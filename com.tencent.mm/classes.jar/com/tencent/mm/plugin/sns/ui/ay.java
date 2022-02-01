package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.sdk.platformtools.Log;

public final class ay
{
  public static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m a(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z paramz, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(98308);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramz != null) {
      switch (paramz.type)
      {
      default: 
        Log.i("SnsAdNativeLandingPagesLayoutHelper", "unknown comp type " + paramz.type);
        localObject1 = localObject2;
      }
    }
    while (localObject1 != null)
    {
      AppMethodBeat.o(98308);
      return localObject1;
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramz, paramViewGroup);
      continue;
      if (paramz.subType == 2)
      {
        paramz = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramz;
        if ((paramz != null) && (paramz.DXQ > 0) && (com.tencent.mm.plugin.sns.device.appstore.a.aV(paramz.DXR))) {}
        for (paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l(paramContext, paramz, paramViewGroup);; paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s(paramContext, paramz, paramViewGroup))
        {
          AppMethodBeat.o(98308);
          return paramContext;
        }
      }
      if (paramz.subType == 6)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)paramz, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramz.subType == 7)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)paramz, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramz.subType == 13)
      {
        paramContext = new ai(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)paramz, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramz.subType == 14)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u(paramContext, (g)paramz, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramz.subType == 15)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)paramz, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramz.subType == 17)
      {
        localObject1 = new k(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)paramz, paramViewGroup);
      }
      else
      {
        if (paramz.subType == 18)
        {
          paramContext = new ac(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)paramz, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        if (paramz.subType == 19)
        {
          paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.a(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)paramz, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
        }
        localObject1 = localObject2;
        if (paramz.subType == 20)
        {
          paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.c(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.c)paramz, paramViewGroup);
          AppMethodBeat.o(98308);
          return paramContext;
          localObject1 = new f(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y)paramz, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x)paramz, paramViewGroup);
          continue;
          localObject1 = new j(paramContext, paramz, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.b(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.b)paramz, paramViewGroup);
          continue;
          localObject1 = new an(paramContext, (ao)paramz, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v(paramContext, (ak)paramz, paramViewGroup);
          continue;
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)paramz, paramViewGroup);
          continue;
          switch (paramz.subType)
          {
          default: 
            localObject1 = localObject2;
            break;
          case 0: 
            localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)paramz, paramViewGroup);
            break;
          case 1: 
            localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)paramz, paramViewGroup);
          }
        }
      }
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag)paramz, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)paramz, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v))
    {
      paramContext = new ah(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am))
    {
      paramz = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am)paramz;
      if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0) {
        Log.i("SnsAdNativeLandingPagesLayoutHelper", "use new stream video player component");
      }
      for (paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al(paramContext, paramz, paramViewGroup);; paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y(paramContext, paramz, paramViewGroup))
      {
        AppMethodBeat.o(98308);
        return paramContext;
      }
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae))
    {
      paramContext = new ad(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u))
    {
      paramContext = new aj(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof p))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o(paramContext, (p)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.d))
    {
      paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.d(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.d)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af)paramz, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m(paramContext, paramz, paramViewGroup);
    AppMethodBeat.o(98308);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ay
 * JD-Core Version:    0.7.0.1
 */