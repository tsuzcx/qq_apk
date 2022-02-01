package com.tencent.mm.plugin.y.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Collection;
import java.util.List;

public final class a
{
  private static final a zhe;
  
  static
  {
    AppMethodBeat.i(151586);
    zhe = new a()
    {
      public final int dTn()
      {
        return -1;
      }
      
      public final boolean dTo()
      {
        return false;
      }
      
      public final void gl(Context paramAnonymousContext) {}
    };
    AppMethodBeat.o(151586);
  }
  
  public static a dTm()
  {
    AppMethodBeat.i(151585);
    b localb = new b();
    AppMethodBeat.o(151585);
    return localb;
  }
  
  public static abstract class a
  {
    public abstract int dTn();
    
    public abstract boolean dTo();
    
    public abstract void gl(Context paramContext);
  }
  
  static abstract class b
  {
    public final boolean dTp()
    {
      List localList = ak.getContext().getPackageManager().queryIntentActivities(dTq(), 0);
      if ((localList == null) || (localList.isEmpty())) {}
      for (int i = 1; (i == 0) && (((ResolveInfo)localList.get(0)).activityInfo.exported); i = 0) {
        return true;
      }
      return false;
    }
    
    protected abstract Intent dTq();
    
    public final void gm(Context paramContext)
    {
      Object localObject = dTq();
      if (!(paramContext instanceof Activity)) {
        ((Intent)localObject).addFlags(268435456);
      }
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/shortcut/permission/AppPermissionSettingAdapterFactory$SettingPageJumper", "jump", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/shortcut/permission/AppPermissionSettingAdapterFactory$SettingPageJumper", "jump", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.y.a.a
 * JD-Core Version:    0.7.0.1
 */