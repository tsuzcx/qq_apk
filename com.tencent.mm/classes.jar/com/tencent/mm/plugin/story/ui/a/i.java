package com.tencent.mm.plugin.story.ui.a;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.d.j;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;)V", "bindItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "storyItemView", "thumbView", "Landroid/widget/ImageView;", "onBind", "", "item", "position", "", "isActive", "", "reBindBitmap", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends RecyclerView.v
{
  private final ImageView AlJ;
  final StoryGalleryPostTip SuA;
  com.tencent.mm.plugin.story.model.d.h SuB;
  final StoryGalleryItemView Sux;
  final StoryCommentView Suy;
  final StoryMsgView Suz;
  
  public i(StoryGalleryItemView paramStoryGalleryItemView)
  {
    super((View)paramStoryGalleryItemView);
    AppMethodBeat.i(119773);
    this.Sux = paramStoryGalleryItemView;
    this.Suy = paramStoryGalleryItemView.getCommentView();
    this.Suz = paramStoryGalleryItemView.getMsgView();
    this.AlJ = paramStoryGalleryItemView.getThumbView();
    this.SuA = paramStoryGalleryItemView.getPostTipView();
    AppMethodBeat.o(119773);
  }
  
  public final void hzI()
  {
    AppMethodBeat.i(119772);
    Object localObject3 = this.SuB;
    if (localObject3 == null)
    {
      AppMethodBeat.o(119772);
      return;
    }
    Object localObject1 = br.jbn();
    ((br)localObject1).time = ((com.tencent.mm.plugin.story.model.d.h)localObject3).Smr.createTime;
    Object localObject2;
    if (((com.tencent.mm.plugin.story.model.d.h)localObject3).Smr.hwL())
    {
      Log.i(h.aUw(), "reBindBitmap FakeVideo");
      if (((com.tencent.mm.plugin.story.model.d.h)localObject3).Smr.Smy == null)
      {
        localObject1 = e.noo;
        e.blh().GE("").d(this.AlJ);
        AppMethodBeat.o(119772);
        return;
      }
      localObject1 = ((com.tencent.mm.plugin.story.model.d.h)localObject3).Smr.Smy;
      if (localObject1 != null)
      {
        Log.i(h.aUw(), "load fake localFile:" + ((c)localObject1).gGD().thumbPath + ", position:" + getPosition() + ", videoPath:" + ((c)localObject1).gGD().videoPath);
        localObject2 = e.noo;
        localObject2 = e.blh();
        localObject1 = ((c)localObject1).gGD().thumbPath;
        s.s(localObject1, "it.editorProtoData.thumbPath");
        ((a)localObject2).GE((String)localObject1).a(this.AlJ, false);
        AppMethodBeat.o(119772);
      }
    }
    else
    {
      localObject2 = ((com.tencent.mm.plugin.story.model.d.h)localObject3).Smr.Smx;
      localObject3 = ((com.tencent.mm.plugin.story.model.d.h)localObject3).userName;
      s.s(localObject1, "fromScene");
      localObject1 = new com.tencent.mm.plugin.story.model.c.d((fis)localObject2, (String)localObject3, (br)localObject1);
      Log.i(h.aUw(), s.X("reBindBitmap NormalVideo ", ((com.tencent.mm.plugin.story.model.c.d)localObject1).aUt()));
      localObject2 = StoryCore.SjP;
      StoryCore.b.hvZ().dk(localObject1).d(this.AlJ);
    }
    AppMethodBeat.o(119772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.i
 * JD-Core Version:    0.7.0.1
 */