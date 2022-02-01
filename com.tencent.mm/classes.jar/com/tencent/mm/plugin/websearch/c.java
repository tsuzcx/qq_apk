package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.protobuf.evc;
import com.tencent.mm.protocal.protobuf.evd;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;

public class c
  implements i
{
  private static String WnF = "websearch_";
  private static String WnG;
  private static String WnH;
  private Runnable WnD;
  private Runnable WnE;
  
  private static void co(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116547);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", true);
    localIntent.putExtra("rawUrl", paramString);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(116547);
  }
  
  public static void init()
  {
    AppMethodBeat.i(116540);
    if (WnG == null) {
      ipx();
    }
    AppMethodBeat.o(116540);
  }
  
  private static SharedPreferences ipw()
  {
    AppMethodBeat.i(116539);
    init();
    Log.i("WebSearchPrivacyMgr", " sp name %s ", new Object[] { WnF });
    SharedPreferences localSharedPreferences = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), WnF, 0, false);
    AppMethodBeat.o(116539);
    return localSharedPreferences;
  }
  
  public static void ipx()
  {
    AppMethodBeat.i(116541);
    Log.i("WebSearchPrivacyMgr", "reInit");
    Object localObject1 = new StringBuilder("websearch_");
    h.baC();
    WnF = com.tencent.mm.kernel.b.aZs();
    Object localObject2 = h.baE().ban().d(274436, "");
    localObject1 = "en";
    if (localObject2 != null) {
      localObject1 = localObject2.toString();
    }
    WnG = String.format("https://" + WeChatHosts.domainString(a.h.host_weixin_qq_com) + "/cgi-bin/newreadtemplate?t=gdpr/confirm&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { LocaleUtil.getApplicationLanguage(), localObject1 });
    WnH = String.format("https://" + WeChatHosts.domainString(a.h.host_weixin_qq_com) + "/cgi-bin/newreadtemplate?t=gdpr/close&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { LocaleUtil.getApplicationLanguage(), localObject1 });
    AppMethodBeat.o(116541);
  }
  
  public final void a(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(116545);
    init();
    if ((!ipA()) && (com.tencent.mm.au.b.OE((String)h.baE().ban().d(274436, null))))
    {
      this.WnD = paramRunnable;
      co(paramContext, WnG);
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
    if (com.tencent.mm.au.b.OE((String)h.baE().ban().d(274436, null)))
    {
      this.WnE = paramRunnable;
      co(paramContext, WnH);
      AppMethodBeat.o(116546);
      return true;
    }
    paramRunnable.run();
    AppMethodBeat.o(116546);
    return false;
  }
  
  public final boolean ipA()
  {
    AppMethodBeat.i(116544);
    boolean bool = ipw().getBoolean("websearch_confirmed", false);
    AppMethodBeat.o(116544);
    return bool;
  }
  
  public final void ipy()
  {
    AppMethodBeat.i(116542);
    Log.i("WebSearchPrivacyMgr", "openSearch ");
    init();
    if (this.WnD != null)
    {
      this.WnD.run();
      if (this.WnD == this.WnD) {
        this.WnD = null;
      }
    }
    ipw().edit().putBoolean("websearch_confirmed", true).commit();
    evc localevc = new evc();
    localevc.abxT = 1;
    localevc.Zvi = ((int)(System.currentTimeMillis() / 1000L));
    localevc.muC = 1;
    c.a locala = new c.a();
    locala.otE = localevc;
    locala.otF = new evd();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    z.a(locala.bEF(), new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
      {
        return 0;
      }
    });
    AppMethodBeat.o(116542);
  }
  
  public final void ipz()
  {
    AppMethodBeat.i(116543);
    Log.i("WebSearchPrivacyMgr", "closeSearch ");
    init();
    if (this.WnE != null)
    {
      this.WnE.run();
      if (this.WnE == this.WnE) {
        this.WnE = null;
      }
    }
    ipw().edit().putBoolean("websearch_confirmed", false).commit();
    Object localObject = new evc();
    ((evc)localObject).abxT = 1;
    ((evc)localObject).Zvi = ((int)(System.currentTimeMillis() / 1000L));
    ((evc)localObject).muC = 2;
    c.a locala = new c.a();
    locala.otE = ((a)localObject);
    locala.otF = new evd();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    z.a(locala.bEF(), new z.a()
    {
      public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
      {
        return 0;
      }
    });
    ((n)h.az(n.class)).deleteSOSHistory();
    if (an.Wpx != null) {
      an.Wpx = null;
    }
    localObject = an.cwe();
    MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove((String)localObject).commit();
    AppMethodBeat.o(116543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c
 * JD-Core Version:    0.7.0.1
 */