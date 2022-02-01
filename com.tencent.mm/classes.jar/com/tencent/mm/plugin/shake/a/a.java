package com.tencent.mm.plugin.shake.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/shake/accessibility/ShakeReportUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273488);
    AppMethodBeat.o(273488);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(273498);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(R.h.fOT);
    localConfigHelper.view(R.h.fOS).desc(R.l.shake_back);
    localConfigHelper.view(R.h.fOU).desc(R.l.shake_setting);
    localConfigHelper = root(R.h.fRy);
    localConfigHelper.view(R.h.fRB).desc(R.l.shake_back);
    localConfigHelper.view(R.h.fRC).desc(R.l.shake_setting);
    AppMethodBeat.o(273498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.a.a
 * JD-Core Version:    0.7.0.1
 */