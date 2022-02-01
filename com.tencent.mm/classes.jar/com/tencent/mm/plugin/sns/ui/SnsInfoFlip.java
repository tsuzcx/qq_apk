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
import com.tencent.mm.g.a.uo;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.g.e;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.base.MMViewPager.e;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.o;
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
  private int AnM;
  int Arl;
  private boolean Arr;
  private boolean Art;
  c AuL;
  private boolean AuM;
  HashMap<Integer, Integer> AuN;
  HashMap<Integer, Long> AuO;
  HashMap<Integer, Long> AuP;
  private boolean AuQ;
  private boolean AuR;
  private boolean AuS;
  private boolean AuT;
  private boolean AuU;
  private float AuV;
  MMPageControlView AuW;
  private Runnable AuX;
  private String AuY;
  private int AuZ;
  long Ava;
  private b Avb;
  private HashMap<String, com.tencent.mm.plugin.sns.storage.p> Avc;
  private HashSet<String> Avd;
  public int Ave;
  private HashMap<String, a> Avf;
  private Context context;
  List<com.tencent.mm.plugin.sns.i.b> hMc;
  private aq handler;
  boolean isAd;
  MMViewPager tZe;
  public String username;
  
  public SnsInfoFlip(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98759);
    this.isAd = false;
    this.AuM = true;
    this.AuN = new HashMap();
    this.AuO = new HashMap();
    this.AuP = new HashMap();
    this.AuQ = false;
    this.AuR = false;
    this.AuS = false;
    this.AuT = false;
    this.AuU = true;
    this.AuV = 1.0F;
    this.AuX = null;
    this.handler = new aq();
    this.AuY = "";
    this.AuZ = -1;
    this.Arl = -1;
    this.Arr = false;
    this.Art = false;
    this.Ava = 0L;
    this.AnM = 0;
    this.Avc = new HashMap();
    this.Avd = new HashSet();
    this.Ave = 0;
    this.Avf = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98759);
  }
  
  public SnsInfoFlip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98758);
    this.isAd = false;
    this.AuM = true;
    this.AuN = new HashMap();
    this.AuO = new HashMap();
    this.AuP = new HashMap();
    this.AuQ = false;
    this.AuR = false;
    this.AuS = false;
    this.AuT = false;
    this.AuU = true;
    this.AuV = 1.0F;
    this.AuX = null;
    this.handler = new aq();
    this.AuY = "";
    this.AuZ = -1;
    this.Arl = -1;
    this.Arr = false;
    this.Art = false;
    this.Ava = 0L;
    this.AnM = 0;
    this.Avc = new HashMap();
    this.Avd = new HashSet();
    this.Ave = 0;
    this.Avf = new HashMap();
    init(paramContext);
    AppMethodBeat.o(98758);
  }
  
  private void b(bzh parambzh, int paramInt, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(98764);
    if (this.Avb != null) {
      this.Avb.a(parambzh, paramInt, paramString);
    }
    Object localObject = ah.dXE().aBr(paramString);
    if (localObject != null) {
      com.tencent.mm.plugin.sns.ui.a.c.h((com.tencent.mm.plugin.sns.storage.p)localObject, paramInt);
    }
    if (this.AuZ == -1) {
      this.AuZ = paramInt;
    }
    if ((bu.isNullOrNil(paramString)) && (this.AuL != null))
    {
      i = this.AuL.getCount();
      parambzh = paramInt + 1 + " / " + i;
      this.AhC.kc(parambzh, null);
      AppMethodBeat.o(98764);
      return;
    }
    com.tencent.mm.plugin.sns.storage.p localp = (com.tencent.mm.plugin.sns.storage.p)this.Avc.get(paramString);
    localObject = localp;
    if (localp == null)
    {
      localObject = ah.dXE().aBr(paramString);
      this.Avc.put(paramString, localObject);
    }
    if (localObject == null)
    {
      AppMethodBeat.o(98764);
      return;
    }
    if (parambzh.nJA != 6) {
      ah.cXK().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98735);
          if (SnsInfoFlip.c(SnsInfoFlip.this) != null) {
            SnsInfoFlip.c(SnsInfoFlip.this).efJ();
          }
          AppMethodBeat.o(98735);
        }
      });
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsInfoFlip", "onItemSelected " + paramInt + " localId " + paramString);
    long l1;
    if (this.Arl != paramInt)
    {
      if (!this.AuN.containsKey(Integer.valueOf(paramInt))) {
        break label832;
      }
      i = ((Integer)this.AuN.get(Integer.valueOf(paramInt))).intValue();
      this.AuN.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
      this.AuO.put(Integer.valueOf(paramInt), Long.valueOf(bu.HQ()));
      if (this.Arl >= 0)
      {
        if (!this.AuO.containsKey(Integer.valueOf(this.Arl))) {
          break label838;
        }
        l1 = ((Long)this.AuO.get(Integer.valueOf(this.Arl))).longValue();
        label364:
        if (l1 > 0L)
        {
          this.AuO.put(Integer.valueOf(this.Arl), Long.valueOf(0L));
          if (this.AuP.containsKey(Integer.valueOf(this.Arl))) {
            l2 = ((Long)this.AuP.get(Integer.valueOf(this.Arl))).longValue();
          }
          l1 = bu.aO(l1);
          l2 += l1;
          this.AuP.put(Integer.valueOf(this.Arl), Long.valueOf(l2));
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + this.Arl + " curtime " + l2 + " passtime " + l1 / 1000.0D);
        }
      }
      if ((this.Arr) && (this.AuL != null))
      {
        parambzh = this.AuL.RR(this.Arl);
        if (parambzh != null)
        {
          parambzh = parambzh.dKe.Id;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, bigPicId:%s", new Object[] { parambzh });
          if (this.Avf.containsKey(parambzh))
          {
            parambzh = (a)this.Avf.get(parambzh);
            parambzh.networkType = getReportNetworkType();
            if (parambzh.Avj == -1L) {
              break label844;
            }
            parambzh.Avh = 1;
            parambzh.zEx = (parambzh.Avj - parambzh.Avi);
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load success, costTime:%d", new Object[] { Long.valueOf(parambzh.zEx) });
          }
        }
      }
    }
    label651:
    this.Arl = paramInt;
    if (this.AhB != null) {
      this.AhB.aBV(paramString);
    }
    int i = ((com.tencent.mm.plugin.sns.storage.p)localObject).field_createTime;
    parambzh = ((com.tencent.mm.plugin.sns.storage.p)localObject).ebP();
    localObject = bj.r(this.context, i * 1000L);
    if ((parambzh != null) && (parambzh.HUG != null) && (parambzh.HUG.Gtx.size() > 1) && (this.AuL != null)) {
      i = parambzh.HUG.Gtx.size();
    }
    for (parambzh = this.AuL.RR(paramInt).zHI + 1 + " / " + i;; parambzh = null)
    {
      this.AhC.kc(String.valueOf(localObject), parambzh);
      this.AhC.fk(paramString, paramInt);
      if (this.AuL != null) {
        this.AuL.RN(paramInt);
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
      parambzh.Avh = 2;
      parambzh.Avj = System.currentTimeMillis();
      parambzh.zEx = (parambzh.Avj - parambzh.Avi);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load failed, costTime:%d", new Object[] { Long.valueOf(parambzh.zEx) });
      break label651;
    }
  }
  
  private void efG()
  {
    AppMethodBeat.i(98767);
    if ((this.AuL == null) || (this.AuL.RR(this.tZe.getCurrentItem()) == null))
    {
      AppMethodBeat.o(98767);
      return;
    }
    int i = this.tZe.getCurrentItem();
    if ((this.AuQ) && (this.AuL.getCount() > 1))
    {
      this.AuW.setVisibility(0);
      this.AuW.setPage(i);
    }
    bzh localbzh = this.AuL.RR(this.tZe.getCurrentItem()).dKe;
    this.Avd.add(localbzh.Id);
    String str1 = this.AuL.RR(this.tZe.getCurrentItem()).parentId;
    String str2 = localbzh.Id;
    if ((bu.isNullOrNil(this.AuY)) || (!this.AuY.equals(str2))) {
      this.AuY = "";
    }
    b(localbzh, i, str1);
    AppMethodBeat.o(98767);
  }
  
  private int getReportNetworkType()
  {
    AppMethodBeat.i(98777);
    Context localContext = ak.getContext();
    if (az.is2G(localContext))
    {
      AppMethodBeat.o(98777);
      return 1;
    }
    if (az.is3G(localContext))
    {
      AppMethodBeat.o(98777);
      return 2;
    }
    if (az.is4G(localContext))
    {
      AppMethodBeat.o(98777);
      return 3;
    }
    if (az.isWifi(localContext))
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
    this.Ava = System.currentTimeMillis();
    this.context = paramContext;
    this.tZe = ((MMViewPager)inflate(paramContext, 2131495553, this).findViewById(2131300335));
    this.tZe.setVerticalFadingEdgeEnabled(false);
    this.tZe.setHorizontalFadingEdgeEnabled(false);
    this.tZe.setOffscreenPageLimit(1);
    this.tZe.setSingleClickOverListener(new MMViewPager.e()
    {
      public final void aRO()
      {
        AppMethodBeat.i(98733);
        SnsInfoFlip.b(SnsInfoFlip.this);
        AppMethodBeat.o(98733);
      }
      
      public final void cYT()
      {
        AppMethodBeat.i(98734);
        SnsInfoFlip.b(SnsInfoFlip.this);
        AppMethodBeat.o(98734);
      }
    });
    this.AuW = ((MMPageControlView)findViewById(2131306987));
    this.AuW.setIndicatorLayoutRes(2131495626);
    paramContext = (LinearLayout.LayoutParams)this.AuW.getLayoutParams();
    paramContext.bottomMargin += ar.en(getContext());
    this.AuW.setLayoutParams(paramContext);
    r.zuB = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qMS, 3200);
    AppMethodBeat.o(98760);
  }
  
  public final void a(List<com.tencent.mm.plugin.sns.i.b> paramList, String paramString, int paramInt, x paramx, v.a parama)
  {
    AppMethodBeat.i(98765);
    ah.dXz().a(this);
    this.hMc = paramList;
    al.ajU(paramString);
    this.AhB = paramx;
    this.AhC = parama;
    this.AuL = new c(this.context);
    this.tZe.setAdapter(this.AuL);
    if ((paramInt >= 0) && (paramInt < this.hMc.size()))
    {
      this.tZe.setCurrentItem(paramInt);
      if (this.AuU)
      {
        this.AuU = false;
        paramList = this.AuL.RR(paramInt).dKe;
        if ((paramList == null) || (paramList.Hmm == null) || (paramList.Hmm.Hnb <= 0.0F)) {
          break label326;
        }
      }
    }
    label326:
    for (this.AuV = (paramList.Hmm.Hna / paramList.Hmm.Hnb);; this.AuV = 1.0F)
    {
      this.tZe.setFadingEdgeLength(0);
      this.tZe.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
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
            Object localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).RR(paramAnonymousInt).dKe;
            Object localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).RR(paramAnonymousInt).parentId;
            SnsInfoFlip.a(SnsInfoFlip.this, (bzh)localObject1, paramAnonymousInt, (String)localObject2);
            localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).HN(paramAnonymousInt);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).HO(paramAnonymousInt);
            }
            if (localObject1 != null) {
              ((com.tencent.mm.ui.base.g)localObject1).fCA();
            }
            if ((SnsInfoFlip.f(SnsInfoFlip.this) instanceof SnsBrowseUI)) {
              ((SnsBrowseUI)SnsInfoFlip.f(SnsInfoFlip.this)).efo();
            }
            SnsInfoFlip.c(SnsInfoFlip.this).RO(paramAnonymousInt);
          }
          AppMethodBeat.o(98736);
        }
      });
      if (this.AuM) {
        this.tZe.setLongClickOverListener(new MMViewPager.c()
        {
          public final void aRP()
          {
            AppMethodBeat.i(98737);
            if (!SnsInfoFlip.g(SnsInfoFlip.this))
            {
              AppMethodBeat.o(98737);
              return;
            }
            Object localObject1 = z.aBG().F("basescanui@datacenter", true);
            ((z.b)localObject1).k("key_basescanui_screen_x", Integer.valueOf(SnsInfoFlip.h(SnsInfoFlip.this).getXDown()));
            ((z.b)localObject1).k("key_basescanui_screen_y", Integer.valueOf(SnsInfoFlip.h(SnsInfoFlip.this).getYDown()));
            if (SnsInfoFlip.c(SnsInfoFlip.this) == null)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsInfoFlip", "longClickOver, adapter is null.");
              AppMethodBeat.o(98737);
              return;
            }
            localObject1 = SnsInfoFlip.c(SnsInfoFlip.this).RR(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem());
            if ((localObject1 == null) || (bu.isNullOrNil(((com.tencent.mm.plugin.sns.i.b)localObject1).parentId)))
            {
              AppMethodBeat.o(98737);
              return;
            }
            Object localObject2 = new ce();
            ((ce)localObject2).dQB = 1L;
            if (SnsInfoFlip.i(SnsInfoFlip.this)) {}
            for (((ce)localObject2).edv = 6L;; ((ce)localObject2).edv = 7L)
            {
              ((ce)localObject2).aLH();
              localObject2 = SnsInfoFlip.c(SnsInfoFlip.this).RR(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem()).dKe.Id;
              String str = ap.jv(ah.getAccSnsPath(), (String)localObject2) + r.k(SnsInfoFlip.c(SnsInfoFlip.this).RR(SnsInfoFlip.h(SnsInfoFlip.this).getCurrentItem()).dKe);
              SnsInfoFlip.this.e(str, ((com.tencent.mm.plugin.sns.i.b)localObject1).parentId, (String)localObject2, true);
              AppMethodBeat.o(98737);
              return;
            }
          }
        });
      }
      if ((this.AuQ) && (this.AuL.getCount() > 1))
      {
        this.AuW.setVisibility(0);
        this.AuW.jO(this.AuL.getCount(), paramInt);
      }
      if ((this.Art) && (!bu.isNullOrNil(this.AuL.RR(paramInt).parentId)))
      {
        paramList = this.AuL.RR(paramInt).dKe.Id;
        aBS(ap.jv(ah.getAccSnsPath(), paramList) + r.k(this.AuL.RR(paramInt).dKe));
      }
      AppMethodBeat.o(98765);
      return;
    }
  }
  
  public final void bQ(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(98775);
    if (this.AuL == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsInfoFlip", "onImageFinish, mediaId: %s, isOK: %s, null == adapter: %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (this.AuL != null) {
        break;
      }
      AppMethodBeat.o(98775);
      return;
    }
    Object localObject;
    if ((!paramBoolean) && (this.AuL.RR(this.tZe.getCurrentItem()) != null))
    {
      localObject = this.AuL.RR(this.tZe.getCurrentItem()).dKe;
      if ((localObject != null) && (((bzh)localObject).Id != null) && (((bzh)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131763806), 0).show();
        this.AuY = paramString;
      }
    }
    this.Ave += 1;
    if (this.Arr)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.Avf.containsKey(paramString)))
      {
        localObject = (a)this.Avf.get(paramString);
        ((a)localObject).Avj = System.currentTimeMillis();
        ((a)localObject).networkType = getReportNetworkType();
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
      }
    }
    c localc;
    int j;
    if (this.AuL.RR(this.tZe.getCurrentItem()) != null)
    {
      localObject = this.AuL.RR(this.tZe.getCurrentItem()).dKe;
      if ((localObject != null) && (((bzh)localObject).Id != null) && (((bzh)localObject).Id.equals(paramString)))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsInfoFlip", "img download finish, refresh ui, media id: %s. and mediaLocal id %s", new Object[] { ((bzh)localObject).Id, Integer.valueOf(((bzh)localObject).dKr) });
        localc = this.AuL;
        j = localc.Avg.hMc.size();
      }
    }
    for (;;)
    {
      if (i < j)
      {
        com.tencent.mm.plugin.sns.i.b localb = localc.RR(i);
        if ((localb != null) && (localb.dKe.Id.equals(paramString))) {
          localc.RO(i);
        }
      }
      else
      {
        if (this.Art) {
          E((bzh)localObject);
        }
        AppMethodBeat.o(98775);
        return;
      }
      i += 1;
    }
  }
  
  public final void bR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(98776);
    Object localObject = new StringBuilder("onSightFinish ").append(paramString).append(" ").append(paramBoolean).append(" ");
    if (this.AuL == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsInfoFlip", bool);
      if (this.AuL != null) {
        break;
      }
      AppMethodBeat.o(98776);
      return;
    }
    if ((!paramBoolean) && (this.AuL.RR(this.tZe.getCurrentItem()) != null))
    {
      localObject = this.AuL.RR(this.tZe.getCurrentItem()).dKe;
      if ((localObject != null) && (((bzh)localObject).Id != null) && (((bzh)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131763807), 0).show();
        this.AuY = paramString;
      }
    }
    this.AuL.notifyDataSetChanged();
    AppMethodBeat.o(98776);
  }
  
  public final boolean edq()
  {
    return this.Arr;
  }
  
  public final int efH()
  {
    AppMethodBeat.i(98770);
    if ((this.tZe == null) || (this.AuL == null))
    {
      AppMethodBeat.o(98770);
      return -1;
    }
    int i = this.tZe.getCurrentItem();
    if ((i >= 0) && (this.hMc.size() > i))
    {
      this.hMc.remove(i);
      this.AuL.notifyDataSetChanged();
      efG();
    }
    i = this.AuL.getCount();
    AppMethodBeat.o(98770);
    return i;
  }
  
  public final void efI()
  {
    AppMethodBeat.i(98778);
    Iterator localIterator = this.Avf.values().iterator();
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
      if (locala.Avh != -1)
      {
        localp = ah.dXE().aBr(locala.dsN);
        str = ap.jv(ah.getAccSnsPath(), locala.Avl) + r.k(locala.zyh);
        localOptions = h.aRz(str);
        k = 0;
        j = 0;
        i = (int)o.aZR(str);
        if (localOptions != null)
        {
          k = localOptions.outWidth;
          j = localOptions.outHeight;
          i = (int)o.aZR(str);
        }
        m = r.aou(str);
        if (locala.zyh.mediaType != 0) {
          m = locala.zyh.mediaType;
        }
        if (localp != null)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(11601, new Object[] { Integer.valueOf(locala.hGu), Integer.valueOf(locala.Avh), Long.valueOf(locala.zEx), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localp.field_snsId), Long.valueOf(locala.Avi), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.hGu), Integer.valueOf(locala.Avh), Long.valueOf(locala.zEx), Integer.valueOf(locala.networkType), Long.valueOf(localp.field_snsId), Long.valueOf(locala.Avi), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(r.aou(str)), str });
        }
      }
      else if (locala.Avi != -1L)
      {
        if (locala.Avj != -1L) {
          locala.Avh = 1;
        }
        for (;;)
        {
          locala.zEx = (locala.Avj - locala.Avi);
          localp = ah.dXE().aBr(locala.dsN);
          str = ap.jv(ah.getAccSnsPath(), locala.Avl) + r.k(locala.zyh);
          localOptions = h.aRz(str);
          k = 0;
          j = 0;
          i = (int)o.aZR(str);
          if (localOptions != null)
          {
            k = localOptions.outWidth;
            j = localOptions.outHeight;
            i = (int)o.aZR(str);
          }
          m = r.aou(str);
          if (locala.zyh.mediaType != 0) {
            m = locala.zyh.mediaType;
          }
          if (localp == null) {
            break;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(11601, new Object[] { Integer.valueOf(locala.hGu), Integer.valueOf(locala.Avh), Long.valueOf(locala.zEx), Integer.valueOf(locala.networkType), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(localp.field_snsId), Long.valueOf(locala.Avi), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", new Object[] { Integer.valueOf(locala.hGu), Integer.valueOf(locala.Avh), Long.valueOf(locala.zEx), Integer.valueOf(locala.networkType), Long.valueOf(localp.field_snsId), Long.valueOf(locala.Avi), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(r.aou(str)), str });
          break;
          locala.Avh = 2;
          locala.Avj = System.currentTimeMillis();
        }
      }
    }
    this.Avf.clear();
    AppMethodBeat.o(98778);
  }
  
  public bzh getCntMedia()
  {
    AppMethodBeat.i(98772);
    if (this.AuL != null)
    {
      int i = this.tZe.getCurrentItem();
      if ((this.hMc != null) && (i < this.hMc.size()))
      {
        bzh localbzh = this.AuL.RR(i).dKe;
        AppMethodBeat.o(98772);
        return localbzh;
      }
    }
    AppMethodBeat.o(98772);
    return null;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(98771);
    if (this.AuL != null)
    {
      int i = this.AuL.getCount();
      AppMethodBeat.o(98771);
      return i;
    }
    AppMethodBeat.o(98771);
    return 0;
  }
  
  public List<com.tencent.mm.plugin.sns.i.b> getFlipList()
  {
    return this.hMc;
  }
  
  public bk getFromScene()
  {
    return this.zul;
  }
  
  public MMViewPager getGallery()
  {
    return this.tZe;
  }
  
  public int getNumOfFileExist()
  {
    AppMethodBeat.i(98774);
    Iterator localIterator = this.hMc.iterator();
    int k = 0;
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.sns.i.b localb = (com.tencent.mm.plugin.sns.i.b)localIterator.next();
        ah.dXB();
        j = i;
        if (o.fB(com.tencent.mm.plugin.sns.model.g.C(localb.dKe))) {
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
    return this.Arl;
  }
  
  public int getSelectCount()
  {
    AppMethodBeat.i(98773);
    int i = this.Avd.size();
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
    if ((this.tZe != null) && (this.AuL != null))
    {
      int i = this.tZe.getCurrentItem();
      com.tencent.mm.plugin.sns.i.b localb = this.AuL.RR(i);
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
      localObject = ((bzh)localObject).Id;
      AppMethodBeat.o(98762);
      return localObject;
    }
    AppMethodBeat.o(98762);
    return null;
  }
  
  public long getSnsId()
  {
    AppMethodBeat.i(98766);
    if (this.AuL == null)
    {
      AppMethodBeat.o(98766);
      return 0L;
    }
    Object localObject = this.AuL.RR(this.tZe.getCurrentItem());
    if (localObject == null) {
      localObject = "";
    }
    while (!bu.isNullOrNil((String)localObject))
    {
      localObject = ah.dXE().aBr((String)localObject);
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
    return this.AuV;
  }
  
  protected final void onDestroy()
  {
    AppMethodBeat.i(98779);
    super.onDestroy();
    if (this.AuL != null)
    {
      this.AuL.detach();
      this.AuL = null;
    }
    AppMethodBeat.o(98779);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(98769);
    super.onPause();
    if (this.AuL != null)
    {
      this.AuL.efJ();
      this.AuL.clear();
    }
    AppMethodBeat.o(98769);
  }
  
  public final void rY(boolean paramBoolean)
  {
    AppMethodBeat.i(179207);
    if (this.AuL != null)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsInfoFlip", "onRefresh ");
      if (paramBoolean) {
        this.AuL.notifyDataSetChanged();
      }
      efG();
    }
    AppMethodBeat.o(179207);
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.AuT = paramBoolean;
  }
  
  public void setFromScene(bk parambk)
  {
    this.zul = parambk;
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
    this.Arr = paramBoolean;
  }
  
  public void setIsSoonEnterPhotoEditUI(boolean paramBoolean)
  {
    this.Art = paramBoolean;
  }
  
  public void setItems(List<com.tencent.mm.plugin.sns.i.b> paramList)
  {
    this.hMc = paramList;
  }
  
  public void setOnDeleteAllAction(Runnable paramRunnable)
  {
    this.AuX = paramRunnable;
  }
  
  public void setOnPageSelectListener(b paramb)
  {
    this.Avb = paramb;
  }
  
  public void setShowLongClickMenu(boolean paramBoolean)
  {
    this.AuM = paramBoolean;
  }
  
  public void setShowPageControl(boolean paramBoolean)
  {
    this.AuQ = paramBoolean;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.AuS = paramBoolean;
  }
  
  public void setTouchFinish(boolean paramBoolean)
  {
    this.AuR = paramBoolean;
  }
  
  public void setVideoScene(int paramInt)
  {
    this.AnM = paramInt;
  }
  
  final class a
  {
    int Avh = -1;
    long Avi = -1L;
    long Avj = -1L;
    bzj Avk;
    String Avl;
    String dsN = "";
    int hGu;
    int networkType;
    long zEx = -1L;
    bzh zyh;
    
    a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(bzh parambzh, int paramInt, String paramString);
  }
  
  final class c
    extends u
  {
    private int Avm;
    private String Avn;
    Map<String, WeakReference<View>> Avo;
    private boolean Avp;
    Context context;
    private boolean ptB;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(98742);
      this.Avo = new HashMap();
      this.Avp = false;
      this.context = paramContext;
      this.Avm = SnsInfoFlip.j(SnsInfoFlip.this).size();
      com.tencent.mm.modelcontrol.c.aHe();
      this.ptB = com.tencent.mm.modelcontrol.c.aHg();
      AppMethodBeat.o(98742);
    }
    
    private void RP(int paramInt)
    {
      AppMethodBeat.i(98753);
      if (!this.ptB)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (SnsInfoFlip.c(SnsInfoFlip.this) == null)
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (!com.tencent.mm.network.ae.cR(this.context))
      {
        AppMethodBeat.o(98753);
        return;
      }
      if (paramInt - 1 >= 0) {
        RQ(paramInt - 1);
      }
      if (paramInt + 1 < SnsInfoFlip.c(SnsInfoFlip.this).getCount()) {
        RQ(paramInt + 1);
      }
      AppMethodBeat.o(98753);
    }
    
    private void RQ(int paramInt)
    {
      AppMethodBeat.i(98754);
      bzh localbzh = RR(paramInt).dKe;
      bk localbk = bk.a(SnsInfoFlip.this.zul, RR(paramInt).icw);
      if (localbzh.nJA != 2)
      {
        AppMethodBeat.o(98754);
        return;
      }
      boolean bool = com.tencent.mm.plugin.sns.storage.x.aBM(RR(paramInt).parentId);
      ah.dXB();
      bool = com.tencent.mm.plugin.sns.model.g.a(localbzh, localbk, bool);
      if ((SnsInfoFlip.i(SnsInfoFlip.this)) && (!bool)) {
        SnsInfoFlip.a(SnsInfoFlip.this, localbzh.Id, SnsInfoFlip.this.getSelectItem().parentId, localbzh.Hmm, localbzh);
      }
      AppMethodBeat.o(98754);
    }
    
    private void a(final SnsInfoFlip.d paramd, final int paramInt, final bzh parambzh, final boolean paramBoolean)
    {
      AppMethodBeat.i(219896);
      final bk localbk = bk.a(SnsInfoFlip.this.zul, RR(paramInt).icw);
      com.tencent.mm.plugin.sns.model.g localg = ah.dXB();
      MultiTouchImageView localMultiTouchImageView = paramd.Avy;
      int i = this.context.hashCode();
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        localg.a(parambzh, localMultiTouchImageView, i, bool, localbk, com.tencent.mm.plugin.sns.storage.x.aBM(RR(paramInt).parentId), new g.e()
        {
          public final void am(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(98741);
            if ((!r.J(paramAnonymousBitmap)) && (SnsInfoFlip.i(SnsInfoFlip.this)) && (SnsInfoFlip.this.getSelectItem() != null)) {
              SnsInfoFlip.a(SnsInfoFlip.this, parambzh.Id, SnsInfoFlip.this.getSelectItem().parentId, parambzh.Hmm, parambzh);
            }
            if ((!r.J(paramAnonymousBitmap)) && (parambzh.Id != null) && (!parambzh.Id.startsWith("pre_temp_extend_pic")))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsGalleryAdapter", "big image not ready, set loading img. position: %d, media id: %s.", new Object[] { Integer.valueOf(paramInt), parambzh.Id });
              paramd.tBa.setVisibility(0);
              paramd.jeY.setVisibility(0);
              paramd.Avy.setVisibility(8);
              paramd.tYB.setVisibility(8);
              ah.dXB().eQ(paramd.tBa);
              ah.dXB().b(parambzh, paramd.tBa, 2131231318, SnsInfoFlip.c.this.context.hashCode(), localbk);
              if (paramBoolean)
              {
                paramd.jeY.setVisibility(8);
                AppMethodBeat.o(98741);
              }
            }
            else if (r.J(paramAnonymousBitmap))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsGalleryAdapter", "pennqin, use multiTouchImageView, %s.", new Object[] { paramd.Avy });
              paramd.Avy.setVisibility(0);
              paramd.tYB.setVisibility(8);
              paramd.Avy.setEnableHorLongBmpMode(SnsInfoFlip.n(SnsInfoFlip.this));
              paramd.Avy.cH(paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight());
              paramd.Avy.setImageBitmap(null);
              paramd.Avy.setImageBitmap(paramAnonymousBitmap);
              paramd.Avy.post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(98740);
                  SnsInfoFlip.c.2.this.Avq.tBa.setVisibility(8);
                  SnsInfoFlip.c.2.this.Avq.jeY.setVisibility(8);
                  AppMethodBeat.o(98740);
                }
              });
            }
            AppMethodBeat.o(98741);
          }
        });
        AppMethodBeat.o(219896);
        return;
      }
    }
    
    private View j(final int paramInt, View paramView)
    {
      final boolean bool = true;
      AppMethodBeat.i(98750);
      Object localObject2 = RR(paramInt).dKe;
      final SnsInfoFlip.d locald;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        locald = new SnsInfoFlip.d();
        paramView = View.inflate(this.context, 2131495549, null);
        locald.Avx = paramView.findViewById(2131300341);
        locald.tBa = ((ImageView)paramView.findViewById(2131301501));
        locald.jeY = ((ProgressBar)paramView.findViewById(2131301506));
        locald.Avy = ((MultiTouchImageView)paramView.findViewById(2131302559));
        locald.tYB = ((WxImageView)paramView.findViewById(2131307106));
        paramView.setTag(locald);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsGalleryAdapter", "gallery position %d, media id: %s, %s.", new Object[] { Integer.valueOf(paramInt), ((bzh)localObject2).Id, locald.Avy });
        locald.position = paramInt;
        if ((bu.isNullOrNil(SnsInfoFlip.l(SnsInfoFlip.this))) || (!SnsInfoFlip.l(SnsInfoFlip.this).equals(((bzh)localObject2).Id))) {
          break label322;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (!((bzh)localObject2).Id.startsWith("Locall_path")) {
          break label385;
        }
        localObject1 = localObject2;
        if (bu.isNullOrNil(RR(paramInt).parentId)) {
          break label385;
        }
        localObject3 = (com.tencent.mm.plugin.sns.storage.p)SnsInfoFlip.m(SnsInfoFlip.this).get(RR(paramInt).parentId);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = ah.dXE().aBr(RR(paramInt).parentId);
          SnsInfoFlip.m(SnsInfoFlip.this).put(RR(paramInt).parentId, localObject1);
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
      Object localObject3 = ((com.tencent.mm.plugin.sns.storage.p)localObject1).ebP();
      Object localObject1 = localObject2;
      if (((TimeLineObject)localObject3).HUG.Gtx.size() > RR(paramInt).zHI) {
        localObject1 = (bzh)((TimeLineObject)localObject3).HUG.Gtx.get(RR(paramInt).zHI);
      }
      label385:
      localObject2 = com.tencent.mm.plugin.sns.model.g.C((bzh)localObject1);
      if ((!bu.isNullOrNil((String)localObject2)) && (SnsInfoFlip.aCf((String)localObject2)))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsGalleryAdapter", "pennqin, use wxImageView.");
        locald.Avy.setVisibility(8);
        locald.tYB.setVisibility(0);
        localObject3 = h.aRz((String)localObject2);
        if (localObject3 != null)
        {
          int i = BackwardSupportUtil.ExifHelper.df((String)localObject2);
          locald.tYB.setOrientation(i);
          locald.tYB.cH(((BitmapFactory.Options)localObject3).outWidth, ((BitmapFactory.Options)localObject3).outHeight);
          locald.tYB.fCA();
          locald.tYB.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
          {
            public final void a(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void b(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
            {
              AppMethodBeat.i(219895);
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SnsGalleryAdapter", "onImageLoadError, switch to multiTouchImageView");
              SnsInfoFlip.c.a(SnsInfoFlip.c.this, locald, paramInt, this.Avr, bool);
              AppMethodBeat.o(219895);
            }
            
            public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc) {}
            
            public final void n(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(98739);
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on image loaded.");
              locald.tBa.setVisibility(8);
              locald.jeY.setVisibility(8);
              AppMethodBeat.o(98739);
            }
            
            public final void rY()
            {
              AppMethodBeat.i(98738);
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on preview loaded.");
              AppMethodBeat.o(98738);
            }
            
            public final void rZ() {}
          });
          localObject1 = Uri.encode(o.k(com.tencent.mm.plugin.sns.model.g.q((bzh)localObject1), false));
          if (!bu.isNullOrNil((String)localObject1)) {
            locald.tYB.a(o.k((String)localObject2, false), com.davemorrissey.labs.subscaleview.view.a.aP((String)localObject1));
          }
        }
      }
      for (;;)
      {
        RP(paramInt);
        AppMethodBeat.o(98750);
        return paramView;
        a(locald, paramInt, (bzh)localObject1, bool);
      }
    }
    
    public final MultiTouchImageView HN(int paramInt)
    {
      AppMethodBeat.i(98743);
      Object localObject = super.Tq(paramInt);
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsGalleryAdapter", "position : %d getMultiTouchImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98743);
        return null;
      }
      localObject = (SnsInfoFlip.d)((View)localObject).getTag();
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsGalleryAdapter", "position : %d getMultiTouchImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98743);
        return null;
      }
      if (((SnsInfoFlip.d)localObject).Avy.getVisibility() == 8)
      {
        AppMethodBeat.o(98743);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).Avy;
      AppMethodBeat.o(98743);
      return localObject;
    }
    
    public final WxImageView HO(int paramInt)
    {
      AppMethodBeat.i(98744);
      Object localObject = super.Tq(paramInt);
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsGalleryAdapter", "position : %d getWxImageViewByPosition view is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98744);
        return null;
      }
      localObject = (SnsInfoFlip.d)((View)localObject).getTag();
      if (localObject == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsGalleryAdapter", "position : %d getWxImageViewByPosition holder is null.", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(98744);
        return null;
      }
      if (((SnsInfoFlip.d)localObject).tYB.getVisibility() == 8)
      {
        AppMethodBeat.o(98744);
        return null;
      }
      localObject = ((SnsInfoFlip.d)localObject).tYB;
      AppMethodBeat.o(98744);
      return localObject;
    }
    
    final void RN(int paramInt)
    {
      AppMethodBeat.i(98746);
      Object localObject1 = RR(paramInt);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but flip item is null.");
        AppMethodBeat.o(98746);
        return;
      }
      String str = ((com.tencent.mm.plugin.sns.i.b)localObject1).parentId;
      if (bu.isNullOrNil(str))
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but sns local id is null.");
        AppMethodBeat.o(98746);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsGalleryAdapter", "notify online sight play pos %s sns local id %s.", new Object[] { Integer.valueOf(paramInt), str });
      Object localObject2 = (WeakReference)this.Avo.get(str);
      if (localObject2 == null)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but view cache is null.");
        this.Avn = str;
        AppMethodBeat.o(98746);
        return;
      }
      localObject2 = (OnlineVideoView)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SnsGalleryAdapter", "online sight view is null, do nothing. snsLocalId %s.", new Object[] { str });
        this.Avn = str;
        AppMethodBeat.o(98746);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsGalleryAdapter", "%d notify online sight play video %s.", new Object[] { Integer.valueOf(localObject2.hashCode()), str });
      this.Avn = null;
      ((OnlineVideoView)localObject2).edP();
      ((OnlineVideoView)localObject2).a(((com.tencent.mm.plugin.sns.i.b)localObject1).dKe, ((com.tencent.mm.plugin.sns.i.b)localObject1).parentId, ((com.tencent.mm.plugin.sns.i.b)localObject1).icw);
      localObject1 = new uo();
      ((uo)localObject1).dJW.dto = 1;
      ((uo)localObject1).dJW.dsN = str;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(98746);
    }
    
    final boolean RO(int paramInt)
    {
      AppMethodBeat.i(98752);
      View localView = Tq(paramInt);
      if ((localView != null) && (HN(paramInt) == null) && (HO(paramInt) == null))
      {
        j(paramInt, localView);
        AppMethodBeat.o(98752);
        return true;
      }
      AppMethodBeat.o(98752);
      return false;
    }
    
    public final com.tencent.mm.plugin.sns.i.b RR(int paramInt)
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsGalleryAdapter", "adapter clear.");
      this.Avo.clear();
      AppMethodBeat.o(98747);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(98751);
      paramViewGroup.removeView((View)paramObject);
      super.destroyItem(paramViewGroup, paramInt, paramObject);
      AppMethodBeat.o(98751);
    }
    
    public final void efJ()
    {
      AppMethodBeat.i(98749);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsGalleryAdapter", "notify online sight stop %s", new Object[] { bu.fpN() });
      uo localuo = new uo();
      localuo.dJW.context = this.context;
      localuo.dJW.dsN = this.Avn;
      localuo.dJW.dto = 2;
      com.tencent.mm.sdk.b.a.IvT.l(localuo);
      this.Avn = null;
      AppMethodBeat.o(98749);
    }
    
    public final Object g(int paramInt, View paramView)
    {
      AppMethodBeat.i(98745);
      if (RR(paramInt).dKe.nJA == 6)
      {
        boolean bool;
        com.tencent.mm.plugin.sns.i.b localb;
        if (paramView == null)
        {
          bool = true;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsGalleryAdapter", "fill view online sight %d convert view is null %b.", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
          localb = RR(paramInt);
          if (localb != null) {
            break label87;
          }
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but flip item is null.");
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
          if (!bu.isNullOrNil((String)localObject)) {
            break label113;
          }
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but sns local id is null.");
        }
        label113:
        paramView = (WeakReference)this.Avo.get(localObject);
        if ((paramView != null) && (paramView.get() != null)) {
          paramView = (OnlineVideoView)paramView.get();
        }
        for (;;)
        {
          paramView.aI(null);
          if (bu.lX((String)localObject, this.Avn)) {
            RN(paramInt);
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsGalleryAdapter", "return online sight view %d parent id %s.", new Object[] { Integer.valueOf(paramView.hashCode()), localb.parentId });
          localObject = ah.dXE().aBr((String)localObject);
          if (localObject != null)
          {
            paramView.setScene(SnsInfoFlip.k(SnsInfoFlip.this));
            StringBuilder localStringBuilder = new StringBuilder();
            com.tencent.mm.kernel.g.ajP();
            paramView.setSessionId(new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).toString() + "_" + bu.fpO());
            paramView.setSessionTimestamp(bu.fpO());
            paramView.setSnsId(r.zV(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId));
            paramView.setFilePath(aw.D(localb.dKe));
          }
          break;
          paramView = new OnlineVideoView(this.context);
          this.Avo.put(localObject, new WeakReference(paramView));
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
      if (this.Avp)
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
      this.Avp = true;
      super.notifyDataSetChanged();
      this.Avp = false;
      this.Avm = SnsInfoFlip.j(SnsInfoFlip.this).size();
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsGalleryAdapter", "items.size: %d.", new Object[] { Integer.valueOf(this.Avm) });
      if ((this.Avm <= 0) && (SnsInfoFlip.o(SnsInfoFlip.this) != null)) {
        SnsInfoFlip.o(SnsInfoFlip.this).run();
      }
      AppMethodBeat.o(98755);
    }
  }
  
  static final class d
  {
    View Avx;
    MultiTouchImageView Avy;
    ProgressBar jeY;
    int position;
    ImageView tBa;
    WxImageView tYB;
    String videoPath = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip
 * JD-Core Version:    0.7.0.1
 */