package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends q
{
  private List<String> KlZ;
  private Cursor iVJ;
  
  public i(MMBaseSelectContactUI paramMMBaseSelectContactUI, boolean paramBoolean, List<String> paramList)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), true, paramBoolean);
    AppMethodBeat.i(102840);
    this.KlZ = paramList;
    g.ajD();
    this.iVJ = ((l)g.ab(l.class)).azp().hx(this.KlZ);
    AppMethodBeat.o(102840);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102843);
    super.finish();
    ad.i("MicroMsg.CustomContactAdapter", "finish!");
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    AppMethodBeat.o(102843);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102841);
    int i = this.iVJ.getCount();
    AppMethodBeat.o(102841);
    return i;
  }
  
  protected final a rh(int paramInt)
  {
    AppMethodBeat.i(102842);
    e locale = null;
    if ((paramInt >= 0) && (this.iVJ.moveToPosition(paramInt)))
    {
      locale = new e(paramInt);
      am localam = new am();
      localam.convertFrom(this.iVJ);
      locale.contact = localam;
      locale.KmP = dQK();
    }
    for (;;)
    {
      AppMethodBeat.o(102842);
      return locale;
      ad.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.i
 * JD-Core Version:    0.7.0.1
 */