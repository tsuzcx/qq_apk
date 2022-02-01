package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.storage.ae;

public final class b
  implements h
{
  private static String BXU = "websearch_";
  private static String BXV;
  private static String BXW;
  private Runnable BXS;
  private Runnable BXT;
  
  private static void bt(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116547);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", true);
    localIntent.putExtra("rawUrl", paramString);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(116547);
  }
  
  private static SharedPreferences ewP()
  {
    AppMethodBeat.i(116539);
    init();
    ac.i("WebSearchPrivacyMgr", " sp name %s ", new Object[] { BXU });
    SharedPreferences localSharedPreferences = av.s(ai.getContext(), BXU, 0);
    AppMethodBeat.o(116539);
    return localSharedPreferences;
  }
  
  public static void ewQ()
  {
    AppMethodBeat.i(116541);
    ac.i("WebSearchPrivacyMgr", "reInit");
    Object localObject1 = new StringBuilder("websearch_");
    g.agP();
    BXU = com.tencent.mm.kernel.a.afE();
    Object localObject2 = g.agR().agA().get(274436, "");
    localObject1 = "en";
    if (localObject2 != null) {
      localObject1 = localObject2.toString();
    }
    BXV = String.format("https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { ab.eUO(), localObject1 });
    BXW = String.format("https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/close&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { ab.eUO(), localObject1 });
    AppMethodBeat.o(116541);
  }
  
  public static void init()
  {
    AppMethodBeat.i(116540);
    if (BXV == null) {
      ewQ();
    }
    AppMethodBeat.o(116540);
  }
  
  public final void a(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(116545);
    init();
    if ((!ewT()) && (com.tencent.mm.aw.b.CQ((String)g.agR().agA().get(274436, null))))
    {
      this.BXS = paramRunnable;
      bt(paramContext, BXV);
      AppMethodBeat.o(116545);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(116545);
  }
  
  public final boolean b(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(116546);
    init();
    if (com.tencent.mm.aw.b.CQ((String)g.agR().agA().get(274436, null)))
    {
      this.BXT = paramRunnable;
      bt(paramContext, BXW);
      AppMethodBeat.o(116546);
      return true;
    }
    paramRunnable.run();
    AppMethodBeat.o(116546);
    return false;
  }
  
  public final void ewR()
  {
    AppMethodBeat.i(116542);
    ac.i("WebSearchPrivacyMgr", "openSearch ");
    init();
    if (this.BXS != null)
    {
      this.BXS.run();
      if (this.BXS == this.BXS) {
        this.BXS = null;
      }
    }
    ewP().edit().putBoolean("websearch_confirmed", true).commit();
    cso localcso = new cso();
    localcso.FEN = 1;
    localcso.Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    localcso.fZz = 1;
    b.a locala = new b.a();
    locala.hvt = localcso;
    locala.hvu = new csp();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    x.a(locala.aAz(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, com.tencent.mm.ak.n paramAnonymousn)
      {
        return 0;
      }
    });
    AppMethodBeat.o(116542);
  }
  
  public final void ewS()
  {
    AppMethodBeat.i(116543);
    ac.i("WebSearchPrivacyMgr", "closeSearch ");
    init();
    if (this.BXT != null)
    {
      this.BXT.run();
      if (this.BXT == this.BXT) {
        this.BXT = null;
      }
    }
    ewP().edit().putBoolean("websearch_confirmed", false).commit();
    Object localObject = new cso();
    ((cso)localObject).FEN = 1;
    ((cso)localObject).Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    ((cso)localObject).fZz = 2;
    b.a locala = new b.a();
    locala.hvt = ((com.tencent.mm.bw.a)localObject);
    locala.hvu = new csp();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    x.a(locala.aAz(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, com.tencent.mm.ak.n paramAnonymousn)
      {
        return 0;
      }
    });
    ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).deleteSOSHistory();
    if (ad.BZi != null) {
      ad.BZi = null;
    }
    localObject = ad.bkj();
    ai.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove((String)localObject).commit();
    AppMethodBeat.o(116543);
  }
  
  public final boolean ewT()
  {
    AppMethodBeat.i(116544);
    boolean bool = ewP().getBoolean("websearch_confirmed", false);
    AppMethodBeat.o(116544);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b
 * JD-Core Version:    0.7.0.1
 */