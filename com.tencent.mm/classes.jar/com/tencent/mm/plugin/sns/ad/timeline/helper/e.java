package com.tencent.mm.plugin.sns.ad.timeline.helper;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.contact.d;
import com.tencent.mm.plugin.sns.data.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  private static Map<String, Long> Qal;
  
  static
  {
    AppMethodBeat.i(311172);
    Qal = new ConcurrentHashMap();
    AppMethodBeat.o(311172);
  }
  
  public static void a(TextView paramTextView, SnsObject paramSnsObject, ADInfo paramADInfo)
  {
    AppMethodBeat.i(311165);
    if ((paramTextView == null) || (paramSnsObject == null) || (paramADInfo == null))
    {
      AppMethodBeat.o(311165);
      return;
    }
    try
    {
      HashSet localHashSet = m.c(m.c(paramSnsObject), m.d(paramSnsObject));
      if ((paramSnsObject != null) && (!Util.isNullOrNil(paramSnsObject.Username))) {
        localHashSet.remove(paramSnsObject.Username);
      }
      int i = Math.max(localHashSet.size(), paramADInfo.adExtTailWordingExchangeValue);
      paramTextView.setText(String.format(paramADInfo.adExtTailWording, new Object[] { Integer.valueOf(i) }));
      paramTextView.setVisibility(0);
      if (paramADInfo.adExtTailWordingExchangeValue < localHashSet.size()) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 51);
      }
      AppMethodBeat.o(311165);
      return;
    }
    finally
    {
      paramTextView.setVisibility(8);
      Log.e("DynamicDataReqHelper", paramSnsObject.toString());
      AppMethodBeat.o(311165);
    }
  }
  
  public static void a(String paramString, ADInfo paramADInfo, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(311149);
    if ((paramADInfo == null) || (Util.isNullOrNil(paramString)))
    {
      Log.e("DynamicDataReqHelper", "adInfo or snsId is null, snsId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(311149);
      return;
    }
    if (paramSnsObject == null)
    {
      Log.e("DynamicDataReqHelper", "snsObject is null, snsId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(311149);
      return;
    }
    if (paramADInfo.adChainType != 1)
    {
      Log.i("DynamicDataReqHelper", "adChainType is not 1, snsId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(311149);
      return;
    }
    int i;
    long l2;
    if (paramADInfo.adChainTypeExpireTime == 0)
    {
      i = 60000;
      l2 = System.currentTimeMillis();
      localObject = (Long)Qal.get(paramString);
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
      AppMethodBeat.o(311149);
      return;
      i = paramADInfo.adChainTypeExpireTime * 1000;
      break;
    }
    label164:
    Object localObject = m.c(paramSnsObject);
    paramSnsObject = m.d(paramSnsObject);
    HashSet localHashSet = m.c((HashSet)localObject, paramSnsObject);
    paramADInfo = new com.tencent.mm.plugin.sns.ad.g.i("", paramADInfo.aid, paramString, paramADInfo.uxInfo, localHashSet.size(), ((HashSet)localObject).size(), paramSnsObject.size());
    com.tencent.mm.kernel.h.aZW().a(4342, new a(paramString));
    com.tencent.mm.kernel.h.baD().mCm.a(paramADInfo, 0);
    Qal.put(paramString, Long.valueOf(l2));
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 43);
    AppMethodBeat.o(311149);
  }
  
  public static boolean a(ADInfo paramADInfo)
  {
    boolean bool2 = true;
    AppMethodBeat.i(311158);
    if (paramADInfo == null)
    {
      AppMethodBeat.o(311158);
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
      AppMethodBeat.o(311158);
      return bool1;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  public static boolean a(ADInfo paramADInfo, String paramString)
  {
    AppMethodBeat.i(311142);
    if (((paramADInfo.adActionExtTailType == ADInfo.ADChainStrengthenUserInfoFormatWording) && (!Util.isNullOrNil(paramADInfo.adActionExtTailWording)) && (paramADInfo.adActionExtUserList.size() > 0)) || ((paramADInfo.adActionExtTailType == ADInfo.ADChainStrengthenDefaultWording) && (!Util.isNullOrNil(paramADInfo.adActionExtTailWording))))
    {
      Log.i("DynamicDataReqHelper", "use init adChainData");
      Qal.put(paramString, Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(311142);
      return true;
    }
    AppMethodBeat.o(311142);
    return false;
  }
  
  static final class a
    implements com.tencent.mm.am.h
  {
    private ADInfo Qam;
    private int actionType = 1;
    private String hQX;
    
    private a(int paramInt, String paramString)
    {
      this.hQX = paramString;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
    {
      AppMethodBeat.i(311104);
      if ((paramp instanceof com.tencent.mm.plugin.sns.ad.g.i)) {
        try
        {
          Object localObject = (csq)c.c.b(((com.tencent.mm.am.c)paramp.getReqResp()).otC);
          StringBuilder localStringBuilder = new StringBuilder("errType = ").append(paramInt1).append(", errCode = ").append(paramInt2).append(", snsId = ").append(this.hQX).append(", rsp.sns_ad_id = ");
          if (localObject == null) {}
          for (paramString = "";; paramString = ((csq)localObject).aayI)
          {
            Log.i("DynamicDataReqHelper", paramString);
            if ((paramInt1 == 0) && (paramInt2 == 0) && (localObject != null))
            {
              paramInt1 = ((csq)localObject).wuj;
              paramString = ((csq)localObject).aayI;
              localObject = ((csq)localObject).aayL;
              if ((this.actionType == 1) && (this.actionType == paramInt1)) {
                if ((!Util.isNullOrNil(new String[] { this.hQX, localObject })) && (this.hQX.equals(paramString)))
                {
                  paramString = this.hQX;
                  com.tencent.threadpool.h.ahAA.bm(new Runnable()
                  {
                    public final void run()
                    {
                      int j = 1;
                      AppMethodBeat.i(311152);
                      a locala;
                      Object localObject2;
                      try
                      {
                        e.a.a(e.a.this, paramString);
                        if (e.a.a(e.a.this) == null)
                        {
                          Log.e("DynamicDataReqHelper", "adInfo is null, can not update AdInfo, snsId = " + paramString);
                          AppMethodBeat.o(311152);
                          return;
                        }
                        locala = new a();
                        JSONObject localJSONObject = new JSONObject(this.ryy);
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
                          localObject2 = localJSONObject.optJSONArray("UserNameList");
                          locala.adActionExtUserList.clear();
                          i = 0;
                          while (i < ((JSONArray)localObject2).length())
                          {
                            locala.adActionExtUserList.add(((JSONArray)localObject2).optString(i));
                            i += 1;
                          }
                        }
                        locala.adActionExtUserList.clear();
                      }
                      finally
                      {
                        Log.e("DynamicDataReqHelper", localObject1.toString());
                        AppMethodBeat.o(311152);
                        return;
                      }
                      String str1;
                      if (localObject1.has("WordingRepAndroid"))
                      {
                        str1 = localObject1.optString("WordingRepAndroid");
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
                          localObject2 = locala.adActionExtUserList.iterator();
                          str1 = "";
                        }
                        for (;;)
                        {
                          if (((Iterator)localObject2).hasNext())
                          {
                            String str2 = (String)((Iterator)localObject2).next();
                            Object localObject3 = al.hgp().bxv(str2);
                            if (localObject3 != null)
                            {
                              localObject3 = ((d)localObject3).aSV();
                              if (!Util.isNullOrNil((String)localObject3)) {
                                str1 = str1 + (String)localObject3;
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
                            AppMethodBeat.o(311152);
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
            com.tencent.mm.kernel.h.aZW().b(paramp.getType(), this);
            AppMethodBeat.o(311104);
            return;
          }
          AppMethodBeat.o(311104);
        }
        finally
        {
          Log.e("DynamicDataReqHelper", "NetSceneDynamicAdDataUpdate onSceneEnd exp=" + paramString.toString() + ", snsId = " + this.hQX);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.e
 * JD-Core Version:    0.7.0.1
 */