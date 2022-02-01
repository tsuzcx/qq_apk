package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.o.a;
import java.util.List;

public final class b
  extends o
{
  private an contact;
  private aq handler;
  private List<m> lPc;
  private String query;
  private com.tencent.mm.plugin.fts.a.a.a tGb;
  private l xfN;
  
  public b(com.tencent.mm.ui.contact.n paramn, int paramInt, an paraman)
  {
    super(paramn, false, paramInt);
    AppMethodBeat.i(26955);
    this.handler = new aq();
    this.xfN = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(26954);
        if (paramAnonymousk.bZU == 0)
        {
          b.a(b.this, paramAnonymousk.tGc);
          if (b.a(b.this) != null) {
            b.c(b.this).y(paramAnonymousk.tCm.query, b.b(b.this).size(), true);
          }
        }
        b.this.clearCache();
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(26954);
      }
    };
    this.contact = paraman;
    AppMethodBeat.o(26955);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(26958);
    this.query = paramString;
    paramArrayOfInt = new j();
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.tGa = this.xfN;
    paramArrayOfInt.tFT = this.contact.field_username;
    paramArrayOfInt.jUf = 7;
    this.tGb = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(26958);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(26959);
    this.query = null;
    if (this.tGb != null) {
      ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.tGb);
    }
    AppMethodBeat.o(26959);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26957);
    if (this.lPc == null)
    {
      AppMethodBeat.o(26957);
      return 0;
    }
    int i = this.lPc.size();
    AppMethodBeat.o(26957);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a rk(int paramInt)
  {
    AppMethodBeat.i(26956);
    d locald = new d(paramInt, this.contact);
    bc.aCg();
    locald.contact = c.azF().BH(((m)this.lPc.get(paramInt)).tEY);
    AppMethodBeat.o(26956);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b
 * JD-Core Version:    0.7.0.1
 */