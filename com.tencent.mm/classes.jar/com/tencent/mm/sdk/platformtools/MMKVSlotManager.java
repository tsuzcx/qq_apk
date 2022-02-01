package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "slotRecorder", "slotSeconds", "", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;J)V", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "", "decodeBool", "default", "decodeBytes", "", "decodeInt", "", "decodeLong", "decodeProtoBuffer", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "decodeString", "getSlotByKey", "kotlin.jvm.PlatformType", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
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
    AppMethodBeat.i(243716);
    s.u(paramMultiProcessMMKV, "slot");
    if (paramMultiProcessMMKV.count() > 0L) {
      paramMultiProcessMMKV.clear();
    }
    AppMethodBeat.o(243716);
  }
  
  protected boolean containsKey(MultiProcessMMKV paramMultiProcessMMKV, String paramString)
  {
    AppMethodBeat.i(243727);
    s.u(paramMultiProcessMMKV, "slot");
    s.u(paramString, "key");
    boolean bool = paramMultiProcessMMKV.containsKey(paramString);
    AppMethodBeat.o(243727);
    return bool;
  }
  
  public final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(243750);
    s.u(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString);
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(243750);
      return false;
    }
    boolean bool = localMultiProcessMMKV.containsKey(paramString);
    AppMethodBeat.o(243750);
    return bool;
  }
  
  public final boolean decodeBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(243747);
    s.u(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString);
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(243747);
      return paramBoolean;
    }
    paramBoolean = localMultiProcessMMKV.decodeBool(paramString, paramBoolean);
    AppMethodBeat.o(243747);
    return paramBoolean;
  }
  
  public final byte[] decodeBytes(String paramString)
  {
    AppMethodBeat.i(243745);
    s.u(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString);
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(243745);
      return null;
    }
    paramString = localMultiProcessMMKV.decodeBytes(paramString);
    AppMethodBeat.o(243745);
    return paramString;
  }
  
  public final int decodeInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(243733);
    s.u(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString);
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(243733);
      return paramInt;
    }
    paramInt = localMultiProcessMMKV.decodeInt(paramString, paramInt);
    AppMethodBeat.o(243733);
    return paramInt;
  }
  
  public final long decodeLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(243740);
    s.u(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString);
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(243740);
      return paramLong;
    }
    paramLong = localMultiProcessMMKV.decodeLong(paramString);
    AppMethodBeat.o(243740);
    return paramLong;
  }
  
  public final String decodeString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243741);
    s.u(paramString1, "key");
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)findSlot(paramString1);
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(243741);
      return paramString2;
    }
    paramString1 = localMultiProcessMMKV.decodeString(paramString1, paramString2);
    if (paramString1 == null)
    {
      AppMethodBeat.o(243741);
      return paramString2;
    }
    AppMethodBeat.o(243741);
    return paramString1;
  }
  
  protected MultiProcessMMKV getSlotByKey(String paramString, long paramLong)
  {
    AppMethodBeat.i(243724);
    s.u(paramString, "slotKey");
    paramString = MultiProcessMMKV.getMMKV(paramString, 2);
    AppMethodBeat.o(243724);
    return paramString;
  }
  
  protected void remarkSlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156392);
    s.u(paramString, "slotKey");
    this.slotRecorder.putLong(paramString, paramLong);
    AppMethodBeat.o(156392);
  }
  
  protected boolean verifySlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156393);
    s.u(paramString, "slotKey");
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