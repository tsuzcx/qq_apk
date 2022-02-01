package com.tencent.mm.ui.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/accessibility/ChattingUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends MMBaseAccessibilityConfig
{
  public static final d.a adLr;
  
  static
  {
    AppMethodBeat.i(250105);
    adLr = new d.a((byte)0);
    AppMethodBeat.o(250105);
  }
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250099);
    AppMethodBeat.o(250099);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(250109);
    root(R.i.ggR).view(R.h.fTY).descFormat(R.l.msg_quote_ll).valueByView(R.h.fwZ).valueByKey("quote_img");
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(R.i.ggn);
    localConfigHelper.view(R.h.chatting_click_area).desc(R.h.fZY);
    localConfigHelper.view(R.h.fMO).desc(R.l.avatar_desc);
    root(R.i.actionbar_custom_area_center).view(R.h.title_area_ll).desc((b)new b(this));
    AppMethodBeat.o(250109);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.a.d
 * JD-Core Version:    0.7.0.1
 */