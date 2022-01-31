package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class bu
  extends com.tencent.mm.sdk.e.j<bt>
  implements l
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(1472);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(bt.info, "shakeverifymessage") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )" };
    AppMethodBeat.o(1472);
  }
  
  public bu(e parame)
  {
    super(parame, bt.info, "shakeverifymessage", INDEX_CREATE);
    this.db = parame;
  }
  
  public final void Te(String paramString)
  {
    AppMethodBeat.i(1465);
    paramString = "svrid = '" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    ab.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(i)));
    AppMethodBeat.o(1465);
  }
  
  public final long Tg(String paramString)
  {
    AppMethodBeat.i(1470);
    if (paramString != null)
    {
      paramString = ((bu)((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPM()).dyP();
      if (paramString == null) {}
    }
    for (long l1 = paramString.field_createtime + 1L;; l1 = 0L)
    {
      long l2 = bo.aox();
      if (l1 > l2)
      {
        AppMethodBeat.o(1470);
        return l1;
      }
      AppMethodBeat.o(1470);
      return l2;
    }
  }
  
  public final boolean a(bt parambt)
  {
    AppMethodBeat.i(1467);
    if (parambt == null)
    {
      ab.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
      AppMethodBeat.o(1467);
      return false;
    }
    if (super.insert(parambt))
    {
      doNotify(parambt.systemRowid);
      AppMethodBeat.o(1467);
      return true;
    }
    AppMethodBeat.o(1467);
    return false;
  }
  
  public final bt[] asF(String paramString)
  {
    AppMethodBeat.i(1469);
    ab.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
    paramString = "select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + bo.wC(paramString) + "' order by createtime DESC limit 3";
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bt localbt = new bt();
      localbt.convertFrom(paramString);
      localArrayList.add(localbt);
    }
    paramString.close();
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(1469);
      return null;
    }
    paramString = (bt[])localArrayList.toArray(new bt[localArrayList.size()]);
    AppMethodBeat.o(1469);
    return paramString;
  }
  
  public final void axH()
  {
    AppMethodBeat.i(1466);
    this.db.delete(getTableName(), null, null);
    AppMethodBeat.o(1466);
  }
  
  public final int bbZ()
  {
    AppMethodBeat.i(1461);
    Cursor localCursor = this.db.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(1461);
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    if (i > 0)
    {
      AppMethodBeat.o(1461);
      return i;
    }
    AppMethodBeat.o(1461);
    return 0;
  }
  
  public final bt dyP()
  {
    AppMethodBeat.i(1463);
    Cursor localCursor = this.db.a("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(1463);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(1463);
      return null;
    }
    bt localbt = new bt();
    localbt.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(1463);
    return localbt;
  }
  
  public final bt[] eH(String paramString, int paramInt)
  {
    AppMethodBeat.i(1468);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
      AppMethodBeat.o(1468);
      return null;
    }
    paramString = "select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + bo.wC(paramString) + "' order by createTime DESC limit " + paramInt;
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bt localbt = new bt();
      localbt.convertFrom(paramString);
      localArrayList.add(localbt);
    }
    paramString.close();
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(1468);
      return null;
    }
    paramString = (bt[])localArrayList.toArray(new bt[localArrayList.size()]);
    AppMethodBeat.o(1468);
    return paramString;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(1462);
    Cursor localCursor = this.db.a("select count(*) from " + getTableName(), null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(1462);
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    if (i > 0)
    {
      AppMethodBeat.o(1462);
      return i;
    }
    AppMethodBeat.o(1462);
    return 0;
  }
  
  public final Cursor xL(int paramInt)
  {
    AppMethodBeat.i(1464);
    Object localObject = "SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(1464);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.bu
 * JD-Core Version:    0.7.0.1
 */