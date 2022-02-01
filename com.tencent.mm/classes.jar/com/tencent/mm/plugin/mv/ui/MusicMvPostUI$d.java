package com.tencent.mm.plugin.mv.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.modelimage.loader.b.h;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvPostUI$updateCoverImg$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvPostUI$d
  implements h
{
  MusicMvPostUI$d(MusicMvPostUI paramMusicMvPostUI, View paramView) {}
  
  public final Bitmap a(String paramString, View paramView, com.tencent.mm.modelimage.loader.c.b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, com.tencent.mm.modelimage.loader.c.b paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(286501);
    s.u(paramString, "url");
    label30:
    Context localContext;
    View localView;
    if (paramb == null)
    {
      paramView = null;
      if (paramView != null)
      {
        if (paramb != null) {
          break label128;
        }
        paramView = null;
        if (!paramView.isRecycled())
        {
          paramString = paramString.getBytes(d.UTF_8);
          s.s(paramString, "(this as java.lang.String).getBytes(charset)");
          paramView = g.getMessageDigest(paramString);
          paramString = com.tencent.mm.plugin.comm.b.xeH;
          paramString = this.Mau.getContext();
          s.s(paramString, "context");
          localContext = (Context)paramString;
          localView = this.Mav;
          if (paramb != null) {
            break label136;
          }
        }
      }
    }
    label128:
    label136:
    for (paramString = localObject;; paramString = paramb.bitmap)
    {
      s.s(paramString, "imageData?.bitmap");
      s.s(paramView, "md5Key");
      com.tencent.mm.plugin.comm.b.a(localContext, localView, paramString, paramView);
      AppMethodBeat.o(286501);
      return;
      paramView = paramb.bitmap;
      break;
      paramView = paramb.bitmap;
      break label30;
    }
  }
  
  public final void c(String paramString, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvPostUI.d
 * JD-Core Version:    0.7.0.1
 */