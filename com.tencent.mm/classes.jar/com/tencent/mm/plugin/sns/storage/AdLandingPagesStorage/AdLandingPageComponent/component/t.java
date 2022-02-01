package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
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
  private l Dtq;
  private x Eei;
  private CustomScrollView Eej;
  List<m> aQz;
  
  public t(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
    AppMethodBeat.i(96563);
    this.Eei = paramx;
    this.aQz = new ArrayList();
    AppMethodBeat.o(96563);
  }
  
  public final void b(z paramz)
  {
    AppMethodBeat.i(96572);
    if ((paramz instanceof x)) {
      this.Eei = ((x)paramz);
    }
    super.b(paramz);
    AppMethodBeat.o(96572);
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96564);
    if (this.Dtq == null)
    {
      this.Dtq = new l(this.Eei.aQz, this.context, this.Eej);
      this.Dtq.layout();
      this.aQz = eWU();
    }
    for (;;)
    {
      if (getGravity() == 0)
      {
        ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.EcX.paddingLeft, (int)this.EcX.paddingTop, (int)this.EcX.paddingRight, (int)this.EcX.paddingBottom);
        }
        this.contentView.setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(96564);
      return;
      this.Dtq.gV(this.Eei.aQz);
    }
  }
  
  public final List<m> eWU()
  {
    AppMethodBeat.i(96571);
    ArrayList localArrayList = new ArrayList(this.Dtq.fdY());
    AppMethodBeat.o(96571);
    return localArrayList;
  }
  
  protected final View eWY()
  {
    AppMethodBeat.i(96565);
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = new RoundedCornerFrameLayout(this.context);
    this.Eej = new CustomScrollView(this.context);
    this.Eej.setOverScrollMode(2);
    this.Eej.setHorizontalScrollBarEnabled(false);
    this.Eej.setVerticalScrollBarEnabled(false);
    this.Eej.setOnScrollChangeListener(new CustomScrollView.a()
    {
      public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(96562);
        paramAnonymousScrollView = t.this.aQz.iterator();
        while (paramAnonymousScrollView.hasNext())
        {
          m localm = (m)paramAnonymousScrollView.next();
          if (localm.fdm())
          {
            localm.eWZ();
            localm.eXb();
          }
          else
          {
            localm.eXa();
          }
        }
        AppMethodBeat.o(96562);
      }
    });
    localRoundedCornerFrameLayout.setBackgroundColor(this.backgroundColor);
    localRoundedCornerFrameLayout.addView(this.Eej);
    localRoundedCornerFrameLayout.setRadius(this.Eei.hH);
    AppMethodBeat.o(96565);
    return localRoundedCornerFrameLayout;
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96566);
    Iterator localIterator = this.aQz.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fdm()) {
        localm.eWZ();
      }
    }
    super.eWZ();
    AppMethodBeat.o(96566);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96567);
    Iterator localIterator = this.aQz.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).eXa();
    }
    super.eXa();
    AppMethodBeat.o(96567);
  }
  
  public final void eXb()
  {
    AppMethodBeat.i(96568);
    Iterator localIterator = this.aQz.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fdm()) {
        localm.eXb();
      }
    }
    super.eXb();
    AppMethodBeat.o(96568);
  }
  
  public final void eXc()
  {
    AppMethodBeat.i(96569);
    Iterator localIterator = this.aQz.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fdm())
      {
        localm.eWZ();
        localm.eXb();
      }
      else
      {
        localm.eXa();
      }
    }
    AppMethodBeat.o(96569);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96570);
    super.eXd();
    Iterator localIterator = this.aQz.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).eXd();
    }
    AppMethodBeat.o(96570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t
 * JD-Core Version:    0.7.0.1
 */