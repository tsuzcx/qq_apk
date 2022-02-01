package com.tencent.mm.plugin.story.ui.a;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.v;
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
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;)V", "bindItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "storyItemView", "thumbView", "Landroid/widget/ImageView;", "onBind", "", "item", "position", "", "isActive", "", "reBindBitmap", "plugin-story_release"})
public final class i
  extends RecyclerView.v
{
  final StoryGalleryItemView LSh;
  final StoryCommentView LSi;
  final StoryMsgView LSj;
  final StoryGalleryPostTip LSk;
  com.tencent.mm.plugin.story.f.d.h LSl;
  private final ImageView wPh;
  
  public i(StoryGalleryItemView paramStoryGalleryItemView)
  {
    super((View)paramStoryGalleryItemView);
    AppMethodBeat.i(119773);
    this.LSh = paramStoryGalleryItemView;
    this.LSi = paramStoryGalleryItemView.getCommentView();
    this.LSj = paramStoryGalleryItemView.getMsgView();
    this.wPh = paramStoryGalleryItemView.getThumbView();
    this.LSk = paramStoryGalleryItemView.getPostTipView();
    AppMethodBeat.o(119773);
  }
  
  public final void ggr()
  {
    AppMethodBeat.i(119772);
    Object localObject3 = this.LSl;
    if (localObject3 == null)
    {
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject1 = bp.hzn().asH(((com.tencent.mm.plugin.story.f.d.h)localObject3).LIV.createTime);
    if (((com.tencent.mm.plugin.story.f.d.h)localObject3).LIV.gdp())
    {
      Log.i(h.aBy(), "reBindBitmap FakeVideo");
      if (((com.tencent.mm.plugin.story.f.d.h)localObject3).LIV.LJg == null)
      {
        localObject1 = e.kMy;
        e.aRs().Oq("").c(this.wPh);
        AppMethodBeat.o(119772);
        return;
      }
      localObject1 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).LIV.LJg;
      if (localObject1 != null)
      {
        Log.i(h.aBy(), "load fake localFile:" + ((c)localObject1).fuN().thumbPath + ", position:" + getPosition() + ", videoPath:" + ((c)localObject1).fuN().videoPath);
        localObject2 = e.kMy;
        localObject2 = e.aRs();
        localObject1 = ((c)localObject1).fuN().thumbPath;
        p.j(localObject1, "it.editorProtoData.thumbPath");
        ((a)localObject2).Oq((String)localObject1).a(this.wPh, false);
        AppMethodBeat.o(119772);
        return;
      }
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).LIV.LJf;
    localObject3 = ((com.tencent.mm.plugin.story.f.d.h)localObject3).userName;
    p.j(localObject1, "fromScene");
    localObject1 = new com.tencent.mm.plugin.story.f.c.d((enu)localObject2, (String)localObject3, (bp)localObject1);
    Log.i(h.aBy(), "reBindBitmap NormalVideo " + ((com.tencent.mm.plugin.story.f.c.d)localObject1).aBv());
    localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcE().bQ(localObject1).c(this.wPh);
    AppMethodBeat.o(119772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.i
 * JD-Core Version:    0.7.0.1
 */