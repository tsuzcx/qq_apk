package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.sns.data.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  private static Map<String, Long> JIW;
  
  static
  {
    AppMethodBeat.i(224325);
    JIW = new ConcurrentHashMap();
    AppMethodBeat.o(224325);
  }
  
  public static void a(TextView paramTextView, SnsObject paramSnsObject, ADInfo paramADInfo)
  {
    AppMethodBeat.i(224323);
    if ((paramTextView == null) || (paramSnsObject == null) || (paramADInfo == null))
    {
      AppMethodBeat.o(224323);
      return;
    }
    try
    {
      HashSet localHashSet = m.b(m.b(paramSnsObject), m.c(paramSnsObject));
      if ((paramSnsObject != null) && (!Util.isNullOrNil(paramSnsObject.Username))) {
        localHashSet.remove(paramSnsObject.Username);
      }
      int i = Math.max(localHashSet.size(), paramADInfo.adExtTailWordingExchangeValue);
      paramTextView.setText(String.format(paramADInfo.adExtTailWording, new Object[] { Integer.valueOf(i) }));
      paramTextView.setVisibility(0);
      if (paramADInfo.adExtTailWordingExchangeValue < localHashSet.size()) {
        com.tencent.mm.plugin.report.service.h.IzE.el(1612, 51);
      }
      AppMethodBeat.o(224323);
      return;
    }
    catch (Throwable paramSnsObject)
    {
      paramTextView.setVisibility(8);
      Log.e("DynamicDataReqHelper", paramSnsObject.toString());
      AppMethodBeat.o(224323);
    }
  }
  
  public static void a(String paramString, ADInfo paramADInfo, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(224306);
    if ((paramADInfo == null) || (Util.isNullOrNil(paramString)))
    {
      Log.e("DynamicDataReqHelper", "adInfo or snsId is null, snsId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(224306);
      return;
    }
    if (paramSnsObject == null)
    {
      Log.e("DynamicDataReqHelper", "snsObject is null, snsId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(224306);
      return;
    }
    if (paramADInfo.adChainType != 1)
    {
      Log.i("DynamicDataReqHelper", "adChainType is not 1, snsId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(224306);
      return;
    }
    int i;
    long l2;
    if (paramADInfo.adChainTypeExpireTime == 0)
    {
      i = 60000;
      l2 = System.currentTimeMillis();
      localObject = (Long)JIW.get(paramString);
      if (localObject != null) {
        break label154;
      }
    }
    label154:
    for (long l1 = 0L;; l1 = ((Long)localObject).longValue())
    {
      if (l2 - l1 >= i) {
        break label164;
      }
      AppMethodBeat.o(224306);
      return;
      i = paramADInfo.adChainTypeExpireTime * 1000;
      break;
    }
    label164:
    Object localObject = m.b(paramSnsObject);
    paramSnsObject = m.c(paramSnsObject);
    HashSet localHashSet = m.b((HashSet)localObject, paramSnsObject);
    paramADInfo = new com.tencent.mm.plugin.sns.ad.f.i("", paramADInfo.aid, paramString, paramADInfo.uxInfo, localHashSet.size(), ((HashSet)localObject).size(), paramSnsObject.size());
    com.tencent.mm.kernel.h.aGY().a(4342, new a(paramString));
    com.tencent.mm.kernel.h.aHF().kcd.a(paramADInfo, 0);
    JIW.put(paramString, Long.valueOf(l2));
    com.tencent.mm.plugin.report.service.h.IzE.el(1612, 43);
    AppMethodBeat.o(224306);
  }
  
  public static boolean a(ADInfo paramADInfo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(224314);
    if (paramADInfo == null)
    {
      AppMethodBeat.o(224314);
      return false;
    }
    boolean bool1;
    if ((!Util.isNullOrNil(paramADInfo.adExtTailWording)) && (paramADInfo.adExtTailWordingExchangeValue > 0))
    {
      bool1 = true;
      if (!bool1) {
        break label101;
      }
      bool1 = paramADInfo.adExtTailWording.contains("%d");
      int i = paramADInfo.adExtTailWording.indexOf("%");
      int j = paramADInfo.adExtTailWording.lastIndexOf("%");
      if ((!bool1) || (i != j)) {
        break label96;
      }
      bool1 = bool2;
    }
    label96:
    label101:
    for (;;)
    {
      AppMethodBeat.o(224314);
      return bool1;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  public static boolean a(ADInfo paramADInfo, String paramString)
  {
    AppMethodBeat.i(224294);
    if (((paramADInfo.adActionExtTailType == ADInfo.ADChainStrengthenUserInfoFormatWording) && (!Util.isNullOrNil(paramADInfo.adActionExtTailWording)) && (paramADInfo.adActionExtUserList.size() > 0)) || ((paramADInfo.adActionExtTailType == ADInfo.ADChainStrengthenDefaultWording) && (!Util.isNullOrNil(paramADInfo.adActionExtTailWording))))
    {
      Log.i("DynamicDataReqHelper", "use init adChainData");
      JIW.put(paramString, Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(224294);
      return true;
    }
    AppMethodBeat.o(224294);
    return false;
  }
  
  static final class a
    implements com.tencent.mm.an.i
  {
    private ADInfo JIX;
    private int actionType = 1;
    private String fLp;
    
    private a(int paramInt, String paramString)
    {
      this.fLp = paramString;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
    {
      AppMethodBeat.i(257309);
      if ((paramq instanceof com.tencent.mm.plugin.sns.ad.f.i)) {
        try
        {
          Object localObject = (cde)d.c.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBS);
          StringBuilder localStringBuilder = new StringBuilder("errType = ").append(paramInt1).append(", errCode = ").append(paramInt2).append(", snsId = ").append(this.fLp).append(", rsp.sns_ad_id = ");
          if (localObject == null) {}
          for (paramString = "";; paramString = ((cde)localObject).Tlb)
          {
            Log.i("DynamicDataReqHelper", paramString);
            if ((paramInt1 == 0) && (paramInt2 == 0) && (localObject != null))
            {
              paramInt1 = ((cde)localObject).tpK;
              paramString = ((cde)localObject).Tlb;
              localObject = ((cde)localObject).Tle;
              if ((this.actionType == 1) && (this.actionType == paramInt1)) {
                if ((!Util.isNullOrNil(new String[] { this.fLp, localObject })) && (this.fLp.equals(paramString)))
                {
                  paramString = this.fLp;
                  com.tencent.e.h.ZvG.be(new Runnable()
                  {
                    public final void run()
                    {
                      int j = 1;
                      AppMethodBeat.i(267019);
                      a locala;
                      Object localObject1;
                      try
                      {
                        e.a.a(e.a.this, paramString);
                        if (e.a.a(e.a.this) == null)
                        {
                          Log.e("DynamicDataReqHelper", "adInfo is null, can not update AdInfo, snsId = " + paramString);
                          AppMethodBeat.o(267019);
                          return;
                        }
                        locala = new a();
                        JSONObject localJSONObject = new JSONObject(this.ove);
                        if (localJSONObject.has("WordingComplexString")) {
                          locala.adExtTailWording = localJSONObject.optString("WordingComplexString");
                        }
                        if (localJSONObject.has("WordingComplexExchangeValue")) {
                          locala.adExtTailWordingExchangeValue = localJSONObject.optInt("WordingComplexExchangeValue");
                        }
                        if (localJSONObject.has("WordingLink")) {}
                        for (locala.adActionExtTailLink = localJSONObject.optString("WordingLink");; locala.adActionExtTailLink = null)
                        {
                          if (!localJSONObject.has("WordingType")) {
                            break label630;
                          }
                          locala.adActionExtTailType = localJSONObject.optInt("WordingType");
                          if (locala.adActionExtTailType != ADInfo.ADChainStrengthenUserInfoFormatWording) {
                            break label586;
                          }
                          if (!localJSONObject.has("UserNameList")) {
                            break;
                          }
                          localObject1 = localJSONObject.optJSONArray("UserNameList");
                          locala.adActionExtUserList.clear();
                          i = 0;
                          while (i < ((JSONArray)localObject1).length())
                          {
                            locala.adActionExtUserList.add(((JSONArray)localObject1).optString(i));
                            i += 1;
                          }
                        }
                        locala.adActionExtUserList.clear();
                      }
                      catch (Throwable localThrowable)
                      {
                        Log.e("DynamicDataReqHelper", localThrowable.toString());
                        AppMethodBeat.o(267019);
                        return;
                      }
                      String str1;
                      if (localThrowable.has("WordingRepAndroid"))
                      {
                        str1 = localThrowable.optString("WordingRepAndroid");
                        if (str1.indexOf("%s") < 0) {
                          break label641;
                        }
                      }
                      label641:
                      for (int i = j;; i = 0)
                      {
                        j = str1.indexOf("%");
                        int k = str1.lastIndexOf("%");
                        if ((!Util.isNullOrNil(str1)) && (i != 0) && (j == k)) {
                          locala.adActionExtTailWording = str1;
                        }
                        if (!Util.isNullOrNil(locala.adActionExtTailWording))
                        {
                          localObject1 = locala.adActionExtUserList.iterator();
                          str1 = "";
                        }
                        for (;;)
                        {
                          if (((Iterator)localObject1).hasNext())
                          {
                            String str2 = (String)((Iterator)localObject1).next();
                            Object localObject2 = aj.fOw().bwh(str2);
                            if (localObject2 != null)
                            {
                              localObject2 = ((com.tencent.mm.contact.d)localObject2).ays();
                              if (!Util.isNullOrNil((String)localObject2)) {
                                str1 = str1 + (String)localObject2;
                              }
                            }
                            while (locala.adActionExtUserList.getLast() != str2)
                            {
                              str1 = str1 + ",";
                              break;
                              str1 = str1 + str2;
                              continue;
                              str1 = str1 + str2;
                            }
                          }
                          locala.adActionExtTailUserDisplayName = str1;
                          locala.adActionExtTailFormattedWording = String.format(locala.adActionExtTailWording, new Object[] { str1 });
                          for (;;)
                          {
                            e.a.a(e.a.this, locala);
                            AppMethodBeat.o(267019);
                            return;
                            e.a.a(locala);
                            continue;
                            label586:
                            if ((locala.adActionExtTailType == ADInfo.ADChainStrengthenDefaultWording) && (str1.has("Wording")))
                            {
                              locala.adActionExtTailWording = str1.optString("Wording");
                            }
                            else
                            {
                              e.a.a(locala);
                              continue;
                              label630:
                              e.a.a(locala);
                            }
                          }
                        }
                      }
                    }
                  });
                }
              }
            }
            com.tencent.mm.kernel.h.aGY().b(paramq.getType(), this);
            AppMethodBeat.o(257309);
            return;
          }
          AppMethodBeat.o(257309);
        }
        catch (Throwable paramString)
        {
          Log.e("DynamicDataReqHelper", "NetSceneDynamicAdDataUpdate onSceneEnd exp=" + paramString.toString() + ", snsId = " + this.fLp);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.e
 * JD-Core Version:    0.7.0.1
 */