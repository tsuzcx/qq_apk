package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends a
{
  private List<k> buB;
  private w wZI;
  private l wZJ;
  
  public f(Context paramContext, w paramw, ViewGroup paramViewGroup)
  {
    super(paramContext, paramw, paramViewGroup);
    AppMethodBeat.i(96438);
    this.wZI = paramw;
    this.buB = new ArrayList();
    AppMethodBeat.o(96438);
  }
  
  public final void a(x paramx)
  {
    AppMethodBeat.i(96448);
    if ((paramx instanceof w)) {
      this.wZI = ((w)paramx);
    }
    super.a(paramx);
    AppMethodBeat.o(96448);
  }
  
  public final void dvA()
  {
    AppMethodBeat.i(96443);
    Iterator localIterator = this.buB.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dvA();
    }
    super.dvA();
    AppMethodBeat.o(96443);
  }
  
  public final void dvB()
  {
    AppMethodBeat.i(96444);
    Iterator localIterator = this.buB.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dwd()) {
        localk.dvB();
      }
    }
    super.dvB();
    AppMethodBeat.o(96444);
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96439);
    if (this.wZJ == null)
    {
      this.wZJ = new l(this.wZI.buB, this.context, (FrameLayout)this.contentView);
      this.wZJ.layout();
      this.buB = dvV();
      AppMethodBeat.o(96439);
      return;
    }
    this.wZJ.fw(this.wZI.buB);
    AppMethodBeat.o(96439);
  }
  
  protected final View dvQ()
  {
    AppMethodBeat.i(96441);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(96441);
    return localFrameLayout;
  }
  
  protected final void dvT()
  {
    AppMethodBeat.i(96440);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.xab.paddingLeft, (int)this.xab.paddingTop, (int)this.xab.paddingRight, (int)this.xab.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96440);
  }
  
  public final void dvU()
  {
    AppMethodBeat.i(96445);
    Iterator localIterator = this.buB.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dwd())
      {
        localk.dvz();
        localk.dvB();
      }
      else
      {
        localk.dvA();
      }
    }
    AppMethodBeat.o(96445);
  }
  
  public final List<k> dvV()
  {
    AppMethodBeat.i(96447);
    ArrayList localArrayList = new ArrayList(this.wZJ.dwO());
    AppMethodBeat.o(96447);
    return localArrayList;
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96446);
    super.dvy();
    Iterator localIterator = this.buB.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dvy();
    }
    AppMethodBeat.o(96446);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96442);
    Iterator localIterator = this.buB.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dwd()) {
        localk.dvz();
      }
    }
    super.dvz();
    AppMethodBeat.o(96442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f
 * JD-Core Version:    0.7.0.1
 */