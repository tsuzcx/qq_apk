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
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;)V", "bindItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "storyItemView", "thumbView", "Landroid/widget/ImageView;", "onBind", "", "item", "position", "", "isActive", "", "reBindBitmap", "plugin-story_release"})
public final class i
  extends RecyclerView.w
{
  final StoryGalleryItemView AVR;
  final StoryCommentView AVS;
  final StoryMsgView AVT;
  final StoryGalleryPostTip AVU;
  com.tencent.mm.plugin.story.f.d.h AVV;
  private final ImageView rAT;
  
  public i(StoryGalleryItemView paramStoryGalleryItemView)
  {
    super((View)paramStoryGalleryItemView);
    AppMethodBeat.i(119773);
    this.AVR = paramStoryGalleryItemView;
    this.AVS = paramStoryGalleryItemView.getCommentView();
    this.AVT = paramStoryGalleryItemView.getMsgView();
    this.rAT = paramStoryGalleryItemView.getThumbView();
    this.AVU = paramStoryGalleryItemView.getPostTipView();
    AppMethodBeat.o(119773);
  }
  
  public final void elL()
  {
    AppMethodBeat.i(119772);
    Object localObject3 = this.AVV;
    if (localObject3 == null)
    {
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject1 = bj.frt().aaU(((com.tencent.mm.plugin.story.f.d.h)localObject3).AMA.hZE);
    if (((com.tencent.mm.plugin.story.f.d.h)localObject3).AMA.eiM())
    {
      ad.i(h.aeD(), "reBindBitmap FakeVideo");
      if (((com.tencent.mm.plugin.story.f.d.h)localObject3).AMA.AML == null)
      {
        localObject1 = e.hcm;
        e.aqF().xW("").c(this.rAT);
        AppMethodBeat.o(119772);
        return;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).AMA.AML;
      if (localObject1 != null)
      {
        ad.i(h.aeD(), "load fake localFile:" + ((c)localObject1).dEE().thumbPath + ", position:" + getPosition() + ", videoPath:" + ((c)localObject1).dEE().videoPath);
        localObject2 = e.hcm;
        localObject2 = e.aqF();
        localObject1 = ((c)localObject1).dEE().thumbPath;
        p.g(localObject1, "it.editorProtoData.thumbPath");
        ((a)localObject2).xW((String)localObject1).a(this.rAT, false);
        AppMethodBeat.o(119772);
        return;
      }
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).AMA.AMK;
    localObject3 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).userName;
    p.g(localObject1, "fromScene");
    localObject1 = new com.tencent.mm.plugin.story.f.c.d((djl)localObject2, (String)localObject3, (bj)localObject1);
    ad.i(h.aeD(), "reBindBitmap NormalVideo " + ((com.tencent.mm.plugin.story.f.c.d)localObject1).aeA());
    localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.eib().bI(localObject1).c(this.rAT);
    AppMethodBeat.o(119772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.i
 * JD-Core Version:    0.7.0.1
 */