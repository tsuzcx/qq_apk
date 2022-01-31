package android.support.v4.widget;

import android.view.View;
import java.util.ArrayList;

final class n
  implements Runnable
{
  final View pI;
  
  n(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    this.pI = paramView;
  }
  
  public final void run()
  {
    if (this.pI.getParent() == this.pH)
    {
      this.pI.setLayerType(0, null);
      this.pH.Q(this.pI);
    }
    this.pH.pF.remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.n
 * JD-Core Version:    0.7.0.1
 */