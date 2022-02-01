package com.tencent.thumbplayer.a.a.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.i.e;
import com.tencent.thumbplayer.b.l;
import com.tencent.thumbplayer.b.o;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoCropInfo;
import com.tencent.thumbplayer.core.player.TPNativePlayerPropertyID;
import com.tencent.thumbplayer.utils.d;
import java.util.HashMap;

public final class c
{
  private static SparseArray<a> Mvt;
  private static HashMap<Integer, Integer> Mvu;
  private static HashMap<Integer, Integer> Mvv;
  private static HashMap<Integer, Integer> Mvw;
  private static HashMap<Integer, Integer> Mvx;
  private static HashMap<Integer, Integer> Mvy;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(194519);
    TAG = "TPThumbPlayerUtils";
    Mvt = new SparseArray();
    Mvu = new HashMap();
    Mvv = new HashMap();
    Mvw = new HashMap();
    Mvx = new HashMap();
    Mvy = new HashMap();
    Mvt.append(100, new a(1, 100));
    Mvt.append(101, new a(3, 101));
    Mvt.append(104, new a(1, 104));
    Mvt.append(103, new a(1, 103));
    Mvt.append(102, new a(1, 102));
    Mvt.append(105, new a(1, 105));
    Mvt.append(106, new a(1, 106));
    Mvt.append(107, new a(1, 107));
    Mvt.append(108, new a(1, 108));
    Mvt.append(109, new a(4, 109));
    Mvt.append(110, new a(3, 110));
    Mvt.append(111, new a(3, 111));
    Mvt.append(112, new a(3, 112));
    Mvt.append(115, new a(3, 115));
    Mvt.append(200, new a(4, 200));
    Mvt.append(117, new a(1, 117));
    Mvt.append(118, new a(6, 113));
    Mvt.append(119, new a(3, 403));
    Mvt.append(120, new a(3, 402));
    Mvt.append(121, new a(4, 310));
    Mvt.append(201, new a(3, 201));
    Mvt.append(400, new a(3, 400));
    Mvt.append(300, new a(4, 404));
    Mvt.append(301, new a(4, 405));
    Mvt.append(401, new a(3, 401));
    Mvt.append(204, new a(5, 203));
    Mvt.append(500, new a(1, 500));
    Mvt.append(502, new a(4, 100));
    Mvt.append(206, new a(1, 107));
    Mvu.put(Integer.valueOf(1), Integer.valueOf(1));
    Mvu.put(Integer.valueOf(2), Integer.valueOf(2));
    Mvu.put(Integer.valueOf(3), Integer.valueOf(3));
    Mvu.put(Integer.valueOf(4), Integer.valueOf(4));
    Mvv.put(Integer.valueOf(101), Integer.valueOf(101));
    Mvv.put(Integer.valueOf(102), Integer.valueOf(102));
    Mvv.put(Integer.valueOf(103), Integer.valueOf(103));
    Mvv.put(Integer.valueOf(104), Integer.valueOf(104));
    Mvv.put(Integer.valueOf(105), Integer.valueOf(105));
    Mvv.put(Integer.valueOf(106), Integer.valueOf(106));
    Mvv.put(Integer.valueOf(107), Integer.valueOf(107));
    Mvv.put(Integer.valueOf(150), Integer.valueOf(150));
    Mvv.put(Integer.valueOf(151), Integer.valueOf(151));
    Mvv.put(Integer.valueOf(152), Integer.valueOf(152));
    Mvv.put(Integer.valueOf(153), Integer.valueOf(154));
    Mvv.put(Integer.valueOf(200), Integer.valueOf(200));
    Mvv.put(Integer.valueOf(201), Integer.valueOf(201));
    Mvv.put(Integer.valueOf(203), Integer.valueOf(203));
    Mvv.put(Integer.valueOf(204), Integer.valueOf(204));
    Mvv.put(Integer.valueOf(205), Integer.valueOf(205));
    Mvv.put(Integer.valueOf(206), Integer.valueOf(206));
    Mvv.put(Integer.valueOf(207), Integer.valueOf(207));
    Mvv.put(Integer.valueOf(208), Integer.valueOf(208));
    Mvv.put(Integer.valueOf(500), Integer.valueOf(500));
    Mvv.put(Integer.valueOf(501), Integer.valueOf(501));
    Mvv.put(Integer.valueOf(3), Integer.valueOf(3));
    Mvv.put(Integer.valueOf(4), Integer.valueOf(4));
    Mvw.put(Integer.valueOf(l.STRING_MEDIA_INFO), Integer.valueOf(TPNativePlayerPropertyID.STRING_MEDIA_INFO));
    Mvw.put(Integer.valueOf(l.LONG_AUDIO_CODEC_ID), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_CODEC_ID));
    Mvw.put(Integer.valueOf(l.LONG_AUDIO_BIT_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_BIT_RATE));
    Mvw.put(Integer.valueOf(l.LONG_AUDIO_PROFILE), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_PROFILE));
    Mvw.put(Integer.valueOf(l.LONG_AUDIO_CHANNEL_NUM), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_CHANNEL_NUM));
    Mvw.put(Integer.valueOf(l.LONG_VIDEO_CODEC_ID), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_CODEC_ID));
    Mvw.put(Integer.valueOf(l.LONG_VIDEO_BIT_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_BIT_RATE));
    Mvw.put(Integer.valueOf(l.LONG_VIDEO_PROFILE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_PROFILE));
    Mvw.put(Integer.valueOf(l.LONG_VIDEO_LEVEL), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_LEVEL));
    Mvw.put(Integer.valueOf(l.LONG_VIDEO_ROTATION), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_ROTATION));
    Mvw.put(Integer.valueOf(l.LONG_VIDEO_FRAME_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_FRAME_RATE));
    Mvx.put(Integer.valueOf(1001), Integer.valueOf(1001));
    Mvx.put(Integer.valueOf(1100), Integer.valueOf(1100));
    Mvx.put(Integer.valueOf(1101), Integer.valueOf(1101));
    Mvx.put(Integer.valueOf(1102), Integer.valueOf(1102));
    Mvx.put(Integer.valueOf(1103), Integer.valueOf(1103));
    Mvx.put(Integer.valueOf(1200), Integer.valueOf(1200));
    Mvx.put(Integer.valueOf(1210), Integer.valueOf(1210));
    Mvx.put(Integer.valueOf(1211), Integer.valueOf(1211));
    Mvx.put(Integer.valueOf(1220), Integer.valueOf(1220));
    Mvx.put(Integer.valueOf(1221), Integer.valueOf(1221));
    Mvx.put(Integer.valueOf(1230), Integer.valueOf(1230));
    Mvx.put(Integer.valueOf(1231), Integer.valueOf(1231));
    Mvx.put(Integer.valueOf(1300), Integer.valueOf(1300));
    Mvx.put(Integer.valueOf(1500), Integer.valueOf(1500));
    Mvx.put(Integer.valueOf(1600), Integer.valueOf(1600));
    Mvy.put(Integer.valueOf(1), Integer.valueOf(1));
    Mvy.put(Integer.valueOf(2), Integer.valueOf(2));
    Mvy.put(Integer.valueOf(3), Integer.valueOf(3));
    AppMethodBeat.o(194519);
  }
  
  public static com.tencent.thumbplayer.b.c a(TPAudioFrame paramTPAudioFrame)
  {
    AppMethodBeat.i(194517);
    com.tencent.thumbplayer.b.c localc = new com.tencent.thumbplayer.b.c();
    localc.data = paramTPAudioFrame.data;
    localc.MvF = paramTPAudioFrame.linesize;
    localc.sampleRate = paramTPAudioFrame.sampleRate;
    localc.channelLayout = paramTPAudioFrame.channelLayout;
    localc.MvG = (paramTPAudioFrame.ptsUs / 1000L);
    AppMethodBeat.o(194517);
    return localc;
  }
  
  public static i.e a(ITPNativePlayerMessageCallback.VideoCropInfo paramVideoCropInfo)
  {
    AppMethodBeat.i(194513);
    if (paramVideoCropInfo == null)
    {
      AppMethodBeat.o(194513);
      return null;
    }
    i.e locale = new i.e();
    locale.width = paramVideoCropInfo.width;
    locale.height = paramVideoCropInfo.height;
    locale.cropLeft = paramVideoCropInfo.cropLeft;
    locale.cropRight = paramVideoCropInfo.cropRight;
    locale.cropTop = paramVideoCropInfo.cropTop;
    locale.cropBottom = paramVideoCropInfo.cropBottom;
    AppMethodBeat.o(194513);
    return locale;
  }
  
  public static o a(TPVideoFrame paramTPVideoFrame)
  {
    int i = 12;
    AppMethodBeat.i(194516);
    o localo = new o();
    localo.data = paramTPVideoFrame.data;
    localo.lineSize = paramTPVideoFrame.linesize;
    int j = paramTPVideoFrame.format;
    if (-1 != j) {
      if (j == 0) {
        i = 0;
      }
    }
    for (;;)
    {
      localo.format = i;
      localo.iyx = paramTPVideoFrame.height;
      localo.iyw = paramTPVideoFrame.width;
      localo.wdX = paramTPVideoFrame.height;
      localo.wdW = paramTPVideoFrame.width;
      localo.rotation = paramTPVideoFrame.rotation;
      localo.MvG = (paramTPVideoFrame.ptsUs / 1000L);
      AppMethodBeat.o(194516);
      return localo;
      if (12 != j) {
        if (37 == j) {
          i = 37;
        } else {
          i = -1;
        }
      }
    }
  }
  
  public static int ahK(int paramInt)
  {
    AppMethodBeat.i(194509);
    if (!Mvu.containsKey(Integer.valueOf(paramInt)))
    {
      d.e(TAG, "player seek mode is invalid, return next frame mode instead");
      AppMethodBeat.o(194509);
      return 2;
    }
    paramInt = ((Integer)Mvu.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(194509);
    return paramInt;
  }
  
  public static a ahL(int paramInt)
  {
    AppMethodBeat.i(194510);
    a locala = (a)Mvt.get(paramInt);
    AppMethodBeat.o(194510);
    return locala;
  }
  
  public static int ahM(int paramInt)
  {
    AppMethodBeat.i(194511);
    if (!Mvv.containsKey(Integer.valueOf(paramInt)))
    {
      d.e(TAG, "nativePlayerMsgInfo: " + paramInt + " not recognition, return -1");
      AppMethodBeat.o(194511);
      return -1;
    }
    paramInt = ((Integer)Mvv.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(194511);
    return paramInt;
  }
  
  public static int ahN(int paramInt)
  {
    AppMethodBeat.i(194512);
    if (!Mvw.containsKey(Integer.valueOf(paramInt)))
    {
      d.e(TAG, "tpPropertyID: " + paramInt + " not recognition, return -1");
      AppMethodBeat.o(194512);
      return -1;
    }
    paramInt = ((Integer)Mvw.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(194512);
    return paramInt;
  }
  
  public static int ahO(int paramInt)
  {
    AppMethodBeat.i(194514);
    switch (paramInt)
    {
    default: 
      d.e(TAG, "decoderType: " + paramInt + " not recognition, return -1");
      paramInt = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(194514);
      return paramInt;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 101;
      continue;
      paramInt = 102;
    }
  }
  
  public static int ahP(int paramInt)
  {
    AppMethodBeat.i(194515);
    if (!Mvx.containsKey(Integer.valueOf(paramInt)))
    {
      d.e(TAG, "nativeErrorType: " + paramInt + " not recognition, return 1001");
      AppMethodBeat.o(194515);
      return 1001;
    }
    paramInt = ((Integer)Mvx.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(194515);
    return paramInt;
  }
  
  public static int ahQ(int paramInt)
  {
    AppMethodBeat.i(194518);
    if (!Mvy.containsKey(Integer.valueOf(paramInt)))
    {
      d.e(TAG, "player switch definition mode is invalid, return default mode instead");
      AppMethodBeat.o(194518);
      return 2;
    }
    paramInt = ((Integer)Mvy.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(194518);
    return paramInt;
  }
  
  public static final class a
  {
    int MvA;
    int Mvz;
    
    public a(int paramInt1, int paramInt2)
    {
      this.Mvz = paramInt1;
      this.MvA = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */