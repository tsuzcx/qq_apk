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
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.eir;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import java.util.HashMap;
import java.util.UUID;

public abstract class f
  extends RelativeLayout
{
  public static c Glu;
  public eiw GjH;
  public b GlS;
  protected FrameLayout GlT;
  public TextView GlU;
  protected View GlV;
  protected TextView GlW;
  protected ImageView GlX;
  protected ImageView GlY;
  protected Button GlZ;
  protected TextView Gma;
  protected TextView Gmb;
  protected View Gmc;
  protected View Gmd;
  protected View Gme;
  protected View Gmf;
  protected View Gmg;
  public FrameLayout Gmh;
  public ImageView Gmi;
  public ImageView Gmj;
  public a Gmk;
  protected TextView Gml;
  public f.a Gmm = f.a.Gmn;
  protected ImageView puw;
  public String sessionId = "";
  protected TextView titleTv;
  
  static
  {
    c.a locala = new c.a();
    locala.jbf = true;
    locala.jbe = true;
    Glu = locala.bdv();
  }
  
  public f(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.GlS = paramb;
    this.Gmk = parama;
    init();
  }
  
  public final void a(eiw parameiw, int paramInt)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", new Object[] { Integer.valueOf(paramInt) });
    this.GjH = parameiw;
    updateView();
  }
  
  public boolean ay(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.GlS.fyP();
    Object localObject2 = ai.fYe();
    int i = this.GlS.fyQ();
    if (!this.GlS.fyA().isConnected())
    {
      this.Gmm = f.a.Gmp;
      fza();
      lg(getNoNetTip(), getContext().getString(2131767108));
      this.GlS.fyF().a(this, c(this.GjH));
      return false;
    }
    if ((!((String)localObject2).equals("wifi")) && (!((String)localObject2).equals(localObject1)))
    {
      if (!((String)localObject2).equals("wangka")) {
        break label704;
      }
      if ((i != 1) && (i != 2))
      {
        this.GlS.abW(1);
        if (this.Gml == null) {
          break label682;
        }
        this.Gml.setVisibility(0);
        this.Gml.setAlpha(1.0F);
        this.Gml.animate().alpha(0.0F).setDuration(3000L).start();
      }
    }
    this.GlS.aTF((String)localObject2);
    fzd();
    this.Gmm = f.a.Gmn;
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
    this.Gmd.setVisibility(0);
    this.Gmf.setVisibility(8);
    this.Gmc.setVisibility(8);
    this.Gmh.setVisibility(8);
    this.Gme.setVisibility(0);
    this.Gmg.setVisibility(8);
    this.GlV.setVisibility(0);
    this.GlV.setVisibility(0);
    this.GlV.setAlpha(0.0F);
    this.GlV.animate().setDuration(4000L).setInterpolator(new AccelerateInterpolator()).alpha(1.0F).start();
    this.puw.setVisibility(0);
    this.GlU.setVisibility(8);
    this.GlT.setVisibility(0);
    this.GlT.setAlpha(0.0F);
    this.GlS.fyF().a(this, c(this.GjH));
    localObject1 = this.GlS.fyF();
    Object localObject3 = this.GlS;
    localObject2 = this.GjH;
    String str = this.sessionId;
    int j = this.Gmk.fyz();
    HashMap localHashMap = ((PluginTopStoryUI)com.tencent.mm.kernel.g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap();
    if (localHashMap.containsKey(((eiw)localObject2).psI)) {}
    for (i = ((Integer)localHashMap.get(((eiw)localObject2).psI)).intValue();; i = 0)
    {
      Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPlay, pos:%s, vid:%s videoProgress: %d", new Object[] { Integer.valueOf(j), ((eiw)localObject2).psI, Integer.valueOf(i) });
      if (((eiw)localObject2).Niz != null) {
        Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "video %s secondVideoInfo %d %d", new Object[] { ((eiw)localObject2).psI, Integer.valueOf(((eiw)localObject2).Niz.NhT), Integer.valueOf(((eiw)localObject2).Niz.NhU) });
      }
      if (((eiw)localObject2).NiI != null) {
        ((eiw)localObject2).NiI.dEF = false;
      }
      if (((r)localObject1).GjK != null)
      {
        if ((!((r)localObject1).GjK.wWb.equals(((eiw)localObject2).wWb)) || (paramBoolean2))
        {
          ((r)localObject1).GnX.stop();
          ((b)localObject3).fyB().b(((b)localObject3).fyD());
          ((b)localObject3).fyB().fzB();
        }
      }
      else
      {
        if (!Util.isNullOrNil(((eiw)localObject2).videoUrl)) {
          break label756;
        }
        Log.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", new Object[] { str, ((eiw)localObject2).psI, ((eiw)localObject2).title });
      }
      return true;
      label682:
      u.makeText(this.GlS.eeF(), 2131766827, 0).show();
      break;
      label704:
      if (i == 2) {
        break;
      }
      fzc();
      this.GlS.fyF().a(this, c(this.GjH));
      return false;
      localHashMap.put(((eiw)localObject2).psI, Integer.valueOf(0));
    }
    label756:
    ((b)localObject3).fyB().a((eiw)localObject2, j, str);
    ((r)localObject1).GlS.fyB().j((eiw)localObject2);
    ((r)localObject1).GnX.setLoop(false);
    ((r)localObject1).GnX.setVideoInfo((eiw)localObject2);
    ((r)localObject1).GnX.setMute(((b)localObject3).Zx());
    ((r)localObject1).GnX.setKeepScreenOn(true);
    if (i == 0) {
      ((r)localObject1).GnX.aTG(str);
    }
    for (;;)
    {
      ((r)localObject1).GnX.fzE();
      ((r)localObject1).GjK = ((eiw)localObject2);
      ((r)localObject1).GnZ = true;
      ((r)localObject1).Goa = false;
      break;
      localObject3 = ((r)localObject1).GnX;
      ((q)localObject3).sessionId = str;
      ((q)localObject3).G(i, true);
    }
  }
  
  public i.e c(eiw parameiw)
  {
    return i.e.KbZ;
  }
  
  public void crC() {}
  
  public abstract void fyV();
  
  public abstract void fyW();
  
  public void fyX()
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.Gmk.fyz()) });
    this.Gmd.setVisibility(8);
    this.puw.setVisibility(8);
    this.GlU.setVisibility(8);
    this.Gmc.setVisibility(8);
    this.GlT.setVisibility(0);
    this.GlT.setAlpha(1.0F);
  }
  
  public final void fyY()
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", new Object[] { Integer.valueOf(this.Gmk.fyz()) });
    this.puw.setVisibility(0);
    this.Gmd.setVisibility(0);
    this.Gmh.setVisibility(8);
    this.Gme.setVisibility(8);
    this.Gmc.setVisibility(0);
    this.Gmf.setVisibility(0);
    this.GlX.setVisibility(0);
    this.GlY.setVisibility(8);
    this.Gmb.setVisibility(8);
    this.GlW.setVisibility(8);
  }
  
  public final void fyZ()
  {
    lg(getNoNetTip(), this.GlS.eeF().getString(2131767108));
    getContext().getString(2131766825, new Object[] { Util.getSizeMB(this.GjH.Niv, 100.0D) });
  }
  
  public void fza() {}
  
  public void fzb() {}
  
  public final void fzc()
  {
    this.Gmm = f.a.Gmo;
    fza();
    lg(getMobileNetTip(), getContext().getString(2131766803));
  }
  
  public final String fzd()
  {
    this.sessionId = UUID.randomUUID().toString();
    return this.sessionId;
  }
  
  public final void fze()
  {
    this.Gmh.setVisibility(0);
  }
  
  public void fzf() {}
  
  public void fzg() {}
  
  public boolean fzh()
  {
    return false;
  }
  
  public abstract g getControlBar();
  
  public a getItemUIComponent()
  {
    return this.Gmk;
  }
  
  protected abstract int getLayoutId();
  
  protected String getMobileNetTip()
  {
    if (this.GjH.Niv == 0L) {
      return getContext().getString(2131766826);
    }
    return getContext().getString(2131766825, new Object[] { Util.getSizeMB(this.GjH.Niv, 100.0D) });
  }
  
  public String getNoNetTip()
  {
    return getContext().getString(2131767092);
  }
  
  public f.a getPauseReason()
  {
    return this.Gmm;
  }
  
  public abstract i.b getVideoViewCallback();
  
  public FrameLayout getVideoViewParent()
  {
    return this.GlT;
  }
  
  protected void init()
  {
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    this.GlT = ((FrameLayout)findViewById(2131309843));
    this.GlU = ((TextView)findViewById(2131306300));
    this.Gmc = findViewById(2131309172);
    this.Gmd = findViewById(2131309725);
    this.Gme = findViewById(2131309833);
    this.Gmf = findViewById(2131309726);
    this.Gmg = findViewById(2131309775);
    this.GlV = findViewById(2131309779);
    this.puw = ((ImageView)findViewById(2131299289));
    this.GlW = ((TextView)findViewById(2131309824));
    this.titleTv = ((TextView)findViewById(2131309249));
    this.GlX = ((ImageView)findViewById(2131299280));
    this.GlY = ((ImageView)findViewById(2131299281));
    this.Gmb = ((TextView)findViewById(2131306944));
    this.GlZ = ((Button)findViewById(2131309151));
    this.Gma = ((TextView)findViewById(2131309152));
    this.Gmi = ((ImageView)findViewById(2131305970));
    this.Gmj = ((ImageView)findViewById(2131305969));
    this.Gmh = ((FrameLayout)findViewById(2131305971));
    this.Gml = ((TextView)findViewById(2131305275));
  }
  
  public final void lg(String paramString1, String paramString2)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", new Object[] { paramString1, paramString2 });
    this.puw.setVisibility(0);
    this.Gmd.setVisibility(0);
    this.Gme.setVisibility(0);
    this.Gmc.setVisibility(0);
    this.Gmf.setVisibility(8);
    this.Gmg.setVisibility(0);
    this.GlV.setVisibility(8);
    if (!TextUtils.isEmpty(paramString1))
    {
      this.Gma.setText(paramString1);
      this.Gma.setVisibility(0);
    }
    while (!TextUtils.isEmpty(paramString2))
    {
      this.GlZ.setText(paramString2);
      this.GlZ.setVisibility(0);
      return;
      this.Gma.setVisibility(8);
    }
    this.GlZ.setVisibility(8);
  }
  
  public final void seekTo(int paramInt)
  {
    Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.GlS.fyF().getCurrPosSec()) });
    Object localObject = this.GlS.fyF();
    if (((r)localObject).GnX != null) {
      ((r)localObject).GnX.G(paramInt, true);
    }
    localObject = this.GlS.fyB().GnT;
    if (localObject != null) {
      ((com.tencent.mm.plugin.topstory.a.b.b)localObject).Gjr = 1L;
    }
  }
  
  protected void updateView()
  {
    this.puw.setImageDrawable(null);
    com.tencent.mm.av.q.bcV().a(this.GjH.Nio, this.puw, Glu);
    if (this.Gml != null)
    {
      this.Gml.animate().cancel();
      this.Gml.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.f
 * JD-Core Version:    0.7.0.1
 */