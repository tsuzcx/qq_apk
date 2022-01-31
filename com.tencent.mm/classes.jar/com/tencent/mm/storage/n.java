package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.protocal.c.fi;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
  extends i<m>
{
  public static final String[] dXp = { i.a(m.buS, "BackupTempMoveTime") };
  public e dXw;
  
  public n(h paramh)
  {
    super(paramh, m.buS, "BackupTempMoveTime", null);
    this.dXw = paramh;
  }
  
  public final void a(LinkedList<String> paramLinkedList1, LinkedList<Long> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<Long> paramLinkedList4)
  {
    if (getCount() <= 0)
    {
      paramLinkedList3.addAll(paramLinkedList1);
      paramLinkedList4.addAll(paramLinkedList2);
    }
    label32:
    String str;
    int i;
    long l1;
    do
    {
      return;
      paramLinkedList2 = paramLinkedList2.iterator();
      Iterator localIterator = paramLinkedList1.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
        i = 0;
      } while (!paramLinkedList2.hasNext());
      l1 = ((Long)paramLinkedList2.next()).longValue();
    } while (!paramLinkedList2.hasNext());
    long l3 = ((Long)paramLinkedList2.next()).longValue();
    long l2 = l3;
    if (l3 == 0L) {
      l2 = 9223372036854775807L;
    }
    paramLinkedList1 = new LinkedList();
    Object localObject = "SELECT * FROM BackupTempMoveTime WHERE sessionName = \"" + str + "\" ";
    y.d("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession:" + (String)localObject);
    localObject = this.dXw.rawQuery((String)localObject, null);
    if (localObject == null)
    {
      y.e("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession failed, sessionName:%s ", new Object[] { str });
      paramLinkedList1 = null;
    }
    for (;;)
    {
      if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0) && (l2 >= ((fi)paramLinkedList1.getFirst()).startTime) && (l1 <= ((fi)paramLinkedList1.getLast()).endTime)) {
        break label360;
      }
      paramLinkedList3.add(str);
      paramLinkedList4.add(Long.valueOf(l1));
      paramLinkedList4.add(Long.valueOf(l2));
      break;
      while (((Cursor)localObject).moveToNext())
      {
        m localm = new m();
        localm.d((Cursor)localObject);
        fi localfi = new fi();
        localfi.startTime = localm.field_startTime;
        localfi.endTime = localm.field_endTime;
        paramLinkedList1.add(localfi);
      }
      ((Cursor)localObject).close();
    }
    label360:
    int j = 0;
    label363:
    int k;
    if ((j < paramLinkedList1.size()) && (l1 <= l2))
    {
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
        break label32;
      }
      paramLinkedList3.add(str);
      paramLinkedList4.add(Long.valueOf(l1));
      paramLinkedList4.add(Long.valueOf(l2));
      break label32;
      break;
      paramLinkedList4.add(Long.valueOf(((fi)localObject).startTime));
      l3 = ((fi)localObject).endTime;
      k = i;
      j += 1;
      i = k;
      l1 = l3;
      break label363;
    }
  }
  
  public final boolean ctu()
  {
    boolean bool = this.dXw.gk("BackupTempMoveTime", "delete from BackupTempMoveTime");
    y.i("MicroMsg.BackupTempMoveTimeStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.n
 * JD-Core Version:    0.7.0.1
 */