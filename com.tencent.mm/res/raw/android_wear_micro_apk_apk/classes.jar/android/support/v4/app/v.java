package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.view.r;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class v
  extends w
{
  View cZ;
  
  v(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    super(paramAnimationListener, (byte)0);
    this.cZ = paramView;
  }
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if ((r.z(this.cZ)) || (Build.VERSION.SDK_INT >= 24)) {
      this.cZ.post(new Runnable()
      {
        public final void run()
        {
          v.this.cZ.setLayerType(0, null);
        }
      });
    }
    for (;;)
    {
      super.onAnimationEnd(paramAnimation);
      return;
      this.cZ.setLayerType(0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.v
 * JD-Core Version:    0.7.0.1
 */