package com.tencent.mm.plugin.sns.ui;

import android.os.Handler;
import android.os.Process;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.sns.h.a.a;
import com.tencent.mm.plugin.sns.h.a.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.j.b.a;
import com.tencent.mm.plugin.sns.j.b.b;
import com.tencent.mm.plugin.sns.j.c.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.vending.g.f;
import java.util.LinkedList;
import java.util.List;

final class SnsTimeLineUI$19
  implements ba.a
{
  private int pfG = 0;
  private int pfH = 0;
  
  SnsTimeLineUI$19(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void W(int paramInt, boolean paramBoolean)
  {
    if (SnsTimeLineUI.a(this.pfC) != null) {
      SnsTimeLineUI.a(this.pfC).pgx.notifyVendingDataChange();
    }
    if (!paramBoolean) {
      this.pfC.EB().ae(c.b.class);
    }
  }
  
  public final void a(int paramInt, List<Integer> paramList1, List<Integer> paramList2)
  {
    int j = 1;
    int i = j;
    if (paramInt > 0)
    {
      paramList1 = af.bDF().yt(paramInt);
      i = j;
      if (paramList1 != null)
      {
        if (paramList1.field_pravited > 0) {
          Toast.makeText(this.pfC, i.j.sns_has_save, 1).show();
        }
        i = j;
        if (paramList1.field_pravited == 1) {
          i = 0;
        }
      }
    }
    if (i != 0) {
      BackwardSupportUtil.c.a(SnsTimeLineUI.h(this.pfC).lwE);
    }
    if (SnsTimeLineUI.a(this.pfC) != null) {
      SnsTimeLineUI.a(this.pfC).pgx.notifyVendingDataChange();
    }
  }
  
  public final void bJA()
  {
    SnsTimeLineUI.k(this.pfC).prx.b(SnsTimeLineUI.r(this.pfC), SnsTimeLineUI.i(this.pfC), false, SnsTimeLineUI.s(this.pfC));
    y.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
    if (SnsTimeLineUI.t(this.pfC) == null) {
      y.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
    }
    while (SnsTimeLineUI.g(this.pfC) == null) {
      return;
    }
    SnsTimeLineUI.t(this.pfC).removeCallbacks(SnsTimeLineUI.u(this.pfC));
    SnsTimeLineUI.t(this.pfC).postDelayed(SnsTimeLineUI.u(this.pfC), 3000L);
  }
  
  public final ListView bJB()
  {
    if (SnsTimeLineUI.g(this.pfC).lwE == null) {
      SnsTimeLineUI.g(this.pfC).lwE = ((ListView)this.pfC.findViewById(i.f.sns_photo_list));
    }
    return SnsTimeLineUI.g(this.pfC).lwE;
  }
  
  public final View bJC()
  {
    if (SnsTimeLineUI.g(this.pfC).ovy == null) {
      SnsTimeLineUI.g(this.pfC).ovy = ((FrameLayout)this.pfC.findViewById(i.f.timeline_root));
    }
    return SnsTimeLineUI.g(this.pfC).ovy;
  }
  
  public final View bJD()
  {
    return this.pfC.findViewById(i.f.sns_cover_shadow);
  }
  
  public final MMPullDownView bJE()
  {
    return (MMPullDownView)this.pfC.findViewById(i.f.sns_pull_down_view);
  }
  
  public final boolean bJF()
  {
    return SnsTimeLineUI.v(this.pfC);
  }
  
  public final void bJG()
  {
    this.pfC.bHw();
    if (SnsTimeLineUI.m(this.pfC) != null)
    {
      y.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
      SnsTimeLineUI.m(this.pfC).setVisibility(0);
    }
    SnsTimeLineUI.k(this.pfC).prw.b(SnsTimeLineUI.r(this.pfC), SnsTimeLineUI.i(this.pfC), SnsTimeLineUI.j(this.pfC), SnsTimeLineUI.s(this.pfC));
  }
  
  public final void bJH()
  {
    this.pfC.bHw();
  }
  
  public final void ea(int paramInt1, int paramInt2) {}
  
  public final int getType()
  {
    return 1;
  }
  
  public final void jA(boolean paramBoolean)
  {
    SnsTimeLineUI localSnsTimeLineUI = this.pfC;
    localSnsTimeLineUI.pfn = paramBoolean;
    ah localah = af.aXq();
    g localg = af.bDC();
    com.tencent.mm.plugin.sns.model.b localb = af.bDA();
    if (paramBoolean) {
      if ((localg.ooI) || (localb.ooI))
      {
        localah.removeCallbacks(localSnsTimeLineUI.pfo);
        localah.removeCallbacks(localSnsTimeLineUI.pfp);
        localah.postDelayed(localSnsTimeLineUI.pfo, 0L);
      }
    }
    while ((localg.ooI) && (localb.ooI)) {
      return;
    }
    localah.removeCallbacks(localSnsTimeLineUI.pfo);
    localah.removeCallbacks(localSnsTimeLineUI.pfp);
    localah.postDelayed(localSnsTimeLineUI.pfp, 0L);
  }
  
  public final void yP(int paramInt)
  {
    int i = SnsTimeLineUI.h(this.pfC).lwE.getFirstVisiblePosition();
    int j = SnsTimeLineUI.h(this.pfC).lwE.getLastVisiblePosition();
    if ((i == this.pfG) && (j == this.pfH)) {
      return;
    }
    this.pfG = i;
    this.pfH = j;
    y.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) });
    Object localObject1;
    boolean bool;
    int k;
    com.tencent.mm.plugin.sns.h.a locala;
    au localau;
    if (paramInt == 2)
    {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcSNSScrollEnable, SnsTimeLineUI.w(this.pfC));
      localObject1 = this.pfC;
      bool = WXHardCoderJNI.hcSNSScrollEnable;
      i = WXHardCoderJNI.hcSNSScrollDelay;
      j = WXHardCoderJNI.hcSNSScrollCPU;
      k = WXHardCoderJNI.hcSNSScrollIO;
      if (WXHardCoderJNI.hcSNSScrollThr)
      {
        paramInt = Process.myTid();
        SnsTimeLineUI.c((SnsTimeLineUI)localObject1, WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt, WXHardCoderJNI.hcSNSScrollTimeout, 701, WXHardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI"));
        y.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsTimeLineUI.w(this.pfC)) });
      }
    }
    else
    {
      locala = SnsTimeLineUI.f(this.pfC);
      localau = SnsTimeLineUI.a(this.pfC).pgw;
      paramInt = com.tencent.mm.modelsns.c.eAT;
      if (paramInt != 2) {
        break label251;
      }
      localObject1 = null;
    }
    label471:
    for (;;)
    {
      f.cLb().d(new SnsTimeLineUI.19.1(this, (a.a)localObject1));
      return;
      paramInt = 0;
      break;
      label251:
      if ((paramInt == 4) && (!locala.oxh))
      {
        localObject1 = null;
      }
      else
      {
        long l = System.nanoTime();
        localObject1 = new a.a();
        ((a.a)localObject1).oxi = System.currentTimeMillis();
        ((a.a)localObject1).mScreenHeight = locala.mScreenHeight;
        ((a.a)localObject1).mScreenWidth = locala.mScreenWidth;
        j = locala.oxg.getTop();
        i = locala.oxg.getHeight();
        paramInt = i;
        if (j < 0) {
          paramInt = i + j;
        }
        ((a.a)localObject1).oxk = paramInt;
        i = locala.fuF.getFirstVisiblePosition() - 1;
        k = locala.fuF.getLastVisiblePosition() - 1;
        ((a.a)localObject1).oxj = i;
        ((a.a)localObject1).UL = k;
        int m = localau.getCount();
        bool = false;
        if (locala.fuF.getChildAt(0) != null) {
          bool = locala.fuF.getChildAt(0) instanceof SnsHeader;
        }
        y.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Boolean.valueOf(bool) });
        if (bool)
        {
          paramInt = 1;
          int n = locala.fuF.getChildCount();
          if (i > k) {
            break label975;
          }
          j = paramInt;
          if (i < m)
          {
            j = paramInt;
            if (i >= 0)
            {
              if (paramInt < n) {
                break label541;
              }
              y.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(n) });
              j = paramInt;
            }
          }
        }
        for (;;)
        {
          i += 1;
          paramInt = j;
          break label471;
          paramInt = 0;
          break;
          if (((a.a)localObject1).oxl == null) {
            ((a.a)localObject1).oxl = new LinkedList();
          }
          a.b localb = new a.b();
          ((a.a)localObject1).oxl.add(localb);
          Object localObject2 = locala.fuF.getChildAt(paramInt);
          j = paramInt + 1;
          int i1;
          int i2;
          int i3;
          if (localObject2 != null)
          {
            paramInt = ((View)localObject2).getTop();
            i1 = ((View)localObject2).getLeft();
            i2 = ((View)localObject2).getHeight();
            i3 = ((View)localObject2).getWidth();
            n localn = localau.yy(i);
            localb.oxq = com.tencent.mm.plugin.sns.data.i.j(localn);
            localb.oxo = localn.field_type;
            localb.oxp = localn.yr(32);
            localb.oxm = paramInt;
            localb.oxn = i1;
            localb.aqG = i2;
            localb.aqF = i3;
          }
          if ((localObject2 != null) && (((View)localObject2).getTag() != null) && ((((View)localObject2).getTag() instanceof a.c)))
          {
            localObject2 = (a.c)((View)localObject2).getTag();
            if ((((a.c)localObject2).pnc) && (((a.c)localObject2).oMK != null))
            {
              paramInt = ((a.c)localObject2).oMK.getTop();
              i1 = ((a.c)localObject2).oMK.getLeft();
              i2 = ((a.c)localObject2).pmU.getHeight();
              i3 = ((a.c)localObject2).pmU.getWidth();
              int i4 = ((a.c)localObject2).pmV.getTop();
              int i5 = ((a.c)localObject2).pmV.getLeft();
              int i6 = ((a.c)localObject2).pmV.getHeight();
              int i7 = ((a.c)localObject2).pmV.getWidth();
              y.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[] { Integer.valueOf(((a.c)localObject2).position), Integer.valueOf(i), Integer.valueOf(j) });
              if (((a.c)localObject2).okd.tJW != 0)
              {
                localb.oxs = ((a.c)localObject2).okd.tJW;
                localb.oxt = paramInt;
                localb.oxu = i1;
                localb.oxv = i3;
                localb.oxw = i2;
              }
              if (((a.c)localObject2).okd.tJZ != 0)
              {
                localb.oxr = ((a.c)localObject2).okd.tJZ;
                localb.oxy = (i5 + i1);
                localb.oxx = (i4 + paramInt);
                localb.oxz = i7;
                localb.oxA = i6;
              }
            }
          }
        }
        y.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - l));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.19
 * JD-Core Version:    0.7.0.1
 */