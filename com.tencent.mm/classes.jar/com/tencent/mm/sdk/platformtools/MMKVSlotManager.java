package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "slotRecorder", "slotSeconds", "", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;J)V", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "", "decodeBool", "default", "decodeBytes", "", "decodeInt", "", "decodeLong", "decodeProtoBuffer", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "decodeString", "getSlotByKey", "kotlin.jvm.PlatformType", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"})
public class MMKVSlotManager
  extends BaseSlotManager<MultiProcessMMKV>
{
  private final MultiProcessMMKV slotRecorder;
  
  public MMKVSlotManager(MultiProcessMMKV paramMultiProcessMMKV, long paramLong)
  {
    super(paramLong, 0, 2, null);
    AppMethodBeat.i(156396);
    this.slotRecorder = paramMultiProcessMMKV;
    AppMethodBeat.o(156396);
  }
  
  protected void clearSlot(long paramLong, MultiProcessMMKV paramMultiProcessMMKV)
  {
    AppMethodBeat.i(263265);
    p.k(paramMultiProcessMMKV, "slot");
    if (paramMultiProcessMMKV.count() > 0L) {
      paramMultiProcessMMKV.clear();
    }
    AppMethodBeat.o(263265);
  }
  
  protected boolean containsKey(MultiProcessMMKV paramMultiProcessMMKV, String paramString)
  {
    AppMethodBeat.i(263275);
    p.k(paramMultiProcessMMKV, "slot");
    p.k(paramString, "key");
    boolean bool = paramMultiProcessMMKV.containsKey(paramString);
    AppMethodBeat.o(263275);
    return bool;
  }
  
  public final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(263287);
    p.k(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString);
    if (localMultiProcessMMKV != null)
    {
      boolean bool = localMultiProcessMMKV.containsKey(paramString);
      AppMethodBeat.o(263287);
      return bool;
    }
    AppMethodBeat.o(263287);
    return false;
  }
  
  public final boolean decodeBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(263285);
    p.k(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString);
    if (localMultiProcessMMKV != null)
    {
      paramBoolean = localMultiProcessMMKV.decodeBool(paramString, paramBoolean);
      AppMethodBeat.o(263285);
      return paramBoolean;
    }
    AppMethodBeat.o(263285);
    return paramBoolean;
  }
  
  public final byte[] decodeBytes(String paramString)
  {
    AppMethodBeat.i(263284);
    p.k(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString);
    if (localMultiProcessMMKV != null)
    {
      paramString = localMultiProcessMMKV.decodeBytes(paramString);
      AppMethodBeat.o(263284);
      return paramString;
    }
    AppMethodBeat.o(263284);
    return null;
  }
  
  public final int decodeInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(263278);
    p.k(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString);
    if (localMultiProcessMMKV != null)
    {
      paramInt = localMultiProcessMMKV.decodeInt(paramString, paramInt);
      AppMethodBeat.o(263278);
      return paramInt;
    }
    AppMethodBeat.o(263278);
    return paramInt;
  }
  
  public final long decodeLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(263280);
    p.k(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString);
    if (localMultiProcessMMKV != null)
    {
      paramLong = localMultiProcessMMKV.decodeLong(paramString);
      AppMethodBeat.o(263280);
      return paramLong;
    }
    AppMethodBeat.o(263280);
    return paramLong;
  }
  
  public final String decodeString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(263282);
    p.k(paramString1, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString1);
    String str = paramString2;
    if (localMultiProcessMMKV != null)
    {
      str = localMultiProcessMMKV.decodeString(paramString1, paramString2);
      if (str != null) {
        break label49;
      }
      str = paramString2;
    }
    label49:
    for (;;)
    {
      AppMethodBeat.o(263282);
      return str;
    }
  }
  
  protected MultiProcessMMKV getSlotByKey(String paramString, long paramLong)
  {
    AppMethodBeat.i(263270);
    p.k(paramString, "slotKey");
    paramString = MultiProcessMMKV.getMMKV(paramString, 2);
    AppMethodBeat.o(263270);
    return paramString;
  }
  
  protected void remarkSlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156392);
    p.k(paramString, "slotKey");
    this.slotRecorder.putLong(paramString, paramLong);
    AppMethodBeat.o(156392);
  }
  
  protected boolean verifySlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156393);
    p.k(paramString, "slotKey");
    if (this.slotRecorder.getLong(paramString, 0L) == paramLong)
    {
      AppMethodBeat.o(156393);
      return true;
    }
    AppMethodBeat.o(156393);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMKVSlotManager
 * JD-Core Version:    0.7.0.1
 */