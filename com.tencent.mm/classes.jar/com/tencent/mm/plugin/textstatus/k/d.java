package com.tencent.mm.plugin.textstatus.k;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.g.e.a;
import com.tencent.mm.plugin.textstatus.proto.ac;
import com.tencent.mm.plugin.textstatus.proto.ad;
import java.lang.ref.WeakReference;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/IconLoader;", "", "iv", "Landroid/widget/ImageView;", "iconItem", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIcon;", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIcon;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "getIconColor", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "getIconItem", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIcon;", "getIconType", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "getItem", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "ivRef", "Ljava/lang/ref/WeakReference;", "getIvRef", "()Ljava/lang/ref/WeakReference;", "setIvRef", "(Ljava/lang/ref/WeakReference;)V", "load", "", "plugin-textstatus_release"})
public final class d
{
  WeakReference<ImageView> Gfw;
  final a.c MDC;
  final a MDH;
  final ac MOq;
  final a.a MOr;
  
  public d(ImageView paramImageView, ac paramac, a.c paramc, a.a parama, a parama1)
  {
    AppMethodBeat.i(233259);
    this.MOq = paramac;
    this.MDC = paramc;
    this.MOr = parama;
    this.MDH = parama1;
    this.Gfw = new WeakReference(paramImageView);
    AppMethodBeat.o(233259);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/textstatus/util/IconLoader$load$1$1"})
  static final class a
    extends q
    implements b<Bitmap, x>
  {
    a(d paramd, ad paramad, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.d
 * JD-Core Version:    0.7.0.1
 */