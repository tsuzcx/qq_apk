package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Set;

public final class q
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> EhY;
  private g Egl;
  public String EhV;
  private boolean EhW;
  private String EhX;
  
  static
  {
    AppMethodBeat.i(78425);
    HashSet localHashSet = new HashSet();
    EhY = localHashSet;
    localHashSet.add("title");
    EhY.add("webpageTitle");
    EhY.add("srcUsername");
    EhY.add("srcDisplayname");
    EhY.add("mode");
    EhY.add("KTemplateId");
    EhY.add("KPublisherId");
    AppMethodBeat.o(78425);
  }
  
  public q(com.tencent.mm.plugin.ball.a.f paramf, g paramg)
  {
    super(paramf);
    this.Egl = paramg;
  }
  
  public final void WY(String paramString)
  {
    AppMethodBeat.i(78423);
    if ((this.nLK != null) && (!bu.isNullOrNil(this.nLK.name)) && (!this.nLK.name.startsWith("http://")) && (!this.nLK.name.startsWith("https://")) && (!bu.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(78423);
      return;
    }
    super.WY(paramString);
    AppMethodBeat.o(78423);
  }
  
  public final void aIr(String paramString)
  {
    AppMethodBeat.i(78424);
    this.EhX = paramString;
    if (!this.EhW)
    {
      AppMethodBeat.o(78424);
      return;
    }
    bLD().dyc = paramString;
    bLz();
    AppMethodBeat.o(78424);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(78417);
    ae.i("MicroMsg.LuggageWebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    bLD().nLC = 8;
    bLD().nLB = 32;
    bLz();
    if ((this.nME.getIntent() != null) && (this.nLK.ioY != null))
    {
      com.tencent.mm.plugin.ball.f.a.b(this.nME.getIntent(), this.nLK.ioY, EhY);
      bLz();
    }
    this.EhV = paramString;
    this.EhW = true;
    if (!bu.isNullOrNil(this.EhX)) {
      aIr(this.EhX);
    }
    AppMethodBeat.o(78417);
  }
  
  public final boolean bhh()
  {
    AppMethodBeat.i(78416);
    if ((this.Egl.eSW()) && (this.nME.bhh()))
    {
      AppMethodBeat.o(78416);
      return true;
    }
    AppMethodBeat.o(78416);
    return false;
  }
  
  public final boolean bhi()
  {
    AppMethodBeat.i(78415);
    boolean bool = this.Egl.eSW();
    AppMethodBeat.o(78415);
    return bool;
  }
  
  public final void bhj()
  {
    AppMethodBeat.i(78420);
    ae.i("MicroMsg.LuggageWebViewFloatBallHelper", "onEnterPage :%s", new Object[] { Integer.valueOf(this.Egl.hashCode()) });
    super.bhj();
    AppMethodBeat.o(78420);
  }
  
  public final void bhk()
  {
    AppMethodBeat.i(78421);
    ae.i("MicroMsg.LuggageWebViewFloatBallHelper", "onExitPage :%s", new Object[] { Integer.valueOf(this.Egl.hashCode()) });
    super.bhk();
    AppMethodBeat.o(78421);
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(78422);
    ae.i("MicroMsg.LuggageWebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent:%s", new Object[] { Integer.valueOf(this.Egl.hashCode()) });
    super.bhl();
    this.nME.ge(false);
    AppMethodBeat.o(78422);
  }
  
  public final boolean bhq()
  {
    AppMethodBeat.i(198082);
    boolean bool = this.Egl.eSW();
    AppMethodBeat.o(198082);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(78419);
    ae.i("MicroMsg.LuggageWebViewFloatBallHelper", "onDestroy :%s", new Object[] { Integer.valueOf(this.Egl.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(78419);
  }
  
  public final boolean sy(int paramInt)
  {
    AppMethodBeat.i(78418);
    ae.i("MicroMsg.LuggageWebViewFloatBallHelper", "onClose :%s", new Object[] { Integer.valueOf(this.Egl.hashCode()) });
    boolean bool = super.sy(paramInt);
    AppMethodBeat.o(78418);
    return bool;
  }
  
  public static final class a
    implements com.tencent.luggage.d.a.a
  {
    private com.tencent.mm.plugin.webview.e.c EgK;
    private g Egl;
    private Set<String> EhZ;
    
    public a(g paramg, com.tencent.mm.plugin.webview.e.c paramc)
    {
      AppMethodBeat.i(198078);
      this.EhZ = new HashSet();
      this.Egl = paramg;
      this.EgK = paramc;
      AppMethodBeat.o(198078);
    }
    
    public final void a(com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(198080);
      paramc.a(b.cif);
      AppMethodBeat.o(198080);
    }
    
    public final void a(String paramString, com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(198081);
      if (this.EhZ.contains(paramString))
      {
        this.EhZ.remove(paramString);
        paramc.a(b.cif);
        AppMethodBeat.o(198081);
        return;
      }
      if (this.EgK.fV(this.Egl.getUrl(), com.tencent.mm.plugin.webview.e.c.aJz(paramString))) {}
      for (paramString = b.cif;; paramString = b.cig)
      {
        paramc.a(paramString);
        AppMethodBeat.o(198081);
        return;
      }
    }
    
    public final void aIs(String paramString)
    {
      AppMethodBeat.i(198079);
      this.EhZ.add(paramString);
      AppMethodBeat.o(198079);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.q
 * JD-Core Version:    0.7.0.1
 */