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
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.b.l;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

public final class b
  implements TextureView.SurfaceTextureListener, View.OnClickListener, r.a, f
{
  protected static final int[] AKc = { -1, 2131764841, 2131764846, 2131764845 };
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  private VoipBigIconButton AIT;
  private View.OnClickListener AJG;
  private boolean AJj;
  private OpenGlView AKS;
  private OpenGlView AKT;
  public OpenGlRender AKU;
  public OpenGlRender AKV;
  protected long AVA;
  private boolean AVB;
  private boolean AVC;
  private int AVD;
  private int AVE;
  private com.tencent.mm.plugin.voip_cs.d.b AVF;
  public String AVG;
  public String AVH;
  private au AVI;
  private au AVJ;
  a AVK;
  c AVL;
  b AVM;
  String AVN;
  Drawable AVO;
  public VoipCSMainUI AVq;
  private RelativeLayout AVr;
  private TextView AVs;
  private TextView AVt;
  private TextView AVu;
  private TextView AVv;
  public ImageView AVw;
  private ao AVx;
  private com.tencent.mm.plugin.voip_cs.d.a AVy;
  private boolean AVz;
  public boolean dhO;
  private TextView fAz;
  public TextView fuZ;
  private ao gox;
  private Timer uXx;
  private ImageButton vaX;
  private ObservableTextureView vbI;
  private View vbs;
  
  public b(VoipCSMainUI paramVoipCSMainUI)
  {
    AppMethodBeat.i(125382);
    this.AJj = false;
    this.dhO = false;
    this.AVz = false;
    this.AVA = -1L;
    this.AVB = false;
    this.AVC = false;
    this.AVD = 60000;
    this.AVE = 5000;
    this.AVF = new com.tencent.mm.plugin.voip_cs.d.b();
    this.AVG = "";
    this.AVH = "";
    this.AVI = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125370);
        ac.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
        com.tencent.mm.plugin.voip_cs.c.c.enE().dataType = 1;
        b.this.Tl(6);
        AppMethodBeat.o(125370);
        return true;
      }
    }, false);
    this.AVJ = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125371);
        b.a(b.this).setText(ai.getContext().getString(2131764848));
        b.b(b.this).setVisibility(0);
        com.tencent.mm.plugin.voip_cs.d.b localb = b.c(b.this);
        TextView localTextView = b.b(b.this);
        Object localObject = b.AKc;
        if ((localObject == null) || (localTextView == null)) {
          ac.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        }
        for (;;)
        {
          AppMethodBeat.o(125371);
          return true;
          localb.elo();
          localb.AKq = 0;
          localb.AKo = ((int[])localObject);
          localb.Up = localTextView;
          localb.AKp = 500;
          if (localb.bYO != null)
          {
            localObject = localb.bYO;
            long l = localb.AKp;
            ((au)localObject).au(l, l);
          }
          ac.l("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(localTextView)), new Object[0]);
        }
      }
    }, false);
    this.AJG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125372);
        ac.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
        b.d(b.this).setEnabled(false);
        if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi > 1) {
          b.e(b.this);
        }
        b.d(b.this).setEnabled(true);
        if (b.f(b.this) != null) {
          b.f(b.this).emn();
        }
        AppMethodBeat.o(125372);
      }
    };
    this.AVK = new a((byte)0);
    this.AVN = "";
    this.AVO = null;
    this.AVq = paramVoipCSMainUI;
    Object localObject = (WindowManager)paramVoipCSMainUI.getSystemService("window");
    int i = ((WindowManager)localObject).getDefaultDisplay().getHeight() / 5;
    int j = ((WindowManager)localObject).getDefaultDisplay().getWidth() * i / ((WindowManager)localObject).getDefaultDisplay().getHeight();
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)paramVoipCSMainUI.findViewById(2131304206)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(paramVoipCSMainUI.getContext(), 40.0F));
    }
    this.AKT = new MovableVideoView(paramVoipCSMainUI.getApplicationContext());
    ((MovableVideoView)this.AKT).ij(j, i);
    this.AKT.setVisibility(8);
    this.AKU = new OpenGlRender(this.AKT, OpenGlRender.RenderRemote);
    this.AKT.setRenderer(this.AKU);
    this.AKT.setRenderMode(0);
    this.fAz = ((TextView)paramVoipCSMainUI.findViewById(2131305822));
    this.fAz.setVisibility(0);
    this.uXx = new Timer("voip_cs_talking_time");
    this.AVs = ((TextView)paramVoipCSMainUI.findViewById(2131306563));
    this.AVs.setVisibility(0);
    this.AVt = ((TextView)paramVoipCSMainUI.findViewById(2131306568));
    if (paramVoipCSMainUI.scene.equals("1")) {
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.AVt.setText(ai.getContext().getString(2131764824));
        this.AVt.setVisibility(0);
        this.fuZ = ((TextView)paramVoipCSMainUI.findViewById(2131306571));
        this.fuZ.setVisibility(0);
        this.AVw = ((ImageView)paramVoipCSMainUI.findViewById(2131306564));
        this.AVw.setVisibility(0);
        this.AVv = ((TextView)paramVoipCSMainUI.findViewById(2131306567));
        this.AVu = ((TextView)paramVoipCSMainUI.findViewById(2131306569));
        this.AIT = ((VoipBigIconButton)paramVoipCSMainUI.findViewById(2131306565));
        if ((paramVoipCSMainUI.AVW == null) || (!paramVoipCSMainUI.AVW.equals("1"))) {
          break label1031;
        }
        this.AIT.setVisibility(0);
        this.AIT.setOnClickListener(this.AJG);
        label567:
        this.gox = new ao();
        this.AVx = new ao()
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
              if (b.this.AVO != null)
              {
                b.g(b.this).setImageDrawable(b.this.AVO);
                AppMethodBeat.o(125373);
                return;
              }
              b.g(b.this).setImageResource(2131231875);
            }
          }
        };
        this.vbs = paramVoipCSMainUI.findViewById(2131306560);
        this.vaX = ((ImageButton)paramVoipCSMainUI.findViewById(2131306566));
        this.AVr = ((RelativeLayout)paramVoipCSMainUI.findViewById(2131306560));
        mScreenWidth = com.tencent.mm.cc.a.ig(paramVoipCSMainUI.getContext());
        mScreenHeight = com.tencent.mm.plugin.voip_cs.d.c.gE(paramVoipCSMainUI.getContext());
        this.AKS = ((OpenGlView)paramVoipCSMainUI.findViewById(2131306561));
        this.AKS.ik(mScreenWidth, mScreenHeight);
        this.AKV = new OpenGlRender(this.AKS, OpenGlRender.RenderLocal);
        this.AKS.setRenderer(this.AKV);
        this.AKS.setRenderMode(0);
        this.AKS.setVisibility(0);
        ac.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[] { Integer.valueOf(mScreenHeight) });
        this.vaX.setOnClickListener(this);
        this.AVr.addView(this.AKT);
        this.AKT.setOnClickListener(new View.OnClickListener()
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
              b.i(b.this).il(paramAnonymousView.x, paramAnonymousView.y);
              AppMethodBeat.o(125374);
              return;
            }
          }
        });
        this.AKU.onStarted();
        this.AKV.onStarted();
        if (!l.gy(ai.getContext())) {
          l.gz(ai.getContext());
        }
        paramVoipCSMainUI = ai.eUY();
        this.AVG = paramVoipCSMainUI.getString(enQ(), "");
        if ((this.AVq.iTS == null) || (this.AVq.iTS.equals(""))) {
          break label1043;
        }
        ayF(this.AVq.iTS);
      }
    }
    for (;;)
    {
      this.AVH = paramVoipCSMainUI.getString(enR(), "");
      if (!bs.isNullOrNil(this.AVH)) {
        setNickName(this.AVH);
      }
      paramVoipCSMainUI = com.tencent.mm.plugin.voip_cs.c.c.enD();
      localObject = this.AVq.AVj;
      ac.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:".concat(String.valueOf(localObject)));
      com.tencent.mm.kernel.g.agi().a(106, paramVoipCSMainUI);
      paramVoipCSMainUI = new com.tencent.mm.plugin.messenger.a.g((String)localObject);
      com.tencent.mm.kernel.g.agi().a(paramVoipCSMainUI, 0);
      AppMethodBeat.o(125382);
      return;
      this.AVt.setText(ai.getContext().getString(2131764825));
      break;
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.AVt.setText(ai.getContext().getString(2131764826));
        break;
      }
      this.AVt.setText(ai.getContext().getString(2131764825));
      break;
      label1031:
      this.AIT.setVisibility(8);
      break label567;
      label1043:
      if (!bs.isNullOrNil(this.AVG)) {
        ayF(this.AVG);
      }
    }
  }
  
  private void Tk(int paramInt)
  {
    AppMethodBeat.i(125392);
    if ((this.AVq.AVW != null) && (this.AVq.AVW.equals("1")))
    {
      this.AIT.setVisibility(paramInt);
      AppMethodBeat.o(125392);
      return;
    }
    this.AIT.setVisibility(8);
    AppMethodBeat.o(125392);
  }
  
  private static int Tm(int paramInt)
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
    if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi < 2)
    {
      AppMethodBeat.o(125401);
      return 2131764819;
    }
    AppMethodBeat.o(125401);
    return 2131764828;
  }
  
  public static Drawable ayG(String paramString)
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
      ac.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
      AppMethodBeat.o(125398);
    }
    return null;
  }
  
  private void enU()
  {
    AppMethodBeat.i(125395);
    ac.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
    this.gox.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125375);
        ac.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
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
  
  protected static String qn(long paramLong)
  {
    AppMethodBeat.i(125399);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(125399);
    return str;
  }
  
  private static float sG(boolean paramBoolean)
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
        localObject = com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.field_capInfo;
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
          ac.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
          f2 = f1;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        ac.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + localException.getMessage());
        continue;
      }
      AppMethodBeat.o(125390);
      return f2;
      f2 = f1;
      localObject = com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.AGi;
    }
  }
  
  private Point sL(boolean paramBoolean)
  {
    AppMethodBeat.i(125389);
    int i = ((WindowManager)this.AVq.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
    float f = i;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Point localPoint = new Point((int)(sG(paramBoolean) * f), i);
      AppMethodBeat.o(125389);
      return localPoint;
    }
  }
  
  private void te(boolean paramBoolean)
  {
    AppMethodBeat.i(125396);
    if (Build.MANUFACTURER.equalsIgnoreCase("sony"))
    {
      ac.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
      AppMethodBeat.o(125396);
      return;
    }
    if (!paramBoolean)
    {
      this.AVq.getWindow().setFlags(1024, 1024);
      AppMethodBeat.o(125396);
      return;
    }
    this.AVq.getWindow().clearFlags(1024);
    AppMethodBeat.o(125396);
  }
  
  public final void Tl(int paramInt)
  {
    AppMethodBeat.i(125400);
    ac.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:".concat(String.valueOf(paramInt)));
    if (this.uXx != null)
    {
      this.uXx.cancel();
      this.uXx = null;
    }
    if (!this.AVI.eVs()) {
      this.AVI.stopTimer();
    }
    if (!this.AVJ.eVs()) {
      this.AVJ.stopTimer();
    }
    this.AVF.elo();
    this.AVz = false;
    this.AVv.setVisibility(0);
    this.AVv.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.AVv.setBackgroundResource(2131234566);
    this.AVv.setCompoundDrawables(null, null, null, null);
    this.AVv.setCompoundDrawablePadding(0);
    this.AVv.setText(Tm(paramInt));
    if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi == 2) {
      com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "VoipCS_play_end_sound";
        }
        
        public final void run()
        {
          AppMethodBeat.i(125378);
          a locala = a.enM();
          if (locala.oue != null) {
            locala.oue.T(false, 0);
          }
          AppMethodBeat.o(125378);
        }
      });
    }
    this.gox.postDelayed(new Runnable()
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
    ac.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.dhO);
    if (this.dhO)
    {
      AppMethodBeat.o(125404);
      return;
    }
    if (this.AVK.uYj == null)
    {
      this.AVK.w = paramInt1;
      this.AVK.h = paramInt2;
      this.AVK.uYj = new int[this.AVK.w * this.AVK.h];
    }
    int i;
    if (this.AVy.emq())
    {
      i = OpenGlRender.FLAG_Mirror;
      if (!this.AVy.emr()) {
        break label278;
      }
    }
    label278:
    for (int j = OpenGlRender.FLAG_Angle270;; j = OpenGlRender.FLAG_Angle90)
    {
      if (this.AVB)
      {
        ac.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = ".concat(String.valueOf(com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.videoEncodeToSend(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3 + paramInt4))));
        com.tencent.mm.plugin.voip_cs.c.a locala = com.tencent.mm.plugin.voip_cs.c.c.enC().AVR;
        locala.AHP += 1;
      }
      com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.videoEncodeToLocal(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, 0, 75, this.AVK.uYj);
      if (OpenGlRender.AOo != 1) {
        break label321;
      }
      if (!this.AJj) {
        break label286;
      }
      this.AKU.a(this.AVK.uYj, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
      AppMethodBeat.o(125404);
      return;
      i = 0;
      break;
    }
    label286:
    this.AKV.a(this.AVK.uYj, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
    AppMethodBeat.o(125404);
    return;
    label321:
    if (OpenGlRender.AOo == 2)
    {
      if (this.AJj)
      {
        this.AKU.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
        AppMethodBeat.o(125404);
        return;
      }
      this.AKV.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
    }
    AppMethodBeat.o(125404);
  }
  
  public final void ayF(String paramString)
  {
    AppMethodBeat.i(125386);
    if (!bs.isNullOrNil(paramString))
    {
      this.AVM = new b();
      if ((this.AVq.iTS == null) || (this.AVq.iTS.equals(""))) {
        break label81;
      }
    }
    label81:
    for (this.AVN = this.AVq.iTS;; this.AVN = paramString)
    {
      com.tencent.e.h.JZN.aS(this.AVM);
      AppMethodBeat.o(125386);
      return;
    }
  }
  
  public final void bVs()
  {
    AppMethodBeat.i(125405);
    ac.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    AppMethodBeat.o(125405);
  }
  
  public final void cTS()
  {
    AppMethodBeat.i(125397);
    this.AVI.stopTimer();
    this.AVJ.stopTimer();
    this.AVF.elo();
    this.AVu.setVisibility(8);
    this.AVt.setText(2131764844);
    this.AVs.setText(2131764832);
    Tk(0);
    this.vbs.setOnClickListener(this);
    if ((this.AVq.AVX != null) && (this.AVq.AVX.equals("1")))
    {
      this.AKT.setVisibility(0);
      this.AJj = true;
      localObject = sL(this.AJj);
      ((MovableVideoView)this.AKT).ij(((Point)localObject).x, ((Point)localObject).y);
      enV();
    }
    enU();
    this.AVB = true;
    if (this.uXx == null) {
      this.uXx = new Timer("voip_cs_talking_time");
    }
    if (this.AVz)
    {
      AppMethodBeat.o(125397);
      return;
    }
    if (this.AVA == -1L) {
      this.AVA = bs.aNx();
    }
    this.AVz = true;
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
            String str = b.qn(bs.pN(b.this.AVA));
            b.l(b.this).setText(str);
            AppMethodBeat.o(125376);
          }
        });
        AppMethodBeat.o(125377);
      }
    };
    this.uXx.schedule((TimerTask)localObject, 1000L, 1000L);
    r.ejf().ejg();
    r.ejf().a(this);
    AppMethodBeat.o(125397);
  }
  
  public final void cTT() {}
  
  public final void cTU()
  {
    AppMethodBeat.i(125403);
    this.AVv.setVisibility(8);
    AppMethodBeat.o(125403);
  }
  
  public final void enO()
  {
    AppMethodBeat.i(125383);
    if (this.AVI.eVs())
    {
      au localau = this.AVI;
      long l = this.AVD;
      localau.au(l, l);
    }
    AppMethodBeat.o(125383);
  }
  
  public final void enP()
  {
    AppMethodBeat.i(125384);
    if (this.AVJ.eVs())
    {
      au localau = this.AVJ;
      long l = this.AVE;
      localau.au(l, l);
    }
    AppMethodBeat.o(125384);
  }
  
  public final String enQ()
  {
    AppMethodBeat.i(125387);
    String str = "voip_cs_headImageUrl_" + this.AVq.AVj;
    AppMethodBeat.o(125387);
    return str;
  }
  
  public final String enR()
  {
    AppMethodBeat.i(125388);
    String str = "voip_cs_nickname_" + this.AVq.AVj;
    AppMethodBeat.o(125388);
    return str;
  }
  
  public final void enS()
  {
    AppMethodBeat.i(125393);
    ac.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
    if (this.vbI == null)
    {
      ac.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
      this.vbI = new ObservableTextureView(this.AVq);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
      this.vbI.setLayoutParams(localLayoutParams);
      this.AVr.addView(this.vbI, new RelativeLayout.LayoutParams(1, 1));
      this.vbI.setVisibility(0);
    }
    if (this.AVy == null)
    {
      ac.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
      this.AVy = new com.tencent.mm.plugin.voip_cs.d.a();
      this.AVy.a(this, true);
      this.AVy.a(this.vbI);
      com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.AGv = this.AVy.ems();
      this.AVy.emo();
      this.AVy.eob();
      ac.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.AVy.emq()), Boolean.valueOf(this.AVy.emr()) });
    }
    AppMethodBeat.o(125393);
  }
  
  public final void enT()
  {
    AppMethodBeat.i(125394);
    ac.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
    if (this.vbI != null)
    {
      this.AVr.removeView(this.vbI);
      this.vbI = null;
    }
    if (this.AVy != null)
    {
      this.AVy.emp();
      this.AVy = null;
    }
    AppMethodBeat.o(125394);
  }
  
  public final void enV()
  {
    AppMethodBeat.i(125406);
    enW();
    this.AVL = new c();
    com.tencent.e.h.JZN.aS(this.AVL);
    ac.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    AppMethodBeat.o(125406);
  }
  
  public final void enW()
  {
    AppMethodBeat.i(125407);
    if (this.AVL != null)
    {
      ac.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
      this.AVL.ACN = true;
      this.AVL.cancel();
      this.AVL = null;
    }
    AppMethodBeat.o(125407);
  }
  
  public final void ne(boolean paramBoolean)
  {
    AppMethodBeat.i(125402);
    this.AVv.setVisibility(0);
    this.AVv.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.AVv.setBackgroundResource(2131234566);
    this.AVv.setCompoundDrawables(null, null, null, null);
    this.AVv.setCompoundDrawablePadding(0);
    this.AVv.setText(Tm(1001));
    AppMethodBeat.o(125402);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(125391);
    if (paramView.getId() == 2131306566)
    {
      if (com.tencent.mm.plugin.voip_cs.c.c.enD().AVi < 2) {}
      for (com.tencent.mm.plugin.voip_cs.c.c.enE().dataType = 2;; com.tencent.mm.plugin.voip_cs.c.c.enE().dataType = 4)
      {
        paramView = com.tencent.mm.plugin.voip_cs.c.c.enE();
        paramView.AUn = 1;
        paramView.AUI = 1;
        paramView.AUo = ((int)(System.currentTimeMillis() / 1000L));
        paramView = com.tencent.mm.plugin.voip_cs.c.c.enE();
        ac.d("MicroMsg.VoipCSReportHelper", "selfCancel");
        if (paramView.AUF == 0)
        {
          paramView.AUA = 3;
          if ((paramView.AUJ == 0L) && (paramView.AUV != 0)) {
            paramView.AUJ = ((int)(System.currentTimeMillis() / 1000L) - paramView.AUV);
          }
        }
        com.tencent.mm.plugin.voip_cs.c.c.enE().enF();
        ac.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
        Tl(0);
        AppMethodBeat.o(125391);
        return;
      }
    }
    if (this.vaX.getVisibility() == 0) {}
    for (int i = 8;; i = 0)
    {
      this.vaX.setVisibility(i);
      this.fAz.setVisibility(i);
      this.AVs.setVisibility(i);
      Tk(i);
      if (i == 0) {
        bool = true;
      }
      te(bool);
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
    if (this.AVq.AVZ) {}
    for (paramString = paramString + ai.getContext().getString(2131764815);; paramString = paramString + ai.getContext().getString(2131764816))
    {
      this.fuZ.setText(paramString);
      AppMethodBeat.o(125385);
      return;
    }
  }
  
  final class a
  {
    int h;
    int[] uYj;
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
      b.this.AVO = b.ayG(b.this.AVN);
      Message localMessage = new Message();
      localMessage.what = 12;
      b.t(b.this).sendMessage(localMessage);
      b.this.AVM.cancel();
      AppMethodBeat.o(125380);
    }
  }
  
  final class c
    extends com.tencent.e.i.b
  {
    boolean ACN = false;
    byte[] ACO = null;
    
    c() {}
    
    public final String getKey()
    {
      return "VOIPCS_VideoDecode";
    }
    
    public final void run()
    {
      AppMethodBeat.i(125381);
      if ((!this.ACN) && (!b.q(b.this)))
      {
        if (this.ACO == null) {
          this.ACO = new byte[com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.defaultWidth * com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.defaultHeight * 3 / 2];
        }
        int i;
        int j;
        if (com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.videoDecode(this.ACO) == 1)
        {
          i = com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.field_remoteImgWidth;
          j = com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.field_remoteImgHeight;
          if (OpenGlRender.AOo != 1) {
            break label198;
          }
          if (!b.h(b.this)) {
            break label166;
          }
          b.r(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.AHp, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
        }
        for (;;)
        {
          try
          {
            Thread.sleep(20L);
          }
          catch (InterruptedException localInterruptedException)
          {
            ac.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", localInterruptedException, "", new Object[0]);
          }
          break;
          label166:
          b.s(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.enC().AVR.AHp, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
          continue;
          label198:
          if (b.h(b.this)) {
            b.r(b.this).a(this.ACO, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
          } else {
            b.s(b.this).a(this.ACO, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
          }
        }
      }
      AppMethodBeat.o(125381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a.b
 * JD-Core Version:    0.7.0.1
 */