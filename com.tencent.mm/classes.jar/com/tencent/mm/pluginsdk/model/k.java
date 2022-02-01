package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ao;
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
  public static boolean ELK = false;
  private static k ELL;
  public a ELM;
  
  public static b aLy(String paramString)
  {
    AppMethodBeat.i(30992);
    if (paramString == null)
    {
      AppMethodBeat.o(30992);
      return null;
    }
    paramString = bw.M(paramString, "PersonalAppSetting");
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
    localb.ELN = paramString;
    AppMethodBeat.o(30992);
    return localb;
  }
  
  public static k eZu()
  {
    AppMethodBeat.i(30989);
    if (ELL == null) {
      ELL = new k();
    }
    k localk = ELL;
    AppMethodBeat.o(30989);
    return localk;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(30991);
    if (!ba.ajx())
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
      if ((aj.getContext() == null) || (a.a.dxX() == null))
      {
        ad.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
        AppMethodBeat.o(30991);
        return;
      }
      ad.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (n)paramaa;
      if (this.ELM != null) {
        this.ELM.a(paramString);
      }
    }
  }
  
  public final void eZv()
  {
    AppMethodBeat.i(30990);
    if (!ba.ajx())
    {
      AppMethodBeat.o(30990);
      return;
    }
    ao.dxT().a(14, this);
    ELK = true;
    AppMethodBeat.o(30990);
  }
  
  public static abstract interface a
  {
    public abstract void a(n paramn);
  }
  
  public static final class b
  {
    public String ELN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.k
 * JD-Core Version:    0.7.0.1
 */