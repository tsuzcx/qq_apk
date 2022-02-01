package com.tencent.tinker.lib.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.tinker.lib.service.TinkerPatchForeService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a
  implements b
{
  ServiceConnection ahRm;
  protected final Context context;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final int bGk(String paramString)
  {
    int i = jG(paramString, SharePatchFileUtil.getMD5(new File(paramString)));
    if (i == 0) {}
    try
    {
      this.ahRm = new ServiceConnection()
      {
        public final void onBindingDied(ComponentName paramAnonymousComponentName) {}
        
        public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {}
        
        public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
        {
          if ((a.this.context != null) && (a.this.ahRm != null)) {}
          try
          {
            a.this.context.unbindService(a.this.ahRm);
            return;
          }
          finally {}
        }
      };
      Intent localIntent = new Intent(this.context, TinkerPatchForeService.class);
      this.context.bindService(localIntent, this.ahRm, 1);
      label61:
      TinkerPatchService.dr(this.context, paramString);
      return i;
      com.tencent.tinker.lib.e.a.oy(this.context).ahRH.g(new File(paramString), i);
      return i;
    }
    finally
    {
      break label61;
    }
  }
  
  protected int jG(String paramString1, String paramString2)
  {
    int j = -2;
    Object localObject = com.tencent.tinker.lib.e.a.oy(this.context);
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
    if (((com.tencent.tinker.lib.e.a)localObject).ahRL) {
      return -4;
    }
    if (com.tencent.tinker.lib.f.c.oA(this.context)) {
      return -3;
    }
    if (ShareTinkerInternals.isVmJit()) {
      return -5;
    }
    paramString1 = ((com.tencent.tinker.lib.e.a)localObject).ahRM;
    if ((((com.tencent.tinker.lib.e.a)localObject).rgc) && (paramString1 != null) && (paramString1.useInterpretMode)) {
      i = 1;
    }
    while (i == 0) {
      if ((((com.tencent.tinker.lib.e.a)localObject).ahRN) && (paramString1 != null) && (paramString2.equals(paramString1.ahRR)))
      {
        return -6;
        i = 0;
      }
      else
      {
        localObject = ((com.tencent.tinker.lib.e.a)localObject).ahRF.getAbsolutePath();
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
        finally {}
      }
    }
    if (!com.tencent.tinker.lib.f.d.oD(this.context).bGn(paramString2)) {
      return -7;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.b.a
 * JD-Core Version:    0.7.0.1
 */