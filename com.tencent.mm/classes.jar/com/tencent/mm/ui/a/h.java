package com.tencent.mm.ui.a;

import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.k;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/accessibility/MMCommonAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends MMBaseAccessibilityConfig
{
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250091);
    AppMethodBeat.o(250091);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(250095);
    String str1 = getResources().getString(a.k.app_close);
    s.s(str1, "resources.getString(R.string.app_close)");
    final String str2 = getResources().getString(a.k.app_back);
    s.s(str2, "resources.getString(R.string.app_back)");
    s.s(getResources().getString(a.k.app_share), "resources.getString(R.string.app_share)");
    int i = a.g.actionbar_up_indicator;
    view(i, i).type(ViewType.Button).desc((b)new a(str1, str2));
    AppMethodBeat.o(250095);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.a.h
 * JD-Core Version:    0.7.0.1
 */