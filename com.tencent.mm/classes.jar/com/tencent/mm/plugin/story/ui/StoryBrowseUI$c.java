package com.tencent.mm.plugin.story.ui;

import a.a.j;
import a.f.b.u.d;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.model.d.a;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryBrowseUI$c
  implements Runnable
{
  StoryBrowseUI$c(StoryBrowseUI paramStoryBrowseUI, u.d paramd1, String paramString, u.d paramd2) {}
  
  public final void run()
  {
    AppMethodBeat.i(154830);
    Object localObject = StoryBrowseUI.b(this.sHk);
    if (localObject != null)
    {
      ((StoryGalleryView)localObject).getVideoViewMgrFromPreLoad();
      ((StoryGalleryView)localObject).K(false, true);
      ((StoryGalleryView)localObject).setVideoViewMgrFromPreLoad(false);
      ((StoryGalleryView)localObject).setCurrentHItem(StoryBrowseUI.d(this.sHk));
    }
    if ((ArrayList)this.sHn.BNq == null) {
      this.sHn.BNq = new ArrayList();
    }
    localObject = i.sFa;
    List localList;
    i locali;
    if (i.cDo().FF() != 4L)
    {
      localObject = i.sFa;
      if (i.cDo().FF() != 6L) {}
    }
    else
    {
      localObject = (e)g.G(e.class);
      localList = (List)this.sHn.BNq;
      locali = i.sFa;
      ((e)localObject).reportWaitPlayList(localList, i.cDo().FF());
      AppMethodBeat.o(154830);
      return;
    }
    localObject = i.sFa;
    if (i.cDo().FF() == 5L)
    {
      localObject = (e)g.G(e.class);
      localList = (List)j.V(new String[] { this.hDt });
      locali = i.sFa;
      ((e)localObject).reportWaitPlayList(localList, i.cDo().FF());
      AppMethodBeat.o(154830);
      return;
    }
    localObject = i.sFa;
    if (i.cDo().FF() != 12L)
    {
      localObject = i.sFa;
      if (i.cDo().FF() != 13L) {}
    }
    else if ((this.sHo.BNq != null) && ((this.sHo.BNq instanceof a)))
    {
      localObject = (e)g.G(e.class);
      localList = ((a)this.sHo.BNq).fxt;
      locali = i.sFa;
      ((e)localObject).reportWaitPlayList(localList, i.cDo().FF());
    }
    AppMethodBeat.o(154830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryBrowseUI.c
 * JD-Core Version:    0.7.0.1
 */