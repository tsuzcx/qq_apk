package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.HashSet;

public final class l
{
  public HashMap<String, a> Eou;
  public HashMap<String, a> Eov;
  private HashSet<Integer> Eow;
  public HashMap<String, b> Eox;
  
  public l()
  {
    AppMethodBeat.i(79218);
    this.Eou = new HashMap();
    this.Eov = new HashMap();
    this.Eow = new HashSet();
    this.Eox = new HashMap();
    AppMethodBeat.o(79218);
  }
  
  public final boolean Xv(int paramInt)
  {
    AppMethodBeat.i(79222);
    boolean bool = this.Eow.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79222);
    return bool;
  }
  
  public final boolean aJs(String paramString)
  {
    AppMethodBeat.i(79219);
    if ((this.Eox.containsKey(paramString)) && (this.Eox.get(paramString) != null))
    {
      AppMethodBeat.o(79219);
      return true;
    }
    AppMethodBeat.o(79219);
    return false;
  }
  
  public final b aJt(String paramString)
  {
    AppMethodBeat.i(79220);
    paramString = (b)this.Eox.get(paramString);
    AppMethodBeat.o(79220);
    return paramString;
  }
  
  public final void cD(int paramInt, String paramString)
  {
    AppMethodBeat.i(79221);
    if (bu.getBoolean(paramString, false))
    {
      this.Eow.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(79221);
      return;
    }
    this.Eow.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79221);
  }
  
  public static final class a
  {
    public String desc;
    public String link;
    public String rSl;
    public String title;
  }
  
  public static final class b
  {
    public boolean Eoy;
    public boolean Eoz;
    public int duration;
    public String fXp;
    public int hBV;
    public int hBY;
    public String hCa;
    public String userName;
    public int videoHeight;
    public int videoWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.l
 * JD-Core Version:    0.7.0.1
 */