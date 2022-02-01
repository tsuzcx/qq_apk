package com.tencent.mm.plugin.textstatus.e;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/jump/TextStatusJumpManager;", "", "()V", "TAG", "", "doJumpDetail", "", "context", "Landroid/content/Context;", "sourceId", "customParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "doJumpInner", "customRes", "doJumpSource", "extParam", "Landroid/os/Bundle;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Tlb;
  
  static
  {
    AppMethodBeat.i(289645);
    Tlb = new a();
    AppMethodBeat.o(289645);
  }
  
  public static boolean Q(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(369822);
    s.u(paramContext, "context");
    AppMethodBeat.o(369822);
    return paramBoolean;
  }
  
  public static boolean a(Context paramContext, k paramk, Bundle paramBundle)
  {
    AppMethodBeat.i(289638);
    s.u(paramContext, "context");
    boolean bool = false;
    if (paramk != null) {
      bool = paramk.g(paramContext, paramBundle);
    }
    s.u(paramContext, "context");
    AppMethodBeat.o(289638);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.a
 * JD-Core Version:    0.7.0.1
 */