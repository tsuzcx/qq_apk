package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.o.a;
import java.util.List;

public final class b
  extends o
{
  private ai contact;
  private ao handler;
  private List<m> lnk;
  private String query;
  private com.tencent.mm.plugin.fts.a.a.a syJ;
  private l vIP;
  
  public b(com.tencent.mm.ui.contact.n paramn, int paramInt, ai paramai)
  {
    super(paramn, false, paramInt);
    AppMethodBeat.i(26955);
    this.handler = new ao();
    this.vIP = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(26954);
        if (paramAnonymousk.bPH == 0)
        {
          b.a(b.this, paramAnonymousk.syK);
          if (b.a(b.this) != null) {
            b.c(b.this).y(paramAnonymousk.suU.query, b.b(b.this).size(), true);
          }
        }
        b.this.clearCache();
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(26954);
      }
    };
    this.contact = paramai;
    AppMethodBeat.o(26955);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(26958);
    this.query = paramString;
    paramArrayOfInt = new j();
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.syI = this.vIP;
    paramArrayOfInt.syB = this.contact.field_username;
    paramArrayOfInt.jwR = 7;
    this.syJ = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(26958);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(26959);
    this.query = null;
    if (this.syJ != null) {
      ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.syJ);
    }
    AppMethodBeat.o(26959);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26957);
    if (this.lnk == null)
    {
      AppMethodBeat.o(26957);
      return 0;
    }
    int i = this.lnk.size();
    AppMethodBeat.o(26957);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a qH(int paramInt)
  {
    AppMethodBeat.i(26956);
    d locald = new d(paramInt, this.contact);
    az.ayM();
    locald.contact = c.awB().aNt(((m)this.lnk.get(paramInt)).sxG);
    AppMethodBeat.o(26956);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b
 * JD-Core Version:    0.7.0.1
 */