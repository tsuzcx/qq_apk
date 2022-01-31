package org.c.a;

import java.io.OutputStream;
import org.c.b.b;
import org.c.d.h;
import org.c.g.d;

public final class a
{
  public String scope;
  public String xun;
  public String xuo;
  public String xup = "oob";
  public org.c.a.a.a xuq;
  public h xur = h.xuH;
  public OutputStream xus = null;
  
  public static org.c.a.a.a an(Class<? extends org.c.a.a.a> paramClass)
  {
    d.l(paramClass, "Api class cannot be null");
    try
    {
      paramClass = (org.c.a.a.a)paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      throw new b("Error while creating the Api object", paramClass);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.c.a.a
 * JD-Core Version:    0.7.0.1
 */