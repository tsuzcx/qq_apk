package com.tencent.mm.plugin.profile.ui.newbizinfo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a
  extends MAutoStorage<g>
{
  public static final String[] lqL;
  public static final String[] lqM;
  
  static
  {
    AppMethodBeat.i(27598);
    lqL = new String[] { MAutoStorage.getCreateSQLs(g.lqK, "ProfileInfo") };
    lqM = new String[0];
    AppMethodBeat.o(27598);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, g.lqK, "ProfileInfo", lqM);
  }
  
  public final g aUX(String paramString)
  {
    AppMethodBeat.i(27597);
    g localg = new g();
    localg.field_username = paramString;
    if (!get(localg, new String[] { "username" }))
    {
      Log.e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
      AppMethodBeat.o(27597);
      return null;
    }
    Log.i("MicroMsg.ProfileInfoStorage", "get username:%s", new Object[] { localg.field_username });
    AppMethodBeat.o(27597);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.d.a
 * JD-Core Version:    0.7.0.1
 */