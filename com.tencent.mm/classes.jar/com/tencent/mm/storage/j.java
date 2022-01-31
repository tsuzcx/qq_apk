package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.protocal.c.fi;
import com.tencent.mm.protocal.c.fj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class j
  extends com.tencent.mm.sdk.e.i<i>
{
  public static final String[] dXp = { com.tencent.mm.sdk.e.i.a(i.buS, "BackupMoveTime") };
  public e dXw;
  
  public j(h paramh)
  {
    super(paramh, i.buS, "BackupMoveTime", null);
    this.dXw = paramh;
    long l1 = System.currentTimeMillis();
    long l2 = paramh.eV(Thread.currentThread().getId());
    long l3 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new String[] { "CREATE INDEX IF NOT EXISTS DeviceIdSessionIndex ON BackupMoveTime ( deviceId,sessionName )" }));
    int i = 0;
    while (i < localArrayList.size())
    {
      paramh.gk("BackupMoveTime", (String)localArrayList.get(i));
      i += 1;
    }
    y.d("MicroMsg.BackupMoveTimeStorage", "build new index last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
    paramh.hI(l2);
    y.i("MicroMsg.BackupMoveTimeStorage", "executeInitSQL last time[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
  
  private static void a(LinkedList<fi> paramLinkedList, m paramm)
  {
    if (paramm.field_startTime > paramm.field_endTime) {}
    for (;;)
    {
      return;
      Object localObject = paramLinkedList.iterator();
      fi localfi1;
      int i;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          localfi1 = (fi)((Iterator)localObject).next();
          if (paramm.field_startTime < localfi1.endTime) {
            if (paramm.field_endTime < localfi1.startTime)
            {
              localObject = new fi();
              ((fi)localObject).startTime = paramm.field_startTime;
              ((fi)localObject).endTime = paramm.field_endTime;
              paramLinkedList.add(localObject);
              i = 1;
            }
          }
        }
      }
      while (i == 0)
      {
        localObject = new fi();
        ((fi)localObject).startTime = paramm.field_startTime;
        ((fi)localObject).endTime = paramm.field_endTime;
        paramLinkedList.add(localObject);
        return;
        if (paramm.field_startTime < localfi1.startTime) {
          localfi1.startTime = paramm.field_startTime;
        }
        if (paramm.field_endTime > localfi1.endTime)
        {
          localfi1.endTime = paramm.field_endTime;
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label251;
            }
            fi localfi2 = (fi)((Iterator)localObject).next();
            if (paramm.field_endTime <= localfi2.startTime) {
              break label251;
            }
            if (paramm.field_endTime <= localfi2.endTime)
            {
              localfi1.endTime = localfi2.endTime;
              ((Iterator)localObject).remove();
              i = 1;
              break;
            }
            ((Iterator)localObject).remove();
          }
        }
        label251:
        i = 1;
        continue;
        i = 0;
      }
    }
  }
  
  public final void a(String paramString, LinkedList<String> paramLinkedList1, LinkedList<Long> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<Long> paramLinkedList4)
  {
    paramLinkedList2 = paramLinkedList2.iterator();
    Iterator localIterator = paramLinkedList1.iterator();
    String str;
    int i;
    long l1;
    long l3;
    long l2;
    Object localObject;
    label324:
    int j;
    label332:
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
            y.d("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession:" + paramLinkedList1);
            paramLinkedList1 = this.dXw.rawQuery(paramLinkedList1, null);
            if (paramLinkedList1 == null)
            {
              y.e("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession failed, deviceid:%s, sessionName:%s ", new Object[] { paramString, str });
              paramLinkedList1 = null;
            }
            for (;;)
            {
              if ((paramLinkedList1 != null) && (paramLinkedList1.syX.size() > 0) && (l2 >= ((fi)paramLinkedList1.syX.getFirst()).startTime) && (l1 <= ((fi)paramLinkedList1.syX.getLast()).endTime)) {
                break label324;
              }
              paramLinkedList3.add(str);
              paramLinkedList4.add(Long.valueOf(l1));
              paramLinkedList4.add(Long.valueOf(l2));
              break;
              if (paramLinkedList1.moveToFirst())
              {
                localObject = new i();
                ((i)localObject).d(paramLinkedList1);
                paramLinkedList1.close();
                paramLinkedList1 = ((i)localObject).field_moveTime;
              }
              else
              {
                paramLinkedList1.close();
                paramLinkedList1 = null;
              }
            }
            paramLinkedList1 = paramLinkedList1.syX;
            j = 0;
            if ((j >= paramLinkedList1.size()) || (l1 > l2)) {
              break label566;
            }
            localObject = (fi)paramLinkedList1.get(j);
            k = i;
            l3 = l1;
            if (l1 <= ((fi)localObject).endTime) {
              if (l1 < ((fi)localObject).startTime)
              {
                i = 1;
                paramLinkedList3.add(str);
                paramLinkedList4.add(Long.valueOf(l1));
                if (l2 < ((fi)localObject).startTime)
                {
                  paramLinkedList4.add(Long.valueOf(l2));
                  l1 = ((fi)localObject).startTime;
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    label566:
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
      paramLinkedList4.add(Long.valueOf(((fi)localObject).startTime));
      l3 = ((fi)localObject).endTime;
      k = i;
      j += 1;
      i = k;
      l1 = l3;
      break label332;
      return;
    }
  }
  
  public final boolean ctu()
  {
    boolean bool = this.dXw.gk("BackupMoveTime", "delete from BackupMoveTime");
    y.i("MicroMsg.BackupMoveTimeStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final void f(String paramString, LinkedList<m> paramLinkedList)
  {
    y.i("MicroMsg.BackupMoveTimeStorage", "start mergeDataByDeviceIdSession.");
    HashMap localHashMap = new HashMap();
    Object localObject1 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + paramString + "\" ";
    y.d("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice:" + (String)localObject1);
    localObject1 = this.dXw.rawQuery((String)localObject1, null);
    if (localObject1 == null)
    {
      y.e("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice failed, deviceid:%s", new Object[] { paramString });
      if (this.dXw.delete("BackupMoveTime", "deviceId= ? ", new String[] { paramString }) >= 0) {
        break label188;
      }
      y.e("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId delete db failed, deviceid:%s", new Object[] { paramString });
    }
    for (;;)
    {
      return;
      Object localObject2;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new i();
        ((i)localObject2).d((Cursor)localObject1);
        localHashMap.put(((i)localObject2).field_sessionName, localObject2);
      }
      ((Cursor)localObject1).close();
      break;
      label188:
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject1 = (m)paramLinkedList.next();
        localObject2 = (i)localHashMap.get(((m)localObject1).field_sessionName);
        if (localObject2 == null)
        {
          localObject2 = new fi();
          ((fi)localObject2).startTime = ((m)localObject1).field_startTime;
          ((fi)localObject2).endTime = ((m)localObject1).field_endTime;
          i locali = new i();
          locali.field_deviceId = paramString;
          locali.field_sessionName = ((m)localObject1).field_sessionName;
          locali.field_moveTime = new fj();
          locali.field_moveTime.syX = new LinkedList();
          locali.field_moveTime.syX.add(localObject2);
          localHashMap.put(((m)localObject1).field_sessionName, locali);
        }
        else
        {
          a(((i)localObject2).field_moveTime.syX, (m)localObject1);
        }
      }
      paramString = localHashMap.keySet().iterator();
      while (paramString.hasNext())
      {
        paramLinkedList = (String)paramString.next();
        y.i("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId insert BackupMoveTimeStorage ret[%b], sessionName:%s", new Object[] { Boolean.valueOf(b((c)localHashMap.get(paramLinkedList))), paramLinkedList });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.j
 * JD-Core Version:    0.7.0.1
 */