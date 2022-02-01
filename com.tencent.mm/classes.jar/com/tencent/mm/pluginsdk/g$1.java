package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

final class g$1
  implements i
{
  g$1(Context paramContext, int paramInt, String paramString1, String paramString2, g.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(124343);
    com.tencent.mm.kernel.g.azz().b(233, this);
    Log.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    Object localObject2;
    String str;
    if (paramq != null)
    {
      bool1 = bool3;
      if ((paramq instanceof l))
      {
        localObject2 = (l)paramq;
        Log.d("MicroMsg.DeepLinkHelper", "bitset:" + ((l)localObject2).beW());
        long l = ((l)localObject2).beW();
        str = g.bcY(((l)localObject2).beQ());
        if (!g.bM(str, l)) {
          break label339;
        }
      }
    }
    for (bool1 = bool2;; bool1 = true)
    {
      try
      {
        Log.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", new Object[] { str });
        bool1 = bool2;
        bool2 = g.a(this.val$context, ((l)localObject2).beY(), ((l)localObject2).bfa(), str);
        bool1 = bool2;
        h.CyF.a(11405, new Object[] { str, Integer.valueOf(1), Integer.valueOf(this.gsA), this.gtu, Util.nullAsNil(this.val$url) });
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.DeepLinkHelper", localException, "", new Object[] { "" });
          h.CyF.a(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(this.gsA), this.gtu, Util.nullAsNil(this.val$url) });
        }
      }
      if (this.JSR != null) {
        this.JSR.a(paramInt1, paramInt2, paramString, paramq, bool1);
      }
      AppMethodBeat.o(124343);
      return;
      label339:
      Log.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
      Object localObject1 = new Intent();
      ((Intent)localObject1).setFlags(268435456);
      ((Intent)localObject1).setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      ((Intent)localObject1).putExtra("rawUrl", g.JSL);
      ((Intent)localObject1).putExtra("geta8key_session_id", ((l)localObject2).beY());
      ((Intent)localObject1).putExtra("geta8key_cookie", ((l)localObject2).bfa());
      localObject2 = MMApplicationContext.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/pluginsdk/DeepLinkHelper$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/pluginsdk/DeepLinkHelper$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      h.CyF.a(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(this.gsA), this.gtu, Util.nullAsNil(this.val$url) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.1
 * JD-Core Version:    0.7.0.1
 */