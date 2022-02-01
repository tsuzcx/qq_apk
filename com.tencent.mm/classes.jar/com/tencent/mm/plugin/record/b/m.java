package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends com.tencent.mm.sdk.e.j<com.tencent.mm.plugin.record.a.j>
  implements g
{
  private e db;
  
  public m(e parame)
  {
    super(parame, com.tencent.mm.plugin.record.a.j.info, "RecordMessageInfo", null);
    this.db = parame;
  }
  
  public final void Ma(int paramInt)
  {
    AppMethodBeat.i(9517);
    ac.d("MicroMsg.RecordMsgStorage", "delete record msg item, local id %d, result %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.db.delete("RecordMessageInfo", "localId=?", new String[] { String.valueOf(paramInt) })) });
    AppMethodBeat.o(9517);
  }
  
  public final com.tencent.mm.plugin.record.a.j Mb(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(9518);
    Object localObject1 = "SELECT * FROM RecordMessageInfo WHERE localId=".concat(String.valueOf(paramInt));
    ac.d("MicroMsg.RecordMsgStorage", "get by local id, sql[%s], local[%d]", new Object[] { localObject1, Integer.valueOf(paramInt) });
    Cursor localCursor = this.db.a((String)localObject1, null, 2);
    localObject1 = localObject2;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst())
      {
        localObject1 = new com.tencent.mm.plugin.record.a.j();
        ((com.tencent.mm.plugin.record.a.j)localObject1).convertFrom(localCursor);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(9518);
    return localObject1;
  }
  
  public final List<com.tencent.mm.plugin.record.a.j> dtK()
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
          com.tencent.mm.plugin.record.a.j localj = new com.tencent.mm.plugin.record.a.j();
          try
          {
            localj.convertFrom(localCursor);
            localLinkedList.add(localj);
            localCursor.moveToNext();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ac.e("MicroMsg.RecordMsgStorage", "convert recordInfo Exception: " + localException.getMessage());
            }
          }
        }
      }
      localCursor.close();
    }
    ac.d("MicroMsg.RecordMsgStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(9516);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.m
 * JD-Core Version:    0.7.0.1
 */