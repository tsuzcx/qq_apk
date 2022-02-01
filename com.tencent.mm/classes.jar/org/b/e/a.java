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
  private org.b.d.a abMb;
  private org.b.a.a.b abMc;
  
  public a(org.b.a.a.b paramb, org.b.d.a parama)
  {
    this.abMc = paramb;
    this.abMb = parama;
  }
  
  private void a(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40562);
    paramc.pG("oauth_timestamp", new org.b.f.d().iVx());
    paramc.pG("oauth_nonce", new org.b.f.d().iVy());
    paramc.pG("oauth_consumer_key", this.abMb.abLw);
    paramc.pG("oauth_signature_method", new org.b.f.a().iVw());
    paramc.pG("oauth_version", "1.0");
    if (this.abMb.iVj()) {
      paramc.pG("scope", this.abMb.scope);
    }
    paramc.pG("oauth_signature", b(paramc, parami));
    this.abMb.log("appended additional OAuth parameters: " + org.b.g.b.F(paramc.abLF));
    AppMethodBeat.o(40562);
  }
  
  private String b(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40566);
    this.abMb.log("generating signature...");
    paramc = new org.b.c.c().a(paramc);
    parami = new org.b.f.a().bC(paramc, this.abMb.abLx, parami.TEk);
    this.abMb.log("base string is: ".concat(String.valueOf(paramc)));
    this.abMb.log("signature is: ".concat(String.valueOf(parami)));
    AppMethodBeat.o(40566);
    return parami;
  }
  
  private void b(org.b.d.c paramc)
  {
    AppMethodBeat.i(40567);
    switch (iVv()[this.abMb.abLA.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40567);
      return;
      this.abMb.log("using Http Header signature");
      paramc.pI("Authorization", new e().a(paramc));
      AppMethodBeat.o(40567);
      return;
      this.abMb.log("using Querystring signature");
      Iterator localIterator = paramc.abLF.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramc.pH((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public final i a(i parami, k paramk)
  {
    AppMethodBeat.i(40563);
    this.abMb.log("obtaining access token from " + this.abMc.iVi());
    org.b.d.c localc = new org.b.d.c(j.abLT, this.abMc.iVi());
    localc.pG("oauth_token", parami.token);
    localc.pG("oauth_verifier", paramk.value);
    this.abMb.log("setting token to: " + parami + " and verifier to: " + paramk);
    a(localc, parami);
    b(localc);
    parami = localc.iVo();
    parami = new org.b.c.g().bIB(parami.getBody());
    AppMethodBeat.o(40563);
    return parami;
  }
  
  public final void a(i parami, org.b.d.c paramc)
  {
    AppMethodBeat.i(40564);
    this.abMb.log("signing request: " + paramc.iVm());
    if (("".equals(parami.token)) && ("".equals(parami.TEk))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramc.pG("oauth_token", parami.token);
      }
      this.abMb.log("setting token to: ".concat(String.valueOf(parami)));
      a(paramc, parami);
      b(paramc);
      AppMethodBeat.o(40564);
      return;
    }
  }
  
  public final String b(i parami)
  {
    AppMethodBeat.i(40565);
    parami = this.abMc.b(parami);
    AppMethodBeat.o(40565);
    return parami;
  }
  
  public final i iVu()
  {
    AppMethodBeat.i(40561);
    this.abMb.log("obtaining request token from " + this.abMc.iVh());
    Object localObject = new org.b.d.c(j.abLT, this.abMc.iVh());
    this.abMb.log("setting oauth_callback to " + this.abMb.abLy);
    ((org.b.d.c)localObject).pG("oauth_callback", this.abMb.abLy);
    a((org.b.d.c)localObject, org.b.d.b.abLE);
    b((org.b.d.c)localObject);
    this.abMb.log("sending request...");
    localObject = ((org.b.d.c)localObject).iVo();
    String str = ((org.b.d.g)localObject).getBody();
    this.abMb.log("response status code: " + ((org.b.d.g)localObject).code);
    this.abMb.log("response body: ".concat(String.valueOf(str)));
    localObject = new org.b.c.g().bIB(str);
    AppMethodBeat.o(40561);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.b.e.a
 * JD-Core Version:    0.7.0.1
 */