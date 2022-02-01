package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.view.TimelineEditorDragRectView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "alwaysCropMode", "", "getAlwaysCropMode", "()Z", "setAlwaysCropMode", "(Z)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "value", "Landroid/graphics/RectF;", "halfRect", "setHalfRect", "(Landroid/graphics/RectF;)V", "halfScreenHeader", "Landroid/view/View;", "halfScreenRectView", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView;", "halfScreenSelectBtn", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "validRect", "setValidRect", "getFirstMediaRatio", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getHalfRectF", "getValidRectF", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "onBackPress", "onClick", "view", "Companion", "plugin-vlog_release"})
public final class e
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener
{
  public static final a NEd;
  d APl;
  public final TimelineEditorDragRectView NEb;
  public RectF NEc;
  private final View NvA;
  private final View Nvz;
  public final Context context;
  public RectF vav;
  
  static
  {
    AppMethodBeat.i(224465);
    NEd = new a((byte)0);
    AppMethodBeat.o(224465);
  }
  
  public e(ViewGroup paramViewGroup, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(224464);
    this.APl = paramd;
    paramd = paramViewGroup.findViewById(a.f.half_screen_select_btn);
    p.j(paramd, "parent.findViewById(R.id.half_screen_select_btn)");
    this.Nvz = paramd;
    paramd = paramViewGroup.findViewById(a.f.crop_ope_layout);
    p.j(paramd, "parent.findViewById(R.id.crop_ope_layout)");
    this.NEb = ((TimelineEditorDragRectView)paramd);
    this.context = paramViewGroup.getContext();
    paramViewGroup = paramViewGroup.findViewById(a.f.half_screen_header);
    p.j(paramViewGroup, "parent.findViewById(R.id.half_screen_header)");
    this.NvA = paramViewGroup;
    this.vav = new RectF(0.0F, 0.0F, com.tencent.mm.ci.a.kr(this.context) * 1.0F, com.tencent.mm.ci.a.ks(this.context) * 1.0F);
    this.NEc = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.Nvz.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.NEb.findViewById(a.f.timeline_editor_crop_rect_close);
    p.j(paramViewGroup, "halfScreenRectView.findV…e_editor_crop_rect_close)");
    new f((ImageView)paramViewGroup, this.APl).aVU("HalfScreenBack");
    this.NEb.findViewById(a.f.editor_mix_fullscreen).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(228130);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.d.f.h.ioq();
        this.NEe.onBackPress();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(228130);
      }
    });
    this.NvA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(230725);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        d.b.a(this.NEe.APl, d.c.HTI);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(230725);
      }
    });
    paramViewGroup = com.tencent.mm.kernel.h.ag(ak.class);
    p.j(paramViewGroup, "MMKernel.plugin(IPluginFinder::class.java)");
    boolean bool = ((ak)paramViewGroup).isDisablePostHalfScreen();
    "enableSetHalfPosition:".concat(String.valueOf(bool));
    com.tencent.d.f.h.ioq();
    if (!bool) {
      this.Nvz.setVisibility(8);
    }
    AppMethodBeat.o(224464);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(224447);
    if ((this.NEb.getVisibility() == 0) && (this.NvA.getVisibility() == 0))
    {
      this.NEb.setVisibility(4);
      this.Nvz.setVisibility(0);
      d.b.a(this.APl, d.c.HTy);
      AppMethodBeat.o(224447);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(224447);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(224451);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.half_screen_select_btn;
      if (paramView != null) {
        break label85;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(224451);
      return;
      paramView = null;
      break;
      label85:
      if (paramView.intValue() == i)
      {
        d.b.a(this.APl, d.c.HTx);
        this.Nvz.setVisibility(4);
        this.NEb.setVisibility(0);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.e
 * JD-Core Version:    0.7.0.1
 */