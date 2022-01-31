package com.tencent.tinker.lib.e;

import android.content.Intent;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class b
{
  public static boolean c(ApplicationLike paramApplicationLike)
  {
    if ((paramApplicationLike == null) || (paramApplicationLike.getApplication() == null)) {
      throw new TinkerRuntimeException("tinkerApplication is null");
    }
    return ShareTinkerInternals.Kl(paramApplicationLike.getTinkerFlags());
  }
  
  public static boolean d(ApplicationLike paramApplicationLike)
  {
    if ((paramApplicationLike == null) || (paramApplicationLike.getApplication() == null)) {
      throw new TinkerRuntimeException("tinkerApplication is null");
    }
    paramApplicationLike = paramApplicationLike.getTinkerResultIntent();
    if (paramApplicationLike == null) {}
    while (ShareIntentUtil.aA(paramApplicationLike) != 0) {
      return false;
    }
    return true;
  }
  
  public static String e(ApplicationLike paramApplicationLike)
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
      str = ShareIntentUtil.j((Intent)localObject, "intent_patch_old_version");
      localObject = ShareIntentUtil.j((Intent)localObject, "intent_patch_new_version");
      bool = ShareTinkerInternals.ie(paramApplicationLike.getApplication());
    } while ((str == null) || (localObject == null));
    if (bool) {
      return localObject;
    }
    return str;
  }
  
  public static void f(ApplicationLike paramApplicationLike)
  {
    if ((paramApplicationLike == null) || (paramApplicationLike.getApplication() == null)) {
      throw new TinkerRuntimeException("tinkerApplication is null");
    }
    if (d(paramApplicationLike)) {
      a.e("Tinker.TinkerApplicationHelper", "it is not safety to clean patch when tinker is loaded, you should kill all your process after clean!", new Object[0]);
    }
    SharePatchFileUtil.k(SharePatchFileUtil.hX(paramApplicationLike.getApplication()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.e.b
 * JD-Core Version:    0.7.0.1
 */