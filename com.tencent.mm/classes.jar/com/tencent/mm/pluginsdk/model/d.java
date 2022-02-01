package com.tencent.mm.pluginsdk.model;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.v;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.ay.a.d.b;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.biz.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizImageLoader;", "", "()V", "TAG", "", "loadImage", "", "msgId", "", "msgIndex", "", "item", "Lcom/tencent/mm/message/BizReaderItem;", "scene", "url", "view", "Landroid/widget/ImageView;", "cellPosition", "isPreload", "", "options", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "imageLoaderListener", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoaderListener;", "imageLoadListener", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "ImageLoadListenerWrapper", "plugin-biz_release"})
public final class d
{
  public static final d QUR;
  
  static
  {
    AppMethodBeat.i(124831);
    QUR = new d();
    AppMethodBeat.o(124831);
  }
  
  public static void a(long paramLong, int paramInt1, v paramv, String paramString, ImageView paramImageView, int paramInt2, boolean paramBoolean, com.tencent.mm.ay.a.a.c paramc, h paramh)
  {
    AppMethodBeat.i(124830);
    if (paramString == null)
    {
      AppMethodBeat.o(124830);
      return;
    }
    Object localObject = c.QUt;
    String str2 = c.bpB(paramString);
    if (paramImageView != null) {
      paramImageView.setTag(b.d.biz_image_view_url, paramString);
    }
    String str1;
    label70:
    long l;
    int i;
    if (paramImageView != null)
    {
      localObject = Integer.valueOf(paramImageView.hashCode());
      if (paramc == null) {
        break label351;
      }
      str1 = paramc.bmz();
      Log.d("MicroMsg.BizImageLoader", "alvinluo BizImage loadImage imageView: %s, isPreload: %b, id: %s, url: %s, fullPath: %s", new Object[] { localObject, Boolean.valueOf(paramBoolean), str2, paramString, str1 });
      localObject = com.tencent.mm.pluginsdk.ui.applet.g.Rfj;
      if ((com.tencent.mm.pluginsdk.ui.applet.g.aqi(1)) && (!paramBoolean))
      {
        l = System.currentTimeMillis();
        if (paramv != null)
        {
          localObject = c.QUt;
          p.k(paramv, "item");
          p.k(paramString, "url");
          if (((CharSequence)paramString).length() != 0) {
            break label357;
          }
          i = 1;
          label169:
          if ((i == 0) && (c.FHN.get(paramString) == null))
          {
            paramv = (String)c.QUp.get(c.au(paramLong, paramInt1));
            localObject = new c.b(paramString);
            if (l == 0L) {
              break label363;
            }
          }
        }
      }
    }
    label351:
    label357:
    label363:
    for (paramLong = l;; paramLong = System.currentTimeMillis())
    {
      ((c.b)localObject).position = paramInt2;
      if (paramv != null) {
        ((c.b)localObject).bpC(paramv);
      }
      ((c.b)localObject).bc(1, paramLong);
      ((Map)c.FHN).put(paramString, localObject);
      if (c.QUr)
      {
        Log.v("MicroMsg.BizImageBlankReporter", "alvinluo startLoad flinging id: %s, url: %s", new Object[] { c.bpB(paramString), paramString });
        ((c.b)localObject).bc(9, paramLong);
      }
      paramv = c.QUt;
      c.e(8, paramString, l);
      q.bml().a(paramString, paramImageView, paramc, null, (h)new a(paramString, paramh));
      AppMethodBeat.o(124830);
      return;
      localObject = null;
      break;
      str1 = null;
      break label70;
      i = 0;
      break label169;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/BizImageLoader$ImageLoadListenerWrapper;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "scene", "", "url", "", "imageLoadListener", "(ILjava/lang/String;Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;)V", "id", "getImageLoadListener", "()Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "getScene", "()I", "getUrl", "()Ljava/lang/String;", "onImageLoadFinish", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-biz_release"})
  public static final class a
    implements h
  {
    private final h FRB;
    private final String id;
    private final int scene;
    private final String url;
    
    public a(String paramString, h paramh)
    {
      AppMethodBeat.i(124829);
      this.scene = 1;
      this.url = paramString;
      this.FRB = paramh;
      paramString = this.url;
      if (paramString != null)
      {
        paramh = kotlin.n.d.UTF_8;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(124829);
          throw paramString;
        }
        paramString = paramString.getBytes(paramh);
        p.j(paramString, "(this as java.lang.String).getBytes(charset)");
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
    
    public final Bitmap a(String paramString, View paramView, b paramb)
    {
      AppMethodBeat.i(124827);
      Object localObject = com.tencent.mm.pluginsdk.ui.applet.g.Rfj;
      if (com.tencent.mm.pluginsdk.ui.applet.g.aqi(this.scene))
      {
        localObject = c.QUt;
        c.dd(7, paramString);
      }
      localObject = this.FRB;
      if (localObject != null) {}
      for (paramView = ((h)localObject).a(paramString, paramView, paramb);; paramView = null)
      {
        paramb = com.tencent.mm.pluginsdk.ui.applet.g.Rfj;
        if (com.tencent.mm.pluginsdk.ui.applet.g.aqi(this.scene))
        {
          paramb = c.QUt;
          c.de(7, paramString);
        }
        AppMethodBeat.o(124827);
        return paramView;
      }
    }
    
    public final void b(String paramString, View paramView)
    {
      AppMethodBeat.i(124826);
      h localh = this.FRB;
      if (localh != null)
      {
        localh.b(paramString, paramView);
        AppMethodBeat.o(124826);
        return;
      }
      AppMethodBeat.o(124826);
    }
    
    public final void b(String paramString, View paramView, b paramb)
    {
      AppMethodBeat.i(124828);
      p.k(paramString, "url");
      h localh = this.FRB;
      if (localh != null) {
        localh.b(paramString, paramView, paramb);
      }
      paramView = com.tencent.mm.pluginsdk.ui.applet.g.Rfj;
      if (com.tencent.mm.pluginsdk.ui.applet.g.aqi(this.scene))
      {
        paramView = c.QUt;
        p.k(paramString, "url");
        c.u((Runnable)new c.e(paramString, System.currentTimeMillis(), paramb));
      }
      AppMethodBeat.o(124828);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.d
 * JD-Core Version:    0.7.0.1
 */