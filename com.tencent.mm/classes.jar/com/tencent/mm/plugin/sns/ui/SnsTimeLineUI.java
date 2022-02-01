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
import com.tencent.mm.al.n;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.g.a.te;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.g.a.uf;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.b.a.cn;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sns.a.b.k.5;
import com.tencent.mm.plugin.sns.c.i.a;
import com.tencent.mm.plugin.sns.k.a.a;
import com.tencent.mm.plugin.sns.k.c.2;
import com.tencent.mm.plugin.sns.m.c.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ar.3;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.y;
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
  implements com.tencent.mm.al.g, com.tencent.mm.model.au, i.a, v
{
  private static final Set<Activity> sUILeaksRoutineEnsuranceRef;
  public static final Boolean xGO;
  private static Boolean xGo;
  private boolean autoPlay;
  private long fXQ;
  private int foV;
  private long hcE;
  private String kGt;
  private ActionBar mActionBar;
  private int mScreenHeight;
  private int mScreenWidth;
  private String mSessionId;
  private SnsUIAction mUIAction;
  private com.tencent.mm.ui.statusbar.c.a qAM;
  private int tZz;
  private long tlW;
  private View uAo;
  private com.tencent.mm.sdk.b.c wJd;
  private boolean wOo;
  private final long xFP;
  private long xFQ;
  private com.tencent.mm.plugin.sns.m.b xFR;
  private com.tencent.mm.plugin.sns.m.a xFS;
  private com.tencent.mm.plugin.sns.ui.a.a.c xFT;
  private com.tencent.mm.plugin.sns.ui.a.c xFU;
  private LinearLayout xFV;
  private LinearLayout xFW;
  private QFadeImageView xFX;
  private boolean xFY;
  private boolean xFZ;
  private com.tencent.mm.sdk.b.c xGA;
  private com.tencent.mm.sdk.b.c xGB;
  private com.tencent.mm.sdk.b.c xGC;
  private com.tencent.mm.sdk.b.c xGD;
  private com.tencent.mm.sdk.b.c xGE;
  private com.tencent.mm.sdk.b.c xGF;
  private com.tencent.mm.sdk.b.c xGG;
  private com.tencent.mm.sdk.b.c xGH;
  private com.tencent.mm.sdk.b.c xGI;
  private com.tencent.mm.sdk.b.c xGJ;
  private com.tencent.mm.sdk.b.c xGK;
  private com.tencent.mm.sdk.b.c xGL;
  private com.tencent.mm.sdk.b.c xGM;
  private com.tencent.mm.sdk.b.c xGN;
  private long xGP;
  boolean xGQ;
  Runnable xGR;
  Runnable xGS;
  private Handler xGT;
  private Runnable xGU;
  private SnsUIAction.a xGV;
  private long xGW;
  private a.b xGX;
  boolean xGY;
  int xGZ;
  private i xGa;
  private int xGb;
  private a xGc;
  private TestTimeForSns xGd;
  private int xGe;
  private boolean xGf;
  private String xGg;
  private com.tencent.mm.plugin.sns.k.a xGh;
  private ay xGi;
  private aw xGj;
  private String xGk;
  private boolean xGl;
  private int xGm;
  private String xGn;
  private String xGp;
  private c xGq;
  private az xGr;
  private ViewGroup xGs;
  private long xGt;
  private Runnable xGu;
  private com.tencent.mm.sdk.b.c xGv;
  private com.tencent.mm.sdk.b.c xGw;
  private Vending.d xGx;
  private boolean xGy;
  private com.tencent.mm.sdk.b.c xGz;
  private MenuItem.OnMenuItemClickListener xHa;
  private ImageView xHb;
  private View xHc;
  private boolean xHd;
  private boolean xlh;
  private boolean xng;
  private volatile boolean xtG;
  private bh.a xuu;
  protected com.tencent.mm.plugin.sns.a.b.i xwT;
  
  static
  {
    AppMethodBeat.i(99430);
    xGo = null;
    xGO = Boolean.FALSE;
    sUILeaksRoutineEnsuranceRef = new HashSet();
    AppMethodBeat.o(99430);
  }
  
  public SnsTimeLineUI()
  {
    AppMethodBeat.i(99372);
    this.xFP = 300L;
    this.xFQ = SystemClock.elapsedRealtime();
    this.xFR = ((com.tencent.mm.plugin.sns.m.b)am(com.tencent.mm.plugin.sns.m.b.class));
    if (this.xFR != null) {}
    for (com.tencent.mm.plugin.sns.m.a locala = this.xFR.dEw();; locala = null)
    {
      this.xFS = locala;
      this.xFT = new com.tencent.mm.plugin.sns.ui.a.a.c();
      this.xFY = false;
      this.xFZ = false;
      this.xlh = false;
      this.xGb = 800;
      this.xGe = 0;
      this.xGf = false;
      this.xGg = "";
      this.xGh = new com.tencent.mm.plugin.sns.k.a();
      this.xwT = new com.tencent.mm.plugin.sns.a.b.i(0);
      this.xGi = new ay();
      this.xGj = new aw();
      this.autoPlay = false;
      this.xGp = "";
      this.xGq = new c((byte)0);
      this.xGr = new az();
      this.xGs = null;
      this.xGt = 0L;
      this.xtG = false;
      this.xGu = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99267);
          com.tencent.mm.plugin.sns.ui.a.c localc = SnsTimeLineUI.a(SnsTimeLineUI.this);
          if (localc != null)
          {
            if (af.dtD().wJJ == as.wKi) {
              SnsTimeLineUI.a(SnsTimeLineUI.this, localc.qv(true));
            }
            localc.xMy.dBK();
            localc.xMy.notifyVendingDataChange();
          }
          AppMethodBeat.o(99267);
        }
      };
      this.xGv = new com.tencent.mm.sdk.b.c() {};
      this.xGw = new com.tencent.mm.sdk.b.c() {};
      this.xGx = new Vending.d()
      {
        public final void dCq()
        {
          AppMethodBeat.i(179249);
          final int i;
          if ((SnsTimeLineUI.a(SnsTimeLineUI.this) != null) && (!SnsTimeLineUI.a(SnsTimeLineUI.this).xMz))
          {
            SnsTimeLineUI.a(SnsTimeLineUI.this).notifyDataSetChanged();
            if (SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView() != null)
            {
              i = com.tencent.mm.ui.ap.dL(SnsTimeLineUI.this.getContext());
              int j = com.tencent.mm.ui.ap.iX(SnsTimeLineUI.this.getContext());
              ad.d("MicroMsg.SnsTimeLineUI", "topOffset:%s curFetchMode:%s, mUIAction.header.getLoadingGroupHeight():%s, actionBar:%s, statusBar:%s", new Object[] { Integer.valueOf(-(SnsTimeLineUI.d(SnsTimeLineUI.this).wOn.getLoadingGroupHeight() - ao.fromDPToPix(SnsTimeLineUI.this.getContext(), 44) - i - j)), Integer.valueOf(af.dtD().wJJ), Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).wOn.getLoadingGroupHeight()), Integer.valueOf(i), Integer.valueOf(j) });
              if (af.dtD().wJJ == as.wKh)
              {
                ad.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_SPECIFIC");
                long l = SnsTimeLineUI.a(SnsTimeLineUI.this).dDc();
                af.dtk().N(l, -1);
                SnsTimeLineUI.a(SnsTimeLineUI.this).xMy.aqF(com.tencent.mm.plugin.sns.data.q.su(l));
                SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.a(SnsTimeLineUI.this).qv(true));
                SnsTimeLineUI.d(SnsTimeLineUI.this).qu(true);
                af.dtr().start();
                SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(187722);
                    SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().setSelectionFromTop(SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), i + ao.fromDPToPix(SnsTimeLineUI.this.getContext(), 44));
                    af.dtD().wJL = false;
                    AppMethodBeat.o(187722);
                  }
                });
                AppMethodBeat.o(179249);
                return;
              }
              if (af.dtD().wJJ == as.wKi)
              {
                i = 0;
                if (i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) {
                  break label421;
                }
                if (SnsTimeLineUI.a(SnsTimeLineUI.this).Ni(i).field_snsId != SnsTimeLineUI.e(SnsTimeLineUI.this)) {
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
      this.xGy = false;
      this.wOo = false;
      this.xGz = new com.tencent.mm.sdk.b.c() {};
      this.xGA = new com.tencent.mm.sdk.b.c() {};
      this.xGB = new SnsTimeLineUI.67(this);
      this.xGC = new com.tencent.mm.sdk.b.c() {};
      this.xGD = new com.tencent.mm.sdk.b.c() {};
      this.xGE = new com.tencent.mm.sdk.b.c() {};
      this.xGF = new com.tencent.mm.sdk.b.c() {};
      this.xGG = new com.tencent.mm.sdk.b.c() {};
      this.xGH = new com.tencent.mm.sdk.b.c() {};
      this.wJd = new com.tencent.mm.sdk.b.c() {};
      this.xGI = new com.tencent.mm.sdk.b.c() {};
      this.xGJ = new com.tencent.mm.sdk.b.c() {};
      this.xGK = new com.tencent.mm.sdk.b.c() {};
      this.xGL = new com.tencent.mm.sdk.b.c() {};
      this.xGM = new com.tencent.mm.sdk.b.c() {};
      this.xGN = new com.tencent.mm.sdk.b.c() {};
      this.xGP = 0L;
      this.xGQ = false;
      this.tZz = 0;
      this.xGR = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99288);
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) == null)
          {
            AppMethodBeat.o(99288);
            return;
          }
          if (SnsTimeLineUI.v(SnsTimeLineUI.this)) {
            af.dtr().pause();
          }
          AppMethodBeat.o(99288);
        }
      };
      this.xGS = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(176303);
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) == null)
          {
            AppMethodBeat.o(176303);
            return;
          }
          if (!SnsTimeLineUI.v(SnsTimeLineUI.this))
          {
            ad.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() - SnsTimeLineUI.d(SnsTimeLineUI.this).list.getHeaderViewsCount()) });
            af.dtr().start();
            SnsTimeLineUI.a(SnsTimeLineUI.this).xMx.dBX();
          }
          AppMethodBeat.o(176303);
        }
      };
      this.xGT = ((com.tencent.mm.vending.h.b)com.tencent.mm.vending.h.d.HQM.HQU).mHandler;
      this.xGU = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179225);
          SnsTimeLineUI.this.setMMNormalView();
          SnsTimeLineUI.w(SnsTimeLineUI.this);
          SnsTimeLineUI.x(SnsTimeLineUI.this);
          SnsTimeLineUI.this.setMMTitle(SnsTimeLineUI.this.getString(2131764037));
          SnsTimeLineUI.y(SnsTimeLineUI.this);
          SnsTimeLineUI.c(SnsTimeLineUI.this, SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition());
          AppMethodBeat.o(179225);
        }
      };
      this.xGV = new SnsUIAction.a()
      {
        private int xHk = 0;
        private int xHl = 0;
        
        public final void NC(int paramAnonymousInt)
        {
          AppMethodBeat.i(179238);
          int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          int k = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
          if ((paramAnonymousInt == 0) && (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)) {
            SnsTimeLineUI.a(SnsTimeLineUI.this, j, k);
          }
          if ((j == this.xHk) && (k == this.xHl))
          {
            AppMethodBeat.o(179238);
            return;
          }
          this.xHk = j;
          this.xHl = k;
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
              Object localObject2 = ((com.tencent.mm.plugin.sns.ui.a.c)localObject1).Ni(paramAnonymousInt - 1);
              if (localObject2 != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject2).dxy();
                if ((localObject2 != null) && (!TextUtils.isEmpty(((TimeLineObject)localObject2).Etm.Url)) && (((TimeLineObject)localObject2).Etm.Url.contains("mp.weixin.qq.com")) && (((TimeLineObject)localObject2).Etm.DaB == 3))
                {
                  i = -1;
                  if (((TimeLineObject)localObject2).Etm.DaF != null) {
                    i = ((TimeLineObject)localObject2).Etm.DaF.gKq;
                  }
                  ArrayList localArrayList = new ArrayList();
                  localArrayList.add(((TimeLineObject)localObject2).Etm.Url);
                  localArrayList.add(String.valueOf(i));
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).Id));
                  localArrayList.add("");
                  localArrayList.add("");
                  localArrayList.add(((TimeLineObject)localObject2).mAQ);
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).CreateTime));
                  localArrayList.add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).OZ("__sns_timeline__")));
                  localLinkedList.add(localArrayList);
                }
              }
              paramAnonymousInt += 1;
            }
          }
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).i(localLinkedList, 2);
          label537:
          SnsTimeLineUI.a(SnsTimeLineUI.this).hu(j, k);
          label550:
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)
          {
            localObject1 = SnsTimeLineUI.j(SnsTimeLineUI.this).a(SnsTimeLineUI.a(SnsTimeLineUI.this).xMx);
            com.tencent.mm.vending.g.g.fhq().d(new com.tencent.mm.vending.c.a() {});
          }
          com.tencent.mm.plugin.sns.k.f.wQY.hb(j, k);
          com.tencent.mm.plugin.sns.k.f.wQY.hc(j, k);
          AppMethodBeat.o(179238);
        }
        
        public final void a(com.tencent.mm.plugin.sns.data.l paramAnonymousl) {}
        
        public final void ar(int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179239);
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).xMy.notifyVendingDataChange();
          }
          if (!paramAnonymousBoolean) {
            SnsTimeLineUI.this.agy().bf(c.b.class);
          }
          AppMethodBeat.o(179239);
        }
        
        public final void d(int paramAnonymousInt, List<Integer> paramAnonymousList1, List<Integer> paramAnonymousList2)
        {
          int j = 1;
          AppMethodBeat.i(179233);
          int i = j;
          if (paramAnonymousInt > 0)
          {
            paramAnonymousList1 = af.dtu().Ne(paramAnonymousInt);
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
            paramAnonymousList1 = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousList1);
            paramAnonymousList2 = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousList2, paramAnonymousList1.adn(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$33", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.c.b((ListView)paramAnonymousList1.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousList2, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$33", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          }
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).xMy.notifyVendingDataChange();
          }
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.b(SnsTimeLineUI.this);
          }
          AppMethodBeat.o(179233);
        }
        
        public final void dCi()
        {
          AppMethodBeat.i(179228);
          if (af.dtD().wJL)
          {
            ad.i("MicroMsg.SnsTimeLineUI", "isAutoScrolling, skip onLoadingMore");
            AppMethodBeat.o(179228);
            return;
          }
          com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
          SnsTimeLineUI.n(SnsTimeLineUI.this);
          localc.e(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), false, SnsTimeLineUI.A(SnsTimeLineUI.this));
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FuD, Integer.valueOf(3));
          ad.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
          if (SnsTimeLineUI.B(SnsTimeLineUI.this) == null)
          {
            ad.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
            AppMethodBeat.o(179228);
            return;
          }
          if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
          {
            SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
            SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
          }
          AppMethodBeat.o(179228);
        }
        
        public final View dCj()
        {
          AppMethodBeat.i(179230);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).wMz == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).wMz = ((FrameLayout)SnsTimeLineUI.this.findViewById(2131305824));
          }
          FrameLayout localFrameLayout = SnsTimeLineUI.k(SnsTimeLineUI.this).wMz;
          AppMethodBeat.o(179230);
          return localFrameLayout;
        }
        
        public final MMPullDownView dCk()
        {
          AppMethodBeat.i(179232);
          MMPullDownView localMMPullDownView = (MMPullDownView)SnsTimeLineUI.this.findViewById(2131305047);
          AppMethodBeat.o(179232);
          return localMMPullDownView;
        }
        
        public final boolean dCl()
        {
          AppMethodBeat.i(179234);
          boolean bool = SnsTimeLineUI.D(SnsTimeLineUI.this);
          AppMethodBeat.o(179234);
          return bool;
        }
        
        public final void dCm()
        {
          AppMethodBeat.i(179235);
          ad.d("MicroMsg.SnsTimeLineUI", "onLoadingTap");
          SnsTimeLineUI.this.dzb();
          if (!SnsTimeLineUI.d(SnsTimeLineUI.this).xrF)
          {
            if (SnsTimeLineUI.u(SnsTimeLineUI.this) != null)
            {
              ad.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
              SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
            }
            com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this);
            localc.d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.FuD, Integer.valueOf(2));
          }
          AppMethodBeat.o(179235);
        }
        
        public final void dCn()
        {
          AppMethodBeat.i(179236);
          SnsTimeLineUI.this.dzb();
          AppMethodBeat.o(179236);
        }
        
        public final void dCo()
        {
          AppMethodBeat.i(179237);
          af.dtD().duj();
          int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          Object localObject1 = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getChildAt(0);
          ad.i("MicroMsg.SnsTimeLineUI", "will do up fetch isDoingFetch:%s, SnsCore.getSnsUnreadTipManager().isAutoScrolling:%s", new Object[] { Boolean.valueOf(af.dtD().wJM), Boolean.valueOf(af.dtD().wJL) });
          if ((!af.dtD().wJL) && (localObject1 != null) && (i == 0) && (((View)localObject1).getTop() == 0) && (SnsTimeLineUI.d(SnsTimeLineUI.this).xrF))
          {
            if (af.dtD().wJM)
            {
              AppMethodBeat.o(179237);
              return;
            }
            Object localObject2 = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this);
            localObject1 = SnsTimeLineUI.o(SnsTimeLineUI.this);
            i = as.wKi;
            boolean bool = SnsTimeLineUI.q(SnsTimeLineUI.this);
            int j = SnsTimeLineUI.A(SnsTimeLineUI.this);
            if ((((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).hasInit) && (((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).xGZ == 0))
            {
              long l = af.dtD().wJI;
              localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).xMU;
              if (((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).xFR != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).xFR.xZl;
                com.tencent.mm.vending.g.g.b(localObject1, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(j), Long.valueOf(l)).c((com.tencent.mm.vending.c.a)localObject2);
              }
            }
            if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
            {
              SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
              SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
            }
          }
          AppMethodBeat.o(179237);
        }
        
        public final View getMaskView()
        {
          AppMethodBeat.i(179231);
          View localView = SnsTimeLineUI.this.findViewById(2131304966);
          AppMethodBeat.o(179231);
          return localView;
        }
        
        public final ListView getSnsListView()
        {
          AppMethodBeat.i(179229);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).list == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).list = ((ListView)SnsTimeLineUI.this.findViewById(2131305038));
          }
          ListView localListView = SnsTimeLineUI.k(SnsTimeLineUI.this).list;
          AppMethodBeat.o(179229);
          return localListView;
        }
        
        public final int getType()
        {
          int i = 1;
          if (SnsTimeLineUI.this.xGZ == 1) {
            i = 2;
          }
          return i;
        }
        
        public final void ht(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void qt(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(179240);
          SnsTimeLineUI localSnsTimeLineUI = SnsTimeLineUI.this;
          localSnsTimeLineUI.xGQ = paramAnonymousBoolean;
          com.tencent.mm.sdk.platformtools.ap localap = af.czA();
          com.tencent.mm.plugin.sns.model.f localf = af.dtr();
          com.tencent.mm.plugin.sns.model.b localb = af.dtp();
          if (paramAnonymousBoolean)
          {
            if ((localf.wDv) || (localb.wDv))
            {
              localap.removeCallbacks(localSnsTimeLineUI.xGR);
              localap.removeCallbacks(localSnsTimeLineUI.xGS);
              localap.postDelayed(localSnsTimeLineUI.xGR, 0L);
              AppMethodBeat.o(179240);
            }
          }
          else if ((!localf.wDv) || (!localb.wDv))
          {
            localap.removeCallbacks(localSnsTimeLineUI.xGR);
            localap.removeCallbacks(localSnsTimeLineUI.xGS);
            localap.postDelayed(localSnsTimeLineUI.xGS, 0L);
          }
          AppMethodBeat.o(179240);
        }
      };
      this.xGW = 0L;
      this.xGX = new a.b() {};
      this.mScreenWidth = 0;
      this.mScreenHeight = 0;
      this.xGY = true;
      this.tlW = 0L;
      this.fXQ = 0L;
      this.hcE = 0L;
      this.xuu = new bh.a()
      {
        public final void P(String paramAnonymousString, long paramAnonymousLong)
        {
          AppMethodBeat.i(187723);
          ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
          SnsTimeLineUI.L(SnsTimeLineUI.this);
          AppMethodBeat.o(187723);
        }
      };
      this.xGZ = 0;
      this.xHa = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(179272);
          SnsTimeLineUI.this.hideVKB();
          SnsTimeLineUI.this.finish();
          AppMethodBeat.o(179272);
          return false;
        }
      };
      this.xHd = false;
      AppMethodBeat.o(99372);
      return;
    }
  }
  
  private void NB(int paramInt)
  {
    AppMethodBeat.i(99376);
    if (xGO.booleanValue()) {
      if (paramInt != 0) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.SnsTimeLineUI", "setRefreshAnimVisible %s %s", new Object[] { Boolean.valueOf(bool), bt.eGN().toString() });
      this.xFX.setVisibility(paramInt);
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
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(15827, paramc.toString());
    }
    AppMethodBeat.o(99406);
  }
  
  private void dCc()
  {
    AppMethodBeat.i(99377);
    this.mUIAction.list.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179226);
        int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
        int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
        ad.d("MicroMsg.SnsTimeLineUI", "notifyList from:%s to:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        SnsTimeLineUI.a(SnsTimeLineUI.this, i, j);
        SnsTimeLineUI.d(SnsTimeLineUI.this).bcc();
        AppMethodBeat.o(179226);
      }
    }, 15L);
    AppMethodBeat.o(99377);
  }
  
  private void dCd()
  {
    AppMethodBeat.i(99380);
    boolean bool;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pjO, 0) == 1)
    {
      bool = true;
      this.autoPlay = bool;
      String str1 = Build.MODEL.toLowerCase();
      String str2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pjP, "");
      if ((!bt.isNullOrNil(str2)) && (str2.contains(str1)))
      {
        ad.i("MicroMsg.SnsTimeLineUI", "model %s is hit, expt:%s", new Object[] { str1, str2 });
        this.autoPlay = false;
      }
      if (!this.autoPlay) {
        break label225;
      }
      if (!this.xGr.dBB()) {
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
      if (this.xGr.bVA())
      {
        ad.i("MicroMsg.SnsTimeLineUI", "wifi autoplay true");
        this.autoPlay = true;
      }
      else
      {
        this.autoPlay = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fnq, Boolean.TRUE)).booleanValue();
        continue;
        label225:
        ad.i("MicroMsg.SnsTimeLineUI", "autoPlay DynamicConfig false");
      }
    }
  }
  
  private void dCe()
  {
    AppMethodBeat.i(99381);
    if (this.xGZ == 1)
    {
      if (!this.xng)
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99381);
        return;
      }
      addIconOptionMenu(0, getString(2131763911), 2131689502, new SnsTimeLineUI.35(this));
      AppMethodBeat.o(99381);
      return;
    }
    addIconOptionMenu(0, 2131763730, 2131690361, new SnsTimeLineUI.36(this), new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179252);
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).xkY != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).xkY.wIv.pO(true);
        }
        com.tencent.mm.kernel.g.afC();
        boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(7490, Boolean.TRUE)).booleanValue();
        af.dtB().qe(true);
        paramAnonymousView = af.dtB().apL("draft_text");
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.field_draft;
          if (!bt.cw(paramAnonymousView))
          {
            com.tencent.mm.kernel.g.afC();
            localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fis, "");
            new cn().QE().jg((String)localObject).aBj();
            localObject = Parcel.obtain();
            ((Parcel)localObject).unmarshall(paramAnonymousView, 0, paramAnonymousView.length);
            ((Parcel)localObject).setDataPosition(0);
          }
        }
        try
        {
          paramAnonymousView = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject);
          if (SnsTimeLineUI.aH(paramAnonymousView))
          {
            SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
            AppMethodBeat.o(179252);
            return true;
          }
          af.dtB().b("draft_text", null, 0);
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            af.dtB().b("draft_text", null, 0);
            continue;
            paramAnonymousView = SnsTimeLineUI.this;
            localObject = new Intent().setClass(SnsTimeLineUI.this, SnsLongMsgUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$42", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$42", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afB().afk().set(7490, Boolean.FALSE);
          }
        }
        if (!bool)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(SnsTimeLineUI.this, SnsUploadUI.class);
          paramAnonymousView.putExtra("KSnsPostManu", true);
          paramAnonymousView.putExtra("KTouchCameraTime", bt.aGK());
          paramAnonymousView.putExtra("sns_comment_type", 1);
          paramAnonymousView.putExtra("Ksnsupload_type", 9);
          localObject = com.tencent.mm.modelsns.d.oE(705);
          ((com.tencent.mm.modelsns.d)localObject).oI(((com.tencent.mm.modelsns.d)localObject).htj).zj(System.currentTimeMillis()).oI(((com.tencent.mm.modelsns.d)localObject).htk).oI(1);
          localObject = com.tencent.mm.plugin.sns.k.h.wRM.b((com.tencent.mm.modelsns.d)localObject);
          ((com.tencent.mm.modelsns.d)localObject).aBj();
          ((com.tencent.mm.modelsns.d)localObject).b(paramAnonymousView, "intent_key_StatisticsOplog");
          SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 9);
          AppMethodBeat.o(179252);
          return true;
        }
      }
    });
    AppMethodBeat.o(99381);
  }
  
  private void dCf()
  {
    AppMethodBeat.i(99392);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fxw, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fxw, Boolean.FALSE);
    if (bool) {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fxw, Boolean.FALSE);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.g.afC();
      int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FuM, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(getContext(), "", getContext().getResources().getString(2131764291, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(99392);
      return;
    }
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).startStoryCaptureForResult(getContext(), 0, System.currentTimeMillis(), 18);
    AppMethodBeat.o(99392);
  }
  
  private void dCg()
  {
    AppMethodBeat.i(99393);
    if (com.tencent.mm.r.a.cc(this))
    {
      AppMethodBeat.o(99393);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 18, "", "");
    ad.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this });
    if (!bool)
    {
      AppMethodBeat.o(99393);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 18, "", "");
    ad.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), this });
    if (!bool)
    {
      AppMethodBeat.o(99393);
      return;
    }
    long l = ce.asR();
    Object localObject1 = com.tencent.mm.plugin.sns.data.q.dsd();
    ad.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", new Object[] { localObject1 });
    com.tencent.mm.plugin.report.service.h.vKh.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), localObject1, Long.valueOf(l) });
    Object localObject2 = new SightParams(2, 0);
    localObject2 = RecordConfigProvider.a("", "", ((SightParams)localObject2).gCB, ((SightParams)localObject2).gCB.duration * 1000, 2);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pqf, false)) {
      ((RecordConfigProvider)localObject2).vhB = 2;
    }
    Object localObject3 = new VideoCaptureReportInfo();
    ((VideoCaptureReportInfo)localObject3).pOf = 1;
    ((RecordConfigProvider)localObject2).vhY = ((VideoCaptureReportInfo)localObject3);
    localObject3 = new UICustomParam.a();
    ((UICustomParam.a)localObject3).XZ();
    ((UICustomParam.a)localObject3).Ya();
    ((UICustomParam.a)localObject3).cO(true);
    ((RecordConfigProvider)localObject2).vhI = ((UICustomParam.a)localObject3).fHa;
    localObject3 = new SnsTimeLineUI.62(this);
    CaptureDataManager.vhw.vhv = ((CaptureDataManager.b)localObject3);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pqd, true))
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 17, 2130772137, 2130772138, (RecordConfigProvider)localObject2);
      AppMethodBeat.o(99393);
      return;
    }
    localObject2 = new Intent();
    com.tencent.mm.pluginsdk.ui.tools.q.c(getContext(), (Intent)localObject2, (String)localObject1);
    AppMethodBeat.o(99393);
  }
  
  private void dlP()
  {
    AppMethodBeat.i(99391);
    setTitleBarClickListener(new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(179273);
        SnsTimeLineUI.Q(SnsTimeLineUI.this);
        AppMethodBeat.o(179273);
      }
    }, new Runnable()
    {
      public final void run() {}
    });
    setBackBtn(this.xHa, 2131689490);
    AppMethodBeat.o(99391);
  }
  
  private boolean eJ(View paramView)
  {
    AppMethodBeat.i(187725);
    try
    {
      if (getContext() != null)
      {
        boolean bool = getContext().isFinishing();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(187725);
        return false;
      }
      Rect localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      paramView = new DisplayMetrics();
      getContext().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      int i = paramView.heightPixels;
      int j = this.mActionBar.getHeight() + ai.jl(this);
      ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "lxl checkItemVisible actionbar height:%s, total height:%s, screenHeight:%s, top:%s, bottom:%s", new Object[] { Integer.valueOf(this.mActionBar.getHeight()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localRect.top), Integer.valueOf(localRect.bottom) });
      if ((localRect.bottom > j) && (i > localRect.top))
      {
        AppMethodBeat.o(187725);
        return true;
      }
    }
    catch (Throwable paramView)
    {
      ad.e("MicroMsg.SnsTimeLineUI.ScreenShot", paramView.toString());
      AppMethodBeat.o(187725);
      return false;
    }
    AppMethodBeat.o(187725);
    return false;
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, final com.tencent.mm.plugin.sns.c.b paramb)
  {
    AppMethodBeat.i(187724);
    ad.i("MicroMsg.SnsTimeLineUI", "onOtherAddSize respMaxSeq:%s, respMinSeq:%s", new Object[] { paramString1, paramString2 });
    this.xGT.removeCallbacks(this.xGu);
    com.tencent.mm.vending.g.g.fhq().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(187724);
  }
  
  public final void a(final String paramString, boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.c.b paramb)
  {
    AppMethodBeat.i(99373);
    this.xGT.removeCallbacks(this.xGu);
    com.tencent.mm.vending.g.g.fhq().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(99373);
  }
  
  public final void arI()
  {
    AppMethodBeat.i(99396);
    agy().bf(c.b.class);
    AppMethodBeat.o(99396);
  }
  
  public final void arJ() {}
  
  public final void arK()
  {
    AppMethodBeat.i(99397);
    if (this.xHd)
    {
      AppMethodBeat.o(99397);
      return;
    }
    ad.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
    this.xHd = true;
    af.czA().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179281);
        if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
          SnsTimeLineUI.a(SnsTimeLineUI.this).xMy.notifyVendingDataChange();
        }
        SnsTimeLineUI.Y(SnsTimeLineUI.this);
        AppMethodBeat.o(179281);
      }
    }, 1000L);
    AppMethodBeat.o(99397);
  }
  
  public final void arL()
  {
    AppMethodBeat.i(99400);
    agy().bf(c.b.class);
    AppMethodBeat.o(99400);
  }
  
  public final void b(final String paramString, final boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.c.b paramb)
  {
    AppMethodBeat.i(99374);
    this.xGT.removeCallbacks(this.xGu);
    com.tencent.mm.vending.g.g.fhq().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
    {
      private Void a(Void paramAnonymousVoid)
      {
        AppMethodBeat.i(179220);
        if (SnsTimeLineUI.l(SnsTimeLineUI.this) != null)
        {
          SnsTimeLineUI.m(SnsTimeLineUI.this);
          SnsTimeLineUI.l(SnsTimeLineUI.this).dCv();
        }
        SnsTimeLineUI.d(SnsTimeLineUI.this).nEj = paramb.drF();
        if (SnsTimeLineUI.this.xGZ == 0)
        {
          ad.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[] { Boolean.valueOf(paramb.drF()) });
          if (paramb.drF()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).aqE(paramb.drL());
          }
          AppMethodBeat.o(179220);
          return paramAnonymousVoid;
        }
        if ((paramBoolean) && (!SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))))
        {
          SnsTimeLineUI.d(SnsTimeLineUI.this).nEj = true;
          SnsTimeLineUI.d(SnsTimeLineUI.this).aqs(paramb.drL());
        }
        for (;;)
        {
          AppMethodBeat.o(179220);
          return paramAnonymousVoid;
          if ((SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))) && (paramb.drK() != 0L))
          {
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.FnI, Long.valueOf(paramb.drK()));
          }
          if (paramb.drF()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).aqE(paramb.drL());
          }
        }
      }
    });
    AppMethodBeat.o(99374);
  }
  
  public final com.tencent.mm.plugin.sns.a.b.i dCh()
  {
    return this.xwT;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(99378);
    ad.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[] { paramKeyEvent.toString() });
    int k = keyboardState();
    i locali = this.xGa;
    int i = j;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      i = j;
      if (locali.xlc.getVisibility() == 0)
      {
        locali.xlc.setVisibility(8);
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
  
  public final boolean dzb()
  {
    AppMethodBeat.i(99395);
    if ((this.xGa == null) || (this.xGa.xlj == null))
    {
      AppMethodBeat.o(99395);
      return false;
    }
    if ((this.xGa == null) || (this.xGa.xlk == null))
    {
      if ((this.xGa != null) && (this.xGa.xlm != null)) {
        break label118;
      }
      label65:
      if ((this.xGa != null) && (this.xGa.xln != null)) {
        break label132;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.drm();
      boolean bool = this.xGa.xlj.dzb();
      AppMethodBeat.o(99395);
      return bool;
      this.xGa.xlk.duJ();
      break;
      label118:
      this.xGa.xlm.duJ();
      break label65;
      label132:
      this.xGa.xln.dDa();
    }
  }
  
  public final boolean eF(View paramView)
  {
    AppMethodBeat.i(99394);
    this.xGa.xlk.duJ();
    this.xGa.xlm.duJ();
    bm localbm = this.xGa.xlj;
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      ad.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
      AppMethodBeat.o(99394);
      return false;
    }
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    Object localObject1 = localBaseViewHolder.dgg;
    if (localbm.xLP != null)
    {
      if ((localbm.xLP.getTag() instanceof bm.a))
      {
        localObject2 = (bm.a)localbm.xLP.getTag();
        if (((bm.a)localObject2).wMT.equals(localObject1))
        {
          localbm.eK(((bm.a)localObject2).wwV);
          AppMethodBeat.o(99394);
          return true;
        }
        localbm.dzb();
      }
      localbm.xLP = null;
    }
    localbm.xLP = new SnsCommentShowAbLayout(localbm.mContext);
    com.tencent.mm.sdk.platformtools.p.eFg();
    localbm.xLP.setId(2131296470);
    new FrameLayout.LayoutParams(-1, -1);
    localbm.wMz.addView(localbm.xLP);
    int i = BackwardSupportUtil.b.g(localbm.mContext, 192.0F);
    int j = BackwardSupportUtil.b.g(localbm.mContext, 76.0F);
    BackwardSupportUtil.b.g(localbm.mContext, 8.0F);
    int k = BackwardSupportUtil.b.g(localbm.mContext, 16.0F);
    int m = BackwardSupportUtil.b.g(localbm.mContext, 40.0F);
    Object localObject2 = y.js(localbm.mContext).inflate(2131495535, null);
    new Rect();
    Object localObject3 = new int[2];
    com.tencent.mm.pluginsdk.g.gW(localbm.mContext);
    int n = com.tencent.mm.cd.a.fromDPToPix(localbm.mContext, 1);
    paramView.getLocationInWindow((int[])localObject3);
    localbm.wxW = ai.jl(localbm.mContext);
    ad.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + n + " height_hardcode:" + j + " statusBarHeight: " + localbm.wxW);
    localObject3 = new AbsoluteLayout.LayoutParams(-2, -2, localObject3[0] - i + k, localObject3[1] - n - (m / 2 - paramView.getMeasuredHeight() / 2));
    localObject1 = new bm.a(localbm, (String)localObject1, (View)localObject2);
    localbm.xLP.setTag(localObject1);
    localbm.xLP.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    if (localBaseViewHolder.nBH == 10) {
      ((View)localObject2).findViewById(2131296548).setBackgroundResource(2131232447);
    }
    ((View)localObject2).setVisibility(8);
    new com.tencent.mm.sdk.platformtools.ap().post(new bm.1(localbm, paramView, (View)localObject2));
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
    this.mUIAction.wOn.setDrawingCacheEnabled(false);
    this.xGa.wMz = ((FrameLayout)findViewById(2131305824));
    int i = af.dtC().position;
    Object localObject = (AdListView)this.mUIAction.getSnsListView();
    ((AdListView)localObject).xjv = this.xwT;
    ((AdListView)localObject).setTimelineStat(this.xGi);
    ((AdListView)localObject).setTimelineEvent(this.xGj);
    this.xGj.a(af.dtl());
    ad.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.xlh, new Object[] { Integer.valueOf(i) });
    this.xFX = ((QFadeImageView)findViewById(2131305048));
    this.xFX.setImageResource(2131690250);
    this.xGc = new a(this.mUIAction.getSnsListView());
    this.xGc.setInterpolator(new LinearInterpolator());
    this.xGc.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(179259);
        ad.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
        AppMethodBeat.o(179259);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(179258);
        ad.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
        AppMethodBeat.o(179258);
      }
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(179257);
        ad.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
        AppMethodBeat.o(179257);
      }
    });
    localObject = null;
    if (this.xGZ == 1)
    {
      this.xFZ = true;
      localObject = new com.tencent.mm.plugin.sns.ui.a.b.d(this.kGt, this.xng);
    }
    this.xFU = new com.tencent.mm.plugin.sns.ui.a.c(this, this.mUIAction.getSnsListView(), this.xGa.xlo, this.xGa, this.xGk, (com.tencent.mm.plugin.sns.ui.a.b.b)localObject, this.xGx);
    this.xGa.xlo.xUe = new be.b()
    {
      public final boolean dCb()
      {
        AppMethodBeat.i(179260);
        SnsTimeLineUI.this.agy().bf(c.b.class);
        AppMethodBeat.o(179260);
        return false;
      }
    };
    this.xGa.wNd = this.xFU.xMx;
    this.xFU.xMy.HOP = new com.tencent.mm.vending.a.b.a()
    {
      public final void dCr()
      {
        AppMethodBeat.i(179261);
        com.tencent.mm.plugin.report.service.g.KI(14);
        AppMethodBeat.o(179261);
      }
      
      public final void dCs()
      {
        AppMethodBeat.i(179262);
        com.tencent.mm.plugin.report.service.g.KJ(14);
        AppMethodBeat.o(179262);
      }
    };
    this.xGd = ((TestTimeForSns)this.xGa.wMz);
    this.xGd.setListener(new TestTimeForSns.a()
    {
      public final void cAy()
      {
        AppMethodBeat.i(179264);
        ad.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
        SnsTimeLineUI.H(SnsTimeLineUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179263);
            if ((SnsTimeLineUI.a(SnsTimeLineUI.this) == null) || (SnsTimeLineUI.H(SnsTimeLineUI.this) == null))
            {
              ad.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
              AppMethodBeat.o(179263);
              return;
            }
            SnsTimeLineUI.H(SnsTimeLineUI.this).setListener(null);
            SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.N(SnsTimeLineUI.this));
            if (SnsTimeLineUI.O(SnsTimeLineUI.this))
            {
              ad.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
              AppMethodBeat.o(179263);
              return;
            }
            if (SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              af.dtk().N(af.dtC().wIQ, -1);
              af.dtk().sP(af.dtC().wIR);
            }
            if (!SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              ad.i("MicroMsg.SnsTimeLineUI", "onViewDrawed doFpList");
              com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
              SnsTimeLineUI.n(SnsTimeLineUI.this);
              localc.d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FuD, Integer.valueOf(1));
            }
            SnsTimeLineUI.a(SnsTimeLineUI.this, false);
            if (SnsTimeLineUI.this.xwT != null) {
              SnsTimeLineUI.this.xwT.pH(false);
            }
            AppMethodBeat.o(179263);
          }
        });
        AppMethodBeat.o(179264);
      }
    });
    this.mUIAction.list.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179265);
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          SnsTimeLineUI.this.dzb();
          if ((SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) && (SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() == 0)) {
            ad.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
          }
          SnsTimeLineUI.l(SnsTimeLineUI.this).dCw();
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          }
          SnsTimeLineUI.k(SnsTimeLineUI.this).dyK();
          SnsTimeLineUI.k(SnsTimeLineUI.this).xld.dCZ();
        }
        AppMethodBeat.o(179265);
        return false;
      }
    });
    this.mUIAction.list.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99335);
        if (SnsTimeLineUI.k(SnsTimeLineUI.this) == null)
        {
          AppMethodBeat.o(99335);
          return;
        }
        SnsTimeLineUI.k(SnsTimeLineUI.this).xld.xwB = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getBottom();
        SnsTimeLineUI.k(SnsTimeLineUI.this).xld.xLU = SnsTimeLineUI.d(SnsTimeLineUI.this).twE.getTop();
        SnsTimeLineUI.l(SnsTimeLineUI.this).xHH = ao.fromDPToPix(SnsTimeLineUI.this.getContext(), -44);
        AppMethodBeat.o(99335);
      }
    });
    this.mUIAction.twE.setOnSrcollDistance(new MMPullDownView.f()
    {
      public final void bv(float paramAnonymousFloat)
      {
        AppMethodBeat.i(179266);
        SnsTimeLineUI.P(SnsTimeLineUI.this);
        if (SnsTimeLineUI.xGO.booleanValue()) {
          ad.i("MicroMsg.SnsTimeLineUI", "mUIAction.header.getTop %s originalHeaderTop %s distanceY %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).wOn.getTop()), Integer.valueOf(SnsTimeLineUI.l(SnsTimeLineUI.this).xHH), Float.valueOf(paramAnonymousFloat) });
        }
        if (((SnsTimeLineUI.d(SnsTimeLineUI.this).wOn.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).xHH) || (paramAnonymousFloat > 0.0F)) && (!SnsTimeLineUI.d(SnsTimeLineUI.this).xrF)) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).bw(paramAnonymousFloat);
        }
        SnsTimeLineUI.k(SnsTimeLineUI.this).dyK();
        SnsTimeLineUI.this.dzb();
        SnsTimeLineUI.k(SnsTimeLineUI.this).xld.dCZ();
        AppMethodBeat.o(179266);
      }
      
      public final void dCt()
      {
        AppMethodBeat.i(179267);
        if (!SnsTimeLineUI.d(SnsTimeLineUI.this).xrF) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).dCw();
        }
        AppMethodBeat.o(179267);
      }
    });
    this.xGa.xlc = ((SnsCommentFooter)findViewById(2131298521));
    this.xGa.xlc.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99337);
        com.tencent.mm.compatible.util.i.v(SnsTimeLineUI.this);
        AppMethodBeat.o(99337);
      }
    });
    this.xGa.xld = new bn(this.mUIAction.list, this.xGa.xlc);
    this.xFV = ((LinearLayout)this.mUIAction.wOn.findViewById(2131305028));
    this.xFV.findViewById(2131305024).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179268);
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).xkY != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).xkY.wIv.pN(true);
        }
        paramAnonymousView = (c.b)SnsTimeLineUI.this.agy().w(c.b.class);
        com.tencent.mm.modelsns.d locald = com.tencent.mm.modelsns.d.oE(725);
        locald.oH(paramAnonymousView.rAb);
        locald.aBj();
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
        paramAnonymousView.putExtra("sns_msg_comment_list_scene", 1);
        SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 13);
        AppMethodBeat.o(179268);
      }
    });
    this.xFW = ((LinearLayout)this.mUIAction.wOn.findViewById(2131305029));
    this.xGa.xle = new av(this);
    dCe();
    dlP();
    boolean bool1;
    label591:
    boolean bool2;
    if (this.xGZ == 0)
    {
      setMMTitle(2131764037);
      if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.h.DEBUG)) {
        break label923;
      }
      bool1 = true;
      if (1 != ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pvy, 0)) {
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
      com.tencent.mm.sdk.platformtools.p.uR(bool1);
      if (bool1)
      {
        i = com.tencent.mm.sdk.platformtools.p.eFh();
        if (i > 2048) {
          break label933;
        }
        com.tencent.mm.plugin.report.service.h.vKh.dB(1198, 7);
      }
    }
    for (;;)
    {
      this.xGs = ((ViewGroup)findViewById(2131305092));
      this.xGs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179269);
          SnsTimeLineUI.k(SnsTimeLineUI.this).dyP();
          com.tencent.mm.plugin.sns.k.f.wQY.wRE.dWy = 2L;
          AppMethodBeat.o(179269);
        }
      });
      this.xGs.setVisibility(4);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = (ao.fromDPToPix(getContext(), 24) + com.tencent.mm.ui.ap.dL(getContext()) + com.tencent.mm.ui.ap.iX(getContext()));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.xGs.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(99388);
      return;
      if (this.xng)
      {
        setMMTitle(2131763939);
        NB(8);
        break;
      }
      ad.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, userName:%s, title:%s", new Object[] { this.kGt, this.mUIAction.title });
      localObject = af.dti().aHY(this.kGt);
      if (localObject != null) {
        ad.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is not null");
      }
      for (localObject = ((com.tencent.mm.n.b)localObject).ZX();; localObject = this.mUIAction.title)
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
        com.tencent.mm.plugin.report.service.h.vKh.dB(1198, 8);
      } else if (i <= 6144) {
        com.tencent.mm.plugin.report.service.h.vKh.dB(1198, 9);
      } else if (i <= 8192) {
        com.tencent.mm.plugin.report.service.h.vKh.dB(1198, 10);
      } else {
        com.tencent.mm.plugin.report.service.h.vKh.dB(1198, 11);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99402);
    ad.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 15)
    {
      if ((this.xGa != null) && (this.xGa.xlo != null) && (this.xGa.xlo.xTt != null))
      {
        this.xGa.xlo.xTt.onActivityResult(paramInt1, paramInt2, paramIntent);
        com.tencent.mm.sdk.platformtools.aq.n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179284);
            SnsTimeLineUI.this.hideVKB();
            AppMethodBeat.o(179284);
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
          this.xGa.xlc.imP.showVKB();
          String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(localObject[0]);
          if (!bt.isNullOrNil(str))
          {
            this.xGa.xlc.dBe();
            this.xGa.xlc.setText("@" + str + " ");
            this.xGa.xlc.setCommentAtPrefix("@" + str + " ");
            this.xGa.xlc.setCommentInfo(new cuo());
            this.xGa.xlc.getCommentInfo().Username = localObject[0];
            this.xGa.xlc.setCommentFlag(8);
          }
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mUIAction.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 11)
    {
      this.xFT.d(this.kGt, this.xGl, this.xng, this.xGm);
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
    com.tencent.mm.sdk.b.a.ESL.l(new cf());
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    Point localPoint = new Point();
    localPoint.x = paramConfiguration.widthPixels;
    localPoint.y = paramConfiguration.heightPixels;
    af.f(localPoint);
    com.tencent.mm.plugin.sns.ui.widget.f.dEn().xXY = 0;
    com.tencent.mm.plugin.sns.ui.widget.d.dEk().xXY = 0;
    com.tencent.mm.kiss.widget.textview.c.ggt.agC();
    this.xFU.xMx.dBS();
    this.xFU.xMy.resolvedClear();
    AppMethodBeat.o(99382);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 1;
    AppMethodBeat.i(99379);
    Object localObject1;
    if (xGo == null)
    {
      xGo = Boolean.valueOf(ai.Eq());
      com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
      com.tencent.mm.plugin.sns.model.b.a.duB();
      localObject1 = af.dts();
      ((com.tencent.mm.plugin.sns.model.au)localObject1).hzd = true;
      ad.i("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.sns.model.au)localObject1).hzd) });
      if (((((com.tencent.mm.plugin.sns.model.au)localObject1).hzd) && (!com.tencent.mm.plugin.sns.model.b.a.duC())) || (((com.tencent.mm.plugin.sns.model.au)localObject1).hzc)) {
        ((com.tencent.mm.plugin.sns.model.au)localObject1).dum();
      }
      o.aCK().eA(((com.tencent.mm.plugin.sns.model.au)localObject1).hzd);
      localObject1 = af.dtD();
      if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
        break label683;
      }
      ((ar)localObject1).wJr = true;
      ((ar)localObject1).wJs = 1L;
      ((ar)localObject1).wJt = 86400L;
      ((ar)localObject1).wJu = 1;
      ((ar)localObject1).wJv = 1;
      ((ar)localObject1).wJw = 50;
      ((ar)localObject1).wJy = 2;
      ((ar)localObject1).wJx = 5;
      ((ar)localObject1).wJz = 0L;
      label170:
      ad.i("MicroMsg.SnsUnreadTipManager", "jumpEnable:%s, jumpMinInterval:%s, jumpMaxInterval:%s, jumpMinFeedsCount:%s, jumpMinFeedsGapCount:%s, jumpNotWsPercent:%s, jumpIndicatorIndexOffset:%s, jumpReadContinuousCount:%s, jumpIndicatorExposeInterval:%s", new Object[] { Boolean.valueOf(((ar)localObject1).wJr), Long.valueOf(((ar)localObject1).wJs), Long.valueOf(((ar)localObject1).wJt), Integer.valueOf(((ar)localObject1).wJu), Integer.valueOf(((ar)localObject1).wJv), Integer.valueOf(((ar)localObject1).wJw), Integer.valueOf(((ar)localObject1).wJy), Integer.valueOf(((ar)localObject1).wJx), Long.valueOf(((ar)localObject1).wJz) });
      if (((ar)localObject1).wJr) {
        ((ar)localObject1).wJq = (af.getAccSnsPath() + "snsUnread.proto");
      }
    }
    int i;
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = com.tencent.mm.vfs.i.aR(((ar)localObject1).wJq, 0, -1);
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          ((ar)localObject1).wJN.parseFrom(arrayOfByte);
          i = ce.asT();
          ad.i("MicroMsg.SnsUnreadTipManager", "unreadSnsIdList.indicatorExposeTime:%s, now:%s, jumpIndicatorExposeInterval:%s", new Object[] { Long.valueOf(((ar)localObject1).wJN.wJR), Integer.valueOf(i), Long.valueOf(((ar)localObject1).wJz) });
          if ((((ar)localObject1).wJN.wJR <= 0L) || (i - ((ar)localObject1).wJN.wJR <= ((ar)localObject1).wJz)) {
            continue;
          }
          ((ar)localObject1).wJN.wJR = 0L;
          ((ar)localObject1).wJR = ((ar)localObject1).wJN.wJR;
          ((ar)localObject1).duf();
        }
      }
      catch (IOException localIOException)
      {
        label683:
        ad.w("MicroMsg.SnsUnreadTipManager", "IOException:%s", new Object[] { localIOException.getMessage() });
        continue;
        this.uAo = findViewById(2131296345);
        if (this.uAo == null) {
          break label1201;
        }
      }
      ((ar)localObject1).dud();
      ((ar)localObject1).due();
      ad.i("MicroMsg.SnsUnreadTipManager", "firstUnreadId:%s unreadSnsIdList.lastSnsId:%s", new Object[] { Long.valueOf(((ar)localObject1).wJE), Long.valueOf(((ar)localObject1).wJN.wOg) });
      ((ar)localObject1).dug();
      ((ar)localObject1).sessionId = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbl();
      localObject1 = ((ar)localObject1).wJX;
      com.tencent.mm.kernel.g.afA().gcy.a(211, (com.tencent.mm.al.g)localObject1);
      if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class) != null) {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).OY("__sns_timeline__");
      }
      if (this.mController != null) {
        this.mController.aT(2, true);
      }
      getIntent().setExtrasClassLoader(getClass().getClassLoader());
      com.tencent.mm.pluginsdk.g.o(this);
      customfixStatusbar(true);
      super.onCreate(paramBundle);
      if (!com.tencent.mm.kernel.g.afz().aeI())
      {
        finish();
        AppMethodBeat.o(99379);
        return;
        if (xGo.booleanValue() == ai.Eq()) {
          break;
        }
        ad.i("MicroMsg.SnsTimeLineUI", "dancy test UIMode change!!");
        xGo = Boolean.valueOf(ai.Eq());
        com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
        break;
        if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE))
        {
          ((ar)localObject1).wJr = true;
          ((ar)localObject1).wJs = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwK, 120L);
          ((ar)localObject1).wJu = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwL, 5);
          ((ar)localObject1).wJv = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwN, 3);
          ((ar)localObject1).wJt = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwO, 86400L);
          ((ar)localObject1).wJw = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwP, 50);
          ((ar)localObject1).wJy = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwR, 5);
          ((ar)localObject1).wJx = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwQ, 30);
          ((ar)localObject1).wJz = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwS, 0);
          break label170;
        }
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwM, 0) == 1)
        {
          bool = true;
          ((ar)localObject1).wJr = bool;
          ((ar)localObject1).wJs = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwK, 0);
          ((ar)localObject1).wJu = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwL, 0);
          ((ar)localObject1).wJv = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwN, 0);
          ((ar)localObject1).wJt = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwO, 86400L);
          ((ar)localObject1).wJw = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwP, 50);
          ((ar)localObject1).wJy = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwR, 5);
          ((ar)localObject1).wJx = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwQ, 30);
          ((ar)localObject1).wJz = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwS, 0);
          break label170;
        }
        bool = false;
        continue;
        if (((ar)localObject1).wJN.wJR >= 0L) {
          continue;
        }
        ((ar)localObject1).wJN.wJR = 0L;
        continue;
      }
      if (com.tencent.mm.ui.statusbar.c.HlA) {
        break label3342;
      }
    }
    label1201:
    getWindow().getDecorView().setSystemUiVisibility(1280);
    paramBundle = com.tencent.mm.sdk.platformtools.aj.eFE();
    if (paramBundle != null) {}
    label1922:
    label3595:
    for (boolean bool = paramBundle.getBoolean("Main_need_read_top_margin", false);; bool = false)
    {
      com.tencent.mm.ui.b.c(this, bool);
      this.xGb = ((int)(getResources().getDisplayMetrics().heightPixels * 0.4D));
      setActionbarColor(getContext().getResources().getColor(2131101053));
      hideActionbarLine();
      this.xGZ = getIntent().getIntExtra("sns_adapter_type", 0);
      this.xFZ = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
      this.mActionBar = getSupportActionBar();
      i = com.tencent.mm.model.c.d.atz().fK("Sns_Private_Recent_Setting_Guide", 0);
      ad.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = ".concat(String.valueOf(i)));
      if (i == 1)
      {
        com.tencent.mm.kernel.g.afC();
        if (!com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FnN, false))
        {
          paramBundle = getIntent();
          paramBundle.setClass(getContext(), SnsSettingIntroduceUI.class);
          paramBundle = new com.tencent.mm.hellhoundlib.b.a().bd(paramBundle);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.adn(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramBundle.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          overridePendingTransition(0, 0);
          finish();
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FnN, Boolean.TRUE);
        }
      }
      this.xGr.xBW = new az.b()
      {
        public final void dBD()
        {
          AppMethodBeat.i(179242);
          SnsTimeLineUI.I(SnsTimeLineUI.this);
          AppMethodBeat.o(179242);
        }
      };
      dCd();
      com.tencent.e.h.Iye.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179243);
          com.tencent.mm.ck.b.eOL();
          AppMethodBeat.o(179243);
        }
      });
      this.xFS.a(c.b.class, this.xGX);
      localObject1 = this.xFT;
      i = this.xGZ;
      paramBundle = getIntent();
      com.tencent.mm.plugin.sns.m.b localb = this.xFR;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xGZ = i;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = true;
      Object localObject2;
      if (i == 0)
      {
        localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMU;
        ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).xFR = localb;
        if (localb != null)
        {
          paramBundle = localb.dEw();
          label1602:
          ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).xFS = paramBundle;
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMU.xFS.a(this);
          label1620:
          paramBundle = this.xFT;
          if (paramBundle.xGZ != 0) {
            break label3562;
          }
          paramBundle = (com.tencent.mm.plugin.sns.m.c.a)paramBundle.xMU.xFS.w(com.tencent.mm.plugin.sns.m.c.a.class);
          label1649:
          this.kGt = paramBundle.kGt;
          this.xGk = paramBundle.xGk;
          this.xGl = paramBundle.xGl;
          this.xng = paramBundle.xng;
          this.xGm = paramBundle.xGm;
          localObject1 = paramBundle.ixE;
          paramBundle = paramBundle.bXk;
          this.mSessionId = com.tencent.mm.ui.e.aJX("123");
          this.xGn = String.valueOf(System.currentTimeMillis());
          this.mUIAction = new SnsUIAction(this);
          this.mUIAction.setSessionId(this.mSessionId);
          this.mUIAction.wQb = this.xGn;
          this.mUIAction.xJr = this.xGV;
          this.mUIAction.actionbarView = this.mActionBar.getCustomView();
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().ku(2);
          com.tencent.mm.plugin.sns.ui.widget.f.dEn().xXY = 0;
          com.tencent.mm.plugin.sns.ui.widget.d.dEk().xXY = 0;
          localObject2 = com.tencent.mm.modelsns.e.htu;
          com.tencent.mm.modelsns.e.aBk();
          if (!getIntent().getBooleanExtra("is_sns_notify_open", true)) {
            break label3570;
          }
          i = 1;
          label1837:
          this.xGa = new i(this, i, bt.by(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0), this.xGn);
          this.xGa.xlb = new i.b()
          {
            public final void dyP()
            {
              AppMethodBeat.i(179244);
              com.tencent.mm.plugin.report.service.h.vKh.dB(1295, 2);
              Object localObject = af.dtD();
              if (((ar)localObject).wJr) {
                af.dhI().post(new ar.3((ar)localObject));
              }
              com.tencent.mm.plugin.sns.k.f.wQY.wRE.dWx = 1L;
              localObject = af.dtD();
              int i;
              if ((!((ar)localObject).duc()) || (((ar)localObject).wJC.get(((ar)localObject).wJO.qaM.peek()) == null))
              {
                i = -1;
                localObject = af.dtD();
                if (((ar)localObject).duc()) {
                  break label390;
                }
              }
              com.tencent.mm.hellhoundlib.b.a locala;
              label390:
              for (int j = 0;; j = ((ar)localObject).wJO.qaM.size())
              {
                ad.d("MicroMsg.SnsTimeLineUI", "rightIndex:%s, targetSize:%s, adapter.count:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) });
                af.dtD().es(null);
                SnsTimeLineUI.J(SnsTimeLineUI.this).setVisibility(4);
                if ((i == -1) || (j + i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount())) {
                  break label405;
                }
                af.dtD().duk();
                af.dtD().wJI = 0L;
                j = SnsTimeLineUI.this.getResources().getDimensionPixelSize(2131166841);
                int k = com.tencent.mm.ui.ap.dL(SnsTimeLineUI.this.getContext());
                int m = com.tencent.mm.ui.ap.iX(SnsTimeLineUI.this.getContext());
                localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                locala = com.tencent.mm.hellhoundlib.b.c.a(i + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), com.tencent.mm.hellhoundlib.b.c.a(k + m - j, new com.tencent.mm.hellhoundlib.b.a()));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$37", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                ((ListView)localObject).smoothScrollToPositionFromTop(((Integer)locala.lS(0)).intValue(), ((Integer)locala.lS(1)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$37", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                AppMethodBeat.o(179244);
                return;
                i = ((Integer)((ar)localObject).wJC.get(((ar)localObject).wJO.qaM.peek())).intValue();
                break;
              }
              label405:
              if (!af.dtD().wJL)
              {
                af.dtD().duk();
                af.dtD().wJL = true;
                SnsTimeLineUI.a(SnsTimeLineUI.this).xMy.aqG(com.tencent.mm.plugin.sns.data.q.su(SnsTimeLineUI.a(SnsTimeLineUI.this).dDc()));
                SnsTimeLineUI.a(SnsTimeLineUI.this).xMy.aqH(com.tencent.mm.plugin.sns.data.q.su(SnsTimeLineUI.a(SnsTimeLineUI.this).qv(false)));
                af.dtD().wJI = af.dtD().dui();
                af.dtk().sP(af.dtD().dui());
                af.dtD().wJJ = as.wKh;
                localObject = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                locala = com.tencent.mm.hellhoundlib.b.c.a(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount() - 1 + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$37", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                ((ListView)localObject).smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$37", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
                {
                  SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
                  SnsTimeLineUI.B(SnsTimeLineUI.this).post(SnsTimeLineUI.C(SnsTimeLineUI.this));
                }
              }
              AppMethodBeat.o(179244);
            }
          };
          this.xlh = getIntent().getBooleanExtra("sns_resume_state", true);
          if (!af.dtd()) {
            break label3575;
          }
          this.xlh = false;
          this.xFY = this.xlh;
          this.mUIAction.a(this.xGk, this.kGt, (String)localObject1, paramBundle, this.xGl, this.xng, this.xGm);
          this.mUIAction.onCreate();
          af.dtl().init();
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(213, this);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(682, this);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(218, this);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(211, this);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(683, this);
          com.tencent.mm.plugin.sns.ui.video.d.dDS().dDT();
          initView();
          paramBundle = af.dtl();
          localObject1 = this.mUIAction.list;
          localObject2 = this.xFU.xMx;
          paramBundle.wNc = ((ListView)localObject1);
          paramBundle.wNd = ((be)localObject2);
          paramBundle = af.dtl();
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(291, paramBundle);
          this.xGa.qiE = ((ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard"));
          if (!af.dtd()) {
            break label3595;
          }
          this.xlh = false;
          label2153:
          paramBundle = this.xFS;
          paramBundle.xMy = this.xFU.xMy;
          localObject1 = paramBundle.xMy;
          paramBundle.HOQ.keep((com.tencent.mm.vending.e.a)localObject1);
          if ((!this.xlh) || (this.xGZ != 0)) {
            break label3615;
          }
          this.xFZ = false;
          int k = af.dtC().position;
          this.xFU.xMy.aqI(af.dtC().pLA);
          this.xFU.xMy.aqF(af.dtC().xrA);
          this.xFU.xMy.qw(true);
          this.xFU.xMy.aqJ(af.dtC().xrD);
          this.xFU.xMy.aqG(af.dtC().xrB);
          this.xFU.xMy.aqH(af.dtC().xrC);
          this.mUIAction.qu(af.dtC().xrF);
          this.xFU.tP();
          i = k;
          if (k >= this.xFU.getCount())
          {
            i = this.xFU.getCount() - 1;
            ad.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[] { Integer.valueOf(this.xFU.getCount()) });
          }
          this.mUIAction.list.setAdapter(this.xFU);
          ad.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[] { Integer.valueOf(af.dtC().xrE) });
          this.mUIAction.list.setSelectionFromTop(i, af.dtC().xrE);
          NB(4);
          dCc();
          i = this.xFU.getCount();
          k = this.mUIAction.list.getFirstVisiblePosition();
          if (k < i) {
            this.xGg = com.tencent.mm.plugin.sns.data.q.l(this.xFU.Ni(k));
          }
          com.tencent.mm.kernel.g.afC();
          this.xGe = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(327776, Integer.valueOf(0))).intValue();
          this.xGa.xlj = new bm(this, this.xFU.xMx, this.xGa.wMz);
          this.xGa.xll = new com.tencent.mm.plugin.sns.i.b(this, this.xFU.xMx.wMy, this.xGa.wMz);
          this.xGa.xlk = new b(this, this.xFU.xMx.wMy, this.xGa.wMz, this.xGa.xll);
          this.xGa.xlm = new aj(this, this.xFU.xMx.wMy, this.xGa.wMz);
          this.xGa.xln = new bo(this, this.xFU.xMx.wMy, this.xGa.wMz);
          if (this.xGj != null) {
            this.xGj.a(this.xGa.xll);
          }
          if (i > 0)
          {
            paramBundle = this.xFU.Ni(0);
            if ((this.xGa.xkY != null) && (this.xGa.xkY.wIv != null)) {
              this.xGa.xkY.wIv.wOL = paramBundle.field_snsId;
            }
            paramBundle = com.tencent.mm.plugin.sns.k.f.wQY;
            if (paramBundle.fYF != 0)
            {
              if (paramBundle.wQZ.isEmpty())
              {
                paramBundle.fjZ.setLong(2, bt.aGK());
                paramBundle.wRa.clear();
              }
              ad.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[] { Integer.valueOf(paramBundle.wQZ.size()) });
            }
          }
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(13312, "1," + bt.eGO());
          com.tencent.mm.sdk.b.a.ESL.c(this.xGv);
          if (getIntent().getBooleanExtra("is_need_resend_sns", false))
          {
            com.tencent.mm.sdk.platformtools.aq.n(new SnsTimeLineUI.32(this), 500L);
            getIntent().putExtra("is_need_resend_sns", false);
          }
          com.tencent.mm.kernel.g.afC();
          if (com.tencent.mm.kernel.g.afz().aeI())
          {
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afB().afk().set(589825, Boolean.FALSE);
          }
          paramBundle = this.xGa;
          localObject1 = this.xwT;
          paramBundle.xkX = ((com.tencent.mm.plugin.sns.a.b.i)localObject1);
          if (paramBundle.xlo != null) {
            paramBundle.xlo.b((com.tencent.mm.plugin.sns.a.b.i)localObject1);
          }
          this.xwT.a(this.mUIAction.wwY, this.mActionBar.getCustomView(), this);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGB);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGC);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGD);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGE);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGF);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGH);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGG);
          com.tencent.mm.sdk.b.a.ESL.c(this.wJd);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGI);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGJ);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGL);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGK);
          com.tencent.mm.sdk.b.a.ESL.c(this.xGM);
          com.tencent.mm.plugin.sns.abtest.c.drr();
          com.tencent.mm.plugin.sns.abtest.a.d(this, this.xGa.wMz);
          if (this.xGh != null)
          {
            paramBundle = this.xGh;
            localObject1 = this.mUIAction.list;
            localObject2 = this.mUIAction.wOn;
            paramBundle.izP = ((ListView)localObject1);
            paramBundle.wOn = ((SnsHeader)localObject2);
          }
          if ((this.xGa != null) && (this.xGa.xkY != null))
          {
            paramBundle = this.xGa.xkY.wIv;
            ad.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
            paramBundle.wOK = true;
            paramBundle.wQI = System.currentTimeMillis();
          }
          bool = getIntent().getBooleanExtra("enter_by_red", false);
          if ((this.xGa != null) && (this.xGa.xkY != null))
          {
            paramBundle = this.xGa.xkY.wIv;
            if (!bool) {
              break label3644;
            }
          }
        }
      }
      label3342:
      label3615:
      label3644:
      for (i = j;; i = 0)
      {
        paramBundle.wOX = i;
        af.dtr().wDQ.clear();
        if ((this.mUIAction != null) && (this.mUIAction.wOn != null)) {
          this.mUIAction.wOn.setStoryAction(new SnsStoryHeaderView.a()
          {
            public final void dCp()
            {
              AppMethodBeat.i(179248);
              SnsTimeLineUI.a locala = SnsTimeLineUI.l(SnsTimeLineUI.this);
              if (SnsTimeLineUI.u(locala.xHe).getVisibility() == 0)
              {
                locala.init();
                SnsTimeLineUI.u(locala.xHe).clearAnimation();
                SnsTimeLineUI.u(locala.xHe).startAnimation(locala);
                locala.tp(locala.DELAY_TIME + 100);
                locala.xHG = false;
              }
              AppMethodBeat.o(179248);
            }
          });
        }
        com.tencent.mm.sdk.b.a.ESL.c(this.xGw);
        AppMethodBeat.o(99379);
        return;
        paramBundle = com.tencent.mm.ui.statusbar.c.bj(this);
        localObject1 = new com.tencent.mm.ui.statusbar.c.a()
        {
          public final void sG(int paramAnonymousInt)
          {
            AppMethodBeat.i(179224);
            SnsTimeLineUI.t(SnsTimeLineUI.this).setPadding(0, paramAnonymousInt, 0, 0);
            AppMethodBeat.o(179224);
          }
        };
        this.qAM = ((com.tencent.mm.ui.statusbar.c.a)localObject1);
        paramBundle.a((com.tencent.mm.ui.statusbar.c.a)localObject1);
        getWindow().getDecorView().requestApplyInsets();
        com.tencent.mm.ui.statusbar.d.b(getWindow());
        break;
        paramBundle = null;
        break label1602;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMV = new com.tencent.mm.plugin.sns.m.c.a();
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMV.kGt = paramBundle.getStringExtra("sns_userName");
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMV.xGk = u.aqG();
        localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMV;
        com.tencent.mm.kernel.g.afC();
        ((com.tencent.mm.plugin.sns.m.c.a)localObject2).xGl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHT(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMV.kGt);
        localObject2 = u.aqG();
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMV.xng = ((String)localObject2).equals(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMV.kGt);
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMV.xGm = paramBundle.getIntExtra("sns_source", 0);
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMV.ixE = bt.by(paramBundle.getStringExtra("sns_nickName"), "");
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMV.bXk = bt.by(paramBundle.getStringExtra("sns_signature"), "");
        break label1620;
        label3562:
        paramBundle = paramBundle.xMV;
        break label1649;
        label3570:
        i = 0;
        break label1837;
        label3575:
        if (!this.xlh) {
          break label1922;
        }
        this.xlh = af.dtC().dAc();
        break label1922;
        if (!this.xlh) {
          break label2153;
        }
        this.xlh = af.dtC().dAc();
        break label2153;
        this.mUIAction.list.setAdapter(this.xFU);
        NB(0);
        this.xFU.tP();
        break label2434;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99383);
    this.xGf = true;
    Object localObject1 = this.xGr;
    ((az)localObject1).cvf();
    ((az)localObject1).xBW = null;
    ((az)localObject1).vZZ = az.a.xBY;
    com.tencent.mm.plugin.sns.ui.video.d.dDS().aE(this);
    localObject1 = com.tencent.mm.plugin.sns.ui.video.b.dDL();
    ad.i("MicroMsg.SightPlayViewManager", "onUIDestroy");
    Object localObject2 = ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).xVY.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((com.tencent.mm.plugin.sns.ui.video.a)((Iterator)localObject2).next()).stop();
    }
    ((com.tencent.mm.plugin.sns.ui.video.b)localObject1).xVY.clear();
    ad.i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
    com.tencent.mm.sdk.b.a.ESL.d(this.xGB);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGC);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGD);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGE);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGF);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGH);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGG);
    com.tencent.mm.sdk.b.a.ESL.d(this.wJd);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGI);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGJ);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGK);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGL);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGM);
    com.tencent.mm.sdk.b.a.ESL.d(this.xGw);
    com.tencent.mm.plugin.sns.ui.e.a.dDJ();
    int i;
    long l1;
    Object localObject3;
    Object localObject4;
    int j;
    label453:
    String str2;
    if ((this.xGa != null) && (this.xGa.xkY != null))
    {
      localObject1 = this.xGa.xkY.wIv;
      if (this.xGy)
      {
        i = 1;
        ((com.tencent.mm.plugin.sns.k.c)localObject1).wOY = i;
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.sns.k.f.wQY;
      if (((com.tencent.mm.plugin.sns.k.f)localObject2).fYF == 0) {
        break label781;
      }
      ad.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sns.k.f)localObject2).wQZ.size()), Integer.valueOf(((com.tencent.mm.plugin.sns.k.f)localObject2).wRa.size()) });
      l1 = ((com.tencent.mm.plugin.sns.k.f)localObject2).fjZ.getLong(2, 0L);
      if ((((com.tencent.mm.plugin.sns.k.f)localObject2).wQZ.isEmpty()) || ((((com.tencent.mm.plugin.sns.k.f)localObject2).wQZ.size() <= ((com.tencent.mm.plugin.sns.k.f)localObject2).wRe) && (bt.lZ(l1) <= ((com.tencent.mm.plugin.sns.k.f)localObject2).wRf))) {
        break label1777;
      }
      localObject3 = new StringBuffer();
      localObject4 = ((com.tencent.mm.plugin.sns.k.f)localObject2).wQZ.keySet().iterator();
      i = 0;
      j = 0;
      if (!((Iterator)localObject4).hasNext()) {
        break label607;
      }
      str2 = (String)((Iterator)localObject4).next();
      localObject1 = (String)((com.tencent.mm.plugin.sns.k.f)localObject2).wRa.get(str2);
      if (bt.isNullOrNil((String)localObject1)) {
        break label594;
      }
      j = 1;
      label500:
      if (!((com.tencent.mm.plugin.sns.k.f)localObject2).wRb.contains(str2)) {
        break label602;
      }
    }
    label594:
    label602:
    for (int k = 1;; k = 0)
    {
      ((StringBuffer)localObject3).append(str2 + "#" + ((com.tencent.mm.plugin.sns.k.f)localObject2).wQZ.get(str2) + "#" + (String)localObject1 + "#" + k + "|");
      i += 1;
      break label453;
      i = 0;
      break;
      localObject1 = "";
      break label500;
    }
    label607:
    ((StringBuffer)localObject3).append("," + l1 + "," + bt.aGK() + ",1," + j + "," + i + ",1");
    ad.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", new Object[] { Integer.valueOf(13226), localObject3 });
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(13226, ((StringBuffer)localObject3).toString());
    ((com.tencent.mm.plugin.sns.k.f)localObject2).fjZ.set(3, null);
    ((com.tencent.mm.plugin.sns.k.f)localObject2).fjZ.set(4, null);
    ((com.tencent.mm.plugin.sns.k.f)localObject2).fjZ.set(5, null);
    ((com.tencent.mm.plugin.sns.k.f)localObject2).wQZ.clear();
    ((com.tencent.mm.plugin.sns.k.f)localObject2).wRa.clear();
    ((com.tencent.mm.plugin.sns.k.f)localObject2).wRb.clear();
    ((com.tencent.mm.plugin.sns.k.f)localObject2).fjZ.setLong(2, bt.aGK());
    for (;;)
    {
      ((com.tencent.mm.plugin.sns.k.f)localObject2).duT();
      label781:
      com.tencent.mm.kernel.g.afC();
      localObject3 = (String)com.tencent.mm.kernel.g.afB().afk().get(68377, null);
      i = this.xFU.getCount();
      localObject1 = "";
      localObject2 = null;
      if (i > 0)
      {
        localObject2 = this.xFU.Ni(i - 1);
        localObject1 = com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject2);
      }
      label878:
      boolean bool;
      if ((this.xGa != null) && (this.xGa.xkY != null))
      {
        localObject4 = this.xGa.xkY.wIv;
        if (localObject2 == null)
        {
          i = -1;
          ad.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
          l1 = System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.k.c)localObject4).wQI;
          ((com.tencent.mm.plugin.sns.k.c)localObject4).wOM += l1;
          ad.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + l1 + " BrowseTime: " + ((com.tencent.mm.plugin.sns.k.c)localObject4).wOM + "BackgroundTime: " + ((com.tencent.mm.plugin.sns.k.c)localObject4).wPv);
          localObject2 = af.dth();
          if (localObject2 != null) {
            ((ExecutorService)localObject2).execute(new c.2((com.tencent.mm.plugin.sns.k.c)localObject4, i));
          }
          ((com.tencent.mm.plugin.sns.k.c)localObject4).wOK = false;
        }
      }
      else
      {
        localObject2 = com.tencent.mm.modelsns.d.oE(704);
        if (((com.tencent.mm.modelsns.d)localObject2).aBf())
        {
          ((com.tencent.mm.modelsns.d)localObject2).ew(this.xGy);
          if (bt.isNullOrNil((String)localObject3)) {
            break label1831;
          }
          bool = true;
          ((com.tencent.mm.modelsns.d)localObject2).ew(bool);
          ((com.tencent.mm.modelsns.d)localObject2).zi(this.xGg);
          ((com.tencent.mm.modelsns.d)localObject2).zi((String)localObject1);
          ((com.tencent.mm.modelsns.d)localObject2).zi((String)localObject1);
          ((com.tencent.mm.modelsns.d)localObject2).oH(this.mUIAction.xJq);
          ((com.tencent.mm.modelsns.d)localObject2).zi("");
          com.tencent.mm.modelsns.d.aBi();
          ((com.tencent.mm.modelsns.d)localObject2).aBj();
        }
        localObject1 = (AdListView)this.mUIAction.getSnsListView();
        this.xGj.wKx.clear();
        af.dtl().clean();
        localObject2 = af.dto();
        af.dth().execute(new k.5((com.tencent.mm.plugin.sns.a.b.k)localObject2));
        ((AdListView)localObject1).xjv.clear();
        ((AdListView)localObject1).xjv = null;
        ((AdListView)localObject1).xjw.dsJ();
        ((AdListView)localObject1).xjw = null;
        t.dsO();
        if (!af.dtd()) {
          this.xGT.removeCallbacks(this.xGu);
        }
        com.tencent.mm.kernel.g.afC();
        if (com.tencent.mm.kernel.g.afz().aeI())
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.b(213, this);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.b(682, this);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.b(218, this);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.b(211, this);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.b(683, this);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(327776, Integer.valueOf(this.xGe));
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(589825, Boolean.FALSE);
        }
        if (this.xGa != null)
        {
          localObject1 = this.xGa;
          ((i)localObject1).xlo.removeListener();
          if (((i)localObject1).xlc != null) {
            ((i)localObject1).xlc.dBh();
          }
          com.tencent.mm.sdk.b.a.ESL.d(((i)localObject1).xlq);
          com.tencent.mm.sdk.b.a.ESL.d(((i)localObject1).xlr);
        }
        af.czA().removeCallbacks(this.xGU);
        localObject1 = af.dtD();
        if (((ar)localObject1).wJT != null) {
          ((ar)localObject1).dul();
        }
        if (!((ar)localObject1).wJr) {}
      }
      try
      {
        ((ar)localObject1).wJN.wJR = ((ar)localObject1).wJR;
        localObject2 = ((ar)localObject1).wJN.toByteArray();
        com.tencent.mm.vfs.i.f(((ar)localObject1).wJq, (byte[])localObject2, localObject2.length);
        ((ar)localObject1).wJN.wOf.clear();
        ((ar)localObject1).wJO = null;
        ((ar)localObject1).wJP = 0L;
        ((ar)localObject1).wJI = 0L;
        ((ar)localObject1).wJC.clear();
        ((ar)localObject1).wJD = null;
        ((ar)localObject1).wJH = 0L;
        ((ar)localObject1).wJE = 0L;
        ((ar)localObject1).wJK = false;
        ((ar)localObject1).wJT = null;
        ((ar)localObject1).wJU = null;
        ((ar)localObject1).wJJ = as.wKj;
        ((ar)localObject1).wJV = 0;
        ((ar)localObject1).wJS = 0L;
        ((ar)localObject1).wJR = 0L;
        ((ar)localObject1).wJW = 0L;
        ((ar)localObject1).wJF.clear();
        localObject1 = ((ar)localObject1).wJX;
        ((com.tencent.mm.plugin.sns.model.aq)localObject1).wJn.clear();
        ((com.tencent.mm.plugin.sns.model.aq)localObject1).wJo = null;
        com.tencent.mm.kernel.g.afA().gcy.b(211, (com.tencent.mm.al.g)localObject1);
        if (this.xFU == null) {
          break label2298;
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
            label1777:
            ((com.tencent.mm.plugin.sns.k.f)localObject2).fjZ.set(3, ((com.tencent.mm.plugin.sns.k.f)localObject2).wQZ);
            ((com.tencent.mm.plugin.sns.k.f)localObject2).fjZ.set(4, ((com.tencent.mm.plugin.sns.k.f)localObject2).wRa);
            ((com.tencent.mm.plugin.sns.k.f)localObject2).fjZ.set(5, ((com.tencent.mm.plugin.sns.k.f)localObject2).wRb);
            break;
            i = ((com.tencent.mm.plugin.sns.storage.p)localObject2).field_createTime;
            break label878;
            label1831:
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
        if ((!af.dtd()) && (this.xFS.dtk() != null) && (this.xGZ == 0))
        {
          localObject1 = af.dtC();
          String str1 = this.xFU.xMy.dDf();
          localObject3 = this.xFU.xMy.dDh();
          l1 = this.xFS.dtk().wIQ;
          localObject4 = this.xFU.xMy.dDd();
          str2 = this.xFU.xMy.dDe();
          long l2 = this.xFS.dtk().wIR;
          String str3 = this.xFU.xMy.dDg();
          bool = this.mUIAction.xrF;
          ((am)localObject1).xrz = bt.GC();
          ((am)localObject1).pLA = str1;
          ((am)localObject1).xrA = ((String)localObject3);
          ((am)localObject1).wIQ = l1;
          ((am)localObject1).position = m;
          ((am)localObject1).xrE = (i - j);
          ((am)localObject1).xrD = str3;
          ((am)localObject1).xrB = ((String)localObject4);
          ((am)localObject1).xrC = str2;
          ((am)localObject1).wIR = l2;
          ((am)localObject1).xrF = bool;
          ad.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", new Object[] { Long.valueOf(((am)localObject1).xrz), str1, localObject3, Long.valueOf(l1), Integer.valueOf(m), Integer.valueOf(((am)localObject1).xrE), localObject4, str2, Long.valueOf(l2), str3, Boolean.valueOf(bool) });
        }
        ad.d("MicroMsg.SnsTimeLineUI", "top h %d", new Object[] { Integer.valueOf(i - j) });
        localObject1 = this.xFU.xMx;
        com.tencent.mm.sdk.b.a.ESL.d(((be)localObject1).jBI);
        if (!af.dtd()) {
          break label2545;
        }
      }
    }
    ad.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
    for (;;)
    {
      localObject1 = this.xFU.xMx;
      if (((be)localObject1).xwI != null) {
        ((be)localObject1).xwI.activity = null;
      }
      localObject1 = this.xFU.xMx;
      com.tencent.mm.sdk.b.a.ESL.d(((be)localObject1).jBI);
      this.xFU.xMx.dBZ();
      this.xFU.xMx.dBV();
      label2298:
      bg.clean();
      com.tencent.mm.sdk.b.a.ESL.d(this.xGv);
      com.tencent.mm.kernel.g.afC();
      if (com.tencent.mm.kernel.g.afz().aeI()) {
        af.dtr().wDQ.clear();
      }
      this.xFU.xMy.removeVendingDataChangedCallback(this.xGx);
      this.xGx = null;
      this.xFU = null;
      this.xGa = null;
      com.tencent.mm.plugin.sns.ui.a.c.dDb();
      com.tencent.mm.plugin.sns.abtest.c.drs();
      localObject1 = af.dtl();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(291, (com.tencent.mm.al.g)localObject1);
      com.tencent.mm.plugin.sns.abtest.a.clean();
      this.mUIAction.onDestroy();
      super.onDestroy();
      com.tencent.mm.kiss.widget.textview.c.ggt.agC();
      localObject1 = this.xFT;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).xMV = null;
      ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = false;
      com.tencent.mm.plugin.sns.a.b.l.wyR.wyQ.clear();
      ad.i("MicroMsg.SnsTimelineAdResourceMgr", "clean cache", new Object[] { bt.eGN() });
      localObject1 = af.dtp();
      if (!((com.tencent.mm.plugin.sns.model.b)localObject1).wDB.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.b)localObject1).wDB.clear();
      }
      localObject1 = af.dtp();
      if (!((com.tencent.mm.plugin.sns.model.b)localObject1).wDC.isEmpty()) {
        ((com.tencent.mm.plugin.sns.model.b)localObject1).wDC.clear();
      }
      af.dtD().wJL = false;
      localObject1 = com.tencent.mm.plugin.sns.k.f.wQY;
      ((com.tencent.mm.plugin.sns.k.f)localObject1).wRi.clear();
      ((com.tencent.mm.plugin.sns.k.f)localObject1).wRj.clear();
      AppMethodBeat.o(99383);
      return;
      label2545:
      af.dtr();
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
        AppMethodBeat.i(179270);
        SnsTimeLineUI.this.dzb();
        AppMethodBeat.o(179270);
      }
    });
    if (keyboardState() == 2)
    {
      if ((this.xGa != null) && (this.xGa.xlc != null) && (!this.xGa.xlc.dBc()))
      {
        ad.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
        AppMethodBeat.o(99389);
      }
    }
    else if ((keyboardState() == 1) && (this.xGa != null))
    {
      i locali = this.xGa;
      if (locali.xkZ)
      {
        locali.xkZ = false;
        locali.xld.dCY();
      }
    }
    AppMethodBeat.o(99389);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99387);
    try
    {
      bh.a(this, null);
      this.xtG = false;
      this.xFX.clearAnimation();
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, this.foV);
      this.foV = 0;
      t.b(this);
      af.dtr().wDS = null;
      if (this.xFU != null)
      {
        localObject = this.xFU.xMx;
        com.tencent.mm.sdk.b.a.ESL.d(((be)localObject).xxk);
        com.tencent.mm.sdk.b.a.ESL.d(((be)localObject).xxj);
        com.tencent.mm.sdk.b.a.ESL.d(((be)localObject).xxl);
      }
      if ((this.xGa != null) && (this.xGa.xkX != null)) {
        this.xGa.xkX.onPause();
      }
      if ((this.xGa != null) && (this.xGa.xkY != null)) {
        this.xGa.xkY.wIv.pK(false);
      }
      com.tencent.mm.modelstat.d.p("SnsTimeLineUI", this.tlW, bt.aGK());
      this.mUIAction.onPause();
      super.onPause();
      com.tencent.mm.plugin.sns.ui.video.d.dDS().onUIPause();
      Object localObject = com.tencent.mm.plugin.sns.ui.video.b.dDL();
      ad.i("MicroMsg.SightPlayViewManager", "onUIPause");
      localObject = ((com.tencent.mm.plugin.sns.ui.video.b)localObject).xVY.iterator();
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
      com.tencent.mm.sdk.b.a.ESL.d(this.xGA);
      com.tencent.mm.sdk.b.a.ESL.d(this.xGz);
      com.tencent.mm.sdk.b.a.ESL.d(this.xGN);
      if ((com.tencent.matrix.b.GE()) && (com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class) != null))
      {
        com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class)).cBu;
        if (localc != null) {
          this.fXQ = Math.max(0L, localc.cDj - this.fXQ);
        }
      }
      if (bt.aGK() <= this.hcE) {}
    }
    for (long l = bt.aGK() - this.hcE;; l = 1L)
    {
      this.hcE = l;
      WXHardCoderJNI.reportFPS(701, WXHardCoderJNI.hcSNSScrollAction, 1, this.fXQ, this.hcE);
      this.fXQ = 0L;
      this.hcE = 0L;
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
        dCg();
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131761885), getString(2131760598), getString(2131755691), false, new SnsTimeLineUI.68(this), new SnsTimeLineUI.69(this));
        }
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        dCf();
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        com.tencent.mm.ui.base.h.a(getContext(), getString(paramInt), getString(2131761885), getString(2131760598), getString(2131755691), false, new SnsTimeLineUI.70(this), new SnsTimeLineUI.71(this));
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        dCf();
        AppMethodBeat.o(99403);
        return;
      }
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131761869), getString(2131761885), getString(2131760598), getString(2131755691), false, new SnsTimeLineUI.72(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99384);
    af.dtD().wJJ = as.wKj;
    this.xGr.vZZ = az.dBC();
    this.hcE = bt.aGK();
    Object localObject1;
    if ((com.tencent.matrix.b.GE()) && (com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class) != null))
    {
      localObject1 = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class)).cBu;
      if (localObject1 != null) {
        this.fXQ = ((com.tencent.matrix.trace.f.c)localObject1).cDj;
      }
    }
    try
    {
      if (!this.xtG)
      {
        ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onResume callback");
        bh.a(this, this.xuu);
        this.xtG = true;
      }
      if ((com.tencent.mm.sdk.a.b.eEQ()) && (com.tencent.mm.sdk.a.b.eEO())) {
        sUILeaksRoutineEnsuranceRef.add(this);
      }
      this.mUIAction.onResume();
      super.onResume();
      dCd();
      if (this.autoPlay) {
        dCc();
      }
      this.tlW = bt.aGK();
      int i;
      if (this.xGY)
      {
        this.xGY = false;
        i = this.xFU.getCount();
        if (getIntent().getBooleanExtra("is_from_find_more", false))
        {
          localObject3 = com.tencent.mm.modelsns.d.c(getIntent(), "enter_log");
          if (localObject3 != null)
          {
            if (i <= 0) {
              break label735;
            }
            localp = this.xFU.Ni(0);
            if (localp != null) {
              break label701;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.d)localObject3).zi((String)localObject1);
            if (localp != null) {
              break label713;
            }
            localObject1 = "0";
            ((com.tencent.mm.modelsns.d)localObject3).zi((String)localObject1);
            ((com.tencent.mm.modelsns.d)localObject3).zi(String.valueOf(i));
            ((com.tencent.mm.modelsns.d)localObject3).aBj();
          }
        }
      }
      if (this.mScreenWidth == 0)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
        this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
        localObject1 = this.xGh;
        i = this.mScreenWidth;
        int j = this.mScreenHeight;
        ((com.tencent.mm.plugin.sns.k.a)localObject1).mScreenWidth = i;
        ((com.tencent.mm.plugin.sns.k.a)localObject1).mScreenHeight = j;
      }
      if (af.dtd()) {
        finish();
      }
      af.dtr().wDS = this.xFU.xMx;
      agy().bf(c.b.class);
      t.a(this);
      if (this.xFZ)
      {
        this.xFX.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179256);
            ad.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.M(SnsTimeLineUI.this));
            if (SnsTimeLineUI.M(SnsTimeLineUI.this))
            {
              SnsTimeLineUI.m(SnsTimeLineUI.this);
              SnsTimeLineUI.l(SnsTimeLineUI.this).dCu();
            }
            AppMethodBeat.o(179256);
          }
        });
        if ((this.xGa != null) && (this.xGa.xkX != null)) {
          this.xGa.xkX.onResume();
        }
        if (this.xFU != null)
        {
          localObject1 = this.xFU.xMx;
          com.tencent.mm.sdk.b.a.ESL.c(((be)localObject1).xxk);
          com.tencent.mm.sdk.b.a.ESL.c(((be)localObject1).xxj);
          com.tencent.mm.sdk.b.a.ESL.c(((be)localObject1).xxl);
        }
        if ((this.xGa != null) && (this.xGa.xkY != null))
        {
          this.xGa.xkY.wIv.pK(true);
          this.xGa.xkY.wIv.pL(false);
          this.xGa.xkY.wIv.pM(false);
          this.xGa.xkY.wIv.pN(false);
          this.xGa.xkY.wIv.pX(false);
          localObject1 = this.xGa.xkY.wIv;
          ((com.tencent.mm.plugin.sns.k.c)localObject1).pV(false);
          ((com.tencent.mm.plugin.sns.k.c)localObject1).pW(false);
          ((com.tencent.mm.plugin.sns.k.c)localObject1).pP(false);
          ((com.tencent.mm.plugin.sns.k.c)localObject1).pU(false);
          ((com.tencent.mm.plugin.sns.k.c)localObject1).pS(false);
          ((com.tencent.mm.plugin.sns.k.c)localObject1).pU(false);
          ((com.tencent.mm.plugin.sns.k.c)localObject1).pY(false);
          ((com.tencent.mm.plugin.sns.k.c)localObject1).pT(false);
          ((com.tencent.mm.plugin.sns.k.c)localObject1).pU(false);
          ((com.tencent.mm.plugin.sns.k.c)localObject1).pQ(false);
          ((com.tencent.mm.plugin.sns.k.c)localObject1).pR(false);
        }
        localObject1 = af.dtr();
        ((com.tencent.mm.plugin.sns.model.f)localObject1).wDT = 0L;
        ((com.tencent.mm.plugin.sns.model.f)localObject1).wDU = 0L;
        com.tencent.mm.sdk.b.a.ESL.c(this.xGA);
        com.tencent.mm.sdk.b.a.ESL.c(this.xGz);
        com.tencent.mm.sdk.b.a.ESL.c(this.xGN);
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
        Object localObject2 = com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId);
        continue;
        label713:
        localObject2 = localp.field_createTime;
        continue;
        label735:
        ((com.tencent.mm.modelsns.d)localObject3).zi("");
        ((com.tencent.mm.modelsns.d)localObject3).zi("");
        ((com.tencent.mm.modelsns.d)localObject3).zi("0");
        continue;
        localObject2 = this.xGc;
        if (((a)localObject2).xHe.xFX.getVisibility() == 0)
        {
          ((a)localObject2).init();
          localObject3 = (AbsoluteLayout.LayoutParams)((a)localObject2).xHe.xFX.getLayoutParams();
          ((AbsoluteLayout.LayoutParams)localObject3).y = ((int)((a)localObject2).xHz);
          ((a)localObject2).xHe.xFX.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((a)localObject2).xHe.xFX.invalidate();
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
      if (((paramString.type == 1) || (paramString.type == 6) || (paramString.type == 4)) && (this.xGa.xlp != null)) {
        this.xGa.xlp.dismiss();
      }
      if (paramString.type == 11)
      {
        if (this.mUIAction.tipDialog != null) {
          this.mUIAction.tipDialog.dismiss();
        }
        if (this.xHb != null) {
          this.xHb.setImageResource(2131690526);
        }
      }
    }
    if (this.xFU != null) {
      this.xFU.xMy.notifyVendingDataChange();
    }
    if (paramn.getType() == 211)
    {
      paramString = (x)paramn;
      if (!paramString.wES) {
        break label272;
      }
      paramn = com.tencent.mm.modelsns.d.oE(727);
      paramn.oH(this.xFU.getCount()).oH(paramString.ahd);
      paramn.aBj();
    }
    for (;;)
    {
      if (this.xGc != null)
      {
        this.xFZ = false;
        this.xGc.dCv();
      }
      AppMethodBeat.o(99398);
      return;
      label272:
      paramn = com.tencent.mm.modelsns.d.oE(728);
      paramn.oH(this.xFU.getCount()).oH(paramString.ahd).oH(0);
      paramn.aBj();
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
    AppMethodBeat.i(187726);
    super.onWindowFocusChanged(paramBoolean);
    ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      bh.a(this, null);
      this.xtG = false;
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(187726);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      ad.e("MicroMsg.SnsTimeLineUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(187726);
    }
    if (!this.xtG)
    {
      ad.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onWindowFocusChanged callback");
      bh.a(this, this.xuu);
      this.xtG = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(187726);
    return;
  }
  
  public final void qs(boolean paramBoolean)
  {
    AppMethodBeat.i(99405);
    if (this.xFU != null)
    {
      ad.i("MicroMsg.SnsTimeLineUI", "set play animation %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.mm.plugin.sns.ui.a.c localc = this.xFU;
      localc.xMz = paramBoolean;
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
    if ((Build.VERSION.SDK_INT >= 21) && (this.uAo != null))
    {
      this.uAo.setBackgroundColor(getWindow().getStatusBarColor());
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
    private float xHA = 50.0F;
    private float xHB = 10.0F;
    float xHC = 0.0F;
    private float xHD = 0.0F;
    private float xHE;
    private float xHF;
    boolean xHG;
    int xHH;
    boolean xHI = false;
    int xHJ = 0;
    float xHK = 0.0F;
    float xHL = 0.0F;
    float xHM = 0.0F;
    float xHN = 0.0F;
    private float xHw;
    private float xHx;
    float xHy = -1.0F;
    float xHz;
    
    public a(ListView paramListView)
    {
      this.list = paramListView;
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(99366);
      if (SnsTimeLineUI.xGO.booleanValue()) {
        ad.d("MicroMsg.RefreshAnim", "animtest applyTransformation vis %s interpolatedTime %s isJustUp %s", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(paramFloat), Boolean.valueOf(this.xHG) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99366);
        return;
      }
      float f1 = (paramFloat - this.xHE) * (float)getDuration();
      if (f1 < 2.0F)
      {
        if (SnsTimeLineUI.xGO.booleanValue()) {
          ad.d("MicroMsg.RefreshAnim", "applyTransformation wawawa %s", new Object[] { Float.valueOf(f1) });
        }
        AppMethodBeat.o(99366);
        return;
      }
      this.xHE = paramFloat;
      SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(2131690250);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.HBs);
      if (((float)getDuration() * paramFloat >= (float)(getDuration() - this.DELAY_TIME)) || (this.xHG))
      {
        paramTransformation = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        if (paramTransformation.y <= this.xHD)
        {
          AppMethodBeat.o(99366);
          return;
        }
        if (this.xHM == 0.0F)
        {
          this.xHM = (-this.xHD + paramTransformation.y);
          this.xHN = paramTransformation.y;
          this.xHF = paramFloat;
        }
        paramFloat = (paramFloat - this.xHF) / (1.0F - this.xHF);
        f1 = this.xHM * paramFloat;
        float f2 = this.xHN - f1;
        if (SnsTimeLineUI.xGO.booleanValue()) {
          ad.i("MicroMsg.RefreshAnim", "animcheck interpolatedTime y %s duration %s factor %s residualTime %s pass %s ", new Object[] { Float.valueOf(f2), Long.valueOf(getDuration()), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.xHF * (float)getDuration()) });
        }
        if (paramTransformation.y > f2) {
          paramTransformation.y = ((int)f2);
        }
        this.xHC = paramTransformation.y;
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(paramTransformation);
      }
      for (;;)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99366);
        return;
        if (SnsTimeLineUI.xGO.booleanValue()) {
          ad.d("MicroMsg.RefreshAnim", "animcheck delt Rotate " + f1 / 2.5F);
        }
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(f1 / 2.5F, this.xHw, this.xHx);
      }
    }
    
    public final void bw(float paramFloat)
    {
      AppMethodBeat.i(99360);
      if (this.list != null)
      {
        if (this.list.getFirstVisiblePosition() != 0) {
          break label122;
        }
        if (SnsTimeLineUI.d(SnsTimeLineUI.this).wOn.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).xHH) {
          SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
        }
      }
      for (;;)
      {
        if (SnsTimeLineUI.xGO.booleanValue()) {
          ad.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.xHz), Float.valueOf(this.xHy) });
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
      if (paramFloat <= -this.xHA) {
        f1 = -this.xHA;
      }
      float f2 = f1;
      if (f1 >= this.xHA) {
        f2 = this.xHA;
      }
      if (f2 < 0.0F)
      {
        this.xHC -= f2 * 2.0F;
        f1 = this.xHC;
        paramFloat = f1;
        if (f1 < this.xHz)
        {
          paramFloat = this.xHz;
          this.xHC = this.xHz;
        }
        f1 = paramFloat;
        if (paramFloat > this.xHy)
        {
          f1 = this.xHy;
          this.xHC = this.xHy;
        }
        if (SnsTimeLineUI.xGO.booleanValue()) {
          ad.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s sumY %s translateY %s distanceY %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.xHz), Float.valueOf(this.xHy), Float.valueOf(this.xHC), Float.valueOf(f1), Float.valueOf(this.xHA) });
        }
        if (f1 != this.xHy) {
          break label455;
        }
      }
      label455:
      for (paramFloat = f2 * 2.0F;; paramFloat = 5.0F * f2)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.HBs);
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(paramFloat, this.xHw, this.xHx);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(2131690250);
        AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        localLayoutParams.y = ((int)f1);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99360);
        return;
        this.xHC -= f2 / 2.0F;
        break;
      }
    }
    
    public final void dCu()
    {
      AppMethodBeat.i(99361);
      if (SnsTimeLineUI.xGO.booleanValue()) {
        ad.d("MicroMsg.RefreshAnim", "animtest playLoading");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99361);
        return;
      }
      init();
      this.xHC = (this.xHy + 20.0F);
      AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
      localLayoutParams.y = ((int)this.xHy);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
      dCw();
      AppMethodBeat.o(99361);
    }
    
    public final void dCv()
    {
      AppMethodBeat.i(99362);
      if (SnsTimeLineUI.xGO.booleanValue()) {
        ad.i("MicroMsg.RefreshAnim", "play end vis: %d, sumY %f MAX_Y %f", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(this.xHC), Float.valueOf(this.xHy) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99362);
        return;
      }
      init();
      if (this.xHC < this.xHy - this.xHB)
      {
        AppMethodBeat.o(99362);
        return;
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      tp(this.DELAY_TIME + 100);
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      this.xHG = false;
      AppMethodBeat.o(99362);
    }
    
    public final void dCw()
    {
      AppMethodBeat.i(99364);
      if (SnsTimeLineUI.xGO.booleanValue()) {
        ad.d("MicroMsg.RefreshAnim", "animtest setAcitonUp");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99364);
        return;
      }
      init();
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      if (SnsTimeLineUI.xGO.booleanValue()) {
        ad.v("MicroMsg.RefreshAnim", "setAcitonUp1 sumY  %s MAX_Y %s %s", new Object[] { Float.valueOf(this.xHC), Float.valueOf(this.xHy), bt.eGN().toString() });
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      if (this.xHC >= this.xHy - this.xHB)
      {
        tp(20000L);
        this.xHG = false;
        AppMethodBeat.o(99364);
        return;
      }
      tp(this.DELAY_TIME + 100);
      this.xHG = true;
      AppMethodBeat.o(99364);
    }
    
    final void init()
    {
      AppMethodBeat.i(99365);
      if ((this.xHy == -1.0F) || (this.xHx < 0.1D))
      {
        this.xHy = BackwardSupportUtil.b.g(SnsTimeLineUI.this, 70.0F);
        this.xHA = BackwardSupportUtil.b.g(SnsTimeLineUI.this, 16.0F);
        this.xHw = (SnsTimeLineUI.u(SnsTimeLineUI.this).getWidth() / 2);
        this.xHx = (SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() / 2);
        this.xHD = (-SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() * 2);
        if (this.xHD == 0.0F) {
          this.xHD = (-BackwardSupportUtil.b.g(SnsTimeLineUI.this, 40.0F));
        }
        this.xHz = this.xHD;
        if (SnsTimeLineUI.xGO.booleanValue()) {
          ad.d("MicroMsg.RefreshAnim", "init MIN_Y %s MAX_Y %s targetInitY %s distanceY %s", new Object[] { Float.valueOf(this.xHz), Float.valueOf(this.xHy), Float.valueOf(this.xHD), Float.valueOf(this.xHA) });
        }
        this.xHC = this.xHz;
        if (!this.xHI)
        {
          if (SnsTimeLineUI.xGO.booleanValue()) {
            ad.i("MicroMsg.RefreshAnim", "initState");
          }
          this.xHJ = ((AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams()).y;
          this.xHK = this.xHy;
          this.xHL = this.xHC;
        }
        this.xHI = true;
      }
      AppMethodBeat.o(99365);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(99367);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      if (SnsTimeLineUI.xGO.booleanValue()) {
        ad.i("MicroMsg.RefreshAnim", "anim initialize %s", new Object[] { bt.eGN().toString() });
      }
      this.xHE = 0.0F;
      this.xHF = 0.0F;
      this.xHM = 0.0F;
      this.xHN = 0.0F;
      AppMethodBeat.o(99367);
    }
    
    final void tp(long paramLong)
    {
      AppMethodBeat.i(99363);
      if (SnsTimeLineUI.xGO.booleanValue()) {
        ad.d("MicroMsg.RefreshAnim", "setDurationTime durationMillis %s %s", new Object[] { Long.valueOf(paramLong), bt.eGN().toString() });
      }
      setDuration(paramLong);
      AppMethodBeat.o(99363);
    }
  }
  
  final class b
  {
    public int type = 0;
    public int xHO;
    
    private b() {}
  }
  
  final class c
  {
    public boolean active = true;
    public long kCZ;
    public int scene;
    public String xHP = "";
    public long xHQ;
    public int xHR;
    public int xHS;
    public long xHT;
    public int xHU;
    public long xHV;
    public int xHW;
    public long xHX;
    
    private c() {}
    
    public final void ND(int paramInt)
    {
      AppMethodBeat.i(99368);
      if (!this.active)
      {
        AppMethodBeat.o(99368);
        return;
      }
      this.xHS = paramInt;
      this.kCZ = bt.eGO();
      AppMethodBeat.o(99368);
    }
    
    public final void NE(int paramInt)
    {
      AppMethodBeat.i(99369);
      if (!this.active)
      {
        AppMethodBeat.o(99369);
        return;
      }
      reset();
      this.scene = 2;
      this.xHT = bt.eGO();
      this.xHU = paramInt;
      AppMethodBeat.o(99369);
    }
    
    public final void NF(int paramInt)
    {
      AppMethodBeat.i(99370);
      if (!this.active)
      {
        AppMethodBeat.o(99370);
        return;
      }
      reset();
      this.scene = 3;
      this.xHV = bt.eGO();
      this.xHX = 0L;
      this.xHW = paramInt;
      AppMethodBeat.o(99370);
    }
    
    final void reset()
    {
      this.scene = 0;
      this.xHQ = 0L;
      this.xHR = -1;
      this.xHS = 0;
      this.kCZ = 0L;
      this.xHT = 0L;
      this.xHU = 0;
      this.xHV = 0L;
      this.xHW = 0;
      this.xHX = 0L;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(99371);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.xHP).append(",").append(this.scene).append(",").append(this.xHQ).append(",").append(this.xHR).append(",").append(this.xHS).append(",").append(this.kCZ).append(",").append(this.xHT).append(",").append(this.xHU).append(",").append(this.xHV).append(",").append(this.xHW).append(",").append(this.xHX);
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