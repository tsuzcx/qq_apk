package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.as;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class aa
  extends a
{
  private q PPI;
  LinearLayout QQR;
  
  public aa(Context paramContext, ab paramab, ViewGroup paramViewGroup)
  {
    super(paramContext, paramab, paramViewGroup);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96623);
    this.QQR = ((LinearLayout)this.contentView.findViewById(b.f.sns_ad_native_landing_pages_item_page_linear_layout));
    AppMethodBeat.o(96623);
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_linear_layout;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96622);
    if (((ab)this.QOV).QKW == 0)
    {
      this.QQR.setOrientation(1);
      if (this.PPI != null) {
        break label117;
      }
      this.PPI = new q(((ab)this.QOV).QKV, this.context, this.QQR);
      this.PPI.CY();
    }
    for (;;)
    {
      as.a(this.contentView, ((ab)this.QOV).QKF);
      AppMethodBeat.o(96622);
      return;
      if (((ab)this.QOV).QKW != 1) {
        break;
      }
      this.QQR.setOrientation(0);
      break;
      label117:
      this.PPI.notify(((ab)this.QOV).QKV);
    }
  }
  
  public final List<n> hai()
  {
    AppMethodBeat.i(96624);
    ArrayList localArrayList = new ArrayList(this.PPI.hjV());
    AppMethodBeat.o(96624);
    return localArrayList;
  }
  
  protected final void hal()
  {
    AppMethodBeat.i(96619);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.QOV.paddingLeft, (int)this.QOV.paddingTop, (int)this.QOV.paddingRight, (int)this.QOV.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96619);
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96616);
    Iterator localIterator = this.PPI.hjV().iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.hji()) {
        localn.hao();
      }
    }
    super.hao();
    AppMethodBeat.o(96616);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(96620);
    Iterator localIterator = this.PPI.hjV().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).hap();
    }
    super.hap();
    AppMethodBeat.o(96620);
  }
  
  public final void haq()
  {
    AppMethodBeat.i(96617);
    Iterator localIterator = this.PPI.hjV().iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.hji()) {
        localn.haq();
      }
    }
    super.haq();
    AppMethodBeat.o(96617);
  }
  
  public final void har()
  {
    AppMethodBeat.i(96618);
    Iterator localIterator = this.PPI.hjV().iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.hji())
      {
        localn.hao();
        localn.haq();
      }
      else
      {
        localn.hap();
      }
    }
    AppMethodBeat.o(96618);
  }
  
  public final void has()
  {
    AppMethodBeat.i(96621);
    super.has();
    Iterator localIterator = this.PPI.hjV().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).has();
    }
    AppMethodBeat.o(96621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa
 * JD-Core Version:    0.7.0.1
 */