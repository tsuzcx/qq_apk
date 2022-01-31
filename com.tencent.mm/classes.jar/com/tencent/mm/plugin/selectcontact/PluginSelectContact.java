package com.tencent.mm.plugin.selectcontact;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.selectcontact.a.a;
import com.tencent.mm.ui.contact.s;

public class PluginSelectContact
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, a
{
  private com.tencent.mm.sdk.b.c nQu = new PluginSelectContact.1(this);
  
  public void configure(g paramg)
  {
    paramg.Ex();
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    paramg.Ex();
  }
  
  public void installed()
  {
    alias(PluginSelectContact.class);
  }
  
  public String name()
  {
    return "plugin-selectcontact";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    s.init();
    this.nQu.cqo();
  }
  
  public void onAccountRelease()
  {
    this.nQu.dead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.selectcontact.PluginSelectContact
 * JD-Core Version:    0.7.0.1
 */