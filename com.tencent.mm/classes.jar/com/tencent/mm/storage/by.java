package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;

public final class by
  extends j<bx>
  implements l
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(117342);
    SQL_CREATE = new String[] { j.getCreateSQLs(bx.info, "shakeverifymessage") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )" };
    AppMethodBeat.o(117342);
  }
  
  public by(e parame)
  {
    super(parame, bx.info, "shakeverifymessage", INDEX_CREATE);
    this.db = parame;
  }
  
  public final Cursor Hi(int paramInt)
  {
    AppMethodBeat.i(117334);
    Object localObject = "SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117334);
    return localObject;
  }
  
  public final boolean a(bx parambx)
  {
    AppMethodBeat.i(117337);
    if (parambx == null)
    {
      ac.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
      AppMethodBeat.o(117337);
      return false;
    }
    if (super.insert(parambx))
    {
      doNotify(parambx.systemRowid);
      AppMethodBeat.o(117337);
      return true;
    }
    AppMethodBeat.o(117337);
    return false;
  }
  
  public final bx[] aOG(String paramString)
  {
    AppMethodBeat.i(117339);
    ac.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
    paramString = "select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + bs.aLh(paramString) + "' order by createtime DESC limit 3";
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bx localbx = new bx();
      localbx.convertFrom(paramString);
      localArrayList.add(localbx);
    }
    paramString.close();
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(117339);
      return null;
    }
    paramString = (bx[])localArrayList.toArray(new bx[localArrayList.size()]);
    AppMethodBeat.o(117339);
    return paramString;
  }
  
  public final void aZf()
  {
    AppMethodBeat.i(117336);
    this.db.delete(getTableName(), null, null);
    AppMethodBeat.o(117336);
  }
  
  public final void alc(String paramString)
  {
    AppMethodBeat.i(117335);
    paramString = "svrid = '" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    ac.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117335);
  }
  
  public final long ale(String paramString)
  {
    AppMethodBeat.i(117340);
    if (paramString != null)
    {
      paramString = ((by)((k)g.ab(k.class)).dcn()).fcD();
      if (paramString == null) {}
    }
    for (long l1 = paramString.field_createtime + 1L;; l1 = 0L)
    {
      long l2 = bs.aNx();
      if (l1 > l2)
      {
        AppMethodBeat.o(117340);
        return l1;
      }
      AppMethodBeat.o(117340);
      return l2;
    }
  }
  
  public final int bQe()
  {
    AppMethodBeat.i(117331);
    Cursor localCursor = this.db.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(117331);
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    if (i > 0)
    {
      AppMethodBeat.o(117331);
      return i;
    }
    AppMethodBeat.o(117331);
    return 0;
  }
  
  public final bx[] fU(String paramString, int paramInt)
  {
    AppMethodBeat.i(117338);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
      AppMethodBeat.o(117338);
      return null;
    }
    paramString = "select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + bs.aLh(paramString) + "' order by createTime DESC limit " + paramInt;
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bx localbx = new bx();
      localbx.convertFrom(paramString);
      localArrayList.add(localbx);
    }
    paramString.close();
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(117338);
      return null;
    }
    paramString = (bx[])localArrayList.toArray(new bx[localArrayList.size()]);
    AppMethodBeat.o(117338);
    return paramString;
  }
  
  public final bx fcD()
  {
    AppMethodBeat.i(117333);
    Cursor localCursor = this.db.a("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(117333);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(117333);
      return null;
    }
    bx localbx = new bx();
    localbx.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(117333);
    return localbx;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(117332);
    Cursor localCursor = this.db.a("select count(*) from " + getTableName(), null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(117332);
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    if (i > 0)
    {
      AppMethodBeat.o(117332);
      return i;
    }
    AppMethodBeat.o(117332);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.by
 * JD-Core Version:    0.7.0.1
 */