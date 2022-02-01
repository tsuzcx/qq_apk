package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class k
  implements u
{
  public static boolean BOM = false;
  private static k BON;
  public a BOO;
  
  public static b aAG(String paramString)
  {
    AppMethodBeat.i(30992);
    if (paramString == null)
    {
      AppMethodBeat.o(30992);
      return null;
    }
    paramString = bw.K(paramString, "PersonalAppSetting");
    if (paramString == null)
    {
      AppMethodBeat.o(30992);
      return null;
    }
    paramString = (String)paramString.get(".PersonalAppSetting.OpenID");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30992);
      return null;
    }
    b localb = new b();
    localb.BOP = paramString;
    AppMethodBeat.o(30992);
    return localb;
  }
  
  public static k evg()
  {
    AppMethodBeat.i(30989);
    if (BON == null) {
      BON = new k();
    }
    k localk = BON;
    AppMethodBeat.o(30989);
    return localk;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(30991);
    if (!az.afw())
    {
      AppMethodBeat.o(30991);
      return;
    }
    ad.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramaa == null)
    {
      ad.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
      AppMethodBeat.o(30991);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramaa.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30991);
      return;
      if ((aj.getContext() == null) || (a.a.cZX() == null))
      {
        ad.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
        AppMethodBeat.o(30991);
        return;
      }
      ad.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (n)paramaa;
      if (this.BOO != null) {
        this.BOO.a(paramString);
      }
    }
  }
  
  public final void evh()
  {
    AppMethodBeat.i(30990);
    if (!az.afw())
    {
      AppMethodBeat.o(30990);
      return;
    }
    ap.cZT().a(14, this);
    BOM = true;
    AppMethodBeat.o(30990);
  }
  
  public static abstract interface a
  {
    public abstract void a(n paramn);
  }
  
  public static final class b
  {
    public String BOP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.k
 * JD-Core Version:    0.7.0.1
 */