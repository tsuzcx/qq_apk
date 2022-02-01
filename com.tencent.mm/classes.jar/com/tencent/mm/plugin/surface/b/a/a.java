package com.tencent.mm.plugin.surface.b.a;

import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.surface.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceCanvasJsApi;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfacePlainJsApi;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceCanvasJsApiContext;", "context", "(Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceCanvasJsApiContext;)V", "createCanvas", "", "frameSetId", "", "getFrameSetHeight", "", "getFrameSetName", "getFrameSetWidth", "getHeight", "", "canvasId", "getLeft", "getTop", "getWidth", "has", "", "hasFrameSet", "remove", "", "setHeight", "height", "setLeft", "left", "setTop", "top", "setWidth", "width", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends h<b>
{
  public a(b paramb)
  {
    super("WeixinCanvas", (i)paramb);
    AppMethodBeat.i(265144);
    AppMethodBeat.o(265144);
  }
  
  @JavascriptInterface
  public final int createCanvas(String paramString)
  {
    AppMethodBeat.i(265160);
    s.u(paramString, "frameSetId");
    int i = ((b)hBQ()).createCanvas(paramString);
    AppMethodBeat.o(265160);
    return i;
  }
  
  @JavascriptInterface
  public final Number getFrameSetHeight(String paramString)
  {
    AppMethodBeat.i(265193);
    s.u(paramString, "frameSetId");
    b localb = (b)hBQ();
    s.u(paramString, "frameSetId");
    Object localObject = localb.bcZ(paramString);
    if (localObject == null) {
      localObject = Float.valueOf((0.0F / 0.0F));
    }
    for (;;)
    {
      Log.v(localb.TAG, "getFrameSetHeight#" + paramString + ':' + localObject);
      paramString = (Number)localObject;
      AppMethodBeat.o(265193);
      return paramString;
      localObject = ((c)localObject).mJe;
      if (localObject == null) {
        localObject = Float.valueOf((0.0F / 0.0F));
      } else {
        localObject = Integer.valueOf(com.tencent.mm.plugin.surface.c.h.e((Number)Integer.valueOf(((ViewGroup)localObject).getMeasuredHeight())));
      }
    }
  }
  
  @JavascriptInterface
  public final String getFrameSetName(String paramString)
  {
    AppMethodBeat.i(265177);
    s.u(paramString, "frameSetId");
    b localb = (b)hBQ();
    s.u(paramString, "frameSetId");
    paramString = localb.bcZ(paramString);
    s.checkNotNull(paramString);
    paramString = paramString.name;
    AppMethodBeat.o(265177);
    return paramString;
  }
  
  @JavascriptInterface
  public final Number getFrameSetWidth(String paramString)
  {
    AppMethodBeat.i(265188);
    s.u(paramString, "frameSetId");
    b localb = (b)hBQ();
    s.u(paramString, "frameSetId");
    Object localObject = localb.bcZ(paramString);
    if (localObject == null) {
      localObject = Float.valueOf((0.0F / 0.0F));
    }
    for (;;)
    {
      Log.v(localb.TAG, "getFrameSetWidth#" + paramString + ':' + localObject);
      paramString = (Number)localObject;
      AppMethodBeat.o(265188);
      return paramString;
      localObject = ((c)localObject).mJe;
      if (localObject == null) {
        localObject = Float.valueOf((0.0F / 0.0F));
      } else {
        localObject = Integer.valueOf(com.tencent.mm.plugin.surface.c.h.e((Number)Integer.valueOf(((ViewGroup)localObject).getMeasuredWidth())));
      }
    }
  }
  
  @JavascriptInterface
  public final Object getHeight(int paramInt)
  {
    AppMethodBeat.i(265248);
    paramInt = com.tencent.mm.plugin.surface.c.h.e((Number)Integer.valueOf(((b)hBQ()).anL(paramInt).getMeasuredHeight()));
    AppMethodBeat.o(265248);
    return Integer.valueOf(paramInt);
  }
  
  @JavascriptInterface
  public final Number getLeft(int paramInt)
  {
    AppMethodBeat.i(265204);
    Number localNumber = (Number)Integer.valueOf(com.tencent.mm.plugin.surface.c.h.e((Number)Float.valueOf(((b)hBQ()).anL(paramInt).getX())));
    AppMethodBeat.o(265204);
    return localNumber;
  }
  
  @JavascriptInterface
  public final Number getTop(int paramInt)
  {
    AppMethodBeat.i(265219);
    Number localNumber = (Number)Integer.valueOf(com.tencent.mm.plugin.surface.c.h.e((Number)Float.valueOf(((b)hBQ()).anL(paramInt).getY())));
    AppMethodBeat.o(265219);
    return localNumber;
  }
  
  @JavascriptInterface
  public final Object getWidth(int paramInt)
  {
    AppMethodBeat.i(265233);
    paramInt = com.tencent.mm.plugin.surface.c.h.e((Number)Integer.valueOf(((b)hBQ()).anL(paramInt).getMeasuredWidth()));
    AppMethodBeat.o(265233);
    return Integer.valueOf(paramInt);
  }
  
  @JavascriptInterface
  public final boolean has(int paramInt)
  {
    AppMethodBeat.i(265152);
    if (((b)hBQ()).SKU.eHD.findOrNull(paramInt) != null)
    {
      AppMethodBeat.o(265152);
      return true;
    }
    AppMethodBeat.o(265152);
    return false;
  }
  
  @JavascriptInterface
  public final boolean hasFrameSet(String paramString)
  {
    AppMethodBeat.i(265167);
    s.u(paramString, "frameSetId");
    b localb = (b)hBQ();
    s.u(paramString, "frameSetId");
    if (localb.bcZ(paramString) != null)
    {
      AppMethodBeat.o(265167);
      return true;
    }
    AppMethodBeat.o(265167);
    return false;
  }
  
  @JavascriptInterface
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(265199);
    d.uiThread((kotlin.g.a.a)new b.a((b)hBQ(), paramInt));
    AppMethodBeat.o(265199);
  }
  
  @JavascriptInterface
  public final void setHeight(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(265257);
    s.u(paramObject, "height");
    b localb = (b)hBQ();
    s.u(paramObject, "height");
    if (!(paramObject instanceof Number))
    {
      paramObject = new Exception("height:" + paramObject + " is invalid, number only");
      AppMethodBeat.o(265257);
      throw paramObject;
    }
    d.uiThread((kotlin.g.a.a)new b.b(localb, paramInt, paramObject));
    AppMethodBeat.o(265257);
  }
  
  @JavascriptInterface
  public final void setLeft(int paramInt, Number paramNumber)
  {
    AppMethodBeat.i(265211);
    s.u(paramNumber, "left");
    b localb = (b)hBQ();
    s.u(paramNumber, "x");
    d.uiThread((kotlin.g.a.a)new b.c(localb, paramInt, paramNumber));
    AppMethodBeat.o(265211);
  }
  
  @JavascriptInterface
  public final void setTop(int paramInt, Number paramNumber)
  {
    AppMethodBeat.i(265227);
    s.u(paramNumber, "top");
    b localb = (b)hBQ();
    s.u(paramNumber, "y");
    d.uiThread((kotlin.g.a.a)new b.d(localb, paramInt, paramNumber));
    AppMethodBeat.o(265227);
  }
  
  @JavascriptInterface
  public final void setWidth(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(265242);
    s.u(paramObject, "width");
    b localb = (b)hBQ();
    s.u(paramObject, "width");
    if (!(paramObject instanceof Number))
    {
      paramObject = new Exception("width:" + paramObject + " is invalid, number only");
      AppMethodBeat.o(265242);
      throw paramObject;
    }
    d.uiThread((kotlin.g.a.a)new b.e(localb, paramInt, paramObject));
    AppMethodBeat.o(265242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.a.a
 * JD-Core Version:    0.7.0.1
 */