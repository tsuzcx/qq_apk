package com.tencent.mm.plugin.scanner.model;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ui.widget.ScanNetworkMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.b.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/ScanNetworkViewHelper;", "", "()V", "isLoadingShow", "", "loadingCancelListener", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;", "networkMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanNetworkMaskView;", "scanMaskView", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "sharedMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "cancelLoading", "", "setOnCancelListener", "cancelListener", "setScanMaskView", "showLoadingView", "show", "withAnimation", "showNetworkUnconnectedView", "showNetworkWeakView", "Companion", "plugin-scan_release"})
public final class v
{
  public static final a vPo;
  public BaseScanMaskView vPj;
  public ScanSharedMaskView vPk;
  public ScanNetworkMaskView vPl;
  public boolean vPm;
  public b.a vPn;
  
  static
  {
    AppMethodBeat.i(170035);
    vPo = new a((byte)0);
    AppMethodBeat.o(170035);
  }
  
  public final void V(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(170034);
    Object localObject1;
    Object localObject2;
    if (paramBoolean1)
    {
      localObject1 = this.vPj;
      if (localObject1 == null) {
        break label153;
      }
      localObject1 = ((BaseScanMaskView)localObject1).getTargetSuccessMarkView();
      localObject2 = this.vPl;
      if (localObject2 != null) {
        ((ScanNetworkMaskView)localObject2).setSuccessMarkView((View)localObject1);
      }
    }
    if (this.vPm != paramBoolean1)
    {
      this.vPm = paramBoolean1;
      localObject1 = this.vPk;
      boolean bool;
      if (localObject1 != null)
      {
        if (!paramBoolean1)
        {
          bool = true;
          label75:
          ((ScanSharedMaskView)localObject1).pk(bool);
        }
      }
      else
      {
        localObject1 = this.vPl;
        if (localObject1 != null)
        {
          if (!paramBoolean1) {
            break label173;
          }
          if (((ScanNetworkMaskView)localObject1).vYU != null)
          {
            if ((localObject1.vYW[0] != 0) || (localObject1.vYW[1] != 0)) {
              break label164;
            }
            ((ScanNetworkMaskView)localObject1).vZf = true;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.vPj;
        if (localObject1 == null) {
          break label230;
        }
        ((BaseScanMaskView)localObject1).pf(paramBoolean1);
        AppMethodBeat.o(170034);
        return;
        label153:
        localObject1 = null;
        break;
        bool = false;
        break label75;
        label164:
        ((ScanNetworkMaskView)localObject1).ph(paramBoolean2);
        continue;
        label173:
        ((ScanNetworkMaskView)localObject1).setVisibility(8);
        ((ScanNetworkMaskView)localObject1).vPm = false;
        localObject2 = ((ScanNetworkMaskView)localObject1).ruE;
        if (localObject2 == null) {
          k.aPZ("loadingLayout");
        }
        ((View)localObject2).setVisibility(8);
        localObject1 = ((ScanNetworkMaskView)localObject1).vYX;
        if (localObject1 != null) {
          ((Animation)localObject1).cancel();
        }
      }
    }
    label230:
    AppMethodBeat.o(170034);
  }
  
  public final void a(BaseScanMaskView paramBaseScanMaskView, ScanSharedMaskView paramScanSharedMaskView, ScanNetworkMaskView paramScanNetworkMaskView)
  {
    this.vPj = paramBaseScanMaskView;
    this.vPk = paramScanSharedMaskView;
    this.vPl = paramScanNetworkMaskView;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/ScanNetworkViewHelper$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.v
 * JD-Core Version:    0.7.0.1
 */