package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class e
  extends i<f>
  implements d
{
  private com.tencent.mm.sdk.e.e dXw;
  private Vector<c> nta = new Vector();
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, f.buS, "RecordCDNInfo", null);
    this.dXw = parame;
  }
  
  private void b(int paramInt, f paramf)
  {
    g.DS().O(new e.3(this, paramInt, paramf));
  }
  
  public final f LG(String paramString)
  {
    Object localObject = null;
    paramString = "SELECT * FROM RecordCDNInfo WHERE mediaId='" + paramString + "'";
    Cursor localCursor = this.dXw.a(paramString, null, 2);
    paramString = localObject;
    if (localCursor != null)
    {
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        paramString = new f();
        paramString.d(localCursor);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    return paramString;
  }
  
  public final void a(c paramc)
  {
    g.DS().O(new e.1(this, paramc));
  }
  
  public final boolean a(f paramf)
  {
    if (super.a(paramf))
    {
      b(1, paramf);
      return true;
    }
    return false;
  }
  
  public final boolean a(f paramf, String... paramVarArgs)
  {
    boolean bool = false;
    if (super.a(paramf, paramVarArgs))
    {
      b(0, paramf);
      bool = true;
    }
    return bool;
  }
  
  public final void b(c paramc)
  {
    g.DS().O(new e.2(this, paramc));
  }
  
  public final boolean b(f paramf)
  {
    if (paramf != null)
    {
      y.v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", new Object[] { paramf });
      if (super.b(paramf))
      {
        b(2, paramf);
        return true;
      }
    }
    else
    {
      y.e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
      return false;
    }
    return false;
  }
  
  public final boolean b(f paramf, String... paramVarArgs)
  {
    if (super.c(paramf, paramVarArgs))
    {
      b(1, paramf);
      return true;
    }
    return false;
  }
  
  public final List<f> bvt()
  {
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = this.dXw.a("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2 AND status != -1", null, 2);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        f localf = new f();
        localf.d(localCursor);
        localLinkedList.add(localf);
      }
      localCursor.close();
    }
    y.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    return localLinkedList;
  }
  
  public final List<f> wy(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = "SELECT * FROM RecordCDNInfo WHERE recordLocalId = " + paramInt;
    localObject = this.dXw.a((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        f localf = new f();
        localf.d((Cursor)localObject);
        localLinkedList.add(localf);
      }
      ((Cursor)localObject).close();
    }
    y.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.e
 * JD-Core Version:    0.7.0.1
 */