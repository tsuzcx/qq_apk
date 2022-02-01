package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"enableFallbackFailedSoftEncode", "", "enableHevcHardwareEncode", "enableHevcSoftEncode", "enableImageAddMusic", "enableMagic", "enableVideoTemplate", "plugin-vlog_release"})
public final class w
{
  public static final boolean fBr()
  {
    AppMethodBeat.i(190629);
    if (!BuildInfo.IS_FLAVOR_PURPLE) {
      boolean bool = BuildInfo.DEBUG;
    }
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_MAGIC_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(190629);
      return true;
    }
    AppMethodBeat.o(190629);
    return false;
  }
  
  public static final boolean fBs()
  {
    AppMethodBeat.i(190630);
    MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_VIDEO_TEMPLATE_INT_SYNC", 0);
    AppMethodBeat.o(190630);
    return false;
  }
  
  public static final boolean fBt()
  {
    AppMethodBeat.i(190631);
    int i = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("FINDER_FOLLOW_PAT_ENTRANCE", 0);
    int j = ((b)g.af(b.class)).a(b.a.sbw, 0);
    if ((i == 1) || (j == 1))
    {
      AppMethodBeat.o(190631);
      return true;
    }
    AppMethodBeat.o(190631);
    return false;
  }
  
  public static final boolean fBu()
  {
    AppMethodBeat.i(190632);
    Object localObject = m.Gyi;
    if (m.fAU())
    {
      localObject = m.Gyi;
      if (m.fAX() == 1)
      {
        AppMethodBeat.o(190632);
        return true;
      }
      AppMethodBeat.o(190632);
      return false;
    }
    int i = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_HEVC_ENCODE_OPTION_INT_SYNC", 0);
    localObject = o.Gyk;
    boolean bool = o.fBg();
    if ((i == 1) || (bool))
    {
      AppMethodBeat.o(190632);
      return true;
    }
    AppMethodBeat.o(190632);
    return false;
  }
  
  public static final boolean fBv()
  {
    AppMethodBeat.i(190633);
    Object localObject = m.Gyi;
    if (m.fAU())
    {
      localObject = m.Gyi;
      if (m.fAX() == 2)
      {
        AppMethodBeat.o(190633);
        return true;
      }
      AppMethodBeat.o(190633);
      return false;
    }
    int i = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_HEVC_ENCODE_OPTION_INT_SYNC", 0);
    localObject = o.Gyk;
    boolean bool = o.fBh();
    if ((i == 2) || (bool))
    {
      AppMethodBeat.o(190633);
      return true;
    }
    AppMethodBeat.o(190633);
    return false;
  }
  
  public static final boolean fBw()
  {
    AppMethodBeat.i(190634);
    m localm = m.Gyi;
    if (m.fAU())
    {
      localm = m.Gyi;
      if (m.fAY() == 1)
      {
        AppMethodBeat.o(190634);
        return true;
      }
      AppMethodBeat.o(190634);
      return false;
    }
    int i;
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_ENABLE_SOFT_ENCODE_FALLBACK_INT_SYNC", 0) == 1)
    {
      i = 1;
      if (((b)g.af(b.class)).a(b.a.soQ, 0) != 1) {
        break label100;
      }
    }
    label100:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) && (j == 0)) {
        break label105;
      }
      AppMethodBeat.o(190634);
      return true;
      i = 0;
      break;
    }
    label105:
    AppMethodBeat.o(190634);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.w
 * JD-Core Version:    0.7.0.1
 */