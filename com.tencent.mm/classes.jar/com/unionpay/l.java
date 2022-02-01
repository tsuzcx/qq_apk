package com.unionpay;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
  implements x
{
  l(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, y paramy)
  {
    AppMethodBeat.i(207276);
    paramString = a.a(this.aisR);
    if (paramy != null) {
      paramy.a(UPPayWapActivity.bU("0", "success", paramString));
    }
    AppMethodBeat.o(207276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.l
 * JD-Core Version:    0.7.0.1
 */