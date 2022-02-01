package android.support.wearable.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

final class e
  extends ViewOutlineProvider
{
  private e(CircularButton paramCircularButton) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setOval(0, 0, CircularButton.a(this.Dn), CircularButton.a(this.Dn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.e
 * JD-Core Version:    0.7.0.1
 */