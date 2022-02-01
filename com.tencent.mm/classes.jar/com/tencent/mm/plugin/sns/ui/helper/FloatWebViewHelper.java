package com.tencent.mm.plugin.sns.ui.helper;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class FloatWebViewHelper
  implements LifecycleObserver
{
  public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e EWp;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e EWq;
  private ViewGroup EWr;
  
  private FloatWebViewHelper(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    this.EWp = parame;
    this.EWr = paramViewGroup;
  }
  
  public static FloatWebViewHelper a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(203903);
    parame = new FloatWebViewHelper(parame, paramViewGroup);
    AppMethodBeat.o(203903);
    return parame;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(203904);
    try
    {
      if (this.EWp != null)
      {
        paramLifecycleOwner = this.EWp;
        ViewGroup localViewGroup = this.EWr;
        if ((localViewGroup != null) && (paramLifecycleOwner != null))
        {
          this.EWq = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(localViewGroup.getContext(), paramLifecycleOwner, localViewGroup);
          if (this.EWq != null)
          {
            paramLifecycleOwner = this.EWq.getView();
            if ((paramLifecycleOwner != null) && (this.EWr != null))
            {
              localViewGroup = (ViewGroup)paramLifecycleOwner.getParent();
              if (localViewGroup == null)
              {
                this.EWr.addView(paramLifecycleOwner, this.EWr.getChildCount() - 1);
                AppMethodBeat.o(203904);
                return;
              }
              if (localViewGroup != this.EWr)
              {
                localViewGroup.removeView(paramLifecycleOwner);
                this.EWr.addView(paramLifecycleOwner, this.EWr.getChildCount() - 1);
              }
            }
          }
        }
      }
      AppMethodBeat.o(203904);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(203904);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(203907);
    try
    {
      if (this.EWq != null) {
        this.EWq.eXd();
      }
      AppMethodBeat.o(203907);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(203907);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(203906);
    try
    {
      if (this.EWq != null) {
        this.EWq.eXa();
      }
      AppMethodBeat.o(203906);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(203906);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(203905);
    try
    {
      if (this.EWq != null) {
        this.EWq.eWZ();
      }
      AppMethodBeat.o(203905);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(203905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper
 * JD-Core Version:    0.7.0.1
 */