package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.ui.ar;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "editIndex", "", "getEditIndex", "()I", "setEditIndex", "(I)V", "editTransitionPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin;", "layout", "getLayout", "()Landroid/view/ViewGroup;", "layout$delegate", "Lkotlin/Lazy;", "getParent", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "attachEditTransitionPlugin", "", "plugin", "loadMenuLayout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "plugin-vlog_release"})
public final class q
  implements View.OnClickListener, t
{
  private com.tencent.mm.plugin.vlog.ui.plugin.transition.a GEi;
  public int GyM;
  private final Context context;
  ViewGroup parent;
  private d wgr;
  private final f xmB;
  
  public q(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191345);
    this.parent = paramViewGroup;
    this.wgr = paramd;
    this.context = this.parent.getContext();
    this.xmB = g.ah((kotlin.g.a.a)new a(this));
    this.GyM = -1;
    paramViewGroup = this.parent.findViewById(2131304608);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_crop)");
    e((ViewGroup)paramViewGroup, 2131690526, 2131759676);
    paramViewGroup = this.parent.findViewById(2131304613);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_emoji)");
    e((ViewGroup)paramViewGroup, 2131690683, 2131759678);
    paramViewGroup = this.parent.findViewById(2131304635);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_text)");
    e((ViewGroup)paramViewGroup, 2131690690, 2131759680);
    paramViewGroup = this.parent.findViewById(2131304634);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_speed)");
    e((ViewGroup)paramViewGroup, 2131690723, 2131759679);
    AppMethodBeat.o(191345);
  }
  
  private final void e(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191344);
    View localView = paramViewGroup.findViewById(2131309195);
    p.g(localView, "layout.findViewById<TextView>(R.id.title)");
    ((TextView)localView).setText((CharSequence)com.tencent.mm.cb.a.aI(this.context, paramInt2));
    ((ImageView)paramViewGroup.findViewById(2131302468)).setImageDrawable(ar.m(this.context, paramInt1, -1));
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(191344);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.ui.plugin.transition.a parama)
  {
    AppMethodBeat.i(191341);
    p.h(parama, "plugin");
    this.GEi = parama;
    AppMethodBeat.o(191341);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(191342);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label85;
      }
      label50:
      if (paramView != null) {
        break label132;
      }
      label54:
      if (paramView != null) {
        break label154;
      }
      label58:
      if (paramView != null) {
        break label176;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191342);
      return;
      paramView = null;
      break;
      label85:
      if (paramView.intValue() != 2131304608) {
        break label50;
      }
      paramView = this.wgr;
      localObject = d.c.BWg;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_VLOG_SELECT_TRACK", this.GyM);
      paramView.a((d.c)localObject, localBundle);
      continue;
      label132:
      if (paramView.intValue() != 2131304613) {
        break label54;
      }
      d.b.a(this.wgr, d.c.BUX);
      continue;
      label154:
      if (paramView.intValue() != 2131304635) {
        break label58;
      }
      d.b.a(this.wgr, d.c.BUZ);
      continue;
      label176:
      if (paramView.intValue() == 2131304634) {
        d.b.a(this.wgr, d.c.BWj);
      }
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191346);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191346);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191343);
    ViewGroup localViewGroup = (ViewGroup)this.xmB.getValue();
    p.g(localViewGroup, "layout");
    localViewGroup.setVisibility(paramInt);
    AppMethodBeat.o(191343);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ViewGroup>
  {
    a(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.q
 * JD-Core Version:    0.7.0.1
 */