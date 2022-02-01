package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "", "()V", "TAG", "", "callCountMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "Lkotlin/collections/HashMap;", "controlByteMap", "isTooFrequent", "", "controlByte", "reportTooFrequent", "", "funcName", "url", "JsApiCallInfo", "webview-sdk_release"})
public final class e
{
  private final HashMap<Integer, a> Eeu;
  private final HashMap<Integer, Integer> Eev;
  private final String TAG;
  
  public e()
  {
    AppMethodBeat.i(214159);
    this.TAG = "MicroMsg.JsApiFrequentHelper";
    this.Eeu = new HashMap();
    this.Eev = new HashMap();
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qAv, "{\"list\":[{\"limit\":10,\"pos\":14},{\"limit\":10,\"pos\":15}]}");
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
          AppMethodBeat.o(214159);
          throw ((Throwable)localObject1);
        }
      }
      catch (Throwable localThrowable)
      {
        ae.w(this.TAG, "parse fail: ex=" + localThrowable.getMessage());
        AppMethodBeat.o(214159);
        return;
      }
      Object localObject2 = (JSONObject)localObject2;
      ((Map)this.Eev).put(Integer.valueOf(((JSONObject)localObject2).optInt("pos")), Integer.valueOf(((JSONObject)localObject2).optInt("limit")));
      i += 1;
    }
    ae.i(this.TAG, "size=" + this.Eev.size() + ", config=" + localThrowable);
    AppMethodBeat.o(214159);
  }
  
  public final void Q(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(214158);
    p.h(paramString1, "funcName");
    p.h(paramString2, "url");
    if (((Map)this.Eev).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.Eev.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.gkB();
      }
      p.g(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(214158);
        return;
      }
      localObject = (a)this.Eeu.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        if (((a)localObject).count == i) {
          com.tencent.mm.plugin.report.service.g.yxI.f(18188, new Object[] { paramString1, x.aPc(paramString2) });
        }
        AppMethodBeat.o(214158);
        return;
      }
    }
    AppMethodBeat.o(214158);
  }
  
  public final boolean Xk(int paramInt)
  {
    AppMethodBeat.i(214157);
    if (((Map)this.Eev).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.Eev.get(Integer.valueOf(paramInt));
      if (localObject == null) {
        p.gkB();
      }
      p.g(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(214157);
        return false;
      }
      localObject = (a)this.Eeu.get(Integer.valueOf(paramInt));
      long l = System.currentTimeMillis() / 60000L;
      if (localObject == null) {
        localObject = new a(l);
      }
      for (;;)
      {
        ((Map)this.Eeu).put(Integer.valueOf(paramInt), localObject);
        if (((a)localObject).count < i) {
          break;
        }
        AppMethodBeat.o(214157);
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
      ae.i(this.TAG, "isTooFrequent controlByte:" + paramInt + ", count:" + ((a)localObject).count);
    }
    AppMethodBeat.o(214157);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "", "time", "", "count", "", "(JI)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "webview-sdk_release"})
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
      AppMethodBeat.i(214156);
      String str = "JsApiCallInfo(time=" + this.time + ", count=" + this.count + ")";
      AppMethodBeat.o(214156);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.e
 * JD-Core Version:    0.7.0.1
 */