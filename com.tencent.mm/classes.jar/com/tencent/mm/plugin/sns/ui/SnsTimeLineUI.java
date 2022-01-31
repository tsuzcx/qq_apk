package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.model.cb;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sns.a.b.i.5;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.i.b.2;
import com.tencent.mm.plugin.sns.k.c.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.vending.app.a.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@com.tencent.mm.kernel.i
public class SnsTimeLineUI
  extends WxPresenterActivity
  implements com.tencent.mm.ai.f, com.tencent.mm.model.ar, h.a, t
{
  private static Handler h;
  public static final Boolean rYc;
  private static HandlerThread rYn;
  private static final Set<Activity> sUILeaksRoutineEnsuranceRef;
  private long eCX;
  private int eez;
  private long fAA;
  private String ikj;
  private ActionBar mActionBar;
  private com.tencent.matrix.trace.e.b mCa;
  private int mScreenHeight;
  private int mScreenWidth;
  private String mSessionId;
  private SnsUIAction mUIAction;
  private boolean oXs;
  private long otr;
  private int pcb;
  private View pyE;
  private com.tencent.mm.ui.statusbar.c.a pyG;
  private boolean rFt;
  private boolean rHl;
  protected com.tencent.mm.plugin.sns.a.b.g rOU;
  private com.tencent.mm.plugin.sns.i.a rXA;
  private aw rXB;
  private au rXC;
  private String rXD;
  private boolean rXE;
  private int rXF;
  private String rXG;
  private String rXH;
  private SnsTimeLineUI.c rXI;
  private ar rXJ;
  private Runnable rXK;
  private com.tencent.mm.sdk.b.c rXL;
  private com.tencent.mm.sdk.b.c rXM;
  private boolean rXN;
  private com.tencent.mm.sdk.b.c rXO;
  private com.tencent.mm.sdk.b.c rXP;
  private com.tencent.mm.sdk.b.c rXQ;
  private com.tencent.mm.sdk.b.c rXR;
  private com.tencent.mm.sdk.b.c rXS;
  private com.tencent.mm.sdk.b.c rXT;
  private com.tencent.mm.sdk.b.c rXU;
  private com.tencent.mm.sdk.b.c rXV;
  private com.tencent.mm.sdk.b.c rXW;
  private com.tencent.mm.sdk.b.c rXX;
  private com.tencent.mm.sdk.b.c rXY;
  private com.tencent.mm.sdk.b.c rXZ;
  private final long rXi;
  private long rXj;
  private com.tencent.mm.plugin.sns.k.b rXk;
  private com.tencent.mm.plugin.sns.k.a rXl;
  private com.tencent.mm.plugin.sns.ui.a.a.c rXm;
  private com.tencent.mm.plugin.sns.ui.a.c rXn;
  private LinearLayout rXo;
  private LinearLayout rXp;
  private QFadeImageView rXq;
  private boolean rXr;
  private boolean rXs;
  private i rXt;
  private int rXu;
  private SnsTimeLineUI.a rXv;
  private TestTimeForSns rXw;
  private int rXx;
  private boolean rXy;
  private String rXz;
  private com.tencent.mm.sdk.b.c rYa;
  private com.tencent.mm.sdk.b.c rYb;
  private long rYd;
  boolean rYe;
  Runnable rYf;
  Runnable rYg;
  private Handler rYh;
  private Runnable rYi;
  private SnsUIAction.a rYj;
  private long rYk;
  private a.b rYl;
  boolean rYm;
  int rYo;
  private MenuItem.OnMenuItemClickListener rYp;
  private ImageView rYq;
  private View rYr;
  private ay rYs;
  private View.OnClickListener rYt;
  private boolean rYu;
  private com.tencent.mm.sdk.b.c rir;
  private boolean rmd;
  
  static
  {
    AppMethodBeat.i(39602);
    rYc = Boolean.FALSE;
    sUILeaksRoutineEnsuranceRef = new HashSet();
    HandlerThread localHandlerThread = new HandlerThread("sns");
    rYn = localHandlerThread;
    localHandlerThread.start();
    h = new Handler(rYn.getLooper());
    AppMethodBeat.o(39602);
  }
  
  public SnsTimeLineUI()
  {
    AppMethodBeat.i(39554);
    this.rXi = 300L;
    this.rXj = SystemClock.elapsedRealtime();
    this.rXk = ((com.tencent.mm.plugin.sns.k.b)P(com.tencent.mm.plugin.sns.k.b.class));
    if (this.rXk != null) {}
    for (com.tencent.mm.plugin.sns.k.a locala = this.rXk.cxQ();; locala = null)
    {
      this.rXl = locala;
      this.rXm = new com.tencent.mm.plugin.sns.ui.a.a.c();
      this.rXr = false;
      this.rXs = false;
      this.rFt = false;
      this.rXu = 800;
      this.rXx = 0;
      this.rXy = false;
      this.rXz = "";
      this.rXA = new com.tencent.mm.plugin.sns.i.a();
      this.rOU = new com.tencent.mm.plugin.sns.a.b.g(1);
      this.rXB = new aw();
      this.rXC = new au();
      this.oXs = false;
      this.rXH = "";
      this.rXI = new SnsTimeLineUI.c(this, (byte)0);
      this.rXJ = new ar();
      this.rXK = new SnsTimeLineUI.1(this);
      this.rXL = new SnsTimeLineUI.12(this);
      this.rXM = new SnsTimeLineUI.23(this);
      this.rXN = false;
      this.rmd = false;
      this.rXO = new com.tencent.mm.sdk.b.c() {};
      this.rXP = new SnsTimeLineUI.45(this);
      this.rXQ = new SnsTimeLineUI.56(this);
      this.rXR = new com.tencent.mm.sdk.b.c() {};
      this.rXS = new com.tencent.mm.sdk.b.c() {};
      this.rXT = new com.tencent.mm.sdk.b.c() {};
      this.rXU = new SnsTimeLineUI.2(this);
      this.rXV = new SnsTimeLineUI.3(this);
      this.rXW = new SnsTimeLineUI.4(this);
      this.rir = new SnsTimeLineUI.5(this);
      this.rXX = new SnsTimeLineUI.6(this);
      this.rXY = new SnsTimeLineUI.7(this);
      this.rXZ = new SnsTimeLineUI.8(this);
      this.rYa = new SnsTimeLineUI.9(this);
      this.rYb = new SnsTimeLineUI.10(this);
      this.rYd = 0L;
      this.rYe = false;
      this.pcb = 0;
      this.rYf = new SnsTimeLineUI.17(this);
      this.rYg = new SnsTimeLineUI.18(this);
      this.rYh = ((com.tencent.mm.vending.h.b)com.tencent.mm.vending.h.d.AOX.APc).a;
      this.rYi = new SnsTimeLineUI.19(this);
      this.rYj = new SnsTimeLineUI.22(this);
      this.rYk = 0L;
      this.rYl = new SnsTimeLineUI.24(this);
      this.mScreenWidth = 0;
      this.mScreenHeight = 0;
      this.rYm = true;
      this.otr = 0L;
      this.eCX = 0L;
      this.fAA = 0L;
      this.mCa = new com.tencent.matrix.trace.e.b()
      {
        public final void a(String paramAnonymousString, long paramAnonymousLong, int paramAnonymousInt)
        {
          AppMethodBeat.i(155741);
          super.a(paramAnonymousString, paramAnonymousLong, paramAnonymousInt);
          if ((paramAnonymousInt > 0) && (!bo.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.endsWith(SnsTimeLineUI.this.getClass().getSimpleName()))) {
            SnsTimeLineUI.b(SnsTimeLineUI.this, SnsTimeLineUI.J(SnsTimeLineUI.this) + paramAnonymousInt);
          }
          AppMethodBeat.o(155741);
        }
      };
      this.rYo = 0;
      this.rYp = new SnsTimeLineUI.47(this);
      this.rYs = null;
      this.rYt = new SnsTimeLineUI.57(this);
      this.rYu = false;
      AppMethodBeat.o(39554);
      return;
    }
  }
  
  private void EX(int paramInt)
  {
    AppMethodBeat.i(39558);
    if (rYc.booleanValue()) {
      if (paramInt != 0) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.SnsTimeLineUI", "setRefreshAnimVisible %s %s", new Object[] { Boolean.valueOf(bool), bo.dtY().toString() });
      this.rXq.setVisibility(paramInt);
      AppMethodBeat.o(39558);
      return;
    }
  }
  
  private static void a(SnsTimeLineUI.c paramc)
  {
    AppMethodBeat.i(39585);
    if (paramc.active)
    {
      ab.d("MicroMsg.SnsTimeLineUI", "report weishi: %s", new Object[] { paramc.toString() });
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(15827, paramc.toString());
    }
    AppMethodBeat.o(39585);
  }
  
  private void cwa()
  {
    AppMethodBeat.i(145623);
    this.mUIAction.list.post(new SnsTimeLineUI.20(this));
    AppMethodBeat.o(145623);
  }
  
  private void cwb()
  {
    AppMethodBeat.i(155768);
    boolean bool;
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSu, 0) == 1)
    {
      bool = true;
      this.oXs = bool;
      String str1 = Build.MODEL.toLowerCase();
      String str2 = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSv, "");
      if ((!bo.isNullOrNil(str2)) && (str2.contains(str1)))
      {
        ab.i("MicroMsg.SnsTimeLineUI", "model %s is hit, expt:%s", new Object[] { str1, str2 });
        this.oXs = false;
      }
      if (!this.oXs) {
        break label225;
      }
      if (!this.rXJ.bTw()) {
        break label170;
      }
      this.oXs = false;
      ab.i("MicroMsg.SnsTimeLineUI", "2G/3G autoplay false");
    }
    for (;;)
    {
      ab.i("MicroMsg.SnsTimeLineUI", "autoPlay:%s", new Object[] { Boolean.valueOf(this.oXs) });
      AppMethodBeat.o(155768);
      return;
      bool = false;
      break;
      label170:
      if (this.rXJ.blP())
      {
        ab.i("MicroMsg.SnsTimeLineUI", "wifi autoplay true");
        this.oXs = true;
      }
      else
      {
        this.oXs = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yEK, Boolean.TRUE)).booleanValue();
        continue;
        label225:
        ab.i("MicroMsg.SnsTimeLineUI", "autoPlay DynamicConfig false");
      }
    }
  }
  
  private void cwc()
  {
    AppMethodBeat.i(39561);
    if (this.rYo == 1)
    {
      if (!this.rHl)
      {
        enableOptionMenu(false);
        AppMethodBeat.o(39561);
        return;
      }
      addIconOptionMenu(0, getString(2131303900), 2131230749, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(145592);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
          paramAnonymousMenuItem.putExtra("sns_msg_force_show_all", true);
          paramAnonymousMenuItem.putExtra("sns_msg_comment_list_scene", 1);
          SnsTimeLineUI.this.startActivityForResult(paramAnonymousMenuItem, 8);
          AppMethodBeat.o(145592);
          return true;
        }
      });
      AppMethodBeat.o(39561);
      return;
    }
    addIconOptionMenu(0, 2131303736, 2131231442, new SnsTimeLineUI.30(this), new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(155740);
        if ((SnsTimeLineUI.i(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.i(SnsTimeLineUI.this).rFl != null)) {
          SnsTimeLineUI.i(SnsTimeLineUI.this).rFl.rhS.lg(true);
        }
        com.tencent.mm.kernel.g.RM();
        boolean bool = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(7490, Boolean.TRUE)).booleanValue();
        com.tencent.mm.kernel.g.RM();
        paramAnonymousView = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yzV, null);
        Object localObject;
        if (!bo.isNullOrNil(paramAnonymousView))
        {
          paramAnonymousView = com.tencent.e.f.e.awF(paramAnonymousView);
          localObject = Parcel.obtain();
          ((Parcel)localObject).unmarshall(paramAnonymousView, 0, paramAnonymousView.length);
          ((Parcel)localObject).setDataPosition(0);
          try
          {
            paramAnonymousView = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject);
            SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
            AppMethodBeat.o(155740);
            return true;
          }
          catch (Exception paramAnonymousView)
          {
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzV, "");
          }
        }
        if (!bool)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(SnsTimeLineUI.this, SnsUploadUI.class);
          paramAnonymousView.putExtra("KSnsPostManu", true);
          paramAnonymousView.putExtra("KTouchCameraTime", bo.aox());
          paramAnonymousView.putExtra("sns_comment_type", 1);
          paramAnonymousView.putExtra("Ksnsupload_type", 9);
          localObject = com.tencent.mm.modelsns.b.lV(705);
          ((com.tencent.mm.modelsns.b)localObject).lZ(((com.tencent.mm.modelsns.b)localObject).fQC).uw(System.currentTimeMillis()).lZ(((com.tencent.mm.modelsns.b)localObject).fQD).lZ(1);
          localObject = com.tencent.mm.plugin.sns.i.g.roZ.b((com.tencent.mm.modelsns.b)localObject);
          ((com.tencent.mm.modelsns.b)localObject).ake();
          ((com.tencent.mm.modelsns.b)localObject).b(paramAnonymousView, "intent_key_StatisticsOplog");
          SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
        }
        for (;;)
        {
          AppMethodBeat.o(155740);
          return true;
          SnsTimeLineUI.this.startActivity(new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class));
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RL().Ru().set(7490, Boolean.FALSE);
        }
      }
    });
    AppMethodBeat.o(39561);
  }
  
  private void cwd()
  {
    AppMethodBeat.i(39571);
    setTitleBarClickListener(new SnsTimeLineUI.48(this), new SnsTimeLineUI.49(this));
    setBackBtn(this.rYp, 2131230737);
    AppMethodBeat.o(39571);
  }
  
  private void cwe()
  {
    AppMethodBeat.i(39572);
    if (com.tencent.mm.r.a.bM(this))
    {
      AppMethodBeat.o(39572);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "");
    ab.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this });
    if (!bool)
    {
      AppMethodBeat.o(39572);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 18, "", "");
    ab.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this });
    if (!bool)
    {
      AppMethodBeat.o(39572);
      return;
    }
    long l = cb.abq();
    Object localObject1 = com.tencent.mm.plugin.sns.data.i.ls(l);
    ab.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", new Object[] { localObject1 });
    com.tencent.mm.plugin.report.service.h.qsU.e(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), localObject1, Long.valueOf(l) });
    Object localObject2 = new SightParams(2, 0);
    o.alD();
    Object localObject3 = com.tencent.mm.plugin.mmsight.d.TU(o.getAccVideoPath());
    localObject2 = RecordConfigProvider.a((String)localObject3, com.tencent.mm.plugin.mmsight.d.TW((String)localObject3), ((SightParams)localObject2).fcu, ((SightParams)localObject2).fcu.duration * 1000, 2);
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVS, false)) {
      ((RecordConfigProvider)localObject2).qbm = 2;
    }
    localObject3 = new VideoCaptureReportInfo();
    ((VideoCaptureReportInfo)localObject3).mhr = 1;
    ((RecordConfigProvider)localObject2).qbE = ((VideoCaptureReportInfo)localObject3);
    localObject3 = new SnsTimeLineUI.55(this);
    CaptureDataManager.qbh.qbg = ((CaptureDataManager.b)localObject3);
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVQ, true))
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.qbG;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 17, (RecordConfigProvider)localObject2);
      AppMethodBeat.o(39572);
      return;
    }
    localObject2 = new Intent();
    com.tencent.mm.pluginsdk.ui.tools.n.c(getContext(), (Intent)localObject2, (String)localObject1);
    AppMethodBeat.o(39572);
  }
  
  public final void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(39556);
    this.rYh.removeCallbacks(this.rXK);
    com.tencent.mm.vending.g.f.dQr().d(new SnsTimeLineUI.15(this, paramString1)).f(new SnsTimeLineUI.14(this, paramBoolean1, paramBoolean3, paramInt, paramString2, paramLong, paramBoolean2));
    AppMethodBeat.o(39556);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(39555);
    this.rYh.removeCallbacks(this.rXK);
    com.tencent.mm.vending.g.f.dQr().d(new SnsTimeLineUI.13(this, paramString1)).f(new SnsTimeLineUI.11(this, paramBoolean2, paramInt, paramString2, paramBoolean1));
    AppMethodBeat.o(39555);
  }
  
  public final void aam()
  {
    AppMethodBeat.i(39575);
    SF().az(c.b.class);
    AppMethodBeat.o(39575);
  }
  
  public final void aan() {}
  
  public final void aao()
  {
    AppMethodBeat.i(39576);
    if (this.rYu)
    {
      AppMethodBeat.o(39576);
      return;
    }
    ab.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
    this.rYu = true;
    ag.bEf().postDelayed(new SnsTimeLineUI.59(this), 1000L);
    AppMethodBeat.o(39576);
  }
  
  public final void aap()
  {
    AppMethodBeat.i(39579);
    SF().az(c.b.class);
    AppMethodBeat.o(39579);
  }
  
  public final boolean ctC()
  {
    AppMethodBeat.i(39574);
    if ((this.rXt == null) || (this.rXt.rFv == null))
    {
      AppMethodBeat.o(39574);
      return false;
    }
    if ((this.rXt == null) || (this.rXt.rFw == null)) {}
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.cnw();
      boolean bool = this.rXt.rFv.ctC();
      AppMethodBeat.o(39574);
      return bool;
      this.rXt.rFw.cpX();
    }
  }
  
  public final com.tencent.mm.plugin.sns.a.b.g cwf()
  {
    return this.rOU;
  }
  
  public final boolean dP(View paramView)
  {
    AppMethodBeat.i(39573);
    this.rXt.rFw.cpX();
    be localbe = this.rXt.rFv;
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      ab.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
      AppMethodBeat.o(39573);
      return false;
    }
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    Object localObject1 = localBaseViewHolder.crk;
    if (localbe.scN != null)
    {
      if ((localbe.scN.getTag() instanceof be.a))
      {
        localObject2 = (be.a)localbe.scN.getTag();
        if (((be.a)localObject2).rkN.equals(localObject1))
        {
          localbe.dS(((be.a)localObject2).qYp);
          AppMethodBeat.o(39573);
          return true;
        }
        localbe.ctC();
      }
      localbe.scN = null;
    }
    localbe.scN = new SnsCommentShowAbLayout(localbe.mContext);
    com.tencent.mm.sdk.platformtools.n.cn(localbe.scN);
    localbe.scN.setId(2131820735);
    new FrameLayout.LayoutParams(-1, -1);
    localbe.rkt.addView(localbe.scN);
    int i = BackwardSupportUtil.b.b(localbe.mContext, 192.0F);
    int j = BackwardSupportUtil.b.b(localbe.mContext, 76.0F);
    BackwardSupportUtil.b.b(localbe.mContext, 20.0F);
    int k = BackwardSupportUtil.b.b(localbe.mContext, 12.0F);
    int m = BackwardSupportUtil.b.b(localbe.mContext, 40.0F);
    Object localObject2 = w.hM(localbe.mContext).inflate(2130970814, null);
    new Rect();
    Object localObject3 = new int[2];
    com.tencent.mm.pluginsdk.f.fK(localbe.mContext);
    int n = com.tencent.mm.cb.a.fromDPToPix(localbe.mContext, 6);
    paramView.getLocationInWindow((int[])localObject3);
    localbe.qZo = af.hT(localbe.mContext);
    ab.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + n + " height_hardcode:" + j + " statusBarHeight: " + localbe.qZo);
    localObject3 = new AbsoluteLayout.LayoutParams(-2, -2, localObject3[0] - i + k, localObject3[1] - n - (m / 2 - paramView.getMeasuredHeight() / 2));
    localObject1 = new be.a(localbe, (String)localObject1, (View)localObject2);
    localbe.scN.setTag(localObject1);
    localbe.scN.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    if (localBaseViewHolder.kwo == 10) {
      ((View)localObject2).findViewById(2131821045).setBackgroundResource(2130838910);
    }
    ((View)localObject2).setVisibility(8);
    new ak().post(new be.1(localbe, paramView, (View)localObject2));
    AppMethodBeat.o(39573);
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(39559);
    ab.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[] { paramKeyEvent.toString() });
    int k = keyboardState();
    i locali = this.rXt;
    int i = j;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      i = j;
      if (locali.rFo.getVisibility() == 0)
      {
        locali.rFo.setVisibility(8);
        i = 1;
      }
    }
    if ((i != 0) && (k == 2))
    {
      AppMethodBeat.o(39559);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(39559);
    return bool;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(39578);
    ab.d("MicroMsg.SnsTimeLineUI", "finalize");
    super.finalize();
    AppMethodBeat.o(39578);
  }
  
  public int getLayoutId()
  {
    return 2130970889;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39568);
    this.mUIAction.rmc.setDrawingCacheEnabled(false);
    this.rXt.rkt = ((FrameLayout)findViewById(2131822827));
    int i = ag.cpm().position;
    Object localObject = (AdListView)this.mUIAction.getSnsListView();
    ((AdListView)localObject).rDL = this.rOU;
    ((AdListView)localObject).setTimelineStat(this.rXB);
    ((AdListView)localObject).setTimelineEvent(this.rXC);
    this.rXC.a(ag.coW());
    ab.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.rFt, new Object[] { Integer.valueOf(i) });
    this.rXq = ((QFadeImageView)findViewById(2131828164));
    this.rXq.setImageResource(2131231368);
    this.rXv = new SnsTimeLineUI.a(this, this.mUIAction.getSnsListView());
    this.rXv.setInterpolator(new LinearInterpolator());
    this.rXv.setAnimationListener(new SnsTimeLineUI.35(this));
    localObject = null;
    if (this.rYo == 1)
    {
      this.rXs = true;
      localObject = new com.tencent.mm.plugin.sns.ui.a.b.d(this.ikj, this.rHl);
    }
    this.rXn = new com.tencent.mm.plugin.sns.ui.a.c(this, this.mUIAction.getSnsListView(), this.rXt.rFy, this.rXt, this.rXD, (com.tencent.mm.plugin.sns.ui.a.b.b)localObject);
    this.rXt.rFy.sjY = new SnsTimeLineUI.36(this);
    this.rXt.rkX = this.rXn.sdr;
    this.rXn.sds.ANH = new SnsTimeLineUI.37(this);
    this.rXw = ((TestTimeForSns)this.rXt.rkt);
    this.rXw.setListener(new SnsTimeLineUI.38(this));
    this.mUIAction.list.setOnTouchListener(new SnsTimeLineUI.39(this));
    this.mUIAction.list.post(new SnsTimeLineUI.40(this));
    this.mUIAction.oCa.setOnSrcollDistance(new SnsTimeLineUI.41(this));
    this.rXt.rFo = ((SnsCommentFooter)findViewById(2131822831));
    this.rXt.rFo.post(new SnsTimeLineUI.42(this));
    this.rXt.rFp = new bf(this.mUIAction.list, this.rXt.rFo);
    this.rXo = ((LinearLayout)this.mUIAction.rmc.findViewById(2131828003));
    this.rXo.findViewById(2131828006).setOnClickListener(new SnsTimeLineUI.43(this));
    this.rXp = ((LinearLayout)this.mUIAction.rmc.findViewById(2131828005));
    this.rXt.rFq = new an(this);
    cwc();
    cwd();
    if (this.rYo == 0)
    {
      setMMTitle(2131304020);
      AppMethodBeat.o(39568);
      return;
    }
    if (this.rHl)
    {
      setMMTitle(2131303925);
      EX(8);
      AppMethodBeat.o(39568);
      return;
    }
    ab.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, userName:%s, title:%s", new Object[] { this.ikj, this.mUIAction.title });
    localObject = ag.coT().arw(this.ikj);
    if (localObject != null) {
      ab.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is not null");
    }
    for (localObject = ((com.tencent.mm.n.a)localObject).Of();; localObject = this.mUIAction.title)
    {
      setMMTitle(com.tencent.mm.plugin.sns.data.i.I((CharSequence)localObject));
      break;
      ab.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is null, title:%s", new Object[] { this.mUIAction.title });
    }
  }
  
  public final void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(39584);
    if (this.rXn != null)
    {
      ab.i("MicroMsg.SnsTimeLineUI", "set play animation %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.mm.plugin.sns.ui.a.c localc = this.rXn;
      localc.sdt = paramBoolean;
      if (!paramBoolean) {
        localc.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(39584);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39581);
    ab.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 15)
    {
      if ((this.rXt != null) && (this.rXt.rFy != null) && (this.rXt.rFy.sjr != null))
      {
        this.rXt.rFy.sjr.onActivityResult(paramInt1, paramInt2, paramIntent);
        al.p(new SnsTimeLineUI.61(this), 300L);
      }
      AppMethodBeat.o(39581);
      return;
    }
    if (paramInt1 == 16)
    {
      ab.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
      AppMethodBeat.o(39581);
      return;
    }
    if ((paramInt1 == 2333) && (paramIntent != null))
    {
      Object localObject = paramIntent.getStringExtra("Select_Contact");
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split(",");
        if (localObject.length > 0)
        {
          this.rXt.rFo.cmc.showVKB();
          String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nE(localObject[0]);
          if (!bo.isNullOrNil(str))
          {
            this.rXt.rFo.cvf();
            this.rXt.rFo.setText("@" + str + " ");
            this.rXt.rFo.setCommentAtPrefix("@" + str + " ");
            this.rXt.rFo.setCommentInfo(new cds());
            this.rXt.rFo.getCommentInfo().Username = localObject[0];
            this.rXt.rFo.setCommentFlag(8);
          }
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mUIAction.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 11)
    {
      this.rXm.d(this.ikj, this.rXE, this.rHl, this.rXF);
      AppMethodBeat.o(39581);
      return;
    }
    AppMethodBeat.o(39581);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39580);
    finish();
    AppMethodBeat.o(39580);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(39562);
    super.onConfigurationChanged(paramConfiguration);
    ab.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
    com.tencent.mm.sdk.b.a.ymk.l(new ca());
    com.tencent.mm.plugin.sns.ui.widget.e.cxN().smV = 0;
    com.tencent.mm.plugin.sns.ui.widget.c.cxK().smV = 0;
    com.tencent.mm.kiss.widget.textview.c.eLm.SJ();
    this.rXn.sdr.cvS();
    this.rXn.sds.resolvedClear();
    AppMethodBeat.o(39562);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39560);
    ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).GJ("__sns_timeline__");
    if (this.mController != null) {
      this.mController.aF(2, true);
    }
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    com.tencent.mm.pluginsdk.f.m(this);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      finish();
      AppMethodBeat.o(39560);
      return;
    }
    this.pyE = findViewById(2131820956);
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((this.pyE == null) || (!com.tencent.mm.ui.statusbar.c.ApJ))
    {
      getWindow().getDecorView().setSystemUiVisibility(1280);
      com.tencent.mm.ui.b.c(this, false);
      this.rXu = ((int)(getResources().getDisplayMetrics().heightPixels * 0.4D));
      setActionbarColor(getContext().getResources().getColor(2131690605));
      hideActionbarLine();
      this.rYo = getIntent().getIntExtra("sns_adapter_type", 0);
      this.rXs = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
      this.mActionBar = getSupportActionBar();
      i = com.tencent.mm.model.c.c.abV().eB("Sns_Private_Recent_Setting_Guide", 0);
      ab.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = ".concat(String.valueOf(i)));
      if (i == 1)
      {
        com.tencent.mm.kernel.g.RM();
        if (!com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yFe, false))
        {
          paramBundle = getIntent();
          paramBundle.setClass(getContext(), SnsSettingIntroduceUI.class);
          startActivity(paramBundle);
          overridePendingTransition(0, 0);
          finish();
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yFe, Boolean.TRUE);
        }
      }
      this.rXJ.rTu = new SnsTimeLineUI.25(this);
      cwb();
      com.tencent.mm.sdk.g.d.ysm.execute(new SnsTimeLineUI.26(this));
      this.rXl.a(c.b.class, this.rYl);
      localObject1 = this.rXm;
      i = this.rYo;
      paramBundle = getIntent();
      localObject3 = this.rXk;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).rYo = i;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = true;
      if (i != 0) {
        break label907;
      }
      localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdN;
      ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).rXk = ((com.tencent.mm.plugin.sns.k.b)localObject3);
      if (localObject3 == null) {
        break label902;
      }
      paramBundle = ((com.tencent.mm.plugin.sns.k.b)localObject3).cxQ();
      label423:
      ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).rXl = paramBundle;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdN.rXl.a(this);
      label441:
      paramBundle = this.rXm;
      if (paramBundle.rYo != 0) {
        break label1075;
      }
      paramBundle = (com.tencent.mm.plugin.sns.k.c.a)paramBundle.sdN.rXl.m(com.tencent.mm.plugin.sns.k.c.a.class);
      label470:
      this.ikj = paramBundle.ikj;
      this.rXD = paramBundle.rXD;
      this.rXE = paramBundle.rXE;
      this.rHl = paramBundle.rHl;
      this.rXF = paramBundle.rXF;
      localObject1 = paramBundle.gJX;
      paramBundle = paramBundle.mSignature;
      this.mSessionId = com.tencent.mm.ui.e.atl("123");
      this.rXG = String.valueOf(System.currentTimeMillis());
      this.mUIAction = new SnsUIAction(this);
      this.mUIAction.setSessionId(this.mSessionId);
      this.mUIAction.rnO = this.rXG;
      this.mUIAction.saS = this.rYj;
      this.mUIAction.actionbarView = this.mActionBar.getCustomView();
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().ii(2);
      com.tencent.mm.plugin.sns.ui.widget.e.cxN().smV = 0;
      com.tencent.mm.plugin.sns.ui.widget.c.cxK().smV = 0;
      localObject2 = com.tencent.mm.modelsns.c.fQN;
      com.tencent.mm.modelsns.c.akf();
      if (!getIntent().getBooleanExtra("is_sns_notify_open", true)) {
        break label1083;
      }
      i = 1;
      label658:
      this.rXt = new i(this, i, bo.bf(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0), this.rXG);
      this.rFt = getIntent().getBooleanExtra("sns_resume_state", true);
      if (!ag.coN()) {
        break label1088;
      }
      this.rFt = false;
      label728:
      this.rXr = this.rFt;
      this.mUIAction.a(this.rXD, this.ikj, (String)localObject1, paramBundle, this.rXE, this.rHl, this.rXF);
      this.mUIAction.onCreate();
      paramBundle = ag.coW();
      localObject1 = new ArrayList();
      localObject2 = com.tencent.mm.model.c.c.abU().aqN("10001").values().iterator();
    }
    label902:
    label907:
    label1075:
    label1083:
    label1088:
    label1278:
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label1280;
      }
      localObject3 = (com.tencent.mm.storage.c)((Iterator)localObject2).next();
      com.tencent.mm.plugin.sns.g.d locald = new com.tencent.mm.plugin.sns.g.d();
      if (localObject3 == null)
      {
        ab.i("MicroMsg.SnsABTestStrategy", "abtest is null");
        continue;
        paramBundle = com.tencent.mm.ui.statusbar.c.aH(this);
        localObject1 = new SnsTimeLineUI.16(this);
        this.pyG = ((com.tencent.mm.ui.statusbar.c.a)localObject1);
        paramBundle.a((com.tencent.mm.ui.statusbar.c.a)localObject1);
        getWindow().getDecorView().requestApplyInsets();
        com.tencent.mm.ui.statusbar.d.a(getWindow());
        break;
        paramBundle = null;
        break label423;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdO = new com.tencent.mm.plugin.sns.k.c.a();
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdO.ikj = paramBundle.getStringExtra("sns_userName");
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdO.rXD = com.tencent.mm.model.r.Zn();
        localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdO;
        com.tencent.mm.kernel.g.RM();
        ((com.tencent.mm.plugin.sns.k.c.a)localObject2).rXE = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arr(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdO.ikj);
        localObject2 = com.tencent.mm.model.r.Zn();
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdO.rHl = ((String)localObject2).equals(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdO.ikj);
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdO.rXF = paramBundle.getIntExtra("sns_source", 0);
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdO.gJX = bo.bf(paramBundle.getStringExtra("sns_nickName"), "");
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdO.mSignature = bo.bf(paramBundle.getStringExtra("sns_signature"), "");
        break label441;
        paramBundle = paramBundle.sdO;
        break label470;
        i = 0;
        break label658;
        if (!this.rFt) {
          break label728;
        }
        this.rFt = ag.cpm().cur();
        break label728;
      }
      if (!((com.tencent.mm.storage.c)localObject3).isValid())
      {
        ab.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
      }
      else
      {
        Map localMap = ((com.tencent.mm.storage.c)localObject3).dvN();
        if (localMap != null)
        {
          ab.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + ((com.tencent.mm.storage.c)localObject3).field_expId + " " + ((com.tencent.mm.storage.c)localObject3).field_layerId + " " + ((com.tencent.mm.storage.c)localObject3).field_startTime + " " + ((com.tencent.mm.storage.c)localObject3).field_endTime);
          locald.h(((com.tencent.mm.storage.c)localObject3).field_layerId, ((com.tencent.mm.storage.c)localObject3).field_expId, localMap);
          if ((locald.cqS) && (locald.rlv != null) && (locald.rlv.size() > 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1278;
            }
            ((List)localObject1).add(locald);
            break;
          }
        }
      }
    }
    label1280:
    paramBundle.rkV = ((List)localObject1);
    paramBundle.rkY.clear();
    paramBundle.rkZ.clear();
    paramBundle.rlb.clear();
    paramBundle.rfe = null;
    if ((paramBundle.rkV == null) || (paramBundle.rkV.size() == 0))
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(213, this);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(682, this);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(218, this);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(211, this);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(683, this);
      com.tencent.mm.plugin.sns.ui.video.c.cxv().cxw();
      initView();
      paramBundle = ag.coW();
      localObject1 = this.mUIAction.list;
      localObject2 = this.rXn.sdr;
      paramBundle.rkW = ((ListView)localObject1);
      paramBundle.rkX = ((av)localObject2);
      paramBundle = ag.coW();
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(291, paramBundle);
      this.rXt.mAZ = ((ClipboardManager)ah.getContext().getSystemService("clipboard"));
      if (!ag.coN()) {
        break label2748;
      }
      this.rFt = false;
      label1513:
      paramBundle = this.rXl;
      paramBundle.sds = this.rXn.sds;
      localObject1 = paramBundle.sds;
      paramBundle.ANF.keep((com.tencent.mm.vending.e.a)localObject1);
      if ((!this.rFt) || (this.rYo != 0)) {
        break label2768;
      }
      this.rXs = false;
      int j = ag.cpm().position;
      this.rXn.sds.acm(ag.cpm().meP);
      this.rXn.sds.acl(ag.cpm().rKW);
      this.rXn.sds.cwP();
      this.rXn.ph();
      i = j;
      if (j >= this.rXn.getCount())
      {
        i = this.rXn.getCount() - 1;
        ab.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[] { Integer.valueOf(this.rXn.getCount()) });
      }
      this.mUIAction.list.setAdapter(this.rXn);
      ab.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[] { Integer.valueOf(ag.cpm().rKX) });
      this.mUIAction.list.setSelectionFromTop(i, ag.cpm().rKX);
      EX(4);
      label1729:
      cwa();
      i = this.rXn.getCount();
      j = this.mUIAction.list.getFirstVisiblePosition();
      if (j < i) {
        this.rXz = com.tencent.mm.plugin.sns.data.i.j(this.rXn.EE(j));
      }
      com.tencent.mm.kernel.g.RM();
      this.rXx = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(327776, Integer.valueOf(0))).intValue();
      this.rXt.rFv = new be(this, this.rXn.sdr, this.rXt.rkt);
      this.rXt.rFx = new com.tencent.mm.plugin.sns.g.b(this, this.rXn.sdr.rks, this.rXt.rkt);
      this.rXt.rFw = new b(this, this.rXn.sdr.rks, this.rXt.rkt, this.rXt.rFx);
      if (this.rXC != null) {
        this.rXC.a(this.rXt.rFx);
      }
      if (i > 0)
      {
        paramBundle = this.rXn.EE(0);
        if ((this.rXt.rFl != null) && (this.rXt.rFl.rhS != null)) {
          this.rXt.rFl.rhS.rmy = paramBundle.field_snsId;
        }
        paramBundle = com.tencent.mm.plugin.sns.i.e.roN;
        if (paramBundle.eDB != 0)
        {
          if (paramBundle.roO.isEmpty())
          {
            paramBundle.dZQ.setLong(2, bo.aox());
            paramBundle.roP.clear();
          }
          ab.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[] { Integer.valueOf(paramBundle.roO.size()) });
        }
      }
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(13312, "1," + bo.aoy());
      com.tencent.mm.sdk.b.a.ymk.c(this.rXL);
      if (getIntent().getBooleanExtra("is_need_resend_sns", false))
      {
        al.p(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(155737);
            com.tencent.mm.ui.base.h.d(SnsTimeLineUI.this, SnsTimeLineUI.this.getString(2131301942), "", SnsTimeLineUI.this.getString(2131301943), SnsTimeLineUI.this.getString(2131296888), new SnsTimeLineUI.27.1(this), new SnsTimeLineUI.27.2(this));
            AppMethodBeat.o(155737);
          }
        }, 500L);
        getIntent().putExtra("is_need_resend_sns", false);
      }
      com.tencent.mm.kernel.g.RM();
      if (com.tencent.mm.kernel.g.RJ().QU())
      {
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(589825, Boolean.FALSE);
      }
      this.rXt.rFk = this.rOU;
      this.rOU.a(this.mUIAction.qYs, this.mActionBar.getCustomView(), this);
      com.tencent.mm.sdk.b.a.ymk.c(this.rXQ);
      com.tencent.mm.sdk.b.a.ymk.c(this.rXR);
      com.tencent.mm.sdk.b.a.ymk.c(this.rXS);
      com.tencent.mm.sdk.b.a.ymk.c(this.rXT);
      com.tencent.mm.sdk.b.a.ymk.c(this.rXU);
      com.tencent.mm.sdk.b.a.ymk.c(this.rXW);
      com.tencent.mm.sdk.b.a.ymk.c(this.rXV);
      com.tencent.mm.sdk.b.a.ymk.c(this.rir);
      com.tencent.mm.sdk.b.a.ymk.c(this.rXX);
      com.tencent.mm.sdk.b.a.ymk.c(this.rXY);
      com.tencent.mm.sdk.b.a.ymk.c(this.rYa);
      com.tencent.mm.sdk.b.a.ymk.c(this.rXZ);
      com.tencent.mm.sdk.b.a.ymk.c(this.rYb);
      com.tencent.mm.plugin.sns.abtest.c.cnB();
      com.tencent.mm.plugin.sns.abtest.a.d(this, this.rXt.rkt);
      if (this.rXA != null)
      {
        paramBundle = this.rXA;
        localObject1 = this.mUIAction.list;
        localObject2 = this.mUIAction.rmc;
        paramBundle.gMh = ((ListView)localObject1);
        paramBundle.rmc = ((SnsHeader)localObject2);
      }
      if ((this.rXt != null) && (this.rXt.rFl != null))
      {
        paramBundle = this.rXt.rFl.rhS;
        ab.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
        paramBundle.rmx = true;
        paramBundle.rov = System.currentTimeMillis();
      }
      boolean bool = getIntent().getBooleanExtra("enter_by_red", false);
      if ((this.rXt != null) && (this.rXt.rFl != null))
      {
        paramBundle = this.rXt.rFl.rhS;
        if (!bool) {
          break label2797;
        }
      }
    }
    label2713:
    label2748:
    label2768:
    label2797:
    for (int i = 1;; i = 0)
    {
      for (;;)
      {
        paramBundle.rmK = i;
        ag.cpc().rdw.clear();
        if ((this.mUIAction != null) && (this.mUIAction.rmc != null)) {
          this.mUIAction.rmc.setStoryAction(new SnsStoryHeaderView.a()
          {
            public final void cwm()
            {
              AppMethodBeat.i(155738);
              SnsTimeLineUI.a locala = SnsTimeLineUI.j(SnsTimeLineUI.this);
              if (SnsTimeLineUI.t(locala.rYv).getVisibility() == 0)
              {
                locala.init();
                SnsTimeLineUI.t(locala.rYv).clearAnimation();
                SnsTimeLineUI.t(locala.rYv).startAnimation(locala);
                locala.mg(locala.DELAY_TIME + 100);
                locala.rYZ = false;
              }
              AppMethodBeat.o(155738);
            }
          });
        }
        com.tencent.mm.sdk.b.a.ymk.c(this.rXM);
        disableMultiTouch();
        AppMethodBeat.o(39560);
        return;
        long l = System.currentTimeMillis();
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.RM();
        localObject1 = com.tencent.mm.kernel.g.RL().cachePath + "ws_1100004";
        ab.i("MicroMsg.SnSABTestMgr", "filepath to list  ".concat(String.valueOf(localObject1)));
        localObject2 = com.tencent.mm.vfs.e.i((String)localObject1, 0, -1);
        if (localObject2 == null) {
          break;
        }
        try
        {
          paramBundle.rfe = ((com.tencent.mm.plugin.sns.h.c)new com.tencent.mm.plugin.sns.h.c().parseFrom((byte[])localObject2));
          ab.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - l));
          if (paramBundle.rfe != null) {
            break label2713;
          }
          ab.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
        }
        catch (IOException paramBundle)
        {
          ab.printErrStackTrace("MicroMsg.SnSABTestMgr", paramBundle, "", new Object[0]);
          com.tencent.mm.vfs.e.deleteFile((String)localObject1);
        }
      }
      break;
      ab.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + paramBundle.rfe.rlL.size());
      break;
      if (!this.rFt) {
        break label1513;
      }
      this.rFt = ag.cpm().cur();
      break label1513;
      this.mUIAction.list.setAdapter(this.rXn);
      EX(0);
      this.rXn.ph();
      break label1729;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39563);
    this.rXy = true;
    Object localObject1 = this.rXJ;
    ((ar)localObject1).bzQ();
    ((ar)localObject1).rTu = null;
    ((ar)localObject1).qCf = ar.a.rTw;
    com.tencent.mm.plugin.sns.ui.video.c.cxv().aEM();
    ab.i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
    com.tencent.mm.sdk.b.a.ymk.d(this.rXQ);
    com.tencent.mm.sdk.b.a.ymk.d(this.rXR);
    com.tencent.mm.sdk.b.a.ymk.d(this.rXS);
    com.tencent.mm.sdk.b.a.ymk.d(this.rXT);
    com.tencent.mm.sdk.b.a.ymk.d(this.rXU);
    com.tencent.mm.sdk.b.a.ymk.d(this.rXW);
    com.tencent.mm.sdk.b.a.ymk.d(this.rXV);
    com.tencent.mm.sdk.b.a.ymk.d(this.rir);
    com.tencent.mm.sdk.b.a.ymk.d(this.rXX);
    com.tencent.mm.sdk.b.a.ymk.d(this.rXY);
    com.tencent.mm.sdk.b.a.ymk.d(this.rXZ);
    com.tencent.mm.sdk.b.a.ymk.d(this.rYa);
    com.tencent.mm.sdk.b.a.ymk.d(this.rYb);
    com.tencent.mm.sdk.b.a.ymk.d(this.rXM);
    com.tencent.mm.plugin.sns.ui.e.a.cxo();
    long l;
    Object localObject4;
    label388:
    String str;
    if ((this.rXt != null) && (this.rXt.rFl != null))
    {
      localObject1 = this.rXt.rFl.rhS;
      if (this.rXN)
      {
        i = 1;
        ((com.tencent.mm.plugin.sns.i.b)localObject1).rmL = i;
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.sns.i.e.roN;
      if (((com.tencent.mm.plugin.sns.i.e)localObject2).eDB == 0) {
        break label706;
      }
      ab.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sns.i.e)localObject2).roO.size()), Integer.valueOf(((com.tencent.mm.plugin.sns.i.e)localObject2).roP.size()) });
      l = ((com.tencent.mm.plugin.sns.i.e)localObject2).dZQ.getLong(2, 0L);
      if ((((com.tencent.mm.plugin.sns.i.e)localObject2).roO.isEmpty()) || ((((com.tencent.mm.plugin.sns.i.e)localObject2).roO.size() <= ((com.tencent.mm.plugin.sns.i.e)localObject2).roT) && (bo.gz(l) <= ((com.tencent.mm.plugin.sns.i.e)localObject2).roU))) {
        break label1485;
      }
      localObject3 = new StringBuffer();
      localObject4 = ((com.tencent.mm.plugin.sns.i.e)localObject2).roO.keySet().iterator();
      i = 0;
      j = 0;
      if (!((Iterator)localObject4).hasNext()) {
        break label542;
      }
      str = (String)((Iterator)localObject4).next();
      localObject1 = (String)((com.tencent.mm.plugin.sns.i.e)localObject2).roP.get(str);
      if (bo.isNullOrNil((String)localObject1)) {
        break label529;
      }
      j = 1;
      label435:
      if (!((com.tencent.mm.plugin.sns.i.e)localObject2).roQ.contains(str)) {
        break label537;
      }
    }
    label529:
    label537:
    for (int k = 1;; k = 0)
    {
      ((StringBuffer)localObject3).append(str + "#" + ((com.tencent.mm.plugin.sns.i.e)localObject2).roO.get(str) + "#" + (String)localObject1 + "#" + k + "|");
      i += 1;
      break label388;
      i = 0;
      break;
      localObject1 = "";
      break label435;
    }
    label542:
    ((StringBuffer)localObject3).append("," + l + "," + bo.aox() + ",1," + j + "," + i + ",1");
    ab.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", new Object[] { Integer.valueOf(13226), localObject3 });
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(13226, ((StringBuffer)localObject3).toString());
    ((com.tencent.mm.plugin.sns.i.e)localObject2).dZQ.set(3, null);
    ((com.tencent.mm.plugin.sns.i.e)localObject2).dZQ.set(4, null);
    ((com.tencent.mm.plugin.sns.i.e)localObject2).roO.clear();
    ((com.tencent.mm.plugin.sns.i.e)localObject2).roP.clear();
    ((com.tencent.mm.plugin.sns.i.e)localObject2).roQ.clear();
    ((com.tencent.mm.plugin.sns.i.e)localObject2).dZQ.setLong(2, bo.aox());
    ((com.tencent.mm.plugin.sns.i.e)localObject2).cqg();
    label706:
    com.tencent.mm.kernel.g.RM();
    Object localObject3 = (String)com.tencent.mm.kernel.g.RL().Ru().get(68377, null);
    int i = this.rXn.getCount();
    localObject1 = "";
    Object localObject2 = null;
    if (i > 0)
    {
      localObject2 = this.rXn.EE(i - 1);
      localObject1 = com.tencent.mm.plugin.sns.data.i.j((com.tencent.mm.plugin.sns.storage.n)localObject2);
    }
    if ((this.rXt != null) && (this.rXt.rFl != null))
    {
      localObject4 = this.rXt.rFl.rhS;
      if (localObject2 == null)
      {
        i = -1;
        label803:
        ab.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
        l = System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.i.b)localObject4).rov;
        ((com.tencent.mm.plugin.sns.i.b)localObject4).rmz += l;
        ab.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + l + " BrowseTime: " + ((com.tencent.mm.plugin.sns.i.b)localObject4).rmz + "BackgroundTime: " + ((com.tencent.mm.plugin.sns.i.b)localObject4).rni);
        localObject2 = ag.coS();
        if (localObject2 != null) {
          ((com.tencent.mm.sdk.g.b.a)localObject2).execute(new b.2((com.tencent.mm.plugin.sns.i.b)localObject4, i));
        }
        ((com.tencent.mm.plugin.sns.i.b)localObject4).rmx = false;
      }
    }
    else
    {
      localObject2 = com.tencent.mm.modelsns.b.lV(704);
      if (((com.tencent.mm.modelsns.b)localObject2).aka())
      {
        ((com.tencent.mm.modelsns.b)localObject2).de(this.rXN);
        if (bo.isNullOrNil((String)localObject3)) {
          break label1539;
        }
      }
    }
    int m;
    label1539:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.modelsns.b)localObject2).de(bool);
      ((com.tencent.mm.modelsns.b)localObject2).uv(this.rXz);
      ((com.tencent.mm.modelsns.b)localObject2).uv((String)localObject1);
      ((com.tencent.mm.modelsns.b)localObject2).uv((String)localObject1);
      ((com.tencent.mm.modelsns.b)localObject2).lY(this.mUIAction.saR);
      ((com.tencent.mm.modelsns.b)localObject2).uv("");
      com.tencent.mm.modelsns.b.akd();
      ((com.tencent.mm.modelsns.b)localObject2).ake();
      localObject1 = (AdListView)this.mUIAction.getSnsListView();
      this.rXC.riK.clear();
      ag.coW().clean();
      localObject2 = ag.coZ();
      ag.coS().execute(new i.5((com.tencent.mm.plugin.sns.a.b.i)localObject2));
      ((AdListView)localObject1).rDL.clear();
      ((AdListView)localObject1).rDL = null;
      ((AdListView)localObject1).rDM.cov();
      ((AdListView)localObject1).rDM = null;
      u.coA();
      if (!ag.coN()) {
        this.rYh.removeCallbacks(this.rXK);
      }
      com.tencent.mm.kernel.g.RM();
      if (com.tencent.mm.kernel.g.RJ().QU())
      {
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.b(213, this);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.b(682, this);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.b(218, this);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.b(211, this);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.b(683, this);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(327776, Integer.valueOf(this.rXx));
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(589825, Boolean.FALSE);
      }
      if (this.rXt != null)
      {
        localObject1 = this.rXt;
        ((i)localObject1).rFy.removeListener();
        if (((i)localObject1).rFo != null) {
          ((i)localObject1).rFo.bOo();
        }
        com.tencent.mm.sdk.b.a.ymk.d(((i)localObject1).rFA);
        com.tencent.mm.sdk.b.a.ymk.d(((i)localObject1).rFB);
      }
      ag.bEf().removeCallbacks(this.rYi);
      if (this.rXn == null) {
        break label1842;
      }
      m = this.mUIAction.list.getFirstVisiblePosition();
      i = 0;
      j = 0;
      while (j < this.mUIAction.list.getCount())
      {
        localObject1 = this.mUIAction.list.getChildAt(j);
        k = i;
        if (localObject1 != null)
        {
          int n = this.mUIAction.list.getPositionForView((View)localObject1);
          k = i;
          if (n == m)
          {
            localObject2 = new int[2];
            ((View)localObject1).getLocationInWindow((int[])localObject2);
            ab.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", new Object[] { Integer.valueOf(n), Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
            k = localObject2[1];
          }
        }
        j += 1;
        i = k;
      }
      label1485:
      ((com.tencent.mm.plugin.sns.i.e)localObject2).dZQ.set(3, ((com.tencent.mm.plugin.sns.i.e)localObject2).roO);
      ((com.tencent.mm.plugin.sns.i.e)localObject2).dZQ.set(4, ((com.tencent.mm.plugin.sns.i.e)localObject2).roP);
      ((com.tencent.mm.plugin.sns.i.e)localObject2).dZQ.set(5, ((com.tencent.mm.plugin.sns.i.e)localObject2).roQ);
      break;
      i = ((com.tencent.mm.plugin.sns.storage.n)localObject2).field_createTime;
      break label803;
    }
    int j = getResources().getDimensionPixelSize(2131428714);
    if ((!ag.coN()) && (this.rXl.coV() != null) && (this.rYo == 0))
    {
      localObject1 = ag.cpm();
      localObject2 = this.rXn.sds.cwN();
      localObject3 = this.rXn.sds.cwO();
      l = this.rXl.coV().rig;
      ((ai)localObject1).rKV = bo.yB();
      ((ai)localObject1).meP = ((String)localObject2);
      ((ai)localObject1).rKW = ((String)localObject3);
      ((ai)localObject1).rig = l;
      ((ai)localObject1).position = m;
      ((ai)localObject1).rKX = (i - j);
      ab.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", new Object[] { Long.valueOf(((ai)localObject1).rKV), localObject2, localObject3, Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(((ai)localObject1).rKX) });
    }
    ab.d("MicroMsg.SnsTimeLineUI", "top h %d", new Object[] { Integer.valueOf(i - j) });
    localObject1 = this.rXn.sdr;
    com.tencent.mm.sdk.b.a.ymk.d(((av)localObject1).hCe);
    if (ag.coN()) {
      ab.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
    }
    for (;;)
    {
      localObject1 = this.rXn.sdr;
      if (((av)localObject1).rOK != null) {
        ((av)localObject1).rOK.activity = null;
      }
      localObject1 = this.rXn.sdr;
      com.tencent.mm.sdk.b.a.ymk.d(((av)localObject1).hCe);
      this.rXn.sdr.cvV();
      label1842:
      ax.clean();
      com.tencent.mm.sdk.b.a.ymk.d(this.rXL);
      com.tencent.mm.kernel.g.RM();
      if (com.tencent.mm.kernel.g.RJ().QU()) {
        ag.cpc().rdw.clear();
      }
      localObject1 = this.rXn;
      ((com.tencent.mm.plugin.sns.ui.a.c)localObject1).sds.removeVendingDataChangedCallback(((com.tencent.mm.plugin.sns.ui.a.c)localObject1).sdu);
      ((com.tencent.mm.plugin.sns.ui.a.c)localObject1).sdu = null;
      this.rXn = null;
      this.rXt = null;
      com.tencent.mm.plugin.sns.ui.a.c.cwL();
      com.tencent.mm.plugin.sns.abtest.c.cnC();
      localObject1 = ag.coW();
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(291, (com.tencent.mm.ai.f)localObject1);
      com.tencent.mm.plugin.sns.abtest.a.clean();
      this.mUIAction.onDestroy();
      super.onDestroy();
      com.tencent.mm.kiss.widget.textview.c.eLm.SJ();
      localObject1 = this.rXm;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).sdO = null;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = false;
      com.tencent.mm.plugin.sns.a.b.j.rac.rab.clear();
      ab.i("MicroMsg.SnsTimelineAdResourceMgr", "clean cache", new Object[] { bo.dtY() });
      localObject1 = ag.cpa();
      if (!((com.tencent.mm.plugin.sns.model.b)localObject1).rdh.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.b)localObject1).rdh.clear();
      }
      localObject1 = ag.cpa();
      if (!((com.tencent.mm.plugin.sns.model.b)localObject1).rdi.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.b)localObject1).rdi.clear();
      }
      try
      {
        localObject1 = getResources().getDrawable(2130838913);
        localObject2 = com.tencent.mm.cc.b.f(getResources(), 2130838913);
        if (((localObject1 instanceof StateListDrawable)) && ((localObject2 instanceof StateListDrawable)))
        {
          ab.i("MicroMsg.SnsTimeLineUI", "[%d,%d]  [%d,%d]", new Object[] { Integer.valueOf(((Drawable)localObject1).getMinimumWidth()), Integer.valueOf(((Drawable)localObject1).getMinimumHeight()), Integer.valueOf(((Drawable)localObject2).getMinimumWidth()), Integer.valueOf(((Drawable)localObject2).getMinimumHeight()) });
          if ((((Drawable)localObject1).getMinimumWidth() != ((Drawable)localObject2).getMinimumWidth()) || (((Drawable)localObject1).getMinimumHeight() != ((Drawable)localObject2).getMinimumHeight()))
          {
            com.tencent.mm.plugin.report.service.h.qsU.cT(931, 13);
            AppMethodBeat.o(39563);
            return;
            ag.cpc();
          }
        }
        else
        {
          ab.e("MicroMsg.SnsTimeLineUI", "check resource icon error! not StateListDrawable");
          com.tencent.mm.plugin.report.service.h.qsU.cT(931, 13);
        }
        AppMethodBeat.o(39563);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.SnsTimeLineUI", localException.getMessage());
        AppMethodBeat.o(39563);
      }
    }
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(39583);
    super.onDrag();
    AppMethodBeat.o(39583);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(39569);
    super.onKeyboardStateChanged();
    al.d(new SnsTimeLineUI.44(this));
    if (keyboardState() == 2)
    {
      if ((this.rXt != null) && (this.rXt.rFo != null) && (!this.rXt.rFo.cvd()))
      {
        ab.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
        AppMethodBeat.o(39569);
      }
    }
    else if ((keyboardState() == 1) && (this.rXt != null))
    {
      i locali = this.rXt;
      if (locali.rFm)
      {
        locali.rFm = false;
        locali.rFp.cwJ();
      }
    }
    AppMethodBeat.o(39569);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39567);
    this.rXq.clearAnimation();
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, this.eez);
    this.eez = 0;
    u.b(this);
    ag.cpc().rdy = null;
    Object localObject = new ua();
    ((ua)localObject).cKz.type = 1;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    if (this.rXn != null)
    {
      localObject = this.rXn.sdr;
      com.tencent.mm.sdk.b.a.ymk.d(((av)localObject).rPg);
      com.tencent.mm.sdk.b.a.ymk.d(((av)localObject).rPf);
      com.tencent.mm.sdk.b.a.ymk.d(((av)localObject).rPh);
    }
    if ((this.rXt != null) && (this.rXt.rFk != null)) {
      this.rXt.rFk.onPause();
    }
    if ((this.rXt != null) && (this.rXt.rFl != null)) {
      this.rXt.rFl.rhS.lc(false);
    }
    com.tencent.mm.modelstat.d.o("SnsTimeLineUI", this.otr, bo.aox());
    this.mUIAction.onPause();
    super.onPause();
    localObject = com.tencent.mm.plugin.sns.ui.video.c.cxv();
    ab.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay onUIPause");
    if (((com.tencent.mm.plugin.sns.ui.video.c)localObject).smk != null)
    {
      boolean bool = com.tencent.mm.plugin.sns.ui.video.c.A(((com.tencent.mm.plugin.sns.ui.video.c)localObject).smk);
      ((com.tencent.mm.plugin.sns.ui.video.c)localObject).smk.cxr();
      if (bool) {
        ((com.tencent.mm.plugin.sns.ui.video.c)localObject).smk.cxq();
      }
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.rXP);
    com.tencent.mm.sdk.b.a.ymk.d(this.rXO);
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class) != null))
    {
      localObject = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class)).bQQ;
      if (localObject != null) {
        ((com.tencent.matrix.trace.f.c)localObject).b(this.mCa);
      }
    }
    if (bo.aox() > this.fAA) {}
    for (long l = bo.aox() - this.fAA;; l = 1L)
    {
      this.fAA = l;
      WXHardCoderJNI.reportFPS(701, WXHardCoderJNI.hcSNSScrollAction, 1, this.eCX, this.fAA);
      this.eCX = 0L;
      this.fAA = 0L;
      AppMethodBeat.o(39567);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(39582);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(39582);
      return;
    }
    ab.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    label218:
    for (;;)
    {
      AppMethodBeat.o(39582);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cwe();
        AppMethodBeat.o(39582);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131302067;; paramInt = 2131302075)
      {
        if (paramArrayOfInt[0] == 0) {
          break label218;
        }
        com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131302083), getString(2131300996), getString(2131296888), false, new SnsTimeLineUI.62(this), new SnsTimeLineUI.63(this));
        break;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39564);
    this.rXJ.qCf = ar.cvE();
    this.fAA = bo.aox();
    Object localObject1;
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class) != null))
    {
      localObject1 = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class)).bQQ;
      if (localObject1 != null) {
        ((com.tencent.matrix.trace.f.c)localObject1).a(this.mCa);
      }
    }
    if ((com.tencent.mm.sdk.a.b.dsf()) && (com.tencent.mm.sdk.a.b.dsd())) {
      sUILeaksRoutineEnsuranceRef.add(this);
    }
    this.mUIAction.onResume();
    super.onResume();
    cwb();
    if (this.oXs)
    {
      localObject1 = com.tencent.mm.plugin.sns.ui.video.c.cxv();
      if (((com.tencent.mm.plugin.sns.ui.video.c)localObject1).smk != null)
      {
        ((com.tencent.mm.plugin.sns.ui.video.c)localObject1).smk.ctQ();
        ((com.tencent.mm.plugin.sns.ui.video.c)localObject1).smk.setMute(true);
        ((com.tencent.mm.plugin.sns.ui.video.c)localObject1).smk.ctY();
      }
    }
    this.otr = bo.aox();
    int i;
    Object localObject2;
    com.tencent.mm.plugin.sns.storage.n localn;
    if (this.rYm)
    {
      this.rYm = false;
      i = this.rXn.getCount();
      if (getIntent().getBooleanExtra("is_from_find_more", false))
      {
        localObject2 = com.tencent.mm.modelsns.b.c(getIntent(), "enter_log");
        if (localObject2 != null)
        {
          if (i <= 0) {
            break label775;
          }
          localn = this.rXn.EE(0);
          if (localn != null) {
            break label741;
          }
          localObject1 = "0";
          ((com.tencent.mm.modelsns.b)localObject2).uv((String)localObject1);
          if (localn != null) {
            break label753;
          }
          localObject1 = "0";
          label243:
          ((com.tencent.mm.modelsns.b)localObject2).uv((String)localObject1);
          ((com.tencent.mm.modelsns.b)localObject2).uv(String.valueOf(i));
          label260:
          ((com.tencent.mm.modelsns.b)localObject2).ake();
        }
      }
    }
    if (this.mScreenWidth == 0)
    {
      localObject1 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
      this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
      localObject1 = this.rXA;
      i = this.mScreenWidth;
      int j = this.mScreenHeight;
      ((com.tencent.mm.plugin.sns.i.a)localObject1).mScreenWidth = i;
      ((com.tencent.mm.plugin.sns.i.a)localObject1).mScreenHeight = j;
    }
    if (ag.coN()) {
      finish();
    }
    ag.cpc().rdy = this.rXn.sdr;
    SF().az(c.b.class);
    u.a(this);
    if (this.rXs) {
      this.rXq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(155742);
          ab.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.K(SnsTimeLineUI.this));
          if (SnsTimeLineUI.K(SnsTimeLineUI.this))
          {
            SnsTimeLineUI.k(SnsTimeLineUI.this);
            SnsTimeLineUI.j(SnsTimeLineUI.this).cwq();
          }
          AppMethodBeat.o(155742);
        }
      });
    }
    for (;;)
    {
      localObject1 = new ua();
      ((ua)localObject1).cKz.cKA = this.mUIAction.list.getFirstVisiblePosition();
      ((ua)localObject1).cKz.cKB = this.mUIAction.list.getLastVisiblePosition();
      ((ua)localObject1).cKz.cKC = this.mUIAction.list.getHeaderViewsCount();
      ((ua)localObject1).cKz.type = 0;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      if ((this.rXt != null) && (this.rXt.rFk != null)) {
        this.rXt.rFk.onResume();
      }
      if (this.rXn != null)
      {
        localObject1 = this.rXn.sdr;
        com.tencent.mm.sdk.b.a.ymk.c(((av)localObject1).rPg);
        com.tencent.mm.sdk.b.a.ymk.c(((av)localObject1).rPf);
        com.tencent.mm.sdk.b.a.ymk.c(((av)localObject1).rPh);
      }
      if ((this.rXt != null) && (this.rXt.rFl != null))
      {
        this.rXt.rFl.rhS.lc(true);
        this.rXt.rFl.rhS.ld(false);
        this.rXt.rFl.rhS.le(false);
        this.rXt.rFl.rhS.lf(false);
        this.rXt.rFl.rhS.lp(false);
        localObject1 = this.rXt.rFl.rhS;
        ((com.tencent.mm.plugin.sns.i.b)localObject1).ln(false);
        ((com.tencent.mm.plugin.sns.i.b)localObject1).lo(false);
        ((com.tencent.mm.plugin.sns.i.b)localObject1).lh(false);
        ((com.tencent.mm.plugin.sns.i.b)localObject1).lm(false);
        ((com.tencent.mm.plugin.sns.i.b)localObject1).lk(false);
        ((com.tencent.mm.plugin.sns.i.b)localObject1).lm(false);
        ((com.tencent.mm.plugin.sns.i.b)localObject1).lq(false);
        ((com.tencent.mm.plugin.sns.i.b)localObject1).ll(false);
        ((com.tencent.mm.plugin.sns.i.b)localObject1).lm(false);
        ((com.tencent.mm.plugin.sns.i.b)localObject1).li(false);
        ((com.tencent.mm.plugin.sns.i.b)localObject1).lj(false);
      }
      localObject1 = ag.cpc();
      ((com.tencent.mm.plugin.sns.model.g)localObject1).rdz = 0L;
      ((com.tencent.mm.plugin.sns.model.g)localObject1).rdA = 0L;
      com.tencent.mm.sdk.b.a.ymk.c(this.rXP);
      com.tencent.mm.sdk.b.a.ymk.c(this.rXO);
      AppMethodBeat.o(39564);
      return;
      label741:
      localObject1 = com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId);
      break;
      label753:
      localObject1 = localn.field_createTime;
      break label243;
      label775:
      ((com.tencent.mm.modelsns.b)localObject2).uv("");
      ((com.tencent.mm.modelsns.b)localObject2).uv("");
      ((com.tencent.mm.modelsns.b)localObject2).uv("0");
      break label260;
      localObject1 = this.rXv;
      if (((SnsTimeLineUI.a)localObject1).rYv.rXq.getVisibility() == 0)
      {
        ((SnsTimeLineUI.a)localObject1).init();
        localObject2 = (AbsoluteLayout.LayoutParams)((SnsTimeLineUI.a)localObject1).rYv.rXq.getLayoutParams();
        ((AbsoluteLayout.LayoutParams)localObject2).y = ((int)((SnsTimeLineUI.a)localObject1).rYS);
        ((SnsTimeLineUI.a)localObject1).rYv.rXq.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((SnsTimeLineUI.a)localObject1).rYv.rXq.invalidate();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(39577);
    ab.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType());
    if (paramm.getType() == 218)
    {
      paramString = (com.tencent.mm.plugin.sns.model.r)paramm;
      if (((paramString.type == 1) || (paramString.type == 6) || (paramString.type == 4)) && (this.rXt.rFz != null)) {
        this.rXt.rFz.dismiss();
      }
      if (paramString.type == 11)
      {
        if (this.mUIAction.tipDialog != null) {
          this.mUIAction.tipDialog.dismiss();
        }
        if (this.rYq != null) {
          this.rYq.setImageResource(2131231490);
        }
      }
    }
    if (this.rXn != null) {
      this.rXn.sds.notifyVendingDataChange();
    }
    if (paramm.getType() == 211)
    {
      paramString = (com.tencent.mm.plugin.sns.model.y)paramm;
      if (!paramString.rew) {
        break label272;
      }
      paramm = com.tencent.mm.modelsns.b.lV(727);
      paramm.lY(this.rXn.getCount()).lY(paramString.ZY);
      paramm.ake();
    }
    for (;;)
    {
      if (this.rXv != null)
      {
        this.rXs = false;
        this.rXv.cwr();
      }
      AppMethodBeat.o(39577);
      return;
      label272:
      paramm = com.tencent.mm.modelsns.b.lV(728);
      paramm.lY(this.rXn.getCount()).lY(paramString.ZY).lY(0);
      paramm.ake();
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(39565);
    super.onStart();
    AppMethodBeat.o(39565);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(39566);
    super.onStop();
    AppMethodBeat.o(39566);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(39557);
    super.setActionbarColor(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.pyE != null))
    {
      this.pyE.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.a(getWindow());
    }
    AppMethodBeat.o(39557);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    AppMethodBeat.i(39570);
    boolean bool = super.supportNavigationSwipeBack();
    AppMethodBeat.o(39570);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI
 * JD-Core Version:    0.7.0.1
 */