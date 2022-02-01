package com.tencent.thumbplayer.api.capability;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.b.a;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.common.TPCodecCapability.TPVCodecMaxCapability;
import com.tencent.thumbplayer.core.common.TPCodecCapability.TPVCodecPropertyRange;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.d;
import java.util.HashMap;

public class TPCapability
{
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPVCodecCapabilityForSet paramTPVCodecCapabilityForSet)
  {
    AppMethodBeat.i(219942);
    TPCodecCapability.TPVCodecPropertyRange localTPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
    localTPVCodecPropertyRange.set(paramTPVCodecCapabilityForSet.getUpperboundWidth(), paramTPVCodecCapabilityForSet.getUpperboundHeight(), paramTPVCodecCapabilityForSet.getLowerboundWidth(), paramTPVCodecCapabilityForSet.getLowerboundHeight(), paramTPVCodecCapabilityForSet.getProfile(), paramTPVCodecCapabilityForSet.getLevel());
    boolean bool = TPThumbplayerCapabilityHelper.addVCodecBlacklist(d.aBq(paramInt1), d.aBr(paramInt2), localTPVCodecPropertyRange);
    AppMethodBeat.o(219942);
    return bool;
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPVCodecCapabilityForSet paramTPVCodecCapabilityForSet)
  {
    AppMethodBeat.i(219943);
    TPCodecCapability.TPVCodecPropertyRange localTPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
    localTPVCodecPropertyRange.set(paramTPVCodecCapabilityForSet.getUpperboundWidth(), paramTPVCodecCapabilityForSet.getUpperboundHeight(), paramTPVCodecCapabilityForSet.getLowerboundWidth(), paramTPVCodecCapabilityForSet.getLowerboundHeight(), paramTPVCodecCapabilityForSet.getProfile(), paramTPVCodecCapabilityForSet.getLevel());
    boolean bool = TPThumbplayerCapabilityHelper.addVCodecWhitelist(d.aBq(paramInt1), d.aBr(paramInt2), localTPVCodecPropertyRange);
    AppMethodBeat.o(219943);
    return bool;
  }
  
  public static int[] getDRMCapabilities()
  {
    AppMethodBeat.i(219953);
    int[] arrayOfInt = a.getDRMCapabilities();
    AppMethodBeat.o(219953);
    return arrayOfInt;
  }
  
  public static TPVCodecCapabilityForGet getThumbPlayerVCodecMaxCapability(int paramInt)
  {
    AppMethodBeat.i(219945);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      localObject = new TPVCodecCapabilityForGet(0, 0, 0, 30);
      AppMethodBeat.o(219945);
      return localObject;
    }
    Object localObject = TPThumbplayerCapabilityHelper.getVCodecMaxCapability(d.aBr(paramInt));
    if (localObject == null)
    {
      localObject = new TPVCodecCapabilityForGet(0, 0, 0, 30);
      AppMethodBeat.o(219945);
      return localObject;
    }
    localObject = new TPVCodecCapabilityForGet(((TPCodecCapability.TPVCodecMaxCapability)localObject).maxLumaSamples, ((TPCodecCapability.TPVCodecMaxCapability)localObject).maxProfile, ((TPCodecCapability.TPVCodecMaxCapability)localObject).maxLevel, ((TPCodecCapability.TPVCodecMaxCapability)localObject).maxFramerateFormaxLumaSamples);
    AppMethodBeat.o(219945);
    return localObject;
  }
  
  public static TPVCodecCapabilityForGet getThumbPlayerVCodecTypeMaxCapability(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219948);
    if (!TPNativeLibraryLoader.isLibLoaded())
    {
      localObject = new TPVCodecCapabilityForGet(0, 0, 0, 30);
      AppMethodBeat.o(219948);
      return localObject;
    }
    int i;
    if (101 == paramInt2) {
      i = 101;
    }
    for (;;)
    {
      localObject = TPThumbplayerCapabilityHelper.getVCodecDecoderMaxCapabilityMap(i);
      if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (((HashMap)localObject).get(Integer.valueOf(d.aBr(paramInt1))) != null)) {
        break;
      }
      localObject = new TPVCodecCapabilityForGet(0, 0, 0, 30);
      AppMethodBeat.o(219948);
      return localObject;
      i = paramInt2;
      if (102 == paramInt2) {
        i = 102;
      }
    }
    Object localObject = new TPVCodecCapabilityForGet(((TPCodecCapability.TPVCodecMaxCapability)((HashMap)localObject).get(Integer.valueOf(d.aBr(paramInt1)))).maxLumaSamples, ((TPCodecCapability.TPVCodecMaxCapability)((HashMap)localObject).get(Integer.valueOf(d.aBr(paramInt1)))).maxProfile, ((TPCodecCapability.TPVCodecMaxCapability)((HashMap)localObject).get(Integer.valueOf(d.aBr(paramInt1)))).maxLevel, ((TPCodecCapability.TPVCodecMaxCapability)((HashMap)localObject).get(Integer.valueOf(d.aBr(paramInt1)))).maxFramerateFormaxLumaSamples);
    AppMethodBeat.o(219948);
    return localObject;
  }
  
  public static boolean isDDPlusSupported()
  {
    AppMethodBeat.i(219950);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      AppMethodBeat.o(219950);
      return false;
    }
    boolean bool = TPThumbplayerCapabilityHelper.isDDPlusSupported();
    AppMethodBeat.o(219950);
    return bool;
  }
  
  public static boolean isDDSupported()
  {
    AppMethodBeat.i(219949);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      AppMethodBeat.o(219949);
      return false;
    }
    boolean bool = TPThumbplayerCapabilityHelper.isDDSupported();
    AppMethodBeat.o(219949);
    return bool;
  }
  
  public static boolean isDRMsupport(int paramInt)
  {
    AppMethodBeat.i(219954);
    boolean bool = a.aAL(paramInt);
    AppMethodBeat.o(219954);
    return bool;
  }
  
  public static boolean isDolbyDSSupported()
  {
    AppMethodBeat.i(219951);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      AppMethodBeat.o(219951);
      return false;
    }
    boolean bool = TPThumbplayerCapabilityHelper.isDolbyDSSupported();
    AppMethodBeat.o(219951);
    return bool;
  }
  
  public static boolean isDolbyVisionSupported()
  {
    return false;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(219956);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      AppMethodBeat.o(219956);
      return false;
    }
    int i;
    if (paramInt1 == 0) {
      i = 0;
    }
    for (;;)
    {
      boolean bool = TPThumbplayerCapabilityHelper.isHDRsupport(i, paramInt2, paramInt3);
      AppMethodBeat.o(219956);
      return bool;
      if (1 == paramInt1)
      {
        i = 1;
      }
      else if (2 == paramInt1)
      {
        i = 2;
      }
      else
      {
        i = paramInt1;
        if (3 == paramInt1) {
          i = 3;
        }
      }
    }
  }
  
  public static boolean isVCodecCapabilityCanSupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(219957);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      AppMethodBeat.o(219957);
      return false;
    }
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilityCanSupport(paramInt1, paramInt2, paramInt3, 0, 0, paramInt6);
    AppMethodBeat.o(219957);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.api.capability.TPCapability
 * JD-Core Version:    0.7.0.1
 */