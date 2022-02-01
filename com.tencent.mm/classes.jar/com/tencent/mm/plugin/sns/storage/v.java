package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ebn;
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
  public Map<Long, List<Long>> EmT;
  public h iFy;
  
  static
  {
    AppMethodBeat.i(203221);
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS snsWsFoldGroupIdIndex ON SnsWsFoldGroupDetail ( groupId )" };
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(u.info, "SnsWsFoldGroupDetail") };
    AppMethodBeat.o(203221);
  }
  
  public v(h paramh)
  {
    super(paramh, s.info, "SnsWsFoldGroupDetail", INDEX_CREATE);
    AppMethodBeat.i(203217);
    this.EmT = new HashMap();
    this.iFy = paramh;
    AppMethodBeat.o(203217);
  }
  
  public final u JN(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(203219);
    Object localObject3 = "select *,rowid from SnsWsFoldGroupDetail  where SnsWsFoldGroupDetail.groupId=".concat(String.valueOf(paramLong));
    localObject3 = this.iFy.rawQuery((String)localObject3, null, 2);
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
    AppMethodBeat.o(203219);
    return localObject1;
  }
  
  public final boolean JO(long paramLong)
  {
    AppMethodBeat.i(203220);
    int i = this.iFy.delete("SnsWsFoldGroupDetail", "groupId=?", new String[] { String.valueOf(paramLong) });
    Log.d("MicroMsg.SnsWsFoldDetailStorage", "removeByGroupId " + paramLong + " res " + i);
    this.EmT.remove(Long.valueOf(paramLong));
    if (i > 0)
    {
      AppMethodBeat.o(203220);
      return true;
    }
    AppMethodBeat.o(203220);
    return false;
  }
  
  public final boolean a(u paramu)
  {
    AppMethodBeat.i(203218);
    Object localObject = paramu.convertTo();
    boolean bool;
    if (this.iFy.replace("SnsWsFoldGroupDetail", "groupId", (ContentValues)localObject) > 0L) {
      bool = true;
    }
    for (;;)
    {
      Log.d("MicroMsg.SnsWsFoldDetailStorage", "SnsWsFoldDetail replace result ".concat(String.valueOf(bool)));
      try
      {
        localObject = new ebn();
        ((ebn)localObject).parseFrom(paramu.field_groupStrcut);
        if (!Util.isNullOrNil(((ebn)localObject).Nbk)) {
          this.EmT.put(Long.valueOf(paramu.field_groupId), ((ebn)localObject).Nbk);
        }
        AppMethodBeat.o(203218);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.v
 * JD-Core Version:    0.7.0.1
 */