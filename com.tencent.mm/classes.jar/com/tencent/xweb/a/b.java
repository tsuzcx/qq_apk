package com.tencent.xweb.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class b
  implements e
{
  public final OutputStream Lg(String paramString)
  {
    AppMethodBeat.i(183508);
    paramString = new FileOutputStream(paramString);
    AppMethodBeat.o(183508);
    return paramString;
  }
  
  public final InputStream Lh(String paramString)
  {
    AppMethodBeat.i(183507);
    paramString = new FileInputStream(paramString);
    AppMethodBeat.o(183507);
    return paramString;
  }
  
  public final String bub(String paramString)
  {
    AppMethodBeat.i(183505);
    paramString = h.getMD5(paramString);
    AppMethodBeat.o(183505);
    return paramString;
  }
  
  public final boolean copyFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(183506);
    boolean bool = g.copyFile(paramString1, paramString2);
    AppMethodBeat.o(183506);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.a.b
 * JD-Core Version:    0.7.0.1
 */