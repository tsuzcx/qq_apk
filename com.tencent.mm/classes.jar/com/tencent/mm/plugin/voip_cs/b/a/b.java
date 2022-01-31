package com.tencent.mm.plugin.voip_cs.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.view.Display;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.model.p.a;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip_cs.a.a;
import com.tencent.mm.plugin.voip_cs.a.b;
import com.tencent.mm.plugin.voip_cs.a.e;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

public final class b
  implements TextureView.SurfaceTextureListener, View.OnClickListener, p.a, com.tencent.mm.plugin.voip.video.g
{
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected static final int[] pWP = { -1, a.e.voip_cs_one_dot, a.e.voip_cs_two_dot, a.e.voip_cs_three_dot };
  public boolean bNW = false;
  private Timer bzx;
  private ah dPi;
  public TextView doV;
  private TextView dsz;
  private ImageButton mvM;
  private View mwf;
  public ObservableTextureView mws;
  private VoipBigIconButton pXR;
  private OpenGlView pXu;
  private OpenGlView pXv;
  public OpenGlRender pXw;
  public OpenGlRender pXx;
  private View.OnClickListener pYL = new b.3(this);
  private boolean pYj = false;
  public String qeA = "";
  public am qeB = new am(Looper.getMainLooper(), new b.1(this), false);
  public am qeC = new am(Looper.getMainLooper(), new b.2(this), false);
  b.a qeD = new b.a(this, (byte)0);
  b.c qeE;
  b.b qeF;
  String qeG = "";
  Drawable qeH = null;
  public VoipCSMainUI qej;
  public RelativeLayout qek;
  private TextView qel;
  private TextView qem;
  private TextView qen;
  private TextView qeo;
  public ImageView qep;
  private ah qeq;
  public com.tencent.mm.plugin.voip_cs.c.a qer;
  private boolean qes = false;
  protected long qet = -1L;
  private boolean qeu = false;
  private boolean qev = false;
  public int qew = 60000;
  public int qex = 5000;
  private com.tencent.mm.plugin.voip_cs.c.b qey = new com.tencent.mm.plugin.voip_cs.c.b();
  public String qez = "";
  
  public b(VoipCSMainUI paramVoipCSMainUI)
  {
    this.qej = paramVoipCSMainUI;
    Object localObject = (WindowManager)paramVoipCSMainUI.getSystemService("window");
    int i = ((WindowManager)localObject).getDefaultDisplay().getHeight() / 5;
    int j = ((WindowManager)localObject).getDefaultDisplay().getWidth() * i / ((WindowManager)localObject).getDefaultDisplay().getHeight();
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)paramVoipCSMainUI.findViewById(a.b.rl_video_cs_controllers)).setPadding(0, 0, 0, BackwardSupportUtil.b.b(paramVoipCSMainUI.mController.uMN, 40.0F));
    }
    this.pXv = new MovableVideoView(paramVoipCSMainUI.getApplicationContext());
    ((MovableVideoView)this.pXv).eo(j, i);
    this.pXv.setVisibility(8);
    this.pXw = new OpenGlRender(this.pXv, OpenGlRender.RenderRemote);
    this.pXv.setRenderer(this.pXw);
    this.pXv.setRenderMode(0);
    if (Build.MODEL.equals("Nexus 6"))
    {
      this.pXv.setZOrderOnTop(true);
      this.dsz = ((TextView)paramVoipCSMainUI.findViewById(a.b.time_tv));
      this.dsz.setVisibility(0);
      this.bzx = new Timer("voip_cs_talking_time");
      this.qel = ((TextView)paramVoipCSMainUI.findViewById(a.b.voip_cs_cancel));
      this.qel.setVisibility(0);
      this.qem = ((TextView)paramVoipCSMainUI.findViewById(a.b.voip_cs_video_calling_status));
      if (!paramVoipCSMainUI.bso.equals("1")) {
        break label1020;
      }
      if (!paramVoipCSMainUI.type.equals("video")) {
        break label1001;
      }
      this.qem.setText(ae.getContext().getString(a.e.voip_cs_declare));
      label453:
      this.qem.setVisibility(0);
      this.doV = ((TextView)paramVoipCSMainUI.findViewById(a.b.voip_cs_video_remote_talker_name));
      this.doV.setVisibility(0);
      this.qep = ((ImageView)paramVoipCSMainUI.findViewById(a.b.voip_cs_pic));
      this.qep.setVisibility(0);
      this.qeo = ((TextView)paramVoipCSMainUI.findViewById(a.b.voip_cs_video_call_hint));
      this.qen = ((TextView)paramVoipCSMainUI.findViewById(a.b.voip_cs_video_calling_status_dot));
      this.pXR = ((VoipBigIconButton)paramVoipCSMainUI.findViewById(a.b.voip_cs_switch_camera));
      if ((paramVoipCSMainUI.qeR == null) || (!paramVoipCSMainUI.qeR.equals("1"))) {
        break label1071;
      }
      this.pXR.setVisibility(0);
      this.pXR.setOnClickListener(this.pYL);
      label586:
      this.dPi = new ah();
      this.qeq = new b.4(this);
      this.mwf = paramVoipCSMainUI.findViewById(a.b.voip_cs_activity_root);
      this.mvM = ((ImageButton)paramVoipCSMainUI.findViewById(a.b.voip_cs_talking_hangup_btn));
      this.qek = ((RelativeLayout)paramVoipCSMainUI.findViewById(a.b.voip_cs_activity_root));
      mScreenWidth = com.tencent.mm.cb.a.fj(paramVoipCSMainUI.mController.uMN);
      mScreenHeight = com.tencent.mm.plugin.voip_cs.c.c.es(paramVoipCSMainUI.mController.uMN);
      this.pXu = ((OpenGlView)paramVoipCSMainUI.findViewById(a.b.voip_cs_big_video));
      this.pXu.ep(mScreenWidth, mScreenHeight);
      this.pXx = new OpenGlRender(this.pXu, OpenGlRender.RenderLocal);
      this.pXu.setRenderer(this.pXx);
      this.pXu.setRenderMode(0);
      this.pXu.setVisibility(0);
      y.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[] { Integer.valueOf(mScreenHeight) });
      this.mvM.setOnClickListener(this);
      this.qek.addView(this.pXv);
      this.pXv.setOnClickListener(new b.5(this));
      this.pXw.qaX = true;
      this.pXx.qaX = true;
      if (!com.tencent.mm.plugin.voip.a.d.en(ae.getContext())) {
        com.tencent.mm.plugin.voip.a.d.eo(ae.getContext());
      }
      paramVoipCSMainUI = ae.cqS();
      this.qez = paramVoipCSMainUI.getString(bSY(), "");
      if ((this.qej.foS == null) || (this.qej.foS.equals(""))) {
        break label1083;
      }
      Qf(this.qej.foS);
    }
    for (;;)
    {
      this.qeA = paramVoipCSMainUI.getString(bSZ(), "");
      if (!bk.bl(this.qeA)) {
        Qe(this.qeA);
      }
      paramVoipCSMainUI = com.tencent.mm.plugin.voip_cs.b.c.bSP();
      localObject = this.qej.qec;
      y.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:" + (String)localObject);
      com.tencent.mm.kernel.g.Dk().a(106, paramVoipCSMainUI);
      paramVoipCSMainUI = new f((String)localObject);
      com.tencent.mm.kernel.g.Dk().a(paramVoipCSMainUI, 0);
      return;
      this.pXv.setZOrderMediaOverlay(true);
      break;
      label1001:
      this.qem.setText(ae.getContext().getString(a.e.voip_cs_declare_audio));
      break label453;
      label1020:
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.qem.setText(ae.getContext().getString(a.e.voip_cs_declare_video));
        break label453;
      }
      this.qem.setText(ae.getContext().getString(a.e.voip_cs_declare_audio));
      break label453;
      label1071:
      this.pXR.setVisibility(8);
      break label586;
      label1083:
      if (!bk.bl(this.qez)) {
        Qf(this.qez);
      }
    }
  }
  
  private void AD(int paramInt)
  {
    if ((this.qej.qeR != null) && (this.qej.qeR.equals("1")))
    {
      this.pXR.setVisibility(paramInt);
      return;
    }
    this.pXR.setVisibility(8);
  }
  
  private static int AF(int paramInt)
  {
    if (paramInt == 1) {
      return a.e.voip_cs_callee_hang_up;
    }
    if (paramInt == 0) {
      return a.e.voip_cs_end_wording;
    }
    if ((paramInt == -1) || (paramInt == 5)) {
      return a.e.voip_cs_net_unavailable;
    }
    if ((paramInt == 403) || (paramInt == 404)) {
      return a.e.voip_cs_verify_fail;
    }
    if (paramInt == 6) {
      return a.e.voip_cs_opposite_not_response;
    }
    if (paramInt == 1001) {
      return a.e.voip_cs_net_status_warning_hint;
    }
    if (paramInt == 10) {
      return a.e.voip_cs_disconnect_tip;
    }
    if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb < 2) {
      return a.e.voip_cs_call_fail;
    }
    return a.e.voip_cs_end_wording;
  }
  
  public static Drawable Qg(String paramString)
  {
    try
    {
      paramString = Drawable.createFromStream((InputStream)new URL(paramString).getContent(), "urlDrawable");
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
    }
    return null;
  }
  
  private void bTb()
  {
    y.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
    this.dPi.postDelayed(new b.6(this), 10000L);
  }
  
  protected static String ce(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  private static float ka(boolean paramBoolean)
  {
    float f1 = 0.7476636F;
    float f2;
    if (paramBoolean) {
      f2 = f1;
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.field_capInfo;
        f2 = f1;
        if (localObject == null) {
          return f2;
        }
        f2 = f1;
        localObject = ByteBuffer.wrap((byte[])localObject);
        f2 = f1;
        if (((ByteBuffer)localObject).getInt() > 65535)
        {
          f2 = f1;
          ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
        }
        f2 = f1;
        ((ByteBuffer)localObject).getShort();
        f2 = f1;
        ((ByteBuffer)localObject).getShort();
        f2 = f1;
        float f3 = ((ByteBuffer)localObject).getInt() / 100.0F;
        if (f3 != 0.0F) {
          f1 = f3;
        }
        f2 = f1;
        y.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
        return f1;
      }
      catch (Exception localException)
      {
        Object localObject;
        y.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + localException.getMessage());
      }
      f2 = f1;
      localObject = com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.pUC;
    }
    return f2;
  }
  
  private Point kc(boolean paramBoolean)
  {
    int i = ((WindowManager)this.qej.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
    float f = i;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return new Point((int)(ka(paramBoolean) * f), i);
    }
  }
  
  private void ki(boolean paramBoolean)
  {
    if (Build.MANUFACTURER.equalsIgnoreCase("sony"))
    {
      y.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
      return;
    }
    if (!paramBoolean)
    {
      this.qej.getWindow().setFlags(1024, 1024);
      return;
    }
    this.qej.getWindow().clearFlags(1024);
  }
  
  public final void AE(int paramInt)
  {
    y.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:" + paramInt);
    if (this.bzx != null)
    {
      this.bzx.cancel();
      this.bzx = null;
    }
    if (!this.qeB.crl()) {
      this.qeB.stopTimer();
    }
    if (!this.qeC.crl()) {
      this.qeC.stopTimer();
    }
    this.qey.bSc();
    this.qes = false;
    this.qeo.setVisibility(0);
    this.qeo.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.qeo.setBackgroundResource(a.a.voip_cs_toast_bg);
    this.qeo.setCompoundDrawables(null, null, null, null);
    this.qeo.setCompoundDrawablePadding(0);
    this.qeo.setText(AF(paramInt));
    if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb == 2) {
      com.tencent.mm.sdk.f.e.post(new b.8(this), "VoipCS_play_end_sound");
    }
    this.dPi.postDelayed(new b.9(this), 2000L);
  }
  
  public final void Qe(String paramString)
  {
    if (this.qej.qeU) {}
    for (paramString = paramString + ae.getContext().getString(a.e.voip_cs_biz_user_appbrand);; paramString = paramString + ae.getContext().getString(a.e.voip_cs_biz_user_mp))
    {
      this.doV.setText(paramString);
      return;
    }
  }
  
  public final void Qf(String paramString)
  {
    if (!bk.bl(paramString))
    {
      this.qeF = new b.b(this);
      if ((this.qej.foS == null) || (this.qej.foS.equals(""))) {
        break label68;
      }
    }
    label68:
    for (this.qeG = this.qej.foS;; this.qeG = paramString)
    {
      com.tencent.mm.sdk.f.e.a(this.qeF, "VOIPCS_netPic", 10);
      return;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.bNW);
    if (this.bNW) {}
    int i;
    int j;
    label271:
    label279:
    label308:
    do
    {
      return;
      if (this.qeD.muz == null)
      {
        this.qeD.w = paramInt1;
        this.qeD.h = paramInt2;
        this.qeD.muz = new int[this.qeD.w * this.qeD.h];
      }
      if (this.qer.bSu())
      {
        i = OpenGlRender.FLAG_Mirror;
        if (!this.qer.bSv()) {
          break label271;
        }
      }
      for (j = OpenGlRender.FLAG_Angle270;; j = OpenGlRender.FLAG_Angle90)
      {
        if (this.qeu)
        {
          int k = com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.videoEncodeToSend(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3 + paramInt4);
          y.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = " + k);
          com.tencent.mm.plugin.voip_cs.b.a locala = com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL;
          locala.pVS += 1;
        }
        com.tencent.mm.plugin.voip_cs.b.c.bSO().qeL.videoEncodeToLocal(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, 0, 75, this.qeD.muz);
        if (OpenGlRender.qbn != 1) {
          break label308;
        }
        if (!this.pYj) {
          break label279;
        }
        this.pXw.a(this.qeD.muz, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
        return;
        i = 0;
        break;
      }
      this.pXx.a(this.qeD.muz, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
      return;
    } while (OpenGlRender.qbn != 2);
    if (this.pYj)
    {
      this.pXw.c(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false);
      return;
    }
    this.pXx.c(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false);
  }
  
  public final String bSY()
  {
    return "voip_cs_headImageUrl_" + this.qej.qec;
  }
  
  public final String bSZ()
  {
    return "voip_cs_nickname_" + this.qej.qec;
  }
  
  public final void bTa()
  {
    y.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
    if (this.mws != null)
    {
      this.qek.removeView(this.mws);
      this.mws = null;
    }
    if (this.qer != null)
    {
      this.qer.bSs();
      com.tencent.mm.plugin.voip_cs.c.a.bSt();
      this.qer = null;
    }
  }
  
  public final void bTc()
  {
    bTd();
    this.qeE = new b.c(this);
    com.tencent.mm.sdk.f.e.a(this.qeE, "VOIPCS_VideoDecode", 10);
    y.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
  }
  
  public final void bTd()
  {
    if (this.qeE != null)
    {
      y.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
      this.qeE.pQT = true;
      com.tencent.mm.sdk.f.e.remove(this.qeE);
      this.qeE = null;
    }
  }
  
  public final void bbF()
  {
    this.qeB.stopTimer();
    this.qeC.stopTimer();
    this.qey.bSc();
    this.qen.setVisibility(8);
    this.qem.setText(a.e.voip_cs_serve_hint);
    this.qel.setText(a.e.voip_cs_hungup);
    AD(0);
    this.mwf.setOnClickListener(this);
    if ((this.qej.qeS != null) && (this.qej.qeS.equals("1")))
    {
      this.pXv.setVisibility(0);
      this.pYj = true;
      localObject = kc(this.pYj);
      ((MovableVideoView)this.pXv).eo(((Point)localObject).x, ((Point)localObject).y);
      bTc();
    }
    bTb();
    this.qeu = true;
    if (this.bzx == null) {
      this.bzx = new Timer("voip_cs_talking_time");
    }
    if (this.qes) {
      return;
    }
    if (this.qet == -1L) {
      this.qet = bk.UX();
    }
    this.qes = true;
    Object localObject = new b.7(this);
    this.bzx.schedule((TimerTask)localObject, 1000L, 1000L);
    com.tencent.mm.plugin.voip.model.p.bQU().bQV();
    com.tencent.mm.plugin.voip.model.p.bQU().pTc = this;
  }
  
  public final void bbG()
  {
    this.qeo.setVisibility(0);
    this.qeo.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.qeo.setBackgroundResource(a.a.voip_cs_toast_bg);
    this.qeo.setCompoundDrawables(null, null, null, null);
    this.qeo.setCompoundDrawablePadding(0);
    this.qeo.setText(AF(1001));
  }
  
  public final void bbH()
  {
    this.qeo.setVisibility(8);
  }
  
  public final void blN()
  {
    y.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    if (paramView.getId() == a.b.voip_cs_talking_hangup_btn)
    {
      if (com.tencent.mm.plugin.voip_cs.b.c.bSP().qeb < 2) {}
      for (com.tencent.mm.plugin.voip_cs.b.c.bSQ().aYU = 2;; com.tencent.mm.plugin.voip_cs.b.c.bSQ().aYU = 4)
      {
        paramView = com.tencent.mm.plugin.voip_cs.b.c.bSQ();
        paramView.qde = 1;
        paramView.qdB = 1;
        paramView.qdf = ((int)(System.currentTimeMillis() / 1000L));
        paramView = com.tencent.mm.plugin.voip_cs.b.c.bSQ();
        y.d("MicroMsg.VoipCSReportHelper", "selfCancel");
        if (paramView.qdy == 0)
        {
          paramView.qdt = 3;
          if ((paramView.qdC == 0L) && (paramView.qdO != 0)) {
            paramView.qdC = ((int)(System.currentTimeMillis() / 1000L) - paramView.qdO);
          }
        }
        com.tencent.mm.plugin.voip_cs.b.c.bSQ().bSR();
        y.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
        AE(0);
        return;
      }
    }
    if (this.mvM.getVisibility() == 0) {}
    for (int i = 8;; i = 0)
    {
      this.mvM.setVisibility(i);
      this.dsz.setVisibility(i);
      this.qel.setVisibility(i);
      AD(i);
      if (i == 0) {
        bool = true;
      }
      ki(bool);
      return;
    }
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b
 * JD-Core Version:    0.7.0.1
 */