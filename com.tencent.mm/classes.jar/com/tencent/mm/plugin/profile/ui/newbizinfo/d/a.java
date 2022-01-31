package com.tencent.mm.plugin.profile.ui.newbizinfo.d;

import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends i<d>
{
  public static final String[] dUb = { i.a(d.dUa, "ProfileInfo") };
  public static final String[] dUc = new String[0];
  
  public a(e parame)
  {
    super(parame, d.dUa, "ProfileInfo", dUc);
  }
  
  public final d Lb(String paramString)
  {
    d locald = new d();
    locald.field_username = paramString;
    if (!b(locald, new String[] { "username" }))
    {
      y.e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
      return null;
    }
    y.i("MicroMsg.ProfileInfoStorage", "get username:%s", new Object[] { locald.field_username });
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.d.a
 * JD-Core Version:    0.7.0.1
 */