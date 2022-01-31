package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.a.m;
import a.l;
import a.y;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.m.a;
import com.tencent.mm.plugin.story.ui.a.b;
import com.tencent.mm.plugin.story.ui.a.d;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allFavBtn", "Landroid/widget/ImageView;", "avatarRecycler", "Landroid/support/v7/widget/RecyclerView;", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "checkedChangeListener", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "", "", "closeView", "dataAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "dataLayoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "favCheckBox", "Landroid/widget/CheckBox;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "menuBtn", "onAllFav", "Lkotlin/Function0;", "getOnAllFav", "()Lkotlin/jvm/functions/Function0;", "setOnAllFav", "(Lkotlin/jvm/functions/Function0;)V", "onCheckedFav", "Lkotlin/ParameterName;", "name", "checkBox", "isChecked", "getOnCheckedFav", "()Lkotlin/jvm/functions/Function2;", "setOnCheckedFav", "(Lkotlin/jvm/functions/Function2;)V", "onClose", "getOnClose", "setOnClose", "onMenu", "getOnMenu", "setOnMenu", "privacyIcon", "snsIcon", "initWithGalleryType", "needAction", "relayoutDateRecyclerView", "relayoutProfileRecyclerView", "relayoutSelfFavBtn", "removeUser", "userIndex", "setScrollOffset", "position", "offset", "", "setShowClose", "setUserList", "userList", "", "showFavoriteIcon", "isShow", "showPrivacyIcon", "showSnsIcon", "toggleActiveState", "active", "updateFavCheckedStatus", "Companion", "plugin-story_release"})
public final class GalleryVerticalControlView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.GalleryVerticalControlView";
  public static final GalleryVerticalControlView.a sSV;
  private String grA;
  final ImageView qUz;
  final ImageView sLi;
  private final ImageView sRu;
  final ImageView sSJ;
  final RecyclerView sSK;
  final ImageView sSL;
  final CheckBox sSM;
  m.a sSN;
  d<?> sSO;
  com.tencent.mm.plugin.story.ui.b.a sSP;
  private m<? super CompoundButton, ? super Boolean, y> sSQ;
  private a.f.a.a<y> sSR;
  private a.f.a.a<y> sSS;
  private a.f.a.a<y> sST;
  m<? super CompoundButton, ? super Boolean, y> sSU;
  
  static
  {
    AppMethodBeat.i(110759);
    sSV = new GalleryVerticalControlView.a((byte)0);
    TAG = "MicroMsg.GalleryVerticalControlView";
    AppMethodBeat.o(110759);
  }
  
  public GalleryVerticalControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110758);
    AppMethodBeat.o(110758);
  }
  
  public GalleryVerticalControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110757);
    this.sSQ = ((m)new GalleryVerticalControlView.b(this));
    View.inflate(paramContext, 2130970974, (ViewGroup)this);
    paramAttributeSet = findViewById(2131828458);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_gallery_close)");
    this.sLi = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828463);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_gallery_privacy)");
    this.sRu = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828462);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_gallery_avatar_recycler)");
    this.sSK = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828459);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_gallery_menu)");
    this.qUz = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828464);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_gallery_sns)");
    this.sSJ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828460);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_gallery_all_fav)");
    this.sSL = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828461);
    a.f.b.j.p(paramAttributeSet, "findViewById(R.id.story_gallery_select_fav)");
    this.sSM = ((CheckBox)paramAttributeSet);
    this.sSK.setItemAnimator(null);
    this.qUz.setImageDrawable(aj.g(paramContext, 2131231463, -1));
    this.sSL.setImageDrawable(aj.g(paramContext, 2131231449, -1));
    this.sLi.setOnClickListener((View.OnClickListener)new GalleryVerticalControlView.1(this));
    this.qUz.setOnClickListener((View.OnClickListener)new GalleryVerticalControlView.2(this));
    this.sSL.setOnClickListener((View.OnClickListener)new GalleryVerticalControlView.3(this));
    paramAttributeSet = this.sSM;
    paramContext = this.sSU;
    if (paramContext != null) {
      paramContext = new j(paramContext);
    }
    for (;;)
    {
      paramAttributeSet.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)paramContext);
      AppMethodBeat.o(110757);
      return;
    }
  }
  
  public final String getChatRoom()
  {
    return this.grA;
  }
  
  public final a.f.a.a<y> getOnAllFav()
  {
    return this.sST;
  }
  
  public final m<CompoundButton, Boolean, y> getOnCheckedFav()
  {
    return this.sSU;
  }
  
  public final a.f.a.a<y> getOnClose()
  {
    return this.sSR;
  }
  
  public final a.f.a.a<y> getOnMenu()
  {
    return this.sSS;
  }
  
  public final void mi(boolean paramBoolean)
  {
    AppMethodBeat.i(138940);
    if (paramBoolean)
    {
      setVisibility(0);
      AppMethodBeat.o(138940);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(138940);
  }
  
  public final void mq(boolean paramBoolean)
  {
    AppMethodBeat.i(110755);
    if (paramBoolean)
    {
      this.sRu.setVisibility(0);
      this.sRu.setImageDrawable(aj.g(getContext(), 2131231459, getResources().getColor(2131690551)));
      AppMethodBeat.o(110755);
      return;
    }
    this.sRu.setVisibility(8);
    AppMethodBeat.o(110755);
  }
  
  public final void mr(boolean paramBoolean)
  {
    AppMethodBeat.i(110756);
    if ((paramBoolean) && (com.tencent.mm.plugin.story.c.a.a.srz.czq()))
    {
      this.sRu.setVisibility(0);
      this.sRu.setImageDrawable(aj.g(getContext(), 2131231475, getResources().getColor(2131690551)));
      AppMethodBeat.o(110756);
      return;
    }
    this.sRu.setVisibility(8);
    AppMethodBeat.o(110756);
  }
  
  public final void setChatRoom(String paramString)
  {
    this.grA = paramString;
    d locald = this.sSO;
    Object localObject = locald;
    if (!(locald instanceof b)) {
      localObject = null;
    }
    localObject = (b)localObject;
    if (localObject != null) {
      ((b)localObject).grA = paramString;
    }
  }
  
  public final void setOnAllFav(a.f.a.a<y> parama)
  {
    this.sST = parama;
  }
  
  public final void setOnCheckedFav(m<? super CompoundButton, ? super Boolean, y> paramm)
  {
    this.sSU = paramm;
  }
  
  public final void setOnClose(a.f.a.a<y> parama)
  {
    this.sSR = parama;
  }
  
  public final void setOnMenu(a.f.a.a<y> parama)
  {
    this.sSS = parama;
  }
  
  public final void setUserList(List<String> paramList)
  {
    AppMethodBeat.i(110754);
    a.f.b.j.q(paramList, "userList");
    d locald = this.sSO;
    if (locald != null)
    {
      a.f.b.j.q(paramList, "users");
      locald.iRT.clear();
      locald.iRT.add("");
      locald.iRT.addAll((Collection)paramList);
      locald.iRT.add("");
    }
    paramList = this.sSO;
    if (paramList != null)
    {
      paramList.notifyDataSetChanged();
      AppMethodBeat.o(110754);
      return;
    }
    AppMethodBeat.o(110754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView
 * JD-Core Version:    0.7.0.1
 */