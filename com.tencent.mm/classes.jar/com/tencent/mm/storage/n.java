package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
  extends j<m>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(29022);
    SQL_CREATE = new String[] { j.getCreateSQLs(m.info, "BackupTempMoveTime") };
    AppMethodBeat.o(29022);
  }
  
  public n(h paramh)
  {
    super(paramh, m.info, "BackupTempMoveTime", null);
    this.db = paramh;
  }
  
  public final void a(LinkedList<String> paramLinkedList1, LinkedList<Long> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<Long> paramLinkedList4)
  {
    AppMethodBeat.i(29019);
    if (getCount() <= 0)
    {
      paramLinkedList3.addAll(paramLinkedList1);
      paramLinkedList4.addAll(paramLinkedList2);
      AppMethodBeat.o(29019);
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
    label365:
    int j;
    label368:
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
            ab.d("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession:".concat(String.valueOf(localObject)));
            localObject = this.db.rawQuery((String)localObject, null);
            if (localObject == null)
            {
              ab.e("MicroMsg.BackupTempMoveTimeStorage", "getTempMoveTimeBySession failed, sessionName:%s ", new Object[] { str });
              paramLinkedList1 = null;
            }
            for (;;)
            {
              if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0) && (l2 >= ((gr)paramLinkedList1.getFirst()).startTime) && (l1 <= ((gr)paramLinkedList1.getLast()).endTime)) {
                break label365;
              }
              paramLinkedList3.add(str);
              paramLinkedList4.add(Long.valueOf(l1));
              paramLinkedList4.add(Long.valueOf(l2));
              break;
              while (((Cursor)localObject).moveToNext())
              {
                m localm = new m();
                localm.convertFrom((Cursor)localObject);
                gr localgr = new gr();
                localgr.startTime = localm.field_startTime;
                localgr.endTime = localm.field_endTime;
                paramLinkedList1.add(localgr);
              }
              ((Cursor)localObject).close();
            }
            j = 0;
            if ((j >= paramLinkedList1.size()) || (l1 > l2)) {
              break label605;
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
    label605:
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
      break label368;
      AppMethodBeat.o(29019);
      return;
    }
  }
  
  public final boolean dvQ()
  {
    AppMethodBeat.i(29020);
    boolean bool = this.db.execSQL("BackupTempMoveTime", "delete from BackupTempMoveTime");
    ab.i("MicroMsg.BackupTempMoveTimeStorage", "deleteAllData, result:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(29020);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.n
 * JD-Core Version:    0.7.0.1
 */