package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class z
  extends q
{
  public z(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q paramq, ViewGroup paramViewGroup)
  {
    super(paramContext, paramq, paramViewGroup);
    AppMethodBeat.i(96657);
    paramContext = h.o(paramq.DYs, true, false);
    paramViewGroup = this.Edn;
    if (paramContext == null) {}
    for (paramContext = "";; paramContext = paramContext.field_packageName)
    {
      paramViewGroup.kv("pkg", paramContext);
      this.Edn.kv("appid", paramq.DYs);
      AppMethodBeat.o(96657);
      return;
    }
  }
  
  private boolean I(Context paramContext, final String paramString1, final String paramString2)
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
  
  protected final void fde()
  {
    AppMethodBeat.i(96658);
    Object localObject = fdx();
    if (h.s(this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject).DYs))
    {
      localObject = h.o(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject).DYs, true, false);
      if ((localObject != null) && (!TextUtils.isEmpty(((g)localObject).field_packageName)) && (I(this.context, ((g)localObject).field_packageName, h.a(this.context, (g)localObject, null))))
      {
        fdf();
        AppMethodBeat.o(96658);
        return;
      }
      super.fde();
      AppMethodBeat.o(96658);
      return;
    }
    super.fde();
    AppMethodBeat.o(96658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z
 * JD-Core Version:    0.7.0.1
 */