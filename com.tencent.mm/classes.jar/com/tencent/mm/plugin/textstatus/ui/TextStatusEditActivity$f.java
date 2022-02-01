package com.tencent.mm.plugin.textstatus.ui;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.d;
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.mm.xeffect.effect.b;
import com.tencent.mm.xeffect.effect.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$handleFileLocal$1$1"})
final class TextStatusEditActivity$f
  implements Runnable
{
  TextStatusEditActivity$f(VideoCompositionPlayView paramVideoCompositionPlayView, TextStatusEditActivity paramTextStatusEditActivity, FrameLayout.LayoutParams paramLayoutParams, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(216493);
    try
    {
      n localn = new n();
      EffectManager localEffectManager = new EffectManager();
      TextStatusEditActivity localTextStatusEditActivity = this.GeQ;
      ad localad = localEffectManager.a(j.Ryj);
      Object localObject = localad;
      if (!(localad instanceof b)) {
        localObject = null;
      }
      TextStatusEditActivity.a(localTextStatusEditActivity, (b)localObject);
      localObject = TextStatusEditActivity.e(this.GeQ);
      if (localObject != null) {
        ((b)localObject).setRadius(3.5F);
      }
      localn.e(new d(this.uJI, 2));
      localn.lW(this.GeT.getWidth(), this.GeT.getHeight());
      localn.GAw = localEffectManager;
      this.GeT.setLoop(true);
      this.GeT.a(localn);
      TextStatusEditActivity.a(this.GeQ, localn);
      TextStatusEditActivity.a(this.GeQ, localEffectManager);
      TextStatusEditActivity.a(this.GeQ, TextStatusEditActivity.e(this.GeQ));
      AppMethodBeat.o(216493);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.TxtStatus.TextStatusEditActivity", localThrowable, "video play err", new Object[0]);
      AppMethodBeat.o(216493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.f
 * JD-Core Version:    0.7.0.1
 */