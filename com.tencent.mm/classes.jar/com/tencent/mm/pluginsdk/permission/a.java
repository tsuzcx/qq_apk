package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public final class a
{
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME))) {
      return true;
    }
    for (;;)
    {
      try
      {
        int i = b.checkSelfPermission(paramActivity, paramString1);
        if (i == 0) {
          break;
        }
        if (!bk.bl(paramString3))
        {
          h.a(paramActivity, paramString3, paramString2, false, new a.1(paramActivity, paramString1, paramInt));
          return false;
        }
      }
      catch (Exception paramActivity)
      {
        y.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
        return true;
      }
      android.support.v4.app.a.a(paramActivity, new String[] { paramString1 }, paramInt);
    }
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt)
  {
    android.support.v4.app.a.a(paramActivity, new String[] { paramString }, paramInt);
  }
  
  public static boolean g(Activity paramActivity, String paramString)
  {
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME))) {}
    for (;;)
    {
      return true;
      try
      {
        int i = b.checkSelfPermission(paramActivity, paramString);
        if (i != 0) {
          return false;
        }
      }
      catch (Exception paramActivity)
      {
        y.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      }
    }
    return true;
  }
  
  public static boolean j(Context paramContext, String paramString)
  {
    int i;
    try
    {
      i = b.checkSelfPermission(paramContext, paramString);
      if (i != 0) {
        return false;
      }
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramContext });
      return false;
    }
    String str = null;
    if (paramString.equals("android.permission.READ_CONTACTS"))
    {
      str = "android.permission.WRITE_CONTACTS";
      if (bk.bl(str)) {
        break label98;
      }
    }
    label96:
    label98:
    for (;;)
    {
      try
      {
        i = b.checkSelfPermission(paramContext, str);
        if (i != 0) {
          break label96;
        }
        return true;
      }
      catch (Exception paramContext)
      {
        y.e("MicroMsg.MPermissionUtil", "check mpermission otherPermisson exception:%s.", new Object[] { paramContext });
        return false;
      }
      if (!paramString.equals("android.permission.WRITE_CONTACTS")) {
        break;
      }
      str = "android.permission.READ_CONTACTS";
      break;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.a
 * JD-Core Version:    0.7.0.1
 */