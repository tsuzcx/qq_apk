package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f
{
  private static String CrW = null;
  private static com.tencent.mm.bw.b CrX = null;
  private static String jKB = null;
  
  public static Bundle a(Bundle paramBundle, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(79144);
    CrW = null;
    jKB = null;
    CrX = null;
    try
    {
      czf localczf = new czf();
      localczf.FIm = paramBundle.getString("PickedWord");
      localczf.FIn = paramBundle.getString("PrefixText");
      localczf.FIo = paramBundle.getString("SuffixText");
      localczf.Scene = paramBundle.getInt("Scene");
      localczf.FIp = paramBundle.getInt("MainIndex", -1);
      localczf.Url = paramString1;
      localczf.Title = paramString2;
      localczf.FIq = paramBundle.getString("SubPickedWord");
      localczf.FIr = paramBundle.getString("SubPrefixText");
      localczf.FIs = paramBundle.getString("SubSuffixText");
      localczf.FIt = paramBundle.getInt("SubIndex", -1);
      localczf.FIu = paramBundle.getInt("TagNewLineBefore", -1);
      localczf.FIv = paramBundle.getInt("TagNewLineAfter", -1);
      localczf.FIw = paramBundle.getInt("TagNewLineBeforeSub", -1);
      localczf.FIx = paramBundle.getInt("TagNewLineAfterSub", -1);
      ac.i("MicroMsg.SmartPickWordHelper", "req: PrefixText: %s, PickedWord: %s, SuffixText: %s", new Object[] { localczf.FIn, localczf.FIm, localczf.FIo });
      paramBundle = new b.a();
      paramBundle.hvt = localczf;
      paramBundle.hvu = new czg();
      paramBundle.uri = "/cgi-bin/mmsearch-bin/searchsmartpickword";
      paramBundle.funcId = 2974;
      paramBundle.reqCmdId = 0;
      paramBundle.respCmdId = 0;
      paramString2 = new CountDownLatch(1);
      paramString1 = new Bundle();
      IPCRunCgi.a(paramBundle.aAz(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(79143);
          ac.i("MicroMsg.SmartPickWordHelper", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            this.val$countDownWait.countDown();
            AppMethodBeat.o(79143);
            return;
          }
          paramAnonymousString = (czg)paramAnonymousb.hvs.hvw;
          paramString1.putString("PickedWord", paramAnonymousString.FIm);
          paramString1.putInt("PrefixOffset", paramAnonymousString.FIy);
          paramString1.putInt("SuffixOffset", paramAnonymousString.FIz);
          paramString1.putString("PrefixText", paramAnonymousString.FIn);
          paramString1.putString("SuffixText", paramAnonymousString.FIo);
          paramString1.putInt("IsMainOrSub", paramAnonymousString.FIA);
          f.eh(paramAnonymousString.FIm);
          f.b(paramAnonymousString.FIB);
          f.access$202(paramAnonymousString.FhW);
          ac.i("MicroMsg.SmartPickWordHelper", "response: PrefixText: %s, PickedWord: %s, SuffixText: %s, %d, %d, %d", new Object[] { paramAnonymousString.FIn, paramAnonymousString.FIm, paramAnonymousString.FIo, Integer.valueOf(paramAnonymousString.FIy), Integer.valueOf(paramAnonymousString.FIz), Integer.valueOf(paramAnonymousString.FIA) });
          this.val$countDownWait.countDown();
          AppMethodBeat.o(79143);
        }
      });
      try
      {
        paramString2.await(1000L, TimeUnit.MILLISECONDS);
        ac.i("MicroMsg.SmartPickWordHelper", "smartPickWord end");
        AppMethodBeat.o(79144);
        return paramString1;
      }
      catch (InterruptedException paramBundle)
      {
        for (;;)
        {
          ac.w("MicroMsg.SmartPickWordHelper", paramBundle.getMessage());
          ac.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramBundle, "", new Object[0]);
        }
      }
      return null;
    }
    catch (Exception paramBundle)
    {
      ac.e("MicroMsg.SmartPickWordHelper", "smartPickWord url failed");
      AppMethodBeat.o(79144);
    }
  }
  
  public static void aCt(String paramString)
  {
    AppMethodBeat.i(79149);
    String str = "";
    try
    {
      paramString = URLEncoder.encode(bs.nullAsNil(paramString), "UTF-8");
      h.wUl.f(13742, new Object[] { Integer.valueOf(4), paramString, "", "", Integer.valueOf(0), jKB });
      AppMethodBeat.o(79149);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString, "", new Object[0]);
        paramString = str;
      }
    }
  }
  
  public static void av(Bundle paramBundle)
  {
    AppMethodBeat.i(79145);
    if (paramBundle == null)
    {
      AppMethodBeat.o(79145);
      return;
    }
    if (jKB != null) {
      paramBundle.putString("searchId", jKB);
    }
    if (CrX != null) {
      paramBundle.putString("extQueryInfo", CrX.eQU());
    }
    AppMethodBeat.o(79145);
  }
  
  public static boolean aw(Bundle paramBundle)
  {
    AppMethodBeat.i(79146);
    String str1 = paramBundle.getString("query");
    String str2 = paramBundle.getString("searchId");
    String str3 = paramBundle.getString("extQueryInfo");
    if (bs.isNullOrNil(str1))
    {
      AppMethodBeat.o(79146);
      return false;
    }
    long l = e.swV;
    HashMap localHashMap = new HashMap();
    paramBundle = null;
    if (str2 != null)
    {
      paramBundle = "18:" + str2 + ":" + str1 + ":";
      localHashMap.put("parentSearchID", paramBundle);
    }
    if (paramBundle != null) {
      y.ayq().F(paramBundle, true).l("extQueryInfo", str3);
    }
    localHashMap.put("clickType", "18");
    ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(ai.getContext(), 17, str1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(79146);
    return false;
  }
  
  public static void ky(String paramString1, String paramString2)
  {
    int j = 1;
    AppMethodBeat.i(79147);
    if ((!bs.isNullOrNil(CrW)) && (!bs.lr(paramString1, CrW))) {}
    for (i = 1;; i = 0)
    {
      localObject = "";
      String str3 = "";
      str2 = "";
      String str1 = str3;
      try
      {
        paramString2 = URLEncoder.encode(bs.nullAsNil(paramString2), "UTF-8");
        str1 = str3;
        localObject = paramString2;
        paramString1 = URLEncoder.encode(bs.nullAsNil(paramString1), "UTF-8");
        str1 = paramString1;
        localObject = paramString2;
        str3 = URLEncoder.encode(bs.nullAsNil(CrW), "UTF-8");
        localObject = str3;
        str1 = paramString1;
        paramString1 = (String)localObject;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString1, "", new Object[0]);
          paramString1 = str2;
          paramString2 = (String)localObject;
          continue;
          i = 0;
        }
      }
      localObject = h.wUl;
      if (i == 0) {
        break;
      }
      i = j;
      ((h)localObject).f(13742, new Object[] { Integer.valueOf(2), paramString2, paramString1, str1, Integer.valueOf(i), jKB });
      AppMethodBeat.o(79147);
      return;
    }
  }
  
  public static void p(String paramString, Bundle paramBundle)
  {
    int j = 1;
    AppMethodBeat.i(79148);
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("IsCursorMove", false);; bool = false)
    {
      paramBundle = "";
      try
      {
        paramString = URLEncoder.encode(bs.nullAsNil(paramString), "UTF-8");
        paramBundle = h.wUl;
        if (bool)
        {
          i = 3;
          if (!bool) {
            break label127;
          }
          paramBundle.f(13742, new Object[] { Integer.valueOf(i), paramString, "", "", Integer.valueOf(j), jKB });
          AppMethodBeat.o(79148);
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString, "", new Object[0]);
          paramString = paramBundle;
          continue;
          int i = 1;
          continue;
          label127:
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