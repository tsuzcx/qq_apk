package com.tencent.mm.plugin.x.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;
import java.util.List;

public final class a
{
  private static final a DlV;
  
  static
  {
    AppMethodBeat.i(151586);
    DlV = new a()
    {
      public final int eVm()
      {
        return -1;
      }
      
      public final boolean eVn()
      {
        return false;
      }
      
      public final void gX(Context paramAnonymousContext) {}
    };
    AppMethodBeat.o(151586);
  }
  
  public static a eVl()
  {
    AppMethodBeat.i(151585);
    b localb = new b();
    AppMethodBeat.o(151585);
    return localb;
  }
  
  public static abstract class a
  {
    public abstract int eVm();
    
    public abstract boolean eVn();
    
    public abstract void gX(Context paramContext);
  }
  
  static abstract class b
  {
    public final boolean eVo()
    {
      List localList = MMApplicationContext.getContext().getPackageManager().queryIntentActivities(eVp(), 0);
      if ((localList == null) || (localList.isEmpty())) {}
      for (int i = 1; (i == 0) && (((ResolveInfo)localList.get(0)).activityInfo.exported); i = 0) {
        return true;
      }
      return false;
    }
    
    protected abstract Intent eVp();
    
    public final void gY(Context paramContext)
    {
      Object localObject = eVp();
      if (!(paramContext instanceof Activity)) {
        ((Intent)localObject).addFlags(268435456);
      }
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/shortcut/permission/AppPermissionSettingAdapterFactory$SettingPageJumper", "jump", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/shortcut/permission/AppPermissionSettingAdapterFactory$SettingPageJumper", "jump", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.x.a.a
 * JD-Core Version:    0.7.0.1
 */