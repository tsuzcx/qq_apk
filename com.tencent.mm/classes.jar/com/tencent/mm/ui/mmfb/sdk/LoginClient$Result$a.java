package com.tencent.mm.ui.mmfb.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum LoginClient$Result$a
{
  private final String afAb;
  
  static
  {
    AppMethodBeat.i(250242);
    afzY = new a("SUCCESS", 0, "success");
    afzZ = new a("CANCEL", 1, "cancel");
    afAa = new a("ERROR", 2, "error");
    afAc = new a[] { afzY, afzZ, afAa };
    AppMethodBeat.o(250242);
  }
  
  private LoginClient$Result$a(String paramString)
  {
    this.afAb = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.LoginClient.Result.a
 * JD-Core Version:    0.7.0.1
 */