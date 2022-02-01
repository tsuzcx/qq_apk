package com.tencent.mm.plugin.mv.ui.view;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.l;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.l.c;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.plugin.gallery.model.r;
import com.tencent.mm.plugin.gallery.model.r.a;
import com.tencent.mm.plugin.gallery.model.r.c;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.flex.a.c;
import com.tencent.mm.plugin.mv.ui.MusicMvAlbumPreviewUI;
import com.tencent.mm.plugin.mv.ui.adapter.b.c.a;
import com.tencent.mm.plugin.mv.ui.adapter.b.c.b;
import com.tencent.mm.plugin.mv.ui.adapter.b.d;
import com.tencent.mm.plugin.mv.ui.uic.j;
import com.tencent.mm.plugin.mv.ui.uic.l;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.protocal.protobuf.egy;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.protocal.protobuf.eww;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView$FTSSearchViewListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activity", "Lcom/tencent/mm/ui/MMActivity;", "adapter", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter;", "albumChooseRV", "Landroidx/recyclerview/widget/RecyclerView;", "checkMediaStorage", "", "checkStatusJob", "Lkotlinx/coroutines/Job;", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "finderChooseRL", "finderMainView", "firstVisibleItem", "flexHeight", "fragmentItemClickedListener", "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentItemClickedListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentItemClickedListener$1;", "fragmentResultListener", "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentResultListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentResultListener$1;", "isChangingMode", "isEnableTouch", "isMinMode", "jumpToRecordNew", "lastVisibleItem", "listener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$IChoosePanelActionListener;", "loadingState", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$LoadingState;", "loadingView", "Landroid/widget/LinearLayout;", "mOnCameraOpen", "mOnItemClickListener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$OnItemClickListener;", "mQueryTicket", "", "maxHeight", "minHeight", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "myFavLL", "myIntroduceLL", "myLikeLL", "myPostLL", "noResultView", "Landroid/widget/TextView;", "onFlingListener", "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$onFlingListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$onFlingListener$1;", "pagerFragmentFav", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyFavFragment;", "pagerFragmentLike", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyLikeFragment;", "pagerFragmentMachine", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMachineFragment;", "pagerFragmentPost", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabMyPostFragment;", "querySource", "queryType", "reportClickCamera", "root", "screenWidth", "searchBar", "searchPanel", "searchResultPanel", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabSearchFragment;", "searchView", "Lcom/tencent/mm/plugin/mv/ui/view/FTSSearchNoActionBarView;", "selectLimit", "startPerformance", "state", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "tabSelectedListener", "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$tabSelectedListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$tabSelectedListener$1;", "tipDialog", "Landroid/app/ProgressDialog;", "titleTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "titles", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "updateMediaItemCheckedStatus", "Lkotlin/Function0;", "", "videoMaxDuration", "videoMinDuration", "addChoosePanelActionListener", "clearEditFocus", "disableTouch", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "enableTouch", "fillFinderFragmentPreviewList", "Lcom/tencent/mm/protocal/protobuf/PreviewItemList;", "fragment", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "fillPreviewItemObj", "Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "clickItemId", "clickListId", "filterNonExistMedia", "mediaItems", "", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "generateOneQueryTicket", "hideSearchResultPanel", "init", "initAlbumChooseArea", "initContentView", "initEditView", "initFinderBtnArea", "initFinderChooseArea", "initQueryInfo", "initSearchPanel", "initSearchView", "initTitleArea", "initView", "isFlexMode", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onFlexItemRemoved", "type", "uniqueId", "(ILjava/lang/Long;)V", "onHeaderClick", "position", "itemView", "itemViewType", "onMediaClick", "onModeChanged", "change2Min", "onAnimationUpdate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "afterModeChanged", "onPause", "onPreviewBack", "uniqueIdList", "onQueryMediaFinished", "Ljava/util/LinkedList;", "ticket", "isFirstNotify", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSearchKeyDown", "onSwitchFixMode", "onSwitchFlexMode", "onTagClick", "index", "tag", "onTakePhotoFinished", "queryMedia", "queryMediaIncrement", "queryVideo", "refreshSearchView", "showPagerFragment", "showSearchResultPanel", "showVKB", "startSearch", "query", "updateTextColor", "updateVideoMinDuration", "isFlex", "minDuration", "updateViewHeight", "fromHeight", "toHeight", "withAnimation", "onAnimationEnd", "Companion", "IChoosePanelActionListener", "LoadingState", "NotifyMediaItemsChanged", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMVCardChooseView
  extends RelativeLayout
  implements l.c, FTSSearchNoActionBarView.b, FTSEditTextView.c
{
  public static int MhS;
  private static int MhT;
  public static final MusicMVCardChooseView.a Mho;
  private static long start;
  private TextView BnA;
  private boolean GFm;
  private int GzH;
  public boolean HMB;
  private int HMD;
  private int HMI;
  public int HMO;
  private boolean HMP;
  private volatile long HMR;
  private r.c HMZ;
  public com.tencent.mm.plugin.music.model.e.a LMB;
  public boolean LPC;
  private final b.d MaM;
  private LinearLayout MhA;
  private LinearLayout MhB;
  private LinearLayout MhC;
  public MusicMvTabMachineFragment MhD;
  public MusicMvTabMyPostFragment MhE;
  public MusicMvTabMyFavFragment MhF;
  public MusicMvTabMyLikeFragment MhG;
  private final k MhH;
  public b MhI;
  private final ArrayList<String> MhJ;
  public final p MhK;
  private final e MhL;
  private final f MhM;
  private volatile MusicMVCardChooseView.c MhN;
  public int MhO;
  private boolean MhP;
  private cb MhQ;
  private final kotlin.g.a.a<ah> MhR;
  public TabLayout Mhp;
  private RecyclerView Mhq;
  public com.tencent.mm.plugin.mv.ui.adapter.b Mhr;
  private RelativeLayout Mhs;
  private RelativeLayout Mht;
  private WeImageView Mhu;
  private LinearLayout Mhv;
  private FTSSearchNoActionBarView Mhw;
  public MusicMvTabSearchFragment Mhx;
  private LinearLayout Mhy;
  private LinearLayout Mhz;
  public MMActivity activity;
  private int lyw;
  private ProgressDialog lzP;
  public int maxHeight;
  private final int mpb;
  private WeImageView ngN;
  private int qqa;
  public int rIW;
  private int sJv;
  private int uRj;
  private int vBs;
  private boolean xCI;
  
  static
  {
    AppMethodBeat.i(287562);
    Mho = new MusicMVCardChooseView.a((byte)0);
    MhT = 2000;
    AppMethodBeat.o(287562);
  }
  
  public MusicMVCardChooseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(287234);
    AppMethodBeat.o(287234);
  }
  
  public MusicMVCardChooseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(287240);
    this.GFm = true;
    this.MhH = new k(this);
    this.MhJ = p.al(new String[] { getContext().getString(b.h.music_dialog_title_album), getContext().getString(b.h.music_dialog_title_finder) });
    this.MhK = new p(this);
    this.MhL = new e(this);
    this.MhM = new f(this);
    this.MaM = ((b.d)new i(this));
    this.vBs = -1;
    this.uRj = -1;
    this.HMZ = r.c.HIl;
    this.mpb = 27;
    this.HMO = 3;
    this.HMR = -1L;
    this.MhP = true;
    this.MhR = ((kotlin.g.a.a)new MusicMVCardChooseView.q(this));
    AppMethodBeat.o(287240);
  }
  
  private final void YM(int paramInt)
  {
    AppMethodBeat.i(287258);
    TextView localTextView = (TextView)findViewById(b.e.LTY);
    if (localTextView != null) {
      localTextView.setTextColor(getContext().getResources().getColor(b.b.BW_100_Alpha_0_5));
    }
    localTextView = (TextView)findViewById(b.e.LUa);
    if (localTextView != null) {
      localTextView.setTextColor(getContext().getResources().getColor(b.b.BW_100_Alpha_0_5));
    }
    localTextView = (TextView)findViewById(b.e.LTX);
    if (localTextView != null) {
      localTextView.setTextColor(getContext().getResources().getColor(b.b.BW_100_Alpha_0_5));
    }
    localTextView = (TextView)findViewById(b.e.LTZ);
    if (localTextView != null) {
      localTextView.setTextColor(getContext().getResources().getColor(b.b.BW_100_Alpha_0_5));
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(287258);
      return;
      localTextView = (TextView)findViewById(b.e.LTY);
      if (localTextView != null)
      {
        localTextView.setTextColor(getContext().getResources().getColor(b.b.BW_100_Alpha_0_9));
        AppMethodBeat.o(287258);
        return;
        localTextView = (TextView)findViewById(b.e.LUa);
        if (localTextView != null)
        {
          localTextView.setTextColor(getContext().getResources().getColor(b.b.BW_100_Alpha_0_9));
          AppMethodBeat.o(287258);
          return;
          localTextView = (TextView)findViewById(b.e.LTX);
          if (localTextView != null)
          {
            localTextView.setTextColor(getContext().getResources().getColor(b.b.BW_100_Alpha_0_9));
            AppMethodBeat.o(287258);
            return;
            localTextView = (TextView)findViewById(b.e.LTZ);
            if (localTextView != null) {
              localTextView.setTextColor(getContext().getResources().getColor(b.b.BW_100_Alpha_0_9));
            }
          }
        }
      }
    }
  }
  
  private static egy a(MusicMvTabFragment paramMusicMvTabFragment)
  {
    AppMethodBeat.i(287335);
    kotlin.g.b.s.u(paramMusicMvTabFragment, "fragment");
    egy localegy = new egy();
    localegy.LZD = String.valueOf(paramMusicMvTabFragment.getType());
    paramMusicMvTabFragment = (Iterable)paramMusicMvTabFragment.getAllDataList();
    int i = 0;
    paramMusicMvTabFragment = paramMusicMvTabFragment.iterator();
    if (paramMusicMvTabFragment.hasNext())
    {
      Object localObject1 = paramMusicMvTabFragment.next();
      if (i < 0) {
        p.kkW();
      }
      Object localObject2 = (MusicMvTabFragment.d)localObject1;
      localObject1 = localegy.mew;
      egx localegx = new egx();
      FinderObject localFinderObject = ((MusicMvTabFragment.d)localObject2).MjQ.feedObject;
      if (localFinderObject == null) {}
      for (long l = 0L;; l = localFinderObject.id)
      {
        localegx.id = com.tencent.mm.ae.d.hF(l);
        localegx.EDa = ((MusicMvTabFragment.d)localObject2).MjQ.feedObject;
        localegx.type = 3;
        localObject2 = ah.aiuX;
        ((LinkedList)localObject1).add(localegx);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(287335);
    return localegy;
  }
  
  private final void a(int paramInt1, int paramInt2, boolean paramBoolean, kotlin.g.a.b<? super Float, ah> paramb, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(287310);
    View localView = findViewById(b.e.dialog_container);
    if (localView != null)
    {
      if (!paramBoolean)
      {
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = paramInt2;
        ah localah = ah.aiuX;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (paramb != null) {
          paramb.invoke(Float.valueOf(1.0F));
        }
        if (parama != null) {
          parama.invoke();
        }
        AppMethodBeat.o(287310);
        return;
      }
      Object localObject = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
      ((ValueAnimator)localObject).addUpdateListener(new MusicMVCardChooseView..ExternalSyntheticLambda0(localView, paramb, paramInt1, paramInt2));
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new MusicMVCardChooseView.r(parama));
      ((ValueAnimator)localObject).setDuration(300L);
      ((ValueAnimator)localObject).start();
      Log.d("MicroMsg.Mv.MusicMVCardChooseView", "heightAnim start");
    }
    AppMethodBeat.o(287310);
  }
  
  private static final void a(View paramView, kotlin.g.a.b paramb, int paramInt1, int paramInt2, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(287396);
    kotlin.g.b.s.u(paramView, "$animateView");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(287396);
      throw paramView;
    }
    int i = ((Integer)paramValueAnimator).intValue();
    paramValueAnimator = paramView.getLayoutParams();
    paramValueAnimator.height = i;
    ah localah = ah.aiuX;
    paramView.setLayoutParams(paramValueAnimator);
    if (paramb != null) {
      paramb.invoke(Float.valueOf((i - paramInt1) / (paramInt2 - paramInt1)));
    }
    AppMethodBeat.o(287396);
  }
  
  private static final void a(MusicMVCardChooseView paramMusicMVCardChooseView)
  {
    AppMethodBeat.i(287388);
    kotlin.g.b.s.u(paramMusicMVCardChooseView, "this$0");
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onCreate, post delay, dialog show.");
    if (MusicMVCardChooseView.c.MhV != paramMusicMVCardChooseView.MhN)
    {
      paramMusicMVCardChooseView = paramMusicMVCardChooseView.lzP;
      if (paramMusicMVCardChooseView != null) {
        paramMusicMVCardChooseView.show();
      }
    }
    AppMethodBeat.o(287388);
  }
  
  private static final void a(MusicMVCardChooseView paramMusicMVCardChooseView, View paramView)
  {
    AppMethodBeat.i(287338);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMVCardChooseView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramMusicMVCardChooseView, "this$0");
    a(paramMusicMVCardChooseView, true, null, 6);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287338);
  }
  
  private final void a(boolean paramBoolean, kotlin.g.a.b<? super Float, ah> paramb, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(287324);
    Object localObject;
    if ((!this.MhP) && (paramBoolean))
    {
      this.LPC = true;
      Log.i("MicroMsg.Mv.MusicMVCardChooseView", "onModeChanged, change2Min:true, hideSearchResultPanel");
      Log.d("MicroMsg.Mv.MusicMVCardChooseView", "hideSearchResultPanel");
      localObject = this.Mhw;
      if (localObject != null)
      {
        localObject = ((FTSSearchNoActionBarView)localObject).getFtsEditText();
        if (localObject != null) {
          ((FTSEditTextView)localObject).dzv.clearFocus();
        }
      }
      localObject = this.Mhw;
      if (localObject != null)
      {
        localObject = ((FTSSearchNoActionBarView)localObject).getFtsEditText();
        if (localObject != null) {
          ((FTSEditTextView)localObject).hideVKB();
        }
      }
      localObject = this.ngN;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
      localObject = this.Mhp;
      if (localObject != null) {
        ((TabLayout)localObject).animate().translationX(0.0F).setDuration(300L).start();
      }
      a(this.maxHeight, this.rIW, true, paramb, (kotlin.g.a.a)new n(parama, this));
    }
    for (;;)
    {
      this.MhP = paramBoolean;
      AppMethodBeat.o(287324);
      return;
      if ((this.MhP) && (!paramBoolean))
      {
        this.LPC = true;
        Log.i("MicroMsg.Mv.MusicMVCardChooseView", "onModeChanged, change2Min:false");
        int i = this.sJv / 2;
        int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 40);
        localObject = this.ngN;
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
        localObject = this.Mhp;
        if (localObject != null)
        {
          int k = ((TabLayout)localObject).getWidth() / 2;
          ((TabLayout)localObject).animate().translationX((i - j - k) * 1.0F).setDuration(300L).start();
        }
        a(this.rIW, this.maxHeight, true, paramb, (kotlin.g.a.a)new o(parama, this));
      }
      else
      {
        Log.i("MicroMsg.Mv.MusicMVCardChooseView", "onModeChanged, else");
        if (parama != null) {
          parama.invoke();
        }
      }
    }
  }
  
  private final void ael(int paramInt)
  {
    AppMethodBeat.i(287249);
    Object localObject = this.MhD;
    if (localObject != null) {
      ((MusicMvTabMachineFragment)localObject).setVisibility(8);
    }
    localObject = this.MhE;
    if (localObject != null) {
      ((MusicMvTabMyPostFragment)localObject).setVisibility(8);
    }
    localObject = this.MhF;
    if (localObject != null) {
      ((MusicMvTabMyFavFragment)localObject).setVisibility(8);
    }
    localObject = this.MhG;
    if (localObject != null) {
      ((MusicMvTabMyLikeFragment)localObject).setVisibility(8);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(287249);
      return;
      localObject = this.MhD;
      if (localObject != null)
      {
        ((MusicMvTabMachineFragment)localObject).setVisibility(0);
        AppMethodBeat.o(287249);
        return;
        localObject = this.MhE;
        if (localObject != null)
        {
          ((MusicMvTabMyPostFragment)localObject).setVisibility(0);
          AppMethodBeat.o(287249);
          return;
          localObject = this.MhF;
          if (localObject != null)
          {
            ((MusicMvTabMyFavFragment)localObject).setVisibility(0);
            AppMethodBeat.o(287249);
            return;
            localObject = this.MhG;
            if (localObject != null) {
              ((MusicMvTabMyLikeFragment)localObject).setVisibility(0);
            }
          }
        }
      }
    }
  }
  
  private static final void b(MusicMVCardChooseView paramMusicMVCardChooseView, View paramView)
  {
    AppMethodBeat.i(287344);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMVCardChooseView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramMusicMVCardChooseView, "this$0");
    paramMusicMVCardChooseView.grs();
    if (!paramMusicMVCardChooseView.gqh()) {
      a(paramMusicMVCardChooseView, false, (kotlin.g.a.a)new h(paramMusicMVCardChooseView), 2);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287344);
      return;
      paramMusicMVCardChooseView.showVKB();
    }
  }
  
  private static final void c(MusicMVCardChooseView paramMusicMVCardChooseView, View paramView)
  {
    AppMethodBeat.i(287350);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMVCardChooseView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramMusicMVCardChooseView, "this$0");
    paramMusicMVCardChooseView.YM(0);
    paramMusicMVCardChooseView.ael(0);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287350);
  }
  
  private static final void d(MusicMVCardChooseView paramMusicMVCardChooseView, View paramView)
  {
    AppMethodBeat.i(287356);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMVCardChooseView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramMusicMVCardChooseView, "this$0");
    paramMusicMVCardChooseView.YM(1);
    paramMusicMVCardChooseView.ael(1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287356);
  }
  
  private static final void e(MusicMVCardChooseView paramMusicMVCardChooseView, View paramView)
  {
    AppMethodBeat.i(287363);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMVCardChooseView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramMusicMVCardChooseView, "this$0");
    paramMusicMVCardChooseView.YM(2);
    paramMusicMVCardChooseView.ael(2);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287363);
  }
  
  private static final void f(MusicMVCardChooseView paramMusicMVCardChooseView, View paramView)
  {
    AppMethodBeat.i(287370);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMVCardChooseView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramMusicMVCardChooseView, "this$0");
    paramMusicMVCardChooseView.YM(3);
    paramMusicMVCardChooseView.ael(3);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287370);
  }
  
  private final void fBr()
  {
    AppMethodBeat.i(287286);
    com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.nNV).bwi();
    com.tencent.mm.plugin.gallery.a.a.HFE.setScene(this.mpb);
    Log.i("MicroMsg.Mv.MusicMVCardChooseView", "start queryMediaInAlbums %s", new Object[] { this });
    e.fAn().a((l.c)this);
    this.HMR = System.currentTimeMillis();
    e.fAn().aI("", this.HMR);
    Object localObject = this.Mhq;
    if (localObject != null) {
      ((RecyclerView)localObject).postDelayed(new MusicMVCardChooseView..ExternalSyntheticLambda8(this), 300L);
    }
    localObject = r.HIe;
    r.fAT().a((com.tencent.mm.plugin.gallery.model.m)new o());
    localObject = r.HIe;
    r.fAT().a((com.tencent.mm.plugin.gallery.model.m)new com.tencent.mm.plugin.gallery.model.s());
    AppMethodBeat.o(287286);
  }
  
  private static final void g(MusicMVCardChooseView paramMusicMVCardChooseView, View paramView)
  {
    AppMethodBeat.i(287380);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMVCardChooseView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramMusicMVCardChooseView, "this$0");
    if ((!paramMusicMVCardChooseView.gqh()) && (paramMusicMVCardChooseView.MhP)) {
      a(paramMusicMVCardChooseView, false, null, 6);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287380);
  }
  
  private final boolean gqh()
  {
    AppMethodBeat.i(287301);
    Object localObject = k.aeZF;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    boolean bool = ((j)k.nq((Context)localObject).q(j.class)).gqh();
    AppMethodBeat.o(287301);
    return bool;
  }
  
  private final void grr()
  {
    int j = 1;
    AppMethodBeat.i(287268);
    Object localObject = this.Mhs;
    if ((localObject != null) && (((RelativeLayout)localObject).getVisibility() == 0))
    {
      i = 1;
      if (i == 0) {
        break label85;
      }
      localObject = this.Mhv;
      if ((localObject == null) || (((LinearLayout)localObject).getVisibility() != 8)) {
        break label80;
      }
    }
    label80:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label85;
      }
      localObject = this.Mhu;
      if (localObject == null) {
        break label99;
      }
      ((WeImageView)localObject).setVisibility(0);
      AppMethodBeat.o(287268);
      return;
      i = 0;
      break;
    }
    label85:
    localObject = this.Mhu;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(4);
    }
    label99:
    AppMethodBeat.o(287268);
  }
  
  private final void grs()
  {
    AppMethodBeat.i(287274);
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "showSearchResultPanel");
    Object localObject = this.Mhw;
    if (localObject != null)
    {
      localObject = ((FTSSearchNoActionBarView)localObject).getFtsEditText();
      if (localObject != null) {
        ((FTSEditTextView)localObject).iCF();
      }
    }
    localObject = this.Mhx;
    if (localObject != null) {
      ((MusicMvTabSearchFragment)localObject).clear();
    }
    localObject = this.Mhv;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(0);
    }
    localObject = this.Mht;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(8);
    }
    grr();
    AppMethodBeat.o(287274);
  }
  
  private final void gru()
  {
    AppMethodBeat.i(287292);
    e.fAn().sfB = this.mpb;
    e.fAn().setQueryType(this.HMO);
    Log.i("MicroMsg.Mv.MusicMVCardChooseView", "query source: " + this.mpb + ", queryType: " + this.HMO);
    AppMethodBeat.o(287292);
  }
  
  private static void ie(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(287297);
    long l = System.currentTimeMillis();
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "filterNonExistMedia size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (!y.ZC(localMediaItem.Gcc))
      {
        Log.w("MicroMsg.Mv.MusicMVCardChooseView", "filter non exist media: %s.", new Object[] { localMediaItem.Gcc });
        ((LinkedList)localObject).add(localMediaItem);
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.remove((GalleryItem.MediaItem)((Iterator)localObject).next());
    }
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "filterNonExistMedia cost: %s.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(287297);
  }
  
  private final void showVKB()
  {
    AppMethodBeat.i(287279);
    Object localObject = this.Mhw;
    if (localObject != null)
    {
      localObject = ((FTSSearchNoActionBarView)localObject).getFtsEditText();
      if (localObject != null) {
        ((FTSEditTextView)localObject).aWT();
      }
    }
    localObject = this.Mhw;
    if (localObject != null)
    {
      localObject = ((FTSSearchNoActionBarView)localObject).getFtsEditText();
      if (localObject != null) {
        ((FTSEditTextView)localObject).showVKB();
      }
    }
    AppMethodBeat.o(287279);
  }
  
  public final boolean aWU()
  {
    AppMethodBeat.i(287658);
    Object localObject1 = this.Mhw;
    if (localObject1 == null) {
      localObject1 = "";
    }
    while (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(287658);
      return true;
      localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject1 = ((FTSEditTextView)localObject1).getTotalQuery();
        if (localObject1 == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = n.bq((CharSequence)localObject1).toString();
          if (localObject1 == null) {
            localObject1 = "";
          }
        }
      }
    }
    Object localObject2 = (MusicMvTabFragment)this.Mhx;
    if (localObject2 != null) {
      ((MusicMvTabFragment)localObject2).setResultView(8);
    }
    localObject2 = this.BnA;
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(8);
    }
    localObject2 = this.Mhy;
    if (localObject2 != null) {
      ((LinearLayout)localObject2).setVisibility(0);
    }
    localObject2 = this.Mhx;
    if (localObject2 != null) {
      ((MusicMvTabSearchFragment)localObject2).aPI((String)localObject1);
    }
    localObject1 = this.Mhw;
    if (localObject1 != null)
    {
      localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
      if (localObject1 != null) {
        ((FTSEditTextView)localObject1).hideVKB();
      }
    }
    AppMethodBeat.o(287658);
    return true;
  }
  
  public final void ae(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(287614);
    if (!paramBoolean) {
      MhS = paramInt;
    }
    for (;;)
    {
      Object localObject = this.Mhr;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mv.ui.adapter.b)localObject).setVideoDuration(paramInt);
      }
      localObject = this.MhD;
      if (localObject != null) {
        ((MusicMvTabMachineFragment)localObject).setVideoDuration(paramInt);
      }
      localObject = this.MhE;
      if (localObject != null) {
        ((MusicMvTabMyPostFragment)localObject).setVideoDuration(paramInt);
      }
      localObject = this.MhF;
      if (localObject != null) {
        ((MusicMvTabMyFavFragment)localObject).setVideoDuration(paramInt);
      }
      localObject = this.MhG;
      if (localObject != null) {
        ((MusicMvTabMyLikeFragment)localObject).setVideoDuration(paramInt);
      }
      localObject = this.Mhx;
      if (localObject != null) {
        ((MusicMvTabSearchFragment)localObject).setVideoDuration(paramInt);
      }
      AppMethodBeat.o(287614);
      return;
      MhT = paramInt;
    }
  }
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(287705);
    if (paramLong != this.HMR)
    {
      Log.w("MicroMsg.Mv.MusicMVCardChooseView", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.HMR) });
      Log.w("MicroMsg.Mv.MusicMVCardChooseView", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(287705);
      return;
    }
    if (paramLinkedList == null)
    {
      Log.e("MicroMsg.Mv.MusicMVCardChooseView", "onQueryMediaFinished, null == mediaItems");
      AppMethodBeat.o(287705);
      return;
    }
    Object localObject = this.Mhr;
    if (localObject == null)
    {
      localObject = null;
      Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onQueryMediaFinished: %s %s %s.", new Object[] { Boolean.valueOf(paramBoolean), localObject, Integer.valueOf(paramLinkedList.size()) });
      localObject = this.Mhr;
      if (localObject != null)
      {
        if ((!paramBoolean) && (((com.tencent.mm.plugin.mv.ui.adapter.b)localObject).MaJ.size() <= paramLinkedList.size())) {
          break label379;
        }
        ie((List)paramLinkedList);
        label169:
        localObject = this.MhI;
        if (localObject != null) {
          ((b)localObject).bI(new LinkedList((Collection)paramLinkedList));
        }
        paramLinkedList = new LinkedList((Collection)paramLinkedList);
        if (this.Mhr != null) {
          break label413;
        }
      }
    }
    label413:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Mv.MusicMVCardChooseView", "[onQueryMediaFinished] adapter is null?:%s %s", new Object[] { Boolean.valueOf(bool), Util.getStack().toString() });
      if (this.Mhr != null)
      {
        localObject = new d();
        ((d)localObject).HNp = new WeakReference(this.Mhr);
        ((d)localObject).HNq = new WeakReference(this.lzP);
        ((d)localObject).HNs = new WeakReference(this.Mhq);
        ((d)localObject).HNt = paramLinkedList;
        ((d)localObject).HNu = paramBoolean;
        if (MusicMVCardChooseView.c.MhU == this.MhN) {
          this.MhN = MusicMVCardChooseView.c.MhV;
        }
        e.fAo().postToMainThread((Runnable)localObject);
      }
      AppMethodBeat.o(287705);
      return;
      localObject = Integer.valueOf(((com.tencent.mm.plugin.mv.ui.adapter.b)localObject).MaJ.size());
      break;
      label379:
      localObject = paramLinkedList.subList(((com.tencent.mm.plugin.mv.ui.adapter.b)localObject).MaJ.size(), paramLinkedList.size());
      kotlin.g.b.s.s(localObject, "mediaItems.subList(it.mediaCount, mediaItems.size)");
      ie((List)localObject);
      break label169;
    }
  }
  
  public final void cOJ()
  {
    AppMethodBeat.i(287722);
    this.GFm = false;
    Object localObject = this.Mhp;
    if (localObject != null) {
      ((TabLayout)localObject).cx(com.tencent.mm.cd.a.w((Context)this.activity, b.b.BW_100_Alpha_0_2), com.tencent.mm.cd.a.w((Context)this.activity, b.b.BW_100_Alpha_0_5));
    }
    localObject = this.Mhp;
    if (localObject != null) {
      ((TabLayout)localObject).setSelectedTabIndicatorColor(com.tencent.mm.cd.a.w((Context)this.activity, b.b.BW_100_Alpha_0_5));
    }
    localObject = this.Mhu;
    if (localObject != null) {
      ((WeImageView)localObject).F(-1, 0.5F);
    }
    AppMethodBeat.o(287722);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(287713);
    if (this.GFm)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(287713);
      return bool;
    }
    AppMethodBeat.o(287713);
    return true;
  }
  
  public final void eeU() {}
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(287666);
    if (paramBoolean)
    {
      Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onEditTextFocusChange, hasFocus:" + paramBoolean + ", showSearchResultPanel");
      grs();
      if (gqh())
      {
        showVKB();
        AppMethodBeat.o(287666);
        return;
      }
      a(this, false, (kotlin.g.a.a)new j(this), 2);
    }
    AppMethodBeat.o(287666);
  }
  
  public final void grp()
  {
    AppMethodBeat.i(287683);
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onClickBackBtn, hideSearchResultPanel");
    Log.d("MicroMsg.Mv.MusicMVCardChooseView", "hideSearchResultPanel");
    Object localObject = this.Mhw;
    if (localObject != null)
    {
      localObject = ((FTSSearchNoActionBarView)localObject).getFtsEditText();
      if (localObject != null) {
        ((FTSEditTextView)localObject).iCF();
      }
    }
    localObject = this.Mhw;
    if (localObject != null)
    {
      localObject = ((FTSSearchNoActionBarView)localObject).getFtsEditText();
      if (localObject != null) {
        ((FTSEditTextView)localObject).dzv.clearFocus();
      }
    }
    localObject = this.Mhw;
    if (localObject != null)
    {
      localObject = ((FTSSearchNoActionBarView)localObject).getFtsEditText();
      if (localObject != null) {
        ((FTSEditTextView)localObject).hideVKB();
      }
    }
    localObject = this.Mhx;
    if (localObject != null) {
      ((MusicMvTabSearchFragment)localObject).clear();
    }
    localObject = this.Mhv;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    localObject = this.Mht;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(0);
    }
    grr();
    AppMethodBeat.o(287683);
  }
  
  public final void grq()
  {
    AppMethodBeat.i(287623);
    com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.nNV).bwi();
    com.tencent.mm.plugin.gallery.a.a.HFE.setScene(this.mpb);
    Log.i("MicroMsg.Mv.MusicMVCardChooseView", "start queryMediaInAlbums %s", new Object[] { this });
    e.fAn().a((l.c)this);
    this.HMR = System.currentTimeMillis();
    e.fAn().aI("", this.HMR);
    r.a locala = r.HIe;
    r.fAT().a((com.tencent.mm.plugin.gallery.model.m)new o());
    locala = r.HIe;
    r.fAT().a((com.tencent.mm.plugin.gallery.model.m)new com.tencent.mm.plugin.gallery.model.s());
    AppMethodBeat.o(287623);
  }
  
  public final void grt()
  {
    AppMethodBeat.i(287691);
    Object localObject2 = (Activity)this.activity;
    Object localObject1 = this.activity;
    if (localObject1 != null) {
      ((MMActivity)localObject1).getString(b.h.permission_tips_title);
    }
    localObject1 = this.activity;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.HMP = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject2, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, (String)localObject1);
      Log.i("MicroMsg.Mv.MusicMVCardChooseView", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(this.HMP) });
      this.MhN = MusicMVCardChooseView.c.MhU;
      localObject2 = getContext();
      localObject1 = getContext();
      if (localObject1 != null) {
        break label159;
      }
    }
    label159:
    for (localObject1 = null;; localObject1 = ((Context)localObject1).getString(b.h.app_waiting))
    {
      this.lzP = ((ProgressDialog)w.a((Context)localObject2, (CharSequence)localObject1, false));
      gru();
      if (this.HMP) {
        fBr();
      }
      AppMethodBeat.o(287691);
      return;
      localObject1 = ((MMActivity)localObject1).getString(b.h.gallery_permission_msg);
      break;
    }
  }
  
  public final void grv()
  {
    AppMethodBeat.i(287732);
    this.GFm = true;
    Object localObject = this.Mhp;
    if (localObject != null) {
      ((TabLayout)localObject).cx(com.tencent.mm.cd.a.w((Context)this.activity, b.b.BW_100_Alpha_0_5), com.tencent.mm.cd.a.w((Context)this.activity, b.b.BW_100_Alpha_0_9));
    }
    localObject = this.Mhp;
    if (localObject != null) {
      ((TabLayout)localObject).setSelectedTabIndicatorColor(com.tencent.mm.cd.a.w((Context)this.activity, b.b.BW_100_Alpha_0_9));
    }
    localObject = this.Mhu;
    if (localObject != null) {
      ((WeImageView)localObject).F(-1, 1.0F);
    }
    AppMethodBeat.o(287732);
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(287650);
    this.sJv = com.tencent.mm.cd.a.ms(getContext());
    View.inflate(getContext(), b.f.LVn, (ViewGroup)this);
    Object localObject1;
    int k;
    if (com.tencent.mm.plugin.music.model.m.dsS())
    {
      a(this, 0, this.MhO, false, 24);
      localObject1 = (RelativeLayout)findViewById(b.e.LSL);
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setOnClickListener(new MusicMVCardChooseView..ExternalSyntheticLambda6(this));
      }
      this.ngN = ((WeImageView)findViewById(b.e.close_btn));
      localObject1 = this.ngN;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setVisibility(8);
      }
      localObject1 = this.ngN;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setOnClickListener(new MusicMVCardChooseView..ExternalSyntheticLambda1(this));
      }
      this.Mhp = ((TabLayout)findViewById(b.e.LUU));
      localObject1 = this.Mhp;
      if (localObject1 != null) {
        ((TabLayout)localObject1).a((TabLayout.b)this.MhK);
      }
      k = this.MhJ.size();
      if (k <= 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject1 = this.Mhp;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((TabLayout)localObject1).WW();
        if (localObject1 != null)
        {
          localObject2 = this.Mhp;
          if (localObject2 != null) {
            ((TabLayout)localObject2).a((TabLayout.e)localObject1);
          }
        }
      }
      localObject1 = this.Mhp;
      if (localObject1 == null)
      {
        localObject1 = null;
        label246:
        if (localObject1 != null) {
          ((TabLayout.e)localObject1).D((CharSequence)this.MhJ.get(i));
        }
        if (j < k) {
          continue;
        }
        this.xCI = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVi, true);
        this.Mhq = ((RecyclerView)findViewById(b.e.LRO));
        localObject1 = getContext();
        kotlin.g.b.s.s(localObject1, "context");
        this.Mhr = new com.tencent.mm.plugin.mv.ui.adapter.b((Context)localObject1);
        localObject2 = new b.c.a();
        localObject1 = this.Mhr;
        kotlin.g.b.s.checkNotNull(localObject1);
        localObject2 = (b.c.b)localObject2;
        ((com.tencent.mm.plugin.mv.ui.adapter.b)localObject1).HLF.remove(localObject2);
        ((com.tencent.mm.plugin.mv.ui.adapter.b)localObject1).HLF.add(localObject2);
        localObject1 = this.Mhq;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.Mhr);
        }
        localObject1 = this.activity;
        if (localObject1 != null) {
          break label712;
        }
      }
      label712:
      for (localObject1 = null;; localObject1 = ((MMActivity)localObject1).getContext())
      {
        localObject1 = new FirstRowLayoutManager((Context)localObject1, 4);
        localObject2 = this.Mhq;
        if (localObject2 != null) {
          ((RecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject1);
        }
        localObject2 = new com.tencent.mm.plugin.gallery.ui.c.a(getContext()).WM(b.c.music_gallery_item_padding).WL(b.c.music_gallery_item_padding).WK(b.b.gallery_dark_mode_color);
        ((com.tencent.mm.plugin.gallery.ui.c.a)localObject2).HNS = false;
        localObject2 = ((com.tencent.mm.plugin.gallery.ui.c.a)localObject2).fBB();
        Object localObject3 = this.Mhq;
        if (localObject3 != null) {
          ((RecyclerView)localObject3).a((RecyclerView.h)localObject2);
        }
        localObject2 = this.Mhq;
        if (localObject2 != null) {
          ((RecyclerView)localObject2).a((RecyclerView.l)new g(this, (FirstRowLayoutManager)localObject1));
        }
        localObject1 = this.Mhq;
        if (localObject1 != null) {
          ((RecyclerView)localObject1).setOnFlingListener((RecyclerView.j)this.MhH);
        }
        localObject1 = this.Mhr;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mv.ui.adapter.b)localObject1).MaM = this.MaM;
        }
        localObject1 = this.activity;
        if (localObject1 == null) {
          break label781;
        }
        localObject2 = ((MMActivity)localObject1).getIntent().getExtras();
        if (localObject2 == null) {
          break label722;
        }
        localObject3 = ((Bundle)localObject2).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          Log.d("MicroMsg.Mv.MusicMVCardChooseView", "key=%s | value=%s", new Object[] { str, ((Bundle)localObject2).get(str) });
        }
        a(this, 0, this.rIW, false, 24);
        break;
        localObject1 = ((TabLayout)localObject1).js(i);
        break label246;
      }
      label722:
      Log.e("MicroMsg.Mv.MusicMVCardChooseView", "initView, oops! no extras data!");
      this.qqa = ((MMActivity)localObject1).getIntent().getIntExtra("album_video_max_duration", 10);
      this.HMI = ((MMActivity)localObject1).getIntent().getIntExtra("album_video_min_duration", 0);
      this.GzH = ((MMActivity)localObject1).getIntent().getIntExtra("max_select_count", 9);
      label781:
      grt();
      this.Mhs = ((RelativeLayout)findViewById(b.e.LSu));
      localObject1 = this.Mhs;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setVisibility(4);
      }
      this.Mht = ((RelativeLayout)findViewById(b.e.LSv));
      this.Mhu = ((WeImageView)findViewById(b.e.search_bar));
      localObject1 = this.Mhu;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setOnClickListener(new MusicMVCardChooseView..ExternalSyntheticLambda4(this));
      }
      this.Mhw = ((FTSSearchNoActionBarView)findViewById(b.e.search_view));
      localObject1 = this.Mhw;
      if (localObject1 != null) {
        ((FTSSearchNoActionBarView)localObject1).setSearchViewListener((FTSSearchNoActionBarView.b)this);
      }
      localObject1 = this.Mhw;
      if (localObject1 != null)
      {
        localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).setHint(getContext().getString(b.h.app_search));
        }
      }
      localObject1 = this.Mhw;
      if (localObject1 != null)
      {
        localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).setHintColor(getContext().getResources().getColor(b.b.BW_100_Alpha_0_5));
        }
      }
      localObject1 = this.Mhw;
      if (localObject1 != null)
      {
        localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).setTextColor(getContext().getResources().getColor(b.b.BW_100_Alpha_0_8));
        }
      }
      localObject1 = this.Mhw;
      if (localObject1 != null)
      {
        localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).setFtsEditTextListener((FTSEditTextView.c)this);
        }
      }
      localObject1 = this.Mhw;
      if (localObject1 != null)
      {
        localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).setCanDeleteTag(false);
        }
      }
      localObject1 = this.Mhw;
      if (localObject1 != null)
      {
        localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).dzv.clearFocus();
        }
      }
      localObject1 = this.Mhw;
      if (localObject1 != null)
      {
        localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).hideVKB();
        }
      }
      localObject1 = this.Mhw;
      if (localObject1 != null)
      {
        localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
        if (localObject1 != null) {
          ((FTSEditTextView)localObject1).jBL();
        }
      }
      localObject1 = this.Mhw;
      if (localObject1 != null)
      {
        localObject1 = ((FTSSearchNoActionBarView)localObject1).getFtsEditText();
        if (localObject1 != null)
        {
          localObject1 = ((FTSEditTextView)localObject1).getClearBtn();
          if (localObject1 != null) {
            ((ImageButton)localObject1).setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
          }
        }
      }
      this.Mhv = ((LinearLayout)findViewById(b.e.LUw));
      localObject1 = this.Mhv;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setVisibility(8);
      }
      this.Mhx = ((MusicMvTabSearchFragment)findViewById(b.e.LUq));
      localObject1 = this.Mhx;
      if (localObject1 != null) {
        ((MusicMvTabSearchFragment)localObject1).a((MusicMvTabFragment.b)this.MhL);
      }
      localObject1 = this.Mhx;
      if (localObject1 != null)
      {
        localObject2 = (MusicMvTabFragment.c)this.MhM;
        kotlin.g.b.s.u(localObject2, "resultListener");
        ((MusicMvTabFragment)localObject1).MjN = ((MusicMvTabFragment.c)localObject2);
      }
      localObject1 = this.Mhx;
      if (localObject1 != null) {
        ((MusicMvTabSearchFragment)localObject1).setOnFlingListener((RecyclerView.j)this.MhH);
      }
      localObject1 = this.Mhx;
      if (localObject1 != null) {
        ((MusicMvTabSearchFragment)localObject1).setOnSceneEndListener(this.MhR);
      }
      this.BnA = ((TextView)findViewById(b.e.no_result_tv));
      this.Mhy = ((LinearLayout)findViewById(b.e.loading_layout));
      this.Mhz = ((LinearLayout)findViewById(b.e.LUd));
      this.MhA = ((LinearLayout)findViewById(b.e.LUf));
      this.MhB = ((LinearLayout)findViewById(b.e.LUb));
      this.MhC = ((LinearLayout)findViewById(b.e.LUe));
      this.MhD = ((MusicMvTabMachineFragment)findViewById(b.e.LUm));
      this.MhE = ((MusicMvTabMyPostFragment)findViewById(b.e.LUp));
      this.MhF = ((MusicMvTabMyFavFragment)findViewById(b.e.LUn));
      this.MhG = ((MusicMvTabMyLikeFragment)findViewById(b.e.LUo));
      localObject1 = this.MhF;
      if (localObject1 != null) {
        ((MusicMvTabMyFavFragment)localObject1).a((MusicMvTabFragment.b)this.MhL);
      }
      localObject1 = this.MhD;
      if (localObject1 != null) {
        ((MusicMvTabMachineFragment)localObject1).a((MusicMvTabFragment.b)this.MhL);
      }
      localObject1 = this.MhE;
      if (localObject1 != null) {
        ((MusicMvTabMyPostFragment)localObject1).a((MusicMvTabFragment.b)this.MhL);
      }
      localObject1 = this.MhG;
      if (localObject1 != null) {
        ((MusicMvTabMyLikeFragment)localObject1).a((MusicMvTabFragment.b)this.MhL);
      }
      localObject1 = this.MhD;
      if (localObject1 != null) {
        ((MusicMvTabMachineFragment)localObject1).a(this.LMB, null);
      }
      localObject1 = this.MhE;
      if (localObject1 != null) {
        ((MusicMvTabMyPostFragment)localObject1).a(this.LMB, null);
      }
      localObject1 = this.MhF;
      if (localObject1 != null) {
        ((MusicMvTabMyFavFragment)localObject1).a(this.LMB, null);
      }
      localObject1 = this.MhG;
      if (localObject1 != null) {
        ((MusicMvTabMyLikeFragment)localObject1).a(this.LMB, null);
      }
      localObject1 = this.MhD;
      if (localObject1 != null) {
        ((MusicMvTabMachineFragment)localObject1).setOnFlingListener((RecyclerView.j)this.MhH);
      }
      localObject1 = this.MhE;
      if (localObject1 != null) {
        ((MusicMvTabMyPostFragment)localObject1).setOnFlingListener((RecyclerView.j)this.MhH);
      }
      localObject1 = this.MhF;
      if (localObject1 != null) {
        ((MusicMvTabMyFavFragment)localObject1).setOnFlingListener((RecyclerView.j)this.MhH);
      }
      localObject1 = this.MhG;
      if (localObject1 != null) {
        ((MusicMvTabMyLikeFragment)localObject1).setOnFlingListener((RecyclerView.j)this.MhH);
      }
      localObject1 = this.MhD;
      if (localObject1 != null) {
        ((MusicMvTabMachineFragment)localObject1).setOnSceneEndListener(this.MhR);
      }
      localObject1 = this.MhE;
      if (localObject1 != null) {
        ((MusicMvTabMyPostFragment)localObject1).setOnSceneEndListener(this.MhR);
      }
      localObject1 = this.MhF;
      if (localObject1 != null) {
        ((MusicMvTabMyFavFragment)localObject1).setOnSceneEndListener(this.MhR);
      }
      localObject1 = this.MhG;
      if (localObject1 != null) {
        ((MusicMvTabMyLikeFragment)localObject1).setOnSceneEndListener(this.MhR);
      }
      localObject1 = this.Mhz;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setOnClickListener(new MusicMVCardChooseView..ExternalSyntheticLambda3(this));
      }
      localObject1 = this.MhA;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setOnClickListener(new MusicMVCardChooseView..ExternalSyntheticLambda7(this));
      }
      localObject1 = this.MhB;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setOnClickListener(new MusicMVCardChooseView..ExternalSyntheticLambda5(this));
      }
      localObject1 = this.MhC;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setOnClickListener(new MusicMVCardChooseView..ExternalSyntheticLambda2(this));
      }
      Log.i("MicroMsg.Mv.MusicMVCardChooseView", "init completed");
      AppMethodBeat.o(287650);
      return;
    }
  }
  
  public final egz kD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(287754);
    kotlin.g.b.s.u(paramString1, "clickItemId");
    kotlin.g.b.s.u(paramString2, "clickListId");
    Log.i("MicroMsg.Mv.MusicMVCardChooseView", "fillPreviewItemObj clickItemId:" + paramString1 + " clickListId:" + paramString2);
    egz localegz = new egz();
    localegz.abmn = paramString2;
    localegz.abmo = paramString1;
    paramString1 = new egy();
    paramString1.LZD = "0";
    paramString2 = this.Mhr;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    if (paramString2 != null)
    {
      paramString2 = paramString2.MaJ;
      if (paramString2 != null)
      {
        paramString2 = (Iterable)paramString2;
        i = 0;
        paramString2 = paramString2.iterator();
        if (paramString2.hasNext())
        {
          localObject1 = paramString2.next();
          if (i < 0) {
            p.kkW();
          }
          localObject3 = (GalleryItem.MediaItem)localObject1;
          localObject1 = paramString1.mew;
          localObject2 = new egx();
          localObject4 = com.tencent.mm.plugin.mv.ui.a.Maz;
          ((egx)localObject2).id = com.tencent.mm.plugin.mv.ui.a.sH(((GalleryItem.MediaItem)localObject3).HHJ);
          ((egx)localObject2).abml = new com.tencent.mm.bx.b(com.tencent.mm.ae.d.c((Parcelable)localObject3));
          if ((localObject3 instanceof GalleryItem.VideoMediaItem)) {}
          for (((egx)localObject2).type = 2;; ((egx)localObject2).type = 1)
          {
            localObject3 = ah.aiuX;
            ((LinkedList)localObject1).add(localObject2);
            i += 1;
            break;
          }
        }
      }
    }
    localegz.TZE.add(paramString1);
    paramString1 = this.MhD;
    if (paramString1 != null) {
      localegz.TZE.add(a((MusicMvTabFragment)paramString1));
    }
    paramString1 = this.MhF;
    if (paramString1 != null) {
      localegz.TZE.add(a((MusicMvTabFragment)paramString1));
    }
    paramString1 = this.MhE;
    if (paramString1 != null) {
      localegz.TZE.add(a((MusicMvTabFragment)paramString1));
    }
    paramString1 = this.MhG;
    if (paramString1 != null) {
      localegz.TZE.add(a((MusicMvTabFragment)paramString1));
    }
    paramString1 = this.Mhx;
    if (paramString1 != null) {
      localegz.TZE.add(a((MusicMvTabFragment)paramString1));
    }
    paramString2 = new egy();
    paramString2.LZD = "-1";
    paramString1 = k.aeZF;
    paramString1 = getContext();
    kotlin.g.b.s.s(paramString1, "context");
    paramString1 = (Iterable)((l)k.nq(paramString1).q(l.class)).MfF.pUj;
    int i = 0;
    Object localObject1 = paramString1.iterator();
    for (;;)
    {
      int j;
      if (((Iterator)localObject1).hasNext())
      {
        paramString1 = ((Iterator)localObject1).next();
        j = i + 1;
        if (i < 0) {
          p.kkW();
        }
        paramString1 = (com.tencent.mm.plugin.mv.model.flex.a)paramString1;
        if (paramString1.type != 0)
        {
          localObject2 = localegz.abmm;
          localObject3 = new eww();
          ((eww)localObject3).LZD = String.valueOf(paramString1.LYq);
          localObject4 = new egx();
          switch (paramString1.type)
          {
          default: 
          case 1: 
          case 3: 
            for (;;)
            {
              paramString1 = ah.aiuX;
              ((eww)localObject3).abyX = ((egx)localObject4);
              if (kotlin.g.b.s.p(((eww)localObject3).LZD, "-1")) {
                paramString2.mew.add(((eww)localObject3).abyX);
              }
              paramString1 = ah.aiuX;
              ((LinkedList)localObject2).add(localObject3);
              i = j;
              break;
              ((egx)localObject4).id = paramString1.id;
              paramString1 = paramString1.LYr;
              if (paramString1 != null)
              {
                paramString1 = paramString1.HHB;
                if (paramString1 != null)
                {
                  ((egx)localObject4).abml = new com.tencent.mm.bx.b(com.tencent.mm.ae.d.c((Parcelable)paramString1));
                  if ((paramString1 instanceof GalleryItem.VideoMediaItem)) {
                    ((egx)localObject4).type = 2;
                  } else {
                    ((egx)localObject4).type = 1;
                  }
                }
              }
            }
          }
          ((egx)localObject4).id = paramString1.id;
          ((egx)localObject4).type = 3;
          paramString1 = paramString1.LYs;
          if (paramString1 == null) {}
          for (paramString1 = null;; paramString1 = paramString1.EDa)
          {
            ((egx)localObject4).EDa = paramString1;
            break;
          }
        }
      }
      else
      {
        if (paramString2.mew.size() > 0)
        {
          paramString1 = paramString2.mew;
          kotlin.g.b.s.s(paramString1, "selectDraftList.itemList");
          localObject1 = (Iterable)paramString1;
          paramString1 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramString1.add(((egx)((Iterator)localObject1).next()).id);
          }
          Log.i("MicroMsg.Mv.MusicMVCardChooseView", kotlin.g.b.s.X("add draft size ", (List)paramString1));
          localegz.TZE.add(paramString2);
        }
        AppMethodBeat.o(287754);
        return localegz;
      }
      i = j;
    }
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(287670);
    paramView = this.Mhx;
    if (paramView != null) {
      paramView.clear();
    }
    AppMethodBeat.o(287670);
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(287662);
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      Log.i("MicroMsg.Mv.MusicMVCardChooseView", paramString1);
      AppMethodBeat.o(287662);
      return;
      paramString2 = n.bq((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$IChoosePanelActionListener;", "", "onAlbumItemClicked", "", "data", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onAlbumItemFlexChecked", "", "isChecked", "fragmentType", "", "onFinderItemClicked", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "onFinderItemFlexChecked", "onFinderItemFlexClicked", "position", "onHeaderCameraClicked", "minRecordDurationMs", "onQueryMediaFinished", "mediaItems", "Ljava/util/LinkedList;", "onSearchBarClicked", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(GalleryItem.MediaItem paramMediaItem, com.tencent.mm.plugin.mv.model.g paramg);
    
    public abstract void a(MusicMvTabFragment.f paramf, com.tencent.mm.plugin.mv.model.g paramg);
    
    public abstract boolean a(boolean paramBoolean, GalleryItem.MediaItem paramMediaItem);
    
    public abstract boolean a(boolean paramBoolean, MusicMvTabFragment.f paramf, int paramInt);
    
    public abstract void adU(int paramInt);
    
    public abstract void bI(LinkedList<GalleryItem.MediaItem> paramLinkedList);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$NotifyMediaItemsChanged;", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView;)V", "adapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter;", "getAdapterRef", "()Ljava/lang/ref/WeakReference;", "setAdapterRef", "(Ljava/lang/ref/WeakReference;)V", "dialogRef", "Landroid/app/ProgressDialog;", "getDialogRef", "setDialogRef", "galleryRef", "Landroidx/recyclerview/widget/RecyclerView;", "getGalleryRef", "setGalleryRef", "isSwitchAlbum", "", "()Z", "setSwitchAlbum", "(Z)V", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getMediaItems", "()Ljava/util/LinkedList;", "setMediaItems", "(Ljava/util/LinkedList;)V", "run", "", "toString", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    implements Runnable
  {
    WeakReference<com.tencent.mm.plugin.mv.ui.adapter.b> HNp;
    WeakReference<ProgressDialog> HNq;
    WeakReference<RecyclerView> HNs;
    LinkedList<GalleryItem.MediaItem> HNt;
    boolean HNu;
    
    public d()
    {
      AppMethodBeat.i(287106);
      AppMethodBeat.o(287106);
    }
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(287126);
      if (this.HNt == null)
      {
        localObject1 = Integer.valueOf(-1);
        Log.d("MicroMsg.Mv.MusicMVCardChooseView", "on NotifyMediaItemsChanged, size %d", new Object[] { localObject1 });
        localObject1 = MusicMVCardChooseView.Mho;
        localObject1 = this.HNt;
        if (localObject1 != null) {
          break label110;
        }
        Log.e("MicroMsg.Mv.MusicMVCardChooseView", "[filterEditMediaItem] mMediaItems is null!");
      }
      label110:
      int i;
      Object localObject5;
      for (;;)
      {
        if (this.HNp != null) {
          break label312;
        }
        Log.w("MicroMsg.Mv.MusicMVCardChooseView", "null == adapterRef");
        AppMethodBeat.o(287126);
        return;
        localObject1 = this.HNt;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
        break;
        localObject2 = e.fAq();
        if ((localObject2 == null) || (((HashSet)localObject2).isEmpty()))
        {
          Log.i("MicroMsg.Mv.MusicMVCardChooseView", "editedMediaSet is invalid.");
        }
        else
        {
          long l = System.currentTimeMillis();
          Log.i("MicroMsg.Mv.MusicMVCardChooseView", "[filterEditMediaItem] size:%s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
          localObject2 = ((HashSet)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            i = ((LinkedList)localObject1).indexOf(localObject4);
            if (-1 == i) {
              break;
            }
            localObject5 = ((LinkedList)localObject1).get(i);
            kotlin.g.b.s.s(localObject5, "mMediaItems[i]");
            localObject5 = (GalleryItem.MediaItem)localObject5;
            if ((kotlin.g.b.s.p(((GalleryItem.MediaItem)localObject4).mMimeType, "edit")) && (!kotlin.g.b.s.p(((GalleryItem.MediaItem)localObject5).mMimeType, "edit")))
            {
              Log.d("MicroMsg.Mv.MusicMVCardChooseView", "item:%s, editItem:%s", new Object[] { localObject5, localObject4 });
              ((LinkedList)localObject1).set(i, localObject4);
            }
          }
          Log.d("MicroMsg.Mv.MusicMVCardChooseView", "[filterEditMediaItem] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      label312:
      Object localObject1 = this.HNp;
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = (com.tencent.mm.plugin.mv.ui.adapter.b)((WeakReference)localObject1).get())
      {
        Log.w("MicroMsg.Mv.MusicMVCardChooseView", "null == adapter");
        AppMethodBeat.o(287126);
        return;
      }
      if (this.HNs == null)
      {
        AppMethodBeat.o(287126);
        return;
      }
      Object localObject2 = this.HNs;
      if (localObject2 == null) {}
      for (localObject2 = null; localObject2 == null; localObject2 = (RecyclerView)((WeakReference)localObject2).get())
      {
        AppMethodBeat.o(287126);
        return;
      }
      Log.d("MicroMsg.Mv.MusicMVCardChooseView", "isSwitchAlbum: %s.", new Object[] { Boolean.valueOf(this.HNu) });
      if (this.HNq == null)
      {
        AppMethodBeat.o(287126);
        return;
      }
      Object localObject4 = this.HNt;
      if (localObject4 != null)
      {
        localObject5 = r.HIe;
        r.fAT().ia((List)localObject4);
        if (!this.HNu) {
          break label731;
        }
        this.HNu = false;
        localObject5 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject5).aYi(), "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((RecyclerView)localObject2).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject5).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        kotlin.g.b.s.u(localObject4, "mediaItems");
        ((com.tencent.mm.plugin.mv.ui.adapter.b)localObject1).MaJ.clear();
        ((com.tencent.mm.plugin.mv.ui.adapter.b)localObject1).MaJ.addAll((Collection)localObject4);
        ((RecyclerView.a)localObject1).bZE.notifyChanged();
        localObject2 = r.HIe;
        localObject2 = r.fAT();
        localObject5 = r.c.HIl;
        if (((LinkedList)localObject4).size() > 32)
        {
          i = 32;
          ((r)localObject2).a((r.c)localObject5, 0, i, ((com.tencent.mm.plugin.mv.ui.adapter.b)localObject1).MaJ.size());
        }
      }
      else
      {
        label645:
        localObject1 = this.HNq;
        if (localObject1 != null) {
          break label741;
        }
      }
      label731:
      label741:
      for (localObject1 = localObject3;; localObject1 = (ProgressDialog)((WeakReference)localObject1).get())
      {
        if ((localObject1 != null) && (((ProgressDialog)localObject1).isShowing()))
        {
          ((ProgressDialog)localObject1).dismiss();
          Log.i("MicroMsg.Mv.MusicMVCardChooseView", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - MusicMVCardChooseView.grw()) });
        }
        MusicMVCardChooseView.j(this.MhX).invoke();
        AppMethodBeat.o(287126);
        return;
        i = ((LinkedList)localObject4).size();
        break;
        ((com.tencent.mm.plugin.mv.ui.adapter.b)localObject1).bo((LinkedList)localObject4);
        break label645;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(287133);
      String str = kotlin.g.b.s.X(super.toString(), "|NotifyMediaItemsChanged");
      AppMethodBeat.o(287133);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentItemClickedListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "onItemChecked", "", "isChecked", "data", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "fragmentType", "", "onItemClicked", "", "errType", "position", "itemView", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements MusicMvTabFragment.b
  {
    e(MusicMVCardChooseView paramMusicMVCardChooseView) {}
    
    public final void a(final MusicMvTabFragment.f paramf, View paramView, RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(287121);
      kotlin.g.b.s.u(paramf, "data");
      kotlin.g.b.s.u(paramView, "itemView");
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      if (!MusicMVCardChooseView.l(this.MhX))
      {
        boolean bool = MusicMVCardChooseView.n(this.MhX);
        ah.d locald1 = new ah.d();
        ah.d locald2 = new ah.d();
        if (!bool)
        {
          RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
          kotlin.g.b.s.checkNotNull(localLayoutManager);
          kotlin.g.b.s.s(localLayoutManager, "recyclerView.layoutManager!!");
          int i = localLayoutManager.getDecoratedTop(paramView);
          int j = localLayoutManager.getPaddingTop();
          paramInt = i - j;
          Log.d("MicroMsg.Mv.MusicMVCardChooseView", "[debugScroll] viewTop: " + i + ", boxTop:" + j + ", offsetOfMoveToFirstRow:" + paramInt);
          i = paramRecyclerView.computeVerticalScrollRange();
          j = paramRecyclerView.computeVerticalScrollOffset();
          int k = paramRecyclerView.getHeight();
          int m = paramView.getHeight();
          int n = i - j - k + (MusicMVCardChooseView.s(this.MhX) - MusicMVCardChooseView.t(this.MhX));
          Log.d("MicroMsg.Mv.MusicMVCardChooseView", "[debugScroll] totalHeight: " + i + ", scrollY:" + j + ", albumRvHeight:" + k + ", itemHeight:" + m + ", availableSpace:" + n);
          locald1.aixb = Math.max(0, Math.min(paramInt, n));
        }
        MusicMVCardChooseView.a(this.MhX, (kotlin.g.a.b)new MusicMVCardChooseView.e.a(locald1, locald2, paramRecyclerView), (kotlin.g.a.a)new b(paramView, this.MhX, paramf));
        AppMethodBeat.o(287121);
        return;
      }
      paramView = MusicMvAlbumPreviewUI.LZJ;
      MusicMvAlbumPreviewUI.a(this.MhX.kD(com.tencent.mm.ae.d.hF(paramf.feedId), String.valueOf(paramInt)));
      paramf = new Intent(this.MhX.getContext(), MusicMvAlbumPreviewUI.class);
      if ((this.MhX.getContext() instanceof Activity))
      {
        paramView = this.MhX.getContext();
        if (paramView == null)
        {
          paramf = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(287121);
          throw paramf;
        }
        com.tencent.mm.hellhoundlib.a.a.a((Activity)paramView, com.tencent.mm.hellhoundlib.b.c.a(10041, new com.tencent.mm.hellhoundlib.b.a()).cG(paramf).aYi(), "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentItemClickedListener$1", "onItemClicked", "(ILcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;ILandroid/view/View;Landroidx/recyclerview/widget/RecyclerView;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      }
      AppMethodBeat.o(287121);
    }
    
    public final boolean b(boolean paramBoolean, MusicMvTabFragment.f paramf, int paramInt)
    {
      AppMethodBeat.i(287128);
      kotlin.g.b.s.u(paramf, "data");
      if (!MusicMVCardChooseView.l(this.MhX))
      {
        Log.e("MicroMsg.Mv.MusicMVCardChooseView", "onItemChecked, but not on flex mode");
        AppMethodBeat.o(287128);
        return true;
      }
      MusicMVCardChooseView.b localb = MusicMVCardChooseView.h(this.MhX);
      if (localb == null)
      {
        AppMethodBeat.o(287128);
        return false;
      }
      paramBoolean = localb.a(paramBoolean, paramf, paramInt);
      AppMethodBeat.o(287128);
      return paramBoolean;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(View paramView, MusicMVCardChooseView paramMusicMVCardChooseView, MusicMvTabFragment.f paramf)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$fragmentResultListener$1", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "onCountResult", "", "type", "", "cnt", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements MusicMvTabFragment.c
  {
    f(MusicMVCardChooseView paramMusicMVCardChooseView) {}
    
    public final void kg(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287115);
      if (paramInt1 == 4)
      {
        Object localObject;
        if (paramInt2 > 0)
        {
          localObject = MusicMVCardChooseView.u(this.MhX);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
          localObject = MusicMVCardChooseView.v(this.MhX);
          if (localObject != null) {
            ((LinearLayout)localObject).setVisibility(8);
          }
          localObject = MusicMVCardChooseView.w(this.MhX);
          if (localObject != null)
          {
            ((MusicMvTabSearchFragment)localObject).setResultView(0);
            AppMethodBeat.o(287115);
          }
        }
        else
        {
          localObject = MusicMVCardChooseView.u(this.MhX);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
          localObject = MusicMVCardChooseView.v(this.MhX);
          if (localObject != null) {
            ((LinearLayout)localObject).setVisibility(8);
          }
          localObject = MusicMVCardChooseView.w(this.MhX);
          if (localObject != null) {
            ((MusicMvTabSearchFragment)localObject).setResultView(8);
          }
        }
      }
      AppMethodBeat.o(287115);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initAlbumChooseArea$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends RecyclerView.l
  {
    g(MusicMVCardChooseView paramMusicMVCardChooseView, FirstRowLayoutManager paramFirstRowLayoutManager) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(287127);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initAlbumChooseArea$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      Log.d("MicroMsg.Mv.MusicMVCardChooseView", "scroll state[%d]", new Object[] { Integer.valueOf(paramInt) });
      if (1 == paramInt) {
        e.fAm().fAh();
      }
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initAlbumChooseArea$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(287127);
          return;
          if (paramInt != 0) {
            break;
          }
          MusicMVCardChooseView.a(this.MhX, this.Mia.Ju());
          MusicMVCardChooseView.b(this.MhX, this.Mia.Jw());
          Log.d("MicroMsg.Mv.MusicMVCardChooseView", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", new Object[] { Integer.valueOf(MusicMVCardChooseView.b(this.MhX)), Integer.valueOf(MusicMVCardChooseView.c(this.MhX)) });
          paramRecyclerView = MusicMVCardChooseView.d(this.MhX);
          if (paramRecyclerView != null)
          {
            paramInt = paramRecyclerView.MaJ.size();
            paramRecyclerView = this.MhX;
            localObject = r.HIe;
            r.fAT().a(r.c.HIl, MusicMVCardChooseView.b(paramRecyclerView), MusicMVCardChooseView.c(paramRecyclerView), paramInt);
          }
        }
      } while (2 != paramInt);
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, MusicMVCardChooseView.e(this.MhX));
      paramRecyclerView = this.MhX;
      boolean bool = WXHardCoderJNI.hcAlbumScrollEnable;
      int i = WXHardCoderJNI.hcAlbumScrollDelay;
      int j = WXHardCoderJNI.hcAlbumScrollCPU;
      int k = WXHardCoderJNI.hcAlbumScrollIO;
      if (WXHardCoderJNI.hcAlbumScrollThr) {}
      for (paramInt = Process.myTid();; paramInt = 0)
      {
        MusicMVCardChooseView.c(paramRecyclerView, WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt, WXHardCoderJNI.hcAlbumScrollTimeout, 702, WXHardCoderJNI.hcAlbumScrollAction, "MicroMsg.Mv.MusicMVCardChooseView"));
        break;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287142);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initAlbumChooseArea$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      paramInt1 = this.Mia.Ju();
      int i = this.Mia.Jw();
      Log.d("MicroMsg.Mv.MusicMVCardChooseView", "pennqin, onScrolled, %s %s %s %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(MusicMVCardChooseView.b(this.MhX)), Integer.valueOf(MusicMVCardChooseView.c(this.MhX)) });
      if ((MusicMVCardChooseView.b(this.MhX) != paramInt1) || (MusicMVCardChooseView.c(this.MhX) != i))
      {
        MusicMVCardChooseView.a(this.MhX, paramInt1);
        MusicMVCardChooseView.b(this.MhX, i);
        localObject = new ArrayList();
        paramInt1 = MusicMVCardChooseView.b(this.MhX);
        i = MusicMVCardChooseView.c(this.MhX);
        if (paramInt1 > i) {}
      }
      for (;;)
      {
        paramRecyclerView = MusicMVCardChooseView.d(this.MhX);
        if (paramRecyclerView == null)
        {
          paramRecyclerView = null;
          if ((paramRecyclerView != null) && (!Util.isNullOrNil(paramRecyclerView.bud()))) {
            ((ArrayList)localObject).add(com.tencent.mm.plugin.gallery.b.h.a(paramRecyclerView.bud(), null, -1));
          }
          if (paramInt1 != i) {
            break label414;
          }
          Log.d("MicroMsg.Mv.MusicMVCardChooseView", "cancelTask, legalPaths size: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
          e.fAm().hZ((List)localObject);
          if (paramInt2 != 0)
          {
            if (paramInt2 >= 0) {
              break label401;
            }
            MusicMVCardChooseView.a(this.MhX, r.c.HIm);
          }
        }
        for (;;)
        {
          Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onScrolled, dy: %s state: %s.", new Object[] { Integer.valueOf(paramInt2), MusicMVCardChooseView.f(this.MhX) });
          paramRecyclerView = MusicMVCardChooseView.d(this.MhX);
          if (paramRecyclerView != null)
          {
            paramInt1 = paramRecyclerView.MaJ.size();
            paramRecyclerView = this.MhX;
            localObject = r.HIe;
            r.fAT().a(MusicMVCardChooseView.f(paramRecyclerView), MusicMVCardChooseView.b(paramRecyclerView), MusicMVCardChooseView.c(paramRecyclerView), paramInt1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$initAlbumChooseArea$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(287142);
          return;
          paramRecyclerView = paramRecyclerView.WF(paramInt1);
          break;
          label401:
          MusicMVCardChooseView.a(this.MhX, r.c.HIn);
        }
        label414:
        paramInt1 += 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(MusicMVCardChooseView paramMusicMVCardChooseView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$mOnItemClickListener$1", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicMvAlbumAdapter$OnItemClickListener;", "onItemChecked", "", "isCheck", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements b.d
  {
    i(MusicMVCardChooseView paramMusicMVCardChooseView) {}
    
    public final void a(int paramInt1, View paramView, int paramInt2)
    {
      AppMethodBeat.i(287134);
      switch (paramInt2)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(287134);
        return;
        MusicMVCardChooseView.x(this.MhX);
        AppMethodBeat.o(287134);
        return;
        MusicMVCardChooseView.a(this.MhX, paramInt1, paramView);
      }
    }
    
    public final boolean b(boolean paramBoolean, GalleryItem.MediaItem paramMediaItem)
    {
      AppMethodBeat.i(287147);
      kotlin.g.b.s.u(paramMediaItem, "item");
      if (!MusicMVCardChooseView.l(this.MhX))
      {
        AppMethodBeat.o(287147);
        return true;
      }
      MusicMVCardChooseView.b localb = MusicMVCardChooseView.h(this.MhX);
      if (localb == null)
      {
        AppMethodBeat.o(287147);
        return false;
      }
      paramBoolean = localb.a(paramBoolean, paramMediaItem);
      AppMethodBeat.o(287147);
      return paramBoolean;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(MusicMVCardChooseView paramMusicMVCardChooseView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$onFlingListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnFlingListener;", "onFling", "", "velocityX", "", "velocityY", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends RecyclerView.j
  {
    k(MusicMVCardChooseView paramMusicMVCardChooseView) {}
    
    public final boolean bC(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287139);
      Log.d("MicroMsg.Mv.MusicMVCardChooseView", kotlin.g.b.s.X("onFling velocityY:", Integer.valueOf(paramInt2)));
      if ((!MusicMVCardChooseView.l(this.MhX)) && (!MusicMVCardChooseView.m(this.MhX)))
      {
        if ((paramInt2 <= 8000) || (!MusicMVCardChooseView.n(this.MhX))) {
          break label100;
        }
        Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onFling velocityY:" + paramInt2 + ", changeTo maxMode");
        MusicMVCardChooseView.a(this.MhX, false, null, 6);
      }
      for (;;)
      {
        AppMethodBeat.o(287139);
        return false;
        label100:
        if ((paramInt2 < -8000) && (!MusicMVCardChooseView.n(this.MhX)))
        {
          Log.d("MicroMsg.Mv.MusicMVCardChooseView", "onFling velocityY:" + paramInt2 + ", changeTo minMode");
          MusicMVCardChooseView.a(this.MhX, true, null, 6);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<ah>
  {
    m(View paramView, MusicMVCardChooseView paramMusicMVCardChooseView, GalleryItem.MediaItem paramMediaItem)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<ah>
  {
    n(kotlin.g.a.a<ah> parama, MusicMVCardChooseView paramMusicMVCardChooseView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<ah>
  {
    o(kotlin.g.a.a<ah> parama, MusicMVCardChooseView paramMusicMVCardChooseView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMVCardChooseView$tabSelectedListener$1", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabReselected", "", "p0", "onTabSelected", "tab", "onTabUnselected", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements TabLayout.b<TabLayout.e>
  {
    p(MusicMVCardChooseView paramMusicMVCardChooseView) {}
    
    public final void i(TabLayout.e parame)
    {
      AppMethodBeat.i(287172);
      MusicMVCardChooseView localMusicMVCardChooseView;
      Object localObject;
      if (parame != null)
      {
        localMusicMVCardChooseView = this.MhX;
        localObject = MusicMVCardChooseView.o(localMusicMVCardChooseView);
        if (localObject != null) {
          break label215;
        }
        localObject = null;
        if (!(localObject instanceof ViewGroup)) {
          break label226;
        }
        localObject = (ViewGroup)localObject;
        label45:
        if (localObject != null) {
          break label232;
        }
        localObject = null;
        label53:
        if (!(localObject instanceof ViewGroup)) {
          break label246;
        }
        localObject = (ViewGroup)localObject;
        label68:
        if (localObject != null) {
          break label252;
        }
        localObject = null;
        label76:
        if (!(localObject instanceof TextView)) {
          break label263;
        }
        localObject = (TextView)localObject;
        label91:
        if (localObject != null) {
          ((TextView)localObject).setTypeface(Typeface.DEFAULT_BOLD);
        }
        int j = parame.position;
        Log.i("MicroMsg.Mv.MusicMVCardChooseView", kotlin.g.b.s.X("setCurrentPage:", Integer.valueOf(j)));
        int i = j;
        if (j == -1) {
          i = 0;
        }
        parame = MusicMVCardChooseView.p(localMusicMVCardChooseView);
        if (parame != null)
        {
          parame = parame.getFtsEditText();
          if (parame != null) {
            parame.dzv.clearFocus();
          }
        }
        parame = MusicMVCardChooseView.p(localMusicMVCardChooseView);
        if (parame != null)
        {
          parame = parame.getFtsEditText();
          if (parame != null) {
            parame.hideVKB();
          }
        }
        switch (i)
        {
        }
      }
      for (;;)
      {
        MusicMVCardChooseView.r(localMusicMVCardChooseView);
        AppMethodBeat.o(287172);
        return;
        label215:
        localObject = ((TabLayout)localObject).getChildAt(0);
        break;
        label226:
        localObject = null;
        break label45;
        label232:
        localObject = ((ViewGroup)localObject).getChildAt(parame.position);
        break label53;
        label246:
        localObject = null;
        break label68;
        label252:
        localObject = ((ViewGroup)localObject).getChildAt(1);
        break label76;
        label263:
        localObject = null;
        break label91;
        parame = MusicMVCardChooseView.g(localMusicMVCardChooseView);
        if (parame != null) {
          parame.setVisibility(0);
        }
        parame = MusicMVCardChooseView.q(localMusicMVCardChooseView);
        if (parame != null)
        {
          parame.setVisibility(4);
          continue;
          parame = MusicMVCardChooseView.g(localMusicMVCardChooseView);
          if (parame != null) {
            parame.setVisibility(4);
          }
          parame = MusicMVCardChooseView.q(localMusicMVCardChooseView);
          if (parame != null) {
            parame.setVisibility(0);
          }
        }
      }
    }
    
    public final void j(TabLayout.e parame)
    {
      AppMethodBeat.i(287167);
      Object localObject;
      if (parame != null)
      {
        localObject = MusicMVCardChooseView.o(this.MhX);
        if (localObject != null) {
          break label88;
        }
        localObject = null;
        if (!(localObject instanceof ViewGroup)) {
          break label97;
        }
        localObject = (ViewGroup)localObject;
        label35:
        if (localObject != null) {
          break label102;
        }
        parame = null;
        label41:
        if (!(parame instanceof ViewGroup)) {
          break label114;
        }
        parame = (ViewGroup)parame;
        label53:
        if (parame != null) {
          break label119;
        }
        parame = null;
        label59:
        if (!(parame instanceof TextView)) {
          break label128;
        }
      }
      label128:
      for (parame = (TextView)parame;; parame = null)
      {
        if (parame != null) {
          parame.setTypeface(Typeface.DEFAULT);
        }
        AppMethodBeat.o(287167);
        return;
        label88:
        localObject = ((TabLayout)localObject).getChildAt(0);
        break;
        label97:
        localObject = null;
        break label35;
        label102:
        parame = ((ViewGroup)localObject).getChildAt(parame.position);
        break label41;
        label114:
        parame = null;
        break label53;
        label119:
        parame = parame.getChildAt(1);
        break label59;
      }
    }
    
    public final void k(TabLayout.e parame) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMVCardChooseView
 * JD-Core Version:    0.7.0.1
 */