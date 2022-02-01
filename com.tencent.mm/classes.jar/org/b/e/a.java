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
  private org.b.d.a ajYV;
  private org.b.a.a.b ajYW;
  
  public a(org.b.a.a.b paramb, org.b.d.a parama)
  {
    this.ajYW = paramb;
    this.ajYV = parama;
  }
  
  private void a(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40562);
    paramc.rK("oauth_timestamp", new org.b.f.d().kJV());
    paramc.rK("oauth_nonce", new org.b.f.d().kJW());
    paramc.rK("oauth_consumer_key", this.ajYV.ajYp);
    paramc.rK("oauth_signature_method", new org.b.f.a().kJU());
    paramc.rK("oauth_version", "1.0");
    if (this.ajYV.kJH()) {
      paramc.rK("scope", this.ajYV.scope);
    }
    paramc.rK("oauth_signature", b(paramc, parami));
    this.ajYV.log("appended additional OAuth parameters: " + org.b.g.b.M(paramc.ajYy));
    AppMethodBeat.o(40562);
  }
  
  private String b(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40566);
    this.ajYV.log("generating signature...");
    paramc = new org.b.c.c().a(paramc);
    parami = new org.b.f.a().cb(paramc, this.ajYV.ajYq, parami.aaTQ);
    this.ajYV.log("base string is: ".concat(String.valueOf(paramc)));
    this.ajYV.log("signature is: ".concat(String.valueOf(parami)));
    AppMethodBeat.o(40566);
    return parami;
  }
  
  private void b(org.b.d.c paramc)
  {
    AppMethodBeat.i(40567);
    switch (kJT()[this.ajYV.ajYt.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40567);
      return;
      this.ajYV.log("using Http Header signature");
      paramc.rM("Authorization", new e().a(paramc));
      AppMethodBeat.o(40567);
      return;
      this.ajYV.log("using Querystring signature");
      Iterator localIterator = paramc.ajYy.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramc.rL((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public final i a(i parami, k paramk)
  {
    AppMethodBeat.i(40563);
    this.ajYV.log("obtaining access token from " + this.ajYW.kJG());
    org.b.d.c localc = new org.b.d.c(j.ajYN, this.ajYW.kJG());
    localc.rK("oauth_token", parami.token);
    localc.rK("oauth_verifier", paramk.value);
    this.ajYV.log("setting token to: " + parami + " and verifier to: " + paramk);
    a(localc, parami);
    b(localc);
    parami = localc.kJM();
    parami = new org.b.c.g().bLx(parami.getBody());
    AppMethodBeat.o(40563);
    return parami;
  }
  
  public final void a(i parami, org.b.d.c paramc)
  {
    AppMethodBeat.i(40564);
    this.ajYV.log("signing request: " + paramc.kJK());
    if (("".equals(parami.token)) && ("".equals(parami.aaTQ))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramc.rK("oauth_token", parami.token);
      }
      this.ajYV.log("setting token to: ".concat(String.valueOf(parami)));
      a(paramc, parami);
      b(paramc);
      AppMethodBeat.o(40564);
      return;
    }
  }
  
  public final String b(i parami)
  {
    AppMethodBeat.i(40565);
    parami = this.ajYW.b(parami);
    AppMethodBeat.o(40565);
    return parami;
  }
  
  public final i kJS()
  {
    AppMethodBeat.i(40561);
    this.ajYV.log("obtaining request token from " + this.ajYW.kJF());
    Object localObject = new org.b.d.c(j.ajYN, this.ajYW.kJF());
    this.ajYV.log("setting oauth_callback to " + this.ajYV.ajYr);
    ((org.b.d.c)localObject).rK("oauth_callback", this.ajYV.ajYr);
    a((org.b.d.c)localObject, org.b.d.b.ajYx);
    b((org.b.d.c)localObject);
    this.ajYV.log("sending request...");
    localObject = ((org.b.d.c)localObject).kJM();
    String str = ((org.b.d.g)localObject).getBody();
    this.ajYV.log("response status code: " + ((org.b.d.g)localObject).code);
    this.ajYV.log("response body: ".concat(String.valueOf(str)));
    localObject = new org.b.c.g().bLx(str);
    AppMethodBeat.o(40561);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.b.e.a
 * JD-Core Version:    0.7.0.1
 */