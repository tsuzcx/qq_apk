package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends o
  implements com.tencent.mm.plugin.fts.a.l
{
  ad dnp;
  ah handler = new ah(Looper.getMainLooper());
  private List<com.tencent.mm.plugin.fts.a.a.l> kxO;
  
  public a(com.tencent.mm.ui.contact.l paraml, int paramInt, ad paramad)
  {
    super(paraml, new ArrayList(), true, false, paramInt);
    this.dnp = paramad;
  }
  
  public final void b(j paramj)
  {
    if (paramj.aYY == 0) {
      this.kxO = paramj.kxh;
    }
    notifyDataSetChanged();
  }
  
  public final int getCount()
  {
    if (this.kxO == null) {
      return 0;
    }
    return this.kxO.size();
  }
  
  protected final com.tencent.mm.ui.contact.a.a jQ(int paramInt)
  {
    e locale = new e(paramInt);
    au.Hx();
    locale.dnp = c.Fw().abl(((com.tencent.mm.plugin.fts.a.a.l)this.kxO.get(paramInt)).kwg);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a
 * JD-Core Version:    0.7.0.1
 */