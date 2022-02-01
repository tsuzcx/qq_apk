package com.tencent.mm.plugin.websearch.webview;

import android.content.Context;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/IWebSearchUIComponent;", "T", "Lcom/tencent/mm/plugin/websearch/webview/IMultiProcessWebSearchUIComponent;", "getActivityContext", "Landroid/content/Context;", "getDataContext", "()Ljava/lang/Object;", "getWebSearchData", "Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchData;", "getWebSearchJSApi", "Lcom/tencent/mm/plugin/websearch/webview/BaseWebSearchJSApi;", "hideVKB", "", "showVKB", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f<T>
  extends c
{
  public abstract T fyQ();
  
  public abstract a<T> fyS();
  
  public abstract b<T> fyU();
  
  public abstract Context getActivityContext();
  
  public abstract void hideVKB();
  
  public abstract void showVKB();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.f
 * JD-Core Version:    0.7.0.1
 */