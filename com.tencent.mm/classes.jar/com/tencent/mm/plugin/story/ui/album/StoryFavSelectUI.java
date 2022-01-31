package com.tencent.mm.plugin.story.ui.album;

import a.f.a.q;
import a.l;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.m;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "()V", "TAG", "", "checkedFromGalleyListener", "com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getLayoutId", "", "goDateStoryGallery", "vPosition", "hPosition", "username", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filters", "", "", "initActionBar", "initViews", "justDoIt", "loadDatas", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "", "onLoadFpFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "checkedDatas", "onLoadNpFinish", "updateOptionMenu", "plugin-story_release"})
public final class StoryFavSelectUI
  extends MMActivity
  implements a.d
{
  private final String TAG;
  private StoryFavoritePanel sJu;
  private com.tencent.mm.plugin.story.d.a.c sJy;
  private final StoryFavSelectUI.a sJz;
  
  public StoryFavSelectUI()
  {
    AppMethodBeat.i(110196);
    this.TAG = "MicroMsg.StoryFavSelectUI";
    this.sJz = new StoryFavSelectUI.a(this);
    AppMethodBeat.o(110196);
  }
  
  private final void cFq()
  {
    AppMethodBeat.i(151138);
    Object localObject = this.sJu;
    if (localObject == null) {
      a.f.b.j.ays("favPanel");
    }
    int i = ((StoryFavoritePanel)localObject).getMCheckedDatas().size();
    localObject = new StringBuilder().append(getString(2131296964)).append('(').append(i).append('/');
    com.tencent.mm.plugin.story.h.a.c localc = com.tencent.mm.plugin.story.h.a.c.sFZ;
    updateOptionMenuText(0, com.tencent.mm.plugin.story.h.a.c.cEx() + ')');
    enableOptionMenu(0, true);
    AppMethodBeat.o(151138);
  }
  
  public final void dC(List<com.tencent.mm.plugin.story.h.j> paramList)
  {
    AppMethodBeat.i(151136);
    a.f.b.j.q(paramList, "datas");
    new StringBuilder("onLoadNpFinish datas.size").append(paramList.size());
    h.dUV();
    StoryFavoritePanel localStoryFavoritePanel = this.sJu;
    if (localStoryFavoritePanel == null) {
      a.f.b.j.ays("favPanel");
    }
    localStoryFavoritePanel.p(paramList, (List)new ArrayList());
    AppMethodBeat.o(151136);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(110193);
    super.dealContentView(paramView);
    paramView = findViewById(2131828231);
    a.f.b.j.p(paramView, "findViewById(R.id.album_story_favorite_panel)");
    this.sJu = ((StoryFavoritePanel)paramView);
    paramView = this.sJu;
    if (paramView == null) {
      a.f.b.j.ays("favPanel");
    }
    StoryFavoritePanel.a locala = StoryFavoritePanel.sJS;
    paramView.setup(StoryFavoritePanel.cFs());
    paramView = this.sJu;
    if (paramView == null) {
      a.f.b.j.ays("favPanel");
    }
    paramView = paramView.sJE;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    paramView = this.sJu;
    if (paramView == null) {
      a.f.b.j.ays("favPanel");
    }
    paramView.setMOnFavItemClickListener((a.f.a.m)new StoryFavSelectUI.d(this));
    paramView = this.sJu;
    if (paramView == null) {
      a.f.b.j.ays("favPanel");
    }
    paramView.setMOnCheckItemListener((q)new StoryFavSelectUI.e(this));
    paramView = this.sJu;
    if (paramView == null) {
      a.f.b.j.ays("favPanel");
    }
    paramView.a((RecyclerView.m)new StoryFavSelectUI.f(this));
    paramView = this.sJy;
    if (paramView == null) {
      a.f.b.j.ays("mPresenter");
    }
    paramView.lP(true);
    paramView = this.sJy;
    if (paramView == null) {
      a.f.b.j.ays("mPresenter");
    }
    paramView.czI();
    AppMethodBeat.o(110193);
  }
  
  public final int getLayoutId()
  {
    return 2130970917;
  }
  
  public final void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(151137);
    StoryFavoritePanel localStoryFavoritePanel = this.sJu;
    if (localStoryFavoritePanel == null) {
      a.f.b.j.ays("favPanel");
    }
    localStoryFavoritePanel.lu(paramBoolean);
    AppMethodBeat.o(151137);
  }
  
  public final void n(List<com.tencent.mm.plugin.story.h.j> paramList1, List<com.tencent.mm.plugin.story.h.j> paramList2)
  {
    AppMethodBeat.i(151135);
    a.f.b.j.q(paramList1, "datas");
    a.f.b.j.q(paramList2, "checkedDatas");
    new StringBuilder("onLoadFpFinish datas.size").append(paramList1.size());
    h.dUV();
    if (paramList1.isEmpty())
    {
      paramList1 = this.sJu;
      if (paramList1 == null) {
        a.f.b.j.ays("favPanel");
      }
      paramList2 = getContext();
      a.f.b.j.p(paramList2, "context");
      paramList2 = paramList2.getResources().getString(2131304108);
      a.f.b.j.p(paramList2, "context.resources.getStr…album_favorite_empty_tip)");
      paramList1.adI(paramList2);
    }
    for (;;)
    {
      cFq();
      AppMethodBeat.o(151135);
      return;
      StoryFavoritePanel localStoryFavoritePanel = this.sJu;
      if (localStoryFavoritePanel == null) {
        a.f.b.j.ays("favPanel");
      }
      localStoryFavoritePanel.p(paramList1, paramList2);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110191);
    this.sJy = ((com.tencent.mm.plugin.story.d.a.c)new com.tencent.mm.plugin.story.f.m((a.d)this));
    com.tencent.mm.plugin.story.d.a.c localc = this.sJy;
    if (localc == null) {
      a.f.b.j.ays("mPresenter");
    }
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    localc.onCreate(j.b.coK());
    super.onCreate(paramBundle);
    a.ymk.c((c)this.sJz);
    setMMTitle(2131304160);
    addTextOptionMenu(0, getString(2131296964), (MenuItem.OnMenuItemClickListener)new StoryFavSelectUI.b(this), null, q.b.zby);
    setBackBtn((MenuItem.OnMenuItemClickListener)new StoryFavSelectUI.c(this));
    AppMethodBeat.o(110191);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(110192);
    super.onDestroy();
    com.tencent.mm.plugin.story.d.a.c localc = this.sJy;
    if (localc == null) {
      a.f.b.j.ays("mPresenter");
    }
    localc.bOo();
    a.ymk.d((c)this.sJz);
    AppMethodBeat.o(110192);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI
 * JD-Core Version:    0.7.0.1
 */