package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TPUnitendCodecUtils
{
  private static int DolbyVisionProfileDvavPen;
  private static int DolbyVisionProfileDvavPer;
  private static int DolbyVisionProfileDvavSe = 9;
  private static int DolbyVisionProfileDvheDen;
  private static int DolbyVisionProfileDvheDer;
  private static int DolbyVisionProfileDvheDtb;
  private static int DolbyVisionProfileDvheDth;
  private static int DolbyVisionProfileDvheDtr;
  private static int DolbyVisionProfileDvheSt;
  private static int DolbyVisionProfileDvheStn;
  private static HashMap<String, String> mSecureDecoderNameMaps = null;
  
  static
  {
    DolbyVisionProfileDvavPer = 0;
    DolbyVisionProfileDvavPen = 1;
    DolbyVisionProfileDvheDer = 2;
    DolbyVisionProfileDvheDen = 3;
    DolbyVisionProfileDvheDtr = 4;
    DolbyVisionProfileDvheStn = 5;
    DolbyVisionProfileDvheDth = 6;
    DolbyVisionProfileDvheDtb = 7;
    DolbyVisionProfileDvheSt = 8;
  }
  
  public static int convertOmxProfileToDolbyVision(int paramInt)
  {
    AppMethodBeat.i(223282);
    int i = 0;
    switch (paramInt)
    {
    }
    for (;;)
    {
      TPNativeLog.printLog(2, "TPUnitendCodecUtils", "convertOmxProfileToDolbyVision omxProfile:" + paramInt + " dolbyVisionProfile:" + i);
      AppMethodBeat.o(223282);
      return i;
      i = DolbyVisionProfileDvavPer;
      continue;
      i = DolbyVisionProfileDvavPen;
      continue;
      i = DolbyVisionProfileDvheDer;
      continue;
      i = DolbyVisionProfileDvheDen;
      continue;
      i = DolbyVisionProfileDvheDtr;
      continue;
      i = DolbyVisionProfileDvheStn;
      continue;
      i = DolbyVisionProfileDvheDth;
      continue;
      i = DolbyVisionProfileDvheDtb;
      continue;
      i = DolbyVisionProfileDvheSt;
      continue;
      i = DolbyVisionProfileDvavSe;
    }
  }
  
  public static String getDolbyVisionDecoderName(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(223277);
        if (!TextUtils.equals("video/dolby-vision", paramString))
        {
          paramString = null;
          AppMethodBeat.o(223277);
          return paramString;
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          paramString = null;
          AppMethodBeat.o(223277);
          continue;
        }
        arrayOfMediaCodecInfo = new MediaCodecList(1).getCodecInfos();
      }
      finally {}
      MediaCodecInfo[] arrayOfMediaCodecInfo;
      if (arrayOfMediaCodecInfo == null)
      {
        paramString = null;
        AppMethodBeat.o(223277);
        continue;
      }
      Object localObject2 = null;
      int j = arrayOfMediaCodecInfo.length;
      paramInt2 = 0;
      Object localObject1 = localObject2;
      MediaCodecInfo localMediaCodecInfo;
      Object localObject3;
      if (paramInt2 < j)
      {
        localMediaCodecInfo = arrayOfMediaCodecInfo[paramInt2];
        TPNativeLog.printLog(2, "TPUnitendCodecUtils", "getDolbyVisionDecoderName name:" + localMediaCodecInfo.getName());
        boolean bool = localMediaCodecInfo.isEncoder();
        localObject3 = localObject2;
        if (bool) {
          break label347;
        }
      }
      try
      {
        localCodecCapabilities = localMediaCodecInfo.getCapabilitiesForType(paramString);
        localObject3 = localObject2;
        if (localCodecCapabilities != null)
        {
          localObject3 = localCodecCapabilities.profileLevels;
          int i = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i < localObject3.length)
            {
              int k = convertOmxProfileToDolbyVision(localObject3[i].profile);
              if (k != paramInt1) {
                break label338;
              }
              TPNativeLog.printLog(2, "TPUnitendCodecUtils", "getDolbyVisionDecoderName i:" + i + " profile:" + k + " dvProfile:" + paramInt1 + " bSecure:" + paramBoolean + " name:" + localMediaCodecInfo.getName());
              if (!paramBoolean) {
                break label328;
              }
              if (!localCodecCapabilities.isFeatureSupported("secure-playback")) {
                break label338;
              }
            }
            label328:
            for (localObject1 = localMediaCodecInfo.getName();; localObject1 = localMediaCodecInfo.getName())
            {
              localObject3 = localObject1;
              if (localObject1 == null) {
                break label347;
              }
              TPNativeLog.printLog(2, "TPUnitendCodecUtils", "getDolbyVisionDecoderName name:".concat(String.valueOf(localObject1)));
              AppMethodBeat.o(223277);
              paramString = (String)localObject1;
              break;
            }
            label338:
            i += 1;
          }
        }
        label347:
        paramInt2 += 1;
        localObject2 = localObject3;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          MediaCodecInfo.CodecCapabilities localCodecCapabilities = null;
        }
      }
    }
  }
  
  public static String getSecureDecoderName(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    MediaCodecInfo[] arrayOfMediaCodecInfo;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(223273);
        if ((!TextUtils.equals("video/avc", paramString)) && (!TextUtils.equals("video/hevc", paramString)) && (!TextUtils.equals("video/dolby-vision", paramString)))
        {
          AppMethodBeat.o(223273);
          return localObject1;
        }
        if (mSecureDecoderNameMaps == null) {
          mSecureDecoderNameMaps = new HashMap();
        }
        if (mSecureDecoderNameMaps.containsKey(paramString))
        {
          localObject1 = (String)mSecureDecoderNameMaps.get(paramString);
          AppMethodBeat.o(223273);
          continue;
        }
        arrayOfMediaCodecInfo = new MediaCodecList(1).getCodecInfos();
      }
      finally {}
      if (arrayOfMediaCodecInfo != null) {
        break;
      }
      AppMethodBeat.o(223273);
    }
    int j = arrayOfMediaCodecInfo.length;
    int i = 0;
    for (;;)
    {
      for (;;)
      {
        localObject1 = localObject3;
        MediaCodecInfo localMediaCodecInfo;
        if (i < j)
        {
          localMediaCodecInfo = arrayOfMediaCodecInfo[i];
          boolean bool = localMediaCodecInfo.isEncoder();
          if (bool) {}
        }
        else
        {
          try
          {
            localObject1 = localMediaCodecInfo.getCapabilitiesForType(paramString);
            if ((localObject1 != null) && (((MediaCodecInfo.CodecCapabilities)localObject1).isFeatureSupported("secure-playback")))
            {
              localObject1 = localMediaCodecInfo.getName();
              mSecureDecoderNameMaps.put(paramString, localObject1);
              AppMethodBeat.o(223273);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Object localObject2 = null;
            }
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPUnitendCodecUtils
 * JD-Core Version:    0.7.0.1
 */