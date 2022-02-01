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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class w
  extends a
{
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l zDl;
  LinearLayout zFy;
  
  public w(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    super(paramContext, paramy, paramViewGroup);
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(96623);
    this.zFy = ((LinearLayout)this.contentView.findViewById(2131304906));
    AppMethodBeat.o(96623);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96622);
    if (((y)this.zDK).zAr == 0) {
      this.zFy.setOrientation(1);
    }
    while (this.zDl == null)
    {
      this.zDl = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l(((y)this.zDK).zAq, this.context, this.zFy);
      this.zDl.layout();
      AppMethodBeat.o(96622);
      return;
      if (((y)this.zDK).zAr == 1) {
        this.zFy.setOrientation(0);
      }
    }
    this.zDl.fP(((y)this.zDK).zAq);
    AppMethodBeat.o(96622);
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(96616);
    Iterator localIterator = this.zDl.dXE().iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (locall.dWU()) {
        locall.dRm();
      }
    }
    super.dRm();
    AppMethodBeat.o(96616);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96620);
    Iterator localIterator = this.zDl.dXE().iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).dRn();
    }
    super.dRn();
    AppMethodBeat.o(96620);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96621);
    super.dRo();
    Iterator localIterator = this.zDl.dXE().iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).dRo();
    }
    AppMethodBeat.o(96621);
  }
  
  protected final void dWF()
  {
    AppMethodBeat.i(96619);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zDK.paddingLeft, (int)this.zDK.paddingTop, (int)this.zDK.paddingRight, (int)this.zDK.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96619);
  }
  
  public final void dWG()
  {
    AppMethodBeat.i(96618);
    Iterator localIterator = this.zDl.dXE().iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (locall.dWU())
      {
        locall.dRm();
        locall.dWm();
      }
      else
      {
        locall.dRn();
      }
    }
    AppMethodBeat.o(96618);
  }
  
  public final List<l> dWH()
  {
    AppMethodBeat.i(96624);
    ArrayList localArrayList = new ArrayList(this.zDl.dXE());
    AppMethodBeat.o(96624);
    return localArrayList;
  }
  
  public final void dWm()
  {
    AppMethodBeat.i(96617);
    Iterator localIterator = this.zDl.dXE().iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (locall.dWU()) {
        locall.dWm();
      }
    }
    super.dWm();
    AppMethodBeat.o(96617);
  }
  
  protected final int getLayout()
  {
    return 2131495504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w
 * JD-Core Version:    0.7.0.1
 */