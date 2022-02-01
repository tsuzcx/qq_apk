package com.tencent.mm.view.refreshLayout.g;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import com.tencent.mm.view.refreshLayout.a.d;
import com.tencent.mm.view.refreshLayout.b.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/widget/RefreshSpinnerHelper;", "", "layout", "Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "stateCenter", "Lcom/tencent/mm/view/refreshLayout/widget/LayoutStateCenter;", "defaultMarginLP", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;Lcom/tencent/mm/view/refreshLayout/widget/LayoutStateCenter;Landroid/view/ViewGroup$MarginLayoutParams;)V", "cValues", "Lcom/tencent/mm/view/refreshLayout/config/CommonValue;", "checkFeedBackStart", "", "isAutoRefresh", "", "moveSpinner", "spinner", "", "isDragging", "moveSpinnerInfinitely", "outSpinner", "", "nestedInProgress", "overSpinner", "setCommonValue", "commonValue", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private final a agPj;
  private com.tencent.mm.view.refreshLayout.a.b agPn;
  private final ViewGroup.MarginLayoutParams agPs;
  private final WxRefreshLayout agRh;
  
  public e(WxRefreshLayout paramWxRefreshLayout, a parama, ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    AppMethodBeat.i(235109);
    this.agRh = paramWxRefreshLayout;
    this.agPj = parama;
    this.agPs = paramMarginLayoutParams;
    AppMethodBeat.o(235109);
  }
  
  private final void Oh(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235115);
    com.tencent.mm.view.refreshLayout.a.b localb = this.agPn;
    Object localObject1 = localb;
    if (localb == null)
    {
      s.bIx("cValues");
      localObject1 = null;
    }
    if ((!((com.tencent.mm.view.refreshLayout.a.b)localObject1).agJm) && (!paramBoolean) && (this.agRh.getCommonConfig().agJq))
    {
      this.agRh.performHapticFeedback(0, 2);
      localObject1 = this.agPn;
      if (localObject1 != null) {
        break label89;
      }
      s.bIx("cValues");
      localObject1 = localObject2;
    }
    label89:
    for (;;)
    {
      ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agJm = true;
      AppMethodBeat.o(235115);
      return;
    }
  }
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(235121);
    s.u(parame, "this$0");
    parame.agRh.jNu();
    AppMethodBeat.o(235121);
  }
  
  public final void a(com.tencent.mm.view.refreshLayout.a.b paramb)
  {
    AppMethodBeat.i(235130);
    s.u(paramb, "commonValue");
    this.agPn = paramb;
    AppMethodBeat.o(235130);
  }
  
  public final void g(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(235152);
    float f = paramFloat;
    Object localObject;
    if (paramBoolean)
    {
      f = paramFloat;
      if (!this.agRh.getCommonConfig().agPJ)
      {
        f = paramFloat;
        if (paramFloat < 0.0F)
        {
          localObject = this.agRh.getContentView();
          if (localObject != null) {
            break label294;
          }
          paramBoolean = false;
          f = paramFloat;
          if (!paramBoolean) {
            f = 0.0F;
          }
        }
      }
    }
    if ((this.agPj.jME()) && (f >= 0.0F)) {
      if (f < this.agRh.getHeaderConfig().headerHeight) {
        y((int)f, true, false);
      }
    }
    com.tencent.mm.view.refreshLayout.a.b localb;
    label294:
    label344:
    double d2;
    double d1;
    double d3;
    double d4;
    for (;;)
    {
      if (this.agRh.getCommonConfig().agPF)
      {
        localb = this.agPn;
        localObject = localb;
        if (localb == null)
        {
          s.bIx("cValues");
          localObject = null;
        }
        if ((!((com.tencent.mm.view.refreshLayout.a.b)localObject).agQh) && (this.agRh.Oc(this.agRh.getCommonConfig().Jcx)) && (f < 0.0F) && (!this.agPj.jME()) && (!this.agPj.isLoading()) && (!this.agPj.jNO()))
        {
          if (this.agRh.getCommonConfig().agPR)
          {
            this.agRh.getAnimHelper().agRl = null;
            this.agRh.aGm(-this.agRh.getFooterConfig().footerHeight);
          }
          this.agRh.setDirectLoadingState(false);
          this.agRh.getMainHandler().postDelayed(new e..ExternalSyntheticLambda0(this), this.agRh.getCommonConfig().reboundDuration);
        }
      }
      AppMethodBeat.o(235152);
      return;
      paramBoolean = ((com.tencent.mm.view.refreshLayout.b.a)localObject).egB();
      break;
      if (this.agRh.getHeaderConfig().agQn < 10.0F)
      {
        paramFloat = this.agRh.getHeaderConfig().headerHeight * this.agRh.getHeaderConfig().agQn;
        d2 = paramFloat - this.agRh.getHeaderConfig().headerHeight;
        localb = this.agPn;
        localObject = localb;
        if (localb == null)
        {
          s.bIx("cValues");
          localObject = null;
        }
        d1 = Math.max(((com.tencent.mm.view.refreshLayout.a.b)localObject).agPT * 4 / 3, this.agRh.getHeight()) - this.agRh.getHeaderConfig().headerHeight;
        d3 = Math.max(0.0F, (f - this.agRh.getHeaderConfig().headerHeight) * this.agRh.getCommonConfig().agPE);
        d4 = -d3;
        if (d1 != 0.0D) {
          break label523;
        }
      }
      label523:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          d1 = 1.0D;
        }
        y((int)Math.min((1.0D - Math.pow(100.0D, d4 / d1)) * d2, d3) + this.agRh.getHeaderConfig().headerHeight, true, false);
        break;
        paramFloat = this.agRh.getHeaderConfig().agQn;
        break label344;
      }
      if (f >= 0.0F) {
        break label961;
      }
      if (!this.agPj.isLoading())
      {
        if (this.agRh.getCommonConfig().agPI)
        {
          localb = this.agPn;
          localObject = localb;
          if (localb == null)
          {
            s.bIx("cValues");
            localObject = null;
          }
          if (((com.tencent.mm.view.refreshLayout.a.b)localObject).agQh)
          {
            localb = this.agPn;
            localObject = localb;
            if (localb == null)
            {
              s.bIx("cValues");
              localObject = null;
            }
            if ((((com.tencent.mm.view.refreshLayout.a.b)localObject).agQi) && (this.agRh.Oc(this.agRh.getCommonConfig().Jcx))) {
              break label705;
            }
          }
        }
        if (!this.agRh.getCommonConfig().agPF) {
          break label961;
        }
        localb = this.agPn;
        localObject = localb;
        if (localb == null)
        {
          s.bIx("cValues");
          localObject = null;
        }
        if ((((com.tencent.mm.view.refreshLayout.a.b)localObject).agQh) || (!this.agRh.Oc(this.agRh.getCommonConfig().Jcx))) {
          break label961;
        }
      }
      label705:
      if (f <= -this.agRh.getFooterConfig().footerHeight) {
        break label735;
      }
      y((int)f, true, false);
    }
    label735:
    if (this.agRh.getFooterConfig().agQk < 10.0F)
    {
      paramFloat = this.agRh.getFooterConfig().footerHeight * this.agRh.getFooterConfig().agQk;
      d2 = paramFloat - this.agRh.getFooterConfig().footerHeight;
      localb = this.agPn;
      localObject = localb;
      if (localb == null)
      {
        s.bIx("cValues");
        localObject = null;
      }
      d1 = Math.max(((com.tencent.mm.view.refreshLayout.a.b)localObject).agPT * 4 / 3, this.agRh.getHeight()) - this.agRh.getFooterConfig().footerHeight;
      d3 = -Math.min(0.0F, (this.agRh.getFooterConfig().footerHeight + f) * this.agRh.getCommonConfig().agPE);
      d4 = -d3;
      if (d1 != 0.0D) {
        break label955;
      }
    }
    label774:
    label955:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        d1 = 1.0D;
      }
      y((int)-Math.min((1.0D - Math.pow(100.0D, d4 / d1)) * d2, d3) - this.agRh.getFooterConfig().footerHeight, true, false);
      break;
      paramFloat = this.agRh.getFooterConfig().agQk;
      break label774;
    }
    label961:
    if (f >= 0.0F)
    {
      if (this.agRh.getHeaderConfig().agQn < 10.0F)
      {
        d1 = this.agRh.getHeaderConfig().headerHeight * this.agRh.getHeaderConfig().agQn;
        label1008:
        localb = this.agPn;
        localObject = localb;
        if (localb == null)
        {
          s.bIx("cValues");
          localObject = null;
        }
        d2 = Math.max(((com.tencent.mm.view.refreshLayout.a.b)localObject).agPT / 2, this.agRh.getHeight());
        d3 = Math.max(0.0F, this.agRh.getCommonConfig().agPE * f);
        d4 = -d3;
        if (d2 != 0.0D) {
          break label1139;
        }
      }
      label1139:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          d2 = 1.0D;
        }
        y((int)Math.min(d1 * (1.0D - Math.pow(100.0D, d4 / d2)), d3), true, false);
        break;
        d1 = this.agRh.getHeaderConfig().agQn;
        break label1008;
      }
    }
    if (this.agRh.getFooterConfig().agQk < 10.0F)
    {
      d1 = this.agRh.getFooterConfig().footerHeight * this.agRh.getFooterConfig().agQk;
      label1185:
      localb = this.agPn;
      localObject = localb;
      if (localb == null)
      {
        s.bIx("cValues");
        localObject = null;
      }
      d2 = Math.max(((com.tencent.mm.view.refreshLayout.a.b)localObject).agPT / 2, this.agRh.getHeight());
      d3 = -Math.min(0.0F, this.agRh.getCommonConfig().agPE * f);
      d4 = -d3;
      if (d2 != 0.0D) {
        break label1318;
      }
    }
    label1318:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        d2 = 1.0D;
      }
      y((int)-Math.min(d1 * (1.0D - Math.pow(100.0D, d4 / d2)), d3), true, false);
      break;
      d1 = this.agRh.getFooterConfig().agQk;
      break label1185;
    }
  }
  
  public final void jNW()
  {
    com.tencent.mm.view.refreshLayout.a.b localb2 = null;
    Object localObject2 = null;
    com.tencent.mm.view.refreshLayout.a.b localb1 = null;
    AppMethodBeat.i(235161);
    Object localObject1;
    if (!this.agPj.isLoading())
    {
      if (this.agRh.getCommonConfig().agPI)
      {
        com.tencent.mm.view.refreshLayout.a.b localb3 = this.agPn;
        localObject1 = localb3;
        if (localb3 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQh)
        {
          localb3 = this.agPn;
          localObject1 = localb3;
          if (localb3 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQi)
          {
            localb3 = this.agPn;
            localObject1 = localb3;
            if (localb3 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            if ((((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU >= 0) || (!this.agRh.Oc(this.agRh.getCommonConfig().Jcx))) {}
          }
        }
      }
    }
    else
    {
      localb2 = this.agPn;
      localObject1 = localb2;
      if (localb2 == null)
      {
        s.bIx("cValues");
        localObject1 = null;
      }
      if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU < -this.agRh.getFooterConfig().footerHeight)
      {
        this.agRh.aGm(-this.agRh.getFooterConfig().footerHeight);
        AppMethodBeat.o(235161);
        return;
      }
      localObject1 = this.agPn;
      if (localObject1 == null)
      {
        s.bIx("cValues");
        localObject1 = localb1;
      }
      while (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU > 0)
      {
        this.agRh.aGm(0);
        AppMethodBeat.o(235161);
        return;
      }
    }
    if (this.agPj.jME())
    {
      localb1 = this.agPn;
      localObject1 = localb1;
      if (localb1 == null)
      {
        s.bIx("cValues");
        localObject1 = null;
      }
      if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU > this.agRh.getHeaderConfig().headerHeight)
      {
        this.agRh.aGm(this.agRh.getHeaderConfig().headerHeight);
        AppMethodBeat.o(235161);
        return;
      }
      localObject1 = this.agPn;
      if (localObject1 == null)
      {
        s.bIx("cValues");
        localObject1 = localb2;
      }
      while (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU < 0)
      {
        this.agRh.aGm(0);
        AppMethodBeat.o(235161);
        return;
      }
    }
    if (this.agPj.jNP())
    {
      this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQP);
      AppMethodBeat.o(235161);
      return;
    }
    if (this.agPj.jNQ())
    {
      this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQR);
      AppMethodBeat.o(235161);
      return;
    }
    if (this.agPj.jNR())
    {
      this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQV);
      AppMethodBeat.o(235161);
      return;
    }
    if (this.agPj.jNS())
    {
      this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQN);
      AppMethodBeat.o(235161);
      return;
    }
    if (this.agPj.jNJ())
    {
      if (this.agRh.getAnimHelper().agRm == null)
      {
        this.agRh.aGm(this.agRh.getHeaderConfig().headerHeight);
        AppMethodBeat.o(235161);
      }
    }
    else if (this.agPj.jNK())
    {
      if (this.agRh.getAnimHelper().agRm == null)
      {
        this.agRh.aGm(-this.agRh.getFooterConfig().footerHeight);
        AppMethodBeat.o(235161);
      }
    }
    else if (!this.agPj.jNO())
    {
      localObject1 = this.agPn;
      if (localObject1 != null) {
        break label611;
      }
      s.bIx("cValues");
      localObject1 = localObject2;
    }
    label611:
    for (;;)
    {
      if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU != 0) {
        this.agRh.aGm(0);
      }
      AppMethodBeat.o(235161);
      return;
    }
  }
  
  public final void y(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(235175);
    Object localObject2 = this.agPn;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("cValues");
      localObject1 = null;
    }
    if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU == paramInt)
    {
      AppMethodBeat.o(235175);
      return;
    }
    localObject2 = this.agPn;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("cValues");
      localObject1 = null;
    }
    int n = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU;
    localObject2 = this.agPn;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("cValues");
      localObject1 = null;
    }
    ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU = paramInt;
    float f2;
    float f1;
    label228:
    Object localObject4;
    Object localObject3;
    int k;
    int m;
    int j;
    int i;
    if ((paramBoolean1) && ((this.agPj.agRj.mlX) || (this.agPj.agRj.LWA)))
    {
      localObject2 = this.agPn;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("cValues");
        localObject1 = null;
      }
      f2 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU;
      if (this.agRh.getHeaderConfig().agQo < 10.0F)
      {
        f1 = this.agRh.getHeaderConfig().headerHeight * this.agRh.getHeaderConfig().agQo;
        if (f2 <= f1) {
          break label979;
        }
        Oh(paramBoolean2);
        this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQX);
      }
    }
    else
    {
      localObject1 = this.agRh.getContentView();
      localObject4 = this.agRh.getLoadMoreFooter();
      localObject3 = this.agRh.getRefreshHeader();
      if (localObject1 != null)
      {
        k = 0;
        m = 0;
        j = m;
        i = k;
        if (paramInt >= 0)
        {
          if (!this.agRh.a(this.agRh.getCommonConfig().agPG, (f)localObject3)) {
            break label1237;
          }
          j = 1;
          i = paramInt;
        }
        label309:
        if (paramInt > 0) {
          break label1651;
        }
        if (!this.agRh.a(this.agRh.getCommonConfig().agPH, (f)localObject4)) {
          break label1259;
        }
        j = 1;
        i = paramInt;
      }
    }
    label344:
    label1118:
    label1259:
    label1651:
    for (;;)
    {
      if (j != 0)
      {
        ((com.tencent.mm.view.refreshLayout.b.a)localObject1).aGn(i);
        localObject2 = this.agPn;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQh)
        {
          localObject2 = this.agPn;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if ((((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQi) && (this.agRh.getCommonConfig().agPI) && (localObject4 != null) && (((com.tencent.mm.view.refreshLayout.b.b)localObject4).getSpinnerStyle() == com.tencent.mm.view.refreshLayout.e.c.agRc) && (this.agRh.Oc(this.agRh.getCommonConfig().Jcx)))
          {
            localObject1 = ((com.tencent.mm.view.refreshLayout.b.b)localObject4).getView();
            if (localObject1 != null) {
              ((View)localObject1).setTranslationY(Math.max(0, i));
            }
          }
        }
      }
      localObject1 = ah.aiuX;
      localObject1 = ah.aiuX;
      if (((paramInt >= 0) || (n > 0)) && (localObject3 != null))
      {
        Math.max(paramInt, 0);
        this.agRh.getHeaderConfig();
        if (this.agRh.getHeaderConfig().agQn < 10.0F)
        {
          this.agRh.getHeaderConfig();
          this.agRh.getHeaderConfig();
          if (this.agRh.getHeaderConfig().agQo >= 10.0F) {
            break label1284;
          }
          this.agRh.getHeaderConfig();
          this.agRh.getHeaderConfig();
          if ((this.agRh.Oc(this.agRh.getCommonConfig().agJq)) || ((this.agPj.jNN()) && (!paramBoolean1)))
          {
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            if (n != ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU)
            {
              if (((com.tencent.mm.view.refreshLayout.b.c)localObject3).getSpinnerStyle() != com.tencent.mm.view.refreshLayout.e.c.agRc) {
                break label1295;
              }
              localObject3 = ((com.tencent.mm.view.refreshLayout.b.c)localObject3).getView();
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              ((View)localObject3).setTranslationY(((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU);
            }
          }
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
      }
      else if (((paramInt <= 0) || (n < 0)) && (localObject4 != null))
      {
        Math.min(paramInt, 0);
        this.agRh.getFooterConfig();
        if (this.agRh.getFooterConfig().agQk >= 10.0F) {
          break label1460;
        }
        this.agRh.getFooterConfig();
        this.agRh.getFooterConfig();
        if (this.agRh.getFooterConfig().agQl >= 10.0F) {
          break label1471;
        }
        this.agRh.getFooterConfig();
        this.agRh.getFooterConfig();
        if ((this.agRh.Oc(this.agRh.getCommonConfig().Jcx)) || ((this.agPj.jNO()) && (!paramBoolean1)))
        {
          localObject2 = this.agPn;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if (n != ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU)
          {
            if (((com.tencent.mm.view.refreshLayout.b.b)localObject4).getSpinnerStyle() != com.tencent.mm.view.refreshLayout.e.c.agRc) {
              break label1482;
            }
            localObject3 = ((com.tencent.mm.view.refreshLayout.b.b)localObject4).getView();
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((View)localObject3).setTranslationY(((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU);
          }
        }
      }
      while (!((com.tencent.mm.view.refreshLayout.b.b)localObject4).getSpinnerStyle().agRb)
      {
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
        AppMethodBeat.o(235175);
        return;
        f1 = this.agRh.getHeaderConfig().agQo;
        break;
        localObject2 = this.agPn;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        f2 = -((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU;
        if (this.agRh.getFooterConfig().agQl < 10.0F) {}
        for (f1 = this.agRh.getFooterConfig().footerHeight * this.agRh.getFooterConfig().agQl;; f1 = this.agRh.getFooterConfig().agQl)
        {
          if (f2 <= f1) {
            break label1118;
          }
          localObject2 = this.agPn;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQh) {
            break label1118;
          }
          this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQW);
          break;
        }
        localObject2 = this.agPn;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU < 0)
        {
          localObject2 = this.agPn;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if (!((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQh)
          {
            this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQS);
            break label228;
          }
        }
        localObject2 = this.agPn;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU <= 0) {
          break label228;
        }
        this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQQ);
        break label228;
        j = m;
        i = k;
        if (n >= 0) {
          break label309;
        }
        j = 1;
        i = 0;
        break label309;
        if (n <= 0) {
          break label1651;
        }
        j = 1;
        i = 0;
        break label344;
        this.agRh.getHeaderConfig();
        break label567;
        this.agRh.getHeaderConfig();
        break label599;
        if (!((com.tencent.mm.view.refreshLayout.b.c)localObject3).getSpinnerStyle().agRb) {
          break label722;
        }
        View localView = ((com.tencent.mm.view.refreshLayout.b.c)localObject3).getView();
        localObject1 = localView.getLayoutParams();
        if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {}
        for (localObject1 = (ViewGroup.MarginLayoutParams)localObject1;; localObject1 = this.agPs)
        {
          i = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredWidth(), 1073741824);
          localObject3 = this.agPn;
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("cValues");
            localObject2 = null;
          }
          localView.measure(i, View.MeasureSpec.makeMeasureSpec(Math.max(((com.tencent.mm.view.refreshLayout.a.b)localObject2).agPU - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject1).topMargin, 0), 1073741824));
          i = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
          j = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
          localView.layout(i, j, localView.getMeasuredWidth() + i, localView.getMeasuredHeight() + j);
          break;
        }
        this.agRh.getFooterConfig();
        break label792;
        this.agRh.getFooterConfig();
        break label824;
      }
      localObject4 = ((com.tencent.mm.view.refreshLayout.b.b)localObject4).getView();
      localObject1 = ((View)localObject4).getLayoutParams();
      if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {}
      for (localObject1 = (ViewGroup.MarginLayoutParams)localObject1;; localObject1 = this.agPs)
      {
        paramInt = View.MeasureSpec.makeMeasureSpec(((View)localObject4).getMeasuredWidth(), 1073741824);
        localObject3 = this.agPn;
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cValues");
          localObject2 = null;
        }
        ((View)localObject4).measure(paramInt, View.MeasureSpec.makeMeasureSpec(Math.max(-((com.tencent.mm.view.refreshLayout.a.b)localObject2).agPU - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject1).topMargin, 0), 1073741824));
        paramInt = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
        i = ((ViewGroup.MarginLayoutParams)localObject1).topMargin + this.agRh.getMeasuredHeight();
        ((View)localObject4).layout(paramInt, i - ((View)localObject4).getMeasuredHeight(), ((View)localObject4).getMeasuredWidth() + paramInt, i);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.g.e
 * JD-Core Version:    0.7.0.1
 */