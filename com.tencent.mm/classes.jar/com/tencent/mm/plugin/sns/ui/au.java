package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.ScaleAnimation;
import android.widget.ListView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.c.b.a;
import com.tencent.mm.plugin.sns.ui.c.d;
import com.tencent.mm.plugin.sns.ui.c.d.a;
import com.tencent.mm.plugin.sns.ui.c.e;
import com.tencent.mm.plugin.sns.ui.c.f;
import com.tencent.mm.plugin.sns.ui.c.g;
import com.tencent.mm.plugin.sns.ui.c.h;
import com.tencent.mm.plugin.sns.ui.c.h.a;
import com.tencent.mm.plugin.sns.ui.c.i.a;
import com.tencent.mm.plugin.sns.ui.c.j.b;
import com.tencent.mm.plugin.sns.ui.c.k;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class au
  implements x
{
  public MMActivity bER;
  public com.tencent.mm.ui.tools.j contextMenuHelper;
  private ListView fuF;
  com.tencent.mm.sdk.b.c giK;
  protected ah handler = new ah();
  public com.tencent.mm.ui.widget.b.a iep;
  protected HashMap<String, Integer> oOk = new HashMap();
  public View.OnTouchListener oPc;
  boolean oVB = false;
  com.tencent.mm.sdk.b.c oWH = new au.2(this);
  com.tencent.mm.sdk.b.c oWI = new au.1(this);
  com.tencent.mm.sdk.b.c oWJ = new au.3(this);
  protected ScaleAnimation oWa;
  protected ScaleAnimation oWb;
  public aq oWh;
  private int oWk = 0;
  public j oWm;
  public bf oWp;
  public com.tencent.mm.plugin.sns.ui.d.b ovx;
  protected w peb;
  public i pec;
  protected LinkedList<SnsCommentPreloadTextView> ped = new LinkedList();
  public HashMap<Integer, WeakReference<View>> pee = new HashMap();
  View pef;
  public int peg = -1;
  int peh = 0;
  protected HashMap<Integer, View> pei = new HashMap();
  public HashMap<String, String> pej = new HashMap();
  private HashMap<Integer, Class<? extends a.c>> pek = new HashMap();
  public View.OnClickListener pel;
  public View.OnClickListener pem;
  public HashMap<String, Boolean> pen;
  private au.c peo;
  protected int requestType = 0;
  
  public au(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.b paramb, i parami, w paramw)
  {
    this.pek.put(Integer.valueOf(6), i.a.class);
    this.pek.put(Integer.valueOf(2), h.a.class);
    this.pek.put(Integer.valueOf(3), h.a.class);
    this.pek.put(Integer.valueOf(4), h.a.class);
    this.pek.put(Integer.valueOf(5), h.a.class);
    this.pek.put(Integer.valueOf(0), h.a.class);
    this.pek.put(Integer.valueOf(1), h.a.class);
    this.pek.put(Integer.valueOf(7), h.a.class);
    this.pek.put(Integer.valueOf(8), h.a.class);
    this.pek.put(Integer.valueOf(9), h.a.class);
    this.pek.put(Integer.valueOf(11), j.b.class);
    this.pek.put(Integer.valueOf(13), b.a.class);
    this.pek.put(Integer.valueOf(14), d.a.class);
    this.pek.put(Integer.valueOf(10), h.a.class);
    this.pek.put(Integer.valueOf(12), h.a.class);
    this.pel = new au.4(this);
    this.pem = new au.5(this);
    this.oPc = bk.crZ();
    this.pen = new HashMap();
    this.peo = new au.c();
    this.giK = new au.9(this);
    this.peb = paramw;
    this.pec = parami;
    y.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
    this.fuF = paramListView;
    af.bDC();
    this.bER = paramMMActivity;
    this.ovx = paramb;
    this.contextMenuHelper = new com.tencent.mm.ui.tools.j(paramMMActivity);
    this.iep = new com.tencent.mm.ui.widget.b.a(paramMMActivity);
    this.oWh = new aq(paramMMActivity, (byte)0);
    this.oWa = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.oWa.setDuration(150L);
    this.oWb = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.oWb.setDuration(150L);
    this.oWm = new j(paramMMActivity, 0, parami.oNC);
    this.requestType = 10;
    this.oWp = new bf(paramMMActivity, new au.6(this, paramw), 0, parami.oNC);
    com.tencent.mm.sdk.b.a.udP.c(this.giK);
  }
  
  protected static int E(n paramn)
  {
    return b(paramn, true);
  }
  
  public static String Pq(String paramString)
  {
    if (bk.bl(paramString)) {}
    int i;
    String str;
    do
    {
      return paramString;
      i = paramString.indexOf("://");
      str = paramString;
      if (i != -1) {
        str = paramString.substring(i + 3);
      }
      i = str.indexOf("/");
      paramString = str;
    } while (i == -1);
    return str.substring(0, i);
  }
  
  public static String Pr(String paramString)
  {
    y.d("MicroMsg.SnsTimeLineBaseAdapter", "url:" + paramString);
    return com.tencent.mm.plugin.sns.c.a.eUS.u(paramString, "timeline");
  }
  
  public static String a(bxk parambxk, Context paramContext)
  {
    return com.tencent.mm.plugin.sns.c.a.eUS.f(paramContext, parambxk.tNq.lsK, "timeline");
  }
  
  protected static int b(n paramn, boolean paramBoolean)
  {
    int i = 13;
    bxk localbxk = paramn.bGe();
    if (localbxk.tNr.sPI == 1) {
      if ((paramBoolean) && (localbxk.cCu == 1)) {
        i = 12;
      }
    }
    label236:
    do
    {
      do
      {
        do
        {
          return i;
          if ((!paramn.yr(32)) || (paramn.bFZ() == null)) {
            break;
          }
        } while (paramn.bFZ().bEJ());
        if (paramn.bEK()) {
          return 14;
        }
        i = localbxk.tNr.sPJ.size();
        if (i <= 1) {
          return 2;
        }
        if (i <= 3) {
          return 3;
        }
        if (i <= 6) {
          return 4;
        }
        return 5;
        switch (localbxk.tNr.sPI)
        {
        default: 
          return 1;
        case 4: 
          return 0;
        case 5: 
          if ((!paramn.yr(32)) || (paramn.bFZ() == null)) {
            break label236;
          }
        }
      } while (paramn.bFZ().bEJ());
      if (paramn.bEK()) {
        return 14;
      }
      return 1;
      return 6;
      return 3;
      return 2;
      return 7;
      if ((paramBoolean) && (localbxk.tNy == 1)) {
        return 12;
      }
      if ((!paramn.yr(32)) || (paramn.bFZ() == null)) {
        break;
      }
    } while (paramn.bFZ().bEJ());
    if (paramn.bEK()) {
      return 14;
    }
    return 9;
    return 10;
    return 11;
  }
  
  public final void N(Runnable paramRunnable)
  {
    this.peb.bHx();
    paramRunnable.run();
  }
  
  public final void a(SnsCommentPreloadTextView paramSnsCommentPreloadTextView)
  {
    this.ped.add(paramSnsCommentPreloadTextView);
  }
  
  public final void bJp()
  {
    this.oOk.clear();
  }
  
  public final t bJq()
  {
    if ((this.bER instanceof t)) {
      return (t)this.bER;
    }
    return null;
  }
  
  public final SnsCommentPreloadTextView bJr()
  {
    if (this.ped.size() == 0) {
      return new SnsCommentPreloadTextView(this.bER);
    }
    return (SnsCommentPreloadTextView)this.ped.removeFirst();
  }
  
  public final boolean bJs()
  {
    if (this.ped != null) {
      this.ped.clear();
    }
    if (this.pek != null) {
      this.pek.clear();
    }
    com.tencent.mm.pluginsdk.ui.d.j.clearCache();
    com.tencent.mm.kiss.widget.textview.c.dNE.EE();
    return true;
  }
  
  public final void bJt()
  {
    this.peb.bHx();
  }
  
  public final void bJu()
  {
    int i = this.fuF.getFirstVisiblePosition() - this.fuF.getHeaderViewsCount();
    int j = this.fuF.getLastVisiblePosition() - this.fuF.getHeaderViewsCount();
    y.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + i + " " + j);
    int k = this.peb.getCount();
    if ((i <= j) && (i < k))
    {
      n localn = yy(i);
      Object localObject = (View)this.pei.get(Integer.valueOf(i));
      if ((localObject == null) || (localn == null) || (((View)localObject).getTag() == null)) {
        y.e("MicroMsg.SnsTimeLineBaseAdapter", " passe " + i);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = (a.c)((View)localObject).getTag();
        y.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + ((a.c)localObject).position);
        ((a.c)localObject).pnA.a((a.c)localObject, i, localn);
      }
    }
  }
  
  public final w bJv()
  {
    return this.peb;
  }
  
  public final void da(View paramView)
  {
    if (!(paramView.getTag() instanceof a.c)) {}
    do
    {
      return;
      y.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
    } while ((this.pef == null) || (this.pef.getVisibility() != 0));
    this.pef.startAnimation(this.oWb);
    this.oWb.setAnimationListener(new au.8(this));
  }
  
  public final View g(int paramInt, View paramView)
  {
    n localn = this.peb.yy(paramInt);
    bxk localbxk = localn.bGe();
    int j = b(localn, true);
    Object localObject1 = null;
    localObject3 = null;
    Object localObject4 = localObject1;
    Object localObject2 = localObject3;
    int i;
    if (paramView != null)
    {
      localObject2 = paramView.getTag(i.f.sns_item_root);
      if (!(localObject2 instanceof Integer)) {
        break label414;
      }
      i = ((Integer)localObject2).intValue();
      localObject4 = localObject1;
      localObject2 = localObject3;
      if (i == j)
      {
        localObject2 = (a.c)paramView.getTag();
        localObject4 = ((a.c)localObject2).pnA;
      }
    }
    localObject1 = localObject2;
    localObject3 = paramView;
    if (localObject2 == null) {
      switch (j)
      {
      default: 
        localObject1 = new g();
      }
    }
    for (;;)
    {
      for (;;)
      {
        Iterator localIterator;
        Object localObject6;
        label414:
        try
        {
          if (this.pek.get(Integer.valueOf(j)) != null)
          {
            localObject3 = (a.c)((Class)this.pek.get(Integer.valueOf(j))).newInstance();
            localObject2 = localObject3;
            localObject3 = paramView;
          }
        }
        catch (Exception localException1) {}
        try
        {
          ((a.c)localObject2).pnA = ((com.tencent.mm.plugin.sns.ui.c.a)localObject1);
          localObject3 = paramView;
          ((a.c)localObject2).plP = localbxk;
          localObject3 = paramView;
          paramView = ((com.tencent.mm.plugin.sns.ui.c.a)localObject1).a(this.bER, (a.c)localObject2, j, this, localn);
          localObject3 = paramView;
          paramView.setTag(i.f.sns_item_root, Integer.valueOf(j));
          localObject4 = localObject1;
          localObject3 = paramView;
          localObject1 = localObject2;
          ((com.tencent.mm.plugin.sns.ui.c.a)localObject4).setIsFromMainTimeline(this.oVB);
          paramView = localn.bGk();
          localObject2 = new ArrayList();
          if (ap.bEi().size() <= 0) {
            break label645;
          }
          localIterator = ap.bEi().keySet().iterator();
          if (!localIterator.hasNext()) {
            break label645;
          }
          localObject6 = (String)localIterator.next();
          if (((String)localObject6).startsWith(paramView))
          {
            localObject6 = (ap.b)ap.bEi().get(localObject6);
            if (ap.c((ap.b)localObject6))
            {
              ((ArrayList)localObject2).add(localObject6);
              continue;
              i = -1;
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject5;
            paramView = (View)localObject3;
          }
        }
      }
      localObject1 = new com.tencent.mm.plugin.sns.ui.c.i();
      continue;
      localObject1 = new h();
      continue;
      localObject1 = new h();
      continue;
      localObject1 = new h();
      continue;
      localObject1 = new h();
      continue;
      localObject1 = new f();
      continue;
      localObject1 = new g();
      continue;
      localObject1 = new g();
      continue;
      localObject1 = new g();
      continue;
      localObject1 = new k();
      continue;
      localObject1 = new e();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.c.j();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.c.c();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.c.b();
      continue;
      localObject1 = new d();
      continue;
      localObject3 = new h.a();
      localObject2 = localObject3;
      continue;
      y.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", localException1, "create holder error", new Object[0]);
      localObject5 = localObject1;
      localObject1 = localObject2;
      localObject3 = paramView;
    }
    label645:
    ((com.tencent.mm.plugin.sns.ui.c.a)localObject5).pmy = ((ArrayList)localObject2);
    ((com.tencent.mm.plugin.sns.ui.c.a)localObject5).a((a.c)localObject1, paramInt, localn, localbxk, j, this);
    if (ap.cr(localn.bGk(), 2))
    {
      paramView = ap.NJ(localn.bGk());
      if (localn.field_snsId == 0L) {
        paramView = new ap.b();
      }
      if (paramView.dYj) {
        if (!paramView.ebE)
        {
          localObject2 = paramView.result;
          localObject5 = paramView.egI;
          if ((localObject1 != null) && (((a.c)localObject1).pmG != null))
          {
            ((a.c)localObject1).pmG.a(paramView, 1, (String)localObject2, (String)localObject5, paramView.otH);
            ((a.c)localObject1).pmG.setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      this.pei.put(Integer.valueOf(paramInt), localObject3);
      return localObject3;
      com.tencent.mm.plugin.sns.ui.c.a.e((a.c)localObject1);
      ap.cq(paramView.id, 2);
      continue;
      if ((localObject1 != null) && (((a.c)localObject1).pmG != null))
      {
        ((a.c)localObject1).pmG.yV(1);
        ((a.c)localObject1).pmG.setVisibility(0);
        continue;
        com.tencent.mm.plugin.sns.ui.c.a.e((a.c)localObject1);
      }
    }
  }
  
  public final int getCount()
  {
    return this.peb.getCount();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return b(this.peb.yy(paramInt), true);
  }
  
  public final void notifyDataSetChanged()
  {
    this.peb.notifyDataSetChanged();
  }
  
  public final n yy(int paramInt)
  {
    return this.peb.yy(paramInt);
  }
  
  public final boolean yz(int paramInt)
  {
    return (paramInt >= this.fuF.getFirstVisiblePosition() - 1) && (paramInt <= this.fuF.getLastVisiblePosition() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au
 * JD-Core Version:    0.7.0.1
 */