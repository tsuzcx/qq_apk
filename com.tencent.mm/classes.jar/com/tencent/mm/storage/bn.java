package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;

public final class bn
  extends i<bm>
{
  public static final String[] dXp = { i.a(bm.buS, "NewTipsInfo") };
  public e dXw;
  
  public bn(e parame)
  {
    super(parame, bm.buS, "NewTipsInfo", null);
    this.dXw = parame;
  }
  
  public final bm Fr(int paramInt)
  {
    if (this.dXw == null)
    {
      y.e("MicroMsg.NewTipsInfoStorage", "getByTipsId, but db is null, return");
      return null;
    }
    Cursor localCursor = this.dXw.a("NewTipsInfo", null, "tipId=?", new String[] { String.valueOf(paramInt) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      bm localbm = new bm();
      try
      {
        localbm.d(localCursor);
        localCursor.close();
        return localbm;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.NewTipsInfoStorage", "getByTipsId convertFrom(cu) cause IlleagalStateException, return null");
        localCursor.close();
        return null;
      }
    }
    y.w("MicroMsg.NewTipsInfoStorage", "getByTipsId:%d, no data", new Object[] { Integer.valueOf(paramInt) });
    localCursor.close();
    return null;
  }
  
  public final boolean a(bm parambm, String... paramVarArgs)
  {
    if (parambm == null)
    {
      y.e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
      return false;
    }
    boolean bool = super.b(parambm, false, paramVarArgs);
    if (bool) {
      b(parambm.field_tipId, 3, Integer.valueOf(parambm.field_tipId));
    }
    y.d("MicroMsg.NewTipsInfoStorage", "update result[%B]", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean f(bm parambm)
  {
    boolean bool1 = false;
    if (parambm == null) {
      y.e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
    }
    boolean bool2;
    do
    {
      return bool1;
      if (parambm.field_tipId <= 0)
      {
        y.e("MicroMsg.NewTipsInfoStorage", "newTipsId is error, tipsId = %s", new Object[] { Integer.valueOf(parambm.field_tipId) });
        return false;
      }
      bool2 = a(parambm, false);
      bool1 = bool2;
    } while (!bool2);
    b(parambm.field_tipId, 2, Integer.valueOf(parambm.field_tipId));
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bn
 * JD-Core Version:    0.7.0.1
 */