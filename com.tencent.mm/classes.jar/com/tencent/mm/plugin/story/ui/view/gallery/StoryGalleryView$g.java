package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.az;
import com.tencent.mm.plugin.story.api.m.a;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$galleryGroupUpdateCallback$1", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "deleteGroup", "", "groupIndex", "", "notifyDeleteResult", "isOk", "", "notifyGroup", "notifyIndicator", "notifyItemsChange", "start", "count", "notifyItemsInsert", "notifyItemsRemove", "notifySetFavResult", "favorite", "success", "notifySetPrivacyResult", "isPrivacy", "updateGroup", "items", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "updateGroupCount", "plugin-story_release"})
public final class StoryGalleryView$g
  implements com.tencent.mm.plugin.story.f.d
{
  StoryGalleryView$g(Context paramContext) {}
  
  public final void FM(int paramInt)
  {
    AppMethodBeat.i(110799);
    if (paramInt <= 1) {
      StoryGalleryView.w(this.sTX).cFZ();
    }
    StoryGalleryView.g(this.sTX).clear();
    int i = 0;
    while (i < paramInt)
    {
      StoryGalleryView.g(this.sTX).add(new ArrayList());
      i += 1;
    }
    AppMethodBeat.o(110799);
  }
  
  public final void FN(int paramInt)
  {
    AppMethodBeat.i(110801);
    Object localObject = StoryGalleryView.sTW;
    ab.i(StoryGalleryView.access$getTAG$cp(), "deleteGroup: exitCheck " + this.sTX.getDeleteWhenFirstEmpty() + ' ' + paramInt + ' ' + StoryGalleryView.h(this.sTX));
    if ((this.sTX.getDeleteWhenFirstEmpty()) && (paramInt == 0) && (StoryGalleryView.h(this.sTX) <= 0)) {
      i = 1;
    }
    while (i != 0)
    {
      localObject = StoryGalleryView.p(this.sTX);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.story.api.g)localObject).cbT();
        AppMethodBeat.o(110801);
        return;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(110801);
        return;
      }
    }
    int i = StoryGalleryView.g(this.sTX).size();
    if (paramInt < 0) {}
    for (;;)
    {
      if (StoryGalleryView.g(this.sTX).size() <= 1) {
        StoryGalleryView.w(this.sTX).cFZ();
      }
      if (!StoryGalleryView.g(this.sTX).isEmpty()) {
        break;
      }
      localObject = StoryGalleryView.p(this.sTX);
      if (localObject != null) {
        ((com.tencent.mm.plugin.story.api.g)localObject).cbR();
      }
      StoryGalleryView.f(this.sTX).setVisibility(8);
      AppMethodBeat.o(110801);
      return;
      if (i > paramInt)
      {
        StoryGalleryView.g(this.sTX).remove(paramInt);
        StoryGalleryView.x(this.sTX).dH((List)StoryGalleryView.g(this.sTX));
        StoryGalleryView.x(this.sTX).bT(paramInt);
        localObject = StoryGalleryView.q(this.sTX).sSO;
        if ((localObject != null) && (paramInt >= 0) && (paramInt < ((com.tencent.mm.plugin.story.ui.a.d)localObject).iRT.size() - 2))
        {
          ((com.tencent.mm.plugin.story.ui.a.d)localObject).iRT.remove(paramInt + 1);
          ((com.tencent.mm.plugin.story.ui.a.d)localObject).bT(paramInt + 1);
        }
      }
    }
    localObject = StoryGalleryView.p(this.sTX);
    if (localObject != null) {
      ((com.tencent.mm.plugin.story.api.g)localObject).cbS();
    }
    if (!StoryGalleryView.k(this.sTX))
    {
      StoryGalleryView.f(this.sTX).setAlpha(1.0F);
      StoryGalleryView.f(this.sTX).setVisibility(0);
    }
    AppMethodBeat.o(110801);
  }
  
  public final void FO(int paramInt)
  {
    AppMethodBeat.i(110802);
    Object localObject = StoryGalleryView.sTW;
    ab.b(StoryGalleryView.access$getTAG$cp(), "notifyGroup, groupIndex:" + paramInt + ", selectedRow:" + StoryGalleryView.h(this.sTX), new Object[0]);
    if (StoryGalleryView.h(this.sTX) == paramInt)
    {
      localObject = StoryGalleryView.y(this.sTX);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.story.ui.a.g)localObject).notifyDataSetChanged();
        AppMethodBeat.o(110802);
        return;
      }
      AppMethodBeat.o(110802);
      return;
    }
    StoryGalleryView.d(this.sTX).post((Runnable)new StoryGalleryView.g.a(this, paramInt));
    AppMethodBeat.o(110802);
  }
  
  public final void N(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(151312);
    if (paramBoolean2)
    {
      StoryGalleryView.q(this.sTX).mr(paramBoolean1);
      AppMethodBeat.o(151312);
      return;
    }
    if (paramBoolean1) {
      h.J(this.hEq, "", this.hEq.getResources().getString(2131304157));
    }
    AppMethodBeat.o(151312);
  }
  
  public final void ah(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(110803);
    if (StoryGalleryView.h(this.sTX) == paramInt1)
    {
      com.tencent.mm.plugin.story.ui.a.g localg = StoryGalleryView.y(this.sTX);
      if (localg != null)
      {
        localg.ap(paramInt2, paramInt3);
        AppMethodBeat.o(110803);
        return;
      }
      AppMethodBeat.o(110803);
      return;
    }
    StoryGalleryView.d(this.sTX).post((Runnable)new StoryGalleryView.g.c(this, paramInt1));
    AppMethodBeat.o(110803);
  }
  
  public final void ai(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(110804);
    if (StoryGalleryView.h(this.sTX) == paramInt1)
    {
      com.tencent.mm.plugin.story.ui.a.g localg = StoryGalleryView.y(this.sTX);
      if (localg != null)
      {
        localg.aq(paramInt2, paramInt3);
        AppMethodBeat.o(110804);
        return;
      }
      AppMethodBeat.o(110804);
      return;
    }
    StoryGalleryView.d(this.sTX).post((Runnable)new StoryGalleryView.g.d(this, paramInt1));
    AppMethodBeat.o(110804);
  }
  
  public final void aj(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(110805);
    if (StoryGalleryView.h(this.sTX) == paramInt1)
    {
      com.tencent.mm.plugin.story.ui.a.g localg = StoryGalleryView.y(this.sTX);
      if (localg != null)
      {
        localg.an(paramInt2, paramInt3);
        AppMethodBeat.o(110805);
        return;
      }
      AppMethodBeat.o(110805);
      return;
    }
    StoryGalleryView.d(this.sTX).post((Runnable)new StoryGalleryView.g.b(this, paramInt1));
    AppMethodBeat.o(110805);
  }
  
  public final void cCn()
  {
    AppMethodBeat.i(110806);
    int i = StoryGalleryView.g(this.sTX).size();
    int j = StoryGalleryView.h(this.sTX);
    if (j < 0)
    {
      AppMethodBeat.o(110806);
      return;
    }
    if (i > j)
    {
      GalleryHorizontalControlView localGalleryHorizontalControlView = StoryGalleryView.A(this.sTX);
      if (localGalleryHorizontalControlView != null)
      {
        Object localObject = StoryGalleryView.g(this.sTX).get(StoryGalleryView.h(this.sTX));
        j.p(localObject, "galleryGroups[selectedRow]");
        localGalleryHorizontalControlView.dH((List)localObject);
        AppMethodBeat.o(110806);
        return;
      }
    }
    AppMethodBeat.o(110806);
  }
  
  public final void j(int paramInt, List<com.tencent.mm.plugin.story.model.d.g> paramList)
  {
    AppMethodBeat.i(110800);
    j.q(paramList, "items");
    Object localObject = StoryGalleryView.sTW;
    ab.b(StoryGalleryView.access$getTAG$cp(), "updateGroup, groupIndex:" + paramInt + ", items:" + paramList.size() + ", active:" + StoryGalleryView.k(this.sTX) + ", galleryType:" + this.sTX.getGalleryType(), new Object[0]);
    if (paramInt >= StoryGalleryView.g(this.sTX).size())
    {
      AppMethodBeat.o(110800);
      return;
    }
    ((ArrayList)StoryGalleryView.g(this.sTX).get(paramInt)).clear();
    ((ArrayList)StoryGalleryView.g(this.sTX).get(paramInt)).addAll((Collection)paramList);
    StoryGalleryView.x(this.sTX).dH((List)StoryGalleryView.g(this.sTX));
    if (StoryGalleryView.h(this.sTX) == paramInt)
    {
      localObject = StoryGalleryView.y(this.sTX);
      if (localObject != null) {
        ((com.tencent.mm.plugin.story.ui.a.g)localObject).dH(paramList);
      }
    }
    if ((StoryGalleryView.g(this.sTX).size() == 1) && (paramList.isEmpty()))
    {
      paramList = StoryGalleryView.p(this.sTX);
      if (paramList != null) {
        paramList.cbR();
      }
      StoryGalleryView.f(this.sTX).setVisibility(8);
      if (this.sTX.getGalleryType() == m.a.sqP)
      {
        StoryGalleryView.z(this.sTX).setVisibility(0);
        paramList = i.sFa;
        i.cDs().cC(1L);
        paramList = i.sFa;
        i.cDt();
      }
    }
    while ((paramInt == 0) && (!StoryGalleryView.k(this.sTX)) && (this.sTX.getGalleryType() != m.a.sqU) && (this.sTX.getGalleryType() != m.a.sqT))
    {
      this.sTX.Gh(0);
      AppMethodBeat.o(110800);
      return;
      StoryGalleryView.z(this.sTX).setVisibility(8);
      continue;
      this.sTX.post((Runnable)new StoryGalleryView.g.e(this));
      paramList = StoryGalleryView.p(this.sTX);
      if (paramList != null) {
        paramList.cbS();
      }
      StoryGalleryView.z(this.sTX).setVisibility(8);
      if (!StoryGalleryView.k(this.sTX))
      {
        StoryGalleryView.f(this.sTX).setAlpha(1.0F);
        StoryGalleryView.f(this.sTX).setVisibility(0);
      }
    }
    if (paramInt == 1)
    {
      this.sTX.getGalleryType();
      paramList = m.a.sqT;
    }
    AppMethodBeat.o(110800);
  }
  
  public final void lX(boolean paramBoolean)
  {
    AppMethodBeat.i(110798);
    Object localObject = StoryGalleryView.n(this.sTX);
    if (localObject != null) {
      ((p)localObject).dismiss();
    }
    if (!paramBoolean)
    {
      t.makeText(this.hEq, (CharSequence)this.hEq.getResources().getString(2131304134), 0).show();
      AppMethodBeat.o(110798);
      return;
    }
    localObject = com.tencent.mm.plugin.story.model.d.sut;
    com.tencent.mm.plugin.story.model.d.cAh();
    AppMethodBeat.o(110798);
  }
  
  public final void lY(boolean paramBoolean)
  {
    AppMethodBeat.i(110797);
    StoryGalleryView.q(this.sTX).mq(paramBoolean);
    AppMethodBeat.o(110797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.g
 * JD-Core Version:    0.7.0.1
 */