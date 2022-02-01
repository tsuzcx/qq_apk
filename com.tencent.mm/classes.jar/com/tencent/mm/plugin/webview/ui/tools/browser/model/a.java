package com.tencent.mm.plugin.webview.ui.tools.browser.model;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;", "", "dismissDialog", "", "dialog", "Landroid/app/Dialog;", "withAnimation", "", "finishUI", "resultCode", "", "data", "Landroid/content/Intent;", "getTargetIntent", "getUIContext", "Landroid/content/Context;", "showDialog", "plugin-webview_release"})
public abstract interface a
{
  public abstract void e(Dialog paramDialog);
  
  public abstract Intent gZH();
  
  public abstract Context getUIContext();
  
  public abstract void r(int paramInt, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.model.a
 * JD-Core Version:    0.7.0.1
 */