package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class r
  extends a
{
  List<k> buB;
  private l wZJ;
  private v xbl;
  private CustomScrollView xbm;
  
  public r(Context paramContext, v paramv, ViewGroup paramViewGroup)
  {
    super(paramContext, paramv, paramViewGroup);
    AppMethodBeat.i(96563);
    this.xbl = paramv;
    this.buB = new ArrayList();
    AppMethodBeat.o(96563);
  }
  
  public final void a(x paramx)
  {
    AppMethodBeat.i(96572);
    if ((paramx instanceof v)) {
      this.xbl = ((v)paramx);
    }
    super.a(paramx);
    AppMethodBeat.o(96572);
  }
  
  public final void dvA()
  {
    AppMethodBeat.i(96567);
    Iterator localIterator = this.buB.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dvA();
    }
    super.dvA();
    AppMethodBeat.o(96567);
  }
  
  public final void dvB()
  {
    AppMethodBeat.i(96568);
    Iterator localIterator = this.buB.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dwd()) {
        localk.dvB();
      }
    }
    super.dvB();
    AppMethodBeat.o(96568);
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96564);
    if (this.wZJ == null)
    {
      this.wZJ = new l(this.xbl.buB, this.context, this.xbm);
      this.wZJ.layout();
      this.buB = dvV();
    }
    for (;;)
    {
      if (getGravity() == 0)
      {
        ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.xab.paddingLeft, (int)this.xab.paddingTop, (int)this.xab.paddingRight, (int)this.xab.paddingBottom);
        }
        this.contentView.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(96564);
      return;
      this.wZJ.fw(this.xbl.buB);
    }
  }
  
  protected final View dvQ()
  {
    AppMethodBeat.i(96565);
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = new RoundedCornerFrameLayout(this.context);
    this.xbm = new CustomScrollView(this.context);
    this.xbm.setOverScrollMode(2);
    this.xbm.setHorizontalScrollBarEnabled(false);
    this.xbm.setVerticalScrollBarEnabled(false);
    this.xbm.setOnScrollChangeListener(new CustomScrollView.a()
    {
      public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(96562);
        paramAnonymousScrollView = r.this.buB.iterator();
        while (paramAnonymousScrollView.hasNext())
        {
          k localk = (k)paramAnonymousScrollView.next();
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
        AppMethodBeat.o(96562);
      }
    });
    localRoundedCornerFrameLayout.setBackgroundColor(this.backgroundColor);
    localRoundedCornerFrameLayout.addView(this.xbm);
    localRoundedCornerFrameLayout.setRadius(this.xbl.eN);
    AppMethodBeat.o(96565);
    return localRoundedCornerFrameLayout;
  }
  
  public final void dvU()
  {
    AppMethodBeat.i(96569);
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
    AppMethodBeat.o(96569);
  }
  
  public final List<k> dvV()
  {
    AppMethodBeat.i(96571);
    ArrayList localArrayList = new ArrayList(this.wZJ.dwO());
    AppMethodBeat.o(96571);
    return localArrayList;
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96570);
    super.dvy();
    Iterator localIterator = this.buB.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dvy();
    }
    AppMethodBeat.o(96570);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96566);
    Iterator localIterator = this.buB.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dwd()) {
        localk.dvz();
      }
    }
    super.dvz();
    AppMethodBeat.o(96566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r
 * JD-Core Version:    0.7.0.1
 */