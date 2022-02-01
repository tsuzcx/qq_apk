package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends q
  implements l
{
  as contact;
  MMHandler handler;
  private List<m> mWl;
  
  public a(n paramn, int paramInt, as paramas)
  {
    super(paramn, new ArrayList(), true, false, paramInt);
    AppMethodBeat.i(26950);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.contact = paramas;
    AppMethodBeat.o(26950);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(26953);
    if (paramk.resultCode == 0) {
      this.mWl = paramk.wXb;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(26953);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26952);
    if (this.mWl == null)
    {
      AppMethodBeat.o(26952);
      return 0;
    }
    int i = this.mWl.size();
    AppMethodBeat.o(26952);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    AppMethodBeat.i(26951);
    d locald = new d(paramInt, this.contact);
    bg.aVF();
    locald.contact = c.aSN().Kn(((m)this.mWl.get(paramInt)).wVX);
    AppMethodBeat.o(26951);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a
 * JD-Core Version:    0.7.0.1
 */