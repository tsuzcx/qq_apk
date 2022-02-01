package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.ui.plugin.d.c;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.plugin.vlog.ui.plugin.t.a;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cutDuration", "", "getCutDuration", "()J", "externalStatusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getExternalStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "externalStatusIcon$delegate", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "getLayout", "()Landroid/view/ViewGroup;", "maxTrackEnd", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$onCropCallback$1;", "panelRoot", "getPanelRoot", "panelRoot$delegate", "playStatusContainer", "Landroid/view/View;", "getPlayStatusContainer", "()Landroid/view/View;", "playStatusContainer$delegate", "playStatusIcon", "getPlayStatusIcon", "playStatusIcon$delegate", "progressIndicator", "getProgressIndicator", "progressIndicator$delegate", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "sourceDuration", "getSourceDuration", "titleView", "getTitleView", "titleView$delegate", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "trackCropView$delegate", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "onVideoPause", "onVideoPlay", "seek", "setEnableLengthEdit", "enable", "setTrack", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "setVisibility", "visibility", "", "updateHint", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.c, t.a
{
  public static final a.a Uqi;
  final ViewGroup GrB;
  private final EditorPanelHolder Gvm;
  private d.e UeU;
  private long UhA;
  private boolean UhB;
  private final j Uhs;
  private final j Uht;
  private final j Uhu;
  private final j Uhv;
  private final j Uhw;
  private final j Uhx;
  private final j Uhy;
  private final j Uhz;
  private final j Uqj;
  private final j Uqk;
  private final g Uql;
  private boolean lYs;
  
  static
  {
    AppMethodBeat.i(282389);
    Uqi = new a.a((byte)0);
    AppMethodBeat.o(282389);
  }
  
  public a(ViewGroup paramViewGroup, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282245);
    this.GrB = paramViewGroup;
    paramViewGroup = this.GrB.getContext();
    s.s(paramViewGroup, "layout.context");
    paramViewGroup = new EditorPanelHolder(paramViewGroup);
    this.GrB.addView((View)paramViewGroup);
    paramViewGroup.setVisibility(8);
    ah localah = ah.aiuX;
    this.Gvm = paramViewGroup;
    this.Uhs = k.cm((kotlin.g.a.a)new h(this));
    this.Uht = k.cm((kotlin.g.a.a)new m(this));
    this.Uhu = k.cm((kotlin.g.a.a)new e(this));
    this.Uhv = k.cm((kotlin.g.a.a)new b(this));
    this.Uhw = k.cm((kotlin.g.a.a)new f(this));
    this.Uqj = k.cm((kotlin.g.a.a)new l(this));
    this.Uhx = k.cm((kotlin.g.a.a)new k(this));
    this.Uhy = k.cm((kotlin.g.a.a)new d(this));
    this.Uhz = k.cm((kotlin.g.a.a)new j(this));
    this.Uqk = k.cm((kotlin.g.a.a)new i(this));
    this.Uql = new g(this, parama);
    AppMethodBeat.o(282245);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(282328);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.UhB = false;
    parama.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282328);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(282335);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.UhB = true;
    parama.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282335);
  }
  
  private static final void c(a parama, View paramView)
  {
    AppMethodBeat.i(282340);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.hUw().performClick();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282340);
  }
  
  private final TextView eOX()
  {
    AppMethodBeat.i(282256);
    TextView localTextView = (TextView)this.Uhu.getValue();
    AppMethodBeat.o(282256);
    return localTextView;
  }
  
  private final void gVJ()
  {
    AppMethodBeat.i(282318);
    long l = kotlin.h.a.ai((float)Math.min(this.UhA, hSD().getCutDuration()) / 1000.0F);
    eOX().setText((CharSequence)this.Gvm.getContext().getString(com.tencent.mm.plugin.vlog.a.i.video_track_edit_duration_cut_off, new Object[] { Long.valueOf(l) }));
    TextView localTextView = eOX();
    if (hSD().getSourceDuration() > this.UhA) {}
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(282318);
      return;
    }
  }
  
  private final WeImageView hSE()
  {
    AppMethodBeat.i(282291);
    WeImageView localWeImageView = (WeImageView)this.Uhz.getValue();
    AppMethodBeat.o(282291);
    return localWeImageView;
  }
  
  private final ViewGroup hUt()
  {
    AppMethodBeat.i(282250);
    ViewGroup localViewGroup = (ViewGroup)this.Uhs.getValue();
    AppMethodBeat.o(282250);
    return localViewGroup;
  }
  
  private final ImageView hUu()
  {
    AppMethodBeat.i(282263);
    ImageView localImageView = (ImageView)this.Uhv.getValue();
    AppMethodBeat.o(282263);
    return localImageView;
  }
  
  private final ImageView hUv()
  {
    AppMethodBeat.i(282272);
    ImageView localImageView = (ImageView)this.Uhw.getValue();
    AppMethodBeat.o(282272);
    return localImageView;
  }
  
  private final WeImageView hUw()
  {
    AppMethodBeat.i(282281);
    WeImageView localWeImageView = (WeImageView)this.Uhy.getValue();
    AppMethodBeat.o(282281);
    return localWeImageView;
  }
  
  private final View hUx()
  {
    AppMethodBeat.i(282295);
    View localView = (View)this.Uqk.getValue();
    AppMethodBeat.o(282295);
    return localView;
  }
  
  public final void a(d.e parame)
  {
    this.UeU = parame;
  }
  
  public final MultiTrackCropView hSD()
  {
    AppMethodBeat.i(282417);
    MultiTrackCropView localMultiTrackCropView = (MultiTrackCropView)this.Uht.getValue();
    AppMethodBeat.o(282417);
    return localMultiTrackCropView;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282429);
    if (this.Gvm.cvt())
    {
      this.UhB = false;
      this.Gvm.setShow(false);
      AppMethodBeat.o(282429);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(282429);
    return bool;
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(282455);
    hSE().setImageDrawable(bb.m(this.GrB.getContext(), com.tencent.mm.plugin.vlog.a.h.icons_filled_play, -1));
    hUx().setContentDescription((CharSequence)hUt().getContext().getString(com.tencent.mm.plugin.vlog.a.i.app_continue));
    hUw().setContentDescription((CharSequence)hUt().getContext().getString(com.tencent.mm.plugin.vlog.a.i.app_continue));
    AppMethodBeat.o(282455);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(282447);
    hSE().setImageDrawable(bb.m(this.GrB.getContext(), com.tencent.mm.plugin.vlog.a.h.icons_filled_pause, -1));
    hUx().setContentDescription((CharSequence)hUt().getContext().getString(com.tencent.mm.plugin.vlog.a.i.app_pause));
    hUw().setContentDescription((CharSequence)hUt().getContext().getString(com.tencent.mm.plugin.vlog.a.i.app_pause));
    AppMethodBeat.o(282447);
  }
  
  public final void qU(long paramLong)
  {
    AppMethodBeat.i(282439);
    if (this.Gvm.cvt()) {
      hSD().setProgress(paramLong);
    }
    AppMethodBeat.o(282439);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282424);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.UhB = false;
      this.Gvm.setShow(false);
    }
    AppMethodBeat.o(282424);
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$OnCropCallback;", "onTapDown", "", "position", "", "left", "", "startTimeMs", "", "endTimeMs", "onTapMove", "onTapUp", "pause", "resume", "seekTo", "time", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements MultiTrackCropView.b
  {
    g(a parama, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama1) {}
    
    public final void a(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(282000);
      a.d(this.Uqm).setVisibility(4);
      Object localObject = a.e(this.Uqm);
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
      AppMethodBeat.o(282000);
    }
    
    public final void b(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(282007);
      a.d(this.Uqm).setVisibility(0);
      com.tencent.mm.plugin.recordvideo.plugin.parent.a locala = parama;
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.c localc = com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPz;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_COMPOSITION_TRACK_INDEX", paramInt);
      localBundle.putBoolean("EDIT_COMPOSITION_LEFT", paramBoolean);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ah localah = ah.aiuX;
      locala.a(localc, localBundle);
      a.f(this.Uqm);
      AppMethodBeat.o(282007);
    }
    
    public final void hSF()
    {
      AppMethodBeat.i(282012);
      a.f(this.Uqm);
      AppMethodBeat.o(282012);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(282019);
      d.e locale = a.e(this.Uqm);
      if (locale != null) {
        locale.pause();
      }
      AppMethodBeat.o(282019);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(282025);
      d.e locale = a.e(this.Uqm);
      if (locale != null) {
        locale.wK(paramLong);
      }
      AppMethodBeat.o(282025);
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
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<View>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    j(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<View>
  {
    k(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<TextView>
  {
    l(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<MultiTrackCropView>
  {
    m(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.a
 * JD-Core Version:    0.7.0.1
 */