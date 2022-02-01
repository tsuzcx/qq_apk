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
import com.tencent.mm.ui.ao;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "editIndex", "", "getEditIndex", "()I", "setEditIndex", "(I)V", "editTransitionPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin;", "layout", "getLayout", "()Landroid/view/ViewGroup;", "layout$delegate", "Lkotlin/Lazy;", "getParent", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "attachEditTransitionPlugin", "", "plugin", "loadMenuLayout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "plugin-vlog_release"})
public final class n
  implements View.OnClickListener, t
{
  public int BFJ;
  public com.tencent.mm.plugin.vlog.ui.plugin.transition.a BKO;
  private final Context context;
  ViewGroup gqv;
  private d sQE;
  private final f tKy;
  
  public n(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(196261);
    this.gqv = paramViewGroup;
    this.sQE = paramd;
    this.context = this.gqv.getContext();
    this.tKy = g.O((d.g.a.a)new a(this));
    this.BFJ = -1;
    paramViewGroup = this.gqv.findViewById(2131308354);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_crop)");
    e((ViewGroup)paramViewGroup, 2131690382, 2131766961);
    paramViewGroup = this.gqv.findViewById(2131308356);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_emoji)");
    e((ViewGroup)paramViewGroup, 2131690482, 2131766966);
    paramViewGroup = this.gqv.findViewById(2131308360);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_text)");
    e((ViewGroup)paramViewGroup, 2131690486, 2131766972);
    paramViewGroup = this.gqv.findViewById(2131308359);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_speed)");
    e((ViewGroup)paramViewGroup, 2131691606, 2131766971);
    AppMethodBeat.o(196261);
  }
  
  private final void e(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196260);
    View localView = paramViewGroup.findViewById(2131305902);
    p.g(localView, "layout.findViewById<TextView>(R.id.title)");
    ((TextView)localView).setText((CharSequence)com.tencent.mm.cc.a.az(this.context, paramInt2));
    ((ImageView)paramViewGroup.findViewById(2131300874)).setImageDrawable(ao.k(this.context, paramInt1, -1));
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(196260);
  }
  
  public final void TC(int paramInt)
  {
    this.BFJ = paramInt;
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196258);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
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
      AppMethodBeat.o(196258);
      return;
      paramView = null;
      break;
      label85:
      if (paramView.intValue() != 2131308354) {
        break label50;
      }
      paramView = this.sQE;
      localObject = d.c.xFB;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_VLOG_SELECT_TRACK", this.BFJ);
      paramView.a((d.c)localObject, localBundle);
      continue;
      label132:
      if (paramView.intValue() != 2131308356) {
        break label54;
      }
      d.b.a(this.sQE, d.c.xEA);
      continue;
      label154:
      if (paramView.intValue() != 2131308360) {
        break label58;
      }
      d.b.a(this.sQE, d.c.xEC);
      continue;
      label176:
      if (paramView.intValue() == 2131308359) {
        d.b.a(this.sQE, d.c.xFE);
      }
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196262);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196262);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196259);
    ViewGroup localViewGroup = (ViewGroup)this.tKy.getValue();
    p.g(localViewGroup, "layout");
    localViewGroup.setVisibility(paramInt);
    AppMethodBeat.o(196259);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<ViewGroup>
  {
    a(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.n
 * JD-Core Version:    0.7.0.1
 */