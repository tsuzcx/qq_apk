package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.component.a.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.sdk.platformtools.Log;

public final class ba
{
  public static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m a(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa paramaa, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(98308);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramaa != null) {
      switch (paramaa.type)
      {
      default: 
        Log.i("SnsAdNativeLandingPagesLayoutHelper", "unknown comp type " + paramaa.type);
        localObject1 = localObject2;
      }
    }
    while (localObject1 != null)
    {
      AppMethodBeat.o(98308);
      return localObject1;
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)paramaa, paramViewGroup);
      continue;
      if (paramaa.subType == 2)
      {
        paramaa = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramaa;
        if ((paramaa != null) && (paramaa.KkZ > 0) && (com.tencent.mm.plugin.sns.device.appstore.a.aV(paramaa.Kla))) {}
        for (paramContext = new l(paramContext, paramaa, paramViewGroup);; paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s(paramContext, paramaa, paramViewGroup))
        {
          AppMethodBeat.o(98308);
          return paramContext;
        }
      }
      if (paramaa.subType == 6)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramaa, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramaa.subType == 7)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)paramaa, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramaa.subType == 13)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah(paramContext, (p)paramaa, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramaa.subType == 14)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u(paramContext, (h)paramaa, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramaa.subType == 15)
      {
        paramContext = new ae(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)paramaa, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramaa.subType == 17)
      {
        localObject1 = new k(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x)paramaa, paramViewGroup);
      }
      else
      {
        if (paramaa.subType == 18)
        {
          paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab(paramContext, (n)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        if (paramaa.subType == 19)
        {
          paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.a(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        if (paramaa.subType == 20)
        {
          paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.c(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.d)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        localObject1 = localObject2;
        if (paramaa.subType == 21)
        {
          paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.d(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.c)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z)paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y)paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j(paramContext, paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.b(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.b)paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am(paramContext, (ap)paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al)paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)paramaa, paramViewGroup);
          continue;
          localObject1 = new g(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.f)paramaa, paramViewGroup);
          continue;
          switch (paramaa.subType)
          {
          default: 
            localObject1 = localObject2;
            break;
          case 0: 
            localObject1 = new ad(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramaa, paramViewGroup);
            break;
          case 1: 
            localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramaa, paramViewGroup);
          }
        }
      }
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)paramaa, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramaa, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u))
    {
      paramContext = new ad(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof an))
    {
      paramaa = (an)paramaa;
      Log.i("SnsAdNativeLandingPagesLayoutHelper", "use new stream video player component");
      paramContext = new ak(paramContext, paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j))
    {
      paramContext = new i(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v))
    {
      paramContext = new ai(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q))
    {
      paramContext = new o(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.e))
    {
      paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.e(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.e)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f))
    {
      paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.f(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m(paramContext, paramaa, paramViewGroup);
    AppMethodBeat.o(98308);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba
 * JD-Core Version:    0.7.0.1
 */