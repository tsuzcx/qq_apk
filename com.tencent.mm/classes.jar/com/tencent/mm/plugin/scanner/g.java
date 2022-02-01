package com.tencent.mm.plugin.scanner;

import com.tencent.mm.kernel.b.d;

public abstract interface g
  extends d
{
  public abstract String genScanCaptureImgPath(String paramString);
  
  public abstract String genScanTmpImgPath(String paramString);
  
  public abstract String genScanTmpImgPath(String paramString1, String paramString2);
  
  public abstract String getAccScannerPath();
  
  public abstract String getScanImageSaveDir();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.g
 * JD-Core Version:    0.7.0.1
 */