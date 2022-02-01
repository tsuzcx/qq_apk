package com.tencent.mm.plugin.sight.base;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.k;
import java.io.File;

public final class b
{
  public static boolean ae(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133596);
    try
    {
      if ((g.ajS().gED) && (g.ajP().aiZ()))
      {
        int i = ((Integer)g.ajR().ajA().get(am.a.IRl, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool1 = true;; bool1 = false)
          {
            ae.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
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
      ae.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
      if ((j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE) || (j.DEBUG))
      {
        ae.i("MicroMsg.WechatSight.PacketMuxerController", "Special version, open by default: %s", new Object[] { j.hju });
        AppMethodBeat.o(133596);
        return true;
      }
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNQ, 0) != 1) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramBoolean2)
        {
          ae.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", new Object[] { Boolean.FALSE, Boolean.valueOf(paramBoolean2) });
          bool2 = true;
        }
      }
      ae.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(133596);
      return bool2;
    }
  }
  
  public static boolean af(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(221731);
    try
    {
      if ((g.ajS().gED) && (g.ajP().aiZ()))
      {
        int i = ((Integer)g.ajR().ajA().get(am.a.IRm, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool1 = true;; bool1 = false)
          {
            ae.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
            if (i != 2) {
              break;
            }
            AppMethodBeat.o(221731);
            return true;
          }
          AppMethodBeat.o(221731);
          return false;
        }
      }
    }
    catch (Error localError)
    {
      ae.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
      if ((j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE) || (j.DEBUG))
      {
        ae.i("MicroMsg.WechatSight.PacketMuxerController", "Special version, open by default: %s", new Object[] { j.hju });
        AppMethodBeat.o(221731);
        return true;
      }
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNR, 0) != 1) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramBoolean2)
        {
          ae.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", new Object[] { Boolean.FALSE, Boolean.valueOf(paramBoolean2) });
          bool2 = true;
        }
      }
      ae.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(221731);
      return bool2;
    }
  }
  
  public static void ah(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(176223);
    try
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1280L, paramLong1, paramLong2, false);
      ae.d("MicroMsg.WechatSight.PacketMuxerController", "reportIDKey muxer called: %d, %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(176223);
      return;
    }
    catch (Error localError)
    {
      ae.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "reportIDKey muxer called error", new Object[0]);
      AppMethodBeat.o(176223);
    }
  }
  
  public static boolean dTs()
  {
    AppMethodBeat.i(221730);
    try
    {
      if ((g.ajS().gED) && (g.ajP().aiZ()))
      {
        int i = ((Integer)g.ajR().ajA().get(am.a.IRl, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool = true;; bool = false)
          {
            ae.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
            if (i != 2) {
              break;
            }
            AppMethodBeat.o(221730);
            return true;
          }
          AppMethodBeat.o(221730);
          return false;
        }
      }
    }
    catch (Error localError)
    {
      ae.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
      if ((j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE) || (j.DEBUG))
      {
        ae.i("MicroMsg.WechatSight.PacketMuxerController", "Special version, open by default: %s", new Object[] { j.hju });
        AppMethodBeat.o(221730);
        return true;
      }
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNT, 0) != 1) {}
    }
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(221730);
      return bool;
    }
  }
  
  public static boolean dTt()
  {
    AppMethodBeat.i(176222);
    try
    {
      if ((g.ajS().gED) && (g.ajP().aiZ()))
      {
        int i = ((Integer)g.ajR().ajA().get(am.a.IRn, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 1) {}
          for (bool = true;; bool = false)
          {
            ae.d("MicroMsg.WechatSight.PacketMuxerController", "WechatSight useCodecPts localConfig: %d, useCodecPts: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
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
      ae.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load useCodecPts local config fail", new Object[0]);
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNS, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight useCodecPts: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(176222);
      return bool;
    }
  }
  
  public static String dTu()
  {
    AppMethodBeat.i(133597);
    if ((ak.getContext() == null) || (ak.getContext().getCacheDir() == null))
    {
      ae.e("MicroMsg.WechatSight.PacketMuxerController", "path is empty, MMApplicationContext.getContext() == null");
      AppMethodBeat.o(133597);
      return "";
    }
    String str = ak.getContext().getCacheDir().getAbsolutePath() + "/mux";
    k localk = new k(str);
    if (!localk.exists())
    {
      localk.mkdirs();
      ae.i("MicroMsg.WechatSight.PacketMuxerController", "path is not exists, mkdir path: %s", new Object[] { str });
    }
    ae.d("MicroMsg.WechatSight.PacketMuxerController", "WechatSight ffmpegMuxerPath path is %s", new Object[] { str });
    AppMethodBeat.o(133597);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.b
 * JD-Core Version:    0.7.0.1
 */