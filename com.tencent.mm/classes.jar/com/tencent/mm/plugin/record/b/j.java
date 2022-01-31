package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class j
  extends com.tencent.mm.sdk.e.j<i>
  implements com.tencent.mm.plugin.record.a.e
{
  private com.tencent.mm.sdk.e.e db;
  private Vector<d> pYG;
  
  public j(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, i.info, "RecordCDNInfo", null);
    AppMethodBeat.i(135678);
    this.pYG = new Vector();
    this.db = parame;
    AppMethodBeat.o(135678);
  }
  
  private void b(int paramInt, i parami)
  {
    AppMethodBeat.i(135681);
    g.RO().ac(new j.3(this, paramInt, parami));
    AppMethodBeat.o(135681);
  }
  
  public final List<i> Ck(int paramInt)
  {
    AppMethodBeat.i(135683);
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
    ab.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(135683);
    return localLinkedList;
  }
  
  public final i XR(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(135684);
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
    AppMethodBeat.o(135684);
    return paramString;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(135679);
    g.RO().ac(new j.1(this, paramd));
    AppMethodBeat.o(135679);
  }
  
  public final boolean a(i parami)
  {
    AppMethodBeat.i(135687);
    if (super.replace(parami))
    {
      b(1, parami);
      AppMethodBeat.o(135687);
      return true;
    }
    AppMethodBeat.o(135687);
    return false;
  }
  
  public final boolean a(i parami, String... paramVarArgs)
  {
    AppMethodBeat.i(135685);
    if (super.delete(parami, paramVarArgs))
    {
      b(0, parami);
      AppMethodBeat.o(135685);
      return true;
    }
    AppMethodBeat.o(135685);
    return false;
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(135680);
    g.RO().ac(new j.2(this, paramd));
    AppMethodBeat.o(135680);
  }
  
  public final boolean b(i parami)
  {
    AppMethodBeat.i(135688);
    if (parami != null)
    {
      ab.v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", new Object[] { parami });
      if (super.insert(parami))
      {
        b(2, parami);
        AppMethodBeat.o(135688);
        return true;
      }
    }
    else
    {
      ab.e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
      AppMethodBeat.o(135688);
      return false;
    }
    AppMethodBeat.o(135688);
    return false;
  }
  
  public final boolean b(i parami, String... paramVarArgs)
  {
    AppMethodBeat.i(135686);
    if (super.update(parami, paramVarArgs))
    {
      b(1, parami);
      AppMethodBeat.o(135686);
      return true;
    }
    AppMethodBeat.o(135686);
    return false;
  }
  
  public final List<i> cfM()
  {
    AppMethodBeat.i(135682);
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
    ab.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(135682);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.j
 * JD-Core Version:    0.7.0.1
 */