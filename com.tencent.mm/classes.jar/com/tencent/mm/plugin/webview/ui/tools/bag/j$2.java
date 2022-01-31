package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class j$2
  extends AnimatorListenerAdapter
{
  j$2(j paramj) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(8180);
    if (j.d(this.vih) != null) {
      j.d(this.vih).onAnimationEnd(paramAnimator);
    }
    this.vih.setVisibility(8);
    if ((j.e(this.vih) != null) && (!j.e(this.vih).isRecycled()))
    {
      ab.i("MicroMsg.TransformToBagAniMask", "bitmap recycle %s", new Object[] { j.e(this.vih).toString() });
      j.e(this.vih).recycle();
    }
    AppMethodBeat.o(8180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.j.2
 * JD-Core Version:    0.7.0.1
 */