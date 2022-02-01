package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.l.h;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView.f;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.a.a;
import com.tencent.mm.plugin.scanner.view.a.b;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.protocal.protobuf.qi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper;", "", "()V", "currentInfoViewType", "", "infoMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView;", "isLoadingShow", "", "loadingCancelListener", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;", "mScanUIMode", "Lcom/tencent/mm/plugin/scanner/model/IScanUIModel;", "scanMaskView", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "sharedMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "animateSwitch", "", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "attachScanUIModel", "scanUIModel", "buildViewParams", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "context", "Landroid/content/Context;", "showType", "data", "Landroid/os/Bundle;", "cancelLoading", "dismissInfoView", "withAnimation", "getInfoViewType", "setOnCancelListener", "cancelListener", "setScanMaskView", "showInfoView", "extra", "showLoadingView", "show", "Companion", "plugin-scan_release"})
public final class ab
{
  public static final ab.a ILU;
  private d ILN;
  public BaseScanMaskView<BaseScanRequest> ILO;
  public ScanSharedMaskView ILP;
  public ScanInfoMaskView ILQ;
  public boolean ILR;
  public c.a ILS;
  public int ILT;
  
  static
  {
    AppMethodBeat.i(217078);
    ILU = new ab.a((byte)0);
    AppMethodBeat.o(217078);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(217073);
    p.k(paramd, "scanUIModel");
    this.ILN = paramd;
    AppMethodBeat.o(217073);
  }
  
  public final void a(BaseScanMaskView<BaseScanRequest> paramBaseScanMaskView, ScanSharedMaskView paramScanSharedMaskView, ScanInfoMaskView paramScanInfoMaskView)
  {
    this.ILO = paramBaseScanMaskView;
    this.ILP = paramScanSharedMaskView;
    this.ILQ = paramScanInfoMaskView;
  }
  
  public final void as(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(217075);
    if (this.ILR != paramBoolean1)
    {
      Object localObject2;
      if (paramBoolean1)
      {
        localObject1 = this.ILO;
        if (localObject1 == null) {
          break label202;
        }
        localObject1 = ((BaseScanMaskView)localObject1).getTargetSuccessMarkView();
        localObject2 = this.ILQ;
        if (localObject2 != null) {
          ((ScanInfoMaskView)localObject2).setAnchorView((View)localObject1);
        }
      }
      this.ILR = paramBoolean1;
      Object localObject1 = this.ILP;
      boolean bool;
      if (localObject1 != null)
      {
        if (!paramBoolean1)
        {
          bool = true;
          label75:
          ((ScanSharedMaskView)localObject1).xG(bool);
        }
      }
      else
      {
        localObject1 = this.ILQ;
        if (localObject1 != null)
        {
          Log.v("MicroMsg.ScanInfoMaskView", "alvinluo showLoadingView show: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
          localObject2 = ((ScanInfoMaskView)localObject1).HyS;
          if (localObject2 == null) {
            p.bGy("infoLayout");
          }
          ((View)localObject2).setVisibility(8);
          localObject2 = ((ScanInfoMaskView)localObject1).IXm;
          if (localObject2 == null) {
            p.bGy("opButton");
          }
          ((TextView)localObject2).setVisibility(8);
          if (!paramBoolean1) {
            break label281;
          }
          if (paramBoolean2) {
            break label213;
          }
          ((ScanInfoMaskView)localObject1).xC(false);
        }
      }
      for (;;)
      {
        localObject1 = this.ILO;
        if (localObject1 == null) {
          break label326;
        }
        ((BaseScanMaskView)localObject1).xA(paramBoolean1);
        AppMethodBeat.o(217075);
        return;
        label202:
        localObject1 = null;
        break;
        bool = false;
        break label75;
        label213:
        ((ScanInfoMaskView)localObject1).IXp = false;
        ((ScanInfoMaskView)localObject1).IXv = true;
        ((ScanInfoMaskView)localObject1).IXw = paramBoolean2;
        localObject2 = ((ScanInfoMaskView)localObject1).BOd;
        if (localObject2 == null) {
          p.bGy("loadingLayout");
        }
        ((View)localObject2).setVisibility(0);
        ((ScanInfoMaskView)localObject1).setVisibility(4);
        ((ScanInfoMaskView)localObject1).post((Runnable)new ScanInfoMaskView.f((ScanInfoMaskView)localObject1));
        continue;
        label281:
        ((ScanInfoMaskView)localObject1).setVisibility(8);
        ((ScanInfoMaskView)localObject1).ILR = false;
        localObject2 = ((ScanInfoMaskView)localObject1).BOd;
        if (localObject2 == null) {
          p.bGy("loadingLayout");
        }
        ((View)localObject2).setVisibility(8);
        ((ScanInfoMaskView)localObject1).fEB();
      }
    }
    label326:
    AppMethodBeat.o(217075);
  }
  
  public final a.a b(Context paramContext, int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    int i = 1;
    AppMethodBeat.i(217077);
    boolean bool;
    a.b localb;
    if (paramBundle != null)
    {
      bool = paramBundle.getBoolean("key_offline_scan_show_tips", true);
      localb = new a.b(paramInt);
    }
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
      for (;;)
      {
        paramContext = new a.a(localb.viewType, localb.Jaw, localb.Jax, localb.title, localb.tsf, localb.Jay, localb.Jaz);
        AppMethodBeat.o(217077);
        return paramContext;
        bool = true;
        break;
        localb.Jaw = bool;
        localb.Jay = false;
        localb.Jax = l.h.scan_no_network_error;
        paramBundle = paramContext.getResources().getString(l.i.IFf);
        p.j(paramBundle, "context.resources.getStr…line_network_unavailable)");
        paramBundle = localb.aXG(paramBundle);
        paramContext = paramContext.getResources().getString(l.i.IFg);
        p.j(paramContext, "context.resources.getStr…network_unavailable_tips)");
        paramBundle.aXH(paramContext);
        continue;
        localb.Jaw = bool;
        localb.Jay = false;
        localb.Jax = l.h.scan_no_network_error;
        paramBundle = paramContext.getResources().getString(l.i.IFi);
        p.j(paramBundle, "context.resources.getStr…can_offline_network_weak)");
        paramBundle = localb.aXG(paramBundle);
        paramContext = paramContext.getResources().getString(l.i.IFg);
        p.j(paramContext, "context.resources.getStr…network_unavailable_tips)");
        paramBundle.aXH(paramContext);
      }
    }
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        localObject1 = paramBundle.getByteArray("key_scan_bar_code_response");
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = new byte[0];
        }
        p.j(paramBundle, "data?.getByteArray(Const…ESPONSE) ?: byteArrayOf()");
        Object localObject3 = new pq();
        ((pq)localObject3).parseFrom(paramBundle);
        paramBundle = ((pq)localObject3).RXX;
        if (paramBundle == null) {
          break label638;
        }
        paramBundle = (qi)j.M((List)paramBundle, 0);
        if (paramBundle == null) {
          break label638;
        }
        localObject1 = paramBundle.RYF;
        localObject3 = ((pq)localObject3).RXX;
        paramBundle = (Bundle)localObject2;
        if (localObject3 != null)
        {
          localObject3 = (qi)j.M((List)localObject3, 1);
          paramBundle = (Bundle)localObject2;
          if (localObject3 != null) {
            paramBundle = ((qi)localObject3).RYF;
          }
        }
        localb.Jaw = bool;
        localObject2 = localb.f((View.OnClickListener)new b(this));
        ((a.b)localObject2).Jax = l.h.scan_no_result_error;
        localObject3 = (CharSequence)localObject1;
        if (localObject3 == null) {
          break label654;
        }
        if (((CharSequence)localObject3).length() != 0) {
          break label644;
        }
      }
      catch (Exception paramBundle)
      {
        Log.printErrStackTrace("MicroMsg.ScanInfoPageViewHelper", (Throwable)paramBundle, "buildViewParams parse BizScanBarcodeResponse from byte array exception", new Object[0]);
        localb.Jaw = bool;
        paramBundle = localb.f((View.OnClickListener)new c(this));
        paramBundle.Jax = l.h.scan_no_result_error;
        localObject1 = paramContext.getResources().getString(l.i.IEL);
        p.j(localObject1, "context.resources.getStr…scan_goods_title_default)");
        paramBundle = paramBundle.aXG((String)localObject1);
        paramContext = paramContext.getResources().getString(l.i.IEK);
        p.j(paramContext, "context.resources.getStr…_goods_sub_title_default)");
        paramBundle.aXH(paramContext);
      }
      if (paramInt != 0) {
        localObject1 = paramContext.getResources().getString(l.i.IEL);
      }
      p.j(localObject1, "if (title.isNullOrEmpty(…title_default) else title");
      Object localObject1 = ((a.b)localObject2).aXG((String)localObject1);
      localObject2 = (CharSequence)paramBundle;
      paramInt = i;
      if (localObject2 != null)
      {
        if (((CharSequence)localObject2).length() == 0) {
          paramInt = i;
        }
      }
      else
      {
        if (paramInt != 0) {
          paramBundle = paramContext.getResources().getString(l.i.IEK);
        }
        p.j(paramBundle, "if (subTitle.isNullOrEmp…le_default) else subTitle");
        ((a.b)localObject1).aXH(paramBundle);
        break;
        break;
        label638:
        localObject1 = null;
        continue;
        label644:
        paramInt = 0;
        continue;
      }
      paramInt = 0;
      continue;
      label654:
      paramInt = 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ab paramab) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(222964);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = ab.a(this.ILV);
      if (paramView != null) {
        paramView.fCK();
      }
      ad.fDk();
      a.a(this, "com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(222964);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ab paramab) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(222168);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = ab.a(this.ILV);
      if (paramView != null) {
        paramView.fCK();
      }
      a.a(this, "com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(222168);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ab
 * JD-Core Version:    0.7.0.1
 */