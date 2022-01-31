package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends i<f>
{
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS  shakemessage_status_index ON shakemessage ( status )", "CREATE INDEX IF NOT EXISTS shakemessage_type_index ON shakemessage ( type )" };
  public static final String[] dXp = { i.a(f.buS, "shakemessage") };
  public e dXw;
  
  public g(e parame)
  {
    super(parame, f.buS, "shakemessage", cqY);
    this.dXw = parame;
  }
  
  public final boolean a(f paramf)
  {
    if (paramf == null) {
      y.e("MicroMsg.ShakeMessageStorage", "insert fail, shakeMsg is null");
    }
    while (!super.b(paramf)) {
      return false;
    }
    aam(paramf.ujK);
    return true;
  }
  
  public final int aAo()
  {
    Cursor localCursor = this.dXw.a("select count(*) from " + getTableName() + " where status != 1", null, 2);
    if (localCursor.moveToFirst()) {}
    for (int i = localCursor.getInt(0);; i = 0)
    {
      localCursor.close();
      if (i > 0) {
        return i;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.g
 * JD-Core Version:    0.7.0.1
 */