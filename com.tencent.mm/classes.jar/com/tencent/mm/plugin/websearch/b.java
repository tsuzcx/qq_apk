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
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.aj;

public final class b
  implements i
{
  private static String DSJ = "websearch_";
  private static String DSK;
  private static String DSL;
  private Runnable DSH;
  private Runnable DSI;
  
  private static void by(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116547);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", true);
    localIntent.putExtra("rawUrl", paramString);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(116547);
  }
  
  private static SharedPreferences ePm()
  {
    AppMethodBeat.i(116539);
    init();
    ae.i("WebSearchPrivacyMgr", " sp name %s ", new Object[] { DSJ });
    SharedPreferences localSharedPreferences = ax.r(ak.getContext(), DSJ, 0);
    AppMethodBeat.o(116539);
    return localSharedPreferences;
  }
  
  public static void ePn()
  {
    AppMethodBeat.i(116541);
    ae.i("WebSearchPrivacyMgr", "reInit");
    Object localObject1 = new StringBuilder("websearch_");
    g.ajP();
    DSJ = com.tencent.mm.kernel.a.aiF();
    Object localObject2 = g.ajR().ajA().get(274436, "");
    localObject1 = "en";
    if (localObject2 != null) {
      localObject1 = localObject2.toString();
    }
    DSK = String.format("https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { ad.fom(), localObject1 });
    DSL = String.format("https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/close&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { ad.fom(), localObject1 });
    AppMethodBeat.o(116541);
  }
  
  public static void init()
  {
    AppMethodBeat.i(116540);
    if (DSK == null) {
      ePn();
    }
    AppMethodBeat.o(116540);
  }
  
  public final void a(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(116545);
    init();
    if ((!ePq()) && (com.tencent.mm.aw.b.Gw((String)g.ajR().ajA().get(274436, null))))
    {
      this.DSH = paramRunnable;
      by(paramContext, DSK);
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
    if (com.tencent.mm.aw.b.Gw((String)g.ajR().ajA().get(274436, null)))
    {
      this.DSI = paramRunnable;
      by(paramContext, DSL);
      AppMethodBeat.o(116546);
      return true;
    }
    paramRunnable.run();
    AppMethodBeat.o(116546);
    return false;
  }
  
  public final void ePo()
  {
    AppMethodBeat.i(116542);
    ae.i("WebSearchPrivacyMgr", "openSearch ");
    init();
    if (this.DSH != null)
    {
      this.DSH.run();
      if (this.DSH == this.DSH) {
        this.DSH = null;
      }
    }
    ePm().edit().putBoolean("websearch_confirmed", true).commit();
    cys localcys = new cys();
    localcys.HIO = 1;
    localcys.Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    localcys.gvx = 1;
    b.a locala = new b.a();
    locala.hQF = localcys;
    locala.hQG = new cyt();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    x.a(locala.aDS(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, com.tencent.mm.ak.n paramAnonymousn)
      {
        return 0;
      }
    });
    AppMethodBeat.o(116542);
  }
  
  public final void ePp()
  {
    AppMethodBeat.i(116543);
    ae.i("WebSearchPrivacyMgr", "closeSearch ");
    init();
    if (this.DSI != null)
    {
      this.DSI.run();
      if (this.DSI == this.DSI) {
        this.DSI = null;
      }
    }
    ePm().edit().putBoolean("websearch_confirmed", false).commit();
    Object localObject = new cys();
    ((cys)localObject).HIO = 1;
    ((cys)localObject).Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    ((cys)localObject).gvx = 2;
    b.a locala = new b.a();
    locala.hQF = ((com.tencent.mm.bw.a)localObject);
    locala.hQG = new cyt();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    x.a(locala.aDS(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, com.tencent.mm.ak.n paramAnonymousn)
      {
        return 0;
      }
    });
    ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).deleteSOSHistory();
    if (ah.DUb != null) {
      ah.DUb = null;
    }
    localObject = ah.boE();
    ak.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove((String)localObject).commit();
    AppMethodBeat.o(116543);
  }
  
  public final boolean ePq()
  {
    AppMethodBeat.i(116544);
    boolean bool = ePm().getBoolean("websearch_confirmed", false);
    AppMethodBeat.o(116544);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b
 * JD-Core Version:    0.7.0.1
 */