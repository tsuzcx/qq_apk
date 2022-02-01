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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abw;
import com.tencent.mm.autogen.a.cy;
import com.tencent.mm.autogen.a.ki;
import com.tencent.mm.autogen.a.px;
import com.tencent.mm.autogen.a.qj;
import com.tencent.mm.autogen.a.qk;
import com.tencent.mm.autogen.a.xy;
import com.tencent.mm.autogen.a.yg;
import com.tencent.mm.autogen.a.yh;
import com.tencent.mm.autogen.a.yl;
import com.tencent.mm.autogen.a.ym;
import com.tencent.mm.autogen.a.yn;
import com.tencent.mm.autogen.a.ys;
import com.tencent.mm.autogen.a.yv;
import com.tencent.mm.autogen.a.zb;
import com.tencent.mm.autogen.a.zc;
import com.tencent.mm.autogen.a.zg;
import com.tencent.mm.autogen.a.zl;
import com.tencent.mm.autogen.mmdata.rpt.mp;
import com.tencent.mm.autogen.mmdata.rpt.nr;
import com.tencent.mm.autogen.mmdata.rpt.py;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.findersdk.a.ad;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.secdata.ui.WxPresenterSecDataActivity;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.c.k.a;
import com.tencent.mm.plugin.sns.data.o;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ax.5;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.o.c.b;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.af;
import com.tencent.mm.plugin.sns.storage.ag;
import com.tencent.mm.plugin.sns.storage.ah;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.plugin.sns.ui.widget.h.c;
import com.tencent.mm.plugin.sns.ui.widget.h.d;
import com.tencent.mm.pluginsdk.ui.span.o.a;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.fdp;
import com.tencent.mm.protocal.protobuf.fdq;
import com.tencent.mm.protocal.protobuf.fdv;
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
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMOverScrollView;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.vending.app.a.b;
import com.tencent.mm.vending.base.Vending.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.widget.pulldown.c(0)
public class SnsTimeLineUI
  extends WxPresenterSecDataActivity
  implements com.tencent.mm.am.h, com.tencent.mm.model.bc, k.a, aa
{
  private static int RzA;
  public static final Boolean RzY;
  private static Boolean Rzo;
  private static int Rzu;
  private static int Rzz;
  private MenuItem.OnMenuItemClickListener Bpg;
  private long Bti;
  private int BuD;
  private View Inv;
  private com.tencent.mm.ui.statusbar.c.a Inw;
  private boolean QCZ;
  private IListener QyL;
  boolean RAa;
  Runnable RAb;
  Runnable RAc;
  private Handler RAd;
  private Runnable RAe;
  private SnsUIAction.a RAf;
  private long RAg;
  private a.b RAh;
  boolean RAi;
  int RAj;
  private ImageView RAk;
  private View RAl;
  private long RAm;
  private boolean RAn;
  private boolean RbF;
  private boolean RdS;
  private volatile boolean Rlo;
  private ScreenShotUtil.ScreenShotCallback Rmk;
  protected com.tencent.mm.plugin.sns.ad.g.l RoZ;
  private com.tencent.mm.plugin.sns.o.b RyR;
  private com.tencent.mm.plugin.sns.o.a RyS;
  private com.tencent.mm.plugin.sns.ui.a.a.c RyT;
  com.tencent.mm.plugin.sns.ui.a.c RyU;
  private LinearLayout RyV;
  private LinearLayout RyW;
  private QFadeImageView RyX;
  private boolean RyY;
  private boolean RyZ;
  private com.tencent.mm.ui.widget.a.f RzB;
  private boolean RzC;
  private Runnable RzD;
  private IListener RzE;
  private IListener RzF;
  private Vending.d RzG;
  private boolean RzH;
  private IListener RzI;
  private IListener RzJ;
  private IListener RzK;
  private IListener RzL;
  private IListener RzM;
  private IListener RzN;
  private IListener RzO;
  private IListener RzP;
  private IListener RzQ;
  private IListener RzR;
  private IListener RzS;
  private IListener RzT;
  private IListener RzU;
  private IListener RzV;
  private IListener RzW;
  private IListener RzX;
  private long RzZ;
  private i Rza;
  private int Rzb;
  private a Rzc;
  private TestTimeForSns Rzd;
  private int Rze;
  private boolean Rzf;
  private String Rzg;
  private com.tencent.mm.plugin.sns.statistics.a Rzh;
  private com.tencent.mm.plugin.sns.model.be Rzi;
  private com.tencent.mm.plugin.sns.model.bc Rzj;
  private String Rzk;
  private boolean Rzl;
  private int Rzm;
  private String Rzn;
  private String Rzp;
  private c Rzq;
  private bi Rzr;
  private ViewGroup Rzs;
  private long Rzt;
  private int Rzv;
  private int Rzw;
  private int Rzx;
  private int Rzy;
  private boolean autoPlay;
  private int lyw;
  private ActionBar mActionBar;
  private int mScreenHeight;
  private int mScreenWidth;
  private String mSessionId;
  private SnsUIAction mUIAction;
  private long mxe;
  private long oCx;
  private String sWX;
  
  static
  {
    AppMethodBeat.i(99430);
    Rzo = null;
    Rzu = 0;
    Rzz = 2;
    RzA = 2;
    RzY = Boolean.FALSE;
    AppMethodBeat.o(99430);
  }
  
  public SnsTimeLineUI()
  {
    AppMethodBeat.i(99372);
    this.RyR = ((com.tencent.mm.plugin.sns.o.b)aI(com.tencent.mm.plugin.sns.o.b.class));
    if (this.RyR != null) {}
    for (com.tencent.mm.plugin.sns.o.a locala = this.RyR.htb();; locala = null)
    {
      this.RyS = locala;
      this.RyT = new com.tencent.mm.plugin.sns.ui.a.a.c();
      this.RyY = false;
      this.RyZ = false;
      this.RbF = false;
      this.Rzb = 800;
      this.Rze = 0;
      this.Rzf = false;
      this.Rzg = "";
      this.Rzh = new com.tencent.mm.plugin.sns.statistics.a();
      this.RoZ = new com.tencent.mm.plugin.sns.ad.g.l(0);
      this.Rzi = new com.tencent.mm.plugin.sns.model.be();
      this.Rzj = new com.tencent.mm.plugin.sns.model.bc();
      this.autoPlay = false;
      this.Rzp = "";
      this.Rzq = new c((byte)0);
      this.Rzr = new bi();
      this.Rzs = null;
      this.Rzt = 0L;
      this.Rlo = false;
      this.Rzv = 0;
      this.Rzw = 0;
      this.Rzx = 0;
      this.Rzy = 2;
      this.RzC = false;
      this.RzD = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99267);
          com.tencent.mm.plugin.sns.ui.a.c localc = SnsTimeLineUI.a(SnsTimeLineUI.this);
          if (localc != null)
          {
            if (al.hgN().QxQ == com.tencent.mm.plugin.sns.model.ay.QyA) {
              SnsTimeLineUI.a(SnsTimeLineUI.this, localc.Et(true));
            }
            localc.RGD.hpl();
            localc.RGD.notifyVendingDataChange();
          }
          AppMethodBeat.o(99267);
        }
      };
      this.RzE = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzF = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzG = new Vending.d()
      {
        public final void hpU()
        {
          AppMethodBeat.i(179249);
          final int i;
          long l;
          if ((SnsTimeLineUI.a(SnsTimeLineUI.this) != null) && (!SnsTimeLineUI.a(SnsTimeLineUI.this).RGE))
          {
            SnsTimeLineUI.a(SnsTimeLineUI.this).notifyDataSetChanged();
            if (SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView() != null)
            {
              i = bf.fs(SnsTimeLineUI.this.getContext());
              int j = bf.getStatusBarHeight(SnsTimeLineUI.this.getContext());
              Log.d("MicroMsg.SnsTimeLineUI", "topOffset:%s curFetchMode:%s, mUIAction.header.getLoadingGroupHeight():%s, actionBar:%s, statusBar:%s", new Object[] { Integer.valueOf(-(SnsTimeLineUI.d(SnsTimeLineUI.this).QCY.getLoadingGroupHeight() - com.tencent.mm.ui.bd.fromDPToPix(SnsTimeLineUI.this.getContext(), 44) - i - j)), Integer.valueOf(al.hgN().QxQ), Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).QCY.getLoadingGroupHeight()), Integer.valueOf(i), Integer.valueOf(j) });
              if (al.hgN().QxQ == com.tencent.mm.plugin.sns.model.ay.Qyz)
              {
                Log.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_SPECIFIC");
                l = SnsTimeLineUI.a(SnsTimeLineUI.this).hqJ();
                al.hgr().ax(l, -1);
                SnsTimeLineUI.a(SnsTimeLineUI.this).RGD.baQ(com.tencent.mm.plugin.sns.data.t.uB(l));
                SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.a(SnsTimeLineUI.this).Et(true));
                SnsTimeLineUI.d(SnsTimeLineUI.this).Eq(true);
                al.hgy().start();
                SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(307625);
                    SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().setSelectionFromTop(SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), i + com.tencent.mm.ui.bd.fromDPToPix(SnsTimeLineUI.this.getContext(), 44));
                    al.hgN().QxS = false;
                    AppMethodBeat.o(307625);
                  }
                });
                AppMethodBeat.o(179249);
                return;
              }
              if (al.hgN().QxQ == com.tencent.mm.plugin.sns.model.ay.QyA)
              {
                i = 0;
                if (i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) {
                  break label469;
                }
                if (SnsTimeLineUI.a(SnsTimeLineUI.this).alF(i).field_snsId != SnsTimeLineUI.e(SnsTimeLineUI.this)) {}
              }
            }
          }
          for (;;)
          {
            Log.i("MicroMsg.SnsTimeLineUI", "curFetchMode == FETCH_MODE_UP upFetchRightId:%s, rightIndex:%s", new Object[] { Long.valueOf(SnsTimeLineUI.e(SnsTimeLineUI.this)), Integer.valueOf(i) });
            SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().setSelectionFromTop(i + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), SnsTimeLineUI.d(SnsTimeLineUI.this).getHeaderHeight());
            AppMethodBeat.o(179249);
            return;
            i += 1;
            break;
            if ((al.hgN().QxQ == com.tencent.mm.plugin.sns.model.ay.QyB) && (al.hgr().QwG == 0L))
            {
              l = SnsTimeLineUI.a(SnsTimeLineUI.this).hqJ();
              al.hgr().ax(l, -1);
            }
            AppMethodBeat.o(179249);
            return;
            label469:
            i = 0;
          }
        }
      };
      this.RzH = false;
      this.QCZ = false;
      this.RzI = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzJ = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzK = new SnsTimeLineUI.7(this, com.tencent.mm.app.f.hfK);
      this.RzL = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzM = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzN = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzO = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzP = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzQ = new IListener(com.tencent.mm.app.f.hfK) {};
      this.QyL = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzR = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzS = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzT = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzU = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzV = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzW = new SnsTimeLineUI.20(this, com.tencent.mm.app.f.hfK);
      this.RzX = new IListener(com.tencent.mm.app.f.hfK) {};
      this.RzZ = 0L;
      this.RAa = false;
      this.BuD = 0;
      this.RAb = new Runnable()
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
            al.hgy().pause();
          }
          AppMethodBeat.o(176303);
        }
      };
      this.RAc = new Runnable()
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
            al.hgy().start();
            SnsTimeLineUI.a(SnsTimeLineUI.this).RGC.hpy();
          }
          AppMethodBeat.o(179225);
        }
      };
      this.RAd = ((com.tencent.mm.vending.h.b)com.tencent.mm.vending.h.d.LOGIC.agvz).mHandler;
      this.RAe = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179226);
          SnsTimeLineUI.this.setMMNormalView();
          SnsTimeLineUI.w(SnsTimeLineUI.this);
          SnsTimeLineUI.x(SnsTimeLineUI.this);
          SnsTimeLineUI.this.setMMTitle(SnsTimeLineUI.this.getString(b.j.sns_timeline_ui_title));
          SnsTimeLineUI.y(SnsTimeLineUI.this);
          SnsTimeLineUI.c(SnsTimeLineUI.this, SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition());
          AppMethodBeat.o(179226);
        }
      };
      this.RAf = new SnsUIAction.a()
      {
        private int RAw = 0;
        private int RAx = 0;
        
        public final void Eo(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(308213);
          SnsTimeLineUI localSnsTimeLineUI = SnsTimeLineUI.this;
          localSnsTimeLineUI.RAa = paramAnonymousBoolean;
          MMHandler localMMHandler = al.fAG();
          com.tencent.mm.plugin.sns.model.g localg = al.hgy();
          com.tencent.mm.plugin.sns.model.c localc = al.hgw();
          if (paramAnonymousBoolean)
          {
            if ((localg.QqK) || (localc.QqK))
            {
              localMMHandler.removeCallbacks(localSnsTimeLineUI.RAb);
              localMMHandler.removeCallbacks(localSnsTimeLineUI.RAc);
              localMMHandler.postDelayed(localSnsTimeLineUI.RAb, 0L);
              AppMethodBeat.o(308213);
            }
          }
          else if ((!localg.QqK) || (!localc.QqK))
          {
            localMMHandler.removeCallbacks(localSnsTimeLineUI.RAb);
            localMMHandler.removeCallbacks(localSnsTimeLineUI.RAc);
            localMMHandler.postDelayed(localSnsTimeLineUI.RAc, 0L);
          }
          AppMethodBeat.o(308213);
        }
        
        public final void a(o paramAnonymouso) {}
        
        public final void amk(int paramAnonymousInt)
        {
          AppMethodBeat.i(308205);
          int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          int k = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
          if ((paramAnonymousInt == 0) && (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)) {
            SnsTimeLineUI.a(SnsTimeLineUI.this, j, k);
          }
          if ((j == this.RAw) && (k == this.RAx))
          {
            AppMethodBeat.o(308205);
            return;
          }
          this.RAw = j;
          this.RAx = k;
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
              break label522;
            }
          }
          LinkedList localLinkedList;
          label522:
          for (int i = Process.myTid();; i = 0)
          {
            SnsTimeLineUI.d((SnsTimeLineUI)localObject1, WXHardCoderJNI.startPerformance(bool, m, n, i1, i, WXHardCoderJNI.hcSNSScrollTimeout, 701, WXHardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI"));
            Log.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsTimeLineUI.F(SnsTimeLineUI.this)) });
            if ((paramAnonymousInt != 0) || (SnsTimeLineUI.a(SnsTimeLineUI.this) == null)) {
              break label557;
            }
            localObject1 = SnsTimeLineUI.a(SnsTimeLineUI.this);
            if (k < j) {
              break label544;
            }
            localLinkedList = new LinkedList();
            paramAnonymousInt = j;
            while (paramAnonymousInt <= k)
            {
              Object localObject2 = ((com.tencent.mm.plugin.sns.ui.a.c)localObject1).alF(paramAnonymousInt - 1);
              if (localObject2 != null)
              {
                localObject2 = ((SnsInfo)localObject2).getTimeLine();
                if ((localObject2 != null) && (!TextUtils.isEmpty(((TimeLineObject)localObject2).ContentObj.Url)) && (((TimeLineObject)localObject2).ContentObj.Url.contains(WeChatHosts.domainString(b.j.host_mp_weixin_qq_com))) && (((TimeLineObject)localObject2).ContentObj.Zpq == 3))
                {
                  i = -1;
                  if (((TimeLineObject)localObject2).ContentObj.Zpu != null) {
                    i = ((TimeLineObject)localObject2).ContentObj.Zpu.nUA;
                  }
                  ArrayList localArrayList = new ArrayList();
                  localArrayList.add(((TimeLineObject)localObject2).ContentObj.Url);
                  localArrayList.add(String.valueOf(i));
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).Id));
                  localArrayList.add("");
                  localArrayList.add("");
                  localArrayList.add(((TimeLineObject)localObject2).UserName);
                  localArrayList.add(String.valueOf(((TimeLineObject)localObject2).CreateTime));
                  localArrayList.add(String.valueOf(((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiB("__sns_timeline__")));
                  localLinkedList.add(localArrayList);
                }
              }
              paramAnonymousInt += 1;
            }
          }
          ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).s(localLinkedList, 2);
          label544:
          SnsTimeLineUI.a(SnsTimeLineUI.this).lO(j, k);
          label557:
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null)
          {
            localObject1 = SnsTimeLineUI.j(SnsTimeLineUI.this).b(SnsTimeLineUI.a(SnsTimeLineUI.this).RGC);
            com.tencent.mm.vending.g.g.jJU().d(new com.tencent.mm.vending.c.a() {});
          }
          j.QFS.ls(j, k);
          j.QFS.lt(j, k);
          AppMethodBeat.o(308205);
        }
        
        public final void bF(int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(308210);
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).RGD.notifyVendingDataChange();
          }
          if (!paramAnonymousBoolean) {
            SnsTimeLineUI.this.bbE().ct(c.b.class);
          }
          AppMethodBeat.o(308210);
        }
        
        public final void d(int paramAnonymousInt, List<Integer> paramAnonymousList1, List<Integer> paramAnonymousList2)
        {
          int j = 1;
          AppMethodBeat.i(308186);
          int i = j;
          if (paramAnonymousInt > 0)
          {
            paramAnonymousList1 = al.hgB().alB(paramAnonymousInt);
            i = j;
            if (paramAnonymousList1 != null)
            {
              if (paramAnonymousList1.getPravited() > 0) {
                Toast.makeText(SnsTimeLineUI.this, b.j.sns_has_save, 1).show();
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
            paramAnonymousList1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousList1);
            paramAnonymousList2 = new Object();
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousList2, paramAnonymousList1.aYi(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
            BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousList1.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousList2, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$34", "notifyList", "(ZILjava/util/List;Ljava/util/List;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
          }
          if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
            SnsTimeLineUI.a(SnsTimeLineUI.this).RGD.notifyVendingDataChange();
          }
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.b(SnsTimeLineUI.this);
          }
          AppMethodBeat.o(308186);
        }
        
        public final View getActionBar()
        {
          AppMethodBeat.i(308182);
          View localView = SnsTimeLineUI.this.findViewById(b.f.action_bar_container);
          AppMethodBeat.o(308182);
          return localView;
        }
        
        public final View getMaskView()
        {
          AppMethodBeat.i(308176);
          View localView = SnsTimeLineUI.this.findViewById(b.f.sns_cover_shadow);
          AppMethodBeat.o(308176);
          return localView;
        }
        
        public final ListView getSnsListView()
        {
          AppMethodBeat.i(308169);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).list == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).list = ((ListView)SnsTimeLineUI.this.findViewById(b.f.sns_photo_list));
          }
          ListView localListView = SnsTimeLineUI.k(SnsTimeLineUI.this).list;
          AppMethodBeat.o(308169);
          return localListView;
        }
        
        public final int getType()
        {
          int i = 1;
          if (SnsTimeLineUI.this.RAj == 1) {
            i = 2;
          }
          return i;
        }
        
        public final void hpO()
        {
          AppMethodBeat.i(308166);
          if (al.hgN().QxS)
          {
            Log.i("MicroMsg.SnsTimeLineUI", "isAutoScrolling, skip onLoadingMore");
            AppMethodBeat.o(308166);
            return;
          }
          com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
          SnsTimeLineUI.n(SnsTimeLineUI.this).getType();
          localc.e(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), false, SnsTimeLineUI.A(SnsTimeLineUI.this));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acYi, Integer.valueOf(3));
          Log.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
          if (SnsTimeLineUI.B(SnsTimeLineUI.this) == null)
          {
            Log.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
            AppMethodBeat.o(308166);
            return;
          }
          if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
          {
            SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
            SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
          }
          AppMethodBeat.o(308166);
        }
        
        public final View hpP()
        {
          AppMethodBeat.i(308171);
          if (SnsTimeLineUI.k(SnsTimeLineUI.this).QBg == null) {
            SnsTimeLineUI.k(SnsTimeLineUI.this).QBg = ((FrameLayout)SnsTimeLineUI.this.findViewById(b.f.timeline_root));
          }
          FrameLayout localFrameLayout = SnsTimeLineUI.k(SnsTimeLineUI.this).QBg;
          AppMethodBeat.o(308171);
          return localFrameLayout;
        }
        
        public final MMOverScrollView hpQ()
        {
          AppMethodBeat.i(308178);
          MMOverScrollView localMMOverScrollView = (MMOverScrollView)SnsTimeLineUI.this.findViewById(b.f.sns_pull_down_view);
          AppMethodBeat.o(308178);
          return localMMOverScrollView;
        }
        
        public final boolean hpR()
        {
          AppMethodBeat.i(308190);
          boolean bool = SnsTimeLineUI.D(SnsTimeLineUI.this);
          AppMethodBeat.o(308190);
          return bool;
        }
        
        public final void hpS()
        {
          AppMethodBeat.i(308193);
          Log.d("MicroMsg.SnsTimeLineUI", "onLoadingTap");
          SnsTimeLineUI.this.hmb();
          if ((!SnsTimeLineUI.d(SnsTimeLineUI.this).Rjd) && (!SnsTimeLineUI.E(SnsTimeLineUI.this)))
          {
            if (SnsTimeLineUI.u(SnsTimeLineUI.this) != null)
            {
              Log.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
              SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
            }
            com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this).getType();
            localc.d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acYi, Integer.valueOf(2));
          }
          AppMethodBeat.o(308193);
        }
        
        public final void hpT()
        {
          AppMethodBeat.i(308199);
          al.hgN().hhv();
          int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          Object localObject1 = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getChildAt(0);
          Log.i("MicroMsg.SnsTimeLineUI", "will do up fetch isDoingFetch:%s, SnsCore.getSnsUnreadTipManager().isAutoScrolling:%s", new Object[] { Boolean.valueOf(al.hgN().QxT), Boolean.valueOf(al.hgN().QxS) });
          if ((!al.hgN().QxS) && (localObject1 != null) && (i == 0) && (((View)localObject1).getTop() == 0) && (SnsTimeLineUI.d(SnsTimeLineUI.this).Rjd))
          {
            if (al.hgN().QxT)
            {
              AppMethodBeat.o(308199);
              return;
            }
            Object localObject2 = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this).getType();
            localObject1 = SnsTimeLineUI.o(SnsTimeLineUI.this);
            i = com.tencent.mm.plugin.sns.model.ay.QyA;
            boolean bool = SnsTimeLineUI.q(SnsTimeLineUI.this);
            int j = SnsTimeLineUI.A(SnsTimeLineUI.this);
            if ((((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).hasInit) && (((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).RAj == 0))
            {
              long l = al.hgN().QxP;
              localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject2).RHc;
              if (((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).RyR != null)
              {
                localObject2 = ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject2).RyR.RYJ;
                com.tencent.mm.vending.g.g.b(localObject1, Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(j), Long.valueOf(l)).c((com.tencent.mm.vending.c.a)localObject2);
              }
            }
            if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
            {
              SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
              SnsTimeLineUI.B(SnsTimeLineUI.this).postDelayed(SnsTimeLineUI.C(SnsTimeLineUI.this), 3000L);
            }
          }
          AppMethodBeat.o(308199);
        }
        
        public final void lM(int paramAnonymousInt1, int paramAnonymousInt2) {}
      };
      this.RAg = 0L;
      this.RAh = new a.b() {};
      this.mScreenWidth = 0;
      this.mScreenHeight = 0;
      this.RAi = true;
      this.Bti = 0L;
      this.mxe = 0L;
      this.oCx = 0L;
      this.Rmk = new ScreenShotUtil.ScreenShotCallback()
      {
        public final void onScreenShot(String paramAnonymousString, long paramAnonymousLong)
        {
          AppMethodBeat.i(308313);
          Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
          SnsTimeLineUI.N(SnsTimeLineUI.this);
          AppMethodBeat.o(308313);
        }
      };
      this.RAj = 0;
      this.Bpg = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(307927);
          SnsTimeLineUI.this.hideVKB();
          SnsTimeLineUI.this.finish();
          AppMethodBeat.o(307927);
          return false;
        }
      };
      this.RAm = 0L;
      this.RAn = false;
      AppMethodBeat.o(99372);
      return;
    }
  }
  
  private void El(final boolean paramBoolean)
  {
    AppMethodBeat.i(307690);
    this.mUIAction.list.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99306);
        int i = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
        int j = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getLastVisiblePosition();
        Log.d("MicroMsg.SnsTimeLineUI", "notifyList from:%s to:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        SnsTimeLineUI.a(SnsTimeLineUI.this, i, j);
        if (paramBoolean) {
          SnsTimeLineUI.d(SnsTimeLineUI.this).cuV();
        }
        AppMethodBeat.o(99306);
      }
    }, 15L);
    AppMethodBeat.o(307690);
  }
  
  private static RecordConfigProvider Em(boolean paramBoolean)
  {
    AppMethodBeat.i(307765);
    Object localObject1 = new SightParams(2, 0);
    Object localObject2 = com.tencent.mm.plugin.sns.statistics.d.QDv;
    localObject1 = com.tencent.mm.plugin.sns.statistics.d.a("", "", ((SightParams)localObject1).nLH, ((SightParams)localObject1).nLH.duration * 1000);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVk, false)) {
      ((RecordConfigProvider)localObject1).remuxType = 2;
    }
    localObject2 = new VideoCaptureReportInfo();
    ((VideoCaptureReportInfo)localObject2).ybL = 1;
    ((RecordConfigProvider)localObject1).NIi = ((VideoCaptureReportInfo)localObject2);
    localObject2 = new UICustomParam.a();
    ((UICustomParam.a)localObject2).aQv();
    ((UICustomParam.a)localObject2).aQw();
    ((UICustomParam.a)localObject2).eL(true);
    ((RecordConfigProvider)localObject1).NHR = ((UICustomParam.a)localObject2).lZB;
    ((RecordConfigProvider)localObject1).NHW = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(307765);
    return localObject1;
  }
  
  public static void a(int paramInt1, int paramInt2, com.tencent.mm.am.p paramp, final Context paramContext)
  {
    AppMethodBeat.i(307785);
    if (paramp == null)
    {
      AppMethodBeat.o(307785);
      return;
    }
    if ((paramp.getType() != 213) && (paramp.getType() != 682))
    {
      AppMethodBeat.o(307785);
      return;
    }
    if (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag())
    {
      AppMethodBeat.o(307785);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(307785);
      return;
    }
    if ((!(paramp instanceof com.tencent.mm.plugin.sns.model.p)) && (!(paramp instanceof com.tencent.mm.plugin.sns.model.k)))
    {
      AppMethodBeat.o(307785);
      return;
    }
    if ((paramp instanceof com.tencent.mm.plugin.sns.model.p))
    {
      if (((paramContext instanceof SnsTimeLineUI)) && (((com.tencent.mm.plugin.sns.model.p)paramp).Qsl != 0)) {
        AppMethodBeat.o(307785);
      }
    }
    else if (((paramp instanceof com.tencent.mm.plugin.sns.model.k)) && ((paramContext instanceof SnsTimeLineUI)) && (((com.tencent.mm.plugin.sns.model.k)paramp).mScene != 0))
    {
      AppMethodBeat.o(307785);
      return;
    }
    final long l = com.tencent.mm.model.cn.getSyncServerTimeSecond();
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        Object localObject2 = null;
        Object localObject1 = null;
        AppMethodBeat.i(307549);
        Object localObject4;
        Object localObject3;
        if ((SnsTimeLineUI.this instanceof com.tencent.mm.plugin.sns.model.p))
        {
          localObject2 = (com.tencent.mm.plugin.sns.model.p)SnsTimeLineUI.this;
          if (((com.tencent.mm.plugin.sns.model.p)localObject2).Qsc != null) {
            localObject1 = ((com.tencent.mm.plugin.sns.model.p)localObject2).Qsc.abDp;
          }
          localObject2 = ((com.tencent.mm.plugin.sns.model.p)SnsTimeLineUI.this).PJP;
          localObject4 = ((com.tencent.mm.plugin.sns.model.p)SnsTimeLineUI.this).PJQ;
          localObject3 = localObject1;
          localObject1 = localObject4;
        }
        for (;;)
        {
          if ((localObject3 == null) || (localObject2 == null) || (localObject1 == null))
          {
            AppMethodBeat.o(307549);
            return;
            if ((SnsTimeLineUI.this instanceof com.tencent.mm.plugin.sns.model.k))
            {
              localObject3 = (com.tencent.mm.plugin.sns.model.k)SnsTimeLineUI.this;
              localObject1 = localObject2;
              if (((com.tencent.mm.plugin.sns.model.k)localObject3).Qsc != null) {
                localObject1 = ((com.tencent.mm.plugin.sns.model.k)localObject3).Qsc.abDp;
              }
              localObject2 = ((com.tencent.mm.plugin.sns.model.k)SnsTimeLineUI.this).PJP;
              localObject3 = (com.tencent.mm.plugin.sns.model.k)SnsTimeLineUI.this;
              if (((com.tencent.mm.plugin.sns.model.k)localObject3).PJQ == null) {
                ((com.tencent.mm.plugin.sns.model.k)localObject3).PJQ = ((com.tencent.mm.plugin.sns.model.k)localObject3).hfN();
              }
              localObject4 = ((com.tencent.mm.plugin.sns.model.k)localObject3).PJQ;
              localObject3 = localObject1;
              localObject1 = localObject4;
            }
          }
          else
          {
            localObject2 = com.tencent.mm.plugin.sns.data.t.a((fdp)localObject3, (SnsObject)localObject2);
            if (localObject2 == null)
            {
              AppMethodBeat.o(307549);
              return;
            }
            localObject3 = o.a.YoB.matcher(((fdp)localObject3).nUB);
            if (((Matcher)localObject3).find())
            {
              localObject4 = new StringBuilder();
              if (((fdv)localObject2).abDh != 0) {}
              for (long l = ((fdv)localObject2).abDh;; l = ((fdv)localObject2).abDj)
              {
                localObject4 = l;
                SnsCommentFooter.a(paramContext, localObject1, com.tencent.mm.plugin.sns.data.t.a((fdv)localObject2), (String)localObject4, 3, ((Matcher)localObject3).group(), l);
                break;
              }
            }
            SnsCommentFooter.opP = com.tencent.mm.plugin.fts.a.d.We(79);
            AppMethodBeat.o(307549);
            return;
          }
          localObject1 = null;
          localObject2 = null;
          localObject3 = null;
        }
      }
    }, "WebSearchReportLogic.TagSearchReport");
    AppMethodBeat.o(307785);
  }
  
  public static void a(Activity paramActivity, Boolean paramBoolean)
  {
    AppMethodBeat.i(307780);
    if (com.tencent.mm.n.a.dl(paramActivity))
    {
      AppMethodBeat.o(307780);
      return;
    }
    if (com.tencent.mm.n.a.dp(paramActivity))
    {
      AppMethodBeat.o(307780);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.CAMERA", 18, "");
    Log.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), paramActivity });
    if (!bool)
    {
      AppMethodBeat.o(307780);
      return;
    }
    long l = com.tencent.mm.model.cn.bDv();
    Object localObject = com.tencent.mm.plugin.sns.data.t.heR();
    Log.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", new Object[] { localObject });
    com.tencent.mm.plugin.report.service.h.OAn.b(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), localObject, Long.valueOf(l) });
    CaptureDataManager.c local70 = new CaptureDataManager.c()
    {
      public final void a(Context paramAnonymousContext, CaptureDataManager.CaptureVideoNormalModel paramAnonymousCaptureVideoNormalModel, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(307631);
        com.tencent.mm.plugin.sns.data.t.aXG(paramAnonymousCaptureVideoNormalModel.gHE().J("KEY_EDIT_PUBLISHID_INT", Integer.valueOf(-1)));
        paramAnonymousBundle = new dmb();
        paramAnonymousBundle.aaSg = true;
        paramAnonymousBundle.aaSf = false;
        String str = com.tencent.mm.vfs.y.bEq(paramAnonymousCaptureVideoNormalModel.videoPath);
        paramAnonymousBundle = new SightCaptureResult(true, paramAnonymousCaptureVideoNormalModel.videoPath, paramAnonymousCaptureVideoNormalModel.thumbPath, str, com.tencent.mm.b.g.getMD5(paramAnonymousCaptureVideoNormalModel.videoPath), (int)(paramAnonymousCaptureVideoNormalModel.NHJ.longValue() / 1000L), paramAnonymousBundle);
        if (paramAnonymousCaptureVideoNormalModel.NHK.booleanValue())
        {
          paramAnonymousBundle.KTL = true;
          paramAnonymousBundle.AnF = false;
          paramAnonymousBundle.KTT = paramAnonymousCaptureVideoNormalModel.thumbPath;
        }
        paramAnonymousCaptureVideoNormalModel = new Intent();
        paramAnonymousCaptureVideoNormalModel.putExtra("key_req_result", paramAnonymousBundle);
        ((Activity)paramAnonymousContext).setResult(-1, paramAnonymousCaptureVideoNormalModel);
        ((Activity)paramAnonymousContext).finish();
        AppMethodBeat.o(307631);
      }
      
      public final boolean a(Context paramAnonymousContext, Bundle paramAnonymousBundle, CaptureDataManager.a paramAnonymousa)
      {
        return false;
      }
    };
    CaptureDataManager.NHH.NHG = local70;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVi, true))
    {
      localObject = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(paramActivity, 17, com.tencent.mm.plugin.sns.b.a.sight_slide_bottom_in, com.tencent.mm.plugin.sns.b.a.sight_slide_bottom_out, Em(paramBoolean.booleanValue()));
      AppMethodBeat.o(307780);
      return;
    }
    com.tencent.mm.pluginsdk.ui.tools.t.a(paramActivity, 17, new Intent(), 2, (String)localObject);
    AppMethodBeat.o(307780);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(99406);
    if (paramc.active)
    {
      Log.d("MicroMsg.SnsTimeLineUI", "report weishi: %s", new Object[] { paramc.toString() });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(15827, paramc.toString());
    }
    AppMethodBeat.o(99406);
  }
  
  private void ami(int paramInt)
  {
    AppMethodBeat.i(99376);
    if (RzY.booleanValue()) {
      if (paramInt != 0) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsTimeLineUI", "setRefreshAnimVisible %s %s", new Object[] { Boolean.valueOf(bool), Util.getStack().toString() });
      this.RyX.setVisibility(paramInt);
      AppMethodBeat.o(99376);
      return;
    }
  }
  
  private void amj(int paramInt)
  {
    AppMethodBeat.i(307734);
    com.tencent.mm.plugin.recordvideo.util.b localb = com.tencent.mm.plugin.recordvideo.util.b.Obj;
    if (com.tencent.mm.plugin.recordvideo.util.b.D(this, "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF")) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(20838, new Object[] { Long.valueOf(com.tencent.mm.model.cn.bDv()), Integer.valueOf(Rzz), Integer.valueOf(Rzu), com.tencent.mm.plugin.sns.data.t.heR(), Integer.valueOf(RzA), Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(307734);
      return;
    }
  }
  
  public static void bv(Activity paramActivity)
  {
    AppMethodBeat.i(307740);
    com.tencent.mm.plugin.recordvideo.util.b localb = com.tencent.mm.plugin.recordvideo.util.b.Obj;
    boolean bool = com.tencent.mm.plugin.recordvideo.util.b.D(paramActivity, "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF");
    if (bool) {}
    for (int i = b.j.app_field_secondcut_jump_tip;; i = b.j.app_field_secondcut_install_tip)
    {
      com.tencent.mm.ui.base.k.a(paramActivity, i, b.j.app_tip, b.j.app_ok, b.j.app_cancel, new SnsTimeLineUI.66(bool, paramActivity), new SnsTimeLineUI.67(bool));
      AppMethodBeat.o(307740);
      return;
    }
  }
  
  public static void bw(Activity paramActivity)
  {
    AppMethodBeat.i(307770);
    a(paramActivity, Boolean.TRUE);
    AppMethodBeat.o(307770);
  }
  
  private void d(com.tencent.mm.modelsns.l paraml)
  {
    AppMethodBeat.i(307729);
    long l = com.tencent.mm.model.cn.bDv();
    String str = com.tencent.mm.plugin.sns.data.t.heR();
    com.tencent.mm.plugin.recordvideo.f.c localc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.aTh(str);
    localc = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.aTi(str);
    j.QFS.QGK.vb(str);
    com.tencent.mm.plugin.report.service.h.OAn.b(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), str, Long.valueOf(l) });
    com.tencent.mm.plugin.sns.statistics.l.QGY.b(paraml);
    paraml.bMH();
    this.mUIAction.RDb = paraml;
    this.mUIAction.lN(1, 1);
    this.Rzq.aml(2);
    a(this.Rzq);
    if (this.RAm != 0L)
    {
      paraml = j.QFS;
      j.a(1, getString(b.j.edit_finder_content), 2, hpI(), this.RAm, Rzu);
      this.RAm = 0L;
    }
    amj(2);
    AppMethodBeat.o(307729);
  }
  
  private void hpE()
  {
    AppMethodBeat.i(99380);
    boolean bool;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yIY, 0) == 1)
    {
      bool = true;
      this.autoPlay = bool;
      String str1 = com.tencent.mm.compatible.deviceinfo.q.aPo().toLowerCase();
      String str2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yIZ, "");
      if ((!Util.isNullOrNil(str2)) && (str2.contains(str1)))
      {
        Log.i("MicroMsg.SnsTimeLineUI", "model %s is hit, expt:%s", new Object[] { str1, str2 });
        this.autoPlay = false;
      }
      if (!this.autoPlay) {
        break label225;
      }
      if (!this.Rzr.geL()) {
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
      if (this.Rzr.fvi())
      {
        Log.i("MicroMsg.SnsTimeLineUI", "wifi autoplay true");
        this.autoPlay = true;
      }
      else
      {
        this.autoPlay = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPt, Boolean.TRUE)).booleanValue();
        continue;
        label225:
        Log.i("MicroMsg.SnsTimeLineUI", "autoPlay DynamicConfig false");
      }
    }
  }
  
  private void hpF()
  {
    AppMethodBeat.i(99381);
    if (this.RAj == 1)
    {
      if (!this.RdS)
      {
        enableOptionMenu(false);
        AppMethodBeat.o(99381);
        return;
      }
      addIconOptionMenu(0, getString(b.j.sns_message_desc), b.i.actionbar_list_icon, new SnsTimeLineUI.41(this));
      AppMethodBeat.o(99381);
      return;
    }
    addIconOptionMenu(0, b.j.sns_action_bar_take_photo_btn_desc, b.i.icons_filled_camera, new SnsTimeLineUI.42(this), new SnsTimeLineUI.43(this));
    boolean bool1 = getIntent().getBooleanExtra("sns_timeline_NeedShowPushlistDialog", false);
    boolean bool2 = getIntent().getBooleanExtra("sns_timeline_NeedShowPulistText", false);
    if ((bool1) && (this.Rza != null) && (this.Rza.RbA != null)) {
      this.Rza.RbA.postDelayed(new SnsTimeLineUI.44(this), 150L);
    }
    if ((bool2) && (this.Rza != null) && (this.Rza.RbA != null)) {
      this.Rza.RbA.postDelayed(new SnsTimeLineUI.45(this), 200L);
    }
    AppMethodBeat.o(99381);
  }
  
  private boolean hpG()
  {
    AppMethodBeat.i(307714);
    if ((this.Rza != null) && (this.Rza.Rbw != null)) {
      this.Rza.Rbw.Qwn.DI(true);
    }
    com.tencent.mm.kernel.h.baF();
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(7490, Boolean.TRUE)).booleanValue();
    al.hgJ().DX(true);
    Object localObject1 = al.hgJ().aZP("draft_text");
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.sns.storage.s)localObject1).field_draft;
      if (!Util.isNullOrNil((byte[])localObject1))
      {
        com.tencent.mm.kernel.h.baF();
        localObject3 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKr, "");
        new nr().aIV().vM((String)localObject3).bMH();
        localObject3 = Parcel.obtain();
        ((Parcel)localObject3).unmarshall((byte[])localObject1, 0, localObject1.length);
        ((Parcel)localObject3).setDataPosition(0);
      }
    }
    try
    {
      localObject1 = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject3);
      if ((localObject1 == null) || (((Intent)localObject1).getIntExtra("Ksnsupload_type", 0) != 9)) {
        break label496;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        al.hgJ().b("draft_text", null, 0);
        continue;
        Object localObject2 = new Intent().setClass(this, SnsLongMsgUI.class);
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "doLongeClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "doLongeClick", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().B(7490, Boolean.FALSE);
        continue;
        int i = 0;
      }
    }
    if (i != 0)
    {
      startActivityForResult((Intent)localObject1, 9);
      AppMethodBeat.o(307714);
      return true;
    }
    al.hgJ().b("draft_text", null, 0);
    if (!bool)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).setClass(this, SnsUploadUI.class);
      ((Intent)localObject1).putExtra("KSnsPostManu", true);
      ((Intent)localObject1).putExtra("KTouchCameraTime", Util.nowSecond());
      ((Intent)localObject1).putExtra("sns_comment_type", 1);
      ((Intent)localObject1).putExtra("Ksnsupload_type", 9);
      localObject3 = com.tencent.mm.modelsns.l.wO(705);
      ((com.tencent.mm.modelsns.l)localObject3).wS(((com.tencent.mm.modelsns.l)localObject3).oUi).Pi(System.currentTimeMillis()).wS(((com.tencent.mm.modelsns.l)localObject3).oUj).wS(1);
      localObject3 = com.tencent.mm.plugin.sns.statistics.l.QGY.b((com.tencent.mm.modelsns.l)localObject3);
      ((com.tencent.mm.modelsns.l)localObject3).bMH();
      ((com.tencent.mm.modelsns.l)localObject3).b((Intent)localObject1, "intent_key_StatisticsOplog");
      startActivityForResult((Intent)localObject1, 9);
      AppMethodBeat.o(307714);
      return true;
    }
  }
  
  private void hpH()
  {
    AppMethodBeat.i(99391);
    setTitleBarClickListener(new SnsTimeLineUI.61(this), new SnsTimeLineUI.62(this));
    setBackBtn(this.Bpg, b.i.actionbar_icon_dark_back);
    AppMethodBeat.o(99391);
  }
  
  private int hpI()
  {
    if (this.Rzy == 0) {
      return this.Rzv;
    }
    if (this.Rzy == 1) {
      return this.Rzw;
    }
    return this.Rzx;
  }
  
  private void hpJ()
  {
    AppMethodBeat.i(99392);
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.adfH, Boolean.TRUE)).booleanValue();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adfH, Boolean.FALSE);
    if (bool) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfH, Boolean.FALSE);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.h.baF();
      int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acYs, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.k.c(getContext(), "", getContext().getResources().getString(b.j.story_one_day_post_tip, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(99392);
      return;
    }
    ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).startStoryCaptureForResult(getContext(), 0, System.currentTimeMillis(), 18);
    AppMethodBeat.o(99392);
  }
  
  public static boolean hpL()
  {
    AppMethodBeat.i(307790);
    boolean bool = com.tencent.matrix.b.gg("clicfg_sns_cancel_camera_sheet");
    AppMethodBeat.o(307790);
    return bool;
  }
  
  public static boolean hpM()
  {
    AppMethodBeat.i(307796);
    boolean bool = com.tencent.matrix.b.gg("clicfg_sns_gallery_show_secondcut");
    AppMethodBeat.o(307796);
    return bool;
  }
  
  private boolean jM(View paramView)
  {
    AppMethodBeat.i(307719);
    try
    {
      if (getContext() != null)
      {
        boolean bool = getContext().isFinishing();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(307719);
        return false;
      }
      Rect localRect = new Rect();
      paramView.getGlobalVisibleRect(localRect);
      paramView = new DisplayMetrics();
      getContext().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      int i = paramView.heightPixels;
      int j = this.mActionBar.getHeight() + com.tencent.mm.ui.aw.mL(this);
      Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "lxl checkItemVisible actionbar height:%s, total height:%s, screenHeight:%s, top:%s, bottom:%s", new Object[] { Integer.valueOf(this.mActionBar.getHeight()), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(localRect.top), Integer.valueOf(localRect.bottom) });
      if ((localRect.bottom > j) && (i > localRect.top))
      {
        AppMethodBeat.o(307719);
        return true;
      }
    }
    finally
    {
      Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", paramView.toString());
      AppMethodBeat.o(307719);
      return false;
    }
    AppMethodBeat.o(307719);
    return false;
  }
  
  public final void En(boolean paramBoolean)
  {
    AppMethodBeat.i(99405);
    if (this.RyU != null)
    {
      Log.i("MicroMsg.SnsTimeLineUI", "set play animation %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.mm.plugin.sns.ui.a.c localc = this.RyU;
      localc.RGE = paramBoolean;
      if (!paramBoolean) {
        localc.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(99405);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, final com.tencent.mm.plugin.sns.c.b paramb, boolean paramBoolean2)
  {
    AppMethodBeat.i(308117);
    Log.i("MicroMsg.SnsTimeLineUI", "onOtherAddSize respMaxSeq:%s, respMinSeq:%s", new Object[] { paramString1, paramString2 });
    this.RAd.removeCallbacks(this.RzD);
    this.mUIAction.isLoading = false;
    com.tencent.mm.vending.g.g.jJU().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(308117);
  }
  
  public final void a(final String paramString, boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.c.b paramb)
  {
    AppMethodBeat.i(99373);
    this.RAd.removeCallbacks(this.RzD);
    this.mUIAction.isLoading = false;
    com.tencent.mm.vending.g.g.jJU().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
    {
      private Void o(Void paramAnonymousVoid)
      {
        AppMethodBeat.i(176300);
        if (SnsTimeLineUI.l(SnsTimeLineUI.this) != null)
        {
          SnsTimeLineUI.m(SnsTimeLineUI.this);
          SnsTimeLineUI.l(SnsTimeLineUI.this).hqa();
        }
        SnsTimeLineUI.d(SnsTimeLineUI.this).wFp = paramb.hdV();
        if (paramb.hdV())
        {
          SnsTimeLineUI.d(SnsTimeLineUI.this).baP(paramb.heb());
          if (SnsTimeLineUI.this.RAj == 1) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).baw(paramb.heb());
          }
        }
        for (;;)
        {
          SnsTimeLineUI.d(SnsTimeLineUI.this).hqh();
          al.hgN().hhv();
          al.hgN().uV(0L);
          AppMethodBeat.o(176300);
          return paramAnonymousVoid;
          if (paramb.hdW())
          {
            com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.r(SnsTimeLineUI.this);
            SnsTimeLineUI.n(SnsTimeLineUI.this).getType();
            localc.e(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), 0);
          }
        }
      }
    });
    AppMethodBeat.o(99373);
  }
  
  public final void b(final String paramString, final boolean paramBoolean, final int paramInt, final com.tencent.mm.plugin.sns.c.b paramb)
  {
    AppMethodBeat.i(99374);
    this.RAd.removeCallbacks(this.RzD);
    this.mUIAction.isLoading = false;
    com.tencent.mm.plugin.sns.statistics.e locale = this.Rza.Rbw.Qwn;
    locale.QEU += 1L;
    com.tencent.mm.vending.g.g.jJU().d(new com.tencent.mm.vending.c.a() {}).f(new com.tencent.mm.vending.c.a()
    {
      private Void o(Void paramAnonymousVoid)
      {
        AppMethodBeat.i(308189);
        if (SnsTimeLineUI.l(SnsTimeLineUI.this) != null)
        {
          SnsTimeLineUI.m(SnsTimeLineUI.this);
          SnsTimeLineUI.l(SnsTimeLineUI.this).hqa();
        }
        SnsTimeLineUI.d(SnsTimeLineUI.this).wFp = paramb.hdV();
        if (SnsTimeLineUI.this.RAj == 0)
        {
          Log.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[] { Boolean.valueOf(paramb.hdV()) });
          if (paramb.hdV()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).baP(paramb.heb());
          }
          AppMethodBeat.o(308189);
          return paramAnonymousVoid;
        }
        if ((paramBoolean) && (!SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))))
        {
          SnsTimeLineUI.d(SnsTimeLineUI.this).wFp = true;
          SnsTimeLineUI.d(SnsTimeLineUI.this).baw(paramb.heb());
        }
        for (;;)
        {
          AppMethodBeat.o(308189);
          return paramAnonymousVoid;
          if ((SnsTimeLineUI.s(SnsTimeLineUI.this).equals(SnsTimeLineUI.o(SnsTimeLineUI.this))) && (paramb.hea() != 0L))
          {
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acPN, Long.valueOf(paramb.hea()));
          }
          if (paramb.hdV()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).baP(paramb.heb());
          }
        }
      }
    });
    AppMethodBeat.o(99374);
  }
  
  public final void bCn()
  {
    AppMethodBeat.i(99396);
    bbE().ct(c.b.class);
    AppMethodBeat.o(99396);
  }
  
  public final void bCo() {}
  
  public final void bCp()
  {
    AppMethodBeat.i(99397);
    if (this.RAn)
    {
      AppMethodBeat.o(99397);
      return;
    }
    Log.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
    this.RAn = true;
    al.fAG().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307558);
        if (SnsTimeLineUI.a(SnsTimeLineUI.this) != null) {
          SnsTimeLineUI.a(SnsTimeLineUI.this).RGD.notifyVendingDataChange();
        }
        SnsTimeLineUI.ae(SnsTimeLineUI.this);
        AppMethodBeat.o(307558);
      }
    }, 1000L);
    AppMethodBeat.o(99397);
  }
  
  public final void bCq()
  {
    AppMethodBeat.i(99400);
    bbE().ct(c.b.class);
    AppMethodBeat.o(99400);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(99378);
    Log.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[] { paramKeyEvent.toString() });
    int k = keyboardState();
    i locali = this.Rza;
    int i = j;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      i = j;
      if (locali.RbA.getVisibility() == 0)
      {
        locali.RbA.setVisibility(8);
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
  
  protected void finalize()
  {
    AppMethodBeat.i(99399);
    Log.d("MicroMsg.SnsTimeLineUI", "finalize");
    super.finalize();
    AppMethodBeat.o(99399);
  }
  
  public int getLayoutId()
  {
    return b.g.sns_timeline_ui;
  }
  
  public final boolean hmb()
  {
    AppMethodBeat.i(99395);
    if ((this.Rza == null) || (this.Rza.RbH == null))
    {
      AppMethodBeat.o(99395);
      return false;
    }
    if ((this.Rza == null) || (this.Rza.RbI == null))
    {
      if ((this.Rza != null) && (this.Rza.RbK != null)) {
        break label118;
      }
      label65:
      if ((this.Rza != null) && (this.Rza.RbL != null)) {
        break label132;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.gZr();
      boolean bool = this.Rza.RbH.hmb();
      AppMethodBeat.o(99395);
      return bool;
      this.Rza.RbI.hib();
      break;
      label118:
      this.Rza.RbK.hib();
      break label65;
      label132:
      this.Rza.RbL.hqH();
    }
  }
  
  public final com.tencent.mm.plugin.sns.ad.g.l hpK()
  {
    return this.RoZ;
  }
  
  public void initView()
  {
    boolean bool3 = false;
    AppMethodBeat.i(99388);
    this.mUIAction.QCY.setDrawingCacheEnabled(false);
    this.Rza.QBg = ((FrameLayout)findViewById(b.f.timeline_root));
    int i = al.hgM().position;
    Object localObject = (AdListView)this.mUIAction.getSnsListView();
    ((AdListView)localObject).QZR = this.RoZ;
    ((AdListView)localObject).setTimelineStat(this.Rzi);
    ((AdListView)localObject).setTimelineEvent(this.Rzj);
    this.Rzj.a(al.hgs());
    Log.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.RbF, new Object[] { Integer.valueOf(i) });
    this.RyX = ((QFadeImageView)findViewById(b.f.sns_refresh_iv));
    this.RyX.setImageResource(b.i.friendactivity_refresh);
    this.Rzc = new a(this.mUIAction.getSnsListView());
    this.Rzc.setInterpolator(new LinearInterpolator());
    this.Rzc.setAnimationListener(new SnsTimeLineUI.48(this));
    localObject = null;
    if (this.RAj == 1)
    {
      this.RyZ = true;
      localObject = new com.tencent.mm.plugin.sns.ui.a.b.d(this.sWX, this.RdS);
    }
    this.RyU = new com.tencent.mm.plugin.sns.ui.a.c(this, this.mUIAction.getSnsListView(), this.Rza.RbM, this.Rza, this.Rzk, (com.tencent.mm.plugin.sns.ui.a.b.b)localObject, this.RzG);
    this.Rza.RbM.RQH = new bn.b()
    {
      public final boolean hpD()
      {
        AppMethodBeat.i(307867);
        SnsTimeLineUI.this.bbE().ct(c.b.class);
        AppMethodBeat.o(307867);
        return false;
      }
    };
    this.Rza.QBJ = this.RyU.RGC;
    this.RyU.RGD.agtA = new com.tencent.mm.vending.a.b.a()
    {
      public final void hpW()
      {
        AppMethodBeat.i(307804);
        com.tencent.mm.plugin.report.service.g.ahw(14);
        AppMethodBeat.o(307804);
      }
      
      public final void hpX()
      {
        AppMethodBeat.i(307810);
        com.tencent.mm.plugin.report.service.g.ahx(14);
        AppMethodBeat.o(307810);
      }
    };
    this.Rzd = ((TestTimeForSns)this.Rza.QBg);
    this.Rzd.setListener(new TestTimeForSns.a()
    {
      public final void fBx()
      {
        AppMethodBeat.i(307809);
        Log.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
        SnsTimeLineUI.I(SnsTimeLineUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(308425);
            if ((SnsTimeLineUI.a(SnsTimeLineUI.this) == null) || (SnsTimeLineUI.I(SnsTimeLineUI.this) == null))
            {
              Log.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
              AppMethodBeat.o(308425);
              return;
            }
            SnsTimeLineUI.I(SnsTimeLineUI.this).setListener(null);
            SnsTimeLineUI.a(SnsTimeLineUI.this, SnsTimeLineUI.P(SnsTimeLineUI.this));
            if (SnsTimeLineUI.Q(SnsTimeLineUI.this))
            {
              Log.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
              AppMethodBeat.o(308425);
              return;
            }
            if (SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              al.hgr().ax(al.hgM().QwG, -1);
              al.hgr().uU(al.hgM().QwH);
            }
            Object localObject1;
            int i;
            if (!SnsTimeLineUI.D(SnsTimeLineUI.this))
            {
              Log.i("MicroMsg.SnsTimeLineUI", "onViewDrawed doFpList");
              localObject1 = al.hgK();
              Object localObject2 = "select *,rowid from SnsWsFoldGroup  where SnsWsFoldGroup.state=" + ah.QZC + " order by SnsWsFoldGroup.top desc limit 1";
              localObject1 = ((ah)localObject1).omV.rawQuery((String)localObject2, null, 2);
              if (localObject1 == null) {
                break label540;
              }
              if (!((Cursor)localObject1).moveToFirst()) {
                break label535;
              }
              localObject2 = new ag();
              ((ag)localObject2).convertFrom((Cursor)localObject1);
              i = ((ag)localObject2).field_size;
              ((Cursor)localObject1).close();
            }
            for (;;)
            {
              Log.i("MicroMsg.SnsTimeLineUI", "oldWsFoldSize:%s newWsFoldSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(aj.Quq) });
              if ((i != -1) && (i != aj.Quq))
              {
                localObject1 = al.hgK();
                long l = System.currentTimeMillis();
                Log.i("MicroMsg.SnsWsFoldGroupStorage", "dropTable:%s %s", new Object[] { Boolean.valueOf(((ah)localObject1).omV.execSQL("SnsWsFoldGroup", "DELETE FROM SnsWsFoldGroup")), Long.valueOf(System.currentTimeMillis() - l) });
                localObject1 = al.hgL();
                l = System.currentTimeMillis();
                boolean bool = ((af)localObject1).omV.execSQL("SnsWsFoldGroupDetail", "DELETE FROM SnsWsFoldGroupDetail");
                ((af)localObject1).QZB.clear();
                Log.i("MicroMsg.SnsWsFoldDetailStorage", "dropTable:%s %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
              }
              localObject1 = SnsTimeLineUI.r(SnsTimeLineUI.this);
              SnsTimeLineUI.n(SnsTimeLineUI.this).getType();
              ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).d(SnsTimeLineUI.o(SnsTimeLineUI.this), SnsTimeLineUI.p(SnsTimeLineUI.this), SnsTimeLineUI.q(SnsTimeLineUI.this), SnsTimeLineUI.A(SnsTimeLineUI.this));
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acYi, Integer.valueOf(1));
              SnsTimeLineUI.a(SnsTimeLineUI.this, false);
              if (SnsTimeLineUI.this.RoZ != null) {
                SnsTimeLineUI.this.RoZ.hbi();
              }
              AppMethodBeat.o(308425);
              return;
              label535:
              i = -1;
              break;
              label540:
              i = -1;
            }
          }
        });
        AppMethodBeat.o(307809);
      }
    });
    this.mUIAction.list.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(307803);
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          SnsTimeLineUI.this.hmb();
          if ((SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) && (SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition() == 0)) {
            Log.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
          }
          SnsTimeLineUI.l(SnsTimeLineUI.this).hqb();
        }
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).list != null) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).list.getFirstVisiblePosition();
          }
          SnsTimeLineUI.k(SnsTimeLineUI.this).hlC();
          SnsTimeLineUI.k(SnsTimeLineUI.this).RbB.hqG();
        }
        AppMethodBeat.o(307803);
        return false;
      }
    });
    this.mUIAction.list.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179270);
        if (SnsTimeLineUI.k(SnsTimeLineUI.this) == null)
        {
          AppMethodBeat.o(179270);
          return;
        }
        SnsTimeLineUI.k(SnsTimeLineUI.this).RbB.RoH = SnsTimeLineUI.d(SnsTimeLineUI.this).list.getBottom();
        SnsTimeLineUI.k(SnsTimeLineUI.this).RbB.CMA = SnsTimeLineUI.d(SnsTimeLineUI.this).RCD.getTop();
        SnsTimeLineUI.l(SnsTimeLineUI.this).RAX = com.tencent.mm.ui.bd.fromDPToPix(SnsTimeLineUI.this.getContext(), -44);
        AppMethodBeat.o(179270);
      }
    });
    this.mUIAction.RCF.a(new h.d()
    {
      private boolean RAE = false;
      
      public final void Ep(boolean paramAnonymousBoolean)
      {
        int i = 1;
        AppMethodBeat.i(307827);
        this.RAE = false;
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(307827);
          return;
        }
        if (SnsTimeLineUI.d(SnsTimeLineUI.this).dsp())
        {
          if (!SnsTimeLineUI.d(SnsTimeLineUI.this).Rjd) {
            SnsTimeLineUI.l(SnsTimeLineUI.this).hqb();
          }
          Object localObject = SnsTimeLineUI.this;
          if (SnsTimeLineUI.S(SnsTimeLineUI.this)) {
            break label172;
          }
          paramAnonymousBoolean = true;
          SnsTimeLineUI.b((SnsTimeLineUI)localObject, paramAnonymousBoolean);
          localObject = SnsTimeLineUI.l(SnsTimeLineUI.this);
          AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(((SnsTimeLineUI.a)localObject).RAo).getLayoutParams();
          if ((localLayoutParams == null) || (localLayoutParams.y != ((SnsTimeLineUI.a)localObject).RAN)) {
            break label177;
          }
        }
        for (;;)
        {
          if (i != 0) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).RCL.hpS();
          }
          if (SnsTimeLineUI.d(SnsTimeLineUI.this).dsq()) {
            SnsTimeLineUI.d(SnsTimeLineUI.this).hqd();
          }
          AppMethodBeat.o(307827);
          return;
          label172:
          paramAnonymousBoolean = false;
          break;
          label177:
          i = 0;
        }
      }
      
      public final void hpY()
      {
        this.RAE = true;
      }
      
      public final void v(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(307825);
        if ((!paramAnonymousBoolean) || (!this.RAE))
        {
          AppMethodBeat.o(307825);
          return;
        }
        SnsTimeLineUI.R(SnsTimeLineUI.this);
        if (SnsTimeLineUI.RzY.booleanValue()) {
          Log.i("MicroMsg.SnsTimeLineUI", "mUIAction.header.getTop %s originalHeaderTop %s distanceY %s", new Object[] { Integer.valueOf(SnsTimeLineUI.d(SnsTimeLineUI.this).QCY.getTop()), Integer.valueOf(SnsTimeLineUI.l(SnsTimeLineUI.this).RAX), Integer.valueOf(paramAnonymousInt1) });
        }
        if (((paramAnonymousInt1 > 0) || (SnsTimeLineUI.S(SnsTimeLineUI.this))) && ((SnsTimeLineUI.d(SnsTimeLineUI.this).QCY.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).RAX) || (paramAnonymousInt1 > 0)) && (!SnsTimeLineUI.d(SnsTimeLineUI.this).Rjd)) {
          SnsTimeLineUI.l(SnsTimeLineUI.this).dq(paramAnonymousInt1);
        }
        SnsTimeLineUI.k(SnsTimeLineUI.this).hlC();
        SnsTimeLineUI.this.hmb();
        SnsTimeLineUI.k(SnsTimeLineUI.this).RbB.hqG();
        AppMethodBeat.o(307825);
      }
    });
    this.Rza.RbA = ((SnsCommentFooter)findViewById(b.f.comment_footer));
    this.Rza.RbA.post(new SnsTimeLineUI.55(this));
    this.Rza.RbB = new bx(this.mUIAction.list, this.Rza.RbA);
    this.RyV = ((LinearLayout)this.mUIAction.QCY.findViewById(b.f.sns_notify_list));
    this.RyV.findViewById(b.f.sns_notify_for_click).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(307815);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$58", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((SnsTimeLineUI.k(SnsTimeLineUI.this) != null) && (SnsTimeLineUI.k(SnsTimeLineUI.this).Rbw != null)) {
          SnsTimeLineUI.k(SnsTimeLineUI.this).Rbw.Qwn.DH(true);
        }
        paramAnonymousView = (c.b)SnsTimeLineUI.this.bbE().v(c.b.class);
        localObject = com.tencent.mm.modelsns.l.wO(725);
        ((com.tencent.mm.modelsns.l)localObject).wR(paramAnonymousView.HGq);
        ((com.tencent.mm.modelsns.l)localObject).bMH();
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(SnsTimeLineUI.this, SnsMsgUI.class);
        paramAnonymousView.putExtra("sns_msg_comment_list_scene", 1);
        SnsTimeLineUI.this.startActivityForResult(paramAnonymousView, 13);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$58", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(307815);
      }
    });
    this.RyW = ((LinearLayout)this.mUIAction.QCY.findViewById(b.f.sns_notify_media_content_collapse));
    this.Rza.RbC = new be(this);
    hpF();
    hpH();
    boolean bool1;
    label591:
    boolean bool2;
    if (this.RAj == 0)
    {
      setMMTitle(b.j.sns_timeline_ui_title);
      if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
        break label923;
      }
      bool1 = true;
      if (1 != ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zmD, 0)) {
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
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1198, 7);
      }
    }
    for (;;)
    {
      this.Rzs = ((ViewGroup)findViewById(b.f.sns_unread_tip_group));
      this.Rzs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(307817);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$59", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          SnsTimeLineUI.k(SnsTimeLineUI.this).hlI();
          j.QFS.QGC.jpE = 2L;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$59", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(307817);
        }
      });
      this.Rzs.setVisibility(4);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = (com.tencent.mm.ui.bd.fromDPToPix(getContext(), 24) + bf.fs(getContext()) + bf.getStatusBarHeight(getContext()));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.Rzs.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(99388);
      return;
      if (this.RdS)
      {
        setMMTitle(b.j.sns_photo_ui_title);
        ami(8);
        break;
      }
      Log.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, userName:%s, title:%s", new Object[] { this.sWX, this.mUIAction.title });
      localObject = al.hgp().JE(this.sWX);
      if (localObject != null) {
        Log.d("MicroMsg.SnsTimeLineUI", "SnsUserUI, contact is not null");
      }
      for (localObject = ((com.tencent.mm.contact.d)localObject).aSV();; localObject = this.mUIAction.title)
      {
        setMMTitle(com.tencent.mm.plugin.sns.data.t.aq((CharSequence)localObject));
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
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1198, 8);
      } else if (i <= 6144) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1198, 9);
      } else if (i <= 8192) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1198, 10);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1198, 11);
      }
    }
  }
  
  public final boolean jG(View paramView)
  {
    AppMethodBeat.i(99394);
    this.Rza.RbI.hib();
    this.Rza.RbK.hib();
    boolean bool = this.Rza.RbH.jG(paramView);
    AppMethodBeat.o(99394);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99402);
    Log.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 15)
    {
      if ((this.Rza != null) && (this.Rza.RbM != null) && (this.Rza.RbM.RPU != null))
      {
        this.Rza.RbM.RPU.onActivityResult(paramInt1, paramInt2, paramIntent);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(307542);
            SnsTimeLineUI.this.hideVKB();
            AppMethodBeat.o(307542);
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
          this.Rza.RbA.evh();
          String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(localObject[0]);
          if (!Util.isNullOrNil(str))
          {
            this.Rza.RbA.hoz();
            this.Rza.RbA.setText("@" + str + " ");
            this.Rza.RbA.setCommentAtPrefix("@" + str + " ");
            this.Rza.RbA.setCommentInfo(new fdv());
            this.Rza.RbA.getCommentInfo().Username = localObject[0];
            this.Rza.RbA.setCommentFlag(8);
          }
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mUIAction.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 11)
    {
      paramIntent = this.RyT;
      this.RAf.getType();
      paramIntent.d(this.sWX, this.Rzl, this.RdS, this.Rzm);
      AppMethodBeat.o(99402);
      return;
    }
    AppMethodBeat.o(99402);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(99401);
    if (!this.mUIAction.onBackPressed()) {
      finish();
    }
    AppMethodBeat.o(99401);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99382);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
    new cy().publish();
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    Point localPoint = new Point();
    localPoint.x = paramConfiguration.widthPixels;
    localPoint.y = paramConfiguration.heightPixels;
    al.m(localPoint);
    com.tencent.mm.plugin.sns.ui.widget.i.hsX().RXd = 0;
    com.tencent.mm.plugin.sns.ui.widget.f.hsU().RXd = 0;
    com.tencent.mm.kiss.widget.textview.c.mGx.bbI();
    this.RyU.RGC.hpt();
    this.RyU.RGD.resolvedClear();
    AppMethodBeat.o(99382);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99379);
    com.tencent.mm.ui.aw.bW(this);
    Object localObject1;
    if (Rzo == null)
    {
      Rzo = Boolean.valueOf(com.tencent.mm.ui.aw.isDarkMode());
      com.tencent.mm.plugin.sns.ui.widget.i.resetConfig();
      com.tencent.mm.plugin.sns.model.b.a.hhO();
      localObject1 = al.hgz();
      ((ba)localObject1).oZS = true;
      Log.i("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", new Object[] { Boolean.valueOf(((ba)localObject1).oZS) });
      if (((((ba)localObject1).oZS) && (!com.tencent.mm.plugin.sns.model.b.a.hhP())) || (((ba)localObject1).oZR)) {
        ((ba)localObject1).eGB();
      }
      com.tencent.mm.modelvideo.v.bOj().hp(((ba)localObject1).oZS);
      localObject1 = al.hgN();
      if (!BuildInfo.DEBUG) {
        break label1114;
      }
      ((ax)localObject1).Qxy = true;
      ((ax)localObject1).Qxz = 1L;
      ((ax)localObject1).QxA = 86400L;
      ((ax)localObject1).QxB = 1;
      ((ax)localObject1).QxC = 1;
      ((ax)localObject1).QxD = 50;
      ((ax)localObject1).QxF = 2;
      ((ax)localObject1).QxE = 5;
      ((ax)localObject1).QxG = 0L;
      label172:
      Log.i("MicroMsg.SnsUnreadTipManager", "jumpEnable:%s, jumpMinInterval:%s, jumpMaxInterval:%s, jumpMinFeedsCount:%s, jumpMinFeedsGapCount:%s, jumpNotWsPercent:%s, jumpIndicatorIndexOffset:%s, jumpReadContinuousCount:%s, jumpIndicatorExposeInterval:%s", new Object[] { Boolean.valueOf(((ax)localObject1).Qxy), Long.valueOf(((ax)localObject1).Qxz), Long.valueOf(((ax)localObject1).QxA), Integer.valueOf(((ax)localObject1).QxB), Integer.valueOf(((ax)localObject1).QxC), Integer.valueOf(((ax)localObject1).QxD), Integer.valueOf(((ax)localObject1).QxF), Integer.valueOf(((ax)localObject1).QxE), Long.valueOf(((ax)localObject1).QxG) });
      if (((ax)localObject1).Qxy) {
        ((ax)localObject1).Qxx = (al.getAccSnsPath() + "snsUnread.proto");
      }
    }
    int i;
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.mm.vfs.y.bi(((ax)localObject1).Qxx, 0, -1);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          ((ax)localObject1).QxU.parseFrom((byte[])localObject2);
          i = com.tencent.mm.model.cn.getSyncServerTimeSecond();
          Log.i("MicroMsg.SnsUnreadTipManager", "unreadSnsIdList.indicatorExposeTime:%s, now:%s, jumpIndicatorExposeInterval:%s", new Object[] { Long.valueOf(((ax)localObject1).QxU.QxZ), Integer.valueOf(i), Long.valueOf(((ax)localObject1).QxG) });
          if ((((ax)localObject1).QxU.QxZ <= 0L) || (i - ((ax)localObject1).QxU.QxZ <= ((ax)localObject1).QxG)) {
            continue;
          }
          ((ax)localObject1).QxU.QxZ = 0L;
          ((ax)localObject1).QxZ = ((ax)localObject1).QxU.QxZ;
          ((ax)localObject1).hhr();
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        label1114:
        Log.w("MicroMsg.SnsUnreadTipManager", "Exception:%s", new Object[] { localException.getMessage() });
        continue;
        bool = false;
        continue;
        au.Qxd = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zfh, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zfg, 1) != 1) {
          continue;
        }
        bool = true;
        au.Qxe = bool;
        au.Qxf = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zfi, 60);
        continue;
        bool = false;
        continue;
        long l = au.Qxd - Util.milliSecondsToNow(((au)localObject1).Qxg);
        Log.i(au.TAG, "delay %s to reset", new Object[] { Long.valueOf(l) });
        MMHandlerThread.postToMainThreadDelayed(((au)localObject1).Qxk, l);
        continue;
        MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVSnsUI", true);
        this.Inv = findViewById(b.f.action_bar_container);
        if (this.Inv == null) {
          break label1598;
        }
      }
      ((ax)localObject1).hhp();
      ((ax)localObject1).hhq();
      Log.i("MicroMsg.SnsUnreadTipManager", "firstUnreadId:%s unreadSnsIdList.lastSnsId:%s", new Object[] { Long.valueOf(((ax)localObject1).QxL), Long.valueOf(((ax)localObject1).QxU.QCN) });
      ((ax)localObject1).hhs();
      ((ax)localObject1).sessionId = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHO();
      localObject1 = ((ax)localObject1).Qyf;
      com.tencent.mm.kernel.h.baD().mCm.a(211, (com.tencent.mm.am.h)localObject1);
      ((com.tencent.mm.plugin.sns.model.aw)localObject1).Qxw = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zow, 50);
      Log.i("MicroMsg.SnsUnreadPreloader", "onCreate PRELOAD_MAX_COUNT:%s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sns.model.aw)localObject1).Qxw) });
      localObject1 = al.hgO();
      Log.i(au.TAG, "create");
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
      {
        au.Qxd = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zfh, 300) * 1000;
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zfg, 1) == 1)
        {
          bool = true;
          au.Qxe = bool;
          au.Qxf = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zfi, 60);
          Log.i(au.TAG, "updateConfig configEnable:%s, configInterval:%s, configExpiredTime:%s", new Object[] { Boolean.valueOf(au.Qxe), Integer.valueOf(au.Qxf), Long.valueOf(au.Qxd) });
          if (((au)localObject1).Qxg != 0L)
          {
            if (Util.milliSecondsToNow(((au)localObject1).Qxg) < au.Qxd) {
              continue;
            }
            Log.i(au.TAG, "already expired, reset directly");
            MMHandlerThread.postToMainThread(((au)localObject1).Qxk);
            if (((au)localObject1).Qxi != null)
            {
              localObject2 = com.tencent.mm.plugin.sns.model.ap.E(((au)localObject1).Qxi);
              if (localObject2 != null)
              {
                j.QFS.QGD.xe(((au)localObject1).Qxj);
                j.QFS.QGD.xd(com.tencent.mm.plugin.sns.data.t.uB(((au)localObject1).Qxi.field_snsId));
                j.QFS.QGD.jpO = ((SnsObject)localObject2).LikeCount;
                j.QFS.QGD.jpP = ((SnsObject)localObject2).CommentCount;
                j.QFS.QGD.xf(String.valueOf(System.currentTimeMillis()));
                j.QFS.QGE.xe(((au)localObject1).Qxj);
                j.QFS.QGE.xd(com.tencent.mm.plugin.sns.data.t.uB(((au)localObject1).Qxi.field_snsId));
                j.QFS.QGE.jpO = ((SnsObject)localObject2).LikeCount;
                j.QFS.QGE.jpP = ((SnsObject)localObject2).CommentCount;
                j.QFS.QGE.xf(String.valueOf(System.currentTimeMillis()));
              }
            }
          }
          if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class) != null) {
            ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiA("__sns_timeline__");
          }
          if (this.mController != null) {
            this.mController.cD(2, true);
          }
          getIntent().setExtrasClassLoader(getClass().getClassLoader());
          com.tencent.mm.pluginsdk.h.w(this);
          customfixStatusbar(true);
          super.onCreate(paramBundle);
          if (com.tencent.mm.kernel.h.baC().aZN()) {
            continue;
          }
          finish();
          AppMethodBeat.o(99379);
          return;
          if (Rzo.booleanValue() == com.tencent.mm.ui.aw.isDarkMode()) {
            break;
          }
          Log.i("MicroMsg.SnsTimeLineUI", "dancy test UIMode change!!");
          Rzo = Boolean.valueOf(com.tencent.mm.ui.aw.isDarkMode());
          com.tencent.mm.plugin.sns.ui.widget.i.resetConfig();
          break;
          if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
          {
            bool = true;
            ((ax)localObject1).Qxy = bool;
            ((ax)localObject1).Qxz = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zon, 3600);
            ((ax)localObject1).QxB = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zoo, 5);
            ((ax)localObject1).QxC = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zoq, 10);
            ((ax)localObject1).QxA = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zor, 86400L);
            ((ax)localObject1).QxD = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zos, 0);
            ((ax)localObject1).QxF = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zou, 1);
            ((ax)localObject1).QxE = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zot, 2);
            ((ax)localObject1).QxG = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zov, 14400);
            break label172;
          }
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zop, 1) == 1)
          {
            bool = true;
            continue;
          }
          bool = false;
          continue;
          if (((ax)localObject1).QxU.QxZ >= 0L) {
            continue;
          }
          ((ax)localObject1).QxU.QxZ = 0L;
          continue;
        }
      }
      if (com.tencent.mm.ui.statusbar.c.afCQ) {
        break label3926;
      }
    }
    label1598:
    getWindow().getDecorView().setSystemUiVisibility(1280);
    paramBundle = MMApplicationContext.getDefaultPreference();
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("Main_need_read_top_margin", false);; bool = false) {
      for (;;)
      {
        com.tencent.mm.ui.c.h(this, bool);
        this.Rzb = ((int)(getResources().getDisplayMetrics().heightPixels * 0.4D));
        setActionbarColor(getContext().getResources().getColor(b.c.transparent));
        hideActionbarLine();
        setNavigationbarColor(getContext().getResources().getColor(b.c.BG_2));
        this.RAj = getIntent().getIntExtra("sns_adapter_type", 0);
        this.RyZ = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
        this.mActionBar = getSupportActionBar();
        i = com.tencent.mm.model.newabtest.d.bEu().bva("Sns_Private_Recent_Setting_Guide");
        Log.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = ".concat(String.valueOf(i)));
        if (i == 1)
        {
          com.tencent.mm.kernel.h.baF();
          if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPS, false))
          {
            paramBundle = getIntent();
            paramBundle.setClass(getContext(), SnsSettingIntroduceUI.class);
            paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aYi(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramBundle.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            overridePendingTransition(0, 0);
            finish();
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acPS, Boolean.TRUE);
          }
        }
        com.tencent.mm.plugin.sns.ad.timeline.b.b.a.hca();
        this.Rzr.RuA = new bi.b()
        {
          public final void hpb()
          {
            AppMethodBeat.i(308161);
            SnsTimeLineUI.J(SnsTimeLineUI.this);
            AppMethodBeat.o(308161);
          }
        };
        hpE();
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(308324);
            Log.i("MicroMsg.SnsTimeLineUI", "%s", new Object[] { com.tencent.mm.plugin.performance.watchdogs.d.gzs().af(true, 0) });
            AppMethodBeat.o(308324);
          }
        });
        this.RyS.a(c.b.class, this.RAh);
        localObject1 = this.RyT;
        i = this.RAj;
        this.RAf.getType();
        paramBundle = getIntent();
        com.tencent.mm.plugin.sns.o.b localb = this.RyR;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RAj = i;
        ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).hasInit = true;
        Object localObject3;
        if (i == 0)
        {
          localObject3 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHc;
          ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject3).RyR = localb;
          if (localb != null)
          {
            paramBundle = localb.htb();
            label2028:
            ((com.tencent.mm.plugin.sns.ui.a.a.b)localObject3).RyS = paramBundle;
            ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHc.RyS.a(this);
            label2046:
            paramBundle = this.RyT;
            if (paramBundle.RAj != 0) {
              break label4146;
            }
            paramBundle = (com.tencent.mm.plugin.sns.o.c.a)paramBundle.RHc.RyS.v(com.tencent.mm.plugin.sns.o.c.a.class);
            label2075:
            this.sWX = paramBundle.sWX;
            this.Rzk = paramBundle.Rzk;
            this.Rzl = paramBundle.Rzl;
            this.RdS = paramBundle.RdS;
            this.Rzm = paramBundle.Rzm;
            localObject1 = paramBundle.qgV;
            paramBundle = paramBundle.mSignature;
            this.mSessionId = com.tencent.mm.ui.f.bjC("123");
            this.Rzn = String.valueOf(System.currentTimeMillis());
            this.mUIAction = new SnsUIAction(this);
            this.mUIAction.RCY = false;
            this.mUIAction.setSessionId(this.mSessionId);
            this.mUIAction.QEN = this.Rzn;
            this.mUIAction.RCL = this.RAf;
            this.mUIAction.actionbarView = this.mActionBar.getCustomView();
            ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().qh(2);
            com.tencent.mm.plugin.sns.ui.widget.i.hsX().RXd = 0;
            com.tencent.mm.plugin.sns.ui.widget.f.hsU().RXd = 0;
            localObject3 = m.oUt;
            m.bMI();
            if (!getIntent().getBooleanExtra("is_sns_notify_open", true)) {
              break label4154;
            }
            i = 1;
            label2271:
            this.Rza = new i(this, i, Util.nullAs(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0), this.Rzn);
            this.Rza.Rbz = new i.b()
            {
              public final void hlI()
              {
                AppMethodBeat.i(308331);
                com.tencent.mm.plugin.report.service.h.OAn.kJ(1295, 2);
                Object localObject1 = al.hgN();
                Object localObject2;
                int i;
                if (((ax)localObject1).Qxy)
                {
                  localObject2 = ((ax)localObject1).QxV;
                  long l = ((ax)localObject1).Qya;
                  String str = ((ax)localObject1).sessionId;
                  i = ((ax)localObject1).QxI;
                  com.tencent.mm.plugin.sns.k.k localk = ((ax)localObject1).QxU;
                  al.gHI().post(new ax.5((ax)localObject1, (com.tencent.mm.plugin.sns.k.l)localObject2, localk, l, str, i));
                }
                j.QFS.QGC.jpD = 1L;
                localObject1 = al.hgN();
                if ((!ax.a(((ax)localObject1).QxV)) || (((ax)localObject1).QxJ.get(((ax)localObject1).QxV.Adz.peek()) == null))
                {
                  i = -1;
                  localObject1 = al.hgN();
                  if (ax.a(((ax)localObject1).QxV)) {
                    break label440;
                  }
                }
                label440:
                for (int j = 0;; j = ((ax)localObject1).QxV.Adz.size())
                {
                  Log.d("MicroMsg.SnsTimeLineUI", "rightIndex:%s, targetSize:%s, adapter.count:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount()) });
                  al.hgN().ju(null);
                  SnsTimeLineUI.K(SnsTimeLineUI.this).setVisibility(4);
                  if ((i == -1) || (j + i >= SnsTimeLineUI.a(SnsTimeLineUI.this).getCount())) {
                    break label455;
                  }
                  al.hgN().hhw();
                  al.hgN().QxP = 0L;
                  j = SnsTimeLineUI.this.getResources().getDimensionPixelSize(b.d.sns_timeline_top_margin);
                  int k = bf.fs(SnsTimeLineUI.this.getContext());
                  int m = bf.getStatusBarHeight(SnsTimeLineUI.this.getContext());
                  localObject1 = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                  localObject2 = com.tencent.mm.hellhoundlib.b.c.a(i + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), com.tencent.mm.hellhoundlib.b.c.a(k + m - j, new com.tencent.mm.hellhoundlib.b.a()));
                  com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                  ((ListView)localObject1).smoothScrollToPositionFromTop(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue(), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(1)).intValue());
                  com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPositionFromTop", "(II)V");
                  AppMethodBeat.o(308331);
                  return;
                  i = ((Integer)((ax)localObject1).QxJ.get(((ax)localObject1).QxV.Adz.peek())).intValue();
                  break;
                }
                label455:
                if (!al.hgN().QxS)
                {
                  al.hgN().hhw();
                  al.hgN().QxS = true;
                  SnsTimeLineUI.a(SnsTimeLineUI.this).RGD.baR(com.tencent.mm.plugin.sns.data.t.uB(SnsTimeLineUI.a(SnsTimeLineUI.this).hqJ()));
                  SnsTimeLineUI.a(SnsTimeLineUI.this).RGD.baS(com.tencent.mm.plugin.sns.data.t.uB(SnsTimeLineUI.a(SnsTimeLineUI.this).Et(false)));
                  al.hgN().QxP = al.hgN().hhu();
                  al.hgr().uU(al.hgN().hhu());
                  al.hgN().QxQ = com.tencent.mm.plugin.sns.model.ay.Qyz;
                  localObject1 = SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView();
                  localObject2 = com.tencent.mm.hellhoundlib.b.c.a(SnsTimeLineUI.a(SnsTimeLineUI.this).getCount() - 1 + SnsTimeLineUI.d(SnsTimeLineUI.this).getSnsListView().getHeaderViewsCount(), new com.tencent.mm.hellhoundlib.b.a());
                  com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                  ((ListView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
                  com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$38", "onUnreadTipClick", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                  if (SnsTimeLineUI.k(SnsTimeLineUI.this) != null)
                  {
                    SnsTimeLineUI.B(SnsTimeLineUI.this).removeCallbacks(SnsTimeLineUI.C(SnsTimeLineUI.this));
                    SnsTimeLineUI.B(SnsTimeLineUI.this).post(SnsTimeLineUI.C(SnsTimeLineUI.this));
                  }
                }
                AppMethodBeat.o(308331);
              }
            };
            this.RbF = getIntent().getBooleanExtra("sns_resume_state", true);
            if (!al.isInValid()) {
              break label4159;
            }
            this.RbF = false;
            label2356:
            this.RyY = this.RbF;
            this.mUIAction.a(this.Rzk, this.sWX, (String)localObject1, paramBundle, this.Rzl, this.RdS, this.Rzm);
            this.mUIAction.onCreate(true);
            al.hgs().init();
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(213, this);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(682, this);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(218, this);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(211, this);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(683, this);
            com.tencent.mm.plugin.sns.ui.video.e.hsu().hsv();
            initView();
            paramBundle = al.hgs();
            localObject1 = this.mUIAction.list;
            localObject3 = this.RyU.RGC;
            paramBundle.QBI = ((ListView)localObject1);
            paramBundle.QBJ = ((bn)localObject3);
            paramBundle = al.hgs();
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(291, paramBundle);
            if (!al.isInValid()) {
              break label4179;
            }
            this.RbF = false;
            label2569:
            paramBundle = this.RyS;
            paramBundle.RGD = this.RyU.RGD;
            localObject1 = paramBundle.RGD;
            paramBundle.agtB.keep((com.tencent.mm.vending.e.a)localObject1);
            if ((!this.RbF) || (this.RAj != 0)) {
              break label4199;
            }
            this.RyZ = false;
            int j = al.hgM().position;
            this.RyU.RGD.baT(al.hgM().zPH);
            this.RyU.RGD.baQ(al.hgM().RiY);
            this.RyU.RGD.Eu(true);
            this.RyU.RGD.baU(al.hgM().Rjb);
            this.RyU.RGD.baR(al.hgM().RiZ);
            this.RyU.RGD.baS(al.hgM().Rja);
            this.mUIAction.Eq(al.hgM().Rjd);
            this.RyU.Td();
            i = j;
            if (j >= this.RyU.getCount())
            {
              i = this.RyU.getCount() - 1;
              Log.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[] { Integer.valueOf(this.RyU.getCount()) });
            }
            this.mUIAction.list.setAdapter(this.RyU);
            Log.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[] { Integer.valueOf(al.hgM().Rjc) });
            this.mUIAction.list.setSelectionFromTop(i, al.hgM().Rjc);
            ami(4);
            label2847:
            El(true);
            i = this.RyU.getCount();
            j = this.mUIAction.list.getFirstVisiblePosition();
            if (j < i) {
              this.Rzg = com.tencent.mm.plugin.sns.data.t.x(this.RyU.alF(j));
            }
            com.tencent.mm.kernel.h.baF();
            this.Rze = ((Integer)com.tencent.mm.kernel.h.baE().ban().d(327776, Integer.valueOf(0))).intValue();
            this.Rza.RbH = new bw(this, this.RyU.RGC, this.Rza.QBg);
            this.Rza.RbJ = new com.tencent.mm.plugin.sns.i.b(this, this.RyU.RGC.QBf, this.Rza.QBg);
            this.Rza.RbI = new b(this, this.RyU.RGC.QBf, this.Rza.QBg, this.Rza.RbJ);
            this.Rza.RbI.PYh = this.RoZ;
            this.Rza.RbK = new as(this, this.RyU.RGC.QBf, this.Rza.QBg);
            this.Rza.RbL = new by(this, this.RyU.RGC.QBf, this.Rza.QBg);
            if (this.Rzj != null) {
              this.Rzj.a(this.Rza.RbJ);
            }
            if (i > 0)
            {
              paramBundle = this.RyU.alF(0);
              if ((this.Rza.Rbw != null) && (this.Rza.Rbw.Qwn != null)) {
                this.Rza.Rbw.Qwn.QDx = paramBundle.field_snsId;
              }
              paramBundle = j.QFS;
              if (paramBundle.mxT != 0)
              {
                if (paramBundle.QFT.isEmpty())
                {
                  paramBundle.lsW.setLong(2, Util.nowSecond());
                  paramBundle.QFU.clear();
                }
                Log.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[] { Integer.valueOf(paramBundle.QFT.size()) });
              }
            }
            com.tencent.mm.plugin.report.service.h.OAn.kvStat(13312, "1," + Util.nowMilliSecond());
            this.RzE.alive();
            if (getIntent().getBooleanExtra("is_need_resend_sns", false))
            {
              MMHandlerThread.postToMainThreadDelayed(new SnsTimeLineUI.38(this), 500L);
              getIntent().putExtra("is_need_resend_sns", false);
            }
            com.tencent.mm.kernel.h.baF();
            if (com.tencent.mm.kernel.h.baC().aZN())
            {
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baE().ban().B(589825, Boolean.FALSE);
            }
            this.Rza.b(this.RoZ);
            this.RoZ.a(this.mUIAction.CCP, this.mActionBar.getCustomView(), this);
            this.RzK.alive();
            this.RzL.alive();
            this.RzM.alive();
            this.RzN.alive();
            this.RzO.alive();
            this.RzQ.alive();
            this.RzP.alive();
            this.QyL.alive();
            this.RzR.alive();
            this.RzS.alive();
            this.RzU.alive();
            this.RzT.alive();
            this.RzV.alive();
            this.RzX.alive();
            com.tencent.mm.plugin.sns.abtest.c.gZw();
            com.tencent.mm.plugin.sns.abtest.a.d(this, this.Rza.QBg);
            if (this.Rzh != null)
            {
              paramBundle = this.Rzh;
              localObject1 = this.mUIAction.list;
              localObject3 = this.mUIAction.QCY;
              paramBundle.nlI = ((ListView)localObject1);
              paramBundle.QCY = ((SnsHeader)localObject3);
            }
            if ((this.Rza != null) && (this.Rza.Rbw != null))
            {
              paramBundle = this.Rza.Rbw.Qwn;
              Log.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
              paramBundle.QDw = true;
              paramBundle.QFz = System.currentTimeMillis();
            }
            bool = getIntent().getBooleanExtra("enter_by_red", false);
            if ((this.Rza != null) && (this.Rza.Rbw != null))
            {
              paramBundle = this.Rza.Rbw.Qwn;
              if (!bool) {
                break label4228;
              }
              i = 1;
              label3629:
              paramBundle.QDJ = i;
            }
            al.hgy().Qrf.clear();
            if ((this.mUIAction != null) && (this.mUIAction.QCY != null)) {
              this.mUIAction.QCY.setStoryAction(new SnsStoryHeaderView.a()
              {
                public final void hpV()
                {
                  AppMethodBeat.i(308261);
                  SnsTimeLineUI.a locala = SnsTimeLineUI.l(SnsTimeLineUI.this);
                  if (SnsTimeLineUI.u(locala.RAo).getVisibility() == 0)
                  {
                    locala.init();
                    SnsTimeLineUI.u(locala.RAo).clearAnimation();
                    SnsTimeLineUI.u(locala.RAo).startAnimation(locala);
                    locala.vt(locala.MvO + 100);
                    locala.RAV = false;
                  }
                  AppMethodBeat.o(308261);
                }
              });
            }
            ((ae)com.tencent.mm.kernel.h.ax(ae.class)).Sh(3);
            if (!Util.isNullOrNil(com.tencent.mm.model.z.bAW())) {
              break label4233;
            }
            this.Rzy = 0;
            label3707:
            if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED)) {
              break label4266;
            }
            paramBundle = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zmY, "{\"enable\":2,\"max_count_no_user\":0,\"max_count_no_feed\":0,\"max_count_normal\":0}");
            if (Util.isNullOrNil(paramBundle)) {}
          }
        }
        try
        {
          paramBundle = new JSONObject(paramBundle);
          Rzu = paramBundle.getInt("enable");
          this.Rzv = paramBundle.getInt("max_count_no_user");
          this.Rzw = paramBundle.getInt("max_count_no_feed");
          this.Rzx = paramBundle.getInt("max_count_normal");
          if (com.tencent.mm.platformtools.z.pDu > 0)
          {
            Rzu = com.tencent.mm.platformtools.z.pDu;
            if (com.tencent.mm.platformtools.z.pDu == 1)
            {
              this.Rzv = -1;
              this.Rzw = -1;
              this.Rzx = -1;
            }
          }
          Log.i("MicroMsg.SnsTimeLineUI", "curFinderStatus:%s, finderEntranceEnable:%s, finderEntranceMaxCountNoUser:%s, finderEntranceMaxCountNoFeed:%s, finderEntranceMaxCountNormal:%s", new Object[] { Integer.valueOf(this.Rzy), Integer.valueOf(Rzu), Integer.valueOf(this.Rzv), Integer.valueOf(this.Rzw), Integer.valueOf(this.Rzx) });
          aj.hfY();
          this.RzF.alive();
          paramBundle = com.tencent.mm.plugin.sns.j.a.QCu;
          com.tencent.mm.plugin.sns.j.a.a.jQ(this);
          AppMethodBeat.o(99379);
          return;
          label3926:
          paramBundle = com.tencent.mm.ui.statusbar.c.ch(this);
          localObject1 = new com.tencent.mm.ui.statusbar.c.a()
          {
            public final void onStatusBarHeightChange(int paramAnonymousInt)
            {
              AppMethodBeat.i(308218);
              SnsTimeLineUI.t(SnsTimeLineUI.this).setPadding(0, paramAnonymousInt, 0, 0);
              AppMethodBeat.o(308218);
            }
          };
          this.Inw = ((com.tencent.mm.ui.statusbar.c.a)localObject1);
          paramBundle.a((com.tencent.mm.ui.statusbar.c.a)localObject1);
          getWindow().getDecorView().requestApplyInsets();
          com.tencent.mm.ui.statusbar.d.g(getWindow());
          break;
          paramBundle = null;
          break label2028;
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHd = new com.tencent.mm.plugin.sns.o.c.a();
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHd.sWX = paramBundle.getStringExtra("sns_userName");
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHd.Rzk = com.tencent.mm.model.z.bAM();
          localObject3 = ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHd;
          com.tencent.mm.kernel.h.baF();
          ((com.tencent.mm.plugin.sns.o.c.a)localObject3).Rzl = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxr(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHd.sWX);
          localObject3 = com.tencent.mm.model.z.bAM();
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHd.RdS = ((String)localObject3).equals(((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHd.sWX);
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHd.Rzm = paramBundle.getIntExtra("sns_source", 0);
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHd.qgV = Util.nullAs(paramBundle.getStringExtra("sns_nickName"), "");
          ((com.tencent.mm.plugin.sns.ui.a.a.c)localObject1).RHd.mSignature = Util.nullAs(paramBundle.getStringExtra("sns_signature"), "");
          break label2046;
          label4146:
          paramBundle = paramBundle.RHd;
          break label2075;
          label4154:
          i = 0;
          break label2271;
          label4159:
          if (!this.RbF) {
            break label2356;
          }
          this.RbF = al.hgM().hnh();
          break label2356;
          label4179:
          if (!this.RbF) {
            break label2569;
          }
          this.RbF = al.hgM().hnh();
          break label2569;
          label4199:
          this.mUIAction.list.setAdapter(this.RyU);
          ami(0);
          this.RyU.Td();
          break label2847;
          label4228:
          i = 0;
          break label3629;
          label4233:
          if (!((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).hasFinderPosted())
          {
            this.Rzy = 1;
            break label3707;
          }
          this.Rzy = 2;
          break label3707;
          label4266:
          paramBundle = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zmY, "");
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
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: ldc_w 3949
    //   3: invokestatic 292	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 3411
    //   9: invokestatic 3417	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   12: ldc_w 3419
    //   15: iconst_0
    //   16: invokevirtual 3422	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Z)Z
    //   19: pop
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 359	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rzf	Z
    //   25: aload_0
    //   26: getfield 398	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rzr	Lcom/tencent/mm/plugin/sns/ui/bi;
    //   29: astore 11
    //   31: aload 11
    //   33: invokevirtual 3952	com/tencent/mm/plugin/sns/ui/bi:hpa	()V
    //   36: aload 11
    //   38: aconst_null
    //   39: putfield 3528	com/tencent/mm/plugin/sns/ui/bi:RuA	Lcom/tencent/mm/plugin/sns/ui/bi$b;
    //   42: aload 11
    //   44: getstatic 3957	com/tencent/mm/plugin/sns/ui/bi$a:RuD	I
    //   47: putfield 3960	com/tencent/mm/plugin/sns/ui/bi:PhY	I
    //   50: invokestatic 1694	com/tencent/mm/plugin/sns/ui/video/e:hsu	()Lcom/tencent/mm/plugin/sns/ui/video/e;
    //   53: aload_0
    //   54: invokevirtual 3963	com/tencent/mm/plugin/sns/ui/video/e:bx	(Landroid/app/Activity;)V
    //   57: invokestatic 1773	com/tencent/mm/plugin/sns/ui/video/b:hsi	()Lcom/tencent/mm/plugin/sns/ui/video/b;
    //   60: astore 11
    //   62: ldc_w 3965
    //   65: ldc_w 3967
    //   68: invokestatic 792	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload 11
    //   73: getfield 3971	com/tencent/mm/plugin/sns/ui/video/b:RUx	Ljava/util/Set;
    //   76: invokeinterface 3977 1 0
    //   81: astore 12
    //   83: aload 12
    //   85: invokeinterface 3982 1 0
    //   90: ifeq +21 -> 111
    //   93: aload 12
    //   95: invokeinterface 3985 1 0
    //   100: checkcast 1717	com/tencent/mm/plugin/sns/ui/video/a
    //   103: invokeinterface 3988 1 0
    //   108: goto -25 -> 83
    //   111: aload 11
    //   113: getfield 3971	com/tencent/mm/plugin/sns/ui/video/b:RUx	Ljava/util/Set;
    //   116: invokeinterface 3989 1 0
    //   121: ldc_w 785
    //   124: ldc_w 3991
    //   127: invokestatic 792	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 451	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzK	Lcom/tencent/mm/sdk/event/IListener;
    //   134: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   137: aload_0
    //   138: getfield 454	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzL	Lcom/tencent/mm/sdk/event/IListener;
    //   141: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   144: aload_0
    //   145: getfield 457	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzM	Lcom/tencent/mm/sdk/event/IListener;
    //   148: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   151: aload_0
    //   152: getfield 460	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzN	Lcom/tencent/mm/sdk/event/IListener;
    //   155: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   158: aload_0
    //   159: getfield 463	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzO	Lcom/tencent/mm/sdk/event/IListener;
    //   162: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   165: aload_0
    //   166: getfield 469	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzQ	Lcom/tencent/mm/sdk/event/IListener;
    //   169: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   172: aload_0
    //   173: getfield 466	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzP	Lcom/tencent/mm/sdk/event/IListener;
    //   176: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   179: aload_0
    //   180: getfield 472	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:QyL	Lcom/tencent/mm/sdk/event/IListener;
    //   183: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   186: aload_0
    //   187: getfield 475	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzR	Lcom/tencent/mm/sdk/event/IListener;
    //   190: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   193: aload_0
    //   194: getfield 478	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzS	Lcom/tencent/mm/sdk/event/IListener;
    //   197: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   200: aload_0
    //   201: getfield 481	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzT	Lcom/tencent/mm/sdk/event/IListener;
    //   204: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   207: aload_0
    //   208: getfield 484	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzU	Lcom/tencent/mm/sdk/event/IListener;
    //   211: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   214: aload_0
    //   215: getfield 487	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzV	Lcom/tencent/mm/sdk/event/IListener;
    //   218: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   221: aload_0
    //   222: getfield 433	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzF	Lcom/tencent/mm/sdk/event/IListener;
    //   225: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   228: aload_0
    //   229: getfield 495	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzX	Lcom/tencent/mm/sdk/event/IListener;
    //   232: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   235: invokestatic 3999	com/tencent/mm/plugin/sns/ui/e/a:hsg	()V
    //   238: aload_0
    //   239: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   242: ifnull +40 -> 282
    //   245: aload_0
    //   246: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   249: getfield 946	com/tencent/mm/plugin/sns/ui/i:Rbw	Lcom/tencent/mm/plugin/sns/model/bd;
    //   252: ifnull +30 -> 282
    //   255: aload_0
    //   256: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   259: getfield 946	com/tencent/mm/plugin/sns/ui/i:Rbw	Lcom/tencent/mm/plugin/sns/model/bd;
    //   262: getfield 952	com/tencent/mm/plugin/sns/model/bd:Qwn	Lcom/tencent/mm/plugin/sns/statistics/e;
    //   265: astore 11
    //   267: aload_0
    //   268: getfield 438	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzH	Z
    //   271: ifeq +282 -> 553
    //   274: iconst_1
    //   275: istore_1
    //   276: aload 11
    //   278: iload_1
    //   279: putfield 4002	com/tencent/mm/plugin/sns/statistics/e:QDK	I
    //   282: getstatic 737	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   285: astore 12
    //   287: aload 12
    //   289: getfield 3756	com/tencent/mm/plugin/sns/statistics/j:mxT	I
    //   292: ifeq +453 -> 745
    //   295: ldc_w 3781
    //   298: ldc_w 4004
    //   301: iconst_2
    //   302: anewarray 1331	java/lang/Object
    //   305: dup
    //   306: iconst_0
    //   307: aload 12
    //   309: getfield 3760	com/tencent/mm/plugin/sns/statistics/j:QFT	Ljava/util/HashMap;
    //   312: invokevirtual 3784	java/util/HashMap:size	()I
    //   315: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: aload 12
    //   323: getfield 3776	com/tencent/mm/plugin/sns/statistics/j:QFU	Ljava/util/HashMap;
    //   326: invokevirtual 3784	java/util/HashMap:size	()I
    //   329: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   332: aastore
    //   333: invokestatic 1334	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: aload 12
    //   338: getfield 3767	com/tencent/mm/plugin/sns/statistics/j:lsW	Lcom/tencent/mm/storage/ap;
    //   341: iconst_2
    //   342: invokevirtual 4008	com/tencent/mm/storage/ap:amW	(I)J
    //   345: lstore 6
    //   347: aload 12
    //   349: getfield 3760	com/tencent/mm/plugin/sns/statistics/j:QFT	Ljava/util/HashMap;
    //   352: invokevirtual 3763	java/util/HashMap:isEmpty	()Z
    //   355: ifne +1365 -> 1720
    //   358: aload 12
    //   360: getfield 3760	com/tencent/mm/plugin/sns/statistics/j:QFT	Ljava/util/HashMap;
    //   363: invokevirtual 3784	java/util/HashMap:size	()I
    //   366: aload 12
    //   368: getfield 4011	com/tencent/mm/plugin/sns/statistics/j:QGb	I
    //   371: if_icmpgt +18 -> 389
    //   374: lload 6
    //   376: invokestatic 4014	com/tencent/mm/sdk/platformtools/Util:secondsToNow	(J)J
    //   379: aload 12
    //   381: getfield 4017	com/tencent/mm/plugin/sns/statistics/j:QGc	I
    //   384: i2l
    //   385: lcmp
    //   386: ifle +1334 -> 1720
    //   389: new 1670	java/lang/StringBuffer
    //   392: dup
    //   393: invokespecial 4018	java/lang/StringBuffer:<init>	()V
    //   396: astore 13
    //   398: aload 12
    //   400: getfield 3760	com/tencent/mm/plugin/sns/statistics/j:QFT	Ljava/util/HashMap;
    //   403: invokevirtual 4022	java/util/HashMap:keySet	()Ljava/util/Set;
    //   406: invokeinterface 3977 1 0
    //   411: astore 14
    //   413: iconst_0
    //   414: istore_1
    //   415: iconst_0
    //   416: istore_2
    //   417: aload 14
    //   419: invokeinterface 3982 1 0
    //   424: ifeq +147 -> 571
    //   427: aload 14
    //   429: invokeinterface 3985 1 0
    //   434: checkcast 832	java/lang/String
    //   437: astore 15
    //   439: aload 12
    //   441: getfield 3776	com/tencent/mm/plugin/sns/statistics/j:QFU	Ljava/util/HashMap;
    //   444: aload 15
    //   446: invokevirtual 4025	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   449: checkcast 832	java/lang/String
    //   452: astore 11
    //   454: aload 11
    //   456: invokestatic 1675	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   459: ifne +99 -> 558
    //   462: iconst_1
    //   463: istore_2
    //   464: aload 12
    //   466: getfield 4029	com/tencent/mm/plugin/sns/statistics/j:QFV	Ljava/util/HashSet;
    //   469: aload 15
    //   471: invokevirtual 4033	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   474: ifeq +92 -> 566
    //   477: iconst_1
    //   478: istore_3
    //   479: aload 13
    //   481: new 739	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 740	java/lang/StringBuilder:<init>	()V
    //   488: aload 15
    //   490: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc_w 4035
    //   496: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload 12
    //   501: getfield 3760	com/tencent/mm/plugin/sns/statistics/j:QFT	Ljava/util/HashMap;
    //   504: aload 15
    //   506: invokevirtual 4025	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   509: invokevirtual 4038	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   512: ldc_w 4035
    //   515: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload 11
    //   520: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: ldc_w 4035
    //   526: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: iload_3
    //   530: invokevirtual 1216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: ldc_w 4040
    //   536: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 763	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokevirtual 1680	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   545: pop
    //   546: iload_1
    //   547: iconst_1
    //   548: iadd
    //   549: istore_1
    //   550: goto -133 -> 417
    //   553: iconst_0
    //   554: istore_1
    //   555: goto -279 -> 276
    //   558: ldc_w 361
    //   561: astore 11
    //   563: goto -99 -> 464
    //   566: iconst_0
    //   567: istore_3
    //   568: goto -89 -> 479
    //   571: aload 13
    //   573: new 739	java/lang/StringBuilder
    //   576: dup
    //   577: ldc_w 2930
    //   580: invokespecial 1213	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   583: lload 6
    //   585: invokevirtual 760	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   588: ldc_w 2930
    //   591: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokestatic 1956	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   597: invokevirtual 760	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   600: ldc_w 4042
    //   603: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: iload_2
    //   607: invokevirtual 1216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: ldc_w 2930
    //   613: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: iload_1
    //   617: invokevirtual 1216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   620: ldc_w 4044
    //   623: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 763	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokevirtual 1680	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   632: pop
    //   633: ldc_w 3781
    //   636: ldc_w 4046
    //   639: iconst_2
    //   640: anewarray 1331	java/lang/Object
    //   643: dup
    //   644: iconst_0
    //   645: sipush 13226
    //   648: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   651: aastore
    //   652: dup
    //   653: iconst_1
    //   654: aload 13
    //   656: aastore
    //   657: invokestatic 2906	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   660: getstatic 1310	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   663: sipush 13226
    //   666: aload 13
    //   668: invokevirtual 4047	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   671: invokevirtual 1314	com/tencent/mm/plugin/report/service/h:kvStat	(ILjava/lang/String;)V
    //   674: aload 12
    //   676: getfield 3767	com/tencent/mm/plugin/sns/statistics/j:lsW	Lcom/tencent/mm/storage/ap;
    //   679: iconst_3
    //   680: aconst_null
    //   681: invokevirtual 4048	com/tencent/mm/storage/ap:B	(ILjava/lang/Object;)V
    //   684: aload 12
    //   686: getfield 3767	com/tencent/mm/plugin/sns/statistics/j:lsW	Lcom/tencent/mm/storage/ap;
    //   689: iconst_4
    //   690: aconst_null
    //   691: invokevirtual 4048	com/tencent/mm/storage/ap:B	(ILjava/lang/Object;)V
    //   694: aload 12
    //   696: getfield 3767	com/tencent/mm/plugin/sns/statistics/j:lsW	Lcom/tencent/mm/storage/ap;
    //   699: iconst_5
    //   700: aconst_null
    //   701: invokevirtual 4048	com/tencent/mm/storage/ap:B	(ILjava/lang/Object;)V
    //   704: aload 12
    //   706: getfield 3760	com/tencent/mm/plugin/sns/statistics/j:QFT	Ljava/util/HashMap;
    //   709: invokevirtual 3779	java/util/HashMap:clear	()V
    //   712: aload 12
    //   714: getfield 3776	com/tencent/mm/plugin/sns/statistics/j:QFU	Ljava/util/HashMap;
    //   717: invokevirtual 3779	java/util/HashMap:clear	()V
    //   720: aload 12
    //   722: getfield 4029	com/tencent/mm/plugin/sns/statistics/j:QFV	Ljava/util/HashSet;
    //   725: invokevirtual 4049	java/util/HashSet:clear	()V
    //   728: aload 12
    //   730: getfield 3767	com/tencent/mm/plugin/sns/statistics/j:lsW	Lcom/tencent/mm/storage/ap;
    //   733: iconst_2
    //   734: invokestatic 1956	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   737: invokevirtual 3773	com/tencent/mm/storage/ap:setLong	(IJ)V
    //   740: aload 12
    //   742: invokevirtual 4052	com/tencent/mm/plugin/sns/statistics/j:hil	()V
    //   745: invokestatic 808	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   748: pop
    //   749: invokestatic 812	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   752: invokevirtual 818	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   755: ldc_w 4053
    //   758: aconst_null
    //   759: invokevirtual 2266	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   762: checkcast 832	java/lang/String
    //   765: astore 11
    //   767: aload_0
    //   768: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   771: ifnull +150 -> 921
    //   774: aload_0
    //   775: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   778: getfield 946	com/tencent/mm/plugin/sns/ui/i:Rbw	Lcom/tencent/mm/plugin/sns/model/bd;
    //   781: ifnull +140 -> 921
    //   784: aload_0
    //   785: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   788: getfield 946	com/tencent/mm/plugin/sns/ui/i:Rbw	Lcom/tencent/mm/plugin/sns/model/bd;
    //   791: getfield 952	com/tencent/mm/plugin/sns/model/bd:Qwn	Lcom/tencent/mm/plugin/sns/statistics/e;
    //   794: astore 12
    //   796: getstatic 737	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   799: getfield 4056	com/tencent/mm/plugin/sns/statistics/j:QGa	I
    //   802: istore_1
    //   803: ldc_w 3822
    //   806: ldc_w 4058
    //   809: invokestatic 792	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   812: invokestatic 757	java/lang/System:currentTimeMillis	()J
    //   815: aload 12
    //   817: getfield 3830	com/tencent/mm/plugin/sns/statistics/e:QFz	J
    //   820: lsub
    //   821: lstore 6
    //   823: aload 12
    //   825: aload 12
    //   827: getfield 4061	com/tencent/mm/plugin/sns/statistics/e:QDy	J
    //   830: lload 6
    //   832: ladd
    //   833: putfield 4061	com/tencent/mm/plugin/sns/statistics/e:QDy	J
    //   836: ldc_w 3822
    //   839: new 739	java/lang/StringBuilder
    //   842: dup
    //   843: ldc_w 4063
    //   846: invokespecial 1213	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   849: lload 6
    //   851: invokevirtual 760	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   854: ldc_w 4065
    //   857: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload 12
    //   862: getfield 4061	com/tencent/mm/plugin/sns/statistics/e:QDy	J
    //   865: invokevirtual 760	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   868: ldc_w 4067
    //   871: invokevirtual 749	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: aload 12
    //   876: getfield 4070	com/tencent/mm/plugin/sns/statistics/e:QEh	J
    //   879: invokevirtual 760	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   882: invokevirtual 763	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: invokestatic 792	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   888: invokestatic 4074	com/tencent/mm/plugin/sns/model/al:hgo	()Ljava/util/concurrent/ExecutorService;
    //   891: astore 13
    //   893: aload 13
    //   895: ifnull +20 -> 915
    //   898: aload 13
    //   900: new 4076	com/tencent/mm/plugin/sns/statistics/e$1
    //   903: dup
    //   904: aload 12
    //   906: iload_1
    //   907: invokespecial 4079	com/tencent/mm/plugin/sns/statistics/e$1:<init>	(Lcom/tencent/mm/plugin/sns/statistics/e;I)V
    //   910: invokeinterface 4084 2 0
    //   915: aload 12
    //   917: iconst_0
    //   918: putfield 3827	com/tencent/mm/plugin/sns/statistics/e:QDw	Z
    //   921: sipush 704
    //   924: invokestatic 963	com/tencent/mm/modelsns/l:wO	(I)Lcom/tencent/mm/modelsns/l;
    //   927: astore 12
    //   929: aload 12
    //   931: invokevirtual 1664	com/tencent/mm/modelsns/l:bMD	()Z
    //   934: ifeq +97 -> 1031
    //   937: aload 12
    //   939: aload_0
    //   940: getfield 438	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzH	Z
    //   943: invokevirtual 4088	com/tencent/mm/modelsns/l:hm	(Z)Lcom/tencent/mm/modelsns/l;
    //   946: pop
    //   947: aload 11
    //   949: invokestatic 1675	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   952: ifne +813 -> 1765
    //   955: iconst_1
    //   956: istore 10
    //   958: aload 12
    //   960: iload 10
    //   962: invokevirtual 4088	com/tencent/mm/modelsns/l:hm	(Z)Lcom/tencent/mm/modelsns/l;
    //   965: pop
    //   966: aload 12
    //   968: aload_0
    //   969: getfield 363	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rzg	Ljava/lang/String;
    //   972: invokevirtual 1685	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   975: pop
    //   976: aload 12
    //   978: getstatic 737	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   981: getfield 4091	com/tencent/mm/plugin/sns/statistics/j:QFZ	Ljava/lang/String;
    //   984: invokevirtual 1685	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   987: pop
    //   988: aload 12
    //   990: getstatic 737	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   993: getfield 4091	com/tencent/mm/plugin/sns/statistics/j:QFZ	Ljava/lang/String;
    //   996: invokevirtual 1685	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   999: pop
    //   1000: aload 12
    //   1002: aload_0
    //   1003: getfield 577	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mUIAction	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;
    //   1006: getfield 4094	com/tencent/mm/plugin/sns/ui/SnsUIAction:RCK	I
    //   1009: invokevirtual 4097	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   1012: pop
    //   1013: aload 12
    //   1015: ldc_w 361
    //   1018: invokevirtual 1685	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   1021: pop
    //   1022: invokestatic 4100	com/tencent/mm/modelsns/l:bMG	()V
    //   1025: aload 12
    //   1027: invokevirtual 1686	com/tencent/mm/modelsns/l:bMH	()Z
    //   1030: pop
    //   1031: getstatic 737	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   1034: iconst_m1
    //   1035: putfield 4056	com/tencent/mm/plugin/sns/statistics/j:QGa	I
    //   1038: getstatic 737	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   1041: ldc_w 4102
    //   1044: putfield 4091	com/tencent/mm/plugin/sns/statistics/j:QFZ	Ljava/lang/String;
    //   1047: aload_0
    //   1048: getfield 577	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mUIAction	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;
    //   1051: invokevirtual 2658	com/tencent/mm/plugin/sns/ui/SnsUIAction:getSnsListView	()Landroid/widget/ListView;
    //   1054: checkcast 2660	com/tencent/mm/plugin/sns/ui/AdListView
    //   1057: astore 11
    //   1059: aload_0
    //   1060: getfield 384	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rzj	Lcom/tencent/mm/plugin/sns/model/bc;
    //   1063: getfield 4106	com/tencent/mm/plugin/sns/model/bc:QyR	Ljava/util/List;
    //   1066: invokeinterface 4107 1 0
    //   1071: invokestatic 2676	com/tencent/mm/plugin/sns/model/al:hgs	()Lcom/tencent/mm/plugin/sns/i/c;
    //   1074: invokevirtual 4110	com/tencent/mm/plugin/sns/i/c:clean	()V
    //   1077: invokestatic 4114	com/tencent/mm/plugin/sns/model/al:hgv	()Lcom/tencent/mm/plugin/sns/ad/g/n;
    //   1080: astore 12
    //   1082: invokestatic 4074	com/tencent/mm/plugin/sns/model/al:hgo	()Ljava/util/concurrent/ExecutorService;
    //   1085: new 4116	com/tencent/mm/plugin/sns/ad/g/n$5
    //   1088: dup
    //   1089: aload 12
    //   1091: invokespecial 4119	com/tencent/mm/plugin/sns/ad/g/n$5:<init>	(Lcom/tencent/mm/plugin/sns/ad/g/n;)V
    //   1094: invokeinterface 4084 2 0
    //   1099: aload 11
    //   1101: getfield 2664	com/tencent/mm/plugin/sns/ui/AdListView:QZR	Lcom/tencent/mm/plugin/sns/ad/g/e;
    //   1104: invokeinterface 4122 1 0
    //   1109: aload 11
    //   1111: aconst_null
    //   1112: putfield 2664	com/tencent/mm/plugin/sns/ui/AdListView:QZR	Lcom/tencent/mm/plugin/sns/ad/g/e;
    //   1115: aload 11
    //   1117: getfield 4126	com/tencent/mm/plugin/sns/ui/AdListView:QZS	Lcom/tencent/mm/plugin/sns/model/f;
    //   1120: invokeinterface 4131 1 0
    //   1125: aload 11
    //   1127: aconst_null
    //   1128: putfield 4126	com/tencent/mm/plugin/sns/ui/AdListView:QZS	Lcom/tencent/mm/plugin/sns/model/f;
    //   1131: invokestatic 4136	com/tencent/mm/plugin/sns/model/v:hfO	()V
    //   1134: invokestatic 3642	com/tencent/mm/plugin/sns/model/al:isInValid	()Z
    //   1137: ifne +14 -> 1151
    //   1140: aload_0
    //   1141: getfield 526	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RAd	Landroid/os/Handler;
    //   1144: aload_0
    //   1145: getfield 419	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzD	Ljava/lang/Runnable;
    //   1148: invokevirtual 1420	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1151: invokestatic 808	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1154: pop
    //   1155: invokestatic 3363	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   1158: invokevirtual 3368	com/tencent/mm/kernel/b:aZN	()Z
    //   1161: ifeq +130 -> 1291
    //   1164: invokestatic 808	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1167: pop
    //   1168: invokestatic 3195	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   1171: getfield 3201	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   1174: sipush 213
    //   1177: aload_0
    //   1178: invokevirtual 4138	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   1181: invokestatic 808	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1184: pop
    //   1185: invokestatic 3195	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   1188: getfield 3201	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   1191: sipush 682
    //   1194: aload_0
    //   1195: invokevirtual 4138	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   1198: invokestatic 808	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1201: pop
    //   1202: invokestatic 3195	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   1205: getfield 3201	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   1208: sipush 218
    //   1211: aload_0
    //   1212: invokevirtual 4138	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   1215: invokestatic 808	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1218: pop
    //   1219: invokestatic 3195	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   1222: getfield 3201	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   1225: sipush 211
    //   1228: aload_0
    //   1229: invokevirtual 4138	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   1232: invokestatic 808	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1235: pop
    //   1236: invokestatic 3195	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   1239: getfield 3201	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   1242: sipush 683
    //   1245: aload_0
    //   1246: invokevirtual 4138	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   1249: invokestatic 808	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1252: pop
    //   1253: invokestatic 812	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   1256: invokevirtual 818	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   1259: ldc_w 3727
    //   1262: aload_0
    //   1263: getfield 357	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rze	I
    //   1266: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1269: invokevirtual 2291	com/tencent/mm/storage/aq:B	(ILjava/lang/Object;)V
    //   1272: invokestatic 808	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1275: pop
    //   1276: invokestatic 812	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   1279: invokevirtual 818	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   1282: ldc_w 3799
    //   1285: getstatic 322	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1288: invokevirtual 2291	com/tencent/mm/storage/aq:B	(ILjava/lang/Object;)V
    //   1291: aload_0
    //   1292: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   1295: ifnull +10 -> 1305
    //   1298: aload_0
    //   1299: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   1302: invokevirtual 4139	com/tencent/mm/plugin/sns/ui/i:clean	()V
    //   1305: invokestatic 1374	com/tencent/mm/plugin/sns/model/al:fAG	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   1308: aload_0
    //   1309: getfield 529	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RAe	Ljava/lang/Runnable;
    //   1312: invokevirtual 1379	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1315: invokestatic 3094	com/tencent/mm/plugin/sns/model/al:hgN	()Lcom/tencent/mm/plugin/sns/model/ax;
    //   1318: astore 11
    //   1320: aload 11
    //   1322: getfield 4143	com/tencent/mm/plugin/sns/model/ax:Qyb	Lcom/tencent/mm/plugin/sns/k/l;
    //   1325: ifnull +8 -> 1333
    //   1328: aload 11
    //   1330: invokevirtual 4146	com/tencent/mm/plugin/sns/model/ax:hhx	()V
    //   1333: aload 11
    //   1335: getfield 3099	com/tencent/mm/plugin/sns/model/ax:Qxy	Z
    //   1338: ifeq +40 -> 1378
    //   1341: aload 11
    //   1343: getfield 3147	com/tencent/mm/plugin/sns/model/ax:QxU	Lcom/tencent/mm/plugin/sns/k/k;
    //   1346: aload 11
    //   1348: getfield 3159	com/tencent/mm/plugin/sns/model/ax:QxZ	J
    //   1351: putfield 3158	com/tencent/mm/plugin/sns/k/k:QxZ	J
    //   1354: aload 11
    //   1356: getfield 3147	com/tencent/mm/plugin/sns/model/ax:QxU	Lcom/tencent/mm/plugin/sns/k/k;
    //   1359: invokevirtual 4150	com/tencent/mm/plugin/sns/k/k:toByteArray	()[B
    //   1362: astore 12
    //   1364: aload 11
    //   1366: getfield 3137	com/tencent/mm/plugin/sns/model/ax:Qxx	Ljava/lang/String;
    //   1369: aload 12
    //   1371: aload 12
    //   1373: arraylength
    //   1374: invokestatic 4153	com/tencent/mm/vfs/y:f	(Ljava/lang/String;[BI)I
    //   1377: pop
    //   1378: aload 11
    //   1380: getfield 3147	com/tencent/mm/plugin/sns/model/ax:QxU	Lcom/tencent/mm/plugin/sns/k/k;
    //   1383: getfield 4156	com/tencent/mm/plugin/sns/k/k:QCM	Ljava/util/LinkedList;
    //   1386: invokevirtual 4157	java/util/LinkedList:clear	()V
    //   1389: aload 11
    //   1391: aconst_null
    //   1392: putfield 4160	com/tencent/mm/plugin/sns/model/ax:QxV	Lcom/tencent/mm/plugin/sns/k/l;
    //   1395: aload 11
    //   1397: aconst_null
    //   1398: putfield 4163	com/tencent/mm/plugin/sns/model/ax:QxW	Lcom/tencent/mm/plugin/sns/k/l;
    //   1401: aload 11
    //   1403: lconst_0
    //   1404: putfield 4166	com/tencent/mm/plugin/sns/model/ax:QxX	J
    //   1407: aload 11
    //   1409: lconst_0
    //   1410: putfield 4169	com/tencent/mm/plugin/sns/model/ax:QxP	J
    //   1413: aload 11
    //   1415: getfield 4173	com/tencent/mm/plugin/sns/model/ax:QxJ	Ljava/util/Map;
    //   1418: invokeinterface 4176 1 0
    //   1423: aload 11
    //   1425: aconst_null
    //   1426: putfield 4179	com/tencent/mm/plugin/sns/model/ax:QxK	Landroid/view/View;
    //   1429: aload 11
    //   1431: lconst_0
    //   1432: putfield 4182	com/tencent/mm/plugin/sns/model/ax:QxO	J
    //   1435: aload 11
    //   1437: lconst_0
    //   1438: putfield 3173	com/tencent/mm/plugin/sns/model/ax:QxL	J
    //   1441: aload 11
    //   1443: iconst_0
    //   1444: putfield 4185	com/tencent/mm/plugin/sns/model/ax:QxR	Z
    //   1447: aload 11
    //   1449: aconst_null
    //   1450: putfield 4143	com/tencent/mm/plugin/sns/model/ax:Qyb	Lcom/tencent/mm/plugin/sns/k/l;
    //   1453: aload 11
    //   1455: aconst_null
    //   1456: putfield 4188	com/tencent/mm/plugin/sns/model/ax:Qyc	Lcom/tencent/mm/plugin/sns/k/l;
    //   1459: aload 11
    //   1461: getstatic 4193	com/tencent/mm/plugin/sns/model/ay:QyB	I
    //   1464: putfield 4196	com/tencent/mm/plugin/sns/model/ax:QxQ	I
    //   1467: aload 11
    //   1469: iconst_0
    //   1470: putfield 4199	com/tencent/mm/plugin/sns/model/ax:Qyd	I
    //   1473: aload 11
    //   1475: lconst_0
    //   1476: putfield 4202	com/tencent/mm/plugin/sns/model/ax:Qya	J
    //   1479: aload 11
    //   1481: lconst_0
    //   1482: putfield 3159	com/tencent/mm/plugin/sns/model/ax:QxZ	J
    //   1485: aload 11
    //   1487: lconst_0
    //   1488: putfield 4205	com/tencent/mm/plugin/sns/model/ax:Qye	J
    //   1491: aload 11
    //   1493: getfield 4208	com/tencent/mm/plugin/sns/model/ax:QxM	Ljava/util/List;
    //   1496: astore 12
    //   1498: aload 12
    //   1500: monitorenter
    //   1501: aload 11
    //   1503: getfield 4208	com/tencent/mm/plugin/sns/model/ax:QxM	Ljava/util/List;
    //   1506: invokeinterface 4107 1 0
    //   1511: aload 12
    //   1513: monitorexit
    //   1514: aload 11
    //   1516: getfield 3191	com/tencent/mm/plugin/sns/model/ax:Qyf	Lcom/tencent/mm/plugin/sns/model/aw;
    //   1519: astore 11
    //   1521: aload 11
    //   1523: getfield 4211	com/tencent/mm/plugin/sns/model/aw:Qxu	Ljava/util/List;
    //   1526: invokeinterface 4107 1 0
    //   1531: aload 11
    //   1533: aconst_null
    //   1534: putfield 4214	com/tencent/mm/plugin/sns/model/aw:Qxv	Lcom/tencent/mm/plugin/sns/k/l;
    //   1537: invokestatic 3195	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   1540: getfield 3201	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   1543: sipush 211
    //   1546: aload 11
    //   1548: invokevirtual 4138	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   1551: invokestatic 3222	com/tencent/mm/plugin/sns/model/al:hgO	()Lcom/tencent/mm/plugin/sns/model/au;
    //   1554: astore 11
    //   1556: getstatic 3227	com/tencent/mm/plugin/sns/model/au:TAG	Ljava/lang/String;
    //   1559: ldc_w 4216
    //   1562: invokestatic 792	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1565: aload 11
    //   1567: getfield 3261	com/tencent/mm/plugin/sns/model/au:Qxk	Ljava/lang/Runnable;
    //   1570: invokestatic 4219	com/tencent/mm/sdk/platformtools/MMHandlerThread:removeRunnable	(Ljava/lang/Runnable;)V
    //   1573: aload_0
    //   1574: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   1577: ifnull +627 -> 2204
    //   1580: aload_0
    //   1581: getfield 577	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mUIAction	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;
    //   1584: getfield 583	com/tencent/mm/plugin/sns/ui/SnsUIAction:list	Landroid/widget/ListView;
    //   1587: invokevirtual 1206	android/widget/ListView:getFirstVisiblePosition	()I
    //   1590: istore 4
    //   1592: iconst_0
    //   1593: istore_1
    //   1594: iconst_0
    //   1595: istore_2
    //   1596: iload_2
    //   1597: aload_0
    //   1598: getfield 577	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mUIAction	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;
    //   1601: getfield 583	com/tencent/mm/plugin/sns/ui/SnsUIAction:list	Landroid/widget/ListView;
    //   1604: invokevirtual 4220	android/widget/ListView:getCount	()I
    //   1607: if_icmpge +204 -> 1811
    //   1610: aload_0
    //   1611: getfield 577	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mUIAction	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;
    //   1614: getfield 583	com/tencent/mm/plugin/sns/ui/SnsUIAction:list	Landroid/widget/ListView;
    //   1617: iload_2
    //   1618: invokevirtual 1222	android/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   1621: astore 11
    //   1623: iload_1
    //   1624: istore_3
    //   1625: aload 11
    //   1627: ifnull +84 -> 1711
    //   1630: aload_0
    //   1631: getfield 577	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mUIAction	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;
    //   1634: getfield 583	com/tencent/mm/plugin/sns/ui/SnsUIAction:list	Landroid/widget/ListView;
    //   1637: aload 11
    //   1639: invokevirtual 4224	android/widget/ListView:getPositionForView	(Landroid/view/View;)I
    //   1642: istore 5
    //   1644: iload_1
    //   1645: istore_3
    //   1646: iload 5
    //   1648: iload 4
    //   1650: if_icmpne +61 -> 1711
    //   1653: iconst_2
    //   1654: newarray int
    //   1656: astore 12
    //   1658: aload 11
    //   1660: aload 12
    //   1662: invokevirtual 4227	android/view/View:getLocationInWindow	([I)V
    //   1665: ldc_w 785
    //   1668: ldc_w 4229
    //   1671: iconst_3
    //   1672: anewarray 1331	java/lang/Object
    //   1675: dup
    //   1676: iconst_0
    //   1677: iload 5
    //   1679: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1682: aastore
    //   1683: dup
    //   1684: iconst_1
    //   1685: aload 12
    //   1687: iconst_0
    //   1688: iaload
    //   1689: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1692: aastore
    //   1693: dup
    //   1694: iconst_2
    //   1695: aload 12
    //   1697: iconst_1
    //   1698: iaload
    //   1699: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1702: aastore
    //   1703: invokestatic 1650	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1706: aload 12
    //   1708: iconst_1
    //   1709: iaload
    //   1710: istore_3
    //   1711: iload_2
    //   1712: iconst_1
    //   1713: iadd
    //   1714: istore_2
    //   1715: iload_3
    //   1716: istore_1
    //   1717: goto -121 -> 1596
    //   1720: aload 12
    //   1722: getfield 3767	com/tencent/mm/plugin/sns/statistics/j:lsW	Lcom/tencent/mm/storage/ap;
    //   1725: iconst_3
    //   1726: aload 12
    //   1728: getfield 3760	com/tencent/mm/plugin/sns/statistics/j:QFT	Ljava/util/HashMap;
    //   1731: invokevirtual 4048	com/tencent/mm/storage/ap:B	(ILjava/lang/Object;)V
    //   1734: aload 12
    //   1736: getfield 3767	com/tencent/mm/plugin/sns/statistics/j:lsW	Lcom/tencent/mm/storage/ap;
    //   1739: iconst_4
    //   1740: aload 12
    //   1742: getfield 3776	com/tencent/mm/plugin/sns/statistics/j:QFU	Ljava/util/HashMap;
    //   1745: invokevirtual 4048	com/tencent/mm/storage/ap:B	(ILjava/lang/Object;)V
    //   1748: aload 12
    //   1750: getfield 3767	com/tencent/mm/plugin/sns/statistics/j:lsW	Lcom/tencent/mm/storage/ap;
    //   1753: iconst_5
    //   1754: aload 12
    //   1756: getfield 4029	com/tencent/mm/plugin/sns/statistics/j:QFV	Ljava/util/HashSet;
    //   1759: invokevirtual 4048	com/tencent/mm/storage/ap:B	(ILjava/lang/Object;)V
    //   1762: goto -1022 -> 740
    //   1765: iconst_0
    //   1766: istore 10
    //   1768: goto -810 -> 958
    //   1771: astore 12
    //   1773: ldc_w 3127
    //   1776: ldc_w 4231
    //   1779: iconst_1
    //   1780: anewarray 1331	java/lang/Object
    //   1783: dup
    //   1784: iconst_0
    //   1785: aload 12
    //   1787: invokevirtual 3405	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1790: aastore
    //   1791: invokestatic 3407	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1794: goto -416 -> 1378
    //   1797: astore 11
    //   1799: aload 12
    //   1801: monitorexit
    //   1802: ldc_w 3949
    //   1805: invokestatic 298	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1808: aload 11
    //   1810: athrow
    //   1811: aload_0
    //   1812: invokevirtual 1744	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:getResources	()Landroid/content/res/Resources;
    //   1815: getstatic 4236	com/tencent/mm/plugin/sns/b$d:sns_timeline_top_margin	I
    //   1818: invokevirtual 4239	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   1821: istore_2
    //   1822: invokestatic 3642	com/tencent/mm/plugin/sns/model/al:isInValid	()Z
    //   1825: ifne +295 -> 2120
    //   1828: aload_0
    //   1829: getfield 342	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyS	Lcom/tencent/mm/plugin/sns/o/a;
    //   1832: invokevirtual 4243	com/tencent/mm/plugin/sns/o/a:hgr	()Lcom/tencent/mm/plugin/sns/model/ar$a;
    //   1835: ifnull +285 -> 2120
    //   1838: aload_0
    //   1839: getfield 554	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RAj	I
    //   1842: ifne +278 -> 2120
    //   1845: invokestatic 2649	com/tencent/mm/plugin/sns/model/al:hgM	()Lcom/tencent/mm/plugin/sns/ui/av;
    //   1848: astore 11
    //   1850: aload_0
    //   1851: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   1854: getfield 2733	com/tencent/mm/plugin/sns/ui/a/c:RGD	Lcom/tencent/mm/plugin/sns/ui/a/b/b;
    //   1857: invokevirtual 4246	com/tencent/mm/plugin/sns/ui/a/b/b:hqM	()Ljava/lang/String;
    //   1860: astore 12
    //   1862: aload_0
    //   1863: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   1866: getfield 2733	com/tencent/mm/plugin/sns/ui/a/c:RGD	Lcom/tencent/mm/plugin/sns/ui/a/b/b;
    //   1869: invokevirtual 4249	com/tencent/mm/plugin/sns/ui/a/b/b:hqO	()Ljava/lang/String;
    //   1872: astore 13
    //   1874: aload_0
    //   1875: getfield 342	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyS	Lcom/tencent/mm/plugin/sns/o/a;
    //   1878: invokevirtual 4243	com/tencent/mm/plugin/sns/o/a:hgr	()Lcom/tencent/mm/plugin/sns/model/ar$a;
    //   1881: getfield 4254	com/tencent/mm/plugin/sns/model/ar$a:QwG	J
    //   1884: lstore 6
    //   1886: aload_0
    //   1887: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   1890: getfield 2733	com/tencent/mm/plugin/sns/ui/a/c:RGD	Lcom/tencent/mm/plugin/sns/ui/a/b/b;
    //   1893: invokevirtual 4257	com/tencent/mm/plugin/sns/ui/a/b/b:hqK	()Ljava/lang/String;
    //   1896: astore 14
    //   1898: aload_0
    //   1899: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   1902: getfield 2733	com/tencent/mm/plugin/sns/ui/a/c:RGD	Lcom/tencent/mm/plugin/sns/ui/a/b/b;
    //   1905: invokevirtual 4260	com/tencent/mm/plugin/sns/ui/a/b/b:hqL	()Ljava/lang/String;
    //   1908: astore 15
    //   1910: aload_0
    //   1911: getfield 342	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyS	Lcom/tencent/mm/plugin/sns/o/a;
    //   1914: invokevirtual 4243	com/tencent/mm/plugin/sns/o/a:hgr	()Lcom/tencent/mm/plugin/sns/model/ar$a;
    //   1917: getfield 4263	com/tencent/mm/plugin/sns/model/ar$a:QwH	J
    //   1920: lstore 8
    //   1922: aload_0
    //   1923: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   1926: getfield 2733	com/tencent/mm/plugin/sns/ui/a/c:RGD	Lcom/tencent/mm/plugin/sns/ui/a/b/b;
    //   1929: invokevirtual 4266	com/tencent/mm/plugin/sns/ui/a/b/b:hqN	()Ljava/lang/String;
    //   1932: astore 16
    //   1934: aload_0
    //   1935: getfield 577	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mUIAction	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;
    //   1938: getfield 1400	com/tencent/mm/plugin/sns/ui/SnsUIAction:Rjd	Z
    //   1941: istore 10
    //   1943: aload 11
    //   1945: invokestatic 4269	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   1948: putfield 4272	com/tencent/mm/plugin/sns/ui/av:RiX	J
    //   1951: aload 11
    //   1953: aload 12
    //   1955: putfield 3675	com/tencent/mm/plugin/sns/ui/av:zPH	Ljava/lang/String;
    //   1958: aload 11
    //   1960: aload 13
    //   1962: putfield 3681	com/tencent/mm/plugin/sns/ui/av:RiY	Ljava/lang/String;
    //   1965: aload 11
    //   1967: lload 6
    //   1969: putfield 4273	com/tencent/mm/plugin/sns/ui/av:QwG	J
    //   1972: aload 11
    //   1974: iload 4
    //   1976: putfield 2654	com/tencent/mm/plugin/sns/ui/av:position	I
    //   1979: aload 11
    //   1981: iload_1
    //   1982: iload_2
    //   1983: isub
    //   1984: putfield 3722	com/tencent/mm/plugin/sns/ui/av:Rjc	I
    //   1987: aload 11
    //   1989: aload 16
    //   1991: putfield 3690	com/tencent/mm/plugin/sns/ui/av:Rjb	Ljava/lang/String;
    //   1994: aload 11
    //   1996: aload 14
    //   1998: putfield 3696	com/tencent/mm/plugin/sns/ui/av:RiZ	Ljava/lang/String;
    //   2001: aload 11
    //   2003: aload 15
    //   2005: putfield 3702	com/tencent/mm/plugin/sns/ui/av:Rja	Ljava/lang/String;
    //   2008: aload 11
    //   2010: lload 8
    //   2012: putfield 4274	com/tencent/mm/plugin/sns/ui/av:QwH	J
    //   2015: aload 11
    //   2017: iload 10
    //   2019: putfield 3706	com/tencent/mm/plugin/sns/ui/av:Rjd	Z
    //   2022: ldc_w 4276
    //   2025: ldc_w 4278
    //   2028: bipush 11
    //   2030: anewarray 1331	java/lang/Object
    //   2033: dup
    //   2034: iconst_0
    //   2035: aload 11
    //   2037: getfield 4272	com/tencent/mm/plugin/sns/ui/av:RiX	J
    //   2040: invokestatic 1584	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2043: aastore
    //   2044: dup
    //   2045: iconst_1
    //   2046: aload 12
    //   2048: aastore
    //   2049: dup
    //   2050: iconst_2
    //   2051: aload 13
    //   2053: aastore
    //   2054: dup
    //   2055: iconst_3
    //   2056: lload 6
    //   2058: invokestatic 1584	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2061: aastore
    //   2062: dup
    //   2063: iconst_4
    //   2064: iload 4
    //   2066: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2069: aastore
    //   2070: dup
    //   2071: iconst_5
    //   2072: aload 11
    //   2074: getfield 3722	com/tencent/mm/plugin/sns/ui/av:Rjc	I
    //   2077: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2080: aastore
    //   2081: dup
    //   2082: bipush 6
    //   2084: aload 14
    //   2086: aastore
    //   2087: dup
    //   2088: bipush 7
    //   2090: aload 15
    //   2092: aastore
    //   2093: dup
    //   2094: bipush 8
    //   2096: lload 8
    //   2098: invokestatic 1584	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2101: aastore
    //   2102: dup
    //   2103: bipush 9
    //   2105: aload 16
    //   2107: aastore
    //   2108: dup
    //   2109: bipush 10
    //   2111: iload 10
    //   2113: invokestatic 677	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2116: aastore
    //   2117: invokestatic 1334	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2120: ldc_w 785
    //   2123: ldc_w 4280
    //   2126: iconst_1
    //   2127: anewarray 1331	java/lang/Object
    //   2130: dup
    //   2131: iconst_0
    //   2132: iload_1
    //   2133: iload_2
    //   2134: isub
    //   2135: invokestatic 1058	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2138: aastore
    //   2139: invokestatic 1650	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2142: invokestatic 3642	com/tencent/mm/plugin/sns/model/al:isInValid	()Z
    //   2145: ifeq +425 -> 2570
    //   2148: ldc_w 4282
    //   2151: ldc_w 4284
    //   2154: invokestatic 1320	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2157: aload_0
    //   2158: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   2161: getfield 2729	com/tencent/mm/plugin/sns/ui/a/c:RGC	Lcom/tencent/mm/plugin/sns/ui/bn;
    //   2164: astore 11
    //   2166: aload 11
    //   2168: getfield 4288	com/tencent/mm/plugin/sns/ui/bn:RoO	Lcom/tencent/mm/plugin/sns/ui/j;
    //   2171: ifnull +12 -> 2183
    //   2174: aload 11
    //   2176: getfield 4288	com/tencent/mm/plugin/sns/ui/bn:RoO	Lcom/tencent/mm/plugin/sns/ui/j;
    //   2179: aconst_null
    //   2180: putfield 4294	com/tencent/mm/plugin/sns/ui/j:activity	Landroid/app/Activity;
    //   2183: aload_0
    //   2184: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   2187: getfield 2729	com/tencent/mm/plugin/sns/ui/a/c:RGC	Lcom/tencent/mm/plugin/sns/ui/bn;
    //   2190: invokevirtual 4297	com/tencent/mm/plugin/sns/ui/bn:hpA	()V
    //   2193: aload_0
    //   2194: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   2197: getfield 2729	com/tencent/mm/plugin/sns/ui/a/c:RGC	Lcom/tencent/mm/plugin/sns/ui/bn;
    //   2200: invokevirtual 4300	com/tencent/mm/plugin/sns/ui/bn:hpw	()Z
    //   2203: pop
    //   2204: invokestatic 4303	com/tencent/mm/plugin/sns/ui/bp:clean	()V
    //   2207: aload_0
    //   2208: getfield 430	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzE	Lcom/tencent/mm/sdk/event/IListener;
    //   2211: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   2214: invokestatic 808	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   2217: pop
    //   2218: invokestatic 3363	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   2221: invokevirtual 3368	com/tencent/mm/kernel/b:aZN	()Z
    //   2224: ifeq +12 -> 2236
    //   2227: invokestatic 3839	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
    //   2230: getfield 3844	com/tencent/mm/plugin/sns/model/g:Qrf	Ljava/util/HashMap;
    //   2233: invokevirtual 3779	java/util/HashMap:clear	()V
    //   2236: aload_0
    //   2237: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   2240: getfield 2733	com/tencent/mm/plugin/sns/ui/a/c:RGD	Lcom/tencent/mm/plugin/sns/ui/a/b/b;
    //   2243: aload_0
    //   2244: getfield 436	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzG	Lcom/tencent/mm/vending/base/Vending$d;
    //   2247: invokevirtual 4307	com/tencent/mm/plugin/sns/ui/a/b/b:removeVendingDataChangedCallback	(Lcom/tencent/mm/vending/base/Vending$d;)V
    //   2250: aload_0
    //   2251: aconst_null
    //   2252: putfield 436	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzG	Lcom/tencent/mm/vending/base/Vending$d;
    //   2255: getstatic 737	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   2258: aload_0
    //   2259: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   2262: invokevirtual 1657	com/tencent/mm/plugin/sns/ui/a/c:getCount	()I
    //   2265: invokevirtual 4310	com/tencent/mm/plugin/sns/statistics/j:akZ	(I)V
    //   2268: aload_0
    //   2269: aconst_null
    //   2270: putfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   2273: aload_0
    //   2274: aconst_null
    //   2275: putfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   2278: invokestatic 4313	com/tencent/mm/plugin/sns/ui/a/c:hqI	()V
    //   2281: invokestatic 4316	com/tencent/mm/plugin/sns/abtest/c:gZx	()V
    //   2284: invokestatic 2676	com/tencent/mm/plugin/sns/model/al:hgs	()Lcom/tencent/mm/plugin/sns/i/c;
    //   2287: astore 11
    //   2289: invokestatic 808	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   2292: pop
    //   2293: invokestatic 3195	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   2296: getfield 3201	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   2299: sipush 291
    //   2302: aload 11
    //   2304: invokevirtual 4138	com/tencent/mm/am/s:b	(ILcom/tencent/mm/am/h;)V
    //   2307: invokestatic 4317	com/tencent/mm/plugin/sns/abtest/a:clean	()V
    //   2310: aload_0
    //   2311: getfield 577	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mUIAction	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;
    //   2314: invokevirtual 4319	com/tencent/mm/plugin/sns/ui/SnsUIAction:onDestroy	()V
    //   2317: aload_0
    //   2318: invokespecial 4320	com/tencent/mm/plugin/secdata/ui/WxPresenterSecDataActivity:onDestroy	()V
    //   2321: getstatic 3029	com/tencent/mm/kiss/widget/textview/c:mGx	Lcom/tencent/mm/kiss/widget/textview/c;
    //   2324: invokevirtual 3032	com/tencent/mm/kiss/widget/textview/c:bbI	()V
    //   2327: aload_0
    //   2328: getfield 347	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyT	Lcom/tencent/mm/plugin/sns/ui/a/a/c;
    //   2331: astore 11
    //   2333: aload 11
    //   2335: aconst_null
    //   2336: putfield 3920	com/tencent/mm/plugin/sns/ui/a/a/c:RHd	Lcom/tencent/mm/plugin/sns/o/c$a;
    //   2339: aload 11
    //   2341: iconst_0
    //   2342: putfield 3542	com/tencent/mm/plugin/sns/ui/a/a/c:hasInit	Z
    //   2345: getstatic 4326	com/tencent/mm/plugin/sns/ad/g/o:PWQ	Lcom/tencent/mm/plugin/sns/ad/g/o;
    //   2348: astore 11
    //   2350: aload 11
    //   2352: getfield 4330	com/tencent/mm/plugin/sns/ad/g/o:PWO	Lcom/tencent/mm/memory/a/a/a/g;
    //   2355: invokevirtual 4333	com/tencent/mm/memory/a/a/a/g:clear	()V
    //   2358: ldc_w 4335
    //   2361: ldc_w 4337
    //   2364: iconst_1
    //   2365: anewarray 1331	java/lang/Object
    //   2368: dup
    //   2369: iconst_0
    //   2370: invokestatic 1577	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   2373: aastore
    //   2374: invokestatic 1334	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2377: aload 11
    //   2379: getfield 4341	com/tencent/mm/plugin/sns/ad/g/o:PWP	Lcom/tencent/mm/sdk/platformtools/LruCache;
    //   2382: invokevirtual 4346	com/tencent/mm/sdk/platformtools/LruCache:evictAll	()V
    //   2385: invokestatic 4350	com/tencent/mm/plugin/sns/model/al:hgw	()Lcom/tencent/mm/plugin/sns/model/c;
    //   2388: astore 11
    //   2390: aload 11
    //   2392: getfield 4356	com/tencent/mm/plugin/sns/model/c:QqR	Ljava/util/concurrent/ConcurrentHashMap;
    //   2395: invokevirtual 4359	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   2398: ifne +11 -> 2409
    //   2401: aload 11
    //   2403: getfield 4356	com/tencent/mm/plugin/sns/model/c:QqR	Ljava/util/concurrent/ConcurrentHashMap;
    //   2406: invokevirtual 4360	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   2409: invokestatic 4350	com/tencent/mm/plugin/sns/model/al:hgw	()Lcom/tencent/mm/plugin/sns/model/c;
    //   2412: astore 11
    //   2414: aload 11
    //   2416: getfield 4364	com/tencent/mm/plugin/sns/model/c:QqS	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   2419: invokevirtual 4367	java/util/concurrent/CopyOnWriteArrayList:isEmpty	()Z
    //   2422: ifne +11 -> 2433
    //   2425: aload 11
    //   2427: getfield 4364	com/tencent/mm/plugin/sns/model/c:QqS	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   2430: invokevirtual 4368	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   2433: invokestatic 3094	com/tencent/mm/plugin/sns/model/al:hgN	()Lcom/tencent/mm/plugin/sns/model/ax;
    //   2436: iconst_0
    //   2437: putfield 4371	com/tencent/mm/plugin/sns/model/ax:QxS	Z
    //   2440: getstatic 737	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   2443: astore 11
    //   2445: aload 11
    //   2447: getfield 4374	com/tencent/mm/plugin/sns/statistics/j:QGf	Ljava/util/Map;
    //   2450: invokeinterface 4176 1 0
    //   2455: aload 11
    //   2457: getfield 4377	com/tencent/mm/plugin/sns/statistics/j:QGg	Ljava/util/Map;
    //   2460: invokeinterface 4176 1 0
    //   2465: getstatic 737	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   2468: getfield 3277	com/tencent/mm/plugin/sns/statistics/j:QGD	Lcom/tencent/mm/autogen/mmdata/rpt/py;
    //   2471: getfield 4380	com/tencent/mm/autogen/mmdata/rpt/py:jpS	J
    //   2474: lconst_0
    //   2475: lcmp
    //   2476: ifle +38 -> 2514
    //   2479: getstatic 737	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   2482: astore 11
    //   2484: aload 11
    //   2486: getfield 3277	com/tencent/mm/plugin/sns/statistics/j:QGD	Lcom/tencent/mm/autogen/mmdata/rpt/py;
    //   2489: lconst_1
    //   2490: putfield 4383	com/tencent/mm/autogen/mmdata/rpt/py:ioV	J
    //   2493: aload 11
    //   2495: getfield 3277	com/tencent/mm/plugin/sns/statistics/j:QGD	Lcom/tencent/mm/autogen/mmdata/rpt/py;
    //   2498: invokevirtual 4384	com/tencent/mm/autogen/mmdata/rpt/py:bMH	()Z
    //   2501: pop
    //   2502: aload 11
    //   2504: new 3282	com/tencent/mm/autogen/mmdata/rpt/py
    //   2507: dup
    //   2508: invokespecial 4385	com/tencent/mm/autogen/mmdata/rpt/py:<init>	()V
    //   2511: putfield 3277	com/tencent/mm/plugin/sns/statistics/j:QGD	Lcom/tencent/mm/autogen/mmdata/rpt/py;
    //   2514: getstatic 4391	com/tencent/mm/plugin/sns/storage/i:QYv	Lcom/tencent/mm/plugin/sns/storage/i;
    //   2517: astore 11
    //   2519: invokestatic 4394	com/tencent/mm/plugin/sns/storage/i:getHandler	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   2522: getstatic 4397	com/tencent/mm/plugin/sns/storage/i:QYw	I
    //   2525: invokevirtual 4400	com/tencent/mm/sdk/platformtools/MMHandler:removeMessages	(I)V
    //   2528: ldc_w 4402
    //   2531: invokestatic 1067	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   2534: checkcast 4402	com/tencent/d/a/a/a/b
    //   2537: iconst_3
    //   2538: invokeinterface 4405 2 0
    //   2543: getstatic 709	com/tencent/mm/plugin/comm/b/e:xfd	Lcom/tencent/mm/plugin/comm/b/e$a;
    //   2546: astore 11
    //   2548: getstatic 4411	com/tencent/mm/plugin/comm/b/b:xeQ	Lcom/tencent/mm/plugin/comm/b/b;
    //   2551: invokevirtual 4414	com/tencent/mm/plugin/comm/b/b:name	()Ljava/lang/String;
    //   2554: ldc_w 4416
    //   2557: invokevirtual 4419	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   2560: invokestatic 4422	com/tencent/mm/plugin/comm/b/e$a:gw	(Ljava/lang/String;Ljava/lang/String;)V
    //   2563: ldc_w 3949
    //   2566: invokestatic 298	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2569: return
    //   2570: invokestatic 3839	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
    //   2573: pop
    //   2574: goto -417 -> 2157
    //   2577: astore 11
    //   2579: goto -194 -> 2385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2582	0	this	SnsTimeLineUI
    //   275	1860	1	i	int
    //   416	1719	2	j	int
    //   478	1238	3	k	int
    //   1590	475	4	m	int
    //   1642	36	5	n	int
    //   345	1712	6	l1	long
    //   1920	177	8	l2	long
    //   956	1156	10	bool	boolean
    //   29	1630	11	localObject1	Object
    //   1797	12	11	localObject2	Object
    //   1848	699	11	localObject3	Object
    //   2577	1	11	localObject4	Object
    //   81	1674	12	localObject5	Object
    //   1771	29	12	localException	Exception
    //   1860	187	12	str1	String
    //   396	1656	13	localObject6	Object
    //   411	1674	14	localObject7	Object
    //   437	1654	15	str2	String
    //   1932	174	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   1341	1378	1771	java/lang/Exception
    //   1501	1514	1797	finally
    //   2377	2385	2577	finally
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
        AppMethodBeat.i(307839);
        SnsTimeLineUI.this.hmb();
        AppMethodBeat.o(307839);
      }
    });
    if (keyboardState() == 2)
    {
      if ((this.Rza != null) && (this.Rza.RbA != null) && (!this.Rza.RbA.hox()))
      {
        Log.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
        AppMethodBeat.o(99389);
      }
    }
    else if ((keyboardState() == 1) && (this.Rza != null)) {
      this.Rza.hlD();
    }
    AppMethodBeat.o(99389);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(308273);
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
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderTimelineUI(getContext(), localIntent);
      finish();
    }
    AppMethodBeat.o(308273);
  }
  
  /* Error */
  public void onPause()
  {
    // Byte code:
    //   0: ldc_w 4471
    //   3: invokestatic 292	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aconst_null
    //   8: invokestatic 4477	com/tencent/mm/sdk/platformtools/ScreenShotUtil:setScreenShotCallback	(Landroid/content/Context;Lcom/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotCallback;)V
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 404	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rlo	Z
    //   16: aload_0
    //   17: getfield 2002	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyX	Lcom/tencent/mm/ui/widget/QFadeImageView;
    //   20: invokevirtual 4480	com/tencent/mm/ui/widget/QFadeImageView:clearAnimation	()V
    //   23: getstatic 4485	com/tencent/mm/hardcoder/WXHardCoderJNI:hcSNSScrollEnable	Z
    //   26: aload_0
    //   27: getfield 683	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:lyw	I
    //   30: invokestatic 4489	com/tencent/mm/hardcoder/WXHardCoderJNI:stopPerformance	(ZI)I
    //   33: pop
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 683	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:lyw	I
    //   39: aload_0
    //   40: invokestatic 4492	com/tencent/mm/plugin/sns/model/v:b	(Lcom/tencent/mm/model/bc;)V
    //   43: invokestatic 3839	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
    //   46: aconst_null
    //   47: putfield 4496	com/tencent/mm/plugin/sns/model/g:Qrh	Lcom/tencent/mm/plugin/sns/ui/af;
    //   50: aload_0
    //   51: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   54: ifnull +13 -> 67
    //   57: aload_0
    //   58: getfield 1512	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RyU	Lcom/tencent/mm/plugin/sns/ui/a/c;
    //   61: getfield 2729	com/tencent/mm/plugin/sns/ui/a/c:RGC	Lcom/tencent/mm/plugin/sns/ui/bn;
    //   64: invokevirtual 4498	com/tencent/mm/plugin/sns/ui/bn:onPause	()V
    //   67: aload_0
    //   68: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   71: ifnull +23 -> 94
    //   74: aload_0
    //   75: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   78: getfield 4501	com/tencent/mm/plugin/sns/ui/i:Rbv	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   81: ifnull +13 -> 94
    //   84: aload_0
    //   85: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   88: getfield 4501	com/tencent/mm/plugin/sns/ui/i:Rbv	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   91: invokevirtual 4502	com/tencent/mm/plugin/sns/ad/g/l:onPause	()V
    //   94: aload_0
    //   95: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   98: ifnull +27 -> 125
    //   101: aload_0
    //   102: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   105: getfield 946	com/tencent/mm/plugin/sns/ui/i:Rbw	Lcom/tencent/mm/plugin/sns/model/bd;
    //   108: ifnull +17 -> 125
    //   111: aload_0
    //   112: getfield 940	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Rza	Lcom/tencent/mm/plugin/sns/ui/i;
    //   115: getfield 946	com/tencent/mm/plugin/sns/ui/i:Rbw	Lcom/tencent/mm/plugin/sns/model/bd;
    //   118: getfield 952	com/tencent/mm/plugin/sns/model/bd:Qwn	Lcom/tencent/mm/plugin/sns/statistics/e;
    //   121: iconst_0
    //   122: invokevirtual 4505	com/tencent/mm/plugin/sns/statistics/e:DE	(Z)V
    //   125: ldc_w 4507
    //   128: aload_0
    //   129: getfield 545	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:Bti	J
    //   132: invokestatic 1956	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   135: invokestatic 4512	com/tencent/mm/modelstat/d:n	(Ljava/lang/String;JJ)V
    //   138: aload_0
    //   139: getfield 577	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mUIAction	Lcom/tencent/mm/plugin/sns/ui/SnsUIAction;
    //   142: invokevirtual 4513	com/tencent/mm/plugin/sns/ui/SnsUIAction:onPause	()V
    //   145: aload_0
    //   146: invokespecial 4514	com/tencent/mm/plugin/secdata/ui/WxPresenterSecDataActivity:onPause	()V
    //   149: ldc_w 4516
    //   152: invokestatic 628	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   155: checkcast 4516	com/tencent/mm/plugin/findersdk/a/ad
    //   158: astore_3
    //   159: aload_3
    //   160: ifnull +9 -> 169
    //   163: aload_3
    //   164: invokeinterface 4519 1 0
    //   169: invokestatic 1694	com/tencent/mm/plugin/sns/ui/video/e:hsu	()Lcom/tencent/mm/plugin/sns/ui/video/e;
    //   172: invokevirtual 4522	com/tencent/mm/plugin/sns/ui/video/e:onUIPause	()V
    //   175: invokestatic 1773	com/tencent/mm/plugin/sns/ui/video/b:hsi	()Lcom/tencent/mm/plugin/sns/ui/video/b;
    //   178: astore_3
    //   179: ldc_w 3965
    //   182: ldc_w 4523
    //   185: invokestatic 792	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload_3
    //   189: getfield 3971	com/tencent/mm/plugin/sns/ui/video/b:RUx	Ljava/util/Set;
    //   192: invokeinterface 3977 1 0
    //   197: astore_3
    //   198: aload_3
    //   199: invokeinterface 3982 1 0
    //   204: ifeq +34 -> 238
    //   207: aload_3
    //   208: invokeinterface 3985 1 0
    //   213: checkcast 1717	com/tencent/mm/plugin/sns/ui/video/a
    //   216: invokeinterface 4524 1 0
    //   221: goto -23 -> 198
    //   224: astore_3
    //   225: ldc_w 1195
    //   228: aload_3
    //   229: invokevirtual 1317	java/lang/Throwable:toString	()Ljava/lang/String;
    //   232: invokestatic 1320	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: goto -219 -> 16
    //   238: aload_0
    //   239: getfield 446	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzJ	Lcom/tencent/mm/sdk/event/IListener;
    //   242: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   245: aload_0
    //   246: getfield 443	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzI	Lcom/tencent/mm/sdk/event/IListener;
    //   249: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   252: aload_0
    //   253: getfield 492	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:RzW	Lcom/tencent/mm/sdk/event/IListener;
    //   256: invokevirtual 3994	com/tencent/mm/sdk/event/IListener:dead	()V
    //   259: invokestatic 4529	com/tencent/matrix/c:isInstalled	()Z
    //   262: ifeq +53 -> 315
    //   265: invokestatic 4533	com/tencent/matrix/c:avW	()Lcom/tencent/matrix/c;
    //   268: ldc_w 4535
    //   271: invokevirtual 4539	com/tencent/matrix/c:ai	(Ljava/lang/Class;)Lcom/tencent/matrix/d/b;
    //   274: ifnull +41 -> 315
    //   277: invokestatic 4533	com/tencent/matrix/c:avW	()Lcom/tencent/matrix/c;
    //   280: ldc_w 4535
    //   283: invokevirtual 4539	com/tencent/matrix/c:ai	(Ljava/lang/Class;)Lcom/tencent/matrix/d/b;
    //   286: checkcast 4535	com/tencent/matrix/trace/b
    //   289: getfield 4543	com/tencent/matrix/trace/b:fdr	Lcom/tencent/matrix/trace/tracer/b;
    //   292: astore_3
    //   293: aload_3
    //   294: ifnull +21 -> 315
    //   297: aload_0
    //   298: lconst_0
    //   299: aload_3
    //   300: getfield 4548	com/tencent/matrix/trace/tracer/b:ffH	I
    //   303: i2l
    //   304: aload_0
    //   305: getfield 547	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mxe	J
    //   308: lsub
    //   309: invokestatic 4552	java/lang/Math:max	(JJ)J
    //   312: putfield 547	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mxe	J
    //   315: invokestatic 1956	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   318: aload_0
    //   319: getfield 549	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:oCx	J
    //   322: lcmp
    //   323: ifle +104 -> 427
    //   326: invokestatic 1956	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   329: aload_0
    //   330: getfield 549	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:oCx	J
    //   333: lsub
    //   334: lstore_1
    //   335: aload_0
    //   336: lload_1
    //   337: putfield 549	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:oCx	J
    //   340: sipush 701
    //   343: getstatic 4555	com/tencent/mm/hardcoder/WXHardCoderJNI:hcSNSScrollAction	J
    //   346: iconst_1
    //   347: aload_0
    //   348: getfield 547	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mxe	J
    //   351: aload_0
    //   352: getfield 549	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:oCx	J
    //   355: invokestatic 4559	com/tencent/mm/hardcoder/WXHardCoderJNI:reportFPS	(IJIJJ)V
    //   358: aload_0
    //   359: lconst_0
    //   360: putfield 547	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:mxe	J
    //   363: aload_0
    //   364: lconst_0
    //   365: putfield 549	com/tencent/mm/plugin/sns/ui/SnsTimeLineUI:oCx	J
    //   368: ldc_w 4561
    //   371: invokestatic 628	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   374: ifnull +21 -> 395
    //   377: ldc_w 4561
    //   380: invokestatic 628	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   383: checkcast 4561	com/tencent/mm/plugin/ball/c/a
    //   386: bipush 101
    //   388: iconst_0
    //   389: iconst_0
    //   390: invokeinterface 4564 4 0
    //   395: new 4566	com/tencent/mm/autogen/a/zg
    //   398: dup
    //   399: invokespecial 4567	com/tencent/mm/autogen/a/zg:<init>	()V
    //   402: astore_3
    //   403: aload_3
    //   404: getfield 4571	com/tencent/mm/autogen/a/zg:icu	Lcom/tencent/mm/autogen/a/zg$a;
    //   407: getstatic 322	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   410: putfield 4576	com/tencent/mm/autogen/a/zg$a:icv	Ljava/lang/Boolean;
    //   413: aload_3
    //   414: invokestatic 4582	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   417: invokevirtual 4586	com/tencent/mm/autogen/a/zg:asyncPublish	(Landroid/os/Looper;)V
    //   420: ldc_w 4471
    //   423: invokestatic 298	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   426: return
    //   427: lconst_1
    //   428: lstore_1
    //   429: goto -94 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	SnsTimeLineUI
    //   334	95	1	l	long
    //   158	50	3	localObject1	Object
    //   224	5	3	localObject2	Object
    //   292	122	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   6	16	224	finally
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
        a(this, Boolean.TRUE);
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = b.j.permission_camera_request_again_msg;; paramInt = b.j.permission_microphone_request_again_msg)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.k.a(this, getString(paramInt), getString(b.j.permission_tips_title), getString(b.j.jump_to_settings), getString(b.j.app_cancel), false, new SnsTimeLineUI.76(this), new SnsTimeLineUI.77(this));
        }
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        hpJ();
        AppMethodBeat.o(99403);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = b.j.permission_camera_request_again_msg;; paramInt = b.j.permission_microphone_request_again_msg)
      {
        com.tencent.mm.ui.base.k.a(getContext(), getString(paramInt), getString(b.j.permission_tips_title), getString(b.j.jump_to_settings), getString(b.j.app_cancel), false, new SnsTimeLineUI.78(this), new SnsTimeLineUI.79(this));
        AppMethodBeat.o(99403);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        hpJ();
        AppMethodBeat.o(99403);
        return;
      }
      com.tencent.mm.ui.base.k.a(getContext(), getString(b.j.permission_location_request_again_msg), getString(b.j.permission_tips_title), getString(b.j.jump_to_settings), getString(b.j.app_cancel), false, new SnsTimeLineUI.80(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99384);
    al.hgN().QxQ = com.tencent.mm.plugin.sns.model.ay.QyB;
    this.Rzr.PhY = bi.hoZ();
    this.oCx = Util.nowSecond();
    Object localObject1;
    if ((com.tencent.matrix.c.isInstalled()) && (com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class) != null))
    {
      localObject1 = ((com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class)).fdr;
      if (localObject1 != null) {
        this.mxe = ((com.tencent.matrix.trace.tracer.b)localObject1).ffH;
      }
    }
    try
    {
      if (!this.Rlo)
      {
        Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onResume callback");
        ScreenShotUtil.setScreenShotCallback(this, this.Rmk);
        this.Rlo = true;
      }
      this.mUIAction.onResume();
      super.onResume();
      localObject1 = (ad)com.tencent.mm.kernel.h.ax(ad.class);
      if ((localObject1 != null) && (((ad)localObject1).E(this)))
      {
        AppMethodBeat.o(99384);
        return;
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", localObject2.toString());
      }
      hpE();
      El(this.autoPlay);
      this.Bti = Util.nowSecond();
      if (!this.RAi) {
        break label296;
      }
    }
    this.RAi = false;
    int i = this.RyU.getCount();
    Object localObject4;
    SnsInfo localSnsInfo;
    Object localObject3;
    if (getIntent().getBooleanExtra("is_from_find_more", false))
    {
      localObject4 = com.tencent.mm.modelsns.l.c(getIntent(), "enter_log");
      if (localObject4 != null)
      {
        if (i <= 0) {
          break label723;
        }
        localSnsInfo = this.RyU.alF(0);
        if (localSnsInfo != null) {
          break label689;
        }
        localObject3 = "0";
        ((com.tencent.mm.modelsns.l)localObject4).Ph((String)localObject3);
        if (localSnsInfo != null) {
          break label701;
        }
        localObject3 = "0";
        label273:
        ((com.tencent.mm.modelsns.l)localObject4).Ph((String)localObject3);
        ((com.tencent.mm.modelsns.l)localObject4).Ph(String.valueOf(i));
        label290:
        ((com.tencent.mm.modelsns.l)localObject4).bMH();
      }
    }
    label296:
    if (this.mScreenWidth == 0)
    {
      localObject3 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
      this.mScreenWidth = ((DisplayMetrics)localObject3).widthPixels;
      this.mScreenHeight = ((DisplayMetrics)localObject3).heightPixels;
      localObject3 = this.Rzh;
      i = this.mScreenWidth;
      int j = this.mScreenHeight;
      ((com.tencent.mm.plugin.sns.statistics.a)localObject3).mScreenWidth = i;
      ((com.tencent.mm.plugin.sns.statistics.a)localObject3).mScreenHeight = j;
    }
    if (al.isInValid()) {
      finish();
    }
    al.hgy().Qrh = this.RyU.RGC;
    bbE().ct(c.b.class);
    com.tencent.mm.plugin.sns.model.v.a(this);
    if (this.RyZ) {
      this.RyX.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99333);
          Log.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.O(SnsTimeLineUI.this));
          if (SnsTimeLineUI.O(SnsTimeLineUI.this))
          {
            SnsTimeLineUI.m(SnsTimeLineUI.this);
            SnsTimeLineUI.l(SnsTimeLineUI.this).hpZ();
          }
          AppMethodBeat.o(99333);
        }
      });
    }
    for (;;)
    {
      if ((this.Rza != null) && (this.Rza.Rbv != null)) {
        this.Rza.Rbv.onResume();
      }
      if (this.RyU != null) {
        this.RyU.RGC.onResume();
      }
      if ((this.Rza != null) && (this.Rza.Rbw != null))
      {
        this.Rza.Rbw.Qwn.DE(true);
        this.Rza.Rbw.Qwn.DF(false);
        this.Rza.Rbw.Qwn.DG(false);
        this.Rza.Rbw.Qwn.DH(false);
        this.Rza.Rbw.Qwn.DR(false);
        localObject3 = this.Rza.Rbw.Qwn;
        ((com.tencent.mm.plugin.sns.statistics.e)localObject3).DP(false);
        ((com.tencent.mm.plugin.sns.statistics.e)localObject3).DQ(false);
        ((com.tencent.mm.plugin.sns.statistics.e)localObject3).DJ(false);
        ((com.tencent.mm.plugin.sns.statistics.e)localObject3).DO(false);
        ((com.tencent.mm.plugin.sns.statistics.e)localObject3).DM(false);
        ((com.tencent.mm.plugin.sns.statistics.e)localObject3).DO(false);
        ((com.tencent.mm.plugin.sns.statistics.e)localObject3).DS(false);
        ((com.tencent.mm.plugin.sns.statistics.e)localObject3).DN(false);
        ((com.tencent.mm.plugin.sns.statistics.e)localObject3).DO(false);
        ((com.tencent.mm.plugin.sns.statistics.e)localObject3).DK(false);
        ((com.tencent.mm.plugin.sns.statistics.e)localObject3).DL(false);
      }
      localObject3 = al.hgy();
      ((com.tencent.mm.plugin.sns.model.g)localObject3).Qri = 0L;
      ((com.tencent.mm.plugin.sns.model.g)localObject3).Qrj = 0L;
      this.RzJ.alive();
      this.RzI.alive();
      this.RzW.alive();
      localObject3 = new zg();
      ((zg)localObject3).icu.icv = Boolean.TRUE;
      ((zg)localObject3).asyncPublish(Looper.getMainLooper());
      AppMethodBeat.o(99384);
      return;
      label689:
      localObject3 = com.tencent.mm.plugin.sns.data.t.uA(localSnsInfo.field_snsId);
      break;
      label701:
      localObject3 = localSnsInfo.field_createTime;
      break label273;
      label723:
      ((com.tencent.mm.modelsns.l)localObject4).Ph("");
      ((com.tencent.mm.modelsns.l)localObject4).Ph("");
      ((com.tencent.mm.modelsns.l)localObject4).Ph("0");
      break label290;
      localObject3 = this.Rzc;
      if (((a)localObject3).RAo.RyX.getVisibility() == 0)
      {
        ((a)localObject3).init();
        localObject4 = (AbsoluteLayout.LayoutParams)((a)localObject3).RAo.RyX.getLayoutParams();
        ((AbsoluteLayout.LayoutParams)localObject4).y = ((int)((a)localObject3).RAO);
        ((a)localObject3).RAo.RyX.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((a)localObject3).RAo.RyX.invalidate();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(99398);
    Log.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramp.getType());
    if (paramp.getType() == 218)
    {
      paramString = (com.tencent.mm.plugin.sns.model.s)paramp;
      if (((paramString.type == 1) || (paramString.type == 6) || (paramString.type == 4)) && (this.Rza.RbN != null)) {
        this.Rza.RbN.dismiss();
      }
      if (paramString.type == 11)
      {
        if (this.mUIAction.tipDialog != null) {
          this.mUIAction.tipDialog.dismiss();
        }
        if (this.RAk != null) {
          this.RAk.setImageResource(b.i.icons_outlined_camera);
        }
      }
    }
    if (this.RyU != null) {
      this.RyU.RGD.notifyVendingDataChange();
    }
    com.tencent.mm.modelsns.l locall;
    if (paramp.getType() == 211)
    {
      paramString = (com.tencent.mm.plugin.sns.model.z)paramp;
      if (!paramString.Qsg) {
        break label280;
      }
      locall = com.tencent.mm.modelsns.l.wO(727);
      locall.wR(this.RyU.getCount()).wR(paramString.bUo);
      locall.bMH();
    }
    for (;;)
    {
      if (this.Rzc != null)
      {
        this.RyZ = false;
        this.Rzc.hqa();
      }
      a(paramInt1, paramInt2, paramp, this);
      AppMethodBeat.o(99398);
      return;
      label280:
      locall = com.tencent.mm.modelsns.l.wO(728);
      locall.wR(this.RyU.getCount()).wR(paramString.bUo).wR(0);
      locall.bMH();
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(99385);
    ad localad = (ad)com.tencent.mm.kernel.h.ax(ad.class);
    if (localad != null) {
      localad.bUT();
    }
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
    AppMethodBeat.i(308167);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.Rlo = false;
      AppMethodBeat.o(308167);
      return;
    }
    finally
    {
      Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      Log.e("MicroMsg.SnsTimeLineUI.ScreenShot", localObject.toString());
      AppMethodBeat.o(308167);
    }
    if (!this.Rlo)
    {
      Log.i("MicroMsg.SnsTimeLineUI.ScreenShot", "onWindowFocusChanged callback");
      ScreenShotUtil.setScreenShotCallback(this, this.Rmk);
      this.Rlo = true;
    }
    AppMethodBeat.o(308167);
    return;
  }
  
  public void setActionbarColor(int paramInt)
  {
    AppMethodBeat.i(99375);
    super.setActionbarColor(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.Inv != null))
    {
      this.Inv.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.g(getWindow());
    }
    AppMethodBeat.o(99375);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(308172);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.sns.a.b.class);
    AppMethodBeat.o(308172);
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
    int MvO = 600;
    private float RAL;
    private float RAM;
    float RAN = -1.0F;
    float RAO;
    private float RAP = 50.0F;
    private float RAQ = 10.0F;
    float RAR = 0.0F;
    private float RAS = 0.0F;
    private float RAT;
    private float RAU;
    boolean RAV;
    int RAX;
    boolean RAY = false;
    int RAZ = 0;
    float RBa = 0.0F;
    float RBb = 0.0F;
    float RBc = 0.0F;
    float RBd = 0.0F;
    private ListView list;
    
    public a(ListView paramListView)
    {
      this.list = paramListView;
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(99366);
      if (SnsTimeLineUI.RzY.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "animtest applyTransformation vis %s interpolatedTime %s isJustUp %s", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(paramFloat), Boolean.valueOf(this.RAV) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99366);
        return;
      }
      float f1 = (paramFloat - this.RAT) * (float)getDuration();
      if (f1 < 2.0F)
      {
        if (SnsTimeLineUI.RzY.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "applyTransformation wawawa %s", new Object[] { Float.valueOf(f1) });
        }
        AppMethodBeat.o(99366);
        return;
      }
      this.RAT = paramFloat;
      SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(b.i.friendactivity_refresh);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.afUW);
      if (((float)getDuration() * paramFloat >= (float)(getDuration() - this.MvO)) || (this.RAV))
      {
        paramTransformation = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        if (paramTransformation.y <= this.RAS)
        {
          AppMethodBeat.o(99366);
          return;
        }
        if (this.RBc == 0.0F)
        {
          this.RBc = (-this.RAS + paramTransformation.y);
          this.RBd = paramTransformation.y;
          this.RAU = paramFloat;
        }
        paramFloat = (paramFloat - this.RAU) / (1.0F - this.RAU);
        f1 = this.RBc * paramFloat;
        float f2 = this.RBd - f1;
        if (SnsTimeLineUI.RzY.booleanValue()) {
          Log.i("MicroMsg.RefreshAnim", "animcheck interpolatedTime y %s duration %s factor %s residualTime %s pass %s ", new Object[] { Float.valueOf(f2), Long.valueOf(getDuration()), Float.valueOf(paramFloat), Float.valueOf(f1), Float.valueOf(this.RAU * (float)getDuration()) });
        }
        if (paramTransformation.y > f2) {
          paramTransformation.y = ((int)f2);
        }
        this.RAR = paramTransformation.y;
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(paramTransformation);
      }
      for (;;)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99366);
        return;
        if (SnsTimeLineUI.RzY.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "animcheck delt Rotate " + f1 / 2.5F);
        }
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(f1 / 2.5F, this.RAL, this.RAM);
      }
    }
    
    public final void dq(float paramFloat)
    {
      AppMethodBeat.i(99360);
      if (this.list != null)
      {
        if (this.list.getFirstVisiblePosition() != 0) {
          break label122;
        }
        if (SnsTimeLineUI.d(SnsTimeLineUI.this).QCY.getTop() >= SnsTimeLineUI.l(SnsTimeLineUI.this).RAX) {
          SnsTimeLineUI.b(SnsTimeLineUI.this, 0);
        }
      }
      for (;;)
      {
        if (SnsTimeLineUI.RzY.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.RAO), Float.valueOf(this.RAN) });
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
      if (paramFloat <= -this.RAP) {
        f1 = -this.RAP;
      }
      float f2 = f1;
      if (f1 >= this.RAP) {
        f2 = this.RAP;
      }
      if (f2 < 0.0F)
      {
        this.RAR -= f2 * 2.0F;
        f1 = this.RAR;
        paramFloat = f1;
        if (f1 < this.RAO)
        {
          paramFloat = this.RAO;
          this.RAR = this.RAO;
        }
        f1 = paramFloat;
        if (paramFloat > this.RAN)
        {
          f1 = this.RAN;
          this.RAR = this.RAN;
        }
        if (SnsTimeLineUI.RzY.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "animtest setDistanceY %s %s %s sumY %s translateY %s distanceY %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.RAO), Float.valueOf(this.RAN), Float.valueOf(this.RAR), Float.valueOf(f1), Float.valueOf(this.RAP) });
        }
        if (f1 != this.RAN) {
          break label456;
        }
      }
      label456:
      for (paramFloat = f2 * 2.0F;; paramFloat = 5.0F * f2)
      {
        SnsTimeLineUI.u(SnsTimeLineUI.this).setScaleType(QImageView.a.afUW);
        SnsTimeLineUI.u(SnsTimeLineUI.this).getImageMatrix().postRotate(paramFloat, this.RAL, this.RAM);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setImageResource(b.i.friendactivity_refresh);
        AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
        localLayoutParams.y = ((int)f1);
        SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
        SnsTimeLineUI.u(SnsTimeLineUI.this).invalidate();
        AppMethodBeat.o(99360);
        return;
        this.RAR -= f2 / 2.0F;
        break;
      }
    }
    
    public final void hpZ()
    {
      AppMethodBeat.i(99361);
      if (SnsTimeLineUI.RzY.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "animtest playLoading");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99361);
        return;
      }
      init();
      this.RAR = (this.RAN + 20.0F);
      AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams();
      localLayoutParams.y = ((int)this.RAN);
      SnsTimeLineUI.u(SnsTimeLineUI.this).setLayoutParams(localLayoutParams);
      hqb();
      AppMethodBeat.o(99361);
    }
    
    public final void hqa()
    {
      AppMethodBeat.i(99362);
      if (SnsTimeLineUI.RzY.booleanValue()) {
        Log.i("MicroMsg.RefreshAnim", "play end vis: %d, sumY %f MAX_Y %f", new Object[] { Integer.valueOf(SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility()), Float.valueOf(this.RAR), Float.valueOf(this.RAN) });
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99362);
        return;
      }
      init();
      if (this.RAR < this.RAN - this.RAQ)
      {
        AppMethodBeat.o(99362);
        return;
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      vt(this.MvO + 100);
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      this.RAV = false;
      AppMethodBeat.o(99362);
    }
    
    public final void hqb()
    {
      AppMethodBeat.i(99364);
      if (SnsTimeLineUI.RzY.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "animtest setAcitonUp");
      }
      if (SnsTimeLineUI.u(SnsTimeLineUI.this).getVisibility() != 0)
      {
        AppMethodBeat.o(99364);
        return;
      }
      init();
      SnsTimeLineUI.u(SnsTimeLineUI.this).clearAnimation();
      if (SnsTimeLineUI.RzY.booleanValue()) {
        Log.v("MicroMsg.RefreshAnim", "setAcitonUp1 sumY  %s MAX_Y %s %s", new Object[] { Float.valueOf(this.RAR), Float.valueOf(this.RAN), Util.getStack().toString() });
      }
      SnsTimeLineUI.u(SnsTimeLineUI.this).startAnimation(this);
      if (this.RAR >= this.RAN - this.RAQ)
      {
        vt(20000L);
        this.RAV = false;
        AppMethodBeat.o(99364);
        return;
      }
      vt(this.MvO + 100);
      this.RAV = true;
      AppMethodBeat.o(99364);
    }
    
    final void init()
    {
      AppMethodBeat.i(99365);
      if ((this.RAN == -1.0F) || (this.RAM < 0.1D))
      {
        this.RAN = BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 70.0F);
        this.RAP = BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 16.0F);
        this.RAL = (SnsTimeLineUI.u(SnsTimeLineUI.this).getWidth() / 2);
        this.RAM = (SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() / 2);
        this.RAS = (-SnsTimeLineUI.u(SnsTimeLineUI.this).getHeight() * 2);
        if (this.RAS == 0.0F) {
          this.RAS = (-BackwardSupportUtil.BitmapFactory.fromDPToPix(SnsTimeLineUI.this, 40.0F));
        }
        this.RAO = this.RAS;
        if (SnsTimeLineUI.RzY.booleanValue()) {
          Log.d("MicroMsg.RefreshAnim", "init MIN_Y %s MAX_Y %s targetInitY %s distanceY %s", new Object[] { Float.valueOf(this.RAO), Float.valueOf(this.RAN), Float.valueOf(this.RAS), Float.valueOf(this.RAP) });
        }
        this.RAR = this.RAO;
        if (!this.RAY)
        {
          if (SnsTimeLineUI.RzY.booleanValue()) {
            Log.i("MicroMsg.RefreshAnim", "initState");
          }
          this.RAZ = ((AbsoluteLayout.LayoutParams)SnsTimeLineUI.u(SnsTimeLineUI.this).getLayoutParams()).y;
          this.RBa = this.RAN;
          this.RBb = this.RAR;
        }
        this.RAY = true;
      }
      AppMethodBeat.o(99365);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(99367);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      if (SnsTimeLineUI.RzY.booleanValue()) {
        Log.i("MicroMsg.RefreshAnim", "anim initialize %s", new Object[] { Util.getStack().toString() });
      }
      this.RAT = 0.0F;
      this.RAU = 0.0F;
      this.RBc = 0.0F;
      this.RBd = 0.0F;
      AppMethodBeat.o(99367);
    }
    
    final void vt(long paramLong)
    {
      AppMethodBeat.i(99363);
      if (SnsTimeLineUI.RzY.booleanValue()) {
        Log.d("MicroMsg.RefreshAnim", "setDurationTime durationMillis %s %s", new Object[] { Long.valueOf(paramLong), Util.getStack().toString() });
      }
      setDuration(paramLong);
      AppMethodBeat.o(99363);
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
    public int Qmt;
    public String RBe = "";
    public long RBf;
    public int RBg;
    public int RBh;
    public long RBi;
    public long RBj;
    public int RBk;
    public long RBl;
    public boolean active = true;
    public long sSP;
    public int scene;
    
    private c() {}
    
    public final void aml(int paramInt)
    {
      AppMethodBeat.i(99368);
      if (!this.active)
      {
        AppMethodBeat.o(99368);
        return;
      }
      this.RBh = paramInt;
      this.sSP = Util.nowMilliSecond();
      AppMethodBeat.o(99368);
    }
    
    public final void amm(int paramInt)
    {
      AppMethodBeat.i(99369);
      if (!this.active)
      {
        AppMethodBeat.o(99369);
        return;
      }
      reset();
      this.scene = 2;
      this.RBi = Util.nowMilliSecond();
      this.Qmt = paramInt;
      AppMethodBeat.o(99369);
    }
    
    public final void amn(int paramInt)
    {
      AppMethodBeat.i(99370);
      if (!this.active)
      {
        AppMethodBeat.o(99370);
        return;
      }
      reset();
      this.scene = 3;
      this.RBj = Util.nowMilliSecond();
      this.RBl = 0L;
      this.RBk = paramInt;
      AppMethodBeat.o(99370);
    }
    
    final void reset()
    {
      this.scene = 0;
      this.RBf = 0L;
      this.RBg = -1;
      this.RBh = 0;
      this.sSP = 0L;
      this.RBi = 0L;
      this.Qmt = 0;
      this.RBj = 0L;
      this.RBk = 0;
      this.RBl = 0L;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(99371);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.RBe).append(",").append(this.scene).append(",").append(this.RBf).append(",").append(this.RBg).append(",").append(this.RBh).append(",").append(this.sSP).append(",").append(this.RBi).append(",").append(this.Qmt).append(",").append(this.RBj).append(",").append(this.RBk).append(",").append(this.RBl);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(99371);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI
 * JD-Core Version:    0.7.0.1
 */