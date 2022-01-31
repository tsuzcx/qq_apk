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
  private WeakReference<WearableListView> Fs;
  private boolean Ft;
  private boolean Fu;
  private t te;
  
  private void fM()
  {
    if (this.Fu) {
      if (this.Fs != null) {
        break label31;
      }
    }
    label31:
    for (WearableListView localWearableListView = null;; localWearableListView = (WearableListView)this.Fs.get())
    {
      if (localWearableListView != null) {
        localWearableListView.removeOnLayoutChangeListener(this);
      }
      this.Fu = false;
      return;
    }
  }
  
  public final void a(t paramt)
  {
    fM();
    if (this.Ft)
    {
      this.te.b(this);
      this.Ft = false;
    }
    this.te = paramt;
    if (this.te != null)
    {
      this.te.a(this);
      this.Ft = true;
    }
  }
  
  public final void n(WearableListView paramWearableListView)
  {
    fM();
    this.Fs = new WeakReference(paramWearableListView);
  }
  
  public final void onChanged()
  {
    if (this.Fs == null) {}
    for (WearableListView localWearableListView = null;; localWearableListView = (WearableListView)this.Fs.get())
    {
      if ((!this.Fu) && (localWearableListView != null))
      {
        localWearableListView.addOnLayoutChangeListener(this);
        this.Fu = true;
      }
      return;
    }
  }
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = (WearableListView)this.Fs.get();
    if (paramView == null) {}
    do
    {
      return;
      fM();
    } while (paramView.getChildCount() <= 0);
    paramView.fI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.ab
 * JD-Core Version:    0.7.0.1
 */