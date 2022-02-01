package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.drq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;

public final class b
  implements i
{
  private static String IDj = "websearch_";
  private static String IDk;
  private static String IDl;
  private Runnable IDh;
  private Runnable IDi;
  
  private static void bS(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116547);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", true);
    localIntent.putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(116547);
  }
  
  private static SharedPreferences fXs()
  {
    AppMethodBeat.i(116539);
    init();
    Log.i("WebSearchPrivacyMgr", " sp name %s ", new Object[] { IDj });
    SharedPreferences localSharedPreferences = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), IDj, 0, false);
    AppMethodBeat.o(116539);
    return localSharedPreferences;
  }
  
  public static void fXt()
  {
    AppMethodBeat.i(116541);
    Log.i("WebSearchPrivacyMgr", "reInit");
    Object localObject1 = new StringBuilder("websearch_");
    g.aAf();
    IDj = com.tencent.mm.kernel.a.ayV();
    Object localObject2 = g.aAh().azQ().get(274436, "");
    localObject1 = "en";
    if (localObject2 != null) {
      localObject1 = localObject2.toString();
    }
    IDk = String.format("https://" + WeChatHosts.domainString(2131761749) + "/cgi-bin/newreadtemplate?t=gdpr/confirm&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { LocaleUtil.getApplicationLanguage(), localObject1 });
    IDl = String.format("https://" + WeChatHosts.domainString(2131761749) + "/cgi-bin/newreadtemplate?t=gdpr/close&business=search&lang=%s&cc=%s&autoCloseWindow=1", new Object[] { LocaleUtil.getApplicationLanguage(), localObject1 });
    AppMethodBeat.o(116541);
  }
  
  public static void init()
  {
    AppMethodBeat.i(116540);
    if (IDk == null) {
      fXt();
    }
    AppMethodBeat.o(116540);
  }
  
  public final void a(Context paramContext, Runnable paramRunnable)
  {
    AppMethodBeat.i(116545);
    init();
    if ((!fXw()) && (com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null))))
    {
      this.IDh = paramRunnable;
      bS(paramContext, IDk);
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
    if (com.tencent.mm.aw.b.Pi((String)g.aAh().azQ().get(274436, null)))
    {
      this.IDi = paramRunnable;
      bS(paramContext, IDl);
      AppMethodBeat.o(116546);
      return true;
    }
    paramRunnable.run();
    AppMethodBeat.o(116546);
    return false;
  }
  
  public final void fXu()
  {
    AppMethodBeat.i(116542);
    Log.i("WebSearchPrivacyMgr", "openSearch ");
    init();
    if (this.IDh != null)
    {
      this.IDh.run();
      if (this.IDh == this.IDh) {
        this.IDh = null;
      }
    }
    fXs().edit().putBoolean("websearch_confirmed", true).commit();
    drp localdrp = new drp();
    localdrp.MUj = 1;
    localdrp.Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    localdrp.him = 1;
    d.a locala = new d.a();
    locala.iLN = localdrp;
    locala.iLO = new drq();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    aa.a(locala.aXF(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        return 0;
      }
    });
    AppMethodBeat.o(116542);
  }
  
  public final void fXv()
  {
    AppMethodBeat.i(116543);
    Log.i("WebSearchPrivacyMgr", "closeSearch ");
    init();
    if (this.IDi != null)
    {
      this.IDi.run();
      if (this.IDi == this.IDi) {
        this.IDi = null;
      }
    }
    fXs().edit().putBoolean("websearch_confirmed", false).commit();
    Object localObject = new drp();
    ((drp)localObject).MUj = 1;
    ((drp)localObject).Timestamp = ((int)(System.currentTimeMillis() / 1000L));
    ((drp)localObject).him = 2;
    d.a locala = new d.a();
    locala.iLN = ((com.tencent.mm.bw.a)localObject);
    locala.iLO = new drq();
    locala.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
    locala.funcId = 2957;
    aa.a(locala.aXF(), new aa.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
      {
        return 0;
      }
    });
    ((n)g.ah(n.class)).deleteSOSHistory();
    if (am.IEW != null) {
      am.IEW = null;
    }
    localObject = am.bKh();
    MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove((String)localObject).commit();
    AppMethodBeat.o(116543);
  }
  
  public final boolean fXw()
  {
    AppMethodBeat.i(116544);
    boolean bool = fXs().getBoolean("websearch_confirmed", false);
    AppMethodBeat.o(116544);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b
 * JD-Core Version:    0.7.0.1
 */