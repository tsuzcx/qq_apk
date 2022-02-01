package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aa;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public final class p
  extends j<aa>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(31047);
    SQL_CREATE = new String[] { j.getCreateSQLs(o.info, "AppSort") };
    AppMethodBeat.o(31047);
  }
  
  public p(e parame)
  {
    super(parame, o.info, "AppSort", null);
    AppMethodBeat.i(31044);
    this.db = parame;
    parame.execSQL("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
    parame.execSQL("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
    AppMethodBeat.o(31044);
  }
  
  public final List<String> Da(long paramLong)
  {
    AppMethodBeat.i(31045);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder(256);
    ((StringBuilder)localObject).append("select * from AppSort");
    ((StringBuilder)localObject).append(" where ");
    ((StringBuilder)localObject).append("flag = ").append(paramLong);
    ((StringBuilder)localObject).append(" order by sortId desc ");
    localObject = rawQuery(((StringBuilder)localObject).toString(), new String[0]);
    if (localObject == null)
    {
      ae.e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
      AppMethodBeat.o(31045);
      return null;
    }
    ae.d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
    int i = ((Cursor)localObject).getColumnIndex("appId");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(31045);
    return localArrayList;
  }
  
  public final boolean a(o paramo)
  {
    AppMethodBeat.i(31046);
    boolean bool = super.insert(paramo);
    AppMethodBeat.o(31046);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.p
 * JD-Core Version:    0.7.0.1
 */