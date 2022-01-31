package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.cf.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class ao
  extends j
  implements c
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) ", "CREATE INDEX IF NOT EXISTS createTimeIndex  ON DeletedConversationInfo ( reserved2 )" };
  private h dXo;
  private final f<String, Long> dss = new f(50);
  
  public ao(h paramh)
  {
    this.dXo = paramh;
  }
  
  public final long Ho(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0L;
    }
    Object localObject = "select lastSeq from DeletedConversationInfo where userName = \"" + bk.pl(paramString) + "\"";
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.i("MicroMsg.DeletedConversationInfoStorage", "getLastPushSeq failed " + paramString);
      return 0L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      return l;
    }
    ((Cursor)localObject).close();
    return 0L;
  }
  
  public final long Hp(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0L;
    }
    Object localObject = (Long)this.dss.get(paramString);
    if (localObject != null) {
      return ((Long)localObject).longValue();
    }
    localObject = "select reserved2 from DeletedConversationInfo where userName = \"" + bk.pl(paramString) + "\"";
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null)
    {
      y.i("MicroMsg.DeletedConversationInfoStorage", "getCreateTime failed " + paramString);
      this.dss.f(paramString, Long.valueOf(0L));
      return 0L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      this.dss.f(paramString, Long.valueOf(l));
      ((Cursor)localObject).close();
      return l;
    }
    ((Cursor)localObject).close();
    return 0L;
  }
  
  public final boolean L(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {}
    ContentValues localContentValues;
    do
    {
      return false;
      localContentValues = new ContentValues();
      localContentValues.put("userName", paramString);
      localContentValues.put("lastSeq", Long.valueOf(paramLong));
      localContentValues.put("reserved2", Long.valueOf(Hp(paramString)));
    } while ((int)this.dXo.replace("DeletedConversationInfo", "userName", localContentValues) == -1);
    aam(paramString);
    return true;
  }
  
  public final boolean M(String paramString, long paramLong)
  {
    if (bk.bl(paramString)) {}
    ContentValues localContentValues;
    do
    {
      return false;
      this.dss.f(paramString, Long.valueOf(paramLong));
      localContentValues = new ContentValues();
      localContentValues.put("userName", paramString);
      localContentValues.put("lastSeq", Long.valueOf(Ho(paramString)));
      localContentValues.put("reserved2", Long.valueOf(paramLong));
    } while ((int)this.dXo.replace("DeletedConversationInfo", "userName", localContentValues) == -1);
    aam(paramString);
    return true;
  }
  
  public final List<String> bhS()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.dXo.a("select userName,reserved2 from DeletedConversationInfo where reserved2 > 0", null, 2);
    if (localCursor == null) {
      return localArrayList;
    }
    if (localCursor.moveToFirst()) {
      do
      {
        String str = localCursor.getString(0);
        long l = localCursor.getLong(1);
        this.dss.f(str, Long.valueOf(l));
        localArrayList.add(str);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.ao
 * JD-Core Version:    0.7.0.1
 */