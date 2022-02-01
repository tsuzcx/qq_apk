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
import d.a.j;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1;", "originEnd", "originPlayRate", "", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "playStartOffset", "sourceDuration", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "trackCropView$delegate", "videoSeekable", "cancel", "", "checkInit", "isShowing", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "init", "maxTrackEnd", "setVisibility", "visibility", "", "updateHint", "plugin-vlog_release"})
public final class ae
  implements t, c.c
{
  private final f CdT;
  private final f CdU;
  private final f CdV;
  private final f CdW;
  private final f CdX;
  private long CdY;
  private long CdZ;
  long Cea;
  long Ceb;
  private long Cec;
  boolean Ced;
  public c.e Cee;
  public c.e Cef;
  private long CgN;
  private float CgO;
  private final g CgP;
  final String TAG;
  private boolean gff;
  final d tbP;
  public final EditorPanelHolder tcK;
  
  public ae(EditorPanelHolder paramEditorPanelHolder, d paramd)
  {
    AppMethodBeat.i(191901);
    this.tcK = paramEditorPanelHolder;
    this.tbP = paramd;
    this.TAG = "MicroMsg.VLogTrackEditPlugin";
    this.CdT = g.O((d.g.a.a)new h(this));
    this.CdU = g.O((d.g.a.a)new i(this));
    this.CdV = g.O((d.g.a.a)new e(this));
    this.CdW = g.O((d.g.a.a)new a(this));
    this.CdX = g.O((d.g.a.a)new f(this));
    this.CgO = 1.0F;
    this.CgP = new g(this);
    AppMethodBeat.o(191901);
  }
  
  private void a(w paramw, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(191897);
    p.h(paramw, "track");
    if ((paramBoolean) && (this.Ceb != 0L))
    {
      this.CgP.at(this.Cea, this.Ceb);
      AppMethodBeat.o(191897);
      return;
    }
    this.Ced = false;
    if (!this.gff)
    {
      this.gff = true;
      this.tcK.setCloseTouchOutside(false);
      ewJ().setCallback((TrackCropView.a)this.CgP);
      localObject = (ImageView)this.CdW.getValue();
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener((View.OnClickListener)new b(this));
      }
      localObject = (ImageView)this.CdX.getValue();
      if (localObject != null) {
        ((ImageView)localObject).setOnClickListener((View.OnClickListener)new c(this));
      }
      this.tcK.setOnVisibleChangeCallback((d.g.a.b)new d(this));
    }
    Object localObject = new w(paramw.path, paramw.type);
    ((w)localObject).BJ(paramw.BXV.Cec);
    ((w)localObject).BH(((float)paramw.BXV.Cec / paramw.BXV.lqb));
    ((w)localObject).setPlayRate(paramw.BXV.lqb);
    ((w)localObject).BXV.LJm = 0L;
    ((w)localObject).BXV.LJn = ((w)localObject).BXV.hlm;
    ((w)localObject).BXV.fCr();
    this.CgN = paramw.BXV.startTimeMs;
    this.CdY = paramw.BXV.HWH;
    this.CdZ = Math.min(paramw.BXV.HWI, paramLong);
    this.CgO = paramw.BXV.lqb;
    this.Cea = (((float)this.CdY / this.CgO));
    this.Ceb = (((float)this.CdZ / this.CgO));
    this.Cec = paramw.BXV.Cec;
    localObject = new v(j.listOf(localObject));
    ((v)localObject).aq(((float)this.CdY / paramw.BXV.lqb), ((float)this.CdZ / paramw.BXV.lqb));
    TrackCropView.a(ewJ(), (v)localObject);
    this.tcK.setShow(true);
    dRe();
    AppMethodBeat.o(191897);
  }
  
  private final TextView ewK()
  {
    AppMethodBeat.i(191893);
    TextView localTextView = (TextView)this.CdV.getValue();
    AppMethodBeat.o(191893);
    return localTextView;
  }
  
  public final void BO(long paramLong)
  {
    AppMethodBeat.i(191900);
    if (this.tcK.bnS()) {
      ewJ().setProgress(paramLong);
    }
    AppMethodBeat.o(191900);
  }
  
  public final void a(c.e parame) {}
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(191896);
    if (this.tcK.bnS())
    {
      this.Ced = false;
      this.tcK.setShow(false);
      AppMethodBeat.o(191896);
      return true;
    }
    AppMethodBeat.o(191896);
    return false;
  }
  
  public final void azm() {}
  
  final void dRe()
  {
    AppMethodBeat.i(191899);
    int i = Math.round((float)this.Cec / this.CgO / 1000.0F);
    int j = Math.round((float)(this.Ceb - this.Cea) / 1000.0F);
    TextView localTextView = ewK();
    p.g(localTextView, "hintText");
    localTextView.setText((CharSequence)this.tcK.getContext().getString(2131767223, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    AppMethodBeat.o(191899);
  }
  
  final TrackCropView ewJ()
  {
    AppMethodBeat.i(191892);
    TrackCropView localTrackCropView = (TrackCropView)this.CdU.getValue();
    AppMethodBeat.o(191892);
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
    AppMethodBeat.i(191902);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191902);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(191894);
    ewJ().setEnableLengthEdit(paramBoolean);
    AppMethodBeat.o(191894);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191895);
    if (paramInt == 8)
    {
      this.Ced = false;
      this.tcK.setShow(false);
    }
    AppMethodBeat.o(191895);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<ImageView>
  {
    a(ae paramae)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ae paramae) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191881);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.CgQ.Ced = false;
      this.CgQ.tcK.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191881);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ae paramae) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191882);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.CgQ.Ced = true;
      this.CgQ.tcK.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191882);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Boolean, z>
  {
    d(ae paramae)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<TextView>
  {
    e(ae paramae)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<ImageView>
  {
    f(ae paramae)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static final class g
    implements TrackCropView.a
  {
    public final void as(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191886);
      this.CgQ.Cea = paramLong1;
      this.CgQ.Ceb = paramLong2;
      this.CgQ.dRe();
      AppMethodBeat.o(191886);
    }
    
    public final void at(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191887);
      com.tencent.mm.sdk.platformtools.ae.i(this.CgQ.TAG, "onScrollStateChanged: " + paramLong1 + ", " + paramLong2);
      Object localObject = new Bundle();
      this.CgQ.Cea = paramLong1;
      this.CgQ.Ceb = paramLong2;
      this.CgQ.dRe();
      ((Bundle)localObject).putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      ((Bundle)localObject).putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((Bundle)localObject).putBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", true);
      this.CgQ.tbP.a(d.c.xVu, (Bundle)localObject);
      localObject = this.CgQ.Cee;
      if (localObject != null)
      {
        ((c.e)localObject).resume();
        AppMethodBeat.o(191887);
        return;
      }
      AppMethodBeat.o(191887);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(191888);
      c.e locale = this.CgQ.Cee;
      if (locale != null) {
        locale.pause();
      }
      locale = this.CgQ.Cef;
      if (locale != null)
      {
        locale.pause();
        AppMethodBeat.o(191888);
        return;
      }
      AppMethodBeat.o(191888);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(191889);
      c.e locale = this.CgQ.Cee;
      if (locale != null)
      {
        locale.BP(paramLong);
        AppMethodBeat.o(191889);
        return;
      }
      AppMethodBeat.o(191889);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<ViewGroup>
  {
    h(ae paramae)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ae
 * JD-Core Version:    0.7.0.1
 */