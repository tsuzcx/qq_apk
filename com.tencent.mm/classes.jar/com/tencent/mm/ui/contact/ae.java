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

public final class ae
  extends q
{
  private String PSf;
  private Cursor jWh;
  
  public ae(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), false, false);
    AppMethodBeat.i(102929);
    this.PSf = paramString;
    anp();
    AppMethodBeat.o(102929);
  }
  
  private void anp()
  {
    AppMethodBeat.i(219809);
    g.aAi();
    this.jWh = ((l)g.af(l.class)).aSN().e(this.PSf, "", this.gzY);
    AppMethodBeat.o(219809);
  }
  
  public final void and()
  {
    AppMethodBeat.i(219810);
    super.and();
    anp();
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(219810);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102932);
    super.finish();
    Log.i("MicroMsg.SpecialContactAdapter", "finish!");
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    AppMethodBeat.o(102932);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102930);
    int i = this.jWh.getCount();
    AppMethodBeat.o(102930);
    return i;
  }
  
  protected final a va(int paramInt)
  {
    AppMethodBeat.i(102931);
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
      AppMethodBeat.o(102931);
      return locale;
      Log.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ae
 * JD-Core Version:    0.7.0.1
 */