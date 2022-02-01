package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardFlag;", "", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "RECYCLE_CARD_FLAG_NORMAL", "RECYCLE_CARD_FLAG_DEL", "plugin-biz_release"})
public enum y$a
{
  final int cUP;
  
  static
  {
    AppMethodBeat.i(205860);
    a locala1 = new a("RECYCLE_CARD_FLAG_NORMAL", 0, 1);
    VdI = locala1;
    a locala2 = new a("RECYCLE_CARD_FLAG_DEL", 1, 2);
    VdJ = locala2;
    VdK = new a[] { locala1, locala2 };
    AppMethodBeat.o(205860);
  }
  
  private y$a(int paramInt)
  {
    this.cUP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.y.a
 * JD-Core Version:    0.7.0.1
 */