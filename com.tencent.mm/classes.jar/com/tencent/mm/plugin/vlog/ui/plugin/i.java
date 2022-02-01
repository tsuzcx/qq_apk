package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g;
import d.g.a.a;
import d.g.a.b;
import d.g.b.u;
import d.g.b.w;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "confirmBtn", "getConfirmBtn", "confirmBtn$delegate", "confirmed", "", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1;", "panelRoot", "getPanelRoot", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "trackCropView$delegate", "cancel", "", "checkInit", "onBackPress", "onFinish", "onProgress", "timeMs", "", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setEnableLengthEdit", "enable", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "plugin-vlog_release"})
public final class i
  implements t, b.c
{
  final EditorPanelHolder LuA;
  private final f Luv;
  private final f Luw;
  private final f Lux;
  private boolean Luy;
  private final g Luz;
  private final String TAG;
  private boolean fFP;
  private final f qLX;
  private final f uTd;
  final d vjo;
  
  static
  {
    AppMethodBeat.i(201163);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(i.class), "panelRoot", "getPanelRoot()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(i.class), "trackCropView", "getTrackCropView()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;")), (d.l.k)w.a(new u(w.bk(i.class), "cancelBtn", "getCancelBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(i.class), "confirmBtn", "getConfirmBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(i.class), "hintText", "getHintText()Landroid/widget/TextView;")) };
    AppMethodBeat.o(201163);
  }
  
  public i(EditorPanelHolder paramEditorPanelHolder, d paramd)
  {
    AppMethodBeat.i(201172);
    this.LuA = paramEditorPanelHolder;
    this.vjo = paramd;
    this.TAG = "MicroMsg.VLogTrackEditPlugin";
    this.Luv = g.E((a)new h(this));
    this.Luw = g.E((a)new i(this));
    this.qLX = g.E((a)new a(this));
    this.uTd = g.E((a)new e(this));
    this.Lux = g.E((a)new f(this));
    this.Luz = new g(this);
    AppMethodBeat.o(201172);
  }
  
  private final void eCz()
  {
    AppMethodBeat.i(201166);
    if (this.fFP)
    {
      AppMethodBeat.o(201166);
      return;
    }
    this.fFP = true;
    fZo().setCallback((TrackCropView.a)this.Luz);
    ((View)this.qLX.getValue()).setOnClickListener((View.OnClickListener)new b(this));
    ((View)this.uTd.getValue()).setOnClickListener((View.OnClickListener)new c(this));
    this.LuA.setOnVisibleChangeCallback((b)new d(this));
    AppMethodBeat.o(201166);
  }
  
  private final TrackCropView fZo()
  {
    AppMethodBeat.i(201164);
    TrackCropView localTrackCropView = (TrackCropView)this.Luw.getValue();
    AppMethodBeat.o(201164);
    return localTrackCropView;
  }
  
  private final TextView fZp()
  {
    AppMethodBeat.i(201165);
    TextView localTextView = (TextView)this.Lux.getValue();
    AppMethodBeat.o(201165);
    return localTextView;
  }
  
  public final void Ch(long paramLong)
  {
    AppMethodBeat.i(201171);
    fZo().setProgress(paramLong);
    AppMethodBeat.o(201171);
  }
  
  public final void a(b.e parame) {}
  
  public final void apt() {}
  
  public final boolean dia()
  {
    AppMethodBeat.i(201169);
    if (this.LuA.getVisibility() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.Luy = true;
      this.LuA.setShow(false);
      AppMethodBeat.o(201169);
      return true;
    }
    AppMethodBeat.o(201169);
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(201167);
    TextView localTextView;
    if (paramBoolean)
    {
      localTextView = fZp();
      d.g.b.k.g(localTextView, "hintText");
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      fZo().setEnableLengthEdit(paramBoolean);
      AppMethodBeat.o(201167);
      return;
      localTextView = fZp();
      d.g.b.k.g(localTextView, "hintText");
      localTextView.setVisibility(0);
    }
  }
  
  public final void setTrack(v paramv)
  {
    AppMethodBeat.i(201170);
    d.g.b.k.h(paramv, "composition");
    this.Luy = false;
    eCz();
    this.LuA.setShow(true);
    fZo().setTrack(paramv);
    AppMethodBeat.o(201170);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(201168);
    if (paramInt == 8)
    {
      this.Luy = true;
      this.LuA.setShow(false);
    }
    AppMethodBeat.o(201168);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<View>
  {
    a(i parami)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201155);
      i.a(this.LuB, false);
      this.LuB.LuA.setShow(false);
      AppMethodBeat.o(201155);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201156);
      i.a(this.LuB, true);
      this.LuB.LuA.setShow(false);
      AppMethodBeat.o(201156);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<Boolean, y>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<View>
  {
    e(i parami)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<TextView>
  {
    f(i parami)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "onCrop", "", "start", "", "end", "plugin-vlog_release"})
  public static final class g
    implements TrackCropView.a
  {
    public final void aE(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(201160);
      Bundle localBundle = new Bundle();
      ad.i(i.c(this.LuB), "onScrollStateChanged: " + paramLong1 + ", " + paramLong2);
      localBundle.putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      localBundle.putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      localBundle.putBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", true);
      this.LuB.vjo.a(d.c.LoD, localBundle);
      AppMethodBeat.o(201160);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<View>
  {
    h(i parami)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends d.g.b.l
    implements a<TrackCropView>
  {
    i(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.i
 * JD-Core Version:    0.7.0.1
 */