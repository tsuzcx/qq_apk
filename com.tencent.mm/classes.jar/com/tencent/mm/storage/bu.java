package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class bu
  extends i<bt>
  implements k
{
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )" };
  public static final String[] dXp = { i.a(bt.buS, "shakeverifymessage") };
  public e dXw;
  
  public bu(e parame)
  {
    super(parame, bt.buS, "shakeverifymessage", cqY);
    this.dXw = parame;
  }
  
  public final void Hs(String paramString)
  {
    paramString = "svrid = '" + paramString + "'";
    int i = this.dXw.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    y.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = " + i);
  }
  
  public final long Hu(String paramString)
  {
    if (paramString != null)
    {
      paramString = ((bu)((j)g.r(j.class)).bhK()).cwd();
      if (paramString == null) {}
    }
    for (long l1 = paramString.field_createtime + 1L;; l1 = 0L)
    {
      long l2 = bk.UX();
      if (l1 > l2) {
        return l1;
      }
      return l2;
    }
  }
  
  public final boolean a(bt parambt)
  {
    if (parambt == null) {
      y.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
    }
    while (!super.b(parambt)) {
      return false;
    }
    aam(parambt.ujK);
    return true;
  }
  
  public final int aAo()
  {
    Cursor localCursor = this.dXw.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
    if (!localCursor.moveToFirst()) {
      localCursor.close();
    }
    int i;
    do
    {
      return 0;
      i = localCursor.getInt(0);
      localCursor.close();
    } while (i <= 0);
    return i;
  }
  
  public final void aUK()
  {
    this.dXw.delete(getTableName(), null, null);
  }
  
  public final bt[] act(String paramString)
  {
    y.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
    paramString = "select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + bk.pl(paramString) + "' order by createtime DESC limit 3";
    paramString = this.dXw.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bt localbt = new bt();
      localbt.d(paramString);
      localArrayList.add(localbt);
    }
    paramString.close();
    if (localArrayList.size() == 0) {
      return null;
    }
    return (bt[])localArrayList.toArray(new bt[localArrayList.size()]);
  }
  
  public final bt cwd()
  {
    Cursor localCursor = this.dXw.a("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
    if (localCursor == null) {
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      return null;
    }
    bt localbt = new bt();
    localbt.d(localCursor);
    localCursor.close();
    return localbt;
  }
  
  public final bt[] dy(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      y.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
    }
    ArrayList localArrayList;
    do
    {
      return null;
      paramString = "select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + bk.pl(paramString) + "' order by createTime DESC limit " + paramInt;
      paramString = this.dXw.a(paramString, null, 2);
      localArrayList = new ArrayList();
      while (paramString.moveToNext())
      {
        bt localbt = new bt();
        localbt.d(paramString);
        localArrayList.add(localbt);
      }
      paramString.close();
    } while (localArrayList.size() == 0);
    return (bt[])localArrayList.toArray(new bt[localArrayList.size()]);
  }
  
  public final int getCount()
  {
    Cursor localCursor = this.dXw.a("select count(*) from " + getTableName(), null, 2);
    if (!localCursor.moveToFirst()) {
      localCursor.close();
    }
    int i;
    do
    {
      return 0;
      i = localCursor.getInt(0);
      localCursor.close();
    } while (i <= 0);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.bu
 * JD-Core Version:    0.7.0.1
 */