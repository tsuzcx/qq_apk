package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_core/utils/SenderType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "SENDER", "RECEIVER", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum h
{
  final int value;
  
  static
  {
    AppMethodBeat.i(301423);
    VYe = new h("DEFAULT", 0, 0);
    VYf = new h("SENDER", 1, 1);
    VYg = new h("RECEIVER", 2, 2);
    VYh = new h[] { VYe, VYf, VYg };
    AppMethodBeat.o(301423);
  }
  
  private h(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.h
 * JD-Core Version:    0.7.0.1
 */