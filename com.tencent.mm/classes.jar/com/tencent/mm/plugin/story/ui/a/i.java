package com.tencent.mm.plugin.story.ui.a;

import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.az;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;)V", "bindItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "storyItemView", "thumbView", "Landroid/widget/ImageView;", "onBind", "", "item", "position", "", "isActive", "", "reBindBitmap", "plugin-story_release"})
public final class i
  extends RecyclerView.v
{
  private final ImageView mAM;
  final StoryGalleryItemView sIH;
  final StoryCommentView sII;
  final StoryGalleryPostTip sIJ;
  g sIK;
  
  public i(StoryGalleryItemView paramStoryGalleryItemView)
  {
    super((View)paramStoryGalleryItemView);
    AppMethodBeat.i(110138);
    this.sIH = paramStoryGalleryItemView;
    this.sII = paramStoryGalleryItemView.getCommentView();
    this.mAM = paramStoryGalleryItemView.getThumbView();
    this.sIJ = paramStoryGalleryItemView.getPostTipView();
    AppMethodBeat.o(110138);
  }
  
  public final void cFp()
  {
    AppMethodBeat.i(110137);
    Object localObject3 = this.sIK;
    if (localObject3 == null)
    {
      AppMethodBeat.o(110137);
      return;
    }
    Object localObject1 = az.dxH().Nv(((g)localObject3).syr.fDT);
    if (((g)localObject3).syr.cBM())
    {
      ab.i(h.Ot(), "reBindBitmap FakeVideo");
      if (((g)localObject3).syr.syD == null)
      {
        localObject1 = e.eME;
        e.SX().mJ("").d(this.mAM);
        AppMethodBeat.o(110137);
        return;
      }
      localObject1 = ((g)localObject3).syr.syD;
      if (localObject1 != null)
      {
        ab.i(h.Ot(), "load fake localFile:" + ((chf)localObject1).thumbPath + ", position:" + getPosition() + ", videoPath:" + ((chf)localObject1).videoPath);
        localObject2 = e.eME;
        localObject2 = e.SX();
        localObject1 = ((chf)localObject1).thumbPath;
        a.f.b.j.p(localObject1, "it.thumbPath");
        ((a)localObject2).mJ((String)localObject1).e(this.mAM);
        AppMethodBeat.o(110137);
        return;
      }
      AppMethodBeat.o(110137);
      return;
    }
    Object localObject2 = ((g)localObject3).syr.syB;
    localObject3 = ((g)localObject3).userName;
    a.f.b.j.p(localObject1, "fromScene");
    localObject1 = new com.tencent.mm.plugin.story.model.c.d((chl)localObject2, (String)localObject3, (az)localObject1);
    ab.i(h.Ot(), "reBindBitmap NormalVideo " + ((com.tencent.mm.plugin.story.model.c.d)localObject1).Ug());
    localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAK().aE(localObject1).d(this.mAM);
    AppMethodBeat.o(110137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.i
 * JD-Core Version:    0.7.0.1
 */