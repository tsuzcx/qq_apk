package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.f.f.d;
import com.tencent.mm.plugin.story.h.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$setDataSeed$1", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "updateChatRoomState", "", "hasStory", "", "hasUnread", "updateGalleryUserList", "userList", "", "", "unreadList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateUserState", "username", "plugin-story_release"})
public final class StoryGalleryView$r
  implements l.a
{
  StoryGalleryView$r(d paramd) {}
  
  public final void a(List<String> paramList, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(120471);
    p.h(paramList, "userList");
    p.h(paramArrayList, "unreadList");
    paramArrayList = StoryGalleryView.FGV;
    Log.i(StoryGalleryView.access$getTAG$cp(), "updateGalleryUserList: " + paramList.size());
    StoryGalleryView.a(this.FGW, paramList);
    paramArrayList = b.FtL;
    b.hv(paramList);
    this.FHe.destroy();
    AppMethodBeat.o(120471);
  }
  
  public final void as(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void cs(String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.r
 * JD-Core Version:    0.7.0.1
 */