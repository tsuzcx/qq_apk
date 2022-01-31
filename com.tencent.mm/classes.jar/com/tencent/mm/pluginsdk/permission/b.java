package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class b
{
  private static HashMap<String, c> vMr;
  private static HashMap<String, d> vMs;
  
  static
  {
    AppMethodBeat.i(79426);
    vMr = new HashMap();
    vMs = new HashMap();
    AppMethodBeat.o(79426);
  }
  
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(79418);
    a.a(paramActivity, paramArrayOfString, paramInt);
    AppMethodBeat.o(79418);
  }
  
  public static void a(Intent paramIntent, d paramd)
  {
    AppMethodBeat.i(79421);
    a(paramIntent, "", "", paramd);
    AppMethodBeat.o(79421);
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2, d paramd)
  {
    AppMethodBeat.i(79420);
    ab.i("MicroMsg.MPermissionUtil", "startSettings reasonTitle:%s, reasonMsg:%s", new Object[] { paramString1, paramString2 });
    String str = String.valueOf(System.currentTimeMillis());
    vMs.put(str, paramd);
    paramd = ah.getContext();
    Intent localIntent = new Intent(paramd, PermissionActivity.class);
    localIntent.putExtra("scene", 2);
    localIntent.setSelector(paramIntent);
    localIntent.putExtra("key", str);
    localIntent.putExtra("reasonTitle", paramString1);
    localIntent.putExtra("reasonMsg", paramString2);
    localIntent.addFlags(268435456);
    paramd.startActivity(localIntent);
    AppMethodBeat.o(79420);
  }
  
  public static void a(c paramc, String[] paramArrayOfString)
  {
    AppMethodBeat.i(79419);
    ab.i("MicroMsg.MPermissionUtil", "requestPermission requestCode:%s", new Object[] { Integer.valueOf(1001) });
    Context localContext = ah.getContext();
    Object localObject = new int[2];
    int i = 0;
    while (i < 2)
    {
      localObject[i] = 0;
      i += 1;
    }
    if ((Build.VERSION.SDK_INT < 23) || (e(localContext, paramArrayOfString)))
    {
      paramc.t((int[])localObject);
      AppMethodBeat.o(79419);
      return;
    }
    localObject = String.valueOf(System.currentTimeMillis());
    vMr.put(localObject, paramc);
    paramc = new Intent(localContext, PermissionActivity.class);
    paramc.putExtra("scene", 1);
    paramc.putExtra("requestCode", 1001);
    paramc.putExtra("permission", paramArrayOfString);
    paramc.putExtra("key", (String)localObject);
    paramc.addFlags(268435456);
    localContext.startActivity(paramc);
    AppMethodBeat.o(79419);
  }
  
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(79412);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(79412);
      return true;
    }
    try
    {
      int i = android.support.v4.content.b.checkSelfPermission(paramActivity, paramString1);
      if (i == 0)
      {
        AppMethodBeat.o(79412);
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      ab.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      AppMethodBeat.o(79412);
      return true;
    }
    if (!bo.isNullOrNil(paramString3)) {
      h.a(paramActivity, paramString3, paramString2, false, new b.2(paramActivity, paramString1, paramInt));
    }
    for (;;)
    {
      AppMethodBeat.o(79412);
      return false;
      a.a(paramActivity, new String[] { paramString1 }, paramInt);
    }
  }
  
  static c alB(String paramString)
  {
    AppMethodBeat.i(79424);
    paramString = (c)vMr.remove(paramString);
    AppMethodBeat.o(79424);
    return paramString;
  }
  
  static d alC(String paramString)
  {
    AppMethodBeat.i(79425);
    paramString = (d)vMs.remove(paramString);
    AppMethodBeat.o(79425);
    return paramString;
  }
  
  public static boolean aq(Activity paramActivity)
  {
    AppMethodBeat.i(79413);
    boolean bool = j(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
    ab.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(79413);
      return false;
    }
    bool = j(paramActivity, "android.permission.READ_PHONE_STATE");
    ab.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkPhone[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(79413);
      return false;
    }
    AppMethodBeat.o(79413);
    return true;
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(79417);
    a.a(paramActivity, new String[] { paramString }, paramInt);
    AppMethodBeat.o(79417);
  }
  
  public static boolean b(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(151621);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(151621);
      return true;
    }
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j < 2) {
        try
        {
          i = android.support.v4.content.b.checkSelfPermission(paramActivity, paramArrayOfString[j]);
          k = i;
          if (i == 0) {
            j += 1;
          }
        }
        catch (Exception paramActivity)
        {
          ab.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
          AppMethodBeat.o(151621);
          return true;
        }
      }
    }
    if (k == 0)
    {
      AppMethodBeat.o(151621);
      return true;
    }
    if (!bo.isNullOrNil(null)) {
      h.a(paramActivity, null, null, false, new b.1(paramActivity, paramArrayOfString, paramInt));
    }
    for (;;)
    {
      AppMethodBeat.o(151621);
      return false;
      a.a(paramActivity, paramArrayOfString, paramInt);
    }
  }
  
  private static boolean bx(Context paramContext, String paramString)
  {
    AppMethodBeat.i(79423);
    try
    {
      int i = android.support.v4.content.b.checkSelfPermission(paramContext, paramString);
      if (i != 0)
      {
        AppMethodBeat.o(79423);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramContext });
      AppMethodBeat.o(79423);
      return false;
    }
    AppMethodBeat.o(79423);
    return true;
  }
  
  public static boolean e(Context paramContext, String... paramVarArgs)
  {
    AppMethodBeat.i(79422);
    if (paramVarArgs.length == 0)
    {
      AppMethodBeat.o(79422);
      return false;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (!bx(paramContext, paramVarArgs[i]))
      {
        AppMethodBeat.o(79422);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(79422);
    return true;
  }
  
  public static boolean i(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(79416);
    int i;
    try
    {
      i = android.support.v4.content.b.checkSelfPermission(paramContext, paramString);
      if (i != 0)
      {
        AppMethodBeat.o(79416);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramContext });
      AppMethodBeat.o(79416);
      return false;
    }
    if (!paramBoolean)
    {
      AppMethodBeat.o(79416);
      return true;
    }
    String str = null;
    if (paramString.equals("android.permission.READ_CONTACTS"))
    {
      str = "android.permission.WRITE_CONTACTS";
      if (bo.isNullOrNil(str)) {
        break label144;
      }
    }
    label137:
    label144:
    for (;;)
    {
      try
      {
        i = android.support.v4.content.b.checkSelfPermission(paramContext, str);
        if (i != 0) {
          break label137;
        }
        AppMethodBeat.o(79416);
        return true;
      }
      catch (Exception paramContext)
      {
        ab.e("MicroMsg.MPermissionUtil", "check mpermission otherPermisson exception:%s.", new Object[] { paramContext });
        AppMethodBeat.o(79416);
        return false;
      }
      if (!paramString.equals("android.permission.WRITE_CONTACTS")) {
        break;
      }
      str = "android.permission.READ_CONTACTS";
      break;
      AppMethodBeat.o(79416);
      return false;
    }
  }
  
  private static boolean j(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(79414);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(79414);
      return true;
    }
    try
    {
      int i = android.support.v4.content.b.checkSelfPermission(paramActivity, paramString);
      if (i == 0)
      {
        AppMethodBeat.o(79414);
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      ab.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      AppMethodBeat.o(79414);
      return true;
    }
    AppMethodBeat.o(79414);
    return false;
  }
  
  public static boolean o(Context paramContext, String paramString)
  {
    AppMethodBeat.i(79415);
    boolean bool = i(paramContext, paramString, true);
    AppMethodBeat.o(79415);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.b
 * JD-Core Version:    0.7.0.1
 */