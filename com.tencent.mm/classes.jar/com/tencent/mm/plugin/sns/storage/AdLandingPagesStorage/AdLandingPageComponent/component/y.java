package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class y
  extends p
{
  public y(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
    AppMethodBeat.i(96657);
    paramContext = h.m(paramp.zyU, true, false);
    paramViewGroup = this.zEb;
    if (paramContext == null) {}
    for (paramContext = "";; paramContext = paramContext.field_packageName)
    {
      paramViewGroup.jB("pkg", paramContext);
      this.zEb.jB("appid", paramp.zyU);
      AppMethodBeat.o(96657);
      return;
    }
  }
  
  private boolean E(Context paramContext, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(96659);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(96659);
      return false;
    }
    try
    {
      final Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString1);
      if (localIntent != null)
      {
        paramString1 = paramContext;
        if (!(paramContext instanceof Activity)) {
          paramString1 = this.context;
        }
        a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96656);
            h.b(paramString1, localIntent, paramString2);
            AppMethodBeat.o(96656);
          }
        });
        AppMethodBeat.o(96659);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      ad.e("AdLandingPageOpenAppBtnComp", bt.n(paramContext));
      AppMethodBeat.o(96659);
    }
    return false;
  }
  
  protected final void dXg()
  {
    AppMethodBeat.i(96658);
    Object localObject = dXf();
    if (h.s(this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject).zyU))
    {
      localObject = h.m(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject).zyU, true, false);
      if ((localObject != null) && (!TextUtils.isEmpty(((g)localObject).field_packageName)) && (E(this.context, ((g)localObject).field_packageName, h.a(this.context, (g)localObject, null))))
      {
        dXe();
        AppMethodBeat.o(96658);
        return;
      }
      super.dXg();
      AppMethodBeat.o(96658);
      return;
    }
    super.dXg();
    AppMethodBeat.o(96658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y
 * JD-Core Version:    0.7.0.1
 */