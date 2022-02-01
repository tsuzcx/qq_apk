package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class k
  extends MAutoStorage<j>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(32824);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(j.info, "BackupMoveTime") };
    AppMethodBeat.o(32824);
  }
  
  public k(h paramh)
  {
    super(paramh, j.info, "BackupMoveTime", null);
    AppMethodBeat.i(32818);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.beginTransaction(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new String[] { "CREATE INDEX IF NOT EXISTS DeviceIdSessionIndex ON BackupMoveTime ( deviceId,sessionName )" }));
    int i = 0;
    while (i < localArrayList.size())
    {
      paramh.execSQL("BackupMoveTime", (String)localArrayList.get(i));
      i += 1;
    }
    Log.d("MicroMsg.BackupMoveTimeStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.endTransaction(l2);
    Log.i("MicroMsg.BackupMoveTimeStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(32818);
  }
  
  private static void a(LinkedList<ib> paramLinkedList, n paramn)
  {
    AppMethodBeat.i(32821);
    if (paramn.field_startTime > paramn.field_endTime)
    {
      AppMethodBeat.o(32821);
      return;
    }
    Object localObject = paramLinkedList.iterator();
    ib localib1;
    int i;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localib1 = (ib)((Iterator)localObject).next();
        if (paramn.field_startTime < localib1.endTime) {
          if (paramn.field_endTime < localib1.startTime)
          {
            localObject = new ib();
            ((ib)localObject).startTime = paramn.field_startTime;
            ((ib)localObject).endTime = paramn.field_endTime;
            paramLinkedList.add(localObject);
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject = new ib();
        ((ib)localObject).startTime = paramn.field_startTime;
        ((ib)localObject).endTime = paramn.field_endTime;
        paramLinkedList.add(localObject);
      }
      AppMethodBeat.o(32821);
      return;
      if (paramn.field_startTime < localib1.startTime) {
        localib1.startTime = paramn.field_startTime;
      }
      if (paramn.field_endTime > localib1.endTime)
      {
        localib1.endTime = paramn.field_endTime;
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label266;
          }
          ib localib2 = (ib)((Iterator)localObject).next();
          if (paramn.field_endTime <= localib2.startTime) {
            break label266;
          }
          if (paramn.field_endTime <= localib2.endTime)
          {
            localib1.endTime = localib2.endTime;
            ((Iterator)localObject).remove();
            i = 1;
            break;
          }
          ((Iterator)localObject).remove();
        }
      }
      label266:
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public final void a(String paramString, LinkedList<String> paramLinkedList1, LinkedList<Long> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<Long> paramLinkedList4)
  {
    AppMethodBeat.i(32819);
    paramLinkedList2 = paramLinkedList2.iterator();
    Iterator localIterator = paramLinkedList1.iterator();
    String str;
    int i;
    long l1;
    long l3;
    long l2;
    Object localObject;
    label322:
    int j;
    label330:
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
            paramLinkedList1 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + paramString + "\" AND sessionName = \"" + str + "\" ";
            Log.d("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession:".concat(String.valueOf(paramLinkedList1)));
            paramLinkedList1 = this.db.rawQuery(paramLinkedList1, null);
            if (paramLinkedList1 == null)
            {
              Log.e("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession failed, deviceid:%s, sessionName:%s ", new Object[] { paramString, str });
              paramLinkedList1 = null;
            }
            for (;;)
            {
              if ((paramLinkedList1 != null) && (paramLinkedList1.RNv.size() > 0) && (l2 >= ((ib)paramLinkedList1.RNv.getFirst()).startTime) && (l1 <= ((ib)paramLinkedList1.RNv.getLast()).endTime)) {
                break label322;
              }
              paramLinkedList3.add(str);
              paramLinkedList4.add(Long.valueOf(l1));
              paramLinkedList4.add(Long.valueOf(l2));
              break;
              if (paramLinkedList1.moveToFirst())
              {
                localObject = new j();
                ((j)localObject).convertFrom(paramLinkedList1);
                paramLinkedList1.close();
                paramLinkedList1 = ((j)localObject).field_moveTime;
              }
              else
              {
                paramLinkedList1.close();
                paramLinkedList1 = null;
              }
            }
            paramLinkedList1 = paramLinkedList1.RNv;
            j = 0;
            if ((j >= paramLinkedList1.size()) || (l1 > l2)) {
              break label602;
            }
            localObject = (ib)paramLinkedList1.get(j);
            k = i;
            l3 = l1;
            if (l1 <= ((ib)localObject).endTime) {
              if (l1 < ((ib)localObject).startTime)
              {
                i = 1;
                paramLinkedList3.add(str);
                paramLinkedList4.add(Long.valueOf(l1));
                if (l2 < ((ib)localObject).startTime)
                {
                  paramLinkedList4.add(Long.valueOf(l2));
                  l1 = ((ib)localObject).startTime;
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
      paramLinkedList4.add(Long.valueOf(((ib)localObject).startTime));
      l3 = ((ib)localObject).endTime;
      k = i;
      j += 1;
      i = k;
      l1 = l3;
      break label330;
      Log.i("MicroMsg.BackupMoveTimeStorage", "getSessionRequestTimeInteval, resultSession size:%s, resultTimeInterval:%s", new Object[] { Integer.valueOf(paramLinkedList3.size()), Integer.valueOf(paramLinkedList4.size()) });
      AppMethodBeat.o(32819);
      return;
    }
  }
  
  public final boolean aPo()
  {
    AppMethodBeat.i(32822);
    boolean bool = this.db.execSQL("BackupMoveTime", "delete from BackupMoveTime");
    Log.i("MicroMsg.BackupMoveTimeStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(32822);
    return bool;
  }
  
  public final void j(String paramString, LinkedList<n> paramLinkedList)
  {
    AppMethodBeat.i(32820);
    Log.i("MicroMsg.BackupMoveTimeStorage", "start mergeDataByDeviceId.");
    HashMap localHashMap = new HashMap();
    Object localObject1 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + paramString + "\" ";
    Log.d("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice:".concat(String.valueOf(localObject1)));
    localObject1 = this.db.rawQuery((String)localObject1, null);
    if (localObject1 == null) {
      Log.e("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice failed, deviceid:%s", new Object[] { paramString });
    }
    Object localObject2;
    while (this.db.delete("BackupMoveTime", "deviceId= ? ", new String[] { String.valueOf(paramString) }) < 0)
    {
      Log.e("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId delete db failed, deviceid:%s", new Object[] { paramString });
      AppMethodBeat.o(32820);
      return;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new j();
        ((j)localObject2).convertFrom((Cursor)localObject1);
        localHashMap.put(((j)localObject2).field_sessionName, localObject2);
      }
      ((Cursor)localObject1).close();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (n)paramLinkedList.next();
      localObject2 = (j)localHashMap.get(((n)localObject1).field_sessionName);
      if (localObject2 == null)
      {
        localObject2 = new ib();
        ((ib)localObject2).startTime = ((n)localObject1).field_startTime;
        ((ib)localObject2).endTime = ((n)localObject1).field_endTime;
        j localj = new j();
        localj.field_deviceId = paramString;
        localj.field_sessionName = ((n)localObject1).field_sessionName;
        localj.field_moveTime = new ic();
        localj.field_moveTime.RNv = new LinkedList();
        localj.field_moveTime.RNv.add(localObject2);
        localHashMap.put(((n)localObject1).field_sessionName, localj);
      }
      else
      {
        a(((j)localObject2).field_moveTime.RNv, (n)localObject1);
      }
    }
    paramString = localHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      paramLinkedList = (String)paramString.next();
      Log.i("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId insert BackupMoveTimeStorage ret[%b], sessionName:%s", new Object[] { Boolean.valueOf(insert((IAutoDBItem)localHashMap.get(paramLinkedList))), paramLinkedList });
    }
    AppMethodBeat.o(32820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.k
 * JD-Core Version:    0.7.0.1
 */