package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class s
  extends k
{
  public s(Context paramContext, l paraml, ViewGroup paramViewGroup)
  {
    super(paramContext, paraml, paramViewGroup);
  }
  
  protected final void e(Button paramButton)
  {
    AppMethodBeat.i(37237);
    l locall = cri();
    if (g.u(this.context, locall.rsf))
    {
      paramButton.setOnClickListener(new s.1(this, locall));
      AppMethodBeat.o(37237);
      return;
    }
    super.e(paramButton);
    AppMethodBeat.o(37237);
  }
  
  public final boolean v(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(37238);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)))
    {
      AppMethodBeat.o(37238);
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
        a.post(new s.2(this, paramString1, localIntent, paramString2));
        AppMethodBeat.o(37238);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      ab.e("AdLandingPageOpenAppBtnComp", bo.l(paramContext));
      AppMethodBeat.o(37238);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s
 * JD-Core Version:    0.7.0.1
 */