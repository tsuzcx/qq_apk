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
import com.tencent.thumbplayer.utils.f;
import java.util.HashMap;

public final class c
{
  private static SparseArray<a> KeC;
  private static HashMap<Integer, Integer> KeD;
  private static HashMap<Integer, Integer> KeE;
  private static HashMap<Integer, Integer> KeF;
  private static HashMap<Integer, Integer> KeG;
  private static HashMap<Integer, Integer> KeH;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(187820);
    TAG = "TPThumbPlayerUtils";
    KeC = new SparseArray();
    KeD = new HashMap();
    KeE = new HashMap();
    KeF = new HashMap();
    KeG = new HashMap();
    KeH = new HashMap();
    KeC.append(100, new a(1, 100));
    KeC.append(101, new a(3, 101));
    KeC.append(104, new a(1, 104));
    KeC.append(103, new a(1, 103));
    KeC.append(102, new a(1, 102));
    KeC.append(105, new a(1, 105));
    KeC.append(106, new a(1, 106));
    KeC.append(107, new a(1, 107));
    KeC.append(108, new a(1, 108));
    KeC.append(109, new a(4, 109));
    KeC.append(110, new a(3, 110));
    KeC.append(111, new a(3, 111));
    KeC.append(112, new a(3, 112));
    KeC.append(115, new a(3, 115));
    KeC.append(200, new a(4, 200));
    KeC.append(117, new a(1, 117));
    KeC.append(118, new a(6, 113));
    KeC.append(119, new a(3, 403));
    KeC.append(120, new a(3, 402));
    KeC.append(121, new a(4, 310));
    KeC.append(201, new a(3, 201));
    KeC.append(400, new a(3, 400));
    KeC.append(300, new a(4, 404));
    KeC.append(301, new a(4, 405));
    KeC.append(401, new a(3, 401));
    KeC.append(204, new a(5, 203));
    KeC.append(500, new a(1, 500));
    KeC.append(502, new a(4, 100));
    KeC.append(206, new a(1, 107));
    KeD.put(Integer.valueOf(1), Integer.valueOf(1));
    KeD.put(Integer.valueOf(2), Integer.valueOf(2));
    KeD.put(Integer.valueOf(3), Integer.valueOf(3));
    KeD.put(Integer.valueOf(4), Integer.valueOf(4));
    KeE.put(Integer.valueOf(101), Integer.valueOf(101));
    KeE.put(Integer.valueOf(102), Integer.valueOf(102));
    KeE.put(Integer.valueOf(103), Integer.valueOf(103));
    KeE.put(Integer.valueOf(104), Integer.valueOf(104));
    KeE.put(Integer.valueOf(105), Integer.valueOf(105));
    KeE.put(Integer.valueOf(106), Integer.valueOf(106));
    KeE.put(Integer.valueOf(107), Integer.valueOf(107));
    KeE.put(Integer.valueOf(150), Integer.valueOf(150));
    KeE.put(Integer.valueOf(151), Integer.valueOf(151));
    KeE.put(Integer.valueOf(152), Integer.valueOf(152));
    KeE.put(Integer.valueOf(153), Integer.valueOf(154));
    KeE.put(Integer.valueOf(200), Integer.valueOf(200));
    KeE.put(Integer.valueOf(201), Integer.valueOf(201));
    KeE.put(Integer.valueOf(203), Integer.valueOf(203));
    KeE.put(Integer.valueOf(204), Integer.valueOf(204));
    KeE.put(Integer.valueOf(205), Integer.valueOf(205));
    KeE.put(Integer.valueOf(206), Integer.valueOf(206));
    KeE.put(Integer.valueOf(207), Integer.valueOf(207));
    KeE.put(Integer.valueOf(208), Integer.valueOf(208));
    KeE.put(Integer.valueOf(500), Integer.valueOf(500));
    KeE.put(Integer.valueOf(501), Integer.valueOf(501));
    KeE.put(Integer.valueOf(3), Integer.valueOf(3));
    KeE.put(Integer.valueOf(4), Integer.valueOf(4));
    KeF.put(Integer.valueOf(l.STRING_MEDIA_INFO), Integer.valueOf(TPNativePlayerPropertyID.STRING_MEDIA_INFO));
    KeF.put(Integer.valueOf(l.LONG_AUDIO_CODEC_ID), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_CODEC_ID));
    KeF.put(Integer.valueOf(l.LONG_AUDIO_BIT_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_BIT_RATE));
    KeF.put(Integer.valueOf(l.LONG_AUDIO_PROFILE), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_PROFILE));
    KeF.put(Integer.valueOf(l.LONG_AUDIO_CHANNEL_NUM), Integer.valueOf(TPNativePlayerPropertyID.LONG_AUDIO_CHANNEL_NUM));
    KeF.put(Integer.valueOf(l.LONG_VIDEO_CODEC_ID), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_CODEC_ID));
    KeF.put(Integer.valueOf(l.LONG_VIDEO_BIT_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_BIT_RATE));
    KeF.put(Integer.valueOf(l.LONG_VIDEO_PROFILE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_PROFILE));
    KeF.put(Integer.valueOf(l.LONG_VIDEO_LEVEL), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_LEVEL));
    KeF.put(Integer.valueOf(l.LONG_VIDEO_ROTATION), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_ROTATION));
    KeF.put(Integer.valueOf(l.LONG_VIDEO_FRAME_RATE), Integer.valueOf(TPNativePlayerPropertyID.LONG_VIDEO_FRAME_RATE));
    KeG.put(Integer.valueOf(1001), Integer.valueOf(1001));
    KeG.put(Integer.valueOf(1100), Integer.valueOf(1100));
    KeG.put(Integer.valueOf(1101), Integer.valueOf(1101));
    KeG.put(Integer.valueOf(1102), Integer.valueOf(1102));
    KeG.put(Integer.valueOf(1103), Integer.valueOf(1103));
    KeG.put(Integer.valueOf(1200), Integer.valueOf(1200));
    KeG.put(Integer.valueOf(1210), Integer.valueOf(1210));
    KeG.put(Integer.valueOf(1211), Integer.valueOf(1211));
    KeG.put(Integer.valueOf(1220), Integer.valueOf(1220));
    KeG.put(Integer.valueOf(1221), Integer.valueOf(1221));
    KeG.put(Integer.valueOf(1230), Integer.valueOf(1230));
    KeG.put(Integer.valueOf(1231), Integer.valueOf(1231));
    KeG.put(Integer.valueOf(1300), Integer.valueOf(1300));
    KeG.put(Integer.valueOf(1500), Integer.valueOf(1500));
    KeG.put(Integer.valueOf(1600), Integer.valueOf(1600));
    KeH.put(Integer.valueOf(1), Integer.valueOf(1));
    KeH.put(Integer.valueOf(2), Integer.valueOf(2));
    KeH.put(Integer.valueOf(3), Integer.valueOf(3));
    AppMethodBeat.o(187820);
  }
  
  public static com.tencent.thumbplayer.b.c a(TPAudioFrame paramTPAudioFrame)
  {
    AppMethodBeat.i(187818);
    com.tencent.thumbplayer.b.c localc = new com.tencent.thumbplayer.b.c();
    localc.data = paramTPAudioFrame.data;
    localc.KeO = paramTPAudioFrame.linesize;
    localc.sampleRate = paramTPAudioFrame.sampleRate;
    localc.channelLayout = paramTPAudioFrame.channelLayout;
    localc.KeP = (paramTPAudioFrame.ptsUs / 1000L);
    AppMethodBeat.o(187818);
    return localc;
  }
  
  public static i.e a(ITPNativePlayerMessageCallback.VideoCropInfo paramVideoCropInfo)
  {
    AppMethodBeat.i(187814);
    if (paramVideoCropInfo == null)
    {
      AppMethodBeat.o(187814);
      return null;
    }
    i.e locale = new i.e();
    locale.width = paramVideoCropInfo.width;
    locale.height = paramVideoCropInfo.height;
    locale.cropLeft = paramVideoCropInfo.cropLeft;
    locale.cropRight = paramVideoCropInfo.cropRight;
    locale.cropTop = paramVideoCropInfo.cropTop;
    locale.cropBottom = paramVideoCropInfo.cropBottom;
    AppMethodBeat.o(187814);
    return locale;
  }
  
  public static o a(TPVideoFrame paramTPVideoFrame)
  {
    int i = 12;
    AppMethodBeat.i(187817);
    o localo = new o();
    localo.data = paramTPVideoFrame.data;
    localo.Kfr = paramTPVideoFrame.linesize;
    int j = paramTPVideoFrame.format;
    if (-1 != j) {
      if (j == 0) {
        i = 0;
      }
    }
    for (;;)
    {
      localo.format = i;
      localo.ici = paramTPVideoFrame.height;
      localo.ich = paramTPVideoFrame.width;
      localo.uOK = paramTPVideoFrame.height;
      localo.uOJ = paramTPVideoFrame.width;
      localo.rotation = paramTPVideoFrame.rotation;
      localo.KeP = (paramTPVideoFrame.ptsUs / 1000L);
      AppMethodBeat.o(187817);
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
  
  public static int aeB(int paramInt)
  {
    AppMethodBeat.i(187810);
    if (!KeD.containsKey(Integer.valueOf(paramInt)))
    {
      f.e(TAG, "player seek mode is invalid, return next frame mode instead");
      AppMethodBeat.o(187810);
      return 2;
    }
    paramInt = ((Integer)KeD.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(187810);
    return paramInt;
  }
  
  public static a aeC(int paramInt)
  {
    AppMethodBeat.i(187811);
    a locala = (a)KeC.get(paramInt);
    AppMethodBeat.o(187811);
    return locala;
  }
  
  public static int aeD(int paramInt)
  {
    AppMethodBeat.i(187812);
    if (!KeE.containsKey(Integer.valueOf(paramInt)))
    {
      f.e(TAG, "nativePlayerMsgInfo: " + paramInt + " not recognition, return -1");
      AppMethodBeat.o(187812);
      return -1;
    }
    paramInt = ((Integer)KeE.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(187812);
    return paramInt;
  }
  
  public static int aeE(int paramInt)
  {
    AppMethodBeat.i(187813);
    if (!KeF.containsKey(Integer.valueOf(paramInt)))
    {
      f.e(TAG, "tpPropertyID: " + paramInt + " not recognition, return -1");
      AppMethodBeat.o(187813);
      return -1;
    }
    paramInt = ((Integer)KeF.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(187813);
    return paramInt;
  }
  
  public static int aeF(int paramInt)
  {
    AppMethodBeat.i(187815);
    switch (paramInt)
    {
    default: 
      f.e(TAG, "decoderType: " + paramInt + " not recognition, return -1");
      paramInt = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(187815);
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
  
  public static int aeG(int paramInt)
  {
    AppMethodBeat.i(187816);
    if (!KeG.containsKey(Integer.valueOf(paramInt)))
    {
      f.e(TAG, "nativeErrorType: " + paramInt + " not recognition, return 1001");
      AppMethodBeat.o(187816);
      return 1001;
    }
    paramInt = ((Integer)KeG.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(187816);
    return paramInt;
  }
  
  public static int aeH(int paramInt)
  {
    AppMethodBeat.i(187819);
    if (!KeH.containsKey(Integer.valueOf(paramInt)))
    {
      f.e(TAG, "player switch definition mode is invalid, return default mode instead");
      AppMethodBeat.o(187819);
      return 2;
    }
    paramInt = ((Integer)KeH.get(Integer.valueOf(paramInt))).intValue();
    AppMethodBeat.o(187819);
    return paramInt;
  }
  
  public static final class a
  {
    int KeI;
    int KeJ;
    
    public a(int paramInt1, int paramInt2)
    {
      this.KeI = paramInt1;
      this.KeJ = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */