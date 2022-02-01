package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.cd.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class e
{
  private static String PWW = null;
  private static b PWX = null;
  private static String jQi = null;
  
  public static void aL(Bundle paramBundle)
  {
    AppMethodBeat.i(79145);
    if (paramBundle == null)
    {
      AppMethodBeat.o(79145);
      return;
    }
    if (jQi != null) {
      paramBundle.putString("searchId", jQi);
    }
    if (PWX != null) {
      paramBundle.putString("extQueryInfo", PWX.Ap());
    }
    AppMethodBeat.o(79145);
  }
  
  public static boolean aM(Bundle paramBundle)
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
    long l = com.tencent.mm.plugin.fts.a.e.BHi;
    HashMap localHashMap = new HashMap();
    paramBundle = null;
    if (str2 != null)
    {
      paramBundle = "18:" + str2 + ":" + str1 + ":";
      localHashMap.put("parentSearchID", paramBundle);
    }
    if (paramBundle != null) {
      ad.beh().I(paramBundle, true).k("extQueryInfo", str3);
    }
    localHashMap.put("clickType", "18");
    ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a(MMApplicationContext.getContext(), 17, str1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(79146);
    return false;
  }
  
  public static Bundle b(Bundle paramBundle, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(79144);
    PWW = null;
    jQi = null;
    PWX = null;
    try
    {
      eit localeit = new eit();
      localeit.Ukz = paramBundle.getString("PickedWord");
      localeit.UkA = paramBundle.getString("PrefixText");
      localeit.UkB = paramBundle.getString("SuffixText");
      localeit.CPw = paramBundle.getInt("Scene");
      localeit.UkC = paramBundle.getInt("MainIndex", -1);
      localeit.Url = paramString1;
      localeit.fwr = paramString2;
      localeit.UkD = paramBundle.getString("SubPickedWord");
      localeit.UkE = paramBundle.getString("SubPrefixText");
      localeit.UkF = paramBundle.getString("SubSuffixText");
      localeit.UkG = paramBundle.getInt("SubIndex", -1);
      localeit.UkH = paramBundle.getInt("TagNewLineBefore", -1);
      localeit.UkI = paramBundle.getInt("TagNewLineAfter", -1);
      localeit.UkJ = paramBundle.getInt("TagNewLineBeforeSub", -1);
      localeit.UkK = paramBundle.getInt("TagNewLineAfterSub", -1);
      Log.i("MicroMsg.SmartPickWordHelper", "req: PrefixText: %s, PickedWord: %s, SuffixText: %s", new Object[] { localeit.UkA, localeit.Ukz, localeit.UkB });
      paramBundle = new d.a();
      paramBundle.lBU = localeit;
      paramBundle.lBV = new eiu();
      paramBundle.uri = "/cgi-bin/mmsearch-bin/searchsmartpickword";
      paramBundle.funcId = 2974;
      paramBundle.lBW = 0;
      paramBundle.respCmdId = 0;
      paramString2 = new CountDownLatch(1);
      paramString1 = new Bundle();
      IPCRunCgi.a(paramBundle.bgN(), new IPCRunCgi.a()
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
          paramAnonymousString = (eiu)d.c.b(paramAnonymousd.lBS);
          paramString1.putString("PickedWord", paramAnonymousString.Ukz);
          paramString1.putInt("PrefixOffset", paramAnonymousString.UkL);
          paramString1.putInt("SuffixOffset", paramAnonymousString.UkM);
          paramString1.putString("PrefixText", paramAnonymousString.UkA);
          paramString1.putString("SuffixText", paramAnonymousString.UkB);
          paramString1.putInt("IsMainOrSub", paramAnonymousString.UkN);
          e.gE(paramAnonymousString.Ukz);
          e.f(paramAnonymousString.UkO);
          e.access$202(paramAnonymousString.Tky);
          Log.i("MicroMsg.SmartPickWordHelper", "response: PrefixText: %s, PickedWord: %s, SuffixText: %s, %d, %d, %d", new Object[] { paramAnonymousString.UkA, paramAnonymousString.Ukz, paramAnonymousString.UkB, Integer.valueOf(paramAnonymousString.UkL), Integer.valueOf(paramAnonymousString.UkM), Integer.valueOf(paramAnonymousString.UkN) });
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
  
  public static void mC(String paramString1, String paramString2)
  {
    int j = 1;
    AppMethodBeat.i(79147);
    if ((!Util.isNullOrNil(PWW)) && (!Util.isEqual(paramString1, PWW))) {}
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
        str3 = URLEncoder.encode(Util.nullAsNil(PWW), "UTF-8");
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
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      if (i == 0) {
        break;
      }
      i = j;
      ((com.tencent.mm.plugin.report.service.h)localObject).a(13742, new Object[] { Integer.valueOf(2), paramString2, paramString1, str1, Integer.valueOf(i), jQi });
      AppMethodBeat.o(79147);
      return;
    }
  }
  
  public static void v(String paramString, Bundle paramBundle)
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
        paramBundle = com.tencent.mm.plugin.report.service.h.IzE;
        if (bool)
        {
          i = 3;
          if (!bool) {
            break label132;
          }
          paramBundle.a(13742, new Object[] { Integer.valueOf(i), paramString, "", "", Integer.valueOf(j), jQi });
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
          label132:
          j = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e
 * JD-Core Version:    0.7.0.1
 */