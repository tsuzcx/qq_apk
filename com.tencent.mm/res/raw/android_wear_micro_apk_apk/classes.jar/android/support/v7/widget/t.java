package android.support.v7.widget;

import android.support.v4.os.f;
import android.view.ViewGroup;

public abstract class t<VH extends an>
{
  private final u vR = new u();
  private boolean vS = false;
  
  public abstract void a(VH paramVH, int paramInt);
  
  public final void a(v paramv)
  {
    this.vR.registerObserver(paramv);
  }
  
  public abstract VH b(ViewGroup paramViewGroup);
  
  public final void b(VH paramVH, int paramInt)
  {
    paramVH.un = paramInt;
    if (this.vS) {
      paramVH.wV = -1L;
    }
    paramVH.setFlags(1, 519);
    f.beginSection("RV OnBindView");
    paramVH.eG();
    a(paramVH, paramInt);
    paramVH.eF();
    f.endSection();
  }
  
  public final void b(v paramv)
  {
    this.vR.unregisterObserver(paramv);
  }
  
  public abstract int getItemCount();
  
  public final boolean hasStableIds()
  {
    return this.vS;
  }
  
  public final void notifyDataSetChanged()
  {
    this.vR.notifyChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.t
 * JD-Core Version:    0.7.0.1
 */