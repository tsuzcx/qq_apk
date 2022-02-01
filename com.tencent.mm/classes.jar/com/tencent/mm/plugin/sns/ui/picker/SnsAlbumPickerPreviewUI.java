package com.tencent.mm.plugin.sns.ui.picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI;
import com.tencent.mm.plugin.sns.ui.SnsInfoFlip;
import com.tencent.mm.plugin.sns.ui.SnsInfoFlip.b;
import com.tencent.mm.plugin.sns.ui.ab;
import com.tencent.mm.plugin.sns.ui.z.a;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerPreviewUI;", "Lcom/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI;", "()V", "mActionBarLayout", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "getMActionBarLayout", "()Landroid/widget/RelativeLayout;", "mActionBarLayout$delegate", "Lkotlin/Lazy;", "mBackBtn", "Landroid/widget/LinearLayout;", "getMBackBtn", "()Landroid/widget/LinearLayout;", "mBackBtn$delegate", "mBottomBar", "getMBottomBar", "mBottomBar$delegate", "mCurrentMediaId", "", "mCurrentPageTitle", "mIsHideTopBottom", "", "mIsSelf", "mItemPosition", "", "mLayoutContent", "getMLayoutContent", "mLayoutContent$delegate", "mNextButton", "Landroid/widget/Button;", "getMNextButton", "()Landroid/widget/Button;", "mNextButton$delegate", "mPageTitleTv", "Landroid/widget/TextView;", "getMPageTitleTv", "()Landroid/widget/TextView;", "mPageTitleTv$delegate", "mScene", "mSelectButton", "Landroid/widget/ImageButton;", "getMSelectButton", "()Landroid/widget/ImageButton;", "mSelectButton$delegate", "mSelectLimitCount", "mSelectTv", "getMSelectTv", "mSelectTv$delegate", "mSelectedMediaObjIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMSelectedMediaObjIdList", "()Ljava/util/ArrayList;", "mSelectedMediaObjIdList$delegate", "mUserName", "changeSelectState", "", "mediaObjId", "mediaObjIdList", "", "getCheckBoxSelectedResource", "isSelected", "getCurrentPageTitleText", "getLayoutId", "getNextButtonText", "selectedCount", "handlerIntentData", "hideStatusBar", "toHide", "initActionBar", "initBackButton", "initFlipView", "initNextButton", "initSelectArea", "initViews", "isMediaObjSelected", "mediaObjList", "notifyData", "reset", "localId", "opType", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onStart", "onStop", "onUpdateTitle", "title", "subTitle", "setActionBarLayoutVisibility", "visible", "setFooterVisibility", "setTitleFooterInVisible", "inVisible", "updateCurrentPageTitleText", "text", "updateNextButton", "content", "isEnable", "updateSelectButtonState", "toSelect", "updateSelectData", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsAlbumPickerPreviewUI
  extends SnsBaseGalleryUI
{
  public static final SnsAlbumPickerPreviewUI.a RSa;
  private final j CAI;
  private String QcW;
  private final j RSb;
  private final j RSc;
  private final j RSd;
  private final j RSe;
  private final j RSf;
  private final j RSg;
  private final j RSh;
  private final j RSi;
  private int RSj;
  private boolean RSk;
  private String RSl;
  private int RSm;
  private boolean RdS;
  private String luk;
  private int mScene;
  
  static
  {
    AppMethodBeat.i(308746);
    RSa = new SnsAlbumPickerPreviewUI.a((byte)0);
    AppMethodBeat.o(308746);
  }
  
  public SnsAlbumPickerPreviewUI()
  {
    AppMethodBeat.i(308642);
    this.RSb = k.cm((kotlin.g.a.a)new f(this));
    this.RSc = k.cm((kotlin.g.a.a)new i(this));
    this.RSd = k.cm((kotlin.g.a.a)new j(this));
    this.RSe = k.cm((kotlin.g.a.a)new e(this));
    this.RSf = k.cm((kotlin.g.a.a)new c(this));
    this.RSg = k.cm((kotlin.g.a.a)new h(this));
    this.CAI = k.cm((kotlin.g.a.a)new d(this));
    this.RSh = k.cm((kotlin.g.a.a)new g(this));
    this.RSi = k.cm((kotlin.g.a.a)SnsAlbumPickerPreviewUI.k.RSo);
    this.luk = "";
    this.RdS = true;
    this.QcW = "";
    this.RSl = "--/--";
    this.RSm = -1;
    AppMethodBeat.o(308642);
  }
  
  private void Ew(boolean paramBoolean)
  {
    AppMethodBeat.i(308668);
    if (paramBoolean) {}
    for (int i = Ex(true);; i = Ex(false))
    {
      ImageButton localImageButton = hrB();
      if (localImageButton != null) {
        localImageButton.setImageResource(i);
      }
      AppMethodBeat.o(308668);
      return;
    }
  }
  
  private static int Ex(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b.i.checkbox_selected_orange;
    }
    return b.i.radio_off;
  }
  
  private void K(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(308665);
    s.u(paramString, "mediaObjId");
    s.u(paramList, "mediaObjIdList");
    if (L(paramString, paramList))
    {
      Ew(false);
      c(paramString, false, paramList);
      bbk(amz(hrF().size()));
      AppMethodBeat.o(308665);
      return;
    }
    Ew(true);
    c(paramString, true, paramList);
    bbk(amz(hrF().size()));
    AppMethodBeat.o(308665);
  }
  
  private static boolean L(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(308687);
    s.u(paramString, "mediaObjId");
    s.u(paramList, "mediaObjList");
    boolean bool = paramList.contains(paramString);
    AppMethodBeat.o(308687);
    return bool;
  }
  
  private static final void a(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI, View paramView)
  {
    AppMethodBeat.i(308697);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramSnsAlbumPickerPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSnsAlbumPickerPreviewUI, "this$0");
    paramSnsAlbumPickerPreviewUI.K(paramSnsAlbumPickerPreviewUI.QcW, (List)paramSnsAlbumPickerPreviewUI.hrF());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(308697);
  }
  
  private static final void a(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI, dmz paramdmz, int paramInt, String paramString)
  {
    AppMethodBeat.i(308725);
    s.u(paramSnsAlbumPickerPreviewUI, "this$0");
    paramString = paramdmz.Id;
    s.s(paramString, "media.Id");
    paramSnsAlbumPickerPreviewUI.Ew(L(paramString, (List)paramSnsAlbumPickerPreviewUI.hrF()));
    paramSnsAlbumPickerPreviewUI.RSl = (paramInt + 1 + '/' + paramSnsAlbumPickerPreviewUI.RnH.getCount());
    paramSnsAlbumPickerPreviewUI.mV(paramSnsAlbumPickerPreviewUI.RSl, "");
    paramdmz = paramdmz.Id;
    s.s(paramdmz, "media.Id");
    paramSnsAlbumPickerPreviewUI.QcW = paramdmz;
    AppMethodBeat.o(308725);
  }
  
  private final String amz(int paramInt)
  {
    AppMethodBeat.i(308681);
    if (paramInt > 0)
    {
      str = getContext().getResources().getString(b.j.app_nextstep) + '(' + paramInt + '/' + this.RSm + ')';
      AppMethodBeat.o(308681);
      return str;
    }
    String str = getContext().getResources().getString(b.j.app_nextstep);
    s.s(str, "context.resources.getString(R.string.app_nextstep)");
    AppMethodBeat.o(308681);
    return str;
  }
  
  private static final void b(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI, View paramView)
  {
    AppMethodBeat.i(308704);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramSnsAlbumPickerPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSnsAlbumPickerPreviewUI, "this$0");
    paramSnsAlbumPickerPreviewUI.K(paramSnsAlbumPickerPreviewUI.QcW, (List)paramSnsAlbumPickerPreviewUI.hrF());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(308704);
  }
  
  private final void bbk(String paramString)
  {
    AppMethodBeat.i(308676);
    Button localButton = hrE();
    if (localButton != null)
    {
      localButton.setEnabled(true);
      localButton.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(308676);
  }
  
  private static final void c(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI, View paramView)
  {
    AppMethodBeat.i(308712);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramSnsAlbumPickerPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSnsAlbumPickerPreviewUI, "this$0");
    if (paramSnsAlbumPickerPreviewUI.hrF().isEmpty()) {
      paramSnsAlbumPickerPreviewUI.K(paramSnsAlbumPickerPreviewUI.QcW, (List)paramSnsAlbumPickerPreviewUI.hrF());
    }
    paramView = new Intent();
    paramView.putExtra("sns_album_select_mediaobj_id_list", (Serializable)paramSnsAlbumPickerPreviewUI.hrF());
    paramSnsAlbumPickerPreviewUI.setResult(-1, paramView);
    paramSnsAlbumPickerPreviewUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(308712);
  }
  
  private static void c(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(308694);
    s.u(paramString, "mediaObjId");
    s.u(paramList, "mediaObjIdList");
    if (paramBoolean)
    {
      if (paramList.contains(paramString))
      {
        if (paramList.remove(paramString))
        {
          paramList.add(paramString);
          AppMethodBeat.o(308694);
        }
      }
      else
      {
        paramList.add(paramString);
        AppMethodBeat.o(308694);
      }
    }
    else if (paramList.contains(paramString)) {
      paramList.remove(paramString);
    }
    AppMethodBeat.o(308694);
  }
  
  private static final void d(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI, View paramView)
  {
    AppMethodBeat.i(308720);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramSnsAlbumPickerPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSnsAlbumPickerPreviewUI, "this$0");
    paramSnsAlbumPickerPreviewUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(308720);
  }
  
  private final ImageButton hrB()
  {
    AppMethodBeat.i(308645);
    ImageButton localImageButton = (ImageButton)this.RSc.getValue();
    AppMethodBeat.o(308645);
    return localImageButton;
  }
  
  private final RelativeLayout hrC()
  {
    AppMethodBeat.i(308648);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.RSe.getValue();
    AppMethodBeat.o(308648);
    return localRelativeLayout;
  }
  
  private final RelativeLayout hrD()
  {
    AppMethodBeat.i(308653);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.RSf.getValue();
    AppMethodBeat.o(308653);
    return localRelativeLayout;
  }
  
  private final Button hrE()
  {
    AppMethodBeat.i(308658);
    Button localButton = (Button)this.RSh.getValue();
    AppMethodBeat.o(308658);
    return localButton;
  }
  
  private final ArrayList<String> hrF()
  {
    AppMethodBeat.i(308660);
    ArrayList localArrayList = (ArrayList)this.RSi.getValue();
    AppMethodBeat.o(308660);
    return localArrayList;
  }
  
  public final int getLayoutId()
  {
    return b.g.preview_picker_sns_album_ui_layout;
  }
  
  public final void hf(String paramString, int paramInt)
  {
    AppMethodBeat.i(308817);
    if (this.RnH != null)
    {
      if ((!Util.isNullOrNil(paramString)) && (paramInt != 3)) {
        this.RnH.baF(paramString);
      }
      this.RnH.Ei(true);
    }
    AppMethodBeat.o(308817);
  }
  
  public final void mV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(308815);
    paramString1 = (TextView)this.RSg.getValue();
    if (paramString1 != null) {
      paramString1.setText((CharSequence)this.RSl);
    }
    AppMethodBeat.o(308815);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(308785);
    super.onCreate(paramBundle);
    aw.bW((Activity)this);
    hideTitleView();
    getWindow().addFlags(128);
    this.mScene = getIntent().getIntExtra("sns_video_scene", 0);
    String str = getIntent().getStringExtra("sns_gallery_userName");
    paramBundle = str;
    if (str == null)
    {
      paramBundle = z.bAM();
      s.s(paramBundle, "getUsernameFromUserInfo()");
    }
    this.luk = paramBundle;
    getIntent().getIntExtra("sns_gallery_localId", 0);
    this.RdS = getIntent().getBooleanExtra("sns_gallery_is_self", false);
    this.RSj = getIntent().getIntExtra("sns_gallery_position", 0);
    this.RSm = getIntent().getIntExtra("sns_album_select_limit_count", 9);
    paramBundle = getIntent().getStringArrayListExtra("sns_album_select_mediaobj_id_list");
    if (paramBundle == null) {}
    for (paramBundle = (List)new ArrayList();; paramBundle = (List)paramBundle)
    {
      hrF().addAll((Collection)paramBundle);
      enableOptionMenu(true);
      AppMethodBeat.o(308785);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(308811);
    getWindow().clearFlags(128);
    al.hgy().bq((Activity)this);
    super.onDestroy();
    AppMethodBeat.o(308811);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(308798);
    super.onResume();
    SnsInfoFlip localSnsInfoFlip;
    if (this.RnH != null)
    {
      dmz localdmz = this.RnH.getCntMedia();
      localSnsInfoFlip = this.RnH;
      if ((localdmz == null) || (localdmz.vhJ != 6)) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      localSnsInfoFlip.Ei(bool);
      AppMethodBeat.o(308798);
      return;
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(308793);
    super.onStart();
    Object localObject = new SnsInfoFlip((Context)this);
    ((SnsInfoFlip)localObject).setVideoScene(this.mScene);
    ((SnsInfoFlip)localObject).setNeedOCRImg(false);
    ((SnsInfoFlip)localObject).setNeedScanImage(false);
    ((SnsInfoFlip)localObject).setNeedTranslationImg(false);
    ((SnsInfoFlip)localObject).setShowTitle(false);
    ((SnsInfoFlip)localObject).setEnableHorLongBmpMode(false);
    ((SnsInfoFlip)localObject).setUIFromScene(getIntent().getIntExtra("key_from_scene", 0));
    ((SnsInfoFlip)localObject).setFromScene(br.jbj());
    ((SnsInfoFlip)localObject).username = this.luk;
    ah localah = ah.aiuX;
    this.RnH = ((SnsInfoFlip)localObject);
    localObject = al.hgr().aYA(this.luk);
    if (localObject == null) {}
    for (localObject = (List)new ArrayList();; localObject = (List)localObject)
    {
      this.RnH.a((List)localObject, this.luk, this.RSj, (ab)this.RnC, (z.a)this);
      this.RnH.setOnPageSelectListener((SnsInfoFlip.b)this);
      addView((View)this.RnH);
      localObject = (MMViewPager.f)new b(this);
      if (this.RnH != null) {
        this.RnH.getGallery().setSingleClickOverListener((MMViewPager.f)localObject);
      }
      a(new SnsAlbumPickerPreviewUI..ExternalSyntheticLambda4(this));
      localObject = (TextView)this.RSd.getValue();
      if (localObject != null) {
        ((TextView)localObject).setOnClickListener(new SnsAlbumPickerPreviewUI..ExternalSyntheticLambda1(this));
      }
      localObject = hrB();
      if (localObject != null) {
        ((ImageButton)localObject).setOnClickListener(new SnsAlbumPickerPreviewUI..ExternalSyntheticLambda3(this));
      }
      setActionbarColor(getResources().getColor(b.c.gallery_dark_mode_color));
      localObject = hrE();
      if (localObject != null)
      {
        ((Button)localObject).setText((CharSequence)amz(hrF().size()));
        ((Button)localObject).setContentDescription(hrE().getText());
        ((Button)localObject).setOnClickListener(new SnsAlbumPickerPreviewUI..ExternalSyntheticLambda2(this));
      }
      localObject = (LinearLayout)this.CAI.getValue();
      if (localObject != null) {
        ((LinearLayout)localObject).setOnClickListener(new SnsAlbumPickerPreviewUI..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(308793);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(308805);
    super.onStop();
    AppMethodBeat.o(308805);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerPreviewUI$initFlipView$2", "Lcom/tencent/mm/ui/base/MMViewPager$SingleClickOverListener;", "exitDirectly", "", "singleClickOver", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements MMViewPager.f
  {
    b(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI) {}
    
    public final void fBN() {}
    
    public final void singleClickOver()
    {
      AppMethodBeat.i(308654);
      SnsAlbumPickerPreviewUI localSnsAlbumPickerPreviewUI = this.RSn;
      if (!SnsAlbumPickerPreviewUI.a(this.RSn)) {}
      for (boolean bool = true;; bool = false)
      {
        SnsAlbumPickerPreviewUI.a(localSnsAlbumPickerPreviewUI, bool);
        SnsAlbumPickerPreviewUI.b(this.RSn, SnsAlbumPickerPreviewUI.a(this.RSn));
        AppMethodBeat.o(308654);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    c(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    d(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    e(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    f(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<Button>
  {
    g(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TextView>
  {
    h(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageButton;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ImageButton>
  {
    i(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<TextView>
  {
    j(SnsAlbumPickerPreviewUI paramSnsAlbumPickerPreviewUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.SnsAlbumPickerPreviewUI
 * JD-Core Version:    0.7.0.1
 */