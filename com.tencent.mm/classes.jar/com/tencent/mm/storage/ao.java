package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class ao
  extends k
  implements com.tencent.mm.plugin.messenger.foundation.a.a.c
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) ", "CREATE INDEX IF NOT EXISTS createTimeIndex  ON DeletedConversationInfo ( reserved2 )" };
  private final f<String, Long> eka;
  private h fnw;
  
  public ao(h paramh)
  {
    AppMethodBeat.i(1273);
    this.eka = new com.tencent.mm.memory.a.c(50);
    this.fnw = paramh;
    AppMethodBeat.o(1273);
  }
  
  public final long Ta(String paramString)
  {
    AppMethodBeat.i(1275);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1275);
      return 0L;
    }
    Object localObject = "select lastSeq from DeletedConversationInfo where userName = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.i("MicroMsg.DeletedConversationInfoStorage", "getLastPushSeq failed ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(1275);
      return 0L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      AppMethodBeat.o(1275);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1275);
    return 0L;
  }
  
  public final long Tb(String paramString)
  {
    AppMethodBeat.i(1278);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1278);
      return 0L;
    }
    Object localObject = (Long)this.eka.get(paramString);
    long l;
    if (localObject != null)
    {
      l = ((Long)localObject).longValue();
      AppMethodBeat.o(1278);
      return l;
    }
    localObject = "select reserved2 from DeletedConversationInfo where userName = \"" + bo.wC(String.valueOf(paramString)) + "\"";
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      ab.i("MicroMsg.DeletedConversationInfoStorage", "getCreateTime failed ".concat(String.valueOf(paramString)));
      this.eka.f(paramString, Long.valueOf(0L));
      AppMethodBeat.o(1278);
      return 0L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      l = ((Cursor)localObject).getLong(0);
      this.eka.f(paramString, Long.valueOf(l));
      ((Cursor)localObject).close();
      AppMethodBeat.o(1278);
      return l;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(1278);
    return 0L;
  }
  
  public final boolean ad(String paramString, long paramLong)
  {
    AppMethodBeat.i(1274);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1274);
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("userName", paramString);
    localContentValues.put("lastSeq", Long.valueOf(paramLong));
    localContentValues.put("reserved2", Long.valueOf(Tb(paramString)));
    if ((int)this.fnw.replace("DeletedConversationInfo", "userName", localContentValues) != -1)
    {
      doNotify(paramString);
      AppMethodBeat.o(1274);
      return true;
    }
    AppMethodBeat.o(1274);
    return false;
  }
  
  public final boolean ae(String paramString, long paramLong)
  {
    AppMethodBeat.i(1276);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(1276);
      return false;
    }
    this.eka.f(paramString, Long.valueOf(paramLong));
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("userName", paramString);
    localContentValues.put("lastSeq", Long.valueOf(Ta(paramString)));
    localContentValues.put("reserved2", Long.valueOf(paramLong));
    if ((int)this.fnw.replace("DeletedConversationInfo", "userName", localContentValues) != -1)
    {
      doNotify(paramString);
      AppMethodBeat.o(1276);
      return true;
    }
    AppMethodBeat.o(1276);
    return false;
  }
  
  public final List<String> bPU()
  {
    AppMethodBeat.i(1277);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.fnw.a("select userName,reserved2 from DeletedConversationInfo where reserved2 > 0", null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(1277);
      return localArrayList;
    }
    if (localCursor.moveToFirst()) {
      do
      {
        String str = localCursor.getString(0);
        long l = localCursor.getLong(1);
        this.eka.f(str, Long.valueOf(l));
        localArrayList.add(str);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(1277);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.storage.ao
 * JD-Core Version:    0.7.0.1
 */