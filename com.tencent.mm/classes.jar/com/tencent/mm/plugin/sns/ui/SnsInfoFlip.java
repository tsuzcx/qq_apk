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
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.b.a.ao;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.f.e;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
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
  List<com.tencent.mm.plugin.sns.j.b> gQr;
  private com.tencent.mm.sdk.platformtools.ap handler;
  boolean isAd;
  MMViewPager rJU;
  public String username;
  private int xss;
  int xvO;
  private boolean xvU;
  private boolean xvW;
  MMPageControlView xzA;
  private Runnable xzB;
  private String xzC;
  private int xzD;
  long xzE;
  private b xzF;
  private HashMap<String, com.tencent.mm.plugin.sns.storage.p> xzG;
  private HashSet<String> xzH;
  public int xzI;
  private HashMap<String, a> xzJ;
  c xzp;
  private boolean xzq;
  HashMap<Integer, Integer> xzr;
  HashMap<Integer, Long> xzs;
  HashMap<Integer, Long> xzt;
  private boolean xzu;
  private boolean xzv;
  private boolean xzw;
  private boolean xzx;
  private boolean xzy;
  private float xzz;
  
  public SnsInfoFlip(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98759);
    this.isAd = false;
    this.xzq = true;
    this.xzr = new HashMap();
    this.xzs = new HashMap();
    this.xzt = new HashMap();
    this.xzu = false;
    this.xzv = false;
    this.xzw = false;
    this.xzx = false;
    this.xzy = true;
    this.xzz = 1.0F;
    this.xzB = null;
    this.handler = new com.tencent.mm.sdk.platformtools.ap();
    this.xzC = "";
    this.xzD = -1;
    this.xvO = -1;
    this.xvU = false;
    this.xvW = false;
    this.xzE = 0L;
    this.xss = 0;
    this.xzG = new HashMap();
    this.xzH = new HashSet();
    this.xzI = 0;
    this.xzJ = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98759);
  }
  
  public SnsInfoFlip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98758);
    this.isAd = false;
    this.xzq = true;
    this.xzr = new HashMap();
    this.xzs = new HashMap();
    this.xzt = new HashMap();
    this.xzu = false;
    this.xzv = false;
    this.xzw = false;
    this.xzx = false;
    this.xzy = true;
    this.xzz = 1.0F;
    this.xzB = null;
    this.handler = new com.tencent.mm.sdk.platformtools.ap();
    this.xzC = "";
    this.xzD = -1;
    this.xvO = -1;
    this.xvU = false;
    this.xvW = false;
    this.xzE = 0L;
    this.xss = 0;
    this.xzG = new HashMap();
    this.xzH = new HashSet();
    this.xzI = 0;
    this.xzJ = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98758);
  }
  
  private void b(bpi parambpi, int paramInt, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(98764);
    if (this.xzF != null) {
      this.xzF.a(parambpi, paramInt, paramString);
    }
    Object localObject = af.dtu().apK(paramString);
    if (localObject != null) {
      com.tencent.mm.plugin.sns.ui.a.c.g((com.tencent.mm.plugin.sns.storage.p)localObject, paramInt);
    }
    if (this.xzD == -1) {
      this.xzD = paramInt;
    }
    if ((bt.isNullOrNil(paramString)) && (this.xzp != null))
    {
      i = this.xzp.getCount();
      parambpi = paramInt + 1 + " / " + i;
      this.xmm.jk(parambpi, null);
      AppMethodBeat.o(98764);
      return;
    }
    com.tencent.mm.plugin.sns.storage.p localp = (com.tencent.mm.plugin.sns.storage.p)this.xzG.get(paramString);
    localObject = localp;
    if (localp == null)
    {
      localObject = af.dtu().apK(paramString);
      this.xzG.put(paramString, localObject);
    }
    if (localObject == null)
    {
      AppMethodBeat.o(98764);
      return;
    }
    if (parambpi.mBH != 6) {
      af.czA().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98735);
          if (SnsInfoFlip.c(SnsInfoFlip.this) != null) {
            SnsInfoFlip.c(SnsInfoFlip.this).dBo();
          }
          AppMethodBeat.o(98735);
        }
      });
    }
    ad.d("MicroMsg.SnsInfoFlip", "onItemSelected " + paramInt + " localId " + paramString);
    long l1;
    if (this.xvO != paramInt)
    {
      if (!this.xzr.containsKey(Integer.valueOf(paramInt))) {
        break label832;
      }
      i = ((Integer)this.xzr.get(Integer.valueOf(paramInt))).intValue();
      this.xzr.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
      this.xzs.put(Integer.valueOf(paramInt), Long.valueOf(bt.GC()));
      if (this.xvO >= 0)
      {
        if (!this.xzs.containsKey(Integer.valueOf(this.xvO))) {
          break label838;
        }
        l1 = ((Long)this.xzs.get(Integer.valueOf(this.xvO))).longValue();
        label364:
        if (l1 > 0L)
        {
          this.xzs.put(Integer.valueOf(this.xvO), Long.valueOf(0L));
          if (this.xzt.containsKey(Integer.valueOf(this.xvO))) {
            l2 = ((Long)this.xzt.get(Integer.valueOf(this.xvO))).longValue();
          }
          l1 = bt.aS(l1);
          l2 += l1;
          this.xzt.put(Integer.valueOf(this.xvO), Long.valueOf(l2));
          ad.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + this.xvO + " curtime " + l2 + " passtime " + l1 / 1000.0D);
        }
      }
      if ((this.xvU) && (this.xzp != null))
      {
        parambpi = this.xzp.Nx(this.xvO);
        if (parambpi != null)
        {
          parambpi = parambpi.dyS.Id;
          ad.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, bigPicId:%s", new Object[] { parambpi });
          if (this.xzJ.containsKey(parambpi))
          {
            parambpi = (a)this.xzJ.get(parambpi);
            parambpi.networkType = getReportNetworkType();
            if (parambpi.xzN == -1L) {
              break label844;
            }
            parambpi.xzL = 1;
            parambpi.wKD = (parambpi.xzN - parambpi.xzM);
            ad.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load success, costTime:%d", new Object[] { Long.valueOf(parambpi.wKD) });
          }
        }
      }
    }
    label651:
    this.xvO = paramInt;
    if (this.xml != null) {
      this.xml.aqo(paramString);
    }
    int i = ((com.tencent.mm.plugin.sns.storage.p)localObject).field_createTime;
    parambpi = ((com.tencent.mm.plugin.sns.storage.p)localObject).dxy();
    localObject = bg.p(this.context, i * 1000L);
    if ((parambpi != null) && (parambpi.Etm != null) && (parambpi.Etm.DaC.size() > 1) && (this.xzp != null)) {
      i = parambpi.Etm.DaC.size();
    }
    for (parambpi = this.xzp.Nx(paramInt).wNQ + 1 + " / " + i;; parambpi = null)
    {
      this.xmm.jk(String.valueOf(localObject), parambpi);
      this.xmm.eB(paramString, paramInt);
      if (this.xzp != null) {
        this.xzp.Nt(paramInt);
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
      parambpi.xzL = 2;
      parambpi.xzN = System.currentTimeMillis();
      parambpi.wKD = (parambpi.xzN - parambpi.xzM);
      ad.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load failed, costTime:%d", new Object[] { Long.valueOf(parambpi.wKD) });
      break label651;
    }
  }
  
  private void dBl()
  {
    AppMethodBeat.i(98767);
    if ((this.xzp == null) || (this.xzp.Nx(this.rJU.getCurrentItem()) == null))
    {
      AppMethodBeat.o(98767);
      return;
    }
    int i = this.rJU.getCurrentItem();
    if ((this.xzu) && (this.xzp.getCount() > 1))
    {
      this.xzA.setVisibility(0);
      this.xzA.setPage(i);
    }
    bpi localbpi = this.xzp.Nx(this.rJU.getCurrentItem()).dyS;
    this.xzH.add(localbpi.Id);
    String str1 = this.xzp.Nx(this.rJU.getCurrentItem()).wNP;
    String str2 = localbpi.Id;
    if ((bt.isNullOrNil(this.xzC)) || (!this.xzC.equals(str2))) {
      this.xzC = "";
    }
    b(localbpi, i, str1);
    AppMethodBeat.o(98767);
  }
  
  private int getReportNetworkType()
  {
    AppMethodBeat.i(98777);
    Context localContext = com.tencent.mm.sdk.platformtools.aj.getContext();
    if (ay.is2G(localContext))
    {
      AppMethodBeat.o(98777);
      return 1;
    }
    if (ay.is3G(localContext))
    {
      AppMethodBeat.o(98777);
      return 2;
    }
    if (ay.is4G(localContext))
    {
      AppMethodBeat.o(98777);
      return 3;
    }
    if (ay.isWifi(localContext))
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
    this.xzE = System.currentTimeMillis();
    this.context = paramContext;
    this.rJU = ((MMViewPager)inflate(paramContext, 2131495553, this).findViewById(2131300335));
    this.rJU.setVerticalFadingEdgeEnabled(false);
    this.rJU.setHorizontalFadingEdgeEnabled(false);
    this.rJU.setOffscreenPageLimit(1);
    this.rJU.setSingleClickOverListener(new MMViewPager.e()
    {
      public final void aHo()
      {
        AppMethodBeat.i(98733);
        SnsInfoFlip.b(SnsInfoFlip.this);
        AppMethodBeat.o(98733);
      }
      
      public final void cAM()
      {
        AppMethodBeat.i(98734);
        SnsInfoFlip.b(SnsInfoFlip.this);
        AppMethodBeat.o(98734);
      }
    });
    this.xzA = ((MMPageControlView)findViewById(2131306987));
    this.xzA.setIndicatorLayoutRes(2131495626);
    paramContext = (LinearLayout.LayoutParams)this.xzA.getLayoutParams();
    paramContext.bottomMargin += com.tencent.mm.ui.ap.eb(getContext());
    this.xzA.setLayoutParams(paramContext);
    com.tencent.mm.plugin.sns.data.q.wBw = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvD, 3200);
    AppMethodBeat.o(98760);
  }
  
  public final void a(List<com.tencent.mm.plugin.sns.j.b> paramList, String paramString, int paramInt, w paramw, u.a parama)
  {
    AppMethodBeat.i(98765);
    af.dtp().a(this);
    this.gQr = paramList;
    com.tencent.mm.plugin.sns.model.aj.ZR(paramString);
    this.xml = paramw;
    this.xmm = parama;
    this.xzp = new c(this.context);
    this.rJU.setAdapter(this.xzp);
    if ((paramInt >= 0) && (paramInt < this.gQr.size()))
    {
      this.rJU.setCurrentItem(paramInt);
      if (this.xzy)
      {
        this.xzy = false;
        paramList = this.xzp.Nx(paramInt).dyS;
        if ((paramList == null) || (paramList.DMT == null) || (paramList.DMT.DNI <= 0.0F)) {
          break label326;
        }
      }
    }
    label326:
    for (this.xzz = (paramList.DMT.DNH / paramList.DMT.DNI);; this.xzz = 1.0F)
    {
      this.rJU.setFadingEdgeLength(0);
      this.rJU.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
            Object localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).Nx(paramAnonymousInt).dyS;
            Object localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).Nx(paramAnonymousInt).wNP;
            SnsInfoFlip.a(SnsInfoFlip.this, (bpi)localObject1, paramAnonymousInt, (String)localObject2);
            localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).Ef(paramAnonymousInt);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).Eg(paramAnonymousInt);
            }
            if (localObject1 != null) {
              ((com.tencent.mm.ui.base.g)localObject1).eSz();
            }
            if ((SnsInfoFlip.f(SnsInfoFlip.this) instanceof SnsBrowseUI)) {
              ((SnsBrowseUI)SnsInfoFlip.f(SnsInfoFlip.this)).dAT();
            }
            SnsInfoFlip.c(SnsInfoFlip.this).Nu(paramAnonymousInt);
          }
          AppMethodBeat.o(98736);
        }
      });
      if (this.xzq) {
        this.rJU.setLongClickOverListener(new MMViewPager.c()
        {
          public final void aHp()
          {
            AppMethodBeat.i(98737);
            if (!SnsInfoFlip.g(SnsInfoFlip.this))
            {
              AppMethodBeat.o(98737);
              return;
            }
            Object localObject1 = y.arz().E("basescanui@datacenter", true);
            ((y.b)localObject1).m("key_basescanui_screen_x", Integer.valueOf(SnsInfoFlip.h(SnsInfoFlip.this).getXDown()));
            ((y.b)localObject1).m("key_basescanui_screen_y", Integer.valueOf(SnsInfoFlip.h(SnsInfoFlip.this).getYDown()));
            if (SnsInfoFlip.c(SnsInfoFlip.this) == null)
            {
              ad.e("MicroMsg.SnsInfoFlip", "longClickOver, adapter is null.");
              AppMethodBeat.o(98737);
              return;
            }
            localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).Nx(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem());
            if ((localObject1 == null) || (bt.isNullOrNil(((com.tencent.mm.plugin.sns.j.b)localObject1).wNP)))
            {
              AppMethodBeat.o(98737);
              return;
            }
            Object localObject2 = new ao();
            ((ao)localObject2).dFd = 1L;
            if (SnsInfoFlip.i(SnsInfoFlip.this)) {}
            for (((ao)localObject2).dMB = 6L;; ((ao)localObject2).dMB = 7L)
            {
              ((ao)localObject2).aBj();
              localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).Nx(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem()).dyS.Id;
              String str = an.iF(af.getAccSnsPath(), (String)localObject2) + com.tencent.mm.plugin.sns.data.q.k(SnsInfoFlip.c(SnsInfoFlip.this).Nx(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem()).dyS);
              SnsInfoFlip.this.e(str, ((com.tencent.mm.plugin.sns.j.b)localObject1).wNP, (String)localObject2, true);
              AppMethodBeat.o(98737);
              return;
            }
          }
        });
      }
      if ((this.xzu) && (this.xzp.getCount() > 1))
      {
        this.xzA.setVisibility(0);
        this.xzA.jl(this.xzp.getCount(), paramInt);
      }
      if ((this.xvW) && (!bt.isNullOrNil(this.xzp.Nx(paramInt).wNP)))
      {
        paramList = this.xzp.Nx(paramInt).dyS.Id;
        aql(an.iF(af.getAccSnsPath(), paramList) + com.tencent.mm.plugin.sns.data.q.k(this.xzp.Nx(paramInt).dyS));
      }
      AppMethodBeat.o(98765);
      return;
    }
  }
  
  public final void by(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(98775);
    if (this.xzp == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.SnsInfoFlip", "onImageFinish, mediaId: %s, isOK: %s, null == adapter: %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (this.xzp != null) {
        break;
      }
      AppMethodBeat.o(98775);
      return;
    }
    Object localObject;
    if ((!paramBoolean) && (this.xzp.Nx(this.rJU.getCurrentItem()) != null))
    {
      localObject = this.xzp.Nx(this.rJU.getCurrentItem()).dyS;
      if ((localObject != null) && (((bpi)localObject).Id != null) && (((bpi)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131763806), 0).show();
        this.xzC = paramString;
      }
    }
    this.xzI += 1;
    if (this.xvU)
    {
      ad.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.xzJ.containsKey(paramString)))
      {
        localObject = (a)this.xzJ.get(paramString);
        ((a)localObject).xzN = System.currentTimeMillis();
        ((a)localObject).networkType = getReportNetworkType();
        ad.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
      }
    }
    c localc;
    int j;
    if (this.xzp.Nx(this.rJU.getCurrentItem()) != null)
    {
      localObject = this.xzp.Nx(this.rJU.getCurrentItem()).dyS;
      if ((localObject != null) && (((bpi)localObject).Id != null) && (((bpi)localObject).Id.equals(paramString)))
      {
        ad.i("MicroMsg.SnsInfoFlip", "img download finish, refresh ui, media id: %s. and mediaLocal id %s", new Object[] { ((bpi)localObject).Id, Integer.valueOf(((bpi)localObject).dzf) });
        localc = this.xzp;
        j = localc.xzK.gQr.size();
      }
    }
    for (;;)
    {
      if (i < j)
      {
        com.tencent.mm.plugin.sns.j.b localb = localc.Nx(i);
        if ((localb != null) && (localb.dyS.Id.equals(paramString))) {
          localc.Nu(i);
        }
      }
      else
      {
        if (this.xvW) {
          E((bpi)localObject);
        }
        AppMethodBeat.o(98775);
        return;
      }
      i += 1;
    }
  }
  
  public final void bz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98776);
    Object localObject = new StringBuilder("onSightFinish ").append(paramString).append(" ").append(paramBoolean).append(" ");
    if (this.xzp == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.SnsInfoFlip", bool);
      if (this.xzp != null) {
        break;
      }
      AppMethodBeat.o(98776);
      return;
    }
    if ((!paramBoolean) && (this.xzp.Nx(this.rJU.getCurrentItem()) != null))
    {
      localObject = this.xzp.Nx(this.rJU.getCurrentItem()).dyS;
      if ((localObject != null) && (((bpi)localObject).Id != null) && (((bpi)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131763807), 0).show();
        this.xzC = paramString;
      }
    }
    this.xzp.notifyDataSetChanged();
    AppMethodBeat.o(98776);
  }
  
  public final int dBm()
  {
    AppMethodBeat.i(98770);
    if ((this.rJU == null) || (this.xzp == null))
    {
      AppMethodBeat.o(98770);
      return -1;
    }
    int i = this.rJU.getCurrentItem();
    if ((i >= 0) && (this.gQr.size() > i))
    {
      this.gQr.remove(i);
      this.xzp.notifyDataSetChanged();
      dBl();
    }
    i = this.xzp.getCount();
    AppMethodBeat.o(98770);
    return i;
  }
  
  public final void dBn()
  {
    AppMethodBeat.i(98778);
    Iterator localIterator = this.xzJ.values().iterator();
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
      if (locala.xzL != -1)
      {
        localp = af.dtu().apK(locala.diQ);
        str = an.iF(af.getAccSnsPath(), locala.xzP) + com.tencent.mm.plugin.sns.data.q.k(locala.wFd);
        localOptions = com.tencent.mm.sdk.platformtools.f.aFf(str);
        k = 0;
        j = 0;
        i = (int)i.aMN(str);
        if (localOptions != null)
        {
          k = localOptions.outWidth;
          j = localOptions.outHeight;
          i = (int)i.aMN(str);
        }
        m = com.tencent.mm.plugin.sns.data.q.adN(str);
        if (locala.wFd.mediaType != 0) {
          m = locala.wFd.mediaType;
        }
        h.vKh.f(11601, new Object[] { Integer.valueOf(locala.gKT), Integer.valueOf(locala.xzL), Long.valueOf(locala.wKD), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localp.field_snsId), Long.valueOf(locala.xzM), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
        ad.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.gKT), Integer.valueOf(locala.xzL), Long.valueOf(locala.wKD), Integer.valueOf(locala.networkType), Long.valueOf(localp.field_snsId), Long.valueOf(locala.xzM), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.sns.data.q.adN(str)), str });
      }
      else if (locala.xzM != -1L)
      {
        if (locala.xzN != -1L) {
          locala.xzL = 1;
        }
        for (;;)
        {
          locala.wKD = (locala.xzN - locala.xzM);
          localp = af.dtu().apK(locala.diQ);
          str = an.iF(af.getAccSnsPath(), locala.xzP) + com.tencent.mm.plugin.sns.data.q.k(locala.wFd);
          localOptions = com.tencent.mm.sdk.platformtools.f.aFf(str);
          k = 0;
          j = 0;
          i = (int)i.aMN(str);
          if (localOptions != null)
          {
            k = localOptions.outWidth;
            j = localOptions.outHeight;
            i = (int)i.aMN(str);
          }
          m = com.tencent.mm.plugin.sns.data.q.adN(str);
          if (locala.wFd.mediaType != 0) {
            m = locala.wFd.mediaType;
          }
          h.vKh.f(11601, new Object[] { Integer.valueOf(locala.gKT), Integer.valueOf(locala.xzL), Long.valueOf(locala.wKD), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localp.field_snsId), Long.valueOf(locala.xzM), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          ad.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.gKT), Integer.valueOf(locala.xzL), Long.valueOf(locala.wKD), Integer.valueOf(locala.networkType), Long.valueOf(localp.field_snsId), Long.valueOf(locala.xzM), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.sns.data.q.adN(str)), str });
          break;
          locala.xzL = 2;
          locala.xzN = System.currentTimeMillis();
        }
      }
    }
    this.xzJ.clear();
    AppMethodBeat.o(98778);
  }
  
  public final boolean dyY()
  {
    return this.xvU;
  }
  
  public bpi getCntMedia()
  {
    AppMethodBeat.i(98772);
    if (this.xzp != null)
    {
      int i = this.rJU.getCurrentItem();
      if ((this.gQr != null) && (i < this.gQr.size()))
      {
        bpi localbpi = this.xzp.Nx(i).dyS;
        AppMethodBeat.o(98772);
        return localbpi;
      }
    }
    AppMethodBeat.o(98772);
    return null;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(98771);
    if (this.xzp != null)
    {
      int i = this.xzp.getCount();
      AppMethodBeat.o(98771);
      return i;
    }
    AppMethodBeat.o(98771);
    return 0;
  }
  
  public List<com.tencent.mm.plugin.sns.j.b> getFlipList()
  {
    return this.gQr;
  }
  
  public bc getFromScene()
  {
    return this.wBg;
  }
  
  public MMViewPager getGallery()
  {
    return this.rJU;
  }
  
  public int getNumOfFileExist()
  {
    AppMethodBeat.i(98774);
    Iterator localIterator = this.gQr.iterator();
    int k = 0;
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.sns.j.b localb = (com.tencent.mm.plugin.sns.j.b)localIterator.next();
        af.dtr();
        j = i;
        if (i.eK(com.tencent.mm.plugin.sns.model.f.C(localb.dyS))) {
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
    return this.xvO;
  }
  
  public int getSelectCount()
  {
    AppMethodBeat.i(98773);
    int i = this.xzH.size();
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
    localObject = ((com.tencent.mm.plugin.sns.j.b)localObject).wNP;
    AppMethodBeat.o(98763);
    return localObject;
  }
  
  public com.tencent.mm.plugin.sns.j.b getSelectItem()
  {
    AppMethodBeat.i(98761);
    if ((this.rJU != null) && (this.xzp != null))
    {
      int i = this.rJU.getCurrentItem();
      com.tencent.mm.plugin.sns.j.b localb = this.xzp.Nx(i);
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
      localObject = ((bpi)localObject).Id;
      AppMethodBeat.o(98762);
      return localObject;
    }
    AppMethodBeat.o(98762);
    return null;
  }
  
  public long getSnsId()
  {
    AppMethodBeat.i(98766);
    if (this.xzp == null)
    {
      AppMethodBeat.o(98766);
      return 0L;
    }
    Object localObject = this.xzp.Nx(this.rJU.getCurrentItem());
    if (localObject == null) {
      localObject = "";
    }
    while (!bt.isNullOrNil((String)localObject))
    {
      localObject = af.dtu().apK((String)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(98766);
        return 0L;
        localObject = ((com.tencent.mm.plugin.sns.j.b)localObject).wNP;
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
    return this.xzz;
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(98779);
    super.onDestroy();
    if (this.xzp != null)
    {
      this.xzp.detach();
      this.xzp = null;
    }
    AppMethodBeat.o(98779);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(98769);
    super.onPause();
    if (this.xzp != null)
    {
      this.xzp.dBo();
      this.xzp.clear();
    }
    AppMethodBeat.o(98769);
  }
  
  public final void qp(boolean paramBoolean)
  {
    AppMethodBeat.i(179207);
    if (this.xzp != null)
    {
      ad.d("MicroMsg.SnsInfoFlip", "onRefresh ");
      if (paramBoolean) {
        this.xzp.notifyDataSetChanged();
      }
      dBl();
    }
    AppMethodBeat.o(179207);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.xzx = paramBoolean;
  }
  
  public void setFromScene(bc parambc)
  {
    this.wBg = parambc;
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
    this.xvU = paramBoolean;
  }
  
  public void setIsSoonEnterPhotoEditUI(boolean paramBoolean)
  {
    this.xvW = paramBoolean;
  }
  
  public void setItems(List<com.tencent.mm.plugin.sns.j.b> paramList)
  {
    this.gQr = paramList;
  }
  
  public void setOnDeleteAllAction(Runnable paramRunnable)
  {
    this.xzB = paramRunnable;
  }
  
  public void setOnPageSelectListener(b paramb)
  {
    this.xzF = paramb;
  }
  
  public void setShowLongClickMenu(boolean paramBoolean)
  {
    this.xzq = paramBoolean;
  }
  
  public void setShowPageControl(boolean paramBoolean)
  {
    this.xzu = paramBoolean;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.xzw = paramBoolean;
  }
  
  public void setTouchFinish(boolean paramBoolean)
  {
    this.xzv = paramBoolean;
  }
  
  public void setVideoScene(int paramInt)
  {
    this.xss = paramInt;
  }
  
  final class a
  {
    String diQ = "";
    int gKT;
    int networkType;
    bpi wFd;
    long wKD = -1L;
    int xzL = -1;
    long xzM = -1L;
    long xzN = -1L;
    bpk xzO;
    String xzP;
    
    a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(bpi parambpi, int paramInt, String paramString);
  }
  
  final class c
    extends u
  {
    Context context;
    private boolean ofM;
    private int xzQ;
    private String xzR;
    Map<String, WeakReference<View>> xzS;
    private boolean xzT;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(98742);
      this.xzS = new HashMap();
      this.xzT = false;
      this.context = paramContext;
      this.xzQ = SnsInfoFlip.j(SnsInfoFlip.this).size();
      com.tencent.mm.modelcontrol.c.awQ();
      this.ofM = com.tencent.mm.modelcontrol.c.awS();
      AppMethodBeat.o(98742);
    }
    
    private void Nv(int paramInt)
    {
      AppMethodBeat.i(98753);
      if (!this.ofM)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (SnsInfoFlip.c(SnsInfoFlip.this) == null)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (!ae.cJ(this.context))
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (paramInt - 1 >= 0) {
        Nw(paramInt - 1);
      }
      if (paramInt + 1 < SnsInfoFlip.c(SnsInfoFlip.this).getCount()) {
        Nw(paramInt + 1);
      }
      AppMethodBeat.o(98753);
    }
    
    private void Nw(int paramInt)
    {
      AppMethodBeat.i(98754);
      bpi localbpi = Nx(paramInt).dyS;
      bc localbc = bc.a(SnsInfoFlip.this.wBg, Nx(paramInt).hgr);
      if (localbpi.mBH != 2)
      {
        AppMethodBeat.o(98754);
        return;
      }
      boolean bool = x.aqf(Nx(paramInt).wNP);
      af.dtr();
      bool = com.tencent.mm.plugin.sns.model.f.a(localbpi, localbc, bool);
      if ((SnsInfoFlip.i(SnsInfoFlip.this)) && (!bool)) {
        SnsInfoFlip.a(SnsInfoFlip.this, localbpi.Id, SnsInfoFlip.this.getSelectItem().wNP, localbpi.DMT, localbpi);
      }
      AppMethodBeat.o(98754);
    }
    
    private void a(final SnsInfoFlip.d paramd, final int paramInt, final bpi parambpi, final boolean paramBoolean)
    {
      AppMethodBeat.i(187700);
      final bc localbc = bc.a(SnsInfoFlip.this.wBg, Nx(paramInt).hgr);
      com.tencent.mm.plugin.sns.model.f localf = af.dtr();
      MultiTouchImageView localMultiTouchImageView = paramd.xAc;
      int i = this.context.hashCode();
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        localf.a(parambpi, localMultiTouchImageView, i, bool, localbc, x.aqf(Nx(paramInt).wNP), new f.e()
        {
          public final void ai(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(98741);
            if ((!com.tencent.mm.plugin.sns.data.q.I(paramAnonymousBitmap)) && (SnsInfoFlip.i(SnsInfoFlip.this)) && (SnsInfoFlip.this.getSelectItem() != null)) {
              SnsInfoFlip.a(SnsInfoFlip.this, parambpi.Id, SnsInfoFlip.this.getSelectItem().wNP, parambpi.DMT, parambpi);
            }
            if ((!com.tencent.mm.plugin.sns.data.q.I(paramAnonymousBitmap)) && (parambpi.Id != null) && (!parambpi.Id.startsWith("pre_temp_extend_pic")))
            {
              ad.i("MicroMsg.SnsGalleryAdapter", "big image not ready, set loading img. position: %d, media id: %s.", new Object[] { Integer.valueOf(paramInt), parambpi.Id });
              paramd.rkO.setVisibility(0);
              paramd.iiP.setVisibility(0);
              paramd.xAc.setVisibility(8);
              paramd.rJr.setVisibility(8);
              af.dtr().eo(paramd.rkO);
              af.dtr().b(parambpi, paramd.rkO, 2131231318, SnsInfoFlip.c.this.context.hashCode(), localbc);
              if (paramBoolean)
              {
                paramd.iiP.setVisibility(8);
                AppMethodBeat.o(98741);
              }
            }
            else if (com.tencent.mm.plugin.sns.data.q.I(paramAnonymousBitmap))
            {
              ad.i("MicroMsg.SnsGalleryAdapter", "pennqin, use multiTouchImageView, %s.", new Object[] { paramd.xAc });
              paramd.xAc.setVisibility(0);
              paramd.rJr.setVisibility(8);
              paramd.xAc.setEnableHorLongBmpMode(SnsInfoFlip.n(SnsInfoFlip.this));
              paramd.xAc.cH(paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight());
              paramd.xAc.setImageBitmap(null);
              paramd.xAc.setImageBitmap(paramAnonymousBitmap);
              paramd.xAc.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98740);
                  SnsInfoFlip.c.2.this.xzU.rkO.setVisibility(8);
                  SnsInfoFlip.c.2.this.xzU.iiP.setVisibility(8);
                  AppMethodBeat.o(98740);
                }
              });
            }
            AppMethodBeat.o(98741);
          }
        });
        AppMethodBeat.o(187700);
        return;
      }
    }
    
    private View j(final int paramInt, View paramView)
    {
      final boolean bool = true;
      AppMethodBeat.i(98750);
      Object localObject2 = Nx(paramInt).dyS;
      final SnsInfoFlip.d locald;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        locald = new SnsInfoFlip.d();
        paramView = View.inflate(this.context, 2131495549, null);
        locald.xAb = paramView.findViewById(2131300341);
        locald.rkO = ((ImageView)paramView.findViewById(2131301501));
        locald.iiP = ((ProgressBar)paramView.findViewById(2131301506));
        locald.xAc = ((MultiTouchImageView)paramView.findViewById(2131302559));
        locald.rJr = ((WxImageView)paramView.findViewById(2131307106));
        paramView.setTag(locald);
        ad.d("MicroMsg.SnsGalleryAdapter", "gallery position %d, media id: %s, %s.", new Object[] { Integer.valueOf(paramInt), ((bpi)localObject2).Id, locald.xAc });
        locald.position = paramInt;
        if ((bt.isNullOrNil(SnsInfoFlip.l(SnsInfoFlip.this))) || (!SnsInfoFlip.l(SnsInfoFlip.this).equals(((bpi)localObject2).Id))) {
          break label322;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (!((bpi)localObject2).Id.startsWith("Locall_path")) {
          break label385;
        }
        localObject1 = localObject2;
        if (bt.isNullOrNil(Nx(paramInt).wNP)) {
          break label385;
        }
        localObject3 = (com.tencent.mm.plugin.sns.storage.p)SnsInfoFlip.m(SnsInfoFlip.this).get(Nx(paramInt).wNP);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = af.dtu().apK(Nx(paramInt).wNP);
          SnsInfoFlip.m(SnsInfoFlip.this).put(Nx(paramInt).wNP, localObject1);
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
      Object localObject3 = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dxy();
      Object localObject1 = localObject2;
      if (((TimeLineObject)localObject3).Etm.DaC.size() > Nx(paramInt).wNQ) {
        localObject1 = (bpi)((TimeLineObject)localObject3).Etm.DaC.get(Nx(paramInt).wNQ);
      }
      label385:
      localObject2 = com.tencent.mm.plugin.sns.model.f.C((bpi)localObject1);
      if ((!bt.isNullOrNil((String)localObject2)) && (SnsInfoFlip.aqy((String)localObject2)))
      {
        ad.i("MicroMsg.SnsGalleryAdapter", "pennqin, use wxImageView.");
        locald.xAc.setVisibility(8);
        locald.rJr.setVisibility(0);
        localObject3 = com.tencent.mm.sdk.platformtools.f.aFf((String)localObject2);
        if (localObject3 != null)
        {
          int i = BackwardSupportUtil.ExifHelper.co((String)localObject2);
          locald.rJr.setOrientation(i);
          locald.rJr.cH(((BitmapFactory.Options)localObject3).outWidth, ((BitmapFactory.Options)localObject3).outHeight);
          locald.rJr.eSz();
          locald.rJr.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
          {
            public final void a(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void b(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
            {
              AppMethodBeat.i(187699);
              ad.w("MicroMsg.SnsGalleryAdapter", "onImageLoadError, switch to multiTouchImageView");
              SnsInfoFlip.c.a(SnsInfoFlip.c.this, locald, paramInt, this.xzV, bool);
              AppMethodBeat.o(187699);
            }
            
            public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void m(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(98739);
              ad.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on image loaded.");
              locald.rkO.setVisibility(8);
              locald.iiP.setVisibility(8);
              AppMethodBeat.o(98739);
            }
            
            public final void qq()
            {
              AppMethodBeat.i(98738);
              ad.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on preview loaded.");
              AppMethodBeat.o(98738);
            }
            
            public final void qr() {}
          });
          localObject1 = Uri.encode(i.k(com.tencent.mm.plugin.sns.model.f.q((bpi)localObject1), false));
          if (!bt.isNullOrNil((String)localObject1)) {
            locald.rJr.a(i.k((String)localObject2, false), com.davemorrissey.labs.subscaleview.view.a.U((String)localObject1));
          }
        }
      }
      for (;;)
      {
        Nv(paramInt);
        AppMethodBeat.o(98750);
        return paramView;
        a(locald, paramInt, (bpi)localObject1, bool);
      }
    }
    
    public final MultiTouchImageView Ef(int paramInt)
    {
      AppMethodBeat.i(98743);
      Object localObject = super.OT(paramInt);
      if (localObject == null)
      {
        ad.e("MicroMsg.SnsGalleryAdapter", "position : %d getMultiTouchImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98743);
        return null;
      }
      localObject = (SnsInfoFlip.d)((View)localObject).getTag();
      if (localObject == null)
      {
        ad.e("MicroMsg.SnsGalleryAdapter", "position : %d getMultiTouchImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98743);
        return null;
      }
      if (((SnsInfoFlip.d)localObject).xAc.getVisibility() == 8)
      {
        AppMethodBeat.o(98743);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).xAc;
      AppMethodBeat.o(98743);
      return localObject;
    }
    
    public final WxImageView Eg(int paramInt)
    {
      AppMethodBeat.i(98744);
      Object localObject = super.OT(paramInt);
      if (localObject == null)
      {
        ad.e("MicroMsg.SnsGalleryAdapter", "position : %d getWxImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98744);
        return null;
      }
      localObject = (SnsInfoFlip.d)((View)localObject).getTag();
      if (localObject == null)
      {
        ad.e("MicroMsg.SnsGalleryAdapter", "position : %d getWxImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98744);
        return null;
      }
      if (((SnsInfoFlip.d)localObject).rJr.getVisibility() == 8)
      {
        AppMethodBeat.o(98744);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).rJr;
      AppMethodBeat.o(98744);
      return localObject;
    }
    
    final void Nt(int paramInt)
    {
      AppMethodBeat.i(98746);
      Object localObject1 = Nx(paramInt);
      if (localObject1 == null)
      {
        ad.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but flip item is null.");
        AppMethodBeat.o(98746);
        return;
      }
      String str = ((com.tencent.mm.plugin.sns.j.b)localObject1).wNP;
      if (bt.isNullOrNil(str))
      {
        ad.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but sns local id is null.");
        AppMethodBeat.o(98746);
        return;
      }
      ad.i("MicroMsg.SnsGalleryAdapter", "notify online sight play pos %s sns local id %s.", new Object[] { Integer.valueOf(paramInt), str });
      Object localObject2 = (WeakReference)this.xzS.get(str);
      if (localObject2 == null)
      {
        ad.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but view cache is null.");
        this.xzR = str;
        AppMethodBeat.o(98746);
        return;
      }
      localObject2 = (OnlineVideoView)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        ad.w("MicroMsg.SnsGalleryAdapter", "online sight view is null, do nothing. snsLocalId %s.", new Object[] { str });
        this.xzR = str;
        AppMethodBeat.o(98746);
        return;
      }
      ad.i("MicroMsg.SnsGalleryAdapter", "%d notify online sight play video %s.", new Object[] { Integer.valueOf(localObject2.hashCode()), str });
      this.xzR = null;
      ((OnlineVideoView)localObject2).dzz();
      ((OnlineVideoView)localObject2).a(((com.tencent.mm.plugin.sns.j.b)localObject1).dyS, ((com.tencent.mm.plugin.sns.j.b)localObject1).wNP, ((com.tencent.mm.plugin.sns.j.b)localObject1).hgr);
      localObject1 = new ti();
      ((ti)localObject1).dyK.djq = 1;
      ((ti)localObject1).dyK.diQ = str;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(98746);
    }
    
    final boolean Nu(int paramInt)
    {
      AppMethodBeat.i(98752);
      View localView = OT(paramInt);
      if ((localView != null) && (Ef(paramInt) == null) && (Eg(paramInt) == null))
      {
        j(paramInt, localView);
        AppMethodBeat.o(98752);
        return true;
      }
      AppMethodBeat.o(98752);
      return false;
    }
    
    public final com.tencent.mm.plugin.sns.j.b Nx(int paramInt)
    {
      AppMethodBeat.i(98756);
      if ((paramInt < SnsInfoFlip.j(SnsInfoFlip.this).size()) && (paramInt >= 0))
      {
        com.tencent.mm.plugin.sns.j.b localb = (com.tencent.mm.plugin.sns.j.b)SnsInfoFlip.j(SnsInfoFlip.this).get(paramInt);
        AppMethodBeat.o(98756);
        return localb;
      }
      AppMethodBeat.o(98756);
      return null;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(98747);
      ad.i("MicroMsg.SnsGalleryAdapter", "adapter clear.");
      this.xzS.clear();
      AppMethodBeat.o(98747);
    }
    
    public final void dBo()
    {
      AppMethodBeat.i(98749);
      ad.i("MicroMsg.SnsGalleryAdapter", "notify online sight stop %s", new Object[] { bt.eGN() });
      ti localti = new ti();
      localti.dyK.context = this.context;
      localti.dyK.diQ = this.xzR;
      localti.dyK.djq = 2;
      com.tencent.mm.sdk.b.a.ESL.l(localti);
      this.xzR = null;
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
      if (Nx(paramInt).dyS.mBH == 6)
      {
        boolean bool;
        com.tencent.mm.plugin.sns.j.b localb;
        if (paramView == null)
        {
          bool = true;
          ad.d("MicroMsg.SnsGalleryAdapter", "fill view online sight %d convert view is null %b.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
          localb = Nx(paramInt);
          if (localb != null) {
            break label87;
          }
          ad.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but flip item is null.");
        }
        label87:
        Object localObject;
        for (;;)
        {
          AppMethodBeat.o(98745);
          return paramView;
          bool = false;
          break;
          localObject = localb.wNP;
          if (!bt.isNullOrNil((String)localObject)) {
            break label113;
          }
          ad.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but sns local id is null.");
        }
        label113:
        paramView = (WeakReference)this.xzS.get(localObject);
        if ((paramView != null) && (paramView.get() != null)) {
          paramView = (OnlineVideoView)paramView.get();
        }
        for (;;)
        {
          paramView.aD(null);
          if (bt.kU((String)localObject, this.xzR)) {
            Nt(paramInt);
          }
          ad.i("MicroMsg.SnsGalleryAdapter", "return online sight view %d parent id %s.", new Object[] { Integer.valueOf(paramView.hashCode()), localb.wNP });
          localObject = af.dtu().apK((String)localObject);
          if (localObject != null)
          {
            paramView.setScene(SnsInfoFlip.k(SnsInfoFlip.this));
            StringBuilder localStringBuilder = new StringBuilder();
            com.tencent.mm.kernel.g.afz();
            paramView.setSessionId(new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + bt.eGO());
            paramView.setSessionTimestamp(bt.eGO());
            paramView.setSnsId(com.tencent.mm.plugin.sns.data.q.st(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId));
            paramView.setFilePath(at.D(localb.dyS));
          }
          break;
          paramView = new OnlineVideoView(this.context);
          this.xzS.put(localObject, new WeakReference(paramView));
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
      if (this.xzT)
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
      this.xzT = true;
      super.notifyDataSetChanged();
      this.xzT = false;
      this.xzQ = SnsInfoFlip.j(SnsInfoFlip.this).size();
      ad.d("MicroMsg.SnsGalleryAdapter", "items.size: %d.", new Object[] { Integer.valueOf(this.xzQ) });
      if ((this.xzQ <= 0) && (SnsInfoFlip.o(SnsInfoFlip.this) != null)) {
        SnsInfoFlip.o(SnsInfoFlip.this).run();
      }
      AppMethodBeat.o(98755);
    }
  }
  
  static final class d
  {
    ProgressBar iiP;
    int position;
    WxImageView rJr;
    ImageView rkO;
    String videoPath = "";
    View xAb;
    MultiTouchImageView xAc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip
 * JD-Core Version:    0.7.0.1
 */