package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.d.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class k
  extends MAutoStorage<j>
{
  private static String Kzu;
  public static String Kzv;
  public static String Kzw;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(176289);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(j.info, "snsDraft") };
    Kzu = " (snsDraft.extFlag & 2 == 0 ) ";
    Kzv = " (snsDraft.extFlag & 2 != 0 ) ";
    Kzw = " order by snsDraft.timestamp desc";
    AppMethodBeat.o(176289);
  }
  
  public k(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, j.info, "snsDraft", null);
    AppMethodBeat.i(176285);
    this.db = paramISQLiteDatabase;
    Log.i("MicroMsg.SnsDraftStorage", "createDraftStorage " + paramISQLiteDatabase + "  " + Thread.currentThread().getId());
    AppMethodBeat.o(176285);
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(176287);
    if (paramArrayOfByte == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramArrayOfByte.length))
    {
      Log.i("MicroMsg.SnsDraftStorage", "writeDraft: %s, %s", new Object[] { paramString, localObject });
      localObject = new j();
      ((j)localObject).field_key = paramString;
      ((j)localObject).field_timestamp = System.currentTimeMillis();
      ((j)localObject).field_draft = paramArrayOfByte;
      ((j)localObject).field_extFlag = paramInt;
      super.replace((IAutoDBItem)localObject);
      AppMethodBeat.o(176287);
      return;
    }
  }
  
  public final j bbm(String paramString)
  {
    Integer localInteger = null;
    AppMethodBeat.i(176288);
    j localj = new j();
    Object localObject = "select *,rowid from snsDraft  where snsDraft.key='" + paramString + "' limit 1";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localj.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      if (localj.field_draft != null) {
        break label123;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsDraftStorage", "readDraft: %s, %s", new Object[] { paramString, localInteger });
      AppMethodBeat.o(176288);
      return localj;
      ((Cursor)localObject).close();
      AppMethodBeat.o(176288);
      return null;
      label123:
      localInteger = Integer.valueOf(localj.field_draft.length);
    }
  }
  
  public final void yO(boolean paramBoolean)
  {
    AppMethodBeat.i(176286);
    Object localObject;
    if (paramBoolean)
    {
      h.aHH();
      localObject = (String)h.aHG().aHp().get(ar.a.ViV, null);
    }
    while (!Util.isNullOrNil((String)localObject))
    {
      localObject = e.bCW((String)localObject);
      if (!Util.isNullOrNil((byte[])localObject)) {
        if (paramBoolean)
        {
          h.aHH();
          h.aHG().aHp().set(ar.a.ViV, "");
          b("draft_text", (byte[])localObject, 0);
          AppMethodBeat.o(176286);
          return;
          h.aHH();
          localObject = (String)h.aHG().aHp().get(ar.a.ViU, null);
        }
        else
        {
          h.aHH();
          h.aHG().aHp().set(ar.a.ViU, "");
          b("draft_normal", (byte[])localObject, 0);
        }
      }
    }
    AppMethodBeat.o(176286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.k
 * JD-Core Version:    0.7.0.1
 */