package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TPUnitendCodecUtils
{
  private static HashMap<String, String> mSecureDecoderNameMaps = null;
  
  public static String getSecureDecoderName(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    MediaCodecInfo[] arrayOfMediaCodecInfo;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(193743);
        if ((!TextUtils.equals("video/avc", paramString)) && (!TextUtils.equals("video/hevc", paramString)))
        {
          AppMethodBeat.o(193743);
          return localObject1;
        }
        if (mSecureDecoderNameMaps == null) {
          mSecureDecoderNameMaps = new HashMap();
        }
        if (mSecureDecoderNameMaps.containsKey(paramString))
        {
          localObject1 = (String)mSecureDecoderNameMaps.get(paramString);
          AppMethodBeat.o(193743);
          continue;
        }
        arrayOfMediaCodecInfo = new MediaCodecList(1).getCodecInfos();
      }
      finally {}
      if (arrayOfMediaCodecInfo != null) {
        break;
      }
      AppMethodBeat.o(193743);
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
              AppMethodBeat.o(193743);
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