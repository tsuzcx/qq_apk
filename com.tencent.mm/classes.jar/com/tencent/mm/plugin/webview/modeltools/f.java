package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.protocal.protobuf.fda;
import com.tencent.mm.protocal.protobuf.fdb;
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
  private static String WNA = null;
  private static b WNB = null;
  private static String mpa = null;
  
  public static Bundle b(Bundle paramBundle, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(79144);
    WNA = null;
    mpa = null;
    WNB = null;
    try
    {
      fda localfda = new fda();
      localfda.abCq = paramBundle.getString("PickedWord");
      localfda.abCr = paramBundle.getString("PrefixText");
      localfda.abCs = paramBundle.getString("SuffixText");
      localfda.IJG = paramBundle.getInt("Scene");
      localfda.abCt = paramBundle.getInt("MainIndex", -1);
      localfda.Url = paramString1;
      localfda.hAP = paramString2;
      localfda.abCu = paramBundle.getString("SubPickedWord");
      localfda.abCv = paramBundle.getString("SubPrefixText");
      localfda.abCw = paramBundle.getString("SubSuffixText");
      localfda.abCx = paramBundle.getInt("SubIndex", -1);
      localfda.abCy = paramBundle.getInt("TagNewLineBefore", -1);
      localfda.abCz = paramBundle.getInt("TagNewLineAfter", -1);
      localfda.abCA = paramBundle.getInt("TagNewLineBeforeSub", -1);
      localfda.abCB = paramBundle.getInt("TagNewLineAfterSub", -1);
      Log.i("MicroMsg.SmartPickWordHelper", "req: PrefixText: %s, PickedWord: %s, SuffixText: %s", new Object[] { localfda.abCr, localfda.abCq, localfda.abCs });
      paramBundle = new c.a();
      paramBundle.otE = localfda;
      paramBundle.otF = new fdb();
      paramBundle.uri = "/cgi-bin/mmsearch-bin/searchsmartpickword";
      paramBundle.funcId = 2974;
      paramBundle.otG = 0;
      paramBundle.respCmdId = 0;
      paramString2 = new CountDownLatch(1);
      paramString1 = new Bundle();
      IPCRunCgi.a(paramBundle.bEF(), new IPCRunCgi.a()
      {
        public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc)
        {
          AppMethodBeat.i(79143);
          Log.i("MicroMsg.SmartPickWordHelper", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            f.this.countDown();
            AppMethodBeat.o(79143);
            return;
          }
          paramAnonymousString = (fdb)c.c.b(paramAnonymousc.otC);
          paramString1.putString("PickedWord", paramAnonymousString.abCq);
          paramString1.putInt("PrefixOffset", paramAnonymousString.abCC);
          paramString1.putInt("SuffixOffset", paramAnonymousString.abCD);
          paramString1.putString("PrefixText", paramAnonymousString.abCr);
          paramString1.putString("SuffixText", paramAnonymousString.abCs);
          paramString1.putInt("IsMainOrSub", paramAnonymousString.abCE);
          f.jdMethod_if(paramAnonymousString.abCq);
          f.k(paramAnonymousString.abCF);
          f.bkN(paramAnonymousString.aayf);
          Log.i("MicroMsg.SmartPickWordHelper", "response: PrefixText: %s, PickedWord: %s, SuffixText: %s, %d, %d, %d", new Object[] { paramAnonymousString.abCr, paramAnonymousString.abCq, paramAnonymousString.abCs, Integer.valueOf(paramAnonymousString.abCC), Integer.valueOf(paramAnonymousString.abCD), Integer.valueOf(paramAnonymousString.abCE) });
          f.this.countDown();
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
  
  public static void bp(Bundle paramBundle)
  {
    AppMethodBeat.i(79145);
    if (paramBundle == null)
    {
      AppMethodBeat.o(79145);
      return;
    }
    if (mpa != null) {
      paramBundle.putString("searchId", mpa);
    }
    if (WNB != null) {
      paramBundle.putString("extQueryInfo", WNB.ZV());
    }
    AppMethodBeat.o(79145);
  }
  
  public static boolean bq(Bundle paramBundle)
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
    long l = e.HrM;
    HashMap localHashMap = new HashMap();
    paramBundle = null;
    if (str2 != null)
    {
      paramBundle = "18:" + str2 + ":" + str1 + ":";
      localHashMap.put("parentSearchID", paramBundle);
    }
    if (paramBundle != null) {
      ad.bCb().M(paramBundle, true).q("extQueryInfo", str3);
    }
    localHashMap.put("clickType", "18");
    ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(MMApplicationContext.getContext(), 17, str1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(79146);
    return false;
  }
  
  public static void os(String paramString1, String paramString2)
  {
    int j = 1;
    AppMethodBeat.i(79147);
    if ((!Util.isNullOrNil(WNA)) && (!Util.isEqual(paramString1, WNA))) {}
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
        str3 = URLEncoder.encode(Util.nullAsNil(WNA), "UTF-8");
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
      localObject = com.tencent.mm.plugin.report.service.h.OAn;
      if (i == 0) {
        break;
      }
      i = j;
      ((com.tencent.mm.plugin.report.service.h)localObject).b(13742, new Object[] { Integer.valueOf(2), paramString2, paramString1, str1, Integer.valueOf(i), mpa });
      AppMethodBeat.o(79147);
      return;
    }
  }
  
  public static void w(String paramString, Bundle paramBundle)
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
        paramBundle = com.tencent.mm.plugin.report.service.h.OAn;
        if (bool)
        {
          i = 3;
          if (!bool) {
            break label128;
          }
          paramBundle.b(13742, new Object[] { Integer.valueOf(i), paramString, "", "", Integer.valueOf(j), mpa });
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
          label128:
          j = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.f
 * JD-Core Version:    0.7.0.1
 */