package com.tencent.mm.plugin.story.ui.album;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.m;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r.b;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "()V", "TAG", "", "checkedFromGalleyListener", "com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getLayoutId", "", "goDateStoryGallery", "vPosition", "hPosition", "username", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filters", "", "", "initActionBar", "initViews", "justDoIt", "loadDatas", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "", "onLoadFpFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "checkedDatas", "onLoadNpFinish", "updateOptionMenu", "plugin-story_release"})
public final class StoryFavSelectUI
  extends MMActivity
  implements a.d
{
  private final String TAG;
  private StoryFavoritePanel yrW;
  private com.tencent.mm.plugin.story.d.a.c ysa;
  private final a ysb;
  
  public StoryFavSelectUI()
  {
    AppMethodBeat.i(119875);
    this.TAG = "MicroMsg.StoryFavSelectUI";
    this.ysb = new a(this);
    AppMethodBeat.o(119875);
  }
  
  private final void cri()
  {
    AppMethodBeat.i(119874);
    Object localObject = this.yrW;
    if (localObject == null) {
      k.aPZ("favPanel");
    }
    int i = ((StoryFavoritePanel)localObject).getMCheckedDatas().size();
    localObject = new StringBuilder().append(getString(2131755779)).append('(').append(i).append('/');
    com.tencent.mm.plugin.story.i.a.c localc = com.tencent.mm.plugin.story.i.a.c.yov;
    updateOptionMenuText(0, com.tencent.mm.plugin.story.i.a.c.dKm() + ')');
    enableOptionMenu(0, true);
    AppMethodBeat.o(119874);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(119870);
    super.dealContentView(paramView);
    paramView = findViewById(2131296607);
    k.g(paramView, "findViewById(R.id.album_story_favorite_panel)");
    this.yrW = ((StoryFavoritePanel)paramView);
    paramView = this.yrW;
    if (paramView == null) {
      k.aPZ("favPanel");
    }
    StoryFavoritePanel.a locala = StoryFavoritePanel.yst;
    paramView.setup(StoryFavoritePanel.dKY());
    paramView = this.yrW;
    if (paramView == null) {
      k.aPZ("favPanel");
    }
    paramView = paramView.ysg;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    paramView = this.yrW;
    if (paramView == null) {
      k.aPZ("favPanel");
    }
    paramView.setMOnFavItemClickListener((m)new d(this));
    paramView = this.yrW;
    if (paramView == null) {
      k.aPZ("favPanel");
    }
    paramView.setMOnCheckItemListener((q)new e(this));
    paramView = this.yrW;
    if (paramView == null) {
      k.aPZ("favPanel");
    }
    paramView.a((RecyclerView.m)new f(this));
    paramView = this.ysa;
    if (paramView == null) {
      k.aPZ("mPresenter");
    }
    paramView.qF(true);
    paramView = this.ysa;
    if (paramView == null) {
      k.aPZ("mPresenter");
    }
    paramView.dGy();
    AppMethodBeat.o(119870);
  }
  
  public final void fT(List<com.tencent.mm.plugin.story.i.j> paramList)
  {
    AppMethodBeat.i(119872);
    k.h(paramList, "datas");
    new StringBuilder("onLoadNpFinish datas.size").append(paramList.size());
    h.fmz();
    StoryFavoritePanel localStoryFavoritePanel = this.yrW;
    if (localStoryFavoritePanel == null) {
      k.aPZ("favPanel");
    }
    localStoryFavoritePanel.B(paramList, (List)new ArrayList());
    AppMethodBeat.o(119872);
  }
  
  public final int getLayoutId()
  {
    return 2131495652;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119868);
    this.ysa = ((com.tencent.mm.plugin.story.d.a.c)new com.tencent.mm.plugin.story.g.l((a.d)this));
    com.tencent.mm.plugin.story.d.a.c localc = this.ysa;
    if (localc == null) {
      k.aPZ("mPresenter");
    }
    j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
    localc.onCreate(j.b.dta());
    super.onCreate(paramBundle);
    a.ESL.c((c)this.ysb);
    setMMTitle(2131764262);
    addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new StoryFavSelectUI.b(this), null, r.b.FOB);
    setBackBtn((MenuItem.OnMenuItemClickListener)new StoryFavSelectUI.c(this));
    AppMethodBeat.o(119868);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119869);
    super.onDestroy();
    com.tencent.mm.plugin.story.d.a.c localc = this.ysa;
    if (localc == null) {
      k.aPZ("mPresenter");
    }
    localc.dBh();
    a.ESL.d((c)this.ysb);
    AppMethodBeat.o(119869);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qE(boolean paramBoolean)
  {
    AppMethodBeat.i(119873);
    StoryFavoritePanel localStoryFavoritePanel = this.yrW;
    if (localStoryFavoritePanel == null) {
      k.aPZ("favPanel");
    }
    localStoryFavoritePanel.qE(paramBoolean);
    AppMethodBeat.o(119873);
  }
  
  public final void z(List<com.tencent.mm.plugin.story.i.j> paramList1, List<com.tencent.mm.plugin.story.i.j> paramList2)
  {
    AppMethodBeat.i(119871);
    k.h(paramList1, "datas");
    k.h(paramList2, "checkedDatas");
    new StringBuilder("onLoadFpFinish datas.size").append(paramList1.size());
    h.fmz();
    if (paramList1.isEmpty())
    {
      paramList1 = this.yrW;
      if (paramList1 == null) {
        k.aPZ("favPanel");
      }
      paramList2 = getContext();
      k.g(paramList2, "context");
      paramList2 = paramList2.getResources().getString(2131764202);
      k.g(paramList2, "context.resources.getStr…album_favorite_empty_tip)");
      paramList1.asb(paramList2);
    }
    for (;;)
    {
      cri();
      AppMethodBeat.o(119871);
      return;
      StoryFavoritePanel localStoryFavoritePanel = this.yrW;
      if (localStoryFavoritePanel == null) {
        k.aPZ("favPanel");
      }
      localStoryFavoritePanel.B(paramList1, paramList2);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StoryCheckedFavFromGalleryEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class a
    extends c<uu>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements m<StoryFavoritePanel.c, Integer, y>
  {
    d(StoryFavSelectUI paramStoryFavSelectUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "checked", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements q<StoryFavoritePanel.c, Integer, Boolean, y>
  {
    e(StoryFavSelectUI paramStoryFavSelectUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class f
    extends e
  {
    public final void Wc()
    {
      AppMethodBeat.i(119867);
      StoryFavSelectUI.d(this.ysc).dGx();
      AppMethodBeat.o(119867);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI
 * JD-Core Version:    0.7.0.1
 */