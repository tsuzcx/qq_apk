package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.List;

public final class h
  extends p
{
  private List<String> AcC;
  private Cursor gqa;
  
  public h(MMBaseSelectContactUI paramMMBaseSelectContactUI, boolean paramBoolean, List<String> paramList)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), true, paramBoolean);
    AppMethodBeat.i(105204);
    this.AcC = paramList;
    g.RM();
    this.gqa = ((j)g.E(j.class)).YA().eE(this.AcC);
    AppMethodBeat.o(105204);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(105207);
    super.finish();
    ab.i("MicroMsg.CustomContactAdapter", "finish!");
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    AppMethodBeat.o(105207);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(105205);
    int i = this.gqa.getCount();
    AppMethodBeat.o(105205);
    return i;
  }
  
  protected final a mM(int paramInt)
  {
    AppMethodBeat.i(105206);
    e locale = null;
    if ((paramInt >= 0) && (this.gqa.moveToPosition(paramInt)))
    {
      locale = new e(paramInt);
      ad localad = new ad();
      localad.convertFrom(this.gqa);
      locale.contact = localad;
      locale.Adl = cni();
    }
    for (;;)
    {
      AppMethodBeat.o(105206);
      return locale;
      ab.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.h
 * JD-Core Version:    0.7.0.1
 */