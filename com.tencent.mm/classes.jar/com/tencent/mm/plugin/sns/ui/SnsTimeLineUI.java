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
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.f.a.cp;
import com.tencent.mm.f.a.jh;
import com.tencent.mm.f.a.oi;
import com.tencent.mm.f.a.on;
import com.tencent.mm.f.a.ox;
import com.tencent.mm.f.a.oy;
import com.tencent.mm.f.a.pf;
import com.tencent.mm.f.a.tl;
import com.tencent.mm.f.a.wf;
import com.tencent.mm.f.a.wn;
import com.tencent.mm.f.a.wo;
import com.tencent.mm.f.a.ws;
import com.tencent.mm.f.a.wt;
import com.tencent.mm.f.a.wu;
import com.tencent.mm.f.a.wz;
import com.tencent.mm.f.a.xc;
import com.tencent.mm.f.a.xi;
import com.tencent.mm.f.a.xj;
import com.tencent.mm.f.a.xn;
import com.tencent.mm.f.a.xs;
import com.tencent.mm.f.a.zz;
import com.tencent.mm.f.b.a.jy;
import com.tencent.mm.f.b.a.ku;
import com.tencent.mm.f.b.a.mw;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.secdata.ui.WxPresenterSecDataActivity;
import com.tencent.mm.plugin.sns.ad.f.n.5;
import com.tencent.mm.plugin.sns.b.j.a;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.d.2;
import com.tencent.mm.plugin.sns.m.c.b;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.av.5;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.eji;
import com.tencent.mm.protocal.protobuf.ejj;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.f;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
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

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.widget.pulldown.c(0)
public class SnsTimeLineUI
  extends WxPresenterSecDataActivity
  implements com.tencent.mm.an.i, com.tencent.mm.model.bc, j.a, z
{
  public static final Boolean KZY;
  private static Boolean KZo;
  private static final Set<Activity> sUILeaksRoutineEnsuranceRef;
  private int BoC;
  private View Cwk;
  private com.tencent.mm.ui.statusbar.c.a Cwl;
  private long EIx;
  private boolean KBX;
  private boolean KEq;
  private volatile boolean KLC;
  private ScreenShotUtil.ScreenShotCallback KMx;
  protected com.tencent.mm.plugin.sns.ad.f.l KPn;
  private com.tencent.mm.plugin.sns.m.b KYR;
  private com.tencent.mm.plugin.sns.m.a KYS;
  private com.tencent.mm.plugin.sns.ui.a.a.c KYT;
  com.tencent.mm.plugin.sns.ui.a.c KYU;
  private LinearLayout KYV;
  private LinearLayout KYW;
  private QFadeImageView KYX;
  private boolean KYY;
  private boolean KYZ;
  private int KZA;
  private com.tencent.mm.ui.widget.a.e KZB;
  private boolean KZC;
  private Runnable KZD;
  private IListener KZE;
  private IListener KZF;
  private Vending.d KZG;
  private boolean KZH;
  private IListener KZI;
  private IListener KZJ;
  private IListener KZK;
  private IListener KZL;
  private IListener KZM;
  private IListener KZN;
  private IListener KZO;
  private IListener KZP;
  private IListener KZQ;
  private IListener KZR;
  private IListener KZS;
  private IListener KZT;
  private IListener KZU;
  private IListener KZV;
  private IListener KZW;
  private IListener KZX;
  private long KZZ;
  private i KZa;
  private int KZb;
  private a KZc;
  private TestTimeForSns KZd;
  private int KZe;
  private boolean KZf;
  private String KZg;
  private com.tencent.mm.plugin.sns.k.a KZh;
  private com.tencent.mm.plugin.sns.model.bc KZi;
  private ba KZj;
  private String KZk;
  private boolean KZl;
  private int KZm;
  private String KZn;
  private String KZp;
  private c KZq;
  private bh KZr;
  private ViewGroup KZs;
  private long KZt;
  private int KZu;
  private int KZv;
  private int KZw;
  private int KZx;
  private int KZy;
  private int KZz;
  private IListener Kbv;
  private boolean Kfq;
  boolean Laa;
  Runnable Lab;
  Runnable Lac;
  private Handler Lad;
  private Runnable Lae;
  private SnsUIAction.a Laf;
  private long Lag;
  private a.b Lah;
  boolean Lai;
  int Laj;
  private ImageView Lak;
  private View Lal;
  private long Lam;
  private boolean Lan;
  private boolean autoPlay;
  private int iWt;
  private long jXk;
  private long lJV;
  private ActionBar mActionBar;
  private int mScreenHeight;
  private int mScreenWidth;
  private String mSessionId;
  private SnsUIAction mUIAction;
  private String pRV;
  private MenuItem.OnMenuItemClickListener xPo;
  
  static
  {
    AppMethodBeat.i(99430);
    KZo = null;
    KZY = Boolean.FALSE;
    sUILeaksRoutineEnsuranceRef = new HashSet();
    AppMethodBeat.o(99430);
  }
  
  public SnsTimeLineUI()
  {
    AppMethodBeat.i(99372);
    this.KYR = ((com.tencent.mm.plugin.sns.m.b)ap(com.tencent.mm.plugin.sns.m.b.class));
    if (this.KYR != null) {}
    for (com.tencent.mm.plugin.sns.m.a locala = this.KYR.fZK();; locala = null)
    {
      this.KYS = locala;
      this.KYT = new com.tencent.mm.plugin.sns.ui.a.a.c();
      this.KYY = false;
      this.KYZ = false;
      this.KBX = false;
      this.KZb = 800;
      this.KZe = 0;
      this.KZf = false;
      this.KZg = "";
      this.KZh = new com.tencent.mm.plugin.sns.k.a();
      this.KPn = new com.tencent.mm.plugin.sns.ad.f.l(0);
      this.KZi = new com.tencent.mm.plugin.sns.model.bc();
      this.KZj = new ba();
      this.autoPlay = false;
      this.KZp = "";
      this.KZq = new c((byte)0);
      this.KZr = new bh();
      this.KZs = null;
      this.KZt = 0L;
      this.KLC = false;
      this.KZu = 0;
      this.KZv = 0;
      this.KZw = 0;
      this.KZx = 0;
      this.KZy = 2;
      this.KZz = 2;
      this.KZA = 2;
      this.KZC = false;
      this.KZD = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99267);
          com.tencent.mm.plugin.sns.ui.a.c localc = SnsTimeLineUI.a(SnsTimeLineUI.this);
          if (localc != null)
          {
            if (aj.fOT().KaH == com.tencent.mm.plugin.sns.model.aw.Kbk) {
              SnsTimeLineUI.a(SnsTimeLineUI.this, localc.zg(true));
            }
            localc.Lgt.fWS();
            localc.Lgt.notifyVendingDataChange();
          }
          AppMethodBeat.o(99267);
        }
      };
      this.KZE = new IListener() {};
      this.KZF = new IListener() {};
      this.KZG = new Vending.d()
      {
        public final void fXA()
        {
          AppMethodBeat.i(179249);
          final int i;
          if ((SnsTimeLineUI.a(SnsTimeLineUI.this) != null) && (!SnsTimeLineUI.a(SnsTimeLineUI.this).Lgu))
          {
            SnsTimeLineUI.a(SnsTimeLineUI.this).notifyDataSetChanged();
            if (SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView() != null)
            {
              i = ax.ew(SnsTimeLineUI.this.getContext());
              int j = ax.getStatusBarHeight(SnsTimeLineUI.this.getContext());
              Log.d("MicroMsg.SnsTimeLineUI", "topOffset:%s curFetchMode:%s, mUIAction.header.getLoadingGroupHeight():%s, actionBar:%s, statusBar:%s", new Object[] { Integer.valueOf(-(SnsTimeLineUI.d(SnsTimeLineUI.this).Kfp.getLoadingGroupHeight() - com.tencent.mm.ui.aw.fromDPToPix(SnsTimeLineUI.this.getContext(), 44) - i - j)), Integer.valueOf(aj.fOT().KaH), Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).Kfp.getLoadingGroupHeight()), Integer.valueOf(i), Integer.valueOf(j) });
              if (aj.fOT().KaH == com.tencent.mm.plugin.sns.model.aw.Kbj)
              {
                Log.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_SPECIFIC");
                long l = SnsTimeLineUI.a(SnsTimeLineUI.this).fYl();
                aj.fOy().af(l, -1);
                SnsTimeLineUI.a(SnsTimeLineUI.this).Lgt.bck(com.tencent.mm.plugin.sns.data.t.Qv(l));
                SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.a(SnsTimeLineUI.this).zg(true));
                SnsTimeLineUI.d(SnsTimeLineUI.this).zd(true);
                aj.fOF().start();
                SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(268513);
                    SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().setSelectionFromTop(SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), i + com.tencent.mm.ui.aw.fromDPToPix(SnsTimeLineUI.this.getContext(), 44));
                    aj.fOT().KaJ = false;
                    AppMethodBeat.o(268513);
                  }
                });
                AppMethodBeat.o(179249);
                return;
              }
              if (aj.fOT().KaH == com.tencent.mm.plugin.sns.model.aw.Kbk)
              {
                i = 0;
                if (i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) {
                  break label421;
                }
                if (SnsTimeLineUI.a(SnsTimeLineUI.this).agM(i).field_snsId != SnsTimeLineUI.e(SnsTimeLineUI.this)) {
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
      this.KZH = false;
      this.Kfq = false;
      this.KZI = new IListener() {};
      this.KZJ = new IListener() {};
      this.KZK = new IListener() {};
      this.KZL = new IListener() {};
      this.KZM = new IListener() {};
      this.KZN = new IListener() {};
      this.KZO = new IListener() {};
      this.KZP = new IListener() {};
      this.KZQ = new IListener() {};
      this.Kbv = new IListener() {};
      this.KZR = new IListener() {};
      this.KZS = new IListener() {};
      this.KZT = new IListener() {};
      this.KZU = new IListener() {};
      this.KZV = new IListener() {};
      this.KZW = new IListener() {};
      this.KZX = new IListener() {};
      this.KZZ = 0L;
      this.Laa = false;
      this.BoC = 0;
      this.Lab = new Runnable()
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
            aj.fOF().pause();
          }
          AppMethodBeat.o(176303);
        }
      };
      this.Lac = new Runnable()
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
            aj.fOF().start();
            SnsTimeLineUI.a(SnsTimeLineUI.this).Lgs.fXf();
          }
          AppMethodBeat.o(179225);
        }
      };
      this.Lad = ((com.tencent.mm.vending.h.b)com.tencent.mm.vending.h.d.LOGIC.YBc).mHandler;
      this.Lae = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179226);
          SnsTimeLineUI.this.setMMNormalView();
          SnsTimeLineUI.w(SnsTimeLineUI.this);
          SnsTimeLineUI.x(SnsTimeLineUI.this);
          SnsTimeLineUI.this.setMMTitle(SnsTimeLineUI.this.getString(i.j.sns_timeline_ui_title));
          SnsTimeLineUI.y(SnsTimeLineUI.this);
          SnsTimeLineUI.c(SnsTimeLineUI.this, SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition());
          AppMethodBeat.o(179226);
        }
      };
      this.Laf = new SnsUIAction.a()
      {
        private int Lav = 0;
        private int Law = 0;
        
        public final void a(com.tencent.mm.plugin.sns.data.o paramAnonymouso) {}
        
        public final void aY(int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(267810);
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).Lgt.notifyVendingDataChange();
          }
          if (!paramAnonymousBoolean) {
            SnsTimeLineUI.this.aII().bG(c.b.class);
          }
          AppMethodBeat.o(267810);
        }
        
        public final void ahp(int paramAnonymousInt)
        {
          AppMethodBeat.i(267809);
          int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          int k = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
          if ((paramAnonymousInt == 0) && (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)) {
            SnsTimeLineUI.a(SnsTimeLineUI.this, j, k);
          }
          if ((j == this.Lav) && (k == this.Law))
          {
            AppMethodBeat.o(267809);
            return;
          }
          this.Lav = j;
          this.Law = k;
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
              break label520;
            }
          }
          LinkedList localLinkedList;
          label520:
          for (int i = Process.myTid();; i = 0)
          {
            SnsTimeLineUI.d((SnsTimeLineUI)localObject1, WXHardCoderJNI.startPerformance(bool, m, n, i1, i, WXHardCoderJNI.hcSNSScrollTimeout, 701, WXHardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI"));
            Log.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsTimeLineUI.F(SnsTimeLineUI.this)) });
            if ((paramAnonymousInt != 0) || (SnsTimeLineUI.a(SnsTimeLineUI.this) == null)) {
              break label554;
            }
            localObject1 = SnsTimeLineUI.a(SnsTimeLineUI.this);
            if (k < j) {
              break label541;
            }
            localLinkedList = new LinkedList();
            paramAnonymousInt = j;
            while (paramAnonymousInt <= k)
            {
              Object localObject2 = ((com.tencent.mm.plugin.sns.ui.a.c)localObject1).agM(paramAnonymousInt - 1);
              if (localObject2 != null)
              {
                localObject2 = ((SnsInfo)localObject2).getTimeLine();
                if ((localObject2 != null) && (!TextUtils.isEmpty(((TimeLineObject)localObject2).ContentObj.Url)) && (((TimeLineObject)localObject2).ContentObj.Url.contains(WeChatHosts.domainString(i.j.host_mp_weixin_qq_com))) && (((TimeLineObject)localObject2).ContentObj.Sqq == 3))
                {
                  i = -1;
                  if (((TimeLineObject)localObject2).ContentObj.Squ != null) {
                    i = ((TimeLineObject)localObject2).ContentObj.Squ.lpx;
                  }
                  ArrayList localArrayList = new ArrayList();
                  localArrayList.add(((TimeLineObject)localObject2).ContentObj.Url);
                  localArrayList.add(String.valueOf(i));
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).Id));
                  localArrayList.add("");
                  localArrayList.add("");
                  localArrayList.add(((TimeLineObject)localObject2).UserName);
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).CreateTime));
                  localArrayList.add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).ape("__sns_timeline__")));
                  localLinkedList.add(localArrayList);
                }
              }
              paramAnonymousInt += 1;
            }
          }
          ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).j(localLinkedList, 2);
          label541:
          SnsTimeLineUI.a(SnsTimeLineUI.this).kb(j, k);
          label554:
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)
          {
            localObject1 = SnsTimeLineUI.j(SnsTimeLineUI.this).b(SnsTimeLineUI.a(SnsTimeLineUI.this).Lgs);
            com.tencent.mm.vending.g.g.ieN().d(new com.tencent.mm.vending.c.a() {});
          }
          com.tencent.mm.plugin.sns.k.g.Kia.jG(j, k);
          com.tencent.mm.plugin.sns.k.g.Kia.jH(j, k);
          AppMethodBeat.o(267809);
        }
        
        public final void d(int paramAnonymousInt, List<Integer> paramAnonymousList1, List<Integer> paramAnonymousList2)
        {
          int j = 1;
          AppMethodBeat.i(267804);
          int i = j;
          if (paramAnonymousInt > 0)
          {
            paramAnonymousList1 = aj.fOI().agI(paramAnonymousInt);
            i = j;
            if (paramAnonymousList1 != null)
            {
              if (paramAnonymousList1.getPravited() > 0) {
                Toast.makeText(SnsTimeLineUI.this, i.j.sns_has_save, 1).show();
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
            paramAnonymousList1 = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousList1);
            paramAnonymousList2 = new Object();
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousList2, paramAnonymousList1.aFh(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousList1.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousList2, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          }
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).Lgt.notifyVendingDataChange();
          }
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.b(SnsTimeLineUI.this);
          }
          AppMethodBeat.o(267804);
        }
        
        public final void fXt()
        {
          AppMethodBeat.i(267799);
          if (aj.fOT().KaJ)
          {
            Log.i("MicroMsg.SnsTimeLineUI", "isAutoScrolling, skip onLoadingMore");
            AppMethodBeat.o(267799);
            return;
          }
          com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
          SnsTimeLineUI.n(SnsTimeLineUI.this).getType();
          localc.e(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), false, SnsTimeLineUI.A(SnsTimeLineUI.this));
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vwx, Integer.valueOf(3));
          Log.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
          if (SnsTimeLineUI.B(SnsTimeLineUI.this) == null)
          {
            Log.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
            AppMethodBeat.o(267799);
            return;
          }
          if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
          {
            SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
            SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
          }
          AppMethodBeat.o(267799);
        }
        
        public final View fXu()
        {
          AppMethodBeat.i(267801);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).KdA == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).KdA = ((FrameLayout)SnsTimeLineUI.this.findViewById(i.f.timeline_root));
          }
          FrameLayout localFrameLayout = SnsTimeLineUI.k(SnsTimeLineUI.this).KdA;
          AppMethodBeat.o(267801);
          return localFrameLayout;
        }
        
        public final MMPullDownView fXv()
        {
          AppMethodBeat.i(267803);
          MMPullDownView localMMPullDownView = (MMPullDownView)SnsTimeLineUI.this.findViewById(i.f.sns_pull_down_view);
          AppMethodBeat.o(267803);
          return localMMPullDownView;
        }
        
        public final boolean fXw()
        {
          AppMethodBeat.i(267805);
          boolean bool = SnsTimeLineUI.D(SnsTimeLineUI.this);
          AppMethodBeat.o(267805);
          return bool;
        }
        
        public final void fXx()
        {
          AppMethodBeat.i(267806);
          Log.d("MicroMsg.SnsTimeLineUI", "onLoadingTap");
          SnsTimeLineUI.this.fTI();
          if ((!SnsTimeLineUI.d(SnsTimeLineUI.this).KJB) && (!SnsTimeLineUI.E(SnsTimeLineUI.this)))
          {
            if (SnsTimeLineUI.u(SnsTimeLineUI.this) != null)
            {
              Log.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
              SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
            }
            com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this).getType();
            localc.d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vwx, Integer.valueOf(2));
          }
          AppMethodBeat.o(267806);
        }
        
        public final void fXy()
        {
          AppMethodBeat.i(267807);
          SnsTimeLineUI.this.fTI();
          AppMethodBeat.o(267807);
        }
        
        public final void fXz()
        {
          AppMethodBeat.i(267808);
          aj.fOT().fPD();
          int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          Object localObject1 = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getChildAt(0);
          Log.i("MicroMsg.SnsTimeLineUI", "will do up fetch isDoingFetch:%s, SnsCore.getSnsUnreadTipManager().isAutoScrolling:%s", new Object[] { Boolean.valueOf(aj.fOT().KaK), Boolean.valueOf(aj.fOT().KaJ) });
          if ((!aj.fOT().KaJ) && (localObject1 != null) && (i == 0) && (((View)localObject1).getTop() == 0) && (SnsTimeLineUI.d(SnsTimeLineUI.this).KJB))
          {
            if (aj.fOT().KaK)
            {
              AppMethodBeat.o(267808);
              return;
            }
            Object localObject2 = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this).getType();
            localObject1 = SnsTimeLineUI.o(SnsTimeLineUI.this);
            i = com.tencent.mm.plugin.sns.model.aw.Kbk;
            boolean bool = SnsTimeLineUI.q(SnsTimeLineUI.this);
            int j = SnsTimeLineUI.A(SnsTimeLineUI.this);
            if ((((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).hasInit) && (((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).Laj == 0))
            {
              long l = aj.fOT().KaG;
              localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).LgN;
              if (((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).KYR != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).KYR.Lvi;
                com.tencent.mm.vending.g.g.b(localObject1, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(j), Long.valueOf(l)).c((com.tencent.mm.vending.c.a)localObject2);
              }
            }
            if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
            {
              SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
              SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
            }
          }
          AppMethodBeat.o(267808);
        }
        
        public final View getMaskView()
        {
          AppMethodBeat.i(267802);
          View localView = SnsTimeLineUI.this.findViewById(i.f.sns_cover_shadow);
          AppMethodBeat.o(267802);
          return localView;
        }
        
        public final ListView getSnsListView()
        {
          AppMethodBeat.i(267800);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).list == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).list = ((ListView)SnsTimeLineUI.this.findViewById(i.f.sns_photo_list));
          }
          ListView localListView = SnsTimeLineUI.k(SnsTimeLineUI.this).list;
          AppMethodBeat.o(267800);
          return localListView;
        }
        
        public final int getType()
        {
          int i = 1;
          if (SnsTimeLineUI.this.Laj == 1) {
            i = 2;
          }
          return i;
        }
        
        public final void ka(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void zc(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(267811);
          SnsTimeLineUI localSnsTimeLineUI = SnsTimeLineUI.this;
          localSnsTimeLineUI.Laa = paramAnonymousBoolean;
          MMHandler localMMHandler = aj.etE();
          com.tencent.mm.plugin.sns.model.g localg = aj.fOF();
          com.tencent.mm.plugin.sns.model.c localc = aj.fOD();
          if (paramAnonymousBoolean)
          {
            if ((localg.JTH) || (localc.JTH))
            {
              localMMHandler.removeCallbacks(localSnsTimeLineUI.Lab);
              localMMHandler.removeCallbacks(localSnsTimeLineUI.Lac);
              localMMHandler.postDelayed(localSnsTimeLineUI.Lab, 0L);
              AppMethodBeat.o(267811);
            }
          }
          else if ((!localg.JTH) || (!localc.JTH))
          {
            localMMHandler.removeCallbacks(localSnsTimeLineUI.Lab);
            localMMHandler.removeCallbacks(localSnsTimeLineUI.Lac);
            localMMHandler.postDelayed(localSnsTimeLineUI.Lac, 0L);
          }
          AppMethodBeat.o(267811);
        }
      };
      this.Lag = 0L;
      this.Lah = new a.b() {};
      this.mScreenWidth = 0;
      this.mScreenHeight = 0;
      this.Lai = true;
      this.EIx = 0L;
      this.jXk = 0L;
      this.lJV = 0L;
      this.KMx = new ScreenShotUtil.ScreenShotCallback()
      {
        public final void onScreenShot(String paramAnonymousString, long paramAnonymousLong)
        {
          AppMethodBeat.i(199278);
          Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
          SnsTimeLineUI.M(SnsTimeLineUI.this);
          AppMethodBeat.o(199278);
        }
      };
      this.Laj = 0;
      this.xPo = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(220578);
          SnsTimeLineUI.this.hideVKB();
          SnsTimeLineUI.this.finish();
          AppMethodBeat.o(220578);
          return false;
        }
      };
      this.Lam = 0L;
      this.Lan = false;
      AppMethodBeat.o(99372);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, q paramq, final Context paramContext)
  {
    AppMethodBeat.i(193877);
    if (paramq == null)
    {
      AppMethodBeat.o(193877);
      return;
    }
    if ((paramq.getType() != 213) && (paramq.getType() != 682))
    {
      AppMethodBeat.o(193877);
      return;
    }
    if (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag())
    {
      AppMethodBeat.o(193877);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(193877);
      return;
    }
    if ((!(paramq instanceof com.tencent.mm.plugin.sns.model.p)) && (!(paramq instanceof com.tencent.mm.plugin.sns.model.k)))
    {
      AppMethodBeat.o(193877);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.sns.model.p))
    {
      if (((paramContext instanceof SnsTimeLineUI)) && (((com.tencent.mm.plugin.sns.model.p)paramq).JVk != 0)) {
        AppMethodBeat.o(193877);
      }
    }
    else if (((paramq instanceof com.tencent.mm.plugin.sns.model.k)) && ((paramContext instanceof SnsTimeLineUI)) && (((com.tencent.mm.plugin.sns.model.k)paramq).mScene != 0))
    {
      AppMethodBeat.o(193877);
      return;
    }
    final long l = cm.bfF();
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        Object localObject2 = null;
        Object localObject1 = null;
        AppMethodBeat.i(198537);
        Object localObject4;
        Object localObject3;
        if ((this.ftz instanceof com.tencent.mm.plugin.sns.model.p))
        {
          localObject2 = (com.tencent.mm.plugin.sns.model.p)this.ftz;
          if (((com.tencent.mm.plugin.sns.model.p)localObject2).JVa != null) {
            localObject1 = ((com.tencent.mm.plugin.sns.model.p)localObject2).JVa.Ulv;
          }
          localObject2 = ((com.tencent.mm.plugin.sns.model.p)this.ftz).Jwr;
          localObject4 = ((com.tencent.mm.plugin.sns.model.p)this.ftz).Jws;
          localObject3 = localObject1;
          localObject1 = localObject4;
        }
        for (;;)
        {
          if ((localObject3 == null) || (localObject2 == null) || (localObject1 == null))
          {
            AppMethodBeat.o(198537);
            return;
            if ((this.ftz instanceof com.tencent.mm.plugin.sns.model.k))
            {
              localObject3 = (com.tencent.mm.plugin.sns.model.k)this.ftz;
              localObject1 = localObject2;
              if (((com.tencent.mm.plugin.sns.model.k)localObject3).JVa != null) {
                localObject1 = ((com.tencent.mm.plugin.sns.model.k)localObject3).JVa.Ulv;
              }
              localObject2 = ((com.tencent.mm.plugin.sns.model.k)this.ftz).Jwr;
              localObject3 = (com.tencent.mm.plugin.sns.model.k)this.ftz;
              if (((com.tencent.mm.plugin.sns.model.k)localObject3).Jws == null) {
                ((com.tencent.mm.plugin.sns.model.k)localObject3).Jws = ((com.tencent.mm.plugin.sns.model.k)localObject3).fNZ();
              }
              localObject4 = ((com.tencent.mm.plugin.sns.model.k)localObject3).Jws;
              localObject3 = localObject1;
              localObject1 = localObject4;
            }
          }
          else
          {
            localObject2 = com.tencent.mm.plugin.sns.data.t.a((eji)localObject3, (SnsObject)localObject2);
            if (localObject2 == null)
            {
              AppMethodBeat.o(198537);
              return;
            }
            localObject3 = k.a.Rsi.matcher(((eji)localObject3).lpy);
            if (((Matcher)localObject3).find())
            {
              localObject4 = new StringBuilder();
              if (((ejo)localObject2).Uln != 0) {}
              for (long l = ((ejo)localObject2).Uln;; l = ((ejo)localObject2).Ulp)
              {
                localObject4 = l;
                SnsCommentFooter.a(paramContext, localObject1, com.tencent.mm.plugin.sns.data.t.a((ejo)localObject2), (String)localObject4, 3, ((Matcher)localObject3).group(), l);
                break;
              }
            }
            SnsCommentFooter.lyo = com.tencent.mm.plugin.fts.a.d.Sx(79);
            AppMethodBeat.o(198537);
            return;
          }
          localObject1 = null;
          localObject2 = null;
          localObject3 = null;
        }
      }
    }, "WebSearchReportLogic.TagSearchReport");
    AppMethodBeat.o(193877);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(99406);
    if (paramc.active)
    {
      Log.d("MicroMsg.SnsTimeLineUI", "report weishi: %s", new Object[] { paramc.toString() });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(15827, paramc.toString());
    }
    AppMethodBeat.o(99406);
  }
  
  private void aho(int paramInt)
  {
    AppMethodBeat.i(99376);
    if (KZY.booleanValue()) {
      if (paramInt != 0) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsTimeLineUI", "setRefreshAnimVisible %s %s", new Object[] { Boolean.valueOf(bool), Util.getStack().toString() });
      this.KYX.setVisibility(paramInt);
      AppMethodBeat.o(99376);
      return;
    }
  }
  
  private void fXl()
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
        SnsTimeLineUI.d(SnsTimeLineUI.this).bUF();
        AppMethodBeat.o(99306);
      }
    }, 15L);
    AppMethodBeat.o(99377);
  }
  
  private void fXm()
  {
    AppMethodBeat.i(99380);
    boolean bool;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vvX, 0) == 1)
    {
      bool = true;
      this.autoPlay = bool;
      String str1 = Build.MODEL.toLowerCase();
      String str2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vvY, "");
      if ((!Util.isNullOrNil(str2)) && (str2.contains(str1)))
      {
        Log.i("MicroMsg.SnsTimeLineUI", "model %s is hit, expt:%s", new Object[] { str1, str2 });
        this.autoPlay = false;
      }
      if (!this.autoPlay) {
        break label225;
      }
      if (!this.KZr.eVU()) {
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
      if (this.KZr.eqb())
      {
        Log.i("MicroMsg.SnsTimeLineUI", "wifi autoplay true");
        this.autoPlay = true;
      }
      else
      {
        this.autoPlay = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VnY, Boolean.TRUE)).booleanValue();
        continue;
        label225:
        Log.i("MicroMsg.SnsTimeLineUI", "autoPlay DynamicConfig false");
      }
    }
  }
  
  private void fXn()
  {
    AppMethodBeat.i(99381);
    if (this.Laj == 1)
    {
      if (!this.KEq)
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99381);
        return;
      }
      addIconOptionMenu(0, getString(i.j.sns_message_desc), i.i.actionbar_list_icon, new MenuItem.OnMenuItemClickListener()
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
    addIconOptionMenu(0, i.j.sns_action_bar_take_photo_btn_desc, i.i.icons_filled_camera, new MenuItem.OnMenuItemClickListener()new View.OnLongClickListener
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(244363);
        SnsTimeLineUI.L(SnsTimeLineUI.this);
        AppMethodBeat.o(244363);
        return true;
      }
    }, new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(263678);
        localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).KBO != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).KBO.JZd.yA(true);
        }
        com.tencent.mm.kernel.h.aHH();
        boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(7490, Boolean.TRUE)).booleanValue();
        aj.fOP().yO(true);
        paramAnonymousView = aj.fOP().bbm("draft_text");
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.field_draft;
          if (!Util.isNullOrNil(paramAnonymousView))
          {
            com.tencent.mm.kernel.h.aHH();
            localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.ViX, "");
            new ku().amC().BI((String)localObject).bpa();
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
            AppMethodBeat.o(263678);
            return true;
          }
          aj.fOP().b("draft_text", null, 0);
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            aj.fOP().b("draft_text", null, 0);
            continue;
            paramAnonymousView = SnsTimeLineUI.this;
            localObject = new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHG().aHp().i(7490, Boolean.FALSE);
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
          localObject = com.tencent.mm.modelsns.l.wO(705);
          ((com.tencent.mm.modelsns.l)localObject).wS(((com.tencent.mm.modelsns.l)localObject).mbo).Xg(System.currentTimeMillis()).wS(((com.tencent.mm.modelsns.l)localObject).mbp).wS(1);
          localObject = com.tencent.mm.plugin.sns.k.i.Kjb.b((com.tencent.mm.modelsns.l)localObject);
          ((com.tencent.mm.modelsns.l)localObject).bpa();
          ((com.tencent.mm.modelsns.l)localObject).b(paramAnonymousView, "intent_key_StatisticsOplog");
          SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$43", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(263678);
          return true;
        }
      }
    });
    AppMethodBeat.o(99381);
  }
  
  private void fXo()
  {
    AppMethodBeat.i(99391);
    setTitleBarClickListener(new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(193507);
        SnsTimeLineUI.S(SnsTimeLineUI.this);
        AppMethodBeat.o(193507);
      }
    }, new Runnable()
    {
      public final void run() {}
    });
    setBackBtn(this.xPo, i.i.actionbar_icon_dark_back);
    AppMethodBeat.o(99391);
  }
  
  private int fXp()
  {
    if (this.KZy == 0) {
      return this.KZv;
    }
    if (this.KZy == 1) {
      return this.KZw;
    }
    return this.KZx;
  }
  
  private void fXq()
  {
    AppMethodBeat.i(99392);
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VCN, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCN, Boolean.FALSE);
    if (bool) {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCN, Boolean.FALSE);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.h.aHH();
      int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VwH, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(getContext(), "", getContext().getResources().getString(i.j.story_one_day_post_tip, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(99392);
      return;
    }
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).startStoryCaptureForResult(getContext(), 0, System.currentTimeMillis(), 18);
    AppMethodBeat.o(99392);
  }
  
  private void fXr()
  {
    AppMethodBeat.i(99393);
    if (com.tencent.mm.q.a.cw(this))
    {
      AppMethodBeat.o(99393);
      return;
    }
    if (com.tencent.mm.q.a.cB(this))
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
    long l = cm.bfD();
    Object localObject1 = com.tencent.mm.plugin.sns.data.t.fNp();
    Log.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", new Object[] { localObject1 });
    com.tencent.mm.plugin.report.service.h.IzE.a(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), localObject1, Long.valueOf(l) });
    Object localObject2 = new SightParams(2, 0);
    Object localObject3 = com.tencent.mm.plugin.sns.k.c.KfL;
    localObject2 = com.tencent.mm.plugin.sns.k.c.a("", "", ((SightParams)localObject2).lgX, ((SightParams)localObject2).lgX.duration * 1000);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFL, false)) {
      ((RecordConfigProvider)localObject2).remuxType = 2;
    }
    localObject3 = new VideoCaptureReportInfo();
    ((VideoCaptureReportInfo)localObject3).wwk = 1;
    ((RecordConfigProvider)localObject2).HLk = ((VideoCaptureReportInfo)localObject3);
    localObject3 = new UICustomParam.a();
    ((UICustomParam.a)localObject3).avW();
    ((UICustomParam.a)localObject3).avX();
    ((UICustomParam.a)localObject3).dZ(true);
    ((RecordConfigProvider)localObject2).HKT = ((UICustomParam.a)localObject3).jwj;
    localObject3 = new SnsTimeLineUI.65(this);
    CaptureDataManager.HKJ.HKI = ((CaptureDataManager.b)localObject3);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFJ, true))
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 17, i.a.sight_slide_bottom_in, i.a.sight_slide_bottom_out, (RecordConfigProvider)localObject2);
      AppMethodBeat.o(99393);
      return;
    }
    localObject2 = new Intent();
    com.tencent.mm.pluginsdk.ui.tools.u.a(getContext(), 17, (Intent)localObject2, 2, (String)localObject1);
    AppMethodBeat.o(99393);
  }
  
  private boolean gH(View paramView)
  {
    AppMethodBeat.i(193843);
    try
    {
      if (getContext() != null)
      {
        boolean bool = getContext().isFinishing();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(193843);
        return false;
      }
      Rect localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      paramView = new DisplayMetrics();
      getContext().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      int i = paramView.heightPixels;
      int j = this.mActionBar.getHeight() + com.tencent.mm.ui.ar.kI(this);
      Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "lxl checkItemVisible actionbar height:%s, total height:%s, screenHeight:%s, top:%s, bottom:%s", new Object[] { Integer.valueOf(this.mActionBar.getHeight()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localRect.top), Integer.valueOf(localRect.bottom) });
      if ((localRect.bottom > j) && (i > localRect.top))
      {
        AppMethodBeat.o(193843);
        return true;
      }
    }
    catch (Throwable paramView)
    {
      Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", paramView.toString());
      AppMethodBeat.o(193843);
      return false;
    }
    AppMethodBeat.o(193843);
    return false;
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(193822);
    Log.i("MicroMsg.SnsTimeLineUI", "onOtherAddSize respMaxSeq:%s, respMinSeq:%s", new Object[] { paramString1, paramString2 });
    this.Lad.removeCallbacks(this.KZD);
    com.tencent.mm.vending.g.g.ieN().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(193822);
  }
  
  public final void a(final String paramString, boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99373);
    this.Lad.removeCallbacks(this.KZD);
    com.tencent.mm.vending.g.g.ieN().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(99373);
  }
  
  public final void b(final String paramString, final boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(99374);
    this.Lad.removeCallbacks(this.KZD);
    com.tencent.mm.vending.g.g.ieN().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
    {
      private Void a(Void paramAnonymousVoid)
      {
        AppMethodBeat.i(249836);
        if (SnsTimeLineUI.l(SnsTimeLineUI.this) != null)
        {
          SnsTimeLineUI.m(SnsTimeLineUI.this);
          SnsTimeLineUI.l(SnsTimeLineUI.this).fXG();
        }
        SnsTimeLineUI.d(SnsTimeLineUI.this).tAQ = paramb.fMP();
        if (SnsTimeLineUI.this.Laj == 0)
        {
          Log.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[] { Boolean.valueOf(paramb.fMP()) });
          if (paramb.fMP()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).bcj(paramb.fMV());
          }
          AppMethodBeat.o(249836);
          return paramAnonymousVoid;
        }
        if ((paramBoolean) && (!SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))))
        {
          SnsTimeLineUI.d(SnsTimeLineUI.this).tAQ = true;
          SnsTimeLineUI.d(SnsTimeLineUI.this).bbU(paramb.fMV());
        }
        for (;;)
        {
          AppMethodBeat.o(249836);
          return paramAnonymousVoid;
          if ((SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))) && (paramb.fMU() != 0L))
          {
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vor, Long.valueOf(paramb.fMU()));
          }
          if (paramb.fMP()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).bcj(paramb.fMV());
          }
        }
      }
    });
    AppMethodBeat.o(99374);
  }
  
  public final void bev()
  {
    AppMethodBeat.i(99396);
    aII().bG(c.b.class);
    AppMethodBeat.o(99396);
  }
  
  public final void bew() {}
  
  public final void bex()
  {
    AppMethodBeat.i(99397);
    if (this.Lan)
    {
      AppMethodBeat.o(99397);
      return;
    }
    Log.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
    this.Lan = true;
    aj.etE().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(268631);
        if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
          SnsTimeLineUI.a(SnsTimeLineUI.this).Lgt.notifyVendingDataChange();
        }
        SnsTimeLineUI.af(SnsTimeLineUI.this);
        AppMethodBeat.o(268631);
      }
    }, 1000L);
    AppMethodBeat.o(99397);
  }
  
  public final void bey()
  {
    AppMethodBeat.i(99400);
    aII().bG(c.b.class);
    AppMethodBeat.o(99400);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(99378);
    Log.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[] { paramKeyEvent.toString() });
    int k = keyboardState();
    i locali = this.KZa;
    int i = j;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      i = j;
      if (locali.KBS.getVisibility() == 0)
      {
        locali.KBS.setVisibility(8);
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
  
  public final boolean fTI()
  {
    AppMethodBeat.i(99395);
    if ((this.KZa == null) || (this.KZa.KBZ == null))
    {
      AppMethodBeat.o(99395);
      return false;
    }
    if ((this.KZa == null) || (this.KZa.KCa == null))
    {
      if ((this.KZa != null) && (this.KZa.KCc != null)) {
        break label118;
      }
      label65:
      if ((this.KZa != null) && (this.KZa.KCd != null)) {
        break label132;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.fJx();
      boolean bool = this.KZa.KBZ.fTI();
      AppMethodBeat.o(99395);
      return bool;
      this.KZa.KCa.fQe();
      break;
      label118:
      this.KZa.KCc.fQe();
      break label65;
      label132:
      this.KZa.KCd.fYj();
    }
  }
  
  public final com.tencent.mm.plugin.sns.ad.f.l fXs()
  {
    return this.KPn;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(99399);
    Log.d("MicroMsg.SnsTimeLineUI", "finalize");
    super.finalize();
    AppMethodBeat.o(99399);
  }
  
  public final boolean gC(View paramView)
  {
    AppMethodBeat.i(99394);
    this.KZa.KCa.fQe();
    this.KZa.KCc.fQe();
    boolean bool = this.KZa.KBZ.d(paramView, false, false);
    AppMethodBeat.o(99394);
    return bool;
  }
  
  public int getLayoutId()
  {
    return i.g.sns_timeline_ui;
  }
  
  public void initView()
  {
    boolean bool3 = false;
    AppMethodBeat.i(99388);
    this.mUIAction.Kfp.setDrawingCacheEnabled(false);
    this.KZa.KdA = ((FrameLayout)findViewById(i.f.timeline_root));
    int i = aj.fOS().position;
    Object localObject = (AdListView)this.mUIAction.getSnsListView();
    ((AdListView)localObject).KAk = this.KPn;
    ((AdListView)localObject).setTimelineStat(this.KZi);
    ((AdListView)localObject).setTimelineEvent(this.KZj);
    this.KZj.a(aj.fOz());
    Log.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.KBX, new Object[] { Integer.valueOf(i) });
    this.KYX = ((QFadeImageView)findViewById(i.f.sns_refresh_iv));
    this.KYX.setImageResource(i.i.friendactivity_refresh);
    this.KZc = new a(this.mUIAction.getSnsListView());
    this.KZc.setInterpolator(new LinearInterpolator());
    this.KZc.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(205838);
        Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
        AppMethodBeat.o(205838);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(205837);
        Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
        AppMethodBeat.o(205837);
      }
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(205835);
        Log.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
        AppMethodBeat.o(205835);
      }
    });
    localObject = null;
    if (this.Laj == 1)
    {
      this.KYZ = true;
      localObject = new com.tencent.mm.plugin.sns.ui.a.b.d(this.pRV, this.KEq);
    }
    this.KYU = new com.tencent.mm.plugin.sns.ui.a.c(this, this.mUIAction.getSnsListView(), this.KZa.KCe, this.KZa, this.KZk, (com.tencent.mm.plugin.sns.ui.a.b.b)localObject, this.KZG);
    this.KZa.KCe.LpC = new bm.b()
    {
      public final boolean fXk()
      {
        AppMethodBeat.i(265219);
        SnsTimeLineUI.this.aII().bG(c.b.class);
        AppMethodBeat.o(265219);
        return false;
      }
    };
    this.KZa.Kee = this.KYU.Lgs;
    this.KYU.Lgt.Yzc = new com.tencent.mm.vending.a.b.a()
    {
      public final void fXC()
      {
        AppMethodBeat.i(265803);
        com.tencent.mm.plugin.report.service.g.ada(14);
        AppMethodBeat.o(265803);
      }
      
      public final void fXD()
      {
        AppMethodBeat.i(265806);
        com.tencent.mm.plugin.report.service.g.adb(14);
        AppMethodBeat.o(265806);
      }
    };
    this.KZd = ((TestTimeForSns)this.KZa.KdA);
    this.KZd.setListener(new TestTimeForSns.a()
    {
      public final void euB()
      {
        AppMethodBeat.i(203465);
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
              aj.fOy().af(aj.fOS().JZy, -1);
              aj.fOy().QO(aj.fOS().JZz);
            }
            Object localObject1;
            int i;
            if (!SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              Log.i("MicroMsg.SnsTimeLineUI", "onViewDrawed doFpList");
              localObject1 = aj.fOQ();
              Object localObject2 = "select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.state=" + x.KAd + " order by SnsWsFoldGroup.top desc limit 1";
              localObject1 = ((x)localObject1).lvy.rawQuery((String)localObject2, null, 2);
              if (localObject1 == null) {
                break label540;
              }
              if (!((Cursor)localObject1).moveToFirst()) {
                break label535;
              }
              localObject2 = new com.tencent.mm.plugin.sns.storage.w();
              ((com.tencent.mm.plugin.sns.storage.w)localObject2).convertFrom((Cursor)localObject1);
              i = ((com.tencent.mm.plugin.sns.storage.w)localObject2).field_size;
              ((Cursor)localObject1).close();
            }
            for (;;)
            {
              Log.i("MicroMsg.SnsTimeLineUI", "oldWsFoldSize:%s newWsFoldSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(ah.JXi) });
              if ((i != -1) && (i != ah.JXi))
              {
                localObject1 = aj.fOQ();
                long l = System.currentTimeMillis();
                Log.i("MicroMsg.SnsWsFoldGroupStorage", "dropTable:%s %s", new Object[] { Boolean.valueOf(((x)localObject1).lvy.execSQL("SnsWsFoldGroup", "DELETE FROM SnsWsFoldGroup")), Long.valueOf(System.currentTimeMillis() - l) });
                localObject1 = aj.fOR();
                l = System.currentTimeMillis();
                boolean bool = ((com.tencent.mm.plugin.sns.storage.v)localObject1).lvy.execSQL("SnsWsFoldGroupDetail", "DELETE FROM SnsWsFoldGroupDetail");
                ((com.tencent.mm.plugin.sns.storage.v)localObject1).KAc.clear();
                Log.i("MicroMsg.SnsWsFoldDetailStorage", "dropTable:%s %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
              }
              localObject1 = SnsTimeLineUI.r(SnsTimeLineUI.this);
              SnsTimeLineUI.n(SnsTimeLineUI.this).getType();
              ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vwx, Integer.valueOf(1));
              SnsTimeLineUI.a(SnsTimeLineUI.this, false);
              if (SnsTimeLineUI.this.KPn != null) {
                SnsTimeLineUI.this.KPn.fKR();
              }
              AppMethodBeat.o(176335);
              return;
              label535:
              i = -1;
              break;
              label540:
              i = -1;
            }
          }
        });
        AppMethodBeat.o(203465);
      }
    });
    this.mUIAction.list.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(217371);
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          SnsTimeLineUI.this.fTI();
          if ((SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) && (SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() == 0)) {
            Log.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
          }
          SnsTimeLineUI.l(SnsTimeLineUI.this).fXH();
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          }
          SnsTimeLineUI.k(SnsTimeLineUI.this).fTl();
          SnsTimeLineUI.k(SnsTimeLineUI.this).KBT.fYi();
        }
        AppMethodBeat.o(217371);
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
        SnsTimeLineUI.k(SnsTimeLineUI.this).KBT.KOU = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getBottom();
        SnsTimeLineUI.k(SnsTimeLineUI.this).KBT.LfM = SnsTimeLineUI.d(SnsTimeLineUI.this).ETx.getTop();
        SnsTimeLineUI.l(SnsTimeLineUI.this).LaT = com.tencent.mm.ui.aw.fromDPToPix(SnsTimeLineUI.this.getContext(), -44);
        AppMethodBeat.o(176343);
      }
    });
    this.mUIAction.ETx.setOnSrcollDistance(new MMPullDownView.f()
    {
      public final void cg(float paramAnonymousFloat)
      {
        AppMethodBeat.i(259088);
        SnsTimeLineUI.Q(SnsTimeLineUI.this);
        if (SnsTimeLineUI.KZY.booleanValue()) {
          Log.i("MicroMsg.SnsTimeLineUI", "mUIAction.header.getTop %s originalHeaderTop %s distanceY %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).Kfp.getTop()), Integer.valueOf(SnsTimeLineUI.l(SnsTimeLineUI.this).LaT), Float.valueOf(paramAnonymousFloat) });
        }
        if (((paramAnonymousFloat > 0.0F) || (SnsTimeLineUI.R(SnsTimeLineUI.this))) && ((SnsTimeLineUI.d(SnsTimeLineUI.this).Kfp.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).LaT) || (paramAnonymousFloat > 0.0F)) && (!SnsTimeLineUI.d(SnsTimeLineUI.this).KJB)) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).ch(paramAnonymousFloat);
        }
        SnsTimeLineUI.k(SnsTimeLineUI.this).fTl();
        SnsTimeLineUI.this.fTI();
        SnsTimeLineUI.k(SnsTimeLineUI.this).KBT.fYi();
        AppMethodBeat.o(259088);
      }
      
      public final void fXE()
      {
        AppMethodBeat.i(259090);
        if (!SnsTimeLineUI.d(SnsTimeLineUI.this).KJB) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).fXH();
        }
        if (SnsTimeLineUI.R(SnsTimeLineUI.this))
        {
          SnsTimeLineUI.b(SnsTimeLineUI.this, false);
          AppMethodBeat.o(259090);
          return;
        }
        SnsTimeLineUI.b(SnsTimeLineUI.this, true);
        AppMethodBeat.o(259090);
      }
    });
    this.KZa.KBS = ((SnsCommentFooter)findViewById(i.f.comment_footer));
    this.KZa.KBS.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99338);
        com.tencent.mm.compatible.util.i.u(SnsTimeLineUI.this);
        AppMethodBeat.o(99338);
      }
    });
    this.KZa.KBT = new bw(this.mUIAction.list, this.KZa.KBS);
    this.KYV = ((LinearLayout)this.mUIAction.Kfp.findViewById(i.f.sns_notify_list));
    this.KYV.findViewById(i.f.sns_notify_for_click).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179269);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).KBO != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).KBO.JZd.yz(true);
        }
        paramAnonymousView = (c.b)SnsTimeLineUI.this.aII().m(c.b.class);
        localObject = com.tencent.mm.modelsns.l.wO(725);
        ((com.tencent.mm.modelsns.l)localObject).wR(paramAnonymousView.BTV);
        ((com.tencent.mm.modelsns.l)localObject).bpa();
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
        paramAnonymousView.putExtra("sns_msg_comment_list_scene", 1);
        SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 13);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$54", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179269);
      }
    });
    this.KYW = ((LinearLayout)this.mUIAction.Kfp.findViewById(i.f.sns_notify_media_content_collapse));
    this.KZa.KBU = new bd(this);
    fXn();
    fXo();
    boolean bool1;
    label591:
    boolean bool2;
    if (this.Laj == 0)
    {
      setMMTitle(i.j.sns_timeline_ui_title);
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
        break label923;
      }
      bool1 = true;
      if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vTZ, 0)) {
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
        com.tencent.mm.plugin.report.service.h.IzE.el(1198, 7);
      }
    }
    for (;;)
    {
      this.KZs = ((ViewGroup)findViewById(i.f.sns_unread_tip_group));
      this.KZs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(268772);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$55", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          SnsTimeLineUI.k(SnsTimeLineUI.this).fTr();
          com.tencent.mm.plugin.sns.k.g.Kia.KiI.gWi = 2L;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$55", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268772);
        }
      });
      this.KZs.setVisibility(4);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = (com.tencent.mm.ui.aw.fromDPToPix(getContext(), 24) + ax.ew(getContext()) + ax.getStatusBarHeight(getContext()));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.KZs.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(99388);
      return;
      if (this.KEq)
      {
        setMMTitle(i.j.sns_photo_ui_title);
        aho(8);
        break;
      }
      Log.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, userName:%s, title:%s", new Object[] { this.pRV, this.mUIAction.title });
      localObject = aj.fOw().RG(this.pRV);
      if (localObject != null) {
        Log.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is not null");
      }
      for (localObject = ((com.tencent.mm.contact.d)localObject).ays();; localObject = this.mUIAction.title)
      {
        setMMTitle(com.tencent.mm.plugin.sns.data.t.af((CharSequence)localObject));
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
        com.tencent.mm.plugin.report.service.h.IzE.el(1198, 8);
      } else if (i <= 6144) {
        com.tencent.mm.plugin.report.service.h.IzE.el(1198, 9);
      } else if (i <= 8192) {
        com.tencent.mm.plugin.report.service.h.IzE.el(1198, 10);
      } else {
        com.tencent.mm.plugin.report.service.h.IzE.el(1198, 11);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99402);
    Log.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 15)
    {
      if ((this.KZa != null) && (this.KZa.KCe != null) && (this.KZa.KCe.LoP != null))
      {
        this.KZa.KCe.LoP.onActivityResult(paramInt1, paramInt2, paramIntent);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(218485);
            SnsTimeLineUI.this.hideVKB();
            AppMethodBeat.o(218485);
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
          this.KZa.KBS.iXq.showVKB();
          String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(localObject[0]);
          if (!Util.isNullOrNil(str))
          {
            this.KZa.KBS.fWl();
            this.KZa.KBS.setText("@" + str + " ");
            this.KZa.KBS.setCommentAtPrefix("@" + str + " ");
            this.KZa.KBS.setCommentInfo(new ejo());
            this.KZa.KBS.getCommentInfo().Username = localObject[0];
            this.KZa.KBS.setCommentFlag(8);
          }
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mUIAction.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 11)
    {
      paramIntent = this.KYT;
      this.Laf.getType();
      paramIntent.d(this.pRV, this.KZl, this.KEq, this.KZm);
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
    EventCenter.instance.publish(new cp());
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    Point localPoint = new Point();
    localPoint.x = paramConfiguration.widthPixels;
    localPoint.y = paramConfiguration.heightPixels;
    aj.k(localPoint);
    com.tencent.mm.plugin.sns.ui.widget.f.fZG().LtK = 0;
    com.tencent.mm.plugin.sns.ui.widget.d.fZD().LtK = 0;
    com.tencent.mm.kiss.widget.textview.c.kfZ.aIM();
    this.KYU.Lgs.fXa();
    this.KYU.Lgt.resolvedClear();
    AppMethodBeat.o(99382);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99379);
    Object localObject1;
    if (KZo == null)
    {
      KZo = Boolean.valueOf(com.tencent.mm.ui.ar.isDarkMode());
      com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
      com.tencent.mm.plugin.sns.model.b.a.fPW();
      localObject1 = aj.fOG();
      ((com.tencent.mm.plugin.sns.model.ay)localObject1).mgI = true;
      Log.i("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.sns.model.ay)localObject1).mgI) });
      if (((((com.tencent.mm.plugin.sns.model.ay)localObject1).mgI) && (!com.tencent.mm.plugin.sns.model.b.a.fPX())) || (((com.tencent.mm.plugin.sns.model.ay)localObject1).mgH)) {
        ((com.tencent.mm.plugin.sns.model.ay)localObject1).dMv();
      }
      com.tencent.mm.modelvideo.s.bqD().gB(((com.tencent.mm.plugin.sns.model.ay)localObject1).mgI);
      localObject1 = aj.fOT();
      if (!BuildInfo.DEBUG) {
        break label1110;
      }
      ((av)localObject1).Kap = true;
      ((av)localObject1).Kaq = 1L;
      ((av)localObject1).Kar = 86400L;
      ((av)localObject1).Kas = 1;
      ((av)localObject1).Kat = 1;
      ((av)localObject1).Kau = 50;
      ((av)localObject1).Kaw = 2;
      ((av)localObject1).Kav = 5;
      ((av)localObject1).Kax = 0L;
      label168:
      Log.i("MicroMsg.SnsUnreadTipManager", "jumpEnable:%s, jumpMinInterval:%s, jumpMaxInterval:%s, jumpMinFeedsCount:%s, jumpMinFeedsGapCount:%s, jumpNotWsPercent:%s, jumpIndicatorIndexOffset:%s, jumpReadContinuousCount:%s, jumpIndicatorExposeInterval:%s", new Object[] { Boolean.valueOf(((av)localObject1).Kap), Long.valueOf(((av)localObject1).Kaq), Long.valueOf(((av)localObject1).Kar), Integer.valueOf(((av)localObject1).Kas), Integer.valueOf(((av)localObject1).Kat), Integer.valueOf(((av)localObject1).Kau), Integer.valueOf(((av)localObject1).Kaw), Integer.valueOf(((av)localObject1).Kav), Long.valueOf(((av)localObject1).Kax) });
      if (((av)localObject1).Kap) {
        ((av)localObject1).Kao = (aj.getAccSnsPath() + "snsUnread.proto");
      }
    }
    int i;
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.mm.vfs.u.aY(((av)localObject1).Kao, 0, -1);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          ((av)localObject1).KaL.parseFrom((byte[])localObject2);
          i = cm.bfF();
          Log.i("MicroMsg.SnsUnreadTipManager", "unreadSnsIdList.indicatorExposeTime:%s, now:%s, jumpIndicatorExposeInterval:%s", new Object[] { Long.valueOf(((av)localObject1).KaL.KaQ), Integer.valueOf(i), Long.valueOf(((av)localObject1).Kax) });
          if ((((av)localObject1).KaL.KaQ <= 0L) || (i - ((av)localObject1).KaL.KaQ <= ((av)localObject1).Kax)) {
            continue;
          }
          ((av)localObject1).KaL.KaQ = 0L;
          ((av)localObject1).KaQ = ((av)localObject1).KaL.KaQ;
          ((av)localObject1).fPz();
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
        as.JZU = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vNi, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vNh, 1) != 1) {
          continue;
        }
        bool = true;
        as.JZV = bool;
        as.JZW = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vNj, 60);
        continue;
        bool = false;
        continue;
        long l = as.JZU - Util.milliSecondsToNow(((as)localObject1).JZX);
        Log.i(as.TAG, "delay %s to reset", new Object[] { Long.valueOf(l) });
        MMHandlerThread.postToMainThreadDelayed(((as)localObject1).Kab, l);
        continue;
        MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVSnsUI", true);
        this.Cwk = findViewById(i.f.action_bar_container);
        if (this.Cwk == null) {
          break label1594;
        }
      }
      ((av)localObject1).fPx();
      ((av)localObject1).fPy();
      Log.i("MicroMsg.SnsUnreadTipManager", "firstUnreadId:%s unreadSnsIdList.lastSnsId:%s", new Object[] { Long.valueOf(((av)localObject1).KaC), Long.valueOf(((av)localObject1).KaL.Kfg) });
      ((av)localObject1).fPA();
      ((av)localObject1).sessionId = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbs();
      localObject1 = ((av)localObject1).KaW;
      com.tencent.mm.kernel.h.aHF().kcd.a(211, (com.tencent.mm.an.i)localObject1);
      ((com.tencent.mm.plugin.sns.model.au)localObject1).Kan = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVS, 50);
      Log.i("MicroMsg.SnsUnreadPreloader", "onCreate PRELOAD_MAX_COUNT:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).Kan) });
      localObject1 = aj.fOU();
      Log.i(as.TAG, "create");
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
      {
        as.JZU = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vNi, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vNh, 1) == 1)
        {
          bool = true;
          as.JZV = bool;
          as.JZW = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vNj, 60);
          Log.i(as.TAG, "updateConfig configEnable:%s, configInterval:%s, configExpiredTime:%s", new Object[] { Boolean.valueOf(as.JZV), Integer.valueOf(as.JZW), Long.valueOf(as.JZU) });
          if (((as)localObject1).JZX != 0L)
          {
            if (Util.milliSecondsToNow(((as)localObject1).JZX) < as.JZU) {
              continue;
            }
            Log.i(as.TAG, "already expired, reset directly");
            MMHandlerThread.postToMainThread(((as)localObject1).Kab);
            if (((as)localObject1).JZZ != null)
            {
              localObject2 = com.tencent.mm.plugin.sns.model.an.D(((as)localObject1).JZZ);
              if (localObject2 != null)
              {
                com.tencent.mm.plugin.sns.k.g.Kia.KiJ.Dy(((as)localObject1).Kaa);
                com.tencent.mm.plugin.sns.k.g.Kia.KiJ.Dx(com.tencent.mm.plugin.sns.data.t.Qv(((as)localObject1).JZZ.field_snsId));
                com.tencent.mm.plugin.sns.k.g.Kia.KiJ.gWs = ((SnsObject)localObject2).LikeCount;
                com.tencent.mm.plugin.sns.k.g.Kia.KiJ.gWt = ((SnsObject)localObject2).CommentCount;
                com.tencent.mm.plugin.sns.k.g.Kia.KiJ.Dz(String.valueOf(System.currentTimeMillis()));
                com.tencent.mm.plugin.sns.k.g.Kia.KiK.Dy(((as)localObject1).Kaa);
                com.tencent.mm.plugin.sns.k.g.Kia.KiK.Dx(com.tencent.mm.plugin.sns.data.t.Qv(((as)localObject1).JZZ.field_snsId));
                com.tencent.mm.plugin.sns.k.g.Kia.KiK.gWs = ((SnsObject)localObject2).LikeCount;
                com.tencent.mm.plugin.sns.k.g.Kia.KiK.gWt = ((SnsObject)localObject2).CommentCount;
                com.tencent.mm.plugin.sns.k.g.Kia.KiK.Dz(String.valueOf(System.currentTimeMillis()));
              }
            }
          }
          if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class) != null) {
            ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apd("__sns_timeline__");
          }
          if (this.mController != null) {
            this.mController.bS(2, true);
          }
          getIntent().setExtrasClassLoader(getClass().getClassLoader());
          com.tencent.mm.pluginsdk.h.r(this);
          customfixStatusbar(true);
          super.onCreate(paramBundle);
          if (com.tencent.mm.kernel.h.aHE().aGM()) {
            continue;
          }
          finish();
          AppMethodBeat.o(99379);
          return;
          if (KZo.booleanValue() == com.tencent.mm.ui.ar.isDarkMode()) {
            break;
          }
          Log.i("MicroMsg.SnsTimeLineUI", "dancy test UIMode change!!");
          KZo = Boolean.valueOf(com.tencent.mm.ui.ar.isDarkMode());
          com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
          break;
          if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
          {
            bool = true;
            ((av)localObject1).Kap = bool;
            ((av)localObject1).Kaq = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVJ, 3600);
            ((av)localObject1).Kas = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVK, 5);
            ((av)localObject1).Kat = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVM, 10);
            ((av)localObject1).Kar = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVN, 86400L);
            ((av)localObject1).Kau = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVO, 0);
            ((av)localObject1).Kaw = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVQ, 1);
            ((av)localObject1).Kav = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVP, 2);
            ((av)localObject1).Kax = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVR, 14400);
            break label168;
          }
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVL, 1) == 1)
          {
            bool = true;
            continue;
          }
          bool = false;
          continue;
          if (((av)localObject1).KaL.KaQ >= 0L) {
            continue;
          }
          ((av)localObject1).KaL.KaQ = 0L;
          continue;
        }
      }
      if (com.tencent.mm.ui.statusbar.c.XMC) {
        break label3962;
      }
    }
    label1594:
    getWindow().getDecorView().setSystemUiVisibility(1280);
    paramBundle = MMApplicationContext.getDefaultPreference();
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("Main_need_read_top_margin", false);; bool = false) {
      for (;;)
      {
        com.tencent.mm.ui.c.f(this, bool);
        this.KZb = ((int)(getResources().getDisplayMetrics().heightPixels * 0.4D));
        setActionbarColor(getContext().getResources().getColor(i.c.transparent));
        hideActionbarLine();
        this.Laj = getIntent().getIntExtra("sns_adapter_type", 0);
        this.KYZ = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
        this.mActionBar = getSupportActionBar();
        i = com.tencent.mm.model.c.d.bgC().buT("Sns_Private_Recent_Setting_Guide");
        Log.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = ".concat(String.valueOf(i)));
        if (i == 1)
        {
          com.tencent.mm.kernel.h.aHH();
          if (!com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vow, false))
          {
            paramBundle = getIntent();
            paramBundle.setClass(getContext(), SnsSettingIntroduceUI.class);
            paramBundle = new com.tencent.mm.hellhoundlib.b.a().bm(paramBundle);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aFh(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramBundle.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            overridePendingTransition(0, 0);
            finish();
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vow, Boolean.TRUE);
          }
        }
        com.tencent.mm.plugin.sns.ad.timeline.c.b.a.fLD();
        this.KZr.KUC = new bh.b()
        {
          public final void fWK()
          {
            AppMethodBeat.i(269371);
            SnsTimeLineUI.J(SnsTimeLineUI.this);
            AppMethodBeat.o(269371);
          }
        };
        fXm();
        com.tencent.e.h.ZvG.be(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(211530);
            Log.i("MicroMsg.SnsTimeLineUI", "%s", new Object[] { com.tencent.mm.plugin.performance.watchdogs.c.fou().ad(true, 0) });
            AppMethodBeat.o(211530);
          }
        });
        this.KYS.a(c.b.class, this.Lah);
        localObject1 = this.KYT;
        i = this.Laj;
        this.Laf.getType();
        paramBundle = getIntent();
        com.tencent.mm.plugin.sns.m.b localb = this.KYR;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).Laj = i;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = true;
        Object localObject3;
        if (i == 0)
        {
          localObject3 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgN;
          ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject3).KYR = localb;
          if (localb != null)
          {
            paramBundle = localb.fZK();
            label2007:
            ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject3).KYS = paramBundle;
            ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgN.KYS.a(this);
            label2025:
            paramBundle = this.KYT;
            if (paramBundle.Laj != 0) {
              break label4182;
            }
            paramBundle = (com.tencent.mm.plugin.sns.m.c.a)paramBundle.LgN.KYS.m(com.tencent.mm.plugin.sns.m.c.a.class);
            label2054:
            this.pRV = paramBundle.pRV;
            this.KZk = paramBundle.KZk;
            this.KZl = paramBundle.KZl;
            this.KEq = paramBundle.KEq;
            this.KZm = paramBundle.KZm;
            localObject1 = paramBundle.njH;
            paramBundle = paramBundle.mSignature;
            this.mSessionId = com.tencent.mm.ui.f.bjQ("123");
            this.KZn = String.valueOf(System.currentTimeMillis());
            this.mUIAction = new SnsUIAction(this);
            this.mUIAction.setSessionId(this.mSessionId);
            this.mUIAction.Khd = this.KZn;
            this.mUIAction.LcD = this.Laf;
            this.mUIAction.actionbarView = this.mActionBar.getCustomView();
            ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().qh(2);
            com.tencent.mm.plugin.sns.ui.widget.f.fZG().LtK = 0;
            com.tencent.mm.plugin.sns.ui.widget.d.fZD().LtK = 0;
            localObject3 = com.tencent.mm.modelsns.m.mby;
            com.tencent.mm.modelsns.m.bpb();
            if (!getIntent().getBooleanExtra("is_sns_notify_open", true)) {
              break label4190;
            }
            i = 1;
            label2242:
            this.KZa = new i(this, i, Util.nullAs(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0), this.KZn);
            this.KZa.KBR = new i.b()
            {
              public final void fTr()
              {
                AppMethodBeat.i(238267);
                com.tencent.mm.plugin.report.service.h.IzE.el(1295, 2);
                Object localObject = aj.fOT();
                if (((av)localObject).Kap) {
                  aj.fwa().post(new av.5((av)localObject));
                }
                com.tencent.mm.plugin.sns.k.g.Kia.KiI.gWh = 1L;
                localObject = aj.fOT();
                int i;
                if ((!((av)localObject).fPw()) || (((av)localObject).KaA.get(((av)localObject).KaM.wHq.peek()) == null))
                {
                  i = -1;
                  localObject = aj.fOT();
                  if (((av)localObject).fPw()) {
                    break label391;
                  }
                }
                com.tencent.mm.hellhoundlib.b.a locala;
                label391:
                for (int j = 0;; j = ((av)localObject).KaM.wHq.size())
                {
                  Log.d("MicroMsg.SnsTimeLineUI", "rightIndex:%s, targetSize:%s, adapter.count:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) });
                  aj.fOT().gq(null);
                  SnsTimeLineUI.K(SnsTimeLineUI.this).setVisibility(4);
                  if ((i == -1) || (j + i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount())) {
                    break label406;
                  }
                  aj.fOT().fPE();
                  aj.fOT().KaG = 0L;
                  j = SnsTimeLineUI.this.getResources().getDimensionPixelSize(i.d.sns_timeline_top_margin);
                  int k = ax.ew(SnsTimeLineUI.this.getContext());
                  int m = ax.getStatusBarHeight(SnsTimeLineUI.this.getContext());
                  localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                  locala = com.tencent.mm.hellhoundlib.b.c.a(i + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), com.tencent.mm.hellhoundlib.b.c.a(k + m - j, new com.tencent.mm.hellhoundlib.b.a()));
                  com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                  ((ListView)localObject).smoothScrollToPositionFromTop(((Integer)locala.sf(0)).intValue(), ((Integer)locala.sf(1)).intValue());
                  com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                  AppMethodBeat.o(238267);
                  return;
                  i = ((Integer)((av)localObject).KaA.get(((av)localObject).KaM.wHq.peek())).intValue();
                  break;
                }
                label406:
                if (!aj.fOT().KaJ)
                {
                  aj.fOT().fPE();
                  aj.fOT().KaJ = true;
                  SnsTimeLineUI.a(SnsTimeLineUI.this).Lgt.bcl(com.tencent.mm.plugin.sns.data.t.Qv(SnsTimeLineUI.a(SnsTimeLineUI.this).fYl()));
                  SnsTimeLineUI.a(SnsTimeLineUI.this).Lgt.bcm(com.tencent.mm.plugin.sns.data.t.Qv(SnsTimeLineUI.a(SnsTimeLineUI.this).zg(false)));
                  aj.fOT().KaG = aj.fOT().fPC();
                  aj.fOy().QO(aj.fOT().fPC());
                  aj.fOT().KaH = com.tencent.mm.plugin.sns.model.aw.Kbj;
                  localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                  locala = com.tencent.mm.hellhoundlib.b.c.a(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount() - 1 + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), new com.tencent.mm.hellhoundlib.b.a());
                  com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                  ((ListView)localObject).smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
                  com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                  if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
                  {
                    SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
                    SnsTimeLineUI.B(SnsTimeLineUI.this).post(SnsTimeLineUI.C(SnsTimeLineUI.this));
                  }
                }
                AppMethodBeat.o(238267);
              }
            };
            this.KBX = getIntent().getBooleanExtra("sns_resume_state", true);
            if (!aj.isInValid()) {
              break label4195;
            }
            this.KBX = false;
            label2327:
            this.KYY = this.KBX;
            this.mUIAction.a(this.KZk, this.pRV, (String)localObject1, paramBundle, this.KZl, this.KEq, this.KZm);
            this.mUIAction.onCreate();
            aj.fOz().init();
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(213, this);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(682, this);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(218, this);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(211, this);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(683, this);
            com.tencent.mm.plugin.sns.ui.video.e.fZg().fZh();
            initView();
            paramBundle = aj.fOz();
            localObject1 = this.mUIAction.list;
            localObject3 = this.KYU.Lgs;
            paramBundle.Ked = ((ListView)localObject1);
            paramBundle.Kee = ((bm)localObject3);
            paramBundle = aj.fOz();
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(291, paramBundle);
            if (!aj.isInValid()) {
              break label4215;
            }
            this.KBX = false;
            label2539:
            paramBundle = this.KYS;
            paramBundle.Lgt = this.KYU.Lgt;
            localObject1 = paramBundle.Lgt;
            paramBundle.Yzd.keep((com.tencent.mm.vending.e.a)localObject1);
            if ((!this.KBX) || (this.Laj != 0)) {
              break label4235;
            }
            this.KYZ = false;
            int j = aj.fOS().position;
            this.KYU.Lgt.bcn(aj.fOS().wtB);
            this.KYU.Lgt.bck(aj.fOS().KJw);
            this.KYU.Lgt.zh(true);
            this.KYU.Lgt.bco(aj.fOS().KJz);
            this.KYU.Lgt.bcl(aj.fOS().KJx);
            this.KYU.Lgt.bcm(aj.fOS().KJy);
            this.mUIAction.zd(aj.fOS().KJB);
            this.KYU.tA();
            i = j;
            if (j >= this.KYU.getCount())
            {
              i = this.KYU.getCount() - 1;
              Log.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[] { Integer.valueOf(this.KYU.getCount()) });
            }
            this.mUIAction.list.setAdapter(this.KYU);
            Log.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[] { Integer.valueOf(aj.fOS().KJA) });
            this.mUIAction.list.setSelectionFromTop(i, aj.fOS().KJA);
            aho(4);
            label2817:
            fXl();
            i = this.KYU.getCount();
            j = this.mUIAction.list.getFirstVisiblePosition();
            if (j < i) {
              this.KZg = com.tencent.mm.plugin.sns.data.t.w(this.KYU.agM(j));
            }
            com.tencent.mm.kernel.h.aHH();
            this.KZe = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(327776, Integer.valueOf(0))).intValue();
            this.KZa.KBZ = new bv(this, this.KYU.Lgs, this.KZa.KdA);
            this.KZa.KCb = new com.tencent.mm.plugin.sns.h.b(this, this.KYU.Lgs.Kdz, this.KZa.KdA);
            this.KZa.KCa = new b(this, this.KYU.Lgs.Kdz, this.KZa.KdA, this.KZa.KCb);
            this.KZa.KCa.JHg = this.KPn;
            this.KZa.KCc = new ar(this, this.KYU.Lgs.Kdz, this.KZa.KdA);
            this.KZa.KCd = new bx(this, this.KYU.Lgs.Kdz, this.KZa.KdA);
            if (this.KZj != null) {
              this.KZj.a(this.KZa.KCb);
            }
            if (i > 0)
            {
              paramBundle = this.KYU.agM(0);
              if ((this.KZa.KBO != null) && (this.KZa.KBO.JZd != null)) {
                this.KZa.KBO.JZd.KfN = paramBundle.field_snsId;
              }
              paramBundle = com.tencent.mm.plugin.sns.k.g.Kia;
              if (paramBundle.jXZ != 0)
              {
                if (paramBundle.Kib.isEmpty())
                {
                  paramBundle.iRa.setLong(2, Util.nowSecond());
                  paramBundle.Kic.clear();
                }
                Log.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[] { Integer.valueOf(paramBundle.Kib.size()) });
              }
            }
            com.tencent.mm.plugin.report.service.h.IzE.kvStat(13312, "1," + Util.nowMilliSecond());
            EventCenter.instance.addListener(this.KZE);
            if (getIntent().getBooleanExtra("is_need_resend_sns", false))
            {
              MMHandlerThread.postToMainThreadDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(99317);
                  com.tencent.mm.ui.base.h.c(SnsTimeLineUI.this, SnsTimeLineUI.this.getString(i.j.notification_need_resend_dialog_prompt), "", SnsTimeLineUI.this.getString(i.j.notification_need_resend_dialog_prompt_resend_now), SnsTimeLineUI.this.getString(i.j.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(99307);
                      paramAnonymous2DialogInterface = new tl();
                      EventCenter.instance.publish(paramAnonymous2DialogInterface);
                      AppMethodBeat.o(99307);
                    }
                  }, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(99308);
                      paramAnonymous2DialogInterface = new pf();
                      EventCenter.instance.publish(paramAnonymous2DialogInterface);
                      AppMethodBeat.o(99308);
                    }
                  });
                  AppMethodBeat.o(99317);
                }
              }, 500L);
              getIntent().putExtra("is_need_resend_sns", false);
            }
            com.tencent.mm.kernel.h.aHH();
            if (com.tencent.mm.kernel.h.aHE().aGM())
            {
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHG().aHp().i(589825, Boolean.FALSE);
            }
            this.KZa.b(this.KPn);
            this.KPn.a(this.mUIAction.APq, this.mActionBar.getCustomView(), this);
            EventCenter.instance.addListener(this.KZK);
            EventCenter.instance.addListener(this.KZL);
            EventCenter.instance.addListener(this.KZM);
            EventCenter.instance.addListener(this.KZN);
            EventCenter.instance.addListener(this.KZO);
            EventCenter.instance.addListener(this.KZQ);
            EventCenter.instance.addListener(this.KZP);
            EventCenter.instance.addListener(this.Kbv);
            EventCenter.instance.addListener(this.KZR);
            EventCenter.instance.addListener(this.KZS);
            EventCenter.instance.addListener(this.KZU);
            EventCenter.instance.addListener(this.KZT);
            EventCenter.instance.addListener(this.KZV);
            EventCenter.instance.addListener(this.KZX);
            com.tencent.mm.plugin.sns.abtest.c.fJC();
            com.tencent.mm.plugin.sns.abtest.a.d(this, this.KZa.KdA);
            if (this.KZh != null)
            {
              paramBundle = this.KZh;
              localObject1 = this.mUIAction.list;
              localObject3 = this.mUIAction.Kfp;
              paramBundle.kJh = ((ListView)localObject1);
              paramBundle.Kfp = ((SnsHeader)localObject3);
            }
            if ((this.KZa != null) && (this.KZa.KBO != null))
            {
              paramBundle = this.KZa.KBO.JZd;
              Log.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
              paramBundle.KfM = true;
              paramBundle.KhK = System.currentTimeMillis();
            }
            bool = getIntent().getBooleanExtra("enter_by_red", false);
            if ((this.KZa != null) && (this.KZa.KBO != null))
            {
              paramBundle = this.KZa.KBO.JZd;
              if (!bool) {
                break label4264;
              }
              i = 1;
              label3658:
              paramBundle.KfZ = i;
            }
            aj.fOF().JUd.clear();
            if ((this.mUIAction != null) && (this.mUIAction.Kfp != null)) {
              this.mUIAction.Kfp.setStoryAction(new SnsStoryHeaderView.a()
              {
                public final void fXB()
                {
                  AppMethodBeat.i(195321);
                  SnsTimeLineUI.a locala = SnsTimeLineUI.l(SnsTimeLineUI.this);
                  if (SnsTimeLineUI.u(locala.Lao).getVisibility() == 0)
                  {
                    locala.init();
                    SnsTimeLineUI.u(locala.Lao).clearAnimation();
                    SnsTimeLineUI.u(locala.Lao).startAnimation(locala);
                    locala.Rn(locala.GzF + 100);
                    locala.LaS = false;
                  }
                  AppMethodBeat.o(195321);
                }
              });
            }
            ((com.tencent.mm.plugin.findersdk.a.p)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.p.class)).Pf(3);
            if (!Util.isNullOrNil(com.tencent.mm.model.z.bdh())) {
              break label4269;
            }
            this.KZy = 0;
            label3736:
            if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED)) {
              break label4302;
            }
            paramBundle = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vUv, "{\"enable\":2,\"max_count_no_user\":0,\"max_count_no_feed\":0,\"max_count_normal\":0}");
            if (Util.isNullOrNil(paramBundle)) {}
          }
        }
        try
        {
          paramBundle = new JSONObject(paramBundle);
          this.KZu = paramBundle.getInt("enable");
          this.KZv = paramBundle.getInt("max_count_no_user");
          this.KZw = paramBundle.getInt("max_count_no_feed");
          this.KZx = paramBundle.getInt("max_count_normal");
          if (ac.mGU > 0)
          {
            this.KZu = ac.mGU;
            if (ac.mGU == 1)
            {
              this.KZv = -1;
              this.KZw = -1;
              this.KZx = -1;
            }
          }
          Log.i("MicroMsg.SnsTimeLineUI", "curFinderStatus:%s, finderEntranceEnable:%s, finderEntranceMaxCountNoUser:%s, finderEntranceMaxCountNoFeed:%s, finderEntranceMaxCountNormal:%s", new Object[] { Integer.valueOf(this.KZy), Integer.valueOf(this.KZu), Integer.valueOf(this.KZv), Integer.valueOf(this.KZw), Integer.valueOf(this.KZx) });
          ah.fOm();
          EventCenter.instance.addListener(this.KZF);
          paramBundle = com.tencent.mm.plugin.sns.i.a.KeP;
          com.tencent.mm.plugin.sns.i.a.a.ia(this);
          AppMethodBeat.o(99379);
          return;
          label3962:
          paramBundle = com.tencent.mm.ui.statusbar.c.bA(this);
          localObject1 = new com.tencent.mm.ui.statusbar.c.a()
          {
            public final void BF(int paramAnonymousInt)
            {
              AppMethodBeat.i(226506);
              SnsTimeLineUI.t(SnsTimeLineUI.this).setPadding(0, paramAnonymousInt, 0, 0);
              AppMethodBeat.o(226506);
            }
          };
          this.Cwl = ((com.tencent.mm.ui.statusbar.c.a)localObject1);
          paramBundle.a((com.tencent.mm.ui.statusbar.c.a)localObject1);
          getWindow().getDecorView().requestApplyInsets();
          com.tencent.mm.ui.statusbar.d.e(getWindow());
          break;
          paramBundle = null;
          break label2007;
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgO = new com.tencent.mm.plugin.sns.m.c.a();
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgO.pRV = paramBundle.getStringExtra("sns_userName");
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgO.KZk = com.tencent.mm.model.z.bcZ();
          localObject3 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgO;
          com.tencent.mm.kernel.h.aHH();
          ((com.tencent.mm.plugin.sns.m.c.a)localObject3).KZl = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwd(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgO.pRV);
          localObject3 = com.tencent.mm.model.z.bcZ();
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgO.KEq = ((String)localObject3).equals(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgO.pRV);
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgO.KZm = paramBundle.getIntExtra("sns_source", 0);
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgO.njH = Util.nullAs(paramBundle.getStringExtra("sns_nickName"), "");
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgO.mSignature = Util.nullAs(paramBundle.getStringExtra("sns_signature"), "");
          break label2025;
          label4182:
          paramBundle = paramBundle.LgO;
          break label2054;
          label4190:
          i = 0;
          break label2242;
          label4195:
          if (!this.KBX) {
            break label2327;
          }
          this.KBX = aj.fOS().fUR();
          break label2327;
          label4215:
          if (!this.KBX) {
            break label2539;
          }
          this.KBX = aj.fOS().fUR();
          break label2539;
          label4235:
          this.mUIAction.list.setAdapter(this.KYU);
          aho(0);
          this.KYU.tA();
          break label2817;
          label4264:
          i = 0;
          break label3658;
          label4269:
          if (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).hasFinderPosted())
          {
            this.KZy = 1;
            break label3736;
          }
          this.KZy = 2;
          break label3736;
          label4302:
          paramBundle = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vUv, "");
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
    MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVSnsUI", false);
    this.KZf = true;
    Object localObject1 = this.KZr;
    ((bh)localObject1).fWJ();
    ((bh)localObject1).KUC = null;
    ((bh)localObject1).IYy = bh.a.KUF;
    com.tencent.mm.plugin.sns.ui.video.e.fZg().aT(this);
    localObject1 = com.tencent.mm.plugin.sns.ui.video.b.fYX();
    Log.i("MicroMsg.SightPlayViewManager", "onUIDestroy");
    Object localObject2 = ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).Lrs.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((com.tencent.mm.plugin.sns.ui.video.a)((Iterator)localObject2).next()).stop();
    }
    ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).Lrs.clear();
    Log.i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
    EventCenter.instance.removeListener(this.KZK);
    EventCenter.instance.removeListener(this.KZL);
    EventCenter.instance.removeListener(this.KZM);
    EventCenter.instance.removeListener(this.KZN);
    EventCenter.instance.removeListener(this.KZO);
    EventCenter.instance.removeListener(this.KZQ);
    EventCenter.instance.removeListener(this.KZP);
    EventCenter.instance.removeListener(this.Kbv);
    EventCenter.instance.removeListener(this.KZR);
    EventCenter.instance.removeListener(this.KZS);
    EventCenter.instance.removeListener(this.KZT);
    EventCenter.instance.removeListener(this.KZU);
    EventCenter.instance.removeListener(this.KZV);
    EventCenter.instance.removeListener(this.KZF);
    EventCenter.instance.removeListener(this.KZX);
    com.tencent.mm.plugin.sns.ui.e.a.fYV();
    int i;
    long l1;
    Object localObject3;
    Object localObject4;
    int j;
    label477:
    String str2;
    if ((this.KZa != null) && (this.KZa.KBO != null))
    {
      localObject1 = this.KZa.KBO.JZd;
      if (this.KZH)
      {
        i = 1;
        ((com.tencent.mm.plugin.sns.k.d)localObject1).Kga = i;
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.sns.k.g.Kia;
      if (((com.tencent.mm.plugin.sns.k.g)localObject2).jXZ == 0) {
        break label805;
      }
      Log.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sns.k.g)localObject2).Kib.size()), Integer.valueOf(((com.tencent.mm.plugin.sns.k.g)localObject2).Kic.size()) });
      l1 = ((com.tencent.mm.plugin.sns.k.g)localObject2).iRa.ahV(2);
      if ((((com.tencent.mm.plugin.sns.k.g)localObject2).Kib.isEmpty()) || ((((com.tencent.mm.plugin.sns.k.g)localObject2).Kib.size() <= ((com.tencent.mm.plugin.sns.k.g)localObject2).Kii) && (Util.secondsToNow(l1) <= ((com.tencent.mm.plugin.sns.k.g)localObject2).Kij))) {
        break label1764;
      }
      localObject3 = new StringBuffer();
      localObject4 = ((com.tencent.mm.plugin.sns.k.g)localObject2).Kib.keySet().iterator();
      i = 0;
      j = 0;
      if (!((Iterator)localObject4).hasNext()) {
        break label631;
      }
      str2 = (String)((Iterator)localObject4).next();
      localObject1 = (String)((com.tencent.mm.plugin.sns.k.g)localObject2).Kic.get(str2);
      if (Util.isNullOrNil((String)localObject1)) {
        break label618;
      }
      j = 1;
      label524:
      if (!((com.tencent.mm.plugin.sns.k.g)localObject2).Kid.contains(str2)) {
        break label626;
      }
    }
    label618:
    label626:
    for (int k = 1;; k = 0)
    {
      ((StringBuffer)localObject3).append(str2 + "#" + ((com.tencent.mm.plugin.sns.k.g)localObject2).Kib.get(str2) + "#" + (String)localObject1 + "#" + k + "|");
      i += 1;
      break label477;
      i = 0;
      break;
      localObject1 = "";
      break label524;
    }
    label631:
    ((StringBuffer)localObject3).append("," + l1 + "," + Util.nowSecond() + ",1," + j + "," + i + ",1");
    Log.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", new Object[] { Integer.valueOf(13226), localObject3 });
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(13226, ((StringBuffer)localObject3).toString());
    ((com.tencent.mm.plugin.sns.k.g)localObject2).iRa.i(3, null);
    ((com.tencent.mm.plugin.sns.k.g)localObject2).iRa.i(4, null);
    ((com.tencent.mm.plugin.sns.k.g)localObject2).iRa.i(5, null);
    ((com.tencent.mm.plugin.sns.k.g)localObject2).Kib.clear();
    ((com.tencent.mm.plugin.sns.k.g)localObject2).Kic.clear();
    ((com.tencent.mm.plugin.sns.k.g)localObject2).Kid.clear();
    ((com.tencent.mm.plugin.sns.k.g)localObject2).iRa.setLong(2, Util.nowSecond());
    for (;;)
    {
      ((com.tencent.mm.plugin.sns.k.g)localObject2).fQn();
      label805:
      com.tencent.mm.kernel.h.aHH();
      localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(68377, null);
      if ((this.KZa != null) && (this.KZa.KBO != null))
      {
        localObject2 = this.KZa.KBO.JZd;
        i = com.tencent.mm.plugin.sns.k.g.Kia.Kih;
        Log.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
        l1 = System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.k.d)localObject2).KhK;
        ((com.tencent.mm.plugin.sns.k.d)localObject2).KfO += l1;
        Log.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + l1 + " BrowseTime: " + ((com.tencent.mm.plugin.sns.k.d)localObject2).KfO + "BackgroundTime: " + ((com.tencent.mm.plugin.sns.k.d)localObject2).Kgx);
        localObject3 = aj.fOv();
        if (localObject3 != null) {
          ((ExecutorService)localObject3).execute(new d.2((com.tencent.mm.plugin.sns.k.d)localObject2, i));
        }
        ((com.tencent.mm.plugin.sns.k.d)localObject2).KfM = false;
      }
      localObject2 = com.tencent.mm.modelsns.l.wO(704);
      boolean bool;
      if (((com.tencent.mm.modelsns.l)localObject2).boW())
      {
        ((com.tencent.mm.modelsns.l)localObject2).gx(this.KZH);
        if (!Util.isNullOrNil((String)localObject1))
        {
          bool = true;
          ((com.tencent.mm.modelsns.l)localObject2).gx(bool);
          ((com.tencent.mm.modelsns.l)localObject2).Xf(this.KZg);
          ((com.tencent.mm.modelsns.l)localObject2).Xf(com.tencent.mm.plugin.sns.k.g.Kia.Kig);
          ((com.tencent.mm.modelsns.l)localObject2).Xf(com.tencent.mm.plugin.sns.k.g.Kia.Kig);
          ((com.tencent.mm.modelsns.l)localObject2).wR(this.mUIAction.LcC);
          ((com.tencent.mm.modelsns.l)localObject2).Xf("");
          com.tencent.mm.modelsns.l.boZ();
          ((com.tencent.mm.modelsns.l)localObject2).bpa();
        }
      }
      else
      {
        com.tencent.mm.plugin.sns.k.g.Kia.Kih = -1;
        com.tencent.mm.plugin.sns.k.g.Kia.Kig = "0";
        localObject1 = (AdListView)this.mUIAction.getSnsListView();
        this.KZj.KbB.clear();
        aj.fOz().clean();
        localObject2 = aj.fOC();
        aj.fOv().execute(new n.5((com.tencent.mm.plugin.sns.ad.f.n)localObject2));
        ((AdListView)localObject1).KAk.clear();
        ((AdListView)localObject1).KAk = null;
        ((AdListView)localObject1).KAl.fNV();
        ((AdListView)localObject1).KAl = null;
        com.tencent.mm.plugin.sns.model.v.fOa();
        if (!aj.isInValid()) {
          this.Lad.removeCallbacks(this.KZD);
        }
        com.tencent.mm.kernel.h.aHH();
        if (com.tencent.mm.kernel.h.aHE().aGM())
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.b(213, this);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.b(682, this);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.b(218, this);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.b(211, this);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.b(683, this);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(327776, Integer.valueOf(this.KZe));
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(589825, Boolean.FALSE);
        }
        if (this.KZa != null) {
          this.KZa.clean();
        }
        aj.etE().removeCallbacks(this.Lae);
        localObject1 = aj.fOT();
        if (((av)localObject1).KaS != null) {
          ((av)localObject1).fPF();
        }
        if (!((av)localObject1).Kap) {}
      }
      try
      {
        ((av)localObject1).KaL.KaQ = ((av)localObject1).KaQ;
        localObject2 = ((av)localObject1).KaL.toByteArray();
        com.tencent.mm.vfs.u.H(((av)localObject1).Kao, (byte[])localObject2);
        ((av)localObject1).KaL.Kff.clear();
        ((av)localObject1).KaM = null;
        ((av)localObject1).KaN = null;
        ((av)localObject1).KaO = 0L;
        ((av)localObject1).KaG = 0L;
        ((av)localObject1).KaA.clear();
        ((av)localObject1).KaB = null;
        ((av)localObject1).KaF = 0L;
        ((av)localObject1).KaC = 0L;
        ((av)localObject1).KaI = false;
        ((av)localObject1).KaS = null;
        ((av)localObject1).KaT = null;
        ((av)localObject1).KaH = com.tencent.mm.plugin.sns.model.aw.Kbl;
        ((av)localObject1).KaU = 0;
        ((av)localObject1).KaR = 0L;
        ((av)localObject1).KaQ = 0L;
        ((av)localObject1).KaV = 0L;
        ((av)localObject1).KaD.clear();
        localObject1 = ((av)localObject1).KaW;
        ((com.tencent.mm.plugin.sns.model.au)localObject1).Kal.clear();
        ((com.tencent.mm.plugin.sns.model.au)localObject1).Kam = null;
        com.tencent.mm.kernel.h.aHF().kcd.b(211, (com.tencent.mm.an.i)localObject1);
        localObject1 = aj.fOU();
        Log.i(as.TAG, "destroy");
        MMHandlerThread.removeRunnable(((as)localObject1).Kab);
        if (this.KYU == null) {
          break label2234;
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
            label1764:
            ((com.tencent.mm.plugin.sns.k.g)localObject2).iRa.i(3, ((com.tencent.mm.plugin.sns.k.g)localObject2).Kib);
            ((com.tencent.mm.plugin.sns.k.g)localObject2).iRa.i(4, ((com.tencent.mm.plugin.sns.k.g)localObject2).Kic);
            ((com.tencent.mm.plugin.sns.k.g)localObject2).iRa.i(5, ((com.tencent.mm.plugin.sns.k.g)localObject2).Kid);
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
        j = getResources().getDimensionPixelSize(i.d.sns_timeline_top_margin);
        if ((!aj.isInValid()) && (this.KYS.fOy() != null) && (this.Laj == 0))
        {
          localObject1 = aj.fOS();
          String str1 = this.KYU.Lgt.fYo();
          localObject3 = this.KYU.Lgt.fYq();
          l1 = this.KYS.fOy().JZy;
          localObject4 = this.KYU.Lgt.fYm();
          str2 = this.KYU.Lgt.fYn();
          long l2 = this.KYS.fOy().JZz;
          String str3 = this.KYU.Lgt.fYp();
          bool = this.mUIAction.KJB;
          ((au)localObject1).KJv = Util.currentTicks();
          ((au)localObject1).wtB = str1;
          ((au)localObject1).KJw = ((String)localObject3);
          ((au)localObject1).JZy = l1;
          ((au)localObject1).position = m;
          ((au)localObject1).KJA = (i - j);
          ((au)localObject1).KJz = str3;
          ((au)localObject1).KJx = ((String)localObject4);
          ((au)localObject1).KJy = str2;
          ((au)localObject1).JZz = l2;
          ((au)localObject1).KJB = bool;
          Log.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(((au)localObject1).KJv), str1, localObject3, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(((au)localObject1).KJA), localObject4, str2, Long.valueOf(l2), str3, Boolean.valueOf(bool) });
        }
        Log.d("MicroMsg.SnsTimeLineUI", "top h %d", new Object[] { Integer.valueOf(i - j) });
        if (!aj.isInValid()) {
          break label2569;
        }
      }
    }
    Log.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
    for (;;)
    {
      localObject1 = this.KYU.Lgs;
      if (((bm)localObject1).KPc != null) {
        ((bm)localObject1).KPc.activity = null;
      }
      this.KYU.Lgs.fXh();
      this.KYU.Lgs.fXd();
      label2234:
      bo.clean();
      EventCenter.instance.removeListener(this.KZE);
      com.tencent.mm.kernel.h.aHH();
      if (com.tencent.mm.kernel.h.aHE().aGM()) {
        aj.fOF().JUd.clear();
      }
      this.KYU.Lgt.removeVendingDataChangedCallback(this.KZG);
      this.KZG = null;
      com.tencent.mm.plugin.sns.k.g.Kia.agh(this.KYU.getCount());
      this.KYU = null;
      this.KZa = null;
      com.tencent.mm.plugin.sns.ui.a.c.fYk();
      com.tencent.mm.plugin.sns.abtest.c.fJD();
      localObject1 = aj.fOz();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(291, (com.tencent.mm.an.i)localObject1);
      com.tencent.mm.plugin.sns.abtest.a.clean();
      this.mUIAction.onDestroy();
      super.onDestroy();
      com.tencent.mm.kiss.widget.textview.c.kfZ.aIM();
      localObject1 = this.KYT;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).LgO = null;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = false;
      localObject1 = com.tencent.mm.plugin.sns.ad.f.o.JFQ;
      ((com.tencent.mm.plugin.sns.ad.f.o)localObject1).JFO.clear();
      Log.i("MicroMsg.SnsTimelineAdResourceMgr", "clean cache", new Object[] { Util.getStack() });
      try
      {
        ((com.tencent.mm.plugin.sns.ad.f.o)localObject1).JFP.evictAll();
        label2419:
        localObject1 = aj.fOD();
        if (!((com.tencent.mm.plugin.sns.model.c)localObject1).JTO.isEmpty()) {
          ((com.tencent.mm.plugin.sns.model.c)localObject1).JTO.clear();
        }
        localObject1 = aj.fOD();
        if (!((com.tencent.mm.plugin.sns.model.c)localObject1).JTP.isEmpty()) {
          ((com.tencent.mm.plugin.sns.model.c)localObject1).JTP.clear();
        }
        aj.fOT().KaJ = false;
        localObject1 = com.tencent.mm.plugin.sns.k.g.Kia;
        ((com.tencent.mm.plugin.sns.k.g)localObject1).Kim.clear();
        ((com.tencent.mm.plugin.sns.k.g)localObject1).Kin.clear();
        if (com.tencent.mm.plugin.sns.k.g.Kia.KiJ.gWw > 0L)
        {
          localObject1 = com.tencent.mm.plugin.sns.k.g.Kia;
          ((com.tencent.mm.plugin.sns.k.g)localObject1).KiJ.giq = 1L;
          ((com.tencent.mm.plugin.sns.k.g)localObject1).KiJ.bpa();
          ((com.tencent.mm.plugin.sns.k.g)localObject1).KiJ = new mw();
        }
        localObject1 = com.tencent.mm.plugin.sns.storage.d.Kzp;
        com.tencent.mm.plugin.sns.storage.d.btS().removeMessages(com.tencent.mm.plugin.sns.storage.d.Kzo);
        AppMethodBeat.o(99383);
        return;
        label2569:
        aj.fOF();
      }
      catch (Throwable localThrowable)
      {
        break label2419;
      }
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
        SnsTimeLineUI.this.fTI();
        AppMethodBeat.o(179271);
      }
    });
    if (keyboardState() == 2)
    {
      if ((this.KZa != null) && (this.KZa.KBS != null) && (!this.KZa.KBS.fWj()))
      {
        Log.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
        AppMethodBeat.o(99389);
      }
    }
    else if ((keyboardState() == 1) && (this.KZa != null)) {
      this.KZa.fTm();
    }
    AppMethodBeat.o(99389);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(193888);
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
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderTimelineUI(getContext(), localIntent);
      finish();
    }
    AppMethodBeat.o(193888);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99387);
    Object localObject2;
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.KLC = false;
      this.KYX.clearAnimation();
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, this.iWt);
      this.iWt = 0;
      com.tencent.mm.plugin.sns.model.v.b(this);
      aj.fOF().JUf = null;
      if (this.KYU != null) {
        this.KYU.Lgs.onPause();
      }
      if ((this.KZa != null) && (this.KZa.KBN != null)) {
        this.KZa.KBN.onPause();
      }
      if ((this.KZa != null) && (this.KZa.KBO != null)) {
        this.KZa.KBO.JZd.yw(false);
      }
      com.tencent.mm.modelstat.d.l("SnsTimeLineUI", this.EIx, Util.nowSecond());
      this.mUIAction.onPause();
      super.onPause();
      com.tencent.mm.plugin.sns.ui.video.e.fZg().onUIPause();
      Object localObject1 = com.tencent.mm.plugin.sns.ui.video.b.fYX();
      Log.i("MicroMsg.SightPlayViewManager", "onUIPause");
      localObject1 = ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).Lrs.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.sns.ui.video.a)((Iterator)localObject1).next()).onUIPause();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
      }
      EventCenter.instance.removeListener(this.KZJ);
      EventCenter.instance.removeListener(this.KZI);
      EventCenter.instance.removeListener(this.KZW);
      if ((com.tencent.matrix.b.Vt()) && (com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class) != null))
      {
        localObject2 = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class)).deH;
        if (localObject2 != null) {
          this.jXk = Math.max(0L, ((com.tencent.matrix.trace.f.c)localObject2).dgA - this.jXk);
        }
      }
      if (Util.nowSecond() <= this.lJV) {}
    }
    for (long l = Util.nowSecond() - this.lJV;; l = 1L)
    {
      this.lJV = l;
      WXHardCoderJNI.reportFPS(701, WXHardCoderJNI.hcSNSScrollAction, 1, this.jXk, this.lJV);
      this.jXk = 0L;
      this.lJV = 0L;
      if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.a.class) != null) {
        ((com.tencent.mm.plugin.ball.c.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.a.class)).f(101, false, false);
      }
      localObject2 = new xn();
      ((xn)localObject2).fWv.fWw = Boolean.FALSE;
      EventCenter.instance.asyncPublish((IEvent)localObject2, Looper.getMainLooper());
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
        fXr();
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = i.j.permission_camera_request_again_msg;; paramInt = i.j.permission_microphone_request_again_msg)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(i.j.permission_tips_title), getString(i.j.jump_to_settings), getString(i.j.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(240772);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = SnsTimeLineUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$75", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$75", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(240772);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(210343);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(210343);
            }
          });
        }
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        fXq();
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = i.j.permission_camera_request_again_msg;; paramInt = i.j.permission_microphone_request_again_msg)
      {
        com.tencent.mm.ui.base.h.a(getContext(), getString(paramInt), getString(i.j.permission_tips_title), getString(i.j.jump_to_settings), getString(i.j.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(200351);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = SnsTimeLineUI.this.getContext();
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$77", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$77", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(200351);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(198977);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(198977);
          }
        });
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        fXq();
        AppMethodBeat.o(99403);
        return;
      }
      com.tencent.mm.ui.base.h.a(getContext(), getString(i.j.permission_location_request_again_msg), getString(i.j.permission_tips_title), getString(i.j.jump_to_settings), getString(i.j.app_cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(267820);
          paramAnonymousDialogInterface = SnsTimeLineUI.this.getContext();
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$79", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$79", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(267820);
        }
      }, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99384);
    aj.fOT().KaH = com.tencent.mm.plugin.sns.model.aw.Kbl;
    this.KZr.IYy = bh.fWI();
    this.lJV = Util.nowSecond();
    Object localObject1;
    if ((com.tencent.matrix.b.Vt()) && (com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class) != null))
    {
      localObject1 = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class)).deH;
      if (localObject1 != null) {
        this.jXk = ((com.tencent.matrix.trace.f.c)localObject1).dgA;
      }
    }
    try
    {
      if (!this.KLC)
      {
        Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onResume callback");
        ScreenShotUtil.setScreenShotCallback(this, this.KMx);
        this.KLC = true;
      }
      if ((CrashReportFactory.hasDebuger()) && (CrashReportFactory.isMonkeyEnv())) {
        sUILeaksRoutineEnsuranceRef.add(this);
      }
      this.mUIAction.onResume();
      super.onResume();
      fXm();
      if (this.autoPlay) {
        fXl();
      }
      this.EIx = Util.nowSecond();
      int i;
      if (this.Lai)
      {
        this.Lai = false;
        i = this.KYU.getCount();
        if (getIntent().getBooleanExtra("is_from_find_more", false))
        {
          localObject3 = com.tencent.mm.modelsns.l.c(getIntent(), "enter_log");
          if (localObject3 != null)
          {
            if (i <= 0) {
              break label732;
            }
            localSnsInfo = this.KYU.agM(0);
            if (localSnsInfo != null) {
              break label698;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.l)localObject3).Xf((String)localObject1);
            if (localSnsInfo != null) {
              break label710;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.l)localObject3).Xf((String)localObject1);
            ((com.tencent.mm.modelsns.l)localObject3).Xf(String.valueOf(i));
            ((com.tencent.mm.modelsns.l)localObject3).bpa();
          }
        }
      }
      if (this.mScreenWidth == 0)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
        this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
        localObject1 = this.KZh;
        i = this.mScreenWidth;
        int j = this.mScreenHeight;
        ((com.tencent.mm.plugin.sns.k.a)localObject1).mScreenWidth = i;
        ((com.tencent.mm.plugin.sns.k.a)localObject1).mScreenHeight = j;
      }
      if (aj.isInValid()) {
        finish();
      }
      aj.fOF().JUf = this.KYU.Lgs;
      aII().bG(c.b.class);
      com.tencent.mm.plugin.sns.model.v.a(this);
      if (this.KYZ)
      {
        this.KYX.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99328);
            Log.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.N(SnsTimeLineUI.this));
            if (SnsTimeLineUI.N(SnsTimeLineUI.this))
            {
              SnsTimeLineUI.m(SnsTimeLineUI.this);
              SnsTimeLineUI.l(SnsTimeLineUI.this).fXF();
            }
            AppMethodBeat.o(99328);
          }
        });
        if ((this.KZa != null) && (this.KZa.KBN != null)) {
          this.KZa.KBN.onResume();
        }
        if (this.KYU != null) {
          this.KYU.Lgs.onResume();
        }
        if ((this.KZa != null) && (this.KZa.KBO != null))
        {
          this.KZa.KBO.JZd.yw(true);
          this.KZa.KBO.JZd.yx(false);
          this.KZa.KBO.JZd.yy(false);
          this.KZa.KBO.JZd.yz(false);
          this.KZa.KBO.JZd.yJ(false);
          localObject1 = this.KZa.KBO.JZd;
          ((com.tencent.mm.plugin.sns.k.d)localObject1).yH(false);
          ((com.tencent.mm.plugin.sns.k.d)localObject1).yI(false);
          ((com.tencent.mm.plugin.sns.k.d)localObject1).yB(false);
          ((com.tencent.mm.plugin.sns.k.d)localObject1).yG(false);
          ((com.tencent.mm.plugin.sns.k.d)localObject1).yE(false);
          ((com.tencent.mm.plugin.sns.k.d)localObject1).yG(false);
          ((com.tencent.mm.plugin.sns.k.d)localObject1).yK(false);
          ((com.tencent.mm.plugin.sns.k.d)localObject1).yF(false);
          ((com.tencent.mm.plugin.sns.k.d)localObject1).yG(false);
          ((com.tencent.mm.plugin.sns.k.d)localObject1).yC(false);
          ((com.tencent.mm.plugin.sns.k.d)localObject1).yD(false);
        }
        localObject1 = aj.fOF();
        ((com.tencent.mm.plugin.sns.model.g)localObject1).JUg = 0L;
        ((com.tencent.mm.plugin.sns.model.g)localObject1).JUh = 0L;
        EventCenter.instance.addListener(this.KZJ);
        EventCenter.instance.addListener(this.KZI);
        EventCenter.instance.addListener(this.KZW);
        localObject1 = new xn();
        ((xn)localObject1).fWv.fWw = Boolean.TRUE;
        EventCenter.instance.asyncPublish((IEvent)localObject1, Looper.getMainLooper());
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
        label698:
        Object localObject2 = com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId);
        continue;
        label710:
        localObject2 = localSnsInfo.field_createTime;
        continue;
        label732:
        ((com.tencent.mm.modelsns.l)localObject3).Xf("");
        ((com.tencent.mm.modelsns.l)localObject3).Xf("");
        ((com.tencent.mm.modelsns.l)localObject3).Xf("0");
        continue;
        localObject2 = this.KZc;
        if (((a)localObject2).Lao.KYX.getVisibility() == 0)
        {
          ((a)localObject2).init();
          localObject3 = (AbsoluteLayout.LayoutParams)((a)localObject2).Lao.KYX.getLayoutParams();
          ((AbsoluteLayout.LayoutParams)localObject3).y = ((int)((a)localObject2).LaL);
          ((a)localObject2).Lao.KYX.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((a)localObject2).Lao.KYX.invalidate();
        }
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(99398);
    Log.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType());
    if (paramq.getType() == 218)
    {
      paramString = (com.tencent.mm.plugin.sns.model.s)paramq;
      if (((paramString.type == 1) || (paramString.type == 6) || (paramString.type == 4)) && (this.KZa.KCf != null)) {
        this.KZa.KCf.dismiss();
      }
      if (paramString.type == 11)
      {
        if (this.mUIAction.tipDialog != null) {
          this.mUIAction.tipDialog.dismiss();
        }
        if (this.Lak != null) {
          this.Lak.setImageResource(i.i.icons_outlined_camera);
        }
      }
    }
    if (this.KYU != null) {
      this.KYU.Lgt.notifyVendingDataChange();
    }
    com.tencent.mm.modelsns.l locall;
    if (paramq.getType() == 211)
    {
      paramString = (com.tencent.mm.plugin.sns.model.z)paramq;
      if (!paramString.JVe) {
        break label280;
      }
      locall = com.tencent.mm.modelsns.l.wO(727);
      locall.wR(this.KYU.getCount()).wR(paramString.afI);
      locall.bpa();
    }
    for (;;)
    {
      if (this.KZc != null)
      {
        this.KYZ = false;
        this.KZc.fXG();
      }
      a(paramInt1, paramInt2, paramq, this);
      AppMethodBeat.o(99398);
      return;
      label280:
      locall = com.tencent.mm.modelsns.l.wO(728);
      locall.wR(this.KYU.getCount()).wR(paramString.afI).wR(0);
      locall.bpa();
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
    AppMethodBeat.i(193844);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.KLC = false;
      AppMethodBeat.o(193844);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.o(193844);
    }
    if (!this.KLC)
    {
      Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onWindowFocusChanged callback");
      ScreenShotUtil.setScreenShotCallback(this, this.KMx);
      this.KLC = true;
    }
    AppMethodBeat.o(193844);
    return;
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(99375);
    super.setActionbarColor(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.Cwk != null))
    {
      this.Cwk.setBackgroundColor(getWindow().getStatusBarColor());
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
  
  public final void zb(boolean paramBoolean)
  {
    AppMethodBeat.i(99405);
    if (this.KYU != null)
    {
      Log.i("MicroMsg.SnsTimeLineUI", "set play animation %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.mm.plugin.sns.ui.a.c localc = this.KYU;
      localc.Lgu = paramBoolean;
      if (!paramBoolean) {
        localc.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(99405);
  }
  
  final class a
    extends Animation
  {
    int GzF = 600;
    private float LaI;
    private float LaJ;
    float LaK = -1.0F;
    float LaL;
    private float LaM = 50.0F;
    private float LaN = 10.0F;
    float LaO = 0.0F;
    private float LaP = 0.0F;
    private float LaQ;
    private float LaR;
    boolean LaS;
    int LaT;
    boolean LaU = false;
    int LaV = 0;
    float LaW = 0.0F;
    float LaX = 0.0F;
    float LaY = 0.0F;
    float LaZ = 0.0F;
    private ListView list;
    
    public a(ListView paramListView)
    {
      this.list = paramListView;
    }
    
    final void Rn(long paramLong)
    {
      AppMethodBeat.i(99363);
      if (SnsTimeLineUI.KZY.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "setDurationTime durationMillis %s %s", new Object[] { Long.valueOf(paramLong), Util.getStack().toString() });
      }
      setDuration(paramLong);
      AppMethodBeat.o(99363);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(99366);
      if (SnsTimeLineUI.KZY.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "animtest applyTransformation vis %s interpolatedTime %s isJustUp %s", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(paramFloat), Boolean.valueOf(this.LaS) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99366);
        return;
      }
      float f1 = (paramFloat - this.LaQ) * (float)getDuration();
      if (f1 < 2.0F)
      {
        if (SnsTimeLineUI.KZY.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "applyTransformation wawawa %s", new Object[] { Float.valueOf(f1) });
        }
        AppMethodBeat.o(99366);
        return;
      }
      this.LaQ = paramFloat;
      SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(i.i.friendactivity_refresh);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.Ydg);
      if (((float)getDuration() * paramFloat >= (float)(getDuration() - this.GzF)) || (this.LaS))
      {
        paramTransformation = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        if (paramTransformation.y <= this.LaP)
        {
          AppMethodBeat.o(99366);
          return;
        }
        if (this.LaY == 0.0F)
        {
          this.LaY = (-this.LaP + paramTransformation.y);
          this.LaZ = paramTransformation.y;
          this.LaR = paramFloat;
        }
        paramFloat = (paramFloat - this.LaR) / (1.0F - this.LaR);
        f1 = this.LaY * paramFloat;
        float f2 = this.LaZ - f1;
        if (SnsTimeLineUI.KZY.booleanValue()) {
          Log.i("MicroMsg.RefreshAnim", "animcheck interpolatedTime y %s duration %s factor %s residualTime %s pass %s ", new Object[] { Float.valueOf(f2), Long.valueOf(getDuration()), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.LaR * (float)getDuration()) });
        }
        if (paramTransformation.y > f2) {
          paramTransformation.y = ((int)f2);
        }
        this.LaO = paramTransformation.y;
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(paramTransformation);
      }
      for (;;)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99366);
        return;
        if (SnsTimeLineUI.KZY.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "animcheck delt Rotate " + f1 / 2.5F);
        }
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(f1 / 2.5F, this.LaI, this.LaJ);
      }
    }
    
    public final void ch(float paramFloat)
    {
      AppMethodBeat.i(99360);
      if (this.list != null)
      {
        if (this.list.getFirstVisiblePosition() != 0) {
          break label123;
        }
        if (SnsTimeLineUI.d(SnsTimeLineUI.this).Kfp.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).LaT) {
          SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
        }
      }
      for (;;)
      {
        if (SnsTimeLineUI.KZY.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.LaL), Float.valueOf(this.LaK) });
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
      if (paramFloat <= -this.LaM) {
        f1 = -this.LaM;
      }
      float f2 = f1;
      if (f1 >= this.LaM) {
        f2 = this.LaM;
      }
      if (f2 < 0.0F)
      {
        this.LaO -= f2 * 2.0F;
        f1 = this.LaO;
        paramFloat = f1;
        if (f1 < this.LaL)
        {
          paramFloat = this.LaL;
          this.LaO = this.LaL;
        }
        f1 = paramFloat;
        if (paramFloat > this.LaK)
        {
          f1 = this.LaK;
          this.LaO = this.LaK;
        }
        if (SnsTimeLineUI.KZY.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s sumY %s translateY %s distanceY %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.LaL), Float.valueOf(this.LaK), Float.valueOf(this.LaO), Float.valueOf(f1), Float.valueOf(this.LaM) });
        }
        if (f1 != this.LaK) {
          break label457;
        }
      }
      label457:
      for (paramFloat = f2 * 2.0F;; paramFloat = 5.0F * f2)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.Ydg);
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(paramFloat, this.LaI, this.LaJ);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(i.i.friendactivity_refresh);
        AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        localLayoutParams.y = ((int)f1);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99360);
        return;
        this.LaO -= f2 / 2.0F;
        break;
      }
    }
    
    public final void fXF()
    {
      AppMethodBeat.i(99361);
      if (SnsTimeLineUI.KZY.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "animtest playLoading");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99361);
        return;
      }
      init();
      this.LaO = (this.LaK + 20.0F);
      AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
      localLayoutParams.y = ((int)this.LaK);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
      fXH();
      AppMethodBeat.o(99361);
    }
    
    public final void fXG()
    {
      AppMethodBeat.i(99362);
      if (SnsTimeLineUI.KZY.booleanValue()) {
        Log.i("MicroMsg.RefreshAnim", "play end vis: %d, sumY %f MAX_Y %f", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(this.LaO), Float.valueOf(this.LaK) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99362);
        return;
      }
      init();
      if (this.LaO < this.LaK - this.LaN)
      {
        AppMethodBeat.o(99362);
        return;
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      Rn(this.GzF + 100);
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      this.LaS = false;
      AppMethodBeat.o(99362);
    }
    
    public final void fXH()
    {
      AppMethodBeat.i(99364);
      if (SnsTimeLineUI.KZY.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "animtest setAcitonUp");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99364);
        return;
      }
      init();
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      if (SnsTimeLineUI.KZY.booleanValue()) {
        Log.v("MicroMsg.RefreshAnim", "setAcitonUp1 sumY  %s MAX_Y %s %s", new Object[] { Float.valueOf(this.LaO), Float.valueOf(this.LaK), Util.getStack().toString() });
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      if (this.LaO >= this.LaK - this.LaN)
      {
        Rn(20000L);
        this.LaS = false;
        AppMethodBeat.o(99364);
        return;
      }
      Rn(this.GzF + 100);
      this.LaS = true;
      AppMethodBeat.o(99364);
    }
    
    final void init()
    {
      AppMethodBeat.i(99365);
      if ((this.LaK == -1.0F) || (this.LaJ < 0.1D))
      {
        this.LaK = BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 70.0F);
        this.LaM = BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 16.0F);
        this.LaI = (SnsTimeLineUI.u(SnsTimeLineUI.this).getWidth() / 2);
        this.LaJ = (SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() / 2);
        this.LaP = (-SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() * 2);
        if (this.LaP == 0.0F) {
          this.LaP = (-BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 40.0F));
        }
        this.LaL = this.LaP;
        if (SnsTimeLineUI.KZY.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "init MIN_Y %s MAX_Y %s targetInitY %s distanceY %s", new Object[] { Float.valueOf(this.LaL), Float.valueOf(this.LaK), Float.valueOf(this.LaP), Float.valueOf(this.LaM) });
        }
        this.LaO = this.LaL;
        if (!this.LaU)
        {
          if (SnsTimeLineUI.KZY.booleanValue()) {
            Log.i("MicroMsg.RefreshAnim", "initState");
          }
          this.LaV = ((AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams()).y;
          this.LaW = this.LaK;
          this.LaX = this.LaO;
        }
        this.LaU = true;
      }
      AppMethodBeat.o(99365);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(99367);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      if (SnsTimeLineUI.KZY.booleanValue()) {
        Log.i("MicroMsg.RefreshAnim", "anim initialize %s", new Object[] { Util.getStack().toString() });
      }
      this.LaQ = 0.0F;
      this.LaR = 0.0F;
      this.LaY = 0.0F;
      this.LaZ = 0.0F;
      AppMethodBeat.o(99367);
    }
  }
  
  final class b
  {
    public int tips;
    public int type = 0;
    
    private b() {}
  }
  
  final class c
  {
    public int JPM;
    public String Lba = "";
    public long Lbb;
    public int Lbc;
    public int Lbd;
    public long Lbe;
    public long Lbf;
    public int Lbg;
    public long Lbh;
    public boolean active = true;
    public long pOr;
    public int scene;
    
    private c() {}
    
    public final void ahq(int paramInt)
    {
      AppMethodBeat.i(99368);
      if (!this.active)
      {
        AppMethodBeat.o(99368);
        return;
      }
      this.Lbd = paramInt;
      this.pOr = Util.nowMilliSecond();
      AppMethodBeat.o(99368);
    }
    
    public final void ahr(int paramInt)
    {
      AppMethodBeat.i(99369);
      if (!this.active)
      {
        AppMethodBeat.o(99369);
        return;
      }
      reset();
      this.scene = 2;
      this.Lbe = Util.nowMilliSecond();
      this.JPM = paramInt;
      AppMethodBeat.o(99369);
    }
    
    public final void ahs(int paramInt)
    {
      AppMethodBeat.i(99370);
      if (!this.active)
      {
        AppMethodBeat.o(99370);
        return;
      }
      reset();
      this.scene = 3;
      this.Lbf = Util.nowMilliSecond();
      this.Lbh = 0L;
      this.Lbg = paramInt;
      AppMethodBeat.o(99370);
    }
    
    final void reset()
    {
      this.scene = 0;
      this.Lbb = 0L;
      this.Lbc = -1;
      this.Lbd = 0;
      this.pOr = 0L;
      this.Lbe = 0L;
      this.JPM = 0;
      this.Lbf = 0L;
      this.Lbg = 0;
      this.Lbh = 0L;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(99371);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.Lba).append(",").append(this.scene).append(",").append(this.Lbb).append(",").append(this.Lbc).append(",").append(this.Lbd).append(",").append(this.pOr).append(",").append(this.Lbe).append(",").append(this.JPM).append(",").append(this.Lbf).append(",").append(this.Lbg).append(",").append(this.Lbh);
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