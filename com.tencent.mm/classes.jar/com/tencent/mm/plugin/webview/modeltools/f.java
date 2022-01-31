package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f
{
  private static String hng = null;
  private static String uXC = null;
  private static com.tencent.mm.bv.b uXD = null;
  
  public static Bundle a(Bundle paramBundle, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(6953);
    uXC = null;
    hng = null;
    uXD = null;
    try
    {
      ccy localccy = new ccy();
      localccy.xNn = paramBundle.getString("PickedWord");
      localccy.xNo = paramBundle.getString("PrefixText");
      localccy.xNp = paramBundle.getString("SuffixText");
      localccy.Scene = paramBundle.getInt("Scene");
      localccy.xNq = paramBundle.getInt("MainIndex", -1);
      localccy.Url = paramString1;
      localccy.Title = paramString2;
      localccy.xNr = paramBundle.getString("SubPickedWord");
      localccy.xNs = paramBundle.getString("SubPrefixText");
      localccy.xNt = paramBundle.getString("SubSuffixText");
      localccy.xNu = paramBundle.getInt("SubIndex", -1);
      localccy.xNv = paramBundle.getInt("TagNewLineBefore", -1);
      localccy.xNw = paramBundle.getInt("TagNewLineAfter", -1);
      localccy.xNx = paramBundle.getInt("TagNewLineBeforeSub", -1);
      localccy.xNy = paramBundle.getInt("TagNewLineAfterSub", -1);
      ab.i("MicroMsg.SmartPickWordHelper", "req: PrefixText: %s, PickedWord: %s, SuffixText: %s", new Object[] { localccy.xNo, localccy.xNn, localccy.xNp });
      paramBundle = new com.tencent.mm.ai.b.a();
      paramBundle.fsX = localccy;
      paramBundle.fsY = new ccz();
      paramBundle.uri = "/cgi-bin/mmsearch-bin/searchsmartpickword";
      paramBundle.funcId = 2974;
      paramBundle.reqCmdId = 0;
      paramBundle.respCmdId = 0;
      paramString2 = new CountDownLatch(1);
      paramString1 = new Bundle();
      com.tencent.mm.ipcinvoker.wx_extension.b.a(paramBundle.ado(), new com.tencent.mm.ipcinvoker.wx_extension.b.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.b paramAnonymousb)
        {
          AppMethodBeat.i(6952);
          ab.i("MicroMsg.SmartPickWordHelper", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            this.val$countDownWait.countDown();
            AppMethodBeat.o(6952);
            return;
          }
          paramAnonymousString = (ccz)paramAnonymousb.fsW.fta;
          paramString1.putString("PickedWord", paramAnonymousString.xNn);
          paramString1.putInt("PrefixOffset", paramAnonymousString.xNz);
          paramString1.putInt("SuffixOffset", paramAnonymousString.xNA);
          paramString1.putString("PrefixText", paramAnonymousString.xNo);
          paramString1.putString("SuffixText", paramAnonymousString.xNp);
          paramString1.putInt("IsMainOrSub", paramAnonymousString.xNB);
          f.access$002(paramAnonymousString.xNn);
          f.b(paramAnonymousString.xNC);
          f.access$202(paramAnonymousString.xqX);
          ab.i("MicroMsg.SmartPickWordHelper", "response: PrefixText: %s, PickedWord: %s, SuffixText: %s, %d, %d, %d", new Object[] { paramAnonymousString.xNo, paramAnonymousString.xNn, paramAnonymousString.xNp, Integer.valueOf(paramAnonymousString.xNz), Integer.valueOf(paramAnonymousString.xNA), Integer.valueOf(paramAnonymousString.xNB) });
          this.val$countDownWait.countDown();
          AppMethodBeat.o(6952);
        }
      });
      try
      {
        paramString2.await(1000L, TimeUnit.MILLISECONDS);
        ab.i("MicroMsg.SmartPickWordHelper", "smartPickWord end");
        AppMethodBeat.o(6953);
        return paramString1;
      }
      catch (InterruptedException paramBundle)
      {
        for (;;)
        {
          ab.w("MicroMsg.SmartPickWordHelper", paramBundle.getMessage());
          ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramBundle, "", new Object[0]);
        }
      }
      return null;
    }
    catch (Exception paramBundle)
    {
      ab.e("MicroMsg.SmartPickWordHelper", "smartPickWord url failed");
      AppMethodBeat.o(6953);
    }
  }
  
  public static void ad(Bundle paramBundle)
  {
    AppMethodBeat.i(6954);
    if (paramBundle == null)
    {
      AppMethodBeat.o(6954);
      return;
    }
    if (hng != null) {
      paramBundle.putString("searchId", hng);
    }
    if (uXD != null) {
      paramBundle.putString("extQueryInfo", uXD.dqj());
    }
    AppMethodBeat.o(6954);
  }
  
  public static boolean ae(Bundle paramBundle)
  {
    AppMethodBeat.i(6955);
    String str1 = paramBundle.getString("query");
    String str2 = paramBundle.getString("searchId");
    String str3 = paramBundle.getString("extQueryInfo");
    if (bo.isNullOrNil(str1))
    {
      AppMethodBeat.o(6955);
      return false;
    }
    long l = e.mRk;
    HashMap localHashMap = new HashMap();
    paramBundle = null;
    if (str2 != null)
    {
      paramBundle = "18:" + str2 + ":" + str1 + ":";
      localHashMap.put("parentSearchID", paramBundle);
    }
    if (paramBundle != null) {
      v.aae().z(paramBundle, true).i("extQueryInfo", str3);
    }
    localHashMap.put("clickType", "18");
    ((j)g.E(j.class)).a(ah.getContext(), 17, str1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(6955);
    return false;
  }
  
  public static void ahB(String paramString)
  {
    AppMethodBeat.i(6958);
    String str = "";
    try
    {
      paramString = URLEncoder.encode(bo.nullAsNil(paramString), "UTF-8");
      h.qsU.e(13742, new Object[] { Integer.valueOf(4), paramString, "", "", Integer.valueOf(0), hng });
      AppMethodBeat.o(6958);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString, "", new Object[0]);
        paramString = str;
      }
    }
  }
  
  public static void ht(String paramString1, String paramString2)
  {
    int j = 1;
    AppMethodBeat.i(6956);
    if ((!bo.isNullOrNil(uXC)) && (!bo.isEqual(paramString1, uXC))) {}
    for (i = 1;; i = 0)
    {
      localObject = "";
      String str3 = "";
      str2 = "";
      String str1 = str3;
      try
      {
        paramString2 = URLEncoder.encode(bo.nullAsNil(paramString2), "UTF-8");
        str1 = str3;
        localObject = paramString2;
        paramString1 = URLEncoder.encode(bo.nullAsNil(paramString1), "UTF-8");
        str1 = paramString1;
        localObject = paramString2;
        str3 = URLEncoder.encode(bo.nullAsNil(uXC), "UTF-8");
        localObject = str3;
        str1 = paramString1;
        paramString1 = (String)localObject;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString1, "", new Object[0]);
          paramString1 = str2;
          paramString2 = (String)localObject;
          continue;
          i = 0;
        }
      }
      localObject = h.qsU;
      if (i == 0) {
        break;
      }
      i = j;
      ((h)localObject).e(13742, new Object[] { Integer.valueOf(2), paramString2, paramString1, str1, Integer.valueOf(i), hng });
      AppMethodBeat.o(6956);
      return;
    }
  }
  
  public static void p(String paramString, Bundle paramBundle)
  {
    int j = 1;
    AppMethodBeat.i(6957);
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("IsCursorMove", false);; bool = false)
    {
      paramBundle = "";
      try
      {
        paramString = URLEncoder.encode(bo.nullAsNil(paramString), "UTF-8");
        paramBundle = h.qsU;
        if (bool)
        {
          i = 3;
          if (!bool) {
            break label128;
          }
          paramBundle.e(13742, new Object[] { Integer.valueOf(i), paramString, "", "", Integer.valueOf(j), hng });
          AppMethodBeat.o(6957);
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.f
 * JD-Core Version:    0.7.0.1
 */