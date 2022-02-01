package com.unionpay.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class a
{
  SSLContext aisK = null;
  Context b;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  static SSLContext pl(Context paramContext)
  {
    AppMethodBeat.i(207345);
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, new TrustManager[] { new b(paramContext) }, null);
      AppMethodBeat.o(207345);
      return localSSLContext;
    }
    catch (Exception paramContext)
    {
      paramContext = new IOException(paramContext.getMessage());
      AppMethodBeat.o(207345);
      throw paramContext;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207354);
    if ((paramObject != null) && (paramObject.getClass().equals(a.class)))
    {
      AppMethodBeat.o(207354);
      return true;
    }
    AppMethodBeat.o(207354);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(207361);
    int i = a.class.hashCode();
    AppMethodBeat.o(207361);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.a.a
 * JD-Core Version:    0.7.0.1
 */