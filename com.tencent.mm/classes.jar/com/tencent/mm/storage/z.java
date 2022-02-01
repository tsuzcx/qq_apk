package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizRecExposeInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/storage/BizRecExposeInfo;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "totalCount", "", "getTotalCount", "()I", "deleteTooOldData", "", "getByExposeId", "exposeId", "", "getTodayExposeRecCardCount", "type", "insertOrUpdate", "", "info", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends MAutoStorage<y>
{
  private static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static final z.a acEZ;
  private final h omV;
  
  static
  {
    AppMethodBeat.i(248770);
    acEZ = new z.a((byte)0);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(y.info, "BizRecExposeInfo") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS biz_rec_exposeTime_type_index ON BizRecExposeInfo (exposeTime,exposeType)" };
    AppMethodBeat.o(248770);
  }
  
  public z(h paramh)
  {
    super((ISQLiteDatabase)paramh, y.info, "BizRecExposeInfo", INDEX_CREATE);
    AppMethodBeat.i(248757);
    this.omV = paramh;
    AppMethodBeat.o(248757);
  }
  
  public final boolean a(y paramy)
  {
    y localy = null;
    AppMethodBeat.i(248778);
    s.u(paramy, "info");
    paramy.field_exposeId = (paramy.field_msgId + '-' + paramy.field_exposeType);
    Object localObject = paramy.field_exposeId;
    s.s(localObject, "info.field_exposeId");
    s.u(localObject, "exposeId");
    localObject = "SELECT * FROM BizRecExposeInfo WHERE exposeId = '" + (String)localObject + "' limit 1";
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst())
    {
      localy = new y();
      localy.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    if (localy != null)
    {
      Log.i("MicroMsg.BizRecExposeInfoStorage", "insertOrUpdate exist");
      AppMethodBeat.o(248778);
      return false;
    }
    boolean bool = super.insertNotify((IAutoDBItem)paramy, false);
    Log.i("MicroMsg.BizRecExposeInfoStorage", "insertOrUpdate ret=" + bool + ", type=" + paramy.field_exposeType);
    d.B((a)new b(this));
    AppMethodBeat.o(248778);
    return bool;
  }
  
  public final int ayz(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(248784);
    long l = System.currentTimeMillis();
    Object localObject = "SELECT count(*) FROM BizRecExposeInfo where exposeTime > " + (l - 86400000L) + " and exposeType = " + paramInt;
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    Log.d("MicroMsg.BizRecExposeInfoStorage", "getTodayExposeRecCardCount count=" + i + ", type=" + paramInt);
    AppMethodBeat.o(248784);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(z paramz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.z
 * JD-Core Version:    0.7.0.1
 */