package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c;
import com.tencent.mm.plugin.vlog.ui.plugin.c.c;
import com.tencent.mm.plugin.vlog.ui.plugin.c.e;
import com.tencent.mm.sdk.platformtools.ae;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelImg", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelImg", "()Landroid/widget/ImageView;", "cancelImg$delegate", "Lkotlin/Lazy;", "confirmed", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "cropEnd", "", "cropStart", "doneImg", "getDoneImg", "doneImg$delegate", "editTimeData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "timeRangeEnd", "timeRangeStart", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEditData", "data", "setEnableLengthEdit", "enable", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"})
public final class a
  implements t, c.c
{
  public static final a.a CjB;
  private final f CdT;
  private final f CdU;
  public long CdY;
  public long CdZ;
  public long Cea;
  public long Ceb;
  public boolean Ced;
  private c.e Cee;
  public final h CjA;
  public final f Cjv;
  public final f Cjw;
  public long Cjx;
  public long Cjy;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.a Cjz;
  public boolean gff;
  private final f scS;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d tbP;
  public final EditorPanelHolder tcK;
  
  static
  {
    AppMethodBeat.i(192116);
    CjB = new a.a((byte)0);
    AppMethodBeat.o(192116);
  }
  
  public a(EditorPanelHolder paramEditorPanelHolder, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(192115);
    this.tcK = paramEditorPanelHolder;
    this.tbP = paramd;
    this.scS = g.O((d.g.a.a)new f(this));
    this.CdT = g.O((d.g.a.a)new i(this));
    this.CdU = g.O((d.g.a.a)new j(this));
    this.Cjv = g.O((d.g.a.a)new b(this));
    this.Cjw = g.O((d.g.a.a)new g(this));
    this.CjA = new h(this);
    AppMethodBeat.o(192115);
  }
  
  public final void BO(long paramLong)
  {
    AppMethodBeat.i(192114);
    exa().setProgress(paramLong);
    AppMethodBeat.o(192114);
  }
  
  public final void a(c.e parame)
  {
    this.Cee = parame;
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(192113);
    if (this.tcK.bnS())
    {
      this.Ced = false;
      this.tcK.setShow(false);
      AppMethodBeat.o(192113);
      return true;
    }
    AppMethodBeat.o(192113);
    return false;
  }
  
  public final void azm() {}
  
  public final TimeCropViewGroup exa()
  {
    AppMethodBeat.i(192111);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.CdU.getValue();
    AppMethodBeat.o(192111);
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
    AppMethodBeat.i(192117);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(192117);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(192112);
    if (paramInt == 8)
    {
      this.Ced = false;
      this.tcK.setShow(false);
    }
    AppMethodBeat.o(192112);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<ImageView>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.b<Boolean, z>
  {
    public c(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(192102);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.CjC.tcK.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(192102);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class e
    implements View.OnClickListener
  {
    public e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(192103);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if ((a.c(this.CjC) != a.e(this.CjC)) || (a.d(this.CjC) != a.f(this.CjC)))
      {
        paramView = a.a(this.CjC);
        if (paramView != null)
        {
          paramView = paramView.ydt;
          if (paramView != null)
          {
            paramView.yfy.a(null);
            paramView.yfy.zn(a.e(this.CjC));
            paramView.yfz.a(paramView.yfy);
            paramView.yfz.zn(a.f(this.CjC) - a.e(this.CjC));
          }
        }
      }
      for (;;)
      {
        paramView = a.a(this.CjC);
        if (paramView != null) {
          paramView.yds = null;
        }
        a.b(this.CjC);
        this.CjC.tcK.setShow(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192103);
        return;
        paramView = a.a(this.CjC);
        if (paramView != null)
        {
          paramView = paramView.ydt;
          if (paramView != null) {
            paramView.ae(a.e(this.CjC), a.f(this.CjC));
          }
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<Context>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<ImageView>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
  public static final class h
    implements TimeCropViewGroup.a
  {
    public final void f(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      d.c localc = null;
      AppMethodBeat.i(192106);
      Object localObject2 = new StringBuilder("onCropCallback: [").append(paramLong1).append(", ").append(paramLong2).append("], onUp:").append(paramBoolean).append(", showTime start:");
      Object localObject1 = a.a(this.CjC);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).ydt;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getStart());
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" end:");
          Object localObject3 = a.a(this.CjC);
          localObject1 = localc;
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).ydt;
            localObject1 = localc;
            if (localObject3 != null) {
              localObject1 = Long.valueOf(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getEnd());
            }
          }
          ae.i("MicroMsg.VLogTimeEditPlugin", localObject1);
          if (a.e(this.CjC) == paramLong1) {
            break label328;
          }
          a.a(this.CjC, paramLong1);
          a.b(this.CjC, paramLong2);
        }
      }
      for (paramLong1 = a.e(this.CjC);; paramLong1 = a.f(this.CjC))
      {
        localObject1 = a.a(this.CjC);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).yds;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).ae(a.e(this.CjC), a.f(this.CjC));
          }
        }
        localObject1 = this.CjC.tbP;
        localc = d.c.xVA;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", a.e(this.CjC));
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", a.f(this.CjC));
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_SEEKTIME_LONG", paramLong1);
        ((Bundle)localObject2).putBoolean("EDIT_CROP_VLOG_ON_UP_BOOLEAN", paramBoolean);
        ((com.tencent.mm.plugin.recordvideo.plugin.parent.d)localObject1).a(localc, (Bundle)localObject2);
        AppMethodBeat.o(192106);
        return;
        localObject1 = null;
        break;
        label328:
        a.a(this.CjC, paramLong1);
        a.b(this.CjC, paramLong2);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<ViewGroup>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<TimeCropViewGroup>
  {
    j(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.a
 * JD-Core Version:    0.7.0.1
 */