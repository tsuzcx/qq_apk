package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.protocal.protobuf.cqv;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/loader/LensIconData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "(Lcom/tencent/mm/protocal/protobuf/LensInfo;)V", "getLensInfo", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "isLegal", "", "uniqueValue", "", "plugin-sticker_release"})
public final class a
  implements c
{
  final cqv Vat;
  
  public a(cqv paramcqv)
  {
    AppMethodBeat.i(105912);
    this.Vat = paramcqv;
    AppMethodBeat.o(105912);
  }
  
  public final String aBv()
  {
    String str2 = this.Vat.LensId;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.a
 * JD-Core Version:    0.7.0.1
 */