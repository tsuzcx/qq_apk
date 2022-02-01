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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.cs.MovableVideoView;
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
import java.util.Timer;
import java.util.TimerTask;

public final class b
  implements TextureView.SurfaceTextureListener, View.OnClickListener, r.a, com.tencent.mm.plugin.voip.video.camera.a.b
{
  protected static final int[] HeB = { -1, 2131767280, 2131767285, 2131767284 };
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  private boolean HdG;
  private VoipBigIconButton Hdl;
  private View.OnClickListener Hed;
  private OpenGlView Hfn;
  private OpenGlView Hfo;
  public OpenGlRender Hfp;
  public OpenGlRender Hfq;
  public VoipCSMainUI HrT;
  private RelativeLayout HrU;
  private TextView HrV;
  private TextView HrW;
  private TextView HrX;
  private TextView HrY;
  public ImageView HrZ;
  private MMHandler Hsa;
  private com.tencent.mm.plugin.voip_cs.d.a Hsb;
  private ObservableTextureView Hsc;
  private boolean Hsd;
  protected long Hse;
  private boolean Hsf;
  private boolean Hsg;
  private int Hsh;
  private int Hsi;
  private com.tencent.mm.plugin.voip_cs.d.b Hsj;
  public String Hsk;
  public String Hsl;
  private MTimerHandler Hsm;
  private MTimerHandler Hsn;
  a Hso;
  c Hsp;
  b Hsq;
  String Hsr;
  Drawable Hss;
  public boolean dLD;
  private Timer dfh;
  public TextView gvw;
  private MMHandler hAk;
  private TextView timeTV;
  private ImageButton zSP;
  private View zUm;
  
  public b(VoipCSMainUI paramVoipCSMainUI)
  {
    AppMethodBeat.i(125382);
    this.HdG = false;
    this.dLD = false;
    this.Hsd = false;
    this.Hse = -1L;
    this.Hsf = false;
    this.Hsg = false;
    this.Hsh = 60000;
    this.Hsi = 5000;
    this.Hsj = new com.tencent.mm.plugin.voip_cs.d.b();
    this.Hsk = "";
    this.Hsl = "";
    this.Hsm = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125370);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
        com.tencent.mm.plugin.voip_cs.c.c.fMt().dataType = 1;
        b.this.aek(6);
        AppMethodBeat.o(125370);
        return true;
      }
    }, false);
    this.Hsn = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125371);
        b.a(b.this).setText(MMApplicationContext.getContext().getString(2131767287));
        b.b(b.this).setVisibility(0);
        com.tencent.mm.plugin.voip_cs.d.b localb = b.c(b.this);
        TextView localTextView = b.b(b.this);
        int[] arrayOfInt = b.HeB;
        if ((arrayOfInt == null) || (localTextView == null)) {
          Log.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        }
        for (;;)
        {
          AppMethodBeat.o(125371);
          return true;
          localb.fJB();
          localb.HeP = 0;
          localb.HeN = arrayOfInt;
          localb.Ws = localTextView;
          localb.HeO = 500;
          if (localb.cve != null) {
            localb.cve.startTimer(localb.HeO);
          }
          Log.printDebugStack("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(localTextView)), new Object[0]);
        }
      }
    }, false);
    this.Hed = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125372);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
        b.d(b.this).setEnabled(false);
        if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL > 1) {
          b.e(b.this);
        }
        b.d(b.this).setEnabled(true);
        if (b.f(b.this) != null) {
          b.f(b.this).fLd();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125372);
      }
    };
    this.Hso = new a((byte)0);
    this.Hsr = "";
    this.Hss = null;
    this.HrT = paramVoipCSMainUI;
    Object localObject = (WindowManager)paramVoipCSMainUI.getSystemService("window");
    int i = ((WindowManager)localObject).getDefaultDisplay().getHeight() / 5;
    int j = ((WindowManager)localObject).getDefaultDisplay().getWidth() * i / ((WindowManager)localObject).getDefaultDisplay().getHeight();
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)paramVoipCSMainUI.findViewById(2131307123)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(paramVoipCSMainUI.getContext(), 40.0F));
    }
    this.Hfo = new MovableVideoView(paramVoipCSMainUI.getApplicationContext());
    ((MovableVideoView)this.Hfo).jF(j, i);
    this.Hfo.setVisibility(8);
    this.Hfp = new OpenGlRender(this.Hfo, OpenGlRender.RenderRemote);
    this.Hfo.setRenderer(this.Hfp);
    this.Hfo.setRenderMode(0);
    this.timeTV = ((TextView)paramVoipCSMainUI.findViewById(2131309101));
    this.timeTV.setVisibility(0);
    this.dfh = new Timer("voip_cs_talking_time");
    this.HrV = ((TextView)paramVoipCSMainUI.findViewById(2131310023));
    this.HrV.setVisibility(0);
    this.HrW = ((TextView)paramVoipCSMainUI.findViewById(2131310028));
    if (paramVoipCSMainUI.scene.equals("1")) {
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.HrW.setText(MMApplicationContext.getContext().getString(2131767263));
        this.HrW.setVisibility(0);
        this.gvw = ((TextView)paramVoipCSMainUI.findViewById(2131310031));
        this.gvw.setVisibility(0);
        this.HrZ = ((ImageView)paramVoipCSMainUI.findViewById(2131310024));
        this.HrZ.setVisibility(0);
        this.HrY = ((TextView)paramVoipCSMainUI.findViewById(2131310027));
        this.HrX = ((TextView)paramVoipCSMainUI.findViewById(2131310029));
        this.Hdl = ((VoipBigIconButton)paramVoipCSMainUI.findViewById(2131310025));
        if ((paramVoipCSMainUI.HsA == null) || (!paramVoipCSMainUI.HsA.equals("1"))) {
          break label1031;
        }
        this.Hdl.setVisibility(0);
        this.Hdl.setOnClickListener(this.Hed);
        label567:
        this.hAk = new MMHandler();
        this.Hsa = new MMHandler()
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
              if (b.this.Hss != null)
              {
                b.g(b.this).setImageDrawable(b.this.Hss);
                AppMethodBeat.o(125373);
                return;
              }
              b.g(b.this).setImageResource(2131231957);
            }
          }
        };
        this.zUm = paramVoipCSMainUI.findViewById(2131310020);
        this.zSP = ((ImageButton)paramVoipCSMainUI.findViewById(2131310026));
        this.HrU = ((RelativeLayout)paramVoipCSMainUI.findViewById(2131310020));
        mScreenWidth = com.tencent.mm.cb.a.jn(paramVoipCSMainUI.getContext());
        mScreenHeight = com.tencent.mm.plugin.voip_cs.d.c.hI(paramVoipCSMainUI.getContext());
        this.Hfn = ((OpenGlView)paramVoipCSMainUI.findViewById(2131310021));
        this.Hfn.jG(mScreenWidth, mScreenHeight);
        this.Hfq = new OpenGlRender(this.Hfn, OpenGlRender.RenderLocal);
        this.Hfn.setRenderer(this.Hfq);
        this.Hfn.setRenderMode(0);
        this.Hfn.setVisibility(0);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[] { Integer.valueOf(mScreenHeight) });
        this.zSP.setOnClickListener(this);
        this.HrU.addView(this.Hfo);
        this.Hfo.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125374);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = b.this;
            if (!b.h(b.this)) {}
            for (boolean bool = true;; bool = false)
            {
              b.a(paramAnonymousView, bool);
              paramAnonymousView = b.b(b.this, b.h(b.this));
              b.i(b.this).jH(paramAnonymousView.x, paramAnonymousView.y);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(125374);
              return;
            }
          }
        });
        this.Hfp.onStarted();
        this.Hfq.onStarted();
        if (!m.hC(MMApplicationContext.getContext())) {
          m.hD(MMApplicationContext.getContext());
        }
        paramVoipCSMainUI = MMApplicationContext.getDefaultPreference();
        this.Hsk = paramVoipCSMainUI.getString(fMF(), "");
        if ((this.HrT.kog == null) || (this.HrT.kog.equals(""))) {
          break label1043;
        }
        aUE(this.HrT.kog);
      }
    }
    for (;;)
    {
      this.Hsl = paramVoipCSMainUI.getString(fMG(), "");
      if (!Util.isNullOrNil(this.Hsl)) {
        setNickName(this.Hsl);
      }
      paramVoipCSMainUI = com.tencent.mm.plugin.voip_cs.c.c.fMs();
      localObject = this.HrT.HrM;
      Log.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:".concat(String.valueOf(localObject)));
      g.azz().a(106, paramVoipCSMainUI);
      paramVoipCSMainUI = new f((String)localObject);
      g.azz().a(paramVoipCSMainUI, 0);
      AppMethodBeat.o(125382);
      return;
      this.HrW.setText(MMApplicationContext.getContext().getString(2131767264));
      break;
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.HrW.setText(MMApplicationContext.getContext().getString(2131767265));
        break;
      }
      this.HrW.setText(MMApplicationContext.getContext().getString(2131767264));
      break;
      label1031:
      this.Hdl.setVisibility(8);
      break label567;
      label1043:
      if (!Util.isNullOrNil(this.Hsk)) {
        aUE(this.Hsk);
      }
    }
  }
  
  protected static String AF(long paramLong)
  {
    AppMethodBeat.i(125399);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(125399);
    return str;
  }
  
  public static Drawable aUF(String paramString)
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
  
  private void aej(int paramInt)
  {
    AppMethodBeat.i(125392);
    if ((this.HrT.HsA != null) && (this.HrT.HsA.equals("1")))
    {
      this.Hdl.setVisibility(paramInt);
      AppMethodBeat.o(125392);
      return;
    }
    this.Hdl.setVisibility(8);
    AppMethodBeat.o(125392);
  }
  
  private static int ael(int paramInt)
  {
    AppMethodBeat.i(125401);
    if (paramInt == 1)
    {
      AppMethodBeat.o(125401);
      return 2131767260;
    }
    if (paramInt == 0)
    {
      AppMethodBeat.o(125401);
      return 2131767267;
    }
    if ((paramInt == -1) || (paramInt == 5))
    {
      AppMethodBeat.o(125401);
      return 2131767278;
    }
    if ((paramInt == 403) || (paramInt == 404))
    {
      AppMethodBeat.o(125401);
      return 2131767286;
    }
    if (paramInt == 6)
    {
      AppMethodBeat.o(125401);
      return 2131767281;
    }
    if (paramInt == 1001)
    {
      AppMethodBeat.o(125401);
      return 2131767277;
    }
    if (paramInt == 10)
    {
      AppMethodBeat.o(125401);
      return 2131767266;
    }
    if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL < 2)
    {
      AppMethodBeat.o(125401);
      return 2131767258;
    }
    AppMethodBeat.o(125401);
    return 2131767267;
  }
  
  private void fMJ()
  {
    AppMethodBeat.i(125395);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
    this.hAk.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125375);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
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
  
  private void xD(boolean paramBoolean)
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
      this.HrT.getWindow().setFlags(1024, 1024);
      AppMethodBeat.o(125396);
      return;
    }
    this.HrT.getWindow().clearFlags(1024);
    AppMethodBeat.o(125396);
  }
  
  private static float xg(boolean paramBoolean)
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
        localObject = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.field_capInfo;
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
      localObject = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.Hay;
    }
  }
  
  private Point xl(boolean paramBoolean)
  {
    AppMethodBeat.i(125389);
    int i = ((WindowManager)this.HrT.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
    float f = i;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Point localPoint = new Point((int)(xg(paramBoolean) * f), i);
      AppMethodBeat.o(125389);
      return localPoint;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(125404);
    Log.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.dLD);
    if (this.dLD)
    {
      AppMethodBeat.o(125404);
      return;
    }
    if (this.Hso.zLY == null)
    {
      this.Hso.w = paramInt1;
      this.Hso.h = paramInt2;
      this.Hso.zLY = new int[this.Hso.w * this.Hso.h];
    }
    int i;
    if (this.Hsb.fLp())
    {
      i = OpenGlRender.FLAG_Mirror;
      if (!this.Hsb.fKZ()) {
        break label278;
      }
    }
    label278:
    for (int j = OpenGlRender.FLAG_Angle270;; j = OpenGlRender.FLAG_Angle90)
    {
      if (this.Hsf)
      {
        Log.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = ".concat(String.valueOf(com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.videoEncodeToSend(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3 + paramInt4))));
        com.tencent.mm.plugin.voip_cs.c.a locala = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv;
        locala.Hcg += 1;
      }
      com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.videoEncodeToLocal(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, 0, 75, this.Hso.zLY);
      if (OpenGlRender.His != 1) {
        break label321;
      }
      if (!this.HdG) {
        break label286;
      }
      this.Hfp.a(this.Hso.zLY, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
      AppMethodBeat.o(125404);
      return;
      i = 0;
      break;
    }
    label286:
    this.Hfq.a(this.Hso.zLY, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
    AppMethodBeat.o(125404);
    return;
    label321:
    if (OpenGlRender.His == 2)
    {
      if (this.HdG)
      {
        this.Hfp.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
        AppMethodBeat.o(125404);
        return;
      }
      this.Hfq.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
    }
    AppMethodBeat.o(125404);
  }
  
  public final void aUE(String paramString)
  {
    AppMethodBeat.i(125386);
    if (!Util.isNullOrNil(paramString))
    {
      this.Hsq = new b();
      if ((this.HrT.kog == null) || (this.HrT.kog.equals(""))) {
        break label81;
      }
    }
    label81:
    for (this.Hsr = this.HrT.kog;; this.Hsr = paramString)
    {
      com.tencent.f.h.RTc.aX(this.Hsq);
      AppMethodBeat.o(125386);
      return;
    }
  }
  
  public final void aek(int paramInt)
  {
    AppMethodBeat.i(125400);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:".concat(String.valueOf(paramInt)));
    if (this.dfh != null)
    {
      this.dfh.cancel();
      this.dfh = null;
    }
    if (!this.Hsm.stopped()) {
      this.Hsm.stopTimer();
    }
    if (!this.Hsn.stopped()) {
      this.Hsn.stopTimer();
    }
    this.Hsj.fJB();
    this.Hsd = false;
    this.HrY.setVisibility(0);
    this.HrY.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.HrY.setBackgroundResource(2131235528);
    this.HrY.setCompoundDrawables(null, null, null, null);
    this.HrY.setCompoundDrawablePadding(0);
    this.HrY.setText(ael(paramInt));
    if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL == 2) {
      com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
      {
        public final String getKey()
        {
          return "VoipCS_play_end_sound";
        }
        
        public final void run()
        {
          AppMethodBeat.i(125378);
          a locala = a.fMB();
          if (locala.qtg != null) {
            locala.qtg.g(2131689973, false, 0);
          }
          AppMethodBeat.o(125378);
        }
      });
    }
    this.hAk.postDelayed(new Runnable()
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
  
  public final void cza()
  {
    AppMethodBeat.i(125405);
    Log.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    AppMethodBeat.o(125405);
  }
  
  public final void dZP()
  {
    AppMethodBeat.i(125397);
    this.Hsm.stopTimer();
    this.Hsn.stopTimer();
    this.Hsj.fJB();
    this.HrX.setVisibility(8);
    this.HrW.setText(2131767283);
    this.HrV.setText(2131767271);
    aej(0);
    this.zUm.setOnClickListener(this);
    if ((this.HrT.HsB != null) && (this.HrT.HsB.equals("1")))
    {
      this.Hfo.setVisibility(0);
      this.HdG = true;
      localObject = xl(this.HdG);
      ((MovableVideoView)this.Hfo).jF(((Point)localObject).x, ((Point)localObject).y);
      fMK();
    }
    fMJ();
    this.Hsf = true;
    if (this.dfh == null) {
      this.dfh = new Timer("voip_cs_talking_time");
    }
    if (this.Hsd)
    {
      AppMethodBeat.o(125397);
      return;
    }
    if (this.Hse == -1L) {
      this.Hse = Util.nowSecond();
    }
    this.Hsd = true;
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
            String str = b.AF(Util.secondsToNow(b.this.Hse));
            b.l(b.this).setText(str);
            AppMethodBeat.o(125376);
          }
        });
        AppMethodBeat.o(125377);
      }
    };
    this.dfh.schedule((TimerTask)localObject, 1000L, 1000L);
    r.fHo().fHp();
    r.fHo().a(this);
    AppMethodBeat.o(125397);
  }
  
  public final void dZQ() {}
  
  public final void dZR()
  {
    AppMethodBeat.i(125403);
    this.HrY.setVisibility(8);
    AppMethodBeat.o(125403);
  }
  
  public final void fMD()
  {
    AppMethodBeat.i(125383);
    if (this.Hsm.stopped()) {
      this.Hsm.startTimer(this.Hsh);
    }
    AppMethodBeat.o(125383);
  }
  
  public final void fME()
  {
    AppMethodBeat.i(125384);
    if (this.Hsn.stopped()) {
      this.Hsn.startTimer(this.Hsi);
    }
    AppMethodBeat.o(125384);
  }
  
  public final String fMF()
  {
    AppMethodBeat.i(125387);
    String str = "voip_cs_headImageUrl_" + this.HrT.HrM;
    AppMethodBeat.o(125387);
    return str;
  }
  
  public final String fMG()
  {
    AppMethodBeat.i(125388);
    String str = "voip_cs_nickname_" + this.HrT.HrM;
    AppMethodBeat.o(125388);
    return str;
  }
  
  public final void fMH()
  {
    AppMethodBeat.i(125393);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
    if (this.Hsc == null)
    {
      Log.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
      this.Hsc = new ObservableTextureView(this.HrT);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
      this.Hsc.setLayoutParams(localLayoutParams);
      this.HrU.addView(this.Hsc, new RelativeLayout.LayoutParams(1, 1));
      this.Hsc.setVisibility(0);
    }
    if (this.Hsb == null)
    {
      Log.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
      this.Hsb = new com.tencent.mm.plugin.voip_cs.d.a();
      this.Hsb.a(this, true);
      this.Hsb.a(this.Hsc);
      com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.zNX = this.Hsb.fLa();
      this.Hsb.fLb();
      this.Hsb.fMQ();
      Log.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.Hsb.fLp()), Boolean.valueOf(this.Hsb.fKZ()) });
    }
    AppMethodBeat.o(125393);
  }
  
  public final void fMI()
  {
    AppMethodBeat.i(125394);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
    if (this.Hsc != null)
    {
      this.HrU.removeView(this.Hsc);
      this.Hsc = null;
    }
    if (this.Hsb != null)
    {
      this.Hsb.eoc();
      this.Hsb = null;
    }
    AppMethodBeat.o(125394);
  }
  
  public final void fMK()
  {
    AppMethodBeat.i(125406);
    fML();
    this.Hsp = new c();
    com.tencent.f.h.RTc.aX(this.Hsp);
    Log.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    AppMethodBeat.o(125406);
  }
  
  public final void fML()
  {
    AppMethodBeat.i(125407);
    if (this.Hsp != null)
    {
      Log.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
      this.Hsp.GWY = true;
      this.Hsp.cancel();
      this.Hsp = null;
    }
    AppMethodBeat.o(125407);
  }
  
  public final void fs(int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(125391);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView.getId() == 2131310026)
    {
      if (com.tencent.mm.plugin.voip_cs.c.c.fMs().HrL < 2) {}
      for (com.tencent.mm.plugin.voip_cs.c.c.fMt().dataType = 2;; com.tencent.mm.plugin.voip_cs.c.c.fMt().dataType = 4)
      {
        paramView = com.tencent.mm.plugin.voip_cs.c.c.fMt();
        paramView.HqQ = 1;
        paramView.Hrl = 1;
        paramView.HqR = ((int)(System.currentTimeMillis() / 1000L));
        paramView = com.tencent.mm.plugin.voip_cs.c.c.fMt();
        Log.d("MicroMsg.VoipCSReportHelper", "selfCancel");
        if (paramView.Hri == 0)
        {
          paramView.Hrd = 3;
          if ((paramView.Hrm == 0L) && (paramView.Hry != 0)) {
            paramView.Hrm = ((int)(System.currentTimeMillis() / 1000L) - paramView.Hry);
          }
        }
        com.tencent.mm.plugin.voip_cs.c.c.fMt().fMu();
        Log.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
        aek(0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125391);
        return;
      }
    }
    if (this.zSP.getVisibility() == 0) {}
    for (int i = 8;; i = 0)
    {
      this.zSP.setVisibility(i);
      this.timeTV.setVisibility(i);
      this.HrV.setVisibility(i);
      aej(i);
      if (i == 0) {
        bool = true;
      }
      xD(bool);
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
  
  public final void ql(boolean paramBoolean)
  {
    AppMethodBeat.i(125402);
    this.HrY.setVisibility(0);
    this.HrY.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.HrY.setBackgroundResource(2131235528);
    this.HrY.setCompoundDrawables(null, null, null, null);
    this.HrY.setCompoundDrawablePadding(0);
    this.HrY.setText(ael(1001));
    AppMethodBeat.o(125402);
  }
  
  public final void setNickName(String paramString)
  {
    AppMethodBeat.i(125385);
    if (this.HrT.HsD) {}
    for (paramString = paramString + MMApplicationContext.getContext().getString(2131767254);; paramString = paramString + MMApplicationContext.getContext().getString(2131767255))
    {
      this.gvw.setText(paramString);
      AppMethodBeat.o(125385);
      return;
    }
  }
  
  final class a
  {
    int h;
    int w;
    int[] zLY;
    
    private a() {}
  }
  
  final class b
    extends com.tencent.f.i.b
  {
    b() {}
    
    public final String getKey()
    {
      return "VOIPCS_netPic";
    }
    
    public final void run()
    {
      AppMethodBeat.i(125380);
      b.this.Hss = b.aUF(b.this.Hsr);
      Message localMessage = new Message();
      localMessage.what = 12;
      b.t(b.this).sendMessage(localMessage);
      b.this.Hsq.cancel();
      AppMethodBeat.o(125380);
    }
  }
  
  final class c
    extends com.tencent.f.i.b
  {
    boolean GWY = false;
    byte[] GWZ = null;
    
    c() {}
    
    public final String getKey()
    {
      return "VOIPCS_VideoDecode";
    }
    
    public final void run()
    {
      AppMethodBeat.i(125381);
      if ((!this.GWY) && (!b.q(b.this)))
      {
        if (this.GWZ == null) {
          this.GWZ = new byte[com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.defaultWidth * com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.defaultHeight * 3 / 2];
        }
        int i;
        int j;
        if (com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.videoDecode(this.GWZ) == 1)
        {
          i = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.field_remoteImgWidth;
          j = com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.field_remoteImgHeight;
          if (OpenGlRender.His != 1) {
            break label198;
          }
          if (!b.h(b.this)) {
            break label166;
          }
          b.r(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.HbF, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
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
          b.s(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.fMr().Hsv.HbF, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
          continue;
          label198:
          if (b.h(b.this)) {
            b.r(b.this).a(this.GWZ, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
          } else {
            b.s(b.this).a(this.GWZ, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
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