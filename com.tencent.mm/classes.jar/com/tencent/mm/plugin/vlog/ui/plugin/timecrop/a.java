package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.j;
import com.tencent.tav.coremedia.CMTimeRange;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelImg", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelImg", "()Landroid/widget/ImageView;", "cancelImg$delegate", "Lkotlin/Lazy;", "confirmed", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "cropEnd", "", "cropStart", "doneImg", "getDoneImg", "doneImg$delegate", "editTimeData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "timeRangeEnd", "timeRangeStart", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEditData", "data", "setEnableLengthEdit", "enable", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements com.tencent.mm.plugin.vlog.ui.plugin.d.c
{
  public static final a NAk;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  final EditorPanelHolder ATq;
  private final f NAe;
  private final f NAf;
  private long NAg;
  private long NAh;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.a NAi;
  private final h NAj;
  private d.e NuG;
  private final f Nua;
  private final f Nub;
  private boolean Nuj;
  private long Nvc;
  private long Nvd;
  private long Nve;
  private long Nvf;
  private boolean jvb;
  private final f xwp;
  
  static
  {
    AppMethodBeat.i(246249);
    NAk = new a((byte)0);
    AppMethodBeat.o(246249);
  }
  
  public a(EditorPanelHolder paramEditorPanelHolder, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(246248);
    this.ATq = paramEditorPanelHolder;
    this.APl = paramd;
    this.xwp = g.ar((kotlin.g.a.a)new f(this));
    this.Nua = g.ar((kotlin.g.a.a)new i(this));
    this.Nub = g.ar((kotlin.g.a.a)new j(this));
    this.NAe = g.ar((kotlin.g.a.a)new b(this));
    this.NAf = g.ar((kotlin.g.a.a)new g(this));
    this.NAj = new h(this);
    AppMethodBeat.o(246248);
  }
  
  private final void bcM()
  {
    AppMethodBeat.i(246242);
    if (this.jvb)
    {
      AppMethodBeat.o(246242);
      return;
    }
    this.jvb = true;
    this.ATq.setCloseTouchOutside(true);
    gvm().setCallback((TimeCropViewGroup.a)this.NAj);
    gvm().setRealTimeCallback((TimeCropViewGroup.a)this.NAj);
    this.ATq.setOnVisibleChangeCallback((kotlin.g.a.b)new c(this));
    ((ImageView)this.NAe.getValue()).setOnClickListener((View.OnClickListener)new d(this));
    ((ImageView)this.NAf.getValue()).setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(246242);
  }
  
  private final TimeCropViewGroup gvm()
  {
    AppMethodBeat.i(246240);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.Nub.getValue();
    AppMethodBeat.o(246240);
    return localTimeCropViewGroup;
  }
  
  public final void LX(long paramLong)
  {
    AppMethodBeat.i(246247);
    gvm().setProgress(paramLong);
    AppMethodBeat.o(246247);
  }
  
  public final void a(d.e parame)
  {
    this.NuG = parame;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(246245);
    if (this.ATq.bVd())
    {
      this.Nuj = false;
      this.ATq.setShow(false);
      AppMethodBeat.o(246245);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(246245);
    return bool;
  }
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(246243);
    gvm().setEnableLengthEdit(paramBoolean);
    AppMethodBeat.o(246243);
  }
  
  public final void setTrack(ac paramac)
  {
    AppMethodBeat.i(246246);
    p.k(paramac, "composition");
    Object localObject1 = this.NAi;
    if (localObject1 != null)
    {
      this.Nuj = false;
      bcM();
      this.Nvc = (paramac.NmT.igH().getStartUs() / 1000L);
      this.Nvd = (paramac.NmT.igH().getEndUs() / 1000L);
      if (((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.Idp.getTime() > this.Nvd)
      {
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.Idp;
        ((c)localObject2).PF(((c)localObject2).offset + (this.Nvd - ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.Idp.getTime()));
      }
      this.Nve = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.Ido.getTime();
      this.Nvf = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr.Idp.getTime();
      this.NAg = this.Nve;
      this.NAh = this.Nvf;
      Object localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(0L, false, 3);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject2).ar(this.NAg, this.NAh);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibq = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject2);
      Log.i("MicroMsg.VLogTimeEditPlugin", "time range:" + ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr);
      localObject1 = gvm();
      localObject2 = this.NAi;
      if (localObject2 == null) {
        p.iCn();
      }
      long l = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).Ibr.getStart();
      localObject2 = this.NAi;
      if (localObject2 == null) {
        p.iCn();
      }
      ((TimeCropViewGroup)localObject1).a(paramac, l, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).Ibr.getEnd());
      this.ATq.setShow(true);
      AppMethodBeat.o(246246);
      return;
    }
    AppMethodBeat.o(246246);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(246244);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.Nuj = false;
      this.ATq.setShow(false);
    }
    AppMethodBeat.o(246244);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(233487);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.NAl.ATq.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(233487);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(229484);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if ((a.c(this.NAl) != a.e(this.NAl)) || (a.d(this.NAl) != a.f(this.NAl)))
      {
        paramView = a.a(this.NAl);
        if (paramView != null)
        {
          paramView = paramView.Ibr;
          if (paramView != null)
          {
            paramView.Ido.a(null);
            paramView.Ido.PF(a.e(this.NAl));
            paramView.Idp.a(paramView.Ido);
            paramView.Idp.PF(a.f(this.NAl) - a.e(this.NAl));
          }
        }
      }
      for (;;)
      {
        paramView = a.a(this.NAl);
        if (paramView != null) {
          paramView.Ibq = null;
        }
        a.b(this.NAl);
        this.NAl.ATq.setShow(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(229484);
        return;
        paramView = a.a(this.NAl);
        if (paramView != null)
        {
          paramView = paramView.Ibr;
          if (paramView != null) {
            paramView.ar(a.e(this.NAl), a.f(this.NAl));
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
    f(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
  public static final class h
    implements TimeCropViewGroup.a
  {
    public final void d(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.c localc = null;
      AppMethodBeat.i(230384);
      Object localObject2 = new StringBuilder("onCropCallback: [").append(paramLong1).append(", ").append(paramLong2).append("], onUp:").append(paramBoolean).append(", showTime start:");
      Object localObject1 = a.a(this.NAl);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibr;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getStart());
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" end:");
          Object localObject3 = a.a(this.NAl);
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
          if (a.e(this.NAl) == paramLong1) {
            break label328;
          }
          a.a(this.NAl, paramLong1);
          a.b(this.NAl, paramLong2);
        }
      }
      for (paramLong1 = a.e(this.NAl);; paramLong1 = a.f(this.NAl))
      {
        localObject1 = a.a(this.NAl);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibq;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).ar(a.e(this.NAl), a.f(this.NAl));
          }
        }
        localObject1 = this.NAl.APl;
        localc = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSZ;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", a.e(this.NAl));
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", a.f(this.NAl));
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_SEEKTIME_LONG", paramLong1);
        ((Bundle)localObject2).putBoolean("EDIT_CROP_VLOG_ON_UP_BOOLEAN", paramBoolean);
        ((com.tencent.mm.plugin.recordvideo.plugin.parent.d)localObject1).a(localc, (Bundle)localObject2);
        AppMethodBeat.o(230384);
        return;
        localObject1 = null;
        break;
        label328:
        a.a(this.NAl, paramLong1);
        a.b(this.NAl, paramLong2);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<TimeCropViewGroup>
  {
    j(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.a
 * JD-Core Version:    0.7.0.1
 */