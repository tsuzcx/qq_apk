package com.tencent.mm.plugin.scanner.util.a;

import android.graphics.Bitmap;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/compress/ScanImageCompressStrategy;", "T", "", "computeSampleSize", "", "request", "width", "height", "(Ljava/lang/Object;II)I", "isSizeValid", "", "name", "", "onTransform", "Landroid/graphics/Bitmap;", "bitmap", "(Ljava/lang/Object;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "scan-sdk_release"})
public abstract interface i<T>
{
  public abstract Bitmap a(T paramT, Bitmap paramBitmap);
  
  public abstract int d(T paramT, int paramInt1, int paramInt2);
  
  public abstract boolean jo(int paramInt1, int paramInt2);
  
  public abstract String name();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a.i
 * JD-Core Version:    0.7.0.1
 */