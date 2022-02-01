package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardFlag;", "", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "RECYCLE_CARD_FLAG_NORMAL", "RECYCLE_CARD_FLAG_DEL", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum aa$a
{
  final int eQp;
  
  static
  {
    AppMethodBeat.i(248765);
    acFf = new a("RECYCLE_CARD_FLAG_NORMAL", 0, 1);
    acFg = new a("RECYCLE_CARD_FLAG_DEL", 1, 2);
    acFh = new a[] { acFf, acFg };
    AppMethodBeat.o(248765);
  }
  
  private aa$a(int paramInt)
  {
    this.eQp = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.aa.a
 * JD-Core Version:    0.7.0.1
 */