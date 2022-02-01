package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

public final class q
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> IUM;
  private g ISU;
  private String IUJ;
  private boolean IUK;
  private String IUL;
  
  static
  {
    AppMethodBeat.i(78425);
    HashSet localHashSet = new HashSet();
    IUM = localHashSet;
    localHashSet.add("title");
    IUM.add("webpageTitle");
    IUM.add("srcUsername");
    IUM.add("srcDisplayname");
    IUM.add("mode");
    IUM.add("KTemplateId");
    IUM.add("KPublisherId");
    AppMethodBeat.o(78425);
  }
  
  public q(com.tencent.mm.plugin.ball.a.f paramf, g paramg)
  {
    super(paramf);
    this.ISU = paramg;
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(78417);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onCreate, type:%s, key:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.G(paramInt, paramString);
    ciw().hDa = 8;
    ciw().oWx = 32;
    cit();
    if ((this.oXA.getIntent() != null) && (this.oWE.jkf != null))
    {
      com.tencent.mm.plugin.ball.f.a.b(this.oXA.getIntent(), this.oWE.jkf, IUM);
      cit();
    }
    this.IUJ = paramString;
    this.IUK = true;
    if (!Util.isNullOrNil(this.IUL)) {
      aYt(this.IUL);
    }
    AppMethodBeat.o(78417);
  }
  
  public final boolean aGg()
  {
    AppMethodBeat.i(78416);
    if ((this.ISU.gbH()) && (this.oXA.aGg()))
    {
      AppMethodBeat.o(78416);
      return true;
    }
    AppMethodBeat.o(78416);
    return false;
  }
  
  public final boolean aGh()
  {
    AppMethodBeat.i(78415);
    boolean bool = this.ISU.gbH();
    AppMethodBeat.o(78415);
    return bool;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(78422);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent:%s", new Object[] { Integer.valueOf(this.ISU.hashCode()) });
    super.aGi();
    this.oXA.hb(false);
    AppMethodBeat.o(78422);
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(78421);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onExitPage :%s", new Object[] { Integer.valueOf(this.ISU.hashCode()) });
    super.aGj();
    AppMethodBeat.o(78421);
  }
  
  public final void aYt(String paramString)
  {
    AppMethodBeat.i(78424);
    this.IUL = paramString;
    if (!this.IUK)
    {
      AppMethodBeat.o(78424);
      return;
    }
    ciw().dPJ = paramString;
    cit();
    AppMethodBeat.o(78424);
  }
  
  public final void agT(String paramString)
  {
    AppMethodBeat.i(78423);
    if ((this.oWE != null) && (!Util.isNullOrNil(this.oWE.name)) && (!this.oWE.name.startsWith("http://")) && (!this.oWE.name.startsWith("https://")) && (!Util.isNullOrNil(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      AppMethodBeat.o(78423);
      return;
    }
    super.agT(paramString);
    AppMethodBeat.o(78423);
  }
  
  public final void bCA()
  {
    AppMethodBeat.i(78420);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onEnterPage :%s", new Object[] { Integer.valueOf(this.ISU.hashCode()) });
    super.bCA();
    AppMethodBeat.o(78420);
  }
  
  public final boolean bCG()
  {
    AppMethodBeat.i(210939);
    boolean bool = this.ISU.gbH();
    AppMethodBeat.o(210939);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(78419);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onDestroy :%s", new Object[] { Integer.valueOf(this.ISU.hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(78419);
  }
  
  public final boolean wu(int paramInt)
  {
    AppMethodBeat.i(78418);
    Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onClose :%s", new Object[] { Integer.valueOf(this.ISU.hashCode()) });
    boolean bool = super.wu(paramInt);
    AppMethodBeat.o(78418);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.q
 * JD-Core Version:    0.7.0.1
 */