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
import java.util.List;

public final class i
  extends q
{
  private List<String> GVg;
  private Cursor icq;
  
  public i(MMBaseSelectContactUI paramMMBaseSelectContactUI, boolean paramBoolean, List<String> paramList)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), true, paramBoolean);
    AppMethodBeat.i(102840);
    this.GVg = paramList;
    g.afC();
    this.icq = ((k)g.ab(k.class)).apM().gY(this.GVg);
    AppMethodBeat.o(102840);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102843);
    super.finish();
    ad.i("MicroMsg.CustomContactAdapter", "finish!");
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    AppMethodBeat.o(102843);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102841);
    int i = this.icq.getCount();
    AppMethodBeat.o(102841);
    return i;
  }
  
  protected final a pU(int paramInt)
  {
    AppMethodBeat.i(102842);
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
      AppMethodBeat.o(102842);
      return locale;
      ad.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.i
 * JD-Core Version:    0.7.0.1
 */