package com.tencent.mm.plugin.scanner.e;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckResult;", "", "errType", "", "errCode", "(II)V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "checkSuccess", "", "getCheckSuccess", "()Z", "setCheckSuccess", "(Z)V", "compressType", "getCompressType", "()I", "setCompressType", "(I)V", "getErrCode", "getErrType", "fileId", "getFileId", "setFileId", "plugin-scan_release"})
public final class h
{
  boolean IJN;
  String aesKey;
  final int errCode;
  final int errType;
  String fileId;
  int lNK;
  
  public h(int paramInt1, int paramInt2)
  {
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.fileId = "";
    this.aesKey = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.h
 * JD-Core Version:    0.7.0.1
 */