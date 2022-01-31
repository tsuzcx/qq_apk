package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.mm.h.c.t;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class o
  extends i<t>
{
  public static final String[] dXp = { i.a(n.buS, "AppSort") };
  public e dXw;
  
  public o(e parame)
  {
    super(parame, n.buS, "AppSort", null);
    this.dXw = parame;
    parame.gk("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
    parame.gk("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
  }
  
  public final boolean a(n paramn)
  {
    return super.b(paramn);
  }
  
  public final List<String> hc(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder(256);
    ((StringBuilder)localObject).append("select * from AppSort");
    ((StringBuilder)localObject).append(" where ");
    ((StringBuilder)localObject).append("flag = ").append(paramLong);
    ((StringBuilder)localObject).append(" order by sortId desc ");
    localObject = rawQuery(((StringBuilder)localObject).toString(), new String[0]);
    if (localObject == null)
    {
      y.e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
      return null;
    }
    y.d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
    int i = ((Cursor)localObject).getColumnIndex("appId");
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(((Cursor)localObject).getString(i));
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.o
 * JD-Core Version:    0.7.0.1
 */