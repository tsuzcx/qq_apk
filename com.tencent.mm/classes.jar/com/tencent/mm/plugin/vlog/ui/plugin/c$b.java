package com.tencent.mm.plugin.vlog.ui.plugin;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.ui.base.a.a;
import com.tencent.mm.ui.base.a.b;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
public final class c$b
  extends a<GalleryItem.MediaItem, c.d>
{
  public c$b()
  {
    AppMethodBeat.i(191182);
    au(true);
    AppMethodBeat.o(191182);
  }
  
  public final void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(191177);
    p.h(paramb, "viewWrapper");
    super.a(paramb, paramInt);
    paramb = (c.d)paramb.getView();
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)getItemAtPosition(paramInt);
    ImageView localImageView = paramb.getImageView();
    p.g(localMediaItem, "media");
    h.a(localImageView, localMediaItem.getType(), localMediaItem.aQn(), localMediaItem.dRh(), localMediaItem.xiZ, (h.a)a.GGF, localMediaItem.xja);
    p.g(paramb, "itemView");
    if (localMediaItem.xiZ == c.a(this.GGE))
    {
      bool = true;
      paramb.setSelected(bool);
      if (localMediaItem.xiZ != c.a(this.GGE)) {
        break label147;
      }
    }
    label147:
    for (boolean bool = true;; bool = false)
    {
      paramb.setFocusable(bool);
      AppMethodBeat.o(191177);
      return;
      bool = false;
      break;
    }
  }
  
  public final void a(b paramb, int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(191179);
    p.h(paramb, "holder");
    p.h(paramList, "payloads");
    if (paramList.isEmpty()) {
      a(paramb, paramInt);
    }
    AppMethodBeat.o(191179);
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(191181);
    long l = ((GalleryItem.MediaItem)getItemAtPosition(paramInt)).xiZ;
    AppMethodBeat.o(191181);
    return l;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "attached"})
  static final class a
    implements h.a
  {
    public static final a GGF;
    
    static
    {
      AppMethodBeat.i(191175);
      GGF = new a();
      AppMethodBeat.o(191175);
    }
    
    public final void dSs() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.c.b
 * JD-Core Version:    0.7.0.1
 */