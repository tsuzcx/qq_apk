package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "editIndex", "", "getEditIndex", "()I", "setEditIndex", "(I)V", "editTransitionPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin;", "layout", "getLayout", "()Landroid/view/ViewGroup;", "layout$delegate", "Lkotlin/Lazy;", "getParent", "setParent", "(Landroid/view/ViewGroup;)V", "attachEditTransitionPlugin", "", "plugin", "loadMenuLayout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener
{
  private final j HKW;
  public int TZU;
  private com.tencent.mm.plugin.vlog.ui.plugin.transition.a UfI;
  private final Context context;
  ViewGroup parent;
  
  public p(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282353);
    this.parent = paramViewGroup;
    this.context = this.parent.getContext();
    this.HKW = k.cm((kotlin.g.a.a)new a(this));
    this.TZU = -1;
    paramViewGroup = this.parent.findViewById(a.f.menu_crop);
    s.s(paramViewGroup, "parent.findViewById(R.id.menu_crop)");
    f((ViewGroup)paramViewGroup, a.h.icons_filled_crop, a.i.finder_edit_menu_crop);
    paramViewGroup = this.parent.findViewById(a.f.menu_emoji);
    s.s(paramViewGroup, "parent.findViewById(R.id.menu_emoji)");
    f((ViewGroup)paramViewGroup, a.h.icons_filled_sticker, a.i.finder_edit_menu_emoji);
    paramViewGroup = this.parent.findViewById(a.f.menu_text);
    s.s(paramViewGroup, "parent.findViewById(R.id.menu_text)");
    f((ViewGroup)paramViewGroup, a.h.icons_filled_text, a.i.finder_edit_menu_text);
    paramViewGroup = this.parent.findViewById(a.f.menu_speed);
    s.s(paramViewGroup, "parent.findViewById(R.id.menu_speed)");
    f((ViewGroup)paramViewGroup, a.h.icons_outline_change_speed, a.i.finder_edit_menu_speed);
    AppMethodBeat.o(282353);
  }
  
  private final void f(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(282361);
    ((TextView)paramViewGroup.findViewById(a.f.title)).setText((CharSequence)com.tencent.mm.cd.a.bt(this.context, paramInt2));
    ((ImageView)paramViewGroup.findViewById(a.f.icon)).setImageDrawable(bb.m(this.context, paramInt1, -1));
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(282361);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.ui.plugin.transition.a parama)
  {
    AppMethodBeat.i(282369);
    s.u(parama, "plugin");
    this.UfI = parama;
    AppMethodBeat.o(282369);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(282379);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.menu_crop;
      if (paramView != null) {
        break label101;
      }
      label48:
      i = a.f.menu_emoji;
      if (paramView != null) {
        break label156;
      }
      label56:
      i = a.f.menu_text;
      if (paramView != null) {
        break label177;
      }
      label64:
      i = a.f.menu_speed;
      if (paramView != null) {
        break label198;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282379);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label101:
      if (paramView.intValue() != i) {
        break label48;
      }
      paramView = this.GrC;
      localObject = a.c.NPB;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_VLOG_SELECT_TRACK", this.TZU);
      ah localah = ah.aiuX;
      paramView.a((a.c)localObject, localBundle);
      continue;
      label156:
      if (paramView.intValue() != i) {
        break label56;
      }
      a.b.a(this.GrC, a.c.NOq);
      continue;
      label177:
      if (paramView.intValue() != i) {
        break label64;
      }
      a.b.a(this.GrC, a.c.NOs);
      continue;
      label198:
      if (paramView.intValue() == i) {
        a.b.a(this.GrC, a.c.NPE);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282399);
    super.reset();
    this.TZU = -1;
    setVisibility(4);
    AppMethodBeat.o(282399);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282390);
    super.setVisibility(paramInt);
    ((ViewGroup)this.HKW.getValue()).setVisibility(paramInt);
    AppMethodBeat.o(282390);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    a(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.p
 * JD-Core Version:    0.7.0.1
 */