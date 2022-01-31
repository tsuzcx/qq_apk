package com.tencent.mm.pluginsdk.model.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

final class p$1
  implements Runnable
{
  p$1(Activity paramActivity, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(151616);
    if ((this.val$activity == null) || (this.val$activity.isFinishing()))
    {
      AppMethodBeat.o(151616);
      return;
    }
    ab.v("MicroMsg.AppUtil", "reportLaunchWechat");
    try
    {
      String str2 = p.ap(this.val$activity);
      boolean bool1;
      if (bo.isNullOrNil(str2))
      {
        bool1 = bo.isNullOrNil(this.val$url);
        if (bool1)
        {
          AppMethodBeat.o(151616);
          return;
        }
      }
      Object localObject1 = this.val$activity;
      Object localObject2 = new Intent("android.intent.action.MAIN", null);
      ((Intent)localObject2).addCategory("android.intent.category.HOME");
      localObject1 = ((Activity)localObject1).getPackageManager().queryIntentActivities((Intent)localObject2, 0);
      int i;
      if (!bo.es((List)localObject1))
      {
        i = 0;
        if (i < ((List)localObject1).size()) {
          if (bo.isEqual(str2, ((ResolveInfo)((List)localObject1).get(i)).activityInfo.packageName))
          {
            bool1 = true;
            label157:
            boolean bool2 = bo.isNullOrNil(this.val$url);
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
          localObject2 = h.qsU;
          if (!bool1) {
            break label294;
          }
          i = 1;
          ((h)localObject2).e(17591, new Object[] { "", str2, localObject1, Integer.valueOf(i) });
          ab.i("MicroMsg.AppUtil", "reportLaunchWechat callPackage=%s, isCategoryHome = %b, url=%s, isCategoryHome= %b", new Object[] { str2, Boolean.valueOf(bool1), localObject1, Boolean.valueOf(bool1) });
          AppMethodBeat.o(151616);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ab.e("MicroMsg.AppUtil", "reportLaunchWechat parse fail");
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
      ab.e("MicroMsg.AppUtil", "reportLaunchWechat ex:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(151616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.p.1
 * JD-Core Version:    0.7.0.1
 */