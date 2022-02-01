package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelImg", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelImg", "()Landroid/widget/ImageView;", "cancelImg$delegate", "Lkotlin/Lazy;", "confirmed", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "cropEnd", "", "cropStart", "doneImg", "getDoneImg", "doneImg$delegate", "editTimeData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "timeRangeEnd", "timeRangeStart", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setComposition", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "setEditData", "data", "setEnableLengthEdit", "enable", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"})
public final class c
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements com.tencent.mm.plugin.vlog.ui.plugin.d.c
{
  public static final a NDY;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  public final EditorPanelHolder ATq;
  public final f NAe;
  public final f NAf;
  public long NAg;
  public long NAh;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.a NAi;
  public final h NDX;
  private final f Nua;
  private final f Nub;
  public boolean Nuj;
  public long Nvc;
  public long Nvd;
  public long Nve;
  public long Nvf;
  public boolean jvb;
  private final f xwp;
  
  static
  {
    AppMethodBeat.i(251486);
    NDY = new a((byte)0);
    AppMethodBeat.o(251486);
  }
  
  public c(EditorPanelHolder paramEditorPanelHolder, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(251484);
    this.ATq = paramEditorPanelHolder;
    this.APl = paramd;
    this.xwp = g.ar((kotlin.g.a.a)new f(this));
    this.Nua = g.ar((kotlin.g.a.a)new i(this));
    this.Nub = g.ar((kotlin.g.a.a)new j(this));
    this.NAe = g.ar((kotlin.g.a.a)new b(this));
    this.NAf = g.ar((kotlin.g.a.a)new g(this));
    this.NDX = new h(this);
    AppMethodBeat.o(251484);
  }
  
  public final void LX(long paramLong)
  {
    AppMethodBeat.i(251483);
    TimeCropViewGroup localTimeCropViewGroup = gvm();
    p.j(localTimeCropViewGroup, "trackCropView");
    localTimeCropViewGroup.getVisibility();
    gvm().setProgress(paramLong);
    AppMethodBeat.o(251483);
  }
  
  public final void a(d.e parame) {}
  
  public final TimeCropViewGroup gvm()
  {
    AppMethodBeat.i(251480);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.Nub.getValue();
    AppMethodBeat.o(251480);
    return localTimeCropViewGroup;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(251482);
    if (this.ATq.bVd())
    {
      this.Nuj = false;
      this.ATq.setShow(false);
      AppMethodBeat.o(251482);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(251482);
    return bool;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(251481);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.Nuj = false;
      this.ATq.setShow(false);
    }
    AppMethodBeat.o(251481);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public c(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237115);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.NDZ.ATq.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237115);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class e
    implements View.OnClickListener
  {
    public e(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228236);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if ((c.c(this.NDZ) != c.e(this.NDZ)) || (c.d(this.NDZ) != c.f(this.NDZ)))
      {
        paramView = c.a(this.NDZ);
        if (paramView != null)
        {
          paramView = paramView.Ibr;
          if (paramView != null)
          {
            paramView.Ido.a(null);
            paramView.Ido.PF(c.e(this.NDZ));
            paramView.Idp.a(paramView.Ido);
            paramView.Idp.PF(c.f(this.NDZ) - c.e(this.NDZ));
          }
        }
      }
      for (;;)
      {
        paramView = c.a(this.NDZ);
        if (paramView != null) {
          paramView.Ibq = null;
        }
        c.b(this.NDZ);
        this.NDZ.ATq.setShow(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(228236);
        return;
        paramView = c.a(this.NDZ);
        if (paramView != null)
        {
          paramView = paramView.Ibr;
          if (paramView != null) {
            paramView.ar(c.e(this.NDZ), c.f(this.NDZ));
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<Context>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    g(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
  public static final class h
    implements TimeCropViewGroup.a
  {
    public final void d(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.c localc = null;
      AppMethodBeat.i(242131);
      Object localObject2 = new StringBuilder("onCropCallback: [").append(paramLong1).append(", ").append(paramLong2).append("], onUp:").append(paramBoolean).append(", showTime start:");
      Object localObject1 = c.a(this.NDZ);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getStart());
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" end:");
          Object localObject3 = c.a(this.NDZ);
          localObject1 = localc;
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).Ibr;
            localObject1 = localc;
            if (localObject3 != null) {
              localObject1 = Long.valueOf(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getEnd());
            }
          }
          Log.i("MicroMsg.VLogTimeEditPlugin", localObject1);
          if (c.e(this.NDZ) == paramLong1) {
            break label328;
          }
          c.a(this.NDZ, paramLong1);
          c.b(this.NDZ, paramLong2);
        }
      }
      for (paramLong1 = c.e(this.NDZ);; paramLong1 = c.f(this.NDZ))
      {
        localObject1 = c.a(this.NDZ);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibq;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).ar(c.e(this.NDZ), c.f(this.NDZ));
          }
        }
        localObject1 = this.NDZ.APl;
        localc = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSZ;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", c.e(this.NDZ));
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", c.f(this.NDZ));
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_SEEKTIME_LONG", paramLong1);
        ((Bundle)localObject2).putBoolean("EDIT_CROP_VLOG_ON_UP_BOOLEAN", paramBoolean);
        ((com.tencent.mm.plugin.recordvideo.plugin.parent.d)localObject1).a(localc, (Bundle)localObject2);
        AppMethodBeat.o(242131);
        return;
        localObject1 = null;
        break;
        label328:
        c.a(this.NDZ, paramLong1);
        c.b(this.NDZ, paramLong2);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    i(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<TimeCropViewGroup>
  {
    j(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.c
 * JD-Core Version:    0.7.0.1
 */