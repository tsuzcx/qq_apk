package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "", "()V", "TAG", "", "callCountMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "Lkotlin/collections/HashMap;", "controlByteMap", "isTooFrequent", "", "controlByte", "reportTooFrequent", "", "funcName", "url", "JsApiCallInfo", "webview-sdk_release"})
public final class e
{
  private final HashMap<Integer, a> Cjs;
  private final HashMap<Integer, Integer> Cjt;
  private final String TAG;
  
  public e()
  {
    AppMethodBeat.i(205529);
    this.TAG = "MicroMsg.JsApiFrequentHelper";
    this.Cjs = new HashMap();
    this.Cjt = new HashMap();
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = ((b)g.ab(b.class)).a(b.a.pPG, "{\"list\":[{\"limit\":10,\"pos\":14},{\"limit\":10,\"pos\":15}]}");
        JSONArray localJSONArray = new JSONObject((String)localObject1).optJSONArray("list");
        if (localJSONArray == null) {
          break;
        }
        int j = localJSONArray.length();
        i = 0;
        if (i >= j) {
          break;
        }
        localObject2 = localJSONArray.get(i);
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type org.json.JSONObject");
          AppMethodBeat.o(205529);
          throw ((Throwable)localObject1);
        }
      }
      catch (Throwable localThrowable)
      {
        ac.w(this.TAG, "parse fail: ex=" + localThrowable.getMessage());
        AppMethodBeat.o(205529);
        return;
      }
      Object localObject2 = (JSONObject)localObject2;
      ((Map)this.Cjt).put(Integer.valueOf(((JSONObject)localObject2).optInt("pos")), Integer.valueOf(((JSONObject)localObject2).optInt("limit")));
      i += 1;
    }
    ac.i(this.TAG, "size=" + this.Cjt.size() + ", config=" + localThrowable);
    AppMethodBeat.o(205529);
  }
  
  public final void N(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(205528);
    k.h(paramString1, "funcName");
    k.h(paramString2, "url");
    if (((Map)this.Cjt).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.Cjt.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        k.fOy();
      }
      k.g(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(205528);
        return;
      }
      localObject = (a)this.Cjs.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        if (((a)localObject).count == i) {
          h.wUl.f(18188, new Object[] { paramString1, x.aId(paramString2) });
        }
        AppMethodBeat.o(205528);
        return;
      }
    }
    AppMethodBeat.o(205528);
  }
  
  public final boolean UM(int paramInt)
  {
    AppMethodBeat.i(205527);
    if (((Map)this.Cjt).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.Cjt.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        k.fOy();
      }
      k.g(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(205527);
        return false;
      }
      localObject = (a)this.Cjs.get(Integer.valueOf(paramInt));
      long l = System.currentTimeMillis() / 60000L;
      if (localObject == null) {
        localObject = new a(l);
      }
      for (;;)
      {
        ((Map)this.Cjs).put(Integer.valueOf(paramInt), localObject);
        if (((a)localObject).count < i) {
          break;
        }
        AppMethodBeat.o(205527);
        return true;
        if (((a)localObject).time == l)
        {
          ((a)localObject).count += 1;
        }
        else
        {
          ((a)localObject).time = l;
          ((a)localObject).count = 1;
        }
      }
      ac.i(this.TAG, "isTooFrequent controlByte:" + paramInt + ", count:" + ((a)localObject).count);
    }
    AppMethodBeat.o(205527);
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "", "time", "", "count", "", "(JI)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "webview-sdk_release"})
  public static final class a
  {
    int count;
    long time;
    
    public a(long paramLong)
    {
      this.time = paramLong;
      this.count = 1;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.time != paramObject.time) || (this.count != paramObject.count)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.time;
      return (int)(l ^ l >>> 32) * 31 + this.count;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205526);
      String str = "JsApiCallInfo(time=" + this.time + ", count=" + this.count + ")";
      AppMethodBeat.o(205526);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.e
 * JD-Core Version:    0.7.0.1
 */