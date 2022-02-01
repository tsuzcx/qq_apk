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
  private org.b.d.a OtJ;
  private org.b.a.a.b OtK;
  
  public a(org.b.a.a.b paramb, org.b.d.a parama)
  {
    this.OtK = paramb;
    this.OtJ = parama;
  }
  
  private void a(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40562);
    paramc.nS("oauth_timestamp", new org.b.f.d().gDk());
    paramc.nS("oauth_nonce", new org.b.f.d().getNonce());
    paramc.nS("oauth_consumer_key", this.OtJ.Ote);
    paramc.nS("oauth_signature_method", new org.b.f.a().gDj());
    paramc.nS("oauth_version", "1.0");
    if (this.OtJ.gCW()) {
      paramc.nS("scope", this.OtJ.scope);
    }
    paramc.nS("oauth_signature", b(paramc, parami));
    this.OtJ.log("appended additional OAuth parameters: " + org.b.g.b.J(paramc.Otn));
    AppMethodBeat.o(40562);
  }
  
  private String b(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40566);
    this.OtJ.log("generating signature...");
    paramc = new org.b.c.c().a(paramc);
    parami = new org.b.f.a().bv(paramc, this.OtJ.Otf, parami.HmQ);
    this.OtJ.log("base string is: ".concat(String.valueOf(paramc)));
    this.OtJ.log("signature is: ".concat(String.valueOf(parami)));
    AppMethodBeat.o(40566);
    return parami;
  }
  
  private void b(org.b.d.c paramc)
  {
    AppMethodBeat.i(40567);
    switch (gDi()[this.OtJ.Oti.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40567);
      return;
      this.OtJ.log("using Http Header signature");
      paramc.addHeader("Authorization", new e().a(paramc));
      AppMethodBeat.o(40567);
      return;
      this.OtJ.log("using Querystring signature");
      Iterator localIterator = paramc.Otn.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramc.nT((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public final i a(i parami, k paramk)
  {
    AppMethodBeat.i(40563);
    this.OtJ.log("obtaining access token from " + this.OtK.gCV());
    org.b.d.c localc = new org.b.d.c(j.OtB, this.OtK.gCV());
    localc.nS("oauth_token", parami.token);
    localc.nS("oauth_verifier", paramk.value);
    this.OtJ.log("setting token to: " + parami + " and verifier to: " + paramk);
    a(localc, parami);
    b(localc);
    parami = localc.gDb();
    parami = new org.b.c.g().bfE(parami.getBody());
    AppMethodBeat.o(40563);
    return parami;
  }
  
  public final void a(i parami, org.b.d.c paramc)
  {
    AppMethodBeat.i(40564);
    this.OtJ.log("signing request: " + paramc.gCZ());
    if (("".equals(parami.token)) && ("".equals(parami.HmQ))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramc.nS("oauth_token", parami.token);
      }
      this.OtJ.log("setting token to: ".concat(String.valueOf(parami)));
      a(paramc, parami);
      b(paramc);
      AppMethodBeat.o(40564);
      return;
    }
  }
  
  public final String b(i parami)
  {
    AppMethodBeat.i(40565);
    parami = this.OtK.b(parami);
    AppMethodBeat.o(40565);
    return parami;
  }
  
  public final i gDh()
  {
    AppMethodBeat.i(40561);
    this.OtJ.log("obtaining request token from " + this.OtK.gCU());
    Object localObject = new org.b.d.c(j.OtB, this.OtK.gCU());
    this.OtJ.log("setting oauth_callback to " + this.OtJ.Otg);
    ((org.b.d.c)localObject).nS("oauth_callback", this.OtJ.Otg);
    a((org.b.d.c)localObject, org.b.d.b.Otm);
    b((org.b.d.c)localObject);
    this.OtJ.log("sending request...");
    localObject = ((org.b.d.c)localObject).gDb();
    String str = ((org.b.d.g)localObject).getBody();
    this.OtJ.log("response status code: " + ((org.b.d.g)localObject).code);
    this.OtJ.log("response body: ".concat(String.valueOf(str)));
    localObject = new org.b.c.g().bfE(str);
    AppMethodBeat.o(40561);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.b.e.a
 * JD-Core Version:    0.7.0.1
 */