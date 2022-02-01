package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.p.a;
import java.util.List;

public final class b
  extends p
{
  private com.tencent.mm.plugin.fts.a.a.a BIV;
  private l GXs;
  private as contact;
  private MMHandler handler;
  private List<m> pWR;
  private String query;
  
  public b(o paramo, int paramInt, as paramas)
  {
    super(paramo, false, paramInt);
    AppMethodBeat.i(26955);
    this.handler = new MMHandler();
    this.GXs = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(26954);
        if (paramAnonymousk.resultCode == 0)
        {
          b.a(b.this, paramAnonymousk.BIW);
          if (b.a(b.this) != null) {
            b.c(b.this).g(paramAnonymousk.BFk.query, b.b(b.this).size(), true);
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
  
  public final void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(26958);
    this.query = paramString;
    paramArrayOfInt = new j();
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.BIU = this.GXs;
    paramArrayOfInt.BIN = this.contact.field_username;
    paramArrayOfInt.nRn = 7;
    this.BIV = ((n)h.ag(n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(26958);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(26959);
    this.query = null;
    if (this.BIV != null) {
      ((n)h.ag(n.class)).cancelSearchTask(this.BIV);
    }
    AppMethodBeat.o(26959);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26957);
    if (this.pWR == null)
    {
      AppMethodBeat.o(26957);
      return 0;
    }
    int i = this.pWR.size();
    AppMethodBeat.o(26957);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(26956);
    e locale = new e(paramInt, this.contact);
    bh.beI();
    locale.contact = c.bbL().RG(((m)this.pWR.get(paramInt)).BHS);
    AppMethodBeat.o(26956);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b
 * JD-Core Version:    0.7.0.1
 */