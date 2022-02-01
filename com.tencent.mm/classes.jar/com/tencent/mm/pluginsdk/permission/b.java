package com.tencent.mm.pluginsdk.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.vas.VASActivity;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.b;
import java.util.HashMap;

public final class b
{
  private static HashMap<String, c> XUe;
  private static HashMap<String, d> XUf;
  
  static
  {
    AppMethodBeat.i(151866);
    XUe = new HashMap();
    XUf = new HashMap();
    AppMethodBeat.o(151866);
  }
  
  public static void a(int paramInt, c paramc, String[] paramArrayOfString)
  {
    AppMethodBeat.i(244646);
    a(MMApplicationContext.getContext(), paramInt, paramc, paramArrayOfString);
    AppMethodBeat.o(244646);
  }
  
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(151857);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      iw(paramArrayOfString[i], paramInt);
      i += 1;
    }
    androidx.core.app.a.a(paramActivity, paramArrayOfString, paramInt);
    AppMethodBeat.o(151857);
  }
  
  public static void a(Context paramContext, int paramInt, c paramc, String[] paramArrayOfString)
  {
    int j = 0;
    AppMethodBeat.i(244657);
    if (paramc == null)
    {
      Log.i("MicroMsg.MPermissionUtil", "listener is null");
      AppMethodBeat.o(244657);
      return;
    }
    Log.i("MicroMsg.MPermissionUtil", "requestPermission requestCode:%s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new int[paramArrayOfString.length];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = 0;
      i += 1;
    }
    if ((Build.VERSION.SDK_INT < 23) || (g(paramContext, paramArrayOfString)))
    {
      paramc.onRequestPermissionsResult(paramInt, paramArrayOfString, (int[])localObject);
      AppMethodBeat.o(244657);
      return;
    }
    localObject = String.valueOf(System.currentTimeMillis());
    XUe.put(localObject, paramc);
    paramc = new Intent(paramContext, PermissionActivity.class);
    paramc.putExtra("scene", 1);
    paramc.putExtra("requestCode", paramInt);
    paramc.putExtra("permission", paramArrayOfString);
    paramc.putExtra("key", (String)localObject);
    if (!(paramContext instanceof Activity)) {
      paramc.addFlags(268435456);
    }
    paramc = new com.tencent.mm.hellhoundlib.b.a().cG(paramc);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramc.aYi(), "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "requestPermission", "(Landroid/content/Context;ILcom/tencent/mm/pluginsdk/permission/PermissionListener;[Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramc.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "requestPermission", "(Landroid/content/Context;ILcom/tencent/mm/pluginsdk/permission/PermissionListener;[Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    int k = paramArrayOfString.length;
    i = j;
    while (i < k)
    {
      iw(paramArrayOfString[i], paramInt);
      i += 1;
    }
    AppMethodBeat.o(244657);
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
    XUf.put(str, paramd);
    paramd = MMApplicationContext.getContext();
    Intent localIntent = new Intent(paramd, PermissionActivity.class);
    localIntent.putExtra("scene", 2);
    localIntent.setSelector(paramIntent);
    localIntent.putExtra("key", str);
    localIntent.putExtra("reasonTitle", paramString1);
    localIntent.putExtra("reasonMsg", paramString2);
    localIntent.addFlags(268435456);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramd, paramIntent.aYi(), "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "startSettings", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/permission/SettingsListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramd.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramd, "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "startSettings", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/permission/SettingsListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(151860);
  }
  
  public static void a(c paramc, String paramString)
  {
    AppMethodBeat.i(151858);
    a(1001, paramc, new String[] { paramString });
    AppMethodBeat.o(151858);
  }
  
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(244627);
    boolean bool = a(paramActivity, paramString1, paramInt, paramString2, null);
    AppMethodBeat.o(244627);
    return bool;
  }
  
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2, g.b paramb)
  {
    AppMethodBeat.i(244631);
    boolean bool = a(paramActivity, paramString1, paramInt, paramString2, paramb, Boolean.FALSE);
    AppMethodBeat.o(244631);
    return bool;
  }
  
  public static boolean a(final Activity paramActivity, String paramString1, final int paramInt, String paramString2, final g.b paramb, final Boolean paramBoolean)
  {
    AppMethodBeat.i(244634);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(244634);
      return true;
    }
    try
    {
      int i = androidx.core.content.a.checkSelfPermission(paramActivity, paramString1);
      if (i == 0)
      {
        AppMethodBeat.o(244634);
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      AppMethodBeat.o(244634);
      return true;
    }
    paramString2 = ae(paramActivity, paramString1, paramString2);
    if ((!Util.isNullOrNil(paramString2)) && (q(paramActivity, paramInt)))
    {
      g.a locala = new g.a(paramActivity);
      locala.bDE(paramString2);
      locala.NF(false);
      locala.bDI(paramActivity.getString(c.h.app_to_authorize));
      locala.a(new g.b()
      {
        public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(244569);
          if (paramAnonymousBoolean1)
          {
            b.iw(b.this, paramInt);
            if ((paramActivity instanceof VASActivity))
            {
              paramAnonymousString = (VASActivity)paramActivity;
              str = b.this;
              i = paramInt;
              if (paramAnonymousString.handleRequestPermissions(new String[] { str }, i))
              {
                AppMethodBeat.o(244569);
                return;
              }
            }
            paramAnonymousString = paramActivity;
            String str = b.this;
            int i = paramInt;
            androidx.core.app.a.a(paramAnonymousString, new String[] { str }, i);
            AppMethodBeat.o(244569);
            return;
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (!paramBoolean.booleanValue())
            {
              paramActivity.onRequestPermissionsResult(paramInt, new String[] { b.this }, new int[] { -1 });
              AppMethodBeat.o(244569);
            }
          }
          else if (paramb != null) {
            paramb.e(paramAnonymousBoolean1, paramAnonymousString, paramAnonymousBoolean2);
          }
          AppMethodBeat.o(244569);
        }
      });
      iv(paramString1, paramInt);
      paramActivity = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(244568);
          b.this.show();
          AppMethodBeat.o(244568);
        }
      };
      if (MMHandlerThread.isMainThread()) {
        paramActivity.run();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(244634);
      return false;
      MMHandlerThread.postToMainThread(paramActivity);
      continue;
      iw(paramString1, paramInt);
      if ((paramActivity instanceof VASActivity)) {
        if (((VASActivity)paramActivity).handleRequestPermissions(new String[] { paramString1 }, paramInt))
        {
          AppMethodBeat.o(244634);
          return false;
        }
      }
      androidx.core.app.a.a(paramActivity, new String[] { paramString1 }, paramInt);
    }
  }
  
  public static boolean a(final Activity paramActivity, String[] paramArrayOfString, final int paramInt, String paramString)
  {
    AppMethodBeat.i(244625);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(244625);
      return true;
    }
    int j;
    int i;
    String str;
    try
    {
      int k = paramArrayOfString.length;
      j = 0;
      i = 0;
      for (;;)
      {
        str = paramString;
        if (j < k)
        {
          str = paramArrayOfString[j];
          i = androidx.core.content.a.checkSelfPermission(paramActivity, str);
          if (i != 0) {
            str = ae(paramActivity, str, paramString);
          }
        }
        else
        {
          if (i != 0) {
            break;
          }
          AppMethodBeat.o(244625);
          return true;
        }
        j += 1;
      }
      if (Util.isNullOrNil(str)) {
        break label235;
      }
    }
    catch (Exception paramActivity)
    {
      Log.e("MicroMsg.MPermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      AppMethodBeat.o(244625);
      return true;
    }
    if (q(paramActivity, paramInt))
    {
      paramString = new g.a(paramActivity);
      paramString.bDE(str);
      paramString.NF(false);
      paramString.bDI(paramActivity.getString(c.h.app_to_authorize));
      paramString.a(new g.b()
      {
        public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
        {
          int i = 0;
          AppMethodBeat.i(244570);
          if (paramAnonymousBoolean1)
          {
            paramAnonymousString = b.this;
            int j = paramAnonymousString.length;
            while (i < j)
            {
              b.iw(paramAnonymousString[i], paramInt);
              i += 1;
            }
            if (((paramActivity instanceof VASActivity)) && (((VASActivity)paramActivity).handleRequestPermissions(b.this, paramInt)))
            {
              AppMethodBeat.o(244570);
              return;
            }
            androidx.core.app.a.a(paramActivity, b.this, paramInt);
            AppMethodBeat.o(244570);
            return;
          }
          if (Build.VERSION.SDK_INT >= 23) {
            paramActivity.onRequestPermissionsResult(paramInt, b.this, new int[] { -1 });
          }
          AppMethodBeat.o(244570);
        }
      });
      j = paramArrayOfString.length;
      i = 0;
      while (i < j)
      {
        iv(paramArrayOfString[i], paramInt);
        i += 1;
      }
      paramString.show();
    }
    for (;;)
    {
      AppMethodBeat.o(244625);
      return false;
      label235:
      j = paramArrayOfString.length;
      i = 0;
      while (i < j)
      {
        iw(paramArrayOfString[i], paramInt);
        i += 1;
      }
      if (((paramActivity instanceof VASActivity)) && (((VASActivity)paramActivity).handleRequestPermissions(paramArrayOfString, paramInt)))
      {
        AppMethodBeat.o(244625);
        return false;
      }
      androidx.core.app.a.a(paramActivity, paramArrayOfString, paramInt);
    }
  }
  
  private static String ae(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(244619);
    if (!Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(244619);
      return paramString2;
    }
    if (("android.permission.ACCESS_FINE_LOCATION".equals(paramString1)) || ("android.permission.ACCESS_COARSE_LOCATION".equals(paramString1)))
    {
      paramContext = paramContext.getString(c.h.common_request_permission_reason_location);
      AppMethodBeat.o(244619);
      return paramContext;
    }
    if (("android.permission.READ_EXTERNAL_STORAGE".equals(paramString1)) || ("android.permission.WRITE_EXTERNAL_STORAGE".equals(paramString1)))
    {
      paramContext = paramContext.getString(c.h.common_request_permission_storage);
      AppMethodBeat.o(244619);
      return paramContext;
    }
    if ("android.permission.RECORD_AUDIO".equals(paramString1))
    {
      paramContext = paramContext.getString(c.h.common_request_permission_reason_microphone);
      AppMethodBeat.o(244619);
      return paramContext;
    }
    if ("android.permission.CAMERA".equals(paramString1))
    {
      paramContext = paramContext.getString(c.h.common_request_permission_reason_camera);
      AppMethodBeat.o(244619);
      return paramContext;
    }
    if ("android.permission.READ_CONTACTS".equals(paramString1))
    {
      paramContext = paramContext.getString(c.h.common_request_permission_reason_read_contacts);
      AppMethodBeat.o(244619);
      return paramContext;
    }
    if ("android.permission.ACTIVITY_RECOGNITION".equals(paramString1))
    {
      paramContext = paramContext.getString(c.h.common_request_permission_reason_sport);
      AppMethodBeat.o(244619);
      return paramContext;
    }
    AppMethodBeat.o(244619);
    return null;
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt)
  {
    AppMethodBeat.i(151856);
    iw(paramString, paramInt);
    androidx.core.app.a.a(paramActivity, new String[] { paramString }, paramInt);
    AppMethodBeat.o(151856);
  }
  
  public static void bG(Activity paramActivity)
  {
    AppMethodBeat.i(244691);
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + paramActivity.getPackageName()));
    localIntent.addFlags(268435456);
    if (Util.isIntentAvailable(paramActivity, localIntent)) {
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(564, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "gotoSystemAppMgrUI", "(Landroid/app/Activity;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    }
    AppMethodBeat.o(244691);
  }
  
  static c bqa(String paramString)
  {
    AppMethodBeat.i(151864);
    paramString = (c)XUe.remove(paramString);
    AppMethodBeat.o(151864);
    return paramString;
  }
  
  static d bqb(String paramString)
  {
    AppMethodBeat.i(151865);
    paramString = (d)XUf.remove(paramString);
    AppMethodBeat.o(151865);
    return paramString;
  }
  
  public static boolean c(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(244614);
    if (g(paramActivity, paramArrayOfString))
    {
      AppMethodBeat.o(244614);
      return true;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = paramArrayOfString[i];
      String str2 = "had_show_rationale_dlg_" + str1 + "_" + paramInt;
      long l1 = MultiProcessMMKV.getDefault().getLong(str2, 0L);
      long l2 = ix(str1, paramInt);
      if ((System.currentTimeMillis() - l1 < 172800000L) || ((l2 != 0L) && (!androidx.core.app.a.a(paramActivity, str1))))
      {
        AppMethodBeat.o(244614);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(244614);
    return true;
  }
  
  private static boolean cI(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151863);
    try
    {
      int i = androidx.core.content.a.checkSelfPermission(paramContext, paramString);
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
  
  public static boolean g(Context paramContext, String... paramVarArgs)
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
      if (!cI(paramContext, paramVarArgs[i]))
      {
        AppMethodBeat.o(151862);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(151862);
    return true;
  }
  
  public static void iv(String paramString, int paramInt)
  {
    AppMethodBeat.i(244590);
    paramString = "had_show_rationale_dlg_" + paramString + "_" + paramInt;
    MultiProcessMMKV.getDefault().putLong(paramString, System.currentTimeMillis());
    AppMethodBeat.o(244590);
  }
  
  public static void iw(String paramString, int paramInt)
  {
    AppMethodBeat.i(244597);
    paramString = "had_request_permission_" + paramString + "_" + paramInt;
    MultiProcessMMKV.getDefault().putLong(paramString, System.currentTimeMillis());
    AppMethodBeat.o(244597);
  }
  
  public static long ix(String paramString, int paramInt)
  {
    AppMethodBeat.i(244608);
    paramString = "had_request_permission_" + paramString + "_" + paramInt;
    long l = MultiProcessMMKV.getDefault().getLong(paramString, 0L);
    AppMethodBeat.o(244608);
    return l;
  }
  
  public static boolean k(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(151855);
    int i;
    try
    {
      i = androidx.core.content.a.checkSelfPermission(paramContext, paramString);
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
    if (!Util.isNullOrNil(null)) {}
    try
    {
      i = androidx.core.content.a.checkSelfPermission(paramContext, null);
      if (i == 0)
      {
        AppMethodBeat.o(151855);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.MPermissionUtil", "check mpermission otherPermisson exception:%s.", new Object[] { paramContext });
      AppMethodBeat.o(151855);
      return false;
    }
    AppMethodBeat.o(151855);
    return false;
  }
  
  public static boolean lw(Context paramContext)
  {
    AppMethodBeat.i(244680);
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = Settings.canDrawOverlays(paramContext);
      AppMethodBeat.o(244680);
      return bool;
    }
    AppMethodBeat.o(244680);
    return true;
  }
  
  public static void lx(Context paramContext)
  {
    AppMethodBeat.i(244686);
    Object localObject = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + paramContext.getPackageName()));
    ((Intent)localObject).addFlags(268435456);
    if (Util.isIntentAvailable(paramContext, (Intent)localObject))
    {
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "gotoSystemAppMgrUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/pluginsdk/permission/MPermissionUtil", "gotoSystemAppMgrUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(244686);
  }
  
  private static boolean q(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(244697);
    if ((paramActivity.getClass().getSimpleName().equals("FinderLiveVisitorWithoutAffinityUI")) && ((paramInt == 1002) || (paramInt == 1001)))
    {
      AppMethodBeat.o(244697);
      return false;
    }
    if (!MultiProcessMMKV.getMMKV("MMKV_KEY_EXPT_VALUE").getBoolean("MMKV_KEY_EXPT_PERMISSION_DIALOG", true)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yJM, paramInt) == 0)
      {
        AppMethodBeat.o(244697);
        return true;
      }
      AppMethodBeat.o(244697);
      return false;
    }
  }
  
  public static boolean s(Context paramContext, String paramString)
  {
    AppMethodBeat.i(151854);
    boolean bool = k(paramContext, paramString, true);
    AppMethodBeat.o(151854);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.permission.b
 * JD-Core Version:    0.7.0.1
 */