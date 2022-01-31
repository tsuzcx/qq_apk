package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public class gq
  extends gb<String>
{
  private final gd.b<String> a;
  
  public gq(int paramInt, String paramString, gd.b<String> paramb, gd.a parama)
  {
    super(paramInt, paramString, parama);
    this.a = paramb;
  }
  
  public gq(String paramString, gd.b<String> paramb, gd.a parama)
  {
    this(0, paramString, paramb, parama);
  }
  
  protected gd<String> a(fz paramfz)
  {
    AppMethodBeat.i(148022);
    try
    {
      String str = new String(paramfz.b, gm.a(paramfz.c));
      paramfz = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramfz = new String(paramfz.b);
      }
    }
    paramfz = gd.a(paramfz);
    AppMethodBeat.o(148022);
    return paramfz;
  }
  
  protected void c(String paramString)
  {
    AppMethodBeat.i(148021);
    this.a.a(paramString);
    AppMethodBeat.o(148021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gq
 * JD-Core Version:    0.7.0.1
 */