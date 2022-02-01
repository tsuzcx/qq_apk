package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public abstract class FloatCompHelperWithLifecycle<INFO extends x, COMP extends l>
  implements LifecycleObserver
{
  protected Context mContext;
  protected INFO yXm;
  protected COMP yXn;
  protected ViewGroup yXo;
  
  protected FloatCompHelperWithLifecycle(INFO paramINFO, ViewGroup paramViewGroup)
  {
    this.yXm = paramINFO;
    this.yXo = paramViewGroup;
    if (paramViewGroup != null) {}
    for (paramINFO = paramViewGroup.getContext();; paramINFO = aj.getContext())
    {
      this.mContext = paramINFO;
      return;
    }
  }
  
  protected abstract COMP a(Context paramContext, INFO paramINFO, ViewGroup paramViewGroup);
  
  public final COMP dRs()
  {
    return this.yXn;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void doCreate(LifecycleOwner paramLifecycleOwner)
  {
    try
    {
      paramLifecycleOwner = this.yXm;
      Object localObject = this.yXo;
      if ((paramLifecycleOwner != null) && (localObject != null))
      {
        this.yXn = a(((ViewGroup)localObject).getContext(), paramLifecycleOwner, (ViewGroup)localObject);
        paramLifecycleOwner = this.yXo;
        localObject = this.yXn;
        if ((paramLifecycleOwner != null) && (localObject != null))
        {
          localObject = ((l)localObject).getView();
          if (localObject != null)
          {
            eL((View)localObject);
            j.a(paramLifecycleOwner, (View)localObject, paramLifecycleOwner.getChildCount() - 1);
          }
        }
        else
        {
          ad.w("FloatCompHelperWithLifecycle", "the comp is null, please check config!!!!");
        }
      }
      else
      {
        ad.w("FloatCompHelperWithLifecycle", "the info or container is null, please check input param");
      }
      return;
    }
    catch (Throwable paramLifecycleOwner) {}
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void doDestroy(LifecycleOwner paramLifecycleOwner)
  {
    try
    {
      if (this.yXn != null) {
        this.yXn.dRo();
      }
      return;
    }
    catch (Throwable paramLifecycleOwner) {}
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void doPause(LifecycleOwner paramLifecycleOwner)
  {
    try
    {
      if (this.yXn != null) {
        this.yXn.dRn();
      }
      return;
    }
    catch (Throwable paramLifecycleOwner) {}
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void doResume(LifecycleOwner paramLifecycleOwner)
  {
    try
    {
      if (this.yXn != null) {
        this.yXn.dRm();
      }
      return;
    }
    catch (Throwable paramLifecycleOwner) {}
  }
  
  protected void eL(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatCompHelperWithLifecycle
 * JD-Core Version:    0.7.0.1
 */