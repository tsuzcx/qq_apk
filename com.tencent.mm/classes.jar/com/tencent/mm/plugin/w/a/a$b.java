package com.tencent.mm.plugin.w.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Collection;
import java.util.List;

abstract class a$b
{
  public final boolean cms()
  {
    List localList = ah.getContext().getPackageManager().queryIntentActivities(cmt(), 0);
    if ((localList == null) || (localList.isEmpty())) {}
    for (int i = 1; (i == 0) && (((ResolveInfo)localList.get(0)).activityInfo.exported); i = 0) {
      return true;
    }
    return false;
  }
  
  protected abstract Intent cmt();
  
  public final void eS(Context paramContext)
  {
    Intent localIntent = cmt();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.w.a.a.b
 * JD-Core Version:    0.7.0.1
 */