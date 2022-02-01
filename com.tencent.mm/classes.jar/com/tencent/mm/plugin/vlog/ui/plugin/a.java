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
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.videocomposition.h;
import com.tencent.tav.coremedia.CMTimeRange;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "getLayout", "()Landroid/view/ViewGroup;", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "getPanelRoot", "panelRoot$delegate", "sourceDuration", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "trackCropView$delegate", "videoSeekable", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "init", "setVisibility", "visibility", "", "updateHint", "plugin-vlog_release"})
public final class a
  implements t, c.c
{
  long BMA;
  long BMB;
  long BMC;
  private long BMD;
  boolean BME;
  public c.e BMF;
  public c.e BMG;
  private final g BMH;
  private final ViewGroup BMI;
  private final f BMu;
  private final f BMv;
  private final f BMw;
  private final f BMx;
  private final f BMy;
  long BMz;
  final String TAG;
  private boolean gcX;
  final d sQE;
  final EditorPanelHolder sRz;
  
  public a(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(196117);
    this.BMI = paramViewGroup;
    this.sQE = paramd;
    this.TAG = "MicroMsg.CompositionEditPlugin";
    paramViewGroup = this.BMI.getContext();
    p.g(paramViewGroup, "layout.context");
    paramViewGroup = new EditorPanelHolder(paramViewGroup);
    this.BMI.addView((View)paramViewGroup);
    paramViewGroup.setVisibility(8);
    this.sRz = paramViewGroup;
    this.BMu = g.O((d.g.a.a)new h(this));
    this.BMv = g.O((d.g.a.a)new i(this));
    this.BMw = g.O((d.g.a.a)new e(this));
    this.BMx = g.O((d.g.a.a)new a(this));
    this.BMy = g.O((d.g.a.a)new f(this));
    this.BMH = new g(this);
    AppMethodBeat.o(196117);
  }
  
  private final TextView etd()
  {
    AppMethodBeat.i(196110);
    TextView localTextView = (TextView)this.BMw.getValue();
    AppMethodBeat.o(196110);
    return localTextView;
  }
  
  private final void ete()
  {
    AppMethodBeat.i(196111);
    if (this.gcX)
    {
      AppMethodBeat.o(196111);
      return;
    }
    this.gcX = true;
    this.sRz.setCloseTouchOutside(false);
    etc().setCallback((TrackCropView.a)this.BMH);
    ((ImageView)this.BMx.getValue()).setOnClickListener((View.OnClickListener)new b(this));
    ((ImageView)this.BMy.getValue()).setOnClickListener((View.OnClickListener)new c(this));
    this.sRz.setOnVisibleChangeCallback((d.g.a.b)new d(this));
    AppMethodBeat.o(196111);
  }
  
  public final void Bq(long paramLong)
  {
    AppMethodBeat.i(196116);
    if (this.sRz.bni()) {
      etc().setProgress(paramLong);
    }
    AppMethodBeat.o(196116);
  }
  
  public final void a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(196114);
    p.h(paramv, "composition");
    if ((paramBoolean) && (this.BMC != 0L))
    {
      this.BMH.au(this.BMB, this.BMC);
      AppMethodBeat.o(196114);
      return;
    }
    this.BME = false;
    ete();
    this.BMz = (paramv.BGk.esb().getStartUs() / 1000L);
    this.BMA = (paramv.BGk.esb().getEndUs() / 1000L);
    this.BMB = this.BMz;
    this.BMC = this.BMA;
    this.sRz.setShow(true);
    this.BMD = paramv.BGk.fPE();
    TrackCropView.a(etc(), paramv);
    dNH();
    AppMethodBeat.o(196114);
  }
  
  public final void a(c.e parame) {}
  
  public final boolean aoB()
  {
    AppMethodBeat.i(196113);
    if (this.sRz.bni())
    {
      this.BME = false;
      this.sRz.setShow(false);
      AppMethodBeat.o(196113);
      return true;
    }
    AppMethodBeat.o(196113);
    return false;
  }
  
  public final void ayX() {}
  
  final void dNH()
  {
    AppMethodBeat.i(196115);
    int i = Math.round((float)this.BMD / 1000.0F);
    int j = Math.round((float)(this.BMC - this.BMB) / 1000.0F);
    TextView localTextView = etd();
    p.g(localTextView, "hintText");
    localTextView.setText((CharSequence)this.sRz.getContext().getString(2131767223, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    AppMethodBeat.o(196115);
  }
  
  final TrackCropView etc()
  {
    AppMethodBeat.i(196109);
    TrackCropView localTrackCropView = (TrackCropView)this.BMv.getValue();
    AppMethodBeat.o(196109);
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
    AppMethodBeat.i(196118);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196118);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196112);
    if (paramInt == 8)
    {
      this.BME = false;
      this.sRz.setShow(false);
    }
    AppMethodBeat.o(196112);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<ImageView>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196098);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.BMJ.BME = false;
      this.BMJ.sRz.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196098);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196099);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.BMJ.BME = true;
      this.BMJ.sRz.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196099);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Boolean, z>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<TextView>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<ImageView>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static final class g
    implements TrackCropView.a
  {
    public final void at(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(196103);
      this.BMJ.BMB = paramLong1;
      this.BMJ.BMC = paramLong2;
      this.BMJ.dNH();
      AppMethodBeat.o(196103);
    }
    
    public final void au(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(196104);
      ad.i(this.BMJ.TAG, "onScrollStateChanged: " + paramLong1 + ", " + paramLong2);
      Object localObject = new Bundle();
      this.BMJ.BMB = paramLong1;
      this.BMJ.BMC = paramLong2;
      this.BMJ.dNH();
      ((Bundle)localObject).putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      ((Bundle)localObject).putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((Bundle)localObject).putBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", true);
      this.BMJ.sQE.a(d.c.xFA, (Bundle)localObject);
      localObject = this.BMJ.BMF;
      if (localObject != null)
      {
        ((c.e)localObject).resume();
        AppMethodBeat.o(196104);
        return;
      }
      AppMethodBeat.o(196104);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(196105);
      c.e locale = this.BMJ.BMF;
      if (locale != null) {
        locale.pause();
      }
      locale = this.BMJ.BMG;
      if (locale != null)
      {
        locale.pause();
        AppMethodBeat.o(196105);
        return;
      }
      AppMethodBeat.o(196105);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(196106);
      c.e locale = this.BMJ.BMF;
      if (locale != null)
      {
        locale.Br(paramLong);
        AppMethodBeat.o(196106);
        return;
      }
      AppMethodBeat.o(196106);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<ViewGroup>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<TrackCropView>
  {
    i(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.a
 * JD-Core Version:    0.7.0.1
 */