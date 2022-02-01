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
  private org.b.d.a MbC;
  private org.b.a.a.b MbD;
  
  public a(org.b.a.a.b paramb, org.b.d.a parama)
  {
    this.MbD = paramb;
    this.MbC = parama;
  }
  
  private void a(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40562);
    paramc.nn("oauth_timestamp", new org.b.f.d().gge());
    paramc.nn("oauth_nonce", new org.b.f.d().getNonce());
    paramc.nn("oauth_consumer_key", this.MbC.MaX);
    paramc.nn("oauth_signature_method", new org.b.f.a().ggd());
    paramc.nn("oauth_version", "1.0");
    if (this.MbC.gfQ()) {
      paramc.nn("scope", this.MbC.scope);
    }
    paramc.nn("oauth_signature", b(paramc, parami));
    this.MbC.log("appended additional OAuth parameters: " + org.b.g.b.C(paramc.Mbg));
    AppMethodBeat.o(40562);
  }
  
  private String b(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40566);
    this.MbC.log("generating signature...");
    paramc = new org.b.c.c().a(paramc);
    parami = new org.b.f.a().bk(paramc, this.MbC.MaY, parami.FjO);
    this.MbC.log("base string is: ".concat(String.valueOf(paramc)));
    this.MbC.log("signature is: ".concat(String.valueOf(parami)));
    AppMethodBeat.o(40566);
    return parami;
  }
  
  private void b(org.b.d.c paramc)
  {
    AppMethodBeat.i(40567);
    switch (ggc()[this.MbC.Mbb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40567);
      return;
      this.MbC.log("using Http Header signature");
      paramc.addHeader("Authorization", new e().a(paramc));
      AppMethodBeat.o(40567);
      return;
      this.MbC.log("using Querystring signature");
      Iterator localIterator = paramc.Mbg.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramc.no((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public final i a(i parami, k paramk)
  {
    AppMethodBeat.i(40563);
    this.MbC.log("obtaining access token from " + this.MbD.gfP());
    org.b.d.c localc = new org.b.d.c(j.Mbu, this.MbD.gfP());
    localc.nn("oauth_token", parami.token);
    localc.nn("oauth_verifier", paramk.value);
    this.MbC.log("setting token to: " + parami + " and verifier to: " + paramk);
    a(localc, parami);
    b(localc);
    parami = localc.gfV();
    parami = new org.b.c.g().aXE(parami.getBody());
    AppMethodBeat.o(40563);
    return parami;
  }
  
  public final void a(i parami, org.b.d.c paramc)
  {
    AppMethodBeat.i(40564);
    this.MbC.log("signing request: " + paramc.gfT());
    if (("".equals(parami.token)) && ("".equals(parami.FjO))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramc.nn("oauth_token", parami.token);
      }
      this.MbC.log("setting token to: ".concat(String.valueOf(parami)));
      a(paramc, parami);
      b(paramc);
      AppMethodBeat.o(40564);
      return;
    }
  }
  
  public final String b(i parami)
  {
    AppMethodBeat.i(40565);
    parami = this.MbD.b(parami);
    AppMethodBeat.o(40565);
    return parami;
  }
  
  public final i ggb()
  {
    AppMethodBeat.i(40561);
    this.MbC.log("obtaining request token from " + this.MbD.gfO());
    Object localObject = new org.b.d.c(j.Mbu, this.MbD.gfO());
    this.MbC.log("setting oauth_callback to " + this.MbC.MaZ);
    ((org.b.d.c)localObject).nn("oauth_callback", this.MbC.MaZ);
    a((org.b.d.c)localObject, org.b.d.b.Mbf);
    b((org.b.d.c)localObject);
    this.MbC.log("sending request...");
    localObject = ((org.b.d.c)localObject).gfV();
    String str = ((org.b.d.g)localObject).getBody();
    this.MbC.log("response status code: " + ((org.b.d.g)localObject).code);
    this.MbC.log("response body: ".concat(String.valueOf(str)));
    localObject = new org.b.c.g().aXE(str);
    AppMethodBeat.o(40561);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.b.e.a
 * JD-Core Version:    0.7.0.1
 */