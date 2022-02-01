package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class d$a
{
  i xfv;
  i xfw;
  
  public d$a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(179131);
    this.xfv = new i();
    this.xfw = new i();
    try
    {
      this.xfv.j("uxinfo", paramString1);
      this.xfv.O("scene", paramInt1);
      this.xfv.O("originScene", paramInt2);
      this.xfv.s("canvasId", paramLong);
      this.xfv.O("type", 21);
      this.xfv.O("subType", paramInt3);
      this.xfv.O("action", 1);
      if (!bt.T(new String[] { paramString2, paramString3 }))
      {
        this.xfv.j("viewid", paramString2);
        this.xfv.j("commInfo", paramString3);
      }
      AppMethodBeat.o(179131);
      return;
    }
    catch (Exception paramString1)
    {
      ad.e("NetSceneAdLadingPageClick", "ContentBuilder exp=" + paramString1.toString());
      AppMethodBeat.o(179131);
    }
  }
  
  public final i bg(String paramString, long paramLong)
  {
    AppMethodBeat.i(97143);
    try
    {
      this.xfw.s(paramString, paramLong);
      paramString = this.xfw;
      AppMethodBeat.o(97143);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString.toString());
      }
    }
  }
  
  public final String cFx()
  {
    AppMethodBeat.i(97144);
    try
    {
      this.xfv.j("extInfo", this.xfw);
      String str = this.xfv.toString();
      AppMethodBeat.o(97144);
      return str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("NetSceneAdLadingPageClick", "build exp=" + localException.toString());
      }
    }
  }
  
  public final i iQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97142);
    try
    {
      this.xfw.j(paramString1, bt.nullAsNil(paramString2));
      paramString1 = this.xfw;
      AppMethodBeat.o(97142);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ad.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString1.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a
 * JD-Core Version:    0.7.0.1
 */