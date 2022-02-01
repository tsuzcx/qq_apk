package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateNormalModeSelectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "containerLayout", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "isInTemplateMode", "", "selectNormalMode", "", "selectTemplateMode", "setShowContainer", "show", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"})
public final class ab
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final a Nwl;
  d APl;
  private final TabLayout BoG;
  private final InsectRelativeLayout Nwk;
  private ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(242286);
    Nwl = new a((byte)0);
    AppMethodBeat.o(242286);
  }
  
  public ab(ViewGroup paramViewGroup, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(242285);
    this.parent = paramViewGroup;
    this.APl = paramd;
    paramViewGroup = this.parent.findViewById(a.f.template_normal_mode_switch_container);
    p.j(paramViewGroup, "parent.findViewById(R.id…al_mode_switch_container)");
    this.Nwk = ((InsectRelativeLayout)paramViewGroup);
    paramViewGroup = this.parent.findViewById(a.f.template_normal_mode_switcher);
    p.j(paramViewGroup, "parent.findViewById(R.id…ate_normal_mode_switcher)");
    this.BoG = ((TabLayout)paramViewGroup);
    Log.i("MicroMsg.TemplateNormalModeSelectPlugin", "init tabLayout.tabCount:" + this.BoG.getTabCount());
    this.Nwk.setDiscardKeyboard(true);
    int j = this.BoG.getTabCount();
    int i = 0;
    while (i < j - 1)
    {
      paramViewGroup = this.BoG.getChildAt(0);
      if (paramViewGroup == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(242285);
        throw paramViewGroup;
      }
      paramViewGroup = ((ViewGroup)paramViewGroup).getChildAt(i);
      p.j(paramViewGroup, "tab");
      paramd = paramViewGroup.getLayoutParams();
      if (paramd == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(242285);
        throw paramViewGroup;
      }
      paramd = (ViewGroup.MarginLayoutParams)paramd;
      paramd.setMarginEnd(com.tencent.mm.ci.a.aY(this.parent.getContext(), a.d.Edge_4A));
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)paramd);
      i += 1;
    }
    this.BoG.a((TabLayout.b)new com.google.android.material.tabs.a()
    {
      public final void i(TabLayout.e paramAnonymouse)
      {
        AppMethodBeat.i(226877);
        if (paramAnonymouse != null)
        {
          if (paramAnonymouse.getPosition() == 1)
          {
            Log.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect template mode");
            d.b.a(this.Nwm.APl, d.c.HTD);
            AppMethodBeat.o(226877);
            return;
          }
          if (paramAnonymouse.getPosition() == 0)
          {
            Log.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect normal mode");
            d.b.a(this.Nwm.APl, d.c.HTE);
          }
          AppMethodBeat.o(226877);
          return;
        }
        AppMethodBeat.o(226877);
      }
      
      public final void j(TabLayout.e paramAnonymouse) {}
      
      public final void k(TabLayout.e paramAnonymouse) {}
    });
    Aw(false);
    AppMethodBeat.o(242285);
  }
  
  public final void Aw(boolean paramBoolean)
  {
    AppMethodBeat.i(242283);
    InsectRelativeLayout localInsectRelativeLayout = this.Nwk;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localInsectRelativeLayout.setVisibility(i);
      AppMethodBeat.o(242283);
      return;
    }
  }
  
  public final boolean gvM()
  {
    AppMethodBeat.i(242281);
    if (this.BoG.getSelectedTabPosition() == 1)
    {
      AppMethodBeat.o(242281);
      return true;
    }
    AppMethodBeat.o(242281);
    return false;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(242284);
    this.BoG.setVisibility(paramInt);
    AppMethodBeat.o(242284);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateNormalModeSelectPlugin$Companion;", "", "()V", "NormalPos", "", "TAG", "", "TemplatePos", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ab
 * JD-Core Version:    0.7.0.1
 */