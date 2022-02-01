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
import com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView.f;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.a.a;
import com.tencent.mm.plugin.scanner.view.a.b;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper;", "", "()V", "currentInfoViewType", "", "infoMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView;", "isLoadingShow", "", "loadingCancelListener", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;", "mScanUIMode", "Lcom/tencent/mm/plugin/scanner/model/IScanUIModel;", "scanMaskView", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "sharedMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "animateSwitch", "", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "attachScanUIModel", "scanUIModel", "buildViewParams", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "context", "Landroid/content/Context;", "showType", "data", "Landroid/os/Bundle;", "cancelLoading", "dismissInfoView", "withAnimation", "getInfoViewType", "setOnCancelListener", "cancelListener", "setScanMaskView", "showInfoView", "extra", "showLoadingView", "show", "Companion", "plugin-scan_release"})
public final class ad
{
  public static final ad.a CGJ;
  private f CGC;
  public BaseScanMaskView<BaseScanRequest> CGD;
  public ScanSharedMaskView CGE;
  public ScanInfoMaskView CGF;
  public boolean CGG;
  public c.a CGH;
  public int CGI;
  
  static
  {
    AppMethodBeat.i(240458);
    CGJ = new ad.a((byte)0);
    AppMethodBeat.o(240458);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(240455);
    p.h(paramf, "scanUIModel");
    this.CGC = paramf;
    AppMethodBeat.o(240455);
  }
  
  public final void a(BaseScanMaskView<BaseScanRequest> paramBaseScanMaskView, ScanSharedMaskView paramScanSharedMaskView, ScanInfoMaskView paramScanInfoMaskView)
  {
    this.CGD = paramBaseScanMaskView;
    this.CGE = paramScanSharedMaskView;
    this.CGF = paramScanInfoMaskView;
  }
  
  public final void ag(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(240456);
    if (this.CGG != paramBoolean1)
    {
      Object localObject2;
      if (paramBoolean1)
      {
        localObject1 = this.CGD;
        if (localObject1 == null) {
          break label202;
        }
        localObject1 = ((BaseScanMaskView)localObject1).getTargetSuccessMarkView();
        localObject2 = this.CGF;
        if (localObject2 != null) {
          ((ScanInfoMaskView)localObject2).setAnchorView((View)localObject1);
        }
      }
      this.CGG = paramBoolean1;
      Object localObject1 = this.CGE;
      boolean bool;
      if (localObject1 != null)
      {
        if (!paramBoolean1)
        {
          bool = true;
          label75:
          ((ScanSharedMaskView)localObject1).ui(bool);
        }
      }
      else
      {
        localObject1 = this.CGF;
        if (localObject1 != null)
        {
          Log.v("MicroMsg.ScanInfoMaskView", "alvinluo showLoadingView show: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
          localObject2 = ((ScanInfoMaskView)localObject1).BCP;
          if (localObject2 == null) {
            p.btv("infoLayout");
          }
          ((View)localObject2).setVisibility(8);
          localObject2 = ((ScanInfoMaskView)localObject1).CRU;
          if (localObject2 == null) {
            p.btv("opButton");
          }
          ((TextView)localObject2).setVisibility(8);
          if (!paramBoolean1) {
            break label281;
          }
          if (paramBoolean2) {
            break label213;
          }
          ((ScanInfoMaskView)localObject1).ue(false);
        }
      }
      for (;;)
      {
        localObject1 = this.CGD;
        if (localObject1 == null) {
          break label326;
        }
        ((BaseScanMaskView)localObject1).uc(paramBoolean1);
        AppMethodBeat.o(240456);
        return;
        label202:
        localObject1 = null;
        break;
        bool = false;
        break label75;
        label213:
        ((ScanInfoMaskView)localObject1).CRX = false;
        ((ScanInfoMaskView)localObject1).CSd = true;
        ((ScanInfoMaskView)localObject1).CSe = paramBoolean2;
        localObject2 = ((ScanInfoMaskView)localObject1).xcd;
        if (localObject2 == null) {
          p.btv("loadingLayout");
        }
        ((View)localObject2).setVisibility(0);
        ((ScanInfoMaskView)localObject1).setVisibility(4);
        ((ScanInfoMaskView)localObject1).post((Runnable)new ScanInfoMaskView.f((ScanInfoMaskView)localObject1));
        continue;
        label281:
        ((ScanInfoMaskView)localObject1).setVisibility(8);
        ((ScanInfoMaskView)localObject1).CGG = false;
        localObject2 = ((ScanInfoMaskView)localObject1).xcd;
        if (localObject2 == null) {
          p.btv("loadingLayout");
        }
        ((View)localObject2).setVisibility(8);
        ((ScanInfoMaskView)localObject1).eRC();
      }
    }
    label326:
    AppMethodBeat.o(240456);
  }
  
  public final a.a b(Context paramContext, int paramInt, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(240457);
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
        paramContext = new a.a(localb.qcr, localb.mVp, localb.CUX, localb.title, localb.pWf, localb.CUY, localb.CUZ);
        AppMethodBeat.o(240457);
        return paramContext;
        bool = true;
        break;
        localb.mVp = bool;
        localb.CUY = false;
        localb.CUX = 2131691426;
        paramBundle = paramContext.getResources().getString(2131764958);
        p.g(paramBundle, "context.resources.getStr…line_network_unavailable)");
        paramBundle = localb.aMW(paramBundle);
        paramContext = paramContext.getResources().getString(2131764959);
        p.g(paramContext, "context.resources.getStr…network_unavailable_tips)");
        paramBundle.aMX(paramContext);
        continue;
        localb.mVp = bool;
        localb.CUY = false;
        localb.CUX = 2131691426;
        paramBundle = paramContext.getResources().getString(2131764961);
        p.g(paramBundle, "context.resources.getStr…can_offline_network_weak)");
        paramBundle = localb.aMW(paramBundle);
        paramContext = paramContext.getResources().getString(2131764959);
        p.g(paramContext, "context.resources.getStr…network_unavailable_tips)");
        paramBundle.aMX(paramContext);
      }
    }
    if (paramBundle != null) {}
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = paramBundle.getByteArray("key_scan_bar_code_response");
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = new byte[0];
        }
        p.g(paramBundle, "data?.getByteArray(Const…ESPONSE) ?: byteArrayOf()");
        localObject1 = new pu();
        ((pu)localObject1).parseFrom(paramBundle);
        paramBundle = ((pu)localObject1).KWJ;
        if (paramBundle == null) {
          break label630;
        }
        paramBundle = (qp)j.L((List)paramBundle, 0);
        if (paramBundle == null) {
          break label630;
        }
        paramBundle = paramBundle.KXw;
        localObject1 = ((pu)localObject1).KWJ;
        if (localObject1 == null) {
          break label635;
        }
        localObject1 = (qp)j.L((List)localObject1, 1);
        if (localObject1 == null) {
          break label635;
        }
        localObject1 = ((qp)localObject1).KXw;
        localb.mVp = bool;
        localObject2 = localb.e((View.OnClickListener)new b(this));
        ((a.b)localObject2).CUX = 2131691427;
        CharSequence localCharSequence = (CharSequence)paramBundle;
        if (localCharSequence == null) {
          break label651;
        }
        if (localCharSequence.length() != 0) {
          break label641;
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject2;
        Log.printErrStackTrace("MicroMsg.ScanInfoPageViewHelper", (Throwable)paramBundle, "buildViewParams parse BizScanBarcodeResponse from byte array exception", new Object[0]);
        localb.mVp = bool;
        paramBundle = localb.e((View.OnClickListener)new c(this));
        paramBundle.CUX = 2131691427;
        localObject1 = paramContext.getResources().getString(2131764890);
        p.g(localObject1, "context.resources.getStr…scan_goods_title_default)");
        paramBundle = paramBundle.aMW((String)localObject1);
        paramContext = paramContext.getResources().getString(2131764889);
        p.g(paramContext, "context.resources.getStr…_goods_sub_title_default)");
        paramBundle.aMX(paramContext);
      }
      if (paramInt != 0) {
        paramBundle = paramContext.getResources().getString(2131764890);
      }
      p.g(paramBundle, "if (title.isNullOrEmpty(…title_default) else title");
      paramBundle = ((a.b)localObject2).aMW(paramBundle);
      localObject2 = (CharSequence)localObject1;
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
          localObject1 = paramContext.getResources().getString(2131764889);
        }
        p.g(localObject1, "if (subTitle.isNullOrEmp…le_default) else subTitle");
        paramBundle.aMX((String)localObject1);
        break;
        break;
        label630:
        paramBundle = null;
        continue;
        label635:
        localObject1 = null;
        continue;
        label641:
        paramInt = 0;
        continue;
      }
      paramInt = 0;
      continue;
      label651:
      paramInt = 1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ad paramad) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240453);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = ad.a(this.CGK);
      if (paramView != null) {
        paramView.ePP();
      }
      af.eQo();
      a.a(this, "com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(240453);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ad paramad) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240454);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = ad.a(this.CGK);
      if (paramView != null) {
        paramView.ePP();
      }
      a.a(this, "com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(240454);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ad
 * JD-Core Version:    0.7.0.1
 */