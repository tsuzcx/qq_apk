package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.ec;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends i<j>
  implements d
{
  public static final String[] dXp = { i.a(j.buS, "SnsComment") };
  public h dXo;
  
  public k(h paramh)
  {
    super(paramh, j.buS, "SnsComment", ec.cqY);
    this.dXo = paramh;
  }
  
  public static String bGo()
  {
    return "select *, rowid from SnsComment";
  }
  
  public final boolean a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (bk.bl(paramString2)) {}
    for (paramString1 = "select count(*) from SnsComment where snsID = " + paramLong + " and createTime = " + paramInt + " and talker = '" + paramString1 + "'";; paramString1 = "select count(*) from SnsComment where snsID = " + paramLong + " and clientId = '" + paramString2 + "'")
    {
      paramString1 = rawQuery(paramString1, new String[0]);
      if (paramString1 == null) {
        break label129;
      }
      paramString1.moveToFirst();
      paramInt = paramString1.getInt(0);
      paramString1.close();
      if (paramInt <= 0) {
        break;
      }
      return true;
    }
    return false;
    label129:
    return false;
  }
  
  public final int aAo()
  {
    int i = 0;
    Cursor localCursor = this.dXo.a(" select count(*) from SnsComment where isRead = ? and isSilence != ? ", new String[] { "0", "1" }, 2);
    if (localCursor == null) {
      return 0;
    }
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    return i;
  }
  
  public final boolean aAp()
  {
    return this.dXo.gk("SnsComment", " update SnsComment set isRead = 1 where isRead = 0");
  }
  
  public final Cursor bGp()
  {
    return this.dXo.a("select *, rowid from SnsComment where isRead = ?  and isSilence != ?  order by createTime desc", new String[] { "0", "1" }, 0);
  }
  
  public final int bGq()
  {
    int i = 0;
    Cursor localCursor = rawQuery("select count(*) from SnsComment where isSend = 0", new String[0]);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      i = localCursor.getInt(0);
      localCursor.close();
    }
    return i;
  }
  
  public final void bGr()
  {
    this.dXo.acQ("SnsComment");
  }
  
  public final j d(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject1 = "";
    if (paramInt == 9) {
      localObject1 = "" + "(2)";
    }
    Object localObject2 = localObject1;
    if (paramInt == 10) {
      localObject2 = (String)localObject1 + "(8,16)";
    }
    localObject2 = rawQuery("select *, rowid from SnsComment where snsID = " + paramLong1 + " and commentSvrID = " + paramLong2 + " and type in " + (String)localObject2, new String[0]);
    if (localObject2 != null)
    {
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject1 = new j();
        ((j)localObject1).d((Cursor)localObject2);
      }
      for (;;)
      {
        ((Cursor)localObject2).close();
        return localObject1;
        localObject1 = null;
      }
    }
    return null;
  }
  
  public final boolean e(long paramLong1, long paramLong2, int paramInt)
  {
    String str1 = "";
    if (paramInt == 9) {
      str1 = "" + "(2)";
    }
    String str2 = str1;
    if (paramInt == 10) {
      str2 = str1 + "(8,16)";
    }
    str1 = "delete from SnsComment where snsID = " + paramLong1 + " and commentSvrID = " + paramLong2 + " and type in " + str2;
    return this.dXo.gk("SnsComment", str1);
  }
  
  public final boolean go(long paramLong)
  {
    String str = "delete from SnsComment where snsID = " + paramLong;
    return this.dXo.gk("SnsComment", str);
  }
  
  public final boolean u(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      String str = " update SnsComment set isSilence = " + i + " where isSilence != " + i + " and  snsID = " + paramLong;
      y.i("MicroMsg.SnsCommentStorage", "updateIsSilence " + str);
      return this.dXo.gk("SnsComment", str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.k
 * JD-Core Version:    0.7.0.1
 */