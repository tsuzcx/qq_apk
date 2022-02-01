package com.tencent.mm.plugin.scanner.box;

import android.content.DialogInterface;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "exitType", "", "onShow", "plugin-scan_release"})
public abstract interface g
{
  public abstract void a(DialogInterface paramDialogInterface, int paramInt);
  
  public abstract void onCancel(DialogInterface paramDialogInterface);
  
  public abstract void onShow(DialogInterface paramDialogInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.g
 * JD-Core Version:    0.7.0.1
 */