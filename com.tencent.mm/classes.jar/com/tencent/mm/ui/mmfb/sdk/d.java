package com.tencent.mm.ui.mmfb.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d
{
  private final String afyM;
  
  static
  {
    AppMethodBeat.i(250205);
    afyI = new d("NONE", 0, null);
    afyJ = new d("ONLY_ME", 1, "only_me");
    afyK = new d("FRIENDS", 2, "friends");
    afyL = new d("EVERYONE", 3, "everyone");
    afyN = new d[] { afyI, afyJ, afyK, afyL };
    AppMethodBeat.o(250205);
  }
  
  private d(String paramString)
  {
    this.afyM = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.d
 * JD-Core Version:    0.7.0.1
 */