package org.c.e;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.c.c.e;
import org.c.c.f;
import org.c.d.i;
import org.c.d.j;
import org.c.d.k;

public final class a
  implements b
{
  private org.c.d.a xuU;
  private org.c.a.a.b xuV;
  
  public a(org.c.a.a.b paramb, org.c.d.a parama)
  {
    this.xuV = paramb;
    this.xuU = parama;
  }
  
  private void a(org.c.d.c paramc, i parami)
  {
    paramc.ha("oauth_timestamp", new org.c.f.d().cVg());
    paramc.ha("oauth_nonce", new org.c.f.d().getNonce());
    paramc.ha("oauth_consumer_key", this.xuU.xun);
    paramc.ha("oauth_signature_method", new org.c.f.a().cVf());
    paramc.ha("oauth_version", "1.0");
    if (this.xuU.scope != null) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramc.ha("scope", this.xuU.scope);
      }
      this.xuU.tn("generating signature...");
      String str = new org.c.c.c().a(paramc);
      parami = new org.c.f.a().au(str, this.xuU.xuo, parami.tsv);
      this.xuU.tn("base string is: " + str);
      this.xuU.tn("signature is: " + parami);
      paramc.ha("oauth_signature", parami);
      this.xuU.tn("appended additional OAuth parameters: " + org.c.g.b.s(paramc.xuw));
      return;
    }
  }
  
  private void b(org.c.d.c paramc)
  {
    switch (cVe()[this.xuU.xur.ordinal()])
    {
    }
    for (;;)
    {
      return;
      this.xuU.tn("using Http Header signature");
      paramc.addHeader("Authorization", new e().a(paramc));
      return;
      this.xuU.tn("using Querystring signature");
      Iterator localIterator = paramc.xuw.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramc.hb((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public final i a(i parami, k paramk)
  {
    this.xuU.tn("obtaining access token from " + this.xuV.cUT());
    org.c.d.c localc = new org.c.d.c(j.xuM, this.xuV.cUT());
    localc.ha("oauth_token", parami.token);
    localc.ha("oauth_verifier", paramk.value);
    this.xuU.tn("setting token to: " + parami + " and verifier to: " + paramk);
    a(localc, parami);
    b(localc);
    parami = localc.cUY();
    return new org.c.c.g().ahz(parami.getBody());
  }
  
  public final void a(i parami, org.c.d.c paramc)
  {
    this.xuU.tn("signing request: " + paramc.cUW());
    if (("".equals(parami.token)) && ("".equals(parami.tsv))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramc.ha("oauth_token", parami.token);
      }
      this.xuU.tn("setting token to: " + parami);
      a(paramc, parami);
      b(paramc);
      return;
    }
  }
  
  public final String b(i parami)
  {
    return this.xuV.b(parami);
  }
  
  public final i cVd()
  {
    this.xuU.tn("obtaining request token from " + this.xuV.cUS());
    Object localObject = new org.c.d.c(j.xuM, this.xuV.cUS());
    this.xuU.tn("setting oauth_callback to " + this.xuU.xup);
    ((org.c.d.c)localObject).ha("oauth_callback", this.xuU.xup);
    a((org.c.d.c)localObject, org.c.d.b.xuv);
    b((org.c.d.c)localObject);
    this.xuU.tn("sending request...");
    localObject = ((org.c.d.c)localObject).cUY();
    String str = ((org.c.d.g)localObject).getBody();
    this.xuU.tn("response status code: " + ((org.c.d.g)localObject).code);
    this.xuU.tn("response body: " + str);
    return new org.c.c.g().ahz(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.c.e.a
 * JD-Core Version:    0.7.0.1
 */