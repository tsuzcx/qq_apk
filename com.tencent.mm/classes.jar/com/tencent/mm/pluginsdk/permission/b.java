package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class b
{
  private static HashMap<String, c> JXE;
  private static HashMap<String, d> JXF;
  
  static
  {
    AppMethodBeat.i(151866);
    JXE = new HashMap();
    JXF = new HashMap();
    AppMethodBeat.o(151866);
  }
  
  public static void a(int paramInt, c paramc, String[] paramArrayOfString)
  {
    AppMethodBeat.i(223776);
    if (paramc == null)
    {
      Log.i("MicroMsg.MPermissionUtil", "listener is null");
      AppMethodBeat.o(223776);
      return;
    }
    Log.i("MicroMsg.MPermissionUtil", "requestPermission requestCode:%s", new Object[] { Integer.valueOf(paramInt) });
    Context localContext = MMApplicationContext.getContext();
    Object localObject = new int[paramArrayOfString.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = 0;
      i += 1;
    }
    if ((Build.VERSION.SDK_INT < 23) || (e(localContext, paramArrayOfString)))
    {
      paramc.b(paramInt, (int[])localObject);
      AppMethodBeat.o(223776);
      return;
    }
    localObject = String.valueOf(System.currentTimeMillis());
    JXE.put(localObject, paramc);
    paramc = new Intent(localContext, PermissionActivity.class);
    paramc.putExtra("scene", 1);
    paramc.putExtra("requestCode", paramInt);
    paramc.putExtra("permission", paramArrayOfString);
    paramc.putExtra("key", (String)localObject);
    paramc.addFlags(268435456);
    paramc = new com.tencent.mm.hellhoundlib.b.a().bl(paramc);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, paramc.axQ(), "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "requestPermission", "(ILcom/tencent/mm/pluginsdk/permission/PermissionListener;[Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)paramc.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "requestPermission", "(ILcom/tencent/mm/pluginsdk/permission/PermissionListener;[Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(223776);
  }
  
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(151857);
    android.support.v4.app.a.a(paramActivity, paramArrayOfString, paramInt);
    AppMethodBeat.o(151857);
  }
  
  public static void a(Intent paramIntent, d paramd)
  {
    AppMethodBeat.i(151861);
    a(paramIntent, "", "", paramd);
    AppMethodBeat.o(151861);
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2, d paramd)
  {
    AppMethodBeat.i(151860);
    Log.i("MicroMsg.MPermissionUtil", "startSettings reasonTitle:%s, reasonMsg:%s", new Object[] { paramString1, paramString2 });
    String str = String.valueOf(System.currentTimeMillis());
    JXF.put(str, paramd);
    paramd = MMApplicationContext.getContext();
    Intent localIntent = new Intent(paramd, PermissionActivity.class);
    localIntent.putExtra("scene", 2);
    localIntent.setSelector(paramIntent);
    localIntent.putExtra("key", str);
    localIntent.putExtra("reasonTitle", paramString1);
    localIntent.putExtra("reasonMsg", paramString2);
    localIntent.addFlags(268435456);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramd, paramIntent.axQ(), "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "startSettings", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/permission/SettingsListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramd.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramd, "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "startSettings", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/permission/SettingsListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(151860);
  }
  
  public static void a(c paramc, String paramString)
  {
    AppMethodBeat.i(151858);
    a(1001, paramc, new String[] { paramString });
    AppMethodBeat.o(151858);
  }
  
  public static boolean a(Activity paramActivity, final String paramString1, final int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151851);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(151851);
      return true;
    }
    try
    {
      int i = android.support.v4.content.b.checkSelfPermission(paramActivity, paramString1);
      if (i == 0)
      {
        AppMethodBeat.o(151851);
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      AppMethodBeat.o(151851);
      return true;
    }
    if (!Util.isNullOrNil(paramString3)) {
      h.a(paramActivity, paramString3, paramString2, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(151849);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = this.val$activity;
          String str = paramString1;
          paramAnonymousInt = paramInt;
          android.support.v4.app.a.a(paramAnonymousDialogInterface, new String[] { str }, paramAnonymousInt);
          AppMethodBeat.o(151849);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(151851);
      return false;
      android.support.v4.app.a.a(paramActivity, new String[] { paramString1 }, paramInt);
    }
  }
  
  public static boolean a(Activity paramActivity, final String[] paramArrayOfString, final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(177303);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(177303);
      return true;
    }
    try
    {
      int m = paramArrayOfString.length;
      int j = 0;
      int i = 0;
      int k;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        i = android.support.v4.content.b.checkSelfPermission(paramActivity, paramArrayOfString[j]);
        k = i;
        if (i != 0) {
          break;
        }
        j += 1;
      }
      if (k != 0) {
        break label115;
      }
    }
    catch (Exception paramActivity)
    {
      Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      AppMethodBeat.o(177303);
      return true;
    }
    AppMethodBeat.o(177303);
    return true;
    label115:
    if (!Util.isNullOrNil(paramString2)) {
      h.a(paramActivity, paramString2, paramString1, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(151848);
          paramAnonymousDialogInterface.dismiss();
          android.support.v4.app.a.a(this.val$activity, paramArrayOfString, paramInt);
          AppMethodBeat.o(151848);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(177303);
      return false;
      android.support.v4.app.a.a(paramActivity, paramArrayOfString, paramInt);
    }
  }
  
  public static boolean aW(Activity paramActivity)
  {
    AppMethodBeat.i(151852);
    Log.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(o(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE")) });
    boolean bool = o(paramActivity, "android.permission.READ_PHONE_STATE");
    Log.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkPhone[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(151852);
      return false;
    }
    AppMethodBeat.o(151852);
    return true;
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(151856);
    android.support.v4.app.a.a(paramActivity, new String[] { paramString }, paramInt);
    AppMethodBeat.o(151856);
  }
  
  static c bdP(String paramString)
  {
    AppMethodBeat.i(151864);
    paramString = (c)JXE.remove(paramString);
    AppMethodBeat.o(151864);
    return paramString;
  }
  
  static d bdQ(String paramString)
  {
    AppMethodBeat.i(151865);
    paramString = (d)JXF.remove(paramString);
    AppMethodBeat.o(151865);
    return paramString;
  }
  
  private static boolean cl(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151863);
    try
    {
      int i = android.support.v4.content.b.checkSelfPermission(paramContext, paramString);
      if (i != 0)
      {
        AppMethodBeat.o(151863);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramContext });
      AppMethodBeat.o(151863);
      return false;
    }
    AppMethodBeat.o(151863);
    return true;
  }
  
  public static boolean e(Context paramContext, String... paramVarArgs)
  {
    AppMethodBeat.i(151862);
    if (paramVarArgs.length == 0)
    {
      AppMethodBeat.o(151862);
      return false;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (!cl(paramContext, paramVarArgs[i]))
      {
        AppMethodBeat.o(151862);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(151862);
    return true;
  }
  
  public static boolean k(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151855);
    int i;
    try
    {
      i = android.support.v4.content.b.checkSelfPermission(paramContext, paramString);
      if (i != 0)
      {
        AppMethodBeat.o(151855);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramContext });
      AppMethodBeat.o(151855);
      return false;
    }
    if (!paramBoolean)
    {
      AppMethodBeat.o(151855);
      return true;
    }
    String str = null;
    if (paramString.equals("android.permission.READ_CONTACTS"))
    {
      str = "android.permission.WRITE_CONTACTS";
      if (Util.isNullOrNil(str)) {
        break label156;
      }
    }
    label148:
    label156:
    for (;;)
    {
      try
      {
        i = android.support.v4.content.b.checkSelfPermission(paramContext, str);
        if (i != 0) {
          break label148;
        }
        AppMethodBeat.o(151855);
        return true;
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.MPermissionUtil", "check mpermission otherPermisson exception:%s.", new Object[] { paramContext });
        AppMethodBeat.o(151855);
        return false;
      }
      if (!paramString.equals("android.permission.WRITE_CONTACTS")) {
        break;
      }
      str = "android.permission.READ_CONTACTS";
      break;
      AppMethodBeat.o(151855);
      return false;
    }
  }
  
  public static boolean n(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151854);
    boolean bool = k(paramContext, paramString, true);
    AppMethodBeat.o(151854);
    return bool;
  }
  
  private static boolean o(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(151853);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(151853);
      return true;
    }
    try
    {
      int i = android.support.v4.content.b.checkSelfPermission(paramActivity, paramString);
      if (i == 0)
      {
        AppMethodBeat.o(151853);
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      AppMethodBeat.o(151853);
      return true;
    }
    AppMethodBeat.o(151853);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.b
 * JD-Core Version:    0.7.0.1
 */