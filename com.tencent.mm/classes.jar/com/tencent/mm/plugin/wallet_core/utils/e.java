package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet_core/utils/MessageType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "TRANSFER", "C2C", "plugin-wxpay_release"})
public enum e
{
  final int value;
  
  static
  {
    AppMethodBeat.i(278140);
    e locale1 = new e("DEFAULT", 0, 0);
    Phn = locale1;
    e locale2 = new e("TRANSFER", 1, 1);
    Pho = locale2;
    e locale3 = new e("C2C", 2, 2);
    Php = locale3;
    Phq = new e[] { locale1, locale2, locale3 };
    AppMethodBeat.o(278140);
  }
  
  private e(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.e
 * JD-Core Version:    0.7.0.1
 */