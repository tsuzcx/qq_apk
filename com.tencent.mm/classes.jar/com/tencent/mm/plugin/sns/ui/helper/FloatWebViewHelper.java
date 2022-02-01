package com.tencent.mm.plugin.sns.ui.helper;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class FloatWebViewHelper
  implements k
{
  public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e LkA;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e LkB;
  private ViewGroup LkC;
  
  private FloatWebViewHelper(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    this.LkA = parame;
    this.LkC = paramViewGroup;
  }
  
  public static FloatWebViewHelper a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(199323);
    parame = new FloatWebViewHelper(parame, paramViewGroup);
    AppMethodBeat.o(199323);
    return parame;
  }
  
  @t(jl=h.a.ON_CREATE)
  public final void onCreate(l paraml)
  {
    AppMethodBeat.i(199327);
    try
    {
      if (this.LkA != null)
      {
        paraml = this.LkA;
        ViewGroup localViewGroup = this.LkC;
        if ((localViewGroup != null) && (paraml != null))
        {
          this.LkB = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(localViewGroup.getContext(), paraml, localViewGroup);
          if (this.LkB != null)
          {
            paraml = this.LkB.getView();
            if ((paraml != null) && (this.LkC != null))
            {
              localViewGroup = (ViewGroup)paraml.getParent();
              if (localViewGroup == null)
              {
                this.LkC.addView(paraml, this.LkC.getChildCount() - 1);
                AppMethodBeat.o(199327);
                return;
              }
              if (localViewGroup != this.LkC)
              {
                localViewGroup.removeView(paraml);
                this.LkC.addView(paraml, this.LkC.getChildCount() - 1);
              }
            }
          }
        }
      }
      AppMethodBeat.o(199327);
      return;
    }
    catch (Throwable paraml)
    {
      AppMethodBeat.o(199327);
    }
  }
  
  @t(jl=h.a.ON_DESTROY)
  public final void onDestroy(l paraml)
  {
    AppMethodBeat.i(199330);
    try
    {
      if (this.LkB != null) {
        this.LkB.fKo();
      }
      AppMethodBeat.o(199330);
      return;
    }
    catch (Throwable paraml)
    {
      AppMethodBeat.o(199330);
    }
  }
  
  @t(jl=h.a.ON_PAUSE)
  public final void onPause(l paraml)
  {
    AppMethodBeat.i(199329);
    try
    {
      if (this.LkB != null) {
        this.LkB.fKl();
      }
      AppMethodBeat.o(199329);
      return;
    }
    catch (Throwable paraml)
    {
      AppMethodBeat.o(199329);
    }
  }
  
  @t(jl=h.a.ON_RESUME)
  public final void onResume(l paraml)
  {
    AppMethodBeat.i(199328);
    try
    {
      if (this.LkB != null) {
        this.LkB.fKk();
      }
      AppMethodBeat.o(199328);
      return;
    }
    catch (Throwable paraml)
    {
      AppMethodBeat.o(199328);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper
 * JD-Core Version:    0.7.0.1
 */