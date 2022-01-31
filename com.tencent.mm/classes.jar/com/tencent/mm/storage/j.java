package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class j
  extends com.tencent.mm.sdk.e.j<i>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(29009);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(i.info, "BackupMoveTime") };
    AppMethodBeat.o(29009);
  }
  
  public j(h paramh)
  {
    super(paramh, i.info, "BackupMoveTime", null);
    AppMethodBeat.i(29003);
    this.db = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.kr(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new String[] { "CREATE INDEX IF NOT EXISTS DeviceIdSessionIndex ON BackupMoveTime ( deviceId,sessionName )" }));
    int i = 0;
    while (i < localArrayList.size())
    {
      paramh.execSQL("BackupMoveTime", (String)localArrayList.get(i));
      i += 1;
    }
    ab.d("MicroMsg.BackupMoveTimeStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.nY(l2);
    ab.i("MicroMsg.BackupMoveTimeStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(29003);
  }
  
  private static void a(LinkedList<gr> paramLinkedList, m paramm)
  {
    AppMethodBeat.i(29006);
    if (paramm.field_startTime > paramm.field_endTime)
    {
      AppMethodBeat.o(29006);
      return;
    }
    Object localObject = paramLinkedList.iterator();
    gr localgr1;
    int i;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localgr1 = (gr)((Iterator)localObject).next();
        if (paramm.field_startTime < localgr1.endTime) {
          if (paramm.field_endTime < localgr1.startTime)
          {
            localObject = new gr();
            ((gr)localObject).startTime = paramm.field_startTime;
            ((gr)localObject).endTime = paramm.field_endTime;
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
        localObject = new gr();
        ((gr)localObject).startTime = paramm.field_startTime;
        ((gr)localObject).endTime = paramm.field_endTime;
        paramLinkedList.add(localObject);
      }
      AppMethodBeat.o(29006);
      return;
      if (paramm.field_startTime < localgr1.startTime) {
        localgr1.startTime = paramm.field_startTime;
      }
      if (paramm.field_endTime > localgr1.endTime)
      {
        localgr1.endTime = paramm.field_endTime;
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label269;
          }
          gr localgr2 = (gr)((Iterator)localObject).next();
          if (paramm.field_endTime <= localgr2.startTime) {
            break label269;
          }
          if (paramm.field_endTime <= localgr2.endTime)
          {
            localgr1.endTime = localgr2.endTime;
            ((Iterator)localObject).remove();
            i = 1;
            break;
          }
          ((Iterator)localObject).remove();
        }
      }
      label269:
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public final void a(String paramString, LinkedList<String> paramLinkedList1, LinkedList<Long> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<Long> paramLinkedList4)
  {
    AppMethodBeat.i(29004);
    paramLinkedList2 = paramLinkedList2.iterator();
    Iterator localIterator = paramLinkedList1.iterator();
    String str;
    int i;
    long l1;
    long l3;
    long l2;
    Object localObject;
    label323:
    int j;
    label331:
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
            ab.d("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession:".concat(String.valueOf(paramLinkedList1)));
            paramLinkedList1 = this.db.rawQuery(paramLinkedList1, null);
            if (paramLinkedList1 == null)
            {
              ab.e("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession failed, deviceid:%s, sessionName:%s ", new Object[] { paramString, str });
              paramLinkedList1 = null;
            }
            for (;;)
            {
              if ((paramLinkedList1 != null) && (paramLinkedList1.wsZ.size() > 0) && (l2 >= ((gr)paramLinkedList1.wsZ.getFirst()).startTime) && (l1 <= ((gr)paramLinkedList1.wsZ.getLast()).endTime)) {
                break label323;
              }
              paramLinkedList3.add(str);
              paramLinkedList4.add(Long.valueOf(l1));
              paramLinkedList4.add(Long.valueOf(l2));
              break;
              if (paramLinkedList1.moveToFirst())
              {
                localObject = new i();
                ((i)localObject).convertFrom(paramLinkedList1);
                paramLinkedList1.close();
                paramLinkedList1 = ((i)localObject).field_moveTime;
              }
              else
              {
                paramLinkedList1.close();
                paramLinkedList1 = null;
              }
            }
            paramLinkedList1 = paramLinkedList1.wsZ;
            j = 0;
            if ((j >= paramLinkedList1.size()) || (l1 > l2)) {
              break label571;
            }
            localObject = (gr)paramLinkedList1.get(j);
            k = i;
            l3 = l1;
            if (l1 <= ((gr)localObject).endTime) {
              if (l1 < ((gr)localObject).startTime)
              {
                i = 1;
                paramLinkedList3.add(str);
                paramLinkedList4.add(Long.valueOf(l1));
                if (l2 < ((gr)localObject).startTime)
                {
                  paramLinkedList4.add(Long.valueOf(l2));
                  l1 = ((gr)localObject).startTime;
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    label571:
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
      paramLinkedList4.add(Long.valueOf(((gr)localObject).startTime));
      l3 = ((gr)localObject).endTime;
      k = i;
      j += 1;
      i = k;
      l1 = l3;
      break label331;
      AppMethodBeat.o(29004);
      return;
    }
  }
  
  public final boolean dvQ()
  {
    AppMethodBeat.i(29007);
    boolean bool = this.db.execSQL("BackupMoveTime", "delete from BackupMoveTime");
    ab.i("MicroMsg.BackupMoveTimeStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(29007);
    return bool;
  }
  
  public final void f(String paramString, LinkedList<m> paramLinkedList)
  {
    AppMethodBeat.i(29005);
    ab.i("MicroMsg.BackupMoveTimeStorage", "start mergeDataByDeviceIdSession.");
    HashMap localHashMap = new HashMap();
    Object localObject1 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + paramString + "\" ";
    ab.d("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice:".concat(String.valueOf(localObject1)));
    localObject1 = this.db.rawQuery((String)localObject1, null);
    if (localObject1 == null) {
      ab.e("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice failed, deviceid:%s", new Object[] { paramString });
    }
    Object localObject2;
    while (this.db.delete("BackupMoveTime", "deviceId= ? ", new String[] { String.valueOf(paramString) }) < 0)
    {
      ab.e("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId delete db failed, deviceid:%s", new Object[] { paramString });
      AppMethodBeat.o(29005);
      return;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new i();
        ((i)localObject2).convertFrom((Cursor)localObject1);
        localHashMap.put(((i)localObject2).field_sessionName, localObject2);
      }
      ((Cursor)localObject1).close();
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (m)paramLinkedList.next();
      localObject2 = (i)localHashMap.get(((m)localObject1).field_sessionName);
      if (localObject2 == null)
      {
        localObject2 = new gr();
        ((gr)localObject2).startTime = ((m)localObject1).field_startTime;
        ((gr)localObject2).endTime = ((m)localObject1).field_endTime;
        i locali = new i();
        locali.field_deviceId = paramString;
        locali.field_sessionName = ((m)localObject1).field_sessionName;
        locali.field_moveTime = new gs();
        locali.field_moveTime.wsZ = new LinkedList();
        locali.field_moveTime.wsZ.add(localObject2);
        localHashMap.put(((m)localObject1).field_sessionName, locali);
      }
      else
      {
        a(((i)localObject2).field_moveTime.wsZ, (m)localObject1);
      }
    }
    paramString = localHashMap.keySet().iterator();
    while (paramString.hasNext())
    {
      paramLinkedList = (String)paramString.next();
      ab.i("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId insert BackupMoveTimeStorage ret[%b], sessionName:%s", new Object[] { Boolean.valueOf(insert((c)localHashMap.get(paramLinkedList))), paramLinkedList });
    }
    AppMethodBeat.o(29005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.j
 * JD-Core Version:    0.7.0.1
 */