package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bk;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;)V", "bindItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "storyItemView", "thumbView", "Landroid/widget/ImageView;", "onBind", "", "item", "position", "", "isActive", "", "reBindBitmap", "plugin-story_release"})
public final class i
  extends RecyclerView.w
{
  final StoryGalleryItemView Bnp;
  final StoryCommentView Bnq;
  final StoryMsgView Bnr;
  final StoryGalleryPostTip Bns;
  com.tencent.mm.plugin.story.f.d.h Bnt;
  private final ImageView rJe;
  
  public i(StoryGalleryItemView paramStoryGalleryItemView)
  {
    super((View)paramStoryGalleryItemView);
    AppMethodBeat.i(119773);
    this.Bnp = paramStoryGalleryItemView;
    this.Bnq = paramStoryGalleryItemView.getCommentView();
    this.Bnr = paramStoryGalleryItemView.getMsgView();
    this.rJe = paramStoryGalleryItemView.getThumbView();
    this.Bns = paramStoryGalleryItemView.getPostTipView();
    AppMethodBeat.o(119773);
  }
  
  public final void epu()
  {
    AppMethodBeat.i(119772);
    Object localObject3 = this.Bnt;
    if (localObject3 == null)
    {
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject1 = bk.fvt().abC(((com.tencent.mm.plugin.story.f.d.h)localObject3).Bec.icw);
    if (((com.tencent.mm.plugin.story.f.d.h)localObject3).Bec.emu())
    {
      ae.i(h.aeP(), "reBindBitmap FakeVideo");
      if (((com.tencent.mm.plugin.story.f.d.h)localObject3).Bec.Ben == null)
      {
        localObject1 = e.hfa;
        e.aqU().yG("").c(this.rJe);
        AppMethodBeat.o(119772);
        return;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).Bec.Ben;
      if (localObject1 != null)
      {
        ae.i(h.aeP(), "load fake localFile:" + ((c)localObject1).dHV().thumbPath + ", position:" + getPosition() + ", videoPath:" + ((c)localObject1).dHV().videoPath);
        localObject2 = e.hfa;
        localObject2 = e.aqU();
        localObject1 = ((c)localObject1).dHV().thumbPath;
        p.g(localObject1, "it.editorProtoData.thumbPath");
        ((a)localObject2).yG((String)localObject1).a(this.rJe, false);
        AppMethodBeat.o(119772);
        return;
      }
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).Bec.Bem;
    localObject3 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).userName;
    p.g(localObject1, "fromScene");
    localObject1 = new com.tencent.mm.plugin.story.f.c.d((dkg)localObject2, (String)localObject3, (bk)localObject1);
    ae.i(h.aeP(), "reBindBitmap NormalVideo " + ((com.tencent.mm.plugin.story.f.c.d)localObject1).aeM());
    localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elJ().bI(localObject1).c(this.rJe);
    AppMethodBeat.o(119772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.i
 * JD-Core Version:    0.7.0.1
 */