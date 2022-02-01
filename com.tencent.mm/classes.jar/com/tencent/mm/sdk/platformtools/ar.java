package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "slotRecorder", "slotSeconds", "", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;J)V", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "", "decodeProtoBuffer", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getSlotByKey", "kotlin.jvm.PlatformType", "slotKey", "remarkSlot", "verifySlot", "libcompatible_release"})
public class ar
  extends e<ax>
{
  private final ax IdT;
  
  public ar(ax paramax, long paramLong)
  {
    super(paramLong, (byte)0);
    AppMethodBeat.i(156396);
    this.IdT = paramax;
    AppMethodBeat.o(156396);
  }
  
  protected final void bU(String paramString, long paramLong)
  {
    AppMethodBeat.i(156392);
    p.h(paramString, "slotKey");
    this.IdT.putLong(paramString, paramLong);
    AppMethodBeat.o(156392);
  }
  
  protected final boolean bV(String paramString, long paramLong)
  {
    AppMethodBeat.i(156393);
    p.h(paramString, "slotKey");
    if (this.IdT.getLong(paramString, 0L) == paramLong)
    {
      AppMethodBeat.o(156393);
      return true;
    }
    AppMethodBeat.o(156393);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ar
 * JD-Core Version:    0.7.0.1
 */