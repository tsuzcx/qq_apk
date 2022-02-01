package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
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
  List<m> aQH;
  private l zUn;
  private w zWb;
  private CustomScrollView zWc;
  
  public t(Context paramContext, w paramw, ViewGroup paramViewGroup)
  {
    super(paramContext, paramw, paramViewGroup);
    AppMethodBeat.i(96563);
    this.zWb = paramw;
    this.aQH = new ArrayList();
    AppMethodBeat.o(96563);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(96572);
    if ((paramy instanceof w)) {
      this.zWb = ((w)paramy);
    }
    super.a(paramy);
    AppMethodBeat.o(96572);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96564);
    if (this.zUn == null)
    {
      this.zUn = new l(this.zWb.aQH, this.context, this.zWc);
      this.zUn.layout();
      this.aQH = eaj();
    }
    for (;;)
    {
      if (getGravity() == 0)
      {
        ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zUP.paddingLeft, (int)this.zUP.paddingTop, (int)this.zUP.paddingRight, (int)this.zUP.paddingBottom);
        }
        this.contentView.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(96564);
      return;
      this.zUn.fY(this.zWb.aQH);
    }
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96566);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.eay()) {
        localm.dUK();
      }
    }
    super.dUK();
    AppMethodBeat.o(96566);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96567);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).dUL();
    }
    super.dUL();
    AppMethodBeat.o(96567);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96570);
    super.dUM();
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).dUM();
    }
    AppMethodBeat.o(96570);
  }
  
  public final void dZO()
  {
    AppMethodBeat.i(96568);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.eay()) {
        localm.dZO();
      }
    }
    super.dZO();
    AppMethodBeat.o(96568);
  }
  
  protected final View eae()
  {
    AppMethodBeat.i(96565);
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = new RoundedCornerFrameLayout(this.context);
    this.zWc = new CustomScrollView(this.context);
    this.zWc.setOverScrollMode(2);
    this.zWc.setHorizontalScrollBarEnabled(false);
    this.zWc.setVerticalScrollBarEnabled(false);
    this.zWc.setOnScrollChangeListener(new CustomScrollView.a()
    {
      public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(96562);
        paramAnonymousScrollView = t.this.aQH.iterator();
        while (paramAnonymousScrollView.hasNext())
        {
          m localm = (m)paramAnonymousScrollView.next();
          if (localm.eay())
          {
            localm.dUK();
            localm.dZO();
          }
          else
          {
            localm.dUL();
          }
        }
        AppMethodBeat.o(96562);
      }
    });
    localRoundedCornerFrameLayout.setBackgroundColor(this.backgroundColor);
    localRoundedCornerFrameLayout.addView(this.zWc);
    localRoundedCornerFrameLayout.setRadius(this.zWb.hF);
    AppMethodBeat.o(96565);
    return localRoundedCornerFrameLayout;
  }
  
  public final void eai()
  {
    AppMethodBeat.i(96569);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.eay())
      {
        localm.dUK();
        localm.dZO();
      }
      else
      {
        localm.dUL();
      }
    }
    AppMethodBeat.o(96569);
  }
  
  public final List<m> eaj()
  {
    AppMethodBeat.i(96571);
    ArrayList localArrayList = new ArrayList(this.zUn.ebh());
    AppMethodBeat.o(96571);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t
 * JD-Core Version:    0.7.0.1
 */