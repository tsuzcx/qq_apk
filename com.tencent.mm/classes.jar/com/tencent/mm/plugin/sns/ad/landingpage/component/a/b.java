package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends a
{
  public com.tencent.mm.plugin.sns.ad.landingpage.component.b.b JAf;
  private List<m> JAg;
  private l JAh;
  private int JAi;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(268056);
    this.JAi = 0;
    this.JAf = paramb;
    this.JAg = new ArrayList();
    AppMethodBeat.o(268056);
  }
  
  public static View a(m paramm)
  {
    AppMethodBeat.i(268071);
    if ((paramm.KqB.KmL) || (paramm.KqB.KmO))
    {
      paramm = paramm.getContentView();
      AppMethodBeat.o(268071);
      return paramm;
    }
    if ((paramm instanceof a))
    {
      paramm = ((a)paramm).fKf().iterator();
      while (paramm.hasNext())
      {
        View localView = a((m)paramm.next());
        if (localView != null)
        {
          AppMethodBeat.o(268071);
          return localView;
        }
      }
    }
    AppMethodBeat.o(268071);
    return null;
  }
  
  public static b b(m paramm)
  {
    AppMethodBeat.i(268072);
    if ((paramm instanceof b))
    {
      paramm = (b)paramm;
      AppMethodBeat.o(268072);
      return paramm;
    }
    if ((paramm instanceof a))
    {
      paramm = ((a)paramm).fKf().iterator();
      while (paramm.hasNext())
      {
        b localb = b((m)paramm.next());
        if (localb != null)
        {
          AppMethodBeat.o(268072);
          return localb;
        }
      }
    }
    AppMethodBeat.o(268072);
    return null;
  }
  
  private f b(aa paramaa)
  {
    AppMethodBeat.i(268064);
    if (paramaa == null)
    {
      AppMethodBeat.o(268064);
      return null;
    }
    if ((paramaa instanceof f))
    {
      paramaa = (f)paramaa;
      AppMethodBeat.o(268064);
      return paramaa;
    }
    if (i.agz(paramaa.type))
    {
      paramaa = paramaa.fKw();
      if (paramaa != null)
      {
        paramaa = paramaa.iterator();
        while (paramaa.hasNext())
        {
          f localf = b((aa)paramaa.next());
          if (localf != null)
          {
            AppMethodBeat.o(268064);
            return localf;
          }
        }
      }
    }
    AppMethodBeat.o(268064);
    return null;
  }
  
  private aa fKg()
  {
    AppMethodBeat.i(268069);
    Object localObject = this.JAf.ayS.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aa localaa = (aa)((Iterator)localObject).next();
      if (localaa.KmM)
      {
        AppMethodBeat.o(268069);
        return localaa;
      }
    }
    if (this.JAf.ayS.size() > 0)
    {
      localObject = (aa)this.JAf.ayS.get(0);
      AppMethodBeat.o(268069);
      return localObject;
    }
    AppMethodBeat.o(268069);
    return null;
  }
  
  public final void c(aa paramaa)
  {
    AppMethodBeat.i(268080);
    if ((paramaa instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.b)) {
      this.JAf = ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.b)paramaa);
    }
    super.c(paramaa);
    AppMethodBeat.o(268080);
  }
  
  public final void fKe() {}
  
  public final List<m> fKf()
  {
    AppMethodBeat.i(268066);
    if (this.JAh != null)
    {
      localArrayList = new ArrayList(this.JAh.fRQ());
      AppMethodBeat.o(268066);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(268066);
    return localArrayList;
  }
  
  public final Pair<Integer, Integer> fKh()
  {
    AppMethodBeat.i(268070);
    Object localObject = fKg();
    float f2;
    float f1;
    if (localObject != null)
    {
      f2 = ((aa)localObject).KmD;
      f1 = ((aa)localObject).KmE;
    }
    for (;;)
    {
      if ((f2 <= 0.0F) || (f1 <= 0.0F)) {
        Log.e("AdLandingEggCardComponent", "default card size is 0, w=" + f2 + ", h=" + f1);
      }
      localObject = new Pair(Integer.valueOf((int)f2), Integer.valueOf((int)f1));
      AppMethodBeat.o(268070);
      return localObject;
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public final void fKi()
  {
    AppMethodBeat.i(268073);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.KqB.paddingLeft, (int)this.KqB.paddingTop, (int)this.KqB.paddingRight, (int)this.KqB.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(268073);
  }
  
  public final View fKj()
  {
    AppMethodBeat.i(268074);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(268074);
    return localFrameLayout;
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(268075);
    Iterator localIterator = this.JAg.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fRj()) {
        localm.fKk();
      }
    }
    super.fKk();
    AppMethodBeat.o(268075);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(268076);
    Iterator localIterator = this.JAg.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).fKl();
    }
    super.fKl();
    AppMethodBeat.o(268076);
  }
  
  public final void fKm()
  {
    AppMethodBeat.i(268077);
    Iterator localIterator = this.JAg.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fRj()) {
        localm.fKm();
      }
    }
    super.fKm();
    AppMethodBeat.o(268077);
  }
  
  public final void fKn()
  {
    AppMethodBeat.i(268078);
    Iterator localIterator = this.JAg.iterator();
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
    AppMethodBeat.o(268078);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(268079);
    super.fKo();
    Iterator localIterator = this.JAg.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).fKo();
    }
    AppMethodBeat.o(268079);
  }
  
  public final void km(String paramString1, String paramString2)
  {
    AppMethodBeat.i(268061);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject2 = this.JAf.ayS.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (aa)((Iterator)localObject2).next();
        if (paramString1.equals(((aa)localObject1).KmN))
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = fKg();
            Log.i("AdLandingEggCardComponent", "selectShowCard, useDefaultCard, cardId=".concat(String.valueOf(paramString1)));
          }
          localObject1 = new ArrayList();
          if (localObject2 == null) {
            break label238;
          }
          f localf = b((aa)localObject2);
          if (localf != null)
          {
            Log.i("AdLandingEggCardComponent", "selectShowCard, show socialCard, cardId=".concat(String.valueOf(paramString1)));
            localf.aYx(paramString2);
          }
          ((List)localObject1).add(localObject2);
        }
      }
    }
    for (;;)
    {
      Log.i("AdLandingEggCardComponent", "selectShowCard, cost=" + (System.currentTimeMillis() - l));
      if (this.JAh != null) {
        break label249;
      }
      this.JAh = new l((List)localObject1, this.context, (FrameLayout)this.contentView);
      this.JAh.fP();
      this.JAg = fKf();
      AppMethodBeat.o(268061);
      return;
      localObject1 = null;
      break;
      label238:
      Log.e("AdLandingEggCardComponent", "selectShowCard, showCardInfo==null");
    }
    label249:
    this.JAh.notify((List)localObject1);
    AppMethodBeat.o(268061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.b
 * JD-Core Version:    0.7.0.1
 */