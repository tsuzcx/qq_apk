package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.l.h;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.a.a;
import com.tencent.mm.plugin.scanner.view.a.b;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.protocal.protobuf.rs;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper;", "", "()V", "currentCodeString", "", "currentInfoViewType", "", "infoMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView;", "isLoadingShow", "", "loadingCancelListener", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;", "mScanUIMode", "Lcom/tencent/mm/plugin/scanner/model/IScanUIModel;", "scanMaskView", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "sharedMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "animateSwitch", "", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "attachScanUIModel", "scanUIModel", "buildViewParams", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "context", "Landroid/content/Context;", "showType", "data", "Landroid/os/Bundle;", "cancelLoading", "dismissInfoView", "withAnimation", "getInfoViewType", "setOnCancelListener", "cancelListener", "setScanMaskView", "showInfoView", "extra", "showLoadingView", "show", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
{
  public static final ai.a OSM;
  private h OSN;
  public BaseScanMaskView<BaseScanRequest> OSO;
  public ScanSharedMaskView OSP;
  public ScanInfoMaskView OSQ;
  public boolean OSR;
  public c.a OSS;
  public int OST;
  public String OSU = "";
  
  static
  {
    AppMethodBeat.i(314235);
    OSM = new ai.a((byte)0);
    AppMethodBeat.o(314235);
  }
  
  private static final void a(ai paramai, View paramView)
  {
    AppMethodBeat.i(314225);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramai);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramai, "this$0");
    paramai = paramai.OSN;
    if (paramai != null) {
      paramai.gQL();
    }
    am.gRu();
    a.a(new Object(), "com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314225);
  }
  
  private static final void b(ai paramai, View paramView)
  {
    AppMethodBeat.i(314230);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramai);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramai, "this$0");
    paramai = paramai.OSN;
    if (paramai != null) {
      paramai.gQL();
    }
    a.a(new Object(), "com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314230);
  }
  
  public final a.a a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    int j = 1;
    int i = 1;
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(314271);
    boolean bool;
    a.b localb;
    if (paramBundle == null)
    {
      bool = true;
      localb = new a.b(paramInt);
    }
    label274:
    Object localObject1;
    label315:
    label713:
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
      for (;;)
      {
        paramContext = new a.a(localb.viewType, localb.Pko, localb.Pkp, localb.title, localb.lym, localb.Pkq, localb.Pkr);
        AppMethodBeat.o(314271);
        return paramContext;
        bool = paramBundle.getBoolean("key_offline_scan_show_tips", true);
        break;
        localb.Pko = bool;
        localb.Pkq = false;
        localb.Pkp = l.h.scan_no_network_error;
        paramBundle = paramContext.getResources().getString(l.i.OLm);
        s.s(paramBundle, "context.resources.getStr…line_network_unavailable)");
        paramBundle = localb.aVp(paramBundle);
        paramContext = paramContext.getResources().getString(l.i.OLn);
        s.s(paramContext, "context.resources.getStr…network_unavailable_tips)");
        paramBundle.aVq(paramContext);
        continue;
        localb.Pko = bool;
        localb.Pkq = false;
        localb.Pkp = l.h.scan_no_network_error;
        paramBundle = paramContext.getResources().getString(l.i.OLp);
        s.s(paramBundle, "context.resources.getStr…can_offline_network_weak)");
        paramBundle = localb.aVp(paramBundle);
        paramContext = paramContext.getResources().getString(l.i.OLn);
        s.s(paramContext, "context.resources.getStr…network_unavailable_tips)");
        paramBundle.aVq(paramContext);
      }
    case 3: 
      if (paramBundle == null)
      {
        paramBundle = null;
        localObject1 = paramBundle;
        if (paramBundle == null) {}
        try
        {
          localObject1 = new byte[0];
          localObject2 = new qz();
          ((qz)localObject2).parseFrom((byte[])localObject1);
          paramBundle = ((qz)localObject2).YVU;
          if (paramBundle != null) {
            break label587;
          }
          paramBundle = null;
          localObject1 = ((qz)localObject2).YVU;
          if (localObject1 != null) {
            break label616;
          }
          localObject1 = localObject3;
          localb.Pko = bool;
          localObject2 = localb.f(new ai..ExternalSyntheticLambda1(this));
          ((a.b)localObject2).Pkp = l.h.scan_no_result_error;
          localObject3 = (CharSequence)paramBundle;
          if (localObject3 == null) {
            break;
          }
          if (((CharSequence)localObject3).length() != 0) {
            break label649;
          }
        }
        catch (Exception paramBundle)
        {
          Log.printErrStackTrace("MicroMsg.ScanInfoPageViewHelper", (Throwable)paramBundle, "buildViewParams parse BizScanBarcodeResponse from byte array exception", new Object[0]);
          localb.Pko = bool;
          paramBundle = localb.f(new ai..ExternalSyntheticLambda0(this));
          paramBundle.Pkp = l.h.scan_no_result_error;
          localObject1 = paramContext.getResources().getString(l.i.OKO);
          s.s(localObject1, "context.resources.getStr…scan_goods_title_default)");
          paramBundle = paramBundle.aVp((String)localObject1);
          paramContext = paramContext.getResources().getString(l.i.OKN);
          s.s(paramContext, "context.resources.getStr…_goods_sub_title_default)");
          paramBundle.aVq(paramContext);
        }
        if (paramInt != 0) {
          paramBundle = paramContext.getResources().getString(l.i.OKO);
        }
        s.s(paramBundle, "if (title.isNullOrEmpty(…title_default) else title");
        paramBundle = ((a.b)localObject2).aVp(paramBundle);
        localObject2 = (CharSequence)localObject1;
        paramInt = i;
        if (localObject2 != null) {
          if (((CharSequence)localObject2).length() != 0) {
            break label654;
          }
        }
      }
      for (paramInt = i;; paramInt = 0)
      {
        if (paramInt != 0) {
          localObject1 = paramContext.getResources().getString(l.i.OKN);
        }
        s.s(localObject1, "if (subTitle.isNullOrEmp…le_default) else subTitle");
        paramBundle.aVq((String)localObject1);
        break;
        break;
        paramBundle = paramBundle.getByteArray("key_scan_bar_code_response");
        break label274;
        paramBundle = (rs)p.ae((List)paramBundle, 0);
        if (paramBundle == null)
        {
          paramBundle = null;
          break label315;
        }
        paramBundle = paramBundle.YWE;
        break label315;
        localObject2 = (rs)p.ae((List)localObject1, 1);
        localObject1 = localObject3;
        if (localObject2 == null) {
          break label331;
        }
        localObject1 = ((rs)localObject2).YWE;
        break label331;
        paramInt = 0;
        break label385;
      }
    case 4: 
      label331:
      label616:
      if (paramBundle == null) {}
      label587:
      for (localObject1 = null;; localObject1 = paramBundle.getByteArray("key_scan_bar_code_response"))
      {
        if (localObject1 != null) {
          break label1083;
        }
        try
        {
          localObject1 = new byte[0];
        }
        catch (Exception paramBundle)
        {
          Log.printErrStackTrace("MicroMsg.ScanInfoPageViewHelper", (Throwable)paramBundle, "buildViewParams parse BizScanBarcodeResponse from byte array exception", new Object[0]);
          localb.Pko = bool;
          localb.Pkq = false;
          localb.Pkp = l.h.scan_no_result_error;
          paramBundle = paramContext.getResources().getString(l.i.OKR);
          s.s(paramBundle, "context.resources.getStr…scan_goods_title_default)");
          paramBundle = localb.aVp(paramBundle);
          paramContext = paramContext.getResources().getString(l.i.OKQ);
          s.s(paramContext, "context.resources.getStr…_goods_sub_title_default)");
          paramBundle.aVq(paramContext);
        }
        this.OSU = paramBundle;
        localObject3 = new qz();
        ((qz)localObject3).parseFrom((byte[])localObject1);
        paramBundle = ((qz)localObject3).YVU;
        if (paramBundle != null) {
          break label991;
        }
        paramBundle = null;
        localObject1 = ((qz)localObject3).YVU;
        if (localObject1 != null) {
          break label1020;
        }
        localObject1 = localObject2;
        label729:
        localb.Pko = bool;
        localb.Pkq = false;
        localb.Pkp = l.h.scan_no_result_error;
        localObject2 = (CharSequence)paramBundle;
        if (localObject2 == null) {
          break label1078;
        }
        if (((CharSequence)localObject2).length() != 0) {
          break label1053;
        }
        break label1078;
        if (paramInt != 0) {
          paramBundle = paramContext.getResources().getString(l.i.OKR);
        }
        s.s(paramBundle, "if (title.isNullOrEmpty(…title_default) else title");
        paramBundle = localb.aVp(paramBundle);
        localObject2 = (CharSequence)localObject1;
        paramInt = j;
        if (localObject2 != null)
        {
          if (((CharSequence)localObject2).length() != 0) {
            break label1058;
          }
          paramInt = j;
        }
        if (paramInt != 0) {
          localObject1 = paramContext.getResources().getString(l.i.OKQ);
        }
        s.s(localObject1, "if (subTitle.isNullOrEmp…le_default) else subTitle");
        paramBundle.aVq((String)localObject1);
        break;
        break;
      }
    }
    label385:
    label649:
    label654:
    label679:
    label1078:
    label1083:
    label1084:
    for (;;)
    {
      label831:
      localObject3 = paramBundle.getString("key_scan_bar_code_string");
      paramBundle = (Bundle)localObject3;
      if (localObject3 != null) {
        break label679;
      }
      paramBundle = "";
      break label679;
      label991:
      paramBundle = (rs)p.ae((List)paramBundle, 0);
      if (paramBundle == null)
      {
        paramBundle = null;
        break label713;
      }
      paramBundle = paramBundle.YWE;
      break label713;
      label1020:
      localObject3 = (rs)p.ae((List)localObject1, 1);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label729;
      }
      localObject1 = ((rs)localObject3).YWE;
      break label729;
      paramInt = 0;
      break label774;
      paramInt = 0;
      break label831;
      paramInt = 1;
      break;
      for (;;)
      {
        if (paramBundle != null) {
          break label1084;
        }
        paramBundle = "";
        break;
        paramInt = 1;
        break label774;
      }
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(314256);
    s.u(paramh, "scanUIModel");
    this.OSN = paramh;
    AppMethodBeat.o(314256);
  }
  
  public final void a(BaseScanMaskView<BaseScanRequest> paramBaseScanMaskView, ScanSharedMaskView paramScanSharedMaskView, ScanInfoMaskView paramScanInfoMaskView)
  {
    this.OSO = paramBaseScanMaskView;
    this.OSP = paramScanSharedMaskView;
    this.OSQ = paramScanInfoMaskView;
  }
  
  public final void aL(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(314259);
    Object localObject;
    if (this.OSR != paramBoolean1)
    {
      if (paramBoolean1)
      {
        localObject = this.OSO;
        if (localObject != null) {
          break label120;
        }
        localObject = null;
        ScanInfoMaskView localScanInfoMaskView = this.OSQ;
        if (localScanInfoMaskView != null) {
          localScanInfoMaskView.setAnchorView((View)localObject);
        }
      }
      this.OSR = paramBoolean1;
      localObject = this.OSP;
      if (localObject != null) {
        if (paramBoolean1) {
          break label130;
        }
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      ((ScanSharedMaskView)localObject).Cv(bool);
      localObject = this.OSQ;
      if (localObject != null) {
        ((ScanInfoMaskView)localObject).aL(paramBoolean1, paramBoolean2);
      }
      localObject = this.OSO;
      if (localObject != null) {
        ((BaseScanMaskView)localObject).Co(paramBoolean1);
      }
      AppMethodBeat.o(314259);
      return;
      label120:
      localObject = ((BaseScanMaskView)localObject).getTargetSuccessMarkView();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ai
 * JD-Core Version:    0.7.0.1
 */