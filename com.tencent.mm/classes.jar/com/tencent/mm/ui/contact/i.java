package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends q
{
  private List<String> PVr;
  private Cursor jWh;
  
  public i(MMBaseSelectContactUI paramMMBaseSelectContactUI, boolean paramBoolean, List<String> paramList)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), true, paramBoolean);
    AppMethodBeat.i(102840);
    this.PVr = paramList;
    g.aAi();
    this.jWh = ((l)g.af(l.class)).aSN().iL(this.PVr);
    AppMethodBeat.o(102840);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102843);
    super.finish();
    Log.i("MicroMsg.CustomContactAdapter", "finish!");
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    AppMethodBeat.o(102843);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102841);
    int i = this.jWh.getCount();
    AppMethodBeat.o(102841);
    return i;
  }
  
  protected final a va(int paramInt)
  {
    AppMethodBeat.i(102842);
    e locale = null;
    if ((paramInt >= 0) && (this.jWh.moveToPosition(paramInt)))
    {
      locale = new e(paramInt);
      as localas = new as();
      localas.convertFrom(this.jWh);
      locale.contact = localas;
      locale.PWh = eWh();
    }
    for (;;)
    {
      AppMethodBeat.o(102842);
      return locale;
      Log.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.i
 * JD-Core Version:    0.7.0.1
 */