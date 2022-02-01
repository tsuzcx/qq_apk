package com.tencent.mm.plugin.textstatus.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.nv;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"TEXT_STATUS_ICON_EXT_OPTION_ORIGINAL_IMAGE", "", "TEXT_STATUS_ICON_SHOW_TYPE_HIDDEN", "", "TEXT_STATUS_ICON_SHOW_TYPE_NORMAL", "TEXT_STATUS_ICON_SHOW_TYPE_RESIDENT", "checkResUpdateCacheFileEventIListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "isUseOldStrategy", "", "()Z", "localCheckResUpdateCacheFileEventIListener", "Lcom/tencent/mm/autogen/events/LocalCheckResUpdateCacheFileEvent;", "getIconHelper", "Lcom/tencent/mm/plugin/textstatus/util/IStatusIconHelper;", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final boolean TAK;
  private static final IListener<nv> TAL;
  private static final IListener<cd> wZy;
  
  static
  {
    AppMethodBeat.i(290383);
    TAK = ac.hGl();
    wZy = (IListener)new IStatusIconHelperKt.checkResUpdateCacheFileEventIListener.1(com.tencent.mm.app.f.hfK);
    TAL = (IListener)new IStatusIconHelperKt.localCheckResUpdateCacheFileEventIListener.1(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(290383);
  }
  
  public static final boolean hKg()
  {
    return TAK;
  }
  
  public static final a hKh()
  {
    if (TAK) {
      return (a)f.TAW;
    }
    return (a)g.TBm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.b
 * JD-Core Version:    0.7.0.1
 */