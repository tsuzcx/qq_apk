package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "scanTabIdToIndex", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "scanTabInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$ScanTabInfo;", "Lkotlin/collections/ArrayList;", "scrollTabList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "scrollTabView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabView;", "selectedIndex", "addTab", "", "index", "scanTab", "attachScrollTabView", "", "enableScanGoods", "enableTranslation", "getScanTabById", "tabId", "hide", "setEnable", "enable", "setEnableSwitchTab", "setEnableTab", "tabIdList", "", "setOnTabClickListener", "tabOnClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "setOnTabScrollListener", "tabOnScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "setOnTabSelectedListener", "tabOnSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "setSelectedTab", "tabSelectedAction", "show", "showTab", "switchNextTab", "switchPreviousTab", "Companion", "ScanTabInfo", "plugin-scan_release"})
public final class b
{
  public static final b.a CSt;
  public ScanScrollTabView CSp;
  public ArrayList<a> CSq;
  public final ArrayList<b.b> CSr;
  private HashMap<Integer, Integer> CSs;
  private int bxP;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(52442);
    CSt = new b.a((byte)0);
    AppMethodBeat.o(52442);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(52441);
    this.context = paramContext;
    this.CSq = new ArrayList();
    this.bxP = -1;
    paramContext = this.context.getString(2131764906);
    p.g(paramContext, "context.getString(R.string.scan_entry_qbar)");
    paramContext = new b.b(1, paramContext);
    Object localObject = this.context.getString(2131764901);
    p.g(localObject, "context.getString(R.string.scan_entry_goods)");
    localObject = new b.b(12, (String)localObject);
    String str = this.context.getString(2131764905);
    p.g(str, "context.getString(R.string.scan_entry_ocr)");
    this.CSr = j.ac(new b.b[] { paramContext, localObject, new b.b(3, str) });
    this.CSs = new HashMap();
    AppMethodBeat.o(52441);
  }
  
  private static boolean WX(int paramInt)
  {
    AppMethodBeat.i(52440);
    if ((paramInt == 3) && (!r.eSd()))
    {
      AppMethodBeat.o(52440);
      return false;
    }
    if ((paramInt == 12) && (!r.eSf()))
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
    if (!WX(paramb.CSu))
    {
      Log.w("MicroMsg.ScanScrollTabController", "alvinluo initTabs tabId: %d not show", new Object[] { Integer.valueOf(paramb.CSu) });
      AppMethodBeat.o(52435);
      return false;
    }
    if ((paramb.CSu == 12) && (WeChatBrands.Business.Entries.DiscoveryScanRecognize.restricted()))
    {
      AppMethodBeat.o(52435);
      return false;
    }
    if ((paramb.CSu == 3) && (WeChatBrands.Business.Entries.DiscoveryScanTranslate.restricted()))
    {
      AppMethodBeat.o(52435);
      return false;
    }
    ScrollTab localScrollTab = new ScrollTab(this.context);
    localScrollTab.setTabId(paramb.CSu);
    localScrollTab.setTabTitle(paramb.CSv);
    ((Map)this.CSs).put(Integer.valueOf(paramb.CSu), Integer.valueOf(paramInt));
    this.CSq.add(localScrollTab);
    ScanScrollTabView localScanScrollTabView = this.CSp;
    if (localScanScrollTabView != null) {
      localScanScrollTabView.b((a)localScrollTab);
    }
    Log.i("MicroMsg.ScanScrollTabController", "alvinluo addTab index: %d, tabId: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramb.CSu) });
    AppMethodBeat.o(52435);
    return true;
  }
  
  public final void eRD()
  {
    AppMethodBeat.i(52437);
    int i = this.bxP + 1;
    Log.d("MicroMsg.ScanScrollTabController", "alvinluo switchNextTab selectedIndex: %d, nextIndex: %d", new Object[] { Integer.valueOf(this.bxP), Integer.valueOf(i) });
    if ((i >= 0) && (i < this.CSq.size()))
    {
      this.bxP = i;
      ScanScrollTabView localScanScrollTabView = this.CSp;
      if (localScanScrollTabView != null)
      {
        localScanScrollTabView.ii(i, 3);
        AppMethodBeat.o(52437);
        return;
      }
    }
    AppMethodBeat.o(52437);
  }
  
  public final void eRE()
  {
    AppMethodBeat.i(52438);
    int i = this.bxP - 1;
    Log.d("MicroMsg.ScanScrollTabController", "alvinluo switchPreviousTab selectedIndex: %d, previousIndex: %d", new Object[] { Integer.valueOf(this.bxP), Integer.valueOf(i) });
    if ((i >= 0) && (i < this.CSq.size()))
    {
      this.bxP = i;
      ScanScrollTabView localScanScrollTabView = this.CSp;
      if (localScanScrollTabView != null)
      {
        localScanScrollTabView.ii(i, 3);
        AppMethodBeat.o(52438);
        return;
      }
    }
    AppMethodBeat.o(52438);
  }
  
  public final void gE(List<Integer> paramList)
  {
    AppMethodBeat.i(240673);
    p.h(paramList, "tabIdList");
    Log.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabIdList size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = this.CSp;
    if (localObject != null) {
      ((ScanScrollTabView)localObject).removeAllTabs();
    }
    this.CSq.clear();
    localObject = ((Iterable)paramList).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      int j = ((Number)((Iterator)localObject).next()).intValue();
      Log.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabId: %d", new Object[] { Integer.valueOf(j) });
      Iterator localIterator = ((Iterable)this.CSr).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (b.b)localIterator.next();
      } while (paramList.CSu != j);
      while (paramList == null)
      {
        AppMethodBeat.o(240673);
        return;
        paramList = null;
      }
      if (!a(i, paramList)) {
        break label198;
      }
      i += 1;
    }
    label198:
    for (;;)
    {
      break;
      AppMethodBeat.o(240673);
      return;
    }
  }
  
  public final void ii(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240672);
    Integer localInteger = (Integer)this.CSs.get(Integer.valueOf(paramInt1));
    Log.i("MicroMsg.ScanScrollTabController", "alvinluo setSelectedTab tabId: %d, index: %s, tabSelectedAction: %d", new Object[] { Integer.valueOf(paramInt1), localInteger, Integer.valueOf(paramInt2) });
    if (localInteger != null)
    {
      this.bxP = localInteger.intValue();
      ScanScrollTabView localScanScrollTabView = this.CSp;
      if (localScanScrollTabView != null)
      {
        localScanScrollTabView.ii(localInteger.intValue(), paramInt2);
        AppMethodBeat.o(240672);
        return;
      }
    }
    AppMethodBeat.o(240672);
  }
  
  public final void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(52439);
    Log.i("MicroMsg.ScanScrollTabController", "alvinluo setEnableSwitchTab enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ScanScrollTabView localScanScrollTabView = this.CSp;
    if (localScanScrollTabView != null)
    {
      localScanScrollTabView.setEnableSwitchTab(paramBoolean);
      AppMethodBeat.o(52439);
      return;
    }
    AppMethodBeat.o(52439);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$setOnTabSelectedListener$tabOnSelectedListenerWrapper$1", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "onTabSelected", "", "tabId", "", "tabSelectedAction", "onTabUnSelected", "plugin-scan_release"})
  public static final class d
    implements e
  {
    public d(e parame) {}
    
    public final void WQ(int paramInt)
    {
      AppMethodBeat.i(52434);
      this.CSx.WQ(paramInt);
      AppMethodBeat.o(52434);
    }
    
    public final void jdMethod_if(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(52433);
      Integer localInteger = (Integer)b.a(this.CSw).get(Integer.valueOf(paramInt1));
      if (localInteger != null) {
        b.a(this.CSw, localInteger.intValue());
      }
      this.CSx.jdMethod_if(paramInt1, paramInt2);
      AppMethodBeat.o(52433);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */