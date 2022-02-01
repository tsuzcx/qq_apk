package com.tencent.mm.plugin.story.ui.album;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "()V", "curDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "favPanel", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "isSelf", "", "mPresenter", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "mUsername", "", "tipTv", "Landroid/widget/TextView;", "getLayoutId", "", "goFavGallery", "", "position", "dateList", "goFavSelector", "initActionBar", "initViews", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onIsAll", "isAll", "onLoadFavFinish", "datas", "", "isAllEmpty", "onResume", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryFavAlbumUI
  extends MMActivity
  implements a.b
{
  public static final StoryFavAlbumUI.a Svu;
  private static final String TAG;
  private ArrayList<j> Svv;
  private StoryFavoritePanel Svw;
  private a.a Svx;
  private boolean hHq;
  private TextView pls;
  private String sWX;
  
  static
  {
    AppMethodBeat.i(119858);
    Svu = new StoryFavAlbumUI.a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumUI";
    AppMethodBeat.o(119858);
  }
  
  public StoryFavAlbumUI()
  {
    AppMethodBeat.i(119857);
    this.sWX = "";
    this.Svv = new ArrayList();
    this.hHq = true;
    AppMethodBeat.o(119857);
  }
  
  private static final void a(StoryFavAlbumUI paramStoryFavAlbumUI, View paramView)
  {
    AppMethodBeat.i(367311);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramStoryFavAlbumUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryFavAlbumUI, "this$0");
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramStoryFavAlbumUI.sWX);
    paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
    c.b((Context)paramStoryFavAlbumUI, "profile", ".ui.ContactInfoUI", paramView);
    a.a(new Object(), "com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367311);
  }
  
  private static final boolean a(StoryFavAlbumUI paramStoryFavAlbumUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(367313);
    s.u(paramStoryFavAlbumUI, "this$0");
    paramStoryFavAlbumUI.finish();
    AppMethodBeat.o(367313);
    return true;
  }
  
  public final void E(List<j> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(119855);
    s.u(paramList, "datas");
    int i;
    if (!((Collection)paramList).isEmpty()) {
      i = 1;
    }
    Object localObject1;
    while ((i != 0) || (!paramBoolean))
    {
      this.Svv.clear();
      this.Svv.addAll((Collection)paramList);
      localObject1 = this.Svw;
      if (localObject1 == null) {
        break label361;
      }
      paramBoolean = this.hHq;
      s.u(paramList, "favoriteStory");
      Log.i(((StoryFavoritePanel)localObject1).TAG, s.X("updateFavStory ", Integer.valueOf(paramList.size())));
      Object localObject2 = ((StoryFavoritePanel)localObject1).SvH;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      localObject2 = ((StoryFavoritePanel)localObject1).SvI;
      if (localObject2 != null) {
        ((RecyclerView)localObject2).setVisibility(0);
      }
      ((StoryFavoritePanel)localObject1).hHq = paramBoolean;
      ((StoryFavoritePanel)localObject1).SvL.clear();
      if ((paramBoolean) && (((StoryFavoritePanel)localObject1).fromScene != StoryFavoritePanel.SvS)) {
        ((StoryFavoritePanel)localObject1).SvL.add(new StoryFavoritePanel.c(new j(), ((StoryFavoritePanel)localObject1).SvD));
      }
      paramList = ((Iterable)paramList).iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localObject2 = (j)paramList.next();
          ((StoryFavoritePanel)localObject1).getMDatas().add(new StoryFavoritePanel.c((j)localObject2, ((StoryFavoritePanel)localObject1).SvE));
          continue;
          i = 0;
          break;
        }
      }
      ((StoryFavoritePanel)localObject1).SvL.add(new StoryFavoritePanel.c(new j(), ((StoryFavoritePanel)localObject1).NIQ));
      ((StoryFavoritePanel)localObject1).SvJ.bZE.notifyChanged();
      AppMethodBeat.o(119855);
      return;
    }
    this.Svv.clear();
    paramList = this.pls;
    if (paramList != null) {
      paramList.setVisibility(8);
    }
    paramList = this.Svw;
    if (paramList != null)
    {
      localObject1 = getContext().getResources().getString(a.g.Shj);
      s.s(localObject1, "context.resources.getStr…album_favorite_empty_tip)");
      paramList.bcs((String)localObject1);
    }
    label361:
    AppMethodBeat.o(119855);
  }
  
  public final void EF(boolean paramBoolean)
  {
    AppMethodBeat.i(119856);
    StoryFavoritePanel localStoryFavoritePanel = this.Svw;
    if (localStoryFavoritePanel != null) {
      localStoryFavoritePanel.EF(paramBoolean);
    }
    AppMethodBeat.o(119856);
  }
  
  public final int getLayoutId()
  {
    return a.e.Sgi;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(119852);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null) {
      paramBundle = "";
    }
    Object localObject2;
    for (;;)
    {
      this.sWX = paramBundle;
      Log.i(TAG, s.X("initViews username=", this.sWX));
      paramBundle = h.baE().ban().d(2, null);
      if (paramBundle != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(119852);
      throw paramBundle;
      localObject2 = paramBundle.getStringExtra("username");
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null) {
        paramBundle = "";
      }
    }
    this.hHq = Util.isEqual((String)paramBundle, this.sWX);
    if (this.hHq)
    {
      setMMTitle(a.g.Shk);
      setBackBtn(new StoryFavAlbumUI..ExternalSyntheticLambda0(this));
      this.Svx = ((a.a)new k((a.b)this));
      localObject2 = this.Svx;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("mPresenter");
        paramBundle = null;
      }
      paramBundle.onCreate(this.sWX);
      this.pls = ((TextView)findViewById(a.d.Sde));
      if (this.hHq) {
        break label501;
      }
      paramBundle = this.pls;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      label229:
      this.Svw = ((StoryFavoritePanel)findViewById(a.d.Sdg));
      paramBundle = this.Svw;
      if (paramBundle != null)
      {
        localObject2 = StoryFavoritePanel.SvC;
        paramBundle.setup(StoryFavoritePanel.hzK());
      }
      paramBundle = this.Svw;
      if (paramBundle != null) {
        paramBundle.setMOnAddItemClickListener((kotlin.g.a.b)new StoryFavAlbumUI.b(this));
      }
      paramBundle = this.Svw;
      if (paramBundle != null) {
        paramBundle.setMOnFavItemClickListener((m)new c(this));
      }
      paramBundle = this.Svw;
      if (paramBundle != null) {
        paramBundle.a((RecyclerView.l)new d(this));
      }
      localObject2 = this.Svx;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        s.bIx("mPresenter");
        paramBundle = null;
      }
      paramBundle.hvi();
      paramBundle = this.Svx;
      if (paramBundle != null) {
        break label568;
      }
      s.bIx("mPresenter");
      paramBundle = localObject1;
    }
    label568:
    for (;;)
    {
      paramBundle.hvj();
      AppMethodBeat.o(119852);
      return;
      paramBundle = ((n)h.ax(n.class)).bzA().JE(this.sWX);
      Context localContext = (Context)getContext();
      if (paramBundle == null) {
        paramBundle = "";
      }
      for (;;)
      {
        paramBundle = p.b(localContext, (CharSequence)paramBundle, ((TextView)findViewById(16908308)).getTextSize());
        setMMTitle(paramBundle + getString(a.g.Shl));
        break;
        localObject2 = paramBundle.aSV();
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null) {
          paramBundle = "";
        }
      }
      label501:
      paramBundle = this.pls;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.pls;
      if (paramBundle != null) {
        paramBundle.setText((CharSequence)Html.fromHtml(getResources().getString(a.g.Shi)));
      }
      paramBundle = this.pls;
      if (paramBundle == null) {
        break label229;
      }
      paramBundle.setOnClickListener(new StoryFavAlbumUI..ExternalSyntheticLambda1(this));
      break label229;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119854);
    super.onDestroy();
    a.a locala2 = this.Svx;
    a.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("mPresenter");
      locala1 = null;
    }
    locala1.hoB();
    AppMethodBeat.o(119854);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119853);
    super.onResume();
    a.a locala2 = this.Svx;
    a.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("mPresenter");
      locala1 = null;
    }
    locala1.hvj();
    AppMethodBeat.o(119853);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "storyFavInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "position", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<StoryFavoritePanel.c, Integer, ah>
  {
    c(StoryFavAlbumUI paramStoryFavAlbumUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/album/StoryFavAlbumUI$initViews$4", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "onLoadMore", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends e
  {
    d(StoryFavAlbumUI paramStoryFavAlbumUI) {}
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(119851);
      a.a locala2 = StoryFavAlbumUI.c(this.Svy);
      a.a locala1 = locala2;
      if (locala2 == null)
      {
        s.bIx("mPresenter");
        locala1 = null;
      }
      locala1.hvh();
      AppMethodBeat.o(119851);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI
 * JD-Core Version:    0.7.0.1
 */