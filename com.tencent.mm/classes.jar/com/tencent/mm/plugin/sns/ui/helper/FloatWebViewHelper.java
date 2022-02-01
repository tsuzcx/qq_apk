package com.tencent.mm.plugin.sns.ui.helper;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class FloatWebViewHelper
  implements p
{
  public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e RKp;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e RKq;
  private ViewGroup RKr;
  
  private FloatWebViewHelper(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    this.RKp = parame;
    this.RKr = paramViewGroup;
  }
  
  public static FloatWebViewHelper a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e parame, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(308121);
    parame = new FloatWebViewHelper(parame, paramViewGroup);
    AppMethodBeat.o(308121);
    return parame;
  }
  
  @z(Ho=j.a.ON_CREATE)
  public final void onCreate(q paramq)
  {
    AppMethodBeat.i(308129);
    try
    {
      if (this.RKp != null)
      {
        paramq = this.RKp;
        ViewGroup localViewGroup = this.RKr;
        if ((localViewGroup != null) && (paramq != null))
        {
          this.RKq = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(localViewGroup.getContext(), paramq, localViewGroup);
          if (this.RKq != null)
          {
            paramq = this.RKq.getView();
            if ((paramq != null) && (this.RKr != null))
            {
              localViewGroup = (ViewGroup)paramq.getParent();
              if (localViewGroup == null)
              {
                this.RKr.addView(paramq, this.RKr.getChildCount() - 1);
                return;
              }
              if (localViewGroup != this.RKr)
              {
                localViewGroup.removeView(paramq);
                this.RKr.addView(paramq, this.RKr.getChildCount() - 1);
              }
            }
          }
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308129);
    }
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy(q paramq)
  {
    AppMethodBeat.i(308137);
    try
    {
      if (this.RKq != null) {
        this.RKq.has();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308137);
    }
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public final void onPause(q paramq)
  {
    AppMethodBeat.i(308136);
    try
    {
      if (this.RKq != null) {
        this.RKq.hap();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308136);
    }
  }
  
  @z(Ho=j.a.ON_RESUME)
  public final void onResume(q paramq)
  {
    AppMethodBeat.i(308132);
    try
    {
      if (this.RKq != null) {
        this.RKq.hao();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308132);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.helper.FloatWebViewHelper
 * JD-Core Version:    0.7.0.1
 */