package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;

final class OfflineVideoView$3
  implements Runnable
{
  OfflineVideoView$3(OfflineVideoView paramOfflineVideoView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(98015);
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    m.a(this.xpC.getContext(), (Intent)localObject, new e(this.qmz), "video/*");
    try
    {
      Context localContext = this.xpC.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/sns/ui/OfflineVideoView$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/sns/ui/OfflineVideoView$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(98015);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.OfflineVideoView", "startActivity fail, activity not found");
      h.j(this.xpC.getContext(), 2131758931, 2131758932);
      AppMethodBeat.o(98015);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OfflineVideoView.3
 * JD-Core Version:    0.7.0.1
 */