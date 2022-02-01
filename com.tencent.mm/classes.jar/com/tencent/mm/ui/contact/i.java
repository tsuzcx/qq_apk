package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends q
{
  private List<String> Ivt;
  private Cursor iCz;
  
  public i(MMBaseSelectContactUI paramMMBaseSelectContactUI, boolean paramBoolean, List<String> paramList)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), true, paramBoolean);
    AppMethodBeat.i(102840);
    this.Ivt = paramList;
    g.agS();
    this.iCz = ((k)g.ab(k.class)).awB().hl(this.Ivt);
    AppMethodBeat.o(102840);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102843);
    super.finish();
    ac.i("MicroMsg.CustomContactAdapter", "finish!");
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    AppMethodBeat.o(102843);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102841);
    int i = this.iCz.getCount();
    AppMethodBeat.o(102841);
    return i;
  }
  
  protected final a qH(int paramInt)
  {
    AppMethodBeat.i(102842);
    e locale = null;
    if ((paramInt >= 0) && (this.iCz.moveToPosition(paramInt)))
    {
      locale = new e(paramInt);
      ai localai = new ai();
      localai.convertFrom(this.iCz);
      locale.contact = localai;
      locale.Iwh = dFi();
    }
    for (;;)
    {
      AppMethodBeat.o(102842);
      return locale;
      ac.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.i
 * JD-Core Version:    0.7.0.1
 */