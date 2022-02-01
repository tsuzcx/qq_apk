package com.tencent.mm.ui.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.chatroom.ui.a.f;
import com.tencent.mm.chatroom.ui.a.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/accessibility/SingleChatInfoUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends MMBaseAccessibilityConfig
{
  public static final m.a adLF;
  
  static
  {
    AppMethodBeat.i(250087);
    adLF = new m.a((byte)0);
    AppMethodBeat.o(250087);
  }
  
  public m(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250078);
    AppMethodBeat.o(250078);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(250092);
    root(a.f.actionbar_title_center).view(16908308).descFormat(a.i.actionbar_title_desc).valueByView(16908308).valueByKey("is_mute");
    AppMethodBeat.o(250092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.a.m
 * JD-Core Version:    0.7.0.1
 */