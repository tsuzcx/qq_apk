package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_core/utils/MessageType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "TRANSFER", "C2C", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum f
{
  final int value;
  
  static
  {
    AppMethodBeat.i(301433);
    VYa = new f("DEFAULT", 0, 0);
    VYb = new f("TRANSFER", 1, 1);
    VYc = new f("C2C", 2, 2);
    VYd = new f[] { VYa, VYb, VYc };
    AppMethodBeat.o(301433);
  }
  
  private f(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.f
 * JD-Core Version:    0.7.0.1
 */