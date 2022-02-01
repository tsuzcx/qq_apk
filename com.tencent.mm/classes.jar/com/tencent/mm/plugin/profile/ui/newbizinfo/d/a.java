package com.tencent.mm.plugin.profile.ui.newbizinfo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a
  extends MAutoStorage<h>
{
  public static final String[] iBh;
  public static final String[] iBi;
  
  static
  {
    AppMethodBeat.i(27598);
    iBh = new String[] { MAutoStorage.getCreateSQLs(h.iBg, "ProfileInfo") };
    iBi = new String[0];
    AppMethodBeat.o(27598);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, h.iBg, "ProfileInfo", iBi);
  }
  
  public final h aKz(String paramString)
  {
    AppMethodBeat.i(27597);
    h localh = new h();
    localh.field_username = paramString;
    if (!get(localh, new String[] { "username" }))
    {
      Log.e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
      AppMethodBeat.o(27597);
      return null;
    }
    Log.i("MicroMsg.ProfileInfoStorage", "get username:%s", new Object[] { localh.field_username });
    AppMethodBeat.o(27597);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.d.a
 * JD-Core Version:    0.7.0.1
 */