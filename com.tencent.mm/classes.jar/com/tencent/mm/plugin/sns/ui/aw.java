package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending.a;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public final class aw
  extends BaseAdapter
  implements w
{
  private static HashMap<Long, aw.a> pgA = new HashMap();
  private boolean dJO = false;
  au pgw = new au(paramMMActivity, paramListView, paramb, parami, this);
  public av pgx;
  boolean pgy;
  Vending.a pgz = new aw.1(this);
  
  public aw(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.b paramb, i parami, String paramString)
  {
    this.pgw.oVB = true;
    this.pgx = new av();
    paramListView = this.pgx;
    paramb = this.pgw;
    paramListView.mContext = paramMMActivity;
    paramListView.pgm = paramb;
    paramListView.peN = paramString;
    com.tencent.mm.kernel.g.DQ();
    paramListView.dXx = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw();
    paramMMActivity = this.pgx;
    a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[] { Integer.valueOf(10) });
    paramMMActivity.a = 10;
    this.pgx.addVendingDataChangedCallback(this.pgz);
  }
  
  public static void F(n paramn)
  {
    long l1;
    aw.a locala;
    if (paramn != null)
    {
      l1 = paramn.field_snsId;
      if (!pgA.containsKey(Long.valueOf(l1)))
      {
        locala = new aw.a();
        if ((paramn.bGe() != null) && (paramn.bGe().tNr != null) && (paramn.bGe().tNr.sPI == 1) && (paramn.bGe().tNr.sPJ != null) && (paramn.bGe().tNr.sPJ.size() > 0))
        {
          locala.dTT = paramn.bGe().tNr.sPJ.size();
          locala.pgC = new HashSet();
          locala.pgD = new HashSet();
          locala.pgE = new HashSet();
          locala.pgF = new HashSet();
          locala.id = paramn.bGe().lsK;
          locala.pgK = paramn.bGe().cCu;
        }
      }
    }
    try
    {
      bto localbto = aj.q(paramn);
      locala.pgI = localbto.tJW;
      locala.pgJ = localbto.tJZ;
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          com.tencent.mm.kernel.g.DQ();
          locala.kzq = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HP(paramn.field_userName);
          long l2 = System.currentTimeMillis();
          com.tencent.mm.kernel.g.DQ();
          locala.pgH = ((l2 - ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HV(paramn.field_userName)) / 1000L);
          pgA.put(Long.valueOf(l1), locala);
          return;
          localException = localException;
          locala.pgI = 0;
          locala.pgJ = 0;
        }
      }
      catch (Exception paramn)
      {
        for (;;)
        {
          locala.kzq = 0;
          locala.pgH = 0L;
        }
      }
    }
  }
  
  public static void b(n paramn, int paramInt)
  {
    if (paramn != null)
    {
      long l = paramn.field_snsId;
      if (pgA.containsKey(Long.valueOf(l)))
      {
        paramn = (aw.a)pgA.get(Long.valueOf(l));
        if (paramn.pgG == 0) {
          paramn.pgG = (paramInt + 1);
        }
        if (paramn.pgC == null) {
          paramn.pgC = new HashSet();
        }
        paramn.pgC.add(Integer.valueOf(paramInt + 1));
      }
    }
  }
  
  public static void bJO()
  {
    Iterator localIterator = pgA.entrySet().iterator();
    while (localIterator.hasNext())
    {
      aw.a locala = (aw.a)((Map.Entry)localIterator.next()).getValue();
      locala.networkType = com.tencent.mm.plugin.sns.data.i.bCs();
      y.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[] { Integer.valueOf(locala.dTT), Integer.valueOf(locala.pgC.size()), Integer.valueOf(locala.pgG), Integer.valueOf(locala.networkType), locala.id });
      Object localObject1 = locala.pgD.iterator();
      for (String str = ""; ((Iterator)localObject1).hasNext(); str = str + localObject2 + "|") {
        localObject2 = (Integer)((Iterator)localObject1).next();
      }
      localObject1 = str;
      if (str.length() >= 2) {
        localObject1 = str.substring(0, str.length() - 1);
      }
      Object localObject2 = locala.pgE.iterator();
      for (str = ""; ((Iterator)localObject2).hasNext(); str = str + localObject3 + "|") {
        localObject3 = (Integer)((Iterator)localObject2).next();
      }
      localObject2 = str;
      if (str.length() >= 2) {
        localObject2 = str.substring(0, str.length() - 1);
      }
      Object localObject3 = locala.pgF.iterator();
      Integer localInteger;
      for (str = ""; ((Iterator)localObject3).hasNext(); str = str + localInteger + "|") {
        localInteger = (Integer)((Iterator)localObject3).next();
      }
      localObject3 = str;
      if (str.length() >= 2) {
        localObject3 = str.substring(0, str.length() - 1);
      }
      h.nFQ.f(11599, new Object[] { Integer.valueOf(locala.dTT), Integer.valueOf(locala.pgC.size()), Integer.valueOf(locala.pgG), Integer.valueOf(locala.networkType), Integer.valueOf(0), locala.id, Long.valueOf(locala.pgH), Integer.valueOf(locala.kzq), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.pgI), Integer.valueOf(locala.pgJ), Integer.valueOf(0), localObject1, localObject2, localObject3, Integer.valueOf(0), "", Integer.valueOf(locala.pgK) });
    }
    pgA.clear();
  }
  
  public static void c(n paramn, int paramInt)
  {
    if (paramn != null)
    {
      long l = paramn.field_snsId;
      if (pgA.containsKey(Long.valueOf(l)))
      {
        paramn = (aw.a)pgA.get(Long.valueOf(l));
        if (paramn.pgD == null) {
          paramn.pgD = new HashSet();
        }
        if (!paramn.pgD.contains(Integer.valueOf(paramInt + 1))) {
          paramn.pgD.add(Integer.valueOf(paramInt + 1));
        }
      }
    }
  }
  
  public static void d(n paramn, int paramInt)
  {
    if (paramn != null)
    {
      long l = paramn.field_snsId;
      if (pgA.containsKey(Long.valueOf(l)))
      {
        paramn = (aw.a)pgA.get(Long.valueOf(l));
        if (paramn.pgE == null) {
          paramn.pgE = new HashSet();
        }
        if (!paramn.pgE.contains(Integer.valueOf(paramInt + 1))) {
          paramn.pgE.add(Integer.valueOf(paramInt + 1));
        }
      }
    }
  }
  
  public static void e(n paramn, int paramInt)
  {
    if (paramn != null)
    {
      long l = paramn.field_snsId;
      if (pgA.containsKey(Long.valueOf(l)))
      {
        paramn = (aw.a)pgA.get(Long.valueOf(l));
        if (paramn.pgF == null) {
          paramn.pgF = new HashSet();
        }
        if (!paramn.pgF.contains(Integer.valueOf(paramInt + 1))) {
          paramn.pgF.add(Integer.valueOf(paramInt + 1));
        }
      }
    }
  }
  
  public final void bHx()
  {
    this.pgx.notifyVendingDataChange();
  }
  
  public final int getCount()
  {
    return this.pgx.c;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return this.pgw.getItemViewType(paramInt);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.pgw.g(paramInt, paramView);
  }
  
  public final int getViewTypeCount()
  {
    return 15;
  }
  
  public final void mT()
  {
    if (this.dJO) {
      return;
    }
    this.dJO = true;
    this.pgx.notifyVendingDataChangeSynchronize();
  }
  
  public final n yy(int paramInt)
  {
    ax localax = (ax)this.pgx.get(paramInt);
    if (localax == null) {
      return null;
    }
    return localax.oje;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aw
 * JD-Core Version:    0.7.0.1
 */