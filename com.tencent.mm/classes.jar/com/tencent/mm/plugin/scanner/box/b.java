package com.tencent.mm.plugin.scanner.box;

import android.content.DialogInterface;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogEventListener;", "", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "exitType", "", "onShow", "plugin-scan_release"})
public abstract interface b
{
  public abstract void a(DialogInterface paramDialogInterface, int paramInt);
  
  public abstract void onCancel(DialogInterface paramDialogInterface);
  
  public abstract void onShow(DialogInterface paramDialogInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.b
 * JD-Core Version:    0.7.0.1
 */