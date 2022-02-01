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
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.storage.ab;

public final class b
  implements i
{
  private static String AFB = "websearch_";
  private static String AFC;
  private static String AFD;
  private Runnable AFA;
  private Runnable AFz;
  
  private static void bs(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116547);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", true);
    localIntent.putExtra("rawUrl", paramString);
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(116547);
  }
  
  private static SharedPreferences ehv()
  {
    AppMethodBeat.i(116539);
    init();
    ad.i("WebSearchPrivacyMgr", " sp name %s ", new Object[] { AFB });
    SharedPreferences localSharedPreferences = aw.s(aj.getContext(), AFB, 0);
    AppMethodBeat.o(116539);
    return localSharedPreferences;
  }
  
  public static void ehw()
  {
    AppMethodBeat.i(116541);
    ad.i("WebSearchPrivacyMgr", "reInit");
    Object localObject1 = new StringBuilder("websearch_");
    g.afz();
    AFB = com.tencent.mm.kernel.a.aeo();
    Object localObject2 = g.afB().afk().get(274436, "");
    localObject1 = "en";
    if (localObject2 != null) {
      localObject1 = localObject2.toString();
    }
    AFC = String.format("https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { ac.eFu(), localObject1 });
    AFD = String.format("https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/close&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { ac.eFu(), localObject1 });
    AppMethodBeat.o(116541);
  }
  
  public static void init()
  {
    AppMethodBeat.i(116540);
    if (AFC == null) {
      ehw();
    }
    AppMethodBeat.o(116540);
  }
  
  public final void a(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(116545);
    init();
    if ((!ehz()) && (com.tencent.mm.ax.b.yL((String)g.afB().afk().get(274436, null))))
    {
      this.AFz = paramRunnable;
      bs(paramContext, AFC);
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
    if (com.tencent.mm.ax.b.yL((String)g.afB().afk().get(274436, null)))
    {
      this.AFA = paramRunnable;
      bs(paramContext, AFD);
      AppMethodBeat.o(116546);
      return true;
    }
    paramRunnable.run();
    AppMethodBeat.o(116546);
    return false;
  }
  
  public final void ehx()
  {
    AppMethodBeat.i(116542);
    ad.i("WebSearchPrivacyMgr", "openSearch ");
    init();
    if (this.AFz != null)
    {
      this.AFz.run();
      if (this.AFz == this.AFz) {
        this.AFz = null;
      }
    }
    ehv().edit().putBoolean("websearch_confirmed", true).commit();
    cnh localcnh = new cnh();
    localcnh.EhP = 1;
    localcnh.Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    localcnh.fVE = 1;
    b.a locala = new b.a();
    locala.gUU = localcnh;
    locala.gUV = new cni();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    x.a(locala.atI(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, com.tencent.mm.al.n paramAnonymousn)
      {
        return 0;
      }
    });
    AppMethodBeat.o(116542);
  }
  
  public final void ehy()
  {
    AppMethodBeat.i(116543);
    ad.i("WebSearchPrivacyMgr", "closeSearch ");
    init();
    if (this.AFA != null)
    {
      this.AFA.run();
      if (this.AFA == this.AFA) {
        this.AFA = null;
      }
    }
    ehv().edit().putBoolean("websearch_confirmed", false).commit();
    Object localObject = new cnh();
    ((cnh)localObject).EhP = 1;
    ((cnh)localObject).Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    ((cnh)localObject).fVE = 2;
    b.a locala = new b.a();
    locala.gUU = ((com.tencent.mm.bx.a)localObject);
    locala.gUV = new cni();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    x.a(locala.atI(), new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, com.tencent.mm.al.n paramAnonymousn)
      {
        return 0;
      }
    });
    ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).deleteSOSHistory();
    if (af.AGQ != null) {
      af.AGQ = null;
    }
    localObject = af.bdo();
    aj.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove((String)localObject).commit();
    AppMethodBeat.o(116543);
  }
  
  public final boolean ehz()
  {
    AppMethodBeat.i(116544);
    boolean bool = ehv().getBoolean("websearch_confirmed", false);
    AppMethodBeat.o(116544);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b
 * JD-Core Version:    0.7.0.1
 */