package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a;

import android.content.Context;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/view/PickerWheelViewController;", "", "context", "Landroid/content/Context;", "bindData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/view/PickerWheelViewController$PickerData;", "wheelView", "Lcom/tencent/mm/picker/base/view/WheelView;", "(Landroid/content/Context;Landroidx/lifecycle/MutableLiveData;Lcom/tencent/mm/picker/base/view/WheelView;)V", "_selectedItem", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickDataNode;", "getBindData", "()Landroidx/lifecycle/MutableLiveData;", "getContext", "()Landroid/content/Context;", "currentPickData", "selectedItem", "Landroidx/lifecycle/LiveData;", "getSelectedItem", "()Landroidx/lifecycle/LiveData;", "getWheelView", "()Lcom/tencent/mm/picker/base/view/WheelView;", "isCyclic", "", "(Lcom/tencent/mm/picker/base/view/WheelView;)Z", "findNearedIndex", "", "lastItems", "", "updateItems", "lastIndex", "findNewIndex", "pickerData", "lastPickerData", "getCurrentPickItem", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickItem;", "getDataNode", "selectIndex", "initDefaultData", "", "setAdapter", "setCyclic", "cyclic", "Companion", "PickerData", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a QWJ;
  private final x<b> QWK;
  final x<c> QWL;
  private b QWM;
  private final Context context;
  final WheelView pxN;
  
  static
  {
    AppMethodBeat.i(306869);
    QWJ = new b.a((byte)0);
    AppMethodBeat.o(306869);
  }
  
  private b(Context paramContext, x<b> paramx, WheelView paramWheelView)
  {
    AppMethodBeat.i(306854);
    this.context = paramContext;
    this.QWK = paramx;
    this.pxN = paramWheelView;
    this.QWL = new x();
    this.pxN.setOnItemSelectedListener(new b..ExternalSyntheticLambda1(this));
    this.QWK.a(new b..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(306854);
  }
  
  private static final void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(306864);
    s.u(paramb, "this$0");
    paramb.QWL.setValue(paramb.alr(paramInt));
    AppMethodBeat.o(306864);
  }
  
  private static final void a(b paramb, b paramb1)
  {
    int i1 = 0;
    AppMethodBeat.i(306867);
    s.u(paramb, "this$0");
    if (paramb1 == null)
    {
      AppMethodBeat.o(306867);
      return;
    }
    Object localObject1 = paramb.QWM;
    if (localObject1 == null) {}
    for (localObject1 = null; (s.p(localObject1, paramb1.QWE)) && (paramb1.QWN < 0); localObject1 = ((b)localObject1).QWE)
    {
      AppMethodBeat.o(306867);
      return;
    }
    Object localObject2 = paramb.QWM;
    s.u(paramb1, "pickerData");
    int k;
    int i;
    List localList;
    label200:
    label204:
    label212:
    label231:
    int j;
    label267:
    boolean bool;
    int n;
    int m;
    if ((localObject2 != null) && (paramb1.QWN < 0))
    {
      k = paramb.pxN.getCurrentItem();
      if (paramb1.QWO == 2) {
        i = i1;
      }
      do
      {
        do
        {
          paramb.pxN.setAdapter((com.tencent.mm.picker.base.a.b)new c(paramb1));
          paramb.pxN.requestLayout();
          paramb.pxN.setCurrentItem(i);
          paramb.QWM = paramb1;
          paramb.QWL.setValue(paramb.alr(i));
          AppMethodBeat.o(306867);
          return;
          localList = paramb1.bMQ;
          localObject1 = ((b)localObject2).bMQ;
          if (((List)localObject1).size() <= k) {
            break;
          }
          i = 1;
          if (i == 0) {
            break label568;
          }
          if (localObject1 != null) {
            break label574;
          }
          localObject1 = null;
          i = i1;
        } while (localObject1 == null);
        Iterator localIterator = localList.iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label598;
        }
        if (!s.p(((c)localIterator.next()).key, ((c)localObject1).key)) {
          break label591;
        }
        j = i;
        i = j;
        if (j >= 0) {
          break label641;
        }
        i = i1;
      } while (paramb1.QWO == 1);
      localObject1 = ((b)localObject2).bMQ;
      localObject2 = paramb.pxN;
      s.u(localObject2, "<this>");
      bool = ((WheelView)localObject2).oYG;
      j = 0;
      n = 0;
      i = k;
      m = k;
      k = i;
    }
    label641:
    label644:
    for (;;)
    {
      label326:
      if (k < ((List)localObject1).size())
      {
        localObject2 = localList.iterator();
        i = 0;
        label349:
        if (!((Iterator)localObject2).hasNext()) {
          break label610;
        }
        if (s.p(((c)((Iterator)localObject2).next()).key, ((c)((List)localObject1).get(k)).key)) {
          j = i;
        }
      }
      else
      {
        i = j;
        if (j >= 0) {
          break label641;
        }
        if (m >= 0)
        {
          localObject2 = localList.iterator();
          i = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label622;
          }
          if (!s.p(((c)((Iterator)localObject2).next()).key, ((c)((List)localObject1).get(m)).key)) {
            break label615;
          }
        }
      }
      for (;;)
      {
        label393:
        label417:
        j = i;
        i = j;
        if (j >= 0) {
          break label641;
        }
        n += 1;
        if (k >= ((List)localObject1).size())
        {
          i = i1;
          if (m < 0) {
            break;
          }
        }
        i = i1;
        if (n >= ((List)localObject1).size()) {
          break;
        }
        k += 1;
        m -= 1;
        if (!bool) {
          break label644;
        }
        i = m;
        if (m < 0) {
          i = ((List)localObject1).size() - 1;
        }
        k %= ((List)localObject1).size();
        m = i;
        break label326;
        i = 0;
        break label200;
        label568:
        localObject1 = null;
        break label204;
        label574:
        localObject1 = (c)((List)localObject1).get(k);
        break label212;
        label591:
        i += 1;
        break label231;
        label598:
        j = -1;
        break label267;
        i += 1;
        break label349;
        label610:
        i = -1;
        break label393;
        label615:
        i += 1;
        break label417;
        label622:
        i = -1;
      }
      j = paramb1.QWN;
      i = i1;
      if (j < 0) {
        break;
      }
      i = j;
      break;
    }
  }
  
  private final c alr(int paramInt)
  {
    AppMethodBeat.i(306861);
    Object localObject = this.QWM;
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      Log.w("PickerWheelView", "onItemSelectedListener error: cannot find selectItem!");
      AppMethodBeat.o(306861);
      return null;
      localObject = ((b)localObject).bMQ;
      int i;
      if (((List)localObject).size() > paramInt)
      {
        i = 1;
        label51:
        if (i == 0) {
          break label69;
        }
      }
      for (;;)
      {
        if (localObject != null) {
          break label74;
        }
        localObject = null;
        break;
        i = 0;
        break label51;
        label69:
        localObject = null;
      }
      label74:
      localObject = (c)((List)localObject).get(paramInt);
    }
    AppMethodBeat.o(306861);
    return localObject;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(306874);
    s.u(paramb, "pickerData");
    this.QWK.setValue(paramb);
    AppMethodBeat.o(306874);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/view/PickerWheelViewController$PickerData;", "", "parentNode", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickDataNode;", "items", "", "refreshForceToIndex", "", "refreshBehavior", "(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickDataNode;Ljava/util/List;II)V", "getItems", "()Ljava/util/List;", "getParentNode", "()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickDataNode;", "getRefreshBehavior", "()I", "getRefreshForceToIndex", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final c QWE;
    final int QWN;
    final int QWO;
    final List<c> bMQ;
    
    private b(c paramc, List<c> paramList, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(306855);
      this.QWE = paramc;
      this.bMQ = paramList;
      this.QWN = paramInt1;
      this.QWO = paramInt2;
      AppMethodBeat.o(306855);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/view/PickerWheelViewController$setAdapter$1", "Lcom/tencent/mm/picker/base/adapter/WheelAdapter;", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickDataNode;", "getItem", "index", "", "getItemToDisplay", "", "getItemsCount", "indexOf", "o", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.picker.base.a.b<c>
  {
    c(b.b paramb) {}
    
    public final int getItemsCount()
    {
      AppMethodBeat.i(306859);
      int i = this.QWP.bMQ.size();
      AppMethodBeat.o(306859);
      return i;
    }
    
    public final String xN(int paramInt)
    {
      AppMethodBeat.i(306863);
      if (paramInt < 0)
      {
        AppMethodBeat.o(306863);
        return "";
      }
      Object localObject = this.QWP.bMQ;
      if (((List)localObject).size() > paramInt)
      {
        localObject = ((c)((List)localObject).get(paramInt)).label;
        AppMethodBeat.o(306863);
        return localObject;
      }
      AppMethodBeat.o(306863);
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a.b
 * JD-Core Version:    0.7.0.1
 */