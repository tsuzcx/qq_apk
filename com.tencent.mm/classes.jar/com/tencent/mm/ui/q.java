package com.tencent.mm.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/LauncherServiceNoticeAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends MMBaseAccessibilityConfig
{
  public q(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(249205);
    AppMethodBeat.o(249205);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(249212);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(R.h.fQd);
    localConfigHelper.view(R.h.fQd).descFormat(R.l.talkback_placehodler_4).valueByView(R.h.fQA).valueByView(R.h.fPz).valueByView(R.h.fQz).valueByView(R.h.fQb).type(ViewType.Button);
    localConfigHelper.view(R.h.fQi).desc(R.l.chatting_more).type(ViewType.Button);
    Iterator localIterator = ((Iterable)p.listOf(new Integer[] { Integer.valueOf(R.h.fQA), Integer.valueOf(R.h.fPz), Integer.valueOf(R.h.fQz), Integer.valueOf(R.h.fQb), Integer.valueOf(R.h.fPv) })).iterator();
    while (localIterator.hasNext()) {
      localConfigHelper.disable(((Number)localIterator.next()).intValue());
    }
    root(R.h.fPA).view(R.h.fPA).desc(R.h.fPv);
    localConfigHelper = root(R.h.fuP);
    localConfigHelper.view(R.h.fPC).descFormat(R.l.talkback_placehodler).valueByView(R.h.fPE).disableChildren().type(ViewType.Button);
    localConfigHelper.view(R.h.fPF).descFormat(R.l.talkback_placehodler).valueByView(R.h.fPH).disableChildren().type(ViewType.Button);
    localConfigHelper.view(R.h.fQo).descFormat(R.l.talkback_placehodler_2).valueByView(R.h.fQr).valueByView(R.h.fQq).type(ViewType.Button);
    root(R.h.fJG).view(R.h.fJG).desc(R.h.fAr).type(ViewType.Button);
    root(R.h.fJG).view(R.h.fxl).disable();
    root(R.h.fOz).view(R.h.fOz).desc(R.l.chatting_more).type(ViewType.Button);
    root(R.h.fGs).view(R.h.fGs).desc(R.h.fPv);
    root(R.h.fyC).view(R.h.fEZ).desc(R.l.gWE).type(ViewType.Button);
    root(R.h.fQe).view(R.h.fQj).desc(R.l.chatting_more).type(ViewType.Button);
    root(R.h.fzK).view(R.h.fTt).disable();
    AppMethodBeat.o(249212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.q
 * JD-Core Version:    0.7.0.1
 */