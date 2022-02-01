package com.tencent.mm.plugin.webview.jsapi;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper;", "", "()V", "TAG", "", "callCountMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "Lkotlin/collections/HashMap;", "controlByteMap", "isTooFrequent", "", "controlByte", "reportTooFrequent", "", "funcName", "url", "JsApiCallInfo", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  private final String TAG;
  private final HashMap<Integer, a> WDA;
  private final HashMap<Integer, Integer> WDB;
  
  public i()
  {
    AppMethodBeat.i(295252);
    this.TAG = "MicroMsg.JsApiFrequentHelper";
    this.WDA = new HashMap();
    this.WDB = new HashMap();
    for (;;)
    {
      int k;
      int j;
      try
      {
        Object localObject1 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yMN, "{\"list\":[{\"limit\":10,\"pos\":14},{\"limit\":10,\"pos\":15}]}");
        JSONArray localJSONArray = new JSONObject((String)localObject1).optJSONArray("list");
        if (localJSONArray == null) {
          break label196;
        }
        i = 0;
        k = localJSONArray.length();
        if (k <= 0) {
          break label196;
        }
        j = i + 1;
        localObject3 = localJSONArray.get(i);
        if (localObject3 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
          AppMethodBeat.o(295252);
          throw ((Throwable)localObject1);
        }
      }
      finally
      {
        Log.w(this.TAG, s.X("parse fail: ex=", localObject2.getMessage()));
        AppMethodBeat.o(295252);
        return;
      }
      Object localObject3 = (JSONObject)localObject3;
      ((Map)this.WDB).put(Integer.valueOf(((JSONObject)localObject3).optInt("pos")), Integer.valueOf(((JSONObject)localObject3).optInt("limit")));
      if (j >= k)
      {
        label196:
        Log.i(this.TAG, "size=" + this.WDB.size() + ", config=" + localObject2);
        AppMethodBeat.o(295252);
        return;
      }
      int i = j;
    }
  }
  
  public final void Z(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(295270);
    s.u(paramString1, "funcName");
    s.u(paramString2, "url");
    if (((Map)this.WDB).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.WDB.get(Integer.valueOf(paramInt));
      s.checkNotNull(localObject);
      s.s(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(295270);
        return;
      }
      localObject = (a)this.WDA.get(Integer.valueOf(paramInt));
      if ((localObject != null) && (((a)localObject).count == i)) {
        com.tencent.mm.plugin.report.service.h.OAn.b(18188, new Object[] { paramString1, aa.aUC(paramString2) });
      }
    }
    AppMethodBeat.o(295270);
  }
  
  public final boolean atB(int paramInt)
  {
    AppMethodBeat.i(295259);
    if (((Map)this.WDB).containsKey(Integer.valueOf(paramInt)))
    {
      Object localObject = this.WDB.get(Integer.valueOf(paramInt));
      s.checkNotNull(localObject);
      s.s(localObject, "controlByteMap[controlByte]!!");
      int i = ((Number)localObject).intValue();
      if (i <= 0)
      {
        AppMethodBeat.o(295259);
        return false;
      }
      localObject = (a)this.WDA.get(Integer.valueOf(paramInt));
      long l = System.currentTimeMillis() / 60000L;
      if (localObject == null) {
        localObject = new a(l);
      }
      for (;;)
      {
        ((Map)this.WDA).put(Integer.valueOf(paramInt), localObject);
        if (((a)localObject).count < i) {
          break;
        }
        AppMethodBeat.o(295259);
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
    AppMethodBeat.o(295259);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/JsApiFrequentHelper$JsApiCallInfo;", "", "time", "", "count", "", "(JI)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.time != paramObject.time) {
          return false;
        }
      } while (this.count == paramObject.count);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(295228);
      int i = q.a..ExternalSyntheticBackport0.m(this.time);
      int j = this.count;
      AppMethodBeat.o(295228);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(295218);
      String str = "JsApiCallInfo(time=" + this.time + ", count=" + this.count + ')';
      AppMethodBeat.o(295218);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.i
 * JD-Core Version:    0.7.0.1
 */