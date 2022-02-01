package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class t
  extends a
{
  private l JAh;
  private y KrO;
  private CustomScrollView KrP;
  List<m> ayS;
  
  public t(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    super(paramContext, paramy, paramViewGroup);
    AppMethodBeat.i(96563);
    this.KrO = paramy;
    this.ayS = new ArrayList();
    AppMethodBeat.o(96563);
  }
  
  public final void c(aa paramaa)
  {
    AppMethodBeat.i(96572);
    if ((paramaa instanceof y)) {
      this.KrO = ((y)paramaa);
    }
    super.c(paramaa);
    AppMethodBeat.o(96572);
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(96564);
    if (this.JAh == null)
    {
      this.JAh = new l(this.KrO.ayS, this.context, this.KrP);
      this.JAh.fP();
      this.ayS = fKf();
    }
    for (;;)
    {
      if (getGravity() == 0)
      {
        ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.KqB.paddingLeft, (int)this.KqB.paddingTop, (int)this.KqB.paddingRight, (int)this.KqB.paddingBottom);
        }
        this.contentView.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(96564);
      return;
      this.JAh.notify(this.KrO.ayS);
    }
  }
  
  public final List<m> fKf()
  {
    AppMethodBeat.i(96571);
    ArrayList localArrayList = new ArrayList(this.JAh.fRQ());
    AppMethodBeat.o(96571);
    return localArrayList;
  }
  
  protected final View fKj()
  {
    AppMethodBeat.i(96565);
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = new RoundedCornerFrameLayout(this.context);
    this.KrP = new CustomScrollView(this.context);
    this.KrP.setOverScrollMode(2);
    this.KrP.setHorizontalScrollBarEnabled(false);
    this.KrP.setVerticalScrollBarEnabled(false);
    this.KrP.setOnScrollChangeListener(new CustomScrollView.a()
    {
      public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(96562);
        paramAnonymousScrollView = t.this.ayS.iterator();
        while (paramAnonymousScrollView.hasNext())
        {
          m localm = (m)paramAnonymousScrollView.next();
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
        AppMethodBeat.o(96562);
      }
    });
    localRoundedCornerFrameLayout.setBackgroundColor(this.backgroundColor);
    localRoundedCornerFrameLayout.addView(this.KrP);
    localRoundedCornerFrameLayout.setRadius(this.KrO.cornerRadius);
    AppMethodBeat.o(96565);
    return localRoundedCornerFrameLayout;
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96566);
    Iterator localIterator = this.ayS.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fRj()) {
        localm.fKk();
      }
    }
    super.fKk();
    AppMethodBeat.o(96566);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(96567);
    Iterator localIterator = this.ayS.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).fKl();
    }
    super.fKl();
    AppMethodBeat.o(96567);
  }
  
  public final void fKm()
  {
    AppMethodBeat.i(96568);
    Iterator localIterator = this.ayS.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fRj()) {
        localm.fKm();
      }
    }
    super.fKm();
    AppMethodBeat.o(96568);
  }
  
  public final void fKn()
  {
    AppMethodBeat.i(96569);
    Iterator localIterator = this.ayS.iterator();
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
    AppMethodBeat.o(96569);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96570);
    super.fKo();
    Iterator localIterator = this.ayS.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).fKo();
    }
    AppMethodBeat.o(96570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t
 * JD-Core Version:    0.7.0.1
 */