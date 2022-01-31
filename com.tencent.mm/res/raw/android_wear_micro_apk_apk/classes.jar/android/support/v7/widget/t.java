package android.support.v7.widget;

import android.support.v4.os.f;
import android.view.ViewGroup;

public abstract class t<VH extends an>
{
  private final u ub = new u();
  private boolean uc = false;
  
  public abstract void a(VH paramVH, int paramInt);
  
  public final void a(v paramv)
  {
    this.ub.registerObserver(paramv);
  }
  
  public final void b(VH paramVH, int paramInt)
  {
    paramVH.sx = paramInt;
    if (this.uc) {
      paramVH.vg = -1L;
    }
    paramVH.setFlags(1, 519);
    f.beginSection("RV OnBindView");
    paramVH.er();
    a(paramVH, paramInt);
    paramVH.eq();
    f.endSection();
  }
  
  public final void b(v paramv)
  {
    this.ub.unregisterObserver(paramv);
  }
  
  public abstract VH c(ViewGroup paramViewGroup);
  
  public abstract int getItemCount();
  
  public final boolean hasStableIds()
  {
    return this.uc;
  }
  
  public final void notifyDataSetChanged()
  {
    this.ub.notifyChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.t
 * JD-Core Version:    0.7.0.1
 */