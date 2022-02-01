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

public final class ae
  extends q
{
  private String KiP;
  private Cursor iVJ;
  
  public ae(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), false, false);
    AppMethodBeat.i(102929);
    this.KiP = paramString;
    g.ajD();
    this.iVJ = ((l)g.ab(l.class)).azp().e(this.KiP, "", this.fSL);
    AppMethodBeat.o(102929);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102932);
    super.finish();
    ad.i("MicroMsg.SpecialContactAdapter", "finish!");
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    AppMethodBeat.o(102932);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102930);
    int i = this.iVJ.getCount();
    AppMethodBeat.o(102930);
    return i;
  }
  
  protected final a rh(int paramInt)
  {
    AppMethodBeat.i(102931);
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
      AppMethodBeat.o(102931);
      return locale;
      ad.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ae
 * JD-Core Version:    0.7.0.1
 */