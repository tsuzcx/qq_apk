package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ab
  extends r
{
  public ab(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r paramr, ViewGroup paramViewGroup)
  {
    super(paramContext, paramr, paramViewGroup);
    AppMethodBeat.i(96657);
    paramContext = h.s(paramr.QJQ, true, false);
    paramViewGroup = this.QPl;
    if (paramContext == null) {}
    for (paramContext = "";; paramContext = paramContext.field_packageName)
    {
      paramViewGroup.mx("pkg", paramContext);
      this.QPl.mx("appid", paramr.QJQ);
      AppMethodBeat.o(96657);
      return;
    }
  }
  
  private boolean Q(Context paramContext, final String paramString1, final String paramString2)
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
      Log.e("AdLandingPageOpenAppBtnComp", Util.stackTraceToString(paramContext));
      AppMethodBeat.o(96659);
    }
    return false;
  }
  
  protected final void hiZ()
  {
    AppMethodBeat.i(96658);
    Object localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV;
    if (h.y(this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject).QJQ))
    {
      localObject = h.s(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject).QJQ, true, false);
      if ((localObject != null) && (!TextUtils.isEmpty(((g)localObject).field_packageName)) && (Q(this.context, ((g)localObject).field_packageName, h.a(this.context, (g)localObject, null))))
      {
        hja();
        AppMethodBeat.o(96658);
        return;
      }
      super.hiZ();
      AppMethodBeat.o(96658);
      return;
    }
    super.hiZ();
    AppMethodBeat.o(96658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab
 * JD-Core Version:    0.7.0.1
 */