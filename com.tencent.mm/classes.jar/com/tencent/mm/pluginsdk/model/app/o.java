package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.v;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends j<v>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(27354);
    SQL_CREATE = new String[] { j.getCreateSQLs(n.info, "AppSort") };
    AppMethodBeat.o(27354);
  }
  
  public o(e parame)
  {
    super(parame, n.info, "AppSort", null);
    AppMethodBeat.i(27351);
    this.db = parame;
    parame.execSQL("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
    parame.execSQL("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
    AppMethodBeat.o(27351);
  }
  
  public final boolean a(n paramn)
  {
    AppMethodBeat.i(27353);
    boolean bool = super.insert(paramn);
    AppMethodBeat.o(27353);
    return bool;
  }
  
  public final List<String> ny(long paramLong)
  {
    AppMethodBeat.i(27352);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder(256);
    ((StringBuilder)localObject).append("select * from AppSort");
    ((StringBuilder)localObject).append(" where ");
    ((StringBuilder)localObject).append("flag = ").append(paramLong);
    ((StringBuilder)localObject).append(" order by sortId desc ");
    localObject = rawQuery(((StringBuilder)localObject).toString(), new String[0]);
    if (localObject == null)
    {
      ab.e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
      AppMethodBeat.o(27352);
      return null;
    }
    ab.d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
    int i = ((Cursor)localObject).getColumnIndex("appId");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(27352);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.o
 * JD-Core Version:    0.7.0.1
 */