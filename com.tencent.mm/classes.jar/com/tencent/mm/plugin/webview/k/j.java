package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class j
{
  public HashMap<String, a> QAc;
  
  public j()
  {
    AppMethodBeat.i(82381);
    this.QAc = new HashMap();
    AppMethodBeat.o(82381);
  }
  
  public final a bnm(String paramString)
  {
    AppMethodBeat.i(82383);
    paramString = (a)this.QAc.get(paramString);
    AppMethodBeat.o(82383);
    return paramString;
  }
  
  public static final class a
  {
    public int QAd;
    public int QAe;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.j
 * JD-Core Version:    0.7.0.1
 */