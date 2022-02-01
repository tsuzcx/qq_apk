package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dv;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;

public final class bt
  extends j<bs>
  implements com.tencent.mm.plugin.messenger.foundation.a.a.g
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(117186);
    SQL_CREATE = new String[] { j.getCreateSQLs(bs.info, "LBSVerifyMessage") };
    AppMethodBeat.o(117186);
  }
  
  public bt(e parame)
  {
    super(parame, bs.info, "LBSVerifyMessage", dv.INDEX_CREATE);
    this.db = parame;
  }
  
  public final Cursor Jc(int paramInt)
  {
    AppMethodBeat.i(117175);
    Object localObject = "SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117175);
    return localObject;
  }
  
  public final boolean a(bs parambs)
  {
    AppMethodBeat.i(117180);
    if (parambs == null)
    {
      ae.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
      AppMethodBeat.o(117180);
      return false;
    }
    if (super.insert(parambs))
    {
      doNotify(parambs.systemRowid);
      AppMethodBeat.o(117180);
      return true;
    }
    AppMethodBeat.o(117180);
    return false;
  }
  
  public final bs aVA(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117182);
    ae.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + bu.aSk(paramString) + "' or sayhiencryptuser = '" + bu.aSk(paramString) + "') and flag=1 order by createtime DESC limit 1";
    Cursor localCursor = this.db.a(paramString, null, 2);
    if (localCursor.moveToFirst())
    {
      paramString = new bs();
      paramString.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      AppMethodBeat.o(117182);
      return paramString;
      ae.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
      paramString = localObject;
    }
  }
  
  public final bs[] aVz(String paramString)
  {
    AppMethodBeat.i(117181);
    ae.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where sayhiuser = '" + bu.aSk(paramString) + "' or sayhiencryptuser = '" + bu.aSk(paramString) + "' order by createtime DESC limit 3";
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bs localbs = new bs();
      localbs.convertFrom(paramString);
      localArrayList.add(localbs);
    }
    paramString.close();
    paramString = (bs[])localArrayList.toArray(new bs[localArrayList.size()]);
    AppMethodBeat.o(117181);
    return paramString;
  }
  
  public final Cursor abD(int paramInt)
  {
    AppMethodBeat.i(117176);
    Object localObject = "SELECT sayhiencryptuser,max(createtime) createtime FROM " + getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + paramInt;
    localObject = "SELECT a.* FROM (" + (String)localObject + ") b left join " + getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117176);
    return localObject;
  }
  
  public final void aqU(String paramString)
  {
    AppMethodBeat.i(117177);
    paramString = "svrid = '" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    ae.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117177);
  }
  
  public final void aqV(String paramString)
  {
    AppMethodBeat.i(117178);
    paramString = "sayhiuser = '" + paramString + "' or sayhiencryptuser='" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    ae.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117178);
  }
  
  public final long aqW(String paramString)
  {
    AppMethodBeat.i(117184);
    Cursor localCursor;
    if (paramString != null)
    {
      paramString = (bt)((l)com.tencent.mm.kernel.g.ab(l.class)).doG();
      localCursor = paramString.db.a("SELECT * FROM " + paramString.getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
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
      long l2 = bu.aRi();
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
        paramString = new bs();
        paramString.convertFrom(localCursor);
        localCursor.close();
        break;
      }
      AppMethodBeat.o(117184);
      return l2;
    }
  }
  
  public final int bVY()
  {
    AppMethodBeat.i(117172);
    Cursor localCursor = this.db.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
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
  
  public final void bdi()
  {
    AppMethodBeat.i(117179);
    this.db.delete(getTableName(), null, null);
    AppMethodBeat.o(117179);
  }
  
  public final bs doR()
  {
    AppMethodBeat.i(117174);
    Cursor localCursor = this.db.a("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
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
    bs localbs = new bs();
    localbs.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(117174);
    return localbs;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(117173);
    Cursor localCursor = this.db.a("select count(*) from " + getTableName(), null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(117173);
    return i;
  }
  
  public final bs[] gy(String paramString, int paramInt)
  {
    AppMethodBeat.i(117183);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
      AppMethodBeat.o(117183);
      return null;
    }
    paramString = "select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + bu.aSk(paramString) + "' or sayhiencryptuser = '" + bu.aSk(paramString) + "') order by createTime DESC limit " + paramInt;
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bs localbs = new bs();
      localbs.convertFrom(paramString);
      localArrayList.add(localbs);
    }
    paramString.close();
    paramString = (bs[])localArrayList.toArray(new bs[localArrayList.size()]);
    AppMethodBeat.o(117183);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.bt
 * JD-Core Version:    0.7.0.1
 */