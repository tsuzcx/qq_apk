package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.bxd;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.z;

public final class b
  implements com.tencent.mm.plugin.websearch.api.m
{
  private static String uIu = "websearch_";
  private static String uIv;
  private static String uIw;
  private Runnable uIs;
  private Runnable uIt;
  
  private static void bf(Context paramContext, String paramString)
  {
    AppMethodBeat.i(91350);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", true);
    localIntent.putExtra("rawUrl", paramString);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(91350);
  }
  
  private static SharedPreferences cYT()
  {
    AppMethodBeat.i(91343);
    init();
    ab.i("WebSearchPrivacyMgr", " sp name %s ", new Object[] { uIu });
    SharedPreferences localSharedPreferences = ar.r(ah.getContext(), uIu, 0);
    AppMethodBeat.o(91343);
    return localSharedPreferences;
  }
  
  public static void cYU()
  {
    AppMethodBeat.i(91345);
    ab.i("WebSearchPrivacyMgr", "reInit");
    Object localObject1 = new StringBuilder("websearch_");
    g.RJ();
    uIu = com.tencent.mm.kernel.a.QC();
    Object localObject2 = g.RL().Ru().get(274436, "");
    localObject1 = "en";
    if (localObject2 != null) {
      localObject1 = localObject2.toString();
    }
    uIv = ah.getContext().getString(2131306199, new Object[] { aa.dsG(), localObject1 });
    uIw = ah.getContext().getString(2131306138, new Object[] { aa.dsG(), localObject1 });
    AppMethodBeat.o(91345);
  }
  
  public static void init()
  {
    AppMethodBeat.i(91344);
    if (uIv == null) {
      cYU();
    }
    AppMethodBeat.o(91344);
  }
  
  public final void a(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(91348);
    init();
    if ((!cYX()) && (com.tencent.mm.au.b.tM((String)g.RL().Ru().get(274436, null))))
    {
      this.uIs = paramRunnable;
      bf(paramContext, uIv);
      AppMethodBeat.o(91348);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(91348);
  }
  
  public final boolean b(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(91349);
    init();
    if (com.tencent.mm.au.b.tM((String)g.RL().Ru().get(274436, null)))
    {
      this.uIt = paramRunnable;
      bf(paramContext, uIw);
      AppMethodBeat.o(91349);
      return true;
    }
    paramRunnable.run();
    AppMethodBeat.o(91349);
    return false;
  }
  
  public final void cYV()
  {
    AppMethodBeat.i(91346);
    ab.i("WebSearchPrivacyMgr", "openSearch ");
    init();
    if (this.uIs != null)
    {
      this.uIs.run();
      if (this.uIs == this.uIs) {
        this.uIs = null;
      }
    }
    cYT().edit().putBoolean("websearch_confirmed", true).commit();
    bxd localbxd = new bxd();
    localbxd.xKe = 1;
    localbxd.Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    localbxd.nrS = 1;
    b.a locala = new b.a();
    locala.fsX = localbxd;
    locala.fsY = new bxe();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    w.a(locala.ado(), new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.b paramAnonymousb, com.tencent.mm.ai.m paramAnonymousm)
      {
        return 0;
      }
    });
    AppMethodBeat.o(91346);
  }
  
  public final void cYW()
  {
    AppMethodBeat.i(91347);
    ab.i("WebSearchPrivacyMgr", "closeSearch ");
    init();
    if (this.uIt != null)
    {
      this.uIt.run();
      if (this.uIt == this.uIt) {
        this.uIt = null;
      }
    }
    cYT().edit().putBoolean("websearch_confirmed", false).commit();
    Object localObject = new bxd();
    ((bxd)localObject).xKe = 1;
    ((bxd)localObject).Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    ((bxd)localObject).nrS = 2;
    b.a locala = new b.a();
    locala.fsX = ((com.tencent.mm.bv.a)localObject);
    locala.fsY = new bxe();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    w.a(locala.ado(), new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.b paramAnonymousb, com.tencent.mm.ai.m paramAnonymousm)
      {
        return 0;
      }
    });
    ((n)g.G(n.class)).deleteSOSHistory();
    if (ai.uJI != null) {
      ai.uJI = null;
    }
    localObject = ai.cZx();
    ah.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove((String)localObject).commit();
    AppMethodBeat.o(91347);
  }
  
  public final boolean cYX()
  {
    AppMethodBeat.i(146047);
    boolean bool = cYT().getBoolean("websearch_confirmed", false);
    AppMethodBeat.o(146047);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b
 * JD-Core Version:    0.7.0.1
 */