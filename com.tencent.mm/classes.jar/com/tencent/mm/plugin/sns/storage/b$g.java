package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b$g
{
  public String rrk;
  public ArrayList<b.h> rrl;
  
  public b$g(b paramb)
  {
    AppMethodBeat.i(36904);
    this.rrk = "";
    this.rrl = new ArrayList();
    AppMethodBeat.o(36904);
  }
  
  public final String Ea(int paramInt)
  {
    AppMethodBeat.i(36905);
    if ((paramInt >= 0) && (paramInt < this.rrl.size()))
    {
      String str = ((b.h)this.rrl.get(paramInt)).rro;
      AppMethodBeat.o(36905);
      return str;
    }
    AppMethodBeat.o(36905);
    return "";
  }
  
  public final String Eb(int paramInt)
  {
    AppMethodBeat.i(36906);
    if ((paramInt >= 0) && (paramInt < this.rrl.size()))
    {
      String str = ((b.h)this.rrl.get(paramInt)).title;
      AppMethodBeat.o(36906);
      return str;
    }
    AppMethodBeat.o(36906);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b.g
 * JD-Core Version:    0.7.0.1
 */