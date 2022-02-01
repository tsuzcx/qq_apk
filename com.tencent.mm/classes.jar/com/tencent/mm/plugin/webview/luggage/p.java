package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

public final class p
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> AUq;
  private f ASM;
  public String AUn;
  private boolean AUo;
  private String AUp;
  
  static
  {
    AppMethodBeat.i(78425);
    HashSet localHashSet = new HashSet();
    AUq = localHashSet;
    localHashSet.add("title");
    AUq.add("webpageTitle");
    AUq.add("srcUsername");
    AUq.add("srcDisplayname");
    AUq.add("mode");
    AUq.add("KTemplateId");
    AUq.add("KPublisherId");
    AppMethodBeat.o(78425);
  }
  
  public p(com.tencent.mm.plugin.ball.a.f paramf, f paramf1)
  {
    super(paramf);
    this.ASM = paramf1;
  }
  
  public final void OE(String paramString)
  {
    AppMethodBeat.i(78423);
    if ((this.mDH != null) && (!bt.isNullOrNil(this.mDH.name)) && (!this.mDH.name.startsWith("http://")) && (!this.mDH.name.startsWith("https://")) && (!bt.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(78423);
      return;
    }
    super.OE(paramString);
    AppMethodBeat.o(78423);
  }
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(78417);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.Z(paramInt, paramString);
    bzz().mDz = 8;
    bzz().mDy = 32;
    bzv();
    if ((this.mEA.getIntent() != null) && (this.mDH.hsl != null))
    {
      com.tencent.mm.plugin.ball.f.a.b(this.mEA.getIntent(), this.mDH.hsl, AUq);
      bzv();
    }
    this.AUn = paramString;
    this.AUo = true;
    if (!bt.isNullOrNil(this.AUp)) {
      awh(this.AUp);
    }
    AppMethodBeat.o(78417);
  }
  
  public final boolean aVX()
  {
    AppMethodBeat.i(78416);
    if ((this.ASM.ekY()) && (this.mEA.aVX()))
    {
      AppMethodBeat.o(78416);
      return true;
    }
    AppMethodBeat.o(78416);
    return false;
  }
  
  public final boolean aVY()
  {
    AppMethodBeat.i(78415);
    boolean bool = this.ASM.ekY();
    AppMethodBeat.o(78415);
    return bool;
  }
  
  public final void aVZ()
  {
    AppMethodBeat.i(78420);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onEnterPage :%s", new Object[] { Integer.valueOf(this.ASM.hashCode()) });
    super.aVZ();
    AppMethodBeat.o(78420);
  }
  
  public final void aWa()
  {
    AppMethodBeat.i(78421);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onExitPage :%s", new Object[] { Integer.valueOf(this.ASM.hashCode()) });
    super.aWa();
    AppMethodBeat.o(78421);
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(78422);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent:%s", new Object[] { Integer.valueOf(this.ASM.hashCode()) });
    super.aWb();
    this.mEA.fF(false);
    AppMethodBeat.o(78422);
  }
  
  public final boolean aWg()
  {
    AppMethodBeat.i(187871);
    boolean bool = this.ASM.ekY();
    AppMethodBeat.o(187871);
    return bool;
  }
  
  public final void awh(String paramString)
  {
    AppMethodBeat.i(78424);
    this.AUp = paramString;
    if (!this.AUo)
    {
      AppMethodBeat.o(78424);
      return;
    }
    bzz().dnC = paramString;
    bzv();
    AppMethodBeat.o(78424);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(78419);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onDestroy :%s", new Object[] { Integer.valueOf(this.ASM.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(78419);
  }
  
  public final boolean rg(int paramInt)
  {
    AppMethodBeat.i(78418);
    ad.i("MicroMsg.LuggageWebViewFloatBallHelper", "onClose :%s", new Object[] { Integer.valueOf(this.ASM.hashCode()) });
    boolean bool = super.rg(paramInt);
    AppMethodBeat.o(78418);
    return bool;
  }
  
  public static final class a
    implements com.tencent.luggage.d.a.a
  {
    private f ASM;
    private com.tencent.mm.plugin.webview.e.c ATm;
    private Set<String> AUr;
    
    public a(f paramf, com.tencent.mm.plugin.webview.e.c paramc)
    {
      AppMethodBeat.i(187867);
      this.AUr = new HashSet();
      this.ASM = paramf;
      this.ATm = paramc;
      AppMethodBeat.o(187867);
    }
    
    public final void a(com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(187869);
      paramc.a(b.caQ);
      AppMethodBeat.o(187869);
    }
    
    public final void a(String paramString, com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(187870);
      if (this.AUr.contains(paramString))
      {
        this.AUr.remove(paramString);
        paramc.a(b.caQ);
        AppMethodBeat.o(187870);
        return;
      }
      if (this.ATm.ff(this.ASM.getUrl(), com.tencent.mm.plugin.webview.e.c.axm(paramString))) {}
      for (paramString = b.caQ;; paramString = b.caR)
      {
        paramc.a(paramString);
        AppMethodBeat.o(187870);
        return;
      }
    }
    
    public final void awi(String paramString)
    {
      AppMethodBeat.i(187868);
      this.AUr.add(paramString);
      AppMethodBeat.o(187868);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.p
 * JD-Core Version:    0.7.0.1
 */