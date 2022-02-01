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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.cs.MovableVideoView;
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
  implements TextureView.SurfaceTextureListener, View.OnClickListener, r.a, com.tencent.mm.plugin.voip.video.f
{
  protected static final int[] Cje = { -1, 2131764841, 2131764846, 2131764845 };
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  private VoipBigIconButton ChU;
  private View.OnClickListener CiH;
  private boolean Cik;
  private OpenGlView CjU;
  private OpenGlView CjV;
  public OpenGlRender CjW;
  public OpenGlRender CjX;
  private TextView CvA;
  private TextView CvB;
  private TextView CvC;
  private TextView CvD;
  public ImageView CvE;
  private ap CvF;
  private com.tencent.mm.plugin.voip_cs.d.a CvG;
  private boolean CvH;
  protected long CvI;
  private boolean CvJ;
  private boolean CvK;
  private int CvL;
  private int CvM;
  private com.tencent.mm.plugin.voip_cs.d.b CvN;
  public String CvO;
  public String CvP;
  private av CvQ;
  private av CvR;
  a CvS;
  c CvT;
  b CvU;
  String CvV;
  Drawable CvW;
  public VoipCSMainUI Cvy;
  private RelativeLayout Cvz;
  private Timer cNY;
  public boolean dtm;
  public TextView fOg;
  private TextView fTP;
  private ap gIf;
  private View wgB;
  private ObservableTextureView wgP;
  private ImageButton wgg;
  
  public b(VoipCSMainUI paramVoipCSMainUI)
  {
    AppMethodBeat.i(125382);
    this.Cik = false;
    this.dtm = false;
    this.CvH = false;
    this.CvI = -1L;
    this.CvJ = false;
    this.CvK = false;
    this.CvL = 60000;
    this.CvM = 5000;
    this.CvN = new com.tencent.mm.plugin.voip_cs.d.b();
    this.CvO = "";
    this.CvP = "";
    this.CvQ = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125370);
        ad.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
        com.tencent.mm.plugin.voip_cs.c.c.eBD().dataType = 1;
        b.this.Ve(6);
        AppMethodBeat.o(125370);
        return true;
      }
    }, false);
    this.CvR = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125371);
        b.a(b.this).setText(aj.getContext().getString(2131764848));
        b.b(b.this).setVisibility(0);
        com.tencent.mm.plugin.voip_cs.d.b localb = b.c(b.this);
        TextView localTextView = b.b(b.this);
        Object localObject = b.Cje;
        if ((localObject == null) || (localTextView == null)) {
          ad.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        }
        for (;;)
        {
          AppMethodBeat.o(125371);
          return true;
          localb.eyY();
          localb.Cjs = 0;
          localb.Cjq = ((int[])localObject);
          localb.Wf = localTextView;
          localb.Cjr = 500;
          if (localb.cjg != null)
          {
            localObject = localb.cjg;
            long l = localb.Cjr;
            ((av)localObject).az(l, l);
          }
          ad.l("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(localTextView)), new Object[0]);
        }
      }
    }, false);
    this.CiH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125372);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
        b.d(b.this).setEnabled(false);
        if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq > 1) {
          b.e(b.this);
        }
        b.d(b.this).setEnabled(true);
        if (b.f(b.this) != null) {
          b.f(b.this).eAi();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125372);
      }
    };
    this.CvS = new a((byte)0);
    this.CvV = "";
    this.CvW = null;
    this.Cvy = paramVoipCSMainUI;
    Object localObject = (WindowManager)paramVoipCSMainUI.getSystemService("window");
    int i = ((WindowManager)localObject).getDefaultDisplay().getHeight() / 5;
    int j = ((WindowManager)localObject).getDefaultDisplay().getWidth() * i / ((WindowManager)localObject).getDefaultDisplay().getHeight();
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)paramVoipCSMainUI.findViewById(2131304206)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(paramVoipCSMainUI.getContext(), 40.0F));
    }
    this.CjV = new MovableVideoView(paramVoipCSMainUI.getApplicationContext());
    ((MovableVideoView)this.CjV).iw(j, i);
    this.CjV.setVisibility(8);
    this.CjW = new OpenGlRender(this.CjV, OpenGlRender.RenderRemote);
    this.CjV.setRenderer(this.CjW);
    this.CjV.setRenderMode(0);
    this.fTP = ((TextView)paramVoipCSMainUI.findViewById(2131305822));
    this.fTP.setVisibility(0);
    this.cNY = new Timer("voip_cs_talking_time");
    this.CvA = ((TextView)paramVoipCSMainUI.findViewById(2131306563));
    this.CvA.setVisibility(0);
    this.CvB = ((TextView)paramVoipCSMainUI.findViewById(2131306568));
    if (paramVoipCSMainUI.scene.equals("1")) {
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.CvB.setText(aj.getContext().getString(2131764824));
        this.CvB.setVisibility(0);
        this.fOg = ((TextView)paramVoipCSMainUI.findViewById(2131306571));
        this.fOg.setVisibility(0);
        this.CvE = ((ImageView)paramVoipCSMainUI.findViewById(2131306564));
        this.CvE.setVisibility(0);
        this.CvD = ((TextView)paramVoipCSMainUI.findViewById(2131306567));
        this.CvC = ((TextView)paramVoipCSMainUI.findViewById(2131306569));
        this.ChU = ((VoipBigIconButton)paramVoipCSMainUI.findViewById(2131306565));
        if ((paramVoipCSMainUI.Cwe == null) || (!paramVoipCSMainUI.Cwe.equals("1"))) {
          break label1031;
        }
        this.ChU.setVisibility(0);
        this.ChU.setOnClickListener(this.CiH);
        label567:
        this.gIf = new ap();
        this.CvF = new ap()
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
              if (b.this.CvW != null)
              {
                b.g(b.this).setImageDrawable(b.this.CvW);
                AppMethodBeat.o(125373);
                return;
              }
              b.g(b.this).setImageResource(2131231875);
            }
          }
        };
        this.wgB = paramVoipCSMainUI.findViewById(2131306560);
        this.wgg = ((ImageButton)paramVoipCSMainUI.findViewById(2131306566));
        this.Cvz = ((RelativeLayout)paramVoipCSMainUI.findViewById(2131306560));
        mScreenWidth = com.tencent.mm.cc.a.ip(paramVoipCSMainUI.getContext());
        mScreenHeight = com.tencent.mm.plugin.voip_cs.d.c.gI(paramVoipCSMainUI.getContext());
        this.CjU = ((OpenGlView)paramVoipCSMainUI.findViewById(2131306561));
        this.CjU.ix(mScreenWidth, mScreenHeight);
        this.CjX = new OpenGlRender(this.CjU, OpenGlRender.RenderLocal);
        this.CjU.setRenderer(this.CjX);
        this.CjU.setRenderMode(0);
        this.CjU.setVisibility(0);
        ad.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[] { Integer.valueOf(mScreenHeight) });
        this.wgg.setOnClickListener(this);
        this.Cvz.addView(this.CjV);
        this.CjV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125374);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = b.this;
            if (!b.h(b.this)) {}
            for (boolean bool = true;; bool = false)
            {
              b.a(paramAnonymousView, bool);
              paramAnonymousView = b.b(b.this, b.h(b.this));
              b.i(b.this).iy(paramAnonymousView.x, paramAnonymousView.y);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(125374);
              return;
            }
          }
        });
        this.CjW.onStarted();
        this.CjX.onStarted();
        if (!n.gC(aj.getContext())) {
          n.gD(aj.getContext());
        }
        paramVoipCSMainUI = aj.fkD();
        this.CvO = paramVoipCSMainUI.getString(eBP(), "");
        if ((this.Cvy.jna == null) || (this.Cvy.jna.equals(""))) {
          break label1043;
        }
        aDN(this.Cvy.jna);
      }
    }
    for (;;)
    {
      this.CvP = paramVoipCSMainUI.getString(eBQ(), "");
      if (!bt.isNullOrNil(this.CvP)) {
        setNickName(this.CvP);
      }
      paramVoipCSMainUI = com.tencent.mm.plugin.voip_cs.c.c.eBC();
      localObject = this.Cvy.Cvr;
      ad.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:".concat(String.valueOf(localObject)));
      g.aiU().a(106, paramVoipCSMainUI);
      paramVoipCSMainUI = new com.tencent.mm.plugin.messenger.a.f((String)localObject);
      g.aiU().a(paramVoipCSMainUI, 0);
      AppMethodBeat.o(125382);
      return;
      this.CvB.setText(aj.getContext().getString(2131764825));
      break;
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.CvB.setText(aj.getContext().getString(2131764826));
        break;
      }
      this.CvB.setText(aj.getContext().getString(2131764825));
      break;
      label1031:
      this.ChU.setVisibility(8);
      break label567;
      label1043:
      if (!bt.isNullOrNil(this.CvO)) {
        aDN(this.CvO);
      }
    }
  }
  
  private void Vd(int paramInt)
  {
    AppMethodBeat.i(125392);
    if ((this.Cvy.Cwe != null) && (this.Cvy.Cwe.equals("1")))
    {
      this.ChU.setVisibility(paramInt);
      AppMethodBeat.o(125392);
      return;
    }
    this.ChU.setVisibility(8);
    AppMethodBeat.o(125392);
  }
  
  private static int Vf(int paramInt)
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
    if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq < 2)
    {
      AppMethodBeat.o(125401);
      return 2131764819;
    }
    AppMethodBeat.o(125401);
    return 2131764828;
  }
  
  public static Drawable aDO(String paramString)
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
  
  private void eBT()
  {
    AppMethodBeat.i(125395);
    ad.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
    this.gIf.postDelayed(new Runnable()
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
  
  protected static String sm(long paramLong)
  {
    AppMethodBeat.i(125399);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(125399);
    return str;
  }
  
  private void tO(boolean paramBoolean)
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
      this.Cvy.getWindow().setFlags(1024, 1024);
      AppMethodBeat.o(125396);
      return;
    }
    this.Cvy.getWindow().clearFlags(1024);
    AppMethodBeat.o(125396);
  }
  
  private static float tp(boolean paramBoolean)
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
        localObject = com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.field_capInfo;
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
      localObject = com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.Cfi;
    }
  }
  
  private Point tu(boolean paramBoolean)
  {
    AppMethodBeat.i(125389);
    int i = ((WindowManager)this.Cvy.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
    float f = i;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Point localPoint = new Point((int)(tp(paramBoolean) * f), i);
      AppMethodBeat.o(125389);
      return localPoint;
    }
  }
  
  public final void Ve(int paramInt)
  {
    AppMethodBeat.i(125400);
    ad.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:".concat(String.valueOf(paramInt)));
    if (this.cNY != null)
    {
      this.cNY.cancel();
      this.cNY = null;
    }
    if (!this.CvQ.fkZ()) {
      this.CvQ.stopTimer();
    }
    if (!this.CvR.fkZ()) {
      this.CvR.stopTimer();
    }
    this.CvN.eyY();
    this.CvH = false;
    this.CvD.setVisibility(0);
    this.CvD.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.CvD.setBackgroundResource(2131234566);
    this.CvD.setCompoundDrawables(null, null, null, null);
    this.CvD.setCompoundDrawablePadding(0);
    this.CvD.setText(Vf(paramInt));
    if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq == 2) {
      com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "VoipCS_play_end_sound";
        }
        
        public final void run()
        {
          AppMethodBeat.i(125378);
          a locala = a.eBL();
          if (locala.oXA != null) {
            locala.oXA.U(false, 0);
          }
          AppMethodBeat.o(125378);
        }
      });
    }
    this.gIf.postDelayed(new Runnable()
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
    ad.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.dtm);
    if (this.dtm)
    {
      AppMethodBeat.o(125404);
      return;
    }
    if (this.CvS.whe == null)
    {
      this.CvS.w = paramInt1;
      this.CvS.h = paramInt2;
      this.CvS.whe = new int[this.CvS.w * this.CvS.h];
    }
    int i;
    if (this.CvG.eAm())
    {
      i = OpenGlRender.FLAG_Mirror;
      if (!this.CvG.eAn()) {
        break label278;
      }
    }
    label278:
    for (int j = OpenGlRender.FLAG_Angle270;; j = OpenGlRender.FLAG_Angle90)
    {
      if (this.CvJ)
      {
        ad.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = ".concat(String.valueOf(com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.videoEncodeToSend(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3 + paramInt4))));
        com.tencent.mm.plugin.voip_cs.c.a locala = com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ;
        locala.CgQ += 1;
      }
      com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.videoEncodeToLocal(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, 0, 75, this.CvS.whe);
      if (OpenGlRender.CnB != 1) {
        break label321;
      }
      if (!this.Cik) {
        break label286;
      }
      this.CjW.a(this.CvS.whe, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
      AppMethodBeat.o(125404);
      return;
      i = 0;
      break;
    }
    label286:
    this.CjX.a(this.CvS.whe, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
    AppMethodBeat.o(125404);
    return;
    label321:
    if (OpenGlRender.CnB == 2)
    {
      if (this.Cik)
      {
        this.CjW.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
        AppMethodBeat.o(125404);
        return;
      }
      this.CjX.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
    }
    AppMethodBeat.o(125404);
  }
  
  public final void aDN(String paramString)
  {
    AppMethodBeat.i(125386);
    if (!bt.isNullOrNil(paramString))
    {
      this.CvU = new b();
      if ((this.Cvy.jna == null) || (this.Cvy.jna.equals(""))) {
        break label81;
      }
    }
    label81:
    for (this.CvV = this.Cvy.jna;; this.CvV = paramString)
    {
      com.tencent.e.h.LTJ.aR(this.CvU);
      AppMethodBeat.o(125386);
      return;
    }
  }
  
  public final void bZW()
  {
    AppMethodBeat.i(125405);
    ad.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    AppMethodBeat.o(125405);
  }
  
  public final void ddd()
  {
    AppMethodBeat.i(125397);
    this.CvQ.stopTimer();
    this.CvR.stopTimer();
    this.CvN.eyY();
    this.CvC.setVisibility(8);
    this.CvB.setText(2131764844);
    this.CvA.setText(2131764832);
    Vd(0);
    this.wgB.setOnClickListener(this);
    if ((this.Cvy.Cwf != null) && (this.Cvy.Cwf.equals("1")))
    {
      this.CjV.setVisibility(0);
      this.Cik = true;
      localObject = tu(this.Cik);
      ((MovableVideoView)this.CjV).iw(((Point)localObject).x, ((Point)localObject).y);
      eBU();
    }
    eBT();
    this.CvJ = true;
    if (this.cNY == null) {
      this.cNY = new Timer("voip_cs_talking_time");
    }
    if (this.CvH)
    {
      AppMethodBeat.o(125397);
      return;
    }
    if (this.CvI == -1L) {
      this.CvI = bt.aQJ();
    }
    this.CvH = true;
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
            String str = b.sm(bt.rM(b.this.CvI));
            b.l(b.this).setText(str);
            AppMethodBeat.o(125376);
          }
        });
        AppMethodBeat.o(125377);
      }
    };
    this.cNY.schedule((TimerTask)localObject, 1000L, 1000L);
    r.ewQ().ewR();
    r.ewQ().a(this);
    AppMethodBeat.o(125397);
  }
  
  public final void dde() {}
  
  public final void ddf()
  {
    AppMethodBeat.i(125403);
    this.CvD.setVisibility(8);
    AppMethodBeat.o(125403);
  }
  
  public final void eBN()
  {
    AppMethodBeat.i(125383);
    if (this.CvQ.fkZ())
    {
      av localav = this.CvQ;
      long l = this.CvL;
      localav.az(l, l);
    }
    AppMethodBeat.o(125383);
  }
  
  public final void eBO()
  {
    AppMethodBeat.i(125384);
    if (this.CvR.fkZ())
    {
      av localav = this.CvR;
      long l = this.CvM;
      localav.az(l, l);
    }
    AppMethodBeat.o(125384);
  }
  
  public final String eBP()
  {
    AppMethodBeat.i(125387);
    String str = "voip_cs_headImageUrl_" + this.Cvy.Cvr;
    AppMethodBeat.o(125387);
    return str;
  }
  
  public final String eBQ()
  {
    AppMethodBeat.i(125388);
    String str = "voip_cs_nickname_" + this.Cvy.Cvr;
    AppMethodBeat.o(125388);
    return str;
  }
  
  public final void eBR()
  {
    AppMethodBeat.i(125393);
    ad.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
    if (this.wgP == null)
    {
      ad.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
      this.wgP = new ObservableTextureView(this.Cvy);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
      this.wgP.setLayoutParams(localLayoutParams);
      this.Cvz.addView(this.wgP, new RelativeLayout.LayoutParams(1, 1));
      this.wgP.setVisibility(0);
    }
    if (this.CvG == null)
    {
      ad.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
      this.CvG = new com.tencent.mm.plugin.voip_cs.d.a();
      this.CvG.a(this, true);
      this.CvG.a(this.wgP);
      com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.Cfv = this.CvG.eAo();
      this.CvG.eAk();
      this.CvG.eCa();
      ad.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.CvG.eAm()), Boolean.valueOf(this.CvG.eAn()) });
    }
    AppMethodBeat.o(125393);
  }
  
  public final void eBS()
  {
    AppMethodBeat.i(125394);
    ad.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
    if (this.wgP != null)
    {
      this.Cvz.removeView(this.wgP);
      this.wgP = null;
    }
    if (this.CvG != null)
    {
      this.CvG.eAl();
      this.CvG = null;
    }
    AppMethodBeat.o(125394);
  }
  
  public final void eBU()
  {
    AppMethodBeat.i(125406);
    eBV();
    this.CvT = new c();
    com.tencent.e.h.LTJ.aR(this.CvT);
    ad.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    AppMethodBeat.o(125406);
  }
  
  public final void eBV()
  {
    AppMethodBeat.i(125407);
    if (this.CvT != null)
    {
      ad.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
      this.CvT.CbO = true;
      this.CvT.cancel();
      this.CvT = null;
    }
    AppMethodBeat.o(125407);
  }
  
  public final void ny(boolean paramBoolean)
  {
    AppMethodBeat.i(125402);
    this.CvD.setVisibility(0);
    this.CvD.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.CvD.setBackgroundResource(2131234566);
    this.CvD.setCompoundDrawables(null, null, null, null);
    this.CvD.setCompoundDrawablePadding(0);
    this.CvD.setText(Vf(1001));
    AppMethodBeat.o(125402);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(125391);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (paramView.getId() == 2131306566)
    {
      if (com.tencent.mm.plugin.voip_cs.c.c.eBC().Cvq < 2) {}
      for (com.tencent.mm.plugin.voip_cs.c.c.eBD().dataType = 2;; com.tencent.mm.plugin.voip_cs.c.c.eBD().dataType = 4)
      {
        paramView = com.tencent.mm.plugin.voip_cs.c.c.eBD();
        paramView.Cuv = 1;
        paramView.CuQ = 1;
        paramView.Cuw = ((int)(System.currentTimeMillis() / 1000L));
        paramView = com.tencent.mm.plugin.voip_cs.c.c.eBD();
        ad.d("MicroMsg.VoipCSReportHelper", "selfCancel");
        if (paramView.CuN == 0)
        {
          paramView.CuI = 3;
          if ((paramView.CuR == 0L) && (paramView.Cvd != 0)) {
            paramView.CuR = ((int)(System.currentTimeMillis() / 1000L) - paramView.Cvd);
          }
        }
        com.tencent.mm.plugin.voip_cs.c.c.eBD().eBE();
        ad.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
        Ve(0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125391);
        return;
      }
    }
    if (this.wgg.getVisibility() == 0) {}
    for (int i = 8;; i = 0)
    {
      this.wgg.setVisibility(i);
      this.fTP.setVisibility(i);
      this.CvA.setVisibility(i);
      Vd(i);
      if (i == 0) {
        bool = true;
      }
      tO(bool);
      break;
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
    if (this.Cvy.Cwh) {}
    for (paramString = paramString + aj.getContext().getString(2131764815);; paramString = paramString + aj.getContext().getString(2131764816))
    {
      this.fOg.setText(paramString);
      AppMethodBeat.o(125385);
      return;
    }
  }
  
  final class a
  {
    int h;
    int w;
    int[] whe;
    
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
      b.this.CvW = b.aDO(b.this.CvV);
      Message localMessage = new Message();
      localMessage.what = 12;
      b.t(b.this).sendMessage(localMessage);
      b.this.CvU.cancel();
      AppMethodBeat.o(125380);
    }
  }
  
  final class c
    extends com.tencent.e.i.b
  {
    boolean CbO = false;
    byte[] CbP = null;
    
    c() {}
    
    public final String getKey()
    {
      return "VOIPCS_VideoDecode";
    }
    
    public final void run()
    {
      AppMethodBeat.i(125381);
      if ((!this.CbO) && (!b.q(b.this)))
      {
        if (this.CbP == null) {
          this.CbP = new byte[com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.defaultWidth * com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.defaultHeight * 3 / 2];
        }
        int i;
        int j;
        if (com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.videoDecode(this.CbP) == 1)
        {
          i = com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.field_remoteImgWidth;
          j = com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.field_remoteImgHeight;
          if (OpenGlRender.CnB != 1) {
            break label198;
          }
          if (!b.h(b.this)) {
            break label166;
          }
          b.r(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.Cgq, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
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
          b.s(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.eBB().CvZ.Cgq, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
          continue;
          label198:
          if (b.h(b.this)) {
            b.r(b.this).a(this.CbP, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
          } else {
            b.s(b.this).a(this.CbP, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
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