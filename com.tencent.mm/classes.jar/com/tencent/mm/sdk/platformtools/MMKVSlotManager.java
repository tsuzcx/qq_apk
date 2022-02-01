package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "slotRecorder", "slotSeconds", "", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;J)V", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "", "decodeProtoBuffer", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getSlotByKey", "kotlin.jvm.PlatformType", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"})
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
    AppMethodBeat.i(215490);
    p.h(paramMultiProcessMMKV, "slot");
    if (paramMultiProcessMMKV.count() > 0L) {
      paramMultiProcessMMKV.clear();
    }
    AppMethodBeat.o(215490);
  }
  
  protected boolean containsKey(MultiProcessMMKV paramMultiProcessMMKV, String paramString)
  {
    AppMethodBeat.i(215492);
    p.h(paramMultiProcessMMKV, "slot");
    p.h(paramString, "key");
    boolean bool = paramMultiProcessMMKV.containsKey(paramString);
    AppMethodBeat.o(215492);
    return bool;
  }
  
  protected MultiProcessMMKV getSlotByKey(String paramString, long paramLong)
  {
    AppMethodBeat.i(215491);
    p.h(paramString, "slotKey");
    paramString = MultiProcessMMKV.getMMKV(paramString, 2);
    AppMethodBeat.o(215491);
    return paramString;
  }
  
  protected void remarkSlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156392);
    p.h(paramString, "slotKey");
    this.slotRecorder.putLong(paramString, paramLong);
    AppMethodBeat.o(156392);
  }
  
  protected boolean verifySlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156393);
    p.h(paramString, "slotKey");
    if (this.slotRecorder.getLong(paramString, 0L) == paramLong)
    {
      AppMethodBeat.o(156393);
      return true;
    }
    AppMethodBeat.o(156393);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMKVSlotManager
 * JD-Core Version:    0.7.0.1
 */