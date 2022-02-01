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
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class s
  extends a
{
  List<l> aQH;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l zDl;
  private v zEV;
  private CustomScrollView zEW;
  
  public s(Context paramContext, v paramv, ViewGroup paramViewGroup)
  {
    super(paramContext, paramv, paramViewGroup);
    AppMethodBeat.i(96563);
    this.zEV = paramv;
    this.aQH = new ArrayList();
    AppMethodBeat.o(96563);
  }
  
  public final void a(x paramx)
  {
    AppMethodBeat.i(96572);
    if ((paramx instanceof v)) {
      this.zEV = ((v)paramx);
    }
    super.a(paramx);
    AppMethodBeat.o(96572);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96564);
    if (this.zDl == null)
    {
      this.zDl = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l(this.zEV.aQH, this.context, this.zEW);
      this.zDl.layout();
      this.aQH = dWH();
    }
    for (;;)
    {
      if (getGravity() == 0)
      {
        ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zDK.paddingLeft, (int)this.zDK.paddingTop, (int)this.zDK.paddingRight, (int)this.zDK.paddingBottom);
        }
        this.contentView.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(96564);
      return;
      this.zDl.fP(this.zEV.aQH);
    }
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(96566);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (locall.dWU()) {
        locall.dRm();
      }
    }
    super.dRm();
    AppMethodBeat.o(96566);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96567);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).dRn();
    }
    super.dRn();
    AppMethodBeat.o(96567);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96570);
    super.dRo();
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).dRo();
    }
    AppMethodBeat.o(96570);
  }
  
  protected final View dWC()
  {
    AppMethodBeat.i(96565);
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = new RoundedCornerFrameLayout(this.context);
    this.zEW = new CustomScrollView(this.context);
    this.zEW.setOverScrollMode(2);
    this.zEW.setHorizontalScrollBarEnabled(false);
    this.zEW.setVerticalScrollBarEnabled(false);
    this.zEW.setOnScrollChangeListener(new CustomScrollView.a()
    {
      public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(96562);
        paramAnonymousScrollView = s.this.aQH.iterator();
        while (paramAnonymousScrollView.hasNext())
        {
          l locall = (l)paramAnonymousScrollView.next();
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
        AppMethodBeat.o(96562);
      }
    });
    localRoundedCornerFrameLayout.setBackgroundColor(this.backgroundColor);
    localRoundedCornerFrameLayout.addView(this.zEW);
    localRoundedCornerFrameLayout.setRadius(this.zEV.hF);
    AppMethodBeat.o(96565);
    return localRoundedCornerFrameLayout;
  }
  
  public final void dWG()
  {
    AppMethodBeat.i(96569);
    Iterator localIterator = this.aQH.iterator();
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
    AppMethodBeat.o(96569);
  }
  
  public final List<l> dWH()
  {
    AppMethodBeat.i(96571);
    ArrayList localArrayList = new ArrayList(this.zDl.dXE());
    AppMethodBeat.o(96571);
    return localArrayList;
  }
  
  public final void dWm()
  {
    AppMethodBeat.i(96568);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (locall.dWU()) {
        locall.dWm();
      }
    }
    super.dWm();
    AppMethodBeat.o(96568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s
 * JD-Core Version:    0.7.0.1
 */