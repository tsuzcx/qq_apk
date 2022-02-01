package com.tencent.mm.plugin.sight.base;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.File;

public final class b
{
  public static boolean ab(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133596);
    try
    {
      if ((g.agS().gim) && (g.agP().afY()))
      {
        int i = ((Integer)g.agR().agA().get(ah.a.GKv, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool1 = true;; bool1 = false)
          {
            ac.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
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
      ac.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
      if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (h.DEBUG))
      {
        ac.i("MicroMsg.WechatSight.PacketMuxerController", "Special version, open by default: %s", new Object[] { h.gMJ });
        AppMethodBeat.o(133596);
        return true;
      }
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaN, 0) != 1) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramBoolean2)
        {
          ac.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", new Object[] { Boolean.FALSE, Boolean.valueOf(paramBoolean2) });
          bool2 = true;
        }
      }
      ac.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(133596);
      return bool2;
    }
  }
  
  public static boolean ac(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195675);
    try
    {
      if ((g.agS().gim) && (g.agP().afY()))
      {
        int i = ((Integer)g.agR().agA().get(ah.a.GKw, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool1 = true;; bool1 = false)
          {
            ac.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
            if (i != 2) {
              break;
            }
            AppMethodBeat.o(195675);
            return true;
          }
          AppMethodBeat.o(195675);
          return false;
        }
      }
    }
    catch (Error localError)
    {
      ac.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
      if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (h.DEBUG))
      {
        ac.i("MicroMsg.WechatSight.PacketMuxerController", "Special version, open by default: %s", new Object[] { h.gMJ });
        AppMethodBeat.o(195675);
        return true;
      }
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaO, 0) != 1) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramBoolean2)
        {
          ac.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", new Object[] { Boolean.FALSE, Boolean.valueOf(paramBoolean2) });
          bool2 = true;
        }
      }
      ac.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(195675);
      return bool2;
    }
  }
  
  public static void af(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(176223);
    try
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1280L, paramLong1, paramLong2, false);
      ac.d("MicroMsg.WechatSight.PacketMuxerController", "reportIDKey muxer called: %d, %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(176223);
      return;
    }
    catch (Error localError)
    {
      ac.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "reportIDKey muxer called error", new Object[0]);
      AppMethodBeat.o(176223);
    }
  }
  
  public static boolean dEs()
  {
    AppMethodBeat.i(195674);
    try
    {
      if ((g.agS().gim) && (g.agP().afY()))
      {
        int i = ((Integer)g.agR().agA().get(ah.a.GKv, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool = true;; bool = false)
          {
            ac.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
            if (i != 2) {
              break;
            }
            AppMethodBeat.o(195674);
            return true;
          }
          AppMethodBeat.o(195674);
          return false;
        }
      }
    }
    catch (Error localError)
    {
      ac.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
      if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (h.DEBUG))
      {
        ac.i("MicroMsg.WechatSight.PacketMuxerController", "Special version, open by default: %s", new Object[] { h.gMJ });
        AppMethodBeat.o(195674);
        return true;
      }
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaQ, 0) != 1) {}
    }
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(195674);
      return bool;
    }
  }
  
  public static boolean dEt()
  {
    AppMethodBeat.i(176222);
    try
    {
      if ((g.agS().gim) && (g.agP().afY()))
      {
        int i = ((Integer)g.agR().agA().get(ah.a.GKx, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 1) {}
          for (bool = true;; bool = false)
          {
            ac.d("MicroMsg.WechatSight.PacketMuxerController", "WechatSight useCodecPts localConfig: %d, useCodecPts: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
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
      ac.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load useCodecPts local config fail", new Object[0]);
    }
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaP, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight useCodecPts: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(176222);
      return bool;
    }
  }
  
  public static String dEu()
  {
    AppMethodBeat.i(133597);
    if ((ai.getContext() == null) || (ai.getContext().getCacheDir() == null))
    {
      ac.e("MicroMsg.WechatSight.PacketMuxerController", "path is empty, MMApplicationContext.getContext() == null");
      AppMethodBeat.o(133597);
      return "";
    }
    String str = ai.getContext().getCacheDir().getAbsolutePath() + "/mux";
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(str);
    if (!locale.exists())
    {
      locale.mkdirs();
      ac.i("MicroMsg.WechatSight.PacketMuxerController", "path is not exists, mkdir path: %s", new Object[] { str });
    }
    ac.d("MicroMsg.WechatSight.PacketMuxerController", "WechatSight ffmpegMuxerPath path is %s", new Object[] { str });
    AppMethodBeat.o(133597);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.b
 * JD-Core Version:    0.7.0.1
 */