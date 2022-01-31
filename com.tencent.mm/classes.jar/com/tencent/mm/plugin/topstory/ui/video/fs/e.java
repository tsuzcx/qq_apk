package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.af;

public class e
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  private boolean isLoading;
  protected f tkg;
  protected k tkh;
  protected View.OnClickListener tki;
  protected View.OnClickListener tkj;
  protected View.OnClickListener tkk;
  protected View.OnClickListener tkl;
  protected View.OnClickListener tkm;
  protected View.OnClickListener tkn;
  private h.b tko;
  public boolean tkp;
  
  public e(Context paramContext, b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(1909);
    this.tko = new e.3(this);
    if (this.thM.cJn()) {
      this.kha.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    AppMethodBeat.o(1909);
  }
  
  private boolean aEU()
  {
    AppMethodBeat.i(1920);
    if (this.thX.getVisibility() == 0)
    {
      AppMethodBeat.o(1920);
      return true;
    }
    AppMethodBeat.o(1920);
    return false;
  }
  
  protected void aEN()
  {
    AppMethodBeat.i(141937);
    this.tkh = new k(getContext(), this, new e.a(this));
    AppMethodBeat.o(141937);
  }
  
  public void bJ()
  {
    AppMethodBeat.i(1915);
    super.bJ();
    if (this.tkg != null)
    {
      this.tkg.setVideoTotalTime(this.tfm.xUZ);
      this.tkg.j(this.tfm);
    }
    if ((getFSItemUIComponent() != null) && (getFSItemUIComponent().cJb() != getFSVideoUIComponent().cJk()))
    {
      if (!getFSVideoUIComponent().cJc().isConnected()) {
        break label129;
      }
      cJC();
    }
    for (;;)
    {
      if (this.titleTv != null)
      {
        this.titleTv.setText(this.tfm.title);
        af.a(this.titleTv.getPaint(), 0.8F);
      }
      AppMethodBeat.o(1915);
      return;
      label129:
      gT(getNoNetTip(), getContext().getString(2131304536));
    }
  }
  
  public h.d c(ckx paramckx)
  {
    return h.d.vQK;
  }
  
  public final void cJA()
  {
    AppMethodBeat.i(1913);
    ab.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollStopContainerStatus");
    this.thX.setVisibility(0);
    if ((getFSVideoUIComponent().cJc().cJZ()) && (!g.cIz())) {
      this.thW.setVisibility(0);
    }
    for (;;)
    {
      this.kha.setVisibility(0);
      this.thO.setVisibility(8);
      this.thN.setVisibility(8);
      this.tib.setVisibility(8);
      this.thZ.setVisibility(0);
      this.thY.setVisibility(8);
      this.thR.setVisibility(0);
      this.thS.setVisibility(8);
      this.thV.setVisibility(8);
      AppMethodBeat.o(1913);
      return;
      this.thW.setVisibility(8);
    }
  }
  
  public final void cJB()
  {
    AppMethodBeat.i(1911);
    super.cJB();
    AppMethodBeat.o(1911);
  }
  
  public final void cJE()
  {
    AppMethodBeat.i(1917);
    if (this.tkg != null) {
      this.tkg.setVisibility(8);
    }
    AppMethodBeat.o(1917);
  }
  
  public final void cJF()
  {
    AppMethodBeat.i(1914);
    f localf = this.tkg;
    if (localf.tkH != null) {
      localf.tkH.stopTimer();
    }
    AppMethodBeat.o(1914);
  }
  
  public final void cJI()
  {
    AppMethodBeat.i(1918);
    if (this.tkg != null) {
      this.tkg.show();
    }
    AppMethodBeat.o(1918);
  }
  
  public final void cJz()
  {
    AppMethodBeat.i(1912);
    ab.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "setListScrollPlayContainerStatus");
    this.thX.setVisibility(8);
    this.thW.setVisibility(8);
    this.kha.setVisibility(0);
    this.thO.setVisibility(8);
    this.thN.setVisibility(8);
    this.tib.setVisibility(8);
    AppMethodBeat.o(1912);
  }
  
  protected void cKl()
  {
    AppMethodBeat.i(141936);
    this.tkg.i(this.tfm);
    AppMethodBeat.o(141936);
  }
  
  public f getControlBar()
  {
    return this.tkg;
  }
  
  public a getFSItemUIComponent()
  {
    return (a)this.tif;
  }
  
  public b getFSVideoUIComponent()
  {
    return this.thM;
  }
  
  public int getLayoutId()
  {
    return 2130971013;
  }
  
  public String getSessionId()
  {
    return this.cpW;
  }
  
  public ckx getVideoInfo()
  {
    return this.tfm;
  }
  
  public h.b getVideoViewCallback()
  {
    return this.tko;
  }
  
  public void init()
  {
    AppMethodBeat.i(1910);
    super.init();
    this.tki = new e.1(this);
    this.tkj = new e.8(this);
    this.tkk = new e.9(this);
    this.tkl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(1895);
        e.this.getFSVideoUIComponent().a(e.c(e.this));
        e.this.cKl();
        AppMethodBeat.o(1895);
      }
    };
    this.tkm = new e.11(this);
    this.tkn = new e.12(this);
    this.thT.setOnClickListener(new e.13(this));
    this.thR.setOnClickListener(new e.14(this));
    this.thS.setOnClickListener(new e.15(this));
    this.thX.setOnClickListener(new e.2(this));
    aEN();
    if (getFSVideoUIComponent().cJn()) {
      this.tkg = new l(getContext());
    }
    for (;;)
    {
      this.tkg.setOnlyFS(this.tkp);
      this.tkg.setVisibility(8);
      this.tkg.setShareBtnClickListener(this.tkk);
      this.tkg.setWowBtnClickListener(this.tkl);
      this.tkg.setTagBtnClickListener(this.tkm);
      this.tkg.setSourceItemClickListener(this.tkn);
      if (g.cIw()) {
        this.tkg.setTitleClickListener(new e.4(this));
      }
      this.tkg.setOnUpdateProgressLenListener(new e.5(this));
      this.tkg.setIplaySeekCallback(new e.6(this));
      this.tkg.setOnPlayButtonClickListener(new e.7(this));
      AppMethodBeat.o(1910);
      return;
      this.tkg = new f(getContext());
      if (af.hW(getContext()))
      {
        f localf = this.tkg;
        int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
        int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
        localf.tkx.setPadding(i, 0, j, 0);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(1919);
    if (this.tkh != null) {
      this.tkh.z(paramMotionEvent);
    }
    AppMethodBeat.o(1919);
    return true;
  }
  
  public void setOnlyFS(boolean paramBoolean)
  {
    AppMethodBeat.i(1921);
    this.tkp = paramBoolean;
    if (this.tkg != null) {
      this.tkg.setOnlyFS(paramBoolean);
    }
    AppMethodBeat.o(1921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e
 * JD-Core Version:    0.7.0.1
 */