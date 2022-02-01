package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class d$a
{
  i AaA;
  public i zUr;
  
  public d$a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(179131);
    this.zUr = new i();
    this.AaA = new i();
    try
    {
      this.zUr.h("uxinfo", paramString1);
      this.zUr.S("scene", paramInt1);
      this.zUr.S("originScene", paramInt2);
      this.zUr.u("canvasId", paramLong);
      this.zUr.S("type", 21);
      this.zUr.S("subType", paramInt3);
      this.zUr.S("action", 1);
      if (!bu.V(new String[] { paramString2, paramString3 }))
      {
        this.zUr.h("viewid", paramString2);
        this.zUr.h("commInfo", paramString3);
      }
      AppMethodBeat.o(179131);
      return;
    }
    catch (Exception paramString1)
    {
      ae.e("NetSceneAdLadingPageClick", "ContentBuilder exp=" + paramString1.toString());
      AppMethodBeat.o(179131);
    }
  }
  
  private String deF()
  {
    AppMethodBeat.i(97144);
    try
    {
      this.zUr.h("extInfo", this.AaA);
      String str = this.zUr.toString();
      AppMethodBeat.o(97144);
      return str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("NetSceneAdLadingPageClick", "build exp=" + localException.toString());
      }
    }
  }
  
  public final i bm(String paramString, long paramLong)
  {
    AppMethodBeat.i(97143);
    try
    {
      this.AaA.u(paramString, paramLong);
      paramString = this.AaA;
      AppMethodBeat.o(97143);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString.toString());
      }
    }
  }
  
  public final i jH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97142);
    try
    {
      this.AaA.h(paramString1, bu.nullAsNil(paramString2));
      paramString1 = this.AaA;
      AppMethodBeat.o(97142);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ae.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString1.toString());
      }
    }
  }
  
  public final void report(String paramString)
  {
    AppMethodBeat.i(219610);
    try
    {
      String str = deF();
      AdLandingPagesProxy.getInstance().onAdLandingPageClick(paramString, str);
      ae.i("NetSceneAdLadingPageClick", "report, channel=" + paramString + ", content=" + str);
      AppMethodBeat.o(219610);
      return;
    }
    catch (Exception paramString)
    {
      ae.e("NetSceneAdLadingPageClick", "report exp=" + paramString.toString());
      AppMethodBeat.o(219610);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a
 * JD-Core Version:    0.7.0.1
 */