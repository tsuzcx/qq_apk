package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.l.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.y;

public final class bw
  extends i<bv>
  implements l
{
  public static final String[] dXp = { i.a(bv.buS, "Stranger") };
  private e dXw;
  private final k<l.a, bv> umW = new k() {};
  
  public bw(e parame)
  {
    super(parame, bv.buS, "Stranger", null);
    this.dXw = parame;
  }
  
  private void b(bv parambv)
  {
    if (this.umW.bV(parambv)) {
      this.umW.doNotify();
    }
  }
  
  public final bv Id(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    bv localbv = new bv();
    paramString = this.dXw.a("Stranger", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbv.d(paramString);
    }
    paramString.close();
    return localbv;
  }
  
  public final int Ie(String paramString)
  {
    int i = this.dXw.delete("Stranger", "(encryptUsername=?)", new String[] { paramString });
    if (i > 0) {
      doNotify();
    }
    y.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + paramString + " result:" + i);
    return i;
  }
  
  public final void a(l.a parama)
  {
    this.umW.a(parama, null);
  }
  
  public final void b(l.a parama)
  {
    this.umW.remove(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bw
 * JD-Core Version:    0.7.0.1
 */