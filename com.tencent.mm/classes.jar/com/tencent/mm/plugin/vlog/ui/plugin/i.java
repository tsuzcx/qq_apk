package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup.a;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "editCallback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "getEditCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "setEditCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;)V", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "okBtn", "getOkBtn", "okBtn$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "getPanelRoot", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancel", "", "checkInit", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setTimeRange", "start", "end", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "EditCallback", "plugin-vlog_release"})
public final class i
  implements t, c.c
{
  public static final i.a CeP;
  private final f CdT;
  private final f CdU;
  long CdY;
  long CdZ;
  final f CeM;
  b CeN;
  final j CeO;
  long Cea;
  long Ceb;
  boolean Ced;
  private c.e Cee;
  boolean gff;
  final f sNg;
  final d tbP;
  final EditorPanelHolder tcK;
  
  static
  {
    AppMethodBeat.i(191689);
    CeP = new i.a((byte)0);
    AppMethodBeat.o(191689);
  }
  
  public i(EditorPanelHolder paramEditorPanelHolder, d paramd)
  {
    AppMethodBeat.i(191688);
    this.tcK = paramEditorPanelHolder;
    this.tbP = paramd;
    this.CdT = g.O((d.g.a.a)new k(this));
    this.CdU = g.O((d.g.a.a)new l(this));
    this.sNg = g.O((d.g.a.a)new c(this));
    this.CeM = g.O((d.g.a.a)new i(this));
    this.CeO = new j(this);
    AppMethodBeat.o(191688);
  }
  
  public final void BO(long paramLong)
  {
    AppMethodBeat.i(191687);
    exa().setProgress(paramLong);
    AppMethodBeat.o(191687);
  }
  
  public final void a(c.e parame)
  {
    this.Cee = parame;
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(191686);
    if (this.tcK.bnS())
    {
      this.Ced = false;
      b localb = this.CeN;
      if (localb != null) {
        localb.onFinish();
      }
      this.tcK.setShow(false);
      AppMethodBeat.o(191686);
      return true;
    }
    AppMethodBeat.o(191686);
    return false;
  }
  
  public final void azm() {}
  
  public final void cancel()
  {
    AppMethodBeat.i(191684);
    this.Cea = this.CdY;
    this.Ceb = this.CdZ;
    b localb = this.CeN;
    if (localb != null) {
      localb.at(this.Cea, this.Ceb);
    }
    localb = this.CeN;
    if (localb != null)
    {
      localb.onFinish();
      AppMethodBeat.o(191684);
      return;
    }
    AppMethodBeat.o(191684);
  }
  
  final View ewZ()
  {
    AppMethodBeat.i(191682);
    View localView = (View)this.CdT.getValue();
    AppMethodBeat.o(191682);
    return localView;
  }
  
  final TimeCropViewGroup exa()
  {
    AppMethodBeat.i(191683);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.CdU.getValue();
    AppMethodBeat.o(191683);
    return localTimeCropViewGroup;
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
    AppMethodBeat.i(191690);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191690);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191685);
    if (paramInt == 8)
    {
      this.Ced = false;
      b localb = this.CeN;
      if (localb != null) {
        localb.onFinish();
      }
      this.tcK.setShow(false);
    }
    AppMethodBeat.o(191685);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "", "onCrop", "", "start", "", "end", "onCropStart", "onDelete", "onFinish", "plugin-vlog_release"})
  public static abstract interface b
  {
    public abstract void at(long paramLong1, long paramLong2);
    
    public abstract void dLs();
    
    public abstract void exb();
    
    public abstract void onFinish();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<View>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Boolean, z>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191674);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.CeQ.cancel();
      this.CeQ.tcK.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191674);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191675);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.CeQ.CeN;
      if (paramView != null) {
        paramView.onFinish();
      }
      this.CeQ.tcK.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191675);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191676);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.CeQ.CeN;
      if (paramView != null) {
        paramView.dLs();
      }
      this.CeQ.tcK.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191676);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191677);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.CeQ.CeN;
      if (paramView != null) {
        paramView.dLs();
      }
      this.CeQ.tcK.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191677);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<View>
  {
    i(i parami)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
  public static final class j
    implements TimeCropViewGroup.a
  {
    public final void f(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(191679);
      if (i.a(this.CeQ) != paramLong1)
      {
        i.a(this.CeQ, paramLong1);
        i.b(this.CeQ, paramLong2);
      }
      for (long l = i.a(this.CeQ);; l = i.c(this.CeQ))
      {
        localObject = this.CeQ.tbP;
        d.c localc = d.c.xVA;
        Bundle localBundle = new Bundle();
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", i.a(this.CeQ));
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", i.c(this.CeQ));
        ((d)localObject).a(localc, localBundle);
        if (!paramBoolean) {
          break label221;
        }
        localObject = this.CeQ.CeN;
        if (localObject != null) {
          ((i.b)localObject).at(paramLong1, paramLong2);
        }
        localObject = i.d(this.CeQ);
        if (localObject != null) {
          ((c.e)localObject).BP(i.a(this.CeQ));
        }
        localObject = i.d(this.CeQ);
        if (localObject == null) {
          break;
        }
        ((c.e)localObject).resume();
        AppMethodBeat.o(191679);
        return;
        i.a(this.CeQ, paramLong1);
        i.b(this.CeQ, paramLong2);
      }
      AppMethodBeat.o(191679);
      return;
      label221:
      Object localObject = this.CeQ.CeN;
      if (localObject != null) {
        ((i.b)localObject).exb();
      }
      localObject = i.d(this.CeQ);
      if (localObject != null) {
        ((c.e)localObject).pause();
      }
      localObject = i.d(this.CeQ);
      if (localObject != null)
      {
        ((c.e)localObject).BP(l);
        AppMethodBeat.o(191679);
        return;
      }
      AppMethodBeat.o(191679);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<View>
  {
    k(i parami)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<TimeCropViewGroup>
  {
    l(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.i
 * JD-Core Version:    0.7.0.1
 */