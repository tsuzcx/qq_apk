package com.tencent.mm.plugin.vlog.ui.timelineeditor;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.recordvideo.plugin.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.view.TimelineEditorDragRectView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "alwaysCropMode", "", "getAlwaysCropMode", "()Z", "setAlwaysCropMode", "(Z)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "value", "Landroid/graphics/RectF;", "halfRect", "setHalfRect", "(Landroid/graphics/RectF;)V", "halfScreenHeader", "Landroid/view/View;", "halfScreenRectView", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/view/TimelineEditorDragRectView;", "halfScreenSelectBtn", "validRect", "setValidRect", "getFirstMediaRatio", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getHalfRectF", "getValidRectF", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "onBackPress", "onClick", "view", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener
{
  public static final e.a Uqx;
  private final View UiO;
  private final View UiP;
  public final TimelineEditorDragRectView Uqy;
  public RectF Uqz;
  public final Context context;
  public RectF ymw;
  
  static
  {
    AppMethodBeat.i(282290);
    Uqx = new e.a((byte)0);
    AppMethodBeat.o(282290);
  }
  
  public e(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282260);
    View localView = paramViewGroup.findViewById(a.f.half_screen_select_btn);
    s.s(localView, "parent.findViewById(R.id.half_screen_select_btn)");
    this.UiO = localView;
    localView = paramViewGroup.findViewById(a.f.crop_ope_layout);
    s.s(localView, "parent.findViewById(R.id.crop_ope_layout)");
    this.Uqy = ((TimelineEditorDragRectView)localView);
    this.context = paramViewGroup.getContext();
    paramViewGroup = paramViewGroup.findViewById(a.f.half_screen_header);
    s.s(paramViewGroup, "parent.findViewById(R.id.half_screen_header)");
    this.UiP = paramViewGroup;
    this.ymw = new RectF(0.0F, 0.0F, com.tencent.mm.cd.a.ms(this.context) * 1.0F, com.tencent.mm.cd.a.mt(this.context) * 1.0F);
    this.Uqz = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.UiO.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.Uqy.findViewById(a.f.timeline_editor_crop_rect_close);
    s.s(paramViewGroup, "halfScreenRectView.findV…e_editor_crop_rect_close)");
    new g((ImageView)paramViewGroup, parama).aTb("HalfScreenBack");
    this.Uqy.findViewById(a.f.editor_mix_fullscreen).setOnClickListener(new e..ExternalSyntheticLambda1(this));
    this.UiP.setOnClickListener(new e..ExternalSyntheticLambda0(parama));
    boolean bool = ((cn)com.tencent.mm.kernel.h.az(cn.class)).isDisablePostHalfScreen();
    s.X("enableSetHalfPosition:", Boolean.valueOf(bool));
    com.tencent.e.f.h.jXD();
    if (!bool) {
      this.UiO.setVisibility(8);
    }
    AppMethodBeat.o(282260);
  }
  
  private static final void a(e parame, View paramView)
  {
    AppMethodBeat.i(282271);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    com.tencent.e.f.h.jXD();
    parame.onBackPress();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282271);
  }
  
  private static final void b(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, View paramView)
  {
    AppMethodBeat.i(282280);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$status");
    a.b.a(parama, a.c.NQo);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282280);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(282312);
    if ((this.Uqy.getVisibility() == 0) && (this.UiP.getVisibility() == 0))
    {
      this.Uqy.setVisibility(4);
      this.UiO.setVisibility(0);
      a.b.a(this.GrC, a.c.NQe);
      AppMethodBeat.o(282312);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(282312);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(282321);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.half_screen_select_btn;
      if (paramView != null) {
        break label79;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/timelineeditor/TimelineEditorHalfScreenPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282321);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label79:
      if (paramView.intValue() == i)
      {
        a.b.a(this.GrC, a.c.NQd);
        this.UiO.setVisibility(4);
        this.Uqy.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.e
 * JD-Core Version:    0.7.0.1
 */