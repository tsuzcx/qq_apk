package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.e;
import org.xwalk.core.XWalkView;

public final class f
  implements com.tencent.xweb.c.f
{
  j xlU;
  k xlV;
  XWalkView xlW;
  
  public f(XWalkView paramXWalkView)
  {
    this.xlW = paramXWalkView;
    this.xlU = new j(paramXWalkView);
    this.xlV = new k(paramXWalkView);
  }
  
  public final boolean a(String paramString1, String paramString2, com.tencent.xweb.f paramf)
  {
    if ((paramf instanceof e.c)) {
      return this.xlU.b(this.xlW, paramString1, paramString2, ((e.c)paramf).xlS);
    }
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, e parame)
  {
    if ((parame instanceof e.d)) {
      return this.xlU.a(this.xlW, paramString1, paramString2, paramString3, ((e.d)parame).xlS);
    }
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, com.tencent.xweb.f paramf)
  {
    if ((paramf instanceof e.c)) {
      return this.xlU.a(this.xlW, paramString1, paramString2, ((e.c)paramf).xlS);
    }
    return false;
  }
  
  public final void onHideCustomView()
  {
    this.xlU.cTw();
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if ((paramCustomViewCallback instanceof e.a)) {
      this.xlU.a(paramView, ((e.a)paramCustomViewCallback).xlQ);
    }
  }
  
  public final void u(String paramString, Bitmap paramBitmap)
  {
    this.xlU.a(this.xlW, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.f
 * JD-Core Version:    0.7.0.1
 */