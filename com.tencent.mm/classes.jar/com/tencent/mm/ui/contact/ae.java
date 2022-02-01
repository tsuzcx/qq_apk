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

public final class ae
  extends q
{
  private String Isk;
  private Cursor iCz;
  
  public ae(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), false, false);
    AppMethodBeat.i(102929);
    this.Isk = paramString;
    g.agS();
    this.iCz = ((k)g.ab(k.class)).awB().e(this.Isk, "", this.fzw);
    AppMethodBeat.o(102929);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102932);
    super.finish();
    ac.i("MicroMsg.SpecialContactAdapter", "finish!");
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    AppMethodBeat.o(102932);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102930);
    int i = this.iCz.getCount();
    AppMethodBeat.o(102930);
    return i;
  }
  
  protected final a qH(int paramInt)
  {
    AppMethodBeat.i(102931);
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
      AppMethodBeat.o(102931);
      return locale;
      ac.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ae
 * JD-Core Version:    0.7.0.1
 */