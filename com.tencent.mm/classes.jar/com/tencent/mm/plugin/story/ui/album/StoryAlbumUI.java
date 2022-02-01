package com.tencent.mm.plugin.story.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.d.a.f;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "()V", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mStoryAlbumAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "mStoryBubblePostFailLayout", "Landroid/widget/LinearLayout;", "mStoryBubblePostFailTv", "Landroid/widget/TextView;", "mStoryFavEntrancePanel", "Landroid/view/View;", "mStoryNoDataTv", "mStoryPostFailLayout", "mStoryPostFailTv", "mUsername", "", "dealContentView", "", "v", "enableFavorite", "", "getLayoutId", "", "goDateStoryGallery", "position", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "goFavAlbum", "initActionBar", "initViews", "loadFromDB", "loadFromRemote", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBubbleFail", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "onStoryPostFail", "list", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "supportNavigationSwipeBack", "Companion", "plugin-story_release"})
public final class StoryAlbumUI
  extends MMFragment
  implements a.f
{
  public static final a LTf;
  private static final String TAG = "MicroMsg.StoryAlbumUI";
  private LinearLayout LSX;
  private LinearLayout LSY;
  private TextView LSZ;
  private TextView LTa;
  private TextView LTb;
  private View LTc;
  private a LTd;
  private com.tencent.mm.plugin.story.d.a.e LTe;
  private RecyclerView mRecyclerView;
  private String pRV = "";
  
  static
  {
    AppMethodBeat.i(119842);
    LTf = new a((byte)0);
    TAG = "MicroMsg.StoryAlbumUI";
    AppMethodBeat.o(119842);
  }
  
  private final void loadFromDB()
  {
    AppMethodBeat.i(119835);
    com.tencent.mm.plugin.story.d.a.e locale = this.LTe;
    if (locale == null) {
      p.bGy("mPresenter");
    }
    locale.gbT();
    AppMethodBeat.o(119835);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(119837);
    p.k(paramView, "v");
    super.dealContentView(paramView);
    this.LTe = ((com.tencent.mm.plugin.story.d.a.e)new com.tencent.mm.plugin.story.g.a((a.f)this));
    Object localObject = getActivity();
    if (localObject != null)
    {
      localObject = ((FragmentActivity)localObject).getIntent();
      if (localObject != null)
      {
        String str = ((Intent)localObject).getStringExtra("username");
        localObject = str;
        if (str != null) {
          break label70;
        }
      }
    }
    localObject = "";
    label70:
    this.pRV = ((String)localObject);
    Log.i(TAG, "initViews username=" + this.pRV);
    localObject = paramView.findViewById(a.d.LzC);
    p.j(localObject, "v.findViewById(R.id.album_story_recycler)");
    this.mRecyclerView = ((RecyclerView)localObject);
    localObject = paramView.findViewById(a.d.LzD);
    p.j(localObject, "v.findViewById(R.id.album_story_send_fail_layout)");
    this.LSX = ((LinearLayout)localObject);
    localObject = paramView.findViewById(a.d.Lzp);
    p.j(localObject, "v.findViewById(R.id.album_bubble_send_fail_layout)");
    this.LSY = ((LinearLayout)localObject);
    localObject = paramView.findViewById(a.d.LzE);
    p.j(localObject, "v.findViewById(R.id.album_story_send_fail_tips)");
    this.LSZ = ((TextView)localObject);
    localObject = paramView.findViewById(a.d.Lzq);
    p.j(localObject, "v.findViewById(R.id.album_bubble_send_fail_tips)");
    this.LTa = ((TextView)localObject);
    localObject = paramView.findViewById(a.d.LzB);
    p.j(localObject, "v.findViewById(R.id.album_story_no_data_tip_tv)");
    this.LTb = ((TextView)localObject);
    paramView = paramView.findViewById(a.d.LzA);
    p.j(paramView, "v.findViewById(R.id.album_story_no_data_fav_panel)");
    this.LTc = paramView;
    this.LTd = new a();
    paramView = this.LTd;
    if (paramView == null) {
      p.bGy("mStoryAlbumAdapter");
    }
    paramView.LSI = ((kotlin.g.a.b)new c(this));
    paramView = this.LTd;
    if (paramView == null) {
      p.bGy("mStoryAlbumAdapter");
    }
    paramView.LSJ = ((kotlin.g.a.a)new d(this));
    paramView = this.mRecyclerView;
    if (paramView == null) {
      p.bGy("mRecyclerView");
    }
    localObject = this.LTd;
    if (localObject == null) {
      p.bGy("mStoryAlbumAdapter");
    }
    paramView.setAdapter((RecyclerView.a)localObject);
    paramView = this.mRecyclerView;
    if (paramView == null) {
      p.bGy("mRecyclerView");
    }
    getActivity();
    paramView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramView = this.mRecyclerView;
    if (paramView == null) {
      p.bGy("mRecyclerView");
    }
    paramView.a((RecyclerView.l)new e(this));
    paramView = this.LTc;
    if (paramView == null) {
      p.bGy("mStoryFavEntrancePanel");
    }
    paramView.setOnClickListener((View.OnClickListener)new f(this));
    paramView = this.LTe;
    if (paramView == null) {
      p.bGy("mPresenter");
    }
    paramView.onCreate(this.pRV);
    loadFromDB();
    paramView = this.LTe;
    if (paramView == null) {
      p.bGy("mPresenter");
    }
    paramView.gbR();
    AppMethodBeat.o(119837);
  }
  
  public final void gbU()
  {
    AppMethodBeat.i(119841);
    a locala = this.LTd;
    if (locala == null) {
      p.bGy("mStoryAlbumAdapter");
    }
    locala.tDb = true;
    if (!((Collection)locala.mItemList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        locala.notifyDataSetChanged();
      }
      AppMethodBeat.o(119841);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return com.tencent.mm.plugin.story.a.e.LCF;
  }
  
  public final void hQ(List<c> paramList)
  {
    AppMethodBeat.i(119840);
    p.k(paramList, "datas");
    Log.i(TAG, "onLoadFinish datas.size=" + paramList.size());
    a locala = this.LTd;
    if (locala == null) {
      p.bGy("mStoryAlbumAdapter");
    }
    locala.ig(paramList);
    if (paramList.isEmpty())
    {
      paramList = this.LTc;
      if (paramList == null) {
        p.bGy("mStoryFavEntrancePanel");
      }
      paramList.setVisibility(0);
      paramList = this.LTb;
      if (paramList == null) {
        p.bGy("mStoryNoDataTv");
      }
      paramList.setVisibility(0);
      paramList = this.mRecyclerView;
      if (paramList == null) {
        p.bGy("mRecyclerView");
      }
      paramList.setVisibility(8);
      if (!t.gkZ()) {
        break label240;
      }
    }
    label240:
    for (boolean bool = com.tencent.mm.plugin.story.c.a.a.LEY.gbN();; bool = com.tencent.mm.plugin.story.c.a.a.LEY.gbw())
    {
      if (!bool)
      {
        paramList = this.LTc;
        if (paramList == null) {
          p.bGy("mStoryFavEntrancePanel");
        }
        paramList.setVisibility(8);
      }
      AppMethodBeat.o(119840);
      return;
      paramList = this.LTc;
      if (paramList == null) {
        p.bGy("mStoryFavEntrancePanel");
      }
      paramList.setVisibility(8);
      paramList = this.LTb;
      if (paramList == null) {
        p.bGy("mStoryNoDataTv");
      }
      paramList.setVisibility(8);
      paramList = this.mRecyclerView;
      if (paramList == null) {
        p.bGy("mRecyclerView");
      }
      paramList.setVisibility(0);
      break;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(119838);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d(TAG, "onActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    if (paramInt1 == 1) {
      loadFromDB();
    }
    AppMethodBeat.o(119838);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119836);
    super.onCreate(paramBundle);
    setMMTitle(a.g.album_title);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    AppMethodBeat.o(119836);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119839);
    super.onDestroy();
    com.tencent.mm.plugin.story.d.a.e locale = this.LTe;
    if (locale == null) {
      p.bGy("mPresenter");
    }
    locale.fWn();
    AppMethodBeat.o(119839);
  }
  
  public final boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(StoryAlbumUI paramStoryAlbumUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119830);
      paramMenuItem = this.LTg.getActivity();
      if (paramMenuItem != null) {
        paramMenuItem.finish();
      }
      AppMethodBeat.o(119830);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "storyHistoryInfo", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<h, x>
  {
    c(StoryAlbumUI paramStoryAlbumUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(StoryAlbumUI paramStoryAlbumUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class e
    extends e
  {
    public final void onLoadMore()
    {
      AppMethodBeat.i(119833);
      StoryAlbumUI.c(this.LTg).gbQ();
      AppMethodBeat.o(119833);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(StoryAlbumUI paramStoryAlbumUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119834);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      StoryAlbumUI.b(this.LTg);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(119834);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryAlbumUI
 * JD-Core Version:    0.7.0.1
 */