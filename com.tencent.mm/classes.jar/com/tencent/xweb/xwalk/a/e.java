package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends m
{
  public final String ata(int paramInt)
  {
    AppMethodBeat.i(157180);
    String str = dA(paramInt, "pdfreader.apk");
    AppMethodBeat.o(157180);
    return str;
  }
  
  public final int atb(int paramInt)
  {
    if (paramInt == 1) {
      return 250;
    }
    return 100;
  }
  
  public final String getPluginName()
  {
    return "XFilesPDFReader";
  }
  
  public final String hvg()
  {
    return "com.tencent.xweb.xfiles.pdf.PDFReader";
  }
  
  public final String hvh()
  {
    return "com.tencent.xweb.xfiles.pdf.PDFReaderEnvironment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.e
 * JD-Core Version:    0.7.0.1
 */