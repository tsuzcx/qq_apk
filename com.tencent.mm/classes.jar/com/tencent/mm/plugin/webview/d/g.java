package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "", "()V", "TAG", "", "callCountMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "Lkotlin/collections/HashMap;", "controlByteMap", "isTooFrequent", "", "controlByte", "reportTooFrequent", "", "funcName", "url", "JsApiCallInfo", "webview-sdk_release"})
public final class g
{
  private final HashMap<Integer, a> IRb;
  private final HashMap<Integer, Integer> IRc;
  private final String TAG;
  
  public g()
  {
    AppMethodBeat.i(225106);
    this.TAG = "MicroMsg.JsApiFrequentHelper";
    this.IRb = new HashMap();
    this.IRc = new HashMap();
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rSI, "{\"list\":[{\"limit\":10,\"pos\":14},{\"limit\":10,\"pos\":15}]}");
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
          AppMethodBeat.o(225106);
          throw ((Throwable)localObject1);
        }
      }
      catch (Throwable localThrowable)
      {
        Log.w(this.TAG, "parse fail: ex=" + localThrowable.getMessage());
        AppMethodBeat.o(225106);
        return;
      }
      Object localObject2 = (JSONObject)localObject2;
      ((Map)this.IRc).put(Integer.valueOf(((JSONObject)localObject2).optInt("pos")), Integer.valueOf(((JSONObject)localObject2).optInt("limit")));
      i += 1;
    }
    Log.i(this.TAG, "size=" + this.IRc.size() + ", config=" + localThrowable);
    AppMethodBeat.o(225106);
  }
  
  public final void S(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(225105);
    p.h(paramString1, "funcName");
    p.h(paramString2, "url");
    if (((Map)this.IRc).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.IRc.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(225105);
        return;
      }
      localObject = (a)this.IRb.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        if (((a)localObject).count == i) {
          h.CyF.a(18188, new Object[] { paramString1, z.bfG(paramString2) });
        }
        AppMethodBeat.o(225105);
        return;
      }
    }
    AppMethodBeat.o(225105);
  }
  
  public final boolean afT(int paramInt)
  {
    AppMethodBeat.i(225104);
    if (((Map)this.IRc).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.IRc.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(225104);
        return false;
      }
      localObject = (a)this.IRb.get(Integer.valueOf(paramInt));
      long l = System.currentTimeMillis() / 60000L;
      if (localObject == null) {
        localObject = new a(l);
      }
      for (;;)
      {
        ((Map)this.IRb).put(Integer.valueOf(paramInt), localObject);
        if (((a)localObject).count < i) {
          break;
        }
        AppMethodBeat.o(225104);
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
    AppMethodBeat.o(225104);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "", "time", "", "count", "", "(JI)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "webview-sdk_release"})
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
      AppMethodBeat.i(225103);
      String str = "JsApiCallInfo(time=" + this.time + ", count=" + this.count + ")";
      AppMethodBeat.o(225103);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.g
 * JD-Core Version:    0.7.0.1
 */