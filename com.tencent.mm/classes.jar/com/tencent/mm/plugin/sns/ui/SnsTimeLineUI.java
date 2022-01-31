package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.bx;
import com.tencent.mm.h.a.si;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.j;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.model.al;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.sns.a.b.i.5;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.h.b.2;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.j.c.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vending.app.a.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@j
public class SnsTimeLineUI
  extends WxPresenterActivity
  implements com.tencent.mm.ah.f, ap, h.a, t
{
  private static Handler h = new Handler(pfv.getLooper());
  private static HandlerThread pfv;
  private static final Set<Activity> wuA = new HashSet();
  private long dFe;
  private int dmY;
  private long ekk;
  private String hcm;
  private long iaq;
  private com.tencent.matrix.trace.c.a kho;
  private ActionBar mActionBar;
  private int mBY;
  private int mScreenHeight;
  private int mScreenWidth;
  private boolean oNK;
  private boolean oPz;
  protected com.tencent.mm.plugin.sns.a.b.g oWw;
  private com.tencent.mm.sdk.b.c otz;
  private boolean oxh;
  private LinearLayout peA;
  private QFadeImageView peB;
  private boolean peC;
  private boolean peD;
  private i peE;
  private SnsTimeLineUI.a peF;
  private TestTimeForSns peG;
  private int peH;
  private boolean peI;
  private String peJ;
  private com.tencent.mm.plugin.sns.h.a peK;
  private com.tencent.mm.plugin.sns.model.av peL;
  private at peM;
  private String peN;
  private boolean peO;
  private int peP;
  private ba peQ;
  private String peR;
  private SnsTimeLineUI.c peS;
  private Runnable peT;
  private com.tencent.mm.sdk.b.c peU;
  private boolean peV;
  private com.tencent.mm.sdk.b.c peW;
  private com.tencent.mm.sdk.b.c peX;
  private com.tencent.mm.sdk.b.c peY;
  private com.tencent.mm.sdk.b.c peZ;
  private final long peu = 300L;
  private long pev = SystemClock.elapsedRealtime();
  private com.tencent.mm.plugin.sns.j.b pew = (com.tencent.mm.plugin.sns.j.b)z(com.tencent.mm.plugin.sns.j.b.class);
  private com.tencent.mm.plugin.sns.j.a pex;
  private aw pey;
  private LinearLayout pez;
  private View.OnClickListener pfA;
  private boolean pfB;
  private com.tencent.mm.sdk.b.c pfa;
  private com.tencent.mm.sdk.b.c pfb;
  private com.tencent.mm.sdk.b.c pfc;
  private com.tencent.mm.sdk.b.c pfd;
  private com.tencent.mm.sdk.b.c pfe;
  private com.tencent.mm.sdk.b.c pff;
  private com.tencent.mm.sdk.b.c pfg;
  private com.tencent.mm.sdk.b.c pfh;
  private com.tencent.mm.sdk.b.c pfi;
  private com.tencent.mm.sdk.b.c pfj;
  private View pfk;
  private com.tencent.mm.ui.statusbar.c.a pfl;
  private long pfm;
  boolean pfn;
  Runnable pfo;
  Runnable pfp;
  private Handler pfq;
  private Runnable pfr;
  private ba.a pfs;
  private a.b pft;
  boolean pfu;
  private MenuItem.OnMenuItemClickListener pfw;
  private ImageView pfx;
  private View pfy;
  private az pfz;
  
  static
  {
    HandlerThread localHandlerThread = new HandlerThread("sns");
    pfv = localHandlerThread;
    localHandlerThread.start();
  }
  
  public SnsTimeLineUI()
  {
    if (this.pew != null) {}
    for (com.tencent.mm.plugin.sns.j.a locala = this.pew.bKE();; locala = null)
    {
      this.pex = locala;
      this.peC = false;
      this.peD = false;
      this.oNK = false;
      this.peH = 0;
      this.peI = false;
      this.peJ = "";
      this.peK = new com.tencent.mm.plugin.sns.h.a();
      this.oWw = new com.tencent.mm.plugin.sns.a.b.g(1);
      this.peL = new com.tencent.mm.plugin.sns.model.av();
      this.peM = new at();
      this.peR = "";
      this.peS = new SnsTimeLineUI.c(this, (byte)0);
      this.peT = new SnsTimeLineUI.1(this);
      this.peU = new SnsTimeLineUI.12(this);
      this.peV = false;
      this.oxh = false;
      this.peW = new SnsTimeLineUI.23(this);
      this.peX = new SnsTimeLineUI.34(this);
      this.peY = new SnsTimeLineUI.45(this);
      this.peZ = new SnsTimeLineUI.55(this);
      this.pfa = new SnsTimeLineUI.56(this);
      this.pfb = new SnsTimeLineUI.57(this);
      this.pfc = new SnsTimeLineUI.58(this);
      this.pfd = new SnsTimeLineUI.2(this);
      this.pfe = new SnsTimeLineUI.3(this);
      this.otz = new SnsTimeLineUI.4(this);
      this.pff = new SnsTimeLineUI.5(this);
      this.pfg = new SnsTimeLineUI.6(this);
      this.pfh = new SnsTimeLineUI.7(this);
      this.pfi = new SnsTimeLineUI.8(this);
      this.pfj = new SnsTimeLineUI.9(this);
      this.pfm = 0L;
      this.pfn = false;
      this.mBY = 0;
      this.pfo = new SnsTimeLineUI.16(this);
      this.pfp = new SnsTimeLineUI.17(this);
      this.pfq = ((com.tencent.mm.vending.h.b)com.tencent.mm.vending.h.d.wtZ.wue).a;
      this.pfr = new SnsTimeLineUI.18(this);
      this.pfs = new SnsTimeLineUI.19(this);
      this.pft = new SnsTimeLineUI.20(this);
      this.mScreenWidth = 0;
      this.mScreenHeight = 0;
      this.pfu = true;
      this.iaq = 0L;
      this.dFe = 0L;
      this.ekk = 0L;
      this.kho = new SnsTimeLineUI.25(this);
      this.pfw = new SnsTimeLineUI.39(this);
      this.pfz = null;
      this.pfA = new SnsTimeLineUI.48(this);
      this.pfB = false;
      return;
    }
  }
  
  private static void a(SnsTimeLineUI.c paramc)
  {
    if (paramc.axD)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsTimeLineUI", "report weishi: %s", new Object[] { paramc.toString() });
      com.tencent.mm.plugin.report.service.h.nFQ.aC(15827, paramc.toString());
    }
  }
  
  private void bJx()
  {
    addIconOptionMenu(0, i.j.sns_action_bar_take_photo_btn_desc, i.i.common_icons_camera, new SnsTimeLineUI.22(this), new SnsTimeLineUI.24(this));
  }
  
  private void bJy()
  {
    b(new SnsTimeLineUI.40(this), new SnsTimeLineUI.41(this));
    setBackBtn(this.pfw, i.i.actionbar_icon_dark_back);
  }
  
  private void bJz()
  {
    if (com.tencent.mm.r.a.bi(this)) {}
    boolean bool;
    do
    {
      do
      {
        return;
        bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 18, "", "");
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this });
      } while (!bool);
      bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "");
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this });
    } while (!bool);
    String str = bk.UY() + "_" + bk.Fe(5);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "doCpatureMMSight sessionID:%s", new Object[] { str });
    com.tencent.mm.plugin.report.service.h.nFQ.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), str, Long.valueOf(bk.UX()) });
    Intent localIntent = new Intent();
    l.b(this.mController.uMN, localIntent, str);
  }
  
  public final void Hk() {}
  
  public final void Hl()
  {
    if (this.pfB) {
      return;
    }
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
    this.pfB = true;
    af.aXq().postDelayed(new SnsTimeLineUI.50(this), 1000L);
  }
  
  public final void Hm()
  {
    EB().ae(c.b.class);
  }
  
  public final void a(bsx parambsx)
  {
    if (parambsx != null) {
      int i = parambsx.tJz;
    }
    EB().ae(c.b.class);
  }
  
  public final void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, int paramInt, long paramLong)
  {
    this.pfq.removeCallbacks(this.peT);
    com.tencent.mm.vending.g.f.cLb().d(new SnsTimeLineUI.14(this, paramString)).f(new SnsTimeLineUI.13(this, paramBoolean1));
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4, int paramInt, long paramLong)
  {
    this.pfq.removeCallbacks(this.peT);
    com.tencent.mm.vending.g.f.cLb().d(new SnsTimeLineUI.11(this, paramString)).f(new SnsTimeLineUI.10(this, paramBoolean2, paramBoolean1));
  }
  
  public final boolean bHw()
  {
    if ((this.peE == null) || (this.peE.oNM == null)) {
      return false;
    }
    if ((this.peE == null) || (this.peE.oNN == null)) {}
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.bBV();
      return this.peE.oNM.bHw();
      this.peE.oNN.bEx();
    }
  }
  
  public final boolean cZ(View paramView)
  {
    this.peE.oNN.bEx();
    bg localbg = this.peE.oNM;
    if (!(paramView.getTag() instanceof a.c))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
      return false;
    }
    a.c localc = (a.c)paramView.getTag();
    Object localObject1 = localc.bJQ;
    if (localbg.pkj != null)
    {
      if ((localbg.pkj.getTag() instanceof bg.a))
      {
        localObject2 = (bg.a)localbg.pkj.getTag();
        if (((bg.a)localObject2).ovS.equals(localObject1))
        {
          localbg.db(((bg.a)localObject2).okf);
          return true;
        }
        localbg.bHw();
      }
      localbg.pkj = null;
    }
    localbg.pkj = new SnsCommentShowAbLayout(localbg.mContext);
    k.bO(localbg.pkj);
    localbg.pkj.setId(i.f.address);
    new FrameLayout.LayoutParams(-1, -1);
    localbg.ovy.addView(localbg.pkj);
    int i = BackwardSupportUtil.b.b(localbg.mContext, 192.0F);
    int j = BackwardSupportUtil.b.b(localbg.mContext, 76.0F);
    BackwardSupportUtil.b.b(localbg.mContext, 20.0F);
    int k = BackwardSupportUtil.b.b(localbg.mContext, 12.0F);
    int m = BackwardSupportUtil.b.b(localbg.mContext, 40.0F);
    Object localObject2 = com.tencent.mm.ui.y.gt(localbg.mContext).inflate(i.g.sns_comment_button, null);
    new Rect();
    Object localObject3 = new int[2];
    com.tencent.mm.pluginsdk.e.eK(localbg.mContext);
    int n = com.tencent.mm.cb.a.fromDPToPix(localbg.mContext, 2);
    paramView.getLocationInWindow((int[])localObject3);
    localbg.olg = ak.gz(localbg.mContext);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + n + " height_hardcode:" + j + " statusBarHeight: " + localbg.olg);
    localObject3 = new AbsoluteLayout.LayoutParams(-2, -2, localObject3[0] - i + k, localObject3[1] - n - (m / 2 - paramView.getMeasuredHeight() / 2));
    localObject1 = new bg.a(localbg, (String)localObject1, (View)localObject2);
    localbg.pkj.setTag(localObject1);
    localbg.pkj.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    if (localc.ivk == 10) {
      ((View)localObject2).findViewById(i.f.album_comment_container).setBackgroundResource(i.e.friendactivity_comment_frame_bg_golden);
    }
    ((View)localObject2).setVisibility(8);
    new ah().post(new bg.1(localbg, paramView, (View)localObject2));
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int j = 0;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[] { paramKeyEvent.toString() });
    int k = this.mController.uNh;
    i locali = this.peE;
    int i = j;
    if (paramKeyEvent.getKeyCode() == 4)
    {
      i = j;
      if (locali.oNF.getVisibility() == 0)
      {
        locali.oNF.setVisibility(8);
        i = 1;
      }
    }
    if ((i != 0) && (k == 2)) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void finalize()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsTimeLineUI", "finalize");
    super.finalize();
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_timeline_ui;
  }
  
  protected final void initView()
  {
    this.peQ.oxg.setDrawingCacheEnabled(false);
    this.peE.ovy = ((FrameLayout)findViewById(i.f.timeline_root));
    setMMTitle(i.j.sns_timeline_ui_title);
    int i = af.bDM().position;
    AdListView localAdListView = (AdListView)this.peQ.bJB();
    localAdListView.oMa = this.oWw;
    localAdListView.setTimelineStat(this.peL);
    localAdListView.setTimelineEvent(this.peM);
    this.peM.a(af.bDw());
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.oNK, new Object[] { Integer.valueOf(i) });
    this.peB = ((QFadeImageView)findViewById(i.f.sns_refresh_iv));
    this.peB.setImageResource(i.i.friendactivity_refresh);
    this.peF = new SnsTimeLineUI.a(this, this.peQ.bJB());
    this.peF.setInterpolator(new LinearInterpolator());
    this.peF.setAnimationListener(new SnsTimeLineUI.27(this));
    this.pey = new aw(this, this.peQ.bJB(), this.peE.oNP, this.peE, this.peN);
    this.peE.oNP.ppg = new au.a()
    {
      public final boolean bJw()
      {
        SnsTimeLineUI.this.EB().ae(c.b.class);
        return false;
      }
    };
    this.peE.owd = this.pey.pgw;
    this.pey.pgx.wsM = new com.tencent.mm.vending.a.b.a()
    {
      public final void bJI()
      {
        com.tencent.mm.plugin.report.service.g.wI(14);
      }
      
      public final void bJJ()
      {
        com.tencent.mm.plugin.report.service.g.wJ(14);
      }
    };
    this.peG = ((TestTimeForSns)this.peE.ovy);
    this.peG.setListener(new SnsTimeLineUI.30(this));
    this.peQ.lwE.setOnTouchListener(new SnsTimeLineUI.31(this));
    this.peQ.lwE.post(new Runnable()
    {
      public final void run()
      {
        if (SnsTimeLineUI.g(SnsTimeLineUI.this) == null) {
          return;
        }
        SnsTimeLineUI.g(SnsTimeLineUI.this).oNG.oWf = SnsTimeLineUI.h(SnsTimeLineUI.this).lwE.getBottom();
        SnsTimeLineUI.g(SnsTimeLineUI.this).oNG.pko = SnsTimeLineUI.h(SnsTimeLineUI.this).mbz.getTop();
        SnsTimeLineUI.E(SnsTimeLineUI.this).pfX = SnsTimeLineUI.h(SnsTimeLineUI.this).oxg.getTop();
      }
    });
    this.peQ.mbz.setOnSrcollDistance(new MMPullDownView.f()
    {
      public final void aF(float paramAnonymousFloat)
      {
        SnsTimeLineUI.H(SnsTimeLineUI.this);
        SnsTimeLineUI.a locala;
        float f1;
        if ((SnsTimeLineUI.h(SnsTimeLineUI.this).oxg.getTop() >= SnsTimeLineUI.E(SnsTimeLineUI.this).pfX) || (paramAnonymousFloat > 0.0F))
        {
          locala = SnsTimeLineUI.E(SnsTimeLineUI.this);
          if (locala.lwE != null)
          {
            if (locala.lwE.getFirstVisiblePosition() != 0) {
              break label320;
            }
            SnsTimeLineUI.m(locala.pfC).setVisibility(0);
          }
          if (SnsTimeLineUI.m(locala.pfC).getVisibility() == 0)
          {
            SnsTimeLineUI.m(locala.pfC).clearAnimation();
            locala.init();
            locala.pfU -= paramAnonymousFloat / 2.0F;
            float f2 = locala.pfU;
            f1 = f2;
            if (f2 < locala.pfT)
            {
              f1 = locala.pfT;
              locala.pfU = locala.pfT;
            }
            if (f1 <= locala.pfS) {
              break label344;
            }
            f1 = locala.pfS;
          }
        }
        label320:
        label344:
        for (;;)
        {
          if (f1 == locala.pfS) {}
          for (paramAnonymousFloat *= 2.0F;; paramAnonymousFloat = 5.0F * paramAnonymousFloat)
          {
            SnsTimeLineUI.m(locala.pfC).setScaleType(QImageView.a.wkM);
            SnsTimeLineUI.m(locala.pfC).getImageMatrix().postRotate(paramAnonymousFloat, locala.pfQ, locala.pfR);
            SnsTimeLineUI.m(locala.pfC).setImageResource(i.i.friendactivity_refresh);
            AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.m(locala.pfC).getLayoutParams();
            localLayoutParams.y = ((int)f1);
            SnsTimeLineUI.m(locala.pfC).setLayoutParams(localLayoutParams);
            SnsTimeLineUI.m(locala.pfC).invalidate();
            SnsTimeLineUI.g(SnsTimeLineUI.this).bHn();
            SnsTimeLineUI.this.bHw();
            SnsTimeLineUI.g(SnsTimeLineUI.this).oNG.bKi();
            return;
            SnsTimeLineUI.m(locala.pfC).setVisibility(8);
            break;
          }
        }
      }
      
      public final void bJK()
      {
        SnsTimeLineUI.E(SnsTimeLineUI.this).bJM();
      }
    });
    this.peE.oNF = ((SnsCommentFooter)findViewById(i.f.comment_footer));
    this.peE.oNF.post(new SnsTimeLineUI.35(this));
    this.peE.oNG = new bh(this.peQ.lwE, this.peE.oNF);
    this.pez = ((LinearLayout)this.peQ.oxg.findViewById(i.f.sns_notify_list));
    this.pez.findViewById(i.f.sns_notify_for_click).setOnClickListener(new SnsTimeLineUI.36(this));
    this.peA = ((LinearLayout)this.peQ.oxg.findViewById(i.f.sns_notify_media_content_collapse));
    this.peE.oNH = new an(this);
    bJy();
  }
  
  public final void jz(boolean paramBoolean)
  {
    if (this.pey != null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "set play animation %s", new Object[] { Boolean.valueOf(paramBoolean) });
      aw localaw = this.pey;
      localaw.pgy = paramBoolean;
      if (!paramBoolean) {
        localaw.notifyDataSetChanged();
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 15) {
      if ((this.peE != null) && (this.peE.oNP != null) && (this.peE.oNP.poz != null))
      {
        this.peE.oNP.poz.onActivityResult(paramInt1, paramInt2, paramIntent);
        com.tencent.mm.sdk.platformtools.ai.l(new SnsTimeLineUI.52(this), 300L);
      }
    }
    do
    {
      return;
      if (paramInt1 == 16)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
        return;
      }
      if ((paramInt1 == 2333) && (paramIntent != null))
      {
        Object localObject = paramIntent.getStringExtra("Select_Contact");
        if (!bk.bl((String)localObject))
        {
          localObject = ((String)localObject).split(",");
          if (localObject.length > 0)
          {
            this.peE.oNF.bER.showVKB();
            String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV(localObject[0]);
            if (!bk.bl(str))
            {
              this.peE.oNF.bIL();
              this.peE.oNF.setText("@" + str + " ");
              this.peE.oNF.setCommentAtPrefix("@" + str + " ");
              this.peE.oNF.setCommentInfo(new btd());
              this.peE.oNF.getCommentInfo().sxM = localObject[0];
              this.peE.oNF.setCommentFlag(8);
            }
          }
        }
      }
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      this.peQ.onActivityResult(paramInt1, paramInt2, paramIntent);
    } while (paramInt1 != 11);
    this.pew.prw.b(this.hcm, this.peO, this.oPz, this.peP);
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
    com.tencent.mm.sdk.b.a.udP.m(new bx());
    com.tencent.mm.plugin.sns.ui.widget.d.bKB().prl = 0;
    com.tencent.mm.plugin.sns.ui.widget.b.bKA().prl = 0;
    com.tencent.mm.kiss.widget.textview.c.dNE.EE();
    this.pey.pgw.bJp();
    this.pey.pgx.resolvedClear();
  }
  
  public void onCreate(Bundle arg1)
  {
    int j = 1;
    if (this.mController != null) {
      this.mController.ap(2, true);
    }
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    com.tencent.mm.pluginsdk.e.k(this);
    super.onCreate(???);
    if (!com.tencent.mm.kernel.g.DN().Dc())
    {
      finish();
      return;
    }
    this.pfk = findViewById(i.f.action_bar_container);
    int i;
    Object localObject1;
    Object localObject3;
    label444:
    label509:
    int k;
    if ((this.pfk == null) || (!com.tencent.mm.ui.statusbar.c.vXv))
    {
      getWindow().getDecorView().setSystemUiVisibility(1280);
      new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a(this);
      bJx();
      ta(this.mController.uMN.getResources().getColor(i.c.transparent));
      czo();
      this.mActionBar = getSupportActionBar();
      i = com.tencent.mm.model.c.c.IY().dt("Sns_Private_Recent_Setting_Guide", 0);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = " + i);
      if (i == 1)
      {
        com.tencent.mm.kernel.g.DQ();
        if (!com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uuX, false))
        {
          ??? = getIntent();
          ???.setClass(this.mController.uMN, SnsSettingIntroduceUI.class);
          startActivity(???);
          overridePendingTransition(0, 0);
          finish();
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uuX, Boolean.valueOf(true));
        }
      }
      com.tencent.mm.ch.b.cxz();
      this.pex.a(c.b.class, this.pft);
      this.pex.a(this);
      localObject1 = (com.tencent.mm.plugin.sns.j.c.a)this.pex.ad(com.tencent.mm.plugin.sns.j.c.a.class);
      this.hcm = ((com.tencent.mm.plugin.sns.j.c.a)localObject1).hcm;
      this.peN = ((com.tencent.mm.plugin.sns.j.c.a)localObject1).peN;
      this.peO = ((com.tencent.mm.plugin.sns.j.c.a)localObject1).peO;
      this.oPz = ((com.tencent.mm.plugin.sns.j.c.a)localObject1).oPz;
      this.peP = ((com.tencent.mm.plugin.sns.j.c.a)localObject1).peP;
      ??? = ((com.tencent.mm.plugin.sns.j.c.a)localObject1).fsv;
      localObject1 = ((com.tencent.mm.plugin.sns.j.c.a)localObject1).mSignature;
      this.peQ = new ba(this);
      this.peQ.piq = this.pfs;
      this.peQ.pir = this.mActionBar.getCustomView();
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().fU(2);
      com.tencent.mm.plugin.sns.ui.widget.d.bKB().prl = 0;
      com.tencent.mm.plugin.sns.ui.widget.b.bKA().prl = 0;
      localObject3 = com.tencent.mm.modelsns.c.eAU;
      com.tencent.mm.modelsns.c.QY();
      if (!getIntent().getBooleanExtra("is_sns_notify_open", true)) {
        break label1811;
      }
      i = 1;
      this.peE = new i(this, i, bk.aM(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0));
      this.oNK = getIntent().getBooleanExtra("sns_resume_state", true);
      if (!af.bDo()) {
        break label1816;
      }
      this.oNK = false;
      this.peC = this.oNK;
      this.peQ.a(this.peN, this.hcm, ???, (String)localObject1, this.peO, this.oPz, this.peP);
      this.peQ.onCreate();
      af.bDw().init();
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(213, this);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(682, this);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(218, this);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(211, this);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(683, this);
      initView();
      ??? = af.bDw();
      localObject1 = this.peQ.lwE;
      localObject3 = this.pey.pgw;
      ???.owc = ((ListView)localObject1);
      ???.owd = ((au)localObject3);
      ??? = af.bDw();
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(291, ???);
      this.peD = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
      this.peE.kgn = ((ClipboardManager)getSystemService("clipboard"));
      if (!af.bDo()) {
        break label1836;
      }
      this.oNK = false;
      label747:
      ??? = this.pex;
      ???.pgx = this.pey.pgx;
      localObject1 = ???.pgx;
      ???.wsK.keep((com.tencent.mm.vending.e.a)localObject1);
      if (!this.oNK) {
        break label1863;
      }
      this.peD = false;
      k = af.bDM().position;
      localObject1 = this.pey.pgx;
      localObject3 = af.bDM().jKL;
    }
    for (;;)
    {
      synchronized (((av)localObject1).pgr)
      {
        ((av)localObject1).jKL = ((String)localObject3);
        this.pey.pgx.oSZ = af.bDM().oSZ;
        this.pey.pgx.pgq = true;
        this.pey.mT();
        i = k;
        if (k >= this.pey.getCount())
        {
          i = this.pey.getCount() - 1;
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[] { Integer.valueOf(this.pey.getCount()) });
        }
        this.peQ.lwE.setAdapter(this.pey);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[] { Integer.valueOf(af.bDM().oTa) });
        this.peQ.lwE.setSelectionFromTop(i, af.bDM().oTa);
        this.peB.setVisibility(4);
        i = this.pey.getCount();
        k = this.peQ.lwE.getFirstVisiblePosition();
        if (k < i) {
          this.peJ = com.tencent.mm.plugin.sns.data.i.j(this.pey.yy(k));
        }
        com.tencent.mm.kernel.g.DQ();
        this.peH = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(327776, Integer.valueOf(0))).intValue();
        this.peE.oNM = new bg(this, this.pey.pgw, this.peE.ovy);
        this.peE.oNO = new com.tencent.mm.plugin.sns.f.b(this, this.pey.pgw.ovx, this.peE.ovy);
        this.peE.oNN = new b(this, this.pey.pgw.ovx, this.peE.ovy, this.peE.oNO);
        if (this.peM != null) {
          this.peM.a(this.peE.oNO);
        }
        if (i > 0)
        {
          ??? = this.pey.yy(0);
          if ((this.peE.oNC != null) && (this.peE.oNC.ota != null)) {
            this.peE.oNC.ota.oxC = ???.field_snsId;
          }
          ??? = com.tencent.mm.plugin.sns.h.d.ozJ;
          if (???.dFZ != 0)
          {
            if (???.ozK.isEmpty())
            {
              ???.dix.setLong(2, bk.UX());
              ???.ozL.clear();
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[] { Integer.valueOf(???.ozK.size()) });
          }
        }
        com.tencent.mm.plugin.report.service.h.nFQ.aC(13312, "1," + bk.UY());
        com.tencent.mm.sdk.b.a.udP.c(this.peU);
        if (getIntent().getBooleanExtra("is_need_resend_sns", false))
        {
          com.tencent.mm.sdk.platformtools.ai.l(new SnsTimeLineUI.21(this), 500L);
          getIntent().putExtra("is_need_resend_sns", false);
        }
        com.tencent.mm.kernel.g.DQ();
        if (com.tencent.mm.kernel.g.DN().Dc())
        {
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().o(589825, Boolean.valueOf(false));
        }
        this.peE.oNB = this.oWw;
        ??? = this.oWw;
        i = this.peQ.oki;
        localObject1 = this.mActionBar.getCustomView();
        ???.oki = i;
        ???.old = ((View)localObject1);
        ???.activity = this;
        com.tencent.mm.sdk.b.a.udP.c(this.peY);
        com.tencent.mm.sdk.b.a.udP.c(this.peZ);
        com.tencent.mm.sdk.b.a.udP.c(this.pfa);
        com.tencent.mm.sdk.b.a.udP.c(this.pfb);
        com.tencent.mm.sdk.b.a.udP.c(this.pfc);
        com.tencent.mm.sdk.b.a.udP.c(this.pfe);
        com.tencent.mm.sdk.b.a.udP.c(this.pfd);
        com.tencent.mm.sdk.b.a.udP.c(this.otz);
        com.tencent.mm.sdk.b.a.udP.c(this.pff);
        com.tencent.mm.sdk.b.a.udP.c(this.pfg);
        com.tencent.mm.sdk.b.a.udP.c(this.pfi);
        com.tencent.mm.sdk.b.a.udP.c(this.pfh);
        com.tencent.mm.sdk.b.a.udP.c(this.pfj);
        com.tencent.mm.plugin.sns.abtest.c.bCa();
        com.tencent.mm.plugin.sns.abtest.a.d(this, this.peE.ovy);
        if (this.peK != null)
        {
          ??? = this.peK;
          localObject1 = this.peQ.lwE;
          localObject3 = this.peQ.oxg;
          ???.fuF = ((ListView)localObject1);
          ???.oxg = ((SnsHeader)localObject3);
        }
        if ((this.peE != null) && (this.peE.oNC != null))
        {
          ??? = this.peE.oNC.ota;
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
          ???.oxB = true;
          ???.ozy = System.currentTimeMillis();
        }
        boolean bool = getIntent().getBooleanExtra("enter_by_red", false);
        if ((this.peE != null) && (this.peE.oNC != null))
        {
          ??? = this.peE.oNC.ota;
          if (!bool) {
            break label1895;
          }
          i = j;
          ???.oxO = i;
        }
        af.bDC().ooY.clear();
        return;
        ??? = com.tencent.mm.ui.statusbar.c.af(this);
        localObject1 = new SnsTimeLineUI.15(this);
        this.pfl = ((com.tencent.mm.ui.statusbar.c.a)localObject1);
        ???.a((com.tencent.mm.ui.statusbar.c.a)localObject1);
        getWindow().getDecorView().requestApplyInsets();
        com.tencent.mm.ui.statusbar.d.a(getWindow());
        break;
        label1811:
        i = 0;
        break label444;
        label1816:
        if (!this.oNK) {
          break label509;
        }
        this.oNK = af.bDM().bHZ();
        break label509;
        label1836:
        if (!this.oNK) {
          break label747;
        }
        this.oNK = af.bDM().bHZ();
      }
      label1863:
      this.peQ.lwE.setAdapter(this.pey);
      this.peB.setVisibility(0);
      this.pey.mT();
      continue;
      label1895:
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    this.peI = true;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "timeline on destroy");
    com.tencent.mm.sdk.b.a.udP.d(this.peY);
    com.tencent.mm.sdk.b.a.udP.d(this.peZ);
    com.tencent.mm.sdk.b.a.udP.d(this.pfa);
    com.tencent.mm.sdk.b.a.udP.d(this.pfb);
    com.tencent.mm.sdk.b.a.udP.d(this.pfc);
    com.tencent.mm.sdk.b.a.udP.d(this.pfe);
    com.tencent.mm.sdk.b.a.udP.d(this.pfd);
    com.tencent.mm.sdk.b.a.udP.d(this.otz);
    com.tencent.mm.sdk.b.a.udP.d(this.pff);
    com.tencent.mm.sdk.b.a.udP.d(this.pfg);
    com.tencent.mm.sdk.b.a.udP.d(this.pfh);
    com.tencent.mm.sdk.b.a.udP.d(this.pfi);
    com.tencent.mm.sdk.b.a.udP.d(this.pfj);
    long l;
    Object localObject4;
    label337:
    String str;
    if ((this.peE != null) && (this.peE.oNC != null))
    {
      localObject1 = this.peE.oNC.ota;
      if (this.peV)
      {
        i = 1;
        ((com.tencent.mm.plugin.sns.h.b)localObject1).oxP = i;
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.sns.h.d.ozJ;
      if (((com.tencent.mm.plugin.sns.h.d)localObject2).dFZ == 0) {
        break label649;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d, exposureAppIdSize %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sns.h.d)localObject2).ozK.size()), Integer.valueOf(((com.tencent.mm.plugin.sns.h.d)localObject2).ozL.size()) });
      l = ((com.tencent.mm.plugin.sns.h.d)localObject2).dix.getLong(2, 0L);
      if ((((com.tencent.mm.plugin.sns.h.d)localObject2).ozK.isEmpty()) || ((((com.tencent.mm.plugin.sns.h.d)localObject2).ozK.size() <= ((com.tencent.mm.plugin.sns.h.d)localObject2).ozN) && (bk.cn(l) <= ((com.tencent.mm.plugin.sns.h.d)localObject2).ozO))) {
        break label1413;
      }
      localObject3 = new StringBuffer();
      localObject4 = ((com.tencent.mm.plugin.sns.h.d)localObject2).ozK.keySet().iterator();
      j = 0;
      i = 0;
      if (!((Iterator)localObject4).hasNext()) {
        break label490;
      }
      str = (String)((Iterator)localObject4).next();
      localObject1 = (String)((com.tencent.mm.plugin.sns.h.d)localObject2).ozL.get(str);
      if (bk.bl((String)localObject1)) {
        break label478;
      }
      j = 1;
      label384:
      if (!((com.tencent.mm.plugin.sns.h.d)localObject2).ozM.contains(str)) {
        break label485;
      }
    }
    label478:
    label485:
    for (int k = 1;; k = 0)
    {
      ((StringBuffer)localObject3).append(str + "#" + ((com.tencent.mm.plugin.sns.h.d)localObject2).ozK.get(str) + "#" + (String)localObject1 + "#" + k + "|");
      i += 1;
      break label337;
      i = 0;
      break;
      localObject1 = "";
      break label384;
    }
    label490:
    ((StringBuffer)localObject3).append("," + l + "," + bk.UX() + ",1," + j + "," + i + ",1");
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", new Object[] { Integer.valueOf(13226), localObject3 });
    com.tencent.mm.plugin.report.service.h.nFQ.aC(13226, ((StringBuffer)localObject3).toString());
    ((com.tencent.mm.plugin.sns.h.d)localObject2).dix.set(3, null);
    ((com.tencent.mm.plugin.sns.h.d)localObject2).dix.set(4, null);
    ((com.tencent.mm.plugin.sns.h.d)localObject2).ozK.clear();
    ((com.tencent.mm.plugin.sns.h.d)localObject2).ozL.clear();
    ((com.tencent.mm.plugin.sns.h.d)localObject2).ozM.clear();
    ((com.tencent.mm.plugin.sns.h.d)localObject2).dix.setLong(2, bk.UX());
    label649:
    com.tencent.mm.kernel.g.DQ();
    Object localObject3 = (String)com.tencent.mm.kernel.g.DP().Dz().get(68377, null);
    int i = this.pey.getCount();
    Object localObject1 = "";
    Object localObject2 = null;
    if (i > 0)
    {
      localObject2 = this.pey.yy(i - 1);
      localObject1 = com.tencent.mm.plugin.sns.data.i.j((n)localObject2);
    }
    if ((this.peE != null) && (this.peE.oNC != null))
    {
      localObject4 = this.peE.oNC.ota;
      if (localObject2 == null)
      {
        i = -1;
        label745:
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
        l = System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.h.b)localObject4).ozy;
        ((com.tencent.mm.plugin.sns.h.b)localObject4).oxD += l;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + l + " BrowseTime: " + ((com.tencent.mm.plugin.sns.h.b)localObject4).oxD + "BackgroundTime: " + ((com.tencent.mm.plugin.sns.h.b)localObject4).oym);
        localObject2 = af.bDs();
        if (localObject2 != null) {
          ((ah)localObject2).post(new b.2((com.tencent.mm.plugin.sns.h.b)localObject4, i));
        }
        ((com.tencent.mm.plugin.sns.h.b)localObject4).oxB = false;
      }
    }
    else
    {
      localObject2 = com.tencent.mm.modelsns.b.jd(704);
      if (((com.tencent.mm.modelsns.b)localObject2).QT())
      {
        ((com.tencent.mm.modelsns.b)localObject2).cb(this.peV);
        if (bk.bl((String)localObject3)) {
          break label1467;
        }
      }
    }
    int m;
    label1413:
    label1467:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.modelsns.b)localObject2).cb(bool);
      ((com.tencent.mm.modelsns.b)localObject2).ni(this.peJ);
      ((com.tencent.mm.modelsns.b)localObject2).ni((String)localObject1);
      ((com.tencent.mm.modelsns.b)localObject2).ni((String)localObject1);
      ((com.tencent.mm.modelsns.b)localObject2).jg(this.peQ.pip);
      ((com.tencent.mm.modelsns.b)localObject2).ni("");
      com.tencent.mm.modelsns.b.QW();
      ((com.tencent.mm.modelsns.b)localObject2).QX();
      localObject1 = (AdListView)this.peQ.bJB();
      this.peM.otS.clear();
      af.bDw().clean();
      localObject2 = af.bDz();
      af.bDs().post(new i.5((com.tencent.mm.plugin.sns.a.b.i)localObject2));
      ((AdListView)localObject1).oMa.clear();
      ((AdListView)localObject1).oMa = null;
      ((AdListView)localObject1).oMb.bCT();
      ((AdListView)localObject1).oMb = null;
      u.bDa();
      if (!af.bDo()) {
        this.pfq.removeCallbacks(this.peT);
      }
      com.tencent.mm.kernel.g.DQ();
      if (com.tencent.mm.kernel.g.DN().Dc())
      {
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.b(213, this);
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.b(682, this);
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.b(218, this);
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.b(211, this);
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.b(683, this);
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DP().Dz().o(327776, Integer.valueOf(this.peH));
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DP().Dz().o(589825, Boolean.valueOf(false));
      }
      if (this.peE != null)
      {
        localObject1 = this.peE;
        ((i)localObject1).oNP.ch();
        if (((i)localObject1).oNF != null) {
          ((i)localObject1).oNF.bgu();
        }
        com.tencent.mm.sdk.b.a.udP.d(((i)localObject1).oNR);
      }
      af.aXq().removeCallbacks(this.pfr);
      if (this.pey == null) {
        break label1763;
      }
      m = this.peQ.lwE.getFirstVisiblePosition();
      i = 0;
      j = 0;
      while (j < this.peQ.lwE.getCount())
      {
        localObject1 = this.peQ.lwE.getChildAt(j);
        k = i;
        if (localObject1 != null)
        {
          int n = this.peQ.lwE.getPositionForView((View)localObject1);
          k = i;
          if (n == m)
          {
            localObject2 = new int[2];
            ((View)localObject1).getLocationInWindow((int[])localObject2);
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", new Object[] { Integer.valueOf(n), Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]) });
            k = localObject2[1];
          }
        }
        j += 1;
        i = k;
      }
      ((com.tencent.mm.plugin.sns.h.d)localObject2).dix.set(3, ((com.tencent.mm.plugin.sns.h.d)localObject2).ozK);
      ((com.tencent.mm.plugin.sns.h.d)localObject2).dix.set(4, ((com.tencent.mm.plugin.sns.h.d)localObject2).ozL);
      ((com.tencent.mm.plugin.sns.h.d)localObject2).dix.set(5, ((com.tencent.mm.plugin.sns.h.d)localObject2).ozM);
      break;
      i = ((n)localObject2).field_createTime;
      break label745;
    }
    int j = getResources().getDimensionPixelSize(i.d.sns_timeline_top_margin);
    if ((!af.bDo()) && (this.pex.bDv() != null))
    {
      localObject1 = af.bDM();
      localObject2 = this.pey.pgx.jKL;
      localObject3 = this.pey.pgx.oSZ;
      l = this.pex.bDv().oto;
      ((ai)localObject1).oSY = bk.UZ();
      ((ai)localObject1).jKL = ((String)localObject2);
      ((ai)localObject1).oSZ = ((String)localObject3);
      ((ai)localObject1).oto = l;
      ((ai)localObject1).position = m;
      ((ai)localObject1).oTa = (i - j);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", new Object[] { Long.valueOf(((ai)localObject1).oSY), localObject2, localObject3, Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(((ai)localObject1).oTa) });
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsTimeLineUI", "top h %d", new Object[] { Integer.valueOf(i - j) });
    localObject1 = this.pey.pgw;
    com.tencent.mm.sdk.b.a.udP.d(((au)localObject1).giK);
    if (af.bDo()) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
    }
    for (;;)
    {
      localObject1 = this.pey.pgw;
      if (((au)localObject1).oWm != null) {
        ((au)localObject1).oWm.activity = null;
      }
      localObject1 = this.pey.pgw;
      com.tencent.mm.sdk.b.a.udP.d(((au)localObject1).giK);
      this.pey.pgw.bJs();
      label1763:
      ay.clean();
      com.tencent.mm.sdk.b.a.udP.d(this.peU);
      com.tencent.mm.kernel.g.DQ();
      if (com.tencent.mm.kernel.g.DN().Dc()) {
        af.bDC().ooY.clear();
      }
      localObject1 = this.pey;
      ((aw)localObject1).pgx.removeVendingDataChangedCallback(((aw)localObject1).pgz);
      ((aw)localObject1).pgz = null;
      this.pey = null;
      this.peE = null;
      aw.bJO();
      com.tencent.mm.plugin.sns.abtest.c.bCb();
      localObject1 = af.bDw();
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(291, (com.tencent.mm.ah.f)localObject1);
      com.tencent.mm.plugin.sns.abtest.a.clean();
      this.peQ.onDestroy();
      super.onDestroy();
      com.tencent.mm.kiss.widget.textview.c.dNE.EE();
      return;
      af.bDC();
    }
  }
  
  public void onDrag()
  {
    super.onDrag();
  }
  
  public final void onKeyboardStateChanged()
  {
    super.onKeyboardStateChanged();
    com.tencent.mm.sdk.platformtools.ai.d(new SnsTimeLineUI.37(this));
    if (this.mController.uNh == 2) {
      if ((this.peE != null) && (this.peE.oNF != null) && (!this.peE.oNF.bIJ())) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
      }
    }
    i locali;
    do
    {
      do
      {
        return;
      } while ((this.mController.uNh != 1) || (this.peE == null));
      locali = this.peE;
    } while (!locali.oND);
    locali.oND = false;
    locali.oNG.bKh();
  }
  
  public void onPause()
  {
    this.peB.clearAnimation();
    WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcSNSScrollEnable, this.dmY);
    this.dmY = 0;
    u.b(this);
    af.bDC().opa = null;
    Object localObject = new si();
    ((si)localObject).cbT.type = 1;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    if (this.pey != null)
    {
      localObject = this.pey.pgw;
      com.tencent.mm.sdk.b.a.udP.d(((au)localObject).oWI);
      com.tencent.mm.sdk.b.a.udP.d(((au)localObject).oWH);
      com.tencent.mm.sdk.b.a.udP.d(((au)localObject).oWJ);
    }
    if ((this.peE != null) && (this.peE.oNB != null)) {
      this.peE.oNB.onPause();
    }
    if ((this.peE != null) && (this.peE.oNC != null)) {
      this.peE.oNC.ota.iW(false);
    }
    com.tencent.mm.modelstat.d.h("SnsTimeLineUI", this.iaq, bk.UX());
    ba.onPause();
    super.onPause();
    com.tencent.mm.sdk.b.a.udP.d(this.peX);
    com.tencent.mm.sdk.b.a.udP.d(this.peW);
    ((com.tencent.matrix.trace.a)com.tencent.matrix.a.qO().l(com.tencent.matrix.trace.a.class)).bqu.b(this.kho);
    if (bk.UX() > this.ekk) {}
    for (long l = bk.UX() - this.ekk;; l = 1L)
    {
      this.ekk = l;
      WXHardCoderJNI.reportFPS(701, WXHardCoderJNI.hcSNSScrollAction, 1, this.dFe, this.ekk);
      this.dFe = 0L;
      this.ekk = 0L;
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bJz();
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = i.j.permission_camera_request_again_msg; paramArrayOfInt[0] != 0; paramInt = i.j.permission_microphone_request_again_msg)
      {
        com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(i.j.permission_tips_title), getString(i.j.jump_to_settings), getString(i.j.app_cancel), false, new SnsTimeLineUI.53(this), new SnsTimeLineUI.54(this));
        return;
      }
    }
  }
  
  public void onResume()
  {
    this.ekk = bk.UX();
    ((com.tencent.matrix.trace.a)com.tencent.matrix.a.qO().l(com.tencent.matrix.trace.a.class)).bqu.a(this.kho);
    if ((com.tencent.mm.sdk.a.b.cqk()) && (com.tencent.mm.sdk.a.b.cqi())) {
      wuA.add(this);
    }
    ba.onResume();
    super.onResume();
    this.iaq = bk.UX();
    int i;
    Object localObject2;
    n localn;
    Object localObject1;
    if (this.pfu)
    {
      this.pfu = false;
      i = this.pey.getCount();
      if (getIntent().getBooleanExtra("is_from_find_more", false))
      {
        localObject2 = com.tencent.mm.modelsns.b.c(getIntent(), "enter_log");
        if (localObject2 != null)
        {
          if (i <= 0) {
            break label681;
          }
          localn = this.pey.yy(0);
          if (localn != null) {
            break label647;
          }
          localObject1 = "0";
          ((com.tencent.mm.modelsns.b)localObject2).ni((String)localObject1);
          if (localn != null) {
            break label659;
          }
          localObject1 = "0";
          label155:
          ((com.tencent.mm.modelsns.b)localObject2).ni((String)localObject1);
          ((com.tencent.mm.modelsns.b)localObject2).ni(String.valueOf(i));
          label172:
          ((com.tencent.mm.modelsns.b)localObject2).QX();
        }
      }
    }
    if (this.mScreenWidth == 0)
    {
      localObject1 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
      this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
      localObject1 = this.peK;
      i = this.mScreenWidth;
      int j = this.mScreenHeight;
      ((com.tencent.mm.plugin.sns.h.a)localObject1).mScreenWidth = i;
      ((com.tencent.mm.plugin.sns.h.a)localObject1).mScreenHeight = j;
    }
    if (af.bDo()) {
      finish();
    }
    af.bDC().opa = this.pey.pgw;
    EB().ae(c.b.class);
    u.a(this);
    if (this.peD) {
      this.peB.post(new SnsTimeLineUI.26(this));
    }
    for (;;)
    {
      localObject1 = new si();
      ((si)localObject1).cbT.cbU = this.peQ.lwE.getFirstVisiblePosition();
      ((si)localObject1).cbT.cbV = this.peQ.lwE.getLastVisiblePosition();
      ((si)localObject1).cbT.cbW = this.peQ.lwE.getHeaderViewsCount();
      ((si)localObject1).cbT.type = 0;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      if ((this.peE != null) && (this.peE.oNB != null)) {
        this.peE.oNB.onResume();
      }
      if (this.pey != null)
      {
        localObject1 = this.pey.pgw;
        com.tencent.mm.sdk.b.a.udP.c(((au)localObject1).oWI);
        com.tencent.mm.sdk.b.a.udP.c(((au)localObject1).oWH);
        com.tencent.mm.sdk.b.a.udP.c(((au)localObject1).oWJ);
      }
      if ((this.peE != null) && (this.peE.oNC != null))
      {
        this.peE.oNC.ota.iW(true);
        this.peE.oNC.ota.iX(false);
        this.peE.oNC.ota.iY(false);
        this.peE.oNC.ota.iZ(false);
        this.peE.oNC.ota.jj(false);
        localObject1 = this.peE.oNC.ota;
        ((com.tencent.mm.plugin.sns.h.b)localObject1).jh(false);
        ((com.tencent.mm.plugin.sns.h.b)localObject1).ji(false);
        ((com.tencent.mm.plugin.sns.h.b)localObject1).jb(false);
        ((com.tencent.mm.plugin.sns.h.b)localObject1).jg(false);
        ((com.tencent.mm.plugin.sns.h.b)localObject1).je(false);
        ((com.tencent.mm.plugin.sns.h.b)localObject1).jg(false);
        ((com.tencent.mm.plugin.sns.h.b)localObject1).jk(false);
        ((com.tencent.mm.plugin.sns.h.b)localObject1).jf(false);
        ((com.tencent.mm.plugin.sns.h.b)localObject1).jg(false);
        ((com.tencent.mm.plugin.sns.h.b)localObject1).jc(false);
        ((com.tencent.mm.plugin.sns.h.b)localObject1).jd(false);
      }
      localObject1 = af.bDC();
      ((com.tencent.mm.plugin.sns.model.g)localObject1).opb = 0L;
      ((com.tencent.mm.plugin.sns.model.g)localObject1).opc = 0L;
      com.tencent.mm.sdk.b.a.udP.c(this.peX);
      com.tencent.mm.sdk.b.a.udP.c(this.peW);
      return;
      label647:
      localObject1 = com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId);
      break;
      label659:
      localObject1 = localn.field_createTime;
      break label155;
      label681:
      ((com.tencent.mm.modelsns.b)localObject2).ni("");
      ((com.tencent.mm.modelsns.b)localObject2).ni("");
      ((com.tencent.mm.modelsns.b)localObject2).ni("0");
      break label172;
      localObject1 = this.peF;
      if (((SnsTimeLineUI.a)localObject1).pfC.peB.getVisibility() == 0)
      {
        ((SnsTimeLineUI.a)localObject1).init();
        localObject2 = (AbsoluteLayout.LayoutParams)((SnsTimeLineUI.a)localObject1).pfC.peB.getLayoutParams();
        ((AbsoluteLayout.LayoutParams)localObject2).y = ((int)((SnsTimeLineUI.a)localObject1).pfT);
        ((SnsTimeLineUI.a)localObject1).pfC.peB.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((SnsTimeLineUI.a)localObject1).pfC.peB.invalidate();
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType());
    if (paramm.getType() == 218)
    {
      paramString = (r)paramm;
      if (((paramString.type == 1) || (paramString.type == 6) || (paramString.type == 4)) && (this.peE.oNQ != null)) {
        this.peE.oNQ.dismiss();
      }
      if (paramString.type == 11)
      {
        if (this.peQ.tipDialog != null) {
          this.peQ.tipDialog.dismiss();
        }
        if (this.pfx != null) {
          this.pfx.setImageResource(i.i.common_icons_camera);
        }
      }
    }
    if (this.pey != null) {
      this.pey.pgx.notifyVendingDataChange();
    }
    if (paramm.getType() == 211)
    {
      paramString = (com.tencent.mm.plugin.sns.model.y)paramm;
      if (!paramString.opP) {
        break label369;
      }
      paramm = com.tencent.mm.modelsns.b.jd(727);
      paramm.jg(this.pey.getCount()).jg(paramString.Zn);
      paramm.QX();
    }
    for (;;)
    {
      if (this.peF != null)
      {
        this.peD = false;
        paramString = this.peF;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsTimeLineUI", "play end vis: %d, sumY %f MAX_Y %f", new Object[] { Integer.valueOf(paramString.pfC.peB.getVisibility()), Float.valueOf(paramString.pfU), Float.valueOf(paramString.pfS) });
        if (paramString.pfC.peB.getVisibility() == 0)
        {
          paramString.init();
          if (paramString.pfU >= paramString.pfS)
          {
            paramString.pfC.peB.clearAnimation();
            paramString.pfC.peB.startAnimation(paramString);
            paramString.setDuration(1200L);
            paramString.pfW = false;
          }
        }
      }
      return;
      label369:
      paramm = com.tencent.mm.modelsns.b.jd(728);
      paramm.jg(this.pey.getCount()).jg(paramString.Zn).jg(0);
      paramm.QX();
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return super.supportNavigationSwipeBack();
  }
  
  public final void ta(int paramInt)
  {
    super.ta(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.pfk != null))
    {
      this.pfk.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.a(getWindow());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI
 * JD-Core Version:    0.7.0.1
 */