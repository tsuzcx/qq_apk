package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.internal.e;
import org.xwalk.core.XWalkView;

public final class g
  implements e
{
  l ITK;
  n ITL;
  XWalkView ITM;
  
  public g(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(154285);
    this.ITM = paramXWalkView;
    this.ITK = new l(paramXWalkView);
    this.ITL = new n(paramXWalkView);
    AppMethodBeat.o(154285);
  }
  
  public final boolean a(String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(154289);
    if ((paramJsResult instanceof f.c))
    {
      boolean bool = this.ITK.b(this.ITM, paramString1, paramString2, ((f.c)paramJsResult).ITH);
      AppMethodBeat.o(154289);
      return bool;
    }
    AppMethodBeat.o(154289);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, com.tencent.xweb.n paramn)
  {
    AppMethodBeat.i(154291);
    if ((paramn instanceof f.e))
    {
      boolean bool = this.ITK.a(this.ITM, paramString1, paramString2, paramString3, ((f.e)paramn).ITH);
      AppMethodBeat.o(154291);
      return bool;
    }
    AppMethodBeat.o(154291);
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(154290);
    if ((paramJsResult instanceof f.c))
    {
      boolean bool = this.ITK.a(this.ITM, paramString1, paramString2, ((f.c)paramJsResult).ITH);
      AppMethodBeat.o(154290);
      return bool;
    }
    AppMethodBeat.o(154290);
    return false;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(154288);
    this.ITK.fsO();
    AppMethodBeat.o(154288);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(154287);
    if ((paramCustomViewCallback instanceof f.a)) {
      this.ITK.a(paramView, ((f.a)paramCustomViewCallback).ITF);
    }
    AppMethodBeat.o(154287);
  }
  
  public final void z(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(154286);
    this.ITK.a(this.ITM, paramString);
    AppMethodBeat.o(154286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g
 * JD-Core Version:    0.7.0.1
 */