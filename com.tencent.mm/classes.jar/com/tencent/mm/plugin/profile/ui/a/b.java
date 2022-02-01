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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/accessibility/FacingCreateChatRoomAllInOneUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MMBaseAccessibilityConfig
{
  public static final b.a NbF;
  
  static
  {
    AppMethodBeat.i(305658);
    NbF = new b.a((byte)0);
    AppMethodBeat.o(305658);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(305655);
    AppMethodBeat.o(305655);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(305663);
    root(R.i.gnn).view(R.h.fIj).type(ViewType.Button).descFormat(R.l.biz_timeline_placeholder).valueByKey("title_num_1");
    root(R.i.gnn).view(R.h.second).type(ViewType.Button).descFormat(R.l.biz_timeline_placeholder).valueByKey("title_num_2");
    root(R.i.gnn).view(R.h.fZe).type(ViewType.Button).descFormat(R.l.biz_timeline_placeholder).valueByKey("title_num_3");
    root(R.i.gnn).view(R.h.fIP).type(ViewType.Button).descFormat(R.l.biz_timeline_placeholder).valueByKey("title_num_4");
    AppMethodBeat.o(305663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.b
 * JD-Core Version:    0.7.0.1
 */