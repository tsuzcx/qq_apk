package com.tencent.mm.pluginsdk.model;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.o;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.n.d;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/pluginsdk/model/BizImageLoader;", "", "()V", "TAG", "", "loadImage", "", "msgId", "", "msgIndex", "", "item", "Lcom/tencent/mm/message/BizReaderItem;", "scene", "url", "view", "Landroid/widget/ImageView;", "cellPosition", "isPreload", "", "options", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "imageLoaderListener", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoaderListener;", "imageLoadListener", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "ImageLoadListenerWrapper", "plugin-biz_release"})
public final class b
{
  public static final b DgN;
  
  static
  {
    AppMethodBeat.i(124831);
    DgN = new b();
    AppMethodBeat.o(124831);
  }
  
  public static void a(long paramLong, int paramInt1, com.tencent.mm.ah.v paramv, String paramString, ImageView paramImageView, int paramInt2, boolean paramBoolean, c paramc, h paramh)
  {
    AppMethodBeat.i(124830);
    if (paramString == null)
    {
      AppMethodBeat.o(124830);
      return;
    }
    Object localObject = a.Dgo;
    String str2 = a.aFT(paramString);
    if (paramImageView != null) {
      paramImageView.setTag(2131297288, paramString);
    }
    String str1;
    label69:
    long l;
    int i;
    if (paramImageView != null)
    {
      localObject = Integer.valueOf(paramImageView.hashCode());
      if (paramc == null) {
        break label350;
      }
      str1 = paramc.aFN();
      ac.d("MicroMsg.BizImageLoader", "alvinluo BizImage loadImage imageView: %s, isPreload: %b, id: %s, url: %s, fullPath: %s", new Object[] { localObject, Boolean.valueOf(paramBoolean), str2, paramString, str1 });
      localObject = com.tencent.mm.pluginsdk.ui.applet.g.Dqh;
      if ((com.tencent.mm.pluginsdk.ui.applet.g.WT(1)) && (!paramBoolean))
      {
        l = System.currentTimeMillis();
        if (paramv != null)
        {
          localObject = a.Dgo;
          k.h(paramv, "item");
          k.h(paramString, "url");
          if (((CharSequence)paramString).length() != 0) {
            break label356;
          }
          i = 1;
          label168:
          if ((i == 0) && (a.Dgj.get(paramString) == null))
          {
            paramv = (String)a.Dgk.get(a.ad(paramLong, paramInt1));
            localObject = new a.b(paramString);
            if (l == 0L) {
              break label362;
            }
          }
        }
      }
    }
    label350:
    label356:
    label362:
    for (paramLong = l;; paramLong = System.currentTimeMillis())
    {
      ((a.b)localObject).position = paramInt2;
      if (paramv != null) {
        ((a.b)localObject).aFU(paramv);
      }
      ((a.b)localObject).aB(1, paramLong);
      ((Map)a.Dgj).put(paramString, localObject);
      if (a.Dgm)
      {
        ac.v("MicroMsg.BizImageBlankReporter", "alvinluo startLoad flinging id: %s, url: %s", new Object[] { a.aFT(paramString), paramString });
        ((a.b)localObject).aB(9, paramLong);
      }
      paramv = a.Dgo;
      a.c(8, paramString, l);
      o.aFB().a(paramString, paramImageView, paramc, null, (h)new a(paramString, paramh));
      AppMethodBeat.o(124830);
      return;
      localObject = null;
      break;
      str1 = null;
      break label69;
      i = 0;
      break label168;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/pluginsdk/model/BizImageLoader$ImageLoadListenerWrapper;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "scene", "", "url", "", "imageLoadListener", "(ILjava/lang/String;Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;)V", "id", "getImageLoadListener", "()Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "getScene", "()I", "getUrl", "()Ljava/lang/String;", "onImageLoadFinish", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-biz_release"})
  public static final class a
    implements h
  {
    private final String id;
    private final int scene;
    private final String url;
    private final h vfu;
    
    public a(String paramString, h paramh)
    {
      AppMethodBeat.i(124829);
      this.scene = 1;
      this.url = paramString;
      this.vfu = paramh;
      paramString = this.url;
      if (paramString != null)
      {
        paramh = d.UTF_8;
        if (paramString == null)
        {
          paramString = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(124829);
          throw paramString;
        }
        paramString = paramString.getBytes(paramh);
        k.g(paramString, "(this as java.lang.String).getBytes(charset)");
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
        paramString = null;
      }
    }
    
    public final Bitmap a(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
    {
      AppMethodBeat.i(124827);
      Object localObject = com.tencent.mm.pluginsdk.ui.applet.g.Dqh;
      if (com.tencent.mm.pluginsdk.ui.applet.g.WT(this.scene))
      {
        localObject = a.Dgo;
        a.cC(7, paramString);
      }
      localObject = this.vfu;
      if (localObject != null) {}
      for (paramView = ((h)localObject).a(paramString, paramView, paramb);; paramView = null)
      {
        paramb = com.tencent.mm.pluginsdk.ui.applet.g.Dqh;
        if (com.tencent.mm.pluginsdk.ui.applet.g.WT(this.scene))
        {
          paramb = a.Dgo;
          a.cD(7, paramString);
        }
        AppMethodBeat.o(124827);
        return paramView;
      }
    }
    
    public final void b(String paramString, View paramView)
    {
      AppMethodBeat.i(124826);
      h localh = this.vfu;
      if (localh != null)
      {
        localh.b(paramString, paramView);
        AppMethodBeat.o(124826);
        return;
      }
      AppMethodBeat.o(124826);
    }
    
    public final void b(String paramString, View paramView, com.tencent.mm.av.a.d.b paramb)
    {
      AppMethodBeat.i(124828);
      k.h(paramString, "url");
      h localh = this.vfu;
      if (localh != null) {
        localh.b(paramString, paramView, paramb);
      }
      paramView = com.tencent.mm.pluginsdk.ui.applet.g.Dqh;
      if (com.tencent.mm.pluginsdk.ui.applet.g.WT(this.scene))
      {
        paramView = a.Dgo;
        k.h(paramString, "url");
        a.v((Runnable)new a.e(paramString, System.currentTimeMillis(), paramb));
      }
      AppMethodBeat.o(124828);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.b
 * JD-Core Version:    0.7.0.1
 */