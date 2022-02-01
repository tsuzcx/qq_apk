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
import java.util.List;

public final class i
  extends r
{
  private List<String> Xsg;
  private Cursor mNt;
  
  public i(MMBaseSelectContactUI paramMMBaseSelectContactUI, boolean paramBoolean, List<String> paramList)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), true, paramBoolean);
    AppMethodBeat.i(102840);
    this.Xsg = paramList;
    h.aHH();
    this.mNt = ((n)h.ae(n.class)).bbL().jD(this.Xsg);
    AppMethodBeat.o(102840);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102843);
    super.finish();
    Log.i("MicroMsg.CustomContactAdapter", "finish!");
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    AppMethodBeat.o(102843);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102841);
    int i = this.mNt.getCount();
    AppMethodBeat.o(102841);
    return i;
  }
  
  protected final a ye(int paramInt)
  {
    AppMethodBeat.i(102842);
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