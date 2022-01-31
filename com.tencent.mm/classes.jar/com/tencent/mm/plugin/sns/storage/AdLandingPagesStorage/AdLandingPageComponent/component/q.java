package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class q
  extends a
{
  private l ruW;
  LinearLayout rwE;
  
  public q(Context paramContext, u paramu, ViewGroup paramViewGroup)
  {
    super(paramContext, paramu, paramViewGroup);
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(37195);
    Iterator localIterator = this.ruW.crG().iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh.cqX()) {
        localh.cqA();
      }
    }
    super.cqA();
    AppMethodBeat.o(37195);
  }
  
  public final void cqB()
  {
    AppMethodBeat.i(37199);
    Iterator localIterator = this.ruW.crG().iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).cqB();
    }
    super.cqB();
    AppMethodBeat.o(37199);
  }
  
  public final void cqC()
  {
    AppMethodBeat.i(37196);
    Iterator localIterator = this.ruW.crG().iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh.cqX()) {
        localh.cqC();
      }
    }
    super.cqC();
    AppMethodBeat.o(37196);
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37202);
    this.rwE = ((LinearLayout)this.contentView.findViewById(2131827858));
    AppMethodBeat.o(37202);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37201);
    if (((u)this.rve).rsT == 0) {
      this.rwE.setOrientation(1);
    }
    while (this.ruW == null)
    {
      this.ruW = new l(((u)this.rve).rsS, this.context, this.rwE);
      this.ruW.layout();
      AppMethodBeat.o(37201);
      return;
      if (((u)this.rve).rsT == 1) {
        this.rwE.setOrientation(0);
      }
    }
    this.ruW.dg(((u)this.rve).rsS);
    AppMethodBeat.o(37201);
  }
  
  protected final void cqQ()
  {
    AppMethodBeat.i(37198);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.rve.paddingLeft, (int)this.rve.paddingTop, (int)this.rve.paddingRight, (int)this.rve.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37198);
  }
  
  public final void cqS()
  {
    AppMethodBeat.i(37197);
    Iterator localIterator = this.ruW.crG().iterator();
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
    AppMethodBeat.o(37197);
  }
  
  public final List<h> cqT()
  {
    AppMethodBeat.i(37203);
    ArrayList localArrayList = new ArrayList(this.ruW.crG());
    AppMethodBeat.o(37203);
    return localArrayList;
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(37200);
    super.cqz();
    Iterator localIterator = this.ruW.crG().iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).cqz();
    }
    AppMethodBeat.o(37200);
  }
  
  protected final int getLayout()
  {
    return 2130970784;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
 * JD-Core Version:    0.7.0.1
 */