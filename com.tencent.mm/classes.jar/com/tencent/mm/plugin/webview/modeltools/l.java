package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;

public final class l
{
  public HashMap<String, a> DWv;
  public HashMap<String, a> DWw;
  private HashSet<Integer> DWx;
  public HashMap<String, b> DWy;
  
  public l()
  {
    AppMethodBeat.i(79218);
    this.DWv = new HashMap();
    this.DWw = new HashMap();
    this.DWx = new HashSet();
    this.DWy = new HashMap();
    AppMethodBeat.o(79218);
  }
  
  public final boolean WO(int paramInt)
  {
    AppMethodBeat.i(79222);
    boolean bool = this.DWx.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79222);
    return bool;
  }
  
  public final boolean aHZ(String paramString)
  {
    AppMethodBeat.i(79219);
    if ((this.DWy.containsKey(paramString)) && (this.DWy.get(paramString) != null))
    {
      AppMethodBeat.o(79219);
      return true;
    }
    AppMethodBeat.o(79219);
    return false;
  }
  
  public final b aIa(String paramString)
  {
    AppMethodBeat.i(79220);
    paramString = (b)this.DWy.get(paramString);
    AppMethodBeat.o(79220);
    return paramString;
  }
  
  public final void cD(int paramInt, String paramString)
  {
    AppMethodBeat.i(79221);
    if (bt.getBoolean(paramString, false))
    {
      this.DWx.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(79221);
      return;
    }
    this.DWx.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79221);
  }
  
  public static final class a
  {
    public String desc;
    public String link;
    public String rJX;
    public String title;
  }
  
  public static final class b
  {
    public boolean DWA;
    public boolean DWz;
    public int duration;
    public String fVj;
    public int hzh;
    public int hzk;
    public String hzm;
    public String userName;
    public int videoHeight;
    public int videoWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.l
 * JD-Core Version:    0.7.0.1
 */