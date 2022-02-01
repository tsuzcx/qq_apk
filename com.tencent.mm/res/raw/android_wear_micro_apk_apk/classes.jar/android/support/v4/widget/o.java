package android.support.v4.widget;

import android.view.View;
import java.util.ArrayList;

final class o
  implements Runnable
{
  final View ry;
  
  o(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    this.ry = paramView;
  }
  
  public final void run()
  {
    if (this.ry.getParent() == this.rx)
    {
      this.ry.setLayerType(0, null);
      this.rx.W(this.ry);
    }
    this.rx.rv.remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.o
 * JD-Core Version:    0.7.0.1
 */