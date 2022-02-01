package com.tencent.mm.sensitive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sensitive.ui.SysPermissionDialogUI;
import com.tencent.mm.sensitive.ui.SysPermissionDialogUI.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/MMPermissionDelegate;", "Landroidx/core/app/ActivityCompat$PermissionCompatDelegate;", "()V", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "requestPermissions", "permissions", "", "", "(Landroid/app/Activity;[Ljava/lang/String;I)Z", "Companion", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements a.b
{
  public static final e.a actI;
  private static final String actJ;
  
  static
  {
    AppMethodBeat.i(240910);
    actI = new e.a((byte)0);
    actJ = "IS_FROM_DELEGATE";
    AppMethodBeat.o(240910);
  }
  
  public final boolean b(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(240918);
    s.u(paramActivity, "activity");
    s.u(paramArrayOfString, "permissions");
    if (s.p(paramActivity.getClass().getSimpleName(), "FinderLiveVisitorWithoutAffinityUI")) {
      if (!p.listOf(new Integer[] { Integer.valueOf(1002), Integer.valueOf(1001) }).contains(Integer.valueOf(paramInt))) {}
    }
    Object localObject;
    for (int i = 1; i == 0; i = 0)
    {
      localObject = com.tencent.mm.sensitive.ui.a.acvO;
      if (!com.tencent.mm.sensitive.ui.a.iUw()) {
        break;
      }
      AppMethodBeat.o(240918);
      return false;
    }
    boolean bool = paramActivity.getIntent().getBooleanExtra(actJ, false);
    if (!bool)
    {
      localObject = new Intent();
      SysPermissionDialogUI.a locala = SysPermissionDialogUI.acvX;
      ((Intent)localObject).putCharSequenceArrayListExtra(SysPermissionDialogUI.iUz(), (ArrayList)k.b(paramArrayOfString, (Collection)new ArrayList()));
      paramArrayOfString = SysPermissionDialogUI.acvX;
      ((Intent)localObject).putExtra(SysPermissionDialogUI.iUA(), paramInt);
      ((Intent)localObject).setClass((Context)paramActivity, SysPermissionDialogUI.class);
      paramArrayOfString = SysPermissionDialogUI.acvX;
      SysPermissionDialogUI.k((q)new e.b(paramActivity));
      paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramArrayOfString.aYi(), "com/tencent/mm/sensitive/MMPermissionDelegate", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramArrayOfString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/sensitive/MMPermissionDelegate", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    while (!bool)
    {
      AppMethodBeat.o(240918);
      return true;
      paramActivity.getIntent().removeExtra(actJ);
    }
    AppMethodBeat.o(240918);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.e
 * JD-Core Version:    0.7.0.1
 */