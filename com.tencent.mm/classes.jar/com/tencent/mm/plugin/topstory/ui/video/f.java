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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.HashMap;
import java.util.UUID;

public abstract class f
  extends RelativeLayout
{
  public static c AbF;
  public b Acd;
  protected FrameLayout Ace;
  public TextView Acf;
  protected View Acg;
  protected TextView Ach;
  protected ImageView Aci;
  protected ImageView Acj;
  protected Button Ack;
  protected TextView Acl;
  protected TextView Acm;
  protected View Acn;
  protected View Aco;
  protected View Acp;
  protected View Acq;
  protected View Acr;
  public FrameLayout Acs;
  public ImageView Act;
  public ImageView Acu;
  public a Acv;
  protected TextView Acw;
  public a Acx = a.Acy;
  protected ImageView opg;
  public String sessionId = "";
  protected TextView titleTv;
  public dio zZN;
  
  static
  {
    c.a locala = new c.a();
    locala.hKx = true;
    locala.hKw = true;
    AbF = locala.aFT();
  }
  
  public f(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.Acd = paramb;
    this.Acv = parama;
    init();
  }
  
  public final void a(dio paramdio, int paramInt)
  {
    ac.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", new Object[] { Integer.valueOf(paramInt) });
    this.zZN = paramdio;
    cL();
  }
  
  public boolean am(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.Acd.edu();
    Object localObject2 = h.ecx();
    int i = this.Acd.edv();
    if (!this.Acd.ede().isConnected())
    {
      this.Acx = a.AcA;
      edF();
      jT(getNoNetTip(), getContext().getString(2131764699));
      this.Acd.edj().a(this, c(this.zZN));
      return false;
    }
    if ((!((String)localObject2).equals("wifi")) && (!((String)localObject2).equals(localObject1)))
    {
      if (!((String)localObject2).equals("wangka")) {
        break label704;
      }
      if ((i != 1) && (i != 2))
      {
        this.Acd.Rp(1);
        if (this.Acw == null) {
          break label682;
        }
        this.Acw.setVisibility(0);
        this.Acw.setAlpha(1.0F);
        this.Acw.animate().alpha(0.0F).setDuration(3000L).start();
      }
    }
    this.Acd.axR((String)localObject2);
    edI();
    this.Acx = a.Acy;
    ac.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
    this.Aco.setVisibility(0);
    this.Acq.setVisibility(8);
    this.Acn.setVisibility(8);
    this.Acs.setVisibility(8);
    this.Acp.setVisibility(0);
    this.Acr.setVisibility(8);
    this.Acg.setVisibility(0);
    this.Acg.setVisibility(0);
    this.Acg.setAlpha(0.0F);
    this.Acg.animate().setDuration(4000L).setInterpolator(new AccelerateInterpolator()).alpha(1.0F).start();
    this.opg.setVisibility(0);
    this.Acf.setVisibility(8);
    this.Ace.setVisibility(0);
    this.Ace.setAlpha(0.0F);
    this.Acd.edj().a(this, c(this.zZN));
    localObject1 = this.Acd.edj();
    Object localObject3 = this.Acd;
    localObject2 = this.zZN;
    String str = this.sessionId;
    int j = this.Acv.edd();
    HashMap localHashMap = ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getVideoPlayProgressMap();
    if (localHashMap.containsKey(((dio)localObject2).sVF)) {}
    for (i = ((Integer)localHashMap.get(((dio)localObject2).sVF)).intValue();; i = 0)
    {
      ac.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPlay, pos:%s, vid:%s videoProgress: %d", new Object[] { Integer.valueOf(j), ((dio)localObject2).sVF, Integer.valueOf(i) });
      if (((dio)localObject2).FRZ != null) {
        ac.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "video %s secondVideoInfo %d %d", new Object[] { ((dio)localObject2).sVF, Integer.valueOf(((dio)localObject2).FRZ.FRr), Integer.valueOf(((dio)localObject2).FRZ.FRs) });
      }
      if (((dio)localObject2).FSi != null) {
        ((dio)localObject2).FSi.daU = false;
      }
      if (((r)localObject1).zZQ != null)
      {
        if ((!((r)localObject1).zZQ.sxK.equals(((dio)localObject2).sxK)) || (paramBoolean2))
        {
          ((r)localObject1).Aeg.stop();
          ((b)localObject3).edf().b(((b)localObject3).edh());
          ((b)localObject3).edf().eeh();
        }
      }
      else
      {
        if (!bs.isNullOrNil(((dio)localObject2).videoUrl)) {
          break label756;
        }
        ac.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", new Object[] { str, ((dio)localObject2).sVF, ((dio)localObject2).title });
      }
      return true;
      label682:
      t.makeText(this.Acd.cYC(), 2131764483, 0).show();
      break;
      label704:
      if (i == 2) {
        break;
      }
      edH();
      this.Acd.edj().a(this, c(this.zZN));
      return false;
      localHashMap.put(((dio)localObject2).sVF, Integer.valueOf(0));
    }
    label756:
    ((b)localObject3).edf().a((dio)localObject2, j, str);
    ((r)localObject1).Acd.edf().i((dio)localObject2);
    ((r)localObject1).Aeg.setLoop(false);
    ((r)localObject1).Aeg.setVideoInfo((dio)localObject2);
    ((r)localObject1).Aeg.setMute(((b)localObject3).Nw());
    ((r)localObject1).Aeg.setKeepScreenOn(true);
    if (i == 0) {
      ((r)localObject1).Aeg.axS(str);
    }
    for (;;)
    {
      ((r)localObject1).Aeg.eek();
      ((r)localObject1).zZQ = ((dio)localObject2);
      ((r)localObject1).Aei = true;
      ((r)localObject1).Aej = false;
      break;
      localObject3 = ((r)localObject1).Aeg;
      ((q)localObject3).sessionId = str;
      ((q)localObject3).C(i, true);
    }
  }
  
  public void bOb() {}
  
  public h.e c(dio paramdio)
  {
    return h.e.DnH;
  }
  
  protected void cL()
  {
    this.opg.setImageDrawable(null);
    com.tencent.mm.av.o.aFB().a(this.zZN.FRN, this.opg, AbF);
    if (this.Acw != null)
    {
      this.Acw.animate().cancel();
      this.Acw.setVisibility(8);
    }
  }
  
  public abstract void edA();
  
  public abstract void edB();
  
  public void edC()
  {
    ac.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.Acv.edd()) });
    this.Aco.setVisibility(8);
    this.opg.setVisibility(8);
    this.Acf.setVisibility(8);
    this.Acn.setVisibility(8);
    this.Ace.setVisibility(0);
    this.Ace.setAlpha(1.0F);
  }
  
  public final void edD()
  {
    ac.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.Acv.edd()) });
    this.opg.setVisibility(0);
    this.Aco.setVisibility(0);
    this.Acs.setVisibility(8);
    this.Acp.setVisibility(8);
    this.Acn.setVisibility(0);
    this.Acq.setVisibility(0);
    this.Aci.setVisibility(0);
    this.Acj.setVisibility(8);
    this.Acm.setVisibility(8);
    this.Ach.setVisibility(8);
  }
  
  public final void edE()
  {
    jT(getNoNetTip(), this.Acd.cYC().getString(2131764699));
    getContext().getString(2131764481, new Object[] { bs.a(this.zZN.FRV, 100.0D) });
  }
  
  public void edF() {}
  
  public void edG() {}
  
  public final void edH()
  {
    this.Acx = a.Acz;
    edF();
    jT(getMobileNetTip(), getContext().getString(2131764459));
  }
  
  public final String edI()
  {
    this.sessionId = UUID.randomUUID().toString();
    return this.sessionId;
  }
  
  public final void edJ()
  {
    this.Acs.setVisibility(0);
  }
  
  public void edK() {}
  
  public void edL() {}
  
  public boolean edM()
  {
    return false;
  }
  
  public abstract g getControlBar();
  
  public a getItemUIComponent()
  {
    return this.Acv;
  }
  
  protected abstract int getLayoutId();
  
  protected String getMobileNetTip()
  {
    if (this.zZN.FRV == 0L) {
      return getContext().getString(2131764482);
    }
    return getContext().getString(2131764481, new Object[] { bs.a(this.zZN.FRV, 100.0D) });
  }
  
  public String getNoNetTip()
  {
    return getContext().getString(2131764685);
  }
  
  public a getPauseReason()
  {
    return this.Acx;
  }
  
  public abstract h.b getVideoViewCallback();
  
  public FrameLayout getVideoViewParent()
  {
    return this.Ace;
  }
  
  protected void init()
  {
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    this.Ace = ((FrameLayout)findViewById(2131306412));
    this.Acf = ((TextView)findViewById(2131303532));
    this.Acn = findViewById(2131305889);
    this.Aco = findViewById(2131306311);
    this.Acp = findViewById(2131306402);
    this.Acq = findViewById(2131306312);
    this.Acr = findViewById(2131306349);
    this.Acg = findViewById(2131306353);
    this.opg = ((ImageView)findViewById(2131298824));
    this.Ach = ((TextView)findViewById(2131306394));
    this.titleTv = ((TextView)findViewById(2131305948));
    this.Aci = ((ImageView)findViewById(2131298815));
    this.Acj = ((ImageView)findViewById(2131298816));
    this.Acm = ((TextView)findViewById(2131304079));
    this.Ack = ((Button)findViewById(2131305869));
    this.Acl = ((TextView)findViewById(2131305870));
    this.Act = ((ImageView)findViewById(2131303297));
    this.Acu = ((ImageView)findViewById(2131303296));
    this.Acs = ((FrameLayout)findViewById(2131303298));
    this.Acw = ((TextView)findViewById(2131302710));
  }
  
  public final void jT(String paramString1, String paramString2)
  {
    ac.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", new Object[] { paramString1, paramString2 });
    this.opg.setVisibility(0);
    this.Aco.setVisibility(0);
    this.Acp.setVisibility(0);
    this.Acn.setVisibility(0);
    this.Acq.setVisibility(8);
    this.Acr.setVisibility(0);
    this.Acg.setVisibility(8);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.Acl.setText(paramString1);
      this.Acl.setVisibility(0);
    }
    while (!TextUtils.isEmpty(paramString2))
    {
      this.Ack.setText(paramString2);
      this.Ack.setVisibility(0);
      return;
      this.Acl.setVisibility(8);
    }
    this.Ack.setVisibility(8);
  }
  
  public final void seekTo(int paramInt)
  {
    ac.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Acd.edj().getCurrPosSec()) });
    Object localObject = this.Acd.edj();
    if (((r)localObject).Aeg != null) {
      ((r)localObject).Aeg.C(paramInt, true);
    }
    localObject = this.Acd.edf().Aec;
    if (localObject != null) {
      ((com.tencent.mm.plugin.topstory.a.b.b)localObject).zZx = 1L;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(126071);
      Acy = new a("UNKNOWN", 0);
      Acz = new a("MOBILE_NET", 1);
      AcA = new a("NO_NET", 2);
      AcB = new a[] { Acy, Acz, AcA };
      AppMethodBeat.o(126071);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.f
 * JD-Core Version:    0.7.0.1
 */