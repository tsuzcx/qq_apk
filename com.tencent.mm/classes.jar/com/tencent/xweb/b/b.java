package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.d;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class b
  implements e
{
  public final String aEN(String paramString)
  {
    AppMethodBeat.i(183505);
    paramString = d.getMD5(paramString);
    AppMethodBeat.o(183505);
    return paramString;
  }
  
  public final boolean kP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(183506);
    boolean bool = c.kP(paramString1, paramString2);
    AppMethodBeat.o(183506);
    return bool;
  }
  
  public final InputStream openRead(String paramString)
  {
    AppMethodBeat.i(183507);
    paramString = new FileInputStream(paramString);
    AppMethodBeat.o(183507);
    return paramString;
  }
  
  public final OutputStream vu(String paramString)
  {
    AppMethodBeat.i(183508);
    paramString = new FileOutputStream(paramString);
    AppMethodBeat.o(183508);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.b.b
 * JD-Core Version:    0.7.0.1
 */