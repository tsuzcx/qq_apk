package com.tencent.mm.plugin.selectrecord.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends j<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(221249);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "SelectRecord") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS SelectRecord_historyIdIndex ON SelectRecord ( historyId )" };
    AppMethodBeat.o(221249);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "SelectRecord", INDEX_CREATE);
    this.db = parame;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(221246);
    if (parama == null)
    {
      AppMethodBeat.o(221246);
      return false;
    }
    boolean bool = super.insert(parama);
    AppMethodBeat.o(221246);
    return bool;
  }
  
  public final bu aHp(String paramString)
  {
    AppMethodBeat.i(221247);
    bu localbu1 = new bu();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(221247);
      return localbu1;
    }
    paramString = this.db.a("SelectRecord", a.info.columns, "historyId=?", new String[] { paramString }, null, null, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(221247);
      return localbu1;
    }
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      while (paramString.moveToNext())
      {
        a locala = new a();
        locala.convertFrom(paramString);
        localArrayList.add(locala);
      }
      i = localArrayList.size();
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(221247);
    }
    int i;
    if (i == 0)
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(221247);
      return localbu2;
    }
    Object localObject = (a)localArrayList.get(0);
    localObject = ((l)g.ab(l.class)).dlK().xY(((a)localObject).field_msgId);
    if (paramString != null) {
      paramString.close();
    }
    AppMethodBeat.o(221247);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.e.b
 * JD-Core Version:    0.7.0.1
 */