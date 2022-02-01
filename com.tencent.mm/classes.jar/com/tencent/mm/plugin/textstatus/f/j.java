package com.tencent.mm.plugin.textstatus.f;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.j.b;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/StatusThirdShare;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShare;", "()V", "setTextStatus", "", "context", "Landroid/content/Context;", "statusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setTextStatusForResult", "Landroid/app/Activity;", "requestCode", "", "plugin-textstatus_release"})
public final class j
  implements i
{
  public final boolean a(Activity paramActivity, m paramm)
  {
    AppMethodBeat.i(216205);
    if (paramActivity == null)
    {
      AppMethodBeat.o(216205);
      return false;
    }
    if (paramm != null)
    {
      localObject = b.GfZ;
      paramm.FZB = b.getName(paramm.Gae);
      paramm.UrT = 5L;
    }
    Object localObject = TextStatusEditActivity.GeM;
    TextStatusEditActivity.a.b(paramActivity, paramm);
    AppMethodBeat.o(216205);
    return true;
  }
  
  public final boolean a(Context paramContext, m paramm)
  {
    AppMethodBeat.i(216206);
    if (paramContext == null)
    {
      AppMethodBeat.o(216206);
      return false;
    }
    if (paramm != null)
    {
      localObject = b.GfZ;
      paramm.FZB = b.getName(paramm.Gae);
      paramm.UrT = 5L;
    }
    Object localObject = TextStatusEditActivity.GeM;
    TextStatusEditActivity.a.b(paramContext, paramm);
    AppMethodBeat.o(216206);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.j
 * JD-Core Version:    0.7.0.1
 */