package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_core/utils/MessageEventType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "ADD", "DELETE", "MODIFY", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum d
{
  final int value;
  
  static
  {
    AppMethodBeat.i(301414);
    VXT = new d("DEFAULT", 0, 0);
    VXU = new d("ADD", 1, 1);
    VXV = new d("DELETE", 2, 2);
    VXW = new d("MODIFY", 3, 3);
    VXX = new d[] { VXT, VXU, VXV, VXW };
    AppMethodBeat.o(301414);
  }
  
  private d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.d
 * JD-Core Version:    0.7.0.1
 */