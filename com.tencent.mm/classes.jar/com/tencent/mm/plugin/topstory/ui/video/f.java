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
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.HashMap;
import java.util.UUID;

public abstract class f
  extends RelativeLayout
{
  public static c Btq;
  public dod Brz;
  public b BtO;
  protected FrameLayout BtP;
  public TextView BtQ;
  protected View BtR;
  protected TextView BtS;
  protected ImageView BtT;
  protected ImageView BtU;
  protected Button BtV;
  protected TextView BtW;
  protected TextView BtX;
  protected View BtY;
  protected View BtZ;
  protected View Bua;
  protected View Bub;
  protected View Buc;
  public FrameLayout Bud;
  public ImageView Bue;
  public ImageView Buf;
  public a Bug;
  protected TextView Buh;
  public f.a Bui = f.a.Buj;
  protected ImageView oSB;
  public String sessionId = "";
  protected TextView titleTv;
  
  static
  {
    c.a locala = new c.a();
    locala.idr = true;
    locala.idq = true;
    Btq = locala.aJc();
  }
  
  public f(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.BtO = paramb;
    this.Bug = parama;
    init();
  }
  
  public final void a(dod paramdod, int paramInt)
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", new Object[] { Integer.valueOf(paramInt) });
    this.Brz = paramdod;
    updateView();
  }
  
  public boolean aq(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.BtO.epM();
    Object localObject2 = h.eoO();
    int i = this.BtO.epN();
    if (!this.BtO.epw().isConnected())
    {
      this.Bui = f.a.Bul;
      epX();
      ki(getNoNetTip(), getContext().getString(2131764699));
      this.BtO.epB().a(this, c(this.Brz));
      return false;
    }
    if ((!((String)localObject2).equals("wifi")) && (!((String)localObject2).equals(localObject1)))
    {
      if (!((String)localObject2).equals("wangka")) {
        break label704;
      }
      if ((i != 1) && (i != 2))
      {
        this.BtO.SZ(1);
        if (this.Buh == null) {
          break label682;
        }
        this.Buh.setVisibility(0);
        this.Buh.setAlpha(1.0F);
        this.Buh.animate().alpha(0.0F).setDuration(3000L).start();
      }
    }
    this.BtO.aCW((String)localObject2);
    eqa();
    this.Bui = f.a.Buj;
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
    this.BtZ.setVisibility(0);
    this.Bub.setVisibility(8);
    this.BtY.setVisibility(8);
    this.Bud.setVisibility(8);
    this.Bua.setVisibility(0);
    this.Buc.setVisibility(8);
    this.BtR.setVisibility(0);
    this.BtR.setVisibility(0);
    this.BtR.setAlpha(0.0F);
    this.BtR.animate().setDuration(4000L).setInterpolator(new AccelerateInterpolator()).alpha(1.0F).start();
    this.oSB.setVisibility(0);
    this.BtQ.setVisibility(8);
    this.BtP.setVisibility(0);
    this.BtP.setAlpha(0.0F);
    this.BtO.epB().a(this, c(this.Brz));
    localObject1 = this.BtO.epB();
    Object localObject3 = this.BtO;
    localObject2 = this.Brz;
    String str = this.sessionId;
    int j = this.Bug.epv();
    HashMap localHashMap = ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap();
    if (localHashMap.containsKey(((dod)localObject2).tSk)) {}
    for (i = ((Integer)localHashMap.get(((dod)localObject2).tSk)).intValue();; i = 0)
    {
      ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPlay, pos:%s, vid:%s videoProgress: %d", new Object[] { Integer.valueOf(j), ((dod)localObject2).tSk, Integer.valueOf(i) });
      if (((dod)localObject2).HCF != null) {
        ad.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "video %s secondVideoInfo %d %d", new Object[] { ((dod)localObject2).tSk, Integer.valueOf(((dod)localObject2).HCF.HBX), Integer.valueOf(((dod)localObject2).HCF.HBY) });
      }
      if (((dod)localObject2).HCO != null) {
        ((dod)localObject2).HCO.dmo = false;
      }
      if (((r)localObject1).BrC != null)
      {
        if ((!((r)localObject1).BrC.tul.equals(((dod)localObject2).tul)) || (paramBoolean2))
        {
          ((r)localObject1).BvS.stop();
          ((b)localObject3).epx().b(((b)localObject3).epz());
          ((b)localObject3).epx().eqy();
        }
      }
      else
      {
        if (!bt.isNullOrNil(((dod)localObject2).videoUrl)) {
          break label756;
        }
        ad.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", new Object[] { str, ((dod)localObject2).tSk, ((dod)localObject2).title });
      }
      return true;
      label682:
      t.makeText(this.BtO.dhO(), 2131764483, 0).show();
      break;
      label704:
      if (i == 2) {
        break;
      }
      epZ();
      this.BtO.epB().a(this, c(this.Brz));
      return false;
      localHashMap.put(((dod)localObject2).tSk, Integer.valueOf(0));
    }
    label756:
    ((b)localObject3).epx().a((dod)localObject2, j, str);
    ((r)localObject1).BtO.epx().i((dod)localObject2);
    ((r)localObject1).BvS.setLoop(false);
    ((r)localObject1).BvS.setVideoInfo((dod)localObject2);
    ((r)localObject1).BvS.setMute(((b)localObject3).Pf());
    ((r)localObject1).BvS.setKeepScreenOn(true);
    if (i == 0) {
      ((r)localObject1).BvS.aCX(str);
    }
    for (;;)
    {
      ((r)localObject1).BvS.eqB();
      ((r)localObject1).BrC = ((dod)localObject2);
      ((r)localObject1).BvU = true;
      ((r)localObject1).BvV = false;
      break;
      localObject3 = ((r)localObject1).BvS;
      ((q)localObject3).sessionId = str;
      ((q)localObject3).C(i, true);
    }
  }
  
  public void bSC() {}
  
  public i.e c(dod paramdod)
  {
    return i.e.ESM;
  }
  
  public abstract void epS();
  
  public abstract void epT();
  
  public void epU()
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.Bug.epv()) });
    this.BtZ.setVisibility(8);
    this.oSB.setVisibility(8);
    this.BtQ.setVisibility(8);
    this.BtY.setVisibility(8);
    this.BtP.setVisibility(0);
    this.BtP.setAlpha(1.0F);
  }
  
  public final void epV()
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.Bug.epv()) });
    this.oSB.setVisibility(0);
    this.BtZ.setVisibility(0);
    this.Bud.setVisibility(8);
    this.Bua.setVisibility(8);
    this.BtY.setVisibility(0);
    this.Bub.setVisibility(0);
    this.BtT.setVisibility(0);
    this.BtU.setVisibility(8);
    this.BtX.setVisibility(8);
    this.BtS.setVisibility(8);
  }
  
  public final void epW()
  {
    ki(getNoNetTip(), this.BtO.dhO().getString(2131764699));
    getContext().getString(2131764481, new Object[] { bt.a(this.Brz.HCB, 100.0D) });
  }
  
  public void epX() {}
  
  public void epY() {}
  
  public final void epZ()
  {
    this.Bui = f.a.Buk;
    epX();
    ki(getMobileNetTip(), getContext().getString(2131764459));
  }
  
  public final String eqa()
  {
    this.sessionId = UUID.randomUUID().toString();
    return this.sessionId;
  }
  
  public final void eqb()
  {
    this.Bud.setVisibility(0);
  }
  
  public void eqc() {}
  
  public void eqd() {}
  
  public boolean eqe()
  {
    return false;
  }
  
  public abstract g getControlBar();
  
  public a getItemUIComponent()
  {
    return this.Bug;
  }
  
  protected abstract int getLayoutId();
  
  protected String getMobileNetTip()
  {
    if (this.Brz.HCB == 0L) {
      return getContext().getString(2131764482);
    }
    return getContext().getString(2131764481, new Object[] { bt.a(this.Brz.HCB, 100.0D) });
  }
  
  public String getNoNetTip()
  {
    return getContext().getString(2131764685);
  }
  
  public f.a getPauseReason()
  {
    return this.Bui;
  }
  
  public abstract i.b getVideoViewCallback();
  
  public FrameLayout getVideoViewParent()
  {
    return this.BtP;
  }
  
  protected void init()
  {
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    this.BtP = ((FrameLayout)findViewById(2131306412));
    this.BtQ = ((TextView)findViewById(2131303532));
    this.BtY = findViewById(2131305889);
    this.BtZ = findViewById(2131306311);
    this.Bua = findViewById(2131306402);
    this.Bub = findViewById(2131306312);
    this.Buc = findViewById(2131306349);
    this.BtR = findViewById(2131306353);
    this.oSB = ((ImageView)findViewById(2131298824));
    this.BtS = ((TextView)findViewById(2131306394));
    this.titleTv = ((TextView)findViewById(2131305948));
    this.BtT = ((ImageView)findViewById(2131298815));
    this.BtU = ((ImageView)findViewById(2131298816));
    this.BtX = ((TextView)findViewById(2131304079));
    this.BtV = ((Button)findViewById(2131305869));
    this.BtW = ((TextView)findViewById(2131305870));
    this.Bue = ((ImageView)findViewById(2131303297));
    this.Buf = ((ImageView)findViewById(2131303296));
    this.Bud = ((FrameLayout)findViewById(2131303298));
    this.Buh = ((TextView)findViewById(2131302710));
  }
  
  public final void ki(String paramString1, String paramString2)
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", new Object[] { paramString1, paramString2 });
    this.oSB.setVisibility(0);
    this.BtZ.setVisibility(0);
    this.Bua.setVisibility(0);
    this.BtY.setVisibility(0);
    this.Bub.setVisibility(8);
    this.Buc.setVisibility(0);
    this.BtR.setVisibility(8);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.BtW.setText(paramString1);
      this.BtW.setVisibility(0);
    }
    while (!TextUtils.isEmpty(paramString2))
    {
      this.BtV.setText(paramString2);
      this.BtV.setVisibility(0);
      return;
      this.BtW.setVisibility(8);
    }
    this.BtV.setVisibility(8);
  }
  
  public final void seekTo(int paramInt)
  {
    ad.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.BtO.epB().getCurrPosSec()) });
    Object localObject = this.BtO.epB();
    if (((r)localObject).BvS != null) {
      ((r)localObject).BvS.C(paramInt, true);
    }
    localObject = this.BtO.epx().BvO;
    if (localObject != null) {
      ((com.tencent.mm.plugin.topstory.a.b.b)localObject).Brj = 1L;
    }
  }
  
  protected void updateView()
  {
    this.oSB.setImageDrawable(null);
    com.tencent.mm.aw.q.aIJ().a(this.Brz.HCt, this.oSB, Btq);
    if (this.Buh != null)
    {
      this.Buh.animate().cancel();
      this.Buh.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.f
 * JD-Core Version:    0.7.0.1
 */