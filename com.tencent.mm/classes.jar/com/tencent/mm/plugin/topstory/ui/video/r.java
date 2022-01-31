package com.tencent.mm.plugin.topstory.ui.video;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class r
{
  private int smh;
  b thM;
  private d tjO;
  q tjP;
  public f tjQ;
  public ckx tjR;
  public boolean tjS;
  public boolean tjT;
  public boolean tjU;
  private d.a tjV;
  private boolean tjW;
  private boolean tjX;
  
  public r()
  {
    AppMethodBeat.i(1838);
    this.smh = 0;
    this.tjU = false;
    this.tjV = new r.1(this);
    this.tjO = new d();
    AppMethodBeat.o(1838);
  }
  
  public static boolean ad(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 50L) || (paramLong2 > 5242880L);
  }
  
  private void cKh()
  {
    AppMethodBeat.i(1841);
    if (this.tjP.getParent() != null) {
      ((ViewGroup)this.tjP.getParent()).removeView(this.tjP);
    }
    AppMethodBeat.o(1841);
  }
  
  private q cKi()
  {
    AppMethodBeat.i(1842);
    q localq = new q(this.thM.bMN(), this.thM);
    localq.setRootPath(this.thM.cJe());
    localq.setIOnlineVideoProxy(new r.b(this, (byte)0));
    localq.setReporter(new r.c(this, (byte)0));
    AppMethodBeat.o(1842);
    return localq;
  }
  
  private void cnu()
  {
    AppMethodBeat.i(1843);
    this.tjO.a(this.tjV);
    AppMethodBeat.o(1843);
  }
  
  private void ctQ()
  {
    AppMethodBeat.i(1844);
    this.tjO.cJ(false);
    AppMethodBeat.o(1844);
  }
  
  public final void a(b paramb, ckx paramckx, String paramString, int paramInt)
  {
    AppMethodBeat.i(1840);
    ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", new Object[] { paramckx.xVa, paramckx.title, paramString });
    paramb.cJd().b(paramb.cJf());
    paramb.cJd().cKd();
    paramb.cJd().a(paramckx, paramInt, paramString);
    this.tjP.setKeepScreenOn(true);
    this.tjP.cKg();
    this.tjP.aep(paramString);
    this.tjR = paramckx;
    this.tjS = true;
    this.tjT = false;
    ((PluginTopStoryUI)g.G(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramckx.xVa, Integer.valueOf(0));
    AppMethodBeat.o(1840);
  }
  
  public final void a(f paramf, h.d paramd)
  {
    AppMethodBeat.i(1839);
    if ((paramf == this.tjQ) || (this.thM == null))
    {
      AppMethodBeat.o(1839);
      return;
    }
    if (this.tjP == null) {
      this.tjP = cKi();
    }
    cKh();
    paramf.getVideoViewParent().addView(this.tjP);
    this.tjP.setVideoFooterView(paramf.getControlBar());
    this.tjP.setScaleType(paramd);
    this.tjP.setIMMVideoViewCallback(paramf.getVideoViewCallback());
    this.tjO.a(this.tjV);
    this.tjQ = paramf;
    AppMethodBeat.o(1839);
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(1852);
    this.smh -= 1;
    ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.smh) });
    if (this.smh <= 0)
    {
      if (this.tjP != null)
      {
        stopPlay();
        this.tjP.aEM();
      }
      this.thM = null;
    }
    AppMethodBeat.o(1852);
  }
  
  public final void aeq(String paramString)
  {
    AppMethodBeat.i(1855);
    com.tencent.mm.plugin.topstory.a.b.a locala = this.thM.cJd().tjL;
    if (locala != null) {
      locala.teX = 1L;
    }
    if ((this.tjP != null) && (this.tjP.getSessionId().equals(paramString)))
    {
      ((PluginTopStoryUI)g.G(PluginTopStoryUI.class)).getVideoPlayProgressMap().remove(this.tjR.xVa);
      stopPlay();
    }
    com.tencent.mm.plugin.websearch.api.a.a.kS(26);
    AppMethodBeat.o(1855);
  }
  
  public final void alo()
  {
    AppMethodBeat.i(1851);
    if (this.tjP != null) {
      this.tjP.alo();
    }
    AppMethodBeat.o(1851);
  }
  
  public final void alp()
  {
    AppMethodBeat.i(1850);
    if (this.tjP != null)
    {
      this.tjP.alp();
      if (this.tjQ != null) {
        this.tjQ.cJE();
      }
    }
    AppMethodBeat.o(1850);
  }
  
  public final boolean cKj()
  {
    AppMethodBeat.i(1845);
    if (this.tjP != null)
    {
      boolean bool = this.tjP.isPlaying();
      AppMethodBeat.o(1845);
      return bool;
    }
    AppMethodBeat.o(1845);
    return false;
  }
  
  public final void crn()
  {
    AppMethodBeat.i(1848);
    if (this.tjP != null)
    {
      ctQ();
      this.tjP.setKeepScreenOn(false);
      this.tjP.pause();
      this.tjT = true;
    }
    AppMethodBeat.o(1848);
  }
  
  public final void ctY()
  {
    AppMethodBeat.i(1847);
    if (this.tjP != null)
    {
      cnu();
      this.tjP.setKeepScreenOn(true);
      this.tjP.play();
      this.tjT = false;
    }
    AppMethodBeat.o(1847);
  }
  
  public final void d(b paramb)
  {
    this.smh += 1;
    this.thM = paramb;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(1858);
    if (this.tjP != null)
    {
      int i = this.tjP.getCurrPosMs();
      AppMethodBeat.o(1858);
      return i;
    }
    AppMethodBeat.o(1858);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(1856);
    if (this.tjP != null)
    {
      int i = this.tjP.getCurrPosSec();
      AppMethodBeat.o(1856);
      return i;
    }
    AppMethodBeat.o(1856);
    return 0;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(1857);
    if (this.tjP != null)
    {
      int i = this.tjP.getVideoDurationSec();
      AppMethodBeat.o(1857);
      return i;
    }
    AppMethodBeat.o(1857);
    return 0;
  }
  
  public final void gi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(1854);
    if (paramInt1 == 0)
    {
      if ((this.tjS) && (this.tjX))
      {
        this.tjX = false;
        ctY();
        AppMethodBeat.o(1854);
      }
    }
    else if (paramInt2 == 0)
    {
      if ((this.tjS) && (cKj()))
      {
        this.tjX = true;
        crn();
        AppMethodBeat.o(1854);
      }
    }
    else if ((paramInt2 == 1) && (this.tjW) && (this.tjS) && (this.tjT))
    {
      this.tjW = false;
      ctY();
      this.tjQ.cJB();
    }
    AppMethodBeat.o(1854);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(1853);
    if ((this.tjP != null) && (this.tjP.getSessionId().equals(paramString))) {
      stopPlay();
    }
    AppMethodBeat.o(1853);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(1846);
    if (this.tjP != null) {
      this.tjP.setMute(paramBoolean);
    }
    AppMethodBeat.o(1846);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(1849);
    if (this.tjP != null)
    {
      ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
      ctQ();
      this.tjP.cKf();
      this.tjP.setKeepScreenOn(false);
      this.tjP.stop();
      this.tjR = null;
      this.tjS = false;
      this.tjT = false;
      if (this.thM != null)
      {
        this.thM.cJd().b(this.thM.cJf());
        this.thM.cJd().cKd();
      }
      if (this.tjQ != null) {
        this.tjQ.cJF();
      }
    }
    AppMethodBeat.o(1849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r
 * JD-Core Version:    0.7.0.1
 */