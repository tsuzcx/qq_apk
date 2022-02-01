package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.protocal.protobuf.dyt;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f
{
  private static String JaE = null;
  private static b JaF = null;
  private static String hes = null;
  
  public static void aP(Bundle paramBundle)
  {
    AppMethodBeat.i(79145);
    if (paramBundle == null)
    {
      AppMethodBeat.o(79145);
      return;
    }
    if (hes != null) {
      paramBundle.putString("searchId", hes);
    }
    if (JaF != null) {
      paramBundle.putString("extQueryInfo", JaF.yO());
    }
    AppMethodBeat.o(79145);
  }
  
  public static boolean aQ(Bundle paramBundle)
  {
    AppMethodBeat.i(79146);
    String str1 = paramBundle.getString("query");
    String str2 = paramBundle.getString("searchId");
    String str3 = paramBundle.getString("extQueryInfo");
    if (Util.isNullOrNil(str1))
    {
      AppMethodBeat.o(79146);
      return false;
    }
    long l = e.wVm;
    HashMap localHashMap = new HashMap();
    paramBundle = null;
    if (str2 != null)
    {
      paramBundle = "18:" + str2 + ":" + str1 + ":";
      localHashMap.put("parentSearchID", paramBundle);
    }
    if (paramBundle != null) {
      ad.aVe().G(paramBundle, true).l("extQueryInfo", str3);
    }
    localHashMap.put("clickType", "18");
    ((com.tencent.mm.plugin.websearch.api.h)g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(MMApplicationContext.getContext(), 17, str1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(79146);
    return false;
  }
  
  public static void aZr(String paramString)
  {
    AppMethodBeat.i(79149);
    String str = "";
    try
    {
      paramString = URLEncoder.encode(Util.nullAsNil(paramString), "UTF-8");
      com.tencent.mm.plugin.report.service.h.CyF.a(13742, new Object[] { Integer.valueOf(4), paramString, "", "", Integer.valueOf(0), hes });
      AppMethodBeat.o(79149);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString, "", new Object[0]);
        paramString = str;
      }
    }
  }
  
  public static Bundle b(Bundle paramBundle, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(79144);
    JaE = null;
    hes = null;
    JaF = null;
    try
    {
      dyt localdyt = new dyt();
      localdyt.MYh = paramBundle.getString("PickedWord");
      localdyt.MYi = paramBundle.getString("PrefixText");
      localdyt.MYj = paramBundle.getString("SuffixText");
      localdyt.Scene = paramBundle.getInt("Scene");
      localdyt.MYk = paramBundle.getInt("MainIndex", -1);
      localdyt.Url = paramString1;
      localdyt.Title = paramString2;
      localdyt.MYl = paramBundle.getString("SubPickedWord");
      localdyt.MYm = paramBundle.getString("SubPrefixText");
      localdyt.MYn = paramBundle.getString("SubSuffixText");
      localdyt.MYo = paramBundle.getInt("SubIndex", -1);
      localdyt.MYp = paramBundle.getInt("TagNewLineBefore", -1);
      localdyt.MYq = paramBundle.getInt("TagNewLineAfter", -1);
      localdyt.MYr = paramBundle.getInt("TagNewLineBeforeSub", -1);
      localdyt.MYs = paramBundle.getInt("TagNewLineAfterSub", -1);
      Log.i("MicroMsg.SmartPickWordHelper", "req: PrefixText: %s, PickedWord: %s, SuffixText: %s", new Object[] { localdyt.MYi, localdyt.MYh, localdyt.MYj });
      paramBundle = new d.a();
      paramBundle.iLN = localdyt;
      paramBundle.iLO = new dyu();
      paramBundle.uri = "/cgi-bin/mmsearch-bin/searchsmartpickword";
      paramBundle.funcId = 2974;
      paramBundle.iLP = 0;
      paramBundle.respCmdId = 0;
      paramString2 = new CountDownLatch(1);
      paramString1 = new Bundle();
      IPCRunCgi.a(paramBundle.aXF(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
        {
          AppMethodBeat.i(79143);
          Log.i("MicroMsg.SmartPickWordHelper", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            this.val$countDownWait.countDown();
            AppMethodBeat.o(79143);
            return;
          }
          paramAnonymousString = (dyu)paramAnonymousd.iLL.iLR;
          paramString1.putString("PickedWord", paramAnonymousString.MYh);
          paramString1.putInt("PrefixOffset", paramAnonymousString.MYt);
          paramString1.putInt("SuffixOffset", paramAnonymousString.MYu);
          paramString1.putString("PrefixText", paramAnonymousString.MYi);
          paramString1.putString("SuffixText", paramAnonymousString.MYj);
          paramString1.putInt("IsMainOrSub", paramAnonymousString.MYv);
          f.fU(paramAnonymousString.MYh);
          f.e(paramAnonymousString.MYw);
          f.access$202(paramAnonymousString.Mbb);
          Log.i("MicroMsg.SmartPickWordHelper", "response: PrefixText: %s, PickedWord: %s, SuffixText: %s, %d, %d, %d", new Object[] { paramAnonymousString.MYi, paramAnonymousString.MYh, paramAnonymousString.MYj, Integer.valueOf(paramAnonymousString.MYt), Integer.valueOf(paramAnonymousString.MYu), Integer.valueOf(paramAnonymousString.MYv) });
          this.val$countDownWait.countDown();
          AppMethodBeat.o(79143);
        }
      });
      try
      {
        paramString2.await(1000L, TimeUnit.MILLISECONDS);
        Log.i("MicroMsg.SmartPickWordHelper", "smartPickWord end");
        AppMethodBeat.o(79144);
        return paramString1;
      }
      catch (InterruptedException paramBundle)
      {
        for (;;)
        {
          Log.w("MicroMsg.SmartPickWordHelper", paramBundle.getMessage());
          Log.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramBundle, "", new Object[0]);
        }
      }
      return null;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.SmartPickWordHelper", "smartPickWord url failed");
      AppMethodBeat.o(79144);
    }
  }
  
  public static void mc(String paramString1, String paramString2)
  {
    int j = 1;
    AppMethodBeat.i(79147);
    if ((!Util.isNullOrNil(JaE)) && (!Util.isEqual(paramString1, JaE))) {}
    for (i = 1;; i = 0)
    {
      localObject = "";
      String str3 = "";
      str2 = "";
      String str1 = str3;
      try
      {
        paramString2 = URLEncoder.encode(Util.nullAsNil(paramString2), "UTF-8");
        str1 = str3;
        localObject = paramString2;
        paramString1 = URLEncoder.encode(Util.nullAsNil(paramString1), "UTF-8");
        str1 = paramString1;
        localObject = paramString2;
        str3 = URLEncoder.encode(Util.nullAsNil(JaE), "UTF-8");
        localObject = str3;
        str1 = paramString1;
        paramString1 = (String)localObject;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString1, "", new Object[0]);
          paramString1 = str2;
          paramString2 = (String)localObject;
          continue;
          i = 0;
        }
      }
      localObject = com.tencent.mm.plugin.report.service.h.CyF;
      if (i == 0) {
        break;
      }
      i = j;
      ((com.tencent.mm.plugin.report.service.h)localObject).a(13742, new Object[] { Integer.valueOf(2), paramString2, paramString1, str1, Integer.valueOf(i), hes });
      AppMethodBeat.o(79147);
      return;
    }
  }
  
  public static void q(String paramString, Bundle paramBundle)
  {
    int j = 1;
    AppMethodBeat.i(79148);
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("IsCursorMove", false);; bool = false)
    {
      paramBundle = "";
      try
      {
        paramString = URLEncoder.encode(Util.nullAsNil(paramString), "UTF-8");
        paramBundle = com.tencent.mm.plugin.report.service.h.CyF;
        if (bool)
        {
          i = 3;
          if (!bool) {
            break label127;
          }
          paramBundle.a(13742, new Object[] { Integer.valueOf(i), paramString, "", "", Integer.valueOf(j), hes });
          AppMethodBeat.o(79148);
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString, "", new Object[0]);
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