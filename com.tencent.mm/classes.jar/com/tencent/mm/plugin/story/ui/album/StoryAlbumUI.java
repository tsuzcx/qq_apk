package com.tencent.mm.plugin.story.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.d.a.e;
import com.tencent.mm.plugin.story.d.a.f;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "()V", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mStoryAlbumAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "mStoryBubblePostFailLayout", "Landroid/widget/LinearLayout;", "mStoryBubblePostFailTv", "Landroid/widget/TextView;", "mStoryFavEntrancePanel", "Landroid/view/View;", "mStoryNoDataTv", "mStoryPostFailLayout", "mStoryPostFailTv", "mUsername", "", "dealContentView", "", "v", "enableFavorite", "", "getLayoutId", "", "goDateStoryGallery", "position", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "goFavAlbum", "initActionBar", "initViews", "loadFromDB", "loadFromRemote", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBubbleFail", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "onStoryPostFail", "list", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "supportNavigationSwipeBack", "Companion", "plugin-story_release"})
public final class StoryAlbumUI
  extends MMFragment
  implements a.f
{
  public static final a Fzd;
  private static final String TAG = "MicroMsg.StoryAlbumUI";
  private LinearLayout FyV;
  private LinearLayout FyW;
  private TextView FyX;
  private TextView FyY;
  private TextView FyZ;
  private View Fza;
  private a Fzb;
  private a.e Fzc;
  private String mRa = "";
  private RecyclerView mRecyclerView;
  
  static
  {
    AppMethodBeat.i(119842);
    Fzd = new a((byte)0);
    TAG = "MicroMsg.StoryAlbumUI";
    AppMethodBeat.o(119842);
  }
  
  private final void loadFromDB()
  {
    AppMethodBeat.i(119835);
    a.e locale = this.Fzc;
    if (locale == null) {
      kotlin.g.b.p.btv("mPresenter");
    }
    locale.fnz();
    AppMethodBeat.o(119835);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(119837);
    kotlin.g.b.p.h(paramView, "v");
    super.dealContentView(paramView);
    this.Fzc = ((a.e)new com.tencent.mm.plugin.story.g.a((a.f)this));
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
    this.mRa = ((String)localObject);
    Log.i(TAG, "initViews username=" + this.mRa);
    localObject = paramView.findViewById(2131296695);
    kotlin.g.b.p.g(localObject, "v.findViewById(R.id.album_story_recycler)");
    this.mRecyclerView = ((RecyclerView)localObject);
    localObject = paramView.findViewById(2131296698);
    kotlin.g.b.p.g(localObject, "v.findViewById(R.id.album_story_send_fail_layout)");
    this.FyV = ((LinearLayout)localObject);
    localObject = paramView.findViewById(2131296616);
    kotlin.g.b.p.g(localObject, "v.findViewById(R.id.album_bubble_send_fail_layout)");
    this.FyW = ((LinearLayout)localObject);
    localObject = paramView.findViewById(2131296699);
    kotlin.g.b.p.g(localObject, "v.findViewById(R.id.album_story_send_fail_tips)");
    this.FyX = ((TextView)localObject);
    localObject = paramView.findViewById(2131296617);
    kotlin.g.b.p.g(localObject, "v.findViewById(R.id.album_bubble_send_fail_tips)");
    this.FyY = ((TextView)localObject);
    localObject = paramView.findViewById(2131296694);
    kotlin.g.b.p.g(localObject, "v.findViewById(R.id.album_story_no_data_tip_tv)");
    this.FyZ = ((TextView)localObject);
    paramView = paramView.findViewById(2131296693);
    kotlin.g.b.p.g(paramView, "v.findViewById(R.id.album_story_no_data_fav_panel)");
    this.Fza = paramView;
    this.Fzb = new a();
    paramView = this.Fzb;
    if (paramView == null) {
      kotlin.g.b.p.btv("mStoryAlbumAdapter");
    }
    paramView.FyG = ((b)new c(this));
    paramView = this.Fzb;
    if (paramView == null) {
      kotlin.g.b.p.btv("mStoryAlbumAdapter");
    }
    paramView.FyH = ((kotlin.g.a.a)new StoryAlbumUI.d(this));
    paramView = this.mRecyclerView;
    if (paramView == null) {
      kotlin.g.b.p.btv("mRecyclerView");
    }
    localObject = this.Fzb;
    if (localObject == null) {
      kotlin.g.b.p.btv("mStoryAlbumAdapter");
    }
    paramView.setAdapter((RecyclerView.a)localObject);
    paramView = this.mRecyclerView;
    if (paramView == null) {
      kotlin.g.b.p.btv("mRecyclerView");
    }
    getActivity();
    paramView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramView = this.mRecyclerView;
    if (paramView == null) {
      kotlin.g.b.p.btv("mRecyclerView");
    }
    paramView.a((RecyclerView.l)new e(this));
    paramView = this.Fza;
    if (paramView == null) {
      kotlin.g.b.p.btv("mStoryFavEntrancePanel");
    }
    paramView.setOnClickListener((View.OnClickListener)new StoryAlbumUI.f(this));
    paramView = this.Fzc;
    if (paramView == null) {
      kotlin.g.b.p.btv("mPresenter");
    }
    paramView.onCreate(this.mRa);
    loadFromDB();
    paramView = this.Fzc;
    if (paramView == null) {
      kotlin.g.b.p.btv("mPresenter");
    }
    paramView.fnx();
    AppMethodBeat.o(119837);
  }
  
  public final void fnA()
  {
    AppMethodBeat.i(119841);
    a locala = this.Fzb;
    if (locala == null) {
      kotlin.g.b.p.btv("mStoryAlbumAdapter");
    }
    locala.qhf = true;
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
    return 2131496563;
  }
  
  public final void hh(List<c> paramList)
  {
    AppMethodBeat.i(119840);
    kotlin.g.b.p.h(paramList, "datas");
    Log.i(TAG, "onLoadFinish datas.size=" + paramList.size());
    a locala = this.Fzb;
    if (locala == null) {
      kotlin.g.b.p.btv("mStoryAlbumAdapter");
    }
    locala.hy(paramList);
    if (paramList.isEmpty())
    {
      paramList = this.Fza;
      if (paramList == null) {
        kotlin.g.b.p.btv("mStoryFavEntrancePanel");
      }
      paramList.setVisibility(0);
      paramList = this.FyZ;
      if (paramList == null) {
        kotlin.g.b.p.btv("mStoryNoDataTv");
      }
      paramList.setVisibility(0);
      paramList = this.mRecyclerView;
      if (paramList == null) {
        kotlin.g.b.p.btv("mRecyclerView");
      }
      paramList.setVisibility(8);
      if (!com.tencent.mm.plugin.textstatus.a.p.fvC()) {
        break label240;
      }
    }
    label240:
    for (boolean bool = com.tencent.mm.plugin.story.c.a.a.FkW.gIi();; bool = com.tencent.mm.plugin.story.c.a.a.FkW.fnd())
    {
      if (!bool)
      {
        paramList = this.Fza;
        if (paramList == null) {
          kotlin.g.b.p.btv("mStoryFavEntrancePanel");
        }
        paramList.setVisibility(8);
      }
      AppMethodBeat.o(119840);
      return;
      paramList = this.Fza;
      if (paramList == null) {
        kotlin.g.b.p.btv("mStoryFavEntrancePanel");
      }
      paramList.setVisibility(8);
      paramList = this.FyZ;
      if (paramList == null) {
        kotlin.g.b.p.btv("mStoryNoDataTv");
      }
      paramList.setVisibility(8);
      paramList = this.mRecyclerView;
      if (paramList == null) {
        kotlin.g.b.p.btv("mRecyclerView");
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
    setMMTitle(2131755286);
    setBackBtn((MenuItem.OnMenuItemClickListener)new StoryAlbumUI.b(this));
    AppMethodBeat.o(119836);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119839);
    super.onDestroy();
    a.e locale = this.Fzc;
    if (locale == null) {
      kotlin.g.b.p.btv("mPresenter");
    }
    locale.fib();
    AppMethodBeat.o(119839);
  }
  
  public final boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "storyHistoryInfo", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "invoke"})
  static final class c
    extends q
    implements b<h, x>
  {
    c(StoryAlbumUI paramStoryAlbumUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class e
    extends e
  {
    public final void onLoadMore()
    {
      AppMethodBeat.i(119833);
      StoryAlbumUI.c(this.Fze).fnw();
      AppMethodBeat.o(119833);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryAlbumUI
 * JD-Core Version:    0.7.0.1
 */