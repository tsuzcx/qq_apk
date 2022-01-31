package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.UUID;

public abstract class f
  extends RelativeLayout
{
  public static c pEq;
  public String bIB = "";
  public TextView eXr;
  public byg pDy;
  public TextView pEA;
  public View pEB;
  public View pEC;
  public View pED;
  public View pEE;
  protected View pEF;
  public FrameLayout pEG;
  public ImageView pEH;
  public ImageView pEI;
  public a pEJ;
  public f.a pEK = f.a.pEL;
  public b pEp;
  public FrameLayout pEr;
  public TextView pEs;
  protected View pEt;
  public ImageView pEu;
  protected TextView pEv;
  public ImageView pEw;
  public ImageView pEx;
  public Button pEy;
  protected TextView pEz;
  
  static
  {
    c.a locala = new c.a();
    locala.erf = true;
    locala.ere = true;
    pEq = locala.OV();
  }
  
  public f(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.pEp = paramb;
    this.pEJ = parama;
    init();
  }
  
  public final void a(byg parambyg, int paramInt)
  {
    y.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", new Object[] { Integer.valueOf(paramInt) });
    this.pDy = parambyg;
    aZ();
  }
  
  public void aZ()
  {
    this.pEu.setImageDrawable(null);
    com.tencent.mm.as.o.ON().a(this.pDy.tOv, this.pEu, pEq);
  }
  
  public abstract void bNL();
  
  public abstract void bNM();
  
  public void bNN()
  {
    y.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.pEJ.bNr()) });
    this.pEC.setVisibility(8);
    this.pEu.setVisibility(8);
    this.pEs.setVisibility(8);
    this.pEB.setVisibility(8);
    this.pEr.setVisibility(0);
    this.pEr.setAlpha(1.0F);
  }
  
  public final void bNO()
  {
    y.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.pEJ.bNr()) });
    this.pEu.setVisibility(0);
    this.pEC.setVisibility(0);
    this.pEG.setVisibility(8);
    this.pED.setVisibility(8);
    this.pEB.setVisibility(0);
    this.pEE.setVisibility(0);
    this.pEw.setVisibility(0);
    this.pEx.setVisibility(8);
    this.pEA.setVisibility(8);
    if ((this.pEp.bNs().bOm()) && (!com.tencent.mm.plugin.topstory.a.g.bNg()))
    {
      this.pEv.setText(getContext().getString(b.g.top_story_mobile_net_tips, new Object[] { bk.a(this.pDy.tOF, 100.0D) }));
      this.pEv.setVisibility(0);
      return;
    }
    this.pEv.setVisibility(8);
  }
  
  public final void bNP()
  {
    fc(getNoNetTip(), this.pEp.bfn().getString(b.g.video_retry_play));
    getContext().getString(b.g.top_story_mobile_net_warnning, new Object[] { bk.a(this.pDy.tOF, 100.0D) });
  }
  
  public final void bNQ()
  {
    y.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setReplayContainerStatus");
    this.pEu.setVisibility(0);
    this.pEC.setVisibility(0);
    this.pEB.setVisibility(0);
    this.pEs.setVisibility(8);
    this.pED.setVisibility(8);
    this.pEE.setVisibility(0);
    this.pEw.setVisibility(8);
    this.pEv.setVisibility(8);
    this.pEx.setVisibility(0);
    this.pEA.setVisibility(0);
  }
  
  public void bNR() {}
  
  public void bNS() {}
  
  public final void bNT()
  {
    this.pEK = f.a.pEM;
    bNR();
    fc(getMobileNetTip(), getContext().getString(b.g.top_story_continue_play));
  }
  
  public final String bNU()
  {
    this.bIB = UUID.randomUUID().toString();
    return this.bIB;
  }
  
  public void bNV() {}
  
  public final void bNW()
  {
    this.pEG.setVisibility(0);
  }
  
  public final void fc(String paramString1, String paramString2)
  {
    y.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", new Object[] { paramString1, paramString2 });
    this.pEu.setVisibility(0);
    this.pEC.setVisibility(0);
    this.pED.setVisibility(0);
    this.pEB.setVisibility(0);
    this.pEE.setVisibility(8);
    this.pEF.setVisibility(0);
    this.pEt.setVisibility(8);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.pEz.setText(paramString1);
      this.pEz.setVisibility(0);
    }
    while (!TextUtils.isEmpty(paramString2))
    {
      this.pEy.setText(paramString2);
      this.pEy.setVisibility(0);
      return;
      this.pEz.setVisibility(8);
    }
    this.pEy.setVisibility(8);
  }
  
  public abstract g getControlBar();
  
  public a getItemUIComponent()
  {
    return this.pEJ;
  }
  
  public abstract int getLayoutId();
  
  protected String getMobileNetTip()
  {
    if (this.pDy.tOF == 0L) {
      return getContext().getString(b.g.top_story_mobile_net_warnning_short);
    }
    return getContext().getString(b.g.top_story_mobile_net_warnning, new Object[] { bk.a(this.pDy.tOF, 100.0D) });
  }
  
  public String getNoNetTip()
  {
    return getContext().getString(b.g.video_net_disable_warnning);
  }
  
  public h.d getScaleType()
  {
    return h.d.rZQ;
  }
  
  public abstract h.b getVideoViewCallback();
  
  public FrameLayout getVideoViewParent()
  {
    return this.pEr;
  }
  
  public void init()
  {
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    this.pEr = ((FrameLayout)findViewById(b.d.video_view_parent));
    this.pEs = ((TextView)findViewById(b.d.progress_tv));
    this.pEB = findViewById(b.d.tips_bg);
    this.pEC = findViewById(b.d.video_action_and_info_layout);
    this.pED = findViewById(b.d.video_tip_and_loading_layout);
    this.pEE = findViewById(b.d.video_action_layout);
    this.pEF = findViewById(b.d.video_info_layout);
    this.pEt = findViewById(b.d.video_loading_progress_bar);
    this.pEu = ((ImageView)findViewById(b.d.cover_iv));
    this.pEv = ((TextView)findViewById(b.d.video_size_tv));
    this.eXr = ((TextView)findViewById(b.d.title_tv));
    this.pEw = ((ImageView)findViewById(b.d.cover_area_play_btn));
    this.pEx = ((ImageView)findViewById(b.d.cover_area_replay_btn));
    this.pEA = ((TextView)findViewById(b.d.replay_hint_tv));
    this.pEy = ((Button)findViewById(b.d.tip_cover_play));
    this.pEz = ((TextView)findViewById(b.d.tip_cover_warning));
    this.pEH = ((ImageView)findViewById(b.d.player_bottom_progress_bar_front));
    this.pEI = ((ImageView)findViewById(b.d.player_bottom_progress_bar_background));
    this.pEG = ((FrameLayout)findViewById(b.d.player_bottom_progress_root));
  }
  
  public boolean jI(boolean paramBoolean)
  {
    if (!this.pEp.bNs().isConnected())
    {
      this.pEK = f.a.pEN;
      bNR();
      fc(getNoNetTip(), getContext().getString(b.g.video_retry_play));
      return false;
    }
    if ((paramBoolean) && (this.pEp.bNs().bOm()) && (!com.tencent.mm.plugin.topstory.a.g.bNg()) && (!this.pEp.bNs().pFL))
    {
      bNT();
      return false;
    }
    bNU();
    this.pEK = f.a.pEL;
    y.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
    this.pEC.setVisibility(0);
    this.pEE.setVisibility(8);
    this.pEB.setVisibility(8);
    this.pEG.setVisibility(8);
    this.pED.setVisibility(0);
    this.pEF.setVisibility(8);
    this.pEt.setVisibility(0);
    this.pEt.setVisibility(0);
    this.pEt.setAlpha(0.0F);
    this.pEt.animate().setDuration(4000L).setInterpolator(new AccelerateInterpolator()).alpha(1.0F).start();
    this.pEu.setVisibility(0);
    this.pEs.setVisibility(8);
    this.pEr.setVisibility(0);
    this.pEr.setAlpha(0.0F);
    this.pEp.bNx().a(this, getScaleType());
    r localr = this.pEp.bNx();
    b localb = this.pEp;
    byg localbyg = this.pDy;
    String str = this.bIB;
    int i = this.pEJ.bNr();
    if (localr.pGw != null)
    {
      if (!localr.pGw.qVw.equals(localbyg.qVw))
      {
        localr.pGu.stop();
        localb.bNt().b(localb.bNv());
        localb.bNt().bOp();
      }
    }
    else
    {
      if (!bk.bl(localbyg.videoUrl)) {
        break label412;
      }
      y.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", new Object[] { str, localbyg.tOx, localbyg.title });
    }
    for (;;)
    {
      return true;
      label412:
      localb.bNt().a(localbyg, i, str);
      localr.pEp.bNt().b(localbyg);
      localr.pGu.setLoop(false);
      localr.pGu.setVideoInfo(localbyg);
      localr.pGu.setMute(localb.Bj());
      localr.pGu.setKeepScreenOn(true);
      localr.pGu.PN(str);
      localr.pGu.bOs();
      localr.pGw = localbyg;
      localr.pGx = true;
      localr.pGy = false;
    }
  }
  
  public final void seekTo(int paramInt)
  {
    y.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.pEp.bNx().getCurrPosSec()) });
    Object localObject = this.pEp.bNx();
    if (((r)localObject).pGu != null) {
      ((r)localObject).pGu.y(paramInt, true);
    }
    localObject = this.pEp.bNt().pGq;
    if (localObject != null) {
      ((com.tencent.mm.plugin.topstory.a.b.a)localObject).pDj = 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.f
 * JD-Core Version:    0.7.0.1
 */