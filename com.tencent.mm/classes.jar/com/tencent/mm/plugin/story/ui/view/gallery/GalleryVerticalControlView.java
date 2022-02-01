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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allFavBtn", "Landroid/widget/ImageView;", "avatarRecycler", "Landroid/support/v7/widget/RecyclerView;", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "checkedChangeListener", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "", "", "closeView", "dataAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "dataLayoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "favCheckBox", "Landroid/widget/CheckBox;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "itemStatusGroup", "Landroid/view/View;", "menuBtn", "onAllFav", "Lkotlin/Function0;", "getOnAllFav", "()Lkotlin/jvm/functions/Function0;", "setOnAllFav", "(Lkotlin/jvm/functions/Function0;)V", "onCheckedFav", "Lkotlin/ParameterName;", "name", "checkBox", "isChecked", "getOnCheckedFav", "()Lkotlin/jvm/functions/Function2;", "setOnCheckedFav", "(Lkotlin/jvm/functions/Function2;)V", "onClickRangeIcon", "getOnClickRangeIcon", "setOnClickRangeIcon", "onClose", "getOnClose", "setOnClose", "onMenu", "getOnMenu", "setOnMenu", "privacyIcon", "rangeIcon", "recyclerViewContainer", "Landroid/widget/FrameLayout;", "snsIcon", "initWithGalleryType", "needAction", "relayoutDateRecyclerView", "relayoutProfileRecyclerView", "relayoutSelfFavBtn", "removeUser", "userIndex", "setScrollOffset", "position", "offset", "", "setShowClose", "setUserList", "userList", "", "showFavoriteIcon", "isShow", "showPrivacyIcon", "showRangeIcon", "showSnsIcon", "toggleActiveState", "active", "updateFavCheckedStatus", "Companion", "plugin-story_release"})
public final class GalleryVerticalControlView
  extends RelativeLayout
{
  public static final GalleryVerticalControlView.a BdF;
  private static final String TAG = "MicroMsg.GalleryVerticalControlView";
  private final ImageView Bcm;
  private d.g.a.a<z> BdA;
  private d.g.a.a<z> BdB;
  private d.g.a.a<z> BdC;
  m<? super CompoundButton, ? super Boolean, z> BdD;
  private d.g.a.a<z> BdE;
  final ImageView Bdq;
  final ImageView Bdr;
  final RecyclerView Bds;
  private final View Bdt;
  final ImageView Bdu;
  final CheckBox Bdv;
  n.a Bdw;
  d<?> Bdx;
  AvatarLayoutManager Bdy;
  private m<? super CompoundButton, ? super Boolean, z> Bdz;
  final FrameLayout iCS;
  private String iXK;
  final ImageView xMt;
  final ImageView ySX;
  
  static
  {
    AppMethodBeat.i(120392);
    BdF = new GalleryVerticalControlView.a((byte)0);
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
    this.Bdz = ((m)new b(this));
    View.inflate(paramContext, 2131495723, (ViewGroup)this);
    paramAttributeSet = findViewById(2131305420);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_close)");
    this.Bdq = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305439);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_privacy)");
    this.Bcm = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305418);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_avatar_recycler)");
    this.Bds = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305419);
    p.g(paramAttributeSet, "findViewById(R.id.story_…vatar_recycler_container)");
    this.iCS = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305435);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_menu)");
    this.ySX = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305444);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_sns)");
    this.Bdr = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305417);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_all_fav)");
    this.Bdu = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305433);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_item_status_group)");
    this.Bdt = paramAttributeSet;
    paramAttributeSet = findViewById(2131305443);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_select_fav)");
    this.Bdv = ((CheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(2131305440);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_range)");
    this.xMt = ((ImageView)paramAttributeSet);
    this.Bds.setItemAnimator(null);
    this.ySX.setImageDrawable(ao.k(paramContext, 2131690436, -1));
    this.Bdu.setImageDrawable(ao.k(paramContext, 2131690380, -1));
    this.Bdq.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120379);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.BdG.getOnClose();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120379);
      }
    });
    this.ySX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120380);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.BdG.getOnMenu();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120380);
      }
    });
    this.Bdu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120381);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.BdG.getOnAllFav();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(120381);
      }
    });
    paramAttributeSet = this.Bdv;
    paramContext = this.BdD;
    if (paramContext != null) {
      paramContext = new h(paramContext);
    }
    for (;;)
    {
      paramAttributeSet.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)paramContext);
      this.xMt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(120382);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = this.BdG.getOnClickRangeIcon();
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
    return this.iXK;
  }
  
  public final d.g.a.a<z> getOnAllFav()
  {
    return this.BdC;
  }
  
  public final m<CompoundButton, Boolean, z> getOnCheckedFav()
  {
    return this.BdD;
  }
  
  public final d.g.a.a<z> getOnClickRangeIcon()
  {
    return this.BdE;
  }
  
  public final d.g.a.a<z> getOnClose()
  {
    return this.BdA;
  }
  
  public final d.g.a.a<z> getOnMenu()
  {
    return this.BdB;
  }
  
  public final void setChatRoom(String paramString)
  {
    this.iXK = paramString;
    d locald = this.Bdx;
    Object localObject = locald;
    if (!(locald instanceof com.tencent.mm.plugin.story.ui.a.b)) {
      localObject = null;
    }
    localObject = (com.tencent.mm.plugin.story.ui.a.b)localObject;
    if (localObject != null) {
      ((com.tencent.mm.plugin.story.ui.a.b)localObject).iXK = paramString;
    }
  }
  
  public final void setOnAllFav(d.g.a.a<z> parama)
  {
    this.BdC = parama;
  }
  
  public final void setOnCheckedFav(m<? super CompoundButton, ? super Boolean, z> paramm)
  {
    this.BdD = paramm;
  }
  
  public final void setOnClickRangeIcon(d.g.a.a<z> parama)
  {
    this.BdE = parama;
  }
  
  public final void setOnClose(d.g.a.a<z> parama)
  {
    this.BdA = parama;
  }
  
  public final void setOnMenu(d.g.a.a<z> parama)
  {
    this.BdB = parama;
  }
  
  public final void setUserList(List<String> paramList)
  {
    AppMethodBeat.i(120386);
    p.h(paramList, "userList");
    d locald = this.Bdx;
    if (locald != null)
    {
      p.h(paramList, "users");
      locald.jfg.clear();
      locald.jfg.add("");
      locald.jfg.addAll((Collection)paramList);
      locald.jfg.add("");
    }
    paramList = this.Bdx;
    if (paramList != null)
    {
      paramList.notifyDataSetChanged();
      AppMethodBeat.o(120386);
      return;
    }
    AppMethodBeat.o(120386);
  }
  
  public final void sx(boolean paramBoolean)
  {
    AppMethodBeat.i(120387);
    if (paramBoolean)
    {
      this.Bcm.setVisibility(0);
      this.Bcm.setImageDrawable(ao.k(getContext(), 2131690423, getResources().getColor(2131100987)));
      AppMethodBeat.o(120387);
      return;
    }
    this.Bcm.setVisibility(8);
    AppMethodBeat.o(120387);
  }
  
  public final void sy(boolean paramBoolean)
  {
    AppMethodBeat.i(120388);
    if ((paramBoolean) && (com.tencent.mm.plugin.story.c.a.a.AIv.egU()))
    {
      this.Bcm.setVisibility(0);
      this.Bcm.setImageDrawable(ao.k(getContext(), 2131690480, getResources().getColor(2131100987)));
      AppMethodBeat.o(120388);
      return;
    }
    this.Bcm.setVisibility(8);
    AppMethodBeat.o(120388);
  }
  
  public final void sz(boolean paramBoolean)
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "checkBox", "Landroid/widget/CompoundButton;", "isChecked", "", "invoke", "(Landroid/widget/CompoundButton;Z)Lkotlin/Unit;"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView
 * JD-Core Version:    0.7.0.1
 */