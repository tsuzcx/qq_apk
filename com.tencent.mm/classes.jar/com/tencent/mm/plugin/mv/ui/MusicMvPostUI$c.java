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

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvPostUI$onCreate$6$1$1", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadListener;", "onImageLoadFinish", "", "url", "", "view", "Landroid/view/View;", "imageData", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onImageLoadStart", "onProcessBitmap", "Landroid/graphics/Bitmap;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvPostUI$c
  implements h
{
  MusicMvPostUI$c(MusicMvPostUI paramMusicMvPostUI, View paramView) {}
  
  public final Bitmap a(String paramString, View paramView, com.tencent.mm.modelimage.loader.c.b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, com.tencent.mm.modelimage.loader.c.b paramb)
  {
    View localView = null;
    AppMethodBeat.i(286493);
    s.u(paramString, "url");
    if (paramb == null)
    {
      paramView = null;
      if (paramView != null) {
        if (paramb != null) {
          break label125;
        }
      }
    }
    label125:
    for (paramView = localView;; paramView = paramb.bitmap)
    {
      if (!paramView.isRecycled())
      {
        paramString = paramString.getBytes(d.UTF_8);
        s.s(paramString, "(this as java.lang.String).getBytes(charset)");
        paramString = g.getMessageDigest(paramString);
        paramView = com.tencent.mm.plugin.comm.b.xeH;
        paramView = this.Mau.getContext();
        s.s(paramView, "context");
        paramView = (Context)paramView;
        localView = this.Mav;
        paramb = paramb.bitmap;
        s.s(paramb, "imageData.bitmap");
        s.s(paramString, "md5Key");
        com.tencent.mm.plugin.comm.b.a(paramView, localView, paramb, paramString);
      }
      AppMethodBeat.o(286493);
      return;
      paramView = paramb.bitmap;
      break;
    }
  }
  
  public final void c(String paramString, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvPostUI.c
 * JD-Core Version:    0.7.0.1
 */