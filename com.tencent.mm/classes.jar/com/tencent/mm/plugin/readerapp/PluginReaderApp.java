package com.tencent.mm.plugin.readerapp;

import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class PluginReaderApp
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, a
{
  private com.tencent.mm.ah.f noq = new PluginReaderApp.2(this);
  
  private boolean checkInstall()
  {
    return (q.Gu() & 0x80000) == 0;
  }
  
  private boolean checkRecvNews()
  {
    return (q.Gp() & 0x400) == 0;
  }
  
  private void reportPluginStatus()
  {
    int i;
    if (checkInstall())
    {
      i = 1;
      if (!checkRecvNews()) {
        break label74;
      }
    }
    label74:
    for (int j = 1;; j = 0)
    {
      h.nFQ.f(15416, new Object[] { "newsapp", Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzl, Long.valueOf(System.currentTimeMillis()));
      return;
      i = 0;
      break;
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex()) {
      pin(new com.tencent.mm.model.p(com.tencent.mm.plugin.readerapp.c.g.class));
    }
  }
  
  public void dependency()
  {
    dependsOn(com.tencent.mm.plugin.messenger.foundation.a.p.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex()) {
      com.tencent.mm.br.c.Xg("readerapp");
    }
  }
  
  public void installed()
  {
    alias(a.class);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    com.tencent.mm.sdk.f.e.post(new PluginReaderApp.1(this), "ReaderAppReport");
  }
  
  public void onAccountRelease()
  {
    com.tencent.mm.kernel.g.Dk().b(138, this.noq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.PluginReaderApp
 * JD-Core Version:    0.7.0.1
 */