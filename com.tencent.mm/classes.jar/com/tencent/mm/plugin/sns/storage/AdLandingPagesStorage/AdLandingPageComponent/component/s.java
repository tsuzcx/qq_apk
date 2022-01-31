package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.cg.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class s
  extends l
{
  public s(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l paraml, ViewGroup paramViewGroup)
  {
    super(paramContext, paraml, paramViewGroup);
  }
  
  protected final void e(Button paramButton)
  {
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l locall = bFt();
    if (g.o(this.context, locall.oCE))
    {
      paramButton.setOnClickListener(new s.1(this, locall));
      return;
    }
    super.e(paramButton);
  }
  
  public final boolean q(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return false;
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
          return true;
        }
      }
      catch (Exception paramContext)
      {
        y.e("AdLandingPageOpenAppBtnComp", bk.j(paramContext));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s
 * JD-Core Version:    0.7.0.1
 */