package com.tencent.mm.plugin.story.ui.album;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.text.Html;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.a.m;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "()V", "curDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "isSelf", "", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "mUsername", "", "tipTv", "Landroid/widget/TextView;", "getLayoutId", "", "goFavGallery", "", "position", "dateList", "goFavSelector", "initActionBar", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "onLoadFavFinish", "datas", "", "isAllEmpty", "onResume", "Companion", "plugin-story_release"})
public final class StoryFavAlbumUI
  extends MMActivity
  implements a.b
{
  private static final String TAG = "MicroMsg.StoryFavAlbumUI";
  public static final a yrY;
  private boolean diE;
  private TextView hJf;
  private String kGt;
  private ArrayList<j> yrV;
  private StoryFavoritePanel yrW;
  private a.a yrX;
  
  static
  {
    AppMethodBeat.i(119858);
    yrY = new a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumUI";
    AppMethodBeat.o(119858);
  }
  
  public StoryFavAlbumUI()
  {
    AppMethodBeat.i(119857);
    this.kGt = "";
    this.yrV = new ArrayList();
    this.diE = true;
    AppMethodBeat.o(119857);
  }
  
  public final int getLayoutId()
  {
    return 2131495649;
  }
  
  public final void i(List<j> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(119855);
    d.g.b.k.h(paramList, "datas");
    int i;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    Object localObject1;
    while ((i != 0) || (!paramBoolean))
    {
      this.yrV.clear();
      this.yrV.addAll((Collection)paramList);
      localObject1 = this.yrW;
      if (localObject1 != null)
      {
        paramBoolean = this.diE;
        d.g.b.k.h(paramList, "favoriteStory");
        ad.i(((StoryFavoritePanel)localObject1).TAG, "updateFavStory " + paramList.size());
        Object localObject2 = ((StoryFavoritePanel)localObject1).ysh;
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        localObject2 = ((StoryFavoritePanel)localObject1).ysi;
        if (localObject2 != null) {
          ((RecyclerView)localObject2).setVisibility(0);
        }
        ((StoryFavoritePanel)localObject1).diE = paramBoolean;
        ((StoryFavoritePanel)localObject1).ysl.clear();
        if ((paramBoolean) && (((StoryFavoritePanel)localObject1).fromScene != StoryFavoritePanel.yss)) {
          ((StoryFavoritePanel)localObject1).ysl.add(new StoryFavoritePanel.c(new j(), ((StoryFavoritePanel)localObject1).ysd));
        }
        paramList = ((Iterable)paramList).iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject2 = (j)paramList.next();
            ((StoryFavoritePanel)localObject1).ysl.add(new StoryFavoritePanel.c((j)localObject2, ((StoryFavoritePanel)localObject1).yse));
            continue;
            i = 0;
            break;
          }
        }
        ((StoryFavoritePanel)localObject1).ysl.add(new StoryFavoritePanel.c(new j(), ((StoryFavoritePanel)localObject1).viI));
        ((StoryFavoritePanel)localObject1).ysj.notifyDataSetChanged();
        AppMethodBeat.o(119855);
        return;
      }
      AppMethodBeat.o(119855);
      return;
    }
    this.yrV.clear();
    paramList = this.hJf;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    paramList = this.yrW;
    if (paramList != null)
    {
      localObject1 = getContext();
      d.g.b.k.g(localObject1, "context");
      localObject1 = ((AppCompatActivity)localObject1).getResources().getString(2131764202);
      d.g.b.k.g(localObject1, "context.resources.getStr…album_favorite_empty_tip)");
      paramList.asb((String)localObject1);
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
    this.kGt = paramBundle;
    ad.i(TAG, "initViews username=" + this.kGt);
    paramBundle = g.afB().afk().get(2);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(119852);
      throw paramBundle;
    }
    this.diE = bt.kU((String)paramBundle, this.kGt);
    if (this.diE)
    {
      setMMTitle(2131764203);
      setBackBtn((MenuItem.OnMenuItemClickListener)new StoryFavAlbumUI.b(this));
      this.yrX = ((a.a)new com.tencent.mm.plugin.story.g.k((a.b)this));
      paramBundle = this.yrX;
      if (paramBundle == null) {
        d.g.b.k.aPZ("mPresenter");
      }
      paramBundle.onCreate(this.kGt);
      this.hJf = ((TextView)findViewById(2131296567));
      if (this.diE) {
        break label508;
      }
      paramBundle = this.hJf;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      this.yrW = ((StoryFavoritePanel)findViewById(2131296607));
      paramBundle = this.yrW;
      if (paramBundle != null)
      {
        localObject = StoryFavoritePanel.yst;
        paramBundle.setup(StoryFavoritePanel.dKX());
      }
      paramBundle = this.yrW;
      if (paramBundle != null) {
        paramBundle.setMOnAddItemClickListener((b)new d(this));
      }
      paramBundle = this.yrW;
      if (paramBundle != null) {
        paramBundle.setMOnFavItemClickListener((m)new e(this));
      }
      paramBundle = this.yrW;
      if (paramBundle != null) {
        paramBundle.a((RecyclerView.m)new f(this));
      }
      paramBundle = this.yrX;
      if (paramBundle == null) {
        d.g.b.k.aPZ("mPresenter");
      }
      paramBundle.dGy();
      paramBundle = this.yrX;
      if (paramBundle == null) {
        d.g.b.k.aPZ("mPresenter");
      }
      paramBundle.dGz();
      AppMethodBeat.o(119852);
      return;
      paramBundle = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
      paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramBundle).apM().aHY(this.kGt);
      localObject = (Context)getContext();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.ZX();
        if (paramBundle == null) {}
      }
      for (paramBundle = (CharSequence)paramBundle;; paramBundle = (CharSequence)"")
      {
        View localView = findViewById(16908308);
        d.g.b.k.g(localView, "findViewById<TextView>(android.R.id.text1)");
        paramBundle = com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject, paramBundle, ((TextView)localView).getTextSize());
        setMMTitle(paramBundle + getString(2131764204));
        break;
      }
      label508:
      paramBundle = this.hJf;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.hJf;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)Html.fromHtml(getResources().getString(2131764197)));
      }
      paramBundle = this.hJf;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new StoryFavAlbumUI.c(this));
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119854);
    super.onDestroy();
    a.a locala = this.yrX;
    if (locala == null) {
      d.g.b.k.aPZ("mPresenter");
    }
    locala.dBh();
    AppMethodBeat.o(119854);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119853);
    super.onResume();
    a.a locala = this.yrX;
    if (locala == null) {
      d.g.b.k.aPZ("mPresenter");
    }
    locala.dGz();
    AppMethodBeat.o(119853);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qE(boolean paramBoolean)
  {
    AppMethodBeat.i(119856);
    StoryFavoritePanel localStoryFavoritePanel = this.yrW;
    if (localStoryFavoritePanel != null)
    {
      localStoryFavoritePanel.qE(paramBoolean);
      AppMethodBeat.o(119856);
      return;
    }
    AppMethodBeat.o(119856);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<StoryFavoritePanel.c, y>
  {
    d(StoryFavAlbumUI paramStoryFavAlbumUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements m<StoryFavoritePanel.c, Integer, y>
  {
    e(StoryFavAlbumUI paramStoryFavAlbumUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$4", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class f
    extends e
  {
    public final void Wc()
    {
      AppMethodBeat.i(119851);
      StoryFavAlbumUI.d(this.yrZ).dGx();
      AppMethodBeat.o(119851);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI
 * JD-Core Version:    0.7.0.1
 */