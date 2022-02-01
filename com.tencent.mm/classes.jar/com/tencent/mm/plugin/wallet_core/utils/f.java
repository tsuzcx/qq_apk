package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet_core/utils/SenderType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "SENDER", "RECEIVER", "plugin-wxpay_release"})
public enum f
{
  final int value;
  
  static
  {
    AppMethodBeat.i(204897);
    f localf1 = new f("DEFAULT", 0, 0);
    Phr = localf1;
    f localf2 = new f("SENDER", 1, 1);
    Phs = localf2;
    f localf3 = new f("RECEIVER", 2, 2);
    Pht = localf3;
    Phu = new f[] { localf1, localf2, localf3 };
    AppMethodBeat.o(204897);
  }
  
  private f(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.f
 * JD-Core Version:    0.7.0.1
 */