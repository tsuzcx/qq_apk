package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.ui.a.d;
import com.tencent.mm.plugin.story.ui.layout.AvatarLayoutManager;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allFavBtn", "Landroid/widget/ImageView;", "avatarRecycler", "Landroid/support/v7/widget/RecyclerView;", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "checkedChangeListener", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "", "", "closeView", "dataAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "dataLayoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "favCheckBox", "Landroid/widget/CheckBox;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "itemStatusGroup", "Landroid/view/View;", "menuBtn", "onAllFav", "Lkotlin/Function0;", "getOnAllFav", "()Lkotlin/jvm/functions/Function0;", "setOnAllFav", "(Lkotlin/jvm/functions/Function0;)V", "onCheckedFav", "Lkotlin/ParameterName;", "name", "checkBox", "isChecked", "getOnCheckedFav", "()Lkotlin/jvm/functions/Function2;", "setOnCheckedFav", "(Lkotlin/jvm/functions/Function2;)V", "onClickRangeIcon", "getOnClickRangeIcon", "setOnClickRangeIcon", "onClose", "getOnClose", "setOnClose", "onMenu", "getOnMenu", "setOnMenu", "privacyIcon", "rangeIcon", "recyclerViewContainer", "Landroid/widget/FrameLayout;", "snsIcon", "initWithGalleryType", "needAction", "relayoutDateRecyclerView", "relayoutProfileRecyclerView", "relayoutSelfFavBtn", "removeUser", "userIndex", "setScrollOffset", "position", "offset", "", "setShowClose", "setUserList", "userList", "", "showFavoriteIcon", "isShow", "showPrivacyIcon", "showRangeIcon", "showSnsIcon", "toggleActiveState", "active", "updateFavCheckedStatus", "Companion", "plugin-story_release"})
public final class GalleryVerticalControlView
  extends RelativeLayout
{
  public static final GalleryVerticalControlView.a FFQ;
  private static final String TAG = "MicroMsg.GalleryVerticalControlView";
  final ImageView Cdq;
  final ImageView DnY;
  private final ImageView FEx;
  final ImageView FFB;
  final ImageView FFC;
  final RecyclerView FFD;
  private final View FFE;
  final ImageView FFF;
  final CheckBox FFG;
  n.a FFH;
  d<?> FFI;
  AvatarLayoutManager FFJ;
  private m<? super CompoundButton, ? super Boolean, x> FFK;
  private kotlin.g.a.a<x> FFL;
  private kotlin.g.a.a<x> FFM;
  private kotlin.g.a.a<x> FFN;
  m<? super CompoundButton, ? super Boolean, x> FFO;
  private kotlin.g.a.a<x> FFP;
  final FrameLayout jBO;
  private String jVv;
  
  static
  {
    AppMethodBeat.i(120392);
    FFQ = new GalleryVerticalControlView.a((byte)0);
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
    this.FFK = ((m)new b(this));
    View.inflate(paramContext, 2131496628, (ViewGroup)this);
    paramAttributeSet = findViewById(2131308626);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_close)");
    this.FFB = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308645);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_privacy)");
    this.FEx = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308624);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_avatar_recycler)");
    this.FFD = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308625);
    p.g(paramAttributeSet, "findViewById(R.id.story_…vatar_recycler_container)");
    this.jBO = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131308641);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_menu)");
    this.DnY = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308650);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_sns)");
    this.FFC = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308623);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_all_fav)");
    this.FFF = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131308639);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_item_status_group)");
    this.FFE = paramAttributeSet;
    paramAttributeSet = findViewById(2131308649);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_select_fav)");
    this.FFG = ((CheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(2131308646);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_range)");
    this.Cdq = ((ImageView)paramAttributeSet);
    this.FFD.setItemAnimator(null);
    this.DnY.setImageDrawable(ar.m(paramContext, 2131690612, -1));
    this.FFF.setImageDrawable(ar.m(paramContext, 2131690523, -1));
    this.FFB.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120379);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.FFR.getOnClose();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120379);
      }
    });
    this.DnY.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120380);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.FFR.getOnMenu();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120380);
      }
    });
    this.FFF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120381);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.FFR.getOnAllFav();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120381);
      }
    });
    paramAttributeSet = this.FFG;
    paramContext = this.FFO;
    if (paramContext != null) {
      paramContext = new h(paramContext);
    }
    for (;;)
    {
      paramAttributeSet.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)paramContext);
      this.Cdq.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(120382);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = this.FFR.getOnClickRangeIcon();
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
    return this.jVv;
  }
  
  public final kotlin.g.a.a<x> getOnAllFav()
  {
    return this.FFN;
  }
  
  public final m<CompoundButton, Boolean, x> getOnCheckedFav()
  {
    return this.FFO;
  }
  
  public final kotlin.g.a.a<x> getOnClickRangeIcon()
  {
    return this.FFP;
  }
  
  public final kotlin.g.a.a<x> getOnClose()
  {
    return this.FFL;
  }
  
  public final kotlin.g.a.a<x> getOnMenu()
  {
    return this.FFM;
  }
  
  public final void setChatRoom(String paramString)
  {
    this.jVv = paramString;
    d locald = this.FFI;
    Object localObject = locald;
    if (!(locald instanceof com.tencent.mm.plugin.story.ui.a.b)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.plugin.story.ui.a.b)localObject;
    if (localObject != null) {
      ((com.tencent.mm.plugin.story.ui.a.b)localObject).jVv = paramString;
    }
  }
  
  public final void setOnAllFav(kotlin.g.a.a<x> parama)
  {
    this.FFN = parama;
  }
  
  public final void setOnCheckedFav(m<? super CompoundButton, ? super Boolean, x> paramm)
  {
    this.FFO = paramm;
  }
  
  public final void setOnClickRangeIcon(kotlin.g.a.a<x> parama)
  {
    this.FFP = parama;
  }
  
  public final void setOnClose(kotlin.g.a.a<x> parama)
  {
    this.FFL = parama;
  }
  
  public final void setOnMenu(kotlin.g.a.a<x> parama)
  {
    this.FFM = parama;
  }
  
  public final void setUserList(List<String> paramList)
  {
    AppMethodBeat.i(120386);
    p.h(paramList, "userList");
    d locald = this.FFI;
    if (locald != null)
    {
      p.h(paramList, "users");
      locald.kgc.clear();
      locald.kgc.add("");
      locald.kgc.addAll((Collection)paramList);
      locald.kgc.add("");
    }
    paramList = this.FFI;
    if (paramList != null)
    {
      paramList.notifyDataSetChanged();
      AppMethodBeat.o(120386);
      return;
    }
    AppMethodBeat.o(120386);
  }
  
  public final void vY(boolean paramBoolean)
  {
    AppMethodBeat.i(120387);
    if (paramBoolean)
    {
      this.FEx.setVisibility(0);
      this.FEx.setImageDrawable(ar.m(getContext(), 2131690590, getResources().getColor(2131101217)));
      AppMethodBeat.o(120387);
      return;
    }
    this.FEx.setVisibility(8);
    AppMethodBeat.o(120387);
  }
  
  public final void vZ(boolean paramBoolean)
  {
    AppMethodBeat.i(120388);
    if ((paramBoolean) && (com.tencent.mm.plugin.story.c.a.a.FkW.fnd()))
    {
      this.FEx.setVisibility(0);
      this.FEx.setImageDrawable(ar.m(getContext(), 2131690677, getResources().getColor(2131101217)));
      AppMethodBeat.o(120388);
      return;
    }
    this.FEx.setVisibility(8);
    AppMethodBeat.o(120388);
  }
  
  public final void wa(boolean paramBoolean)
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "checkBox", "Landroid/widget/CompoundButton;", "isChecked", "", "invoke", "(Landroid/widget/CompoundButton;Z)Lkotlin/Unit;"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView
 * JD-Core Version:    0.7.0.1
 */