package com.tencent.mm.plugin.selectcontact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.selectcontact.a.a;
import com.tencent.mm.ui.contact.u;

public class PluginSelectContact
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, a
{
  private com.tencent.mm.sdk.b.c yRT;
  
  public PluginSelectContact()
  {
    AppMethodBeat.i(102768);
    this.yRT = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(102768);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(102770);
    paramg.akL();
    AppMethodBeat.o(102770);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(102771);
    paramg.akL();
    AppMethodBeat.o(102771);
  }
  
  public void installed()
  {
    AppMethodBeat.i(102769);
    alias(PluginSelectContact.class);
    AppMethodBeat.o(102769);
  }
  
  public String name()
  {
    return "plugin-selectcontact";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(102772);
    u.init();
    this.yRT.alive();
    AppMethodBeat.o(102772);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102773);
    this.yRT.dead();
    AppMethodBeat.o(102773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectcontact.PluginSelectContact
 * JD-Core Version:    0.7.0.1
 */