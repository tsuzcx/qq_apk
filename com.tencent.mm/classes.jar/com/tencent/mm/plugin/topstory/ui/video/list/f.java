package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class f
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  private boolean isLoading;
  private k tkh;
  private View.OnClickListener tki;
  private h.b tko;
  private g tlq;
  
  public f(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    AppMethodBeat.i(2061);
    this.tko = new f.6(this);
    AppMethodBeat.o(2061);
  }
  
  private boolean aEU()
  {
    AppMethodBeat.i(2071);
    if (this.thX.getVisibility() == 0)
    {
      AppMethodBeat.o(2071);
      return true;
    }
    AppMethodBeat.o(2071);
    return false;
  }
  
  public final boolean Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(2066);
    paramBoolean1 = super.Q(paramBoolean1, paramBoolean2);
    getListVideoUIComponent().cJh().setMute(getListVideoUIComponent().DP());
    AppMethodBeat.o(2066);
    return paramBoolean1;
  }
  
  public final void bJ()
  {
    AppMethodBeat.i(2068);
    super.bJ();
    if (this.tlq != null) {
      this.tlq.setVideoTotalTime(this.tfm.xUZ);
    }
    if ((getListItemUIComponent() != null) && (getListItemUIComponent().cJb() != getListVideoUIComponent().cJk()))
    {
      if (getListVideoUIComponent().cJc().isConnected())
      {
        cJC();
        AppMethodBeat.o(2068);
        return;
      }
      gT(getNoNetTip(), getContext().getString(2131304536));
    }
    AppMethodBeat.o(2068);
  }
  
  public final h.d c(ckx paramckx)
  {
    return h.d.vQK;
  }
  
  public final void cJA()
  {
    AppMethodBeat.i(2065);
    ab.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
    this.thX.setVisibility(0);
    this.kha.setVisibility(0);
    this.thO.setVisibility(8);
    this.thN.setVisibility(8);
    this.tib.setVisibility(8);
    this.thZ.setVisibility(0);
    this.thY.setVisibility(8);
    this.thR.setVisibility(0);
    this.thS.setVisibility(8);
    this.thV.setVisibility(8);
    AppMethodBeat.o(2065);
  }
  
  public final void cJB()
  {
    AppMethodBeat.i(2063);
    super.cJB();
    AppMethodBeat.o(2063);
  }
  
  public final void cJE()
  {
    AppMethodBeat.i(2069);
    if (this.tlq != null) {
      this.tlq.setVisibility(8);
    }
    AppMethodBeat.o(2069);
  }
  
  public final void cJF()
  {
    AppMethodBeat.i(2067);
    g localg = this.tlq;
    if (localg.tkH != null) {
      localg.tkH.stopTimer();
    }
    AppMethodBeat.o(2067);
  }
  
  public final void cJz()
  {
    AppMethodBeat.i(2064);
    ab.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
    this.thX.setVisibility(8);
    this.kha.setVisibility(0);
    this.thO.setVisibility(8);
    this.thN.setVisibility(8);
    this.tib.setVisibility(8);
    AppMethodBeat.o(2064);
  }
  
  public final g getControlBar()
  {
    return this.tlq;
  }
  
  public final int getLayoutId()
  {
    return 2130971026;
  }
  
  public final a getListItemUIComponent()
  {
    return (a)this.tif;
  }
  
  public final b getListVideoUIComponent()
  {
    return (b)this.thM;
  }
  
  public final String getSessionId()
  {
    return this.cpW;
  }
  
  public final ckx getVideoInfo()
  {
    return this.tfm;
  }
  
  public final h.b getVideoViewCallback()
  {
    return this.tko;
  }
  
  public final void init()
  {
    AppMethodBeat.i(2062);
    super.init();
    this.tki = new f.1(this);
    this.thT.setOnClickListener(new f.2(this));
    this.thR.setOnClickListener(new f.3(this));
    this.thS.setOnClickListener(new f.4(this));
    this.thX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(2039);
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().cJb() != f.this.getListVideoUIComponent().cJk()))
        {
          f.this.getListVideoUIComponent().cJd().tjK = 2;
          f.this.getListVideoUIComponent().Gz(f.k(f.this).cJb());
          f.this.getListVideoUIComponent().cJd().g(f.l(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().cJf(), f.m(f.this), f.n(f.this).cJb(), 2, "");
        }
        AppMethodBeat.o(2039);
      }
    });
    this.tkh = new k(getContext(), this, new f.a(this));
    this.tlq = new g(getContext());
    this.tlq.setVisibility(8);
    this.tlq.setFullScreenBtnClickListener(this.tki);
    this.tlq.setOnUpdateProgressLenListener(new f.7(this));
    this.tlq.setIplaySeekCallback(new f.8(this));
    this.tlq.setOnPlayButtonClickListener(new f.9(this));
    AppMethodBeat.o(2062);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(2070);
    if (this.tkh != null) {
      this.tkh.z(paramMotionEvent);
    }
    AppMethodBeat.o(2070);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f
 * JD-Core Version:    0.7.0.1
 */