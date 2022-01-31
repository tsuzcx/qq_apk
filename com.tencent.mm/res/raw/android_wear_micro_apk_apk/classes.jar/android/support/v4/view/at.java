package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;

final class at
  implements au
{
  as mn;
  boolean mo;
  
  at(as paramas)
  {
    this.mn = paramas;
  }
  
  public final void A(View paramView)
  {
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof au)) {}
    for (localObject = (au)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((au)localObject).A(paramView);
      }
      return;
    }
  }
  
  public final void y(View paramView)
  {
    this.mo = false;
    if (this.mn.mj >= 0) {
      paramView.setLayerType(2, null);
    }
    if (this.mn.mh != null)
    {
      localObject = this.mn.mh;
      this.mn.mh = null;
      ((Runnable)localObject).run();
    }
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof au)) {}
    for (localObject = (au)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((au)localObject).y(paramView);
      }
      return;
    }
  }
  
  public final void z(View paramView)
  {
    if (this.mn.mj >= 0)
    {
      paramView.setLayerType(this.mn.mj, null);
      this.mn.mj = -1;
    }
    if ((Build.VERSION.SDK_INT >= 16) || (!this.mo))
    {
      if (this.mn.mi != null)
      {
        localObject = this.mn.mi;
        this.mn.mi = null;
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
        ((au)localObject).z(paramView);
      }
      this.mo = true;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.at
 * JD-Core Version:    0.7.0.1
 */