package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
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
import com.davemorrissey.labs.subscaleview.decoder.ImageDecodeResult;
import com.davemorrissey.labs.subscaleview.view.ImageSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.yk;
import com.tencent.mm.autogen.mmdata.rpt.hj;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.n.a;
import com.tencent.mm.network.ah;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.model.g.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.d;
import com.tencent.mm.ui.base.MMViewPager.f;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.bf;
import com.tencent.mm.vfs.y;
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
  MMViewPager HOP;
  private int RjS;
  int RnM;
  private boolean Roa;
  private boolean Roc;
  c RrL;
  private i RrM;
  private boolean RrN;
  HashMap<Integer, Integer> RrO;
  HashMap<Integer, Long> RrP;
  HashMap<Integer, Long> RrQ;
  private boolean RrR;
  private boolean RrS;
  private boolean RrT;
  private boolean RrU;
  private boolean RrV;
  private boolean RrW;
  private float RrX;
  MMPageControlView RrY;
  private Runnable RrZ;
  private String Rsa;
  private int Rsb;
  long Rsc;
  private b Rsd;
  private HashMap<String, SnsInfo> Rse;
  private HashSet<String> Rsf;
  public int Rsg;
  private HashMap<String, a> Rsh;
  private List<bzi> bMQ;
  private Context context;
  private MMHandler handler;
  boolean isAd;
  public String username;
  
  public SnsInfoFlip(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98759);
    this.isAd = false;
    this.RrN = true;
    this.RrO = new HashMap();
    this.RrP = new HashMap();
    this.RrQ = new HashMap();
    this.RrR = false;
    this.RrS = false;
    this.RrT = false;
    this.RrU = false;
    this.RrV = true;
    this.RrW = true;
    this.RrX = 1.0F;
    this.RrZ = null;
    this.handler = new MMHandler();
    this.Rsa = "";
    this.Rsb = -1;
    this.RnM = -1;
    this.Roa = false;
    this.Roc = false;
    this.Rsc = 0L;
    this.RjS = 0;
    this.Rse = new HashMap();
    this.Rsf = new HashSet();
    this.Rsg = 0;
    this.Rsh = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98759);
  }
  
  public SnsInfoFlip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98758);
    this.isAd = false;
    this.RrN = true;
    this.RrO = new HashMap();
    this.RrP = new HashMap();
    this.RrQ = new HashMap();
    this.RrR = false;
    this.RrS = false;
    this.RrT = false;
    this.RrU = false;
    this.RrV = true;
    this.RrW = true;
    this.RrX = 1.0F;
    this.RrZ = null;
    this.handler = new MMHandler();
    this.Rsa = "";
    this.Rsb = -1;
    this.RnM = -1;
    this.Roa = false;
    this.Roc = false;
    this.Rsc = 0L;
    this.RjS = 0;
    this.Rse = new HashMap();
    this.Rsf = new HashSet();
    this.Rsg = 0;
    this.Rsh = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98758);
  }
  
  private void b(dmz paramdmz, int paramInt, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(98764);
    if (this.Rsd != null) {
      this.Rsd.a(paramdmz, paramInt, paramString);
    }
    Object localObject = al.hgB().aZL(paramString);
    if (localObject != null) {
      com.tencent.mm.plugin.sns.ui.a.c.j((SnsInfo)localObject, paramInt);
    }
    if (this.Rsb == -1) {
      this.Rsb = paramInt;
    }
    if ((Util.isNullOrNil(paramString)) && (this.RrL != null))
    {
      i = this.RrL.getCount();
      paramdmz = paramInt + 1 + " / " + i;
      this.RcW.mV(paramdmz, null);
      AppMethodBeat.o(98764);
      return;
    }
    SnsInfo localSnsInfo = (SnsInfo)this.Rse.get(paramString);
    localObject = localSnsInfo;
    if (localSnsInfo == null)
    {
      localObject = al.hgB().aZL(paramString);
      this.Rse.put(paramString, localObject);
    }
    if (localObject == null)
    {
      AppMethodBeat.o(98764);
      return;
    }
    if (paramdmz.vhJ != 6) {
      al.fAG().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98735);
          if (SnsInfoFlip.d(SnsInfoFlip.this) != null) {
            SnsInfoFlip.d(SnsInfoFlip.this).hoM();
          }
          AppMethodBeat.o(98735);
        }
      });
    }
    Log.d("MicroMsg.SnsInfoFlip", "onItemSelected " + paramInt + " localId " + paramString);
    long l1;
    if (this.RnM != paramInt)
    {
      if (!this.RrO.containsKey(Integer.valueOf(paramInt))) {
        break label828;
      }
      i = ((Integer)this.RrO.get(Integer.valueOf(paramInt))).intValue();
      this.RrO.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
      this.RrP.put(Integer.valueOf(paramInt), Long.valueOf(Util.currentTicks()));
      if (this.RnM >= 0)
      {
        if (!this.RrP.containsKey(Integer.valueOf(this.RnM))) {
          break label834;
        }
        l1 = ((Long)this.RrP.get(Integer.valueOf(this.RnM))).longValue();
        label361:
        if (l1 > 0L)
        {
          this.RrP.put(Integer.valueOf(this.RnM), Long.valueOf(0L));
          if (this.RrQ.containsKey(Integer.valueOf(this.RnM))) {
            l2 = ((Long)this.RrQ.get(Integer.valueOf(this.RnM))).longValue();
          }
          l1 = Util.ticksToNow(l1);
          l2 += l1;
          this.RrQ.put(Integer.valueOf(this.RnM), Long.valueOf(l2));
          Log.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + this.RnM + " curtime " + l2 + " passtime " + l1 / 1000.0D);
        }
      }
      if ((this.Roa) && (this.RrL != null))
      {
        paramdmz = this.RrL.ame(this.RnM);
        if (paramdmz != null)
        {
          paramdmz = paramdmz.ibT.Id;
          Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, bigPicId:%s", new Object[] { paramdmz });
          if (this.Rsh.containsKey(paramdmz))
          {
            paramdmz = (a)this.Rsh.get(paramdmz);
            paramdmz.networkType = getReportNetworkType();
            if (paramdmz.Rsl == -1L) {
              break label840;
            }
            paramdmz.Rsj = 1;
            paramdmz.QyX = (paramdmz.Rsl - paramdmz.Rsk);
            Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load success, costTime:%d", new Object[] { Long.valueOf(paramdmz.QyX) });
          }
        }
      }
    }
    label648:
    this.RnM = paramInt;
    if (this.RcV != null) {
      this.RcV.bav(paramString);
    }
    int i = ((SnsInfo)localObject).getCreateTime();
    paramdmz = ((SnsInfo)localObject).getTimeLine();
    localObject = bp.w(this.context, i * 1000L);
    if ((paramdmz != null) && (paramdmz.ContentObj != null) && (paramdmz.ContentObj.Zpr.size() > 1) && (this.RrL != null)) {
      i = paramdmz.ContentObj.Zpr.size();
    }
    for (paramdmz = this.RrL.ame(paramInt).aaiz + 1 + " / " + i;; paramdmz = null)
    {
      this.RcW.mV(String.valueOf(localObject), paramdmz);
      this.RcW.hg(paramString, paramInt);
      if (this.RrL != null) {
        c.a(this.RrL, paramInt);
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
      paramdmz.Rsj = 2;
      paramdmz.Rsl = System.currentTimeMillis();
      paramdmz.QyX = (paramdmz.Rsl - paramdmz.Rsk);
      Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load failed, costTime:%d", new Object[] { Long.valueOf(paramdmz.QyX) });
      break label648;
    }
  }
  
  private int dh(int paramInt, String paramString)
  {
    AppMethodBeat.i(308464);
    if (this.RrL == null)
    {
      AppMethodBeat.o(308464);
      return -1;
    }
    bzi localbzi;
    do
    {
      paramInt += 1;
      if (paramInt >= this.bMQ.size()) {
        break;
      }
      localbzi = this.RrL.ame(paramInt);
    } while ((Util.isNullOrNil(localbzi.parentId)) || (!localbzi.parentId.equals(paramString)));
    this.bMQ.remove(paramInt);
    AppMethodBeat.o(308464);
    return paramInt;
    AppMethodBeat.o(308464);
    return -1;
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
  
  private void hoJ()
  {
    AppMethodBeat.i(98767);
    if ((this.RrL == null) || (this.RrL.ame(this.HOP.getCurrentItem()) == null))
    {
      AppMethodBeat.o(98767);
      return;
    }
    int i = this.HOP.getCurrentItem();
    if ((this.RrR) && (this.RrL.getCount() > 1))
    {
      this.RrY.setVisibility(0);
      this.RrY.setPage(i);
    }
    dmz localdmz = this.RrL.ame(this.HOP.getCurrentItem()).ibT;
    this.Rsf.add(localdmz.Id);
    String str1 = this.RrL.ame(this.HOP.getCurrentItem()).parentId;
    String str2 = localdmz.Id;
    if ((Util.isNullOrNil(this.Rsa)) || (!this.Rsa.equals(str2))) {
      this.Rsa = "";
    }
    b(localdmz, i, str1);
    AppMethodBeat.o(98767);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(98760);
    this.Rsc = System.currentTimeMillis();
    this.context = paramContext;
    this.HOP = ((MMViewPager)inflate(paramContext, b.g.sns_info_flip_view, this).findViewById(b.f.gallery));
    this.HOP.setVerticalFadingEdgeEnabled(false);
    this.HOP.setHorizontalFadingEdgeEnabled(false);
    this.HOP.setOffscreenPageLimit(1);
    this.HOP.setSingleClickOverListener(new MMViewPager.f()
    {
      public final void fBN()
      {
        AppMethodBeat.i(98734);
        SnsInfoFlip.c(SnsInfoFlip.this);
        AppMethodBeat.o(98734);
      }
      
      public final void singleClickOver()
      {
        AppMethodBeat.i(98733);
        if (SnsInfoFlip.b(SnsInfoFlip.this)) {
          SnsInfoFlip.c(SnsInfoFlip.this);
        }
        AppMethodBeat.o(98733);
      }
    });
    this.RrY = ((MMPageControlView)findViewById(b.f.what_news_page_control));
    this.RrY.setIndicatorLayoutRes(b.g.snspage_control_image);
    paramContext = (LinearLayout.LayoutParams)this.RrY.getLayoutParams();
    paramContext.bottomMargin += bf.bk(getContext());
    this.RrY.setLayoutParams(paramContext);
    t.Qor = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zmN, 3200);
    AppMethodBeat.o(98760);
  }
  
  public final void Ei(boolean paramBoolean)
  {
    AppMethodBeat.i(179207);
    if (this.RrL != null)
    {
      Log.d("MicroMsg.SnsInfoFlip", "onRefresh ");
      if (paramBoolean) {
        this.RrL.notifyDataSetChanged();
      }
      hoJ();
    }
    AppMethodBeat.o(179207);
  }
  
  public final void a(List<bzi> paramList, String paramString, int paramInt, ab paramab, z.a parama)
  {
    AppMethodBeat.i(98765);
    al.hgw().a(this);
    this.bMQ = paramList;
    ap.Iz(paramString);
    this.RcV = paramab;
    this.RcW = parama;
    this.RrL = new c(this.context);
    this.HOP.setAdapter(this.RrL);
    if ((paramInt >= 0) && (paramInt < this.bMQ.size()))
    {
      this.HOP.setCurrentItem(paramInt);
      if (this.RrW)
      {
        this.RrW = false;
        paramList = this.RrL.ame(paramInt).ibT;
        if ((paramList == null) || (paramList.aaTn == null) || (paramList.aaTn.aaUc <= 0.0F)) {
          break label341;
        }
      }
    }
    label341:
    for (this.RrX = (paramList.aaTn.aaUb / paramList.aaTn.aaUc);; this.RrX = 1.0F)
    {
      this.HOP.setFadingEdgeLength(0);
      this.HOP.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
            Object localObject1 = SnsInfoFlip.d(SnsInfoFlip.this).ame(paramAnonymousInt).ibT;
            Object localObject2 = SnsInfoFlip.d(SnsInfoFlip.this).ame(paramAnonymousInt).parentId;
            SnsInfoFlip.a(SnsInfoFlip.this, (dmz)localObject1, paramAnonymousInt, (String)localObject2);
            localObject2 = SnsInfoFlip.d(SnsInfoFlip.this).WN(paramAnonymousInt);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = SnsInfoFlip.d(SnsInfoFlip.this).WO(paramAnonymousInt);
            }
            SnsInfoFlip.a(SnsInfoFlip.this, (i)localObject1);
            if (localObject1 != null) {
              ((i)localObject1).jma();
            }
            if ((SnsInfoFlip.g(SnsInfoFlip.this) instanceof SnsBrowseUI)) {
              ((SnsBrowseUI)SnsInfoFlip.g(SnsInfoFlip.this)).hon();
            }
            SnsInfoFlip.d(SnsInfoFlip.this).amb(paramAnonymousInt);
          }
          AppMethodBeat.o(98736);
        }
      });
      this.HOP.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(307595);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(307595);
            return false;
            paramAnonymousView = ad.bCb().M("basescanui@datacenter", true);
            if ((SnsInfoFlip.h(SnsInfoFlip.this) instanceof View))
            {
              PointF localPointF = com.tencent.mm.plugin.scanner.util.p.f((View)SnsInfoFlip.h(SnsInfoFlip.this), paramAnonymousMotionEvent.getRawX(), paramAnonymousMotionEvent.getRawY());
              if (localPointF != null)
              {
                paramAnonymousView.q("key_basescanui_touch_normalize_x", Float.valueOf(localPointF.x));
                paramAnonymousView.q("key_basescanui_touch_normalize_y", Float.valueOf(localPointF.y));
              }
              else
              {
                Log.e("MicroMsg.SnsInfoFlip", "alvinluo get touchCoordinate is invalid");
                paramAnonymousView.q("key_basescanui_screen_position", Boolean.TRUE);
                paramAnonymousView.q("key_basescanui_screen_x", Float.valueOf(paramAnonymousMotionEvent.getRawX()));
                paramAnonymousView.q("key_basescanui_screen_y", Float.valueOf(paramAnonymousMotionEvent.getRawY()));
              }
            }
          }
        }
      });
      if (this.RrN) {
        this.HOP.setLongClickOverListener(new MMViewPager.d()
        {
          public final void longClickOver()
          {
            AppMethodBeat.i(307599);
            if (!SnsInfoFlip.i(SnsInfoFlip.this))
            {
              AppMethodBeat.o(307599);
              return;
            }
            if (SnsInfoFlip.d(SnsInfoFlip.this) == null)
            {
              Log.e("MicroMsg.SnsInfoFlip", "longClickOver, adapter is null.");
              AppMethodBeat.o(307599);
              return;
            }
            bzi localbzi = SnsInfoFlip.d(SnsInfoFlip.this).ame(SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem());
            if ((localbzi == null) || (Util.isNullOrNil(localbzi.parentId)))
            {
              AppMethodBeat.o(307599);
              return;
            }
            if (SnsInfoFlip.this.onLongClickListener != null) {
              SnsInfoFlip.this.onLongClickListener.onLongClick(SnsInfoFlip.j(SnsInfoFlip.this));
            }
            Object localObject1 = new hj();
            ((hj)localObject1).ikE = 1L;
            if (SnsInfoFlip.k(SnsInfoFlip.this)) {}
            for (((hj)localObject1).iOd = 6L;; ((hj)localObject1).iOd = 7L)
            {
              Object localObject2 = SnsInfoFlip.d(SnsInfoFlip.this).ame(SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem()).ibT;
              ((hj)localObject1).rq(((dmz)localObject2).Url);
              ((hj)localObject1).bMH();
              localObject1 = ((dmz)localObject2).Id;
              localObject2 = as.mg(al.getAccSnsPath(), (String)localObject1) + t.k(SnsInfoFlip.d(SnsInfoFlip.this).ame(SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem()).ibT);
              SnsInfoFlip.this.j((String)localObject2, localbzi.parentId, (String)localObject1, true);
              AppMethodBeat.o(307599);
              return;
            }
          }
        });
      }
      if ((this.RrR) && (this.RrL.getCount() > 1))
      {
        this.RrY.setVisibility(0);
        this.RrY.oj(this.RrL.getCount(), paramInt);
      }
      if ((this.Roc) && (!Util.isNullOrNil(this.RrL.ame(paramInt).parentId)))
      {
        paramList = this.RrL.ame(paramInt).ibT.Id;
        bau(as.mg(al.getAccSnsPath(), paramList) + t.k(this.RrL.ame(paramInt).ibT));
      }
      AppMethodBeat.o(98765);
      return;
    }
  }
  
  public final boolean baF(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(308519);
    if ((this.RrL == null) || (this.bMQ == null))
    {
      AppMethodBeat.o(308519);
      return false;
    }
    while (i >= 0) {
      i = dh(i, paramString);
    }
    this.RrL.notifyDataSetChanged();
    AppMethodBeat.o(308519);
    return true;
  }
  
  public final void cpX()
  {
    AppMethodBeat.i(308513);
    if ((this.RrL == null) || (this.HOP == null))
    {
      AppMethodBeat.o(308513);
      return;
    }
    try
    {
      int i = this.HOP.getCurrentItem();
      bzi localbzi = this.RrL.ame(i);
      String str = localbzi.ibT.Id;
      j(as.mg(al.getAccSnsPath(), str) + t.k(this.RrL.ame(this.HOP.getCurrentItem()).ibT), localbzi.parentId, str, true);
      AppMethodBeat.o(308513);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(308513);
    }
  }
  
  public dmz getCntMedia()
  {
    AppMethodBeat.i(98772);
    if (this.RrL != null)
    {
      int i = this.HOP.getCurrentItem();
      if ((this.bMQ != null) && (i < this.bMQ.size()))
      {
        dmz localdmz = this.RrL.ame(i).ibT;
        AppMethodBeat.o(98772);
        return localdmz;
      }
    }
    AppMethodBeat.o(98772);
    return null;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(98771);
    if (this.RrL != null)
    {
      int i = this.RrL.getCount();
      AppMethodBeat.o(98771);
      return i;
    }
    AppMethodBeat.o(98771);
    return 0;
  }
  
  public View getCurrentImageView()
  {
    if ((this.RrM instanceof View)) {
      return (View)this.RrM;
    }
    return null;
  }
  
  public List<bzi> getFlipList()
  {
    return this.bMQ;
  }
  
  public br getFromScene()
  {
    return this.Qob;
  }
  
  public MMViewPager getGallery()
  {
    return this.HOP;
  }
  
  public int getNumOfFileExist()
  {
    AppMethodBeat.i(98774);
    Iterator localIterator = this.bMQ.iterator();
    int k = 0;
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (localIterator.hasNext())
      {
        bzi localbzi = (bzi)localIterator.next();
        al.hgy();
        j = i;
        if (y.ZC(g.D(localbzi.ibT))) {
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
    return this.RnM;
  }
  
  public int getSelectCount()
  {
    AppMethodBeat.i(98773);
    int i = this.Rsf.size();
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
    localObject = ((bzi)localObject).parentId;
    AppMethodBeat.o(98763);
    return localObject;
  }
  
  public bzi getSelectItem()
  {
    AppMethodBeat.i(308514);
    if ((this.HOP != null) && (this.RrL != null))
    {
      int i = this.HOP.getCurrentItem();
      bzi localbzi = this.RrL.ame(i);
      AppMethodBeat.o(308514);
      return localbzi;
    }
    AppMethodBeat.o(308514);
    return null;
  }
  
  public String getSelectedMediaId()
  {
    AppMethodBeat.i(98762);
    Object localObject = getCntMedia();
    if (localObject != null)
    {
      localObject = ((dmz)localObject).Id;
      AppMethodBeat.o(98762);
      return localObject;
    }
    AppMethodBeat.o(98762);
    return null;
  }
  
  public long getSnsId()
  {
    AppMethodBeat.i(98766);
    if (this.RrL == null)
    {
      AppMethodBeat.o(98766);
      return 0L;
    }
    Object localObject = this.RrL.ame(this.HOP.getCurrentItem());
    if (localObject == null) {
      localObject = "";
    }
    while (!Util.isNullOrNil((String)localObject))
    {
      localObject = al.hgB().aZL((String)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(98766);
        return 0L;
        localObject = ((bzi)localObject).parentId;
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
    return this.RrX;
  }
  
  public final boolean hlX()
  {
    return this.Roa;
  }
  
  public final int hoK()
  {
    AppMethodBeat.i(98770);
    if ((this.HOP == null) || (this.RrL == null))
    {
      AppMethodBeat.o(98770);
      return -1;
    }
    int i = this.HOP.getCurrentItem();
    if ((i >= 0) && (this.bMQ.size() > i))
    {
      this.bMQ.remove(i);
      this.RrL.notifyDataSetChanged();
      hoJ();
    }
    i = this.RrL.getCount();
    AppMethodBeat.o(98770);
    return i;
  }
  
  public final void hoL()
  {
    AppMethodBeat.i(98778);
    Iterator localIterator = this.Rsh.values().iterator();
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
      if (locala.Rsj != -1)
      {
        localSnsInfo = al.hgB().aZL(locala.hHB);
        str = as.mg(al.getAccSnsPath(), locala.Rsn) + t.k(locala.Qsr);
        localOptions = BitmapUtil.getImageOptions(str);
        k = 0;
        j = 0;
        i = (int)y.bEl(str);
        if (localOptions != null)
        {
          k = localOptions.outWidth;
          j = localOptions.outHeight;
          i = (int)y.bEl(str);
        }
        m = t.aIP(str);
        if (locala.Qsr.mediaType != 0) {
          m = locala.Qsr.mediaType;
        }
        if (localSnsInfo != null)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(11601, new Object[] { Integer.valueOf(locala.nVc), Integer.valueOf(locala.Rsj), Long.valueOf(locala.QyX), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.Rsk), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          Log.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.nVc), Integer.valueOf(locala.Rsj), Long.valueOf(locala.QyX), Integer.valueOf(locala.networkType), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.Rsk), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(t.aIP(str)), str });
        }
      }
      else if (locala.Rsk != -1L)
      {
        if (locala.Rsl != -1L) {
          locala.Rsj = 1;
        }
        for (;;)
        {
          locala.QyX = (locala.Rsl - locala.Rsk);
          localSnsInfo = al.hgB().aZL(locala.hHB);
          str = as.mg(al.getAccSnsPath(), locala.Rsn) + t.k(locala.Qsr);
          localOptions = BitmapUtil.getImageOptions(str);
          k = 0;
          j = 0;
          i = (int)y.bEl(str);
          if (localOptions != null)
          {
            k = localOptions.outWidth;
            j = localOptions.outHeight;
            i = (int)y.bEl(str);
          }
          m = t.aIP(str);
          if (locala.Qsr.mediaType != 0) {
            m = locala.Qsr.mediaType;
          }
          if (localSnsInfo == null) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(11601, new Object[] { Integer.valueOf(locala.nVc), Integer.valueOf(locala.Rsj), Long.valueOf(locala.QyX), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.Rsk), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          Log.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.nVc), Integer.valueOf(locala.Rsj), Long.valueOf(locala.QyX), Integer.valueOf(locala.networkType), Long.valueOf(localSnsInfo.field_snsId), Long.valueOf(locala.Rsk), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(t.aIP(str)), str });
          break;
          locala.Rsj = 2;
          locala.Rsl = System.currentTimeMillis();
        }
      }
    }
    this.Rsh.clear();
    AppMethodBeat.o(98778);
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(98779);
    super.onDestroy();
    if (this.RrL != null)
    {
      this.RrL.detach();
      this.RrL = null;
    }
    AppMethodBeat.o(98779);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(98769);
    super.onPause();
    if (this.RrL != null)
    {
      this.RrL.hoM();
      this.RrL.clear();
    }
    AppMethodBeat.o(98769);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.RrU = paramBoolean;
  }
  
  public void setEnableSingleClickOver(boolean paramBoolean)
  {
    this.RrV = paramBoolean;
  }
  
  public void setFromScene(br parambr)
  {
    this.Qob = parambr;
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
    this.Roa = paramBoolean;
  }
  
  public void setIsSoonEnterPhotoEditUI(boolean paramBoolean)
  {
    this.Roc = paramBoolean;
  }
  
  public void setItems(List<bzi> paramList)
  {
    this.bMQ = paramList;
  }
  
  public void setOnDeleteAllAction(Runnable paramRunnable)
  {
    this.RrZ = paramRunnable;
  }
  
  public void setOnPageSelectListener(b paramb)
  {
    this.Rsd = paramb;
  }
  
  public void setShowLongClickMenu(boolean paramBoolean)
  {
    this.RrN = paramBoolean;
  }
  
  public void setShowPageControl(boolean paramBoolean)
  {
    this.RrR = paramBoolean;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.RrT = paramBoolean;
  }
  
  public void setTouchFinish(boolean paramBoolean)
  {
    this.RrS = paramBoolean;
  }
  
  public void setUIFromScene(int paramInt)
  {
    this.Rdp = paramInt;
  }
  
  public void setVideoScene(int paramInt)
  {
    this.RjS = paramInt;
  }
  
  public final void w(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(98775);
    if (this.RrL == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsInfoFlip", "onImageFinish, mediaId: %s, isOK: %s, null == adapter: %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (this.RrL != null) {
        break;
      }
      AppMethodBeat.o(98775);
      return;
    }
    dmz localdmz = this.RrL.ame(this.HOP.getCurrentItem()).ibT;
    if ((!paramBoolean) && (localdmz != null) && (localdmz != null) && (localdmz.Id != null) && (localdmz.Id.equals(paramString)))
    {
      Toast.makeText(this.context, this.context.getString(b.j.sns_down_error), 0).show();
      this.Rsa = paramString;
    }
    this.Rsg += 1;
    Object localObject;
    if (this.Roa)
    {
      localObject = "";
      if (localdmz != null) {
        localObject = localdmz.Id;
      }
      Log.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b, mediaId:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), localObject });
      if ((paramBoolean) && (this.Rsh.containsKey(paramString)))
      {
        localObject = (a)this.Rsh.get(paramString);
        ((a)localObject).Rsl = System.currentTimeMillis();
        ((a)localObject).networkType = getReportNetworkType();
        Log.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
      }
    }
    int j;
    if ((localdmz != null) && (localdmz != null) && (localdmz.Id != null) && (localdmz.Id.equals(paramString)))
    {
      Log.i("MicroMsg.SnsInfoFlip", "img download finish, refresh ui, media id: %s. and mediaLocal id %s", new Object[] { localdmz.Id, Integer.valueOf(localdmz.icg) });
      localObject = this.RrL;
      j = ((c)localObject).Rsi.bMQ.size();
    }
    for (;;)
    {
      if (i < j)
      {
        bzi localbzi = ((c)localObject).ame(i);
        if ((localbzi != null) && (localbzi.ibT.Id.equals(paramString))) {
          ((c)localObject).amb(i);
        }
      }
      else
      {
        if (this.Roc) {
          F(localdmz);
        }
        AppMethodBeat.o(98775);
        return;
      }
      i += 1;
    }
  }
  
  public final void x(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98776);
    Object localObject = new StringBuilder("onSightFinish ").append(paramString).append(" ").append(paramBoolean).append(" ");
    if (this.RrL == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsInfoFlip", bool);
      if (this.RrL != null) {
        break;
      }
      AppMethodBeat.o(98776);
      return;
    }
    if ((!paramBoolean) && (this.RrL.ame(this.HOP.getCurrentItem()) != null))
    {
      localObject = this.RrL.ame(this.HOP.getCurrentItem()).ibT;
      if ((localObject != null) && (((dmz)localObject).Id != null) && (((dmz)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(b.j.sns_down_sight_error), 0).show();
        this.Rsa = paramString;
      }
    }
    this.RrL.notifyDataSetChanged();
    AppMethodBeat.o(98776);
  }
  
  final class a
  {
    dmz Qsr;
    long QyX = -1L;
    int Rsj = -1;
    long Rsk = -1L;
    long Rsl = -1L;
    dnb Rsm;
    String Rsn;
    String hHB = "";
    int nVc;
    int networkType;
    
    a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(dmz paramdmz, int paramInt, String paramString);
  }
  
  final class c
    extends com.tencent.mm.ui.base.ab
  {
    private int Rso;
    private String Rsp;
    Map<String, WeakReference<View>> Rsq;
    private boolean Rsr;
    private Context context;
    private boolean xon;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(98742);
      this.Rsq = new HashMap();
      this.Rsr = false;
      this.context = paramContext;
      this.Rso = SnsInfoFlip.l(SnsInfoFlip.this).size();
      d.bId();
      this.xon = d.bIf();
      AppMethodBeat.o(98742);
    }
    
    private void a(final SnsInfoFlip.d paramd, final int paramInt, final dmz paramdmz, final boolean paramBoolean)
    {
      AppMethodBeat.i(307658);
      final br localbr = br.a(SnsInfoFlip.this.Qob, ame(paramInt).createTime);
      g localg = al.hgy();
      MultiTouchImageView localMultiTouchImageView = paramd.RsB;
      int i = this.context.hashCode();
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        localg.a(paramdmz, localMultiTouchImageView, i, bool, localbr, ai.bao(ame(paramInt).parentId), new g.e()
        {
          public final void aN(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(98741);
            if ((!t.S(paramAnonymousBitmap)) && (SnsInfoFlip.k(SnsInfoFlip.this)) && (SnsInfoFlip.this.getSelectItem() != null)) {
              SnsInfoFlip.a(SnsInfoFlip.this, paramdmz.Id, SnsInfoFlip.this.getSelectItem().parentId, paramdmz.aaTn, paramdmz);
            }
            if ((!t.S(paramAnonymousBitmap)) && (paramdmz.Id != null) && (!paramdmz.Id.startsWith("pre_temp_extend_pic")))
            {
              Log.i("MicroMsg.SnsGalleryAdapter", "big image not ready, set loading img. position: %d, media id: %s.", new Object[] { Integer.valueOf(paramInt), paramdmz.Id });
              paramd.RsA.setVisibility(0);
              paramd.pRi.setVisibility(0);
              paramd.pRi.setAlpha(0.1F);
              paramd.pRi.animate().alpha(1.0F).setDuration(2000L).setListener(null);
              paramd.RsB.setVisibility(8);
              paramd.HOl.setVisibility(8);
              al.hgy().jq(paramd.RsA);
              al.hgy().b(paramdmz, paramd.RsA, b.e.black, SnsInfoFlip.c.a(SnsInfoFlip.c.this).hashCode(), localbr);
              if (paramBoolean)
              {
                paramd.pRi.setVisibility(8);
                AppMethodBeat.o(98741);
              }
            }
            else if (t.S(paramAnonymousBitmap))
            {
              Log.i("MicroMsg.SnsGalleryAdapter", "pennqin, use multiTouchImageView, %s.", new Object[] { paramd.RsB });
              paramd.RsB.setVisibility(0);
              paramd.HOl.setVisibility(8);
              paramd.RsB.setEnableHorLongBmpMode(SnsInfoFlip.p(SnsInfoFlip.this));
              paramd.RsB.dU(paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight());
              paramd.RsB.setImageBitmap(null);
              paramd.RsB.setImageBitmap(paramAnonymousBitmap);
              paramd.RsB.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98740);
                  SnsInfoFlip.c.2.this.Rss.RsA.setVisibility(8);
                  SnsInfoFlip.c.2.this.Rss.pRi.setVisibility(8);
                  AppMethodBeat.o(98740);
                }
              });
              if ((SnsInfoFlip.j(SnsInfoFlip.this) != null) && (paramInt == SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem())) {
                SnsInfoFlip.a(SnsInfoFlip.this, paramd.RsB);
              }
            }
            AppMethodBeat.o(98741);
          }
        });
        AppMethodBeat.o(307658);
        return;
      }
    }
    
    private void ama(int paramInt)
    {
      AppMethodBeat.i(98746);
      Object localObject1 = ame(paramInt);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but flip item is null.");
        AppMethodBeat.o(98746);
        return;
      }
      String str = ((bzi)localObject1).parentId;
      if (Util.isNullOrNil(str))
      {
        Log.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but sns local id is null.");
        AppMethodBeat.o(98746);
        return;
      }
      Log.i("MicroMsg.SnsGalleryAdapter", "notify online sight play pos %s sns local id %s.", new Object[] { Integer.valueOf(paramInt), str });
      Object localObject2 = (WeakReference)this.Rsq.get(str);
      if (localObject2 == null)
      {
        Log.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but view cache is null.");
        this.Rsp = str;
        AppMethodBeat.o(98746);
        return;
      }
      localObject2 = (OnlineVideoView)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        Log.w("MicroMsg.SnsGalleryAdapter", "online sight view is null, do nothing. snsLocalId %s.", new Object[] { str });
        this.Rsp = str;
        AppMethodBeat.o(98746);
        return;
      }
      Log.i("MicroMsg.SnsGalleryAdapter", "%d notify online sight play video %s.", new Object[] { Integer.valueOf(localObject2.hashCode()), str });
      this.Rsp = null;
      ((OnlineVideoView)localObject2).hmz();
      ((OnlineVideoView)localObject2).a(((bzi)localObject1).ibT, ((bzi)localObject1).parentId, ((bzi)localObject1).createTime);
      localObject1 = new yk();
      ((yk)localObject1).ibL.hId = 1;
      ((yk)localObject1).ibL.hHB = str;
      ((yk)localObject1).publish();
      AppMethodBeat.o(98746);
    }
    
    private void amc(int paramInt)
    {
      AppMethodBeat.i(98753);
      if (!this.xon)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (SnsInfoFlip.d(SnsInfoFlip.this) == null)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (!ah.eb(this.context))
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (paramInt - 1 >= 0) {
        amd(paramInt - 1);
      }
      if (paramInt + 1 < SnsInfoFlip.d(SnsInfoFlip.this).getCount()) {
        amd(paramInt + 1);
      }
      AppMethodBeat.o(98753);
    }
    
    private void amd(int paramInt)
    {
      AppMethodBeat.i(98754);
      dmz localdmz = ame(paramInt).ibT;
      br localbr = br.a(SnsInfoFlip.this.Qob, ame(paramInt).createTime);
      if (localdmz.vhJ != 2)
      {
        AppMethodBeat.o(98754);
        return;
      }
      boolean bool = ai.bao(ame(paramInt).parentId);
      al.hgy();
      bool = g.a(localdmz, localbr, bool);
      if ((SnsInfoFlip.k(SnsInfoFlip.this)) && (!bool)) {
        SnsInfoFlip.a(SnsInfoFlip.this, localdmz.Id, SnsInfoFlip.this.getSelectItem().parentId, localdmz.aaTn, localdmz);
      }
      AppMethodBeat.o(98754);
    }
    
    private View u(final int paramInt, View paramView)
    {
      final boolean bool = true;
      AppMethodBeat.i(98750);
      Object localObject2 = ame(paramInt).ibT;
      final SnsInfoFlip.d locald;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        locald = new SnsInfoFlip.d();
        paramView = View.inflate(this.context, b.g.sns_gallery_item, null);
        locald.Rsz = paramView.findViewById(b.f.gallery_item);
        locald.RsA = ((ImageView)paramView.findViewById(b.f.loading_image));
        locald.pRi = ((ProgressBar)paramView.findViewById(b.f.loading_pb));
        locald.RsB = ((MultiTouchImageView)paramView.findViewById(b.f.mul_image));
        locald.HOl = ((WxImageView)paramView.findViewById(b.f.wx_image));
        paramView.setTag(locald);
        Log.d("MicroMsg.SnsGalleryAdapter", "gallery position %d, media id: %s, %s.", new Object[] { Integer.valueOf(paramInt), ((dmz)localObject2).Id, locald.RsB });
        locald.position = paramInt;
        locald.HOl.setContentDescription(String.format(SnsInfoFlip.this.getResources().getString(b.j.sns_gallery_img_item), new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(getCount()) }));
        locald.RsB.setContentDescription(String.format(SnsInfoFlip.this.getResources().getString(b.j.sns_gallery_img_item), new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(getCount()) }));
        if ((Util.isNullOrNil(SnsInfoFlip.n(SnsInfoFlip.this))) || (!SnsInfoFlip.n(SnsInfoFlip.this).equals(((dmz)localObject2).Id))) {
          break label425;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (!((dmz)localObject2).Id.startsWith("Locall_path")) {
          break label488;
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil(ame(paramInt).parentId)) {
          break label488;
        }
        localObject3 = (SnsInfo)SnsInfoFlip.o(SnsInfoFlip.this).get(ame(paramInt).parentId);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = al.hgB().aZL(ame(paramInt).parentId);
          SnsInfoFlip.o(SnsInfoFlip.this).put(ame(paramInt).parentId, localObject1);
        }
        if (localObject1 != null) {
          break label431;
        }
        AppMethodBeat.o(98750);
        return paramView;
        locald = (SnsInfoFlip.d)paramView.getTag();
        break;
        label425:
        bool = false;
      }
      label431:
      Object localObject3 = ((SnsInfo)localObject1).getTimeLine();
      Object localObject1 = localObject2;
      if (((TimeLineObject)localObject3).ContentObj.Zpr.size() > ame(paramInt).aaiz) {
        localObject1 = (dmz)((TimeLineObject)localObject3).ContentObj.Zpr.get(ame(paramInt).aaiz);
      }
      label488:
      localObject2 = g.D((dmz)localObject1);
      if ((!Util.isNullOrNil((String)localObject2)) && (SnsInfoFlip.baG((String)localObject2)))
      {
        Log.i("MicroMsg.SnsGalleryAdapter", "pennqin, use wxImageView.");
        locald.RsB.setVisibility(8);
        locald.HOl.setVisibility(0);
        localObject3 = BitmapUtil.getImageOptions((String)localObject2);
        if (localObject3 != null)
        {
          int i = BackwardSupportUtil.ExifHelper.getExifOrientation((String)localObject2);
          locald.HOl.setOrientation(i);
          locald.HOl.dU(((BitmapFactory.Options)localObject3).outWidth, ((BitmapFactory.Options)localObject3).outHeight);
          locald.HOl.jma();
          locald.HOl.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
          {
            public final void onImageLoadError(ImageDecodeResult paramAnonymousImageDecodeResult)
            {
              AppMethodBeat.i(307940);
              Log.w("MicroMsg.SnsGalleryAdapter", "onImageLoadError, switch to multiTouchImageView");
              SnsInfoFlip.c.a(SnsInfoFlip.c.this, locald, paramInt, this.Rst, bool);
              AppMethodBeat.o(307940);
            }
            
            public final void onImageLoaded(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(98739);
              Log.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on image loaded.");
              locald.RsA.setVisibility(8);
              locald.pRi.setVisibility(8);
              if ((SnsInfoFlip.j(SnsInfoFlip.this) != null) && (paramInt == SnsInfoFlip.j(SnsInfoFlip.this).getCurrentItem())) {
                SnsInfoFlip.a(SnsInfoFlip.this, locald.HOl);
              }
              AppMethodBeat.o(98739);
            }
            
            public final void onPreviewLoadError(ImageDecodeResult paramAnonymousImageDecodeResult) {}
            
            public final void onPreviewLoaded()
            {
              AppMethodBeat.i(98738);
              Log.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on preview loaded.");
              AppMethodBeat.o(98738);
            }
            
            public final void onPreviewReleased() {}
            
            public final void onTileLoadError(ImageDecodeResult paramAnonymousImageDecodeResult) {}
          });
          localObject1 = Uri.encode(y.n(g.r((dmz)localObject1), false));
          if (!Util.isNullOrNil((String)localObject1)) {
            locald.HOl.a(y.n((String)localObject2, false), ImageSource.uri((String)localObject1));
          }
        }
      }
      for (;;)
      {
        amc(paramInt);
        AppMethodBeat.o(98750);
        return paramView;
        a(locald, paramInt, (dmz)localObject1, bool);
      }
    }
    
    public final MultiTouchImageView WN(int paramInt)
    {
      AppMethodBeat.i(98743);
      Object localObject = super.aAZ(paramInt);
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
      if (((SnsInfoFlip.d)localObject).RsB.getVisibility() == 8)
      {
        AppMethodBeat.o(98743);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).RsB;
      AppMethodBeat.o(98743);
      return localObject;
    }
    
    public final WxImageView WO(int paramInt)
    {
      AppMethodBeat.i(98744);
      Object localObject = super.aAZ(paramInt);
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
      if (((SnsInfoFlip.d)localObject).HOl.getVisibility() == 8)
      {
        AppMethodBeat.o(98744);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).HOl;
      AppMethodBeat.o(98744);
      return localObject;
    }
    
    final boolean amb(int paramInt)
    {
      AppMethodBeat.i(98752);
      View localView = aAZ(paramInt);
      if ((localView != null) && (WN(paramInt) == null) && (WO(paramInt) == null))
      {
        u(paramInt, localView);
        AppMethodBeat.o(98752);
        return true;
      }
      AppMethodBeat.o(98752);
      return false;
    }
    
    public final bzi ame(int paramInt)
    {
      AppMethodBeat.i(307675);
      if ((paramInt < SnsInfoFlip.l(SnsInfoFlip.this).size()) && (paramInt >= 0))
      {
        bzi localbzi = (bzi)SnsInfoFlip.l(SnsInfoFlip.this).get(paramInt);
        AppMethodBeat.o(307675);
        return localbzi;
      }
      AppMethodBeat.o(307675);
      return null;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(98747);
      Log.i("MicroMsg.SnsGalleryAdapter", "adapter clear.");
      this.Rsq.clear();
      AppMethodBeat.o(98747);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(98751);
      paramViewGroup.removeView((View)paramObject);
      super.destroyItem(paramViewGroup, paramInt, paramObject);
      AppMethodBeat.o(98751);
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
      if (this.Rsr)
      {
        AppMethodBeat.o(98757);
        return -2;
      }
      int i = super.getItemPosition(paramObject);
      AppMethodBeat.o(98757);
      return i;
    }
    
    public final void hoM()
    {
      AppMethodBeat.i(98749);
      Log.i("MicroMsg.SnsGalleryAdapter", "notify online sight stop %s", new Object[] { Util.getStack() });
      yk localyk = new yk();
      localyk.ibL.context = this.context;
      localyk.ibL.hHB = this.Rsp;
      localyk.ibL.hId = 2;
      localyk.publish();
      this.Rsp = null;
      AppMethodBeat.o(98749);
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(98755);
      this.Rsr = true;
      super.notifyDataSetChanged();
      this.Rsr = false;
      this.Rso = SnsInfoFlip.l(SnsInfoFlip.this).size();
      Log.d("MicroMsg.SnsGalleryAdapter", "items.size: %d.", new Object[] { Integer.valueOf(this.Rso) });
      if ((this.Rso <= 0) && (SnsInfoFlip.q(SnsInfoFlip.this) != null)) {
        SnsInfoFlip.q(SnsInfoFlip.this).run();
      }
      AppMethodBeat.o(98755);
    }
    
    public final Object p(int paramInt, View paramView)
    {
      AppMethodBeat.i(98745);
      if (ame(paramInt).ibT.vhJ == 6)
      {
        boolean bool;
        bzi localbzi;
        if (paramView == null)
        {
          bool = true;
          Log.d("MicroMsg.SnsGalleryAdapter", "fill view online sight %d convert view is null %b.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
          localbzi = ame(paramInt);
          if (localbzi != null) {
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
          localObject = localbzi.parentId;
          if (!Util.isNullOrNil((String)localObject)) {
            break label120;
          }
          Log.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but sns local id is null.");
        }
        label120:
        paramView = (WeakReference)this.Rsq.get(localObject);
        if ((paramView != null) && (paramView.get() != null)) {
          paramView = (OnlineVideoView)paramView.get();
        }
        for (;;)
        {
          paramView.bu(null);
          if (Util.isEqual((String)localObject, this.Rsp)) {
            ama(paramInt);
          }
          Log.i("MicroMsg.SnsGalleryAdapter", "return online sight view %d parent id %s.", new Object[] { Integer.valueOf(paramView.hashCode()), localbzi.parentId });
          SnsInfo localSnsInfo = al.hgB().aZL((String)localObject);
          localObject = paramView;
          if (localSnsInfo == null) {
            break;
          }
          paramView.setScene(SnsInfoFlip.m(SnsInfoFlip.this));
          localObject = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          paramView.setSessionId(new com.tencent.mm.b.p(com.tencent.mm.kernel.b.getUin()).toString() + "_" + Util.nowMilliSecond());
          paramView.setSessionTimestamp(Util.nowMilliSecond());
          paramView.setSnsId(t.uA(localSnsInfo.field_snsId));
          paramView.setFilePath(az.E(localbzi.ibT));
          localObject = paramView;
          if (!a.aTj()) {
            break;
          }
          paramView.setMute(true);
          localObject = paramView;
          break;
          paramView = new OnlineVideoView(this.context, (byte)0);
          this.Rsq.put(localObject, new WeakReference(paramView));
        }
      }
      paramView = u(paramInt, paramView);
      AppMethodBeat.o(98745);
      return paramView;
    }
  }
  
  static final class d
  {
    WxImageView HOl;
    ImageView RsA;
    MultiTouchImageView RsB;
    View Rsz;
    ProgressBar pRi;
    int position;
    String videoPath = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip
 * JD-Core Version:    0.7.0.1
 */