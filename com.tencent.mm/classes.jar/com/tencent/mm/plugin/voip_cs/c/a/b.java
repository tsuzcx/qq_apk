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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

public final class b
  implements TextureView.SurfaceTextureListener, View.OnClickListener, r.a, com.tencent.mm.plugin.voip.video.f
{
  protected static final int[] CAI = { -1, 2131764841, 2131764846, 2131764845 };
  protected static int mScreenHeight;
  protected static int mScreenWidth;
  private View.OnClickListener CAl;
  public OpenGlRender CBA;
  public OpenGlRender CBB;
  private OpenGlView CBy;
  private OpenGlView CBz;
  String CNA;
  Drawable CNB;
  public VoipCSMainUI CNd;
  private RelativeLayout CNe;
  private TextView CNf;
  private TextView CNg;
  private TextView CNh;
  private TextView CNi;
  public ImageView CNj;
  private aq CNk;
  private com.tencent.mm.plugin.voip_cs.d.a CNl;
  private boolean CNm;
  protected long CNn;
  private boolean CNo;
  private boolean CNp;
  private int CNq;
  private int CNr;
  private com.tencent.mm.plugin.voip_cs.d.b CNs;
  public String CNt;
  public String CNu;
  private aw CNv;
  private aw CNw;
  a CNx;
  c CNy;
  b CNz;
  private boolean CzO;
  private VoipBigIconButton Czv;
  private Timer cOI;
  public boolean dus;
  public TextView fQm;
  private TextView fVV;
  private aq gKO;
  private ImageButton wvJ;
  private View wwe;
  private ObservableTextureView wws;
  
  public b(VoipCSMainUI paramVoipCSMainUI)
  {
    AppMethodBeat.i(125382);
    this.CzO = false;
    this.dus = false;
    this.CNm = false;
    this.CNn = -1L;
    this.CNo = false;
    this.CNp = false;
    this.CNq = 60000;
    this.CNr = 5000;
    this.CNs = new com.tencent.mm.plugin.voip_cs.d.b();
    this.CNt = "";
    this.CNu = "";
    this.CNv = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125370);
        ae.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
        com.tencent.mm.plugin.voip_cs.c.c.eFl().dataType = 1;
        b.this.VL(6);
        AppMethodBeat.o(125370);
        return true;
      }
    }, false);
    this.CNw = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125371);
        b.a(b.this).setText(ak.getContext().getString(2131764848));
        b.b(b.this).setVisibility(0);
        com.tencent.mm.plugin.voip_cs.d.b localb = b.c(b.this);
        TextView localTextView = b.b(b.this);
        Object localObject = b.CAI;
        if ((localObject == null) || (localTextView == null)) {
          ae.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
        }
        for (;;)
        {
          AppMethodBeat.o(125371);
          return true;
          localb.eCG();
          localb.CAW = 0;
          localb.CAU = ((int[])localObject);
          localb.Wf = localTextView;
          localb.CAV = 500;
          if (localb.cji != null)
          {
            localObject = localb.cji;
            long l = localb.CAV;
            ((aw)localObject).ay(l, l);
          }
          ae.l("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(localTextView)), new Object[0]);
        }
      }
    }, false);
    this.CAl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125372);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
        b.d(b.this).setEnabled(false);
        if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV > 1) {
          b.e(b.this);
        }
        b.d(b.this).setEnabled(true);
        if (b.f(b.this) != null) {
          b.f(b.this).eDQ();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125372);
      }
    };
    this.CNx = new a((byte)0);
    this.CNA = "";
    this.CNB = null;
    this.CNd = paramVoipCSMainUI;
    Object localObject = (WindowManager)paramVoipCSMainUI.getSystemService("window");
    int i = ((WindowManager)localObject).getDefaultDisplay().getHeight() / 5;
    int j = ((WindowManager)localObject).getDefaultDisplay().getWidth() * i / ((WindowManager)localObject).getDefaultDisplay().getHeight();
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      ((RelativeLayout)paramVoipCSMainUI.findViewById(2131304206)).setPadding(0, 0, 0, BackwardSupportUtil.b.h(paramVoipCSMainUI.getContext(), 40.0F));
    }
    this.CBz = new MovableVideoView(paramVoipCSMainUI.getApplicationContext());
    ((MovableVideoView)this.CBz).iA(j, i);
    this.CBz.setVisibility(8);
    this.CBA = new OpenGlRender(this.CBz, OpenGlRender.RenderRemote);
    this.CBz.setRenderer(this.CBA);
    this.CBz.setRenderMode(0);
    this.fVV = ((TextView)paramVoipCSMainUI.findViewById(2131305822));
    this.fVV.setVisibility(0);
    this.cOI = new Timer("voip_cs_talking_time");
    this.CNf = ((TextView)paramVoipCSMainUI.findViewById(2131306563));
    this.CNf.setVisibility(0);
    this.CNg = ((TextView)paramVoipCSMainUI.findViewById(2131306568));
    if (paramVoipCSMainUI.scene.equals("1")) {
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.CNg.setText(ak.getContext().getString(2131764824));
        this.CNg.setVisibility(0);
        this.fQm = ((TextView)paramVoipCSMainUI.findViewById(2131306571));
        this.fQm.setVisibility(0);
        this.CNj = ((ImageView)paramVoipCSMainUI.findViewById(2131306564));
        this.CNj.setVisibility(0);
        this.CNi = ((TextView)paramVoipCSMainUI.findViewById(2131306567));
        this.CNh = ((TextView)paramVoipCSMainUI.findViewById(2131306569));
        this.Czv = ((VoipBigIconButton)paramVoipCSMainUI.findViewById(2131306565));
        if ((paramVoipCSMainUI.CNJ == null) || (!paramVoipCSMainUI.CNJ.equals("1"))) {
          break label1031;
        }
        this.Czv.setVisibility(0);
        this.Czv.setOnClickListener(this.CAl);
        label567:
        this.gKO = new aq();
        this.CNk = new aq()
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
              if (b.this.CNB != null)
              {
                b.g(b.this).setImageDrawable(b.this.CNB);
                AppMethodBeat.o(125373);
                return;
              }
              b.g(b.this).setImageResource(2131231875);
            }
          }
        };
        this.wwe = paramVoipCSMainUI.findViewById(2131306560);
        this.wvJ = ((ImageButton)paramVoipCSMainUI.findViewById(2131306566));
        this.CNe = ((RelativeLayout)paramVoipCSMainUI.findViewById(2131306560));
        mScreenWidth = com.tencent.mm.cb.a.iu(paramVoipCSMainUI.getContext());
        mScreenHeight = com.tencent.mm.plugin.voip_cs.d.c.gN(paramVoipCSMainUI.getContext());
        this.CBy = ((OpenGlView)paramVoipCSMainUI.findViewById(2131306561));
        this.CBy.iB(mScreenWidth, mScreenHeight);
        this.CBB = new OpenGlRender(this.CBy, OpenGlRender.RenderLocal);
        this.CBy.setRenderer(this.CBB);
        this.CBy.setRenderMode(0);
        this.CBy.setVisibility(0);
        ae.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[] { Integer.valueOf(mScreenHeight) });
        this.wvJ.setOnClickListener(this);
        this.CNe.addView(this.CBz);
        this.CBz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(125374);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = b.this;
            if (!b.h(b.this)) {}
            for (boolean bool = true;; bool = false)
            {
              b.a(paramAnonymousView, bool);
              paramAnonymousView = b.b(b.this, b.h(b.this));
              b.i(b.this).iC(paramAnonymousView.x, paramAnonymousView.y);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(125374);
              return;
            }
          }
        });
        this.CBA.onStarted();
        this.CBB.onStarted();
        if (!n.gH(ak.getContext())) {
          n.gI(ak.getContext());
        }
        paramVoipCSMainUI = ak.fox();
        this.CNt = paramVoipCSMainUI.getString(eFx(), "");
        if ((this.CNd.jpU == null) || (this.CNd.jpU.equals(""))) {
          break label1043;
        }
        aFg(this.CNd.jpU);
      }
    }
    for (;;)
    {
      this.CNu = paramVoipCSMainUI.getString(eFy(), "");
      if (!bu.isNullOrNil(this.CNu)) {
        setNickName(this.CNu);
      }
      paramVoipCSMainUI = com.tencent.mm.plugin.voip_cs.c.c.eFk();
      localObject = this.CNd.CMW;
      ae.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:".concat(String.valueOf(localObject)));
      g.ajj().a(106, paramVoipCSMainUI);
      paramVoipCSMainUI = new com.tencent.mm.plugin.messenger.a.f((String)localObject);
      g.ajj().a(paramVoipCSMainUI, 0);
      AppMethodBeat.o(125382);
      return;
      this.CNg.setText(ak.getContext().getString(2131764825));
      break;
      if (paramVoipCSMainUI.type.equals("video"))
      {
        this.CNg.setText(ak.getContext().getString(2131764826));
        break;
      }
      this.CNg.setText(ak.getContext().getString(2131764825));
      break;
      label1031:
      this.Czv.setVisibility(8);
      break label567;
      label1043:
      if (!bu.isNullOrNil(this.CNt)) {
        aFg(this.CNt);
      }
    }
  }
  
  private void VK(int paramInt)
  {
    AppMethodBeat.i(125392);
    if ((this.CNd.CNJ != null) && (this.CNd.CNJ.equals("1")))
    {
      this.Czv.setVisibility(paramInt);
      AppMethodBeat.o(125392);
      return;
    }
    this.Czv.setVisibility(8);
    AppMethodBeat.o(125392);
  }
  
  private static int VM(int paramInt)
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
    if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV < 2)
    {
      AppMethodBeat.o(125401);
      return 2131764819;
    }
    AppMethodBeat.o(125401);
    return 2131764828;
  }
  
  public static Drawable aFh(String paramString)
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
      ae.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
      AppMethodBeat.o(125398);
    }
    return null;
  }
  
  private void eFB()
  {
    AppMethodBeat.i(125395);
    ae.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
    this.gKO.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(125375);
        ae.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
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
  
  protected static String sz(long paramLong)
  {
    AppMethodBeat.i(125399);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(125399);
    return str;
  }
  
  private Point tB(boolean paramBoolean)
  {
    AppMethodBeat.i(125389);
    int i = ((WindowManager)this.CNd.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
    float f = i;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Point localPoint = new Point((int)(tw(paramBoolean) * f), i);
      AppMethodBeat.o(125389);
      return localPoint;
    }
  }
  
  private void tV(boolean paramBoolean)
  {
    AppMethodBeat.i(125396);
    if (Build.MANUFACTURER.equalsIgnoreCase("sony"))
    {
      ae.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
      AppMethodBeat.o(125396);
      return;
    }
    if (!paramBoolean)
    {
      this.CNd.getWindow().setFlags(1024, 1024);
      AppMethodBeat.o(125396);
      return;
    }
    this.CNd.getWindow().clearFlags(1024);
    AppMethodBeat.o(125396);
  }
  
  private static float tw(boolean paramBoolean)
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
        localObject = com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.field_capInfo;
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
          ae.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
          f2 = f1;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        ae.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + localException.getMessage());
        continue;
      }
      AppMethodBeat.o(125390);
      return f2;
      f2 = f1;
      localObject = com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.CwJ;
    }
  }
  
  public final void VL(int paramInt)
  {
    AppMethodBeat.i(125400);
    ae.i("MicroMsg.voipcs.VoipCSViewManager", "onRefreshed for action:".concat(String.valueOf(paramInt)));
    if (this.cOI != null)
    {
      this.cOI.cancel();
      this.cOI = null;
    }
    if (!this.CNv.foU()) {
      this.CNv.stopTimer();
    }
    if (!this.CNw.foU()) {
      this.CNw.stopTimer();
    }
    this.CNs.eCG();
    this.CNm = false;
    this.CNi.setVisibility(0);
    this.CNi.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.CNi.setBackgroundResource(2131234566);
    this.CNi.setCompoundDrawables(null, null, null, null);
    this.CNi.setCompoundDrawablePadding(0);
    this.CNi.setText(VM(paramInt));
    if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV == 2) {
      com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "VoipCS_play_end_sound";
        }
        
        public final void run()
        {
          AppMethodBeat.i(125378);
          a locala = a.eFt();
          if (locala.ped != null) {
            locala.ped.X(false, 0);
          }
          AppMethodBeat.o(125378);
        }
      });
    }
    this.gKO.postDelayed(new Runnable()
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
    ae.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.dus);
    if (this.dus)
    {
      AppMethodBeat.o(125404);
      return;
    }
    if (this.CNx.wwH == null)
    {
      this.CNx.w = paramInt1;
      this.CNx.h = paramInt2;
      this.CNx.wwH = new int[this.CNx.w * this.CNx.h];
    }
    int i;
    if (this.CNl.eDU())
    {
      i = OpenGlRender.FLAG_Mirror;
      if (!this.CNl.eDV()) {
        break label278;
      }
    }
    label278:
    for (int j = OpenGlRender.FLAG_Angle270;; j = OpenGlRender.FLAG_Angle90)
    {
      if (this.CNo)
      {
        ae.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = ".concat(String.valueOf(com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.videoEncodeToSend(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3 + paramInt4))));
        com.tencent.mm.plugin.voip_cs.c.a locala = com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE;
        locala.Cyr += 1;
      }
      com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.videoEncodeToLocal(paramArrayOfByte, (int)paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, 0, 75, this.CNx.wwH);
      if (OpenGlRender.CFf != 1) {
        break label321;
      }
      if (!this.CzO) {
        break label286;
      }
      this.CBA.a(this.CNx.wwH, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
      AppMethodBeat.o(125404);
      return;
      i = 0;
      break;
    }
    label286:
    this.CBB.a(this.CNx.wwH, paramInt1, paramInt2, OpenGlRender.FLAG_RGBAClip + i + j, false);
    AppMethodBeat.o(125404);
    return;
    label321:
    if (OpenGlRender.CFf == 2)
    {
      if (this.CzO)
      {
        this.CBA.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
        AppMethodBeat.o(125404);
        return;
      }
      this.CBB.a(paramArrayOfByte, paramInt1, paramInt2, OpenGlRender.FLAG_NV21 + i + j, false, 3);
    }
    AppMethodBeat.o(125404);
  }
  
  public final void aFg(String paramString)
  {
    AppMethodBeat.i(125386);
    if (!bu.isNullOrNil(paramString))
    {
      this.CNz = new b();
      if ((this.CNd.jpU == null) || (this.CNd.jpU.equals(""))) {
        break label81;
      }
    }
    label81:
    for (this.CNA = this.CNd.jpU;; this.CNA = paramString)
    {
      com.tencent.e.h.MqF.aO(this.CNz);
      AppMethodBeat.o(125386);
      return;
    }
  }
  
  public final void cbl()
  {
    AppMethodBeat.i(125405);
    ae.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    AppMethodBeat.o(125405);
  }
  
  public final void dfV()
  {
    AppMethodBeat.i(125397);
    this.CNv.stopTimer();
    this.CNw.stopTimer();
    this.CNs.eCG();
    this.CNh.setVisibility(8);
    this.CNg.setText(2131764844);
    this.CNf.setText(2131764832);
    VK(0);
    this.wwe.setOnClickListener(this);
    if ((this.CNd.CNK != null) && (this.CNd.CNK.equals("1")))
    {
      this.CBz.setVisibility(0);
      this.CzO = true;
      localObject = tB(this.CzO);
      ((MovableVideoView)this.CBz).iA(((Point)localObject).x, ((Point)localObject).y);
      eFC();
    }
    eFB();
    this.CNo = true;
    if (this.cOI == null) {
      this.cOI = new Timer("voip_cs_talking_time");
    }
    if (this.CNm)
    {
      AppMethodBeat.o(125397);
      return;
    }
    if (this.CNn == -1L) {
      this.CNn = bu.aRi();
    }
    this.CNm = true;
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
            String str = b.sz(bu.rZ(b.this.CNn));
            b.l(b.this).setText(str);
            AppMethodBeat.o(125376);
          }
        });
        AppMethodBeat.o(125377);
      }
    };
    this.cOI.schedule((TimerTask)localObject, 1000L, 1000L);
    r.eAx().eAy();
    r.eAx().a(this);
    AppMethodBeat.o(125397);
  }
  
  public final void dfW() {}
  
  public final void dfX()
  {
    AppMethodBeat.i(125403);
    this.CNi.setVisibility(8);
    AppMethodBeat.o(125403);
  }
  
  public final void eFA()
  {
    AppMethodBeat.i(125394);
    ae.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
    if (this.wws != null)
    {
      this.CNe.removeView(this.wws);
      this.wws = null;
    }
    if (this.CNl != null)
    {
      this.CNl.eDT();
      this.CNl = null;
    }
    AppMethodBeat.o(125394);
  }
  
  public final void eFC()
  {
    AppMethodBeat.i(125406);
    eFD();
    this.CNy = new c();
    com.tencent.e.h.MqF.aO(this.CNy);
    ae.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    AppMethodBeat.o(125406);
  }
  
  public final void eFD()
  {
    AppMethodBeat.i(125407);
    if (this.CNy != null)
    {
      ae.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
      this.CNy.Ctp = true;
      this.CNy.cancel();
      this.CNy = null;
    }
    AppMethodBeat.o(125407);
  }
  
  public final void eFv()
  {
    AppMethodBeat.i(125383);
    if (this.CNv.foU())
    {
      aw localaw = this.CNv;
      long l = this.CNq;
      localaw.ay(l, l);
    }
    AppMethodBeat.o(125383);
  }
  
  public final void eFw()
  {
    AppMethodBeat.i(125384);
    if (this.CNw.foU())
    {
      aw localaw = this.CNw;
      long l = this.CNr;
      localaw.ay(l, l);
    }
    AppMethodBeat.o(125384);
  }
  
  public final String eFx()
  {
    AppMethodBeat.i(125387);
    String str = "voip_cs_headImageUrl_" + this.CNd.CMW;
    AppMethodBeat.o(125387);
    return str;
  }
  
  public final String eFy()
  {
    AppMethodBeat.i(125388);
    String str = "voip_cs_nickname_" + this.CNd.CMW;
    AppMethodBeat.o(125388);
    return str;
  }
  
  public final void eFz()
  {
    AppMethodBeat.i(125393);
    ae.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
    if (this.wws == null)
    {
      ae.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
      this.wws = new ObservableTextureView(this.CNd);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
      this.wws.setLayoutParams(localLayoutParams);
      this.CNe.addView(this.wws, new RelativeLayout.LayoutParams(1, 1));
      this.wws.setVisibility(0);
    }
    if (this.CNl == null)
    {
      ae.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
      this.CNl = new com.tencent.mm.plugin.voip_cs.d.a();
      this.CNl.a(this, true);
      this.CNl.a(this.wws);
      com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.CwW = this.CNl.eDW();
      this.CNl.eDS();
      this.CNl.eFI();
      ae.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[] { Boolean.valueOf(this.CNl.eDU()), Boolean.valueOf(this.CNl.eDV()) });
    }
    AppMethodBeat.o(125393);
  }
  
  public final void nC(boolean paramBoolean)
  {
    AppMethodBeat.i(125402);
    this.CNi.setVisibility(0);
    this.CNi.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.CNi.setBackgroundResource(2131234566);
    this.CNi.setCompoundDrawables(null, null, null, null);
    this.CNi.setCompoundDrawablePadding(0);
    this.CNi.setText(VM(1001));
    AppMethodBeat.o(125402);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(125391);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView.getId() == 2131306566)
    {
      if (com.tencent.mm.plugin.voip_cs.c.c.eFk().CMV < 2) {}
      for (com.tencent.mm.plugin.voip_cs.c.c.eFl().dataType = 2;; com.tencent.mm.plugin.voip_cs.c.c.eFl().dataType = 4)
      {
        paramView = com.tencent.mm.plugin.voip_cs.c.c.eFl();
        paramView.CMa = 1;
        paramView.CMv = 1;
        paramView.CMb = ((int)(System.currentTimeMillis() / 1000L));
        paramView = com.tencent.mm.plugin.voip_cs.c.c.eFl();
        ae.d("MicroMsg.VoipCSReportHelper", "selfCancel");
        if (paramView.CMs == 0)
        {
          paramView.CMn = 3;
          if ((paramView.CMw == 0L) && (paramView.CMI != 0)) {
            paramView.CMw = ((int)(System.currentTimeMillis() / 1000L) - paramView.CMI);
          }
        }
        com.tencent.mm.plugin.voip_cs.c.c.eFl().eFm();
        ae.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
        VL(0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip_cs/model/device/VoipCSViewManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125391);
        return;
      }
    }
    if (this.wvJ.getVisibility() == 0) {}
    for (int i = 8;; i = 0)
    {
      this.wvJ.setVisibility(i);
      this.fVV.setVisibility(i);
      this.CNf.setVisibility(i);
      VK(i);
      if (i == 0) {
        bool = true;
      }
      tV(bool);
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
    if (this.CNd.CNM) {}
    for (paramString = paramString + ak.getContext().getString(2131764815);; paramString = paramString + ak.getContext().getString(2131764816))
    {
      this.fQm.setText(paramString);
      AppMethodBeat.o(125385);
      return;
    }
  }
  
  final class a
  {
    int h;
    int w;
    int[] wwH;
    
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
      b.this.CNB = b.aFh(b.this.CNA);
      Message localMessage = new Message();
      localMessage.what = 12;
      b.t(b.this).sendMessage(localMessage);
      b.this.CNz.cancel();
      AppMethodBeat.o(125380);
    }
  }
  
  final class c
    extends com.tencent.e.i.b
  {
    boolean Ctp = false;
    byte[] Ctq = null;
    
    c() {}
    
    public final String getKey()
    {
      return "VOIPCS_VideoDecode";
    }
    
    public final void run()
    {
      AppMethodBeat.i(125381);
      if ((!this.Ctp) && (!b.q(b.this)))
      {
        if (this.Ctq == null) {
          this.Ctq = new byte[com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.defaultWidth * com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.defaultHeight * 3 / 2];
        }
        int i;
        int j;
        if (com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.videoDecode(this.Ctq) == 1)
        {
          i = com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.field_remoteImgWidth;
          j = com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.field_remoteImgHeight;
          if (OpenGlRender.CFf != 1) {
            break label198;
          }
          if (!b.h(b.this)) {
            break label166;
          }
          b.r(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.CxR, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
        }
        for (;;)
        {
          try
          {
            Thread.sleep(20L);
          }
          catch (InterruptedException localInterruptedException)
          {
            ae.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", localInterruptedException, "", new Object[0]);
          }
          break;
          label166:
          b.s(b.this).a(com.tencent.mm.plugin.voip_cs.c.c.eFj().CNE.CxR, i, j, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
          continue;
          label198:
          if (b.h(b.this)) {
            b.r(b.this).a(this.Ctq, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
          } else {
            b.s(b.this).a(this.Ctq, i, j, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
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