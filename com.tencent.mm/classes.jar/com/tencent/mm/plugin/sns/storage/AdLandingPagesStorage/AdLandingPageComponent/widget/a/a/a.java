package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/view/MultiPickerWheelViewController;", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/IPickerUserInterface;", "context", "Landroid/content/Context;", "iPickerData", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/IPickerData;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/IPickerData;)V", "callbacks", "", "Lkotlin/Function1;", "", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickItem;", "Lkotlin/ParameterName;", "name", "selectedItems", "", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/SelectItemCallback;", "container", "Landroid/widget/LinearLayout;", "getContext", "()Landroid/content/Context;", "getIPickerData", "()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/IPickerData;", "wheels", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/view/PickerWheelViewController;", "createBindLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/view/PickerWheelViewController$PickerData;", "index", "", "lastWheelViewController", "getContainerView", "getSelectedItems", "initCallbacks", "initDefaultNode", "initUIOption", "uiOptions", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/IPickerData$UIOptions;", "initWheels", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "registerOnItemSelected", "callback", "unRegisterOnItemSelected", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.b
{
  public static final a.a QWG;
  private final LinearLayout Api;
  private final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a QWH;
  private final List<b> QWI;
  private final List<kotlin.g.a.b<List<d>, ah>> bPE;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(306877);
    QWG = new a.a((byte)0);
    AppMethodBeat.o(306877);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a parama)
  {
    AppMethodBeat.i(306860);
    this.context = paramContext;
    this.QWH = parama;
    paramContext = new LinearLayout(this.context);
    paramContext.setOrientation(0);
    parama = ah.aiuX;
    this.Api = paramContext;
    this.bPE = ((List)new ArrayList());
    this.QWI = ((List)hkx());
    hkz();
    this.QWH.hjK();
    hky();
    hkw();
    AppMethodBeat.o(306860);
  }
  
  private static final void a(x paramx, c paramc)
  {
    AppMethodBeat.i(306875);
    s.u(paramx, "$mutableLiveData");
    if (paramc == null) {}
    for (List localList = null; (localList == null) || (localList.isEmpty()); localList = paramc.QWF)
    {
      AppMethodBeat.o(306875);
      return;
    }
    paramx.setValue(new b.b(paramc, localList, 0, 0, 12));
    AppMethodBeat.o(306875);
  }
  
  private static final void a(a parama, c paramc)
  {
    AppMethodBeat.i(306873);
    s.u(parama, "this$0");
    paramc = ((Iterable)parama.bPE).iterator();
    while (paramc.hasNext()) {
      ((kotlin.g.a.b)paramc.next()).invoke(parama.hku());
    }
    AppMethodBeat.o(306873);
  }
  
  private final void hkw()
  {
    AppMethodBeat.i(306862);
    Iterator localIterator = ((Iterable)this.QWI).iterator();
    while (localIterator.hasNext()) {
      ((LiveData)((b)localIterator.next()).QWL).a(new a..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(306862);
  }
  
  private final ArrayList<b> hkx()
  {
    AppMethodBeat.i(306866);
    ArrayList localArrayList = new ArrayList();
    int j = this.QWH.hjH();
    int i = 0;
    Object localObject = null;
    if (i < j)
    {
      if (i == 0) {
        localObject = new x();
      }
      for (;;)
      {
        localObject = new b(this.context, (x)localObject);
        boolean bool = this.QWH.hjL();
        ((b)localObject).pxN.setCyclic(bool);
        localArrayList.add(localObject);
        i += 1;
        break;
        if (localObject == null)
        {
          Log.w("MultiPickerWheelView", s.X("createBindLiveData error with i=", Integer.valueOf(i)));
          localObject = new x();
        }
        else
        {
          x localx = new x();
          ((LiveData)((b)localObject).QWL).a(new a..ExternalSyntheticLambda0(localx));
          localObject = localx;
        }
      }
    }
    AppMethodBeat.o(306866);
    return localArrayList;
  }
  
  private final void hky()
  {
    AppMethodBeat.i(306868);
    Iterator localIterator = ((Iterable)this.QWI).iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams.weight = 1.0F;
      localb.pxN.setPadding(0, this.context.getResources().getDimensionPixelSize(b.d.sns_ad_data_picker_padding), 0, this.context.getResources().getDimensionPixelSize(b.d.sns_ad_data_picker_padding));
      localb.pxN.xS(androidx.core.content.a.w(this.context, b.c.BW_0_Alpha_0_9));
      localb.pxN.setDividerHeight(this.context.getResources().getDimensionPixelSize(b.d.sns_ad_picker_divide_line_height));
      localb.pxN.xR(this.context.getResources().getDimensionPixelSize(b.d.sns_ad_data_picker_item_height));
      localb.pxN.setBackgroundColor(androidx.core.content.a.w(this.context, b.c.BG_5));
      this.Api.addView((View)localb.pxN, (ViewGroup.LayoutParams)localLayoutParams);
    }
    AppMethodBeat.o(306868);
  }
  
  private final void hkz()
  {
    AppMethodBeat.i(306871);
    Object localObject1 = this.QWH.hjJ();
    int i;
    label44:
    label85:
    label91:
    int n;
    if (localObject1 != null) {
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i != 1) {
          break label173;
        }
        i = 1;
        if (i == 0) {
          break label183;
        }
        localObject1 = this.QWH.hjJ();
        if ((localObject1 == null) || (((List)localObject1).size() != this.QWI.size())) {
          break label178;
        }
        i = 1;
        if (i == 0) {
          break label183;
        }
        i = 1;
        if (i == 0) {
          break label345;
        }
        n = this.QWI.size() - 1;
        if (n < 0) {
          break label414;
        }
      }
    }
    int m;
    label139:
    label414:
    label421:
    for (int j = 0;; j = m)
    {
      m = j + 1;
      localObject1 = this.QWH.hjJ();
      if (localObject1 == null)
      {
        localObject2 = null;
        if (localObject2 != null) {
          break label204;
        }
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 != null) {
          break label232;
        }
        Log.w("MultiPickerWheelView", "get child nodes error!");
        AppMethodBeat.o(306871);
        return;
        i = 0;
        break;
        label173:
        i = 0;
        break label44;
        label178:
        i = 0;
        break label85;
        label183:
        i = 0;
        break label91;
        localObject2 = (c)((List)localObject1).get(j);
        break label139;
        label204:
        localObject1 = ((c)localObject2).QWE;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((c)localObject1).QWF;
        }
      }
      label232:
      Iterator localIterator = ((List)localObject1).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (!s.p(((c)localIterator.next()).key, ((c)localObject2).key)) {}
      }
      for (;;)
      {
        int k = i;
        if (i < 0) {
          k = 0;
        }
        ((b)this.QWI.get(j)).a(new b.b(((c)localObject2).QWE, (List)localObject1, k, 0, 8));
        if (m <= n) {
          break label421;
        }
        AppMethodBeat.o(306871);
        return;
        i += 1;
        break;
        i = -1;
      }
      label345:
      Object localObject2 = this.QWH.hjI().QWF;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (List)ab.aivy;
      }
      ((b)this.QWI.get(0)).a(new b.b(this.QWH.hjI(), (List)localObject1, 0, 0, 8));
      AppMethodBeat.o(306871);
      return;
    }
  }
  
  public final List<d> hku()
  {
    AppMethodBeat.i(306882);
    List localList = (List)new ArrayList();
    Iterator localIterator = ((Iterable)this.QWI).iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (b)localIterator.next();
      Object localObject1 = (c)((LiveData)((b)localObject3).QWL).getValue();
      label75:
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject2 = (c)((LiveData)((b)localObject3).QWL).getValue();
        if (localObject2 != null) {
          break label135;
        }
        localObject2 = "";
      }
      for (;;)
      {
        localList.add(new d((String)localObject1, (String)localObject2));
        break;
        localObject2 = ((c)localObject1).key;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label75;
        }
        localObject1 = "";
        break label75;
        label135:
        localObject3 = ((c)localObject2).label;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
      }
    }
    AppMethodBeat.o(306882);
    return localList;
  }
  
  public final LinearLayout hkv()
  {
    return this.Api;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a.a
 * JD-Core Version:    0.7.0.1
 */