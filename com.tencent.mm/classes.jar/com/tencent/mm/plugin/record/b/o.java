package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.plugin.record.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;

public final class o
  extends MAutoStorage<k>
  implements h
{
  private ISQLiteDatabase db;
  
  public o(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, k.info, "RecordMessageInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  public o(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public final void acc(int paramInt)
  {
    AppMethodBeat.i(9517);
    Log.d("MicroMsg.RecordMsgStorage", "delete record msg item, local id %d, result %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.db.delete("RecordMessageInfo", "localId=?", new String[] { String.valueOf(paramInt) })) });
    AppMethodBeat.o(9517);
  }
  
  public final k acd(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(9518);
    Object localObject1 = "SELECT * FROM RecordMessageInfo WHERE localId=".concat(String.valueOf(paramInt));
    Log.d("MicroMsg.RecordMsgStorage", "get by local id, sql[%s], local[%d]", new Object[] { localObject1, Integer.valueOf(paramInt) });
    Cursor localCursor = this.db.rawQuery((String)localObject1, null, 2);
    localObject1 = localObject2;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst())
      {
        localObject1 = new k();
        ((k)localObject1).convertFrom(localCursor);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(9518);
    return localObject1;
  }
  
  public final List<k> fuq()
  {
    AppMethodBeat.i(9516);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = getAll();
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      for (;;)
      {
        if (!localCursor.isAfterLast())
        {
          k localk = new k();
          try
          {
            localk.convertFrom(localCursor);
            localLinkedList.add(localk);
            localCursor.moveToNext();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MicroMsg.RecordMsgStorage", "convert recordInfo Exception: " + localException.getMessage());
            }
          }
        }
      }
      localCursor.close();
    }
    Log.d("MicroMsg.RecordMsgStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(9516);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.o
 * JD-Core Version:    0.7.0.1
 */