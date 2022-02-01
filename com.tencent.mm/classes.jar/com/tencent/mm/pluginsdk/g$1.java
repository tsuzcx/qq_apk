package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

final class g$1
  implements com.tencent.mm.am.h
{
  g$1(Context paramContext, int paramInt, String paramString1, String paramString2, g.a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(124343);
    com.tencent.mm.kernel.h.aZW().b(233, this);
    Log.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    Object localObject2;
    String str;
    if (paramp != null)
    {
      bool1 = bool3;
      if ((paramp instanceof n))
      {
        localObject2 = (n)paramp;
        Log.d("MicroMsg.DeepLinkHelper", "bitset:" + ((n)localObject2).bMa());
        long l = ((n)localObject2).bMa();
        str = g.boS(((n)localObject2).bLT());
        if (!g.ce(str, l)) {
          break label339;
        }
        bool1 = bool2;
      }
    }
    try
    {
      Log.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", new Object[] { str });
      bool1 = bool2;
      bool2 = g.a(this.val$context, ((n)localObject2).bMc(), ((n)localObject2).bMe(), str);
      bool1 = bool2;
      com.tencent.mm.plugin.report.service.h.OAn.b(11405, new Object[] { str, Integer.valueOf(1), Integer.valueOf(this.lyQ), this.lzC, Util.nullAsNil(this.val$url) });
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.DeepLinkHelper", localException, "", new Object[] { "" });
        com.tencent.mm.plugin.report.service.h.OAn.b(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(this.lyQ), this.lzC, Util.nullAsNil(this.val$url) });
      }
    }
    if (this.XNK != null) {
      this.XNK.a(paramInt1, paramInt2, paramString, paramp, bool1);
    }
    AppMethodBeat.o(124343);
    return;
    label339:
    Log.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
    if (((n)localObject2).bLV() != 49)
    {
      Object localObject1 = new Intent();
      ((Intent)localObject1).setFlags(268435456);
      ((Intent)localObject1).setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
      ((Intent)localObject1).putExtra("rawUrl", g.XNE);
      ((Intent)localObject1).putExtra("geta8key_session_id", ((n)localObject2).bMc());
      ((Intent)localObject1).putExtra("geta8key_cookie", ((n)localObject2).bMe());
      localObject2 = MMApplicationContext.getContext();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/pluginsdk/DeepLinkHelper$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/pluginsdk/DeepLinkHelper$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.OAn.b(11405, new Object[] { str, Integer.valueOf(0), Integer.valueOf(this.lyQ), this.lzC, Util.nullAsNil(this.val$url) });
    }
    for (;;)
    {
      bool1 = true;
      break;
      ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).jumpToRingtoneSettingUI(this.val$context, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.1
 * JD-Core Version:    0.7.0.1
 */