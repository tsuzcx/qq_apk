package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "", "()V", "TAG", "", "callCountMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "Lkotlin/collections/HashMap;", "controlByteMap", "isTooFrequent", "", "controlByte", "reportTooFrequent", "", "funcName", "url", "JsApiCallInfo", "webview-sdk_release"})
public final class e
{
  private final HashMap<Integer, a> DMw;
  private final HashMap<Integer, Integer> DMx;
  private final String TAG;
  
  public e()
  {
    AppMethodBeat.i(214318);
    this.TAG = "MicroMsg.JsApiFrequentHelper";
    this.DMw = new HashMap();
    this.DMx = new HashMap();
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qtH, "{\"list\":[{\"limit\":10,\"pos\":14},{\"limit\":10,\"pos\":15}]}");
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
          AppMethodBeat.o(214318);
          throw ((Throwable)localObject1);
        }
      }
      catch (Throwable localThrowable)
      {
        ad.w(this.TAG, "parse fail: ex=" + localThrowable.getMessage());
        AppMethodBeat.o(214318);
        return;
      }
      Object localObject2 = (JSONObject)localObject2;
      ((Map)this.DMx).put(Integer.valueOf(((JSONObject)localObject2).optInt("pos")), Integer.valueOf(((JSONObject)localObject2).optInt("limit")));
      i += 1;
    }
    ad.i(this.TAG, "size=" + this.DMx.size() + ", config=" + localThrowable);
    AppMethodBeat.o(214318);
  }
  
  public final void Q(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(214317);
    p.h(paramString1, "funcName");
    p.h(paramString2, "url");
    if (((Map)this.DMx).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.DMx.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.gfZ();
      }
      p.g(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(214317);
        return;
      }
      localObject = (a)this.DMw.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        if (((a)localObject).count == i) {
          com.tencent.mm.plugin.report.service.g.yhR.f(18188, new Object[] { paramString1, x.aNF(paramString2) });
        }
        AppMethodBeat.o(214317);
        return;
      }
    }
    AppMethodBeat.o(214317);
  }
  
  public final boolean WD(int paramInt)
  {
    AppMethodBeat.i(214316);
    if (((Map)this.DMx).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.DMx.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.gfZ();
      }
      p.g(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(214316);
        return false;
      }
      localObject = (a)this.DMw.get(Integer.valueOf(paramInt));
      long l = System.currentTimeMillis() / 60000L;
      if (localObject == null) {
        localObject = new a(l);
      }
      for (;;)
      {
        ((Map)this.DMw).put(Integer.valueOf(paramInt), localObject);
        if (((a)localObject).count < i) {
          break;
        }
        AppMethodBeat.o(214316);
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
      ad.i(this.TAG, "isTooFrequent controlByte:" + paramInt + ", count:" + ((a)localObject).count);
    }
    AppMethodBeat.o(214316);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "", "time", "", "count", "", "(JI)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "webview-sdk_release"})
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
      AppMethodBeat.i(214315);
      String str = "JsApiCallInfo(time=" + this.time + ", count=" + this.count + ")";
      AppMethodBeat.o(214315);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.e
 * JD-Core Version:    0.7.0.1
 */