package com.tencent.mm.plugin.mv.ui.uic;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.videocomposition.effect.a;
import com.tencent.mm.videocomposition.effect.d;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class j$c$b
  implements Runnable
{
  j$c$b(j.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(232348);
    Object localObject = j.a(this.GjG.GjF);
    if (localObject == null) {
      p.iCn();
    }
    ImageView localImageView = (ImageView)((View)localObject).findViewById(b.e.cover_iv);
    if (localImageView != null)
    {
      localObject = localImageView.getDrawable();
      if (localObject != null) {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
          AppMethodBeat.o(232348);
          throw ((Throwable)localObject);
        }
      }
    }
    for (localObject = ((BitmapDrawable)localObject).getBitmap(); localObject == null; localObject = null)
    {
      AppMethodBeat.o(232348);
      return;
    }
    a locala = new a();
    if (localObject == null) {
      p.iCn();
    }
    locala.setInputBitmap((Bitmap)localObject);
    p.j(localImageView, "coverIv");
    locala.setOutputSize(localImageView.getWidth(), localImageView.getHeight());
    localObject = (com.tencent.mm.xeffect.effect.b)locala.YIy.ANo.a(com.tencent.mm.xeffect.effect.j.YZP);
    if (localObject != null) {
      ((com.tencent.mm.xeffect.effect.b)localObject).setRadius(20.0F);
    }
    locala.YIy.ANo.b((af)localObject);
    locala.af((kotlin.g.a.b)new q(localImageView) {});
    AppMethodBeat.o(232348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.j.c.b
 * JD-Core Version:    0.7.0.1
 */