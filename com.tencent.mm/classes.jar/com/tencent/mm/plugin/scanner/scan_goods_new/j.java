package com.tencent.mm.plugin.scanner.scan_goods_new;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ScanProductInfo;
import com.tencent.mm.plugin.scanner.model.d.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo;", "", "scanProductInfo", "Lcom/tencent/mm/plugin/scanner/model/ScanProductInfo;", "(Lcom/tencent/mm/plugin/scanner/model/ScanProductInfo;)V", "clientLogInfo", "Lcom/tencent/mm/plugin/scanner/model/CameraScanCombineClientLogReporter$ClientLogInfo;", "getClientLogInfo", "()Lcom/tencent/mm/plugin/scanner/model/CameraScanCombineClientLogReporter$ClientLogInfo;", "setClientLogInfo", "(Lcom/tencent/mm/plugin/scanner/model/CameraScanCombineClientLogReporter$ClientLogInfo;)V", "imageDetectByServer", "", "getImageDetectByServer", "()Z", "setImageDetectByServer", "(Z)V", "imageEncodeType", "", "getImageEncodeType", "()I", "setImageEncodeType", "(I)V", "jpgImageDataForScanFile", "", "getJpgImageDataForScanFile", "()[B", "setJpgImageDataForScanFile", "([B)V", "performance", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo$Performance;", "getPerformance", "()Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo$Performance;", "setPerformance", "(Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo$Performance;)V", "getScanProductInfo", "()Lcom/tencent/mm/plugin/scanner/model/ScanProductInfo;", "showImageData", "getShowImageData", "setShowImageData", "Performance", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public int ORl;
  public byte[] OWb;
  public d.a OWg;
  public final ScanProductInfo OWh;
  public boolean OWi;
  public byte[] OWj;
  public a OWk;
  
  public j(ScanProductInfo paramScanProductInfo)
  {
    AppMethodBeat.i(313861);
    this.OWh = paramScanProductInfo;
    this.ORl = -1;
    this.OWk = new a();
    AppMethodBeat.o(313861);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo$Performance;", "", "()V", "addQueueTime", "", "getAddQueueTime", "()J", "setAddQueueTime", "(J)V", "detectDuration", "getDetectDuration", "setDetectDuration", "detectSession", "", "getDetectSession", "()Ljava/lang/String;", "setDetectSession", "(Ljava/lang/String;)V", "encodeDuration", "getEncodeDuration", "setEncodeDuration", "encodeSize", "", "getEncodeSize", "()I", "setEncodeSize", "(I)V", "imgCropDuration", "getImgCropDuration", "setImgCropDuration", "itemSource", "getItemSource", "setItemSource", "modelVersion", "getModelVersion", "setModelVersion", "queueDuration", "getQueueDuration", "setQueueDuration", "retrievalDuration", "getRetrievalDuration", "setRetrievalDuration", "scanCodeFrameCost", "getScanCodeFrameCost", "setScanCodeFrameCost", "scanProductSkipFrameCount", "getScanProductSkipFrameCount", "setScanProductSkipFrameCount", "startRetrievalTime", "getStartRetrievalTime", "setStartRetrievalTime", "startUploadTime", "getStartUploadTime", "setStartUploadTime", "uploadDuration", "getUploadDuration", "setUploadDuration", "uploadEncodeType", "getUploadEncodeType", "setUploadEncodeType", "copy", "toCopyPerformance", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a OWl;
    public int OOK;
    public int OPw;
    long OWm;
    long OWn;
    long OWo;
    public String OWp = "";
    public int OWq;
    public long OWr;
    public long OWs;
    public long OWt;
    public int OWu;
    public long OWv;
    public long OWw;
    public long OWx;
    public int OWy;
    public int OWz;
    
    static
    {
      AppMethodBeat.i(313837);
      OWl = new a((byte)0);
      AppMethodBeat.o(313837);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRequestInfo$Performance$Companion;", "", "()V", "ENCODE_TYPE_JPEG", "", "ENCODE_TYPE_WEBP", "ENCODE_TYPE_WXAM", "ENCODE_TYPE_WXAM_FAILED_USE_JPEG", "SOURCE_DETECT_SERVER_BY_ENGINE", "SOURCE_LOCAL", "SOURCE_SERVICE", "transformItemStatus", "svrItemStatus", "transformReportEncodeImageType", "uploadEncodeImageType", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static int aim(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          return 2;
        case 2: 
          return 1;
        }
        return 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.j
 * JD-Core Version:    0.7.0.1
 */