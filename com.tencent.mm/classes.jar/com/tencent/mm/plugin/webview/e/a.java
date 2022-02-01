package com.tencent.mm.plugin.webview.e;

import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "T", "", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthStart", "onContentRedirect", "content", "onError", "errType", "errCode", "errMsg", "onPermissionUpdate", "fullUrl", "response", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "onProcessResult", "", "(ILjava/lang/String;Ljava/lang/Object;)Z", "onUrlRedirect", "forceRedirect", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "webview-sdk_release"})
public abstract interface a<T>
{
  public abstract void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, T paramT);
  
  public abstract void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2, T paramT);
  
  public abstract boolean b(int paramInt, String paramString, T paramT);
  
  public abstract void bl(int paramInt, String paramString);
  
  public abstract void bm(int paramInt, String paramString);
  
  public abstract void z(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.a
 * JD-Core Version:    0.7.0.1
 */