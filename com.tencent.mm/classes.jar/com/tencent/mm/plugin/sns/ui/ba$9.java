package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ch.d;
import com.tencent.mm.h.a.si;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.s;

final class ba$9
  implements AbsListView.OnScrollListener
{
  ba$9(ba paramba) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    System.currentTimeMillis();
    this.piF.pip = (paramInt1 + paramInt2 - 1);
    if ((this.piF.lwE.getLastVisiblePosition() == this.piF.lwE.getCount() - 1) && (this.piF.lwE.getCount() != ba.f(this.piF)))
    {
      y.d("MicroMsg.SnsActivity", "now refresh count: %s", new Object[] { Integer.valueOf(this.piF.lwE.getCount()) });
      ba.a(this.piF, this.piF.lwE.getCount());
      ba.g(this.piF);
    }
    if (paramAbsListView.getChildCount() == 0) {
      return;
    }
    int j = com.tencent.mm.cb.a.fromDPToPix(ba.a(this.piF), 20);
    com.tencent.mm.cb.a.fromDPToPix(ba.a(this.piF), 100);
    paramInt2 = 0;
    float f1 = 1.0F;
    float f2 = 1.0F;
    ap.ab(ba.a(this.piF), i.d.DefaultActionbarHeightPort);
    ap.ab(ba.a(this.piF), i.d.SmallActionbarHeight);
    paramInt3 = 0;
    int i;
    int k;
    int m;
    label280:
    Object localObject;
    label326:
    int n;
    label437:
    float f3;
    if ((ba.a(this.piF) instanceof SnsTimeLineUI))
    {
      paramInt3 = com.tencent.mm.cb.a.fromDPToPix(ba.a(this.piF), 245);
      i = ((SnsTimeLineUI)ba.a(this.piF)).mController.aTI;
      k = paramInt3 - com.tencent.mm.cb.a.fromDPToPix(ba.a(this.piF), 30);
      m = paramInt3 - com.tencent.mm.cb.a.fromDPToPix(ba.a(this.piF), 10);
      paramAbsListView = paramAbsListView.getChildAt(0);
      if (paramAbsListView != null) {
        break label835;
      }
      i = 0;
      if (paramInt1 <= ba.h(this.piF)) {
        break label844;
      }
      this.piF.piA = ba.ave();
      if (paramAbsListView != null)
      {
        localObject = this.piF;
        ((ba)localObject).jsr += paramAbsListView.getHeight();
      }
      this.piF.piC = (-i + this.piF.jsr);
      ba.b(this.piF, paramInt1);
      ba.c(this.piF, i);
      if (this.piF.piB != this.piF.piA)
      {
        this.piF.start = this.piF.piC;
        this.piF.piD = false;
      }
      if (paramInt1 != 0) {
        break label1094;
      }
      n = -paramAbsListView.getTop();
      this.piF.piC = n;
      if ((n < 0) || (n > k)) {
        break label970;
      }
      f1 = 1.0F;
      if ((n < 0) || (n > paramInt3)) {
        break label1024;
      }
      paramInt2 = 0;
      f2 = 0.0F;
      f3 = f1;
      label458:
      if (this.piF.hoY != null)
      {
        y.d("MicroMsg.SnsActivity", "dancy text totalScrollY:%s, top:%s, viewHeight:%s ", new Object[] { Integer.valueOf(this.piF.piC), Integer.valueOf(i), Integer.valueOf(this.piF.jsr) });
        if (this.piF.piC <= paramInt3) {
          break label1104;
        }
        this.piF.hoY.setVisibility(8);
      }
      label537:
      this.piF.pix = this.piF.piC;
      this.piF.piB = this.piF.piA;
      if (!(ba.a(this.piF) instanceof SnsTimeLineUI)) {
        break label1118;
      }
      paramAbsListView = (SnsTimeLineUI)ba.a(this.piF);
    }
    for (;;)
    {
      label589:
      if (paramAbsListView != null)
      {
        if (this.piF.lZB != paramInt2)
        {
          if (paramInt2 > 0) {
            break label1145;
          }
          paramAbsListView.ta(ba.a(this.piF).getResources().getColor(i.c.transparent));
        }
        label628:
        ba.c(this.piF).ea(paramInt1, paramInt2);
        if (this.piF.piz != f2)
        {
          localObject = paramAbsListView.mController;
          if (((s)localObject).uMS != null) {
            ((s)localObject).uMS.setAlpha(f2);
          }
        }
        if (this.piF.piy != f3)
        {
          paramAbsListView = paramAbsListView.mController;
          if (paramAbsListView.uMU != null)
          {
            paramAbsListView.uMU.setAlpha(f3);
            if (f3 != 0.0F) {
              break label1176;
            }
            paramAbsListView.uMU.setEnabled(false);
          }
          label728:
          if (paramAbsListView.uGM != null)
          {
            paramAbsListView.uGM.setAlpha(f3);
            if (f3 != 0.0F) {
              break label1187;
            }
            paramAbsListView.uGM.setEnabled(false);
          }
        }
      }
      for (;;)
      {
        this.piF.lZB = paramInt2;
        this.piF.piy = f3;
        this.piF.piz = f2;
        return;
        if (!(ba.a(this.piF) instanceof SnsUserUI)) {
          break;
        }
        paramInt3 = com.tencent.mm.cb.a.fromDPToPix(ba.a(this.piF), 199);
        i = ((SnsUserUI)ba.a(this.piF)).mController.aTI;
        break;
        label835:
        i = paramAbsListView.getTop();
        break label280;
        label844:
        if (paramInt1 < ba.h(this.piF))
        {
          this.piF.piA = ba.Tc();
          if (this.piF.jsr < paramAbsListView.getHeight()) {
            break label326;
          }
          localObject = this.piF;
          ((ba)localObject).jsr -= paramAbsListView.getHeight();
          break label326;
        }
        if (Math.abs(i - ba.i(this.piF)) <= 1) {
          break label326;
        }
        if (i < ba.i(this.piF))
        {
          this.piF.piA = ba.ave();
          break label326;
        }
        if (i <= ba.i(this.piF)) {
          break label326;
        }
        this.piF.piA = ba.Tc();
        break label326;
        label970:
        if (n <= m)
        {
          f1 = 1.0F - (n - k) / (m - k);
          break label437;
        }
        if (n > paramInt3 + j) {
          break label437;
        }
        f1 = (n - paramInt3) * 1.0F / j;
        break label437;
        label1024:
        if (n <= paramInt3 + j)
        {
          paramInt2 = (n - paramInt3) * 100 / j;
          f2 = (n - paramInt3) * 1.0F / j;
          f3 = f1;
          break label458;
        }
        f3 = f1;
        if (n <= j + paramInt3) {
          break label458;
        }
        paramInt2 = 100;
        f2 = 1.0F;
        f3 = f1;
        break label458;
        label1094:
        paramInt2 = 100;
        f3 = f1;
        break label458;
        label1104:
        this.piF.hoY.setVisibility(0);
        break label537;
        label1118:
        if (!(ba.a(this.piF) instanceof SnsUserUI)) {
          break label1198;
        }
        paramAbsListView = (SnsUserUI)ba.a(this.piF);
        break label589;
        label1145:
        paramInt3 = i.c.normal_actionbar_color;
        paramAbsListView.ta(an.fm(ba.a(this.piF).getResources().getColor(paramInt3), paramInt2));
        break label628;
        label1176:
        paramAbsListView.uMU.setEnabled(true);
        break label728;
        label1187:
        paramAbsListView.uGM.setEnabled(true);
      }
      label1198:
      paramAbsListView = null;
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    ba.c(this.piF).yP(paramInt);
    if (paramInt == 0)
    {
      paramAbsListView = new si();
      paramAbsListView.cbT.type = 5;
      paramAbsListView.cbT.cbU = this.piF.lwE.getFirstVisiblePosition();
      paramAbsListView.cbT.cbV = this.piF.lwE.getLastVisiblePosition();
      paramAbsListView.cbT.cbW = this.piF.lwE.getHeaderViewsCount();
      com.tencent.mm.sdk.b.a.udP.m(paramAbsListView);
      if (((ba.a(this.piF) instanceof SnsTimeLineUI)) && (((SnsTimeLineUI)ba.a(this.piF)).oWw != null)) {
        ((SnsTimeLineUI)ba.a(this.piF)).oWw.bCe();
      }
    }
    if (paramInt == 2)
    {
      d.cxA().dA(ba.class.getName() + ba.c(this.piF).getType() + ".Listview", 4);
      this.piF.jA(true);
      return;
    }
    this.piF.jA(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba.9
 * JD-Core Version:    0.7.0.1
 */