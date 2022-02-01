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
  private List<k> bsA;
  private w ymv;
  private l ymw;
  
  public f(Context paramContext, w paramw, ViewGroup paramViewGroup)
  {
    super(paramContext, paramw, paramViewGroup);
    AppMethodBeat.i(96438);
    this.ymv = paramw;
    this.bsA = new ArrayList();
    AppMethodBeat.o(96438);
  }
  
  public final void a(x paramx)
  {
    AppMethodBeat.i(96448);
    if ((paramx instanceof w)) {
      this.ymv = ((w)paramx);
    }
    super.a(paramx);
    AppMethodBeat.o(96448);
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96446);
    super.dJX();
    Iterator localIterator = this.bsA.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dJX();
    }
    AppMethodBeat.o(96446);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96442);
    Iterator localIterator = this.bsA.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dKC()) {
        localk.dJY();
      }
    }
    super.dJY();
    AppMethodBeat.o(96442);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96443);
    Iterator localIterator = this.bsA.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dJZ();
    }
    super.dJZ();
    AppMethodBeat.o(96443);
  }
  
  public final void dKa()
  {
    AppMethodBeat.i(96444);
    Iterator localIterator = this.bsA.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dKC()) {
        localk.dKa();
      }
    }
    super.dKa();
    AppMethodBeat.o(96444);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96439);
    if (this.ymw == null)
    {
      this.ymw = new l(this.ymv.bsA, this.context, (FrameLayout)this.contentView);
      this.ymw.layout();
      this.bsA = dKu();
      AppMethodBeat.o(96439);
      return;
    }
    this.ymw.fE(this.ymv.bsA);
    AppMethodBeat.o(96439);
  }
  
  protected final View dKp()
  {
    AppMethodBeat.i(96441);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(96441);
    return localFrameLayout;
  }
  
  protected final void dKs()
  {
    AppMethodBeat.i(96440);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.ymQ.paddingLeft, (int)this.ymQ.paddingTop, (int)this.ymQ.paddingRight, (int)this.ymQ.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96440);
  }
  
  public final void dKt()
  {
    AppMethodBeat.i(96445);
    Iterator localIterator = this.bsA.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dKC())
      {
        localk.dJY();
        localk.dKa();
      }
      else
      {
        localk.dJZ();
      }
    }
    AppMethodBeat.o(96445);
  }
  
  public final List<k> dKu()
  {
    AppMethodBeat.i(96447);
    ArrayList localArrayList = new ArrayList(this.ymw.dLn());
    AppMethodBeat.o(96447);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f
 * JD-Core Version:    0.7.0.1
 */