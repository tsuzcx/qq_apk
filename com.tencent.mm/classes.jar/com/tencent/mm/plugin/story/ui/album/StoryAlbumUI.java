package com.tencent.mm.plugin.story.ui.album;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.d.a.e;
import com.tencent.mm.plugin.story.d.a.f;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragment;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "()V", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mStoryAlbumAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "mStoryBubblePostFailLayout", "Landroid/widget/LinearLayout;", "mStoryBubblePostFailTv", "Landroid/widget/TextView;", "mStoryFavEntrancePanel", "Landroid/view/View;", "mStoryNoDataTv", "mStoryPostFailLayout", "mStoryPostFailTv", "mUsername", "", "dealContentView", "", "v", "getLayoutId", "", "goDateStoryGallery", "position", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "goFavAlbum", "initActionBar", "initViews", "loadFromDB", "loadFromRemote", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBubbleFail", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "onStoryPostFail", "list", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "supportNavigationSwipeBack", "", "Companion", "plugin-story_release"})
public final class StoryAlbumUI
  extends MMFragment
  implements a.f
{
  public static final StoryAlbumUI.a AWP;
  private static final String TAG = "MicroMsg.StoryAlbumUI";
  private LinearLayout AWH;
  private LinearLayout AWI;
  private TextView AWJ;
  private TextView AWK;
  private TextView AWL;
  private View AWM;
  private a AWN;
  private a.e AWO;
  private RecyclerView anl;
  private String lEN = "";
  
  static
  {
    AppMethodBeat.i(119842);
    AWP = new StoryAlbumUI.a((byte)0);
    TAG = "MicroMsg.StoryAlbumUI";
    AppMethodBeat.o(119842);
  }
  
  private final void loadFromDB()
  {
    AppMethodBeat.i(119835);
    a.e locale = this.AWO;
    if (locale == null) {
      p.bcb("mPresenter");
    }
    locale.ehq();
    AppMethodBeat.o(119835);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(119837);
    p.h(paramView, "v");
    super.dealContentView(paramView);
    this.AWO = ((a.e)new com.tencent.mm.plugin.story.g.a((a.f)this));
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
    this.lEN = ((String)localObject);
    ad.i(TAG, "initViews username=" + this.lEN);
    localObject = paramView.findViewById(2131296618);
    p.g(localObject, "v.findViewById(R.id.album_story_recycler)");
    this.anl = ((RecyclerView)localObject);
    localObject = paramView.findViewById(2131296621);
    p.g(localObject, "v.findViewById(R.id.album_story_send_fail_layout)");
    this.AWH = ((LinearLayout)localObject);
    localObject = paramView.findViewById(2131296540);
    p.g(localObject, "v.findViewById(R.id.album_bubble_send_fail_layout)");
    this.AWI = ((LinearLayout)localObject);
    localObject = paramView.findViewById(2131296622);
    p.g(localObject, "v.findViewById(R.id.album_story_send_fail_tips)");
    this.AWJ = ((TextView)localObject);
    localObject = paramView.findViewById(2131296541);
    p.g(localObject, "v.findViewById(R.id.album_bubble_send_fail_tips)");
    this.AWK = ((TextView)localObject);
    localObject = paramView.findViewById(2131296617);
    p.g(localObject, "v.findViewById(R.id.album_story_no_data_tip_tv)");
    this.AWL = ((TextView)localObject);
    paramView = paramView.findViewById(2131296616);
    p.g(paramView, "v.findViewById(R.id.album_story_no_data_fav_panel)");
    this.AWM = paramView;
    this.AWN = new a();
    paramView = this.AWN;
    if (paramView == null) {
      p.bcb("mStoryAlbumAdapter");
    }
    paramView.AWs = ((b)new c(this));
    paramView = this.AWN;
    if (paramView == null) {
      p.bcb("mStoryAlbumAdapter");
    }
    paramView.AWt = ((d.g.a.a)new StoryAlbumUI.d(this));
    paramView = this.anl;
    if (paramView == null) {
      p.bcb("mRecyclerView");
    }
    localObject = this.AWN;
    if (localObject == null) {
      p.bcb("mStoryAlbumAdapter");
    }
    paramView.setAdapter((RecyclerView.a)localObject);
    paramView = this.anl;
    if (paramView == null) {
      p.bcb("mRecyclerView");
    }
    getActivity();
    paramView.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramView = this.anl;
    if (paramView == null) {
      p.bcb("mRecyclerView");
    }
    paramView.a((RecyclerView.m)new e(this));
    paramView = this.AWM;
    if (paramView == null) {
      p.bcb("mStoryFavEntrancePanel");
    }
    paramView.setOnClickListener((View.OnClickListener)new StoryAlbumUI.f(this));
    paramView = this.AWO;
    if (paramView == null) {
      p.bcb("mPresenter");
    }
    paramView.onCreate(this.lEN);
    loadFromDB();
    paramView = this.AWO;
    if (paramView == null) {
      p.bcb("mPresenter");
    }
    paramView.eho();
    AppMethodBeat.o(119837);
  }
  
  public final void ehr()
  {
    AppMethodBeat.i(119841);
    a locala = this.AWN;
    if (locala == null) {
      p.bcb("mStoryAlbumAdapter");
    }
    locala.oMN = true;
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
  
  public final void gb(List<c> paramList)
  {
    AppMethodBeat.i(119840);
    p.h(paramList, "datas");
    ad.i(TAG, "onLoadFinish datas.size=" + paramList.size());
    a locala = this.AWN;
    if (locala == null) {
      p.bcb("mStoryAlbumAdapter");
    }
    locala.gs(paramList);
    if (paramList.isEmpty())
    {
      paramList = this.AWM;
      if (paramList == null) {
        p.bcb("mStoryFavEntrancePanel");
      }
      paramList.setVisibility(0);
      paramList = this.AWL;
      if (paramList == null) {
        p.bcb("mStoryNoDataTv");
      }
      paramList.setVisibility(0);
      paramList = this.anl;
      if (paramList == null) {
        p.bcb("mRecyclerView");
      }
      paramList.setVisibility(8);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.story.c.a.a.AIv.egU())
      {
        paramList = this.AWM;
        if (paramList == null) {
          p.bcb("mStoryFavEntrancePanel");
        }
        paramList.setVisibility(8);
      }
      AppMethodBeat.o(119840);
      return;
      paramList = this.AWM;
      if (paramList == null) {
        p.bcb("mStoryFavEntrancePanel");
      }
      paramList.setVisibility(8);
      paramList = this.AWL;
      if (paramList == null) {
        p.bcb("mStoryNoDataTv");
      }
      paramList.setVisibility(8);
      paramList = this.anl;
      if (paramList == null) {
        p.bcb("mRecyclerView");
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
    ad.d(TAG, "onActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
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
    setBackBtn((MenuItem.OnMenuItemClickListener)new StoryAlbumUI.b(this));
    AppMethodBeat.o(119836);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119839);
    super.onDestroy();
    a.e locale = this.AWO;
    if (locale == null) {
      p.bcb("mPresenter");
    }
    locale.ebV();
    AppMethodBeat.o(119839);
  }
  
  public final boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "storyHistoryInfo", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "invoke"})
  static final class c
    extends q
    implements b<h, z>
  {
    c(StoryAlbumUI paramStoryAlbumUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class e
    extends e
  {
    public final void Zt()
    {
      AppMethodBeat.i(119833);
      StoryAlbumUI.c(this.AWQ).ehn();
      AppMethodBeat.o(119833);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryAlbumUI
 * JD-Core Version:    0.7.0.1
 */