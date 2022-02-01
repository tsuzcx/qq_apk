package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f
{
  private static String EnA = null;
  private static com.tencent.mm.bw.b EnB = null;
  private static String kid = null;
  
  public static Bundle a(Bundle paramBundle, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(79144);
    EnA = null;
    kid = null;
    EnB = null;
    try
    {
      dfm localdfm = new dfm();
      localdfm.HMx = paramBundle.getString("PickedWord");
      localdfm.HMy = paramBundle.getString("PrefixText");
      localdfm.HMz = paramBundle.getString("SuffixText");
      localdfm.Scene = paramBundle.getInt("Scene");
      localdfm.HMA = paramBundle.getInt("MainIndex", -1);
      localdfm.Url = paramString1;
      localdfm.Title = paramString2;
      localdfm.HMB = paramBundle.getString("SubPickedWord");
      localdfm.HMC = paramBundle.getString("SubPrefixText");
      localdfm.HMD = paramBundle.getString("SubSuffixText");
      localdfm.HME = paramBundle.getInt("SubIndex", -1);
      localdfm.HMF = paramBundle.getInt("TagNewLineBefore", -1);
      localdfm.HMG = paramBundle.getInt("TagNewLineAfter", -1);
      localdfm.HMH = paramBundle.getInt("TagNewLineBeforeSub", -1);
      localdfm.HMI = paramBundle.getInt("TagNewLineAfterSub", -1);
      ae.i("MicroMsg.SmartPickWordHelper", "req: PrefixText: %s, PickedWord: %s, SuffixText: %s", new Object[] { localdfm.HMy, localdfm.HMx, localdfm.HMz });
      paramBundle = new b.a();
      paramBundle.hQF = localdfm;
      paramBundle.hQG = new dfn();
      paramBundle.uri = "/cgi-bin/mmsearch-bin/searchsmartpickword";
      paramBundle.funcId = 2974;
      paramBundle.hQH = 0;
      paramBundle.respCmdId = 0;
      paramString2 = new CountDownLatch(1);
      paramString1 = new Bundle();
      IPCRunCgi.a(paramBundle.aDS(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(79143);
          ae.i("MicroMsg.SmartPickWordHelper", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            this.val$countDownWait.countDown();
            AppMethodBeat.o(79143);
            return;
          }
          paramAnonymousString = (dfn)paramAnonymousb.hQE.hQJ;
          paramString1.putString("PickedWord", paramAnonymousString.HMx);
          paramString1.putInt("PrefixOffset", paramAnonymousString.HMJ);
          paramString1.putInt("SuffixOffset", paramAnonymousString.HMK);
          paramString1.putString("PrefixText", paramAnonymousString.HMy);
          paramString1.putString("SuffixText", paramAnonymousString.HMz);
          paramString1.putInt("IsMainOrSub", paramAnonymousString.HML);
          f.fh(paramAnonymousString.HMx);
          f.c(paramAnonymousString.HMM);
          f.access$202(paramAnonymousString.HkY);
          ae.i("MicroMsg.SmartPickWordHelper", "response: PrefixText: %s, PickedWord: %s, SuffixText: %s, %d, %d, %d", new Object[] { paramAnonymousString.HMy, paramAnonymousString.HMx, paramAnonymousString.HMz, Integer.valueOf(paramAnonymousString.HMJ), Integer.valueOf(paramAnonymousString.HMK), Integer.valueOf(paramAnonymousString.HML) });
          this.val$countDownWait.countDown();
          AppMethodBeat.o(79143);
        }
      });
      try
      {
        paramString2.await(1000L, TimeUnit.MILLISECONDS);
        ae.i("MicroMsg.SmartPickWordHelper", "smartPickWord end");
        AppMethodBeat.o(79144);
        return paramString1;
      }
      catch (InterruptedException paramBundle)
      {
        for (;;)
        {
          ae.w("MicroMsg.SmartPickWordHelper", paramBundle.getMessage());
          ae.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramBundle, "", new Object[0]);
        }
      }
      return null;
    }
    catch (Exception paramBundle)
    {
      ae.e("MicroMsg.SmartPickWordHelper", "smartPickWord url failed");
      AppMethodBeat.o(79144);
    }
  }
  
  public static void aD(Bundle paramBundle)
  {
    AppMethodBeat.i(79145);
    if (paramBundle == null)
    {
      AppMethodBeat.o(79145);
      return;
    }
    if (kid != null) {
      paramBundle.putString("searchId", kid);
    }
    if (EnB != null) {
      paramBundle.putString("extQueryInfo", EnB.fjO());
    }
    AppMethodBeat.o(79145);
  }
  
  public static boolean aE(Bundle paramBundle)
  {
    AppMethodBeat.i(79146);
    String str1 = paramBundle.getString("query");
    String str2 = paramBundle.getString("searchId");
    String str3 = paramBundle.getString("extQueryInfo");
    if (bu.isNullOrNil(str1))
    {
      AppMethodBeat.o(79146);
      return false;
    }
    long l = e.tEn;
    HashMap localHashMap = new HashMap();
    paramBundle = null;
    if (str2 != null)
    {
      paramBundle = "18:" + str2 + ":" + str1 + ":";
      localHashMap.put("parentSearchID", paramBundle);
    }
    if (paramBundle != null) {
      z.aBG().F(paramBundle, true).k("extQueryInfo", str3);
    }
    localHashMap.put("clickType", "18");
    ((h)com.tencent.mm.kernel.g.ab(h.class)).a(ak.getContext(), 17, str1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(79146);
    return false;
  }
  
  public static void aJm(String paramString)
  {
    AppMethodBeat.i(79149);
    String str = "";
    try
    {
      paramString = URLEncoder.encode(bu.nullAsNil(paramString), "UTF-8");
      com.tencent.mm.plugin.report.service.g.yxI.f(13742, new Object[] { Integer.valueOf(4), paramString, "", "", Integer.valueOf(0), kid });
      AppMethodBeat.o(79149);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString, "", new Object[0]);
        paramString = str;
      }
    }
  }
  
  public static void ld(String paramString1, String paramString2)
  {
    int j = 1;
    AppMethodBeat.i(79147);
    if ((!bu.isNullOrNil(EnA)) && (!bu.lX(paramString1, EnA))) {}
    for (i = 1;; i = 0)
    {
      localObject = "";
      String str3 = "";
      str2 = "";
      String str1 = str3;
      try
      {
        paramString2 = URLEncoder.encode(bu.nullAsNil(paramString2), "UTF-8");
        str1 = str3;
        localObject = paramString2;
        paramString1 = URLEncoder.encode(bu.nullAsNil(paramString1), "UTF-8");
        str1 = paramString1;
        localObject = paramString2;
        str3 = URLEncoder.encode(bu.nullAsNil(EnA), "UTF-8");
        localObject = str3;
        str1 = paramString1;
        paramString1 = (String)localObject;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString1, "", new Object[0]);
          paramString1 = str2;
          paramString2 = (String)localObject;
          continue;
          i = 0;
        }
      }
      localObject = com.tencent.mm.plugin.report.service.g.yxI;
      if (i == 0) {
        break;
      }
      i = j;
      ((com.tencent.mm.plugin.report.service.g)localObject).f(13742, new Object[] { Integer.valueOf(2), paramString2, paramString1, str1, Integer.valueOf(i), kid });
      AppMethodBeat.o(79147);
      return;
    }
  }
  
  public static void r(String paramString, Bundle paramBundle)
  {
    int j = 1;
    AppMethodBeat.i(79148);
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("IsCursorMove", false);; bool = false)
    {
      paramBundle = "";
      try
      {
        paramString = URLEncoder.encode(bu.nullAsNil(paramString), "UTF-8");
        paramBundle = com.tencent.mm.plugin.report.service.g.yxI;
        if (bool)
        {
          i = 3;
          if (!bool) {
            break label128;
          }
          paramBundle.f(13742, new Object[] { Integer.valueOf(i), paramString, "", "", Integer.valueOf(j), kid });
          AppMethodBeat.o(79148);
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString, "", new Object[0]);
          paramString = paramBundle;
          continue;
          int i = 1;
          continue;
          label128:
          j = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.f
 * JD-Core Version:    0.7.0.1
 */