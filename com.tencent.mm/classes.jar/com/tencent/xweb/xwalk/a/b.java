package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends m
{
  public final String ata(int paramInt)
  {
    AppMethodBeat.i(157173);
    String str = dA(paramInt, "excelreader.apk");
    AppMethodBeat.o(157173);
    return str;
  }
  
  public final int atb(int paramInt)
  {
    if (paramInt == 1) {
      return 238;
    }
    return 100;
  }
  
  public final String getPluginName()
  {
    return "XFilesExcelReader";
  }
  
  public final String hvg()
  {
    return "com.tencent.xweb.xfiles.excel.ExcelReader";
  }
  
  public final String hvh()
  {
    return "com.tencent.xweb.xfiles.excel.ExcelReaderEnvironment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.b
 * JD-Core Version:    0.7.0.1
 */