package com.tencent.mm.plugin.sns.ad.timeline.b;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  private static Map<String, Long> DyN;
  
  static
  {
    AppMethodBeat.i(202209);
    DyN = new ConcurrentHashMap();
    AppMethodBeat.o(202209);
  }
  
  public static void a(String paramString, ADInfo paramADInfo)
  {
    AppMethodBeat.i(202208);
    if ((paramADInfo == null) || (Util.isNullOrNil(paramString)))
    {
      Log.e("DynamicDataReqHelper", "adInfo or snsId is null, snsId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(202208);
      return;
    }
    if (paramADInfo.adChainType != 1)
    {
      Log.i("DynamicDataReqHelper", "adChainType is not 1, snsId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(202208);
      return;
    }
    int i;
    long l2;
    Long localLong;
    if (paramADInfo.adChainTypeExpireTime == 0)
    {
      i = 60000;
      l2 = System.currentTimeMillis();
      localLong = (Long)DyN.get(paramString);
      if (localLong != null) {
        break label128;
      }
    }
    label128:
    for (long l1 = 0L;; l1 = localLong.longValue())
    {
      if (l2 - l1 >= i) {
        break label137;
      }
      AppMethodBeat.o(202208);
      return;
      i = paramADInfo.adChainTypeExpireTime * 1000;
      break;
    }
    label137:
    paramADInfo = new com.tencent.mm.plugin.sns.ad.g.i("", paramADInfo.aid, paramString, paramADInfo.uxInfo);
    g.azz().a(4342, new a(paramString));
    g.aAg().hqi.a(paramADInfo, 0);
    DyN.put(paramString, Long.valueOf(l2));
    AppMethodBeat.o(202208);
  }
  
  public static boolean a(ADInfo paramADInfo, String paramString)
  {
    AppMethodBeat.i(202207);
    if (((paramADInfo.adActionExtTailType == ADInfo.ADChainStrengthenUserInfoFormatWording) && (!Util.isNullOrNil(paramADInfo.adActionExtTailWording)) && (paramADInfo.adActionExtUserList.size() > 0)) || ((paramADInfo.adActionExtTailType == ADInfo.ADChainStrengthenDefaultWording) && (!Util.isNullOrNil(paramADInfo.adActionExtTailWording))))
    {
      Log.i("DynamicDataReqHelper", "use init adChainData");
      DyN.put(paramString, Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(202207);
      return true;
    }
    AppMethodBeat.o(202207);
    return false;
  }
  
  static final class a
    implements com.tencent.mm.ak.i
  {
    ADInfo DyO;
    private int actionType = 1;
    private String dRS;
    
    private a(int paramInt, String paramString)
    {
      this.dRS = paramString;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
    {
      AppMethodBeat.i(202205);
      if ((paramq instanceof com.tencent.mm.plugin.sns.ad.g.i)) {
        try
        {
          Object localObject = (bvm)((com.tencent.mm.ak.d)paramq.getReqResp()).iLL.iLR;
          StringBuilder localStringBuilder = new StringBuilder("errType = ").append(paramInt1).append(", errCode = ").append(paramInt2).append(", snsId = ").append(this.dRS).append(", rsp.sns_ad_id = ");
          if (localObject == null) {}
          for (paramString = "";; paramString = ((bvm)localObject).MbB)
          {
            Log.i("DynamicDataReqHelper", paramString);
            if ((paramInt1 == 0) && (paramInt2 == 0) && (localObject != null))
            {
              paramInt1 = ((bvm)localObject).pTI;
              paramString = ((bvm)localObject).MbB;
              localObject = ((bvm)localObject).MbC;
              if ((this.actionType == 1) && (this.actionType == paramInt1)) {
                if ((!Util.isNullOrNil(new String[] { this.dRS, localObject })) && (this.dRS.equals(paramString)))
                {
                  paramString = this.dRS;
                  h.RTc.aX(new Runnable()
                  {
                    public final void run()
                    {
                      int j = 1;
                      AppMethodBeat.i(202204);
                      Object localObject2;
                      Object localObject3;
                      try
                      {
                        d.a locala = d.a.this;
                        localObject2 = paramString;
                        long l = r.aOw((String)localObject2);
                        localObject3 = aj.faR().JE(l);
                        if (localObject3 == null) {
                          Log.e("DynamicDataReqHelper", "adInfo can not get from DB due to adsnsinfo is null, longSnsId = " + l + ", snsId = " + (String)localObject2);
                        }
                        while (d.a.this.DyO == null)
                        {
                          Log.e("DynamicDataReqHelper", "adInfo is null, can not update AdInfo, snsId = " + paramString);
                          AppMethodBeat.o(202204);
                          return;
                          locala.DyO = ((AdSnsInfo)localObject3).getAdInfo();
                        }
                        localObject2 = new a();
                      }
                      catch (Throwable localThrowable)
                      {
                        Log.e("DynamicDataReqHelper", localThrowable.toString());
                        AppMethodBeat.o(202204);
                        return;
                      }
                      Object localObject1 = new JSONObject(this.lzO);
                      if (((JSONObject)localObject1).has("WordingLink")) {
                        ((a)localObject2).adActionExtTailLink = ((JSONObject)localObject1).optString("WordingLink");
                      }
                      for (;;)
                      {
                        if (((JSONObject)localObject1).has("WordingType"))
                        {
                          ((a)localObject2).adActionExtTailType = ((JSONObject)localObject1).optInt("WordingType");
                          if (((a)localObject2).adActionExtTailType == ADInfo.ADChainStrengthenUserInfoFormatWording)
                          {
                            if (((JSONObject)localObject1).has("UserNameList"))
                            {
                              localObject3 = ((JSONObject)localObject1).optJSONArray("UserNameList");
                              ((a)localObject2).adActionExtUserList.clear();
                              i = 0;
                              while (i < ((JSONArray)localObject3).length())
                              {
                                ((a)localObject2).adActionExtUserList.add(((JSONArray)localObject3).optString(i));
                                i += 1;
                              }
                              ((a)localObject2).adActionExtTailLink = null;
                              continue;
                            }
                            ((a)localObject2).adActionExtUserList.clear();
                            if (((JSONObject)localObject1).has("WordingRepAndroid"))
                            {
                              localObject1 = ((JSONObject)localObject1).optString("WordingRepAndroid");
                              if (((String)localObject1).indexOf("%s") < 0) {
                                break label697;
                              }
                            }
                          }
                        }
                      }
                      label697:
                      for (int i = j;; i = 0)
                      {
                        j = ((String)localObject1).indexOf("%");
                        int k = ((String)localObject1).lastIndexOf("%");
                        if ((!Util.isNullOrNil((String)localObject1)) && (i != 0) && (j == k)) {
                          ((a)localObject2).adActionExtTailWording = ((String)localObject1);
                        }
                        if (!Util.isNullOrNil(((a)localObject2).adActionExtTailWording))
                        {
                          localObject3 = ((a)localObject2).adActionExtUserList.iterator();
                          localObject1 = "";
                        }
                        for (;;)
                        {
                          if (((Iterator)localObject3).hasNext())
                          {
                            String str = (String)((Iterator)localObject3).next();
                            Object localObject4 = aj.faC().bjK(str);
                            if (localObject4 != null)
                            {
                              localObject4 = ((com.tencent.mm.contact.c)localObject4).arJ();
                              if (!Util.isNullOrNil((String)localObject4)) {
                                localObject1 = (String)localObject1 + (String)localObject4;
                              }
                            }
                            while (((a)localObject2).adActionExtUserList.getLast() != str)
                            {
                              localObject1 = (String)localObject1 + ",";
                              break;
                              localObject1 = (String)localObject1 + str;
                              continue;
                              localObject1 = (String)localObject1 + str;
                            }
                          }
                          ((a)localObject2).adActionExtTailUserDisplayName = ((String)localObject1);
                          ((a)localObject2).adActionExtTailFormattedWording = String.format(((a)localObject2).adActionExtTailWording, new Object[] { localObject1 });
                          for (;;)
                          {
                            localObject1 = d.a.this;
                            if (((d.a)localObject1).DyO != null) {
                              break;
                            }
                            Log.e("DynamicDataReqHelper", "adInfo or adChainData is null");
                            AppMethodBeat.o(202204);
                            return;
                            d.a.a((a)localObject2);
                            continue;
                            if ((((a)localObject2).adActionExtTailType == ADInfo.ADChainStrengthenDefaultWording) && (((JSONObject)localObject1).has("Wording")))
                            {
                              ((a)localObject2).adActionExtTailWording = ((JSONObject)localObject1).optString("Wording");
                            }
                            else
                            {
                              d.a.a((a)localObject2);
                              continue;
                              d.a.a((a)localObject2);
                            }
                          }
                          MMHandlerThread.postToMainThread(new d.a.1((d.a)localObject1, (a)localObject2));
                          AppMethodBeat.o(202204);
                          return;
                        }
                      }
                    }
                  });
                }
              }
            }
            g.azz().b(paramq.getType(), this);
            AppMethodBeat.o(202205);
            return;
          }
          AppMethodBeat.o(202205);
        }
        catch (Throwable paramString)
        {
          Log.e("DynamicDataReqHelper", "NetSceneDynamicAdDataUpdate onSceneEnd exp=" + paramString.toString() + ", snsId = " + this.dRS);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.d
 * JD-Core Version:    0.7.0.1
 */