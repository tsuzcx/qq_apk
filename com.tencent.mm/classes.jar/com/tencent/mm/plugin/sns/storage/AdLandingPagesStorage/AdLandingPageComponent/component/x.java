package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aq;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class x
  extends a
{
  private l JAh;
  LinearLayout Kst;
  
  public x(Context paramContext, ab paramab, ViewGroup paramViewGroup)
  {
    super(paramContext, paramab, paramViewGroup);
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(96622);
    if (((ab)this.KqB).KmR == 0)
    {
      this.Kst.setOrientation(1);
      if (this.JAh != null) {
        break label117;
      }
      this.JAh = new l(((ab)this.KqB).KmQ, this.context, this.Kst);
      this.JAh.fP();
    }
    for (;;)
    {
      aq.a(this.contentView, ((ab)this.KqB).KmA);
      AppMethodBeat.o(96622);
      return;
      if (((ab)this.KqB).KmR != 1) {
        break;
      }
      this.Kst.setOrientation(0);
      break;
      label117:
      this.JAh.notify(((ab)this.KqB).KmQ);
    }
  }
  
  public final List<m> fKf()
  {
    AppMethodBeat.i(96624);
    ArrayList localArrayList = new ArrayList(this.JAh.fRQ());
    AppMethodBeat.o(96624);
    return localArrayList;
  }
  
  protected final void fKi()
  {
    AppMethodBeat.i(96619);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.KqB.paddingLeft, (int)this.KqB.paddingTop, (int)this.KqB.paddingRight, (int)this.KqB.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96619);
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96616);
    Iterator localIterator = this.JAh.fRQ().iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fRj()) {
        localm.fKk();
      }
    }
    super.fKk();
    AppMethodBeat.o(96616);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(96620);
    Iterator localIterator = this.JAh.fRQ().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).fKl();
    }
    super.fKl();
    AppMethodBeat.o(96620);
  }
  
  public final void fKm()
  {
    AppMethodBeat.i(96617);
    Iterator localIterator = this.JAh.fRQ().iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fRj()) {
        localm.fKm();
      }
    }
    super.fKm();
    AppMethodBeat.o(96617);
  }
  
  public final void fKn()
  {
    AppMethodBeat.i(96618);
    Iterator localIterator = this.JAh.fRQ().iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fRj())
      {
        localm.fKk();
        localm.fKm();
      }
      else
      {
        localm.fKl();
      }
    }
    AppMethodBeat.o(96618);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96621);
    super.fKo();
    Iterator localIterator = this.JAh.fRQ().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).fKo();
    }
    AppMethodBeat.o(96621);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96623);
    this.Kst = ((LinearLayout)this.contentView.findViewById(i.f.sns_ad_native_landing_pages_item_page_linear_layout));
    AppMethodBeat.o(96623);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_linear_layout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x
 * JD-Core Version:    0.7.0.1
 */