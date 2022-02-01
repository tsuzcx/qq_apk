package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;)V", "bindItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "storyItemView", "thumbView", "Landroid/widget/ImageView;", "onBind", "", "item", "position", "", "isActive", "", "reBindBitmap", "plugin-story_release"})
public final class i
  extends RecyclerView.v
{
  final StoryGalleryItemView Fyf;
  final StoryCommentView Fyg;
  final StoryMsgView Fyh;
  final StoryGalleryPostTip Fyi;
  com.tencent.mm.plugin.story.f.d.h Fyj;
  private final ImageView tiQ;
  
  public i(StoryGalleryItemView paramStoryGalleryItemView)
  {
    super((View)paramStoryGalleryItemView);
    AppMethodBeat.i(119773);
    this.Fyf = paramStoryGalleryItemView;
    this.Fyg = paramStoryGalleryItemView.getCommentView();
    this.Fyh = paramStoryGalleryItemView.getMsgView();
    this.tiQ = paramStoryGalleryItemView.getThumbView();
    this.Fyi = paramStoryGalleryItemView.getPostTipView();
    AppMethodBeat.o(119773);
  }
  
  public final void frU()
  {
    AppMethodBeat.i(119772);
    Object localObject3 = this.Fyj;
    if (localObject3 == null)
    {
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject1 = bp.gDa().akk(((com.tencent.mm.plugin.story.f.d.h)localObject3).FoT.iXu);
    if (((com.tencent.mm.plugin.story.f.d.h)localObject3).FoT.foV())
    {
      Log.i(h.auD(), "reBindBitmap FakeVideo");
      if (((com.tencent.mm.plugin.story.f.d.h)localObject3).FoT.Fpe == null)
      {
        localObject1 = e.hXU;
        e.aJs().Hf("").c(this.tiQ);
        AppMethodBeat.o(119772);
        return;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).FoT.Fpe;
      if (localObject1 != null)
      {
        Log.i(h.auD(), "load fake localFile:" + ((c)localObject1).eII().thumbPath + ", position:" + getPosition() + ", videoPath:" + ((c)localObject1).eII().videoPath);
        localObject2 = e.hXU;
        localObject2 = e.aJs();
        localObject1 = ((c)localObject1).eII().thumbPath;
        p.g(localObject1, "it.editorProtoData.thumbPath");
        ((a)localObject2).Hf((String)localObject1).a(this.tiQ, false);
        AppMethodBeat.o(119772);
        return;
      }
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).FoT.Fpd;
    localObject3 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).userName;
    p.g(localObject1, "fromScene");
    localObject1 = new com.tencent.mm.plugin.story.f.c.d((edt)localObject2, (String)localObject3, (bp)localObject1);
    Log.i(h.auD(), "reBindBitmap NormalVideo " + ((com.tencent.mm.plugin.story.f.c.d)localObject1).auA());
    localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.fok().bQ(localObject1).c(this.tiQ);
    AppMethodBeat.o(119772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.i
 * JD-Core Version:    0.7.0.1
 */