package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dhp;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/LensItem;", "", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "reportPos", "", "lensType", "(Lcom/tencent/mm/protocal/protobuf/LensInfo;II)V", "getLensInfo", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getLensType", "()I", "setLensType", "(I)V", "getReportPos", "setReportPos", "Companion", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a acBN;
  public final dhp acBO;
  public int acBP;
  public int mjy;
  
  static
  {
    AppMethodBeat.i(233909);
    acBN = new c.a((byte)0);
    AppMethodBeat.o(233909);
  }
  
  public c(dhp paramdhp, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233905);
    this.acBO = paramdhp;
    this.mjy = paramInt1;
    this.acBP = paramInt2;
    AppMethodBeat.o(233905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sticker.c
 * JD-Core Version:    0.7.0.1
 */