package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.widget.RoundedCornerRelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class n
  extends a
{
  List<h> aWy;
  private l ruW;
  private r rwf;
  private CustomScrollView rwg;
  
  public n(Context paramContext, r paramr, ViewGroup paramViewGroup)
  {
    super(paramContext, paramr, paramViewGroup);
    AppMethodBeat.i(37153);
    this.rwf = paramr;
    this.aWy = new ArrayList();
    AppMethodBeat.o(37153);
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(37162);
    if ((paramt instanceof r)) {
      this.rwf = ((r)paramt);
    }
    super.a(paramt);
    AppMethodBeat.o(37162);
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(37156);
    Iterator localIterator = this.aWy.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh.cqX()) {
        localh.cqA();
      }
    }
    super.cqA();
    AppMethodBeat.o(37156);
  }
  
  public final void cqB()
  {
    AppMethodBeat.i(37157);
    Iterator localIterator = this.aWy.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).cqB();
    }
    super.cqB();
    AppMethodBeat.o(37157);
  }
  
  public final void cqC()
  {
    AppMethodBeat.i(37158);
    Iterator localIterator = this.aWy.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh.cqX()) {
        localh.cqC();
      }
    }
    super.cqC();
    AppMethodBeat.o(37158);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37154);
    if (this.ruW == null)
    {
      this.ruW = new l(this.rwf.aWy, this.context, this.rwg);
      this.ruW.layout();
      this.aWy = cqT();
    }
    for (;;)
    {
      if (getGravity() == 0)
      {
        ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.rve.paddingLeft, (int)this.rve.paddingTop, (int)this.rve.paddingRight, (int)this.rve.paddingBottom);
        }
        this.contentView.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(37154);
      return;
      this.ruW.dg(this.rwf.aWy);
    }
  }
  
  protected final View cqR()
  {
    AppMethodBeat.i(37155);
    RoundedCornerRelativeLayout localRoundedCornerRelativeLayout = new RoundedCornerRelativeLayout(this.context);
    this.rwg = new CustomScrollView(this.context);
    this.rwg.setOverScrollMode(2);
    this.rwg.setHorizontalScrollBarEnabled(false);
    this.rwg.setVerticalScrollBarEnabled(false);
    this.rwg.setOnScrollChangeListener(new n.1(this));
    localRoundedCornerRelativeLayout.setBackgroundColor(this.backgroundColor);
    localRoundedCornerRelativeLayout.addView(this.rwg);
    localRoundedCornerRelativeLayout.setRadius(this.rwf.rsH);
    AppMethodBeat.o(37155);
    return localRoundedCornerRelativeLayout;
  }
  
  public final void cqS()
  {
    AppMethodBeat.i(37159);
    Iterator localIterator = this.aWy.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh.cqX())
      {
        localh.cqA();
        localh.cqC();
      }
      else
      {
        localh.cqB();
      }
    }
    AppMethodBeat.o(37159);
  }
  
  public final List<h> cqT()
  {
    AppMethodBeat.i(37161);
    ArrayList localArrayList = new ArrayList(this.ruW.crG());
    AppMethodBeat.o(37161);
    return localArrayList;
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(37160);
    super.cqz();
    Iterator localIterator = this.aWy.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).cqz();
    }
    AppMethodBeat.o(37160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n
 * JD-Core Version:    0.7.0.1
 */