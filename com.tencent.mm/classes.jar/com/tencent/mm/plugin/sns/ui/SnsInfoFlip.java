package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.g.b.a.bo;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.f.e;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.base.MMViewPager.e;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.i;
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
  private Context context;
  private ao handler;
  List<com.tencent.mm.plugin.sns.i.b> hqR;
  boolean isAd;
  MMViewPager sRJ;
  public String username;
  private int yFi;
  int yIE;
  private boolean yIK;
  private boolean yIM;
  c yMd;
  private boolean yMe;
  HashMap<Integer, Integer> yMf;
  HashMap<Integer, Long> yMg;
  HashMap<Integer, Long> yMh;
  private boolean yMi;
  private boolean yMj;
  private boolean yMk;
  private boolean yMl;
  private boolean yMm;
  private float yMn;
  MMPageControlView yMo;
  private Runnable yMp;
  private String yMq;
  private int yMr;
  long yMs;
  private b yMt;
  private HashMap<String, com.tencent.mm.plugin.sns.storage.p> yMu;
  private HashSet<String> yMv;
  public int yMw;
  private HashMap<String, a> yMx;
  
  public SnsInfoFlip(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98759);
    this.isAd = false;
    this.yMe = true;
    this.yMf = new HashMap();
    this.yMg = new HashMap();
    this.yMh = new HashMap();
    this.yMi = false;
    this.yMj = false;
    this.yMk = false;
    this.yMl = false;
    this.yMm = true;
    this.yMn = 1.0F;
    this.yMp = null;
    this.handler = new ao();
    this.yMq = "";
    this.yMr = -1;
    this.yIE = -1;
    this.yIK = false;
    this.yIM = false;
    this.yMs = 0L;
    this.yFi = 0;
    this.yMu = new HashMap();
    this.yMv = new HashSet();
    this.yMw = 0;
    this.yMx = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98759);
  }
  
  public SnsInfoFlip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98758);
    this.isAd = false;
    this.yMe = true;
    this.yMf = new HashMap();
    this.yMg = new HashMap();
    this.yMh = new HashMap();
    this.yMi = false;
    this.yMj = false;
    this.yMk = false;
    this.yMl = false;
    this.yMm = true;
    this.yMn = 1.0F;
    this.yMp = null;
    this.handler = new ao();
    this.yMq = "";
    this.yMr = -1;
    this.yIE = -1;
    this.yIK = false;
    this.yIM = false;
    this.yMs = 0L;
    this.yFi = 0;
    this.yMu = new HashMap();
    this.yMv = new HashSet();
    this.yMw = 0;
    this.yMx = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98758);
  }
  
  private void b(btz parambtz, int paramInt, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(98764);
    if (this.yMt != null) {
      this.yMt.a(parambtz, paramInt, paramString);
    }
    Object localObject = af.dHR().auT(paramString);
    if (localObject != null) {
      com.tencent.mm.plugin.sns.ui.a.c.g((com.tencent.mm.plugin.sns.storage.p)localObject, paramInt);
    }
    if (this.yMr == -1) {
      this.yMr = paramInt;
    }
    if ((bs.isNullOrNil(paramString)) && (this.yMd != null))
    {
      i = this.yMd.getCount();
      parambtz = paramInt + 1 + " / " + i;
      this.yze.jI(parambtz, null);
      AppMethodBeat.o(98764);
      return;
    }
    com.tencent.mm.plugin.sns.storage.p localp = (com.tencent.mm.plugin.sns.storage.p)this.yMu.get(paramString);
    localObject = localp;
    if (localp == null)
    {
      localObject = af.dHR().auT(paramString);
      this.yMu.put(paramString, localObject);
    }
    if (localObject == null)
    {
      AppMethodBeat.o(98764);
      return;
    }
    if (parambtz.ndI != 6) {
      af.cMM().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98735);
          if (SnsInfoFlip.c(SnsInfoFlip.this) != null) {
            SnsInfoFlip.c(SnsInfoFlip.this).dPL();
          }
          AppMethodBeat.o(98735);
        }
      });
    }
    ac.d("MicroMsg.SnsInfoFlip", "onItemSelected " + paramInt + " localId " + paramString);
    long l1;
    if (this.yIE != paramInt)
    {
      if (!this.yMf.containsKey(Integer.valueOf(paramInt))) {
        break label832;
      }
      i = ((Integer)this.yMf.get(Integer.valueOf(paramInt))).intValue();
      this.yMf.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
      this.yMg.put(Integer.valueOf(paramInt), Long.valueOf(bs.Gn()));
      if (this.yIE >= 0)
      {
        if (!this.yMg.containsKey(Integer.valueOf(this.yIE))) {
          break label838;
        }
        l1 = ((Long)this.yMg.get(Integer.valueOf(this.yIE))).longValue();
        label364:
        if (l1 > 0L)
        {
          this.yMg.put(Integer.valueOf(this.yIE), Long.valueOf(0L));
          if (this.yMh.containsKey(Integer.valueOf(this.yIE))) {
            l2 = ((Long)this.yMh.get(Integer.valueOf(this.yIE))).longValue();
          }
          l1 = bs.aO(l1);
          l2 += l1;
          this.yMh.put(Integer.valueOf(this.yIE), Long.valueOf(l2));
          ac.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + this.yIE + " curtime " + l2 + " passtime " + l1 / 1000.0D);
        }
      }
      if ((this.yIK) && (this.yMd != null))
      {
        parambtz = this.yMd.PB(this.yIE);
        if (parambtz != null)
        {
          parambtz = parambtz.dwE.Id;
          ac.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, bigPicId:%s", new Object[] { parambtz });
          if (this.yMx.containsKey(parambtz))
          {
            parambtz = (a)this.yMx.get(parambtz);
            parambtz.networkType = getReportNetworkType();
            if (parambtz.yMB == -1L) {
              break label844;
            }
            parambtz.yMz = 1;
            parambtz.xXj = (parambtz.yMB - parambtz.yMA);
            ac.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load success, costTime:%d", new Object[] { Long.valueOf(parambtz.xXj) });
          }
        }
      }
    }
    label651:
    this.yIE = paramInt;
    if (this.yzd != null) {
      this.yzd.avx(paramString);
    }
    int i = ((com.tencent.mm.plugin.sns.storage.p)localObject).field_createTime;
    parambtz = ((com.tencent.mm.plugin.sns.storage.p)localObject).dLV();
    localObject = bg.q(this.context, i * 1000L);
    if ((parambtz != null) && (parambtz.FQo != null) && (parambtz.FQo.Etz.size() > 1) && (this.yMd != null)) {
      i = parambtz.FQo.Etz.size();
    }
    for (parambtz = this.yMd.PB(paramInt).yax + 1 + " / " + i;; parambtz = null)
    {
      this.yze.jI(String.valueOf(localObject), parambtz);
      this.yze.eJ(paramString, paramInt);
      if (this.yMd != null) {
        this.yMd.Px(paramInt);
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
      parambtz.yMz = 2;
      parambtz.yMB = System.currentTimeMillis();
      parambtz.xXj = (parambtz.yMB - parambtz.yMA);
      ac.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load failed, costTime:%d", new Object[] { Long.valueOf(parambtz.xXj) });
      break label651;
    }
  }
  
  private void dPI()
  {
    AppMethodBeat.i(98767);
    if ((this.yMd == null) || (this.yMd.PB(this.sRJ.getCurrentItem()) == null))
    {
      AppMethodBeat.o(98767);
      return;
    }
    int i = this.sRJ.getCurrentItem();
    if ((this.yMi) && (this.yMd.getCount() > 1))
    {
      this.yMo.setVisibility(0);
      this.yMo.setPage(i);
    }
    btz localbtz = this.yMd.PB(this.sRJ.getCurrentItem()).dwE;
    this.yMv.add(localbtz.Id);
    String str1 = this.yMd.PB(this.sRJ.getCurrentItem()).yav;
    String str2 = localbtz.Id;
    if ((bs.isNullOrNil(this.yMq)) || (!this.yMq.equals(str2))) {
      this.yMq = "";
    }
    b(localbtz, i, str1);
    AppMethodBeat.o(98767);
  }
  
  private int getReportNetworkType()
  {
    AppMethodBeat.i(98777);
    Context localContext = ai.getContext();
    if (ax.is2G(localContext))
    {
      AppMethodBeat.o(98777);
      return 1;
    }
    if (ax.is3G(localContext))
    {
      AppMethodBeat.o(98777);
      return 2;
    }
    if (ax.is4G(localContext))
    {
      AppMethodBeat.o(98777);
      return 3;
    }
    if (ax.isWifi(localContext))
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
    this.yMs = System.currentTimeMillis();
    this.context = paramContext;
    this.sRJ = ((MMViewPager)inflate(paramContext, 2131495553, this).findViewById(2131300335));
    this.sRJ.setVerticalFadingEdgeEnabled(false);
    this.sRJ.setHorizontalFadingEdgeEnabled(false);
    this.sRJ.setOffscreenPageLimit(1);
    this.sRJ.setSingleClickOverListener(new MMViewPager.e()
    {
      public final void aOd()
      {
        AppMethodBeat.i(98733);
        SnsInfoFlip.b(SnsInfoFlip.this);
        AppMethodBeat.o(98733);
      }
      
      public final void cNW()
      {
        AppMethodBeat.i(98734);
        SnsInfoFlip.b(SnsInfoFlip.this);
        AppMethodBeat.o(98734);
      }
    });
    this.yMo = ((MMPageControlView)findViewById(2131306987));
    this.yMo.setIndicatorLayoutRes(2131495626);
    paramContext = (LinearLayout.LayoutParams)this.yMo.getLayoutParams();
    paramContext.bottomMargin += ap.ej(getContext());
    this.yMo.setLayoutParams(paramContext);
    com.tencent.mm.plugin.sns.data.q.xNR = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pZR, 3200);
    AppMethodBeat.o(98760);
  }
  
  public final void a(List<com.tencent.mm.plugin.sns.i.b> paramList, String paramString, int paramInt, w paramw, u.a parama)
  {
    AppMethodBeat.i(98765);
    af.dHM().a(this);
    this.hqR = paramList;
    aj.aeD(paramString);
    this.yzd = paramw;
    this.yze = parama;
    this.yMd = new c(this.context);
    this.sRJ.setAdapter(this.yMd);
    if ((paramInt >= 0) && (paramInt < this.hqR.size()))
    {
      this.sRJ.setCurrentItem(paramInt);
      if (this.yMm)
      {
        this.yMm = false;
        paramList = this.yMd.PB(paramInt).dwE;
        if ((paramList == null) || (paramList.Fjk == null) || (paramList.Fjk.FjZ <= 0.0F)) {
          break label326;
        }
      }
    }
    label326:
    for (this.yMn = (paramList.Fjk.FjY / paramList.Fjk.FjZ);; this.yMn = 1.0F)
    {
      this.sRJ.setFadingEdgeLength(0);
      this.sRJ.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(98736);
          if (SnsInfoFlip.c(SnsInfoFlip.this) != null)
          {
            if ((SnsInfoFlip.d(SnsInfoFlip.this)) && (SnsInfoFlip.c(SnsInfoFlip.this).getCount() > 1))
            {
              SnsInfoFlip.e(SnsInfoFlip.this).setVisibility(0);
              SnsInfoFlip.e(SnsInfoFlip.this).setPage(paramAnonymousInt);
            }
            Object localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).PB(paramAnonymousInt).dwE;
            Object localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).PB(paramAnonymousInt).yav;
            SnsInfoFlip.a(SnsInfoFlip.this, (btz)localObject1, paramAnonymousInt, (String)localObject2);
            localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).Gb(paramAnonymousInt);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).Gc(paramAnonymousInt);
            }
            if (localObject1 != null) {
              ((com.tencent.mm.ui.base.g)localObject1).fij();
            }
            if ((SnsInfoFlip.f(SnsInfoFlip.this) instanceof SnsBrowseUI)) {
              ((SnsBrowseUI)SnsInfoFlip.f(SnsInfoFlip.this)).dPq();
            }
            SnsInfoFlip.c(SnsInfoFlip.this).Py(paramAnonymousInt);
          }
          AppMethodBeat.o(98736);
        }
      });
      if (this.yMe) {
        this.sRJ.setLongClickOverListener(new MMViewPager.c()
        {
          public final void aOe()
          {
            AppMethodBeat.i(98737);
            if (!SnsInfoFlip.g(SnsInfoFlip.this))
            {
              AppMethodBeat.o(98737);
              return;
            }
            Object localObject1 = y.ayq().F("basescanui@datacenter", true);
            ((y.b)localObject1).l("key_basescanui_screen_x", Integer.valueOf(SnsInfoFlip.h(SnsInfoFlip.this).getXDown()));
            ((y.b)localObject1).l("key_basescanui_screen_y", Integer.valueOf(SnsInfoFlip.h(SnsInfoFlip.this).getYDown()));
            if (SnsInfoFlip.c(SnsInfoFlip.this) == null)
            {
              ac.e("MicroMsg.SnsInfoFlip", "longClickOver, adapter is null.");
              AppMethodBeat.o(98737);
              return;
            }
            localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).PB(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem());
            if ((localObject1 == null) || (bs.isNullOrNil(((com.tencent.mm.plugin.sns.i.b)localObject1).yav)))
            {
              AppMethodBeat.o(98737);
              return;
            }
            Object localObject2 = new bo();
            ((bo)localObject2).dCQ = 1L;
            if (SnsInfoFlip.i(SnsInfoFlip.this)) {}
            for (((bo)localObject2).dNc = 6L;; ((bo)localObject2).dNc = 7L)
            {
              ((bo)localObject2).aHZ();
              localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).PB(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem()).dwE.Id;
              String str = an.jc(af.getAccSnsPath(), (String)localObject2) + com.tencent.mm.plugin.sns.data.q.k(SnsInfoFlip.c(SnsInfoFlip.this).PB(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem()).dwE);
              SnsInfoFlip.this.e(str, ((com.tencent.mm.plugin.sns.i.b)localObject1).yav, (String)localObject2, true);
              AppMethodBeat.o(98737);
              return;
            }
          }
        });
      }
      if ((this.yMi) && (this.yMd.getCount() > 1))
      {
        this.yMo.setVisibility(0);
        this.yMo.jy(this.yMd.getCount(), paramInt);
      }
      if ((this.yIM) && (!bs.isNullOrNil(this.yMd.PB(paramInt).yav)))
      {
        paramList = this.yMd.PB(paramInt).dwE.Id;
        avu(an.jc(af.getAccSnsPath(), paramList) + com.tencent.mm.plugin.sns.data.q.k(this.yMd.PB(paramInt).dwE));
      }
      AppMethodBeat.o(98765);
      return;
    }
  }
  
  public final void bF(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(98775);
    if (this.yMd == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.SnsInfoFlip", "onImageFinish, mediaId: %s, isOK: %s, null == adapter: %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (this.yMd != null) {
        break;
      }
      AppMethodBeat.o(98775);
      return;
    }
    Object localObject;
    if ((!paramBoolean) && (this.yMd.PB(this.sRJ.getCurrentItem()) != null))
    {
      localObject = this.yMd.PB(this.sRJ.getCurrentItem()).dwE;
      if ((localObject != null) && (((btz)localObject).Id != null) && (((btz)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131763806), 0).show();
        this.yMq = paramString;
      }
    }
    this.yMw += 1;
    if (this.yIK)
    {
      ac.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.yMx.containsKey(paramString)))
      {
        localObject = (a)this.yMx.get(paramString);
        ((a)localObject).yMB = System.currentTimeMillis();
        ((a)localObject).networkType = getReportNetworkType();
        ac.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
      }
    }
    c localc;
    int j;
    if (this.yMd.PB(this.sRJ.getCurrentItem()) != null)
    {
      localObject = this.yMd.PB(this.sRJ.getCurrentItem()).dwE;
      if ((localObject != null) && (((btz)localObject).Id != null) && (((btz)localObject).Id.equals(paramString)))
      {
        ac.i("MicroMsg.SnsInfoFlip", "img download finish, refresh ui, media id: %s. and mediaLocal id %s", new Object[] { ((btz)localObject).Id, Integer.valueOf(((btz)localObject).dwR) });
        localc = this.yMd;
        j = localc.yMy.hqR.size();
      }
    }
    for (;;)
    {
      if (i < j)
      {
        com.tencent.mm.plugin.sns.i.b localb = localc.PB(i);
        if ((localb != null) && (localb.dwE.Id.equals(paramString))) {
          localc.Py(i);
        }
      }
      else
      {
        if (this.yIM) {
          E((btz)localObject);
        }
        AppMethodBeat.o(98775);
        return;
      }
      i += 1;
    }
  }
  
  public final void bG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98776);
    Object localObject = new StringBuilder("onSightFinish ").append(paramString).append(" ").append(paramBoolean).append(" ");
    if (this.yMd == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.SnsInfoFlip", bool);
      if (this.yMd != null) {
        break;
      }
      AppMethodBeat.o(98776);
      return;
    }
    if ((!paramBoolean) && (this.yMd.PB(this.sRJ.getCurrentItem()) != null))
    {
      localObject = this.yMd.PB(this.sRJ.getCurrentItem()).dwE;
      if ((localObject != null) && (((btz)localObject).Id != null) && (((btz)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131763807), 0).show();
        this.yMq = paramString;
      }
    }
    this.yMd.notifyDataSetChanged();
    AppMethodBeat.o(98776);
  }
  
  public final boolean dNv()
  {
    return this.yIK;
  }
  
  public final int dPJ()
  {
    AppMethodBeat.i(98770);
    if ((this.sRJ == null) || (this.yMd == null))
    {
      AppMethodBeat.o(98770);
      return -1;
    }
    int i = this.sRJ.getCurrentItem();
    if ((i >= 0) && (this.hqR.size() > i))
    {
      this.hqR.remove(i);
      this.yMd.notifyDataSetChanged();
      dPI();
    }
    i = this.yMd.getCount();
    AppMethodBeat.o(98770);
    return i;
  }
  
  public final void dPK()
  {
    AppMethodBeat.i(98778);
    Iterator localIterator = this.yMx.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      com.tencent.mm.plugin.sns.storage.p localp;
      String str;
      BitmapFactory.Options localOptions;
      int k;
      int j;
      int i;
      int m;
      if (locala.yMz != -1)
      {
        localp = af.dHR().auT(locala.dgl);
        str = an.jc(af.getAccSnsPath(), locala.yMD) + com.tencent.mm.plugin.sns.data.q.k(locala.xRy);
        localOptions = com.tencent.mm.sdk.platformtools.f.aKw(str);
        k = 0;
        j = 0;
        i = (int)i.aSp(str);
        if (localOptions != null)
        {
          k = localOptions.outWidth;
          j = localOptions.outHeight;
          i = (int)i.aSp(str);
        }
        m = com.tencent.mm.plugin.sns.data.q.aiF(str);
        if (locala.xRy.mediaType != 0) {
          m = locala.xRy.mediaType;
        }
        h.wUl.f(11601, new Object[] { Integer.valueOf(locala.hlt), Integer.valueOf(locala.yMz), Long.valueOf(locala.xXj), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localp.field_snsId), Long.valueOf(locala.yMA), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
        ac.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.hlt), Integer.valueOf(locala.yMz), Long.valueOf(locala.xXj), Integer.valueOf(locala.networkType), Long.valueOf(localp.field_snsId), Long.valueOf(locala.yMA), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.sns.data.q.aiF(str)), str });
      }
      else if (locala.yMA != -1L)
      {
        if (locala.yMB != -1L) {
          locala.yMz = 1;
        }
        for (;;)
        {
          locala.xXj = (locala.yMB - locala.yMA);
          localp = af.dHR().auT(locala.dgl);
          str = an.jc(af.getAccSnsPath(), locala.yMD) + com.tencent.mm.plugin.sns.data.q.k(locala.xRy);
          localOptions = com.tencent.mm.sdk.platformtools.f.aKw(str);
          k = 0;
          j = 0;
          i = (int)i.aSp(str);
          if (localOptions != null)
          {
            k = localOptions.outWidth;
            j = localOptions.outHeight;
            i = (int)i.aSp(str);
          }
          m = com.tencent.mm.plugin.sns.data.q.aiF(str);
          if (locala.xRy.mediaType != 0) {
            m = locala.xRy.mediaType;
          }
          h.wUl.f(11601, new Object[] { Integer.valueOf(locala.hlt), Integer.valueOf(locala.yMz), Long.valueOf(locala.xXj), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localp.field_snsId), Long.valueOf(locala.yMA), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          ac.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.hlt), Integer.valueOf(locala.yMz), Long.valueOf(locala.xXj), Integer.valueOf(locala.networkType), Long.valueOf(localp.field_snsId), Long.valueOf(locala.yMA), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.sns.data.q.aiF(str)), str });
          break;
          locala.yMz = 2;
          locala.yMB = System.currentTimeMillis();
        }
      }
    }
    this.yMx.clear();
    AppMethodBeat.o(98778);
  }
  
  public btz getCntMedia()
  {
    AppMethodBeat.i(98772);
    if (this.yMd != null)
    {
      int i = this.sRJ.getCurrentItem();
      if ((this.hqR != null) && (i < this.hqR.size()))
      {
        btz localbtz = this.yMd.PB(i).dwE;
        AppMethodBeat.o(98772);
        return localbtz;
      }
    }
    AppMethodBeat.o(98772);
    return null;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(98771);
    if (this.yMd != null)
    {
      int i = this.yMd.getCount();
      AppMethodBeat.o(98771);
      return i;
    }
    AppMethodBeat.o(98771);
    return 0;
  }
  
  public List<com.tencent.mm.plugin.sns.i.b> getFlipList()
  {
    return this.hqR;
  }
  
  public bf getFromScene()
  {
    return this.xNB;
  }
  
  public MMViewPager getGallery()
  {
    return this.sRJ;
  }
  
  public int getNumOfFileExist()
  {
    AppMethodBeat.i(98774);
    Iterator localIterator = this.hqR.iterator();
    int k = 0;
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.sns.i.b localb = (com.tencent.mm.plugin.sns.i.b)localIterator.next();
        af.dHO();
        j = i;
        if (i.eA(com.tencent.mm.plugin.sns.model.f.C(localb.dwE))) {
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
    return this.yIE;
  }
  
  public int getSelectCount()
  {
    AppMethodBeat.i(98773);
    int i = this.yMv.size();
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
    localObject = ((com.tencent.mm.plugin.sns.i.b)localObject).yav;
    AppMethodBeat.o(98763);
    return localObject;
  }
  
  public com.tencent.mm.plugin.sns.i.b getSelectItem()
  {
    AppMethodBeat.i(98761);
    if ((this.sRJ != null) && (this.yMd != null))
    {
      int i = this.sRJ.getCurrentItem();
      com.tencent.mm.plugin.sns.i.b localb = this.yMd.PB(i);
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
      localObject = ((btz)localObject).Id;
      AppMethodBeat.o(98762);
      return localObject;
    }
    AppMethodBeat.o(98762);
    return null;
  }
  
  public long getSnsId()
  {
    AppMethodBeat.i(98766);
    if (this.yMd == null)
    {
      AppMethodBeat.o(98766);
      return 0L;
    }
    Object localObject = this.yMd.PB(this.sRJ.getCurrentItem());
    if (localObject == null) {
      localObject = "";
    }
    while (!bs.isNullOrNil((String)localObject))
    {
      localObject = af.dHR().auT((String)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(98766);
        return 0L;
        localObject = ((com.tencent.mm.plugin.sns.i.b)localObject).yav;
      }
      else
      {
        long l = ((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId;
        AppMethodBeat.o(98766);
        return l;
      }
    }
    AppMethodBeat.o(98766);
    return 0L;
  }
  
  public float getWidthModHeight()
  {
    return this.yMn;
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(98779);
    super.onDestroy();
    if (this.yMd != null)
    {
      this.yMd.detach();
      this.yMd = null;
    }
    AppMethodBeat.o(98779);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(98769);
    super.onPause();
    if (this.yMd != null)
    {
      this.yMd.dPL();
      this.yMd.clear();
    }
    AppMethodBeat.o(98769);
  }
  
  public final void rn(boolean paramBoolean)
  {
    AppMethodBeat.i(179207);
    if (this.yMd != null)
    {
      ac.d("MicroMsg.SnsInfoFlip", "onRefresh ");
      if (paramBoolean) {
        this.yMd.notifyDataSetChanged();
      }
      dPI();
    }
    AppMethodBeat.o(179207);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.yMl = paramBoolean;
  }
  
  public void setFromScene(bf parambf)
  {
    this.xNB = parambf;
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
    this.yIK = paramBoolean;
  }
  
  public void setIsSoonEnterPhotoEditUI(boolean paramBoolean)
  {
    this.yIM = paramBoolean;
  }
  
  public void setItems(List<com.tencent.mm.plugin.sns.i.b> paramList)
  {
    this.hqR = paramList;
  }
  
  public void setOnDeleteAllAction(Runnable paramRunnable)
  {
    this.yMp = paramRunnable;
  }
  
  public void setOnPageSelectListener(b paramb)
  {
    this.yMt = paramb;
  }
  
  public void setShowLongClickMenu(boolean paramBoolean)
  {
    this.yMe = paramBoolean;
  }
  
  public void setShowPageControl(boolean paramBoolean)
  {
    this.yMi = paramBoolean;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.yMk = paramBoolean;
  }
  
  public void setTouchFinish(boolean paramBoolean)
  {
    this.yMj = paramBoolean;
  }
  
  public void setVideoScene(int paramInt)
  {
    this.yFi = paramInt;
  }
  
  final class a
  {
    String dgl = "";
    int hlt;
    int networkType;
    btz xRy;
    long xXj = -1L;
    long yMA = -1L;
    long yMB = -1L;
    bub yMC;
    String yMD;
    int yMz = -1;
    
    a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(btz parambtz, int paramInt, String paramString);
  }
  
  final class c
    extends u
  {
    Context context;
    private boolean oJn;
    private int yME;
    private String yMF;
    Map<String, WeakReference<View>> yMG;
    private boolean yMH;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(98742);
      this.yMG = new HashMap();
      this.yMH = false;
      this.context = paramContext;
      this.yME = SnsInfoFlip.j(SnsInfoFlip.this).size();
      com.tencent.mm.modelcontrol.c.aDI();
      this.oJn = com.tencent.mm.modelcontrol.c.aDK();
      AppMethodBeat.o(98742);
    }
    
    private void PA(int paramInt)
    {
      AppMethodBeat.i(98754);
      btz localbtz = PB(paramInt).dwE;
      bf localbf = bf.a(SnsInfoFlip.this.xNB, PB(paramInt).hGU);
      if (localbtz.ndI != 2)
      {
        AppMethodBeat.o(98754);
        return;
      }
      boolean bool = x.avo(PB(paramInt).yav);
      af.dHO();
      bool = com.tencent.mm.plugin.sns.model.f.a(localbtz, localbf, bool);
      if ((SnsInfoFlip.i(SnsInfoFlip.this)) && (!bool)) {
        SnsInfoFlip.a(SnsInfoFlip.this, localbtz.Id, SnsInfoFlip.this.getSelectItem().yav, localbtz.Fjk, localbtz);
      }
      AppMethodBeat.o(98754);
    }
    
    private void Pz(int paramInt)
    {
      AppMethodBeat.i(98753);
      if (!this.oJn)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (SnsInfoFlip.c(SnsInfoFlip.this) == null)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (!ae.cS(this.context))
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (paramInt - 1 >= 0) {
        PA(paramInt - 1);
      }
      if (paramInt + 1 < SnsInfoFlip.c(SnsInfoFlip.this).getCount()) {
        PA(paramInt + 1);
      }
      AppMethodBeat.o(98753);
    }
    
    private void a(final SnsInfoFlip.d paramd, final int paramInt, final btz parambtz, final boolean paramBoolean)
    {
      AppMethodBeat.i(200515);
      final bf localbf = bf.a(SnsInfoFlip.this.xNB, PB(paramInt).hGU);
      com.tencent.mm.plugin.sns.model.f localf = af.dHO();
      MultiTouchImageView localMultiTouchImageView = paramd.yMQ;
      int i = this.context.hashCode();
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        localf.a(parambtz, localMultiTouchImageView, i, bool, localbf, x.avo(PB(paramInt).yav), new f.e()
        {
          public final void aj(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(98741);
            if ((!com.tencent.mm.plugin.sns.data.q.I(paramAnonymousBitmap)) && (SnsInfoFlip.i(SnsInfoFlip.this)) && (SnsInfoFlip.this.getSelectItem() != null)) {
              SnsInfoFlip.a(SnsInfoFlip.this, parambtz.Id, SnsInfoFlip.this.getSelectItem().yav, parambtz.Fjk, parambtz);
            }
            if ((!com.tencent.mm.plugin.sns.data.q.I(paramAnonymousBitmap)) && (parambtz.Id != null) && (!parambtz.Id.startsWith("pre_temp_extend_pic")))
            {
              ac.i("MicroMsg.SnsGalleryAdapter", "big image not ready, set loading img. position: %d, media id: %s.", new Object[] { Integer.valueOf(paramInt), parambtz.Id });
              paramd.stH.setVisibility(0);
              paramd.iIW.setVisibility(0);
              paramd.yMQ.setVisibility(8);
              paramd.sRg.setVisibility(8);
              af.dHO().eB(paramd.stH);
              af.dHO().b(parambtz, paramd.stH, 2131231318, SnsInfoFlip.c.this.context.hashCode(), localbf);
              if (paramBoolean)
              {
                paramd.iIW.setVisibility(8);
                AppMethodBeat.o(98741);
              }
            }
            else if (com.tencent.mm.plugin.sns.data.q.I(paramAnonymousBitmap))
            {
              ac.i("MicroMsg.SnsGalleryAdapter", "pennqin, use multiTouchImageView, %s.", new Object[] { paramd.yMQ });
              paramd.yMQ.setVisibility(0);
              paramd.sRg.setVisibility(8);
              paramd.yMQ.setEnableHorLongBmpMode(SnsInfoFlip.n(SnsInfoFlip.this));
              paramd.yMQ.cF(paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight());
              paramd.yMQ.setImageBitmap(null);
              paramd.yMQ.setImageBitmap(paramAnonymousBitmap);
              paramd.yMQ.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98740);
                  SnsInfoFlip.c.2.this.yMI.stH.setVisibility(8);
                  SnsInfoFlip.c.2.this.yMI.iIW.setVisibility(8);
                  AppMethodBeat.o(98740);
                }
              });
            }
            AppMethodBeat.o(98741);
          }
        });
        AppMethodBeat.o(200515);
        return;
      }
    }
    
    private View j(final int paramInt, View paramView)
    {
      final boolean bool = true;
      AppMethodBeat.i(98750);
      Object localObject2 = PB(paramInt).dwE;
      final SnsInfoFlip.d locald;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        locald = new SnsInfoFlip.d();
        paramView = View.inflate(this.context, 2131495549, null);
        locald.yMP = paramView.findViewById(2131300341);
        locald.stH = ((ImageView)paramView.findViewById(2131301501));
        locald.iIW = ((ProgressBar)paramView.findViewById(2131301506));
        locald.yMQ = ((MultiTouchImageView)paramView.findViewById(2131302559));
        locald.sRg = ((WxImageView)paramView.findViewById(2131307106));
        paramView.setTag(locald);
        ac.d("MicroMsg.SnsGalleryAdapter", "gallery position %d, media id: %s, %s.", new Object[] { Integer.valueOf(paramInt), ((btz)localObject2).Id, locald.yMQ });
        locald.position = paramInt;
        if ((bs.isNullOrNil(SnsInfoFlip.l(SnsInfoFlip.this))) || (!SnsInfoFlip.l(SnsInfoFlip.this).equals(((btz)localObject2).Id))) {
          break label322;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (!((btz)localObject2).Id.startsWith("Locall_path")) {
          break label385;
        }
        localObject1 = localObject2;
        if (bs.isNullOrNil(PB(paramInt).yav)) {
          break label385;
        }
        localObject3 = (com.tencent.mm.plugin.sns.storage.p)SnsInfoFlip.m(SnsInfoFlip.this).get(PB(paramInt).yav);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = af.dHR().auT(PB(paramInt).yav);
          SnsInfoFlip.m(SnsInfoFlip.this).put(PB(paramInt).yav, localObject1);
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
      Object localObject3 = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dLV();
      Object localObject1 = localObject2;
      if (((TimeLineObject)localObject3).FQo.Etz.size() > PB(paramInt).yax) {
        localObject1 = (btz)((TimeLineObject)localObject3).FQo.Etz.get(PB(paramInt).yax);
      }
      label385:
      localObject2 = com.tencent.mm.plugin.sns.model.f.C((btz)localObject1);
      if ((!bs.isNullOrNil((String)localObject2)) && (SnsInfoFlip.avH((String)localObject2)))
      {
        ac.i("MicroMsg.SnsGalleryAdapter", "pennqin, use wxImageView.");
        locald.yMQ.setVisibility(8);
        locald.sRg.setVisibility(0);
        localObject3 = com.tencent.mm.sdk.platformtools.f.aKw((String)localObject2);
        if (localObject3 != null)
        {
          int i = BackwardSupportUtil.ExifHelper.ce((String)localObject2);
          locald.sRg.setOrientation(i);
          locald.sRg.cF(((BitmapFactory.Options)localObject3).outWidth, ((BitmapFactory.Options)localObject3).outHeight);
          locald.sRg.fij();
          locald.sRg.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
          {
            public final void a(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void b(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
            {
              AppMethodBeat.i(200514);
              ac.w("MicroMsg.SnsGalleryAdapter", "onImageLoadError, switch to multiTouchImageView");
              SnsInfoFlip.c.a(SnsInfoFlip.c.this, locald, paramInt, this.yMJ, bool);
              AppMethodBeat.o(200514);
            }
            
            public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void m(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(98739);
              ac.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on image loaded.");
              locald.stH.setVisibility(8);
              locald.iIW.setVisibility(8);
              AppMethodBeat.o(98739);
            }
            
            public final void qA()
            {
              AppMethodBeat.i(98738);
              ac.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on preview loaded.");
              AppMethodBeat.o(98738);
            }
            
            public final void qB() {}
          });
          localObject1 = Uri.encode(i.k(com.tencent.mm.plugin.sns.model.f.q((btz)localObject1), false));
          if (!bs.isNullOrNil((String)localObject1)) {
            locald.sRg.a(i.k((String)localObject2, false), com.davemorrissey.labs.subscaleview.view.a.W((String)localObject1));
          }
        }
      }
      for (;;)
      {
        Pz(paramInt);
        AppMethodBeat.o(98750);
        return paramView;
        a(locald, paramInt, (btz)localObject1, bool);
      }
    }
    
    public final MultiTouchImageView Gb(int paramInt)
    {
      AppMethodBeat.i(98743);
      Object localObject = super.QZ(paramInt);
      if (localObject == null)
      {
        ac.e("MicroMsg.SnsGalleryAdapter", "position : %d getMultiTouchImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98743);
        return null;
      }
      localObject = (SnsInfoFlip.d)((View)localObject).getTag();
      if (localObject == null)
      {
        ac.e("MicroMsg.SnsGalleryAdapter", "position : %d getMultiTouchImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98743);
        return null;
      }
      if (((SnsInfoFlip.d)localObject).yMQ.getVisibility() == 8)
      {
        AppMethodBeat.o(98743);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).yMQ;
      AppMethodBeat.o(98743);
      return localObject;
    }
    
    public final WxImageView Gc(int paramInt)
    {
      AppMethodBeat.i(98744);
      Object localObject = super.QZ(paramInt);
      if (localObject == null)
      {
        ac.e("MicroMsg.SnsGalleryAdapter", "position : %d getWxImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98744);
        return null;
      }
      localObject = (SnsInfoFlip.d)((View)localObject).getTag();
      if (localObject == null)
      {
        ac.e("MicroMsg.SnsGalleryAdapter", "position : %d getWxImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98744);
        return null;
      }
      if (((SnsInfoFlip.d)localObject).sRg.getVisibility() == 8)
      {
        AppMethodBeat.o(98744);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).sRg;
      AppMethodBeat.o(98744);
      return localObject;
    }
    
    public final com.tencent.mm.plugin.sns.i.b PB(int paramInt)
    {
      AppMethodBeat.i(98756);
      if ((paramInt < SnsInfoFlip.j(SnsInfoFlip.this).size()) && (paramInt >= 0))
      {
        com.tencent.mm.plugin.sns.i.b localb = (com.tencent.mm.plugin.sns.i.b)SnsInfoFlip.j(SnsInfoFlip.this).get(paramInt);
        AppMethodBeat.o(98756);
        return localb;
      }
      AppMethodBeat.o(98756);
      return null;
    }
    
    final void Px(int paramInt)
    {
      AppMethodBeat.i(98746);
      Object localObject1 = PB(paramInt);
      if (localObject1 == null)
      {
        ac.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but flip item is null.");
        AppMethodBeat.o(98746);
        return;
      }
      String str = ((com.tencent.mm.plugin.sns.i.b)localObject1).yav;
      if (bs.isNullOrNil(str))
      {
        ac.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but sns local id is null.");
        AppMethodBeat.o(98746);
        return;
      }
      ac.i("MicroMsg.SnsGalleryAdapter", "notify online sight play pos %s sns local id %s.", new Object[] { Integer.valueOf(paramInt), str });
      Object localObject2 = (WeakReference)this.yMG.get(str);
      if (localObject2 == null)
      {
        ac.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but view cache is null.");
        this.yMF = str;
        AppMethodBeat.o(98746);
        return;
      }
      localObject2 = (OnlineVideoView)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        ac.w("MicroMsg.SnsGalleryAdapter", "online sight view is null, do nothing. snsLocalId %s.", new Object[] { str });
        this.yMF = str;
        AppMethodBeat.o(98746);
        return;
      }
      ac.i("MicroMsg.SnsGalleryAdapter", "%d notify online sight play video %s.", new Object[] { Integer.valueOf(localObject2.hashCode()), str });
      this.yMF = null;
      ((OnlineVideoView)localObject2).dNW();
      ((OnlineVideoView)localObject2).a(((com.tencent.mm.plugin.sns.i.b)localObject1).dwE, ((com.tencent.mm.plugin.sns.i.b)localObject1).yav, ((com.tencent.mm.plugin.sns.i.b)localObject1).hGU);
      localObject1 = new tr();
      ((tr)localObject1).dww.dgL = 1;
      ((tr)localObject1).dww.dgl = str;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(98746);
    }
    
    final boolean Py(int paramInt)
    {
      AppMethodBeat.i(98752);
      View localView = QZ(paramInt);
      if ((localView != null) && (Gb(paramInt) == null) && (Gc(paramInt) == null))
      {
        j(paramInt, localView);
        AppMethodBeat.o(98752);
        return true;
      }
      AppMethodBeat.o(98752);
      return false;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(98747);
      ac.i("MicroMsg.SnsGalleryAdapter", "adapter clear.");
      this.yMG.clear();
      AppMethodBeat.o(98747);
    }
    
    public final void dPL()
    {
      AppMethodBeat.i(98749);
      ac.i("MicroMsg.SnsGalleryAdapter", "notify online sight stop %s", new Object[] { bs.eWi() });
      tr localtr = new tr();
      localtr.dww.context = this.context;
      localtr.dww.dgl = this.yMF;
      localtr.dww.dgL = 2;
      com.tencent.mm.sdk.b.a.GpY.l(localtr);
      this.yMF = null;
      AppMethodBeat.o(98749);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(98751);
      paramViewGroup.removeView((View)paramObject);
      super.destroyItem(paramViewGroup, paramInt, paramObject);
      AppMethodBeat.o(98751);
    }
    
    public final Object g(int paramInt, View paramView)
    {
      AppMethodBeat.i(98745);
      if (PB(paramInt).dwE.ndI == 6)
      {
        boolean bool;
        com.tencent.mm.plugin.sns.i.b localb;
        if (paramView == null)
        {
          bool = true;
          ac.d("MicroMsg.SnsGalleryAdapter", "fill view online sight %d convert view is null %b.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
          localb = PB(paramInt);
          if (localb != null) {
            break label87;
          }
          ac.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but flip item is null.");
        }
        label87:
        Object localObject;
        for (;;)
        {
          AppMethodBeat.o(98745);
          return paramView;
          bool = false;
          break;
          localObject = localb.yav;
          if (!bs.isNullOrNil((String)localObject)) {
            break label113;
          }
          ac.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but sns local id is null.");
        }
        label113:
        paramView = (WeakReference)this.yMG.get(localObject);
        if ((paramView != null) && (paramView.get() != null)) {
          paramView = (OnlineVideoView)paramView.get();
        }
        for (;;)
        {
          paramView.aH(null);
          if (bs.lr((String)localObject, this.yMF)) {
            Px(paramInt);
          }
          ac.i("MicroMsg.SnsGalleryAdapter", "return online sight view %d parent id %s.", new Object[] { Integer.valueOf(paramView.hashCode()), localb.yav });
          localObject = af.dHR().auT((String)localObject);
          if (localObject != null)
          {
            paramView.setScene(SnsInfoFlip.k(SnsInfoFlip.this));
            StringBuilder localStringBuilder = new StringBuilder();
            com.tencent.mm.kernel.g.agP();
            paramView.setSessionId(new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + bs.eWj());
            paramView.setSessionTimestamp(bs.eWj());
            paramView.setSnsId(com.tencent.mm.plugin.sns.data.q.wW(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId));
            paramView.setFilePath(au.D(localb.dwE));
          }
          break;
          paramView = new OnlineVideoView(this.context);
          this.yMG.put(localObject, new WeakReference(paramView));
        }
      }
      paramView = j(paramInt, paramView);
      AppMethodBeat.o(98745);
      return paramView;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(98748);
      if (SnsInfoFlip.j(SnsInfoFlip.this) == null)
      {
        AppMethodBeat.o(98748);
        return 0;
      }
      int i = SnsInfoFlip.j(SnsInfoFlip.this).size();
      AppMethodBeat.o(98748);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(98757);
      if (this.yMH)
      {
        AppMethodBeat.o(98757);
        return -2;
      }
      int i = super.getItemPosition(paramObject);
      AppMethodBeat.o(98757);
      return i;
    }
    
    public final void notifyDataSetChanged()
    {
      AppMethodBeat.i(98755);
      this.yMH = true;
      super.notifyDataSetChanged();
      this.yMH = false;
      this.yME = SnsInfoFlip.j(SnsInfoFlip.this).size();
      ac.d("MicroMsg.SnsGalleryAdapter", "items.size: %d.", new Object[] { Integer.valueOf(this.yME) });
      if ((this.yME <= 0) && (SnsInfoFlip.o(SnsInfoFlip.this) != null)) {
        SnsInfoFlip.o(SnsInfoFlip.this).run();
      }
      AppMethodBeat.o(98755);
    }
  }
  
  static final class d
  {
    ProgressBar iIW;
    int position;
    WxImageView sRg;
    ImageView stH;
    String videoPath = "";
    View yMP;
    MultiTouchImageView yMQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip
 * JD-Core Version:    0.7.0.1
 */