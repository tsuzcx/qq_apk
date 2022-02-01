package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;

public final class cf
  extends j<ce>
  implements m
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(117342);
    SQL_CREATE = new String[] { j.getCreateSQLs(ce.info, "shakeverifymessage") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )" };
    AppMethodBeat.o(117342);
  }
  
  public cf(e parame)
  {
    super(parame, ce.info, "shakeverifymessage", INDEX_CREATE);
    this.db = parame;
  }
  
  public final Cursor Jc(int paramInt)
  {
    AppMethodBeat.i(117334);
    Object localObject = "SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117334);
    return localObject;
  }
  
  public final boolean a(ce paramce)
  {
    AppMethodBeat.i(117337);
    if (paramce == null)
    {
      ae.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
      AppMethodBeat.o(117337);
      return false;
    }
    if (super.insert(paramce))
    {
      doNotify(paramce.systemRowid);
      AppMethodBeat.o(117337);
      return true;
    }
    AppMethodBeat.o(117337);
    return false;
  }
  
  public final ce[] aVY(String paramString)
  {
    AppMethodBeat.i(117339);
    ae.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
    paramString = "select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + bu.aSk(paramString) + "' order by createtime DESC limit 3";
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      ce localce = new ce();
      localce.convertFrom(paramString);
      localArrayList.add(localce);
    }
    paramString.close();
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(117339);
      return null;
    }
    paramString = (ce[])localArrayList.toArray(new ce[localArrayList.size()]);
    AppMethodBeat.o(117339);
    return paramString;
  }
  
  public final void aqU(String paramString)
  {
    AppMethodBeat.i(117335);
    paramString = "svrid = '" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    ae.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117335);
  }
  
  public final long aqW(String paramString)
  {
    AppMethodBeat.i(117340);
    if (paramString != null)
    {
      paramString = ((cf)((l)g.ab(l.class)).doF()).fwL();
      if (paramString == null) {}
    }
    for (long l1 = paramString.field_createtime + 1L;; l1 = 0L)
    {
      long l2 = bu.aRi();
      if (l1 > l2)
      {
        AppMethodBeat.o(117340);
        return l1;
      }
      AppMethodBeat.o(117340);
      return l2;
    }
  }
  
  public final int bVY()
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
  
  public final void bdi()
  {
    AppMethodBeat.i(117336);
    this.db.delete(getTableName(), null, null);
    AppMethodBeat.o(117336);
  }
  
  public final ce fwL()
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
    ce localce = new ce();
    localce.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(117333);
    return localce;
  }
  
  public final ce[] gA(String paramString, int paramInt)
  {
    AppMethodBeat.i(117338);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
      AppMethodBeat.o(117338);
      return null;
    }
    paramString = "select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + bu.aSk(paramString) + "' order by createTime DESC limit " + paramInt;
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      ce localce = new ce();
      localce.convertFrom(paramString);
      localArrayList.add(localce);
    }
    paramString.close();
    if (localArrayList.size() == 0)
    {
      AppMethodBeat.o(117338);
      return null;
    }
    paramString = (ce[])localArrayList.toArray(new ce[localArrayList.size()]);
    AppMethodBeat.o(117338);
    return paramString;
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
 * Qualified Name:     com.tencent.mm.storage.cf
 * JD-Core Version:    0.7.0.1
 */