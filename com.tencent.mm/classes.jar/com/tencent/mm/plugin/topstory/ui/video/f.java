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
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.foc;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import java.util.HashMap;
import java.util.UUID;

public abstract class f
  extends RelativeLayout
{
  public static c TKP;
  public foh TIW;
  protected View TLA;
  protected View TLB;
  public FrameLayout TLC;
  public ImageView TLD;
  public ImageView TLE;
  public a TLF;
  protected TextView TLG;
  public f.a TLH = f.a.TLI;
  public b TLn;
  protected FrameLayout TLo;
  public TextView TLp;
  protected View TLq;
  protected TextView TLr;
  protected ImageView TLs;
  protected ImageView TLt;
  protected Button TLu;
  protected TextView TLv;
  protected TextView TLw;
  protected View TLx;
  protected View TLy;
  protected View TLz;
  protected ImageView coverIv;
  public String sessionId = "";
  protected TextView titleTv;
  
  static
  {
    c.a locala = new c.a();
    locala.oKp = true;
    locala.oKo = true;
    TKP = locala.bKx();
  }
  
  public f(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.TLn = paramb;
    this.TLF = parama;
    init();
  }
  
  public final void a(foh paramfoh, int paramInt)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", new Object[] { Integer.valueOf(paramInt) });
    this.TIW = paramfoh;
    updateView();
  }
  
  public boolean bi(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.TLn.hNL();
    Object localObject2 = aj.iqb();
    int i = this.TLn.hNM();
    if (!this.TLn.hNw().isConnected())
    {
      this.TLH = f.a.TLK;
      hNX();
      nn(getNoNetTip(), getContext().getString(c.g.video_retry_play));
      this.TLn.hNB().a(this, c(this.TIW));
      return false;
    }
    if ((!((String)localObject2).equals("wifi")) && (!((String)localObject2).equals(localObject1)))
    {
      if (!((String)localObject2).equals("wangka")) {
        break label705;
      }
      if ((i != 1) && (i != 2))
      {
        this.TLn.aoV(1);
        if (this.TLG == null) {
          break label683;
        }
        this.TLG.setVisibility(0);
        this.TLG.setAlpha(1.0F);
        this.TLG.animate().alpha(0.0F).setDuration(3000L).start();
      }
    }
    this.TLn.beA((String)localObject2);
    hOa();
    this.TLH = f.a.TLI;
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
    this.TLy.setVisibility(0);
    this.TLA.setVisibility(8);
    this.TLx.setVisibility(8);
    this.TLC.setVisibility(8);
    this.TLz.setVisibility(0);
    this.TLB.setVisibility(8);
    this.TLq.setVisibility(0);
    this.TLq.setVisibility(0);
    this.TLq.setAlpha(0.0F);
    this.TLq.animate().setDuration(4000L).setInterpolator(new AccelerateInterpolator()).alpha(1.0F).start();
    this.coverIv.setVisibility(0);
    this.TLp.setVisibility(8);
    this.TLo.setVisibility(0);
    this.TLo.setAlpha(0.0F);
    this.TLn.hNB().a(this, c(this.TIW));
    localObject1 = this.TLn.hNB();
    Object localObject3 = this.TLn;
    localObject2 = this.TIW;
    String str = this.sessionId;
    int j = this.TLF.hNv();
    HashMap localHashMap = ((PluginTopStoryUI)h.az(PluginTopStoryUI.class)).getVideoPlayProgressMap();
    if (localHashMap.containsKey(((foh)localObject2).Ido)) {}
    for (i = ((Integer)localHashMap.get(((foh)localObject2).Ido)).intValue();; i = 0)
    {
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPlay, pos:%s, vid:%s videoProgress: %d", new Object[] { Integer.valueOf(j), ((foh)localObject2).Ido, Integer.valueOf(i) });
      if (((foh)localObject2).abOG != null) {
        Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "video %s secondVideoInfo %d %d", new Object[] { ((foh)localObject2).Ido, Integer.valueOf(((foh)localObject2).abOG.abOb), Integer.valueOf(((foh)localObject2).abOG.abOc) });
      }
      if (((foh)localObject2).abOO != null) {
        ((foh)localObject2).abOO.hBY = false;
      }
      if (((r)localObject1).TIZ != null)
      {
        if ((!((r)localObject1).TIZ.HsD.equals(((foh)localObject2).HsD)) || (paramBoolean2))
        {
          ((r)localObject1).TNt.stop();
          ((b)localObject3).hNx().b(((b)localObject3).hNz());
          ((b)localObject3).hNx().hOC();
        }
      }
      else
      {
        if (!Util.isNullOrNil(((foh)localObject2).videoUrl)) {
          break label757;
        }
        Log.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", new Object[] { str, ((foh)localObject2).Ido, ((foh)localObject2).title });
      }
      return true;
      label683:
      aa.makeText(this.TLn.fWt(), c.g.top_story_mobile_wangka_tips, 0).show();
      break;
      label705:
      if (i == 2) {
        break;
      }
      hNZ();
      this.TLn.hNB().a(this, c(this.TIW));
      return false;
      localHashMap.put(((foh)localObject2).Ido, Integer.valueOf(0));
    }
    label757:
    ((b)localObject3).hNx().a((foh)localObject2, j, str);
    ((r)localObject1).TLn.hNx().j((foh)localObject2);
    ((r)localObject1).TNt.setLoop(false);
    ((r)localObject1).TNt.setVideoInfo((foh)localObject2);
    ((r)localObject1).TNt.setMute(((b)localObject3).aGe());
    ((r)localObject1).TNt.setKeepScreenOn(true);
    if (i == 0) {
      ((r)localObject1).TNt.beB(str);
    }
    for (;;)
    {
      ((r)localObject1).TNt.hOF();
      ((r)localObject1).TIZ = ((foh)localObject2);
      ((r)localObject1).TNv = true;
      ((r)localObject1).TNw = false;
      break;
      localObject3 = ((r)localObject1).TNt;
      ((q)localObject3).sessionId = str;
      ((q)localObject3).X(i, true);
    }
  }
  
  public i.e c(foh paramfoh)
  {
    return i.e.XYK;
  }
  
  public abstract g getControlBar();
  
  public a getItemUIComponent()
  {
    return this.TLF;
  }
  
  protected abstract int getLayoutId();
  
  protected String getMobileNetTip()
  {
    if (this.TIW.abOC == 0L) {
      return getContext().getString(c.g.top_story_mobile_net_warnning_short);
    }
    return getContext().getString(c.g.top_story_mobile_net_warnning, new Object[] { Util.getSizeMB(this.TIW.abOC, 100.0D) });
  }
  
  public String getNoNetTip()
  {
    return getContext().getString(c.g.video_net_disable_warnning);
  }
  
  public f.a getPauseReason()
  {
    return this.TLH;
  }
  
  public abstract i.b getVideoViewCallback();
  
  public FrameLayout getVideoViewParent()
  {
    return this.TLo;
  }
  
  public abstract void hNS();
  
  public abstract void hNT();
  
  public void hNU()
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.TLF.hNv()) });
    this.TLy.setVisibility(8);
    this.coverIv.setVisibility(8);
    this.TLp.setVisibility(8);
    this.TLx.setVisibility(8);
    this.TLo.setVisibility(0);
    this.TLo.setAlpha(1.0F);
  }
  
  public final void hNV()
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.TLF.hNv()) });
    this.coverIv.setVisibility(0);
    this.TLy.setVisibility(0);
    this.TLC.setVisibility(8);
    this.TLz.setVisibility(8);
    this.TLx.setVisibility(0);
    this.TLA.setVisibility(0);
    this.TLs.setVisibility(0);
    this.TLt.setVisibility(8);
    this.TLw.setVisibility(8);
    this.TLr.setVisibility(8);
  }
  
  public final void hNW()
  {
    nn(getNoNetTip(), this.TLn.fWt().getString(c.g.video_retry_play));
    getContext().getString(c.g.top_story_mobile_net_warnning, new Object[] { Util.getSizeMB(this.TIW.abOC, 100.0D) });
  }
  
  public void hNX() {}
  
  public void hNY() {}
  
  public final void hNZ()
  {
    this.TLH = f.a.TLJ;
    hNX();
    nn(getMobileNetTip(), getContext().getString(c.g.top_story_continue_play));
  }
  
  public final String hOa()
  {
    this.sessionId = UUID.randomUUID().toString();
    return this.sessionId;
  }
  
  public void hOb() {}
  
  public final void hOc()
  {
    this.TLC.setVisibility(0);
  }
  
  public void hOd() {}
  
  public void hOe() {}
  
  public boolean hOf()
  {
    return false;
  }
  
  protected void init()
  {
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    this.TLo = ((FrameLayout)findViewById(c.d.video_view_parent));
    this.TLp = ((TextView)findViewById(c.d.progress_tv));
    this.TLx = findViewById(c.d.tips_bg);
    this.TLy = findViewById(c.d.video_action_and_info_layout);
    this.TLz = findViewById(c.d.video_tip_and_loading_layout);
    this.TLA = findViewById(c.d.video_action_layout);
    this.TLB = findViewById(c.d.video_info_layout);
    this.TLq = findViewById(c.d.video_loading_progress_bar);
    this.coverIv = ((ImageView)findViewById(c.d.cover_iv));
    this.TLr = ((TextView)findViewById(c.d.video_size_tv));
    this.titleTv = ((TextView)findViewById(c.d.title_tv));
    this.TLs = ((ImageView)findViewById(c.d.cover_area_play_btn));
    this.TLt = ((ImageView)findViewById(c.d.cover_area_replay_btn));
    this.TLw = ((TextView)findViewById(c.d.replay_hint_tv));
    this.TLu = ((Button)findViewById(c.d.tip_cover_play));
    this.TLv = ((TextView)findViewById(c.d.tip_cover_warning));
    this.TLD = ((ImageView)findViewById(c.d.player_bottom_progress_bar_front));
    this.TLE = ((ImageView)findViewById(c.d.player_bottom_progress_bar_background));
    this.TLC = ((FrameLayout)findViewById(c.d.player_bottom_progress_root));
    this.TLG = ((TextView)findViewById(c.d.network_toast));
  }
  
  public final void nn(String paramString1, String paramString2)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", new Object[] { paramString1, paramString2 });
    this.coverIv.setVisibility(0);
    this.TLy.setVisibility(0);
    this.TLz.setVisibility(0);
    this.TLx.setVisibility(0);
    this.TLA.setVisibility(8);
    this.TLB.setVisibility(0);
    this.TLq.setVisibility(8);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.TLv.setText(paramString1);
      this.TLv.setVisibility(0);
    }
    while (!TextUtils.isEmpty(paramString2))
    {
      this.TLu.setText(paramString2);
      this.TLu.setVisibility(0);
      return;
      this.TLv.setVisibility(8);
    }
    this.TLu.setVisibility(8);
  }
  
  public final void seekTo(int paramInt)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.TLn.hNB().getCurrPosSec()) });
    Object localObject = this.TLn.hNB();
    if (((r)localObject).TNt != null) {
      ((r)localObject).TNt.X(paramInt, true);
    }
    localObject = this.TLn.hNx().TNp;
    if (localObject != null) {
      ((com.tencent.mm.plugin.topstory.a.b.b)localObject).TIG = 1L;
    }
  }
  
  protected void updateView()
  {
    this.coverIv.setImageDrawable(null);
    com.tencent.mm.modelimage.r.bKe().a(this.TIW.oeS, this.coverIv, TKP);
    if (this.TLG != null)
    {
      this.TLG.animate().cancel();
      this.TLG.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.f
 * JD-Core Version:    0.7.0.1
 */