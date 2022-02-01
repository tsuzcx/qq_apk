package com.tencent.mm.plugin.scanner.scan_goods_new.b;

import com.tencent.mm.plugin.scanner.scan_goods_new.a;
import com.tencent.mm.plugin.scanner.scan_goods_new.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/BaseAiScanImageTask;", "T", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageBaseRequest;", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/task/AiScanImageTask;", "()V", "finished", "", "getFinished", "()Z", "setFinished", "(Z)V", "fillBaseInfo", "", "request", "productItem", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;", "(Lcom/tencent/mm/plugin/scanner/scan_goods_new/AiScanImageBaseRequest;Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;)V", "isFinished", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e<T extends a>
  implements c
{
  private boolean mhq;
  
  protected final void Cd(boolean paramBoolean)
  {
    this.mhq = paramBoolean;
  }
  
  protected void a(T paramT, h paramh)
  {
    s.u(paramT, "request");
    s.u(paramh, "productItem");
    paramh.source = paramT.source;
    paramh.hBk = paramT.hBk;
    paramh.OVD = paramT.gRK();
  }
  
  protected final boolean gSg()
  {
    return this.mhq;
  }
  
  protected final boolean isFinished()
  {
    return this.mhq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.b.e
 * JD-Core Version:    0.7.0.1
 */