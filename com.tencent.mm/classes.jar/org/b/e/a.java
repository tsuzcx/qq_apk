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
  private org.b.d.a UiG;
  private org.b.a.a.b UiH;
  
  public a(org.b.a.a.b paramb, org.b.d.a parama)
  {
    this.UiH = paramb;
    this.UiG = parama;
  }
  
  private void a(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40562);
    paramc.oK("oauth_timestamp", new org.b.f.d().hQo());
    paramc.oK("oauth_nonce", new org.b.f.d().getNonce());
    paramc.oK("oauth_consumer_key", this.UiG.Uib);
    paramc.oK("oauth_signature_method", new org.b.f.a().hQn());
    paramc.oK("oauth_version", "1.0");
    if (this.UiG.hQa()) {
      paramc.oK("scope", this.UiG.scope);
    }
    paramc.oK("oauth_signature", b(paramc, parami));
    this.UiG.log("appended additional OAuth parameters: " + org.b.g.b.M(paramc.Uik));
    AppMethodBeat.o(40562);
  }
  
  private String b(org.b.d.c paramc, i parami)
  {
    AppMethodBeat.i(40566);
    this.UiG.log("generating signature...");
    paramc = new org.b.c.c().a(paramc);
    parami = new org.b.f.a().bD(paramc, this.UiG.Uic, parami.Mte);
    this.UiG.log("base string is: ".concat(String.valueOf(paramc)));
    this.UiG.log("signature is: ".concat(String.valueOf(parami)));
    AppMethodBeat.o(40566);
    return parami;
  }
  
  private void b(org.b.d.c paramc)
  {
    AppMethodBeat.i(40567);
    switch (hQm()[this.UiG.Uif.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(40567);
      return;
      this.UiG.log("using Http Header signature");
      paramc.addHeader("Authorization", new e().a(paramc));
      AppMethodBeat.o(40567);
      return;
      this.UiG.log("using Querystring signature");
      Iterator localIterator = paramc.Uik.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramc.oL((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public final i a(i parami, k paramk)
  {
    AppMethodBeat.i(40563);
    this.UiG.log("obtaining access token from " + this.UiH.hPZ());
    org.b.d.c localc = new org.b.d.c(j.Uiy, this.UiH.hPZ());
    localc.oK("oauth_token", parami.token);
    localc.oK("oauth_verifier", paramk.value);
    this.UiG.log("setting token to: " + parami + " and verifier to: " + paramk);
    a(localc, parami);
    b(localc);
    parami = localc.hQf();
    parami = new org.b.c.g().bvu(parami.getBody());
    AppMethodBeat.o(40563);
    return parami;
  }
  
  public final void a(i parami, org.b.d.c paramc)
  {
    AppMethodBeat.i(40564);
    this.UiG.log("signing request: " + paramc.hQd());
    if (("".equals(parami.token)) && ("".equals(parami.Mte))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramc.oK("oauth_token", parami.token);
      }
      this.UiG.log("setting token to: ".concat(String.valueOf(parami)));
      a(paramc, parami);
      b(paramc);
      AppMethodBeat.o(40564);
      return;
    }
  }
  
  public final String b(i parami)
  {
    AppMethodBeat.i(40565);
    parami = this.UiH.b(parami);
    AppMethodBeat.o(40565);
    return parami;
  }
  
  public final i hQl()
  {
    AppMethodBeat.i(40561);
    this.UiG.log("obtaining request token from " + this.UiH.hPY());
    Object localObject = new org.b.d.c(j.Uiy, this.UiH.hPY());
    this.UiG.log("setting oauth_callback to " + this.UiG.Uid);
    ((org.b.d.c)localObject).oK("oauth_callback", this.UiG.Uid);
    a((org.b.d.c)localObject, org.b.d.b.Uij);
    b((org.b.d.c)localObject);
    this.UiG.log("sending request...");
    localObject = ((org.b.d.c)localObject).hQf();
    String str = ((org.b.d.g)localObject).getBody();
    this.UiG.log("response status code: " + ((org.b.d.g)localObject).code);
    this.UiG.log("response body: ".concat(String.valueOf(str)));
    localObject = new org.b.c.g().bvu(str);
    AppMethodBeat.o(40561);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.b.e.a
 * JD-Core Version:    0.7.0.1
 */