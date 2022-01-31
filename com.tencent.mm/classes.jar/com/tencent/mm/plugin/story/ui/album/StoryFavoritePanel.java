package com.tencent.mm.plugin.story.ui.album;

import a.f.a.m;
import a.f.a.q;
import a.l;
import a.y;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "VIEW_TYPE_ADD_FAV", "VIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL_FAV", "VIEW_TYPE_SELECT_FAV", "checkedFavTime", "getCheckedFavTime", "()I", "setCheckedFavTime", "(I)V", "dp", "", "fromScene", "getFromScene", "setFromScene", "isSelf", "", "()Z", "setSelf", "(Z)V", "mCheckedDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "getMCheckedDatas", "()Ljava/util/ArrayList;", "mDatas", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "getMDatas", "mEmptyTipTv", "Landroid/widget/TextView;", "mFavAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter;", "mFavRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mFavTitleTv", "mIsAll", "getMIsAll", "setMIsAll", "mOnAddItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "storyFavInfo", "", "getMOnAddItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnAddItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mOnCheckItemListener", "Lkotlin/Function3;", "position", "checked", "getMOnCheckItemListener", "()Lkotlin/jvm/functions/Function3;", "setMOnCheckItemListener", "(Lkotlin/jvm/functions/Function3;)V", "mOnFavItemClickListener", "Lkotlin/Function2;", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "spanCount", "addOnScrollListener", "listener", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "init", "onIsAll", "isAll", "setup", "showEmptyTip", "tip", "showTopTip", "show", "updateCheckedStatus", "storyId", "", "isChecked", "updateFavStory", "favoriteStory", "", "updateSelectFavStory", "checkableStory", "checkedStory", "Companion", "StoryAlbumLoadingHolder", "StoryFavInfo", "StoryFavSelectHolder", "StoryFavoriteAdapter", "StoryFavoriteAddHolder", "StoryFavoriteNormalHolder", "plugin-story_release"})
public final class StoryFavoritePanel
  extends RelativeLayout
{
  private static final int sJQ = 0;
  static final int sJR = 1;
  public static final a sJS;
  final String TAG;
  boolean ctJ;
  int fromScene;
  final int sJB;
  final int sJC;
  private final int sJD;
  TextView sJE;
  TextView sJF;
  RecyclerView sJG;
  StoryFavoritePanel.e sJH;
  private final float sJI;
  private final int sJJ;
  final ArrayList<StoryFavoritePanel.c> sJK;
  final ArrayList<com.tencent.mm.plugin.story.h.j> sJL;
  private int sJM;
  private q<? super StoryFavoritePanel.c, ? super Integer, ? super Boolean, y> sJN;
  private m<? super StoryFavoritePanel.c, ? super Integer, y> sJO;
  private a.f.a.b<? super StoryFavoritePanel.c, y> sJP;
  private boolean sek;
  final int swy;
  
  static
  {
    AppMethodBeat.i(138889);
    sJS = new a((byte)0);
    sJR = 1;
    AppMethodBeat.o(138889);
  }
  
  public StoryFavoritePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(110207);
    this.TAG = "MicroMsg.StoryFavoritePanel";
    this.sJC = 1;
    this.swy = 2;
    this.sJD = 3;
    this.sJH = new StoryFavoritePanel.e(this);
    this.sJI = (a.getDensity(getContext()) * 1.0F);
    this.sJJ = 4;
    this.sJK = new ArrayList();
    this.sJL = new ArrayList();
    this.fromScene = sJQ;
    init();
    AppMethodBeat.o(110207);
  }
  
  public StoryFavoritePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110208);
    this.TAG = "MicroMsg.StoryFavoritePanel";
    this.sJC = 1;
    this.swy = 2;
    this.sJD = 3;
    this.sJH = new StoryFavoritePanel.e(this);
    this.sJI = (a.getDensity(getContext()) * 1.0F);
    this.sJJ = 4;
    this.sJK = new ArrayList();
    this.sJL = new ArrayList();
    this.fromScene = sJQ;
    init();
    AppMethodBeat.o(110208);
  }
  
  private final void init()
  {
    AppMethodBeat.i(110206);
    View.inflate(getContext(), 2130970918, (ViewGroup)this);
    this.sJE = ((TextView)findViewById(2131828237));
    this.sJF = ((TextView)findViewById(2131828238));
    this.sJG = ((RecyclerView)findViewById(2131828239));
    getContext();
    Object localObject = new GridLayoutManager(this.sJJ);
    ((GridLayoutManager)localObject).a((GridLayoutManager.b)new StoryFavoritePanel.h(this));
    RecyclerView localRecyclerView = this.sJG;
    if (localRecyclerView != null) {
      localRecyclerView.setLayoutManager((RecyclerView.i)localObject);
    }
    localObject = this.sJG;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.sJH);
    }
    localObject = this.sJG;
    if (localObject != null) {
      ((RecyclerView)localObject).b((RecyclerView.h)new b());
    }
    localObject = this.sJG;
    if (localObject != null)
    {
      ((RecyclerView)localObject).setItemAnimator(null);
      AppMethodBeat.o(110206);
      return;
    }
    AppMethodBeat.o(110206);
  }
  
  public final void a(RecyclerView.m paramm)
  {
    AppMethodBeat.i(138887);
    a.f.b.j.q(paramm, "listener");
    RecyclerView localRecyclerView = this.sJG;
    if (localRecyclerView != null)
    {
      localRecyclerView.a(paramm);
      AppMethodBeat.o(138887);
      return;
    }
    AppMethodBeat.o(138887);
  }
  
  public final void adI(String paramString)
  {
    AppMethodBeat.i(138886);
    a.f.b.j.q(paramString, "tip");
    Object localObject = this.sJF;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.sJE;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.sJG;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(8);
    }
    localObject = this.sJF;
    if (localObject != null)
    {
      ((TextView)localObject).setText((CharSequence)paramString);
      AppMethodBeat.o(138886);
      return;
    }
    AppMethodBeat.o(138886);
  }
  
  public final int getCheckedFavTime()
  {
    return this.sJM;
  }
  
  public final int getFromScene()
  {
    return this.fromScene;
  }
  
  public final ArrayList<com.tencent.mm.plugin.story.h.j> getMCheckedDatas()
  {
    return this.sJL;
  }
  
  public final ArrayList<StoryFavoritePanel.c> getMDatas()
  {
    return this.sJK;
  }
  
  public final boolean getMIsAll()
  {
    return this.sek;
  }
  
  public final a.f.a.b<StoryFavoritePanel.c, y> getMOnAddItemClickListener()
  {
    return this.sJP;
  }
  
  public final q<StoryFavoritePanel.c, Integer, Boolean, y> getMOnCheckItemListener()
  {
    return this.sJN;
  }
  
  public final m<StoryFavoritePanel.c, Integer, y> getMOnFavItemClickListener()
  {
    return this.sJO;
  }
  
  public final void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(151151);
    this.sek = paramBoolean;
    if (!((Collection)this.sJK).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.sJH.bR(this.sJH.getItemCount() - 1);
      }
      AppMethodBeat.o(151151);
      return;
    }
  }
  
  public final void p(List<com.tencent.mm.plugin.story.h.j> paramList1, List<com.tencent.mm.plugin.story.h.j> paramList2)
  {
    AppMethodBeat.i(151150);
    a.f.b.j.q(paramList1, "checkableStory");
    a.f.b.j.q(paramList2, "checkedStory");
    ab.i(this.TAG, "updateFavStory " + paramList1.size() + ' ' + paramList2.size());
    Object localObject = this.sJF;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.sJG;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(0);
    }
    this.sJK.clear();
    paramList1 = ((Iterable)paramList1).iterator();
    while (paramList1.hasNext())
    {
      localObject = (com.tencent.mm.plugin.story.h.j)paramList1.next();
      this.sJK.add(new StoryFavoritePanel.c((com.tencent.mm.plugin.story.h.j)localObject, this.sJD));
    }
    this.sJK.add(new StoryFavoritePanel.c(new com.tencent.mm.plugin.story.h.j(), this.swy));
    paramList1 = ((Iterable)paramList2).iterator();
    while (paramList1.hasNext())
    {
      localObject = (com.tencent.mm.plugin.story.h.j)paramList1.next();
      if ((this.sJM == 0) || (((com.tencent.mm.plugin.story.h.j)localObject).field_createTime < this.sJM))
      {
        ab.d(this.TAG, "add to CheckedList: " + ((com.tencent.mm.plugin.story.h.j)localObject).field_storyID);
        this.sJL.add(localObject);
      }
    }
    paramList1 = (com.tencent.mm.plugin.story.h.j)a.a.j.fT(paramList2);
    if (paramList1 != null) {}
    for (int i = paramList1.field_createTime;; i = 0)
    {
      this.sJM = i;
      this.sJH.notifyDataSetChanged();
      AppMethodBeat.o(151150);
      return;
    }
  }
  
  public final void setCheckedFavTime(int paramInt)
  {
    this.sJM = paramInt;
  }
  
  public final void setFromScene(int paramInt)
  {
    this.fromScene = paramInt;
  }
  
  public final void setMIsAll(boolean paramBoolean)
  {
    this.sek = paramBoolean;
  }
  
  public final void setMOnAddItemClickListener(a.f.a.b<? super StoryFavoritePanel.c, y> paramb)
  {
    this.sJP = paramb;
  }
  
  public final void setMOnCheckItemListener(q<? super StoryFavoritePanel.c, ? super Integer, ? super Boolean, y> paramq)
  {
    this.sJN = paramq;
  }
  
  public final void setMOnFavItemClickListener(m<? super StoryFavoritePanel.c, ? super Integer, y> paramm)
  {
    this.sJO = paramm;
  }
  
  public final void setSelf(boolean paramBoolean)
  {
    this.ctJ = paramBoolean;
  }
  
  public final void setup(int paramInt)
  {
    this.fromScene = paramInt;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$Companion;", "", "()V", "FAV_ALBUM_UI", "", "getFAV_ALBUM_UI", "()I", "FAV_SELECT_UI", "getFAV_SELECT_UI", "plugin-story_release"})
  public static final class a {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e$e
    implements View.OnClickListener
  {
    e$e(StoryFavoritePanel.e parame, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(151148);
      paramView = this.sJV.sJT.getMOnFavItemClickListener();
      if (paramView != null)
      {
        Object localObject = this.sJV.sJT.getMDatas().get(this.euX);
        a.f.b.j.p(localObject, "mDatas[position]");
        paramView.h(localObject, Integer.valueOf(this.euX));
        AppMethodBeat.o(151148);
        return;
      }
      AppMethodBeat.o(151148);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel
 * JD-Core Version:    0.7.0.1
 */