package com.tencent.mm.plugin.scanner.e;

import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.protocal.protobuf.mi;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy;", "", "getCDNImageInfoList", "", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "getCDNInfoCallback", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "name", "", "GetCDNInfoCallback", "plugin-scan_release"})
public abstract interface k
{
  public abstract void a(e parame, a parama);
  
  public abstract String name();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "", "onCDNUploadStart", "", "mediaId", "", "onError", "errType", "", "errCode", "errMsg", "onGetCDNInfoResult", "cdnList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "Lkotlin/collections/ArrayList;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void aXd(String paramString);
    
    public abstract void aZ(ArrayList<mi> paramArrayList);
    
    public abstract void i(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.k
 * JD-Core Version:    0.7.0.1
 */