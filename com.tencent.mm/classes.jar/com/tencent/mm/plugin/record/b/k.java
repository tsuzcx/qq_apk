package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class k
  extends com.tencent.mm.sdk.e.j<com.tencent.mm.plugin.record.a.j>
  implements com.tencent.mm.plugin.record.a.e
{
  private com.tencent.mm.sdk.e.e db;
  private Vector<d> xqY;
  
  public k(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, com.tencent.mm.plugin.record.a.j.info, "RecordCDNInfo", null);
    AppMethodBeat.i(9500);
    this.xqY = new Vector();
    this.db = parame;
    AppMethodBeat.o(9500);
  }
  
  private void b(final int paramInt, final com.tencent.mm.plugin.record.a.j paramj)
  {
    AppMethodBeat.i(9503);
    g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9499);
        Iterator localIterator = k.a(k.this).iterator();
        while (localIterator.hasNext()) {
          ((d)localIterator.next()).a(paramInt, paramj);
        }
        AppMethodBeat.o(9499);
      }
    });
    AppMethodBeat.o(9503);
  }
  
  public final List<com.tencent.mm.plugin.record.a.j> Ny(int paramInt)
  {
    AppMethodBeat.i(9505);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = "SELECT * FROM RecordCDNInfo WHERE recordLocalId = ".concat(String.valueOf(paramInt));
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        com.tencent.mm.plugin.record.a.j localj = new com.tencent.mm.plugin.record.a.j();
        localj.convertFrom((Cursor)localObject);
        localLinkedList.add(localj);
      }
      ((Cursor)localObject).close();
    }
    ad.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(9505);
    return localLinkedList;
  }
  
  public final void a(final d paramd)
  {
    AppMethodBeat.i(9501);
    g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9497);
        if (!k.a(k.this).contains(paramd)) {
          k.a(k.this).add(paramd);
        }
        AppMethodBeat.o(9497);
      }
    });
    AppMethodBeat.o(9501);
  }
  
  public final boolean a(com.tencent.mm.plugin.record.a.j paramj)
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
  
  public final boolean a(com.tencent.mm.plugin.record.a.j paramj, String... paramVarArgs)
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
  
  public final com.tencent.mm.plugin.record.a.j avq(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(9506);
    paramString = "SELECT * FROM RecordCDNInfo WHERE mediaId='" + paramString + "'";
    Cursor localCursor = this.db.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor != null)
    {
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        paramString = new com.tencent.mm.plugin.record.a.j();
        paramString.convertFrom(localCursor);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    AppMethodBeat.o(9506);
    return paramString;
  }
  
  public final void b(final d paramd)
  {
    AppMethodBeat.i(9502);
    g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9498);
        k.a(k.this).remove(paramd);
        AppMethodBeat.o(9498);
      }
    });
    AppMethodBeat.o(9502);
  }
  
  public final boolean b(com.tencent.mm.plugin.record.a.j paramj)
  {
    AppMethodBeat.i(9510);
    if (paramj != null)
    {
      ad.v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", new Object[] { paramj });
      if (super.insert(paramj))
      {
        b(2, paramj);
        AppMethodBeat.o(9510);
        return true;
      }
    }
    else
    {
      ad.e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
      AppMethodBeat.o(9510);
      return false;
    }
    AppMethodBeat.o(9510);
    return false;
  }
  
  public final boolean b(com.tencent.mm.plugin.record.a.j paramj, String... paramVarArgs)
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
  
  public final List<com.tencent.mm.plugin.record.a.j> dEg()
  {
    AppMethodBeat.i(9504);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = this.db.a("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2 AND status != -1", null, 2);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        com.tencent.mm.plugin.record.a.j localj = new com.tencent.mm.plugin.record.a.j();
        localj.convertFrom(localCursor);
        localLinkedList.add(localj);
      }
      localCursor.close();
    }
    ad.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(9504);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.k
 * JD-Core Version:    0.7.0.1
 */