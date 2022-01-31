package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  private boolean isLoading;
  private k pGP;
  private View.OnClickListener pGQ;
  private h.b pGV = new f.6(this);
  private g pHI;
  
  public f(Context paramContext, com.tencent.mm.plugin.topstory.ui.video.b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  private boolean aki()
  {
    return this.pEC.getVisibility() == 0;
  }
  
  protected final void aZ()
  {
    super.aZ();
    if (this.pHI != null) {
      this.pHI.setVideoTotalTime(this.pDy.tOw);
    }
    if ((getListItemUIComponent() != null) && (getListItemUIComponent().bNr() != getListVideoUIComponent().bNB()))
    {
      if (getListVideoUIComponent().bNs().isConnected()) {
        bNO();
      }
    }
    else {
      return;
    }
    fc(getNoNetTip(), getContext().getString(b.g.video_retry_play));
  }
  
  public final void bNL()
  {
    y.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
    this.pEC.setVisibility(8);
    this.pEu.setVisibility(0);
    this.pEs.setVisibility(8);
    this.pEr.setVisibility(8);
    this.pEG.setVisibility(8);
  }
  
  public final void bNM()
  {
    y.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
    this.pEC.setVisibility(0);
    this.pEu.setVisibility(0);
    this.pEs.setVisibility(8);
    this.pEr.setVisibility(8);
    this.pEG.setVisibility(8);
    this.pEE.setVisibility(0);
    this.pED.setVisibility(8);
    this.pEw.setVisibility(0);
    this.pEx.setVisibility(8);
    this.pEA.setVisibility(8);
  }
  
  public final void bNN()
  {
    super.bNN();
  }
  
  public final void bNR()
  {
    if (this.pHI != null) {
      this.pHI.setVisibility(8);
    }
  }
  
  public final void bNS()
  {
    g localg = this.pHI;
    if (localg.pHm != null) {
      localg.pHm.stopTimer();
    }
  }
  
  public final g getControlBar()
  {
    return this.pHI;
  }
  
  protected final int getLayoutId()
  {
    return b.e.top_story_list_video_container;
  }
  
  public final a getListItemUIComponent()
  {
    return (a)this.pEJ;
  }
  
  public final b getListVideoUIComponent()
  {
    return (b)this.pEp;
  }
  
  public final h.d getScaleType()
  {
    return h.d.rZS;
  }
  
  public final String getSessionId()
  {
    return this.bIB;
  }
  
  public final byg getVideoInfo()
  {
    return this.pDy;
  }
  
  public final h.b getVideoViewCallback()
  {
    return this.pGV;
  }
  
  protected final void init()
  {
    super.init();
    this.pGQ = new f.1(this);
    this.pEy.setOnClickListener(new f.2(this));
    this.pEw.setOnClickListener(new f.3(this));
    this.pEx.setOnClickListener(new f.4(this));
    this.pEC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if ((f.this.getListItemUIComponent() != null) && (f.this.getListItemUIComponent().bNr() != f.this.getListVideoUIComponent().bNB()))
        {
          f.this.getListVideoUIComponent().bNt().pGp = 2;
          f.this.getListVideoUIComponent().zw(f.j(f.this).bNr());
          f.this.getListVideoUIComponent().bNt().c(f.k(f.this));
          ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(f.this.getListVideoUIComponent().bNv(), f.l(f.this), f.m(f.this).bNr(), 2, "");
        }
      }
    });
    this.pGP = new k(getContext(), this, new f.a(this));
    this.pHI = new g(getContext());
    this.pHI.setVisibility(8);
    this.pHI.setFullScreenBtnClickListener(this.pGQ);
    this.pHI.setOnUpdateProgressLenListener(new g.a()
    {
      public final void bOw()
      {
        f.D(f.this).setVisibility(8);
      }
      
      public final void bOx()
      {
        if ((f.this.getListVideoUIComponent().bNx().pGx) && ((f.this.getListVideoUIComponent().bNx().bOu()) || (f.this.getListVideoUIComponent().bNx().pGy)))
        {
          f.E(f.this).setVisibility(0);
          return;
        }
        f.F(f.this).setVisibility(8);
      }
      
      public final void update(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousInt2 > 0) {}
        for (int i = f.w(f.this).getWidth() * paramAnonymousInt1 / paramAnonymousInt2;; i = 0)
        {
          Object localObject = f.this.getListVideoUIComponent().bNt().pGq;
          if ((localObject != null) && (((com.tencent.mm.plugin.topstory.a.b.a)localObject).pDh < f.this.getListVideoUIComponent().bNx().getCurrPosMs())) {
            ((com.tencent.mm.plugin.topstory.a.b.a)localObject).pDh = f.this.getListVideoUIComponent().bNx().getCurrPosMs();
          }
          localObject = (FrameLayout.LayoutParams)f.x(f.this).getLayoutParams();
          ((FrameLayout.LayoutParams)localObject).width = i;
          f.y(f.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
          f.z(f.this).requestLayout();
          if ((f.A(f.this).tOK <= 0) && (f.B(f.this).ej(paramAnonymousInt1, paramAnonymousInt2))) {
            f.C(f.this).tOK = 1;
          }
          return;
        }
      }
    });
    this.pHI.setIplaySeekCallback(new f.8(this));
    this.pHI.setOnPlayButtonClickListener(new f.9(this));
  }
  
  public final boolean jI(boolean paramBoolean)
  {
    paramBoolean = super.jI(paramBoolean);
    getListVideoUIComponent().bNx().setMute(getListVideoUIComponent().Bj());
    return paramBoolean;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.pGP != null) {
      this.pGP.E(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f
 * JD-Core Version:    0.7.0.1
 */