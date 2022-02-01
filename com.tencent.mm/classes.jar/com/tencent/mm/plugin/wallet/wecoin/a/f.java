package com.tencent.mm.plugin.wallet.wecoin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  static
  {
    AppMethodBeat.i(315704);
    VtT = new f("present", 0);
    VtU = new f("push", 1);
    VtV = new f[] { VtT, VtU };
    AppMethodBeat.o(315704);
  }
  
  private f() {}
  
  public static f bgs(String paramString)
  {
    AppMethodBeat.i(315697);
    f[] arrayOff = values();
    int j = arrayOff.length;
    int i = 0;
    while (i < j)
    {
      f localf = arrayOff[i];
      if (localf.toString().equals(paramString))
      {
        AppMethodBeat.o(315697);
        return localf;
      }
      i += 1;
    }
    paramString = VtT;
    AppMethodBeat.o(315697);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.a.f
 * JD-Core Version:    0.7.0.1
 */