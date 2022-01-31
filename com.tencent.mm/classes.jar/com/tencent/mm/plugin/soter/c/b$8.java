package com.tencent.mm.plugin.soter.c;

import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.soter.a.b;
import com.tencent.mm.plugin.soter.a.c;

final class b$8
  implements Animation.AnimationListener
{
  b$8(b paramb, CharSequence paramCharSequence) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.psa.gSp.post(this.psa.prZ);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.psa.prT.setImageResource(a.c.fingerprint_luggage_icon_error);
    this.psa.gSp.setText(this.lZ);
    this.psa.gSp.setTextColor(this.psa.gSp.getResources().getColor(a.b.warning_color));
    this.psa.gSp.removeCallbacks(this.psa.prZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.b.8
 * JD-Core Version:    0.7.0.1
 */