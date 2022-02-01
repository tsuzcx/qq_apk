package com.tencent.mm.plugin.profile.ui.newbizinfo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends j<h>
{
  public static final String[] hEf;
  public static final String[] hEg;
  
  static
  {
    AppMethodBeat.i(27598);
    hEf = new String[] { j.getCreateSQLs(h.hEe, "ProfileInfo") };
    hEg = new String[0];
    AppMethodBeat.o(27598);
  }
  
  public a(e parame)
  {
    super(parame, h.hEe, "ProfileInfo", hEg);
  }
  
  public final h auS(String paramString)
  {
    AppMethodBeat.i(27597);
    h localh = new h();
    localh.field_username = paramString;
    if (!get(localh, new String[] { "username" }))
    {
      ad.e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
      AppMethodBeat.o(27597);
      return null;
    }
    ad.i("MicroMsg.ProfileInfoStorage", "get username:%s", new Object[] { localh.field_username });
    AppMethodBeat.o(27597);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.d.a
 * JD-Core Version:    0.7.0.1
 */