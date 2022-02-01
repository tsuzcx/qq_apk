package com.tencent.mm.plugin.profile.ui.newbizinfo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends j<h>
{
  public static final String[] hGX;
  public static final String[] hGY;
  
  static
  {
    AppMethodBeat.i(27598);
    hGX = new String[] { j.getCreateSQLs(h.hGW, "ProfileInfo") };
    hGY = new String[0];
    AppMethodBeat.o(27598);
  }
  
  public a(e parame)
  {
    super(parame, h.hGW, "ProfileInfo", hGY);
  }
  
  public final h awh(String paramString)
  {
    AppMethodBeat.i(27597);
    h localh = new h();
    localh.field_username = paramString;
    if (!get(localh, new String[] { "username" }))
    {
      ae.e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
      AppMethodBeat.o(27597);
      return null;
    }
    ae.i("MicroMsg.ProfileInfoStorage", "get username:%s", new Object[] { localh.field_username });
    AppMethodBeat.o(27597);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.d.a
 * JD-Core Version:    0.7.0.1
 */