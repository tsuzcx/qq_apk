package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;

public final class by
  extends MAutoStorage<bx>
  implements com.tencent.mm.plugin.messenger.foundation.a.a.g
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(117186);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(bx.info, "LBSVerifyMessage") };
    AppMethodBeat.o(117186);
  }
  
  public by(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, bx.info, "LBSVerifyMessage", eb.INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final Cursor Pf(int paramInt)
  {
    AppMethodBeat.i(117175);
    Object localObject = "SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117175);
    return localObject;
  }
  
  public final boolean a(bx parambx)
  {
    AppMethodBeat.i(117180);
    if (parambx == null)
    {
      Log.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
      AppMethodBeat.o(117180);
      return false;
    }
    if (super.insert(parambx))
    {
      doNotify(parambx.systemRowid);
      AppMethodBeat.o(117180);
      return true;
    }
    AppMethodBeat.o(117180);
    return false;
  }
  
  public final void aEp(String paramString)
  {
    AppMethodBeat.i(117177);
    paramString = "svrid = '" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    Log.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117177);
  }
  
  public final void aEq(String paramString)
  {
    AppMethodBeat.i(117178);
    paramString = "sayhiuser = '" + paramString + "' or sayhiencryptuser='" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    Log.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117178);
  }
  
  public final long aEr(String paramString)
  {
    AppMethodBeat.i(117184);
    Cursor localCursor;
    if (paramString != null)
    {
      paramString = (by)((l)com.tencent.mm.kernel.g.af(l.class)).eiv();
      localCursor = paramString.db.rawQuery("SELECT * FROM " + paramString.getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
      if (localCursor == null)
      {
        paramString = null;
        if (paramString == null) {
          break label154;
        }
      }
    }
    label154:
    for (long l1 = paramString.field_createtime + 1L;; l1 = 0L)
    {
      long l2 = Util.nowSecond();
      if (l1 > l2)
      {
        AppMethodBeat.o(117184);
        return l1;
        if (!localCursor.moveToFirst())
        {
          localCursor.close();
          paramString = null;
          break;
        }
        paramString = new bx();
        paramString.convertFrom(localCursor);
        localCursor.close();
        break;
      }
      AppMethodBeat.o(117184);
      return l2;
    }
  }
  
  public final Cursor akl(int paramInt)
  {
    AppMethodBeat.i(117176);
    Object localObject = "SELECT sayhiencryptuser,max(createtime) createtime FROM " + getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + paramInt;
    localObject = "SELECT a.* FROM (" + (String)localObject + ") b left join " + getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117176);
    return localObject;
  }
  
  public final bx[] bkx(String paramString)
  {
    AppMethodBeat.i(117181);
    Log.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where sayhiuser = '" + Util.escapeSqlValue(paramString) + "' or sayhiencryptuser = '" + Util.escapeSqlValue(paramString) + "' order by createtime DESC limit 3";
    paramString = this.db.rawQuery(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bx localbx = new bx();
      localbx.convertFrom(paramString);
      localArrayList.add(localbx);
    }
    paramString.close();
    paramString = (bx[])localArrayList.toArray(new bx[localArrayList.size()]);
    AppMethodBeat.o(117181);
    return paramString;
  }
  
  public final bx bky(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117182);
    Log.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + Util.escapeSqlValue(paramString) + "' or sayhiencryptuser = '" + Util.escapeSqlValue(paramString) + "') and flag=1 order by createtime DESC limit 1";
    Cursor localCursor = this.db.rawQuery(paramString, null, 2);
    if (localCursor.moveToFirst())
    {
      paramString = new bx();
      paramString.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      AppMethodBeat.o(117182);
      return paramString;
      Log.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
      paramString = localObject;
    }
  }
  
  public final void byC()
  {
    AppMethodBeat.i(117179);
    this.db.delete(getTableName(), null, null);
    AppMethodBeat.o(117179);
  }
  
  public final int ctM()
  {
    AppMethodBeat.i(117172);
    Cursor localCursor = this.db.rawQuery("select count(*) from " + getTableName() + " where status != 4", null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(117172);
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    AppMethodBeat.o(117172);
    return i;
  }
  
  public final bx eiG()
  {
    AppMethodBeat.i(117174);
    Cursor localCursor = this.db.rawQuery("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(117174);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(117174);
      return null;
    }
    bx localbx = new bx();
    localbx.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(117174);
    return localbx;
  }
  
  public final bx[] gR(String paramString, int paramInt)
  {
    AppMethodBeat.i(117183);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
      AppMethodBeat.o(117183);
      return null;
    }
    paramString = "select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + Util.escapeSqlValue(paramString) + "' or sayhiencryptuser = '" + Util.escapeSqlValue(paramString) + "') order by createTime DESC limit " + paramInt;
    paramString = this.db.rawQuery(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bx localbx = new bx();
      localbx.convertFrom(paramString);
      localArrayList.add(localbx);
    }
    paramString.close();
    paramString = (bx[])localArrayList.toArray(new bx[localArrayList.size()]);
    AppMethodBeat.o(117183);
    return paramString;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(117173);
    Cursor localCursor = this.db.rawQuery("select count(*) from " + getTableName(), null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(117173);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.by
 * JD-Core Version:    0.7.0.1
 */