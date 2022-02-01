package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardFlag;", "", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "RECYCLE_CARD_FLAG_NORMAL", "RECYCLE_CARD_FLAG_DEL", "plugin-biz_release"})
public enum y$a
{
  final int cSx;
  
  static
  {
    AppMethodBeat.i(212572);
    a locala1 = new a("RECYCLE_CARD_FLAG_NORMAL", 0, 1);
    NPQ = locala1;
    a locala2 = new a("RECYCLE_CARD_FLAG_DEL", 1, 2);
    NPR = locala2;
    NPS = new a[] { locala1, locala2 };
    AppMethodBeat.o(212572);
  }
  
  private y$a(int paramInt)
  {
    this.cSx = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.y.a
 * JD-Core Version:    0.7.0.1
 */