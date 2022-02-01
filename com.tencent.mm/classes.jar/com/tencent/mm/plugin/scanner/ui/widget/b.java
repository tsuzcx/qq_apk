package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController;", "", "context", "Landroid/content/Context;", "enableScanCodeProductMerge", "", "(Landroid/content/Context;Z)V", "scanTabIdToIndex", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "scanTabInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$ScanTabInfo;", "Lkotlin/collections/ArrayList;", "scrollTabList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "scrollTabView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabView;", "selectedIndex", "addTab", "index", "scanTab", "attachScrollTabView", "", "enableScanGoods", "enableTranslation", "getScanScrollTabViewHeight", "getScanTabById", "tabId", "hide", "setEnable", "enable", "setEnableSwitchTab", "setEnableTab", "tabIdList", "", "setOnTabClickListener", "tabOnClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "setOnTabScrollListener", "tabOnScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "setOnTabSelectedListener", "tabOnSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "setSelectedTab", "tabSelectedAction", "show", "showTab", "switchNextTab", "switchPreviousTab", "Companion", "ScanTabInfo", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a Phg;
  private final boolean OTn;
  public ScanScrollTabView Phh;
  public ArrayList<a> Phi;
  public final ArrayList<b.b> Phj;
  private HashMap<Integer, Integer> Phk;
  private final Context context;
  private int dbk;
  
  static
  {
    AppMethodBeat.i(52442);
    Phg = new b.a((byte)0);
    AppMethodBeat.o(52442);
  }
  
  public b(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(314735);
    this.context = paramContext;
    this.OTn = paramBoolean;
    this.Phi = new ArrayList();
    this.dbk = -1;
    if (this.OTn) {}
    for (paramContext = this.context.getString(l.i.OKT);; paramContext = this.context.getString(l.i.OKW))
    {
      s.s(paramContext, "if (enableScanCodeProduc…R.string.scan_entry_qbar)");
      paramContext = new b.b(1, paramContext);
      Object localObject = this.context.getString(l.i.OKU);
      s.s(localObject, "context.getString(R.string.scan_entry_goods)");
      localObject = new b.b(12, (String)localObject);
      String str = this.context.getString(l.i.scan_entry_ocr);
      s.s(str, "context.getString(R.string.scan_entry_ocr)");
      this.Phj = p.al(new b.b[] { paramContext, localObject, new b.b(3, str) });
      this.Phk = new HashMap();
      AppMethodBeat.o(314735);
      return;
    }
  }
  
  private static boolean aiA(int paramInt)
  {
    AppMethodBeat.i(52440);
    if ((paramInt == 3) && (!t.gUm()))
    {
      AppMethodBeat.o(52440);
      return false;
    }
    if ((paramInt == 12) && (!t.gUo()))
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
    if (!aiA(paramb.Phl))
    {
      Log.w("MicroMsg.ScanScrollTabController", "alvinluo initTabs tabId: %d not show", new Object[] { Integer.valueOf(paramb.Phl) });
      AppMethodBeat.o(52435);
      return false;
    }
    if ((paramb.Phl == 12) && (WeChatBrands.Business.Entries.DiscoveryScanRecognize.restricted()))
    {
      AppMethodBeat.o(52435);
      return false;
    }
    if ((paramb.Phl == 3) && (WeChatBrands.Business.Entries.DiscoveryScanTranslate.restricted()))
    {
      AppMethodBeat.o(52435);
      return false;
    }
    ScrollTab localScrollTab = new ScrollTab(this.context);
    localScrollTab.setTabId(paramb.Phl);
    localScrollTab.setTabTitle(paramb.Phm);
    ((Map)this.Phk).put(Integer.valueOf(paramb.Phl), Integer.valueOf(paramInt));
    this.Phi.add(localScrollTab);
    ScanScrollTabView localScanScrollTabView = this.Phh;
    if (localScanScrollTabView != null) {
      localScanScrollTabView.b((a)localScrollTab);
    }
    Log.i("MicroMsg.ScanScrollTabController", "alvinluo addTab index: %d, tabId: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramb.Phl) });
    AppMethodBeat.o(52435);
    return true;
  }
  
  public final void gTx()
  {
    AppMethodBeat.i(52437);
    int i = this.dbk + 1;
    Log.d("MicroMsg.ScanScrollTabController", "alvinluo switchNextTab selectedIndex: %d, nextIndex: %d", new Object[] { Integer.valueOf(this.dbk), Integer.valueOf(i) });
    if ((i >= 0) && (i < this.Phi.size()))
    {
      this.dbk = i;
      ScanScrollTabView localScanScrollTabView = this.Phh;
      if (localScanScrollTabView != null) {
        localScanScrollTabView.kU(i, 3);
      }
    }
    AppMethodBeat.o(52437);
  }
  
  public final void gTy()
  {
    AppMethodBeat.i(52438);
    int i = this.dbk - 1;
    Log.d("MicroMsg.ScanScrollTabController", "alvinluo switchPreviousTab selectedIndex: %d, previousIndex: %d", new Object[] { Integer.valueOf(this.dbk), Integer.valueOf(i) });
    if ((i >= 0) && (i < this.Phi.size()))
    {
      this.dbk = i;
      ScanScrollTabView localScanScrollTabView = this.Phh;
      if (localScanScrollTabView != null) {
        localScanScrollTabView.kU(i, 3);
      }
    }
    AppMethodBeat.o(52438);
  }
  
  public final void kU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(314769);
    Integer localInteger = (Integer)this.Phk.get(Integer.valueOf(paramInt1));
    Log.i("MicroMsg.ScanScrollTabController", "alvinluo setSelectedTab tabId: %d, index: %s, tabSelectedAction: %d", new Object[] { Integer.valueOf(paramInt1), localInteger, Integer.valueOf(paramInt2) });
    if (localInteger != null)
    {
      this.dbk = localInteger.intValue();
      ScanScrollTabView localScanScrollTabView = this.Phh;
      if (localScanScrollTabView != null) {
        localScanScrollTabView.kU(localInteger.intValue(), paramInt2);
      }
    }
    AppMethodBeat.o(314769);
  }
  
  public final void kl(List<Integer> paramList)
  {
    AppMethodBeat.i(314774);
    s.u(paramList, "tabIdList");
    Log.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabIdList size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = this.Phh;
    if (localObject != null) {
      ((ScanScrollTabView)localObject).WY();
    }
    this.Phi.clear();
    localObject = ((Iterable)paramList).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      int j = ((Number)((Iterator)localObject).next()).intValue();
      Log.v("MicroMsg.ScanScrollTabController", "alvinluo setEnableTab tabId: %d", new Object[] { Integer.valueOf(j) });
      Iterator localIterator = ((Iterable)this.Phj).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (b.b)localIterator.next();
      } while (paramList.Phl != j);
      while (paramList == null)
      {
        AppMethodBeat.o(314774);
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
      AppMethodBeat.o(314774);
      return;
    }
  }
  
  public final void setEnableSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(52439);
    Log.i("MicroMsg.ScanScrollTabController", "alvinluo setEnableSwitchTab enable: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ScanScrollTabView localScanScrollTabView = this.Phh;
    if (localScanScrollTabView != null) {
      localScanScrollTabView.setEnableSwitchTab(paramBoolean);
    }
    AppMethodBeat.o(52439);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabController$setOnTabSelectedListener$tabOnSelectedListenerWrapper$1", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "onTabSelected", "", "tabId", "", "tabSelectedAction", "onTabUnSelected", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements e
  {
    public d(b paramb, e parame) {}
    
    public final void aiq(int paramInt)
    {
      AppMethodBeat.i(52434);
      this.Pho.aiq(paramInt);
      AppMethodBeat.o(52434);
    }
    
    public final void kR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(52433);
      Integer localInteger = (Integer)b.a(this.Phn).get(Integer.valueOf(paramInt1));
      if (localInteger != null) {
        b.a(this.Phn, localInteger.intValue());
      }
      this.Pho.kR(paramInt1, paramInt2);
      AppMethodBeat.o(52433);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */