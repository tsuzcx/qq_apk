package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

final class f$1
  implements com.tencent.mm.ak.g
{
  f$1(Context paramContext, int paramInt, String paramString1, String paramString2, f.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(124343);
    com.tencent.mm.kernel.g.agi().b(233, this);
    ac.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    Object localObject2;
    String str;
    if (paramn != null)
    {
      bool1 = bool3;
      if ((paramn instanceof k))
      {
        localObject2 = (k)paramn;
        ac.d("MicroMsg.DeepLinkHelper", "bitset:" + ((k)localObject2).aHm());
        long l = ((k)localObject2).aHm();
        str = ((k)localObject2).aHg();
        if (!f.bH(str, l)) {
          break label336;
        }
      }
    }
    for (bool1 = bool2;; bool1 = true)
    {
      try
      {
        ac.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", new Object[] { str });
        bool1 = bool2;
        bool2 = f.a(this.val$context, ((k)localObject2).aHo(), ((k)localObject2).aHq(), str);
        bool1 = bool2;
        h.wUl.f(11405, new Object[] { str, Integer.valueOf(1), Integer.valueOf(this.fsL), this.fur, bs.nullAsNil(this.val$url) });
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.DeepLinkHelper", localException, "", new Object[] { "" });
          h.wUl.f(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(this.fsL), this.fur, bs.nullAsNil(this.val$url) });
        }
      }
      if (this.DfA != null) {
        this.DfA.a(paramInt1, paramInt2, paramString, paramn, bool1);
      }
      AppMethodBeat.o(124343);
      return;
      label336:
      ac.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
      Object localObject1 = new Intent();
      ((Intent)localObject1).setFlags(268435456);
      ((Intent)localObject1).setClassName(ai.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      ((Intent)localObject1).putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
      ((Intent)localObject1).putExtra("geta8key_session_id", ((k)localObject2).aHo());
      ((Intent)localObject1).putExtra("geta8key_cookie", ((k)localObject2).aHq());
      localObject2 = ai.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/pluginsdk/DeepLinkHelper$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/pluginsdk/DeepLinkHelper$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      h.wUl.f(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(this.fsL), this.fur, bs.nullAsNil(this.val$url) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.1
 * JD-Core Version:    0.7.0.1
 */