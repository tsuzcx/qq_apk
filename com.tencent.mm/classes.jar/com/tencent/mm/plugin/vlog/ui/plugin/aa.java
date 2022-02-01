package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.b;
import com.google.android.material.tabs.TabLayout.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateNormalModeSelectPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "containerLayout", "Lcom/tencent/mm/ui/widget/InsectRelativeLayout;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "isInTemplateMode", "", "selectNormalMode", "", "selectTemplateMode", "setShowContainer", "show", "setVisibility", "visibility", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final aa.a Ujw;
  private final InsectRelativeLayout Ujx;
  private ViewGroup parent;
  private final TabLayout yaj;
  
  static
  {
    AppMethodBeat.i(282681);
    Ujw = new aa.a((byte)0);
    AppMethodBeat.o(282681);
  }
  
  public aa(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282676);
    this.parent = paramViewGroup;
    paramViewGroup = this.parent.findViewById(a.f.template_normal_mode_switch_container);
    s.s(paramViewGroup, "parent.findViewById(R.id…al_mode_switch_container)");
    this.Ujx = ((InsectRelativeLayout)paramViewGroup);
    paramViewGroup = this.parent.findViewById(a.f.template_normal_mode_switcher);
    s.s(paramViewGroup, "parent.findViewById(R.id…ate_normal_mode_switcher)");
    this.yaj = ((TabLayout)paramViewGroup);
    Log.i("MicroMsg.TemplateNormalModeSelectPlugin", s.X("init tabLayout.tabCount:", Integer.valueOf(this.yaj.getTabCount())));
    this.Ujx.setDiscardKeyboard(true);
    int k = this.yaj.getTabCount() - 1;
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      paramViewGroup = this.yaj.getChildAt(0);
      if (paramViewGroup == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(282676);
        throw paramViewGroup;
      }
      paramViewGroup = ((ViewGroup)paramViewGroup).getChildAt(i);
      Object localObject = paramViewGroup.getLayoutParams();
      if (localObject == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(282676);
        throw paramViewGroup;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(com.tencent.mm.cd.a.br(this.parent.getContext(), a.d.Edge_4A));
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (j >= k)
      {
        this.yaj.a((TabLayout.b)new com.google.android.material.tabs.a()
        {
          public final void i(TabLayout.e paramAnonymouse)
          {
            AppMethodBeat.i(282820);
            if (paramAnonymouse != null)
            {
              com.tencent.mm.plugin.recordvideo.plugin.parent.a locala = this.NJL;
              if (paramAnonymouse.position == 1)
              {
                Log.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect template mode");
                a.b.a(locala, a.c.NQj);
                AppMethodBeat.o(282820);
                return;
              }
              if (paramAnonymouse.position == 0)
              {
                Log.i("MicroMsg.TemplateNormalModeSelectPlugin", "onSelect normal mode");
                a.b.a(locala, a.c.NQk);
              }
            }
            AppMethodBeat.o(282820);
          }
          
          public final void j(TabLayout.e paramAnonymouse) {}
          
          public final void k(TabLayout.e paramAnonymouse) {}
        });
        FV(false);
        AppMethodBeat.o(282676);
        return;
      }
    }
  }
  
  public final void FV(boolean paramBoolean)
  {
    AppMethodBeat.i(282706);
    InsectRelativeLayout localInsectRelativeLayout = this.Ujx;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localInsectRelativeLayout.setVisibility(i);
      AppMethodBeat.o(282706);
      return;
    }
  }
  
  public final void hTB()
  {
    AppMethodBeat.i(282691);
    TabLayout.e locale = this.yaj.js(1);
    if (locale != null) {
      locale.Xf();
    }
    a.b.a(this.GrC, a.c.NQj);
    AppMethodBeat.o(282691);
  }
  
  public final boolean hTC()
  {
    AppMethodBeat.i(282697);
    if (this.yaj.getSelectedTabPosition() == 1)
    {
      AppMethodBeat.o(282697);
      return true;
    }
    AppMethodBeat.o(282697);
    return false;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282714);
    this.yaj.setVisibility(paramInt);
    AppMethodBeat.o(282714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.aa
 * JD-Core Version:    0.7.0.1
 */