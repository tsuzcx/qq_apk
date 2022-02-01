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
import android.widget.Toast;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.est;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import java.util.HashMap;
import java.util.UUID;

public abstract class f
  extends RelativeLayout
{
  public static c MYh;
  public esy MWs;
  public b MYE;
  protected FrameLayout MYF;
  public TextView MYG;
  protected View MYH;
  protected TextView MYI;
  protected ImageView MYJ;
  protected ImageView MYK;
  protected Button MYL;
  protected TextView MYM;
  protected TextView MYN;
  protected View MYO;
  protected View MYP;
  protected View MYQ;
  protected View MYR;
  protected View MYS;
  public FrameLayout MYT;
  public ImageView MYU;
  public ImageView MYV;
  public a MYW;
  protected TextView MYX;
  public f.a MYY = f.a.MYZ;
  protected ImageView sDJ;
  public String sessionId = "";
  protected TextView titleTv;
  
  static
  {
    c.a locala = new c.a();
    locala.lRD = true;
    locala.lRC = true;
    MYh = locala.bmL();
  }
  
  public f(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.MYE = paramb;
    this.MYW = parama;
    init();
  }
  
  public final void a(esy paramesy, int paramInt)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", new Object[] { Integer.valueOf(paramInt) });
    this.MWs = paramesy;
    updateView();
  }
  
  public boolean aL(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.MYE.gqM();
    Object localObject2 = ai.gQP();
    int i = this.MYE.gqN();
    if (!this.MYE.gqx().isConnected())
    {
      this.MYY = f.a.MZb;
      gqZ();
      lF(getNoNetTip(), getContext().getString(c.g.video_retry_play));
      this.MYE.gqC().a(this, c(this.MWs));
      return false;
    }
    if ((!((String)localObject2).equals("wifi")) && (!((String)localObject2).equals(localObject1)))
    {
      if (!((String)localObject2).equals("wangka")) {
        break label705;
      }
      if ((i != 1) && (i != 2))
      {
        this.MYE.ajC(1);
        if (this.MYX == null) {
          break label683;
        }
        this.MYX.setVisibility(0);
        this.MYX.setAlpha(1.0F);
        this.MYX.animate().alpha(0.0F).setDuration(3000L).start();
      }
    }
    this.MYE.bfd((String)localObject2);
    grc();
    this.MYY = f.a.MYZ;
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
    this.MYP.setVisibility(0);
    this.MYR.setVisibility(8);
    this.MYO.setVisibility(8);
    this.MYT.setVisibility(8);
    this.MYQ.setVisibility(0);
    this.MYS.setVisibility(8);
    this.MYH.setVisibility(0);
    this.MYH.setVisibility(0);
    this.MYH.setAlpha(0.0F);
    this.MYH.animate().setDuration(4000L).setInterpolator(new AccelerateInterpolator()).alpha(1.0F).start();
    this.sDJ.setVisibility(0);
    this.MYG.setVisibility(8);
    this.MYF.setVisibility(0);
    this.MYF.setAlpha(0.0F);
    this.MYE.gqC().a(this, c(this.MWs));
    localObject1 = this.MYE.gqC();
    Object localObject3 = this.MYE;
    localObject2 = this.MWs;
    String str = this.sessionId;
    int j = this.MYW.gqw();
    HashMap localHashMap = ((PluginTopStoryUI)h.ag(PluginTopStoryUI.class)).getVideoPlayProgressMap();
    if (localHashMap.containsKey(((esy)localObject2).Crh)) {}
    for (i = ((Integer)localHashMap.get(((esy)localObject2).Crh)).intValue();; i = 0)
    {
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPlay, pos:%s, vid:%s videoProgress: %d", new Object[] { Integer.valueOf(j), ((esy)localObject2).Crh, Integer.valueOf(i) });
      if (((esy)localObject2).Uvf != null) {
        Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "video %s secondVideoInfo %d %d", new Object[] { ((esy)localObject2).Crh, Integer.valueOf(((esy)localObject2).Uvf.Uuz), Integer.valueOf(((esy)localObject2).Uvf.UuA) });
      }
      if (((esy)localObject2).Uvn != null) {
        ((esy)localObject2).Uvn.fxt = false;
      }
      if (((r)localObject1).MWv != null)
      {
        if ((!((r)localObject1).MWv.BHW.equals(((esy)localObject2).BHW)) || (paramBoolean2))
        {
          ((r)localObject1).NaK.stop();
          ((b)localObject3).gqy().b(((b)localObject3).gqA());
          ((b)localObject3).gqy().grC();
        }
      }
      else
      {
        if (!Util.isNullOrNil(((esy)localObject2).videoUrl)) {
          break label757;
        }
        Log.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", new Object[] { str, ((esy)localObject2).Crh, ((esy)localObject2).title });
      }
      return true;
      label683:
      w.makeText(this.MYE.eOa(), c.g.top_story_mobile_wangka_tips, 0).show();
      break;
      label705:
      if (i == 2) {
        break;
      }
      grb();
      this.MYE.gqC().a(this, c(this.MWs));
      return false;
      localHashMap.put(((esy)localObject2).Crh, Integer.valueOf(0));
    }
    label757:
    ((b)localObject3).gqy().a((esy)localObject2, j, str);
    ((r)localObject1).MYE.gqy().j((esy)localObject2);
    ((r)localObject1).NaK.setLoop(false);
    ((r)localObject1).NaK.setVideoInfo((esy)localObject2);
    ((r)localObject1).NaK.setMute(((b)localObject3).aeg());
    ((r)localObject1).NaK.setKeepScreenOn(true);
    if (i == 0) {
      ((r)localObject1).NaK.bfe(str);
    }
    for (;;)
    {
      ((r)localObject1).NaK.grF();
      ((r)localObject1).MWv = ((esy)localObject2);
      ((r)localObject1).NaM = true;
      ((r)localObject1).NaN = false;
      break;
      localObject3 = ((r)localObject1).NaK;
      ((q)localObject3).sessionId = str;
      ((q)localObject3).I(i, true);
    }
  }
  
  public i.e c(esy paramesy)
  {
    return i.e.RcE;
  }
  
  public void cEI() {}
  
  public abstract g getControlBar();
  
  public a getItemUIComponent()
  {
    return this.MYW;
  }
  
  protected abstract int getLayoutId();
  
  protected String getMobileNetTip()
  {
    if (this.MWs.Uvb == 0L) {
      return getContext().getString(c.g.top_story_mobile_net_warnning_short);
    }
    return getContext().getString(c.g.top_story_mobile_net_warnning, new Object[] { Util.getSizeMB(this.MWs.Uvb, 100.0D) });
  }
  
  public String getNoNetTip()
  {
    return getContext().getString(c.g.video_net_disable_warnning);
  }
  
  public f.a getPauseReason()
  {
    return this.MYY;
  }
  
  public abstract i.b getVideoViewCallback();
  
  public FrameLayout getVideoViewParent()
  {
    return this.MYF;
  }
  
  public abstract void gqU();
  
  public abstract void gqV();
  
  public void gqW()
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.MYW.gqw()) });
    this.MYP.setVisibility(8);
    this.sDJ.setVisibility(8);
    this.MYG.setVisibility(8);
    this.MYO.setVisibility(8);
    this.MYF.setVisibility(0);
    this.MYF.setAlpha(1.0F);
  }
  
  public final void gqX()
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.MYW.gqw()) });
    this.sDJ.setVisibility(0);
    this.MYP.setVisibility(0);
    this.MYT.setVisibility(8);
    this.MYQ.setVisibility(8);
    this.MYO.setVisibility(0);
    this.MYR.setVisibility(0);
    this.MYJ.setVisibility(0);
    this.MYK.setVisibility(8);
    this.MYN.setVisibility(8);
    this.MYI.setVisibility(8);
  }
  
  public final void gqY()
  {
    lF(getNoNetTip(), this.MYE.eOa().getString(c.g.video_retry_play));
    getContext().getString(c.g.top_story_mobile_net_warnning, new Object[] { Util.getSizeMB(this.MWs.Uvb, 100.0D) });
  }
  
  public void gqZ() {}
  
  public void gra() {}
  
  public final void grb()
  {
    this.MYY = f.a.MZa;
    gqZ();
    lF(getMobileNetTip(), getContext().getString(c.g.top_story_continue_play));
  }
  
  public final String grc()
  {
    this.sessionId = UUID.randomUUID().toString();
    return this.sessionId;
  }
  
  public final void grd()
  {
    this.MYT.setVisibility(0);
  }
  
  public void gre() {}
  
  public void grf() {}
  
  public boolean grg()
  {
    return false;
  }
  
  protected void init()
  {
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    this.MYF = ((FrameLayout)findViewById(c.d.video_view_parent));
    this.MYG = ((TextView)findViewById(c.d.progress_tv));
    this.MYO = findViewById(c.d.tips_bg);
    this.MYP = findViewById(c.d.video_action_and_info_layout);
    this.MYQ = findViewById(c.d.video_tip_and_loading_layout);
    this.MYR = findViewById(c.d.video_action_layout);
    this.MYS = findViewById(c.d.video_info_layout);
    this.MYH = findViewById(c.d.video_loading_progress_bar);
    this.sDJ = ((ImageView)findViewById(c.d.cover_iv));
    this.MYI = ((TextView)findViewById(c.d.video_size_tv));
    this.titleTv = ((TextView)findViewById(c.d.title_tv));
    this.MYJ = ((ImageView)findViewById(c.d.cover_area_play_btn));
    this.MYK = ((ImageView)findViewById(c.d.cover_area_replay_btn));
    this.MYN = ((TextView)findViewById(c.d.replay_hint_tv));
    this.MYL = ((Button)findViewById(c.d.tip_cover_play));
    this.MYM = ((TextView)findViewById(c.d.tip_cover_warning));
    this.MYU = ((ImageView)findViewById(c.d.player_bottom_progress_bar_front));
    this.MYV = ((ImageView)findViewById(c.d.player_bottom_progress_bar_background));
    this.MYT = ((FrameLayout)findViewById(c.d.player_bottom_progress_root));
    this.MYX = ((TextView)findViewById(c.d.network_toast));
  }
  
  public final void lF(String paramString1, String paramString2)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", new Object[] { paramString1, paramString2 });
    this.sDJ.setVisibility(0);
    this.MYP.setVisibility(0);
    this.MYQ.setVisibility(0);
    this.MYO.setVisibility(0);
    this.MYR.setVisibility(8);
    this.MYS.setVisibility(0);
    this.MYH.setVisibility(8);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.MYM.setText(paramString1);
      this.MYM.setVisibility(0);
    }
    while (!TextUtils.isEmpty(paramString2))
    {
      this.MYL.setText(paramString2);
      this.MYL.setVisibility(0);
      return;
      this.MYM.setVisibility(8);
    }
    this.MYL.setVisibility(8);
  }
  
  public final void seekTo(int paramInt)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.MYE.gqC().getCurrPosSec()) });
    Object localObject = this.MYE.gqC();
    if (((r)localObject).NaK != null) {
      ((r)localObject).NaK.I(paramInt, true);
    }
    localObject = this.MYE.gqy().NaG;
    if (localObject != null) {
      ((com.tencent.mm.plugin.topstory.a.b.b)localObject).MWc = 1L;
    }
  }
  
  protected void updateView()
  {
    this.sDJ.setImageDrawable(null);
    com.tencent.mm.ay.q.bml().a(this.MWs.UuU, this.sDJ, MYh);
    if (this.MYX != null)
    {
      this.MYX.animate().cancel();
      this.MYX.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.f
 * JD-Core Version:    0.7.0.1
 */