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
  private org.b.d.a KnT;
  private org.b.a.a.b KnU;
  
  public a(org.b.a.a.b paramb, org.b.d.a parama)
  {
    this.KnU = paramb;
    this.KnT = parama;
  }
  
  private void a(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40562);
    paramc.mN("oauth_timestamp", new org.b.f.d().fNo());
    paramc.mN("oauth_nonce", new org.b.f.d().getNonce());
    paramc.mN("oauth_consumer_key", this.KnT.Kno);
    paramc.mN("oauth_signature_method", new org.b.f.a().fNn());
    paramc.mN("oauth_version", "1.0");
    if (this.KnT.fNa()) {
      paramc.mN("scope", this.KnT.scope);
    }
    paramc.mN("oauth_signature", b(paramc, parami));
    this.KnT.log("appended additional OAuth parameters: " + org.b.g.b.D(paramc.Knx));
    AppMethodBeat.o(40562);
  }
  
  private String b(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40566);
    this.KnT.log("generating signature...");
    paramc = new org.b.c.c().a(paramc);
    parami = new org.b.f.a().bf(paramc, this.KnT.Knp, parami.DNx);
    this.KnT.log("base string is: ".concat(String.valueOf(paramc)));
    this.KnT.log("signature is: ".concat(String.valueOf(parami)));
    AppMethodBeat.o(40566);
    return parami;
  }
  
  private void b(org.b.d.c paramc)
  {
    AppMethodBeat.i(40567);
    switch (fNm()[this.KnT.Kns.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40567);
      return;
      this.KnT.log("using Http Header signature");
      paramc.addHeader("Authorization", new e().a(paramc));
      AppMethodBeat.o(40567);
      return;
      this.KnT.log("using Querystring signature");
      Iterator localIterator = paramc.Knx.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramc.mO((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public final i a(i parami, k paramk)
  {
    AppMethodBeat.i(40563);
    this.KnT.log("obtaining access token from " + this.KnU.fMZ());
    org.b.d.c localc = new org.b.d.c(j.KnL, this.KnU.fMZ());
    localc.mN("oauth_token", parami.token);
    localc.mN("oauth_verifier", paramk.value);
    this.KnT.log("setting token to: " + parami + " and verifier to: " + paramk);
    a(localc, parami);
    b(localc);
    parami = localc.fNf();
    parami = new org.b.c.g().aRE(parami.getBody());
    AppMethodBeat.o(40563);
    return parami;
  }
  
  public final void a(i parami, org.b.d.c paramc)
  {
    AppMethodBeat.i(40564);
    this.KnT.log("signing request: " + paramc.fNd());
    if (("".equals(parami.token)) && ("".equals(parami.DNx))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramc.mN("oauth_token", parami.token);
      }
      this.KnT.log("setting token to: ".concat(String.valueOf(parami)));
      a(paramc, parami);
      b(paramc);
      AppMethodBeat.o(40564);
      return;
    }
  }
  
  public final String b(i parami)
  {
    AppMethodBeat.i(40565);
    parami = this.KnU.b(parami);
    AppMethodBeat.o(40565);
    return parami;
  }
  
  public final i fNl()
  {
    AppMethodBeat.i(40561);
    this.KnT.log("obtaining request token from " + this.KnU.fMY());
    Object localObject = new org.b.d.c(j.KnL, this.KnU.fMY());
    this.KnT.log("setting oauth_callback to " + this.KnT.Knq);
    ((org.b.d.c)localObject).mN("oauth_callback", this.KnT.Knq);
    a((org.b.d.c)localObject, org.b.d.b.Knw);
    b((org.b.d.c)localObject);
    this.KnT.log("sending request...");
    localObject = ((org.b.d.c)localObject).fNf();
    String str = ((org.b.d.g)localObject).getBody();
    this.KnT.log("response status code: " + ((org.b.d.g)localObject).code);
    this.KnT.log("response body: ".concat(String.valueOf(str)));
    localObject = new org.b.c.g().aRE(str);
    AppMethodBeat.o(40561);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.b.e.a
 * JD-Core Version:    0.7.0.1
 */