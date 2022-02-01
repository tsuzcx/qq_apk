package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class k
  implements u
{
  public static boolean Fei = false;
  private static k Fej;
  public a Fek;
  
  public static b aMU(String paramString)
  {
    AppMethodBeat.i(30992);
    if (paramString == null)
    {
      AppMethodBeat.o(30992);
      return null;
    }
    paramString = bx.M(paramString, "PersonalAppSetting");
    if (paramString == null)
    {
      AppMethodBeat.o(30992);
      return null;
    }
    paramString = (String)paramString.get(".PersonalAppSetting.OpenID");
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30992);
      return null;
    }
    b localb = new b();
    localb.Fel = paramString;
    AppMethodBeat.o(30992);
    return localb;
  }
  
  public static k fdi()
  {
    AppMethodBeat.i(30989);
    if (Fej == null) {
      Fej = new k();
    }
    k localk = Fej;
    AppMethodBeat.o(30989);
    return localk;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(30991);
    if (!bc.ajM())
    {
      AppMethodBeat.o(30991);
      return;
    }
    ae.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramaa == null)
    {
      ae.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
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
      if ((ak.getContext() == null) || (a.a.dBn() == null))
      {
        ae.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
        AppMethodBeat.o(30991);
        return;
      }
      ae.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (n)paramaa;
      if (this.Fek != null) {
        this.Fek.a(paramString);
      }
    }
  }
  
  public final void fdj()
  {
    AppMethodBeat.i(30990);
    if (!bc.ajM())
    {
      AppMethodBeat.o(30990);
      return;
    }
    ao.dBj().a(14, this);
    Fei = true;
    AppMethodBeat.o(30990);
  }
  
  public static abstract interface a
  {
    public abstract void a(n paramn);
  }
  
  public static final class b
  {
    public String Fel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.k
 * JD-Core Version:    0.7.0.1
 */