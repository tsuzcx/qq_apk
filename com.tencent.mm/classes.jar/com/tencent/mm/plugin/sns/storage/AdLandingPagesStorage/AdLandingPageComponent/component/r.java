package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class r
  extends m
{
  CircularImageView zVr;
  
  public r(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
  }
  
  public final void dUI()
  {
    this.zVr = ((CircularImageView)this.contentView);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96504);
    if ((this.contentView == null) || (this.zVr == null))
    {
      AppMethodBeat.o(96504);
      return;
    }
    s locals = (s)this.zUP;
    if (locals == null)
    {
      AppMethodBeat.o(96504);
      return;
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(locals.zQK, locals.zRh, new f.a()
    {
      public final void ayY(String paramAnonymousString)
      {
        AppMethodBeat.i(96501);
        r localr;
        try
        {
          paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString);
          localr = r.this;
          if (paramAnonymousString == null)
          {
            ae.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
            AppMethodBeat.o(96501);
            return;
          }
          if (localr.zVr == null)
          {
            ae.e("AdLandingPageCircleImgComp", "when set image the img is null!");
            AppMethodBeat.o(96501);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          ae.e("AdLandingPageCircleImgComp", "%s" + bu.o(paramAnonymousString));
          AppMethodBeat.o(96501);
          return;
        }
        if (paramAnonymousString.getWidth() == 0)
        {
          ae.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
          AppMethodBeat.o(96501);
          return;
        }
        localr.zVr.setImageBitmap(paramAnonymousString);
        AppMethodBeat.o(96501);
      }
      
      public final void dVu() {}
      
      public final void dVv() {}
    });
    AppMethodBeat.o(96504);
  }
  
  protected final View eae()
  {
    AppMethodBeat.i(96503);
    CircularImageView localCircularImageView = new CircularImageView(this.context);
    AppMethodBeat.o(96503);
    return localCircularImageView;
  }
  
  protected final void eah()
  {
    AppMethodBeat.i(96502);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zUP.paddingLeft, (int)this.zUP.paddingTop, (int)this.zUP.paddingRight, (int)this.zUP.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r
 * JD-Core Version:    0.7.0.1
 */