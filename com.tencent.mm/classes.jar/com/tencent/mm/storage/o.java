package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class o
  extends j<n>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(32838);
    SQL_CREATE = new String[] { j.getCreateSQLs(n.info, "BackupTempMoveTime") };
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
            ad.d("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession:".concat(String.valueOf(localObject)));
            localObject = this.db.rawQuery((String)localObject, null);
            if (localObject == null)
            {
              ad.e("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession failed, sessionName:%s ", new Object[] { str });
              paramLinkedList1 = null;
            }
            for (;;)
            {
              if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0) && (l2 >= ((ho)paramLinkedList1.getFirst()).startTime) && (l1 <= ((ho)paramLinkedList1.getLast()).endTime)) {
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
                ho localho = new ho();
                localho.startTime = localn.field_startTime;
                localho.endTime = localn.field_endTime;
                paramLinkedList1.add(localho);
              }
              ((Cursor)localObject).close();
            }
            j = 0;
            if ((j >= paramLinkedList1.size()) || (l1 > l2)) {
              break label602;
            }
            localObject = (ho)paramLinkedList1.get(j);
            k = i;
            l3 = l1;
            if (l1 <= ((ho)localObject).endTime) {
              if (l1 < ((ho)localObject).startTime)
              {
                i = 1;
                paramLinkedList3.add(str);
                paramLinkedList4.add(Long.valueOf(l1));
                if (l2 < ((ho)localObject).startTime)
                {
                  paramLinkedList4.add(Long.valueOf(l2));
                  l1 = ((ho)localObject).startTime;
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    label602:
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
      paramLinkedList4.add(Long.valueOf(((ho)localObject).startTime));
      l3 = ((ho)localObject).endTime;
      k = i;
      j += 1;
      i = k;
      l1 = l3;
      break label366;
      AppMethodBeat.o(32835);
      return;
    }
  }
  
  public final boolean cWA()
  {
    AppMethodBeat.i(32836);
    boolean bool = this.db.execSQL("BackupTempMoveTime", "delete from BackupTempMoveTime");
    ad.i("MicroMsg.BackupTempMoveTimeStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(32836);
    return bool;
  }
  
  public final LinkedList<n> eJE()
  {
    AppMethodBeat.i(32834);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = getAll();
    if (localCursor == null)
    {
      ad.e("MicroMsg.BackupTempMoveTimeStorage", "getAllData failed.");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.o
 * JD-Core Version:    0.7.0.1
 */