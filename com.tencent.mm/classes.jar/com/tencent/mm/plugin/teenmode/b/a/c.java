package com.tencent.mm.plugin.teenmode.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/storage/TeenModeAuthorizationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeAuthorization;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "get", "type", "", "key", "", "msgSvrId", "", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends MAutoStorage<e>
{
  public static final c.a SZo;
  private static final String ptT;
  private static final String[] ptU;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(278911);
    SZo = new c.a((byte)0);
    ptT = "TeenModeAuthorization";
    ptU = new String[] { MAutoStorage.getCreateSQLs(e.dbInfo, "TeenModeAuthorization") };
    AppMethodBeat.o(278911);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, e.dbInfo, "TeenModeAuthorization", null);
    AppMethodBeat.i(278890);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(278890);
  }
  
  public final e b(int paramInt, String paramString, long paramLong)
  {
    AppMethodBeat.i(278920);
    s.u(paramString, "key");
    e locale = new e();
    locale.field_businessType = paramInt;
    locale.field_businessKey = paramString;
    locale.field_msgSvrId = paramLong;
    String str = "select * from " + ptT + " where businessType = " + paramInt + " and businessKey = '" + paramString + "' ";
    paramString = str;
    if (paramLong > 0L) {
      paramString = str + " and msgSvrId = " + paramLong;
    }
    paramString = s.X(paramString, " order by time desc ");
    paramString = this.db.rawQuery(paramString, null);
    if (paramString.moveToNext()) {
      locale.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(278920);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.a.c
 * JD-Core Version:    0.7.0.1
 */