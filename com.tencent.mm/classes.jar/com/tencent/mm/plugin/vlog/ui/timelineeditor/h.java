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
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "lastSeekTime", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin$onCropCallback$1;", "originEnd", "originPlayRate", "", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "playStartOffset", "sourceDuration", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "trackCropView$delegate", "cancel", "", "checkInit", "isShowing", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setEnableLengthEdit", "enable", "setTrack", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "init", "maxTrackEnd", "setVisibility", "visibility", "", "updateHint", "plugin-vlog_release"})
public final class h
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements com.tencent.mm.plugin.vlog.ui.plugin.d.c
{
  final d APl;
  final EditorPanelHolder ATq;
  private long KIe;
  private final g NEs;
  private final f Nua;
  private final f Nub;
  private final f Nuc;
  private final f Nud;
  private final f Nue;
  private boolean Nuj;
  private long Nvc;
  private long Nvd;
  private long Nve;
  private long Nvf;
  private long NwQ;
  private float NwR;
  private long NwS;
  private final String TAG;
  private boolean jvb;
  
  public h(EditorPanelHolder paramEditorPanelHolder, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(231353);
    this.ATq = paramEditorPanelHolder;
    this.APl = paramd;
    this.TAG = "MicroMsg.VLogTrackEditPlugin";
    this.Nua = g.ar((kotlin.g.a.a)new h(this));
    this.Nub = g.ar((kotlin.g.a.a)new i(this));
    this.Nuc = g.ar((kotlin.g.a.a)new e(this));
    this.Nud = g.ar((kotlin.g.a.a)new a(this));
    this.Nue = g.ar((kotlin.g.a.a)new f(this));
    this.NwR = 1.0F;
    this.NEs = new g(this);
    AppMethodBeat.o(231353);
  }
  
  private final TextView dQW()
  {
    AppMethodBeat.i(231329);
    TextView localTextView = (TextView)this.Nuc.getValue();
    AppMethodBeat.o(231329);
    return localTextView;
  }
  
  private final void fGj()
  {
    AppMethodBeat.i(231346);
    int i = kotlin.h.a.dm((float)(this.Nvf - this.Nve) / 1000.0F);
    TextView localTextView = dQW();
    p.j(localTextView, "hintText");
    localTextView.setText((CharSequence)this.ATq.getContext().getString(a.i.video_track_edit_duration_cut_off, new Object[] { Integer.valueOf(i) }));
    AppMethodBeat.o(231346);
  }
  
  private final TrackCropView gvQ()
  {
    AppMethodBeat.i(231326);
    TrackCropView localTrackCropView = (TrackCropView)this.Nub.getValue();
    AppMethodBeat.o(231326);
    return localTrackCropView;
  }
  
  public final void LX(long paramLong)
  {
    AppMethodBeat.i(231351);
    if (this.ATq.bVd()) {
      gvQ().setProgress(paramLong);
    }
    AppMethodBeat.o(231351);
  }
  
  public final void a(d.e parame) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(231337);
    if (this.ATq.bVd())
    {
      this.Nuj = false;
      this.ATq.setShow(false);
      AppMethodBeat.o(231337);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(231337);
    return bool;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(231333);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.Nuj = false;
      this.ATq.setShow(false);
    }
    AppMethodBeat.o(231333);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    a(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(225857);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      h.a(this.NEt, h.b(this.NEt));
      h.b(this.NEt, h.d(this.NEt));
      this.NEt.ATq.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(225857);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247467);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.NEt.ATq.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247467);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<TextView>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    f(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static final class g
    implements TrackCropView.a
  {
    public final void aN(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(229134);
      Log.i(h.g(this.NEt), "onScrollStateChanged: " + paramLong1 + ", " + paramLong2);
      Bundle localBundle = new Bundle();
      h.a(this.NEt, paramLong1);
      h.b(this.NEt, paramLong2);
      h.f(this.NEt);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      this.NEt.APl.a(com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSR, localBundle);
      AppMethodBeat.o(229134);
    }
    
    public final void aO(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(229132);
      h.a(this.NEt, paramLong1);
      h.b(this.NEt, paramLong2);
      h.f(this.NEt);
      AppMethodBeat.o(229132);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(229135);
      d.b.a(this.NEt.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSf);
      AppMethodBeat.o(229135);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(229136);
      if (System.currentTimeMillis() - h.h(this.NEt) > 15L)
      {
        h.c(this.NEt, System.currentTimeMillis());
        Bundle localBundle = new Bundle();
        localBundle.putLong("PARAM_1_LONG", paramLong);
        this.NEt.APl.a(com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HRJ, localBundle);
      }
      AppMethodBeat.o(229136);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    h(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<TrackCropView>
  {
    i(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.h
 * JD-Core Version:    0.7.0.1
 */