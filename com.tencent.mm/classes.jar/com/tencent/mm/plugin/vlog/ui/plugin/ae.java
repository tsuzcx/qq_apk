package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1;", "originEnd", "originPlayRate", "", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "playStartOffset", "sourceDuration", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "trackCropView$delegate", "videoSeekable", "cancel", "", "checkInit", "isShowing", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "init", "maxTrackEnd", "setVisibility", "visibility", "", "updateHint", "plugin-vlog_release"})
public final class ae
  implements t, c.c
{
  private long BMA;
  long BMB;
  long BMC;
  private long BMD;
  boolean BME;
  public c.e BMF;
  public c.e BMG;
  private final f BMu;
  private final f BMv;
  private final f BMw;
  private final f BMx;
  private final f BMy;
  private long BMz;
  private long BPo;
  private float BPp;
  private final g BPq;
  final String TAG;
  private boolean gcX;
  final d sQE;
  public final EditorPanelHolder sRz;
  
  public ae(EditorPanelHolder paramEditorPanelHolder, d paramd)
  {
    AppMethodBeat.i(196442);
    this.sRz = paramEditorPanelHolder;
    this.sQE = paramd;
    this.TAG = "MicroMsg.VLogTrackEditPlugin";
    this.BMu = g.O((d.g.a.a)new h(this));
    this.BMv = g.O((d.g.a.a)new i(this));
    this.BMw = g.O((d.g.a.a)new e(this));
    this.BMx = g.O((d.g.a.a)new a(this));
    this.BMy = g.O((d.g.a.a)new f(this));
    this.BPp = 1.0F;
    this.BPq = new g(this);
    AppMethodBeat.o(196442);
  }
  
  private void a(w paramw, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(196438);
    p.h(paramw, "track");
    if ((paramBoolean) && (this.BMC != 0L))
    {
      this.BPq.au(this.BMB, this.BMC);
      AppMethodBeat.o(196438);
      return;
    }
    this.BME = false;
    if (!this.gcX)
    {
      this.gcX = true;
      this.sRz.setCloseTouchOutside(false);
      etc().setCallback((TrackCropView.a)this.BPq);
      localObject = (ImageView)this.BMx.getValue();
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener((View.OnClickListener)new b(this));
      }
      localObject = (ImageView)this.BMy.getValue();
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener((View.OnClickListener)new c(this));
      }
      this.sRz.setOnVisibleChangeCallback((d.g.a.b)new d(this));
    }
    Object localObject = new w(paramw.path, paramw.type);
    ((w)localObject).Bl(paramw.BGw.BMD);
    ((w)localObject).Bj(((float)paramw.BGw.BMD / paramw.BGw.llC));
    ((w)localObject).setPlayRate(paramw.BGw.llC);
    ((w)localObject).BGw.LmC = 0L;
    ((w)localObject).BGw.LmD = ((w)localObject).BGw.hiy;
    ((w)localObject).BGw.fyp();
    this.BPo = paramw.BGw.startTimeMs;
    this.BMz = paramw.BGw.HCU;
    this.BMA = Math.min(paramw.BGw.HCV, paramLong);
    this.BPp = paramw.BGw.llC;
    this.BMB = (((float)this.BMz / this.BPp));
    this.BMC = (((float)this.BMA / this.BPp));
    this.BMD = paramw.BGw.BMD;
    localObject = new v(j.listOf(localObject));
    ((v)localObject).ar(((float)this.BMz / paramw.BGw.llC), ((float)this.BMA / paramw.BGw.llC));
    TrackCropView.a(etc(), (v)localObject);
    this.sRz.setShow(true);
    dNH();
    AppMethodBeat.o(196438);
  }
  
  private final TextView etd()
  {
    AppMethodBeat.i(196434);
    TextView localTextView = (TextView)this.BMw.getValue();
    AppMethodBeat.o(196434);
    return localTextView;
  }
  
  public final void Bq(long paramLong)
  {
    AppMethodBeat.i(196441);
    if (this.sRz.bni()) {
      etc().setProgress(paramLong);
    }
    AppMethodBeat.o(196441);
  }
  
  public final void a(c.e parame) {}
  
  public final boolean aoB()
  {
    AppMethodBeat.i(196437);
    if (this.sRz.bni())
    {
      this.BME = false;
      this.sRz.setShow(false);
      AppMethodBeat.o(196437);
      return true;
    }
    AppMethodBeat.o(196437);
    return false;
  }
  
  public final void ayX() {}
  
  final void dNH()
  {
    AppMethodBeat.i(196440);
    int i = Math.round((float)this.BMD / this.BPp / 1000.0F);
    int j = Math.round((float)(this.BMC - this.BMB) / 1000.0F);
    TextView localTextView = etd();
    p.g(localTextView, "hintText");
    localTextView.setText((CharSequence)this.sRz.getContext().getString(2131767223, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    AppMethodBeat.o(196440);
  }
  
  final TrackCropView etc()
  {
    AppMethodBeat.i(196433);
    TrackCropView localTrackCropView = (TrackCropView)this.BMv.getValue();
    AppMethodBeat.o(196433);
    return localTrackCropView;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196443);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196443);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(196435);
    etc().setEnableLengthEdit(paramBoolean);
    AppMethodBeat.o(196435);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196436);
    if (paramInt == 8)
    {
      this.BME = false;
      this.sRz.setShow(false);
    }
    AppMethodBeat.o(196436);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<ImageView>
  {
    a(ae paramae)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ae paramae) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196422);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.BPr.BME = false;
      this.BPr.sRz.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196422);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ae paramae) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196423);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.BPr.BME = true;
      this.BPr.sRz.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196423);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Boolean, z>
  {
    d(ae paramae)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<TextView>
  {
    e(ae paramae)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<ImageView>
  {
    f(ae paramae)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static final class g
    implements TrackCropView.a
  {
    public final void at(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(196427);
      this.BPr.BMB = paramLong1;
      this.BPr.BMC = paramLong2;
      this.BPr.dNH();
      AppMethodBeat.o(196427);
    }
    
    public final void au(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(196428);
      ad.i(this.BPr.TAG, "onScrollStateChanged: " + paramLong1 + ", " + paramLong2);
      Object localObject = new Bundle();
      this.BPr.BMB = paramLong1;
      this.BPr.BMC = paramLong2;
      this.BPr.dNH();
      ((Bundle)localObject).putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      ((Bundle)localObject).putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((Bundle)localObject).putBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", true);
      this.BPr.sQE.a(d.c.xFz, (Bundle)localObject);
      localObject = this.BPr.BMF;
      if (localObject != null)
      {
        ((c.e)localObject).resume();
        AppMethodBeat.o(196428);
        return;
      }
      AppMethodBeat.o(196428);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(196429);
      c.e locale = this.BPr.BMF;
      if (locale != null) {
        locale.pause();
      }
      locale = this.BPr.BMG;
      if (locale != null)
      {
        locale.pause();
        AppMethodBeat.o(196429);
        return;
      }
      AppMethodBeat.o(196429);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(196430);
      c.e locale = this.BPr.BMF;
      if (locale != null)
      {
        locale.Br(paramLong);
        AppMethodBeat.o(196430);
        return;
      }
      AppMethodBeat.o(196430);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<ViewGroup>
  {
    h(ae paramae)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<TrackCropView>
  {
    i(ae paramae)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ae
 * JD-Core Version:    0.7.0.1
 */