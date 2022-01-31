package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.h.c.cn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class bg
  extends i<bf>
  implements f
{
  public static final String[] dXp = { i.a(bf.buS, "LBSVerifyMessage") };
  public e dXw;
  
  public bg(e parame)
  {
    super(parame, bf.buS, "LBSVerifyMessage", cn.cqY);
    this.dXw = parame;
  }
  
  public final void Hs(String paramString)
  {
    paramString = "svrid = '" + paramString + "'";
    int i = this.dXw.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    y.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = " + i);
  }
  
  public final void Ht(String paramString)
  {
    paramString = "sayhiuser = '" + paramString + "' or sayhiencryptuser='" + paramString + "'";
    int i = this.dXw.delete(getTableName(), paramString, null);
    if (i > 0) {
      doNotify();
    }
    y.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = " + i);
  }
  
  public final long Hu(String paramString)
  {
    Cursor localCursor;
    if (paramString != null)
    {
      paramString = (bg)((j)g.r(j.class)).bhL();
      localCursor = paramString.dXw.a("SELECT * FROM " + paramString.getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
      if (localCursor == null)
      {
        paramString = null;
        if (paramString == null) {
          break label139;
        }
      }
    }
    label139:
    for (long l1 = paramString.field_createtime + 1L;; l1 = 0L)
    {
      long l2 = bk.UX();
      if (l1 > l2)
      {
        return l1;
        if (!localCursor.moveToFirst())
        {
          localCursor.close();
          paramString = null;
          break;
        }
        paramString = new bf();
        paramString.d(localCursor);
        localCursor.close();
        break;
      }
      return l2;
    }
  }
  
  public final boolean a(bf parambf)
  {
    if (parambf == null) {
      y.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
    }
    while (!super.b(parambf)) {
      return false;
    }
    aam(parambf.ujK);
    return true;
  }
  
  public final int aAo()
  {
    Cursor localCursor = this.dXw.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      return 0;
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    return i;
  }
  
  public final void aUK()
  {
    this.dXw.delete(getTableName(), null, null);
  }
  
  public final bf[] abW(String paramString)
  {
    y.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where sayhiuser = '" + bk.pl(paramString) + "' or sayhiencryptuser = '" + bk.pl(paramString) + "' order by createtime DESC limit 3";
    paramString = this.dXw.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bf localbf = new bf();
      localbf.d(paramString);
      localArrayList.add(localbf);
    }
    paramString.close();
    return (bf[])localArrayList.toArray(new bf[localArrayList.size()]);
  }
  
  public final bf abX(String paramString)
  {
    Object localObject = null;
    y.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
    paramString = "select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + bk.pl(paramString) + "' or sayhiencryptuser = '" + bk.pl(paramString) + "') and flag=1 order by createtime DESC limit 1";
    Cursor localCursor = this.dXw.a(paramString, null, 2);
    if (localCursor.moveToFirst())
    {
      paramString = new bf();
      paramString.d(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      return paramString;
      y.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
      paramString = localObject;
    }
  }
  
  public final bf bhU()
  {
    Cursor localCursor = this.dXw.a("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
    if (localCursor == null) {
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      return null;
    }
    bf localbf = new bf();
    localbf.d(localCursor);
    localCursor.close();
    return localbf;
  }
  
  public final bf[] dw(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
      return null;
    }
    paramString = "select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + bk.pl(paramString) + "' or sayhiencryptuser = '" + bk.pl(paramString) + "') order by createTime DESC limit " + paramInt;
    paramString = this.dXw.a(paramString, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (paramString.moveToNext())
    {
      bf localbf = new bf();
      localbf.d(paramString);
      localArrayList.add(localbf);
    }
    paramString.close();
    return (bf[])localArrayList.toArray(new bf[localArrayList.size()]);
  }
  
  public final int getCount()
  {
    int i = 0;
    Cursor localCursor = this.dXw.a("select count(*) from " + getTableName(), null, 2);
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bg
 * JD-Core Version:    0.7.0.1
 */