package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.net.Uri;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.model.g.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
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
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.d;
import com.tencent.mm.ui.base.MMViewPager.f;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.vfs.s;
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
  int EAk;
  private boolean EAv;
  private boolean EAx;
  c EDX;
  private com.tencent.mm.ui.base.g EDY;
  private boolean EDZ;
  HashMap<Integer, Integer> EEa;
  HashMap<Integer, Long> EEb;
  HashMap<Integer, Long> EEc;
  private boolean EEd;
  private boolean EEe;
  private boolean EEf;
  private boolean EEg;
  private boolean EEh;
  private boolean EEi;
  private float EEj;
  MMPageControlView EEk;
  private Runnable EEl;
  private String EEm;
  private int EEn;
  long EEo;
  private b EEp;
  private HashMap<String, SnsInfo> EEq;
  private HashSet<String> EEr;
  public int EEs;
  private HashMap<String, a> EEt;
  private int Ewx;
  private Context context;
  private MMHandler handler;
  List<com.tencent.mm.plugin.sns.j.b> iHf;
  boolean isAd;
  public String username;
  MMViewPager xqs;
  
  public SnsInfoFlip(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98759);
    this.isAd = false;
    this.EDZ = true;
    this.EEa = new HashMap();
    this.EEb = new HashMap();
    this.EEc = new HashMap();
    this.EEd = false;
    this.EEe = false;
    this.EEf = false;
    this.EEg = false;
    this.EEh = true;
    this.EEi = true;
    this.EEj = 1.0F;
    this.EEl = null;
    this.handler = new MMHandler();
    this.EEm = "";
    this.EEn = -1;
    this.EAk = -1;
    this.EAv = false;
    this.EAx = false;
    this.EEo = 0L;
    this.Ewx = 0;
    this.EEq = new HashMap();
    this.EEr = new HashSet();
    this.EEs = 0;
    this.EEt = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98759);
  }
  
  public SnsInfoFlip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98758);
    this.isAd = false;
    this.EDZ = true;
    this.EEa = new HashMap();
    this.EEb = new HashMap();
    this.EEc = new HashMap();
    this.EEd = false;
    this.EEe = false;
    this.EEf = false;
    this.EEg = false;
    this.EEh = true;
    this.EEi = true;
    this.EEj = 1.0F;
    this.EEl = null;
    this.handler = new MMHandler();
    this.EEm = "";
    this.EEn = -1;
    this.EAk = -1;
    this.EAv = false;
    this.EAx = false;
    this.EEo = 0L;
    this.Ewx = 0;
    this.EEq = new HashMap();
    this.EEr = new HashSet();
    this.EEs = 0;
    this.EEt = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98758);
  }
  
  private void b(cnb paramcnb, int paramInt, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(98764);
    if (this.EEp != null) {
      this.EEp.a(paramcnb, paramInt, paramString);
    }
    Object localObject = aj.faO().aQm(paramString);
    if (localObject != null) {
      com.tencent.mm.plugin.sns.ui.a.c.h((SnsInfo)localObject, paramInt);
    }
    if (this.EEn == -1) {
      this.EEn = paramInt;
    }
    if ((Util.isNullOrNil(paramString)) && (this.EDX != null))
    {
      i = this.EDX.getCount();
      paramcnb = paramInt + 1 + " / " + i;
      this.Eqc.kQ(paramcnb, null);
      AppMethodBeat.o(98764);
      return;
    }
    SnsInfo localSnsInfo = (SnsInfo)this.EEq.get(paramString);
    localObject = localSnsInfo;
    if (localSnsInfo == null)
    {
      localObject = aj.faO().aQm(paramString);
      this.EEq.put(paramString, localObject);
    }
    if (localObject == null)
    {
      AppMethodBeat.o(98764);
      return;
    }
    if (paramcnb.oUv != 6) {
      aj.dRd().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98735);
          if (SnsInfoFlip.d(SnsInfoFlip.this) != null) {
            SnsInfoFlip.d(SnsInfoFlip.this).fij();
          }
          AppMethodBeat.o(98735);
        }
      });
    }
    Log.d("MicroMsg.SnsInfoFlip", "onItemSelected " + paramInt + " localId " + paramString);
    long l1;
    if (this.EAk != paramInt)
    {
      if (!this.EEa.containsKey(Integer.valueOf(paramInt))) {
        break label832;
      }
      i = ((Integer)this.EEa.get(Integer.valueOf(paramInt))).intValue();
      this.EEa.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
      this.EEb.put(Integer.valueOf(paramInt), Long.valueOf(Util.currentTicks()));
      if (this.EAk >= 0)
      {
        if (!this.EEb.containsKey(Integer.valueOf(this.EAk))) {
          break label838;
        }
        l1 = ((Long)this.EEb.get(Integer.valueOf(this.EAk))).longValue();
        label364:
        if (l1 > 0L)
        {
          this.EEb.put(Integer.valueOf(this.EAk), Long.valueOf(0L));
          if (this.EEc.containsKey(Integer.valueOf(this.EAk))) {
            l2 = ((Long)this.EEc.get(Integer.valueOf(this.EAk))).longValue();
          }
          l1 = Util.ticksToNow(l1);
          l2 += l1;
          this.EEc.put(Integer.valueOf(this.EAk), Long.valueOf(l2));
          Log.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + this.EAk + " curtime " + l2 + " passtime " + l1 / 1000.0D);
        }
      }
      if ((this.EAv) && (this.EDX != null))
      {
        paramcnb = this.EDX.ZN(this.EAk);
        if (paramcnb != null)
        {
          paramcnb = paramcnb.ebR.Id;
          Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, bigPicId:%s", new Object[] { paramcnb });
          if (this.EEt.containsKey(paramcnb))
          {
            paramcnb = (a)this.EEt.get(paramcnb);
            paramcnb.networkType = getReportNetworkType();
            if (paramcnb.EEx == -1L) {
              break label844;
            }
            paramcnb.EEv = 1;
            paramcnb.DOA = (paramcnb.EEx - paramcnb.EEw);
            Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load success, costTime:%d", new Object[] { Long.valueOf(paramcnb.DOA) });
          }
        }
      }
    }
    label651:
    this.EAk = paramInt;
    if (this.Eqb != null) {
      this.Eqb.aQQ(paramString);
    }
    int i = ((SnsInfo)localObject).getCreateTime();
    paramcnb = ((SnsInfo)localObject).getTimeLine();
    localObject = bm.r(this.context, i * 1000L);
    if ((paramcnb != null) && (paramcnb.ContentObj != null) && (paramcnb.ContentObj.LoV.size() > 1) && (this.EDX != null)) {
      i = paramcnb.ContentObj.LoV.size();
    }
    for (paramcnb = this.EDX.ZN(paramInt).DRJ + 1 + " / " + i;; paramcnb = null)
    {
      this.Eqc.kQ(String.valueOf(localObject), paramcnb);
      this.Eqc.fI(paramString, paramInt);
      if (this.EDX != null) {
        this.EDX.ZJ(paramInt);
      }
      AppMethodBeat.o(98764);
      return;
      label832:
      i = 0;
      break;
      label838:
      l1 = 0L;
      break label364;
      label844:
      paramcnb.EEv = 2;
      paramcnb.EEx = System.currentTimeMillis();
      paramcnb.DOA = (paramcnb.EEx - paramcnb.EEw);
      Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load failed, costTime:%d", new Object[] { Long.valueOf(paramcnb.DOA) });
      break label651;
    }
  }
  
  private void fig()
  {
    AppMethodBeat.i(98767);
    if ((this.EDX == null) || (this.EDX.ZN(this.xqs.getCurrentItem()) == null))
    {
      AppMethodBeat.o(98767);
      return;
    }
    int i = this.xqs.getCurrentItem();
    if ((this.EEd) && (this.EDX.getCount() > 1))
    {
      this.EEk.setVisibility(0);
      this.EEk.setPage(i);
    }
    cnb localcnb = this.EDX.ZN(this.xqs.getCurrentItem()).ebR;
    this.EEr.add(localcnb.Id);
    String str1 = this.EDX.ZN(this.xqs.getCurrentItem()).parentId;
    String str2 = localcnb.Id;
    if ((Util.isNullOrNil(this.EEm)) || (!this.EEm.equals(str2))) {
      this.EEm = "";
    }
    b(localcnb, i, str1);
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
    this.EEo = System.currentTimeMillis();
    this.context = paramContext;
    this.xqs = ((MMViewPager)inflate(paramContext, 2131496445, this).findViewById(2131301853));
    this.xqs.setVerticalFadingEdgeEnabled(false);
    this.xqs.setHorizontalFadingEdgeEnabled(false);
    this.xqs.setOffscreenPageLimit(1);
    this.xqs.setSingleClickOverListener(new MMViewPager.f()
    {
      public final void bmt()
      {
        AppMethodBeat.i(98733);
        if (SnsInfoFlip.b(SnsInfoFlip.this)) {
          SnsInfoFlip.c(SnsInfoFlip.this);
        }
        AppMethodBeat.o(98733);
      }
      
      public final void dSr()
      {
        AppMethodBeat.i(98734);
        SnsInfoFlip.c(SnsInfoFlip.this);
        AppMethodBeat.o(98734);
      }
    });
    this.EEk = ((MMPageControlView)findViewById(2131310487));
    this.EEk.setIndicatorLayoutRes(2131496528);
    paramContext = (LinearLayout.LayoutParams)this.EEk.getLayoutParams();
    paramContext.bottomMargin += au.aD(getContext());
    this.EEk.setLayoutParams(paramContext);
    r.DEL = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sjJ, 3200);
    AppMethodBeat.o(98760);
  }
  
  public final void a(List<com.tencent.mm.plugin.sns.j.b> paramList, String paramString, int paramInt, y paramy, w.a parama)
  {
    AppMethodBeat.i(98765);
    aj.faJ().a(this);
    this.iHf = paramList;
    an.In(paramString);
    this.Eqb = paramy;
    this.Eqc = parama;
    this.EDX = new c(this.context);
    this.xqs.setAdapter(this.EDX);
    if ((paramInt >= 0) && (paramInt < this.iHf.size()))
    {
      this.xqs.setCurrentItem(paramInt);
      if (this.EEi)
      {
        this.EEi = false;
        paramList = this.EDX.ZN(paramInt).ebR;
        if ((paramList == null) || (paramList.MsB == null) || (paramList.MsB.Mtp <= 0.0F)) {
          break label341;
        }
      }
    }
    label341:
    for (this.EEj = (paramList.MsB.Mto / paramList.MsB.Mtp);; this.EEj = 1.0F)
    {
      this.xqs.setFadingEdgeLength(0);
      this.xqs.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
            Object localObject1 = SnsInfoFlip.d(SnsInfoFlip.this).ZN(paramAnonymousInt).ebR;
            Object localObject2 = SnsInfoFlip.d(SnsInfoFlip.this).ZN(paramAnonymousInt).parentId;
            SnsInfoFlip.a(SnsInfoFlip.this, (cnb)localObject1, paramAnonymousInt, (String)localObject2);
            localObject2 = SnsInfoFlip.d(SnsInfoFlip.this).NQ(paramAnonymousInt);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = SnsInfoFlip.d(SnsInfoFlip.this).NR(paramAnonymousInt);
            }
            SnsInfoFlip.a(SnsInfoFlip.this, (com.tencent.mm.ui.base.g)localObject1);
            if (localObject1 != null) {
              ((com.tencent.mm.ui.base.g)localObject1).gKy();
            }
            if ((SnsInfoFlip.g(SnsInfoFlip.this) instanceof SnsBrowseUI)) {
              ((SnsBrowseUI)SnsInfoFlip.g(SnsInfoFlip.this)).fhM();
            }
            SnsInfoFlip.d(SnsInfoFlip.this).ZK(paramAnonymousInt);
          }
          AppMethodBeat.o(98736);
        }
      });
      this.xqs.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(203588);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(203588);
            return false;
            paramAnonymousView = ad.aVe().G("basescanui@datacenter", true);
            if ((SnsInfoFlip.h(SnsInfoFlip.this) instanceof View))
            {
              PointF localPointF = m.e((View)SnsInfoFlip.h(SnsInfoFlip.this), paramAnonymousMotionEvent.getRawX(), paramAnonymousMotionEvent.getRawY());
              if (localPointF != null)
              {
                paramAnonymousView.l("key_basescanui_touch_normalize_x", Float.valueOf(localPointF.x));
                paramAnonymousView.l("key_basescanui_touch_normalize_y", Float.valueOf(localPointF.y));
              }
              else
              {
                Log.e("MicroMsg.SnsInfoFlip", "alvinluo get touchCoordinate is invalid");
                paramAnonymousView.l("key_basescanui_screen_position", Boolean.TRUE);
                paramAnonymousView.l("key_basescanui_screen_x", Float.valueOf(paramAnonymousMotionEvent.getRawX()));
                paramAnonymousView.l("key_basescanui_screen_y", Float.valueOf(paramAnonymousMotionEvent.getRawY()));
              }
            }
          }
        }
      });
      if (this.EDZ) {
        this.xqs.setLongClickOverListener(new MMViewPager.d()
        {
          public final void bmu()
          {
            AppMethodBeat.i(203589);
            if (!SnsInfoFlip.i(SnsInfoFlip.this))
            {
              AppMethodBeat.o(203589);
              return;
            }
            if (SnsInfoFlip.d(SnsInfoFlip.this) == null)
            {
              Log.e("MicroMsg.SnsInfoFlip", "longClickOver, adapter is null.");
              AppMethodBeat.o(203589);
              return;
            }
            com.tencent.mm.plugin.sns.j.b localb = SnsInfoFlip.d(SnsInfoFlip.this).ZN(SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem());
            if ((localb == null) || (Util.isNullOrNil(localb.parentId)))
            {
              AppMethodBeat.o(203589);
              return;
            }
            Object localObject1 = new ep();
            ((ep)localObject1).ejA = 1L;
            if (SnsInfoFlip.k(SnsInfoFlip.this)) {}
            for (((ep)localObject1).eDV = 6L;; ((ep)localObject1).eDV = 7L)
            {
              Object localObject2 = SnsInfoFlip.d(SnsInfoFlip.this).ZN(SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem()).ebR;
              ((ep)localObject1).rK(((cnb)localObject2).Url);
              ((ep)localObject1).bfK();
              localObject1 = ((cnb)localObject2).Id;
              localObject2 = ar.ki(aj.getAccSnsPath(), (String)localObject1) + r.l(SnsInfoFlip.d(SnsInfoFlip.this).ZN(SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem()).ebR);
              SnsInfoFlip.this.g((String)localObject2, localb.parentId, (String)localObject1, true);
              AppMethodBeat.o(203589);
              return;
            }
          }
        });
      }
      if ((this.EEd) && (this.EDX.getCount() > 1))
      {
        this.EEk.setVisibility(0);
        this.EEk.kX(this.EDX.getCount(), paramInt);
      }
      if ((this.EAx) && (!Util.isNullOrNil(this.EDX.ZN(paramInt).parentId)))
      {
        paramList = this.EDX.ZN(paramInt).ebR.Id;
        aQN(ar.ki(aj.getAccSnsPath(), paramList) + r.l(this.EDX.ZN(paramInt).ebR));
      }
      AppMethodBeat.o(98765);
      return;
    }
  }
  
  public final void bEq()
  {
    AppMethodBeat.i(203593);
    if ((this.EDX == null) || (this.xqs == null))
    {
      AppMethodBeat.o(203593);
      return;
    }
    try
    {
      int i = this.xqs.getCurrentItem();
      com.tencent.mm.plugin.sns.j.b localb = this.EDX.ZN(i);
      String str = localb.ebR.Id;
      g(ar.ki(aj.getAccSnsPath(), str) + r.l(this.EDX.ZN(this.xqs.getCurrentItem()).ebR), localb.parentId, str, true);
      AppMethodBeat.o(203593);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(203593);
    }
  }
  
  public final void ci(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(98775);
    if (this.EDX == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsInfoFlip", "onImageFinish, mediaId: %s, isOK: %s, null == adapter: %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (this.EDX != null) {
        break;
      }
      AppMethodBeat.o(98775);
      return;
    }
    Object localObject;
    if ((!paramBoolean) && (this.EDX.ZN(this.xqs.getCurrentItem()) != null))
    {
      localObject = this.EDX.ZN(this.xqs.getCurrentItem()).ebR;
      if ((localObject != null) && (((cnb)localObject).Id != null) && (((cnb)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131766030), 0).show();
        this.EEm = paramString;
      }
    }
    this.EEs += 1;
    if (this.EAv)
    {
      Log.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.EEt.containsKey(paramString)))
      {
        localObject = (a)this.EEt.get(paramString);
        ((a)localObject).EEx = System.currentTimeMillis();
        ((a)localObject).networkType = getReportNetworkType();
        Log.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
      }
    }
    c localc;
    int j;
    if (this.EDX.ZN(this.xqs.getCurrentItem()) != null)
    {
      localObject = this.EDX.ZN(this.xqs.getCurrentItem()).ebR;
      if ((localObject != null) && (((cnb)localObject).Id != null) && (((cnb)localObject).Id.equals(paramString)))
      {
        Log.i("MicroMsg.SnsInfoFlip", "img download finish, refresh ui, media id: %s. and mediaLocal id %s", new Object[] { ((cnb)localObject).Id, Integer.valueOf(((cnb)localObject).ecf) });
        localc = this.EDX;
        j = localc.EEu.iHf.size();
      }
    }
    for (;;)
    {
      if (i < j)
      {
        com.tencent.mm.plugin.sns.j.b localb = localc.ZN(i);
        if ((localb != null) && (localb.ebR.Id.equals(paramString))) {
          localc.ZK(i);
        }
      }
      else
      {
        if (this.EAx) {
          F((cnb)localObject);
        }
        AppMethodBeat.o(98775);
        return;
      }
      i += 1;
    }
  }
  
  public final void cj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98776);
    Object localObject = new StringBuilder("onSightFinish ").append(paramString).append(" ").append(paramBoolean).append(" ");
    if (this.EDX == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsInfoFlip", bool);
      if (this.EDX != null) {
        break;
      }
      AppMethodBeat.o(98776);
      return;
    }
    if ((!paramBoolean) && (this.EDX.ZN(this.xqs.getCurrentItem()) != null))
    {
      localObject = this.EDX.ZN(this.xqs.getCurrentItem()).ebR;
      if ((localObject != null) && (((cnb)localObject).Id != null) && (((cnb)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131766031), 0).show();
        this.EEm = paramString;
      }
    }
    this.EDX.notifyDataSetChanged();
    AppMethodBeat.o(98776);
  }
  
  public final boolean ffH()
  {
    return this.EAv;
  }
  
  public final int fih()
  {
    AppMethodBeat.i(98770);
    if ((this.xqs == null) || (this.EDX == null))
    {
      AppMethodBeat.o(98770);
      return -1;
    }
    int i = this.xqs.getCurrentItem();
    if ((i >= 0) && (this.iHf.size() > i))
    {
      this.iHf.remove(i);
      this.EDX.notifyDataSetChanged();
      fig();
    }
    i = this.EDX.getCount();
    AppMethodBeat.o(98770);
    return i;
  }
  
  public final void fii()
  {
    AppMethodBeat.i(98778);
    Iterator localIterator = this.EEt.values().iterator();
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
      if (locala.EEv != -1)
      {
        localSnsInfo = aj.faO().aQm(locala.dJX);
        str = ar.ki(aj.getAccSnsPath(), locala.EEz) + r.l(locala.DIq);
        localOptions = BitmapUtil.getImageOptions(str);
        k = 0;
        j = 0;
        i = (int)s.boW(str);
        if (localOptions != null)
        {
          k = localOptions.outWidth;
          j = localOptions.outHeight;
          i = (int)s.boW(str);
        }
        m = r.aBO(str);
        if (locala.DIq.mediaType != 0) {
          m = locala.DIq.mediaType;
        }
        if (localSnsInfo != null)
        {
          h.CyF.a(11601, new Object[] { Integer.valueOf(locala.iAC), Integer.valueOf(locala.EEv), Long.valueOf(locala.DOA), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.EEw), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          Log.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.iAC), Integer.valueOf(locala.EEv), Long.valueOf(locala.DOA), Integer.valueOf(locala.networkType), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.EEw), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(r.aBO(str)), str });
        }
      }
      else if (locala.EEw != -1L)
      {
        if (locala.EEx != -1L) {
          locala.EEv = 1;
        }
        for (;;)
        {
          locala.DOA = (locala.EEx - locala.EEw);
          localSnsInfo = aj.faO().aQm(locala.dJX);
          str = ar.ki(aj.getAccSnsPath(), locala.EEz) + r.l(locala.DIq);
          localOptions = BitmapUtil.getImageOptions(str);
          k = 0;
          j = 0;
          i = (int)s.boW(str);
          if (localOptions != null)
          {
            k = localOptions.outWidth;
            j = localOptions.outHeight;
            i = (int)s.boW(str);
          }
          m = r.aBO(str);
          if (locala.DIq.mediaType != 0) {
            m = locala.DIq.mediaType;
          }
          if (localSnsInfo == null) {
            break;
          }
          h.CyF.a(11601, new Object[] { Integer.valueOf(locala.iAC), Integer.valueOf(locala.EEv), Long.valueOf(locala.DOA), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.EEw), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          Log.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.iAC), Integer.valueOf(locala.EEv), Long.valueOf(locala.DOA), Integer.valueOf(locala.networkType), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.EEw), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(r.aBO(str)), str });
          break;
          locala.EEv = 2;
          locala.EEx = System.currentTimeMillis();
        }
      }
    }
    this.EEt.clear();
    AppMethodBeat.o(98778);
  }
  
  public cnb getCntMedia()
  {
    AppMethodBeat.i(98772);
    if (this.EDX != null)
    {
      int i = this.xqs.getCurrentItem();
      if ((this.iHf != null) && (i < this.iHf.size()))
      {
        cnb localcnb = this.EDX.ZN(i).ebR;
        AppMethodBeat.o(98772);
        return localcnb;
      }
    }
    AppMethodBeat.o(98772);
    return null;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(98771);
    if (this.EDX != null)
    {
      int i = this.EDX.getCount();
      AppMethodBeat.o(98771);
      return i;
    }
    AppMethodBeat.o(98771);
    return 0;
  }
  
  public View getCurrentImageView()
  {
    if ((this.EDY instanceof View)) {
      return (View)this.EDY;
    }
    return null;
  }
  
  public List<com.tencent.mm.plugin.sns.j.b> getFlipList()
  {
    return this.iHf;
  }
  
  public bp getFromScene()
  {
    return this.DEv;
  }
  
  public MMViewPager getGallery()
  {
    return this.xqs;
  }
  
  public int getNumOfFileExist()
  {
    AppMethodBeat.i(98774);
    Iterator localIterator = this.iHf.iterator();
    int k = 0;
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.sns.j.b localb = (com.tencent.mm.plugin.sns.j.b)localIterator.next();
        aj.faL();
        j = i;
        if (s.YS(com.tencent.mm.plugin.sns.model.g.D(localb.ebR))) {
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
    return this.EAk;
  }
  
  public int getSelectCount()
  {
    AppMethodBeat.i(98773);
    int i = this.EEr.size();
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
    if ((this.xqs != null) && (this.EDX != null))
    {
      int i = this.xqs.getCurrentItem();
      com.tencent.mm.plugin.sns.j.b localb = this.EDX.ZN(i);
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
      localObject = ((cnb)localObject).Id;
      AppMethodBeat.o(98762);
      return localObject;
    }
    AppMethodBeat.o(98762);
    return null;
  }
  
  public long getSnsId()
  {
    AppMethodBeat.i(98766);
    if (this.EDX == null)
    {
      AppMethodBeat.o(98766);
      return 0L;
    }
    Object localObject = this.EDX.ZN(this.xqs.getCurrentItem());
    if (localObject == null) {
      localObject = "";
    }
    while (!Util.isNullOrNil((String)localObject))
    {
      localObject = aj.faO().aQm((String)localObject);
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
    return this.EEj;
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(98779);
    super.onDestroy();
    if (this.EDX != null)
    {
      this.EDX.detach();
      this.EDX = null;
    }
    AppMethodBeat.o(98779);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(98769);
    super.onPause();
    if (this.EDX != null)
    {
      this.EDX.fij();
      this.EDX.clear();
    }
    AppMethodBeat.o(98769);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.EEg = paramBoolean;
  }
  
  public void setEnableSingleClickOver(boolean paramBoolean)
  {
    this.EEh = paramBoolean;
  }
  
  public void setFromScene(bp parambp)
  {
    this.DEv = parambp;
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
    this.EAv = paramBoolean;
  }
  
  public void setIsSoonEnterPhotoEditUI(boolean paramBoolean)
  {
    this.EAx = paramBoolean;
  }
  
  public void setItems(List<com.tencent.mm.plugin.sns.j.b> paramList)
  {
    this.iHf = paramList;
  }
  
  public void setOnDeleteAllAction(Runnable paramRunnable)
  {
    this.EEl = paramRunnable;
  }
  
  public void setOnPageSelectListener(b paramb)
  {
    this.EEp = paramb;
  }
  
  public void setShowLongClickMenu(boolean paramBoolean)
  {
    this.EDZ = paramBoolean;
  }
  
  public void setShowPageControl(boolean paramBoolean)
  {
    this.EEd = paramBoolean;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.EEf = paramBoolean;
  }
  
  public void setTouchFinish(boolean paramBoolean)
  {
    this.EEe = paramBoolean;
  }
  
  public void setUIFromScene(int paramInt)
  {
    this.Eqv = paramInt;
  }
  
  public void setVideoScene(int paramInt)
  {
    this.Ewx = paramInt;
  }
  
  public final void vu(boolean paramBoolean)
  {
    AppMethodBeat.i(179207);
    if (this.EDX != null)
    {
      Log.d("MicroMsg.SnsInfoFlip", "onRefresh ");
      if (paramBoolean) {
        this.EDX.notifyDataSetChanged();
      }
      fig();
    }
    AppMethodBeat.o(179207);
  }
  
  final class a
  {
    cnb DIq;
    long DOA = -1L;
    int EEv = -1;
    long EEw = -1L;
    long EEx = -1L;
    cnd EEy;
    String EEz;
    String dJX = "";
    int iAC;
    int networkType;
    
    a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(cnb paramcnb, int paramInt, String paramString);
  }
  
  final class c
    extends v
  {
    private int EEA;
    private String EEB;
    Map<String, WeakReference<View>> EEC;
    private boolean EED;
    Context context;
    private boolean qJf;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(98742);
      this.EEC = new HashMap();
      this.EED = false;
      this.context = paramContext;
      this.EEA = SnsInfoFlip.l(SnsInfoFlip.this).size();
      d.baW();
      this.qJf = d.baY();
      AppMethodBeat.o(98742);
    }
    
    private void ZL(int paramInt)
    {
      AppMethodBeat.i(98753);
      if (!this.qJf)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (SnsInfoFlip.d(SnsInfoFlip.this) == null)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (!ag.dm(this.context))
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (paramInt - 1 >= 0) {
        ZM(paramInt - 1);
      }
      if (paramInt + 1 < SnsInfoFlip.d(SnsInfoFlip.this).getCount()) {
        ZM(paramInt + 1);
      }
      AppMethodBeat.o(98753);
    }
    
    private void ZM(int paramInt)
    {
      AppMethodBeat.i(98754);
      cnb localcnb = ZN(paramInt).ebR;
      bp localbp = bp.a(SnsInfoFlip.this.DEv, ZN(paramInt).iXu);
      if (localcnb.oUv != 2)
      {
        AppMethodBeat.o(98754);
        return;
      }
      boolean bool = com.tencent.mm.plugin.sns.storage.y.aQH(ZN(paramInt).parentId);
      aj.faL();
      bool = com.tencent.mm.plugin.sns.model.g.a(localcnb, localbp, bool);
      if ((SnsInfoFlip.k(SnsInfoFlip.this)) && (!bool)) {
        SnsInfoFlip.a(SnsInfoFlip.this, localcnb.Id, SnsInfoFlip.this.getSelectItem().parentId, localcnb.MsB, localcnb);
      }
      AppMethodBeat.o(98754);
    }
    
    private void a(final SnsInfoFlip.d paramd, final int paramInt, final cnb paramcnb, final boolean paramBoolean)
    {
      AppMethodBeat.i(203591);
      final bp localbp = bp.a(SnsInfoFlip.this.DEv, ZN(paramInt).iXu);
      com.tencent.mm.plugin.sns.model.g localg = aj.faL();
      MultiTouchImageView localMultiTouchImageView = paramd.EEM;
      int i = this.context.hashCode();
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        localg.a(paramcnb, localMultiTouchImageView, i, bool, localbp, com.tencent.mm.plugin.sns.storage.y.aQH(ZN(paramInt).parentId), new g.e()
        {
          public final void ax(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(98741);
            if ((!r.M(paramAnonymousBitmap)) && (SnsInfoFlip.k(SnsInfoFlip.this)) && (SnsInfoFlip.this.getSelectItem() != null)) {
              SnsInfoFlip.a(SnsInfoFlip.this, paramcnb.Id, SnsInfoFlip.this.getSelectItem().parentId, paramcnb.MsB, paramcnb);
            }
            if ((!r.M(paramAnonymousBitmap)) && (paramcnb.Id != null) && (!paramcnb.Id.startsWith("pre_temp_extend_pic")))
            {
              Log.i("MicroMsg.SnsGalleryAdapter", "big image not ready, set loading img. position: %d, media id: %s.", new Object[] { Integer.valueOf(paramInt), paramcnb.Id });
              paramd.wSb.setVisibility(0);
              paramd.kdb.setVisibility(0);
              paramd.kdb.setAlpha(0.1F);
              paramd.kdb.animate().alpha(1.0F).setDuration(2000L).setListener(null);
              paramd.EEM.setVisibility(8);
              paramd.xpO.setVisibility(8);
              aj.faL().ff(paramd.wSb);
              aj.faL().b(paramcnb, paramd.wSb, 2131231381, SnsInfoFlip.c.this.context.hashCode(), localbp);
              if (paramBoolean)
              {
                paramd.kdb.setVisibility(8);
                AppMethodBeat.o(98741);
              }
            }
            else if (r.M(paramAnonymousBitmap))
            {
              Log.i("MicroMsg.SnsGalleryAdapter", "pennqin, use multiTouchImageView, %s.", new Object[] { paramd.EEM });
              paramd.EEM.setVisibility(0);
              paramd.xpO.setVisibility(8);
              paramd.EEM.setEnableHorLongBmpMode(SnsInfoFlip.p(SnsInfoFlip.this));
              paramd.EEM.cN(paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight());
              paramd.EEM.setImageBitmap(null);
              paramd.EEM.setImageBitmap(paramAnonymousBitmap);
              paramd.EEM.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98740);
                  SnsInfoFlip.c.2.this.EEE.wSb.setVisibility(8);
                  SnsInfoFlip.c.2.this.EEE.kdb.setVisibility(8);
                  AppMethodBeat.o(98740);
                }
              });
              if ((SnsInfoFlip.j(SnsInfoFlip.this) != null) && (paramInt == SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem())) {
                SnsInfoFlip.a(SnsInfoFlip.this, paramd.EEM);
              }
            }
            AppMethodBeat.o(98741);
          }
        });
        AppMethodBeat.o(203591);
        return;
      }
    }
    
    private View k(final int paramInt, View paramView)
    {
      final boolean bool = true;
      AppMethodBeat.i(98750);
      Object localObject2 = ZN(paramInt).ebR;
      final SnsInfoFlip.d locald;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        locald = new SnsInfoFlip.d();
        paramView = View.inflate(this.context, 2131496441, null);
        locald.EEL = paramView.findViewById(2131301860);
        locald.wSb = ((ImageView)paramView.findViewById(2131303704));
        locald.kdb = ((ProgressBar)paramView.findViewById(2131303709));
        locald.EEM = ((MultiTouchImageView)paramView.findViewById(2131304991));
        locald.xpO = ((WxImageView)paramView.findViewById(2131310633));
        paramView.setTag(locald);
        Log.d("MicroMsg.SnsGalleryAdapter", "gallery position %d, media id: %s, %s.", new Object[] { Integer.valueOf(paramInt), ((cnb)localObject2).Id, locald.EEM });
        locald.position = paramInt;
        if ((Util.isNullOrNil(SnsInfoFlip.n(SnsInfoFlip.this))) || (!SnsInfoFlip.n(SnsInfoFlip.this).equals(((cnb)localObject2).Id))) {
          break label322;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (!((cnb)localObject2).Id.startsWith("Locall_path")) {
          break label385;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(ZN(paramInt).parentId)) {
          break label385;
        }
        localObject3 = (SnsInfo)SnsInfoFlip.o(SnsInfoFlip.this).get(ZN(paramInt).parentId);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = aj.faO().aQm(ZN(paramInt).parentId);
          SnsInfoFlip.o(SnsInfoFlip.this).put(ZN(paramInt).parentId, localObject1);
        }
        if (localObject1 != null) {
          break label328;
        }
        AppMethodBeat.o(98750);
        return paramView;
        locald = (SnsInfoFlip.d)paramView.getTag();
        break;
        label322:
        bool = false;
      }
      label328:
      Object localObject3 = ((SnsInfo)localObject1).getTimeLine();
      Object localObject1 = localObject2;
      if (((TimeLineObject)localObject3).ContentObj.LoV.size() > ZN(paramInt).DRJ) {
        localObject1 = (cnb)((TimeLineObject)localObject3).ContentObj.LoV.get(ZN(paramInt).DRJ);
      }
      label385:
      localObject2 = com.tencent.mm.plugin.sns.model.g.D((cnb)localObject1);
      if ((!Util.isNullOrNil((String)localObject2)) && (SnsInfoFlip.aRa((String)localObject2)))
      {
        Log.i("MicroMsg.SnsGalleryAdapter", "pennqin, use wxImageView.");
        locald.EEM.setVisibility(8);
        locald.xpO.setVisibility(0);
        localObject3 = BitmapUtil.getImageOptions((String)localObject2);
        if (localObject3 != null)
        {
          int i = BackwardSupportUtil.ExifHelper.getExifOrientation((String)localObject2);
          locald.xpO.setOrientation(i);
          locald.xpO.cN(((BitmapFactory.Options)localObject3).outWidth, ((BitmapFactory.Options)localObject3).outHeight);
          locald.xpO.gKy();
          locald.xpO.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
          {
            public final void a(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void b(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
            {
              AppMethodBeat.i(203590);
              Log.w("MicroMsg.SnsGalleryAdapter", "onImageLoadError, switch to multiTouchImageView");
              SnsInfoFlip.c.a(SnsInfoFlip.c.this, locald, paramInt, this.EEF, bool);
              AppMethodBeat.o(203590);
            }
            
            public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void n(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(98739);
              Log.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on image loaded.");
              locald.wSb.setVisibility(8);
              locald.kdb.setVisibility(8);
              if ((SnsInfoFlip.j(SnsInfoFlip.this) != null) && (paramInt == SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem())) {
                SnsInfoFlip.a(SnsInfoFlip.this, locald.xpO);
              }
              AppMethodBeat.o(98739);
            }
            
            public final void sb()
            {
              AppMethodBeat.i(98738);
              Log.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on preview loaded.");
              AppMethodBeat.o(98738);
            }
            
            public final void sc() {}
          });
          localObject1 = Uri.encode(s.k(com.tencent.mm.plugin.sns.model.g.r((cnb)localObject1), false));
          if (!Util.isNullOrNil((String)localObject1)) {
            locald.xpO.a(s.k((String)localObject2, false), com.davemorrissey.labs.subscaleview.view.a.aP((String)localObject1));
          }
        }
      }
      for (;;)
      {
        ZL(paramInt);
        AppMethodBeat.o(98750);
        return paramView;
        a(locald, paramInt, (cnb)localObject1, bool);
      }
    }
    
    public final MultiTouchImageView NQ(int paramInt)
    {
      AppMethodBeat.i(98743);
      Object localObject = super.abm(paramInt);
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
      if (((SnsInfoFlip.d)localObject).EEM.getVisibility() == 8)
      {
        AppMethodBeat.o(98743);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).EEM;
      AppMethodBeat.o(98743);
      return localObject;
    }
    
    public final WxImageView NR(int paramInt)
    {
      AppMethodBeat.i(98744);
      Object localObject = super.abm(paramInt);
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
      if (((SnsInfoFlip.d)localObject).xpO.getVisibility() == 8)
      {
        AppMethodBeat.o(98744);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).xpO;
      AppMethodBeat.o(98744);
      return localObject;
    }
    
    final void ZJ(int paramInt)
    {
      AppMethodBeat.i(98746);
      Object localObject1 = ZN(paramInt);
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
      Object localObject2 = (WeakReference)this.EEC.get(str);
      if (localObject2 == null)
      {
        Log.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but view cache is null.");
        this.EEB = str;
        AppMethodBeat.o(98746);
        return;
      }
      localObject2 = (OnlineVideoView)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        Log.w("MicroMsg.SnsGalleryAdapter", "online sight view is null, do nothing. snsLocalId %s.", new Object[] { str });
        this.EEB = str;
        AppMethodBeat.o(98746);
        return;
      }
      Log.i("MicroMsg.SnsGalleryAdapter", "%d notify online sight play video %s.", new Object[] { Integer.valueOf(localObject2.hashCode()), str });
      this.EEB = null;
      ((OnlineVideoView)localObject2).fgh();
      ((OnlineVideoView)localObject2).a(((com.tencent.mm.plugin.sns.j.b)localObject1).ebR, ((com.tencent.mm.plugin.sns.j.b)localObject1).parentId, ((com.tencent.mm.plugin.sns.j.b)localObject1).iXu);
      localObject1 = new vm();
      ((vm)localObject1).ebJ.dKy = 1;
      ((vm)localObject1).ebJ.dJX = str;
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(98746);
    }
    
    final boolean ZK(int paramInt)
    {
      AppMethodBeat.i(98752);
      View localView = abm(paramInt);
      if ((localView != null) && (NQ(paramInt) == null) && (NR(paramInt) == null))
      {
        k(paramInt, localView);
        AppMethodBeat.o(98752);
        return true;
      }
      AppMethodBeat.o(98752);
      return false;
    }
    
    public final com.tencent.mm.plugin.sns.j.b ZN(int paramInt)
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
      this.EEC.clear();
      AppMethodBeat.o(98747);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(98751);
      paramViewGroup.removeView((View)paramObject);
      super.destroyItem(paramViewGroup, paramInt, paramObject);
      AppMethodBeat.o(98751);
    }
    
    public final void fij()
    {
      AppMethodBeat.i(98749);
      Log.i("MicroMsg.SnsGalleryAdapter", "notify online sight stop %s", new Object[] { Util.getStack() });
      vm localvm = new vm();
      localvm.ebJ.context = this.context;
      localvm.ebJ.dJX = this.EEB;
      localvm.ebJ.dKy = 2;
      EventCenter.instance.publish(localvm);
      this.EEB = null;
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
      if (this.EED)
      {
        AppMethodBeat.o(98757);
        return -2;
      }
      int i = super.getItemPosition(paramObject);
      AppMethodBeat.o(98757);
      return i;
    }
    
    public final Object h(int paramInt, View paramView)
    {
      AppMethodBeat.i(98745);
      if (ZN(paramInt).ebR.oUv == 6)
      {
        boolean bool;
        com.tencent.mm.plugin.sns.j.b localb;
        if (paramView == null)
        {
          bool = true;
          Log.d("MicroMsg.SnsGalleryAdapter", "fill view online sight %d convert view is null %b.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
          localb = ZN(paramInt);
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
        paramView = (WeakReference)this.EEC.get(localObject);
        if ((paramView != null) && (paramView.get() != null)) {
          paramView = (OnlineVideoView)paramView.get();
        }
        for (;;)
        {
          paramView.aM(null);
          if (Util.isEqual((String)localObject, this.EEB)) {
            ZJ(paramInt);
          }
          Log.i("MicroMsg.SnsGalleryAdapter", "return online sight view %d parent id %s.", new Object[] { Integer.valueOf(paramView.hashCode()), localb.parentId });
          SnsInfo localSnsInfo = aj.faO().aQm((String)localObject);
          localObject = paramView;
          if (localSnsInfo == null) {
            break;
          }
          paramView.setScene(SnsInfoFlip.m(SnsInfoFlip.this));
          localObject = new StringBuilder();
          com.tencent.mm.kernel.g.aAf();
          paramView.setSessionId(new p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + Util.nowMilliSecond());
          paramView.setSessionTimestamp(Util.nowMilliSecond());
          paramView.setSnsId(r.Jb(localSnsInfo.field_snsId));
          paramView.setFilePath(ay.E(localb.ebR));
          localObject = paramView;
          if (!com.tencent.mm.q.a.aty()) {
            break;
          }
          paramView.setMute(true);
          localObject = paramView;
          break;
          paramView = new OnlineVideoView(this.context);
          this.EEC.put(localObject, new WeakReference(paramView));
        }
      }
      paramView = k(paramInt, paramView);
      AppMethodBeat.o(98745);
      return paramView;
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(98755);
      this.EED = true;
      super.notifyDataSetChanged();
      this.EED = false;
      this.EEA = SnsInfoFlip.l(SnsInfoFlip.this).size();
      Log.d("MicroMsg.SnsGalleryAdapter", "items.size: %d.", new Object[] { Integer.valueOf(this.EEA) });
      if ((this.EEA <= 0) && (SnsInfoFlip.q(SnsInfoFlip.this) != null)) {
        SnsInfoFlip.q(SnsInfoFlip.this).run();
      }
      AppMethodBeat.o(98755);
    }
  }
  
  static final class d
  {
    View EEL;
    MultiTouchImageView EEM;
    ProgressBar kdb;
    int position;
    String videoPath = "";
    ImageView wSb;
    WxImageView xpO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip
 * JD-Core Version:    0.7.0.1
 */