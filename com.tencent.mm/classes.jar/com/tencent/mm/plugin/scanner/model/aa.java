package com.tencent.mm.plugin.scanner.model;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.ui.widget.ScanNetworkMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.b.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanNetworkViewHelper;", "", "()V", "isLoadingShow", "", "loadingCancelListener", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;", "networkMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView;", "scanMaskView", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "sharedMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "cancelLoading", "", "setOnCancelListener", "cancelListener", "setScanMaskView", "showLoadingView", "show", "withAnimation", "showNetworkUnconnectedView", "showTips", "showNetworkWeakView", "Companion", "plugin-scan_release"})
public final class aa
{
  public static final aa.a ynT;
  public BaseScanMaskView<BaseScanRequest> ynO;
  public ScanSharedMaskView ynP;
  public ScanNetworkMaskView ynQ;
  public boolean ynR;
  public b.a ynS;
  
  static
  {
    AppMethodBeat.i(170035);
    ynT = new aa.a((byte)0);
    AppMethodBeat.o(170035);
  }
  
  public final void a(BaseScanMaskView<BaseScanRequest> paramBaseScanMaskView, ScanSharedMaskView paramScanSharedMaskView, ScanNetworkMaskView paramScanNetworkMaskView)
  {
    this.ynO = paramBaseScanMaskView;
    this.ynP = paramScanSharedMaskView;
    this.ynQ = paramScanNetworkMaskView;
  }
  
  public final void ac(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(170034);
    Object localObject1;
    Object localObject2;
    if (paramBoolean1)
    {
      localObject1 = this.ynO;
      if (localObject1 == null) {
        break label153;
      }
      localObject1 = ((BaseScanMaskView)localObject1).getTargetSuccessMarkView();
      localObject2 = this.ynQ;
      if (localObject2 != null) {
        ((ScanNetworkMaskView)localObject2).setSuccessMarkView((View)localObject1);
      }
    }
    if (this.ynR != paramBoolean1)
    {
      this.ynR = paramBoolean1;
      localObject1 = this.ynP;
      boolean bool;
      if (localObject1 != null)
      {
        if (!paramBoolean1)
        {
          bool = true;
          label75:
          ((ScanSharedMaskView)localObject1).qI(bool);
        }
      }
      else
      {
        localObject1 = this.ynQ;
        if (localObject1 != null)
        {
          if (!paramBoolean1) {
            break label173;
          }
          if (((ScanNetworkMaskView)localObject1).yyc != null)
          {
            if ((localObject1.yye[0] != 0) || (localObject1.yye[1] != 0)) {
              break label164;
            }
            ((ScanNetworkMaskView)localObject1).yyn = true;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.ynO;
        if (localObject1 == null) {
          break label230;
        }
        ((BaseScanMaskView)localObject1).qB(paramBoolean1);
        AppMethodBeat.o(170034);
        return;
        label153:
        localObject1 = null;
        break;
        bool = false;
        break label75;
        label164:
        ((ScanNetworkMaskView)localObject1).qE(paramBoolean2);
        continue;
        label173:
        ((ScanNetworkMaskView)localObject1).setVisibility(8);
        ((ScanNetworkMaskView)localObject1).ynR = false;
        localObject2 = ((ScanNetworkMaskView)localObject1).tAl;
        if (localObject2 == null) {
          p.bcb("loadingLayout");
        }
        ((View)localObject2).setVisibility(8);
        localObject1 = ((ScanNetworkMaskView)localObject1).yyf;
        if (localObject1 != null) {
          ((Animation)localObject1).cancel();
        }
      }
    }
    label230:
    AppMethodBeat.o(170034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.aa
 * JD-Core Version:    0.7.0.1
 */