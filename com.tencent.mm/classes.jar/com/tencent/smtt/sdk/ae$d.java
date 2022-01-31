package com.tencent.smtt.sdk;

import android.net.http.SslCertificate;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ae$d
  implements com.tencent.smtt.export.external.interfaces.SslError
{
  android.net.http.SslError a;
  
  ae$d(android.net.http.SslError paramSslError)
  {
    this.a = paramSslError;
  }
  
  public boolean addError(int paramInt)
  {
    AppMethodBeat.i(139154);
    boolean bool = this.a.addError(paramInt);
    AppMethodBeat.o(139154);
    return bool;
  }
  
  public SslCertificate getCertificate()
  {
    AppMethodBeat.i(139153);
    SslCertificate localSslCertificate = this.a.getCertificate();
    AppMethodBeat.o(139153);
    return localSslCertificate;
  }
  
  public int getPrimaryError()
  {
    AppMethodBeat.i(139156);
    int i = this.a.getPrimaryError();
    AppMethodBeat.o(139156);
    return i;
  }
  
  public boolean hasError(int paramInt)
  {
    AppMethodBeat.i(139155);
    boolean bool = this.a.hasError(paramInt);
    AppMethodBeat.o(139155);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.ae.d
 * JD-Core Version:    0.7.0.1
 */