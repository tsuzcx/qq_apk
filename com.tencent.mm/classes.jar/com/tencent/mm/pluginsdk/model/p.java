package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.openapi.a.a.a;
import com.tencent.mm.pluginsdk.model.app.ae;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class p
  implements y
{
  public static boolean XRc = false;
  private static p XRd;
  public a XRe;
  
  public static b bpw(String paramString)
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
    localb.XRf = paramString;
    AppMethodBeat.o(30992);
    return localb;
  }
  
  public static p iHP()
  {
    AppMethodBeat.i(30989);
    if (XRd == null) {
      XRd = new p();
    }
    p localp = XRd;
    AppMethodBeat.o(30989);
    return localp;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, ae paramae)
  {
    AppMethodBeat.i(30991);
    if (!bh.baz())
    {
      AppMethodBeat.o(30991);
      return;
    }
    Log.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramae == null)
    {
      Log.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
      AppMethodBeat.o(30991);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramae.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30991);
      return;
      if ((MMApplicationContext.getContext() == null) || (a.a.gxu() == null))
      {
        Log.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
        AppMethodBeat.o(30991);
        return;
      }
      Log.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (u)paramae;
      if (this.XRe != null) {
        this.XRe.a(paramString);
      }
    }
  }
  
  public final void iHQ()
  {
    AppMethodBeat.i(30990);
    if (!bh.baz())
    {
      AppMethodBeat.o(30990);
      return;
    }
    as.gxq().a(14, this);
    XRc = true;
    AppMethodBeat.o(30990);
  }
  
  public static abstract interface a
  {
    public abstract void a(u paramu);
  }
  
  public static final class b
  {
    public String XRf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.p
 * JD-Core Version:    0.7.0.1
 */