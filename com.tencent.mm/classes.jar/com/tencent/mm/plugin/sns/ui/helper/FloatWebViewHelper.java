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
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e xQh;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e xQi;
  private ViewGroup xQj;
  
  private FloatWebViewHelper(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    this.xQh = parame;
    this.xQj = paramViewGroup;
  }
  
  public static FloatWebViewHelper a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(187781);
    parame = new FloatWebViewHelper(parame, paramViewGroup);
    AppMethodBeat.o(187781);
    return parame;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(187782);
    try
    {
      if (this.xQh != null)
      {
        paramLifecycleOwner = this.xQh;
        ViewGroup localViewGroup = this.xQj;
        if ((localViewGroup != null) && (paramLifecycleOwner != null))
        {
          this.xQi = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(localViewGroup.getContext(), paramLifecycleOwner, localViewGroup);
          if (this.xQi != null)
          {
            paramLifecycleOwner = this.xQi.getView();
            if ((paramLifecycleOwner != null) && (this.xQj != null))
            {
              localViewGroup = (ViewGroup)paramLifecycleOwner.getParent();
              if (localViewGroup == null)
              {
                this.xQj.addView(paramLifecycleOwner, this.xQj.getChildCount() - 1);
                AppMethodBeat.o(187782);
                return;
              }
              if (localViewGroup != this.xQj)
              {
                localViewGroup.removeView(paramLifecycleOwner);
                this.xQj.addView(paramLifecycleOwner, this.xQj.getChildCount() - 1);
              }
            }
          }
        }
      }
      AppMethodBeat.o(187782);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(187782);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(187785);
    try
    {
      if (this.xQi != null) {
        this.xQi.dvy();
      }
      AppMethodBeat.o(187785);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(187785);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(187784);
    try
    {
      if (this.xQi != null) {
        this.xQi.dvA();
      }
      AppMethodBeat.o(187784);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(187784);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(187783);
    try
    {
      if (this.xQi != null) {
        this.xQi.dvz();
      }
      AppMethodBeat.o(187783);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(187783);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper
 * JD-Core Version:    0.7.0.1
 */