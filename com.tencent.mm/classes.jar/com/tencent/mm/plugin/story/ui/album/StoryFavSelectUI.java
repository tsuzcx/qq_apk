package com.tencent.mm.plugin.story.ui.album;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "()V", "TAG", "", "checkedFromGalleyListener", "com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getLayoutId", "", "goDateStoryGallery", "vPosition", "hPosition", "username", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filters", "", "", "initActionBar", "initViews", "justDoIt", "loadDatas", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "", "onLoadFpFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "checkedDatas", "onLoadNpFinish", "updateOptionMenu", "plugin-story_release"})
public final class StoryFavSelectUI
  extends MMActivity
  implements a.d
{
  private StoryFavoritePanel Fzg;
  private com.tencent.mm.plugin.story.d.a.c Fzk;
  private final a Fzl;
  private final String TAG;
  
  public StoryFavSelectUI()
  {
    AppMethodBeat.i(119875);
    this.TAG = "MicroMsg.StoryFavSelectUI";
    this.Fzl = new a(this);
    AppMethodBeat.o(119875);
  }
  
  private final void dzO()
  {
    AppMethodBeat.i(119874);
    Object localObject = this.Fzg;
    if (localObject == null) {
      p.btv("favPanel");
    }
    int i = ((StoryFavoritePanel)localObject).getMCheckedDatas().size();
    localObject = new StringBuilder().append(getString(2131755858)).append('(').append(i).append('/');
    com.tencent.mm.plugin.story.i.a.c localc = com.tencent.mm.plugin.story.i.a.c.FvH;
    updateOptionMenuText(0, com.tencent.mm.plugin.story.i.a.c.frl() + ')');
    enableOptionMenu(0, true);
    AppMethodBeat.o(119874);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(119870);
    super.dealContentView(paramView);
    paramView = findViewById(2131296684);
    p.g(paramView, "findViewById(R.id.album_story_favorite_panel)");
    this.Fzg = ((StoryFavoritePanel)paramView);
    paramView = this.Fzg;
    if (paramView == null) {
      p.btv("favPanel");
    }
    StoryFavoritePanel.a locala = StoryFavoritePanel.FzD;
    paramView.setup(StoryFavoritePanel.frW());
    paramView = this.Fzg;
    if (paramView == null) {
      p.btv("favPanel");
    }
    paramView = paramView.Fzq;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    paramView = this.Fzg;
    if (paramView == null) {
      p.btv("favPanel");
    }
    paramView.setMOnFavItemClickListener((m)new d(this));
    paramView = this.Fzg;
    if (paramView == null) {
      p.btv("favPanel");
    }
    paramView.setMOnCheckItemListener((kotlin.g.a.q)new e(this));
    paramView = this.Fzg;
    if (paramView == null) {
      p.btv("favPanel");
    }
    paramView.a((RecyclerView.l)new f(this));
    paramView = this.Fzk;
    if (paramView == null) {
      p.btv("mPresenter");
    }
    paramView.vL(true);
    paramView = this.Fzk;
    if (paramView == null) {
      p.btv("mPresenter");
    }
    paramView.fnx();
    AppMethodBeat.o(119870);
  }
  
  public final int getLayoutId()
  {
    return 2131496557;
  }
  
  public final void hr(List<com.tencent.mm.plugin.story.i.j> paramList)
  {
    AppMethodBeat.i(119872);
    p.h(paramList, "datas");
    new StringBuilder("onLoadNpFinish datas.size").append(paramList.size());
    h.hkS();
    StoryFavoritePanel localStoryFavoritePanel = this.Fzg;
    if (localStoryFavoritePanel == null) {
      p.btv("favPanel");
    }
    localStoryFavoritePanel.v(paramList, (List)new ArrayList());
    AppMethodBeat.o(119872);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119868);
    this.Fzk = ((com.tencent.mm.plugin.story.d.a.c)new com.tencent.mm.plugin.story.g.l((a.d)this));
    com.tencent.mm.plugin.story.d.a.c localc = this.Fzk;
    if (localc == null) {
      p.btv("mPresenter");
    }
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    localc.onCreate(j.b.fau());
    super.onCreate(paramBundle);
    EventCenter.instance.addListener((IListener)this.Fzl);
    setMMTitle(2131766520);
    addTextOptionMenu(0, getString(2131755858), (MenuItem.OnMenuItemClickListener)new b(this), null, t.b.OGU);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    AppMethodBeat.o(119868);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119869);
    super.onDestroy();
    com.tencent.mm.plugin.story.d.a.c localc = this.Fzk;
    if (localc == null) {
      p.btv("mPresenter");
    }
    localc.fib();
    EventCenter.instance.removeListener((IListener)this.Fzl);
    AppMethodBeat.o(119869);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void t(List<com.tencent.mm.plugin.story.i.j> paramList1, List<com.tencent.mm.plugin.story.i.j> paramList2)
  {
    AppMethodBeat.i(119871);
    p.h(paramList1, "datas");
    p.h(paramList2, "checkedDatas");
    new StringBuilder("onLoadFpFinish datas.size").append(paramList1.size());
    h.hkS();
    if (paramList1.isEmpty())
    {
      paramList1 = this.Fzg;
      if (paramList1 == null) {
        p.btv("favPanel");
      }
      paramList2 = getContext();
      p.g(paramList2, "context");
      paramList2 = paramList2.getResources().getString(2131766458);
      p.g(paramList2, "context.resources.getStr…album_favorite_empty_tip)");
      paramList1.aSC(paramList2);
    }
    for (;;)
    {
      dzO();
      AppMethodBeat.o(119871);
      return;
      StoryFavoritePanel localStoryFavoritePanel = this.Fzg;
      if (localStoryFavoritePanel == null) {
        p.btv("favPanel");
      }
      localStoryFavoritePanel.v(paramList1, paramList2);
    }
  }
  
  public final void vK(boolean paramBoolean)
  {
    AppMethodBeat.i(119873);
    StoryFavoritePanel localStoryFavoritePanel = this.Fzg;
    if (localStoryFavoritePanel == null) {
      p.btv("favPanel");
    }
    localStoryFavoritePanel.vK(paramBoolean);
    AppMethodBeat.o(119873);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StoryCheckedFavFromGalleryEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class a
    extends IListener<xb>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(StoryFavSelectUI paramStoryFavSelectUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119863);
      StoryFavSelectUI.a(this.Fzm);
      this.Fzm.finish();
      AppMethodBeat.o(119863);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(StoryFavSelectUI paramStoryFavSelectUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119864);
      this.Fzm.finish();
      AppMethodBeat.o(119864);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements m<StoryFavoritePanel.c, Integer, x>
  {
    d(StoryFavSelectUI paramStoryFavSelectUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "checked", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.q<StoryFavoritePanel.c, Integer, Boolean, x>
  {
    e(StoryFavSelectUI paramStoryFavSelectUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class f
    extends e
  {
    public final void onLoadMore()
    {
      AppMethodBeat.i(119867);
      StoryFavSelectUI.d(this.Fzm).fnw();
      AppMethodBeat.o(119867);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI
 * JD-Core Version:    0.7.0.1
 */