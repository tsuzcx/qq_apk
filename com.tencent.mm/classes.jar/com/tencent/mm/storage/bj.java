package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;

public final class bj
  extends j<bi>
  implements f
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(117186);
    SQL_CREATE = new String[] { j.getCreateSQLs(bi.info, "LBSVerifyMessage") };
    AppMethodBeat.o(117186);
  }
  
  public bj(e parame)
  {
    super(parame, bi.info, "LBSVerifyMessage", dj.INDEX_CREATE);
    this.db = parame;
  }
  
  public final Cursor Fn(int paramInt)
  {
    AppMethodBeat.i(117175);
    Object localObject = "SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117175);
    return localObject;
  }
  
  public final Cursor WC(int paramInt)
  {
    AppMethodBeat.i(117176);
    Object localObject = "SELECT sayhiencryptuser,max(createtime) createtime FROM " + getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + paramInt;
    localObject = "SELECT a.* FROM (" + (String)localObject + ") b left join " + getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + paramInt;
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(117176);
    return localObject;
  }
  
  public final boolean a(bi parambi)
  {
    AppMethodBeat.i(117180);
    if (parambi == null)
    {
      ad.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
      AppMethodBeat.o(117180);
      return false;
    }
    if (super.insert(parambi))
    {
      doNotify(parambi.systemRowid);
      AppMethodBeat.o(117180);
      return true;
    }
    AppMethodBeat.o(117180);
    return false;
  }
  
  public final bi[] aIL(String paramString)
  {
    AppMethodBeat.i(117181);
    ad.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where sayhiuser = '" + bt.aFQ(paramString) + "' or sayhiencryptuser = '" + bt.aFQ(paramString) + "' order by createtime DESC limit 3";
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bi localbi = new bi();
      localbi.convertFrom(paramString);
      localArrayList.add(localbi);
    }
    paramString.close();
    paramString = (bi[])localArrayList.toArray(new bi[localArrayList.size()]);
    AppMethodBeat.o(117181);
    return paramString;
  }
  
  public final bi aIM(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(117182);
    ad.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + bt.aFQ(paramString) + "' or sayhiencryptuser = '" + bt.aFQ(paramString) + "') and flag=1 order by createtime DESC limit 1";
    Cursor localCursor = this.db.a(paramString, null, 2);
    if (localCursor.moveToFirst())
    {
      paramString = new bi();
      paramString.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      AppMethodBeat.o(117182);
      return paramString;
      ad.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
      paramString = localObject;
    }
  }
  
  public final void aSi()
  {
    AppMethodBeat.i(117179);
    this.db.delete(getTableName(), null, null);
    AppMethodBeat.o(117179);
  }
  
  public final void agi(String paramString)
  {
    AppMethodBeat.i(117177);
    paramString = "svrid = '" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    ad.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117177);
  }
  
  public final void agj(String paramString)
  {
    AppMethodBeat.i(117178);
    paramString = "sayhiuser = '" + paramString + "' or sayhiencryptuser='" + paramString + "'";
    int i = this.db.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    ad.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = ".concat(String.valueOf(i)));
    AppMethodBeat.o(117178);
  }
  
  public final long agk(String paramString)
  {
    AppMethodBeat.i(117184);
    Cursor localCursor;
    if (paramString != null)
    {
      paramString = (bj)((k)g.ab(k.class)).cOF();
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
      long l2 = bt.aGK();
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
        paramString = new bi();
        paramString.convertFrom(localCursor);
        localCursor.close();
        break;
      }
      AppMethodBeat.o(117184);
      return l2;
    }
  }
  
  public final int bIR()
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
  
  public final bi cOP()
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
    bi localbi = new bi();
    localbi.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(117174);
    return localbi;
  }
  
  public final bi[] fO(String paramString, int paramInt)
  {
    AppMethodBeat.i(117183);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
      AppMethodBeat.o(117183);
      return null;
    }
    paramString = "select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + bt.aFQ(paramString) + "' or sayhiencryptuser = '" + bt.aFQ(paramString) + "') order by createTime DESC limit " + paramInt;
    paramString = this.db.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bi localbi = new bi();
      localbi.convertFrom(paramString);
      localArrayList.add(localbi);
    }
    paramString.close();
    paramString = (bi[])localArrayList.toArray(new bi[localArrayList.size()]);
    AppMethodBeat.o(117183);
    return paramString;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.bj
 * JD-Core Version:    0.7.0.1
 */