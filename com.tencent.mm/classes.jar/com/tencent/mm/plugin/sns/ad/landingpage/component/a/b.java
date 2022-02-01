package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends a
{
  public com.tencent.mm.plugin.sns.ad.landingpage.component.b.b Dto;
  public List<m> Dtp;
  public l Dtq;
  private int Dtr;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(201959);
    this.Dtr = 0;
    this.Dto = paramb;
    this.Dtp = new ArrayList();
    AppMethodBeat.o(201959);
  }
  
  public static View a(m paramm)
  {
    AppMethodBeat.i(201963);
    if (paramm.fdk().DZs)
    {
      paramm = paramm.contentView;
      AppMethodBeat.o(201963);
      return paramm;
    }
    if ((paramm instanceof a))
    {
      paramm = ((a)paramm).eWU().iterator();
      while (paramm.hasNext())
      {
        View localView = a((m)paramm.next());
        if (localView != null)
        {
          AppMethodBeat.o(201963);
          return localView;
        }
      }
    }
    AppMethodBeat.o(201963);
    return null;
  }
  
  public static b b(m paramm)
  {
    AppMethodBeat.i(201964);
    if ((paramm instanceof b))
    {
      paramm = (b)paramm;
      AppMethodBeat.o(201964);
      return paramm;
    }
    if ((paramm instanceof a))
    {
      paramm = ((a)paramm).eWU().iterator();
      while (paramm.hasNext())
      {
        b localb = b((m)paramm.next());
        if (localb != null)
        {
          AppMethodBeat.o(201964);
          return localb;
        }
      }
    }
    AppMethodBeat.o(201964);
    return null;
  }
  
  public final void b(z paramz)
  {
    AppMethodBeat.i(201972);
    if ((paramz instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.b)) {
      this.Dto = ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.b)paramz);
    }
    super.b(paramz);
    AppMethodBeat.o(201972);
  }
  
  public final void eWT() {}
  
  public final List<m> eWU()
  {
    AppMethodBeat.i(201960);
    if (this.Dtq != null)
    {
      localArrayList = new ArrayList(this.Dtq.fdY());
      AppMethodBeat.o(201960);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(201960);
    return localArrayList;
  }
  
  public z eWV()
  {
    AppMethodBeat.i(201961);
    Object localObject = this.Dto.aQz.iterator();
    while (((Iterator)localObject).hasNext())
    {
      z localz = (z)((Iterator)localObject).next();
      if (localz.DZt)
      {
        AppMethodBeat.o(201961);
        return localz;
      }
    }
    if (this.Dto.aQz.size() > 0)
    {
      localObject = (z)this.Dto.aQz.get(0);
      AppMethodBeat.o(201961);
      return localObject;
    }
    AppMethodBeat.o(201961);
    return null;
  }
  
  public final Pair<Integer, Integer> eWW()
  {
    AppMethodBeat.i(201962);
    Object localObject = eWV();
    float f2;
    float f1;
    if (localObject != null)
    {
      f2 = ((z)localObject).DZk;
      f1 = ((z)localObject).DZl;
    }
    for (;;)
    {
      if ((f2 <= 0.0F) || (f1 <= 0.0F)) {
        Log.e("AdLandingEggCardComponent", "default card size is 0, w=" + f2 + ", h=" + f1);
      }
      localObject = new Pair(Integer.valueOf((int)f2), Integer.valueOf((int)f1));
      AppMethodBeat.o(201962);
      return localObject;
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public final void eWX()
  {
    AppMethodBeat.i(201965);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.EcX.paddingLeft, (int)this.EcX.paddingTop, (int)this.EcX.paddingRight, (int)this.EcX.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(201965);
  }
  
  public final View eWY()
  {
    AppMethodBeat.i(201966);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(201966);
    return localFrameLayout;
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(201967);
    Iterator localIterator = this.Dtp.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fdm()) {
        localm.eWZ();
      }
    }
    super.eWZ();
    AppMethodBeat.o(201967);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(201968);
    Iterator localIterator = this.Dtp.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).eXa();
    }
    super.eXa();
    AppMethodBeat.o(201968);
  }
  
  public final void eXb()
  {
    AppMethodBeat.i(201969);
    Iterator localIterator = this.Dtp.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fdm()) {
        localm.eXb();
      }
    }
    super.eXb();
    AppMethodBeat.o(201969);
  }
  
  public final void eXc()
  {
    AppMethodBeat.i(201970);
    Iterator localIterator = this.Dtp.iterator();
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
    AppMethodBeat.o(201970);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(201971);
    super.eXd();
    Iterator localIterator = this.Dtp.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).eXd();
    }
    AppMethodBeat.o(201971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.b
 * JD-Core Version:    0.7.0.1
 */