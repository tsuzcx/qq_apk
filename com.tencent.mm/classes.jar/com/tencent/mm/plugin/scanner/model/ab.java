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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanNetworkViewHelper;", "", "()V", "isLoadingShow", "", "loadingCancelListener", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;", "networkMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView;", "scanMaskView", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "sharedMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "cancelLoading", "", "setOnCancelListener", "cancelListener", "setScanMaskView", "showLoadingView", "show", "withAnimation", "showNetworkUnconnectedView", "showTips", "showNetworkWeakView", "Companion", "plugin-scan_release"})
public final class ab
{
  public static final ab.a yDS;
  public BaseScanMaskView<BaseScanRequest> yDN;
  public ScanSharedMaskView yDO;
  public ScanNetworkMaskView yDP;
  public boolean yDQ;
  public b.a yDR;
  
  static
  {
    AppMethodBeat.i(170035);
    yDS = new ab.a((byte)0);
    AppMethodBeat.o(170035);
  }
  
  public final void a(BaseScanMaskView<BaseScanRequest> paramBaseScanMaskView, ScanSharedMaskView paramScanSharedMaskView, ScanNetworkMaskView paramScanNetworkMaskView)
  {
    this.yDN = paramBaseScanMaskView;
    this.yDO = paramScanSharedMaskView;
    this.yDP = paramScanNetworkMaskView;
  }
  
  public final void ab(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(170034);
    Object localObject1;
    Object localObject2;
    if (paramBoolean1)
    {
      localObject1 = this.yDN;
      if (localObject1 == null) {
        break label153;
      }
      localObject1 = ((BaseScanMaskView)localObject1).getTargetSuccessMarkView();
      localObject2 = this.yDP;
      if (localObject2 != null) {
        ((ScanNetworkMaskView)localObject2).setSuccessMarkView((View)localObject1);
      }
    }
    if (this.yDQ != paramBoolean1)
    {
      this.yDQ = paramBoolean1;
      localObject1 = this.yDO;
      boolean bool;
      if (localObject1 != null)
      {
        if (!paramBoolean1)
        {
          bool = true;
          label75:
          ((ScanSharedMaskView)localObject1).qP(bool);
        }
      }
      else
      {
        localObject1 = this.yDP;
        if (localObject1 != null)
        {
          if (!paramBoolean1) {
            break label173;
          }
          if (((ScanNetworkMaskView)localObject1).yOc != null)
          {
            if ((localObject1.yOe[0] != 0) || (localObject1.yOe[1] != 0)) {
              break label164;
            }
            ((ScanNetworkMaskView)localObject1).yOn = true;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.yDN;
        if (localObject1 == null) {
          break label230;
        }
        ((BaseScanMaskView)localObject1).qI(paramBoolean1);
        AppMethodBeat.o(170034);
        return;
        label153:
        localObject1 = null;
        break;
        bool = false;
        break label75;
        label164:
        ((ScanNetworkMaskView)localObject1).qL(paramBoolean2);
        continue;
        label173:
        ((ScanNetworkMaskView)localObject1).setVisibility(8);
        ((ScanNetworkMaskView)localObject1).yDQ = false;
        localObject2 = ((ScanNetworkMaskView)localObject1).tLc;
        if (localObject2 == null) {
          p.bdF("loadingLayout");
        }
        ((View)localObject2).setVisibility(8);
        localObject1 = ((ScanNetworkMaskView)localObject1).yOf;
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
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ab
 * JD-Core Version:    0.7.0.1
 */