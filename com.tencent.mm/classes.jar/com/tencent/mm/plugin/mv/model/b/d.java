package com.tencent.mm.plugin.mv.model.b;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.thumbplayer.view.recycler.MMRecyclerVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewFinderVideoItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "videoLayoutRecycler", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "(Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;)V", "getVideoLayoutRecycler", "()Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends f<e>
{
  private final com.tencent.mm.plugin.thumbplayer.view.recycler.a LZy;
  
  public d(com.tencent.mm.plugin.thumbplayer.view.recycler.a parama)
  {
    AppMethodBeat.i(286182);
    this.LZy = parama;
    AppMethodBeat.o(286182);
  }
  
  private static final void a(d paramd, FrameLayout paramFrameLayout, e parame, View paramView1, View paramView2)
  {
    AppMethodBeat.i(286200);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFrameLayout);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parame);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/model/preview/MvPreviewFinderVideoItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramd, "this$0");
    s.u(parame, "$item");
    paramView2 = paramd.LZy.hLR();
    paramFrameLayout.removeAllViews();
    paramd = new FrameLayout.LayoutParams(-1, -1);
    paramd.gravity = 17;
    paramFrameLayout.addView((View)paramView2, (ViewGroup.LayoutParams)paramd);
    parame = parame.LZG.EDa;
    long l;
    if (parame != null)
    {
      localObject1 = s.X("video_", Long.valueOf(parame.id));
      paramd = com.tencent.mm.plugin.mv.ui.a.Maz;
      String str = com.tencent.mm.plugin.mv.ui.a.aPC((String)localObject1);
      paramd = parame.objectDesc;
      if (paramd != null)
      {
        paramd = paramd.media;
        if (paramd != null)
        {
          localObject2 = (FinderMedia)p.oL((List)paramd);
          if (localObject2 != null)
          {
            paramFrameLayout = ((FinderMedia)localObject2).url;
            paramd = paramFrameLayout;
            if (paramFrameLayout == null) {
              paramd = "";
            }
            localObject1 = new com.tencent.mm.plugin.thumbplayer.a.b((String)localObject1, str, paramd, kotlin.h.a.eH(((FinderMedia)localObject2).width), kotlin.h.a.eH(((FinderMedia)localObject2).height));
            ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).TBJ = 2;
            ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hVy = "xV2";
            paramFrameLayout = ((FinderMedia)localObject2).url_token;
            paramd = paramFrameLayout;
            if (paramFrameLayout == null) {
              paramd = "";
            }
            ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).msf = paramd;
            ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).decodeKey = ((FinderMedia)localObject2).decodeKey;
            paramFrameLayout = ((FinderMedia)localObject2).thumbUrl;
            paramd = paramFrameLayout;
            if (paramFrameLayout == null) {
              paramd = "";
            }
            ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).thumbUrl = paramd;
            paramFrameLayout = ((FinderMedia)localObject2).thumb_url_token;
            paramd = paramFrameLayout;
            if (paramFrameLayout == null) {
              paramd = "";
            }
            ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).msh = paramd;
            paramd = parame.objectDesc;
            if (paramd != null) {
              break label434;
            }
            l = 0L;
          }
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).vYw = (l * 1000L);
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).nDl = 2;
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hJv = false;
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).TBP = parame;
      paramView2.eDO();
      paramView2.setMediaInfo((com.tencent.mm.plugin.thumbplayer.a.b)localObject1);
      paramView2.hLO();
      paramView2.start();
      paramView2.setLoop(true);
      paramView2.setMute(true);
      paramView1.setVisibility(8);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/model/preview/MvPreviewFinderVideoItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286200);
      return;
      label434:
      paramd = paramd.media;
      if (paramd == null)
      {
        l = 0L;
      }
      else
      {
        paramd = (FinderMedia)p.oK((List)paramd);
        if (paramd == null) {
          l = 0L;
        } else {
          l = paramd.videoDuration;
        }
      }
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(286222);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(286222);
  }
  
  public final int getLayoutId()
  {
    return b.f.LVl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.d
 * JD-Core Version:    0.7.0.1
 */