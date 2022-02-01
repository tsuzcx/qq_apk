package com.tencent.mm.view.refreshLayout.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/widget/LayoutStateCenter;", "", "layout", "Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "(Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;)V", "commonValue", "Lcom/tencent/mm/view/refreshLayout/config/CommonValue;", "mainState", "Lcom/tencent/mm/view/refreshLayout/status/RefreshState;", "getMainState", "()Lcom/tencent/mm/view/refreshLayout/status/RefreshState;", "setMainState", "(Lcom/tencent/mm/view/refreshLayout/status/RefreshState;)V", "viceState", "getViceState", "setViceState", "isLoadFinish", "", "isLoadReleased", "isLoading", "isNone", "isPDCanceled", "isPDToRefresh", "isPUCanceled", "isPUToLoad", "isRefreshFinish", "isRefreshReleased", "isRefreshing", "isReleaseToLoad", "isReleaseToRefresh", "isViceLoading", "isViceNone", "isViceRefreshing", "notifyStateChanged", "", "state", "setCommonValue", "setNewViceState", "setState", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final WxRefreshLayout agRh;
  public com.tencent.mm.view.refreshLayout.e.b agRi;
  public com.tencent.mm.view.refreshLayout.e.b agRj;
  private com.tencent.mm.view.refreshLayout.a.b agRk;
  
  public a(WxRefreshLayout paramWxRefreshLayout)
  {
    AppMethodBeat.i(235112);
    this.agRh = paramWxRefreshLayout;
    this.agRi = com.tencent.mm.view.refreshLayout.e.b.agQO;
    this.agRj = com.tencent.mm.view.refreshLayout.e.b.agQO;
    AppMethodBeat.o(235112);
  }
  
  public final void a(com.tencent.mm.view.refreshLayout.a.b paramb)
  {
    AppMethodBeat.i(235193);
    s.u(paramb, "commonValue");
    this.agRk = paramb;
    AppMethodBeat.o(235193);
  }
  
  public final void a(com.tencent.mm.view.refreshLayout.e.b paramb)
  {
    AppMethodBeat.i(235139);
    s.u(paramb, "state");
    if (this.agRi != paramb)
    {
      this.agRi = paramb;
      this.agRj = paramb;
      this.agRh.a(paramb);
      AppMethodBeat.o(235139);
      return;
    }
    if (this.agRj != this.agRi) {
      this.agRj = this.agRi;
    }
    AppMethodBeat.o(235139);
  }
  
  public final void b(com.tencent.mm.view.refreshLayout.e.b paramb)
  {
    AppMethodBeat.i(235117);
    s.u(paramb, "<set-?>");
    this.agRj = paramb;
    AppMethodBeat.o(235117);
  }
  
  public final void c(com.tencent.mm.view.refreshLayout.e.b paramb)
  {
    com.tencent.mm.view.refreshLayout.a.b localb2 = null;
    Object localObject = null;
    com.tencent.mm.view.refreshLayout.a.b localb1 = null;
    AppMethodBeat.i(235133);
    for (;;)
    {
      s.u(paramb, "state");
      switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        a(paramb);
        AppMethodBeat.o(235133);
        return;
      case 1: 
        localb2 = this.agRk;
        paramb = localb2;
        if (localb2 == null)
        {
          s.bIx("commonValue");
          paramb = null;
        }
        paramb.agJm = false;
        if (this.agRi != com.tencent.mm.view.refreshLayout.e.b.agQO)
        {
          localb2 = this.agRk;
          paramb = localb2;
          if (localb2 == null)
          {
            s.bIx("commonValue");
            paramb = null;
          }
          if (paramb.agPU == 0)
          {
            a(com.tencent.mm.view.refreshLayout.e.b.agQO);
            AppMethodBeat.o(235133);
            return;
          }
        }
        paramb = this.agRk;
        if (paramb == null)
        {
          s.bIx("commonValue");
          paramb = localb1;
        }
        while (paramb.agPU != 0)
        {
          this.agRh.aGm(0);
          AppMethodBeat.o(235133);
          return;
        }
      case 2: 
        if ((!this.agRi.LWA) && (this.agRh.Oc(this.agRh.getCommonConfig().agJq)))
        {
          a(com.tencent.mm.view.refreshLayout.e.b.agQQ);
          AppMethodBeat.o(235133);
          return;
        }
        d(com.tencent.mm.view.refreshLayout.e.b.agQQ);
        AppMethodBeat.o(235133);
        return;
      case 3: 
        if ((this.agRh.Oc(this.agRh.getCommonConfig().Jcx)) && (!this.agRi.LWA) && (!this.agRi.isFinishing))
        {
          localb1 = this.agRk;
          paramb = localb1;
          if (localb1 == null)
          {
            s.bIx("commonValue");
            paramb = null;
          }
          if ((paramb.agQh) && (this.agRh.getCommonConfig().agPI))
          {
            paramb = this.agRk;
            if (paramb != null) {
              break label377;
            }
            s.bIx("commonValue");
            paramb = localb2;
          }
          while (!paramb.agQi)
          {
            a(com.tencent.mm.view.refreshLayout.e.b.agQS);
            AppMethodBeat.o(235133);
            return;
          }
        }
        d(com.tencent.mm.view.refreshLayout.e.b.agQS);
        AppMethodBeat.o(235133);
        return;
      case 4: 
        if ((!this.agRi.LWA) && (this.agRh.Oc(this.agRh.getCommonConfig().agJq)))
        {
          a(com.tencent.mm.view.refreshLayout.e.b.agQP);
          paramb = com.tencent.mm.view.refreshLayout.e.b.agQO;
        }
        else
        {
          d(com.tencent.mm.view.refreshLayout.e.b.agQP);
          AppMethodBeat.o(235133);
          return;
        }
        break;
      case 5: 
        label377:
        if ((!this.agRh.Oc(this.agRh.getCommonConfig().Jcx)) || (this.agRi.LWA)) {
          break label563;
        }
        com.tencent.mm.view.refreshLayout.a.b localb3 = this.agRk;
        paramb = localb3;
        if (localb3 == null)
        {
          s.bIx("commonValue");
          paramb = null;
        }
        if ((paramb.agQh) && (this.agRh.getCommonConfig().agPI))
        {
          localb3 = this.agRk;
          paramb = localb3;
          if (localb3 == null)
          {
            s.bIx("commonValue");
            paramb = null;
          }
          if (paramb.agQi) {
            break label563;
          }
        }
        a(com.tencent.mm.view.refreshLayout.e.b.agQR);
        paramb = com.tencent.mm.view.refreshLayout.e.b.agQO;
      }
    }
    label563:
    d(com.tencent.mm.view.refreshLayout.e.b.agQR);
    AppMethodBeat.o(235133);
    return;
    if ((!this.agRi.LWA) && (this.agRh.Oc(this.agRh.getCommonConfig().agJq)))
    {
      a(com.tencent.mm.view.refreshLayout.e.b.agQX);
      AppMethodBeat.o(235133);
      return;
    }
    d(com.tencent.mm.view.refreshLayout.e.b.agQX);
    AppMethodBeat.o(235133);
    return;
    if ((this.agRh.Oc(this.agRh.getCommonConfig().Jcx)) && (!this.agRi.LWA) && (!this.agRi.isFinishing))
    {
      localb1 = this.agRk;
      paramb = localb1;
      if (localb1 == null)
      {
        s.bIx("commonValue");
        paramb = null;
      }
      if ((paramb.agQh) && (this.agRh.getCommonConfig().agPI))
      {
        paramb = this.agRk;
        if (paramb != null) {
          break label747;
        }
        s.bIx("commonValue");
        paramb = localObject;
      }
      label747:
      while (!paramb.agQi)
      {
        a(com.tencent.mm.view.refreshLayout.e.b.agQW);
        AppMethodBeat.o(235133);
        return;
      }
    }
    d(com.tencent.mm.view.refreshLayout.e.b.agQW);
    AppMethodBeat.o(235133);
    return;
    if ((!this.agRi.LWA) && (this.agRh.Oc(this.agRh.getCommonConfig().agJq)))
    {
      a(com.tencent.mm.view.refreshLayout.e.b.agQU);
      AppMethodBeat.o(235133);
      return;
    }
    d(com.tencent.mm.view.refreshLayout.e.b.agQU);
    AppMethodBeat.o(235133);
    return;
    if ((!this.agRi.LWA) && (this.agRh.Oc(this.agRh.getCommonConfig().Jcx)))
    {
      a(com.tencent.mm.view.refreshLayout.e.b.agQM);
      AppMethodBeat.o(235133);
      return;
    }
    d(com.tencent.mm.view.refreshLayout.e.b.agQM);
    AppMethodBeat.o(235133);
    return;
    this.agRh.jNv();
    AppMethodBeat.o(235133);
    return;
    this.agRh.dUn();
    AppMethodBeat.o(235133);
  }
  
  public final void d(com.tencent.mm.view.refreshLayout.e.b paramb)
  {
    AppMethodBeat.i(235144);
    s.u(paramb, "state");
    if ((this.agRi.mlX) && (this.agRi.agQI != paramb.agQI)) {
      a(com.tencent.mm.view.refreshLayout.e.b.agQO);
    }
    if (this.agRj != paramb) {
      this.agRj = paramb;
    }
    AppMethodBeat.o(235144);
  }
  
  public final boolean isLoading()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQN;
  }
  
  public final boolean jME()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQV;
  }
  
  public final boolean jNI()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQO;
  }
  
  public final boolean jNJ()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQU;
  }
  
  public final boolean jNK()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQM;
  }
  
  public final boolean jNL()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQP;
  }
  
  public final boolean jNM()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQR;
  }
  
  public final boolean jNN()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQT;
  }
  
  public final boolean jNO()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQL;
  }
  
  public final boolean jNP()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQQ;
  }
  
  public final boolean jNQ()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQS;
  }
  
  public final boolean jNR()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQX;
  }
  
  public final boolean jNS()
  {
    return this.agRi == com.tencent.mm.view.refreshLayout.e.b.agQW;
  }
  
  public final boolean jNT()
  {
    return this.agRj == com.tencent.mm.view.refreshLayout.e.b.agQV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.g.a
 * JD-Core Version:    0.7.0.1
 */