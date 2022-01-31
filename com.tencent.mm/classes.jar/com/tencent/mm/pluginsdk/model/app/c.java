package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends j<b>
{
  public static final String[] SQL_CREATE;
  e db;
  
  static
  {
    AppMethodBeat.i(79236);
    SQL_CREATE = new String[] { j.getCreateSQLs(b.info, "appattach") };
    AppMethodBeat.o(79236);
  }
  
  public c(e parame)
  {
    super(parame, b.info, "appattach", null);
    this.db = parame;
  }
  
  public final boolean a(b paramb, String... paramVarArgs)
  {
    AppMethodBeat.i(79233);
    boolean bool = super.update(paramb, paramVarArgs);
    ab.d("MicroMsg.AppAttachInfoStorage", "update AppAttachInfo field_mediaId %s field_mediaSvrId %s ret %s %s", new Object[] { paramb.field_mediaId, paramb.field_mediaSvrId, Boolean.valueOf(bool), "" });
    AppMethodBeat.o(79233);
    return bool;
  }
  
  public final b alo(String paramString)
  {
    AppMethodBeat.i(79232);
    b localb = new b();
    localb.field_mediaSvrId = paramString;
    if (get(localb, new String[] { "mediaSvrId" }))
    {
      AppMethodBeat.o(79232);
      return localb;
    }
    if (get(localb, new String[] { "mediaId" }))
    {
      AppMethodBeat.o(79232);
      return localb;
    }
    AppMethodBeat.o(79232);
    return null;
  }
  
  public final void nv(long paramLong)
  {
    AppMethodBeat.i(79231);
    String str = " update appattach set status = 198 , lastModifyTime = " + bo.aox() + " where rowid = " + paramLong;
    this.db.execSQL("appattach", str);
    doNotify();
    AppMethodBeat.o(79231);
  }
  
  public final b nw(long paramLong)
  {
    AppMethodBeat.i(79234);
    b localb = new b();
    localb.field_msgInfoId = paramLong;
    if (get(localb, new String[] { "msgInfoId" }))
    {
      AppMethodBeat.o(79234);
      return localb;
    }
    AppMethodBeat.o(79234);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.c
 * JD-Core Version:    0.7.0.1
 */