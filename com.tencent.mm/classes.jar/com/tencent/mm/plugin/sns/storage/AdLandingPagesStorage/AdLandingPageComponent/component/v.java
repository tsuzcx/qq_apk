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
  private l wZJ;
  LinearLayout xbO;
  
  public v(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    super(paramContext, paramy, paramViewGroup);
  }
  
  public final void dvA()
  {
    AppMethodBeat.i(96620);
    Iterator localIterator = this.wZJ.dwO().iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dvA();
    }
    super.dvA();
    AppMethodBeat.o(96620);
  }
  
  public final void dvB()
  {
    AppMethodBeat.i(96617);
    Iterator localIterator = this.wZJ.dwO().iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dwd()) {
        localk.dvB();
      }
    }
    super.dvB();
    AppMethodBeat.o(96617);
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96622);
    if (((y)this.xab).wWP == 0) {
      this.xbO.setOrientation(1);
    }
    while (this.wZJ == null)
    {
      this.wZJ = new l(((y)this.xab).wWO, this.context, this.xbO);
      this.wZJ.layout();
      AppMethodBeat.o(96622);
      return;
      if (((y)this.xab).wWP == 1) {
        this.xbO.setOrientation(0);
      }
    }
    this.wZJ.fw(((y)this.xab).wWO);
    AppMethodBeat.o(96622);
  }
  
  protected final void dvT()
  {
    AppMethodBeat.i(96619);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.xab.paddingLeft, (int)this.xab.paddingTop, (int)this.xab.paddingRight, (int)this.xab.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96619);
  }
  
  public final void dvU()
  {
    AppMethodBeat.i(96618);
    Iterator localIterator = this.wZJ.dwO().iterator();
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
    AppMethodBeat.o(96618);
  }
  
  public final List<k> dvV()
  {
    AppMethodBeat.i(96624);
    ArrayList localArrayList = new ArrayList(this.wZJ.dwO());
    AppMethodBeat.o(96624);
    return localArrayList;
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(96623);
    this.xbO = ((LinearLayout)this.contentView.findViewById(2131304906));
    AppMethodBeat.o(96623);
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96621);
    super.dvy();
    Iterator localIterator = this.wZJ.dwO().iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dvy();
    }
    AppMethodBeat.o(96621);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96616);
    Iterator localIterator = this.wZJ.dwO().iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dwd()) {
        localk.dvz();
      }
    }
    super.dvz();
    AppMethodBeat.o(96616);
  }
  
  protected final int getLayout()
  {
    return 2131495504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v
 * JD-Core Version:    0.7.0.1
 */