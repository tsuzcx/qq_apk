package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "", "()V", "TAG", "", "callCountMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "Lkotlin/collections/HashMap;", "controlByteMap", "isTooFrequent", "", "controlByte", "reportTooFrequent", "", "funcName", "url", "JsApiCallInfo", "webview-sdk_release"})
public final class g
{
  private final HashMap<Integer, a> PNq;
  private final HashMap<Integer, Integer> PNr;
  private final String TAG;
  
  public g()
  {
    AppMethodBeat.i(206686);
    this.TAG = "MicroMsg.JsApiFrequentHelper";
    this.PNq = new HashMap();
    this.PNr = new HashMap();
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vzg, "{\"list\":[{\"limit\":10,\"pos\":14},{\"limit\":10,\"pos\":15}]}");
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
          localObject1 = new t("null cannot be cast to non-null type org.json.JSONObject");
          AppMethodBeat.o(206686);
          throw ((Throwable)localObject1);
        }
      }
      catch (Throwable localThrowable)
      {
        Log.w(this.TAG, "parse fail: ex=" + localThrowable.getMessage());
        AppMethodBeat.o(206686);
        return;
      }
      Object localObject2 = (JSONObject)localObject2;
      ((Map)this.PNr).put(Integer.valueOf(((JSONObject)localObject2).optInt("pos")), Integer.valueOf(((JSONObject)localObject2).optInt("limit")));
      i += 1;
    }
    Log.i(this.TAG, "size=" + this.PNr.size() + ", config=" + localThrowable);
    AppMethodBeat.o(206686);
  }
  
  public final void W(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(206685);
    p.k(paramString1, "funcName");
    p.k(paramString2, "url");
    if (((Map)this.PNr).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.PNr.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.iCn();
      }
      p.j(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(206685);
        return;
      }
      localObject = (a)this.PNq.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        if (((a)localObject).count == i) {
          com.tencent.mm.plugin.report.service.h.IzE.a(18188, new Object[] { paramString1, ab.aXb(paramString2) });
        }
        AppMethodBeat.o(206685);
        return;
      }
    }
    AppMethodBeat.o(206685);
  }
  
  public final boolean anH(int paramInt)
  {
    AppMethodBeat.i(206684);
    if (((Map)this.PNr).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.PNr.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.iCn();
      }
      p.j(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(206684);
        return false;
      }
      localObject = (a)this.PNq.get(Integer.valueOf(paramInt));
      long l = System.currentTimeMillis() / 60000L;
      if (localObject == null) {
        localObject = new a(l);
      }
      for (;;)
      {
        ((Map)this.PNq).put(Integer.valueOf(paramInt), localObject);
        if (((a)localObject).count < i) {
          break;
        }
        AppMethodBeat.o(206684);
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
      Log.i(this.TAG, "isTooFrequent controlByte:" + paramInt + ", count:" + ((a)localObject).count);
    }
    AppMethodBeat.o(206684);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "", "time", "", "count", "", "(JI)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "webview-sdk_release"})
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
      AppMethodBeat.i(206798);
      String str = "JsApiCallInfo(time=" + this.time + ", count=" + this.count + ")";
      AppMethodBeat.o(206798);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.g
 * JD-Core Version:    0.7.0.1
 */