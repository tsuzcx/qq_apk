package com.tencent.mm.plugin.mv.model.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.thumbplayer.view.recycler.MMRecyclerVideoLayout;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewAlbumVideoItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "videoLayoutRecycler", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "(Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;)V", "getVideoLayoutRecycler", "()Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateMedia", "videoMediaItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "callback", "Lkotlin/Function0;", "plugin-mv_release"})
public final class b
  extends com.tencent.mm.view.recyclerview.e<e>
{
  final com.tencent.mm.plugin.thumbplayer.view.recycler.a GdK;
  
  public b(com.tencent.mm.plugin.thumbplayer.view.recycler.a parama)
  {
    AppMethodBeat.i(229817);
    this.GdK = parama;
    AppMethodBeat.o(229817);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(229811);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(229811);
  }
  
  public final int getLayoutId()
  {
    return b.f.FZo;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(b paramb, FrameLayout paramFrameLayout, e parame, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227684);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/model/preview/MvPreviewAlbumVideoItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      MMRecyclerVideoLayout localMMRecyclerVideoLayout = this.GdM.GdK.gpf();
      this.GdN.removeAllViews();
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.GdN.addView((View)localMMRecyclerVideoLayout, (ViewGroup.LayoutParams)paramView);
      localObject = this.GdO.GdY;
      paramView = (View)localObject;
      if (!(localObject instanceof GalleryItem.VideoMediaItem)) {
        paramView = null;
      }
      paramView = (GalleryItem.VideoMediaItem)paramView;
      int i;
      if (paramView != null)
      {
        i = paramView.videoWidth;
        if (paramView == null) {
          break label329;
        }
      }
      label329:
      for (int j = paramView.videoHeight;; j = 0)
      {
        int m;
        int k;
        if ((paramView == null) || (paramView.kWG != 90))
        {
          m = i;
          k = j;
          if (paramView != null)
          {
            m = i;
            k = j;
            if (paramView.kWG != 270) {}
          }
        }
        else
        {
          m = paramView.videoHeight;
          k = paramView.videoWidth;
        }
        String str = "previewId-" + this.GdO.id;
        if (paramView != null)
        {
          localObject = paramView.aZe();
          paramView = (View)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramView = "";
        }
        paramView = new d(str, paramView, "", m, k);
        paramView.fEF = true;
        paramView.MSB = true;
        localMMRecyclerVideoLayout.dLb();
        localMMRecyclerVideoLayout.setMediaInfo(paramView);
        localMMRecyclerVideoLayout.goW();
        localMMRecyclerVideoLayout.start();
        localMMRecyclerVideoLayout.setLoop(true);
        localMMRecyclerVideoLayout.setMute(true);
        paramView = this.GdP;
        p.j(paramView, "playBtn");
        paramView.setVisibility(8);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/model/preview/MvPreviewAlbumVideoItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(227684);
        return;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.b
 * JD-Core Version:    0.7.0.1
 */