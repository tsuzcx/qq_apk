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
import com.tencent.mm.ui.ao;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allFavBtn", "Landroid/widget/ImageView;", "avatarRecycler", "Landroid/support/v7/widget/RecyclerView;", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "checkedChangeListener", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "", "", "closeView", "dataAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "dataLayoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "favCheckBox", "Landroid/widget/CheckBox;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "itemStatusGroup", "Landroid/view/View;", "menuBtn", "onAllFav", "Lkotlin/Function0;", "getOnAllFav", "()Lkotlin/jvm/functions/Function0;", "setOnAllFav", "(Lkotlin/jvm/functions/Function0;)V", "onCheckedFav", "Lkotlin/ParameterName;", "name", "checkBox", "isChecked", "getOnCheckedFav", "()Lkotlin/jvm/functions/Function2;", "setOnCheckedFav", "(Lkotlin/jvm/functions/Function2;)V", "onClickRangeIcon", "getOnClickRangeIcon", "setOnClickRangeIcon", "onClose", "getOnClose", "setOnClose", "onMenu", "getOnMenu", "setOnMenu", "privacyIcon", "rangeIcon", "recyclerViewContainer", "Landroid/widget/FrameLayout;", "snsIcon", "initWithGalleryType", "needAction", "relayoutDateRecyclerView", "relayoutProfileRecyclerView", "relayoutSelfFavBtn", "removeUser", "userIndex", "setScrollOffset", "position", "offset", "", "setShowClose", "setUserList", "userList", "", "showFavoriteIcon", "isShow", "showPrivacyIcon", "showRangeIcon", "showSnsIcon", "toggleActiveState", "active", "updateFavCheckedStatus", "Companion", "plugin-story_release"})
public final class GalleryVerticalControlView
  extends RelativeLayout
{
  public static final GalleryVerticalControlView.a Bvd;
  private static final String TAG = "MicroMsg.GalleryVerticalControlView";
  private final ImageView BtK;
  final ImageView BuO;
  final ImageView BuP;
  final RecyclerView BuQ;
  private final View BuR;
  final ImageView BuS;
  final CheckBox BuT;
  n.a BuU;
  d<?> BuV;
  AvatarLayoutManager BuW;
  private m<? super CompoundButton, ? super Boolean, z> BuX;
  private d.g.a.a<z> BuY;
  private d.g.a.a<z> BuZ;
  private d.g.a.a<z> Bva;
  m<? super CompoundButton, ? super Boolean, z> Bvb;
  private d.g.a.a<z> Bvc;
  final FrameLayout iFL;
  private String jaD;
  final ImageView ycn;
  final ImageView zjh;
  
  static
  {
    AppMethodBeat.i(120392);
    Bvd = new GalleryVerticalControlView.a((byte)0);
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
    this.BuX = ((m)new b(this));
    View.inflate(paramContext, 2131495723, (ViewGroup)this);
    paramAttributeSet = findViewById(2131305420);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_close)");
    this.BuO = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305439);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_privacy)");
    this.BtK = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305418);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_avatar_recycler)");
    this.BuQ = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305419);
    p.g(paramAttributeSet, "findViewById(R.id.story_…vatar_recycler_container)");
    this.iFL = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305435);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_menu)");
    this.zjh = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305444);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_sns)");
    this.BuP = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305417);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_all_fav)");
    this.BuS = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305433);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_item_status_group)");
    this.BuR = paramAttributeSet;
    paramAttributeSet = findViewById(2131305443);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_select_fav)");
    this.BuT = ((CheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(2131305440);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_range)");
    this.ycn = ((ImageView)paramAttributeSet);
    this.BuQ.setItemAnimator(null);
    this.zjh.setImageDrawable(ao.k(paramContext, 2131690436, -1));
    this.BuS.setImageDrawable(ao.k(paramContext, 2131690380, -1));
    this.BuO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120379);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.Bve.getOnClose();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120379);
      }
    });
    this.zjh.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120380);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.Bve.getOnMenu();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120380);
      }
    });
    this.BuS.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120381);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.Bve.getOnAllFav();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120381);
      }
    });
    paramAttributeSet = this.BuT;
    paramContext = this.Bvb;
    if (paramContext != null) {
      paramContext = new h(paramContext);
    }
    for (;;)
    {
      paramAttributeSet.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)paramContext);
      this.ycn.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(120382);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = this.Bve.getOnClickRangeIcon();
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
    return this.jaD;
  }
  
  public final d.g.a.a<z> getOnAllFav()
  {
    return this.Bva;
  }
  
  public final m<CompoundButton, Boolean, z> getOnCheckedFav()
  {
    return this.Bvb;
  }
  
  public final d.g.a.a<z> getOnClickRangeIcon()
  {
    return this.Bvc;
  }
  
  public final d.g.a.a<z> getOnClose()
  {
    return this.BuY;
  }
  
  public final d.g.a.a<z> getOnMenu()
  {
    return this.BuZ;
  }
  
  public final void sE(boolean paramBoolean)
  {
    AppMethodBeat.i(120387);
    if (paramBoolean)
    {
      this.BtK.setVisibility(0);
      this.BtK.setImageDrawable(ao.k(getContext(), 2131690423, getResources().getColor(2131100987)));
      AppMethodBeat.o(120387);
      return;
    }
    this.BtK.setVisibility(8);
    AppMethodBeat.o(120387);
  }
  
  public final void sF(boolean paramBoolean)
  {
    AppMethodBeat.i(120388);
    if ((paramBoolean) && (com.tencent.mm.plugin.story.c.a.a.AZY.ekC()))
    {
      this.BtK.setVisibility(0);
      this.BtK.setImageDrawable(ao.k(getContext(), 2131690480, getResources().getColor(2131100987)));
      AppMethodBeat.o(120388);
      return;
    }
    this.BtK.setVisibility(8);
    AppMethodBeat.o(120388);
  }
  
  public final void sG(boolean paramBoolean)
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
  
  public final void setChatRoom(String paramString)
  {
    this.jaD = paramString;
    d locald = this.BuV;
    Object localObject = locald;
    if (!(locald instanceof com.tencent.mm.plugin.story.ui.a.b)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.plugin.story.ui.a.b)localObject;
    if (localObject != null) {
      ((com.tencent.mm.plugin.story.ui.a.b)localObject).jaD = paramString;
    }
  }
  
  public final void setOnAllFav(d.g.a.a<z> parama)
  {
    this.Bva = parama;
  }
  
  public final void setOnCheckedFav(m<? super CompoundButton, ? super Boolean, z> paramm)
  {
    this.Bvb = paramm;
  }
  
  public final void setOnClickRangeIcon(d.g.a.a<z> parama)
  {
    this.Bvc = parama;
  }
  
  public final void setOnClose(d.g.a.a<z> parama)
  {
    this.BuY = parama;
  }
  
  public final void setOnMenu(d.g.a.a<z> parama)
  {
    this.BuZ = parama;
  }
  
  public final void setUserList(List<String> paramList)
  {
    AppMethodBeat.i(120386);
    p.h(paramList, "userList");
    d locald = this.BuV;
    if (locald != null)
    {
      p.h(paramList, "users");
      locald.jhZ.clear();
      locald.jhZ.add("");
      locald.jhZ.addAll((Collection)paramList);
      locald.jhZ.add("");
    }
    paramList = this.BuV;
    if (paramList != null)
    {
      paramList.notifyDataSetChanged();
      AppMethodBeat.o(120386);
      return;
    }
    AppMethodBeat.o(120386);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "checkBox", "Landroid/widget/CompoundButton;", "isChecked", "", "invoke", "(Landroid/widget/CompoundButton;Z)Lkotlin/Unit;"})
  static final class b
    extends q
    implements m<CompoundButton, Boolean, z>
  {
    b(GalleryVerticalControlView paramGalleryVerticalControlView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView
 * JD-Core Version:    0.7.0.1
 */