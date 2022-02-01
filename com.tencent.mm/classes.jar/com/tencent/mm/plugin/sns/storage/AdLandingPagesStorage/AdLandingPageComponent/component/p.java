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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;

public final class p
  extends k
{
  CircularImageView ynq;
  
  public p(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
  }
  
  public final void dJW()
  {
    this.ynq = ((CircularImageView)this.contentView);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96504);
    if ((this.contentView == null) || (this.ynq == null))
    {
      AppMethodBeat.o(96504);
      return;
    }
    s locals = (s)this.ymQ;
    if (locals == null)
    {
      AppMethodBeat.o(96504);
      return;
    }
    h.a(locals.yjd, locals.yjt, new f.a()
    {
      public final void asD(String paramAnonymousString)
      {
        AppMethodBeat.i(96501);
        p localp;
        try
        {
          paramAnonymousString = f.decodeFile(paramAnonymousString);
          localp = p.this;
          if (paramAnonymousString == null)
          {
            ac.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
            AppMethodBeat.o(96501);
            return;
          }
          if (localp.ynq == null)
          {
            ac.e("AdLandingPageCircleImgComp", "when set image the img is null!");
            AppMethodBeat.o(96501);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          ac.e("AdLandingPageCircleImgComp", "%s" + bs.m(paramAnonymousString));
          AppMethodBeat.o(96501);
          return;
        }
        if (paramAnonymousString.getWidth() == 0)
        {
          ac.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
          AppMethodBeat.o(96501);
          return;
        }
        localp.ynq.setImageBitmap(paramAnonymousString);
        AppMethodBeat.o(96501);
      }
      
      public final void dFC() {}
      
      public final void dFD() {}
    });
    AppMethodBeat.o(96504);
  }
  
  protected final View dKp()
  {
    AppMethodBeat.i(96503);
    CircularImageView localCircularImageView = new CircularImageView(this.context);
    AppMethodBeat.o(96503);
    return localCircularImageView;
  }
  
  protected final void dKs()
  {
    AppMethodBeat.i(96502);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.ymQ.paddingLeft, (int)this.ymQ.paddingTop, (int)this.ymQ.paddingRight, (int)this.ymQ.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p
 * JD-Core Version:    0.7.0.1
 */