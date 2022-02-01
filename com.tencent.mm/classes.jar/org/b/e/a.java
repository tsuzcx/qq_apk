package org.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.b.c.e;
import org.b.c.f;
import org.b.d.i;
import org.b.d.j;
import org.b.d.k;

public final class a
  implements b
{
  private org.b.d.a NWE;
  private org.b.a.a.b NWF;
  
  public a(org.b.a.a.b paramb, org.b.d.a parama)
  {
    this.NWF = paramb;
    this.NWE = parama;
  }
  
  private void a(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40562);
    paramc.nM("oauth_timestamp", new org.b.f.d().gyI());
    paramc.nM("oauth_nonce", new org.b.f.d().getNonce());
    paramc.nM("oauth_consumer_key", this.NWE.NVZ);
    paramc.nM("oauth_signature_method", new org.b.f.a().gyH());
    paramc.nM("oauth_version", "1.0");
    if (this.NWE.gyu()) {
      paramc.nM("scope", this.NWE.scope);
    }
    paramc.nM("oauth_signature", b(paramc, parami));
    this.NWE.log("appended additional OAuth parameters: " + org.b.g.b.C(paramc.NWi));
    AppMethodBeat.o(40562);
  }
  
  private String b(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40566);
    this.NWE.log("generating signature...");
    paramc = new org.b.c.c().a(paramc);
    parami = new org.b.f.a().bt(paramc, this.NWE.NWa, parami.GTp);
    this.NWE.log("base string is: ".concat(String.valueOf(paramc)));
    this.NWE.log("signature is: ".concat(String.valueOf(parami)));
    AppMethodBeat.o(40566);
    return parami;
  }
  
  private void b(org.b.d.c paramc)
  {
    AppMethodBeat.i(40567);
    switch (gyG()[this.NWE.NWd.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40567);
      return;
      this.NWE.log("using Http Header signature");
      paramc.addHeader("Authorization", new e().a(paramc));
      AppMethodBeat.o(40567);
      return;
      this.NWE.log("using Querystring signature");
      Iterator localIterator = paramc.NWi.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramc.nN((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public final i a(i parami, k paramk)
  {
    AppMethodBeat.i(40563);
    this.NWE.log("obtaining access token from " + this.NWF.gyt());
    org.b.d.c localc = new org.b.d.c(j.NWw, this.NWF.gyt());
    localc.nM("oauth_token", parami.token);
    localc.nM("oauth_verifier", paramk.value);
    this.NWE.log("setting token to: " + parami + " and verifier to: " + paramk);
    a(localc, parami);
    b(localc);
    parami = localc.gyz();
    parami = new org.b.c.g().bea(parami.getBody());
    AppMethodBeat.o(40563);
    return parami;
  }
  
  public final void a(i parami, org.b.d.c paramc)
  {
    AppMethodBeat.i(40564);
    this.NWE.log("signing request: " + paramc.gyx());
    if (("".equals(parami.token)) && ("".equals(parami.GTp))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramc.nM("oauth_token", parami.token);
      }
      this.NWE.log("setting token to: ".concat(String.valueOf(parami)));
      a(paramc, parami);
      b(paramc);
      AppMethodBeat.o(40564);
      return;
    }
  }
  
  public final String b(i parami)
  {
    AppMethodBeat.i(40565);
    parami = this.NWF.b(parami);
    AppMethodBeat.o(40565);
    return parami;
  }
  
  public final i gyF()
  {
    AppMethodBeat.i(40561);
    this.NWE.log("obtaining request token from " + this.NWF.gys());
    Object localObject = new org.b.d.c(j.NWw, this.NWF.gys());
    this.NWE.log("setting oauth_callback to " + this.NWE.NWb);
    ((org.b.d.c)localObject).nM("oauth_callback", this.NWE.NWb);
    a((org.b.d.c)localObject, org.b.d.b.NWh);
    b((org.b.d.c)localObject);
    this.NWE.log("sending request...");
    localObject = ((org.b.d.c)localObject).gyz();
    String str = ((org.b.d.g)localObject).getBody();
    this.NWE.log("response status code: " + ((org.b.d.g)localObject).code);
    this.NWE.log("response body: ".concat(String.valueOf(str)));
    localObject = new org.b.c.g().bea(str);
    AppMethodBeat.o(40561);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.b.e.a
 * JD-Core Version:    0.7.0.1
 */