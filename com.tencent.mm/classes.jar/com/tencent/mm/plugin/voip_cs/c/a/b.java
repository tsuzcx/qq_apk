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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.cs.MovableVideoView;
import com.tencent.mm.plugin.voip_cs.a.a;
import com.tencent.mm.plugin.voip_cs.a.b;
import com.tencent.mm.plugin.voip_cs.a.d;
import com.tencent.mm.plugin.voip_cs.a.e;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b
  implements TextureView.SurfaceTextureListener, View.OnClickListener, r.a, com.tencent.mm.plugin.voip.video.camera.a.c
{
  protected static final int[] NVs = { -1, a.e.Oid, a.e.Oii, a.e.Oih };
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  private ImageButton Fyr;
  private View FzQ;
  private MTimerHandler.CallBack NUW;
  private View.OnClickListener NUX;
  private VoipBigIconButton NUa;
  private boolean NUy;
  private OpenGlView NWe;
  private OpenGlView NWf;
  public OpenGlRender NWg;
  public OpenGlRender NWh;
  public VoipCSMainUI OjE;
  private RelativeLayout OjF;
  private TextView OjG;
  private TextView OjH;
  private TextView OjI;
  private TextView OjJ;
  public ImageView OjK;
  private MMHandler OjL;
  private com.tencent.mm.plugin.voip_cs.d.a OjM;
  private ObservableTextureView OjN;
  private boolean OjO;
  protected long OjP;
  private boolean OjQ;
  private boolean OjR;
  private int OjS;
  private int OjT;
  private com.tencent.mm.plugin.voip_cs.d.b OjU;
  public String OjV;
  public String OjW;
  private MTimerHandler OjX;
  private MTimerHandler OjY;
  a OjZ;
  c Oka;
  b Okb;
  String Okc;
  Drawable Okd;
  private MTimerHandler cts;
  public boolean fEs;
  public TextView iZH;
  private MMHandler knk;
  private TextView timeTV;
  
  public b(VoipCSMainUI paramVoipCSMainUI)
  {
    AppMethodBeat.i(125382);
    this.NUy = false;
    this.fEs = false;
    this.OjO = false;
    this.OjP = -1L;
    this.OjQ = false;
    this.OjR = false;
    this.OjS = 60000;
    this.OjT = 5000;
    this.OjU = new com.tencent.mm.plugin.voip_cs.d.b();
    this.OjV = "";
    this.OjW = "";
    this.OjX = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125370);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
        com.tencent.mm.plugin.voip_cs.c.c.gEX().dataType = 1;
        b.this.alX(6);
        AppMethodBeat.o(125370);
        return true;
      }
    }, false);
    this.OjY = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125371);
        b.a(b.this).setText(MMApplicationContext.getContext().getString(a.e.Oik));
        b.b(b.this).setVisibility(0);
        com.tencent.mm.plugin.voip_cs.d.b localb = b.c(b.this);
        TextView localTextView = b.b(b.this);
        int[] arrayOfInt = b.NVs;
        if ((arrayOfInt == null) || (localTextView == null)) {
          Log.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        }
        for (;;)
        {
          AppMethodBeat.o(125371);
          return true;
          localb.gBX();
          localb.NVH = 0;
          localb.NVF = arrayOfInt;
          localb.rR = localTextView;
          localb.NVG = 500;
          if (localb.cts != null) {
            localb.cts.startTimer(localb.NVG);
          }
          Log.printDebugStack("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(localTextView)), new Object[0]);
        }
      }
    }, false);
    this.NUW = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(213382);
        String str = b.GN(Util.secondsToNow(b.this.OjP));
        b.d(b.this).setText(str);
        AppMethodBeat.o(213382);
        return true;
      }
    };
    this.cts = new MTimerHandler(Looper.getMainLooper(), this.NUW, true);
    this.NUX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213743);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
        b.e(b.this).setEnabled(false);
        if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw > 1) {
          b.f(b.this);
        }
        b.e(b.this).setEnabled(true);
        if (b.g(b.this) != null) {
          b.g(b.this).gDD();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213743);
      }
    };
    this.OjZ = new a((byte)0);
    this.Okc = "";
    this.Okd = null;
    this.OjE = paramVoipCSMainUI;
    Object localObject = (WindowManager)paramVoipCSMainUI.getSystemService("window");
    int i = ((WindowManager)localObject).getDefaultDisplay().getHeight() / 5;
    int j = ((WindowManager)localObject).getDefaultDisplay().getWidth() * i / ((WindowManager)localObject).getDefaultDisplay().getHeight();
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)paramVoipCSMainUI.findViewById(a.b.Ohu)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(paramVoipCSMainUI.getContext(), 40.0F));
    }
    this.NWf = new MovableVideoView(paramVoipCSMainUI.getApplicationContext());
    ((MovableVideoView)this.NWf).kU(j, i);
    this.NWf.setVisibility(8);
    this.NWg = new OpenGlRender(this.NWf, OpenGlRender.RenderRemote);
    this.NWf.setRenderer(this.NWg);
    this.NWf.setRenderMode(0);
    this.timeTV = ((TextView)paramVoipCSMainUI.findViewById(a.b.time_tv));
    this.timeTV.setVisibility(0);
    this.OjG = ((TextView)paramVoipCSMainUI.findViewById(a.b.Ohx));
    this.OjG.setVisibility(0);
    this.OjH = ((TextView)paramVoipCSMainUI.findViewById(a.b.OhC));
    if (paramVoipCSMainUI.scene.equals("1")) {
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.OjH.setText(MMApplicationContext.getContext().getString(a.e.OhM));
        this.OjH.setVisibility(0);
        this.iZH = ((TextView)paramVoipCSMainUI.findViewById(a.b.OhE));
        this.iZH.setVisibility(0);
        this.OjK = ((ImageView)paramVoipCSMainUI.findViewById(a.b.Ohy));
        this.OjK.setVisibility(0);
        this.OjJ = ((TextView)paramVoipCSMainUI.findViewById(a.b.OhB));
        this.OjI = ((TextView)paramVoipCSMainUI.findViewById(a.b.OhD));
        this.NUa = ((VoipBigIconButton)paramVoipCSMainUI.findViewById(a.b.Ohz));
        if ((paramVoipCSMainUI.Okk == null) || (!paramVoipCSMainUI.Okk.equals("1"))) {
          break label1049;
        }
        this.NUa.setVisibility(0);
        this.NUa.setOnClickListener(this.NUX);
        label585:
        this.knk = new MMHandler();
        this.OjL = new MMHandler()
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(213463);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(213463);
              return;
              if (b.this.Okd != null)
              {
                b.h(b.this).setImageDrawable(b.this.Okd);
                AppMethodBeat.o(213463);
                return;
              }
              b.h(b.this).setImageResource(a.a.default_avatar);
            }
          }
        };
        this.FzQ = paramVoipCSMainUI.findViewById(a.b.Ohv);
        this.Fyr = ((ImageButton)paramVoipCSMainUI.findViewById(a.b.OhA));
        this.OjF = ((RelativeLayout)paramVoipCSMainUI.findViewById(a.b.Ohv));
        mScreenWidth = com.tencent.mm.ci.a.kr(paramVoipCSMainUI.getContext());
        mScreenHeight = com.tencent.mm.plugin.voip_cs.d.c.iM(paramVoipCSMainUI.getContext());
        this.NWe = ((OpenGlView)paramVoipCSMainUI.findViewById(a.b.Ohw));
        this.NWe.kV(mScreenWidth, mScreenHeight);
        this.NWh = new OpenGlRender(this.NWe, OpenGlRender.RenderLocal);
        this.NWe.setRenderer(this.NWh);
        this.NWe.setRenderMode(0);
        this.NWe.setVisibility(0);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[] { Integer.valueOf(mScreenHeight) });
        this.Fyr.setOnClickListener(this);
        this.OjF.addView(this.NWf);
        this.NWf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213154);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = b.this;
            if (!b.i(b.this)) {}
            for (boolean bool = true;; bool = false)
            {
              b.a(paramAnonymousView, bool);
              paramAnonymousView = b.b(b.this, b.i(b.this));
              b.j(b.this).kW(paramAnonymousView.x, paramAnonymousView.y);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213154);
              return;
            }
          }
        });
        this.NWg.qS();
        this.NWh.qS();
        if (!m.iH(MMApplicationContext.getContext())) {
          m.iI(MMApplicationContext.getContext());
        }
        paramVoipCSMainUI = MMApplicationContext.getDefaultPreference();
        this.OjV = paramVoipCSMainUI.getString(gFj(), "");
        if ((this.OjE.nfY == null) || (this.OjE.nfY.equals(""))) {
          break label1061;
        }
        bgm(this.OjE.nfY);
      }
    }
    for (;;)
    {
      this.OjW = paramVoipCSMainUI.getString(gFk(), "");
      if (!Util.isNullOrNil(this.OjW)) {
        setNickName(this.OjW);
      }
      paramVoipCSMainUI = com.tencent.mm.plugin.voip_cs.c.c.gEW();
      localObject = this.OjE.Ojx;
      Log.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:".concat(String.valueOf(localObject)));
      com.tencent.mm.kernel.h.aGY().a(106, paramVoipCSMainUI);
      paramVoipCSMainUI = new f((String)localObject);
      com.tencent.mm.kernel.h.aGY().a(paramVoipCSMainUI, 0);
      AppMethodBeat.o(125382);
      return;
      this.OjH.setText(MMApplicationContext.getContext().getString(a.e.OhN));
      break;
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.OjH.setText(MMApplicationContext.getContext().getString(a.e.OhO));
        break;
      }
      this.OjH.setText(MMApplicationContext.getContext().getString(a.e.OhN));
      break;
      label1049:
      this.NUa.setVisibility(8);
      break label585;
      label1061:
      if (!Util.isNullOrNil(this.OjV)) {
        bgm(this.OjV);
      }
    }
  }
  
  private static float AY(boolean paramBoolean)
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
        localObject = com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.field_capInfo;
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
          Log.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
          f2 = f1;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        Log.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + localException.getMessage());
        continue;
      }
      AppMethodBeat.o(125390);
      return f2;
      f2 = f1;
      localObject = com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.NQK;
    }
  }
  
  private Point Bd(boolean paramBoolean)
  {
    AppMethodBeat.i(125389);
    int i = ((WindowManager)this.OjE.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
    float f = i;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Point localPoint = new Point((int)(AY(paramBoolean) * f), i);
      AppMethodBeat.o(125389);
      return localPoint;
    }
  }
  
  private void Bx(boolean paramBoolean)
  {
    AppMethodBeat.i(125396);
    if (Build.MANUFACTURER.equalsIgnoreCase("sony"))
    {
      Log.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
      AppMethodBeat.o(125396);
      return;
    }
    if (!paramBoolean)
    {
      this.OjE.getWindow().setFlags(1024, 1024);
      AppMethodBeat.o(125396);
      return;
    }
    this.OjE.getWindow().clearFlags(1024);
    AppMethodBeat.o(125396);
  }
  
  protected static String GN(long paramLong)
  {
    AppMethodBeat.i(125399);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(125399);
    return str;
  }
  
  private void alW(int paramInt)
  {
    AppMethodBeat.i(125392);
    if ((this.OjE.Okk != null) && (this.OjE.Okk.equals("1")))
    {
      this.NUa.setVisibility(paramInt);
      AppMethodBeat.o(125392);
      return;
    }
    this.NUa.setVisibility(8);
    AppMethodBeat.o(125392);
  }
  
  private static int alY(int paramInt)
  {
    AppMethodBeat.i(125401);
    if (paramInt == 1)
    {
      paramInt = a.e.OhL;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if (paramInt == 0)
    {
      paramInt = a.e.OhQ;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if ((paramInt == -1) || (paramInt == 5))
    {
      paramInt = a.e.Oib;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if ((paramInt == 403) || (paramInt == 404))
    {
      paramInt = a.e.Oij;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if (paramInt == 6)
    {
      paramInt = a.e.Oie;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if (paramInt == 1001)
    {
      paramInt = a.e.Oia;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if (paramInt == 10)
    {
      paramInt = a.e.OhP;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw < 2)
    {
      paramInt = a.e.OhK;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    paramInt = a.e.OhQ;
    AppMethodBeat.o(125401);
    return paramInt;
  }
  
  public static Drawable bgn(String paramString)
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
      Log.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
      AppMethodBeat.o(125398);
    }
    return null;
  }
  
  private void gFn()
  {
    AppMethodBeat.i(125395);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
    this.knk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125377);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
        if (b.k(b.this).isFinishing())
        {
          AppMethodBeat.o(125377);
          return;
        }
        b.l(b.this).setVisibility(8);
        b.d(b.this).setVisibility(8);
        b.m(b.this).setVisibility(8);
        b.n(b.this);
        b.o(b.this);
        AppMethodBeat.o(125377);
      }
    }, 10000L);
    AppMethodBeat.o(125395);
  }
  
  public final void IA(int paramInt) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(125404);
    Log.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.fEs);
    if (this.fEs)
    {
      AppMethodBeat.o(125404);
      return;
    }
    if (this.OjZ.Frr == null)
    {
      this.OjZ.w = paramInt1;
      this.OjZ.h = paramInt2;
      this.OjZ.Frr = new int[this.OjZ.w * this.OjZ.h];
    }
    int i;
    if (this.OjM.gDP())
    {
      i = OpenGlRender.FLAG_Mirror;
      if (!this.OjM.gDz()) {
        break label278;
      }
    }
    label278:
    for (int j = OpenGlRender.FLAG_Angle270;; j = OpenGlRender.FLAG_Angle90)
    {
      if (this.OjQ)
      {
        Log.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = ".concat(String.valueOf(com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.videoEncodeToSend(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3 + paramInt4))));
        com.tencent.mm.plugin.voip_cs.c.a locala = com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf;
        locala.NSs += 1;
      }
      com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.videoEncodeToLocal(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, 0, 75, this.OjZ.Frr);
      if (OpenGlRender.NZh != 1) {
        break label321;
      }
      if (!this.NUy) {
        break label286;
      }
      this.NWg.a(this.OjZ.Frr, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
      AppMethodBeat.o(125404);
      return;
      i = 0;
      break;
    }
    label286:
    this.NWh.a(this.OjZ.Frr, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
    AppMethodBeat.o(125404);
    return;
    label321:
    if (OpenGlRender.NZh == 2)
    {
      if (this.NUy)
      {
        this.NWg.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
        AppMethodBeat.o(125404);
        return;
      }
      this.NWh.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
    }
    AppMethodBeat.o(125404);
  }
  
  public final void alX(int paramInt)
  {
    AppMethodBeat.i(125400);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:".concat(String.valueOf(paramInt)));
    if (this.cts != null)
    {
      this.cts.stopTimer();
      this.cts = null;
    }
    if (!this.OjX.stopped()) {
      this.OjX.stopTimer();
    }
    if (!this.OjY.stopped()) {
      this.OjY.stopTimer();
    }
    this.OjU.gBX();
    this.OjO = false;
    this.OjJ.setVisibility(0);
    this.OjJ.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.OjJ.setBackgroundResource(a.a.Oht);
    this.OjJ.setCompoundDrawables(null, null, null, null);
    this.OjJ.setCompoundDrawablePadding(0);
    this.OjJ.setText(alY(paramInt));
    if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw == 2) {
      com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "VoipCS_play_end_sound";
        }
        
        public final void run()
        {
          AppMethodBeat.i(125378);
          a locala = a.gFf();
          if (locala.tRS != null) {
            locala.tRS.i(a.d.close_lower_volume, false, 0);
          }
          AppMethodBeat.o(125378);
        }
      });
    }
    this.knk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125379);
        b.k(b.this).finish();
        AppMethodBeat.o(125379);
      }
    }, 2000L);
    AppMethodBeat.o(125400);
  }
  
  public final void bgm(String paramString)
  {
    AppMethodBeat.i(125386);
    if (!Util.isNullOrNil(paramString))
    {
      this.Okb = new b();
      if ((this.OjE.nfY == null) || (this.OjE.nfY.equals(""))) {
        break label81;
      }
    }
    label81:
    for (this.Okc = this.OjE.nfY;; this.Okc = paramString)
    {
      com.tencent.e.h.ZvG.be(this.Okb);
      AppMethodBeat.o(125386);
      return;
    }
  }
  
  public final void cNy()
  {
    AppMethodBeat.i(125405);
    Log.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    AppMethodBeat.o(125405);
  }
  
  public final void eIM()
  {
    AppMethodBeat.i(125397);
    this.OjX.stopTimer();
    this.OjY.stopTimer();
    this.OjU.gBX();
    this.OjI.setVisibility(8);
    this.OjH.setText(a.e.Oig);
    this.OjG.setText(a.e.OhU);
    alW(0);
    this.FzQ.setOnClickListener(this);
    if ((this.OjE.Okl != null) && (this.OjE.Okl.equals("1")))
    {
      this.NWf.setVisibility(0);
      this.NUy = true;
      Point localPoint = Bd(this.NUy);
      ((MovableVideoView)this.NWf).kU(localPoint.x, localPoint.y);
      gFo();
    }
    gFn();
    this.OjQ = true;
    if (this.cts == null) {
      this.cts = new MTimerHandler(Looper.getMainLooper(), this.NUW, true);
    }
    if (this.OjO)
    {
      AppMethodBeat.o(125397);
      return;
    }
    if (this.OjP == -1L) {
      this.OjP = Util.nowSecond();
    }
    this.OjO = true;
    this.cts.startTimer(1000L, 1000L);
    r.gzC().gzD();
    r.gzC().a(this);
    AppMethodBeat.o(125397);
  }
  
  public final void eIN() {}
  
  public final void eIO() {}
  
  public final void eIP()
  {
    AppMethodBeat.i(125403);
    this.OjJ.setVisibility(8);
    AppMethodBeat.o(125403);
  }
  
  public final void fP(int paramInt1, int paramInt2) {}
  
  public final void gFh()
  {
    AppMethodBeat.i(125383);
    if (this.OjX.stopped()) {
      this.OjX.startTimer(this.OjS);
    }
    AppMethodBeat.o(125383);
  }
  
  public final void gFi()
  {
    AppMethodBeat.i(125384);
    if (this.OjY.stopped()) {
      this.OjY.startTimer(this.OjT);
    }
    AppMethodBeat.o(125384);
  }
  
  public final String gFj()
  {
    AppMethodBeat.i(125387);
    String str = "voip_cs_headImageUrl_" + this.OjE.Ojx;
    AppMethodBeat.o(125387);
    return str;
  }
  
  public final String gFk()
  {
    AppMethodBeat.i(125388);
    String str = "voip_cs_nickname_" + this.OjE.Ojx;
    AppMethodBeat.o(125388);
    return str;
  }
  
  public final void gFl()
  {
    AppMethodBeat.i(125393);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
    if (this.OjN == null)
    {
      Log.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
      this.OjN = new ObservableTextureView(this.OjE);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
      this.OjN.setLayoutParams(localLayoutParams);
      this.OjF.addView(this.OjN, new RelativeLayout.LayoutParams(1, 1));
      this.OjN.setVisibility(0);
    }
    if (this.OjM == null)
    {
      Log.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
      this.OjM = new com.tencent.mm.plugin.voip_cs.d.a();
      this.OjM.a(this, true);
      this.OjM.a(this.OjN);
      com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.Ftu = this.OjM.gDA();
      this.OjM.gDB();
      this.OjM.gFu();
      Log.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.OjM.gDP()), Boolean.valueOf(this.OjM.gDz()) });
    }
    AppMethodBeat.o(125393);
  }
  
  public final void gFm()
  {
    AppMethodBeat.i(125394);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
    if (this.OjN != null)
    {
      this.OjF.removeView(this.OjN);
      this.OjN = null;
    }
    if (this.OjM != null)
    {
      this.OjM.eXS();
      this.OjM = null;
    }
    AppMethodBeat.o(125394);
  }
  
  public final void gFo()
  {
    AppMethodBeat.i(125406);
    gFp();
    this.Oka = new c();
    com.tencent.e.h.ZvG.be(this.Oka);
    Log.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    AppMethodBeat.o(125406);
  }
  
  public final void gFp()
  {
    AppMethodBeat.i(125407);
    if (this.Oka != null)
    {
      Log.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
      this.Oka.NNl = true;
      this.Oka.cancel();
      this.Oka = null;
    }
    AppMethodBeat.o(125407);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(125391);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView.getId() == a.b.OhA)
    {
      if (com.tencent.mm.plugin.voip_cs.c.c.gEW().Ojw < 2) {}
      for (com.tencent.mm.plugin.voip_cs.c.c.gEX().dataType = 2;; com.tencent.mm.plugin.voip_cs.c.c.gEX().dataType = 4)
      {
        paramView = com.tencent.mm.plugin.voip_cs.c.c.gEX();
        paramView.OiB = 1;
        paramView.OiW = 1;
        paramView.OiC = ((int)(System.currentTimeMillis() / 1000L));
        paramView = com.tencent.mm.plugin.voip_cs.c.c.gEX();
        Log.d("MicroMsg.VoipCSReportHelper", "selfCancel");
        if (paramView.OiT == 0)
        {
          paramView.OiO = 3;
          if ((paramView.OiX == 0L) && (paramView.Ojj != 0)) {
            paramView.OiX = ((int)(System.currentTimeMillis() / 1000L) - paramView.Ojj);
          }
        }
        com.tencent.mm.plugin.voip_cs.c.c.gEX().gEY();
        Log.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
        alX(0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125391);
        return;
      }
    }
    if (this.Fyr.getVisibility() == 0) {}
    for (int i = 8;; i = 0)
    {
      this.Fyr.setVisibility(i);
      this.timeTV.setVisibility(i);
      this.OjG.setVisibility(i);
      alW(i);
      if (i == 0) {
        bool = true;
      }
      Bx(bool);
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
    if (this.OjE.Okn) {}
    for (paramString = paramString + MMApplicationContext.getContext().getString(a.e.OhG);; paramString = paramString + MMApplicationContext.getContext().getString(a.e.OhH))
    {
      this.iZH.setText(paramString);
      AppMethodBeat.o(125385);
      return;
    }
  }
  
  public final void tn(boolean paramBoolean)
  {
    AppMethodBeat.i(125402);
    this.OjJ.setVisibility(0);
    this.OjJ.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.OjJ.setBackgroundResource(a.a.Oht);
    this.OjJ.setCompoundDrawables(null, null, null, null);
    this.OjJ.setCompoundDrawablePadding(0);
    this.OjJ.setText(alY(1001));
    AppMethodBeat.o(125402);
  }
  
  final class a
  {
    int[] Frr;
    int h;
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
      b.this.Okd = b.bgn(b.this.Okc);
      Message localMessage = new Message();
      localMessage.what = 12;
      b.s(b.this).sendMessage(localMessage);
      b.this.Okb.cancel();
      AppMethodBeat.o(125380);
    }
  }
  
  final class c
    extends com.tencent.e.i.b
  {
    boolean NNl = false;
    byte[] NNm = null;
    
    c() {}
    
    public final String getKey()
    {
      return "VOIPCS_VideoDecode";
    }
    
    public final void run()
    {
      AppMethodBeat.i(125381);
      if ((!this.NNl) && (!b.p(b.this)))
      {
        if (this.NNm == null) {
          this.NNm = new byte[com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.defaultWidth * com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.defaultHeight * 3 / 2];
        }
        int i;
        int j;
        if (com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.videoDecode(this.NNm) == 1)
        {
          i = com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.field_remoteImgWidth;
          j = com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.field_remoteImgHeight;
          if (OpenGlRender.NZh != 1) {
            break label198;
          }
          if (!b.i(b.this)) {
            break label166;
          }
          b.q(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.NRR, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
        }
        for (;;)
        {
          try
          {
            Thread.sleep(20L);
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", localInterruptedException, "", new Object[0]);
          }
          break;
          label166:
          b.r(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.gEV().Okf.NRR, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
          continue;
          label198:
          if (b.i(b.this)) {
            b.q(b.this).a(this.NNm, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
          } else {
            b.r(b.this).a(this.NNm, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
          }
        }
      }
      AppMethodBeat.o(125381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a.b
 * JD-Core Version:    0.7.0.1
 */