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
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.na;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.a.up;
import com.tencent.mm.g.a.wu;
import com.tencent.mm.g.b.a.eb;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.ce;
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
import com.tencent.mm.plugin.sns.j.a.a;
import com.tencent.mm.plugin.sns.j.c.2;
import com.tencent.mm.plugin.sns.l.c.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.as.4;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bg.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.f;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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

@com.tencent.mm.kernel.i
public class SnsTimeLineUI
  extends WxPresenterActivity
  implements com.tencent.mm.ak.g, au, i.a, v
{
  private static final Set<Activity> sUILeaksRoutineEnsuranceRef;
  public static final Boolean yTC;
  private static Boolean yTb;
  private boolean autoPlay;
  private int fsu;
  private long gcx;
  private long hDh;
  private String lhM;
  private ActionBar mActionBar;
  private int mScreenHeight;
  private int mScreenWidth;
  private String mSessionId;
  private SnsUIAction mUIAction;
  private com.tencent.mm.ui.statusbar.c.a rrB;
  private int seS;
  private long uup;
  private View vJh;
  private com.tencent.mm.sdk.b.c xVy;
  private volatile boolean yGw;
  private bg.a yHk;
  protected com.tencent.mm.plugin.sns.ad.d.i yJJ;
  private final long ySC;
  private long ySD;
  private com.tencent.mm.plugin.sns.l.b ySE;
  private com.tencent.mm.plugin.sns.l.a ySF;
  private com.tencent.mm.plugin.sns.ui.a.a.c ySG;
  private com.tencent.mm.plugin.sns.ui.a.c ySH;
  private LinearLayout ySI;
  private LinearLayout ySJ;
  private QFadeImageView ySK;
  private boolean ySL;
  private boolean ySM;
  private i ySN;
  private int ySO;
  private a ySP;
  private TestTimeForSns ySQ;
  private int ySR;
  private boolean ySS;
  private String yST;
  private com.tencent.mm.plugin.sns.j.a ySU;
  private com.tencent.mm.plugin.sns.model.az ySV;
  private ax ySW;
  private String ySX;
  private boolean ySY;
  private int ySZ;
  private com.tencent.mm.sdk.b.c yTA;
  private com.tencent.mm.sdk.b.c yTB;
  private long yTD;
  boolean yTE;
  Runnable yTF;
  Runnable yTG;
  private Handler yTH;
  private Runnable yTI;
  private SnsUIAction.a yTJ;
  private long yTK;
  private a.b yTL;
  boolean yTM;
  int yTN;
  private MenuItem.OnMenuItemClickListener yTO;
  private ImageView yTP;
  private View yTQ;
  private boolean yTR;
  private String yTa;
  private String yTc;
  private c yTd;
  private az yTe;
  private ViewGroup yTf;
  private long yTg;
  private Runnable yTh;
  private com.tencent.mm.sdk.b.c yTi;
  private com.tencent.mm.sdk.b.c yTj;
  private Vending.d yTk;
  private boolean yTl;
  private com.tencent.mm.sdk.b.c yTm;
  private com.tencent.mm.sdk.b.c yTn;
  private com.tencent.mm.sdk.b.c yTo;
  private com.tencent.mm.sdk.b.c yTp;
  private com.tencent.mm.sdk.b.c yTq;
  private com.tencent.mm.sdk.b.c yTr;
  private com.tencent.mm.sdk.b.c yTs;
  private com.tencent.mm.sdk.b.c yTt;
  private com.tencent.mm.sdk.b.c yTu;
  private com.tencent.mm.sdk.b.c yTv;
  private com.tencent.mm.sdk.b.c yTw;
  private com.tencent.mm.sdk.b.c yTx;
  private com.tencent.mm.sdk.b.c yTy;
  private com.tencent.mm.sdk.b.c yTz;
  private boolean yaV;
  private boolean yxZ;
  private boolean yzX;
  
  static
  {
    AppMethodBeat.i(99430);
    yTb = null;
    yTC = Boolean.FALSE;
    sUILeaksRoutineEnsuranceRef = new HashSet();
    AppMethodBeat.o(99430);
  }
  
  public SnsTimeLineUI()
  {
    AppMethodBeat.i(99372);
    this.ySC = 300L;
    this.ySD = SystemClock.elapsedRealtime();
    this.ySE = ((com.tencent.mm.plugin.sns.l.b)am(com.tencent.mm.plugin.sns.l.b.class));
    if (this.ySE != null) {}
    for (com.tencent.mm.plugin.sns.l.a locala = this.ySE.dSV();; locala = null)
    {
      this.ySF = locala;
      this.ySG = new com.tencent.mm.plugin.sns.ui.a.a.c();
      this.ySL = false;
      this.ySM = false;
      this.yxZ = false;
      this.ySO = 800;
      this.ySR = 0;
      this.ySS = false;
      this.yST = "";
      this.ySU = new com.tencent.mm.plugin.sns.j.a();
      this.yJJ = new com.tencent.mm.plugin.sns.ad.d.i(0);
      this.ySV = new com.tencent.mm.plugin.sns.model.az();
      this.ySW = new ax();
      this.autoPlay = false;
      this.yTc = "";
      this.yTd = new c((byte)0);
      this.yTe = new az();
      this.yTf = null;
      this.yTg = 0L;
      this.yGw = false;
      this.yTh = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99267);
          com.tencent.mm.plugin.sns.ui.a.c localc = SnsTimeLineUI.a(SnsTimeLineUI.this);
          if (localc != null)
          {
            if (af.dIa().xWo == at.xWN) {
              SnsTimeLineUI.a(SnsTimeLineUI.this, localc.rt(true));
            }
            localc.yZn.dQh();
            localc.yZn.notifyVendingDataChange();
          }
          AppMethodBeat.o(99267);
        }
      };
      this.yTi = new com.tencent.mm.sdk.b.c() {};
      this.yTj = new com.tencent.mm.sdk.b.c() {};
      this.yTk = new Vending.d()
      {
        public final void dQM()
        {
          AppMethodBeat.i(179249);
          final int i;
          if ((SnsTimeLineUI.a(SnsTimeLineUI.this) != null) && (!SnsTimeLineUI.a(SnsTimeLineUI.this).yZo))
          {
            SnsTimeLineUI.a(SnsTimeLineUI.this).notifyDataSetChanged();
            if (SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView() != null)
            {
              i = com.tencent.mm.ui.ap.dT(SnsTimeLineUI.this.getContext());
              int j = com.tencent.mm.ui.ap.ji(SnsTimeLineUI.this.getContext());
              ac.d("MicroMsg.SnsTimeLineUI", "topOffset:%s curFetchMode:%s, mUIAction.header.getLoadingGroupHeight():%s, actionBar:%s, statusBar:%s", new Object[] { Integer.valueOf(-(SnsTimeLineUI.d(SnsTimeLineUI.this).yaU.getLoadingGroupHeight() - com.tencent.mm.ui.ao.fromDPToPix(SnsTimeLineUI.this.getContext(), 44) - i - j)), Integer.valueOf(af.dIa().xWo), Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).yaU.getLoadingGroupHeight()), Integer.valueOf(i), Integer.valueOf(j) });
              if (af.dIa().xWo == at.xWM)
              {
                ac.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_SPECIFIC");
                long l = SnsTimeLineUI.a(SnsTimeLineUI.this).dRz();
                af.dHH().Q(l, -1);
                SnsTimeLineUI.a(SnsTimeLineUI.this).yZn.avO(com.tencent.mm.plugin.sns.data.q.wX(l));
                SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.a(SnsTimeLineUI.this).rt(true));
                SnsTimeLineUI.d(SnsTimeLineUI.this).rs(true);
                af.dHO().start();
                SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(200565);
                    SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().setSelectionFromTop(SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), i + com.tencent.mm.ui.ao.fromDPToPix(SnsTimeLineUI.this.getContext(), 44));
                    af.dIa().xWq = false;
                    AppMethodBeat.o(200565);
                  }
                });
                AppMethodBeat.o(179249);
                return;
              }
              if (af.dIa().xWo == at.xWN)
              {
                i = 0;
                if (i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) {
                  break label421;
                }
                if (SnsTimeLineUI.a(SnsTimeLineUI.this).Pl(i).field_snsId != SnsTimeLineUI.e(SnsTimeLineUI.this)) {
                  break label414;
                }
              }
            }
          }
          for (;;)
          {
            ac.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_UP upFetchRightId:%s, rightIndex:%s", new Object[] { Long.valueOf(SnsTimeLineUI.e(SnsTimeLineUI.this)), Integer.valueOf(i) });
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
      this.yTl = false;
      this.yaV = false;
      this.yTm = new com.tencent.mm.sdk.b.c() {};
      this.yTn = new com.tencent.mm.sdk.b.c() {};
      this.yTo = new com.tencent.mm.sdk.b.c() {};
      this.yTp = new com.tencent.mm.sdk.b.c() {};
      this.yTq = new com.tencent.mm.sdk.b.c() {};
      this.yTr = new com.tencent.mm.sdk.b.c() {};
      this.yTs = new com.tencent.mm.sdk.b.c() {};
      this.yTt = new com.tencent.mm.sdk.b.c() {};
      this.yTu = new SnsTimeLineUI.5(this);
      this.xVy = new com.tencent.mm.sdk.b.c() {};
      this.yTv = new com.tencent.mm.sdk.b.c() {};
      this.yTw = new com.tencent.mm.sdk.b.c() {};
      this.yTx = new com.tencent.mm.sdk.b.c() {};
      this.yTy = new com.tencent.mm.sdk.b.c() {};
      this.yTz = new com.tencent.mm.sdk.b.c() {};
      this.yTA = new com.tencent.mm.sdk.b.c() {};
      this.yTB = new com.tencent.mm.sdk.b.c() {};
      this.yTD = 0L;
      this.yTE = false;
      this.seS = 0;
      this.yTF = new Runnable()
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
            af.dHO().pause();
          }
          AppMethodBeat.o(176303);
        }
      };
      this.yTG = new Runnable()
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
            ac.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() - SnsTimeLineUI.d(SnsTimeLineUI.this).list.getHeaderViewsCount()) });
            af.dHO().start();
            SnsTimeLineUI.a(SnsTimeLineUI.this).yZm.dQu();
          }
          AppMethodBeat.o(179225);
        }
      };
      this.yTH = ((com.tencent.mm.vending.h.b)com.tencent.mm.vending.h.d.Jrh.Jrp).mHandler;
      this.yTI = new Runnable()
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
      this.yTJ = new SnsUIAction.a()
      {
        private int yTZ = 0;
        private int yUa = 0;
        
        public final void PG(int paramAnonymousInt)
        {
          AppMethodBeat.i(200558);
          int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          int k = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
          if ((paramAnonymousInt == 0) && (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)) {
            SnsTimeLineUI.a(SnsTimeLineUI.this, j, k);
          }
          if ((j == this.yTZ) && (k == this.yUa))
          {
            AppMethodBeat.o(200558);
            return;
          }
          this.yTZ = j;
          this.yUa = k;
          ac.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramAnonymousInt) });
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
            ac.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsTimeLineUI.E(SnsTimeLineUI.this)) });
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
              Object localObject2 = ((com.tencent.mm.plugin.sns.ui.a.c)localObject1).Pl(paramAnonymousInt - 1);
              if (localObject2 != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject2).dLV();
                if ((localObject2 != null) && (!TextUtils.isEmpty(((TimeLineObject)localObject2).FQo.Url)) && (((TimeLineObject)localObject2).FQo.Url.contains("mp.weixin.qq.com")) && (((TimeLineObject)localObject2).FQo.Ety == 3))
                {
                  i = -1;
                  if (((TimeLineObject)localObject2).FQo.EtC != null) {
                    i = ((TimeLineObject)localObject2).FQo.EtC.hkQ;
                  }
                  ArrayList localArrayList = new ArrayList();
                  localArrayList.add(((TimeLineObject)localObject2).FQo.Url);
                  localArrayList.add(String.valueOf(i));
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).Id));
                  localArrayList.add("");
                  localArrayList.add("");
                  localArrayList.add(((TimeLineObject)localObject2).ncR);
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).CreateTime));
                  localArrayList.add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Tj("__sns_timeline__")));
                  localLinkedList.add(localArrayList);
                }
              }
              paramAnonymousInt += 1;
            }
          }
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).i(localLinkedList, 2);
          label537:
          SnsTimeLineUI.a(SnsTimeLineUI.this).hD(j, k);
          label550:
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)
          {
            localObject1 = SnsTimeLineUI.j(SnsTimeLineUI.this).a(SnsTimeLineUI.a(SnsTimeLineUI.this).yZm);
            com.tencent.mm.vending.g.g.fxs().d(new com.tencent.mm.vending.c.a() {});
          }
          com.tencent.mm.plugin.sns.j.f.ydE.hk(j, k);
          com.tencent.mm.plugin.sns.j.f.ydE.hl(j, k);
          AppMethodBeat.o(200558);
        }
        
        public final void a(com.tencent.mm.plugin.sns.data.l paramAnonymousl) {}
        
        public final void au(int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(200559);
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).yZn.notifyVendingDataChange();
          }
          if (!paramAnonymousBoolean) {
            SnsTimeLineUI.this.ahP().bi(c.b.class);
          }
          AppMethodBeat.o(200559);
        }
        
        public final void d(int paramAnonymousInt, List<Integer> paramAnonymousList1, List<Integer> paramAnonymousList2)
        {
          int j = 1;
          AppMethodBeat.i(200553);
          int i = j;
          if (paramAnonymousInt > 0)
          {
            paramAnonymousList1 = af.dHR().Ph(paramAnonymousInt);
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
            paramAnonymousList1 = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousList1);
            paramAnonymousList2 = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousList2, paramAnonymousList1.aeD(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.c.b((ListView)paramAnonymousList1.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousList2, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          }
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).yZn.notifyVendingDataChange();
          }
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.b(SnsTimeLineUI.this);
          }
          AppMethodBeat.o(200553);
        }
        
        public final void dQF()
        {
          AppMethodBeat.i(200548);
          if (af.dIa().xWq)
          {
            ac.i("MicroMsg.SnsTimeLineUI", "isAutoScrolling, skip onLoadingMore");
            AppMethodBeat.o(200548);
            return;
          }
          com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
          SnsTimeLineUI.n(SnsTimeLineUI.this);
          localc.e(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), false, SnsTimeLineUI.A(SnsTimeLineUI.this));
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GSx, Integer.valueOf(3));
          ac.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
          if (SnsTimeLineUI.B(SnsTimeLineUI.this) == null)
          {
            ac.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
            AppMethodBeat.o(200548);
            return;
          }
          if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
          {
            SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
            SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
          }
          AppMethodBeat.o(200548);
        }
        
        public final View dQG()
        {
          AppMethodBeat.i(200550);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).xZf == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).xZf = ((FrameLayout)SnsTimeLineUI.this.findViewById(2131305824));
          }
          FrameLayout localFrameLayout = SnsTimeLineUI.k(SnsTimeLineUI.this).xZf;
          AppMethodBeat.o(200550);
          return localFrameLayout;
        }
        
        public final MMPullDownView dQH()
        {
          AppMethodBeat.i(200552);
          MMPullDownView localMMPullDownView = (MMPullDownView)SnsTimeLineUI.this.findViewById(2131305047);
          AppMethodBeat.o(200552);
          return localMMPullDownView;
        }
        
        public final boolean dQI()
        {
          AppMethodBeat.i(200554);
          boolean bool = SnsTimeLineUI.D(SnsTimeLineUI.this);
          AppMethodBeat.o(200554);
          return bool;
        }
        
        public final void dQJ()
        {
          AppMethodBeat.i(200555);
          ac.d("MicroMsg.SnsTimeLineUI", "onLoadingTap");
          SnsTimeLineUI.this.dNy();
          if (!SnsTimeLineUI.d(SnsTimeLineUI.this).yEv)
          {
            if (SnsTimeLineUI.u(SnsTimeLineUI.this) != null)
            {
              ac.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
              SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
            }
            com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this);
            localc.d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GSx, Integer.valueOf(2));
          }
          AppMethodBeat.o(200555);
        }
        
        public final void dQK()
        {
          AppMethodBeat.i(200556);
          SnsTimeLineUI.this.dNy();
          AppMethodBeat.o(200556);
        }
        
        public final void dQL()
        {
          AppMethodBeat.i(200557);
          af.dIa().dIJ();
          int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          Object localObject1 = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getChildAt(0);
          ac.i("MicroMsg.SnsTimeLineUI", "will do up fetch isDoingFetch:%s, SnsCore.getSnsUnreadTipManager().isAutoScrolling:%s", new Object[] { Boolean.valueOf(af.dIa().xWr), Boolean.valueOf(af.dIa().xWq) });
          if ((!af.dIa().xWq) && (localObject1 != null) && (i == 0) && (((View)localObject1).getTop() == 0) && (SnsTimeLineUI.d(SnsTimeLineUI.this).yEv))
          {
            if (af.dIa().xWr)
            {
              AppMethodBeat.o(200557);
              return;
            }
            Object localObject2 = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this);
            localObject1 = SnsTimeLineUI.o(SnsTimeLineUI.this);
            i = at.xWN;
            boolean bool = SnsTimeLineUI.q(SnsTimeLineUI.this);
            int j = SnsTimeLineUI.A(SnsTimeLineUI.this);
            if ((((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).hasInit) && (((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).yTN == 0))
            {
              long l = af.dIa().xWn;
              localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).yZJ;
              if (((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).ySE != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).ySE.zml;
                com.tencent.mm.vending.g.g.b(localObject1, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(j), Long.valueOf(l)).c((com.tencent.mm.vending.c.a)localObject2);
              }
            }
            if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
            {
              SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
              SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
            }
          }
          AppMethodBeat.o(200557);
        }
        
        public final View getMaskView()
        {
          AppMethodBeat.i(200551);
          View localView = SnsTimeLineUI.this.findViewById(2131304966);
          AppMethodBeat.o(200551);
          return localView;
        }
        
        public final ListView getSnsListView()
        {
          AppMethodBeat.i(200549);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).list == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).list = ((ListView)SnsTimeLineUI.this.findViewById(2131305038));
          }
          ListView localListView = SnsTimeLineUI.k(SnsTimeLineUI.this).list;
          AppMethodBeat.o(200549);
          return localListView;
        }
        
        public final int getType()
        {
          int i = 1;
          if (SnsTimeLineUI.this.yTN == 1) {
            i = 2;
          }
          return i;
        }
        
        public final void hC(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void rr(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(200560);
          SnsTimeLineUI localSnsTimeLineUI = SnsTimeLineUI.this;
          localSnsTimeLineUI.yTE = paramAnonymousBoolean;
          com.tencent.mm.sdk.platformtools.ao localao = af.cMM();
          com.tencent.mm.plugin.sns.model.f localf = af.dHO();
          com.tencent.mm.plugin.sns.model.b localb = af.dHM();
          if (paramAnonymousBoolean)
          {
            if ((localf.xPQ) || (localb.xPQ))
            {
              localao.removeCallbacks(localSnsTimeLineUI.yTF);
              localao.removeCallbacks(localSnsTimeLineUI.yTG);
              localao.postDelayed(localSnsTimeLineUI.yTF, 0L);
              AppMethodBeat.o(200560);
            }
          }
          else if ((!localf.xPQ) || (!localb.xPQ))
          {
            localao.removeCallbacks(localSnsTimeLineUI.yTF);
            localao.removeCallbacks(localSnsTimeLineUI.yTG);
            localao.postDelayed(localSnsTimeLineUI.yTG, 0L);
          }
          AppMethodBeat.o(200560);
        }
      };
      this.yTK = 0L;
      this.yTL = new a.b() {};
      this.mScreenWidth = 0;
      this.mScreenHeight = 0;
      this.yTM = true;
      this.uup = 0L;
      this.gcx = 0L;
      this.hDh = 0L;
      this.yHk = new SnsTimeLineUI.39(this);
      this.yTN = 0;
      this.yTO = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(200582);
          SnsTimeLineUI.this.hideVKB();
          SnsTimeLineUI.this.finish();
          AppMethodBeat.o(200582);
          return false;
        }
      };
      this.yTR = false;
      AppMethodBeat.o(99372);
      return;
    }
  }
  
  private void PF(int paramInt)
  {
    AppMethodBeat.i(99376);
    if (yTC.booleanValue()) {
      if (paramInt != 0) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.SnsTimeLineUI", "setRefreshAnimVisible %s %s", new Object[] { Boolean.valueOf(bool), bs.eWi().toString() });
      this.ySK.setVisibility(paramInt);
      AppMethodBeat.o(99376);
      return;
    }
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(99406);
    if (paramc.active)
    {
      ac.d("MicroMsg.SnsTimeLineUI", "report weishi: %s", new Object[] { paramc.toString() });
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(15827, paramc.toString());
    }
    AppMethodBeat.o(99406);
  }
  
  private void dQA()
  {
    AppMethodBeat.i(99380);
    boolean bool;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pNf, 0) == 1)
    {
      bool = true;
      this.autoPlay = bool;
      String str1 = Build.MODEL.toLowerCase();
      String str2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pNg, "");
      if ((!bs.isNullOrNil(str2)) && (str2.contains(str1)))
      {
        ac.i("MicroMsg.SnsTimeLineUI", "model %s is hit, expt:%s", new Object[] { str1, str2 });
        this.autoPlay = false;
      }
      if (!this.autoPlay) {
        break label225;
      }
      if (!this.yTe.dPY()) {
        break label170;
      }
      this.autoPlay = false;
      ac.i("MicroMsg.SnsTimeLineUI", "2G/3G autoplay false");
    }
    for (;;)
    {
      ac.i("MicroMsg.SnsTimeLineUI", "autoPlay:%s", new Object[] { Boolean.valueOf(this.autoPlay) });
      AppMethodBeat.o(99380);
      return;
      bool = false;
      break;
      label170:
      if (this.yTe.ccN())
      {
        ac.i("MicroMsg.SnsTimeLineUI", "wifi autoplay true");
        this.autoPlay = true;
      }
      else
      {
        this.autoPlay = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLf, Boolean.TRUE)).booleanValue();
        continue;
        label225:
        ac.i("MicroMsg.SnsTimeLineUI", "autoPlay DynamicConfig false");
      }
    }
  }
  
  private void dQB()
  {
    AppMethodBeat.i(99381);
    if (this.yTN == 1)
    {
      if (!this.yzX)
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
        AppMethodBeat.i(200567);
        SnsTimeLineUI.K(SnsTimeLineUI.this);
        AppMethodBeat.o(200567);
        return true;
      }
    }, new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200568);
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).yxQ != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).yxQ.xUQ.qN(true);
        }
        com.tencent.mm.kernel.g.agS();
        boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(7490, Boolean.TRUE)).booleanValue();
        af.dHY().rd(true);
        paramAnonymousView = af.dHY().auU("draft_text");
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.field_draft;
          if (!bs.cv(paramAnonymousView))
          {
            com.tencent.mm.kernel.g.agS();
            localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGh, "");
            new eb().Rg().lW((String)localObject).aHZ();
            localObject = Parcel.obtain();
            ((Parcel)localObject).unmarshall(paramAnonymousView, 0, paramAnonymousView.length);
            ((Parcel)localObject).setDataPosition(0);
          }
        }
        try
        {
          paramAnonymousView = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject);
          if (SnsTimeLineUI.aJ(paramAnonymousView))
          {
            SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
            AppMethodBeat.o(200568);
            return true;
          }
          af.dHY().b("draft_text", null, 0);
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            af.dHY().b("draft_text", null, 0);
            continue;
            paramAnonymousView = SnsTimeLineUI.this;
            localObject = new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agR().agA().set(7490, Boolean.FALSE);
          }
        }
        if (!bool)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(SnsTimeLineUI.this, SnsUploadUI.class);
          paramAnonymousView.putExtra("KSnsPostManu", true);
          paramAnonymousView.putExtra("KTouchCameraTime", bs.aNx());
          paramAnonymousView.putExtra("sns_comment_type", 1);
          paramAnonymousView.putExtra("Ksnsupload_type", 9);
          localObject = com.tencent.mm.modelsns.d.ps(705);
          ((com.tencent.mm.modelsns.d)localObject).pw(((com.tencent.mm.modelsns.d)localObject).hTL).Do(System.currentTimeMillis()).pw(((com.tencent.mm.modelsns.d)localObject).hTM).pw(1);
          localObject = com.tencent.mm.plugin.sns.j.h.yes.b((com.tencent.mm.modelsns.d)localObject);
          ((com.tencent.mm.modelsns.d)localObject).aHZ();
          ((com.tencent.mm.modelsns.d)localObject).b(paramAnonymousView, "intent_key_StatisticsOplog");
          SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
          AppMethodBeat.o(200568);
          return true;
        }
      }
    });
    AppMethodBeat.o(99381);
  }
  
  private void dQC()
  {
    AppMethodBeat.i(99392);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GWq, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWq, Boolean.FALSE);
    if (bool) {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWq, Boolean.FALSE);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.g.agS();
      int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GSG, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(getContext(), "", getContext().getResources().getString(2131764291, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(99392);
      return;
    }
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).startStoryCaptureForResult(getContext(), 0, System.currentTimeMillis(), 18);
    AppMethodBeat.o(99392);
  }
  
  private void dQD()
  {
    AppMethodBeat.i(99393);
    if (com.tencent.mm.r.a.cf(this))
    {
      AppMethodBeat.o(99393);
      return;
    }
    if (com.tencent.mm.r.a.ck(this))
    {
      AppMethodBeat.o(99393);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "");
    ac.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this });
    if (!bool)
    {
      AppMethodBeat.o(99393);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 18, "", "");
    ac.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this });
    if (!bool)
    {
      AppMethodBeat.o(99393);
      return;
    }
    long l = ce.azI();
    Object localObject1 = com.tencent.mm.plugin.sns.data.q.dGC();
    ac.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", new Object[] { localObject1 });
    com.tencent.mm.plugin.report.service.h.wUl.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), localObject1, Long.valueOf(l) });
    Object localObject2 = new SightParams(2, 0);
    localObject2 = RecordConfigProvider.a("", "", ((SightParams)localObject2).hcZ, ((SightParams)localObject2).hcZ.duration * 1000, 2);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pTQ, false)) {
      ((RecordConfigProvider)localObject2).remuxType = 2;
    }
    Object localObject3 = new VideoCaptureReportInfo();
    ((VideoCaptureReportInfo)localObject3).qwN = 1;
    ((RecordConfigProvider)localObject2).wqK = ((VideoCaptureReportInfo)localObject3);
    localObject3 = new UICustomParam.a();
    ((UICustomParam.a)localObject3).YW();
    ((UICustomParam.a)localObject3).YX();
    ((UICustomParam.a)localObject3).cN(true);
    ((RecordConfigProvider)localObject2).wqu = ((UICustomParam.a)localObject3).fKH;
    localObject3 = new SnsTimeLineUI.63(this);
    CaptureDataManager.wqi.wqh = ((CaptureDataManager.b)localObject3);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pTO, true))
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 17, 2130772137, 2130772138, (RecordConfigProvider)localObject2);
      AppMethodBeat.o(99393);
      return;
    }
    localObject2 = new Intent();
    com.tencent.mm.pluginsdk.ui.tools.q.c(getContext(), (Intent)localObject2, (String)localObject1);
    AppMethodBeat.o(99393);
  }
  
  private void dQz()
  {
    AppMethodBeat.i(99377);
    this.mUIAction.list.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99306);
        int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
        int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
        ac.d("MicroMsg.SnsTimeLineUI", "notifyList from:%s to:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        SnsTimeLineUI.a(SnsTimeLineUI.this, i, j);
        SnsTimeLineUI.d(SnsTimeLineUI.this).biX();
        AppMethodBeat.o(99306);
      }
    }, 15L);
    AppMethodBeat.o(99377);
  }
  
  private void dzV()
  {
    AppMethodBeat.i(99391);
    setTitleBarClickListener(new SnsTimeLineUI.55(this), new SnsTimeLineUI.57(this));
    setBackBtn(this.yTO, 2131689490);
    AppMethodBeat.o(99391);
  }
  
  private boolean eW(View paramView)
  {
    AppMethodBeat.i(200592);
    try
    {
      if (getContext() != null)
      {
        boolean bool = getContext().isFinishing();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(200592);
        return false;
      }
      Rect localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      paramView = new DisplayMetrics();
      getContext().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      int i = paramView.heightPixels;
      int j = this.mActionBar.getHeight() + com.tencent.mm.ui.aj.jw(this);
      ac.i("MicroMsg.SnsTimeLineUI.ScreenShot", "lxl checkItemVisible actionbar height:%s, total height:%s, screenHeight:%s, top:%s, bottom:%s", new Object[] { Integer.valueOf(this.mActionBar.getHeight()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localRect.top), Integer.valueOf(localRect.bottom) });
      if ((localRect.bottom > j) && (i > localRect.top))
      {
        AppMethodBeat.o(200592);
        return true;
      }
    }
    catch (Throwable paramView)
    {
      ac.e("MicroMsg.SnsTimeLineUI.ScreenShot", paramView.toString());
      AppMethodBeat.o(200592);
      return false;
    }
    AppMethodBeat.o(200592);
    return false;
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(200591);
    ac.i("MicroMsg.SnsTimeLineUI", "onOtherAddSize respMaxSeq:%s, respMinSeq:%s", new Object[] { paramString1, paramString2 });
    this.yTH.removeCallbacks(this.yTh);
    com.tencent.mm.vending.g.g.fxs().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(200591);
  }
  
  public final void a(final String paramString, boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99373);
    this.yTH.removeCallbacks(this.yTh);
    com.tencent.mm.vending.g.g.fxs().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(99373);
  }
  
  public final void ayA() {}
  
  public final void ayB()
  {
    AppMethodBeat.i(99397);
    if (this.yTR)
    {
      AppMethodBeat.o(99397);
      return;
    }
    ac.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
    this.yTR = true;
    af.cMM().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179283);
        if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
          SnsTimeLineUI.a(SnsTimeLineUI.this).yZn.notifyVendingDataChange();
        }
        SnsTimeLineUI.Y(SnsTimeLineUI.this);
        AppMethodBeat.o(179283);
      }
    }, 1000L);
    AppMethodBeat.o(99397);
  }
  
  public final void ayC()
  {
    AppMethodBeat.i(99400);
    ahP().bi(c.b.class);
    AppMethodBeat.o(99400);
  }
  
  public final void ayz()
  {
    AppMethodBeat.i(99396);
    ahP().bi(c.b.class);
    AppMethodBeat.o(99396);
  }
  
  public final void b(final String paramString, final boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99374);
    this.yTH.removeCallbacks(this.yTh);
    com.tencent.mm.vending.g.g.fxs().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
    {
      private Void a(Void paramAnonymousVoid)
      {
        AppMethodBeat.i(200544);
        if (SnsTimeLineUI.l(SnsTimeLineUI.this) != null)
        {
          SnsTimeLineUI.m(SnsTimeLineUI.this);
          SnsTimeLineUI.l(SnsTimeLineUI.this).dQS();
        }
        SnsTimeLineUI.d(SnsTimeLineUI.this).ohk = paramb.dGe();
        if (SnsTimeLineUI.this.yTN == 0)
        {
          ac.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[] { Boolean.valueOf(paramb.dGe()) });
          if (paramb.dGe()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).avN(paramb.dGk());
          }
          AppMethodBeat.o(200544);
          return paramAnonymousVoid;
        }
        if ((paramBoolean) && (!SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))))
        {
          SnsTimeLineUI.d(SnsTimeLineUI.this).ohk = true;
          SnsTimeLineUI.d(SnsTimeLineUI.this).avB(paramb.dGk());
        }
        for (;;)
        {
          AppMethodBeat.o(200544);
          return paramAnonymousVoid;
          if ((SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))) && (paramb.dGj() != 0L))
          {
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLx, Long.valueOf(paramb.dGj()));
          }
          if (paramb.dGe()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).avN(paramb.dGk());
          }
        }
      }
    });
    AppMethodBeat.o(99374);
  }
  
  public final boolean dNy()
  {
    AppMethodBeat.i(99395);
    if ((this.ySN == null) || (this.ySN.yyb == null))
    {
      AppMethodBeat.o(99395);
      return false;
    }
    if ((this.ySN == null) || (this.ySN.yyc == null))
    {
      if ((this.ySN != null) && (this.ySN.yye != null)) {
        break label118;
      }
      label65:
      if ((this.ySN != null) && (this.ySN.yyf != null)) {
        break label132;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.dFv();
      boolean bool = this.ySN.yyb.dNy();
      AppMethodBeat.o(99395);
      return bool;
      this.ySN.yyc.dJj();
      break;
      label118:
      this.ySN.yye.dJj();
      break label65;
      label132:
      this.ySN.yyf.dRx();
    }
  }
  
  public final com.tencent.mm.plugin.sns.ad.d.i dQE()
  {
    return this.yJJ;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(99378);
    ac.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[] { paramKeyEvent.toString() });
    int k = keyboardState();
    i locali = this.ySN;
    int i = j;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      i = j;
      if (locali.yxU.getVisibility() == 0)
      {
        locali.yxU.setVisibility(8);
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
  
  public final boolean eS(View paramView)
  {
    AppMethodBeat.i(99394);
    this.ySN.yyc.dJj();
    this.ySN.yye.dJj();
    bm localbm = this.ySN.yyb;
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      ac.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
      AppMethodBeat.o(99394);
      return false;
    }
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    Object localObject1 = localBaseViewHolder.ddB;
    if (localbm.yYE != null)
    {
      if ((localbm.yYE.getTag() instanceof bm.a))
      {
        localObject2 = (bm.a)localbm.yYE.getTag();
        if (((bm.a)localObject2).xZz.equals(localObject1))
        {
          localbm.eX(((bm.a)localObject2).xIw);
          AppMethodBeat.o(99394);
          return true;
        }
        localbm.dNy();
      }
      localbm.yYE = null;
    }
    localbm.yYE = new SnsCommentShowAbLayout(localbm.mContext);
    com.tencent.mm.sdk.platformtools.p.eUA();
    localbm.yYE.setId(2131296470);
    new FrameLayout.LayoutParams(-1, -1);
    localbm.xZf.addView(localbm.yYE);
    int i = BackwardSupportUtil.b.g(localbm.mContext, 192.0F);
    int j = BackwardSupportUtil.b.g(localbm.mContext, 76.0F);
    BackwardSupportUtil.b.g(localbm.mContext, 8.0F);
    int k = BackwardSupportUtil.b.g(localbm.mContext, 16.0F);
    int m = BackwardSupportUtil.b.g(localbm.mContext, 40.0F);
    Object localObject2 = z.jD(localbm.mContext).inflate(2131495535, null);
    new Rect();
    Object localObject3 = new int[2];
    com.tencent.mm.pluginsdk.g.hh(localbm.mContext);
    int n = com.tencent.mm.cc.a.fromDPToPix(localbm.mContext, 1);
    paramView.getLocationInWindow((int[])localObject3);
    localbm.xJx = com.tencent.mm.ui.aj.jw(localbm.mContext);
    ac.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + n + " height_hardcode:" + j + " statusBarHeight: " + localbm.xJx);
    localObject3 = new AbsoluteLayout.LayoutParams(-2, -2, localObject3[0] - i + k, localObject3[1] - n - (m / 2 - paramView.getMeasuredHeight() / 2));
    localObject1 = new bm.a(localbm, (String)localObject1, (View)localObject2);
    localbm.yYE.setTag(localObject1);
    localbm.yYE.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    if (localBaseViewHolder.oeH == 10) {
      ((View)localObject2).findViewById(2131296548).setBackgroundResource(2131232447);
    }
    ((View)localObject2).setVisibility(8);
    new com.tencent.mm.sdk.platformtools.ao().post(new bm.1(localbm, paramView, (View)localObject2));
    AppMethodBeat.o(99394);
    return true;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(99399);
    ac.d("MicroMsg.SnsTimeLineUI", "finalize");
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
    this.mUIAction.yaU.setDrawingCacheEnabled(false);
    this.ySN.xZf = ((FrameLayout)findViewById(2131305824));
    int i = af.dHZ().position;
    Object localObject = (AdListView)this.mUIAction.getSnsListView();
    ((AdListView)localObject).ywm = this.yJJ;
    ((AdListView)localObject).setTimelineStat(this.ySV);
    ((AdListView)localObject).setTimelineEvent(this.ySW);
    this.ySW.a(af.dHI());
    ac.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.yxZ, new Object[] { Integer.valueOf(i) });
    this.ySK = ((QFadeImageView)findViewById(2131305048));
    this.ySK.setImageResource(2131690250);
    this.ySP = new a(this.mUIAction.getSnsListView());
    this.ySP.setInterpolator(new LinearInterpolator());
    this.ySP.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(200572);
        ac.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
        AppMethodBeat.o(200572);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(200571);
        ac.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
        AppMethodBeat.o(200571);
      }
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(200570);
        ac.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
        AppMethodBeat.o(200570);
      }
    });
    localObject = null;
    if (this.yTN == 1)
    {
      this.ySM = true;
      localObject = new com.tencent.mm.plugin.sns.ui.a.b.d(this.lhM, this.yzX);
    }
    this.ySH = new com.tencent.mm.plugin.sns.ui.a.c(this, this.mUIAction.getSnsListView(), this.ySN.yyg, this.ySN, this.ySX, (com.tencent.mm.plugin.sns.ui.a.b.b)localObject, this.yTk);
    this.ySN.yyg.zha = new be.b()
    {
      public final boolean dQy()
      {
        AppMethodBeat.i(200573);
        SnsTimeLineUI.this.ahP().bi(c.b.class);
        AppMethodBeat.o(200573);
        return false;
      }
    };
    this.ySN.xZJ = this.ySH.yZm;
    this.ySH.yZn.Jpk = new com.tencent.mm.vending.a.b.a()
    {
      public final void dQO()
      {
        AppMethodBeat.i(200574);
        com.tencent.mm.plugin.report.service.g.MH(14);
        AppMethodBeat.o(200574);
      }
      
      public final void dQP()
      {
        AppMethodBeat.i(200575);
        com.tencent.mm.plugin.report.service.g.MI(14);
        AppMethodBeat.o(200575);
      }
    };
    this.ySQ = ((TestTimeForSns)this.ySN.xZf);
    this.ySQ.setListener(new TestTimeForSns.a()
    {
      public final void cNI()
      {
        AppMethodBeat.i(200576);
        ac.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
        SnsTimeLineUI.H(SnsTimeLineUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176335);
            if ((SnsTimeLineUI.a(SnsTimeLineUI.this) == null) || (SnsTimeLineUI.H(SnsTimeLineUI.this) == null))
            {
              ac.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
              AppMethodBeat.o(176335);
              return;
            }
            SnsTimeLineUI.H(SnsTimeLineUI.this).setListener(null);
            SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.N(SnsTimeLineUI.this));
            if (SnsTimeLineUI.O(SnsTimeLineUI.this))
            {
              ac.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
              AppMethodBeat.o(176335);
              return;
            }
            if (SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              af.dHH().Q(af.dHZ().xVl, -1);
              af.dHH().xs(af.dHZ().xVm);
            }
            if (!SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              ac.i("MicroMsg.SnsTimeLineUI", "onViewDrawed doFpList");
              com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
              SnsTimeLineUI.n(SnsTimeLineUI.this);
              localc.d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GSx, Integer.valueOf(1));
            }
            SnsTimeLineUI.a(SnsTimeLineUI.this, false);
            if (SnsTimeLineUI.this.yJJ != null) {
              SnsTimeLineUI.this.yJJ.qG(false);
            }
            AppMethodBeat.o(176335);
          }
        });
        AppMethodBeat.o(200576);
      }
    });
    this.mUIAction.list.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(200577);
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          SnsTimeLineUI.this.dNy();
          if ((SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) && (SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() == 0)) {
            ac.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
          }
          SnsTimeLineUI.l(SnsTimeLineUI.this).dQT();
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          }
          SnsTimeLineUI.k(SnsTimeLineUI.this).dNh();
          SnsTimeLineUI.k(SnsTimeLineUI.this).yxV.dRw();
        }
        AppMethodBeat.o(200577);
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
        SnsTimeLineUI.k(SnsTimeLineUI.this).yxV.yJr = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getBottom();
        SnsTimeLineUI.k(SnsTimeLineUI.this).yxV.yYJ = SnsTimeLineUI.d(SnsTimeLineUI.this).uEW.getTop();
        SnsTimeLineUI.l(SnsTimeLineUI.this).yUw = com.tencent.mm.ui.ao.fromDPToPix(SnsTimeLineUI.this.getContext(), -44);
        AppMethodBeat.o(176343);
      }
    });
    this.mUIAction.uEW.setOnSrcollDistance(new MMPullDownView.f()
    {
      public final void bD(float paramAnonymousFloat)
      {
        AppMethodBeat.i(200578);
        SnsTimeLineUI.P(SnsTimeLineUI.this);
        if (SnsTimeLineUI.yTC.booleanValue()) {
          ac.i("MicroMsg.SnsTimeLineUI", "mUIAction.header.getTop %s originalHeaderTop %s distanceY %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).yaU.getTop()), Integer.valueOf(SnsTimeLineUI.l(SnsTimeLineUI.this).yUw), Float.valueOf(paramAnonymousFloat) });
        }
        if (((SnsTimeLineUI.d(SnsTimeLineUI.this).yaU.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).yUw) || (paramAnonymousFloat > 0.0F)) && (!SnsTimeLineUI.d(SnsTimeLineUI.this).yEv)) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).bE(paramAnonymousFloat);
        }
        SnsTimeLineUI.k(SnsTimeLineUI.this).dNh();
        SnsTimeLineUI.this.dNy();
        SnsTimeLineUI.k(SnsTimeLineUI.this).yxV.dRw();
        AppMethodBeat.o(200578);
      }
      
      public final void dQQ()
      {
        AppMethodBeat.i(200579);
        if (!SnsTimeLineUI.d(SnsTimeLineUI.this).yEv) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).dQT();
        }
        AppMethodBeat.o(200579);
      }
    });
    this.ySN.yxU = ((SnsCommentFooter)findViewById(2131298521));
    this.ySN.yxU.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99338);
        com.tencent.mm.compatible.util.i.v(SnsTimeLineUI.this);
        AppMethodBeat.o(99338);
      }
    });
    this.ySN.yxV = new bn(this.mUIAction.list, this.ySN.yxU);
    this.ySI = ((LinearLayout)this.mUIAction.yaU.findViewById(2131305028));
    this.ySI.findViewById(2131305024).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179269);
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).yxQ != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).yxQ.xUQ.qM(true);
        }
        paramAnonymousView = (c.b)SnsTimeLineUI.this.ahP().w(c.b.class);
        com.tencent.mm.modelsns.d locald = com.tencent.mm.modelsns.d.ps(725);
        locald.pv(paramAnonymousView.sIT);
        locald.aHZ();
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
        paramAnonymousView.putExtra("sns_msg_comment_list_scene", 1);
        SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 13);
        AppMethodBeat.o(179269);
      }
    });
    this.ySJ = ((LinearLayout)this.mUIAction.yaU.findViewById(2131305029));
    this.ySN.yxW = new av(this);
    dQB();
    dzV();
    boolean bool1;
    label591:
    boolean bool2;
    if (this.yTN == 0)
    {
      setMMTitle(2131764037);
      if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.h.DEBUG)) {
        break label923;
      }
      bool1 = true;
      if (1 != ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pZM, 0)) {
        break label928;
      }
      bool2 = true;
      label615:
      ac.i("MicroMsg.SnsTimeLineUI", "getGpuMaxTextureSize %s %s.", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1)
      {
        bool1 = bool3;
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      com.tencent.mm.sdk.platformtools.p.vT(bool1);
      if (bool1)
      {
        i = com.tencent.mm.sdk.platformtools.p.eUB();
        if (i > 2048) {
          break label933;
        }
        com.tencent.mm.plugin.report.service.h.wUl.dB(1198, 7);
      }
    }
    for (;;)
    {
      this.yTf = ((ViewGroup)findViewById(2131305092));
      this.yTf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(200580);
          SnsTimeLineUI.k(SnsTimeLineUI.this).dNm();
          com.tencent.mm.plugin.sns.j.f.ydE.yek.dYt = 2L;
          AppMethodBeat.o(200580);
        }
      });
      this.yTf.setVisibility(4);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = (com.tencent.mm.ui.ao.fromDPToPix(getContext(), 24) + com.tencent.mm.ui.ap.dT(getContext()) + com.tencent.mm.ui.ap.ji(getContext()));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.yTf.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(99388);
      return;
      if (this.yzX)
      {
        setMMTitle(2131763939);
        PF(8);
        break;
      }
      ac.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, userName:%s, title:%s", new Object[] { this.lhM, this.mUIAction.title });
      localObject = af.dHF().aNt(this.lhM);
      if (localObject != null) {
        ac.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is not null");
      }
      for (localObject = ((com.tencent.mm.n.b)localObject).aaS();; localObject = this.mUIAction.title)
      {
        setMMTitle(com.tencent.mm.plugin.sns.data.q.P((CharSequence)localObject));
        break;
        ac.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is null, title:%s", new Object[] { this.mUIAction.title });
      }
      label923:
      bool1 = false;
      break label591;
      label928:
      bool2 = false;
      break label615;
      label933:
      if (i <= 4096) {
        com.tencent.mm.plugin.report.service.h.wUl.dB(1198, 8);
      } else if (i <= 6144) {
        com.tencent.mm.plugin.report.service.h.wUl.dB(1198, 9);
      } else if (i <= 8192) {
        com.tencent.mm.plugin.report.service.h.wUl.dB(1198, 10);
      } else {
        com.tencent.mm.plugin.report.service.h.wUl.dB(1198, 11);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99402);
    ac.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 15)
    {
      if ((this.ySN != null) && (this.ySN.yyg != null) && (this.ySN.yyg.zgp != null))
      {
        this.ySN.yyg.zgp.onActivityResult(paramInt1, paramInt2, paramIntent);
        com.tencent.mm.sdk.platformtools.ap.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200589);
            SnsTimeLineUI.this.hideVKB();
            AppMethodBeat.o(200589);
          }
        }, 300L);
      }
      AppMethodBeat.o(99402);
      return;
    }
    if (paramInt1 == 16)
    {
      ac.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
      AppMethodBeat.o(99402);
      return;
    }
    if ((paramInt1 == 2333) && (paramIntent != null))
    {
      Object localObject = paramIntent.getStringExtra("Select_Contact");
      if (!bs.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split(",");
        if (localObject.length > 0)
        {
          this.ySN.yxU.iMV.showVKB();
          String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(localObject[0]);
          if (!bs.isNullOrNil(str))
          {
            this.ySN.yxU.dPB();
            this.ySN.yxU.setText("@" + str + " ");
            this.ySN.yxU.setCommentAtPrefix("@" + str + " ");
            this.ySN.yxU.setCommentInfo(new daa());
            this.ySN.yxU.getCommentInfo().Username = localObject[0];
            this.ySN.yxU.setCommentFlag(8);
          }
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mUIAction.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 11)
    {
      this.ySG.d(this.lhM, this.ySY, this.yzX, this.ySZ);
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
    ac.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
    com.tencent.mm.sdk.b.a.GpY.l(new cf());
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    Point localPoint = new Point();
    localPoint.x = paramConfiguration.widthPixels;
    localPoint.y = paramConfiguration.heightPixels;
    af.h(localPoint);
    com.tencent.mm.plugin.sns.ui.widget.f.dSL().zkU = 0;
    com.tencent.mm.plugin.sns.ui.widget.d.dSI().zkU = 0;
    com.tencent.mm.kiss.widget.textview.c.gkZ.ahT();
    this.ySH.yZm.dQp();
    this.ySH.yZn.resolvedClear();
    AppMethodBeat.o(99382);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 1;
    AppMethodBeat.i(99379);
    Object localObject1;
    if (yTb == null)
    {
      yTb = Boolean.valueOf(com.tencent.mm.ui.aj.DT());
      com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
      com.tencent.mm.plugin.sns.model.b.a.dJb();
      localObject1 = af.dHP();
      ((com.tencent.mm.plugin.sns.model.av)localObject1).hZE = true;
      ac.i("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.sns.model.av)localObject1).hZE) });
      if (((((com.tencent.mm.plugin.sns.model.av)localObject1).hZE) && (!com.tencent.mm.plugin.sns.model.b.a.dJc())) || (((com.tencent.mm.plugin.sns.model.av)localObject1).hZD)) {
        ((com.tencent.mm.plugin.sns.model.av)localObject1).dIM();
      }
      o.aJA().eU(((com.tencent.mm.plugin.sns.model.av)localObject1).hZE);
      localObject1 = af.dIa();
      if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
        break label877;
      }
      ((com.tencent.mm.plugin.sns.model.as)localObject1).xVW = true;
      ((com.tencent.mm.plugin.sns.model.as)localObject1).xVX = 1L;
      ((com.tencent.mm.plugin.sns.model.as)localObject1).xVY = 86400L;
      ((com.tencent.mm.plugin.sns.model.as)localObject1).xVZ = 1;
      ((com.tencent.mm.plugin.sns.model.as)localObject1).xWa = 1;
      ((com.tencent.mm.plugin.sns.model.as)localObject1).xWb = 50;
      ((com.tencent.mm.plugin.sns.model.as)localObject1).xWd = 2;
      ((com.tencent.mm.plugin.sns.model.as)localObject1).xWc = 5;
      ((com.tencent.mm.plugin.sns.model.as)localObject1).xWe = 0L;
      label170:
      ac.i("MicroMsg.SnsUnreadTipManager", "jumpEnable:%s, jumpMinInterval:%s, jumpMaxInterval:%s, jumpMinFeedsCount:%s, jumpMinFeedsGapCount:%s, jumpNotWsPercent:%s, jumpIndicatorIndexOffset:%s, jumpReadContinuousCount:%s, jumpIndicatorExposeInterval:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xVW), Long.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xVX), Long.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xVY), Integer.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xVZ), Integer.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xWa), Integer.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xWb), Integer.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xWd), Integer.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xWc), Long.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xWe) });
      if (((com.tencent.mm.plugin.sns.model.as)localObject1).xVW) {
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xVV = (af.getAccSnsPath() + "snsUnread.proto");
      }
    }
    int i;
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = com.tencent.mm.vfs.i.aU(((com.tencent.mm.plugin.sns.model.as)localObject1).xVV, 0, -1);
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          ((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.parseFrom(arrayOfByte);
          i = ce.azK();
          ac.i("MicroMsg.SnsUnreadTipManager", "unreadSnsIdList.indicatorExposeTime:%s, now:%s, jumpIndicatorExposeInterval:%s", new Object[] { Long.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.xWw), Integer.valueOf(i), Long.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xWe) });
          if ((((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.xWw <= 0L) || (i - ((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.xWw <= ((com.tencent.mm.plugin.sns.model.as)localObject1).xWe)) {
            continue;
          }
          ((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.xWw = 0L;
          ((com.tencent.mm.plugin.sns.model.as)localObject1).xWw = ((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.xWw;
          ((com.tencent.mm.plugin.sns.model.as)localObject1).dIF();
        }
      }
      catch (IOException localIOException)
      {
        label877:
        ac.w("MicroMsg.SnsUnreadTipManager", "IOException:%s", new Object[] { localIOException.getMessage() });
        continue;
        bool = false;
        continue;
        com.tencent.mm.plugin.sns.model.ap.xVE = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWu, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWt, 1) != 1) {
          continue;
        }
        bool = true;
        com.tencent.mm.plugin.sns.model.ap.xVF = bool;
        com.tencent.mm.plugin.sns.model.ap.xVG = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWv, 60);
        continue;
        bool = false;
        continue;
        long l = com.tencent.mm.plugin.sns.model.ap.xVE - bs.Ap(((com.tencent.mm.plugin.sns.model.ap)localObject1).xVH);
        ac.i(com.tencent.mm.plugin.sns.model.ap.TAG, "delay %s to reset", new Object[] { Long.valueOf(l) });
        com.tencent.mm.sdk.platformtools.ap.n(((com.tencent.mm.plugin.sns.model.ap)localObject1).xVJ, l);
        continue;
        this.vJh = findViewById(2131296345);
        if (this.vJh == null) {
          break label1538;
        }
      }
      ((com.tencent.mm.plugin.sns.model.as)localObject1).dID();
      ((com.tencent.mm.plugin.sns.model.as)localObject1).dIE();
      ac.i("MicroMsg.SnsUnreadTipManager", "firstUnreadId:%s unreadSnsIdList.lastSnsId:%s", new Object[] { Long.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xWj), Long.valueOf(((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.yaN) });
      ((com.tencent.mm.plugin.sns.model.as)localObject1).dIG();
      ((com.tencent.mm.plugin.sns.model.as)localObject1).sessionId = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).ciu();
      localObject1 = ((com.tencent.mm.plugin.sns.model.as)localObject1).xWC;
      com.tencent.mm.kernel.g.agQ().ghe.a(211, (com.tencent.mm.ak.g)localObject1);
      localObject1 = af.dIb();
      ac.i(com.tencent.mm.plugin.sns.model.ap.TAG, "create");
      if ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE))
      {
        com.tencent.mm.plugin.sns.model.ap.xVE = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWu, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWt, 1) == 1)
        {
          bool = true;
          com.tencent.mm.plugin.sns.model.ap.xVF = bool;
          com.tencent.mm.plugin.sns.model.ap.xVG = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWv, 60);
          ac.i(com.tencent.mm.plugin.sns.model.ap.TAG, "updateConfig configEnable:%s, configInterval:%s, configExpiredTime:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.sns.model.ap.xVF), Integer.valueOf(com.tencent.mm.plugin.sns.model.ap.xVG), Long.valueOf(com.tencent.mm.plugin.sns.model.ap.xVE) });
          if (((com.tencent.mm.plugin.sns.model.ap)localObject1).xVH != 0L)
          {
            if (bs.Ap(((com.tencent.mm.plugin.sns.model.ap)localObject1).xVH) < com.tencent.mm.plugin.sns.model.ap.xVE) {
              continue;
            }
            ac.i(com.tencent.mm.plugin.sns.model.ap.TAG, "already expired, reset directly");
            com.tencent.mm.sdk.platformtools.ap.f(((com.tencent.mm.plugin.sns.model.ap)localObject1).xVJ);
          }
          if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class) != null) {
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Ti("__sns_timeline__");
          }
          if (this.mController != null) {
            this.mController.aX(2, true);
          }
          getIntent().setExtrasClassLoader(getClass().getClassLoader());
          com.tencent.mm.pluginsdk.g.o(this);
          customfixStatusbar(true);
          super.onCreate(paramBundle);
          if (com.tencent.mm.kernel.g.agP().afY()) {
            continue;
          }
          finish();
          AppMethodBeat.o(99379);
          return;
          if (yTb.booleanValue() == com.tencent.mm.ui.aj.DT()) {
            break;
          }
          ac.i("MicroMsg.SnsTimeLineUI", "dancy test UIMode change!!");
          yTb = Boolean.valueOf(com.tencent.mm.ui.aj.DT());
          com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
          break;
          if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE))
          {
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xVW = true;
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xVX = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qaZ, 120L);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xVZ = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qba, 5);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xWa = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbc, 3);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xVY = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbd, 86400L);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xWb = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbe, 50);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xWd = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbg, 5);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xWc = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbf, 30);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xWe = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbh, 0);
            break label170;
          }
          if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbb, 0) == 1)
          {
            bool = true;
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xVW = bool;
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xVX = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qaZ, 0);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xVZ = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qba, 0);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xWa = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbc, 0);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xVY = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbd, 86400L);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xWb = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbe, 50);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xWd = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbg, 5);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xWc = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbf, 30);
            ((com.tencent.mm.plugin.sns.model.as)localObject1).xWe = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbh, 0);
            break label170;
          }
          bool = false;
          continue;
          if (((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.xWw >= 0L) {
            continue;
          }
          ((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.xWw = 0L;
          continue;
        }
      }
      if (com.tencent.mm.ui.statusbar.c.ILV) {
        break label3704;
      }
    }
    label1538:
    getWindow().getDecorView().setSystemUiVisibility(1280);
    paramBundle = ai.eUY();
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("Main_need_read_top_margin", false);; bool = false)
    {
      com.tencent.mm.ui.b.c(this, bool);
      this.ySO = ((int)(getResources().getDisplayMetrics().heightPixels * 0.4D));
      setActionbarColor(getContext().getResources().getColor(2131101053));
      hideActionbarLine();
      this.yTN = getIntent().getIntExtra("sns_adapter_type", 0);
      this.ySM = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
      this.mActionBar = getSupportActionBar();
      i = com.tencent.mm.model.c.d.aAq().fP("Sns_Private_Recent_Setting_Guide", 0);
      ac.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = ".concat(String.valueOf(i)));
      if (i == 1)
      {
        com.tencent.mm.kernel.g.agS();
        if (!com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GLC, false))
        {
          paramBundle = getIntent();
          paramBundle.setClass(getContext(), SnsSettingIntroduceUI.class);
          paramBundle = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.aeD(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramBundle.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          overridePendingTransition(0, 0);
          finish();
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GLC, Boolean.TRUE);
        }
      }
      this.yTe.yOK = new az.b()
      {
        public final void dQa()
        {
          AppMethodBeat.i(200562);
          SnsTimeLineUI.I(SnsTimeLineUI.this);
          AppMethodBeat.o(200562);
        }
      };
      dQA();
      com.tencent.e.h.JZN.aS(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200563);
          com.tencent.mm.cj.b.fep();
          AppMethodBeat.o(200563);
        }
      });
      this.ySF.a(c.b.class, this.yTL);
      localObject1 = this.ySG;
      i = this.yTN;
      paramBundle = getIntent();
      com.tencent.mm.plugin.sns.l.b localb = this.ySE;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yTN = i;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = true;
      Object localObject2;
      if (i == 0)
      {
        localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZJ;
        ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).ySE = localb;
        if (localb != null)
        {
          paramBundle = localb.dSV();
          label1939:
          ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).ySF = paramBundle;
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZJ.ySF.a(this);
          label1957:
          paramBundle = this.ySG;
          if (paramBundle.yTN != 0) {
            break label3924;
          }
          paramBundle = (com.tencent.mm.plugin.sns.l.c.a)paramBundle.yZJ.ySF.w(com.tencent.mm.plugin.sns.l.c.a.class);
          label1986:
          this.lhM = paramBundle.lhM;
          this.ySX = paramBundle.ySX;
          this.ySY = paramBundle.ySY;
          this.yzX = paramBundle.yzX;
          this.ySZ = paramBundle.ySZ;
          localObject1 = paramBundle.iXH;
          paramBundle = paramBundle.bUS;
          this.mSessionId = com.tencent.mm.ui.e.aPv("123");
          this.yTa = String.valueOf(System.currentTimeMillis());
          this.mUIAction = new SnsUIAction(this);
          this.mUIAction.setSessionId(this.mSessionId);
          this.mUIAction.ycH = this.yTa;
          this.mUIAction.yWh = this.yTJ;
          this.mUIAction.actionbarView = this.mActionBar.getCustomView();
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().kr(2);
          com.tencent.mm.plugin.sns.ui.widget.f.dSL().zkU = 0;
          com.tencent.mm.plugin.sns.ui.widget.d.dSI().zkU = 0;
          localObject2 = com.tencent.mm.modelsns.e.hTW;
          com.tencent.mm.modelsns.e.aIa();
          if (!getIntent().getBooleanExtra("is_sns_notify_open", true)) {
            break label3932;
          }
          i = 1;
          label2174:
          this.ySN = new i(this, i, bs.bG(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0), this.yTa);
          this.ySN.yxT = new i.b()
          {
            public final void dNm()
            {
              AppMethodBeat.i(200564);
              com.tencent.mm.plugin.report.service.h.wUl.dB(1295, 2);
              Object localObject = af.dIa();
              if (((com.tencent.mm.plugin.sns.model.as)localObject).xVW) {
                af.dvq().post(new as.4((com.tencent.mm.plugin.sns.model.as)localObject));
              }
              com.tencent.mm.plugin.sns.j.f.ydE.yek.dYs = 1L;
              localObject = af.dIa();
              int i;
              if ((!((com.tencent.mm.plugin.sns.model.as)localObject).dIC()) || (((com.tencent.mm.plugin.sns.model.as)localObject).xWh.get(((com.tencent.mm.plugin.sns.model.as)localObject).xWt.qJs.peek()) == null))
              {
                i = -1;
                localObject = af.dIa();
                if (((com.tencent.mm.plugin.sns.model.as)localObject).dIC()) {
                  break label390;
                }
              }
              com.tencent.mm.hellhoundlib.b.a locala;
              label390:
              for (int j = 0;; j = ((com.tencent.mm.plugin.sns.model.as)localObject).xWt.qJs.size())
              {
                ac.d("MicroMsg.SnsTimeLineUI", "rightIndex:%s, targetSize:%s, adapter.count:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) });
                af.dIa().eF(null);
                SnsTimeLineUI.J(SnsTimeLineUI.this).setVisibility(4);
                if ((i == -1) || (j + i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount())) {
                  break label405;
                }
                af.dIa().dIK();
                af.dIa().xWn = 0L;
                j = SnsTimeLineUI.this.getResources().getDimensionPixelSize(2131166841);
                int k = com.tencent.mm.ui.ap.dT(SnsTimeLineUI.this.getContext());
                int m = com.tencent.mm.ui.ap.ji(SnsTimeLineUI.this.getContext());
                localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                locala = com.tencent.mm.hellhoundlib.b.c.a(i + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), com.tencent.mm.hellhoundlib.b.c.a(k + m - j, new com.tencent.mm.hellhoundlib.b.a()));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                ((ListView)localObject).smoothScrollToPositionFromTop(((Integer)locala.lR(0)).intValue(), ((Integer)locala.lR(1)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                AppMethodBeat.o(200564);
                return;
                i = ((Integer)((com.tencent.mm.plugin.sns.model.as)localObject).xWh.get(((com.tencent.mm.plugin.sns.model.as)localObject).xWt.qJs.peek())).intValue();
                break;
              }
              label405:
              if (!af.dIa().xWq)
              {
                af.dIa().dIK();
                af.dIa().xWq = true;
                SnsTimeLineUI.a(SnsTimeLineUI.this).yZn.avP(com.tencent.mm.plugin.sns.data.q.wX(SnsTimeLineUI.a(SnsTimeLineUI.this).dRz()));
                SnsTimeLineUI.a(SnsTimeLineUI.this).yZn.avQ(com.tencent.mm.plugin.sns.data.q.wX(SnsTimeLineUI.a(SnsTimeLineUI.this).rt(false)));
                af.dIa().xWn = af.dIa().dII();
                af.dHH().xs(af.dIa().dII());
                af.dIa().xWo = at.xWM;
                localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                locala = com.tencent.mm.hellhoundlib.b.c.a(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount() - 1 + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                ((ListView)localObject).smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
                {
                  SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
                  SnsTimeLineUI.B(SnsTimeLineUI.this).post(SnsTimeLineUI.C(SnsTimeLineUI.this));
                }
              }
              AppMethodBeat.o(200564);
            }
          };
          this.yxZ = getIntent().getBooleanExtra("sns_resume_state", true);
          if (!af.dHA()) {
            break label3937;
          }
          this.yxZ = false;
          label2259:
          this.ySL = this.yxZ;
          this.mUIAction.a(this.ySX, this.lhM, (String)localObject1, paramBundle, this.ySY, this.yzX, this.ySZ);
          this.mUIAction.onCreate();
          af.dHI().init();
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(213, this);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(682, this);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(218, this);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(211, this);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(683, this);
          com.tencent.mm.plugin.sns.ui.video.d.dSq().dSr();
          initView();
          paramBundle = af.dHI();
          localObject1 = this.mUIAction.list;
          localObject2 = this.ySH.yZm;
          paramBundle.xZI = ((ListView)localObject1);
          paramBundle.xZJ = ((be)localObject2);
          paramBundle = af.dHI();
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(291, paramBundle);
          this.ySN.qRg = ((ClipboardManager)ai.getContext().getSystemService("clipboard"));
          if (!af.dHA()) {
            break label3957;
          }
          this.yxZ = false;
          label2490:
          paramBundle = this.ySF;
          paramBundle.yZn = this.ySH.yZn;
          localObject1 = paramBundle.yZn;
          paramBundle.Jpl.keep((com.tencent.mm.vending.e.a)localObject1);
          if ((!this.yxZ) || (this.yTN != 0)) {
            break label3977;
          }
          this.ySM = false;
          int k = af.dHZ().position;
          this.ySH.yZn.avR(af.dHZ().qui);
          this.ySH.yZn.avO(af.dHZ().yEq);
          this.ySH.yZn.ru(true);
          this.ySH.yZn.avS(af.dHZ().yEt);
          this.ySH.yZn.avP(af.dHZ().yEr);
          this.ySH.yZn.avQ(af.dHZ().yEs);
          this.mUIAction.rs(af.dHZ().yEv);
          this.ySH.tX();
          i = k;
          if (k >= this.ySH.getCount())
          {
            i = this.ySH.getCount() - 1;
            ac.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[] { Integer.valueOf(this.ySH.getCount()) });
          }
          this.mUIAction.list.setAdapter(this.ySH);
          ac.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[] { Integer.valueOf(af.dHZ().yEu) });
          this.mUIAction.list.setSelectionFromTop(i, af.dHZ().yEu);
          PF(4);
          label2771:
          dQz();
          i = this.ySH.getCount();
          k = this.mUIAction.list.getFirstVisiblePosition();
          if (k < i) {
            this.yST = com.tencent.mm.plugin.sns.data.q.l(this.ySH.Pl(k));
          }
          com.tencent.mm.kernel.g.agS();
          this.ySR = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(327776, Integer.valueOf(0))).intValue();
          this.ySN.yyb = new bm(this, this.ySH.yZm, this.ySN.xZf);
          this.ySN.yyd = new com.tencent.mm.plugin.sns.h.b(this, this.ySH.yZm.xZe, this.ySN.xZf);
          this.ySN.yyc = new b(this, this.ySH.yZm.xZe, this.ySN.xZf, this.ySN.yyd);
          this.ySN.yyc.ywr = this.yJJ;
          this.ySN.yye = new aj(this, this.ySH.yZm.xZe, this.ySN.xZf);
          this.ySN.yyf = new bo(this, this.ySH.yZm.xZe, this.ySN.xZf);
          if (this.ySW != null) {
            this.ySW.a(this.ySN.yyd);
          }
          if (i > 0)
          {
            paramBundle = this.ySH.Pl(0);
            if ((this.ySN.yxQ != null) && (this.ySN.yxQ.xUQ != null)) {
              this.ySN.yxQ.xUQ.ybr = paramBundle.field_snsId;
            }
            paramBundle = com.tencent.mm.plugin.sns.j.f.ydE;
            if (paramBundle.gdl != 0)
            {
              if (paramBundle.ydF.isEmpty())
              {
                paramBundle.fnt.setLong(2, bs.aNx());
                paramBundle.ydG.clear();
              }
              ac.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[] { Integer.valueOf(paramBundle.ydF.size()) });
            }
          }
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(13312, "1," + bs.eWj());
          com.tencent.mm.sdk.b.a.GpY.c(this.yTi);
          if (getIntent().getBooleanExtra("is_need_resend_sns", false))
          {
            com.tencent.mm.sdk.platformtools.ap.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99317);
                com.tencent.mm.ui.base.h.d(SnsTimeLineUI.this, SnsTimeLineUI.this.getString(2131761704), "", SnsTimeLineUI.this.getString(2131761705), SnsTimeLineUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(99307);
                    paramAnonymous2DialogInterface = new rc();
                    com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(99307);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(99308);
                    paramAnonymous2DialogInterface = new nh();
                    com.tencent.mm.sdk.b.a.GpY.l(paramAnonymous2DialogInterface);
                    AppMethodBeat.o(99308);
                  }
                });
                AppMethodBeat.o(99317);
              }
            }, 500L);
            getIntent().putExtra("is_need_resend_sns", false);
          }
          com.tencent.mm.kernel.g.agS();
          if (com.tencent.mm.kernel.g.agP().afY())
          {
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agR().agA().set(589825, Boolean.FALSE);
          }
          paramBundle = this.ySN;
          localObject1 = this.yJJ;
          paramBundle.yxP = ((com.tencent.mm.plugin.sns.ad.d.i)localObject1);
          if (paramBundle.yyg != null) {
            paramBundle.yyg.b((com.tencent.mm.plugin.sns.ad.d.i)localObject1);
          }
          this.yJJ.a(this.mUIAction.xIz, this.mActionBar.getCustomView(), this);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTo);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTp);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTq);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTr);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTs);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTu);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTt);
          com.tencent.mm.sdk.b.a.GpY.c(this.xVy);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTv);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTw);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTy);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTx);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTz);
          com.tencent.mm.sdk.b.a.GpY.c(this.yTB);
          com.tencent.mm.plugin.sns.abtest.c.dFA();
          com.tencent.mm.plugin.sns.abtest.a.d(this, this.ySN.xZf);
          if (this.ySU != null)
          {
            paramBundle = this.ySU;
            localObject1 = this.mUIAction.list;
            localObject2 = this.mUIAction.yaU;
            paramBundle.gFr = ((ListView)localObject1);
            paramBundle.yaU = ((SnsHeader)localObject2);
          }
          if ((this.ySN != null) && (this.ySN.yxQ != null))
          {
            paramBundle = this.ySN.yxQ.xUQ;
            ac.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
            paramBundle.ybq = true;
            paramBundle.ydo = System.currentTimeMillis();
          }
          bool = getIntent().getBooleanExtra("enter_by_red", false);
          if ((this.ySN != null) && (this.ySN.yxQ != null))
          {
            paramBundle = this.ySN.yxQ.xUQ;
            if (!bool) {
              break label4006;
            }
          }
        }
      }
      label3977:
      label4006:
      for (i = j;; i = 0)
      {
        paramBundle.ybD = i;
        af.dHO().xQl.clear();
        if ((this.mUIAction != null) && (this.mUIAction.yaU != null)) {
          this.mUIAction.yaU.setStoryAction(new SnsStoryHeaderView.a()
          {
            public final void dQN()
            {
              AppMethodBeat.i(200566);
              SnsTimeLineUI.a locala = SnsTimeLineUI.l(SnsTimeLineUI.this);
              if (SnsTimeLineUI.u(locala.yTS).getVisibility() == 0)
              {
                locala.init();
                SnsTimeLineUI.u(locala.yTS).clearAnimation();
                SnsTimeLineUI.u(locala.yTS).startAnimation(locala);
                locala.xS(locala.DELAY_TIME + 100);
                locala.yUv = false;
              }
              AppMethodBeat.o(200566);
            }
          });
        }
        com.tencent.mm.sdk.b.a.GpY.c(this.yTj);
        AppMethodBeat.o(99379);
        return;
        label3704:
        paramBundle = com.tencent.mm.ui.statusbar.c.bm(this);
        localObject1 = new com.tencent.mm.ui.statusbar.c.a()
        {
          public final void tx(int paramAnonymousInt)
          {
            AppMethodBeat.i(200546);
            SnsTimeLineUI.t(SnsTimeLineUI.this).setPadding(0, paramAnonymousInt, 0, 0);
            AppMethodBeat.o(200546);
          }
        };
        this.rrB = ((com.tencent.mm.ui.statusbar.c.a)localObject1);
        paramBundle.a((com.tencent.mm.ui.statusbar.c.a)localObject1);
        getWindow().getDecorView().requestApplyInsets();
        com.tencent.mm.ui.statusbar.d.b(getWindow());
        break;
        paramBundle = null;
        break label1939;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZK = new com.tencent.mm.plugin.sns.l.c.a();
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZK.lhM = paramBundle.getStringExtra("sns_userName");
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZK.ySX = u.axw();
        localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZK;
        com.tencent.mm.kernel.g.agS();
        ((com.tencent.mm.plugin.sns.l.c.a)localObject2).ySY = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNo(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZK.lhM);
        localObject2 = u.axw();
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZK.yzX = ((String)localObject2).equals(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZK.lhM);
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZK.ySZ = paramBundle.getIntExtra("sns_source", 0);
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZK.iXH = bs.bG(paramBundle.getStringExtra("sns_nickName"), "");
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZK.bUS = bs.bG(paramBundle.getStringExtra("sns_signature"), "");
        break label1957;
        label3924:
        paramBundle = paramBundle.yZK;
        break label1986;
        label3932:
        i = 0;
        break label2174;
        label3937:
        if (!this.yxZ) {
          break label2259;
        }
        this.yxZ = af.dHZ().dOz();
        break label2259;
        label3957:
        if (!this.yxZ) {
          break label2490;
        }
        this.yxZ = af.dHZ().dOz();
        break label2490;
        this.mUIAction.list.setAdapter(this.ySH);
        PF(0);
        this.ySH.tX();
        break label2771;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99383);
    this.ySS = true;
    Object localObject1 = this.yTe;
    ((az)localObject1).cIr();
    ((az)localObject1).yOK = null;
    ((az)localObject1).xlf = az.a.yOM;
    com.tencent.mm.plugin.sns.ui.video.d.dSq().aI(this);
    localObject1 = com.tencent.mm.plugin.sns.ui.video.b.dSj();
    ac.i("MicroMsg.SightPlayViewManager", "onUIDestroy");
    Object localObject2 = ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).ziU.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((com.tencent.mm.plugin.sns.ui.video.a)((Iterator)localObject2).next()).stop();
    }
    ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).ziU.clear();
    ac.i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
    com.tencent.mm.sdk.b.a.GpY.d(this.yTo);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTp);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTq);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTr);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTs);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTu);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTt);
    com.tencent.mm.sdk.b.a.GpY.d(this.xVy);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTv);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTw);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTx);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTy);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTz);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTj);
    com.tencent.mm.sdk.b.a.GpY.d(this.yTB);
    com.tencent.mm.plugin.sns.ui.e.a.dSh();
    int i;
    long l1;
    Object localObject3;
    Object localObject4;
    int j;
    label464:
    String str2;
    if ((this.ySN != null) && (this.ySN.yxQ != null))
    {
      localObject1 = this.ySN.yxQ.xUQ;
      if (this.yTl)
      {
        i = 1;
        ((com.tencent.mm.plugin.sns.j.c)localObject1).ybE = i;
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.sns.j.f.ydE;
      if (((com.tencent.mm.plugin.sns.j.f)localObject2).gdl == 0) {
        break label792;
      }
      ac.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sns.j.f)localObject2).ydF.size()), Integer.valueOf(((com.tencent.mm.plugin.sns.j.f)localObject2).ydG.size()) });
      l1 = ((com.tencent.mm.plugin.sns.j.f)localObject2).fnt.getLong(2, 0L);
      if ((((com.tencent.mm.plugin.sns.j.f)localObject2).ydF.isEmpty()) || ((((com.tencent.mm.plugin.sns.j.f)localObject2).ydF.size() <= ((com.tencent.mm.plugin.sns.j.f)localObject2).ydK) && (bs.pN(l1) <= ((com.tencent.mm.plugin.sns.j.f)localObject2).ydL))) {
        break label1810;
      }
      localObject3 = new StringBuffer();
      localObject4 = ((com.tencent.mm.plugin.sns.j.f)localObject2).ydF.keySet().iterator();
      i = 0;
      j = 0;
      if (!((Iterator)localObject4).hasNext()) {
        break label618;
      }
      str2 = (String)((Iterator)localObject4).next();
      localObject1 = (String)((com.tencent.mm.plugin.sns.j.f)localObject2).ydG.get(str2);
      if (bs.isNullOrNil((String)localObject1)) {
        break label605;
      }
      j = 1;
      label511:
      if (!((com.tencent.mm.plugin.sns.j.f)localObject2).ydH.contains(str2)) {
        break label613;
      }
    }
    label605:
    label613:
    for (int k = 1;; k = 0)
    {
      ((StringBuffer)localObject3).append(str2 + "#" + ((com.tencent.mm.plugin.sns.j.f)localObject2).ydF.get(str2) + "#" + (String)localObject1 + "#" + k + "|");
      i += 1;
      break label464;
      i = 0;
      break;
      localObject1 = "";
      break label511;
    }
    label618:
    ((StringBuffer)localObject3).append("," + l1 + "," + bs.aNx() + ",1," + j + "," + i + ",1");
    ac.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", new Object[] { Integer.valueOf(13226), localObject3 });
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(13226, ((StringBuffer)localObject3).toString());
    ((com.tencent.mm.plugin.sns.j.f)localObject2).fnt.set(3, null);
    ((com.tencent.mm.plugin.sns.j.f)localObject2).fnt.set(4, null);
    ((com.tencent.mm.plugin.sns.j.f)localObject2).fnt.set(5, null);
    ((com.tencent.mm.plugin.sns.j.f)localObject2).ydF.clear();
    ((com.tencent.mm.plugin.sns.j.f)localObject2).ydG.clear();
    ((com.tencent.mm.plugin.sns.j.f)localObject2).ydH.clear();
    ((com.tencent.mm.plugin.sns.j.f)localObject2).fnt.setLong(2, bs.aNx());
    for (;;)
    {
      ((com.tencent.mm.plugin.sns.j.f)localObject2).dJs();
      label792:
      com.tencent.mm.kernel.g.agS();
      localObject3 = (String)com.tencent.mm.kernel.g.agR().agA().get(68377, null);
      i = this.ySH.getCount();
      localObject1 = "";
      localObject2 = null;
      if (i > 0)
      {
        localObject2 = this.ySH.Pl(i - 1);
        localObject1 = com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject2);
      }
      label889:
      boolean bool;
      if ((this.ySN != null) && (this.ySN.yxQ != null))
      {
        localObject4 = this.ySN.yxQ.xUQ;
        if (localObject2 == null)
        {
          i = -1;
          ac.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
          l1 = System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.j.c)localObject4).ydo;
          ((com.tencent.mm.plugin.sns.j.c)localObject4).ybs += l1;
          ac.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + l1 + " BrowseTime: " + ((com.tencent.mm.plugin.sns.j.c)localObject4).ybs + "BackgroundTime: " + ((com.tencent.mm.plugin.sns.j.c)localObject4).ycb);
          localObject2 = af.dHE();
          if (localObject2 != null) {
            ((ExecutorService)localObject2).execute(new c.2((com.tencent.mm.plugin.sns.j.c)localObject4, i));
          }
          ((com.tencent.mm.plugin.sns.j.c)localObject4).ybq = false;
        }
      }
      else
      {
        localObject2 = com.tencent.mm.modelsns.d.ps(704);
        if (((com.tencent.mm.modelsns.d)localObject2).aHV())
        {
          ((com.tencent.mm.modelsns.d)localObject2).eQ(this.yTl);
          if (bs.isNullOrNil((String)localObject3)) {
            break label1864;
          }
          bool = true;
          ((com.tencent.mm.modelsns.d)localObject2).eQ(bool);
          ((com.tencent.mm.modelsns.d)localObject2).Dn(this.yST);
          ((com.tencent.mm.modelsns.d)localObject2).Dn((String)localObject1);
          ((com.tencent.mm.modelsns.d)localObject2).Dn((String)localObject1);
          ((com.tencent.mm.modelsns.d)localObject2).pv(this.mUIAction.yWg);
          ((com.tencent.mm.modelsns.d)localObject2).Dn("");
          com.tencent.mm.modelsns.d.aHY();
          ((com.tencent.mm.modelsns.d)localObject2).aHZ();
        }
        localObject1 = (AdListView)this.mUIAction.getSnsListView();
        this.ySW.xXd.clear();
        af.dHI().clean();
        localObject2 = af.dHL();
        af.dHE().execute(new k.5((com.tencent.mm.plugin.sns.ad.d.k)localObject2));
        ((AdListView)localObject1).ywm.clear();
        ((AdListView)localObject1).ywm = null;
        ((AdListView)localObject1).ywn.dHh();
        ((AdListView)localObject1).ywn = null;
        t.dHm();
        if (!af.dHA()) {
          this.yTH.removeCallbacks(this.yTh);
        }
        com.tencent.mm.kernel.g.agS();
        if (com.tencent.mm.kernel.g.agP().afY())
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.b(213, this);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.b(682, this);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.b(218, this);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.b(211, this);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.b(683, this);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(327776, Integer.valueOf(this.ySR));
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(589825, Boolean.FALSE);
        }
        if (this.ySN != null)
        {
          localObject1 = this.ySN;
          ((i)localObject1).yyg.removeListener();
          if (((i)localObject1).yxU != null) {
            ((i)localObject1).yxU.dPE();
          }
          com.tencent.mm.sdk.b.a.GpY.d(((i)localObject1).yyi);
          com.tencent.mm.sdk.b.a.GpY.d(((i)localObject1).yyj);
        }
        af.cMM().removeCallbacks(this.yTI);
        localObject1 = af.dIa();
        if (((com.tencent.mm.plugin.sns.model.as)localObject1).xWy != null) {
          ((com.tencent.mm.plugin.sns.model.as)localObject1).dIL();
        }
        if (!((com.tencent.mm.plugin.sns.model.as)localObject1).xVW) {}
      }
      try
      {
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.xWw = ((com.tencent.mm.plugin.sns.model.as)localObject1).xWw;
        localObject2 = ((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.toByteArray();
        com.tencent.mm.vfs.i.f(((com.tencent.mm.plugin.sns.model.as)localObject1).xVV, (byte[])localObject2, localObject2.length);
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWs.yaM.clear();
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWt = null;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWu = 0L;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWn = 0L;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWh.clear();
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWi = null;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWm = 0L;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWj = 0L;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWp = false;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWy = null;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWz = null;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWo = at.xWO;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWA = 0;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWx = 0L;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWw = 0L;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWB = 0L;
        ((com.tencent.mm.plugin.sns.model.as)localObject1).xWk.clear();
        localObject1 = ((com.tencent.mm.plugin.sns.model.as)localObject1).xWC;
        ((ar)localObject1).xVT.clear();
        ((ar)localObject1).xVU = null;
        com.tencent.mm.kernel.g.agQ().ghe.b(211, (com.tencent.mm.ak.g)localObject1);
        localObject1 = af.dIb();
        ac.i(com.tencent.mm.plugin.sns.model.ap.TAG, "destroy");
        com.tencent.mm.sdk.platformtools.ap.aB(((com.tencent.mm.plugin.sns.model.ap)localObject1).xVJ);
        if (this.ySH == null) {
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
                ac.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", new Object[] { Integer.valueOf(n), Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
                k = localObject2[1];
              }
            }
            j += 1;
            i = k;
            continue;
            label1810:
            ((com.tencent.mm.plugin.sns.j.f)localObject2).fnt.set(3, ((com.tencent.mm.plugin.sns.j.f)localObject2).ydF);
            ((com.tencent.mm.plugin.sns.j.f)localObject2).fnt.set(4, ((com.tencent.mm.plugin.sns.j.f)localObject2).ydG);
            ((com.tencent.mm.plugin.sns.j.f)localObject2).fnt.set(5, ((com.tencent.mm.plugin.sns.j.f)localObject2).ydH);
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
          ac.w("MicroMsg.SnsUnreadTipManager", "flushUnreadTipFaultWriteCache error:%s", new Object[] { localException.getMessage() });
        }
        j = getResources().getDimensionPixelSize(2131166841);
        if ((!af.dHA()) && (this.ySF.dHH() != null) && (this.yTN == 0))
        {
          localObject1 = af.dHZ();
          String str1 = this.ySH.yZn.dRC();
          localObject3 = this.ySH.yZn.dRE();
          l1 = this.ySF.dHH().xVl;
          localObject4 = this.ySH.yZn.dRA();
          str2 = this.ySH.yZn.dRB();
          long l2 = this.ySF.dHH().xVm;
          String str3 = this.ySH.yZn.dRD();
          bool = this.mUIAction.yEv;
          ((am)localObject1).yEp = bs.Gn();
          ((am)localObject1).qui = str1;
          ((am)localObject1).yEq = ((String)localObject3);
          ((am)localObject1).xVl = l1;
          ((am)localObject1).position = m;
          ((am)localObject1).yEu = (i - j);
          ((am)localObject1).yEt = str3;
          ((am)localObject1).yEr = ((String)localObject4);
          ((am)localObject1).yEs = str2;
          ((am)localObject1).xVm = l2;
          ((am)localObject1).yEv = bool;
          ac.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(((am)localObject1).yEp), str1, localObject3, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(((am)localObject1).yEu), localObject4, str2, Long.valueOf(l2), str3, Boolean.valueOf(bool) });
        }
        ac.d("MicroMsg.SnsTimeLineUI", "top h %d", new Object[] { Integer.valueOf(i - j) });
        localObject1 = this.ySH.yZm;
        com.tencent.mm.sdk.b.a.GpY.d(((be)localObject1).kce);
        if (!af.dHA()) {
          break label2578;
        }
      }
    }
    ac.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
    for (;;)
    {
      localObject1 = this.ySH.yZm;
      if (((be)localObject1).yJy != null) {
        ((be)localObject1).yJy.activity = null;
      }
      localObject1 = this.ySH.yZm;
      com.tencent.mm.sdk.b.a.GpY.d(((be)localObject1).kce);
      this.ySH.yZm.dQw();
      this.ySH.yZm.dQs();
      label2331:
      bg.clean();
      com.tencent.mm.sdk.b.a.GpY.d(this.yTi);
      com.tencent.mm.kernel.g.agS();
      if (com.tencent.mm.kernel.g.agP().afY()) {
        af.dHO().xQl.clear();
      }
      this.ySH.yZn.removeVendingDataChangedCallback(this.yTk);
      this.yTk = null;
      this.ySH = null;
      this.ySN = null;
      com.tencent.mm.plugin.sns.ui.a.c.dRy();
      com.tencent.mm.plugin.sns.abtest.c.dFB();
      localObject1 = af.dHI();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(291, (com.tencent.mm.ak.g)localObject1);
      com.tencent.mm.plugin.sns.abtest.a.clean();
      this.mUIAction.onDestroy();
      super.onDestroy();
      com.tencent.mm.kiss.widget.textview.c.gkZ.ahT();
      localObject1 = this.ySG;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).yZK = null;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = false;
      com.tencent.mm.plugin.sns.ad.d.l.xKs.xKr.clear();
      ac.i("MicroMsg.SnsTimelineAdResourceMgr", "clean cache", new Object[] { bs.eWi() });
      localObject1 = af.dHM();
      if (!((com.tencent.mm.plugin.sns.model.b)localObject1).xPW.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.b)localObject1).xPW.clear();
      }
      localObject1 = af.dHM();
      if (!((com.tencent.mm.plugin.sns.model.b)localObject1).xPX.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.b)localObject1).xPX.clear();
      }
      af.dIa().xWq = false;
      localObject1 = com.tencent.mm.plugin.sns.j.f.ydE;
      ((com.tencent.mm.plugin.sns.j.f)localObject1).ydO.clear();
      ((com.tencent.mm.plugin.sns.j.f)localObject1).ydP.clear();
      AppMethodBeat.o(99383);
      return;
      label2578:
      af.dHO();
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
    com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179271);
        SnsTimeLineUI.this.dNy();
        AppMethodBeat.o(179271);
      }
    });
    if (keyboardState() == 2)
    {
      if ((this.ySN != null) && (this.ySN.yxU != null) && (!this.ySN.yxU.dPz()))
      {
        ac.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
        AppMethodBeat.o(99389);
      }
    }
    else if ((keyboardState() == 1) && (this.ySN != null))
    {
      i locali = this.ySN;
      if (locali.yxR)
      {
        locali.yxR = false;
        locali.yxV.dRv();
      }
    }
    AppMethodBeat.o(99389);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99387);
    try
    {
      com.tencent.mm.sdk.platformtools.bg.a(this, null);
      this.yGw = false;
      this.ySK.clearAnimation();
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, this.fsu);
      this.fsu = 0;
      t.b(this);
      af.dHO().xQn = null;
      if (this.ySH != null)
      {
        localObject = this.ySH.yZm;
        com.tencent.mm.sdk.b.a.GpY.d(((be)localObject).yKa);
        com.tencent.mm.sdk.b.a.GpY.d(((be)localObject).yJZ);
        com.tencent.mm.sdk.b.a.GpY.d(((be)localObject).yKb);
      }
      if ((this.ySN != null) && (this.ySN.yxP != null)) {
        this.ySN.yxP.onPause();
      }
      if ((this.ySN != null) && (this.ySN.yxQ != null)) {
        this.ySN.yxQ.xUQ.qJ(false);
      }
      com.tencent.mm.modelstat.d.m("SnsTimeLineUI", this.uup, bs.aNx());
      this.mUIAction.onPause();
      super.onPause();
      com.tencent.mm.plugin.sns.ui.video.d.dSq().onUIPause();
      Object localObject = com.tencent.mm.plugin.sns.ui.video.b.dSj();
      ac.i("MicroMsg.SightPlayViewManager", "onUIPause");
      localObject = ((com.tencent.mm.plugin.sns.ui.video.b)localObject).ziU.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.sns.ui.video.a)((Iterator)localObject).next()).onUIPause();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
      }
      com.tencent.mm.sdk.b.a.GpY.d(this.yTn);
      com.tencent.mm.sdk.b.a.GpY.d(this.yTm);
      com.tencent.mm.sdk.b.a.GpY.d(this.yTA);
      if ((com.tencent.matrix.b.Gp()) && (com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class) != null))
      {
        com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class)).cyD;
        if (localc != null) {
          this.gcx = Math.max(0L, localc.cAr - this.gcx);
        }
      }
      if (bs.aNx() <= this.hDh) {}
    }
    for (long l = bs.aNx() - this.hDh;; l = 1L)
    {
      this.hDh = l;
      WXHardCoderJNI.reportFPS(701, WXHardCoderJNI.hcSNSScrollAction, 1, this.gcx, this.hDh);
      this.gcx = 0L;
      this.hDh = 0L;
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
      ac.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(99403);
      return;
    }
    ac.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99403);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dQD();
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
              AppMethodBeat.i(179285);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = SnsTimeLineUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$71", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$71", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(179285);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(179286);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(179286);
            }
          });
        }
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        dQC();
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
            AppMethodBeat.i(179287);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = SnsTimeLineUI.this.getContext();
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$73", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$73", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(179287);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179288);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(179288);
          }
        });
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        dQC();
        AppMethodBeat.o(99403);
        return;
      }
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131761869), getString(2131761885), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(200590);
          paramAnonymousDialogInterface = SnsTimeLineUI.this.getContext();
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$75", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$75", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(200590);
        }
      }, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99384);
    af.dIa().xWo = at.xWO;
    this.yTe.xlf = az.dPZ();
    this.hDh = bs.aNx();
    Object localObject1;
    if ((com.tencent.matrix.b.Gp()) && (com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class) != null))
    {
      localObject1 = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class)).cyD;
      if (localObject1 != null) {
        this.gcx = ((com.tencent.matrix.trace.f.c)localObject1).cAr;
      }
    }
    try
    {
      if (!this.yGw)
      {
        ac.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onResume callback");
        com.tencent.mm.sdk.platformtools.bg.a(this, this.yHk);
        this.yGw = true;
      }
      if ((com.tencent.mm.sdk.a.b.eUk()) && (com.tencent.mm.sdk.a.b.eUi())) {
        sUILeaksRoutineEnsuranceRef.add(this);
      }
      this.mUIAction.onResume();
      super.onResume();
      dQA();
      if (this.autoPlay) {
        dQz();
      }
      this.uup = bs.aNx();
      int i;
      if (this.yTM)
      {
        this.yTM = false;
        i = this.ySH.getCount();
        if (getIntent().getBooleanExtra("is_from_find_more", false))
        {
          localObject3 = com.tencent.mm.modelsns.d.c(getIntent(), "enter_log");
          if (localObject3 != null)
          {
            if (i <= 0) {
              break label735;
            }
            localp = this.ySH.Pl(0);
            if (localp != null) {
              break label701;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.d)localObject3).Dn((String)localObject1);
            if (localp != null) {
              break label713;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.d)localObject3).Dn((String)localObject1);
            ((com.tencent.mm.modelsns.d)localObject3).Dn(String.valueOf(i));
            ((com.tencent.mm.modelsns.d)localObject3).aHZ();
          }
        }
      }
      if (this.mScreenWidth == 0)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
        this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
        localObject1 = this.ySU;
        i = this.mScreenWidth;
        int j = this.mScreenHeight;
        ((com.tencent.mm.plugin.sns.j.a)localObject1).mScreenWidth = i;
        ((com.tencent.mm.plugin.sns.j.a)localObject1).mScreenHeight = j;
      }
      if (af.dHA()) {
        finish();
      }
      af.dHO().xQn = this.ySH.yZm;
      ahP().bi(c.b.class);
      t.a(this);
      if (this.ySM)
      {
        this.ySK.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99328);
            ac.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.M(SnsTimeLineUI.this));
            if (SnsTimeLineUI.M(SnsTimeLineUI.this))
            {
              SnsTimeLineUI.m(SnsTimeLineUI.this);
              SnsTimeLineUI.l(SnsTimeLineUI.this).dQR();
            }
            AppMethodBeat.o(99328);
          }
        });
        if ((this.ySN != null) && (this.ySN.yxP != null)) {
          this.ySN.yxP.onResume();
        }
        if (this.ySH != null)
        {
          localObject1 = this.ySH.yZm;
          com.tencent.mm.sdk.b.a.GpY.c(((be)localObject1).yKa);
          com.tencent.mm.sdk.b.a.GpY.c(((be)localObject1).yJZ);
          com.tencent.mm.sdk.b.a.GpY.c(((be)localObject1).yKb);
        }
        if ((this.ySN != null) && (this.ySN.yxQ != null))
        {
          this.ySN.yxQ.xUQ.qJ(true);
          this.ySN.yxQ.xUQ.qK(false);
          this.ySN.yxQ.xUQ.qL(false);
          this.ySN.yxQ.xUQ.qM(false);
          this.ySN.yxQ.xUQ.qW(false);
          localObject1 = this.ySN.yxQ.xUQ;
          ((com.tencent.mm.plugin.sns.j.c)localObject1).qU(false);
          ((com.tencent.mm.plugin.sns.j.c)localObject1).qV(false);
          ((com.tencent.mm.plugin.sns.j.c)localObject1).qO(false);
          ((com.tencent.mm.plugin.sns.j.c)localObject1).qT(false);
          ((com.tencent.mm.plugin.sns.j.c)localObject1).qR(false);
          ((com.tencent.mm.plugin.sns.j.c)localObject1).qT(false);
          ((com.tencent.mm.plugin.sns.j.c)localObject1).qX(false);
          ((com.tencent.mm.plugin.sns.j.c)localObject1).qS(false);
          ((com.tencent.mm.plugin.sns.j.c)localObject1).qT(false);
          ((com.tencent.mm.plugin.sns.j.c)localObject1).qP(false);
          ((com.tencent.mm.plugin.sns.j.c)localObject1).qQ(false);
        }
        localObject1 = af.dHO();
        ((com.tencent.mm.plugin.sns.model.f)localObject1).xQo = 0L;
        ((com.tencent.mm.plugin.sns.model.f)localObject1).xQp = 0L;
        com.tencent.mm.sdk.b.a.GpY.c(this.yTn);
        com.tencent.mm.sdk.b.a.GpY.c(this.yTm);
        com.tencent.mm.sdk.b.a.GpY.c(this.yTA);
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
        ac.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
        continue;
        label701:
        Object localObject2 = com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId);
        continue;
        label713:
        localObject2 = localp.field_createTime;
        continue;
        label735:
        ((com.tencent.mm.modelsns.d)localObject3).Dn("");
        ((com.tencent.mm.modelsns.d)localObject3).Dn("");
        ((com.tencent.mm.modelsns.d)localObject3).Dn("0");
        continue;
        localObject2 = this.ySP;
        if (((a)localObject2).yTS.ySK.getVisibility() == 0)
        {
          ((a)localObject2).init();
          localObject3 = (AbsoluteLayout.LayoutParams)((a)localObject2).yTS.ySK.getLayoutParams();
          ((AbsoluteLayout.LayoutParams)localObject3).y = ((int)((a)localObject2).yUo);
          ((a)localObject2).yTS.ySK.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((a)localObject2).yTS.ySK.invalidate();
        }
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(99398);
    ac.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType());
    if (paramn.getType() == 218)
    {
      paramString = (com.tencent.mm.plugin.sns.model.q)paramn;
      if (((paramString.type == 1) || (paramString.type == 6) || (paramString.type == 4)) && (this.ySN.yyh != null)) {
        this.ySN.yyh.dismiss();
      }
      if (paramString.type == 11)
      {
        if (this.mUIAction.tipDialog != null) {
          this.mUIAction.tipDialog.dismiss();
        }
        if (this.yTP != null) {
          this.yTP.setImageResource(2131690526);
        }
      }
    }
    if (this.ySH != null) {
      this.ySH.yZn.notifyVendingDataChange();
    }
    if (paramn.getType() == 211)
    {
      paramString = (x)paramn;
      if (!paramString.xRn) {
        break label272;
      }
      paramn = com.tencent.mm.modelsns.d.ps(727);
      paramn.pv(this.ySH.getCount()).pv(paramString.ahX);
      paramn.aHZ();
    }
    for (;;)
    {
      if (this.ySP != null)
      {
        this.ySM = false;
        this.ySP.dQS();
      }
      AppMethodBeat.o(99398);
      return;
      label272:
      paramn = com.tencent.mm.modelsns.d.ps(728);
      paramn.pv(this.ySH.getCount()).pv(paramString.ahX).pv(0);
      paramn.aHZ();
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
    AppMethodBeat.i(200593);
    super.onWindowFocusChanged(paramBoolean);
    ac.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      com.tencent.mm.sdk.platformtools.bg.a(this, null);
      this.yGw = false;
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(200593);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      ac.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(200593);
    }
    if (!this.yGw)
    {
      ac.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onWindowFocusChanged callback");
      com.tencent.mm.sdk.platformtools.bg.a(this, this.yHk);
      this.yGw = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(200593);
    return;
  }
  
  public final void rq(boolean paramBoolean)
  {
    AppMethodBeat.i(99405);
    if (this.ySH != null)
    {
      ac.i("MicroMsg.SnsTimeLineUI", "set play animation %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.mm.plugin.sns.ui.a.c localc = this.ySH;
      localc.yZo = paramBoolean;
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
    if ((Build.VERSION.SDK_INT >= 21) && (this.vJh != null))
    {
      this.vJh.setBackgroundColor(getWindow().getStatusBarColor());
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
    int DELAY_TIME = 600;
    private ListView list;
    float yUA = 0.0F;
    float yUB = 0.0F;
    float yUC = 0.0F;
    private float yUl;
    private float yUm;
    float yUn = -1.0F;
    float yUo;
    private float yUp = 50.0F;
    private float yUq = 10.0F;
    float yUr = 0.0F;
    private float yUs = 0.0F;
    private float yUt;
    private float yUu;
    boolean yUv;
    int yUw;
    boolean yUx = false;
    int yUy = 0;
    float yUz = 0.0F;
    
    public a(ListView paramListView)
    {
      this.list = paramListView;
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(99366);
      if (SnsTimeLineUI.yTC.booleanValue()) {
        ac.d("MicroMsg.RefreshAnim", "animtest applyTransformation vis %s interpolatedTime %s isJustUp %s", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(paramFloat), Boolean.valueOf(this.yUv) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99366);
        return;
      }
      float f1 = (paramFloat - this.yUt) * (float)getDuration();
      if (f1 < 2.0F)
      {
        if (SnsTimeLineUI.yTC.booleanValue()) {
          ac.d("MicroMsg.RefreshAnim", "applyTransformation wawawa %s", new Object[] { Float.valueOf(f1) });
        }
        AppMethodBeat.o(99366);
        return;
      }
      this.yUt = paramFloat;
      SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(2131690250);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.JbO);
      if (((float)getDuration() * paramFloat >= (float)(getDuration() - this.DELAY_TIME)) || (this.yUv))
      {
        paramTransformation = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        if (paramTransformation.y <= this.yUs)
        {
          AppMethodBeat.o(99366);
          return;
        }
        if (this.yUB == 0.0F)
        {
          this.yUB = (-this.yUs + paramTransformation.y);
          this.yUC = paramTransformation.y;
          this.yUu = paramFloat;
        }
        paramFloat = (paramFloat - this.yUu) / (1.0F - this.yUu);
        f1 = this.yUB * paramFloat;
        float f2 = this.yUC - f1;
        if (SnsTimeLineUI.yTC.booleanValue()) {
          ac.i("MicroMsg.RefreshAnim", "animcheck interpolatedTime y %s duration %s factor %s residualTime %s pass %s ", new Object[] { Float.valueOf(f2), Long.valueOf(getDuration()), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.yUu * (float)getDuration()) });
        }
        if (paramTransformation.y > f2) {
          paramTransformation.y = ((int)f2);
        }
        this.yUr = paramTransformation.y;
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(paramTransformation);
      }
      for (;;)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99366);
        return;
        if (SnsTimeLineUI.yTC.booleanValue()) {
          ac.d("MicroMsg.RefreshAnim", "animcheck delt Rotate " + f1 / 2.5F);
        }
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(f1 / 2.5F, this.yUl, this.yUm);
      }
    }
    
    public final void bE(float paramFloat)
    {
      AppMethodBeat.i(99360);
      if (this.list != null)
      {
        if (this.list.getFirstVisiblePosition() != 0) {
          break label122;
        }
        if (SnsTimeLineUI.d(SnsTimeLineUI.this).yaU.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).yUw) {
          SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
        }
      }
      for (;;)
      {
        if (SnsTimeLineUI.yTC.booleanValue()) {
          ac.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.yUo), Float.valueOf(this.yUn) });
        }
        if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() == 0) {
          break;
        }
        AppMethodBeat.o(99360);
        return;
        label122:
        SnsTimeLineUI.b(SnsTimeLineUI.this, 8);
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      init();
      float f1 = paramFloat;
      if (paramFloat <= -this.yUp) {
        f1 = -this.yUp;
      }
      float f2 = f1;
      if (f1 >= this.yUp) {
        f2 = this.yUp;
      }
      if (f2 < 0.0F)
      {
        this.yUr -= f2 * 2.0F;
        f1 = this.yUr;
        paramFloat = f1;
        if (f1 < this.yUo)
        {
          paramFloat = this.yUo;
          this.yUr = this.yUo;
        }
        f1 = paramFloat;
        if (paramFloat > this.yUn)
        {
          f1 = this.yUn;
          this.yUr = this.yUn;
        }
        if (SnsTimeLineUI.yTC.booleanValue()) {
          ac.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s sumY %s translateY %s distanceY %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.yUo), Float.valueOf(this.yUn), Float.valueOf(this.yUr), Float.valueOf(f1), Float.valueOf(this.yUp) });
        }
        if (f1 != this.yUn) {
          break label455;
        }
      }
      label455:
      for (paramFloat = f2 * 2.0F;; paramFloat = 5.0F * f2)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.JbO);
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(paramFloat, this.yUl, this.yUm);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(2131690250);
        AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        localLayoutParams.y = ((int)f1);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99360);
        return;
        this.yUr -= f2 / 2.0F;
        break;
      }
    }
    
    public final void dQR()
    {
      AppMethodBeat.i(99361);
      if (SnsTimeLineUI.yTC.booleanValue()) {
        ac.d("MicroMsg.RefreshAnim", "animtest playLoading");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99361);
        return;
      }
      init();
      this.yUr = (this.yUn + 20.0F);
      AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
      localLayoutParams.y = ((int)this.yUn);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
      dQT();
      AppMethodBeat.o(99361);
    }
    
    public final void dQS()
    {
      AppMethodBeat.i(99362);
      if (SnsTimeLineUI.yTC.booleanValue()) {
        ac.i("MicroMsg.RefreshAnim", "play end vis: %d, sumY %f MAX_Y %f", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(this.yUr), Float.valueOf(this.yUn) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99362);
        return;
      }
      init();
      if (this.yUr < this.yUn - this.yUq)
      {
        AppMethodBeat.o(99362);
        return;
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      xS(this.DELAY_TIME + 100);
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      this.yUv = false;
      AppMethodBeat.o(99362);
    }
    
    public final void dQT()
    {
      AppMethodBeat.i(99364);
      if (SnsTimeLineUI.yTC.booleanValue()) {
        ac.d("MicroMsg.RefreshAnim", "animtest setAcitonUp");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99364);
        return;
      }
      init();
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      if (SnsTimeLineUI.yTC.booleanValue()) {
        ac.v("MicroMsg.RefreshAnim", "setAcitonUp1 sumY  %s MAX_Y %s %s", new Object[] { Float.valueOf(this.yUr), Float.valueOf(this.yUn), bs.eWi().toString() });
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      if (this.yUr >= this.yUn - this.yUq)
      {
        xS(20000L);
        this.yUv = false;
        AppMethodBeat.o(99364);
        return;
      }
      xS(this.DELAY_TIME + 100);
      this.yUv = true;
      AppMethodBeat.o(99364);
    }
    
    final void init()
    {
      AppMethodBeat.i(99365);
      if ((this.yUn == -1.0F) || (this.yUm < 0.1D))
      {
        this.yUn = BackwardSupportUtil.b.g(SnsTimeLineUI.this, 70.0F);
        this.yUp = BackwardSupportUtil.b.g(SnsTimeLineUI.this, 16.0F);
        this.yUl = (SnsTimeLineUI.u(SnsTimeLineUI.this).getWidth() / 2);
        this.yUm = (SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() / 2);
        this.yUs = (-SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() * 2);
        if (this.yUs == 0.0F) {
          this.yUs = (-BackwardSupportUtil.b.g(SnsTimeLineUI.this, 40.0F));
        }
        this.yUo = this.yUs;
        if (SnsTimeLineUI.yTC.booleanValue()) {
          ac.d("MicroMsg.RefreshAnim", "init MIN_Y %s MAX_Y %s targetInitY %s distanceY %s", new Object[] { Float.valueOf(this.yUo), Float.valueOf(this.yUn), Float.valueOf(this.yUs), Float.valueOf(this.yUp) });
        }
        this.yUr = this.yUo;
        if (!this.yUx)
        {
          if (SnsTimeLineUI.yTC.booleanValue()) {
            ac.i("MicroMsg.RefreshAnim", "initState");
          }
          this.yUy = ((AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams()).y;
          this.yUz = this.yUn;
          this.yUA = this.yUr;
        }
        this.yUx = true;
      }
      AppMethodBeat.o(99365);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(99367);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      if (SnsTimeLineUI.yTC.booleanValue()) {
        ac.i("MicroMsg.RefreshAnim", "anim initialize %s", new Object[] { bs.eWi().toString() });
      }
      this.yUt = 0.0F;
      this.yUu = 0.0F;
      this.yUB = 0.0F;
      this.yUC = 0.0F;
      AppMethodBeat.o(99367);
    }
    
    final void xS(long paramLong)
    {
      AppMethodBeat.i(99363);
      if (SnsTimeLineUI.yTC.booleanValue()) {
        ac.d("MicroMsg.RefreshAnim", "setDurationTime durationMillis %s %s", new Object[] { Long.valueOf(paramLong), bs.eWi().toString() });
      }
      setDuration(paramLong);
      AppMethodBeat.o(99363);
    }
  }
  
  final class b
  {
    public int type = 0;
    public int yUD;
    
    private b() {}
  }
  
  final class c
  {
    public boolean active = true;
    public long ler;
    public int scene;
    public String yUE = "";
    public long yUF;
    public int yUG;
    public int yUH;
    public long yUI;
    public int yUJ;
    public long yUK;
    public int yUL;
    public long yUM;
    
    private c() {}
    
    public final void PH(int paramInt)
    {
      AppMethodBeat.i(99368);
      if (!this.active)
      {
        AppMethodBeat.o(99368);
        return;
      }
      this.yUH = paramInt;
      this.ler = bs.eWj();
      AppMethodBeat.o(99368);
    }
    
    public final void PI(int paramInt)
    {
      AppMethodBeat.i(99369);
      if (!this.active)
      {
        AppMethodBeat.o(99369);
        return;
      }
      reset();
      this.scene = 2;
      this.yUI = bs.eWj();
      this.yUJ = paramInt;
      AppMethodBeat.o(99369);
    }
    
    public final void PJ(int paramInt)
    {
      AppMethodBeat.i(99370);
      if (!this.active)
      {
        AppMethodBeat.o(99370);
        return;
      }
      reset();
      this.scene = 3;
      this.yUK = bs.eWj();
      this.yUM = 0L;
      this.yUL = paramInt;
      AppMethodBeat.o(99370);
    }
    
    final void reset()
    {
      this.scene = 0;
      this.yUF = 0L;
      this.yUG = -1;
      this.yUH = 0;
      this.ler = 0L;
      this.yUI = 0L;
      this.yUJ = 0;
      this.yUK = 0L;
      this.yUL = 0;
      this.yUM = 0L;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(99371);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.yUE).append(",").append(this.scene).append(",").append(this.yUF).append(",").append(this.yUG).append(",").append(this.yUH).append(",").append(this.ler).append(",").append(this.yUI).append(",").append(this.yUJ).append(",").append(this.yUK).append(",").append(this.yUL).append(",").append(this.yUM);
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