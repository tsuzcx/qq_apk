package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f
{
  private static String AZJ = null;
  private static com.tencent.mm.bx.b AZK = null;
  private static String jko = null;
  
  public static Bundle a(Bundle paramBundle, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(79144);
    AZJ = null;
    jko = null;
    AZK = null;
    try
    {
      ctt localctt = new ctt();
      localctt.Eln = paramBundle.getString("PickedWord");
      localctt.Elo = paramBundle.getString("PrefixText");
      localctt.Elp = paramBundle.getString("SuffixText");
      localctt.Scene = paramBundle.getInt("Scene");
      localctt.Elq = paramBundle.getInt("MainIndex", -1);
      localctt.Url = paramString1;
      localctt.Title = paramString2;
      localctt.Elr = paramBundle.getString("SubPickedWord");
      localctt.Els = paramBundle.getString("SubPrefixText");
      localctt.Elt = paramBundle.getString("SubSuffixText");
      localctt.Elu = paramBundle.getInt("SubIndex", -1);
      localctt.Elv = paramBundle.getInt("TagNewLineBefore", -1);
      localctt.Elw = paramBundle.getInt("TagNewLineAfter", -1);
      localctt.Elx = paramBundle.getInt("TagNewLineBeforeSub", -1);
      localctt.Ely = paramBundle.getInt("TagNewLineAfterSub", -1);
      ad.i("MicroMsg.SmartPickWordHelper", "req: PrefixText: %s, PickedWord: %s, SuffixText: %s", new Object[] { localctt.Elo, localctt.Eln, localctt.Elp });
      paramBundle = new b.a();
      paramBundle.gUU = localctt;
      paramBundle.gUV = new ctu();
      paramBundle.uri = "/cgi-bin/mmsearch-bin/searchsmartpickword";
      paramBundle.funcId = 2974;
      paramBundle.reqCmdId = 0;
      paramBundle.respCmdId = 0;
      paramString2 = new CountDownLatch(1);
      paramString1 = new Bundle();
      IPCRunCgi.a(paramBundle.atI(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
        {
          AppMethodBeat.i(79143);
          ad.i("MicroMsg.SmartPickWordHelper", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            this.val$countDownWait.countDown();
            AppMethodBeat.o(79143);
            return;
          }
          paramAnonymousString = (ctu)paramAnonymousb.gUT.gUX;
          paramString1.putString("PickedWord", paramAnonymousString.Eln);
          paramString1.putInt("PrefixOffset", paramAnonymousString.Elz);
          paramString1.putInt("SuffixOffset", paramAnonymousString.ElA);
          paramString1.putString("PrefixText", paramAnonymousString.Elo);
          paramString1.putString("SuffixText", paramAnonymousString.Elp);
          paramString1.putInt("IsMainOrSub", paramAnonymousString.ElB);
          f.es(paramAnonymousString.Eln);
          f.b(paramAnonymousString.ElC);
          f.access$202(paramAnonymousString.DLH);
          ad.i("MicroMsg.SmartPickWordHelper", "response: PrefixText: %s, PickedWord: %s, SuffixText: %s, %d, %d, %d", new Object[] { paramAnonymousString.Elo, paramAnonymousString.Eln, paramAnonymousString.Elp, Integer.valueOf(paramAnonymousString.Elz), Integer.valueOf(paramAnonymousString.ElA), Integer.valueOf(paramAnonymousString.ElB) });
          this.val$countDownWait.countDown();
          AppMethodBeat.o(79143);
        }
      });
      try
      {
        paramString2.await(1000L, TimeUnit.MILLISECONDS);
        ad.i("MicroMsg.SmartPickWordHelper", "smartPickWord end");
        AppMethodBeat.o(79144);
        return paramString1;
      }
      catch (InterruptedException paramBundle)
      {
        for (;;)
        {
          ad.w("MicroMsg.SmartPickWordHelper", paramBundle.getMessage());
          ad.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramBundle, "", new Object[0]);
        }
      }
      return null;
    }
    catch (Exception paramBundle)
    {
      ad.e("MicroMsg.SmartPickWordHelper", "smartPickWord url failed");
      AppMethodBeat.o(79144);
    }
  }
  
  public static void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(79145);
    if (paramBundle == null)
    {
      AppMethodBeat.o(79145);
      return;
    }
    if (jko != null) {
      paramBundle.putString("searchId", jko);
    }
    if (AZK != null) {
      paramBundle.putString("extQueryInfo", AZK.eBA());
    }
    AppMethodBeat.o(79145);
  }
  
  public static boolean ar(Bundle paramBundle)
  {
    AppMethodBeat.i(79146);
    String str1 = paramBundle.getString("query");
    String str2 = paramBundle.getString("searchId");
    String str3 = paramBundle.getString("extQueryInfo");
    if (bt.isNullOrNil(str1))
    {
      AppMethodBeat.o(79146);
      return false;
    }
    long l = e.rob;
    HashMap localHashMap = new HashMap();
    paramBundle = null;
    if (str2 != null)
    {
      paramBundle = "18:" + str2 + ":" + str1 + ":";
      localHashMap.put("parentSearchID", paramBundle);
    }
    if (paramBundle != null) {
      y.arz().E(paramBundle, true).m("extQueryInfo", str3);
    }
    localHashMap.put("clickType", "18");
    ((com.tencent.mm.plugin.websearch.api.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.g.class)).a(aj.getContext(), 17, str1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(79146);
    return false;
  }
  
  public static void axb(String paramString)
  {
    AppMethodBeat.i(79149);
    String str = "";
    try
    {
      paramString = URLEncoder.encode(bt.nullAsNil(paramString), "UTF-8");
      h.vKh.f(13742, new Object[] { Integer.valueOf(4), paramString, "", "", Integer.valueOf(0), jko });
      AppMethodBeat.o(79149);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString, "", new Object[0]);
        paramString = str;
      }
    }
  }
  
  public static void kc(String paramString1, String paramString2)
  {
    int j = 1;
    AppMethodBeat.i(79147);
    if ((!bt.isNullOrNil(AZJ)) && (!bt.kU(paramString1, AZJ))) {}
    for (i = 1;; i = 0)
    {
      localObject = "";
      String str3 = "";
      str2 = "";
      String str1 = str3;
      try
      {
        paramString2 = URLEncoder.encode(bt.nullAsNil(paramString2), "UTF-8");
        str1 = str3;
        localObject = paramString2;
        paramString1 = URLEncoder.encode(bt.nullAsNil(paramString1), "UTF-8");
        str1 = paramString1;
        localObject = paramString2;
        str3 = URLEncoder.encode(bt.nullAsNil(AZJ), "UTF-8");
        localObject = str3;
        str1 = paramString1;
        paramString1 = (String)localObject;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString1, "", new Object[0]);
          paramString1 = str2;
          paramString2 = (String)localObject;
          continue;
          i = 0;
        }
      }
      localObject = h.vKh;
      if (i == 0) {
        break;
      }
      i = j;
      ((h)localObject).f(13742, new Object[] { Integer.valueOf(2), paramString2, paramString1, str1, Integer.valueOf(i), jko });
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
        paramString = URLEncoder.encode(bt.nullAsNil(paramString), "UTF-8");
        paramBundle = h.vKh;
        if (bool)
        {
          i = 3;
          if (!bool) {
            break label128;
          }
          paramBundle.f(13742, new Object[] { Integer.valueOf(i), paramString, "", "", Integer.valueOf(j), jko });
          AppMethodBeat.o(79148);
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString, "", new Object[0]);
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