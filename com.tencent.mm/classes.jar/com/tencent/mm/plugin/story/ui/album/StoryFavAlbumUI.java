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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "()V", "curDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "isSelf", "", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "mUsername", "", "tipTv", "Landroid/widget/TextView;", "getLayoutId", "", "goFavGallery", "", "position", "dateList", "goFavSelector", "initActionBar", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "onLoadFavFinish", "datas", "", "isAllEmpty", "onResume", "Companion", "plugin-story_release"})
public final class StoryFavAlbumUI
  extends MMActivity
  implements a.b
{
  public static final StoryFavAlbumUI.a Bos;
  private static final String TAG = "MicroMsg.StoryFavAlbumUI";
  private ArrayList<j> Bop;
  private StoryFavoritePanel Boq;
  private a.a Bor;
  private boolean dsB;
  private TextView iFP;
  private String lJm;
  
  static
  {
    AppMethodBeat.i(119858);
    Bos = new StoryFavAlbumUI.a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumUI";
    AppMethodBeat.o(119858);
  }
  
  public StoryFavAlbumUI()
  {
    AppMethodBeat.i(119857);
    this.lJm = "";
    this.Bop = new ArrayList();
    this.dsB = true;
    AppMethodBeat.o(119857);
  }
  
  public final int getLayoutId()
  {
    return 2131495649;
  }
  
  public final void k(List<j> paramList, boolean paramBoolean)
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
      this.Bop.clear();
      this.Bop.addAll((Collection)paramList);
      localObject1 = this.Boq;
      if (localObject1 != null)
      {
        paramBoolean = this.dsB;
        p.h(paramList, "favoriteStory");
        ae.i(((StoryFavoritePanel)localObject1).TAG, "updateFavStory " + paramList.size());
        Object localObject2 = ((StoryFavoritePanel)localObject1).BoB;
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        localObject2 = ((StoryFavoritePanel)localObject1).BoC;
        if (localObject2 != null) {
          ((RecyclerView)localObject2).setVisibility(0);
        }
        ((StoryFavoritePanel)localObject1).dsB = paramBoolean;
        ((StoryFavoritePanel)localObject1).BoF.clear();
        if ((paramBoolean) && (((StoryFavoritePanel)localObject1).fromScene != StoryFavoritePanel.BoM)) {
          ((StoryFavoritePanel)localObject1).BoF.add(new StoryFavoritePanel.c(new j(), ((StoryFavoritePanel)localObject1).Box));
        }
        paramList = ((Iterable)paramList).iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject2 = (j)paramList.next();
            ((StoryFavoritePanel)localObject1).BoF.add(new StoryFavoritePanel.c((j)localObject2, ((StoryFavoritePanel)localObject1).Boy));
            continue;
            i = 0;
            break;
          }
        }
        ((StoryFavoritePanel)localObject1).BoF.add(new StoryFavoritePanel.c(new j(), ((StoryFavoritePanel)localObject1).xPh));
        ((StoryFavoritePanel)localObject1).BoD.notifyDataSetChanged();
        AppMethodBeat.o(119855);
        return;
      }
      AppMethodBeat.o(119855);
      return;
    }
    this.Bop.clear();
    paramList = this.iFP;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    paramList = this.Boq;
    if (paramList != null)
    {
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject1 = ((AppCompatActivity)localObject1).getResources().getString(2131764202);
      p.g(localObject1, "context.resources.getStr…album_favorite_empty_tip)");
      paramList.aDH((String)localObject1);
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
    this.lJm = paramBundle;
    ae.i(TAG, "initViews username=" + this.lJm);
    paramBundle = g.ajR().ajA().get(2);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(119852);
      throw paramBundle;
    }
    this.dsB = bu.lX((String)paramBundle, this.lJm);
    if (this.dsB)
    {
      setMMTitle(2131764203);
      setBackBtn((MenuItem.OnMenuItemClickListener)new StoryFavAlbumUI.b(this));
      this.Bor = ((a.a)new com.tencent.mm.plugin.story.g.k((a.b)this));
      paramBundle = this.Bor;
      if (paramBundle == null) {
        p.bdF("mPresenter");
      }
      paramBundle.onCreate(this.lJm);
      this.iFP = ((TextView)findViewById(2131296567));
      if (this.dsB) {
        break label508;
      }
      paramBundle = this.iFP;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      this.Boq = ((StoryFavoritePanel)findViewById(2131296607));
      paramBundle = this.Boq;
      if (paramBundle != null)
      {
        localObject = StoryFavoritePanel.BoN;
        paramBundle.setup(StoryFavoritePanel.epv());
      }
      paramBundle = this.Boq;
      if (paramBundle != null) {
        paramBundle.setMOnAddItemClickListener((b)new d(this));
      }
      paramBundle = this.Boq;
      if (paramBundle != null) {
        paramBundle.setMOnFavItemClickListener((m)new e(this));
      }
      paramBundle = this.Boq;
      if (paramBundle != null) {
        paramBundle.a((RecyclerView.m)new f(this));
      }
      paramBundle = this.Bor;
      if (paramBundle == null) {
        p.bdF("mPresenter");
      }
      paramBundle.ekW();
      paramBundle = this.Bor;
      if (paramBundle == null) {
        p.bdF("mPresenter");
      }
      paramBundle.ekX();
      AppMethodBeat.o(119852);
      return;
      paramBundle = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
      paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).azF().BH(this.lJm);
      localObject = (Context)getContext();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.adG();
        if (paramBundle == null) {}
      }
      for (paramBundle = (CharSequence)paramBundle;; paramBundle = (CharSequence)"")
      {
        View localView = findViewById(16908308);
        p.g(localView, "findViewById<TextView>(android.R.id.text1)");
        paramBundle = com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject, paramBundle, ((TextView)localView).getTextSize());
        setMMTitle(paramBundle + getString(2131764204));
        break;
      }
      label508:
      paramBundle = this.iFP;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.iFP;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)Html.fromHtml(getResources().getString(2131764197)));
      }
      paramBundle = this.iFP;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new StoryFavAlbumUI.c(this));
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119854);
    super.onDestroy();
    a.a locala = this.Bor;
    if (locala == null) {
      p.bdF("mPresenter");
    }
    locala.efC();
    AppMethodBeat.o(119854);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119853);
    super.onResume();
    a.a locala = this.Bor;
    if (locala == null) {
      p.bdF("mPresenter");
    }
    locala.ekX();
    AppMethodBeat.o(119853);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sp(boolean paramBoolean)
  {
    AppMethodBeat.i(119856);
    StoryFavoritePanel localStoryFavoritePanel = this.Boq;
    if (localStoryFavoritePanel != null)
    {
      localStoryFavoritePanel.sp(paramBoolean);
      AppMethodBeat.o(119856);
      return;
    }
    AppMethodBeat.o(119856);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "invoke"})
  static final class d
    extends q
    implements b<StoryFavoritePanel.c, z>
  {
    d(StoryFavAlbumUI paramStoryFavAlbumUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
  static final class e
    extends q
    implements m<StoryFavoritePanel.c, Integer, z>
  {
    e(StoryFavAlbumUI paramStoryFavAlbumUI)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$4", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class f
    extends e
  {
    public final void ZC()
    {
      AppMethodBeat.i(119851);
      StoryFavAlbumUI.d(this.Bot).ekV();
      AppMethodBeat.o(119851);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI
 * JD-Core Version:    0.7.0.1
 */