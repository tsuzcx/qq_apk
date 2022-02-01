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
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.HashMap;
import java.util.UUID;

public abstract class f
  extends RelativeLayout
{
  public static c BKO;
  public dpa BIY;
  protected View BLA;
  public FrameLayout BLB;
  public ImageView BLC;
  public ImageView BLD;
  public a BLE;
  protected TextView BLF;
  public f.a BLG = f.a.BLH;
  public b BLm;
  protected FrameLayout BLn;
  public TextView BLo;
  protected View BLp;
  protected TextView BLq;
  protected ImageView BLr;
  protected ImageView BLs;
  protected Button BLt;
  protected TextView BLu;
  protected TextView BLv;
  protected View BLw;
  protected View BLx;
  protected View BLy;
  protected View BLz;
  protected ImageView oZd;
  public String sessionId = "";
  protected TextView titleTv;
  
  static
  {
    c.a locala = new c.a();
    locala.igk = true;
    locala.igj = true;
    BKO = locala.aJu();
  }
  
  public f(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.BLm = paramb;
    this.BLE = parama;
    init();
  }
  
  public final void a(dpa paramdpa, int paramInt)
  {
    ae.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", new Object[] { Integer.valueOf(paramInt) });
    this.BIY = paramdpa;
    updateView();
  }
  
  public boolean ap(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.BLm.ett();
    Object localObject2 = h.esv();
    int i = this.BLm.etu();
    if (!this.BLm.etd().isConnected())
    {
      this.BLG = f.a.BLJ;
      etE();
      ko(getNoNetTip(), getContext().getString(2131764699));
      this.BLm.eti().a(this, c(this.BIY));
      return false;
    }
    if ((!((String)localObject2).equals("wifi")) && (!((String)localObject2).equals(localObject1)))
    {
      if (!((String)localObject2).equals("wangka")) {
        break label704;
      }
      if ((i != 1) && (i != 2))
      {
        this.BLm.TG(1);
        if (this.BLF == null) {
          break label682;
        }
        this.BLF.setVisibility(0);
        this.BLF.setAlpha(1.0F);
        this.BLF.animate().alpha(0.0F).setDuration(3000L).start();
      }
    }
    this.BLm.aEp((String)localObject2);
    etH();
    this.BLG = f.a.BLH;
    ae.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
    this.BLx.setVisibility(0);
    this.BLz.setVisibility(8);
    this.BLw.setVisibility(8);
    this.BLB.setVisibility(8);
    this.BLy.setVisibility(0);
    this.BLA.setVisibility(8);
    this.BLp.setVisibility(0);
    this.BLp.setVisibility(0);
    this.BLp.setAlpha(0.0F);
    this.BLp.animate().setDuration(4000L).setInterpolator(new AccelerateInterpolator()).alpha(1.0F).start();
    this.oZd.setVisibility(0);
    this.BLo.setVisibility(8);
    this.BLn.setVisibility(0);
    this.BLn.setAlpha(0.0F);
    this.BLm.eti().a(this, c(this.BIY));
    localObject1 = this.BLm.eti();
    Object localObject3 = this.BLm;
    localObject2 = this.BIY;
    String str = this.sessionId;
    int j = this.BLE.etc();
    HashMap localHashMap = ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap();
    if (localHashMap.containsKey(((dpa)localObject2).udb)) {}
    for (i = ((Integer)localHashMap.get(((dpa)localObject2).udb)).intValue();; i = 0)
    {
      ae.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPlay, pos:%s, vid:%s videoProgress: %d", new Object[] { Integer.valueOf(j), ((dpa)localObject2).udb, Integer.valueOf(i) });
      if (((dpa)localObject2).HWs != null) {
        ae.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "video %s secondVideoInfo %d %d", new Object[] { ((dpa)localObject2).udb, Integer.valueOf(((dpa)localObject2).HWs.HVK), Integer.valueOf(((dpa)localObject2).HWs.HVL) });
      }
      if (((dpa)localObject2).HWB != null) {
        ((dpa)localObject2).HWB.dnq = false;
      }
      if (((r)localObject1).BJb != null)
      {
        if ((!((r)localObject1).BJb.tFc.equals(((dpa)localObject2).tFc)) || (paramBoolean2))
        {
          ((r)localObject1).BNq.stop();
          ((b)localObject3).ete().b(((b)localObject3).etg());
          ((b)localObject3).ete().euf();
        }
      }
      else
      {
        if (!bu.isNullOrNil(((dpa)localObject2).videoUrl)) {
          break label756;
        }
        ae.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", new Object[] { str, ((dpa)localObject2).udb, ((dpa)localObject2).title });
      }
      return true;
      label682:
      t.makeText(this.BLm.dkN(), 2131764483, 0).show();
      break;
      label704:
      if (i == 2) {
        break;
      }
      etG();
      this.BLm.eti().a(this, c(this.BIY));
      return false;
      localHashMap.put(((dpa)localObject2).udb, Integer.valueOf(0));
    }
    label756:
    ((b)localObject3).ete().a((dpa)localObject2, j, str);
    ((r)localObject1).BLm.ete().i((dpa)localObject2);
    ((r)localObject1).BNq.setLoop(false);
    ((r)localObject1).BNq.setVideoInfo((dpa)localObject2);
    ((r)localObject1).BNq.setMute(((b)localObject3).Pd());
    ((r)localObject1).BNq.setKeepScreenOn(true);
    if (i == 0) {
      ((r)localObject1).BNq.aEq(str);
    }
    for (;;)
    {
      ((r)localObject1).BNq.eui();
      ((r)localObject1).BJb = ((dpa)localObject2);
      ((r)localObject1).BNs = true;
      ((r)localObject1).BNt = false;
      break;
      localObject3 = ((r)localObject1).BNq;
      ((q)localObject3).sessionId = str;
      ((q)localObject3).C(i, true);
    }
  }
  
  public void bTP() {}
  
  public i.e c(dpa paramdpa)
  {
    return i.e.Flh;
  }
  
  public abstract void etA();
  
  public void etB()
  {
    ae.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.BLE.etc()) });
    this.BLx.setVisibility(8);
    this.oZd.setVisibility(8);
    this.BLo.setVisibility(8);
    this.BLw.setVisibility(8);
    this.BLn.setVisibility(0);
    this.BLn.setAlpha(1.0F);
  }
  
  public final void etC()
  {
    ae.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.BLE.etc()) });
    this.oZd.setVisibility(0);
    this.BLx.setVisibility(0);
    this.BLB.setVisibility(8);
    this.BLy.setVisibility(8);
    this.BLw.setVisibility(0);
    this.BLz.setVisibility(0);
    this.BLr.setVisibility(0);
    this.BLs.setVisibility(8);
    this.BLv.setVisibility(8);
    this.BLq.setVisibility(8);
  }
  
  public final void etD()
  {
    ko(getNoNetTip(), this.BLm.dkN().getString(2131764699));
    getContext().getString(2131764481, new Object[] { bu.a(this.BIY.HWo, 100.0D) });
  }
  
  public void etE() {}
  
  public void etF() {}
  
  public final void etG()
  {
    this.BLG = f.a.BLI;
    etE();
    ko(getMobileNetTip(), getContext().getString(2131764459));
  }
  
  public final String etH()
  {
    this.sessionId = UUID.randomUUID().toString();
    return this.sessionId;
  }
  
  public final void etI()
  {
    this.BLB.setVisibility(0);
  }
  
  public void etJ() {}
  
  public void etK() {}
  
  public boolean etL()
  {
    return false;
  }
  
  public abstract void etz();
  
  public abstract g getControlBar();
  
  public a getItemUIComponent()
  {
    return this.BLE;
  }
  
  protected abstract int getLayoutId();
  
  protected String getMobileNetTip()
  {
    if (this.BIY.HWo == 0L) {
      return getContext().getString(2131764482);
    }
    return getContext().getString(2131764481, new Object[] { bu.a(this.BIY.HWo, 100.0D) });
  }
  
  public String getNoNetTip()
  {
    return getContext().getString(2131764685);
  }
  
  public f.a getPauseReason()
  {
    return this.BLG;
  }
  
  public abstract i.b getVideoViewCallback();
  
  public FrameLayout getVideoViewParent()
  {
    return this.BLn;
  }
  
  protected void init()
  {
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    this.BLn = ((FrameLayout)findViewById(2131306412));
    this.BLo = ((TextView)findViewById(2131303532));
    this.BLw = findViewById(2131305889);
    this.BLx = findViewById(2131306311);
    this.BLy = findViewById(2131306402);
    this.BLz = findViewById(2131306312);
    this.BLA = findViewById(2131306349);
    this.BLp = findViewById(2131306353);
    this.oZd = ((ImageView)findViewById(2131298824));
    this.BLq = ((TextView)findViewById(2131306394));
    this.titleTv = ((TextView)findViewById(2131305948));
    this.BLr = ((ImageView)findViewById(2131298815));
    this.BLs = ((ImageView)findViewById(2131298816));
    this.BLv = ((TextView)findViewById(2131304079));
    this.BLt = ((Button)findViewById(2131305869));
    this.BLu = ((TextView)findViewById(2131305870));
    this.BLC = ((ImageView)findViewById(2131303297));
    this.BLD = ((ImageView)findViewById(2131303296));
    this.BLB = ((FrameLayout)findViewById(2131303298));
    this.BLF = ((TextView)findViewById(2131302710));
  }
  
  public final void ko(String paramString1, String paramString2)
  {
    ae.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", new Object[] { paramString1, paramString2 });
    this.oZd.setVisibility(0);
    this.BLx.setVisibility(0);
    this.BLy.setVisibility(0);
    this.BLw.setVisibility(0);
    this.BLz.setVisibility(8);
    this.BLA.setVisibility(0);
    this.BLp.setVisibility(8);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.BLu.setText(paramString1);
      this.BLu.setVisibility(0);
    }
    while (!TextUtils.isEmpty(paramString2))
    {
      this.BLt.setText(paramString2);
      this.BLt.setVisibility(0);
      return;
      this.BLu.setVisibility(8);
    }
    this.BLt.setVisibility(8);
  }
  
  public final void seekTo(int paramInt)
  {
    ae.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.BLm.eti().getCurrPosSec()) });
    Object localObject = this.BLm.eti();
    if (((r)localObject).BNq != null) {
      ((r)localObject).BNq.C(paramInt, true);
    }
    localObject = this.BLm.ete().BNm;
    if (localObject != null) {
      ((com.tencent.mm.plugin.topstory.a.b.b)localObject).BII = 1L;
    }
  }
  
  protected void updateView()
  {
    this.oZd.setImageDrawable(null);
    com.tencent.mm.av.q.aJb().a(this.BIY.HWg, this.oZd, BKO);
    if (this.BLF != null)
    {
      this.BLF.animate().cancel();
      this.BLF.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.f
 * JD-Core Version:    0.7.0.1
 */