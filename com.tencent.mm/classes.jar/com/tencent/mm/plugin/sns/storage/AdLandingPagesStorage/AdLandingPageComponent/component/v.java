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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.q;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class v
  extends a
{
  private q PPI;
  private y QQk;
  private CustomScrollView QQl;
  List<n> aAO;
  
  public v(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    super(paramContext, paramy, paramViewGroup);
    AppMethodBeat.i(96563);
    this.QQk = paramy;
    this.aAO = new ArrayList();
    AppMethodBeat.o(96563);
  }
  
  public final void c(aa paramaa)
  {
    AppMethodBeat.i(96572);
    if ((paramaa instanceof y)) {
      this.QQk = ((y)paramaa);
    }
    super.c(paramaa);
    AppMethodBeat.o(96572);
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96564);
    if (this.PPI == null)
    {
      this.PPI = new q(this.QQk.aAO, this.context, this.QQl);
      this.PPI.CY();
      this.aAO = hai();
    }
    for (;;)
    {
      if (getGravity() == 0)
      {
        ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.QOV.paddingLeft, (int)this.QOV.paddingTop, (int)this.QOV.paddingRight, (int)this.QOV.paddingBottom);
        }
        this.contentView.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(96564);
      return;
      this.PPI.notify(this.QQk.aAO);
    }
  }
  
  public final List<n> hai()
  {
    AppMethodBeat.i(96571);
    ArrayList localArrayList = new ArrayList(this.PPI.hjV());
    AppMethodBeat.o(96571);
    return localArrayList;
  }
  
  protected final View ham()
  {
    AppMethodBeat.i(96565);
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = new RoundedCornerFrameLayout(this.context);
    this.QQl = new CustomScrollView(this.context);
    this.QQl.setOverScrollMode(2);
    this.QQl.setHorizontalScrollBarEnabled(false);
    this.QQl.setVerticalScrollBarEnabled(false);
    this.QQl.setOnScrollChangeListener(new CustomScrollView.a()
    {
      public final void onScrollChange(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(307054);
        paramAnonymousScrollView = v.this.aAO.iterator();
        while (paramAnonymousScrollView.hasNext())
        {
          n localn = (n)paramAnonymousScrollView.next();
          if (localn.hji())
          {
            localn.hao();
            localn.haq();
          }
          else
          {
            localn.hap();
          }
        }
        AppMethodBeat.o(307054);
      }
    });
    localRoundedCornerFrameLayout.setBackgroundColor(this.backgroundColor);
    localRoundedCornerFrameLayout.addView(this.QQl);
    localRoundedCornerFrameLayout.setRadius(this.QQk.cornerRadius);
    AppMethodBeat.o(96565);
    return localRoundedCornerFrameLayout;
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96566);
    Iterator localIterator = this.aAO.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.hji()) {
        localn.hao();
      }
    }
    super.hao();
    AppMethodBeat.o(96566);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(96567);
    Iterator localIterator = this.aAO.iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).hap();
    }
    super.hap();
    AppMethodBeat.o(96567);
  }
  
  public final void haq()
  {
    AppMethodBeat.i(96568);
    Iterator localIterator = this.aAO.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.hji()) {
        localn.haq();
      }
    }
    super.haq();
    AppMethodBeat.o(96568);
  }
  
  public final void har()
  {
    AppMethodBeat.i(96569);
    Iterator localIterator = this.aAO.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.hji())
      {
        localn.hao();
        localn.haq();
      }
      else
      {
        localn.hap();
      }
    }
    AppMethodBeat.o(96569);
  }
  
  public final void has()
  {
    AppMethodBeat.i(96570);
    super.has();
    Iterator localIterator = this.aAO.iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).has();
    }
    AppMethodBeat.o(96570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v
 * JD-Core Version:    0.7.0.1
 */