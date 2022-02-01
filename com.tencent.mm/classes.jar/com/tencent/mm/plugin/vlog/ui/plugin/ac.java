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
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateNormalModeSelectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "containerLayout", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "tabLayout", "Landroid/support/design/widget/TabLayout;", "isInTemplateMode", "", "selectNormalMode", "", "selectTemplateMode", "setShowContainer", "show", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"})
public final class ac
  implements com.tencent.mm.plugin.recordvideo.plugin.t
{
  public static final ac.a GIx;
  private final InsectRelativeLayout GIw;
  private ViewGroup parent;
  private final TabLayout wAv;
  d wgr;
  
  static
  {
    AppMethodBeat.i(191475);
    GIx = new ac.a((byte)0);
    AppMethodBeat.o(191475);
  }
  
  public ac(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191474);
    this.parent = paramViewGroup;
    this.wgr = paramd;
    paramViewGroup = this.parent.findViewById(2131308942);
    p.g(paramViewGroup, "parent.findViewById(R.id…al_mode_switch_container)");
    this.GIw = ((InsectRelativeLayout)paramViewGroup);
    paramViewGroup = this.parent.findViewById(2131308943);
    p.g(paramViewGroup, "parent.findViewById(R.id…ate_normal_mode_switcher)");
    this.wAv = ((TabLayout)paramViewGroup);
    Log.i("MicroMsg.TemplateNormalModeSelectPlugin", "init tabLayout.tabCount:" + this.wAv.getTabCount());
    this.GIw.setDiscardKeyboard(true);
    int j = this.wAv.getTabCount();
    int i = 0;
    while (i < j - 1)
    {
      paramViewGroup = this.wAv.getChildAt(0);
      if (paramViewGroup == null)
      {
        paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(191474);
        throw paramViewGroup;
      }
      paramViewGroup = ((ViewGroup)paramViewGroup).getChildAt(i);
      p.g(paramViewGroup, "tab");
      paramd = paramViewGroup.getLayoutParams();
      if (paramd == null)
      {
        paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(191474);
        throw paramViewGroup;
      }
      paramd = (ViewGroup.MarginLayoutParams)paramd;
      paramd.setMarginEnd(a.aG(this.parent.getContext(), 2131165303));
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)paramd);
      i += 1;
    }
    this.wAv.a((TabLayout.b)new TabLayout.c()
    {
      public final void i(TabLayout.f paramAnonymousf)
      {
        AppMethodBeat.i(191470);
        if (paramAnonymousf != null)
        {
          if (paramAnonymousf.getPosition() == 1)
          {
            Log.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect template mode");
            d.b.a(this.GIy.wgr, d.c.BWR);
            AppMethodBeat.o(191470);
            return;
          }
          if (paramAnonymousf.getPosition() == 0)
          {
            Log.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect normal mode");
            d.b.a(this.GIy.wgr, d.c.BWS);
          }
          AppMethodBeat.o(191470);
          return;
        }
        AppMethodBeat.o(191470);
      }
      
      public final void j(TabLayout.f paramAnonymousf) {}
      
      public final void k(TabLayout.f paramAnonymousf) {}
    });
    wI(false);
    AppMethodBeat.o(191474);
  }
  
  public final void aSs() {}
  
  public final boolean fDO()
  {
    AppMethodBeat.i(191471);
    if (this.wAv.getSelectedTabPosition() == 1)
    {
      AppMethodBeat.o(191471);
      return true;
    }
    AppMethodBeat.o(191471);
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191476);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191476);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191473);
    this.wAv.setVisibility(paramInt);
    AppMethodBeat.o(191473);
  }
  
  public final void wI(boolean paramBoolean)
  {
    AppMethodBeat.i(191472);
    InsectRelativeLayout localInsectRelativeLayout = this.GIw;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localInsectRelativeLayout.setVisibility(i);
      AppMethodBeat.o(191472);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ac
 * JD-Core Version:    0.7.0.1
 */