package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class j
  extends com.tencent.mm.sdk.e.j<i>
  implements com.tencent.mm.plugin.record.a.e
{
  private com.tencent.mm.sdk.e.e db;
  private Vector<d> wjn;
  
  public j(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, i.info, "RecordCDNInfo", null);
    AppMethodBeat.i(9500);
    this.wjn = new Vector();
    this.db = parame;
    AppMethodBeat.o(9500);
  }
  
  private void b(final int paramInt, final i parami)
  {
    AppMethodBeat.i(9503);
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9499);
        Iterator localIterator = j.a(j.this).iterator();
        while (localIterator.hasNext()) {
          ((d)localIterator.next()).a(paramInt, parami);
        }
        AppMethodBeat.o(9499);
      }
    });
    AppMethodBeat.o(9503);
  }
  
  public final List<i> LZ(int paramInt)
  {
    AppMethodBeat.i(9505);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = "SELECT * FROM RecordCDNInfo WHERE recordLocalId = ".concat(String.valueOf(paramInt));
    localObject = this.db.a((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        i locali = new i();
        locali.convertFrom((Cursor)localObject);
        localLinkedList.add(locali);
      }
      ((Cursor)localObject).close();
    }
    ac.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(9505);
    return localLinkedList;
  }
  
  public final void a(final d paramd)
  {
    AppMethodBeat.i(9501);
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9497);
        if (!j.a(j.this).contains(paramd)) {
          j.a(j.this).add(paramd);
        }
        AppMethodBeat.o(9497);
      }
    });
    AppMethodBeat.o(9501);
  }
  
  public final boolean a(i parami)
  {
    AppMethodBeat.i(9509);
    if (super.replace(parami))
    {
      b(1, parami);
      AppMethodBeat.o(9509);
      return true;
    }
    AppMethodBeat.o(9509);
    return false;
  }
  
  public final boolean a(i parami, String... paramVarArgs)
  {
    AppMethodBeat.i(9507);
    if (super.delete(parami, paramVarArgs))
    {
      b(0, parami);
      AppMethodBeat.o(9507);
      return true;
    }
    AppMethodBeat.o(9507);
    return false;
  }
  
  public final i aqr(String paramString)
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
        paramString = new i();
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
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9498);
        j.a(j.this).remove(paramd);
        AppMethodBeat.o(9498);
      }
    });
    AppMethodBeat.o(9502);
  }
  
  public final boolean b(i parami)
  {
    AppMethodBeat.i(9510);
    if (parami != null)
    {
      ac.v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", new Object[] { parami });
      if (super.insert(parami))
      {
        b(2, parami);
        AppMethodBeat.o(9510);
        return true;
      }
    }
    else
    {
      ac.e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
      AppMethodBeat.o(9510);
      return false;
    }
    AppMethodBeat.o(9510);
    return false;
  }
  
  public final boolean b(i parami, String... paramVarArgs)
  {
    AppMethodBeat.i(9508);
    if (super.update(parami, paramVarArgs))
    {
      b(1, parami);
      AppMethodBeat.o(9508);
      return true;
    }
    AppMethodBeat.o(9508);
    return false;
  }
  
  public final List<i> dtJ()
  {
    AppMethodBeat.i(9504);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = this.db.a("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2 AND status != -1", null, 2);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        i locali = new i();
        locali.convertFrom(localCursor);
        localLinkedList.add(locali);
      }
      localCursor.close();
    }
    ac.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(9504);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.j
 * JD-Core Version:    0.7.0.1
 */