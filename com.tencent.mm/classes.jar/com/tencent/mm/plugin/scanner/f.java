package com.tencent.mm.plugin.scanner;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.plugin.scanner.util.p;

public abstract interface f
  extends d
{
  public abstract String genScanCaptureImgPath(String paramString);
  
  public abstract String genScanTmpImgPath(String paramString);
  
  public abstract String getAccScannerPath();
  
  public abstract p getScanCdnService();
  
  public abstract String getScanImageSaveDir();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f
 * JD-Core Version:    0.7.0.1
 */