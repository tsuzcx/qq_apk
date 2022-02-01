package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.HashSet;

public final class l
{
  public HashMap<String, a> CsQ;
  public HashMap<String, a> CsR;
  private HashSet<Integer> CsS;
  public HashMap<String, b> CsT;
  
  public l()
  {
    AppMethodBeat.i(79218);
    this.CsQ = new HashMap();
    this.CsR = new HashMap();
    this.CsS = new HashSet();
    this.CsT = new HashMap();
    AppMethodBeat.o(79218);
  }
  
  public final boolean UY(int paramInt)
  {
    AppMethodBeat.i(79222);
    boolean bool = this.CsS.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79222);
    return bool;
  }
  
  public final boolean aCx(String paramString)
  {
    AppMethodBeat.i(79219);
    if ((this.CsT.containsKey(paramString)) && (this.CsT.get(paramString) != null))
    {
      AppMethodBeat.o(79219);
      return true;
    }
    AppMethodBeat.o(79219);
    return false;
  }
  
  public final b aCy(String paramString)
  {
    AppMethodBeat.i(79220);
    paramString = (b)this.CsT.get(paramString);
    AppMethodBeat.o(79220);
    return paramString;
  }
  
  public final void cx(int paramInt, String paramString)
  {
    AppMethodBeat.i(79221);
    if (bs.getBoolean(paramString, false))
    {
      this.CsS.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(79221);
      return;
    }
    this.CsS.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(79221);
  }
  
  public static final class a
  {
    public String desc;
    public String link;
    public String qYH;
    public String title;
  }
  
  public static final class b
  {
    public boolean CsU;
    public boolean CsV;
    public int duration;
    public String fBV;
    public int hgY;
    public int hhb;
    public String hhd;
    public String userName;
    public int videoHeight;
    public int videoWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.l
 * JD-Core Version:    0.7.0.1
 */