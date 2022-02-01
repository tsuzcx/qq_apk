package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.c;
import com.tencent.mm.protocal.protobuf.dhp;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/loader/LensIconData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "(Lcom/tencent/mm/protocal/protobuf/LensInfo;)V", "getLensInfo", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "isLegal", "", "uniqueValue", "", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  final dhp acBO;
  
  public a(dhp paramdhp)
  {
    AppMethodBeat.i(105912);
    this.acBO = paramdhp;
    AppMethodBeat.o(105912);
  }
  
  public final String aUt()
  {
    String str2 = this.acBO.LensId;
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