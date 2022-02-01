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
import com.tencent.mm.plugin.story.ui.a.b;
import com.tencent.mm.plugin.story.ui.a.d;
import com.tencent.mm.plugin.story.ui.layout.AvatarLayoutManager;
import com.tencent.mm.ui.am;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allFavBtn", "Landroid/widget/ImageView;", "avatarRecycler", "Landroid/support/v7/widget/RecyclerView;", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "checkedChangeListener", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "", "", "closeView", "dataAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "dataLayoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "favCheckBox", "Landroid/widget/CheckBox;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "itemStatusGroup", "Landroid/view/View;", "menuBtn", "onAllFav", "Lkotlin/Function0;", "getOnAllFav", "()Lkotlin/jvm/functions/Function0;", "setOnAllFav", "(Lkotlin/jvm/functions/Function0;)V", "onCheckedFav", "Lkotlin/ParameterName;", "name", "checkBox", "isChecked", "getOnCheckedFav", "()Lkotlin/jvm/functions/Function2;", "setOnCheckedFav", "(Lkotlin/jvm/functions/Function2;)V", "onClickRangeIcon", "getOnClickRangeIcon", "setOnClickRangeIcon", "onClose", "getOnClose", "setOnClose", "onMenu", "getOnMenu", "setOnMenu", "privacyIcon", "rangeIcon", "recyclerViewContainer", "Landroid/widget/FrameLayout;", "snsIcon", "initWithGalleryType", "needAction", "relayoutDateRecyclerView", "relayoutProfileRecyclerView", "relayoutSelfFavBtn", "removeUser", "userIndex", "setScrollOffset", "position", "offset", "", "setShowClose", "setUserList", "userList", "", "showFavoriteIcon", "isShow", "showPrivacyIcon", "showRangeIcon", "showSnsIcon", "toggleActiveState", "active", "updateFavCheckedStatus", "Companion", "plugin-story_release"})
public final class GalleryVerticalControlView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.GalleryVerticalControlView";
  public static final GalleryVerticalControlView.a zMe;
  private String iEB;
  final FrameLayout ijB;
  final ImageView wBW;
  final ImageView xEn;
  private final ImageView zKL;
  final ImageView zLP;
  final ImageView zLQ;
  final RecyclerView zLR;
  private final View zLS;
  final ImageView zLT;
  final CheckBox zLU;
  n.a zLV;
  d<?> zLW;
  AvatarLayoutManager zLX;
  private m<? super CompoundButton, ? super Boolean, y> zLY;
  private d.g.a.a<y> zLZ;
  private d.g.a.a<y> zMa;
  private d.g.a.a<y> zMb;
  m<? super CompoundButton, ? super Boolean, y> zMc;
  private d.g.a.a<y> zMd;
  
  static
  {
    AppMethodBeat.i(120392);
    zMe = new GalleryVerticalControlView.a((byte)0);
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
    this.zLY = ((m)new b(this));
    View.inflate(paramContext, 2131495723, (ViewGroup)this);
    paramAttributeSet = findViewById(2131305420);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_close)");
    this.zLP = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305439);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_privacy)");
    this.zKL = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305418);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_avatar_recycler)");
    this.zLR = ((RecyclerView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305419);
    k.g(paramAttributeSet, "findViewById(R.id.story_…vatar_recycler_container)");
    this.ijB = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = findViewById(2131305435);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_menu)");
    this.xEn = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305444);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_sns)");
    this.zLQ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305417);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_all_fav)");
    this.zLT = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131305433);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_item_status_group)");
    this.zLS = paramAttributeSet;
    paramAttributeSet = findViewById(2131305443);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_select_fav)");
    this.zLU = ((CheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(2131305440);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_range)");
    this.wBW = ((ImageView)paramAttributeSet);
    this.zLR.setItemAnimator(null);
    this.xEn.setImageDrawable(am.k(paramContext, 2131690436, -1));
    this.zLT.setImageDrawable(am.k(paramContext, 2131690380, -1));
    this.zLP.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120379);
        paramAnonymousView = this.zMf.getOnClose();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(120379);
          return;
        }
        AppMethodBeat.o(120379);
      }
    });
    this.xEn.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120380);
        paramAnonymousView = this.zMf.getOnMenu();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(120380);
          return;
        }
        AppMethodBeat.o(120380);
      }
    });
    this.zLT.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(120381);
        paramAnonymousView = this.zMf.getOnAllFav();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(120381);
          return;
        }
        AppMethodBeat.o(120381);
      }
    });
    paramAttributeSet = this.zLU;
    paramContext = this.zMc;
    if (paramContext != null) {
      paramContext = new h(paramContext);
    }
    for (;;)
    {
      paramAttributeSet.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)paramContext);
      this.wBW.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(120382);
          paramAnonymousView = this.zMf.getOnClickRangeIcon();
          if (paramAnonymousView != null)
          {
            paramAnonymousView.invoke();
            AppMethodBeat.o(120382);
            return;
          }
          AppMethodBeat.o(120382);
        }
      });
      AppMethodBeat.o(120390);
      return;
    }
  }
  
  public final String getChatRoom()
  {
    return this.iEB;
  }
  
  public final d.g.a.a<y> getOnAllFav()
  {
    return this.zMb;
  }
  
  public final m<CompoundButton, Boolean, y> getOnCheckedFav()
  {
    return this.zMc;
  }
  
  public final d.g.a.a<y> getOnClickRangeIcon()
  {
    return this.zMd;
  }
  
  public final d.g.a.a<y> getOnClose()
  {
    return this.zLZ;
  }
  
  public final d.g.a.a<y> getOnMenu()
  {
    return this.zMa;
  }
  
  public final void rR(boolean paramBoolean)
  {
    AppMethodBeat.i(120387);
    if (paramBoolean)
    {
      this.zKL.setVisibility(0);
      this.zKL.setImageDrawable(am.k(getContext(), 2131690423, getResources().getColor(2131100987)));
      AppMethodBeat.o(120387);
      return;
    }
    this.zKL.setVisibility(8);
    AppMethodBeat.o(120387);
  }
  
  public final void rS(boolean paramBoolean)
  {
    AppMethodBeat.i(120388);
    if ((paramBoolean) && (com.tencent.mm.plugin.story.c.a.a.zqB.dUG()))
    {
      this.zKL.setVisibility(0);
      this.zKL.setImageDrawable(am.k(getContext(), 2131690480, getResources().getColor(2131100987)));
      AppMethodBeat.o(120388);
      return;
    }
    this.zKL.setVisibility(8);
    AppMethodBeat.o(120388);
  }
  
  public final void rT(boolean paramBoolean)
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
    this.iEB = paramString;
    d locald = this.zLW;
    Object localObject = locald;
    if (!(locald instanceof b)) {
      localObject = null;
    }
    localObject = (b)localObject;
    if (localObject != null) {
      ((b)localObject).iEB = paramString;
    }
  }
  
  public final void setOnAllFav(d.g.a.a<y> parama)
  {
    this.zMb = parama;
  }
  
  public final void setOnCheckedFav(m<? super CompoundButton, ? super Boolean, y> paramm)
  {
    this.zMc = paramm;
  }
  
  public final void setOnClickRangeIcon(d.g.a.a<y> parama)
  {
    this.zMd = parama;
  }
  
  public final void setOnClose(d.g.a.a<y> parama)
  {
    this.zLZ = parama;
  }
  
  public final void setOnMenu(d.g.a.a<y> parama)
  {
    this.zMa = parama;
  }
  
  public final void setUserList(List<String> paramList)
  {
    AppMethodBeat.i(120386);
    k.h(paramList, "userList");
    d locald = this.zLW;
    if (locald != null)
    {
      k.h(paramList, "users");
      locald.dataList.clear();
      locald.dataList.add("");
      locald.dataList.addAll((Collection)paramList);
      locald.dataList.add("");
    }
    paramList = this.zLW;
    if (paramList != null)
    {
      paramList.notifyDataSetChanged();
      AppMethodBeat.o(120386);
      return;
    }
    AppMethodBeat.o(120386);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "checkBox", "Landroid/widget/CompoundButton;", "isChecked", "", "invoke", "(Landroid/widget/CompoundButton;Z)Lkotlin/Unit;"})
  static final class b
    extends d.g.b.l
    implements m<CompoundButton, Boolean, y>
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