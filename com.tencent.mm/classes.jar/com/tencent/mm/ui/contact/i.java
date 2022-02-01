package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends q
{
  private List<String> KIt;
  private Cursor iYC;
  
  public i(MMBaseSelectContactUI paramMMBaseSelectContactUI, boolean paramBoolean, List<String> paramList)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), true, paramBoolean);
    AppMethodBeat.i(102840);
    this.KIt = paramList;
    g.ajS();
    this.iYC = ((l)g.ab(l.class)).azF().hH(this.KIt);
    AppMethodBeat.o(102840);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102843);
    super.finish();
    ae.i("MicroMsg.CustomContactAdapter", "finish!");
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    AppMethodBeat.o(102843);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102841);
    int i = this.iYC.getCount();
    AppMethodBeat.o(102841);
    return i;
  }
  
  protected final a rk(int paramInt)
  {
    AppMethodBeat.i(102842);
    e locale = null;
    if ((paramInt >= 0) && (this.iYC.moveToPosition(paramInt)))
    {
      locale = new e(paramInt);
      an localan = new an();
      localan.convertFrom(this.iYC);
      locale.contact = localan;
      locale.KJj = dUh();
    }
    for (;;)
    {
      AppMethodBeat.o(102842);
      return locale;
      ae.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.i
 * JD-Core Version:    0.7.0.1
 */