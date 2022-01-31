package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;

public final class m
  extends a
{
  CircularImageView oFU;
  
  public m(Context paramContext, p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
  }
  
  public final View bFf()
  {
    this.oFU = ((CircularImageView)this.contentView);
    return this.contentView;
  }
  
  protected final void bFj()
  {
    if ((this.contentView == null) || (this.oFU == null)) {}
    p localp;
    do
    {
      return;
      localp = (p)this.oFE;
    } while (localp == null);
    h.a(localp.oCV, localp.oDh, new m.1(this));
  }
  
  protected final View bFk()
  {
    return new CircularImageView(this.context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
 * JD-Core Version:    0.7.0.1
 */