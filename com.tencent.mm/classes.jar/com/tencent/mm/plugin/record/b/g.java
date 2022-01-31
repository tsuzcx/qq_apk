package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends i<com.tencent.mm.plugin.record.a.g>
  implements com.tencent.mm.plugin.record.a.e
{
  private com.tencent.mm.sdk.e.e dXw;
  
  public g(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, com.tencent.mm.plugin.record.a.g.buS, "RecordMessageInfo", null);
    this.dXw = parame;
  }
  
  public final List<com.tencent.mm.plugin.record.a.g> bvu()
  {
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = aAn();
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      for (;;)
      {
        if (!localCursor.isAfterLast())
        {
          com.tencent.mm.plugin.record.a.g localg = new com.tencent.mm.plugin.record.a.g();
          try
          {
            localg.d(localCursor);
            localLinkedList.add(localg);
            localCursor.moveToNext();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              y.e("MicroMsg.RecordMsgStorage", "convert recordInfo Exception: " + localException.getMessage());
            }
          }
        }
      }
      localCursor.close();
    }
    y.d("MicroMsg.RecordMsgStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    return localLinkedList;
  }
  
  public final com.tencent.mm.plugin.record.a.g wA(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = "SELECT * FROM RecordMessageInfo WHERE localId=" + paramInt;
    y.d("MicroMsg.RecordMsgStorage", "get by local id, sql[%s], local[%d]", new Object[] { localObject1, Integer.valueOf(paramInt) });
    Cursor localCursor = this.dXw.a((String)localObject1, null, 2);
    localObject1 = localObject2;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst())
      {
        localObject1 = new com.tencent.mm.plugin.record.a.g();
        ((com.tencent.mm.plugin.record.a.g)localObject1).d(localCursor);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    return localObject1;
  }
  
  public final void wz(int paramInt)
  {
    y.d("MicroMsg.RecordMsgStorage", "delete record msg item, local id %d, result %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.dXw.delete("RecordMessageInfo", "localId=?", new String[] { String.valueOf(paramInt) })) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.g
 * JD-Core Version:    0.7.0.1
 */