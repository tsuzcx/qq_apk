package com.tencent.mm.plugin.story.ui.album;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.aab;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.f.l;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.story.h.j;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "()V", "TAG", "", "checkedFromGalleyListener", "com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$checkedFromGalleyListener$1;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getLayoutId", "", "goDateStoryGallery", "vPosition", "hPosition", "username", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filters", "", "", "initActionBar", "initViews", "justDoIt", "loadDatas", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "", "onLoadFpFinish", "datas", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "checkedDatas", "onLoadNpFinish", "updateOptionMenu", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryFavSelectUI
  extends MMActivity
  implements com.tencent.mm.plugin.story.d.a.d
{
  private final checkedFromGalleyListener.1 SvA;
  private StoryFavoritePanel Svw;
  private com.tencent.mm.plugin.story.d.a.c Svz;
  private final String TAG;
  
  public StoryFavSelectUI()
  {
    AppMethodBeat.i(119875);
    this.TAG = "MicroMsg.StoryFavSelectUI";
    this.SvA = new IListener(f.hfK) {};
    AppMethodBeat.o(119875);
  }
  
  private static final boolean a(StoryFavSelectUI paramStoryFavSelectUI, MenuItem paramMenuItem)
  {
    Object localObject1 = null;
    AppMethodBeat.i(367314);
    s.u(paramStoryFavSelectUI, "this$0");
    Object localObject2 = paramStoryFavSelectUI.Svz;
    paramMenuItem = (MenuItem)localObject2;
    if (localObject2 == null)
    {
      s.bIx("mPresenter");
      paramMenuItem = null;
    }
    localObject2 = paramStoryFavSelectUI.Svw;
    if (localObject2 == null) {
      s.bIx("favPanel");
    }
    for (;;)
    {
      paramMenuItem.le((List)localObject1.getMCheckedDatas());
      paramStoryFavSelectUI.finish();
      AppMethodBeat.o(367314);
      return true;
      localObject1 = localObject2;
    }
  }
  
  private static final boolean b(StoryFavSelectUI paramStoryFavSelectUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(367316);
    s.u(paramStoryFavSelectUI, "this$0");
    paramStoryFavSelectUI.finish();
    AppMethodBeat.o(367316);
    return true;
  }
  
  private final void fbu()
  {
    AppMethodBeat.i(119874);
    Object localObject2 = this.Svw;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("favPanel");
      localObject1 = null;
    }
    int i = ((StoryFavoritePanel)localObject1).getMCheckedDatas().size();
    localObject1 = new StringBuilder().append(getString(a.g.app_finish)).append('(').append(i).append('/');
    localObject2 = com.tencent.mm.plugin.story.h.a.c.Ssv;
    updateOptionMenuText(0, com.tencent.mm.plugin.story.h.a.c.hyZ() + ')');
    enableOptionMenu(0, true);
    AppMethodBeat.o(119874);
  }
  
  public final void EF(boolean paramBoolean)
  {
    AppMethodBeat.i(119873);
    StoryFavoritePanel localStoryFavoritePanel2 = this.Svw;
    StoryFavoritePanel localStoryFavoritePanel1 = localStoryFavoritePanel2;
    if (localStoryFavoritePanel2 == null)
    {
      s.bIx("favPanel");
      localStoryFavoritePanel1 = null;
    }
    localStoryFavoritePanel1.EF(paramBoolean);
    AppMethodBeat.o(119873);
  }
  
  public final void L(List<j> paramList1, List<j> paramList2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(119871);
    s.u(paramList1, "datas");
    s.u(paramList2, "checkedDatas");
    s.X("onLoadFpFinish datas.size", Integer.valueOf(paramList1.size()));
    h.jXD();
    if (paramList1.isEmpty())
    {
      paramList1 = this.Svw;
      if (paramList1 == null)
      {
        s.bIx("favPanel");
        paramList1 = (List<j>)localObject1;
      }
      for (;;)
      {
        paramList2 = getContext().getResources().getString(a.g.Shj);
        s.s(paramList2, "context.resources.getStr…album_favorite_empty_tip)");
        paramList1.bcs(paramList2);
        fbu();
        AppMethodBeat.o(119871);
        return;
      }
    }
    localObject1 = this.Svw;
    if (localObject1 == null)
    {
      s.bIx("favPanel");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((StoryFavoritePanel)localObject1).N(paramList1, paramList2);
      break;
    }
  }
  
  public final void dealContentView(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(119870);
    super.dealContentView(paramView);
    paramView = findViewById(com.tencent.mm.plugin.story.a.d.Sdg);
    s.s(paramView, "findViewById(R.id.album_story_favorite_panel)");
    this.Svw = ((StoryFavoritePanel)paramView);
    Object localObject2 = this.Svw;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("favPanel");
      paramView = null;
    }
    localObject2 = StoryFavoritePanel.SvC;
    paramView.setup(StoryFavoritePanel.hzL());
    localObject2 = this.Svw;
    paramView = (View)localObject2;
    if (localObject2 == null)
    {
      s.bIx("favPanel");
      paramView = null;
    }
    paramView = paramView.SvG;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    paramView = this.Svw;
    if (paramView == null)
    {
      s.bIx("favPanel");
      paramView = null;
      paramView.setMOnFavItemClickListener((m)new a(this));
      paramView = this.Svw;
      if (paramView != null) {
        break label250;
      }
      s.bIx("favPanel");
      paramView = null;
      label145:
      paramView.setMOnCheckItemListener((kotlin.g.a.q)new StoryFavSelectUI.b(this));
      paramView = this.Svw;
      if (paramView != null) {
        break label253;
      }
      s.bIx("favPanel");
      paramView = null;
      label176:
      paramView.a((RecyclerView.l)new c(this));
      localObject2 = this.Svz;
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        s.bIx("mPresenter");
        paramView = null;
      }
      paramView.EG(true);
      paramView = this.Svz;
      if (paramView != null) {
        break label256;
      }
      s.bIx("mPresenter");
      paramView = localObject1;
    }
    label256:
    for (;;)
    {
      paramView.hvi();
      AppMethodBeat.o(119870);
      return;
      break;
      label250:
      break label145;
      label253:
      break label176;
    }
  }
  
  public final int getLayoutId()
  {
    return a.e.Sgk;
  }
  
  public final void lf(List<j> paramList)
  {
    AppMethodBeat.i(119872);
    s.u(paramList, "datas");
    s.X("onLoadNpFinish datas.size", Integer.valueOf(paramList.size()));
    h.jXD();
    StoryFavoritePanel localStoryFavoritePanel = this.Svw;
    if (localStoryFavoritePanel == null)
    {
      s.bIx("favPanel");
      localStoryFavoritePanel = null;
    }
    for (;;)
    {
      localStoryFavoritePanel.N(paramList, (List)new ArrayList());
      AppMethodBeat.o(119872);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119868);
    this.Svz = ((com.tencent.mm.plugin.story.d.a.c)new l((com.tencent.mm.plugin.story.d.a.d)this));
    Object localObject2 = this.Svz;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mPresenter");
      localObject1 = null;
    }
    localObject2 = StoryCore.SjP;
    localObject1.onCreate(StoryCore.b.hgg());
    super.onCreate(paramBundle);
    this.SvA.alive();
    setMMTitle(a.g.ShG);
    addTextOptionMenu(0, getString(a.g.app_finish), new StoryFavSelectUI..ExternalSyntheticLambda1(this), null, y.b.adEJ);
    setBackBtn(new StoryFavSelectUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(119868);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119869);
    super.onDestroy();
    com.tencent.mm.plugin.story.d.a.c localc2 = this.Svz;
    com.tencent.mm.plugin.story.d.a.c localc1 = localc2;
    if (localc2 == null)
    {
      s.bIx("mPresenter");
      localc1 = null;
    }
    localc1.hoB();
    this.SvA.dead();
    AppMethodBeat.o(119869);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<StoryFavoritePanel.c, Integer, ah>
  {
    a(StoryFavSelectUI paramStoryFavSelectUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/album/StoryFavSelectUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends e
  {
    c(StoryFavSelectUI paramStoryFavSelectUI) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(119867);
      com.tencent.mm.plugin.story.d.a.c localc2 = StoryFavSelectUI.c(this.SvB);
      com.tencent.mm.plugin.story.d.a.c localc1 = localc2;
      if (localc2 == null)
      {
        s.bIx("mPresenter");
        localc1 = null;
      }
      localc1.hvh();
      AppMethodBeat.o(119867);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavSelectUI
 * JD-Core Version:    0.7.0.1
 */