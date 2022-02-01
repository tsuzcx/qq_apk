package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.c.e;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"enableAddFinderAudio", "", "enableExport1080WidescreenVideo", "enableFallbackFailedSoftEncode", "enableImageAddMusic", "enableImageAutoAddMusic", "enableImageAutoAddMusicPanel", "enableMagic", "enableMusicLyrics", "enableRecordAddAudio", "enableVideoTemplate", "finderEnableEncodeHevc", "longVideo", "duration", "", "finderEnableHevcHardwareEncode", "finderEnableHevcSoftEncode", "plugin-vlog_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final boolean hQM()
  {
    AppMethodBeat.i(283539);
    if (!BuildInfo.IS_FLAVOR_PURPLE) {
      boolean bool = BuildInfo.DEBUG;
    }
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_MAGIC_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(283539);
      return true;
    }
    AppMethodBeat.o(283539);
    return false;
  }
  
  public static final boolean hQN()
  {
    AppMethodBeat.i(283547);
    MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_EDITOR_VIDEO_TEMPLATE_INT_SYNC", 0);
    AppMethodBeat.o(283547);
    return false;
  }
  
  public static final boolean hQO()
  {
    AppMethodBeat.i(283556);
    int i = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("FINDER_FOLLOW_PAT_ENTRANCE", 0);
    int j = ((c)h.ax(c.class)).a(c.a.yZe, 0);
    if ((i == 1) || (j == 1))
    {
      AppMethodBeat.o(283556);
      return true;
    }
    AppMethodBeat.o(283556);
    return false;
  }
  
  public static final boolean hQP()
  {
    AppMethodBeat.i(283582);
    Object localObject = m.TYW;
    if (m.hQq())
    {
      localObject = m.TYW;
      if (m.hQt() == 2)
      {
        AppMethodBeat.o(283582);
        return true;
      }
      AppMethodBeat.o(283582);
      return false;
    }
    int i = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_HEVC_ENCODE_OPTION_INT_SYNC", 0);
    localObject = e.NGK;
    boolean bool = e.gHo();
    if ((i == 2) || (bool))
    {
      AppMethodBeat.o(283582);
      return true;
    }
    AppMethodBeat.o(283582);
    return false;
  }
  
  public static final boolean hQQ()
  {
    AppMethodBeat.i(283591);
    if ((((c)h.ax(c.class)).a(c.a.zbO, 1) == 1) && (hQO()))
    {
      AppMethodBeat.o(283591);
      return true;
    }
    AppMethodBeat.o(283591);
    return false;
  }
  
  public static final boolean hQR()
  {
    AppMethodBeat.i(283597);
    if ((((c)h.ax(c.class)).a(c.a.zbP, 0) == 1) && (hQQ()))
    {
      AppMethodBeat.o(283597);
      return true;
    }
    AppMethodBeat.o(283597);
    return false;
  }
  
  public static final boolean hQS()
  {
    AppMethodBeat.i(283600);
    if (((c)h.ax(c.class)).a(c.a.zbR, 0) == 1)
    {
      AppMethodBeat.o(283600);
      return true;
    }
    AppMethodBeat.o(283600);
    return false;
  }
  
  public static final boolean hQT()
  {
    AppMethodBeat.i(283603);
    if (((c)h.ax(c.class)).a(c.a.zbS, 0) == 1)
    {
      AppMethodBeat.o(283603);
      return true;
    }
    AppMethodBeat.o(283603);
    return false;
  }
  
  public static final boolean hQU()
  {
    AppMethodBeat.i(283608);
    if (((c)h.ax(c.class)).a(c.a.zbT, 1) == 1)
    {
      AppMethodBeat.o(283608);
      return true;
    }
    AppMethodBeat.o(283608);
    return false;
  }
  
  public static final boolean s(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(283566);
    if ((t(paramBoolean, paramLong)) || (hQP()))
    {
      AppMethodBeat.o(283566);
      return true;
    }
    AppMethodBeat.o(283566);
    return false;
  }
  
  public static final boolean t(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(283575);
    Object localObject = m.TYW;
    if (m.hQq())
    {
      localObject = m.TYW;
      if (m.hQt() == 1)
      {
        AppMethodBeat.o(283575);
        return true;
      }
      AppMethodBeat.o(283575);
      return false;
    }
    int i = MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_HEVC_ENCODE_OPTION_INT_SYNC", -1);
    localObject = e.NGK;
    paramBoolean = e.n(paramBoolean, paramLong);
    if (i != -1)
    {
      if (i == 1)
      {
        AppMethodBeat.o(283575);
        return true;
      }
      AppMethodBeat.o(283575);
      return false;
    }
    AppMethodBeat.o(283575);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.w
 * JD-Core Version:    0.7.0.1
 */