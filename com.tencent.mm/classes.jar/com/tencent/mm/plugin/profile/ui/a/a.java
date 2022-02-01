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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/accessibility/AddMoreFriendsUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public static final a.a NbE;
  
  static
  {
    AppMethodBeat.i(305662);
    NbE = new a.a((byte)0);
    AppMethodBeat.o(305662);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(305659);
    AppMethodBeat.o(305659);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(305666);
    root(R.i.glM).view(R.h.search_ll).expand(40, 5, 40, 0);
    root(R.i.glL).view(R.h.mm_preference_ll_id).descFormat(R.l.talkback_placehodler_3).valueByView(16908310).valueByView(R.h.text_tv_one).valueByView(16908304).disableChildren();
    root(R.i.mm_preference_info_qrcode).view(16908310).type(ViewType.Button).descFormat(R.l.biz_timeline_placeholder).valueByKey("title_key");
    AppMethodBeat.o(305666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.a
 * JD-Core Version:    0.7.0.1
 */