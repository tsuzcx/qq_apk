package com.tencent.mm.plugin.scanner;

import com.tencent.mm.plugin.scanner.util.m;

public abstract interface d
  extends com.tencent.mm.kernel.b.d
{
  public abstract String genScanCaptureImgPath(String paramString);
  
  public abstract String genScanTmpImgPath(String paramString);
  
  public abstract String getAccScannerPath();
  
  public abstract m getScanCdnService();
  
  public abstract String getScanImageSaveDir();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d
 * JD-Core Version:    0.7.0.1
 */