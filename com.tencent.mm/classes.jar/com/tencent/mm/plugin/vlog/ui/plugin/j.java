package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup.a;
import com.tencent.tav.coremedia.CMTimeRange;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "editCallback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "getEditCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "setEditCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;)V", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "okBtn", "getOkBtn", "okBtn$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "getPanelRoot", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancel", "", "checkInit", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setTimeRange", "start", "end", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "EditCallback", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements v, d.c
{
  public static final j.a Uiq;
  private final kotlin.j FQn;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  final EditorPanelHolder Gvm;
  private boolean UhB;
  private final kotlin.j Uhs;
  private final kotlin.j Uht;
  private d.e Uia;
  private final kotlin.j Uir;
  long Uis;
  long Uit;
  long Uiu;
  long Uiv;
  b Uiw;
  private final f Uix;
  private boolean lYs;
  
  static
  {
    AppMethodBeat.i(282458);
    Uiq = new j.a((byte)0);
    AppMethodBeat.o(282458);
  }
  
  public j(EditorPanelHolder paramEditorPanelHolder, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(282359);
    this.Gvm = paramEditorPanelHolder;
    this.GrC = parama;
    this.Uhs = k.cm((kotlin.g.a.a)new g(this));
    this.Uht = k.cm((kotlin.g.a.a)new h(this));
    this.FQn = k.cm((kotlin.g.a.a)new c(this));
    this.Uir = k.cm((kotlin.g.a.a)new e(this));
    this.Uix = new f(this);
    AppMethodBeat.o(282359);
  }
  
  private static final void a(j paramj, View paramView)
  {
    AppMethodBeat.i(282387);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "this$0");
    paramj.cancel();
    paramj.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282387);
  }
  
  private static final void b(j paramj, View paramView)
  {
    AppMethodBeat.i(282396);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "this$0");
    paramView = paramj.Uiw;
    if (paramView != null) {
      paramView.onFinish();
    }
    paramj.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282396);
  }
  
  private static final void c(j paramj, View paramView)
  {
    AppMethodBeat.i(282405);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "this$0");
    paramView = paramj.Uiw;
    if (paramView != null) {
      paramView.gKC();
    }
    paramj.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282405);
  }
  
  private static final void d(j paramj, View paramView)
  {
    AppMethodBeat.i(282409);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramj, "this$0");
    paramView = paramj.Uiw;
    if (paramView != null) {
      paramView.gKC();
    }
    paramj.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282409);
  }
  
  private final View hTb()
  {
    AppMethodBeat.i(282370);
    View localView = (View)this.Uhs.getValue();
    AppMethodBeat.o(282370);
    return localView;
  }
  
  private final TimeCropViewGroup hTc()
  {
    AppMethodBeat.i(282375);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.Uht.getValue();
    AppMethodBeat.o(282375);
    return localTimeCropViewGroup;
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(282557);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(282557);
  }
  
  public final void a(d.e parame)
  {
    this.Uia = parame;
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(282577);
    s.u(this, "this");
    AppMethodBeat.o(282577);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(282495);
    this.Uiu = this.Uis;
    this.Uiv = this.Uit;
    b localb = this.Uiw;
    if (localb != null) {
      localb.bz(this.Uiu, this.Uiv);
    }
    localb = this.Uiw;
    if (localb != null) {
      localb.onFinish();
    }
    AppMethodBeat.o(282495);
  }
  
  public final String name()
  {
    AppMethodBeat.i(282566);
    String str = v.a.b(this);
    AppMethodBeat.o(282566);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(282573);
    s.u(this, "this");
    AppMethodBeat.o(282573);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282518);
    if (this.Gvm.cvt())
    {
      this.UhB = false;
      b localb = this.Uiw;
      if (localb != null) {
        localb.onFinish();
      }
      this.Gvm.setShow(false);
      AppMethodBeat.o(282518);
      return true;
    }
    s.u((v)this, "this");
    AppMethodBeat.o(282518);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(282579);
    s.u(this, "this");
    AppMethodBeat.o(282579);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(282586);
    s.u(this, "this");
    AppMethodBeat.o(282586);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(282591);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(282591);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(282595);
    s.u(this, "this");
    AppMethodBeat.o(282595);
  }
  
  public final void qU(long paramLong)
  {
    AppMethodBeat.i(282549);
    hTc().setProgress(paramLong);
    AppMethodBeat.o(282549);
  }
  
  public final void release()
  {
    AppMethodBeat.i(282600);
    s.u(this, "this");
    AppMethodBeat.o(282600);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282609);
    s.u(this, "this");
    AppMethodBeat.o(282609);
  }
  
  public final void setTrack(ac paramac)
  {
    AppMethodBeat.i(282533);
    s.u(paramac, "composition");
    this.UhB = false;
    if (!this.lYs)
    {
      this.lYs = true;
      this.Gvm.setCloseTouchOutside(false);
      hTc().setCallback((TimeCropViewGroup.a)this.Uix);
      hTc().setRealTimeCallback((TimeCropViewGroup.a)this.Uix);
      this.Gvm.setOnVisibleChangeCallback((kotlin.g.a.b)new d(this));
      ((View)this.FQn.getValue()).setOnClickListener(new j..ExternalSyntheticLambda3(this));
      ((View)this.Uir.getValue()).setOnClickListener(new j..ExternalSyntheticLambda1(this));
      hTb().findViewById(a.f.magic_delete_icon).setOnClickListener(new j..ExternalSyntheticLambda2(this));
      hTb().findViewById(a.f.magic_delete_text).setOnClickListener(new j..ExternalSyntheticLambda0(this));
    }
    if (this.Uit > paramac.Uaw.jLV().getEndUs() / 1000L)
    {
      this.Uit = (paramac.Uaw.jLV().getEndUs() / 1000L);
      this.Uiv = this.Uit;
    }
    hTc().a(paramac, this.Uis, this.Uit);
    this.Gvm.setShow(true);
    AppMethodBeat.o(282533);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282506);
    s.u((v)this, "this");
    if (paramInt == 8)
    {
      this.UhB = false;
      b localb = this.Uiw;
      if (localb != null) {
        localb.onFinish();
      }
      this.Gvm.setShow(false);
    }
    AppMethodBeat.o(282506);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "", "onCrop", "", "start", "", "end", "onCropStart", "onDelete", "onFinish", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void bz(long paramLong1, long paramLong2);
    
    public abstract void gKC();
    
    public abstract void hTd();
    
    public abstract void onFinish();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<View>
  {
    c(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    d(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<View>
  {
    e(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements TimeCropViewGroup.a
  {
    f(j paramj) {}
    
    public final void d(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(282437);
      if (j.a(this.Uiy) != paramLong1)
      {
        j.a(this.Uiy, paramLong1);
        j.b(this.Uiy, paramLong2);
      }
      for (long l = j.a(this.Uiy);; l = j.c(this.Uiy))
      {
        localObject1 = this.Uiy.GrC;
        a.c localc = a.c.NPF;
        Bundle localBundle = new Bundle();
        Object localObject2 = this.Uiy;
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", j.a((j)localObject2));
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", j.c((j)localObject2));
        localObject2 = ah.aiuX;
        ((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject1).a(localc, localBundle);
        if (!paramBoolean) {
          break;
        }
        localObject1 = this.Uiy.Uiw;
        if (localObject1 != null) {
          ((j.b)localObject1).bz(paramLong1, paramLong2);
        }
        localObject1 = j.d(this.Uiy);
        if (localObject1 != null) {
          ((d.e)localObject1).wK(j.a(this.Uiy));
        }
        localObject1 = j.d(this.Uiy);
        if (localObject1 == null) {
          break label287;
        }
        ((d.e)localObject1).resume();
        AppMethodBeat.o(282437);
        return;
        j.a(this.Uiy, paramLong1);
        j.b(this.Uiy, paramLong2);
      }
      Object localObject1 = this.Uiy.Uiw;
      if (localObject1 != null) {
        ((j.b)localObject1).hTd();
      }
      localObject1 = j.d(this.Uiy);
      if (localObject1 != null) {
        ((d.e)localObject1).pause();
      }
      localObject1 = j.d(this.Uiy);
      if (localObject1 != null) {
        ((d.e)localObject1).wK(l);
      }
      label287:
      AppMethodBeat.o(282437);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<View>
  {
    g(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TimeCropViewGroup>
  {
    h(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.j
 * JD-Core Version:    0.7.0.1
 */