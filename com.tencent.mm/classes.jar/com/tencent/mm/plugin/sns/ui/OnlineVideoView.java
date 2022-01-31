package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.h.a.qz;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.s.j;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public class OnlineVideoView
  extends RelativeLayout
  implements d.a, ae.a, f.a
{
  private String bMB;
  private awd bZK = null;
  private int cah;
  private boolean cai;
  private int caj;
  private boolean dnJ = false;
  private int duration = 0;
  private int enw;
  private com.tencent.mm.model.d gEB;
  ah itx = new ah(Looper.getMainLooper());
  private f iuC;
  private am iuI = new am(new OnlineVideoView.17(this), true);
  ImageView kga;
  private RelativeLayout kgv;
  private TextView kjP;
  private boolean kjQ = false;
  private boolean kjR;
  private int kjS = 0;
  private ProgressBar kjT;
  private MMPinProgressBtn kjU;
  private Context mContext;
  private com.tencent.mm.plugin.s.b mes = new OnlineVideoView.7(this);
  private int oRA = 0;
  private int oRB = 0;
  private long oRC = 0L;
  private long oRD = 0L;
  private am oRE = new am(new OnlineVideoView.16(this), true);
  private b.b oRF = new b.b()
  {
    public final void Ni(String paramAnonymousString) {}
    
    public final void bCt() {}
    
    public final void ba(String paramAnonymousString, boolean paramAnonymousBoolean) {}
    
    public final void bb(String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      OnlineVideoView.o(OnlineVideoView.this).postDelayed(new OnlineVideoView.2.1(this, paramAnonymousBoolean, paramAnonymousString), 100L);
    }
  };
  private c oRG = new c() {};
  c oRH = new OnlineVideoView.4(this);
  private long oRI;
  private int oRJ;
  private boolean oRk;
  private f.e oRn = new OnlineVideoView.6(this);
  private int oRr = 0;
  boolean oRs = false;
  String oRt;
  private boolean oRu = false;
  private OnlineVideoView.a oRv;
  private TextView oRw;
  private ae oRx = null;
  private boolean oRy;
  private boolean oRz = false;
  private az omX;
  private c otN = new OnlineVideoView.5(this);
  
  public OnlineVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OnlineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OnlineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    y.i("MicroMsg.OnlineVideoView", "%d ui init view.", new Object[] { Integer.valueOf(hashCode()) });
    LayoutInflater.from(paramContext).inflate(i.g.sns_video_view, this);
    this.kga = ((ImageView)findViewById(i.f.video_thumb));
    this.kgv = ((RelativeLayout)findViewById(i.f.video_root));
    this.oRw = ((TextView)findViewById(i.f.video_duration));
    this.oRw.setVisibility(8);
    this.kjU = ((MMPinProgressBtn)findViewById(i.f.video_progress));
    this.kjT = ((ProgressBar)findViewById(i.f.video_loading));
    this.kjP = ((TextView)findViewById(i.f.video_tips));
    com.tencent.mm.modelcontrol.d.Nl();
    if (com.tencent.mm.modelcontrol.d.Ns())
    {
      this.kjR = true;
      this.iuC = new VideoPlayerTextureView(paramContext);
      ((VideoPlayerTextureView)this.iuC).setIOnlineCache(this.mes);
      ((VideoPlayerTextureView)this.iuC).setOpenWithNoneSurface(true);
      h.nFQ.a(354L, 148L, 1L, false);
    }
    for (;;)
    {
      this.iuC.setVideoCallback(this);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(13);
      this.kgv.addView((View)this.iuC, paramContext);
      a(false, 0.0F);
      return;
      this.kjR = false;
      this.iuC = new VideoTextureView(paramContext);
      h.nFQ.a(354L, 149L, 1L, false);
    }
  }
  
  private void Z(int paramInt, boolean paramBoolean)
  {
    this.itx.post(new OnlineVideoView.1(this, paramInt, paramBoolean));
  }
  
  private void a(boolean paramBoolean, float paramFloat)
  {
    this.itx.post(new OnlineVideoView.11(this, paramBoolean, paramFloat));
  }
  
  private void apT()
  {
    this.itx.post(new OnlineVideoView.13(this));
  }
  
  private void bHJ()
  {
    if (!this.oRs) {}
    for (String str = aq.a(this.bMB, this.bZK);; str = this.oRt)
    {
      y.i("MicroMsg.OnlineVideoView", "%d toggleVideo local id %s finish path %s isPreview %b", new Object[] { Integer.valueOf(hashCode()), this.bMB, str, Boolean.valueOf(this.oRs) });
      if (bk.bl(str)) {
        break;
      }
      y.i("MicroMsg.OnlineVideoView", "%d sns video already download finish, play now", new Object[] { Integer.valueOf(hashCode()) });
      a(true, 0.0F);
      bg(str, false);
      return;
    }
    a(false, 0.0F);
    v(false, 0);
    apT();
  }
  
  private void bHN()
  {
    long l = bk.UZ();
    String str1 = aq.a(this.bMB, this.bZK);
    String str2 = u.of(str1);
    if (bk.bl(str2))
    {
      Toast.makeText(this.mContext, this.mContext.getString(i.j.video_file_save_failed), 1).show();
      h.nFQ.a(354L, 222L, 1L, false);
    }
    for (;;)
    {
      this.oRu = false;
      y.i("MicroMsg.OnlineVideoView", "%d save downloaded video finish %d %s", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(bk.cp(l)), str1 });
      this.itx.post(new OnlineVideoView.10(this));
      return;
      Toast.makeText(this.mContext, this.mContext.getString(i.j.video_file_saved, new Object[] { str2 }), 1).show();
      q.a(str2, this.mContext);
      h.nFQ.a(354L, 221L, 1L, false);
    }
  }
  
  private void bHQ()
  {
    this.oRI = bk.UY();
    y.d("MicroMsg.OnlineVideoView", "%d notePlayVideo notePlayVideo %d ", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.oRI) });
  }
  
  private void bHR()
  {
    if (this.oRI > 0L) {
      this.oRJ = ((int)(this.oRJ + (bk.UY() - this.oRI) / 1000L));
    }
    y.i("MicroMsg.OnlineVideoView", "%d notePauseVideo playVideoDuration %d ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.oRJ) });
    this.oRI = 0L;
  }
  
  private void bdC()
  {
    this.itx.post(new OnlineVideoView.14(this));
  }
  
  private void v(boolean paramBoolean, int paramInt)
  {
    if (this.bZK == null)
    {
      y.w("MicroMsg.OnlineVideoView", "%d start download video but media is null.", new Object[] { Integer.valueOf(hashCode()) });
      return;
    }
    if (this.oRx == null)
    {
      y.w("MicroMsg.OnlineVideoView", "%d start download video but helper is null.", new Object[] { Integer.valueOf(hashCode()) });
      return;
    }
    if (this.bZK.trO == 2)
    {
      y.w("MicroMsg.OnlineVideoView", "%d it start download video, url type is weixin", new Object[] { Integer.valueOf(hashCode()) });
      this.oRr = 3;
      af.bDA().a(this.bZK, 4, null, this.omX);
      return;
    }
    int i;
    if (!paramBoolean)
    {
      com.tencent.mm.modelcontrol.d.Nl();
      if (com.tencent.mm.modelcontrol.d.Nr())
      {
        y.i("MicroMsg.OnlineVideoView", "%d it start online download video", new Object[] { Integer.valueOf(hashCode()) });
        this.oRr = 1;
        paramBoolean = true;
        i = paramInt;
        if (paramInt == 0) {
          i = 30;
        }
        paramInt = i;
      }
    }
    do
    {
      ae localae = this.oRx;
      awd localawd = this.bZK;
      i = this.enw;
      String str = this.bMB;
      localae.bZK = localawd;
      localae.enw = i;
      localae.bJQ = str;
      localae.eFp = aq.D(localawd);
      localae.eFo = aq.aI(i, localawd.kSC);
      if ((bk.bl(localae.eFp)) || (bk.bl(localae.eFo))) {
        break;
      }
      y.i("MicroMsg.OnlineVideoViewHelper", "start online download video %s isPlayMode %b", new Object[] { localae.eFo, Boolean.valueOf(paramBoolean) });
      af.bDD().a(localawd, i, str, paramBoolean, true, paramInt);
      localae.eFr = 1;
      localae.dmd = bk.UY();
      if (!paramBoolean) {
        break label377;
      }
      h.nFQ.a(354L, 201L, 1L, false);
      return;
      y.i("MicroMsg.OnlineVideoView", "%d it start offline download video", new Object[] { Integer.valueOf(hashCode()) });
      this.oRr = 2;
      paramBoolean = false;
    } while (paramInt != 0);
    for (;;)
    {
      paramInt = 31;
    }
    label377:
    h.nFQ.a(354L, 202L, 1L, false);
  }
  
  private void yC(int paramInt)
  {
    String str = an.eJ(af.getAccSnsPath(), this.bZK.lsK) + com.tencent.mm.plugin.sns.data.i.e(this.bZK);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("image_path", str);
    localIntent.putExtra("Retr_Msg_Type", 11);
    y.i("MicroMsg.OnlineVideoView", "send video path %s reqCode %d", new Object[] { str, Integer.valueOf(paramInt) });
    com.tencent.mm.br.d.c(this.mContext, ".ui.transmit.SelectConversationUI", localIntent, paramInt);
    this.caj = 0;
  }
  
  public final void Sg()
  {
    y.i("MicroMsg.OnlineVideoView", "%d pauseByDataBlock", new Object[] { Integer.valueOf(hashCode()) });
    bHR();
    apT();
    if (this.iuC.isPlaying())
    {
      y.i("MicroMsg.OnlineVideoView", "%d pause play", new Object[] { Integer.valueOf(hashCode()) });
      bHR();
      this.iuC.pause();
    }
  }
  
  public final void a(awd paramawd, String paramString, int paramInt)
  {
    this.bMB = paramString;
    this.enw = paramInt;
    paramString = az.cvd();
    paramString.time = this.enw;
    this.omX = paramString;
    if (this.bZK != paramawd)
    {
      this.bZK = paramawd;
      boolean bool = af.bDC().b(this.bZK, this.kga, i.e.black, this.mContext.hashCode(), this.omX);
      y.i("MicroMsg.OnlineVideoView", "%d fresh thumb image %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool) });
    }
    this.oRs = false;
    y.i("MicroMsg.OnlineVideoView", "%d set video data[%s, %d] isPreview %b ", new Object[] { Integer.valueOf(hashCode()), this.bMB, Integer.valueOf(this.enw), Boolean.valueOf(this.oRs) });
  }
  
  public final void bHM()
  {
    y.d("MicroMsg.OnlineVideoView", "%d unRegister sns ui event", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.sdk.b.a.udP.d(this.oRH);
  }
  
  protected final void bHO()
  {
    this.oRE.stopTimer();
    this.iuI.stopTimer();
  }
  
  public final boolean bHP()
  {
    boolean bool = true;
    y.i("MicroMsg.OnlineVideoView", "%d resumeByDataGain", new Object[] { Integer.valueOf(hashCode()) });
    if (!this.iuC.isPlaying())
    {
      bHQ();
      bool = this.iuC.start();
      bdC();
    }
    return bool;
  }
  
  public final void bg(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.OnlineVideoView", "%d prepare video isOnlinePlay %b filePath %s", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), paramString });
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.OnlineVideoView", "%d prepare video but filepath is null.", new Object[] { Integer.valueOf(hashCode()) });
      return;
    }
    this.oRy = paramBoolean;
    Object localObject;
    boolean bool;
    if (this.iuC != null)
    {
      if (this.oRB == -3) {
        break label229;
      }
      if ((this.iuC instanceof VideoPlayerTextureView))
      {
        localObject = (VideoPlayerTextureView)this.iuC;
        if (this.oRy) {
          break label208;
        }
        bool = false;
        label112:
        ((VideoPlayerTextureView)localObject).setNeedResetExtractor(bool);
        ((VideoPlayerTextureView)this.iuC).setIsOnlineVideoType(paramBoolean);
      }
      this.iuC.setOneTimeVideoTextureUpdateCallback(this.oRn);
      this.iuC.setVideoPath(paramString);
      a(true, 0.0F);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.DQ();
      if (((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.utO, Integer.valueOf(0))).intValue() != 1) {
        break;
      }
      this.kjP.setText(com.tencent.mm.plugin.sight.base.d.Ik(paramString));
      this.kjP.setVisibility(0);
      return;
      label208:
      com.tencent.mm.kernel.g.DQ();
      bool = com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uuT, false);
      break label112;
      label229:
      y.i("MicroMsg.OnlineVideoView", "%d prepare video reset source", new Object[] { Integer.valueOf(hashCode()) });
      if ((this.iuC instanceof VideoPlayerTextureView))
      {
        localObject = (VideoPlayerTextureView)this.iuC;
        y.i("MicroMsg.VideoPlayerTextureView", "%d reset source ", new Object[] { Integer.valueOf(localObject.hashCode()) });
        if (((VideoPlayerTextureView)localObject).joI != null)
        {
          localObject = ((VideoPlayerTextureView)localObject).joI;
          if (((com.tencent.mm.plugin.s.i)localObject).meE != null) {
            ((com.tencent.mm.plugin.s.i)localObject).meE.biy();
          }
        }
      }
      tP(this.oRA);
    }
  }
  
  protected final void ce(boolean paramBoolean)
  {
    if (this.oRy)
    {
      if (paramBoolean)
      {
        ai.d(new OnlineVideoView.15(this));
        return;
      }
      this.oRE.S(500L, 500L);
      return;
    }
    this.iuI.S(500L, 500L);
  }
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public int getPlayErrorCode()
  {
    return this.kjS;
  }
  
  public int getPlayVideoDuration()
  {
    if (this.oRJ < 0) {
      this.oRJ = 0;
    }
    y.i("MicroMsg.OnlineVideoView", "%d get play video duration [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.oRJ) });
    return this.oRJ;
  }
  
  public int getUiStayTime()
  {
    if ((this.oRD > 0L) && (this.oRC > 0L)) {}
    for (int i = (int)(this.oRD - this.oRC);; i = 0)
    {
      if (i < 0) {
        return 0;
      }
      return i;
    }
  }
  
  public final void kA()
  {
    y.i("MicroMsg.OnlineVideoView", "%d onPrepared playErrorCode[%d] onErrorPlayTimeSec[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.kjS), Integer.valueOf(this.oRA) });
    this.kjS = 0;
    if (this.oRA > 0)
    {
      tP(this.oRA);
      this.oRA = 0;
      return;
    }
    this.oRB = 0;
    bdC();
    bHQ();
    this.iuC.start();
    this.duration = (this.iuC.getDuration() / 1000);
    y.i("MicroMsg.OnlineVideoView", "%d start play duration %d sns local id %s ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.duration), this.bMB });
    ce(false);
  }
  
  public final void onDestroy()
  {
    y.d("MicroMsg.OnlineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    this.oRD = bk.UY();
    y.i("MicroMsg.OnlineVideoView", "%d logic unInit", new Object[] { Integer.valueOf(hashCode()) });
    bHR();
    this.iuC.stop();
    com.tencent.mm.sdk.b.a.udP.d(this.otN);
    com.tencent.mm.sdk.b.a.udP.d(this.oRG);
    af.bDA().b(this.oRF);
    bHO();
    this.itx.removeCallbacksAndMessages(null);
    if (this.oRx != null)
    {
      this.oRx.bHU();
      this.oRx.clear();
    }
    if (com.tencent.mm.r.a.tu() != null) {
      com.tencent.mm.r.a.tu().vS();
    }
    if (this.gEB != null) {
      this.gEB.bH(false);
    }
    this.gEB = null;
    this.bZK = null;
    this.bMB = null;
    this.oRx = null;
    this.oRB = 0;
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.OnlineVideoView", "%d on play video error what %d extra %d. isOnlinePlay %b isMMVideoPlayer[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.oRy), Boolean.valueOf(this.kjR) });
    Object localObject;
    if (this.oRy)
    {
      h.nFQ.a(354L, 230L, 1L, false);
      this.kjS = paramInt2;
      bHR();
      localObject = this.iuC.getVideoPath();
      this.oRA = (this.iuC.getCurrentPosition() / 1000);
      if (!this.oRy) {
        break label367;
      }
      if (paramInt1 != -2) {
        break label328;
      }
      this.iuC.stop();
    }
    for (;;)
    {
      label328:
      label367:
      try
      {
        apT();
        if (this.oRx != null)
        {
          localObject = this.oRx;
          String str = ((ae)localObject).eFo + 0 + "_-1";
          if (!((ae)localObject).oRQ.containsKey(str))
          {
            y.i("MicroMsg.OnlineVideoViewHelper", "request all data. [%s]", new Object[] { ((ae)localObject).eFo });
            o.Ss();
            com.tencent.mm.ak.e.h(((ae)localObject).eFo, 0, -1);
            ((ae)localObject).oRQ.put(str, Integer.valueOf(0));
            h.nFQ.a(354L, 207L, 1L, false);
            h.nFQ.f(13836, new Object[] { Integer.valueOf(403), Long.valueOf(bk.UX()), "" });
          }
          ((ae)localObject).eFs = 5;
          ((ae)localObject).eFx = true;
          ((ae)localObject).eFA = false;
        }
        bHR();
        return;
      }
      catch (Exception localException) {}
      h.nFQ.a(354L, 231L, 1L, false);
      break;
      if (paramInt1 == -3)
      {
        this.oRB = paramInt1;
        this.iuC.pause();
      }
      else
      {
        bHO();
        this.iuC.stop();
        continue;
        this.iuC.stop();
        this.kjQ = true;
        a(false, 0.0F);
        if (!bk.bl((String)localObject))
        {
          y.w("MicroMsg.OnlineVideoView", "%d start third player to play", new Object[] { Integer.valueOf(hashCode()) });
          this.itx.post(new OnlineVideoView.8(this, (String)localObject));
          return;
        }
      }
    }
  }
  
  public final void onPause()
  {
    y.d("MicroMsg.OnlineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    bHO();
    if (this.iuC != null) {
      this.iuC.stop();
    }
  }
  
  public final void onResume()
  {
    y.d("MicroMsg.OnlineVideoView", "%d on resume %s", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    this.oRC = bk.UY();
    if (this.oRx == null)
    {
      y.i("MicroMsg.OnlineVideoView", "%d logic init, create new helper and add listener.", new Object[] { Integer.valueOf(hashCode()) });
      this.oRx = new ae(this);
      com.tencent.mm.sdk.b.a.udP.c(this.otN);
      com.tencent.mm.sdk.b.a.udP.c(this.oRG);
      af.bDA().a(this.oRF);
      this.gEB = new com.tencent.mm.model.d();
      this.gEB.a(this);
      if (com.tencent.mm.r.a.tu() != null) {
        com.tencent.mm.r.a.tu().vT();
      }
    }
    if (!this.kjQ) {
      bHJ();
    }
    this.oRk = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.dnJ = paramBoolean;
    this.iuC.setMute(this.dnJ);
  }
  
  public void setVideoCallback(OnlineVideoView.a parama)
  {
    this.oRv = parama;
  }
  
  public final void tP(int paramInt)
  {
    y.i("MicroMsg.OnlineVideoView", "%d seek second %d afterSeekPlay %b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(true) });
    this.oRB = 0;
    bdC();
    this.iuC.d(paramInt * 1000, true);
    ce(false);
  }
  
  public final void ug()
  {
    y.i("MicroMsg.OnlineVideoView", "%d on completion", new Object[] { Integer.valueOf(hashCode()) });
    if (this.oRv == null)
    {
      if ((!com.tencent.mm.compatible.util.d.gH(18)) && (this.kjR)) {
        break label50;
      }
      tP(0);
    }
    label50:
    while (this.iuC == null) {
      return;
    }
    String str = this.iuC.getVideoPath();
    this.iuC.stop();
    bg(str, this.oRy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView
 * JD-Core Version:    0.7.0.1
 */