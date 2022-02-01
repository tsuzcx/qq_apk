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
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e zcX;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e zcY;
  private ViewGroup zcZ;
  
  private FloatWebViewHelper(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    this.zcX = parame;
    this.zcZ = paramViewGroup;
  }
  
  public static FloatWebViewHelper a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(200650);
    parame = new FloatWebViewHelper(parame, paramViewGroup);
    AppMethodBeat.o(200650);
    return parame;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(200651);
    try
    {
      if (this.zcX != null)
      {
        paramLifecycleOwner = this.zcX;
        ViewGroup localViewGroup = this.zcZ;
        if ((localViewGroup != null) && (paramLifecycleOwner != null))
        {
          this.zcY = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(localViewGroup.getContext(), paramLifecycleOwner, localViewGroup);
          if (this.zcY != null)
          {
            paramLifecycleOwner = this.zcY.getView();
            if ((paramLifecycleOwner != null) && (this.zcZ != null))
            {
              localViewGroup = (ViewGroup)paramLifecycleOwner.getParent();
              if (localViewGroup == null)
              {
                this.zcZ.addView(paramLifecycleOwner, this.zcZ.getChildCount() - 1);
                AppMethodBeat.o(200651);
                return;
              }
              if (localViewGroup != this.zcZ)
              {
                localViewGroup.removeView(paramLifecycleOwner);
                this.zcZ.addView(paramLifecycleOwner, this.zcZ.getChildCount() - 1);
              }
            }
          }
        }
      }
      AppMethodBeat.o(200651);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(200651);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(200654);
    try
    {
      if (this.zcY != null) {
        this.zcY.dJX();
      }
      AppMethodBeat.o(200654);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(200654);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(200653);
    try
    {
      if (this.zcY != null) {
        this.zcY.dJZ();
      }
      AppMethodBeat.o(200653);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(200653);
    }
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(200652);
    try
    {
      if (this.zcY != null) {
        this.zcY.dJY();
      }
      AppMethodBeat.o(200652);
      return;
    }
    catch (Throwable paramLifecycleOwner)
    {
      AppMethodBeat.o(200652);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper
 * JD-Core Version:    0.7.0.1
 */