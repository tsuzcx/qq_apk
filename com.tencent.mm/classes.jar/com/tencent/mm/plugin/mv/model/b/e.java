package com.tencent.mm.plugin.mv.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.mvvmlist.a;
import com.tencent.mm.protocal.protobuf.egx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "id", "", "orderId", "", "previewItem", "Lcom/tencent/mm/protocal/protobuf/PreviewItem;", "listId", "(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/PreviewItem;Ljava/lang/String;)V", "galleryItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getGalleryItem", "()Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "setGalleryItem", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)V", "getId", "()Ljava/lang/String;", "isChecked", "", "()Z", "setChecked", "(Z)V", "isCurrentPreview", "setCurrentPreview", "getListId", "getOrderId", "()I", "setOrderId", "(I)V", "getPreviewItem", "()Lcom/tencent/mm/protocal/protobuf/PreviewItem;", "compareTo", "other", "getItemType", "getUniqueId", "isSameContent", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a<e>
{
  public static final e.a LZF;
  public int FWs;
  public final String LZD;
  public final egx LZG;
  public boolean LZH;
  public GalleryItem.MediaItem LZI;
  public final String id;
  public boolean idG;
  
  static
  {
    AppMethodBeat.i(286193);
    LZF = new e.a((byte)0);
    AppMethodBeat.o(286193);
  }
  
  public e(String paramString1, int paramInt, egx paramegx, String paramString2)
  {
    AppMethodBeat.i(286187);
    this.id = paramString1;
    this.FWs = paramInt;
    this.LZG = paramegx;
    this.LZD = paramString2;
    paramString1 = this.LZG.abml;
    if (paramString1 != null)
    {
      paramString1 = paramString1.toByteArray();
      if (paramString1 != null)
      {
        if (this.LZG.type == 1)
        {
          paramegx = GalleryItem.ImageMediaItem.CREATOR;
          s.s(paramegx, "CREATOR");
          this.LZI = ((GalleryItem.MediaItem)d.a(paramString1, paramegx));
          AppMethodBeat.o(286187);
          return;
        }
        if (this.LZG.type == 2)
        {
          paramegx = GalleryItem.VideoMediaItem.CREATOR;
          s.s(paramegx, "CREATOR");
          this.LZI = ((GalleryItem.MediaItem)d.a(paramString1, paramegx));
        }
      }
    }
    AppMethodBeat.o(286187);
  }
  
  public final int bZB()
  {
    return this.LZG.type;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(286212);
    Object localObject = super.clone();
    AppMethodBeat.o(286212);
    return localObject;
  }
  
  public final String fcs()
  {
    AppMethodBeat.i(286199);
    String str = this.LZD + '-' + this.id;
    AppMethodBeat.o(286199);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.e
 * JD-Core Version:    0.7.0.1
 */