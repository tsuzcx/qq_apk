package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.ui.a.d;
import com.tencent.mm.plugin.story.ui.layout.AvatarLayoutManager;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allFavBtn", "Landroid/widget/ImageView;", "avatarRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "checkedChangeListener", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "", "", "closeView", "dataAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "dataLayoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "favCheckBox", "Landroid/widget/CheckBox;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "itemStatusGroup", "Landroid/view/View;", "menuBtn", "onAllFav", "Lkotlin/Function0;", "getOnAllFav", "()Lkotlin/jvm/functions/Function0;", "setOnAllFav", "(Lkotlin/jvm/functions/Function0;)V", "onCheckedFav", "Lkotlin/ParameterName;", "name", "checkBox", "isChecked", "getOnCheckedFav", "()Lkotlin/jvm/functions/Function2;", "setOnCheckedFav", "(Lkotlin/jvm/functions/Function2;)V", "onClickRangeIcon", "getOnClickRangeIcon", "setOnClickRangeIcon", "onClose", "getOnClose", "setOnClose", "onMenu", "getOnMenu", "setOnMenu", "privacyIcon", "rangeIcon", "recyclerViewContainer", "Landroid/widget/FrameLayout;", "snsIcon", "initWithGalleryType", "needAction", "relayoutDateRecyclerView", "relayoutProfileRecyclerView", "relayoutSelfFavBtn", "removeUser", "userIndex", "setScrollOffset", "position", "offset", "", "setShowClose", "setUserList", "userList", "", "showFavoriteIcon", "isShow", "showPrivacyIcon", "showRangeIcon", "showSnsIcon", "toggleActiveState", "active", "updateFavCheckedStatus", "Companion", "plugin-story_release"})
public final class GalleryVerticalControlView
  extends RelativeLayout
{
  public static final a LZQ;
  private static final String TAG = "MicroMsg.GalleryVerticalControlView";
  final ImageView HZF;
  final ImageView JtD;
  private final ImageView LYy;
  final ImageView LZB;
  final ImageView LZC;
  final RecyclerView LZD;
  private final View LZE;
  final ImageView LZF;
  final CheckBox LZG;
  n.a LZH;
  d<?> LZI;
  AvatarLayoutManager LZJ;
  private m<? super CompoundButton, ? super Boolean, x> LZK;
  private kotlin.g.a.a<x> LZL;
  private kotlin.g.a.a<x> LZM;
  private kotlin.g.a.a<x> LZN;
  m<? super CompoundButton, ? super Boolean, x> LZO;
  private kotlin.g.a.a<x> LZP;
  private String mMI;
  final FrameLayout mrJ;
  
  static
  {
    AppMethodBeat.i(120392);
    LZQ = new a((byte)0);
    TAG = "MicroMsg.GalleryVerticalControlView";
    AppMethodBeat.o(120392);
  }
  
  public GalleryVerticalControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120391);
    AppMethodBeat.o(120391);
  }
  
  public GalleryVerticalControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120390);
    this.LZK = ((m)new b(this));
    View.inflate(paramContext, a.e.LDt, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.LBy);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_close)");
    this.LZB = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBP);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_privacy)");
    this.LYy = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBw);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_avatar_recycler)");
    this.LZD = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBx);
    p.j(paramAttributeSet, "findViewById(R.id.story_…vatar_recycler_container)");
    this.mrJ = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBL);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_menu)");
    this.JtD = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBT);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_sns)");
    this.LZC = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBv);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_all_fav)");
    this.LZF = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBJ);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_item_status_group)");
    this.LZE = paramAttributeSet;
    paramAttributeSet = findViewById(a.d.LBS);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_select_fav)");
    this.LZG = ((CheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.LBQ);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_range)");
    this.HZF = ((ImageView)paramAttributeSet);
    this.LZD.setItemAnimator(null);
    this.JtD.setImageDrawable(au.o(paramContext, a.f.icons_filled_more, -1));
    this.LZF.setImageDrawable(au.o(paramContext, a.f.icons_filled_contents, -1));
    this.LZB.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120379);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.LZR.getOnClose();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120379);
      }
    });
    this.JtD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120380);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.LZR.getOnMenu();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120380);
      }
    });
    this.LZF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120381);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.LZR.getOnAllFav();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120381);
      }
    });
    paramAttributeSet = this.LZG;
    paramContext = this.LZO;
    if (paramContext != null) {
      paramContext = new h(paramContext);
    }
    for (;;)
    {
      paramAttributeSet.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)paramContext);
      this.HZF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(120382);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = this.LZR.getOnClickRangeIcon();
          if (paramAnonymousView != null) {
            paramAnonymousView.invoke();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(120382);
        }
      });
      AppMethodBeat.o(120390);
      return;
    }
  }
  
  public final String getChatRoom()
  {
    return this.mMI;
  }
  
  public final kotlin.g.a.a<x> getOnAllFav()
  {
    return this.LZN;
  }
  
  public final m<CompoundButton, Boolean, x> getOnCheckedFav()
  {
    return this.LZO;
  }
  
  public final kotlin.g.a.a<x> getOnClickRangeIcon()
  {
    return this.LZP;
  }
  
  public final kotlin.g.a.a<x> getOnClose()
  {
    return this.LZL;
  }
  
  public final kotlin.g.a.a<x> getOnMenu()
  {
    return this.LZM;
  }
  
  public final void setChatRoom(String paramString)
  {
    this.mMI = paramString;
    d locald = this.LZI;
    Object localObject = locald;
    if (!(locald instanceof com.tencent.mm.plugin.story.ui.a.b)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.plugin.story.ui.a.b)localObject;
    if (localObject != null) {
      ((com.tencent.mm.plugin.story.ui.a.b)localObject).mMI = paramString;
    }
  }
  
  public final void setOnAllFav(kotlin.g.a.a<x> parama)
  {
    this.LZN = parama;
  }
  
  public final void setOnCheckedFav(m<? super CompoundButton, ? super Boolean, x> paramm)
  {
    this.LZO = paramm;
  }
  
  public final void setOnClickRangeIcon(kotlin.g.a.a<x> parama)
  {
    this.LZP = parama;
  }
  
  public final void setOnClose(kotlin.g.a.a<x> parama)
  {
    this.LZL = parama;
  }
  
  public final void setOnMenu(kotlin.g.a.a<x> parama)
  {
    this.LZM = parama;
  }
  
  public final void setUserList(List<String> paramList)
  {
    AppMethodBeat.i(120386);
    p.k(paramList, "userList");
    d locald = this.LZI;
    if (locald != null)
    {
      p.k(paramList, "users");
      locald.mXB.clear();
      locald.mXB.add("");
      locald.mXB.addAll((Collection)paramList);
      locald.mXB.add("");
    }
    paramList = this.LZI;
    if (paramList != null)
    {
      paramList.notifyDataSetChanged();
      AppMethodBeat.o(120386);
      return;
    }
    AppMethodBeat.o(120386);
  }
  
  public final void zE(boolean paramBoolean)
  {
    AppMethodBeat.i(120387);
    if (paramBoolean)
    {
      this.LYy.setVisibility(0);
      this.LYy.setImageDrawable(au.o(getContext(), a.f.icons_filled_lock, getResources().getColor(a.a.Lzf)));
      AppMethodBeat.o(120387);
      return;
    }
    this.LYy.setVisibility(8);
    AppMethodBeat.o(120387);
  }
  
  public final void zF(boolean paramBoolean)
  {
    AppMethodBeat.i(120388);
    if ((paramBoolean) && (com.tencent.mm.plugin.story.c.a.a.LEY.gbw()))
    {
      this.LYy.setVisibility(0);
      this.LYy.setImageDrawable(au.o(getContext(), a.f.icons_filled_star, getResources().getColor(a.a.Lzf)));
      AppMethodBeat.o(120388);
      return;
    }
    this.LYy.setVisibility(8);
    AppMethodBeat.o(120388);
  }
  
  public final void zG(boolean paramBoolean)
  {
    AppMethodBeat.i(120389);
    if (paramBoolean)
    {
      setVisibility(0);
      AppMethodBeat.o(120389);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(120389);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "checkBox", "Landroid/widget/CompoundButton;", "isChecked", "", "invoke", "(Landroid/widget/CompoundButton;Z)Lkotlin/Unit;"})
  static final class b
    extends q
    implements m<CompoundButton, Boolean, x>
  {
    b(GalleryVerticalControlView paramGalleryVerticalControlView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView
 * JD-Core Version:    0.7.0.1
 */