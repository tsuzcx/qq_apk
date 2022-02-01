package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.e.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class t
  extends MAutoStorage<s>
{
  private static String QYM;
  public static String QYN;
  public static String QYO;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(176289);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(s.info, "snsDraft") };
    QYM = " (snsDraft.extFlag & 2 == 0 ) ";
    QYN = " (snsDraft.extFlag & 2 != 0 ) ";
    QYO = " order by snsDraft.timestamp desc";
    AppMethodBeat.o(176289);
  }
  
  public t(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, s.info, "snsDraft", null);
    AppMethodBeat.i(176285);
    this.db = paramISQLiteDatabase;
    Log.i("MicroMsg.SnsDraftStorage", "createDraftStorage " + paramISQLiteDatabase + "  " + Thread.currentThread().getId());
    AppMethodBeat.o(176285);
  }
  
  public final void DX(boolean paramBoolean)
  {
    AppMethodBeat.i(176286);
    Object localObject;
    if (paramBoolean)
    {
      h.baF();
      localObject = (String)h.baE().ban().get(at.a.acKp, null);
    }
    while (!Util.isNullOrNil((String)localObject))
    {
      localObject = e.bFB((String)localObject);
      if (!Util.isNullOrNil((byte[])localObject)) {
        if (paramBoolean)
        {
          h.baF();
          h.baE().ban().set(at.a.acKp, "");
          b("draft_text", (byte[])localObject, 0);
          AppMethodBeat.o(176286);
          return;
          h.baF();
          localObject = (String)h.baE().ban().get(at.a.acKo, null);
        }
        else
        {
          h.baF();
          h.baE().ban().set(at.a.acKo, "");
          b("draft_normal", (byte[])localObject, 0);
        }
      }
    }
    AppMethodBeat.o(176286);
  }
  
  public final s aZP(String paramString)
  {
    Integer localInteger = null;
    AppMethodBeat.i(176288);
    s locals = new s();
    Object localObject = "select *,rowid from snsDraft  where snsDraft.key='" + paramString + "' limit 1";
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locals.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      if (locals.field_draft != null) {
        break label123;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsDraftStorage", "readDraft: %s, %s", new Object[] { paramString, localInteger });
      AppMethodBeat.o(176288);
      return locals;
      ((Cursor)localObject).close();
      AppMethodBeat.o(176288);
      return null;
      label123:
      localInteger = Integer.valueOf(locals.field_draft.length);
    }
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(176287);
    if (paramArrayOfByte == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramArrayOfByte.length))
    {
      Log.i("MicroMsg.SnsDraftStorage", "writeDraft: %s, %s", new Object[] { paramString, localObject });
      localObject = new s();
      ((s)localObject).field_key = paramString;
      ((s)localObject).field_timestamp = System.currentTimeMillis();
      ((s)localObject).field_draft = paramArrayOfByte;
      ((s)localObject).field_extFlag = paramInt;
      super.replace((IAutoDBItem)localObject);
      AppMethodBeat.o(176287);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.t
 * JD-Core Version:    0.7.0.1
 */