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
    AppMethodBeat.i(189062);
    TPCodecCapability.TPVCodecPropertyRange localTPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
    localTPVCodecPropertyRange.set(paramTPVCodecCapabilityForSet.getUpperboundWidth(), paramTPVCodecCapabilityForSet.getUpperboundHeight(), paramTPVCodecCapabilityForSet.getLowerboundWidth(), paramTPVCodecCapabilityForSet.getLowerboundHeight(), paramTPVCodecCapabilityForSet.getProfile(), paramTPVCodecCapabilityForSet.getLevel());
    boolean bool = TPThumbplayerCapabilityHelper.addVCodecBlacklist(d.arC(paramInt1), d.arD(paramInt2), localTPVCodecPropertyRange);
    AppMethodBeat.o(189062);
    return bool;
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPVCodecCapabilityForSet paramTPVCodecCapabilityForSet)
  {
    AppMethodBeat.i(189063);
    TPCodecCapability.TPVCodecPropertyRange localTPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
    localTPVCodecPropertyRange.set(paramTPVCodecCapabilityForSet.getUpperboundWidth(), paramTPVCodecCapabilityForSet.getUpperboundHeight(), paramTPVCodecCapabilityForSet.getLowerboundWidth(), paramTPVCodecCapabilityForSet.getLowerboundHeight(), paramTPVCodecCapabilityForSet.getProfile(), paramTPVCodecCapabilityForSet.getLevel());
    boolean bool = TPThumbplayerCapabilityHelper.addVCodecWhitelist(d.arC(paramInt1), d.arD(paramInt2), localTPVCodecPropertyRange);
    AppMethodBeat.o(189063);
    return bool;
  }
  
  public static int[] getDRMCapabilities()
  {
    AppMethodBeat.i(189069);
    int[] arrayOfInt = a.getDRMCapabilities();
    AppMethodBeat.o(189069);
    return arrayOfInt;
  }
  
  public static TPVCodecCapabilityForGet getThumbPlayerVCodecMaxCapability(int paramInt)
  {
    AppMethodBeat.i(189064);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      localObject = new TPVCodecCapabilityForGet(0, 0, 0, 30);
      AppMethodBeat.o(189064);
      return localObject;
    }
    Object localObject = TPThumbplayerCapabilityHelper.getVCodecMaxCapability(d.arD(paramInt));
    if (localObject == null)
    {
      localObject = new TPVCodecCapabilityForGet(0, 0, 0, 30);
      AppMethodBeat.o(189064);
      return localObject;
    }
    localObject = new TPVCodecCapabilityForGet(((TPCodecCapability.TPVCodecMaxCapability)localObject).maxLumaSamples, ((TPCodecCapability.TPVCodecMaxCapability)localObject).maxProfile, ((TPCodecCapability.TPVCodecMaxCapability)localObject).maxLevel, ((TPCodecCapability.TPVCodecMaxCapability)localObject).maxFramerateFormaxLumaSamples);
    AppMethodBeat.o(189064);
    return localObject;
  }
  
  public static TPVCodecCapabilityForGet getThumbPlayerVCodecTypeMaxCapability(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189065);
    if (!TPNativeLibraryLoader.isLibLoaded())
    {
      localObject = new TPVCodecCapabilityForGet(0, 0, 0, 30);
      AppMethodBeat.o(189065);
      return localObject;
    }
    int i;
    if (101 == paramInt2) {
      i = 101;
    }
    for (;;)
    {
      localObject = TPThumbplayerCapabilityHelper.getVCodecDecoderMaxCapabilityMap(i);
      if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (((HashMap)localObject).get(Integer.valueOf(d.arD(paramInt1))) != null)) {
        break;
      }
      localObject = new TPVCodecCapabilityForGet(0, 0, 0, 30);
      AppMethodBeat.o(189065);
      return localObject;
      i = paramInt2;
      if (102 == paramInt2) {
        i = 102;
      }
    }
    Object localObject = new TPVCodecCapabilityForGet(((TPCodecCapability.TPVCodecMaxCapability)((HashMap)localObject).get(Integer.valueOf(d.arD(paramInt1)))).maxLumaSamples, ((TPCodecCapability.TPVCodecMaxCapability)((HashMap)localObject).get(Integer.valueOf(d.arD(paramInt1)))).maxProfile, ((TPCodecCapability.TPVCodecMaxCapability)((HashMap)localObject).get(Integer.valueOf(d.arD(paramInt1)))).maxLevel, ((TPCodecCapability.TPVCodecMaxCapability)((HashMap)localObject).get(Integer.valueOf(d.arD(paramInt1)))).maxFramerateFormaxLumaSamples);
    AppMethodBeat.o(189065);
    return localObject;
  }
  
  public static boolean isDDPlusSupported()
  {
    AppMethodBeat.i(189067);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      AppMethodBeat.o(189067);
      return false;
    }
    boolean bool = TPThumbplayerCapabilityHelper.isDDPlusSupported();
    AppMethodBeat.o(189067);
    return bool;
  }
  
  public static boolean isDDSupported()
  {
    AppMethodBeat.i(189066);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      AppMethodBeat.o(189066);
      return false;
    }
    boolean bool = TPThumbplayerCapabilityHelper.isDDSupported();
    AppMethodBeat.o(189066);
    return bool;
  }
  
  public static boolean isDRMsupport(int paramInt)
  {
    AppMethodBeat.i(189070);
    boolean bool = a.aqY(paramInt);
    AppMethodBeat.o(189070);
    return bool;
  }
  
  public static boolean isDolbyDSSupported()
  {
    AppMethodBeat.i(189068);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      AppMethodBeat.o(189068);
      return false;
    }
    boolean bool = TPThumbplayerCapabilityHelper.isDolbyDSSupported();
    AppMethodBeat.o(189068);
    return bool;
  }
  
  public static boolean isDolbyVisionSupported()
  {
    return false;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189071);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      AppMethodBeat.o(189071);
      return false;
    }
    int i;
    if (paramInt1 == 0) {
      i = 0;
    }
    for (;;)
    {
      boolean bool = TPThumbplayerCapabilityHelper.isHDRsupport(i, paramInt2, paramInt3);
      AppMethodBeat.o(189071);
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
    AppMethodBeat.i(189072);
    if (!TPPlayerMgr.isThumbPlayerEnable())
    {
      AppMethodBeat.o(189072);
      return false;
    }
    boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilityCanSupport(paramInt1, paramInt2, paramInt3, 0, 0, paramInt6);
    AppMethodBeat.o(189072);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.api.capability.TPCapability
 * JD-Core Version:    0.7.0.1
 */