package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h$a
{
  public i QOh;
  i QUJ;
  
  public h$a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(179131);
    this.QOh = new i();
    this.QUJ = new i();
    try
    {
      this.QOh.m("uxinfo", paramString1);
      this.QOh.au("scene", paramInt1);
      this.QOh.au("originScene", paramInt2);
      this.QOh.t("canvasId", paramLong);
      this.QOh.au("type", 21);
      this.QOh.au("subType", paramInt3);
      this.QOh.au("action", 1);
      if (!Util.isNullOrNil(new String[] { paramString2, paramString3 }))
      {
        this.QOh.m("viewid", paramString2);
        this.QOh.m("commInfo", paramString3);
      }
      AppMethodBeat.o(179131);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("NetSceneAdLadingPageClick", "ContentBuilder exp=" + paramString1.toString());
      AppMethodBeat.o(179131);
    }
  }
  
  private String build()
  {
    AppMethodBeat.i(97144);
    try
    {
      this.QOh.m("extInfo", this.QUJ);
      String str = this.QOh.toString();
      AppMethodBeat.o(97144);
      return str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("NetSceneAdLadingPageClick", "build exp=" + localException.toString());
      }
    }
  }
  
  public final i bD(String paramString, long paramLong)
  {
    AppMethodBeat.i(97143);
    try
    {
      this.QUJ.t(paramString, paramLong);
      paramString = this.QUJ;
      AppMethodBeat.o(97143);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString.toString());
      }
    }
  }
  
  public final i mx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97142);
    try
    {
      this.QUJ.m(paramString1, Util.nullAsNil(paramString2));
      paramString1 = this.QUJ;
      AppMethodBeat.o(97142);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString1.toString());
      }
    }
  }
  
  public final void report(String paramString)
  {
    AppMethodBeat.i(306836);
    try
    {
      String str = build();
      AdLandingPagesProxy.getInstance().onAdLandingPageClick(paramString, str);
      Log.i("NetSceneAdLadingPageClick", "report, channel=" + paramString + ", content=" + str);
      AppMethodBeat.o(306836);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("NetSceneAdLadingPageClick", "report exp=" + paramString.toString());
      AppMethodBeat.o(306836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a
 * JD-Core Version:    0.7.0.1
 */