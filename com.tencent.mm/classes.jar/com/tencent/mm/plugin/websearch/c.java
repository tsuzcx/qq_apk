package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;

public class c
  implements i
{
  private static String PxA;
  private static String PxB;
  private static String Pxz = "websearch_";
  private Runnable Pxx;
  private Runnable Pxy;
  
  private static void cd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116547);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", true);
    localIntent.putExtra("rawUrl", paramString);
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(116547);
  }
  
  private static SharedPreferences gQf()
  {
    AppMethodBeat.i(116539);
    init();
    Log.i("WebSearchPrivacyMgr", " sp name %s ", new Object[] { Pxz });
    SharedPreferences localSharedPreferences = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), Pxz, 0, false);
    AppMethodBeat.o(116539);
    return localSharedPreferences;
  }
  
  public static void gQg()
  {
    AppMethodBeat.i(116541);
    Log.i("WebSearchPrivacyMgr", "reInit");
    Object localObject1 = new StringBuilder("websearch_");
    h.aHE();
    Pxz = com.tencent.mm.kernel.b.aGq();
    Object localObject2 = h.aHG().aHp().b(274436, "");
    localObject1 = "en";
    if (localObject2 != null) {
      localObject1 = localObject2.toString();
    }
    PxA = String.format("https://" + WeChatHosts.domainString(a.g.host_weixin_qq_com) + "/cgi-bin/newreadtemplate?t=gdpr/confirm&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { LocaleUtil.getApplicationLanguage(), localObject1 });
    PxB = String.format("https://" + WeChatHosts.domainString(a.g.host_weixin_qq_com) + "/cgi-bin/newreadtemplate?t=gdpr/close&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { LocaleUtil.getApplicationLanguage(), localObject1 });
    AppMethodBeat.o(116541);
  }
  
  public static void init()
  {
    AppMethodBeat.i(116540);
    if (PxA == null) {
      gQg();
    }
    AppMethodBeat.o(116540);
  }
  
  public final void a(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(116545);
    init();
    if ((!gQj()) && (com.tencent.mm.az.b.WF((String)h.aHG().aHp().b(274436, null))))
    {
      this.Pxx = paramRunnable;
      cd(paramContext, PxA);
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
    if (com.tencent.mm.az.b.WF((String)h.aHG().aHp().b(274436, null)))
    {
      this.Pxy = paramRunnable;
      cd(paramContext, PxB);
      AppMethodBeat.o(116546);
      return true;
    }
    paramRunnable.run();
    AppMethodBeat.o(116546);
    return false;
  }
  
  public final void gQh()
  {
    AppMethodBeat.i(116542);
    Log.i("WebSearchPrivacyMgr", "openSearch ");
    init();
    if (this.Pxx != null)
    {
      this.Pxx.run();
      if (this.Pxx == this.Pxx) {
        this.Pxx = null;
      }
    }
    gQf().edit().putBoolean("websearch_confirmed", true).commit();
    ebl localebl = new ebl();
    localebl.Ugs = 1;
    localebl.Svi = ((int)(System.currentTimeMillis() / 1000L));
    localebl.jUk = 1;
    d.a locala = new d.a();
    locala.lBU = localebl;
    locala.lBV = new ebm();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    aa.a(locala.bgN(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        return 0;
      }
    });
    AppMethodBeat.o(116542);
  }
  
  public final void gQi()
  {
    AppMethodBeat.i(116543);
    Log.i("WebSearchPrivacyMgr", "closeSearch ");
    init();
    if (this.Pxy != null)
    {
      this.Pxy.run();
      if (this.Pxy == this.Pxy) {
        this.Pxy = null;
      }
    }
    gQf().edit().putBoolean("websearch_confirmed", false).commit();
    Object localObject = new ebl();
    ((ebl)localObject).Ugs = 1;
    ((ebl)localObject).Svi = ((int)(System.currentTimeMillis() / 1000L));
    ((ebl)localObject).jUk = 2;
    d.a locala = new d.a();
    locala.lBU = ((a)localObject);
    locala.lBV = new ebm();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    aa.a(locala.bgN(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        return 0;
      }
    });
    ((n)h.ag(n.class)).deleteSOSHistory();
    if (am.Pzo != null) {
      am.Pzo = null;
    }
    localObject = am.bVR();
    MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove((String)localObject).commit();
    AppMethodBeat.o(116543);
  }
  
  public final boolean gQj()
  {
    AppMethodBeat.i(116544);
    boolean bool = gQf().getBoolean("websearch_confirmed", false);
    AppMethodBeat.o(116544);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c
 * JD-Core Version:    0.7.0.1
 */