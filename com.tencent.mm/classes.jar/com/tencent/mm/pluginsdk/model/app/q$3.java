package com.tencent.mm.pluginsdk.model.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

final class q$3
  implements Runnable
{
  q$3(Activity paramActivity, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(162009);
    if ((this.val$activity == null) || (this.val$activity.isFinishing()))
    {
      AppMethodBeat.o(162009);
      return;
    }
    Log.v("MicroMsg.AppUtil", "reportLaunchWechat");
    try
    {
      String str2 = q.aV(this.val$activity);
      boolean bool1;
      if (Util.isNullOrNil(str2))
      {
        bool1 = Util.isNullOrNil(this.val$url);
        if (bool1)
        {
          AppMethodBeat.o(162009);
          return;
        }
      }
      Object localObject1 = this.val$activity;
      Object localObject2 = new Intent("android.intent.action.MAIN", null);
      ((Intent)localObject2).addCategory("android.intent.category.HOME");
      localObject1 = ((Activity)localObject1).getPackageManager().queryIntentActivities((Intent)localObject2, 0);
      int i;
      if (!Util.isNullOrNil((List)localObject1))
      {
        i = 0;
        if (i < ((List)localObject1).size()) {
          if (Util.isEqual(str2, ((ResolveInfo)((List)localObject1).get(i)).activityInfo.packageName))
          {
            bool1 = true;
            label157:
            boolean bool2 = Util.isNullOrNil(this.val$url);
            if (bool2) {
              break label287;
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = URLEncoder.encode(this.val$url, "UTF-8");
          localObject2 = h.CyF;
          if (!bool1) {
            break label294;
          }
          i = 1;
          ((h)localObject2).a(17591, new Object[] { "", str2, localObject1, Integer.valueOf(i) });
          Log.i("MicroMsg.AppUtil", "reportLaunchWechat callPackage=%s, isCategoryHome = %b, url=%s, isCategoryHome= %b", new Object[] { str2, Boolean.valueOf(bool1), localObject1, Boolean.valueOf(bool1) });
          AppMethodBeat.o(162009);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Log.e("MicroMsg.AppUtil", "reportLaunchWechat parse fail");
        }
        i += 1;
        break;
        bool1 = false;
        break label157;
        label287:
        String str1 = "";
        continue;
        label294:
        i = 0;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppUtil", "reportLaunchWechat ex:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(162009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.q.3
 * JD-Core Version:    0.7.0.1
 */