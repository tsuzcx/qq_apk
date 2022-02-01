package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.o.a;
import java.util.List;

public final class b
  extends o
{
  private l Bdt;
  private as contact;
  private MMHandler handler;
  private List<m> mWl;
  private String query;
  private com.tencent.mm.plugin.fts.a.a.a wXa;
  
  public b(com.tencent.mm.ui.contact.n paramn, int paramInt, as paramas)
  {
    super(paramn, false, paramInt);
    AppMethodBeat.i(26955);
    this.handler = new MMHandler();
    this.Bdt = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(26954);
        if (paramAnonymousk.resultCode == 0)
        {
          b.a(b.this, paramAnonymousk.wXb);
          if (b.a(b.this) != null) {
            b.c(b.this).B(paramAnonymousk.wTn.query, b.b(b.this).size(), true);
          }
        }
        b.this.clearCache();
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(26954);
      }
    };
    this.contact = paramas;
    AppMethodBeat.o(26955);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(26958);
    this.query = paramString;
    paramArrayOfInt = new j();
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.wWZ = this.Bdt;
    paramArrayOfInt.wWS = this.contact.field_username;
    paramArrayOfInt.kXb = 7;
    this.wXa = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(26958);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(26959);
    this.query = null;
    if (this.wXa != null) {
      ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.wXa);
    }
    AppMethodBeat.o(26959);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26957);
    if (this.mWl == null)
    {
      AppMethodBeat.o(26957);
      return 0;
    }
    int i = this.mWl.size();
    AppMethodBeat.o(26957);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    AppMethodBeat.i(26956);
    d locald = new d(paramInt, this.contact);
    bg.aVF();
    locald.contact = c.aSN().Kn(((m)this.mWl.get(paramInt)).wVX);
    AppMethodBeat.o(26956);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b
 * JD-Core Version:    0.7.0.1
 */