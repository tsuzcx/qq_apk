package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import java.util.ArrayList;

public final class al
  extends r
{
  private String afau;
  private Cursor pKb;
  
  public al(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), false, false);
    AppMethodBeat.i(102929);
    this.afau = paramString;
    aNy();
    AppMethodBeat.o(102929);
  }
  
  private void aNy()
  {
    AppMethodBeat.i(252782);
    h.baF();
    this.pKb = ((n)h.ax(n.class)).bzA().h(this.afau, "", cVa());
    AppMethodBeat.o(252782);
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(252788);
    super.aNm();
    aNy();
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(252788);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102932);
    super.finish();
    Log.i("MicroMsg.SpecialContactAdapter", "finish!");
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    AppMethodBeat.o(102932);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102930);
    int i = this.pKb.getCount();
    AppMethodBeat.o(102930);
    return i;
  }
  
  protected final a yk(int paramInt)
  {
    AppMethodBeat.i(102931);
    f localf = null;
    if ((paramInt >= 0) && (this.pKb.moveToPosition(paramInt)))
    {
      localf = new f(paramInt);
      au localau = new au();
      localau.convertFrom(this.pKb);
      localf.contact = localau;
      localf.afey = gZe();
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
 * Qualified Name:     com.tencent.mm.ui.contact.al
 * JD-Core Version:    0.7.0.1
 */