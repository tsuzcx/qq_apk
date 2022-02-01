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
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.ui.plugin.e.c;
import com.tencent.mm.plugin.vlog.ui.plugin.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.n;
import com.tencent.tav.coremedia.CMTimeRange;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelImg", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCancelImg", "()Landroid/widget/ImageView;", "cancelImg$delegate", "Lkotlin/Lazy;", "confirmed", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "cropEnd", "", "cropStart", "doneImg", "getDoneImg", "doneImg$delegate", "editTimeData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getHolder", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "inited", "onCropCallback", "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1;", "originEnd", "originStart", "panelRoot", "Landroid/view/ViewGroup;", "getPanelRoot", "()Landroid/view/ViewGroup;", "panelRoot$delegate", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "timeRangeEnd", "timeRangeStart", "trackCropView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "getTrackCropView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "trackCropView$delegate", "videoSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "checkInit", "", "onBackPress", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "setEditData", "data", "setEnableLengthEdit", "enable", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"})
public final class a
  implements t, e.c
{
  public static final a.a GMC;
  private e.e GGT;
  private final f GGj;
  private final f GGk;
  private boolean GGs;
  private long GHo;
  private long GHp;
  private long GHq;
  private long GHr;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.a GMA;
  private final h GMB;
  private final f GMw;
  private final f GMx;
  private long GMy;
  private long GMz;
  private boolean gKM;
  private final f tMy;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  final EditorPanelHolder wji;
  
  static
  {
    AppMethodBeat.i(191844);
    GMC = new a.a((byte)0);
    AppMethodBeat.o(191844);
  }
  
  public a(EditorPanelHolder paramEditorPanelHolder, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(191843);
    this.wji = paramEditorPanelHolder;
    this.wgr = paramd;
    this.tMy = g.ah((kotlin.g.a.a)new f(this));
    this.GGj = g.ah((kotlin.g.a.a)new i(this));
    this.GGk = g.ah((kotlin.g.a.a)new j(this));
    this.GMw = g.ah((kotlin.g.a.a)new b(this));
    this.GMx = g.ah((kotlin.g.a.a)new g(this));
    this.GMB = new h(this);
    AppMethodBeat.o(191843);
  }
  
  private final void aTL()
  {
    AppMethodBeat.i(191837);
    if (this.gKM)
    {
      AppMethodBeat.o(191837);
      return;
    }
    this.gKM = true;
    this.wji.setCloseTouchOutside(true);
    fDn().setCallback((TimeCropViewGroup.a)this.GMB);
    fDn().setRealTimeCallback((TimeCropViewGroup.a)this.GMB);
    this.wji.setOnVisibleChangeCallback((kotlin.g.a.b)new c(this));
    ((ImageView)this.GMw.getValue()).setOnClickListener((View.OnClickListener)new d(this));
    ((ImageView)this.GMx.getValue()).setOnClickListener((View.OnClickListener)new e(this));
    AppMethodBeat.o(191837);
  }
  
  private final TimeCropViewGroup fDn()
  {
    AppMethodBeat.i(191836);
    TimeCropViewGroup localTimeCropViewGroup = (TimeCropViewGroup)this.GGk.getValue();
    AppMethodBeat.o(191836);
    return localTimeCropViewGroup;
  }
  
  public final void a(e.e parame)
  {
    this.GGT = parame;
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(191840);
    if (this.wji.bJw())
    {
      this.GGs = false;
      this.wji.setShow(false);
      AppMethodBeat.o(191840);
      return true;
    }
    AppMethodBeat.o(191840);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onProgress(long paramLong)
  {
    AppMethodBeat.i(191842);
    fDn().setProgress(paramLong);
    AppMethodBeat.o(191842);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191845);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191845);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(191838);
    fDn().setEnableLengthEdit(paramBoolean);
    AppMethodBeat.o(191838);
  }
  
  public final void setTrack(ac paramac)
  {
    AppMethodBeat.i(191841);
    p.h(paramac, "composition");
    Object localObject1 = this.GMA;
    if (localObject1 != null)
    {
      this.GGs = false;
      aTL();
      this.GHo = (paramac.Gez.hfo().getStartUs() / 1000L);
      this.GHp = (paramac.Gez.hfo().getEndUs() / 1000L);
      if (((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cev.Cgy.getTime() > this.GHp)
      {
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cev.Cgy;
        ((c)localObject2).Il(((c)localObject2).offset + (this.GHp - ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cev.Cgy.getTime()));
      }
      this.GHq = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cev.Cgx.getTime();
      this.GHr = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cev.Cgy.getTime();
      this.GMy = this.GHq;
      this.GMz = this.GHr;
      Object localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(0L, false, 3);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject2).ai(this.GMy, this.GMz);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ceu = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject2);
      Log.i("MicroMsg.VLogTimeEditPlugin", "time range:" + ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cev);
      localObject1 = fDn();
      localObject2 = this.GMA;
      if (localObject2 == null) {
        p.hyc();
      }
      long l = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).Cev.getStart();
      localObject2 = this.GMA;
      if (localObject2 == null) {
        p.hyc();
      }
      ((TimeCropViewGroup)localObject1).a(paramac, l, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).Cev.getEnd());
      this.wji.setShow(true);
      AppMethodBeat.o(191841);
      return;
    }
    AppMethodBeat.o(191841);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191839);
    if (paramInt == 8)
    {
      this.GGs = false;
      this.wji.setShow(false);
    }
    AppMethodBeat.o(191839);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191827);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.GMD.wji.setShow(false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191827);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(191828);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if ((a.c(this.GMD) != a.e(this.GMD)) || (a.d(this.GMD) != a.f(this.GMD)))
      {
        paramView = a.a(this.GMD);
        if (paramView != null)
        {
          paramView = paramView.Cev;
          if (paramView != null)
          {
            paramView.Cgx.a(null);
            paramView.Cgx.Il(a.e(this.GMD));
            paramView.Cgy.a(paramView.Cgx);
            paramView.Cgy.Il(a.f(this.GMD) - a.e(this.GMD));
          }
        }
      }
      for (;;)
      {
        paramView = a.a(this.GMD);
        if (paramView != null) {
          paramView.Ceu = null;
        }
        a.b(this.GMD);
        this.GMD.wji.setShow(false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$checkInit$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191828);
        return;
        paramView = a.a(this.GMD);
        if (paramView != null)
        {
          paramView = paramView.Cev;
          if (paramView != null) {
            paramView.ai(a.e(this.GMD), a.f(this.GMD));
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<Context>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/VLogTimeEditPlugin$onCropCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
  public static final class h
    implements TimeCropViewGroup.a
  {
    public final void d(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      d.c localc = null;
      AppMethodBeat.i(191831);
      Object localObject2 = new StringBuilder("onCropCallback: [").append(paramLong1).append(", ").append(paramLong2).append("], onUp:").append(paramBoolean).append(", showTime start:");
      Object localObject1 = a.a(this.GMD);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cev;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getStart());
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" end:");
          Object localObject3 = a.a(this.GMD);
          localObject1 = localc;
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject3).Cev;
            localObject1 = localc;
            if (localObject3 != null) {
              localObject1 = Long.valueOf(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getEnd());
            }
          }
          Log.i("MicroMsg.VLogTimeEditPlugin", localObject1);
          if (a.e(this.GMD) == paramLong1) {
            break label328;
          }
          a.a(this.GMD, paramLong1);
          a.b(this.GMD, paramLong2);
        }
      }
      for (paramLong1 = a.e(this.GMD);; paramLong1 = a.f(this.GMD))
      {
        localObject1 = a.a(this.GMD);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ceu;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).ai(a.e(this.GMD), a.f(this.GMD));
          }
        }
        localObject1 = this.GMD.wgr;
        localc = d.c.BWk;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_LENGTH_START_TIME_LONG", a.e(this.GMD));
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_LENGTH_END_TIME_LONG", a.f(this.GMD));
        ((Bundle)localObject2).putLong("EDIT_CROP_VLOG_SEEKTIME_LONG", paramLong1);
        ((Bundle)localObject2).putBoolean("EDIT_CROP_VLOG_ON_UP_BOOLEAN", paramBoolean);
        ((com.tencent.mm.plugin.recordvideo.plugin.parent.d)localObject1).a(localc, (Bundle)localObject2);
        AppMethodBeat.o(191831);
        return;
        localObject1 = null;
        break;
        label328:
        a.a(this.GMD, paramLong1);
        a.b(this.GMD, paramLong2);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.a
 * JD-Core Version:    0.7.0.1
 */