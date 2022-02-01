package com.tencent.mm.plugin.multitalk.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/agingOptimize/MultiTalkSelectAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MMBaseAccessibilityConfig
{
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(284632);
    AppMethodBeat.o(284632);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(284642);
    root(a.f.small_avatar_list).view(a.e.avatar).disable();
    root(a.f.multitalk_select_contact_ui).view(a.e.root).disable();
    AppMethodBeat.o(284642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.b
 * JD-Core Version:    0.7.0.1
 */