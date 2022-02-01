package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "", "()V", "TAG", "", "callCountMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "Lkotlin/collections/HashMap;", "controlByteMap", "isTooFrequent", "", "controlByte", "reportTooFrequent", "", "funcName", "url", "JsApiCallInfo", "webview-sdk_release"})
public final class e
{
  private final HashMap<Integer, a> ARf;
  private final HashMap<Integer, Integer> ARg;
  private final String TAG;
  
  public e()
  {
    AppMethodBeat.i(189397);
    this.TAG = "MicroMsg.JsApiFrequentHelper";
    this.ARf = new HashMap();
    this.ARg = new HashMap();
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = ((b)g.ab(b.class)).a(b.a.pmk, "{\"list\":[{\"limit\":10,\"pos\":14},{\"limit\":10,\"pos\":15}]}");
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
          AppMethodBeat.o(189397);
          throw ((Throwable)localObject1);
        }
      }
      catch (Throwable localThrowable)
      {
        ad.w(this.TAG, "parse fail: ex=" + localThrowable.getMessage());
        AppMethodBeat.o(189397);
        return;
      }
      Object localObject2 = (JSONObject)localObject2;
      ((Map)this.ARg).put(Integer.valueOf(((JSONObject)localObject2).optInt("pos")), Integer.valueOf(((JSONObject)localObject2).optInt("limit")));
      i += 1;
    }
    ad.i(this.TAG, "size=" + this.ARg.size() + ", config=" + localThrowable);
    AppMethodBeat.o(189397);
  }
  
  public final void N(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(189396);
    k.h(paramString1, "funcName");
    k.h(paramString2, "url");
    if (((Map)this.ARg).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.ARg.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        k.fvU();
      }
      k.g(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(189396);
        return;
      }
      localObject = (a)this.ARf.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        if (((a)localObject).count == i) {
          h.vKh.f(18188, new Object[] { paramString1, x.aCL(paramString2) });
        }
        AppMethodBeat.o(189396);
        return;
      }
    }
    AppMethodBeat.o(189396);
  }
  
  public final boolean SE(int paramInt)
  {
    AppMethodBeat.i(189395);
    if (((Map)this.ARg).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.ARg.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        k.fvU();
      }
      k.g(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(189395);
        return false;
      }
      localObject = (a)this.ARf.get(Integer.valueOf(paramInt));
      long l = System.currentTimeMillis() / 60000L;
      if (localObject == null) {
        localObject = new a(l);
      }
      for (;;)
      {
        ((Map)this.ARf).put(Integer.valueOf(paramInt), localObject);
        if (((a)localObject).count < i) {
          break;
        }
        AppMethodBeat.o(189395);
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
    AppMethodBeat.o(189395);
    return false;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "", "time", "", "count", "", "(JI)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "webview-sdk_release"})
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
      AppMethodBeat.i(189394);
      String str = "JsApiCallInfo(time=" + this.time + ", count=" + this.count + ")";
      AppMethodBeat.o(189394);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.e
 * JD-Core Version:    0.7.0.1
 */