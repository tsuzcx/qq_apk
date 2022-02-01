package com.tencent.mm.plugin.scanner.f;

import com.tencent.mm.plugin.scanner.api.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListener;", "", "onCancel", "", "session", "", "onDialogCancel", "dialog", "Landroid/content/DialogInterface;", "onDialogDismiss", "exitType", "", "onDialogShow", "onError", "errType", "errCode", "onGetOCRResult", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onStart", "onZoomIn", "zoomOrigin", "onZoomOut", "ZoomOrigin", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
{
  public abstract void a(f paramf);
  
  public abstract void aif(int paramInt);
  
  public abstract void aig(int paramInt);
  
  public abstract void aih(int paramInt);
  
  public abstract void gPF();
  
  public abstract void onError(int paramInt1, int paramInt2);
  
  public abstract void rl(long paramLong);
  
  public abstract void tZ(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.c
 * JD-Core Version:    0.7.0.1
 */