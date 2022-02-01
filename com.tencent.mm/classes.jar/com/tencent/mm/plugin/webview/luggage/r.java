package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

public final class r
  extends e
{
  private static final Set<String> WHA;
  private g WFG;
  private String WHx;
  private boolean WHy;
  private String WHz;
  
  static
  {
    AppMethodBeat.i(78425);
    HashSet localHashSet = new HashSet();
    WHA = localHashSet;
    localHashSet.add("title");
    WHA.add("webpageTitle");
    WHA.add("srcUsername");
    WHA.add("srcDisplayname");
    WHA.add("mode");
    WHA.add("KTemplateId");
    WHA.add("KPublisherId");
    AppMethodBeat.o(78425);
  }
  
  public r(f paramf, g paramg)
  {
    super(paramf);
    this.WFG = paramg;
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(78417);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.J(paramInt, paramString);
    cYv().mUU = 8;
    cYv().vjN = 32;
    cYr();
    if ((this.vkT.getIntent() != null) && (this.vjV.oSS != null))
    {
      com.tencent.mm.plugin.ball.f.a.b(this.vkT.getIntent(), this.vjV.oSS, WHA);
      cYr();
    }
    this.WHx = paramString;
    this.WHy = true;
    if (!Util.isNullOrNil(this.WHz)) {
      bjY(this.WHz);
    }
    AppMethodBeat.o(78417);
  }
  
  public final void ahU(String paramString)
  {
    AppMethodBeat.i(78423);
    if ((this.vjV != null) && (!Util.isNullOrNil(this.vjV.name)) && (!this.vjV.name.startsWith("http://")) && (!this.vjV.name.startsWith("https://")) && (!Util.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(78423);
      return;
    }
    super.ahU(paramString);
    AppMethodBeat.o(78423);
  }
  
  public final boolean bhU()
  {
    AppMethodBeat.i(78416);
    if ((this.WFG.iul()) && (this.vkT.bhU()))
    {
      AppMethodBeat.o(78416);
      return true;
    }
    AppMethodBeat.o(78416);
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(78422);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent:%s", new Object[] { Integer.valueOf(this.WFG.hashCode()) });
    super.bhV();
    this.vkT.iR(false);
    AppMethodBeat.o(78422);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(78421);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onExitPage :%s", new Object[] { Integer.valueOf(this.WFG.hashCode()) });
    super.bhW();
    AppMethodBeat.o(78421);
  }
  
  public final void bjY(String paramString)
  {
    AppMethodBeat.i(78424);
    this.WHz = paramString;
    if (!this.WHy)
    {
      AppMethodBeat.o(78424);
      return;
    }
    cYv().hOH = paramString;
    cYr();
    AppMethodBeat.o(78424);
  }
  
  public final void coi()
  {
    AppMethodBeat.i(78420);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onEnterPage :%s", new Object[] { Integer.valueOf(this.WFG.hashCode()) });
    super.coi();
    AppMethodBeat.o(78420);
  }
  
  public final boolean cop()
  {
    AppMethodBeat.i(78415);
    boolean bool = this.WFG.iul();
    AppMethodBeat.o(78415);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(78419);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onDestroy :%s", new Object[] { Integer.valueOf(this.WFG.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(78419);
  }
  
  public final boolean zX(int paramInt)
  {
    AppMethodBeat.i(78418);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onClose :%s", new Object[] { Integer.valueOf(this.WFG.hashCode()) });
    boolean bool = super.zX(paramInt);
    AppMethodBeat.o(78418);
    return bool;
  }
  
  public static final class a
    implements com.tencent.luggage.d.a.a
  {
    private g WFG;
    private com.tencent.mm.plugin.webview.e.c WGg;
    private Set<String> WHB;
    
    public a(g paramg, com.tencent.mm.plugin.webview.e.c paramc)
    {
      AppMethodBeat.i(295992);
      this.WHB = new HashSet();
      this.WFG = paramg;
      this.WGg = paramc;
      AppMethodBeat.o(295992);
    }
    
    public final void a(com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(295997);
      paramc.a(b.eka);
      AppMethodBeat.o(295997);
    }
    
    public final void a(String paramString, com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(295998);
      if (this.WHB.contains(paramString))
      {
        this.WHB.remove(paramString);
        paramc.a(b.eka);
        AppMethodBeat.o(295998);
        return;
      }
      if (this.WGg.ia(this.WFG.getUrl(), com.tencent.mm.plugin.webview.e.c.bld(paramString))) {}
      for (paramString = b.eka;; paramString = b.ekb)
      {
        paramc.a(paramString);
        AppMethodBeat.o(295998);
        return;
      }
    }
    
    public final void bjZ(String paramString)
    {
      AppMethodBeat.i(295995);
      this.WHB.add(paramString);
      AppMethodBeat.o(295995);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.r
 * JD-Core Version:    0.7.0.1
 */