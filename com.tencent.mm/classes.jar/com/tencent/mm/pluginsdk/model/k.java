package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class k
  implements u
{
  public static boolean Dha = false;
  private static k Dhb;
  public a Dhc;
  
  public static b aFY(String paramString)
  {
    AppMethodBeat.i(30992);
    if (paramString == null)
    {
      AppMethodBeat.o(30992);
      return null;
    }
    paramString = bv.L(paramString, "PersonalAppSetting");
    if (paramString == null)
    {
      AppMethodBeat.o(30992);
      return null;
    }
    paramString = (String)paramString.get(".PersonalAppSetting.OpenID");
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30992);
      return null;
    }
    b localb = new b();
    localb.Dhd = paramString;
    AppMethodBeat.o(30992);
    return localb;
  }
  
  public static k eKA()
  {
    AppMethodBeat.i(30989);
    if (Dhb == null) {
      Dhb = new k();
    }
    k localk = Dhb;
    AppMethodBeat.o(30989);
    return localk;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(30991);
    if (!az.agM())
    {
      AppMethodBeat.o(30991);
      return;
    }
    ac.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramaa == null)
    {
      ac.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
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
      if ((ai.getContext() == null) || (a.a.dnF() == null))
      {
        ac.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
        AppMethodBeat.o(30991);
        return;
      }
      ac.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (n)paramaa;
      if (this.Dhc != null) {
        this.Dhc.a(paramString);
      }
    }
  }
  
  public final void eKB()
  {
    AppMethodBeat.i(30990);
    if (!az.agM())
    {
      AppMethodBeat.o(30990);
      return;
    }
    ap.dnB().a(14, this);
    Dha = true;
    AppMethodBeat.o(30990);
  }
  
  public static abstract interface a
  {
    public abstract void a(n paramn);
  }
  
  public static final class b
  {
    public String Dhd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.k
 * JD-Core Version:    0.7.0.1
 */