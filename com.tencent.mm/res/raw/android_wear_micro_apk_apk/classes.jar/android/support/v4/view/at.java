package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;

final class at
  implements au
{
  as oj;
  boolean ok;
  
  at(as paramas)
  {
    this.oj = paramas;
  }
  
  public final void D(View paramView)
  {
    this.ok = false;
    if (this.oj.of >= 0) {
      paramView.setLayerType(2, null);
    }
    if (this.oj.od != null)
    {
      localObject = this.oj.od;
      this.oj.od = null;
      ((Runnable)localObject).run();
    }
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof au)) {}
    for (localObject = (au)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((au)localObject).D(paramView);
      }
      return;
    }
  }
  
  public final void E(View paramView)
  {
    if (this.oj.of >= 0)
    {
      paramView.setLayerType(this.oj.of, null);
      this.oj.of = -1;
    }
    if ((Build.VERSION.SDK_INT >= 16) || (!this.ok))
    {
      if (this.oj.oe != null)
      {
        localObject = this.oj.oe;
        this.oj.oe = null;
        ((Runnable)localObject).run();
      }
      localObject = paramView.getTag(2113929216);
      if (!(localObject instanceof au)) {
        break label113;
      }
    }
    label113:
    for (Object localObject = (au)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((au)localObject).E(paramView);
      }
      this.ok = true;
      return;
    }
  }
  
  public final void F(View paramView)
  {
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof au)) {}
    for (localObject = (au)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((au)localObject).F(paramView);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.at
 * JD-Core Version:    0.7.0.1
 */