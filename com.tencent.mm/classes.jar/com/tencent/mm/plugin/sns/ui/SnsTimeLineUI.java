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
import com.tencent.mm.al.n;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.um;
import com.tencent.mm.g.a.un;
import com.tencent.mm.g.a.us;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.g.a.va;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.g.a.xn;
import com.tencent.mm.g.b.a.ez;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.model.av;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sns.ad.d.k.5;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.j.a.a;
import com.tencent.mm.plugin.sns.j.b.2;
import com.tencent.mm.plugin.sns.l.c.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.at.4;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
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
  implements com.tencent.mm.al.f, av, i.a, w
{
  private static Boolean AkD;
  public static final Boolean Alj;
  private static final Set<Activity> sUILeaksRoutineEnsuranceRef;
  protected com.tencent.mm.plugin.sns.ad.d.i Abd;
  private boolean AkA;
  private int AkB;
  private String AkC;
  private String AkE;
  private c AkF;
  private bc AkG;
  private ViewGroup AkH;
  private long AkI;
  private boolean AkJ;
  private int AkK;
  private int AkL;
  private int AkM;
  private int AkN;
  private Runnable AkO;
  private com.tencent.mm.sdk.b.c AkP;
  private com.tencent.mm.sdk.b.c AkQ;
  private Vending.d AkR;
  private boolean AkS;
  private com.tencent.mm.sdk.b.c AkT;
  private com.tencent.mm.sdk.b.c AkU;
  private com.tencent.mm.sdk.b.c AkV;
  private com.tencent.mm.sdk.b.c AkW;
  private com.tencent.mm.sdk.b.c AkX;
  private com.tencent.mm.sdk.b.c AkY;
  private com.tencent.mm.sdk.b.c AkZ;
  private final long Ake;
  private long Akf;
  private com.tencent.mm.plugin.sns.l.b Akg;
  private com.tencent.mm.plugin.sns.l.a Akh;
  private com.tencent.mm.plugin.sns.ui.a.a.c Aki;
  private com.tencent.mm.plugin.sns.ui.a.c Akj;
  private LinearLayout Akk;
  private LinearLayout Akl;
  private QFadeImageView Akm;
  private boolean Akn;
  private boolean Ako;
  private i Akp;
  private int Akq;
  private a Akr;
  private TestTimeForSns Aks;
  private int Akt;
  private boolean Aku;
  private String Akv;
  private com.tencent.mm.plugin.sns.j.a Akw;
  private ba Akx;
  private com.tencent.mm.plugin.sns.model.ay Aky;
  private String Akz;
  private boolean AlA;
  private com.tencent.mm.sdk.b.c Ala;
  private com.tencent.mm.sdk.b.c Alb;
  private com.tencent.mm.sdk.b.c Alc;
  private com.tencent.mm.sdk.b.c Ald;
  private com.tencent.mm.sdk.b.c Ale;
  private com.tencent.mm.sdk.b.c Alf;
  private com.tencent.mm.sdk.b.c Alg;
  private com.tencent.mm.sdk.b.c Alh;
  private com.tencent.mm.sdk.b.c Ali;
  private long Alk;
  boolean Alm;
  Runnable Aln;
  Runnable Alo;
  private Handler Alp;
  private Runnable Alq;
  private SnsUIAction.a Alr;
  private long Als;
  private a.b Alt;
  boolean Alu;
  int Alv;
  private MenuItem.OnMenuItemClickListener Alw;
  private ImageView Alx;
  private View Aly;
  private long Alz;
  private boolean autoPlay;
  private int fKU;
  private long gwh;
  private long hVM;
  private String lEN;
  private ActionBar mActionBar;
  private int mScreenHeight;
  private int mScreenWidth;
  private String mSessionId;
  private SnsUIAction mUIAction;
  private com.tencent.mm.ui.statusbar.c.a sgH;
  private int tcO;
  private long vwS;
  private View wQp;
  private boolean zPl;
  private boolean zRo;
  private volatile boolean zXO;
  private bh.a zYD;
  private com.tencent.mm.sdk.b.c zlu;
  private boolean zqR;
  
  static
  {
    AppMethodBeat.i(99430);
    AkD = null;
    Alj = Boolean.FALSE;
    sUILeaksRoutineEnsuranceRef = new HashSet();
    AppMethodBeat.o(99430);
  }
  
  public SnsTimeLineUI()
  {
    AppMethodBeat.i(99372);
    this.Ake = 300L;
    this.Akf = SystemClock.elapsedRealtime();
    this.Akg = ((com.tencent.mm.plugin.sns.l.b)am(com.tencent.mm.plugin.sns.l.b.class));
    if (this.Akg != null) {}
    for (com.tencent.mm.plugin.sns.l.a locala = this.Akg.efh();; locala = null)
    {
      this.Akh = locala;
      this.Aki = new com.tencent.mm.plugin.sns.ui.a.a.c();
      this.Akn = false;
      this.Ako = false;
      this.zPl = false;
      this.Akq = 800;
      this.Akt = 0;
      this.Aku = false;
      this.Akv = "";
      this.Akw = new com.tencent.mm.plugin.sns.j.a();
      this.Abd = new com.tencent.mm.plugin.sns.ad.d.i(0);
      this.Akx = new ba();
      this.Aky = new com.tencent.mm.plugin.sns.model.ay();
      this.autoPlay = false;
      this.AkE = "";
      this.AkF = new c((byte)0);
      this.AkG = new bc();
      this.AkH = null;
      this.AkI = 0L;
      this.zXO = false;
      this.AkJ = false;
      this.AkK = 0;
      this.AkL = 0;
      this.AkM = 0;
      this.AkN = 2;
      this.AkO = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99267);
          com.tencent.mm.plugin.sns.ui.a.c localc = SnsTimeLineUI.a(SnsTimeLineUI.this);
          if (localc != null)
          {
            if (ag.dUn().zmm == au.zmM) {
              SnsTimeLineUI.a(SnsTimeLineUI.this, localc.rZ(true));
            }
            localc.Ard.ecx();
            localc.Ard.notifyVendingDataChange();
          }
          AppMethodBeat.o(99267);
        }
      };
      this.AkP = new com.tencent.mm.sdk.b.c() {};
      this.AkQ = new com.tencent.mm.sdk.b.c() {};
      this.AkR = new Vending.d()
      {
        public final void ede()
        {
          AppMethodBeat.i(179249);
          final int i;
          if ((SnsTimeLineUI.a(SnsTimeLineUI.this) != null) && (!SnsTimeLineUI.a(SnsTimeLineUI.this).Are))
          {
            SnsTimeLineUI.a(SnsTimeLineUI.this).notifyDataSetChanged();
            if (SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView() != null)
            {
              i = com.tencent.mm.ui.ar.dT(SnsTimeLineUI.this.getContext());
              int j = com.tencent.mm.ui.ar.jG(SnsTimeLineUI.this.getContext());
              ad.d("MicroMsg.SnsTimeLineUI", "topOffset:%s curFetchMode:%s, mUIAction.header.getLoadingGroupHeight():%s, actionBar:%s, statusBar:%s", new Object[] { Integer.valueOf(-(SnsTimeLineUI.d(SnsTimeLineUI.this).zqQ.getLoadingGroupHeight() - com.tencent.mm.ui.aq.fromDPToPix(SnsTimeLineUI.this.getContext(), 44) - i - j)), Integer.valueOf(ag.dUn().zmm), Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).zqQ.getLoadingGroupHeight()), Integer.valueOf(i), Integer.valueOf(j) });
              if (ag.dUn().zmm == au.zmL)
              {
                ad.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_SPECIFIC");
                long l = SnsTimeLineUI.a(SnsTimeLineUI.this).edT();
                ag.dTU().V(l, -1);
                SnsTimeLineUI.a(SnsTimeLineUI.this).Ard.aAV(com.tencent.mm.plugin.sns.data.q.zx(l));
                SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.a(SnsTimeLineUI.this).rZ(true));
                SnsTimeLineUI.d(SnsTimeLineUI.this).rW(true);
                ag.dUb().start();
                SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(198430);
                    SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().setSelectionFromTop(SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), i + com.tencent.mm.ui.aq.fromDPToPix(SnsTimeLineUI.this.getContext(), 44));
                    ag.dUn().zmo = false;
                    AppMethodBeat.o(198430);
                  }
                });
                AppMethodBeat.o(179249);
                return;
              }
              if (ag.dUn().zmm == au.zmM)
              {
                i = 0;
                if (i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) {
                  break label421;
                }
                if (SnsTimeLineUI.a(SnsTimeLineUI.this).QT(i).field_snsId != SnsTimeLineUI.e(SnsTimeLineUI.this)) {
                  break label414;
                }
              }
            }
          }
          for (;;)
          {
            ad.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_UP upFetchRightId:%s, rightIndex:%s", new Object[] { Long.valueOf(SnsTimeLineUI.e(SnsTimeLineUI.this)), Integer.valueOf(i) });
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
      this.AkS = false;
      this.zqR = false;
      this.AkT = new com.tencent.mm.sdk.b.c() {};
      this.AkU = new com.tencent.mm.sdk.b.c() {};
      this.AkV = new SnsTimeLineUI.66(this);
      this.AkW = new com.tencent.mm.sdk.b.c() {};
      this.AkX = new com.tencent.mm.sdk.b.c() {};
      this.AkY = new com.tencent.mm.sdk.b.c() {};
      this.AkZ = new com.tencent.mm.sdk.b.c() {};
      this.Ala = new com.tencent.mm.sdk.b.c() {};
      this.Alb = new SnsTimeLineUI.5(this);
      this.zlu = new com.tencent.mm.sdk.b.c() {};
      this.Alc = new com.tencent.mm.sdk.b.c() {};
      this.Ald = new com.tencent.mm.sdk.b.c() {};
      this.Ale = new com.tencent.mm.sdk.b.c() {};
      this.Alf = new com.tencent.mm.sdk.b.c() {};
      this.Alg = new com.tencent.mm.sdk.b.c() {};
      this.Alh = new SnsTimeLineUI.13(this);
      this.Ali = new com.tencent.mm.sdk.b.c() {};
      this.Alk = 0L;
      this.Alm = false;
      this.tcO = 0;
      this.Aln = new Runnable()
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
            ag.dUb().pause();
          }
          AppMethodBeat.o(176303);
        }
      };
      this.Alo = new Runnable()
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
            ad.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() - SnsTimeLineUI.d(SnsTimeLineUI.this).list.getHeaderViewsCount()) });
            ag.dUb().start();
            SnsTimeLineUI.a(SnsTimeLineUI.this).Arc.ecK();
          }
          AppMethodBeat.o(179225);
        }
      };
      this.Alp = ((com.tencent.mm.vending.h.b)com.tencent.mm.vending.h.d.LiM.LiU).mHandler;
      this.Alq = new Runnable()
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
      this.Alr = new SnsUIAction.a()
      {
        private int AlI = 0;
        private int AlJ = 0;
        
        public final void Rp(int paramAnonymousInt)
        {
          AppMethodBeat.i(198423);
          int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          int k = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
          if ((paramAnonymousInt == 0) && (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)) {
            SnsTimeLineUI.a(SnsTimeLineUI.this, j, k);
          }
          if ((j == this.AlI) && (k == this.AlJ))
          {
            AppMethodBeat.o(198423);
            return;
          }
          this.AlI = j;
          this.AlJ = k;
          ad.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramAnonymousInt) });
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
            ad.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsTimeLineUI.E(SnsTimeLineUI.this)) });
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
              Object localObject2 = ((com.tencent.mm.plugin.sns.ui.a.c)localObject1).QT(paramAnonymousInt - 1);
              if (localObject2 != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject2).dYl();
                if ((localObject2 != null) && (!TextUtils.isEmpty(((TimeLineObject)localObject2).HAT.Url)) && (((TimeLineObject)localObject2).HAT.Url.contains("mp.weixin.qq.com")) && (((TimeLineObject)localObject2).HAT.GaP == 3))
                {
                  i = -1;
                  if (((TimeLineObject)localObject2).HAT.GaT != null) {
                    i = ((TimeLineObject)localObject2).HAT.GaT.hCZ;
                  }
                  ArrayList localArrayList = new ArrayList();
                  localArrayList.add(((TimeLineObject)localObject2).HAT.Url);
                  localArrayList.add(String.valueOf(i));
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).Id));
                  localArrayList.add("");
                  localArrayList.add("");
                  localArrayList.add(((TimeLineObject)localObject2).nDo);
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).CreateTime));
                  localArrayList.add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WP("__sns_timeline__")));
                  localLinkedList.add(localArrayList);
                }
              }
              paramAnonymousInt += 1;
            }
          }
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).j(localLinkedList, 2);
          label537:
          SnsTimeLineUI.a(SnsTimeLineUI.this).hU(j, k);
          label550:
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)
          {
            localObject1 = SnsTimeLineUI.j(SnsTimeLineUI.this).b(SnsTimeLineUI.a(SnsTimeLineUI.this).Arc);
            com.tencent.mm.vending.g.g.fOf().d(new com.tencent.mm.vending.c.a() {});
          }
          com.tencent.mm.plugin.sns.j.e.ztz.hB(j, k);
          com.tencent.mm.plugin.sns.j.e.ztz.hC(j, k);
          AppMethodBeat.o(198423);
        }
        
        public final void a(com.tencent.mm.plugin.sns.data.l paramAnonymousl) {}
        
        public final void az(int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(198424);
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).Ard.notifyVendingDataChange();
          }
          if (!paramAnonymousBoolean) {
            SnsTimeLineUI.this.akA().bk(c.b.class);
          }
          AppMethodBeat.o(198424);
        }
        
        public final void e(int paramAnonymousInt, List<Integer> paramAnonymousList1, List<Integer> paramAnonymousList2)
        {
          int j = 1;
          AppMethodBeat.i(198418);
          int i = j;
          if (paramAnonymousInt > 0)
          {
            paramAnonymousList1 = ag.dUe().QP(paramAnonymousInt);
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
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousList2, paramAnonymousList1.ahp(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.c.b((ListView)paramAnonymousList1.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousList2, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          }
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).Ard.notifyVendingDataChange();
          }
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.b(SnsTimeLineUI.this);
          }
          AppMethodBeat.o(198418);
        }
        
        public final void ecX()
        {
          AppMethodBeat.i(198413);
          if (ag.dUn().zmo)
          {
            ad.i("MicroMsg.SnsTimeLineUI", "isAutoScrolling, skip onLoadingMore");
            AppMethodBeat.o(198413);
            return;
          }
          com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
          SnsTimeLineUI.n(SnsTimeLineUI.this);
          localc.e(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), false, SnsTimeLineUI.A(SnsTimeLineUI.this));
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFc, Integer.valueOf(3));
          ad.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
          if (SnsTimeLineUI.B(SnsTimeLineUI.this) == null)
          {
            ad.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
            AppMethodBeat.o(198413);
            return;
          }
          if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
          {
            SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
            SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
          }
          AppMethodBeat.o(198413);
        }
        
        public final View ecY()
        {
          AppMethodBeat.i(198415);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).zpe == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).zpe = ((FrameLayout)SnsTimeLineUI.this.findViewById(2131305824));
          }
          FrameLayout localFrameLayout = SnsTimeLineUI.k(SnsTimeLineUI.this).zpe;
          AppMethodBeat.o(198415);
          return localFrameLayout;
        }
        
        public final MMPullDownView ecZ()
        {
          AppMethodBeat.i(198417);
          MMPullDownView localMMPullDownView = (MMPullDownView)SnsTimeLineUI.this.findViewById(2131305047);
          AppMethodBeat.o(198417);
          return localMMPullDownView;
        }
        
        public final boolean eda()
        {
          AppMethodBeat.i(198419);
          boolean bool = SnsTimeLineUI.D(SnsTimeLineUI.this);
          AppMethodBeat.o(198419);
          return bool;
        }
        
        public final void edb()
        {
          AppMethodBeat.i(198420);
          ad.d("MicroMsg.SnsTimeLineUI", "onLoadingTap");
          SnsTimeLineUI.this.dZN();
          if (!SnsTimeLineUI.d(SnsTimeLineUI.this).zVQ)
          {
            if (SnsTimeLineUI.u(SnsTimeLineUI.this) != null)
            {
              ad.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
              SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
            }
            com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this);
            localc.d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFc, Integer.valueOf(2));
          }
          AppMethodBeat.o(198420);
        }
        
        public final void edc()
        {
          AppMethodBeat.i(198421);
          SnsTimeLineUI.this.dZN();
          AppMethodBeat.o(198421);
        }
        
        public final void edd()
        {
          AppMethodBeat.i(198422);
          ag.dUn().dUW();
          int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          Object localObject1 = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getChildAt(0);
          ad.i("MicroMsg.SnsTimeLineUI", "will do up fetch isDoingFetch:%s, SnsCore.getSnsUnreadTipManager().isAutoScrolling:%s", new Object[] { Boolean.valueOf(ag.dUn().zmp), Boolean.valueOf(ag.dUn().zmo) });
          if ((!ag.dUn().zmo) && (localObject1 != null) && (i == 0) && (((View)localObject1).getTop() == 0) && (SnsTimeLineUI.d(SnsTimeLineUI.this).zVQ))
          {
            if (ag.dUn().zmp)
            {
              AppMethodBeat.o(198422);
              return;
            }
            Object localObject2 = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this);
            localObject1 = SnsTimeLineUI.o(SnsTimeLineUI.this);
            i = au.zmM;
            boolean bool = SnsTimeLineUI.q(SnsTimeLineUI.this);
            int j = SnsTimeLineUI.A(SnsTimeLineUI.this);
            if ((((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).hasInit) && (((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).Alv == 0))
            {
              long l = ag.dUn().zml;
              localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).Arz;
              if (((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).Akg != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).Akg.AEg;
                com.tencent.mm.vending.g.g.b(localObject1, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(j), Long.valueOf(l)).c((com.tencent.mm.vending.c.a)localObject2);
              }
            }
            if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
            {
              SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
              SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
            }
          }
          AppMethodBeat.o(198422);
        }
        
        public final View getMaskView()
        {
          AppMethodBeat.i(198416);
          View localView = SnsTimeLineUI.this.findViewById(2131304966);
          AppMethodBeat.o(198416);
          return localView;
        }
        
        public final ListView getSnsListView()
        {
          AppMethodBeat.i(198414);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).list == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).list = ((ListView)SnsTimeLineUI.this.findViewById(2131305038));
          }
          ListView localListView = SnsTimeLineUI.k(SnsTimeLineUI.this).list;
          AppMethodBeat.o(198414);
          return localListView;
        }
        
        public final int getType()
        {
          int i = 1;
          if (SnsTimeLineUI.this.Alv == 1) {
            i = 2;
          }
          return i;
        }
        
        public final void hT(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void rV(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(198425);
          SnsTimeLineUI localSnsTimeLineUI = SnsTimeLineUI.this;
          localSnsTimeLineUI.Alm = paramAnonymousBoolean;
          com.tencent.mm.sdk.platformtools.ap localap = ag.cVf();
          com.tencent.mm.plugin.sns.model.f localf = ag.dUb();
          com.tencent.mm.plugin.sns.model.b localb = ag.dTZ();
          if (paramAnonymousBoolean)
          {
            if ((localf.zfK) || (localb.zfK))
            {
              localap.removeCallbacks(localSnsTimeLineUI.Aln);
              localap.removeCallbacks(localSnsTimeLineUI.Alo);
              localap.postDelayed(localSnsTimeLineUI.Aln, 0L);
              AppMethodBeat.o(198425);
            }
          }
          else if ((!localf.zfK) || (!localb.zfK))
          {
            localap.removeCallbacks(localSnsTimeLineUI.Aln);
            localap.removeCallbacks(localSnsTimeLineUI.Alo);
            localap.postDelayed(localSnsTimeLineUI.Alo, 0L);
          }
          AppMethodBeat.o(198425);
        }
      };
      this.Als = 0L;
      this.Alt = new a.b() {};
      this.mScreenWidth = 0;
      this.mScreenHeight = 0;
      this.Alu = true;
      this.vwS = 0L;
      this.gwh = 0L;
      this.hVM = 0L;
      this.zYD = new SnsTimeLineUI.39(this);
      this.Alv = 0;
      this.Alw = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(198447);
          SnsTimeLineUI.this.hideVKB();
          SnsTimeLineUI.this.finish();
          AppMethodBeat.o(198447);
          return false;
        }
      };
      this.Alz = 0L;
      this.AlA = false;
      AppMethodBeat.o(99372);
      return;
    }
  }
  
  private void Ro(int paramInt)
  {
    AppMethodBeat.i(99376);
    if (Alj.booleanValue()) {
      if (paramInt != 0) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.SnsTimeLineUI", "setRefreshAnimVisible %s %s", new Object[] { Boolean.valueOf(bool), bt.flS().toString() });
      this.Akm.setVisibility(paramInt);
      AppMethodBeat.o(99376);
      return;
    }
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(99406);
    if (paramc.active)
    {
      ad.d("MicroMsg.SnsTimeLineUI", "report weishi: %s", new Object[] { paramc.toString() });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(15827, paramc.toString());
    }
    AppMethodBeat.o(99406);
  }
  
  private void dLt()
  {
    AppMethodBeat.i(99391);
    setTitleBarClickListener(new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(198448);
        SnsTimeLineUI.Q(SnsTimeLineUI.this);
        AppMethodBeat.o(198448);
      }
    }, new Runnable()
    {
      public final void run() {}
    });
    setBackBtn(this.Alw, 2131689490);
    AppMethodBeat.o(99391);
  }
  
  private void ecQ()
  {
    AppMethodBeat.i(99377);
    this.mUIAction.list.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99306);
        int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
        int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
        ad.d("MicroMsg.SnsTimeLineUI", "notifyList from:%s to:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        SnsTimeLineUI.a(SnsTimeLineUI.this, i, j);
        SnsTimeLineUI.d(SnsTimeLineUI.this).bmJ();
        AppMethodBeat.o(99306);
      }
    }, 15L);
    AppMethodBeat.o(99377);
  }
  
  private void ecR()
  {
    AppMethodBeat.i(99380);
    boolean bool;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qrc, 0) == 1)
    {
      bool = true;
      this.autoPlay = bool;
      String str1 = Build.MODEL.toLowerCase();
      String str2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qrd, "");
      if ((!bt.isNullOrNil(str2)) && (str2.contains(str1)))
      {
        ad.i("MicroMsg.SnsTimeLineUI", "model %s is hit, expt:%s", new Object[] { str1, str2 });
        this.autoPlay = false;
      }
      if (!this.autoPlay) {
        break label225;
      }
      if (!this.AkG.doP()) {
        break label170;
      }
      this.autoPlay = false;
      ad.i("MicroMsg.SnsTimeLineUI", "2G/3G autoplay false");
    }
    for (;;)
    {
      ad.i("MicroMsg.SnsTimeLineUI", "autoPlay:%s", new Object[] { Boolean.valueOf(this.autoPlay) });
      AppMethodBeat.o(99380);
      return;
      bool = false;
      break;
      label170:
      if (this.AkG.chr())
      {
        ad.i("MicroMsg.SnsTimeLineUI", "wifi autoplay true");
        this.autoPlay = true;
      }
      else
      {
        this.autoPlay = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ixx, Boolean.TRUE)).booleanValue();
        continue;
        label225:
        ad.i("MicroMsg.SnsTimeLineUI", "autoPlay DynamicConfig false");
      }
    }
  }
  
  private void ecS()
  {
    AppMethodBeat.i(99381);
    if (this.Alv == 1)
    {
      if (!this.zRo)
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99381);
        return;
      }
      addIconOptionMenu(0, getString(2131763911), 2131689502, new SnsTimeLineUI.36(this));
      AppMethodBeat.o(99381);
      return;
    }
    addIconOptionMenu(0, 2131763730, 2131690361, new SnsTimeLineUI.37(this), new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198433);
        localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).zPc != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).zPc.zkL.rq(true);
        }
        com.tencent.mm.kernel.g.ajD();
        boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(7490, Boolean.TRUE)).booleanValue();
        ag.dUl().rH(true);
        paramAnonymousView = ag.dUl().aAb("draft_text");
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.field_draft;
          if (!bt.cC(paramAnonymousView))
          {
            com.tencent.mm.kernel.g.ajD();
            localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Isz, "");
            new ez().Tn().og((String)localObject).aLk();
            localObject = Parcel.obtain();
            ((Parcel)localObject).unmarshall(paramAnonymousView, 0, paramAnonymousView.length);
            ((Parcel)localObject).setDataPosition(0);
          }
        }
        try
        {
          paramAnonymousView = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject);
          if (SnsTimeLineUI.aO(paramAnonymousView))
          {
            SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(198433);
            return true;
          }
          ag.dUl().b("draft_text", null, 0);
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ag.dUl().b("draft_text", null, 0);
            continue;
            paramAnonymousView = SnsTimeLineUI.this;
            localObject = new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajC().ajl().set(7490, Boolean.FALSE);
          }
        }
        if (!bool)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(SnsTimeLineUI.this, SnsUploadUI.class);
          paramAnonymousView.putExtra("KSnsPostManu", true);
          paramAnonymousView.putExtra("KTouchCameraTime", bt.aQJ());
          paramAnonymousView.putExtra("sns_comment_type", 1);
          paramAnonymousView.putExtra("Ksnsupload_type", 9);
          localObject = com.tencent.mm.modelsns.e.pV(705);
          ((com.tencent.mm.modelsns.e)localObject).pZ(((com.tencent.mm.modelsns.e)localObject).ing).Gt(System.currentTimeMillis()).pZ(((com.tencent.mm.modelsns.e)localObject).inh).pZ(1);
          localObject = com.tencent.mm.plugin.sns.j.g.zus.b((com.tencent.mm.modelsns.e)localObject);
          ((com.tencent.mm.modelsns.e)localObject).aLk();
          ((com.tencent.mm.modelsns.e)localObject).b(paramAnonymousView, "intent_key_StatisticsOplog");
          SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(198433);
          return true;
        }
      }
    });
    AppMethodBeat.o(99381);
  }
  
  private int ecT()
  {
    if (this.AkN == 0) {
      return this.AkK;
    }
    if (this.AkN == 1) {
      return this.AkL;
    }
    return this.AkM;
  }
  
  private void ecU()
  {
    AppMethodBeat.i(99392);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IJo, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJo, Boolean.FALSE);
    if (bool) {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJo, Boolean.FALSE);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.g.ajD();
      int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFl, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(getContext(), "", getContext().getResources().getString(2131764291, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(99392);
      return;
    }
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).startStoryCaptureForResult(getContext(), 0, System.currentTimeMillis(), 18);
    AppMethodBeat.o(99392);
  }
  
  private void ecV()
  {
    AppMethodBeat.i(99393);
    if (com.tencent.mm.s.a.cd(this))
    {
      AppMethodBeat.o(99393);
      return;
    }
    if (com.tencent.mm.s.a.ch(this))
    {
      AppMethodBeat.o(99393);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "");
    ad.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this });
    if (!bool)
    {
      AppMethodBeat.o(99393);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 18, "", "");
    ad.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), this });
    if (!bool)
    {
      AppMethodBeat.o(99393);
      return;
    }
    long l = cf.aCL();
    Object localObject1 = com.tencent.mm.plugin.sns.data.q.dSP();
    ad.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", new Object[] { localObject1 });
    com.tencent.mm.plugin.report.service.g.yhR.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), localObject1, Long.valueOf(l) });
    Object localObject2 = new SightParams(2, 0);
    localObject2 = RecordConfigProvider.a("", "", ((SightParams)localObject2).hvh, ((SightParams)localObject2).hvh.duration * 1000, 2);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qyw, false)) {
      ((RecordConfigProvider)localObject2).remuxType = 2;
    }
    Object localObject3 = new VideoCaptureReportInfo();
    ((VideoCaptureReportInfo)localObject3).rgD = 1;
    ((RecordConfigProvider)localObject2).xyB = ((VideoCaptureReportInfo)localObject3);
    localObject3 = new UICustomParam.a();
    ((UICustomParam.a)localObject3).abx();
    ((UICustomParam.a)localObject3).aby();
    ((UICustomParam.a)localObject3).cP(true);
    ((RecordConfigProvider)localObject2).xyk = ((UICustomParam.a)localObject3).gei;
    localObject3 = new SnsTimeLineUI.63(this);
    CaptureDataManager.xxY.xxX = ((CaptureDataManager.b)localObject3);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qyu, true))
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 17, 2130772137, 2130772138, (RecordConfigProvider)localObject2);
      AppMethodBeat.o(99393);
      return;
    }
    localObject2 = new Intent();
    com.tencent.mm.pluginsdk.ui.tools.q.d(getContext(), (Intent)localObject2, (String)localObject1);
    AppMethodBeat.o(99393);
  }
  
  private boolean fl(View paramView)
  {
    AppMethodBeat.i(198459);
    try
    {
      if (getContext() != null)
      {
        boolean bool = getContext().isFinishing();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(198459);
        return false;
      }
      Rect localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      paramView = new DisplayMetrics();
      getContext().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      int i = paramView.heightPixels;
      int j = this.mActionBar.getHeight() + al.jH(this);
      ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "lxl checkItemVisible actionbar height:%s, total height:%s, screenHeight:%s, top:%s, bottom:%s", new Object[] { Integer.valueOf(this.mActionBar.getHeight()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localRect.top), Integer.valueOf(localRect.bottom) });
      if ((localRect.bottom > j) && (i > localRect.top))
      {
        AppMethodBeat.o(198459);
        return true;
      }
    }
    catch (Throwable paramView)
    {
      ad.e("MicroMsg.SnsTimeLineUI.ScreenShot", paramView.toString());
      AppMethodBeat.o(198459);
      return false;
    }
    AppMethodBeat.o(198459);
    return false;
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(198458);
    ad.i("MicroMsg.SnsTimeLineUI", "onOtherAddSize respMaxSeq:%s, respMinSeq:%s", new Object[] { paramString1, paramString2 });
    this.Alp.removeCallbacks(this.AkO);
    com.tencent.mm.vending.g.g.fOf().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(198458);
  }
  
  public final void a(final String paramString, boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99373);
    this.Alp.removeCallbacks(this.AkO);
    com.tencent.mm.vending.g.g.fOf().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(99373);
  }
  
  public final void aBD()
  {
    AppMethodBeat.i(99396);
    akA().bk(c.b.class);
    AppMethodBeat.o(99396);
  }
  
  public final void aBE() {}
  
  public final void aBF()
  {
    AppMethodBeat.i(99397);
    if (this.AlA)
    {
      AppMethodBeat.o(99397);
      return;
    }
    ad.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
    this.AlA = true;
    ag.cVf().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179284);
        if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
          SnsTimeLineUI.a(SnsTimeLineUI.this).Ard.notifyVendingDataChange();
        }
        SnsTimeLineUI.ab(SnsTimeLineUI.this);
        AppMethodBeat.o(179284);
      }
    }, 1000L);
    AppMethodBeat.o(99397);
  }
  
  public final void aBG()
  {
    AppMethodBeat.i(99400);
    akA().bk(c.b.class);
    AppMethodBeat.o(99400);
  }
  
  public final void b(final String paramString, final boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99374);
    this.Alp.removeCallbacks(this.AkO);
    com.tencent.mm.vending.g.g.fOf().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
    {
      private Void a(Void paramAnonymousVoid)
      {
        AppMethodBeat.i(198409);
        if (SnsTimeLineUI.l(SnsTimeLineUI.this) != null)
        {
          SnsTimeLineUI.m(SnsTimeLineUI.this);
          SnsTimeLineUI.l(SnsTimeLineUI.this).edk();
        }
        SnsTimeLineUI.d(SnsTimeLineUI.this).oKD = paramb.dSr();
        if (SnsTimeLineUI.this.Alv == 0)
        {
          ad.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[] { Boolean.valueOf(paramb.dSr()) });
          if (paramb.dSr()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).aAU(paramb.dSx());
          }
          AppMethodBeat.o(198409);
          return paramAnonymousVoid;
        }
        if ((paramBoolean) && (!SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))))
        {
          SnsTimeLineUI.d(SnsTimeLineUI.this).oKD = true;
          SnsTimeLineUI.d(SnsTimeLineUI.this).aAI(paramb.dSx());
        }
        for (;;)
        {
          AppMethodBeat.o(198409);
          return paramAnonymousVoid;
          if ((SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))) && (paramb.dSw() != 0L))
          {
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IxP, Long.valueOf(paramb.dSw()));
          }
          if (paramb.dSr()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).aAU(paramb.dSx());
          }
        }
      }
    });
    AppMethodBeat.o(99374);
  }
  
  public final boolean dZN()
  {
    AppMethodBeat.i(99395);
    if ((this.Akp == null) || (this.Akp.zPn == null))
    {
      AppMethodBeat.o(99395);
      return false;
    }
    if ((this.Akp == null) || (this.Akp.zPo == null))
    {
      if ((this.Akp != null) && (this.Akp.zPq != null)) {
        break label118;
      }
      label65:
      if ((this.Akp != null) && (this.Akp.zPr != null)) {
        break label132;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.dQX();
      boolean bool = this.Akp.zPn.dZN();
      AppMethodBeat.o(99395);
      return bool;
      this.Akp.zPo.dVw();
      break;
      label118:
      this.Akp.zPq.dVw();
      break label65;
      label132:
      this.Akp.zPr.edR();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(99378);
    ad.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[] { paramKeyEvent.toString() });
    int k = keyboardState();
    i locali = this.Akp;
    int i = j;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      i = j;
      if (locali.zPg.getVisibility() == 0)
      {
        locali.zPg.setVisibility(8);
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
  
  public final com.tencent.mm.plugin.sns.ad.d.i ecW()
  {
    return this.Abd;
  }
  
  public final boolean fh(View paramView)
  {
    AppMethodBeat.i(99394);
    this.Akp.zPo.dVw();
    this.Akp.zPq.dVw();
    bp localbp = this.Akp.zPn;
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      ad.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
      AppMethodBeat.o(99394);
      return false;
    }
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    Object localObject1 = localBaseViewHolder.doX;
    if (localbp.Aqs != null)
    {
      if ((localbp.Aqs.getTag() instanceof bp.a))
      {
        localObject2 = (bp.a)localbp.Aqs.getTag();
        if (((bp.a)localObject2).zpy.equals(localObject1))
        {
          localbp.fm(((bp.a)localObject2).yXL);
          AppMethodBeat.o(99394);
          return true;
        }
        localbp.dZN();
      }
      localbp.Aqs = null;
    }
    localbp.Aqs = new SnsCommentShowAbLayout(localbp.mContext);
    com.tencent.mm.sdk.platformtools.q.fke();
    localbp.Aqs.setId(2131296470);
    new FrameLayout.LayoutParams(-1, -1);
    localbp.zpe.addView(localbp.Aqs);
    int i = BackwardSupportUtil.b.g(localbp.mContext, 192.0F);
    int j = BackwardSupportUtil.b.g(localbp.mContext, 76.0F);
    int k = BackwardSupportUtil.b.g(localbp.mContext, 8.0F);
    BackwardSupportUtil.b.g(localbp.mContext, 16.0F);
    int m = BackwardSupportUtil.b.g(localbp.mContext, 40.0F);
    Object localObject2 = z.jO(localbp.mContext).inflate(2131495535, null);
    new Rect();
    Object localObject3 = new int[2];
    com.tencent.mm.pluginsdk.h.hm(localbp.mContext);
    int n = com.tencent.mm.cc.a.fromDPToPix(localbp.mContext, 1);
    paramView.getLocationInWindow((int[])localObject3);
    localbp.yYM = al.jH(localbp.mContext);
    ad.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + n + " height_hardcode:" + j + " statusBarHeight: " + localbp.yYM);
    localObject3 = new AbsoluteLayout.LayoutParams(-2, -2, localObject3[0] - i - k, localObject3[1] - n - (m / 2 - paramView.getMeasuredHeight() / 2));
    localObject1 = new bp.a(localbp, (String)localObject1, (View)localObject2);
    localbp.Aqs.setTag(localObject1);
    localbp.Aqs.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    if (localBaseViewHolder.oIb == 10) {
      ((View)localObject2).findViewById(2131296548).setBackgroundResource(2131232447);
    }
    ((View)localObject2).setVisibility(8);
    new com.tencent.mm.sdk.platformtools.ap().post(new bp.1(localbp, paramView, (View)localObject2));
    AppMethodBeat.o(99394);
    return true;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(99399);
    ad.d("MicroMsg.SnsTimeLineUI", "finalize");
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
    this.mUIAction.zqQ.setDrawingCacheEnabled(false);
    this.Akp.zpe = ((FrameLayout)findViewById(2131305824));
    int i = ag.dUm().position;
    Object localObject = (AdListView)this.mUIAction.getSnsListView();
    ((AdListView)localObject).zNz = this.Abd;
    ((AdListView)localObject).setTimelineStat(this.Akx);
    ((AdListView)localObject).setTimelineEvent(this.Aky);
    this.Aky.a(ag.dTV());
    ad.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.zPl, new Object[] { Integer.valueOf(i) });
    this.Akm = ((QFadeImageView)findViewById(2131305048));
    this.Akm.setImageResource(2131690250);
    this.Akr = new a(this.mUIAction.getSnsListView());
    this.Akr.setInterpolator(new LinearInterpolator());
    this.Akr.setAnimationListener(new SnsTimeLineUI.41(this));
    localObject = null;
    if (this.Alv == 1)
    {
      this.Ako = true;
      localObject = new com.tencent.mm.plugin.sns.ui.a.b.d(this.lEN, this.zRo);
    }
    this.Akj = new com.tencent.mm.plugin.sns.ui.a.c(this, this.mUIAction.getSnsListView(), this.Akp.zPs, this.Akp, this.Akz, (com.tencent.mm.plugin.sns.ui.a.b.b)localObject, this.AkR);
    this.Akp.zPs.Azd = new bh.b()
    {
      public final boolean ecP()
      {
        AppMethodBeat.i(198438);
        SnsTimeLineUI.this.akA().bk(c.b.class);
        AppMethodBeat.o(198438);
        return false;
      }
    };
    this.Akp.zpI = this.Akj.Arc;
    this.Akj.Ard.LgP = new com.tencent.mm.vending.a.b.a()
    {
      public final void edg()
      {
        AppMethodBeat.i(198439);
        com.tencent.mm.plugin.report.service.f.Oj(14);
        AppMethodBeat.o(198439);
      }
      
      public final void edh()
      {
        AppMethodBeat.i(198440);
        com.tencent.mm.plugin.report.service.f.Ok(14);
        AppMethodBeat.o(198440);
      }
    };
    this.Aks = ((TestTimeForSns)this.Akp.zpe);
    this.Aks.setListener(new TestTimeForSns.a()
    {
      public final void cWa()
      {
        AppMethodBeat.i(198441);
        ad.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
        SnsTimeLineUI.H(SnsTimeLineUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176335);
            if ((SnsTimeLineUI.a(SnsTimeLineUI.this) == null) || (SnsTimeLineUI.H(SnsTimeLineUI.this) == null))
            {
              ad.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
              AppMethodBeat.o(176335);
              return;
            }
            SnsTimeLineUI.H(SnsTimeLineUI.this).setListener(null);
            SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.N(SnsTimeLineUI.this));
            if (SnsTimeLineUI.O(SnsTimeLineUI.this))
            {
              ad.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
              AppMethodBeat.o(176335);
              return;
            }
            if (SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              ag.dTU().V(ag.dUm().zlh, -1);
              ag.dTU().zR(ag.dUm().zli);
            }
            if (!SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              ad.i("MicroMsg.SnsTimeLineUI", "onViewDrawed doFpList");
              com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
              SnsTimeLineUI.n(SnsTimeLineUI.this);
              localc.d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFc, Integer.valueOf(1));
            }
            SnsTimeLineUI.a(SnsTimeLineUI.this, false);
            if (SnsTimeLineUI.this.Abd != null) {
              SnsTimeLineUI.this.Abd.rj(false);
            }
            AppMethodBeat.o(176335);
          }
        });
        AppMethodBeat.o(198441);
      }
    });
    this.mUIAction.list.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198442);
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          SnsTimeLineUI.this.dZN();
          if ((SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) && (SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() == 0)) {
            ad.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
          }
          SnsTimeLineUI.l(SnsTimeLineUI.this).edl();
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          }
          SnsTimeLineUI.k(SnsTimeLineUI.this).dZw();
          SnsTimeLineUI.k(SnsTimeLineUI.this).zPh.edQ();
        }
        AppMethodBeat.o(198442);
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
        SnsTimeLineUI.k(SnsTimeLineUI.this).zPh.AaL = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getBottom();
        SnsTimeLineUI.k(SnsTimeLineUI.this).zPh.Aqx = SnsTimeLineUI.d(SnsTimeLineUI.this).vHW.getTop();
        SnsTimeLineUI.l(SnsTimeLineUI.this).Amf = com.tencent.mm.ui.aq.fromDPToPix(SnsTimeLineUI.this.getContext(), -44);
        AppMethodBeat.o(176343);
      }
    });
    this.mUIAction.vHW.setOnSrcollDistance(new MMPullDownView.f()
    {
      public final void bG(float paramAnonymousFloat)
      {
        AppMethodBeat.i(198443);
        SnsTimeLineUI.P(SnsTimeLineUI.this);
        if (SnsTimeLineUI.Alj.booleanValue()) {
          ad.i("MicroMsg.SnsTimeLineUI", "mUIAction.header.getTop %s originalHeaderTop %s distanceY %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).zqQ.getTop()), Integer.valueOf(SnsTimeLineUI.l(SnsTimeLineUI.this).Amf), Float.valueOf(paramAnonymousFloat) });
        }
        if (((SnsTimeLineUI.d(SnsTimeLineUI.this).zqQ.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).Amf) || (paramAnonymousFloat > 0.0F)) && (!SnsTimeLineUI.d(SnsTimeLineUI.this).zVQ)) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).bH(paramAnonymousFloat);
        }
        SnsTimeLineUI.k(SnsTimeLineUI.this).dZw();
        SnsTimeLineUI.this.dZN();
        SnsTimeLineUI.k(SnsTimeLineUI.this).zPh.edQ();
        AppMethodBeat.o(198443);
      }
      
      public final void edi()
      {
        AppMethodBeat.i(198444);
        if (!SnsTimeLineUI.d(SnsTimeLineUI.this).zVQ) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).edl();
        }
        AppMethodBeat.o(198444);
      }
    });
    this.Akp.zPg = ((SnsCommentFooter)findViewById(2131298521));
    this.Akp.zPg.post(new SnsTimeLineUI.49(this));
    this.Akp.zPh = new bq(this.mUIAction.list, this.Akp.zPg);
    this.Akk = ((LinearLayout)this.mUIAction.zqQ.findViewById(2131305028));
    this.Akk.findViewById(2131305024).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179269);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).zPc != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).zPc.zkL.rp(true);
        }
        paramAnonymousView = (c.b)SnsTimeLineUI.this.akA().w(c.b.class);
        localObject = com.tencent.mm.modelsns.e.pV(725);
        ((com.tencent.mm.modelsns.e)localObject).pY(paramAnonymousView.tFE);
        ((com.tencent.mm.modelsns.e)localObject).aLk();
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
        paramAnonymousView.putExtra("sns_msg_comment_list_scene", 1);
        SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 13);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179269);
      }
    });
    this.Akl = ((LinearLayout)this.mUIAction.zqQ.findViewById(2131305029));
    this.Akp.zPi = new ay(this);
    ecS();
    dLt();
    boolean bool1;
    label591:
    boolean bool2;
    if (this.Alv == 0)
    {
      setMMTitle(2131764037);
      if ((!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.i.DEBUG)) {
        break label923;
      }
      bool1 = true;
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFb, 0)) {
        break label928;
      }
      bool2 = true;
      label615:
      ad.i("MicroMsg.SnsTimeLineUI", "getGpuMaxTextureSize %s %s.", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1)
      {
        bool1 = bool3;
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      com.tencent.mm.sdk.platformtools.q.wF(bool1);
      if (bool1)
      {
        i = com.tencent.mm.sdk.platformtools.q.fkf();
        if (i > 2048) {
          break label933;
        }
        com.tencent.mm.plugin.report.service.g.yhR.dD(1198, 7);
      }
    }
    for (;;)
    {
      this.AkH = ((ViewGroup)findViewById(2131305092));
      this.AkH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198445);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$55", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          SnsTimeLineUI.k(SnsTimeLineUI.this).dZB();
          com.tencent.mm.plugin.sns.j.e.ztz.zuf.eoK = 2L;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$55", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198445);
        }
      });
      this.AkH.setVisibility(4);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = (com.tencent.mm.ui.aq.fromDPToPix(getContext(), 24) + com.tencent.mm.ui.ar.dT(getContext()) + com.tencent.mm.ui.ar.jG(getContext()));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.AkH.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(99388);
      return;
      if (this.zRo)
      {
        setMMTitle(2131763939);
        Ro(8);
        break;
      }
      ad.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, userName:%s, title:%s", new Object[] { this.lEN, this.mUIAction.title });
      localObject = ag.dTS().Bf(this.lEN);
      if (localObject != null) {
        ad.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is not null");
      }
      for (localObject = ((com.tencent.mm.o.b)localObject).adv();; localObject = this.mUIAction.title)
      {
        setMMTitle(com.tencent.mm.plugin.sns.data.q.O((CharSequence)localObject));
        break;
        ad.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is null, title:%s", new Object[] { this.mUIAction.title });
      }
      label923:
      bool1 = false;
      break label591;
      label928:
      bool2 = false;
      break label615;
      label933:
      if (i <= 4096) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1198, 8);
      } else if (i <= 6144) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1198, 9);
      } else if (i <= 8192) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1198, 10);
      } else {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1198, 11);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99402);
    ad.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 15)
    {
      if ((this.Akp != null) && (this.Akp.zPs != null) && (this.Akp.zPs.Ayq != null))
      {
        this.Akp.zPs.Ayq.onActivityResult(paramInt1, paramInt2, paramIntent);
        com.tencent.mm.sdk.platformtools.aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198455);
            SnsTimeLineUI.this.hideVKB();
            AppMethodBeat.o(198455);
          }
        }, 300L);
      }
      AppMethodBeat.o(99402);
      return;
    }
    if (paramInt1 == 16)
    {
      ad.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
      AppMethodBeat.o(99402);
      return;
    }
    if ((paramInt1 == 2333) && (paramIntent != null))
    {
      Object localObject = paramIntent.getStringExtra("Select_Contact");
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split(",");
        if (localObject.length > 0)
        {
          this.Akp.zPg.fLP.showVKB();
          String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(localObject[0]);
          if (!bt.isNullOrNil(str))
          {
            this.Akp.zPg.ebS();
            this.Akp.zPg.setText("@" + str + " ");
            this.Akp.zPg.setCommentAtPrefix("@" + str + " ");
            this.Akp.zPg.setCommentInfo(new dfn());
            this.Akp.zPg.getCommentInfo().Username = localObject[0];
            this.Akp.zPg.setCommentFlag(8);
          }
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mUIAction.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 11)
    {
      this.Aki.d(this.lEN, this.AkA, this.zRo, this.AkB);
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
    ad.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
    com.tencent.mm.sdk.b.a.IbL.l(new ci());
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    Point localPoint = new Point();
    localPoint.x = paramConfiguration.widthPixels;
    localPoint.y = paramConfiguration.heightPixels;
    ag.i(localPoint);
    com.tencent.mm.plugin.sns.ui.widget.f.efe().ACY = 0;
    com.tencent.mm.plugin.sns.ui.widget.d.efb().ACY = 0;
    com.tencent.mm.kiss.widget.textview.c.gEJ.akE();
    this.Akj.Arc.ecF();
    this.Akj.Ard.resolvedClear();
    AppMethodBeat.o(99382);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99379);
    Object localObject1;
    if (AkD == null)
    {
      AkD = Boolean.valueOf(al.isDarkMode());
      com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
      com.tencent.mm.plugin.sns.model.b.a.dVo();
      localObject1 = ag.dUc();
      ((aw)localObject1).isZ = true;
      ad.i("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", new Object[] { Boolean.valueOf(((aw)localObject1).isZ) });
      if (((((aw)localObject1).isZ) && (!com.tencent.mm.plugin.sns.model.b.a.dVp())) || (((aw)localObject1).isY)) {
        ((aw)localObject1).dUZ();
      }
      o.aML().eW(((aw)localObject1).isZ);
      localObject1 = ag.dUn();
      if (!com.tencent.mm.sdk.platformtools.i.DEBUG) {
        break label1062;
      }
      ((com.tencent.mm.plugin.sns.model.at)localObject1).zlU = true;
      ((com.tencent.mm.plugin.sns.model.at)localObject1).zlV = 1L;
      ((com.tencent.mm.plugin.sns.model.at)localObject1).zlW = 86400L;
      ((com.tencent.mm.plugin.sns.model.at)localObject1).zlX = 1;
      ((com.tencent.mm.plugin.sns.model.at)localObject1).zlY = 1;
      ((com.tencent.mm.plugin.sns.model.at)localObject1).zlZ = 50;
      ((com.tencent.mm.plugin.sns.model.at)localObject1).zmb = 2;
      ((com.tencent.mm.plugin.sns.model.at)localObject1).zma = 5;
      ((com.tencent.mm.plugin.sns.model.at)localObject1).zmc = 0L;
      label168:
      ad.i("MicroMsg.SnsUnreadTipManager", "jumpEnable:%s, jumpMinInterval:%s, jumpMaxInterval:%s, jumpMinFeedsCount:%s, jumpMinFeedsGapCount:%s, jumpNotWsPercent:%s, jumpIndicatorIndexOffset:%s, jumpReadContinuousCount:%s, jumpIndicatorExposeInterval:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zlU), Long.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zlV), Long.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zlW), Integer.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zlX), Integer.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zlY), Integer.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zlZ), Integer.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zmb), Integer.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zma), Long.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zmc) });
      if (((com.tencent.mm.plugin.sns.model.at)localObject1).zlU) {
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zlT = (ag.getAccSnsPath() + "snsUnread.proto");
      }
    }
    int i;
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.mm.vfs.i.aY(((com.tencent.mm.plugin.sns.model.at)localObject1).zlT, 0, -1);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          ((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.parseFrom((byte[])localObject2);
          i = cf.aCN();
          ad.i("MicroMsg.SnsUnreadTipManager", "unreadSnsIdList.indicatorExposeTime:%s, now:%s, jumpIndicatorExposeInterval:%s", new Object[] { Long.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.zmu), Integer.valueOf(i), Long.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zmc) });
          if ((((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.zmu <= 0L) || (i - ((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.zmu <= ((com.tencent.mm.plugin.sns.model.at)localObject1).zmc)) {
            continue;
          }
          ((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.zmu = 0L;
          ((com.tencent.mm.plugin.sns.model.at)localObject1).zmu = ((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.zmu;
          ((com.tencent.mm.plugin.sns.model.at)localObject1).dUS();
        }
      }
      catch (IOException localIOException)
      {
        Object localObject2;
        label1062:
        ad.w("MicroMsg.SnsUnreadTipManager", "IOException:%s", new Object[] { localIOException.getMessage() });
        continue;
        bool = false;
        continue;
        com.tencent.mm.plugin.sns.model.aq.zlA = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBo, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBn, 1) != 1) {
          continue;
        }
        bool = true;
        com.tencent.mm.plugin.sns.model.aq.zlB = bool;
        com.tencent.mm.plugin.sns.model.aq.zlC = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBp, 60);
        continue;
        bool = false;
        continue;
        long l = com.tencent.mm.plugin.sns.model.aq.zlA - bt.Df(((com.tencent.mm.plugin.sns.model.aq)localObject1).zlD);
        ad.i(com.tencent.mm.plugin.sns.model.aq.TAG, "delay %s to reset", new Object[] { Long.valueOf(l) });
        com.tencent.mm.sdk.platformtools.aq.o(((com.tencent.mm.plugin.sns.model.aq)localObject1).zlH, l);
        continue;
        this.wQp = findViewById(2131296345);
        if (this.wQp == null) {
          break label1723;
        }
      }
      ((com.tencent.mm.plugin.sns.model.at)localObject1).dUQ();
      ((com.tencent.mm.plugin.sns.model.at)localObject1).dUR();
      ad.i("MicroMsg.SnsUnreadTipManager", "firstUnreadId:%s unreadSnsIdList.lastSnsId:%s", new Object[] { Long.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zmh), Long.valueOf(((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.zqJ) });
      ((com.tencent.mm.plugin.sns.model.at)localObject1).dUT();
      ((com.tencent.mm.plugin.sns.model.at)localObject1).sessionId = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnd();
      localObject1 = ((com.tencent.mm.plugin.sns.model.at)localObject1).zmA;
      com.tencent.mm.kernel.g.ajB().gAO.a(211, (com.tencent.mm.al.f)localObject1);
      localObject1 = ag.dUo();
      ad.i(com.tencent.mm.plugin.sns.model.aq.TAG, "create");
      if ((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE))
      {
        com.tencent.mm.plugin.sns.model.aq.zlA = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBo, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBn, 1) == 1)
        {
          bool = true;
          com.tencent.mm.plugin.sns.model.aq.zlB = bool;
          com.tencent.mm.plugin.sns.model.aq.zlC = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBp, 60);
          ad.i(com.tencent.mm.plugin.sns.model.aq.TAG, "updateConfig configEnable:%s, configInterval:%s, configExpiredTime:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.sns.model.aq.zlB), Integer.valueOf(com.tencent.mm.plugin.sns.model.aq.zlC), Long.valueOf(com.tencent.mm.plugin.sns.model.aq.zlA) });
          if (((com.tencent.mm.plugin.sns.model.aq)localObject1).zlD != 0L)
          {
            if (bt.Df(((com.tencent.mm.plugin.sns.model.aq)localObject1).zlD) < com.tencent.mm.plugin.sns.model.aq.zlA) {
              continue;
            }
            ad.i(com.tencent.mm.plugin.sns.model.aq.TAG, "already expired, reset directly");
            com.tencent.mm.sdk.platformtools.aq.f(((com.tencent.mm.plugin.sns.model.aq)localObject1).zlH);
            if (((com.tencent.mm.plugin.sns.model.aq)localObject1).zlF != null)
            {
              localObject2 = ak.v(((com.tencent.mm.plugin.sns.model.aq)localObject1).zlF);
              if (localObject2 != null)
              {
                com.tencent.mm.plugin.sns.j.e.ztz.zug.pi(((com.tencent.mm.plugin.sns.model.aq)localObject1).zlG);
                com.tencent.mm.plugin.sns.j.e.ztz.zug.ph(com.tencent.mm.plugin.sns.data.q.zx(((com.tencent.mm.plugin.sns.model.aq)localObject1).zlF.field_snsId));
                com.tencent.mm.plugin.sns.j.e.ztz.zug.eoO = ((SnsObject)localObject2).LikeCount;
                com.tencent.mm.plugin.sns.j.e.ztz.zug.eoP = ((SnsObject)localObject2).CommentCount;
                com.tencent.mm.plugin.sns.j.e.ztz.zug.pj(String.valueOf(System.currentTimeMillis()));
                com.tencent.mm.plugin.sns.j.e.ztz.zuh.pi(((com.tencent.mm.plugin.sns.model.aq)localObject1).zlG);
                com.tencent.mm.plugin.sns.j.e.ztz.zuh.ph(com.tencent.mm.plugin.sns.data.q.zx(((com.tencent.mm.plugin.sns.model.aq)localObject1).zlF.field_snsId));
                com.tencent.mm.plugin.sns.j.e.ztz.zuh.eoO = ((SnsObject)localObject2).LikeCount;
                com.tencent.mm.plugin.sns.j.e.ztz.zuh.eoP = ((SnsObject)localObject2).CommentCount;
                com.tencent.mm.plugin.sns.j.e.ztz.zuh.pj(String.valueOf(System.currentTimeMillis()));
              }
            }
          }
          if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class) != null) {
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WO("__sns_timeline__");
          }
          if (this.mController != null) {
            this.mController.be(2, true);
          }
          getIntent().setExtrasClassLoader(getClass().getClassLoader());
          com.tencent.mm.pluginsdk.h.q(this);
          customfixStatusbar(true);
          super.onCreate(paramBundle);
          if (com.tencent.mm.kernel.g.ajA().aiK()) {
            continue;
          }
          finish();
          AppMethodBeat.o(99379);
          return;
          if (AkD.booleanValue() == al.isDarkMode()) {
            break;
          }
          ad.i("MicroMsg.SnsTimeLineUI", "dancy test UIMode change!!");
          AkD = Boolean.valueOf(al.isDarkMode());
          com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
          break;
          if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE))
          {
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlU = true;
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlV = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGy, 120L);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlX = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGz, 5);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlY = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGB, 3);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlW = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGC, 86400L);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlZ = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGD, 50);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zmb = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGF, 5);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zma = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGE, 30);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zmc = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGG, 0);
            break label168;
          }
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGA, 0) == 1)
          {
            bool = true;
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlU = bool;
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlV = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGy, 0);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlX = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGz, 0);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlY = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGB, 0);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlW = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGC, 86400L);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zlZ = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGD, 50);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zmb = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGF, 5);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zma = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGE, 30);
            ((com.tencent.mm.plugin.sns.model.at)localObject1).zmc = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGG, 0);
            break label168;
          }
          bool = false;
          continue;
          if (((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.zmu >= 0L) {
            continue;
          }
          ((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.zmu = 0L;
          continue;
        }
      }
      if (com.tencent.mm.ui.statusbar.c.KDc) {
        break label4068;
      }
    }
    label1723:
    getWindow().getDecorView().setSystemUiVisibility(1280);
    paramBundle = aj.fkD();
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("Main_need_read_top_margin", false);; bool = false)
    {
      com.tencent.mm.ui.b.c(this, bool);
      this.Akq = ((int)(getResources().getDisplayMetrics().heightPixels * 0.4D));
      setActionbarColor(getContext().getResources().getColor(2131101053));
      hideActionbarLine();
      this.Alv = getIntent().getIntExtra("sns_adapter_type", 0);
      this.Ako = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
      this.mActionBar = getSupportActionBar();
      i = com.tencent.mm.model.c.d.aDt().gm("Sns_Private_Recent_Setting_Guide", 0);
      ad.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = ".concat(String.valueOf(i)));
      if (i == 1)
      {
        com.tencent.mm.kernel.g.ajD();
        if (!com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IxU, false))
        {
          paramBundle = getIntent();
          paramBundle.setClass(getContext(), SnsSettingIntroduceUI.class);
          paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahp(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramBundle.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          overridePendingTransition(0, 0);
          finish();
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IxU, Boolean.TRUE);
        }
      }
      this.AkG.Agg = new bc.b()
      {
        public final void ecq()
        {
          AppMethodBeat.i(198427);
          SnsTimeLineUI.I(SnsTimeLineUI.this);
          AppMethodBeat.o(198427);
        }
      };
      ecR();
      com.tencent.e.h.LTJ.aR(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198428);
          ad.i("MicroMsg.SnsTimeLineUI", "%s", new Object[] { com.tencent.mm.plugin.performance.c.c.dyZ().M(true, 0) });
          AppMethodBeat.o(198428);
        }
      });
      this.Akh.a(c.b.class, this.Alt);
      localObject1 = this.Aki;
      i = this.Alv;
      paramBundle = getIntent();
      com.tencent.mm.plugin.sns.l.b localb = this.Akg;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).Alv = i;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = true;
      Object localObject3;
      if (i == 0)
      {
        localObject3 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).Arz;
        ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject3).Akg = localb;
        if (localb != null)
        {
          paramBundle = localb.efh();
          label2124:
          ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject3).Akh = paramBundle;
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).Arz.Akh.a(this);
          label2142:
          paramBundle = this.Aki;
          if (paramBundle.Alv != 0) {
            break label4288;
          }
          paramBundle = (com.tencent.mm.plugin.sns.l.c.a)paramBundle.Arz.Akh.w(com.tencent.mm.plugin.sns.l.c.a.class);
          label2171:
          this.lEN = paramBundle.lEN;
          this.Akz = paramBundle.Akz;
          this.AkA = paramBundle.AkA;
          this.zRo = paramBundle.zRo;
          this.AkB = paramBundle.AkB;
          localObject1 = paramBundle.jqQ;
          paramBundle = paramBundle.cff;
          this.mSessionId = com.tencent.mm.ui.e.aix("123");
          this.AkC = String.valueOf(System.currentTimeMillis());
          this.mUIAction = new SnsUIAction(this);
          this.mUIAction.setSessionId(this.mSessionId);
          this.mUIAction.zsC = this.AkC;
          this.mUIAction.AnR = this.Alr;
          this.mUIAction.actionbarView = this.mActionBar.getCustomView();
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().kO(2);
          com.tencent.mm.plugin.sns.ui.widget.f.efe().ACY = 0;
          com.tencent.mm.plugin.sns.ui.widget.d.efb().ACY = 0;
          localObject3 = com.tencent.mm.modelsns.f.inr;
          com.tencent.mm.modelsns.f.aLl();
          if (!getIntent().getBooleanExtra("is_sns_notify_open", true)) {
            break label4296;
          }
          i = 1;
          label2359:
          this.Akp = new i(this, i, bt.bI(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0), this.AkC);
          this.Akp.zPf = new i.b()
          {
            public final void dZB()
            {
              AppMethodBeat.i(198429);
              com.tencent.mm.plugin.report.service.g.yhR.dD(1295, 2);
              Object localObject = ag.dUn();
              if (((com.tencent.mm.plugin.sns.model.at)localObject).zlU) {
                ag.dFL().post(new at.4((com.tencent.mm.plugin.sns.model.at)localObject));
              }
              com.tencent.mm.plugin.sns.j.e.ztz.zuf.eoJ = 1L;
              localObject = ag.dUn();
              int i;
              if ((!((com.tencent.mm.plugin.sns.model.at)localObject).dUP()) || (((com.tencent.mm.plugin.sns.model.at)localObject).zmf.get(((com.tencent.mm.plugin.sns.model.at)localObject).zmr.rtu.peek()) == null))
              {
                i = -1;
                localObject = ag.dUn();
                if (((com.tencent.mm.plugin.sns.model.at)localObject).dUP()) {
                  break label390;
                }
              }
              com.tencent.mm.hellhoundlib.b.a locala;
              label390:
              for (int j = 0;; j = ((com.tencent.mm.plugin.sns.model.at)localObject).zmr.rtu.size())
              {
                ad.d("MicroMsg.SnsTimeLineUI", "rightIndex:%s, targetSize:%s, adapter.count:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) });
                ag.dUn().eV(null);
                SnsTimeLineUI.J(SnsTimeLineUI.this).setVisibility(4);
                if ((i == -1) || (j + i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount())) {
                  break label405;
                }
                ag.dUn().dUX();
                ag.dUn().zml = 0L;
                j = SnsTimeLineUI.this.getResources().getDimensionPixelSize(2131166841);
                int k = com.tencent.mm.ui.ar.dT(SnsTimeLineUI.this.getContext());
                int m = com.tencent.mm.ui.ar.jG(SnsTimeLineUI.this.getContext());
                localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                locala = com.tencent.mm.hellhoundlib.b.c.a(i + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), com.tencent.mm.hellhoundlib.b.c.a(k + m - j, new com.tencent.mm.hellhoundlib.b.a()));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                ((ListView)localObject).smoothScrollToPositionFromTop(((Integer)locala.mq(0)).intValue(), ((Integer)locala.mq(1)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                AppMethodBeat.o(198429);
                return;
                i = ((Integer)((com.tencent.mm.plugin.sns.model.at)localObject).zmf.get(((com.tencent.mm.plugin.sns.model.at)localObject).zmr.rtu.peek())).intValue();
                break;
              }
              label405:
              if (!ag.dUn().zmo)
              {
                ag.dUn().dUX();
                ag.dUn().zmo = true;
                SnsTimeLineUI.a(SnsTimeLineUI.this).Ard.aAW(com.tencent.mm.plugin.sns.data.q.zx(SnsTimeLineUI.a(SnsTimeLineUI.this).edT()));
                SnsTimeLineUI.a(SnsTimeLineUI.this).Ard.aAX(com.tencent.mm.plugin.sns.data.q.zx(SnsTimeLineUI.a(SnsTimeLineUI.this).rZ(false)));
                ag.dUn().zml = ag.dUn().dUV();
                ag.dTU().zR(ag.dUn().dUV());
                ag.dUn().zmm = au.zmL;
                localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                locala = com.tencent.mm.hellhoundlib.b.c.a(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount() - 1 + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                ((ListView)localObject).smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
                {
                  SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
                  SnsTimeLineUI.B(SnsTimeLineUI.this).post(SnsTimeLineUI.C(SnsTimeLineUI.this));
                }
              }
              AppMethodBeat.o(198429);
            }
          };
          this.zPl = getIntent().getBooleanExtra("sns_resume_state", true);
          if (!ag.dTN()) {
            break label4301;
          }
          this.zPl = false;
          label2444:
          this.Akn = this.zPl;
          this.mUIAction.a(this.Akz, this.lEN, (String)localObject1, paramBundle, this.AkA, this.zRo, this.AkB);
          this.mUIAction.onCreate();
          ag.dTV().init();
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(213, this);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(682, this);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(218, this);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(211, this);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(683, this);
          com.tencent.mm.plugin.sns.ui.video.d.eeK().eeL();
          initView();
          paramBundle = ag.dTV();
          localObject1 = this.mUIAction.list;
          localObject3 = this.Akj.Arc;
          paramBundle.zpH = ((ListView)localObject1);
          paramBundle.zpI = ((bh)localObject3);
          paramBundle = ag.dTV();
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(291, paramBundle);
          this.Akp.rBg = ((ClipboardManager)aj.getContext().getSystemService("clipboard"));
          if (!ag.dTN()) {
            break label4321;
          }
          this.zPl = false;
          label2675:
          paramBundle = this.Akh;
          paramBundle.Ard = this.Akj.Ard;
          localObject1 = paramBundle.Ard;
          paramBundle.LgQ.keep((com.tencent.mm.vending.e.a)localObject1);
          if ((!this.zPl) || (this.Alv != 0)) {
            break label4341;
          }
          this.Ako = false;
          int j = ag.dUm().position;
          this.Akj.Ard.aAY(ag.dUm().rdV);
          this.Akj.Ard.aAV(ag.dUm().zVL);
          this.Akj.Ard.sa(true);
          this.Akj.Ard.aAZ(ag.dUm().zVO);
          this.Akj.Ard.aAW(ag.dUm().zVM);
          this.Akj.Ard.aAX(ag.dUm().zVN);
          this.mUIAction.rW(ag.dUm().zVQ);
          this.Akj.vw();
          i = j;
          if (j >= this.Akj.getCount())
          {
            i = this.Akj.getCount() - 1;
            ad.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[] { Integer.valueOf(this.Akj.getCount()) });
          }
          this.mUIAction.list.setAdapter(this.Akj);
          ad.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[] { Integer.valueOf(ag.dUm().zVP) });
          this.mUIAction.list.setSelectionFromTop(i, ag.dUm().zVP);
          Ro(4);
          label2953:
          ecQ();
          i = this.Akj.getCount();
          j = this.mUIAction.list.getFirstVisiblePosition();
          if (j < i) {
            this.Akv = com.tencent.mm.plugin.sns.data.q.n(this.Akj.QT(j));
          }
          com.tencent.mm.kernel.g.ajD();
          this.Akt = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(327776, Integer.valueOf(0))).intValue();
          this.Akp.zPn = new bp(this, this.Akj.Arc, this.Akp.zpe);
          this.Akp.zPp = new com.tencent.mm.plugin.sns.h.b(this, this.Akj.Arc.zpd, this.Akp.zpe);
          this.Akp.zPo = new b(this, this.Akj.Arc.zpd, this.Akp.zpe, this.Akp.zPp);
          this.Akp.zPo.zbv = this.Abd;
          this.Akp.zPq = new am(this, this.Akj.Arc.zpd, this.Akp.zpe);
          this.Akp.zPr = new br(this, this.Akj.Arc.zpd, this.Akp.zpe);
          if (this.Aky != null) {
            this.Aky.a(this.Akp.zPp);
          }
          if (i > 0)
          {
            paramBundle = this.Akj.QT(0);
            if ((this.Akp.zPc != null) && (this.Akp.zPc.zkL != null)) {
              this.Akp.zPc.zkL.zrm = paramBundle.field_snsId;
            }
            paramBundle = com.tencent.mm.plugin.sns.j.e.ztz;
            if (paramBundle.gwV != 0)
            {
              if (paramBundle.ztA.isEmpty())
              {
                paramBundle.fFB.setLong(2, bt.aQJ());
                paramBundle.ztB.clear();
              }
              ad.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[] { Integer.valueOf(paramBundle.ztA.size()) });
            }
          }
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(13312, "1," + bt.flT());
          com.tencent.mm.sdk.b.a.IbL.c(this.AkP);
          if (getIntent().getBooleanExtra("is_need_resend_sns", false))
          {
            com.tencent.mm.sdk.platformtools.aq.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99317);
                com.tencent.mm.ui.base.h.e(SnsTimeLineUI.this, SnsTimeLineUI.this.getString(2131761704), "", SnsTimeLineUI.this.getString(2131761705), SnsTimeLineUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(99307);
                    paramAnonymous2DialogInterface = new rn();
                    com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(99307);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(99308);
                    paramAnonymous2DialogInterface = new np();
                    com.tencent.mm.sdk.b.a.IbL.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(99308);
                  }
                });
                AppMethodBeat.o(99317);
              }
            }, 500L);
            getIntent().putExtra("is_need_resend_sns", false);
          }
          com.tencent.mm.kernel.g.ajD();
          if (com.tencent.mm.kernel.g.ajA().aiK())
          {
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajC().ajl().set(589825, Boolean.FALSE);
          }
          paramBundle = this.Akp;
          localObject1 = this.Abd;
          paramBundle.zPb = ((com.tencent.mm.plugin.sns.ad.d.i)localObject1);
          if (paramBundle.zPs != null) {
            paramBundle.zPs.b((com.tencent.mm.plugin.sns.ad.d.i)localObject1);
          }
          this.Abd.a(this.mUIAction.yXO, this.mActionBar.getCustomView(), this);
          com.tencent.mm.sdk.b.a.IbL.c(this.AkV);
          com.tencent.mm.sdk.b.a.IbL.c(this.AkW);
          com.tencent.mm.sdk.b.a.IbL.c(this.AkX);
          com.tencent.mm.sdk.b.a.IbL.c(this.AkY);
          com.tencent.mm.sdk.b.a.IbL.c(this.AkZ);
          com.tencent.mm.sdk.b.a.IbL.c(this.Alb);
          com.tencent.mm.sdk.b.a.IbL.c(this.Ala);
          com.tencent.mm.sdk.b.a.IbL.c(this.zlu);
          com.tencent.mm.sdk.b.a.IbL.c(this.Alc);
          com.tencent.mm.sdk.b.a.IbL.c(this.Ald);
          com.tencent.mm.sdk.b.a.IbL.c(this.Alf);
          com.tencent.mm.sdk.b.a.IbL.c(this.Ale);
          com.tencent.mm.sdk.b.a.IbL.c(this.Alg);
          com.tencent.mm.sdk.b.a.IbL.c(this.Ali);
          com.tencent.mm.plugin.sns.abtest.c.dRc();
          com.tencent.mm.plugin.sns.abtest.a.d(this, this.Akp.zpe);
          if (this.Akw != null)
          {
            paramBundle = this.Akw;
            localObject1 = this.mUIAction.list;
            localObject3 = this.mUIAction.zqQ;
            paramBundle.gZb = ((ListView)localObject1);
            paramBundle.zqQ = ((SnsHeader)localObject3);
          }
          if ((this.Akp != null) && (this.Akp.zPc != null))
          {
            paramBundle = this.Akp.zPc.zkL;
            ad.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
            paramBundle.zrl = true;
            paramBundle.ztj = System.currentTimeMillis();
          }
          bool = getIntent().getBooleanExtra("enter_by_red", false);
          if ((this.Akp != null) && (this.Akp.zPc != null))
          {
            paramBundle = this.Akp.zPc.zkL;
            if (!bool) {
              break label4370;
            }
            i = 1;
            label3816:
            paramBundle.zry = i;
          }
          ag.dUb().zgf.clear();
          if ((this.mUIAction != null) && (this.mUIAction.zqQ != null)) {
            this.mUIAction.zqQ.setStoryAction(new SnsStoryHeaderView.a()
            {
              public final void edf()
              {
                AppMethodBeat.i(198431);
                SnsTimeLineUI.a locala = SnsTimeLineUI.l(SnsTimeLineUI.this);
                if (SnsTimeLineUI.u(locala.AlB).getVisibility() == 0)
                {
                  locala.init();
                  SnsTimeLineUI.u(locala.AlB).clearAnimation();
                  SnsTimeLineUI.u(locala.AlB).startAnimation(locala);
                  locala.Aq(locala.DELAY_TIME + 100);
                  locala.Ame = false;
                }
                AppMethodBeat.o(198431);
              }
            });
          }
          if (!bt.isNullOrNil(u.aAu())) {
            break label4375;
          }
          this.AkN = 0;
          label3879:
          if ((!com.tencent.mm.sdk.platformtools.i.DEBUG) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) {
            break label4408;
          }
          paramBundle = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFA, "{\"enable\":1,\"max_count_no_user\":3,\"max_count_no_feed\":3,\"max_count_normal\":-1}");
          label3918:
          if (bt.isNullOrNil(paramBundle)) {}
        }
      }
      for (;;)
      {
        label4370:
        label4375:
        label4408:
        try
        {
          paramBundle = new JSONObject(paramBundle);
          if (paramBundle.getInt("enable") != 1) {
            continue;
          }
          bool = true;
          this.AkJ = bool;
          this.AkK = paramBundle.getInt("max_count_no_user");
          this.AkL = paramBundle.getInt("max_count_no_feed");
          this.AkM = paramBundle.getInt("max_count_normal");
        }
        catch (Exception paramBundle)
        {
          label4068:
          label4341:
          ad.w("MicroMsg.SnsTimeLineUI", "parse SnsFinderEntranceConfig fail. %s", new Object[] { paramBundle.getMessage() });
          label4288:
          label4296:
          label4301:
          label4321:
          continue;
        }
        ad.i("MicroMsg.SnsTimeLineUI", "curFinderStatus:%s, finderEntranceEnable:%s, finderEntranceMaxCountNoUser:%s, finderEntranceMaxCountNoFeed:%s, finderEntranceMaxCountNormal:%s", new Object[] { Integer.valueOf(this.AkN), Boolean.valueOf(this.AkJ), Integer.valueOf(this.AkK), Integer.valueOf(this.AkL), Integer.valueOf(this.AkM) });
        com.tencent.mm.sdk.b.a.IbL.c(this.AkQ);
        AppMethodBeat.o(99379);
        return;
        paramBundle = com.tencent.mm.ui.statusbar.c.bm(this);
        localObject1 = new com.tencent.mm.ui.statusbar.c.a()
        {
          public final void ua(int paramAnonymousInt)
          {
            AppMethodBeat.i(198411);
            SnsTimeLineUI.t(SnsTimeLineUI.this).setPadding(0, paramAnonymousInt, 0, 0);
            AppMethodBeat.o(198411);
          }
        };
        this.sgH = ((com.tencent.mm.ui.statusbar.c.a)localObject1);
        paramBundle.a((com.tencent.mm.ui.statusbar.c.a)localObject1);
        getWindow().getDecorView().requestApplyInsets();
        com.tencent.mm.ui.statusbar.d.b(getWindow());
        break;
        paramBundle = null;
        break label2124;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ArA = new com.tencent.mm.plugin.sns.l.c.a();
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ArA.lEN = paramBundle.getStringExtra("sns_userName");
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ArA.Akz = u.aAm();
        localObject3 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ArA;
        com.tencent.mm.kernel.g.ajD();
        ((com.tencent.mm.plugin.sns.l.c.a)localObject3).AkA = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTg(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ArA.lEN);
        localObject3 = u.aAm();
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ArA.zRo = ((String)localObject3).equals(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ArA.lEN);
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ArA.AkB = paramBundle.getIntExtra("sns_source", 0);
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ArA.jqQ = bt.bI(paramBundle.getStringExtra("sns_nickName"), "");
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ArA.cff = bt.bI(paramBundle.getStringExtra("sns_signature"), "");
        break label2142;
        paramBundle = paramBundle.ArA;
        break label2171;
        i = 0;
        break label2359;
        if (!this.zPl) {
          break label2444;
        }
        this.zPl = ag.dUm().eaN();
        break label2444;
        if (!this.zPl) {
          break label2675;
        }
        this.zPl = ag.dUm().eaN();
        break label2675;
        this.mUIAction.list.setAdapter(this.Akj);
        Ro(0);
        this.Akj.vw();
        break label2953;
        i = 0;
        break label3816;
        if (!((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).hasFinderPosted())
        {
          this.AkN = 1;
          break label3879;
        }
        this.AkN = 2;
        break label3879;
        paramBundle = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFA, "");
        break label3918;
        bool = false;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99383);
    this.Aku = true;
    Object localObject1 = this.AkG;
    ((bc)localObject1).cQG();
    ((bc)localObject1).Agg = null;
    ((bc)localObject1).yzh = bc.a.Agi;
    com.tencent.mm.plugin.sns.ui.video.d.eeK().aI(this);
    localObject1 = com.tencent.mm.plugin.sns.ui.video.b.eeD();
    ad.i("MicroMsg.SightPlayViewManager", "onUIDestroy");
    Object localObject2 = ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).AAU.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((com.tencent.mm.plugin.sns.ui.video.a)((Iterator)localObject2).next()).stop();
    }
    ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).AAU.clear();
    ad.i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
    com.tencent.mm.sdk.b.a.IbL.d(this.AkV);
    com.tencent.mm.sdk.b.a.IbL.d(this.AkW);
    com.tencent.mm.sdk.b.a.IbL.d(this.AkX);
    com.tencent.mm.sdk.b.a.IbL.d(this.AkY);
    com.tencent.mm.sdk.b.a.IbL.d(this.AkZ);
    com.tencent.mm.sdk.b.a.IbL.d(this.Alb);
    com.tencent.mm.sdk.b.a.IbL.d(this.Ala);
    com.tencent.mm.sdk.b.a.IbL.d(this.zlu);
    com.tencent.mm.sdk.b.a.IbL.d(this.Alc);
    com.tencent.mm.sdk.b.a.IbL.d(this.Ald);
    com.tencent.mm.sdk.b.a.IbL.d(this.Ale);
    com.tencent.mm.sdk.b.a.IbL.d(this.Alf);
    com.tencent.mm.sdk.b.a.IbL.d(this.Alg);
    com.tencent.mm.sdk.b.a.IbL.d(this.AkQ);
    com.tencent.mm.sdk.b.a.IbL.d(this.Ali);
    com.tencent.mm.plugin.sns.ui.e.a.eeB();
    int i;
    long l1;
    Object localObject3;
    Object localObject4;
    int j;
    label464:
    String str2;
    if ((this.Akp != null) && (this.Akp.zPc != null))
    {
      localObject1 = this.Akp.zPc.zkL;
      if (this.AkS)
      {
        i = 1;
        ((com.tencent.mm.plugin.sns.j.b)localObject1).zrz = i;
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.sns.j.e.ztz;
      if (((com.tencent.mm.plugin.sns.j.e)localObject2).gwV == 0) {
        break label792;
      }
      ad.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sns.j.e)localObject2).ztA.size()), Integer.valueOf(((com.tencent.mm.plugin.sns.j.e)localObject2).ztB.size()) });
      l1 = ((com.tencent.mm.plugin.sns.j.e)localObject2).fFB.getLong(2, 0L);
      if ((((com.tencent.mm.plugin.sns.j.e)localObject2).ztA.isEmpty()) || ((((com.tencent.mm.plugin.sns.j.e)localObject2).ztA.size() <= ((com.tencent.mm.plugin.sns.j.e)localObject2).ztF) && (bt.rM(l1) <= ((com.tencent.mm.plugin.sns.j.e)localObject2).ztG))) {
        break label1810;
      }
      localObject3 = new StringBuffer();
      localObject4 = ((com.tencent.mm.plugin.sns.j.e)localObject2).ztA.keySet().iterator();
      i = 0;
      j = 0;
      if (!((Iterator)localObject4).hasNext()) {
        break label618;
      }
      str2 = (String)((Iterator)localObject4).next();
      localObject1 = (String)((com.tencent.mm.plugin.sns.j.e)localObject2).ztB.get(str2);
      if (bt.isNullOrNil((String)localObject1)) {
        break label605;
      }
      j = 1;
      label511:
      if (!((com.tencent.mm.plugin.sns.j.e)localObject2).ztC.contains(str2)) {
        break label613;
      }
    }
    label605:
    label613:
    for (int k = 1;; k = 0)
    {
      ((StringBuffer)localObject3).append(str2 + "#" + ((com.tencent.mm.plugin.sns.j.e)localObject2).ztA.get(str2) + "#" + (String)localObject1 + "#" + k + "|");
      i += 1;
      break label464;
      i = 0;
      break;
      localObject1 = "";
      break label511;
    }
    label618:
    ((StringBuffer)localObject3).append("," + l1 + "," + bt.aQJ() + ",1," + j + "," + i + ",1");
    ad.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", new Object[] { Integer.valueOf(13226), localObject3 });
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(13226, ((StringBuffer)localObject3).toString());
    ((com.tencent.mm.plugin.sns.j.e)localObject2).fFB.set(3, null);
    ((com.tencent.mm.plugin.sns.j.e)localObject2).fFB.set(4, null);
    ((com.tencent.mm.plugin.sns.j.e)localObject2).fFB.set(5, null);
    ((com.tencent.mm.plugin.sns.j.e)localObject2).ztA.clear();
    ((com.tencent.mm.plugin.sns.j.e)localObject2).ztB.clear();
    ((com.tencent.mm.plugin.sns.j.e)localObject2).ztC.clear();
    ((com.tencent.mm.plugin.sns.j.e)localObject2).fFB.setLong(2, bt.aQJ());
    for (;;)
    {
      ((com.tencent.mm.plugin.sns.j.e)localObject2).dVF();
      label792:
      com.tencent.mm.kernel.g.ajD();
      localObject3 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(68377, null);
      i = this.Akj.getCount();
      localObject1 = "";
      localObject2 = null;
      if (i > 0)
      {
        localObject2 = this.Akj.QT(i - 1);
        localObject1 = com.tencent.mm.plugin.sns.data.q.n((com.tencent.mm.plugin.sns.storage.p)localObject2);
      }
      label889:
      boolean bool;
      if ((this.Akp != null) && (this.Akp.zPc != null))
      {
        localObject4 = this.Akp.zPc.zkL;
        if (localObject2 == null)
        {
          i = -1;
          ad.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
          l1 = System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.j.b)localObject4).ztj;
          ((com.tencent.mm.plugin.sns.j.b)localObject4).zrn += l1;
          ad.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + l1 + " BrowseTime: " + ((com.tencent.mm.plugin.sns.j.b)localObject4).zrn + "BackgroundTime: " + ((com.tencent.mm.plugin.sns.j.b)localObject4).zrW);
          localObject2 = ag.dTR();
          if (localObject2 != null) {
            ((ExecutorService)localObject2).execute(new b.2((com.tencent.mm.plugin.sns.j.b)localObject4, i));
          }
          ((com.tencent.mm.plugin.sns.j.b)localObject4).zrl = false;
        }
      }
      else
      {
        localObject2 = com.tencent.mm.modelsns.e.pV(704);
        if (((com.tencent.mm.modelsns.e)localObject2).aLg())
        {
          ((com.tencent.mm.modelsns.e)localObject2).eS(this.AkS);
          if (bt.isNullOrNil((String)localObject3)) {
            break label1864;
          }
          bool = true;
          ((com.tencent.mm.modelsns.e)localObject2).eS(bool);
          ((com.tencent.mm.modelsns.e)localObject2).Gs(this.Akv);
          ((com.tencent.mm.modelsns.e)localObject2).Gs((String)localObject1);
          ((com.tencent.mm.modelsns.e)localObject2).Gs((String)localObject1);
          ((com.tencent.mm.modelsns.e)localObject2).pY(this.mUIAction.AnQ);
          ((com.tencent.mm.modelsns.e)localObject2).Gs("");
          com.tencent.mm.modelsns.e.aLj();
          ((com.tencent.mm.modelsns.e)localObject2).aLk();
        }
        localObject1 = (AdListView)this.mUIAction.getSnsListView();
        this.Aky.znc.clear();
        ag.dTV().clean();
        localObject2 = ag.dTY();
        ag.dTR().execute(new k.5((com.tencent.mm.plugin.sns.ad.d.k)localObject2));
        ((AdListView)localObject1).zNz.clear();
        ((AdListView)localObject1).zNz = null;
        ((AdListView)localObject1).zNA.bwZ();
        ((AdListView)localObject1).zNA = null;
        com.tencent.mm.plugin.sns.model.t.dTy();
        if (!ag.dTN()) {
          this.Alp.removeCallbacks(this.AkO);
        }
        com.tencent.mm.kernel.g.ajD();
        if (com.tencent.mm.kernel.g.ajA().aiK())
        {
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.b(213, this);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.b(682, this);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.b(218, this);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.b(211, this);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.b(683, this);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(327776, Integer.valueOf(this.Akt));
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(589825, Boolean.FALSE);
        }
        if (this.Akp != null)
        {
          localObject1 = this.Akp;
          ((i)localObject1).zPs.removeListener();
          if (((i)localObject1).zPg != null) {
            ((i)localObject1).zPg.ebV();
          }
          com.tencent.mm.sdk.b.a.IbL.d(((i)localObject1).zPu);
          com.tencent.mm.sdk.b.a.IbL.d(((i)localObject1).zPv);
        }
        ag.cVf().removeCallbacks(this.Alq);
        localObject1 = ag.dUn();
        if (((com.tencent.mm.plugin.sns.model.at)localObject1).zmw != null) {
          ((com.tencent.mm.plugin.sns.model.at)localObject1).dUY();
        }
        if (!((com.tencent.mm.plugin.sns.model.at)localObject1).zlU) {}
      }
      try
      {
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.zmu = ((com.tencent.mm.plugin.sns.model.at)localObject1).zmu;
        localObject2 = ((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.toByteArray();
        com.tencent.mm.vfs.i.f(((com.tencent.mm.plugin.sns.model.at)localObject1).zlT, (byte[])localObject2, localObject2.length);
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmq.zqI.clear();
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmr = null;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zms = 0L;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zml = 0L;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmf.clear();
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmg = null;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmk = 0L;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmh = 0L;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmn = false;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmw = null;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmx = null;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmm = au.zmN;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmy = 0;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmv = 0L;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmu = 0L;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmz = 0L;
        ((com.tencent.mm.plugin.sns.model.at)localObject1).zmi.clear();
        localObject1 = ((com.tencent.mm.plugin.sns.model.at)localObject1).zmA;
        ((as)localObject1).zlR.clear();
        ((as)localObject1).zlS = null;
        com.tencent.mm.kernel.g.ajB().gAO.b(211, (com.tencent.mm.al.f)localObject1);
        localObject1 = ag.dUo();
        ad.i(com.tencent.mm.plugin.sns.model.aq.TAG, "destroy");
        com.tencent.mm.sdk.platformtools.aq.aA(((com.tencent.mm.plugin.sns.model.aq)localObject1).zlH);
        if (this.Akj == null) {
          break label2331;
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
                ad.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", new Object[] { Integer.valueOf(n), Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
                k = localObject2[1];
              }
            }
            j += 1;
            i = k;
            continue;
            label1810:
            ((com.tencent.mm.plugin.sns.j.e)localObject2).fFB.set(3, ((com.tencent.mm.plugin.sns.j.e)localObject2).ztA);
            ((com.tencent.mm.plugin.sns.j.e)localObject2).fFB.set(4, ((com.tencent.mm.plugin.sns.j.e)localObject2).ztB);
            ((com.tencent.mm.plugin.sns.j.e)localObject2).fFB.set(5, ((com.tencent.mm.plugin.sns.j.e)localObject2).ztC);
            break;
            i = ((com.tencent.mm.plugin.sns.storage.p)localObject2).field_createTime;
            break label889;
            label1864:
            bool = false;
          }
        }
      }
      catch (Exception localException)
      {
        int m;
        for (;;)
        {
          ad.w("MicroMsg.SnsUnreadTipManager", "flushUnreadTipFaultWriteCache error:%s", new Object[] { localException.getMessage() });
        }
        j = getResources().getDimensionPixelSize(2131166841);
        if ((!ag.dTN()) && (this.Akh.dTU() != null) && (this.Alv == 0))
        {
          localObject1 = ag.dUm();
          String str1 = this.Akj.Ard.edW();
          localObject3 = this.Akj.Ard.edY();
          l1 = this.Akh.dTU().zlh;
          localObject4 = this.Akj.Ard.edU();
          str2 = this.Akj.Ard.edV();
          long l2 = this.Akh.dTU().zli;
          String str3 = this.Akj.Ard.edX();
          bool = this.mUIAction.zVQ;
          ((ap)localObject1).zVK = bt.HI();
          ((ap)localObject1).rdV = str1;
          ((ap)localObject1).zVL = ((String)localObject3);
          ((ap)localObject1).zlh = l1;
          ((ap)localObject1).position = m;
          ((ap)localObject1).zVP = (i - j);
          ((ap)localObject1).zVO = str3;
          ((ap)localObject1).zVM = ((String)localObject4);
          ((ap)localObject1).zVN = str2;
          ((ap)localObject1).zli = l2;
          ((ap)localObject1).zVQ = bool;
          ad.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(((ap)localObject1).zVK), str1, localObject3, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(((ap)localObject1).zVP), localObject4, str2, Long.valueOf(l2), str3, Boolean.valueOf(bool) });
        }
        ad.d("MicroMsg.SnsTimeLineUI", "top h %d", new Object[] { Integer.valueOf(i - j) });
        localObject1 = this.Akj.Arc;
        com.tencent.mm.sdk.b.a.IbL.d(((bh)localObject1).kwD);
        if (!ag.dTN()) {
          break label2627;
        }
      }
    }
    ad.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
    for (;;)
    {
      localObject1 = this.Akj.Arc;
      if (((bh)localObject1).AaS != null) {
        ((bh)localObject1).AaS.activity = null;
      }
      localObject1 = this.Akj.Arc;
      com.tencent.mm.sdk.b.a.IbL.d(((bh)localObject1).kwD);
      this.Akj.Arc.ecM();
      this.Akj.Arc.ecI();
      label2331:
      bj.clean();
      com.tencent.mm.sdk.b.a.IbL.d(this.AkP);
      com.tencent.mm.kernel.g.ajD();
      if (com.tencent.mm.kernel.g.ajA().aiK()) {
        ag.dUb().zgf.clear();
      }
      this.Akj.Ard.removeVendingDataChangedCallback(this.AkR);
      this.AkR = null;
      this.Akj = null;
      this.Akp = null;
      com.tencent.mm.plugin.sns.ui.a.c.edS();
      com.tencent.mm.plugin.sns.abtest.c.dRd();
      localObject1 = ag.dTV();
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(291, (com.tencent.mm.al.f)localObject1);
      com.tencent.mm.plugin.sns.abtest.a.clean();
      this.mUIAction.onDestroy();
      super.onDestroy();
      com.tencent.mm.kiss.widget.textview.c.gEJ.akE();
      localObject1 = this.Aki;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ArA = null;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = false;
      com.tencent.mm.plugin.sns.ad.d.l.yZH.yZG.clear();
      ad.i("MicroMsg.SnsTimelineAdResourceMgr", "clean cache", new Object[] { bt.flS() });
      localObject1 = ag.dTZ();
      if (!((com.tencent.mm.plugin.sns.model.b)localObject1).zfQ.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.b)localObject1).zfQ.clear();
      }
      localObject1 = ag.dTZ();
      if (!((com.tencent.mm.plugin.sns.model.b)localObject1).zfR.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.b)localObject1).zfR.clear();
      }
      ag.dUn().zmo = false;
      localObject1 = com.tencent.mm.plugin.sns.j.e.ztz;
      ((com.tencent.mm.plugin.sns.j.e)localObject1).ztJ.clear();
      ((com.tencent.mm.plugin.sns.j.e)localObject1).ztK.clear();
      if (com.tencent.mm.plugin.sns.j.e.ztz.zug.eoS > 0L)
      {
        localObject1 = com.tencent.mm.plugin.sns.j.e.ztz;
        ((com.tencent.mm.plugin.sns.j.e)localObject1).zug.dSa = 1L;
        ((com.tencent.mm.plugin.sns.j.e)localObject1).zug.aLk();
        ((com.tencent.mm.plugin.sns.j.e)localObject1).zug = new go();
      }
      AppMethodBeat.o(99383);
      return;
      label2627:
      ag.dUb();
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
    com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179271);
        SnsTimeLineUI.this.dZN();
        AppMethodBeat.o(179271);
      }
    });
    if (keyboardState() == 2)
    {
      if ((this.Akp != null) && (this.Akp.zPg != null) && (!this.Akp.zPg.ebQ()))
      {
        ad.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
        AppMethodBeat.o(99389);
      }
    }
    else if ((keyboardState() == 1) && (this.Akp != null))
    {
      i locali = this.Akp;
      if (locali.zPd)
      {
        locali.zPd = false;
        locali.zPh.edP();
      }
    }
    AppMethodBeat.o(99389);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99387);
    try
    {
      com.tencent.mm.sdk.platformtools.bh.a(this, null);
      this.zXO = false;
      this.Akm.clearAnimation();
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, this.fKU);
      this.fKU = 0;
      com.tencent.mm.plugin.sns.model.t.b(this);
      ag.dUb().zgh = null;
      if (this.Akj != null)
      {
        localObject = this.Akj.Arc;
        com.tencent.mm.sdk.b.a.IbL.d(((bh)localObject).Abw);
        com.tencent.mm.sdk.b.a.IbL.d(((bh)localObject).Abv);
        com.tencent.mm.sdk.b.a.IbL.d(((bh)localObject).Abx);
      }
      if ((this.Akp != null) && (this.Akp.zPb != null)) {
        this.Akp.zPb.onPause();
      }
      if ((this.Akp != null) && (this.Akp.zPc != null)) {
        this.Akp.zPc.zkL.rm(false);
      }
      com.tencent.mm.modelstat.d.m("SnsTimeLineUI", this.vwS, bt.aQJ());
      this.mUIAction.onPause();
      super.onPause();
      com.tencent.mm.plugin.sns.ui.video.d.eeK().onUIPause();
      Object localObject = com.tencent.mm.plugin.sns.ui.video.b.eeD();
      ad.i("MicroMsg.SightPlayViewManager", "onUIPause");
      localObject = ((com.tencent.mm.plugin.sns.ui.video.b)localObject).AAU.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.sns.ui.video.a)((Iterator)localObject).next()).onUIPause();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
      }
      com.tencent.mm.sdk.b.a.IbL.d(this.AkU);
      com.tencent.mm.sdk.b.a.IbL.d(this.AkT);
      com.tencent.mm.sdk.b.a.IbL.d(this.Alh);
      if ((com.tencent.matrix.b.HK()) && (com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class) != null))
      {
        com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class)).cJy;
        if (localc != null) {
          this.gwh = Math.max(0L, localc.cLq - this.gwh);
        }
      }
      if (bt.aQJ() <= this.hVM) {}
    }
    for (long l = bt.aQJ() - this.hVM;; l = 1L)
    {
      this.hVM = l;
      WXHardCoderJNI.reportFPS(701, WXHardCoderJNI.hcSNSScrollAction, 1, this.gwh, this.hVM);
      this.gwh = 0L;
      this.hVM = 0L;
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
      ad.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(99403);
      return;
    }
    ad.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99403);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ecV();
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131761885), getString(2131760598), getString(2131755691), false, new SnsTimeLineUI.69(this), new SnsTimeLineUI.70(this));
        }
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ecU();
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        com.tencent.mm.ui.base.h.a(getContext(), getString(paramInt), getString(2131761885), getString(2131760598), getString(2131755691), false, new SnsTimeLineUI.71(this), new SnsTimeLineUI.72(this));
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ecU();
        AppMethodBeat.o(99403);
        return;
      }
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131761869), getString(2131761885), getString(2131760598), getString(2131755691), false, new SnsTimeLineUI.73(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99384);
    ag.dUn().zmm = au.zmN;
    this.AkG.yzh = bc.ecp();
    this.hVM = bt.aQJ();
    Object localObject1;
    if ((com.tencent.matrix.b.HK()) && (com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class) != null))
    {
      localObject1 = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class)).cJy;
      if (localObject1 != null) {
        this.gwh = ((com.tencent.matrix.trace.f.c)localObject1).cLq;
      }
    }
    try
    {
      if (!this.zXO)
      {
        ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onResume callback");
        com.tencent.mm.sdk.platformtools.bh.a(this, this.zYD);
        this.zXO = true;
      }
      if ((com.tencent.mm.sdk.a.b.fjN()) && (com.tencent.mm.sdk.a.b.fjL())) {
        sUILeaksRoutineEnsuranceRef.add(this);
      }
      this.mUIAction.onResume();
      super.onResume();
      ecR();
      if (this.autoPlay) {
        ecQ();
      }
      this.vwS = bt.aQJ();
      int i;
      if (this.Alu)
      {
        this.Alu = false;
        i = this.Akj.getCount();
        if (getIntent().getBooleanExtra("is_from_find_more", false))
        {
          localObject3 = com.tencent.mm.modelsns.e.c(getIntent(), "enter_log");
          if (localObject3 != null)
          {
            if (i <= 0) {
              break label735;
            }
            localp = this.Akj.QT(0);
            if (localp != null) {
              break label701;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.e)localObject3).Gs((String)localObject1);
            if (localp != null) {
              break label713;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.e)localObject3).Gs((String)localObject1);
            ((com.tencent.mm.modelsns.e)localObject3).Gs(String.valueOf(i));
            ((com.tencent.mm.modelsns.e)localObject3).aLk();
          }
        }
      }
      if (this.mScreenWidth == 0)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
        this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
        localObject1 = this.Akw;
        i = this.mScreenWidth;
        int j = this.mScreenHeight;
        ((com.tencent.mm.plugin.sns.j.a)localObject1).mScreenWidth = i;
        ((com.tencent.mm.plugin.sns.j.a)localObject1).mScreenHeight = j;
      }
      if (ag.dTN()) {
        finish();
      }
      ag.dUb().zgh = this.Akj.Arc;
      akA().bk(c.b.class);
      com.tencent.mm.plugin.sns.model.t.a(this);
      if (this.Ako)
      {
        this.Akm.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99328);
            ad.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.M(SnsTimeLineUI.this));
            if (SnsTimeLineUI.M(SnsTimeLineUI.this))
            {
              SnsTimeLineUI.m(SnsTimeLineUI.this);
              SnsTimeLineUI.l(SnsTimeLineUI.this).edj();
            }
            AppMethodBeat.o(99328);
          }
        });
        if ((this.Akp != null) && (this.Akp.zPb != null)) {
          this.Akp.zPb.onResume();
        }
        if (this.Akj != null)
        {
          localObject1 = this.Akj.Arc;
          com.tencent.mm.sdk.b.a.IbL.c(((bh)localObject1).Abw);
          com.tencent.mm.sdk.b.a.IbL.c(((bh)localObject1).Abv);
          com.tencent.mm.sdk.b.a.IbL.c(((bh)localObject1).Abx);
        }
        if ((this.Akp != null) && (this.Akp.zPc != null))
        {
          this.Akp.zPc.zkL.rm(true);
          this.Akp.zPc.zkL.rn(false);
          this.Akp.zPc.zkL.ro(false);
          this.Akp.zPc.zkL.rp(false);
          this.Akp.zPc.zkL.rz(false);
          localObject1 = this.Akp.zPc.zkL;
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rx(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).ry(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rr(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rw(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).ru(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rw(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rA(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rv(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rw(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rs(false);
          ((com.tencent.mm.plugin.sns.j.b)localObject1).rt(false);
        }
        localObject1 = ag.dUb();
        ((com.tencent.mm.plugin.sns.model.f)localObject1).zgi = 0L;
        ((com.tencent.mm.plugin.sns.model.f)localObject1).zgj = 0L;
        com.tencent.mm.sdk.b.a.IbL.c(this.AkU);
        com.tencent.mm.sdk.b.a.IbL.c(this.AkT);
        com.tencent.mm.sdk.b.a.IbL.c(this.Alh);
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
        ad.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
        continue;
        label701:
        Object localObject2 = com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId);
        continue;
        label713:
        localObject2 = localp.field_createTime;
        continue;
        label735:
        ((com.tencent.mm.modelsns.e)localObject3).Gs("");
        ((com.tencent.mm.modelsns.e)localObject3).Gs("");
        ((com.tencent.mm.modelsns.e)localObject3).Gs("0");
        continue;
        localObject2 = this.Akr;
        if (((a)localObject2).AlB.Akm.getVisibility() == 0)
        {
          ((a)localObject2).init();
          localObject3 = (AbsoluteLayout.LayoutParams)((a)localObject2).AlB.Akm.getLayoutParams();
          ((AbsoluteLayout.LayoutParams)localObject3).y = ((int)((a)localObject2).AlX);
          ((a)localObject2).AlB.Akm.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((a)localObject2).AlB.Akm.invalidate();
        }
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(99398);
    ad.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType());
    if (paramn.getType() == 218)
    {
      paramString = (com.tencent.mm.plugin.sns.model.q)paramn;
      if (((paramString.type == 1) || (paramString.type == 6) || (paramString.type == 4)) && (this.Akp.zPt != null)) {
        this.Akp.zPt.dismiss();
      }
      if (paramString.type == 11)
      {
        if (this.mUIAction.tipDialog != null) {
          this.mUIAction.tipDialog.dismiss();
        }
        if (this.Alx != null) {
          this.Alx.setImageResource(2131690526);
        }
      }
    }
    if (this.Akj != null) {
      this.Akj.Ard.notifyVendingDataChange();
    }
    if (paramn.getType() == 211)
    {
      paramString = (x)paramn;
      if (!paramString.zhh) {
        break label272;
      }
      paramn = com.tencent.mm.modelsns.e.pV(727);
      paramn.pY(this.Akj.getCount()).pY(paramString.ajO);
      paramn.aLk();
    }
    for (;;)
    {
      if (this.Akr != null)
      {
        this.Ako = false;
        this.Akr.edk();
      }
      AppMethodBeat.o(99398);
      return;
      label272:
      paramn = com.tencent.mm.modelsns.e.pV(728);
      paramn.pY(this.Akj.getCount()).pY(paramString.ajO).pY(0);
      paramn.aLk();
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
    AppMethodBeat.i(198460);
    super.onWindowFocusChanged(paramBoolean);
    ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      com.tencent.mm.sdk.platformtools.bh.a(this, null);
      this.zXO = false;
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(198460);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      ad.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(198460);
    }
    if (!this.zXO)
    {
      ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onWindowFocusChanged callback");
      com.tencent.mm.sdk.platformtools.bh.a(this, this.zYD);
      this.zXO = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(198460);
    return;
  }
  
  public final void rU(boolean paramBoolean)
  {
    AppMethodBeat.i(99405);
    if (this.Akj != null)
    {
      ad.i("MicroMsg.SnsTimeLineUI", "set play animation %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.mm.plugin.sns.ui.a.c localc = this.Akj;
      localc.Are = paramBoolean;
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
    if ((Build.VERSION.SDK_INT >= 21) && (this.wQp != null))
    {
      this.wQp.setBackgroundColor(getWindow().getStatusBarColor());
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
    private float AlU;
    private float AlV;
    float AlW = -1.0F;
    float AlX;
    private float AlY = 50.0F;
    private float AlZ = 10.0F;
    float Ama = 0.0F;
    private float Amb = 0.0F;
    private float Amc;
    private float Amd;
    boolean Ame;
    int Amf;
    boolean Amg = false;
    int Amh = 0;
    float Ami = 0.0F;
    float Amj = 0.0F;
    float Amk = 0.0F;
    float Aml = 0.0F;
    int DELAY_TIME = 600;
    private ListView list;
    
    public a(ListView paramListView)
    {
      this.list = paramListView;
    }
    
    final void Aq(long paramLong)
    {
      AppMethodBeat.i(99363);
      if (SnsTimeLineUI.Alj.booleanValue()) {
        ad.d("MicroMsg.RefreshAnim", "setDurationTime durationMillis %s %s", new Object[] { Long.valueOf(paramLong), bt.flS().toString() });
      }
      setDuration(paramLong);
      AppMethodBeat.o(99363);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(99366);
      if (SnsTimeLineUI.Alj.booleanValue()) {
        ad.d("MicroMsg.RefreshAnim", "animtest applyTransformation vis %s interpolatedTime %s isJustUp %s", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(paramFloat), Boolean.valueOf(this.Ame) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99366);
        return;
      }
      float f1 = (paramFloat - this.Amc) * (float)getDuration();
      if (f1 < 2.0F)
      {
        if (SnsTimeLineUI.Alj.booleanValue()) {
          ad.d("MicroMsg.RefreshAnim", "applyTransformation wawawa %s", new Object[] { Float.valueOf(f1) });
        }
        AppMethodBeat.o(99366);
        return;
      }
      this.Amc = paramFloat;
      SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(2131690250);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.KSV);
      if (((float)getDuration() * paramFloat >= (float)(getDuration() - this.DELAY_TIME)) || (this.Ame))
      {
        paramTransformation = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        if (paramTransformation.y <= this.Amb)
        {
          AppMethodBeat.o(99366);
          return;
        }
        if (this.Amk == 0.0F)
        {
          this.Amk = (-this.Amb + paramTransformation.y);
          this.Aml = paramTransformation.y;
          this.Amd = paramFloat;
        }
        paramFloat = (paramFloat - this.Amd) / (1.0F - this.Amd);
        f1 = this.Amk * paramFloat;
        float f2 = this.Aml - f1;
        if (SnsTimeLineUI.Alj.booleanValue()) {
          ad.i("MicroMsg.RefreshAnim", "animcheck interpolatedTime y %s duration %s factor %s residualTime %s pass %s ", new Object[] { Float.valueOf(f2), Long.valueOf(getDuration()), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.Amd * (float)getDuration()) });
        }
        if (paramTransformation.y > f2) {
          paramTransformation.y = ((int)f2);
        }
        this.Ama = paramTransformation.y;
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(paramTransformation);
      }
      for (;;)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99366);
        return;
        if (SnsTimeLineUI.Alj.booleanValue()) {
          ad.d("MicroMsg.RefreshAnim", "animcheck delt Rotate " + f1 / 2.5F);
        }
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(f1 / 2.5F, this.AlU, this.AlV);
      }
    }
    
    public final void bH(float paramFloat)
    {
      AppMethodBeat.i(99360);
      if (this.list != null)
      {
        if (this.list.getFirstVisiblePosition() != 0) {
          break label123;
        }
        if (SnsTimeLineUI.d(SnsTimeLineUI.this).zqQ.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).Amf) {
          SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
        }
      }
      for (;;)
      {
        if (SnsTimeLineUI.Alj.booleanValue()) {
          ad.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.AlX), Float.valueOf(this.AlW) });
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
      if (paramFloat <= -this.AlY) {
        f1 = -this.AlY;
      }
      float f2 = f1;
      if (f1 >= this.AlY) {
        f2 = this.AlY;
      }
      if (f2 < 0.0F)
      {
        this.Ama -= f2 * 2.0F;
        f1 = this.Ama;
        paramFloat = f1;
        if (f1 < this.AlX)
        {
          paramFloat = this.AlX;
          this.Ama = this.AlX;
        }
        f1 = paramFloat;
        if (paramFloat > this.AlW)
        {
          f1 = this.AlW;
          this.Ama = this.AlW;
        }
        if (SnsTimeLineUI.Alj.booleanValue()) {
          ad.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s sumY %s translateY %s distanceY %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.AlX), Float.valueOf(this.AlW), Float.valueOf(this.Ama), Float.valueOf(f1), Float.valueOf(this.AlY) });
        }
        if (f1 != this.AlW) {
          break label456;
        }
      }
      label456:
      for (paramFloat = f2 * 2.0F;; paramFloat = 5.0F * f2)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.KSV);
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(paramFloat, this.AlU, this.AlV);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(2131690250);
        AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        localLayoutParams.y = ((int)f1);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99360);
        return;
        this.Ama -= f2 / 2.0F;
        break;
      }
    }
    
    public final void edj()
    {
      AppMethodBeat.i(99361);
      if (SnsTimeLineUI.Alj.booleanValue()) {
        ad.d("MicroMsg.RefreshAnim", "animtest playLoading");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99361);
        return;
      }
      init();
      this.Ama = (this.AlW + 20.0F);
      AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
      localLayoutParams.y = ((int)this.AlW);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
      edl();
      AppMethodBeat.o(99361);
    }
    
    public final void edk()
    {
      AppMethodBeat.i(99362);
      if (SnsTimeLineUI.Alj.booleanValue()) {
        ad.i("MicroMsg.RefreshAnim", "play end vis: %d, sumY %f MAX_Y %f", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(this.Ama), Float.valueOf(this.AlW) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99362);
        return;
      }
      init();
      if (this.Ama < this.AlW - this.AlZ)
      {
        AppMethodBeat.o(99362);
        return;
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      Aq(this.DELAY_TIME + 100);
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      this.Ame = false;
      AppMethodBeat.o(99362);
    }
    
    public final void edl()
    {
      AppMethodBeat.i(99364);
      if (SnsTimeLineUI.Alj.booleanValue()) {
        ad.d("MicroMsg.RefreshAnim", "animtest setAcitonUp");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99364);
        return;
      }
      init();
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      if (SnsTimeLineUI.Alj.booleanValue()) {
        ad.v("MicroMsg.RefreshAnim", "setAcitonUp1 sumY  %s MAX_Y %s %s", new Object[] { Float.valueOf(this.Ama), Float.valueOf(this.AlW), bt.flS().toString() });
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      if (this.Ama >= this.AlW - this.AlZ)
      {
        Aq(20000L);
        this.Ame = false;
        AppMethodBeat.o(99364);
        return;
      }
      Aq(this.DELAY_TIME + 100);
      this.Ame = true;
      AppMethodBeat.o(99364);
    }
    
    final void init()
    {
      AppMethodBeat.i(99365);
      if ((this.AlW == -1.0F) || (this.AlV < 0.1D))
      {
        this.AlW = BackwardSupportUtil.b.g(SnsTimeLineUI.this, 70.0F);
        this.AlY = BackwardSupportUtil.b.g(SnsTimeLineUI.this, 16.0F);
        this.AlU = (SnsTimeLineUI.u(SnsTimeLineUI.this).getWidth() / 2);
        this.AlV = (SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() / 2);
        this.Amb = (-SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() * 2);
        if (this.Amb == 0.0F) {
          this.Amb = (-BackwardSupportUtil.b.g(SnsTimeLineUI.this, 40.0F));
        }
        this.AlX = this.Amb;
        if (SnsTimeLineUI.Alj.booleanValue()) {
          ad.d("MicroMsg.RefreshAnim", "init MIN_Y %s MAX_Y %s targetInitY %s distanceY %s", new Object[] { Float.valueOf(this.AlX), Float.valueOf(this.AlW), Float.valueOf(this.Amb), Float.valueOf(this.AlY) });
        }
        this.Ama = this.AlX;
        if (!this.Amg)
        {
          if (SnsTimeLineUI.Alj.booleanValue()) {
            ad.i("MicroMsg.RefreshAnim", "initState");
          }
          this.Amh = ((AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams()).y;
          this.Ami = this.AlW;
          this.Amj = this.Ama;
        }
        this.Amg = true;
      }
      AppMethodBeat.o(99365);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(99367);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      if (SnsTimeLineUI.Alj.booleanValue()) {
        ad.i("MicroMsg.RefreshAnim", "anim initialize %s", new Object[] { bt.flS().toString() });
      }
      this.Amc = 0.0F;
      this.Amd = 0.0F;
      this.Amk = 0.0F;
      this.Aml = 0.0F;
      AppMethodBeat.o(99367);
    }
  }
  
  final class b
  {
    public int Amm;
    public int type = 0;
    
    private b() {}
  }
  
  final class c
  {
    public String Amn = "";
    public long Amo;
    public int Amp;
    public int Amq;
    public long Amr;
    public int Ams;
    public long Amt;
    public int Amu;
    public long Amv;
    public boolean active = true;
    public long lBq;
    public int scene;
    
    private c() {}
    
    public final void Rq(int paramInt)
    {
      AppMethodBeat.i(99368);
      if (!this.active)
      {
        AppMethodBeat.o(99368);
        return;
      }
      this.Amq = paramInt;
      this.lBq = bt.flT();
      AppMethodBeat.o(99368);
    }
    
    public final void Rr(int paramInt)
    {
      AppMethodBeat.i(99369);
      if (!this.active)
      {
        AppMethodBeat.o(99369);
        return;
      }
      reset();
      this.scene = 2;
      this.Amr = bt.flT();
      this.Ams = paramInt;
      AppMethodBeat.o(99369);
    }
    
    public final void Rs(int paramInt)
    {
      AppMethodBeat.i(99370);
      if (!this.active)
      {
        AppMethodBeat.o(99370);
        return;
      }
      reset();
      this.scene = 3;
      this.Amt = bt.flT();
      this.Amv = 0L;
      this.Amu = paramInt;
      AppMethodBeat.o(99370);
    }
    
    final void reset()
    {
      this.scene = 0;
      this.Amo = 0L;
      this.Amp = -1;
      this.Amq = 0;
      this.lBq = 0L;
      this.Amr = 0L;
      this.Ams = 0;
      this.Amt = 0L;
      this.Amu = 0;
      this.Amv = 0L;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(99371);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.Amn).append(",").append(this.scene).append(",").append(this.Amo).append(",").append(this.Amp).append(",").append(this.Amq).append(",").append(this.lBq).append(",").append(this.Amr).append(",").append(this.Ams).append(",").append(this.Amt).append(",").append(this.Amu).append(",").append(this.Amv);
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