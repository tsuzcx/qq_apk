package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet_core/utils/MessageEventType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "ADD", "DELETE", "MODIFY", "plugin-wxpay_release"})
public enum c
{
  final int value;
  
  static
  {
    AppMethodBeat.i(274970);
    c localc1 = new c("DEFAULT", 0, 0);
    Phg = localc1;
    c localc2 = new c("ADD", 1, 1);
    Phh = localc2;
    c localc3 = new c("DELETE", 2, 2);
    Phi = localc3;
    c localc4 = new c("MODIFY", 3, 3);
    Phj = localc4;
    Phk = new c[] { localc1, localc2, localc3, localc4 };
    AppMethodBeat.o(274970);
  }
  
  private c(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.c
 * JD-Core Version:    0.7.0.1
 */