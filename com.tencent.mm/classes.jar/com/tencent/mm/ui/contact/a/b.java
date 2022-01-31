package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class b
  extends e
{
  public String aVr;
  public int kCB = 0;
  private boolean vOm;
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final void bW(Context paramContext)
  {
    if ((this.kCB != 0) && (this.aVr != null))
    {
      this.vOz = this.kCB;
      this.vOy = this.aVr;
      return;
    }
    ad localad = this.dnp;
    if (!this.vOm)
    {
      g.DQ();
      localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.username);
      this.dnp = localad;
      this.vOm = true;
    }
    if (localad == null)
    {
      this.eXK = "";
      return;
    }
    this.eXK = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, ((com.tencent.mm.plugin.messenger.a.b)g.r(com.tencent.mm.plugin.messenger.a.b.class)).c(localad), com.tencent.mm.cb.a.aa(paramContext, a.c.NormalTextSize));
    this.username = localad.field_username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.b
 * JD-Core Version:    0.7.0.1
 */