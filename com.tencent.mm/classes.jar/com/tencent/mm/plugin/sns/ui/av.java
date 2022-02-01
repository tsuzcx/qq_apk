package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;

public final class av
{
  public static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l a(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x paramx, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(98308);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramx != null) {
      switch (paramx.type)
      {
      default: 
        com.tencent.mm.sdk.platformtools.ad.i("SnsAdNativeLandingPagesLayoutHelper", "unknown comp type " + paramx.type);
        localObject1 = localObject2;
      }
    }
    while (localObject1 != null)
    {
      AppMethodBeat.o(98308);
      return localObject1;
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)paramx, paramViewGroup);
      continue;
      if (paramx.subType == 2)
      {
        paramx = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramx;
        if ((paramx != null) && (paramx.zyt > 0) && (com.tencent.mm.plugin.sns.device.appstore.a.aK(paramx.zyu))) {}
        for (paramContext = new k(paramContext, paramx, paramViewGroup);; paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r(paramContext, paramx, paramViewGroup))
        {
          AppMethodBeat.o(98308);
          return paramContext;
        }
      }
      if (paramx.subType == 6)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)paramx, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramx.subType == 7)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)paramx, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramx.subType == 13)
      {
        paramContext = new af(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)paramx, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramx.subType == 14)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t(paramContext, (g)paramx, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      localObject1 = localObject2;
      if (paramx.subType == 15)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z)paramx, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
        localObject1 = new f(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)paramx, paramViewGroup);
        continue;
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)paramx, paramViewGroup);
        continue;
        localObject1 = new j(paramContext, paramx, paramViewGroup);
        continue;
        localObject1 = new ak(paramContext, (al)paramx, paramViewGroup);
        continue;
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u(paramContext, (ah)paramx, paramViewGroup);
        continue;
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y)paramx, paramViewGroup);
        continue;
        switch (paramx.subType)
        {
        default: 
          localObject1 = localObject2;
          break;
        case 0: 
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)paramx, paramViewGroup);
          break;
        case 1: 
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)paramx, paramViewGroup);
        }
      }
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)paramx, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)paramx, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)paramx, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r))
    {
      paramContext = new aa(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramx, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u))
    {
      paramContext = new ae(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramx, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj))
    {
      paramx = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)paramx;
      if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0) {
        com.tencent.mm.sdk.platformtools.ad.i("SnsAdNativeLandingPagesLayoutHelper", "use new stream video player component");
      }
      for (paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ai(paramContext, paramx, paramViewGroup);; paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x(paramContext, paramx, paramViewGroup))
      {
        AppMethodBeat.o(98308);
        return paramContext;
      }
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai)paramx, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)paramx, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof d))
    {
      paramContext = new c(paramContext, (d)paramx, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac))
    {
      paramContext = new ab(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac)paramx, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t))
    {
      paramContext = new ag(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)paramx, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof o))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n(paramContext, (o)paramx, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)paramx, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramx instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.a))
    {
      paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.a(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)paramx, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l(paramContext, paramx, paramViewGroup);
    AppMethodBeat.o(98308);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av
 * JD-Core Version:    0.7.0.1
 */