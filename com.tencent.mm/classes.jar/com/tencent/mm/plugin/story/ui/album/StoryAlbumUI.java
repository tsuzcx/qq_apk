package com.tencent.mm.plugin.story.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.d.a.e;
import com.tencent.mm.plugin.story.d.a.f;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMFragment;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.Collection;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "()V", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mStoryAlbumAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "mStoryBubblePostFailLayout", "Landroid/widget/LinearLayout;", "mStoryBubblePostFailTv", "Landroid/widget/TextView;", "mStoryFavEntrancePanel", "Landroid/view/View;", "mStoryNoDataTv", "mStoryPostFailLayout", "mStoryPostFailTv", "mUsername", "", "dealContentView", "", "v", "getLayoutId", "", "goDateStoryGallery", "position", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "goFavAlbum", "initActionBar", "initViews", "loadFromDB", "loadFromRemote", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBubbleFail", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "onStoryPostFail", "list", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "supportNavigationSwipeBack", "", "Companion", "plugin-story_release"})
public final class StoryAlbumUI
  extends MMFragment
  implements a.f
{
  private static final String TAG = "MicroMsg.StoryAlbumUI";
  public static final StoryAlbumUI.a zFq;
  private RecyclerView alu;
  private String lhM = "";
  private LinearLayout zFi;
  private LinearLayout zFj;
  private TextView zFk;
  private TextView zFl;
  private TextView zFm;
  private View zFn;
  private a zFo;
  private a.e zFp;
  
  static
  {
    AppMethodBeat.i(119842);
    zFq = new StoryAlbumUI.a((byte)0);
    TAG = "MicroMsg.StoryAlbumUI";
    AppMethodBeat.o(119842);
  }
  
  private final void loadFromDB()
  {
    AppMethodBeat.i(119835);
    a.e locale = this.zFp;
    if (locale == null) {
      k.aVY("mPresenter");
    }
    locale.dVb();
    AppMethodBeat.o(119835);
  }
  
  public final void dVc()
  {
    AppMethodBeat.i(119841);
    a locala = this.zFo;
    if (locala == null) {
      k.aVY("mStoryAlbumAdapter");
    }
    locala.ojr = true;
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
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(119837);
    k.h(paramView, "v");
    super.dealContentView(paramView);
    this.zFp = ((a.e)new com.tencent.mm.plugin.story.g.a((a.f)this));
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
    this.lhM = ((String)localObject);
    ac.i(TAG, "initViews username=" + this.lhM);
    localObject = paramView.findViewById(2131296618);
    k.g(localObject, "v.findViewById(R.id.album_story_recycler)");
    this.alu = ((RecyclerView)localObject);
    localObject = paramView.findViewById(2131296621);
    k.g(localObject, "v.findViewById(R.id.album_story_send_fail_layout)");
    this.zFi = ((LinearLayout)localObject);
    localObject = paramView.findViewById(2131296540);
    k.g(localObject, "v.findViewById(R.id.album_bubble_send_fail_layout)");
    this.zFj = ((LinearLayout)localObject);
    localObject = paramView.findViewById(2131296622);
    k.g(localObject, "v.findViewById(R.id.album_story_send_fail_tips)");
    this.zFk = ((TextView)localObject);
    localObject = paramView.findViewById(2131296541);
    k.g(localObject, "v.findViewById(R.id.album_bubble_send_fail_tips)");
    this.zFl = ((TextView)localObject);
    localObject = paramView.findViewById(2131296617);
    k.g(localObject, "v.findViewById(R.id.album_story_no_data_tip_tv)");
    this.zFm = ((TextView)localObject);
    paramView = paramView.findViewById(2131296616);
    k.g(paramView, "v.findViewById(R.id.album_story_no_data_fav_panel)");
    this.zFn = paramView;
    this.zFo = new a();
    paramView = this.zFo;
    if (paramView == null) {
      k.aVY("mStoryAlbumAdapter");
    }
    paramView.zET = ((b)new c(this));
    paramView = this.zFo;
    if (paramView == null) {
      k.aVY("mStoryAlbumAdapter");
    }
    paramView.zEU = ((d.g.a.a)new d(this));
    paramView = this.alu;
    if (paramView == null) {
      k.aVY("mRecyclerView");
    }
    localObject = this.zFo;
    if (localObject == null) {
      k.aVY("mStoryAlbumAdapter");
    }
    paramView.setAdapter((RecyclerView.a)localObject);
    paramView = this.alu;
    if (paramView == null) {
      k.aVY("mRecyclerView");
    }
    getActivity();
    paramView.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramView = this.alu;
    if (paramView == null) {
      k.aVY("mRecyclerView");
    }
    paramView.a((RecyclerView.m)new e(this));
    paramView = this.zFn;
    if (paramView == null) {
      k.aVY("mStoryFavEntrancePanel");
    }
    paramView.setOnClickListener((View.OnClickListener)new f(this));
    paramView = this.zFp;
    if (paramView == null) {
      k.aVY("mPresenter");
    }
    paramView.onCreate(this.lhM);
    loadFromDB();
    paramView = this.zFp;
    if (paramView == null) {
      k.aVY("mPresenter");
    }
    paramView.dUZ();
    AppMethodBeat.o(119837);
  }
  
  public final void fQ(List<c> paramList)
  {
    AppMethodBeat.i(119840);
    k.h(paramList, "datas");
    ac.i(TAG, "onLoadFinish datas.size=" + paramList.size());
    a locala = this.zFo;
    if (locala == null) {
      k.aVY("mStoryAlbumAdapter");
    }
    locala.gh(paramList);
    if (paramList.isEmpty())
    {
      paramList = this.zFn;
      if (paramList == null) {
        k.aVY("mStoryFavEntrancePanel");
      }
      paramList.setVisibility(0);
      paramList = this.zFm;
      if (paramList == null) {
        k.aVY("mStoryNoDataTv");
      }
      paramList.setVisibility(0);
      paramList = this.alu;
      if (paramList == null) {
        k.aVY("mRecyclerView");
      }
      paramList.setVisibility(8);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.story.c.a.a.zqB.dUG())
      {
        paramList = this.zFn;
        if (paramList == null) {
          k.aVY("mStoryFavEntrancePanel");
        }
        paramList.setVisibility(8);
      }
      AppMethodBeat.o(119840);
      return;
      paramList = this.zFn;
      if (paramList == null) {
        k.aVY("mStoryFavEntrancePanel");
      }
      paramList.setVisibility(8);
      paramList = this.zFm;
      if (paramList == null) {
        k.aVY("mStoryNoDataTv");
      }
      paramList.setVisibility(8);
      paramList = this.alu;
      if (paramList == null) {
        k.aVY("mRecyclerView");
      }
      paramList.setVisibility(0);
    }
  }
  
  public final int getLayoutId()
  {
    return 2131495658;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(119838);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.d(TAG, "onActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    if (paramInt1 == 1) {
      loadFromDB();
    }
    AppMethodBeat.o(119838);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119836);
    super.onCreate(paramBundle);
    setMMTitle(2131755251);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    AppMethodBeat.o(119836);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119839);
    super.onDestroy();
    a.e locale = this.zFp;
    if (locale == null) {
      k.aVY("mPresenter");
    }
    locale.dPE();
    AppMethodBeat.o(119839);
  }
  
  public final boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(StoryAlbumUI paramStoryAlbumUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119830);
      paramMenuItem = this.zFr.getActivity();
      if (paramMenuItem != null) {
        paramMenuItem.finish();
      }
      AppMethodBeat.o(119830);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "storyHistoryInfo", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<h, y>
  {
    c(StoryAlbumUI paramStoryAlbumUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(StoryAlbumUI paramStoryAlbumUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class e
    extends e
  {
    public final void Xa()
    {
      AppMethodBeat.i(119833);
      StoryAlbumUI.c(this.zFr).dUY();
      AppMethodBeat.o(119833);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(StoryAlbumUI paramStoryAlbumUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(119834);
      StoryAlbumUI.b(this.zFr);
      AppMethodBeat.o(119834);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryAlbumUI
 * JD-Core Version:    0.7.0.1
 */