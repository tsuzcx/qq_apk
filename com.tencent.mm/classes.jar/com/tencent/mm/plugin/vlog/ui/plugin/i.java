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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "editCallback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "getEditCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "setEditCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;)V", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "okBtn", "getOkBtn", "okBtn$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "getPanelRoot", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancel", "", "checkInit", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setTimeRange", "start", "end", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "EditCallback", "plugin-vlog_release"})
public final class i
  implements t, c.c
{
  public static final i.a BNq;
  long BMA;
  long BMB;
  long BMC;
  boolean BME;
  private c.e BMF;
  private final f BMu;
  private final f BMv;
  long BMz;
  final f BNn;
  b BNo;
  final j BNp;
  boolean gcX;
  final f sCh;
  final d sQE;
  final EditorPanelHolder sRz;
  
  static
  {
    AppMethodBeat.i(196230);
    BNq = new i.a((byte)0);
    AppMethodBeat.o(196230);
  }
  
  public i(EditorPanelHolder paramEditorPanelHolder, d paramd)
  {
    AppMethodBeat.i(196229);
    this.sRz = paramEditorPanelHolder;
    this.sQE = paramd;
    this.BMu = g.O((d.g.a.a)new k(this));
    this.BMv = g.O((d.g.a.a)new l(this));
    this.sCh = g.O((d.g.a.a)new c(this));
    this.BNn = g.O((d.g.a.a)new i(this));
    this.BNp = new j(this);
    AppMethodBeat.o(196229);
  }
  
  public final void Bq(long paramLong)
  {
    AppMethodBeat.i(196228);
    ett().setProgress(paramLong);
    AppMethodBeat.o(196228);
  }
  
  public final void a(c.e parame)
  {
    this.BMF = parame;
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(196227);
    if (this.sRz.bni())
    {
      this.BME = false;
      b localb = this.BNo;
      if (localb != null) {
        localb.onFinish();
      }
      this.sRz.setShow(false);
      AppMethodBeat.o(196227);
      return true;
    }
    AppMethodBeat.o(196227);
    return false;
  }
  
  public final void ayX() {}
  
  public final void cancel()
  {
    AppMethodBeat.i(196225);
    this.BMB = this.BMz;
    this.BMC = this.BMA;
    b localb = this.BNo;
    if (localb != null) {
      localb.au(this.BMB, this.BMC);
    }
    localb = this.BNo;
    if (localb != null)
    {
      localb.onFinish();
      AppMethodBeat.o(196225);
      return;
    }
    AppMethodBeat.o(196225);
  }
  
  final View ets()
  {
    AppMethodBeat.i(196223);
    View localView = (View)this.BMu.getValue();
    AppMethodBeat.o(196223);
    return localView;
  }
  
  final TimeCropViewGroup ett()
  {
    AppMethodBeat.i(196224);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.BMv.getValue();
    AppMethodBeat.o(196224);
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
    AppMethodBeat.i(196231);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196231);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196226);
    if (paramInt == 8)
    {
      this.BME = false;
      b localb = this.BNo;
      if (localb != null) {
        localb.onFinish();
      }
      this.sRz.setShow(false);
    }
    AppMethodBeat.o(196226);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "", "onCrop", "", "start", "", "end", "onCropStart", "onDelete", "onFinish", "plugin-vlog_release"})
  public static abstract interface b
  {
    public abstract void au(long paramLong1, long paramLong2);
    
    public abstract void dIb();
    
    public abstract void etu();
    
    public abstract void onFinish();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<View>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Boolean, z>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196215);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.BNr.cancel();
      this.BNr.sRz.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196215);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196216);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.BNr.BNo;
      if (paramView != null) {
        paramView.onFinish();
      }
      this.BNr.sRz.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196216);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196217);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.BNr.BNo;
      if (paramView != null) {
        paramView.dIb();
      }
      this.BNr.sRz.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196217);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196218);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.BNr.BNo;
      if (paramView != null) {
        paramView.dIb();
      }
      this.BNr.sRz.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196218);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<View>
  {
    i(i parami)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
  public static final class j
    implements TimeCropViewGroup.a
  {
    public final void f(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(196220);
      if (i.a(this.BNr) != paramLong1)
      {
        i.a(this.BNr, paramLong1);
        i.b(this.BNr, paramLong2);
      }
      for (long l = i.a(this.BNr);; l = i.c(this.BNr))
      {
        localObject = this.BNr.sQE;
        d.c localc = d.c.xFF;
        Bundle localBundle = new Bundle();
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", i.a(this.BNr));
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", i.c(this.BNr));
        ((d)localObject).a(localc, localBundle);
        if (!paramBoolean) {
          break label221;
        }
        localObject = this.BNr.BNo;
        if (localObject != null) {
          ((i.b)localObject).au(paramLong1, paramLong2);
        }
        localObject = i.d(this.BNr);
        if (localObject != null) {
          ((c.e)localObject).Br(i.a(this.BNr));
        }
        localObject = i.d(this.BNr);
        if (localObject == null) {
          break;
        }
        ((c.e)localObject).resume();
        AppMethodBeat.o(196220);
        return;
        i.a(this.BNr, paramLong1);
        i.b(this.BNr, paramLong2);
      }
      AppMethodBeat.o(196220);
      return;
      label221:
      Object localObject = this.BNr.BNo;
      if (localObject != null) {
        ((i.b)localObject).etu();
      }
      localObject = i.d(this.BNr);
      if (localObject != null) {
        ((c.e)localObject).pause();
      }
      localObject = i.d(this.BNr);
      if (localObject != null)
      {
        ((c.e)localObject).Br(l);
        AppMethodBeat.o(196220);
        return;
      }
      AppMethodBeat.o(196220);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<View>
  {
    k(i parami)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.i
 * JD-Core Version:    0.7.0.1
 */