package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.api.n.a;
import com.tencent.mm.plugin.story.ui.a.d;
import com.tencent.mm.plugin.story.ui.layout.AvatarLayoutManager;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allFavBtn", "Landroid/widget/ImageView;", "avatarRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "checkedChangeListener", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "", "", "closeView", "dataAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "dataLayoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "favCheckBox", "Landroid/widget/CheckBox;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "itemStatusGroup", "Landroid/view/View;", "menuBtn", "onAllFav", "Lkotlin/Function0;", "getOnAllFav", "()Lkotlin/jvm/functions/Function0;", "setOnAllFav", "(Lkotlin/jvm/functions/Function0;)V", "onCheckedFav", "Lkotlin/ParameterName;", "name", "checkBox", "isChecked", "getOnCheckedFav", "()Lkotlin/jvm/functions/Function2;", "setOnCheckedFav", "(Lkotlin/jvm/functions/Function2;)V", "onClickRangeIcon", "getOnClickRangeIcon", "setOnClickRangeIcon", "onClose", "getOnClose", "setOnClose", "onMenu", "getOnMenu", "setOnMenu", "privacyIcon", "rangeIcon", "recyclerViewContainer", "Landroid/widget/FrameLayout;", "snsIcon", "initWithGalleryType", "needAction", "relayoutDateRecyclerView", "relayoutProfileRecyclerView", "relayoutSelfFavBtn", "removeUser", "userIndex", "setScrollOffset", "position", "offset", "", "setShowClose", "setUserList", "userList", "", "showFavoriteIcon", "isShow", "showPrivacyIcon", "showRangeIcon", "showSnsIcon", "toggleActiveState", "active", "updateFavCheckedStatus", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GalleryVerticalControlView
  extends RelativeLayout
{
  public static final GalleryVerticalControlView.a SAX;
  private static final String TAG;
  final ImageView NWl;
  final ImageView PHc;
  final ImageView SAY;
  final ImageView SAZ;
  final RecyclerView SBa;
  private final View SBb;
  final ImageView SBc;
  final CheckBox SBd;
  n.a SBe;
  d<?> SBf;
  AvatarLayoutManager SBg;
  private m<? super CompoundButton, ? super Boolean, ah> SBh;
  private kotlin.g.a.a<ah> SBi;
  private kotlin.g.a.a<ah> SBj;
  private kotlin.g.a.a<ah> SBk;
  private m<? super CompoundButton, ? super Boolean, ah> SBl;
  private kotlin.g.a.a<ah> SBm;
  private final ImageView SzY;
  private String pJq;
  final FrameLayout plo;
  
  static
  {
    AppMethodBeat.i(120392);
    SAX = new GalleryVerticalControlView.a((byte)0);
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
    this.SBh = ((m)new c(this));
    View.inflate(paramContext, a.e.She, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.Sfj);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_close)");
    this.SAY = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.SfA);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_privacy)");
    this.SzY = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sfh);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_avatar_recycler)");
    this.SBa = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sfi);
    s.s(paramAttributeSet, "findViewById(R.id.story_…vatar_recycler_container)");
    this.plo = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sfw);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_menu)");
    this.PHc = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.SfE);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_sns)");
    this.SAZ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sfg);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_all_fav)");
    this.SBc = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.Sfu);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_item_status_group)");
    this.SBb = paramAttributeSet;
    paramAttributeSet = findViewById(a.d.SfD);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_select_fav)");
    this.SBd = ((CheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(a.d.SfB);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_range)");
    this.NWl = ((ImageView)paramAttributeSet);
    this.SBa.setItemAnimator(null);
    this.PHc.setImageDrawable(bb.m(paramContext, a.f.icons_filled_more, -1));
    this.SBc.setImageDrawable(bb.m(paramContext, a.f.icons_filled_contents, -1));
    this.SAY.setOnClickListener(new GalleryVerticalControlView..ExternalSyntheticLambda3(this));
    this.PHc.setOnClickListener(new GalleryVerticalControlView..ExternalSyntheticLambda1(this));
    this.SBc.setOnClickListener(new GalleryVerticalControlView..ExternalSyntheticLambda2(this));
    paramAttributeSet = this.SBd;
    paramContext = this.SBl;
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = new GalleryVerticalControlView..ExternalSyntheticLambda4(paramContext))
    {
      paramAttributeSet.setOnCheckedChangeListener(paramContext);
      this.NWl.setOnClickListener(new GalleryVerticalControlView..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(120390);
      return;
    }
  }
  
  private static final void a(GalleryVerticalControlView paramGalleryVerticalControlView, View paramView)
  {
    AppMethodBeat.i(367655);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramGalleryVerticalControlView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramGalleryVerticalControlView, "this$0");
    paramGalleryVerticalControlView = paramGalleryVerticalControlView.getOnClose();
    if (paramGalleryVerticalControlView != null) {
      paramGalleryVerticalControlView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367655);
  }
  
  private static final void a(m paramm, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(367669);
    paramm.invoke(paramCompoundButton, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(367669);
  }
  
  private static final void b(GalleryVerticalControlView paramGalleryVerticalControlView, View paramView)
  {
    AppMethodBeat.i(367660);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramGalleryVerticalControlView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramGalleryVerticalControlView, "this$0");
    paramGalleryVerticalControlView = paramGalleryVerticalControlView.getOnMenu();
    if (paramGalleryVerticalControlView != null) {
      paramGalleryVerticalControlView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367660);
  }
  
  private static final void b(m paramm, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(367679);
    paramm.invoke(paramCompoundButton, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(367679);
  }
  
  private static final void c(GalleryVerticalControlView paramGalleryVerticalControlView, View paramView)
  {
    AppMethodBeat.i(367663);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramGalleryVerticalControlView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramGalleryVerticalControlView, "this$0");
    paramGalleryVerticalControlView = paramGalleryVerticalControlView.getOnAllFav();
    if (paramGalleryVerticalControlView != null) {
      paramGalleryVerticalControlView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367663);
  }
  
  private static final void d(GalleryVerticalControlView paramGalleryVerticalControlView, View paramView)
  {
    AppMethodBeat.i(367673);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramGalleryVerticalControlView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramGalleryVerticalControlView, "this$0");
    paramGalleryVerticalControlView = paramGalleryVerticalControlView.getOnClickRangeIcon();
    if (paramGalleryVerticalControlView != null) {
      paramGalleryVerticalControlView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367673);
  }
  
  public final void EU(boolean paramBoolean)
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
  
  public final void EW(boolean paramBoolean)
  {
    AppMethodBeat.i(120387);
    if (paramBoolean)
    {
      this.SzY.setVisibility(0);
      this.SzY.setImageDrawable(bb.m(getContext(), a.f.icons_filled_lock, getResources().getColor(a.a.ScS)));
      AppMethodBeat.o(120387);
      return;
    }
    this.SzY.setVisibility(8);
    AppMethodBeat.o(120387);
  }
  
  public final void EX(boolean paramBoolean)
  {
    AppMethodBeat.i(120388);
    if ((paramBoolean) && (com.tencent.mm.plugin.story.c.a.a.SiJ.huP()))
    {
      this.SzY.setVisibility(0);
      this.SzY.setImageDrawable(bb.m(getContext(), a.f.icons_filled_star, getResources().getColor(a.a.ScS)));
      AppMethodBeat.o(120388);
      return;
    }
    this.SzY.setVisibility(8);
    AppMethodBeat.o(120388);
  }
  
  public final void EY(boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(367723);
    this.SBd.setOnCheckedChangeListener(null);
    this.SBd.setChecked(paramBoolean);
    CheckBox localCheckBox = this.SBd;
    m localm = this.SBl;
    if (localm == null) {}
    for (;;)
    {
      localCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)localObject);
      AppMethodBeat.o(367723);
      return;
      localObject = new GalleryVerticalControlView..ExternalSyntheticLambda5(localm);
    }
  }
  
  public final String getChatRoom()
  {
    return this.pJq;
  }
  
  public final kotlin.g.a.a<ah> getOnAllFav()
  {
    return this.SBk;
  }
  
  public final m<CompoundButton, Boolean, ah> getOnCheckedFav()
  {
    return this.SBl;
  }
  
  public final kotlin.g.a.a<ah> getOnClickRangeIcon()
  {
    return this.SBm;
  }
  
  public final kotlin.g.a.a<ah> getOnClose()
  {
    return this.SBi;
  }
  
  public final kotlin.g.a.a<ah> getOnMenu()
  {
    return this.SBj;
  }
  
  public final void setChatRoom(String paramString)
  {
    this.pJq = paramString;
    Object localObject = this.SBf;
    if ((localObject instanceof com.tencent.mm.plugin.story.ui.a.b)) {}
    for (localObject = (com.tencent.mm.plugin.story.ui.a.b)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.story.ui.a.b)localObject).pJq = paramString;
      }
      return;
    }
  }
  
  public final void setOnAllFav(kotlin.g.a.a<ah> parama)
  {
    this.SBk = parama;
  }
  
  public final void setOnCheckedFav(m<? super CompoundButton, ? super Boolean, ah> paramm)
  {
    this.SBl = paramm;
  }
  
  public final void setOnClickRangeIcon(kotlin.g.a.a<ah> parama)
  {
    this.SBm = parama;
  }
  
  public final void setOnClose(kotlin.g.a.a<ah> parama)
  {
    this.SBi = parama;
  }
  
  public final void setOnMenu(kotlin.g.a.a<ah> parama)
  {
    this.SBj = parama;
  }
  
  public final void setUserList(List<String> paramList)
  {
    AppMethodBeat.i(120386);
    s.u(paramList, "userList");
    d locald = this.SBf;
    if (locald != null)
    {
      s.u(paramList, "users");
      locald.pUj.clear();
      locald.pUj.add("");
      locald.pUj.addAll((Collection)paramList);
      locald.pUj.add("");
    }
    paramList = this.SBf;
    if (paramList != null) {
      paramList.bZE.notifyChanged();
    }
    AppMethodBeat.o(120386);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "checkBox", "Landroid/widget/CompoundButton;", "isChecked", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<CompoundButton, Boolean, ah>
  {
    c(GalleryVerticalControlView paramGalleryVerticalControlView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView
 * JD-Core Version:    0.7.0.1
 */