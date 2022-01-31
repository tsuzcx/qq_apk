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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.q.a;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

public final class b
  implements TextureView.SurfaceTextureListener, View.OnClickListener, q.a, com.tencent.mm.plugin.voip.video.f
{
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected static final int[] tCt = { -1, 2131304665, 2131304670, 2131304669 };
  public boolean cvo;
  public TextView egr;
  private TextView ekh;
  private ak faV;
  private Timer oTD;
  private ImageButton oVE;
  private View oVX;
  private ObservableTextureView oWk;
  private OpenGlView tCX;
  private OpenGlView tCY;
  public OpenGlRender tCZ;
  private boolean tDM;
  public OpenGlRender tDa;
  private VoipBigIconButton tDv;
  private View.OnClickListener tEl;
  public VoipCSMainUI tKW;
  private RelativeLayout tKX;
  private TextView tKY;
  private TextView tKZ;
  private TextView tLa;
  private TextView tLb;
  public ImageView tLc;
  private ak tLd;
  private com.tencent.mm.plugin.voip_cs.c.a tLe;
  private boolean tLf;
  protected long tLg;
  private boolean tLh;
  private boolean tLi;
  private int tLj;
  private int tLk;
  private com.tencent.mm.plugin.voip_cs.c.b tLl;
  public String tLm;
  public String tLn;
  private ap tLo;
  private ap tLp;
  b.a tLq;
  b.c tLr;
  b.b tLs;
  String tLt;
  Drawable tLu;
  
  public b(VoipCSMainUI paramVoipCSMainUI)
  {
    AppMethodBeat.i(135330);
    this.tDM = false;
    this.cvo = false;
    this.tLf = false;
    this.tLg = -1L;
    this.tLh = false;
    this.tLi = false;
    this.tLj = 60000;
    this.tLk = 5000;
    this.tLl = new com.tencent.mm.plugin.voip_cs.c.b();
    this.tLm = "";
    this.tLn = "";
    this.tLo = new ap(Looper.getMainLooper(), new b.1(this), false);
    this.tLp = new ap(Looper.getMainLooper(), new b.2(this), false);
    this.tEl = new b.3(this);
    this.tLq = new b.a(this, (byte)0);
    this.tLt = "";
    this.tLu = null;
    this.tKW = paramVoipCSMainUI;
    Object localObject = (WindowManager)paramVoipCSMainUI.getSystemService("window");
    int i = ((WindowManager)localObject).getDefaultDisplay().getHeight() / 5;
    int j = ((WindowManager)localObject).getDefaultDisplay().getWidth() * i / ((WindowManager)localObject).getDefaultDisplay().getHeight();
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)paramVoipCSMainUI.findViewById(2131828829)).setPadding(0, 0, 0, BackwardSupportUtil.b.b(paramVoipCSMainUI.getContext(), 40.0F));
    }
    this.tCY = new MovableVideoView(paramVoipCSMainUI.getApplicationContext());
    ((MovableVideoView)this.tCY).gn(j, i);
    this.tCY.setVisibility(8);
    this.tCZ = new OpenGlRender(this.tCY, OpenGlRender.RenderRemote);
    this.tCY.setRenderer(this.tCZ);
    this.tCY.setRenderMode(0);
    if (Build.MODEL.equals("Nexus 6"))
    {
      this.tCY.setZOrderOnTop(true);
      this.ekh = ((TextView)paramVoipCSMainUI.findViewById(2131821004));
      this.ekh.setVisibility(0);
      this.oTD = new Timer("voip_cs_talking_time");
      this.tKY = ((TextView)paramVoipCSMainUI.findViewById(2131828832));
      this.tKY.setVisibility(0);
      this.tKZ = ((TextView)paramVoipCSMainUI.findViewById(2131828826));
      if (!paramVoipCSMainUI.bSd.equals("1")) {
        break label1011;
      }
      if (!paramVoipCSMainUI.type.equals("video")) {
        break label992;
      }
      this.tKZ.setText(ah.getContext().getString(2131304648));
      label454:
      this.tKZ.setVisibility(0);
      this.egr = ((TextView)paramVoipCSMainUI.findViewById(2131828824));
      this.egr.setVisibility(0);
      this.tLc = ((ImageView)paramVoipCSMainUI.findViewById(2131828823));
      this.tLc.setVisibility(0);
      this.tLb = ((TextView)paramVoipCSMainUI.findViewById(2131828833));
      this.tLa = ((TextView)paramVoipCSMainUI.findViewById(2131828827));
      this.tDv = ((VoipBigIconButton)paramVoipCSMainUI.findViewById(2131828831));
      if ((paramVoipCSMainUI.tLE == null) || (!paramVoipCSMainUI.tLE.equals("1"))) {
        break label1062;
      }
      this.tDv.setVisibility(0);
      this.tDv.setOnClickListener(this.tEl);
      label587:
      this.faV = new ak();
      this.tLd = new b.4(this);
      this.oVX = paramVoipCSMainUI.findViewById(2131828821);
      this.oVE = ((ImageButton)paramVoipCSMainUI.findViewById(2131828830));
      this.tKX = ((RelativeLayout)paramVoipCSMainUI.findViewById(2131828821));
      mScreenWidth = com.tencent.mm.cb.a.gw(paramVoipCSMainUI.getContext());
      mScreenHeight = com.tencent.mm.plugin.voip_cs.c.c.fp(paramVoipCSMainUI.getContext());
      this.tCX = ((OpenGlView)paramVoipCSMainUI.findViewById(2131828822));
      this.tCX.go(mScreenWidth, mScreenHeight);
      this.tDa = new OpenGlRender(this.tCX, OpenGlRender.RenderLocal);
      this.tCX.setRenderer(this.tDa);
      this.tCX.setRenderMode(0);
      this.tCX.setVisibility(0);
      ab.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[] { Integer.valueOf(mScreenHeight) });
      this.oVE.setOnClickListener(this);
      this.tKX.addView(this.tCY);
      this.tCY.setOnClickListener(new b.5(this));
      this.tCZ.onStarted();
      this.tDa.onStarted();
      if (!com.tencent.mm.plugin.voip.a.d.fj(ah.getContext())) {
        com.tencent.mm.plugin.voip.a.d.fk(ah.getContext());
      }
      paramVoipCSMainUI = ah.dsQ();
      this.tLm = paramVoipCSMainUI.getString(cQz(), "");
      if ((this.tKW.gGm == null) || (this.tKW.gGm.equals(""))) {
        break label1074;
      }
      aeM(this.tKW.gGm);
    }
    for (;;)
    {
      this.tLn = paramVoipCSMainUI.getString(cQA(), "");
      if (!bo.isNullOrNil(this.tLn)) {
        aeL(this.tLn);
      }
      paramVoipCSMainUI = com.tencent.mm.plugin.voip_cs.b.c.cQn();
      localObject = this.tKW.tKP;
      ab.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:".concat(String.valueOf(localObject)));
      g.Rc().a(106, paramVoipCSMainUI);
      paramVoipCSMainUI = new com.tencent.mm.plugin.messenger.a.f((String)localObject);
      g.Rc().a(paramVoipCSMainUI, 0);
      AppMethodBeat.o(135330);
      return;
      this.tCY.setZOrderMediaOverlay(true);
      break;
      label992:
      this.tKZ.setText(ah.getContext().getString(2131304649));
      break label454;
      label1011:
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.tKZ.setText(ah.getContext().getString(2131304650));
        break label454;
      }
      this.tKZ.setText(ah.getContext().getString(2131304649));
      break label454;
      label1062:
      this.tDv.setVisibility(8);
      break label587;
      label1074:
      if (!bo.isNullOrNil(this.tLm)) {
        aeM(this.tLm);
      }
    }
  }
  
  private void Ie(int paramInt)
  {
    AppMethodBeat.i(135340);
    if ((this.tKW.tLE != null) && (this.tKW.tLE.equals("1")))
    {
      this.tDv.setVisibility(paramInt);
      AppMethodBeat.o(135340);
      return;
    }
    this.tDv.setVisibility(8);
    AppMethodBeat.o(135340);
  }
  
  private static int Ig(int paramInt)
  {
    AppMethodBeat.i(135349);
    if (paramInt == 1)
    {
      AppMethodBeat.o(135349);
      return 2131304645;
    }
    if (paramInt == 0)
    {
      AppMethodBeat.o(135349);
      return 2131304652;
    }
    if ((paramInt == -1) || (paramInt == 5))
    {
      AppMethodBeat.o(135349);
      return 2131304663;
    }
    if ((paramInt == 403) || (paramInt == 404))
    {
      AppMethodBeat.o(135349);
      return 2131304671;
    }
    if (paramInt == 6)
    {
      AppMethodBeat.o(135349);
      return 2131304666;
    }
    if (paramInt == 1001)
    {
      AppMethodBeat.o(135349);
      return 2131304662;
    }
    if (paramInt == 10)
    {
      AppMethodBeat.o(135349);
      return 2131304651;
    }
    if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO < 2)
    {
      AppMethodBeat.o(135349);
      return 2131304643;
    }
    AppMethodBeat.o(135349);
    return 2131304652;
  }
  
  public static Drawable aeN(String paramString)
  {
    AppMethodBeat.i(135346);
    try
    {
      paramString = Drawable.createFromStream((InputStream)new URL(paramString).getContent(), "urlDrawable");
      AppMethodBeat.o(135346);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
      AppMethodBeat.o(135346);
    }
    return null;
  }
  
  private void cQD()
  {
    AppMethodBeat.i(135343);
    ab.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
    this.faV.postDelayed(new b.6(this), 10000L);
    AppMethodBeat.o(135343);
  }
  
  protected static String ha(long paramLong)
  {
    AppMethodBeat.i(135347);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(135347);
    return str;
  }
  
  private static float mW(boolean paramBoolean)
  {
    AppMethodBeat.i(135338);
    float f1 = 0.7476636F;
    float f2;
    if (paramBoolean) {
      f2 = f1;
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.field_capInfo;
        f2 = f1;
        if (localObject != null)
        {
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
          ab.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
          f2 = f1;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        ab.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + localException.getMessage());
        continue;
      }
      AppMethodBeat.o(135338);
      return f2;
      f2 = f1;
      localObject = com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.tAd;
    }
  }
  
  private Point na(boolean paramBoolean)
  {
    AppMethodBeat.i(135337);
    int i = ((WindowManager)this.tKW.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
    float f = i;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Point localPoint = new Point((int)(mW(paramBoolean) * f), i);
      AppMethodBeat.o(135337);
      return localPoint;
    }
  }
  
  private void ni(boolean paramBoolean)
  {
    AppMethodBeat.i(135344);
    if (Build.MANUFACTURER.equalsIgnoreCase("sony"))
    {
      ab.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
      AppMethodBeat.o(135344);
      return;
    }
    if (!paramBoolean)
    {
      this.tKW.getWindow().setFlags(1024, 1024);
      AppMethodBeat.o(135344);
      return;
    }
    this.tKW.getWindow().clearFlags(1024);
    AppMethodBeat.o(135344);
  }
  
  public final void If(int paramInt)
  {
    AppMethodBeat.i(135348);
    ab.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:".concat(String.valueOf(paramInt)));
    if (this.oTD != null)
    {
      this.oTD.cancel();
      this.oTD = null;
    }
    if (!this.tLo.dtj()) {
      this.tLo.stopTimer();
    }
    if (!this.tLp.dtj()) {
      this.tLp.stopTimer();
    }
    this.tLl.cOZ();
    this.tLf = false;
    this.tLb.setVisibility(0);
    this.tLb.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.tLb.setBackgroundResource(2130840752);
    this.tLb.setCompoundDrawables(null, null, null, null);
    this.tLb.setCompoundDrawablePadding(0);
    this.tLb.setText(Ig(paramInt));
    if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO == 2) {
      com.tencent.mm.sdk.g.d.post(new b.8(this), "VoipCS_play_end_sound");
    }
    this.faV.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135327);
        b.j(b.this).finish();
        AppMethodBeat.o(135327);
      }
    }, 2000L);
    AppMethodBeat.o(135348);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(135352);
    ab.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.cvo);
    if (this.cvo)
    {
      AppMethodBeat.o(135352);
      return;
    }
    if (this.tLq.oUo == null)
    {
      this.tLq.w = paramInt1;
      this.tLq.h = paramInt2;
      this.tLq.oUo = new int[this.tLq.w * this.tLq.h];
    }
    int i;
    if (this.tLe.cPB())
    {
      i = OpenGlRender.FLAG_Mirror;
      if (!this.tLe.cPC()) {
        break label278;
      }
    }
    label278:
    for (int j = OpenGlRender.FLAG_Angle270;; j = OpenGlRender.FLAG_Angle90)
    {
      if (this.tLh)
      {
        ab.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = ".concat(String.valueOf(com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.videoEncodeToSend(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3 + paramInt4))));
        com.tencent.mm.plugin.voip_cs.b.a locala = com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy;
        locala.tBx += 1;
      }
      com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.videoEncodeToLocal(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, 0, 75, this.tLq.oUo);
      if (OpenGlRender.tGO != 1) {
        break label321;
      }
      if (!this.tDM) {
        break label286;
      }
      this.tCZ.a(this.tLq.oUo, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
      AppMethodBeat.o(135352);
      return;
      i = 0;
      break;
    }
    label286:
    this.tDa.a(this.tLq.oUo, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
    AppMethodBeat.o(135352);
    return;
    label321:
    if (OpenGlRender.tGO == 2)
    {
      if (this.tDM)
      {
        this.tCZ.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
        AppMethodBeat.o(135352);
        return;
      }
      this.tDa.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
    }
    AppMethodBeat.o(135352);
  }
  
  public final void aeL(String paramString)
  {
    AppMethodBeat.i(135333);
    if (this.tKW.tLH) {}
    for (paramString = paramString + ah.getContext().getString(2131304639);; paramString = paramString + ah.getContext().getString(2131304640))
    {
      this.egr.setText(paramString);
      AppMethodBeat.o(135333);
      return;
    }
  }
  
  public final void aeM(String paramString)
  {
    AppMethodBeat.i(135334);
    if (!bo.isNullOrNil(paramString))
    {
      this.tLs = new b.b(this);
      if ((this.tKW.gGm == null) || (this.tKW.gGm.equals(""))) {
        break label78;
      }
    }
    label78:
    for (this.tLt = this.tKW.gGm;; this.tLt = paramString)
    {
      com.tencent.mm.sdk.g.d.f(this.tLs, "VOIPCS_netPic");
      AppMethodBeat.o(135334);
      return;
    }
  }
  
  public final void bIN()
  {
    AppMethodBeat.i(135345);
    this.tLo.stopTimer();
    this.tLp.stopTimer();
    this.tLl.cOZ();
    this.tLa.setVisibility(8);
    this.tKZ.setText(2131304668);
    this.tKY.setText(2131304656);
    Ie(0);
    this.oVX.setOnClickListener(this);
    if ((this.tKW.tLF != null) && (this.tKW.tLF.equals("1")))
    {
      this.tCY.setVisibility(0);
      this.tDM = true;
      localObject = na(this.tDM);
      ((MovableVideoView)this.tCY).gn(((Point)localObject).x, ((Point)localObject).y);
      cQE();
    }
    cQD();
    this.tLh = true;
    if (this.oTD == null) {
      this.oTD = new Timer("voip_cs_talking_time");
    }
    if (this.tLf)
    {
      AppMethodBeat.o(135345);
      return;
    }
    if (this.tLg == -1L) {
      this.tLg = bo.aox();
    }
    this.tLf = true;
    Object localObject = new b.7(this);
    this.oTD.schedule((TimerTask)localObject, 1000L, 1000L);
    q.cNr().cNs();
    q.cNr().a(this);
    AppMethodBeat.o(135345);
  }
  
  public final void bIO()
  {
    AppMethodBeat.i(135351);
    this.tLb.setVisibility(8);
    AppMethodBeat.o(135351);
  }
  
  public final void bho()
  {
    AppMethodBeat.i(135353);
    ab.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    AppMethodBeat.o(135353);
  }
  
  public final String cQA()
  {
    AppMethodBeat.i(135336);
    String str = "voip_cs_nickname_" + this.tKW.tKP;
    AppMethodBeat.o(135336);
    return str;
  }
  
  public final void cQB()
  {
    AppMethodBeat.i(135341);
    ab.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
    if (this.oWk == null)
    {
      ab.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
      this.oWk = new ObservableTextureView(this.tKW);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
      this.oWk.setLayoutParams(localLayoutParams);
      this.tKX.addView(this.oWk, new RelativeLayout.LayoutParams(1, 1));
      this.oWk.setVisibility(0);
    }
    if (this.tLe == null)
    {
      int j = 320;
      int i = 240;
      com.tencent.mm.plugin.voip_cs.b.c.cQm();
      if (com.tencent.mm.plugin.voip_cs.b.a.tzX)
      {
        j = 640;
        i = 480;
      }
      ab.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
      this.tLe = new com.tencent.mm.plugin.voip_cs.c.a(j, i);
      this.tLe.a(this, true);
      this.tLe.a(this.oWk);
      com.tencent.mm.plugin.voip_cs.b.c.cQm().tLy.tAp = this.tLe.cPD();
      this.tLe.cPz();
      this.tLe.cQJ();
      ab.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.tLe.cPB()), Boolean.valueOf(this.tLe.cPC()) });
    }
    AppMethodBeat.o(135341);
  }
  
  public final void cQC()
  {
    AppMethodBeat.i(135342);
    ab.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
    if (this.oWk != null)
    {
      this.tKX.removeView(this.oWk);
      this.oWk = null;
    }
    if (this.tLe != null)
    {
      this.tLe.cPA();
      this.tLe = null;
    }
    AppMethodBeat.o(135342);
  }
  
  public final void cQE()
  {
    AppMethodBeat.i(135354);
    cQF();
    this.tLr = new b.c(this);
    com.tencent.mm.sdk.g.d.f(this.tLr, "VOIPCS_VideoDecode");
    ab.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    AppMethodBeat.o(135354);
  }
  
  public final void cQF()
  {
    AppMethodBeat.i(135355);
    if (this.tLr != null)
    {
      ab.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
      this.tLr.tvX = true;
      com.tencent.mm.sdk.g.d.ysm.remove(this.tLr);
      this.tLr = null;
    }
    AppMethodBeat.o(135355);
  }
  
  public final void cQx()
  {
    AppMethodBeat.i(135331);
    if (this.tLo.dtj())
    {
      ap localap = this.tLo;
      long l = this.tLj;
      localap.ag(l, l);
    }
    AppMethodBeat.o(135331);
  }
  
  public final void cQy()
  {
    AppMethodBeat.i(135332);
    if (this.tLp.dtj())
    {
      ap localap = this.tLp;
      long l = this.tLk;
      localap.ag(l, l);
    }
    AppMethodBeat.o(135332);
  }
  
  public final String cQz()
  {
    AppMethodBeat.i(135335);
    String str = "voip_cs_headImageUrl_" + this.tKW.tKP;
    AppMethodBeat.o(135335);
    return str;
  }
  
  public final void iw(boolean paramBoolean)
  {
    AppMethodBeat.i(135350);
    this.tLb.setVisibility(0);
    this.tLb.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.tLb.setBackgroundResource(2130840752);
    this.tLb.setCompoundDrawables(null, null, null, null);
    this.tLb.setCompoundDrawablePadding(0);
    this.tLb.setText(Ig(1001));
    AppMethodBeat.o(135350);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(135339);
    if (paramView.getId() == 2131828830)
    {
      if (com.tencent.mm.plugin.voip_cs.b.c.cQn().tKO < 2) {}
      for (com.tencent.mm.plugin.voip_cs.b.c.cQo().dataType = 2;; com.tencent.mm.plugin.voip_cs.b.c.cQo().dataType = 4)
      {
        paramView = com.tencent.mm.plugin.voip_cs.b.c.cQo();
        paramView.tJR = 1;
        paramView.tKo = 1;
        paramView.tJS = ((int)(System.currentTimeMillis() / 1000L));
        paramView = com.tencent.mm.plugin.voip_cs.b.c.cQo();
        ab.d("MicroMsg.VoipCSReportHelper", "selfCancel");
        if (paramView.tKl == 0)
        {
          paramView.tKg = 3;
          if ((paramView.tKp == 0L) && (paramView.tKB != 0)) {
            paramView.tKp = ((int)(System.currentTimeMillis() / 1000L) - paramView.tKB);
          }
        }
        com.tencent.mm.plugin.voip_cs.b.c.cQo().cQp();
        ab.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
        If(0);
        AppMethodBeat.o(135339);
        return;
      }
    }
    if (this.oVE.getVisibility() == 0) {}
    for (int i = 8;; i = 0)
    {
      this.oVE.setVisibility(i);
      this.ekh.setVisibility(i);
      this.tKY.setVisibility(i);
      Ie(i);
      if (i == 0) {
        bool = true;
      }
      ni(bool);
      AppMethodBeat.o(135339);
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