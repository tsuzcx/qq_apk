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
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.HashMap;
import java.util.UUID;

public abstract class f
  extends RelativeLayout
{
  public static c yNO;
  protected ImageView nMg;
  public String sessionId = "";
  protected TextView titleTv;
  public ddb yLU;
  protected View yOA;
  public FrameLayout yOB;
  public ImageView yOC;
  public ImageView yOD;
  public a yOE;
  protected TextView yOF;
  public f.a yOG = f.a.yOH;
  public b yOm;
  protected FrameLayout yOn;
  public TextView yOo;
  protected View yOp;
  protected TextView yOq;
  protected ImageView yOr;
  protected ImageView yOs;
  protected Button yOt;
  protected TextView yOu;
  protected TextView yOv;
  protected View yOw;
  protected View yOx;
  protected View yOy;
  protected View yOz;
  
  static
  {
    c.a locala = new c.a();
    locala.hjU = true;
    locala.hjT = true;
    yNO = locala.azc();
  }
  
  public f(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.yOm = paramb;
    this.yOE = parama;
    init();
  }
  
  public final void a(ddb paramddb, int paramInt)
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", new Object[] { Integer.valueOf(paramInt) });
    this.yLU = paramddb;
    cE();
  }
  
  public boolean aj(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.yOm.dOU();
    Object localObject2 = h.dNX();
    int i = this.yOm.dOV();
    if (!this.yOm.dOE().isConnected())
    {
      this.yOG = f.a.yOJ;
      dPf();
      jv(getNoNetTip(), getContext().getString(2131764699));
      this.yOm.dOJ().a(this, c(this.yLU));
      return false;
    }
    if ((!((String)localObject2).equals("wifi")) && (!((String)localObject2).equals(localObject1)))
    {
      if (!((String)localObject2).equals("wangka")) {
        break label704;
      }
      if ((i != 1) && (i != 2))
      {
        this.yOm.Pj(1);
        if (this.yOF == null) {
          break label682;
        }
        this.yOF.setVisibility(0);
        this.yOF.setAlpha(1.0F);
        this.yOF.animate().alpha(0.0F).setDuration(3000L).start();
      }
    }
    this.yOm.asI((String)localObject2);
    dPi();
    this.yOG = f.a.yOH;
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
    this.yOx.setVisibility(0);
    this.yOz.setVisibility(8);
    this.yOw.setVisibility(8);
    this.yOB.setVisibility(8);
    this.yOy.setVisibility(0);
    this.yOA.setVisibility(8);
    this.yOp.setVisibility(0);
    this.yOp.setVisibility(0);
    this.yOp.setAlpha(0.0F);
    this.yOp.animate().setDuration(4000L).setInterpolator(new AccelerateInterpolator()).alpha(1.0F).start();
    this.nMg.setVisibility(0);
    this.yOo.setVisibility(8);
    this.yOn.setVisibility(0);
    this.yOn.setAlpha(0.0F);
    this.yOm.dOJ().a(this, c(this.yLU));
    localObject1 = this.yOm.dOJ();
    Object localObject3 = this.yOm;
    localObject2 = this.yLU;
    String str = this.sessionId;
    int j = this.yOE.dOD();
    HashMap localHashMap = ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap();
    if (localHashMap.containsKey(((ddb)localObject2).rNP)) {}
    for (i = ((Integer)localHashMap.get(((ddb)localObject2).rNP)).intValue();; i = 0)
    {
      ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPlay, pos:%s, vid:%s videoProgress: %d", new Object[] { Integer.valueOf(j), ((ddb)localObject2).rNP, Integer.valueOf(i) });
      if (((ddb)localObject2).EuY != null) {
        ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "video %s secondVideoInfo %d %d", new Object[] { ((ddb)localObject2).rNP, Integer.valueOf(((ddb)localObject2).EuY.Euq), Integer.valueOf(((ddb)localObject2).EuY.Eur) });
      }
      if (((ddb)localObject2).Evh != null) {
        ((ddb)localObject2).Evh.ddw = false;
      }
      if (((r)localObject1).yLY != null)
      {
        if ((!((r)localObject1).yLY.roQ.equals(((ddb)localObject2).roQ)) || (paramBoolean2))
        {
          ((r)localObject1).yQq.stop();
          ((b)localObject3).dOF().b(((b)localObject3).dOH());
          ((b)localObject3).dOF().dPI();
        }
      }
      else
      {
        if (!bt.isNullOrNil(((ddb)localObject2).videoUrl)) {
          break label756;
        }
        ad.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", new Object[] { str, ((ddb)localObject2).rNP, ((ddb)localObject2).title });
      }
      return true;
      label682:
      t.makeText(this.yOm.cKW(), 2131764483, 0).show();
      break;
      label704:
      if (i == 2) {
        break;
      }
      dPh();
      this.yOm.dOJ().a(this, c(this.yLU));
      return false;
      localHashMap.put(((ddb)localObject2).rNP, Integer.valueOf(0));
    }
    label756:
    ((b)localObject3).dOF().a((ddb)localObject2, j, str);
    ((r)localObject1).yOm.dOF().i((ddb)localObject2);
    ((r)localObject1).yQq.setLoop(false);
    ((r)localObject1).yQq.setVideoInfo((ddb)localObject2);
    ((r)localObject1).yQq.setMute(((b)localObject3).Ny());
    ((r)localObject1).yQq.setKeepScreenOn(true);
    if (i == 0) {
      ((r)localObject1).yQq.asJ(str);
    }
    for (;;)
    {
      ((r)localObject1).yQq.dPL();
      ((r)localObject1).yLY = ((ddb)localObject2);
      ((r)localObject1).yQs = true;
      ((r)localObject1).yQt = false;
      break;
      localObject3 = ((r)localObject1).yQq;
      ((q)localObject3).sessionId = str;
      ((q)localObject3).C(i, true);
    }
  }
  
  public void bGO() {}
  
  public h.e c(ddb paramddb)
  {
    return h.e.BVq;
  }
  
  protected void cE()
  {
    this.nMg.setImageDrawable(null);
    com.tencent.mm.aw.o.ayJ().a(this.yLU.EuM, this.nMg, yNO);
    if (this.yOF != null)
    {
      this.yOF.animate().cancel();
      this.yOF.setVisibility(8);
    }
  }
  
  public abstract void dPa();
  
  public abstract void dPb();
  
  public void dPc()
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.yOE.dOD()) });
    this.yOx.setVisibility(8);
    this.nMg.setVisibility(8);
    this.yOo.setVisibility(8);
    this.yOw.setVisibility(8);
    this.yOn.setVisibility(0);
    this.yOn.setAlpha(1.0F);
  }
  
  public final void dPd()
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.yOE.dOD()) });
    this.nMg.setVisibility(0);
    this.yOx.setVisibility(0);
    this.yOB.setVisibility(8);
    this.yOy.setVisibility(8);
    this.yOw.setVisibility(0);
    this.yOz.setVisibility(0);
    this.yOr.setVisibility(0);
    this.yOs.setVisibility(8);
    this.yOv.setVisibility(8);
    this.yOq.setVisibility(8);
  }
  
  public final void dPe()
  {
    jv(getNoNetTip(), this.yOm.cKW().getString(2131764699));
    getContext().getString(2131764481, new Object[] { bt.a(this.yLU.EuU, 100.0D) });
  }
  
  public void dPf() {}
  
  public void dPg() {}
  
  public final void dPh()
  {
    this.yOG = f.a.yOI;
    dPf();
    jv(getMobileNetTip(), getContext().getString(2131764459));
  }
  
  public final String dPi()
  {
    this.sessionId = UUID.randomUUID().toString();
    return this.sessionId;
  }
  
  public final void dPj()
  {
    this.yOB.setVisibility(0);
  }
  
  public void dPk() {}
  
  public void dPl() {}
  
  public boolean dPm()
  {
    return false;
  }
  
  public abstract g getControlBar();
  
  public a getItemUIComponent()
  {
    return this.yOE;
  }
  
  protected abstract int getLayoutId();
  
  protected String getMobileNetTip()
  {
    if (this.yLU.EuU == 0L) {
      return getContext().getString(2131764482);
    }
    return getContext().getString(2131764481, new Object[] { bt.a(this.yLU.EuU, 100.0D) });
  }
  
  public String getNoNetTip()
  {
    return getContext().getString(2131764685);
  }
  
  public f.a getPauseReason()
  {
    return this.yOG;
  }
  
  public abstract h.b getVideoViewCallback();
  
  public FrameLayout getVideoViewParent()
  {
    return this.yOn;
  }
  
  protected void init()
  {
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    this.yOn = ((FrameLayout)findViewById(2131306412));
    this.yOo = ((TextView)findViewById(2131303532));
    this.yOw = findViewById(2131305889);
    this.yOx = findViewById(2131306311);
    this.yOy = findViewById(2131306402);
    this.yOz = findViewById(2131306312);
    this.yOA = findViewById(2131306349);
    this.yOp = findViewById(2131306353);
    this.nMg = ((ImageView)findViewById(2131298824));
    this.yOq = ((TextView)findViewById(2131306394));
    this.titleTv = ((TextView)findViewById(2131305948));
    this.yOr = ((ImageView)findViewById(2131298815));
    this.yOs = ((ImageView)findViewById(2131298816));
    this.yOv = ((TextView)findViewById(2131304079));
    this.yOt = ((Button)findViewById(2131305869));
    this.yOu = ((TextView)findViewById(2131305870));
    this.yOC = ((ImageView)findViewById(2131303297));
    this.yOD = ((ImageView)findViewById(2131303296));
    this.yOB = ((FrameLayout)findViewById(2131303298));
    this.yOF = ((TextView)findViewById(2131302710));
  }
  
  public final void jv(String paramString1, String paramString2)
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", new Object[] { paramString1, paramString2 });
    this.nMg.setVisibility(0);
    this.yOx.setVisibility(0);
    this.yOy.setVisibility(0);
    this.yOw.setVisibility(0);
    this.yOz.setVisibility(8);
    this.yOA.setVisibility(0);
    this.yOp.setVisibility(8);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.yOu.setText(paramString1);
      this.yOu.setVisibility(0);
    }
    while (!TextUtils.isEmpty(paramString2))
    {
      this.yOt.setText(paramString2);
      this.yOt.setVisibility(0);
      return;
      this.yOu.setVisibility(8);
    }
    this.yOt.setVisibility(8);
  }
  
  public final void seekTo(int paramInt)
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.yOm.dOJ().getCurrPosSec()) });
    Object localObject = this.yOm.dOJ();
    if (((r)localObject).yQq != null) {
      ((r)localObject).yQq.C(paramInt, true);
    }
    localObject = this.yOm.dOF().yQm;
    if (localObject != null) {
      ((com.tencent.mm.plugin.topstory.a.b.b)localObject).yLE = 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.f
 * JD-Core Version:    0.7.0.1
 */