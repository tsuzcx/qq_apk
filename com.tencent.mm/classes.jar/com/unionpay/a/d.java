package com.unionpay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;
import java.util.HashMap;

public final class d
{
  private int a = 1;
  private String b;
  HashMap c;
  public byte[] d;
  public String e;
  
  public d(String paramString)
  {
    this.b = paramString;
    this.c = null;
    this.d = null;
  }
  
  public final String b()
  {
    if (this.a == 1) {
      return "POST";
    }
    return "GET";
  }
  
  public final URL kkA()
  {
    AppMethodBeat.i(207338);
    try
    {
      URL localURL = new URL(this.b);
      AppMethodBeat.o(207338);
      return localURL;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.a.d
 * JD-Core Version:    0.7.0.1
 */