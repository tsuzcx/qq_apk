package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.m;
import java.util.List;

public final class b
  extends com.tencent.mm.ui.contact.n
{
  private ad contact;
  private ak handler;
  private com.tencent.mm.plugin.fts.a.a.a mSV;
  private List<com.tencent.mm.plugin.fts.a.a.l> mTC;
  private com.tencent.mm.plugin.fts.a.l pym;
  private String query;
  
  public b(m paramm, int paramInt, ad paramad)
  {
    super(paramm, false, paramInt);
    AppMethodBeat.i(23335);
    this.handler = new ak();
    this.pym = new b.1(this);
    this.contact = paramad;
    AppMethodBeat.o(23335);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(23338);
    this.query = paramString;
    paramArrayOfInt = new i();
    paramArrayOfInt.query = paramString;
    paramArrayOfInt.handler = this.handler;
    paramArrayOfInt.mSU = this.pym;
    paramArrayOfInt.mSN = this.contact.field_username;
    paramArrayOfInt.hdl = 7;
    this.mSV = ((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).search(2, paramArrayOfInt);
    AppMethodBeat.o(23338);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(23339);
    this.query = null;
    if (this.mSV != null) {
      ((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.mSV);
    }
    AppMethodBeat.o(23339);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(23337);
    if (this.mTC == null)
    {
      AppMethodBeat.o(23337);
      return 0;
    }
    int i = this.mTC.size();
    AppMethodBeat.o(23337);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a mM(int paramInt)
  {
    AppMethodBeat.i(23336);
    d locald = new d(paramInt, this.contact);
    aw.aaz();
    locald.contact = c.YA().arw(((com.tencent.mm.plugin.fts.a.a.l)this.mTC.get(paramInt)).mRV);
    AppMethodBeat.o(23336);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b
 * JD-Core Version:    0.7.0.1
 */