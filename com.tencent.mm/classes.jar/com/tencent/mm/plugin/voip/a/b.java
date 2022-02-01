package com.tencent.mm.plugin.voip.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/agingOptimize/VoIPCallerVoiceAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MMBaseAccessibilityConfig
{
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(292211);
    AppMethodBeat.o(292211);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(292213);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(b.e.layout_voip_caller_voice);
    localConfigHelper.view(b.d.voip_remote_talker_avatar).disable();
    localConfigHelper.view(b.d.voip_invite_tips_dot).disable();
    localConfigHelper.view(b.d.voip_remote_talker_container).descFormat(b.g.voip_invite).valueByView(b.d.voip_remote_talker_name).valueByView(b.d.voip_invite_tips);
    focusFirst(b.d.voip_remote_talker_container);
    AppMethodBeat.o(292213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.b
 * JD-Core Version:    0.7.0.1
 */