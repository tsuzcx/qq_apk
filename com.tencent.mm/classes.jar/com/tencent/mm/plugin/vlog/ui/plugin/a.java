package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView.b;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cutDuration", "", "getCutDuration", "()J", "externalStatusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getExternalStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "externalStatusIcon$delegate", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "getLayout", "()Landroid/view/ViewGroup;", "maxTrackEnd", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1;", "panelRoot", "getPanelRoot", "panelRoot$delegate", "playStatusIcon", "getPlayStatusIcon", "playStatusIcon$delegate", "progressIndicator", "Landroid/view/View;", "getProgressIndicator", "()Landroid/view/View;", "progressIndicator$delegate", "restorer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer;", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "sourceDuration", "getSourceDuration", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "trackCropView$delegate", "cache", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "composition", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "onUpdate", "seekTo", "seekToOriginPosition", "onVideoPause", "onVideoPlay", "restore", "restoreTrackTime", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "setVisibility", "visibility", "", "updateHint", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.c, d.d, t.a
{
  public static final a.a Uhr;
  final ViewGroup GrB;
  private final EditorPanelHolder Gvm;
  private d.e UeU;
  private long UhA;
  private boolean UhB;
  private final b UhC;
  private final g UhD;
  private final j Uhs;
  private final j Uht;
  private final j Uhu;
  private final j Uhv;
  private final j Uhw;
  private final j Uhx;
  private final j Uhy;
  private final j Uhz;
  private boolean lYs;
  
  static
  {
    AppMethodBeat.i(282643);
    Uhr = new a.a((byte)0);
    AppMethodBeat.o(282643);
  }
  
  public a(ViewGroup paramViewGroup, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282432);
    this.GrB = paramViewGroup;
    paramViewGroup = this.GrB.getContext();
    s.s(paramViewGroup, "layout.context");
    paramViewGroup = new EditorPanelHolder(paramViewGroup);
    this.GrB.addView((View)paramViewGroup);
    paramViewGroup.setVisibility(8);
    ah localah = ah.aiuX;
    this.Gvm = paramViewGroup;
    this.Uhs = k.cm((kotlin.g.a.a)new h(this));
    this.Uht = k.cm((kotlin.g.a.a)new k(this));
    this.Uhu = k.cm((kotlin.g.a.a)new e(this));
    this.Uhv = k.cm((kotlin.g.a.a)new b(this));
    this.Uhw = k.cm((kotlin.g.a.a)new f(this));
    this.Uhx = k.cm((kotlin.g.a.a)new j(this));
    this.Uhy = k.cm((kotlin.g.a.a)new d(this));
    this.Uhz = k.cm((kotlin.g.a.a)new i(this));
    this.UhC = new b();
    this.UhD = new g(this, parama);
    AppMethodBeat.o(282432);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(282521);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.UhB = false;
    parama.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282521);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(282546);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.UhB = true;
    parama.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282546);
  }
  
  private static final void c(a parama, View paramView)
  {
    AppMethodBeat.i(282564);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    ((WeImageView)parama.Uhy.getValue()).performClick();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282564);
  }
  
  private final void checkInit()
  {
    AppMethodBeat.i(282477);
    if (this.lYs)
    {
      AppMethodBeat.o(282477);
      return;
    }
    this.lYs = true;
    this.Gvm.setCloseTouchOutside(false);
    hSD().setCallback((MultiTrackCropView.b)this.UhD);
    ((ImageView)this.Uhv.getValue()).setOnClickListener(new a..ExternalSyntheticLambda1(this));
    ((ImageView)this.Uhw.getValue()).setOnClickListener(new a..ExternalSyntheticLambda0(this));
    hSE().setOnClickListener(new a..ExternalSyntheticLambda2(this));
    this.Gvm.setOnVisibleChangeCallback((kotlin.g.a.b)new c(this));
    AppMethodBeat.o(282477);
  }
  
  private final TextView eOX()
  {
    AppMethodBeat.i(282452);
    TextView localTextView = (TextView)this.Uhu.getValue();
    AppMethodBeat.o(282452);
    return localTextView;
  }
  
  private final void gVJ()
  {
    AppMethodBeat.i(282499);
    kotlin.h.a.ai((float)hSD().getCutDuration() / 1000.0F);
    long l = kotlin.h.a.ai((float)Math.min(this.UhA, hSD().getCutDuration()) / 1000.0F);
    eOX().setText((CharSequence)this.Gvm.getContext().getString(com.tencent.mm.plugin.vlog.a.i.video_track_edit_duration_cut_off, new Object[] { Long.valueOf(l) }));
    TextView localTextView = eOX();
    if (hSD().getSourceDuration() > this.UhA) {}
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(282499);
      return;
    }
  }
  
  private final MultiTrackCropView hSD()
  {
    AppMethodBeat.i(282442);
    MultiTrackCropView localMultiTrackCropView = (MultiTrackCropView)this.Uht.getValue();
    AppMethodBeat.o(282442);
    return localMultiTrackCropView;
  }
  
  private final WeImageView hSE()
  {
    AppMethodBeat.i(282461);
    WeImageView localWeImageView = (WeImageView)this.Uhz.getValue();
    AppMethodBeat.o(282461);
    return localWeImageView;
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(282774);
    if ((paramac != null) && (paramLong >= 0L)) {
      hSD().wP(paramLong);
    }
    AppMethodBeat.o(282774);
  }
  
  public final void a(d.e parame)
  {
    this.UeU = parame;
  }
  
  public final void b(ac paramac, long paramLong)
  {
    AppMethodBeat.i(282748);
    s.u(paramac, "composition");
    this.UhB = false;
    checkInit();
    this.UhA = paramLong;
    this.Gvm.setShow(true);
    hSD().setTrack(paramac);
    gVJ();
    AppMethodBeat.o(282748);
  }
  
  public final ac c(ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(282733);
    s.u(paramac, "composition");
    paramac = this.UhC.c(paramac, paramBoolean);
    AppMethodBeat.o(282733);
    return paramac;
  }
  
  public final ac d(ac paramac)
  {
    AppMethodBeat.i(282717);
    s.u(paramac, "composition");
    paramac = this.UhC.d(paramac);
    AppMethodBeat.o(282717);
    return paramac;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282699);
    if (this.Gvm.cvt())
    {
      this.UhB = false;
      this.Gvm.setShow(false);
      AppMethodBeat.o(282699);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(282699);
    return bool;
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(282813);
    hSE().setImageDrawable(bb.m(this.GrB.getContext(), com.tencent.mm.plugin.vlog.a.h.icons_filled_play, -1));
    AppMethodBeat.o(282813);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(282800);
    hSE().setImageDrawable(bb.m(this.GrB.getContext(), com.tencent.mm.plugin.vlog.a.h.icons_filled_pause, -1));
    AppMethodBeat.o(282800);
  }
  
  public final void qU(long paramLong)
  {
    AppMethodBeat.i(282787);
    if (this.Gvm.cvt()) {
      hSD().setProgress(paramLong);
    }
    AppMethodBeat.o(282787);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282684);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.UhB = false;
      this.Gvm.setShow(false);
    }
    AppMethodBeat.o(282684);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<TextView>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$OnCropCallback;", "onTapDown", "", "position", "", "left", "", "startTimeMs", "", "endTimeMs", "onTapMove", "onTapUp", "pause", "resume", "seekTo", "time", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements MultiTrackCropView.b
  {
    g(a parama, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama1) {}
    
    public final void a(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(282786);
      a.d(this.UhE).setVisibility(4);
      Object localObject = a.e(this.UhE);
      if (localObject != null) {
        ((d.e)localObject).pause();
      }
      localObject = parama;
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.c localc = com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPz;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_COMPOSITION_TRACK_INDEX", paramInt);
      localBundle.putBoolean("EDIT_COMPOSITION_LEFT", paramBoolean);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ah localah = ah.aiuX;
      ((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject).a(localc, localBundle);
      AppMethodBeat.o(282786);
    }
    
    public final void b(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(282794);
      a.d(this.UhE).setVisibility(0);
      com.tencent.mm.plugin.recordvideo.plugin.parent.a locala = parama;
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.c localc = com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPA;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_COMPOSITION_TRACK_INDEX", paramInt);
      localBundle.putBoolean("EDIT_COMPOSITION_LEFT", paramBoolean);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ah localah = ah.aiuX;
      locala.a(localc, localBundle);
      a.f(this.UhE);
      AppMethodBeat.o(282794);
    }
    
    public final void hSF()
    {
      AppMethodBeat.i(282803);
      a.f(this.UhE);
      AppMethodBeat.o(282803);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(282809);
      d.e locale = a.e(this.UhE);
      if (locale != null) {
        locale.pause();
      }
      AppMethodBeat.o(282809);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(282818);
      d.e locale = a.e(this.UhE);
      if (locale != null) {
        locale.wK(paramLong);
      }
      AppMethodBeat.o(282818);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<View>
  {
    j(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<MultiTrackCropView>
  {
    k(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.a
 * JD-Core Version:    0.7.0.1
 */