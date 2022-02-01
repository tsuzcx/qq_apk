package com.tencent.mm.pluginsdk.model;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.v;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.biz.b.d;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizImageLoader;", "", "()V", "TAG", "", "loadImage", "", "msgId", "", "msgIndex", "", "item", "Lcom/tencent/mm/message/BizReaderItem;", "scene", "url", "view", "Landroid/widget/ImageView;", "cellPosition", "isPreload", "", "options", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "imageLoaderListener", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoaderListener;", "imageLoadListener", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "ImageLoadListenerWrapper", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f XQM;
  
  static
  {
    AppMethodBeat.i(124831);
    XQM = new f();
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
    Object localObject = e.XQp;
    String str2 = e.bpr(paramString);
    if (paramImageView != null) {
      paramImageView.setTag(b.d.biz_image_view_url, paramString);
    }
    String str1;
    label59:
    long l;
    int i;
    if (paramImageView == null)
    {
      localObject = null;
      if (paramc != null) {
        break label347;
      }
      str1 = null;
      Log.d("MicroMsg.BizImageLoader", "alvinluo BizImage loadImage imageView: %s, isPreload: %b, id: %s, url: %s, fullPath: %s", new Object[] { localObject, Boolean.valueOf(paramBoolean), str2, paramString, str1 });
      localObject = g.Ybp;
      if ((g.awm(1)) && (!paramBoolean))
      {
        l = System.currentTimeMillis();
        if (paramv != null)
        {
          localObject = e.XQp;
          s.u(paramv, "item");
          s.u(paramString, "url");
          if (((CharSequence)paramString).length() != 0) {
            break label357;
          }
          i = 1;
          label158:
          if ((i == 0) && (e.LDk.get(paramString) == null))
          {
            paramv = (String)e.XQq.get(e.aK(paramLong, paramInt1));
            localObject = new e.b(paramString);
            if (l == 0L) {
              break label363;
            }
          }
        }
      }
    }
    label347:
    label357:
    label363:
    for (paramLong = l;; paramLong = System.currentTimeMillis())
    {
      ((e.b)localObject).position = paramInt2;
      if (paramv != null) {
        ((e.b)localObject).bps(paramv);
      }
      ((e.b)localObject).bl(1, paramLong);
      ((Map)e.LDk).put(paramString, localObject);
      if (e.XQs)
      {
        Log.v("MicroMsg.BizImageBlankReporter", "alvinluo startLoad flinging id: %s, url: %s", new Object[] { e.bpr(paramString), paramString });
        ((e.b)localObject).bl(9, paramLong);
      }
      paramv = e.XQp;
      e.e(8, paramString, l);
      r.bKe().a(paramString, paramImageView, paramc, null, (h)new f.a(paramString, paramh));
      AppMethodBeat.o(124830);
      return;
      localObject = Integer.valueOf(paramImageView.hashCode());
      break;
      str1 = paramc.fullPath;
      break label59;
      i = 0;
      break label158;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.f
 * JD-Core Version:    0.7.0.1
 */