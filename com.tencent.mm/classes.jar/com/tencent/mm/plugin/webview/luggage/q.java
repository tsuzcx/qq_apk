package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

public final class q
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> DPY;
  private g DOl;
  public String DPV;
  private boolean DPW;
  private String DPX;
  
  static
  {
    AppMethodBeat.i(78425);
    HashSet localHashSet = new HashSet();
    DPY = localHashSet;
    localHashSet.add("title");
    DPY.add("webpageTitle");
    DPY.add("srcUsername");
    DPY.add("srcDisplayname");
    DPY.add("mode");
    DPY.add("KTemplateId");
    DPY.add("KPublisherId");
    AppMethodBeat.o(78425);
  }
  
  public q(com.tencent.mm.plugin.ball.a.f paramf, g paramg)
  {
    super(paramf);
    this.DOl = paramg;
  }
  
  public final void Wm(String paramString)
  {
    AppMethodBeat.i(78423);
    if ((this.nGj != null) && (!bt.isNullOrNil(this.nGj.name)) && (!this.nGj.name.startsWith("http://")) && (!this.nGj.name.startsWith("https://")) && (!bt.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(78423);
      return;
    }
    super.Wm(paramString);
    AppMethodBeat.o(78423);
  }
  
  public final void aGX(String paramString)
  {
    AppMethodBeat.i(78424);
    this.DPX = paramString;
    if (!this.DPW)
    {
      AppMethodBeat.o(78424);
      return;
    }
    bKG().dwX = paramString;
    bKC();
    AppMethodBeat.o(78424);
  }
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(78417);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.ac(paramInt, paramString);
    bKG().nGc = 8;
    bKG().nGb = 32;
    bKC();
    if ((this.nHb.getIntent() != null) && (this.nGj.ime != null))
    {
      com.tencent.mm.plugin.ball.f.a.b(this.nHb.getIntent(), this.nGj.ime, DPY);
      bKC();
    }
    this.DPV = paramString;
    this.DPW = true;
    if (!bt.isNullOrNil(this.DPX)) {
      aGX(this.DPX);
    }
    AppMethodBeat.o(78417);
  }
  
  public final boolean bgA()
  {
    AppMethodBeat.i(78415);
    boolean bool = this.DOl.ePk();
    AppMethodBeat.o(78415);
    return bool;
  }
  
  public final void bgB()
  {
    AppMethodBeat.i(78420);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onEnterPage :%s", new Object[] { Integer.valueOf(this.DOl.hashCode()) });
    super.bgB();
    AppMethodBeat.o(78420);
  }
  
  public final void bgC()
  {
    AppMethodBeat.i(78421);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onExitPage :%s", new Object[] { Integer.valueOf(this.DOl.hashCode()) });
    super.bgC();
    AppMethodBeat.o(78421);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(78422);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent:%s", new Object[] { Integer.valueOf(this.DOl.hashCode()) });
    super.bgD();
    this.nHb.gg(false);
    AppMethodBeat.o(78422);
  }
  
  public final boolean bgI()
  {
    AppMethodBeat.i(207902);
    boolean bool = this.DOl.ePk();
    AppMethodBeat.o(207902);
    return bool;
  }
  
  public final boolean bgz()
  {
    AppMethodBeat.i(78416);
    if ((this.DOl.ePk()) && (this.nHb.bgz()))
    {
      AppMethodBeat.o(78416);
      return true;
    }
    AppMethodBeat.o(78416);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(78419);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onDestroy :%s", new Object[] { Integer.valueOf(this.DOl.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(78419);
  }
  
  public final boolean sv(int paramInt)
  {
    AppMethodBeat.i(78418);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onClose :%s", new Object[] { Integer.valueOf(this.DOl.hashCode()) });
    boolean bool = super.sv(paramInt);
    AppMethodBeat.o(78418);
    return bool;
  }
  
  public static final class a
    implements com.tencent.luggage.d.a.a
  {
    private com.tencent.mm.plugin.webview.e.c DOK;
    private g DOl;
    private Set<String> DPZ;
    
    public a(g paramg, com.tencent.mm.plugin.webview.e.c paramc)
    {
      AppMethodBeat.i(207898);
      this.DPZ = new HashSet();
      this.DOl = paramg;
      this.DOK = paramc;
      AppMethodBeat.o(207898);
    }
    
    public final void a(com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(207900);
      paramc.a(b.cif);
      AppMethodBeat.o(207900);
    }
    
    public final void a(String paramString, com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(207901);
      if (this.DPZ.contains(paramString))
      {
        this.DPZ.remove(paramString);
        paramc.a(b.cif);
        AppMethodBeat.o(207901);
        return;
      }
      if (this.DOK.fK(this.DOl.getUrl(), com.tencent.mm.plugin.webview.e.c.aIg(paramString))) {}
      for (paramString = b.cif;; paramString = b.cig)
      {
        paramc.a(paramString);
        AppMethodBeat.o(207901);
        return;
      }
    }
    
    public final void aGY(String paramString)
    {
      AppMethodBeat.i(207899);
      this.DPZ.add(paramString);
      AppMethodBeat.o(207899);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.q
 * JD-Core Version:    0.7.0.1
 */