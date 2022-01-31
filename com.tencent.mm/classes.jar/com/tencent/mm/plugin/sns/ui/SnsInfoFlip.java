package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Gallery;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.a.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MultiTouchImageView.a;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.vfs.e;
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
  private static int fgQ = 0;
  private static int fgR = 0;
  private Context context;
  private com.tencent.mm.sdk.platformtools.ak handler;
  List<com.tencent.mm.plugin.sns.h.b> items;
  private int rLH;
  private boolean rNW;
  private boolean rNY;
  SnsInfoFlip.b rQT;
  Gallery rQU;
  private boolean rQV;
  HashMap<Integer, Integer> rQW;
  HashMap<Integer, Long> rQX;
  HashMap<Integer, Long> rQY;
  private boolean rQZ;
  private MultiTouchImageView.a rRA;
  private boolean rRa;
  private boolean rRb;
  private boolean rRc;
  private boolean rRd;
  private boolean rRe;
  private boolean rRf;
  private float rRg;
  MMPageControlView rRh;
  private Runnable rRi;
  private String rRj;
  private int rRk;
  private int rRl;
  private boolean rRm;
  long rRn;
  private HashSet<String> rRo;
  private Map<String, Boolean> rRp;
  private int rRq;
  private int rRr;
  private boolean rRs;
  private SnsInfoFlip.c rRt;
  private HashMap<String, n> rRu;
  int rRv;
  private HashSet<String> rRw;
  public int rRx;
  public int rRy;
  private HashMap<String, SnsInfoFlip.a> rRz;
  boolean raZ;
  public String username;
  
  public SnsInfoFlip(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38985);
    this.raZ = false;
    this.rQV = true;
    this.rQW = new HashMap();
    this.rQX = new HashMap();
    this.rQY = new HashMap();
    this.rQZ = false;
    this.rRa = false;
    this.rRb = false;
    this.rRc = false;
    this.rRd = false;
    this.rRe = true;
    this.rRf = true;
    this.rRg = 1.0F;
    this.rRi = null;
    this.handler = new com.tencent.mm.sdk.platformtools.ak();
    this.rRj = "";
    this.rRk = -1;
    this.rRl = -1;
    this.rRm = false;
    this.rNW = false;
    this.rNY = false;
    this.rRn = 0L;
    this.rRo = new HashSet();
    this.rRq = 0;
    this.rRr = 0;
    this.rRs = false;
    this.rLH = 0;
    this.rRu = new HashMap();
    this.rRv = -1;
    this.rRw = new HashSet();
    this.rRx = 0;
    this.rRy = 0;
    this.rRz = new HashMap();
    this.rRA = new SnsInfoFlip.6(this);
    init(paramContext);
    AppMethodBeat.o(38985);
  }
  
  public SnsInfoFlip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38984);
    this.raZ = false;
    this.rQV = true;
    this.rQW = new HashMap();
    this.rQX = new HashMap();
    this.rQY = new HashMap();
    this.rQZ = false;
    this.rRa = false;
    this.rRb = false;
    this.rRc = false;
    this.rRd = false;
    this.rRe = true;
    this.rRf = true;
    this.rRg = 1.0F;
    this.rRi = null;
    this.handler = new com.tencent.mm.sdk.platformtools.ak();
    this.rRj = "";
    this.rRk = -1;
    this.rRl = -1;
    this.rRm = false;
    this.rNW = false;
    this.rNY = false;
    this.rRn = 0L;
    this.rRo = new HashSet();
    this.rRq = 0;
    this.rRr = 0;
    this.rRs = false;
    this.rLH = 0;
    this.rRu = new HashMap();
    this.rRv = -1;
    this.rRw = new HashSet();
    this.rRx = 0;
    this.rRy = 0;
    this.rRz = new HashMap();
    this.rRA = new SnsInfoFlip.6(this);
    init(paramContext);
    AppMethodBeat.o(38984);
  }
  
  private void a(bcs parambcs, int paramInt, String paramString)
  {
    long l2 = 0L;
    AppMethodBeat.i(38991);
    Object localObject1;
    String str1;
    int i;
    float f1;
    float f2;
    if ((this.rQU == null) || (!(this.rQU instanceof MMGestureGallery)))
    {
      if (this.rRt != null) {
        this.rRt.ES(paramInt);
      }
      localObject1 = ag.cpf().abv(paramString);
      if (localObject1 != null) {
        c.c((n)localObject1, paramInt);
      }
      if (this.rRk == -1) {
        this.rRk = paramInt;
      }
      this.rRl = 1;
      str1 = parambcs.Id;
      if (bo.isNullOrNil(paramString))
      {
        i = this.rQT.getCount();
        parambcs = paramInt + 1 + " / " + i;
        this.rGp.gI(parambcs, null);
        AppMethodBeat.o(38991);
      }
    }
    else
    {
      if (parambcs.xrV == null) {
        break label1201;
      }
      f1 = parambcs.xrV.xsI;
      f2 = parambcs.xrV.xsH;
    }
    for (;;)
    {
      if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
        if (parambcs.Id.startsWith("Locall_path"))
        {
          localObject1 = ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.m(parambcs);
          label233:
          localObject1 = d.aoT((String)localObject1);
          if (localObject1 == null) {
            break;
          }
          f1 = ((BitmapFactory.Options)localObject1).outHeight;
          f2 = ((BitmapFactory.Options)localObject1).outWidth;
        }
      }
      for (;;)
      {
        if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
          break label1199;
        }
        localObject1 = (MMGestureGallery)this.rQU;
        if ((this.rRd) && (f2 * 1.0D > f1 * 2.0D))
        {
          ab.d("MicroMsg.SnsInfoFlip", "set on fling true");
          ((MMGestureGallery)localObject1).znj = true;
          break;
          localObject1 = ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.d(parambcs);
          break label233;
        }
        ab.d("MicroMsg.SnsInfoFlip", "set on fling false");
        ((MMGestureGallery)localObject1).znj = false;
        break;
        Object localObject2 = (n)this.rRu.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ag.cpf().abv(paramString);
          this.rRu.put(paramString, localObject1);
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(38991);
          return;
        }
        if ((parambcs.jKs != 2) && ((this.rQU instanceof MMGestureGallery))) {
          ((MMGestureGallery)this.rQU).setLoadQuit(true);
        }
        if (parambcs.jKs != 6) {
          ag.bEf().post(new SnsInfoFlip.3(this));
        }
        ab.d("MicroMsg.SnsInfoFlip", "onItemSelected  " + paramInt + " localId " + paramString);
        long l1;
        if (this.rRv != paramInt)
        {
          if (!this.rQW.containsKey(Integer.valueOf(paramInt))) {
            break label1136;
          }
          i = ((Integer)this.rQW.get(Integer.valueOf(paramInt))).intValue();
          this.rQW.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
          this.rQX.put(Integer.valueOf(paramInt), Long.valueOf(bo.yB()));
          if (this.rRv >= 0)
          {
            if (!this.rQX.containsKey(Integer.valueOf(this.rRv))) {
              break label1142;
            }
            l1 = ((Long)this.rQX.get(Integer.valueOf(this.rRv))).longValue();
            label639:
            if (l1 > 0L)
            {
              this.rQX.put(Integer.valueOf(this.rRv), Long.valueOf(0L));
              if (this.rQY.containsKey(Integer.valueOf(this.rRv))) {
                l2 = ((Long)this.rQY.get(Integer.valueOf(this.rRv))).longValue();
              }
              l1 = bo.av(l1);
              l2 += l1;
              this.rQY.put(Integer.valueOf(this.rRv), Long.valueOf(l2));
              ab.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + this.rRv + " curtime " + l2 + " passtime " + l1 / 1000.0D);
            }
          }
          if ((this.rNW) && (this.rQT != null))
          {
            parambcs = (com.tencent.mm.plugin.sns.h.b)this.rQT.getItem(this.rRv);
            if (parambcs != null)
            {
              parambcs = parambcs.cIc.Id;
              ab.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, bigPicId:%s", new Object[] { parambcs });
              if (this.rRz.containsKey(parambcs))
              {
                parambcs = (SnsInfoFlip.a)this.rRz.get(parambcs);
                parambcs.networkType = getReportNetworkType();
                if (parambcs.rRF == -1L) {
                  break label1148;
                }
                parambcs.rRD = 1;
                parambcs.riP = (parambcs.rRF - parambcs.rRE);
                ab.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load success, costTime:%d", new Object[] { Long.valueOf(parambcs.riP) });
              }
            }
          }
        }
        for (;;)
        {
          this.rRv = paramInt;
          if (this.rGo != null) {
            this.rGo.abX(paramString);
          }
          i = ((n)localObject1).field_createTime;
          localObject2 = ((n)localObject1).csh();
          String str2 = ax.m(this.context, i * 1000L);
          localObject1 = null;
          parambcs = (bcs)localObject1;
          if (localObject2 != null)
          {
            parambcs = (bcs)localObject1;
            if (((TimeLineObject)localObject2).xTS != null)
            {
              parambcs = (bcs)localObject1;
              if (((TimeLineObject)localObject2).xTS.wOa.size() > 1)
              {
                i = ((TimeLineObject)localObject2).xTS.wOa.size();
                parambcs = ((com.tencent.mm.plugin.sns.h.b)this.items.get(paramInt)).rlK + 1 + " / " + i;
                this.rRl = b(str1, (TimeLineObject)localObject2);
              }
            }
          }
          this.rGp.gI(String.valueOf(str2), parambcs);
          this.rGp.dt(paramString, paramInt);
          if (this.rQT != null) {
            this.rQT.ER(paramInt);
          }
          AppMethodBeat.o(38991);
          return;
          label1136:
          i = 0;
          break;
          label1142:
          l1 = 0L;
          break label639;
          label1148:
          parambcs.rRD = 2;
          parambcs.rRF = System.currentTimeMillis();
          parambcs.riP = (parambcs.rRF - parambcs.rRE);
          ab.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load failed, costTime:%d", new Object[] { Long.valueOf(parambcs.riP) });
        }
      }
      label1199:
      break;
      label1201:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  private static int b(String paramString, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(38990);
    paramTimeLineObject = paramTimeLineObject.xTS.wOa.iterator();
    int i = 0;
    while (paramTimeLineObject.hasNext())
    {
      bcs localbcs = (bcs)paramTimeLineObject.next();
      int j = i + 1;
      i = j;
      if (paramString.equals(localbcs.Id))
      {
        AppMethodBeat.o(38990);
        return j;
      }
    }
    AppMethodBeat.o(38990);
    return 0;
  }
  
  private void cvk()
  {
    AppMethodBeat.i(38994);
    if ((this.rQU.getSelectedItem() == null) || (this.rQT == null))
    {
      AppMethodBeat.o(38994);
      return;
    }
    int i = this.rQU.getSelectedItemPosition();
    if ((this.rQZ) && (this.rQT.getCount() > 1))
    {
      this.rRh.setVisibility(0);
      this.rRh.setPage(i);
    }
    bcs localbcs = ((com.tencent.mm.plugin.sns.h.b)this.rQU.getSelectedItem()).cIc;
    this.rRw.add(localbcs.Id);
    String str1 = ((com.tencent.mm.plugin.sns.h.b)this.rQU.getSelectedItem()).rlJ;
    String str2 = localbcs.Id;
    if ((bo.isNullOrNil(this.rRj)) || (!this.rRj.equals(str2))) {
      this.rRj = "";
    }
    a(localbcs, i, str1);
    AppMethodBeat.o(38994);
  }
  
  private int getReportNetworkType()
  {
    AppMethodBeat.i(39007);
    Context localContext = ah.getContext();
    if (at.is2G(localContext))
    {
      AppMethodBeat.o(39007);
      return 1;
    }
    if (at.is3G(localContext))
    {
      AppMethodBeat.o(39007);
      return 2;
    }
    if (at.is4G(localContext))
    {
      AppMethodBeat.o(39007);
      return 3;
    }
    if (at.isWifi(localContext))
    {
      AppMethodBeat.o(39007);
      return 4;
    }
    AppMethodBeat.o(39007);
    return 0;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(38986);
    this.rRn = System.currentTimeMillis();
    this.context = paramContext;
    View localView = inflate(paramContext, 2130970830, this);
    if (f.dDB()) {
      localView.findViewById(2131828010).setVisibility(0);
    }
    for (this.rQU = ((Gallery)localView.findViewById(2131828010));; this.rQU = ((Gallery)localView.findViewById(2131828009)))
    {
      if ((this.rQU instanceof MMGestureGallery))
      {
        this.rQU.setSpacing(50);
        ((MMGestureGallery)this.rQU).setSingleClickOverListener(new SnsInfoFlip.1(this, paramContext));
        ((MMGestureGallery)this.rQU).setScrollLeftRightListener(new SnsInfoFlip.2(this));
      }
      this.rRh = ((MMPageControlView)findViewById(2131828011));
      this.rRh.setIndicatorLayoutRes(2130970899);
      paramContext = (LinearLayout.LayoutParams)this.rRh.getLayoutParams();
      paramContext.bottomMargin += am.fx(getContext());
      this.rRh.setLayoutParams(paramContext);
      this.rRp = new HashMap();
      AppMethodBeat.o(38986);
      return;
      localView.findViewById(2131828009).setVisibility(0);
    }
  }
  
  public final void a(List<com.tencent.mm.plugin.sns.h.b> paramList, String paramString, int paramInt, u paramu, s.a parama)
  {
    AppMethodBeat.i(38992);
    ag.cpa().a(this);
    this.items = paramList;
    boolean bool;
    if (this.items.size() > 1)
    {
      bool = true;
      this.rRm = bool;
      com.tencent.mm.plugin.sns.model.ak.aay(paramString);
      this.rGo = paramu;
      this.rGp = parama;
      this.rQT = new SnsInfoFlip.b(this, this.context);
      this.rQU.setAdapter(this.rQT);
      if ((paramInt >= 0) && (paramInt < this.items.size()))
      {
        this.rQU.setSelection(paramInt);
        if (this.rRf)
        {
          this.rRf = false;
          paramList = ((com.tencent.mm.plugin.sns.h.b)this.items.get(paramInt)).cIc;
          if ((paramList == null) || (paramList.xrV == null) || (paramList.xrV.xsI <= 0.0F)) {
            break label368;
          }
        }
      }
    }
    label368:
    for (this.rRg = (paramList.xrV.xsH / paramList.xrV.xsI);; this.rRg = 1.0F)
    {
      this.rQU.setFadingEdgeLength(0);
      this.rQU.setOnItemSelectedListener(new SnsInfoFlip.4(this));
      if (this.rQV) {
        this.rQU.setOnItemLongClickListener(new SnsInfoFlip.5(this));
      }
      if ((this.rQZ) && (this.rQT.getCount() > 1))
      {
        this.rRh.setVisibility(0);
        this.rRh.hy(this.rQT.getCount(), paramInt);
      }
      if ((this.rNY) && (!bo.isNullOrNil(((com.tencent.mm.plugin.sns.h.b)this.rQT.getItem(paramInt)).rlJ)))
      {
        paramList = ((com.tencent.mm.plugin.sns.h.b)this.rQT.getItem(paramInt)).cIc.Id;
        abU(ao.gl(ag.getAccSnsPath(), paramList) + i.l(((com.tencent.mm.plugin.sns.h.b)this.rQT.getItem(paramInt)).cIc));
      }
      AppMethodBeat.o(38992);
      return;
      bool = false;
      break;
    }
  }
  
  public final void bp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39005);
    Object localObject;
    if ((!paramBoolean) && (this.rQU.getSelectedItem() != null))
    {
      localObject = ((com.tencent.mm.plugin.sns.h.b)this.rQU.getSelectedItem()).cIc;
      if ((localObject != null) && (((bcs)localObject).Id != null) && (((bcs)localObject).Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131303799), 0).show();
        this.rRj = paramString;
      }
    }
    this.rRy += 1;
    if (this.rNW)
    {
      ab.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.rRz.containsKey(paramString)))
      {
        localObject = (SnsInfoFlip.a)this.rRz.get(paramString);
        ((SnsInfoFlip.a)localObject).rRF = System.currentTimeMillis();
        ((SnsInfoFlip.a)localObject).networkType = getReportNetworkType();
        ab.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
        this.rRp.put(paramString, Boolean.TRUE);
      }
    }
    if ((this.rQT != null) && (this.rQU.getSelectedItem() != null))
    {
      localObject = ((com.tencent.mm.plugin.sns.h.b)this.rQU.getSelectedItem()).cIc;
      if ((localObject != null) && (((bcs)localObject).Id != null) && (((bcs)localObject).Id.equals(paramString)))
      {
        this.rQT.notifyDataSetChanged();
        if (this.rNY) {
          E((bcs)localObject);
        }
      }
    }
    AppMethodBeat.o(39005);
  }
  
  public final void bq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39006);
    ab.i("MicroMsg.SnsInfoFlip", "onSightFinish " + paramString + " " + paramBoolean);
    if (!paramBoolean)
    {
      bcs localbcs = ((com.tencent.mm.plugin.sns.h.b)this.rQU.getSelectedItem()).cIc;
      if ((localbcs != null) && (localbcs.Id != null) && (localbcs.Id.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(2131303800), 0).show();
        this.rRj = paramString;
      }
    }
    if (this.rQT != null) {
      this.rQT.notifyDataSetChanged();
    }
    AppMethodBeat.o(39006);
  }
  
  public final void bvl()
  {
    AppMethodBeat.i(38995);
    if (this.rQT != null)
    {
      ab.d("MicroMsg.SnsInfoFlip", "onRefresh ");
      this.rQT.notifyDataSetChanged();
      cvk();
    }
    AppMethodBeat.o(38995);
  }
  
  public final boolean cty()
  {
    return this.rNW;
  }
  
  public final void cvl()
  {
    AppMethodBeat.i(38999);
    ab.i("MicroMsg.SnsInfoFlip", "sns info flip on detch.");
    if (this.rQT != null)
    {
      this.rQT.cvr();
      this.rQT.clear();
    }
    ag.cpa().b(this);
    AppMethodBeat.o(38999);
  }
  
  public final int cvm()
  {
    AppMethodBeat.i(39000);
    if (this.rQU == null)
    {
      AppMethodBeat.o(39000);
      return -1;
    }
    int i = this.rQU.getSelectedItemPosition();
    this.items.remove(i);
    this.rQT.notifyDataSetChanged();
    cvk();
    i = this.rQT.getCount();
    AppMethodBeat.o(39000);
    return i;
  }
  
  public final void cvn()
  {
    AppMethodBeat.i(39008);
    Iterator localIterator = this.rRz.values().iterator();
    while (localIterator.hasNext())
    {
      SnsInfoFlip.a locala = (SnsInfoFlip.a)localIterator.next();
      if (locala.rRD != -1)
      {
        h.qsU.e(11601, new Object[] { Integer.valueOf(locala.fjZ), Integer.valueOf(locala.rRD), Long.valueOf(locala.riP), Integer.valueOf(locala.networkType) });
        ab.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", new Object[] { Integer.valueOf(locala.fjZ), Integer.valueOf(locala.rRD), Long.valueOf(locala.riP), Integer.valueOf(locala.networkType) });
      }
      else if (locala.rRE != -1L)
      {
        if (locala.rRF != -1L) {
          locala.rRD = 1;
        }
        for (;;)
        {
          locala.riP = (locala.rRF - locala.rRE);
          h.qsU.e(11601, new Object[] { Integer.valueOf(locala.fjZ), Integer.valueOf(locala.rRD), Long.valueOf(locala.riP), Integer.valueOf(locala.networkType) });
          ab.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", new Object[] { Integer.valueOf(locala.fjZ), Integer.valueOf(locala.rRD), Long.valueOf(locala.riP), Integer.valueOf(locala.networkType) });
          break;
          locala.rRD = 2;
          locala.rRF = System.currentTimeMillis();
        }
      }
    }
    this.rRz.clear();
    AppMethodBeat.o(39008);
  }
  
  public bcs getCntMedia()
  {
    AppMethodBeat.i(39002);
    if (this.rQT != null)
    {
      int i = this.rQU.getSelectedItemPosition();
      if ((this.items != null) && (i < this.items.size()))
      {
        bcs localbcs = ((com.tencent.mm.plugin.sns.h.b)this.items.get(i)).cIc;
        AppMethodBeat.o(39002);
        return localbcs;
      }
    }
    AppMethodBeat.o(39002);
    return null;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(39001);
    if (this.rQT != null)
    {
      int i = this.rQT.getCount();
      AppMethodBeat.o(39001);
      return i;
    }
    AppMethodBeat.o(39001);
    return 0;
  }
  
  public List<com.tencent.mm.plugin.sns.h.b> getFlipList()
  {
    return this.items;
  }
  
  public az getFromScene()
  {
    return this.rbm;
  }
  
  public Gallery getGallery()
  {
    return this.rQU;
  }
  
  public int getNumOfFileExist()
  {
    AppMethodBeat.i(39004);
    Iterator localIterator = this.items.iterator();
    int k = 0;
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.sns.h.b localb = (com.tencent.mm.plugin.sns.h.b)localIterator.next();
        ag.cpc();
        j = i;
        if (e.cN(g.C(localb.cIc))) {
          j = i + 1;
        }
        k += 1;
        if (k <= 9) {}
      }
      else
      {
        AppMethodBeat.o(39004);
        return j;
      }
    }
  }
  
  public int getPosition()
  {
    return this.rRl;
  }
  
  public int getSelectCount()
  {
    AppMethodBeat.i(39003);
    int i = this.rRw.size();
    AppMethodBeat.o(39003);
    return i;
  }
  
  public String getSelectId()
  {
    AppMethodBeat.i(38989);
    if (this.rQU == null)
    {
      AppMethodBeat.o(38989);
      return "";
    }
    Object localObject = (com.tencent.mm.plugin.sns.h.b)this.rQU.getSelectedItem();
    if (localObject == null)
    {
      AppMethodBeat.o(38989);
      return "";
    }
    localObject = ((com.tencent.mm.plugin.sns.h.b)localObject).rlJ;
    AppMethodBeat.o(38989);
    return localObject;
  }
  
  public com.tencent.mm.plugin.sns.h.b getSelectItem()
  {
    AppMethodBeat.i(38987);
    if (this.rQU == null)
    {
      AppMethodBeat.o(38987);
      return null;
    }
    com.tencent.mm.plugin.sns.h.b localb = (com.tencent.mm.plugin.sns.h.b)this.rQU.getSelectedItem();
    AppMethodBeat.o(38987);
    return localb;
  }
  
  public String getSelectedMediaId()
  {
    AppMethodBeat.i(38988);
    if (this.rQU == null)
    {
      AppMethodBeat.o(38988);
      return null;
    }
    Object localObject = (com.tencent.mm.plugin.sns.h.b)this.rQU.getSelectedItem();
    if (localObject == null)
    {
      AppMethodBeat.o(38988);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.sns.h.b)localObject).cIc.Id;
    AppMethodBeat.o(38988);
    return localObject;
  }
  
  public long getSnsId()
  {
    AppMethodBeat.i(38993);
    Object localObject = (com.tencent.mm.plugin.sns.h.b)this.rQU.getSelectedItem();
    if (localObject == null) {
      localObject = "";
    }
    while (!bo.isNullOrNil((String)localObject))
    {
      localObject = ag.cpf().abv((String)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(38993);
        return 0L;
        localObject = ((com.tencent.mm.plugin.sns.h.b)localObject).rlJ;
      }
      else
      {
        long l = ((n)localObject).field_snsId;
        AppMethodBeat.o(38993);
        return l;
      }
    }
    AppMethodBeat.o(38993);
    return 0L;
  }
  
  public float getWidthModHeight()
  {
    return this.rRg;
  }
  
  public int gettotalSuccDownload()
  {
    return this.rRy;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38998);
    this.rRs = false;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(38998);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38997);
    this.rRs = true;
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(38997);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(38996);
    super.onPause();
    if (this.rQT != null)
    {
      this.rQT.cvr();
      this.rQT.clear();
    }
    AppMethodBeat.o(38996);
  }
  
  public void setDoubleClick(boolean paramBoolean)
  {
    this.rRa = paramBoolean;
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.rRd = paramBoolean;
  }
  
  public void setFromScene(az paramaz)
  {
    this.rbm = paramaz;
  }
  
  public void setInfoType(int paramInt)
  {
    this.infoType = paramInt;
  }
  
  public void setIsAd(boolean paramBoolean)
  {
    this.raZ = paramBoolean;
  }
  
  public void setIsFromMainTimeline(boolean paramBoolean)
  {
    this.rNW = paramBoolean;
  }
  
  public void setIsSoonEnterPhotoEditUI(boolean paramBoolean)
  {
    this.rNY = paramBoolean;
  }
  
  public void setItems(List<com.tencent.mm.plugin.sns.h.b> paramList)
  {
    this.items = paramList;
  }
  
  public void setOnDeleteAllAction(Runnable paramRunnable)
  {
    this.rRi = paramRunnable;
  }
  
  public void setOnPageSelectListener(SnsInfoFlip.c paramc)
  {
    this.rRt = paramc;
  }
  
  public void setOreitaion(boolean paramBoolean) {}
  
  public void setShowLongClickMenu(boolean paramBoolean)
  {
    this.rQV = paramBoolean;
  }
  
  public void setShowPageControl(boolean paramBoolean)
  {
    this.rQZ = paramBoolean;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.rRc = paramBoolean;
  }
  
  public void setTouchFinish(boolean paramBoolean)
  {
    this.rRb = paramBoolean;
  }
  
  public void setVideoScene(int paramInt)
  {
    this.rLH = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip
 * JD-Core Version:    0.7.0.1
 */