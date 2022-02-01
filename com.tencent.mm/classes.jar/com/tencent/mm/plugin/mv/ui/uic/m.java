package com.tencent.mm.plugin.mv.ui.uic;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.video.thumb.c;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.e.e;
import com.tencent.mm.plugin.mv.model.e.g.a;
import com.tencent.mm.plugin.mv.model.e.h;
import com.tencent.mm.plugin.mv.model.e.i;
import com.tencent.mm.plugin.mv.ui.view.MusicMvSliderSeekBar;
import com.tencent.mm.plugin.thumbplayer.view.MMTPVideoLayout;
import com.tencent.mm.plugin.vlog.ui.thumb.FrameListView;
import com.tencent.mm.plugin.vlog.ui.thumb.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionCallback", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "setActionCallback", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;)V", "backFirstFrame", "Landroid/graphics/Bitmap;", "backFirstRenderTime", "", "dataItem", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "firstRenderFrame", "firstRenderTime", "frameAdapter", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "getFrameAdapter", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "frameAdapter$delegate", "Lkotlin/Lazy;", "frameRv", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "getFrameRv", "()Landroidx/recyclerview/widget/RecyclerView;", "frameRv$delegate", "frameViewHeight", "hintView", "Landroid/widget/TextView;", "getHintView", "()Landroid/widget/TextView;", "hintView$delegate", "isScrollEdit", "", "itemEditRoot", "Landroid/widget/LinearLayout;", "getItemEditRoot", "()Landroid/widget/LinearLayout;", "itemEditRoot$delegate", "itemEditStartTimeMs", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "lyricView", "getLyricView", "lyricView$delegate", "previewContainer", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "getPreviewContainer", "()Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "previewContainer$delegate", "progressListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$progressListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$progressListener$1;", "scrollListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1;", "seekBar", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "getSeekBar", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "seekBar$delegate", "sizePerTime", "", "startMs", "targetDuration", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "thumbView$delegate", "totalDuration", "videoContainer", "Landroid/widget/FrameLayout;", "getVideoContainer", "()Landroid/widget/FrameLayout;", "videoContainer$delegate", "videoDataScope", "Lkotlinx/coroutines/CoroutineScope;", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPVideoLayout;", "getFirstRenderFrameInfo", "Lkotlin/Pair;", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "releaseFrameList", "setShow", "show", "setVideoData", "item", "setupLocalVideoThumb", "videoData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$LocalVideoData;", "setupOnlineVideoThumb", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderVideoData;", "tryCatchFirstFrame", "updateFrameView", "Companion", "MVItemEditActionCallback", "ThumbAdapter", "ThumbViewHolder", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends UIComponent
{
  public static final m.a MfR;
  private final kotlin.j EKZ;
  private final kotlin.j FSi;
  private final kotlin.j Gqu;
  private final kotlin.j Mck;
  private final kotlin.j MfS;
  private final kotlin.j MfT;
  private final kotlin.j MfU;
  private final kotlin.j MfV;
  private final kotlin.j MfW;
  private long MfX;
  private float MfY;
  private com.tencent.mm.plugin.mv.model.e MfZ;
  private MMTPVideoLayout Mfq;
  int Mga;
  Bitmap Mgb;
  private int Mgc;
  private Bitmap Mgd;
  private boolean Mge;
  private final int Mgf;
  private long Mgg;
  private final aq Mgh;
  private final l Mgi;
  private final m Mgj;
  public b Mgk;
  private final kotlin.j nWd;
  private long startMs;
  private long targetDuration;
  
  static
  {
    AppMethodBeat.i(288081);
    MfR = new m.a((byte)0);
    AppMethodBeat.o(288081);
  }
  
  public m(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287827);
    this.MfS = kotlin.k.cm((kotlin.g.a.a)new m.h(paramAppCompatActivity));
    this.nWd = kotlin.k.cm((kotlin.g.a.a)new m.k(paramAppCompatActivity));
    this.Mck = kotlin.k.cm((kotlin.g.a.a)new m.t(paramAppCompatActivity));
    this.Gqu = kotlin.k.cm((kotlin.g.a.a)new m.r(paramAppCompatActivity));
    this.MfT = kotlin.k.cm((kotlin.g.a.a)new m.g(paramAppCompatActivity));
    this.MfU = kotlin.k.cm((kotlin.g.a.a)new m.f(paramAppCompatActivity));
    this.EKZ = kotlin.k.cm((kotlin.g.a.a)new m.i(paramAppCompatActivity));
    this.MfV = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.FSi = kotlin.k.cm((kotlin.g.a.a)new m.n(paramAppCompatActivity));
    this.MfW = kotlin.k.cm((kotlin.g.a.a)new m.j(paramAppCompatActivity));
    this.Mga = 2147483647;
    this.Mgc = 2147483647;
    this.Mgf = com.tencent.mm.cd.a.fromDPToPix((Context)paramAppCompatActivity, 48);
    this.Mgg = -1L;
    this.Mgh = ar.kBZ();
    this.Mgi = new l(this);
    this.Mgj = new m(this);
    AppMethodBeat.o(287827);
  }
  
  private static final void a(m paramm)
  {
    AppMethodBeat.i(287901);
    s.u(paramm, "this$0");
    paramm.gqX().setVisibility(8);
    paramm.grb();
    AppMethodBeat.o(287901);
  }
  
  private static final void a(m paramm, View paramView)
  {
    AppMethodBeat.i(287885);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "onCancel, firstRenderTime:" + paramm.Mga + ", firstRenderFrame:" + paramm.Mgb + ", backFirstRenderTime:" + paramm.Mgc + ", backFirstFrame:" + paramm.Mgd);
    paramm.Mgb = paramm.Mgd;
    paramm.Mga = paramm.Mgc;
    paramView = paramm.Mgk;
    if (paramView != null) {
      paramView.zV(paramm.Mge);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287885);
  }
  
  private static final void b(m paramm, View paramView)
  {
    AppMethodBeat.i(287893);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    if ((paramm.Mgg >= 0L) && (paramm.Mgg + paramm.targetDuration <= paramm.MfX))
    {
      paramView = paramm.MfZ;
      if (paramView != null) {
        break label158;
      }
    }
    label158:
    for (paramView = null;; paramView = paramView.LWY)
    {
      if (paramView != null) {
        paramView.sF(paramm.Mgg);
      }
      paramView = paramm.Mgk;
      if (paramView != null) {
        paramView.zU(paramm.Mge);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287893);
      return;
    }
  }
  
  private final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(287858);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.EKZ.getValue();
    AppMethodBeat.o(287858);
    return localLinearLayoutManager;
  }
  
  private final ImageView getThumbView()
  {
    AppMethodBeat.i(287840);
    ImageView localImageView = (ImageView)this.Gqu.getValue();
    AppMethodBeat.o(287840);
    return localImageView;
  }
  
  private final LinearLayout gqX()
  {
    AppMethodBeat.i(287833);
    LinearLayout localLinearLayout = (LinearLayout)this.MfS.getValue();
    AppMethodBeat.o(287833);
    return localLinearLayout;
  }
  
  private final RecyclerView gqY()
  {
    AppMethodBeat.i(287849);
    RecyclerView localRecyclerView = (RecyclerView)this.MfU.getValue();
    AppMethodBeat.o(287849);
    return localRecyclerView;
  }
  
  private final c gqZ()
  {
    AppMethodBeat.i(287865);
    c localc = (c)this.MfV.getValue();
    AppMethodBeat.o(287865);
    return localc;
  }
  
  private final MusicMvSliderSeekBar gra()
  {
    AppMethodBeat.i(287870);
    MusicMvSliderSeekBar localMusicMvSliderSeekBar = (MusicMvSliderSeekBar)this.FSi.getValue();
    AppMethodBeat.o(287870);
    return localMusicMvSliderSeekBar;
  }
  
  private final void grb()
  {
    AppMethodBeat.i(287876);
    int i = 0;
    int k = gqZ().getItemCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      Object localObject = gqY().fU(i);
      if ((localObject instanceof d)) {}
      for (localObject = (d)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((d)localObject).Mgn.release();
        }
        if (j < k) {
          break;
        }
        gqZ().Mdf = null;
        gqY().postInvalidate();
        AppMethodBeat.o(287876);
        return;
      }
      i = j;
    }
  }
  
  public final void d(final com.tencent.mm.plugin.mv.model.e parame)
  {
    AppMethodBeat.i(288130);
    s.u(parame, "item");
    kotlinx.coroutines.j.a(this.Mgh, null, null, (kotlin.g.a.m)new p(this, parame, null), 3);
    AppMethodBeat.o(288130);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(288120);
    if (gqX().getVisibility() == 0)
    {
      b localb = this.Mgk;
      if (localb != null) {
        localb.zV(this.Mge);
      }
      AppMethodBeat.o(288120);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(288120);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(288110);
    super.onCreate(paramBundle);
    gra().setCursorColor(-1);
    gra().setCursorWidth(com.tencent.mm.cd.a.fromDPToPix((Context)getActivity(), 2));
    ((LinearLayout)getActivity().findViewById(b.e.LTp)).setOnClickListener(new m..ExternalSyntheticLambda1(this));
    ((LinearLayout)getActivity().findViewById(b.e.LTq)).setOnClickListener(new m..ExternalSyntheticLambda0(this));
    gqX().setAlpha(0.0F);
    gqY().setAdapter((RecyclerView.a)gqZ());
    gqY().setLayoutManager((RecyclerView.LayoutManager)getLayoutManager());
    gqY().a((RecyclerView.l)this.Mgj);
    this.Mfq = new MMTPVideoLayout((Context)getActivity(), false);
    paramBundle = this.Mfq;
    if (paramBundle != null) {
      paramBundle.hLO();
    }
    paramBundle = this.Mfq;
    if (paramBundle != null) {
      paramBundle.setKeepScreenOn(true);
    }
    paramBundle = this.Mfq;
    if (paramBundle != null) {
      paramBundle.setId(b.e.music_video_layout);
    }
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    paramBundle.gravity = 17;
    ((FrameLayout)this.Mck.getValue()).addView((View)this.Mfq, (ViewGroup.LayoutParams)paramBundle);
    AppMethodBeat.o(288110);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(288138);
    super.onDestroy();
    Object localObject = this.Mfq;
    if (localObject != null)
    {
      localObject = ((MMTPVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
      }
    }
    localObject = this.Mfq;
    if (localObject != null)
    {
      localObject = ((MMTPVideoLayout)localObject).getEffector();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.c.e)localObject).release();
      }
    }
    localObject = com.tencent.mm.videocomposition.a.agDr;
    com.tencent.mm.videocomposition.a.fka().evictAll();
    localObject = com.tencent.mm.plugin.finder.video.thumb.b.GvD;
    Log.i("MicroMsg.TPTrackThumbFetcher", "clearCache");
    com.tencent.mm.plugin.finder.video.thumb.b.fka().evictAll();
    AppMethodBeat.o(288138);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(288127);
    Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", s.X("setShow:", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      getThumbView().setImageDrawable(null);
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((k)com.tencent.mm.ui.component.k.d(getActivity()).q(k.class)).dSW();
      gqX().setVisibility(0);
      gqX().animate().alpha(1.0F).setDuration(250L).setListener((Animator.AnimatorListener)new o(this)).start();
      AppMethodBeat.o(288127);
      return;
    }
    getThumbView().setImageDrawable(null);
    Object localObject = this.Mfq;
    if (localObject != null)
    {
      localObject = ((MMTPVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.b((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
      }
    }
    grb();
    localObject = com.tencent.mm.ui.component.k.aeZF;
    ((k)com.tencent.mm.ui.component.k.d(getActivity()).q(k.class)).dSX();
    gqX().animate().alpha(0.0F).withEndAction(new m..ExternalSyntheticLambda2(this)).start();
    AppMethodBeat.o(288127);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "", "onCancel", "", "isScrollEdit", "", "onConfirm", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void zU(boolean paramBoolean);
    
    public abstract void zV(boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbViewHolder;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC;)V", "thumbFetcherFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "trackInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "Lkotlin/collections/ArrayList;", "getTrackInfoList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewDetachedFromWindow", "holder", "onViewRecycled", "setThumbFetcherFactory", "factory", "updateTrackInfo", "trackInfos", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.a<m.d>
  {
    g Mdf;
    final ArrayList<com.tencent.mm.plugin.vlog.ui.thumb.a> Mgl;
    
    public c()
    {
      AppMethodBeat.i(287537);
      this.Mgl = new ArrayList();
      AppMethodBeat.o(287537);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(287549);
      int i = this.Mgl.size();
      AppMethodBeat.o(287549);
      return i;
    }
    
    public final void jf(List<? extends com.tencent.mm.plugin.vlog.ui.thumb.a> paramList)
    {
      AppMethodBeat.i(287543);
      s.u(paramList, "trackInfos");
      this.Mgl.clear();
      this.Mgl.addAll((Collection)paramList);
      this.bZE.notifyChanged();
      AppMethodBeat.o(287543);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "getFrameList", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "unbind", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.v
  {
    final FrameListView Mgn;
    
    public d(ViewGroup paramViewGroup)
    {
      super();
      AppMethodBeat.i(287563);
      this.Mgn = ((FrameListView)this.caK);
      AppMethodBeat.o(287563);
    }
    
    public final void grc()
    {
      AppMethodBeat.i(287580);
      Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "release frameListView");
      this.Mgn.release();
      AppMethodBeat.o(287580);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<m.c>
  {
    e(m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$progressListener$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "lastPlayPosition", "", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "timeMs", "reset", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements com.tencent.mm.plugin.thumbplayer.view.e
  {
    long Mgo;
    
    l(m paramm) {}
    
    public final void a(com.tencent.mm.plugin.thumbplayer.a.b paramb, final long paramLong)
    {
      AppMethodBeat.i(287494);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.Mgm, paramLong, this));
      AppMethodBeat.o(287494);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(m paramm, long paramLong, m.l paraml)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    extends RecyclerView.l
  {
    m(m paramm) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(287481);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        if (m.e(this.Mgm).getChildCount() <= 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(287481);
          return;
        }
        paramRecyclerView = m.e(this.Mgm).getChildAt(0);
        long l = ((m.e(this.Mgm).getPaddingStart() - paramRecyclerView.getLeft()) / m.t(this.Mgm));
        paramRecyclerView = m.g(this.Mgm);
        if (paramRecyclerView != null)
        {
          paramRecyclerView = paramRecyclerView.getPlayer();
          if (paramRecyclerView != null) {
            paramRecyclerView.bs(l, m.r(this.Mgm) + l);
          }
        }
        paramRecyclerView = m.g(this.Mgm);
        if (paramRecyclerView != null)
        {
          paramRecyclerView = paramRecyclerView.getPlayer();
          if (paramRecyclerView != null) {
            com.tencent.mm.plugin.thumbplayer.e.b.a(paramRecyclerView, (int)l, true, 4);
          }
        }
        m.q(this.Mgm);
        paramRecyclerView = m.w(this.Mgm);
        if (paramRecyclerView != null)
        {
          m.j(this.Mgm).Mgo = 0L;
          com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(paramRecyclerView.LWU);
        }
        m.a(this.Mgm, true);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(287481);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287489);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (m.e(this.Mgm).getChildCount() <= 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(287489);
        return;
      }
      paramRecyclerView = m.e(this.Mgm).getChildAt(0);
      long l = ((m.e(this.Mgm).getPaddingStart() - paramRecyclerView.getLeft()) / m.t(this.Mgm));
      m.a(this.Mgm, l);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(287489);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$setShow$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    extends AnimatorListenerAdapter
  {
    o(m paramm) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(287500);
      m.b(this.Mgm).setAlpha(1.0F);
      AppMethodBeat.o(287500);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(287496);
      m.b(this.Mgm).setAlpha(0.0F);
      AppMethodBeat.o(287496);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    p(m paramm, com.tencent.mm.plugin.mv.model.e parame, kotlin.d.d<? super p> paramd)
    {
      super(paramd);
    }
    
    private static final void b(m paramm, com.tencent.mm.plugin.mv.model.e parame)
    {
      AppMethodBeat.i(287505);
      int i = m.e(paramm).getPaddingStart();
      int j = m.e(paramm).getWidth() - i * 2;
      m.a(paramm, j * 1.0F / (float)m.r(paramm));
      m.s(paramm).bo(0, -(int)((float)m.h(paramm) * m.t(paramm)));
      Object localObject;
      if ((parame.LWY instanceof e.i))
      {
        localObject = parame.LWY;
        if ((localObject instanceof e.i))
        {
          localObject = (e.i)localObject;
          if (localObject != null)
          {
            parame.getDurationMs();
            m.a(paramm, (e.i)localObject);
          }
        }
      }
      label206:
      for (;;)
      {
        m.i(paramm).aR(j, j, i);
        m.i(paramm).b(true, i);
        m.i(paramm).b(true, i + j);
        AppMethodBeat.o(287505);
        return;
        localObject = null;
        break;
        if ((parame.LWY instanceof e.e))
        {
          localObject = parame.LWY;
          if ((localObject instanceof e.e)) {}
          for (localObject = (e.e)localObject;; localObject = null)
          {
            if (localObject == null) {
              break label206;
            }
            parame.getDurationMs();
            m.a(paramm, (e.e)localObject);
            break;
          }
        }
      }
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(287526);
      paramObject = (kotlin.d.d)new p(this.Mgm, parame, paramd);
      AppMethodBeat.o(287526);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(287522);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(287522);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (f)bg.kCi();
        localObject1 = (kotlin.g.a.m)new a(parame, null);
        localObject3 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = l.a(paramObject, (kotlin.g.a.m)localObject1, (kotlin.d.d)localObject3);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(287522);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      localObject2 = (com.tencent.mm.plugin.thumbplayer.a.b)paramObject;
      if (localObject2 == null)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(287522);
        return paramObject;
      }
      Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", s.X("setVideoData:", localObject2));
      m.a(this.Mgm, false);
      m.a(this.Mgm, -1L);
      m.a(this.Mgm, parame);
      paramObject = parame.LWX;
      if (paramObject != null)
      {
        localObject1 = m.c(this.Mgm);
        s.s(localObject1, "thumbView");
        e.g.a.a(paramObject, (ImageView)localObject1);
      }
      int j = com.tencent.mm.plugin.mv.ui.a.e.adV(parame.getDurationMs());
      paramObject = parame.LWY;
      int i;
      if (paramObject == null)
      {
        i = 0;
        m.d(this.Mgm).setText((CharSequence)this.Mgm.getActivity().getString(b.h.music_mv_maker_item_time_crop, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        paramObject = (k)com.tencent.mm.ui.component.k.d(this.Mgm.getActivity()).q(k.class);
        localObject3 = parame;
        s.u(localObject3, "itemData");
        i = paramObject.pUj.indexOf(localObject3);
        if (i == -1) {
          break label1202;
        }
        localObject1 = (com.tencent.mm.plugin.mv.model.e)p.ae((List)paramObject.pUj, i - 1);
        if (localObject1 == null) {
          break label1202;
        }
        if ((!(((com.tencent.mm.plugin.mv.model.e)localObject1).LWY instanceof e.i)) || (!(((com.tencent.mm.plugin.mv.model.e)localObject3).LWY instanceof e.i))) {
          break label1161;
        }
        paramObject = ((com.tencent.mm.plugin.mv.model.e)localObject1).LWY;
        localObject3 = ((com.tencent.mm.plugin.mv.model.e)localObject3).LWY;
        if ((paramObject == null) || (localObject3 == null) || (!s.p(((e.i)paramObject).videoPath, ((e.i)localObject3).videoPath))) {
          break label1202;
        }
        paramObject = localObject1;
        label434:
        localObject3 = parame.LWY;
        if (localObject3 != null)
        {
          com.tencent.mm.plugin.mv.model.e locale = parame;
          m localm = this.Mgm;
          long l2 = ((e.h)localObject3).gpA();
          if (paramObject != null) {
            break label1207;
          }
          localObject1 = null;
          label476:
          long l1 = l2;
          if (localObject1 != null)
          {
            localObject1 = paramObject.LWY;
            s.checkNotNull(localObject1);
            long l3 = ((e.h)localObject1).gpA();
            long l4 = paramObject.getDurationMs();
            long l5 = locale.getDurationMs();
            localObject1 = paramObject.LWY;
            s.checkNotNull(localObject1);
            l1 = l2;
            if (l3 + l4 + l5 < ((e.h)localObject1).getDurationMs())
            {
              localObject1 = paramObject.LWY;
              s.checkNotNull(localObject1);
              l1 = ((e.h)localObject1).gpA() + paramObject.getDurationMs();
            }
          }
          m.c(localm, l1);
          m.d(localm, locale.getDurationMs());
          m.b(localm, ((e.h)localObject3).getDurationMs());
          m.a(localm, m.h(localm));
        }
        m.e(this.Mgm).post(new m.p..ExternalSyntheticLambda0(this.Mgm, parame));
        m.f(this.Mgm);
        m.c(this.Mgm).setVisibility(0);
        paramObject = m.g(this.Mgm);
        if (paramObject != null) {
          paramObject.fva();
        }
        paramObject = m.g(this.Mgm);
        if (paramObject != null) {
          paramObject.setMediaInfo((com.tencent.mm.plugin.thumbplayer.a.b)localObject2);
        }
        paramObject = m.g(this.Mgm);
        if (paramObject != null)
        {
          paramObject = paramObject.getEffector();
          if (paramObject != null)
          {
            paramObject.TDU = null;
            paramObject.TDT = false;
            Log.i(paramObject.TAG, "reset snapshot");
          }
        }
        paramObject = m.g(this.Mgm);
        if (paramObject != null) {
          break label1216;
        }
      }
      label1161:
      label1202:
      label1207:
      label1216:
      for (paramObject = null;; paramObject = paramObject.getPlayer())
      {
        if (paramObject != null) {
          paramObject.Flr = true;
        }
        paramObject = m.g(this.Mgm);
        if (paramObject != null)
        {
          paramObject = paramObject.getPlayer();
          if (paramObject != null) {
            paramObject.setMute(true);
          }
        }
        paramObject = m.g(this.Mgm);
        if (paramObject != null)
        {
          paramObject = paramObject.getPlayer();
          if (paramObject != null) {
            paramObject.setLoop(true);
          }
        }
        paramObject = m.g(this.Mgm);
        if (paramObject != null)
        {
          paramObject = paramObject.getEffector();
          if (paramObject != null) {
            com.tencent.mm.plugin.thumbplayer.c.e.a(paramObject);
          }
        }
        paramObject = m.g(this.Mgm);
        if (paramObject != null)
        {
          paramObject = paramObject.getPlayer();
          if (paramObject != null) {
            paramObject.bs(m.h(this.Mgm), m.h(this.Mgm) + parame.getDurationMs());
          }
        }
        paramObject = m.g(this.Mgm);
        if (paramObject != null)
        {
          paramObject = paramObject.getPlayer();
          if (paramObject != null) {
            paramObject.hLh();
          }
        }
        m.i(this.Mgm).setCursorPos(0.0F);
        paramObject = m.g(this.Mgm);
        if (paramObject != null)
        {
          paramObject = paramObject.getPlayer();
          if (paramObject != null) {
            paramObject.a((com.tencent.mm.plugin.thumbplayer.view.e)m.j(this.Mgm), 30L);
          }
        }
        paramObject = m.g(this.Mgm);
        if (paramObject != null) {
          paramObject.setOnFrameAvailable((kotlin.g.a.b)new u(this.Mgm) {});
        }
        m.a(this.Mgm, m.m(this.Mgm));
        m.a(this.Mgm, m.n(this.Mgm));
        Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "setVideoData, firstRenderTime:" + m.n(this.Mgm) + ", firstRenderFrame:" + m.m(this.Mgm) + ", backFirstRenderTime:" + m.o(this.Mgm) + ", backFirstFrame:" + m.p(this.Mgm));
        m.q(this.Mgm);
        m.j(this.Mgm).Mgo = 0L;
        com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(parame.LWU);
        paramObject = ah.aiuX;
        AppMethodBeat.o(287522);
        return paramObject;
        i = com.tencent.mm.plugin.mv.ui.a.e.adW((int)paramObject.getDurationMs());
        break;
        if (((((com.tencent.mm.plugin.mv.model.e)localObject1).LWY instanceof e.e)) && ((((com.tencent.mm.plugin.mv.model.e)localObject3).LWY instanceof e.e)))
        {
          paramObject = localObject1;
          if (s.p(((com.tencent.mm.plugin.mv.model.e)localObject1).gpw(), ((com.tencent.mm.plugin.mv.model.e)localObject3).gpw())) {
            break label434;
          }
        }
        paramObject = null;
        break label434;
        localObject1 = paramObject.LWY;
        break label476;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super com.tencent.mm.plugin.thumbplayer.a.b>, Object>
    {
      int label;
      
      a(com.tencent.mm.plugin.mv.model.e parame, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(288142);
        paramObject = (kotlin.d.d)new a(this.Mfv, paramd);
        AppMethodBeat.o(288142);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(288132);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(288132);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.Mfv.LWY;
        if (paramObject == null)
        {
          AppMethodBeat.o(288132);
          return null;
        }
        paramObject = paramObject.gpB();
        AppMethodBeat.o(288132);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    q(m paramm, e.e parame, kotlin.d.d<? super q> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(287498);
      paramObject = (kotlin.d.d)new q(this.Mgm, this.Mgq, paramd);
      AppMethodBeat.o(287498);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(287495);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(287495);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (f)bg.kCi();
        Object localObject = (kotlin.g.a.m)new m.q.a(this.Mgq, null);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        localObject = l.a(paramObject, (kotlin.g.a.m)localObject, locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(287495);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (com.tencent.mm.plugin.thumbplayer.a.b)paramObject;
      if (paramObject == null)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(287495);
        return paramObject;
      }
      paramObject = new c(paramObject);
      paramObject.width = 80;
      paramObject.height = 120;
      paramObject.UoR = (m.t(this.Mgm) * (float)m.k(this.Mgm) / (m.u(this.Mgm) * 1.0F / paramObject.height * paramObject.width));
      paramObject.hUp();
      m.v(this.Mgm).Mdf = ((g)new com.tencent.mm.plugin.finder.video.thumb.a());
      m.v(this.Mgm).jf(p.listOf(paramObject));
      paramObject = ah.aiuX;
      AppMethodBeat.o(287495);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.m
 * JD-Core Version:    0.7.0.1
 */