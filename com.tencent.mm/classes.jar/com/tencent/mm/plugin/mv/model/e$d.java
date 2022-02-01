package com.tencent.mm.plugin.mv.model;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderThumbData;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$IThumbData;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "attachThumb", "", "thumbView", "Landroid/widget/ImageView;", "callback", "Lcom/tencent/mm/plugin/gallery/ui/ThumbDrawable$AttachThumbCallback;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$d
  implements e.g
{
  private final FinderObject EDa;
  
  public e$d(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(286159);
    this.EDa = paramFinderObject;
    AppMethodBeat.o(286159);
  }
  
  public final void a(ImageView paramImageView, h.a parama)
  {
    AppMethodBeat.i(286167);
    s.u(paramImageView, "thumbView");
    Object localObject1 = this.EDa.objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 != null)
      {
        Object localObject2 = (FinderMedia)p.oL((List)localObject1);
        if (localObject2 != null)
        {
          localObject1 = new c.a();
          g localg = g.LMs;
          ((c.a)localObject1).fullPath = g.aOX(s.X("thumb_", Long.valueOf(this.EDa.id)));
          ((c.a)localObject1).oKp = true;
          ((c.a)localObject1).oKn = true;
          localObject2 = s.X(((FinderMedia)localObject2).thumbUrl, ((FinderMedia)localObject2).thumb_url_token);
          r.bKe().a((String)localObject2, paramImageView, ((c.a)localObject1).bKx(), (h)new a(parama));
        }
      }
    }
    AppMethodBeat.o(286167);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderThumbData$attachThumb$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements h
  {
    a(h.a parama) {}
    
    public final Bitmap a(String paramString, View paramView, b paramb)
    {
      AppMethodBeat.i(286028);
      s.checkNotNull(paramb);
      paramString = paramb.bitmap;
      s.s(paramString, "imageData!!.bitmap");
      AppMethodBeat.o(286028);
      return paramString;
    }
    
    public final void b(String paramString, View paramView, b paramb)
    {
      AppMethodBeat.i(286031);
      paramString = this.LXc;
      if (paramString != null) {
        paramString.attached();
      }
      AppMethodBeat.o(286031);
    }
    
    public final void c(String paramString, View paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.e.d
 * JD-Core Version:    0.7.0.1
 */