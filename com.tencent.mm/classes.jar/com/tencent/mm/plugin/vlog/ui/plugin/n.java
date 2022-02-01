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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "editIndex", "", "getEditIndex", "()I", "setEditIndex", "(I)V", "editTransitionPlugin", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin;", "layout", "getLayout", "()Landroid/view/ViewGroup;", "layout$delegate", "Lkotlin/Lazy;", "getParent", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "attachEditTransitionPlugin", "", "plugin", "loadMenuLayout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "plugin-vlog_release"})
public final class n
  implements View.OnClickListener, t
{
  public int BXh;
  public com.tencent.mm.plugin.vlog.ui.plugin.transition.a Ccn;
  private final Context context;
  ViewGroup gsV;
  private final f tVp;
  private d tbP;
  
  public n(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191720);
    this.gsV = paramViewGroup;
    this.tbP = paramd;
    this.context = this.gsV.getContext();
    this.tVp = g.O((d.g.a.a)new a(this));
    this.BXh = -1;
    paramViewGroup = this.gsV.findViewById(2131308354);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_crop)");
    e((ViewGroup)paramViewGroup, 2131690382, 2131766961);
    paramViewGroup = this.gsV.findViewById(2131308356);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_emoji)");
    e((ViewGroup)paramViewGroup, 2131690482, 2131766966);
    paramViewGroup = this.gsV.findViewById(2131308360);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_text)");
    e((ViewGroup)paramViewGroup, 2131690486, 2131766972);
    paramViewGroup = this.gsV.findViewById(2131308359);
    p.g(paramViewGroup, "parent.findViewById(R.id.menu_speed)");
    e((ViewGroup)paramViewGroup, 2131691606, 2131766971);
    AppMethodBeat.o(191720);
  }
  
  private final void e(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191719);
    View localView = paramViewGroup.findViewById(2131305902);
    p.g(localView, "layout.findViewById<TextView>(R.id.title)");
    ((TextView)localView).setText((CharSequence)com.tencent.mm.cb.a.az(this.context, paramInt2));
    ((ImageView)paramViewGroup.findViewById(2131300874)).setImageDrawable(ao.k(this.context, paramInt1, -1));
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(191719);
  }
  
  public final void Uj(int paramInt)
  {
    this.BXh = paramInt;
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(191717);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
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
      AppMethodBeat.o(191717);
      return;
      paramView = null;
      break;
      label85:
      if (paramView.intValue() != 2131308354) {
        break label50;
      }
      paramView = this.tbP;
      localObject = d.c.xVw;
      Bundle localBundle = new Bundle();
      localBundle.putInt("EDIT_VLOG_SELECT_TRACK", this.BXh);
      paramView.a((d.c)localObject, localBundle);
      continue;
      label132:
      if (paramView.intValue() != 2131308356) {
        break label54;
      }
      d.b.a(this.tbP, d.c.xUv);
      continue;
      label154:
      if (paramView.intValue() != 2131308360) {
        break label58;
      }
      d.b.a(this.tbP, d.c.xUx);
      continue;
      label176:
      if (paramView.intValue() == 2131308359) {
        d.b.a(this.tbP, d.c.xVz);
      }
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191721);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191721);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191718);
    ViewGroup localViewGroup = (ViewGroup)this.tVp.getValue();
    p.g(localViewGroup, "layout");
    localViewGroup.setVisibility(paramInt);
    AppMethodBeat.o(191718);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.n
 * JD-Core Version:    0.7.0.1
 */