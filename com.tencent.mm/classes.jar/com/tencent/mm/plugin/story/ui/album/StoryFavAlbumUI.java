package com.tencent.mm.plugin.story.ui.album;

import a.f.a.b;
import a.f.a.m;
import a.f.b.k;
import a.v;
import a.y;
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
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "()V", "curDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "isSelf", "", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "mUsername", "", "tipTv", "Landroid/widget/TextView;", "getLayoutId", "", "goFavGallery", "", "position", "dateList", "goFavSelector", "initActionBar", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "onLoadFavFinish", "datas", "", "isAllEmpty", "onResume", "Companion", "plugin-story_release"})
public final class StoryFavAlbumUI
  extends MMActivity
  implements a.b
{
  private static final String TAG = "MicroMsg.StoryFavAlbumUI";
  public static final StoryFavAlbumUI.a sJw;
  private boolean ctJ;
  private TextView gLI;
  private String ikj;
  private ArrayList<com.tencent.mm.plugin.story.h.j> sJt;
  private StoryFavoritePanel sJu;
  private a.a sJv;
  
  static
  {
    AppMethodBeat.i(138107);
    sJw = new StoryFavAlbumUI.a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumUI";
    AppMethodBeat.o(138107);
  }
  
  public StoryFavAlbumUI()
  {
    AppMethodBeat.i(138876);
    this.ikj = "";
    this.sJt = new ArrayList();
    this.ctJ = true;
    AppMethodBeat.o(138876);
  }
  
  public final int getLayoutId()
  {
    return 2130970914;
  }
  
  public final void h(List<com.tencent.mm.plugin.story.h.j> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(138874);
    a.f.b.j.q(paramList, "datas");
    int i;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    Object localObject1;
    while ((i != 0) || (!paramBoolean))
    {
      this.sJt.clear();
      this.sJt.addAll((Collection)paramList);
      localObject1 = this.sJu;
      if (localObject1 != null)
      {
        paramBoolean = this.ctJ;
        a.f.b.j.q(paramList, "favoriteStory");
        ab.i(((StoryFavoritePanel)localObject1).TAG, "updateFavStory " + paramList.size());
        Object localObject2 = ((StoryFavoritePanel)localObject1).sJF;
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        localObject2 = ((StoryFavoritePanel)localObject1).sJG;
        if (localObject2 != null) {
          ((RecyclerView)localObject2).setVisibility(0);
        }
        ((StoryFavoritePanel)localObject1).ctJ = paramBoolean;
        ((StoryFavoritePanel)localObject1).sJK.clear();
        if ((paramBoolean) && (((StoryFavoritePanel)localObject1).fromScene != StoryFavoritePanel.sJR)) {
          ((StoryFavoritePanel)localObject1).sJK.add(new StoryFavoritePanel.c(new com.tencent.mm.plugin.story.h.j(), ((StoryFavoritePanel)localObject1).sJB));
        }
        paramList = ((Iterable)paramList).iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.story.h.j)paramList.next();
            ((StoryFavoritePanel)localObject1).sJK.add(new StoryFavoritePanel.c((com.tencent.mm.plugin.story.h.j)localObject2, ((StoryFavoritePanel)localObject1).sJC));
            continue;
            i = 0;
            break;
          }
        }
        ((StoryFavoritePanel)localObject1).sJK.add(new StoryFavoritePanel.c(new com.tencent.mm.plugin.story.h.j(), ((StoryFavoritePanel)localObject1).swy));
        ((StoryFavoritePanel)localObject1).sJH.notifyDataSetChanged();
        AppMethodBeat.o(138874);
        return;
      }
      AppMethodBeat.o(138874);
      return;
    }
    this.sJt.clear();
    paramList = this.gLI;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    paramList = this.sJu;
    if (paramList != null)
    {
      localObject1 = getContext();
      a.f.b.j.p(localObject1, "context");
      localObject1 = ((AppCompatActivity)localObject1).getResources().getString(2131304108);
      a.f.b.j.p(localObject1, "context.resources.getStr…album_favorite_empty_tip)");
      paramList.adI((String)localObject1);
      AppMethodBeat.o(138874);
      return;
    }
    AppMethodBeat.o(138874);
  }
  
  public final void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(151130);
    StoryFavoritePanel localStoryFavoritePanel = this.sJu;
    if (localStoryFavoritePanel != null)
    {
      localStoryFavoritePanel.lu(paramBoolean);
      AppMethodBeat.o(151130);
      return;
    }
    AppMethodBeat.o(151130);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(138871);
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
    this.ikj = paramBundle;
    ab.i(TAG, "initViews username=" + this.ikj);
    paramBundle = g.RL().Ru().get(2);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(138871);
      throw paramBundle;
    }
    this.ctJ = bo.isEqual((String)paramBundle, this.ikj);
    if (this.ctJ)
    {
      setMMTitle(2131304109);
      setBackBtn((MenuItem.OnMenuItemClickListener)new StoryFavAlbumUI.b(this));
      this.sJv = ((a.a)new com.tencent.mm.plugin.story.f.l((a.b)this));
      paramBundle = this.sJv;
      if (paramBundle == null) {
        a.f.b.j.ays("mPresenter");
      }
      paramBundle.onCreate(this.ikj);
      this.gLI = ((TextView)findViewById(2131828230));
      if (this.ctJ) {
        break label508;
      }
      paramBundle = this.gLI;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    for (;;)
    {
      this.sJu = ((StoryFavoritePanel)findViewById(2131828231));
      paramBundle = this.sJu;
      if (paramBundle != null)
      {
        localObject = StoryFavoritePanel.sJS;
        paramBundle.setup(StoryFavoritePanel.cFr());
      }
      paramBundle = this.sJu;
      if (paramBundle != null) {
        paramBundle.setMOnAddItemClickListener((b)new d(this));
      }
      paramBundle = this.sJu;
      if (paramBundle != null) {
        paramBundle.setMOnFavItemClickListener((m)new StoryFavAlbumUI.e(this));
      }
      paramBundle = this.sJu;
      if (paramBundle != null) {
        paramBundle.a((RecyclerView.m)new StoryFavAlbumUI.f(this));
      }
      paramBundle = this.sJv;
      if (paramBundle == null) {
        a.f.b.j.ays("mPresenter");
      }
      paramBundle.czI();
      paramBundle = this.sJv;
      if (paramBundle == null) {
        a.f.b.j.ays("mPresenter");
      }
      paramBundle.czJ();
      AppMethodBeat.o(138871);
      return;
      paramBundle = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
      paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramBundle).YA().arw(this.ikj);
      localObject = (Context)getContext();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.Of();
        if (paramBundle == null) {}
      }
      for (paramBundle = (CharSequence)paramBundle;; paramBundle = (CharSequence)"")
      {
        View localView = findViewById(16908308);
        a.f.b.j.p(localView, "findViewById<TextView>(android.R.id.text1)");
        paramBundle = com.tencent.mm.pluginsdk.ui.d.j.b((Context)localObject, paramBundle, ((TextView)localView).getTextSize());
        setMMTitle(paramBundle + getString(2131304110));
        break;
      }
      label508:
      paramBundle = this.gLI;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.gLI;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)Html.fromHtml(getResources().getString(2131304103)));
      }
      paramBundle = this.gLI;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(138873);
    super.onDestroy();
    a.a locala = this.sJv;
    if (locala == null) {
      a.f.b.j.ays("mPresenter");
    }
    locala.bOo();
    AppMethodBeat.o(138873);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(138872);
    super.onResume();
    a.a locala = this.sJv;
    if (locala == null) {
      a.f.b.j.ays("mPresenter");
    }
    locala.czJ();
    AppMethodBeat.o(138872);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(StoryFavAlbumUI paramStoryFavAlbumUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138867);
      paramView = new Intent();
      paramView.putExtra("Contact_User", StoryFavAlbumUI.a(this.sJx));
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
      d.b((Context)this.sJx, "profile", ".ui.ContactInfoUI", paramView);
      AppMethodBeat.o(138867);
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "invoke"})
  static final class d
    extends k
    implements b<StoryFavoritePanel.c, y>
  {
    d(StoryFavAlbumUI paramStoryFavAlbumUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI
 * JD-Core Version:    0.7.0.1
 */