package org.c.d;

import java.io.OutputStream;

public final class a
{
  public final String scope;
  public final String xun;
  public final String xuo;
  public final String xup;
  public final h xur;
  private final OutputStream xus;
  
  public a(String paramString1, String paramString2, String paramString3, h paramh, String paramString4, OutputStream paramOutputStream)
  {
    this.xun = paramString1;
    this.xuo = paramString2;
    this.xup = paramString3;
    this.xur = paramh;
    this.scope = paramString4;
    this.xus = paramOutputStream;
  }
  
  public final void tn(String paramString)
  {
    if (this.xus != null) {
      paramString = paramString + "\n";
    }
    try
    {
      this.xus.write(paramString.getBytes("UTF8"));
      return;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException("there were problems while writting to the debug stream", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.c.d.a
 * JD-Core Version:    0.7.0.1
 */