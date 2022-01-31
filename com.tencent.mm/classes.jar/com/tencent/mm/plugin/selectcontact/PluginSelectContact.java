package com.tencent.mm.plugin.selectcontact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.selectcontact.a.a;
import com.tencent.mm.ui.contact.t;

public class PluginSelectContact
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, a
{
  private com.tencent.mm.sdk.b.c qEr;
  
  public PluginSelectContact()
  {
    AppMethodBeat.i(105152);
    this.qEr = new PluginSelectContact.1(this);
    AppMethodBeat.o(105152);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(105154);
    paramg.SD();
    AppMethodBeat.o(105154);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(105155);
    paramg.SD();
    AppMethodBeat.o(105155);
  }
  
  public void installed()
  {
    AppMethodBeat.i(105153);
    alias(PluginSelectContact.class);
    AppMethodBeat.o(105153);
  }
  
  public String name()
  {
    return "plugin-selectcontact";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(105156);
    t.init();
    this.qEr.alive();
    AppMethodBeat.o(105156);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(105157);
    this.qEr.dead();
    AppMethodBeat.o(105157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.selectcontact.PluginSelectContact
 * JD-Core Version:    0.7.0.1
 */