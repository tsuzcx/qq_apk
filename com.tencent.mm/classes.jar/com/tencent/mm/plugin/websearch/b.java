package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.storage.ai;

public final class b
  implements i
{
  private static String DAM = "websearch_";
  private static String DAN;
  private static String DAO;
  private Runnable DAK;
  private Runnable DAL;
  
  private static void bx(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116547);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", true);
    localIntent.putExtra("rawUrl", paramString);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(116547);
  }
  
  private static SharedPreferences eLD()
  {
    AppMethodBeat.i(116539);
    init();
    ad.i("WebSearchPrivacyMgr", " sp name %s ", new Object[] { DAM });
    SharedPreferences localSharedPreferences = aw.s(aj.getContext(), DAM, 0);
    AppMethodBeat.o(116539);
    return localSharedPreferences;
  }
  
  public static void eLE()
  {
    AppMethodBeat.i(116541);
    ad.i("WebSearchPrivacyMgr", "reInit");
    Object localObject1 = new StringBuilder("websearch_");
    g.ajA();
    DAM = com.tencent.mm.kernel.a.aiq();
    Object localObject2 = g.ajC().ajl().get(274436, "");
    localObject1 = "en";
    if (localObject2 != null) {
      localObject1 = localObject2.toString();
    }
    DAN = String.format("https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { ac.fks(), localObject1 });
    DAO = String.format("https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/close&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { ac.fks(), localObject1 });
    AppMethodBeat.o(116541);
  }
  
  public static void init()
  {
    AppMethodBeat.i(116540);
    if (DAN == null) {
      eLE();
    }
    AppMethodBeat.o(116540);
  }
  
  public final void a(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(116545);
    init();
    if ((!eLH()) && (com.tencent.mm.ax.b.FU((String)g.ajC().ajl().get(274436, null))))
    {
      this.DAK = paramRunnable;
      bx(paramContext, DAN);
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
    if (com.tencent.mm.ax.b.FU((String)g.ajC().ajl().get(274436, null)))
    {
      this.DAL = paramRunnable;
      bx(paramContext, DAO);
      AppMethodBeat.o(116546);
      return true;
    }
    paramRunnable.run();
    AppMethodBeat.o(116546);
    return false;
  }
  
  public final void eLF()
  {
    AppMethodBeat.i(116542);
    ad.i("WebSearchPrivacyMgr", "openSearch ");
    init();
    if (this.DAK != null)
    {
      this.DAK.run();
      if (this.DAK == this.DAK) {
        this.DAK = null;
      }
    }
    eLD().edit().putBoolean("websearch_confirmed", true).commit();
    cxy localcxy = new cxy();
    localcxy.Hpm = 1;
    localcxy.Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    localcxy.gsV = 1;
    b.a locala = new b.a();
    locala.hNM = localcxy;
    locala.hNN = new cxz();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    x.a(locala.aDC(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, com.tencent.mm.al.n paramAnonymousn)
      {
        return 0;
      }
    });
    AppMethodBeat.o(116542);
  }
  
  public final void eLG()
  {
    AppMethodBeat.i(116543);
    ad.i("WebSearchPrivacyMgr", "closeSearch ");
    init();
    if (this.DAL != null)
    {
      this.DAL.run();
      if (this.DAL == this.DAL) {
        this.DAL = null;
      }
    }
    eLD().edit().putBoolean("websearch_confirmed", false).commit();
    Object localObject = new cxy();
    ((cxy)localObject).Hpm = 1;
    ((cxy)localObject).Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    ((cxy)localObject).gsV = 2;
    b.a locala = new b.a();
    locala.hNM = ((com.tencent.mm.bx.a)localObject);
    locala.hNN = new cxz();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    x.a(locala.aDC(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, com.tencent.mm.al.n paramAnonymousn)
      {
        return 0;
      }
    });
    ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).deleteSOSHistory();
    if (ah.DCe != null) {
      ah.DCe = null;
    }
    localObject = ah.bnU();
    aj.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove((String)localObject).commit();
    AppMethodBeat.o(116543);
  }
  
  public final boolean eLH()
  {
    AppMethodBeat.i(116544);
    boolean bool = eLD().getBoolean("websearch_confirmed", false);
    AppMethodBeat.o(116544);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b
 * JD-Core Version:    0.7.0.1
 */