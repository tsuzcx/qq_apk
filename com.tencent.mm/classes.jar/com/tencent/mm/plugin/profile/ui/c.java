package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.p.a;
import java.util.List;

public final class c
  extends p
{
  private com.tencent.mm.plugin.fts.a.a.c HtE;
  private com.tencent.mm.plugin.fts.a.l MVp;
  private au contact;
  private MMHandler handler;
  private String query;
  private List<com.tencent.mm.plugin.fts.a.a.o> tbH;
  
  public c(com.tencent.mm.ui.contact.o paramo, int paramInt, au paramau)
  {
    super(paramo, false, paramInt);
    AppMethodBeat.i(26955);
    this.handler = new MMHandler();
    this.MVp = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(m paramAnonymousm)
      {
        AppMethodBeat.i(26954);
        if (paramAnonymousm.resultCode == 0)
        {
          c.a(c.this, paramAnonymousm.HtF);
          if (c.a(c.this) != null) {
            c.c(c.this).h(paramAnonymousm.HpM.query, c.b(c.this).size(), true);
          }
        }
        c.this.clearCache();
        c.this.notifyDataSetChanged();
        AppMethodBeat.o(26954);
      }
    };
    this.contact = paramau;
    AppMethodBeat.o(26955);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(26958);
    this.query = paramString;
    paramArrayOfInt = new com.tencent.mm.plugin.fts.a.a.l();
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.HtC = this.MVp;
    paramArrayOfInt.Htv = this.contact.field_username;
    paramArrayOfInt.qRb = 7;
    this.HtE = ((n)h.az(n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(26958);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(26959);
    this.query = null;
    if (this.HtE != null) {
      ((n)h.az(n.class)).cancelSearchTask(this.HtE);
    }
    AppMethodBeat.o(26959);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26957);
    if (this.tbH == null)
    {
      AppMethodBeat.o(26957);
      return 0;
    }
    int i = this.tbH.size();
    AppMethodBeat.o(26957);
    return i;
  }
  
  public final a yk(int paramInt)
  {
    AppMethodBeat.i(26956);
    e locale = new e(paramInt, this.contact);
    bh.bCz();
    locale.contact = com.tencent.mm.model.c.bzA().JE(((com.tencent.mm.plugin.fts.a.a.o)this.tbH.get(paramInt)).Hsz);
    AppMethodBeat.o(26956);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c
 * JD-Core Version:    0.7.0.1
 */