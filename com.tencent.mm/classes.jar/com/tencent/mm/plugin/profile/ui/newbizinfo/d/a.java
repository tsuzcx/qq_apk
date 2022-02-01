package com.tencent.mm.plugin.profile.ui.newbizinfo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends j<h>
{
  public static final String[] hlS;
  public static final String[] hlT;
  
  static
  {
    AppMethodBeat.i(27598);
    hlS = new String[] { j.getCreateSQLs(h.hlR, "ProfileInfo") };
    hlT = new String[0];
    AppMethodBeat.o(27598);
  }
  
  public a(e parame)
  {
    super(parame, h.hlR, "ProfileInfo", hlT);
  }
  
  public final h apM(String paramString)
  {
    AppMethodBeat.i(27597);
    h localh = new h();
    localh.field_username = paramString;
    if (!get(localh, new String[] { "username" }))
    {
      ac.e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
      AppMethodBeat.o(27597);
      return null;
    }
    ac.i("MicroMsg.ProfileInfoStorage", "get username:%s", new Object[] { localh.field_username });
    AppMethodBeat.o(27597);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.d.a
 * JD-Core Version:    0.7.0.1
 */