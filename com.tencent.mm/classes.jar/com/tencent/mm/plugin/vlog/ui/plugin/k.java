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
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "editCallback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "getEditCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "setEditCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;)V", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "okBtn", "getOkBtn", "okBtn$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "getPanelRoot", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancel", "", "checkInit", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setTimeRange", "start", "end", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "EditCallback", "plugin-vlog_release"})
public final class k
  implements t, e.c
{
  public static final k.a GHu;
  private e.e GGT;
  private final f GGj;
  private final f GGk;
  boolean GGs;
  final f GHn;
  long GHo;
  long GHp;
  long GHq;
  long GHr;
  b GHs;
  final j GHt;
  boolean gKM;
  final f vJB;
  final d wgr;
  final EditorPanelHolder wji;
  
  static
  {
    AppMethodBeat.i(191306);
    GHu = new k.a((byte)0);
    AppMethodBeat.o(191306);
  }
  
  public k(EditorPanelHolder paramEditorPanelHolder, d paramd)
  {
    AppMethodBeat.i(191305);
    this.wji = paramEditorPanelHolder;
    this.wgr = paramd;
    this.GGj = g.ah((kotlin.g.a.a)new k(this));
    this.GGk = g.ah((kotlin.g.a.a)new l(this));
    this.vJB = g.ah((kotlin.g.a.a)new c(this));
    this.GHn = g.ah((kotlin.g.a.a)new i(this));
    this.GHt = new j(this);
    AppMethodBeat.o(191305);
  }
  
  public final void a(e.e parame)
  {
    this.GGT = parame;
  }
  
  public final void aSs() {}
  
  public final void cancel()
  {
    AppMethodBeat.i(191301);
    this.GHq = this.GHo;
    this.GHr = this.GHp;
    b localb = this.GHs;
    if (localb != null) {
      localb.ay(this.GHq, this.GHr);
    }
    localb = this.GHs;
    if (localb != null)
    {
      localb.onFinish();
      AppMethodBeat.o(191301);
      return;
    }
    AppMethodBeat.o(191301);
  }
  
  final View fDm()
  {
    AppMethodBeat.i(191299);
    View localView = (View)this.GGj.getValue();
    AppMethodBeat.o(191299);
    return localView;
  }
  
  final TimeCropViewGroup fDn()
  {
    AppMethodBeat.i(191300);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.GGk.getValue();
    AppMethodBeat.o(191300);
    return localTimeCropViewGroup;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(191303);
    if (this.wji.bJw())
    {
      this.GGs = false;
      b localb = this.GHs;
      if (localb != null) {
        localb.onFinish();
      }
      this.wji.setShow(false);
      AppMethodBeat.o(191303);
      return true;
    }
    AppMethodBeat.o(191303);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onProgress(long paramLong)
  {
    AppMethodBeat.i(191304);
    fDn().setProgress(paramLong);
    AppMethodBeat.o(191304);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191307);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191307);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191302);
    if (paramInt == 8)
    {
      this.GGs = false;
      b localb = this.GHs;
      if (localb != null) {
        localb.onFinish();
      }
      this.wji.setShow(false);
    }
    AppMethodBeat.o(191302);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "", "onCrop", "", "start", "", "end", "onCropStart", "onDelete", "onFinish", "plugin-vlog_release"})
  public static abstract interface b
  {
    public abstract void ay(long paramLong1, long paramLong2);
    
    public abstract void eMs();
    
    public abstract void fDo();
    
    public abstract void onFinish();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<View>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191291);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.GHv.cancel();
      this.GHv.wji.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191291);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191292);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.GHv.GHs;
      if (paramView != null) {
        paramView.onFinish();
      }
      this.GHv.wji.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191292);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191293);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.GHv.GHs;
      if (paramView != null) {
        paramView.eMs();
      }
      this.GHv.wji.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191293);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191294);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.GHv.GHs;
      if (paramView != null) {
        paramView.eMs();
      }
      this.GHv.wji.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191294);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<View>
  {
    i(k paramk)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
  public static final class j
    implements TimeCropViewGroup.a
  {
    public final void d(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(191296);
      if (k.a(this.GHv) != paramLong1)
      {
        k.a(this.GHv, paramLong1);
        k.b(this.GHv, paramLong2);
      }
      for (long l = k.a(this.GHv);; l = k.c(this.GHv))
      {
        localObject = this.GHv.wgr;
        d.c localc = d.c.BWk;
        Bundle localBundle = new Bundle();
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", k.a(this.GHv));
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", k.c(this.GHv));
        ((d)localObject).a(localc, localBundle);
        if (!paramBoolean) {
          break label221;
        }
        localObject = this.GHv.GHs;
        if (localObject != null) {
          ((k.b)localObject).ay(paramLong1, paramLong2);
        }
        localObject = k.d(this.GHv);
        if (localObject != null) {
          ((e.e)localObject).Lb(k.a(this.GHv));
        }
        localObject = k.d(this.GHv);
        if (localObject == null) {
          break;
        }
        ((e.e)localObject).resume();
        AppMethodBeat.o(191296);
        return;
        k.a(this.GHv, paramLong1);
        k.b(this.GHv, paramLong2);
      }
      AppMethodBeat.o(191296);
      return;
      label221:
      Object localObject = this.GHv.GHs;
      if (localObject != null) {
        ((k.b)localObject).fDo();
      }
      localObject = k.d(this.GHv);
      if (localObject != null) {
        ((e.e)localObject).pause();
      }
      localObject = k.d(this.GHv);
      if (localObject != null)
      {
        ((e.e)localObject).Lb(l);
        AppMethodBeat.o(191296);
        return;
      }
      AppMethodBeat.o(191296);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<View>
  {
    k(k paramk)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<TimeCropViewGroup>
  {
    l(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.k
 * JD-Core Version:    0.7.0.1
 */