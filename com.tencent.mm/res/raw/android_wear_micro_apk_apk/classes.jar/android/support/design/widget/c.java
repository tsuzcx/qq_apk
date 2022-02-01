package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

final class c
  implements ViewGroup.OnHierarchyChangeListener
{
  c(CoordinatorLayout paramCoordinatorLayout) {}
  
  public final void onChildViewAdded(View paramView1, View paramView2)
  {
    if (this.bd.ba != null) {
      this.bd.ba.onChildViewAdded(paramView1, paramView2);
    }
  }
  
  public final void onChildViewRemoved(View paramView1, View paramView2)
  {
    this.bd.e(2);
    if (this.bd.ba != null) {
      this.bd.ba.onChildViewRemoved(paramView1, paramView2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.design.widget.c
 * JD-Core Version:    0.7.0.1
 */