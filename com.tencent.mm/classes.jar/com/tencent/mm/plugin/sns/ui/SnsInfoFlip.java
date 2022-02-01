package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.f.a.wr;
import com.tencent.mm.f.b.a.fo;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.g.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.d;
import com.tencent.mm.ui.base.MMViewPager.f;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SnsInfoFlip
  extends FlipView
{
  MMViewPager CcM;
  private int KKq;
  int KOa;
  private boolean KOn;
  private boolean KOp;
  c KRM;
  private com.tencent.mm.ui.base.g KRN;
  private boolean KRO;
  HashMap<Integer, Integer> KRP;
  HashMap<Integer, Long> KRQ;
  HashMap<Integer, Long> KRR;
  private boolean KRS;
  private boolean KRT;
  private boolean KRU;
  private boolean KRV;
  private boolean KRW;
  private boolean KRX;
  private float KRY;
  MMPageControlView KRZ;
  private Runnable KSa;
  private String KSb;
  private int KSc;
  long KSd;
  private b KSe;
  private HashMap<String, SnsInfo> KSf;
  private HashSet<String> KSg;
  public int KSh;
  private HashMap<String, a> KSi;
  private Context context;
  private MMHandler handler;
  boolean isAd;
  List<com.tencent.mm.plugin.sns.j.b> lxh;
  public String username;
  
  public SnsInfoFlip(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98759);
    this.isAd = false;
    this.KRO = true;
    this.KRP = new HashMap();
    this.KRQ = new HashMap();
    this.KRR = new HashMap();
    this.KRS = false;
    this.KRT = false;
    this.KRU = false;
    this.KRV = false;
    this.KRW = true;
    this.KRX = true;
    this.KRY = 1.0F;
    this.KSa = null;
    this.handler = new MMHandler();
    this.KSb = "";
    this.KSc = -1;
    this.KOa = -1;
    this.KOn = false;
    this.KOp = false;
    this.KSd = 0L;
    this.KKq = 0;
    this.KSf = new HashMap();
    this.KSg = new HashSet();
    this.KSh = 0;
    this.KSi = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98759);
  }
  
  public SnsInfoFlip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98758);
    this.isAd = false;
    this.KRO = true;
    this.KRP = new HashMap();
    this.KRQ = new HashMap();
    this.KRR = new HashMap();
    this.KRS = false;
    this.KRT = false;
    this.KRU = false;
    this.KRV = false;
    this.KRW = true;
    this.KRX = true;
    this.KRY = 1.0F;
    this.KSa = null;
    this.handler = new MMHandler();
    this.KSb = "";
    this.KSc = -1;
    this.KOa = -1;
    this.KOn = false;
    this.KOp = false;
    this.KSd = 0L;
    this.KKq = 0;
    this.KSf = new HashMap();
    this.KSg = new HashSet();
    this.KSh = 0;
    this.KSi = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98758);
  }
  
  private void b(cvt paramcvt, int paramInt, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(98764);
    if (this.KSe != null) {
      this.KSe.a(paramcvt, paramInt, paramString);
    }
    Object localObject = aj.fOI().bbl(paramString);
    if (localObject != null) {
      com.tencent.mm.plugin.sns.ui.a.c.i((SnsInfo)localObject, paramInt);
    }
    if (this.KSc == -1) {
      this.KSc = paramInt;
    }
    if ((Util.isNullOrNil(paramString)) && (this.KRM != null))
    {
      i = this.KRM.getCount();
      paramcvt = paramInt + 1 + " / " + i;
      this.KDs.lm(paramcvt, null);
      AppMethodBeat.o(98764);
      return;
    }
    SnsInfo localSnsInfo = (SnsInfo)this.KSf.get(paramString);
    localObject = localSnsInfo;
    if (localSnsInfo == null)
    {
      localObject = aj.fOI().bbl(paramString);
      this.KSf.put(paramString, localObject);
    }
    if (localObject == null)
    {
      AppMethodBeat.o(98764);
      return;
    }
    if (paramcvt.rWu != 6) {
      aj.etE().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98735);
          if (SnsInfoFlip.d(SnsInfoFlip.this) != null) {
            SnsInfoFlip.d(SnsInfoFlip.this).fWv();
          }
          AppMethodBeat.o(98735);
        }
      });
    }
    Log.d("MicroMsg.SnsInfoFlip", "onItemSelected " + paramInt + " localId " + paramString);
    long l1;
    if (this.KOa != paramInt)
    {
      if (!this.KRP.containsKey(Integer.valueOf(paramInt))) {
        break label828;
      }
      i = ((Integer)this.KRP.get(Integer.valueOf(paramInt))).intValue();
      this.KRP.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
      this.KRQ.put(Integer.valueOf(paramInt), Long.valueOf(Util.currentTicks()));
      if (this.KOa >= 0)
      {
        if (!this.KRQ.containsKey(Integer.valueOf(this.KOa))) {
          break label834;
        }
        l1 = ((Long)this.KRQ.get(Integer.valueOf(this.KOa))).longValue();
        label361:
        if (l1 > 0L)
        {
          this.KRQ.put(Integer.valueOf(this.KOa), Long.valueOf(0L));
          if (this.KRR.containsKey(Integer.valueOf(this.KOa))) {
            l2 = ((Long)this.KRR.get(Integer.valueOf(this.KOa))).longValue();
          }
          l1 = Util.ticksToNow(l1);
          l2 += l1;
          this.KRR.put(Integer.valueOf(this.KOa), Long.valueOf(l2));
          Log.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + this.KOa + " curtime " + l2 + " passtime " + l1 / 1000.0D);
        }
      }
      if ((this.KOn) && (this.KRM != null))
      {
        paramcvt = this.KRM.ahk(this.KOa);
        if (paramcvt != null)
        {
          paramcvt = paramcvt.fVT.Id;
          Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, bigPicId:%s", new Object[] { paramcvt });
          if (this.KSi.containsKey(paramcvt))
          {
            paramcvt = (a)this.KSi.get(paramcvt);
            paramcvt.networkType = getReportNetworkType();
            if (paramcvt.KSm == -1L) {
              break label840;
            }
            paramcvt.KSk = 1;
            paramcvt.KbH = (paramcvt.KSm - paramcvt.KSl);
            Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load success, costTime:%d", new Object[] { Long.valueOf(paramcvt.KbH) });
          }
        }
      }
    }
    label648:
    this.KOa = paramInt;
    if (this.KDr != null) {
      this.KDr.bbQ(paramString);
    }
    int i = ((SnsInfo)localObject).getCreateTime();
    paramcvt = ((SnsInfo)localObject).getTimeLine();
    localObject = bo.t(this.context, i * 1000L);
    if ((paramcvt != null) && (paramcvt.ContentObj != null) && (paramcvt.ContentObj.Sqr.size() > 1) && (this.KRM != null)) {
      i = paramcvt.ContentObj.Sqr.size();
    }
    for (paramcvt = this.KRM.ahk(paramInt).KeQ + 1 + " / " + i;; paramcvt = null)
    {
      this.KDs.lm(String.valueOf(localObject), paramcvt);
      this.KDs.gm(paramString, paramInt);
      if (this.KRM != null) {
        c.a(this.KRM, paramInt);
      }
      AppMethodBeat.o(98764);
      return;
      label828:
      i = 0;
      break;
      label834:
      l1 = 0L;
      break label361;
      label840:
      paramcvt.KSk = 2;
      paramcvt.KSm = System.currentTimeMillis();
      paramcvt.KbH = (paramcvt.KSm - paramcvt.KSl);
      Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load failed, costTime:%d", new Object[] { Long.valueOf(paramcvt.KbH) });
      break label648;
    }
  }
  
  private void fWs()
  {
    AppMethodBeat.i(98767);
    if ((this.KRM == null) || (this.KRM.ahk(this.CcM.getCurrentItem()) == null))
    {
      AppMethodBeat.o(98767);
      return;
    }
    int i = this.CcM.getCurrentItem();
    if ((this.KRS) && (this.KRM.getCount() > 1))
    {
      this.KRZ.setVisibility(0);
      this.KRZ.setPage(i);
    }
    cvt localcvt = this.KRM.ahk(this.CcM.getCurrentItem()).fVT;
    this.KSg.add(localcvt.Id);
    String str1 = this.KRM.ahk(this.CcM.getCurrentItem()).parentId;
    String str2 = localcvt.Id;
    if ((Util.isNullOrNil(this.KSb)) || (!this.KSb.equals(str2))) {
      this.KSb = "";
    }
    b(localcvt, i, str1);
    AppMethodBeat.o(98767);
  }
  
  private int getReportNetworkType()
  {
    AppMethodBeat.i(98777);
    Context localContext = MMApplicationContext.getContext();
    if (NetStatusUtil.is2G(localContext))
    {
      AppMethodBeat.o(98777);
      return 1;
    }
    if (NetStatusUtil.is3G(localContext))
    {
      AppMethodBeat.o(98777);
      return 2;
    }
    if (NetStatusUtil.is4G(localContext))
    {
      AppMethodBeat.o(98777);
      return 3;
    }
    if (NetStatusUtil.isWifi(localContext))
    {
      AppMethodBeat.o(98777);
      return 4;
    }
    AppMethodBeat.o(98777);
    return 0;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(98760);
    this.KSd = System.currentTimeMillis();
    this.context = paramContext;
    this.CcM = ((MMViewPager)inflate(paramContext, i.g.sns_info_flip_view, this).findViewById(i.f.gallery));
    this.CcM.setVerticalFadingEdgeEnabled(false);
    this.CcM.setHorizontalFadingEdgeEnabled(false);
    this.CcM.setOffscreenPageLimit(1);
    this.CcM.setSingleClickOverListener(new MMViewPager.f()
    {
      public final void bwB()
      {
        AppMethodBeat.i(98733);
        if (SnsInfoFlip.b(SnsInfoFlip.this)) {
          SnsInfoFlip.c(SnsInfoFlip.this);
        }
        AppMethodBeat.o(98733);
      }
      
      public final void euS()
      {
        AppMethodBeat.i(98734);
        SnsInfoFlip.c(SnsInfoFlip.this);
        AppMethodBeat.o(98734);
      }
    });
    this.KRZ = ((MMPageControlView)findViewById(i.f.what_news_page_control));
    this.KRZ.setIndicatorLayoutRes(i.g.snspage_control_image);
    paramContext = (LinearLayout.LayoutParams)this.KRZ.getLayoutParams();
    paramContext.bottomMargin += com.tencent.mm.ui.ax.aB(getContext());
    this.KRZ.setLayoutParams(paramContext);
    t.JRG = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUk, 3200);
    AppMethodBeat.o(98760);
  }
  
  public final void a(List<com.tencent.mm.plugin.sns.j.b> paramList, String paramString, int paramInt, aa paramaa, y.a parama)
  {
    AppMethodBeat.i(98765);
    aj.fOD().a(this);
    this.lxh = paramList;
    an.PE(paramString);
    this.KDr = paramaa;
    this.KDs = parama;
    this.KRM = new c(this.context);
    this.CcM.setAdapter(this.KRM);
    if ((paramInt >= 0) && (paramInt < this.lxh.size()))
    {
      this.CcM.setCurrentItem(paramInt);
      if (this.KRX)
      {
        this.KRX = false;
        paramList = this.KRM.ahk(paramInt).fVT;
        if ((paramList == null) || (paramList.TDH == null) || (paramList.TDH.TEv <= 0.0F)) {
          break label341;
        }
      }
    }
    label341:
    for (this.KRY = (paramList.TDH.TEu / paramList.TDH.TEv);; this.KRY = 1.0F)
    {
      this.CcM.setFadingEdgeLength(0);
      this.CcM.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(98736);
          if (SnsInfoFlip.d(SnsInfoFlip.this) != null)
          {
            if ((SnsInfoFlip.e(SnsInfoFlip.this)) && (SnsInfoFlip.d(SnsInfoFlip.this).getCount() > 1))
            {
              SnsInfoFlip.f(SnsInfoFlip.this).setVisibility(0);
              SnsInfoFlip.f(SnsInfoFlip.this).setPage(paramAnonymousInt);
            }
            Object localObject1 = SnsInfoFlip.d(SnsInfoFlip.this).ahk(paramAnonymousInt).fVT;
            Object localObject2 = SnsInfoFlip.d(SnsInfoFlip.this).ahk(paramAnonymousInt).parentId;
            SnsInfoFlip.a(SnsInfoFlip.this, (cvt)localObject1, paramAnonymousInt, (String)localObject2);
            localObject2 = SnsInfoFlip.d(SnsInfoFlip.this).Tf(paramAnonymousInt);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = SnsInfoFlip.d(SnsInfoFlip.this).Tg(paramAnonymousInt);
            }
            SnsInfoFlip.a(SnsInfoFlip.this, (com.tencent.mm.ui.base.g)localObject1);
            if (localObject1 != null) {
              ((com.tencent.mm.ui.base.g)localObject1).hJx();
            }
            if ((SnsInfoFlip.g(SnsInfoFlip.this) instanceof SnsBrowseUI)) {
              ((SnsBrowseUI)SnsInfoFlip.g(SnsInfoFlip.this)).fVZ();
            }
            SnsInfoFlip.d(SnsInfoFlip.this).ahh(paramAnonymousInt);
          }
          AppMethodBeat.o(98736);
        }
      });
      this.CcM.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(270569);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(270569);
            return false;
            paramAnonymousView = ad.beh().I("basescanui@datacenter", true);
            if ((SnsInfoFlip.h(SnsInfoFlip.this) instanceof View))
            {
              PointF localPointF = com.tencent.mm.plugin.scanner.util.n.g((View)SnsInfoFlip.h(SnsInfoFlip.this), paramAnonymousMotionEvent.getRawX(), paramAnonymousMotionEvent.getRawY());
              if (localPointF != null)
              {
                paramAnonymousView.k("key_basescanui_touch_normalize_x", Float.valueOf(localPointF.x));
                paramAnonymousView.k("key_basescanui_touch_normalize_y", Float.valueOf(localPointF.y));
              }
              else
              {
                Log.e("MicroMsg.SnsInfoFlip", "alvinluo get touchCoordinate is invalid");
                paramAnonymousView.k("key_basescanui_screen_position", Boolean.TRUE);
                paramAnonymousView.k("key_basescanui_screen_x", Float.valueOf(paramAnonymousMotionEvent.getRawX()));
                paramAnonymousView.k("key_basescanui_screen_y", Float.valueOf(paramAnonymousMotionEvent.getRawY()));
              }
            }
          }
        }
      });
      if (this.KRO) {
        this.CcM.setLongClickOverListener(new MMViewPager.d()
        {
          public final void bwC()
          {
            AppMethodBeat.i(231836);
            if (!SnsInfoFlip.i(SnsInfoFlip.this))
            {
              AppMethodBeat.o(231836);
              return;
            }
            if (SnsInfoFlip.d(SnsInfoFlip.this) == null)
            {
              Log.e("MicroMsg.SnsInfoFlip", "longClickOver, adapter is null.");
              AppMethodBeat.o(231836);
              return;
            }
            com.tencent.mm.plugin.sns.j.b localb = SnsInfoFlip.d(SnsInfoFlip.this).ahk(SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem());
            if ((localb == null) || (Util.isNullOrNil(localb.parentId)))
            {
              AppMethodBeat.o(231836);
              return;
            }
            if (SnsInfoFlip.this.aHT != null) {
              SnsInfoFlip.this.aHT.onLongClick(SnsInfoFlip.j(SnsInfoFlip.this));
            }
            Object localObject1 = new fo();
            ((fo)localObject1).gef = 1L;
            if (SnsInfoFlip.k(SnsInfoFlip.this)) {}
            for (((fo)localObject1).gBe = 6L;; ((fo)localObject1).gBe = 7L)
            {
              Object localObject2 = SnsInfoFlip.d(SnsInfoFlip.this).ahk(SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem()).fVT;
              ((fo)localObject1).uU(((cvt)localObject2).Url);
              ((fo)localObject1).bpa();
              localObject1 = ((cvt)localObject2).Id;
              localObject2 = aq.kD(aj.getAccSnsPath(), (String)localObject1) + t.k(SnsInfoFlip.d(SnsInfoFlip.this).ahk(SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem()).fVT);
              SnsInfoFlip.this.i((String)localObject2, localb.parentId, (String)localObject1, true);
              AppMethodBeat.o(231836);
              return;
            }
          }
        });
      }
      if ((this.KRS) && (this.KRM.getCount() > 1))
      {
        this.KRZ.setVisibility(0);
        this.KRZ.mp(this.KRM.getCount(), paramInt);
      }
      if ((this.KOp) && (!Util.isNullOrNil(this.KRM.ahk(paramInt).parentId)))
      {
        paramList = this.KRM.ahk(paramInt).fVT.Id;
        bbN(aq.kD(aj.getAccSnsPath(), paramList) + t.k(this.KRM.ahk(paramInt).fVT));
      }
      AppMethodBeat.o(98765);
      return;
    }
  }
  
  public final void bPQ()
  {
    AppMethodBeat.i(242683);
    if ((this.KRM == null) || (this.CcM == null))
    {
      AppMethodBeat.o(242683);
      return;
    }
    try
    {
      int i = this.CcM.getCurrentItem();
      com.tencent.mm.plugin.sns.j.b localb = this.KRM.ahk(i);
      String str = localb.fVT.Id;
      i(aq.kD(aj.getAccSnsPath(), str) + t.k(this.KRM.ahk(this.CcM.getCurrentItem()).fVT), localb.parentId, str, true);
      AppMethodBeat.o(242683);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(242683);
    }
  }
  
  public final void cq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98776);
    Object localObject = new StringBuilder("onSightFinish ").append(paramString).append(" ").append(paramBoolean).append(" ");
    if (this.KRM == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsInfoFlip", bool);
      if (this.KRM != null) {
        break;
      }
      AppMethodBeat.o(98776);
      return;
    }
    if ((!paramBoolean) && (this.KRM.ahk(this.CcM.getCurrentItem()) != null))
    {
      localObject = this.KRM.ahk(this.CcM.getCurrentItem()).fVT;
      if ((localObject != null) && (((cvt)localObject).Id != null) && (((cvt)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(i.j.sns_down_sight_error), 0).show();
        this.KSb = paramString;
      }
    }
    this.KRM.notifyDataSetChanged();
    AppMethodBeat.o(98776);
  }
  
  public final void cr(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(98775);
    if (this.KRM == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsInfoFlip", "onImageFinish, mediaId: %s, isOK: %s, null == adapter: %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (this.KRM != null) {
        break;
      }
      AppMethodBeat.o(98775);
      return;
    }
    cvt localcvt = this.KRM.ahk(this.CcM.getCurrentItem()).fVT;
    if ((!paramBoolean) && (localcvt != null) && (localcvt != null) && (localcvt.Id != null) && (localcvt.Id.equals(paramString)))
    {
      Toast.makeText(this.context, this.context.getString(i.j.sns_down_error), 0).show();
      this.KSb = paramString;
    }
    this.KSh += 1;
    Object localObject;
    if (this.KOn)
    {
      localObject = "";
      if (localcvt != null) {
        localObject = localcvt.Id;
      }
      Log.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b, mediaId:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), localObject });
      if ((paramBoolean) && (this.KSi.containsKey(paramString)))
      {
        localObject = (a)this.KSi.get(paramString);
        ((a)localObject).KSm = System.currentTimeMillis();
        ((a)localObject).networkType = getReportNetworkType();
        Log.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
      }
    }
    int j;
    if ((localcvt != null) && (localcvt != null) && (localcvt.Id != null) && (localcvt.Id.equals(paramString)))
    {
      Log.i("MicroMsg.SnsInfoFlip", "img download finish, refresh ui, media id: %s. and mediaLocal id %s", new Object[] { localcvt.Id, Integer.valueOf(localcvt.fWh) });
      localObject = this.KRM;
      j = ((c)localObject).KSj.lxh.size();
    }
    for (;;)
    {
      if (i < j)
      {
        com.tencent.mm.plugin.sns.j.b localb = ((c)localObject).ahk(i);
        if ((localb != null) && (localb.fVT.Id.equals(paramString))) {
          ((c)localObject).ahh(i);
        }
      }
      else
      {
        if (this.KOp) {
          F(localcvt);
        }
        AppMethodBeat.o(98775);
        return;
      }
      i += 1;
    }
  }
  
  public final boolean fTE()
  {
    return this.KOn;
  }
  
  public final int fWt()
  {
    AppMethodBeat.i(98770);
    if ((this.CcM == null) || (this.KRM == null))
    {
      AppMethodBeat.o(98770);
      return -1;
    }
    int i = this.CcM.getCurrentItem();
    if ((i >= 0) && (this.lxh.size() > i))
    {
      this.lxh.remove(i);
      this.KRM.notifyDataSetChanged();
      fWs();
    }
    i = this.KRM.getCount();
    AppMethodBeat.o(98770);
    return i;
  }
  
  public final void fWu()
  {
    AppMethodBeat.i(98778);
    Iterator localIterator = this.KSi.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      SnsInfo localSnsInfo;
      String str;
      BitmapFactory.Options localOptions;
      int k;
      int j;
      int i;
      int m;
      if (locala.KSk != -1)
      {
        localSnsInfo = aj.fOI().bbl(locala.fCM);
        str = aq.kD(aj.getAccSnsPath(), locala.KSo) + t.k(locala.JVq);
        localOptions = BitmapUtil.getImageOptions(str);
        k = 0;
        j = 0;
        i = (int)u.bBQ(str);
        if (localOptions != null)
        {
          k = localOptions.outWidth;
          j = localOptions.outHeight;
          i = (int)u.bBQ(str);
        }
        m = t.aLV(str);
        if (locala.JVq.mediaType != 0) {
          m = locala.JVq.mediaType;
        }
        if (localSnsInfo != null)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(11601, new Object[] { Integer.valueOf(locala.lqa), Integer.valueOf(locala.KSk), Long.valueOf(locala.KbH), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.KSl), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          Log.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.lqa), Integer.valueOf(locala.KSk), Long.valueOf(locala.KbH), Integer.valueOf(locala.networkType), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.KSl), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(t.aLV(str)), str });
        }
      }
      else if (locala.KSl != -1L)
      {
        if (locala.KSm != -1L) {
          locala.KSk = 1;
        }
        for (;;)
        {
          locala.KbH = (locala.KSm - locala.KSl);
          localSnsInfo = aj.fOI().bbl(locala.fCM);
          str = aq.kD(aj.getAccSnsPath(), locala.KSo) + t.k(locala.JVq);
          localOptions = BitmapUtil.getImageOptions(str);
          k = 0;
          j = 0;
          i = (int)u.bBQ(str);
          if (localOptions != null)
          {
            k = localOptions.outWidth;
            j = localOptions.outHeight;
            i = (int)u.bBQ(str);
          }
          m = t.aLV(str);
          if (locala.JVq.mediaType != 0) {
            m = locala.JVq.mediaType;
          }
          if (localSnsInfo == null) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(11601, new Object[] { Integer.valueOf(locala.lqa), Integer.valueOf(locala.KSk), Long.valueOf(locala.KbH), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.KSl), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          Log.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.lqa), Integer.valueOf(locala.KSk), Long.valueOf(locala.KbH), Integer.valueOf(locala.networkType), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.KSl), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(t.aLV(str)), str });
          break;
          locala.KSk = 2;
          locala.KSm = System.currentTimeMillis();
        }
      }
    }
    this.KSi.clear();
    AppMethodBeat.o(98778);
  }
  
  public cvt getCntMedia()
  {
    AppMethodBeat.i(98772);
    if (this.KRM != null)
    {
      int i = this.CcM.getCurrentItem();
      if ((this.lxh != null) && (i < this.lxh.size()))
      {
        cvt localcvt = this.KRM.ahk(i).fVT;
        AppMethodBeat.o(98772);
        return localcvt;
      }
    }
    AppMethodBeat.o(98772);
    return null;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(98771);
    if (this.KRM != null)
    {
      int i = this.KRM.getCount();
      AppMethodBeat.o(98771);
      return i;
    }
    AppMethodBeat.o(98771);
    return 0;
  }
  
  public View getCurrentImageView()
  {
    if ((this.KRN instanceof View)) {
      return (View)this.KRN;
    }
    return null;
  }
  
  public List<com.tencent.mm.plugin.sns.j.b> getFlipList()
  {
    return this.lxh;
  }
  
  public bp getFromScene()
  {
    return this.JRq;
  }
  
  public MMViewPager getGallery()
  {
    return this.CcM;
  }
  
  public int getNumOfFileExist()
  {
    AppMethodBeat.i(98774);
    Iterator localIterator = this.lxh.iterator();
    int k = 0;
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.sns.j.b localb = (com.tencent.mm.plugin.sns.j.b)localIterator.next();
        aj.fOF();
        j = i;
        if (u.agG(com.tencent.mm.plugin.sns.model.g.D(localb.fVT))) {
          j = i + 1;
        }
        k += 1;
        if (k <= 9) {}
      }
      else
      {
        AppMethodBeat.o(98774);
        return j;
      }
    }
  }
  
  public int getPosition()
  {
    return this.KOa;
  }
  
  public int getSelectCount()
  {
    AppMethodBeat.i(98773);
    int i = this.KSg.size();
    AppMethodBeat.o(98773);
    return i;
  }
  
  public String getSelectId()
  {
    AppMethodBeat.i(98763);
    Object localObject = getSelectItem();
    if (localObject == null)
    {
      AppMethodBeat.o(98763);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.sns.j.b)localObject).parentId;
    AppMethodBeat.o(98763);
    return localObject;
  }
  
  public com.tencent.mm.plugin.sns.j.b getSelectItem()
  {
    AppMethodBeat.i(98761);
    if ((this.CcM != null) && (this.KRM != null))
    {
      int i = this.CcM.getCurrentItem();
      com.tencent.mm.plugin.sns.j.b localb = this.KRM.ahk(i);
      AppMethodBeat.o(98761);
      return localb;
    }
    AppMethodBeat.o(98761);
    return null;
  }
  
  public String getSelectedMediaId()
  {
    AppMethodBeat.i(98762);
    Object localObject = getCntMedia();
    if (localObject != null)
    {
      localObject = ((cvt)localObject).Id;
      AppMethodBeat.o(98762);
      return localObject;
    }
    AppMethodBeat.o(98762);
    return null;
  }
  
  public long getSnsId()
  {
    AppMethodBeat.i(98766);
    if (this.KRM == null)
    {
      AppMethodBeat.o(98766);
      return 0L;
    }
    Object localObject = this.KRM.ahk(this.CcM.getCurrentItem());
    if (localObject == null) {
      localObject = "";
    }
    while (!Util.isNullOrNil((String)localObject))
    {
      localObject = aj.fOI().bbl((String)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(98766);
        return 0L;
        localObject = ((com.tencent.mm.plugin.sns.j.b)localObject).parentId;
      }
      else
      {
        long l = ((SnsInfo)localObject).field_snsId;
        AppMethodBeat.o(98766);
        return l;
      }
    }
    AppMethodBeat.o(98766);
    return 0L;
  }
  
  public float getWidthModHeight()
  {
    return this.KRY;
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(98779);
    super.onDestroy();
    if (this.KRM != null)
    {
      this.KRM.detach();
      this.KRM = null;
    }
    AppMethodBeat.o(98779);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(98769);
    super.onPause();
    if (this.KRM != null)
    {
      this.KRM.fWv();
      this.KRM.clear();
    }
    AppMethodBeat.o(98769);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.KRV = paramBoolean;
  }
  
  public void setEnableSingleClickOver(boolean paramBoolean)
  {
    this.KRW = paramBoolean;
  }
  
  public void setFromScene(bp parambp)
  {
    this.JRq = parambp;
  }
  
  public void setInfoType(int paramInt)
  {
    this.infoType = paramInt;
  }
  
  public void setIsAd(boolean paramBoolean)
  {
    this.isAd = paramBoolean;
  }
  
  public void setIsFromMainTimeline(boolean paramBoolean)
  {
    this.KOn = paramBoolean;
  }
  
  public void setIsSoonEnterPhotoEditUI(boolean paramBoolean)
  {
    this.KOp = paramBoolean;
  }
  
  public void setItems(List<com.tencent.mm.plugin.sns.j.b> paramList)
  {
    this.lxh = paramList;
  }
  
  public void setOnDeleteAllAction(Runnable paramRunnable)
  {
    this.KSa = paramRunnable;
  }
  
  public void setOnPageSelectListener(b paramb)
  {
    this.KSe = paramb;
  }
  
  public void setShowLongClickMenu(boolean paramBoolean)
  {
    this.KRO = paramBoolean;
  }
  
  public void setShowPageControl(boolean paramBoolean)
  {
    this.KRS = paramBoolean;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.KRU = paramBoolean;
  }
  
  public void setTouchFinish(boolean paramBoolean)
  {
    this.KRT = paramBoolean;
  }
  
  public void setUIFromScene(int paramInt)
  {
    this.KDL = paramInt;
  }
  
  public void setVideoScene(int paramInt)
  {
    this.KKq = paramInt;
  }
  
  public final void yY(boolean paramBoolean)
  {
    AppMethodBeat.i(179207);
    if (this.KRM != null)
    {
      Log.d("MicroMsg.SnsInfoFlip", "onRefresh ");
      if (paramBoolean) {
        this.KRM.notifyDataSetChanged();
      }
      fWs();
    }
    AppMethodBeat.o(179207);
  }
  
  final class a
  {
    cvt JVq;
    int KSk = -1;
    long KSl = -1L;
    long KSm = -1L;
    cvv KSn;
    String KSo;
    long KbH = -1L;
    String fCM = "";
    int lqa;
    int networkType;
    
    a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(cvt paramcvt, int paramInt, String paramString);
  }
  
  final class c
    extends x
  {
    private int KSp;
    private String KSq;
    Map<String, WeakReference<View>> KSr;
    private boolean KSs;
    private Context context;
    private boolean uii;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(98742);
      this.KSr = new HashMap();
      this.KSs = false;
      this.context = paramContext;
      this.KSp = SnsInfoFlip.l(SnsInfoFlip.this).size();
      d.bkm();
      this.uii = d.bko();
      AppMethodBeat.o(98742);
    }
    
    private void a(final SnsInfoFlip.d paramd, final int paramInt, final cvt paramcvt, final boolean paramBoolean)
    {
      AppMethodBeat.i(250580);
      final bp localbp = bp.a(SnsInfoFlip.this.JRq, ahk(paramInt).createTime);
      com.tencent.mm.plugin.sns.model.g localg = aj.fOF();
      MultiTouchImageView localMultiTouchImageView = paramd.KSC;
      int i = this.context.hashCode();
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        localg.a(paramcvt, localMultiTouchImageView, i, bool, localbp, y.bbH(ahk(paramInt).parentId), new g.e()
        {
          public final void au(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(98741);
            if ((!t.K(paramAnonymousBitmap)) && (SnsInfoFlip.k(SnsInfoFlip.this)) && (SnsInfoFlip.this.getSelectItem() != null)) {
              SnsInfoFlip.a(SnsInfoFlip.this, paramcvt.Id, SnsInfoFlip.this.getSelectItem().parentId, paramcvt.TDH, paramcvt);
            }
            if ((!t.K(paramAnonymousBitmap)) && (paramcvt.Id != null) && (!paramcvt.Id.startsWith("pre_temp_extend_pic")))
            {
              Log.i("MicroMsg.SnsGalleryAdapter", "big image not ready, set loading img. position: %d, media id: %s.", new Object[] { Integer.valueOf(paramInt), paramcvt.Id });
              paramd.KSB.setVisibility(0);
              paramd.mUB.setVisibility(0);
              paramd.mUB.setAlpha(0.1F);
              paramd.mUB.animate().alpha(1.0F).setDuration(2000L).setListener(null);
              paramd.KSC.setVisibility(8);
              paramd.Ccj.setVisibility(8);
              aj.fOF().gm(paramd.KSB);
              aj.fOF().b(paramcvt, paramd.KSB, i.e.black, SnsInfoFlip.c.a(SnsInfoFlip.c.this).hashCode(), localbp);
              if (paramBoolean)
              {
                paramd.mUB.setVisibility(8);
                AppMethodBeat.o(98741);
              }
            }
            else if (t.K(paramAnonymousBitmap))
            {
              Log.i("MicroMsg.SnsGalleryAdapter", "pennqin, use multiTouchImageView, %s.", new Object[] { paramd.KSC });
              paramd.KSC.setVisibility(0);
              paramd.Ccj.setVisibility(8);
              paramd.KSC.setEnableHorLongBmpMode(SnsInfoFlip.p(SnsInfoFlip.this));
              paramd.KSC.di(paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight());
              paramd.KSC.setImageBitmap(null);
              paramd.KSC.setImageBitmap(paramAnonymousBitmap);
              paramd.KSC.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98740);
                  SnsInfoFlip.c.2.this.KSt.KSB.setVisibility(8);
                  SnsInfoFlip.c.2.this.KSt.mUB.setVisibility(8);
                  AppMethodBeat.o(98740);
                }
              });
              if ((SnsInfoFlip.j(SnsInfoFlip.this) != null) && (paramInt == SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem())) {
                SnsInfoFlip.a(SnsInfoFlip.this, paramd.KSC);
              }
            }
            AppMethodBeat.o(98741);
          }
        });
        AppMethodBeat.o(250580);
        return;
      }
    }
    
    private void ahg(int paramInt)
    {
      AppMethodBeat.i(98746);
      Object localObject1 = ahk(paramInt);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but flip item is null.");
        AppMethodBeat.o(98746);
        return;
      }
      String str = ((com.tencent.mm.plugin.sns.j.b)localObject1).parentId;
      if (Util.isNullOrNil(str))
      {
        Log.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but sns local id is null.");
        AppMethodBeat.o(98746);
        return;
      }
      Log.i("MicroMsg.SnsGalleryAdapter", "notify online sight play pos %s sns local id %s.", new Object[] { Integer.valueOf(paramInt), str });
      Object localObject2 = (WeakReference)this.KSr.get(str);
      if (localObject2 == null)
      {
        Log.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but view cache is null.");
        this.KSq = str;
        AppMethodBeat.o(98746);
        return;
      }
      localObject2 = (OnlineVideoView)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        Log.w("MicroMsg.SnsGalleryAdapter", "online sight view is null, do nothing. snsLocalId %s.", new Object[] { str });
        this.KSq = str;
        AppMethodBeat.o(98746);
        return;
      }
      Log.i("MicroMsg.SnsGalleryAdapter", "%d notify online sight play video %s.", new Object[] { Integer.valueOf(localObject2.hashCode()), str });
      this.KSq = null;
      ((OnlineVideoView)localObject2).fUf();
      ((OnlineVideoView)localObject2).a(((com.tencent.mm.plugin.sns.j.b)localObject1).fVT, ((com.tencent.mm.plugin.sns.j.b)localObject1).parentId, ((com.tencent.mm.plugin.sns.j.b)localObject1).createTime);
      localObject1 = new wr();
      ((wr)localObject1).fVL.fDn = 1;
      ((wr)localObject1).fVL.fCM = str;
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(98746);
    }
    
    private void ahi(int paramInt)
    {
      AppMethodBeat.i(98753);
      if (!this.uii)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (SnsInfoFlip.d(SnsInfoFlip.this) == null)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (!ag.dj(this.context))
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (paramInt - 1 >= 0) {
        ahj(paramInt - 1);
      }
      if (paramInt + 1 < SnsInfoFlip.d(SnsInfoFlip.this).getCount()) {
        ahj(paramInt + 1);
      }
      AppMethodBeat.o(98753);
    }
    
    private void ahj(int paramInt)
    {
      AppMethodBeat.i(98754);
      cvt localcvt = ahk(paramInt).fVT;
      bp localbp = bp.a(SnsInfoFlip.this.JRq, ahk(paramInt).createTime);
      if (localcvt.rWu != 2)
      {
        AppMethodBeat.o(98754);
        return;
      }
      boolean bool = y.bbH(ahk(paramInt).parentId);
      aj.fOF();
      bool = com.tencent.mm.plugin.sns.model.g.a(localcvt, localbp, bool);
      if ((SnsInfoFlip.k(SnsInfoFlip.this)) && (!bool)) {
        SnsInfoFlip.a(SnsInfoFlip.this, localcvt.Id, SnsInfoFlip.this.getSelectItem().parentId, localcvt.TDH, localcvt);
      }
      AppMethodBeat.o(98754);
    }
    
    private View n(final int paramInt, View paramView)
    {
      final boolean bool = true;
      AppMethodBeat.i(98750);
      Object localObject2 = ahk(paramInt).fVT;
      final SnsInfoFlip.d locald;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        locald = new SnsInfoFlip.d();
        paramView = View.inflate(this.context, i.g.sns_gallery_item, null);
        locald.KSA = paramView.findViewById(i.f.gallery_item);
        locald.KSB = ((ImageView)paramView.findViewById(i.f.loading_image));
        locald.mUB = ((ProgressBar)paramView.findViewById(i.f.loading_pb));
        locald.KSC = ((MultiTouchImageView)paramView.findViewById(i.f.mul_image));
        locald.Ccj = ((WxImageView)paramView.findViewById(i.f.wx_image));
        paramView.setTag(locald);
        Log.d("MicroMsg.SnsGalleryAdapter", "gallery position %d, media id: %s, %s.", new Object[] { Integer.valueOf(paramInt), ((cvt)localObject2).Id, locald.KSC });
        locald.position = paramInt;
        if ((Util.isNullOrNil(SnsInfoFlip.n(SnsInfoFlip.this))) || (!SnsInfoFlip.n(SnsInfoFlip.this).equals(((cvt)localObject2).Id))) {
          break label331;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (!((cvt)localObject2).Id.startsWith("Locall_path")) {
          break label394;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(ahk(paramInt).parentId)) {
          break label394;
        }
        localObject3 = (SnsInfo)SnsInfoFlip.o(SnsInfoFlip.this).get(ahk(paramInt).parentId);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = aj.fOI().bbl(ahk(paramInt).parentId);
          SnsInfoFlip.o(SnsInfoFlip.this).put(ahk(paramInt).parentId, localObject1);
        }
        if (localObject1 != null) {
          break label337;
        }
        AppMethodBeat.o(98750);
        return paramView;
        locald = (SnsInfoFlip.d)paramView.getTag();
        break;
        label331:
        bool = false;
      }
      label337:
      Object localObject3 = ((SnsInfo)localObject1).getTimeLine();
      Object localObject1 = localObject2;
      if (((TimeLineObject)localObject3).ContentObj.Sqr.size() > ahk(paramInt).KeQ) {
        localObject1 = (cvt)((TimeLineObject)localObject3).ContentObj.Sqr.get(ahk(paramInt).KeQ);
      }
      label394:
      localObject2 = com.tencent.mm.plugin.sns.model.g.D((cvt)localObject1);
      if ((!Util.isNullOrNil((String)localObject2)) && (SnsInfoFlip.bcb((String)localObject2)))
      {
        Log.i("MicroMsg.SnsGalleryAdapter", "pennqin, use wxImageView.");
        locald.KSC.setVisibility(8);
        locald.Ccj.setVisibility(0);
        localObject3 = BitmapUtil.getImageOptions((String)localObject2);
        if (localObject3 != null)
        {
          int i = BackwardSupportUtil.ExifHelper.getExifOrientation((String)localObject2);
          locald.Ccj.setOrientation(i);
          locald.Ccj.di(((BitmapFactory.Options)localObject3).outWidth, ((BitmapFactory.Options)localObject3).outHeight);
          locald.Ccj.hJx();
          locald.Ccj.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
          {
            public final void a(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void b(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
            {
              AppMethodBeat.i(241283);
              Log.w("MicroMsg.SnsGalleryAdapter", "onImageLoadError, switch to multiTouchImageView");
              SnsInfoFlip.c.a(SnsInfoFlip.c.this, locald, paramInt, this.KSu, bool);
              AppMethodBeat.o(241283);
            }
            
            public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void i(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(98739);
              Log.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on image loaded.");
              locald.KSB.setVisibility(8);
              locald.mUB.setVisibility(8);
              if ((SnsInfoFlip.j(SnsInfoFlip.this) != null) && (paramInt == SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem())) {
                SnsInfoFlip.a(SnsInfoFlip.this, locald.Ccj);
              }
              AppMethodBeat.o(98739);
            }
            
            public final void pP()
            {
              AppMethodBeat.i(98738);
              Log.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on preview loaded.");
              AppMethodBeat.o(98738);
            }
            
            public final void pQ() {}
          });
          localObject1 = Uri.encode(u.n(com.tencent.mm.plugin.sns.model.g.r((cvt)localObject1), false));
          if (!Util.isNullOrNil((String)localObject1)) {
            locald.Ccj.a(u.n((String)localObject2, false), com.davemorrissey.labs.subscaleview.view.a.aZ((String)localObject1));
          }
        }
      }
      for (;;)
      {
        ahi(paramInt);
        AppMethodBeat.o(98750);
        return paramView;
        a(locald, paramInt, (cvt)localObject1, bool);
      }
    }
    
    public final MultiTouchImageView Tf(int paramInt)
    {
      AppMethodBeat.i(98743);
      Object localObject = super.aiI(paramInt);
      if (localObject == null)
      {
        Log.e("MicroMsg.SnsGalleryAdapter", "position : %d getMultiTouchImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98743);
        return null;
      }
      localObject = (SnsInfoFlip.d)((View)localObject).getTag();
      if (localObject == null)
      {
        Log.e("MicroMsg.SnsGalleryAdapter", "position : %d getMultiTouchImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98743);
        return null;
      }
      if (((SnsInfoFlip.d)localObject).KSC.getVisibility() == 8)
      {
        AppMethodBeat.o(98743);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).KSC;
      AppMethodBeat.o(98743);
      return localObject;
    }
    
    public final WxImageView Tg(int paramInt)
    {
      AppMethodBeat.i(98744);
      Object localObject = super.aiI(paramInt);
      if (localObject == null)
      {
        Log.e("MicroMsg.SnsGalleryAdapter", "position : %d getWxImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98744);
        return null;
      }
      localObject = (SnsInfoFlip.d)((View)localObject).getTag();
      if (localObject == null)
      {
        Log.e("MicroMsg.SnsGalleryAdapter", "position : %d getWxImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98744);
        return null;
      }
      if (((SnsInfoFlip.d)localObject).Ccj.getVisibility() == 8)
      {
        AppMethodBeat.o(98744);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).Ccj;
      AppMethodBeat.o(98744);
      return localObject;
    }
    
    final boolean ahh(int paramInt)
    {
      AppMethodBeat.i(98752);
      View localView = aiI(paramInt);
      if ((localView != null) && (Tf(paramInt) == null) && (Tg(paramInt) == null))
      {
        n(paramInt, localView);
        AppMethodBeat.o(98752);
        return true;
      }
      AppMethodBeat.o(98752);
      return false;
    }
    
    public final com.tencent.mm.plugin.sns.j.b ahk(int paramInt)
    {
      AppMethodBeat.i(98756);
      if ((paramInt < SnsInfoFlip.l(SnsInfoFlip.this).size()) && (paramInt >= 0))
      {
        com.tencent.mm.plugin.sns.j.b localb = (com.tencent.mm.plugin.sns.j.b)SnsInfoFlip.l(SnsInfoFlip.this).get(paramInt);
        AppMethodBeat.o(98756);
        return localb;
      }
      AppMethodBeat.o(98756);
      return null;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(98747);
      Log.i("MicroMsg.SnsGalleryAdapter", "adapter clear.");
      this.KSr.clear();
      AppMethodBeat.o(98747);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(98751);
      paramViewGroup.removeView((View)paramObject);
      super.destroyItem(paramViewGroup, paramInt, paramObject);
      AppMethodBeat.o(98751);
    }
    
    public final void fWv()
    {
      AppMethodBeat.i(98749);
      Log.i("MicroMsg.SnsGalleryAdapter", "notify online sight stop %s", new Object[] { Util.getStack() });
      wr localwr = new wr();
      localwr.fVL.context = this.context;
      localwr.fVL.fCM = this.KSq;
      localwr.fVL.fDn = 2;
      EventCenter.instance.publish(localwr);
      this.KSq = null;
      AppMethodBeat.o(98749);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(98748);
      if (SnsInfoFlip.l(SnsInfoFlip.this) == null)
      {
        AppMethodBeat.o(98748);
        return 0;
      }
      int i = SnsInfoFlip.l(SnsInfoFlip.this).size();
      AppMethodBeat.o(98748);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(98757);
      if (this.KSs)
      {
        AppMethodBeat.o(98757);
        return -2;
      }
      int i = super.getItemPosition(paramObject);
      AppMethodBeat.o(98757);
      return i;
    }
    
    public final Object i(int paramInt, View paramView)
    {
      AppMethodBeat.i(98745);
      if (ahk(paramInt).fVT.rWu == 6)
      {
        boolean bool;
        com.tencent.mm.plugin.sns.j.b localb;
        if (paramView == null)
        {
          bool = true;
          Log.d("MicroMsg.SnsGalleryAdapter", "fill view online sight %d convert view is null %b.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
          localb = ahk(paramInt);
          if (localb != null) {
            break label91;
          }
          Log.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but flip item is null.");
        }
        for (Object localObject = paramView;; localObject = paramView)
        {
          AppMethodBeat.o(98745);
          return localObject;
          bool = false;
          break;
          label91:
          localObject = localb.parentId;
          if (!Util.isNullOrNil((String)localObject)) {
            break label120;
          }
          Log.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but sns local id is null.");
        }
        label120:
        paramView = (WeakReference)this.KSr.get(localObject);
        if ((paramView != null) && (paramView.get() != null)) {
          paramView = (OnlineVideoView)paramView.get();
        }
        for (;;)
        {
          paramView.aS(null);
          if (Util.isEqual((String)localObject, this.KSq)) {
            ahg(paramInt);
          }
          Log.i("MicroMsg.SnsGalleryAdapter", "return online sight view %d parent id %s.", new Object[] { Integer.valueOf(paramView.hashCode()), localb.parentId });
          SnsInfo localSnsInfo = aj.fOI().bbl((String)localObject);
          localObject = paramView;
          if (localSnsInfo == null) {
            break;
          }
          paramView.setScene(SnsInfoFlip.m(SnsInfoFlip.this));
          localObject = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          paramView.setSessionId(new p(com.tencent.mm.kernel.b.getUin()).toString() + "_" + Util.nowMilliSecond());
          paramView.setSessionTimestamp(Util.nowMilliSecond());
          paramView.setSnsId(t.Qu(localSnsInfo.field_snsId));
          paramView.setFilePath(com.tencent.mm.plugin.sns.model.ax.E(localb.fVT));
          localObject = paramView;
          if (!com.tencent.mm.q.a.aAo()) {
            break;
          }
          paramView.setMute(true);
          localObject = paramView;
          break;
          paramView = new OnlineVideoView(this.context, (byte)0);
          this.KSr.put(localObject, new WeakReference(paramView));
        }
      }
      paramView = n(paramInt, paramView);
      AppMethodBeat.o(98745);
      return paramView;
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(98755);
      this.KSs = true;
      super.notifyDataSetChanged();
      this.KSs = false;
      this.KSp = SnsInfoFlip.l(SnsInfoFlip.this).size();
      Log.d("MicroMsg.SnsGalleryAdapter", "items.size: %d.", new Object[] { Integer.valueOf(this.KSp) });
      if ((this.KSp <= 0) && (SnsInfoFlip.q(SnsInfoFlip.this) != null)) {
        SnsInfoFlip.q(SnsInfoFlip.this).run();
      }
      AppMethodBeat.o(98755);
    }
  }
  
  static final class d
  {
    WxImageView Ccj;
    View KSA;
    ImageView KSB;
    MultiTouchImageView KSC;
    ProgressBar mUB;
    int position;
    String videoPath = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip
 * JD-Core Version:    0.7.0.1
 */