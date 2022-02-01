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
import com.tencent.mm.sdk.platformtools.g;

public final class q
  extends l
{
  CircularImageView zEl;
  
  public q(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
  }
  
  public final void dRk()
  {
    this.zEl = ((CircularImageView)this.contentView);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96504);
    if ((this.contentView == null) || (this.zEl == null))
    {
      AppMethodBeat.o(96504);
      return;
    }
    s locals = (s)this.zDK;
    if (locals == null)
    {
      AppMethodBeat.o(96504);
      return;
    }
    h.a(locals.zzL, locals.zAh, new f.a()
    {
      public final void axG(String paramAnonymousString)
      {
        AppMethodBeat.i(96501);
        q localq;
        try
        {
          paramAnonymousString = g.decodeFile(paramAnonymousString);
          localq = q.this;
          if (paramAnonymousString == null)
          {
            ad.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
            AppMethodBeat.o(96501);
            return;
          }
          if (localq.zEl == null)
          {
            ad.e("AdLandingPageCircleImgComp", "when set image the img is null!");
            AppMethodBeat.o(96501);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("AdLandingPageCircleImgComp", "%s" + bt.n(paramAnonymousString));
          AppMethodBeat.o(96501);
          return;
        }
        if (paramAnonymousString.getWidth() == 0)
        {
          ad.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
          AppMethodBeat.o(96501);
          return;
        }
        localq.zEl.setImageBitmap(paramAnonymousString);
        AppMethodBeat.o(96501);
      }
      
      public final void dRW() {}
      
      public final void dRX() {}
    });
    AppMethodBeat.o(96504);
  }
  
  protected final View dWC()
  {
    AppMethodBeat.i(96503);
    CircularImageView localCircularImageView = new CircularImageView(this.context);
    AppMethodBeat.o(96503);
    return localCircularImageView;
  }
  
  protected final void dWF()
  {
    AppMethodBeat.i(96502);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zDK.paddingLeft, (int)this.zDK.paddingTop, (int)this.zDK.paddingRight, (int)this.zDK.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
 * JD-Core Version:    0.7.0.1
 */