package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.ui.plugin.d.c;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "lastSeekTime", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin$onCropCallback$1;", "originEnd", "originPlayRate", "", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "playStartOffset", "sourceDuration", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "trackCropView$delegate", "cancel", "", "checkInit", "isShowing", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setEnableLengthEdit", "enable", "setTrack", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "init", "maxTrackEnd", "setVisibility", "visibility", "", "updateHint", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.c
{
  final EditorPanelHolder Gvm;
  private long RhE;
  private final String TAG;
  private boolean UhB;
  private final j Uhs;
  private final j Uht;
  private final j Uhu;
  private final j Uhv;
  private final j Uhw;
  private long Uis;
  private long Uit;
  private long Uiu;
  private long Uiv;
  private long UjX;
  private float UjY;
  private long UjZ;
  private final e UqF;
  private boolean lYs;
  
  public h(EditorPanelHolder paramEditorPanelHolder, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282254);
    this.Gvm = paramEditorPanelHolder;
    this.TAG = "MicroMsg.VLogTrackEditPlugin";
    this.Uhs = k.cm((kotlin.g.a.a)new f(this));
    this.Uht = k.cm((kotlin.g.a.a)new g(this));
    this.Uhu = k.cm((kotlin.g.a.a)new c(this));
    this.Uhv = k.cm((kotlin.g.a.a)new a(this));
    this.Uhw = k.cm((kotlin.g.a.a)new d(this));
    this.UjY = 1.0F;
    this.UqF = new e(this, parama);
    AppMethodBeat.o(282254);
  }
  
  private static final void a(h paramh, View paramView)
  {
    AppMethodBeat.i(282305);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "this$0");
    paramh.Uiu = paramh.Uis;
    paramh.Uiv = paramh.Uit;
    paramh.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282305);
  }
  
  private static final void b(h paramh, View paramView)
  {
    AppMethodBeat.i(282313);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "this$0");
    paramh.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282313);
  }
  
  private final TextView eOX()
  {
    AppMethodBeat.i(282269);
    TextView localTextView = (TextView)this.Uhu.getValue();
    AppMethodBeat.o(282269);
    return localTextView;
  }
  
  private final void gVJ()
  {
    AppMethodBeat.i(282297);
    int i = kotlin.h.a.eH((float)(this.Uiv - this.Uiu) / 1000.0F);
    eOX().setText((CharSequence)this.Gvm.getContext().getString(a.i.video_track_edit_duration_cut_off, new Object[] { Integer.valueOf(i) }));
    AppMethodBeat.o(282297);
  }
  
  private final TrackCropView hTF()
  {
    AppMethodBeat.i(282262);
    TrackCropView localTrackCropView = (TrackCropView)this.Uht.getValue();
    AppMethodBeat.o(282262);
    return localTrackCropView;
  }
  
  public final void a(d.e parame) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282404);
    if (this.Gvm.cvt())
    {
      this.UhB = false;
      this.Gvm.setShow(false);
      AppMethodBeat.o(282404);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(282404);
    return bool;
  }
  
  public final void qU(long paramLong)
  {
    AppMethodBeat.i(282414);
    if (this.Gvm.cvt()) {
      hTF().setProgress(paramLong);
    }
    AppMethodBeat.o(282414);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282397);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.UhB = false;
      this.Gvm.setShow(false);
    }
    AppMethodBeat.o(282397);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    a(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements TrackCropView.a
  {
    e(h paramh, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama) {}
    
    public final void bA(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(282059);
      h.a(this.UqG, paramLong1);
      h.b(this.UqG, paramLong2);
      h.d(this.UqG);
      AppMethodBeat.o(282059);
    }
    
    public final void bz(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(282063);
      Log.i(h.e(this.UqG), "onScrollStateChanged: " + paramLong1 + ", " + paramLong2);
      Bundle localBundle = new Bundle();
      h.a(this.UqG, paramLong1);
      h.b(this.UqG, paramLong2);
      h.d(this.UqG);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      parama.a(a.c.NPx, localBundle);
      AppMethodBeat.o(282063);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(282068);
      a.b.a(parama, a.c.NOL);
      AppMethodBeat.o(282068);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(282073);
      if (System.currentTimeMillis() - h.f(this.UqG) > 15L)
      {
        h.c(this.UqG, System.currentTimeMillis());
        Bundle localBundle = new Bundle();
        localBundle.putLong("PARAM_1_LONG", paramLong);
        parama.a(a.c.NOp, localBundle);
      }
      AppMethodBeat.o(282073);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    f(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<TrackCropView>
  {
    g(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.h
 * JD-Core Version:    0.7.0.1
 */