package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.mm.plugin.sns.ad.j.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public abstract class FloatCompHelperWithLifecycle<INFO extends aa, COMP extends n>
  implements p
{
  protected INFO PUn;
  protected COMP PUo;
  protected ViewGroup PUp;
  protected Context mContext;
  
  protected FloatCompHelperWithLifecycle(INFO paramINFO, ViewGroup paramViewGroup)
  {
    this.PUn = paramINFO;
    this.PUp = paramViewGroup;
    if (paramViewGroup != null) {}
    for (paramINFO = paramViewGroup.getContext();; paramINFO = MMApplicationContext.getContext())
    {
      this.mContext = paramINFO;
      return;
    }
  }
  
  protected abstract COMP a(Context paramContext, INFO paramINFO, ViewGroup paramViewGroup);
  
  @z(Ho=j.a.ON_CREATE)
  public final void doCreate(q paramq)
  {
    try
    {
      paramq = this.PUn;
      Object localObject = this.PUp;
      if ((paramq != null) && (localObject != null))
      {
        this.PUo = a(((ViewGroup)localObject).getContext(), paramq, (ViewGroup)localObject);
        paramq = this.PUp;
        localObject = this.PUo;
        if ((paramq != null) && (localObject != null))
        {
          localObject = ((n)localObject).getView();
          if (localObject != null)
          {
            jf((View)localObject);
            l.b(paramq, (View)localObject, paramq.getChildCount() - 1);
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
    finally {}
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public final void doDestroy(q paramq)
  {
    try
    {
      if (this.PUo != null) {
        this.PUo.has();
      }
      return;
    }
    finally {}
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public final void doPause(q paramq)
  {
    try
    {
      if (this.PUo != null) {
        this.PUo.hap();
      }
      return;
    }
    finally {}
  }
  
  @z(Ho=j.a.ON_RESUME)
  public final void doResume(q paramq)
  {
    try
    {
      if (this.PUo != null) {
        this.PUo.hao();
      }
      return;
    }
    finally {}
  }
  
  public final COMP haY()
  {
    return this.PUo;
  }
  
  protected void jf(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatCompHelperWithLifecycle
 * JD-Core Version:    0.7.0.1
 */