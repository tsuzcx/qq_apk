package com.tencent.mm.plugin.story.ui.album;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.d.a.f;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.story.ui.album.c;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "()V", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mStoryAlbumAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "mStoryBubblePostFailLayout", "Landroid/widget/LinearLayout;", "mStoryBubblePostFailTv", "Landroid/widget/TextView;", "mStoryFavEntrancePanel", "Landroid/view/View;", "mStoryNoDataTv", "mStoryPostFailLayout", "mStoryPostFailTv", "mUsername", "", "dealContentView", "", "v", "enableFavorite", "", "getLayoutId", "", "goDateStoryGallery", "position", "dateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "goFavAlbum", "initActionBar", "initViews", "loadFromDB", "loadFromRemote", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBubbleFail", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "onLoadFinish", "datas", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "onStoryPostFail", "list", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "supportNavigationSwipeBack", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryAlbumUI
  extends MMFragment
  implements a.f
{
  public static final StoryAlbumUI.a Svk;
  private static final String TAG;
  private LinearLayout Svl;
  private LinearLayout Svm;
  private TextView Svn;
  private TextView Svo;
  private TextView Svp;
  private View Svq;
  private a Svr;
  private com.tencent.mm.plugin.story.d.a.e Svs;
  private RecyclerView mRecyclerView;
  private String sWX = "";
  
  static
  {
    AppMethodBeat.i(119842);
    Svk = new StoryAlbumUI.a((byte)0);
    TAG = "MicroMsg.StoryAlbumUI";
    AppMethodBeat.o(119842);
  }
  
  private static final void a(StoryAlbumUI paramStoryAlbumUI, View paramView)
  {
    AppMethodBeat.i(367304);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStoryAlbumUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/album/StoryAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryAlbumUI, "this$0");
    paramStoryAlbumUI.hzJ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/album/StoryAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367304);
  }
  
  private static final boolean a(StoryAlbumUI paramStoryAlbumUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(367307);
    s.u(paramStoryAlbumUI, "this$0");
    paramStoryAlbumUI = paramStoryAlbumUI.getActivity();
    if (paramStoryAlbumUI != null) {
      paramStoryAlbumUI.finish();
    }
    AppMethodBeat.o(367307);
    return true;
  }
  
  private final void hzJ()
  {
    AppMethodBeat.i(367295);
    Object localObject1 = new Intent((Context)getActivity(), StoryFavAlbumUI.class);
    Object localObject2 = com.tencent.mm.kernel.h.baE().ban().d(2, null);
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(367295);
      throw ((Throwable)localObject1);
    }
    ((Intent)localObject1).putExtra("username", (String)localObject2);
    localObject2 = getActivity();
    if (localObject2 != null)
    {
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/story/ui/album/StoryAlbumUI", "goFavAlbum", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((FragmentActivity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/story/ui/album/StoryAlbumUI", "goFavAlbum", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(367295);
  }
  
  private final void loadFromDB()
  {
    AppMethodBeat.i(119835);
    com.tencent.mm.plugin.story.d.a.e locale2 = this.Svs;
    com.tencent.mm.plugin.story.d.a.e locale1 = locale2;
    if (locale2 == null)
    {
      s.bIx("mPresenter");
      locale1 = null;
    }
    locale1.hvk();
    AppMethodBeat.o(119835);
  }
  
  public final void dealContentView(View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(119837);
    s.u(paramView, "v");
    super.dealContentView(paramView);
    this.Svs = ((com.tencent.mm.plugin.story.d.a.e)new com.tencent.mm.plugin.story.f.a((a.f)this));
    Object localObject1 = getActivity();
    label257:
    label289:
    label321:
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = "";
      this.sWX = ((String)localObject1);
      Log.i(TAG, s.X("initViews username=", this.sWX));
      localObject1 = paramView.findViewById(a.d.Sdp);
      s.s(localObject1, "v.findViewById(R.id.album_story_recycler)");
      this.mRecyclerView = ((RecyclerView)localObject1);
      localObject1 = paramView.findViewById(a.d.Sdq);
      s.s(localObject1, "v.findViewById(R.id.album_story_send_fail_layout)");
      this.Svl = ((LinearLayout)localObject1);
      localObject1 = paramView.findViewById(a.d.Sdc);
      s.s(localObject1, "v.findViewById(R.id.album_bubble_send_fail_layout)");
      this.Svm = ((LinearLayout)localObject1);
      localObject1 = paramView.findViewById(a.d.Sdr);
      s.s(localObject1, "v.findViewById(R.id.album_story_send_fail_tips)");
      this.Svn = ((TextView)localObject1);
      localObject1 = paramView.findViewById(a.d.Sdd);
      s.s(localObject1, "v.findViewById(R.id.album_bubble_send_fail_tips)");
      this.Svo = ((TextView)localObject1);
      localObject1 = paramView.findViewById(a.d.Sdo);
      s.s(localObject1, "v.findViewById(R.id.album_story_no_data_tip_tv)");
      this.Svp = ((TextView)localObject1);
      paramView = paramView.findViewById(a.d.Sdn);
      s.s(paramView, "v.findViewById(R.id.album_story_no_data_fav_panel)");
      this.Svq = paramView;
      this.Svr = new a();
      paramView = this.Svr;
      if (paramView != null) {
        break label550;
      }
      s.bIx("mStoryAlbumAdapter");
      paramView = null;
      paramView.SuX = ((kotlin.g.a.b)new b(this));
      paramView = this.Svr;
      if (paramView != null) {
        break label553;
      }
      s.bIx("mStoryAlbumAdapter");
      paramView = null;
      paramView.SuY = ((kotlin.g.a.a)new StoryAlbumUI.c(this));
      paramView = this.mRecyclerView;
      if (paramView != null) {
        break label556;
      }
      s.bIx("mRecyclerView");
      paramView = null;
      localObject3 = this.Svr;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mStoryAlbumAdapter");
        localObject1 = null;
      }
      paramView.setAdapter((RecyclerView.a)localObject1);
      paramView = this.mRecyclerView;
      if (paramView != null) {
        break label559;
      }
      s.bIx("mRecyclerView");
      paramView = null;
      label368:
      getActivity();
      paramView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramView = this.mRecyclerView;
      if (paramView != null) {
        break label562;
      }
      s.bIx("mRecyclerView");
      paramView = null;
      label404:
      paramView.a((RecyclerView.l)new d(this));
      localObject1 = this.Svq;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mStoryFavEntrancePanel");
        paramView = null;
      }
      paramView.setOnClickListener(new StoryAlbumUI..ExternalSyntheticLambda1(this));
      localObject1 = this.Svs;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mPresenter");
        paramView = null;
      }
      paramView.onCreate(this.sWX);
      loadFromDB();
      paramView = this.Svs;
      if (paramView != null) {
        break label565;
      }
      s.bIx("mPresenter");
      paramView = localObject2;
    }
    label550:
    label553:
    label556:
    label559:
    label562:
    label565:
    for (;;)
    {
      paramView.hvi();
      AppMethodBeat.o(119837);
      return;
      localObject1 = ((FragmentActivity)localObject1).getIntent();
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject3 = ((Intent)localObject1).getStringExtra("username");
      localObject1 = localObject3;
      if (localObject3 != null) {
        break;
      }
      localObject1 = "";
      break;
      break label257;
      break label289;
      break label321;
      break label368;
      break label404;
    }
  }
  
  public final int getLayoutId()
  {
    return com.tencent.mm.plugin.story.a.e.Sgq;
  }
  
  public final void hvl()
  {
    AppMethodBeat.i(119841);
    a locala = this.Svr;
    if (locala == null)
    {
      s.bIx("mStoryAlbumAdapter");
      locala = null;
      locala.wHe = true;
      if (((Collection)locala.xHy).isEmpty()) {
        break label66;
      }
    }
    label66:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        locala.bZE.notifyChanged();
      }
      AppMethodBeat.o(119841);
      return;
      break;
    }
  }
  
  public final void kR(List<c> paramList)
  {
    Object localObject2 = null;
    AppMethodBeat.i(119840);
    s.u(paramList, "datas");
    Log.i(TAG, s.X("onLoadFinish datas.size=", Integer.valueOf(paramList.size())));
    Object localObject1 = this.Svr;
    if (localObject1 == null)
    {
      s.bIx("mStoryAlbumAdapter");
      localObject1 = null;
      s.u(paramList, "datas");
      Log.i(a.TAG, "updateDatas");
      ((a)localObject1).xHy.clear();
      if (!ac.hFS()) {
        break label217;
      }
    }
    label217:
    for (boolean bool = com.tencent.mm.plugin.story.c.a.a.SiJ.hve();; bool = com.tencent.mm.plugin.story.c.a.a.SiJ.huP())
    {
      if ((bool) && (!((a)localObject1).SuW))
      {
        ((a)localObject1).xHy.add(new c(((a)localObject1).SuQ, null, 2));
        Log.i(a.TAG, "updateDatas add fav");
      }
      ((a)localObject1).xHy.addAll((Collection)paramList);
      Iterator localIterator = ((Iterable)((a)localObject1).xHy).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        int i = ((a)localObject1).SuV;
        ((a)localObject1).SuV = (localc.Sve.size() + i);
      }
      break;
    }
    if (!paramList.isEmpty()) {
      ((a)localObject1).xHy.add(new c(((a)localObject1).SuP, null, 2));
    }
    ((RecyclerView.a)localObject1).bZE.notifyChanged();
    if (paramList.isEmpty())
    {
      localObject1 = this.Svq;
      paramList = (List<c>)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mStoryFavEntrancePanel");
        paramList = null;
      }
      paramList.setVisibility(0);
      localObject1 = this.Svp;
      paramList = (List<c>)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mStoryNoDataTv");
        paramList = null;
      }
      paramList.setVisibility(0);
      localObject1 = this.mRecyclerView;
      paramList = (List<c>)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mRecyclerView");
        paramList = null;
      }
      paramList.setVisibility(8);
      if (!ac.hFS()) {
        break label492;
      }
      bool = com.tencent.mm.plugin.story.c.a.a.SiJ.hve();
      label371:
      if (!bool)
      {
        paramList = this.Svq;
        if (paramList != null) {
          break label502;
        }
        s.bIx("mStoryFavEntrancePanel");
        paramList = localObject2;
      }
    }
    label492:
    label502:
    for (;;)
    {
      paramList.setVisibility(8);
      AppMethodBeat.o(119840);
      return;
      localObject1 = this.Svq;
      paramList = (List<c>)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mStoryFavEntrancePanel");
        paramList = null;
      }
      paramList.setVisibility(8);
      localObject1 = this.Svp;
      paramList = (List<c>)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mStoryNoDataTv");
        paramList = null;
      }
      paramList.setVisibility(8);
      localObject1 = this.mRecyclerView;
      paramList = (List<c>)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mRecyclerView");
        paramList = null;
      }
      paramList.setVisibility(0);
      break;
      bool = com.tencent.mm.plugin.story.c.a.a.SiJ.huP();
      break label371;
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
    setBackBtn(new StoryAlbumUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(119836);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119839);
    super.onDestroy();
    com.tencent.mm.plugin.story.d.a.e locale2 = this.Svs;
    com.tencent.mm.plugin.story.d.a.e locale1 = locale2;
    if (locale2 == null)
    {
      s.bIx("mPresenter");
      locale1 = null;
    }
    locale1.hoB();
    AppMethodBeat.o(119839);
  }
  
  public final boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "storyHistoryInfo", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.story.h.h, ah>
  {
    b(StoryAlbumUI paramStoryAlbumUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/album/StoryAlbumUI$initViews$3", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends e
  {
    d(StoryAlbumUI paramStoryAlbumUI) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(119833);
      com.tencent.mm.plugin.story.d.a.e locale2 = StoryAlbumUI.c(this.Svt);
      com.tencent.mm.plugin.story.d.a.e locale1 = locale2;
      if (locale2 == null)
      {
        s.bIx("mPresenter");
        locale1 = null;
      }
      locale1.hvh();
      AppMethodBeat.o(119833);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryAlbumUI
 * JD-Core Version:    0.7.0.1
 */