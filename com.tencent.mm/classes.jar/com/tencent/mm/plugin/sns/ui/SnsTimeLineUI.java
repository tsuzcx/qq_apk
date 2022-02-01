package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.a.wd;
import com.tencent.mm.g.a.we;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.g.b.a.im;
import com.tencent.mm.g.b.a.ke;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.secdata.ui.WxPresenterSecDataActivity;
import com.tencent.mm.plugin.sns.ad.g.m.5;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.b.2;
import com.tencent.mm.plugin.sns.m.c.b;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.aw.4;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.p;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.f;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vending.app.a.b;
import com.tencent.mm.vending.base.Vending.d;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

@com.tencent.mm.kernel.i
public class SnsTimeLineUI
  extends WxPresenterSecDataActivity
  implements com.tencent.mm.ak.i, com.tencent.mm.model.bb, i.a, x
{
  public static final Boolean ELX;
  private static Boolean ELn;
  private static final Set<Activity> sUILeaksRoutineEnsuranceRef;
  private View BdQ;
  private com.tencent.mm.ui.statusbar.c.a BdS;
  private IListener DMM;
  private boolean DSi;
  protected com.tencent.mm.plugin.sns.ad.g.k EBv;
  private final long EKO;
  private long EKP;
  private com.tencent.mm.plugin.sns.m.b EKQ;
  private com.tencent.mm.plugin.sns.m.a EKR;
  private com.tencent.mm.plugin.sns.ui.a.a.c EKS;
  com.tencent.mm.plugin.sns.ui.a.c EKT;
  private LinearLayout EKU;
  private LinearLayout EKV;
  private QFadeImageView EKW;
  private boolean EKX;
  private boolean EKY;
  private i EKZ;
  private com.tencent.mm.ui.widget.a.e ELA;
  private boolean ELB;
  private Runnable ELC;
  private IListener ELD;
  private IListener ELE;
  private Vending.d ELF;
  private boolean ELG;
  private IListener ELH;
  private IListener ELI;
  private IListener ELJ;
  private IListener ELK;
  private IListener ELL;
  private IListener ELM;
  private IListener ELN;
  private IListener ELO;
  private IListener ELP;
  private IListener ELQ;
  private IListener ELR;
  private IListener ELS;
  private IListener ELT;
  private IListener ELU;
  private IListener ELV;
  private IListener ELW;
  private long ELY;
  boolean ELZ;
  private int ELa;
  private a ELb;
  private TestTimeForSns ELc;
  private int ELd;
  private boolean ELe;
  private String ELf;
  private com.tencent.mm.plugin.sns.k.a ELg;
  private bd ELh;
  private com.tencent.mm.plugin.sns.model.bb ELi;
  private String ELj;
  private boolean ELk;
  private int ELl;
  private String ELm;
  private String ELo;
  private c ELp;
  private bf ELq;
  private ViewGroup ELr;
  private long ELs;
  private int ELt;
  private int ELu;
  private int ELv;
  private int ELw;
  private int ELx;
  private int ELy;
  private int ELz;
  Runnable EMa;
  Runnable EMb;
  private Handler EMc;
  private Runnable EMd;
  private SnsUIAction.a EMe;
  private long EMf;
  private a.b EMg;
  boolean EMh;
  int EMi;
  private ImageView EMj;
  private View EMk;
  private long EMl;
  private boolean EMm;
  private boolean EoO;
  private boolean EqY;
  private volatile boolean ExJ;
  private ScreenShotUtil.ScreenShotCallback EyL;
  private boolean autoPlay;
  private int gsi;
  private long hlB;
  private long iTC;
  private ActionBar mActionBar;
  private String mRa;
  private int mScreenHeight;
  private int mScreenWidth;
  private String mSessionId;
  private SnsUIAction mUIAction;
  private MenuItem.OnMenuItemClickListener ubB;
  private int wAr;
  private long zdW;
  
  static
  {
    AppMethodBeat.i(99430);
    ELn = null;
    ELX = Boolean.FALSE;
    sUILeaksRoutineEnsuranceRef = new HashSet();
    AppMethodBeat.o(99430);
  }
  
  public SnsTimeLineUI()
  {
    AppMethodBeat.i(99372);
    this.EKO = 300L;
    this.EKP = SystemClock.elapsedRealtime();
    this.EKQ = ((com.tencent.mm.plugin.sns.m.b)aq(com.tencent.mm.plugin.sns.m.b.class));
    if (this.EKQ != null) {}
    for (com.tencent.mm.plugin.sns.m.a locala = this.EKQ.flo();; locala = null)
    {
      this.EKR = locala;
      this.EKS = new com.tencent.mm.plugin.sns.ui.a.a.c();
      this.EKX = false;
      this.EKY = false;
      this.EoO = false;
      this.ELa = 800;
      this.ELd = 0;
      this.ELe = false;
      this.ELf = "";
      this.ELg = new com.tencent.mm.plugin.sns.k.a();
      this.EBv = new com.tencent.mm.plugin.sns.ad.g.k(0);
      this.ELh = new bd();
      this.ELi = new com.tencent.mm.plugin.sns.model.bb();
      this.autoPlay = false;
      this.ELo = "";
      this.ELp = new c((byte)0);
      this.ELq = new bf();
      this.ELr = null;
      this.ELs = 0L;
      this.ExJ = false;
      this.ELt = 0;
      this.ELu = 0;
      this.ELv = 0;
      this.ELw = 0;
      this.ELx = 2;
      this.ELy = 2;
      this.ELz = 2;
      this.ELB = false;
      this.ELC = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99267);
          com.tencent.mm.plugin.sns.ui.a.c localc = SnsTimeLineUI.a(SnsTimeLineUI.this);
          if (localc != null)
          {
            if (com.tencent.mm.plugin.sns.model.aj.faZ().DNF == com.tencent.mm.plugin.sns.model.ax.DOe) {
              SnsTimeLineUI.a(SnsTimeLineUI.this, localc.vC(true));
            }
            localc.ESq.fiE();
            localc.ESq.notifyVendingDataChange();
          }
          AppMethodBeat.o(99267);
        }
      };
      this.ELD = new IListener() {};
      this.ELE = new IListener() {};
      this.ELF = new Vending.d()
      {
        public final void fjn()
        {
          AppMethodBeat.i(179249);
          final int i;
          if ((SnsTimeLineUI.a(SnsTimeLineUI.this) != null) && (!SnsTimeLineUI.a(SnsTimeLineUI.this).ESr))
          {
            SnsTimeLineUI.a(SnsTimeLineUI.this).notifyDataSetChanged();
            if (SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView() != null)
            {
              i = au.eu(SnsTimeLineUI.this.getContext());
              int j = au.getStatusBarHeight(SnsTimeLineUI.this.getContext());
              Log.d("MicroMsg.SnsTimeLineUI", "topOffset:%s curFetchMode:%s, mUIAction.header.getLoadingGroupHeight():%s, actionBar:%s, statusBar:%s", new Object[] { Integer.valueOf(-(SnsTimeLineUI.d(SnsTimeLineUI.this).DSh.getLoadingGroupHeight() - com.tencent.mm.ui.at.fromDPToPix(SnsTimeLineUI.this.getContext(), 44) - i - j)), Integer.valueOf(com.tencent.mm.plugin.sns.model.aj.faZ().DNF), Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).DSh.getLoadingGroupHeight()), Integer.valueOf(i), Integer.valueOf(j) });
              if (com.tencent.mm.plugin.sns.model.aj.faZ().DNF == com.tencent.mm.plugin.sns.model.ax.DOd)
              {
                Log.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_SPECIFIC");
                long l = SnsTimeLineUI.a(SnsTimeLineUI.this).fkc();
                com.tencent.mm.plugin.sns.model.aj.faE().W(l, -1);
                SnsTimeLineUI.a(SnsTimeLineUI.this).ESq.aRi(r.Jc(l));
                SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.a(SnsTimeLineUI.this).vC(true));
                SnsTimeLineUI.d(SnsTimeLineUI.this).vz(true);
                com.tencent.mm.plugin.sns.model.aj.faL().start();
                SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(203694);
                    SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().setSelectionFromTop(SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), i + com.tencent.mm.ui.at.fromDPToPix(SnsTimeLineUI.this.getContext(), 44));
                    com.tencent.mm.plugin.sns.model.aj.faZ().DNH = false;
                    AppMethodBeat.o(203694);
                  }
                });
                AppMethodBeat.o(179249);
                return;
              }
              if (com.tencent.mm.plugin.sns.model.aj.faZ().DNF == com.tencent.mm.plugin.sns.model.ax.DOe)
              {
                i = 0;
                if (i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) {
                  break label421;
                }
                if (SnsTimeLineUI.a(SnsTimeLineUI.this).Zv(i).field_snsId != SnsTimeLineUI.e(SnsTimeLineUI.this)) {
                  break label414;
                }
              }
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_UP upFetchRightId:%s, rightIndex:%s", new Object[] { Long.valueOf(SnsTimeLineUI.e(SnsTimeLineUI.this)), Integer.valueOf(i) });
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
      this.ELG = false;
      this.DSi = false;
      this.ELH = new IListener() {};
      this.ELI = new IListener() {};
      this.ELJ = new IListener() {};
      this.ELK = new IListener() {};
      this.ELL = new IListener() {};
      this.ELM = new IListener() {};
      this.ELN = new IListener() {};
      this.ELO = new IListener() {};
      this.ELP = new IListener() {};
      this.DMM = new IListener() {};
      this.ELQ = new IListener() {};
      this.ELR = new IListener() {};
      this.ELS = new IListener() {};
      this.ELT = new IListener() {};
      this.ELU = new IListener() {};
      this.ELV = new SnsTimeLineUI.13(this);
      this.ELW = new IListener() {};
      this.ELY = 0L;
      this.ELZ = false;
      this.wAr = 0;
      this.EMa = new Runnable()
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
            com.tencent.mm.plugin.sns.model.aj.faL().pause();
          }
          AppMethodBeat.o(176303);
        }
      };
      this.EMb = new Runnable()
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
            Log.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() - SnsTimeLineUI.d(SnsTimeLineUI.this).list.getHeaderViewsCount()) });
            com.tencent.mm.plugin.sns.model.aj.faL().start();
            SnsTimeLineUI.a(SnsTimeLineUI.this).ESp.fiS();
          }
          AppMethodBeat.o(179225);
        }
      };
      this.EMc = ((com.tencent.mm.vending.h.b)com.tencent.mm.vending.h.d.LOGIC.RaM).mHandler;
      this.EMd = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179226);
          SnsTimeLineUI.this.setMMNormalView();
          SnsTimeLineUI.w(SnsTimeLineUI.this);
          SnsTimeLineUI.x(SnsTimeLineUI.this);
          SnsTimeLineUI.this.setMMTitle(SnsTimeLineUI.this.getString(2131766275));
          SnsTimeLineUI.y(SnsTimeLineUI.this);
          SnsTimeLineUI.c(SnsTimeLineUI.this, SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition());
          AppMethodBeat.o(179226);
        }
      };
      this.EMe = new SnsUIAction.a()
      {
        private int EMu = 0;
        private int EMv = 0;
        
        public final void ZS(int paramAnonymousInt)
        {
          AppMethodBeat.i(203687);
          int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          int k = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
          if ((paramAnonymousInt == 0) && (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)) {
            SnsTimeLineUI.a(SnsTimeLineUI.this, j, k);
          }
          if ((j == this.EMu) && (k == this.EMv))
          {
            AppMethodBeat.o(203687);
            return;
          }
          this.EMu = j;
          this.EMv = k;
          Log.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramAnonymousInt) });
          Object localObject1;
          boolean bool;
          int m;
          int n;
          int i1;
          if (paramAnonymousInt == 2)
          {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, SnsTimeLineUI.F(SnsTimeLineUI.this));
            localObject1 = SnsTimeLineUI.this;
            bool = WXHardCoderJNI.hcSNSScrollEnable;
            m = WXHardCoderJNI.hcSNSScrollDelay;
            n = WXHardCoderJNI.hcSNSScrollCPU;
            i1 = WXHardCoderJNI.hcSNSScrollIO;
            if (!WXHardCoderJNI.hcSNSScrollThr) {
              break label519;
            }
          }
          LinkedList localLinkedList;
          label519:
          for (int i = Process.myTid();; i = 0)
          {
            SnsTimeLineUI.d((SnsTimeLineUI)localObject1, WXHardCoderJNI.startPerformance(bool, m, n, i1, i, WXHardCoderJNI.hcSNSScrollTimeout, 701, WXHardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI"));
            Log.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsTimeLineUI.F(SnsTimeLineUI.this)) });
            if ((paramAnonymousInt != 0) || (SnsTimeLineUI.a(SnsTimeLineUI.this) == null)) {
              break label553;
            }
            localObject1 = SnsTimeLineUI.a(SnsTimeLineUI.this);
            if (k < j) {
              break label540;
            }
            localLinkedList = new LinkedList();
            paramAnonymousInt = j;
            while (paramAnonymousInt <= k)
            {
              Object localObject2 = ((com.tencent.mm.plugin.sns.ui.a.c)localObject1).Zv(paramAnonymousInt - 1);
              if (localObject2 != null)
              {
                localObject2 = ((SnsInfo)localObject2).getTimeLine();
                if ((localObject2 != null) && (!TextUtils.isEmpty(((TimeLineObject)localObject2).ContentObj.Url)) && (((TimeLineObject)localObject2).ContentObj.Url.contains(WeChatHosts.domainString(2131761726))) && (((TimeLineObject)localObject2).ContentObj.LoU == 3))
                {
                  i = -1;
                  if (((TimeLineObject)localObject2).ContentObj.LoY != null) {
                    i = ((TimeLineObject)localObject2).ContentObj.LoY.iAb;
                  }
                  ArrayList localArrayList = new ArrayList();
                  localArrayList.add(((TimeLineObject)localObject2).ContentObj.Url);
                  localArrayList.add(String.valueOf(i));
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).Id));
                  localArrayList.add("");
                  localArrayList.add("");
                  localArrayList.add(((TimeLineObject)localObject2).UserName);
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).CreateTime));
                  localArrayList.add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahy("__sns_timeline__")));
                  localLinkedList.add(localArrayList);
                }
              }
              paramAnonymousInt += 1;
            }
          }
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).j(localLinkedList, 2);
          label540:
          SnsTimeLineUI.a(SnsTimeLineUI.this).iS(j, k);
          label553:
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)
          {
            localObject1 = SnsTimeLineUI.j(SnsTimeLineUI.this).b(SnsTimeLineUI.a(SnsTimeLineUI.this).ESp);
            com.tencent.mm.vending.g.g.hdG().d(new com.tencent.mm.vending.c.a() {});
          }
          com.tencent.mm.plugin.sns.k.e.DUQ.ix(j, k);
          com.tencent.mm.plugin.sns.k.e.DUQ.iy(j, k);
          AppMethodBeat.o(203687);
        }
        
        public final void a(com.tencent.mm.plugin.sns.data.m paramAnonymousm) {}
        
        public final void aP(int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(203688);
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).ESq.notifyVendingDataChange();
          }
          if (!paramAnonymousBoolean) {
            SnsTimeLineUI.this.aBf().bk(c.b.class);
          }
          AppMethodBeat.o(203688);
        }
        
        public final void d(int paramAnonymousInt, List<Integer> paramAnonymousList1, List<Integer> paramAnonymousList2)
        {
          int j = 1;
          AppMethodBeat.i(203682);
          int i = j;
          if (paramAnonymousInt > 0)
          {
            paramAnonymousList1 = com.tencent.mm.plugin.sns.model.aj.faO().Zr(paramAnonymousInt);
            i = j;
            if (paramAnonymousList1 != null)
            {
              if (paramAnonymousList1.getPravited() > 0) {
                Toast.makeText(SnsTimeLineUI.this, 2131766066, 1).show();
              }
              i = j;
              if (paramAnonymousList1.getPravited() == 1) {
                i = 0;
              }
            }
          }
          if (i != 0)
          {
            paramAnonymousList1 = SnsTimeLineUI.d(SnsTimeLineUI.this).list;
            paramAnonymousList1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousList1);
            paramAnonymousList2 = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousList2, paramAnonymousList1.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousList1.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousList2, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          }
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).ESq.notifyVendingDataChange();
          }
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.b(SnsTimeLineUI.this);
          }
          AppMethodBeat.o(203682);
        }
        
        public final void fjg()
        {
          AppMethodBeat.i(203677);
          if (com.tencent.mm.plugin.sns.model.aj.faZ().DNH)
          {
            Log.i("MicroMsg.SnsTimeLineUI", "isAutoScrolling, skip onLoadingMore");
            AppMethodBeat.o(203677);
            return;
          }
          com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
          SnsTimeLineUI.n(SnsTimeLineUI.this);
          localc.e(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), false, SnsTimeLineUI.A(SnsTimeLineUI.this));
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oih, Integer.valueOf(3));
          Log.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
          if (SnsTimeLineUI.B(SnsTimeLineUI.this) == null)
          {
            Log.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
            AppMethodBeat.o(203677);
            return;
          }
          if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
          {
            SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
            SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
          }
          AppMethodBeat.o(203677);
        }
        
        public final View fjh()
        {
          AppMethodBeat.i(203679);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).DQt == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).DQt = ((FrameLayout)SnsTimeLineUI.this.findViewById(2131309104));
          }
          FrameLayout localFrameLayout = SnsTimeLineUI.k(SnsTimeLineUI.this).DQt;
          AppMethodBeat.o(203679);
          return localFrameLayout;
        }
        
        public final MMPullDownView fji()
        {
          AppMethodBeat.i(203681);
          MMPullDownView localMMPullDownView = (MMPullDownView)SnsTimeLineUI.this.findViewById(2131308198);
          AppMethodBeat.o(203681);
          return localMMPullDownView;
        }
        
        public final boolean fjj()
        {
          AppMethodBeat.i(203683);
          boolean bool = SnsTimeLineUI.D(SnsTimeLineUI.this);
          AppMethodBeat.o(203683);
          return bool;
        }
        
        public final void fjk()
        {
          AppMethodBeat.i(203684);
          Log.d("MicroMsg.SnsTimeLineUI", "onLoadingTap");
          SnsTimeLineUI.this.ffL();
          if ((!SnsTimeLineUI.d(SnsTimeLineUI.this).EvK) && (!SnsTimeLineUI.E(SnsTimeLineUI.this)))
          {
            if (SnsTimeLineUI.u(SnsTimeLineUI.this) != null)
            {
              Log.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
              SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
            }
            com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this);
            localc.d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oih, Integer.valueOf(2));
          }
          AppMethodBeat.o(203684);
        }
        
        public final void fjl()
        {
          AppMethodBeat.i(203685);
          SnsTimeLineUI.this.ffL();
          AppMethodBeat.o(203685);
        }
        
        public final void fjm()
        {
          AppMethodBeat.i(203686);
          com.tencent.mm.plugin.sns.model.aj.faZ().fbK();
          int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          Object localObject1 = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getChildAt(0);
          Log.i("MicroMsg.SnsTimeLineUI", "will do up fetch isDoingFetch:%s, SnsCore.getSnsUnreadTipManager().isAutoScrolling:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.sns.model.aj.faZ().DNI), Boolean.valueOf(com.tencent.mm.plugin.sns.model.aj.faZ().DNH) });
          if ((!com.tencent.mm.plugin.sns.model.aj.faZ().DNH) && (localObject1 != null) && (i == 0) && (((View)localObject1).getTop() == 0) && (SnsTimeLineUI.d(SnsTimeLineUI.this).EvK))
          {
            if (com.tencent.mm.plugin.sns.model.aj.faZ().DNI)
            {
              AppMethodBeat.o(203686);
              return;
            }
            Object localObject2 = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this);
            localObject1 = SnsTimeLineUI.o(SnsTimeLineUI.this);
            i = com.tencent.mm.plugin.sns.model.ax.DOe;
            boolean bool = SnsTimeLineUI.q(SnsTimeLineUI.this);
            int j = SnsTimeLineUI.A(SnsTimeLineUI.this);
            if ((((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).hasInit) && (((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).EMi == 0))
            {
              long l = com.tencent.mm.plugin.sns.model.aj.faZ().DNE;
              localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).ESM;
              if (((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).EKQ != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).EKQ.FgD;
                com.tencent.mm.vending.g.g.b(localObject1, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(j), Long.valueOf(l)).c((com.tencent.mm.vending.c.a)localObject2);
              }
            }
            if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
            {
              SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
              SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
            }
          }
          AppMethodBeat.o(203686);
        }
        
        public final View getMaskView()
        {
          AppMethodBeat.i(203680);
          View localView = SnsTimeLineUI.this.findViewById(2131308106);
          AppMethodBeat.o(203680);
          return localView;
        }
        
        public final ListView getSnsListView()
        {
          AppMethodBeat.i(203678);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).list == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).list = ((ListView)SnsTimeLineUI.this.findViewById(2131308189));
          }
          ListView localListView = SnsTimeLineUI.k(SnsTimeLineUI.this).list;
          AppMethodBeat.o(203678);
          return localListView;
        }
        
        public final int getType()
        {
          int i = 1;
          if (SnsTimeLineUI.this.EMi == 1) {
            i = 2;
          }
          return i;
        }
        
        public final void iR(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void vy(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(203689);
          SnsTimeLineUI localSnsTimeLineUI = SnsTimeLineUI.this;
          localSnsTimeLineUI.ELZ = paramAnonymousBoolean;
          MMHandler localMMHandler = com.tencent.mm.plugin.sns.model.aj.dRd();
          com.tencent.mm.plugin.sns.model.g localg = com.tencent.mm.plugin.sns.model.aj.faL();
          com.tencent.mm.plugin.sns.model.c localc = com.tencent.mm.plugin.sns.model.aj.faJ();
          if (paramAnonymousBoolean)
          {
            if ((localg.DGJ) || (localc.DGJ))
            {
              localMMHandler.removeCallbacks(localSnsTimeLineUI.EMa);
              localMMHandler.removeCallbacks(localSnsTimeLineUI.EMb);
              localMMHandler.postDelayed(localSnsTimeLineUI.EMa, 0L);
              AppMethodBeat.o(203689);
            }
          }
          else if ((!localg.DGJ) || (!localc.DGJ))
          {
            localMMHandler.removeCallbacks(localSnsTimeLineUI.EMa);
            localMMHandler.removeCallbacks(localSnsTimeLineUI.EMb);
            localMMHandler.postDelayed(localSnsTimeLineUI.EMb, 0L);
          }
          AppMethodBeat.o(203689);
        }
      };
      this.EMf = 0L;
      this.EMg = new a.b() {};
      this.mScreenWidth = 0;
      this.mScreenHeight = 0;
      this.EMh = true;
      this.zdW = 0L;
      this.hlB = 0L;
      this.iTC = 0L;
      this.EyL = new ScreenShotUtil.ScreenShotCallback()
      {
        public final void onScreenShot(String paramAnonymousString, long paramAnonymousLong)
        {
          AppMethodBeat.i(203698);
          Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
          SnsTimeLineUI.M(SnsTimeLineUI.this);
          AppMethodBeat.o(203698);
        }
      };
      this.EMi = 0;
      this.ubB = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(203711);
          SnsTimeLineUI.this.hideVKB();
          SnsTimeLineUI.this.finish();
          AppMethodBeat.o(203711);
          return false;
        }
      };
      this.EMl = 0L;
      this.EMm = false;
      AppMethodBeat.o(99372);
      return;
    }
  }
  
  private void ZR(int paramInt)
  {
    AppMethodBeat.i(99376);
    if (ELX.booleanValue()) {
      if (paramInt != 0) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsTimeLineUI", "setRefreshAnimVisible %s %s", new Object[] { Boolean.valueOf(bool), Util.getStack().toString() });
      this.EKW.setVisibility(paramInt);
      AppMethodBeat.o(99376);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, com.tencent.mm.ak.q paramq, final Context paramContext)
  {
    AppMethodBeat.i(203732);
    if (paramq == null)
    {
      AppMethodBeat.o(203732);
      return;
    }
    if (paramq.getType() != 213)
    {
      AppMethodBeat.o(203732);
      return;
    }
    if (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag())
    {
      AppMethodBeat.o(203732);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(203732);
      return;
    }
    if (!(paramq instanceof p))
    {
      AppMethodBeat.o(203732);
      return;
    }
    paramq = (p)paramq;
    if (((paramContext instanceof SnsTimeLineUI)) && (paramq.DIk != 0))
    {
      AppMethodBeat.o(203732);
      return;
    }
    final long l = com.tencent.mm.model.cl.aWB();
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203722);
        Object localObject1 = this.EMI;
        if (((p)localObject1).DIb != null) {}
        SnsInfo localSnsInfo;
        for (localObject1 = ((p)localObject1).DIb.MZb;; localObject1 = null)
        {
          localObject2 = this.EMI.DqN;
          localSnsInfo = this.EMI.DqO;
          if ((localObject1 != null) && (localObject2 != null) && (localSnsInfo != null)) {
            break;
          }
          AppMethodBeat.o(203722);
          return;
        }
        Object localObject2 = r.a((dzi)localObject1, (SnsObject)localObject2);
        if (localObject2 == null)
        {
          AppMethodBeat.o(203722);
          return;
        }
        localObject1 = k.a.Krb.matcher(((dzi)localObject1).iAc);
        while (((Matcher)localObject1).find()) {
          SnsCommentFooter.a(paramContext, localSnsInfo, r.a((dzo)localObject2), String.valueOf(((dzo)localObject2).MYT), 3, ((Matcher)localObject1).group(), l);
        }
        AppMethodBeat.o(203722);
      }
    }, "WebSearchReportLogic.TagSearchReport");
    AppMethodBeat.o(203732);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(99406);
    if (paramc.active)
    {
      Log.d("MicroMsg.SnsTimeLineUI", "report weishi: %s", new Object[] { paramc.toString() });
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(15827, paramc.toString());
    }
    AppMethodBeat.o(99406);
  }
  
  private boolean fA(View paramView)
  {
    AppMethodBeat.i(203730);
    try
    {
      if (getContext() != null)
      {
        boolean bool = getContext().isFinishing();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(203730);
        return false;
      }
      Rect localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      paramView = new DisplayMetrics();
      getContext().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      int i = paramView.heightPixels;
      int j = this.mActionBar.getHeight() + com.tencent.mm.ui.ao.jJ(this);
      Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "lxl checkItemVisible actionbar height:%s, total height:%s, screenHeight:%s, top:%s, bottom:%s", new Object[] { Integer.valueOf(this.mActionBar.getHeight()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localRect.top), Integer.valueOf(localRect.bottom) });
      if ((localRect.bottom > j) && (i > localRect.top))
      {
        AppMethodBeat.o(203730);
        return true;
      }
    }
    catch (Throwable paramView)
    {
      Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", paramView.toString());
      AppMethodBeat.o(203730);
      return false;
    }
    AppMethodBeat.o(203730);
    return false;
  }
  
  private void fiY()
  {
    AppMethodBeat.i(99377);
    this.mUIAction.list.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99306);
        int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
        int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
        Log.d("MicroMsg.SnsTimeLineUI", "notifyList from:%s to:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        SnsTimeLineUI.a(SnsTimeLineUI.this, i, j);
        SnsTimeLineUI.d(SnsTimeLineUI.this).bIW();
        AppMethodBeat.o(99306);
      }
    }, 15L);
    AppMethodBeat.o(99377);
  }
  
  private void fiZ()
  {
    AppMethodBeat.i(99380);
    boolean bool;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rPM, 0) == 1)
    {
      bool = true;
      this.autoPlay = bool;
      String str1 = Build.MODEL.toLowerCase();
      String str2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rPN, "");
      if ((!Util.isNullOrNil(str2)) && (str2.contains(str1)))
      {
        Log.i("MicroMsg.SnsTimeLineUI", "model %s is hit, expt:%s", new Object[] { str1, str2 });
        this.autoPlay = false;
      }
      if (!this.autoPlay) {
        break label225;
      }
      if (!this.ELq.emf()) {
        break label170;
      }
      this.autoPlay = false;
      Log.i("MicroMsg.SnsTimeLineUI", "2G/3G autoplay false");
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsTimeLineUI", "autoPlay:%s", new Object[] { Boolean.valueOf(this.autoPlay) });
      AppMethodBeat.o(99380);
      return;
      bool = false;
      break;
      label170:
      if (this.ELq.cGF())
      {
        Log.i("MicroMsg.SnsTimeLineUI", "wifi autoplay true");
        this.autoPlay = true;
      }
      else
      {
        this.autoPlay = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NZX, Boolean.TRUE)).booleanValue();
        continue;
        label225:
        Log.i("MicroMsg.SnsTimeLineUI", "autoPlay DynamicConfig false");
      }
    }
  }
  
  private void fja()
  {
    AppMethodBeat.i(99381);
    if (this.EMi == 1)
    {
      if (!this.EqY)
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99381);
        return;
      }
      addIconOptionMenu(0, getString(2131766138), 2131689504, new SnsTimeLineUI.36(this));
      AppMethodBeat.o(99381);
      return;
    }
    addIconOptionMenu(0, 2131765923, 2131690501, new SnsTimeLineUI.37(this), new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203697);
        localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).EoF != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).EoF.DMa.uT(true);
        }
        com.tencent.mm.kernel.g.aAi();
        boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(7490, Boolean.TRUE)).booleanValue();
        com.tencent.mm.plugin.sns.model.aj.faV().vk(true);
        paramAnonymousView = com.tencent.mm.plugin.sns.model.aj.faV().aQn("draft_text");
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.field_draft;
          if (!Util.isNullOrNil(paramAnonymousView))
          {
            com.tencent.mm.kernel.g.aAi();
            localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NUY, "");
            new im().ahi().wj((String)localObject).bfK();
            localObject = Parcel.obtain();
            ((Parcel)localObject).unmarshall(paramAnonymousView, 0, paramAnonymousView.length);
            ((Parcel)localObject).setDataPosition(0);
          }
        }
        try
        {
          paramAnonymousView = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject);
          if (SnsTimeLineUI.aZ(paramAnonymousView))
          {
            SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(203697);
            return true;
          }
          com.tencent.mm.plugin.sns.model.aj.faV().b("draft_text", null, 0);
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            com.tencent.mm.plugin.sns.model.aj.faV().b("draft_text", null, 0);
            continue;
            paramAnonymousView = SnsTimeLineUI.this;
            localObject = new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(7490, Boolean.FALSE);
          }
        }
        if (!bool)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(SnsTimeLineUI.this, SnsUploadUI.class);
          paramAnonymousView.putExtra("KSnsPostManu", true);
          paramAnonymousView.putExtra("KTouchCameraTime", Util.nowSecond());
          paramAnonymousView.putExtra("sns_comment_type", 1);
          paramAnonymousView.putExtra("Ksnsupload_type", 9);
          localObject = com.tencent.mm.modelsns.k.tO(705);
          ((com.tencent.mm.modelsns.k)localObject).tS(((com.tencent.mm.modelsns.k)localObject).jll).PI(System.currentTimeMillis()).tS(((com.tencent.mm.modelsns.k)localObject).jlm).tS(1);
          localObject = com.tencent.mm.plugin.sns.k.g.DVR.b((com.tencent.mm.modelsns.k)localObject);
          ((com.tencent.mm.modelsns.k)localObject).bfK();
          ((com.tencent.mm.modelsns.k)localObject).b(paramAnonymousView, "intent_key_StatisticsOplog");
          SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(203697);
          return true;
        }
      }
    });
    AppMethodBeat.o(99381);
  }
  
  private void fjb()
  {
    AppMethodBeat.i(99391);
    setTitleBarClickListener(new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(203712);
        SnsTimeLineUI.S(SnsTimeLineUI.this);
        AppMethodBeat.o(203712);
      }
    }, new Runnable()
    {
      public final void run() {}
    });
    setBackBtn(this.ubB, 2131689492);
    AppMethodBeat.o(99391);
  }
  
  private int fjc()
  {
    if (this.ELx == 0) {
      return this.ELu;
    }
    if (this.ELx == 1) {
      return this.ELv;
    }
    return this.ELw;
  }
  
  private void fjd()
  {
    AppMethodBeat.i(99392);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OnA, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OnA, Boolean.FALSE);
    if (bool) {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OnA, Boolean.FALSE);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.g.aAi();
      int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oir, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(getContext(), "", getContext().getResources().getString(2131766549, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(99392);
      return;
    }
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).startStoryCaptureForResult(getContext(), 0, System.currentTimeMillis(), 18);
    AppMethodBeat.o(99392);
  }
  
  private void fje()
  {
    AppMethodBeat.i(99393);
    if (com.tencent.mm.q.a.cA(this))
    {
      AppMethodBeat.o(99393);
      return;
    }
    if (com.tencent.mm.q.a.cE(this))
    {
      AppMethodBeat.o(99393);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "");
    Log.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
    if (!bool)
    {
      AppMethodBeat.o(99393);
      return;
    }
    long l = com.tencent.mm.model.cl.aWz();
    Object localObject1 = r.eZx();
    Log.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", new Object[] { localObject1 });
    com.tencent.mm.plugin.report.service.h.CyF.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), localObject1, Long.valueOf(l) });
    Object localObject2 = new SightParams(2, 0);
    localObject2 = RecordConfigProvider.a("", "", ((SightParams)localObject2).irT, ((SightParams)localObject2).irT.duration * 1000, 2);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rYO, false)) {
      ((RecordConfigProvider)localObject2).remuxType = 2;
    }
    Object localObject3 = new VideoCaptureReportInfo();
    ((VideoCaptureReportInfo)localObject3).sQn = 1;
    ((RecordConfigProvider)localObject2).BOE = ((VideoCaptureReportInfo)localObject3);
    localObject3 = new UICustomParam.a();
    ((UICustomParam.a)localObject3).apD();
    ((UICustomParam.a)localObject3).apE();
    ((UICustomParam.a)localObject3).dz(true);
    ((RecordConfigProvider)localObject2).BOn = ((UICustomParam.a)localObject3).gLU;
    localObject3 = new SnsTimeLineUI.65(this);
    CaptureDataManager.BOb.BOa = ((CaptureDataManager.b)localObject3);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rYM, true))
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 17, 2130772161, 2130772162, (RecordConfigProvider)localObject2);
      AppMethodBeat.o(99393);
      return;
    }
    localObject2 = new Intent();
    com.tencent.mm.pluginsdk.ui.tools.s.d(getContext(), (Intent)localObject2, (String)localObject1);
    AppMethodBeat.o(99393);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(203729);
    Log.i("MicroMsg.SnsTimeLineUI", "onOtherAddSize respMaxSeq:%s, respMinSeq:%s", new Object[] { paramString1, paramString2 });
    this.EMc.removeCallbacks(this.ELC);
    com.tencent.mm.vending.g.g.hdG().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(203729);
  }
  
  public final void a(final String paramString, boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99373);
    this.EMc.removeCallbacks(this.ELC);
    com.tencent.mm.vending.g.g.hdG().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(99373);
  }
  
  public final void aVs()
  {
    AppMethodBeat.i(99396);
    aBf().bk(c.b.class);
    AppMethodBeat.o(99396);
  }
  
  public final void aVt() {}
  
  public final void aVu()
  {
    AppMethodBeat.i(99397);
    if (this.EMm)
    {
      AppMethodBeat.o(99397);
      return;
    }
    Log.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
    this.EMm = true;
    com.tencent.mm.plugin.sns.model.aj.dRd().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203719);
        if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
          SnsTimeLineUI.a(SnsTimeLineUI.this).ESq.notifyVendingDataChange();
        }
        SnsTimeLineUI.ah(SnsTimeLineUI.this);
        AppMethodBeat.o(203719);
      }
    }, 1000L);
    AppMethodBeat.o(99397);
  }
  
  public final void aVv()
  {
    AppMethodBeat.i(99400);
    aBf().bk(c.b.class);
    AppMethodBeat.o(99400);
  }
  
  public final void b(final String paramString, final boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99374);
    this.EMc.removeCallbacks(this.ELC);
    com.tencent.mm.vending.g.g.hdG().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
    {
      private Void a(Void paramAnonymousVoid)
      {
        AppMethodBeat.i(203673);
        if (SnsTimeLineUI.l(SnsTimeLineUI.this) != null)
        {
          SnsTimeLineUI.m(SnsTimeLineUI.this);
          SnsTimeLineUI.l(SnsTimeLineUI.this).fjt();
        }
        SnsTimeLineUI.d(SnsTimeLineUI.this).qeT = paramb.eZa();
        if (SnsTimeLineUI.this.EMi == 0)
        {
          Log.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[] { Boolean.valueOf(paramb.eZa()) });
          if (paramb.eZa()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).aRh(paramb.eZg());
          }
          AppMethodBeat.o(203673);
          return paramAnonymousVoid;
        }
        if ((paramBoolean) && (!SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))))
        {
          SnsTimeLineUI.d(SnsTimeLineUI.this).qeT = true;
          SnsTimeLineUI.d(SnsTimeLineUI.this).aQU(paramb.eZg());
        }
        for (;;)
        {
          AppMethodBeat.o(203673);
          return paramAnonymousVoid;
          if ((SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))) && (paramb.eZf() != 0L))
          {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oap, Long.valueOf(paramb.eZf()));
          }
          if (paramb.eZa()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).aRh(paramb.eZg());
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
    Log.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[] { paramKeyEvent.toString() });
    int k = keyboardState();
    i locali = this.EKZ;
    int i = j;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      i = j;
      if (locali.EoJ.getVisibility() == 0)
      {
        locali.EoJ.setVisibility(8);
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
  
  public final boolean ffL()
  {
    AppMethodBeat.i(99395);
    if ((this.EKZ == null) || (this.EKZ.EoQ == null))
    {
      AppMethodBeat.o(99395);
      return false;
    }
    if ((this.EKZ == null) || (this.EKZ.EoR == null))
    {
      if ((this.EKZ != null) && (this.EKZ.EoT != null)) {
        break label118;
      }
      label65:
      if ((this.EKZ != null) && (this.EKZ.EoU != null)) {
        break label132;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.eWu();
      boolean bool = this.EKZ.EoQ.ffL();
      AppMethodBeat.o(99395);
      return bool;
      this.EKZ.EoR.fcl();
      break;
      label118:
      this.EKZ.EoT.fcl();
      break label65;
      label132:
      this.EKZ.EoU.fka();
    }
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(99399);
    Log.d("MicroMsg.SnsTimeLineUI", "finalize");
    super.finalize();
    AppMethodBeat.o(99399);
  }
  
  public final com.tencent.mm.plugin.sns.ad.g.k fjf()
  {
    return this.EBv;
  }
  
  public final boolean fv(View paramView)
  {
    AppMethodBeat.i(99394);
    this.EKZ.EoR.fcl();
    this.EKZ.EoT.fcl();
    boolean bool = this.EKZ.EoQ.d(paramView, false, false);
    AppMethodBeat.o(99394);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131496514;
  }
  
  public void initView()
  {
    boolean bool3 = false;
    AppMethodBeat.i(99388);
    this.mUIAction.DSh.setDrawingCacheEnabled(false);
    this.EKZ.DQt = ((FrameLayout)findViewById(2131309104));
    int i = com.tencent.mm.plugin.sns.model.aj.faY().position;
    Object localObject = (AdListView)this.mUIAction.getSnsListView();
    ((AdListView)localObject).Enb = this.EBv;
    ((AdListView)localObject).setTimelineStat(this.ELh);
    ((AdListView)localObject).setTimelineEvent(this.ELi);
    this.ELi.a(com.tencent.mm.plugin.sns.model.aj.faF());
    Log.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.EoO, new Object[] { Integer.valueOf(i) });
    this.EKW = ((QFadeImageView)findViewById(2131308199));
    this.EKW.setImageResource(2131690346);
    this.ELb = new a(this.mUIAction.getSnsListView());
    this.ELb.setInterpolator(new LinearInterpolator());
    this.ELb.setAnimationListener(new SnsTimeLineUI.41(this));
    localObject = null;
    if (this.EMi == 1)
    {
      this.EKY = true;
      localObject = new com.tencent.mm.plugin.sns.ui.a.b.d(this.mRa, this.EqY);
    }
    this.EKT = new com.tencent.mm.plugin.sns.ui.a.c(this, this.mUIAction.getSnsListView(), this.EKZ.EoV, this.EKZ, this.ELj, (com.tencent.mm.plugin.sns.ui.a.b.b)localObject, this.ELF);
    this.EKZ.EoV.Fbe = new bk.b()
    {
      public final boolean fiX()
      {
        AppMethodBeat.i(203702);
        SnsTimeLineUI.this.aBf().bk(c.b.class);
        AppMethodBeat.o(203702);
        return false;
      }
    };
    this.EKZ.DQX = this.EKT.ESp;
    this.EKT.ESq.QYM = new com.tencent.mm.vending.a.b.a()
    {
      public final void fjp()
      {
        AppMethodBeat.i(203703);
        com.tencent.mm.plugin.report.service.g.Wl(14);
        AppMethodBeat.o(203703);
      }
      
      public final void fjq()
      {
        AppMethodBeat.i(203704);
        com.tencent.mm.plugin.report.service.g.Wm(14);
        AppMethodBeat.o(203704);
      }
    };
    this.ELc = ((TestTimeForSns)this.EKZ.DQt);
    this.ELc.setListener(new TestTimeForSns.a()
    {
      public final void dSa()
      {
        AppMethodBeat.i(203705);
        Log.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
        SnsTimeLineUI.I(SnsTimeLineUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(176335);
            if ((SnsTimeLineUI.a(SnsTimeLineUI.this) == null) || (SnsTimeLineUI.I(SnsTimeLineUI.this) == null))
            {
              Log.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
              AppMethodBeat.o(176335);
              return;
            }
            SnsTimeLineUI.I(SnsTimeLineUI.this).setListener(null);
            SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.O(SnsTimeLineUI.this));
            if (SnsTimeLineUI.P(SnsTimeLineUI.this))
            {
              Log.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
              AppMethodBeat.o(176335);
              return;
            }
            if (SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              com.tencent.mm.plugin.sns.model.aj.faE().W(com.tencent.mm.plugin.sns.model.aj.faY().DMw, -1);
              com.tencent.mm.plugin.sns.model.aj.faE().Jv(com.tencent.mm.plugin.sns.model.aj.faY().DMx);
            }
            Object localObject1;
            int i;
            if (!SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              Log.i("MicroMsg.SnsTimeLineUI", "onViewDrawed doFpList");
              localObject1 = com.tencent.mm.plugin.sns.model.aj.faW();
              Object localObject2 = "select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.state=" + com.tencent.mm.plugin.sns.storage.x.EmU + " order by SnsWsFoldGroup.top desc limit 1";
              localObject1 = ((com.tencent.mm.plugin.sns.storage.x)localObject1).iFy.rawQuery((String)localObject2, null, 2);
              if (localObject1 == null) {
                break label535;
              }
              if (!((Cursor)localObject1).moveToFirst()) {
                break label530;
              }
              localObject2 = new w();
              ((w)localObject2).convertFrom((Cursor)localObject1);
              i = ((w)localObject2).field_size;
              ((Cursor)localObject1).close();
            }
            for (;;)
            {
              Log.i("MicroMsg.SnsTimeLineUI", "oldWsFoldSize:%s newWsFoldSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(ah.DKg) });
              if ((i != -1) && (i != ah.DKg))
              {
                localObject1 = com.tencent.mm.plugin.sns.model.aj.faW();
                long l = System.currentTimeMillis();
                Log.i("MicroMsg.SnsWsFoldGroupStorage", "dropTable:%s %s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.sns.storage.x)localObject1).iFy.execSQL("SnsWsFoldGroup", "DELETE FROM SnsWsFoldGroup")), Long.valueOf(System.currentTimeMillis() - l) });
                localObject1 = com.tencent.mm.plugin.sns.model.aj.faX();
                l = System.currentTimeMillis();
                boolean bool = ((com.tencent.mm.plugin.sns.storage.v)localObject1).iFy.execSQL("SnsWsFoldGroupDetail", "DELETE FROM SnsWsFoldGroupDetail");
                ((com.tencent.mm.plugin.sns.storage.v)localObject1).EmT.clear();
                Log.i("MicroMsg.SnsWsFoldDetailStorage", "dropTable:%s %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
              }
              localObject1 = SnsTimeLineUI.r(SnsTimeLineUI.this);
              SnsTimeLineUI.n(SnsTimeLineUI.this);
              ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oih, Integer.valueOf(1));
              SnsTimeLineUI.a(SnsTimeLineUI.this, false);
              if (SnsTimeLineUI.this.EBv != null) {
                SnsTimeLineUI.this.EBv.eXq();
              }
              AppMethodBeat.o(176335);
              return;
              label530:
              i = -1;
              break;
              label535:
              i = -1;
            }
          }
        });
        AppMethodBeat.o(203705);
      }
    });
    this.mUIAction.list.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(203706);
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          SnsTimeLineUI.this.ffL();
          if ((SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) && (SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() == 0)) {
            Log.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
          }
          SnsTimeLineUI.l(SnsTimeLineUI.this).fju();
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          }
          SnsTimeLineUI.k(SnsTimeLineUI.this).ffp();
          SnsTimeLineUI.k(SnsTimeLineUI.this).EoK.fjZ();
        }
        AppMethodBeat.o(203706);
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
        SnsTimeLineUI.k(SnsTimeLineUI.this).EoK.EBc = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getBottom();
        SnsTimeLineUI.k(SnsTimeLineUI.this).EoK.ERI = SnsTimeLineUI.d(SnsTimeLineUI.this).zog.getTop();
        SnsTimeLineUI.l(SnsTimeLineUI.this).EMU = com.tencent.mm.ui.at.fromDPToPix(SnsTimeLineUI.this.getContext(), -44);
        AppMethodBeat.o(176343);
      }
    });
    this.mUIAction.zog.setOnSrcollDistance(new MMPullDownView.f()
    {
      public final void bY(float paramAnonymousFloat)
      {
        AppMethodBeat.i(203707);
        SnsTimeLineUI.Q(SnsTimeLineUI.this);
        if (SnsTimeLineUI.ELX.booleanValue()) {
          Log.i("MicroMsg.SnsTimeLineUI", "mUIAction.header.getTop %s originalHeaderTop %s distanceY %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).DSh.getTop()), Integer.valueOf(SnsTimeLineUI.l(SnsTimeLineUI.this).EMU), Float.valueOf(paramAnonymousFloat) });
        }
        if (((paramAnonymousFloat > 0.0F) || (SnsTimeLineUI.R(SnsTimeLineUI.this))) && ((SnsTimeLineUI.d(SnsTimeLineUI.this).DSh.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).EMU) || (paramAnonymousFloat > 0.0F)) && (!SnsTimeLineUI.d(SnsTimeLineUI.this).EvK)) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).bZ(paramAnonymousFloat);
        }
        SnsTimeLineUI.k(SnsTimeLineUI.this).ffp();
        SnsTimeLineUI.this.ffL();
        SnsTimeLineUI.k(SnsTimeLineUI.this).EoK.fjZ();
        AppMethodBeat.o(203707);
      }
      
      public final void fjr()
      {
        AppMethodBeat.i(203708);
        if (!SnsTimeLineUI.d(SnsTimeLineUI.this).EvK) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).fju();
        }
        if (SnsTimeLineUI.R(SnsTimeLineUI.this))
        {
          SnsTimeLineUI.b(SnsTimeLineUI.this, false);
          AppMethodBeat.o(203708);
          return;
        }
        SnsTimeLineUI.b(SnsTimeLineUI.this, true);
        AppMethodBeat.o(203708);
      }
    });
    this.EKZ.EoJ = ((SnsCommentFooter)findViewById(2131298947));
    this.EKZ.EoJ.post(new SnsTimeLineUI.49(this));
    this.EKZ.EoK = new bt(this.mUIAction.list, this.EKZ.EoJ);
    this.EKU = ((LinearLayout)this.mUIAction.DSh.findViewById(2131308179));
    this.EKU.findViewById(2131308175).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179269);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).EoF != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).EoF.DMa.uS(true);
        }
        paramAnonymousView = (c.b)SnsTimeLineUI.this.aBf().y(c.b.class);
        localObject = com.tencent.mm.modelsns.k.tO(725);
        ((com.tencent.mm.modelsns.k)localObject).tR(paramAnonymousView.xhI);
        ((com.tencent.mm.modelsns.k)localObject).bfK();
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
        paramAnonymousView.putExtra("sns_msg_comment_list_scene", 1);
        SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 13);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179269);
      }
    });
    this.EKV = ((LinearLayout)this.mUIAction.DSh.findViewById(2131308180));
    this.EKZ.EoL = new bb(this);
    fja();
    fjb();
    boolean bool1;
    label591:
    boolean bool2;
    if (this.EMi == 0)
    {
      setMMTitle(2131766275);
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
        break label923;
      }
      bool1 = true;
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sjy, 0)) {
        break label928;
      }
      bool2 = true;
      label615:
      Log.i("MicroMsg.SnsTimeLineUI", "getGpuMaxTextureSize %s %s.", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1)
      {
        bool1 = bool3;
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      ForceGpuUtil.setMaxTextureGet(bool1);
      if (bool1)
      {
        i = ForceGpuUtil.getMaxTextureSize();
        if (i > 2048) {
          break label933;
        }
        com.tencent.mm.plugin.report.service.h.CyF.dN(1198, 7);
      }
    }
    for (;;)
    {
      this.ELr = ((ViewGroup)findViewById(2131308250));
      this.ELr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(203709);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$55", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          SnsTimeLineUI.k(SnsTimeLineUI.this).ffv();
          com.tencent.mm.plugin.sns.k.e.DUQ.DVy.eTU = 2L;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$55", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203709);
        }
      });
      this.ELr.setVisibility(4);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = (com.tencent.mm.ui.at.fromDPToPix(getContext(), 24) + au.eu(getContext()) + au.getStatusBarHeight(getContext()));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.ELr.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(99388);
      return;
      if (this.EqY)
      {
        setMMTitle(2131766166);
        ZR(8);
        break;
      }
      Log.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, userName:%s, title:%s", new Object[] { this.mRa, this.mUIAction.title });
      localObject = com.tencent.mm.plugin.sns.model.aj.faC().Kn(this.mRa);
      if (localObject != null) {
        Log.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is not null");
      }
      for (localObject = ((com.tencent.mm.contact.c)localObject).arJ();; localObject = this.mUIAction.title)
      {
        setMMTitle(r.R((CharSequence)localObject));
        break;
        Log.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is null, title:%s", new Object[] { this.mUIAction.title });
      }
      label923:
      bool1 = false;
      break label591;
      label928:
      bool2 = false;
      break label615;
      label933:
      if (i <= 4096) {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1198, 8);
      } else if (i <= 6144) {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1198, 9);
      } else if (i <= 8192) {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1198, 10);
      } else {
        com.tencent.mm.plugin.report.service.h.CyF.dN(1198, 11);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99402);
    Log.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 15)
    {
      if ((this.EKZ != null) && (this.EKZ.EoV != null) && (this.EKZ.EoV.Far != null))
      {
        this.EKZ.EoV.Far.onActivityResult(paramInt1, paramInt2, paramIntent);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203723);
            SnsTimeLineUI.this.hideVKB();
            AppMethodBeat.o(203723);
          }
        }, 300L);
      }
      AppMethodBeat.o(99402);
      return;
    }
    if (paramInt1 == 16)
    {
      Log.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
      AppMethodBeat.o(99402);
      return;
    }
    if ((paramInt1 == 2333) && (paramIntent != null))
    {
      Object localObject = paramIntent.getStringExtra("Select_Contact");
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split(",");
        if (localObject.length > 0)
        {
          this.EKZ.EoJ.gte.showVKB();
          String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(localObject[0]);
          if (!Util.isNullOrNil(str))
          {
            this.EKZ.EoJ.fhY();
            this.EKZ.EoJ.setText("@" + str + " ");
            this.EKZ.EoJ.setCommentAtPrefix("@" + str + " ");
            this.EKZ.EoJ.setCommentInfo(new dzo());
            this.EKZ.EoJ.getCommentInfo().Username = localObject[0];
            this.EKZ.EoJ.setCommentFlag(8);
          }
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mUIAction.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 11)
    {
      this.EKS.d(this.mRa, this.ELk, this.EqY, this.ELl);
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
    Log.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
    EventCenter.instance.publish(new com.tencent.mm.g.a.cl());
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    Point localPoint = new Point();
    localPoint.x = paramConfiguration.widthPixels;
    localPoint.y = paramConfiguration.heightPixels;
    com.tencent.mm.plugin.sns.model.aj.k(localPoint);
    com.tencent.mm.plugin.sns.ui.widget.f.fll().Fff = 0;
    com.tencent.mm.plugin.sns.ui.widget.d.fli().Fff = 0;
    com.tencent.mm.kiss.widget.textview.c.hue.aBj();
    this.EKT.ESp.fiM();
    this.EKT.ESq.resolvedClear();
    AppMethodBeat.o(99382);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99379);
    Object localObject1;
    if (ELn == null)
    {
      ELn = Boolean.valueOf(com.tencent.mm.ui.ao.isDarkMode());
      com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
      com.tencent.mm.plugin.sns.model.b.a.fcd();
      localObject1 = com.tencent.mm.plugin.sns.model.aj.faM();
      ((az)localObject1).jrf = true;
      Log.i("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", new Object[] { Boolean.valueOf(((az)localObject1).jrf) });
      if (((((az)localObject1).jrf) && (!com.tencent.mm.plugin.sns.model.b.a.fce())) || (((az)localObject1).jre)) {
        ((az)localObject1).fbN();
      }
      o.bhl().fP(((az)localObject1).jrf);
      localObject1 = com.tencent.mm.plugin.sns.model.aj.faZ();
      if (!BuildInfo.DEBUG) {
        break label1110;
      }
      ((aw)localObject1).DNn = true;
      ((aw)localObject1).DNo = 1L;
      ((aw)localObject1).DNp = 86400L;
      ((aw)localObject1).DNq = 1;
      ((aw)localObject1).DNr = 1;
      ((aw)localObject1).DNs = 50;
      ((aw)localObject1).DNu = 2;
      ((aw)localObject1).DNt = 5;
      ((aw)localObject1).DNv = 0L;
      label168:
      Log.i("MicroMsg.SnsUnreadTipManager", "jumpEnable:%s, jumpMinInterval:%s, jumpMaxInterval:%s, jumpMinFeedsCount:%s, jumpMinFeedsGapCount:%s, jumpNotWsPercent:%s, jumpIndicatorIndexOffset:%s, jumpReadContinuousCount:%s, jumpIndicatorExposeInterval:%s", new Object[] { Boolean.valueOf(((aw)localObject1).DNn), Long.valueOf(((aw)localObject1).DNo), Long.valueOf(((aw)localObject1).DNp), Integer.valueOf(((aw)localObject1).DNq), Integer.valueOf(((aw)localObject1).DNr), Integer.valueOf(((aw)localObject1).DNs), Integer.valueOf(((aw)localObject1).DNu), Integer.valueOf(((aw)localObject1).DNt), Long.valueOf(((aw)localObject1).DNv) });
      if (((aw)localObject1).DNn) {
        ((aw)localObject1).DNm = (com.tencent.mm.plugin.sns.model.aj.getAccSnsPath() + "snsUnread.proto");
      }
    }
    int i;
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.mm.vfs.s.aW(((aw)localObject1).DNm, 0, -1);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          ((aw)localObject1).DNJ.parseFrom((byte[])localObject2);
          i = com.tencent.mm.model.cl.aWB();
          Log.i("MicroMsg.SnsUnreadTipManager", "unreadSnsIdList.indicatorExposeTime:%s, now:%s, jumpIndicatorExposeInterval:%s", new Object[] { Long.valueOf(((aw)localObject1).DNJ.DNN), Integer.valueOf(i), Long.valueOf(((aw)localObject1).DNv) });
          if ((((aw)localObject1).DNJ.DNN <= 0L) || (i - ((aw)localObject1).DNJ.DNN <= ((aw)localObject1).DNv)) {
            continue;
          }
          ((aw)localObject1).DNJ.DNN = 0L;
          ((aw)localObject1).DNN = ((aw)localObject1).DNJ.DNN;
          ((aw)localObject1).fbG();
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        label1110:
        Log.w("MicroMsg.SnsUnreadTipManager", "Exception:%s", new Object[] { localException.getMessage() });
        continue;
        bool = false;
        continue;
        com.tencent.mm.plugin.sns.model.at.DMS = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sdO, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sdN, 1) != 1) {
          continue;
        }
        bool = true;
        com.tencent.mm.plugin.sns.model.at.DMT = bool;
        com.tencent.mm.plugin.sns.model.at.DMU = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sdP, 60);
        continue;
        bool = false;
        continue;
        long l = com.tencent.mm.plugin.sns.model.at.DMS - Util.milliSecondsToNow(((com.tencent.mm.plugin.sns.model.at)localObject1).DMV);
        Log.i(com.tencent.mm.plugin.sns.model.at.TAG, "delay %s to reset", new Object[] { Long.valueOf(l) });
        MMHandlerThread.postToMainThreadDelayed(((com.tencent.mm.plugin.sns.model.at)localObject1).DMZ, l);
        continue;
        this.BdQ = findViewById(2131296366);
        if (this.BdQ == null) {
          break label1580;
        }
      }
      ((aw)localObject1).fbE();
      ((aw)localObject1).fbF();
      Log.i("MicroMsg.SnsUnreadTipManager", "firstUnreadId:%s unreadSnsIdList.lastSnsId:%s", new Object[] { Long.valueOf(((aw)localObject1).DNA), Long.valueOf(((aw)localObject1).DNJ.DRZ) });
      ((aw)localObject1).fbH();
      ((aw)localObject1).sessionId = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cME();
      localObject1 = ((aw)localObject1).DNT;
      com.tencent.mm.kernel.g.aAg().hqi.a(211, (com.tencent.mm.ak.i)localObject1);
      ((av)localObject1).DNl = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slp, 50);
      Log.i("MicroMsg.SnsUnreadPreloader", "onCreate PRELOAD_MAX_COUNT:%s", new Object[] { Integer.valueOf(((av)localObject1).DNl) });
      localObject1 = com.tencent.mm.plugin.sns.model.aj.fba();
      Log.i(com.tencent.mm.plugin.sns.model.at.TAG, "create");
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
      {
        com.tencent.mm.plugin.sns.model.at.DMS = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sdO, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sdN, 1) == 1)
        {
          bool = true;
          com.tencent.mm.plugin.sns.model.at.DMT = bool;
          com.tencent.mm.plugin.sns.model.at.DMU = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sdP, 60);
          Log.i(com.tencent.mm.plugin.sns.model.at.TAG, "updateConfig configEnable:%s, configInterval:%s, configExpiredTime:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.sns.model.at.DMT), Integer.valueOf(com.tencent.mm.plugin.sns.model.at.DMU), Long.valueOf(com.tencent.mm.plugin.sns.model.at.DMS) });
          if (((com.tencent.mm.plugin.sns.model.at)localObject1).DMV != 0L)
          {
            if (Util.milliSecondsToNow(((com.tencent.mm.plugin.sns.model.at)localObject1).DMV) < com.tencent.mm.plugin.sns.model.at.DMS) {
              continue;
            }
            Log.i(com.tencent.mm.plugin.sns.model.at.TAG, "already expired, reset directly");
            MMHandlerThread.postToMainThread(((com.tencent.mm.plugin.sns.model.at)localObject1).DMZ);
            if (((com.tencent.mm.plugin.sns.model.at)localObject1).DMX != null)
            {
              localObject2 = com.tencent.mm.plugin.sns.model.an.C(((com.tencent.mm.plugin.sns.model.at)localObject1).DMX);
              if (localObject2 != null)
              {
                com.tencent.mm.plugin.sns.k.e.DUQ.DVz.xm(((com.tencent.mm.plugin.sns.model.at)localObject1).DMY);
                com.tencent.mm.plugin.sns.k.e.DUQ.DVz.xl(r.Jc(((com.tencent.mm.plugin.sns.model.at)localObject1).DMX.field_snsId));
                com.tencent.mm.plugin.sns.k.e.DUQ.DVz.eTY = ((SnsObject)localObject2).LikeCount;
                com.tencent.mm.plugin.sns.k.e.DUQ.DVz.eTZ = ((SnsObject)localObject2).CommentCount;
                com.tencent.mm.plugin.sns.k.e.DUQ.DVz.xn(String.valueOf(System.currentTimeMillis()));
                com.tencent.mm.plugin.sns.k.e.DUQ.DVA.xm(((com.tencent.mm.plugin.sns.model.at)localObject1).DMY);
                com.tencent.mm.plugin.sns.k.e.DUQ.DVA.xl(r.Jc(((com.tencent.mm.plugin.sns.model.at)localObject1).DMX.field_snsId));
                com.tencent.mm.plugin.sns.k.e.DUQ.DVA.eTY = ((SnsObject)localObject2).LikeCount;
                com.tencent.mm.plugin.sns.k.e.DUQ.DVA.eTZ = ((SnsObject)localObject2).CommentCount;
                com.tencent.mm.plugin.sns.k.e.DUQ.DVA.xn(String.valueOf(System.currentTimeMillis()));
              }
            }
          }
          if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class) != null) {
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahx("__sns_timeline__");
          }
          if (this.mController != null) {
            this.mController.bF(2, true);
          }
          getIntent().setExtrasClassLoader(getClass().getClassLoader());
          com.tencent.mm.pluginsdk.h.q(this);
          customfixStatusbar(true);
          super.onCreate(paramBundle);
          if (com.tencent.mm.kernel.g.aAf().azp()) {
            continue;
          }
          finish();
          AppMethodBeat.o(99379);
          return;
          if (ELn.booleanValue() == com.tencent.mm.ui.ao.isDarkMode()) {
            break;
          }
          Log.i("MicroMsg.SnsTimeLineUI", "dancy test UIMode change!!");
          ELn = Boolean.valueOf(com.tencent.mm.ui.ao.isDarkMode());
          com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
          break;
          if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
          {
            bool = true;
            ((aw)localObject1).DNn = bool;
            ((aw)localObject1).DNo = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slg, 3600);
            ((aw)localObject1).DNq = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slh, 5);
            ((aw)localObject1).DNr = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slj, 10);
            ((aw)localObject1).DNp = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slk, 86400L);
            ((aw)localObject1).DNs = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sll, 0);
            ((aw)localObject1).DNu = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sln, 1);
            ((aw)localObject1).DNt = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slm, 2);
            ((aw)localObject1).DNv = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slo, 14400);
            break label168;
          }
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sli, 1) == 1)
          {
            bool = true;
            continue;
          }
          bool = false;
          continue;
          if (((aw)localObject1).DNJ.DNN >= 0L) {
            continue;
          }
          ((aw)localObject1).DNJ.DNN = 0L;
          continue;
        }
      }
      if (com.tencent.mm.ui.statusbar.c.Qow) {
        break label3921;
      }
    }
    label1580:
    getWindow().getDecorView().setSystemUiVisibility(1280);
    paramBundle = MMApplicationContext.getDefaultPreference();
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("Main_need_read_top_margin", false);; bool = false) {
      for (;;)
      {
        com.tencent.mm.ui.b.e(this, bool);
        this.ELa = ((int)(getResources().getDisplayMetrics().heightPixels * 0.4D));
        setActionbarColor(getContext().getResources().getColor(2131101287));
        hideActionbarLine();
        this.EMi = getIntent().getIntExtra("sns_adapter_type", 0);
        this.EKY = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
        this.mActionBar = getSupportActionBar();
        i = com.tencent.mm.model.c.d.aXv().gO("Sns_Private_Recent_Setting_Guide", 0);
        Log.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = ".concat(String.valueOf(i)));
        if (i == 1)
        {
          com.tencent.mm.kernel.g.aAi();
          if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Oau, false))
          {
            paramBundle = getIntent();
            paramBundle.setClass(getContext(), SnsSettingIntroduceUI.class);
            paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramBundle.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            overridePendingTransition(0, 0);
            finish();
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oau, Boolean.TRUE);
          }
        }
        this.ELq.EGI = new bf.b()
        {
          public final void fix()
          {
            AppMethodBeat.i(203691);
            SnsTimeLineUI.J(SnsTimeLineUI.this);
            AppMethodBeat.o(203691);
          }
        };
        fiZ();
        com.tencent.f.h.RTc.aX(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203692);
            Log.i("MicroMsg.SnsTimeLineUI", "%s", new Object[] { com.tencent.mm.plugin.performance.watchdogs.c.eCH().S(true, 0) });
            AppMethodBeat.o(203692);
          }
        });
        this.EKR.a(c.b.class, this.EMg);
        localObject1 = this.EKS;
        i = this.EMi;
        paramBundle = getIntent();
        com.tencent.mm.plugin.sns.m.b localb = this.EKQ;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).EMi = i;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = true;
        Object localObject3;
        if (i == 0)
        {
          localObject3 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESM;
          ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject3).EKQ = localb;
          if (localb != null)
          {
            paramBundle = localb.flo();
            label1981:
            ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject3).EKR = paramBundle;
            ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESM.EKR.a(this);
            label1999:
            paramBundle = this.EKS;
            if (paramBundle.EMi != 0) {
              break label4141;
            }
            paramBundle = (com.tencent.mm.plugin.sns.m.c.a)paramBundle.ESM.EKR.y(com.tencent.mm.plugin.sns.m.c.a.class);
            label2028:
            this.mRa = paramBundle.mRa;
            this.ELj = paramBundle.ELj;
            this.ELk = paramBundle.ELk;
            this.EqY = paramBundle.EqY;
            this.ELl = paramBundle.ELl;
            localObject1 = paramBundle.krY;
            paramBundle = paramBundle.mSignature;
            this.mSessionId = com.tencent.mm.ui.e.avA("123");
            this.ELm = String.valueOf(System.currentTimeMillis());
            this.mUIAction = new SnsUIAction(this);
            this.mUIAction.setSessionId(this.mSessionId);
            this.mUIAction.DTT = this.ELm;
            this.mUIAction.EOI = this.EMe;
            this.mUIAction.actionbarView = this.mActionBar.getCustomView();
            ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().nS(2);
            com.tencent.mm.plugin.sns.ui.widget.f.fll().Fff = 0;
            com.tencent.mm.plugin.sns.ui.widget.d.fli().Fff = 0;
            localObject3 = com.tencent.mm.modelsns.l.jlw;
            com.tencent.mm.modelsns.l.bfL();
            if (!getIntent().getBooleanExtra("is_sns_notify_open", true)) {
              break label4149;
            }
            i = 1;
            label2216:
            this.EKZ = new i(this, i, Util.nullAs(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0), this.ELm);
            this.EKZ.EoI = new i.b()
            {
              public final void ffv()
              {
                AppMethodBeat.i(203693);
                com.tencent.mm.plugin.report.service.h.CyF.dN(1295, 2);
                Object localObject = com.tencent.mm.plugin.sns.model.aj.faZ();
                if (((aw)localObject).DNn) {
                  com.tencent.mm.plugin.sns.model.aj.eJP().post(new aw.4((aw)localObject));
                }
                com.tencent.mm.plugin.sns.k.e.DUQ.DVy.eTT = 1L;
                localObject = com.tencent.mm.plugin.sns.model.aj.faZ();
                int i;
                if ((!((aw)localObject).fbD()) || (((aw)localObject).DNy.get(((aw)localObject).DNK.tbl.peek()) == null))
                {
                  i = -1;
                  localObject = com.tencent.mm.plugin.sns.model.aj.faZ();
                  if (((aw)localObject).fbD()) {
                    break label390;
                  }
                }
                com.tencent.mm.hellhoundlib.b.a locala;
                label390:
                for (int j = 0;; j = ((aw)localObject).DNK.tbl.size())
                {
                  Log.d("MicroMsg.SnsTimeLineUI", "rightIndex:%s, targetSize:%s, adapter.count:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) });
                  com.tencent.mm.plugin.sns.model.aj.faZ().fj(null);
                  SnsTimeLineUI.K(SnsTimeLineUI.this).setVisibility(4);
                  if ((i == -1) || (j + i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount())) {
                    break label405;
                  }
                  com.tencent.mm.plugin.sns.model.aj.faZ().fbL();
                  com.tencent.mm.plugin.sns.model.aj.faZ().DNE = 0L;
                  j = SnsTimeLineUI.this.getResources().getDimensionPixelSize(2131166968);
                  int k = au.eu(SnsTimeLineUI.this.getContext());
                  int m = au.getStatusBarHeight(SnsTimeLineUI.this.getContext());
                  localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                  locala = com.tencent.mm.hellhoundlib.b.c.a(i + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), com.tencent.mm.hellhoundlib.b.c.a(k + m - j, new com.tencent.mm.hellhoundlib.b.a()));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                  ((ListView)localObject).smoothScrollToPositionFromTop(((Integer)locala.pG(0)).intValue(), ((Integer)locala.pG(1)).intValue());
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                  AppMethodBeat.o(203693);
                  return;
                  i = ((Integer)((aw)localObject).DNy.get(((aw)localObject).DNK.tbl.peek())).intValue();
                  break;
                }
                label405:
                if (!com.tencent.mm.plugin.sns.model.aj.faZ().DNH)
                {
                  com.tencent.mm.plugin.sns.model.aj.faZ().fbL();
                  com.tencent.mm.plugin.sns.model.aj.faZ().DNH = true;
                  SnsTimeLineUI.a(SnsTimeLineUI.this).ESq.aRj(r.Jc(SnsTimeLineUI.a(SnsTimeLineUI.this).fkc()));
                  SnsTimeLineUI.a(SnsTimeLineUI.this).ESq.aRk(r.Jc(SnsTimeLineUI.a(SnsTimeLineUI.this).vC(false)));
                  com.tencent.mm.plugin.sns.model.aj.faZ().DNE = com.tencent.mm.plugin.sns.model.aj.faZ().fbJ();
                  com.tencent.mm.plugin.sns.model.aj.faE().Jv(com.tencent.mm.plugin.sns.model.aj.faZ().fbJ());
                  com.tencent.mm.plugin.sns.model.aj.faZ().DNF = com.tencent.mm.plugin.sns.model.ax.DOd;
                  localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                  locala = com.tencent.mm.hellhoundlib.b.c.a(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount() - 1 + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), new com.tencent.mm.hellhoundlib.b.a());
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                  ((ListView)localObject).smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
                  com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                  if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
                  {
                    SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
                    SnsTimeLineUI.B(SnsTimeLineUI.this).post(SnsTimeLineUI.C(SnsTimeLineUI.this));
                  }
                }
                AppMethodBeat.o(203693);
              }
            };
            this.EoO = getIntent().getBooleanExtra("sns_resume_state", true);
            if (!com.tencent.mm.plugin.sns.model.aj.isInValid()) {
              break label4154;
            }
            this.EoO = false;
            label2301:
            this.EKX = this.EoO;
            this.mUIAction.a(this.ELj, this.mRa, (String)localObject1, paramBundle, this.ELk, this.EqY, this.ELl);
            this.mUIAction.onCreate();
            com.tencent.mm.plugin.sns.model.aj.faF().init();
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(213, this);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(682, this);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(218, this);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(211, this);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(683, this);
            com.tencent.mm.plugin.sns.ui.video.d.fkS().fkT();
            initView();
            paramBundle = com.tencent.mm.plugin.sns.model.aj.faF();
            localObject1 = this.mUIAction.list;
            localObject3 = this.EKT.ESp;
            paramBundle.DQW = ((ListView)localObject1);
            paramBundle.DQX = ((bk)localObject3);
            paramBundle = com.tencent.mm.plugin.sns.model.aj.faF();
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(291, paramBundle);
            if (!com.tencent.mm.plugin.sns.model.aj.isInValid()) {
              break label4174;
            }
            this.EoO = false;
            label2513:
            paramBundle = this.EKR;
            paramBundle.ESq = this.EKT.ESq;
            localObject1 = paramBundle.ESq;
            paramBundle.QYN.keep((com.tencent.mm.vending.e.a)localObject1);
            if ((!this.EoO) || (this.EMi != 0)) {
              break label4194;
            }
            this.EKY = false;
            int j = com.tencent.mm.plugin.sns.model.aj.faY().position;
            this.EKT.ESq.aRl(com.tencent.mm.plugin.sns.model.aj.faY().sNG);
            this.EKT.ESq.aRi(com.tencent.mm.plugin.sns.model.aj.faY().EvF);
            this.EKT.ESq.vD(true);
            this.EKT.ESq.aRm(com.tencent.mm.plugin.sns.model.aj.faY().EvI);
            this.EKT.ESq.aRj(com.tencent.mm.plugin.sns.model.aj.faY().EvG);
            this.EKT.ESq.aRk(com.tencent.mm.plugin.sns.model.aj.faY().EvH);
            this.mUIAction.vz(com.tencent.mm.plugin.sns.model.aj.faY().EvK);
            this.EKT.vC();
            i = j;
            if (j >= this.EKT.getCount())
            {
              i = this.EKT.getCount() - 1;
              Log.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[] { Integer.valueOf(this.EKT.getCount()) });
            }
            this.mUIAction.list.setAdapter(this.EKT);
            Log.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[] { Integer.valueOf(com.tencent.mm.plugin.sns.model.aj.faY().EvJ) });
            this.mUIAction.list.setSelectionFromTop(i, com.tencent.mm.plugin.sns.model.aj.faY().EvJ);
            ZR(4);
            label2791:
            fiY();
            i = this.EKT.getCount();
            j = this.mUIAction.list.getFirstVisiblePosition();
            if (j < i) {
              this.ELf = r.v(this.EKT.Zv(j));
            }
            com.tencent.mm.kernel.g.aAi();
            this.ELd = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(327776, Integer.valueOf(0))).intValue();
            this.EKZ.EoQ = new bs(this, this.EKT.ESp, this.EKZ.DQt);
            this.EKZ.EoS = new com.tencent.mm.plugin.sns.h.b(this, this.EKT.ESp.DQs, this.EKZ.DQt);
            this.EKZ.EoR = new b(this, this.EKT.ESp.DQs, this.EKZ.DQt, this.EKZ.EoS);
            this.EKZ.EoR.DzW = this.EBv;
            this.EKZ.EoT = new ap(this, this.EKT.ESp.DQs, this.EKZ.DQt);
            this.EKZ.EoU = new bu(this, this.EKT.ESp.DQs, this.EKZ.DQt);
            if (this.ELi != null) {
              this.ELi.a(this.EKZ.EoS);
            }
            if (i > 0)
            {
              paramBundle = this.EKT.Zv(0);
              if ((this.EKZ.EoF != null) && (this.EKZ.EoF.DMa != null)) {
                this.EKZ.EoF.DMa.DSD = paramBundle.field_snsId;
              }
              paramBundle = com.tencent.mm.plugin.sns.k.e.DUQ;
              if (paramBundle.hmp != 0)
              {
                if (paramBundle.DUR.isEmpty())
                {
                  paramBundle.gmR.setLong(2, Util.nowSecond());
                  paramBundle.DUS.clear();
                }
                Log.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[] { Integer.valueOf(paramBundle.DUR.size()) });
              }
            }
            com.tencent.mm.plugin.report.service.h.CyF.kvStat(13312, "1," + Util.nowMilliSecond());
            EventCenter.instance.addListener(this.ELD);
            if (getIntent().getBooleanExtra("is_need_resend_sns", false))
            {
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(99317);
                  com.tencent.mm.ui.base.h.c(SnsTimeLineUI.this, SnsTimeLineUI.this.getString(2131763672), "", SnsTimeLineUI.this.getString(2131763673), SnsTimeLineUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(99307);
                      paramAnonymous2DialogInterface = new sk();
                      EventCenter.instance.publish(paramAnonymous2DialogInterface);
                      AppMethodBeat.o(99307);
                    }
                  }, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(99308);
                      paramAnonymous2DialogInterface = new oi();
                      EventCenter.instance.publish(paramAnonymous2DialogInterface);
                      AppMethodBeat.o(99308);
                    }
                  });
                  AppMethodBeat.o(99317);
                }
              }, 500L);
              getIntent().putExtra("is_need_resend_sns", false);
            }
            com.tencent.mm.kernel.g.aAi();
            if (com.tencent.mm.kernel.g.aAf().azp())
            {
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAh().azQ().set(589825, Boolean.FALSE);
            }
            this.EKZ.b(this.EBv);
            this.EBv.a(this.mUIAction.DuA, this.mActionBar.getCustomView(), this);
            EventCenter.instance.addListener(this.ELJ);
            EventCenter.instance.addListener(this.ELK);
            EventCenter.instance.addListener(this.ELL);
            EventCenter.instance.addListener(this.ELM);
            EventCenter.instance.addListener(this.ELN);
            EventCenter.instance.addListener(this.ELP);
            EventCenter.instance.addListener(this.ELO);
            EventCenter.instance.addListener(this.DMM);
            EventCenter.instance.addListener(this.ELQ);
            EventCenter.instance.addListener(this.ELR);
            EventCenter.instance.addListener(this.ELT);
            EventCenter.instance.addListener(this.ELS);
            EventCenter.instance.addListener(this.ELU);
            EventCenter.instance.addListener(this.ELW);
            com.tencent.mm.plugin.sns.abtest.c.eWz();
            com.tencent.mm.plugin.sns.abtest.a.d(this, this.EKZ.DQt);
            if (this.ELg != null)
            {
              paramBundle = this.ELg;
              localObject1 = this.mUIAction.list;
              localObject3 = this.mUIAction.DSh;
              paramBundle.hUI = ((ListView)localObject1);
              paramBundle.DSh = ((SnsHeader)localObject3);
            }
            if ((this.EKZ != null) && (this.EKZ.EoF != null))
            {
              paramBundle = this.EKZ.EoF.DMa;
              Log.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
              paramBundle.DSC = true;
              paramBundle.DUA = System.currentTimeMillis();
            }
            bool = getIntent().getBooleanExtra("enter_by_red", false);
            if ((this.EKZ != null) && (this.EKZ.EoF != null))
            {
              paramBundle = this.EKZ.EoF.DMa;
              if (!bool) {
                break label4223;
              }
              i = 1;
              label3632:
              paramBundle.DSP = i;
            }
            com.tencent.mm.plugin.sns.model.aj.faL().DHe.clear();
            if ((this.mUIAction != null) && (this.mUIAction.DSh != null)) {
              this.mUIAction.DSh.setStoryAction(new SnsStoryHeaderView.a()
              {
                public final void fjo()
                {
                  AppMethodBeat.i(203695);
                  SnsTimeLineUI.a locala = SnsTimeLineUI.l(SnsTimeLineUI.this);
                  if (SnsTimeLineUI.u(locala.EMn).getVisibility() == 0)
                  {
                    locala.init();
                    SnsTimeLineUI.u(locala.EMn).clearAnimation();
                    SnsTimeLineUI.u(locala.EMn).startAnimation(locala);
                    locala.JT(locala.AGw + 100);
                    locala.EMT = false;
                  }
                  AppMethodBeat.o(203695);
                }
              });
            }
            if (!Util.isNullOrNil(com.tencent.mm.model.z.aUg())) {
              break label4228;
            }
            this.ELx = 0;
            label3695:
            if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED)) {
              break label4261;
            }
            paramBundle = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.skb, "{\"enable\":2,\"max_count_no_user\":0,\"max_count_no_feed\":0,\"max_count_normal\":0}");
            if (Util.isNullOrNil(paramBundle)) {}
          }
        }
        try
        {
          paramBundle = new JSONObject(paramBundle);
          this.ELt = paramBundle.getInt("enable");
          this.ELu = paramBundle.getInt("max_count_no_user");
          this.ELv = paramBundle.getInt("max_count_no_feed");
          this.ELw = paramBundle.getInt("max_count_normal");
          if (ac.jPK > 0)
          {
            this.ELt = ac.jPK;
            if (ac.jPK == 1)
            {
              this.ELu = -1;
              this.ELv = -1;
              this.ELw = -1;
            }
          }
          Log.i("MicroMsg.SnsTimeLineUI", "curFinderStatus:%s, finderEntranceEnable:%s, finderEntranceMaxCountNoUser:%s, finderEntranceMaxCountNoFeed:%s, finderEntranceMaxCountNormal:%s", new Object[] { Integer.valueOf(this.ELx), Integer.valueOf(this.ELt), Integer.valueOf(this.ELu), Integer.valueOf(this.ELv), Integer.valueOf(this.ELw) });
          ah.fas();
          EventCenter.instance.addListener(this.ELE);
          paramBundle = com.tencent.mm.plugin.sns.i.a.DRI;
          com.tencent.mm.plugin.sns.i.a.a.gZ(this);
          AppMethodBeat.o(99379);
          return;
          label3921:
          paramBundle = com.tencent.mm.ui.statusbar.c.bt(this);
          localObject1 = new com.tencent.mm.ui.statusbar.c.a()
          {
            public final void yf(int paramAnonymousInt)
            {
              AppMethodBeat.i(203675);
              SnsTimeLineUI.t(SnsTimeLineUI.this).setPadding(0, paramAnonymousInt, 0, 0);
              AppMethodBeat.o(203675);
            }
          };
          this.BdS = ((com.tencent.mm.ui.statusbar.c.a)localObject1);
          paramBundle.a((com.tencent.mm.ui.statusbar.c.a)localObject1);
          getWindow().getDecorView().requestApplyInsets();
          com.tencent.mm.ui.statusbar.d.e(getWindow());
          break;
          paramBundle = null;
          break label1981;
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESN = new com.tencent.mm.plugin.sns.m.c.a();
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESN.mRa = paramBundle.getStringExtra("sns_userName");
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESN.ELj = com.tencent.mm.model.z.aTY();
          localObject3 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESN;
          com.tencent.mm.kernel.g.aAi();
          ((com.tencent.mm.plugin.sns.m.c.a)localObject3).ELk = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjG(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESN.mRa);
          localObject3 = com.tencent.mm.model.z.aTY();
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESN.EqY = ((String)localObject3).equals(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESN.mRa);
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESN.ELl = paramBundle.getIntExtra("sns_source", 0);
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESN.krY = Util.nullAs(paramBundle.getStringExtra("sns_nickName"), "");
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESN.mSignature = Util.nullAs(paramBundle.getStringExtra("sns_signature"), "");
          break label1999;
          label4141:
          paramBundle = paramBundle.ESN;
          break label2028;
          label4149:
          i = 0;
          break label2216;
          label4154:
          if (!this.EoO) {
            break label2301;
          }
          this.EoO = com.tencent.mm.plugin.sns.model.aj.faY().fgK();
          break label2301;
          label4174:
          if (!this.EoO) {
            break label2513;
          }
          this.EoO = com.tencent.mm.plugin.sns.model.aj.faY().fgK();
          break label2513;
          label4194:
          this.mUIAction.list.setAdapter(this.EKT);
          ZR(0);
          this.EKT.vC();
          break label2791;
          label4223:
          i = 0;
          break label3632;
          label4228:
          if (!((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).hasFinderPosted())
          {
            this.ELx = 1;
            break label3695;
          }
          this.ELx = 2;
          break label3695;
          label4261:
          paramBundle = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.skb, "");
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            Log.w("MicroMsg.SnsTimeLineUI", "parse SnsFinderEntranceConfig fail. %s", new Object[] { paramBundle.getMessage() });
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99383);
    this.ELe = true;
    Object localObject1 = this.ELq;
    ((bf)localObject1).dMu();
    ((bf)localObject1).EGI = null;
    ((bf)localObject1).CTg = bf.a.EGK;
    com.tencent.mm.plugin.sns.ui.video.d.fkS().aN(this);
    localObject1 = com.tencent.mm.plugin.sns.ui.video.b.fkM();
    Log.i("MicroMsg.SightPlayViewManager", "onUIDestroy");
    Object localObject2 = ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).FcW.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((com.tencent.mm.plugin.sns.ui.video.a)((Iterator)localObject2).next()).stop();
    }
    ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).FcW.clear();
    Log.i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
    EventCenter.instance.removeListener(this.ELJ);
    EventCenter.instance.removeListener(this.ELK);
    EventCenter.instance.removeListener(this.ELL);
    EventCenter.instance.removeListener(this.ELM);
    EventCenter.instance.removeListener(this.ELN);
    EventCenter.instance.removeListener(this.ELP);
    EventCenter.instance.removeListener(this.ELO);
    EventCenter.instance.removeListener(this.DMM);
    EventCenter.instance.removeListener(this.ELQ);
    EventCenter.instance.removeListener(this.ELR);
    EventCenter.instance.removeListener(this.ELS);
    EventCenter.instance.removeListener(this.ELT);
    EventCenter.instance.removeListener(this.ELU);
    EventCenter.instance.removeListener(this.ELE);
    EventCenter.instance.removeListener(this.ELW);
    com.tencent.mm.plugin.sns.ui.e.a.fkK();
    int i;
    long l1;
    Object localObject3;
    Object localObject4;
    int j;
    label464:
    String str2;
    if ((this.EKZ != null) && (this.EKZ.EoF != null))
    {
      localObject1 = this.EKZ.EoF.DMa;
      if (this.ELG)
      {
        i = 1;
        ((com.tencent.mm.plugin.sns.k.b)localObject1).DSQ = i;
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.sns.k.e.DUQ;
      if (((com.tencent.mm.plugin.sns.k.e)localObject2).hmp == 0) {
        break label792;
      }
      Log.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sns.k.e)localObject2).DUR.size()), Integer.valueOf(((com.tencent.mm.plugin.sns.k.e)localObject2).DUS.size()) });
      l1 = ((com.tencent.mm.plugin.sns.k.e)localObject2).gmR.getLong(2, 0L);
      if ((((com.tencent.mm.plugin.sns.k.e)localObject2).DUR.isEmpty()) || ((((com.tencent.mm.plugin.sns.k.e)localObject2).DUR.size() <= ((com.tencent.mm.plugin.sns.k.e)localObject2).DUY) && (Util.secondsToNow(l1) <= ((com.tencent.mm.plugin.sns.k.e)localObject2).DUZ))) {
        break label1748;
      }
      localObject3 = new StringBuffer();
      localObject4 = ((com.tencent.mm.plugin.sns.k.e)localObject2).DUR.keySet().iterator();
      i = 0;
      j = 0;
      if (!((Iterator)localObject4).hasNext()) {
        break label618;
      }
      str2 = (String)((Iterator)localObject4).next();
      localObject1 = (String)((com.tencent.mm.plugin.sns.k.e)localObject2).DUS.get(str2);
      if (Util.isNullOrNil((String)localObject1)) {
        break label605;
      }
      j = 1;
      label511:
      if (!((com.tencent.mm.plugin.sns.k.e)localObject2).DUT.contains(str2)) {
        break label613;
      }
    }
    label605:
    label613:
    for (int k = 1;; k = 0)
    {
      ((StringBuffer)localObject3).append(str2 + "#" + ((com.tencent.mm.plugin.sns.k.e)localObject2).DUR.get(str2) + "#" + (String)localObject1 + "#" + k + "|");
      i += 1;
      break label464;
      i = 0;
      break;
      localObject1 = "";
      break label511;
    }
    label618:
    ((StringBuffer)localObject3).append("," + l1 + "," + Util.nowSecond() + ",1," + j + "," + i + ",1");
    Log.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", new Object[] { Integer.valueOf(13226), localObject3 });
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(13226, ((StringBuffer)localObject3).toString());
    ((com.tencent.mm.plugin.sns.k.e)localObject2).gmR.set(3, null);
    ((com.tencent.mm.plugin.sns.k.e)localObject2).gmR.set(4, null);
    ((com.tencent.mm.plugin.sns.k.e)localObject2).gmR.set(5, null);
    ((com.tencent.mm.plugin.sns.k.e)localObject2).DUR.clear();
    ((com.tencent.mm.plugin.sns.k.e)localObject2).DUS.clear();
    ((com.tencent.mm.plugin.sns.k.e)localObject2).DUT.clear();
    ((com.tencent.mm.plugin.sns.k.e)localObject2).gmR.setLong(2, Util.nowSecond());
    for (;;)
    {
      ((com.tencent.mm.plugin.sns.k.e)localObject2).fcu();
      label792:
      com.tencent.mm.kernel.g.aAi();
      localObject1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(68377, null);
      if ((this.EKZ != null) && (this.EKZ.EoF != null))
      {
        localObject2 = this.EKZ.EoF.DMa;
        i = com.tencent.mm.plugin.sns.k.e.DUQ.DUX;
        Log.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
        l1 = System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.k.b)localObject2).DUA;
        ((com.tencent.mm.plugin.sns.k.b)localObject2).DSE += l1;
        Log.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + l1 + " BrowseTime: " + ((com.tencent.mm.plugin.sns.k.b)localObject2).DSE + "BackgroundTime: " + ((com.tencent.mm.plugin.sns.k.b)localObject2).DTn);
        localObject3 = com.tencent.mm.plugin.sns.model.aj.faB();
        if (localObject3 != null) {
          ((ExecutorService)localObject3).execute(new b.2((com.tencent.mm.plugin.sns.k.b)localObject2, i));
        }
        ((com.tencent.mm.plugin.sns.k.b)localObject2).DSC = false;
      }
      localObject2 = com.tencent.mm.modelsns.k.tO(704);
      boolean bool;
      if (((com.tencent.mm.modelsns.k)localObject2).bfG())
      {
        ((com.tencent.mm.modelsns.k)localObject2).fL(this.ELG);
        if (!Util.isNullOrNil((String)localObject1))
        {
          bool = true;
          ((com.tencent.mm.modelsns.k)localObject2).fL(bool);
          ((com.tencent.mm.modelsns.k)localObject2).PH(this.ELf);
          ((com.tencent.mm.modelsns.k)localObject2).PH(com.tencent.mm.plugin.sns.k.e.DUQ.DUW);
          ((com.tencent.mm.modelsns.k)localObject2).PH(com.tencent.mm.plugin.sns.k.e.DUQ.DUW);
          ((com.tencent.mm.modelsns.k)localObject2).tR(this.mUIAction.EOH);
          ((com.tencent.mm.modelsns.k)localObject2).PH("");
          com.tencent.mm.modelsns.k.bfJ();
          ((com.tencent.mm.modelsns.k)localObject2).bfK();
        }
      }
      else
      {
        com.tencent.mm.plugin.sns.k.e.DUQ.DUX = -1;
        com.tencent.mm.plugin.sns.k.e.DUQ.DUW = "0";
        localObject1 = (AdListView)this.mUIAction.getSnsListView();
        this.ELi.DOu.clear();
        com.tencent.mm.plugin.sns.model.aj.faF().clean();
        localObject2 = com.tencent.mm.plugin.sns.model.aj.faI();
        com.tencent.mm.plugin.sns.model.aj.faB().execute(new m.5((com.tencent.mm.plugin.sns.ad.g.m)localObject2));
        ((AdListView)localObject1).Enb.clear();
        ((AdListView)localObject1).Enb = null;
        ((AdListView)localObject1).Enc.fac();
        ((AdListView)localObject1).Enc = null;
        com.tencent.mm.plugin.sns.model.v.fah();
        if (!com.tencent.mm.plugin.sns.model.aj.isInValid()) {
          this.EMc.removeCallbacks(this.ELC);
        }
        com.tencent.mm.kernel.g.aAi();
        if (com.tencent.mm.kernel.g.aAf().azp())
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.b(213, this);
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.b(682, this);
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.b(218, this);
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.b(211, this);
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.b(683, this);
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(327776, Integer.valueOf(this.ELd));
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(589825, Boolean.FALSE);
        }
        if (this.EKZ != null) {
          this.EKZ.clean();
        }
        com.tencent.mm.plugin.sns.model.aj.dRd().removeCallbacks(this.EMd);
        localObject1 = com.tencent.mm.plugin.sns.model.aj.faZ();
        if (((aw)localObject1).DNP != null) {
          ((aw)localObject1).fbM();
        }
        if (!((aw)localObject1).DNn) {}
      }
      try
      {
        ((aw)localObject1).DNJ.DNN = ((aw)localObject1).DNN;
        localObject2 = ((aw)localObject1).DNJ.toByteArray();
        com.tencent.mm.vfs.s.f(((aw)localObject1).DNm, (byte[])localObject2, localObject2.length);
        ((aw)localObject1).DNJ.DRY.clear();
        ((aw)localObject1).DNK = null;
        ((aw)localObject1).DNL = 0L;
        ((aw)localObject1).DNE = 0L;
        ((aw)localObject1).DNy.clear();
        ((aw)localObject1).DNz = null;
        ((aw)localObject1).DND = 0L;
        ((aw)localObject1).DNA = 0L;
        ((aw)localObject1).DNG = false;
        ((aw)localObject1).DNP = null;
        ((aw)localObject1).DNQ = null;
        ((aw)localObject1).DNF = com.tencent.mm.plugin.sns.model.ax.DOf;
        ((aw)localObject1).DNR = 0;
        ((aw)localObject1).DNO = 0L;
        ((aw)localObject1).DNN = 0L;
        ((aw)localObject1).DNS = 0L;
        ((aw)localObject1).DNB.clear();
        localObject1 = ((aw)localObject1).DNT;
        ((av)localObject1).DNj.clear();
        ((av)localObject1).DNk = null;
        com.tencent.mm.kernel.g.aAg().hqi.b(211, (com.tencent.mm.ak.i)localObject1);
        localObject1 = com.tencent.mm.plugin.sns.model.aj.fba();
        Log.i(com.tencent.mm.plugin.sns.model.at.TAG, "destroy");
        MMHandlerThread.removeRunnable(((com.tencent.mm.plugin.sns.model.at)localObject1).DMZ);
        if (this.EKT == null) {
          break label2249;
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
                Log.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", new Object[] { Integer.valueOf(n), Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
                k = localObject2[1];
              }
            }
            j += 1;
            i = k;
            continue;
            label1748:
            ((com.tencent.mm.plugin.sns.k.e)localObject2).gmR.set(3, ((com.tencent.mm.plugin.sns.k.e)localObject2).DUR);
            ((com.tencent.mm.plugin.sns.k.e)localObject2).gmR.set(4, ((com.tencent.mm.plugin.sns.k.e)localObject2).DUS);
            ((com.tencent.mm.plugin.sns.k.e)localObject2).gmR.set(5, ((com.tencent.mm.plugin.sns.k.e)localObject2).DUT);
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
          Log.w("MicroMsg.SnsUnreadTipManager", "flushUnreadTipFaultWriteCache error:%s", new Object[] { localException.getMessage() });
        }
        j = getResources().getDimensionPixelSize(2131166968);
        if ((!com.tencent.mm.plugin.sns.model.aj.isInValid()) && (this.EKR.faE() != null) && (this.EMi == 0))
        {
          localObject1 = com.tencent.mm.plugin.sns.model.aj.faY();
          String str1 = this.EKT.ESq.fkf();
          localObject3 = this.EKT.ESq.fkh();
          l1 = this.EKR.faE().DMw;
          localObject4 = this.EKT.ESq.fkd();
          str2 = this.EKT.ESq.fke();
          long l2 = this.EKR.faE().DMx;
          String str3 = this.EKT.ESq.fkg();
          bool = this.mUIAction.EvK;
          ((as)localObject1).EvE = Util.currentTicks();
          ((as)localObject1).sNG = str1;
          ((as)localObject1).EvF = ((String)localObject3);
          ((as)localObject1).DMw = l1;
          ((as)localObject1).position = m;
          ((as)localObject1).EvJ = (i - j);
          ((as)localObject1).EvI = str3;
          ((as)localObject1).EvG = ((String)localObject4);
          ((as)localObject1).EvH = str2;
          ((as)localObject1).DMx = l2;
          ((as)localObject1).EvK = bool;
          Log.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(((as)localObject1).EvE), str1, localObject3, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(((as)localObject1).EvJ), localObject4, str2, Long.valueOf(l2), str3, Boolean.valueOf(bool) });
        }
        Log.d("MicroMsg.SnsTimeLineUI", "top h %d", new Object[] { Integer.valueOf(i - j) });
        localObject1 = this.EKT.ESp;
        EventCenter.instance.removeListener(((bk)localObject1).lEl);
        if (!com.tencent.mm.plugin.sns.model.aj.isInValid()) {
          break label2572;
        }
      }
    }
    Log.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
    for (;;)
    {
      localObject1 = this.EKT.ESp;
      if (((bk)localObject1).EBk != null) {
        ((bk)localObject1).EBk.activity = null;
      }
      this.EKT.ESp.fiP();
      this.EKT.ESp.fiU();
      this.EKT.ESp.fiQ();
      label2249:
      bm.clean();
      EventCenter.instance.removeListener(this.ELD);
      com.tencent.mm.kernel.g.aAi();
      if (com.tencent.mm.kernel.g.aAf().azp()) {
        com.tencent.mm.plugin.sns.model.aj.faL().DHe.clear();
      }
      this.EKT.ESq.removeVendingDataChangedCallback(this.ELF);
      this.ELF = null;
      com.tencent.mm.plugin.sns.k.e.DUQ.YQ(this.EKT.getCount());
      this.EKT = null;
      this.EKZ = null;
      com.tencent.mm.plugin.sns.ui.a.c.fkb();
      com.tencent.mm.plugin.sns.abtest.c.eWA();
      localObject1 = com.tencent.mm.plugin.sns.model.aj.faF();
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.b(291, (com.tencent.mm.ak.i)localObject1);
      com.tencent.mm.plugin.sns.abtest.a.clean();
      this.mUIAction.onDestroy();
      super.onDestroy();
      com.tencent.mm.kiss.widget.textview.c.hue.aBj();
      localObject1 = this.EKS;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).ESN = null;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = false;
      com.tencent.mm.plugin.sns.ad.g.n.Dwr.Dwq.clear();
      Log.i("MicroMsg.SnsTimelineAdResourceMgr", "clean cache", new Object[] { Util.getStack() });
      localObject1 = com.tencent.mm.plugin.sns.model.aj.faJ();
      if (!((com.tencent.mm.plugin.sns.model.c)localObject1).DGP.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.c)localObject1).DGP.clear();
      }
      localObject1 = com.tencent.mm.plugin.sns.model.aj.faJ();
      if (!((com.tencent.mm.plugin.sns.model.c)localObject1).DGQ.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.c)localObject1).DGQ.clear();
      }
      com.tencent.mm.plugin.sns.model.aj.faZ().DNH = false;
      localObject1 = com.tencent.mm.plugin.sns.k.e.DUQ;
      ((com.tencent.mm.plugin.sns.k.e)localObject1).DVc.clear();
      ((com.tencent.mm.plugin.sns.k.e)localObject1).DVd.clear();
      if (com.tencent.mm.plugin.sns.k.e.DUQ.DVz.eUc > 0L)
      {
        localObject1 = com.tencent.mm.plugin.sns.k.e.DUQ;
        ((com.tencent.mm.plugin.sns.k.e)localObject1).DVz.enl = 1L;
        ((com.tencent.mm.plugin.sns.k.e)localObject1).DVz.bfK();
        ((com.tencent.mm.plugin.sns.k.e)localObject1).DVz = new ke();
      }
      localObject1 = com.tencent.mm.plugin.sns.storage.d.Emh;
      com.tencent.mm.plugin.sns.storage.d.bkj().removeMessages(com.tencent.mm.plugin.sns.storage.d.Emg);
      AppMethodBeat.o(99383);
      return;
      label2572:
      com.tencent.mm.plugin.sns.model.aj.faL();
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
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179271);
        SnsTimeLineUI.this.ffL();
        AppMethodBeat.o(179271);
      }
    });
    if (keyboardState() == 2)
    {
      if ((this.EKZ != null) && (this.EKZ.EoJ != null) && (!this.EKZ.EoJ.fhW()))
      {
        Log.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
        AppMethodBeat.o(99389);
      }
    }
    else if ((keyboardState() == 1) && (this.EKZ != null)) {
      this.EKZ.ffq();
    }
    AppMethodBeat.o(99389);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(203733);
    super.onNewIntent(paramIntent);
    paramIntent = paramIntent.getBundleExtra("key_finder_bundle_info");
    if (paramIntent != null)
    {
      Intent localIntent = new Intent();
      String str = paramIntent.getString("key_context_id");
      long l = paramIntent.getLong("key_finder_post_local_id");
      localIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", true);
      localIntent.putExtra("key_finder_post_local_id", l);
      localIntent.putExtra("KEY_POST_DIRECTLY_FROM_SNS", true);
      if (!Util.isNullOrNil(str)) {
        localIntent.putExtra("key_context_id", str);
      }
      ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderTimelineUI(getContext(), localIntent);
      finish();
    }
    AppMethodBeat.o(203733);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99387);
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.ExJ = false;
      this.EKW.clearAnimation();
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, this.gsi);
      this.gsi = 0;
      com.tencent.mm.plugin.sns.model.v.b(this);
      com.tencent.mm.plugin.sns.model.aj.faL().DHg = null;
      if (this.EKT != null) {
        this.EKT.ESp.onPause();
      }
      if ((this.EKZ != null) && (this.EKZ.EoE != null)) {
        this.EKZ.EoE.onPause();
      }
      if ((this.EKZ != null) && (this.EKZ.EoF != null)) {
        this.EKZ.EoF.DMa.uP(false);
      }
      com.tencent.mm.modelstat.d.m("SnsTimeLineUI", this.zdW, Util.nowSecond());
      this.mUIAction.onPause();
      super.onPause();
      com.tencent.mm.plugin.sns.ui.video.d.fkS().onUIPause();
      Object localObject = com.tencent.mm.plugin.sns.ui.video.b.fkM();
      Log.i("MicroMsg.SightPlayViewManager", "onUIPause");
      localObject = ((com.tencent.mm.plugin.sns.ui.video.b)localObject).FcW.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.sns.ui.video.a)((Iterator)localObject).next()).onUIPause();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
      }
      EventCenter.instance.removeListener(this.ELI);
      EventCenter.instance.removeListener(this.ELH);
      EventCenter.instance.removeListener(this.ELV);
      if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) != null))
      {
        com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF;
        if (localc != null) {
          this.hlB = Math.max(0L, localc.dcx - this.hlB);
        }
      }
      if (Util.nowSecond() <= this.iTC) {}
    }
    for (long l = Util.nowSecond() - this.iTC;; l = 1L)
    {
      this.iTC = l;
      WXHardCoderJNI.reportFPS(701, WXHardCoderJNI.hcSNSScrollAction, 1, this.hlB, this.iTC);
      this.hlB = 0L;
      this.iTC = 0L;
      if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class) != null) {
        ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.a.class)).d(101, false, false);
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
      Log.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(99403);
      return;
    }
    Log.i("MicroMsg.SnsTimeLineUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99403);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        fje();
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131763864;; paramInt = 2131763876)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131763890), getString(2131762043), getString(2131755761), false, new SnsTimeLineUI.72(this), new SnsTimeLineUI.73(this));
        }
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        fjd();
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131763864;; paramInt = 2131763876)
      {
        com.tencent.mm.ui.base.h.a(getContext(), getString(paramInt), getString(2131763890), getString(2131762043), getString(2131755761), false, new SnsTimeLineUI.74(this), new SnsTimeLineUI.75(this));
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        fjd();
        AppMethodBeat.o(99403);
        return;
      }
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131763874), getString(2131763890), getString(2131762043), getString(2131755761), false, new SnsTimeLineUI.76(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99384);
    com.tencent.mm.plugin.sns.model.aj.faZ().DNF = com.tencent.mm.plugin.sns.model.ax.DOf;
    this.ELq.CTg = bf.fiw();
    this.iTC = Util.nowSecond();
    Object localObject1;
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) != null))
    {
      localObject1 = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF;
      if (localObject1 != null) {
        this.hlB = ((com.tencent.matrix.trace.f.c)localObject1).dcx;
      }
    }
    try
    {
      if (!this.ExJ)
      {
        Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onResume callback");
        ScreenShotUtil.setScreenShotCallback(this, this.EyL);
        this.ExJ = true;
      }
      if ((CrashReportFactory.hasDebuger()) && (CrashReportFactory.isMonkeyEnv())) {
        sUILeaksRoutineEnsuranceRef.add(this);
      }
      this.mUIAction.onResume();
      super.onResume();
      fiZ();
      if (this.autoPlay) {
        fiY();
      }
      this.zdW = Util.nowSecond();
      int i;
      if (this.EMh)
      {
        this.EMh = false;
        i = this.EKT.getCount();
        if (getIntent().getBooleanExtra("is_from_find_more", false))
        {
          localObject3 = com.tencent.mm.modelsns.k.c(getIntent(), "enter_log");
          if (localObject3 != null)
          {
            if (i <= 0) {
              break label704;
            }
            localSnsInfo = this.EKT.Zv(0);
            if (localSnsInfo != null) {
              break label670;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.k)localObject3).PH((String)localObject1);
            if (localSnsInfo != null) {
              break label682;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.k)localObject3).PH((String)localObject1);
            ((com.tencent.mm.modelsns.k)localObject3).PH(String.valueOf(i));
            ((com.tencent.mm.modelsns.k)localObject3).bfK();
          }
        }
      }
      if (this.mScreenWidth == 0)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
        this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
        localObject1 = this.ELg;
        i = this.mScreenWidth;
        int j = this.mScreenHeight;
        ((com.tencent.mm.plugin.sns.k.a)localObject1).mScreenWidth = i;
        ((com.tencent.mm.plugin.sns.k.a)localObject1).mScreenHeight = j;
      }
      if (com.tencent.mm.plugin.sns.model.aj.isInValid()) {
        finish();
      }
      com.tencent.mm.plugin.sns.model.aj.faL().DHg = this.EKT.ESp;
      aBf().bk(c.b.class);
      com.tencent.mm.plugin.sns.model.v.a(this);
      if (this.EKY)
      {
        this.EKW.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99328);
            Log.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.N(SnsTimeLineUI.this));
            if (SnsTimeLineUI.N(SnsTimeLineUI.this))
            {
              SnsTimeLineUI.m(SnsTimeLineUI.this);
              SnsTimeLineUI.l(SnsTimeLineUI.this).fjs();
            }
            AppMethodBeat.o(99328);
          }
        });
        if ((this.EKZ != null) && (this.EKZ.EoE != null)) {
          this.EKZ.EoE.onResume();
        }
        if (this.EKT != null) {
          this.EKT.ESp.onResume();
        }
        if ((this.EKZ != null) && (this.EKZ.EoF != null))
        {
          this.EKZ.EoF.DMa.uP(true);
          this.EKZ.EoF.DMa.uQ(false);
          this.EKZ.EoF.DMa.uR(false);
          this.EKZ.EoF.DMa.uS(false);
          this.EKZ.EoF.DMa.vc(false);
          localObject1 = this.EKZ.EoF.DMa;
          ((com.tencent.mm.plugin.sns.k.b)localObject1).va(false);
          ((com.tencent.mm.plugin.sns.k.b)localObject1).vb(false);
          ((com.tencent.mm.plugin.sns.k.b)localObject1).uU(false);
          ((com.tencent.mm.plugin.sns.k.b)localObject1).uZ(false);
          ((com.tencent.mm.plugin.sns.k.b)localObject1).uX(false);
          ((com.tencent.mm.plugin.sns.k.b)localObject1).uZ(false);
          ((com.tencent.mm.plugin.sns.k.b)localObject1).vd(false);
          ((com.tencent.mm.plugin.sns.k.b)localObject1).uY(false);
          ((com.tencent.mm.plugin.sns.k.b)localObject1).uZ(false);
          ((com.tencent.mm.plugin.sns.k.b)localObject1).uV(false);
          ((com.tencent.mm.plugin.sns.k.b)localObject1).uW(false);
        }
        localObject1 = com.tencent.mm.plugin.sns.model.aj.faL();
        ((com.tencent.mm.plugin.sns.model.g)localObject1).DHh = 0L;
        ((com.tencent.mm.plugin.sns.model.g)localObject1).DHi = 0L;
        EventCenter.instance.addListener(this.ELI);
        EventCenter.instance.addListener(this.ELH);
        EventCenter.instance.addListener(this.ELV);
        AppMethodBeat.o(99384);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject3;
        SnsInfo localSnsInfo;
        Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
        continue;
        label670:
        Object localObject2 = r.Jb(localSnsInfo.field_snsId);
        continue;
        label682:
        localObject2 = localSnsInfo.field_createTime;
        continue;
        label704:
        ((com.tencent.mm.modelsns.k)localObject3).PH("");
        ((com.tencent.mm.modelsns.k)localObject3).PH("");
        ((com.tencent.mm.modelsns.k)localObject3).PH("0");
        continue;
        localObject2 = this.ELb;
        if (((a)localObject2).EMn.EKW.getVisibility() == 0)
        {
          ((a)localObject2).init();
          localObject3 = (AbsoluteLayout.LayoutParams)((a)localObject2).EMn.EKW.getLayoutParams();
          ((AbsoluteLayout.LayoutParams)localObject3).y = ((int)((a)localObject2).EMM);
          ((a)localObject2).EMn.EKW.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((a)localObject2).EMn.EKW.invalidate();
        }
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(99398);
    Log.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType());
    if (paramq.getType() == 218)
    {
      paramString = (com.tencent.mm.plugin.sns.model.s)paramq;
      if (((paramString.type == 1) || (paramString.type == 6) || (paramString.type == 4)) && (this.EKZ.EoW != null)) {
        this.EKZ.EoW.dismiss();
      }
      if (paramString.type == 11)
      {
        if (this.mUIAction.tipDialog != null) {
          this.mUIAction.tipDialog.dismiss();
        }
        if (this.EMj != null) {
          this.EMj.setImageResource(2131690751);
        }
      }
    }
    if (this.EKT != null) {
      this.EKT.ESq.notifyVendingDataChange();
    }
    com.tencent.mm.modelsns.k localk;
    if (paramq.getType() == 211)
    {
      paramString = (com.tencent.mm.plugin.sns.model.z)paramq;
      if (!paramString.DIe) {
        break label280;
      }
      localk = com.tencent.mm.modelsns.k.tO(727);
      localk.tR(this.EKT.getCount()).tR(paramString.akb);
      localk.bfK();
    }
    for (;;)
    {
      if (this.ELb != null)
      {
        this.EKY = false;
        this.ELb.fjt();
      }
      a(paramInt1, paramInt2, paramq, this);
      AppMethodBeat.o(99398);
      return;
      label280:
      localk = com.tencent.mm.modelsns.k.tO(728);
      localk.tR(this.EKT.getCount()).tR(paramString.akb).tR(0);
      localk.bfK();
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
    AppMethodBeat.i(203731);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.ExJ = false;
      AppMethodBeat.o(203731);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.o(203731);
    }
    if (!this.ExJ)
    {
      Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onWindowFocusChanged callback");
      ScreenShotUtil.setScreenShotCallback(this, this.EyL);
      this.ExJ = true;
    }
    AppMethodBeat.o(203731);
    return;
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(99375);
    super.setActionbarColor(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.BdQ != null))
    {
      this.BdQ.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.e(getWindow());
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
  
  public final void vx(boolean paramBoolean)
  {
    AppMethodBeat.i(99405);
    if (this.EKT != null)
    {
      Log.i("MicroMsg.SnsTimeLineUI", "set play animation %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.mm.plugin.sns.ui.a.c localc = this.EKT;
      localc.ESr = paramBoolean;
      if (!paramBoolean) {
        localc.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(99405);
  }
  
  final class a
    extends Animation
  {
    int AGw = 600;
    private float EMJ;
    private float EMK;
    float EML = -1.0F;
    float EMM;
    private float EMN = 50.0F;
    private float EMO = 10.0F;
    float EMP = 0.0F;
    private float EMQ = 0.0F;
    private float EMR;
    private float EMS;
    boolean EMT;
    int EMU;
    boolean EMV = false;
    int EMW = 0;
    float EMX = 0.0F;
    float EMY = 0.0F;
    float EMZ = 0.0F;
    float ENa = 0.0F;
    private ListView list;
    
    public a(ListView paramListView)
    {
      this.list = paramListView;
    }
    
    final void JT(long paramLong)
    {
      AppMethodBeat.i(99363);
      if (SnsTimeLineUI.ELX.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "setDurationTime durationMillis %s %s", new Object[] { Long.valueOf(paramLong), Util.getStack().toString() });
      }
      setDuration(paramLong);
      AppMethodBeat.o(99363);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(99366);
      if (SnsTimeLineUI.ELX.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "animtest applyTransformation vis %s interpolatedTime %s isJustUp %s", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(paramFloat), Boolean.valueOf(this.EMT) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99366);
        return;
      }
      float f1 = (paramFloat - this.EMR) * (float)getDuration();
      if (f1 < 2.0F)
      {
        if (SnsTimeLineUI.ELX.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "applyTransformation wawawa %s", new Object[] { Float.valueOf(f1) });
        }
        AppMethodBeat.o(99366);
        return;
      }
      this.EMR = paramFloat;
      SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(2131690346);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.QEF);
      if (((float)getDuration() * paramFloat >= (float)(getDuration() - this.AGw)) || (this.EMT))
      {
        paramTransformation = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        if (paramTransformation.y <= this.EMQ)
        {
          AppMethodBeat.o(99366);
          return;
        }
        if (this.EMZ == 0.0F)
        {
          this.EMZ = (-this.EMQ + paramTransformation.y);
          this.ENa = paramTransformation.y;
          this.EMS = paramFloat;
        }
        paramFloat = (paramFloat - this.EMS) / (1.0F - this.EMS);
        f1 = this.EMZ * paramFloat;
        float f2 = this.ENa - f1;
        if (SnsTimeLineUI.ELX.booleanValue()) {
          Log.i("MicroMsg.RefreshAnim", "animcheck interpolatedTime y %s duration %s factor %s residualTime %s pass %s ", new Object[] { Float.valueOf(f2), Long.valueOf(getDuration()), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.EMS * (float)getDuration()) });
        }
        if (paramTransformation.y > f2) {
          paramTransformation.y = ((int)f2);
        }
        this.EMP = paramTransformation.y;
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(paramTransformation);
      }
      for (;;)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99366);
        return;
        if (SnsTimeLineUI.ELX.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "animcheck delt Rotate " + f1 / 2.5F);
        }
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(f1 / 2.5F, this.EMJ, this.EMK);
      }
    }
    
    public final void bZ(float paramFloat)
    {
      AppMethodBeat.i(99360);
      if (this.list != null)
      {
        if (this.list.getFirstVisiblePosition() != 0) {
          break label123;
        }
        if (SnsTimeLineUI.d(SnsTimeLineUI.this).DSh.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).EMU) {
          SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
        }
      }
      for (;;)
      {
        if (SnsTimeLineUI.ELX.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.EMM), Float.valueOf(this.EML) });
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
      if (paramFloat <= -this.EMN) {
        f1 = -this.EMN;
      }
      float f2 = f1;
      if (f1 >= this.EMN) {
        f2 = this.EMN;
      }
      if (f2 < 0.0F)
      {
        this.EMP -= f2 * 2.0F;
        f1 = this.EMP;
        paramFloat = f1;
        if (f1 < this.EMM)
        {
          paramFloat = this.EMM;
          this.EMP = this.EMM;
        }
        f1 = paramFloat;
        if (paramFloat > this.EML)
        {
          f1 = this.EML;
          this.EMP = this.EML;
        }
        if (SnsTimeLineUI.ELX.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s sumY %s translateY %s distanceY %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.EMM), Float.valueOf(this.EML), Float.valueOf(this.EMP), Float.valueOf(f1), Float.valueOf(this.EMN) });
        }
        if (f1 != this.EML) {
          break label456;
        }
      }
      label456:
      for (paramFloat = f2 * 2.0F;; paramFloat = 5.0F * f2)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.QEF);
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(paramFloat, this.EMJ, this.EMK);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(2131690346);
        AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        localLayoutParams.y = ((int)f1);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99360);
        return;
        this.EMP -= f2 / 2.0F;
        break;
      }
    }
    
    public final void fjs()
    {
      AppMethodBeat.i(99361);
      if (SnsTimeLineUI.ELX.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "animtest playLoading");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99361);
        return;
      }
      init();
      this.EMP = (this.EML + 20.0F);
      AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
      localLayoutParams.y = ((int)this.EML);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
      fju();
      AppMethodBeat.o(99361);
    }
    
    public final void fjt()
    {
      AppMethodBeat.i(99362);
      if (SnsTimeLineUI.ELX.booleanValue()) {
        Log.i("MicroMsg.RefreshAnim", "play end vis: %d, sumY %f MAX_Y %f", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(this.EMP), Float.valueOf(this.EML) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99362);
        return;
      }
      init();
      if (this.EMP < this.EML - this.EMO)
      {
        AppMethodBeat.o(99362);
        return;
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      JT(this.AGw + 100);
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      this.EMT = false;
      AppMethodBeat.o(99362);
    }
    
    public final void fju()
    {
      AppMethodBeat.i(99364);
      if (SnsTimeLineUI.ELX.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "animtest setAcitonUp");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99364);
        return;
      }
      init();
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      if (SnsTimeLineUI.ELX.booleanValue()) {
        Log.v("MicroMsg.RefreshAnim", "setAcitonUp1 sumY  %s MAX_Y %s %s", new Object[] { Float.valueOf(this.EMP), Float.valueOf(this.EML), Util.getStack().toString() });
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      if (this.EMP >= this.EML - this.EMO)
      {
        JT(20000L);
        this.EMT = false;
        AppMethodBeat.o(99364);
        return;
      }
      JT(this.AGw + 100);
      this.EMT = true;
      AppMethodBeat.o(99364);
    }
    
    final void init()
    {
      AppMethodBeat.i(99365);
      if ((this.EML == -1.0F) || (this.EMK < 0.1D))
      {
        this.EML = BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 70.0F);
        this.EMN = BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 16.0F);
        this.EMJ = (SnsTimeLineUI.u(SnsTimeLineUI.this).getWidth() / 2);
        this.EMK = (SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() / 2);
        this.EMQ = (-SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() * 2);
        if (this.EMQ == 0.0F) {
          this.EMQ = (-BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 40.0F));
        }
        this.EMM = this.EMQ;
        if (SnsTimeLineUI.ELX.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "init MIN_Y %s MAX_Y %s targetInitY %s distanceY %s", new Object[] { Float.valueOf(this.EMM), Float.valueOf(this.EML), Float.valueOf(this.EMQ), Float.valueOf(this.EMN) });
        }
        this.EMP = this.EMM;
        if (!this.EMV)
        {
          if (SnsTimeLineUI.ELX.booleanValue()) {
            Log.i("MicroMsg.RefreshAnim", "initState");
          }
          this.EMW = ((AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams()).y;
          this.EMX = this.EML;
          this.EMY = this.EMP;
        }
        this.EMV = true;
      }
      AppMethodBeat.o(99365);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(99367);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      if (SnsTimeLineUI.ELX.booleanValue()) {
        Log.i("MicroMsg.RefreshAnim", "anim initialize %s", new Object[] { Util.getStack().toString() });
      }
      this.EMR = 0.0F;
      this.EMS = 0.0F;
      this.EMZ = 0.0F;
      this.ENa = 0.0F;
      AppMethodBeat.o(99367);
    }
  }
  
  final class b
  {
    public int ENb;
    public int type = 0;
    
    private b() {}
  }
  
  final class c
  {
    public String ENc = "";
    public long ENd;
    public int ENe;
    public int ENf;
    public long ENg;
    public int ENh;
    public long ENi;
    public int ENj;
    public long ENk;
    public boolean active = true;
    public long mNy;
    public int scene;
    
    private c() {}
    
    public final void ZT(int paramInt)
    {
      AppMethodBeat.i(99368);
      if (!this.active)
      {
        AppMethodBeat.o(99368);
        return;
      }
      this.ENf = paramInt;
      this.mNy = Util.nowMilliSecond();
      AppMethodBeat.o(99368);
    }
    
    public final void ZU(int paramInt)
    {
      AppMethodBeat.i(99369);
      if (!this.active)
      {
        AppMethodBeat.o(99369);
        return;
      }
      reset();
      this.scene = 2;
      this.ENg = Util.nowMilliSecond();
      this.ENh = paramInt;
      AppMethodBeat.o(99369);
    }
    
    public final void ZV(int paramInt)
    {
      AppMethodBeat.i(99370);
      if (!this.active)
      {
        AppMethodBeat.o(99370);
        return;
      }
      reset();
      this.scene = 3;
      this.ENi = Util.nowMilliSecond();
      this.ENk = 0L;
      this.ENj = paramInt;
      AppMethodBeat.o(99370);
    }
    
    final void reset()
    {
      this.scene = 0;
      this.ENd = 0L;
      this.ENe = -1;
      this.ENf = 0;
      this.mNy = 0L;
      this.ENg = 0L;
      this.ENh = 0;
      this.ENi = 0L;
      this.ENj = 0;
      this.ENk = 0L;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(99371);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.ENc).append(",").append(this.scene).append(",").append(this.ENd).append(",").append(this.ENe).append(",").append(this.ENf).append(",").append(this.mNy).append(",").append(this.ENg).append(",").append(this.ENh).append(",").append(this.ENi).append(",").append(this.ENj).append(",").append(this.ENk);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(99371);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI
 * JD-Core Version:    0.7.0.1
 */