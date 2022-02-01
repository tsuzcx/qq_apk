package com.tencent.mm.plugin.webview.ui.tools.browser.model;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;", "", "dismissDialog", "", "dialog", "Landroid/app/Dialog;", "withAnimation", "", "finishUI", "resultCode", "", "data", "Landroid/content/Intent;", "getTargetIntent", "getUIContext", "Landroid/content/Context;", "showDialog", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract void e(Dialog paramDialog);
  
  public abstract Context getUIContext();
  
  public abstract Intent izK();
  
  public abstract void u(int paramInt, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.model.a
 * JD-Core Version:    0.7.0.1
 */