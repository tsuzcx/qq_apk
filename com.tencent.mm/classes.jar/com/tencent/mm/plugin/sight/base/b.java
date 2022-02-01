package com.tencent.mm.plugin.sight.base;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.File;

public final class b
{
  public static boolean Y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133596);
    try
    {
      if ((g.afC().gdG) && (g.afz().aeI()))
      {
        int i = ((Integer)g.afB().afk().get(ae.a.FmG, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool1 = true;; bool1 = false)
          {
            ad.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
            if (i != 2) {
              break;
            }
            AppMethodBeat.o(133596);
            return true;
          }
          AppMethodBeat.o(133596);
          return false;
        }
      }
    }
    catch (Error localError)
    {
      ad.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
      if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (h.DEBUG))
      {
        ad.i("MicroMsg.WechatSight.PacketMuxerController", "Special version, open by default: %s", new Object[] { h.glW });
        AppMethodBeat.o(133596);
        return true;
      }
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwy, 0) != 1) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramBoolean2)
        {
          ad.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", new Object[] { Boolean.FALSE, Boolean.valueOf(paramBoolean2) });
          bool2 = true;
        }
      }
      ad.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(133596);
      return bool2;
    }
  }
  
  public static boolean Z(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(190199);
    try
    {
      if ((g.afC().gdG) && (g.afz().aeI()))
      {
        int i = ((Integer)g.afB().afk().get(ae.a.FmH, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool1 = true;; bool1 = false)
          {
            ad.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
            if (i != 2) {
              break;
            }
            AppMethodBeat.o(190199);
            return true;
          }
          AppMethodBeat.o(190199);
          return false;
        }
      }
    }
    catch (Error localError)
    {
      ad.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
      if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (h.DEBUG))
      {
        ad.i("MicroMsg.WechatSight.PacketMuxerController", "Special version, open by default: %s", new Object[] { h.glW });
        AppMethodBeat.o(190199);
        return true;
      }
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwz, 0) != 1) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramBoolean2)
        {
          ad.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", new Object[] { Boolean.FALSE, Boolean.valueOf(paramBoolean2) });
          bool2 = true;
        }
      }
      ad.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(190199);
      return bool2;
    }
  }
  
  public static void ai(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(176223);
    try
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1280L, paramLong1, paramLong2, false);
      ad.d("MicroMsg.WechatSight.PacketMuxerController", "reportIDKey muxer called: %d, %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(176223);
      return;
    }
    catch (Error localError)
    {
      ad.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "reportIDKey muxer called error", new Object[0]);
      AppMethodBeat.o(176223);
    }
  }
  
  public static boolean dqj()
  {
    AppMethodBeat.i(190198);
    try
    {
      if ((g.afC().gdG) && (g.afz().aeI()))
      {
        int i = ((Integer)g.afB().afk().get(ae.a.FmG, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool = true;; bool = false)
          {
            ad.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
            if (i != 2) {
              break;
            }
            AppMethodBeat.o(190198);
            return true;
          }
          AppMethodBeat.o(190198);
          return false;
        }
      }
    }
    catch (Error localError)
    {
      ad.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
      if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (h.DEBUG))
      {
        ad.i("MicroMsg.WechatSight.PacketMuxerController", "Special version, open by default: %s", new Object[] { h.glW });
        AppMethodBeat.o(190198);
        return true;
      }
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwB, 0) != 1) {}
    }
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(190198);
      return bool;
    }
  }
  
  public static boolean dqk()
  {
    AppMethodBeat.i(176222);
    try
    {
      if ((g.afC().gdG) && (g.afz().aeI()))
      {
        int i = ((Integer)g.afB().afk().get(ae.a.FmI, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 1) {}
          for (bool = true;; bool = false)
          {
            ad.d("MicroMsg.WechatSight.PacketMuxerController", "WechatSight useCodecPts localConfig: %d, useCodecPts: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
            if (i != 1) {
              break;
            }
            AppMethodBeat.o(176222);
            return true;
          }
          AppMethodBeat.o(176222);
          return false;
        }
      }
    }
    catch (Error localError)
    {
      ad.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load useCodecPts local config fail", new Object[0]);
    }
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwA, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight useCodecPts: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(176222);
      return bool;
    }
  }
  
  public static String dql()
  {
    AppMethodBeat.i(133597);
    if ((aj.getContext() == null) || (aj.getContext().getCacheDir() == null))
    {
      ad.e("MicroMsg.WechatSight.PacketMuxerController", "path is empty, MMApplicationContext.getContext() == null");
      AppMethodBeat.o(133597);
      return "";
    }
    String str = aj.getContext().getCacheDir().getAbsolutePath() + "/mux";
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(str);
    if (!locale.exists())
    {
      locale.mkdirs();
      ad.i("MicroMsg.WechatSight.PacketMuxerController", "path is not exists, mkdir path: %s", new Object[] { str });
    }
    ad.d("MicroMsg.WechatSight.PacketMuxerController", "WechatSight ffmpegMuxerPath path is %s", new Object[] { str });
    AppMethodBeat.o(133597);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.b
 * JD-Core Version:    0.7.0.1
 */