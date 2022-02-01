package com.tencent.mm.plugin.voip_cs.model.a;

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
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.cs.MovableVideoView;
import com.tencent.mm.plugin.voip.widget.VoipBigIconButton;
import com.tencent.mm.plugin.voip_cs.a.a;
import com.tencent.mm.plugin.voip_cs.a.b;
import com.tencent.mm.plugin.voip_cs.a.d;
import com.tencent.mm.plugin.voip_cs.a.e;
import com.tencent.mm.plugin.voip_cs.model.d;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b
  implements TextureView.SurfaceTextureListener, View.OnClickListener, r.a, com.tencent.mm.plugin.voip.video.camera.a.c
{
  protected static final int[] UKa = { -1, a.e.UWz, a.e.UWE, a.e.UWD };
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  private ImageButton LuD;
  private View LvU;
  private boolean UIF;
  private MTimerHandler.CallBack UIT;
  private OpenGlView UKH;
  private OpenGlView UKI;
  public OpenGlRender UKJ;
  public OpenGlRender UKK;
  public VoipCSMainUI UXZ;
  Drawable UYA;
  private RelativeLayout UYa;
  private TextView UYb;
  private TextView UYc;
  private TextView UYd;
  private TextView UYe;
  public ImageView UYf;
  private MMHandler UYg;
  private com.tencent.mm.plugin.voip_cs.b.a UYh;
  private ObservableTextureView UYi;
  private boolean UYj;
  protected long UYk;
  private boolean UYl;
  private boolean UYm;
  private int UYn;
  private int UYo;
  private com.tencent.mm.plugin.voip_cs.b.b UYp;
  public String UYq;
  public String UYr;
  private VoipBigIconButton UYs;
  private MTimerHandler UYt;
  private MTimerHandler UYu;
  private View.OnClickListener UYv;
  a UYw;
  c UYx;
  b UYy;
  String UYz;
  private MTimerHandler eln;
  public boolean hJi;
  public TextView lBD;
  private MMHandler mRi;
  private TextView timeTV;
  
  public b(VoipCSMainUI paramVoipCSMainUI)
  {
    AppMethodBeat.i(125382);
    this.UIF = false;
    this.hJi = false;
    this.UYj = false;
    this.UYk = -1L;
    this.UYl = false;
    this.UYm = false;
    this.UYn = 60000;
    this.UYo = 5000;
    this.UYp = new com.tencent.mm.plugin.voip_cs.b.b();
    this.UYq = "";
    this.UYr = "";
    this.UYt = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125370);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
        com.tencent.mm.plugin.voip_cs.model.c.idY().dataType = 1;
        b.this.arF(6);
        AppMethodBeat.o(125370);
        return true;
      }
    }, false);
    this.UYu = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125371);
        b.a(b.this).setText(MMApplicationContext.getContext().getString(a.e.UWG));
        b.b(b.this).setVisibility(0);
        com.tencent.mm.plugin.voip_cs.b.b localb = b.c(b.this);
        TextView localTextView = b.b(b.this);
        int[] arrayOfInt = b.UKa;
        if ((arrayOfInt == null) || (localTextView == null)) {
          Log.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        }
        for (;;)
        {
          AppMethodBeat.o(125371);
          return true;
          localb.hVz();
          localb.Uvz = 0;
          localb.UKv = arrayOfInt;
          localb.sQ = localTextView;
          localb.Uvy = 500;
          if (localb.eln != null) {
            localb.eln.startTimer(localb.Uvy);
          }
          Log.printDebugStack("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(localTextView)), new Object[0]);
        }
      }
    }, false);
    this.UIT = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(263893);
        String str = b.iY(Util.secondsToNow(b.this.UYk));
        b.d(b.this).setText(str);
        AppMethodBeat.o(263893);
        return true;
      }
    };
    this.eln = new MTimerHandler(Looper.getMainLooper(), this.UIT, true);
    this.UYv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(263887);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
        b.e(b.this).setEnabled(false);
        if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR > 1) {
          b.f(b.this);
        }
        b.e(b.this).setEnabled(true);
        if (b.g(b.this) != null) {
          b.g(b.this).icy();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(263887);
      }
    };
    this.UYw = new a((byte)0);
    this.UYz = "";
    this.UYA = null;
    this.UXZ = paramVoipCSMainUI;
    Object localObject = (WindowManager)paramVoipCSMainUI.getSystemService("window");
    int i = ((WindowManager)localObject).getDefaultDisplay().getHeight() / 5;
    int j = ((WindowManager)localObject).getDefaultDisplay().getWidth() * i / ((WindowManager)localObject).getDefaultDisplay().getHeight();
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)paramVoipCSMainUI.findViewById(a.b.UVQ)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(paramVoipCSMainUI.getContext(), 40.0F));
    }
    this.UKI = new MovableVideoView(paramVoipCSMainUI.getApplicationContext());
    ((MovableVideoView)this.UKI).mG(j, i);
    this.UKI.setVisibility(8);
    this.UKJ = new OpenGlRender(this.UKI, OpenGlRender.RenderRemote);
    this.UKI.setRenderer(this.UKJ);
    this.UKI.setRenderMode(0);
    this.timeTV = ((TextView)paramVoipCSMainUI.findViewById(a.b.time_tv));
    this.timeTV.setVisibility(0);
    this.UYb = ((TextView)paramVoipCSMainUI.findViewById(a.b.UVT));
    this.UYb.setVisibility(0);
    this.UYc = ((TextView)paramVoipCSMainUI.findViewById(a.b.UVY));
    if (paramVoipCSMainUI.scene.equals("1")) {
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.UYc.setText(MMApplicationContext.getContext().getString(a.e.UWi));
        this.UYc.setVisibility(0);
        this.lBD = ((TextView)paramVoipCSMainUI.findViewById(a.b.UWa));
        this.lBD.setVisibility(0);
        this.UYf = ((ImageView)paramVoipCSMainUI.findViewById(a.b.UVU));
        this.UYf.setVisibility(0);
        this.UYe = ((TextView)paramVoipCSMainUI.findViewById(a.b.UVX));
        this.UYd = ((TextView)paramVoipCSMainUI.findViewById(a.b.UVZ));
        this.UYs = ((VoipBigIconButton)paramVoipCSMainUI.findViewById(a.b.UVV));
        if ((paramVoipCSMainUI.UYH == null) || (!paramVoipCSMainUI.UYH.equals("1"))) {
          break label1049;
        }
        this.UYs.setVisibility(0);
        this.UYs.setOnClickListener(this.UYv);
        label585:
        this.mRi = new MMHandler();
        this.UYg = new MMHandler()
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            AppMethodBeat.i(263886);
            switch (paramAnonymousMessage.what)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(263886);
              return;
              if (b.this.UYA != null)
              {
                b.h(b.this).setImageDrawable(b.this.UYA);
                AppMethodBeat.o(263886);
                return;
              }
              b.h(b.this).setImageResource(a.a.default_avatar);
            }
          }
        };
        this.LvU = paramVoipCSMainUI.findViewById(a.b.UVR);
        this.LuD = ((ImageButton)paramVoipCSMainUI.findViewById(a.b.UVW));
        this.UYa = ((RelativeLayout)paramVoipCSMainUI.findViewById(a.b.UVR));
        mScreenWidth = com.tencent.mm.cd.a.ms(paramVoipCSMainUI.getContext());
        mScreenHeight = com.tencent.mm.plugin.voip_cs.b.c.kD(paramVoipCSMainUI.getContext());
        this.UKH = ((OpenGlView)paramVoipCSMainUI.findViewById(a.b.UVS));
        this.UKH.mH(mScreenWidth, mScreenHeight);
        this.UKK = new OpenGlRender(this.UKH, OpenGlRender.RenderLocal);
        this.UKH.setRenderer(this.UKK);
        this.UKH.setRenderMode(0);
        this.UKH.setVisibility(0);
        Log.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[] { Integer.valueOf(mScreenHeight) });
        this.LuD.setOnClickListener(this);
        this.UYa.addView(this.UKI);
        this.UKI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(263888);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = b.this;
            if (!b.i(b.this)) {}
            for (boolean bool = true;; bool = false)
            {
              b.a(paramAnonymousView, bool);
              paramAnonymousView = b.b(b.this, b.i(b.this));
              b.j(b.this).mI(paramAnonymousView.x, paramAnonymousView.y);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(263888);
              return;
            }
          }
        });
        this.UKJ.Qu();
        this.UKK.Qu();
        if (!m.ky(MMApplicationContext.getContext())) {
          m.kz(MMApplicationContext.getContext());
        }
        paramVoipCSMainUI = MMApplicationContext.getDefaultPreference();
        this.UYq = paramVoipCSMainUI.getString(iej(), "");
        if ((this.UXZ.nVM == null) || (this.UXZ.nVM.equals(""))) {
          break label1061;
        }
        bfR(this.UXZ.nVM);
      }
    }
    for (;;)
    {
      this.UYr = paramVoipCSMainUI.getString(iek(), "");
      if (!Util.isNullOrNil(this.UYr)) {
        setNickName(this.UYr);
      }
      paramVoipCSMainUI = com.tencent.mm.plugin.voip_cs.model.c.idX();
      localObject = this.UXZ.UXS;
      Log.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:".concat(String.valueOf(localObject)));
      com.tencent.mm.kernel.h.aZW().a(106, paramVoipCSMainUI);
      paramVoipCSMainUI = new f((String)localObject);
      com.tencent.mm.kernel.h.aZW().a(paramVoipCSMainUI, 0);
      AppMethodBeat.o(125382);
      return;
      this.UYc.setText(MMApplicationContext.getContext().getString(a.e.UWj));
      break;
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.UYc.setText(MMApplicationContext.getContext().getString(a.e.UWk));
        break;
      }
      this.UYc.setText(MMApplicationContext.getContext().getString(a.e.UWj));
      break;
      label1049:
      this.UYs.setVisibility(8);
      break label585;
      label1061:
      if (!Util.isNullOrNil(this.UYq)) {
        bfR(this.UYq);
      }
    }
  }
  
  private Point GC(boolean paramBoolean)
  {
    AppMethodBeat.i(125389);
    int i = ((WindowManager)this.UXZ.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
    float f = i;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Point localPoint = new Point((int)(Gv(paramBoolean) * f), i);
      AppMethodBeat.o(125389);
      return localPoint;
    }
  }
  
  private static float Gv(boolean paramBoolean)
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
        localObject = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.field_capInfo;
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
      localObject = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.UDw;
    }
  }
  
  private void Hd(boolean paramBoolean)
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
      this.UXZ.getWindow().setFlags(1024, 1024);
      AppMethodBeat.o(125396);
      return;
    }
    this.UXZ.getWindow().clearFlags(1024);
    AppMethodBeat.o(125396);
  }
  
  private void arE(int paramInt)
  {
    AppMethodBeat.i(125392);
    if ((this.UXZ.UYH != null) && (this.UXZ.UYH.equals("1")))
    {
      this.UYs.setVisibility(paramInt);
      AppMethodBeat.o(125392);
      return;
    }
    this.UYs.setVisibility(8);
    AppMethodBeat.o(125392);
  }
  
  private static int arG(int paramInt)
  {
    AppMethodBeat.i(125401);
    if (paramInt == 1)
    {
      paramInt = a.e.UWh;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if (paramInt == 0)
    {
      paramInt = a.e.UWm;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if ((paramInt == -1) || (paramInt == 5))
    {
      paramInt = a.e.UWx;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if ((paramInt == 403) || (paramInt == 404))
    {
      paramInt = a.e.UWF;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if (paramInt == 6)
    {
      paramInt = a.e.UWA;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if (paramInt == 1001)
    {
      paramInt = a.e.UWw;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if (paramInt == 10)
    {
      paramInt = a.e.UWl;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR < 2)
    {
      paramInt = a.e.UWg;
      AppMethodBeat.o(125401);
      return paramInt;
    }
    paramInt = a.e.UWm;
    AppMethodBeat.o(125401);
    return paramInt;
  }
  
  public static Drawable bfS(String paramString)
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
  
  protected static String iY(long paramLong)
  {
    AppMethodBeat.i(125399);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(125399);
    return str;
  }
  
  private void iem()
  {
    AppMethodBeat.i(125395);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
    this.mRi.postDelayed(new Runnable()
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
  
  public final void Jd(int paramInt) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(125404);
    Log.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.hJi);
    if (this.hJi)
    {
      AppMethodBeat.o(125404);
      return;
    }
    if (this.UYw.LnE == null)
    {
      this.UYw.w = paramInt1;
      this.UYw.h = paramInt2;
      this.UYw.LnE = new int[this.UYw.w * this.UYw.h];
    }
    int i;
    if (this.UYh.icJ())
    {
      i = OpenGlRender.FLAG_Mirror;
      if (!this.UYh.icv()) {
        break label277;
      }
    }
    label277:
    for (int j = OpenGlRender.FLAG_Angle270;; j = OpenGlRender.FLAG_Angle90)
    {
      if (this.UYl)
      {
        Log.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = ".concat(String.valueOf(com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.videoEncodeToSend(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3 + paramInt4))));
        com.tencent.mm.plugin.voip_cs.model.a locala = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC;
        locala.UFx += 1;
      }
      com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.videoEncodeToLocal(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, 0, 75, this.UYw.LnE);
      if (OpenGlRender.UNe != 1) {
        break label319;
      }
      if (!this.UIF) {
        break label285;
      }
      this.UKJ.b(this.UYw.LnE, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j);
      AppMethodBeat.o(125404);
      return;
      i = 0;
      break;
    }
    label285:
    this.UKK.b(this.UYw.LnE, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j);
    AppMethodBeat.o(125404);
    return;
    label319:
    if (OpenGlRender.UNe == 2)
    {
      if (this.UIF)
      {
        this.UKJ.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
        AppMethodBeat.o(125404);
        return;
      }
      this.UKK.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
    }
    AppMethodBeat.o(125404);
  }
  
  public final void arF(int paramInt)
  {
    AppMethodBeat.i(125400);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:".concat(String.valueOf(paramInt)));
    if (this.eln != null)
    {
      this.eln.stopTimer();
      this.eln = null;
    }
    if (!this.UYt.stopped()) {
      this.UYt.stopTimer();
    }
    if (!this.UYu.stopped()) {
      this.UYu.stopTimer();
    }
    this.UYp.hVz();
    this.UYj = false;
    this.UYe.setVisibility(0);
    this.UYe.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.UYe.setBackgroundResource(a.a.UVP);
    this.UYe.setCompoundDrawables(null, null, null, null);
    this.UYe.setCompoundDrawablePadding(0);
    this.UYe.setText(arG(paramInt));
    if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR == 2) {
      com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
      {
        public final String getKey()
        {
          return "VoipCS_play_end_sound";
        }
        
        public final void run()
        {
          AppMethodBeat.i(125378);
          a locala = a.ief();
          if (locala.wVi != null) {
            locala.wVi.p(a.d.close_lower_volume, false, 0);
          }
          AppMethodBeat.o(125378);
        }
      });
    }
    this.mRi.postDelayed(new Runnable()
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
  
  public final void bfR(String paramString)
  {
    AppMethodBeat.i(125386);
    if (!Util.isNullOrNil(paramString))
    {
      this.UYy = new b();
      if ((this.UXZ.nVM == null) || (this.UXZ.nVM.equals(""))) {
        break label81;
      }
    }
    label81:
    for (this.UYz = this.UXZ.nVM;; this.UYz = paramString)
    {
      com.tencent.threadpool.h.ahAA.bm(this.UYy);
      AppMethodBeat.o(125386);
      return;
    }
  }
  
  public final void dre()
  {
    AppMethodBeat.i(125405);
    Log.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    AppMethodBeat.o(125405);
  }
  
  public final void fQM()
  {
    AppMethodBeat.i(125397);
    this.UYt.stopTimer();
    this.UYu.stopTimer();
    this.UYp.hVz();
    this.UYd.setVisibility(8);
    this.UYc.setText(a.e.UWC);
    this.UYb.setText(a.e.UWq);
    arE(0);
    this.LvU.setOnClickListener(this);
    if ((this.UXZ.UYI != null) && (this.UXZ.UYI.equals("1")))
    {
      this.UKI.setVisibility(0);
      this.UIF = true;
      Point localPoint = GC(this.UIF);
      ((MovableVideoView)this.UKI).mG(localPoint.x, localPoint.y);
      ien();
    }
    iem();
    this.UYl = true;
    if (this.eln == null) {
      this.eln = new MTimerHandler(Looper.getMainLooper(), this.UIT, true);
    }
    if (this.UYj)
    {
      AppMethodBeat.o(125397);
      return;
    }
    if (this.UYk == -1L) {
      this.UYk = Util.nowSecond();
    }
    this.UYj = true;
    this.eln.startTimer(1000L, 1000L);
    r.hXJ().hXK();
    r.hXJ().a(this);
    AppMethodBeat.o(125397);
  }
  
  public final void fQN() {}
  
  public final void fQO()
  {
    AppMethodBeat.i(125403);
    this.UYe.setVisibility(8);
    AppMethodBeat.o(125403);
  }
  
  public final void fwx() {}
  
  public final void gG(int paramInt1, int paramInt2) {}
  
  public final void gfp()
  {
    AppMethodBeat.i(125394);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
    if (this.UYi != null)
    {
      this.UYa.removeView(this.UYi);
      this.UYi = null;
    }
    if (this.UYh != null)
    {
      this.UYh.ggH();
      this.UYh = null;
    }
    AppMethodBeat.o(125394);
  }
  
  public final void ieh()
  {
    AppMethodBeat.i(125383);
    if (this.UYt.stopped()) {
      this.UYt.startTimer(this.UYn);
    }
    AppMethodBeat.o(125383);
  }
  
  public final void iei()
  {
    AppMethodBeat.i(125384);
    if (this.UYu.stopped()) {
      this.UYu.startTimer(this.UYo);
    }
    AppMethodBeat.o(125384);
  }
  
  public final String iej()
  {
    AppMethodBeat.i(125387);
    String str = "voip_cs_headImageUrl_" + this.UXZ.UXS;
    AppMethodBeat.o(125387);
    return str;
  }
  
  public final String iek()
  {
    AppMethodBeat.i(125388);
    String str = "voip_cs_nickname_" + this.UXZ.UXS;
    AppMethodBeat.o(125388);
    return str;
  }
  
  public final void iel()
  {
    AppMethodBeat.i(125393);
    Log.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
    if (this.UYi == null)
    {
      Log.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
      this.UYi = new ObservableTextureView(this.UXZ);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
      this.UYi.setLayoutParams(localLayoutParams);
      this.UYa.addView(this.UYi, new RelativeLayout.LayoutParams(1, 1));
      this.UYi.setVisibility(0);
    }
    if (this.UYh == null)
    {
      Log.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
      this.UYh = new com.tencent.mm.plugin.voip_cs.b.a();
      this.UYh.a(this, true);
      this.UYh.a(this.UYi);
      com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.LpO = this.UYh.icw();
      this.UYh.icx();
      this.UYh.ies();
      Log.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.UYh.icJ()), Boolean.valueOf(this.UYh.icv()) });
    }
    AppMethodBeat.o(125393);
  }
  
  public final void ien()
  {
    AppMethodBeat.i(125406);
    ieo();
    this.UYx = new c();
    com.tencent.threadpool.h.ahAA.bm(this.UYx);
    Log.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    AppMethodBeat.o(125406);
  }
  
  public final void ieo()
  {
    AppMethodBeat.i(125407);
    if (this.UYx != null)
    {
      Log.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
      this.UYx.UAc = true;
      this.UYx.cancel();
      this.UYx = null;
    }
    AppMethodBeat.o(125407);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(125391);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView.getId() == a.b.UVW)
    {
      if (com.tencent.mm.plugin.voip_cs.model.c.idX().UXR < 2) {}
      for (com.tencent.mm.plugin.voip_cs.model.c.idY().dataType = 2;; com.tencent.mm.plugin.voip_cs.model.c.idY().dataType = 4)
      {
        paramView = com.tencent.mm.plugin.voip_cs.model.c.idY();
        paramView.UWW = 1;
        paramView.UXr = 1;
        paramView.UWX = ((int)(System.currentTimeMillis() / 1000L));
        paramView = com.tencent.mm.plugin.voip_cs.model.c.idY();
        Log.d("MicroMsg.VoipCSReportHelper", "selfCancel");
        if (paramView.UXo == 0)
        {
          paramView.UXj = 3;
          if ((paramView.UXs == 0L) && (paramView.UXE != 0)) {
            paramView.UXs = ((int)(System.currentTimeMillis() / 1000L) - paramView.UXE);
          }
        }
        com.tencent.mm.plugin.voip_cs.model.c.idY().idZ();
        Log.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
        arF(0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125391);
        return;
      }
    }
    if (this.LuD.getVisibility() == 0) {}
    for (int i = 8;; i = 0)
    {
      this.LuD.setVisibility(i);
      this.timeTV.setVisibility(i);
      this.UYb.setVisibility(i);
      arE(i);
      if (i == 0) {
        bool = true;
      }
      Hd(bool);
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
    if (this.UXZ.UYK) {}
    for (paramString = paramString + MMApplicationContext.getContext().getString(a.e.UWc);; paramString = paramString + MMApplicationContext.getContext().getString(a.e.UWd))
    {
      this.lBD.setText(paramString);
      AppMethodBeat.o(125385);
      return;
    }
  }
  
  public final void xy(boolean paramBoolean)
  {
    AppMethodBeat.i(125402);
    this.UYe.setVisibility(0);
    this.UYe.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.UYe.setBackgroundResource(a.a.UVP);
    this.UYe.setCompoundDrawables(null, null, null, null);
    this.UYe.setCompoundDrawablePadding(0);
    this.UYe.setText(arG(1001));
    AppMethodBeat.o(125402);
  }
  
  final class a
  {
    int[] LnE;
    int h;
    int w;
    
    private a() {}
  }
  
  final class b
    extends com.tencent.threadpool.i.b
  {
    b() {}
    
    public final String getKey()
    {
      return "VOIPCS_netPic";
    }
    
    public final void run()
    {
      AppMethodBeat.i(125380);
      b.this.UYA = b.bfS(b.this.UYz);
      Message localMessage = new Message();
      localMessage.what = 12;
      b.s(b.this).sendMessage(localMessage);
      b.this.UYy.cancel();
      AppMethodBeat.o(125380);
    }
  }
  
  final class c
    extends com.tencent.threadpool.i.b
  {
    boolean UAc = false;
    byte[] UAd = null;
    
    c() {}
    
    public final String getKey()
    {
      return "VOIPCS_VideoDecode";
    }
    
    public final void run()
    {
      AppMethodBeat.i(125381);
      if ((!this.UAc) && (!b.p(b.this)))
      {
        if (this.UAd == null) {
          this.UAd = new byte[com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.defaultWidth * com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.defaultHeight * 3 / 2];
        }
        int i;
        int j;
        if (com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.videoDecode(this.UAd) == 1)
        {
          i = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.field_remoteImgWidth;
          j = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.field_remoteImgHeight;
          if (OpenGlRender.UNe != 1) {
            break label196;
          }
          if (!b.i(b.this)) {
            break label165;
          }
          b.q(b.this).b(com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.UEW, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90);
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
          label165:
          b.r(b.this).b(com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.UEW, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90);
          continue;
          label196:
          if (b.i(b.this)) {
            b.q(b.this).a(this.UAd, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
          } else {
            b.r(b.this).a(this.UAd, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
          }
        }
      }
      AppMethodBeat.o(125381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.a.b
 * JD-Core Version:    0.7.0.1
 */