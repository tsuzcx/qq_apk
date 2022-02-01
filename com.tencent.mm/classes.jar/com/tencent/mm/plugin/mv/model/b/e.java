package com.tencent.mm.plugin.mv.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.livelist.a;
import com.tencent.mm.protocal.protobuf.dog;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "Lcom/tencent/mm/plugin/livelist/BaseMMLiveListItem;", "id", "", "orderId", "", "previewItem", "Lcom/tencent/mm/protocal/protobuf/PreviewItem;", "listId", "(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/PreviewItem;Ljava/lang/String;)V", "galleryItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getGalleryItem", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setGalleryItem", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "getId", "()Ljava/lang/String;", "isChecked", "", "()Z", "setChecked", "(Z)V", "isCurrentPreview", "setCurrentPreview", "getListId", "getOrderId", "()I", "setOrderId", "(I)V", "getPreviewItem", "()Lcom/tencent/mm/protocal/protobuf/PreviewItem;", "clone", "compareTo", "other", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "getItemType", "getUniqueId", "isSameContent", "Companion", "plugin-mv_release"})
public final class e
  extends a
{
  public static final e.a Geb;
  public final String GdS;
  public boolean GdX;
  public GalleryItem.MediaItem GdY;
  public int GdZ;
  public final dog Gea;
  public boolean fXF;
  public final String id;
  
  static
  {
    AppMethodBeat.i(237268);
    Geb = new e.a((byte)0);
    AppMethodBeat.o(237268);
  }
  
  public e(String paramString1, int paramInt, dog paramdog, String paramString2)
  {
    AppMethodBeat.i(237265);
    this.id = paramString1;
    this.GdZ = paramInt;
    this.Gea = paramdog;
    this.GdS = paramString2;
    paramString1 = this.Gea.TVy;
    if (paramString1 != null)
    {
      paramString1 = paramString1.toByteArray();
      if (this.Gea.type == 1)
      {
        paramdog = GalleryItem.ImageMediaItem.CREATOR;
        p.j(paramdog, "GalleryItem.ImageMediaItem.CREATOR");
        this.GdY = ((GalleryItem.MediaItem)d.a(paramString1, paramdog));
        AppMethodBeat.o(237265);
        return;
      }
      if (this.Gea.type == 2)
      {
        paramdog = GalleryItem.VideoMediaItem.CREATOR;
        p.j(paramdog, "GalleryItem.VideoMediaItem.CREATOR");
        this.GdY = ((GalleryItem.MediaItem)d.a(paramString1, paramdog));
      }
      AppMethodBeat.o(237265);
      return;
    }
    AppMethodBeat.o(237265);
  }
  
  public final int bAQ()
  {
    return this.Gea.type;
  }
  
  public final boolean c(com.tencent.mm.plugin.livelist.b paramb)
  {
    AppMethodBeat.i(237252);
    p.k(paramb, "other");
    if ((paramb instanceof e))
    {
      if ((p.h(this.id, ((e)paramb).id)) && (p.h(this.Gea, ((e)paramb).Gea)) && (p.h(this.GdS, ((e)paramb).GdS)) && (this.GdX == ((e)paramb).GdX))
      {
        AppMethodBeat.o(237252);
        return true;
      }
      AppMethodBeat.o(237252);
      return false;
    }
    AppMethodBeat.o(237252);
    return false;
  }
  
  public final String eLP()
  {
    AppMethodBeat.i(237249);
    String str = this.GdS + '-' + this.id;
    AppMethodBeat.o(237249);
    return str;
  }
  
  public final e fgo()
  {
    AppMethodBeat.i(237257);
    e locale = new e(this.id, this.GdZ, this.Gea, this.GdS);
    locale.GdX = this.GdX;
    locale.fXF = this.fXF;
    AppMethodBeat.o(237257);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.e
 * JD-Core Version:    0.7.0.1
 */