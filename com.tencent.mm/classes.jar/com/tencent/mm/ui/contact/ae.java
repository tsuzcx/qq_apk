package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;

public final class ae
  extends q
{
  private String GRX;
  private Cursor icq;
  
  public ae(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), false, false);
    AppMethodBeat.i(102929);
    this.GRX = paramString;
    g.afC();
    this.icq = ((k)g.ab(k.class)).apM().e(this.GRX, "", this.fvP);
    AppMethodBeat.o(102929);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102932);
    super.finish();
    ad.i("MicroMsg.SpecialContactAdapter", "finish!");
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    AppMethodBeat.o(102932);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102930);
    int i = this.icq.getCount();
    AppMethodBeat.o(102930);
    return i;
  }
  
  protected final a pU(int paramInt)
  {
    AppMethodBeat.i(102931);
    e locale = null;
    if ((paramInt >= 0) && (this.icq.moveToPosition(paramInt)))
    {
      locale = new e(paramInt);
      af localaf = new af();
      localaf.convertFrom(this.icq);
      locale.contact = localaf;
      locale.GVT = dqZ();
    }
    for (;;)
    {
      AppMethodBeat.o(102931);
      return locale;
      ad.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ae
 * JD-Core Version:    0.7.0.1
 */