package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;

public final class l
{
  public HashMap<String, a> uYx;
  public HashMap<String, a> uYy;
  private HashSet<Integer> uYz;
  
  public l()
  {
    AppMethodBeat.i(7031);
    this.uYx = new HashMap();
    this.uYy = new HashMap();
    this.uYz = new HashSet();
    AppMethodBeat.o(7031);
  }
  
  public final boolean JX(int paramInt)
  {
    AppMethodBeat.i(7033);
    boolean bool = this.uYz.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(7033);
    return bool;
  }
  
  public final void bE(int paramInt, String paramString)
  {
    AppMethodBeat.i(7032);
    if (bo.getBoolean(paramString, false))
    {
      this.uYz.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(7032);
      return;
    }
    this.uYz.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(7032);
  }
  
  public static final class a
  {
    public String desc;
    public String link;
    public String rGa;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.l
 * JD-Core Version:    0.7.0.1
 */