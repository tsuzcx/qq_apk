package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.p;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends p
  implements com.tencent.mm.plugin.fts.a.l
{
  ad contact;
  ak handler;
  private List<com.tencent.mm.plugin.fts.a.a.l> mTC;
  
  public a(m paramm, int paramInt, ad paramad)
  {
    super(paramm, new ArrayList(), true, false, paramInt);
    AppMethodBeat.i(23330);
    this.handler = new ak(Looper.getMainLooper());
    this.contact = paramad;
    AppMethodBeat.o(23330);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(23333);
    if (paramj.bpE == 0) {
      this.mTC = paramj.mSW;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(23333);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(23332);
    if (this.mTC == null)
    {
      AppMethodBeat.o(23332);
      return 0;
    }
    int i = this.mTC.size();
    AppMethodBeat.o(23332);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a mM(int paramInt)
  {
    AppMethodBeat.i(23331);
    d locald = new d(paramInt, this.contact);
    aw.aaz();
    locald.contact = c.YA().arw(((com.tencent.mm.plugin.fts.a.a.l)this.mTC.get(paramInt)).mRV);
    AppMethodBeat.o(23331);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a
 * JD-Core Version:    0.7.0.1
 */