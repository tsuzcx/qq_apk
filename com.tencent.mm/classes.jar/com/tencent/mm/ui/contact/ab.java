package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;

public final class ab
  extends p
{
  private Cursor gqa;
  private String zZK;
  
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), false, false);
    AppMethodBeat.i(105265);
    this.zZK = paramString;
    g.RM();
    this.gqa = ((j)g.E(j.class)).YA().e(this.zZK, "", this.ejc);
    AppMethodBeat.o(105265);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(105268);
    super.finish();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SpecialContactAdapter", "finish!");
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    AppMethodBeat.o(105268);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(105266);
    int i = this.gqa.getCount();
    AppMethodBeat.o(105266);
    return i;
  }
  
  protected final a mM(int paramInt)
  {
    AppMethodBeat.i(105267);
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
      AppMethodBeat.o(105267);
      return locale;
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ab
 * JD-Core Version:    0.7.0.1
 */