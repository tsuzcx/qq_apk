package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

final class g$1
  implements f
{
  g$1(Context paramContext, int paramInt, String paramString1, String paramString2, g.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(124343);
    com.tencent.mm.kernel.g.ajj().b(233, this);
    ae.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    Object localObject2;
    String str;
    if (paramn != null)
    {
      bool1 = bool3;
      if ((paramn instanceof l))
      {
        localObject2 = (l)paramn;
        ae.d("MicroMsg.DeepLinkHelper", "bitset:" + ((l)localObject2).aKU());
        long l = ((l)localObject2).aKU();
        str = ((l)localObject2).aKO();
        if (!g.bL(str, l)) {
          break label336;
        }
      }
    }
    for (bool1 = bool2;; bool1 = true)
    {
      try
      {
        ae.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", new Object[] { str });
        bool1 = bool2;
        bool2 = g.a(this.val$context, ((l)localObject2).aKW(), ((l)localObject2).aKY(), str);
        bool1 = bool2;
        com.tencent.mm.plugin.report.service.g.yxI.f(11405, new Object[] { str, Integer.valueOf(1), Integer.valueOf(this.fNp), this.fOj, bu.nullAsNil(this.val$url) });
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.DeepLinkHelper", localException, "", new Object[] { "" });
          com.tencent.mm.plugin.report.service.g.yxI.f(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(this.fNp), this.fOj, bu.nullAsNil(this.val$url) });
        }
      }
      if (this.FbU != null) {
        this.FbU.a(paramInt1, paramInt2, paramString, paramn, bool1);
      }
      AppMethodBeat.o(124343);
      return;
      label336:
      ae.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
      Object localObject1 = new Intent();
      ((Intent)localObject1).setFlags(268435456);
      ((Intent)localObject1).setClassName(ak.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      ((Intent)localObject1).putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
      ((Intent)localObject1).putExtra("geta8key_session_id", ((l)localObject2).aKW());
      ((Intent)localObject1).putExtra("geta8key_cookie", ((l)localObject2).aKY());
      localObject2 = ak.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/pluginsdk/DeepLinkHelper$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/pluginsdk/DeepLinkHelper$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.g.yxI.f(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(this.fNp), this.fOj, bu.nullAsNil(this.val$url) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.1
 * JD-Core Version:    0.7.0.1
 */