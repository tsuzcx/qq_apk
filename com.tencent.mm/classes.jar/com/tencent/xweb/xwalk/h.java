package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.internal.e;
import org.xwalk.core.XWalkView;

public final class h
  implements e
{
  m SGX;
  o SGY;
  XWalkView SGZ;
  
  public h(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(154285);
    this.SGZ = paramXWalkView;
    this.SGX = new m(paramXWalkView);
    this.SGY = new o(paramXWalkView);
    AppMethodBeat.o(154285);
  }
  
  public final boolean a(String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(154289);
    if ((paramJsResult instanceof g.c))
    {
      boolean bool = this.SGX.b(this.SGZ, paramString1, paramString2, ((g.c)paramJsResult).SGT);
      AppMethodBeat.o(154289);
      return bool;
    }
    AppMethodBeat.o(154289);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, com.tencent.xweb.o paramo)
  {
    AppMethodBeat.i(154291);
    if ((paramo instanceof g.e))
    {
      boolean bool = this.SGX.a(this.SGZ, paramString1, paramString2, paramString3, ((g.e)paramo).SGT);
      AppMethodBeat.o(154291);
      return bool;
    }
    AppMethodBeat.o(154291);
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(154290);
    if ((paramJsResult instanceof g.c))
    {
      boolean bool = this.SGX.a(this.SGZ, paramString1, paramString2, ((g.c)paramJsResult).SGT);
      AppMethodBeat.o(154290);
      return bool;
    }
    AppMethodBeat.o(154290);
    return false;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(154288);
    this.SGX.huJ();
    AppMethodBeat.o(154288);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(154287);
    if ((paramCustomViewCallback instanceof g.a)) {
      this.SGX.a(paramView, ((g.a)paramCustomViewCallback).SGR);
    }
    AppMethodBeat.o(154287);
  }
  
  public final void y(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(154286);
    this.SGX.a(this.SGZ, paramString);
    AppMethodBeat.o(154286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h
 * JD-Core Version:    0.7.0.1
 */