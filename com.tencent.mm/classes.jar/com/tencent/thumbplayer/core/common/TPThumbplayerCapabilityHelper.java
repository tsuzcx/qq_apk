package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TPThumbplayerCapabilityHelper
{
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(189852);
    boolean bool = TPPlayerDecoderCapability.addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
    AppMethodBeat.o(189852);
    return bool;
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(189853);
    boolean bool = TPPlayerDecoderCapability.addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
    AppMethodBeat.o(189853);
    return bool;
  }
  
  public static int[] getDRMCapabilities()
  {
    AppMethodBeat.i(189859);
    int[] arrayOfInt = TPDrm.getDRMCapabilities();
    AppMethodBeat.o(189859);
    return arrayOfInt;
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
  {
    AppMethodBeat.i(189854);
    HashMap localHashMap = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(paramInt);
    AppMethodBeat.o(189854);
    return localHashMap;
  }
  
  public static TPCodecCapability.TPVCodecMaxCapability getVCodecMaxCapability(int paramInt)
  {
    AppMethodBeat.i(189855);
    TPCodecCapability.TPVCodecMaxCapability localTPVCodecMaxCapability2 = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    HashMap localHashMap1 = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(102);
    HashMap localHashMap2 = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(101);
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
      AppMethodBeat.o(189855);
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
      AppMethodBeat.i(189847);
      TPPlayerDecoderCapability.init(paramContext, paramBoolean);
      AppMethodBeat.o(189847);
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
    AppMethodBeat.i(189857);
    boolean bool = TPPlayerDecoderCapability.isDDPlusSupported();
    AppMethodBeat.o(189857);
    return bool;
  }
  
  public static boolean isDDSupported()
  {
    AppMethodBeat.i(189856);
    boolean bool = TPPlayerDecoderCapability.isDDPlusSupported();
    AppMethodBeat.o(189856);
    return bool;
  }
  
  public static boolean isDRMsupport(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(189860);
    int[] arrayOfInt = getDRMCapabilities();
    boolean bool1;
    if (arrayOfInt.length == 0)
    {
      bool1 = bool2;
      AppMethodBeat.o(189860);
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
    AppMethodBeat.i(189858);
    boolean bool = TPPlayerDecoderCapability.isDolbyDSSupported();
    AppMethodBeat.o(189858);
    return bool;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189861);
    boolean bool = TPPlayerDecoderCapability.isHDRsupport(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(189861);
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
  
  @Deprecated
  public static boolean isVCodecCapabilityCanSupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(189850);
    boolean bool = isVCodecCapabilityCanSupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 30);
    AppMethodBeat.o(189850);
    return bool;
  }
  
  public static boolean isVCodecCapabilityCanSupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(189851);
    if (isVCodecCapabilitySupport(101, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6)) {}
    for (boolean bool = true;; bool = isVCodecCapabilitySupport(102, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6))
    {
      AppMethodBeat.o(189851);
      return bool;
    }
  }
  
  @Deprecated
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(189848);
    boolean bool = isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 30);
    AppMethodBeat.o(189848);
    return bool;
  }
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(189849);
    boolean bool = TPPlayerDecoderCapability.isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    AppMethodBeat.o(189849);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper
 * JD-Core Version:    0.7.0.1
 */