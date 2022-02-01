package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.scanlib.ui.ScanView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/IScanUIModel;", "", "enableScanCodeProductMerge", "", "getCurrentScanMaskView", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "getScanProductListState", "", "getScanView", "Lcom/tencent/scanlib/ui/ScanView;", "getUIContext", "Landroid/content/Context;", "isActivityFinishing", "isFlashOpen", "onPreviewReady", "", "isSwitchTab", "pauseScan", "resumeScan", "switchTab", "mode", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h
{
  public abstract void gQK();
  
  public abstract void gQL();
  
  public abstract void gQM();
  
  public abstract ScanView gQN();
  
  public abstract boolean gQO();
  
  public abstract BaseScanMaskView<?> gQP();
  
  public abstract boolean gQQ();
  
  public abstract int gQR();
  
  public abstract boolean gQS();
  
  public abstract Context getUIContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.h
 * JD-Core Version:    0.7.0.1
 */