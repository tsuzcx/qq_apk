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
  List<k> bsA;
  private l ymw;
  private v yoa;
  private CustomScrollView yob;
  
  public r(Context paramContext, v paramv, ViewGroup paramViewGroup)
  {
    super(paramContext, paramv, paramViewGroup);
    AppMethodBeat.i(96563);
    this.yoa = paramv;
    this.bsA = new ArrayList();
    AppMethodBeat.o(96563);
  }
  
  public final void a(x paramx)
  {
    AppMethodBeat.i(96572);
    if ((paramx instanceof v)) {
      this.yoa = ((v)paramx);
    }
    super.a(paramx);
    AppMethodBeat.o(96572);
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96570);
    super.dJX();
    Iterator localIterator = this.bsA.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dJX();
    }
    AppMethodBeat.o(96570);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96566);
    Iterator localIterator = this.bsA.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dKC()) {
        localk.dJY();
      }
    }
    super.dJY();
    AppMethodBeat.o(96566);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96567);
    Iterator localIterator = this.bsA.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).dJZ();
    }
    super.dJZ();
    AppMethodBeat.o(96567);
  }
  
  public final void dKa()
  {
    AppMethodBeat.i(96568);
    Iterator localIterator = this.bsA.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.dKC()) {
        localk.dKa();
      }
    }
    super.dKa();
    AppMethodBeat.o(96568);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96564);
    if (this.ymw == null)
    {
      this.ymw = new l(this.yoa.bsA, this.context, this.yob);
      this.ymw.layout();
      this.bsA = dKu();
    }
    for (;;)
    {
      if (getGravity() == 0)
      {
        ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.ymQ.paddingLeft, (int)this.ymQ.paddingTop, (int)this.ymQ.paddingRight, (int)this.ymQ.paddingBottom);
        }
        this.contentView.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(96564);
      return;
      this.ymw.fE(this.yoa.bsA);
    }
  }
  
  protected final View dKp()
  {
    AppMethodBeat.i(96565);
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = new RoundedCornerFrameLayout(this.context);
    this.yob = new CustomScrollView(this.context);
    this.yob.setOverScrollMode(2);
    this.yob.setHorizontalScrollBarEnabled(false);
    this.yob.setVerticalScrollBarEnabled(false);
    this.yob.setOnScrollChangeListener(new CustomScrollView.a()
    {
      public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(96562);
        paramAnonymousScrollView = r.this.bsA.iterator();
        while (paramAnonymousScrollView.hasNext())
        {
          k localk = (k)paramAnonymousScrollView.next();
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
        AppMethodBeat.o(96562);
      }
    });
    localRoundedCornerFrameLayout.setBackgroundColor(this.backgroundColor);
    localRoundedCornerFrameLayout.addView(this.yob);
    localRoundedCornerFrameLayout.setRadius(this.yoa.fO);
    AppMethodBeat.o(96565);
    return localRoundedCornerFrameLayout;
  }
  
  public final void dKt()
  {
    AppMethodBeat.i(96569);
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
    AppMethodBeat.o(96569);
  }
  
  public final List<k> dKu()
  {
    AppMethodBeat.i(96571);
    ArrayList localArrayList = new ArrayList(this.ymw.dLn());
    AppMethodBeat.o(96571);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r
 * JD-Core Version:    0.7.0.1
 */