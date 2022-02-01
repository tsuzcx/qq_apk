package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fgb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class af
  extends MAutoStorage<ae>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public Map<Long, List<Long>> QZB;
  public h omV;
  
  static
  {
    AppMethodBeat.i(306529);
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS snsWsFoldGroupIdIndex ON SnsWsFoldGroupDetail ( groupId )" };
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ae.info, "SnsWsFoldGroupDetail") };
    AppMethodBeat.o(306529);
  }
  
  public af(h paramh)
  {
    super(paramh, ac.info, "SnsWsFoldGroupDetail", INDEX_CREATE);
    AppMethodBeat.i(306526);
    this.QZB = new HashMap();
    this.omV = paramh;
    AppMethodBeat.o(306526);
  }
  
  public final boolean a(ae paramae)
  {
    AppMethodBeat.i(306536);
    Object localObject = paramae.convertTo();
    boolean bool;
    if (this.omV.replace("SnsWsFoldGroupDetail", "groupId", (ContentValues)localObject) > 0L) {
      bool = true;
    }
    for (;;)
    {
      Log.d("MicroMsg.SnsWsFoldDetailStorage", "SnsWsFoldDetail replace result ".concat(String.valueOf(bool)));
      try
      {
        localObject = new fgb();
        ((fgb)localObject).parseFrom(paramae.field_groupStrcut);
        if (!Util.isNullOrNil(((fgb)localObject).abFY)) {
          this.QZB.put(Long.valueOf(paramae.field_groupId), ((fgb)localObject).abFY);
        }
        AppMethodBeat.o(306536);
        return bool;
        bool = false;
      }
      catch (Exception paramae)
      {
        for (;;)
        {
          Log.w("MicroMsg.SnsWsFoldDetailStorage", "parse SnsWsGroupStruct fail:%s", new Object[] { paramae.getMessage() });
        }
      }
    }
  }
  
  public final ae vn(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(306540);
    Object localObject3 = "select *,rowid from SnsWsFoldGroupDetail  where SnsWsFoldGroupDetail.groupId=".concat(String.valueOf(paramLong));
    localObject3 = this.omV.rawQuery((String)localObject3, null, 2);
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((Cursor)localObject3).moveToNext())
      {
        localObject1 = new ae();
        ((ae)localObject1).convertFrom((Cursor)localObject3);
      }
      ((Cursor)localObject3).close();
    }
    AppMethodBeat.o(306540);
    return localObject1;
  }
  
  public final boolean vo(long paramLong)
  {
    AppMethodBeat.i(306546);
    int i = this.omV.delete("SnsWsFoldGroupDetail", "groupId=?", new String[] { String.valueOf(paramLong) });
    Log.d("MicroMsg.SnsWsFoldDetailStorage", "removeByGroupId " + paramLong + " res " + i);
    this.QZB.remove(Long.valueOf(paramLong));
    if (i > 0)
    {
      AppMethodBeat.o(306546);
      return true;
    }
    AppMethodBeat.o(306546);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.af
 * JD-Core Version:    0.7.0.1
 */