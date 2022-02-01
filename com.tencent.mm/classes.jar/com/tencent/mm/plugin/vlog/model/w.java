package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"enableAddFinderAudio", "", "enableExport1080WidescreenVideo", "enableFallbackFailedSoftEncode", "enableImageAddMusic", "enableImageAutoAddMusic", "enableMagic", "enableMusicLyrics", "enableRecordAddAudio", "enableVideoTemplate", "finderEnableEncodeHevc", "longVideo", "duration", "", "finderEnableHevcHardwareEncode", "finderEnableHevcSoftEncode", "plugin-vlog_release"})
public final class w
{
  public static final boolean gtn()
  {
    AppMethodBeat.i(235346);
    if (!BuildInfo.IS_FLAVOR_PURPLE) {
      boolean bool = BuildInfo.DEBUG;
    }
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_MAGIC_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(235346);
      return true;
    }
    AppMethodBeat.o(235346);
    return false;
  }
  
  public static final boolean gto()
  {
    AppMethodBeat.i(235350);
    MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_VIDEO_TEMPLATE_INT_SYNC", 0);
    AppMethodBeat.o(235350);
    return false;
  }
  
  public static final boolean gtp()
  {
    AppMethodBeat.i(235353);
    int i = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("FINDER_FOLLOW_PAT_ENTRANCE", 0);
    int j = ((b)h.ae(b.class)).a(b.a.vJa, 0);
    if ((i == 1) || (j == 1))
    {
      AppMethodBeat.o(235353);
      return true;
    }
    AppMethodBeat.o(235353);
    return false;
  }
  
  public static final boolean gtq()
  {
    AppMethodBeat.i(235361);
    Object localObject = n.NlN;
    if (n.gsU())
    {
      localObject = n.NlN;
      if (n.gsX() == 2)
      {
        AppMethodBeat.o(235361);
        return true;
      }
      AppMethodBeat.o(235361);
      return false;
    }
    int i = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_HEVC_ENCODE_OPTION_INT_SYNC", 0);
    localObject = e.HJM;
    boolean bool = e.fvz();
    if ((i == 2) || (bool))
    {
      AppMethodBeat.o(235361);
      return true;
    }
    AppMethodBeat.o(235361);
    return false;
  }
  
  public static final boolean gtr()
  {
    AppMethodBeat.i(235362);
    if ((((b)h.ae(b.class)).a(b.a.vLo, 1) == 1) && (gtp()))
    {
      AppMethodBeat.o(235362);
      return true;
    }
    AppMethodBeat.o(235362);
    return false;
  }
  
  public static final boolean gts()
  {
    AppMethodBeat.i(235365);
    if (((b)h.ae(b.class)).a(b.a.vLq, 0) == 1)
    {
      AppMethodBeat.o(235365);
      return true;
    }
    AppMethodBeat.o(235365);
    return false;
  }
  
  public static final boolean gtt()
  {
    AppMethodBeat.i(235368);
    if (((b)h.ae(b.class)).a(b.a.vLr, 0) == 1)
    {
      AppMethodBeat.o(235368);
      return true;
    }
    AppMethodBeat.o(235368);
    return false;
  }
  
  public static final boolean gtu()
  {
    AppMethodBeat.i(235370);
    if (((b)h.ae(b.class)).a(b.a.vLs, 1) == 1)
    {
      AppMethodBeat.o(235370);
      return true;
    }
    AppMethodBeat.o(235370);
    return false;
  }
  
  public static final boolean o(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(235355);
    if ((p(paramBoolean, paramLong)) || (gtq()))
    {
      AppMethodBeat.o(235355);
      return true;
    }
    AppMethodBeat.o(235355);
    return false;
  }
  
  public static final boolean p(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(235358);
    Object localObject = n.NlN;
    if (n.gsU())
    {
      localObject = n.NlN;
      if (n.gsX() == 1)
      {
        AppMethodBeat.o(235358);
        return true;
      }
      AppMethodBeat.o(235358);
      return false;
    }
    int i = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_HEVC_ENCODE_OPTION_INT_SYNC", 0);
    localObject = e.HJM;
    paramBoolean = e.k(paramBoolean, paramLong);
    if ((i == 1) || (paramBoolean))
    {
      AppMethodBeat.o(235358);
      return true;
    }
    AppMethodBeat.o(235358);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.w
 * JD-Core Version:    0.7.0.1
 */