package com.tencent.mm.plugin.multitalk.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.h;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/agingOptimize/MultiTalkAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(284647);
    AppMethodBeat.o(284647);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(284657);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.f.multitalk_main_ui);
    localConfigHelper.view(a.e.invite_main_layout).descFormat(a.h.multitalk_invite).valueByView(a.e.invite_main_nickname_tv);
    localConfigHelper.view(a.e.small_avatar_introduce_layout).desc((b)a.Lin);
    localConfigHelper.view(a.e.small_avatar_iv_container).disable();
    localConfigHelper.view(a.e.introduce_tv).disable();
    localConfigHelper.view(a.e.invite_main_avatar_iv).disable();
    root(a.f.main_ui_talking_avatar_cell).view(a.e.mask_view).descFormat(a.h.multitalk_members_waiting).valueByView(a.e.avatar_username_tv);
    localConfigHelper = root(a.f.multitalk_icons_layout);
    localConfigHelper.view(a.e.multitalk_icons_container).descFormat(a.h.multitalk_icon).valueByView(a.e.icon_name);
    localConfigHelper.view(a.e.icon_name).disable();
    localConfigHelper = root(a.f.multitalk_frame_layout);
    localConfigHelper.view(a.e.frame_avatar).desc((b)new b(this));
    localConfigHelper.view(a.e.frame_video).desc((b)new c(this));
    AppMethodBeat.o(284657);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    public static final a Lin;
    
    static
    {
      AppMethodBeat.i(284631);
      Lin = new a();
      AppMethodBeat.o(284631);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.a
 * JD-Core Version:    0.7.0.1
 */