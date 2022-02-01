package com.tencent.mm.plugin.repairer.ui.demo.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.plugin.repairer.ui.b.f;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/accessibility/RepairerDemoAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "dataList", "", "Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerAccessibilityDemoUI$UserData;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "initConfig", "", "setList", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public static final a.a OxB;
  
  static
  {
    AppMethodBeat.i(278200);
    OxB = new a.a((byte)0);
    AppMethodBeat.o(278200);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(278189);
    AppMethodBeat.o(278189);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(278219);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(b.c.OuL);
    localConfigHelper.view(b.c.OuS).desc((b)a.b.OxC);
    localConfigHelper.view(b.c.OuE).desc(b.f.Owi);
    localConfigHelper.view(b.c.OuO).disable();
    localConfigHelper.view(b.c.OuQ).descFormat(b.f.Owl).valueByView(b.c.OuR);
    localConfigHelper.view(b.c.OuH).descFormat(b.f.Owk).valueByView(b.c.OuG).valueByKey("number_key");
    localConfigHelper.view(b.c.OuS).type(ViewType.Button).desc((b)a.c.OxD);
    localConfigHelper.view(b.c.OuG).descFormat(b.f.Owj).valueByView(b.c.OuG);
    root(b.d.Ovw).view(b.c.OuI).desc((b)a.f.OxG);
    localConfigHelper = root(b.c.OuL);
    localConfigHelper.disable(b.c.OuP);
    localConfigHelper.disable(b.c.OuR);
    localConfigHelper.disable(b.c.OuL);
    focusFirst(b.c.OuS);
    focusOrder().next(b.c.OuS).next(b.c.OuE).next(b.c.OuW).next(b.c.OuX);
    focusOrder().next(b.c.OuF).next(b.c.OuG);
    localConfigHelper = root(b.d.Ovp);
    Iterator localIterator = ((Iterable)p.listOf(new Integer[] { Integer.valueOf(b.c.OuE), Integer.valueOf(b.c.OuF), Integer.valueOf(b.c.OuQ) })).iterator();
    while (localIterator.hasNext()) {
      localConfigHelper.view(((Number)localIterator.next()).intValue()).type(ViewType.Button);
    }
    root(b.d.Ovp).view(b.c.OuX).talkOn(b.f.Owm, (b)a.g.OxH);
    root(b.d.Ovp).view(b.c.OuN).clickAs(b.c.OuM);
    root(b.d.Ovp).view(b.c.OuN).disableChildren();
    root(b.d.Ovp).view(b.c.OuF).expand(40, 40, 40, 40);
    root(b.d.Ovp).view(b.c.OuU).disExpand();
    view(b.d.Ovp, b.c.OuV).desc((b)a.h.OxI).checkOn((b)a.i.OxJ);
    view(b.d.Ovp, b.c.OuV).type(ViewType.SeekBar).onSeekForward((b)a.d.OxE).onSeekBackward((b)a.e.OxF);
    AppMethodBeat.o(278219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.a.a
 * JD-Core Version:    0.7.0.1
 */