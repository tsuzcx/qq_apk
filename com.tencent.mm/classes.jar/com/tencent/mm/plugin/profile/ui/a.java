package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class a
  extends q
  implements l
{
  ai contact;
  ao handler;
  private List<m> lnk;
  
  public a(n paramn, int paramInt, ai paramai)
  {
    super(paramn, new ArrayList(), true, false, paramInt);
    AppMethodBeat.i(26950);
    this.handler = new ao(Looper.getMainLooper());
    this.contact = paramai;
    AppMethodBeat.o(26950);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(26953);
    if (paramk.bPH == 0) {
      this.lnk = paramk.syK;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(26953);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26952);
    if (this.lnk == null)
    {
      AppMethodBeat.o(26952);
      return 0;
    }
    int i = this.lnk.size();
    AppMethodBeat.o(26952);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a qH(int paramInt)
  {
    AppMethodBeat.i(26951);
    d locald = new d(paramInt, this.contact);
    az.ayM();
    locald.contact = c.awB().aNt(((m)this.lnk.get(paramInt)).sxG);
    AppMethodBeat.o(26951);
    return locald;
  }
  
  static final class a
    implements Comparator<m>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a
 * JD-Core Version:    0.7.0.1
 */