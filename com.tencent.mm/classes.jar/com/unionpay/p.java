package com.unionpay;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class p
  implements x
{
  p(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, y paramy)
  {
    AppMethodBeat.i(207263);
    boolean bool = Boolean.parseBoolean(paramString);
    UPPayWapActivity.a(this.aisR, bool);
    if (paramy != null) {
      paramy.a(UPPayWapActivity.bU("0", "success", null));
    }
    AppMethodBeat.o(207263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.p
 * JD-Core Version:    0.7.0.1
 */