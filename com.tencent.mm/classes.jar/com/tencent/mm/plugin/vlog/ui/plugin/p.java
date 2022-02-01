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
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.ui.au;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "editIndex", "", "getEditIndex", "()I", "setEditIndex", "(I)V", "editTransitionPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin;", "layout", "getLayout", "()Landroid/view/ViewGroup;", "layout$delegate", "Lkotlin/Lazy;", "getParent", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "attachEditTransitionPlugin", "", "plugin", "loadMenuLayout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "reset", "setVisibility", "visibility", "plugin-vlog_release"})
public final class p
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener
{
  private d APl;
  private final f BYT;
  public int Nmo;
  private com.tencent.mm.plugin.vlog.ui.plugin.transition.a NrZ;
  private final Context context;
  ViewGroup parent;
  
  public p(ViewGroup paramViewGroup, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(225318);
    this.parent = paramViewGroup;
    this.APl = paramd;
    this.context = this.parent.getContext();
    this.BYT = g.ar((kotlin.g.a.a)new a(this));
    this.Nmo = -1;
    paramViewGroup = this.parent.findViewById(a.f.menu_crop);
    kotlin.g.b.p.j(paramViewGroup, "parent.findViewById(R.id.menu_crop)");
    e((ViewGroup)paramViewGroup, a.h.icons_filled_crop, a.i.finder_edit_menu_crop);
    paramViewGroup = this.parent.findViewById(a.f.menu_emoji);
    kotlin.g.b.p.j(paramViewGroup, "parent.findViewById(R.id.menu_emoji)");
    e((ViewGroup)paramViewGroup, a.h.icons_filled_sticker, a.i.finder_edit_menu_emoji);
    paramViewGroup = this.parent.findViewById(a.f.menu_text);
    kotlin.g.b.p.j(paramViewGroup, "parent.findViewById(R.id.menu_text)");
    e((ViewGroup)paramViewGroup, a.h.icons_filled_text, a.i.finder_edit_menu_text);
    paramViewGroup = this.parent.findViewById(a.f.menu_speed);
    kotlin.g.b.p.j(paramViewGroup, "parent.findViewById(R.id.menu_speed)");
    e((ViewGroup)paramViewGroup, a.h.icons_outline_change_speed, a.i.finder_edit_menu_speed);
    AppMethodBeat.o(225318);
  }
  
  private final void e(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225305);
    View localView = paramViewGroup.findViewById(a.f.title);
    kotlin.g.b.p.j(localView, "layout.findViewById<TextView>(R.id.title)");
    ((TextView)localView).setText((CharSequence)com.tencent.mm.ci.a.ba(this.context, paramInt2));
    ((ImageView)paramViewGroup.findViewById(a.f.icon)).setImageDrawable(au.o(this.context, paramInt1, -1));
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(225305);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.ui.plugin.transition.a parama)
  {
    AppMethodBeat.i(225295);
    kotlin.g.b.p.k(parama, "plugin");
    this.NrZ = parama;
    AppMethodBeat.o(225295);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(225300);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.menu_crop;
      if (paramView != null) {
        break label101;
      }
      label54:
      i = a.f.menu_emoji;
      if (paramView != null) {
        break label151;
      }
      label62:
      i = a.f.menu_text;
      if (paramView != null) {
        break label172;
      }
      label70:
      i = a.f.menu_speed;
      if (paramView != null) {
        break label193;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(225300);
      return;
      paramView = null;
      break;
      label101:
      if (paramView.intValue() != i) {
        break label54;
      }
      paramView = this.APl;
      localObject = d.c.HSV;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_VLOG_SELECT_TRACK", this.Nmo);
      paramView.a((d.c)localObject, localBundle);
      continue;
      label151:
      if (paramView.intValue() != i) {
        break label62;
      }
      d.b.a(this.APl, d.c.HRK);
      continue;
      label172:
      if (paramView.intValue() != i) {
        break label70;
      }
      d.b.a(this.APl, d.c.HRM);
      continue;
      label193:
      if (paramView.intValue() == i) {
        d.b.a(this.APl, d.c.HSY);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(225308);
    super.reset();
    this.Nmo = -1;
    setVisibility(4);
    AppMethodBeat.o(225308);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(225301);
    super.setVisibility(paramInt);
    ViewGroup localViewGroup = (ViewGroup)this.BYT.getValue();
    kotlin.g.b.p.j(localViewGroup, "layout");
    localViewGroup.setVisibility(paramInt);
    AppMethodBeat.o(225301);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    a(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.p
 * JD-Core Version:    0.7.0.1
 */