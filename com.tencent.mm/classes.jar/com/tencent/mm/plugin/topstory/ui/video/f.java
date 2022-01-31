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
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import java.util.HashMap;
import java.util.UUID;

public abstract class f
  extends RelativeLayout
{
  public static c thj;
  public String cpW = "";
  protected ImageView kha;
  public ckx tfm;
  public b thM;
  protected FrameLayout thN;
  public TextView thO;
  protected View thP;
  protected TextView thQ;
  protected ImageView thR;
  protected ImageView thS;
  protected Button thT;
  protected TextView thU;
  protected TextView thV;
  protected View thW;
  protected View thX;
  protected View thY;
  protected View thZ;
  protected View tia;
  public FrameLayout tib;
  public ImageView tic;
  public ImageView tie;
  public a tif;
  protected TextView tig;
  public f.a tih = f.a.tii;
  protected TextView titleTv;
  
  static
  {
    c.a locala = new c.a();
    locala.eNM = true;
    locala.eNL = true;
    thj = locala.ahY();
  }
  
  public f(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.thM = paramb;
    this.tif = parama;
    init();
  }
  
  public boolean Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.thM.cJt();
    Object localObject2 = com.tencent.mm.plugin.topstory.a.g.cIA();
    int i = this.thM.cJu();
    if (!this.thM.cJc().isConnected())
    {
      this.tih = f.a.tik;
      cJE();
      gT(getNoNetTip(), getContext().getString(2131304536));
      this.thM.cJh().a(this, c(this.tfm));
      return false;
    }
    if ((!((String)localObject2).equals("wifi")) && (!((String)localObject2).equals(localObject1)))
    {
      if (!((String)localObject2).equals("wangka")) {
        break label630;
      }
      if ((i != 1) && (i != 2))
      {
        this.thM.GB(1);
        if (this.tig == null) {
          break label608;
        }
        this.tig.setVisibility(0);
        this.tig.setAlpha(1.0F);
        this.tig.animate().alpha(0.0F).setDuration(3000L).start();
      }
    }
    this.thM.aeo((String)localObject2);
    cJH();
    this.tih = f.a.tii;
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
    this.thX.setVisibility(0);
    this.thZ.setVisibility(8);
    this.thW.setVisibility(8);
    this.tib.setVisibility(8);
    this.thY.setVisibility(0);
    this.tia.setVisibility(8);
    this.thP.setVisibility(0);
    this.thP.setVisibility(0);
    this.thP.setAlpha(0.0F);
    this.thP.animate().setDuration(4000L).setInterpolator(new AccelerateInterpolator()).alpha(1.0F).start();
    this.kha.setVisibility(0);
    this.thO.setVisibility(8);
    this.thN.setVisibility(0);
    this.thN.setAlpha(0.0F);
    this.thM.cJh().a(this, c(this.tfm));
    localObject1 = this.thM.cJh();
    Object localObject3 = this.thM;
    localObject2 = this.tfm;
    String str = this.cpW;
    int j = this.tif.cJb();
    HashMap localHashMap = ((PluginTopStoryUI)com.tencent.mm.kernel.g.G(PluginTopStoryUI.class)).getVideoPlayProgressMap();
    if (localHashMap.containsKey(((ckx)localObject2).xVa)) {}
    for (i = ((Integer)localHashMap.get(((ckx)localObject2).xVa)).intValue();; i = 0)
    {
      ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPlay, pos:%s, vid:%s videoProgress: %d", new Object[] { Integer.valueOf(j), ((ckx)localObject2).xVa, Integer.valueOf(i) });
      if (((r)localObject1).tjR != null)
      {
        if ((!((r)localObject1).tjR.uKI.equals(((ckx)localObject2).uKI)) || (paramBoolean2))
        {
          ((r)localObject1).tjP.stop();
          ((b)localObject3).cJd().b(((b)localObject3).cJf());
          ((b)localObject3).cJd().cKd();
        }
      }
      else
      {
        if (!bo.isNullOrNil(((ckx)localObject2).videoUrl)) {
          break label682;
        }
        ab.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", new Object[] { str, ((ckx)localObject2).xVa, ((ckx)localObject2).title });
      }
      return true;
      label608:
      t.makeText(this.thM.bMN(), 2131304344, 0).show();
      break;
      label630:
      if (i == 2) {
        break;
      }
      cJG();
      this.thM.cJh().a(this, c(this.tfm));
      return false;
      localHashMap.put(((ckx)localObject2).xVa, Integer.valueOf(0));
    }
    label682:
    ((b)localObject3).cJd().a((ckx)localObject2, j, str);
    ((r)localObject1).thM.cJd().f((ckx)localObject2);
    ((r)localObject1).tjP.setLoop(false);
    ((r)localObject1).tjP.setVideoInfo((ckx)localObject2);
    ((r)localObject1).tjP.setMute(((b)localObject3).DP());
    ((r)localObject1).tjP.setKeepScreenOn(true);
    if (i == 0) {
      ((r)localObject1).tjP.aep(str);
    }
    for (;;)
    {
      ((r)localObject1).tjP.cKg();
      ((r)localObject1).tjR = ((ckx)localObject2);
      ((r)localObject1).tjS = true;
      ((r)localObject1).tjT = false;
      break;
      localObject3 = ((r)localObject1).tjP;
      ((q)localObject3).cpW = str;
      ((q)localObject3).GK(i);
    }
  }
  
  public final void a(ckx paramckx, int paramInt)
  {
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", new Object[] { Integer.valueOf(paramInt) });
    this.tfm = paramckx;
    bJ();
  }
  
  protected void bJ()
  {
    this.kha.setImageDrawable(null);
    com.tencent.mm.at.o.ahG().a(this.tfm.xUY, this.kha, thj);
    if (this.tig != null)
    {
      this.tig.animate().cancel();
      this.tig.setVisibility(8);
    }
  }
  
  public h.d c(ckx paramckx)
  {
    return h.d.vQI;
  }
  
  public abstract void cJA();
  
  public void cJB()
  {
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.tif.cJb()) });
    this.thX.setVisibility(8);
    this.kha.setVisibility(8);
    this.thO.setVisibility(8);
    this.thW.setVisibility(8);
    this.thN.setVisibility(0);
    this.thN.setAlpha(1.0F);
  }
  
  public final void cJC()
  {
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.tif.cJb()) });
    this.kha.setVisibility(0);
    this.thX.setVisibility(0);
    this.tib.setVisibility(8);
    this.thY.setVisibility(8);
    this.thW.setVisibility(0);
    this.thZ.setVisibility(0);
    this.thR.setVisibility(0);
    this.thS.setVisibility(8);
    this.thV.setVisibility(8);
    this.thQ.setVisibility(8);
  }
  
  public final void cJD()
  {
    gT(getNoNetTip(), this.thM.bMN().getString(2131304536));
    getContext().getString(2131304342, new Object[] { bo.b(this.tfm.xVi, 100.0D) });
  }
  
  public void cJE() {}
  
  public void cJF() {}
  
  public final void cJG()
  {
    this.tih = f.a.tij;
    cJE();
    gT(getMobileNetTip(), getContext().getString(2131304323));
  }
  
  public final String cJH()
  {
    this.cpW = UUID.randomUUID().toString();
    return this.cpW;
  }
  
  public void cJI() {}
  
  public final void cJJ()
  {
    this.tib.setVisibility(0);
  }
  
  public abstract void cJz();
  
  public final void gT(String paramString1, String paramString2)
  {
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", new Object[] { paramString1, paramString2 });
    this.kha.setVisibility(0);
    this.thX.setVisibility(0);
    this.thY.setVisibility(0);
    this.thW.setVisibility(0);
    this.thZ.setVisibility(8);
    this.tia.setVisibility(0);
    this.thP.setVisibility(8);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.thU.setText(paramString1);
      this.thU.setVisibility(0);
    }
    while (!TextUtils.isEmpty(paramString2))
    {
      this.thT.setText(paramString2);
      this.thT.setVisibility(0);
      return;
      this.thU.setVisibility(8);
    }
    this.thT.setVisibility(8);
  }
  
  public abstract g getControlBar();
  
  public a getItemUIComponent()
  {
    return this.tif;
  }
  
  protected abstract int getLayoutId();
  
  protected String getMobileNetTip()
  {
    if (this.tfm.xVi == 0L) {
      return getContext().getString(2131304343);
    }
    return getContext().getString(2131304342, new Object[] { bo.b(this.tfm.xVi, 100.0D) });
  }
  
  public String getNoNetTip()
  {
    return getContext().getString(2131304523);
  }
  
  public f.a getPauseReason()
  {
    return this.tih;
  }
  
  public abstract h.b getVideoViewCallback();
  
  public FrameLayout getVideoViewParent()
  {
    return this.thN;
  }
  
  protected void init()
  {
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    this.thN = ((FrameLayout)findViewById(2131828528));
    this.thO = ((TextView)findViewById(2131828539));
    this.thW = findViewById(2131828530);
    this.thX = findViewById(2131828529);
    this.thY = findViewById(2131828535);
    this.thZ = findViewById(2131828531);
    this.tia = findViewById(2131828536);
    this.thP = findViewById(2131828538);
    this.kha = ((ImageView)findViewById(2131821891));
    this.thQ = ((TextView)findViewById(2131828534));
    this.titleTv = ((TextView)findViewById(2131821212));
    this.thR = ((ImageView)findViewById(2131824408));
    this.thS = ((ImageView)findViewById(2131828532));
    this.thV = ((TextView)findViewById(2131828533));
    this.thT = ((Button)findViewById(2131828537));
    this.thU = ((TextView)findViewById(2131824411));
    this.tic = ((ImageView)findViewById(2131821449));
    this.tie = ((ImageView)findViewById(2131821448));
    this.tib = ((FrameLayout)findViewById(2131821447));
    this.tig = ((TextView)findViewById(2131828591));
  }
  
  public final void seekTo(int paramInt)
  {
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.thM.cJh().getCurrPosSec()) });
    Object localObject = this.thM.cJh();
    if (((r)localObject).tjP != null) {
      ((r)localObject).tjP.GK(paramInt);
    }
    localObject = this.thM.cJd().tjL;
    if (localObject != null) {
      ((com.tencent.mm.plugin.topstory.a.b.a)localObject).teY = 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.f
 * JD-Core Version:    0.7.0.1
 */