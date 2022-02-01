package com.tencent.mm.pluginsdk.model;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.loader.c.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizImageLoader$ImageLoadListenerWrapper;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "scene", "", "url", "", "imageLoadListener", "(ILjava/lang/String;Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;)V", "id", "getImageLoadListener", "()Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "getScene", "()I", "getUrl", "()Ljava/lang/String;", "onImageLoadFinish", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$a
  implements h
{
  private final h LMw;
  private final String id;
  private final int scene;
  private final String url;
  
  public f$a(String paramString, h paramh)
  {
    AppMethodBeat.i(124829);
    this.scene = 1;
    this.url = paramString;
    this.LMw = paramh;
    paramString = this.url;
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      paramh = com.tencent.mm.b.g.getMessageDigest(paramString);
      paramString = paramh;
      if (paramh == null) {
        paramString = "-1";
      }
      this.id = paramString;
      AppMethodBeat.o(124829);
      return;
      paramString = paramString.getBytes(d.UTF_8);
      s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    }
  }
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(124827);
    Object localObject = com.tencent.mm.pluginsdk.ui.applet.g.Ybp;
    if (com.tencent.mm.pluginsdk.ui.applet.g.awm(this.scene))
    {
      localObject = e.XQp;
      e.dV(7, paramString);
    }
    localObject = this.LMw;
    if (localObject == null) {}
    for (paramView = null;; paramView = ((h)localObject).a(paramString, paramView, paramb))
    {
      paramb = com.tencent.mm.pluginsdk.ui.applet.g.Ybp;
      if (com.tencent.mm.pluginsdk.ui.applet.g.awm(this.scene))
      {
        paramb = e.XQp;
        e.dW(7, paramString);
      }
      AppMethodBeat.o(124827);
      return paramView;
    }
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(124828);
    s.u(paramString, "url");
    h localh = this.LMw;
    if (localh != null) {
      localh.b(paramString, paramView, paramb);
    }
    paramView = com.tencent.mm.pluginsdk.ui.applet.g.Ybp;
    if (com.tencent.mm.pluginsdk.ui.applet.g.awm(this.scene))
    {
      paramView = e.XQp;
      e.b(paramString, paramb);
    }
    AppMethodBeat.o(124828);
  }
  
  public final void c(String paramString, View paramView)
  {
    AppMethodBeat.i(124826);
    h localh = this.LMw;
    if (localh != null) {
      localh.c(paramString, paramView);
    }
    AppMethodBeat.o(124826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.f.a
 * JD-Core Version:    0.7.0.1
 */