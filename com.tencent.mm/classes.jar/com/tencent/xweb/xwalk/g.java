package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.f;
import com.tencent.xweb.i;
import com.tencent.xweb.j;
import org.xwalk.core.XWalkView;

public final class g
  implements f
{
  l BJD;
  m BJE;
  XWalkView BJF;
  
  public g(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(85230);
    this.BJF = paramXWalkView;
    this.BJD = new l(paramXWalkView);
    this.BJE = new m(paramXWalkView);
    AppMethodBeat.o(85230);
  }
  
  public final boolean a(String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(85234);
    if ((paramj instanceof f.c))
    {
      boolean bool = this.BJD.b(this.BJF, paramString1, paramString2, ((f.c)paramj).BJA);
      AppMethodBeat.o(85234);
      return bool;
    }
    AppMethodBeat.o(85234);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, i parami)
  {
    AppMethodBeat.i(85236);
    if ((parami instanceof f.e))
    {
      boolean bool = this.BJD.a(this.BJF, paramString1, paramString2, paramString3, ((f.e)parami).BJA);
      AppMethodBeat.o(85236);
      return bool;
    }
    AppMethodBeat.o(85236);
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(85235);
    if ((paramj instanceof f.c))
    {
      boolean bool = this.BJD.a(this.BJF, paramString1, paramString2, ((f.c)paramj).BJA);
      AppMethodBeat.o(85235);
      return bool;
    }
    AppMethodBeat.o(85235);
    return false;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(85233);
    this.BJD.dZW();
    AppMethodBeat.o(85233);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(85232);
    if ((paramCustomViewCallback instanceof f.a)) {
      this.BJD.a(paramView, ((f.a)paramCustomViewCallback).BJy);
    }
    AppMethodBeat.o(85232);
  }
  
  public final void w(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(85231);
    this.BJD.a(this.BJF, paramString);
    AppMethodBeat.o(85231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g
 * JD-Core Version:    0.7.0.1
 */