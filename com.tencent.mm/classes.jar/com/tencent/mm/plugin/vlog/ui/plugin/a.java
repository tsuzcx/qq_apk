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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.videocomposition.h;
import com.tencent.tav.coremedia.CMTimeRange;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancelView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelView", "()Landroid/widget/ImageView;", "cancelView$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "getLayout", "()Landroid/view/ViewGroup;", "okView", "getOkView", "okView$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "getPanelRoot", "panelRoot$delegate", "sourceDuration", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "trackCropView$delegate", "videoSeekable", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "init", "setVisibility", "visibility", "", "updateHint", "plugin-vlog_release"})
public final class a
  implements t, c.c
{
  private final f CdT;
  private final f CdU;
  private final f CdV;
  private final f CdW;
  private final f CdX;
  long CdY;
  long CdZ;
  long Cea;
  long Ceb;
  private long Cec;
  boolean Ced;
  public c.e Cee;
  public c.e Cef;
  private final g Ceg;
  private final ViewGroup Ceh;
  final String TAG;
  private boolean gff;
  final d tbP;
  final EditorPanelHolder tcK;
  
  public a(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191576);
    this.Ceh = paramViewGroup;
    this.tbP = paramd;
    this.TAG = "MicroMsg.CompositionEditPlugin";
    paramViewGroup = this.Ceh.getContext();
    p.g(paramViewGroup, "layout.context");
    paramViewGroup = new EditorPanelHolder(paramViewGroup);
    this.Ceh.addView((View)paramViewGroup);
    paramViewGroup.setVisibility(8);
    this.tcK = paramViewGroup;
    this.CdT = g.O((d.g.a.a)new h(this));
    this.CdU = g.O((d.g.a.a)new i(this));
    this.CdV = g.O((d.g.a.a)new e(this));
    this.CdW = g.O((d.g.a.a)new a(this));
    this.CdX = g.O((d.g.a.a)new f(this));
    this.Ceg = new g(this);
    AppMethodBeat.o(191576);
  }
  
  private final TextView ewK()
  {
    AppMethodBeat.i(191569);
    TextView localTextView = (TextView)this.CdV.getValue();
    AppMethodBeat.o(191569);
    return localTextView;
  }
  
  private final void ewL()
  {
    AppMethodBeat.i(191570);
    if (this.gff)
    {
      AppMethodBeat.o(191570);
      return;
    }
    this.gff = true;
    this.tcK.setCloseTouchOutside(false);
    ewJ().setCallback((TrackCropView.a)this.Ceg);
    ((ImageView)this.CdW.getValue()).setOnClickListener((View.OnClickListener)new b(this));
    ((ImageView)this.CdX.getValue()).setOnClickListener((View.OnClickListener)new c(this));
    this.tcK.setOnVisibleChangeCallback((d.g.a.b)new d(this));
    AppMethodBeat.o(191570);
  }
  
  public final void BO(long paramLong)
  {
    AppMethodBeat.i(191575);
    if (this.tcK.bnS()) {
      ewJ().setProgress(paramLong);
    }
    AppMethodBeat.o(191575);
  }
  
  public final void a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(191573);
    p.h(paramv, "composition");
    if ((paramBoolean) && (this.Ceb != 0L))
    {
      this.Ceg.at(this.Cea, this.Ceb);
      AppMethodBeat.o(191573);
      return;
    }
    this.Ced = false;
    ewL();
    this.CdY = (paramv.BXI.evI().getStartUs() / 1000L);
    this.CdZ = (paramv.BXI.evI().getEndUs() / 1000L);
    this.Cea = this.CdY;
    this.Ceb = this.CdZ;
    this.tcK.setShow(true);
    this.Cec = paramv.BXI.fUa();
    TrackCropView.a(ewJ(), paramv);
    dRe();
    AppMethodBeat.o(191573);
  }
  
  public final void a(c.e parame) {}
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(191572);
    if (this.tcK.bnS())
    {
      this.Ced = false;
      this.tcK.setShow(false);
      AppMethodBeat.o(191572);
      return true;
    }
    AppMethodBeat.o(191572);
    return false;
  }
  
  public final void azm() {}
  
  final void dRe()
  {
    AppMethodBeat.i(191574);
    int i = Math.round((float)this.Cec / 1000.0F);
    int j = Math.round((float)(this.Ceb - this.Cea) / 1000.0F);
    TextView localTextView = ewK();
    p.g(localTextView, "hintText");
    localTextView.setText((CharSequence)this.tcK.getContext().getString(2131767223, new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    AppMethodBeat.o(191574);
  }
  
  final TrackCropView ewJ()
  {
    AppMethodBeat.i(191568);
    TrackCropView localTrackCropView = (TrackCropView)this.CdU.getValue();
    AppMethodBeat.o(191568);
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
    AppMethodBeat.i(191577);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191577);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191571);
    if (paramInt == 8)
    {
      this.Ced = false;
      this.tcK.setShow(false);
    }
    AppMethodBeat.o(191571);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<ImageView>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191557);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.Cei.Ced = false;
      this.Cei.tcK.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191557);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191558);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.Cei.Ced = true;
      this.Cei.tcK.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191558);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Boolean, z>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<TextView>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<ImageView>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/CompositionEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static final class g
    implements TrackCropView.a
  {
    public final void as(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191562);
      this.Cei.Cea = paramLong1;
      this.Cei.Ceb = paramLong2;
      this.Cei.dRe();
      AppMethodBeat.o(191562);
    }
    
    public final void at(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(191563);
      ae.i(this.Cei.TAG, "onScrollStateChanged: " + paramLong1 + ", " + paramLong2);
      Object localObject = new Bundle();
      this.Cei.Cea = paramLong1;
      this.Cei.Ceb = paramLong2;
      this.Cei.dRe();
      ((Bundle)localObject).putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      ((Bundle)localObject).putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((Bundle)localObject).putBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", true);
      this.Cei.tbP.a(d.c.xVv, (Bundle)localObject);
      localObject = this.Cei.Cee;
      if (localObject != null)
      {
        ((c.e)localObject).resume();
        AppMethodBeat.o(191563);
        return;
      }
      AppMethodBeat.o(191563);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(191564);
      c.e locale = this.Cei.Cee;
      if (locale != null) {
        locale.pause();
      }
      locale = this.Cei.Cef;
      if (locale != null)
      {
        locale.pause();
        AppMethodBeat.o(191564);
        return;
      }
      AppMethodBeat.o(191564);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(191565);
      c.e locale = this.Cei.Cee;
      if (locale != null)
      {
        locale.BP(paramLong);
        AppMethodBeat.o(191565);
        return;
      }
      AppMethodBeat.o(191565);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<ViewGroup>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.a
 * JD-Core Version:    0.7.0.1
 */