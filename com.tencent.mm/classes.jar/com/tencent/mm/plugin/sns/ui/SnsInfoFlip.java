package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Gallery;
import android.widget.Toast;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMNewPhotoEditUI;
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
  private static int dQP = 0;
  private static int dQQ = 0;
  private Context context;
  private ah handler = new ah();
  List<com.tencent.mm.plugin.sns.g.b> items;
  private boolean oVB = false;
  private boolean oVD = false;
  SnsInfoFlip.b oYA;
  Gallery oYB;
  private boolean oYC = true;
  HashMap<Integer, Integer> oYD = new HashMap();
  HashMap<Integer, Long> oYE = new HashMap();
  HashMap<Integer, Long> oYF = new HashMap();
  private boolean oYG = false;
  private boolean oYH = false;
  private boolean oYI = false;
  private boolean oYJ = false;
  private boolean oYK = false;
  private boolean oYL = true;
  private boolean oYM = true;
  private float oYN = 1.0F;
  MMPageControlView oYO;
  private Runnable oYP = null;
  private String oYQ = "";
  private int oYR = -1;
  private int oYS = -1;
  private boolean oYT = false;
  long oYU = 0L;
  private HashSet<String> oYV = new HashSet();
  private Map<String, Boolean> oYW;
  private int oYX = 0;
  private int oYY = 0;
  private boolean oYZ = false;
  private SnsInfoFlip.c oZa;
  private HashMap<String, n> oZb = new HashMap();
  int oZc = -1;
  private HashSet<String> oZd = new HashSet();
  public int oZe = 0;
  public int oZf = 0;
  private HashMap<String, SnsInfoFlip.a> oZg = new HashMap();
  private MultiTouchImageView.a oZh = new SnsInfoFlip.6(this);
  boolean omL = false;
  private az omX = az.uBK;
  public String username;
  
  public SnsInfoFlip(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public SnsInfoFlip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void a(awd paramawd, int paramInt, String paramString)
  {
    long l2 = 0L;
    Object localObject1;
    String str1;
    int i;
    label136:
    float f2;
    if ((this.oYB == null) || (!(this.oYB instanceof MMGestureGallery)))
    {
      if (this.oZa != null) {
        this.oZa.yK(paramInt);
      }
      localObject1 = af.bDF().OB(paramString);
      if (localObject1 != null) {
        aw.c((n)localObject1, paramInt);
      }
      if (this.oYR == -1) {
        this.oYR = paramInt;
      }
      this.oYS = 1;
      str1 = paramawd.lsK;
      if (bk.bl(paramString))
      {
        i = this.oYA.getCount();
        paramawd = paramInt + 1 + " / " + i;
        this.oOE.fa(paramawd, null);
      }
    }
    else
    {
      if (paramawd.trS == null) {
        break label1205;
      }
      f2 = paramawd.trS.tsG;
    }
    for (float f1 = paramawd.trS.tsF;; f1 = 0.0F)
    {
      label221:
      float f3;
      if ((f2 <= 0.0F) || (f1 <= 0.0F)) {
        if (paramawd.lsK.startsWith("Locall_path"))
        {
          localObject1 = an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.m(paramawd);
          localObject1 = c.YU((String)localObject1);
          if (localObject1 == null) {
            break;
          }
          f1 = ((BitmapFactory.Options)localObject1).outHeight;
          f3 = ((BitmapFactory.Options)localObject1).outWidth;
          f2 = f1;
        }
      }
      for (;;)
      {
        if ((f2 <= 0.0F) || (f3 <= 0.0F)) {
          break label1203;
        }
        localObject1 = (MMGestureGallery)this.oYB;
        if ((this.oYK) && (f3 * 1.0D > f2 * 2.0D))
        {
          y.d("MicroMsg.SnsInfoFlip", "set on fling true");
          ((MMGestureGallery)localObject1).uYS = true;
          break;
          localObject1 = an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.d(paramawd);
          break label221;
        }
        y.d("MicroMsg.SnsInfoFlip", "set on fling false");
        ((MMGestureGallery)localObject1).uYS = false;
        break;
        Object localObject2 = (n)this.oZb.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = af.bDF().OB(paramString);
          this.oZb.put(paramString, localObject1);
        }
        if (localObject1 == null) {
          break label136;
        }
        label444:
        long l1;
        if (paramawd.hQR == 2)
        {
          if ((this.oYB instanceof MMGestureGallery)) {
            ((MMGestureGallery)this.oYB).setLoadQuit(false);
          }
          if (paramawd.hQR != 6) {
            af.aXq().post(new SnsInfoFlip.3(this));
          }
          y.d("MicroMsg.SnsInfoFlip", "onItemSelected  " + paramInt + " localId " + paramString);
          if (this.oZc != paramInt)
          {
            if (!this.oYD.containsKey(Integer.valueOf(paramInt))) {
              break label1136;
            }
            i = ((Integer)this.oYD.get(Integer.valueOf(paramInt))).intValue();
            label541:
            this.oYD.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
            this.oYE.put(Integer.valueOf(paramInt), Long.valueOf(bk.UZ()));
            if (this.oZc >= 0)
            {
              if (!this.oYE.containsKey(Integer.valueOf(this.oZc))) {
                break label1142;
              }
              l1 = ((Long)this.oYE.get(Integer.valueOf(this.oZc))).longValue();
              label624:
              if (l1 > 0L)
              {
                this.oYE.put(Integer.valueOf(this.oZc), Long.valueOf(0L));
                if (this.oYF.containsKey(Integer.valueOf(this.oZc))) {
                  l2 = ((Long)this.oYF.get(Integer.valueOf(this.oZc))).longValue();
                }
                l1 = bk.cp(l1);
                l2 += l1;
                this.oYF.put(Integer.valueOf(this.oZc), Long.valueOf(l2));
                y.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + this.oZc + " curtime " + l2 + " passtime " + l1 / 1000.0D);
              }
            }
            if ((this.oVB) && (this.oYA != null))
            {
              paramawd = (com.tencent.mm.plugin.sns.g.b)this.oYA.getItem(this.oZc);
              if (paramawd != null)
              {
                paramawd = paramawd.bZK.lsK;
                y.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, bigPicId:%s", new Object[] { paramawd });
                if (this.oZg.containsKey(paramawd))
                {
                  paramawd = (SnsInfoFlip.a)this.oZg.get(paramawd);
                  paramawd.networkType = getReportNetworkType();
                  if (paramawd.oZm == -1L) {
                    break label1148;
                  }
                  paramawd.oZk = 1;
                  paramawd.otX = (paramawd.oZm - paramawd.oZl);
                  y.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load success, costTime:%d", new Object[] { Long.valueOf(paramawd.otX) });
                }
              }
            }
          }
        }
        for (;;)
        {
          this.oZc = paramInt;
          if (this.oOD != null) {
            this.oOD.Pd(paramString);
          }
          i = ((n)localObject1).field_createTime;
          localObject2 = ((n)localObject1).bGe();
          String str2 = ay.l(this.context, i * 1000L);
          localObject1 = null;
          paramawd = (awd)localObject1;
          if (localObject2 != null)
          {
            paramawd = (awd)localObject1;
            if (((bxk)localObject2).tNr != null)
            {
              paramawd = (awd)localObject1;
              if (((bxk)localObject2).tNr.sPJ.size() > 1)
              {
                i = ((bxk)localObject2).tNr.sPJ.size();
                paramawd = ((com.tencent.mm.plugin.sns.g.b)this.items.get(paramInt)).owQ + 1 + " / " + i;
                this.oYS = b(str1, (bxk)localObject2);
              }
            }
          }
          this.oOE.fa(str2, paramawd);
          this.oOE.cx(paramString, paramInt);
          if (this.oYA == null) {
            break;
          }
          this.oYA.yJ(paramInt);
          return;
          if (!(this.oYB instanceof MMGestureGallery)) {
            break label444;
          }
          ((MMGestureGallery)this.oYB).setLoadQuit(true);
          break label444;
          label1136:
          i = 0;
          break label541;
          label1142:
          l1 = 0L;
          break label624;
          label1148:
          paramawd.oZk = 2;
          paramawd.oZm = System.currentTimeMillis();
          paramawd.otX = (paramawd.oZm - paramawd.oZl);
          y.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load failed, costTime:%d", new Object[] { Long.valueOf(paramawd.otX) });
        }
        f3 = f1;
      }
      label1203:
      break;
      label1205:
      f2 = 0.0F;
    }
  }
  
  private static int b(String paramString, bxk parambxk)
  {
    parambxk = parambxk.tNr.sPJ.iterator();
    int i = 0;
    while (parambxk.hasNext())
    {
      awd localawd = (awd)parambxk.next();
      int j = i + 1;
      i = j;
      if (paramString.equals(localawd.lsK)) {
        return j;
      }
    }
    return 0;
  }
  
  private void bIP()
  {
    if ((this.oYB.getSelectedItem() == null) || (this.oYA == null)) {
      return;
    }
    int i = this.oYB.getSelectedItemPosition();
    if ((this.oYG) && (this.oYA.getCount() > 1))
    {
      this.oYO.setVisibility(0);
      this.oYO.setPage(i);
    }
    awd localawd = ((com.tencent.mm.plugin.sns.g.b)this.oYB.getSelectedItem()).bZK;
    this.oZd.add(localawd.lsK);
    String str1 = ((com.tencent.mm.plugin.sns.g.b)this.oYB.getSelectedItem()).owP;
    String str2 = localawd.lsK;
    if ((bk.bl(this.oYQ)) || (!this.oYQ.equals(str2))) {
      this.oYQ = "";
    }
    a(localawd, i, str1);
  }
  
  private int getReportNetworkType()
  {
    Context localContext = ae.getContext();
    if (aq.is2G(localContext)) {
      return 1;
    }
    if (aq.is3G(localContext)) {
      return 2;
    }
    if (aq.is4G(localContext)) {
      return 3;
    }
    if (aq.isWifi(localContext)) {
      return 4;
    }
    return 0;
  }
  
  private void init(Context paramContext)
  {
    this.oYU = System.currentTimeMillis();
    this.context = paramContext;
    View localView = inflate(paramContext, i.g.sns_info_flip_view, this);
    if (f.cAr()) {
      localView.findViewById(i.f.gallery_new).setVisibility(0);
    }
    for (this.oYB = ((Gallery)localView.findViewById(i.f.gallery_new));; this.oYB = ((Gallery)localView.findViewById(i.f.gallery_sns)))
    {
      if ((this.oYB instanceof MMGestureGallery))
      {
        this.oYB.setSpacing(50);
        ((MMGestureGallery)this.oYB).setSingleClickOverListener(new SnsInfoFlip.1(this, paramContext));
        ((MMGestureGallery)this.oYB).setScrollLeftRightListener(new SnsInfoFlip.2(this));
      }
      this.oYO = ((MMPageControlView)findViewById(i.f.what_news_page_control));
      this.oYO.setIndicatorLayoutRes(i.g.snspage_control_image);
      this.oYW = new HashMap();
      return;
      localView.findViewById(i.f.gallery_sns).setVisibility(0);
    }
  }
  
  public final void a(List<com.tencent.mm.plugin.sns.g.b> paramList, String paramString, int paramInt, u paramu, s.a parama)
  {
    af.bDA().a(this);
    this.items = paramList;
    boolean bool;
    if (this.items.size() > 1)
    {
      bool = true;
      this.oYT = bool;
      aj.NE(paramString);
      this.oOD = paramu;
      this.oOE = parama;
      this.oYA = new SnsInfoFlip.b(this, this.context);
      this.oYB.setAdapter(this.oYA);
      if ((paramInt >= 0) && (paramInt < this.items.size()))
      {
        this.oYB.setSelection(paramInt);
        if (this.oYM)
        {
          this.oYM = false;
          paramList = ((com.tencent.mm.plugin.sns.g.b)this.items.get(paramInt)).bZK;
          if ((paramList == null) || (paramList.trS == null) || (paramList.trS.tsG <= 0.0F)) {
            break label356;
          }
        }
      }
    }
    label356:
    for (this.oYN = (paramList.trS.tsF / paramList.trS.tsG);; this.oYN = 1.0F)
    {
      this.oYB.setFadingEdgeLength(0);
      this.oYB.setOnItemSelectedListener(new SnsInfoFlip.4(this));
      if (this.oYC) {
        this.oYB.setOnItemLongClickListener(new SnsInfoFlip.5(this));
      }
      if ((this.oYG) && (this.oYA.getCount() > 1))
      {
        this.oYO.setVisibility(0);
        this.oYO.fr(this.oYA.getCount(), paramInt);
      }
      if ((this.oVD) && (!bk.bl(((com.tencent.mm.plugin.sns.g.b)this.oYA.getItem(paramInt)).owP)))
      {
        paramList = ((com.tencent.mm.plugin.sns.g.b)this.oYA.getItem(paramInt)).bZK.lsK;
        Pa(an.eJ(af.getAccSnsPath(), paramList) + i.l(((com.tencent.mm.plugin.sns.g.b)this.oYA.getItem(paramInt)).bZK));
      }
      return;
      bool = false;
      break;
    }
  }
  
  public final void aPg()
  {
    if (this.oYA != null)
    {
      y.d("MicroMsg.SnsInfoFlip", "onRefresh ");
      this.oYA.notifyDataSetChanged();
      bIP();
    }
  }
  
  public final boolean bHt()
  {
    return this.oVB;
  }
  
  public final void bIQ()
  {
    y.i("MicroMsg.SnsInfoFlip", "sns info flip on detch.");
    if (this.oYA != null)
    {
      this.oYA.bIW();
      this.oYA.clear();
    }
    af.bDA().b(this);
  }
  
  public final int bIR()
  {
    if (this.oYB == null) {
      return -1;
    }
    int i = this.oYB.getSelectedItemPosition();
    this.items.remove(i);
    this.oYA.notifyDataSetChanged();
    bIP();
    return this.oYA.getCount();
  }
  
  public final void bIS()
  {
    Iterator localIterator = this.oZg.values().iterator();
    while (localIterator.hasNext())
    {
      SnsInfoFlip.a locala = (SnsInfoFlip.a)localIterator.next();
      if (locala.oZk != -1)
      {
        h.nFQ.f(11601, new Object[] { Integer.valueOf(locala.dTT), Integer.valueOf(locala.oZk), Long.valueOf(locala.otX), Integer.valueOf(locala.networkType) });
        y.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", new Object[] { Integer.valueOf(locala.dTT), Integer.valueOf(locala.oZk), Long.valueOf(locala.otX), Integer.valueOf(locala.networkType) });
      }
      else if (locala.oZl != -1L)
      {
        if (locala.oZm != -1L) {
          locala.oZk = 1;
        }
        for (;;)
        {
          locala.otX = (locala.oZm - locala.oZl);
          h.nFQ.f(11601, new Object[] { Integer.valueOf(locala.dTT), Integer.valueOf(locala.oZk), Long.valueOf(locala.otX), Integer.valueOf(locala.networkType) });
          y.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", new Object[] { Integer.valueOf(locala.dTT), Integer.valueOf(locala.oZk), Long.valueOf(locala.otX), Integer.valueOf(locala.networkType) });
          break;
          locala.oZk = 2;
          locala.oZm = System.currentTimeMillis();
        }
      }
    }
    this.oZg.clear();
  }
  
  public final void ba(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject = ((com.tencent.mm.plugin.sns.g.b)this.oYB.getSelectedItem()).bZK;
      if ((localObject != null) && (((awd)localObject).lsK != null) && (((awd)localObject).lsK.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(i.j.sns_down_error), 0).show();
        this.oYQ = paramString;
      }
    }
    this.oZf += 1;
    if (this.oVB)
    {
      y.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      if ((paramBoolean) && (this.oZg.containsKey(paramString)))
      {
        localObject = (SnsInfoFlip.a)this.oZg.get(paramString);
        ((SnsInfoFlip.a)localObject).oZm = System.currentTimeMillis();
        ((SnsInfoFlip.a)localObject).networkType = getReportNetworkType();
        y.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
        this.oYW.put(paramString, Boolean.valueOf(true));
      }
    }
    if ((this.oYA != null) && ((com.tencent.mm.plugin.sns.g.b)this.oYB.getSelectedItem() != null))
    {
      localObject = ((com.tencent.mm.plugin.sns.g.b)this.oYB.getSelectedItem()).bZK;
      if ((localObject != null) && (((awd)localObject).lsK != null) && (((awd)localObject).lsK.equals(paramString)))
      {
        this.oYA.notifyDataSetChanged();
        if ((this.oVD) && (localObject != null)) {
          break label246;
        }
      }
    }
    label246:
    do
    {
      return;
      paramString = an.eJ(af.getAccSnsPath(), ((awd)localObject).lsK);
      localObject = i.l((awd)localObject);
    } while (!e.bK(paramString + (String)localObject));
    paramString = paramString + (String)localObject;
    Object localObject = new Intent();
    y.i("MicroMsg.FlipView", "edit image path:%s", new Object[] { paramString });
    ((Intent)localObject).putExtra("before_photo_edit", paramString);
    ((Intent)localObject).putExtra("from_scene", 293);
    ((Intent)localObject).putExtra("after_photo_edit", "");
    ((Intent)localObject).putExtra("Retr_Compress_Type", 0);
    ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
    ((Intent)localObject).putExtra("Retr_FromMainTimeline", bHt());
    ((Intent)localObject).setClass(this.context, MMNewPhotoEditUI.class);
    this.context.startActivity((Intent)localObject);
  }
  
  public final void bb(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.SnsInfoFlip", "onSightFinish " + paramString + " " + paramBoolean);
    if (!paramBoolean)
    {
      awd localawd = ((com.tencent.mm.plugin.sns.g.b)this.oYB.getSelectedItem()).bZK;
      if ((localawd != null) && (localawd.lsK != null) && (localawd.lsK.equals(paramString)))
      {
        Toast.makeText(this.context, this.context.getString(i.j.sns_down_sight_error), 0).show();
        this.oYQ = paramString;
      }
    }
    if (this.oYA != null) {
      this.oYA.notifyDataSetChanged();
    }
  }
  
  public awd getCntMedia()
  {
    if (this.oYA != null)
    {
      int i = this.oYB.getSelectedItemPosition();
      if ((this.items != null) && (i < this.items.size())) {
        return ((com.tencent.mm.plugin.sns.g.b)this.items.get(i)).bZK;
      }
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.oYA != null) {
      return this.oYA.getCount();
    }
    return 0;
  }
  
  public List<com.tencent.mm.plugin.sns.g.b> getFlipList()
  {
    return this.items;
  }
  
  public az getFromScene()
  {
    return this.omX;
  }
  
  public Gallery getGallery()
  {
    return this.oYB;
  }
  
  public int getNumOfFileExist()
  {
    Iterator localIterator = this.items.iterator();
    int k = 0;
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (localIterator.hasNext())
      {
        com.tencent.mm.plugin.sns.g.b localb = (com.tencent.mm.plugin.sns.g.b)localIterator.next();
        af.bDC();
        j = i;
        if (e.bK(g.C(localb.bZK))) {
          j = i + 1;
        }
        k += 1;
        if (k <= 9) {}
      }
      else
      {
        return j;
      }
    }
  }
  
  public int getPosition()
  {
    return this.oYS;
  }
  
  public int getSelectCount()
  {
    return this.oZd.size();
  }
  
  public String getSelectId()
  {
    if (this.oYB == null) {
      return "";
    }
    com.tencent.mm.plugin.sns.g.b localb = (com.tencent.mm.plugin.sns.g.b)this.oYB.getSelectedItem();
    if (localb == null) {
      return "";
    }
    return localb.owP;
  }
  
  public com.tencent.mm.plugin.sns.g.b getSelectItem()
  {
    if (this.oYB == null) {
      return null;
    }
    return (com.tencent.mm.plugin.sns.g.b)this.oYB.getSelectedItem();
  }
  
  public String getSelectedMediaId()
  {
    if (this.oYB == null) {
      return null;
    }
    com.tencent.mm.plugin.sns.g.b localb = (com.tencent.mm.plugin.sns.g.b)this.oYB.getSelectedItem();
    if (localb == null) {
      return null;
    }
    return localb.bZK.lsK;
  }
  
  public long getSnsId()
  {
    Object localObject = (com.tencent.mm.plugin.sns.g.b)this.oYB.getSelectedItem();
    if (localObject == null) {
      localObject = "";
    }
    while (!bk.bl((String)localObject))
    {
      localObject = af.bDF().OB((String)localObject);
      if (localObject == null)
      {
        return 0L;
        localObject = ((com.tencent.mm.plugin.sns.g.b)localObject).owP;
      }
      else
      {
        return ((n)localObject).field_snsId;
      }
    }
    return 0L;
  }
  
  public float getWidthModHeight()
  {
    return this.oYN;
  }
  
  public int gettotalSuccDownload()
  {
    return this.oZf;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.oYZ = false;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.oYZ = true;
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected final void onPause()
  {
    super.onPause();
    if (this.oYA != null)
    {
      this.oYA.bIW();
      this.oYA.clear();
    }
  }
  
  public void setDoubleClick(boolean paramBoolean)
  {
    this.oYH = paramBoolean;
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    this.oYK = paramBoolean;
  }
  
  public void setFromScene(az paramaz)
  {
    this.omX = paramaz;
  }
  
  public void setInfoType(int paramInt)
  {
    this.infoType = paramInt;
  }
  
  public void setIsAd(boolean paramBoolean)
  {
    this.omL = paramBoolean;
  }
  
  public void setIsFromMainTimeline(boolean paramBoolean)
  {
    this.oVB = paramBoolean;
  }
  
  public void setIsSoonEnterPhotoEditUI(boolean paramBoolean)
  {
    this.oVD = paramBoolean;
  }
  
  public void setItems(List<com.tencent.mm.plugin.sns.g.b> paramList)
  {
    this.items = paramList;
  }
  
  public void setOnDeleteAllAction(Runnable paramRunnable)
  {
    this.oYP = paramRunnable;
  }
  
  public void setOnPageSelectListener(SnsInfoFlip.c paramc)
  {
    this.oZa = paramc;
  }
  
  public void setOreitaion(boolean paramBoolean) {}
  
  public void setShowLongClickMenu(boolean paramBoolean)
  {
    this.oYC = paramBoolean;
  }
  
  public void setShowPageControl(boolean paramBoolean)
  {
    this.oYG = paramBoolean;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.oYJ = paramBoolean;
  }
  
  public void setTouchFinish(boolean paramBoolean)
  {
    this.oYI = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip
 * JD-Core Version:    0.7.0.1
 */