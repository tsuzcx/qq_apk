package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.b;
import android.support.design.widget.TabLayout.c;
import android.support.design.widget.TabLayout.f;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateNormalModeSelectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "containerLayout", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "tabLayout", "Landroid/support/design/widget/TabLayout;", "isInTemplateMode", "", "selectNormalMode", "", "selectTemplateMode", "setShowContainer", "show", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"})
public final class y
  implements t
{
  public static final y.a CfF;
  private final InsectRelativeLayout CfD;
  public final TabLayout CfE;
  private ViewGroup gsV;
  public d tbP;
  
  static
  {
    AppMethodBeat.i(191807);
    CfF = new y.a((byte)0);
    AppMethodBeat.o(191807);
  }
  
  public y(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191806);
    this.gsV = paramViewGroup;
    this.tbP = paramd;
    paramViewGroup = this.gsV.findViewById(2131308441);
    p.g(paramViewGroup, "parent.findViewById(R.id…al_mode_switch_container)");
    this.CfD = ((InsectRelativeLayout)paramViewGroup);
    paramViewGroup = this.gsV.findViewById(2131308442);
    p.g(paramViewGroup, "parent.findViewById(R.id…ate_normal_mode_switcher)");
    this.CfE = ((TabLayout)paramViewGroup);
    ae.i("MicroMsg.TemplateNormalModeSelectPlugin", "init tabLayout.tabCount:" + this.CfE.getTabCount());
    this.CfD.setDiscardKeyboard(true);
    int j = this.CfE.getTabCount();
    int i = 0;
    while (i < j - 1)
    {
      paramViewGroup = this.CfE.getChildAt(0);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(191806);
        throw paramViewGroup;
      }
      paramViewGroup = ((ViewGroup)paramViewGroup).getChildAt(i);
      p.g(paramViewGroup, "tab");
      paramd = paramViewGroup.getLayoutParams();
      if (paramd == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(191806);
        throw paramViewGroup;
      }
      paramd = (ViewGroup.MarginLayoutParams)paramd;
      paramd.setMarginEnd(a.ax(this.gsV.getContext(), 2131165294));
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)paramd);
      i += 1;
    }
    this.CfE.a((TabLayout.b)new TabLayout.c()
    {
      public final void f(TabLayout.f paramAnonymousf)
      {
        AppMethodBeat.i(191803);
        if (paramAnonymousf != null)
        {
          if (paramAnonymousf.getPosition() == 1)
          {
            ae.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect template mode");
            d.b.a(this.CfG.tbP, d.c.xWh);
            AppMethodBeat.o(191803);
            return;
          }
          if (paramAnonymousf.getPosition() == 0)
          {
            ae.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect normal mode");
            d.b.a(this.CfG.tbP, d.c.xWi);
          }
          AppMethodBeat.o(191803);
          return;
        }
        AppMethodBeat.o(191803);
      }
      
      public final void g(TabLayout.f paramAnonymousf) {}
      
      public final void h(TabLayout.f paramAnonymousf) {}
    });
    tc(false);
    AppMethodBeat.o(191806);
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
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191808);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191808);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191805);
    this.CfE.setVisibility(paramInt);
    AppMethodBeat.o(191805);
  }
  
  public final void tc(boolean paramBoolean)
  {
    AppMethodBeat.i(191804);
    InsectRelativeLayout localInsectRelativeLayout = this.CfD;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localInsectRelativeLayout.setVisibility(i);
      AppMethodBeat.o(191804);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.y
 * JD-Core Version:    0.7.0.1
 */