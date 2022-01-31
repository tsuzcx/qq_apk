package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import java.util.ArrayList;

public final class aa
  extends o
{
  private Cursor eYd;
  private String vIs;
  
  public aa(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, new ArrayList(), false, false);
    this.vIs = paramString;
    g.DQ();
    this.eYd = ((j)g.r(j.class)).Fw().d(this.vIs, "", this.dru);
  }
  
  public final void finish()
  {
    super.finish();
    y.i("MicroMsg.SpecialContactAdapter", "finish!");
    if (this.eYd != null)
    {
      this.eYd.close();
      this.eYd = null;
    }
  }
  
  public final int getCount()
  {
    return this.eYd.getCount();
  }
  
  protected final a jQ(int paramInt)
  {
    if ((paramInt >= 0) && (this.eYd.moveToPosition(paramInt)))
    {
      d locald = new d(paramInt);
      ad localad = new ad();
      localad.d(this.eYd);
      locald.dnp = localad;
      locald.vLJ = bBJ();
      return locald;
    }
    y.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.aa
 * JD-Core Version:    0.7.0.1
 */