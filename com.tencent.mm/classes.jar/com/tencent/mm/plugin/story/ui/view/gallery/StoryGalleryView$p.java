package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.k.a;
import com.tencent.mm.plugin.story.g.b;
import com.tencent.mm.plugin.story.model.f.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$setDataSeed$1", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "updateChatRoomState", "", "hasStory", "", "hasUnread", "updateGalleryUserList", "userList", "", "", "unreadList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateUserState", "username", "plugin-story_release"})
public final class StoryGalleryView$p
  implements k.a
{
  StoryGalleryView$p(d paramd) {}
  
  public final void L(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void a(List<String> paramList, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(110819);
    j.q(paramList, "userList");
    j.q(paramArrayList, "unreadList");
    paramArrayList = StoryGalleryView.sTW;
    ab.i(StoryGalleryView.access$getTAG$cp(), "updateGalleryUserList: " + paramList.size());
    StoryGalleryView.a(this.sTX, paramList);
    paramArrayList = b.sDR;
    b.dE(paramList);
    this.sUf.destroy();
    AppMethodBeat.o(110819);
  }
  
  public final void by(String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.p
 * JD-Core Version:    0.7.0.1
 */