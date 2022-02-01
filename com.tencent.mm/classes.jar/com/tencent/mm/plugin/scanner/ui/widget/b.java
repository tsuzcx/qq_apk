package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "scanTabIdToIndex", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "scanTabInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$ScanTabInfo;", "Lkotlin/collections/ArrayList;", "scrollTabList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "scrollTabView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabView;", "selectedIndex", "addTab", "", "index", "scanTab", "attachScrollTabView", "", "enableScanGoods", "enableTranslation", "getScanTabById", "tabId", "hide", "setEnable", "enable", "setEnableSwitchTab", "setEnableTab", "tabIdList", "", "setOnTabClickListener", "tabOnClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "setOnTabScrollListener", "tabOnScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "setOnTabSelectedListener", "tabOnSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "setSelectedTab", "show", "showTab", "switchNextTab", "switchPreviousTab", "Companion", "ScanTabInfo", "plugin-scan_release"})
public final class b
{
  public static final b.a xkA;
  public int bns;
  private final Context context;
  public ScanScrollTabView xkw;
  public ArrayList<a> xkx;
  public final ArrayList<b.b> xky;
  public HashMap<Integer, Integer> xkz;
  
  static
  {
    AppMethodBeat.i(52442);
    xkA = new b.a((byte)0);
    AppMethodBeat.o(52442);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(52441);
    this.context = paramContext;
    this.xkx = new ArrayList();
    this.bns = -1;
    paramContext = this.context.getString(2131762809);
    k.g(paramContext, "context.getString(R.string.scan_entry_qbar)");
    paramContext = new b.b(1, paramContext);
    Object localObject = this.context.getString(2131762804);
    k.g(localObject, "context.getString(R.string.scan_entry_goods)");
    localObject = new b.b(12, (String)localObject);
    String str = this.context.getString(2131762808);
    k.g(str, "context.getString(R.string.scan_entry_ocr)");
    this.xky = j.ab(new b.b[] { paramContext, localObject, new b.b(3, str) });
    this.xkz = new HashMap();
    AppMethodBeat.o(52441);
  }
  
  private static boolean Np(int paramInt)
  {
    AppMethodBeat.i(52440);
    if ((paramInt == 3) && (!o.dBv()))
    {
      AppMethodBeat.o(52440);
      return false;
    }
    if ((paramInt == 12) && (!o.dBx()))
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
    if (!Np(paramb.xkB))
    {
      ac.w("MicroMsg.ScanScrollTabController", "alvinluo initTabs tabId: %d not show", new Object[] { Integer.valueOf(paramb.xkB) });
      AppMethodBeat.o(52435);
      return false;
    }
    ScrollTab localScrollTab = new ScrollTab(this.context);
    localScrollTab.setTabId(paramb.xkB);
    localScrollTab.setTabTitle(paramb.xkC);
    ((Map)this.xkz).put(Integer.valueOf(paramb.xkB), Integer.valueOf(paramInt));
    this.xkx.add(localScrollTab);
    ScanScrollTabView localScanScrollTabView = this.xkw;
    if (localScanScrollTabView != null) {
      localScanScrollTabView.b((a)localScrollTab);
    }
    ac.i("MicroMsg.ScanScrollTabController", "alvinluo addTab index: %d, tabId: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramb.xkB) });
    AppMethodBeat.o(52435);
    return true;
  }
  
  public final void dBc()
  {
    AppMethodBeat.i(52437);
    int i = this.bns + 1;
    ac.d("MicroMsg.ScanScrollTabController", "alvinluo switchNextTab selectedIndex: %d, nextIndex: %d", new Object[] { Integer.valueOf(this.bns), Integer.valueOf(i) });
    if ((i >= 0) && (i < this.xkx.size()))
    {
      this.bns = i;
      ScanScrollTabView localScanScrollTabView = this.xkw;
      if (localScanScrollTabView != null)
      {
        localScanScrollTabView.hb(i, 3);
        AppMethodBeat.o(52437);
        return;
      }
    }
    AppMethodBeat.o(52437);
  }
  
  public final void dBd()
  {
    AppMethodBeat.i(52438);
    int i = this.bns - 1;
    ac.d("MicroMsg.ScanScrollTabController", "alvinluo switchPreviousTab selectedIndex: %d, previousIndex: %d", new Object[] { Integer.valueOf(this.bns), Integer.valueOf(i) });
    if ((i >= 0) && (i < this.xkx.size()))
    {
      this.bns = i;
      ScanScrollTabView localScanScrollTabView = this.xkw;
      if (localScanScrollTabView != null)
      {
        localScanScrollTabView.hb(i, 3);
        AppMethodBeat.o(52438);
        return;
      }
    }
    AppMethodBeat.o(52438);
  }
  
  public final void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(52439);
    ac.i("MicroMsg.ScanScrollTabController", "alvinluo setEnableSwitchTab enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ScanScrollTabView localScanScrollTabView = this.xkw;
    if (localScanScrollTabView != null)
    {
      localScanScrollTabView.setEnableSwitchTab(paramBoolean);
      AppMethodBeat.o(52439);
      return;
    }
    AppMethodBeat.o(52439);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$setOnTabSelectedListener$tabOnSelectedListenerWrapper$1", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "onTabSelected", "", "tabId", "", "tabSelectedAction", "onTabUnSelected", "plugin-scan_release"})
  public static final class d
    implements e
  {
    public d(e parame) {}
    
    public final void Ni(int paramInt)
    {
      AppMethodBeat.i(52434);
      this.xkE.Ni(paramInt);
      AppMethodBeat.o(52434);
    }
    
    public final void gY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(52433);
      Integer localInteger = (Integer)b.a(this.xkD).get(Integer.valueOf(paramInt1));
      if (localInteger != null) {
        b.a(this.xkD, localInteger.intValue());
      }
      this.xkE.gY(paramInt1, paramInt2);
      AppMethodBeat.o(52433);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */