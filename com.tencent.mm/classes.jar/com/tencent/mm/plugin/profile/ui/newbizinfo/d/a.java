package com.tencent.mm.plugin.profile.ui.newbizinfo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a
  extends MAutoStorage<c>
{
  public static final String[] nVW;
  public static final String[] nVX;
  
  static
  {
    AppMethodBeat.i(27598);
    nVW = new String[] { MAutoStorage.getCreateSQLs(c.nVV, "ProfileInfo") };
    nVX = new String[0];
    AppMethodBeat.o(27598);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.nVV, "ProfileInfo", nVX);
  }
  
  public final c aSe(String paramString)
  {
    AppMethodBeat.i(27597);
    c localc = new c();
    localc.field_username = paramString;
    if (!get(localc, new String[] { "username" }))
    {
      Log.e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
      AppMethodBeat.o(27597);
      return null;
    }
    Log.i("MicroMsg.ProfileInfoStorage", "get username:%s", new Object[] { localc.field_username });
    AppMethodBeat.o(27597);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.d.a
 * JD-Core Version:    0.7.0.1
 */