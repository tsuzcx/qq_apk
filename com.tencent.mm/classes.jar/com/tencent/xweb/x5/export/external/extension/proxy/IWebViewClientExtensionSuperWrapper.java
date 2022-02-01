package com.tencent.xweb.x5.export.external.extension.proxy;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;

public abstract interface IWebViewClientExtensionSuperWrapper
{
  public abstract Object B(String paramString, Bundle paramBundle);
  
  public abstract void Pa(boolean paramBoolean);
  
  public abstract Object a(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4);
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView);
  
  public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView);
  
  public abstract void a(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3);
  
  public abstract void a(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt);
  
  public abstract void a(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt);
  
  public abstract void a(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  public abstract boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView);
  
  public abstract boolean a(String paramString, JsResult paramJsResult);
  
  public abstract boolean a(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean);
  
  public abstract void aJI(int paramInt);
  
  public abstract void aJJ(int paramInt);
  
  public abstract void af(int paramInt1, int paramInt2, String paramString);
  
  public abstract void b(int paramInt1, int paramInt2, String paramString, boolean paramBoolean);
  
  public abstract boolean b(MotionEvent paramMotionEvent, View paramView);
  
  public abstract void bIl(String paramString);
  
  public abstract void bK(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void bX(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean c(MotionEvent paramMotionEvent, View paramView);
  
  public abstract boolean d(MotionEvent paramMotionEvent, View paramView);
  
  public abstract void ew(int paramInt, String paramString);
  
  public abstract void ex(int paramInt, String paramString);
  
  public abstract void i(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  public abstract void kiL();
  
  public abstract void kiM();
  
  public abstract void kiN();
  
  public abstract void kiO();
  
  public abstract void kiP();
  
  public abstract void kiQ();
  
  public abstract void kiR();
  
  public abstract void kiS();
  
  public abstract void kiT();
  
  public abstract void kiU();
  
  public abstract boolean kiV();
  
  public abstract void kiW();
  
  public abstract void kiX();
  
  public abstract void kiY();
  
  public abstract void m(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void mP(View paramView);
  
  public abstract void qg(int paramInt1, int paramInt2);
  
  public abstract void re(String paramString1, String paramString2);
  
  public abstract boolean rf(String paramString1, String paramString2);
  
  public abstract void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.xweb.x5.export.external.extension.proxy.IWebViewClientExtensionSuperWrapper
 * JD-Core Version:    0.7.0.1
 */