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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;

public final class p
  extends k
{
  CircularImageView xaB;
  
  public p(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96504);
    if ((this.contentView == null) || (this.xaB == null))
    {
      AppMethodBeat.o(96504);
      return;
    }
    s locals = (s)this.xab;
    if (locals == null)
    {
      AppMethodBeat.o(96504);
      return;
    }
    h.a(locals.wWp, locals.wWF, new f.a()
    {
      public final void apm(String paramAnonymousString)
      {
        AppMethodBeat.i(96501);
        p localp;
        try
        {
          paramAnonymousString = f.decodeFile(paramAnonymousString);
          localp = p.this;
          if (paramAnonymousString == null)
          {
            ad.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
            AppMethodBeat.o(96501);
            return;
          }
          if (localp.xaB == null)
          {
            ad.e("AdLandingPageCircleImgComp", "when set image the img is null!");
            AppMethodBeat.o(96501);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("AdLandingPageCircleImgComp", "%s" + bt.m(paramAnonymousString));
          AppMethodBeat.o(96501);
          return;
        }
        if (paramAnonymousString.getWidth() == 0)
        {
          ad.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
          AppMethodBeat.o(96501);
          return;
        }
        localp.xaB.setImageBitmap(paramAnonymousString);
        AppMethodBeat.o(96501);
      }
      
      public final void dsA() {}
      
      public final void duP() {}
    });
    AppMethodBeat.o(96504);
  }
  
  protected final View dvQ()
  {
    AppMethodBeat.i(96503);
    CircularImageView localCircularImageView = new CircularImageView(this.context);
    AppMethodBeat.o(96503);
    return localCircularImageView;
  }
  
  protected final void dvT()
  {
    AppMethodBeat.i(96502);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.xab.paddingLeft, (int)this.xab.paddingTop, (int)this.xab.paddingRight, (int)this.xab.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96502);
  }
  
  public final void dvx()
  {
    this.xaB = ((CircularImageView)this.contentView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p
 * JD-Core Version:    0.7.0.1
 */