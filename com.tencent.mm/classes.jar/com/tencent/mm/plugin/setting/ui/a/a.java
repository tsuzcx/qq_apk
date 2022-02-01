package com.tencent.mm.plugin.setting.ui.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/accessibility/SelfQRCodeUIAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public static final a.a Pot;
  
  static
  {
    AppMethodBeat.i(298586);
    Pot = new a.a((byte)0);
    AppMethodBeat.o(298586);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(298585);
    AppMethodBeat.o(298585);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(298594);
    root(b.g.self_qrcode).view(b.f.qrcode_bg).descFormat(b.i.qrcode_desc).valueByView(b.f.nick_name).valueByKey("sex_key").valueByView(b.f.district).valueByView(b.f.self_qrcode_iv).valueByView(b.f.self_qrcode_verify_open_prompt).valueByView(b.f.qrcode_tip);
    AppMethodBeat.o(298594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.a.a
 * JD-Core Version:    0.7.0.1
 */