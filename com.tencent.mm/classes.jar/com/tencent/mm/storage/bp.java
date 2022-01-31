package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class bp
  extends i<bo>
{
  public static final String[] dXp = { i.a(bo.buS, "OpenMsgListener") };
  public e dXw;
  
  public bp(e parame)
  {
    super(parame, bo.buS, "OpenMsgListener", null);
    this.dXw = parame;
    parame.gk("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
    parame.gk("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
  }
  
  public final bo acj(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    Cursor localCursor = this.dXw.a("OpenMsgListener", null, "appId=?", new String[] { bk.pl(paramString) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      y.w("MicroMsg.OpenMsgListenerStorage", "get null with appId:" + paramString);
      localCursor.close();
      return null;
    }
    paramString = new bo();
    paramString.d(localCursor);
    localCursor.close();
    return paramString;
  }
  
  public final Cursor cvU()
  {
    return rawQuery("select * from OpenMsgListener where (status = ?) ", new String[] { "1" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bp
 * JD-Core Version:    0.7.0.1
 */