package com.tencent.mm.plugin.story.ui.album;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.h.a.c;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "VIEW_TYPE_ADD_FAV", "VIEW_TYPE_LOADING", "VIEW_TYPE_NORMAL_FAV", "VIEW_TYPE_SELECT_FAV", "checkedFavTime", "getCheckedFavTime", "()I", "setCheckedFavTime", "(I)V", "dp", "", "fromScene", "getFromScene", "setFromScene", "isSelf", "", "()Z", "setSelf", "(Z)V", "mCheckedDatas", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "getMCheckedDatas", "()Ljava/util/ArrayList;", "mDatas", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavInfo;", "getMDatas", "mEmptyTipTv", "Landroid/widget/TextView;", "mFavAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter;", "mFavRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mFavTitleTv", "mIsAll", "getMIsAll", "setMIsAll", "mOnAddItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "storyFavInfo", "", "getMOnAddItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnAddItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mOnCheckItemListener", "Lkotlin/Function3;", "position", "checked", "getMOnCheckItemListener", "()Lkotlin/jvm/functions/Function3;", "setMOnCheckItemListener", "(Lkotlin/jvm/functions/Function3;)V", "mOnFavItemClickListener", "Lkotlin/Function2;", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "spanCount", "addOnScrollListener", "listener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "init", "onIsAll", "isAll", "setup", "showEmptyTip", "tip", "showTopTip", "show", "updateCheckedStatus", "storyId", "", "isChecked", "updateFavStory", "favoriteStory", "", "updateSelectFavStory", "checkableStory", "checkedStory", "Companion", "StoryAlbumLoadingHolder", "StoryFavInfo", "StoryFavSelectHolder", "StoryFavoriteAdapter", "StoryFavoriteAddHolder", "StoryFavoriteNormalHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryFavoritePanel
  extends RelativeLayout
{
  public static final StoryFavoritePanel.a SvC;
  private static final int SvR = 0;
  static final int SvS;
  final int NIQ;
  final int SvD;
  final int SvE;
  private final int SvF;
  TextView SvG;
  TextView SvH;
  RecyclerView SvI;
  e SvJ;
  private final float SvK;
  final ArrayList<StoryFavoritePanel.c> SvL;
  private final ArrayList<j> SvM;
  private int SvN;
  private q<? super StoryFavoritePanel.c, ? super Integer, ? super Boolean, ah> SvO;
  private m<? super StoryFavoritePanel.c, ? super Integer, ah> SvP;
  private kotlin.g.a.b<? super StoryFavoritePanel.c, ah> SvQ;
  final String TAG;
  int fromScene;
  boolean hHq;
  private final int spanCount;
  private boolean wHe;
  
  static
  {
    AppMethodBeat.i(119905);
    SvC = new StoryFavoritePanel.a((byte)0);
    SvS = 1;
    AppMethodBeat.o(119905);
  }
  
  public StoryFavoritePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(119903);
    this.TAG = "MicroMsg.StoryFavoritePanel";
    this.SvE = 1;
    this.NIQ = 2;
    this.SvF = 3;
    this.SvJ = new e();
    this.SvK = (com.tencent.mm.cd.a.getDensity(getContext()) * 1.0F);
    this.spanCount = 4;
    this.SvL = new ArrayList();
    this.SvM = new ArrayList();
    this.fromScene = SvR;
    init();
    AppMethodBeat.o(119903);
  }
  
  public StoryFavoritePanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(119904);
    this.TAG = "MicroMsg.StoryFavoritePanel";
    this.SvE = 1;
    this.NIQ = 2;
    this.SvF = 3;
    this.SvJ = new e();
    this.SvK = (com.tencent.mm.cd.a.getDensity(getContext()) * 1.0F);
    this.spanCount = 4;
    this.SvL = new ArrayList();
    this.SvM = new ArrayList();
    this.fromScene = SvR;
    init();
    AppMethodBeat.o(119904);
  }
  
  private final void init()
  {
    AppMethodBeat.i(119898);
    View.inflate(getContext(), a.e.Sgl, (ViewGroup)this);
    this.SvG = ((TextView)findViewById(a.d.Seb));
    this.SvH = ((TextView)findViewById(a.d.SdS));
    this.SvI = ((RecyclerView)findViewById(a.d.SdW));
    getContext();
    Object localObject = new GridLayoutManager(this.spanCount);
    ((GridLayoutManager)localObject).bWq = ((GridLayoutManager.b)new h(this));
    RecyclerView localRecyclerView = this.SvI;
    if (localRecyclerView != null) {
      localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    }
    localObject = this.SvI;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.SvJ);
    }
    localObject = this.SvI;
    if (localObject != null) {
      ((RecyclerView)localObject).a((RecyclerView.h)new b());
    }
    localObject = this.SvI;
    if (localObject != null) {
      ((RecyclerView)localObject).setItemAnimator(null);
    }
    AppMethodBeat.o(119898);
  }
  
  public final void EF(boolean paramBoolean)
  {
    AppMethodBeat.i(119902);
    this.wHe = paramBoolean;
    if (!((Collection)this.SvL).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.SvJ.fV(this.SvJ.getItemCount() - 1);
      }
      AppMethodBeat.o(119902);
      return;
    }
  }
  
  public final void N(List<j> paramList1, List<j> paramList2)
  {
    AppMethodBeat.i(119899);
    s.u(paramList1, "checkableStory");
    s.u(paramList2, "checkedStory");
    Log.i(this.TAG, "updateFavStory " + paramList1.size() + ' ' + paramList2.size());
    Object localObject = this.SvH;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.SvI;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(0);
    }
    this.SvL.clear();
    paramList1 = ((Iterable)paramList1).iterator();
    while (paramList1.hasNext())
    {
      localObject = (j)paramList1.next();
      getMDatas().add(new StoryFavoritePanel.c((j)localObject, this.SvF));
    }
    this.SvL.add(new StoryFavoritePanel.c(new j(), this.NIQ));
    paramList1 = ((Iterable)paramList2).iterator();
    while (paramList1.hasNext())
    {
      localObject = (j)paramList1.next();
      if ((getCheckedFavTime() == 0) || (((j)localObject).field_createTime < getCheckedFavTime()))
      {
        Log.d(this.TAG, s.X("add to CheckedList: ", Long.valueOf(((j)localObject).field_storyID)));
        getMCheckedDatas().add(localObject);
      }
    }
    paramList1 = (j)p.oN(paramList2);
    if (paramList1 == null) {}
    for (int i = 0;; i = paramList1.field_createTime)
    {
      this.SvN = i;
      this.SvJ.bZE.notifyChanged();
      AppMethodBeat.o(119899);
      return;
    }
  }
  
  public final void a(RecyclerView.l paraml)
  {
    AppMethodBeat.i(367393);
    s.u(paraml, "listener");
    RecyclerView localRecyclerView = this.SvI;
    if (localRecyclerView != null) {
      localRecyclerView.a(paraml);
    }
    AppMethodBeat.o(367393);
  }
  
  public final void bcs(String paramString)
  {
    AppMethodBeat.i(119900);
    s.u(paramString, "tip");
    Object localObject = this.SvH;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.SvG;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.SvI;
    if (localObject != null) {
      ((RecyclerView)localObject).setVisibility(8);
    }
    localObject = this.SvH;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramString);
    }
    AppMethodBeat.o(119900);
  }
  
  public final int getCheckedFavTime()
  {
    return this.SvN;
  }
  
  public final int getFromScene()
  {
    return this.fromScene;
  }
  
  public final ArrayList<j> getMCheckedDatas()
  {
    return this.SvM;
  }
  
  public final ArrayList<StoryFavoritePanel.c> getMDatas()
  {
    return this.SvL;
  }
  
  public final boolean getMIsAll()
  {
    return this.wHe;
  }
  
  public final kotlin.g.a.b<StoryFavoritePanel.c, ah> getMOnAddItemClickListener()
  {
    return this.SvQ;
  }
  
  public final q<StoryFavoritePanel.c, Integer, Boolean, ah> getMOnCheckItemListener()
  {
    return this.SvO;
  }
  
  public final m<StoryFavoritePanel.c, Integer, ah> getMOnFavItemClickListener()
  {
    return this.SvP;
  }
  
  public final void setCheckedFavTime(int paramInt)
  {
    this.SvN = paramInt;
  }
  
  public final void setFromScene(int paramInt)
  {
    this.fromScene = paramInt;
  }
  
  public final void setMIsAll(boolean paramBoolean)
  {
    this.wHe = paramBoolean;
  }
  
  public final void setMOnAddItemClickListener(kotlin.g.a.b<? super StoryFavoritePanel.c, ah> paramb)
  {
    this.SvQ = paramb;
  }
  
  public final void setMOnCheckItemListener(q<? super StoryFavoritePanel.c, ? super Integer, ? super Boolean, ah> paramq)
  {
    this.SvO = paramq;
  }
  
  public final void setMOnFavItemClickListener(m<? super StoryFavoritePanel.c, ? super Integer, ah> paramm)
  {
    this.SvP = paramm;
  }
  
  public final void setSelf(boolean paramBoolean)
  {
    this.hHq = paramBoolean;
  }
  
  public final void setup(int paramInt)
  {
    this.fromScene = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavSelectHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;Landroid/view/View;)V", "checkIcon", "Landroid/widget/CheckBox;", "getCheckIcon", "()Landroid/widget/CheckBox;", "setCheckIcon", "(Landroid/widget/CheckBox;)V", "clickArea", "getClickArea", "()Landroid/view/View;", "setClickArea", "(Landroid/view/View;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "mask", "getMask", "setMask", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends RecyclerView.v
  {
    ImageView AnL;
    CheckBox SvU;
    ImageView Svh;
    View clickArea;
    
    public d()
    {
      super();
      AppMethodBeat.i(119883);
      this$1 = this.caK.findViewById(a.d.SdZ);
      s.s(StoryFavoritePanel.this, "itemView.findViewById(R.…album_fav_select_item_iv)");
      this.Svh = ((ImageView)StoryFavoritePanel.this);
      this$1 = this.caK.findViewById(a.d.SdY);
      s.s(StoryFavoritePanel.this, "itemView.findViewById(R.…fav_select_item_check_iv)");
      this.SvU = ((CheckBox)StoryFavoritePanel.this);
      this$1 = this.caK.findViewById(a.d.Sea);
      s.s(StoryFavoritePanel.this, "itemView.findViewById(R.…_select_item_normal_mask)");
      this.AnL = ((ImageView)StoryFavoritePanel.this);
      this$1 = this.caK.findViewById(a.d.SdX);
      s.s(StoryFavoritePanel.this, "itemView.findViewById(R.…v_select_item_check_area)");
      this.clickArea = StoryFavoritePanel.this;
      AppMethodBeat.o(119883);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryFavoritePanel;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends RecyclerView.a<RecyclerView.v>
  {
    public e()
    {
      AppMethodBeat.i(367265);
      AppMethodBeat.o(367265);
    }
    
    private static final void a(RecyclerView.v paramv, View paramView)
    {
      AppMethodBeat.i(367280);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramv);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramv, "$holder");
      if (!((StoryFavoritePanel.d)paramv).SvU.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        ((StoryFavoritePanel.d)paramv).SvU.setChecked(bool);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(367280);
        return;
      }
    }
    
    private static final void a(StoryFavoritePanel paramStoryFavoritePanel, StoryFavoritePanel.c paramc, int paramInt, View paramView)
    {
      AppMethodBeat.i(367271);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramStoryFavoritePanel);
      localb.cH(paramc);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramStoryFavoritePanel, "this$0");
      s.u(paramc, "$dataInfo");
      paramStoryFavoritePanel = paramStoryFavoritePanel.getMOnFavItemClickListener();
      if (paramStoryFavoritePanel != null) {
        paramStoryFavoritePanel.invoke(paramc, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367271);
    }
    
    private static final void a(StoryFavoritePanel paramStoryFavoritePanel, StoryFavoritePanel.c paramc, View paramView)
    {
      AppMethodBeat.i(367269);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramStoryFavoritePanel);
      localb.cH(paramc);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramStoryFavoritePanel, "this$0");
      s.u(paramc, "$dataInfo");
      paramStoryFavoritePanel = paramStoryFavoritePanel.getMOnAddItemClickListener();
      if (paramStoryFavoritePanel != null) {
        paramStoryFavoritePanel.invoke(paramc);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367269);
    }
    
    private static final void a(StoryFavoritePanel paramStoryFavoritePanel, StoryFavoritePanel.c paramc, RecyclerView.v paramv, int paramInt, CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(367278);
      s.u(paramStoryFavoritePanel, "this$0");
      s.u(paramc, "$dataInfo");
      s.u(paramv, "$holder");
      Log.d(StoryFavoritePanel.f(paramStoryFavoritePanel), s.X("setOnCheckedChangeListener ", Boolean.valueOf(paramBoolean)));
      int i;
      if (paramBoolean)
      {
        i = paramStoryFavoritePanel.getMCheckedDatas().size();
        paramCompoundButton = a.c.Ssv;
        if (i < a.c.hyZ())
        {
          paramCompoundButton = (Iterable)paramStoryFavoritePanel.getMCheckedDatas();
          if ((!(paramCompoundButton instanceof Collection)) || (!((Collection)paramCompoundButton).isEmpty()))
          {
            paramCompoundButton = paramCompoundButton.iterator();
            if (paramCompoundButton.hasNext()) {
              if (((j)paramCompoundButton.next()).field_storyID == paramc.SnL.field_storyID)
              {
                i = 1;
                label143:
                if (i == 0) {
                  break label215;
                }
                i = 0;
                label151:
                if (i != 0)
                {
                  paramStoryFavoritePanel.getMCheckedDatas().add(paramc.SnL);
                  ((StoryFavoritePanel.d)paramv).AnL.setVisibility(0);
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        paramStoryFavoritePanel = paramStoryFavoritePanel.getMOnCheckItemListener();
        if (paramStoryFavoritePanel != null) {
          paramStoryFavoritePanel.invoke(paramc, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
        }
        AppMethodBeat.o(367278);
        return;
        i = 0;
        break label143;
        label215:
        break;
        i = 1;
        break label151;
        ((StoryFavoritePanel.d)paramv).SvU.setChecked(false);
        k.c(paramStoryFavoritePanel.getContext(), "", paramStoryFavoritePanel.getResources().getString(a.g.ShE), true);
        AppMethodBeat.o(367278);
        return;
        p.e((List)paramStoryFavoritePanel.getMCheckedDatas(), (kotlin.g.a.b)new StoryFavoritePanel.e.a(paramc));
        ((StoryFavoritePanel.d)paramv).AnL.setVisibility(8);
      }
    }
    
    private static final void b(StoryFavoritePanel paramStoryFavoritePanel, StoryFavoritePanel.c paramc, int paramInt, View paramView)
    {
      AppMethodBeat.i(367282);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramStoryFavoritePanel);
      localb.cH(paramc);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramStoryFavoritePanel, "this$0");
      s.u(paramc, "$dataInfo");
      paramStoryFavoritePanel = paramStoryFavoritePanel.getMOnFavItemClickListener();
      if (paramStoryFavoritePanel != null) {
        paramStoryFavoritePanel.invoke(paramc, Integer.valueOf(paramInt));
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$StoryFavoriteAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367282);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(367306);
      s.u(paramViewGroup, "parent");
      if (paramInt == StoryFavoritePanel.d(this.SvT))
      {
        paramViewGroup = af.mU(this.SvT.getContext()).inflate(a.e.Sgg, paramViewGroup, false);
        localStoryFavoritePanel = this.SvT;
        s.s(paramViewGroup, "itemView");
        paramViewGroup = (RecyclerView.v)new StoryFavoritePanel.f(localStoryFavoritePanel, paramViewGroup);
        AppMethodBeat.o(367306);
        return paramViewGroup;
      }
      if (paramInt == StoryFavoritePanel.b(this.SvT))
      {
        localStoryFavoritePanel = this.SvT;
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.e.Sgo, paramViewGroup, false);
        s.s(paramViewGroup, "from(parent.context).inf…ng_layout, parent, false)");
        paramViewGroup = (RecyclerView.v)new StoryFavoritePanel.b(localStoryFavoritePanel, paramViewGroup);
        AppMethodBeat.o(367306);
        return paramViewGroup;
      }
      if (paramInt == StoryFavoritePanel.e(this.SvT))
      {
        localStoryFavoritePanel = this.SvT;
        paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(a.e.Sgj, paramViewGroup, false);
        s.s(paramViewGroup, "from(parent.context).inf…lect_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new StoryFavoritePanel.d(localStoryFavoritePanel, paramViewGroup);
        AppMethodBeat.o(367306);
        return paramViewGroup;
      }
      paramViewGroup = af.mU(this.SvT.getContext()).inflate(a.e.Sgh, paramViewGroup, false);
      StoryFavoritePanel localStoryFavoritePanel = this.SvT;
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (RecyclerView.v)new StoryFavoritePanel.g(localStoryFavoritePanel, paramViewGroup);
      AppMethodBeat.o(367306);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(367312);
      s.u(paramv, "holder");
      Object localObject2 = (StoryFavoritePanel.c)p.ae((List)this.SvT.getMDatas(), paramInt);
      if (localObject2 != null)
      {
        Object localObject1 = this.SvT;
        if ((paramv instanceof StoryFavoritePanel.f))
        {
          ((StoryFavoritePanel.f)paramv).dpM.setImageDrawable(bb.m(((StoryFavoritePanel)localObject1).getContext(), a.f.icons_filled_star, ((StoryFavoritePanel)localObject1).getContext().getResources().getColor(a.a.ScP)));
          paramv.caK.setOnClickListener(new StoryFavoritePanel.e..ExternalSyntheticLambda1((StoryFavoritePanel)localObject1, (StoryFavoritePanel.c)localObject2));
          AppMethodBeat.o(367312);
          return;
        }
        Object localObject3;
        label188:
        Object localObject4;
        if ((paramv instanceof StoryFavoritePanel.g))
        {
          paramv.caK.setOnClickListener(new StoryFavoritePanel.e..ExternalSyntheticLambda3((StoryFavoritePanel)localObject1, (StoryFavoritePanel.c)localObject2, paramInt));
          localObject1 = ((StoryFavoritePanel.c)localObject2).SnL;
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 == null) {
              break label800;
            }
            localObject3 = ((fij)localObject1).Zpr;
            s.s(localObject3, "obj.MediaObjList");
            if (((Collection)localObject3).isEmpty()) {
              break label333;
            }
            paramInt = i;
            if (paramInt == 0) {
              break label800;
            }
            localObject3 = StoryCore.SjP;
            localObject3 = StoryCore.b.hvZ();
            localObject1 = ((fij)localObject1).Zpr.get(0);
            s.s(localObject1, "obj.MediaObjList[0]");
            localObject4 = (fis)localObject1;
            localObject1 = ((StoryFavoritePanel.c)localObject2).SnL;
            if (localObject1 != null) {
              break label338;
            }
          }
          label333:
          label338:
          for (localObject1 = null;; localObject1 = ((j)localObject1).field_userName)
          {
            localObject2 = br.adkh;
            s.s(localObject2, "storyalbum");
            localObject1 = new com.tencent.mm.plugin.story.model.c.d((fis)localObject4, (String)localObject1, (br)localObject2);
            paramv = ((StoryFavoritePanel.g)paramv).Svh;
            localObject2 = StoryCore.SjP;
            ((com.tencent.mm.loader.d)localObject3).a(localObject1, paramv, StoryCore.b.a(com.tencent.mm.plugin.story.model.c.a.SlU));
            AppMethodBeat.o(367312);
            return;
            localObject1 = ((j)localObject1).hzt();
            if (localObject1 == null)
            {
              localObject1 = null;
              break;
            }
            localObject1 = ((fjj)localObject1).abJZ;
            break;
            paramInt = 0;
            break label188;
          }
        }
        else if ((paramv instanceof StoryFavoritePanel.d))
        {
          localObject3 = (Iterable)((StoryFavoritePanel)localObject1).getMCheckedDatas();
          label432:
          boolean bool;
          if ((!(localObject3 instanceof Collection)) || (!((Collection)localObject3).isEmpty()))
          {
            localObject3 = ((Iterable)localObject3).iterator();
            if (((Iterator)localObject3).hasNext()) {
              if (((j)((Iterator)localObject3).next()).field_storyID == ((StoryFavoritePanel.c)localObject2).SnL.field_storyID)
              {
                i = 1;
                if (i == 0) {
                  break label704;
                }
                bool = true;
                label439:
                if (!bool) {
                  break label712;
                }
                ((StoryFavoritePanel.d)paramv).AnL.setVisibility(0);
                label455:
                ((StoryFavoritePanel.d)paramv).SvU.setOnCheckedChangeListener(null);
                ((StoryFavoritePanel.d)paramv).SvU.setChecked(bool);
                ((StoryFavoritePanel.d)paramv).SvU.setOnCheckedChangeListener(new StoryFavoritePanel.e..ExternalSyntheticLambda4((StoryFavoritePanel)localObject1, (StoryFavoritePanel.c)localObject2, paramv, paramInt));
                ((StoryFavoritePanel.d)paramv).clickArea.setOnClickListener(new StoryFavoritePanel.e..ExternalSyntheticLambda0(paramv));
                ((StoryFavoritePanel.d)paramv).Svh.setOnClickListener(new StoryFavoritePanel.e..ExternalSyntheticLambda2((StoryFavoritePanel)localObject1, (StoryFavoritePanel.c)localObject2, paramInt));
                localObject3 = ((StoryFavoritePanel.c)localObject2).SnL.hzt().abJZ;
                if (localObject3 == null) {
                  break label800;
                }
                localObject1 = ((fij)localObject3).Zpr;
                s.s(localObject1, "obj.MediaObjList");
                if (((Collection)localObject1).isEmpty()) {
                  break label727;
                }
              }
            }
          }
          label704:
          label712:
          label727:
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label800;
            }
            localObject1 = StoryCore.SjP;
            localObject1 = StoryCore.b.hvZ();
            localObject3 = ((fij)localObject3).Zpr.get(0);
            s.s(localObject3, "obj.MediaObjList[0]");
            localObject3 = (fis)localObject3;
            localObject2 = ((StoryFavoritePanel.c)localObject2).SnL.field_userName;
            localObject4 = br.adkh;
            s.s(localObject4, "storyalbum");
            localObject2 = new com.tencent.mm.plugin.story.model.c.d((fis)localObject3, (String)localObject2, (br)localObject4);
            paramv = ((StoryFavoritePanel.d)paramv).Svh;
            localObject3 = StoryCore.SjP;
            ((com.tencent.mm.loader.d)localObject1).a(localObject2, paramv, StoryCore.b.a(com.tencent.mm.plugin.story.model.c.a.SlU));
            AppMethodBeat.o(367312);
            return;
            i = 0;
            break label432;
            break;
            bool = false;
            break label439;
            ((StoryFavoritePanel.d)paramv).AnL.setVisibility(8);
            break label455;
          }
        }
        else if ((paramv instanceof StoryFavoritePanel.b))
        {
          if (((StoryFavoritePanel)localObject1).getMIsAll())
          {
            ((StoryFavoritePanel.b)paramv).Sva.setVisibility(8);
            ((StoryFavoritePanel.b)paramv).Svb.setVisibility(0);
            AppMethodBeat.o(367312);
            return;
          }
          ((StoryFavoritePanel.b)paramv).Sva.setVisibility(0);
          ((StoryFavoritePanel.b)paramv).Svb.setVisibility(8);
        }
      }
      label800:
      AppMethodBeat.o(367312);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(119892);
      int i = this.SvT.getMDatas().size();
      AppMethodBeat.o(119892);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(119891);
      paramInt = ((StoryFavoritePanel.c)this.SvT.getMDatas().get(paramInt)).type;
      AppMethodBeat.o(119891);
      return paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/album/StoryFavoritePanel$init$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends GridLayoutManager.b
  {
    h(StoryFavoritePanel paramStoryFavoritePanel) {}
    
    public final int fJ(int paramInt)
    {
      AppMethodBeat.i(119896);
      if (StoryFavoritePanel.a(this.SvT).getItemViewType(paramInt) == StoryFavoritePanel.b(this.SvT))
      {
        paramInt = StoryFavoritePanel.c(this.SvT);
        AppMethodBeat.o(119896);
        return paramInt;
      }
      AppMethodBeat.o(119896);
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.StoryFavoritePanel
 * JD-Core Version:    0.7.0.1
 */