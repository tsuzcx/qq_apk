package com.tencent.mm.plugin.textstatus.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/jump/TextStatusJumpManager;", "", "()V", "TAG", "", "doJumpDetail", "", "context", "Landroid/content/Context;", "sourceId", "customParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "doJumpInner", "customRes", "doJumpSource", "plugin-textstatus_release"})
public final class a
{
  public static final a MBv;
  
  static
  {
    AppMethodBeat.i(237512);
    MBv = new a();
    AppMethodBeat.o(237512);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, List<? extends TextStatusJumpInfo> paramList)
  {
    AppMethodBeat.i(237510);
    p.k(paramContext, "context");
    p.k(paramList, "jumpInfos");
    AppMethodBeat.o(237510);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.d.a
 * JD-Core Version:    0.7.0.1
 */