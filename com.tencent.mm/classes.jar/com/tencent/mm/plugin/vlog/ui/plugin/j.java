package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup.a;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getCancelBtn", "()Landroid/view/View;", "cancelBtn$delegate", "Lkotlin/Lazy;", "confirmed", "", "cropEnd", "", "cropStart", "editCallback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "getEditCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "setEditCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;)V", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "okBtn", "getOkBtn", "okBtn$delegate", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "getPanelRoot", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "cancel", "", "checkInit", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEnableLengthEdit", "enable", "setTimeRange", "start", "end", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "EditCallback", "plugin-vlog_release"})
public final class j
  implements u, d.c
{
  public static final a Nvi;
  final d APl;
  final EditorPanelHolder ATq;
  final f Aqt;
  private d.e NuG;
  private final f Nua;
  private final f Nub;
  boolean Nuj;
  final f Nvb;
  long Nvc;
  long Nvd;
  long Nve;
  long Nvf;
  b Nvg;
  final j Nvh;
  boolean jvb;
  
  static
  {
    AppMethodBeat.i(225723);
    Nvi = new a((byte)0);
    AppMethodBeat.o(225723);
  }
  
  public j(EditorPanelHolder paramEditorPanelHolder, d paramd)
  {
    AppMethodBeat.i(225721);
    this.ATq = paramEditorPanelHolder;
    this.APl = paramd;
    this.Nua = g.ar((kotlin.g.a.a)new k(this));
    this.Nub = g.ar((kotlin.g.a.a)new l(this));
    this.Aqt = g.ar((kotlin.g.a.a)new c(this));
    this.Nvb = g.ar((kotlin.g.a.a)new i(this));
    this.Nvh = new j(this);
    AppMethodBeat.o(225721);
  }
  
  public final void LX(long paramLong)
  {
    AppMethodBeat.i(225720);
    gvm().setProgress(paramLong);
    AppMethodBeat.o(225720);
  }
  
  public final void a(d.e parame)
  {
    this.NuG = parame;
  }
  
  public final void bbp() {}
  
  public final void cancel()
  {
    AppMethodBeat.i(225717);
    this.Nve = this.Nvc;
    this.Nvf = this.Nvd;
    b localb = this.Nvg;
    if (localb != null) {
      localb.aN(this.Nve, this.Nvf);
    }
    localb = this.Nvg;
    if (localb != null)
    {
      localb.onFinish();
      AppMethodBeat.o(225717);
      return;
    }
    AppMethodBeat.o(225717);
  }
  
  final View gvl()
  {
    AppMethodBeat.i(225715);
    View localView = (View)this.Nua.getValue();
    AppMethodBeat.o(225715);
    return localView;
  }
  
  final TimeCropViewGroup gvm()
  {
    AppMethodBeat.i(225716);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.Nub.getValue();
    AppMethodBeat.o(225716);
    return localTimeCropViewGroup;
  }
  
  public final String name()
  {
    AppMethodBeat.i(225724);
    String str = getClass().getName();
    AppMethodBeat.o(225724);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(225719);
    if (this.ATq.bVd())
    {
      this.Nuj = false;
      b localb = this.Nvg;
      if (localb != null) {
        localb.onFinish();
      }
      this.ATq.setShow(false);
      AppMethodBeat.o(225719);
      return true;
    }
    AppMethodBeat.o(225719);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(225726);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(225726);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(225718);
    if (paramInt == 8)
    {
      this.Nuj = false;
      b localb = this.Nvg;
      if (localb != null) {
        localb.onFinish();
      }
      this.ATq.setShow(false);
    }
    AppMethodBeat.o(225718);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$EditCallback;", "", "onCrop", "", "start", "", "end", "onCropStart", "onDelete", "onFinish", "plugin-vlog_release"})
  public static abstract interface b
  {
    public abstract void aN(long paramLong1, long paramLong2);
    
    public abstract void fyQ();
    
    public abstract void gvn();
    
    public abstract void onFinish();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<View>
  {
    c(j paramj)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(j paramj)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(j paramj) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(224382);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Nvj.cancel();
      this.Nvj.ATq.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(224382);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(j paramj) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227024);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.Nvj.Nvg;
      if (paramView != null) {
        paramView.onFinish();
      }
      this.Nvj.ATq.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(227024);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(j paramj) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243104);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.Nvj.Nvg;
      if (paramView != null) {
        paramView.fyQ();
      }
      this.Nvj.ATq.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243104);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(j paramj) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242435);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.Nvj.Nvg;
      if (paramView != null) {
        paramView.fyQ();
      }
      this.Nvj.ATq.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$checkInit$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242435);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<View>
  {
    i(j paramj)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/MagicTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
  public static final class j
    implements TimeCropViewGroup.a
  {
    public final void d(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(245671);
      if (j.a(this.Nvj) != paramLong1)
      {
        j.a(this.Nvj, paramLong1);
        j.b(this.Nvj, paramLong2);
      }
      for (long l = j.a(this.Nvj);; l = j.c(this.Nvj))
      {
        localObject = this.Nvj.APl;
        com.tencent.mm.plugin.recordvideo.plugin.parent.d.c localc = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSZ;
        Bundle localBundle = new Bundle();
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", j.a(this.Nvj));
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", j.c(this.Nvj));
        ((d)localObject).a(localc, localBundle);
        if (!paramBoolean) {
          break label221;
        }
        localObject = this.Nvj.Nvg;
        if (localObject != null) {
          ((j.b)localObject).aN(paramLong1, paramLong2);
        }
        localObject = j.d(this.Nvj);
        if (localObject != null) {
          ((d.e)localObject).Sw(j.a(this.Nvj));
        }
        localObject = j.d(this.Nvj);
        if (localObject == null) {
          break;
        }
        ((d.e)localObject).resume();
        AppMethodBeat.o(245671);
        return;
        j.a(this.Nvj, paramLong1);
        j.b(this.Nvj, paramLong2);
      }
      AppMethodBeat.o(245671);
      return;
      label221:
      Object localObject = this.Nvj.Nvg;
      if (localObject != null) {
        ((j.b)localObject).gvn();
      }
      localObject = j.d(this.Nvj);
      if (localObject != null) {
        ((d.e)localObject).pause();
      }
      localObject = j.d(this.Nvj);
      if (localObject != null)
      {
        ((d.e)localObject).Sw(l);
        AppMethodBeat.o(245671);
        return;
      }
      AppMethodBeat.o(245671);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<View>
  {
    k(j paramj)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<TimeCropViewGroup>
  {
    l(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.j
 * JD-Core Version:    0.7.0.1
 */