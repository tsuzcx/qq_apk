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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class x
  extends o
{
  public x(Context paramContext, p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
    AppMethodBeat.i(96657);
    paramContext = h.k(paramp.yiM, true, false);
    paramViewGroup = this.ynh;
    if (paramContext == null) {}
    for (paramContext = "";; paramContext = paramContext.field_packageName)
    {
      paramViewGroup.jo("pkg", paramContext);
      this.ynh.jo("appid", paramp.yiM);
      AppMethodBeat.o(96657);
      return;
    }
  }
  
  private boolean B(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(96659);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(96659);
      return false;
    }
    try
    {
      Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString1);
      if (localIntent != null)
      {
        paramString1 = paramContext;
        if (!(paramContext instanceof Activity)) {
          paramString1 = this.context;
        }
        a.post(new x.1(this, paramString1, localIntent, paramString2));
        AppMethodBeat.o(96659);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      ac.e("AdLandingPageOpenAppBtnComp", bs.m(paramContext));
      AppMethodBeat.o(96659);
    }
    return false;
  }
  
  protected final void dKO()
  {
    AppMethodBeat.i(96658);
    Object localObject = dKN();
    if (h.t(this.context, ((p)localObject).yiM))
    {
      localObject = h.k(((p)localObject).yiM, true, false);
      if ((localObject != null) && (!TextUtils.isEmpty(((g)localObject).field_packageName)) && (B(this.context, ((g)localObject).field_packageName, h.a(this.context, (g)localObject, null))))
      {
        dKM();
        AppMethodBeat.o(96658);
        return;
      }
      super.dKO();
      AppMethodBeat.o(96658);
      return;
    }
    super.dKO();
    AppMethodBeat.o(96658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x
 * JD-Core Version:    0.7.0.1
 */