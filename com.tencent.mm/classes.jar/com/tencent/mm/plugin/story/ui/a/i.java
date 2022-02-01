package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bc;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;)V", "bindItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "storyItemView", "thumbView", "Landroid/widget/ImageView;", "onBind", "", "item", "position", "", "isActive", "", "reBindBitmap", "plugin-story_release"})
public final class i
  extends RecyclerView.v
{
  private final ImageView qir;
  final StoryGalleryItemView yqV;
  final StoryCommentView yqW;
  final StoryMsgView yqX;
  final StoryGalleryPostTip yqY;
  com.tencent.mm.plugin.story.f.d.h yqZ;
  
  public i(StoryGalleryItemView paramStoryGalleryItemView)
  {
    super((View)paramStoryGalleryItemView);
    AppMethodBeat.i(119773);
    this.yqV = paramStoryGalleryItemView;
    this.yqW = paramStoryGalleryItemView.getCommentView();
    this.yqX = paramStoryGalleryItemView.getMsgView();
    this.qir = paramStoryGalleryItemView.getThumbView();
    this.yqY = paramStoryGalleryItemView.getPostTipView();
    AppMethodBeat.o(119773);
  }
  
  public final void dKW()
  {
    AppMethodBeat.i(119772);
    Object localObject3 = this.yqZ;
    if (localObject3 == null)
    {
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject1 = bc.eLM().WB(((com.tencent.mm.plugin.story.f.d.h)localObject3).yhF.hgr);
    if (((com.tencent.mm.plugin.story.f.d.h)localObject3).yhF.dHW())
    {
      ad.i(h.abb(), "reBindBitmap FakeVideo");
      if (((com.tencent.mm.plugin.story.f.d.h)localObject3).yhF.yhQ == null)
      {
        localObject1 = e.ghT;
        e.agS().rd("").c(this.qir);
        AppMethodBeat.o(119772);
        return;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).yhF.yhQ;
      if (localObject1 != null)
      {
        ad.i(h.abb(), "load fake localFile:" + ((com.tencent.mm.plugin.recordvideo.background.d)localObject1).dgA().thumbPath + ", position:" + getPosition() + ", videoPath:" + ((com.tencent.mm.plugin.recordvideo.background.d)localObject1).dgA().videoPath);
        localObject2 = e.ghT;
        localObject2 = e.agS();
        localObject1 = ((com.tencent.mm.plugin.recordvideo.background.d)localObject1).dgA().thumbPath;
        k.g(localObject1, "it.editorProtoData.thumbPath");
        ((a)localObject2).rd((String)localObject1).a(this.qir, false);
        AppMethodBeat.o(119772);
        return;
      }
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).yhF.yhP;
    localObject3 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).userName;
    k.g(localObject1, "fromScene");
    localObject1 = new com.tencent.mm.plugin.story.f.c.d((cym)localObject2, (String)localObject3, (bc)localObject1);
    ad.i(h.abb(), "reBindBitmap NormalVideo " + ((com.tencent.mm.plugin.story.f.c.d)localObject1).aaX());
    localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHl().bI(localObject1).c(this.qir);
    AppMethodBeat.o(119772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.i
 * JD-Core Version:    0.7.0.1
 */