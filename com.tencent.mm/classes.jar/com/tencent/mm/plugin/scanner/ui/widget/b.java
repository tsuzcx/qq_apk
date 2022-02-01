package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "scanTabIdToIndex", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "scanTabInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$ScanTabInfo;", "Lkotlin/collections/ArrayList;", "scrollTabList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "scrollTabView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabView;", "selectedIndex", "addTab", "", "index", "scanTab", "attachScrollTabView", "", "enableScanGoods", "enableTranslation", "getScanTabById", "tabId", "hide", "setEnable", "enable", "setEnableSwitchTab", "setEnableTab", "tabIdList", "", "setOnTabClickListener", "tabOnClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "setOnTabScrollListener", "tabOnScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "setOnTabSelectedListener", "tabOnSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "setSelectedTab", "show", "showTab", "switchNextTab", "switchPreviousTab", "Companion", "ScanTabInfo", "plugin-scan_release"})
public final class b
{
  public static final a vZu;
  public int boX;
  private final Context context;
  public ScanScrollTabView vZq;
  public ArrayList<a> vZr;
  public final ArrayList<b.b> vZs;
  public HashMap<Integer, Integer> vZt;
  
  static
  {
    AppMethodBeat.i(52442);
    vZu = new a((byte)0);
    AppMethodBeat.o(52442);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(52441);
    this.context = paramContext;
    this.vZr = new ArrayList();
    this.boX = -1;
    paramContext = this.context.getString(2131762809);
    k.g(paramContext, "context.getString(R.string.scan_entry_qbar)");
    paramContext = new b.b(1, paramContext);
    Object localObject = this.context.getString(2131762804);
    k.g(localObject, "context.getString(R.string.scan_entry_goods)");
    localObject = new b.b(12, (String)localObject);
    String str = this.context.getString(2131762808);
    k.g(str, "context.getString(R.string.scan_entry_ocr)");
    this.vZs = j.Z(new b.b[] { paramContext, localObject, new b.b(3, str) });
    this.vZt = new HashMap();
    AppMethodBeat.o(52441);
  }
  
  private static boolean Lp(int paramInt)
  {
    AppMethodBeat.i(52440);
    if ((paramInt == 3) && (!o.dnn()))
    {
      AppMethodBeat.o(52440);
      return false;
    }
    if ((paramInt == 12) && (!o.dnp()))
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
    if (!Lp(paramb.vZv))
    {
      ad.w("MicroMsg.ScanScrollTabController", "alvinluo initTabs tabId: %d not show", new Object[] { Integer.valueOf(paramb.vZv) });
      AppMethodBeat.o(52435);
      return false;
    }
    ScrollTab localScrollTab = new ScrollTab(this.context);
    localScrollTab.setTabId(paramb.vZv);
    localScrollTab.setTabTitle(paramb.vZw);
    ((Map)this.vZt).put(Integer.valueOf(paramb.vZv), Integer.valueOf(paramInt));
    this.vZr.add(localScrollTab);
    ScanScrollTabView localScanScrollTabView = this.vZq;
    if (localScanScrollTabView != null) {
      localScanScrollTabView.b((a)localScrollTab);
    }
    ad.i("MicroMsg.ScanScrollTabController", "alvinluo addTab index: %d, tabId: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramb.vZv) });
    AppMethodBeat.o(52435);
    return true;
  }
  
  public final void dmU()
  {
    AppMethodBeat.i(52437);
    int i = this.boX + 1;
    ad.d("MicroMsg.ScanScrollTabController", "alvinluo switchNextTab selectedIndex: %d, nextIndex: %d", new Object[] { Integer.valueOf(this.boX), Integer.valueOf(i) });
    if ((i >= 0) && (i < this.vZr.size()))
    {
      this.boX = i;
      ScanScrollTabView localScanScrollTabView = this.vZq;
      if (localScanScrollTabView != null)
      {
        localScanScrollTabView.gS(i, 3);
        AppMethodBeat.o(52437);
        return;
      }
    }
    AppMethodBeat.o(52437);
  }
  
  public final void dmV()
  {
    AppMethodBeat.i(52438);
    int i = this.boX - 1;
    ad.d("MicroMsg.ScanScrollTabController", "alvinluo switchPreviousTab selectedIndex: %d, previousIndex: %d", new Object[] { Integer.valueOf(this.boX), Integer.valueOf(i) });
    if ((i >= 0) && (i < this.vZr.size()))
    {
      this.boX = i;
      ScanScrollTabView localScanScrollTabView = this.vZq;
      if (localScanScrollTabView != null)
      {
        localScanScrollTabView.gS(i, 3);
        AppMethodBeat.o(52438);
        return;
      }
    }
    AppMethodBeat.o(52438);
  }
  
  public final void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(52439);
    ad.i("MicroMsg.ScanScrollTabController", "alvinluo setEnableSwitchTab enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ScanScrollTabView localScanScrollTabView = this.vZq;
    if (localScanScrollTabView != null)
    {
      localScanScrollTabView.setEnableSwitchTab(paramBoolean);
      AppMethodBeat.o(52439);
      return;
    }
    AppMethodBeat.o(52439);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$setOnTabSelectedListener$tabOnSelectedListenerWrapper$1", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "onTabSelected", "", "tabId", "", "tabSelectedAction", "onTabUnSelected", "plugin-scan_release"})
  public static final class d
    implements e
  {
    public d(e parame) {}
    
    public final void Li(int paramInt)
    {
      AppMethodBeat.i(52434);
      this.vZy.Li(paramInt);
      AppMethodBeat.o(52434);
    }
    
    public final void gP(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(52433);
      Integer localInteger = (Integer)b.a(this.vZx).get(Integer.valueOf(paramInt1));
      if (localInteger != null) {
        b.a(this.vZx, localInteger.intValue());
      }
      this.vZy.gP(paramInt1, paramInt2);
      AppMethodBeat.o(52433);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */