package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class m
  extends j<l>
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(176289);
    SQL_CREATE = new String[] { j.getCreateSQLs(l.info, "snsDraft") };
    AppMethodBeat.o(176289);
  }
  
  public m(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, l.info, "snsDraft", null);
    AppMethodBeat.i(176285);
    this.db = parame;
    ad.i("MicroMsg.SnsDraftStorage", "createDraftStorage " + parame + "  " + Thread.currentThread().getId());
    AppMethodBeat.o(176285);
  }
  
  public final l apL(String paramString)
  {
    Integer localInteger = null;
    AppMethodBeat.i(176288);
    l locall = new l();
    Object localObject = "select *,rowid from snsDraft  where snsDraft.key='" + paramString + "' limit 1";
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locall.convertFrom((Cursor)localObject);
      ((Cursor)localObject).close();
      if (locall.field_draft != null) {
        break label123;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.SnsDraftStorage", "readDraft: %s, %s", new Object[] { paramString, localInteger });
      AppMethodBeat.o(176288);
      return locall;
      ((Cursor)localObject).close();
      AppMethodBeat.o(176288);
      return null;
      label123:
      localInteger = Integer.valueOf(locall.field_draft.length);
    }
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(176287);
    if (paramArrayOfByte == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramArrayOfByte.length))
    {
      ad.i("MicroMsg.SnsDraftStorage", "writeDraft: %s, %s", new Object[] { paramString, localObject });
      localObject = new l();
      ((l)localObject).field_key = paramString;
      ((l)localObject).field_timestamp = System.currentTimeMillis();
      ((l)localObject).field_draft = paramArrayOfByte;
      ((l)localObject).field_extFlag = paramInt;
      super.replace((c)localObject);
      AppMethodBeat.o(176287);
      return;
    }
  }
  
  public final void qe(boolean paramBoolean)
  {
    AppMethodBeat.i(176286);
    Object localObject;
    if (paramBoolean)
    {
      g.afC();
      localObject = (String)g.afB().afk().get(ae.a.Fiq, null);
    }
    while (!bt.isNullOrNil((String)localObject))
    {
      localObject = com.tencent.d.f.e.aNK((String)localObject);
      if (!bt.cw((byte[])localObject)) {
        if (paramBoolean)
        {
          g.afC();
          g.afB().afk().set(ae.a.Fiq, "");
          b("draft_text", (byte[])localObject, 0);
          AppMethodBeat.o(176286);
          return;
          g.afC();
          localObject = (String)g.afB().afk().get(ae.a.Fip, null);
        }
        else
        {
          g.afC();
          g.afB().afk().set(ae.a.Fip, "");
          b("draft_normal", (byte[])localObject, 0);
        }
      }
    }
    AppMethodBeat.o(176286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.m
 * JD-Core Version:    0.7.0.1
 */