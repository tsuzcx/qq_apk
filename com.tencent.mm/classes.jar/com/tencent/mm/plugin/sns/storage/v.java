package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eln;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class v
  extends MAutoStorage<u>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public Map<Long, List<Long>> KAc;
  public h lvy;
  
  static
  {
    AppMethodBeat.i(199857);
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS snsWsFoldGroupIdIndex ON SnsWsFoldGroupDetail ( groupId )" };
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(u.info, "SnsWsFoldGroupDetail") };
    AppMethodBeat.o(199857);
  }
  
  public v(h paramh)
  {
    super(paramh, s.info, "SnsWsFoldGroupDetail", INDEX_CREATE);
    AppMethodBeat.i(199843);
    this.KAc = new HashMap();
    this.lvy = paramh;
    AppMethodBeat.o(199843);
  }
  
  public final u Rh(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(199851);
    Object localObject3 = "select *,rowid from SnsWsFoldGroupDetail  where SnsWsFoldGroupDetail.groupId=".concat(String.valueOf(paramLong));
    localObject3 = this.lvy.rawQuery((String)localObject3, null, 2);
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToNext())
      {
        localObject1 = new u();
        ((u)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
    }
    AppMethodBeat.o(199851);
    return localObject1;
  }
  
  public final boolean Ri(long paramLong)
  {
    AppMethodBeat.i(199852);
    int i = this.lvy.delete("SnsWsFoldGroupDetail", "groupId=?", new String[] { String.valueOf(paramLong) });
    Log.d("MicroMsg.SnsWsFoldDetailStorage", "removeByGroupId " + paramLong + " res " + i);
    this.KAc.remove(Long.valueOf(paramLong));
    if (i > 0)
    {
      AppMethodBeat.o(199852);
      return true;
    }
    AppMethodBeat.o(199852);
    return false;
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(199848);
    Object localObject = paramu.convertTo();
    boolean bool;
    if (this.lvy.replace("SnsWsFoldGroupDetail", "groupId", (ContentValues)localObject) > 0L) {
      bool = true;
    }
    for (;;)
    {
      Log.d("MicroMsg.SnsWsFoldDetailStorage", "SnsWsFoldDetail replace result ".concat(String.valueOf(bool)));
      try
      {
        localObject = new eln();
        ((eln)localObject).parseFrom(paramu.field_groupStrcut);
        if (!Util.isNullOrNil(((eln)localObject).UnE)) {
          this.KAc.put(Long.valueOf(paramu.field_groupId), ((eln)localObject).UnE);
        }
        AppMethodBeat.o(199848);
        return bool;
        bool = false;
      }
      catch (Exception paramu)
      {
        for (;;)
        {
          Log.w("MicroMsg.SnsWsFoldDetailStorage", "parse SnsWsGroupStruct fail:%s", new Object[] { paramu.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.v
 * JD-Core Version:    0.7.0.1
 */