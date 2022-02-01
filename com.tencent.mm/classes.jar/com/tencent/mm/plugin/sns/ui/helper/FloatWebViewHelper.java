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
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e AuN;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e AuO;
  private ViewGroup AuP;
  
  private FloatWebViewHelper(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    this.AuN = parame;
    this.AuP = paramViewGroup;
  }
  
  public static FloatWebViewHelper a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(198534);
    parame = new FloatWebViewHelper(parame, paramViewGroup);
    AppMethodBeat.o(198534);
    return parame;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(198535);
    try
    {
      if (this.AuN != null)
      {
        paramLifecycleOwner = this.AuN;
        ViewGroup localViewGroup = this.AuP;
        if ((localViewGroup != null) && (paramLifecycleOwner != null))
        {
          this.AuO = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(localViewGroup.getContext(), paramLifecycleOwner, localViewGroup);
          if (this.AuO != null)
          {
            paramLifecycleOwner = this.AuO.getView();
            if ((paramLifecycleOwner != null) && (this.AuP != null))
            {
              localViewGroup = (ViewGroup)paramLifecycleOwner.getParent();
              if (localViewGroup == null)
              {
                this.AuP.addView(paramLifecycleOwner, this.AuP.getChildCount() - 1);
                AppMethodBeat.o(198535);
                return;
              }
              if (localViewGroup != this.AuP)
              {
                localViewGroup.removeView(paramLifecycleOwner);
                this.AuP.addView(paramLifecycleOwner, this.AuP.getChildCount() - 1);
              }
            }
          }
        }
      }
      AppMethodBeat.o(198535);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(198535);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(198538);
    try
    {
      if (this.AuO != null) {
        this.AuO.dRo();
      }
      AppMethodBeat.o(198538);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(198538);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(198537);
    try
    {
      if (this.AuO != null) {
        this.AuO.dRn();
      }
      AppMethodBeat.o(198537);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(198537);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(198536);
    try
    {
      if (this.AuO != null) {
        this.AuO.dRm();
      }
      AppMethodBeat.o(198536);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(198536);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper
 * JD-Core Version:    0.7.0.1
 */