package com.tencent.mm.plugin.selectcontact;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.du;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.selectcontact.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.contact.w;

public class PluginSelectContact
  extends com.tencent.mm.kernel.b.f
  implements c, a
{
  private IListener Pme;
  
  public PluginSelectContact()
  {
    AppMethodBeat.i(102768);
    this.Pme = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(102768);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(102770);
    paramg.bbA();
    AppMethodBeat.o(102770);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(102771);
    paramg.bbA();
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
    this.Pme.alive();
    AppMethodBeat.o(102772);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(102773);
    this.Pme.dead();
    AppMethodBeat.o(102773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectcontact.PluginSelectContact
 * JD-Core Version:    0.7.0.1
 */