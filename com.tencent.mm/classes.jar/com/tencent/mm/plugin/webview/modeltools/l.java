package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;

public final class l
{
  public HashMap<String, a> PYe;
  public HashMap<String, a> PYf;
  private HashSet<Integer> PYg;
  public HashMap<String, b> PYh;
  
  public l()
  {
    AppMethodBeat.i(79218);
    this.PYe = new HashMap();
    this.PYf = new HashMap();
    this.PYg = new HashSet();
    this.PYh = new HashMap();
    AppMethodBeat.o(79218);
  }
  
  public final boolean anS(int paramInt)
  {
    AppMethodBeat.i(79222);
    boolean bool = this.PYg.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79222);
    return bool;
  }
  
  public final boolean blq(String paramString)
  {
    AppMethodBeat.i(79219);
    if ((this.PYh.containsKey(paramString)) && (this.PYh.get(paramString) != null))
    {
      AppMethodBeat.o(79219);
      return true;
    }
    AppMethodBeat.o(79219);
    return false;
  }
  
  public final b blr(String paramString)
  {
    AppMethodBeat.i(79220);
    paramString = (b)this.PYh.get(paramString);
    AppMethodBeat.o(79220);
    return paramString;
  }
  
  public final void cW(int paramInt, String paramString)
  {
    AppMethodBeat.i(79221);
    if (Util.getBoolean(paramString, false))
    {
      this.PYg.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(79221);
      return;
    }
    this.PYg.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79221);
  }
  
  public static final class a
  {
    public String desc;
    public String link;
    public String title;
    public String xei;
  }
  
  public static final class b
  {
    public boolean PYi;
    public boolean PYj;
    public int duration;
    public String jmB;
    public int llp;
    public int lls;
    public String userName;
    public String vid;
    public int videoHeight;
    public int videoWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.l
 * JD-Core Version:    0.7.0.1
 */