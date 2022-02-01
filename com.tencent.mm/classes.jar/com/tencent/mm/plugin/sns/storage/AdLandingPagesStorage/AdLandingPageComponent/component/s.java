package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class s
  extends n
{
  CircularImageView QPw;
  
  public s(Context paramContext, u paramu, ViewGroup paramViewGroup)
  {
    super(paramContext, paramu, paramViewGroup);
  }
  
  public final void Gs()
  {
    this.QPw = ((CircularImageView)this.contentView);
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96504);
    if ((this.contentView == null) || (this.QPw == null))
    {
      AppMethodBeat.o(96504);
      return;
    }
    u localu = (u)this.QOV;
    if (localu == null)
    {
      AppMethodBeat.o(96504);
      return;
    }
    k.b("adId", localu.QKj, new g.a()
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(96501);
        s locals;
        try
        {
          paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
          locals = s.this;
          if (paramAnonymousString == null)
          {
            Log.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
            AppMethodBeat.o(96501);
            return;
          }
          if (locals.QPw == null)
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
        locals.QPw.setImageBitmap(paramAnonymousString);
        AppMethodBeat.o(96501);
      }
      
      public final void gZM() {}
      
      public final void gZN() {}
    });
    AppMethodBeat.o(96504);
  }
  
  protected final void hal()
  {
    AppMethodBeat.i(96502);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.QOV.paddingLeft, (int)this.QOV.paddingTop, (int)this.QOV.paddingRight, (int)this.QOV.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96502);
  }
  
  protected final View ham()
  {
    AppMethodBeat.i(96503);
    CircularImageView localCircularImageView = new CircularImageView(this.context);
    AppMethodBeat.o(96503);
    return localCircularImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s
 * JD-Core Version:    0.7.0.1
 */