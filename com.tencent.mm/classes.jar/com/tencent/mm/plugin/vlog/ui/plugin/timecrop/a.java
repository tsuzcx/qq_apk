package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.d.c;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.coremedia.CMTimeRange;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelImg", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelImg", "()Landroid/widget/ImageView;", "cancelImg$delegate", "Lkotlin/Lazy;", "confirmed", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "cropEnd", "", "cropStart", "doneImg", "getDoneImg", "doneImg$delegate", "editTimeData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "timeRangeEnd", "timeRangeStart", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEditData", "data", "setEnableLengthEdit", "enable", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.c
{
  public static final a.a UmU;
  private final kotlin.j ATU;
  final EditorPanelHolder Gvm;
  private boolean UhB;
  private final kotlin.j Uhs;
  private final kotlin.j Uht;
  private d.e Uia;
  private long Uis;
  private long Uit;
  private long Uiu;
  private long Uiv;
  private final kotlin.j UmV;
  private final kotlin.j UmW;
  private long UmX;
  private long UmY;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.a UmZ;
  private final f Una;
  private boolean lYs;
  
  static
  {
    AppMethodBeat.i(283054);
    UmU = new a.a((byte)0);
    AppMethodBeat.o(283054);
  }
  
  public a(EditorPanelHolder paramEditorPanelHolder, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282973);
    this.Gvm = paramEditorPanelHolder;
    this.ATU = k.cm((kotlin.g.a.a)new a.d(this));
    this.Uhs = k.cm((kotlin.g.a.a)new a.g(this));
    this.Uht = k.cm((kotlin.g.a.a)new h(this));
    this.UmV = k.cm((kotlin.g.a.a)new a.b(this));
    this.UmW = k.cm((kotlin.g.a.a)new a.e(this));
    this.Una = new f(this, parama);
    AppMethodBeat.o(282973);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(283004);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama.Gvm.setShow(false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283004);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(283014);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    if ((parama.UmX != parama.Uiu) || (parama.UmY != parama.Uiv))
    {
      paramView = parama.UmZ;
      if (paramView != null)
      {
        paramView = paramView.NXR;
        if (paramView != null)
        {
          paramView.NZL.a(null);
          paramView.NZL.tF(parama.Uiu);
          paramView.NZM.a(paramView.NZL);
          paramView.NZM.tF(parama.Uiv - parama.Uiu);
        }
      }
    }
    for (;;)
    {
      paramView = parama.UmZ;
      if (paramView != null) {
        paramView.NXQ = null;
      }
      parama.UmZ = null;
      parama.Gvm.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(283014);
      return;
      paramView = parama.UmZ;
      if (paramView != null)
      {
        paramView = paramView.NXR;
        if (paramView != null) {
          paramView.bb(parama.Uiu, parama.Uiv);
        }
      }
    }
  }
  
  private final void checkInit()
  {
    AppMethodBeat.i(282994);
    if (this.lYs)
    {
      AppMethodBeat.o(282994);
      return;
    }
    this.lYs = true;
    this.Gvm.setCloseTouchOutside(true);
    hTc().setCallback((TimeCropViewGroup.a)this.Una);
    hTc().setRealTimeCallback((TimeCropViewGroup.a)this.Una);
    this.Gvm.setOnVisibleChangeCallback((kotlin.g.a.b)new c(this));
    ((ImageView)this.UmV.getValue()).setOnClickListener(new a..ExternalSyntheticLambda1(this));
    ((ImageView)this.UmW.getValue()).setOnClickListener(new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(282994);
  }
  
  private final TimeCropViewGroup hTc()
  {
    AppMethodBeat.i(282986);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.Uht.getValue();
    AppMethodBeat.o(282986);
    return localTimeCropViewGroup;
  }
  
  public final void a(d.e parame)
  {
    this.Uia = parame;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(283077);
    if (this.Gvm.cvt())
    {
      this.UhB = false;
      this.Gvm.setShow(false);
      AppMethodBeat.o(283077);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(283077);
    return bool;
  }
  
  public final void qU(long paramLong)
  {
    AppMethodBeat.i(283103);
    hTc().setProgress(paramLong);
    AppMethodBeat.o(283103);
  }
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(283068);
    hTc().setEnableLengthEdit(paramBoolean);
    AppMethodBeat.o(283068);
  }
  
  public final void setTrack(ac paramac)
  {
    AppMethodBeat.i(283092);
    s.u(paramac, "composition");
    Object localObject1 = this.UmZ;
    if (localObject1 != null)
    {
      this.UhB = false;
      checkInit();
      this.Uis = (paramac.Uaw.jLV().getStartUs() / 1000L);
      this.Uit = (paramac.Uaw.jLV().getEndUs() / 1000L);
      if (((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZM.getTime() > this.Uit)
      {
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZM;
        ((c)localObject2).tF(((c)localObject2).offset + (this.Uit - ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXR.NZM.getTime()));
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
      localObject2 = this.UmZ;
      s.checkNotNull(localObject2);
      long l = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).NXR.NZL.getTime();
      localObject2 = this.UmZ;
      s.checkNotNull(localObject2);
      ((TimeCropViewGroup)localObject1).a(paramac, l, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).NXR.NZM.getTime());
      this.Gvm.setShow(true);
    }
    AppMethodBeat.o(283092);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(283073);
    super.setVisibility(paramInt);
    if (paramInt == 8)
    {
      this.UhB = false;
      this.Gvm.setShow(false);
    }
    AppMethodBeat.o(283073);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements TimeCropViewGroup.a
  {
    f(a parama, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama1) {}
    
    public final void d(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(282956);
      Object localObject2 = new StringBuilder("onCropCallback: [").append(paramLong1).append(", ").append(paramLong2).append("], onUp:").append(paramBoolean).append(", showTime start:");
      Object localObject1 = a.a(this.Unb);
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" end:");
        localObject1 = a.a(this.Unb);
        if (localObject1 != null) {
          break label308;
        }
        localObject1 = null;
        label92:
        Log.i("MicroMsg.VLogTimeEditPlugin", localObject1);
        if (a.d(this.Unb) == paramLong1) {
          break label339;
        }
        a.a(this.Unb, paramLong1);
        a.b(this.Unb, paramLong2);
      }
      for (paramLong1 = a.d(this.Unb);; paramLong1 = a.g(this.Unb))
      {
        localObject1 = a.a(this.Unb);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXQ;
          if (localObject1 != null) {
            ((d)localObject1).bb(a.d(this.Unb), a.g(this.Unb));
          }
        }
        localObject1 = parama;
        localObject2 = com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPF;
        Bundle localBundle = new Bundle();
        Object localObject3 = this.Unb;
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", a.d((a)localObject3));
        localBundle.putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", a.g((a)localObject3));
        localBundle.putLong("EDIT_CROP_VLOG_SEEKTIME_LONG", paramLong1);
        localBundle.putBoolean("EDIT_CROP_VLOG_ON_UP_BOOLEAN", paramBoolean);
        localObject3 = ah.aiuX;
        ((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject1).a((com.tencent.mm.plugin.recordvideo.plugin.parent.a.c)localObject2, localBundle);
        AppMethodBeat.o(282956);
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
        a.a(this.Unb, paramLong1);
        a.b(this.Unb, paramLong2);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TimeCropViewGroup>
  {
    h(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.a
 * JD-Core Version:    0.7.0.1
 */