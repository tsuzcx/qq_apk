package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.g.a.uk;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.up;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.g.a.ve;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.g.b.a.fb;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sns.ad.e.l.5;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.plugin.sns.j.a.a;
import com.tencent.mm.plugin.sns.j.b.2;
import com.tencent.mm.plugin.sns.l.c.b;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.plugin.sns.model.au.4;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.f;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.z;
import com.tencent.mm.vending.app.a.b;
import com.tencent.mm.vending.base.Vending.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

@com.tencent.mm.kernel.i
public class SnsTimeLineUI
  extends WxPresenterActivity
  implements com.tencent.mm.ak.f, com.tencent.mm.model.ax, i.a, w
{
  private static Boolean ABP;
  public static final Boolean ACw;
  private static final Set<Activity> sUILeaksRoutineEnsuranceRef;
  private boolean ABA;
  private i ABB;
  private int ABC;
  private a ABD;
  private TestTimeForSns ABE;
  private int ABF;
  private boolean ABG;
  private String ABH;
  private com.tencent.mm.plugin.sns.j.a ABI;
  private bb ABJ;
  private az ABK;
  private String ABL;
  private boolean ABM;
  private int ABN;
  private String ABO;
  private String ABQ;
  private c ABR;
  private bc ABS;
  private ViewGroup ABT;
  private long ABU;
  private int ABV;
  private int ABW;
  private int ABX;
  private int ABY;
  private int ABZ;
  private final long ABq;
  private long ABr;
  private com.tencent.mm.plugin.sns.l.b ABs;
  private com.tencent.mm.plugin.sns.l.a ABt;
  private com.tencent.mm.plugin.sns.ui.a.a.c ABu;
  private com.tencent.mm.plugin.sns.ui.a.c ABv;
  private LinearLayout ABw;
  private LinearLayout ABx;
  private QFadeImageView ABy;
  private boolean ABz;
  Runnable ACA;
  private Handler ACB;
  private Runnable ACC;
  private SnsUIAction.a ACD;
  private long ACE;
  private a.b ACF;
  boolean ACG;
  int ACH;
  private MenuItem.OnMenuItemClickListener ACI;
  private ImageView ACJ;
  private View ACK;
  private long ACL;
  private boolean ACM;
  private com.tencent.mm.ui.widget.a.e ACa;
  private Runnable ACb;
  private com.tencent.mm.sdk.b.c ACc;
  private com.tencent.mm.sdk.b.c ACd;
  private Vending.d ACe;
  private boolean ACf;
  private com.tencent.mm.sdk.b.c ACg;
  private com.tencent.mm.sdk.b.c ACh;
  private com.tencent.mm.sdk.b.c ACi;
  private com.tencent.mm.sdk.b.c ACj;
  private com.tencent.mm.sdk.b.c ACk;
  private com.tencent.mm.sdk.b.c ACl;
  private com.tencent.mm.sdk.b.c ACm;
  private com.tencent.mm.sdk.b.c ACn;
  private com.tencent.mm.sdk.b.c ACo;
  private com.tencent.mm.sdk.b.c ACp;
  private com.tencent.mm.sdk.b.c ACq;
  private com.tencent.mm.sdk.b.c ACr;
  private com.tencent.mm.sdk.b.c ACs;
  private com.tencent.mm.sdk.b.c ACt;
  private com.tencent.mm.sdk.b.c ACu;
  private com.tencent.mm.sdk.b.c ACv;
  private long ACx;
  boolean ACy;
  Runnable ACz;
  private boolean Ags;
  private boolean Aiv;
  private volatile boolean AoZ;
  private bi.a ApP;
  protected com.tencent.mm.plugin.sns.ad.e.j Asq;
  private boolean autoPlay;
  private int fMX;
  private long gyO;
  private long hYE;
  private String lJm;
  private ActionBar mActionBar;
  private int mScreenHeight;
  private int mScreenWidth;
  private String mSessionId;
  private SnsUIAction mUIAction;
  private com.tencent.mm.ui.statusbar.c.a spA;
  private int tnI;
  private long vIW;
  private View xgg;
  private com.tencent.mm.sdk.b.c zCJ;
  private boolean zIg;
  
  static
  {
    AppMethodBeat.i(99430);
    ABP = null;
    ACw = Boolean.FALSE;
    sUILeaksRoutineEnsuranceRef = new HashSet();
    AppMethodBeat.o(99430);
  }
  
  public SnsTimeLineUI()
  {
    AppMethodBeat.i(99372);
    this.ABq = 300L;
    this.ABr = SystemClock.elapsedRealtime();
    this.ABs = ((com.tencent.mm.plugin.sns.l.b)am(com.tencent.mm.plugin.sns.l.b.class));
    if (this.ABs != null) {}
    for (com.tencent.mm.plugin.sns.l.a locala = this.ABs.eiO();; locala = null)
    {
      this.ABt = locala;
      this.ABu = new com.tencent.mm.plugin.sns.ui.a.a.c();
      this.ABz = false;
      this.ABA = false;
      this.Ags = false;
      this.ABC = 800;
      this.ABF = 0;
      this.ABG = false;
      this.ABH = "";
      this.ABI = new com.tencent.mm.plugin.sns.j.a();
      this.Asq = new com.tencent.mm.plugin.sns.ad.e.j(0);
      this.ABJ = new bb();
      this.ABK = new az();
      this.autoPlay = false;
      this.ABQ = "";
      this.ABR = new c((byte)0);
      this.ABS = new bc();
      this.ABT = null;
      this.ABU = 0L;
      this.AoZ = false;
      this.ABV = 0;
      this.ABW = 0;
      this.ABX = 0;
      this.ABY = 0;
      this.ABZ = 2;
      this.ACb = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99267);
          com.tencent.mm.plugin.sns.ui.a.c localc = SnsTimeLineUI.a(SnsTimeLineUI.this);
          if (localc != null)
          {
            if (ah.dXN().zDB == av.zEb) {
              SnsTimeLineUI.a(SnsTimeLineUI.this, localc.sg(true));
            }
            localc.AIr.ege();
            localc.AIr.notifyVendingDataChange();
          }
          AppMethodBeat.o(99267);
        }
      };
      this.ACc = new com.tencent.mm.sdk.b.c() {};
      this.ACd = new com.tencent.mm.sdk.b.c() {};
      this.ACe = new Vending.d()
      {
        public final void egL()
        {
          AppMethodBeat.i(179249);
          final int i;
          if ((SnsTimeLineUI.a(SnsTimeLineUI.this) != null) && (!SnsTimeLineUI.a(SnsTimeLineUI.this).AIs))
          {
            SnsTimeLineUI.a(SnsTimeLineUI.this).notifyDataSetChanged();
            if (SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView() != null)
            {
              i = com.tencent.mm.ui.ar.dX(SnsTimeLineUI.this.getContext());
              int j = com.tencent.mm.ui.ar.jN(SnsTimeLineUI.this.getContext());
              ae.d("MicroMsg.SnsTimeLineUI", "topOffset:%s curFetchMode:%s, mUIAction.header.getLoadingGroupHeight():%s, actionBar:%s, statusBar:%s", new Object[] { Integer.valueOf(-(SnsTimeLineUI.d(SnsTimeLineUI.this).zIf.getLoadingGroupHeight() - com.tencent.mm.ui.aq.fromDPToPix(SnsTimeLineUI.this.getContext(), 44) - i - j)), Integer.valueOf(ah.dXN().zDB), Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).zIf.getLoadingGroupHeight()), Integer.valueOf(i), Integer.valueOf(j) });
              if (ah.dXN().zDB == av.zEa)
              {
                ae.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_SPECIFIC");
                long l = SnsTimeLineUI.a(SnsTimeLineUI.this).ehA();
                ah.dXu().V(l, -1);
                SnsTimeLineUI.a(SnsTimeLineUI.this).AIr.aCm(com.tencent.mm.plugin.sns.data.r.zW(l));
                SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.a(SnsTimeLineUI.this).sg(true));
                SnsTimeLineUI.d(SnsTimeLineUI.this).sd(true);
                ah.dXB().start();
                SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(219972);
                    SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().setSelectionFromTop(SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), i + com.tencent.mm.ui.aq.fromDPToPix(SnsTimeLineUI.this.getContext(), 44));
                    ah.dXN().zDD = false;
                    AppMethodBeat.o(219972);
                  }
                });
                AppMethodBeat.o(179249);
                return;
              }
              if (ah.dXN().zDB == av.zEb)
              {
                i = 0;
                if (i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) {
                  break label421;
                }
                if (SnsTimeLineUI.a(SnsTimeLineUI.this).RA(i).field_snsId != SnsTimeLineUI.e(SnsTimeLineUI.this)) {
                  break label414;
                }
              }
            }
          }
          for (;;)
          {
            ae.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_UP upFetchRightId:%s, rightIndex:%s", new Object[] { Long.valueOf(SnsTimeLineUI.e(SnsTimeLineUI.this)), Integer.valueOf(i) });
            SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().setSelectionFromTop(i + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), SnsTimeLineUI.d(SnsTimeLineUI.this).getHeaderHeight());
            AppMethodBeat.o(179249);
            return;
            label414:
            i += 1;
            break;
            label421:
            i = 0;
          }
        }
      };
      this.ACf = false;
      this.zIg = false;
      this.ACg = new com.tencent.mm.sdk.b.c() {};
      this.ACh = new com.tencent.mm.sdk.b.c() {};
      this.ACi = new SnsTimeLineUI.66(this);
      this.ACj = new com.tencent.mm.sdk.b.c() {};
      this.ACk = new com.tencent.mm.sdk.b.c() {};
      this.ACl = new com.tencent.mm.sdk.b.c() {};
      this.ACm = new com.tencent.mm.sdk.b.c() {};
      this.ACn = new com.tencent.mm.sdk.b.c() {};
      this.ACo = new com.tencent.mm.sdk.b.c() {};
      this.zCJ = new com.tencent.mm.sdk.b.c() {};
      this.ACp = new com.tencent.mm.sdk.b.c() {};
      this.ACq = new com.tencent.mm.sdk.b.c() {};
      this.ACr = new com.tencent.mm.sdk.b.c() {};
      this.ACs = new com.tencent.mm.sdk.b.c() {};
      this.ACt = new com.tencent.mm.sdk.b.c() {};
      this.ACu = new com.tencent.mm.sdk.b.c() {};
      this.ACv = new com.tencent.mm.sdk.b.c() {};
      this.ACx = 0L;
      this.ACy = false;
      this.tnI = 0;
      this.ACz = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176303);
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) == null)
          {
            AppMethodBeat.o(176303);
            return;
          }
          if (SnsTimeLineUI.v(SnsTimeLineUI.this)) {
            ah.dXB().pause();
          }
          AppMethodBeat.o(176303);
        }
      };
      this.ACA = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179225);
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) == null)
          {
            AppMethodBeat.o(179225);
            return;
          }
          if (!SnsTimeLineUI.v(SnsTimeLineUI.this))
          {
            ae.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() - SnsTimeLineUI.d(SnsTimeLineUI.this).list.getHeaderViewsCount()) });
            ah.dXB().start();
            SnsTimeLineUI.a(SnsTimeLineUI.this).AIq.egr();
          }
          AppMethodBeat.o(179225);
        }
      };
      this.ACB = ((com.tencent.mm.vending.h.b)com.tencent.mm.vending.h.d.LFo.LFw).mHandler;
      this.ACC = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179226);
          SnsTimeLineUI.this.setMMNormalView();
          SnsTimeLineUI.w(SnsTimeLineUI.this);
          SnsTimeLineUI.x(SnsTimeLineUI.this);
          SnsTimeLineUI.this.setMMTitle(SnsTimeLineUI.this.getString(2131764037));
          SnsTimeLineUI.y(SnsTimeLineUI.this);
          SnsTimeLineUI.c(SnsTimeLineUI.this, SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition());
          AppMethodBeat.o(179226);
        }
      };
      this.ACD = new SnsUIAction.a()
      {
        private int ACU = 0;
        private int ACV = 0;
        
        public final void RW(int paramAnonymousInt)
        {
          AppMethodBeat.i(219965);
          int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          int k = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
          if ((paramAnonymousInt == 0) && (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)) {
            SnsTimeLineUI.a(SnsTimeLineUI.this, j, k);
          }
          if ((j == this.ACU) && (k == this.ACV))
          {
            AppMethodBeat.o(219965);
            return;
          }
          this.ACU = j;
          this.ACV = k;
          ae.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramAnonymousInt) });
          Object localObject1;
          boolean bool;
          int m;
          int n;
          int i1;
          if (paramAnonymousInt == 2)
          {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, SnsTimeLineUI.E(SnsTimeLineUI.this));
            localObject1 = SnsTimeLineUI.this;
            bool = WXHardCoderJNI.hcSNSScrollEnable;
            m = WXHardCoderJNI.hcSNSScrollDelay;
            n = WXHardCoderJNI.hcSNSScrollCPU;
            i1 = WXHardCoderJNI.hcSNSScrollIO;
            if (!WXHardCoderJNI.hcSNSScrollThr) {
              break label516;
            }
          }
          LinkedList localLinkedList;
          label516:
          for (int i = Process.myTid();; i = 0)
          {
            SnsTimeLineUI.d((SnsTimeLineUI)localObject1, WXHardCoderJNI.startPerformance(bool, m, n, i1, i, WXHardCoderJNI.hcSNSScrollTimeout, 701, WXHardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI"));
            ae.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsTimeLineUI.E(SnsTimeLineUI.this)) });
            if ((paramAnonymousInt != 0) || (SnsTimeLineUI.a(SnsTimeLineUI.this) == null)) {
              break label550;
            }
            localObject1 = SnsTimeLineUI.a(SnsTimeLineUI.this);
            if (k < j) {
              break label537;
            }
            localLinkedList = new LinkedList();
            paramAnonymousInt = j;
            while (paramAnonymousInt <= k)
            {
              Object localObject2 = ((com.tencent.mm.plugin.sns.ui.a.c)localObject1).RA(paramAnonymousInt - 1);
              if (localObject2 != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject2).ebP();
                if ((localObject2 != null) && (!TextUtils.isEmpty(((TimeLineObject)localObject2).HUG.Url)) && (((TimeLineObject)localObject2).HUG.Url.contains("mp.weixin.qq.com")) && (((TimeLineObject)localObject2).HUG.Gtw == 3))
                {
                  i = -1;
                  if (((TimeLineObject)localObject2).HUG.GtA != null) {
                    i = ((TimeLineObject)localObject2).HUG.GtA.hFR;
                  }
                  ArrayList localArrayList = new ArrayList();
                  localArrayList.add(((TimeLineObject)localObject2).HUG.Url);
                  localArrayList.add(String.valueOf(i));
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).Id));
                  localArrayList.add("");
                  localArrayList.add("");
                  localArrayList.add(((TimeLineObject)localObject2).nIJ);
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).CreateTime));
                  localArrayList.add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).XB("__sns_timeline__")));
                  localLinkedList.add(localArrayList);
                }
              }
              paramAnonymousInt += 1;
            }
          }
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).j(localLinkedList, 2);
          label537:
          SnsTimeLineUI.a(SnsTimeLineUI.this).hX(j, k);
          label550:
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)
          {
            localObject1 = SnsTimeLineUI.j(SnsTimeLineUI.this).b(SnsTimeLineUI.a(SnsTimeLineUI.this).AIq);
            com.tencent.mm.vending.g.g.fSA().d(new com.tencent.mm.vending.c.a() {});
          }
          com.tencent.mm.plugin.sns.j.e.zKO.hE(j, k);
          com.tencent.mm.plugin.sns.j.e.zKO.hF(j, k);
          AppMethodBeat.o(219965);
        }
        
        public final void a(com.tencent.mm.plugin.sns.data.m paramAnonymousm) {}
        
        public final void aC(int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(219966);
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).AIr.notifyVendingDataChange();
          }
          if (!paramAnonymousBoolean) {
            SnsTimeLineUI.this.akP().bk(c.b.class);
          }
          AppMethodBeat.o(219966);
        }
        
        public final void e(int paramAnonymousInt, List<Integer> paramAnonymousList1, List<Integer> paramAnonymousList2)
        {
          int j = 1;
          AppMethodBeat.i(219960);
          int i = j;
          if (paramAnonymousInt > 0)
          {
            paramAnonymousList1 = ah.dXE().Rw(paramAnonymousInt);
            i = j;
            if (paramAnonymousList1 != null)
            {
              if (paramAnonymousList1.field_pravited > 0) {
                Toast.makeText(SnsTimeLineUI.this, 2131763840, 1).show();
              }
              i = j;
              if (paramAnonymousList1.field_pravited == 1) {
                i = 0;
              }
            }
          }
          if (i != 0)
          {
            paramAnonymousList1 = SnsTimeLineUI.d(SnsTimeLineUI.this).list;
            paramAnonymousList1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousList1);
            paramAnonymousList2 = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousList2, paramAnonymousList1.ahE(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.c.b((ListView)paramAnonymousList1.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousList2, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          }
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).AIr.notifyVendingDataChange();
          }
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.b(SnsTimeLineUI.this);
          }
          AppMethodBeat.o(219960);
        }
        
        public final void egE()
        {
          AppMethodBeat.i(219955);
          if (ah.dXN().zDD)
          {
            ae.i("MicroMsg.SnsTimeLineUI", "isAutoScrolling, skip onLoadingMore");
            AppMethodBeat.o(219955);
            return;
          }
          com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
          SnsTimeLineUI.n(SnsTimeLineUI.this);
          localc.e(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), false, SnsTimeLineUI.A(SnsTimeLineUI.this));
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IZC, Integer.valueOf(3));
          ae.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
          if (SnsTimeLineUI.B(SnsTimeLineUI.this) == null)
          {
            ae.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
            AppMethodBeat.o(219955);
            return;
          }
          if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
          {
            SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
            SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
          }
          AppMethodBeat.o(219955);
        }
        
        public final View egF()
        {
          AppMethodBeat.i(219957);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).zGt == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).zGt = ((FrameLayout)SnsTimeLineUI.this.findViewById(2131305824));
          }
          FrameLayout localFrameLayout = SnsTimeLineUI.k(SnsTimeLineUI.this).zGt;
          AppMethodBeat.o(219957);
          return localFrameLayout;
        }
        
        public final MMPullDownView egG()
        {
          AppMethodBeat.i(219959);
          MMPullDownView localMMPullDownView = (MMPullDownView)SnsTimeLineUI.this.findViewById(2131305047);
          AppMethodBeat.o(219959);
          return localMMPullDownView;
        }
        
        public final boolean egH()
        {
          AppMethodBeat.i(219961);
          boolean bool = SnsTimeLineUI.D(SnsTimeLineUI.this);
          AppMethodBeat.o(219961);
          return bool;
        }
        
        public final void egI()
        {
          AppMethodBeat.i(219962);
          ae.d("MicroMsg.SnsTimeLineUI", "onLoadingTap");
          SnsTimeLineUI.this.edt();
          if (!SnsTimeLineUI.d(SnsTimeLineUI.this).AmY)
          {
            if (SnsTimeLineUI.u(SnsTimeLineUI.this) != null)
            {
              ae.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
              SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
            }
            com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this);
            localc.d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IZC, Integer.valueOf(2));
          }
          AppMethodBeat.o(219962);
        }
        
        public final void egJ()
        {
          AppMethodBeat.i(219963);
          SnsTimeLineUI.this.edt();
          AppMethodBeat.o(219963);
        }
        
        public final void egK()
        {
          AppMethodBeat.i(219964);
          ah.dXN().dYw();
          int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          Object localObject1 = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getChildAt(0);
          ae.i("MicroMsg.SnsTimeLineUI", "will do up fetch isDoingFetch:%s, SnsCore.getSnsUnreadTipManager().isAutoScrolling:%s", new Object[] { Boolean.valueOf(ah.dXN().zDE), Boolean.valueOf(ah.dXN().zDD) });
          if ((!ah.dXN().zDD) && (localObject1 != null) && (i == 0) && (((View)localObject1).getTop() == 0) && (SnsTimeLineUI.d(SnsTimeLineUI.this).AmY))
          {
            if (ah.dXN().zDE)
            {
              AppMethodBeat.o(219964);
              return;
            }
            Object localObject2 = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this);
            localObject1 = SnsTimeLineUI.o(SnsTimeLineUI.this);
            i = av.zEb;
            boolean bool = SnsTimeLineUI.q(SnsTimeLineUI.this);
            int j = SnsTimeLineUI.A(SnsTimeLineUI.this);
            if ((((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).hasInit) && (((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).ACH == 0))
            {
              long l = ah.dXN().zDA;
              localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).AIN;
              if (((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).ABs != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).ABs.AVJ;
                com.tencent.mm.vending.g.g.b(localObject1, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(j), Long.valueOf(l)).c((com.tencent.mm.vending.c.a)localObject2);
              }
            }
            if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
            {
              SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
              SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
            }
          }
          AppMethodBeat.o(219964);
        }
        
        public final View getMaskView()
        {
          AppMethodBeat.i(219958);
          View localView = SnsTimeLineUI.this.findViewById(2131304966);
          AppMethodBeat.o(219958);
          return localView;
        }
        
        public final ListView getSnsListView()
        {
          AppMethodBeat.i(219956);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).list == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).list = ((ListView)SnsTimeLineUI.this.findViewById(2131305038));
          }
          ListView localListView = SnsTimeLineUI.k(SnsTimeLineUI.this).list;
          AppMethodBeat.o(219956);
          return localListView;
        }
        
        public final int getType()
        {
          int i = 1;
          if (SnsTimeLineUI.this.ACH == 1) {
            i = 2;
          }
          return i;
        }
        
        public final void hW(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void sc(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(219967);
          SnsTimeLineUI localSnsTimeLineUI = SnsTimeLineUI.this;
          localSnsTimeLineUI.ACy = paramAnonymousBoolean;
          com.tencent.mm.sdk.platformtools.aq localaq = ah.cXK();
          com.tencent.mm.plugin.sns.model.g localg = ah.dXB();
          com.tencent.mm.plugin.sns.model.c localc = ah.dXz();
          if (paramAnonymousBoolean)
          {
            if ((localg.zwA) || (localc.zwA))
            {
              localaq.removeCallbacks(localSnsTimeLineUI.ACz);
              localaq.removeCallbacks(localSnsTimeLineUI.ACA);
              localaq.postDelayed(localSnsTimeLineUI.ACz, 0L);
              AppMethodBeat.o(219967);
            }
          }
          else if ((!localg.zwA) || (!localc.zwA))
          {
            localaq.removeCallbacks(localSnsTimeLineUI.ACz);
            localaq.removeCallbacks(localSnsTimeLineUI.ACA);
            localaq.postDelayed(localSnsTimeLineUI.ACA, 0L);
          }
          AppMethodBeat.o(219967);
        }
      };
      this.ACE = 0L;
      this.ACF = new a.b() {};
      this.mScreenWidth = 0;
      this.mScreenHeight = 0;
      this.ACG = true;
      this.vIW = 0L;
      this.gyO = 0L;
      this.hYE = 0L;
      this.ApP = new bi.a()
      {
        public final void X(String paramAnonymousString, long paramAnonymousLong)
        {
          AppMethodBeat.i(219976);
          ae.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
          SnsTimeLineUI.L(SnsTimeLineUI.this);
          AppMethodBeat.o(219976);
        }
      };
      this.ACH = 0;
      this.ACI = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(219989);
          SnsTimeLineUI.this.hideVKB();
          SnsTimeLineUI.this.finish();
          AppMethodBeat.o(219989);
          return false;
        }
      };
      this.ACL = 0L;
      this.ACM = false;
      AppMethodBeat.o(99372);
      return;
    }
  }
  
  private void RV(int paramInt)
  {
    AppMethodBeat.i(99376);
    if (ACw.booleanValue()) {
      if (paramInt != 0) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.SnsTimeLineUI", "setRefreshAnimVisible %s %s", new Object[] { Boolean.valueOf(bool), bu.fpN().toString() });
      this.ABy.setVisibility(paramInt);
      AppMethodBeat.o(99376);
      return;
    }
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(99406);
    if (paramc.active)
    {
      ae.d("MicroMsg.SnsTimeLineUI", "report weishi: %s", new Object[] { paramc.toString() });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(15827, paramc.toString());
    }
    AppMethodBeat.o(99406);
  }
  
  private void dOM()
  {
    AppMethodBeat.i(99391);
    setTitleBarClickListener(new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(219990);
        SnsTimeLineUI.Q(SnsTimeLineUI.this);
        AppMethodBeat.o(219990);
      }
    }, new Runnable()
    {
      public final void run() {}
    });
    setBackBtn(this.ACI, 2131689490);
    AppMethodBeat.o(99391);
  }
  
  private int egA()
  {
    if (this.ABZ == 0) {
      return this.ABW;
    }
    if (this.ABZ == 1) {
      return this.ABX;
    }
    return this.ABY;
  }
  
  private void egB()
  {
    AppMethodBeat.i(99392);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.JdU, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JdU, Boolean.FALSE);
    if (bool) {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JdU, Boolean.FALSE);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.g.ajS();
      int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IZL, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(getContext(), "", getContext().getResources().getString(2131764291, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(99392);
      return;
    }
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).startStoryCaptureForResult(getContext(), 0, System.currentTimeMillis(), 18);
    AppMethodBeat.o(99392);
  }
  
  private void egC()
  {
    AppMethodBeat.i(99393);
    if (com.tencent.mm.r.a.cf(this))
    {
      AppMethodBeat.o(99393);
      return;
    }
    if (com.tencent.mm.r.a.cj(this))
    {
      AppMethodBeat.o(99393);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "");
    ae.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this });
    if (!bool)
    {
      AppMethodBeat.o(99393);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 18, "", "");
    ae.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this });
    if (!bool)
    {
      AppMethodBeat.o(99393);
      return;
    }
    long l = ch.aDb();
    Object localObject1 = com.tencent.mm.plugin.sns.data.r.dWp();
    ae.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", new Object[] { localObject1 });
    com.tencent.mm.plugin.report.service.g.yxI.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), localObject1, Long.valueOf(l) });
    Object localObject2 = new SightParams(2, 0);
    localObject2 = RecordConfigProvider.a("", "", ((SightParams)localObject2).hxV, ((SightParams)localObject2).hxV.duration * 1000, 2);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFC, false)) {
      ((RecordConfigProvider)localObject2).remuxType = 2;
    }
    Object localObject3 = new VideoCaptureReportInfo();
    ((VideoCaptureReportInfo)localObject3).roH = 1;
    ((RecordConfigProvider)localObject2).xOx = ((VideoCaptureReportInfo)localObject3);
    localObject3 = new UICustomParam.a();
    ((UICustomParam.a)localObject3).abG();
    ((UICustomParam.a)localObject3).abH();
    ((UICustomParam.a)localObject3).cP(true);
    ((RecordConfigProvider)localObject2).xOh = ((UICustomParam.a)localObject3).ggq;
    localObject3 = new SnsTimeLineUI.63(this);
    CaptureDataManager.xNV.xNU = ((CaptureDataManager.b)localObject3);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFA, true))
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 17, 2130772137, 2130772138, (RecordConfigProvider)localObject2);
      AppMethodBeat.o(99393);
      return;
    }
    localObject2 = new Intent();
    com.tencent.mm.pluginsdk.ui.tools.q.d(getContext(), (Intent)localObject2, (String)localObject1);
    AppMethodBeat.o(99393);
  }
  
  private void egx()
  {
    AppMethodBeat.i(99377);
    this.mUIAction.list.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99306);
        int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
        int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
        ae.d("MicroMsg.SnsTimeLineUI", "notifyList from:%s to:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        SnsTimeLineUI.a(SnsTimeLineUI.this, i, j);
        SnsTimeLineUI.d(SnsTimeLineUI.this).bns();
        AppMethodBeat.o(99306);
      }
    }, 15L);
    AppMethodBeat.o(99377);
  }
  
  private void egy()
  {
    AppMethodBeat.i(99380);
    boolean bool;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxR, 0) == 1)
    {
      bool = true;
      this.autoPlay = bool;
      String str1 = Build.MODEL.toLowerCase();
      String str2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxS, "");
      if ((!bu.isNullOrNil(str2)) && (str2.contains(str1)))
      {
        ae.i("MicroMsg.SnsTimeLineUI", "model %s is hit, expt:%s", new Object[] { str1, str2 });
        this.autoPlay = false;
      }
      if (!this.autoPlay) {
        break label225;
      }
      if (!this.ABS.drZ()) {
        break label170;
      }
      this.autoPlay = false;
      ae.i("MicroMsg.SnsTimeLineUI", "2G/3G autoplay false");
    }
    for (;;)
    {
      ae.i("MicroMsg.SnsTimeLineUI", "autoPlay:%s", new Object[] { Boolean.valueOf(this.autoPlay) });
      AppMethodBeat.o(99380);
      return;
      bool = false;
      break;
      label170:
      if (this.ABS.ciH())
      {
        ae.i("MicroMsg.SnsTimeLineUI", "wifi autoplay true");
        this.autoPlay = true;
      }
      else
      {
        this.autoPlay = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IRV, Boolean.TRUE)).booleanValue();
        continue;
        label225:
        ae.i("MicroMsg.SnsTimeLineUI", "autoPlay DynamicConfig false");
      }
    }
  }
  
  private void egz()
  {
    AppMethodBeat.i(99381);
    if (this.ACH == 1)
    {
      if (!this.Aiv)
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99381);
        return;
      }
      addIconOptionMenu(0, getString(2131763911), 2131689502, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(179251);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
          paramAnonymousMenuItem.putExtra("sns_msg_force_show_all", true);
          paramAnonymousMenuItem.putExtra("sns_msg_comment_list_scene", 1);
          SnsTimeLineUI.this.startActivityForResult(paramAnonymousMenuItem, 8);
          AppMethodBeat.o(179251);
          return true;
        }
      });
      AppMethodBeat.o(99381);
      return;
    }
    addIconOptionMenu(0, 2131763730, 2131690361, new MenuItem.OnMenuItemClickListener()new View.OnLongClickListener
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(219974);
        SnsTimeLineUI.K(SnsTimeLineUI.this);
        AppMethodBeat.o(219974);
        return true;
      }
    }, new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(219975);
        localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).Agj != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).Agj.zCa.rx(true);
        }
        com.tencent.mm.kernel.g.ajS();
        boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(7490, Boolean.TRUE)).booleanValue();
        ah.dXL().rO(true);
        paramAnonymousView = ah.dXL().aBs("draft_text");
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.field_draft;
          if (!bu.cF(paramAnonymousView))
          {
            com.tencent.mm.kernel.g.ajS();
            localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMV, "");
            new fb().Tt().oB((String)localObject).aLH();
            localObject = Parcel.obtain();
            ((Parcel)localObject).unmarshall(paramAnonymousView, 0, paramAnonymousView.length);
            ((Parcel)localObject).setDataPosition(0);
          }
        }
        try
        {
          paramAnonymousView = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject);
          if (SnsTimeLineUI.aP(paramAnonymousView))
          {
            SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(219975);
            return true;
          }
          ah.dXL().b("draft_text", null, 0);
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ah.dXL().b("draft_text", null, 0);
            continue;
            paramAnonymousView = SnsTimeLineUI.this;
            localObject = new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajR().ajA().set(7490, Boolean.FALSE);
          }
        }
        if (!bool)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(SnsTimeLineUI.this, SnsUploadUI.class);
          paramAnonymousView.putExtra("KSnsPostManu", true);
          paramAnonymousView.putExtra("KTouchCameraTime", bu.aRi());
          paramAnonymousView.putExtra("sns_comment_type", 1);
          paramAnonymousView.putExtra("Ksnsupload_type", 9);
          localObject = com.tencent.mm.modelsns.e.pY(705);
          ((com.tencent.mm.modelsns.e)localObject).qc(((com.tencent.mm.modelsns.e)localObject).iqa).GV(System.currentTimeMillis()).qc(((com.tencent.mm.modelsns.e)localObject).iqb).qc(1);
          localObject = com.tencent.mm.plugin.sns.j.g.zLJ.b((com.tencent.mm.modelsns.e)localObject);
          ((com.tencent.mm.modelsns.e)localObject).aLH();
          ((com.tencent.mm.modelsns.e)localObject).b(paramAnonymousView, "intent_key_StatisticsOplog");
          SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(219975);
          return true;
        }
      }
    });
    AppMethodBeat.o(99381);
  }
  
  private boolean fk(View paramView)
  {
    AppMethodBeat.i(220002);
    try
    {
      if (getContext() != null)
      {
        boolean bool = getContext().isFinishing();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(220002);
        return false;
      }
      Rect localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      paramView = new DisplayMetrics();
      getContext().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      int i = paramView.heightPixels;
      int j = this.mActionBar.getHeight() + com.tencent.mm.ui.al.jO(this);
      ae.i("MicroMsg.SnsTimeLineUI.ScreenShot", "lxl checkItemVisible actionbar height:%s, total height:%s, screenHeight:%s, top:%s, bottom:%s", new Object[] { Integer.valueOf(this.mActionBar.getHeight()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localRect.top), Integer.valueOf(localRect.bottom) });
      if ((localRect.bottom > j) && (i > localRect.top))
      {
        AppMethodBeat.o(220002);
        return true;
      }
    }
    catch (Throwable paramView)
    {
      ae.e("MicroMsg.SnsTimeLineUI.ScreenShot", paramView.toString());
      AppMethodBeat.o(220002);
      return false;
    }
    AppMethodBeat.o(220002);
    return false;
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(220001);
    ae.i("MicroMsg.SnsTimeLineUI", "onOtherAddSize respMaxSeq:%s, respMinSeq:%s", new Object[] { paramString1, paramString2 });
    this.ACB.removeCallbacks(this.ACb);
    com.tencent.mm.vending.g.g.fSA().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(220001);
  }
  
  public final void a(final String paramString, boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99373);
    this.ACB.removeCallbacks(this.ACb);
    com.tencent.mm.vending.g.g.fSA().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(99373);
  }
  
  public final void aBT()
  {
    AppMethodBeat.i(99396);
    akP().bk(c.b.class);
    AppMethodBeat.o(99396);
  }
  
  public final void aBU() {}
  
  public final void aBV()
  {
    AppMethodBeat.i(99397);
    if (this.ACM)
    {
      AppMethodBeat.o(99397);
      return;
    }
    ae.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
    this.ACM = true;
    ah.cXK().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179284);
        if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
          SnsTimeLineUI.a(SnsTimeLineUI.this).AIr.notifyVendingDataChange();
        }
        SnsTimeLineUI.ac(SnsTimeLineUI.this);
        AppMethodBeat.o(179284);
      }
    }, 1000L);
    AppMethodBeat.o(99397);
  }
  
  public final void aBW()
  {
    AppMethodBeat.i(99400);
    akP().bk(c.b.class);
    AppMethodBeat.o(99400);
  }
  
  public final void b(final String paramString, final boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99374);
    this.ACB.removeCallbacks(this.ACb);
    com.tencent.mm.vending.g.g.fSA().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
    {
      private Void a(Void paramAnonymousVoid)
      {
        AppMethodBeat.i(219951);
        if (SnsTimeLineUI.l(SnsTimeLineUI.this) != null)
        {
          SnsTimeLineUI.m(SnsTimeLineUI.this);
          SnsTimeLineUI.l(SnsTimeLineUI.this).egR();
        }
        SnsTimeLineUI.d(SnsTimeLineUI.this).oRf = paramb.dVP();
        if (SnsTimeLineUI.this.ACH == 0)
        {
          ae.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[] { Boolean.valueOf(paramb.dVP()) });
          if (paramb.dVP()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).aCl(paramb.dVV());
          }
          AppMethodBeat.o(219951);
          return paramAnonymousVoid;
        }
        if ((paramBoolean) && (!SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))))
        {
          SnsTimeLineUI.d(SnsTimeLineUI.this).oRf = true;
          SnsTimeLineUI.d(SnsTimeLineUI.this).aBZ(paramb.dVV());
        }
        for (;;)
        {
          AppMethodBeat.o(219951);
          return paramAnonymousVoid;
          if ((SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))) && (paramb.dVU() != 0L))
          {
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISn, Long.valueOf(paramb.dVU()));
          }
          if (paramb.dVP()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).aCl(paramb.dVV());
          }
        }
      }
    });
    AppMethodBeat.o(99374);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(99378);
    ae.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[] { paramKeyEvent.toString() });
    int k = keyboardState();
    i locali = this.ABB;
    int i = j;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      i = j;
      if (locali.Agn.getVisibility() == 0)
      {
        locali.Agn.setVisibility(8);
        i = 1;
      }
    }
    if ((i != 0) && (k == 2))
    {
      AppMethodBeat.o(99378);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(99378);
    return bool;
  }
  
  public final boolean edt()
  {
    AppMethodBeat.i(99395);
    if ((this.ABB == null) || (this.ABB.Agu == null))
    {
      AppMethodBeat.o(99395);
      return false;
    }
    if ((this.ABB == null) || (this.ABB.Agv == null))
    {
      if ((this.ABB != null) && (this.ABB.Agx != null)) {
        break label118;
      }
      label65:
      if ((this.ABB != null) && (this.ABB.Agy != null)) {
        break label132;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.dUu();
      boolean bool = this.ABB.Agu.edt();
      AppMethodBeat.o(99395);
      return bool;
      this.ABB.Agv.dYX();
      break;
      label118:
      this.ABB.Agx.dYX();
      break label65;
      label132:
      this.ABB.Agy.ehy();
    }
  }
  
  public final com.tencent.mm.plugin.sns.ad.e.j egD()
  {
    return this.Asq;
  }
  
  public final boolean fg(View paramView)
  {
    AppMethodBeat.i(99394);
    this.ABB.Agv.dYX();
    this.ABB.Agx.dYX();
    bp localbp = this.ABB.Agu;
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      ae.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
      AppMethodBeat.o(99394);
      return false;
    }
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    Object localObject1 = localBaseViewHolder.dqc;
    if (localbp.AHG != null)
    {
      if ((localbp.AHG.getTag() instanceof bp.a))
      {
        localObject2 = (bp.a)localbp.AHG.getTag();
        if (((bp.a)localObject2).zGN.equals(localObject1))
        {
          localbp.fl(((bp.a)localObject2).zom);
          AppMethodBeat.o(99394);
          return true;
        }
        localbp.edt();
      }
      localbp.AHG = null;
    }
    localbp.AHG = new SnsCommentShowAbLayout(localbp.mContext);
    com.tencent.mm.sdk.platformtools.r.fnY();
    localbp.AHG.setId(2131296470);
    new FrameLayout.LayoutParams(-1, -1);
    localbp.zGt.addView(localbp.AHG);
    int i = BackwardSupportUtil.b.h(localbp.mContext, 192.0F);
    int j = BackwardSupportUtil.b.h(localbp.mContext, 76.0F);
    int k = BackwardSupportUtil.b.h(localbp.mContext, 8.0F);
    BackwardSupportUtil.b.h(localbp.mContext, 16.0F);
    int m = BackwardSupportUtil.b.h(localbp.mContext, 40.0F);
    Object localObject2 = z.jV(localbp.mContext).inflate(2131495535, null);
    new Rect();
    Object localObject3 = new int[2];
    com.tencent.mm.pluginsdk.h.hs(localbp.mContext);
    int n = com.tencent.mm.cb.a.fromDPToPix(localbp.mContext, 1);
    paramView.getLocationInWindow((int[])localObject3);
    localbp.zpn = com.tencent.mm.ui.al.jO(localbp.mContext);
    ae.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + n + " height_hardcode:" + j + " statusBarHeight: " + localbp.zpn);
    localObject3 = new AbsoluteLayout.LayoutParams(-2, -2, localObject3[0] - i - k, localObject3[1] - n - (m / 2 - paramView.getMeasuredHeight() / 2));
    localObject1 = new bp.a(localbp, (String)localObject1, (View)localObject2);
    localbp.AHG.setTag(localObject1);
    localbp.AHG.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    if (localBaseViewHolder.oOD == 10) {
      ((View)localObject2).findViewById(2131296548).setBackgroundResource(2131232447);
    }
    ((View)localObject2).setVisibility(8);
    new com.tencent.mm.sdk.platformtools.aq().post(new bp.1(localbp, paramView, (View)localObject2));
    AppMethodBeat.o(99394);
    return true;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(99399);
    ae.d("MicroMsg.SnsTimeLineUI", "finalize");
    super.finalize();
    AppMethodBeat.o(99399);
  }
  
  public int getLayoutId()
  {
    return 2131495615;
  }
  
  public void initView()
  {
    boolean bool3 = false;
    AppMethodBeat.i(99388);
    this.mUIAction.zIf.setDrawingCacheEnabled(false);
    this.ABB.zGt = ((FrameLayout)findViewById(2131305824));
    int i = ah.dXM().position;
    Object localObject = (AdListView)this.mUIAction.getSnsListView();
    ((AdListView)localObject).AeG = this.Asq;
    ((AdListView)localObject).setTimelineStat(this.ABJ);
    ((AdListView)localObject).setTimelineEvent(this.ABK);
    this.ABK.a(ah.dXv());
    ae.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.Ags, new Object[] { Integer.valueOf(i) });
    this.ABy = ((QFadeImageView)findViewById(2131305048));
    this.ABy.setImageResource(2131690250);
    this.ABD = new a(this.mUIAction.getSnsListView());
    this.ABD.setInterpolator(new LinearInterpolator());
    this.ABD.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(219979);
        ae.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
        AppMethodBeat.o(219979);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(219978);
        ae.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
        AppMethodBeat.o(219978);
      }
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(219977);
        ae.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
        AppMethodBeat.o(219977);
      }
    });
    localObject = null;
    if (this.ACH == 1)
    {
      this.ABA = true;
      localObject = new com.tencent.mm.plugin.sns.ui.a.b.d(this.lJm, this.Aiv);
    }
    this.ABv = new com.tencent.mm.plugin.sns.ui.a.c(this, this.mUIAction.getSnsListView(), this.ABB.Agz, this.ABB, this.ABL, (com.tencent.mm.plugin.sns.ui.a.b.b)localObject, this.ACe);
    this.ABB.Agz.AQz = new bh.b()
    {
      public final boolean egw()
      {
        AppMethodBeat.i(219980);
        SnsTimeLineUI.this.akP().bk(c.b.class);
        AppMethodBeat.o(219980);
        return false;
      }
    };
    this.ABB.zGX = this.ABv.AIq;
    this.ABv.AIr.LDr = new com.tencent.mm.vending.a.b.a()
    {
      public final void egN()
      {
        AppMethodBeat.i(219981);
        com.tencent.mm.plugin.report.service.f.OP(14);
        AppMethodBeat.o(219981);
      }
      
      public final void egO()
      {
        AppMethodBeat.i(219982);
        com.tencent.mm.plugin.report.service.f.OQ(14);
        AppMethodBeat.o(219982);
      }
    };
    this.ABE = ((TestTimeForSns)this.ABB.zGt);
    this.ABE.setListener(new TestTimeForSns.a()
    {
      public final void cYF()
      {
        AppMethodBeat.i(219983);
        ae.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
        SnsTimeLineUI.H(SnsTimeLineUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176335);
            if ((SnsTimeLineUI.a(SnsTimeLineUI.this) == null) || (SnsTimeLineUI.H(SnsTimeLineUI.this) == null))
            {
              ae.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
              AppMethodBeat.o(176335);
              return;
            }
            SnsTimeLineUI.H(SnsTimeLineUI.this).setListener(null);
            SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.N(SnsTimeLineUI.this));
            if (SnsTimeLineUI.O(SnsTimeLineUI.this))
            {
              ae.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
              AppMethodBeat.o(176335);
              return;
            }
            if (SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              ah.dXu().V(ah.dXM().zCw, -1);
              ah.dXu().Ap(ah.dXM().zCx);
            }
            if (!SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              ae.i("MicroMsg.SnsTimeLineUI", "onViewDrawed doFpList");
              com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
              SnsTimeLineUI.n(SnsTimeLineUI.this);
              localc.d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IZC, Integer.valueOf(1));
            }
            SnsTimeLineUI.a(SnsTimeLineUI.this, false);
            if (SnsTimeLineUI.this.Asq != null) {
              SnsTimeLineUI.this.Asq.rq(false);
            }
            AppMethodBeat.o(176335);
          }
        });
        AppMethodBeat.o(219983);
      }
    });
    this.mUIAction.list.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(219984);
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          SnsTimeLineUI.this.edt();
          if ((SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) && (SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() == 0)) {
            ae.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
          }
          SnsTimeLineUI.l(SnsTimeLineUI.this).egS();
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          }
          SnsTimeLineUI.k(SnsTimeLineUI.this).edb();
          SnsTimeLineUI.k(SnsTimeLineUI.this).Ago.ehx();
        }
        AppMethodBeat.o(219984);
        return false;
      }
    });
    this.mUIAction.list.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176343);
        if (SnsTimeLineUI.k(SnsTimeLineUI.this) == null)
        {
          AppMethodBeat.o(176343);
          return;
        }
        SnsTimeLineUI.k(SnsTimeLineUI.this).Ago.ArY = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getBottom();
        SnsTimeLineUI.k(SnsTimeLineUI.this).Ago.AHL = SnsTimeLineUI.d(SnsTimeLineUI.this).vUa.getTop();
        SnsTimeLineUI.l(SnsTimeLineUI.this).ADs = com.tencent.mm.ui.aq.fromDPToPix(SnsTimeLineUI.this.getContext(), -44);
        AppMethodBeat.o(176343);
      }
    });
    this.mUIAction.vUa.setOnSrcollDistance(new MMPullDownView.f()
    {
      public final void bE(float paramAnonymousFloat)
      {
        AppMethodBeat.i(219985);
        SnsTimeLineUI.P(SnsTimeLineUI.this);
        if (SnsTimeLineUI.ACw.booleanValue()) {
          ae.i("MicroMsg.SnsTimeLineUI", "mUIAction.header.getTop %s originalHeaderTop %s distanceY %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).zIf.getTop()), Integer.valueOf(SnsTimeLineUI.l(SnsTimeLineUI.this).ADs), Float.valueOf(paramAnonymousFloat) });
        }
        if (((SnsTimeLineUI.d(SnsTimeLineUI.this).zIf.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).ADs) || (paramAnonymousFloat > 0.0F)) && (!SnsTimeLineUI.d(SnsTimeLineUI.this).AmY)) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).bF(paramAnonymousFloat);
        }
        SnsTimeLineUI.k(SnsTimeLineUI.this).edb();
        SnsTimeLineUI.this.edt();
        SnsTimeLineUI.k(SnsTimeLineUI.this).Ago.ehx();
        AppMethodBeat.o(219985);
      }
      
      public final void egP()
      {
        AppMethodBeat.i(219986);
        if (!SnsTimeLineUI.d(SnsTimeLineUI.this).AmY) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).egS();
        }
        AppMethodBeat.o(219986);
      }
    });
    this.ABB.Agn = ((SnsCommentFooter)findViewById(2131298521));
    this.ABB.Agn.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99338);
        com.tencent.mm.compatible.util.i.v(SnsTimeLineUI.this);
        AppMethodBeat.o(99338);
      }
    });
    this.ABB.Ago = new bq(this.mUIAction.list, this.ABB.Agn);
    this.ABw = ((LinearLayout)this.mUIAction.zIf.findViewById(2131305028));
    this.ABw.findViewById(2131305024).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179269);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).Agj != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).Agj.zCa.rw(true);
        }
        paramAnonymousView = (c.b)SnsTimeLineUI.this.akP().w(c.b.class);
        localObject = com.tencent.mm.modelsns.e.pY(725);
        ((com.tencent.mm.modelsns.e)localObject).qb(paramAnonymousView.tQv);
        ((com.tencent.mm.modelsns.e)localObject).aLH();
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
        paramAnonymousView.putExtra("sns_msg_comment_list_scene", 1);
        SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 13);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179269);
      }
    });
    this.ABx = ((LinearLayout)this.mUIAction.zIf.findViewById(2131305029));
    this.ABB.Agp = new ay(this);
    egz();
    dOM();
    boolean bool1;
    label591:
    boolean bool2;
    if (this.ACH == 0)
    {
      setMMTitle(2131764037);
      if ((!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.j.DEBUG)) {
        break label923;
      }
      bool1 = true;
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qMH, 0)) {
        break label928;
      }
      bool2 = true;
      label615:
      ae.i("MicroMsg.SnsTimeLineUI", "getGpuMaxTextureSize %s %s.", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1)
      {
        bool1 = bool3;
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      com.tencent.mm.sdk.platformtools.r.wN(bool1);
      if (bool1)
      {
        i = com.tencent.mm.sdk.platformtools.r.fnZ();
        if (i > 2048) {
          break label933;
        }
        com.tencent.mm.plugin.report.service.g.yxI.dD(1198, 7);
      }
    }
    for (;;)
    {
      this.ABT = ((ViewGroup)findViewById(2131305092));
      this.ABT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(219987);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$55", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          SnsTimeLineUI.k(SnsTimeLineUI.this).edg();
          com.tencent.mm.plugin.sns.j.e.zKO.zLw.eqr = 2L;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$55", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219987);
        }
      });
      this.ABT.setVisibility(4);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = (com.tencent.mm.ui.aq.fromDPToPix(getContext(), 24) + com.tencent.mm.ui.ar.dX(getContext()) + com.tencent.mm.ui.ar.jN(getContext()));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.ABT.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(99388);
      return;
      if (this.Aiv)
      {
        setMMTitle(2131763939);
        RV(8);
        break;
      }
      ae.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, userName:%s, title:%s", new Object[] { this.lJm, this.mUIAction.title });
      localObject = ah.dXs().BH(this.lJm);
      if (localObject != null) {
        ae.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is not null");
      }
      for (localObject = ((com.tencent.mm.contact.c)localObject).adG();; localObject = this.mUIAction.title)
      {
        setMMTitle(com.tencent.mm.plugin.sns.data.r.N((CharSequence)localObject));
        break;
        ae.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is null, title:%s", new Object[] { this.mUIAction.title });
      }
      label923:
      bool1 = false;
      break label591;
      label928:
      bool2 = false;
      break label615;
      label933:
      if (i <= 4096) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1198, 8);
      } else if (i <= 6144) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1198, 9);
      } else if (i <= 8192) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1198, 10);
      } else {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1198, 11);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99402);
    ae.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 15)
    {
      if ((this.ABB != null) && (this.ABB.Agz != null) && (this.ABB.Agz.APL != null))
      {
        this.ABB.Agz.APL.onActivityResult(paramInt1, paramInt2, paramIntent);
        com.tencent.mm.sdk.platformtools.ar.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219998);
            SnsTimeLineUI.this.hideVKB();
            AppMethodBeat.o(219998);
          }
        }, 300L);
      }
      AppMethodBeat.o(99402);
      return;
    }
    if (paramInt1 == 16)
    {
      ae.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
      AppMethodBeat.o(99402);
      return;
    }
    if ((paramInt1 == 2333) && (paramIntent != null))
    {
      Object localObject = paramIntent.getStringExtra("Select_Contact");
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split(",");
        if (localObject.length > 0)
        {
          this.ABB.Agn.fNT.showVKB();
          String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(localObject[0]);
          if (!bu.isNullOrNil(str))
          {
            this.ABB.Agn.efz();
            this.ABB.Agn.setText("@" + str + " ");
            this.ABB.Agn.setCommentAtPrefix("@" + str + " ");
            this.ABB.Agn.setCommentInfo(new dgh());
            this.ABB.Agn.getCommentInfo().Username = localObject[0];
            this.ABB.Agn.setCommentFlag(8);
          }
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mUIAction.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 11)
    {
      this.ABu.d(this.lJm, this.ABM, this.Aiv, this.ABN);
      AppMethodBeat.o(99402);
      return;
    }
    AppMethodBeat.o(99402);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(99401);
    finish();
    AppMethodBeat.o(99401);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99382);
    super.onConfigurationChanged(paramConfiguration);
    ae.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
    com.tencent.mm.sdk.b.a.IvT.l(new ci());
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    Point localPoint = new Point();
    localPoint.x = paramConfiguration.widthPixels;
    localPoint.y = paramConfiguration.heightPixels;
    ah.j(localPoint);
    com.tencent.mm.plugin.sns.ui.widget.f.eiL().AUz = 0;
    com.tencent.mm.plugin.sns.ui.widget.d.eiI().AUz = 0;
    com.tencent.mm.kiss.widget.textview.c.gHq.akT();
    this.ABv.AIq.egm();
    this.ABv.AIr.resolvedClear();
    AppMethodBeat.o(99382);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99379);
    Object localObject1;
    if (ABP == null)
    {
      ABP = Boolean.valueOf(com.tencent.mm.ui.al.isDarkMode());
      com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
      com.tencent.mm.plugin.sns.model.b.a.dYP();
      localObject1 = ah.dXC();
      ((com.tencent.mm.plugin.sns.model.ax)localObject1).ivT = true;
      ae.i("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.sns.model.ax)localObject1).ivT) });
      if (((((com.tencent.mm.plugin.sns.model.ax)localObject1).ivT) && (!com.tencent.mm.plugin.sns.model.b.a.dYQ())) || (((com.tencent.mm.plugin.sns.model.ax)localObject1).ivS)) {
        ((com.tencent.mm.plugin.sns.model.ax)localObject1).dYz();
      }
      com.tencent.mm.modelvideo.o.aNj().eZ(((com.tencent.mm.plugin.sns.model.ax)localObject1).ivT);
      localObject1 = ah.dXN();
      if (!com.tencent.mm.sdk.platformtools.j.DEBUG) {
        break label1062;
      }
      ((com.tencent.mm.plugin.sns.model.au)localObject1).zDj = true;
      ((com.tencent.mm.plugin.sns.model.au)localObject1).zDk = 1L;
      ((com.tencent.mm.plugin.sns.model.au)localObject1).zDl = 86400L;
      ((com.tencent.mm.plugin.sns.model.au)localObject1).zDm = 1;
      ((com.tencent.mm.plugin.sns.model.au)localObject1).zDn = 1;
      ((com.tencent.mm.plugin.sns.model.au)localObject1).zDo = 50;
      ((com.tencent.mm.plugin.sns.model.au)localObject1).zDq = 2;
      ((com.tencent.mm.plugin.sns.model.au)localObject1).zDp = 5;
      ((com.tencent.mm.plugin.sns.model.au)localObject1).zDr = 0L;
      label168:
      ae.i("MicroMsg.SnsUnreadTipManager", "jumpEnable:%s, jumpMinInterval:%s, jumpMaxInterval:%s, jumpMinFeedsCount:%s, jumpMinFeedsGapCount:%s, jumpNotWsPercent:%s, jumpIndicatorIndexOffset:%s, jumpReadContinuousCount:%s, jumpIndicatorExposeInterval:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDj), Long.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDk), Long.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDl), Integer.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDm), Integer.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDn), Integer.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDo), Integer.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDq), Integer.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDp), Long.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDr) });
      if (((com.tencent.mm.plugin.sns.model.au)localObject1).zDj) {
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDi = (ah.getAccSnsPath() + "snsUnread.proto");
      }
    }
    int i;
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.mm.vfs.o.bb(((com.tencent.mm.plugin.sns.model.au)localObject1).zDi, 0, -1);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          ((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.parseFrom((byte[])localObject2);
          i = ch.aDd();
          ae.i("MicroMsg.SnsUnreadTipManager", "unreadSnsIdList.indicatorExposeTime:%s, now:%s, jumpIndicatorExposeInterval:%s", new Object[] { Long.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.zDJ), Integer.valueOf(i), Long.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDr) });
          if ((((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.zDJ <= 0L) || (i - ((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.zDJ <= ((com.tencent.mm.plugin.sns.model.au)localObject1).zDr)) {
            continue;
          }
          ((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.zDJ = 0L;
          ((com.tencent.mm.plugin.sns.model.au)localObject1).zDJ = ((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.zDJ;
          ((com.tencent.mm.plugin.sns.model.au)localObject1).dYs();
        }
      }
      catch (IOException localIOException)
      {
        Object localObject2;
        label1062:
        ae.w("MicroMsg.SnsUnreadTipManager", "IOException:%s", new Object[] { localIOException.getMessage() });
        continue;
        bool = false;
        continue;
        com.tencent.mm.plugin.sns.model.ar.zCP = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIH, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIG, 1) != 1) {
          continue;
        }
        bool = true;
        com.tencent.mm.plugin.sns.model.ar.zCQ = bool;
        com.tencent.mm.plugin.sns.model.ar.zCR = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qII, 60);
        continue;
        bool = false;
        continue;
        long l = com.tencent.mm.plugin.sns.model.ar.zCP - bu.DD(((com.tencent.mm.plugin.sns.model.ar)localObject1).zCS);
        ae.i(com.tencent.mm.plugin.sns.model.ar.TAG, "delay %s to reset", new Object[] { Long.valueOf(l) });
        com.tencent.mm.sdk.platformtools.ar.o(((com.tencent.mm.plugin.sns.model.ar)localObject1).zCW, l);
        continue;
        this.xgg = findViewById(2131296345);
        if (this.xgg == null) {
          break label1532;
        }
      }
      ((com.tencent.mm.plugin.sns.model.au)localObject1).dYq();
      ((com.tencent.mm.plugin.sns.model.au)localObject1).dYr();
      ae.i("MicroMsg.SnsUnreadTipManager", "firstUnreadId:%s unreadSnsIdList.lastSnsId:%s", new Object[] { Long.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDw), Long.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.zHY) });
      ((com.tencent.mm.plugin.sns.model.au)localObject1).dYt();
      ((com.tencent.mm.plugin.sns.model.au)localObject1).sessionId = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.c.class)).cot();
      localObject1 = ((com.tencent.mm.plugin.sns.model.au)localObject1).zDP;
      com.tencent.mm.kernel.g.ajQ().gDv.a(211, (com.tencent.mm.ak.f)localObject1);
      localObject1 = ah.dXO();
      ae.i(com.tencent.mm.plugin.sns.model.ar.TAG, "create");
      if ((com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE))
      {
        com.tencent.mm.plugin.sns.model.ar.zCP = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIH, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIG, 1) == 1)
        {
          bool = true;
          com.tencent.mm.plugin.sns.model.ar.zCQ = bool;
          com.tencent.mm.plugin.sns.model.ar.zCR = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qII, 60);
          ae.i(com.tencent.mm.plugin.sns.model.ar.TAG, "updateConfig configEnable:%s, configInterval:%s, configExpiredTime:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.sns.model.ar.zCQ), Integer.valueOf(com.tencent.mm.plugin.sns.model.ar.zCR), Long.valueOf(com.tencent.mm.plugin.sns.model.ar.zCP) });
          if (((com.tencent.mm.plugin.sns.model.ar)localObject1).zCS != 0L)
          {
            if (bu.DD(((com.tencent.mm.plugin.sns.model.ar)localObject1).zCS) < com.tencent.mm.plugin.sns.model.ar.zCP) {
              continue;
            }
            ae.i(com.tencent.mm.plugin.sns.model.ar.TAG, "already expired, reset directly");
            com.tencent.mm.sdk.platformtools.ar.f(((com.tencent.mm.plugin.sns.model.ar)localObject1).zCW);
            if (((com.tencent.mm.plugin.sns.model.ar)localObject1).zCU != null)
            {
              localObject2 = com.tencent.mm.plugin.sns.model.al.v(((com.tencent.mm.plugin.sns.model.ar)localObject1).zCU);
              if (localObject2 != null)
              {
                com.tencent.mm.plugin.sns.j.e.zKO.zLx.pE(((com.tencent.mm.plugin.sns.model.ar)localObject1).zCV);
                com.tencent.mm.plugin.sns.j.e.zKO.zLx.pD(com.tencent.mm.plugin.sns.data.r.zW(((com.tencent.mm.plugin.sns.model.ar)localObject1).zCU.field_snsId));
                com.tencent.mm.plugin.sns.j.e.zKO.zLx.eqv = ((SnsObject)localObject2).LikeCount;
                com.tencent.mm.plugin.sns.j.e.zKO.zLx.eqw = ((SnsObject)localObject2).CommentCount;
                com.tencent.mm.plugin.sns.j.e.zKO.zLx.pF(String.valueOf(System.currentTimeMillis()));
                com.tencent.mm.plugin.sns.j.e.zKO.zLy.pE(((com.tencent.mm.plugin.sns.model.ar)localObject1).zCV);
                com.tencent.mm.plugin.sns.j.e.zKO.zLy.pD(com.tencent.mm.plugin.sns.data.r.zW(((com.tencent.mm.plugin.sns.model.ar)localObject1).zCU.field_snsId));
                com.tencent.mm.plugin.sns.j.e.zKO.zLy.eqv = ((SnsObject)localObject2).LikeCount;
                com.tencent.mm.plugin.sns.j.e.zKO.zLy.eqw = ((SnsObject)localObject2).CommentCount;
                com.tencent.mm.plugin.sns.j.e.zKO.zLy.pF(String.valueOf(System.currentTimeMillis()));
              }
            }
          }
          if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class) != null) {
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).XA("__sns_timeline__");
          }
          if (this.mController != null) {
            this.mController.bk(2, true);
          }
          getIntent().setExtrasClassLoader(getClass().getClassLoader());
          com.tencent.mm.pluginsdk.h.q(this);
          customfixStatusbar(true);
          super.onCreate(paramBundle);
          if (com.tencent.mm.kernel.g.ajP().aiZ()) {
            continue;
          }
          finish();
          AppMethodBeat.o(99379);
          return;
          if (ABP.booleanValue() == com.tencent.mm.ui.al.isDarkMode()) {
            break;
          }
          ae.i("MicroMsg.SnsTimeLineUI", "dancy test UIMode change!!");
          ABP = Boolean.valueOf(com.tencent.mm.ui.al.isDarkMode());
          com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
          break;
          if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE))
          {
            bool = true;
            ((com.tencent.mm.plugin.sns.model.au)localObject1).zDj = bool;
            ((com.tencent.mm.plugin.sns.model.au)localObject1).zDk = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOe, 3600);
            ((com.tencent.mm.plugin.sns.model.au)localObject1).zDm = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOf, 5);
            ((com.tencent.mm.plugin.sns.model.au)localObject1).zDn = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOh, 10);
            ((com.tencent.mm.plugin.sns.model.au)localObject1).zDl = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOi, 86400L);
            ((com.tencent.mm.plugin.sns.model.au)localObject1).zDo = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOj, 0);
            ((com.tencent.mm.plugin.sns.model.au)localObject1).zDq = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOl, 1);
            ((com.tencent.mm.plugin.sns.model.au)localObject1).zDp = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOk, 2);
            ((com.tencent.mm.plugin.sns.model.au)localObject1).zDr = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOm, 14400);
            break label168;
          }
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOg, 1) == 1)
          {
            bool = true;
            continue;
          }
          bool = false;
          continue;
          if (((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.zDJ >= 0L) {
            continue;
          }
          ((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.zDJ = 0L;
          continue;
        }
      }
      if (com.tencent.mm.ui.statusbar.c.KZw) {
        break label3903;
      }
    }
    label1532:
    getWindow().getDecorView().setSystemUiVisibility(1280);
    paramBundle = ak.fox();
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("Main_need_read_top_margin", false);; bool = false) {
      for (;;)
      {
        com.tencent.mm.ui.b.c(this, bool);
        this.ABC = ((int)(getResources().getDisplayMetrics().heightPixels * 0.4D));
        setActionbarColor(getContext().getResources().getColor(2131101053));
        hideActionbarLine();
        this.ACH = getIntent().getIntExtra("sns_adapter_type", 0);
        this.ABA = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
        this.mActionBar = getSupportActionBar();
        i = com.tencent.mm.model.c.d.aDJ().gv("Sns_Private_Recent_Setting_Guide", 0);
        ae.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = ".concat(String.valueOf(i)));
        if (i == 1)
        {
          com.tencent.mm.kernel.g.ajS();
          if (!com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.ISs, false))
          {
            paramBundle = getIntent();
            paramBundle.setClass(getContext(), SnsSettingIntroduceUI.class);
            paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahE(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramBundle.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            overridePendingTransition(0, 0);
            finish();
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ISs, Boolean.TRUE);
          }
        }
        this.ABS.Axs = new bc.b()
        {
          public final void efX()
          {
            AppMethodBeat.i(219969);
            SnsTimeLineUI.I(SnsTimeLineUI.this);
            AppMethodBeat.o(219969);
          }
        };
        egy();
        com.tencent.e.h.MqF.aO(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219970);
            ae.i("MicroMsg.SnsTimeLineUI", "%s", new Object[] { com.tencent.mm.plugin.performance.c.c.dCq().P(true, 0) });
            AppMethodBeat.o(219970);
          }
        });
        this.ABt.a(c.b.class, this.ACF);
        localObject1 = this.ABu;
        i = this.ACH;
        paramBundle = getIntent();
        com.tencent.mm.plugin.sns.l.b localb = this.ABs;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ACH = i;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = true;
        Object localObject3;
        if (i == 0)
        {
          localObject3 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIN;
          ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject3).ABs = localb;
          if (localb != null)
          {
            paramBundle = localb.eiO();
            label1933:
            ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject3).ABt = paramBundle;
            ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIN.ABt.a(this);
            label1951:
            paramBundle = this.ABu;
            if (paramBundle.ACH != 0) {
              break label4123;
            }
            paramBundle = (com.tencent.mm.plugin.sns.l.c.a)paramBundle.AIN.ABt.w(com.tencent.mm.plugin.sns.l.c.a.class);
            label1980:
            this.lJm = paramBundle.lJm;
            this.ABL = paramBundle.ABL;
            this.ABM = paramBundle.ABM;
            this.Aiv = paramBundle.Aiv;
            this.ABN = paramBundle.ABN;
            localObject1 = paramBundle.jtJ;
            paramBundle = paramBundle.cff;
            this.mSessionId = com.tencent.mm.ui.e.aju("123");
            this.ABO = String.valueOf(System.currentTimeMillis());
            this.mUIAction = new SnsUIAction(this);
            this.mUIAction.setSessionId(this.mSessionId);
            this.mUIAction.zJR = this.ABO;
            this.mUIAction.AFe = this.ACD;
            this.mUIAction.actionbarView = this.mActionBar.getCustomView();
            ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().kQ(2);
            com.tencent.mm.plugin.sns.ui.widget.f.eiL().AUz = 0;
            com.tencent.mm.plugin.sns.ui.widget.d.eiI().AUz = 0;
            localObject3 = com.tencent.mm.modelsns.f.iql;
            com.tencent.mm.modelsns.f.aLI();
            if (!getIntent().getBooleanExtra("is_sns_notify_open", true)) {
              break label4131;
            }
            i = 1;
            label2168:
            this.ABB = new i(this, i, bu.bI(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0), this.ABO);
            this.ABB.Agm = new i.b()
            {
              public final void edg()
              {
                AppMethodBeat.i(219971);
                com.tencent.mm.plugin.report.service.g.yxI.dD(1295, 2);
                Object localObject = ah.dXN();
                if (((com.tencent.mm.plugin.sns.model.au)localObject).zDj) {
                  ah.dJc().post(new au.4((com.tencent.mm.plugin.sns.model.au)localObject));
                }
                com.tencent.mm.plugin.sns.j.e.zKO.zLw.eqq = 1L;
                localObject = ah.dXN();
                int i;
                if ((!((com.tencent.mm.plugin.sns.model.au)localObject).dYp()) || (((com.tencent.mm.plugin.sns.model.au)localObject).zDu.get(((com.tencent.mm.plugin.sns.model.au)localObject).zDG.rBG.peek()) == null))
                {
                  i = -1;
                  localObject = ah.dXN();
                  if (((com.tencent.mm.plugin.sns.model.au)localObject).dYp()) {
                    break label390;
                  }
                }
                com.tencent.mm.hellhoundlib.b.a locala;
                label390:
                for (int j = 0;; j = ((com.tencent.mm.plugin.sns.model.au)localObject).zDG.rBG.size())
                {
                  ae.d("MicroMsg.SnsTimeLineUI", "rightIndex:%s, targetSize:%s, adapter.count:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) });
                  ah.dXN().eU(null);
                  SnsTimeLineUI.J(SnsTimeLineUI.this).setVisibility(4);
                  if ((i == -1) || (j + i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount())) {
                    break label405;
                  }
                  ah.dXN().dYx();
                  ah.dXN().zDA = 0L;
                  j = SnsTimeLineUI.this.getResources().getDimensionPixelSize(2131166841);
                  int k = com.tencent.mm.ui.ar.dX(SnsTimeLineUI.this.getContext());
                  int m = com.tencent.mm.ui.ar.jN(SnsTimeLineUI.this.getContext());
                  localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                  locala = com.tencent.mm.hellhoundlib.b.c.a(i + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), com.tencent.mm.hellhoundlib.b.c.a(k + m - j, new com.tencent.mm.hellhoundlib.b.a()));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                  ((ListView)localObject).smoothScrollToPositionFromTop(((Integer)locala.mt(0)).intValue(), ((Integer)locala.mt(1)).intValue());
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                  AppMethodBeat.o(219971);
                  return;
                  i = ((Integer)((com.tencent.mm.plugin.sns.model.au)localObject).zDu.get(((com.tencent.mm.plugin.sns.model.au)localObject).zDG.rBG.peek())).intValue();
                  break;
                }
                label405:
                if (!ah.dXN().zDD)
                {
                  ah.dXN().dYx();
                  ah.dXN().zDD = true;
                  SnsTimeLineUI.a(SnsTimeLineUI.this).AIr.aCn(com.tencent.mm.plugin.sns.data.r.zW(SnsTimeLineUI.a(SnsTimeLineUI.this).ehA()));
                  SnsTimeLineUI.a(SnsTimeLineUI.this).AIr.aCo(com.tencent.mm.plugin.sns.data.r.zW(SnsTimeLineUI.a(SnsTimeLineUI.this).sg(false)));
                  ah.dXN().zDA = ah.dXN().dYv();
                  ah.dXu().Ap(ah.dXN().dYv());
                  ah.dXN().zDB = av.zEa;
                  localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                  locala = com.tencent.mm.hellhoundlib.b.c.a(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount() - 1 + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), new com.tencent.mm.hellhoundlib.b.a());
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                  ((ListView)localObject).smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                  if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
                  {
                    SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
                    SnsTimeLineUI.B(SnsTimeLineUI.this).post(SnsTimeLineUI.C(SnsTimeLineUI.this));
                  }
                }
                AppMethodBeat.o(219971);
              }
            };
            this.Ags = getIntent().getBooleanExtra("sns_resume_state", true);
            if (!ah.dXn()) {
              break label4136;
            }
            this.Ags = false;
            label2253:
            this.ABz = this.Ags;
            this.mUIAction.a(this.ABL, this.lJm, (String)localObject1, paramBundle, this.ABM, this.Aiv, this.ABN);
            this.mUIAction.onCreate();
            ah.dXv().init();
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(213, this);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(682, this);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(218, this);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(211, this);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(683, this);
            com.tencent.mm.plugin.sns.ui.video.d.eir().eis();
            initView();
            paramBundle = ah.dXv();
            localObject1 = this.mUIAction.list;
            localObject3 = this.ABv.AIq;
            paramBundle.zGW = ((ListView)localObject1);
            paramBundle.zGX = ((bh)localObject3);
            paramBundle = ah.dXv();
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(291, paramBundle);
            this.ABB.rJr = ((ClipboardManager)ak.getContext().getSystemService("clipboard"));
            if (!ah.dXn()) {
              break label4156;
            }
            this.Ags = false;
            label2484:
            paramBundle = this.ABt;
            paramBundle.AIr = this.ABv.AIr;
            localObject1 = paramBundle.AIr;
            paramBundle.LDs.keep((com.tencent.mm.vending.e.a)localObject1);
            if ((!this.Ags) || (this.ACH != 0)) {
              break label4176;
            }
            this.ABA = false;
            int j = ah.dXM().position;
            this.ABv.AIr.aCp(ah.dXM().rmb);
            this.ABv.AIr.aCm(ah.dXM().AmT);
            this.ABv.AIr.sh(true);
            this.ABv.AIr.aCq(ah.dXM().AmW);
            this.ABv.AIr.aCn(ah.dXM().AmU);
            this.ABv.AIr.aCo(ah.dXM().AmV);
            this.mUIAction.sd(ah.dXM().AmY);
            this.ABv.vw();
            i = j;
            if (j >= this.ABv.getCount())
            {
              i = this.ABv.getCount() - 1;
              ae.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[] { Integer.valueOf(this.ABv.getCount()) });
            }
            this.mUIAction.list.setAdapter(this.ABv);
            ae.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[] { Integer.valueOf(ah.dXM().AmX) });
            this.mUIAction.list.setSelectionFromTop(i, ah.dXM().AmX);
            RV(4);
            label2762:
            egx();
            i = this.ABv.getCount();
            j = this.mUIAction.list.getFirstVisiblePosition();
            if (j < i) {
              this.ABH = com.tencent.mm.plugin.sns.data.r.o(this.ABv.RA(j));
            }
            com.tencent.mm.kernel.g.ajS();
            this.ABF = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(327776, Integer.valueOf(0))).intValue();
            this.ABB.Agu = new bp(this, this.ABv.AIq, this.ABB.zGt);
            this.ABB.Agw = new com.tencent.mm.plugin.sns.h.b(this, this.ABv.AIq.zGs, this.ABB.zGt);
            this.ABB.Agv = new b(this, this.ABv.AIq.zGs, this.ABB.zGt, this.ABB.Agw);
            this.ABB.Agv.zrZ = this.Asq;
            this.ABB.Agx = new am(this, this.ABv.AIq.zGs, this.ABB.zGt);
            this.ABB.Agy = new br(this, this.ABv.AIq.zGs, this.ABB.zGt);
            if (this.ABK != null) {
              this.ABK.a(this.ABB.Agw);
            }
            if (i > 0)
            {
              paramBundle = this.ABv.RA(0);
              if ((this.ABB.Agj != null) && (this.ABB.Agj.zCa != null)) {
                this.ABB.Agj.zCa.zIB = paramBundle.field_snsId;
              }
              paramBundle = com.tencent.mm.plugin.sns.j.e.zKO;
              if (paramBundle.gzC != 0)
              {
                if (paramBundle.zKP.isEmpty())
                {
                  paramBundle.fHF.setLong(2, bu.aRi());
                  paramBundle.zKQ.clear();
                }
                ae.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[] { Integer.valueOf(paramBundle.zKP.size()) });
              }
            }
            com.tencent.mm.plugin.report.service.g.yxI.kvStat(13312, "1," + bu.fpO());
            com.tencent.mm.sdk.b.a.IvT.c(this.ACc);
            if (getIntent().getBooleanExtra("is_need_resend_sns", false))
            {
              com.tencent.mm.sdk.platformtools.ar.o(new SnsTimeLineUI.33(this), 500L);
              getIntent().putExtra("is_need_resend_sns", false);
            }
            com.tencent.mm.kernel.g.ajS();
            if (com.tencent.mm.kernel.g.ajP().aiZ())
            {
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajR().ajA().set(589825, Boolean.FALSE);
            }
            paramBundle = this.ABB;
            localObject1 = this.Asq;
            paramBundle.Agi = ((com.tencent.mm.plugin.sns.ad.e.j)localObject1);
            if (paramBundle.Agz != null) {
              paramBundle.Agz.b((com.tencent.mm.plugin.sns.ad.e.j)localObject1);
            }
            this.Asq.a(this.mUIAction.zop, this.mActionBar.getCustomView(), this);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACi);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACj);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACk);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACl);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACm);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACo);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACn);
            com.tencent.mm.sdk.b.a.IvT.c(this.zCJ);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACp);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACq);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACs);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACr);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACt);
            com.tencent.mm.sdk.b.a.IvT.c(this.ACv);
            com.tencent.mm.plugin.sns.abtest.c.dUz();
            com.tencent.mm.plugin.sns.abtest.a.d(this, this.ABB.zGt);
            if (this.ABI != null)
            {
              paramBundle = this.ABI;
              localObject1 = this.mUIAction.list;
              localObject3 = this.mUIAction.zIf;
              paramBundle.hbO = ((ListView)localObject1);
              paramBundle.zIf = ((SnsHeader)localObject3);
            }
            if ((this.ABB != null) && (this.ABB.Agj != null))
            {
              paramBundle = this.ABB.Agj.zCa;
              ae.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
              paramBundle.zIA = true;
              paramBundle.zKy = System.currentTimeMillis();
            }
            bool = getIntent().getBooleanExtra("enter_by_red", false);
            if ((this.ABB != null) && (this.ABB.Agj != null))
            {
              paramBundle = this.ABB.Agj.zCa;
              if (!bool) {
                break label4205;
              }
              i = 1;
              label3625:
              paramBundle.zIN = i;
            }
            ah.dXB().zwV.clear();
            if ((this.mUIAction != null) && (this.mUIAction.zIf != null)) {
              this.mUIAction.zIf.setStoryAction(new SnsStoryHeaderView.a()
              {
                public final void egM()
                {
                  AppMethodBeat.i(219973);
                  SnsTimeLineUI.a locala = SnsTimeLineUI.l(SnsTimeLineUI.this);
                  if (SnsTimeLineUI.u(locala.ACN).getVisibility() == 0)
                  {
                    locala.init();
                    SnsTimeLineUI.u(locala.ACN).clearAnimation();
                    SnsTimeLineUI.u(locala.ACN).startAnimation(locala);
                    locala.AO(locala.DELAY_TIME + 100);
                    locala.ADr = false;
                  }
                  AppMethodBeat.o(219973);
                }
              });
            }
            if (!bu.isNullOrNil(v.aAK())) {
              break label4210;
            }
            this.ABZ = 0;
            label3688:
            if ((!com.tencent.mm.sdk.platformtools.j.DEBUG) && (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED)) {
              break label4243;
            }
            paramBundle = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qNg, "{\"enable\":1,\"max_count_no_user\":3,\"max_count_no_feed\":3,\"max_count_normal\":-1}");
            if (bu.isNullOrNil(paramBundle)) {}
          }
        }
        try
        {
          paramBundle = new JSONObject(paramBundle);
          this.ABV = paramBundle.getInt("enable");
          this.ABW = paramBundle.getInt("max_count_no_user");
          this.ABX = paramBundle.getInt("max_count_no_feed");
          this.ABY = paramBundle.getInt("max_count_normal");
          if (ac.iSP > 0)
          {
            this.ABV = ac.iSP;
            if (ac.iSP == 1)
            {
              this.ABW = -1;
              this.ABX = -1;
              this.ABY = -1;
            }
          }
          ae.i("MicroMsg.SnsTimeLineUI", "curFinderStatus:%s, finderEntranceEnable:%s, finderEntranceMaxCountNoUser:%s, finderEntranceMaxCountNoFeed:%s, finderEntranceMaxCountNormal:%s", new Object[] { Integer.valueOf(this.ABZ), Integer.valueOf(this.ABV), Integer.valueOf(this.ABW), Integer.valueOf(this.ABX), Integer.valueOf(this.ABY) });
          com.tencent.mm.sdk.b.a.IvT.c(this.ACd);
          AppMethodBeat.o(99379);
          return;
          label3903:
          paramBundle = com.tencent.mm.ui.statusbar.c.bn(this);
          localObject1 = new com.tencent.mm.ui.statusbar.c.a()
          {
            public final void ug(int paramAnonymousInt)
            {
              AppMethodBeat.i(219953);
              SnsTimeLineUI.t(SnsTimeLineUI.this).setPadding(0, paramAnonymousInt, 0, 0);
              AppMethodBeat.o(219953);
            }
          };
          this.spA = ((com.tencent.mm.ui.statusbar.c.a)localObject1);
          paramBundle.a((com.tencent.mm.ui.statusbar.c.a)localObject1);
          getWindow().getDecorView().requestApplyInsets();
          com.tencent.mm.ui.statusbar.d.b(getWindow());
          break;
          paramBundle = null;
          break label1933;
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIO = new com.tencent.mm.plugin.sns.l.c.a();
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIO.lJm = paramBundle.getStringExtra("sns_userName");
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIO.ABL = v.aAC();
          localObject3 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIO;
          com.tencent.mm.kernel.g.ajS();
          ((com.tencent.mm.plugin.sns.l.c.a)localObject3).ABM = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUH(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIO.lJm);
          localObject3 = v.aAC();
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIO.Aiv = ((String)localObject3).equals(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIO.lJm);
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIO.ABN = paramBundle.getIntExtra("sns_source", 0);
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIO.jtJ = bu.bI(paramBundle.getStringExtra("sns_nickName"), "");
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIO.cff = bu.bI(paramBundle.getStringExtra("sns_signature"), "");
          break label1951;
          label4123:
          paramBundle = paramBundle.AIO;
          break label1980;
          label4131:
          i = 0;
          break label2168;
          label4136:
          if (!this.Ags) {
            break label2253;
          }
          this.Ags = ah.dXM().eet();
          break label2253;
          label4156:
          if (!this.Ags) {
            break label2484;
          }
          this.Ags = ah.dXM().eet();
          break label2484;
          label4176:
          this.mUIAction.list.setAdapter(this.ABv);
          RV(0);
          this.ABv.vw();
          break label2762;
          label4205:
          i = 0;
          break label3625;
          label4210:
          if (!((t)com.tencent.mm.kernel.g.ad(t.class)).hasFinderPosted())
          {
            this.ABZ = 1;
            break label3688;
          }
          this.ABZ = 2;
          break label3688;
          label4243:
          paramBundle = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qNg, "");
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            ae.w("MicroMsg.SnsTimeLineUI", "parse SnsFinderEntranceConfig fail. %s", new Object[] { paramBundle.getMessage() });
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99383);
    this.ABG = true;
    Object localObject1 = this.ABS;
    ((bc)localObject1).cTl();
    ((bc)localObject1).Axs = null;
    ((bc)localObject1).yPh = bc.a.Axu;
    com.tencent.mm.plugin.sns.ui.video.d.eir().aJ(this);
    localObject1 = com.tencent.mm.plugin.sns.ui.video.b.eil();
    ae.i("MicroMsg.SightPlayViewManager", "onUIDestroy");
    Object localObject2 = ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).ASp.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((com.tencent.mm.plugin.sns.ui.video.a)((Iterator)localObject2).next()).stop();
    }
    ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).ASp.clear();
    ae.i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
    com.tencent.mm.sdk.b.a.IvT.d(this.ACi);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACj);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACk);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACl);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACm);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACo);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACn);
    com.tencent.mm.sdk.b.a.IvT.d(this.zCJ);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACp);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACq);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACr);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACs);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACt);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACd);
    com.tencent.mm.sdk.b.a.IvT.d(this.ACv);
    com.tencent.mm.plugin.sns.ui.e.a.eij();
    int i;
    long l1;
    Object localObject3;
    Object localObject4;
    int j;
    label464:
    String str2;
    if ((this.ABB != null) && (this.ABB.Agj != null))
    {
      localObject1 = this.ABB.Agj.zCa;
      if (this.ACf)
      {
        i = 1;
        ((com.tencent.mm.plugin.sns.j.b)localObject1).zIO = i;
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.sns.j.e.zKO;
      if (((com.tencent.mm.plugin.sns.j.e)localObject2).gzC == 0) {
        break label792;
      }
      ae.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sns.j.e)localObject2).zKP.size()), Integer.valueOf(((com.tencent.mm.plugin.sns.j.e)localObject2).zKQ.size()) });
      l1 = ((com.tencent.mm.plugin.sns.j.e)localObject2).fHF.getLong(2, 0L);
      if ((((com.tencent.mm.plugin.sns.j.e)localObject2).zKP.isEmpty()) || ((((com.tencent.mm.plugin.sns.j.e)localObject2).zKP.size() <= ((com.tencent.mm.plugin.sns.j.e)localObject2).zKW) && (bu.rZ(l1) <= ((com.tencent.mm.plugin.sns.j.e)localObject2).zKX))) {
        break label1795;
      }
      localObject3 = new StringBuffer();
      localObject4 = ((com.tencent.mm.plugin.sns.j.e)localObject2).zKP.keySet().iterator();
      i = 0;
      j = 0;
      if (!((Iterator)localObject4).hasNext()) {
        break label618;
      }
      str2 = (String)((Iterator)localObject4).next();
      localObject1 = (String)((com.tencent.mm.plugin.sns.j.e)localObject2).zKQ.get(str2);
      if (bu.isNullOrNil((String)localObject1)) {
        break label605;
      }
      j = 1;
      label511:
      if (!((com.tencent.mm.plugin.sns.j.e)localObject2).zKR.contains(str2)) {
        break label613;
      }
    }
    label605:
    label613:
    for (int k = 1;; k = 0)
    {
      ((StringBuffer)localObject3).append(str2 + "#" + ((com.tencent.mm.plugin.sns.j.e)localObject2).zKP.get(str2) + "#" + (String)localObject1 + "#" + k + "|");
      i += 1;
      break label464;
      i = 0;
      break;
      localObject1 = "";
      break label511;
    }
    label618:
    ((StringBuffer)localObject3).append("," + l1 + "," + bu.aRi() + ",1," + j + "," + i + ",1");
    ae.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", new Object[] { Integer.valueOf(13226), localObject3 });
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(13226, ((StringBuffer)localObject3).toString());
    ((com.tencent.mm.plugin.sns.j.e)localObject2).fHF.set(3, null);
    ((com.tencent.mm.plugin.sns.j.e)localObject2).fHF.set(4, null);
    ((com.tencent.mm.plugin.sns.j.e)localObject2).fHF.set(5, null);
    ((com.tencent.mm.plugin.sns.j.e)localObject2).zKP.clear();
    ((com.tencent.mm.plugin.sns.j.e)localObject2).zKQ.clear();
    ((com.tencent.mm.plugin.sns.j.e)localObject2).zKR.clear();
    ((com.tencent.mm.plugin.sns.j.e)localObject2).fHF.setLong(2, bu.aRi());
    for (;;)
    {
      ((com.tencent.mm.plugin.sns.j.e)localObject2).dZg();
      label792:
      com.tencent.mm.kernel.g.ajS();
      localObject1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(68377, null);
      if ((this.ABB != null) && (this.ABB.Agj != null))
      {
        localObject2 = this.ABB.Agj.zCa;
        i = com.tencent.mm.plugin.sns.j.e.zKO.zKV;
        ae.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
        l1 = System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.j.b)localObject2).zKy;
        ((com.tencent.mm.plugin.sns.j.b)localObject2).zIC += l1;
        ae.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + l1 + " BrowseTime: " + ((com.tencent.mm.plugin.sns.j.b)localObject2).zIC + "BackgroundTime: " + ((com.tencent.mm.plugin.sns.j.b)localObject2).zJl);
        localObject3 = ah.dXr();
        if (localObject3 != null) {
          ((ExecutorService)localObject3).execute(new b.2((com.tencent.mm.plugin.sns.j.b)localObject2, i));
        }
        ((com.tencent.mm.plugin.sns.j.b)localObject2).zIA = false;
      }
      localObject2 = com.tencent.mm.modelsns.e.pY(704);
      boolean bool;
      if (((com.tencent.mm.modelsns.e)localObject2).aLD())
      {
        ((com.tencent.mm.modelsns.e)localObject2).eV(this.ACf);
        if (!bu.isNullOrNil((String)localObject1))
        {
          bool = true;
          ((com.tencent.mm.modelsns.e)localObject2).eV(bool);
          ((com.tencent.mm.modelsns.e)localObject2).GU(this.ABH);
          ((com.tencent.mm.modelsns.e)localObject2).GU(com.tencent.mm.plugin.sns.j.e.zKO.zKU);
          ((com.tencent.mm.modelsns.e)localObject2).GU(com.tencent.mm.plugin.sns.j.e.zKO.zKU);
          ((com.tencent.mm.modelsns.e)localObject2).qb(this.mUIAction.AFd);
          ((com.tencent.mm.modelsns.e)localObject2).GU("");
          com.tencent.mm.modelsns.e.aLG();
          ((com.tencent.mm.modelsns.e)localObject2).aLH();
        }
      }
      else
      {
        com.tencent.mm.plugin.sns.j.e.zKO.zKV = -1;
        com.tencent.mm.plugin.sns.j.e.zKO.zKU = "0";
        localObject1 = (AdListView)this.mUIAction.getSnsListView();
        this.ABK.zEr.clear();
        ah.dXv().clean();
        localObject2 = ah.dXy();
        ah.dXr().execute(new l.5((com.tencent.mm.plugin.sns.ad.e.l)localObject2));
        ((AdListView)localObject1).AeG.clear();
        ((AdListView)localObject1).AeG = null;
        ((AdListView)localObject1).AeH.bxS();
        ((AdListView)localObject1).AeH = null;
        u.dWY();
        if (!ah.dXn()) {
          this.ACB.removeCallbacks(this.ACb);
        }
        com.tencent.mm.kernel.g.ajS();
        if (com.tencent.mm.kernel.g.ajP().aiZ())
        {
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.b(213, this);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.b(682, this);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.b(218, this);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.b(211, this);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.b(683, this);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(327776, Integer.valueOf(this.ABF));
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(589825, Boolean.FALSE);
        }
        if (this.ABB != null)
        {
          localObject1 = this.ABB;
          ((i)localObject1).Agz.removeListener();
          if (((i)localObject1).Agn != null) {
            ((i)localObject1).Agn.efC();
          }
          com.tencent.mm.sdk.b.a.IvT.d(((i)localObject1).AgB);
          com.tencent.mm.sdk.b.a.IvT.d(((i)localObject1).AgC);
        }
        ah.cXK().removeCallbacks(this.ACC);
        localObject1 = ah.dXN();
        if (((com.tencent.mm.plugin.sns.model.au)localObject1).zDL != null) {
          ((com.tencent.mm.plugin.sns.model.au)localObject1).dYy();
        }
        if (!((com.tencent.mm.plugin.sns.model.au)localObject1).zDj) {}
      }
      try
      {
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.zDJ = ((com.tencent.mm.plugin.sns.model.au)localObject1).zDJ;
        localObject2 = ((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.toByteArray();
        com.tencent.mm.vfs.o.f(((com.tencent.mm.plugin.sns.model.au)localObject1).zDi, (byte[])localObject2, localObject2.length);
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDF.zHX.clear();
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDG = null;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDH = 0L;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDA = 0L;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDu.clear();
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDv = null;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDz = 0L;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDw = 0L;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDC = false;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDL = null;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDM = null;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDB = av.zEc;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDN = 0;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDK = 0L;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDJ = 0L;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDO = 0L;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).zDx.clear();
        localObject1 = ((com.tencent.mm.plugin.sns.model.au)localObject1).zDP;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zDg.clear();
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zDh = null;
        com.tencent.mm.kernel.g.ajQ().gDv.b(211, (com.tencent.mm.ak.f)localObject1);
        localObject1 = ah.dXO();
        ae.i(com.tencent.mm.plugin.sns.model.ar.TAG, "destroy");
        com.tencent.mm.sdk.platformtools.ar.ay(((com.tencent.mm.plugin.sns.model.ar)localObject1).zCW);
        if (this.ABv == null) {
          break label2307;
        }
        m = this.mUIAction.list.getFirstVisiblePosition();
        i = 0;
        j = 0;
        for (;;)
        {
          if (j < this.mUIAction.list.getCount())
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
                ae.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", new Object[] { Integer.valueOf(n), Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
                k = localObject2[1];
              }
            }
            j += 1;
            i = k;
            continue;
            label1795:
            ((com.tencent.mm.plugin.sns.j.e)localObject2).fHF.set(3, ((com.tencent.mm.plugin.sns.j.e)localObject2).zKP);
            ((com.tencent.mm.plugin.sns.j.e)localObject2).fHF.set(4, ((com.tencent.mm.plugin.sns.j.e)localObject2).zKQ);
            ((com.tencent.mm.plugin.sns.j.e)localObject2).fHF.set(5, ((com.tencent.mm.plugin.sns.j.e)localObject2).zKR);
            break;
            bool = false;
          }
        }
      }
      catch (Exception localException)
      {
        int m;
        for (;;)
        {
          ae.w("MicroMsg.SnsUnreadTipManager", "flushUnreadTipFaultWriteCache error:%s", new Object[] { localException.getMessage() });
        }
        j = getResources().getDimensionPixelSize(2131166841);
        if ((!ah.dXn()) && (this.ABt.dXu() != null) && (this.ACH == 0))
        {
          localObject1 = ah.dXM();
          String str1 = this.ABv.AIr.ehD();
          localObject3 = this.ABv.AIr.ehF();
          l1 = this.ABt.dXu().zCw;
          localObject4 = this.ABv.AIr.ehB();
          str2 = this.ABv.AIr.ehC();
          long l2 = this.ABt.dXu().zCx;
          String str3 = this.ABv.AIr.ehE();
          bool = this.mUIAction.AmY;
          ((ap)localObject1).AmS = bu.HQ();
          ((ap)localObject1).rmb = str1;
          ((ap)localObject1).AmT = ((String)localObject3);
          ((ap)localObject1).zCw = l1;
          ((ap)localObject1).position = m;
          ((ap)localObject1).AmX = (i - j);
          ((ap)localObject1).AmW = str3;
          ((ap)localObject1).AmU = ((String)localObject4);
          ((ap)localObject1).AmV = str2;
          ((ap)localObject1).zCx = l2;
          ((ap)localObject1).AmY = bool;
          ae.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(((ap)localObject1).AmS), str1, localObject3, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(((ap)localObject1).AmX), localObject4, str2, Long.valueOf(l2), str3, Boolean.valueOf(bool) });
        }
        ae.d("MicroMsg.SnsTimeLineUI", "top h %d", new Object[] { Integer.valueOf(i - j) });
        localObject1 = this.ABv.AIq;
        com.tencent.mm.sdk.b.a.IvT.d(((bh)localObject1).kzS);
        if (!ah.dXn()) {
          break label2603;
        }
      }
    }
    ae.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
    for (;;)
    {
      localObject1 = this.ABv.AIq;
      if (((bh)localObject1).Asf != null) {
        ((bh)localObject1).Asf.activity = null;
      }
      localObject1 = this.ABv.AIq;
      com.tencent.mm.sdk.b.a.IvT.d(((bh)localObject1).kzS);
      this.ABv.AIq.egt();
      this.ABv.AIq.egp();
      label2307:
      bj.clean();
      com.tencent.mm.sdk.b.a.IvT.d(this.ACc);
      com.tencent.mm.kernel.g.ajS();
      if (com.tencent.mm.kernel.g.ajP().aiZ()) {
        ah.dXB().zwV.clear();
      }
      this.ABv.AIr.removeVendingDataChangedCallback(this.ACe);
      this.ACe = null;
      this.ABv = null;
      this.ABB = null;
      com.tencent.mm.plugin.sns.ui.a.c.ehz();
      com.tencent.mm.plugin.sns.abtest.c.dUA();
      localObject1 = ah.dXv();
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(291, (com.tencent.mm.ak.f)localObject1);
      com.tencent.mm.plugin.sns.abtest.a.clean();
      this.mUIAction.onDestroy();
      super.onDestroy();
      com.tencent.mm.kiss.widget.textview.c.gHq.akT();
      localObject1 = this.ABu;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).AIO = null;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = false;
      com.tencent.mm.plugin.sns.ad.e.m.zqi.zqh.clear();
      ae.i("MicroMsg.SnsTimelineAdResourceMgr", "clean cache", new Object[] { bu.fpN() });
      localObject1 = ah.dXz();
      if (!((com.tencent.mm.plugin.sns.model.c)localObject1).zwG.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.c)localObject1).zwG.clear();
      }
      localObject1 = ah.dXz();
      if (!((com.tencent.mm.plugin.sns.model.c)localObject1).zwH.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.c)localObject1).zwH.clear();
      }
      ah.dXN().zDD = false;
      localObject1 = com.tencent.mm.plugin.sns.j.e.zKO;
      ((com.tencent.mm.plugin.sns.j.e)localObject1).zLa.clear();
      ((com.tencent.mm.plugin.sns.j.e)localObject1).zLb.clear();
      if (com.tencent.mm.plugin.sns.j.e.zKO.zLx.eqz > 0L)
      {
        localObject1 = com.tencent.mm.plugin.sns.j.e.zKO;
        ((com.tencent.mm.plugin.sns.j.e)localObject1).zLx.dTq = 1L;
        ((com.tencent.mm.plugin.sns.j.e)localObject1).zLx.aLH();
        ((com.tencent.mm.plugin.sns.j.e)localObject1).zLx = new gq();
      }
      AppMethodBeat.o(99383);
      return;
      label2603:
      ah.dXB();
    }
  }
  
  public void onDrag()
  {
    AppMethodBeat.i(99404);
    super.onDrag();
    AppMethodBeat.o(99404);
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(99389);
    super.onKeyboardStateChanged();
    com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179271);
        SnsTimeLineUI.this.edt();
        AppMethodBeat.o(179271);
      }
    });
    if (keyboardState() == 2)
    {
      if ((this.ABB != null) && (this.ABB.Agn != null) && (!this.ABB.Agn.efx()))
      {
        ae.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
        AppMethodBeat.o(99389);
      }
    }
    else if ((keyboardState() == 1) && (this.ABB != null))
    {
      i locali = this.ABB;
      if (locali.Agk)
      {
        locali.Agk = false;
        locali.Ago.ehw();
      }
    }
    AppMethodBeat.o(99389);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99387);
    try
    {
      bi.a(this, null);
      this.AoZ = false;
      this.ABy.clearAnimation();
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, this.fMX);
      this.fMX = 0;
      u.b(this);
      ah.dXB().zwX = null;
      if (this.ABv != null)
      {
        localObject = this.ABv.AIq;
        com.tencent.mm.sdk.b.a.IvT.d(((bh)localObject).AsJ);
        com.tencent.mm.sdk.b.a.IvT.d(((bh)localObject).AsI);
        com.tencent.mm.sdk.b.a.IvT.d(((bh)localObject).AsK);
      }
      if ((this.ABB != null) && (this.ABB.Agi != null)) {
        this.ABB.Agi.onPause();
      }
      if ((this.ABB != null) && (this.ABB.Agj != null)) {
        this.ABB.Agj.zCa.rt(false);
      }
      com.tencent.mm.modelstat.d.m("SnsTimeLineUI", this.vIW, bu.aRi());
      this.mUIAction.onPause();
      super.onPause();
      com.tencent.mm.plugin.sns.ui.video.d.eir().onUIPause();
      Object localObject = com.tencent.mm.plugin.sns.ui.video.b.eil();
      ae.i("MicroMsg.SightPlayViewManager", "onUIPause");
      localObject = ((com.tencent.mm.plugin.sns.ui.video.b)localObject).ASp.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.sns.ui.video.a)((Iterator)localObject).next()).onUIPause();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
      }
      com.tencent.mm.sdk.b.a.IvT.d(this.ACh);
      com.tencent.mm.sdk.b.a.IvT.d(this.ACg);
      com.tencent.mm.sdk.b.a.IvT.d(this.ACu);
      if ((com.tencent.matrix.b.HS()) && (com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class) != null))
      {
        com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class)).cKh;
        if (localc != null) {
          this.gyO = Math.max(0L, localc.cLZ - this.gyO);
        }
      }
      if (bu.aRi() <= this.hYE) {}
    }
    for (long l = bu.aRi() - this.hYE;; l = 1L)
    {
      this.hYE = l;
      WXHardCoderJNI.reportFPS(701, WXHardCoderJNI.hcSNSScrollAction, 1, this.gyO, this.hYE);
      this.gyO = 0L;
      this.hYE = 0L;
      if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class) != null) {
        ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.b.class)).c(101, false, false);
      }
      AppMethodBeat.o(99387);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(99403);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(99403);
      return;
    }
    ae.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99403);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        egC();
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(179286);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = SnsTimeLineUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$72", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$72", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(179286);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(179287);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(179287);
            }
          });
        }
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        egB();
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        com.tencent.mm.ui.base.h.a(getContext(), getString(paramInt), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179288);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = SnsTimeLineUI.this.getContext();
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$74", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$74", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(179288);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(219999);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(219999);
          }
        });
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        egB();
        AppMethodBeat.o(99403);
        return;
      }
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131761869), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(220000);
          paramAnonymousDialogInterface = SnsTimeLineUI.this.getContext();
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$76", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$76", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(220000);
        }
      }, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99384);
    ah.dXN().zDB = av.zEc;
    this.ABS.yPh = bc.efW();
    this.hYE = bu.aRi();
    Object localObject1;
    if ((com.tencent.matrix.b.HS()) && (com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class) != null))
    {
      localObject1 = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class)).cKh;
      if (localObject1 != null) {
        this.gyO = ((com.tencent.matrix.trace.f.c)localObject1).cLZ;
      }
    }
    try
    {
      if (!this.AoZ)
      {
        ae.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onResume callback");
        bi.a(this, this.ApP);
        this.AoZ = true;
      }
      if ((com.tencent.mm.sdk.a.b.fnF()) && (com.tencent.mm.sdk.a.b.fnD())) {
        sUILeaksRoutineEnsuranceRef.add(this);
      }
      this.mUIAction.onResume();
      super.onResume();
      egy();
      if (this.autoPlay) {
        egx();
      }
      this.vIW = bu.aRi();
      int i;
      if (this.ACG)
      {
        this.ACG = false;
        i = this.ABv.getCount();
        if (getIntent().getBooleanExtra("is_from_find_more", false))
        {
          localObject3 = com.tencent.mm.modelsns.e.c(getIntent(), "enter_log");
          if (localObject3 != null)
          {
            if (i <= 0) {
              break label735;
            }
            localp = this.ABv.RA(0);
            if (localp != null) {
              break label701;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.e)localObject3).GU((String)localObject1);
            if (localp != null) {
              break label713;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.e)localObject3).GU((String)localObject1);
            ((com.tencent.mm.modelsns.e)localObject3).GU(String.valueOf(i));
            ((com.tencent.mm.modelsns.e)localObject3).aLH();
          }
        }
      }
      if (this.mScreenWidth == 0)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
        this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
        localObject1 = this.ABI;
        i = this.mScreenWidth;
        int j = this.mScreenHeight;
        ((com.tencent.mm.plugin.sns.j.a)localObject1).mScreenWidth = i;
        ((com.tencent.mm.plugin.sns.j.a)localObject1).mScreenHeight = j;
      }
      if (ah.dXn()) {
        finish();
      }
      ah.dXB().zwX = this.ABv.AIq;
      akP().bk(c.b.class);
      u.a(this);
      if (this.ABA)
      {
        this.ABy.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99328);
            ae.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.M(SnsTimeLineUI.this));
            if (SnsTimeLineUI.M(SnsTimeLineUI.this))
            {
              SnsTimeLineUI.m(SnsTimeLineUI.this);
              SnsTimeLineUI.l(SnsTimeLineUI.this).egQ();
            }
            AppMethodBeat.o(99328);
          }
        });
        if ((this.ABB != null) && (this.ABB.Agi != null)) {
          this.ABB.Agi.onResume();
        }
        if (this.ABv != null)
        {
          localObject1 = this.ABv.AIq;
          com.tencent.mm.sdk.b.a.IvT.c(((bh)localObject1).AsJ);
          com.tencent.mm.sdk.b.a.IvT.c(((bh)localObject1).AsI);
          com.tencent.mm.sdk.b.a.IvT.c(((bh)localObject1).AsK);
        }
        if ((this.ABB != null) && (this.ABB.Agj != null))
        {
          this.ABB.Agj.zCa.rt(true);
          this.ABB.Agj.zCa.ru(false);
          this.ABB.Agj.zCa.rv(false);
          this.ABB.Agj.zCa.rw(false);
          this.ABB.Agj.zCa.rG(false);
          localObject1 = this.ABB.Agj.zCa;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rE(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rF(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).ry(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rD(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rB(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rD(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rH(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rC(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rD(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rz(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rA(false);
        }
        localObject1 = ah.dXB();
        ((com.tencent.mm.plugin.sns.model.g)localObject1).zwY = 0L;
        ((com.tencent.mm.plugin.sns.model.g)localObject1).zwZ = 0L;
        com.tencent.mm.sdk.b.a.IvT.c(this.ACh);
        com.tencent.mm.sdk.b.a.IvT.c(this.ACg);
        com.tencent.mm.sdk.b.a.IvT.c(this.ACu);
        AppMethodBeat.o(99384);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject3;
        com.tencent.mm.plugin.sns.storage.p localp;
        ae.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
        continue;
        label701:
        Object localObject2 = com.tencent.mm.plugin.sns.data.r.zV(localp.field_snsId);
        continue;
        label713:
        localObject2 = localp.field_createTime;
        continue;
        label735:
        ((com.tencent.mm.modelsns.e)localObject3).GU("");
        ((com.tencent.mm.modelsns.e)localObject3).GU("");
        ((com.tencent.mm.modelsns.e)localObject3).GU("0");
        continue;
        localObject2 = this.ABD;
        if (((a)localObject2).ACN.ABy.getVisibility() == 0)
        {
          ((a)localObject2).init();
          localObject3 = (AbsoluteLayout.LayoutParams)((a)localObject2).ACN.ABy.getLayoutParams();
          ((AbsoluteLayout.LayoutParams)localObject3).y = ((int)((a)localObject2).ADk);
          ((a)localObject2).ACN.ABy.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((a)localObject2).ACN.ABy.invalidate();
        }
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(99398);
    ae.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType());
    if (paramn.getType() == 218)
    {
      paramString = (com.tencent.mm.plugin.sns.model.r)paramn;
      if (((paramString.type == 1) || (paramString.type == 6) || (paramString.type == 4)) && (this.ABB.AgA != null)) {
        this.ABB.AgA.dismiss();
      }
      if (paramString.type == 11)
      {
        if (this.mUIAction.tipDialog != null) {
          this.mUIAction.tipDialog.dismiss();
        }
        if (this.ACJ != null) {
          this.ACJ.setImageResource(2131690526);
        }
      }
    }
    if (this.ABv != null) {
      this.ABv.AIr.notifyVendingDataChange();
    }
    if (paramn.getType() == 211)
    {
      paramString = (y)paramn;
      if (!paramString.zxW) {
        break label272;
      }
      paramn = com.tencent.mm.modelsns.e.pY(727);
      paramn.qb(this.ABv.getCount()).qb(paramString.ajO);
      paramn.aLH();
    }
    for (;;)
    {
      if (this.ABD != null)
      {
        this.ABA = false;
        this.ABD.egR();
      }
      AppMethodBeat.o(99398);
      return;
      label272:
      paramn = com.tencent.mm.modelsns.e.pY(728);
      paramn.qb(this.ABv.getCount()).qb(paramString.ajO).qb(0);
      paramn.aLH();
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(99385);
    super.onStart();
    AppMethodBeat.o(99385);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(99386);
    super.onStop();
    AppMethodBeat.o(99386);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(220003);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    ae.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      bi.a(this, null);
      this.AoZ = false;
      AppMethodBeat.o(220003);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      ae.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.o(220003);
    }
    if (!this.AoZ)
    {
      ae.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onWindowFocusChanged callback");
      bi.a(this, this.ApP);
      this.AoZ = true;
    }
    AppMethodBeat.o(220003);
    return;
  }
  
  public final void sb(boolean paramBoolean)
  {
    AppMethodBeat.i(99405);
    if (this.ABv != null)
    {
      ae.i("MicroMsg.SnsTimeLineUI", "set play animation %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.mm.plugin.sns.ui.a.c localc = this.ABv;
      localc.AIs = paramBoolean;
      if (!paramBoolean) {
        localc.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(99405);
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(99375);
    super.setActionbarColor(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.xgg != null))
    {
      this.xgg.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.b(getWindow());
    }
    AppMethodBeat.o(99375);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    AppMethodBeat.i(99390);
    boolean bool = super.supportNavigationSwipeBack();
    AppMethodBeat.o(99390);
    return bool;
  }
  
  final class a
    extends Animation
  {
    private float ADh;
    private float ADi;
    float ADj = -1.0F;
    float ADk;
    private float ADl = 50.0F;
    private float ADm = 10.0F;
    float ADn = 0.0F;
    private float ADo = 0.0F;
    private float ADp;
    private float ADq;
    boolean ADr;
    int ADs;
    boolean ADt = false;
    int ADu = 0;
    float ADv = 0.0F;
    float ADw = 0.0F;
    float ADx = 0.0F;
    float ADy = 0.0F;
    int DELAY_TIME = 600;
    private ListView list;
    
    public a(ListView paramListView)
    {
      this.list = paramListView;
    }
    
    final void AO(long paramLong)
    {
      AppMethodBeat.i(99363);
      if (SnsTimeLineUI.ACw.booleanValue()) {
        ae.d("MicroMsg.RefreshAnim", "setDurationTime durationMillis %s %s", new Object[] { Long.valueOf(paramLong), bu.fpN().toString() });
      }
      setDuration(paramLong);
      AppMethodBeat.o(99363);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(99366);
      if (SnsTimeLineUI.ACw.booleanValue()) {
        ae.d("MicroMsg.RefreshAnim", "animtest applyTransformation vis %s interpolatedTime %s isJustUp %s", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(paramFloat), Boolean.valueOf(this.ADr) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99366);
        return;
      }
      float f1 = (paramFloat - this.ADp) * (float)getDuration();
      if (f1 < 2.0F)
      {
        if (SnsTimeLineUI.ACw.booleanValue()) {
          ae.d("MicroMsg.RefreshAnim", "applyTransformation wawawa %s", new Object[] { Float.valueOf(f1) });
        }
        AppMethodBeat.o(99366);
        return;
      }
      this.ADp = paramFloat;
      SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(2131690250);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.Lpt);
      if (((float)getDuration() * paramFloat >= (float)(getDuration() - this.DELAY_TIME)) || (this.ADr))
      {
        paramTransformation = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        if (paramTransformation.y <= this.ADo)
        {
          AppMethodBeat.o(99366);
          return;
        }
        if (this.ADx == 0.0F)
        {
          this.ADx = (-this.ADo + paramTransformation.y);
          this.ADy = paramTransformation.y;
          this.ADq = paramFloat;
        }
        paramFloat = (paramFloat - this.ADq) / (1.0F - this.ADq);
        f1 = this.ADx * paramFloat;
        float f2 = this.ADy - f1;
        if (SnsTimeLineUI.ACw.booleanValue()) {
          ae.i("MicroMsg.RefreshAnim", "animcheck interpolatedTime y %s duration %s factor %s residualTime %s pass %s ", new Object[] { Float.valueOf(f2), Long.valueOf(getDuration()), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.ADq * (float)getDuration()) });
        }
        if (paramTransformation.y > f2) {
          paramTransformation.y = ((int)f2);
        }
        this.ADn = paramTransformation.y;
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(paramTransformation);
      }
      for (;;)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99366);
        return;
        if (SnsTimeLineUI.ACw.booleanValue()) {
          ae.d("MicroMsg.RefreshAnim", "animcheck delt Rotate " + f1 / 2.5F);
        }
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(f1 / 2.5F, this.ADh, this.ADi);
      }
    }
    
    public final void bF(float paramFloat)
    {
      AppMethodBeat.i(99360);
      if (this.list != null)
      {
        if (this.list.getFirstVisiblePosition() != 0) {
          break label123;
        }
        if (SnsTimeLineUI.d(SnsTimeLineUI.this).zIf.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).ADs) {
          SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
        }
      }
      for (;;)
      {
        if (SnsTimeLineUI.ACw.booleanValue()) {
          ae.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.ADk), Float.valueOf(this.ADj) });
        }
        if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() == 0) {
          break;
        }
        AppMethodBeat.o(99360);
        return;
        label123:
        SnsTimeLineUI.b(SnsTimeLineUI.this, 8);
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      init();
      float f1 = paramFloat;
      if (paramFloat <= -this.ADl) {
        f1 = -this.ADl;
      }
      float f2 = f1;
      if (f1 >= this.ADl) {
        f2 = this.ADl;
      }
      if (f2 < 0.0F)
      {
        this.ADn -= f2 * 2.0F;
        f1 = this.ADn;
        paramFloat = f1;
        if (f1 < this.ADk)
        {
          paramFloat = this.ADk;
          this.ADn = this.ADk;
        }
        f1 = paramFloat;
        if (paramFloat > this.ADj)
        {
          f1 = this.ADj;
          this.ADn = this.ADj;
        }
        if (SnsTimeLineUI.ACw.booleanValue()) {
          ae.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s sumY %s translateY %s distanceY %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.ADk), Float.valueOf(this.ADj), Float.valueOf(this.ADn), Float.valueOf(f1), Float.valueOf(this.ADl) });
        }
        if (f1 != this.ADj) {
          break label456;
        }
      }
      label456:
      for (paramFloat = f2 * 2.0F;; paramFloat = 5.0F * f2)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.Lpt);
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(paramFloat, this.ADh, this.ADi);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(2131690250);
        AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        localLayoutParams.y = ((int)f1);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99360);
        return;
        this.ADn -= f2 / 2.0F;
        break;
      }
    }
    
    public final void egQ()
    {
      AppMethodBeat.i(99361);
      if (SnsTimeLineUI.ACw.booleanValue()) {
        ae.d("MicroMsg.RefreshAnim", "animtest playLoading");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99361);
        return;
      }
      init();
      this.ADn = (this.ADj + 20.0F);
      AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
      localLayoutParams.y = ((int)this.ADj);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
      egS();
      AppMethodBeat.o(99361);
    }
    
    public final void egR()
    {
      AppMethodBeat.i(99362);
      if (SnsTimeLineUI.ACw.booleanValue()) {
        ae.i("MicroMsg.RefreshAnim", "play end vis: %d, sumY %f MAX_Y %f", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(this.ADn), Float.valueOf(this.ADj) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99362);
        return;
      }
      init();
      if (this.ADn < this.ADj - this.ADm)
      {
        AppMethodBeat.o(99362);
        return;
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      AO(this.DELAY_TIME + 100);
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      this.ADr = false;
      AppMethodBeat.o(99362);
    }
    
    public final void egS()
    {
      AppMethodBeat.i(99364);
      if (SnsTimeLineUI.ACw.booleanValue()) {
        ae.d("MicroMsg.RefreshAnim", "animtest setAcitonUp");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99364);
        return;
      }
      init();
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      if (SnsTimeLineUI.ACw.booleanValue()) {
        ae.v("MicroMsg.RefreshAnim", "setAcitonUp1 sumY  %s MAX_Y %s %s", new Object[] { Float.valueOf(this.ADn), Float.valueOf(this.ADj), bu.fpN().toString() });
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      if (this.ADn >= this.ADj - this.ADm)
      {
        AO(20000L);
        this.ADr = false;
        AppMethodBeat.o(99364);
        return;
      }
      AO(this.DELAY_TIME + 100);
      this.ADr = true;
      AppMethodBeat.o(99364);
    }
    
    final void init()
    {
      AppMethodBeat.i(99365);
      if ((this.ADj == -1.0F) || (this.ADi < 0.1D))
      {
        this.ADj = BackwardSupportUtil.b.h(SnsTimeLineUI.this, 70.0F);
        this.ADl = BackwardSupportUtil.b.h(SnsTimeLineUI.this, 16.0F);
        this.ADh = (SnsTimeLineUI.u(SnsTimeLineUI.this).getWidth() / 2);
        this.ADi = (SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() / 2);
        this.ADo = (-SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() * 2);
        if (this.ADo == 0.0F) {
          this.ADo = (-BackwardSupportUtil.b.h(SnsTimeLineUI.this, 40.0F));
        }
        this.ADk = this.ADo;
        if (SnsTimeLineUI.ACw.booleanValue()) {
          ae.d("MicroMsg.RefreshAnim", "init MIN_Y %s MAX_Y %s targetInitY %s distanceY %s", new Object[] { Float.valueOf(this.ADk), Float.valueOf(this.ADj), Float.valueOf(this.ADo), Float.valueOf(this.ADl) });
        }
        this.ADn = this.ADk;
        if (!this.ADt)
        {
          if (SnsTimeLineUI.ACw.booleanValue()) {
            ae.i("MicroMsg.RefreshAnim", "initState");
          }
          this.ADu = ((AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams()).y;
          this.ADv = this.ADj;
          this.ADw = this.ADn;
        }
        this.ADt = true;
      }
      AppMethodBeat.o(99365);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(99367);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      if (SnsTimeLineUI.ACw.booleanValue()) {
        ae.i("MicroMsg.RefreshAnim", "anim initialize %s", new Object[] { bu.fpN().toString() });
      }
      this.ADp = 0.0F;
      this.ADq = 0.0F;
      this.ADx = 0.0F;
      this.ADy = 0.0F;
      AppMethodBeat.o(99367);
    }
  }
  
  final class b
  {
    public int ADz;
    public int type = 0;
    
    private b() {}
  }
  
  final class c
  {
    public String ADA = "";
    public long ADB;
    public int ADC;
    public int ADE;
    public long ADF;
    public int ADG;
    public long ADH;
    public int ADI;
    public long ADJ;
    public boolean active = true;
    public long lFO;
    public int scene;
    
    private c() {}
    
    public final void RX(int paramInt)
    {
      AppMethodBeat.i(99368);
      if (!this.active)
      {
        AppMethodBeat.o(99368);
        return;
      }
      this.ADE = paramInt;
      this.lFO = bu.fpO();
      AppMethodBeat.o(99368);
    }
    
    public final void RY(int paramInt)
    {
      AppMethodBeat.i(99369);
      if (!this.active)
      {
        AppMethodBeat.o(99369);
        return;
      }
      reset();
      this.scene = 2;
      this.ADF = bu.fpO();
      this.ADG = paramInt;
      AppMethodBeat.o(99369);
    }
    
    public final void RZ(int paramInt)
    {
      AppMethodBeat.i(99370);
      if (!this.active)
      {
        AppMethodBeat.o(99370);
        return;
      }
      reset();
      this.scene = 3;
      this.ADH = bu.fpO();
      this.ADJ = 0L;
      this.ADI = paramInt;
      AppMethodBeat.o(99370);
    }
    
    final void reset()
    {
      this.scene = 0;
      this.ADB = 0L;
      this.ADC = -1;
      this.ADE = 0;
      this.lFO = 0L;
      this.ADF = 0L;
      this.ADG = 0;
      this.ADH = 0L;
      this.ADI = 0;
      this.ADJ = 0L;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(99371);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.ADA).append(",").append(this.scene).append(",").append(this.ADB).append(",").append(this.ADC).append(",").append(this.ADE).append(",").append(this.lFO).append(",").append(this.ADF).append(",").append(this.ADG).append(",").append(this.ADH).append(",").append(this.ADI).append(",").append(this.ADJ);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(99371);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI
 * JD-Core Version:    0.7.0.1
 */