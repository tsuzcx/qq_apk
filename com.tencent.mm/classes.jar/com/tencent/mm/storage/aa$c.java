package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "RECYCLE_CARD_STATUS_CARD_EXPOSURE", "RECYCLE_CARD_STATUS_DIGEST_EXPOSURE", "RECYCLE_CARD_STATUS_NEWEST_CARD", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum aa$c
{
  final int status;
  
  static
  {
    AppMethodBeat.i(248743);
    acFn = new c("RECYCLE_CARD_STATUS_CARD_EXPOSURE", 0, 1);
    acFo = new c("RECYCLE_CARD_STATUS_DIGEST_EXPOSURE", 1, 2);
    acFp = new c("RECYCLE_CARD_STATUS_NEWEST_CARD", 2, 3);
    acFq = new c[] { acFn, acFo, acFp };
    AppMethodBeat.o(248743);
  }
  
  private aa$c(int paramInt)
  {
    this.status = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.aa.c
 * JD-Core Version:    0.7.0.1
 */