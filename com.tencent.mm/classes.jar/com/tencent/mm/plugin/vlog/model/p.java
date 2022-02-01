package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.i;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"enableMagic", "", "enableVideoTemplate", "plugin-vlog_release"})
public final class p
{
  public static final boolean erW()
  {
    AppMethodBeat.i(195746);
    if (!i.IS_FLAVOR_PURPLE) {
      boolean bool = i.DEBUG;
    }
    if (ax.aQz("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_MAGIC_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(195746);
      return true;
    }
    AppMethodBeat.o(195746);
    return false;
  }
  
  public static final boolean erX()
  {
    AppMethodBeat.i(195747);
    if (ax.aQz("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_VIDEO_TEMPLATE_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(195747);
      return true;
    }
    AppMethodBeat.o(195747);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.p
 * JD-Core Version:    0.7.0.1
 */