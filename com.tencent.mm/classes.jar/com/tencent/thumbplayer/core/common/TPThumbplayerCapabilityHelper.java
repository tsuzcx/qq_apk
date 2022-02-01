package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TPThumbplayerCapabilityHelper
{
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(193733);
    boolean bool = TPPlayerDecoderCapability.addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
    AppMethodBeat.o(193733);
    return bool;
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(193734);
    boolean bool = TPPlayerDecoderCapability.addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
    AppMethodBeat.o(193734);
    return bool;
  }
  
  public static int[] getDRMCapabilities()
  {
    AppMethodBeat.i(193740);
    int[] arrayOfInt = TPDrm.getDRMCapabilities();
    AppMethodBeat.o(193740);
    return arrayOfInt;
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
  {
    AppMethodBeat.i(193735);
    HashMap localHashMap = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(paramInt);
    AppMethodBeat.o(193735);
    return localHashMap;
  }
  
  public static TPCodecCapability.TPVCodecMaxCapability getVCodecMaxCapability(int paramInt)
  {
    AppMethodBeat.i(193736);
    TPCodecCapability.TPVCodecMaxCapability localTPVCodecMaxCapability2 = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    HashMap localHashMap1 = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC);
    HashMap localHashMap2 = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(TPDecoderType.TP_VIDEO_DECODER_FFMPEG);
    TPCodecCapability.TPVCodecMaxCapability localTPVCodecMaxCapability1;
    if ((localHashMap1 != null) && (localHashMap2 != null))
    {
      localTPVCodecMaxCapability1 = localTPVCodecMaxCapability2;
      if (localHashMap1.containsKey(Integer.valueOf(paramInt)))
      {
        localTPVCodecMaxCapability1 = localTPVCodecMaxCapability2;
        if (localHashMap2.containsKey(Integer.valueOf(paramInt)))
        {
          if (((TPCodecCapability.TPVCodecMaxCapability)localHashMap1.get(Integer.valueOf(paramInt))).maxLumaSamples < ((TPCodecCapability.TPVCodecMaxCapability)localHashMap2.get(Integer.valueOf(paramInt))).maxLumaSamples) {
            break label118;
          }
          localTPVCodecMaxCapability1 = (TPCodecCapability.TPVCodecMaxCapability)localHashMap1.get(Integer.valueOf(paramInt));
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(193736);
      return localTPVCodecMaxCapability1;
      label118:
      localTPVCodecMaxCapability1 = (TPCodecCapability.TPVCodecMaxCapability)localHashMap2.get(Integer.valueOf(paramInt));
      continue;
      if (localHashMap1 != null)
      {
        localTPVCodecMaxCapability1 = localTPVCodecMaxCapability2;
        if (localHashMap1.containsKey(Integer.valueOf(paramInt))) {
          localTPVCodecMaxCapability1 = (TPCodecCapability.TPVCodecMaxCapability)localHashMap1.get(Integer.valueOf(paramInt));
        }
      }
      else
      {
        localTPVCodecMaxCapability1 = localTPVCodecMaxCapability2;
        if (localHashMap2 != null)
        {
          localTPVCodecMaxCapability1 = localTPVCodecMaxCapability2;
          if (localHashMap2.containsKey(Integer.valueOf(paramInt))) {
            localTPVCodecMaxCapability1 = (TPCodecCapability.TPVCodecMaxCapability)localHashMap2.get(Integer.valueOf(paramInt));
          }
        }
      }
    }
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(193730);
      TPPlayerDecoderCapability.init(paramContext, paramBoolean);
      AppMethodBeat.o(193730);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean isDDPlusSupported()
  {
    AppMethodBeat.i(193738);
    boolean bool = TPPlayerDecoderCapability.isDDPlusSupported();
    AppMethodBeat.o(193738);
    return bool;
  }
  
  public static boolean isDDSupported()
  {
    AppMethodBeat.i(193737);
    boolean bool = TPPlayerDecoderCapability.isDDPlusSupported();
    AppMethodBeat.o(193737);
    return bool;
  }
  
  public static boolean isDRMsupport(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(193741);
    int[] arrayOfInt = getDRMCapabilities();
    boolean bool1;
    if (arrayOfInt.length == 0)
    {
      bool1 = bool2;
      AppMethodBeat.o(193741);
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (paramInt == arrayOfInt[i])
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
  }
  
  public static boolean isDolbyDSSupported()
  {
    AppMethodBeat.i(193739);
    boolean bool = TPPlayerDecoderCapability.isDolbyDSSupported();
    AppMethodBeat.o(193739);
    return bool;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(193742);
    boolean bool = TPPlayerDecoderCapability.isHDRsupport(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(193742);
    return bool;
  }
  
  public static boolean isSupportMediaCodecRotateInternal()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isSupportNativeMediaCodec()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isSupportSetOutputSurfaceApi()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isVCodecCapabilityCanSupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(193732);
    if (isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_FFMPEG, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5)) {}
    for (boolean bool = true;; bool = isVCodecCapabilitySupport(TPDecoderType.TP_VIDEO_DECODER_MEDIACODEC, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5))
    {
      AppMethodBeat.o(193732);
      return bool;
    }
  }
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(193731);
    boolean bool = TPPlayerDecoderCapability.isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.o(193731);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper
 * JD-Core Version:    0.7.0.1
 */