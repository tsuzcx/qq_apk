package com.tencent.mm.plugin.profile.ui.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/accessibility/SayHiWithSnsPermissionUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends MMBaseAccessibilityConfig
{
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(305657);
    AppMethodBeat.o(305657);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(305665);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(R.h.fVm);
    localConfigHelper.view(R.h.scrollView).disable();
    localConfigHelper.view(R.h.fOr).descFormat(R.l.talkback_placehodler).type(ViewType.Button).valueByView(R.h.fOs).clickAs(R.h.fOs).disableChildren();
    localConfigHelper.view(R.h.fMh).descFormat(R.l.talkback_placehodler).valueByView(R.h.fMh).type(ViewType.TextView);
    localConfigHelper.view(R.h.fYL).descFormat(R.l.talkback_placehodler).valueByView(R.h.fYL).type(ViewType.TextView);
    localConfigHelper.view(R.h.fRG).descFormat(R.l.talkback_placehodler).valueByView(R.h.fRG).type(ViewType.TextView);
    localConfigHelper.view(R.h.fRI).descFormat(R.l.talkback_placehodler).valueByView(R.h.fRI).type(ViewType.TextView);
    localConfigHelper.view(R.h.fRK).descFormat(R.l.talkback_placehodler).valueByView(R.h.fRK).type(ViewType.TextView);
    localConfigHelper.view(R.h.request_title).descFormat(R.l.talkback_placehodler).valueByView(R.h.request_title).type(ViewType.TextView);
    localConfigHelper.view(R.h.fUL).descFormat(R.l.talkback_placehodler).valueByView(R.h.fUL).type(ViewType.TextView);
    localConfigHelper.view(R.h.fYK).descFormat(R.l.talkback_placehodler_2).type(ViewType.TextView).valueByView(R.h.fYL).valueByView(R.h.fYI).clickAs(R.h.fYL).clickAs(R.h.fYI).disableChildren();
    AppMethodBeat.o(305665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.d
 * JD-Core Version:    0.7.0.1
 */