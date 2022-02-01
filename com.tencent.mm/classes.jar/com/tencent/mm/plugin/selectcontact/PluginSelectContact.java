package com.tencent.mm.plugin.selectcontact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.selectcontact.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.contact.w;

public class PluginSelectContact
  extends f
  implements c, a
{
  private IListener Jcp;
  
  public PluginSelectContact()
  {
    AppMethodBeat.i(102768);
    this.Jcp = new IListener() {};
    AppMethodBeat.o(102768);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(102770);
    paramg.aIE();
    AppMethodBeat.o(102770);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(102771);
    paramg.aIE();
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
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(102772);
    w.init();
    this.Jcp.alive();
    AppMethodBeat.o(102772);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102773);
    this.Jcp.dead();
    AppMethodBeat.o(102773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectcontact.PluginSelectContact
 * JD-Core Version:    0.7.0.1
 */