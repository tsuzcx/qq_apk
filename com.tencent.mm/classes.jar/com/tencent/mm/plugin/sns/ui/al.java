package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;

public final class al
{
  public static h a(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t paramt, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(38606);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramt != null) {
      switch (paramt.type)
      {
      default: 
        com.tencent.mm.sdk.platformtools.ab.i("SnsAdNativeLandingPagesLayoutHelper", "unknown comp type " + paramt.type);
        localObject1 = localObject2;
      }
    }
    while (localObject1 != null)
    {
      AppMethodBeat.o(38606);
      return localObject1;
      localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m)paramt, paramViewGroup);
      continue;
      if (paramt.subType == 2)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramt, paramViewGroup);
        AppMethodBeat.o(38606);
        return paramContext;
      }
      if (paramt.subType == 6)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)paramt, paramViewGroup);
        AppMethodBeat.o(38606);
        return paramContext;
      }
      localObject1 = localObject2;
      if (paramt.subType == 7)
      {
        paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t(paramContext, (j)paramt, paramViewGroup);
        AppMethodBeat.o(38606);
        return paramContext;
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)paramt, paramViewGroup);
        continue;
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramt, paramViewGroup);
        continue;
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g(paramContext, paramt, paramViewGroup);
        continue;
        localObject1 = new ac(paramContext, (ad)paramt, paramViewGroup);
        continue;
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o(paramContext, (z)paramt, paramViewGroup);
        continue;
        localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)paramt, paramViewGroup);
        continue;
        switch (paramt.subType)
        {
        default: 
          localObject1 = localObject2;
          break;
        case 0: 
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)paramt, paramViewGroup);
          break;
        case 1: 
          localObject1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)paramt, paramViewGroup);
        }
      }
    }
    if ((paramt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w)paramt, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(38606);
      return paramContext;
    }
    if ((paramt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l))
    {
      paramContext = new k(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)paramt, paramViewGroup);
      paramContext.setBackgroundColor(paramInt);
      AppMethodBeat.o(38606);
      return paramContext;
    }
    if ((paramt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)paramt, paramViewGroup);
      AppMethodBeat.o(38606);
      return paramContext;
    }
    if ((paramt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)paramt, paramViewGroup);
      AppMethodBeat.o(38606);
      return paramContext;
    }
    if ((paramt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q))
    {
      paramContext = new x(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)paramt, paramViewGroup);
      AppMethodBeat.o(38606);
      return paramContext;
    }
    if ((paramt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab))
    {
      paramt = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)paramt;
      if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0) {
        com.tencent.mm.sdk.platformtools.ab.i("SnsAdNativeLandingPagesLayoutHelper", "use new stream video player component");
      }
      for (paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa(paramContext, paramt, paramViewGroup);; paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r(paramContext, paramt, paramViewGroup))
      {
        AppMethodBeat.o(38606);
        return paramContext;
      }
    }
    if ((paramt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)paramt, paramViewGroup);
      AppMethodBeat.o(38606);
      return paramContext;
    }
    if ((paramt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g))
    {
      paramContext = new f(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)paramt, paramViewGroup);
      AppMethodBeat.o(38606);
      return paramContext;
    }
    if ((paramt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d))
    {
      paramContext = new c(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)paramt, paramViewGroup);
      AppMethodBeat.o(38606);
      return paramContext;
    }
    if ((paramt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v))
    {
      paramContext = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)paramt, paramViewGroup);
      AppMethodBeat.o(38606);
      return paramContext;
    }
    if ((paramt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p))
    {
      paramContext = new y(paramContext, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)paramt, paramViewGroup);
      AppMethodBeat.o(38606);
      return paramContext;
    }
    paramContext = new h(paramContext, paramt, paramViewGroup);
    AppMethodBeat.o(38606);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.al
 * JD-Core Version:    0.7.0.1
 */