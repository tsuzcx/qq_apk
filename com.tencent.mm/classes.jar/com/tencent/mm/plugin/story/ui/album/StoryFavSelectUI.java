package com.tencent.mm.plugin.story.ui.album;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import d.g.a.m;
import d.g.b.p;
import d.z;
import java.util.ArrayList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "()V", "TAG", "", "checkedFromGalleyListener", "com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getLayoutId", "", "goDateStoryGallery", "vPosition", "hPosition", "username", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filters", "", "", "initActionBar", "initViews", "justDoIt", "loadDatas", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "", "onLoadFpFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "checkedDatas", "onLoadNpFinish", "updateOptionMenu", "plugin-story_release"})
public final class StoryFavSelectUI
  extends MMActivity
  implements a.d
{
  private StoryFavoritePanel AWS;
  private com.tencent.mm.plugin.story.d.a.c AWW;
  private final a AWX;
  private final String TAG;
  
  public StoryFavSelectUI()
  {
    AppMethodBeat.i(119875);
    this.TAG = "MicroMsg.StoryFavSelectUI";
    this.AWX = new a(this);
    AppMethodBeat.o(119875);
  }
  
  private final void cJW()
  {
    AppMethodBeat.i(119874);
    Object localObject = this.AWS;
    if (localObject == null) {
      p.bcb("favPanel");
    }
    int i = ((StoryFavoritePanel)localObject).getMCheckedDatas().size();
    localObject = new StringBuilder().append(getString(2131755779)).append('(').append(i).append('/');
    com.tencent.mm.plugin.story.i.a.c localc = com.tencent.mm.plugin.story.i.a.c.ATt;
    updateOptionMenuText(0, com.tencent.mm.plugin.story.i.a.c.elc() + ')');
    enableOptionMenu(0, true);
    AppMethodBeat.o(119874);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(119870);
    super.dealContentView(paramView);
    paramView = findViewById(2131296607);
    p.g(paramView, "findViewById(R.id.album_story_favorite_panel)");
    this.AWS = ((StoryFavoritePanel)paramView);
    paramView = this.AWS;
    if (paramView == null) {
      p.bcb("favPanel");
    }
    StoryFavoritePanel.a locala = StoryFavoritePanel.AXp;
    paramView.setup(StoryFavoritePanel.elN());
    paramView = this.AWS;
    if (paramView == null) {
      p.bcb("favPanel");
    }
    paramView = paramView.AXc;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    paramView = this.AWS;
    if (paramView == null) {
      p.bcb("favPanel");
    }
    paramView.setMOnFavItemClickListener((m)new d(this));
    paramView = this.AWS;
    if (paramView == null) {
      p.bcb("favPanel");
    }
    paramView.setMOnCheckItemListener((d.g.a.q)new e(this));
    paramView = this.AWS;
    if (paramView == null) {
      p.bcb("favPanel");
    }
    paramView.a((RecyclerView.m)new f(this));
    paramView = this.AWW;
    if (paramView == null) {
      p.bcb("mPresenter");
    }
    paramView.sj(true);
    paramView = this.AWW;
    if (paramView == null) {
      p.bcb("mPresenter");
    }
    paramView.eho();
    AppMethodBeat.o(119870);
  }
  
  public final int getLayoutId()
  {
    return 2131495652;
  }
  
  public final void gm(List<com.tencent.mm.plugin.story.i.j> paramList)
  {
    AppMethodBeat.i(119872);
    p.h(paramList, "datas");
    new StringBuilder("onLoadNpFinish datas.size").append(paramList.size());
    h.fUh();
    StoryFavoritePanel localStoryFavoritePanel = this.AWS;
    if (localStoryFavoritePanel == null) {
      p.bcb("favPanel");
    }
    localStoryFavoritePanel.B(paramList, (List)new ArrayList());
    AppMethodBeat.o(119872);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119868);
    this.AWW = ((com.tencent.mm.plugin.story.d.a.c)new com.tencent.mm.plugin.story.g.l((a.d)this));
    com.tencent.mm.plugin.story.d.a.c localc = this.AWW;
    if (localc == null) {
      p.bcb("mPresenter");
    }
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    localc.onCreate(j.b.dTJ());
    super.onCreate(paramBundle);
    a.IbL.c((c)this.AWX);
    setMMTitle(2131764262);
    addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new b(this), null, s.b.JbS);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    AppMethodBeat.o(119868);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119869);
    super.onDestroy();
    com.tencent.mm.plugin.story.d.a.c localc = this.AWW;
    if (localc == null) {
      p.bcb("mPresenter");
    }
    localc.ebV();
    a.IbL.d((c)this.AWX);
    AppMethodBeat.o(119869);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void si(boolean paramBoolean)
  {
    AppMethodBeat.i(119873);
    StoryFavoritePanel localStoryFavoritePanel = this.AWS;
    if (localStoryFavoritePanel == null) {
      p.bcb("favPanel");
    }
    localStoryFavoritePanel.si(paramBoolean);
    AppMethodBeat.o(119873);
  }
  
  public final void z(List<com.tencent.mm.plugin.story.i.j> paramList1, List<com.tencent.mm.plugin.story.i.j> paramList2)
  {
    AppMethodBeat.i(119871);
    p.h(paramList1, "datas");
    p.h(paramList2, "checkedDatas");
    new StringBuilder("onLoadFpFinish datas.size").append(paramList1.size());
    h.fUh();
    if (paramList1.isEmpty())
    {
      paramList1 = this.AWS;
      if (paramList1 == null) {
        p.bcb("favPanel");
      }
      paramList2 = getContext();
      p.g(paramList2, "context");
      paramList2 = paramList2.getResources().getString(2131764202);
      p.g(paramList2, "context.resources.getStr…album_favorite_empty_tip)");
      paramList1.aCo(paramList2);
    }
    for (;;)
    {
      cJW();
      AppMethodBeat.o(119871);
      return;
      StoryFavoritePanel localStoryFavoritePanel = this.AWS;
      if (localStoryFavoritePanel == null) {
        p.bcb("favPanel");
      }
      localStoryFavoritePanel.B(paramList1, paramList2);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StoryCheckedFavFromGalleryEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class a
    extends c<vx>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(StoryFavSelectUI paramStoryFavSelectUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119863);
      StoryFavSelectUI.a(this.AWY);
      this.AWY.finish();
      AppMethodBeat.o(119863);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(StoryFavSelectUI paramStoryFavSelectUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119864);
      this.AWY.finish();
      AppMethodBeat.o(119864);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements m<StoryFavoritePanel.c, Integer, z>
  {
    d(StoryFavSelectUI paramStoryFavSelectUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "checked", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.q<StoryFavoritePanel.c, Integer, Boolean, z>
  {
    e(StoryFavSelectUI paramStoryFavSelectUI)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class f
    extends e
  {
    public final void Zt()
    {
      AppMethodBeat.i(119867);
      StoryFavSelectUI.d(this.AWY).ehn();
      AppMethodBeat.o(119867);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI
 * JD-Core Version:    0.7.0.1
 */