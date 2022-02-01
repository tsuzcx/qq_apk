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
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1;", "originEnd", "originPlayRate", "", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "playStartOffset", "sourceDuration", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "trackCropView$delegate", "videoSeekable", "cancel", "", "checkInit", "isShowing", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "init", "maxTrackEnd", "setVisibility", "visibility", "", "updateHint", "plugin-vlog_release"})
public final class ah
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.c
{
  final d APl;
  final EditorPanelHolder ATq;
  d.e NuG;
  d.e NuH;
  private final f Nua;
  private final f Nub;
  private final f Nuc;
  private final f Nud;
  private final f Nue;
  boolean Nuj;
  private long Nvc;
  private long Nvd;
  long Nve;
  long Nvf;
  private long NwQ;
  private float NwR;
  private long NwS;
  private final g NwT;
  final String TAG;
  private boolean jvb;
  
  public ah(EditorPanelHolder paramEditorPanelHolder, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(224929);
    this.ATq = paramEditorPanelHolder;
    this.APl = paramd;
    this.TAG = "MicroMsg.VLogTrackEditPlugin";
    this.Nua = g.ar((kotlin.g.a.a)new h(this));
    this.Nub = g.ar((kotlin.g.a.a)new i(this));
    this.Nuc = g.ar((kotlin.g.a.a)new e(this));
    this.Nud = g.ar((kotlin.g.a.a)new a(this));
    this.Nue = g.ar((kotlin.g.a.a)new f(this));
    this.NwR = 1.0F;
    this.NwT = new g(this);
    AppMethodBeat.o(224929);
  }
  
  private void a(ad paramad, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(224912);
    p.k(paramad, "track");
    if ((paramBoolean) && (this.Nvf != 0L))
    {
      this.NwT.aN(this.Nve, this.Nvf);
      AppMethodBeat.o(224912);
      return;
    }
    this.Nuj = false;
    if (!this.jvb)
    {
      this.jvb = true;
      this.ATq.setCloseTouchOutside(false);
      gvQ().setCallback((TrackCropView.a)this.NwT);
      localObject = (ImageView)this.Nud.getValue();
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener((View.OnClickListener)new b(this));
      }
      localObject = (ImageView)this.Nue.getValue();
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener((View.OnClickListener)new c(this));
      }
      this.ATq.setOnVisibleChangeCallback((kotlin.g.a.b)new d(this));
    }
    Object localObject = new ad(paramad.path, paramad.type);
    ((ad)localObject).So(paramad.Nng.NwS);
    ((ad)localObject).Sm(((float)paramad.Nng.NwS / paramad.Nng.pvh));
    ((ad)localObject).setPlayRate(paramad.Nng.pvh);
    ((ad)localObject).Nng.YHU = 0L;
    ((ad)localObject).Nng.YHV = ((ad)localObject).Nng.endTimeMs;
    ((ad)localObject).Nng.igC();
    this.NwQ = paramad.Nng.startTimeMs;
    this.Nvc = paramad.Nng.MQV;
    this.Nvd = Math.min(paramad.Nng.MQW, paramLong);
    this.NwR = paramad.Nng.pvh;
    this.Nve = (((float)this.Nvc / this.NwR));
    this.Nvf = (((float)this.Nvd / this.NwR));
    this.NwS = paramad.Nng.NwS;
    localObject = new ac(j.listOf(localObject));
    ((ac)localObject).aG(((float)this.Nvc / paramad.Nng.pvh), ((float)this.Nvd / paramad.Nng.pvh));
    TrackCropView.a(gvQ(), (ac)localObject);
    this.ATq.setShow(true);
    fGj();
    AppMethodBeat.o(224912);
  }
  
  private final TextView dQW()
  {
    AppMethodBeat.i(224885);
    TextView localTextView = (TextView)this.Nuc.getValue();
    AppMethodBeat.o(224885);
    return localTextView;
  }
  
  public final void LX(long paramLong)
  {
    AppMethodBeat.i(224921);
    if (this.ATq.bVd()) {
      gvQ().setProgress(paramLong);
    }
    AppMethodBeat.o(224921);
  }
  
  public final void a(d.e parame) {}
  
  public final void a(d.e parame1, d.e parame2)
  {
    this.NuG = parame1;
    this.NuH = parame2;
  }
  
  final void fGj()
  {
    AppMethodBeat.i(224919);
    Math.round((float)this.NwS / this.NwR / 1000.0F);
    int i = Math.round((float)(this.Nvf - this.Nve) / 1000.0F);
    TextView localTextView = dQW();
    p.j(localTextView, "hintText");
    localTextView.setText((CharSequence)this.ATq.getContext().getString(a.i.video_track_edit_duration_cut_off, new Object[] { Integer.valueOf(i) }));
    AppMethodBeat.o(224919);
  }
  
  final TrackCropView gvQ()
  {
    AppMethodBeat.i(224884);
    TrackCropView localTrackCropView = (TrackCropView)this.Nub.getValue();
    AppMethodBeat.o(224884);
    return localTrackCropView;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(224923);
    if (this.ATq.getVisibility() == 0)
    {
      AppMethodBeat.o(224923);
      return true;
    }
    AppMethodBeat.o(224923);
    return false;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(224895);
    if (this.ATq.bVd())
    {
      this.Nuj = false;
      this.ATq.setShow(false);
      AppMethodBeat.o(224895);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(224895);
    return bool;
  }
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(224889);
    gvQ().setEnableLengthEdit(paramBoolean);
    AppMethodBeat.o(224889);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(224893);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.Nuj = false;
      this.ATq.setShow(false);
    }
    AppMethodBeat.o(224893);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    a(ah paramah)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ah paramah) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(251833);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.NwU.Nuj = false;
      this.NwU.ATq.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(251833);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ah paramah) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250160);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.NwU.Nuj = true;
      this.NwU.ATq.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250160);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(ah paramah)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<TextView>
  {
    e(ah paramah)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    f(ah paramah)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static final class g
    implements TrackCropView.a
  {
    public final void aN(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(228625);
      Log.i(this.NwU.TAG, "onScrollStateChanged: " + paramLong1 + ", " + paramLong2);
      Object localObject = new Bundle();
      this.NwU.Nve = paramLong1;
      this.NwU.Nvf = paramLong2;
      this.NwU.fGj();
      ((Bundle)localObject).putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      ((Bundle)localObject).putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((Bundle)localObject).putBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", true);
      this.NwU.APl.a(com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSR, (Bundle)localObject);
      localObject = this.NwU.NuG;
      if (localObject != null)
      {
        ((d.e)localObject).resume();
        AppMethodBeat.o(228625);
        return;
      }
      AppMethodBeat.o(228625);
    }
    
    public final void aO(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(228619);
      this.NwU.Nve = paramLong1;
      this.NwU.Nvf = paramLong2;
      this.NwU.fGj();
      AppMethodBeat.o(228619);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(228628);
      d.e locale = this.NwU.NuG;
      if (locale != null) {
        locale.pause();
      }
      locale = this.NwU.NuH;
      if (locale != null)
      {
        locale.pause();
        AppMethodBeat.o(228628);
        return;
      }
      AppMethodBeat.o(228628);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(228631);
      d.e locale = this.NwU.NuG;
      if (locale != null)
      {
        locale.Sw(paramLong);
        AppMethodBeat.o(228631);
        return;
      }
      AppMethodBeat.o(228631);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    h(ah paramah)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<TrackCropView>
  {
    i(ah paramah)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ah
 * JD-Core Version:    0.7.0.1
 */