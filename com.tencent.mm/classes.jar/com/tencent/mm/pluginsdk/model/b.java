package com.tencent.mm.pluginsdk.model;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/model/BizImageLoader;", "", "()V", "TAG", "", "loadImage", "", "msgId", "", "msgIndex", "", "item", "Lcom/tencent/mm/message/BizReaderItem;", "scene", "url", "view", "Landroid/widget/ImageView;", "cellPosition", "isPreload", "", "options", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "imageLoaderListener", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoaderListener;", "imageLoadListener", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "ImageLoadListenerWrapper", "plugin-biz_release"})
public final class b
{
  public static final b JUJ;
  
  static
  {
    AppMethodBeat.i(124831);
    JUJ = new b();
    AppMethodBeat.o(124831);
  }
  
  public static void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, boolean paramBoolean, c paramc, h paramh)
  {
    AppMethodBeat.i(124830);
    if (paramString == null)
    {
      AppMethodBeat.o(124830);
      return;
    }
    Object localObject = a.JUl;
    String str2 = a.bdl(paramString);
    if (paramImageView != null) {
      paramImageView.setTag(2131297446, paramString);
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
      str1 = paramc.bdi();
      Log.d("MicroMsg.BizImageLoader", "alvinluo BizImage loadImage imageView: %s, isPreload: %b, id: %s, url: %s, fullPath: %s", new Object[] { localObject, Boolean.valueOf(paramBoolean), str2, paramString, str1 });
      localObject = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
      if ((com.tencent.mm.pluginsdk.ui.applet.g.aig(1)) && (!paramBoolean))
      {
        l = System.currentTimeMillis();
        if (paramv != null)
        {
          localObject = a.JUl;
          p.h(paramv, "item");
          p.h(paramString, "url");
          if (((CharSequence)paramString).length() != 0) {
            break label356;
          }
          i = 1;
          label168:
          if ((i == 0) && (a.AbY.get(paramString) == null))
          {
            paramv = (String)a.JUh.get(a.al(paramLong, paramInt1));
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
        ((a.b)localObject).bdm(paramv);
      }
      ((a.b)localObject).aQ(1, paramLong);
      ((Map)a.AbY).put(paramString, localObject);
      if (a.JUj)
      {
        Log.v("MicroMsg.BizImageBlankReporter", "alvinluo startLoad flinging id: %s, url: %s", new Object[] { a.bdl(paramString), paramString });
        ((a.b)localObject).aQ(9, paramLong);
      }
      paramv = a.JUl;
      a.d(8, paramString, l);
      q.bcV().a(paramString, paramImageView, paramc, null, (h)new a(paramString, paramh));
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/model/BizImageLoader$ImageLoadListenerWrapper;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "scene", "", "url", "", "imageLoadListener", "(ILjava/lang/String;Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;)V", "id", "getImageLoadListener", "()Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "getScene", "()I", "getUrl", "()Ljava/lang/String;", "onImageLoadFinish", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-biz_release"})
  public static final class a
    implements h
  {
    private final h Akx;
    private final String id;
    private final int scene;
    private final String url;
    
    public a(String paramString, h paramh)
    {
      AppMethodBeat.i(124829);
      this.scene = 1;
      this.url = paramString;
      this.Akx = paramh;
      paramString = this.url;
      if (paramString != null)
      {
        paramh = d.UTF_8;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(124829);
          throw paramString;
        }
        paramString = paramString.getBytes(paramh);
        p.g(paramString, "(this as java.lang.String).getBytes(charset)");
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
      Object localObject = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
      if (com.tencent.mm.pluginsdk.ui.applet.g.aig(this.scene))
      {
        localObject = a.JUl;
        a.dd(7, paramString);
      }
      localObject = this.Akx;
      if (localObject != null) {}
      for (paramView = ((h)localObject).a(paramString, paramView, paramb);; paramView = null)
      {
        paramb = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
        if (com.tencent.mm.pluginsdk.ui.applet.g.aig(this.scene))
        {
          paramb = a.JUl;
          a.de(7, paramString);
        }
        AppMethodBeat.o(124827);
        return paramView;
      }
    }
    
    public final void b(String paramString, View paramView)
    {
      AppMethodBeat.i(124826);
      h localh = this.Akx;
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
      p.h(paramString, "url");
      h localh = this.Akx;
      if (localh != null) {
        localh.b(paramString, paramView, paramb);
      }
      paramView = com.tencent.mm.pluginsdk.ui.applet.g.Kev;
      if (com.tencent.mm.pluginsdk.ui.applet.g.aig(this.scene))
      {
        paramView = a.JUl;
        p.h(paramString, "url");
        a.v((Runnable)new a.e(paramString, System.currentTimeMillis(), paramb));
      }
      AppMethodBeat.o(124828);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.b
 * JD-Core Version:    0.7.0.1
 */