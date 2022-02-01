package com.tencent.mm.plugin.mv.model.b;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.thumbplayer.view.recycler.MMRecyclerVideoLayout;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewAlbumVideoItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "videoLayoutRecycler", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "(Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;)V", "getVideoLayoutRecycler", "()Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateMedia", "videoMediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "callback", "Lkotlin/Function0;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f<e>
{
  private final com.tencent.mm.plugin.thumbplayer.view.recycler.a LZy;
  
  public b(com.tencent.mm.plugin.thumbplayer.view.recycler.a parama)
  {
    AppMethodBeat.i(286170);
    this.LZy = parama;
    AppMethodBeat.o(286170);
  }
  
  private static final void a(b paramb, FrameLayout paramFrameLayout, e parame, View paramView1, View paramView2)
  {
    AppMethodBeat.i(286185);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramFrameLayout);
    localb.cH(parame);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/model/preview/MvPreviewAlbumVideoItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    s.u(parame, "$item");
    paramView2 = paramb.LZy.hLR();
    paramFrameLayout.removeAllViews();
    paramb = new FrameLayout.LayoutParams(-1, -1);
    paramb.gravity = 17;
    paramFrameLayout.addView((View)paramView2, (ViewGroup.LayoutParams)paramb);
    paramb = parame.LZI;
    int i;
    label150:
    int j;
    label157:
    int k;
    if ((paramb instanceof GalleryItem.VideoMediaItem))
    {
      paramb = (GalleryItem.VideoMediaItem)paramb;
      if (paramb != null) {
        break label323;
      }
      i = 0;
      if (paramb != null) {
        break label332;
      }
      j = 0;
      if ((paramb == null) || (paramb.nCg != 90)) {
        break label341;
      }
      k = 1;
      label173:
      if (k == 0)
      {
        if ((paramb == null) || (paramb.nCg != 270)) {
          break label347;
        }
        k = 1;
        label195:
        if (k == 0) {}
      }
      else
      {
        i = paramb.videoHeight;
        j = paramb.videoWidth;
      }
      parame = s.X("previewId-", parame.id);
      if (paramb != null) {
        break label353;
      }
      paramb = "";
    }
    for (;;)
    {
      paramb = new com.tencent.mm.plugin.thumbplayer.a.b(parame, paramb, "", i, j);
      paramb.hJv = true;
      paramb.TBK = true;
      paramView2.eDO();
      paramView2.setMediaInfo(paramb);
      paramView2.hLO();
      paramView2.start();
      paramView2.setLoop(true);
      paramView2.setMute(true);
      paramView1.setVisibility(8);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/model/preview/MvPreviewAlbumVideoItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286185);
      return;
      paramb = null;
      break;
      label323:
      i = paramb.videoWidth;
      break label150;
      label332:
      j = paramb.videoHeight;
      break label157;
      label341:
      k = 0;
      break label173;
      label347:
      k = 0;
      break label195;
      label353:
      paramFrameLayout = paramb.bud();
      paramb = paramFrameLayout;
      if (paramFrameLayout == null) {
        paramb = "";
      }
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(286203);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(286203);
  }
  
  public final int getLayoutId()
  {
    return b.f.LVl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.b
 * JD-Core Version:    0.7.0.1
 */