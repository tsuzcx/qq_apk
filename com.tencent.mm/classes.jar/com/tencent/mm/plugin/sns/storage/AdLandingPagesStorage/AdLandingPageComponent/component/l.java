package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l
  extends h
{
  CircularImageView rvy;
  
  public l(Context paramContext, o paramo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramo, paramViewGroup);
  }
  
  public final void cqK()
  {
    this.rvy = ((CircularImageView)this.contentView);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37099);
    if ((this.contentView == null) || (this.rvy == null))
    {
      AppMethodBeat.o(37099);
      return;
    }
    o localo = (o)this.rve;
    if (localo == null)
    {
      AppMethodBeat.o(37099);
      return;
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localo.rsw, localo.rsJ, new f.a()
    {
      public final void abi(String paramAnonymousString)
      {
        AppMethodBeat.i(37096);
        l locall;
        try
        {
          paramAnonymousString = BitmapFactory.decodeFile(paramAnonymousString);
          locall = l.this;
          if (paramAnonymousString == null)
          {
            ab.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
            AppMethodBeat.o(37096);
            return;
          }
          if (locall.rvy == null)
          {
            ab.e("AdLandingPageCircleImgComp", "when set image the img is null!");
            AppMethodBeat.o(37096);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          ab.e("AdLandingPageCircleImgComp", "%s" + bo.l(paramAnonymousString));
          AppMethodBeat.o(37096);
          return;
        }
        if (paramAnonymousString.getWidth() == 0)
        {
          ab.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
          AppMethodBeat.o(37096);
          return;
        }
        locall.rvy.setImageBitmap(paramAnonymousString);
        AppMethodBeat.o(37096);
      }
      
      public final void coe() {}
      
      public final void cqU() {}
    });
    AppMethodBeat.o(37099);
  }
  
  protected final void cqQ()
  {
    AppMethodBeat.i(37097);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.rve.paddingLeft, (int)this.rve.paddingTop, (int)this.rve.paddingRight, (int)this.rve.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37097);
  }
  
  protected final View cqR()
  {
    AppMethodBeat.i(37098);
    CircularImageView localCircularImageView = new CircularImageView(this.context);
    AppMethodBeat.o(37098);
    return localCircularImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l
 * JD-Core Version:    0.7.0.1
 */