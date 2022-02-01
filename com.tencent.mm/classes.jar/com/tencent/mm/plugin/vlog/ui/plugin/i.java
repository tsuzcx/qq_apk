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
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView;
import com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.f;
import d.g;
import d.g.a.a;
import d.g.a.b;
import d.g.b.u;
import d.g.b.w;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "confirmBtn", "getConfirmBtn", "confirmBtn$delegate", "confirmed", "", "hintText", "Landroid/widget/TextView;", "getHintText", "()Landroid/widget/TextView;", "hintText$delegate", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1;", "panelRoot", "getPanelRoot", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "trackCropView$delegate", "videoSeekable", "cancel", "", "checkInit", "onBackPress", "onFinish", "onProgress", "timeMs", "", "onStart", "seekable", "setEnableLengthEdit", "enable", "setMediaPlayer", "videoSeeker", "audioSeeker", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "plugin-vlog_release"})
public final class i
  implements t, a.c
{
  public a.e AsN;
  public a.e AsO;
  private final f AtO;
  private final f AtP;
  private final f AtQ;
  private boolean AtR;
  private final g AtS;
  final EditorPanelHolder AtT;
  private final String TAG;
  private boolean fJw;
  private final f rGS;
  final d rTT;
  private final f wbS;
  
  static
  {
    AppMethodBeat.i(207848);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(i.class), "panelRoot", "getPanelRoot()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(i.class), "trackCropView", "getTrackCropView()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;")), (d.l.k)w.a(new u(w.bn(i.class), "cancelBtn", "getCancelBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(i.class), "confirmBtn", "getConfirmBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(i.class), "hintText", "getHintText()Landroid/widget/TextView;")) };
    AppMethodBeat.o(207848);
  }
  
  public i(EditorPanelHolder paramEditorPanelHolder, d paramd)
  {
    AppMethodBeat.i(207857);
    this.AtT = paramEditorPanelHolder;
    this.rTT = paramd;
    this.TAG = "MicroMsg.VLogTrackEditPlugin";
    this.AtO = g.K((a)new h(this));
    this.AtP = g.K((a)new i(this));
    this.rGS = g.K((a)new a(this));
    this.wbS = g.K((a)new e(this));
    this.AtQ = g.K((a)new f(this));
    this.AtS = new g(this);
    AppMethodBeat.o(207857);
  }
  
  private final TrackCropView ego()
  {
    AppMethodBeat.i(207849);
    TrackCropView localTrackCropView = (TrackCropView)this.AtP.getValue();
    AppMethodBeat.o(207849);
    return localTrackCropView;
  }
  
  private final TextView egp()
  {
    AppMethodBeat.i(207850);
    TextView localTextView = (TextView)this.AtQ.getValue();
    AppMethodBeat.o(207850);
    return localTextView;
  }
  
  private final void egq()
  {
    AppMethodBeat.i(207851);
    if (this.fJw)
    {
      AppMethodBeat.o(207851);
      return;
    }
    this.fJw = true;
    this.AtT.setCloseTouchOutside(false);
    ego().setCallback((TrackCropView.a)this.AtS);
    ((View)this.rGS.getValue()).setOnClickListener((View.OnClickListener)new b(this));
    ((View)this.wbS.getValue()).setOnClickListener((View.OnClickListener)new c(this));
    this.AtT.setOnVisibleChangeCallback((b)new d(this));
    AppMethodBeat.o(207851);
  }
  
  public final void a(a.e parame) {}
  
  public final boolean alO()
  {
    AppMethodBeat.i(207854);
    if (this.AtT.bjw())
    {
      this.AtR = false;
      this.AtT.setShow(false);
      AppMethodBeat.o(207854);
      return true;
    }
    AppMethodBeat.o(207854);
    return false;
  }
  
  public final void awk() {}
  
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
    AppMethodBeat.i(207852);
    TextView localTextView;
    if (paramBoolean)
    {
      localTextView = egp();
      d.g.b.k.g(localTextView, "hintText");
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      ego().setEnableLengthEdit(paramBoolean);
      AppMethodBeat.o(207852);
      return;
      localTextView = egp();
      d.g.b.k.g(localTextView, "hintText");
      localTextView.setVisibility(0);
    }
  }
  
  public final void setTrack(r paramr)
  {
    AppMethodBeat.i(207855);
    d.g.b.k.h(paramr, "composition");
    this.AtR = false;
    egq();
    this.AtT.setShow(true);
    ego().setTrack(paramr);
    AppMethodBeat.o(207855);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(207853);
    if (paramInt == 8)
    {
      this.AtR = false;
      this.AtT.setShow(false);
    }
    AppMethodBeat.o(207853);
  }
  
  public final void yN(long paramLong)
  {
    AppMethodBeat.i(207856);
    if (this.AtT.bjw()) {
      ego().setProgress(paramLong);
    }
    AppMethodBeat.o(207856);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<View>
  {
    a(i parami)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(207838);
      i.a(this.AtU, false);
      this.AtU.AtT.setShow(false);
      AppMethodBeat.o(207838);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(207839);
      i.a(this.AtU, true);
      this.AtU.AtT.setShow(false);
      AppMethodBeat.o(207839);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<Boolean, y>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<View>
  {
    e(i parami)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<TextView>
  {
    f(i parami)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/ui/plugin/VLogTrackEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "onCrop", "", "start", "", "end", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static final class g
    implements TrackCropView.a
  {
    public final void ap(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(207843);
      Object localObject = new Bundle();
      ac.i(i.d(this.AtU), "onScrollStateChanged: " + paramLong1 + ", " + paramLong2);
      ((Bundle)localObject).putLong("EDIT_VLOG_TRACK_CROP_START", paramLong1);
      ((Bundle)localObject).putLong("EDIT_VLOG_TRAKC_CROP_END", paramLong2);
      ((Bundle)localObject).putBoolean("EDIT_VLOG_TRACK_CROP_CHANGE", true);
      this.AtU.rTT.a(d.c.wxu, (Bundle)localObject);
      localObject = i.e(this.AtU);
      if (localObject != null) {
        ((a.e)localObject).resume();
      }
      localObject = i.f(this.AtU);
      if (localObject != null)
      {
        ((a.e)localObject).resume();
        AppMethodBeat.o(207843);
        return;
      }
      AppMethodBeat.o(207843);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(207844);
      a.e locale = i.e(this.AtU);
      if (locale != null) {
        locale.pause();
      }
      locale = i.f(this.AtU);
      if (locale != null)
      {
        locale.pause();
        AppMethodBeat.o(207844);
        return;
      }
      AppMethodBeat.o(207844);
    }
    
    public final void seekTo(long paramLong)
    {
      AppMethodBeat.i(207845);
      a.e locale = i.e(this.AtU);
      if (locale != null)
      {
        locale.vr(paramLong);
        AppMethodBeat.o(207845);
        return;
      }
      AppMethodBeat.o(207845);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<View>
  {
    h(i parami)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.i
 * JD-Core Version:    0.7.0.1
 */