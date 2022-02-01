package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends l
{
  public final String ajr(int paramInt)
  {
    AppMethodBeat.i(157180);
    String str = dd(paramInt, "pdfreader.apk");
    AppMethodBeat.o(157180);
    return str;
  }
  
  public final int ajs(int paramInt)
  {
    if (paramInt == 1) {
      return 214;
    }
    return 100;
  }
  
  public final String getPluginName()
  {
    return "XFilesPDFReader";
  }
  
  public final String ghI()
  {
    return "com.tencent.xweb.xfiles.pdf.PDFReader";
  }
  
  public final String ghJ()
  {
    return "com.tencent.xweb.xfiles.pdf.PDFReaderEnvironment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.d
 * JD-Core Version:    0.7.0.1
 */