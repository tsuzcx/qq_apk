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

public final class q
  extends e
{
  private static final Set<String> PRd;
  private g PPn;
  private String PRa;
  private boolean PRb;
  private String PRc;
  
  static
  {
    AppMethodBeat.i(78425);
    HashSet localHashSet = new HashSet();
    PRd = localHashSet;
    localHashSet.add("title");
    PRd.add("webpageTitle");
    PRd.add("srcUsername");
    PRd.add("srcDisplayname");
    PRd.add("mode");
    PRd.add("KTemplateId");
    PRd.add("KPublisherId");
    AppMethodBeat.o(78425);
  }
  
  public q(f paramf, g paramg)
  {
    super(paramf);
    this.PPn = paramg;
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(78417);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.I(paramInt, paramString);
    cvL().kqZ = 8;
    cvL().rYx = 32;
    cvG();
    if ((this.rZC.getIntent() != null) && (this.rYE.mab != null))
    {
      com.tencent.mm.plugin.ball.f.a.b(this.rZC.getIntent(), this.rYE.mab, PRd);
      cvG();
    }
    this.PRa = paramString;
    this.PRb = true;
    if (!Util.isNullOrNil(this.PRc)) {
      bko(this.PRc);
    }
    AppMethodBeat.o(78417);
  }
  
  public final boolean aOg()
  {
    AppMethodBeat.i(78416);
    if ((this.PPn.gUC()) && (this.rZC.aOg()))
    {
      AppMethodBeat.o(78416);
      return true;
    }
    AppMethodBeat.o(78416);
    return false;
  }
  
  public final boolean aOh()
  {
    AppMethodBeat.i(78415);
    boolean bool = this.PPn.gUC();
    AppMethodBeat.o(78415);
    return bool;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(78422);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent:%s", new Object[] { Integer.valueOf(this.PPn.hashCode()) });
    super.aOi();
    this.rZC.hS(false);
    AppMethodBeat.o(78422);
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(78421);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onExitPage :%s", new Object[] { Integer.valueOf(this.PPn.hashCode()) });
    super.aOj();
    AppMethodBeat.o(78421);
  }
  
  public final void aoy(String paramString)
  {
    AppMethodBeat.i(78423);
    if ((this.rYE != null) && (!Util.isNullOrNil(this.rYE.name)) && (!this.rYE.name.startsWith("http://")) && (!this.rYE.name.startsWith("https://")) && (!Util.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(78423);
      return;
    }
    super.aoy(paramString);
    AppMethodBeat.o(78423);
  }
  
  public final void bNV()
  {
    AppMethodBeat.i(78420);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onEnterPage :%s", new Object[] { Integer.valueOf(this.PPn.hashCode()) });
    super.bNV();
    AppMethodBeat.o(78420);
  }
  
  public final boolean bOb()
  {
    AppMethodBeat.i(214392);
    boolean bool = this.PPn.gUC();
    AppMethodBeat.o(214392);
    return bool;
  }
  
  public final void bko(String paramString)
  {
    AppMethodBeat.i(78424);
    this.PRc = paramString;
    if (!this.PRb)
    {
      AppMethodBeat.o(78424);
      return;
    }
    cvL().fIZ = paramString;
    cvG();
    AppMethodBeat.o(78424);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(78419);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onDestroy :%s", new Object[] { Integer.valueOf(this.PPn.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(78419);
  }
  
  public final boolean zH(int paramInt)
  {
    AppMethodBeat.i(78418);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onClose :%s", new Object[] { Integer.valueOf(this.PPn.hashCode()) });
    boolean bool = super.zH(paramInt);
    AppMethodBeat.o(78418);
    return bool;
  }
  
  public static final class a
    implements com.tencent.luggage.d.a.a
  {
    private com.tencent.mm.plugin.webview.f.c PPN;
    private g PPn;
    private Set<String> PRe;
    
    public a(g paramg, com.tencent.mm.plugin.webview.f.c paramc)
    {
      AppMethodBeat.i(216993);
      this.PRe = new HashSet();
      this.PPn = paramg;
      this.PPN = paramc;
      AppMethodBeat.o(216993);
    }
    
    public final void a(com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(216995);
      paramc.a(b.csf);
      AppMethodBeat.o(216995);
    }
    
    public final void a(String paramString, com.tencent.luggage.d.a.c paramc)
    {
      AppMethodBeat.i(216998);
      if (this.PRe.contains(paramString))
      {
        this.PRe.remove(paramString);
        paramc.a(b.csf);
        AppMethodBeat.o(216998);
        return;
      }
      if (this.PPN.ha(this.PPn.getUrl(), com.tencent.mm.plugin.webview.f.c.blB(paramString))) {}
      for (paramString = b.csf;; paramString = b.csg)
      {
        paramc.a(paramString);
        AppMethodBeat.o(216998);
        return;
      }
    }
    
    public final void bkp(String paramString)
    {
      AppMethodBeat.i(216994);
      this.PRe.add(paramString);
      AppMethodBeat.o(216994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.q
 * JD-Core Version:    0.7.0.1
 */