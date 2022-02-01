package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.protocal.protobuf.bus;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/loader/LensIconData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "(Lcom/tencent/mm/protocal/protobuf/LensInfo;)V", "getLensInfo", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "isLegal", "", "uniqueValue", "", "plugin-sticker_release"})
public final class a
  implements c
{
  final bus IFR;
  
  public a(bus parambus)
  {
    AppMethodBeat.i(105912);
    this.IFR = parambus;
    AppMethodBeat.o(105912);
  }
  
  public final String aeM()
  {
    String str2 = this.IFR.GwI;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.a
 * JD-Core Version:    0.7.0.1
 */