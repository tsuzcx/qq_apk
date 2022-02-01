package android.support.wearable.view;

import android.support.v7.widget.t;
import android.support.v7.widget.v;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import java.lang.ref.WeakReference;

final class ab
  extends v
  implements View.OnLayoutChangeListener
{
  private WeakReference<WearableListView> Hh;
  private boolean Hi;
  private boolean Hj;
  private t uU;
  
  private void fW()
  {
    if (this.Hj) {
      if (this.Hh != null) {
        break label31;
      }
    }
    label31:
    for (WearableListView localWearableListView = null;; localWearableListView = (WearableListView)this.Hh.get())
    {
      if (localWearableListView != null) {
        localWearableListView.removeOnLayoutChangeListener(this);
      }
      this.Hj = false;
      return;
    }
  }
  
  public final void a(t paramt)
  {
    fW();
    if (this.Hi)
    {
      this.uU.b(this);
      this.Hi = false;
    }
    this.uU = paramt;
    if (this.uU != null)
    {
      this.uU.a(this);
      this.Hi = true;
    }
  }
  
  public final void n(WearableListView paramWearableListView)
  {
    fW();
    this.Hh = new WeakReference(paramWearableListView);
  }
  
  public final void onChanged()
  {
    if (this.Hh == null) {}
    for (WearableListView localWearableListView = null;; localWearableListView = (WearableListView)this.Hh.get())
    {
      if ((!this.Hj) && (localWearableListView != null))
      {
        localWearableListView.addOnLayoutChangeListener(this);
        this.Hj = true;
      }
      return;
    }
  }
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = (WearableListView)this.Hh.get();
    if (paramView == null) {}
    do
    {
      return;
      fW();
    } while (paramView.getChildCount() <= 0);
    paramView.fS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.ab
 * JD-Core Version:    0.7.0.1
 */