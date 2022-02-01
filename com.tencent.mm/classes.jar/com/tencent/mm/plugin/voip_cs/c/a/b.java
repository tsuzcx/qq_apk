package com.tencent.mm.plugin.voip_cs.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
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
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.cs.MovableVideoView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

public final class b
  implements TextureView.SurfaceTextureListener, View.OnClickListener, r.a, f
{
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  protected static final int[] zrr = { -1, 2131764841, 2131764846, 2131764845 };
  public boolean dkt;
  public TextView frs;
  private TextView fwS;
  private ap gAC;
  private Timer tOV;
  private View tSL;
  private ImageButton tSq;
  private ObservableTextureView tTb;
  String zDA;
  Drawable zDB;
  public VoipCSMainUI zDd;
  private RelativeLayout zDe;
  private TextView zDf;
  private TextView zDg;
  private TextView zDh;
  private TextView zDi;
  public ImageView zDj;
  private ap zDk;
  private com.tencent.mm.plugin.voip_cs.d.a zDl;
  private boolean zDm;
  protected long zDn;
  private boolean zDo;
  private boolean zDp;
  private int zDq;
  private int zDr;
  private com.tencent.mm.plugin.voip_cs.d.b zDs;
  public String zDt;
  public String zDu;
  private av zDv;
  private av zDw;
  a zDx;
  c zDy;
  b zDz;
  private View.OnClickListener zqT;
  private VoipBigIconButton zqe;
  private boolean zqu;
  private OpenGlView zsh;
  private OpenGlView zsi;
  public OpenGlRender zsj;
  public OpenGlRender zsk;
  
  public b(VoipCSMainUI paramVoipCSMainUI)
  {
    AppMethodBeat.i(125382);
    this.zqu = false;
    this.dkt = false;
    this.zDm = false;
    this.zDn = -1L;
    this.zDo = false;
    this.zDp = false;
    this.zDq = 60000;
    this.zDr = 5000;
    this.zDs = new com.tencent.mm.plugin.voip_cs.d.b();
    this.zDt = "";
    this.zDu = "";
    this.zDv = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125370);
        ad.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
        com.tencent.mm.plugin.voip_cs.c.c.dYi().dataType = 1;
        b.this.Rc(6);
        AppMethodBeat.o(125370);
        return true;
      }
    }, false);
    this.zDw = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125371);
        b.a(b.this).setText(aj.getContext().getString(2131764848));
        b.b(b.this).setVisibility(0);
        com.tencent.mm.plugin.voip_cs.d.b localb = b.c(b.this);
        TextView localTextView = b.b(b.this);
        Object localObject = b.zrr;
        if ((localObject == null) || (localTextView == null)) {
          ad.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        }
        for (;;)
        {
          AppMethodBeat.o(125371);
          return true;
          localb.dWc();
          localb.zrF = 0;
          localb.zrD = ((int[])localObject);
          localb.Tu = localTextView;
          localb.zrE = 500;
          if (localb.cbR != null)
          {
            localObject = localb.cbR;
            long l = localb.zrE;
            ((av)localObject).av(l, l);
          }
          ad.l("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(localTextView)), new Object[0]);
        }
      }
    }, false);
    this.zqT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125372);
        ad.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
        b.d(b.this).setEnabled(false);
        if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV > 1) {
          b.e(b.this);
        }
        b.d(b.this).setEnabled(true);
        if (b.f(b.this) != null) {
          b.f(b.this).dWT();
        }
        AppMethodBeat.o(125372);
      }
    };
    this.zDx = new a((byte)0);
    this.zDA = "";
    this.zDB = null;
    this.zDd = paramVoipCSMainUI;
    Object localObject = (WindowManager)paramVoipCSMainUI.getSystemService("window");
    int i = ((WindowManager)localObject).getDefaultDisplay().getHeight() / 5;
    int j = ((WindowManager)localObject).getDefaultDisplay().getWidth() * i / ((WindowManager)localObject).getDefaultDisplay().getHeight();
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)paramVoipCSMainUI.findViewById(2131304206)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(paramVoipCSMainUI.getContext(), 40.0F));
    }
    this.zsi = new MovableVideoView(paramVoipCSMainUI.getApplicationContext());
    ((MovableVideoView)this.zsi).hU(j, i);
    this.zsi.setVisibility(8);
    this.zsj = new OpenGlRender(this.zsi, OpenGlRender.RenderRemote);
    this.zsi.setRenderer(this.zsj);
    this.zsi.setRenderMode(0);
    this.fwS = ((TextView)paramVoipCSMainUI.findViewById(2131305822));
    this.fwS.setVisibility(0);
    this.tOV = new Timer("voip_cs_talking_time");
    this.zDf = ((TextView)paramVoipCSMainUI.findViewById(2131306563));
    this.zDf.setVisibility(0);
    this.zDg = ((TextView)paramVoipCSMainUI.findViewById(2131306568));
    if (paramVoipCSMainUI.scene.equals("1")) {
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.zDg.setText(aj.getContext().getString(2131764824));
        this.zDg.setVisibility(0);
        this.frs = ((TextView)paramVoipCSMainUI.findViewById(2131306571));
        this.frs.setVisibility(0);
        this.zDj = ((ImageView)paramVoipCSMainUI.findViewById(2131306564));
        this.zDj.setVisibility(0);
        this.zDi = ((TextView)paramVoipCSMainUI.findViewById(2131306567));
        this.zDh = ((TextView)paramVoipCSMainUI.findViewById(2131306569));
        this.zqe = ((VoipBigIconButton)paramVoipCSMainUI.findViewById(2131306565));
        if ((paramVoipCSMainUI.zDJ == null) || (!paramVoipCSMainUI.zDJ.equals("1"))) {
          break label1031;
        }
        this.zqe.setVisibility(0);
        this.zqe.setOnClickListener(this.zqT);
        label567:
        this.gAC = new ap();
        this.zDk = new ap()
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(125373);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(125373);
              return;
              if (b.this.zDB != null)
              {
                b.g(b.this).setImageDrawable(b.this.zDB);
                AppMethodBeat.o(125373);
                return;
              }
              b.g(b.this).setImageResource(2131231875);
            }
          }
        };
        this.tSL = paramVoipCSMainUI.findViewById(2131306560);
        this.tSq = ((ImageButton)paramVoipCSMainUI.findViewById(2131306566));
        this.zDe = ((RelativeLayout)paramVoipCSMainUI.findViewById(2131306560));
        mScreenWidth = com.tencent.mm.cd.a.hV(paramVoipCSMainUI.getContext());
        mScreenHeight = com.tencent.mm.plugin.voip_cs.d.c.gs(paramVoipCSMainUI.getContext());
        this.zsh = ((OpenGlView)paramVoipCSMainUI.findViewById(2131306561));
        this.zsh.hV(mScreenWidth, mScreenHeight);
        this.zsk = new OpenGlRender(this.zsh, OpenGlRender.RenderLocal);
        this.zsh.setRenderer(this.zsk);
        this.zsh.setRenderMode(0);
        this.zsh.setVisibility(0);
        ad.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[] { Integer.valueOf(mScreenHeight) });
        this.tSq.setOnClickListener(this);
        this.zDe.addView(this.zsi);
        this.zsi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125374);
            paramAnonymousView = b.this;
            if (!b.h(b.this)) {}
            for (boolean bool = true;; bool = false)
            {
              b.a(paramAnonymousView, bool);
              paramAnonymousView = b.b(b.this, b.h(b.this));
              b.i(b.this).hW(paramAnonymousView.x, paramAnonymousView.y);
              AppMethodBeat.o(125374);
              return;
            }
          }
        });
        this.zsj.onStarted();
        this.zsk.onStarted();
        if (!k.gm(aj.getContext())) {
          k.gn(aj.getContext());
        }
        paramVoipCSMainUI = aj.eFE();
        this.zDt = paramVoipCSMainUI.getString(dYu(), "");
        if ((this.zDd.itN == null) || (this.zDd.itN.equals(""))) {
          break label1043;
        }
        atn(this.zDd.itN);
      }
    }
    for (;;)
    {
      this.zDu = paramVoipCSMainUI.getString(dYv(), "");
      if (!bt.isNullOrNil(this.zDu)) {
        setNickName(this.zDu);
      }
      paramVoipCSMainUI = com.tencent.mm.plugin.voip_cs.c.c.dYh();
      localObject = this.zDd.zCW;
      ad.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:".concat(String.valueOf(localObject)));
      com.tencent.mm.kernel.g.aeS().a(106, paramVoipCSMainUI);
      paramVoipCSMainUI = new com.tencent.mm.plugin.messenger.a.g((String)localObject);
      com.tencent.mm.kernel.g.aeS().a(paramVoipCSMainUI, 0);
      AppMethodBeat.o(125382);
      return;
      this.zDg.setText(aj.getContext().getString(2131764825));
      break;
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.zDg.setText(aj.getContext().getString(2131764826));
        break;
      }
      this.zDg.setText(aj.getContext().getString(2131764825));
      break;
      label1031:
      this.zqe.setVisibility(8);
      break label567;
      label1043:
      if (!bt.isNullOrNil(this.zDt)) {
        atn(this.zDt);
      }
    }
  }
  
  private void Rb(int paramInt)
  {
    AppMethodBeat.i(125392);
    if ((this.zDd.zDJ != null) && (this.zDd.zDJ.equals("1")))
    {
      this.zqe.setVisibility(paramInt);
      AppMethodBeat.o(125392);
      return;
    }
    this.zqe.setVisibility(8);
    AppMethodBeat.o(125392);
  }
  
  private static int Rd(int paramInt)
  {
    AppMethodBeat.i(125401);
    if (paramInt == 1)
    {
      AppMethodBeat.o(125401);
      return 2131764821;
    }
    if (paramInt == 0)
    {
      AppMethodBeat.o(125401);
      return 2131764828;
    }
    if ((paramInt == -1) || (paramInt == 5))
    {
      AppMethodBeat.o(125401);
      return 2131764839;
    }
    if ((paramInt == 403) || (paramInt == 404))
    {
      AppMethodBeat.o(125401);
      return 2131764847;
    }
    if (paramInt == 6)
    {
      AppMethodBeat.o(125401);
      return 2131764842;
    }
    if (paramInt == 1001)
    {
      AppMethodBeat.o(125401);
      return 2131764838;
    }
    if (paramInt == 10)
    {
      AppMethodBeat.o(125401);
      return 2131764827;
    }
    if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV < 2)
    {
      AppMethodBeat.o(125401);
      return 2131764819;
    }
    AppMethodBeat.o(125401);
    return 2131764828;
  }
  
  public static Drawable ato(String paramString)
  {
    AppMethodBeat.i(125398);
    try
    {
      paramString = Drawable.createFromStream((InputStream)new URL(paramString).getContent(), "urlDrawable");
      AppMethodBeat.o(125398);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
      AppMethodBeat.o(125398);
    }
    return null;
  }
  
  private void dYy()
  {
    AppMethodBeat.i(125395);
    ad.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
    this.gAC.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125375);
        ad.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
        if (b.j(b.this).isFinishing())
        {
          AppMethodBeat.o(125375);
          return;
        }
        b.k(b.this).setVisibility(8);
        b.l(b.this).setVisibility(8);
        b.m(b.this).setVisibility(8);
        b.n(b.this);
        b.o(b.this);
        AppMethodBeat.o(125375);
      }
    }, 10000L);
    AppMethodBeat.o(125395);
  }
  
  protected static String mz(long paramLong)
  {
    AppMethodBeat.i(125399);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(125399);
    return str;
  }
  
  private static float rF(boolean paramBoolean)
  {
    AppMethodBeat.i(125390);
    float f1 = 0.7476636F;
    float f2;
    if (paramBoolean) {
      f2 = f1;
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.field_capInfo;
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
          ad.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
          f2 = f1;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        ad.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + localException.getMessage());
        continue;
      }
      AppMethodBeat.o(125390);
      return f2;
      f2 = f1;
      localObject = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.znu;
    }
  }
  
  private Point rK(boolean paramBoolean)
  {
    AppMethodBeat.i(125389);
    int i = ((WindowManager)this.zDd.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
    float f = i;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Point localPoint = new Point((int)(rF(paramBoolean) * f), i);
      AppMethodBeat.o(125389);
      return localPoint;
    }
  }
  
  private void sd(boolean paramBoolean)
  {
    AppMethodBeat.i(125396);
    if (Build.MANUFACTURER.equalsIgnoreCase("sony"))
    {
      ad.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
      AppMethodBeat.o(125396);
      return;
    }
    if (!paramBoolean)
    {
      this.zDd.getWindow().setFlags(1024, 1024);
      AppMethodBeat.o(125396);
      return;
    }
    this.zDd.getWindow().clearFlags(1024);
    AppMethodBeat.o(125396);
  }
  
  public final void Rc(int paramInt)
  {
    AppMethodBeat.i(125400);
    ad.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:".concat(String.valueOf(paramInt)));
    if (this.tOV != null)
    {
      this.tOV.cancel();
      this.tOV = null;
    }
    if (!this.zDv.eFX()) {
      this.zDv.stopTimer();
    }
    if (!this.zDw.eFX()) {
      this.zDw.stopTimer();
    }
    this.zDs.dWc();
    this.zDm = false;
    this.zDi.setVisibility(0);
    this.zDi.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.zDi.setBackgroundResource(2131234566);
    this.zDi.setCompoundDrawables(null, null, null, null);
    this.zDi.setCompoundDrawablePadding(0);
    this.zDi.setText(Rd(paramInt));
    if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV == 2) {
      com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "VoipCS_play_end_sound";
        }
        
        public final void run()
        {
          AppMethodBeat.i(125378);
          a locala = a.dYq();
          if (locala.zmt != null) {
            locala.zmt.Y(false, 0);
          }
          AppMethodBeat.o(125378);
        }
      });
    }
    this.gAC.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125379);
        b.j(b.this).finish();
        AppMethodBeat.o(125379);
      }
    }, 2000L);
    AppMethodBeat.o(125400);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(125404);
    ad.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.dkt);
    if (this.dkt)
    {
      AppMethodBeat.o(125404);
      return;
    }
    if (this.zDx.tPJ == null)
    {
      this.zDx.w = paramInt1;
      this.zDx.h = paramInt2;
      this.zDx.tPJ = new int[this.zDx.w * this.zDx.h];
    }
    int i;
    if (this.zDl.dWW())
    {
      i = OpenGlRender.FLAG_Mirror;
      if (!this.zDl.dWX()) {
        break label278;
      }
    }
    label278:
    for (int j = OpenGlRender.FLAG_Angle270;; j = OpenGlRender.FLAG_Angle90)
    {
      if (this.zDo)
      {
        ad.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = ".concat(String.valueOf(com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.videoEncodeToSend(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3 + paramInt4))));
        com.tencent.mm.plugin.voip_cs.c.a locala = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE;
        locala.zpa += 1;
      }
      com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.videoEncodeToLocal(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, 0, 75, this.zDx.tPJ);
      if (OpenGlRender.zvx != 1) {
        break label321;
      }
      if (!this.zqu) {
        break label286;
      }
      this.zsj.a(this.zDx.tPJ, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
      AppMethodBeat.o(125404);
      return;
      i = 0;
      break;
    }
    label286:
    this.zsk.a(this.zDx.tPJ, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
    AppMethodBeat.o(125404);
    return;
    label321:
    if (OpenGlRender.zvx == 2)
    {
      if (this.zqu)
      {
        this.zsj.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
        AppMethodBeat.o(125404);
        return;
      }
      this.zsk.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
    }
    AppMethodBeat.o(125404);
  }
  
  public final void atn(String paramString)
  {
    AppMethodBeat.i(125386);
    if (!bt.isNullOrNil(paramString))
    {
      this.zDz = new b();
      if ((this.zDd.itN == null) || (this.zDd.itN.equals(""))) {
        break label81;
      }
    }
    label81:
    for (this.zDA = this.zDd.itN;; this.zDA = paramString)
    {
      com.tencent.e.h.Iye.aP(this.zDz);
      AppMethodBeat.o(125386);
      return;
    }
  }
  
  public final void bOf()
  {
    AppMethodBeat.i(125405);
    ad.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    AppMethodBeat.o(125405);
  }
  
  public final void cGI()
  {
    AppMethodBeat.i(125397);
    this.zDv.stopTimer();
    this.zDw.stopTimer();
    this.zDs.dWc();
    this.zDh.setVisibility(8);
    this.zDg.setText(2131764844);
    this.zDf.setText(2131764832);
    Rb(0);
    this.tSL.setOnClickListener(this);
    if ((this.zDd.zDK != null) && (this.zDd.zDK.equals("1")))
    {
      this.zsi.setVisibility(0);
      this.zqu = true;
      localObject = rK(this.zqu);
      ((MovableVideoView)this.zsi).hU(((Point)localObject).x, ((Point)localObject).y);
      dYz();
    }
    dYy();
    this.zDo = true;
    if (this.tOV == null) {
      this.tOV = new Timer("voip_cs_talking_time");
    }
    if (this.zDm)
    {
      AppMethodBeat.o(125397);
      return;
    }
    if (this.zDn == -1L) {
      this.zDn = bt.aGK();
    }
    this.zDm = true;
    Object localObject = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(125377);
        b.p(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125376);
            String str = b.mz(bt.lZ(b.this.zDn));
            b.l(b.this).setText(str);
            AppMethodBeat.o(125376);
          }
        });
        AppMethodBeat.o(125377);
      }
    };
    this.tOV.schedule((TimerTask)localObject, 1000L, 1000L);
    r.dTT().dTU();
    r.dTT().a(this);
    AppMethodBeat.o(125397);
  }
  
  public final void cGJ()
  {
    AppMethodBeat.i(125403);
    this.zDi.setVisibility(8);
    AppMethodBeat.o(125403);
  }
  
  public final void dYA()
  {
    AppMethodBeat.i(125407);
    if (this.zDy != null)
    {
      ad.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
      this.zDy.zkd = true;
      this.zDy.cancel();
      this.zDy = null;
    }
    AppMethodBeat.o(125407);
  }
  
  public final void dYs()
  {
    AppMethodBeat.i(125383);
    if (this.zDv.eFX())
    {
      av localav = this.zDv;
      long l = this.zDq;
      localav.av(l, l);
    }
    AppMethodBeat.o(125383);
  }
  
  public final void dYt()
  {
    AppMethodBeat.i(125384);
    if (this.zDw.eFX())
    {
      av localav = this.zDw;
      long l = this.zDr;
      localav.av(l, l);
    }
    AppMethodBeat.o(125384);
  }
  
  public final String dYu()
  {
    AppMethodBeat.i(125387);
    String str = "voip_cs_headImageUrl_" + this.zDd.zCW;
    AppMethodBeat.o(125387);
    return str;
  }
  
  public final String dYv()
  {
    AppMethodBeat.i(125388);
    String str = "voip_cs_nickname_" + this.zDd.zCW;
    AppMethodBeat.o(125388);
    return str;
  }
  
  public final void dYw()
  {
    AppMethodBeat.i(125393);
    ad.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
    if (this.tTb == null)
    {
      ad.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
      this.tTb = new ObservableTextureView(this.zDd);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
      this.tTb.setLayoutParams(localLayoutParams);
      this.zDe.addView(this.tTb, new RelativeLayout.LayoutParams(1, 1));
      this.tTb.setVisibility(0);
    }
    if (this.zDl == null)
    {
      ad.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
      this.zDl = new com.tencent.mm.plugin.voip_cs.d.a();
      this.zDl.a(this, true);
      this.zDl.a(this.tTb);
      com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.znH = this.zDl.dWY();
      this.zDl.dWU();
      this.zDl.dYF();
      ad.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.zDl.dWW()), Boolean.valueOf(this.zDl.dWX()) });
    }
    AppMethodBeat.o(125393);
  }
  
  public final void dYx()
  {
    AppMethodBeat.i(125394);
    ad.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
    if (this.tTb != null)
    {
      this.zDe.removeView(this.tTb);
      this.tTb = null;
    }
    if (this.zDl != null)
    {
      this.zDl.dWV();
      this.zDl = null;
    }
    AppMethodBeat.o(125394);
  }
  
  public final void dYz()
  {
    AppMethodBeat.i(125406);
    dYA();
    this.zDy = new c();
    com.tencent.e.h.Iye.aP(this.zDy);
    ad.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    AppMethodBeat.o(125406);
  }
  
  public final void ml(boolean paramBoolean)
  {
    AppMethodBeat.i(125402);
    this.zDi.setVisibility(0);
    this.zDi.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.zDi.setBackgroundResource(2131234566);
    this.zDi.setCompoundDrawables(null, null, null, null);
    this.zDi.setCompoundDrawablePadding(0);
    this.zDi.setText(Rd(1001));
    AppMethodBeat.o(125402);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(125391);
    if (paramView.getId() == 2131306566)
    {
      if (com.tencent.mm.plugin.voip_cs.c.c.dYh().zCV < 2) {}
      for (com.tencent.mm.plugin.voip_cs.c.c.dYi().dataType = 2;; com.tencent.mm.plugin.voip_cs.c.c.dYi().dataType = 4)
      {
        paramView = com.tencent.mm.plugin.voip_cs.c.c.dYi();
        paramView.zBZ = 1;
        paramView.zCv = 1;
        paramView.zCa = ((int)(System.currentTimeMillis() / 1000L));
        paramView = com.tencent.mm.plugin.voip_cs.c.c.dYi();
        ad.d("MicroMsg.VoipCSReportHelper", "selfCancel");
        if (paramView.zCs == 0)
        {
          paramView.zCn = 3;
          if ((paramView.zCw == 0L) && (paramView.zCI != 0)) {
            paramView.zCw = ((int)(System.currentTimeMillis() / 1000L) - paramView.zCI);
          }
        }
        com.tencent.mm.plugin.voip_cs.c.c.dYi().dYj();
        ad.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
        Rc(0);
        AppMethodBeat.o(125391);
        return;
      }
    }
    if (this.tSq.getVisibility() == 0) {}
    for (int i = 8;; i = 0)
    {
      this.tSq.setVisibility(i);
      this.fwS.setVisibility(i);
      this.zDf.setVisibility(i);
      Rb(i);
      if (i == 0) {
        bool = true;
      }
      sd(bool);
      AppMethodBeat.o(125391);
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
  
  public final void setNickName(String paramString)
  {
    AppMethodBeat.i(125385);
    if (this.zDd.zDM) {}
    for (paramString = paramString + aj.getContext().getString(2131764815);; paramString = paramString + aj.getContext().getString(2131764816))
    {
      this.frs.setText(paramString);
      AppMethodBeat.o(125385);
      return;
    }
  }
  
  final class a
  {
    int h;
    int[] tPJ;
    int w;
    
    private a() {}
  }
  
  final class b
    extends com.tencent.e.i.b
  {
    b() {}
    
    public final String getKey()
    {
      return "VOIPCS_netPic";
    }
    
    public final void run()
    {
      AppMethodBeat.i(125380);
      b.this.zDB = b.ato(b.this.zDA);
      Message localMessage = new Message();
      localMessage.what = 12;
      b.t(b.this).sendMessage(localMessage);
      b.this.zDz.cancel();
      AppMethodBeat.o(125380);
    }
  }
  
  final class c
    extends com.tencent.e.i.b
  {
    boolean zkd = false;
    byte[] zke = null;
    
    c() {}
    
    public final String getKey()
    {
      return "VOIPCS_VideoDecode";
    }
    
    public final void run()
    {
      AppMethodBeat.i(125381);
      if ((!this.zkd) && (!b.q(b.this)))
      {
        if (this.zke == null) {
          this.zke = new byte[com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.defaultWidth * com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.defaultHeight * 3 / 2];
        }
        int i;
        int j;
        if (com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.videoDecode(this.zke) == 1)
        {
          i = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.field_remoteImgWidth;
          j = com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.field_remoteImgHeight;
          if (OpenGlRender.zvx != 1) {
            break label198;
          }
          if (!b.h(b.this)) {
            break label166;
          }
          b.r(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.zoA, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
        }
        for (;;)
        {
          try
          {
            Thread.sleep(20L);
          }
          catch (InterruptedException localInterruptedException)
          {
            ad.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", localInterruptedException, "", new Object[0]);
          }
          break;
          label166:
          b.s(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.dYg().zDE.zoA, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
          continue;
          label198:
          if (b.h(b.this)) {
            b.r(b.this).a(this.zke, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
          } else {
            b.s(b.this).a(this.zke, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
          }
        }
      }
      AppMethodBeat.o(125381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a.b
 * JD-Core Version:    0.7.0.1
 */