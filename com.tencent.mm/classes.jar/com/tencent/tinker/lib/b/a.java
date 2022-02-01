package com.tencent.tinker.lib.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.service.TinkerPatchForeService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a
  implements b
{
  ServiceConnection KqC;
  protected final Context context;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final int aTQ(String paramString)
  {
    int i = hi(paramString, SharePatchFileUtil.getMD5(new File(paramString)));
    if (i == 0) {}
    try
    {
      this.KqC = new ServiceConnection()
      {
        public final void onBindingDied(ComponentName paramAnonymousComponentName) {}
        
        public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {}
        
        public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
        {
          if ((a.this.context != null) && (a.this.KqC != null)) {}
          try
          {
            a.this.context.unbindService(a.this.KqC);
            return;
          }
          catch (Throwable paramAnonymousComponentName) {}
        }
      };
      Intent localIntent = new Intent(this.context, TinkerPatchForeService.class);
      this.context.bindService(localIntent, this.KqC, 1);
      label61:
      TinkerPatchService.cy(this.context, paramString);
      return i;
      com.tencent.tinker.lib.e.a.kX(this.context).KqU.d(new File(paramString), i);
      return i;
    }
    catch (Throwable localThrowable)
    {
      break label61;
    }
  }
  
  protected int hi(String paramString1, String paramString2)
  {
    int j = -2;
    Object localObject = com.tencent.tinker.lib.e.a.kX(this.context);
    int i;
    if ((!ShareTinkerInternals.isTinkerEnabled(((com.tencent.tinker.lib.e.a)localObject).tinkerFlags)) || (!ShareTinkerInternals.isTinkerEnableWithSharedPreferences(this.context))) {
      i = -1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (TextUtils.isEmpty(paramString2));
      i = j;
    } while (!SharePatchFileUtil.isLegalFile(new File(paramString1)));
    if (((com.tencent.tinker.lib.e.a)localObject).KqY) {
      return -4;
    }
    if (com.tencent.tinker.lib.util.b.kZ(this.context)) {
      return -3;
    }
    if (ShareTinkerInternals.isVmJit()) {
      return -5;
    }
    paramString1 = ((com.tencent.tinker.lib.e.a)localObject).KqZ;
    if ((((com.tencent.tinker.lib.e.a)localObject).zmI) && (paramString1 != null) && (paramString1.useInterpretMode)) {
      i = 1;
    }
    while (i == 0) {
      if ((((com.tencent.tinker.lib.e.a)localObject).Kra) && (paramString1 != null) && (paramString2.equals(paramString1.Kre)))
      {
        return -6;
        i = 0;
      }
      else
      {
        localObject = ((com.tencent.tinker.lib.e.a)localObject).KqS.getAbsolutePath();
        paramString1 = SharePatchFileUtil.getPatchInfoLockFile((String)localObject);
        localObject = SharePatchFileUtil.getPatchInfoFile((String)localObject);
        try
        {
          paramString1 = SharePatchInfo.readAndCheckPropertyWithLock((File)localObject, paramString1);
          if ((paramString1 != null) && (!ShareTinkerInternals.isNullOrNil(paramString1.newVersion)) && (!paramString1.isRemoveNewVersion))
          {
            boolean bool = paramString2.equals(paramString1.newVersion);
            if (bool) {
              return -6;
            }
          }
        }
        catch (Throwable paramString1) {}
      }
    }
    if (!com.tencent.tinker.lib.util.c.lc(this.context).aTT(paramString2)) {
      return -7;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.b.a
 * JD-Core Version:    0.7.0.1
 */