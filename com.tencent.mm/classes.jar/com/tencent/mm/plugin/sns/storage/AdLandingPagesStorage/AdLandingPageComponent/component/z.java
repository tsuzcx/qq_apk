package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class z
  extends q
{
  public z(Context paramContext, p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
    AppMethodBeat.i(96657);
    paramContext = h.m(paramp.zQt, true, false);
    paramViewGroup = this.zVg;
    if (paramContext == null) {}
    for (paramContext = "";; paramContext = paramContext.field_packageName)
    {
      paramViewGroup.jH("pkg", paramContext);
      this.zVg.jH("appid", paramp.zQt);
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
      ae.e("AdLandingPageOpenAppBtnComp", bu.o(paramContext));
      AppMethodBeat.o(96659);
    }
    return false;
  }
  
  protected final void eap()
  {
    AppMethodBeat.i(96658);
    Object localObject = eaI();
    if (h.s(this.context, ((p)localObject).zQt))
    {
      localObject = h.m(((p)localObject).zQt, true, false);
      if ((localObject != null) && (!TextUtils.isEmpty(((g)localObject).field_packageName)) && (E(this.context, ((g)localObject).field_packageName, h.a(this.context, (g)localObject, null))))
      {
        eaq();
        AppMethodBeat.o(96658);
        return;
      }
      super.eap();
      AppMethodBeat.o(96658);
      return;
    }
    super.eap();
    AppMethodBeat.o(96658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z
 * JD-Core Version:    0.7.0.1
 */