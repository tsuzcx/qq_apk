package com.tencent.mm.plugin.profile.ui.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/accessibility/PermissionSettingUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends MMBaseAccessibilityConfig
{
  public static final c.a NbG;
  
  static
  {
    AppMethodBeat.i(305656);
    NbG = new c.a((byte)0);
    AppMethodBeat.o(305656);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(305654);
    AppMethodBeat.o(305654);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(305660);
    root(R.h.fRF).view(R.h.fRH).descFormat(R.l.talkback_placehodler_2).type(ViewType.Button).valueByView(R.h.fRI).valueByKey("not_allow_see_sns_permission_cb_key");
    root(R.h.fXO).view(R.h.fRJ).descFormat(R.l.talkback_placehodler_2).type(ViewType.Button).valueByView(R.h.fRK).valueByKey("not_see_sns_permission_tv_key");
    root(R.i.gmS).view(R.h.fRJ).expand(40, 40, 40, 40);
    AppMethodBeat.o(305660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.c
 * JD-Core Version:    0.7.0.1
 */