package com.tencent.mm.plugin.sns.ui;

import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.i.a.a;
import com.tencent.mm.plugin.sns.k.c.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.vending.g.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class SnsTimeLineUI$22
  implements SnsUIAction.a
{
  private int rYE = 0;
  private int rYF = 0;
  
  SnsTimeLineUI$22(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void EY(int paramInt)
  {
    AppMethodBeat.i(145582);
    int j = SnsTimeLineUI.l(this.rYv).list.getFirstVisiblePosition();
    int k = SnsTimeLineUI.l(this.rYv).list.getLastVisiblePosition();
    if ((paramInt == 0) && (SnsTimeLineUI.a(this.rYv) != null)) {
      SnsTimeLineUI.a(this.rYv, j, k);
    }
    if ((j == this.rYE) && (k == this.rYF))
    {
      AppMethodBeat.o(145582);
      return;
    }
    this.rYE = j;
    this.rYF = k;
    ab.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt) });
    Object localObject1;
    boolean bool;
    int m;
    int n;
    int i1;
    if (paramInt == 2)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSScrollEnable, SnsTimeLineUI.D(this.rYv));
      localObject1 = this.rYv;
      bool = WXHardCoderJNI.hcSNSScrollEnable;
      m = WXHardCoderJNI.hcSNSScrollDelay;
      n = WXHardCoderJNI.hcSNSScrollCPU;
      i1 = WXHardCoderJNI.hcSNSScrollIO;
      if (!WXHardCoderJNI.hcSNSScrollThr) {
        break label514;
      }
    }
    LinkedList localLinkedList;
    label514:
    for (int i = Process.myTid();; i = 0)
    {
      SnsTimeLineUI.d((SnsTimeLineUI)localObject1, WXHardCoderJNI.startPerformance(bool, m, n, i1, i, WXHardCoderJNI.hcSNSScrollTimeout, 701, WXHardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI"));
      ab.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsTimeLineUI.D(this.rYv)) });
      if ((paramInt != 0) || (SnsTimeLineUI.a(this.rYv) == null)) {
        break label535;
      }
      localObject1 = SnsTimeLineUI.a(this.rYv);
      if (k < j) {
        break label535;
      }
      localLinkedList = new LinkedList();
      paramInt = j;
      while (paramInt <= k)
      {
        Object localObject2 = ((com.tencent.mm.plugin.sns.ui.a.c)localObject1).EE(paramInt);
        if (localObject2 != null)
        {
          localObject2 = ((n)localObject2).csh();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((TimeLineObject)localObject2).xTS.Url)) && (((TimeLineObject)localObject2).xTS.Url.contains("mp.weixin.qq.com")) && (((TimeLineObject)localObject2).xTS.wNZ == 3))
          {
            i = -1;
            if (((TimeLineObject)localObject2).xTS.wOd != null) {
              i = ((TimeLineObject)localObject2).xTS.wOd.wqp;
            }
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(((TimeLineObject)localObject2).xTS.Url);
            localArrayList.add(String.valueOf(i));
            localArrayList.add(String.valueOf(((TimeLineObject)localObject2).Id));
            localArrayList.add("");
            localArrayList.add("");
            localArrayList.add(((TimeLineObject)localObject2).jJA);
            localArrayList.add(String.valueOf(((TimeLineObject)localObject2).CreateTime));
            localArrayList.add(String.valueOf(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).GK("__sns_timeline__")));
            localLinkedList.add(localArrayList);
          }
        }
        paramInt += 1;
      }
    }
    ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).i(localLinkedList, 2);
    label535:
    if (SnsTimeLineUI.a(this.rYv) != null)
    {
      localObject1 = SnsTimeLineUI.h(this.rYv).a(SnsTimeLineUI.a(this.rYv).sdr);
      f.dQr().d(new SnsTimeLineUI.22.1(this, (a.a)localObject1));
    }
    AppMethodBeat.o(145582);
  }
  
  public final void af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(145583);
    if (SnsTimeLineUI.a(this.rYv) != null) {
      SnsTimeLineUI.a(this.rYv).sds.notifyVendingDataChange();
    }
    if (!paramBoolean) {
      this.rYv.SF().az(c.b.class);
    }
    AppMethodBeat.o(145583);
  }
  
  public final void b(int paramInt, List<Integer> paramList1, List<Integer> paramList2)
  {
    int j = 1;
    AppMethodBeat.i(145578);
    int i = j;
    if (paramInt > 0)
    {
      paramList1 = ag.cpf().Ez(paramInt);
      i = j;
      if (paramList1 != null)
      {
        if (paramList1.field_pravited > 0) {
          Toast.makeText(this.rYv, 2131303831, 1).show();
        }
        i = j;
        if (paramList1.field_pravited == 1) {
          i = 0;
        }
      }
    }
    if (i != 0) {
      BackwardSupportUtil.c.a(SnsTimeLineUI.l(this.rYv).list);
    }
    if (SnsTimeLineUI.a(this.rYv) != null) {
      SnsTimeLineUI.a(this.rYv).sds.notifyVendingDataChange();
    }
    if (SnsTimeLineUI.l(this.rYv).list != null) {
      SnsTimeLineUI.b(this.rYv);
    }
    AppMethodBeat.o(145578);
  }
  
  public final void cwg()
  {
    AppMethodBeat.i(145573);
    com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.q(this.rYv);
    SnsTimeLineUI.m(this.rYv);
    localc.e(SnsTimeLineUI.n(this.rYv), SnsTimeLineUI.o(this.rYv), false, SnsTimeLineUI.z(this.rYv));
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLj, Integer.valueOf(3));
    ab.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
    if (SnsTimeLineUI.A(this.rYv) == null)
    {
      ab.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
      AppMethodBeat.o(145573);
      return;
    }
    if (SnsTimeLineUI.i(this.rYv) != null)
    {
      SnsTimeLineUI.A(this.rYv).removeCallbacks(SnsTimeLineUI.B(this.rYv));
      SnsTimeLineUI.A(this.rYv).postDelayed(SnsTimeLineUI.B(this.rYv), 3000L);
    }
    AppMethodBeat.o(145573);
  }
  
  public final View cwh()
  {
    AppMethodBeat.i(145575);
    if (SnsTimeLineUI.i(this.rYv).rkt == null) {
      SnsTimeLineUI.i(this.rYv).rkt = ((FrameLayout)this.rYv.findViewById(2131822827));
    }
    FrameLayout localFrameLayout = SnsTimeLineUI.i(this.rYv).rkt;
    AppMethodBeat.o(145575);
    return localFrameLayout;
  }
  
  public final MMPullDownView cwi()
  {
    AppMethodBeat.i(145577);
    MMPullDownView localMMPullDownView = (MMPullDownView)this.rYv.findViewById(2131822829);
    AppMethodBeat.o(145577);
    return localMMPullDownView;
  }
  
  public final boolean cwj()
  {
    AppMethodBeat.i(145579);
    boolean bool = SnsTimeLineUI.C(this.rYv);
    AppMethodBeat.o(145579);
    return bool;
  }
  
  public final void cwk()
  {
    AppMethodBeat.i(145580);
    ab.d("MicroMsg.SnsTimeLineUI", "onLoadingTap");
    this.rYv.ctC();
    if (SnsTimeLineUI.t(this.rYv) != null)
    {
      ab.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
      SnsTimeLineUI.b(this.rYv, 0);
    }
    com.tencent.mm.plugin.sns.ui.a.a.c localc = SnsTimeLineUI.q(this.rYv);
    SnsTimeLineUI.m(this.rYv);
    localc.d(SnsTimeLineUI.n(this.rYv), SnsTimeLineUI.o(this.rYv), SnsTimeLineUI.p(this.rYv), SnsTimeLineUI.z(this.rYv));
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLj, Integer.valueOf(2));
    AppMethodBeat.o(145580);
  }
  
  public final void cwl()
  {
    AppMethodBeat.i(145581);
    this.rYv.ctC();
    AppMethodBeat.o(145581);
  }
  
  public final void fN(int paramInt1, int paramInt2) {}
  
  public final View getMaskView()
  {
    AppMethodBeat.i(145576);
    View localView = this.rYv.findViewById(2131828074);
    AppMethodBeat.o(145576);
    return localView;
  }
  
  public final ListView getSnsListView()
  {
    AppMethodBeat.i(145574);
    if (SnsTimeLineUI.i(this.rYv).list == null) {
      SnsTimeLineUI.i(this.rYv).list = ((ListView)this.rYv.findViewById(2131827968));
    }
    ListView localListView = SnsTimeLineUI.i(this.rYv).list;
    AppMethodBeat.o(145574);
    return localListView;
  }
  
  public final int getType()
  {
    int i = 1;
    if (this.rYv.rYo == 1) {
      i = 2;
    }
    return i;
  }
  
  public final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(145584);
    SnsTimeLineUI localSnsTimeLineUI = this.rYv;
    localSnsTimeLineUI.rYe = paramBoolean;
    ak localak = ag.bEf();
    com.tencent.mm.plugin.sns.model.g localg = ag.cpc();
    com.tencent.mm.plugin.sns.model.b localb = ag.cpa();
    if (paramBoolean)
    {
      if ((localg.rdd) || (localb.rdd))
      {
        localak.removeCallbacks(localSnsTimeLineUI.rYf);
        localak.removeCallbacks(localSnsTimeLineUI.rYg);
        localak.postDelayed(localSnsTimeLineUI.rYf, 0L);
        AppMethodBeat.o(145584);
      }
    }
    else if ((!localg.rdd) || (!localb.rdd))
    {
      localak.removeCallbacks(localSnsTimeLineUI.rYf);
      localak.removeCallbacks(localSnsTimeLineUI.rYg);
      localak.postDelayed(localSnsTimeLineUI.rYg, 0L);
    }
    AppMethodBeat.o(145584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.22
 * JD-Core Version:    0.7.0.1
 */