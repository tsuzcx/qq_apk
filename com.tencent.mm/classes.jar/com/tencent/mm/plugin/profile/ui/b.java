package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.o.a;
import java.util.List;

public final class b
  extends o
{
  private am contact;
  private ap handler;
  private List<m> lKC;
  private String query;
  private com.tencent.mm.plugin.fts.a.a.a tvk;
  private l wPW;
  
  public b(com.tencent.mm.ui.contact.n paramn, int paramInt, am paramam)
  {
    super(paramn, false, paramInt);
    AppMethodBeat.i(26955);
    this.handler = new ap();
    this.wPW = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(26954);
        if (paramAnonymousk.bZU == 0)
        {
          b.a(b.this, paramAnonymousk.tvl);
          if (b.a(b.this) != null) {
            b.c(b.this).y(paramAnonymousk.trv.query, b.b(b.this).size(), true);
          }
        }
        b.this.clearCache();
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(26954);
      }
    };
    this.contact = paramam;
    AppMethodBeat.o(26955);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(26958);
    this.query = paramString;
    paramArrayOfInt = new j();
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.tvj = this.wPW;
    paramArrayOfInt.tvc = this.contact.field_username;
    paramArrayOfInt.jQN = 7;
    this.tvk = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(26958);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(26959);
    this.query = null;
    if (this.tvk != null) {
      ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.tvk);
    }
    AppMethodBeat.o(26959);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26957);
    if (this.lKC == null)
    {
      AppMethodBeat.o(26957);
      return 0;
    }
    int i = this.lKC.size();
    AppMethodBeat.o(26957);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a rh(int paramInt)
  {
    AppMethodBeat.i(26956);
    d locald = new d(paramInt, this.contact);
    ba.aBQ();
    locald.contact = c.azp().Bf(((m)this.lKC.get(paramInt)).tuh);
    AppMethodBeat.o(26956);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b
 * JD-Core Version:    0.7.0.1
 */