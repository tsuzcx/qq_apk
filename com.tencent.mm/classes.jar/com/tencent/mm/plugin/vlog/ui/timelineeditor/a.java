package com.tencent.mm.plugin.vlog.ui.timelineeditor;

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
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.plugin.vlog.ui.plugin.u.a;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPlayStatusPlugin$PlayStatusListener;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cutDuration", "", "getCutDuration", "()J", "externalStatusIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getExternalStatusIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "externalStatusIcon$delegate", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "getLayout", "()Landroid/view/ViewGroup;", "maxTrackEnd", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$onCropCallback$1;", "panelRoot", "getPanelRoot", "panelRoot$delegate", "playStatusIcon", "getPlayStatusIcon", "playStatusIcon$delegate", "progressIndicator", "Landroid/view/View;", "getProgressIndicator", "()Landroid/view/View;", "progressIndicator$delegate", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "sourceDuration", "getSourceDuration", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView;", "trackCropView$delegate", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "onVideoPause", "onVideoPlay", "seek", "setEnableLengthEdit", "enable", "setTrack", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "setVisibility", "visibility", "", "updateHint", "Companion", "plugin-vlog_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements com.tencent.mm.plugin.vlog.ui.plugin.d.c, u.a
{
  public static final a NDM;
  final ViewGroup APk;
  final d APl;
  private final EditorPanelHolder ATq;
  private final j NDL;
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
  private boolean jvb;
  
  static
  {
    AppMethodBeat.i(246848);
    NDM = new a((byte)0);
    AppMethodBeat.o(246848);
  }
  
  public a(ViewGroup paramViewGroup, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(246845);
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
    this.NDL = new j(this);
    AppMethodBeat.o(246845);
  }
  
  private final TextView dQW()
  {
    AppMethodBeat.i(246833);
    TextView localTextView = (TextView)this.Nuc.getValue();
    AppMethodBeat.o(246833);
    return localTextView;
  }
  
  private final void fGj()
  {
    AppMethodBeat.i(246839);
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
      AppMethodBeat.o(246839);
      return;
    }
  }
  
  private final WeImageView guP()
  {
    AppMethodBeat.i(246834);
    WeImageView localWeImageView = (WeImageView)this.Nuh.getValue();
    AppMethodBeat.o(246834);
    return localWeImageView;
  }
  
  public final void LX(long paramLong)
  {
    AppMethodBeat.i(246840);
    if (this.ATq.bVd()) {
      guO().setProgress(paramLong);
    }
    AppMethodBeat.o(246840);
  }
  
  public final void a(d.e parame)
  {
    this.Nrj = parame;
  }
  
  public final MultiTrackCropView guO()
  {
    AppMethodBeat.i(246830);
    MultiTrackCropView localMultiTrackCropView = (MultiTrackCropView)this.Nub.getValue();
    AppMethodBeat.o(246830);
    return localMultiTrackCropView;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(246837);
    if (this.ATq.bVd())
    {
      this.Nuj = false;
      this.ATq.setShow(false);
      AppMethodBeat.o(246837);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(246837);
    return bool;
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(246844);
    guP().setImageDrawable(au.o(this.APk.getContext(), com.tencent.mm.plugin.vlog.a.h.icons_filled_play, -1));
    AppMethodBeat.o(246844);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(246842);
    guP().setImageDrawable(au.o(this.APk.getContext(), com.tencent.mm.plugin.vlog.a.h.icons_filled_pause, -1));
    AppMethodBeat.o(246842);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(246836);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.Nuj = false;
      this.ATq.setShow(false);
    }
    AppMethodBeat.o(246836);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
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
      AppMethodBeat.i(241899);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.a(this.NDN, false);
      a.b(this.NDN).setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(241899);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227875);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.a(this.NDN, true);
      a.b(this.NDN).setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(227875);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(224477);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      a.c(this.NDN).performClick();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(224477);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorCompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackCropView$OnCropCallback;", "onTapDown", "", "position", "", "left", "", "startTimeMs", "", "endTimeMs", "onTapMove", "onTapUp", "pause", "resume", "seekTo", "time", "plugin-vlog_release"})
  public static final class j
    implements MultiTrackCropView.b
  {
    public final void a(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(237058);
      Object localObject = a.e(this.NDN);
      p.j(localObject, "progressIndicator");
      ((View)localObject).setVisibility(4);
      localObject = a.f(this.NDN);
      if (localObject != null) {
        ((d.e)localObject).pause();
      }
      localObject = this.NDN.APl;
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.c localc = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HST;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_COMPOSITION_TRACK_INDEX", paramInt);
      localBundle.putBoolean("EDIT_COMPOSITION_LEFT", paramBoolean);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((d)localObject).a(localc, localBundle);
      AppMethodBeat.o(237058);
    }
    
    public final void b(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(237061);
      Object localObject = a.e(this.NDN);
      p.j(localObject, "progressIndicator");
      ((View)localObject).setVisibility(0);
      localObject = this.NDN.APl;
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.c localc = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HST;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_COMPOSITION_TRACK_INDEX", paramInt);
      localBundle.putBoolean("EDIT_COMPOSITION_LEFT", paramBoolean);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((d)localObject).a(localc, localBundle);
      a.g(this.NDN);
      AppMethodBeat.o(237061);
    }
    
    public final void guQ()
    {
      AppMethodBeat.i(237063);
      a.g(this.NDN);
      AppMethodBeat.o(237063);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(237064);
      d.e locale = a.f(this.NDN);
      if (locale != null)
      {
        locale.pause();
        AppMethodBeat.o(237064);
        return;
      }
      AppMethodBeat.o(237064);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(237066);
      d.e locale = a.f(this.NDN);
      if (locale != null)
      {
        locale.Sw(paramLong);
        AppMethodBeat.o(237066);
        return;
      }
      AppMethodBeat.o(237066);
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
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.a
 * JD-Core Version:    0.7.0.1
 */