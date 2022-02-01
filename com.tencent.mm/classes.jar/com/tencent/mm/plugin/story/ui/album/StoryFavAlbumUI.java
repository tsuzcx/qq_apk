package com.tencent.mm.plugin.story.ui.album;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.g;
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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "()V", "curDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "isSelf", "", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "mUsername", "", "tipTv", "Landroid/widget/TextView;", "getLayoutId", "", "goFavGallery", "", "position", "dateList", "goFavSelector", "initActionBar", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "onLoadFavFinish", "datas", "", "isAllEmpty", "onResume", "Companion", "plugin-story_release"})
public final class StoryFavAlbumUI
  extends MMActivity
  implements a.b
{
  public static final a LTk;
  private static final String TAG = "MicroMsg.StoryFavAlbumUI";
  private ArrayList<j> LTh;
  private StoryFavoritePanel LTi;
  private a.a LTj;
  private boolean fCB;
  private TextView mrN;
  private String pRV;
  
  static
  {
    AppMethodBeat.i(119858);
    LTk = new a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumUI";
    AppMethodBeat.o(119858);
  }
  
  public StoryFavAlbumUI()
  {
    AppMethodBeat.i(119857);
    this.pRV = "";
    this.LTh = new ArrayList();
    this.fCB = true;
    AppMethodBeat.o(119857);
  }
  
  public final int getLayoutId()
  {
    return a.e.LCx;
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
    this.pRV = paramBundle;
    Log.i(TAG, "initViews username=" + this.pRV);
    paramBundle = h.aHG().aHp().get(2);
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(119852);
      throw paramBundle;
    }
    this.fCB = Util.isEqual((String)paramBundle, this.pRV);
    if (this.fCB)
    {
      setMMTitle(a.g.LDz);
      setBackBtn((MenuItem.OnMenuItemClickListener)new StoryFavAlbumUI.b(this));
      this.LTj = ((a.a)new k((a.b)this));
      paramBundle = this.LTj;
      if (paramBundle == null) {
        p.bGy("mPresenter");
      }
      paramBundle.onCreate(this.pRV);
      this.mrN = ((TextView)findViewById(a.d.Lzr));
      if (this.fCB) {
        break label504;
      }
      paramBundle = this.mrN;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      this.LTi = ((StoryFavoritePanel)findViewById(a.d.Lzt));
      paramBundle = this.LTi;
      if (paramBundle != null)
      {
        localObject = StoryFavoritePanel.LTG;
        paramBundle.setup(StoryFavoritePanel.ggs());
      }
      paramBundle = this.LTi;
      if (paramBundle != null) {
        paramBundle.setMOnAddItemClickListener((b)new d(this));
      }
      paramBundle = this.LTi;
      if (paramBundle != null) {
        paramBundle.setMOnFavItemClickListener((m)new e(this));
      }
      paramBundle = this.LTi;
      if (paramBundle != null) {
        paramBundle.a((RecyclerView.l)new f(this));
      }
      paramBundle = this.LTj;
      if (paramBundle == null) {
        p.bGy("mPresenter");
      }
      paramBundle.gbR();
      paramBundle = this.LTj;
      if (paramBundle == null) {
        p.bGy("mPresenter");
      }
      paramBundle.gbS();
      AppMethodBeat.o(119852);
      return;
      paramBundle = h.ae(n.class);
      p.j(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
      paramBundle = ((n)paramBundle).bbL().RG(this.pRV);
      localObject = (Context)getContext();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.ays();
        if (paramBundle == null) {}
      }
      for (paramBundle = (CharSequence)paramBundle;; paramBundle = (CharSequence)"")
      {
        View localView = findViewById(16908308);
        p.j(localView, "findViewById<TextView>(android.R.id.text1)");
        paramBundle = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject, paramBundle, ((TextView)localView).getTextSize());
        setMMTitle(paramBundle + getString(a.g.LDA));
        break;
      }
      label504:
      paramBundle = this.mrN;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.mrN;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)Html.fromHtml(getResources().getString(a.g.LDx)));
      }
      paramBundle = this.mrN;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new StoryFavAlbumUI.c(this));
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119854);
    super.onDestroy();
    a.a locala = this.LTj;
    if (locala == null) {
      p.bGy("mPresenter");
    }
    locala.fWn();
    AppMethodBeat.o(119854);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119853);
    super.onResume();
    a.a locala = this.LTj;
    if (locala == null) {
      p.bGy("mPresenter");
    }
    locala.gbS();
    AppMethodBeat.o(119853);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void q(List<j> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(119855);
    p.k(paramList, "datas");
    int i;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    Object localObject1;
    while ((i != 0) || (!paramBoolean))
    {
      this.LTh.clear();
      this.LTh.addAll((Collection)paramList);
      localObject1 = this.LTi;
      if (localObject1 != null)
      {
        paramBoolean = this.fCB;
        p.k(paramList, "favoriteStory");
        Log.i(((StoryFavoritePanel)localObject1).TAG, "updateFavStory " + paramList.size());
        Object localObject2 = ((StoryFavoritePanel)localObject1).LTt;
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        localObject2 = ((StoryFavoritePanel)localObject1).LTu;
        if (localObject2 != null) {
          ((RecyclerView)localObject2).setVisibility(0);
        }
        ((StoryFavoritePanel)localObject1).fCB = paramBoolean;
        ((StoryFavoritePanel)localObject1).LTx.clear();
        if ((paramBoolean) && (((StoryFavoritePanel)localObject1).fromScene != StoryFavoritePanel.LTF)) {
          ((StoryFavoritePanel)localObject1).LTx.add(new StoryFavoritePanel.c(new j(), ((StoryFavoritePanel)localObject1).LTp));
        }
        paramList = ((Iterable)paramList).iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject2 = (j)paramList.next();
            ((StoryFavoritePanel)localObject1).LTx.add(new StoryFavoritePanel.c((j)localObject2, ((StoryFavoritePanel)localObject1).LTq));
            continue;
            i = 0;
            break;
          }
        }
        ((StoryFavoritePanel)localObject1).LTx.add(new StoryFavoritePanel.c(new j(), ((StoryFavoritePanel)localObject1).HLQ));
        ((StoryFavoritePanel)localObject1).LTv.notifyDataSetChanged();
        AppMethodBeat.o(119855);
        return;
      }
      AppMethodBeat.o(119855);
      return;
    }
    this.LTh.clear();
    paramList = this.mrN;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    paramList = this.LTi;
    if (paramList != null)
    {
      localObject1 = getContext();
      p.j(localObject1, "context");
      localObject1 = ((AppCompatActivity)localObject1).getResources().getString(a.g.LDy);
      p.j(localObject1, "context.resources.getStr…album_favorite_empty_tip)");
      paramList.bdG((String)localObject1);
      AppMethodBeat.o(119855);
      return;
    }
    AppMethodBeat.o(119855);
  }
  
  public final void zo(boolean paramBoolean)
  {
    AppMethodBeat.i(119856);
    StoryFavoritePanel localStoryFavoritePanel = this.LTi;
    if (localStoryFavoritePanel != null)
    {
      localStoryFavoritePanel.zo(paramBoolean);
      AppMethodBeat.o(119856);
      return;
    }
    AppMethodBeat.o(119856);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "invoke"})
  static final class d
    extends q
    implements b<StoryFavoritePanel.c, x>
  {
    d(StoryFavAlbumUI paramStoryFavAlbumUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", "", "invoke"})
  static final class e
    extends q
    implements m<StoryFavoritePanel.c, Integer, x>
  {
    e(StoryFavAlbumUI paramStoryFavAlbumUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$4", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"})
  public static final class f
    extends e
  {
    public final void onLoadMore()
    {
      AppMethodBeat.i(119851);
      StoryFavAlbumUI.d(this.LTl).gbQ();
      AppMethodBeat.o(119851);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI
 * JD-Core Version:    0.7.0.1
 */