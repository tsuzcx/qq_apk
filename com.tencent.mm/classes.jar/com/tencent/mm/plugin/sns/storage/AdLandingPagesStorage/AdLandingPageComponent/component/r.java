package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class r
  extends m
{
  CircularImageView Edy;
  
  public r(Context paramContext, t paramt, ViewGroup paramViewGroup)
  {
    super(paramContext, paramt, paramViewGroup);
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96504);
    if ((this.contentView == null) || (this.Edy == null))
    {
      AppMethodBeat.o(96504);
      return;
    }
    t localt = (t)this.EcX;
    if (localt == null)
    {
      AppMethodBeat.o(96504);
      return;
    }
    h.a(localt.DYK, localt.DZj, new f.a()
    {
      public final void aNH(String paramAnonymousString)
      {
        AppMethodBeat.i(96501);
        r localr;
        try
        {
          paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
          localr = r.this;
          if (paramAnonymousString == null)
          {
            Log.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
            AppMethodBeat.o(96501);
            return;
          }
          if (localr.Edy == null)
          {
            Log.e("AdLandingPageCircleImgComp", "when set image the img is null!");
            AppMethodBeat.o(96501);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("AdLandingPageCircleImgComp", "%s" + Util.stackTraceToString(paramAnonymousString));
          AppMethodBeat.o(96501);
          return;
        }
        if (paramAnonymousString.getWidth() == 0)
        {
          Log.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
          AppMethodBeat.o(96501);
          return;
        }
        localr.Edy.setImageBitmap(paramAnonymousString);
        AppMethodBeat.o(96501);
      }
      
      public final void eWN() {}
      
      public final void eWO() {}
    });
    AppMethodBeat.o(96504);
  }
  
  protected final void eWX()
  {
    AppMethodBeat.i(96502);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.EcX.paddingLeft, (int)this.EcX.paddingTop, (int)this.EcX.paddingRight, (int)this.EcX.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96502);
  }
  
  protected final View eWY()
  {
    AppMethodBeat.i(96503);
    CircularImageView localCircularImageView = new CircularImageView(this.context);
    AppMethodBeat.o(96503);
    return localCircularImageView;
  }
  
  public final void eXe()
  {
    this.Edy = ((CircularImageView)this.contentView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r
 * JD-Core Version:    0.7.0.1
 */