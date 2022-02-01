package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.ad.f.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public abstract class FloatCompHelperWithLifecycle<INFO extends y, COMP extends m>
  implements LifecycleObserver
{
  protected Context mContext;
  protected INFO znN;
  protected COMP znO;
  protected ViewGroup znP;
  
  protected FloatCompHelperWithLifecycle(INFO paramINFO, ViewGroup paramViewGroup)
  {
    this.znN = paramINFO;
    this.znP = paramViewGroup;
    if (paramViewGroup != null) {}
    for (paramINFO = paramViewGroup.getContext();; paramINFO = ak.getContext())
    {
      this.mContext = paramINFO;
      return;
    }
  }
  
  protected abstract COMP a(Context paramContext, INFO paramINFO, ViewGroup paramViewGroup);
  
  public final COMP dUQ()
  {
    return this.znO;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void doCreate(LifecycleOwner paramLifecycleOwner)
  {
    try
    {
      paramLifecycleOwner = this.znN;
      Object localObject = this.znP;
      if ((paramLifecycleOwner != null) && (localObject != null))
      {
        this.znO = a(((ViewGroup)localObject).getContext(), paramLifecycleOwner, (ViewGroup)localObject);
        paramLifecycleOwner = this.znP;
        localObject = this.znO;
        if ((paramLifecycleOwner != null) && (localObject != null))
        {
          localObject = ((m)localObject).getView();
          if (localObject != null)
          {
            eL((View)localObject);
            j.a(paramLifecycleOwner, (View)localObject, paramLifecycleOwner.getChildCount() - 1);
          }
        }
        else
        {
          ae.w("FloatCompHelperWithLifecycle", "the comp is null, please check config!!!!");
        }
      }
      else
      {
        ae.w("FloatCompHelperWithLifecycle", "the info or container is null, please check input param");
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
      if (this.znO != null) {
        this.znO.dUM();
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
      if (this.znO != null) {
        this.znO.dUL();
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
      if (this.znO != null) {
        this.znO.dUK();
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