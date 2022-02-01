package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d;
import com.tencent.mm.plugin.vlog.ui.plugin.d.c;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup;
import com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.coremedia.CMTimeRange;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelImg", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelImg", "()Landroid/widget/ImageView;", "cancelImg$delegate", "Lkotlin/Lazy;", "confirmed", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "cropEnd", "", "cropStart", "doneImg", "getDoneImg", "doneImg$delegate", "editTimeData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "timeRangeEnd", "timeRangeStart", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setComposition", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "setEditData", "data", "setEnableLengthEdit", "enable", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.c
{
  public static final c.a Uqu;
  private final kotlin.j ATU;
  final EditorPanelHolder Gvm;
  private boolean UhB;
  private final kotlin.j Uhs;
  private final kotlin.j Uht;
  private long Uis;
  private long Uit;
  private long Uiu;
  private long Uiv;
  private final kotlin.j UmV;
  private final kotlin.j UmW;
  private long UmX;
  private long UmY;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.a UmZ;
  private final f Uqv;
  private boolean lYs;
  
  static
  {
    AppMethodBeat.i(282337);
    Uqu = new c.a((byte)0);
    AppMethodBeat.o(282337);
  }
  
  public c(EditorPanelHolder paramEditorPanelHolder, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282246);
    this.Gvm = paramEditorPanelHolder;
    this.ATU = k.cm((kotlin.g.a.a)new c.d(this));
    this.Uhs = k.cm((kotlin.g.a.a)new c.g(this));
    this.Uht = k.cm((kotlin.g.a.a)new h(this));
    this.UmV = k.cm((kotlin.g.a.a)new c.b(this));
    this.UmW = k.cm((kotlin.g.a.a)new c.e(this));
    this.Uqv = new f(this, parama);
    AppMethodBeat.o(282246);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(282253);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    paramc.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282253);
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(282265);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "this$0");
    if ((paramc.UmX != paramc.Uiu) || (paramc.UmY != paramc.Uiv))
    {
      paramView = paramc.UmZ;
      if (paramView != null)
      {
        paramView = paramView.NXR;
        if (paramView != null)
        {
          paramView.NZL.a(null);
          paramView.NZL.tF(paramc.Uiu);
          paramView.NZM.a(paramView.NZL);
          paramView.NZM.tF(paramc.Uiv - paramc.Uiu);
        }
      }
    }
    for (;;)
    {
      paramView = paramc.UmZ;
      if (paramView != null) {
        paramView.NXQ = null;
      }
      paramc.UmZ = null;
      paramc.Gvm.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282265);
      return;
      paramView = paramc.UmZ;
      if (paramView != null)
      {
        paramView = paramView.NXR;
        if (paramView != null) {
          paramView.bb(paramc.Uiu, paramc.Uiv);
        }
      }
    }
  }
  
  public final void a(d.e parame) {}
  
  public final TimeCropViewGroup hTc()
  {
    AppMethodBeat.i(282354);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.Uht.getValue();
    AppMethodBeat.o(282354);
    return localTimeCropViewGroup;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282368);
    if (this.Gvm.cvt())
    {
      this.UhB = false;
      this.Gvm.setShow(false);
      AppMethodBeat.o(282368);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(282368);
    return bool;
  }
  
  public final void qU(long paramLong)
  {
    AppMethodBeat.i(282395);
    hTc().getVisibility();
    hTc().setProgress(paramLong);
    AppMethodBeat.o(282395);
  }
  
  public final void setComposition(com.tencent.mm.videocomposition.j paramj)
  {
    AppMethodBeat.i(282386);
    s.u(paramj, "composition");
    Object localObject1 = this.UmZ;
    if (localObject1 != null)
    {
      this.UhB = false;
      if (!this.lYs)
      {
        this.lYs = true;
        this.Gvm.setCloseTouchOutside(true);
        hTc().setCallback((TimeCropViewGroup.a)this.Uqv);
        hTc().setRealTimeCallback((TimeCropViewGroup.a)this.Uqv);
        this.Gvm.setOnVisibleChangeCallback((kotlin.g.a.b)new c(this));
        ((ImageView)this.UmV.getValue()).setOnClickListener(new c..ExternalSyntheticLambda0(this));
        ((ImageView)this.UmW.getValue()).setOnClickListener(new c..ExternalSyntheticLambda1(this));
      }
      this.Uis = (paramj.jLV().getStartUs() / 1000L);
      this.Uit = (paramj.jLV().getEndUs() / 1000L);
      if (((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZM.getTime() > this.Uit)
      {
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZM;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c)localObject2).tF(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c)localObject2).offset + (this.Uit - ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZM.getTime()));
      }
      this.Uiu = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZL.getTime();
      this.Uiv = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZM.getTime();
      this.UmX = this.Uiu;
      this.UmY = this.Uiv;
      Object localObject2 = new d(0L, false, 3);
      ((d)localObject2).bb(this.UmX, this.UmY);
      ah localah = ah.aiuX;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXQ = ((d)localObject2);
      Log.i("MicroMsg.VLogTimeEditPlugin", s.X("time range:", ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR));
      localObject1 = hTc();
      paramj = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d(paramj);
      localObject2 = this.UmZ;
      s.checkNotNull(localObject2);
      long l = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).NXR.NZL.getTime();
      localObject2 = this.UmZ;
      s.checkNotNull(localObject2);
      ((TimeCropViewGroup)localObject1).a(paramj, l, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).NXR.NZM.getTime());
      this.Gvm.setShow(true);
    }
    AppMethodBeat.o(282386);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282362);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.UhB = false;
      this.Gvm.setShow(false);
    }
    AppMethodBeat.o(282362);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorEffectTimeCropPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements TimeCropViewGroup.a
  {
    f(c paramc, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama) {}
    
    public final void d(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(282048);
      Object localObject2 = new StringBuilder("onCropCallback: [").append(paramLong1).append(", ").append(paramLong2).append("], onUp:").append(paramBoolean).append(", showTime start:");
      Object localObject1 = c.a(this.Uqw);
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" end:");
        localObject1 = c.a(this.Uqw);
        if (localObject1 != null) {
          break label308;
        }
        localObject1 = null;
        label92:
        Log.i("MicroMsg.VLogTimeEditPlugin", localObject1);
        if (c.d(this.Uqw) == paramLong1) {
          break label339;
        }
        c.a(this.Uqw, paramLong1);
        c.b(this.Uqw, paramLong2);
      }
      for (paramLong1 = c.d(this.Uqw);; paramLong1 = c.g(this.Uqw))
      {
        localObject1 = c.a(this.Uqw);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXQ;
          if (localObject1 != null) {
            ((d)localObject1).bb(c.d(this.Uqw), c.g(this.Uqw));
          }
        }
        localObject1 = parama;
        localObject2 = a.c.NPF;
        Bundle localBundle = new Bundle();
        Object localObject3 = this.Uqw;
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", c.d((c)localObject3));
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", c.g((c)localObject3));
        localBundle.putLong("EDIT_CROP_VLOG_SEEKTIME_LONG", paramLong1);
        localBundle.putBoolean("EDIT_CROP_VLOG_ON_UP_BOOLEAN", paramBoolean);
        localObject3 = ah.aiuX;
        ((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject1).a((a.c)localObject2, localBundle);
        AppMethodBeat.o(282048);
        return;
        localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = Long.valueOf(((d)localObject1).getStart());
        break;
        label308:
        localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label92;
        }
        localObject1 = Long.valueOf(((d)localObject1).getEnd());
        break label92;
        label339:
        c.a(this.Uqw, paramLong1);
        c.b(this.Uqw, paramLong2);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TimeCropViewGroup>
  {
    h(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.c
 * JD-Core Version:    0.7.0.1
 */