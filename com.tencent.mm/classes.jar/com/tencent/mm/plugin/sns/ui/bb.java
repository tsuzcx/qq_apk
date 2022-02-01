package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.component.comp.AdLandingHBCardComponent;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class bb
{
  public static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n a(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa paramaa, ViewGroup paramViewGroup, int paramInt)
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
        if ((paramaa != null) && (paramaa.QJg > 0) && (com.tencent.mm.plugin.sns.device.appstore.a.bv(paramaa.QJh))) {}
        for (paramContext = new l(paramContext, paramaa, paramViewGroup);; paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t(paramContext, paramaa, paramViewGroup))
        {
          AppMethodBeat.o(98308);
          return paramContext;
        }
      }
      if (paramaa.subType == 6)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramaa, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramaa.subType == 7)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)paramaa, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramaa.subType == 13)
      {
        paramContext = new ak(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)paramaa, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramaa.subType == 14)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)paramaa, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramaa.subType == 15)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)paramaa, paramViewGroup);
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
          paramContext = new ae(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        if (paramaa.subType == 19)
        {
          paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.comp.a(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.info.a)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        if (paramaa.subType == 20)
        {
          paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.comp.d(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.info.e)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        if (paramaa.subType == 21)
        {
          paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.comp.e(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.info.c)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        if (paramaa.subType == 22)
        {
          paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.comp.c(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.info.d)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        if (paramaa.subType == 23)
        {
          paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        if (paramaa.subType == 24)
        {
          paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        localObject1 = localObject2;
        if (paramaa.subType == 25)
        {
          paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a.a)paramaa, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z)paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y)paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j(paramContext, paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.comp.b(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.info.b)paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap(paramContext, (ar)paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x(paramContext, (am)paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)paramaa, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.comp.h(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.info.h)paramaa, paramViewGroup);
          continue;
          localObject1 = new AdLandingHBCardComponent(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.info.g)paramaa, paramViewGroup);
          continue;
          switch (paramaa.subType)
          {
          default: 
            localObject1 = localObject2;
            break;
          case 0: 
            localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramaa, paramViewGroup);
            break;
          case 1: 
            localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramaa, paramViewGroup);
          }
        }
      }
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah)paramaa, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramaa, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t))
    {
      paramContext = new ad(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap))
    {
      paramaa = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap)paramaa;
      Log.i("SnsAdNativeLandingPagesLayoutHelper", "use new stream video player component");
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an(paramContext, paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an)paramaa, paramViewGroup);
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
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v))
    {
      paramContext = new al(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof q))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p(paramContext, (q)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.info.f))
    {
      paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.comp.f(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.info.f)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag))
    {
      paramContext = new ai(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f))
    {
      paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.comp.g(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)paramaa, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n(paramContext, paramaa, paramViewGroup);
    AppMethodBeat.o(98308);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bb
 * JD-Core Version:    0.7.0.1
 */