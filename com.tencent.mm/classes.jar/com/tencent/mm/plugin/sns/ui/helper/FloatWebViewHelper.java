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
  public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e AMd;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e AMe;
  private ViewGroup AMf;
  
  private FloatWebViewHelper(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    this.AMd = parame;
    this.AMf = paramViewGroup;
  }
  
  public static FloatWebViewHelper a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(220076);
    parame = new FloatWebViewHelper(parame, paramViewGroup);
    AppMethodBeat.o(220076);
    return parame;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(220077);
    try
    {
      if (this.AMd != null)
      {
        paramLifecycleOwner = this.AMd;
        ViewGroup localViewGroup = this.AMf;
        if ((localViewGroup != null) && (paramLifecycleOwner != null))
        {
          this.AMe = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(localViewGroup.getContext(), paramLifecycleOwner, localViewGroup);
          if (this.AMe != null)
          {
            paramLifecycleOwner = this.AMe.getView();
            if ((paramLifecycleOwner != null) && (this.AMf != null))
            {
              localViewGroup = (ViewGroup)paramLifecycleOwner.getParent();
              if (localViewGroup == null)
              {
                this.AMf.addView(paramLifecycleOwner, this.AMf.getChildCount() - 1);
                AppMethodBeat.o(220077);
                return;
              }
              if (localViewGroup != this.AMf)
              {
                localViewGroup.removeView(paramLifecycleOwner);
                this.AMf.addView(paramLifecycleOwner, this.AMf.getChildCount() - 1);
              }
            }
          }
        }
      }
      AppMethodBeat.o(220077);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(220077);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(220080);
    try
    {
      if (this.AMe != null) {
        this.AMe.dUM();
      }
      AppMethodBeat.o(220080);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(220080);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(220079);
    try
    {
      if (this.AMe != null) {
        this.AMe.dUL();
      }
      AppMethodBeat.o(220079);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(220079);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(220078);
    try
    {
      if (this.AMe != null) {
        this.AMe.dUK();
      }
      AppMethodBeat.o(220078);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(220078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper
 * JD-Core Version:    0.7.0.1
 */