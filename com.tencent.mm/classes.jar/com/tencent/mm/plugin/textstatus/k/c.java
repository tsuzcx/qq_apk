package com.tencent.mm.plugin.textstatus.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.mo;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.sdk.event.IListener;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TEXT_STATUS_ICON_EXT_OPTION_ORIGINAL_IMAGE", "", "TEXT_STATUS_ICON_SHOW_TYPE_HIDDEN", "", "TEXT_STATUS_ICON_SHOW_TYPE_NORMAL", "TEXT_STATUS_ICON_SHOW_TYPE_RESIDENT", "checkResUpdateCacheFileEventIListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "isUseOldStrategy", "", "()Z", "localCheckResUpdateCacheFileEventIListener", "Lcom/tencent/mm/autogen/events/LocalCheckResUpdateCacheFileEvent;", "getIconHelper", "Lcom/tencent/mm/plugin/textstatus/util/IStatusIconHelper;", "plugin-textstatus_release"})
public final class c
{
  private static final boolean MOn;
  private static final IListener<mo> MOo;
  private static final IListener<bu> tWe;
  
  static
  {
    AppMethodBeat.i(236771);
    MOn = t.glr();
    tWe = (IListener)new c.a();
    MOo = (IListener)new c.b();
    AppMethodBeat.o(236771);
  }
  
  public static final boolean gny()
  {
    return MOn;
  }
  
  public static final a gnz()
  {
    if (MOn) {
      return (a)g.MOD;
    }
    return (a)i.MOO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.c
 * JD-Core Version:    0.7.0.1
 */