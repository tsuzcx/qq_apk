package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public abstract class FloatCompHelperWithLifecycle<INFO extends z, COMP extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m>
  implements LifecycleObserver
{
  protected INFO DtZ;
  protected COMP Dua;
  protected ViewGroup Dub;
  protected Context mContext;
  
  protected FloatCompHelperWithLifecycle(INFO paramINFO, ViewGroup paramViewGroup)
  {
    this.DtZ = paramINFO;
    this.Dub = paramViewGroup;
    if (paramViewGroup != null) {}
    for (paramINFO = paramViewGroup.getContext();; paramINFO = MMApplicationContext.getContext())
    {
      this.mContext = paramINFO;
      return;
    }
  }
  
  protected abstract COMP a(Context paramContext, INFO paramINFO, ViewGroup paramViewGroup);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void doCreate(LifecycleOwner paramLifecycleOwner)
  {
    try
    {
      paramLifecycleOwner = this.DtZ;
      Object localObject = this.Dub;
      if ((paramLifecycleOwner != null) && (localObject != null))
      {
        this.Dua = a(((ViewGroup)localObject).getContext(), paramLifecycleOwner, (ViewGroup)localObject);
        paramLifecycleOwner = this.Dub;
        localObject = this.Dua;
        if ((paramLifecycleOwner != null) && (localObject != null))
        {
          localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m)localObject).getView();
          if (localObject != null)
          {
            eX((View)localObject);
            com.tencent.mm.plugin.sns.ad.i.m.a(paramLifecycleOwner, (View)localObject, paramLifecycleOwner.getChildCount() - 1);
          }
        }
        else
        {
          Log.w("FloatCompHelperWithLifecycle", "the comp is null, please check config!!!!");
        }
      }
      else
      {
        Log.w("FloatCompHelperWithLifecycle", "the info or container is null, please check input param");
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
      if (this.Dua != null) {
        this.Dua.eXd();
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
      if (this.Dua != null) {
        this.Dua.eXa();
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
      if (this.Dua != null) {
        this.Dua.eWZ();
      }
      return;
    }
    catch (Throwable paramLifecycleOwner) {}
  }
  
  protected void eX(View paramView) {}
  
  public final COMP eXj()
  {
    return this.Dua;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatCompHelperWithLifecycle
 * JD-Core Version:    0.7.0.1
 */