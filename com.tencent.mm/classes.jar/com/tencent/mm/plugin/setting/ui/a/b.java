package com.tencent.mm.plugin.setting.ui.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/accessibility/SettingFontAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MMBaseAccessibilityConfig
{
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(298592);
    AppMethodBeat.o(298592);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(298599);
    String str = getString(b.i.setting_text_size_font_selector_desc);
    view(b.g.settings_font_ui, b.f.font_selector_view).type(ViewType.SeekBar).desc((kotlin.g.a.b)new a(str)).onSeekBackward((kotlin.g.a.b)b.Pov).onSeekForward((kotlin.g.a.b)c.Pow);
    AppMethodBeat.o(298599);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<View, String>
  {
    a(String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    public static final b Pov;
    
    static
    {
      AppMethodBeat.i(298591);
      Pov = new b();
      AppMethodBeat.o(298591);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<View, ah>
  {
    public static final c Pow;
    
    static
    {
      AppMethodBeat.i(298588);
      Pow = new c();
      AppMethodBeat.o(298588);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.a.b
 * JD-Core Version:    0.7.0.1
 */