package com.tencent.mm.plugin.sight.base;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.o;
import java.io.File;

public final class b
{
  public static boolean aj(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133596);
    try
    {
      if ((g.aAi().hrr) && (g.aAf().azp()))
      {
        int i = ((Integer)g.aAh().azQ().get(ar.a.NZn, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool1 = true;; bool1 = false)
          {
            Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
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
      Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skO, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramBoolean2)
        {
          Log.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", new Object[] { Boolean.FALSE, Boolean.valueOf(paramBoolean2) });
          bool2 = true;
        }
      }
      Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(133596);
      return bool2;
    }
  }
  
  public static boolean ak(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201786);
    try
    {
      if ((g.aAi().hrr) && (g.aAf().azp()))
      {
        int i = ((Integer)g.aAh().azQ().get(ar.a.NZo, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool1 = true;; bool1 = false)
          {
            Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
            if (i != 2) {
              break;
            }
            AppMethodBeat.o(201786);
            return true;
          }
          AppMethodBeat.o(201786);
          return false;
        }
      }
    }
    catch (Error localError)
    {
      Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skP, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramBoolean2)
        {
          Log.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", new Object[] { Boolean.FALSE, Boolean.valueOf(paramBoolean2) });
          bool2 = true;
        }
      }
      Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(201786);
      return bool2;
    }
  }
  
  public static boolean al(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201787);
    try
    {
      if ((g.aAi().hrr) && (g.aAf().azp()))
      {
        int i = ((Integer)g.aAh().azQ().get(ar.a.NZn, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool1 = true;; bool1 = false)
          {
            Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
            if (i != 2) {
              break;
            }
            AppMethodBeat.o(201787);
            return true;
          }
          AppMethodBeat.o(201787);
          return false;
        }
      }
    }
    catch (Error localError)
    {
      Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skS, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramBoolean2)
        {
          Log.i("MicroMsg.WechatSight.PacketMuxerController", "xSwitch: %b, enableHevc: %b, H265 must use ffmpeg_muxer", new Object[] { Boolean.FALSE, Boolean.valueOf(paramBoolean2) });
          bool2 = true;
        }
      }
      Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b, useSoftEncode:%s, enableHevc:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(201787);
      return bool2;
    }
  }
  
  public static void am(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(176223);
    try
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1280L, paramLong1, paramLong2, false);
      Log.d("MicroMsg.WechatSight.PacketMuxerController", "reportIDKey muxer called: %d, %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(176223);
      return;
    }
    catch (Error localError)
    {
      Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "reportIDKey muxer called error", new Object[0]);
      AppMethodBeat.o(176223);
    }
  }
  
  public static boolean eVr()
  {
    AppMethodBeat.i(201785);
    try
    {
      if ((g.aAi().hrr) && (g.aAf().azp()))
      {
        int i = ((Integer)g.aAh().azQ().get(ar.a.NZn, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 2) {}
          for (bool = true;; bool = false)
          {
            Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg localConfig: %d, isIsUseFFmpeg: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
            if (i != 2) {
              break;
            }
            AppMethodBeat.o(201785);
            return true;
          }
          AppMethodBeat.o(201785);
          return false;
        }
      }
    }
    catch (Error localError)
    {
      Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load isIsUseFFmpeg local config fail", new Object[0]);
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skR, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight isIsUseFFmpeg xSwitch: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(201785);
      return bool;
    }
  }
  
  public static boolean eVs()
  {
    AppMethodBeat.i(176222);
    try
    {
      if ((g.aAi().hrr) && (g.aAf().azp()))
      {
        int i = ((Integer)g.aAh().azQ().get(ar.a.NZp, Integer.valueOf(-1))).intValue();
        if (i > 0)
        {
          if (i == 1) {}
          for (bool = true;; bool = false)
          {
            Log.d("MicroMsg.WechatSight.PacketMuxerController", "WechatSight useCodecPts localConfig: %d, useCodecPts: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
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
      Log.printErrStackTrace("MicroMsg.WechatSight.PacketMuxerController", localError, "load useCodecPts local config fail", new Object[0]);
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skQ, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight useCodecPts: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(176222);
      return bool;
    }
  }
  
  public static String eVt()
  {
    AppMethodBeat.i(133597);
    if ((MMApplicationContext.getContext() == null) || (MMApplicationContext.getContext().getCacheDir() == null))
    {
      Log.e("MicroMsg.WechatSight.PacketMuxerController", "path is empty, MMApplicationContext.getContext() == null");
      AppMethodBeat.o(133597);
      return "";
    }
    String str = MMApplicationContext.getContext().getCacheDir().getAbsolutePath() + "/mux";
    o localo = new o(str);
    if (!localo.exists())
    {
      localo.mkdirs();
      Log.i("MicroMsg.WechatSight.PacketMuxerController", "path is not exists, mkdir path: %s", new Object[] { str });
    }
    Log.d("MicroMsg.WechatSight.PacketMuxerController", "WechatSight ffmpegMuxerPath path is %s", new Object[] { str });
    AppMethodBeat.o(133597);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.b
 * JD-Core Version:    0.7.0.1
 */