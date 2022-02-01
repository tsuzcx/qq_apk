package com.tencent.mm.plugin.story.ui.album;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.yi;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "()V", "TAG", "", "checkedFromGalleyListener", "com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getLayoutId", "", "goDateStoryGallery", "vPosition", "hPosition", "username", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filters", "", "", "initActionBar", "initViews", "justDoIt", "loadDatas", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "", "onLoadFpFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "checkedDatas", "onLoadNpFinish", "updateOptionMenu", "plugin-story_release"})
public final class StoryFavSelectUI
  extends MMActivity
  implements com.tencent.mm.plugin.story.d.a.d
{
  private StoryFavoritePanel LTi;
  private com.tencent.mm.plugin.story.d.a.c LTm;
  private final a LTn;
  private final String TAG;
  
  public StoryFavSelectUI()
  {
    AppMethodBeat.i(119875);
    this.TAG = "MicroMsg.StoryFavSelectUI";
    this.LTn = new a(this);
    AppMethodBeat.o(119875);
  }
  
  private final void eaE()
  {
    AppMethodBeat.i(119874);
    Object localObject = this.LTi;
    if (localObject == null) {
      p.bGy("favPanel");
    }
    int i = ((StoryFavoritePanel)localObject).getMCheckedDatas().size();
    localObject = new StringBuilder().append(getString(a.g.app_finish)).append('(').append(i).append('/');
    com.tencent.mm.plugin.story.i.a.c localc = com.tencent.mm.plugin.story.i.a.c.LPK;
    updateOptionMenuText(0, com.tencent.mm.plugin.story.i.a.c.gfH() + ')');
    enableOptionMenu(0, true);
    AppMethodBeat.o(119874);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(119870);
    super.dealContentView(paramView);
    paramView = findViewById(com.tencent.mm.plugin.story.a.d.Lzt);
    p.j(paramView, "findViewById(R.id.album_story_favorite_panel)");
    this.LTi = ((StoryFavoritePanel)paramView);
    paramView = this.LTi;
    if (paramView == null) {
      p.bGy("favPanel");
    }
    StoryFavoritePanel.a locala = StoryFavoritePanel.LTG;
    paramView.setup(StoryFavoritePanel.ggt());
    paramView = this.LTi;
    if (paramView == null) {
      p.bGy("favPanel");
    }
    paramView = paramView.LTs;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    paramView = this.LTi;
    if (paramView == null) {
      p.bGy("favPanel");
    }
    paramView.setMOnFavItemClickListener((m)new d(this));
    paramView = this.LTi;
    if (paramView == null) {
      p.bGy("favPanel");
    }
    paramView.setMOnCheckItemListener((kotlin.g.a.q)new e(this));
    paramView = this.LTi;
    if (paramView == null) {
      p.bGy("favPanel");
    }
    paramView.a((RecyclerView.l)new f(this));
    paramView = this.LTm;
    if (paramView == null) {
      p.bGy("mPresenter");
    }
    paramView.zp(true);
    paramView = this.LTm;
    if (paramView == null) {
      p.bGy("mPresenter");
    }
    paramView.gbR();
    AppMethodBeat.o(119870);
  }
  
  public final int getLayoutId()
  {
    return a.e.LCz;
  }
  
  public final void ia(List<com.tencent.mm.plugin.story.i.j> paramList)
  {
    AppMethodBeat.i(119872);
    p.k(paramList, "datas");
    new StringBuilder("onLoadNpFinish datas.size").append(paramList.size());
    h.ioq();
    StoryFavoritePanel localStoryFavoritePanel = this.LTi;
    if (localStoryFavoritePanel == null) {
      p.bGy("favPanel");
    }
    localStoryFavoritePanel.z(paramList, (List)new ArrayList());
    AppMethodBeat.o(119872);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119868);
    this.LTm = ((com.tencent.mm.plugin.story.d.a.c)new com.tencent.mm.plugin.story.g.l((com.tencent.mm.plugin.story.d.a.d)this));
    com.tencent.mm.plugin.story.d.a.c localc = this.LTm;
    if (localc == null) {
      p.bGy("mPresenter");
    }
    j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
    localc.onCreate(j.b.fOo());
    super.onCreate(paramBundle);
    EventCenter.instance.addListener((IListener)this.LTn);
    setMMTitle(a.g.LDV);
    addTextOptionMenu(0, getString(a.g.app_finish), (MenuItem.OnMenuItemClickListener)new b(this), null, w.b.Wao);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    AppMethodBeat.o(119868);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119869);
    super.onDestroy();
    com.tencent.mm.plugin.story.d.a.c localc = this.LTm;
    if (localc == null) {
      p.bGy("mPresenter");
    }
    localc.fWn();
    EventCenter.instance.removeListener((IListener)this.LTn);
    AppMethodBeat.o(119869);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void x(List<com.tencent.mm.plugin.story.i.j> paramList1, List<com.tencent.mm.plugin.story.i.j> paramList2)
  {
    AppMethodBeat.i(119871);
    p.k(paramList1, "datas");
    p.k(paramList2, "checkedDatas");
    new StringBuilder("onLoadFpFinish datas.size").append(paramList1.size());
    h.ioq();
    if (paramList1.isEmpty())
    {
      paramList1 = this.LTi;
      if (paramList1 == null) {
        p.bGy("favPanel");
      }
      paramList2 = getContext();
      p.j(paramList2, "context");
      paramList2 = paramList2.getResources().getString(a.g.LDy);
      p.j(paramList2, "context.resources.getStr…album_favorite_empty_tip)");
      paramList1.bdG(paramList2);
    }
    for (;;)
    {
      eaE();
      AppMethodBeat.o(119871);
      return;
      StoryFavoritePanel localStoryFavoritePanel = this.LTi;
      if (localStoryFavoritePanel == null) {
        p.bGy("favPanel");
      }
      localStoryFavoritePanel.z(paramList1, paramList2);
    }
  }
  
  public final void zo(boolean paramBoolean)
  {
    AppMethodBeat.i(119873);
    StoryFavoritePanel localStoryFavoritePanel = this.LTi;
    if (localStoryFavoritePanel == null) {
      p.bGy("favPanel");
    }
    localStoryFavoritePanel.zo(paramBoolean);
    AppMethodBeat.o(119873);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StoryCheckedFavFromGalleryEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class a
    extends IListener<yi>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(StoryFavSelectUI paramStoryFavSelectUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119863);
      StoryFavSelectUI.a(this.LTo);
      this.LTo.finish();
      AppMethodBeat.o(119863);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(StoryFavSelectUI paramStoryFavSelectUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119864);
      this.LTo.finish();
      AppMethodBeat.o(119864);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements m<StoryFavoritePanel.c, Integer, x>
  {
    d(StoryFavSelectUI paramStoryFavSelectUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "checked", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.q<StoryFavoritePanel.c, Integer, Boolean, x>
  {
    e(StoryFavSelectUI paramStoryFavSelectUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class f
    extends e
  {
    public final void onLoadMore()
    {
      AppMethodBeat.i(119867);
      StoryFavSelectUI.d(this.LTo).gbQ();
      AppMethodBeat.o(119867);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI
 * JD-Core Version:    0.7.0.1
 */