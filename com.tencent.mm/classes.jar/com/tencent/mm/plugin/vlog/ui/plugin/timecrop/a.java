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
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelImg", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelImg", "()Landroid/widget/ImageView;", "cancelImg$delegate", "Lkotlin/Lazy;", "confirmed", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "cropEnd", "", "cropStart", "doneImg", "getDoneImg", "doneImg$delegate", "editTimeData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "timeRangeEnd", "timeRangeStart", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEditData", "data", "setEnableLengthEdit", "enable", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"})
public final class a
  implements t, c.c
{
  public static final a.a BSb;
  public long BMA;
  public long BMB;
  public long BMC;
  public boolean BME;
  private c.e BMF;
  private final f BMu;
  private final f BMv;
  public long BMz;
  public final f BRV;
  public final f BRW;
  public long BRX;
  public long BRY;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.a BRZ;
  public final h BSa;
  public boolean gcX;
  private final f rUo;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d sQE;
  public final EditorPanelHolder sRz;
  
  static
  {
    AppMethodBeat.i(196655);
    BSb = new a.a((byte)0);
    AppMethodBeat.o(196655);
  }
  
  public a(EditorPanelHolder paramEditorPanelHolder, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(196654);
    this.sRz = paramEditorPanelHolder;
    this.sQE = paramd;
    this.rUo = g.O((d.g.a.a)new f(this));
    this.BMu = g.O((d.g.a.a)new i(this));
    this.BMv = g.O((d.g.a.a)new j(this));
    this.BRV = g.O((d.g.a.a)new b(this));
    this.BRW = g.O((d.g.a.a)new g(this));
    this.BSa = new h(this);
    AppMethodBeat.o(196654);
  }
  
  public final void Bq(long paramLong)
  {
    AppMethodBeat.i(196653);
    ett().setProgress(paramLong);
    AppMethodBeat.o(196653);
  }
  
  public final void a(c.e parame)
  {
    this.BMF = parame;
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(196652);
    if (this.sRz.bni())
    {
      this.BME = false;
      this.sRz.setShow(false);
      AppMethodBeat.o(196652);
      return true;
    }
    AppMethodBeat.o(196652);
    return false;
  }
  
  public final void ayX() {}
  
  public final TimeCropViewGroup ett()
  {
    AppMethodBeat.i(196650);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.BMv.getValue();
    AppMethodBeat.o(196650);
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
    AppMethodBeat.i(196656);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196656);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196651);
    if (paramInt == 8)
    {
      this.BME = false;
      this.sRz.setShow(false);
    }
    AppMethodBeat.o(196651);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<ImageView>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.b<Boolean, z>
  {
    public c(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196641);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.BSc.sRz.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196641);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class e
    implements View.OnClickListener
  {
    public e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(196642);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if ((a.c(this.BSc) != a.e(this.BSc)) || (a.d(this.BSc) != a.f(this.BSc)))
      {
        paramView = a.a(this.BSc);
        if (paramView != null)
        {
          paramView = paramView.xNA;
          if (paramView != null)
          {
            paramView.xPF.a(null);
            paramView.xPF.yP(a.e(this.BSc));
            paramView.xPG.a(paramView.xPF);
            paramView.xPG.yP(a.f(this.BSc) - a.e(this.BSc));
          }
        }
      }
      for (;;)
      {
        paramView = a.a(this.BSc);
        if (paramView != null) {
          paramView.xNz = null;
        }
        a.b(this.BSc);
        this.BSc.sRz.setShow(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196642);
        return;
        paramView = a.a(this.BSc);
        if (paramView != null)
        {
          paramView = paramView.xNA;
          if (paramView != null) {
            paramView.af(a.e(this.BSc), a.f(this.BSc));
          }
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<Context>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<ImageView>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
  public static final class h
    implements TimeCropViewGroup.a
  {
    public final void f(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      d.c localc = null;
      AppMethodBeat.i(196645);
      Object localObject2 = new StringBuilder("onCropCallback: [").append(paramLong1).append(", ").append(paramLong2).append("], onUp:").append(paramBoolean).append(", showTime start:");
      Object localObject1 = a.a(this.BSc);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).xNA;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getStart());
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" end:");
          Object localObject3 = a.a(this.BSc);
          localObject1 = localc;
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).xNA;
            localObject1 = localc;
            if (localObject3 != null) {
              localObject1 = Long.valueOf(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getEnd());
            }
          }
          ad.i("MicroMsg.VLogTimeEditPlugin", localObject1);
          if (a.e(this.BSc) == paramLong1) {
            break label328;
          }
          a.a(this.BSc, paramLong1);
          a.b(this.BSc, paramLong2);
        }
      }
      for (paramLong1 = a.e(this.BSc);; paramLong1 = a.f(this.BSc))
      {
        localObject1 = a.a(this.BSc);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).xNz;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).af(a.e(this.BSc), a.f(this.BSc));
          }
        }
        localObject1 = this.BSc.sQE;
        localc = d.c.xFF;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", a.e(this.BSc));
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", a.f(this.BSc));
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_SEEKTIME_LONG", paramLong1);
        ((Bundle)localObject2).putBoolean("EDIT_CROP_VLOG_ON_UP_BOOLEAN", paramBoolean);
        ((com.tencent.mm.plugin.recordvideo.plugin.parent.d)localObject1).a(localc, (Bundle)localObject2);
        AppMethodBeat.o(196645);
        return;
        localObject1 = null;
        break;
        label328:
        a.a(this.BSc, paramLong1);
        a.b(this.BSc, paramLong2);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<ViewGroup>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.a
 * JD-Core Version:    0.7.0.1
 */