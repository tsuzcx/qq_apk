package com.tencent.mm.plugin.webview.e;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "T", "", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "onProcessResult", "", "(ILjava/lang/String;Ljava/lang/Object;)Z", "onUrlRedirect", "forceRedirect", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a<T>
{
  public abstract void J(int paramInt, String paramString1, String paramString2);
  
  public abstract void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, T paramT);
  
  public abstract void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2, T paramT);
  
  public abstract boolean b(int paramInt, String paramString, T paramT);
  
  public abstract void ca(int paramInt, String paramString);
  
  public abstract void cb(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.a
 * JD-Core Version:    0.7.0.1
 */