package com.tencent.mm.plugin.selectrecord.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.List;

public class b
  extends MAutoStorage<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(255141);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "SelectRecord") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS SelectRecord_historyIdIndex ON SelectRecord ( historyId )" };
    AppMethodBeat.o(255141);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "SelectRecord", INDEX_CREATE);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(255132);
    if (parama == null)
    {
      AppMethodBeat.o(255132);
      return false;
    }
    boolean bool = super.insert(parama);
    AppMethodBeat.o(255132);
    return bool;
  }
  
  public final ca aXL(String paramString)
  {
    AppMethodBeat.i(255136);
    ca localca1 = new ca();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(255136);
      return localca1;
    }
    paramString = this.db.query("SelectRecord", a.info.columns, "historyId=?", new String[] { paramString }, null, null, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(255136);
      return localca1;
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
      AppMethodBeat.o(255136);
    }
    int i;
    if (i == 0)
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(255136);
      return localca2;
    }
    Object localObject = (a)localArrayList.get(0);
    localObject = ((n)h.ae(n.class)).eSe().Oq(((a)localObject).field_msgId);
    if (paramString != null) {
      paramString.close();
    }
    AppMethodBeat.o(255136);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.d.b
 * JD-Core Version:    0.7.0.1
 */