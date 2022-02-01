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
import com.tencent.mm.g.a.uk;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.model.f.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ar;
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
  private boolean Aae;
  private boolean Aag;
  private boolean AdA;
  HashMap<Integer, Integer> AdB;
  HashMap<Integer, Long> AdC;
  HashMap<Integer, Long> AdD;
  private boolean AdE;
  private boolean AdF;
  private boolean AdG;
  private boolean AdH;
  private boolean AdI;
  private float AdJ;
  MMPageControlView AdK;
  private Runnable AdL;
  private String AdM;
  private int AdN;
  long AdO;
  private b AdP;
  private HashMap<String, com.tencent.mm.plugin.sns.storage.p> AdQ;
  private HashSet<String> AdR;
  public int AdS;
  private HashMap<String, a> AdT;
  c Adz;
  private Context context;
  List<com.tencent.mm.plugin.sns.i.b> hJj;
  private ap handler;
  boolean isAd;
  MMViewPager tOn;
  public String username;
  private int zWD;
  int zZY;
  
  public SnsInfoFlip(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98759);
    this.isAd = false;
    this.AdA = true;
    this.AdB = new HashMap();
    this.AdC = new HashMap();
    this.AdD = new HashMap();
    this.AdE = false;
    this.AdF = false;
    this.AdG = false;
    this.AdH = false;
    this.AdI = true;
    this.AdJ = 1.0F;
    this.AdL = null;
    this.handler = new ap();
    this.AdM = "";
    this.AdN = -1;
    this.zZY = -1;
    this.Aae = false;
    this.Aag = false;
    this.AdO = 0L;
    this.zWD = 0;
    this.AdQ = new HashMap();
    this.AdR = new HashSet();
    this.AdS = 0;
    this.AdT = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98759);
  }
  
  public SnsInfoFlip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98758);
    this.isAd = false;
    this.AdA = true;
    this.AdB = new HashMap();
    this.AdC = new HashMap();
    this.AdD = new HashMap();
    this.AdE = false;
    this.AdF = false;
    this.AdG = false;
    this.AdH = false;
    this.AdI = true;
    this.AdJ = 1.0F;
    this.AdL = null;
    this.handler = new ap();
    this.AdM = "";
    this.AdN = -1;
    this.zZY = -1;
    this.Aae = false;
    this.Aag = false;
    this.AdO = 0L;
    this.zWD = 0;
    this.AdQ = new HashMap();
    this.AdR = new HashSet();
    this.AdS = 0;
    this.AdT = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98758);
  }
  
  private void b(byn parambyn, int paramInt, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(98764);
    if (this.AdP != null) {
      this.AdP.a(parambyn, paramInt, paramString);
    }
    Object localObject = ag.dUe().aAa(paramString);
    if (localObject != null) {
      com.tencent.mm.plugin.sns.ui.a.c.h((com.tencent.mm.plugin.sns.storage.p)localObject, paramInt);
    }
    if (this.AdN == -1) {
      this.AdN = paramInt;
    }
    if ((bt.isNullOrNil(paramString)) && (this.Adz != null))
    {
      i = this.Adz.getCount();
      parambyn = paramInt + 1 + " / " + i;
      this.zQv.jV(parambyn, null);
      AppMethodBeat.o(98764);
      return;
    }
    com.tencent.mm.plugin.sns.storage.p localp = (com.tencent.mm.plugin.sns.storage.p)this.AdQ.get(paramString);
    localObject = localp;
    if (localp == null)
    {
      localObject = ag.dUe().aAa(paramString);
      this.AdQ.put(paramString, localObject);
    }
    if (localObject == null)
    {
      AppMethodBeat.o(98764);
      return;
    }
    if (parambyn.nEf != 6) {
      ag.cVf().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98735);
          if (SnsInfoFlip.c(SnsInfoFlip.this) != null) {
            SnsInfoFlip.c(SnsInfoFlip.this).ecc();
          }
          AppMethodBeat.o(98735);
        }
      });
    }
    ad.d("MicroMsg.SnsInfoFlip", "onItemSelected " + paramInt + " localId " + paramString);
    long l1;
    if (this.zZY != paramInt)
    {
      if (!this.AdB.containsKey(Integer.valueOf(paramInt))) {
        break label832;
      }
      i = ((Integer)this.AdB.get(Integer.valueOf(paramInt))).intValue();
      this.AdB.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
      this.AdC.put(Integer.valueOf(paramInt), Long.valueOf(bt.HI()));
      if (this.zZY >= 0)
      {
        if (!this.AdC.containsKey(Integer.valueOf(this.zZY))) {
          break label838;
        }
        l1 = ((Long)this.AdC.get(Integer.valueOf(this.zZY))).longValue();
        label364:
        if (l1 > 0L)
        {
          this.AdC.put(Integer.valueOf(this.zZY), Long.valueOf(0L));
          if (this.AdD.containsKey(Integer.valueOf(this.zZY))) {
            l2 = ((Long)this.AdD.get(Integer.valueOf(this.zZY))).longValue();
          }
          l1 = bt.aO(l1);
          l2 += l1;
          this.AdD.put(Integer.valueOf(this.zZY), Long.valueOf(l2));
          ad.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + this.zZY + " curtime " + l2 + " passtime " + l1 / 1000.0D);
        }
      }
      if ((this.Aae) && (this.Adz != null))
      {
        parambyn = this.Adz.Rk(this.zZY);
        if (parambyn != null)
        {
          parambyn = parambyn.dIQ.Id;
          ad.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, bigPicId:%s", new Object[] { parambyn });
          if (this.AdT.containsKey(parambyn))
          {
            parambyn = (a)this.AdT.get(parambyn);
            parambyn.networkType = getReportNetworkType();
            if (parambyn.AdX == -1L) {
              break label844;
            }
            parambyn.AdV = 1;
            parambyn.zni = (parambyn.AdX - parambyn.AdW);
            ad.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load success, costTime:%d", new Object[] { Long.valueOf(parambyn.zni) });
          }
        }
      }
    }
    label651:
    this.zZY = paramInt;
    if (this.zQu != null) {
      this.zQu.aAE(paramString);
    }
    int i = ((com.tencent.mm.plugin.sns.storage.p)localObject).field_createTime;
    parambyn = ((com.tencent.mm.plugin.sns.storage.p)localObject).dYl();
    localObject = bj.q(this.context, i * 1000L);
    if ((parambyn != null) && (parambyn.HAT != null) && (parambyn.HAT.GaQ.size() > 1) && (this.Adz != null)) {
      i = parambyn.HAT.GaQ.size();
    }
    for (parambyn = this.Adz.Rk(paramInt).zqt + 1 + " / " + i;; parambyn = null)
    {
      this.zQv.jV(String.valueOf(localObject), parambyn);
      this.zQv.fb(paramString, paramInt);
      if (this.Adz != null) {
        this.Adz.Rg(paramInt);
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
      parambyn.AdV = 2;
      parambyn.AdX = System.currentTimeMillis();
      parambyn.zni = (parambyn.AdX - parambyn.AdW);
      ad.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load failed, costTime:%d", new Object[] { Long.valueOf(parambyn.zni) });
      break label651;
    }
  }
  
  private void ebZ()
  {
    AppMethodBeat.i(98767);
    if ((this.Adz == null) || (this.Adz.Rk(this.tOn.getCurrentItem()) == null))
    {
      AppMethodBeat.o(98767);
      return;
    }
    int i = this.tOn.getCurrentItem();
    if ((this.AdE) && (this.Adz.getCount() > 1))
    {
      this.AdK.setVisibility(0);
      this.AdK.setPage(i);
    }
    byn localbyn = this.Adz.Rk(this.tOn.getCurrentItem()).dIQ;
    this.AdR.add(localbyn.Id);
    String str1 = this.Adz.Rk(this.tOn.getCurrentItem()).parentId;
    String str2 = localbyn.Id;
    if ((bt.isNullOrNil(this.AdM)) || (!this.AdM.equals(str2))) {
      this.AdM = "";
    }
    b(localbyn, i, str1);
    AppMethodBeat.o(98767);
  }
  
  private int getReportNetworkType()
  {
    AppMethodBeat.i(98777);
    Context localContext = aj.getContext();
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
    this.AdO = System.currentTimeMillis();
    this.context = paramContext;
    this.tOn = ((MMViewPager)inflate(paramContext, 2131495553, this).findViewById(2131300335));
    this.tOn.setVerticalFadingEdgeEnabled(false);
    this.tOn.setHorizontalFadingEdgeEnabled(false);
    this.tOn.setOffscreenPageLimit(1);
    this.tOn.setSingleClickOverListener(new MMViewPager.e()
    {
      public final void aRp()
      {
        AppMethodBeat.i(98733);
        SnsInfoFlip.b(SnsInfoFlip.this);
        AppMethodBeat.o(98733);
      }
      
      public final void cWo()
      {
        AppMethodBeat.i(98734);
        SnsInfoFlip.b(SnsInfoFlip.this);
        AppMethodBeat.o(98734);
      }
    });
    this.AdK = ((MMPageControlView)findViewById(2131306987));
    this.AdK.setIndicatorLayoutRes(2131495626);
    paramContext = (LinearLayout.LayoutParams)this.AdK.getLayoutParams();
    paramContext.bottomMargin += ar.ej(getContext());
    this.AdK.setLayoutParams(paramContext);
    com.tencent.mm.plugin.sns.data.q.zdL = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFm, 3200);
    AppMethodBeat.o(98760);
  }
  
  public final void a(List<com.tencent.mm.plugin.sns.i.b> paramList, String paramString, int paramInt, x paramx, v.a parama)
  {
    AppMethodBeat.i(98765);
    ag.dTZ().a(this);
    this.hJj = paramList;
    ak.aiX(paramString);
    this.zQu = paramx;
    this.zQv = parama;
    this.Adz = new c(this.context);
    this.tOn.setAdapter(this.Adz);
    if ((paramInt >= 0) && (paramInt < this.hJj.size()))
    {
      this.tOn.setCurrentItem(paramInt);
      if (this.AdI)
      {
        this.AdI = false;
        paramList = this.Adz.Rk(paramInt).dIQ;
        if ((paramList == null) || (paramList.GSL == null) || (paramList.GSL.GTA <= 0.0F)) {
          break label326;
        }
      }
    }
    label326:
    for (this.AdJ = (paramList.GSL.GTz / paramList.GSL.GTA);; this.AdJ = 1.0F)
    {
      this.tOn.setFadingEdgeLength(0);
      this.tOn.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
            Object localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).Rk(paramAnonymousInt).dIQ;
            Object localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).Rk(paramAnonymousInt).parentId;
            SnsInfoFlip.a(SnsInfoFlip.this, (byn)localObject1, paramAnonymousInt, (String)localObject2);
            localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).Hq(paramAnonymousInt);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).Hr(paramAnonymousInt);
            }
            if (localObject1 != null) {
              ((com.tencent.mm.ui.base.g)localObject1).fyy();
            }
            if ((SnsInfoFlip.f(SnsInfoFlip.this) instanceof SnsBrowseUI)) {
              ((SnsBrowseUI)SnsInfoFlip.f(SnsInfoFlip.this)).ebH();
            }
            SnsInfoFlip.c(SnsInfoFlip.this).Rh(paramAnonymousInt);
          }
          AppMethodBeat.o(98736);
        }
      });
      if (this.AdA) {
        this.tOn.setLongClickOverListener(new MMViewPager.c()
        {
          public final void aRq()
          {
            AppMethodBeat.i(98737);
            if (!SnsInfoFlip.g(SnsInfoFlip.this))
            {
              AppMethodBeat.o(98737);
              return;
            }
            Object localObject1 = y.aBq().F("basescanui@datacenter", true);
            ((y.b)localObject1).k("key_basescanui_screen_x", Integer.valueOf(SnsInfoFlip.h(SnsInfoFlip.this).getXDown()));
            ((y.b)localObject1).k("key_basescanui_screen_y", Integer.valueOf(SnsInfoFlip.h(SnsInfoFlip.this).getYDown()));
            if (SnsInfoFlip.c(SnsInfoFlip.this) == null)
            {
              ad.e("MicroMsg.SnsInfoFlip", "longClickOver, adapter is null.");
              AppMethodBeat.o(98737);
              return;
            }
            localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).Rk(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem());
            if ((localObject1 == null) || (bt.isNullOrNil(((com.tencent.mm.plugin.sns.i.b)localObject1).parentId)))
            {
              AppMethodBeat.o(98737);
              return;
            }
            Object localObject2 = new ce();
            ((ce)localObject2).dPl = 1L;
            if (SnsInfoFlip.i(SnsInfoFlip.this)) {}
            for (((ce)localObject2).eca = 6L;; ((ce)localObject2).eca = 7L)
            {
              ((ce)localObject2).aLk();
              localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).Rk(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem()).dIQ.Id;
              String str = ao.jo(ag.getAccSnsPath(), (String)localObject2) + com.tencent.mm.plugin.sns.data.q.k(SnsInfoFlip.c(SnsInfoFlip.this).Rk(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem()).dIQ);
              SnsInfoFlip.this.e(str, ((com.tencent.mm.plugin.sns.i.b)localObject1).parentId, (String)localObject2, true);
              AppMethodBeat.o(98737);
              return;
            }
          }
        });
      }
      if ((this.AdE) && (this.Adz.getCount() > 1))
      {
        this.AdK.setVisibility(0);
        this.AdK.jK(this.Adz.getCount(), paramInt);
      }
      if ((this.Aag) && (!bt.isNullOrNil(this.Adz.Rk(paramInt).parentId)))
      {
        paramList = this.Adz.Rk(paramInt).dIQ.Id;
        aAB(ao.jo(ag.getAccSnsPath(), paramList) + com.tencent.mm.plugin.sns.data.q.k(this.Adz.Rk(paramInt).dIQ));
      }
      AppMethodBeat.o(98765);
      return;
    }
  }
  
  public final void bM(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(98775);
    if (this.Adz == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.SnsInfoFlip", "onImageFinish, mediaId: %s, isOK: %s, null == adapter: %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (this.Adz != null) {
        break;
      }
      AppMethodBeat.o(98775);
      return;
    }
    Object localObject;
    if ((!paramBoolean) && (this.Adz.Rk(this.tOn.getCurrentItem()) != null))
    {
      localObject = this.Adz.Rk(this.tOn.getCurrentItem()).dIQ;
      if ((localObject != null) && (((byn)localObject).Id != null) && (((byn)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131763806), 0).show();
        this.AdM = paramString;
      }
    }
    this.AdS += 1;
    if (this.Aae)
    {
      ad.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.AdT.containsKey(paramString)))
      {
        localObject = (a)this.AdT.get(paramString);
        ((a)localObject).AdX = System.currentTimeMillis();
        ((a)localObject).networkType = getReportNetworkType();
        ad.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
      }
    }
    c localc;
    int j;
    if (this.Adz.Rk(this.tOn.getCurrentItem()) != null)
    {
      localObject = this.Adz.Rk(this.tOn.getCurrentItem()).dIQ;
      if ((localObject != null) && (((byn)localObject).Id != null) && (((byn)localObject).Id.equals(paramString)))
      {
        ad.i("MicroMsg.SnsInfoFlip", "img download finish, refresh ui, media id: %s. and mediaLocal id %s", new Object[] { ((byn)localObject).Id, Integer.valueOf(((byn)localObject).dJd) });
        localc = this.Adz;
        j = localc.AdU.hJj.size();
      }
    }
    for (;;)
    {
      if (i < j)
      {
        com.tencent.mm.plugin.sns.i.b localb = localc.Rk(i);
        if ((localb != null) && (localb.dIQ.Id.equals(paramString))) {
          localc.Rh(i);
        }
      }
      else
      {
        if (this.Aag) {
          E((byn)localObject);
        }
        AppMethodBeat.o(98775);
        return;
      }
      i += 1;
    }
  }
  
  public final void bN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98776);
    Object localObject = new StringBuilder("onSightFinish ").append(paramString).append(" ").append(paramBoolean).append(" ");
    if (this.Adz == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.SnsInfoFlip", bool);
      if (this.Adz != null) {
        break;
      }
      AppMethodBeat.o(98776);
      return;
    }
    if ((!paramBoolean) && (this.Adz.Rk(this.tOn.getCurrentItem()) != null))
    {
      localObject = this.Adz.Rk(this.tOn.getCurrentItem()).dIQ;
      if ((localObject != null) && (((byn)localObject).Id != null) && (((byn)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131763807), 0).show();
        this.AdM = paramString;
      }
    }
    this.Adz.notifyDataSetChanged();
    AppMethodBeat.o(98776);
  }
  
  public final boolean dZK()
  {
    return this.Aae;
  }
  
  public final int eca()
  {
    AppMethodBeat.i(98770);
    if ((this.tOn == null) || (this.Adz == null))
    {
      AppMethodBeat.o(98770);
      return -1;
    }
    int i = this.tOn.getCurrentItem();
    if ((i >= 0) && (this.hJj.size() > i))
    {
      this.hJj.remove(i);
      this.Adz.notifyDataSetChanged();
      ebZ();
    }
    i = this.Adz.getCount();
    AppMethodBeat.o(98770);
    return i;
  }
  
  public final void ecb()
  {
    AppMethodBeat.i(98778);
    Iterator localIterator = this.AdT.values().iterator();
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
      if (locala.AdV != -1)
      {
        localp = ag.dUe().aAa(locala.drH);
        str = ao.jo(ag.getAccSnsPath(), locala.AdZ) + com.tencent.mm.plugin.sns.data.q.k(locala.zhs);
        localOptions = com.tencent.mm.sdk.platformtools.g.aQc(str);
        k = 0;
        j = 0;
        i = (int)i.aYo(str);
        if (localOptions != null)
        {
          k = localOptions.outWidth;
          j = localOptions.outHeight;
          i = (int)i.aYo(str);
        }
        m = com.tencent.mm.plugin.sns.data.q.ans(str);
        if (locala.zhs.mediaType != 0) {
          m = locala.zhs.mediaType;
        }
        if (localp != null)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(11601, new Object[] { Integer.valueOf(locala.hDC), Integer.valueOf(locala.AdV), Long.valueOf(locala.zni), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localp.field_snsId), Long.valueOf(locala.AdW), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          ad.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.hDC), Integer.valueOf(locala.AdV), Long.valueOf(locala.zni), Integer.valueOf(locala.networkType), Long.valueOf(localp.field_snsId), Long.valueOf(locala.AdW), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.sns.data.q.ans(str)), str });
        }
      }
      else if (locala.AdW != -1L)
      {
        if (locala.AdX != -1L) {
          locala.AdV = 1;
        }
        for (;;)
        {
          locala.zni = (locala.AdX - locala.AdW);
          localp = ag.dUe().aAa(locala.drH);
          str = ao.jo(ag.getAccSnsPath(), locala.AdZ) + com.tencent.mm.plugin.sns.data.q.k(locala.zhs);
          localOptions = com.tencent.mm.sdk.platformtools.g.aQc(str);
          k = 0;
          j = 0;
          i = (int)i.aYo(str);
          if (localOptions != null)
          {
            k = localOptions.outWidth;
            j = localOptions.outHeight;
            i = (int)i.aYo(str);
          }
          m = com.tencent.mm.plugin.sns.data.q.ans(str);
          if (locala.zhs.mediaType != 0) {
            m = locala.zhs.mediaType;
          }
          if (localp == null) {
            break;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(11601, new Object[] { Integer.valueOf(locala.hDC), Integer.valueOf(locala.AdV), Long.valueOf(locala.zni), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localp.field_snsId), Long.valueOf(locala.AdW), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          ad.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.hDC), Integer.valueOf(locala.AdV), Long.valueOf(locala.zni), Integer.valueOf(locala.networkType), Long.valueOf(localp.field_snsId), Long.valueOf(locala.AdW), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.sns.data.q.ans(str)), str });
          break;
          locala.AdV = 2;
          locala.AdX = System.currentTimeMillis();
        }
      }
    }
    this.AdT.clear();
    AppMethodBeat.o(98778);
  }
  
  public byn getCntMedia()
  {
    AppMethodBeat.i(98772);
    if (this.Adz != null)
    {
      int i = this.tOn.getCurrentItem();
      if ((this.hJj != null) && (i < this.hJj.size()))
      {
        byn localbyn = this.Adz.Rk(i).dIQ;
        AppMethodBeat.o(98772);
        return localbyn;
      }
    }
    AppMethodBeat.o(98772);
    return null;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(98771);
    if (this.Adz != null)
    {
      int i = this.Adz.getCount();
      AppMethodBeat.o(98771);
      return i;
    }
    AppMethodBeat.o(98771);
    return 0;
  }
  
  public List<com.tencent.mm.plugin.sns.i.b> getFlipList()
  {
    return this.hJj;
  }
  
  public com.tencent.mm.storage.bj getFromScene()
  {
    return this.zdv;
  }
  
  public MMViewPager getGallery()
  {
    return this.tOn;
  }
  
  public int getNumOfFileExist()
  {
    AppMethodBeat.i(98774);
    Iterator localIterator = this.hJj.iterator();
    int k = 0;
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.sns.i.b localb = (com.tencent.mm.plugin.sns.i.b)localIterator.next();
        ag.dUb();
        j = i;
        if (i.fv(f.C(localb.dIQ))) {
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
    return this.zZY;
  }
  
  public int getSelectCount()
  {
    AppMethodBeat.i(98773);
    int i = this.AdR.size();
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
    localObject = ((com.tencent.mm.plugin.sns.i.b)localObject).parentId;
    AppMethodBeat.o(98763);
    return localObject;
  }
  
  public com.tencent.mm.plugin.sns.i.b getSelectItem()
  {
    AppMethodBeat.i(98761);
    if ((this.tOn != null) && (this.Adz != null))
    {
      int i = this.tOn.getCurrentItem();
      com.tencent.mm.plugin.sns.i.b localb = this.Adz.Rk(i);
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
      localObject = ((byn)localObject).Id;
      AppMethodBeat.o(98762);
      return localObject;
    }
    AppMethodBeat.o(98762);
    return null;
  }
  
  public long getSnsId()
  {
    AppMethodBeat.i(98766);
    if (this.Adz == null)
    {
      AppMethodBeat.o(98766);
      return 0L;
    }
    Object localObject = this.Adz.Rk(this.tOn.getCurrentItem());
    if (localObject == null) {
      localObject = "";
    }
    while (!bt.isNullOrNil((String)localObject))
    {
      localObject = ag.dUe().aAa((String)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(98766);
        return 0L;
        localObject = ((com.tencent.mm.plugin.sns.i.b)localObject).parentId;
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
    return this.AdJ;
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(98779);
    super.onDestroy();
    if (this.Adz != null)
    {
      this.Adz.detach();
      this.Adz = null;
    }
    AppMethodBeat.o(98779);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(98769);
    super.onPause();
    if (this.Adz != null)
    {
      this.Adz.ecc();
      this.Adz.clear();
    }
    AppMethodBeat.o(98769);
  }
  
  public final void rR(boolean paramBoolean)
  {
    AppMethodBeat.i(179207);
    if (this.Adz != null)
    {
      ad.d("MicroMsg.SnsInfoFlip", "onRefresh ");
      if (paramBoolean) {
        this.Adz.notifyDataSetChanged();
      }
      ebZ();
    }
    AppMethodBeat.o(179207);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.AdH = paramBoolean;
  }
  
  public void setFromScene(com.tencent.mm.storage.bj parambj)
  {
    this.zdv = parambj;
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
    this.Aae = paramBoolean;
  }
  
  public void setIsSoonEnterPhotoEditUI(boolean paramBoolean)
  {
    this.Aag = paramBoolean;
  }
  
  public void setItems(List<com.tencent.mm.plugin.sns.i.b> paramList)
  {
    this.hJj = paramList;
  }
  
  public void setOnDeleteAllAction(Runnable paramRunnable)
  {
    this.AdL = paramRunnable;
  }
  
  public void setOnPageSelectListener(b paramb)
  {
    this.AdP = paramb;
  }
  
  public void setShowLongClickMenu(boolean paramBoolean)
  {
    this.AdA = paramBoolean;
  }
  
  public void setShowPageControl(boolean paramBoolean)
  {
    this.AdE = paramBoolean;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.AdG = paramBoolean;
  }
  
  public void setTouchFinish(boolean paramBoolean)
  {
    this.AdF = paramBoolean;
  }
  
  public void setVideoScene(int paramInt)
  {
    this.zWD = paramInt;
  }
  
  final class a
  {
    int AdV = -1;
    long AdW = -1L;
    long AdX = -1L;
    byp AdY;
    String AdZ;
    String drH = "";
    int hDC;
    int networkType;
    byn zhs;
    long zni = -1L;
    
    a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(byn parambyn, int paramInt, String paramString);
  }
  
  final class c
    extends u
  {
    private int Aea;
    private String Aeb;
    Map<String, WeakReference<View>> Aec;
    private boolean Aed;
    Context context;
    private boolean pmU;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(98742);
      this.Aec = new HashMap();
      this.Aed = false;
      this.context = paramContext;
      this.Aea = SnsInfoFlip.j(SnsInfoFlip.this).size();
      com.tencent.mm.modelcontrol.c.aGN();
      this.pmU = com.tencent.mm.modelcontrol.c.aGP();
      AppMethodBeat.o(98742);
    }
    
    private void Ri(int paramInt)
    {
      AppMethodBeat.i(98753);
      if (!this.pmU)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (SnsInfoFlip.c(SnsInfoFlip.this) == null)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (!ae.cP(this.context))
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (paramInt - 1 >= 0) {
        Rj(paramInt - 1);
      }
      if (paramInt + 1 < SnsInfoFlip.c(SnsInfoFlip.this).getCount()) {
        Rj(paramInt + 1);
      }
      AppMethodBeat.o(98753);
    }
    
    private void Rj(int paramInt)
    {
      AppMethodBeat.i(98754);
      byn localbyn = Rk(paramInt).dIQ;
      com.tencent.mm.storage.bj localbj = com.tencent.mm.storage.bj.a(SnsInfoFlip.this.zdv, Rk(paramInt).hZE);
      if (localbyn.nEf != 2)
      {
        AppMethodBeat.o(98754);
        return;
      }
      boolean bool = com.tencent.mm.plugin.sns.storage.x.aAv(Rk(paramInt).parentId);
      ag.dUb();
      bool = f.a(localbyn, localbj, bool);
      if ((SnsInfoFlip.i(SnsInfoFlip.this)) && (!bool)) {
        SnsInfoFlip.a(SnsInfoFlip.this, localbyn.Id, SnsInfoFlip.this.getSelectItem().parentId, localbyn.GSL, localbyn);
      }
      AppMethodBeat.o(98754);
    }
    
    private void a(final SnsInfoFlip.d paramd, final int paramInt, final byn parambyn, final boolean paramBoolean)
    {
      AppMethodBeat.i(198358);
      final com.tencent.mm.storage.bj localbj = com.tencent.mm.storage.bj.a(SnsInfoFlip.this.zdv, Rk(paramInt).hZE);
      f localf = ag.dUb();
      MultiTouchImageView localMultiTouchImageView = paramd.Aem;
      int i = this.context.hashCode();
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        localf.a(parambyn, localMultiTouchImageView, i, bool, localbj, com.tencent.mm.plugin.sns.storage.x.aAv(Rk(paramInt).parentId), new f.e()
        {
          public final void al(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(98741);
            if ((!com.tencent.mm.plugin.sns.data.q.I(paramAnonymousBitmap)) && (SnsInfoFlip.i(SnsInfoFlip.this)) && (SnsInfoFlip.this.getSelectItem() != null)) {
              SnsInfoFlip.a(SnsInfoFlip.this, parambyn.Id, SnsInfoFlip.this.getSelectItem().parentId, parambyn.GSL, parambyn);
            }
            if ((!com.tencent.mm.plugin.sns.data.q.I(paramAnonymousBitmap)) && (parambyn.Id != null) && (!parambyn.Id.startsWith("pre_temp_extend_pic")))
            {
              ad.i("MicroMsg.SnsGalleryAdapter", "big image not ready, set loading img. position: %d, media id: %s.", new Object[] { Integer.valueOf(paramInt), parambyn.Id });
              paramd.tqj.setVisibility(0);
              paramd.jcf.setVisibility(0);
              paramd.Aem.setVisibility(8);
              paramd.tNK.setVisibility(8);
              ag.dUb().eR(paramd.tqj);
              ag.dUb().b(parambyn, paramd.tqj, 2131231318, SnsInfoFlip.c.this.context.hashCode(), localbj);
              if (paramBoolean)
              {
                paramd.jcf.setVisibility(8);
                AppMethodBeat.o(98741);
              }
            }
            else if (com.tencent.mm.plugin.sns.data.q.I(paramAnonymousBitmap))
            {
              ad.i("MicroMsg.SnsGalleryAdapter", "pennqin, use multiTouchImageView, %s.", new Object[] { paramd.Aem });
              paramd.Aem.setVisibility(0);
              paramd.tNK.setVisibility(8);
              paramd.Aem.setEnableHorLongBmpMode(SnsInfoFlip.n(SnsInfoFlip.this));
              paramd.Aem.cH(paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight());
              paramd.Aem.setImageBitmap(null);
              paramd.Aem.setImageBitmap(paramAnonymousBitmap);
              paramd.Aem.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98740);
                  SnsInfoFlip.c.2.this.Aee.tqj.setVisibility(8);
                  SnsInfoFlip.c.2.this.Aee.jcf.setVisibility(8);
                  AppMethodBeat.o(98740);
                }
              });
            }
            AppMethodBeat.o(98741);
          }
        });
        AppMethodBeat.o(198358);
        return;
      }
    }
    
    private View j(final int paramInt, View paramView)
    {
      final boolean bool = true;
      AppMethodBeat.i(98750);
      Object localObject2 = Rk(paramInt).dIQ;
      final SnsInfoFlip.d locald;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        locald = new SnsInfoFlip.d();
        paramView = View.inflate(this.context, 2131495549, null);
        locald.Ael = paramView.findViewById(2131300341);
        locald.tqj = ((ImageView)paramView.findViewById(2131301501));
        locald.jcf = ((ProgressBar)paramView.findViewById(2131301506));
        locald.Aem = ((MultiTouchImageView)paramView.findViewById(2131302559));
        locald.tNK = ((WxImageView)paramView.findViewById(2131307106));
        paramView.setTag(locald);
        ad.d("MicroMsg.SnsGalleryAdapter", "gallery position %d, media id: %s, %s.", new Object[] { Integer.valueOf(paramInt), ((byn)localObject2).Id, locald.Aem });
        locald.position = paramInt;
        if ((bt.isNullOrNil(SnsInfoFlip.l(SnsInfoFlip.this))) || (!SnsInfoFlip.l(SnsInfoFlip.this).equals(((byn)localObject2).Id))) {
          break label322;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (!((byn)localObject2).Id.startsWith("Locall_path")) {
          break label385;
        }
        localObject1 = localObject2;
        if (bt.isNullOrNil(Rk(paramInt).parentId)) {
          break label385;
        }
        localObject3 = (com.tencent.mm.plugin.sns.storage.p)SnsInfoFlip.m(SnsInfoFlip.this).get(Rk(paramInt).parentId);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = ag.dUe().aAa(Rk(paramInt).parentId);
          SnsInfoFlip.m(SnsInfoFlip.this).put(Rk(paramInt).parentId, localObject1);
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
      Object localObject3 = ((com.tencent.mm.plugin.sns.storage.p)localObject1).dYl();
      Object localObject1 = localObject2;
      if (((TimeLineObject)localObject3).HAT.GaQ.size() > Rk(paramInt).zqt) {
        localObject1 = (byn)((TimeLineObject)localObject3).HAT.GaQ.get(Rk(paramInt).zqt);
      }
      label385:
      localObject2 = f.C((byn)localObject1);
      if ((!bt.isNullOrNil((String)localObject2)) && (SnsInfoFlip.aAO((String)localObject2)))
      {
        ad.i("MicroMsg.SnsGalleryAdapter", "pennqin, use wxImageView.");
        locald.Aem.setVisibility(8);
        locald.tNK.setVisibility(0);
        localObject3 = com.tencent.mm.sdk.platformtools.g.aQc((String)localObject2);
        if (localObject3 != null)
        {
          int i = BackwardSupportUtil.ExifHelper.cY((String)localObject2);
          locald.tNK.setOrientation(i);
          locald.tNK.cH(((BitmapFactory.Options)localObject3).outWidth, ((BitmapFactory.Options)localObject3).outHeight);
          locald.tNK.fyy();
          locald.tNK.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
          {
            public final void a(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void b(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
            {
              AppMethodBeat.i(198357);
              ad.w("MicroMsg.SnsGalleryAdapter", "onImageLoadError, switch to multiTouchImageView");
              SnsInfoFlip.c.a(SnsInfoFlip.c.this, locald, paramInt, this.Aef, bool);
              AppMethodBeat.o(198357);
            }
            
            public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void m(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(98739);
              ad.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on image loaded.");
              locald.tqj.setVisibility(8);
              locald.jcf.setVisibility(8);
              AppMethodBeat.o(98739);
            }
            
            public final void rY()
            {
              AppMethodBeat.i(98738);
              ad.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on preview loaded.");
              AppMethodBeat.o(98738);
            }
            
            public final void rZ() {}
          });
          localObject1 = Uri.encode(i.k(f.q((byn)localObject1), false));
          if (!bt.isNullOrNil((String)localObject1)) {
            locald.tNK.a(i.k((String)localObject2, false), com.davemorrissey.labs.subscaleview.view.a.aP((String)localObject1));
          }
        }
      }
      for (;;)
      {
        Ri(paramInt);
        AppMethodBeat.o(98750);
        return paramView;
        a(locald, paramInt, (byn)localObject1, bool);
      }
    }
    
    public final MultiTouchImageView Hq(int paramInt)
    {
      AppMethodBeat.i(98743);
      Object localObject = super.SJ(paramInt);
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
      if (((SnsInfoFlip.d)localObject).Aem.getVisibility() == 8)
      {
        AppMethodBeat.o(98743);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).Aem;
      AppMethodBeat.o(98743);
      return localObject;
    }
    
    public final WxImageView Hr(int paramInt)
    {
      AppMethodBeat.i(98744);
      Object localObject = super.SJ(paramInt);
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
      if (((SnsInfoFlip.d)localObject).tNK.getVisibility() == 8)
      {
        AppMethodBeat.o(98744);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).tNK;
      AppMethodBeat.o(98744);
      return localObject;
    }
    
    final void Rg(int paramInt)
    {
      AppMethodBeat.i(98746);
      Object localObject1 = Rk(paramInt);
      if (localObject1 == null)
      {
        ad.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but flip item is null.");
        AppMethodBeat.o(98746);
        return;
      }
      String str = ((com.tencent.mm.plugin.sns.i.b)localObject1).parentId;
      if (bt.isNullOrNil(str))
      {
        ad.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but sns local id is null.");
        AppMethodBeat.o(98746);
        return;
      }
      ad.i("MicroMsg.SnsGalleryAdapter", "notify online sight play pos %s sns local id %s.", new Object[] { Integer.valueOf(paramInt), str });
      Object localObject2 = (WeakReference)this.Aec.get(str);
      if (localObject2 == null)
      {
        ad.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but view cache is null.");
        this.Aeb = str;
        AppMethodBeat.o(98746);
        return;
      }
      localObject2 = (OnlineVideoView)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        ad.w("MicroMsg.SnsGalleryAdapter", "online sight view is null, do nothing. snsLocalId %s.", new Object[] { str });
        this.Aeb = str;
        AppMethodBeat.o(98746);
        return;
      }
      ad.i("MicroMsg.SnsGalleryAdapter", "%d notify online sight play video %s.", new Object[] { Integer.valueOf(localObject2.hashCode()), str });
      this.Aeb = null;
      ((OnlineVideoView)localObject2).eaj();
      ((OnlineVideoView)localObject2).a(((com.tencent.mm.plugin.sns.i.b)localObject1).dIQ, ((com.tencent.mm.plugin.sns.i.b)localObject1).parentId, ((com.tencent.mm.plugin.sns.i.b)localObject1).hZE);
      localObject1 = new uk();
      ((uk)localObject1).dII.dsi = 1;
      ((uk)localObject1).dII.drH = str;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(98746);
    }
    
    final boolean Rh(int paramInt)
    {
      AppMethodBeat.i(98752);
      View localView = SJ(paramInt);
      if ((localView != null) && (Hq(paramInt) == null) && (Hr(paramInt) == null))
      {
        j(paramInt, localView);
        AppMethodBeat.o(98752);
        return true;
      }
      AppMethodBeat.o(98752);
      return false;
    }
    
    public final com.tencent.mm.plugin.sns.i.b Rk(int paramInt)
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
    
    public final void clear()
    {
      AppMethodBeat.i(98747);
      ad.i("MicroMsg.SnsGalleryAdapter", "adapter clear.");
      this.Aec.clear();
      AppMethodBeat.o(98747);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(98751);
      paramViewGroup.removeView((View)paramObject);
      super.destroyItem(paramViewGroup, paramInt, paramObject);
      AppMethodBeat.o(98751);
    }
    
    public final void ecc()
    {
      AppMethodBeat.i(98749);
      ad.i("MicroMsg.SnsGalleryAdapter", "notify online sight stop %s", new Object[] { bt.flS() });
      uk localuk = new uk();
      localuk.dII.context = this.context;
      localuk.dII.drH = this.Aeb;
      localuk.dII.dsi = 2;
      com.tencent.mm.sdk.b.a.IbL.l(localuk);
      this.Aeb = null;
      AppMethodBeat.o(98749);
    }
    
    public final Object g(int paramInt, View paramView)
    {
      AppMethodBeat.i(98745);
      if (Rk(paramInt).dIQ.nEf == 6)
      {
        boolean bool;
        com.tencent.mm.plugin.sns.i.b localb;
        if (paramView == null)
        {
          bool = true;
          ad.d("MicroMsg.SnsGalleryAdapter", "fill view online sight %d convert view is null %b.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
          localb = Rk(paramInt);
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
          localObject = localb.parentId;
          if (!bt.isNullOrNil((String)localObject)) {
            break label113;
          }
          ad.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but sns local id is null.");
        }
        label113:
        paramView = (WeakReference)this.Aec.get(localObject);
        if ((paramView != null) && (paramView.get() != null)) {
          paramView = (OnlineVideoView)paramView.get();
        }
        for (;;)
        {
          paramView.aH(null);
          if (bt.lQ((String)localObject, this.Aeb)) {
            Rg(paramInt);
          }
          ad.i("MicroMsg.SnsGalleryAdapter", "return online sight view %d parent id %s.", new Object[] { Integer.valueOf(paramView.hashCode()), localb.parentId });
          localObject = ag.dUe().aAa((String)localObject);
          if (localObject != null)
          {
            paramView.setScene(SnsInfoFlip.k(SnsInfoFlip.this));
            StringBuilder localStringBuilder = new StringBuilder();
            com.tencent.mm.kernel.g.ajA();
            paramView.setSessionId(new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + bt.flT());
            paramView.setSessionTimestamp(bt.flT());
            paramView.setSnsId(com.tencent.mm.plugin.sns.data.q.zw(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId));
            paramView.setFilePath(av.D(localb.dIQ));
          }
          break;
          paramView = new OnlineVideoView(this.context);
          this.Aec.put(localObject, new WeakReference(paramView));
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
      if (this.Aed)
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
      this.Aed = true;
      super.notifyDataSetChanged();
      this.Aed = false;
      this.Aea = SnsInfoFlip.j(SnsInfoFlip.this).size();
      ad.d("MicroMsg.SnsGalleryAdapter", "items.size: %d.", new Object[] { Integer.valueOf(this.Aea) });
      if ((this.Aea <= 0) && (SnsInfoFlip.o(SnsInfoFlip.this) != null)) {
        SnsInfoFlip.o(SnsInfoFlip.this).run();
      }
      AppMethodBeat.o(98755);
    }
  }
  
  static final class d
  {
    View Ael;
    MultiTouchImageView Aem;
    ProgressBar jcf;
    int position;
    WxImageView tNK;
    ImageView tqj;
    String videoPath = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip
 * JD-Core Version:    0.7.0.1
 */