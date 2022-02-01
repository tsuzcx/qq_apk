package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;

public final class ae
  extends q
{
  private String KFj;
  private Cursor iYC;
  
  public ae(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), false, false);
    AppMethodBeat.i(102929);
    this.KFj = paramString;
    ZD();
    AppMethodBeat.o(102929);
  }
  
  private void ZD()
  {
    AppMethodBeat.i(188633);
    g.ajS();
    this.iYC = ((l)g.ab(l.class)).azF().e(this.KFj, "", this.fUR);
    AppMethodBeat.o(188633);
  }
  
  public final void Zq()
  {
    AppMethodBeat.i(188634);
    super.Zq();
    ZD();
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(188634);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102932);
    super.finish();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SpecialContactAdapter", "finish!");
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    AppMethodBeat.o(102932);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102930);
    int i = this.iYC.getCount();
    AppMethodBeat.o(102930);
    return i;
  }
  
  protected final a rk(int paramInt)
  {
    AppMethodBeat.i(102931);
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
      AppMethodBeat.o(102931);
      return locale;
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ae
 * JD-Core Version:    0.7.0.1
 */