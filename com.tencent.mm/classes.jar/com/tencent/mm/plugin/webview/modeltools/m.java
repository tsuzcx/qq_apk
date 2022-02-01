package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;

public final class m
{
  public HashMap<String, a> WOD;
  public HashMap<String, a> WOE;
  private HashSet<Integer> WOF;
  public HashMap<String, b> WOG;
  
  public m()
  {
    AppMethodBeat.i(79218);
    this.WOD = new HashMap();
    this.WOE = new HashMap();
    this.WOF = new HashSet();
    this.WOG = new HashMap();
    AppMethodBeat.o(79218);
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(295818);
    this.WOD.put(paramString, parama);
    AppMethodBeat.o(295818);
  }
  
  public final boolean atL(int paramInt)
  {
    AppMethodBeat.i(79222);
    boolean bool = this.WOF.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79222);
    return bool;
  }
  
  public final void b(String paramString, a parama)
  {
    AppMethodBeat.i(295822);
    this.WOE.put(paramString, parama);
    AppMethodBeat.o(295822);
  }
  
  public final boolean bkV(String paramString)
  {
    AppMethodBeat.i(79219);
    if ((this.WOG.containsKey(paramString)) && (this.WOG.get(paramString) != null))
    {
      AppMethodBeat.o(79219);
      return true;
    }
    AppMethodBeat.o(79219);
    return false;
  }
  
  public final a bkW(String paramString)
  {
    AppMethodBeat.i(295827);
    paramString = (a)this.WOD.get(paramString);
    AppMethodBeat.o(295827);
    return paramString;
  }
  
  public final a bkX(String paramString)
  {
    AppMethodBeat.i(295833);
    paramString = (a)this.WOE.get(paramString);
    AppMethodBeat.o(295833);
    return paramString;
  }
  
  public final b bkY(String paramString)
  {
    AppMethodBeat.i(79220);
    paramString = (b)this.WOG.get(paramString);
    AppMethodBeat.o(79220);
    return paramString;
  }
  
  public final void dL(int paramInt, String paramString)
  {
    AppMethodBeat.i(79221);
    if (Util.getBoolean(paramString, false))
    {
      this.WOF.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(79221);
      return;
    }
    this.WOF.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79221);
  }
  
  public static final class a
  {
    public String ADt;
    public String desc;
    public String link;
    public String title;
  }
  
  public static final class b
  {
    public boolean WOH;
    public boolean WOI;
    public boolean WOJ;
    public String displayName;
    public int duration;
    public int nQm;
    public int nQp;
    public String userName;
    public String vid;
    public int videoHeight;
    public int videoWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.m
 * JD-Core Version:    0.7.0.1
 */