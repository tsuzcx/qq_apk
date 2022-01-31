package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements f
{
  d$1(Context paramContext, int paramInt, String paramString1, String paramString2, d.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(233, this);
    y.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    com.tencent.mm.modelsimple.h localh;
    String str;
    if (paramm != null)
    {
      bool1 = bool3;
      if ((paramm instanceof com.tencent.mm.modelsimple.h))
      {
        localh = (com.tencent.mm.modelsimple.h)paramm;
        y.d("MicroMsg.DeepLinkHelper", "bitset:" + localh.Ql());
        long l = localh.Ql();
        str = localh.Qf();
        if (!d.ao(str, l)) {
          break label326;
        }
      }
    }
    for (bool1 = bool2;; bool1 = true)
    {
      try
      {
        y.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", new Object[] { str });
        bool1 = bool2;
        bool2 = d.a(this.val$context, localh.Qn(), localh.Qo(), str);
        bool1 = bool2;
        com.tencent.mm.plugin.report.service.h.nFQ.f(11405, new Object[] { str, Integer.valueOf(1), Integer.valueOf(this.egz), this.dol, bk.pm(this.val$url) });
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.DeepLinkHelper", localException, "", new Object[] { "" });
          com.tencent.mm.plugin.report.service.h.nFQ.f(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(this.egz), this.dol, bk.pm(this.val$url) });
        }
      }
      if (this.rSz != null) {
        this.rSz.a(paramInt1, paramInt2, paramString, paramm, bool1);
      }
      return;
      label326:
      y.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
      Intent localIntent = new Intent();
      localIntent.setFlags(268435456);
      localIntent.setClassName(ae.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      localIntent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
      localIntent.putExtra("geta8key_session_id", localException.Qn());
      localIntent.putExtra("geta8key_cookie", localException.Qo());
      ae.getContext().startActivity(localIntent);
      com.tencent.mm.plugin.report.service.h.nFQ.f(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(this.egz), this.dol, bk.pm(this.val$url) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.1
 * JD-Core Version:    0.7.0.1
 */