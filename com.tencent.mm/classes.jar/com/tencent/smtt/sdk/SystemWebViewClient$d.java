package com.tencent.smtt.sdk;

import android.net.http.SslCertificate;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SystemWebViewClient$d
  implements com.tencent.smtt.export.external.interfaces.SslError
{
  android.net.http.SslError a;
  
  SystemWebViewClient$d(android.net.http.SslError paramSslError)
  {
    this.a = paramSslError;
  }
  
  public boolean addError(int paramInt)
  {
    AppMethodBeat.i(55182);
    boolean bool = this.a.addError(paramInt);
    AppMethodBeat.o(55182);
    return bool;
  }
  
  public SslCertificate getCertificate()
  {
    AppMethodBeat.i(55181);
    SslCertificate localSslCertificate = this.a.getCertificate();
    AppMethodBeat.o(55181);
    return localSslCertificate;
  }
  
  public int getPrimaryError()
  {
    AppMethodBeat.i(55184);
    int i = this.a.getPrimaryError();
    AppMethodBeat.o(55184);
    return i;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(55185);
    String str = this.a.getUrl();
    AppMethodBeat.o(55185);
    return str;
  }
  
  public boolean hasError(int paramInt)
  {
    AppMethodBeat.i(55183);
    boolean bool = this.a.hasError(paramInt);
    AppMethodBeat.o(55183);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.d
 * JD-Core Version:    0.7.0.1
 */