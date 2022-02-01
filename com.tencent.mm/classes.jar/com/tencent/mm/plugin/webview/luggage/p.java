package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.Set;

public final class p
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> CmD;
  private f CkZ;
  public String CmA;
  private boolean CmB;
  private String CmC;
  
  static
  {
    AppMethodBeat.i(78425);
    HashSet localHashSet = new HashSet();
    CmD = localHashSet;
    localHashSet.add("title");
    CmD.add("webpageTitle");
    CmD.add("srcUsername");
    CmD.add("srcDisplayname");
    CmD.add("mode");
    CmD.add("KTemplateId");
    CmD.add("KPublisherId");
    AppMethodBeat.o(78425);
  }
  
  public p(com.tencent.mm.plugin.ball.a.f paramf, f paramf1)
  {
    super(paramf);
    this.CkZ = paramf1;
  }
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(78423);
    if ((this.nfN != null) && (!bs.isNullOrNil(this.nfN.name)) && (!this.nfN.name.startsWith("http://")) && (!this.nfN.name.startsWith("https://")) && (!bs.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(78423);
      return;
    }
    super.SO(paramString);
    AppMethodBeat.o(78423);
  }
  
  public final void aBz(String paramString)
  {
    AppMethodBeat.i(78424);
    this.CmC = paramString;
    if (!this.CmB)
    {
      AppMethodBeat.o(78424);
      return;
    }
    bGv().dlk = paramString;
    bGr();
    AppMethodBeat.o(78424);
  }
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(78417);
    ac.i("MicroMsg.LuggageWebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.aa(paramInt, paramString);
    bGv().nfG = 8;
    bGv().nfF = 32;
    bGr();
    if ((this.ngF.getIntent() != null) && (this.nfN.hSN != null))
    {
      com.tencent.mm.plugin.ball.f.a.b(this.ngF.getIntent(), this.nfN.hSN, CmD);
      bGr();
    }
    this.CmA = paramString;
    this.CmB = true;
    if (!bs.isNullOrNil(this.CmC)) {
      aBz(this.CmC);
    }
    AppMethodBeat.o(78417);
  }
  
  public final boolean bcV()
  {
    AppMethodBeat.i(78416);
    if ((this.CkZ.eAu()) && (this.ngF.bcV()))
    {
      AppMethodBeat.o(78416);
      return true;
    }
    AppMethodBeat.o(78416);
    return false;
  }
  
  public final boolean bcW()
  {
    AppMethodBeat.i(78415);
    boolean bool = this.CkZ.eAu();
    AppMethodBeat.o(78415);
    return bool;
  }
  
  public final void bcX()
  {
    AppMethodBeat.i(78420);
    ac.i("MicroMsg.LuggageWebViewFloatBallHelper", "onEnterPage :%s", new Object[] { Integer.valueOf(this.CkZ.hashCode()) });
    super.bcX();
    AppMethodBeat.o(78420);
  }
  
  public final void bcY()
  {
    AppMethodBeat.i(78421);
    ac.i("MicroMsg.LuggageWebViewFloatBallHelper", "onExitPage :%s", new Object[] { Integer.valueOf(this.CkZ.hashCode()) });
    super.bcY();
    AppMethodBeat.o(78421);
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(78422);
    ac.i("MicroMsg.LuggageWebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent:%s", new Object[] { Integer.valueOf(this.CkZ.hashCode()) });
    super.bcZ();
    this.ngF.gb(false);
    AppMethodBeat.o(78422);
  }
  
  public final boolean bde()
  {
    AppMethodBeat.i(188297);
    boolean bool = this.CkZ.eAu();
    AppMethodBeat.o(188297);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(78419);
    ac.i("MicroMsg.LuggageWebViewFloatBallHelper", "onDestroy :%s", new Object[] { Integer.valueOf(this.CkZ.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(78419);
  }
  
  public final boolean rT(int paramInt)
  {
    AppMethodBeat.i(78418);
    ac.i("MicroMsg.LuggageWebViewFloatBallHelper", "onClose :%s", new Object[] { Integer.valueOf(this.CkZ.hashCode()) });
    boolean bool = super.rT(paramInt);
    AppMethodBeat.o(78418);
    return bool;
  }
  
  public static final class a
    implements com.tencent.luggage.d.a.a
  {
    private f CkZ;
    private com.tencent.mm.plugin.webview.e.c Clz;
    private Set<String> CmE;
    
    public a(f paramf, com.tencent.mm.plugin.webview.e.c paramc)
    {
      AppMethodBeat.i(188293);
      this.CmE = new HashSet();
      this.CkZ = paramf;
      this.Clz = paramc;
      AppMethodBeat.o(188293);
    }
    
    public final void a(com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(188295);
      paramc.a(b.bXN);
      AppMethodBeat.o(188295);
    }
    
    public final void a(String paramString, com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(188296);
      if (this.CmE.contains(paramString))
      {
        this.CmE.remove(paramString);
        paramc.a(b.bXN);
        AppMethodBeat.o(188296);
        return;
      }
      if (this.Clz.fn(this.CkZ.getUrl(), com.tencent.mm.plugin.webview.e.c.aCE(paramString))) {}
      for (paramString = b.bXN;; paramString = b.bXO)
      {
        paramc.a(paramString);
        AppMethodBeat.o(188296);
        return;
      }
    }
    
    public final void aBA(String paramString)
    {
      AppMethodBeat.i(188294);
      this.CmE.add(paramString);
      AppMethodBeat.o(188294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.p
 * JD-Core Version:    0.7.0.1
 */