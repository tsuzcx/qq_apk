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
  private org.b.d.a CSe;
  private org.b.a.a.b CSf;
  
  public a(org.b.a.a.b paramb, org.b.d.a parama)
  {
    this.CSf = paramb;
    this.CSe = parama;
  }
  
  private void a(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(77293);
    paramc.jH("oauth_timestamp", new org.b.f.d().erM());
    paramc.jH("oauth_nonce", new org.b.f.d().getNonce());
    paramc.jH("oauth_consumer_key", this.CSe.CRz);
    paramc.jH("oauth_signature_method", new org.b.f.a().erL());
    paramc.jH("oauth_version", "1.0");
    if (this.CSe.ery()) {
      paramc.jH("scope", this.CSe.scope);
    }
    paramc.jH("oauth_signature", b(paramc, parami));
    this.CSe.log("appended additional OAuth parameters: " + org.b.g.b.y(paramc.CRI));
    AppMethodBeat.o(77293);
  }
  
  private String b(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(77297);
    this.CSe.log("generating signature...");
    paramc = new org.b.c.c().a(paramc);
    parami = new org.b.f.a().aO(paramc, this.CSe.CRA, parami.xsy);
    this.CSe.log("base string is: ".concat(String.valueOf(paramc)));
    this.CSe.log("signature is: ".concat(String.valueOf(parami)));
    AppMethodBeat.o(77297);
    return parami;
  }
  
  private void b(org.b.d.c paramc)
  {
    AppMethodBeat.i(77298);
    switch (erK()[this.CSe.CRD.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(77298);
      return;
      this.CSe.log("using Http Header signature");
      paramc.addHeader("Authorization", new e().a(paramc));
      AppMethodBeat.o(77298);
      return;
      this.CSe.log("using Querystring signature");
      Iterator localIterator = paramc.CRI.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramc.jI((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public final i a(i parami, k paramk)
  {
    AppMethodBeat.i(77294);
    this.CSe.log("obtaining access token from " + this.CSf.erx());
    org.b.d.c localc = new org.b.d.c(j.CRW, this.CSf.erx());
    localc.jH("oauth_token", parami.token);
    localc.jH("oauth_verifier", paramk.value);
    this.CSe.log("setting token to: " + parami + " and verifier to: " + paramk);
    a(localc, parami);
    b(localc);
    parami = localc.erD();
    parami = new org.b.c.g().azT(parami.getBody());
    AppMethodBeat.o(77294);
    return parami;
  }
  
  public final void a(i parami, org.b.d.c paramc)
  {
    AppMethodBeat.i(77295);
    this.CSe.log("signing request: " + paramc.erB());
    if (("".equals(parami.token)) && ("".equals(parami.xsy))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramc.jH("oauth_token", parami.token);
      }
      this.CSe.log("setting token to: ".concat(String.valueOf(parami)));
      a(paramc, parami);
      b(paramc);
      AppMethodBeat.o(77295);
      return;
    }
  }
  
  public final String b(i parami)
  {
    AppMethodBeat.i(77296);
    parami = this.CSf.b(parami);
    AppMethodBeat.o(77296);
    return parami;
  }
  
  public final i erJ()
  {
    AppMethodBeat.i(77292);
    this.CSe.log("obtaining request token from " + this.CSf.erw());
    Object localObject = new org.b.d.c(j.CRW, this.CSf.erw());
    this.CSe.log("setting oauth_callback to " + this.CSe.CRB);
    ((org.b.d.c)localObject).jH("oauth_callback", this.CSe.CRB);
    a((org.b.d.c)localObject, org.b.d.b.CRH);
    b((org.b.d.c)localObject);
    this.CSe.log("sending request...");
    localObject = ((org.b.d.c)localObject).erD();
    String str = ((org.b.d.g)localObject).getBody();
    this.CSe.log("response status code: " + ((org.b.d.g)localObject).code);
    this.CSe.log("response body: ".concat(String.valueOf(str)));
    localObject = new org.b.c.g().azT(str);
    AppMethodBeat.o(77292);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.b.e.a
 * JD-Core Version:    0.7.0.1
 */