package com.tencent.mm.plugin.record.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class l
  extends MAutoStorage<j>
  implements e
{
  private Vector<d> NAC;
  private ISQLiteDatabase db;
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, j.info, "RecordCDNInfo", null);
    AppMethodBeat.i(9500);
    this.NAC = new Vector();
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(9500);
  }
  
  private void b(final int paramInt, final j paramj)
  {
    AppMethodBeat.i(9503);
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9499);
        Iterator localIterator = l.a(l.this).iterator();
        while (localIterator.hasNext()) {
          ((d)localIterator.next()).a(paramInt, paramj);
        }
        AppMethodBeat.o(9499);
      }
    });
    AppMethodBeat.o(9503);
  }
  
  public final void a(final d paramd)
  {
    AppMethodBeat.i(9501);
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9497);
        if (!l.a(l.this).contains(paramd)) {
          l.a(l.this).add(paramd);
        }
        AppMethodBeat.o(9497);
      }
    });
    AppMethodBeat.o(9501);
  }
  
  public final boolean a(long paramLong, j paramj)
  {
    AppMethodBeat.i(305341);
    if (super.update(paramLong, paramj))
    {
      b(1, paramj);
      AppMethodBeat.o(305341);
      return true;
    }
    AppMethodBeat.o(305341);
    return false;
  }
  
  public final boolean a(j paramj)
  {
    AppMethodBeat.i(9509);
    if (super.replace(paramj))
    {
      b(1, paramj);
      AppMethodBeat.o(9509);
      return true;
    }
    AppMethodBeat.o(9509);
    return false;
  }
  
  public final boolean a(j paramj, String... paramVarArgs)
  {
    AppMethodBeat.i(9507);
    if (super.delete(paramj, paramVarArgs))
    {
      b(0, paramj);
      AppMethodBeat.o(9507);
      return true;
    }
    AppMethodBeat.o(9507);
    return false;
  }
  
  public final j aSG(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(9506);
    paramString = "SELECT * FROM RecordCDNInfo WHERE mediaId='" + paramString + "'";
    Cursor localCursor = this.db.rawQuery(paramString, null, 2);
    paramString = localObject;
    if (localCursor != null)
    {
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        paramString = new j();
        paramString.convertFrom(localCursor);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(9506);
    return paramString;
  }
  
  public final List<j> agp(int paramInt)
  {
    AppMethodBeat.i(9505);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = "SELECT * FROM RecordCDNInfo WHERE recordLocalId = ".concat(String.valueOf(paramInt));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        j localj = new j();
        localj.convertFrom((Cursor)localObject);
        localLinkedList.add(localj);
      }
      ((Cursor)localObject).close();
    }
    Log.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(9505);
    return localLinkedList;
  }
  
  public final void b(final d paramd)
  {
    AppMethodBeat.i(9502);
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9498);
        l.a(l.this).remove(paramd);
        AppMethodBeat.o(9498);
      }
    });
    AppMethodBeat.o(9502);
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(9510);
    if (paramj != null)
    {
      Log.v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", new Object[] { paramj });
      if (super.insert(paramj))
      {
        b(2, paramj);
        AppMethodBeat.o(9510);
        return true;
      }
    }
    else
    {
      Log.e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
      AppMethodBeat.o(9510);
      return false;
    }
    AppMethodBeat.o(9510);
    return false;
  }
  
  public final boolean b(j paramj, String... paramVarArgs)
  {
    AppMethodBeat.i(9508);
    if (super.update(paramj, paramVarArgs))
    {
      b(1, paramj);
      AppMethodBeat.o(9508);
      return true;
    }
    AppMethodBeat.o(9508);
    return false;
  }
  
  public final List<j> gGe()
  {
    AppMethodBeat.i(9504);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = this.db.rawQuery("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2 AND status != -1", null, 2);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        j localj = new j();
        localj.convertFrom(localCursor);
        localLinkedList.add(localj);
      }
      localCursor.close();
    }
    Log.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(9504);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.l
 * JD-Core Version:    0.7.0.1
 */