package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends r
  implements l
{
  as contact;
  MMHandler handler;
  private List<m> pWR;
  
  public a(o paramo, int paramInt, as paramas)
  {
    super(paramo, new ArrayList(), true, false, paramInt);
    AppMethodBeat.i(26950);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.contact = paramas;
    AppMethodBeat.o(26950);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(26953);
    if (paramk.resultCode == 0) {
      this.pWR = paramk.BIW;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(26953);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26952);
    if (this.pWR == null)
    {
      AppMethodBeat.o(26952);
      return 0;
    }
    int i = this.pWR.size();
    AppMethodBeat.o(26952);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(26951);
    e locale = new e(paramInt, this.contact);
    bh.beI();
    locale.contact = c.bbL().RG(((m)this.pWR.get(paramInt)).BHS);
    AppMethodBeat.o(26951);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a
 * JD-Core Version:    0.7.0.1
 */