package com.tencent.mm.plugin.x.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Collection;
import java.util.List;

abstract class a$b
{
  public final boolean dqf()
  {
    List localList = aj.getContext().getPackageManager().queryIntentActivities(dqg(), 0);
    if ((localList == null) || (localList.isEmpty())) {}
    for (int i = 1; (i == 0) && (((ResolveInfo)localList.get(0)).activityInfo.exported); i = 0) {
      return true;
    }
    return false;
  }
  
  protected abstract Intent dqg();
  
  public final void fR(Context paramContext)
  {
    Object localObject = dqg();
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/shortcut/permission/AppPermissionSettingAdapterFactory$SettingPageJumper", "jump", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/shortcut/permission/AppPermissionSettingAdapterFactory$SettingPageJumper", "jump", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.x.a.a.b
 * JD-Core Version:    0.7.0.1
 */