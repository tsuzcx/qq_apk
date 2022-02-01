package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bf;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;)V", "bindItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "storyItemView", "thumbView", "Landroid/widget/ImageView;", "onBind", "", "item", "position", "", "isActive", "", "reBindBitmap", "plugin-story_release"})
public final class i
  extends RecyclerView.w
{
  private final ImageView qQT;
  final StoryGalleryItemView zEs;
  final StoryCommentView zEt;
  final StoryMsgView zEu;
  final StoryGalleryPostTip zEv;
  com.tencent.mm.plugin.story.f.d.h zEw;
  
  public i(StoryGalleryItemView paramStoryGalleryItemView)
  {
    super((View)paramStoryGalleryItemView);
    AppMethodBeat.i(119773);
    this.zEs = paramStoryGalleryItemView;
    this.zEt = paramStoryGalleryItemView.getCommentView();
    this.zEu = paramStoryGalleryItemView.getMsgView();
    this.qQT = paramStoryGalleryItemView.getThumbView();
    this.zEv = paramStoryGalleryItemView.getPostTipView();
    AppMethodBeat.o(119773);
  }
  
  public final void dZw()
  {
    AppMethodBeat.i(119772);
    Object localObject3 = this.zEw;
    if (localObject3 == null)
    {
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject1 = bf.fbq().YL(((com.tencent.mm.plugin.story.f.d.h)localObject3).zuF.hGU);
    if (((com.tencent.mm.plugin.story.f.d.h)localObject3).zuF.dWx())
    {
      ac.i(h.abZ(), "reBindBitmap FakeVideo");
      if (((com.tencent.mm.plugin.story.f.d.h)localObject3).zuF.zuQ == null)
      {
        localObject1 = com.tencent.mm.loader.e.gIC;
        com.tencent.mm.loader.e.anT().vf("").c(this.qQT);
        AppMethodBeat.o(119772);
        return;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).zuF.zuQ;
      if (localObject1 != null)
      {
        ac.i(h.abZ(), "load fake localFile:" + ((com.tencent.mm.plugin.recordvideo.background.e)localObject1).dui().thumbPath + ", position:" + getPosition() + ", videoPath:" + ((com.tencent.mm.plugin.recordvideo.background.e)localObject1).dui().videoPath);
        localObject2 = com.tencent.mm.loader.e.gIC;
        localObject2 = com.tencent.mm.loader.e.anT();
        localObject1 = ((com.tencent.mm.plugin.recordvideo.background.e)localObject1).dui().thumbPath;
        k.g(localObject1, "it.editorProtoData.thumbPath");
        ((a)localObject2).vf((String)localObject1).a(this.qQT, false);
        AppMethodBeat.o(119772);
        return;
      }
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).zuF.zuP;
    localObject3 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).userName;
    k.g(localObject1, "fromScene");
    localObject1 = new com.tencent.mm.plugin.story.f.c.d((ddy)localObject2, (String)localObject3, (bf)localObject1);
    ac.i(h.abZ(), "reBindBitmap NormalVideo " + ((com.tencent.mm.plugin.story.f.c.d)localObject1).abW());
    localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVM().bG(localObject1).c(this.qQT);
    AppMethodBeat.o(119772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.i
 * JD-Core Version:    0.7.0.1
 */