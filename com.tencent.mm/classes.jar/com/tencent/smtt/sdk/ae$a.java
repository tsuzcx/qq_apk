package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

class ae$a
  extends com.tencent.smtt.export.external.interfaces.ClientCertRequest
{
  private android.webkit.ClientCertRequest a;
  
  public ae$a(android.webkit.ClientCertRequest paramClientCertRequest)
  {
    this.a = paramClientCertRequest;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(139141);
    this.a.cancel();
    AppMethodBeat.o(139141);
  }
  
  public String getHost()
  {
    AppMethodBeat.i(139142);
    String str = this.a.getHost();
    AppMethodBeat.o(139142);
    return str;
  }
  
  public String[] getKeyTypes()
  {
    AppMethodBeat.i(139143);
    String[] arrayOfString = this.a.getKeyTypes();
    AppMethodBeat.o(139143);
    return arrayOfString;
  }
  
  public int getPort()
  {
    AppMethodBeat.i(139144);
    int i = this.a.getPort();
    AppMethodBeat.o(139144);
    return i;
  }
  
  public Principal[] getPrincipals()
  {
    AppMethodBeat.i(139145);
    Principal[] arrayOfPrincipal = this.a.getPrincipals();
    AppMethodBeat.o(139145);
    return arrayOfPrincipal;
  }
  
  public void ignore()
  {
    AppMethodBeat.i(139146);
    this.a.ignore();
    AppMethodBeat.o(139146);
  }
  
  public void proceed(PrivateKey paramPrivateKey, X509Certificate[] paramArrayOfX509Certificate)
  {
    AppMethodBeat.i(139147);
    this.a.proceed(paramPrivateKey, paramArrayOfX509Certificate);
    AppMethodBeat.o(139147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.smtt.sdk.ae.a
 * JD-Core Version:    0.7.0.1
 */