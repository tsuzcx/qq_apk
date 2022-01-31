package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.c.bni;
import com.tencent.mm.protocal.c.bnj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class c
  implements com.tencent.mm.plugin.websearch.api.m
{
  private static String qTn = "websearch_";
  private static String qTo;
  private static String qTp;
  private Runnable qTl;
  private Runnable qTm;
  
  private static void aW(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", true);
    localIntent.putExtra("rawUrl", paramString);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  private static SharedPreferences bZe()
  {
    init();
    y.i("WebSearchPrivacyMgr", " sp name %s ", new Object[] { qTn });
    return ap.l(ae.getContext(), qTn, 0);
  }
  
  public static void bZf()
  {
    y.i("WebSearchPrivacyMgr", "reInit");
    Object localObject = new StringBuilder("websearch_");
    g.DN();
    qTn = com.tencent.mm.kernel.a.CL();
    localObject = g.DP().Dz().get(274436, "").toString();
    qTo = ae.getContext().getString(a.c.open_confirm_url, new Object[] { x.cqJ(), localObject });
    qTp = ae.getContext().getString(a.c.close_confirm_url, new Object[] { x.cqJ(), localObject });
  }
  
  public static void init()
  {
    if (qTo == null) {
      bZf();
    }
  }
  
  public final void a(Context paramContext, Runnable paramRunnable)
  {
    
    if ((!bZe().getBoolean("websearch_confirmed", false)) && (com.tencent.mm.at.b.mC((String)g.DP().Dz().get(274436, null))))
    {
      this.qTl = paramRunnable;
      aW(paramContext, qTo);
      return;
    }
    paramRunnable.run();
  }
  
  public final boolean b(Context paramContext, Runnable paramRunnable)
  {
    
    if (com.tencent.mm.at.b.mC((String)g.DP().Dz().get(274436, null)))
    {
      this.qTm = paramRunnable;
      aW(paramContext, qTp);
      return true;
    }
    paramRunnable.run();
    return false;
  }
  
  public final void bZg()
  {
    y.i("WebSearchPrivacyMgr", "openSearch ");
    init();
    if (this.qTl != null)
    {
      this.qTl.run();
      if (this.qTl == this.qTl) {
        this.qTl = null;
      }
    }
    bZe().edit().putBoolean("websearch_confirmed", true).commit();
    bni localbni = new bni();
    localbni.tGp = 1;
    localbni.sSK = ((int)(System.currentTimeMillis() / 1000L));
    localbni.kTS = 1;
    b.a locala = new b.a();
    locala.ecH = localbni;
    locala.ecI = new bnj();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.ecG = 2957;
    w.a(locala.Kt(), new c.1(this));
  }
  
  public final void bZh()
  {
    y.i("WebSearchPrivacyMgr", "closeSearch ");
    init();
    if (this.qTm != null)
    {
      this.qTm.run();
      if (this.qTm == this.qTm) {
        this.qTm = null;
      }
    }
    bZe().edit().putBoolean("websearch_confirmed", false).commit();
    Object localObject = new bni();
    ((bni)localObject).tGp = 1;
    ((bni)localObject).sSK = ((int)(System.currentTimeMillis() / 1000L));
    ((bni)localObject).kTS = 2;
    b.a locala = new b.a();
    locala.ecH = ((com.tencent.mm.bv.a)localObject);
    locala.ecI = new bnj();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.ecG = 2957;
    w.a(locala.Kt(), new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb, com.tencent.mm.ah.m paramAnonymousm)
      {
        return 0;
      }
    });
    ((n)g.t(n.class)).deleteSOSHistory();
    if (ai.qUx != null) {
      ai.qUx = null;
    }
    localObject = ai.bZB();
    ae.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove((String)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c
 * JD-Core Version:    0.7.0.1
 */