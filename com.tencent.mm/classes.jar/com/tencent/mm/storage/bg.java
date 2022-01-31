package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class bg
  extends com.tencent.mm.sdk.e.j<bf>
  implements f
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(1318);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(bf.info, "LBSVerifyMessage") };
    AppMethodBeat.o(1318);
  }
  
  public bg(e parame)
  {
    super(parame, bf.info, "LBSVerifyMessage", cu.INDEX_CREATE);
    this.db = parame;
  }
  
  public final Cursor Nw(int paramInt)
  {
    AppMethodBeat.i(1308);
    Object localObject = "SELECT sayhiencryptuser,max(createtime) createtime FROM " + getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + paramInt;
    localObject = "SELECT a.* FROM (" + (String)localObject + ") b left join " + getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(1308);
    return localObject;
  }
  
  public final void Te(String paramString)
  {
    AppMethodBeat.i(1309);
    paramString = "svrid = '" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    ab.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(i)));
    AppMethodBeat.o(1309);
  }
  
  public final void Tf(String paramString)
  {
    AppMethodBeat.i(1310);
    paramString = "sayhiuser = '" + paramString + "' or sayhiencryptuser='" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    ab.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = ".concat(String.valueOf(i)));
    AppMethodBeat.o(1310);
  }
  
  public final long Tg(String paramString)
  {
    AppMethodBeat.i(1316);
    Cursor localCursor;
    if (paramString != null)
    {
      paramString = (bg)((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPN();
      localCursor = paramString.db.a("SELECT * FROM " + paramString.getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
      if (localCursor == null)
      {
        paramString = null;
        if (paramString == null) {
          break label157;
        }
      }
    }
    label157:
    for (long l1 = paramString.field_createtime + 1L;; l1 = 0L)
    {
      long l2 = bo.aox();
      if (l1 > l2)
      {
        AppMethodBeat.o(1316);
        return l1;
        if (!localCursor.moveToFirst())
        {
          localCursor.close();
          paramString = null;
          break;
        }
        paramString = new bf();
        paramString.convertFrom(localCursor);
        localCursor.close();
        break;
      }
      AppMethodBeat.o(1316);
      return l2;
    }
  }
  
  public final boolean a(bf parambf)
  {
    AppMethodBeat.i(1312);
    if (parambf == null)
    {
      ab.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
      AppMethodBeat.o(1312);
      return false;
    }
    if (super.insert(parambf))
    {
      doNotify(parambf.systemRowid);
      AppMethodBeat.o(1312);
      return true;
    }
    AppMethodBeat.o(1312);
    return false;
  }
  
  public final bf[] asg(String paramString)
  {
    AppMethodBeat.i(1313);
    ab.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where sayhiuser = '" + bo.wC(paramString) + "' or sayhiencryptuser = '" + bo.wC(paramString) + "' order by createtime DESC limit 3";
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bf localbf = new bf();
      localbf.convertFrom(paramString);
      localArrayList.add(localbf);
    }
    paramString.close();
    paramString = (bf[])localArrayList.toArray(new bf[localArrayList.size()]);
    AppMethodBeat.o(1313);
    return paramString;
  }
  
  public final bf ash(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(1314);
    ab.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + bo.wC(paramString) + "' or sayhiencryptuser = '" + bo.wC(paramString) + "') and flag=1 order by createtime DESC limit 1";
    Cursor localCursor = this.db.a(paramString, null, 2);
    if (localCursor.moveToFirst())
    {
      paramString = new bf();
      paramString.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      AppMethodBeat.o(1314);
      return paramString;
      ab.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
      paramString = localObject;
    }
  }
  
  public final void axH()
  {
    AppMethodBeat.i(1311);
    this.db.delete(getTableName(), null, null);
    AppMethodBeat.o(1311);
  }
  
  public final bf bPW()
  {
    AppMethodBeat.i(1306);
    Cursor localCursor = this.db.a("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(1306);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(1306);
      return null;
    }
    bf localbf = new bf();
    localbf.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(1306);
    return localbf;
  }
  
  public final int bbZ()
  {
    AppMethodBeat.i(1304);
    Cursor localCursor = this.db.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(1304);
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    AppMethodBeat.o(1304);
    return i;
  }
  
  public final bf[] eF(String paramString, int paramInt)
  {
    AppMethodBeat.i(1315);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
      AppMethodBeat.o(1315);
      return null;
    }
    paramString = "select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + bo.wC(paramString) + "' or sayhiencryptuser = '" + bo.wC(paramString) + "') order by createTime DESC limit " + paramInt;
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bf localbf = new bf();
      localbf.convertFrom(paramString);
      localArrayList.add(localbf);
    }
    paramString.close();
    paramString = (bf[])localArrayList.toArray(new bf[localArrayList.size()]);
    AppMethodBeat.o(1315);
    return paramString;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(1305);
    Cursor localCursor = this.db.a("select count(*) from " + getTableName(), null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(1305);
    return i;
  }
  
  public final Cursor xL(int paramInt)
  {
    AppMethodBeat.i(1307);
    Object localObject = "SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(1307);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bg
 * JD-Core Version:    0.7.0.1
 */