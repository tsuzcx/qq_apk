package com.tencent.mm.plugin.profile.ui.newbizinfo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends j<h>
{
  public static final String[] fkl;
  public static final String[] fkm;
  
  static
  {
    AppMethodBeat.i(23959);
    fkl = new String[] { j.getCreateSQLs(h.fkk, "ProfileInfo") };
    fkm = new String[0];
    AppMethodBeat.o(23959);
  }
  
  public a(e parame)
  {
    super(parame, h.fkk, "ProfileInfo", fkm);
  }
  
  public final h Xk(String paramString)
  {
    AppMethodBeat.i(23958);
    h localh = new h();
    localh.field_username = paramString;
    if (!get(localh, new String[] { "username" }))
    {
      ab.e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
      AppMethodBeat.o(23958);
      return null;
    }
    ab.i("MicroMsg.ProfileInfoStorage", "get username:%s", new Object[] { localh.field_username });
    AppMethodBeat.o(23958);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.d.a
 * JD-Core Version:    0.7.0.1
 */