package com.tencent.mm.plugin.sns.waid;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
{
  public static h aqU(String paramString)
  {
    AppMethodBeat.i(100589);
    try
    {
      ad.i("ad.waid.WaidHelper", "getWaid pkg=".concat(String.valueOf(paramString)));
      paramString = aj.getContext().getContentResolver().query(WaidProvider.xZx, null, null, new String[] { paramString }, null);
      if ((paramString != null) && (paramString.getCount() > 0))
      {
        paramString.moveToFirst();
        h localh = new h();
        localh.dvP = paramString.getString(paramString.getColumnIndex("pkg"));
        localh.xZu = paramString.getString(paramString.getColumnIndex("waid"));
        localh.xZw = paramString.getInt(paramString.getColumnIndex("expire"));
        localh.xZv = paramString.getInt(paramString.getColumnIndex("timeStamp"));
        localh.type = paramString.getInt(paramString.getColumnIndex("type"));
        paramString.close();
        AppMethodBeat.o(100589);
        return localh;
      }
    }
    catch (Exception paramString)
    {
      ad.e("ad.waid.WaidHelper", "getWaid exp=" + paramString.toString());
      AppMethodBeat.o(100589);
    }
    return null;
  }
  
  public static void aqW(String paramString)
  {
    AppMethodBeat.i(100590);
    for (;;)
    {
      int i;
      int j;
      try
      {
        ad.i("ad.waid.WaidHelper", "parseWaidFromAdInfoXML, xml=".concat(String.valueOf(paramString)));
        l = System.currentTimeMillis();
        localMap = bw.K(paramString, "ADInfo");
        localContentValues = new ContentValues();
        localArrayList = new ArrayList();
        localObject2 = ".ADInfo.waid" + ".appWaid";
        paramString = (String)localMap.get((String)localObject2 + ".pkg");
        localObject1 = (String)localMap.get((String)localObject2 + ".id");
        i = bt.aGh((String)localMap.get((String)localObject2 + ".expire"));
        localObject2 = (String)localObject2 + ".maxCount";
        if (localMap.containsKey(localObject2))
        {
          j = bt.aGh((String)localMap.get(localObject2));
          if (j > 0) {
            localContentValues.put("maxAppWaidCount", Integer.valueOf(j));
          }
        }
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (i <= 0)) {
          break label715;
        }
        localObject2 = new h();
        ((h)localObject2).dvP = paramString;
        ((h)localObject2).xZu = ((String)localObject1);
        ((h)localObject2).xZw = i;
        ((h)localObject2).type = 1;
        localArrayList.add(localObject2);
        i = 1;
        localObject2 = ".ADInfo.waid" + ".pubWaid";
        k = bt.aGh((String)localMap.get((String)localObject2 + ".expire"));
        paramString = (String)localObject2 + ".maxCount";
        if (!localMap.containsKey(paramString)) {
          break label720;
        }
        j = bt.aGh((String)localMap.get(paramString));
        if (j <= 0) {
          break label720;
        }
        localContentValues.put("maxPubWaidCount", Integer.valueOf(j));
      }
      catch (Throwable paramString)
      {
        long l;
        Map localMap;
        ContentValues localContentValues;
        ArrayList localArrayList;
        Object localObject2;
        Object localObject1;
        int k;
        ad.e("ad.waid.WaidHelper", "parseWaidFromAdInfoXML exp=" + paramString.toString());
        AppMethodBeat.o(100590);
        return;
      }
      localObject1 = (String)localObject2 + ".id";
      paramString = (String)localObject1;
      if (j > 0) {
        paramString = (String)localObject1 + j;
      }
      paramString = (String)localMap.get(paramString);
      if ((!TextUtils.isEmpty(paramString)) && (k > 0))
      {
        localObject1 = new h();
        ((h)localObject1).dvP = "";
        ((h)localObject1).xZu = paramString;
        ((h)localObject1).xZw = k;
        ((h)localObject1).type = 2;
        localArrayList.add(localObject1);
        i += 1;
        j += 1;
      }
      else
      {
        paramString = (String)localObject2 + ".pubWaidSwitch";
        if (localMap.containsKey(paramString)) {
          localContentValues.put("pubWaidSwitch", Integer.valueOf(bt.aGh((String)localMap.get(paramString))));
        }
        if (localContentValues.size() > 0)
        {
          ad.i("ad.waid.WaidHelper", "parseWaidFromAdInfoXML, insert cfg");
          aj.getContext().getContentResolver().insert(WaidProvider.xZy, localContentValues);
        }
        if (!localArrayList.isEmpty()) {
          ar(localArrayList);
        }
        ad.i("ad.waid.WaidHelper", "parseWaidFromAdInfoXML, timeCost=" + (System.currentTimeMillis() - l) + ", count=" + i);
        AppMethodBeat.o(100590);
        return;
        label715:
        i = 0;
        continue;
        label720:
        j = 0;
      }
    }
  }
  
  public static int aqX(String paramString)
  {
    k = 1;
    n = 0;
    AppMethodBeat.i(100591);
    try
    {
      ad.i("ad.waid.WaidHelper", "parseWaidFromJsApi, data=".concat(String.valueOf(paramString)));
      l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localContentValues = new ContentValues();
      paramString = new JSONObject(paramString);
      localObject1 = paramString.optJSONObject("appWaid");
      paramString = paramString.optJSONObject("pubWaid");
      if (localObject1 == null) {
        break label567;
      }
      str = ((JSONObject)localObject1).optString("pkg");
      localObject2 = ((JSONObject)localObject1).optString("id");
      i = ((JSONObject)localObject1).optInt("expire");
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (i <= 0)) {
        break label562;
      }
      h localh = new h();
      localh.dvP = str;
      localh.xZu = ((String)localObject2);
      localh.xZw = i;
      localh.type = 1;
      localArrayList.add(localh);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int m;
        try
        {
          long l;
          ArrayList localArrayList;
          ContentValues localContentValues;
          Object localObject1;
          String str;
          Object localObject2;
          if (((JSONObject)localObject1).has("maxCount"))
          {
            i = k;
            m = ((JSONObject)localObject1).optInt("maxCount");
            j = k;
            if (m > 0)
            {
              i = k;
              localContentValues.put("maxAppWaidCount", Integer.valueOf(m));
              j = k;
            }
          }
          m = j;
          if (paramString != null)
          {
            i = j;
            int i1 = paramString.optInt("expire");
            i = j;
            localObject1 = paramString.optJSONArray("ids");
            k = j;
            if (localObject1 != null)
            {
              k = j;
              if (i1 > 0)
              {
                i = j;
                int i2 = ((JSONArray)localObject1).length();
                m = n;
                k = j;
                if (m < i2)
                {
                  i = j;
                  str = ((JSONArray)localObject1).getString(m);
                  i = j;
                  k = j;
                  if (TextUtils.isEmpty(str)) {
                    break label572;
                  }
                  i = j;
                  localObject2 = new h();
                  i = j;
                  ((h)localObject2).dvP = "";
                  i = j;
                  ((h)localObject2).xZu = str;
                  i = j;
                  ((h)localObject2).xZw = i1;
                  i = j;
                  ((h)localObject2).type = 2;
                  i = j;
                  localArrayList.add(localObject2);
                  k = j + 1;
                  break label572;
                }
              }
            }
            m = k;
            i = k;
            if (paramString.has("maxCount"))
            {
              i = k;
              j = paramString.optInt("maxCount");
              m = k;
              if (j > 0)
              {
                i = k;
                localContentValues.put("maxPubWaidCount", Integer.valueOf(j));
                m = k;
              }
            }
          }
          i = m;
          if (!localArrayList.isEmpty())
          {
            i = m;
            ar(localArrayList);
          }
          i = m;
          if (localContentValues.size() > 0)
          {
            i = m;
            ad.i("ad.waid.WaidHelper", "parseWaidFromJsApi, insert cfg");
            i = m;
            aj.getContext().getContentResolver().insert(WaidProvider.xZy, localContentValues);
          }
          i = m;
          ad.i("ad.waid.WaidHelper", "parseWaidFromJsApi, timeCost=" + (System.currentTimeMillis() - l) + ", count=" + m);
          i = m;
          AppMethodBeat.o(100591);
          return i;
        }
        catch (Exception paramString)
        {
          int i;
          continue;
        }
        paramString = paramString;
        i = 0;
        ad.e("ad.waid.WaidHelper", "parseWaidFromJsApi, exp=" + paramString.toString());
        continue;
        k = 0;
        continue;
        int j = 0;
        continue;
        m += 1;
        j = k;
      }
    }
    j = k;
    i = k;
  }
  
  private static boolean ar(ArrayList<h> paramArrayList)
  {
    AppMethodBeat.i(100588);
    try
    {
      boolean bool = paramArrayList.isEmpty();
      if (bool)
      {
        AppMethodBeat.o(100588);
        return false;
      }
      localObject1 = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = ((h)paramArrayList.next()).toJson();
        if (localObject2 != null) {
          ((JSONArray)localObject1).put(localObject2);
        }
      }
      while (((JSONArray)localObject1).length() <= 0) {}
    }
    catch (Exception paramArrayList)
    {
      ad.e("ad.waid.WaidHelper", "batchInsertWaid exp=" + paramArrayList.toString());
      AppMethodBeat.o(100588);
      return false;
    }
    paramArrayList = aj.getContext().getContentResolver();
    Object localObject2 = new ContentValues();
    Object localObject1 = ((JSONArray)localObject1).toString();
    ad.i("ad.waid.WaidHelper", "batchInsertWaid, data=".concat(String.valueOf(localObject1)));
    ((ContentValues)localObject2).put("waid_array", (String)localObject1);
    if (paramArrayList.insert(WaidProvider.xZx, (ContentValues)localObject2) != null)
    {
      AppMethodBeat.o(100588);
      return true;
    }
    AppMethodBeat.o(100588);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.g
 * JD-Core Version:    0.7.0.1
 */