package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g$a
{
  public i Kqa;
  i Kwa;
  
  public g$a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(179131);
    this.Kqa = new i();
    this.Kwa = new i();
    try
    {
      this.Kqa.g("uxinfo", paramString1);
      this.Kqa.al("scene", paramInt1);
      this.Kqa.al("originScene", paramInt2);
      this.Kqa.s("canvasId", paramLong);
      this.Kqa.al("type", 21);
      this.Kqa.al("subType", paramInt3);
      this.Kqa.al("action", 1);
      if (!Util.isNullOrNil(new String[] { paramString2, paramString3 }))
      {
        this.Kqa.g("viewid", paramString2);
        this.Kqa.g("commInfo", paramString3);
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
      this.Kqa.g("extInfo", this.Kwa);
      String str = this.Kqa.toString();
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
  
  public final i br(String paramString, long paramLong)
  {
    AppMethodBeat.i(97143);
    try
    {
      this.Kwa.s(paramString, paramLong);
      paramString = this.Kwa;
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
  
  public final i kQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97142);
    try
    {
      this.Kwa.g(paramString1, Util.nullAsNil(paramString2));
      paramString1 = this.Kwa;
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
    AppMethodBeat.i(266234);
    try
    {
      String str = build();
      AdLandingPagesProxy.getInstance().onAdLandingPageClick(paramString, str);
      Log.i("NetSceneAdLadingPageClick", "report, channel=" + paramString + ", content=" + str);
      AppMethodBeat.o(266234);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("NetSceneAdLadingPageClick", "report exp=" + paramString.toString());
      AppMethodBeat.o(266234);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a
 * JD-Core Version:    0.7.0.1
 */