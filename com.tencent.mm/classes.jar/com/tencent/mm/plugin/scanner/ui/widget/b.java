package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "scanTabIdToIndex", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "scanTabInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$ScanTabInfo;", "Lkotlin/collections/ArrayList;", "scrollTabList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "scrollTabView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabView;", "selectedIndex", "addTab", "", "index", "scanTab", "attachScrollTabView", "", "enableScanGoods", "enableTranslation", "getScanTabById", "tabId", "hide", "setEnable", "enable", "setEnableSwitchTab", "setEnableTab", "tabIdList", "", "setOnTabClickListener", "tabOnClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "setOnTabScrollListener", "tabOnScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "setOnTabSelectedListener", "tabOnSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "setSelectedTab", "show", "showTab", "switchNextTab", "switchPreviousTab", "Companion", "ScanTabInfo", "plugin-scan_release"})
public final class b
{
  public static final b.a yOC;
  public int bxN;
  private final Context context;
  public final ArrayList<b.b> yOA;
  public HashMap<Integer, Integer> yOB;
  public ScanScrollTabView yOy;
  public ArrayList<a> yOz;
  
  static
  {
    AppMethodBeat.i(52442);
    yOC = new b.a((byte)0);
    AppMethodBeat.o(52442);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(52441);
    this.context = paramContext;
    this.yOz = new ArrayList();
    this.bxN = -1;
    paramContext = this.context.getString(2131762809);
    p.g(paramContext, "context.getString(R.string.scan_entry_qbar)");
    paramContext = new b.b(1, paramContext);
    Object localObject = this.context.getString(2131762804);
    p.g(localObject, "context.getString(R.string.scan_entry_goods)");
    localObject = new b.b(12, (String)localObject);
    String str = this.context.getString(2131762808);
    p.g(str, "context.getString(R.string.scan_entry_ocr)");
    this.yOA = j.ab(new b.b[] { paramContext, localObject, new b.b(3, str) });
    this.yOB = new HashMap();
    AppMethodBeat.o(52441);
  }
  
  private static boolean Py(int paramInt)
  {
    AppMethodBeat.i(52440);
    if ((paramInt == 3) && (!o.dQl()))
    {
      AppMethodBeat.o(52440);
      return false;
    }
    if ((paramInt == 12) && (!o.dQn()))
    {
      AppMethodBeat.o(52440);
      return false;
    }
    AppMethodBeat.o(52440);
    return true;
  }
  
  public final boolean a(int paramInt, b.b paramb)
  {
    AppMethodBeat.i(52435);
    if (!Py(paramb.yOD))
    {
      ae.w("MicroMsg.ScanScrollTabController", "alvinluo initTabs tabId: %d not show", new Object[] { Integer.valueOf(paramb.yOD) });
      AppMethodBeat.o(52435);
      return false;
    }
    ScrollTab localScrollTab = new ScrollTab(this.context);
    localScrollTab.setTabId(paramb.yOD);
    localScrollTab.setTabTitle(paramb.yOE);
    ((Map)this.yOB).put(Integer.valueOf(paramb.yOD), Integer.valueOf(paramInt));
    this.yOz.add(localScrollTab);
    ScanScrollTabView localScanScrollTabView = this.yOy;
    if (localScanScrollTabView != null) {
      localScanScrollTabView.b((a)localScrollTab);
    }
    ae.i("MicroMsg.ScanScrollTabController", "alvinluo addTab index: %d, tabId: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramb.yOD) });
    AppMethodBeat.o(52435);
    return true;
  }
  
  public final void dPT()
  {
    AppMethodBeat.i(52437);
    int i = this.bxN + 1;
    ae.d("MicroMsg.ScanScrollTabController", "alvinluo switchNextTab selectedIndex: %d, nextIndex: %d", new Object[] { Integer.valueOf(this.bxN), Integer.valueOf(i) });
    if ((i >= 0) && (i < this.yOz.size()))
    {
      this.bxN = i;
      ScanScrollTabView localScanScrollTabView = this.yOy;
      if (localScanScrollTabView != null)
      {
        localScanScrollTabView.hu(i, 3);
        AppMethodBeat.o(52437);
        return;
      }
    }
    AppMethodBeat.o(52437);
  }
  
  public final void dPU()
  {
    AppMethodBeat.i(52438);
    int i = this.bxN - 1;
    ae.d("MicroMsg.ScanScrollTabController", "alvinluo switchPreviousTab selectedIndex: %d, previousIndex: %d", new Object[] { Integer.valueOf(this.bxN), Integer.valueOf(i) });
    if ((i >= 0) && (i < this.yOz.size()))
    {
      this.bxN = i;
      ScanScrollTabView localScanScrollTabView = this.yOy;
      if (localScanScrollTabView != null)
      {
        localScanScrollTabView.hu(i, 3);
        AppMethodBeat.o(52438);
        return;
      }
    }
    AppMethodBeat.o(52438);
  }
  
  public final void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(52439);
    ae.i("MicroMsg.ScanScrollTabController", "alvinluo setEnableSwitchTab enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ScanScrollTabView localScanScrollTabView = this.yOy;
    if (localScanScrollTabView != null)
    {
      localScanScrollTabView.setEnableSwitchTab(paramBoolean);
      AppMethodBeat.o(52439);
      return;
    }
    AppMethodBeat.o(52439);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$setOnTabSelectedListener$tabOnSelectedListenerWrapper$1", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "onTabSelected", "", "tabId", "", "tabSelectedAction", "onTabUnSelected", "plugin-scan_release"})
  public static final class d
    implements e
  {
    public d(e parame) {}
    
    public final void Pr(int paramInt)
    {
      AppMethodBeat.i(52434);
      this.yOG.Pr(paramInt);
      AppMethodBeat.o(52434);
    }
    
    public final void hr(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(52433);
      Integer localInteger = (Integer)b.a(this.yOF).get(Integer.valueOf(paramInt1));
      if (localInteger != null) {
        b.a(this.yOF, localInteger.intValue());
      }
      this.yOG.hr(paramInt1, paramInt2);
      AppMethodBeat.o(52433);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */