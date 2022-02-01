package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;

public final class av
{
  public static m a(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y paramy, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(98308);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramy != null) {
      switch (paramy.type)
      {
      default: 
        com.tencent.mm.sdk.platformtools.ae.i("SnsAdNativeLandingPagesLayoutHelper", "unknown comp type " + paramy.type);
        localObject1 = localObject2;
      }
    }
    while (localObject1 != null)
    {
      AppMethodBeat.o(98308);
      return localObject1;
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)paramy, paramViewGroup);
      continue;
      if (paramy.subType == 2)
      {
        paramy = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramy;
        if ((paramy != null) && (paramy.zPS > 0) && (com.tencent.mm.plugin.sns.device.appstore.a.aL(paramy.zPT))) {}
        for (paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l(paramContext, paramy, paramViewGroup);; paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s(paramContext, paramy, paramViewGroup))
        {
          AppMethodBeat.o(98308);
          return paramContext;
        }
      }
      if (paramy.subType == 6)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z(paramContext, (p)paramy, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramy.subType == 7)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)paramy, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramy.subType == 13)
      {
        paramContext = new ag(paramContext, (n)paramy, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramy.subType == 14)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u(paramContext, (g)paramy, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      if (paramy.subType == 15)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)paramy, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
      }
      localObject1 = localObject2;
      if (paramy.subType == 17)
      {
        paramContext = new k(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)paramy, paramViewGroup);
        AppMethodBeat.o(98308);
        return paramContext;
        localObject1 = new f(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x)paramy, paramViewGroup);
        continue;
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)paramy, paramViewGroup);
        continue;
        localObject1 = new j(paramContext, paramy, paramViewGroup);
        continue;
        localObject1 = new al(paramContext, (am)paramy, paramViewGroup);
        continue;
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v(paramContext, (ai)paramy, paramViewGroup);
        continue;
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z)paramy, paramViewGroup);
        continue;
        switch (paramy.subType)
        {
        default: 
          localObject1 = localObject2;
          break;
        case 0: 
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)paramy, paramViewGroup);
          break;
        case 1: 
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)paramy, paramViewGroup);
        }
      }
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ak(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)paramy, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof p))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q(paramContext, (p)paramy, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)paramy, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r))
    {
      paramContext = new ab(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramy, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u))
    {
      paramContext = new af(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramy, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak))
    {
      paramy = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak)paramy;
      if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0) {
        com.tencent.mm.sdk.platformtools.ae.i("SnsAdNativeLandingPagesLayoutHelper", "use new stream video player component");
      }
      for (paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj(paramContext, paramy, paramViewGroup);; paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y(paramContext, paramy, paramViewGroup))
      {
        AppMethodBeat.o(98308);
        return paramContext;
      }
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj)paramy, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)paramy, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof d))
    {
      paramContext = new c(paramContext, (d)paramy, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad))
    {
      paramContext = new ac(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)paramy, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t))
    {
      paramContext = new ah(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)paramy, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)paramy, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e)paramy, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    if ((paramy instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.a))
    {
      paramContext = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.a(paramContext, (com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)paramy, paramViewGroup);
      AppMethodBeat.o(98308);
      return paramContext;
    }
    paramContext = new m(paramContext, paramy, paramViewGroup);
    AppMethodBeat.o(98308);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av
 * JD-Core Version:    0.7.0.1
 */