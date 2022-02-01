package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public abstract class FloatCompHelperWithLifecycle<INFO extends aa, COMP extends m>
  implements k
{
  protected INFO JDo;
  protected COMP JDp;
  protected ViewGroup JDq;
  protected Context mContext;
  
  protected FloatCompHelperWithLifecycle(INFO paramINFO, ViewGroup paramViewGroup)
  {
    this.JDo = paramINFO;
    this.JDq = paramViewGroup;
    if (paramViewGroup != null) {}
    for (paramINFO = paramViewGroup.getContext();; paramINFO = MMApplicationContext.getContext())
    {
      this.mContext = paramINFO;
      return;
    }
  }
  
  protected abstract COMP a(Context paramContext, INFO paramINFO, ViewGroup paramViewGroup);
  
  @t(jl=h.a.ON_CREATE)
  public final void doCreate(androidx.lifecycle.l paraml)
  {
    try
    {
      paraml = this.JDo;
      Object localObject = this.JDq;
      if ((paraml != null) && (localObject != null))
      {
        this.JDp = a(((ViewGroup)localObject).getContext(), paraml, (ViewGroup)localObject);
        paraml = this.JDq;
        localObject = this.JDp;
        if ((paraml != null) && (localObject != null))
        {
          localObject = ((m)localObject).getView();
          if (localObject != null)
          {
            gc((View)localObject);
            com.tencent.mm.plugin.sns.ad.i.l.b(paraml, (View)localObject, paraml.getChildCount() - 1);
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
    catch (Throwable paraml) {}
  }
  
  @t(jl=h.a.ON_DESTROY)
  public final void doDestroy(androidx.lifecycle.l paraml)
  {
    try
    {
      if (this.JDp != null) {
        this.JDp.fKo();
      }
      return;
    }
    catch (Throwable paraml) {}
  }
  
  @t(jl=h.a.ON_PAUSE)
  public final void doPause(androidx.lifecycle.l paraml)
  {
    try
    {
      if (this.JDp != null) {
        this.JDp.fKl();
      }
      return;
    }
    catch (Throwable paraml) {}
  }
  
  @t(jl=h.a.ON_RESUME)
  public final void doResume(androidx.lifecycle.l paraml)
  {
    try
    {
      if (this.JDp != null) {
        this.JDp.fKk();
      }
      return;
    }
    catch (Throwable paraml) {}
  }
  
  public final COMP fKJ()
  {
    return this.JDp;
  }
  
  protected void gc(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatCompHelperWithLifecycle
 * JD-Core Version:    0.7.0.1
 */