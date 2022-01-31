package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends a
{
  private List<h> aWy;
  private s ruV;
  private l ruW;
  
  public d(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
    AppMethodBeat.i(37038);
    this.ruV = params;
    this.aWy = new ArrayList();
    AppMethodBeat.o(37038);
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(37048);
    if ((paramt instanceof s)) {
      this.ruV = ((s)paramt);
    }
    super.a(paramt);
    AppMethodBeat.o(37048);
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(37042);
    Iterator localIterator = this.aWy.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh.cqX()) {
        localh.cqA();
      }
    }
    super.cqA();
    AppMethodBeat.o(37042);
  }
  
  public final void cqB()
  {
    AppMethodBeat.i(37043);
    Iterator localIterator = this.aWy.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).cqB();
    }
    super.cqB();
    AppMethodBeat.o(37043);
  }
  
  public final void cqC()
  {
    AppMethodBeat.i(37044);
    Iterator localIterator = this.aWy.iterator();
    while (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      if (localh.cqX()) {
        localh.cqC();
      }
    }
    super.cqC();
    AppMethodBeat.o(37044);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37039);
    if (this.ruW == null)
    {
      this.ruW = new l(this.ruV.aWy, this.context, (FrameLayout)this.contentView);
      this.ruW.layout();
      this.aWy = cqT();
      AppMethodBeat.o(37039);
      return;
    }
    this.ruW.dg(this.ruV.aWy);
    AppMethodBeat.o(37039);
  }
  
  protected final void cqQ()
  {
    AppMethodBeat.i(37040);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.rve.paddingLeft, (int)this.rve.paddingTop, (int)this.rve.paddingRight, (int)this.rve.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37040);
  }
  
  protected final View cqR()
  {
    AppMethodBeat.i(37041);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(37041);
    return localFrameLayout;
  }
  
  public final void cqS()
  {
    AppMethodBeat.i(37045);
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
    AppMethodBeat.o(37045);
  }
  
  public final List<h> cqT()
  {
    AppMethodBeat.i(37047);
    ArrayList localArrayList = new ArrayList(this.ruW.crG());
    AppMethodBeat.o(37047);
    return localArrayList;
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(37046);
    super.cqz();
    Iterator localIterator = this.aWy.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).cqz();
    }
    AppMethodBeat.o(37046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d
 * JD-Core Version:    0.7.0.1
 */