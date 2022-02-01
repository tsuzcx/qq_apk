package com.tencent.mm.plugin.story.ui.album;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.text.Html;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.plugin.story.g.k;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "()V", "curDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "isSelf", "", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "mUsername", "", "tipTv", "Landroid/widget/TextView;", "getLayoutId", "", "goFavGallery", "", "position", "dateList", "goFavSelector", "initActionBar", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "onLoadFavFinish", "datas", "", "isAllEmpty", "onResume", "Companion", "plugin-story_release"})
public final class StoryFavAlbumUI
  extends MMActivity
  implements a.b
{
  public static final StoryFavAlbumUI.a Fzi;
  private static final String TAG = "MicroMsg.StoryFavAlbumUI";
  private ArrayList<j> Fzf;
  private StoryFavoritePanel Fzg;
  private a.a Fzh;
  private boolean dJM;
  private TextView jBS;
  private String mRa;
  
  static
  {
    AppMethodBeat.i(119858);
    Fzi = new StoryFavAlbumUI.a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumUI";
    AppMethodBeat.o(119858);
  }
  
  public StoryFavAlbumUI()
  {
    AppMethodBeat.i(119857);
    this.mRa = "";
    this.Fzf = new ArrayList();
    this.dJM = true;
    AppMethodBeat.o(119857);
  }
  
  public final int getLayoutId()
  {
    return 2131496554;
  }
  
  public final void o(List<j> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(119855);
    p.h(paramList, "datas");
    int i;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    Object localObject1;
    while ((i != 0) || (!paramBoolean))
    {
      this.Fzf.clear();
      this.Fzf.addAll((Collection)paramList);
      localObject1 = this.Fzg;
      if (localObject1 != null)
      {
        paramBoolean = this.dJM;
        p.h(paramList, "favoriteStory");
        Log.i(((StoryFavoritePanel)localObject1).TAG, "updateFavStory " + paramList.size());
        Object localObject2 = ((StoryFavoritePanel)localObject1).Fzr;
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        localObject2 = ((StoryFavoritePanel)localObject1).Fzs;
        if (localObject2 != null) {
          ((RecyclerView)localObject2).setVisibility(0);
        }
        ((StoryFavoritePanel)localObject1).dJM = paramBoolean;
        ((StoryFavoritePanel)localObject1).Fzv.clear();
        if ((paramBoolean) && (((StoryFavoritePanel)localObject1).fromScene != StoryFavoritePanel.FzC)) {
          ((StoryFavoritePanel)localObject1).Fzv.add(new StoryFavoritePanel.c(new j(), ((StoryFavoritePanel)localObject1).Fzn));
        }
        paramList = ((Iterable)paramList).iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject2 = (j)paramList.next();
            ((StoryFavoritePanel)localObject1).Fzv.add(new StoryFavoritePanel.c((j)localObject2, ((StoryFavoritePanel)localObject1).Fzo));
            continue;
            i = 0;
            break;
          }
        }
        ((StoryFavoritePanel)localObject1).Fzv.add(new StoryFavoritePanel.c(new j(), ((StoryFavoritePanel)localObject1).BPk));
        ((StoryFavoritePanel)localObject1).Fzt.notifyDataSetChanged();
        AppMethodBeat.o(119855);
        return;
      }
      AppMethodBeat.o(119855);
      return;
    }
    this.Fzf.clear();
    paramList = this.jBS;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    paramList = this.Fzg;
    if (paramList != null)
    {
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject1 = ((AppCompatActivity)localObject1).getResources().getString(2131766458);
      p.g(localObject1, "context.resources.getStr…album_favorite_empty_tip)");
      paramList.aSC((String)localObject1);
      AppMethodBeat.o(119855);
      return;
    }
    AppMethodBeat.o(119855);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119852);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    Object localObject;
    if (paramBundle != null)
    {
      localObject = paramBundle.getStringExtra("username");
      paramBundle = (Bundle)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramBundle = "";
    }
    this.mRa = paramBundle;
    Log.i(TAG, "initViews username=" + this.mRa);
    paramBundle = g.aAh().azQ().get(2);
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(119852);
      throw paramBundle;
    }
    this.dJM = Util.isEqual((String)paramBundle, this.mRa);
    if (this.dJM)
    {
      setMMTitle(2131766459);
      setBackBtn((MenuItem.OnMenuItemClickListener)new StoryFavAlbumUI.b(this));
      this.Fzh = ((a.a)new k((a.b)this));
      paramBundle = this.Fzh;
      if (paramBundle == null) {
        p.btv("mPresenter");
      }
      paramBundle.onCreate(this.mRa);
      this.jBS = ((TextView)findViewById(2131296644));
      if (this.dJM) {
        break label508;
      }
      paramBundle = this.jBS;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      this.Fzg = ((StoryFavoritePanel)findViewById(2131296684));
      paramBundle = this.Fzg;
      if (paramBundle != null)
      {
        localObject = StoryFavoritePanel.FzD;
        paramBundle.setup(StoryFavoritePanel.frV());
      }
      paramBundle = this.Fzg;
      if (paramBundle != null) {
        paramBundle.setMOnAddItemClickListener((b)new d(this));
      }
      paramBundle = this.Fzg;
      if (paramBundle != null) {
        paramBundle.setMOnFavItemClickListener((m)new e(this));
      }
      paramBundle = this.Fzg;
      if (paramBundle != null) {
        paramBundle.a((RecyclerView.l)new f(this));
      }
      paramBundle = this.Fzh;
      if (paramBundle == null) {
        p.btv("mPresenter");
      }
      paramBundle.fnx();
      paramBundle = this.Fzh;
      if (paramBundle == null) {
        p.btv("mPresenter");
      }
      paramBundle.fny();
      AppMethodBeat.o(119852);
      return;
      paramBundle = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
      paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).aSN().Kn(this.mRa);
      localObject = (Context)getContext();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.arJ();
        if (paramBundle == null) {}
      }
      for (paramBundle = (CharSequence)paramBundle;; paramBundle = (CharSequence)"")
      {
        View localView = findViewById(16908308);
        p.g(localView, "findViewById<TextView>(android.R.id.text1)");
        paramBundle = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject, paramBundle, ((TextView)localView).getTextSize());
        setMMTitle(paramBundle + getString(2131766460));
        break;
      }
      label508:
      paramBundle = this.jBS;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.jBS;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)Html.fromHtml(getResources().getString(2131766453)));
      }
      paramBundle = this.jBS;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new StoryFavAlbumUI.c(this));
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119854);
    super.onDestroy();
    a.a locala = this.Fzh;
    if (locala == null) {
      p.btv("mPresenter");
    }
    locala.fib();
    AppMethodBeat.o(119854);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119853);
    super.onResume();
    a.a locala = this.Fzh;
    if (locala == null) {
      p.btv("mPresenter");
    }
    locala.fny();
    AppMethodBeat.o(119853);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void vK(boolean paramBoolean)
  {
    AppMethodBeat.i(119856);
    StoryFavoritePanel localStoryFavoritePanel = this.Fzg;
    if (localStoryFavoritePanel != null)
    {
      localStoryFavoritePanel.vK(paramBoolean);
      AppMethodBeat.o(119856);
      return;
    }
    AppMethodBeat.o(119856);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "invoke"})
  static final class d
    extends q
    implements b<StoryFavoritePanel.c, x>
  {
    d(StoryFavAlbumUI paramStoryFavAlbumUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
  static final class e
    extends q
    implements m<StoryFavoritePanel.c, Integer, x>
  {
    e(StoryFavAlbumUI paramStoryFavAlbumUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$4", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class f
    extends e
  {
    public final void onLoadMore()
    {
      AppMethodBeat.i(119851);
      StoryFavAlbumUI.d(this.Fzj).fnw();
      AppMethodBeat.o(119851);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI
 * JD-Core Version:    0.7.0.1
 */