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
import java.util.List;

public final class i
  extends r
{
  private List<String> afdH;
  private Cursor pKb;
  
  public i(MMBaseSelectContactUI paramMMBaseSelectContactUI, boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    super(paramMMBaseSelectContactUI, paramList2, true, paramBoolean);
    AppMethodBeat.i(252799);
    this.afdH = new ArrayList();
    if (paramList1 != null) {
      this.afdH.addAll(paramList1);
    }
    if (paramList2 != null) {
      this.afdH.removeAll(paramList2);
    }
    if (this.afdH.isEmpty())
    {
      h.baF();
      this.pKb = ((n)h.ax(n.class)).bzA().jaF();
      AppMethodBeat.o(252799);
      return;
    }
    h.baF();
    this.pKb = ((n)h.ax(n.class)).bzA().mQ(this.afdH);
    AppMethodBeat.o(252799);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102843);
    super.finish();
    Log.i("MicroMsg.CustomContactAdapter", "finish!");
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    AppMethodBeat.o(102843);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102841);
    int i = this.pKb.getCount();
    AppMethodBeat.o(102841);
    return i;
  }
  
  protected final a yk(int paramInt)
  {
    AppMethodBeat.i(102842);
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
      AppMethodBeat.o(102842);
      return localf;
      Log.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.i
 * JD-Core Version:    0.7.0.1
 */