package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.r.a.a.a;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class l
  implements u
{
  public static boolean JUZ = false;
  private static l JVa;
  public a JVb;
  
  public static b bdq(String paramString)
  {
    AppMethodBeat.i(30992);
    if (paramString == null)
    {
      AppMethodBeat.o(30992);
      return null;
    }
    paramString = XmlParser.parseXml(paramString, "PersonalAppSetting", null);
    if (paramString == null)
    {
      AppMethodBeat.o(30992);
      return null;
    }
    paramString = (String)paramString.get(".PersonalAppSetting.OpenID");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30992);
      return null;
    }
    b localb = new b();
    localb.JVc = paramString;
    AppMethodBeat.o(30992);
    return localb;
  }
  
  public static l gms()
  {
    AppMethodBeat.i(30989);
    if (JVa == null) {
      JVa = new l();
    }
    l locall = JVa;
    AppMethodBeat.o(30989);
    return locall;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(30991);
    if (!bg.aAc())
    {
      AppMethodBeat.o(30991);
      return;
    }
    Log.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramaa == null)
    {
      Log.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
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
      if ((MMApplicationContext.getContext() == null) || (a.a.eAZ() == null))
      {
        Log.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
        AppMethodBeat.o(30991);
        return;
      }
      Log.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (o)paramaa;
      if (this.JVb != null) {
        this.JVb.a(paramString);
      }
    }
  }
  
  public final void gmt()
  {
    AppMethodBeat.i(30990);
    if (!bg.aAc())
    {
      AppMethodBeat.o(30990);
      return;
    }
    ao.eAV().a(14, this);
    JUZ = true;
    AppMethodBeat.o(30990);
  }
  
  public static abstract interface a
  {
    public abstract void a(o paramo);
  }
  
  public static final class b
  {
    public String JVc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.l
 * JD-Core Version:    0.7.0.1
 */