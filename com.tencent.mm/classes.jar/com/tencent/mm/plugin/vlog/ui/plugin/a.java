package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView.b;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cutDuration", "", "getCutDuration", "()J", "externalStatusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getExternalStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "externalStatusIcon$delegate", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "getLayout", "()Landroid/view/ViewGroup;", "maxTrackEnd", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1;", "panelRoot", "getPanelRoot", "panelRoot$delegate", "playStatusIcon", "getPlayStatusIcon", "playStatusIcon$delegate", "progressIndicator", "Landroid/view/View;", "getProgressIndicator", "()Landroid/view/View;", "progressIndicator$delegate", "restorer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer;", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "sourceDuration", "getSourceDuration", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "trackCropView$delegate", "cache", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "composition", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "onUpdate", "seekTo", "seekToOriginPosition", "onVideoPause", "onVideoPlay", "restore", "restoreTrackTime", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "setVisibility", "visibility", "", "updateHint", "Companion", "plugin-vlog_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.c, d.d, u.a
{
  public static final a Num;
  final ViewGroup APk;
  final d APl;
  private final EditorPanelHolder ATq;
  private d.e Nrj;
  private final f Nua;
  private final f Nub;
  private final f Nuc;
  private final f Nud;
  private final f Nue;
  private final f Nuf;
  private final f Nug;
  private final f Nuh;
  private long Nui;
  private boolean Nuj;
  private final b Nuk;
  private final j Nul;
  private boolean jvb;
  
  static
  {
    AppMethodBeat.i(229218);
    Num = new a((byte)0);
    AppMethodBeat.o(229218);
  }
  
  public a(ViewGroup paramViewGroup, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(229216);
    this.APk = paramViewGroup;
    this.APl = paramd;
    paramViewGroup = this.APk.getContext();
    p.j(paramViewGroup, "layout.context");
    paramViewGroup = new EditorPanelHolder(paramViewGroup);
    this.APk.addView((View)paramViewGroup);
    paramViewGroup.setVisibility(8);
    this.ATq = paramViewGroup;
    this.Nua = g.ar((kotlin.g.a.a)new k(this));
    this.Nub = g.ar((kotlin.g.a.a)new n(this));
    this.Nuc = g.ar((kotlin.g.a.a)new h(this));
    this.Nud = g.ar((kotlin.g.a.a)new b(this));
    this.Nue = g.ar((kotlin.g.a.a)new i(this));
    this.Nuf = g.ar((kotlin.g.a.a)new m(this));
    this.Nug = g.ar((kotlin.g.a.a)new g(this));
    this.Nuh = g.ar((kotlin.g.a.a)new l(this));
    this.Nuk = new b();
    this.Nul = new j(this);
    AppMethodBeat.o(229216);
  }
  
  private final void bcM()
  {
    AppMethodBeat.i(229169);
    if (this.jvb)
    {
      AppMethodBeat.o(229169);
      return;
    }
    this.jvb = true;
    this.ATq.setCloseTouchOutside(false);
    guO().setCallback((MultiTrackCropView.b)this.Nul);
    ((ImageView)this.Nud.getValue()).setOnClickListener((View.OnClickListener)new c(this));
    ((ImageView)this.Nue.getValue()).setOnClickListener((View.OnClickListener)new d(this));
    guP().setOnClickListener((View.OnClickListener)new e(this));
    this.ATq.setOnVisibleChangeCallback((kotlin.g.a.b)new f(this));
    AppMethodBeat.o(229169);
  }
  
  private final TextView dQW()
  {
    AppMethodBeat.i(229164);
    TextView localTextView = (TextView)this.Nuc.getValue();
    AppMethodBeat.o(229164);
    return localTextView;
  }
  
  private final void fGj()
  {
    AppMethodBeat.i(229194);
    kotlin.h.a.N((float)guO().getCutDuration() / 1000.0F);
    long l = kotlin.h.a.N((float)Math.min(this.Nui, guO().getCutDuration()) / 1000.0F);
    TextView localTextView = dQW();
    p.j(localTextView, "hintText");
    localTextView.setText((CharSequence)this.ATq.getContext().getString(com.tencent.mm.plugin.vlog.a.i.video_track_edit_duration_cut_off, new Object[] { Long.valueOf(l) }));
    localTextView = dQW();
    p.j(localTextView, "hintText");
    if (guO().getSourceDuration() > this.Nui) {}
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(229194);
      return;
    }
  }
  
  private final MultiTrackCropView guO()
  {
    AppMethodBeat.i(229163);
    MultiTrackCropView localMultiTrackCropView = (MultiTrackCropView)this.Nub.getValue();
    AppMethodBeat.o(229163);
    return localMultiTrackCropView;
  }
  
  private final WeImageView guP()
  {
    AppMethodBeat.i(229165);
    WeImageView localWeImageView = (WeImageView)this.Nuh.getValue();
    AppMethodBeat.o(229165);
    return localWeImageView;
  }
  
  public final void LX(long paramLong)
  {
    AppMethodBeat.i(229202);
    if (this.ATq.bVd()) {
      guO().setProgress(paramLong);
    }
    AppMethodBeat.o(229202);
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(229198);
    if ((paramac != null) && (paramLong >= 0L)) {
      guO().SB(paramLong);
    }
    AppMethodBeat.o(229198);
  }
  
  public final void a(d.e parame)
  {
    this.Nrj = parame;
  }
  
  public final void b(ac paramac, long paramLong)
  {
    AppMethodBeat.i(229184);
    p.k(paramac, "composition");
    this.Nuj = false;
    bcM();
    this.Nui = paramLong;
    this.ATq.setShow(true);
    guO().setTrack(paramac);
    fGj();
    AppMethodBeat.o(229184);
  }
  
  public final ac c(ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(229177);
    p.k(paramac, "composition");
    paramac = this.Nuk.c(paramac, paramBoolean);
    AppMethodBeat.o(229177);
    return paramac;
  }
  
  public final ac d(ac paramac)
  {
    AppMethodBeat.i(229173);
    p.k(paramac, "composition");
    paramac = this.Nuk.d(paramac);
    AppMethodBeat.o(229173);
    return paramac;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(229172);
    if (this.ATq.bVd())
    {
      this.Nuj = false;
      this.ATq.setShow(false);
      AppMethodBeat.o(229172);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(229172);
    return bool;
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(229208);
    guP().setImageDrawable(au.o(this.APk.getContext(), com.tencent.mm.plugin.vlog.a.h.icons_filled_play, -1));
    AppMethodBeat.o(229208);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(229207);
    guP().setImageDrawable(au.o(this.APk.getContext(), com.tencent.mm.plugin.vlog.a.h.icons_filled_pause, -1));
    AppMethodBeat.o(229207);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(229170);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.Nuj = false;
      this.ATq.setShow(false);
    }
    AppMethodBeat.o(229170);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231844);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.a(this.Nun, false);
      a.b(this.Nun).setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(231844);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231492);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.a(this.Nun, true);
      a.b(this.Nun).setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(231492);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231223);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.c(this.Nun).performClick();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(231223);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<TextView>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$OnCropCallback;", "onTapDown", "", "position", "", "left", "", "startTimeMs", "", "endTimeMs", "onTapMove", "onTapUp", "pause", "resume", "seekTo", "time", "plugin-vlog_release"})
  public static final class j
    implements MultiTrackCropView.b
  {
    public final void a(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(223672);
      Object localObject = a.e(this.Nun);
      p.j(localObject, "progressIndicator");
      ((View)localObject).setVisibility(4);
      localObject = a.f(this.Nun);
      if (localObject != null) {
        ((d.e)localObject).pause();
      }
      localObject = this.Nun.APl;
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.c localc = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HST;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_COMPOSITION_TRACK_INDEX", paramInt);
      localBundle.putBoolean("EDIT_COMPOSITION_LEFT", paramBoolean);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((d)localObject).a(localc, localBundle);
      AppMethodBeat.o(223672);
    }
    
    public final void b(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(223673);
      Object localObject = a.e(this.Nun);
      p.j(localObject, "progressIndicator");
      ((View)localObject).setVisibility(0);
      localObject = this.Nun.APl;
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.c localc = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSU;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_COMPOSITION_TRACK_INDEX", paramInt);
      localBundle.putBoolean("EDIT_COMPOSITION_LEFT", paramBoolean);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((d)localObject).a(localc, localBundle);
      a.g(this.Nun);
      AppMethodBeat.o(223673);
    }
    
    public final void guQ()
    {
      AppMethodBeat.i(223675);
      a.g(this.Nun);
      AppMethodBeat.o(223675);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(223676);
      d.e locale = a.f(this.Nun);
      if (locale != null)
      {
        locale.pause();
        AppMethodBeat.o(223676);
        return;
      }
      AppMethodBeat.o(223676);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(223677);
      d.e locale = a.f(this.Nun);
      if (locale != null)
      {
        locale.Sw(paramLong);
        AppMethodBeat.o(223677);
        return;
      }
      AppMethodBeat.o(223677);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    k(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    l(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<View>
  {
    m(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<MultiTrackCropView>
  {
    n(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.a
 * JD-Core Version:    0.7.0.1
 */