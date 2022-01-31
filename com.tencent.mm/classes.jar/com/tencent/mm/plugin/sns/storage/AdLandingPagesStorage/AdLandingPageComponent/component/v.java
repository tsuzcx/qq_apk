package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends h
{
  TextView euY;
  private RelativeLayout rxv;
  ImageView rxw;
  
  public v(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v paramv, ViewGroup paramViewGroup)
  {
    super(paramContext, paramv, paramViewGroup);
    this.rve = paramv;
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(37261);
    super.cqA();
    AppMethodBeat.o(37261);
  }
  
  public final void cqB()
  {
    AppMethodBeat.i(37262);
    super.cqB();
    AppMethodBeat.o(37262);
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37260);
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    this.euY = ((TextView)localView.findViewById(2131827861));
    this.rxv = ((RelativeLayout)localView.findViewById(2131827862));
    this.rxw = ((ImageView)localView.findViewById(2131827863));
    AppMethodBeat.o(37260);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37259);
    this.euY.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)this.rve).label);
    this.euY.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)this.rve).fontSize);
    if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)this.rve).hhh != null) && (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)this.rve).hhh.length() > 0))
    {
      int i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)this.rve).hhh);
      this.rxv.setBackgroundColor(i);
    }
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)this.rve).rsU, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)this.rve).rsJ, new v.1(this));
    AppMethodBeat.o(37259);
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(37258);
    super.cqz();
    AppMethodBeat.o(37258);
  }
  
  protected final int getLayout()
  {
    return 2130970786;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v
 * JD-Core Version:    0.7.0.1
 */