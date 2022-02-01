package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends q
  implements l
{
  af contact;
  ap handler;
  private List<m> kLN;
  
  public a(n paramn, int paramInt, af paramaf)
  {
    super(paramn, new ArrayList(), true, false, paramInt);
    AppMethodBeat.i(26950);
    this.handler = new ap(Looper.getMainLooper());
    this.contact = paramaf;
    AppMethodBeat.o(26950);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(26953);
    if (paramk.bRZ == 0) {
      this.kLN = paramk.rpQ;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(26953);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26952);
    if (this.kLN == null)
    {
      AppMethodBeat.o(26952);
      return 0;
    }
    int i = this.kLN.size();
    AppMethodBeat.o(26952);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a pU(int paramInt)
  {
    AppMethodBeat.i(26951);
    d locald = new d(paramInt, this.contact);
    az.arV();
    locald.contact = c.apM().aHY(((m)this.kLN.get(paramInt)).roN);
    AppMethodBeat.o(26951);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a
 * JD-Core Version:    0.7.0.1
 */