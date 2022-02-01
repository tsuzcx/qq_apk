package com.tencent.mm.plugin.topstory.ui.video;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class r
{
  private int RUS;
  public foh TIZ;
  b TLn;
  private boolean TNA;
  q TNt;
  public f TNu;
  public boolean TNv;
  public boolean TNw;
  public boolean TNx;
  private d.a TNy;
  private boolean TNz;
  private d nmW;
  
  public r()
  {
    AppMethodBeat.i(126212);
    this.RUS = 0;
    this.TNx = false;
    this.TNy = new r.1(this);
    this.nmW = new d();
    AppMethodBeat.o(126212);
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(126218);
    this.nmW.gR(false);
    AppMethodBeat.o(126218);
  }
  
  private void bUf()
  {
    AppMethodBeat.i(126217);
    this.nmW.a(this.TNy);
    AppMethodBeat.o(126217);
  }
  
  public static boolean bv(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 50L) || (paramLong2 > 5242880L);
  }
  
  private void hOG()
  {
    AppMethodBeat.i(126215);
    if (this.TNt.getParent() != null) {
      ((ViewGroup)this.TNt.getParent()).removeView(this.TNt);
    }
    AppMethodBeat.o(126215);
  }
  
  private q hOH()
  {
    AppMethodBeat.i(126216);
    q localq = new q(this.TLn.fWt(), this.TLn);
    localq.setRootPath(this.TLn.hNy());
    localq.setIOnlineVideoProxy(new r.b(this, (byte)0));
    localq.setReporter(new r.c(this, (byte)0));
    AppMethodBeat.o(126216);
    return localq;
  }
  
  public final void a(b paramb, foh paramfoh, String paramString, int paramInt)
  {
    AppMethodBeat.i(126214);
    if (paramfoh.abOO != null) {
      paramfoh.abOO.hBY = false;
    }
    Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "replay video %s %s %s", new Object[] { paramfoh.Ido, paramfoh.title, paramString });
    paramb.hNx().b(paramb.hNz());
    paramb.hNx().hOC();
    paramb.hNx().a(paramfoh, paramInt, paramString);
    this.TNt.setKeepScreenOn(true);
    this.TNt.hOF();
    this.TNt.beB(paramString);
    this.TIZ = paramfoh;
    this.TNv = true;
    this.TNw = false;
    ((PluginTopStoryUI)h.az(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramfoh.Ido, Integer.valueOf(0));
    AppMethodBeat.o(126214);
  }
  
  public final void a(f paramf, i.e parame)
  {
    AppMethodBeat.i(126213);
    if ((paramf == this.TNu) || (this.TLn == null))
    {
      AppMethodBeat.o(126213);
      return;
    }
    if (this.TNt == null) {
      this.TNt = hOH();
    }
    hOG();
    paramf.getVideoViewParent().addView(this.TNt);
    this.TNt.setVideoFooterView(paramf.getControlBar());
    this.TNt.setScaleType(parame);
    this.TNt.setIMMVideoViewCallback(paramf.getVideoViewCallback());
    this.nmW.a(this.TNy);
    this.TNu = paramf;
    AppMethodBeat.o(126213);
  }
  
  public final void bck()
  {
    AppMethodBeat.i(126222);
    if (this.TNt != null)
    {
      abandonAudioFocus();
      this.TNt.setKeepScreenOn(false);
      this.TNt.pause();
      this.TNw = true;
    }
    AppMethodBeat.o(126222);
  }
  
  public final void bcl()
  {
    AppMethodBeat.i(126221);
    if (this.TNt != null)
    {
      bUf();
      this.TNt.setKeepScreenOn(true);
      this.TNt.bNU();
      this.TNw = false;
    }
    AppMethodBeat.o(126221);
  }
  
  public final void beC(String paramString)
  {
    AppMethodBeat.i(126229);
    com.tencent.mm.plugin.topstory.a.b.b localb = this.TLn.hNx().TNp;
    if (localb != null) {
      localb.TIF = 1L;
    }
    if ((this.TNt != null) && (this.TNt.getSessionId().equals(paramString)))
    {
      if (this.TIZ != null) {
        ((PluginTopStoryUI)h.az(PluginTopStoryUI.class)).getVideoPlayProgressMap().remove(this.TIZ.Ido);
      }
      stopPlay();
    }
    a.rG(26);
    AppMethodBeat.o(126229);
  }
  
  public final void d(b paramb)
  {
    this.RUS += 1;
    this.TLn = paramb;
  }
  
  public final boolean fjy()
  {
    AppMethodBeat.i(126219);
    if (this.TNt != null)
    {
      boolean bool = this.TNt.isPlaying();
      AppMethodBeat.o(126219);
      return bool;
    }
    AppMethodBeat.o(126219);
    return false;
  }
  
  public final int getCurrPosMs()
  {
    AppMethodBeat.i(126232);
    if (this.TNt != null)
    {
      int i = this.TNt.getCurrPosMs();
      AppMethodBeat.o(126232);
      return i;
    }
    AppMethodBeat.o(126232);
    return 0;
  }
  
  public final int getCurrPosSec()
  {
    AppMethodBeat.i(126230);
    if (this.TNt != null)
    {
      int i = this.TNt.getCurrPosSec();
      AppMethodBeat.o(126230);
      return i;
    }
    AppMethodBeat.o(126230);
    return 0;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(126231);
    if (this.TNt != null)
    {
      int i = this.TNt.getVideoDurationSec();
      AppMethodBeat.o(126231);
      return i;
    }
    AppMethodBeat.o(126231);
    return 0;
  }
  
  public final void mp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126228);
    if (paramInt1 == 0)
    {
      if ((this.TNv) && (this.TNA))
      {
        this.TNA = false;
        bcl();
        AppMethodBeat.o(126228);
      }
    }
    else if (paramInt2 == 0)
    {
      if ((this.TNv) && (fjy()))
      {
        this.TNA = true;
        bck();
        AppMethodBeat.o(126228);
      }
    }
    else if ((paramInt2 == 1) && (this.TNz) && (this.TNv) && (this.TNw))
    {
      this.TNz = false;
      bcl();
      this.TNu.hNU();
    }
    AppMethodBeat.o(126228);
  }
  
  public final void onError(String paramString)
  {
    AppMethodBeat.i(126227);
    if ((this.TNt != null) && (this.TNt.getSessionId().equals(paramString))) {
      stopPlay();
    }
    AppMethodBeat.o(126227);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126226);
    this.RUS -= 1;
    Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.RUS) });
    if (this.RUS <= 0)
    {
      if (this.TNt != null)
      {
        stopPlay();
        this.TNt.onUIDestroy();
      }
      this.TLn = null;
    }
    AppMethodBeat.o(126226);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(126225);
    if (this.TNt != null) {
      this.TNt.onUIPause();
    }
    AppMethodBeat.o(126225);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(126224);
    if (this.TNt != null)
    {
      this.TNt.onUIResume();
      if (this.TNu != null) {
        this.TNu.hNX();
      }
    }
    AppMethodBeat.o(126224);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(126220);
    if (this.TNt != null) {
      this.TNt.setMute(paramBoolean);
    }
    AppMethodBeat.o(126220);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(126223);
    if (this.TNt != null)
    {
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
      abandonAudioFocus();
      this.TNt.hOE();
      this.TNt.setKeepScreenOn(false);
      this.TNt.stop();
      this.TIZ = null;
      this.TNv = false;
      this.TNw = false;
      if (this.TLn != null)
      {
        this.TLn.hNx().b(this.TLn.hNz());
        this.TLn.hNx().hOC();
      }
      if (this.TNu != null) {
        this.TNu.hNY();
      }
    }
    AppMethodBeat.o(126223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r
 * JD-Core Version:    0.7.0.1
 */