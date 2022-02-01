package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends r
  implements l
{
  au contact;
  MMHandler handler;
  private List<com.tencent.mm.plugin.fts.a.a.o> tbH;
  
  public b(com.tencent.mm.ui.contact.o paramo, int paramInt, au paramau)
  {
    super(paramo, new ArrayList(), true, false, paramInt);
    AppMethodBeat.i(26950);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.contact = paramau;
    AppMethodBeat.o(26950);
  }
  
  public final void b(m paramm)
  {
    AppMethodBeat.i(26953);
    if (paramm.resultCode == 0) {
      this.tbH = paramm.HtF;
    }
    notifyDataSetChanged();
    AppMethodBeat.o(26953);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(26952);
    if (this.tbH == null)
    {
      AppMethodBeat.o(26952);
      return 0;
    }
    int i = this.tbH.size();
    AppMethodBeat.o(26952);
    return i;
  }
  
  public final a yk(int paramInt)
  {
    AppMethodBeat.i(26951);
    e locale = new e(paramInt, this.contact);
    bh.bCz();
    locale.contact = c.bzA().JE(((com.tencent.mm.plugin.fts.a.a.o)this.tbH.get(paramInt)).Hsz);
    AppMethodBeat.o(26951);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b
 * JD-Core Version:    0.7.0.1
 */