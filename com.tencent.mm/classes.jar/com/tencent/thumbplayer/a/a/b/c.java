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
  private static HashMap<Integer, Integer> LYA;
  private static HashMap<Integer, Integer> LYB;
  private static HashMap<Integer, Integer> LYC;
  private static HashMap<Integer, Integer> LYD;
  private static SparseArray<a> LYy;
  private static HashMap<Integer, Integer> LYz;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(191841);
    TAG = "TPThumbPlayerUtils";
    LYy = new SparseArray();
    LYz = new HashMap();
    LYA = new HashMap();
    LYB = new HashMap();
    LYC = new HashMap();
    LYD = new HashMap();
    LYy.append(100, new a(1, 100));
    LYy.append(101, new a(3, 101));
    LYy.append(104, new a(1, 104));
    LYy.append(103, new a(1, 103));
    LYy.append(102, new a(1, 102));
    LYy.append(105, new a(1, 105));
    LYy.append(106, new a(1, 106));
    LYy.append(107, new a(1, 107));
    LYy.append(108, new a(1, 108));
    LYy.append(109, new a(4, 109));
    LYy.append(110, new a(3, 110));
    LYy.append(111, new a(3, 111));
    LYy.append(112, new a(3, 112));
    LYy.append(115, new a(3, 115));
    LYy.append(200, new a(4, 200));
    LYy.append(117, new a(1, 117));
    LYy.append(118, new a(6, 113));
    LYy.append(119, new a(3, 403));
    LYy.append(120, new a(3, 402));
    LYy.append(121, new a(4, 310));
    LYy.append(201, new a(3, 201));
    LYy.append(400, new a(3, 400));
    LYy.append(300, new a(4, 404));
    LYy.append(301, new a(4, 405));
    LYy.append(401, new a(3, 401));
    LYy.append(204, new a(5, 203));
    LYy.append(500, new a(1, 500));
    LYy.append(502, new a(4, 100));
    LYy.append(206, new a(1, 107));
    LYz.put(Integer.valueOf(1), Integer.valueOf(1));
    LYz.put(Integer.valueOf(2), Integer.valueOf(2));
    LYz.put(Integer.valueOf(3), Integer.valueOf(3));
    LYz.put(Integer.valueOf(4), Integer.valueOf(4));
    LYA.put(Integer.valueOf(101), Integer.valueOf(101));
    LYA.put(Integer.valueOf(102), Integer.valueOf(102));
    LYA.put(Integer.valueOf(103), Integer.valueOf(103));
    LYA.put(Integer.valueOf(104), Integer.valueOf(104));
    LYA.put(Integer.valueOf(105), Integer.valueOf(105));
    LYA.put(Integer.valueOf(106), Integer.valueOf(106));
    LYA.put(Integer.valueOf(107), Integer.valueOf(107));
    LYA.put(Integer.valueOf(150), Integer.valueOf(150));
    LYA.put(Integer.valueOf(151), Integer.valueOf(151));
    LYA.put(Integer.valueOf(152), Integer.valueOf(152));
    LYA.put(Integer.valueOf(153), Integer.valueOf(154));
    LYA.put(Integer.valueOf(200), Integer.valueOf(200));
    LYA.put(Integer.valueOf(201), Integer.valueOf(201));
    LYA.put(Integer.valueOf(203), Integer.valueOf(203));
    LYA.put(Integer.valueOf(204), Integer.valueOf(204));
    LYA.put(Integer.valueOf(205), Integer.valueOf(205));
    LYA.put(Integer.valueOf(206), Integer.valueOf(206));
    LYA.put(Integer.valueOf(207), Integer.valueOf(207));
    LYA.put(Integer.valueOf(208), Integer.valueOf(208));
    LYA.put(Integer.valueOf(500), Integer.valueOf(500));
    LYA.put(Integer.valueOf(501), Integer.valueOf(501));
    LYA.put(Integer.valueOf(3), Integer.valueOf(3));
    LYA.put(Integer.valueOf(4), Integer.valueOf(4));
    LYB.put(Integer.valueOf(l.STRING_MEDIA_INFO), Integer.valueOf(TPNativePlayerPropertyID.STRING_MEDIA_INFO));
    LYB.put(Integer.valueOf(l.LONG_AUDIO_CODEC_ID), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_CODEC_ID));
    LYB.put(Integer.valueOf(l.LONG_AUDIO_BIT_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_BIT_RATE));
    LYB.put(Integer.valueOf(l.LONG_AUDIO_PROFILE), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_PROFILE));
    LYB.put(Integer.valueOf(l.LONG_AUDIO_CHANNEL_NUM), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_CHANNEL_NUM));
    LYB.put(Integer.valueOf(l.LONG_VIDEO_CODEC_ID), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_CODEC_ID));
    LYB.put(Integer.valueOf(l.LONG_VIDEO_BIT_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_BIT_RATE));
    LYB.put(Integer.valueOf(l.LONG_VIDEO_PROFILE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_PROFILE));
    LYB.put(Integer.valueOf(l.LONG_VIDEO_LEVEL), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_LEVEL));
    LYB.put(Integer.valueOf(l.LONG_VIDEO_ROTATION), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_ROTATION));
    LYB.put(Integer.valueOf(l.LONG_VIDEO_FRAME_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_FRAME_RATE));
    LYC.put(Integer.valueOf(1001), Integer.valueOf(1001));
    LYC.put(Integer.valueOf(1100), Integer.valueOf(1100));
    LYC.put(Integer.valueOf(1101), Integer.valueOf(1101));
    LYC.put(Integer.valueOf(1102), Integer.valueOf(1102));
    LYC.put(Integer.valueOf(1103), Integer.valueOf(1103));
    LYC.put(Integer.valueOf(1200), Integer.valueOf(1200));
    LYC.put(Integer.valueOf(1210), Integer.valueOf(1210));
    LYC.put(Integer.valueOf(1211), Integer.valueOf(1211));
    LYC.put(Integer.valueOf(1220), Integer.valueOf(1220));
    LYC.put(Integer.valueOf(1221), Integer.valueOf(1221));
    LYC.put(Integer.valueOf(1230), Integer.valueOf(1230));
    LYC.put(Integer.valueOf(1231), Integer.valueOf(1231));
    LYC.put(Integer.valueOf(1300), Integer.valueOf(1300));
    LYC.put(Integer.valueOf(1500), Integer.valueOf(1500));
    LYC.put(Integer.valueOf(1600), Integer.valueOf(1600));
    LYD.put(Integer.valueOf(1), Integer.valueOf(1));
    LYD.put(Integer.valueOf(2), Integer.valueOf(2));
    LYD.put(Integer.valueOf(3), Integer.valueOf(3));
    AppMethodBeat.o(191841);
  }
  
  public static com.tencent.thumbplayer.b.c a(TPAudioFrame paramTPAudioFrame)
  {
    AppMethodBeat.i(191839);
    com.tencent.thumbplayer.b.c localc = new com.tencent.thumbplayer.b.c();
    localc.data = paramTPAudioFrame.data;
    localc.LYK = paramTPAudioFrame.linesize;
    localc.sampleRate = paramTPAudioFrame.sampleRate;
    localc.channelLayout = paramTPAudioFrame.channelLayout;
    localc.LYL = (paramTPAudioFrame.ptsUs / 1000L);
    AppMethodBeat.o(191839);
    return localc;
  }
  
  public static i.e a(ITPNativePlayerMessageCallback.VideoCropInfo paramVideoCropInfo)
  {
    AppMethodBeat.i(191835);
    if (paramVideoCropInfo == null)
    {
      AppMethodBeat.o(191835);
      return null;
    }
    i.e locale = new i.e();
    locale.width = paramVideoCropInfo.width;
    locale.height = paramVideoCropInfo.height;
    locale.cropLeft = paramVideoCropInfo.cropLeft;
    locale.cropRight = paramVideoCropInfo.cropRight;
    locale.cropTop = paramVideoCropInfo.cropTop;
    locale.cropBottom = paramVideoCropInfo.cropBottom;
    AppMethodBeat.o(191835);
    return locale;
  }
  
  public static o a(TPVideoFrame paramTPVideoFrame)
  {
    int i = 12;
    AppMethodBeat.i(191838);
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
      localo.ivE = paramTPVideoFrame.height;
      localo.ivD = paramTPVideoFrame.width;
      localo.vRT = paramTPVideoFrame.height;
      localo.vRS = paramTPVideoFrame.width;
      localo.rotation = paramTPVideoFrame.rotation;
      localo.LYL = (paramTPVideoFrame.ptsUs / 1000L);
      AppMethodBeat.o(191838);
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
  
  public static int ahb(int paramInt)
  {
    AppMethodBeat.i(191831);
    if (!LYz.containsKey(Integer.valueOf(paramInt)))
    {
      d.e(TAG, "player seek mode is invalid, return next frame mode instead");
      AppMethodBeat.o(191831);
      return 2;
    }
    paramInt = ((Integer)LYz.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(191831);
    return paramInt;
  }
  
  public static a ahc(int paramInt)
  {
    AppMethodBeat.i(191832);
    a locala = (a)LYy.get(paramInt);
    AppMethodBeat.o(191832);
    return locala;
  }
  
  public static int ahd(int paramInt)
  {
    AppMethodBeat.i(191833);
    if (!LYA.containsKey(Integer.valueOf(paramInt)))
    {
      d.e(TAG, "nativePlayerMsgInfo: " + paramInt + " not recognition, return -1");
      AppMethodBeat.o(191833);
      return -1;
    }
    paramInt = ((Integer)LYA.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(191833);
    return paramInt;
  }
  
  public static int ahe(int paramInt)
  {
    AppMethodBeat.i(191834);
    if (!LYB.containsKey(Integer.valueOf(paramInt)))
    {
      d.e(TAG, "tpPropertyID: " + paramInt + " not recognition, return -1");
      AppMethodBeat.o(191834);
      return -1;
    }
    paramInt = ((Integer)LYB.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(191834);
    return paramInt;
  }
  
  public static int ahf(int paramInt)
  {
    AppMethodBeat.i(191836);
    switch (paramInt)
    {
    default: 
      d.e(TAG, "decoderType: " + paramInt + " not recognition, return -1");
      paramInt = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(191836);
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
  
  public static int ahg(int paramInt)
  {
    AppMethodBeat.i(191837);
    if (!LYC.containsKey(Integer.valueOf(paramInt)))
    {
      d.e(TAG, "nativeErrorType: " + paramInt + " not recognition, return 1001");
      AppMethodBeat.o(191837);
      return 1001;
    }
    paramInt = ((Integer)LYC.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(191837);
    return paramInt;
  }
  
  public static int ahh(int paramInt)
  {
    AppMethodBeat.i(191840);
    if (!LYD.containsKey(Integer.valueOf(paramInt)))
    {
      d.e(TAG, "player switch definition mode is invalid, return default mode instead");
      AppMethodBeat.o(191840);
      return 2;
    }
    paramInt = ((Integer)LYD.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(191840);
    return paramInt;
  }
  
  public static final class a
  {
    int LYE;
    int LYF;
    
    public a(int paramInt1, int paramInt2)
    {
      this.LYE = paramInt1;
      this.LYF = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */