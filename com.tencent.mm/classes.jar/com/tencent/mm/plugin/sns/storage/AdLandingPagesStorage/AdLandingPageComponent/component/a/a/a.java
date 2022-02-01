package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/h5component/wheelpicker/JsDataMapper;", "", "()V", "parseJson", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/IPickerData;", "pickerParams", "Lorg/json/JSONObject;", "reserveTree", "", "childsJson", "Lorg/json/JSONArray;", "childsList", "", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickDataNode;", "node", "deep", "", "maxDeep", "transferTable", "", "", "toJSONObject", "root", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a QSV;
  
  static
  {
    AppMethodBeat.i(307162);
    QSV = new a();
    AppMethodBeat.o(307162);
  }
  
  private static void a(JSONArray paramJSONArray, List<c> paramList, c paramc, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(307157);
    s.u(paramJSONArray, "childsJson");
    s.u(paramList, "childsList");
    s.u(paramc, "node");
    int j = paramJSONArray.length();
    int i = 0;
    if (i < j)
    {
      List localList = (List)new ArrayList();
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      Object localObject2 = localJSONObject.optString("k");
      label77:
      Object localObject1;
      if (localObject2 == null)
      {
        localObject2 = "";
        localObject1 = localJSONObject.optString("v");
        s.s(localObject1, "nodeLabel");
        if (!n.bp((CharSequence)localObject1)) {
          break label216;
        }
        if (paramMap != null) {
          break label186;
        }
        localObject1 = "";
      }
      label186:
      label216:
      for (;;)
      {
        localObject1 = new c((String)localObject2, (String)localObject1, localList, paramc);
        paramList.add(localObject1);
        localObject2 = localJSONObject.optJSONArray("childs");
        if ((localObject2 != null) && (paramInt1 < paramInt2)) {
          a((JSONArray)localObject2, localList, (c)localObject1, paramInt1 + 1, paramInt2, paramMap);
        }
        i += 1;
        break;
        break label77;
        String str = (String)paramMap.get(localObject2);
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
      }
    }
    AppMethodBeat.o(307157);
  }
  
  public static final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a bQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(307154);
    s.u(paramJSONObject, "pickerParams");
    int j = paramJSONObject.optInt("deep");
    Object localObject4 = paramJSONObject.optJSONArray("default");
    final List localList1 = (List)new ArrayList();
    List localList2 = (List)new ArrayList();
    int k;
    if (localObject4 != null)
    {
      k = ((JSONArray)localObject4).length();
      i = 0;
      if (i < k)
      {
        localObject2 = ((JSONArray)localObject4).optJSONObject(i);
        if (localObject2 == null)
        {
          localObject1 = "";
          label85:
          if (localObject2 != null) {
            break label144;
          }
          localObject2 = "";
        }
        for (;;)
        {
          localList2.add(new d((String)localObject1, (String)localObject2));
          i += 1;
          break;
          localObject1 = ((JSONObject)localObject2).optString("k");
          if (localObject1 == null)
          {
            localObject1 = "";
            break label85;
          }
          break label85;
          label144:
          localObject3 = ((JSONObject)localObject2).optString("v");
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
        }
      }
    }
    Object localObject3 = (Map)new LinkedHashMap();
    localObject4 = paramJSONObject.optJSONArray("transferTable");
    if (localObject4 != null)
    {
      k = ((JSONArray)localObject4).length();
      i = 0;
      while (i < k)
      {
        JSONObject localJSONObject = ((JSONArray)localObject4).optJSONObject(i);
        localObject2 = localJSONObject.optString("k");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localJSONObject.optString("v");
        s.s(localObject2, "jsonObj.optString(\"v\")");
        ((Map)localObject3).put(localObject1, localObject2);
        i += 1;
      }
    }
    paramJSONObject = paramJSONObject.optJSONArray("data");
    Object localObject1 = (List)new ArrayList();
    Object localObject2 = new c("root", "root", (List)localObject1, null);
    if (paramJSONObject != null) {
      a(paramJSONObject, (List)localObject1, (c)localObject2, 0, j, (Map)localObject3);
    }
    int i = 0;
    paramJSONObject = (JSONObject)localObject2;
    label356:
    boolean bool;
    if (i < j)
    {
      localObject1 = paramJSONObject.QWF;
      if (localObject1 == null) {
        break label489;
      }
      localObject3 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = ((Iterator)localObject3).next();
        localObject4 = (c)localObject1;
        if (localList2.size() > i)
        {
          bool = s.p(((c)localObject4).key, ((d)localList2.get(i)).key);
          label417:
          if (!bool) {
            break label458;
          }
          label422:
          localObject1 = (c)localObject1;
          if (localObject1 == null) {
            break label489;
          }
          localList1.add(localObject1);
          paramJSONObject = (JSONObject)localObject1;
        }
      }
    }
    label458:
    label489:
    for (;;)
    {
      i += 1;
      break;
      bool = false;
      break label417;
      break label356;
      localObject1 = null;
      break label422;
      paramJSONObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a)new a(j, (c)localObject2, localList1);
      AppMethodBeat.o(307154);
      return paramJSONObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/h5component/wheelpicker/JsDataMapper$parseJson$4", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/IPickerData;", "colNum", "", "getColNum", "()I", "defaultPickDataNodeKeys", "", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickDataNode;", "getDefaultPickDataNodeKeys", "()Ljava/util/List;", "isCyclic", "", "()Z", "rootPickDataNode", "getRootPickDataNode", "()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickDataNode;", "uiOptions", "Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/IPickerData$UIOptions;", "getUiOptions", "()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/IPickerData$UIOptions;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a
  {
    private final int QSW;
    private final c QSX;
    private final List<c> QSY;
    private final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a.a QSZ;
    private final boolean QTa;
    
    a(int paramInt, c paramc, List<c> paramList)
    {
      AppMethodBeat.i(307144);
      this.QSW = this.QTb;
      this.QSX = this.QTc;
      this.QSY = localList1;
      this.QTa = true;
      AppMethodBeat.o(307144);
    }
    
    public final int hjH()
    {
      return this.QSW;
    }
    
    public final c hjI()
    {
      return this.QSX;
    }
    
    public final List<c> hjJ()
    {
      return this.QSY;
    }
    
    public final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.a.a hjK()
    {
      return this.QSZ;
    }
    
    public final boolean hjL()
    {
      return this.QTa;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.a.a.a
 * JD-Core Version:    0.7.0.1
 */