package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class o
  extends MAutoStorage<n>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(32838);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(n.info, "BackupTempMoveTime") };
    AppMethodBeat.o(32838);
  }
  
  public o(h paramh)
  {
    super(paramh, n.info, "BackupTempMoveTime", null);
    this.db = paramh;
  }
  
  public final void a(LinkedList<String> paramLinkedList1, LinkedList<Long> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<Long> paramLinkedList4)
  {
    AppMethodBeat.i(32835);
    if (getCount() <= 0)
    {
      paramLinkedList3.addAll(paramLinkedList1);
      paramLinkedList4.addAll(paramLinkedList2);
      AppMethodBeat.o(32835);
      return;
    }
    paramLinkedList2 = paramLinkedList2.iterator();
    Iterator localIterator = paramLinkedList1.iterator();
    String str;
    int i;
    long l1;
    long l3;
    long l2;
    Object localObject;
    label363:
    int j;
    label366:
    int k;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        i = 0;
        if (paramLinkedList2.hasNext())
        {
          l1 = ((Long)paramLinkedList2.next()).longValue();
          if (paramLinkedList2.hasNext())
          {
            l3 = ((Long)paramLinkedList2.next()).longValue();
            l2 = l3;
            if (l3 == 0L) {
              l2 = 9223372036854775807L;
            }
            paramLinkedList1 = new LinkedList();
            localObject = "SELECT * FROM BackupTempMoveTime WHERE sessionName = \"" + str + "\" ";
            Log.d("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession:".concat(String.valueOf(localObject)));
            localObject = this.db.rawQuery((String)localObject, null);
            if (localObject == null)
            {
              Log.e("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession failed, sessionName:%s ", new Object[] { str });
              paramLinkedList1 = null;
            }
            for (;;)
            {
              if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0) && (l2 >= ((ix)paramLinkedList1.getFirst()).startTime) && (l1 <= ((ix)paramLinkedList1.getLast()).endTime)) {
                break label363;
              }
              paramLinkedList3.add(str);
              paramLinkedList4.add(Long.valueOf(l1));
              paramLinkedList4.add(Long.valueOf(l2));
              break;
              while (((Cursor)localObject).moveToNext())
              {
                n localn = new n();
                localn.convertFrom((Cursor)localObject);
                ix localix = new ix();
                localix.startTime = localn.field_startTime;
                localix.endTime = localn.field_endTime;
                paramLinkedList1.add(localix);
              }
              ((Cursor)localObject).close();
            }
            j = 0;
            if ((j >= paramLinkedList1.size()) || (l1 > l2)) {
              break label634;
            }
            localObject = (ix)paramLinkedList1.get(j);
            k = i;
            l3 = l1;
            if (l1 <= ((ix)localObject).endTime) {
              if (l1 < ((ix)localObject).startTime)
              {
                i = 1;
                paramLinkedList3.add(str);
                paramLinkedList4.add(Long.valueOf(l1));
                if (l2 < ((ix)localObject).startTime)
                {
                  paramLinkedList4.add(Long.valueOf(l2));
                  l1 = ((ix)localObject).startTime;
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    label634:
    for (;;)
    {
      if (l1 <= l2)
      {
        paramLinkedList3.add(str);
        paramLinkedList4.add(Long.valueOf(l1));
        paramLinkedList4.add(Long.valueOf(l2));
        i = 1;
      }
      if (i != 0) {
        break;
      }
      paramLinkedList3.add(str);
      paramLinkedList4.add(Long.valueOf(l1));
      paramLinkedList4.add(Long.valueOf(l2));
      break;
      paramLinkedList4.add(Long.valueOf(((ix)localObject).startTime));
      l3 = ((ix)localObject).endTime;
      k = i;
      j += 1;
      i = k;
      l1 = l3;
      break label366;
      Log.i("MicroMsg.BackupTempMoveTimeStorage", "getSessionRequestTimeInteval, resultSession size:%s, resultTimeInterval:%s", new Object[] { Integer.valueOf(paramLinkedList3.size()), Integer.valueOf(paramLinkedList4.size()) });
      AppMethodBeat.o(32835);
      return;
    }
  }
  
  public final boolean bjb()
  {
    AppMethodBeat.i(32836);
    boolean bool = this.db.execSQL("BackupTempMoveTime", "delete from BackupTempMoveTime");
    Log.i("MicroMsg.BackupTempMoveTimeStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(32836);
    return bool;
  }
  
  public final LinkedList<n> iXf()
  {
    AppMethodBeat.i(32834);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = getAll();
    if (localCursor == null)
    {
      Log.e("MicroMsg.BackupTempMoveTimeStorage", "getAllData failed.");
      AppMethodBeat.o(32834);
      return localLinkedList;
    }
    while (localCursor.moveToNext())
    {
      n localn = new n();
      localn.convertFrom(localCursor);
      localLinkedList.add(localn);
    }
    localCursor.close();
    AppMethodBeat.o(32834);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.o
 * JD-Core Version:    0.7.0.1
 */