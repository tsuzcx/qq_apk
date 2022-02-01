package com.tencent.mm.plugin.scanner.e;

import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.protocal.protobuf.nn;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy;", "", "getCDNImageInfoList", "", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "getCDNInfoCallback", "Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "name", "", "GetCDNInfoCallback", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface k
{
  public abstract void a(e parame, a parama);
  
  public abstract String name();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/IAiScanImageCDNStrategy$GetCDNInfoCallback;", "", "onCDNUploadStart", "", "mediaId", "", "onError", "errType", "", "errCode", "errMsg", "onGetCDNInfoResult", "cdnList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "Lkotlin/collections/ArrayList;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void aUE(String paramString);
    
    public abstract void bx(ArrayList<nn> paramArrayList);
    
    public abstract void j(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.k
 * JD-Core Version:    0.7.0.1
 */