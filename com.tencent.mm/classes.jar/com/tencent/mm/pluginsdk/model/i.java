package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class i
  implements t
{
  public static boolean vKi = false;
  private static i vKj;
  public i.a vKk;
  
  public static b alj(String paramString)
  {
    AppMethodBeat.i(27299);
    if (paramString == null)
    {
      AppMethodBeat.o(27299);
      return null;
    }
    paramString = br.F(paramString, "PersonalAppSetting");
    if (paramString == null)
    {
      AppMethodBeat.o(27299);
      return null;
    }
    paramString = (String)paramString.get(".PersonalAppSetting.OpenID");
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(27299);
      return null;
    }
    b localb = new b();
    localb.vKl = paramString;
    AppMethodBeat.o(27299);
    return localb;
  }
  
  public static i dkZ()
  {
    AppMethodBeat.i(27296);
    if (vKj == null) {
      vKj = new i();
    }
    i locali = vKj;
    AppMethodBeat.o(27296);
    return locali;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, x paramx)
  {
    AppMethodBeat.i(27298);
    if (!aw.RG())
    {
      AppMethodBeat.o(27298);
      return;
    }
    ab.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramx == null)
    {
      ab.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
      AppMethodBeat.o(27298);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramx.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(27298);
      return;
      if ((ah.getContext() == null) || (a.a.caj() == null))
      {
        ab.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
        AppMethodBeat.o(27298);
        return;
      }
      ab.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (l)paramx;
      if (this.vKk != null) {
        this.vKk.a(paramString);
      }
    }
  }
  
  public final void dla()
  {
    AppMethodBeat.i(27297);
    if (!aw.RG())
    {
      AppMethodBeat.o(27297);
      return;
    }
    al.caf().a(14, this);
    vKi = true;
    AppMethodBeat.o(27297);
  }
  
  public static final class b
  {
    public String vKl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.i
 * JD-Core Version:    0.7.0.1
 */