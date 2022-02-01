package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;

public final class bl
  extends j<bk>
  implements f
{
  public static final String[] SQL_CREATE;
  private final l<f.a, bk> Iou;
  private e db;
  
  static
  {
    AppMethodBeat.i(217615);
    SQL_CREATE = new String[] { j.getCreateSQLs(bk.info, "FriendUser") };
    AppMethodBeat.o(217615);
  }
  
  public bl(e parame)
  {
    super(parame, bk.info, "FriendUser", null);
    AppMethodBeat.i(217609);
    this.Iou = new l() {};
    this.db = parame;
    AppMethodBeat.o(217609);
  }
  
  private void b(bk parambk)
  {
    AppMethodBeat.i(217606);
    if (this.Iou.dV(parambk)) {
      this.Iou.doNotify();
    }
    AppMethodBeat.o(217606);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(217607);
    this.Iou.a(parama, null);
    AppMethodBeat.o(217607);
  }
  
  public final bk apO(String paramString)
  {
    AppMethodBeat.i(217610);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(217610);
      return null;
    }
    bk localbk = new bk();
    paramString = this.db.a("FriendUser", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbk.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(217610);
    return localbk;
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(217608);
    this.Iou.remove(parama);
    AppMethodBeat.o(217608);
  }
  
  public final int dlQ()
  {
    AppMethodBeat.i(217611);
    Object localObject = String.format("select count(rowid) from %s", new Object[] { "FriendUser" });
    localObject = this.db.rawQuery((String)localObject, null);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      int i = ((Cursor)localObject).getInt(0);
      ((Cursor)localObject).close();
      ad.i("MicroMsg.FriendUserStorage", "#recordCnts#, count:".concat(String.valueOf(i)));
      AppMethodBeat.o(217611);
      return i;
    }
    AppMethodBeat.o(217611);
    return 0;
  }
  
  public final int dlR()
  {
    AppMethodBeat.i(217612);
    long l = System.currentTimeMillis();
    int i = this.db.delete("FriendUser", "(modifyTime< ?)", new String[] { String.valueOf(l - 604800000L) });
    if (i > 0) {
      doNotify();
    }
    ad.i("MicroMsg.FriendUserStorage", "#Clear Records#, result:".concat(String.valueOf(i)));
    AppMethodBeat.o(217612);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bl
 * JD-Core Version:    0.7.0.1
 */