package com.tencent.mm.plugin.mv.model.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.plugin.thumbplayer.view.recycler.MMRecyclerVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewFinderVideoItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "videoLayoutRecycler", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "(Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;)V", "getVideoLayoutRecycler", "()Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"})
public final class d
  extends com.tencent.mm.view.recyclerview.e<e>
{
  final com.tencent.mm.plugin.thumbplayer.view.recycler.a GdK;
  
  public d(com.tencent.mm.plugin.thumbplayer.view.recycler.a parama)
  {
    AppMethodBeat.i(226374);
    this.GdK = parama;
    AppMethodBeat.o(226374);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(226372);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(226372);
  }
  
  public final int getLayoutId()
  {
    return b.f.FZo;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(d paramd, FrameLayout paramFrameLayout, e parame, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(236667);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/model/preview/MvPreviewFinderVideoItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      MMRecyclerVideoLayout localMMRecyclerVideoLayout = this.GdW.GdK.gpf();
      this.GdN.removeAllViews();
      paramView = new FrameLayout.LayoutParams(-1, -1);
      paramView.gravity = 17;
      this.GdN.addView((View)localMMRecyclerVideoLayout, (ViewGroup.LayoutParams)paramView);
      FinderObject localFinderObject = this.GdO.Gea.Gbc;
      Object localObject2;
      if (localFinderObject != null)
      {
        localObject2 = "video_" + localFinderObject.id;
        paramView = com.tencent.mm.plugin.mv.ui.a.Gfi;
        String str = com.tencent.mm.plugin.mv.ui.a.aSI((String)localObject2);
        paramView = localFinderObject.objectDesc;
        if (paramView != null)
        {
          paramView = paramView.media;
          if (paramView != null)
          {
            FinderMedia localFinderMedia = (FinderMedia)j.lp((List)paramView);
            if (localFinderMedia != null)
            {
              localObject1 = localFinderMedia.url;
              paramView = (View)localObject1;
              if (localObject1 == null) {
                paramView = "";
              }
              localObject2 = new com.tencent.mm.plugin.thumbplayer.e.d((String)localObject2, str, paramView, kotlin.h.a.dm(localFinderMedia.width), kotlin.h.a.dm(localFinderMedia.height));
              ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).MSA = Integer.valueOf(2);
              ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).fPD = "xV2";
              localObject1 = localFinderMedia.url_token;
              paramView = (View)localObject1;
              if (localObject1 == null) {
                paramView = "";
              }
              ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).beR(paramView);
              ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).decodeKey = localFinderMedia.decodeKey;
              localObject1 = localFinderMedia.thumbUrl;
              paramView = (View)localObject1;
              if (localObject1 == null) {
                paramView = "";
              }
              ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).Oc(paramView);
              localObject1 = localFinderMedia.thumb_url_token;
              paramView = (View)localObject1;
              if (localObject1 == null) {
                paramView = "";
              }
              ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).beS(paramView);
              paramView = localFinderObject.objectDesc;
              if (paramView == null) {
                break label465;
              }
              paramView = paramView.media;
              if (paramView == null) {
                break label465;
              }
              paramView = (FinderMedia)j.lo((List)paramView);
              if (paramView == null) {
                break label465;
              }
            }
          }
        }
      }
      label465:
      for (long l = paramView.videoDuration;; l = 0L)
      {
        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).sTg = (l * 1000L);
        paramView = MMThumbPlayerTextureView.MUw;
        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).kYn = MMThumbPlayerTextureView.gpa();
        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).fEF = false;
        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject2).MSH = localFinderObject;
        localMMRecyclerVideoLayout.dLb();
        localMMRecyclerVideoLayout.setMediaInfo((com.tencent.mm.plugin.thumbplayer.e.d)localObject2);
        localMMRecyclerVideoLayout.goW();
        localMMRecyclerVideoLayout.start();
        localMMRecyclerVideoLayout.setLoop(true);
        localMMRecyclerVideoLayout.setMute(true);
        paramView = this.GdP;
        p.j(paramView, "playBtn");
        paramView.setVisibility(8);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/model/preview/MvPreviewFinderVideoItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(236667);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.d
 * JD-Core Version:    0.7.0.1
 */