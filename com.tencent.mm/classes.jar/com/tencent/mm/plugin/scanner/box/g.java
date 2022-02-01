package com.tencent.mm.plugin.scanner.box;

import android.content.DialogInterface;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "exitType", "", "onShow", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g
{
  public abstract void L(DialogInterface paramDialogInterface, int paramInt);
  
  public abstract void onCancel(DialogInterface paramDialogInterface);
  
  public abstract void onShow(DialogInterface paramDialogInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.g
 * JD-Core Version:    0.7.0.1
 */