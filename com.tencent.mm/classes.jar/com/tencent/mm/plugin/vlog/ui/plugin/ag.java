package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1;", "originEnd", "originPlayRate", "", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "playStartOffset", "sourceDuration", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "trackCropView$delegate", "videoSeekable", "cancel", "", "checkInit", "isShowing", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "init", "maxTrackEnd", "setVisibility", "visibility", "", "updateHint", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.c
{
  final EditorPanelHolder Gvm;
  final String TAG;
  boolean UhB;
  private final j Uhs;
  private final j Uht;
  private final j Uhu;
  private final j Uhv;
  private final j Uhw;
  d.e Uia;
  d.e Uib;
  private long Uis;
  private long Uit;
  long Uiu;
  long Uiv;
  private long UjX;
  private float UjY;
  private long UjZ;
  private final e Uka;
  private boolean lYs;
  
  public ag(EditorPanelHolder paramEditorPanelHolder, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282679);
    this.Gvm = paramEditorPanelHolder;
    this.TAG = "MicroMsg.VLogTrackEditPlugin";
    this.Uhs = k.cm((kotlin.g.a.a)new f(this));
    this.Uht = k.cm((kotlin.g.a.a)new g(this));
    this.Uhu = k.cm((kotlin.g.a.a)new c(this));
    this.Uhv = k.cm((kotlin.g.a.a)new a(this));
    this.Uhw = k.cm((kotlin.g.a.a)new d(this));
    this.UjY = 1.0F;
    this.Uka = new e(this, parama);
    AppMethodBeat.o(282679);
  }
  
  private void a(ad paramad, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(282705);
    s.u(paramad, "track");
    if ((paramBoolean) && (this.Uiv != 0L))
    {
      this.Uka.bz(this.Uiu, this.Uiv);
      AppMethodBeat.o(282705);
      return;
    }
    this.UhB = false;
    if (!this.lYs)
    {
      this.lYs = true;
      this.Gvm.setCloseTouchOutside(false);
      hTF().setCallback((TrackCropView.a)this.Uka);
      localObject = (ImageView)this.Uhv.getValue();
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener(new ag..ExternalSyntheticLambda1(this));
      }
      localObject = (ImageView)this.Uhw.getValue();
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener(new ag..ExternalSyntheticLambda0(this));
      }
      this.Gvm.setOnVisibleChangeCallback((kotlin.g.a.b)new b(this));
    }
    Object localObject = new ad(paramad.path, paramad.type);
    ((ad)localObject).wC(paramad.UaI.UjZ);
    ((ad)localObject).wA(((float)paramad.UaI.UjZ / paramad.UaI.sAn));
    ((ad)localObject).setPlayRate(paramad.UaI.sAn);
    ((ad)localObject).UaI.agDB = 0L;
    ((ad)localObject).UaI.agDC = ((ad)localObject).UaI.endTimeMs;
    ((ad)localObject).UaI.jLQ();
    this.UjX = paramad.UaI.startTimeMs;
    this.Uis = paramad.UaI.TDw;
    this.Uit = Math.min(paramad.UaI.TDx, paramLong);
    this.UjY = paramad.UaI.sAn;
    this.Uiu = (((float)this.Uis / this.UjY));
    this.Uiv = (((float)this.Uit / this.UjY));
    this.UjZ = paramad.UaI.UjZ;
    localObject = new ac(p.listOf(localObject));
    ((ac)localObject).bs(((float)this.Uis / paramad.UaI.sAn), ((float)this.Uit / paramad.UaI.sAn));
    paramad = hTF();
    s.s(paramad, "trackCropView");
    TrackCropView.a(paramad, (ac)localObject);
    this.Gvm.setShow(true);
    gVJ();
    AppMethodBeat.o(282705);
  }
  
  private static final void a(ag paramag, View paramView)
  {
    AppMethodBeat.i(282729);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramag);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramag, "this$0");
    paramag.UhB = false;
    paramag.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282729);
  }
  
  private static final void b(ag paramag, View paramView)
  {
    AppMethodBeat.i(282738);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramag);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramag, "this$0");
    paramag.UhB = true;
    paramag.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282738);
  }
  
  private final TextView eOX()
  {
    AppMethodBeat.i(282687);
    TextView localTextView = (TextView)this.Uhu.getValue();
    AppMethodBeat.o(282687);
    return localTextView;
  }
  
  public final void a(d.e parame) {}
  
  public final void a(d.e parame1, d.e parame2)
  {
    this.Uia = parame1;
    this.Uib = parame2;
  }
  
  final void gVJ()
  {
    AppMethodBeat.i(282802);
    Math.round((float)this.UjZ / this.UjY / 1000.0F);
    int i = Math.round((float)(this.Uiv - this.Uiu) / 1000.0F);
    eOX().setText((CharSequence)this.Gvm.getContext().getString(a.i.video_track_edit_duration_cut_off, new Object[] { Integer.valueOf(i) }));
    AppMethodBeat.o(282802);
  }
  
  final TrackCropView hTF()
  {
    AppMethodBeat.i(282766);
    TrackCropView localTrackCropView = (TrackCropView)this.Uht.getValue();
    AppMethodBeat.o(282766);
    return localTrackCropView;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(282823);
    if (this.Gvm.getVisibility() == 0)
    {
      AppMethodBeat.o(282823);
      return true;
    }
    AppMethodBeat.o(282823);
    return false;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282790);
    if (this.Gvm.cvt())
    {
      this.UhB = false;
      this.Gvm.setShow(false);
      AppMethodBeat.o(282790);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(282790);
    return bool;
  }
  
  public final void qU(long paramLong)
  {
    AppMethodBeat.i(282816);
    if (this.Gvm.cvt()) {
      hTF().setProgress(paramLong);
    }
    AppMethodBeat.o(282816);
  }
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(282780);
    hTF().setEnableLengthEdit(paramBoolean);
    AppMethodBeat.o(282780);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282783);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.UhB = false;
      this.Gvm.setShow(false);
    }
    AppMethodBeat.o(282783);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    a(ag paramag)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(ag paramag)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(ag paramag)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    d(ag paramag)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements TrackCropView.a
  {
    e(ag paramag, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama) {}
    
    public final void bA(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(282563);
      this.Ukb.Uiu = paramLong1;
      this.Ukb.Uiv = paramLong2;
      this.Ukb.gVJ();
      AppMethodBeat.o(282563);
    }
    
    public final void bz(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(282575);
      Log.i(this.Ukb.TAG, "onScrollStateChanged: " + paramLong1 + ", " + paramLong2);
      Object localObject = new Bundle();
      this.Ukb.Uiu = paramLong1;
      this.Ukb.Uiv = paramLong2;
      this.Ukb.gVJ();
      ((Bundle)localObject).putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      ((Bundle)localObject).putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((Bundle)localObject).putBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", true);
      parama.a(a.c.NPx, (Bundle)localObject);
      localObject = this.Ukb.Uia;
      if (localObject != null) {
        ((d.e)localObject).resume();
      }
      AppMethodBeat.o(282575);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(282578);
      d.e locale = this.Ukb.Uia;
      if (locale != null) {
        locale.pause();
      }
      locale = this.Ukb.Uib;
      if (locale != null) {
        locale.pause();
      }
      AppMethodBeat.o(282578);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(282585);
      d.e locale = this.Ukb.Uia;
      if (locale != null) {
        locale.wK(paramLong);
      }
      AppMethodBeat.o(282585);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    f(ag paramag)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<TrackCropView>
  {
    g(ag paramag)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ag
 * JD-Core Version:    0.7.0.1
 */