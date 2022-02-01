package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TPThumbplayerCapabilityHelper
{
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(227698);
    boolean bool = TPPlayerDecoderCapability.addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
    AppMethodBeat.o(227698);
    return bool;
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
  {
    AppMethodBeat.i(227708);
    boolean bool = TPPlayerDecoderCapability.addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
    AppMethodBeat.o(227708);
    return bool;
  }
  
  public static int[] getDRMCapabilities()
  {
    AppMethodBeat.i(227760);
    int[] arrayOfInt = TPDrm.getDRMCapabilities();
    AppMethodBeat.o(227760);
    return arrayOfInt;
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
  {
    AppMethodBeat.i(227715);
    HashMap localHashMap = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(paramInt);
    AppMethodBeat.o(227715);
    return localHashMap;
  }
  
  public static TPCodecCapability.TPVCodecMaxCapability getVCodecMaxCapability(int paramInt)
  {
    AppMethodBeat.i(227727);
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
      AppMethodBeat.o(227727);
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
      AppMethodBeat.i(227637);
      TPPlayerDecoderCapability.init(paramContext, paramBoolean);
      AppMethodBeat.o(227637);
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
    AppMethodBeat.i(227741);
    boolean bool = TPPlayerDecoderCapability.isDDPlusSupported();
    AppMethodBeat.o(227741);
    return bool;
  }
  
  public static boolean isDDSupported()
  {
    AppMethodBeat.i(227734);
    boolean bool = TPPlayerDecoderCapability.isDDPlusSupported();
    AppMethodBeat.o(227734);
    return bool;
  }
  
  public static boolean isDRMsupport(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(227771);
    int[] arrayOfInt = getDRMCapabilities();
    boolean bool1;
    if (arrayOfInt.length == 0)
    {
      bool1 = bool2;
      AppMethodBeat.o(227771);
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
    AppMethodBeat.i(227751);
    boolean bool = TPPlayerDecoderCapability.isDolbyDSSupported();
    AppMethodBeat.o(227751);
    return bool;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(227780);
    boolean bool = TPPlayerDecoderCapability.isHDRsupport(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(227780);
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
    AppMethodBeat.i(227675);
    boolean bool = isVCodecCapabilityCanSupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 30);
    AppMethodBeat.o(227675);
    return bool;
  }
  
  public static boolean isVCodecCapabilityCanSupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(227688);
    if (isVCodecCapabilitySupport(101, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6)) {}
    for (boolean bool = true;; bool = isVCodecCapabilitySupport(102, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6))
    {
      AppMethodBeat.o(227688);
      return bool;
    }
  }
  
  @Deprecated
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(227652);
    boolean bool = isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 30);
    AppMethodBeat.o(227652);
    return bool;
  }
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(227664);
    boolean bool = TPPlayerDecoderCapability.isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    AppMethodBeat.o(227664);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper
 * JD-Core Version:    0.7.0.1
 */