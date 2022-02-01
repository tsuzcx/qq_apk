package com.tencent.mm.plugin.selectrecord.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
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
    AppMethodBeat.i(194005);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "SelectRecord") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS SelectRecord_historyIdIndex ON SelectRecord ( historyId )" };
    AppMethodBeat.o(194005);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "SelectRecord", INDEX_CREATE);
    this.db = parame;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(194002);
    if (parama == null)
    {
      AppMethodBeat.o(194002);
      return false;
    }
    boolean bool = super.insert(parama);
    AppMethodBeat.o(194002);
    return bool;
  }
  
  public final bv ayr(String paramString)
  {
    AppMethodBeat.i(194003);
    bv localbv1 = new bv();
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(194003);
      return localbv1;
    }
    paramString = this.db.a("SelectRecord", a.info.columns, "historyId=?", new String[] { paramString }, null, null, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(194003);
      return localbv1;
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
      AppMethodBeat.o(194003);
    }
    int i;
    if (i == 0)
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(194003);
      return localbv2;
    }
    Object localObject = (a)localArrayList.get(0);
    localObject = ((l)g.ab(l.class)).doJ().ys(((a)localObject).field_msgId);
    if (paramString != null) {
      paramString.close();
    }
    AppMethodBeat.o(194003);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.d.b
 * JD-Core Version:    0.7.0.1
 */