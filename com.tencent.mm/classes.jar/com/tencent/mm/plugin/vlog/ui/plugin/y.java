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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateNormalModeSelectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "containerLayout", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "tabLayout", "Landroid/support/design/widget/TabLayout;", "isInTemplateMode", "", "selectNormalMode", "", "selectTemplateMode", "setShowContainer", "show", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"})
public final class y
  implements t
{
  public static final y.a BOg;
  private final InsectRelativeLayout BOe;
  public final TabLayout BOf;
  private ViewGroup gqv;
  public d sQE;
  
  static
  {
    AppMethodBeat.i(196348);
    BOg = new y.a((byte)0);
    AppMethodBeat.o(196348);
  }
  
  public y(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(196347);
    this.gqv = paramViewGroup;
    this.sQE = paramd;
    paramViewGroup = this.gqv.findViewById(2131308441);
    p.g(paramViewGroup, "parent.findViewById(R.id…al_mode_switch_container)");
    this.BOe = ((InsectRelativeLayout)paramViewGroup);
    paramViewGroup = this.gqv.findViewById(2131308442);
    p.g(paramViewGroup, "parent.findViewById(R.id…ate_normal_mode_switcher)");
    this.BOf = ((TabLayout)paramViewGroup);
    ad.i("MicroMsg.TemplateNormalModeSelectPlugin", "init tabLayout.tabCount:" + this.BOf.getTabCount());
    this.BOe.setDiscardKeyboard(true);
    int j = this.BOf.getTabCount();
    int i = 0;
    while (i < j - 1)
    {
      paramViewGroup = this.BOf.getChildAt(0);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(196347);
        throw paramViewGroup;
      }
      paramViewGroup = ((ViewGroup)paramViewGroup).getChildAt(i);
      p.g(paramViewGroup, "tab");
      paramd = paramViewGroup.getLayoutParams();
      if (paramd == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(196347);
        throw paramViewGroup;
      }
      paramd = (ViewGroup.MarginLayoutParams)paramd;
      paramd.setMarginEnd(a.ax(this.gqv.getContext(), 2131165294));
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)paramd);
      i += 1;
    }
    this.BOf.a((TabLayout.b)new TabLayout.c()
    {
      public final void f(TabLayout.f paramAnonymousf)
      {
        AppMethodBeat.i(196344);
        if (paramAnonymousf != null)
        {
          if (paramAnonymousf.getPosition() == 1)
          {
            ad.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect template mode");
            d.b.a(this.BOh.sQE, d.c.xGm);
            AppMethodBeat.o(196344);
            return;
          }
          if (paramAnonymousf.getPosition() == 0)
          {
            ad.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect normal mode");
            d.b.a(this.BOh.sQE, d.c.xGn);
          }
          AppMethodBeat.o(196344);
          return;
        }
        AppMethodBeat.o(196344);
      }
      
      public final void g(TabLayout.f paramAnonymousf) {}
      
      public final void h(TabLayout.f paramAnonymousf) {}
    });
    sV(false);
    AppMethodBeat.o(196347);
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
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196349);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196349);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void sV(boolean paramBoolean)
  {
    AppMethodBeat.i(196345);
    InsectRelativeLayout localInsectRelativeLayout = this.BOe;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localInsectRelativeLayout.setVisibility(i);
      AppMethodBeat.o(196345);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196346);
    this.BOf.setVisibility(paramInt);
    AppMethodBeat.o(196346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.y
 * JD-Core Version:    0.7.0.1
 */