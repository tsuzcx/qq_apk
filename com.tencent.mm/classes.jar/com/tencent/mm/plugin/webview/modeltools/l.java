package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;

public final class l
{
  private HashSet<Integer> JbA;
  public HashMap<String, b> JbB;
  public HashMap<String, a> Jby;
  public HashMap<String, a> Jbz;
  
  public l()
  {
    AppMethodBeat.i(79218);
    this.Jby = new HashMap();
    this.Jbz = new HashMap();
    this.JbA = new HashSet();
    this.JbB = new HashMap();
    AppMethodBeat.o(79218);
  }
  
  public final boolean aZx(String paramString)
  {
    AppMethodBeat.i(79219);
    if ((this.JbB.containsKey(paramString)) && (this.JbB.get(paramString) != null))
    {
      AppMethodBeat.o(79219);
      return true;
    }
    AppMethodBeat.o(79219);
    return false;
  }
  
  public final b aZy(String paramString)
  {
    AppMethodBeat.i(79220);
    paramString = (b)this.JbB.get(paramString);
    AppMethodBeat.o(79220);
    return paramString;
  }
  
  public final boolean agd(int paramInt)
  {
    AppMethodBeat.i(79222);
    boolean bool = this.JbA.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79222);
    return bool;
  }
  
  public final void cW(int paramInt, String paramString)
  {
    AppMethodBeat.i(79221);
    if (Util.getBoolean(paramString, false))
    {
      this.JbA.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(79221);
      return;
    }
    this.JbA.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79221);
  }
  
  public static final class a
  {
    public String desc;
    public String link;
    public String title;
    public String twt;
  }
  
  public static final class b
  {
    public boolean JbC;
    public boolean JbD;
    public int duration;
    public String gCv;
    public int iwc;
    public int iwf;
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