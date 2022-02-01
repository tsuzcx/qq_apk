package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"enableMagic", "", "enableVideoTemplate", "plugin-vlog_release"})
public final class p
{
  public static final boolean evD()
  {
    AppMethodBeat.i(191203);
    if (!j.IS_FLAVOR_PURPLE) {
      boolean bool = j.DEBUG;
    }
    if (ay.aRW("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_MAGIC_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(191203);
      return true;
    }
    AppMethodBeat.o(191203);
    return false;
  }
  
  public static final boolean evE()
  {
    AppMethodBeat.i(191204);
    if (ay.aRW("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_VIDEO_TEMPLATE_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(191204);
      return true;
    }
    AppMethodBeat.o(191204);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.p
 * JD-Core Version:    0.7.0.1
 */