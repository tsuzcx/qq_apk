package com.tencent.mm.plugin.scanner.f;

import com.tencent.mm.plugin.scanner.box.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel;", "", "getBackgroundOpView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "getImageScaleInfo", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel$ImageScaleInfo;", "isDialogMoving", "", "reset", "", "showBackgroundOpView", "show", "ImageScaleInfo", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g
{
  public abstract void Cc(boolean paramBoolean);
  
  public abstract b gRA();
  
  public abstract boolean gRy();
  
  public abstract a gRz();
  
  public abstract void reset();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel$ImageScaleInfo;", "", "()V", "isLongImage", "", "()Z", "setLongImage", "(Z)V", "showDefaultScale", "", "getShowDefaultScale", "()F", "setShowDefaultScale", "(F)V", "showDoubleScale", "getShowDoubleScale", "setShowDoubleScale", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    boolean OUR;
    float OUS = 2.0F;
    float OUT = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.g
 * JD-Core Version:    0.7.0.1
 */