package com.tencent.tinker.lib.e;

import android.content.Intent;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class b
{
  public static boolean c(ApplicationLike paramApplicationLike)
  {
    if ((paramApplicationLike == null) || (paramApplicationLike.getApplication() == null)) {
      throw new TinkerRuntimeException("tinkerApplication is null");
    }
    paramApplicationLike = paramApplicationLike.getTinkerResultIntent();
    if (paramApplicationLike == null) {}
    while (ShareIntentUtil.getIntentReturnCode(paramApplicationLike) != 0) {
      return false;
    }
    return true;
  }
  
  public static String d(ApplicationLike paramApplicationLike)
  {
    if ((paramApplicationLike == null) || (paramApplicationLike.getApplication() == null)) {
      throw new TinkerRuntimeException("tinkerApplication is null");
    }
    Object localObject = paramApplicationLike.getTinkerResultIntent();
    if (localObject == null) {}
    String str;
    boolean bool;
    do
    {
      return null;
      str = ShareIntentUtil.getStringExtra((Intent)localObject, "intent_patch_old_version");
      localObject = ShareIntentUtil.getStringExtra((Intent)localObject, "intent_patch_new_version");
      bool = ShareTinkerInternals.isInMainProcess(paramApplicationLike.getApplication());
    } while ((str == null) || (localObject == null));
    if (bool) {
      return localObject;
    }
    return str;
  }
  
  public static void e(ApplicationLike paramApplicationLike)
  {
    if ((paramApplicationLike == null) || (paramApplicationLike.getApplication() == null)) {
      throw new TinkerRuntimeException("tinkerApplication is null");
    }
    ShareTinkerInternals.cleanPatch(paramApplicationLike.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.e.b
 * JD-Core Version:    0.7.0.1
 */