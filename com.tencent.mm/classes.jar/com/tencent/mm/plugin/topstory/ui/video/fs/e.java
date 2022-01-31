package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.b.b;
import com.tencent.mm.plugin.topstory.ui.b.c;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.f.a;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.c.bse;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.plugin.topstory.ui.video.f
{
  private boolean isLoading;
  private f pGO;
  private com.tencent.mm.plugin.topstory.ui.video.k pGP;
  private View.OnClickListener pGQ;
  private View.OnClickListener pGR;
  private View.OnClickListener pGS;
  private View.OnClickListener pGT;
  private View.OnClickListener pGU;
  private h.b pGV = new e.2(this);
  public boolean pGW;
  
  public e(Context paramContext, b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
    if (this.pEp.bNE()) {
      this.pEu.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  private boolean aki()
  {
    return this.pEC.getVisibility() == 0;
  }
  
  protected final void aZ()
  {
    super.aZ();
    f localf;
    if (this.pGO != null)
    {
      this.pGO.setVideoTotalTime(this.pDy.tOw);
      localf = this.pGO;
      byg localbyg = this.pDy;
      localf.pHa.setVisibility(0);
      float f = localf.getResources().getDimensionPixelSize(b.b.fts_web_video_fullscreen_control_bar_time_textsize);
      localf.ofs.setTextSize(0, f);
      localf.oft.setTextSize(0, f);
      Object localObject = localf.pHd.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = localf.getResources().getDimensionPixelSize(b.b.fts_web_video_fullscreen_control_bar_height);
      localf.pHd.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (localbyg.sXo.size() <= 0) {
        break label623;
      }
      if (localf.pHe != null) {
        localf.pHe.setVisibility(0);
      }
      localf.pHf.setVisibility(0);
      localf.pHg.setVisibility(8);
      localObject = (bse)localbyg.sXo.get(0);
      localf.pHh.setTag(localObject);
      localf.kEq.setText(((bse)localObject).bQZ);
      localf.kEq.setVisibility(0);
      localf.pHh.setVisibility(0);
      localf.pHj.setVisibility(8);
      if (!bk.bl(((bse)localObject).bVO))
      {
        o.ON().a(((bse)localObject).bVO, localf.pHj, d.pDK);
        localf.pHj.setVisibility(0);
      }
      if (localbyg.sXo.size() <= 1) {
        break label602;
      }
      localObject = (bse)localbyg.sXo.get(1);
      localf.pHi.setTag(localObject);
      localf.kEr.setText(((bse)localObject).bQZ);
      localf.kEr.setVisibility(0);
      localf.pHi.setVisibility(0);
      localf.pHk.setVisibility(8);
      if (!bk.bl(((bse)localObject).bVO))
      {
        o.ON().a(((bse)localObject).bVO, localf.pHk, d.pDK);
        localf.pHk.setVisibility(0);
      }
      if (localf.pGW)
      {
        localf.pHf.setVisibility(8);
        localf.pGZ.setVisibility(8);
        localf.pHb.setVisibility(8);
      }
      if ((localf.pHl != null) && (localf.nMe != null) && (localf.pEY != null))
      {
        localf.pHl.setVisibility(8);
        localf.nMe.setVisibility(8);
        localf.pEY.setVisibility(8);
        if (!bk.bl(localbyg.aWf))
        {
          localf.nMe.setText(localbyg.aWf);
          localf.nMe.setVisibility(0);
          if (!bk.bl(localbyg.mSy)) {
            localf.pHl.setVisibility(0);
          }
          if (bk.bl(localbyg.tOD)) {
            break label651;
          }
          o.ON().a(localbyg.tOD, localf.pEY, d.pDJ);
          label507:
          localf.pEY.setVisibility(0);
        }
      }
      if (localf.eXr != null) {
        localf.eXr.setText(localbyg.title);
      }
    }
    if ((getFSItemUIComponent() != null) && (getFSItemUIComponent().bNr() != getFSVideoUIComponent().bNB()))
    {
      if (!getFSVideoUIComponent().bNs().isConnected()) {
        break label664;
      }
      bNO();
    }
    for (;;)
    {
      if (this.eXr != null) {
        this.eXr.setText(this.pDy.title);
      }
      return;
      label602:
      localf.pHi.setVisibility(8);
      localf.kEr.setVisibility(8);
      break;
      label623:
      if (localf.pHe != null) {
        localf.pHe.setVisibility(8);
      }
      localf.pHf.setVisibility(8);
      break;
      label651:
      localf.pEY.setImageResource(b.c.default_avatar);
      break label507;
      label664:
      fc(getNoNetTip(), getContext().getString(b.g.video_retry_play));
    }
  }
  
  public final void bNL()
  {
    y.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollPlayContainerStatus");
    this.pEC.setVisibility(8);
    this.pEB.setVisibility(8);
    this.pEu.setVisibility(0);
    this.pEs.setVisibility(8);
    this.pEr.setVisibility(8);
    this.pEG.setVisibility(8);
  }
  
  public final void bNM()
  {
    y.d("MicroMsg.TopStory.TopStoryListVideoContainer", "setListScrollStopContainerStatus");
    this.pEC.setVisibility(0);
    if ((getFSVideoUIComponent().bNs().bOm()) && (!g.bNg())) {
      this.pEB.setVisibility(0);
    }
    for (;;)
    {
      this.pEu.setVisibility(0);
      this.pEs.setVisibility(8);
      this.pEr.setVisibility(8);
      this.pEG.setVisibility(8);
      this.pEE.setVisibility(0);
      this.pED.setVisibility(8);
      this.pEw.setVisibility(0);
      this.pEx.setVisibility(8);
      this.pEA.setVisibility(8);
      return;
      this.pEB.setVisibility(8);
    }
  }
  
  public final void bNN()
  {
    super.bNN();
  }
  
  public final void bNR()
  {
    if (this.pGO != null) {
      this.pGO.setVisibility(8);
    }
  }
  
  public final void bNS()
  {
    f localf = this.pGO;
    if (localf.pHm != null) {
      localf.pHm.stopTimer();
    }
  }
  
  public final void bNV()
  {
    if (this.pGO != null) {
      this.pGO.show();
    }
  }
  
  public final f getControlBar()
  {
    return this.pGO;
  }
  
  public final a getFSItemUIComponent()
  {
    return (a)this.pEJ;
  }
  
  public final b getFSVideoUIComponent()
  {
    return this.pEp;
  }
  
  protected final int getLayoutId()
  {
    return b.e.top_story_fs_video_container;
  }
  
  public final h.d getScaleType()
  {
    if (this.pEp.bNE()) {
      return h.d.rZT;
    }
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
    this.pGQ = new e.1(this);
    this.pGR = new e.6(this);
    this.pGS = new e.7(this);
    this.pGT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        b localb = e.this.getFSVideoUIComponent();
        e.c(e.this).bNr();
        localb.a((bse)paramAnonymousView.getTag());
      }
    };
    this.pGU = new e.9(this);
    this.pEy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (e.g(e.this) == f.a.pEM) {
          e.this.getFSVideoUIComponent().bNs().pFL = true;
        }
        if (e.this.getFSVideoUIComponent().bNs().isConnected())
        {
          if (e.this.getFSVideoUIComponent().bNx().pGx) {
            e.this.getFSVideoUIComponent().bNx().bMs();
          }
          for (;;)
          {
            com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(19);
            return;
            e.this.jI(true);
          }
        }
        com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(20);
      }
    });
    this.pEw.setOnClickListener(new e.11(this));
    this.pEx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        e.this.bNU();
        e.l(e.this).akG();
        e.this.getFSVideoUIComponent().bNt().pGp = 2;
        e.this.getFSVideoUIComponent().bNx().a(e.this.getFSVideoUIComponent(), e.m(e.this), e.n(e.this), e.o(e.this).bNr());
        e.this.bNN();
      }
    });
    this.pEC.setOnClickListener(new e.13(this));
    this.pGP = new com.tencent.mm.plugin.topstory.ui.video.k(getContext(), this, new e.a(this));
    if (getFSVideoUIComponent().bNE()) {}
    for (this.pGO = new k(getContext());; this.pGO = new f(getContext()))
    {
      this.pGO.setOnlyFS(this.pGW);
      this.pGO.setVisibility(8);
      this.pGO.setFullScreenBtnClickListener(this.pGQ);
      this.pGO.setFeedbackBtnClickListener(this.pGR);
      this.pGO.setShareBtnClickListener(this.pGS);
      this.pGO.setTagBtnClickListener(this.pGT);
      this.pGO.setSourceItemClickListener(this.pGU);
      this.pGO.setOnUpdateProgressLenListener(new e.3(this));
      this.pGO.setIplaySeekCallback(new e.4(this));
      this.pGO.setOnPlayButtonClickListener(new e.5(this));
      return;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.pGP != null) {
      this.pGP.E(paramMotionEvent);
    }
    return true;
  }
  
  public final void setOnlyFS(boolean paramBoolean)
  {
    this.pGW = paramBoolean;
    if (this.pGO != null) {
      this.pGO.setOnlyFS(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e
 * JD-Core Version:    0.7.0.1
 */