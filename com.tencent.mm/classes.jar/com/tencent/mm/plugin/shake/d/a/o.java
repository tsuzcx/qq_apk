package com.tencent.mm.plugin.shake.d.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class o
  extends j<n>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(24679);
    INDEX_CREATE = new String[0];
    SQL_CREATE = new String[] { j.getCreateSQLs(n.info, "shaketvhistory") };
    AppMethodBeat.o(24679);
  }
  
  public o(e parame)
  {
    super(parame, n.info, "shaketvhistory", SQL_CREATE);
    this.db = parame;
  }
  
  public final Cursor clT()
  {
    AppMethodBeat.i(24678);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SELECT * FROM shaketvhistory ORDER BY createtime DESC");
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.db.rawQuery((String)localObject, null);
    AppMethodBeat.o(24678);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.o
 * JD-Core Version:    0.7.0.1
 */