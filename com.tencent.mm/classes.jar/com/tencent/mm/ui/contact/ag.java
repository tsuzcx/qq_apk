package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import java.util.ArrayList;

public final class ag
  extends r
{
  private String XoS;
  private Cursor mNt;
  
  public ag(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), false, false);
    AppMethodBeat.i(102929);
    this.XoS = paramString;
    atr();
    AppMethodBeat.o(102929);
  }
  
  private void atr()
  {
    AppMethodBeat.i(187313);
    h.aHH();
    this.mNt = ((n)h.ae(n.class)).bbL().f(this.XoS, "", csq());
    AppMethodBeat.o(187313);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(187314);
    super.ate();
    atr();
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(187314);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102932);
    super.finish();
    Log.i("MicroMsg.SpecialContactAdapter", "finish!");
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    AppMethodBeat.o(102932);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102930);
    int i = this.mNt.getCount();
    AppMethodBeat.o(102930);
    return i;
  }
  
  protected final a ye(int paramInt)
  {
    AppMethodBeat.i(102931);
    f localf = null;
    if ((paramInt >= 0) && (this.mNt.moveToPosition(paramInt)))
    {
      localf = new f(paramInt);
      as localas = new as();
      localas.convertFrom(this.mNt);
      localf.contact = localas;
      localf.XsX = fJk();
    }
    for (;;)
    {
      AppMethodBeat.o(102931);
      return localf;
      Log.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ag
 * JD-Core Version:    0.7.0.1
 */