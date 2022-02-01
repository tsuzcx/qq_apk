package com.tencent.mm.plugin.mv.ui.uic;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.mv.a.d.e;
import com.tencent.mm.plugin.mv.a.d.g;
import com.tencent.mm.plugin.mv.a.d.g.a;
import com.tencent.mm.plugin.mv.a.d.h;
import com.tencent.mm.plugin.mv.a.d.i;
import com.tencent.mm.plugin.mv.ui.view.MusicMvSliderSeekBar;
import com.tencent.mm.plugin.thumbplayer.view.MMTPRecyclerVideoLayout;
import com.tencent.mm.plugin.vlog.ui.thumb.FrameListView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.videocomposition.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "actionCallback", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "setActionCallback", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;)V", "dataItem", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "frameAdapter", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "getFrameAdapter", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "frameAdapter$delegate", "Lkotlin/Lazy;", "frameRv", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "getFrameRv", "()Landroid/support/v7/widget/RecyclerView;", "frameRv$delegate", "frameViewHeight", "", "hintView", "Landroid/widget/TextView;", "getHintView", "()Landroid/widget/TextView;", "hintView$delegate", "isScrollEdit", "", "itemEditRoot", "Landroid/widget/LinearLayout;", "getItemEditRoot", "()Landroid/widget/LinearLayout;", "itemEditRoot$delegate", "itemEditStartTimeMs", "", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "previewContainer", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "getPreviewContainer", "()Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "previewContainer$delegate", "progressListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$progressListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$progressListener$1;", "scrollListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1;", "seekBar", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "getSeekBar", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "seekBar$delegate", "sizePerTime", "", "startMs", "targetDuration", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "thumbView$delegate", "totalDuration", "videoContainer", "Landroid/widget/FrameLayout;", "getVideoContainer", "()Landroid/widget/FrameLayout;", "videoContainer$delegate", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "releaseFrameList", "setShow", "show", "setVideoData", "item", "setupLocalVideoThumb", "videoData", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$LocalVideoData;", "setupOnlineVideoThumb", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData$FinderVideoData;", "Companion", "MVItemEditActionCallback", "ThumbAdapter", "ThumbViewHolder", "plugin-mv_release"})
public final class MusicMvMakerItemEditUIC
  extends UIComponent
{
  public static final MusicMvMakerItemEditUIC.a Avm;
  private MMTPRecyclerVideoLayout AuG;
  private final f AuY;
  private final f AuZ;
  private final f Ava;
  private final f Avb;
  private final f Avc;
  private final f Avd;
  private long Ave;
  private float Avf;
  private com.tencent.mm.plugin.mv.a.d Avg;
  private final int Avh;
  private long Avi;
  private final m Avj;
  private final n Avk;
  public b Avl;
  private boolean Urn;
  private long eiq;
  private long targetDuration;
  private final f vMb;
  private final f vat;
  private final f wfk;
  
  static
  {
    AppMethodBeat.i(257301);
    Avm = new MusicMvMakerItemEditUIC.a((byte)0);
    AppMethodBeat.o(257301);
  }
  
  public MusicMvMakerItemEditUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257300);
    this.AuY = kotlin.g.ah((kotlin.g.a.a)new h(paramAppCompatActivity));
    this.AuZ = kotlin.g.ah((kotlin.g.a.a)new l(paramAppCompatActivity));
    this.Ava = kotlin.g.ah((kotlin.g.a.a)new u(paramAppCompatActivity));
    this.wfk = kotlin.g.ah((kotlin.g.a.a)new t(paramAppCompatActivity));
    this.Avb = kotlin.g.ah((kotlin.g.a.a)new g(paramAppCompatActivity));
    this.Avc = kotlin.g.ah((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.vat = kotlin.g.ah((kotlin.g.a.a)new i(paramAppCompatActivity));
    this.Avd = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.vMb = kotlin.g.ah((kotlin.g.a.a)new o(paramAppCompatActivity));
    this.Avh = com.tencent.mm.cb.a.fromDPToPix((Context)paramAppCompatActivity, 48);
    this.Avi = -1L;
    this.Avj = new m(this);
    this.Avk = new n(this);
    AppMethodBeat.o(257300);
  }
  
  private final LinearLayout ewa()
  {
    AppMethodBeat.i(257287);
    LinearLayout localLinearLayout = (LinearLayout)this.AuY.getValue();
    AppMethodBeat.o(257287);
    return localLinearLayout;
  }
  
  private final TextView ewb()
  {
    AppMethodBeat.i(257289);
    TextView localTextView = (TextView)this.Avb.getValue();
    AppMethodBeat.o(257289);
    return localTextView;
  }
  
  private final RecyclerView ewc()
  {
    AppMethodBeat.i(257290);
    RecyclerView localRecyclerView = (RecyclerView)this.Avc.getValue();
    AppMethodBeat.o(257290);
    return localRecyclerView;
  }
  
  private final c ewd()
  {
    AppMethodBeat.i(257292);
    c localc = (c)this.Avd.getValue();
    AppMethodBeat.o(257292);
    return localc;
  }
  
  private final MusicMvSliderSeekBar ewe()
  {
    AppMethodBeat.i(257293);
    MusicMvSliderSeekBar localMusicMvSliderSeekBar = (MusicMvSliderSeekBar)this.vMb.getValue();
    AppMethodBeat.o(257293);
    return localMusicMvSliderSeekBar;
  }
  
  private final void ewf()
  {
    AppMethodBeat.i(257298);
    int j = ewd().getItemCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.v localv = ewc().ch(i);
      Object localObject = localv;
      if (!(localv instanceof d)) {
        localObject = null;
      }
      localObject = (d)localObject;
      if (localObject != null)
      {
        localObject = ((d)localObject).Avq;
        if (localObject != null) {
          ((FrameListView)localObject).release();
        }
      }
      i += 1;
    }
    ewd().Avo = null;
    ewc().postInvalidate();
    AppMethodBeat.o(257298);
  }
  
  private final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(257291);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.vat.getValue();
    AppMethodBeat.o(257291);
    return localLinearLayoutManager;
  }
  
  private final ImageView getThumbView()
  {
    AppMethodBeat.i(257288);
    ImageView localImageView = (ImageView)this.wfk.getValue();
    AppMethodBeat.o(257288);
    return localImageView;
  }
  
  public final void d(final com.tencent.mm.plugin.mv.a.d paramd)
  {
    AppMethodBeat.i(257297);
    p.h(paramd, "item");
    Object localObject2 = new StringBuilder("setVideoData:");
    Object localObject1 = paramd.App;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((d.h)localObject1).evA();
      Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", localObject1);
      this.Urn = false;
      this.Avi = -1L;
      this.Avg = paramd;
      localObject1 = paramd.Apo;
      if (localObject1 != null)
      {
        localObject2 = getThumbView();
        p.g(localObject2, "thumbView");
        d.g.a.a((d.g)localObject1, (ImageView)localObject2);
      }
      j = com.tencent.mm.plugin.mv.ui.a.e.Tl(paramd.getDurationMs());
      localObject1 = paramd.App;
      if (localObject1 == null) {
        break label643;
      }
    }
    label643:
    for (int i = com.tencent.mm.plugin.mv.ui.a.e.Tm((int)((d.h)localObject1).getDurationMs());; i = 0)
    {
      localObject1 = ewb();
      p.g(localObject1, "hintView");
      ((TextView)localObject1).setText((CharSequence)getActivity().getString(2131763370, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      ewc().post((Runnable)new s(this, paramd));
      localObject1 = paramd.App;
      if (localObject1 != null)
      {
        this.eiq = ((d.h)localObject1).evz();
        this.targetDuration = paramd.getDurationMs();
        this.Ave = ((d.h)localObject1).getDurationMs();
      }
      localObject1 = paramd.App;
      if (localObject1 == null) {
        break label648;
      }
      localObject1 = ((d.h)localObject1).evA();
      if (localObject1 == null) {
        break label648;
      }
      ewf();
      localObject2 = this.AuG;
      if (localObject2 != null) {
        ((MMTPRecyclerVideoLayout)localObject2).fxd();
      }
      localObject2 = this.AuG;
      if (localObject2 != null) {
        ((MMTPRecyclerVideoLayout)localObject2).setMediaInfo((com.tencent.mm.plugin.thumbplayer.d.a)localObject1);
      }
      localObject1 = this.AuG;
      if (localObject1 != null)
      {
        localObject1 = ((MMTPRecyclerVideoLayout)localObject1).getPlayer();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).wcA = true;
        }
      }
      localObject1 = this.AuG;
      if (localObject1 != null)
      {
        localObject1 = ((MMTPRecyclerVideoLayout)localObject1).getPlayer();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).fwW();
        }
      }
      localObject1 = this.AuG;
      if (localObject1 != null)
      {
        localObject1 = ((MMTPRecyclerVideoLayout)localObject1).getPlayer();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).setLoop(true);
        }
      }
      localObject1 = this.AuG;
      if (localObject1 != null)
      {
        localObject1 = ((MMTPRecyclerVideoLayout)localObject1).getEffector();
        if (localObject1 != null) {
          com.tencent.mm.plugin.thumbplayer.c.a.a((com.tencent.mm.plugin.thumbplayer.c.a)localObject1);
        }
      }
      localObject1 = this.AuG;
      if (localObject1 != null)
      {
        localObject1 = ((MMTPRecyclerVideoLayout)localObject1).getPlayer();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).at(this.eiq, this.eiq + paramd.getDurationMs());
        }
      }
      localObject1 = this.AuG;
      if (localObject1 != null)
      {
        localObject1 = ((MMTPRecyclerVideoLayout)localObject1).getPlayer();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).fwU();
        }
      }
      ewe().setCursorPos(0.0F);
      localObject1 = this.AuG;
      if (localObject1 != null)
      {
        localObject1 = ((MMTPRecyclerVideoLayout)localObject1).getPlayer();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).a((com.tencent.mm.plugin.thumbplayer.view.e)this.Avj, 30L);
        }
      }
      localObject1 = getThumbView();
      p.g(localObject1, "thumbView");
      ((ImageView)localObject1).setVisibility(0);
      localObject1 = this.AuG;
      if (localObject1 != null) {
        ((MMTPRecyclerVideoLayout)localObject1).setOnFrameAvailable((kotlin.g.a.b)new r(this, paramd));
      }
      this.Avj.Avr = 0L;
      localObject1 = k.euj();
      p.g(localObject1, "MusicPlayerManager.Instance()");
      ((k)localObject1).etW().tG(paramd.Apl);
      AppMethodBeat.o(257297);
      return;
      localObject1 = null;
      break;
    }
    label648:
    AppMethodBeat.o(257297);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(257295);
    Object localObject = ewa();
    p.g(localObject, "itemEditRoot");
    if (((LinearLayout)localObject).getVisibility() == 0)
    {
      localObject = this.Avl;
      if (localObject != null) {
        ((b)localObject).Ff(this.Urn);
      }
      AppMethodBeat.o(257295);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(257295);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(257294);
    super.onCreate(paramBundle);
    ewe().setCursorColor(-1);
    ewe().setCursorWidth(com.tencent.mm.cb.a.fromDPToPix((Context)getActivity(), 2));
    ((Button)((FragmentActivity)getActivity()).findViewById(2131305137)).setOnClickListener((View.OnClickListener)new j(this));
    ((Button)((FragmentActivity)getActivity()).findViewById(2131305138)).setOnClickListener((View.OnClickListener)new k(this));
    paramBundle = ewa();
    p.g(paramBundle, "itemEditRoot");
    paramBundle.setAlpha(0.0F);
    paramBundle = ewc();
    p.g(paramBundle, "frameRv");
    paramBundle.setAdapter((RecyclerView.a)ewd());
    paramBundle = ewc();
    p.g(paramBundle, "frameRv");
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)getLayoutManager());
    ewc().a((RecyclerView.l)this.Avk);
    this.AuG = new MMTPRecyclerVideoLayout((Context)getActivity(), false);
    paramBundle = this.AuG;
    if (paramBundle != null) {
      paramBundle.fxf();
    }
    paramBundle = this.AuG;
    if (paramBundle != null) {
      paramBundle.setKeepScreenOn(true);
    }
    paramBundle = this.AuG;
    if (paramBundle != null) {
      paramBundle.setId(2131305117);
    }
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    paramBundle.gravity = 17;
    ((FrameLayout)this.Ava.getValue()).addView((View)this.AuG, (ViewGroup.LayoutParams)paramBundle);
    AppMethodBeat.o(257294);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257299);
    super.onDestroy();
    Object localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
      }
    }
    localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getEffector();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).release();
      }
    }
    localObject = c.RgU;
    c.evK().evictAll();
    localObject = com.tencent.mm.plugin.mv.ui.b.b.Asr;
    Log.i("MicroMsg.TPTrackThumbFetcher", "clearCache");
    com.tencent.mm.plugin.mv.ui.b.b.evK().evictAll();
    AppMethodBeat.o(257299);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(257296);
    Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "setShow:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      getThumbView().setImageDrawable(null);
      localObject = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvMakerEditUIC.class)).cWX();
      localObject = ewa();
      p.g(localObject, "itemEditRoot");
      ((LinearLayout)localObject).setVisibility(0);
      ewa().animate().alpha(1.0F).setDuration(250L).setListener((Animator.AnimatorListener)new p(this)).start();
      AppMethodBeat.o(257296);
      return;
    }
    getThumbView().setImageDrawable(null);
    Object localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).pause();
      }
    }
    ewf();
    localObject = com.tencent.mm.ui.component.a.PRN;
    ((MusicMvMakerEditUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvMakerEditUIC.class)).cWY();
    ewa().animate().alpha(0.0F).withEndAction((Runnable)new q(this)).start();
    AppMethodBeat.o(257296);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$MVItemEditActionCallback;", "", "onCancel", "", "isScrollEdit", "", "onConfirm", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void Fe(boolean paramBoolean);
    
    public abstract void Ff(boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbViewHolder;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC;)V", "thumbFetcherFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "trackInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewDetachedFromWindow", "holder", "onViewRecycled", "setThumbFetcherFactory", "factory", "updateTrackInfo", "trackInfos", "", "plugin-mv_release"})
  public final class c
    extends RecyclerView.a<MusicMvMakerItemEditUIC.d>
  {
    private final ArrayList<com.tencent.mm.plugin.vlog.ui.thumb.a> Avn;
    com.tencent.mm.plugin.vlog.ui.thumb.g Avo;
    
    public c()
    {
      AppMethodBeat.i(257263);
      this.Avn = new ArrayList();
      AppMethodBeat.o(257263);
    }
    
    public final void fE(List<? extends com.tencent.mm.plugin.vlog.ui.thumb.a> paramList)
    {
      AppMethodBeat.i(257257);
      p.h(paramList, "trackInfos");
      this.Avn.clear();
      this.Avn.addAll((Collection)paramList);
      notifyDataSetChanged();
      AppMethodBeat.o(257257);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(257262);
      int i = this.Avn.size();
      AppMethodBeat.o(257262);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "frameList", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "getFrameList", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListView;", "unbind", "", "plugin-mv_release"})
  public static final class d
    extends RecyclerView.v
  {
    final FrameListView Avq;
    
    public d(ViewGroup paramViewGroup)
    {
      super();
      AppMethodBeat.i(257265);
      paramViewGroup = this.aus;
      if (paramViewGroup == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.thumb.FrameListView");
        AppMethodBeat.o(257265);
        throw paramViewGroup;
      }
      this.Avq = ((FrameListView)paramViewGroup);
      AppMethodBeat.o(257265);
    }
    
    public final void ewg()
    {
      AppMethodBeat.i(257264);
      Log.i("MicroMsg.Mv.MusicMvMakerItemEditUIC", "release frameListView");
      this.Avq.release();
      AppMethodBeat.o(257264);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$ThumbAdapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<MusicMvMakerItemEditUIC.c>
  {
    e(MusicMvMakerItemEditUIC paramMusicMvMakerItemEditUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<RecyclerView>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<TextView>
  {
    g(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    h(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/LinearLayoutManager;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<LinearLayoutManager>
  {
    i(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(MusicMvMakerItemEditUIC paramMusicMvMakerItemEditUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257271);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.Avp.Avl;
      if (paramView != null) {
        paramView.Ff(MusicMvMakerItemEditUIC.o(this.Avp));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257271);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(MusicMvMakerItemEditUIC paramMusicMvMakerItemEditUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257272);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if ((MusicMvMakerItemEditUIC.b(this.Avp) >= 0L) && (MusicMvMakerItemEditUIC.b(this.Avp) + MusicMvMakerItemEditUIC.i(this.Avp) <= MusicMvMakerItemEditUIC.q(this.Avp)))
      {
        paramView = MusicMvMakerItemEditUIC.c(this.Avp);
        if (paramView != null)
        {
          paramView = paramView.App;
          if (paramView != null) {
            paramView.Hr(MusicMvMakerItemEditUIC.b(this.Avp));
          }
        }
      }
      paramView = this.Avp.Avl;
      if (paramView != null) {
        paramView.Fe(MusicMvMakerItemEditUIC.o(this.Avp));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257272);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<RoundedCornerFrameLayout>
  {
    l(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$progressListener$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "lastPlayPosition", "", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "timeMs", "reset", "plugin-mv_release"})
  public static final class m
    implements com.tencent.mm.plugin.thumbplayer.view.e
  {
    long Avr;
    
    public final void Hv(final long paramLong)
    {
      AppMethodBeat.i(257275);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramLong));
      AppMethodBeat.o(257275);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(MusicMvMakerItemEditUIC.m paramm, long paramLong)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-mv_release"})
  public static final class n
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(257276);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        paramRecyclerView = MusicMvMakerItemEditUIC.g(this.Avp);
        p.g(paramRecyclerView, "frameRv");
        if (paramRecyclerView.getChildCount() <= 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(257276);
          return;
        }
        paramRecyclerView = MusicMvMakerItemEditUIC.g(this.Avp).getChildAt(0);
        localObject = MusicMvMakerItemEditUIC.g(this.Avp);
        p.g(localObject, "frameRv");
        paramInt = ((RecyclerView)localObject).getPaddingStart();
        p.g(paramRecyclerView, "childView");
        long l = ((paramInt - paramRecyclerView.getLeft()) / MusicMvMakerItemEditUIC.h(this.Avp));
        paramRecyclerView = MusicMvMakerItemEditUIC.a(this.Avp);
        if (paramRecyclerView != null)
        {
          paramRecyclerView = paramRecyclerView.getPlayer();
          if (paramRecyclerView != null) {
            paramRecyclerView.at(l, MusicMvMakerItemEditUIC.i(this.Avp) + l);
          }
        }
        paramRecyclerView = MusicMvMakerItemEditUIC.a(this.Avp);
        if (paramRecyclerView != null)
        {
          paramRecyclerView = paramRecyclerView.getPlayer();
          if (paramRecyclerView != null) {
            paramRecyclerView.YX((int)l);
          }
        }
        paramRecyclerView = MusicMvMakerItemEditUIC.c(this.Avp);
        if (paramRecyclerView != null)
        {
          MusicMvMakerItemEditUIC.n(this.Avp).Avr = 0L;
          localObject = k.euj();
          p.g(localObject, "MusicPlayerManager.Instance()");
          ((k)localObject).etW().tG(paramRecyclerView.Apl);
        }
        MusicMvMakerItemEditUIC.p(this.Avp);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(257276);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(257277);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = MusicMvMakerItemEditUIC.g(this.Avp);
      p.g(paramRecyclerView, "frameRv");
      if (paramRecyclerView.getChildCount() <= 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(257277);
        return;
      }
      paramRecyclerView = MusicMvMakerItemEditUIC.g(this.Avp).getChildAt(0);
      localObject = MusicMvMakerItemEditUIC.g(this.Avp);
      p.g(localObject, "frameRv");
      paramInt1 = ((RecyclerView)localObject).getPaddingStart();
      p.g(paramRecyclerView, "childView");
      long l = ((paramInt1 - paramRecyclerView.getLeft()) / MusicMvMakerItemEditUIC.h(this.Avp));
      MusicMvMakerItemEditUIC.a(this.Avp, l);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(257277);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSliderSeekBar;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<MusicMvSliderSeekBar>
  {
    o(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$setShow$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-mv_release"})
  public static final class p
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(257280);
      paramAnimator = MusicMvMakerItemEditUIC.d(this.Avp);
      p.g(paramAnimator, "previewContainer");
      paramAnimator.setAlpha(1.0F);
      AppMethodBeat.o(257280);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(257279);
      paramAnimator = MusicMvMakerItemEditUIC.d(this.Avp);
      p.g(paramAnimator, "previewContainer");
      paramAnimator.setAlpha(0.0F);
      AppMethodBeat.o(257279);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(MusicMvMakerItemEditUIC paramMusicMvMakerItemEditUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(257281);
      LinearLayout localLinearLayout = MusicMvMakerItemEditUIC.e(this.Avp);
      p.g(localLinearLayout, "itemEditRoot");
      localLinearLayout.setVisibility(8);
      MusicMvMakerItemEditUIC.f(this.Avp);
      AppMethodBeat.o(257281);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerItemEditUIC$setVideoData$3$1"})
  static final class r
    extends q
    implements kotlin.g.a.b<SurfaceTexture, x>
  {
    r(MusicMvMakerItemEditUIC paramMusicMvMakerItemEditUIC, com.tencent.mm.plugin.mv.a.d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(MusicMvMakerItemEditUIC paramMusicMvMakerItemEditUIC, com.tencent.mm.plugin.mv.a.d paramd) {}
    
    public final void run()
    {
      d.h localh = null;
      Object localObject = null;
      AppMethodBeat.i(257284);
      RecyclerView localRecyclerView = MusicMvMakerItemEditUIC.g(this.Avp);
      p.g(localRecyclerView, "frameRv");
      int i = localRecyclerView.getPaddingStart();
      localRecyclerView = MusicMvMakerItemEditUIC.g(this.Avp);
      p.g(localRecyclerView, "frameRv");
      int j = localRecyclerView.getWidth() - i * 2;
      MusicMvMakerItemEditUIC.a(this.Avp, j * 1.0F / (float)MusicMvMakerItemEditUIC.i(this.Avp));
      MusicMvMakerItemEditUIC.j(this.Avp).ah(0, -(int)((float)MusicMvMakerItemEditUIC.k(this.Avp) * MusicMvMakerItemEditUIC.h(this.Avp)));
      if ((paramd.App instanceof d.i))
      {
        localh = paramd.App;
        if ((localh instanceof d.i)) {
          break label257;
        }
      }
      for (;;)
      {
        localObject = (d.i)localObject;
        if (localObject != null) {
          MusicMvMakerItemEditUIC.a(this.Avp, (d.i)localObject);
        }
        do
        {
          MusicMvMakerItemEditUIC.l(this.Avp).ao(j, j, i);
          MusicMvMakerItemEditUIC.l(this.Avp).b(true, i);
          MusicMvMakerItemEditUIC.l(this.Avp).b(true, i + j);
          AppMethodBeat.o(257284);
          return;
        } while (!(paramd.App instanceof d.e));
        localObject = paramd.App;
        if (!(localObject instanceof d.e)) {
          localObject = localh;
        }
        for (;;)
        {
          localObject = (d.e)localObject;
          if (localObject == null) {
            break;
          }
          MusicMvMakerItemEditUIC.a(this.Avp, (d.e)localObject);
          break;
        }
        label257:
        localObject = localh;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    t(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<FrameLayout>
  {
    u(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerItemEditUIC
 * JD-Core Version:    0.7.0.1
 */