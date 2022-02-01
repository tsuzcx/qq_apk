package com.unionpay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.unionpay.utils.UPUtils;

final class n
  implements x
{
  n(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, y paramy)
  {
    AppMethodBeat.i(207259);
    paramString = UPUtils.a(this.aisR, paramString);
    if (paramy != null) {
      paramy.a(UPPayWapActivity.bU("0", "success", paramString));
    }
    AppMethodBeat.o(207259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.n
 * JD-Core Version:    0.7.0.1
 */