package com.tencent.mm.plugin.webwx.ui.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webwx/ui/accessibility/ExDeviceWXLoginUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(265352);
    AppMethodBeat.o(265352);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(265362);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(R.i.giQ);
    localConfigHelper.view(R.h.fYA).type(ViewType.CheckBox).desc(R.h.fYy).checkOn((b)a.XxZ);
    localConfigHelper.view(R.h.fsu).type(ViewType.CheckBox).desc(R.h.fst).checkOn((b)b.Xya);
    AppMethodBeat.o(265362);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, Boolean>
  {
    public static final a XxZ;
    
    static
    {
      AppMethodBeat.i(265359);
      XxZ = new a();
      AppMethodBeat.o(265359);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, Boolean>
  {
    public static final b Xya;
    
    static
    {
      AppMethodBeat.i(265357);
      Xya = new b();
      AppMethodBeat.o(265357);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.a.a
 * JD-Core Version:    0.7.0.1
 */