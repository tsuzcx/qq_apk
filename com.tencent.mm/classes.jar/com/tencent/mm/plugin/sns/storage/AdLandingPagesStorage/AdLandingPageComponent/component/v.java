package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class v
  extends a
{
  private l ymw;
  LinearLayout yoD;
  
  public v(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    super(paramContext, paramy, paramViewGroup);
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96623);
    this.yoD = ((LinearLayout)this.contentView.findViewById(2131304906));
    AppMethodBeat.o(96623);
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96621);
    super.dJX();
    Iterator localIterator = this.ymw.dLn().iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dJX();
    }
    AppMethodBeat.o(96621);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96616);
    Iterator localIterator = this.ymw.dLn().iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dKC()) {
        localk.dJY();
      }
    }
    super.dJY();
    AppMethodBeat.o(96616);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96620);
    Iterator localIterator = this.ymw.dLn().iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dJZ();
    }
    super.dJZ();
    AppMethodBeat.o(96620);
  }
  
  public final void dKa()
  {
    AppMethodBeat.i(96617);
    Iterator localIterator = this.ymw.dLn().iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dKC()) {
        localk.dKa();
      }
    }
    super.dKa();
    AppMethodBeat.o(96617);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96622);
    if (((y)this.ymQ).yjD == 0) {
      this.yoD.setOrientation(1);
    }
    while (this.ymw == null)
    {
      this.ymw = new l(((y)this.ymQ).yjC, this.context, this.yoD);
      this.ymw.layout();
      AppMethodBeat.o(96622);
      return;
      if (((y)this.ymQ).yjD == 1) {
        this.yoD.setOrientation(0);
      }
    }
    this.ymw.fE(((y)this.ymQ).yjC);
    AppMethodBeat.o(96622);
  }
  
  protected final void dKs()
  {
    AppMethodBeat.i(96619);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.ymQ.paddingLeft, (int)this.ymQ.paddingTop, (int)this.ymQ.paddingRight, (int)this.ymQ.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96619);
  }
  
  public final void dKt()
  {
    AppMethodBeat.i(96618);
    Iterator localIterator = this.ymw.dLn().iterator();
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
    AppMethodBeat.o(96618);
  }
  
  public final List<k> dKu()
  {
    AppMethodBeat.i(96624);
    ArrayList localArrayList = new ArrayList(this.ymw.dLn());
    AppMethodBeat.o(96624);
    return localArrayList;
  }
  
  protected final int getLayout()
  {
    return 2131495504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v
 * JD-Core Version:    0.7.0.1
 */