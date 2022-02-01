package com.tencent.mm.plugin.textstatus.util;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.ap;
import com.tencent.mm.plugin.textstatus.proto.aq;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/IconLoader;", "", "iv", "Landroid/widget/ImageView;", "iconItem", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIcon;", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIcon;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "getIconColor", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "getIconItem", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIcon;", "getIconType", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "getItem", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "ivRef", "Ljava/lang/ref/WeakReference;", "getIvRef", "()Ljava/lang/ref/WeakReference;", "setIvRef", "(Ljava/lang/ref/WeakReference;)V", "getAction", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusIconAction;", "load", "", "url", "", "isUseOriginal", "", "loadBigIcon", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG;
  public static final c.a TAO;
  WeakReference<ImageView> MaP;
  private final ap TAQ;
  final a.a TAR;
  final a.c Tnd;
  private final com.tencent.mm.plugin.textstatus.h.f.b Tnj;
  
  static
  {
    AppMethodBeat.i(290377);
    TAO = new c.a((byte)0);
    TAG = "MicroMsg.TextStatus.IconLoader";
    AppMethodBeat.o(290377);
  }
  
  public c(ImageView paramImageView, ap paramap, a.c paramc, a.a parama, com.tencent.mm.plugin.textstatus.h.f.b paramb)
  {
    AppMethodBeat.i(290371);
    this.TAQ = paramap;
    this.Tnd = paramc;
    this.TAR = parama;
    this.Tnj = paramb;
    this.MaP = new WeakReference(paramImageView);
    AppMethodBeat.o(290371);
  }
  
  public final void du(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(290385);
    Object localObject = (ImageView)this.MaP.get();
    if (localObject == null)
    {
      AppMethodBeat.o(290385);
      return;
    }
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(290385);
      return;
    }
    ((ImageView)localObject).setTag(a.e.TdV, paramString);
    localObject = g.TBm;
    g.u(paramString, (kotlin.g.a.b)new b(this, paramString, paramBoolean));
    AppMethodBeat.o(290385);
  }
  
  public final aq hKk()
  {
    AppMethodBeat.i(290394);
    Object localObject = this.TAQ;
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      localObject = this.Tnj;
      if (localObject == null)
      {
        AppMethodBeat.o(290394);
        return null;
        localObject = h.a((ap)localObject);
      }
      else
      {
        localObject = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject);
        if (localObject == null)
        {
          AppMethodBeat.o(290394);
          return null;
        }
        localObject = ((TextStatusTopicInfo)localObject).iconActions;
        if (localObject == null)
        {
          AppMethodBeat.o(290394);
          return null;
        }
        localObject = h.ly((List)localObject);
        AppMethodBeat.o(290394);
        return localObject;
      }
    }
    AppMethodBeat.o(290394);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    b(c paramc, String paramString, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.c
 * JD-Core Version:    0.7.0.1
 */