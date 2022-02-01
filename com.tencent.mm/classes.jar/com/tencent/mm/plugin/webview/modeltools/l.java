package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;

public final class l
{
  public HashMap<String, a> BaD;
  public HashMap<String, a> BaE;
  private HashSet<Integer> BaF;
  public HashMap<String, b> BaG;
  
  public l()
  {
    AppMethodBeat.i(79218);
    this.BaD = new HashMap();
    this.BaE = new HashMap();
    this.BaF = new HashSet();
    this.BaG = new HashMap();
    AppMethodBeat.o(79218);
  }
  
  public final boolean SQ(int paramInt)
  {
    AppMethodBeat.i(79222);
    boolean bool = this.BaF.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79222);
    return bool;
  }
  
  public final boolean axf(String paramString)
  {
    AppMethodBeat.i(79219);
    if ((this.BaG.containsKey(paramString)) && (this.BaG.get(paramString) != null))
    {
      AppMethodBeat.o(79219);
      return true;
    }
    AppMethodBeat.o(79219);
    return false;
  }
  
  public final b axg(String paramString)
  {
    AppMethodBeat.i(79220);
    paramString = (b)this.BaG.get(paramString);
    AppMethodBeat.o(79220);
    return paramString;
  }
  
  public final void cu(int paramInt, String paramString)
  {
    AppMethodBeat.i(79221);
    if (bt.getBoolean(paramString, false))
    {
      this.BaF.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(79221);
      return;
    }
    this.BaF.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79221);
  }
  
  public static final class a
  {
    public String desc;
    public String link;
    public String qpB;
    public String title;
  }
  
  public static final class b
  {
    public boolean BaH;
    public boolean BaI;
    public int duration;
    public String fyo;
    public int gGA;
    public String gGC;
    public int gGx;
    public String userName;
    public int videoHeight;
    public int videoWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.l
 * JD-Core Version:    0.7.0.1
 */