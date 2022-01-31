package com.tencent.mm.plugin.story.ui.album;

import a.f.a.b;
import a.f.b.j;
import a.l;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragment;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "()V", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mStoryAlbumAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "mStoryBubblePostFailLayout", "Landroid/widget/LinearLayout;", "mStoryBubblePostFailTv", "Landroid/widget/TextView;", "mStoryFavEntrancePanel", "Landroid/view/View;", "mStoryNoDataTv", "mStoryPostFailLayout", "mStoryPostFailTv", "mUsername", "", "dealContentView", "", "v", "getLayoutId", "", "goDateStoryGallery", "position", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "goFavAlbum", "initActionBar", "initViews", "loadFromDB", "loadFromRemote", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBubbleFail", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "onStoryPostFail", "list", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "supportNavigationSwipeBack", "", "Companion", "plugin-story_release"})
public final class StoryAlbumUI
  extends MMFragment
  implements a.f
{
  private static final String TAG = "MicroMsg.StoryAlbumUI";
  public static final StoryAlbumUI.a sJr;
  private RecyclerView adt;
  private String ikj = "";
  private LinearLayout sJj;
  private LinearLayout sJk;
  private TextView sJl;
  private TextView sJm;
  private TextView sJn;
  private View sJo;
  private a sJp;
  private a.e sJq;
  
  static
  {
    AppMethodBeat.i(110181);
    sJr = new StoryAlbumUI.a((byte)0);
    TAG = "MicroMsg.StoryAlbumUI";
    AppMethodBeat.o(110181);
  }
  
  private final void loadFromDB()
  {
    AppMethodBeat.i(110173);
    a.e locale = this.sJq;
    if (locale == null) {
      j.ays("mPresenter");
    }
    locale.czK();
    AppMethodBeat.o(110173);
  }
  
  public final void czL()
  {
    AppMethodBeat.i(110179);
    a locala = this.sJp;
    if (locala == null) {
      j.ays("mStoryAlbumAdapter");
    }
    locala.sek = true;
    if (!((Collection)locala.mItemList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        locala.notifyDataSetChanged();
      }
      AppMethodBeat.o(110179);
      return;
    }
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(110175);
    j.q(paramView, "v");
    super.dealContentView(paramView);
    this.sJq = ((a.e)new com.tencent.mm.plugin.story.f.a((a.f)this));
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
    this.ikj = ((String)localObject);
    ab.i(TAG, "initViews username=" + this.ikj);
    localObject = paramView.findViewById(2131828260);
    j.p(localObject, "v.findViewById(R.id.album_story_recycler)");
    this.adt = ((RecyclerView)localObject);
    localObject = paramView.findViewById(2131828250);
    j.p(localObject, "v.findViewById(R.id.album_story_send_fail_layout)");
    this.sJj = ((LinearLayout)localObject);
    localObject = paramView.findViewById(2131828254);
    j.p(localObject, "v.findViewById(R.id.album_bubble_send_fail_layout)");
    this.sJk = ((LinearLayout)localObject);
    localObject = paramView.findViewById(2131828253);
    j.p(localObject, "v.findViewById(R.id.album_story_send_fail_tips)");
    this.sJl = ((TextView)localObject);
    localObject = paramView.findViewById(2131828257);
    j.p(localObject, "v.findViewById(R.id.album_bubble_send_fail_tips)");
    this.sJm = ((TextView)localObject);
    localObject = paramView.findViewById(2131828259);
    j.p(localObject, "v.findViewById(R.id.album_story_no_data_tip_tv)");
    this.sJn = ((TextView)localObject);
    paramView = paramView.findViewById(2131828258);
    j.p(paramView, "v.findViewById(R.id.album_story_no_data_fav_panel)");
    this.sJo = paramView;
    this.sJp = new a();
    paramView = this.sJp;
    if (paramView == null) {
      j.ays("mStoryAlbumAdapter");
    }
    paramView.sIT = ((b)new StoryAlbumUI.c(this));
    paramView = this.sJp;
    if (paramView == null) {
      j.ays("mStoryAlbumAdapter");
    }
    paramView.sIU = ((a.f.a.a)new StoryAlbumUI.d(this));
    paramView = this.adt;
    if (paramView == null) {
      j.ays("mRecyclerView");
    }
    localObject = this.sJp;
    if (localObject == null) {
      j.ays("mStoryAlbumAdapter");
    }
    paramView.setAdapter((RecyclerView.a)localObject);
    paramView = this.adt;
    if (paramView == null) {
      j.ays("mRecyclerView");
    }
    getActivity();
    paramView.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    paramView = this.adt;
    if (paramView == null) {
      j.ays("mRecyclerView");
    }
    paramView.a((RecyclerView.m)new StoryAlbumUI.e(this));
    paramView = this.sJo;
    if (paramView == null) {
      j.ays("mStoryFavEntrancePanel");
    }
    paramView.setOnClickListener((View.OnClickListener)new StoryAlbumUI.f(this));
    paramView = this.sJq;
    if (paramView == null) {
      j.ays("mPresenter");
    }
    paramView.onCreate(this.ikj);
    loadFromDB();
    paramView = this.sJq;
    if (paramView == null) {
      j.ays("mPresenter");
    }
    paramView.czI();
    AppMethodBeat.o(110175);
  }
  
  public final void dq(List<c> paramList)
  {
    AppMethodBeat.i(110178);
    j.q(paramList, "datas");
    ab.i(TAG, "onLoadFinish datas.size=" + paramList.size());
    a locala = this.sJp;
    if (locala == null) {
      j.ays("mStoryAlbumAdapter");
    }
    locala.dI(paramList);
    if (paramList.isEmpty())
    {
      paramList = this.sJo;
      if (paramList == null) {
        j.ays("mStoryFavEntrancePanel");
      }
      paramList.setVisibility(0);
      paramList = this.sJn;
      if (paramList == null) {
        j.ays("mStoryNoDataTv");
      }
      paramList.setVisibility(0);
      paramList = this.adt;
      if (paramList == null) {
        j.ays("mRecyclerView");
      }
      paramList.setVisibility(8);
    }
    for (;;)
    {
      if (!com.tencent.mm.plugin.story.c.a.a.srz.czq())
      {
        paramList = this.sJo;
        if (paramList == null) {
          j.ays("mStoryFavEntrancePanel");
        }
        paramList.setVisibility(8);
      }
      AppMethodBeat.o(110178);
      return;
      paramList = this.sJo;
      if (paramList == null) {
        j.ays("mStoryFavEntrancePanel");
      }
      paramList.setVisibility(8);
      paramList = this.sJn;
      if (paramList == null) {
        j.ays("mStoryNoDataTv");
      }
      paramList.setVisibility(8);
      paramList = this.adt;
      if (paramList == null) {
        j.ays("mRecyclerView");
      }
      paramList.setVisibility(0);
    }
  }
  
  public final int getLayoutId()
  {
    return 2130970923;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(110176);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.d(TAG, "onActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    if (paramInt1 == 1) {
      loadFromDB();
    }
    AppMethodBeat.o(110176);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110174);
    super.onCreate(paramBundle);
    setMMTitle(2131296518);
    setBackBtn((MenuItem.OnMenuItemClickListener)new StoryAlbumUI.b(this));
    AppMethodBeat.o(110174);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(110177);
    super.onDestroy();
    a.e locale = this.sJq;
    if (locale == null) {
      j.ays("mPresenter");
    }
    locale.bOo();
    AppMethodBeat.o(110177);
  }
  
  public final boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryAlbumUI
 * JD-Core Version:    0.7.0.1
 */